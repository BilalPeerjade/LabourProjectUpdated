package com.registers.helper;



import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import com.aventstack.extentreports.ExtentTest;

//import com.aventstack.extentreports.ExtentTest;

import utils.ExcelF;

/**
 * ExcelSheet2
 * -------------
 * Single-responsibility class:
 * - Direct Excel read (Apache POI)
 * - ExcelF filters (MASTER only)
 * - Optional ExcelExclude
 * - Validations:
 *      1) Employee ID (always)
 *      2) DOJ ordering (checkDOJ || checkNumeric)
 *      3) Numeric ordering (checkNumeric)
 *
 * NOTE:
 * - No HTML report here (DELIVERY-2)
 * - No unnecessary logs
 */
public class ExcelSheet3 {

    /* =========================
       INNER MODELS
       ========================= */

    static class RowData {
        String employeeId;
        String doj; // raw DOJ string (MASTER only)
        int rowNumber;

        RowData(String employeeId, String doj, int rowNumber) {
            this.employeeId = employeeId;
            this.doj = doj;
            this.rowNumber = rowNumber;
        }
    }

    /** OPTIONAL row exclude helper */
   public static class ExcelExclude {
        private final int columnIndex;
        private final List<String> excludedValues;

        ExcelExclude(int columnIndex, List<String> excludedValues) {
            this.columnIndex = columnIndex;
            this.excludedValues = excludedValues;
        }

        boolean shouldExclude(Row row) {
            Cell cell = row.getCell(columnIndex);
            if (cell == null) {
                return false;
            }
            String value = cell.toString().trim();
            return excludedValues.contains(value);
        }
    }

    /** Result holder */
    static class ValidationResult {
        boolean valid = true;

        public boolean isValid() {
            return valid;
        }
    }

    /* =========================
       MAIN ENTRY METHOD
       ========================= */

