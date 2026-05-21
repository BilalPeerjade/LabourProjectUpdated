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

public class DOJValidationUtil4 {

    private static final List<String> VALID_DOJ_KEYWORDS = Arrays.asList("DOJ", "DDOJ", "NEW_JOIN");
    private static final Map<String, Map<String, String>> apiDojCache = new HashMap<>();

    /**
     * Specific Call Validation: Starts a NEW Test ONLY for the provided columns/days
     */
    public static void validateSpecificDaysDOJ(
            ExtentReports extent,
            String clientId,
            int month,
            int year,
            String masterFilePath,
            File downloadedFile,
            List<Integer> targetDays // NAYA PARAMETER: Yaha wo columns aayenge jo tumhe run karne hain
    ) {
        // Get Max Days in Month for validation
        int maxDays = YearMonth.of(year, month).lengthOfMonth();
        
        // 1️⃣ Fetch API Data once (Cache handled internally)
        String cacheKey = clientId + "_" + month + "_" + year;
        Map<String, String> apiDojMap;
        if (apiDojCache.containsKey(cacheKey)) {
            apiDojMap = apiDojCache.get(cacheKey);
        } else {
            String apiResponse = WeekOffApiUtil.getWeekOffData(clientId, month, year, false);
            apiDojMap = extractDOJFromAPI(apiResponse);
            apiDojCache.put(cacheKey, apiDojMap);
        }

        if (apiDojMap.isEmpty()) {
            System.err.println("⚠️ API returned no DOJ data. Check logs.");
            return;
        }

        // 2️⃣ Loop ONLY through the specified days/columns
        for (int d : targetDays) {
            // Basic validation: Check if column/day is valid for that month
            if (d < 1 || d > maxDays) {
                System.err.println("⚠️ Skipping invalid column/day: " + d);
                continue;
            }

            // This creates a new entry in ExtentReport left panel
            ExtentTest dayTest = extent.startTest("DOJ checking day " + d);
            
            processSingleDayDOJ(dayTest, d, month, year, apiDojMap, masterFilePath, downloadedFile);
            
            //End the test for this day
            extent.endTest(dayTest);
        }
    }

    private static void processSingleDayDOJ(ExtentTest dayTest, int day, int month, int year, Map<String, String> apiDojMap, String masterPath, File downloadFile) {
        
        // Read data for this specific day
        Map<String, String> masterData = getExcelDataForDay(new File(masterPath), 0, day);
        LinkedHashMap<String, String> downloadData = getExcelDataForDay(downloadFile, 0, day);

        if (masterData.isEmpty() || downloadData.isEmpty()) {
            dayTest.log(LogStatus.SKIP, "ℹ️ No data found in files for Day " + day);
            return;
        }

        DOJHtmlReportBuilder reportBuilder = new DOJHtmlReportBuilder(day);
        reportBuilder.buildTitle();
        reportBuilder.buildHeaders();

        int passCount = 0, failCount = 0;
        boolean anyFail = false;
        LocalDate procDate = LocalDate.of(year, month, day);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (String empId : downloadData.keySet()) {
            if (!masterData.containsKey(empId)) continue;

            String dojStr = apiDojMap.get(empId);
            if (dojStr == null || dojStr.equalsIgnoreCase("null")) continue;

            LocalDate dojDate = LocalDate.parse(dojStr, dtf);
            boolean isApplicable = procDate.isBefore(dojDate);
            String masterVal = masterData.get(empId).toUpperCase();
            String actualVal = downloadData.get(empId).toUpperCase();
            String status = "PASS";

            // Logic: Before DOJ -> Must be DOJ keyword | After DOJ -> Must NOT be DOJ keyword
            if (isApplicable) {
                if (!VALID_DOJ_KEYWORDS.contains(actualVal)) { status = "FAIL"; anyFail = true; }
            } else {
                if (VALID_DOJ_KEYWORDS.contains(actualVal)) { status = "FAIL"; anyFail = true; }
            }

            if (status.equals("PASS")) passCount++; else failCount++;
            reportBuilder.buildRow(empId, dojStr, masterVal, actualVal, isApplicable, status);
        }

        reportBuilder.buildClosure();
        
        //Log Table and Summary
        LogStatus finalStatus = anyFail ? LogStatus.FAIL : LogStatus.PASS;
        if(true) {
        	dayTest.log(finalStatus, reportBuilder.getHtmlReport());
        }
        dayTest.log(finalStatus, "<b>DOJ Summary:</b> Checked: " + (passCount + failCount) + " | Passed: " + passCount + " | Failed: " + failCount);
    }

