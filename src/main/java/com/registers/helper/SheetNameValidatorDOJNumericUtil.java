package com.registers.helper;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
 * A dedicated Single-Responsibility Utility for Numeric Order Validation.
 * 
 * CORE RULES APPLIED:
 * 1. Expected sequence is determined by sorting DOJ (Ascending) -> Numeric (Ascending).
 * 2. DOJ is strictly used for internal sorting ONLY.
 * 3. DOJ failure logs are completely suppressed.
 * 4. Final output exclusively highlights Numeric mismatch failures.
 */
public final class SheetNameValidatorDOJNumericUtil {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("(\\d+)");

    private SheetNameValidatorDOJNumericUtil() {}

    /**
     * Core orchestration method for Numeric-based sequence validation (with DOJ underlying sort).
     */
    public static ValidationResult validateSheetNamesWithNumeric(
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

        List<MasterRow> masterRows = new ArrayList<>();
        List<String> actualSheetNames = new ArrayList<>();

        List<String> missingSheets = new ArrayList<>();
        List<String> extraSheets = new ArrayList<>();
        List<String> numericSequenceFailures = new ArrayList<>();
        List<String> numericExtractionFailures = new ArrayList<>();

        List<UIRowData> uiTableData = new ArrayList<>();

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

        // 2. Read Master Data & Extract DOJ/Numeric
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

                // Numeric Extraction
                Integer numericVal = extractNumeric(empId);
                if (numericVal == null) {
                    numericExtractionFailures.add(empId);
                    validationFailed = true;
                    continue; // Skip if no numeric part
                }

                // Extract DOJ safely (Silencing errors as requested, fallback to Epoch for sorting)
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

                // Suppressing DOJ failure logs: Just assign Epoch date so sorting still works
                if (dojDate == null) {
                    dojDate = new Date(0); 
                    dojStr = "Invalid/Missing Date";
                }

                masterRows.add(new MasterRow(empId, dojDate, dojStr, numericVal));
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "❌ Exception encountered while parsing Master File: " + e.getMessage());
            return result.fail();
        }

        // 3. Expected Sequence Calculation (Sort by DOJ Asc -> Numeric Asc)
        Collections.sort(masterRows, new Comparator<MasterRow>() {
            @Override
            public int compare(MasterRow r1, MasterRow r2) {
                int dateComp = r1.dojDate.compareTo(r2.dojDate);
                if (dateComp!= 0) {
                    return dateComp;
                }
                // Same DOJ -> Sort Numerically
                return r1.numericVal.compareTo(r2.numericVal);
            }
        });

        List<MasterRow> expectedSequence = masterRows; // Now sorted

        // 4. Read Downloaded File (Actual Sequence)
        try (Workbook downloadedWb = WorkbookFactory.create(new FileInputStream(downloadedFile))) {
            for (int i = 0; i < downloadedWb.getNumberOfSheets(); i++) {
                actualSheetNames.add(downloadedWb.getSheetName(i).trim());
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "❌ Exception reading downloaded artifact: " + e.getMessage());
            return result.fail();
        }

        // 5. Numeric Mismatch Detection & UI Data Preparation
        Set<String> processedExpected = new HashSet<>();

        for (int i = 0; i < actualSheetNames.size(); i++) {
            String actSheet = actualSheetNames.get(i);
            int actualPos = i + 1;
            
            // Find in expected sequence
            int expectedPos = -1;
            MasterRow matchedRow = null;
            for (int j = 0; j < expectedSequence.size(); j++) {
                if (expectedSequence.get(j).empId.equalsIgnoreCase(actSheet)) {
                    expectedPos = j + 1;
                    matchedRow = expectedSequence.get(j);
                    processedExpected.add(actSheet.toUpperCase());
                    break;
                }
            }

            if (matchedRow!= null) {
                if (expectedPos!= actualPos) {
                    // NUMERIC SEQUENCE FAILURE DETECTED
                    validationFailed = true;
                    
                    // Dynamic Reason Calculation
                    String reason = "Position mismatch";
                    if (actualPos - 1 < expectedSequence.size()) {
                        String targetSheet = expectedSequence.get(actualPos - 1).empId;
                        if (actualPos > expectedPos) {
                            reason = "Should appear before " + targetSheet;
                        } else {
                            reason = "Should appear after " + targetSheet;
                        }
                    }

                    numericSequenceFailures.add(actSheet + " -> Expected " + expectedPos + ", Found " + actualPos);
                    uiTableData.add(new UIRowData(actSheet, matchedRow.dojStr, String.valueOf(matchedRow.numericVal), String.valueOf(expectedPos), String.valueOf(actualPos), false, reason));
                } else {
                    // PERFECT MATCH
                    uiTableData.add(new UIRowData(actSheet, matchedRow.dojStr, String.valueOf(matchedRow.numericVal), String.valueOf(expectedPos), String.valueOf(actualPos), true, "---"));
                }
            } else {
                // EXTRA SHEET
                validationFailed = true;
                extraSheets.add(actSheet);
                uiTableData.add(new UIRowData(actSheet, "---", "---", "---", String.valueOf(actualPos), false, "Extra Sheet"));
            }
        }

        // Append Missing Sheets to UI and Logs
        for (int j = 0; j < expectedSequence.size(); j++) {
            MasterRow mr = expectedSequence.get(j);
            if (!processedExpected.contains(mr.empId.toUpperCase())) {
                validationFailed = true;
                missingSheets.add(mr.empId);
                uiTableData.add(new UIRowData(mr.empId, mr.dojStr, String.valueOf(mr.numericVal), String.valueOf(j + 1), "---", false, "Missing Sheet"));
            }
        }

        // 6. Consolidated Logging (Strictly Numeric & Existence, NO DOJ Logs)
        if (!numericExtractionFailures.isEmpty()) {
            test.log(LogStatus.FAIL, "❌ Numeric Extraction Failed (No digits found): " + String.join(", ", numericExtractionFailures));
        }
        if (!missingSheets.isEmpty()) {
            test.log(LogStatus.FAIL, "❌ Missing Sheets from Payload: " + String.join(", ", missingSheets));
        }
        if (!extraSheets.isEmpty()) {
            test.log(LogStatus.FAIL, "❌ Extra Superfluous Sheets: " + String.join(", ", extraSheets));
        }
        if (!numericSequenceFailures.isEmpty()) {
            test.log(LogStatus.FAIL, 
                "<b style='color:#991b1b;'>Numeric Order Validation Failed</b><br>" +
                "Total Numeric Failures: " + numericSequenceFailures.size() + "<br><br>" +
                String.join("<br>", numericSequenceFailures)
            );
        }

        // 7. Render ExtentReport HTML UI
        if (generateHtmlReport) {
        	ReportUIBuilder.generate(test, uiTableData, expectedSequence.size(), actualSheetNames.size(), empIdColIndex, dojColIndex);
        }

        if (validationFailed) {
            return result.fail();
        }

        test.log(LogStatus.PASS, "✅ Numeric Sheet Sequence validation fully passed | Total Validated: " + expectedSequence.size());
        return result;
    }

    // ======================= HELPER METHODS =======================

    private static Integer extractNumeric(String text) {
        if (text == null) return null;
        Matcher m = NUMERIC_PATTERN.matcher(text);
        return m.find()? Integer.valueOf(m.group(1)) : null;
    }

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
        Integer numericVal;

        MasterRow(String empId, Date dojDate, String dojStr, Integer numericVal) {
            this.empId = empId;
            this.dojDate = dojDate;
            this.dojStr = dojStr;
            this.numericVal = numericVal;
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

    private static class UIRowData {
        String empId, doj, numericVal, expectedPos, actualPos, reason;
        boolean pass;
        UIRowData(String empId, String doj, String numericVal, String expectedPos, String actualPos, boolean pass, String reason) {
            this.empId = empId; this.doj = doj; this.numericVal = numericVal; 
            this.expectedPos = expectedPos; this.actualPos = actualPos; this.pass = pass; this.reason = reason;
        }
    }

    // ======================= HTML UI BUILDER =======================

    private static class ReportUIBuilder {

        static void generate(ExtentTest test, List<UIRowData> uiTableData, int totalExpected, int totalActual, int empCol, int dojCol) {
            if (test == null) return;

            String empColLetter = getColumnLetter(empCol);
            String dojColLetter = getColumnLetter(dojCol);

            int displayLimit = Math.min(uiTableData.size(), 5); // STRICTLY 5 ROWS PREVIEW

            StringBuilder html = new StringBuilder();

            html.append("<div style='margin-bottom:12px; font-family:Arial, sans-serif; font-size:12px;'>");
            html.append("<table style='border-collapse:collapse; width:100%; table-layout:fixed;'>");
            
            // 8 Columns definition
            html.append("<colgroup>");
            html.append("<col style='width:5%'>");   // ROW
            html.append("<col style='width:16%'>");  // EMP ID
            html.append("<col style='width:12%'>");  // DOJ
            html.append("<col style='width:12%'>");  // NUMERIC VALUE
            html.append("<col style='width:10%'>");  // EXPECTED POS
            html.append("<col style='width:10%'>");  // ACTUAL POS
            html.append("<col style='width:10%'>");  // RESULT
            html.append("<col style='width:25%'>");  // FAIL REASON
            html.append("</colgroup>");

            // Table Header 
            html.append("<tr>");
            html.append(th("ROW"));
            html.append(th("EMP ID<br><small style='font-weight:400;'>Col " + empColLetter + "</small>"));//Col name
            html.append(th("DOJ<br><small style='font-weight:400;'>Col " + dojColLetter + "</small>"));
            html.append(th("NUMERIC<br>VALUE"));
            html.append(th("EXPECTED<br>POS"));
            html.append(th("ACTUAL<br>POS"));
            html.append(th("RESULT"));
            html.append(th("FAIL REASON"));
            html.append("</tr>");

            // Build Rows
            for (int i = 0; i < displayLimit; i++) {
                UIRowData data = uiTableData.get(i);
                html.append("<tr>");
                html.append(td(String.valueOf(i + 1)));
                html.append(td(data.empId));
                html.append(td(data.doj));
                html.append(td(data.numericVal));
                html.append(td(data.expectedPos));
                html.append(td(data.actualPos));
                html.append(td(pill(data.pass? "PASS" : "FAIL", data.pass)));
                
                // Highlight Reason in Red if failed
                if (!data.pass) {
                    html.append("<td style='border:1px solid #cccccc; padding:6px; text-align:center; color:#991b1b; font-weight:600; font-size:11px;'>").append(data.reason).append("</td>");
                } else {
                    html.append(td(data.reason));
                }
                html.append("</tr>");
            }

            html.append("</table></div>");

            test.log(LogStatus.INFO,
                    "<b style='font-size:14px; color:#000000;'>Numeric Sequence Validation Summary</b><br>" +
                    "<span style='color:#000000; font-size:12px;'>Expected Mapped IDs: " + totalExpected + " | Downloaded Sheets: " + totalActual + "</span><br><br>" +
                    html.toString()
            );
        }

        private static String th(String label) {
            return "<th style='background:#f2f2f2; border:1px solid #cccccc; padding:6px; text-align:center; color:#000000; font-weight:bold; font-size:11px;'>" + label + "</th>";
        }

        private static String td(String val) {
            return "<td style='border:1px solid #cccccc; padding:6px; text-align:center; color:#000000; font-size:12px;'>" + val + "</td>";
        }

        private static String pill(String text, boolean pass) {
            return "<span style='display:inline-block; padding:3px 10px; border-radius:999px; font-size:10px; font-weight:700; " +
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
    }
}