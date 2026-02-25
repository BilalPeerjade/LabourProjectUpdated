package com.registers.helper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.ss.usermodel.*;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utils.ExcelF;
import utils.ExcelFileDetails;
import utils.ExcelValueNormalizer;



public class ExcelSheetNameBusinessValidator {

    private static final int MAX_HTML_ROWS = 5;
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("(\\d+)");

    private ExcelSheetNameBusinessValidator() {}

    // ======================= ENTRY METHOD =======================
    public static ValidationResult validateExcelBusinessData(
    		ExcelFileDetails masterFile,
            File downloadedFile,
            int empIdColIndex,
            int dojColIndex,
            List<ExcelF> masterFilters,
            boolean checkDOJ,
            boolean checkNumeric,
            ExcelExclude exclude,
            boolean generateHtmlReport,
            ExtentTest test
    ) 
    
    {
        ValidationResult result = new ValidationResult(true);

        Workbook masterWb = null;
        Workbook downloadedWb = null;

        boolean validationFailed = false;

        List<MasterRow> filteredMasterRows = new ArrayList<>();
        List<String> downloadedSheetNames = new ArrayList<>();

        List<String> missingEmpIds = new ArrayList<>();
        List<String> duplicateEmpIds = new ArrayList<>();
        List<String> dojFailures = new ArrayList<>();
        List<String> numericFailures = new ArrayList<>();

        // ================= PRE CHECKS =================
        if (masterFile == null
                || masterFile.getFilePath() == null
                || masterFile.getFilePath().trim().isEmpty()) {

            test.log(LogStatus.FAIL, "❌ Master file path is null or empty.");
            validationFailed = true;
        }

        File masterExcelFile = null;
        if (!validationFailed) {
            masterExcelFile = new File(masterFile.getFilePath());
            if (!masterExcelFile.exists()) {
                test.log(LogStatus.FAIL,
                        "❌ Master file not found at path: " + masterFile.getFilePath());
                validationFailed = true;
            }
        }

        if (downloadedFile == null || !downloadedFile.exists()) {
            test.log(LogStatus.FAIL, "❌ Downloaded file is null or missing.");
            validationFailed = true;
        }

        try {
            // ================= READ MASTER =================
            if (!validationFailed) {
                masterWb = WorkbookFactory.create(new FileInputStream(masterExcelFile));
                Sheet sheet = masterWb.getSheetAt(0);

                for (int r = sheet.getFirstRowNum() + 1; r <= sheet.getLastRowNum(); r++) {
                    Row row = sheet.getRow(r);
                    if (row == null) continue;

                    // EMP ID (preserve case)
                    Cell empCell = row.getCell(empIdColIndex);
                    if (empCell == null) continue;
                    empCell.setCellType(CellType.STRING);
                    String empId = empCell.getStringCellValue().trim();

                    // DOJ (proper date handling)
                    Date dojDate = null;
                    String dojStr = null;

                    if (checkDOJ || checkNumeric) {
                        Cell dojCell = row.getCell(dojColIndex);
                        if (dojCell != null) {
                            if (dojCell.getCellType() == CellType.NUMERIC
                                    && DateUtil.isCellDateFormatted(dojCell)) {

                                dojDate = dojCell.getDateCellValue();
                            } else {
                                dojCell.setCellType(CellType.STRING);
                                dojStr = dojCell.getStringCellValue().trim();
                                dojDate = parseDOJ(dojStr);
                            }
                        }
                    }

                    if (exclude != null && exclude.shouldExclude(row)) continue;
                    if (!passesFilters(row, masterFilters)) continue;

                    filteredMasterRows.add(
                            new MasterRow(
                                    r + 1,
                                    empId,
                                    dojDate,
                                    formatDOJ(dojDate)
                            )
                    );
                }
            }

            // ================= READ DOWNLOADED (ALL SHEETS) =================
            downloadedWb = WorkbookFactory.create(new FileInputStream(downloadedFile));
            for (int i = 0; i < downloadedWb.getNumberOfSheets(); i++) {
                downloadedSheetNames.add(
                        downloadedWb.getSheetName(i).trim()
                );
            }

            // ================= EMPLOYEE ID CHECK =================
            Set<String> seen = new HashSet<>();

            for (MasterRow mr : filteredMasterRows) {

                if (!seen.add(mr.empId.toUpperCase())) {
                    duplicateEmpIds.add(mr.empId);
                    validationFailed = true;
                }

                boolean present = false;
                for (String sheet : downloadedSheetNames) {
                    if (sheet.equalsIgnoreCase(mr.empId)) {
                        present = true;
                        break;
                    }
                }

                if (!present) {
                    missingEmpIds.add(mr.empId);
                    validationFailed = true;
                }
            }

            // ================= DOJ ORDER CHECK =================
            if (checkDOJ || checkNumeric) {
                Date prev = null;

                for (MasterRow mr : filteredMasterRows) {
                    if (mr.dojDate == null) {
                        dojFailures.add("[" + mr.empId + " : " + mr.dojStr + "]");
                        validationFailed = true;
                        continue;
                    }

                    if (prev != null && mr.dojDate.before(prev)) {
                        dojFailures.add("[" + mr.empId + " : " + mr.dojStr + "]");
                        validationFailed = true;
                    }
                    prev = mr.dojDate;
                }
            }

            // ================= NUMERIC ORDER CHECK =================
            if (checkNumeric) {
                Integer prev = null;

                for (MasterRow mr : filteredMasterRows) {
                    Integer curr = extractNumeric(mr.empId);
                    if (curr == null) {
                        numericFailures.add(mr.empId);
                        validationFailed = true;
                        continue;
                    }

                    if (prev != null && curr < prev) {
                        numericFailures.add(mr.empId);
                        validationFailed = true;
                    }
                    prev = curr;
                }
            }

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "❌ Exception during validation: " + e.getMessage());
            validationFailed = true;
        }
        finally {
            try { if (masterWb != null) masterWb.close(); } catch (Exception ignored) {}
            try { if (downloadedWb != null) downloadedWb.close(); } catch (Exception ignored) {}
        }

