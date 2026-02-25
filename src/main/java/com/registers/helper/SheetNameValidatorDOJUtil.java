package com.registers.helper;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.ExcelF;
import utils.ExcelFileDetails;

/**
 * A dedicated Single-Responsibility Utility for Validating Excel Sheet Names
 * exclusively against an Ascending Date of Joining (DOJ) sequence.
 * (Numeric Checks Removed. Identical Dates are treated equally regardless of ID order).
 */
public final class SheetNameValidatorDOJUtil {

    private SheetNameValidatorDOJUtil() {}

    /**
     * Core orchestration method for pure DOJ-based sequence validation.
     */
    public static ValidationResult validateSheetNamesWithDOJ(
            ExcelFileDetails masterFile,
            File downloadedFile,
            int empIdColIndex,
            int dojColIndex,
            List<ExcelF> masterFilters,
            ExcelExclude exclude,
            boolean generateHtmlReport,
            ExtentTest test) {

        ValidationResult result = new ValidationResult(true);
        boolean validationFailed = false;

        Map<String, MasterRow> masterMap = new LinkedHashMap<>();
        List<String> actualSheetNames = new ArrayList<>();

        List<String> dojParsingFailures = new ArrayList<>();
        List<String> duplicatesInMaster = new ArrayList<>();
        List<String> sequenceMismatches = new ArrayList<>();

        // 1. Pre Checks
        if (masterFile == null || masterFile.getFilePath() == null || masterFile.getFilePath().trim().isEmpty()) {
            test.log(LogStatus.FAIL, "❌ Master file configuration is missing or path is empty.");
            return result.fail();
        }

        File masterExcelFile = new File(masterFile.getFilePath());
        if (!masterExcelFile.exists()) {
            test.log(LogStatus.FAIL, "❌ Master file not found at system path: " + masterFile.getFilePath());
            return result.fail();
        }

        if (downloadedFile == null ||!downloadedFile.exists()) {
            test.log(LogStatus.FAIL, "❌ Target downloaded file is missing.");
            return result.fail();
        }

        // 2. Read Master Data & Parse DOJ (Mapped by UPPERCASE EmpID)
        try (Workbook masterWb = WorkbookFactory.create(new FileInputStream(masterExcelFile))) {
            Sheet masterSheet = masterWb.getSheetAt(0);

            for (int r = masterSheet.getFirstRowNum() + 1; r <= masterSheet.getLastRowNum(); r++) {
                Row row = masterSheet.getRow(r);
                if (row == null) continue;

                if (exclude!= null && exclude.shouldExclude(row)) continue;
                if (!passesFilters(row, masterFilters)) continue;

                // Extract Emp ID
                Cell empCell = row.getCell(empIdColIndex);
                if (empCell == null) continue;
                empCell.setCellType(CellType.STRING);
                String empId = empCell.getStringCellValue().trim();
                if (empId.isEmpty()) continue;

                // Extract DOJ
                Cell dojCell = row.getCell(dojColIndex);
                Date dojDate = null;
                String dojStr = "---";

                if (dojCell!= null) {
                    if (dojCell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(dojCell)) {
                        dojDate = dojCell.getDateCellValue();
                        dojStr = new SimpleDateFormat("dd-MM-yyyy").format(dojDate);
                    } else {
                        dojCell.setCellType(CellType.STRING);
                        String tempStr = dojCell.getStringCellValue().trim();
                        if (!tempStr.isEmpty()) {
                            dojDate = parseDateSafe(tempStr);
                            dojStr = dojDate!= null? new SimpleDateFormat("dd-MM-yyyy").format(dojDate) : tempStr;
                        }
                    }
                }

                if (dojDate == null) {
                    dojParsingFailures.add(empId + " (Value: " + dojStr + ")");
                    validationFailed = true;
                } else {
                    String upperId = empId.toUpperCase();
                    if (masterMap.containsKey(upperId)) {
                        duplicatesInMaster.add(empId);
                        validationFailed = true;
                    } else {
                        masterMap.put(upperId, new MasterRow(empId, dojDate, dojStr));
                    }
                }
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "❌ Exception encountered while parsing Master File: " + e.getMessage());
            return result.fail();
        }

        // 3. Read Downloaded File (Actual Sequence)
        try (Workbook downloadedWb = WorkbookFactory.create(new FileInputStream(downloadedFile))) {
            for (int i = 0; i < downloadedWb.getNumberOfSheets(); i++) {
                actualSheetNames.add(downloadedWb.getSheetName(i).trim());
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "❌ Exception reading downloaded artifact: " + e.getMessage());
            return result.fail();
        }

        // 4. Existence Checks (Missing / Extra)
        Set<String> actualUpper = new HashSet<>();
        for (String actual : actualSheetNames) actualUpper.add(actual.toUpperCase());

        Set<String> missingSheets = new HashSet<>();
        for (String expectedUpper : masterMap.keySet()) {
            if (!actualUpper.contains(expectedUpper)) missingSheets.add(masterMap.get(expectedUpper).empId);
        }

        Set<String> extraSheets = new HashSet<>();
        for (String actual : actualSheetNames) {
            if (!masterMap.containsKey(actual.toUpperCase())) extraSheets.add(actual);
        }

        // 5. SMART DOJ SEQUENCE CHECK (Ignores ID mismatch, checks ONLY Dates)
        Date maxDojSoFar = null;
        
        // PERFECT ARRAY DECLARATION - No compile errors here
        boolean[] uiRowPass = new boolean[actualSheetNames.size()];

        for (int i = 0; i < actualSheetNames.size(); i++) {

            uiRowPass[i] = true; // assume pass initially

            String actSheet = actualSheetNames.get(i);
            MasterRow mr = masterMap.get(actSheet.toUpperCase());

            if (mr != null && mr.dojDate != null) {

                // If current DOJ is strictly BEFORE the maximum DOJ seen so far -> SEQUENCE ERROR
                if (maxDojSoFar != null && mr.dojDate.before(maxDojSoFar)) {

                    sequenceMismatches.add(
                        "Row " + (i + 1) + ": Sheet with DOJ " + mr.dojStr +
                        " dropped backwards (Expected >= " +
                        new SimpleDateFormat("dd-MM-yyyy").format(maxDojSoFar) + ")"
                    );

                    uiRowPass[i] = false;

                } else {
                    // Update max DOJ (same date allowed)
                    maxDojSoFar = mr.dojDate;
                }

            } else {
                // Extra sheet or invalid DOJ
                uiRowPass[i] = false;
            }
        }
        

        // 6. Consolidated Logging
        if (!dojParsingFailures.isEmpty()) {
            test.log(LogStatus.FAIL, "❌ DOJ Parsing Failures for IDs: " + String.join(", ", dojParsingFailures));
        }
        if (!duplicatesInMaster.isEmpty()) {
            test.log(LogStatus.FAIL, "❌ Duplicate IDs in Master: " + String.join(", ", duplicatesInMaster));
        }
        if (!missingSheets.isEmpty()) {
            test.log(LogStatus.FAIL, "❌ Missing Sheets from Payload: " + String.join(", ", missingSheets));
            validationFailed = true;
        }
        if (!extraSheets.isEmpty()) {
            test.log(LogStatus.FAIL, "❌ Extra Superfluous Sheets: " + String.join(", ", extraSheets));
            validationFailed = true;
        }
        if (!sequenceMismatches.isEmpty()) {
            validationFailed = true;
            List<String> limitMismatches = sequenceMismatches.size() > 10? sequenceMismatches.subList(0, 10) : sequenceMismatches;
            test.log(LogStatus.FAIL, "❌ DOJ Sequence Order Mismatches (Showing first few):<br>" + String.join("<br>", limitMismatches));
        }

        // 7. Render ExtentReport HTML UI
        if (generateHtmlReport) {
        	// Render ExtentReport HTML UI
        	ReportUIBuilder.generate(test, actualSheetNames, masterMap, uiRowPass, empIdColIndex, dojColIndex);
        }

        if (validationFailed) {
            return result.fail();
        }

        test.log(LogStatus.PASS, "✅ DOJ Sequence validation fully passed | Mapped IDs: " + masterMap.size() + " | Downloaded Sheets: " + actualSheetNames.size());
        return result;
    }

