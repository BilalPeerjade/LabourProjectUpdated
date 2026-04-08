package businessTestCases;





import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import com.aventstack.extentreports.markuputils.MarkupHelper;

import utils.ExcelExpressionParser;
import utils.ExcelExtraConfig;
import utils.ExcelF;
import utils.ExcelFileDetails;
import utils.ExcelUtils;

//import com.aventstack.extentreports.markuputils.ExtentColor;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * Advanced Excel Validation Utility for Row-by-Row Comparison.
 * This class maps specific Employee IDs exactly between a master truth file 
 * and a downloaded evaluation file, executing arbitrary mathematical formulas 
 * defined externally as string tokens.
 * Time Complexity Operation: O(n) utilizing native Java HashMaps logic.
 */
public class CalculateWithIds {

    /**
     * DTO container mapping row computational states for the final Extent HTML rendering.
     */
    private static class RowResult {
        int rowNumber;
        String empId;
        double expectedValue;
        double actualValue;
        double tolerance;
        boolean status;

        public RowResult(int rowNumber, String empId, double expectedValue, double actualValue, double tolerance, boolean status) {
            this.rowNumber = rowNumber;
            this.empId = empId;
            this.expectedValue = expectedValue;
            this.actualValue = actualValue;
            this.tolerance = tolerance;
            this.status = status;
        }
    }

