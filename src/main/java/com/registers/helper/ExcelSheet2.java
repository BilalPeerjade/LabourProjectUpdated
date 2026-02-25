package com.registers.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.File;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.relevantcodes.extentreports.ExtentTest;

import utils.ExcelF;

public class ExcelSheet2 {

    /**
     * Main entry point (old validateExcelBusinessData style).
     *
     * @param masterFilePath        master Excel path
     * @param downloadedFilePath    downloaded Excel path
     * @param employeeIdColIndex    employee id column index
     * @param dojColIndex           DOJ column index (MASTER only)
     * @param masterFilters         ExcelF filters (MASTER only)
     * @param checkDOJ              DOJ ordering check
     * @param checkNumeric          numeric ordering check
     * @return ValidationResult
     * @throws IOException 
     * @throws FileNotFoundException 
     */
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
    ) throws FileNotFoundException, IOException {
    	
        // ✅ RESULT MUST BE HERE (TOP)
        ValidationResult result = new ValidationResult();
        result.valid = true;
    	
    	
        // STEP 1: skeleton only
        // Next steps me yahin actual logic add hogi
    	
    	
    	
    	List<RowData> masterRows = new ArrayList<>();

    	try (FileInputStream fis = new FileInputStream(new File(masterFilePath));
    	     Workbook workbook = new XSSFWorkbook(fis)) {

    	    Sheet sheet = workbook.getSheetAt(0); // same as old utility

    	    int rowNum = 1;

    	    for (Row row : sheet) {//YAHA conditions aane wali hai..

    	        // Skip header (assumption same as old code)
    	        if (row.getRowNum() == 0) {
    	            continue;
    	        }
    	        
    	     // ExcelExclude (optional)
    	        if (excelExclude != null && excelExclude.shouldExclude(row)) {
    	            continue;
    	        }


    	        // -------------------------
    	        // Apply ExcelF filters
    	        // -------------------------
    	        boolean skip = false;

    	        if (masterFilters != null) {
    	            for (ExcelF filter : masterFilters) {

    	                Cell filterCell = row.getCell(filter.getColumnIndex());
    	                String cellValue = filterCell == null
    	                        ? ""
    	                        : filterCell.toString().trim();

    	                if (!filter.getValues().contains(cellValue)) {
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

    	        masterRows.add(new RowData(empId, doj, rowNum));
    	        rowNum++;
    	    }
    	}
    	
    	

    	//-------
    	List<RowData> downloadedRows = new ArrayList<>();

    	try (FileInputStream fis = new FileInputStream(new File(downloadedFilePath));
    	     Workbook workbook = new XSSFWorkbook(fis)) {

    	    Sheet sheet = workbook.getSheetAt(0);

    	    int rowNum = 1;

    	    for (Row row : sheet) {

    	        if (row.getRowNum() == 0) {
    	            continue;
    	        }

    	        Cell empCell = row.getCell(employeeIdColIndex);
    	        String empId = empCell == null ? null : empCell.toString().trim();

    	        downloadedRows.add(new RowData(empId, null, rowNum));
    	        rowNum++;
    	    }
    	}
    	
    	
    	//----------step4-------
    	Set<String> masterIds = new HashSet<>();
    	Set<String> downloadedIds = new HashSet<>();

    	// MASTER Employee ID checks
    	for (RowData r : masterRows) {

    	    if (r.employeeId == null || r.employeeId.trim().isEmpty()) {
    	        result.valid = false;
    	        continue;
    	    }

    	    if (!masterIds.add(r.employeeId)) {
    	        result.valid = false; // duplicate
    	    }
    	}

    	// DOWNLOADED Employee IDs
    	for (RowData r : downloadedRows) {
    	    if (r.employeeId != null && !r.employeeId.trim().isEmpty()) {
    	        downloadedIds.add(r.employeeId);
    	    }
    	}

    	// Missing IDs in downloaded
    	for (String id : masterIds) {
    	    if (!downloadedIds.contains(id)) {
    	        result.valid = false;
    	    }
    	}
    	
    	if (checkDOJ || checkNumeric) {

    	    LocalDate previousDOJ = null;

    	    for (RowData r : masterRows) {

    	        if (r.doj == null || r.doj.isEmpty()) {
    	            result.valid = false;
    	            continue;
    	        }

    	        LocalDate currentDOJ = parseDOJ(r.doj); // already discussed

    	        if (previousDOJ != null && currentDOJ.isBefore(previousDOJ)) {
    	            result.valid = false;
    	        }

    	        previousDOJ = currentDOJ;
    	    }
    	}
    	
    	
    	//Rule: DOJ ke baad Employee IDs numeric order me hone chahiye
    	if (checkNumeric) {

    	    Integer previous = null;

    	    for (RowData r : masterRows) {

    	        String empId = r.employeeId;
    	        String digits = empId.replaceAll("\\D+", "");

    	        if (digits.isEmpty()) {
    	            result.valid = false;
    	            continue;
    	        }

    	        int current = Integer.parseInt(digits);

    	        if (previous != null && current < previous) {
    	            result.valid = false;
    	        }

    	        previous = current;
    	    }
    	}
    	
    	
    	
    	//---------Step5 HTML Report-----
    	boolean showDOJ = checkDOJ || checkNumeric;

    	MiniHtmlReport report = new MiniHtmlReport(showDOJ);

    	// MASTER
    	report.masterHeader();
    	for (RowData r : masterRows) {
    	    report.masterRow(r, true); // abhi simple, baad me row-level fail mark kar sakte ho
    	}

    	// DOWNLOADED
    	report.downloadedHeader();
    	for (RowData r : downloadedRows) {
    	    report.downloadedRow(r, true);
    	}

    	result.htmlReport = report.build();

    	
    	

    	

//        ValidationResult result = new ValidationResult();
//        result.valid = true;
        result.htmlReport = "";
        return result;
    }

    // -------------------------
    // Result holder (inner)
    // -------------------------
    static class ValidationResult {
        boolean valid;
        String htmlReport;

        public boolean isValid() {
            return valid;
        }

        public String getHtmlReport() {
            return htmlReport;
        }
    }
    
    
    static class RowData {
        String employeeId;
        String doj;          // raw DOJ string (MASTER only)
        int rowNumber;

        RowData(String employeeId, String doj, int rowNumber) {
            this.employeeId = employeeId;
            this.doj = doj;
            this.rowNumber = rowNumber;
        }
    }
    
    private LocalDate parseDOJ(String doj) {
        if (doj == null || doj.trim().isEmpty()) {
            return null;
        }

        // Simple default format (abhi ke liye)
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            return LocalDate.parse(doj.trim(), formatter);
        } catch (Exception e) {
            return null;
        }
    }

    
    
    
    
    
    
    
    static class ExcelExclude {

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
    
    
    static class MiniHtmlReport {

        StringBuilder html = new StringBuilder();
        boolean showDOJ;

        MiniHtmlReport(boolean showDOJ) {
            this.showDOJ = showDOJ;
            start();
        }

        void start() {
            html.append("<html><head><style>")
                .append("table{border-collapse:collapse;width:100%;}")
                .append("th,td{border:1px solid #999;padding:6px;font-size:12px;}")
                .append("th{background:#f0f0f0;}")
                .append(".fail{background:#ffe6e6;}")
                .append(".pass{background:#e6ffe6;}")
                .append("</style></head><body>");
        }

        void masterHeader() {
            html.append("<h3>Master Excel Validation</h3><table><tr>")
                .append("<th>Employee ID</th>");
            if (showDOJ) html.append("<th>DOJ</th>");
            html.append("<th>Status</th></tr>");
        }

        void masterRow(RowData r, boolean valid) {
            html.append("<tr class='").append(valid ? "pass" : "fail").append("'>")
                .append("<td>").append(r.employeeId).append("</td>");
            if (showDOJ) html.append("<td>").append(r.doj).append("</td>");
            html.append("<td>").append(valid ? "PASS" : "FAIL").append("</td></tr>");
        }

        void downloadedHeader() {
            html.append("</table><br/><h3>Downloaded Excel Validation</h3>")
                .append("<table><tr><th>Employee ID</th><th>Status</th></tr>");
        }

        void downloadedRow(RowData r, boolean valid) {
            html.append("<tr class='").append(valid ? "pass" : "fail").append("'>")
                .append("<td>").append(r.employeeId).append("</td>")
                .append("<td>").append(valid ? "PASS" : "FAIL").append("</td></tr>");
        }

        String build() {
            html.append("</table></body></html>");
            return html.toString();
        }
    }


    



    
    

}