    // ======================= HELPER METHODS =======================

    private static Date parseDateSafe(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()) return null;
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(dateStr.trim());
        } catch (Exception e) {
            return null;
        }
    }

    private static boolean passesFilters(Row row, List<ExcelF> filters) {
        if (filters == null || filters.isEmpty()) return true;
        for (ExcelF filter : filters) {
            if (filter.isDisabled()) continue;
            Cell cell = row.getCell(filter.getColumnIndex());
            if (cell == null) return false;
            cell.setCellType(CellType.STRING);
            String cellVal = cell.getStringCellValue().trim();
            boolean matched = false;
            for (String allowed : filter.getValues()) {
                if (cellVal.equalsIgnoreCase(allowed.trim())) {
                    matched = true;
                    break;
                }
            }
            if (!matched) return false;
        }
        return true;
    }

    // ======================= INNER MODELS =======================

    public static class ValidationResult {
        public boolean valid;
        ValidationResult(boolean valid) { this.valid = valid; }
        ValidationResult fail() { this.valid = false; return this; }
    }

    private static class MasterRow {
        String empId;
        Date dojDate;
        String dojStr;

        MasterRow(String empId, Date dojDate, String dojStr) {
            this.empId = empId;
            this.dojDate = dojDate;
            this.dojStr = dojStr;
        }
    }

    public static class ExcelExclude {
        private final int columnIndex;
        private final List<String> excludedValues;

        public ExcelExclude(int columnIndex, List<String> excludedValues) {
            this.columnIndex = columnIndex;
            this.excludedValues = excludedValues;
        }

        boolean shouldExclude(Row row) {
            Cell cell = row.getCell(columnIndex);
            if (cell == null) return false;
            cell.setCellType(CellType.STRING);
            String value = cell.getStringCellValue().trim();
            return excludedValues.contains(value);
        }
    }

    // ======================= HTML UI BUILDER =======================

    private static class ReportUIBuilder {
    	// Method signature mein 'boolean[] uiRowPass' (array)
    	static void generate(ExtentTest test, List<String> actual, Map<String, MasterRow> masterMap, boolean[] uiRowPass, int empCol, int dojCol) {
    	    if (test == null) return;

    	    String empColLetter = getColumnLetter(empCol);
    	    String dojColLetter = getColumnLetter(dojCol);

    	    List<UIRowData> tableRows = new ArrayList<>();
    	    Set<String> processedMasterUpper = new HashSet<>();

    	    // 1. Map Actual Sequence
    	    for (int i = 0; i < actual.size(); i++) {
    	        String actSheet = actual.get(i);
    	        MasterRow mr = masterMap.get(actSheet.toUpperCase());
    	        
    	        if (mr!= null) {
    	            // Yahan properly array ka index [i] use karein
    	            tableRows.add(new UIRowData(mr.empId, mr.dojStr, actSheet, uiRowPass[i]));
    	            processedMasterUpper.add(actSheet.toUpperCase());
    	        } else {
    	            tableRows.add(new UIRowData("---", "---", actSheet, false)); // Extra
    	        }
    	    }
    	

            // 2. Add Missing Sheets at the end
            for (Map.Entry<String, MasterRow> entry : masterMap.entrySet()) {
                if (!processedMasterUpper.contains(entry.getKey())) {
                    tableRows.add(new UIRowData(entry.getValue().empId, entry.getValue().dojStr, "---", false));
                }
            }

            int displayLimit = Math.min(tableRows.size(), 5); // STRICTLY 5 ROWS  -- If need to print ye use karna : masterMap.size() jitna size hai utna aayega
            StringBuilder html = new StringBuilder();

            html.append("<div style='margin-bottom:12px; font-family:Arial, sans-serif; font-size:13px;'>");
            html.append("<table style='border-collapse:collapse; width:100%; table-layout:fixed;'>");
            html.append("<colgroup>");
            html.append("<col style='width:6%'>");   // SEQ
            html.append("<col style='width:30%'>");  // Expected ID
            html.append("<col style='width:22%'>");  // Expected DOJ
            html.append("<col style='width:30%'>");  // Actual Target
            html.append("<col style='width:12%'>");  // Result Badge
            html.append("</colgroup>");

            // Table Header 
            html.append("<tr>");
            html.append(th("ROW"));
            html.append(th("MASTER EMPLOYEE IDs<br><small style='font-weight:400;'>Column " + empColLetter + "</small>"));
            html.append(th("MASTER DOJ<br><small style='font-weight:400;'>Column " + dojColLetter + "</small>"));
            html.append(th("DOWNLOADED EMPLOYEE IDs"));
            html.append(th("RESULT"));
            html.append("</tr>");

            // Build Rows
            for (int i = 0; i < displayLimit; i++) {
                UIRowData data = tableRows.get(i);
                html.append("<tr>");
                html.append(td(String.valueOf(i + 1)));
                html.append(td(data.masterVal));
                html.append(td(data.masterDoj));
                html.append(td(data.downloadedVal));
                
                // This will print PASS in green when data.pass is true!
                html.append(td(pill(data.pass? "PASS" : "FAIL", data.pass)));
                html.append("</tr>");
            }

            html.append("</table></div>");

            test.log(LogStatus.INFO,
                    "<b style='font-size:14px; color:#000000;'>DOJ Sequence Validation Summary</b><br>" +
                    "<span style='color:#000000; font-size:12px;'>Valid Master DOJ Records: " + masterMap.size() + " | Downloaded Sheets: " + actual.size() + "</span><br><br>" +
                    html.toString()
            );
        }

        private static String th(String label) {
            String bgColor = "#f2f2f2";    
            String headerLine = "#76db90";// #cccccc --BorderLine for header
            String textColor = "#000000";  
            
            return "<th style='background:" + bgColor + "; border:1px solid " + headerLine + "; padding:8px; text-align:center; color:" + textColor + "; font-weight:bold;'>" + label + "</th>";
        }

        private static String td(String val) {
            String headerLineTable = "#cccccc"; //BorderLine for table
            String textColor = "#000000";  
            
            return "<td style='border:1px solid " + headerLineTable + "; padding:8px; text-align:center; color:" + textColor + ";'>" + val + "</td>";
        }

        private static String pill(String text, boolean pass) {
            return "<span style='display:inline-block; padding:3px 12px; border-radius:999px; font-size:11px; font-weight:700; " +
                   "background:" + (pass? "#ecfdf5" : "#fef2f2") + "; " +
                   "color:" + (pass? "#065f46" : "#991b1b") + ";'>" +
                   text + "</span>";
        }

        private static String getColumnLetter(int index) {
            if (index < 0) return "?";
            StringBuilder sb = new StringBuilder();
            int n = index + 1;
            while (n > 0) {
                int rem = (n - 1) % 26;
                sb.append((char) ('A' + rem));
                n = (n - 1) / 26;
            }
            return sb.reverse().toString();
        }

        private static class UIRowData {
            String masterVal; String masterDoj; String downloadedVal; boolean pass;
            UIRowData(String mv, String md, String dv, boolean p) {
                masterVal = mv; masterDoj = md; downloadedVal = dv; pass = p;
            }
        }
    }
    
    
    
    
    
    
    //**********THIS WILL SHOW CIRCLE GRAPH***************