        // ================= CONSOLIDATED LOGS =================
        if (!missingEmpIds.isEmpty()) {
            test.log(LogStatus.FAIL,
                    "❌ Missing Employee IDs: "
                            + String.join(", ", missingEmpIds));
        }

        if (!duplicateEmpIds.isEmpty()) {
            test.log(LogStatus.FAIL,
                    "❌ Duplicate Employee IDs in master: "
                            + String.join(", ", duplicateEmpIds));
        }

        if (!dojFailures.isEmpty()) {
            test.log(LogStatus.FAIL,
                    "❌ DOJ ordering failed for: "
                            + String.join(", ", dojFailures));
        }

        if (!numericFailures.isEmpty()) {
            test.log(LogStatus.FAIL,
                    "❌ Numeric ordering failed for Employee IDs: "
                            + String.join(", ", numericFailures));
        }

        // ================= HTML REPORT (ALWAYS LAST) =================
        HTMLSheetNameReport.generate(
                test,
                filteredMasterRows,
                downloadedSheetNames,
                (checkDOJ || checkNumeric),
                5
        );


        if (validationFailed) {
            result.valid = false;
            return result;
        }

        test.log(LogStatus.PASS,
                "✅ Excel SheetName validation passed | "
                        + "Filtered Master IDs: "
                        + filteredMasterRows.size()
                        + " | Downloaded Sheets: "
                        + downloadedSheetNames.size());

