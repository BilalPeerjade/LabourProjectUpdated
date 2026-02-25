package com.registers.helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.ExcelFileDetails;

public class ExcelSheet {
	
	
	/**
	 * Ye utility sheetNames verify karne ke liye banayi gayi hai
	 */
	public class ExcelBusinessValidationConfig {

	    // Always true logically – no flag needed
	    // Employee IDs validation is mandatory

	    private boolean checkAgainstSheetName;      // DOJ ordering only
	    private boolean validateEmployeeIdNumeric;  // Numeric + DOJ implicit

	    // Multiple DOJ formats (extensible)
	    private List<String> dojFormats;

	    public ExcelBusinessValidationConfig() {
	        this.dojFormats = new ArrayList<>();
	    }

	    public boolean isCheckAgainstSheetName() {
	        return checkAgainstSheetName;
	    }

	    public void setCheckAgainstSheetName(boolean checkAgainstSheetName) {
	        this.checkAgainstSheetName = checkAgainstSheetName;
	    }

	    public boolean isValidateEmployeeIdNumeric() {
	        return validateEmployeeIdNumeric;
	    }

	    public void setValidateEmployeeIdNumeric(boolean validateEmployeeIdNumeric) {
	        this.validateEmployeeIdNumeric = validateEmployeeIdNumeric;
	    }

	    public List<String> getDojFormats() {
	        return dojFormats;
	    }

	    public void setDojFormats(List<String> dojFormats) {
	        this.dojFormats = dojFormats;
	    }
	}
	
	
	
	
	//class2:
	public class ExcelBusinessValidationResult {

	    private boolean valid;
	    private List<String> errors;
	    private List<String> logs;

	    public ExcelBusinessValidationResult() {
	        this.valid = true;
	        this.errors = new ArrayList<>();
	        this.logs = new ArrayList<>();
	    }

	    public void addError(String error) {
	        this.valid = false;
	        this.errors.add(error);
	    }

	    public void addLog(String log) {
	        this.logs.add(log);
	    }

	    public boolean isValid() {
	        return valid;
	    }

	    public List<String> getErrors() {
	        return errors;
	    }

	    public List<String> getLogs() {
	        return logs;
	    }
	}


	//class3:
	public class ExcelBusinessValidationUtil {

	    private ExcelBusinessValidationUtil() {
	        // utility class
	    }

	    public ExcelBusinessValidationResult validateExcelBusinessData(
	            ExcelFileDetails fileDetails,
	            ExcelBusinessValidationConfig config
	    ) {

	        ExcelBusinessValidationResult result =
	                new ExcelBusinessValidationResult();

	        result.addLog("Validation started");

	        // --------------------------------------------------
	        // STEP 1: Read employee records (existing helpers)
	        // --------------------------------------------------
	        List<EmployeeRecord> records =
	                readEmployeeRecords(fileDetails, result);

	        if (records.isEmpty()) {
	            result.addError("No employee records found");
	            return result;
	        }

	        // --------------------------------------------------
	        // STEP 2: Employee ID BASE validation (ALWAYS)
	        // --------------------------------------------------
	        validateEmployeeIds(records, result);

	        // --------------------------------------------------
	        // STEP 3: DOJ validation decision
	        // --------------------------------------------------
	        boolean dojRequired =
	                config.isCheckAgainstSheetName()
	                        || config.isValidateEmployeeIdNumeric();

	        if (dojRequired) {
	            validateAndParseDOJ(records, config, result);
	            validateDOJOrdering(records, result);
	        }

	        // --------------------------------------------------
	        // STEP 4: Numeric Employee ID ordering
	        // --------------------------------------------------
	        if (config.isValidateEmployeeIdNumeric()) {
	            validateEmployeeIdNumericOrdering(records, result);
	        }

	        result.addLog("Validation completed");
	        return result;
	    }
	    
	}//-------
	    //Class4
	    static class EmployeeRecord {
	        String employeeId;
	        String dojRaw;
	        LocalDate doj;
	        int rowNumber;
	    }
	    
	    
	    //class5
	    private static List<EmployeeRecord> readEmployeeRecords(
	            ExcelFileDetails fileDetails,
	            ExcelBusinessValidationResult result
	    ) {
	        result.addLog("Reading employee records from Excel");

	        // Existing ExcelUtils / filters will be used here
	        // This method ONLY reads & maps data

	        return new ArrayList<>();
	    }
	    
	    
	    
	    
	    //class6
	    private static void validateEmployeeIds(
	            List<EmployeeRecord> records,
	            ExcelBusinessValidationResult result
	    ) {
	        result.addLog("Validating Employee IDs (base)");

	        Set<String> uniqueIds = new HashSet<>();

	        for (EmployeeRecord r : records) {

	            if (r.employeeId == null || r.employeeId.trim().isEmpty()) {
	                result.addError("Blank Employee ID at row " + r.rowNumber);
	                continue;
	            }

	            if (!uniqueIds.add(r.employeeId)) {
	                result.addError(
	                        "Duplicate Employee ID " + r.employeeId +
	                        " at row " + r.rowNumber
	                );
	            }
	        }
	    }
	    
	    //7:
	    private static void validateAndParseDOJ(
	            List<EmployeeRecord> records,
	            ExcelBusinessValidationConfig config,
	            ExcelBusinessValidationResult result
	    ) {
	        result.addLog("Validating DOJ values");

	        for (EmployeeRecord r : records) {

	            if (r.dojRaw == null || r.dojRaw.isEmpty()) {
	                result.addError("Missing DOJ for Employee " + r.employeeId);
	                continue;
	            }

	            LocalDate parsed = parseDOJ(r.dojRaw, config.getDojFormats());

	            if (parsed == null) {
	                result.addError(
	                        "Invalid DOJ format for Employee " + r.employeeId +
	                        " value=" + r.dojRaw
	                );
	            } else {
	                r.doj = parsed;
	            }
	        }
	    }
	    