    //Helpers
    private static Map<String, String> extractDOJFromAPI(String json) {
        Map<String, String> map = new HashMap<>();
        try {
            JSONArray arr = new JSONArray(json);
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                if (obj.has("doj") && !obj.isNull("doj")) map.put(obj.getString("eM_EmpID").trim(), obj.getString("doj").trim());
            }
        } catch (Exception e) {}
        return map;
    }

    private static LinkedHashMap<String, String> getExcelDataForDay(File f, int empCol, int day) {
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
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
    
    
    
    
    
    
    
    private static class DOJHtmlReportBuilder {
        private static final int MAX_ROWS = 5;
        private final int day;
        private int count = 0;
        private final StringBuilder sb = new StringBuilder();

        public DOJHtmlReportBuilder(int day) { this.day = day; }

        public void buildTitle() {
            sb.append("<br><table style='width:100%; border-collapse: collapse; font-family: Arial; font-size: 12px; text-align:center;'>");
        }

        public void buildHeaders() {
            sb.append("<tr style='background-color:#f4f6f9; color:#333; border-bottom: 2px solid #ddd;'>")
                .append("<th style='padding:10px; border:1px solid #ddd; width:30%; font-weight:bold;'>EMP ID</th>")
                .append("<th style='padding:10px; border:1px solid #ddd; width:15%; font-weight:bold;'>DOJ</th>")
                .append("<th style='padding:10px; border:1px solid #ddd; width:12%; font-weight:bold;'>M-F</th>")
                .append("<th style='padding:10px; border:1px solid #ddd; width:12%; font-weight:bold;'>D-F</th>")
                .append("<th style='padding:10px; border:1px solid #ddd; width:15%; font-weight:bold;'>Applicable</th>")
                .append("<th style='padding:10px; border:1px solid #ddd; width:16%; font-weight:bold;'>Status</th>")
                .append("</tr>");
        }

        public void buildRow(String id, String doj, String mf, String df, boolean app, String st) {
            if (count >= MAX_ROWS) return;
            sb.append("<tr style='border-bottom: 1px solid #ddd;'>")
                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(id).append("</td>")
                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(doj).append("</td>")
                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(mf).append("</td>")
                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(df).append("</td>")
                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(app ? "YES" : "NO").append("</td>")
                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(st).append("</td></tr>");
            count++;
        }

        public void buildClosure() {
            sb.append("</table>");
        }

        public String getHtmlReport() { return sb.toString(); }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//    private static class DOJHtmlReportBuilder {
//        private static final int MAX_ROWS = 5;
//        private final int day;
//        private int count = 0;
//        private final StringBuilder sb = new StringBuilder();
//
//        public DOJHtmlReportBuilder(int day) { this.day = day; }
//
//        public void buildTitle() {
//            // UI Same: Raw borders, no CSS
//            sb.append("<br><table border='4' width='85%' cellpadding='1' cellspacing='2'>");
//        }
//
//        public void buildHeaders() {
//            // UI Same: Basic background color, no fancy styling
//            sb.append("<tr bgcolor='#d3d3d3'>")
//                .append("<th>EMP ID</th>")
//                .append("<th>DOJ</th>")
//                .append("<th>M-F</th>")
//                .append("<th>D-F</th>")
//                .append("<th>Applicable</th>")
//                .append("<th>Status</th>")
//                .append("</tr>");
//        }
//
//        public void buildRow(String id, String doj, String mf, String df, boolean app, String st) {
//            if (count >= MAX_ROWS) return;
//            sb.append("<tr>")
//                
//                .append("<td>").append(id).append("</td>")
//                
//                .append("<td>").append(doj).append("</td>")
//                
//                .append("<td>").append(mf).append("</td>")
//                
//                .append("<td>").append(df).append("</td>")
//                
//                .append("<td>").append(app ? "YES" : "NO").append("</td>")
//                
//                .append("<td>").append(st).append("</td></tr>");
//            count++;
//        }
//
//        public void buildClosure() {
//            sb.append("</table>");
//        }
//
//        public String getHtmlReport() { return sb.toString(); }
//    }
    
    
    
    
    
    
    
    
    
    
    
//  private static class DOJHtmlReportBuilder {
//  private static final int MAX_ROWS = 5;
//  private final int day;
//  private int count = 0;
//  private final StringBuilder sb = new StringBuilder();
//
//  public DOJHtmlReportBuilder(int day) { this.day = day; }
//
//  public void buildTitle() {
//      sb.append("<br><table border='4' width='85%' cellpadding='1' cellspacing='2'>");
//  }
//
//  public void buildHeaders() {
//      sb.append("<tr bgcolor='#d3d3d3'>")
//          .append("<th>EMP ID</th>")
//          .append("<th>DOJ</th>")
//          .append("<th>M-F</th>")
//          .append("<th>D-F</th>")
//          .append("<th>Applicable</th>")
//          .append("<th>Status</th>")
//          .append("</tr>");
//  }
//
//  public void buildRow(String id, String doj, String mf, String df, boolean app, String st) {
//      if (count >= MAX_ROWS) return;
//      sb.append("<tr>")
//          
//          .append("<td>").append(id).append("</td>")
//          
//          .append("<td>").append(doj).append("</td>")
//          
//          .append("<td></td>")
//          
//          .append("<td></td>")
//          
//          .append("<td>").append(app ? "YES" : "NO").append("</td>")
//          
//          .append("<td></td></tr>");
//      count++;
//  }
//
//  public void buildClosure() {
//      sb.append("</table>");
//  }
//
//  public String getHtmlReport() { return sb.toString(); }
//}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

//    private static class DOJHtmlReportBuilder {
//        private static final int MAX_ROWS = 5;
//        private final int day;
//        private int count = 0;
//        private final StringBuilder sb = new StringBuilder();
//
//        public DOJHtmlReportBuilder(int day) { this.day = day; }
//
//        public void buildTitle() {
//            sb.append("<br><table style='width:100%; border-collapse: collapse; font-family: Arial; font-size: 12px; text-align:center;'>");
//        }
//
//        public void buildHeaders() {
//            sb.append("<tr style='background-color:#f4f6f9; color:#333; border-bottom: 2px solid #ddd;'>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:30%; font-weight:bold;'>EMP ID</th>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:15%; font-weight:bold;'>DOJ</th>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:12%; font-weight:bold;'>M-F</th>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:12%; font-weight:bold;'>D-F</th>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:15%; font-weight:bold;'>Applicable</th>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:16%; font-weight:bold;'>Status</th>")
//                .append("</tr>");
//        }
//
//        public void buildRow(String id, String doj, String mf, String df, boolean app, String st) {
//            if (count >= MAX_ROWS) return;
//            sb.append("<tr style='border-bottom: 1px solid #ddd;'>")
//                .append("<td style='padding:8px; border:1px solid #ddd;'></td>")
//                .append("<td style='padding:8px; border:1px solid #ddd;'></td>")
//                .append("<td style='padding:8px; border:1px solid #ddd;'></td>")
//                .append("<td style='padding:8px; border:1px solid #ddd;'></td>")
//                .append("<td style='padding:8px; border:1px solid #ddd;'></td>")
//                .append("<td style='padding:8px; border:1px solid #ddd;'></td></tr>");
//            count++;
//        }
//
//        public void buildClosure() {
//            sb.append("</table>");
//        }
//
//        public String getHtmlReport() { return sb.toString(); }
//    }
    
    
    
    
    
    
    
    
    
    
    

//    private static class DOJHtmlReportBuilder {
//        private static final int MAX_ROWS = 5;
//        private final int day;
//        private int count = 0;
//        private final StringBuilder sb = new StringBuilder();
//
//        public DOJHtmlReportBuilder(int day) { this.day = day; }
//
//        public void buildTitle() {
//            // No title, just raw table initialization
//            sb.append("<br><table style='width:100%; border-collapse: collapse; font-family: Arial; font-size: 12px; text-align:center;'>");
//        }
//
//        public void buildHeaders() {
//            // Only EMP ID and M-F have text, rest are empty headers
//            sb.append("<tr style='background-color:#f4f6f9; color:#333; border-bottom: 2px solid #ddd;'>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:30%; font-weight:bold;'>EMP ID</th>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:15%; font-weight:bold;'></th>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:12%; font-weight:bold;'>M-F</th>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:12%; font-weight:bold;'></th>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:15%; font-weight:bold;'></th>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:16%; font-weight:bold;'></th>")
//                .append("</tr>");
//        }
//
//        public void buildRow(String id, String doj, String mf, String df, boolean app, String st) {
//            // Day 1 me data print nahi karna hai, so this remains intentionally blank
//        }
//
//        public void buildClosure() {
//            // Creating dummy empty rows just to show the grid/structure to management
//            for(int i = 0; i < 3; i++) {
//                sb.append("<tr style='border-bottom: 1px solid #ddd;'>")
//                  .append("<td style='padding:12px; border:1px solid #ddd;'></td>")
//                  .append("<td style='padding:12px; border:1px solid #ddd;'></td>")
//                  .append("<td style='padding:12px; border:1px solid #ddd;'></td>")
//                  .append("<td style='padding:12px; border:1px solid #ddd;'></td>")
//                  .append("<td style='padding:12px; border:1px solid #ddd;'></td>")
//                  .append("<td style='padding:12px; border:1px solid #ddd;'></td>")
//                  .append("</tr>");
//            }
//            sb.append("</table>");
//        }
//
//        public String getHtmlReport() { return sb.toString(); }
//    }
    
    
    
    
    
    
    
    
    
    

//    // =======================================================================================
//    // CLASS: HTML REPORT BUILDER
//    // =======================================================================================
//    private static class DOJHtmlReportBuilder {
//        private static final int MAX_ROWS = 5;
//        private final int day;
//        private int count = 0;
//        private final StringBuilder sb = new StringBuilder();
//
//        public DOJHtmlReportBuilder(int day) { this.day = day; }
//
//        public void buildTitle() {
//            // Title Left Aligned
//            sb.append("<h4 style='color:#2c3e50; text-align:left; margin-bottom:12px; font-family: Arial;'>📊 DOJ Validation Report (Day ").append(day).append(")</h4>");
//            sb.append("<table style='width:100%; border-collapse: collapse; font-family: Arial; font-size: 12px; text-align:center;'>");
//        }
//
//        public void buildHeaders() {
//            sb.append("<tr style='background-color:#f4f6f9; color:#333; border-bottom: 2px solid #ddd;'>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:30%; font-weight:bold;'>EMP ID</th>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:15%; font-weight:bold;'>DOJ</th>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:12%; font-weight:bold;'>M-F</th>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:12%; font-weight:bold;'>D-F</th>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:15%; font-weight:bold;'>Applicable</th>")
//                .append("<th style='padding:10px; border:1px solid #ddd; width:16%; font-weight:bold;'>Status</th>")
//                .append("</tr>");
//        }
//
//        public void buildRow(String id, String doj, String mf, String df, boolean app, String st) {
//            if (count >= MAX_ROWS) return;
//            String color = st.equals("PASS") ? "#28a745" : "#dc3545";
//            sb.append("<tr style='border-bottom: 1px solid #ddd;'>")
//                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(id).append("</td>")
//                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(doj).append("</td>")
//                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(mf).append("</td>")
//                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(df).append("</td>")
//                .append("<td style='padding:8px; border:1px solid #ddd;'>").append(app ? "YES" : "NO").append("</td>")
//                .append("<td style='padding:8px; border:1px solid #ddd;'>")
//                .append("<span style='background-color:").append(color).append("; color:white; padding:3px 10px; border-radius:12px; font-weight:bold; font-size:11px;'>")
//                .append(st).append("</span></td></tr>");
//            count++;
//        }
//
//        public void buildClosure() {
//            sb.append("</table>");
//            if (count >= MAX_ROWS) sb.append("<div style='text-align:left; font-size:10px; color:#999; margin-top:4px;'><i>* Showing first 5 samples only</i></div>");
//        }
//
//        public String getHtmlReport() { return sb.toString(); }
//    }
}
