package com.registers.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.ExcelF;
import utils.ExcelFileDetails;

/**
 * A highly optimized, stateless utility class dedicated exclusively to validating 
 * expected sheet names (Master Data) against actual sheet names in a downloaded payload.
 *
 * Fixed Features:
 * - Method Signature strictly retained: validateExcelBusinessData
 * - Downloaded Sequence Mapping: Perfectly aligns out-of-order IDs based on downloaded sequence.
 * - CSS Isolation: Uses STRICT INLINE CSS to prevent breaking ExtentReports' global DOM.
 * - SRP Applied: No DOJ logic, no numeric extractions.
 */
public final class SheetNameValidatorUtil {

    private SheetNameValidatorUtil() {}

    /**
     * Core orchestration method to validate sheet names via direct file extraction.
     */
    public static ValidationResult validateExcelBusinessData(
            ExcelFileDetails masterFile,
            File downloadedFile,
            int empIdColIndex,
            List<ExcelF> masterFilters,
            ExcelExclude exclude,
            boolean generateHtmlReport,
            ExtentTest test) {

        ValidationResult result = new ValidationResult(true);
        boolean validationFailed = false;

        List<String> expectedEmpIds = new ArrayList<>();
        List<String> actualSheetNames = new ArrayList<>();

        // 1. Pre Checks
        if (masterFile == null || masterFile.getFilePath() == null || masterFile.getFilePath().trim().isEmpty()) {
            test.log(LogStatus.FAIL, "❌ Master file path is null or empty.");
            return result.fail();
        }

        File masterExcelFile = new File(masterFile.getFilePath());
        if (!masterExcelFile.exists()) {
            test.log(LogStatus.FAIL, "❌ Master file not found at path: " + masterFile.getFilePath());
            return result.fail();
        }

        if (downloadedFile == null ||!downloadedFile.exists()) {
            test.log(LogStatus.FAIL, "❌ Downloaded file is null or missing.");
            return result.fail();
        }

        // 2. Read Master
        try (Workbook masterWb = WorkbookFactory.create(new FileInputStream(masterExcelFile))) {
            Sheet masterSheet = masterWb.getSheetAt(0);

            for (int r = masterSheet.getFirstRowNum() + 1; r <= masterSheet.getLastRowNum(); r++) {
                Row row = masterSheet.getRow(r);
                if (row == null) continue;

                if (exclude!= null && exclude.shouldExclude(row)) continue;
                if (!passesFilters(row, masterFilters)) continue;

                Cell empCell = row.getCell(empIdColIndex);
                if (empCell == null) continue;

                empCell.setCellType(CellType.STRING);
                String empId = empCell.getStringCellValue().trim();

                if (!empId.isEmpty()) {
                    expectedEmpIds.add(empId);
                }
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "❌ Exception during master validation reading: " + e.getMessage());
            return result.fail();
        }

        // 3. Read Downloaded (All Sheets)
        try (Workbook downloadedWb = WorkbookFactory.create(new FileInputStream(downloadedFile))) {
            for (int i = 0; i < downloadedWb.getNumberOfSheets(); i++) {
                actualSheetNames.add(downloadedWb.getSheetName(i).trim());
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "❌ Exception during downloaded file reading: " + e.getMessage());
            return result.fail();
        }

        // 4. Value-Based List Comparison (Order Independent Mathematical Evaluation)
        Set<String> expectedSetUpper = new HashSet<>();
        Set<String> duplicatesInMaster = new HashSet<>();

        for (String emp : expectedEmpIds) {
            if (!expectedSetUpper.add(emp.toUpperCase())) {
                duplicatesInMaster.add(emp);
            }
        }

        Set<String> actualSetUpper = new HashSet<>();
        for (String actual : actualSheetNames) {
            actualSetUpper.add(actual.toUpperCase());
        }

        Set<String> missingFromDownloaded = new HashSet<>(expectedSetUpper);
        missingFromDownloaded.removeAll(actualSetUpper);

        Set<String> extraInDownloaded = new HashSet<>(actualSetUpper);
        extraInDownloaded.removeAll(expectedSetUpper);

        // 5. Consolidated Logs (No loop spamming)
        if (!missingFromDownloaded.isEmpty()) {
            test.log(LogStatus.FAIL, "❌ Missing Employee IDs: " + String.join(", ", missingFromDownloaded));
            validationFailed = true;
        }

        if (!duplicatesInMaster.isEmpty()) {
            test.log(LogStatus.FAIL, "❌ Duplicate Employee IDs in master: " + String.join(", ", duplicatesInMaster));
            validationFailed = true;
        }

        if (!extraInDownloaded.isEmpty()) {
            test.log(LogStatus.FAIL, "❌ Extra / Unmapped Sheets found in downloaded file: " + String.join(", ", extraInDownloaded));
            validationFailed = true;
        }

        // 6. Generate Clean HTML Report Matrix (Safely isolated inline CSS)
        if (generateHtmlReport) {
            ReportUIBuilder.generate(test, expectedEmpIds, actualSheetNames, empIdColIndex);
        }

        if (validationFailed) {
            return result.fail();
        }

        test.log(LogStatus.PASS, "✅ Excel SheetName validation passed | Filtered Master IDs: " + expectedEmpIds.size() + " | Downloaded Sheets: " + actualSheetNames.size());
        return result;
    }