	    //8
	    private static LocalDate parseDOJ(
	            String doj,
	            List<String> formats
	    ) {
	        for (String f : formats) {
	            try {
	                return LocalDate.parse(
	                        doj,
	                        DateTimeFormatter.ofPattern(f)
	                );
	            } catch (Exception ignore) {
	            }
	        }
	        return null;
	    }

	    //9
	    private static void validateDOJOrdering(
	            List<EmployeeRecord> records,
	            ExcelBusinessValidationResult result
	    ) {
	        result.addLog("Validating DOJ ordering");

	        LocalDate previous = null;

	        for (EmployeeRecord r : records) {
	            if (previous != null && r.doj.isBefore(previous)) {
	                result.addError(
	                        "DOJ order mismatch at row " + r.rowNumber +
	                        " for Employee " + r.employeeId
	                );
	            }
	            previous = r.doj;
	        }
	    }
	    
	    //10
	    private static void validateEmployeeIdNumericOrdering(
	            List<EmployeeRecord> records,
	            ExcelBusinessValidationResult result
	    ) {
	        result.addLog("Validating Employee ID numeric ordering");

	        Integer previous = null;

	        for (EmployeeRecord r : records) {

	            Integer current = extractNumericPart(r.employeeId);

	            if (current == null) {
	                result.addError(
	                        "Employee ID numeric part missing: " + r.employeeId
	                );
	                continue;
	            }

	            if (previous != null && current < previous) {
	                result.addError(
	                        "Employee ID numeric order mismatch at row "
	                                + r.rowNumber + " value=" + r.employeeId
	                );
	            }

	            previous = current;
	        }
	    }
	    
	    //10
	    private static Integer extractNumericPart(String empId) {
	        String digits = empId.replaceAll("\\D+", "");
	        return digits.isEmpty() ? null : Integer.parseInt(digits);
	    }
	
	
	
	
	
	    
	    //------------- HTML Report ----------------
	    
	    static class MiniHTMLReport {

	        private final StringBuilder html = new StringBuilder();

	        private final boolean showDOJColumn;

	        MiniHTMLReport(boolean showDOJColumn) {
	            this.showDOJColumn = showDOJColumn;
	            startHtml();
	        }
	        
	        private void startHtml() {
	            html.append("<html>")
	                .append("<head>")
	                .append("<style>")
	                .append("table { border-collapse: collapse; width: 100%; }")
	                .append("th, td { border: 1px solid #999; padding: 6px; font-size: 12px; }")
	                .append("th { background-color: #f0f0f0; }")
	                .append(".error { background-color: #ffe6e6; }")
	                .append(".ok { background-color: #e6ffe6; }")
	                .append("</style>")
	                .append("</head>")
	                .append("<body>");
	        }
	        
	        void addMasterTableHeader() {

	            html.append("<h3>Input Excel Validation</h3>");
	            html.append("<table>");
	            html.append("<tr>");
	            html.append("<th>Employee ID</th>");

	            if (showDOJColumn) {
	                html.append("<th>DOJ</th>");
	            }

	            html.append("<th>Status</th>");
	            html.append("<th>Remarks</th>");
	            html.append("</tr>");
	        }
	        
	        void addMasterRow(
	                String employeeId,
	                String doj,
	                boolean valid,
	                String remarks
	        ) {
	            html.append("<tr class='")
	                .append(valid ? "ok" : "error")
	                .append("'>");

	            html.append("<td>").append(employeeId).append("</td>");

	            if (showDOJColumn) {
	                html.append("<td>").append(doj == null ? "" : doj).append("</td>");
	            }

	            html.append("<td>").append(valid ? "PASS" : "FAIL").append("</td>");
	            html.append("<td>").append(remarks).append("</td>");
	            html.append("</tr>");
	        }
	        
	        void addDownloadedTableHeader() {

	            html.append("</table>");
	            html.append("<br/>");

	            html.append("<h3>Downloaded Excel Validation</h3>");
	            html.append("<table>");
	            html.append("<tr>");
	            html.append("<th>Employee ID</th>");
	            html.append("<th>Status</th>");
	            html.append("<th>Remarks</th>");
	            html.append("</tr>");
	        }
	        
	        void addDownloadedRow(
	                String employeeId,
	                boolean valid,
	                String remarks
	        ) {
	            html.append("<tr class='")
	                .append(valid ? "ok" : "error")
	                .append("'>");

	            html.append("<td>").append(employeeId).append("</td>");
	            html.append("<td>").append(valid ? "PASS" : "FAIL").append("</td>");
	            html.append("<td>").append(remarks).append("</td>");
	            html.append("</tr>");
	        }
	        
	        String build() {
	            html.append("</table>");
	            html.append("</body></html>");
	            return html.toString();
	        }
	    }
	    
	    
	    
	    //Excel Exclude
	    static class ExcelExclude {

	        private final String columnLetter;   // A, B, C...
	        private final Set<String> excludeValues;

	        ExcelExclude(String columnLetter, List<String> values) {
	            this.columnLetter = columnLetter;
	            this.excludeValues = new HashSet<>(values);
	        }

	        boolean shouldExclude(Map<String, String> rowData) {
	            String cellValue = rowData.get(columnLetter);
	            return cellValue != null && excludeValues.contains(cellValue.trim());
	        }
	    }

	

}
