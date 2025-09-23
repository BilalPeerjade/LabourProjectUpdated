package businessTestCases;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.ExcelExpressionParser;
import utils.ExcelExtraConfig;
import utils.methodsb;
import utils.ExcelUtils;
import utils.HTMLReport;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * CommonBusinessUtilis3
 *
 * Patched/calculation-ready version of CommonBusinessUtilis2 with:
 *  - sheet alias/underscore→space normalization
 *  - full calculation validation flow (master vs downloaded, downloaded vs downloaded)
 *  - keyword header search + startRowOffset
 *  - stop-at-Total logic (ExcelExtraConfig)
 *  - filters for master & downloaded independently
 *  - row-by-row and totals-only compare
 *  - tolerance handling
 *  - HTMLCalculationReport hook
 *
 * NOTE: This file expects existing helper classes in your project:
 * - utils.ExcelUtils (with methods like columnLetterToIndex, findHeaderRowAnywhere, readNumericColumnTillTotal, etc.)
 * - utils.ExcelExpressionParser (parse() returning ParsedRule and Token)
 * - utils.HTMLCalculationReport (enableReport flag + logCalculationTable(...))
 * - ExcelFilter (model class used for filters)
 * - ExcelExtraConfig (model class with getTotalLogicEnabled(), getTotalColumnIndex(), getTotalKeyword())
 *
 * If any helper method names differ in your codebase, adjust the call sites accordingly.
 */
public class Utilis3 {

    // ----------------------- Sheet alias / normalization -----------------------
    private static final Map<String, String> SHEET_ALIAS = new HashMap<>();
    static {
        // Automatic common normalization: underscores -> spaces (we still allow explicit alias)
        // Add explicit aliases if needed:
        SHEET_ALIAS.put("PT_Report", "PT Report");
        SHEET_ALIAS.put("All_Emp_Workings", "All Emp Workings");
        SHEET_ALIAS.put("Non_Applicable_Employees", "Non Applicable Employees");
        SHEET_ALIAS.put("Master", "MonthlyEmployeeSalary");
        SHEET_ALIAS.put("Master", "MonthlyEmployeeChallanSalary");
        SHEET_ALIAS.put("All_Employees", "All Employees"); //PF
        SHEET_ALIAS.put("Central_Form_B", "Central Form-B");
        
        // SHEET_ALIAS.put("Emp_Salary", "Employee Salary");
    }

    private static String normalizeSheetName(String raw) {
        if (raw == null) return null;
        // Allow direct alias mapping first
        String alias = SHEET_ALIAS.get(raw);
        if (alias != null) return alias;
        // If not present, fallback: convert underscores to space (most common case)
        return raw.replace('_', ' ').trim();
    }

