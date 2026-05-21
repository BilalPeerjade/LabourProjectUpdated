package attendence;

import com.registers.helper.WeekOffApiUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class AttendanceValidationEngine {

    // =======================================================================================
    // 🔹 CONFIGURATION KEYWORDS
    // =======================================================================================
    private static final List<String> VALID_DOJ_KEYWORDS = Arrays.asList("DOJ", "DDOJ", "NEW_JOIN");
    private static final List<String> VALID_DOL_KEYWORDS = Arrays.asList("DOL", "DDOL", "LEFT", "RESIGNED");
    
    // API Caches to avoid redundant calls
    private static final Map<String, Map<String, String>> apiDojCache = new HashMap<>();
    private static final Map<String, Map<String, String>> apiDolCache = new HashMap<>();


    // =======================================================================================
    // 🟢 1. FULL MONTH DOJ VALIDATION (Nested Extent Reports)
    // =======================================================================================
    public static void validateFullMonthDOJ(
            ExtentReports extent, 
            String clientId,
            int month,
            int year,
            String masterFilePath,
            File downloadedFile
    ) {
        int maxDays = YearMonth.of(year, month).lengthOfMonth();
        
        // Fetch DOJ Data
        String cacheKey = clientId + "_" + month + "_" + year;
        Map<String, String> apiDojMap;
        if (apiDojCache.containsKey(cacheKey)) {
            apiDojMap = apiDojCache.get(cacheKey);
        } else {
            String apiResponse = WeekOffApiUtil.getWeekOffData(clientId, month, year, false);
            apiDojMap = extractDataFromAPI(apiResponse, "doj");
            apiDojCache.put(cacheKey, apiDojMap);
        }

        if (apiDojMap.isEmpty()) {
            System.err.println("⚠️ DOJ API returned no data. Check logs.");
            return;
        }

        // Loop 1 to MaxDays and create Nested Tests
        for (int d = 1; d <= maxDays; d++) {
            ExtentTest dayTest = extent.startTest("DOJ Validation: Day " + d);
            processSingleDay(dayTest, d, month, year, apiDojMap, masterFilePath, downloadedFile, "DOJ");
            extent.endTest(dayTest);
        }
    }


    // =======================================================================================
    // 🔴 2. FULL MONTH DOL VALIDATION (Nested Extent Reports)
    // =======================================================================================
    public static void validateFullMonthDOL(
            ExtentReports extent, 
            String clientId,
            int month,
            int year,
            String masterFilePath,
            File downloadedFile
    ) {
        int maxDays = YearMonth.of(year, month).lengthOfMonth();
        
        // Fetch DOL Data
        String cacheKey = clientId + "_" + month + "_" + year;
        Map<String, String> apiDolMap;
        if (apiDolCache.containsKey(cacheKey)) {
            apiDolMap = apiDolCache.get(cacheKey);
        } else {
            String apiResponse = WeekOffApiUtil.getWeekOffData(clientId, month, year, false);
            apiDolMap = extractDataFromAPI(apiResponse, "dol");
            apiDolCache.put(cacheKey, apiDolMap);
        }

        if (apiDolMap.isEmpty()) {
            System.err.println("⚠️ DOL API returned no data. Check logs.");
            return;
        }

        // Loop 1 to MaxDays and create Nested Tests
        for (int d = 1; d <= maxDays; d++) {
            ExtentTest dayTest = extent.startTest("DOL Validation: Day " + d);
            processSingleDay(dayTest, d, month, year, apiDolMap, masterFilePath, downloadedFile, "DOL");
            extent.endTest(dayTest);
        }
    }


    // =======================================================================================
    // ⚙️ 3. CORE PROCESSING LOGIC FOR A SINGLE DAY (Handles both DOJ & DOL)
    // =======================================================================================
    private static void processSingleDay(ExtentTest dayTest, int day, int month, int year, Map<String, String> apiDataMap, String masterPath, File downloadFile, String type) {
        
        Map<String, String> masterData = getExcelDataForDay(new File(masterPath), 0, day);
        LinkedHashMap<String, String> downloadData = getExcelDataForDay(downloadFile, 0, day);

        if (masterData.isEmpty() || downloadData.isEmpty()) {
            dayTest.log(LogStatus.SKIP, "ℹ️ No data found in Excel files for Day " + day);
            return;
        }

        HtmlReportBuilder reportBuilder = new HtmlReportBuilder(day, type);
        reportBuilder.buildTitle();
        reportBuilder.buildHeaders();

        int passCount = 0, failCount = 0;
        boolean anyFail = false;
        LocalDate procDate = LocalDate.of(year, month, day);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (String empId : downloadData.keySet()) {
            if (!masterData.containsKey(empId)) continue; // Intersection only

            String dateStr = apiDataMap.get(empId);
            if (dateStr == null || dateStr.equalsIgnoreCase("null")) continue;

            LocalDate targetDate;
            try {
                targetDate = LocalDate.parse(dateStr, dtf);
            } catch (Exception e) {
                dayTest.log(LogStatus.WARNING, "❌ Invalid " + type + " format for EMP: " + empId + " -> " + dateStr);
                continue;
            }

            // --- APPLICABILITY LOGIC ---
            boolean isApplicable;
            List<String> validKeywords;
            
            if (type.equals("DOJ")) {
                isApplicable = procDate.isBefore(targetDate);
                validKeywords = VALID_DOJ_KEYWORDS;
            } else { // DOL
                isApplicable = procDate.isAfter(targetDate);
                validKeywords = VALID_DOL_KEYWORDS;
            }

            String masterVal = masterData.get(empId).toUpperCase();
            String actualVal = downloadData.get(empId).toUpperCase();
            String status = "PASS";

            if (isApplicable) {
                if (!validKeywords.contains(actualVal)) { status = "FAIL"; anyFail = true; }
            } else {
                if (validKeywords.contains(actualVal)) { status = "FAIL"; anyFail = true; }
            }

            if (status.equals("PASS")) passCount++; else failCount++;
            reportBuilder.buildRow(empId, dateStr, masterVal, actualVal, isApplicable, status);
        }

        reportBuilder.buildClosure();
        
        LogStatus finalStatus = anyFail ? LogStatus.FAIL : LogStatus.PASS;
        
        dayTest.log(finalStatus, "<b>" + type + " Summary:</b> Checked: " + (passCount + failCount) + " | <span style='color:green;'>Passed: " + passCount + "</span> | <span style='color:red;'>Failed: " + failCount + "</span>");
       
        //dayTest.log(finalStatus, reportBuilder.getHtmlReport());
        
    }


    // =======================================================================================
    // 🛠️ HELPER METHODS (API & EXCEL)
    // =======================================================================================
    private static Map<String, String> extractDataFromAPI(String json, String targetKey) {
        Map<String, String> map = new HashMap<>();
        try {
            JSONArray arr = new JSONArray(json);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                if (obj.has(targetKey) && !obj.isNull(targetKey)) {
                    map.put(obj.getString("eM_EmpID").trim(), obj.getString(targetKey).trim());
                }
            }
        } catch (Exception e) {}
        return map;
    }

    private static LinkedHashMap<String, String> getExcelDataForDay(File f, int empCol, int day) {
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        if (!f.exists()) return data;

        try (FileInputStream fis = new FileInputStream(f); Workbook wb = WorkbookFactory.create(fis)) {
            Sheet s = wb.getSheetAt(0);
            for (Row r : s) {
                if (r.getRowNum() == 0) continue;
                Cell cE = r.getCell(empCol);
                Cell cD = r.getCell(day); 
                if (cE != null && cD != null) data.put(getVal(cE), getVal(cD));
            }
        } catch (Exception e) {}
        return data;
    }

    private static String getVal(Cell c) {
        if (c == null) return "";
        if (c.getCellType() == CellType.NUMERIC) return String.valueOf((int) c.getNumericCellValue());
        return c.getStringCellValue().trim();
    }


    // =======================================================================================
    // 📊 MINI CLASS: HTML REPORT BUILDER
    // =======================================================================================
    private static class HtmlReportBuilder {
        private static final int MAX_ROWS = 5;
        private final int day;
        private final String type;
        private int count = 0;
        private final StringBuilder sb = new StringBuilder();

        public HtmlReportBuilder(int day, String type) { 
            this.day = day; 
            this.type = type;
        }

        public void buildTitle() {
            sb.append("<h4 style='color:#2c3e50; text-align:left; margin-bottom:12px; font-family: Arial;'>📊 ").append(type).append(" Validation Report (Day ").append(day).append(")</h4>");
            sb.append("<table style='width:100%; border-collapse: collapse; font-family: Arial; font-size: 12px; text-align:center;'>");
        }

        public void buildHeaders() {
            sb.append("<tr style='background-color:#f4f6f9; color:#333; border-bottom: 2px solid #ddd;'>")
                .append("<th style='padding:10px; border:1px solid #ddd; width:30%; font-weight:bold;'>EMP ID</th>")
                .append("<th style='padding:10px; border:1px solid #ddd; width:15%; font-weight:bold;'>").append(type).append("</th>")
                .append("<th style='padding:10px; border:1px solid #ddd; width:12%; font-weight:bold;'>M-F</th>")
                .append("<th style='padding:10px; border:1px solid #ddd; width:12%; font-weight:bold;'>D-F</th>")
                .append("<th style='padding:10px; border:1px solid #ddd; width:15%; font-weight:bold;'>Applicable</th>")
                .append("<th style='padding:10px; border:1px solid #ddd; width:16%; font-weight:bold;'>Status</th>")
                .append("</tr>");
        }

        public void buildRow(String id, String targetDate, String mf, String df, boolean app, String st) {
            if (count >= MAX_ROWS) return;
            String color = st.equals("PASS") ? "#28a745" : "#dc3545";
            sb.append("<tr style='border-bottom: 1px solid #ddd;'>")
                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(id).append("</td>")
                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(targetDate).append("</td>")
                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(mf).append("</td>")
                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(df).append("</td>")
                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(app ? "YES" : "NO").append("</td>")
                .append("<td style='padding:8px; border:1px solid #ddd;'>")
                .append("<span style='background-color:").append(color).append("; color:white; padding:3px 10px; border-radius:12px; font-weight:bold; font-size:11px;'>")
                .append(st).append("</span></td></tr>");
            count++;
        }

        public void buildClosure() {
            sb.append("</table>");
            if (count >= MAX_ROWS) sb.append("<div style='text-align:left; font-size:10px; color:#999; margin-top:4px;'><i>* Showing first 5 samples only</i></div>");
        }

        public String getHtmlReport() { return sb.toString(); }
    }
}