//    private static class ReportUIBuilder {
//        // Method signature exactly same rakha hai
//        static void generate(ExtentTest test, List<String> actual, Map<String, MasterRow> masterMap, boolean[] uiRowPass, int empCol, int dojCol) {
//            if (test == null) return;
//
//            String empColLetter = getColumnLetter(empCol);
//            String dojColLetter = getColumnLetter(dojCol);
//
//            List<UIRowData> tableRows = new ArrayList<>();
//            Set<String> processedMasterUpper = new HashSet<>();
//
//            // 1. Map Actual Sequence
//            for (int i = 0; i < actual.size(); i++) {
//                String actSheet = actual.get(i);
//                MasterRow mr = masterMap.get(actSheet.toUpperCase());
//                
//                if (mr != null) {
//                    tableRows.add(new UIRowData(mr.empId, mr.dojStr, actSheet, uiRowPass[i]));
//                    processedMasterUpper.add(actSheet.toUpperCase());
//                } else {
//                    tableRows.add(new UIRowData("---", "---", actSheet, false)); // Extra
//                }
//            }
//
//            // 2. Add Missing Sheets at the end
//            for (Map.Entry<String, MasterRow> entry : masterMap.entrySet()) {
//                if (!processedMasterUpper.contains(entry.getKey())) {
//                    tableRows.add(new UIRowData(entry.getValue().empId, entry.getValue().dojStr, "---", false));
//                }
//            }
//
//            // --- DYNAMIC STATS CALCULATION FOR GRAPHICS ---
//            int totalRecords = tableRows.size();
//            int passCount = 0;
//            for (UIRowData row : tableRows) {
//                if (row.pass) passCount++;
//            }
//            int failCount = totalRecords - passCount;
//            int passPct = totalRecords == 0 ? 0 : (int) Math.round((passCount * 100.0) / totalRecords);
//            int failPct = totalRecords == 0 ? 0 : (100 - passPct);
//            // ----------------------------------------------
//
//            int displayLimit = Math.min(tableRows.size(), 5); // STRICTLY 5 ROWS
//            StringBuilder html = new StringBuilder();
//
//            html.append("<div style='margin-bottom:12px; font-family:Arial, sans-serif; font-size:13px;'>");
//            
//            // --- GRAPHICAL REPRESENTATION (Click to Expand) ---
//            html.append("<details style='margin-bottom: 15px; background: #f9fafb; border: 1px solid #e5e7eb; border-radius: 6px; padding: 10px;'>");
//            html.append("<summary style='cursor: pointer; font-weight: bold; font-size: 14px; color: #374151; outline: none;'>");
//            html.append("📊 Click to view Pass/Fail Analytics");
//            html.append("</summary>");
//            
//            html.append("<div style='margin-top: 15px; display: flex; align-items: center; gap: 20px; padding-top: 10px; border-top: 1px solid #e5e7eb;'>");
//            
//            // CSS Pie Chart (No external JS required, pure CSS)
//            html.append("<div style='width: 80px; height: 80px; border-radius: 50%; background: conic-gradient(#10b981 0% ").append(passPct).append("%, #ef4444 ").append(passPct).append("% 100%); box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);'></div>");
//            
//            // Stats Details
//            html.append("<div style='display: flex; flex-direction: column; gap: 8px;'>");
//            html.append("<div style='display: flex; align-items: center; gap: 8px;'><span style='width: 12px; height: 12px; background: #10b981; border-radius: 2px; display: inline-block;'></span><span style='font-size: 13px; font-weight: 600; color: #374151;'>PASS: ").append(passCount).append(" (").append(passPct).append("%)</span></div>");
//            html.append("<div style='display: flex; align-items: center; gap: 8px;'><span style='width: 12px; height: 12px; background: #ef4444; border-radius: 2px; display: inline-block;'></span><span style='font-size: 13px; font-weight: 600; color: #374151;'>FAIL: ").append(failCount).append(" (").append(failPct).append("%)</span></div>");
//            html.append("<div style='font-size: 12px; color: #6b7280; margin-top: 4px;'>Total Records: ").append(totalRecords).append("</div>");
//            html.append("</div>");
//            
//            html.append("</div>");
//            html.append("</details>");
//            // --------------------------------------------------
//
//            html.append("<table style='border-collapse:collapse; width:100%; table-layout:fixed;'>");
//            html.append("<colgroup>");
//            html.append("<col style='width:6%'>");   // SEQ
//            html.append("<col style='width:30%'>");  // Expected ID
//            html.append("<col style='width:22%'>");  // Expected DOJ
//            html.append("<col style='width:30%'>");  // Actual Target
//            html.append("<col style='width:12%'>");  // Result Badge
//            html.append("</colgroup>");
//
//            // Table Header 
//            html.append("<tr>");
//            html.append(th("ROW"));
//            html.append(th("MASTER VALUE<br><small style='font-weight:400;'>Column " + empColLetter + "</small>"));
//            html.append(th("MASTER DOJ<br><small style='font-weight:400;'>Column " + dojColLetter + "</small>"));
//            html.append(th("DOWNLOADED VALUE"));
//            html.append(th("RESULT"));
//            html.append("</tr>");
//
//            // Build Rows
//            for (int i = 0; i < displayLimit; i++) {
//                UIRowData data = tableRows.get(i);
//                html.append("<tr>");
//                html.append(td(String.valueOf(i + 1)));
//                html.append(td(data.masterVal));
//                html.append(td(data.masterDoj));
//                html.append(td(data.downloadedVal));
//                
//                // This will print PASS in green when data.pass is true!
//                html.append(td(pill(data.pass ? "PASS" : "FAIL", data.pass)));
//                html.append("</tr>");
//            }
//
//            html.append("</table></div>");
//
//            test.log(LogStatus.INFO,
//                    "<b style='font-size:14px; color:#000000;'>DOJ Sequence Validation Summary</b><br>" +
//                    "<span style='color:#000000; font-size:12px;'>Valid Master DOJ Records: " + masterMap.size() + " | Downloaded Sheets: " + actual.size() + "</span><br><br>" +
//                    html.toString()
//            );
//        }
//
//        private static String th(String label) {
//            String bgColor = "#f2f2f2";    
//            String headerLine = "#76db90"; // BorderLine for header
//            String textColor = "#000000";  
//            
//            return "<th style='background:" + bgColor + "; border:1px solid " + headerLine + "; padding:8px; text-align:center; color:" + textColor + "; font-weight:bold;'>" + label + "</th>";
//        }
//
//        private static String td(String val) {
//            String headerLineTable = "#cccccc"; // BorderLine for table
//            String textColor = "#000000";  
//            
//            return "<td style='border:1px solid " + headerLineTable + "; padding:8px; text-align:center; color:" + textColor + ";'>" + val + "</td>";
//        }
//
//        private static String pill(String text, boolean pass) {
//            return "<span style='display:inline-block; padding:3px 12px; border-radius:999px; font-size:11px; font-weight:700; " +
//                   "background:" + (pass ? "#ecfdf5" : "#fef2f2") + "; " +
//                   "color:" + (pass ? "#065f46" : "#991b1b") + ";'>" +
//                   text + "</span>";
//        }
//
//        private static String getColumnLetter(int index) {
//            if (index < 0) return "?";
//            StringBuilder sb = new StringBuilder();
//            int n = index + 1;
//            while (n > 0) {
//                int rem = (n - 1) % 26;
//                sb.append((char) ('A' + rem));
//                n = (n - 1) / 26;
//            }
//            return sb.reverse().toString();
//        }
//
//        private static class UIRowData {
//            String masterVal; String masterDoj; String downloadedVal; boolean pass;
//            UIRowData(String mv, String md, String dv, boolean p) {
//                masterVal = mv; masterDoj = md; downloadedVal = dv; pass = p;
//            }
//        }
//    }
    
    
    
    
    
    
    
    
}