        return result;
    }

    
    

     
    
    
    

    // ======================= HELPERS =======================
    
    private static Date parseDOJ(String doj) {
        try {
            return new java.text.SimpleDateFormat("dd-MM-yyyy").parse(doj);
        } catch (Exception e) {
            return null;
        }
    }
    
    private static String normalizeCell(Cell cell) {
        if (cell == null) return "";

        cell.setCellType(CellType.STRING);
        return ExcelValueNormalizer.normalize(cell.getStringCellValue());
    }

    private static boolean passesFilters(Row row, List<ExcelF> filters) {
        if (filters == null || filters.isEmpty()) {
            return true;
        }

        for (ExcelF f : filters) {
            Cell cell = row.getCell(f.getColumnIndex());
            if (cell == null) {
                return false;
            }

            cell.setCellType(CellType.STRING);
            String cellVal = cell.getStringCellValue().trim();

            boolean matched = false;
            for (String allowed : f.getValues()) {
                if (cellVal.equalsIgnoreCase(allowed.trim())) {
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                return false;
            }
        }
        return true;
    }



    private static boolean isExcluded(Row row, ExcelExclude exclude) {
        if (exclude == null) return false;
        return exclude.shouldExclude(row);
    }

    private static String normalize(Cell cell) {
    	return normalizeCell(cell);
    }

    private static Integer extractNumeric(String empId) {
        Matcher m = NUMERIC_PATTERN.matcher(empId);
        return m.find() ? Integer.valueOf(m.group(1)) : null;
    }

    // ======================= INNER MODELS =======================

    
    private static class MasterRow {
        int rowNum;
        String empId;
        Date dojDate;
        String dojStr;

        MasterRow(int rowNum, String empId, Date dojDate, String dojStr) {
            this.rowNum = rowNum;
            this.empId = empId;
            this.dojDate = dojDate;
            this.dojStr = dojStr;
        }
    }
    
    private static String formatDOJ(Date date) {
        if (date == null) return "";
        return new java.text.SimpleDateFormat("dd-MM-yyyy").format(date);
    }


    public static class ValidationResult {
        public boolean valid;
        ValidationResult(boolean v) { valid = v; }
        ValidationResult fail() { valid = false; return this; }
    }
    
    //---------ExcelExclude----------
    public static class ExcelExclude {
        private final int columnIndex;
        private final List<String> excludedValues;

        public ExcelExclude(int columnIndex, List<String> excludedValues) {
            this.columnIndex = columnIndex;
            this.excludedValues = excludedValues;
        }

        boolean shouldExclude(Row row) {
            Cell cell = row.getCell(columnIndex);
            if (cell == null) {
                return false;
            }

            cell.setCellType(CellType.STRING);
            String value = cell.getStringCellValue().trim();
            return excludedValues.contains(value);
        }
    }
    

    //---------------HTML----------------
    
    public class HTMLSheetNameReport {

        // ================= OLD SIGNATURE =================
        public static void generate(
                List<MasterRow> masterRows,
                List<String> downloadedSheetNames,
                boolean showDOJ,
                int maxRows
        ) {
            generate(null, masterRows, downloadedSheetNames, showDOJ, maxRows);
        }

        // ================= EXTENT AWARE =================
        public static void generate(
                ExtentTest test,
                List<MasterRow> masterRows,
                List<String> downloadedSheetNames,
                boolean showDOJ,
                int maxRows
        ) {

            BufferedWriter bw = null;

            try {
                File reportDir = new File("reports");
                if (!reportDir.exists()) {
                    reportDir.mkdirs();
                }

                File htmlFile = new File(reportDir, "SheetNameValidationReport.html");
                bw = new BufferedWriter(new FileWriter(htmlFile));

                String tableHtml = buildTable(
                        masterRows,
                        downloadedSheetNames,
                        showDOJ,
                        maxRows
                );

                // ================= FILE HTML =================
                StringBuilder fileHtml = new StringBuilder();
                fileHtml.append("<html><head><style>");
                fileHtml.append("body{font-family:Arial;font-size:13px;}");
                fileHtml.append("table{border-collapse:collapse;width:100%;table-layout:fixed;}");
                fileHtml.append("th,td{border:1px solid #ccc;padding:6px;text-align:center;}");
                fileHtml.append("th{background:#f2f2f2;font-weight:bold;}");
                fileHtml.append("</style></head><body>");

                fileHtml.append("<h3>Excel SheetName Validation Summary</h3>");
                fileHtml.append("<p>");
                fileHtml.append("Total Master Records : ").append(masterRows.size()).append("<br>");
                fileHtml.append("Total Downloaded Sheets : ").append(downloadedSheetNames.size());
                fileHtml.append("</p>");

                fileHtml.append(tableHtml);
                fileHtml.append("</body></html>");

                bw.write(fileHtml.toString());

                // ================= SINGLE EXTENT LOG =================
                if (test != null) {
                    test.log(
                            LogStatus.INFO,
                            "<b>Excel SheetName Validation Summary</b><br>" +
                            "Total Master Records : " + masterRows.size() + "<br>" +
                            "Total Downloaded Sheets : " + downloadedSheetNames.size() +
                            "<br><br>" +
                            tableHtml
                    );
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (bw != null) bw.close(); } catch (Exception ignored) {}
            }
        }

        // ================= TABLE BUILDER =================
        private static String buildTable(
                List<MasterRow> masterRows,
                List<String> downloadedSheetNames,
                boolean showDOJ,
                int maxRows
        ) {

            int limit = Math.min(
                    Math.min(masterRows.size(), downloadedSheetNames.size()),
                    Math.min(maxRows, 5)
            );

            StringBuilder html = new StringBuilder();

            html.append("<table>");
            html.append("<colgroup>");
            html.append("<col style='width:6%'>");   // Row
            html.append("<col style='width:22%'>");  // Master
            if (showDOJ) html.append("<col style='width:18%'>"); // DOJ
            html.append("<col style='width:22%'>");  // Downloaded
            html.append("<col style='width:12%'>");  // Result
            html.append("</colgroup>");

            // ---------- HEADER ----------
            html.append("<tr>");
            html.append("<th>ROW</th>");

            html.append("<th>");
            html.append("MASTER VALUE<br>");
            html.append("<small style='font-weight:400;'>Column ");
            html.append((char) ('D')); // Static column index (safe) // For now it is hard coded will take time to make dynamic
            html.append("</small>");
            html.append("</th>");

            if (showDOJ) {
                html.append("<th>DOJ</th>");
            }

            html.append("<th>DOWNLOADED VALUE</th>");
            html.append("<th>RESULT</th>");
            html.append("</tr>");

            // ---------- ROWS ----------
            for (int i = 0; i < limit; i++) {
                MasterRow mr = masterRows.get(i);
                String downloaded = downloadedSheetNames.get(i);

                boolean match =
                        mr.empId != null &&
                        mr.empId.equalsIgnoreCase(downloaded);

                html.append("<tr>");
                html.append("<td>").append(i + 1).append("</td>");
                html.append("<td>").append(mr.empId).append("</td>");

                if (showDOJ) {
                    html.append("<td>")
                            .append(mr.dojStr == null ? "-" : mr.dojStr)
                            .append("</td>");
                }

                html.append("<td>").append(downloaded).append("</td>");
                html.append("<td>").append(pill(match ? "PASS" : "FAIL", match)).append("</td>");
                html.append("</tr>");
            }

            html.append("</table>");
            return html.toString();
        }

        // ================= PASS / FAIL PILL =================
        private static String pill(String text, boolean pass) {
            return "<span style='display:inline-block; padding:2px 12px; border-radius:999px; " +
                    "background:" + (pass ? "#ecfdf5" : "#fef2f2") + "; " +
                    "color:" + (pass ? "#065f46" : "#991b1b") + "; font-weight:700;'>" +
                    text + "</span>";
        }
        
    }
}
    
    
    
    
/**    public class HTMLSheetNameReport {//Report is generating but not loking good 

        // ================= OLD SIGNATURE =================
        public static void generate(
                List<MasterRow> masterRows,
                List<String> downloadedSheetNames,
                boolean showDOJ,
                int maxRows
        ) {
            generate(null, masterRows, downloadedSheetNames, showDOJ, maxRows);
        }

        // ================= EXTENT AWARE =================
        public static void generate(
                ExtentTest test,
                List<MasterRow> masterRows,
                List<String> downloadedSheetNames,
                boolean showDOJ,
                int maxRows
        ) {

            BufferedWriter bw = null;

            try {
                File reportDir = new File("reports");
                if (!reportDir.exists()) {
                    reportDir.mkdirs();
                }

                File htmlFile = new File(reportDir, "SheetNameValidationReport.html");
                bw = new BufferedWriter(new FileWriter(htmlFile));

                // ================= FILE HTML =================
                StringBuilder fileHtml = new StringBuilder();
                fileHtml.append("<html><head><style>");
                fileHtml.append("body{font-family:Arial;font-size:13px;}");
                fileHtml.append("table{border-collapse:collapse;width:100%;}");
                fileHtml.append("th,td{border:1px solid #999;padding:6px;text-align:center;}");
                fileHtml.append("th{background:#f2f2f2;font-weight:bold;}");
                fileHtml.append("</style></head><body>");

                fileHtml.append("<h3>Excel SheetName Validation Summary</h3>");
                fileHtml.append("<p>");
                fileHtml.append("Total Master Records : ").append(masterRows.size()).append("<br>");
                fileHtml.append("Total Downloaded Sheets : ").append(downloadedSheetNames.size());
                fileHtml.append("</p>");

                fileHtml.append(buildTable(masterRows, downloadedSheetNames, showDOJ, maxRows));

                fileHtml.append("</body></html>");
                bw.write(fileHtml.toString());

                // ================= SINGLE EXTENT LOG =================
                if (test != null) {
                    String extentHtml =
                            "<b>Excel SheetName Validation Summary</b><br>" +
                            "Total Master Records : " + masterRows.size() + "<br>" +
                            "Total Downloaded Sheets : " + downloadedSheetNames.size() +
                            "<br><br>" +
                            buildExtentTable(masterRows, downloadedSheetNames, showDOJ, maxRows);

                    test.log(LogStatus.INFO, extentHtml);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (bw != null) bw.close(); } catch (Exception ignored) {}
            }
        }

        // ================= EXTENT + FILE TABLE =================
        private static String buildTable(
                List<MasterRow> masterRows,
                List<String> downloadedSheetNames,
                boolean showDOJ,
                int maxRows
        ) {

            int limit = Math.min(
                    Math.min(masterRows.size(), downloadedSheetNames.size()),
                    Math.min(maxRows, 5)
            );

            StringBuilder html = new StringBuilder();

            html.append("<table>");
            html.append("<tr>");
            html.append("<th>Row</th>");
            html.append("<th>Master Value</th>");
            if (showDOJ) html.append("<th>DOJ</th>");
            html.append("<th>Downloaded Value</th>");
            html.append("<th>Result</th>");
            html.append("</tr>");

            for (int i = 0; i < limit; i++) {
                MasterRow mr = masterRows.get(i);
                String downloaded = downloadedSheetNames.get(i);

                boolean match = mr.empId != null &&
                        mr.empId.equalsIgnoreCase(downloaded);

                html.append("<tr>");
                html.append("<td>").append(i + 1).append("</td>");
                html.append("<td>").append("Column ").append((char)('A' + i)).append("</td>");

                if (showDOJ) {
                    html.append("<td>")
                            .append(mr.dojStr == null ? "-" : mr.dojStr)
                            .append("</td>");
                }

                html.append("<td>").append(downloaded).append("</td>");
                html.append("<td>").append(pill(match ? "PASS" : "FAIL", match)).append("</td>");
                html.append("</tr>");
            }

            html.append("</table>");
            return html.toString();
        }

        // ================= EXTENT SAFE TABLE =================
        private static String buildExtentTable(
                List<MasterRow> masterRows,
                List<String> downloadedSheetNames,
                boolean showDOJ,
                int maxRows
        ) {
            return buildTable(masterRows, downloadedSheetNames, showDOJ, maxRows);
        }

        // ================= PASS / FAIL PILL =================
        private static String pill(String text, boolean pass) {
            return "<span style='display:inline-block; padding:2px 12px; border-radius:999px; " +
                    "background:" + (pass ? "#ecfdf5" : "#fef2f2") + "; " +
                    "color:" + (pass ? "#065f46" : "#991b1b") + "; font-weight:700;'>" +
                    text + "</span>";
        }
    }
}
    
    */
    
    
 /*   public class HTMLSheetNameReport { //Report is generating but not loking good 

        // ================= OLD SIGNATURE =================
        public static void generate(
                List<MasterRow> masterRows,
                List<String> downloadedSheetNames,
                boolean showDOJ,
                int maxRows
        ) {
            generate(null, masterRows, downloadedSheetNames, showDOJ, maxRows);
        }

        // ================= EXTENT AWARE =================
        public static void generate(
                ExtentTest test,
                List<MasterRow> masterRows,
                List<String> downloadedSheetNames,
                boolean showDOJ,
                int maxRows
        ) {

            BufferedWriter bw = null;

            try {
                File reportDir = new File("reports");
                if (!reportDir.exists()) {
                    reportDir.mkdirs();
                }

                File htmlFile = new File(reportDir, "SheetNameValidationReport.html");
                bw = new BufferedWriter(new FileWriter(htmlFile));

                // ================= HTML FOR FILE =================
                StringBuilder fileHtml = new StringBuilder();

                fileHtml.append("<html><head>");
                fileHtml.append("<style>");
                fileHtml.append("body{font-family:Arial;font-size:13px;}");
                fileHtml.append("table{border-collapse:collapse;width:100%;}");
                fileHtml.append("th,td{border:1px solid #999;padding:6px;text-align:center;}");
                fileHtml.append("th{background:#f2f2f2;}");
                fileHtml.append("</style>");
                fileHtml.append("</head><body>");

                fileHtml.append("<h3>Excel SheetName Validation Summary</h3>");
                fileHtml.append("<p>");
                fileHtml.append("Total Master Records : ").append(masterRows.size()).append("<br>");
                fileHtml.append("Total Downloaded Sheets : ").append(downloadedSheetNames.size());
                fileHtml.append("</p>");

                fileHtml.append(buildTable(masterRows, downloadedSheetNames, showDOJ, maxRows));

                fileHtml.append("</body></html>");

                bw.write(fileHtml.toString());

                // ================= EXTENT SAFE HTML =================
                System.out.println("--------upside condition--------");
                if (test != null) { System.out.println("--------inside condition--------");

                    test.log(LogStatus.INFO,
                            "<b>Excel SheetName Validation Summary</b><br>" +
                            "Total Master Records : " + masterRows.size() + "<br>" +
                            "Total Downloaded Sheets : " + downloadedSheetNames.size()
                    );

                    test.log(LogStatus.INFO, buildExtentTable(
                            masterRows, downloadedSheetNames, showDOJ, maxRows
                    ));
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try { if (bw != null) bw.close(); } catch (Exception ignored) {}
            }
        }

        // ================= FILE HTML TABLE =================
        private static String buildTable(
                List<MasterRow> masterRows,
                List<String> downloadedSheetNames,
                boolean showDOJ,
                int maxRows
        ) {

            int limit = Math.min(
                    Math.min(masterRows.size(), downloadedSheetNames.size()),
                    Math.min(maxRows, 5)
            );

            StringBuilder html = new StringBuilder();

            html.append("<table>");
            html.append("<tr>");
            html.append("<th>Row</th>");
            html.append("<th>Master Value</th>");
            html.append("<th>Downloaded Value</th>");
            if (showDOJ) html.append("<th>DOJ</th>");
            html.append("<th>Result</th>");
            html.append("</tr>");

            for (int i = 0; i < limit; i++) {
                MasterRow mr = masterRows.get(i);
                String downloaded = downloadedSheetNames.get(i);

                boolean match = mr.empId != null &&
                        mr.empId.equalsIgnoreCase(downloaded);

                html.append("<tr>");
                html.append("<td>").append(i + 1).append("</td>");
                html.append("<td>").append(mr.empId).append("</td>");
                html.append("<td>").append(downloaded).append("</td>");

                if (showDOJ) {
                    html.append("<td>")
                            .append(mr.dojStr == null ? "-" : mr.dojStr)
                            .append("</td>");
                }

                if (match) {
                    html.append("<td style='color:green;font-weight:bold'>PASS</td>");
                } else {
                    html.append("<td style='color:red;font-weight:bold'>FAIL</td>");
                }

                html.append("</tr>");
            }

            html.append("</table>");
            return html.toString();
        }

        // ================= EXTENT SAFE TABLE =================
        private static String buildExtentTable(
                List<MasterRow> masterRows,
                List<String> downloadedSheetNames,
                boolean showDOJ,
                int maxRows
        ) {

            int limit = Math.min(
                    Math.min(masterRows.size(), downloadedSheetNames.size()),
                    Math.min(maxRows, 5)
            );

            StringBuilder html = new StringBuilder();

            html.append("<table border='1' style='border-collapse:collapse;width:100%;font-size:12px;'>");
            html.append("<tr style='background:#f2f2f2;'>");
            html.append("<th>Row</th>");
            html.append("<th>Master Value</th>");
            html.append("<th>Downloaded Value</th>");
            if (showDOJ) html.append("<th>DOJ</th>");
            html.append("<th>Result</th>");
            html.append("</tr>");

            for (int i = 0; i < limit; i++) {
                MasterRow mr = masterRows.get(i);
                String downloaded = downloadedSheetNames.get(i);

                boolean match = mr.empId != null &&
                        mr.empId.equalsIgnoreCase(downloaded);

                html.append("<tr>");
                html.append("<td>").append(i + 1).append("</td>");
                html.append("<td>").append(mr.empId).append("</td>");
                html.append("<td>").append(downloaded).append("</td>");

                if (showDOJ) {
                    html.append("<td>")
                            .append(mr.dojStr == null ? "-" : mr.dojStr)
                            .append("</td>");
                }

                if (match) {
                    html.append("<td style='color:green;font-weight:bold'>PASS</td>");
                } else {
                    html.append("<td style='color:red;font-weight:bold'>FAIL</td>");
                }

                html.append("</tr>");
            }

            html.append("</table>");
            return html.toString();
        }
        
    }
}*/
    
    
    
    
    
    
    
    //----------HTML Report-------