    public ValidationResult validateExcelBusinessData(
            String masterFilePath,
            String downloadedFilePath,
            int employeeIdColIndex,
            int dojColIndex,
            List<ExcelF> masterFilters,
            boolean checkDOJ,
            boolean checkNumeric,
            ExcelExclude excelExclude,
            ExtentTest test
    ) {

        ValidationResult result = new ValidationResult();

        /* =========================
           STEP 1: READ MASTER EXCEL
           ========================= */

        List<RowData> masterRows = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(masterFilePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            int logicalRowNum = 1;

            for (Row row : sheet) {

                // skip header
                if (row.getRowNum() == 0) {
                    continue;
                }

                // ExcelExclude (optional)
                if (excelExclude != null && excelExclude.shouldExclude(row)) {
                    continue;
                }

                // ExcelF filters (MASTER only)
                boolean skip = false;
                if (masterFilters != null) {
                    for (ExcelF filter : masterFilters) {
                        Cell c = row.getCell(filter.getColumnIndex());
                        String v = c == null ? "" : c.toString().trim();
                        if (!filter.getValues().contains(v)) {
                            skip = true;
                            break;
                        }
                    }
                }
                if (skip) {
                    continue;
                }

                Cell empCell = row.getCell(employeeIdColIndex);
                Cell dojCell = row.getCell(dojColIndex);

                String empId = empCell == null ? null : empCell.toString().trim();
                String doj = dojCell == null ? null : dojCell.toString().trim();

                masterRows.add(new RowData(empId, doj, logicalRowNum));
                logicalRowNum++;
            }

        } catch (Exception e) {
            result.valid = false;
//            test.fail("Failed to read MASTER Excel : " + e.getMessage());
            test.log(LogStatus.FAIL, "Failed to read MASTER Excel : " + e.getMessage());
            return result;
        }

        /* =========================
           STEP 2: READ DOWNLOADED EXCEL
           ========================= */

        List<RowData> downloadedRows = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(downloadedFilePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            int logicalRowNum = 1;

            for (Row row : sheet) {

                if (row.getRowNum() == 0) {
                    continue;
                }

                if (excelExclude != null && excelExclude.shouldExclude(row)) {
                    continue;
                }

                Cell empCell = row.getCell(employeeIdColIndex);
                String empId = empCell == null ? null : empCell.toString().trim();

                downloadedRows.add(new RowData(empId, null, logicalRowNum));
                logicalRowNum++;
            }

        } catch (Exception e) {
            result.valid = false;
//            test.fail("Failed to read DOWNLOADED Excel : " + e.getMessage());
            test.log(LogStatus.FAIL, "Failed to read DOWNLOADED Excel : " + e.getMessage());
            return result;
        }

        /* =========================
           STEP 3: VALIDATIONS
           ========================= */

        /* --- 3.1 Employee ID validation (ALWAYS) --- */

        Set<String> masterIds = new HashSet<>();
        Set<String> downloadedIds = new HashSet<>();

        for (RowData r : masterRows) {
            if (r.employeeId == null || r.employeeId.isEmpty()) {
                result.valid = false;
//                test.fail("Blank Employee ID at MASTER row " + r.rowNumber);
                test.log(LogStatus.FAIL, "Blank Employee ID at MASTER row " + + r.rowNumber);
                continue;
            }
            if (!masterIds.add(r.employeeId)) {
                result.valid = false;
//                test.fail("Duplicate Employee ID in MASTER : " + r.employeeId);
                test.log(LogStatus.FAIL, "Duplicate Employee ID in MASTER : " + r.employeeId);
            }
        }

        for (RowData r : downloadedRows) {
            if (r.employeeId != null && !r.employeeId.isEmpty()) {
                downloadedIds.add(r.employeeId);
            }
        }

        for (String id : masterIds) {
            if (!downloadedIds.contains(id)) {
                result.valid = false;
//                test.fail("Employee ID missing in DOWNLOADED file : " + id);
                test.log(LogStatus.FAIL, "Employee ID missing in DOWNLOADED file : " + id);
            }
        }

        /* --- 3.2 DOJ ordering validation --- */
        if (checkDOJ || checkNumeric) {

            LocalDate previous = null;

            for (RowData r : masterRows) {

                if (r.doj == null || r.doj.isEmpty()) {
                    result.valid = false;
//                    test.fail("Missing DOJ for Employee " + r.employeeId + " at row " + r.rowNumber);
                    test.log(LogStatus.FAIL, "Missing DOJ for Employee " + r.employeeId + " at row " + r.rowNumber);
                    continue;
                }

                LocalDate current = parseDOJ(r.doj);
                if (current == null) {
                    result.valid = false;
//                    test.fail("Invalid DOJ format for Employee " + r.employeeId + " DOJ=" + r.doj);
                    test.log(LogStatus.FAIL, "Invalid DOJ format for Employee " + r.employeeId + " DOJ=" + r.doj);
                    continue;
                }

                if (previous != null && current.isBefore(previous)) {
                    result.valid = false;
//                    test.fail("DOJ order mismatch at row " + r.rowNumber + " DOJ=" + r.doj);
                    test.log(LogStatus.FAIL, "DOJ order mismatch at row " + r.rowNumber + " DOJ=" + r.doj);
                }

                previous = current;
            }
        }

        /* --- 3.3 Numeric ordering validation --- */
        if (checkNumeric) {

            Integer previous = null;

            for (RowData r : masterRows) {

                String empId = r.employeeId;
                String digits = empId == null ? "" : empId.replaceAll("\\D+", "");

                if (digits.isEmpty()) {
                    result.valid = false;
//                    test.fail("Employee ID has no numeric part : " + empId);
                    test.log(LogStatus.FAIL, "Employee ID has no numeric part : " + empId);
                    continue;
                }

                int current = Integer.parseInt(digits);

                if (previous != null && current < previous) {
                    result.valid = false;
//                    test.fail("Employee ID numeric order mismatch at row " + r.rowNumber + " value=" + empId);
                    test.log(LogStatus.FAIL, "Employee ID numeric order mismatch at row " + r.rowNumber + " value=" + empId);
                }

                previous = current;
            }
        }

        /* =========================
           FINAL RESULT LOG
           ========================= */

        if (result.valid) {
//            test.pass("Excel business validation PASSED");
            test.log(LogStatus.PASS, "Excel business validation PASSED");
        } else {
//            test.fail("Excel business validation FAILED");
            test.log(LogStatus.FAIL, "Excel business validation FAILED");
        }

        return result;
    }