    /**
     * Helper to validate row against ExcelF filters.
     */
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

    /** Validation Result Model */
    public static class ValidationResult {
        public boolean valid;
        ValidationResult(boolean valid) { this.valid = valid; }
        ValidationResult fail() { this.valid = false; return this; }
    }
    
    /** Inner Exclude Rules Model */
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

    /** Dedicated UI Builder for Extent Reports using STRICT INLINE CSS to prevent DOM bleed */
    private static class ReportUIBuilder {
        
        static void generate(ExtentTest test, List<String> expected, List<String> actual, int colIndex) {
            if (test == null) return;

            // Step A: Sequence-driven pairing (Drive entirely by Downloaded File to handle scrambled orders)
            List<ReportRow> uiRows = new ArrayList<>();
            Set<String> matchedExpectedUpper = new HashSet<>();

            for (String actSheet : actual) {
                String matchedExp = findIgnoreCase(actSheet, expected);
                if (matchedExp!= null) {
                    uiRows.add(new ReportRow(matchedExp, actSheet, true));
                    matchedExpectedUpper.add(matchedExp.toUpperCase());
                } else {
                    uiRows.add(new ReportRow("---", actSheet, false));
                }
            }

            // Step B: Append any missing expected master IDs at the end
            for (String expSheet : expected) {
                if (!matchedExpectedUpper.contains(expSheet.toUpperCase())) {
                    uiRows.add(new ReportRow(expSheet, "---", false));
                }
            }

            // Step C: Build Extent-Safe HTML (NO <style> tags!)
            String colLetter = getColumnLetter(colIndex);
            int limit = Math.min(uiRows.size(), 5); // Strict 5 row limit

            StringBuilder html = new StringBuilder();

            html.append("<table style='border-collapse:collapse; width:100%; table-layout:fixed; font-family:Arial, sans-serif; font-size:13px;'>");
            html.append("<colgroup>");
            html.append("<col style='width:6%'>");   // Row
            html.append("<col style='width:41%'>");  // Master
            html.append("<col style='width:41%'>");  // Downloaded
            html.append("<col style='width:12%'>");  // Result
            html.append("</colgroup>");
            
            html.append("<tr>");
            html.append(th("ROW"));
            html.append(th("MASTER VALUE<br><small style='font-weight:400;'>Column " + colLetter + "</small>"));
            html.append(th("DOWNLOADED VALUE"));
            html.append(th("RESULT"));
            html.append("</tr>");

            for (int i = 0; i < limit; i++) {
                ReportRow r = uiRows.get(i);
                html.append("<tr>");
                html.append(tdCenter(String.valueOf(i + 1)));
                html.append(tdCenter(r.masterVal));
                html.append(tdCenter(r.downloadedVal));
                html.append(tdCenter(pill(r.match? "PASS" : "FAIL", r.match)));
                html.append("</tr>");
            }
            html.append("</table>");

            test.log(LogStatus.INFO,
                    "<b>Excel SheetName Validation Summary</b><br>" +
                    "Total Master Records : " + expected.size() + "<br>" +
                    "Total Downloaded Sheets : " + actual.size() + "<br><br>" +
                    html.toString()
            );
        }

        private static String th(String label) {
            return "<th style='background:#f2f2f2; border:1px solid #ccc; padding:6px; text-align:center; font-weight:bold;'>" + label + "</th>";
        }

        private static String tdCenter(String val) {
            return "<td style='border:1px solid #ccc; padding:6px; text-align:center;'>" + val + "</td>";
        }

        private static String findIgnoreCase(String target, List<String> list) {
            for (String item : list) {
                if (item.equalsIgnoreCase(target)) return item;
            }
            return null;
        }

        private static String pill(String text, boolean pass) {
            return "<span style='display:inline-block; padding:2px 12px; border-radius:999px; " +
                   "background:" + (pass? "#ecfdf5" : "#fef2f2") + "; " +
                   "color:" + (pass? "#065f46" : "#991b1b") + "; font-weight:700;'>" +
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

    /** Simple container to hold UI row states cleanly */
    private static class ReportRow {
        String masterVal;
        String downloadedVal;
        boolean match;
        ReportRow(String mv, String dv, boolean m) {
            this.masterVal = mv;
            this.downloadedVal = dv;
            this.match = m;
        }
    }
}