    // ----------------------- Public facade -----------------------
    /**
     * Main validation method.
     *
     * @param downloadedExcelFile  latest downloaded file (File)
     * @param masterFilePath       local master file path (String) - may be null if not using master
     * @param test                 ExtentTest for logging
     * @param calculationRule      rule string e.g. "PT_Report.L = Master.H - PT_Report.K" or "L = H - K"
     * @param rhsSource            "MASTER" or "DOWNLOADED" (which workbook to treat RHS as coming from by default)
     * @param defaultSheetName     default sheet name for downloaded file when rule has no sheet prefix
     * @param masterFilters        filters to apply on master workbook (List<ExcelFilter>) - can be empty
     * @param downloadedFilters    filters to apply on downloaded workbook (List<ExcelFilter>) - can be empty
     * @param extraConfig          ExcelExtraConfig (total logic config)
     * @param tolerance            relative tolerance (e.g., 0.05 = 5%). Comparison uses RHS as scale.
     * @param compareRowByRow      true => row-by-row, false => totals only
     * @param startRowOffset       rows to skip after header (headerRow + startRowOffset => data start)
     * @param headerKeywords       map columnLetter -> headerKeyword (optional; can be null)
     * @param successMessage       message to log on full pass
     * 
     */
    public static void validateExcelCalculation(
            File downloadedExcelFile,
            String masterFilePath,
            ExtentTest test,
            String calculationRule,
            String rhsSource,
            String defaultSheetName,
            List<methodsb> masterFilters,
            List<methodsb> downloadedFilters,
            ExcelExtraConfig extraConfig,
            double tolerance,
            boolean compareRowByRow,
            int startRowOffset,
            Map<String, String> headerKeywords,
            String successMessage
    ) {
        // Basic parameter validation
        if (downloadedExcelFile == null || !downloadedExcelFile.exists()) {
            test.log(LogStatus.ERROR, "Downloaded Excel file not found: " + downloadedExcelFile);
            return;
        }
        if ("MASTER".equalsIgnoreCase(rhsSource) && (masterFilePath == null || masterFilePath.trim().isEmpty())) {
            test.log(LogStatus.ERROR, "rhsSource=MASTER but masterFilePath is null/empty.");
            return;
        }
        if (calculationRule == null || calculationRule.trim().isEmpty()) {
            test.log(LogStatus.ERROR, "calculationRule is empty.");
            return;
        }

        // Parse expression
        ExcelExpressionParser.ParsedRule rule;
        try {
            rule = ExcelExpressionParser.parse(calculationRule);
        } catch (Exception ex) {
            test.log(LogStatus.ERROR, "Expression parse failed: " + ex.getMessage());
            return;
        }

        // Open workbooks
        try (InputStream inDownloaded = new FileInputStream(downloadedExcelFile);
             Workbook wbDownloaded = new XSSFWorkbook(inDownloaded);
             InputStream inMaster = (masterFilePath != null && !masterFilePath.trim().isEmpty())
                     ? new FileInputStream(masterFilePath) : null;
             Workbook wbMaster = (inMaster == null) ? null : new XSSFWorkbook(inMaster)) {

            // Determine which workbook provides RHS columns by default
            Workbook wbRhs = "MASTER".equalsIgnoreCase(rhsSource) ? wbMaster : wbDownloaded;
            if (wbRhs == null && "MASTER".equalsIgnoreCase(rhsSource)) {
                test.log(LogStatus.ERROR, "RHS workbook is null (master file could not be opened).");
                return;
            }

            // LHS is always from downloaded file (target to validate)
            // Determine LHS sheet name: if rule.leftSheet present use it, else defaultSheetName
            String lhsSheetRaw = rule.leftSheet != null ? rule.leftSheet : defaultSheetName;
            String lhsSheet = normalizeSheetName(lhsSheetRaw);
            ColumnBinding lhsBinding = bindColumn(
                    wbDownloaded,
                    lhsSheet,
                    rule.leftColumn,
                    headerKeywords,
                    startRowOffset,
                    extraConfig,
                    "DOWNLOADED",
                    downloadedFilters,
                    test
            );

            if (!lhsBinding.ok) {
                test.log(LogStatus.FAIL, "Failed to bind LHS: " + lhsBinding.bindError);
                return;
            }

            // Compute RHS vector (from wbRhs). computeRhs will respect per-token sheet names:
            // - If token has sheetName, the parser will pass it through; we will normalize inside computeRhs.
            RHSComputation rhsComp = computeRhs(
                    wbRhs,
                    wbDownloaded, // pass downloaded as context if cross-file needed
                    rule,
                    defaultSheetName,
                    headerKeywords,
                    startRowOffset,
                    extraConfig,
                    rhsSource,
                    ("MASTER".equalsIgnoreCase(rhsSource) ? masterFilters : downloadedFilters),
                    compareRowByRow,
                    test
            );

            if (!rhsComp.ok) {
                test.log(LogStatus.ERROR, "Failed to compute RHS: " + rhsComp.error);
                return;
            }

            // Take LHS and RHS values
            List<Double> lhsValues = lhsBinding.values;
            List<Double> rhsValues = rhsComp.values;

            if (!compareRowByRow) {
                // Totals mode: collapse both to single number
                Double lhsTotal = sumNonNull(lhsValues);
                Double rhsTotal = sumNonNull(rhsValues);

                // Log sample as HTML if enabled
 /*               HTMLCalculationReport.logTotalsTable(
                	    test,
                	    "Totals Comparison",
                	    lhsBinding.sheetName,
                	    lhsBinding.columnLetter,
                	    lhsBinding.headerName,
                	    rhsComp.displayInfo,        // RHS expression string (multi-columns ke case me yeh best hota hai)
                	    lhsTotal,
                	    rhsTotal
                	); */
                HTMLReport.logTotalsTable(
                	    test,
                	    "Totals Comparison",
                	    lhsBinding.sheetName,
                	    lhsBinding.columnLetter,
                	    lhsBinding.headerName,
                	    rhsComp.displayInfo,        // RHS expression string ...
                	    lhsTotal,
                	    rhsTotal,
                	    tolerance
                	);



                
                
                
                
                

                boolean pass = withinTolerance(lhsTotal, rhsTotal, tolerance);
                if (pass) {
                    test.log(LogStatus.PASS, successMessage + "");
                } else {
                    test.log(LogStatus.FAIL, "Totals mismatch. LHS=" + lhsTotal + ", RHS=" + rhsTotal + ", tolerance=" + tolerance);
                }
                return;
            }

            // Row-by-row: align by minimum available rows
            int n = Math.min(lhsValues.size(), rhsValues.size());
            if (n == 0) {
                test.log(LogStatus.ERROR, "No overlapping rows available for comparison after binding/filters/total logic.");
                return;
            }

            List<Double> lhsTrim = lhsValues.subList(0, n);
            List<Double> rhsTrim = rhsValues.subList(0, n);

            int passCount = 0;
            for (int i = 0; i < n; i++) {
                if (withinTolerance(lhsTrim.get(i), rhsTrim.get(i), tolerance)) passCount++;
            }
            boolean allPass = (passCount == n);

            // HTML sample
 /*           HTMLCalculationReport.logRowByRowTable(
            	    test,
            	    "Row-by-Row Comparison (first " + Math.min(n,5) + " rows shown)",
            	    lhsBinding.sheetName,
            	    lhsBinding.columnLetter,
            	    lhsBinding.headerName,
            	    rhsComp.displayInfo,   // RHS side ko expression ke form me show karenge
            	    lhsTrim,
            	    rhsTrim
            	); */
            HTMLReport.logRowByRowTable(
            	    test,
            	    "Row-by-Row Comparison (first " + Math.min(n,5) + " rows shown)",
            	    lhsBinding.sheetName,
            	    lhsBinding.columnLetter,
            	    lhsBinding.headerName,
            	    rhsComp.displayInfo,   // RHS side expression
            	    lhsTrim,
            	    rhsTrim,
            	    tolerance
            	);


            if (allPass) {
                test.log(LogStatus.PASS, successMessage + " (All " + n + " rows within tolerance)");
            } else {
                test.log(LogStatus.FAIL, "Row-by-row mismatch. Passed " + passCount + " / " + n + " rows within tolerance=" + tolerance);
            }

        } catch (Exception ex) {
            test.log(LogStatus.ERROR, "Exception during validation: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    // ---------------------- Binding & Computation Helpers ----------------------

    private static class ColumnBinding {
        boolean ok;
        String bindError;

        Sheet sheet;
        String sheetName;
        String columnLetter;
        String headerKeyword;
        int headerRow;
        int dataStartRow;
        
        
        //new HTML Report
        String headerName; 
        

        List<Double> values = new ArrayList<>();

        String displayInfo() {
            String h = (headerKeyword == null ? "" : headerKeyword);
            return sheetName + "." + columnLetter + (h.isEmpty() ? "" : " (" + h + ")");
        }
    }

    private static ColumnBinding bindColumn(
            Workbook wb,
            String sheetName,
            String columnLetter,
            Map<String, String> headerKeywords,
            int startRowOffset,
            ExcelExtraConfig extraConfig,
            String fileTag,
            List<methodsb> filters,
            ExtentTest test
    ) {
        ColumnBinding b = new ColumnBinding();
        try {
            if (wb == null) {
                b.ok = false;
                b.bindError = "Workbook is null (" + fileTag + ")";
                return b;
            }
            if (sheetName == null || sheetName.trim().isEmpty()) {
                b.ok = false;
                b.bindError = "Sheet name not provided for " + fileTag;
                return b;
            }

            // normalized sheet name (maps underscores → spaces & alias map)
/**            String normalized = normalizeSheetName(sheetName);
            Sheet sheet = wb.getSheet(normalized);
            if (sheet == null) {
                b.ok = false;
                b.bindError = "Sheet not found: " + sheetName + " (" + fileTag + ")";
                return b;
            } **/
         // normalized + alias mapping
            String resolvedSheetName = normalizeSheetName(
                    SHEET_ALIAS.getOrDefault(sheetName, sheetName)
            );
            Sheet sheet = wb.getSheet(resolvedSheetName);
            if (sheet == null) {
                b.ok = false;
                b.bindError = "Sheet not found: " + resolvedSheetName + " (" + fileTag + ")";
                return b;
            }


            b.sheet = sheet;
            b.sheetName = resolvedSheetName;  //normalized
            b.columnLetter = columnLetter;

            String headerKeyword = headerKeywords != null ? headerKeywords.get(columnLetter) : null;
            b.headerKeyword = headerKeyword;

            int headerRow = -1;
            if (headerKeyword != null && !headerKeyword.trim().isEmpty()) {
                headerRow = ExcelUtils.findHeaderRowInColumn(sheet, columnLetter, headerKeyword);
                if (headerRow < 0) {
                    headerRow = ExcelUtils.findHeaderRowAnywhere(sheet, headerKeyword);
                }
            } else {
                // if header not provided, assume header in first non-empty row (try row 0)
                headerRow = 0;
            }
            b.headerRow = headerRow;

            b.dataStartRow = ExcelUtils.resolveDataStartRow(headerRow, Math.max(1, startRowOffset));
            
            
            
            //---------
         // set headerName from the detected header row (fallback: row 0)
            try {
                int colIdx = ExcelUtils.colLetterToIndex(columnLetter); // ya columnLetterToIndex(...) jo tumhare ExcelUtils me hai
                int hdrRow = (headerRow >= 0) ? headerRow : 0;
                Row hdr = sheet.getRow(hdrRow);
                String hn = "";
                if (hdr != null) {
                    Cell hc = hdr.getCell(colIdx);
                    if (hc != null) {
                        String s = ExcelUtils.getString(hc);
                        if (s != null) hn = s.trim();
                    }
                }
                b.headerName = hn;
            } catch (Exception ignore) {
                b.headerName = "";
            }

            
            
            
            
            
            

            boolean stopAtTotal = extraConfig != null && "YES".equalsIgnoreCase(safeStr(extraConfig.getTotalLogicEnabled()));
            String totalKeyword = extraConfig != null ? safeStr(extraConfig.getTotalKeyword()) : "Total";
            int totalColumnIdx = extraConfig != null ? extraConfig.getTotalColumnIndex() : -1;

            List<Double> raw = ExcelUtils.readNumericColumnTillTotal(
                    sheet, columnLetter, b.dataStartRow, stopAtTotal, totalKeyword, totalColumnIdx
            );
            
            
            
            //Me added below:-
            //For calculating till Total only and skip above part: if applied YES it will ignore above rows
            // 🆕 Patch: If totalLogicEnabled = YES, keep only the "Total" row value
            if (stopAtTotal) {
                Double totalValue = ExcelUtils.readTotalCellValue(sheet, columnLetter, totalKeyword, totalColumnIdx);
                b.values = (totalValue == null) ? Collections.emptyList() : Collections.singletonList(totalValue);
            } else {
                b.values = raw;
            }

            
            
            
            
            
            

            // Apply filters if present: find all row indices that match filters, then filter raw values accordingly
            List<Integer> rowHits = null;
            if (filters != null && !filters.isEmpty()) {
                rowHits = ExcelUtils.findAllRowsMatchingFilters(sheet, b.dataStartRow, filters);
            }

            if (rowHits == null || rowHits.isEmpty()) {
                b.values = raw;
            } else {
                Set<Integer> hitSet = new HashSet<>(rowHits);
                List<Double> filtered = new ArrayList<>();
                for (int i = 0; i < raw.size(); i++) {
                    int physicalRowIndex = b.dataStartRow + i;
                    if (hitSet.contains(physicalRowIndex)) filtered.add(raw.get(i));
                }
                b.values = filtered;
            }

            b.ok = true;
            return b;

        } catch (Exception ex) {
            b.ok = false;
            b.bindError = "Bind failed: " + ex.getMessage();
            return b;
        }
    }

    // RHS computation result holder
    private static class RHSComputation {
        boolean ok;
        String error;
        List<Double> values = new ArrayList<>();
        String displayInfo; // human-friendly RHS expression
    }

    /**
     * Compute RHS values based on parsed rule tokens.
     * Will bind each column token to a ColumnBinding (may be from master or downloaded workbook depending on token).
     */
    private static RHSComputation computeRhs(
            Workbook wbRhs,
            Workbook wbDownloadedContext,
            ExcelExpressionParser.ParsedRule rule,
            String defaultSheetName,
            Map<String, String> headerKeywords,
            int startRowOffset,
            ExcelExtraConfig extraConfig,
            String rhsSource, // "MASTER" or "DOWNLOADED"
            List<methodsb> rhsFilters,
            boolean rowByRow,
            ExtentTest test
    ) {
        RHSComputation out = new RHSComputation();
        try {
            List<ExcelExpressionParser.Token> tokens = rule.rhsTokens;
            // Build human display string
            out.displayInfo = tokens.stream().map(t -> {
                switch (t.type) {
                    case OPERATOR: return t.operator;
                    case NUMBER: return String.valueOf(t.number);
                    case COLUMN:
                        String sh = t.sheetName != null ? normalizeSheetName(t.sheetName) : normalizeSheetName(defaultSheetName);
                        String key = headerKeywords != null ? headerKeywords.get(t.column) : null;
                        return sh + "." + t.column + (key != null ? " (" + key + ")" : "");
                    default: return "?";
                }
            }).collect(Collectors.joining(" "));

            // Prepare column vectors (for column tokens) and scalars for number tokens
            List<List<Double>> colVectors = new ArrayList<>();
            List<String> ops = new ArrayList<>();

            for (ExcelExpressionParser.Token t : tokens) {
                switch (t.type) {
                    case OPERATOR:
                        ops.add(t.operator);
                        break;

                    case NUMBER:
                        // number token: treat as single-element vector for uniformity
                        colVectors.add(Collections.singletonList(t.number));
                        break; 
                    case COLUMN: {
                        // Decide actual sheet name (normalize alias/underscores)
                        String actualSheetName = (t.sheetName != null)
                                ? normalizeSheetName(t.sheetName)
                                : normalizeSheetName(defaultSheetName);

                        // Try to find which workbook actually has this sheet:
                        Workbook bindWb = null;

                        // 1) Prefer downloaded workbook (wbDownloadedContext)
                        if (wbDownloadedContext != null) {
                            try {
                                Sheet s = wbDownloadedContext.getSheet(actualSheetName);
                                if (s != null) {
                                    bindWb = wbDownloadedContext;
                                }
                            } catch (Exception ignore) { /* ignore */ }
                        }

                        // 2) If not found in downloaded, try wbRhs (may be master)
                        if (bindWb == null && wbRhs != null) {
                            try {
                                Sheet s2 = wbRhs.getSheet(actualSheetName);
                                if (s2 != null) {
                                    bindWb = wbRhs;
                                }
                            } catch (Exception ignore) { /* ignore */ }
                        }

                        // 3) fallback: if still null, prefer wbRhs if available, else downloaded
                        if (bindWb == null) {
                            bindWb = (wbRhs != null ? wbRhs : wbDownloadedContext);
                        }

                        // Determine fileTag for logging/filters
                        String fileTagForToken = (bindWb == wbRhs && wbRhs != wbDownloadedContext) ? "MASTER" : "DOWNLOADED";

                        // Bind the column using found workbook + sheet name
                        ColumnBinding cb = bindColumn(
                                bindWb,
                                actualSheetName,
                                t.column,
                                headerKeywords,
                                startRowOffset,
                                extraConfig,
                                fileTagForToken,
                                (rhsFilters == null ? new ArrayList<>() : rhsFilters),
                                test
                        );

                        if (cb == null || !cb.ok) {
                            out.ok = false;
                            out.error = "RHS column bind failed for " + (t.sheetName == null ? defaultSheetName : t.sheetName) + "." + t.column + ": " + (cb == null ? "bind returned null" : cb.bindError);
                            return out;
                        }
                        colVectors.add(cb.values);
                        break;
                    }
                }
            }
                        
                        
                        
                        
                        
                        
                        
                        

            // Evaluate either totals or row-by-row
            if (!rowByRow) {
                // Collapse each vector to a scalar
                List<Double> collapsed = colVectors.stream().map(Utilis3::sumNonNull).collect(Collectors.toList());
                if (collapsed.isEmpty()) {
                    out.ok = false;
                    out.error = "No RHS values after collapsing.";
                    return out;
                }

                double acc = collapsed.get(0);
                int opIdx = 0;
                for (int i = 1; i < collapsed.size(); i++) {
                    String op = ops.get(opIdx++);
                    acc = apply(acc, collapsed.get(i), op);
                }
                out.values = Collections.singletonList(acc);
                out.ok = true;
                return out;
            }

            // Row-by-row: find min length across column vectors
            int minLen = Integer.MAX_VALUE;
            for (List<Double> v : colVectors) if (v != null) minLen = Math.min(minLen, v.size());
            if (minLen == Integer.MAX_VALUE || minLen == 0) {
                out.ok = false;
                out.error = "No RHS rows available after binding.";
                return out;
            }

            List<Double> rhsVals = new ArrayList<>(minLen);
            for (int r = 0; r < minLen; r++) {
                double acc = (colVectors.get(0).get(r) == null ? 0.0 : colVectors.get(0).get(r));
                int opIdx = 0;
                for (int i = 1; i < colVectors.size(); i++) {
                    String op = ops.get(opIdx++);
                    Double v = colVectors.get(i).get(r);
                    acc = apply(acc, (v == null ? 0.0 : v), op);
                }
                rhsVals.add(acc);
            }

            out.values = rhsVals;
            out.ok = true;
            return out;

        } catch (Exception ex) {
            out.ok = false;
            out.error = "RHS computation failed: " + ex.getMessage();
            return out;
        }
    }

    // ---------------------- Small helpers ----------------------

    /** Sum ignoring nulls */
    private static Double sumNonNull(List<Double> list) {
        if (list == null || list.isEmpty()) return 0.0;
        double s = 0.0;
        for (Double d : list) if (d != null) s += d;
        return s;
    }

    /** Tolerance check: relative to RHS (expected). If expected near 0, fallback to absolute tolerance on 1. */
    private static boolean withinTolerance(Double lhs, Double rhs, double tol) {
        if (lhs == null && rhs == null) return true;
        if (lhs == null || rhs == null) return false;
        double diff = Math.abs(lhs - rhs);
        double scale = Math.max(1.0, Math.abs(rhs));
        return diff <= tol * scale;
    }

    /** Apply binary op with null-safety */
    private static double apply(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return (b == 0.0 ? 0.0 : a / b);
            default: return a;
        }
    }

    private static String safeStr(String s) { return (s == null ? "" : s); }
}