    /* =========================
       DOJ PARSER (simple, safe)
       ========================= */

    private LocalDate parseDOJ(String doj) {
        try {
            DateTimeFormatter f =
                    DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(doj.trim(), f);
        } catch (Exception e) {
            return null;
        }
    }
    
    
    
    
    
    
    
    
    public class MiniHtmlValidationReport {

        private final StringBuilder html = new StringBuilder();
        private final boolean showDOJ;

        public MiniHtmlValidationReport(boolean showDOJ) {
            this.showDOJ = showDOJ;
            startHtml();
        }

        /* =========================
           HTML START + STYLE
           ========================= */
        private void startHtml() {
            html.append("<html>")
                .append("<head>")
                .append("<style>")
                .append("table{border-collapse:collapse;width:100%;}")
                .append("th,td{border:1px solid #999;padding:6px;font-size:12px;}")
                .append("th{background:#f0f0f0;}")
                .append(".pass{background:#e6ffe6;}")
                .append(".fail{background:#ffe6e6;}")
                .append("</style>")
                .append("</head>")
                .append("<body>");
        }

        /* =========================
           MASTER TABLE
           ========================= */
        public void startMasterTable() {
            html.append("<h3>Master Excel Validation</h3>")
                .append("<table>")
                .append("<tr>")
                .append("<th>Employee ID</th>");

            if (showDOJ) {
                html.append("<th>DOJ</th>");
            }

            html.append("<th>Status</th>")
                .append("</tr>");
        }

        public void addMasterRow(
                String employeeId,
                String doj,
                boolean valid
        ) {
            html.append("<tr class='")
                .append(valid ? "pass" : "fail")
                .append("'>");

            html.append("<td>")
                .append(employeeId == null ? "" : employeeId)
                .append("</td>");

            if (showDOJ) {
                html.append("<td>")
                    .append(doj == null ? "" : doj)
                    .append("</td>");
            }

            html.append("<td>")
                .append(valid ? "PASS" : "FAIL")
                .append("</td>")
                .append("</tr>");
        }

        public void endMasterTable() {
            html.append("</table>");
        }

        /* =========================
           DOWNLOADED TABLE
           ========================= */
        public void startDownloadedTable() {
            html.append("<br/>")
                .append("<h3>Downloaded Excel Validation</h3>")
                .append("<table>")
                .append("<tr>")
                .append("<th>Employee ID</th>")
                .append("<th>Status</th>")
                .append("</tr>");
        }

        public void addDownloadedRow(
                String employeeId,
                boolean valid
        ) {
            html.append("<tr class='")
                .append(valid ? "pass" : "fail")
                .append("'>")
                .append("<td>")
                .append(employeeId == null ? "" : employeeId)
                .append("</td>")
                .append("<td>")
                .append(valid ? "PASS" : "FAIL")
                .append("</td>")
                .append("</tr>");
        }

        public void endDownloadedTable() {
            html.append("</table>");
        }

        /* =========================
           LOGS / SUMMARY SECTION
           ========================= */
        public void addLogSummary(List<String> logs) {
            if (logs == null || logs.isEmpty()) {
                return;
            }

            html.append("<br/>")
                .append("<h3>Validation Summary</h3>")
                .append("<ul>");

            for (String log : logs) {
                html.append("<li>")
                    .append(log)
                    .append("</li>");
            }

            html.append("</ul>");
        }

        /* =========================
           FINAL BUILD
           ========================= */
        public String build() {
            html.append("</body></html>");
            return html.toString();
        }
    
    }
}