/**    static class HTMLSheetNameReport { //Report is not generating

        // ✅ OLD SIGNATURE (NO EXTENT) — caller unchanged
        static void generate(
                List<MasterRow> masterRows,
                List<String> downloadedSheetNames,
                boolean showDOJ,
                int maxRows
        ) {
            generate(null, masterRows, downloadedSheetNames, showDOJ, maxRows);
        }
        
     // ✅ NEW SIGNATURE (EXTENT AWARE) — FINAL CLEAN UI
        static void generate(
                ExtentTest test,
                List<MasterRow> masterRows,
                List<String> downloadedSheetNames,
                boolean showDOJ,
                int maxRows
        ) {

            BufferedWriter bw = null;
            StringBuilder html = new StringBuilder();

            try {
                File reportDir = new File("reports");
                if (!reportDir.exists()) {
                    reportDir.mkdirs();
                }

                File htmlFile = new File(reportDir, "SheetNameValidationReport.html");
                bw = new BufferedWriter(new FileWriter(htmlFile));

                // ===== HTML HEADER =====
                html.append("<html><head>");
                html.append("<style>");
                html.append("body{font-family:Arial;font-size:13px;color:#333;}");
                html.append("table{border-collapse:collapse;width:100%;margin-top:10px;}");
                html.append("th,td{border:1px solid #ccc;padding:6px;text-align:left;}");
                html.append("th{background:#f2f2f2;font-weight:bold;}");
                html.append(".header{font-weight:bold;margin-top:20px;font-size:14px;}");
                html.append("</style></head><body>");

                // ===== SUMMARY =====
                html.append("<div class='header'>Excel SheetName Validation Summary</div>");
                html.append("<ul>");
                html.append("<li>Total Master Records : ").append(masterRows.size()).append("</li>");
                html.append("<li>Total Downloaded Sheets : ").append(downloadedSheetNames.size()).append("</li>");
                html.append("</ul>");

                // ===== SINGLE CONSOLIDATED TABLE =====
                html.append("<div class='header'>Sheet Name Validation (Top ")
                    .append(maxRows)
                    .append(" Records)</div>");

                html.append("<table>");
                html.append("<tr>");
                html.append("<th>Row</th>");
                html.append("<th>Master Employee ID</th>");
                html.append("<th>Downloaded Employee ID</th>");
                if (showDOJ) {
                    html.append("<th>DOJ</th>");
                }
                html.append("<th>Result</th>");
                html.append("</tr>");

                int limit = Math.min(
                        maxRows,
                        Math.min(masterRows.size(), downloadedSheetNames.size())
                );

                for (int i = 0; i < limit; i++) {
                    MasterRow mr = masterRows.get(i);
                    String downloadedEmpId = downloadedSheetNames.get(i);

                    boolean empMatch =
                            mr.empId != null &&
                            mr.empId.equalsIgnoreCase(downloadedEmpId);

                    html.append("<tr>");
                    html.append("<td>").append(i + 1).append("</td>");
                    html.append("<td>").append(mr.empId).append("</td>");
                    html.append("<td>").append(downloadedEmpId).append("</td>");

                    if (showDOJ) {
                        html.append("<td>")
                            .append(mr.dojStr == null ? "-" : mr.dojStr)
                            .append("</td>");
                    }

                    if (empMatch) {
                        html.append("<td style='color:green;font-weight:bold'>PASS</td>");
                    } else {
                        html.append("<td style='color:red;font-weight:bold'>FAIL</td>");
                    }

                    html.append("</tr>");
                }

                html.append("</table>");
                html.append("</body></html>");

                // ===== FILE WRITE =====
                bw.write(html.toString());

                // ===== EXTENT REPORT v2 PRINT =====
                System.out.println("--------------Not inside block-----------");
                if (test != null) {
                	System.out.println("--------------Inside inside block-----------");
                    test.log(LogStatus.INFO, html.toString(), "");
                    
                    System.out.println("-----BILAL    REPORTTTTTT-----------");
                }
                

            } catch (Exception ignored) {
            } finally {
                try { if (bw != null) bw.close(); } catch (Exception ignored) {}
            }
        }
    }*/