    /**
     * Primary facade function implementing signature guidelines aligned with CommonBusinessUtilis3.
     */
    public static void validateExcelCalculationWithIds(
            File downloadedExcelFile,        
            ExcelFileDetails masterFile,     // Parameter updated to accept ExcelFileDetails config object      
            ExtentTest test,                 
            String calculationRule,          
            String rhsSource,                //can be removed
            String sheetName,                
            List<ExcelF> masterFilters,      
            List<ExcelF> targetFilters,      
            ExcelExtraConfig extraConfig,    
            double tolerance,                
            boolean isRowByRowCompare,       
            int startRowOffset,              
            Map<String, String> headerMap,   
            String validationMessage         
    ) {
        try {
            // Expression evaluation string initialization utilizing helper engine parser
            ExcelExpressionParser.ParsedRule parsedRule = ExcelExpressionParser.parse(calculationRule);
            String actualColumnLetter = parsedRule.leftColumn;
            int actualColumnIndex = ExcelUtils.columnLetterToIndex(actualColumnLetter);

            // Employee ID identifier variables mapping assignment. 
            // Ensures strict exact matching capability without hardcoding constants.
            String masterEmpIdColLetter = headerMap.getOrDefault("EMP_ID_MASTER", "C"); 
            String downloadedEmpIdColLetter = headerMap.getOrDefault("EMP_ID_DOWNLOADED", "B");
            
            int masterEmpIdIndex = ExcelUtils.columnLetterToIndex(masterEmpIdColLetter);
            int downloadedEmpIdIndex = ExcelUtils.columnLetterToIndex(downloadedEmpIdColLetter);

            // Extracting mathematical dependencies required to construct minimal memory Master HashMap
            Set<Integer> requiredMasterColumnIndexes = new HashSet<>();
            for (ExcelExpressionParser.Token token : parsedRule.rhsTokens) {
                if (token.type == ExcelExpressionParser.Token.Type.COLUMN) {
                    if (token.sheetName!= null && token.sheetName.equalsIgnoreCase("Master")) {
                        requiredMasterColumnIndexes.add(ExcelUtils.columnLetterToIndex(token.column));
                    }
                }
            }

            // String path checking safety layer
            if (masterFile == null || masterFile.getFilePath() == null || masterFile.getFilePath().trim().isEmpty()) {
                test.log(LogStatus.FAIL, "Master ExcelFileDetails or inner path string is missing. Validation aborted.");
                return;
            }

            // Central performance scaling node: Loading minimal data to standard memory structure
            Map<String, Map<String, Double>> masterDataMap = loadMasterData(
                    masterFile, masterEmpIdIndex, requiredMasterColumnIndexes, masterFilters, extraConfig
            );

            List<RowResult> resultLogs = new ArrayList<>();
            boolean overallTestingPassed = true;
            
            // Try-with-resources architecture automatically managing memory allocations
            try (FileInputStream fis = new FileInputStream(downloadedExcelFile);
                 Workbook downloadedWb = WorkbookFactory.create(fis)) {
                 
                Sheet downloadedSheet = downloadedWb.getSheet(sheetName);
                if (downloadedSheet == null) {
                    downloadedSheet = downloadedWb.getSheetAt(0); 
                }

                int rowCount = downloadedSheet.getLastRowNum();
                int startIndex = Math.max(1, startRowOffset); 

                // Phase two algorithmic loop trigger (O(M) complexity operation)
                for (int i = startIndex; i <= rowCount; i++) {
                    Row row = downloadedSheet.getRow(i);
                    if (row == null) continue;

                    // ExcelExtraConfig evaluation handling "Total" string termination point logic
                    if (extraConfig!= null && "YES".equalsIgnoreCase(extraConfig.getTotalLogicEnabled())) {
                        Cell totalCell = row.getCell(extraConfig.getTotalColumnIndex());
                        if (totalCell!= null) {
                            String totalCellVal = ExcelUtils.getString(totalCell).trim();
                            // Implementation of Value Normalization layer happens implicitly here 
                            if (totalCellVal.equalsIgnoreCase(extraConfig.getTotalKeyword())) {
                                break; 
                            }
                        }
                    }

                    // Download file data bypassing through provided ExcelF mechanism constraints
                    if (!passesFilters(row, targetFilters)) continue;

                    Cell empIdCell = row.getCell(downloadedEmpIdIndex);
                    if (empIdCell == null) continue;
                    String empId = ExcelUtils.getString(empIdCell).trim();

                    if (empId.isEmpty()) continue;

                    // O(1) Instant memory lookup eliminating nested loop iteration structures
                    if (!masterDataMap.containsKey(empId)) {
                        test.log(LogStatus.INFO, "EMP ID " + empId + " is not present in the master file. Skipping downloaded row index " + (i + 1) + ".");
                        continue;
                    }

                    Map<String, Double> masterRowData = masterDataMap.get(empId);

                    // Dynamic string-to-mathematics token logic calculation
                    Double expectedValue = evaluateExpression(parsedRule.rhsTokens, masterRowData, row);
                    if (expectedValue == null) expectedValue = 0.0;

                    // Target mapping fetch logic utilizing ExcelUtils normalization safety measures
                    Cell actualCell = row.getCell(actualColumnIndex);
                    Double actualValue = actualCell!= null? ExcelUtils.getNumeric(actualCell) : 0.0;
                    if (actualValue == null) actualValue = 0.0;

                    // Decimal bounds assertion check 
                    boolean isRowComputationPass = withinTolerance(actualValue, expectedValue, tolerance);
                    if (!isRowComputationPass) overallTestingPassed = false;

                    // Log appending mechanism restricted to minimal operations scope
                    resultLogs.add(new RowResult(i + 1, empId, expectedValue, actualValue, tolerance, isRowComputationPass));
                }
            }

            // Reporting and presentation handling layer
            test.log(LogStatus.PASS, validationMessage);
            generateHtmlReport(test, resultLogs, parsedRule);
            
            if (!overallTestingPassed) {
                test.log(LogStatus.FAIL, "System identified a mathematical divergence in Excel row-by-row tolerance matching algorithms.");
            }

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "System encountered an automation environment exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Master cache building loop performing sequential data extraction natively using FilePath Strings. 
     */
    private static Map<String, Map<String, Double>> loadMasterData(
            ExcelFileDetails masterFile,
            int masterEmpIdIndex,
            Set<Integer> requiredMasterColumnIndexes,
            List<ExcelF> masterFilters,
            ExcelExtraConfig extraConfig) throws Exception {

        Map<String, Map<String, Double>> masterMap = new HashMap<>();
        String actualPathString = masterFile.getFilePath();

        try (FileInputStream fis = new FileInputStream(actualPathString);
             Workbook wb = WorkbookFactory.create(fis)) {

            Sheet sheet;
            if (masterFile.getSheetName()!= null &&!masterFile.getSheetName().isEmpty()) {
                sheet = wb.getSheet(masterFile.getSheetName());
            } else {
                sheet = wb.getSheetAt(0);
            }
            
            int rowCount = sheet.getLastRowNum();

            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                if (extraConfig!= null && "YES".equalsIgnoreCase(extraConfig.getTotalLogicEnabled())) {
                    Cell totalCell = row.getCell(extraConfig.getTotalColumnIndex());
                    if (totalCell!= null && ExcelUtils.getString(totalCell).trim().equalsIgnoreCase(extraConfig.getTotalKeyword())) {
                        break;
                    }
                }

                if (!passesFilters(row, masterFilters)) continue;

                Cell empIdCell = row.getCell(masterEmpIdIndex);
                if (empIdCell == null) continue;
                String empId = ExcelUtils.getString(empIdCell).trim();
                
                if (empId.isEmpty()) continue;

                Map<String, Double> columnValues = new HashMap<>();
                for (int colIndex : requiredMasterColumnIndexes) {
                    Cell dataCell = row.getCell(colIndex);
                    Double rawNumericalData = dataCell!= null? ExcelUtils.getNumeric(dataCell) : 0.0;
                    columnValues.put(ExcelUtils.indexToColLetter(colIndex), rawNumericalData == null? 0.0 : rawNumericalData);
                }

                masterMap.put(empId, columnValues);
            }
        }
        return masterMap;
    }

    /**
     * Linear sequence operations token execution array list processor.
     */
    private static Double evaluateExpression(List<ExcelExpressionParser.Token> tokens, Map<String, Double> masterData, Row downloadedRow) {
        List<Double> operandValues = new ArrayList<>();
        List<String> operatorsLogic = new ArrayList<>();

        for (ExcelExpressionParser.Token token : tokens) {
            switch (token.type) {
                case NUMBER:
                    operandValues.add(token.number);
                    break;
                case COLUMN:
                    double operationalValue = 0.0;
                    if (token.sheetName!= null && token.sheetName.equalsIgnoreCase("Master")) {
                        operationalValue = masterData.getOrDefault(token.column, 0.0);
                    } else {
                        int crossReferencedColIdx = ExcelUtils.columnLetterToIndex(token.column);
                        Cell dCell = downloadedRow.getCell(crossReferencedColIdx);
                        if (dCell!= null) {
                            Double val = ExcelUtils.getNumeric(dCell);
                            operationalValue = val!= null? val : 0.0;
                        }
                    }
                    operandValues.add(operationalValue);
                    break;
                case OPERATOR:
                    operatorsLogic.add(token.operator);
                    break;
            }
        }

        if (operandValues.isEmpty()) return 0.0;
        
        double finalComputationResult = operandValues.get(0);
        int opPointer = 0;
        
        for (int i = 1; i < operandValues.size(); i++) {
            if (opPointer < operatorsLogic.size()) {
                String operatorCharacter = operatorsLogic.get(opPointer++);
                finalComputationResult = apply(finalComputationResult, operandValues.get(i), operatorCharacter);
            }
        }
        return finalComputationResult;
    }

    /**
     * Internal mathematical boundary applier
     */
    private static double apply(double leftNode, double rightNode, String opType) {
        switch (opType) {
            case "+": return leftNode + rightNode;
            case "-": return leftNode - rightNode;
            case "*": return leftNode * rightNode;
            case "/": return (rightNode == 0.0? 0.0 : leftNode / rightNode);
            case "%": return leftNode * (rightNode / 100.0);
            default: return leftNode;
        }
    }

    /**
     * Decimal precision bounds scaling verification method 
     */
    private static boolean withinTolerance(Double lhsComputed, Double rhsExpected, double limitParameter) {
        if (lhsComputed == null && rhsExpected == null) return true;
        if (lhsComputed == null || rhsExpected == null) return false;
        double errorMargin = Math.abs(lhsComputed - rhsExpected);
        double multiplierBounds = Math.max(1.0, Math.abs(rhsExpected));
        return errorMargin <= limitParameter * multiplierBounds;
    }

    /**
     * ExcelF logical gate execution sequence handling parameter exclusion boundaries.
     */
    private static boolean passesFilters(Row evaluatedRow, List<ExcelF> filterConditionSet) {
        if (filterConditionSet == null || filterConditionSet.isEmpty()) return true;
        for (ExcelF configurationNode : filterConditionSet) {
            if (configurationNode.getValues() == null || configurationNode.getValues().isEmpty()) continue;
            Cell targetPropertyCell = evaluatedRow.getCell(configurationNode.getColumnIndex());
            String stringValidationKey = targetPropertyCell == null? "" : ExcelUtils.getString(targetPropertyCell).trim();
            if (!configurationNode.getValues().contains(stringValidationKey)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Extent UI CSS DOM Table element assembly logic implementing strict sequence caps.
     */
    private static void generateHtmlReport(ExtentTest testingLogInterface, List<RowResult> executionLogsCollection, ExcelExpressionParser.ParsedRule tokenParsedRuleObj) {
        if (executionLogsCollection.isEmpty()) return;
        
        StringBuilder htmlElementConstruct = new StringBuilder();
        htmlElementConstruct.append("<div style='margin: 6px 0 10px; font-weight: 700; font-family: Arial, sans-serif; color: #111827;'>")
        .append("Row-by-Row Calculation Details (Top 5 Display Limited)")
        .append("</div>");

        htmlElementConstruct.append("<table style='border-collapse: collapse; width: 100%; font-family: Arial, sans-serif; font-size: 13px; text-align: center;'>");
        htmlElementConstruct.append("<thead style='background: #f7f7f9; text-transform: uppercase; letter-spacing: 0.4px;'>")
        .append("<tr>")
        .append("<th style='border: 1px solid #e5e7eb; padding: 8px 10px;'>ROW</th>")
        .append("<th style='border: 1px solid #e5e7eb; padding: 8px 10px;'>EMPLOYEE ID</th>")
        .append("<th style='border: 1px solid #e5e7eb; padding: 8px 10px;'>MASTER EXPECTED VALUE<br><small style='color:#6b7280; text-transform:none'>(")
        .append(tokenParsedRuleObj.leftColumn).append(" Computation Target)</small></th>")
        .append("<th style='border: 1px solid #e5e7eb; padding: 8px 10px;'>DOWNLOADED ACTUAL VALUE<br><small style='color:#6b7280; text-transform:none'>(")
        .append(tokenParsedRuleObj.leftColumn).append(" Sheet Content)</small></th>")
        .append("<th style='border: 1px solid #e5e7eb; padding: 8px 10px;'>TOLERANCE RATIO</th>")//Toll
        .append("<th style='border: 1px solid #e5e7eb; padding: 8px 10px;'>AUTOMATION STATUS</th>")
        .append("</tr></thead><tbody>");

        int displayRenderLimit = Math.min(5, executionLogsCollection.size());
        for (int loopIndex = 0; loopIndex < displayRenderLimit; loopIndex++) {
            RowResult resultNodeProperty = executionLogsCollection.get(loopIndex);
            
            String layoutPillBadge;
            if (resultNodeProperty.status) {
                layoutPillBadge = "<span style='display: inline-block; padding: 2px 12px; border-radius: 999px; font-weight: 700; background: #ecfdf5; color: #065f46;'>PASS</span>";
            } else {
                layoutPillBadge = "<span style='display: inline-block; padding: 2px 12px; border-radius: 999px; font-weight: 700; background: #fef2f2; color: #991b1b;'>FAIL</span>";
            }

            htmlElementConstruct.append("<tr>")
            .append("<td style='border: 1px solid #e5e7eb; padding: 10px;'>").append(resultNodeProperty.rowNumber).append("</td>")
            .append("<td style='border: 1px solid #e5e7eb; padding: 10px;'>").append(resultNodeProperty.empId).append("</td>")
            .append("<td style='border: 1px solid #e5e7eb; padding: 10px;'>").append(String.format("%.2f", resultNodeProperty.expectedValue)).append("</td>")
            .append("<td style='border: 1px solid #e5e7eb; padding: 10px;'>").append(String.format("%.2f", resultNodeProperty.actualValue)).append("</td>")
            .append("<td style='border: 1px solid #e5e7eb; padding: 10px;'>").append(resultNodeProperty.tolerance).append("</td>")
            .append("<td style='border: 1px solid #e5e7eb; padding: 10px;'>").append(layoutPillBadge).append("</td>")
            .append("</tr>");
        }
        
        htmlElementConstruct.append("</tbody></table>");
        
        if (executionLogsCollection.size() > 5) {
            htmlElementConstruct.append("<div style='margin-top: 8px; font-size: 12px; color: #6b7280;'>* Showing top 5 log entries structurally. Total processed row checks: ")
            .append(executionLogsCollection.size()).append("</div>");
        }

        // Extent v2 UI Render 
        testingLogInterface.log(LogStatus.INFO, "CalculateWithIds Validation Test Details Result Module", htmlElementConstruct.toString());
    }
    
}