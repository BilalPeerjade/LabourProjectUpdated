//package businessTestCases;
//
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.*;
//import java.util.*;
//import java.util.stream.Collectors;
//
////Imports:
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//// ✅ Helper classes jo tumhare project me already hain:
//import utils.ExcelUtils;                // Excel read helpers (findHeaderRow, readNumericColumnTillTotal etc.)
//import utils.ExcelExpressionParser;     // Expression parsing "C = A + B"
//import utils.ExcelFilter;               // Filter model (columnIndex + values)
//import utils.ExcelExtraConfig;          // Total row logic model
//import utils.HTMLCalculationReport;     // HTML report builder for calculation results
//
//
//
///**
// * Facade for Calculation-based Excel validations.
// *
// * Supports:
// * - Master → Downloaded compare   (RHS from Master, LHS from Downloaded)
// * - Downloaded → Downloaded compare (RHS & LHS from Downloaded)
// * - Dynamic expressions like: "F = C + D", "Sheet2.X = Sheet1.A + Sheet1.B * 8.33%"
// * - Keyword-based header discovery + startRowOffset
// * - Stop reading at "Total" row (via ExcelExtraConfig)
// * - Filters per file (Master / Downloaded) with YES/NO toggles
// * - Row-by-row or Totals-only comparison
// * - Tolerance (fraction, e.g., 0.05 = 5%)
// *
// * NOTE: Keep existing helpers intact; only add-ons are used here.
// */
//public class CommonBusinessUtilis2 {
//	
//	
//	
//	//Enhancement:---
//	// 🔑 Step 1: Alias mapping for sheet names
//	private static final Map<String, String> SHEET_ALIAS = new HashMap<>();
//	static {
//	    // Example alias (underscore → space)
//	    SHEET_ALIAS.put("PT_Report", "PT Report");
//	    SHEET_ALIAS.put("MonthlyEmployeeSalary", "MonthlyEmployeeSalary"); 
//	    // Add more if needed
//	}
//	/** Normalize sheet name using alias map (fallback to same name if not mapped). */
//	private static String normalizeSheetName(String raw) {
//	    if (raw == null) return null;
//	    String alias = SHEET_ALIAS.get(raw);
//	    return (alias != null ? alias : raw);
//	}
//
//
//	
//	
//
//    public static void validateExcelCalculation(
//            File downloadedExcelFile,                 // latest downloaded file
//            String masterFilePath,                   // local master file path (nullable if not used)
//            ExtentTest test,
//            String calculationRule,                  // e.g. "Sheet1.F = Sheet1.C + Sheet1.D + Sheet1.E"
//            String rhsSource,                        // "MASTER" or "DOWNLOADED"
//            String defaultSheetName,                 // used when rule doesn't specify sheet (e.g., "C = A + B")
//            List<ExcelFilter> masterFilters,         // filters for Master (can be empty)
//            List<ExcelFilter> downloadedFilters,     // filters for Downloaded (can be empty)
//            ExcelExtraConfig extraConfig,            // total logic: enabled/keyword/columnIndex
//            double tolerance,                        // 0.05 => 5%
//            boolean compareRowByRow,                 // true=row-by-row, false=totals
//            int startRowOffset,                      // rows to skip after header row
//            Map<String, String> headerKeywords,      // e.g., {"C":"Basic","D":"HRA","F":"Net Salary"}
//            String successMessage                    // success log on full pass
//    ) {
//        // Basic guards
//        if (downloadedExcelFile == null || !downloadedExcelFile.exists()) {
//            test.log(LogStatus.ERROR, "Downloaded Excel file not found.");
//            return;
//        }
//        if ("MASTER".equalsIgnoreCase(rhsSource) && (masterFilePath == null || masterFilePath.trim().isEmpty())) {
//            test.log(LogStatus.ERROR, "rhsSource=MASTER but masterFilePath is null/empty.");
//            return;
//        }
//
//        // Parse expression
//        ExcelExpressionParser.ParsedRule rule;
//        try {
//            rule = ExcelExpressionParser.parse(calculationRule);
//        } catch (Exception ex) {
//            test.log(LogStatus.ERROR, "Expression parse failed: " + ex.getMessage());
//            return;
//        }
//
//        // Open workbooks
//        try (InputStream inDownloaded = new FileInputStream(downloadedExcelFile);
//             Workbook wbDownloaded = new XSSFWorkbook(inDownloaded);
//             Workbook wbMaster = openMasterIfNeeded(masterFilePath)) {
//
//            // Decide RHS workbook per mode
//            Workbook wbRhs = "MASTER".equalsIgnoreCase(rhsSource) ? wbMaster : wbDownloaded;
//            if (wbRhs == null) {
//                test.log(LogStatus.ERROR, "RHS workbook is null (check masterFilePath).");
//                return;
//            }
//
//            // LHS always read from Downloaded (target we verify in the report)
//            // RHS read either from Master or Downloaded per rhsSource
//
//            // Build LHS vector (numeric values)
//            ColumnBinding lhsBinding = bindColumn(
//                    wbDownloaded,
//                    rule.leftSheet != null ? rule.leftSheet : defaultSheetName,
//                    rule.leftColumn,
//                    headerKeywords,
//                    startRowOffset,
//                    extraConfig,
//                    "DOWNLOADED",
//                    downloadedFilters,
//                    test
//            );
//
//            if (!lhsBinding.ok) {
//                test.log(LogStatus.ERROR, "Failed to bind LHS: " + lhsBinding.bindError);
//                return;
//            }
//
//            // Build RHS vectors per token and then evaluate per strategy
//            RHSComputation rhsComp = computeRhs(
//                    wbRhs,
//                    wbDownloaded,               // we pass downloaded to allow cross-file align if needed
//                    rule,
//                    defaultSheetName,
//                    headerKeywords,
//                    startRowOffset,
//                    extraConfig,
//                    "MASTER".equalsIgnoreCase(rhsSource) ? "MASTER" : "DOWNLOADED",
//                    "MASTER".equalsIgnoreCase(rhsSource) ? masterFilters : downloadedFilters,
//                    compareRowByRow,
//                    test
//            );
//
//            if (!rhsComp.ok) {
//                test.log(LogStatus.ERROR, "Failed to compute RHS: " + rhsComp.error);
//                return;
//            }
//
//            // Align LHS & RHS (row counts)
//            List<Double> lhsValues = lhsBinding.values;
//            List<Double> rhsValues = rhsComp.values;
//
//            if (!compareRowByRow) {
//                // Totals mode → collapse both sides to single value
//                Double lhsTotal = sumNonNull(lhsValues);
//                Double rhsTotal = sumNonNull(rhsValues);
//                boolean pass = withinTolerance(lhsTotal, rhsTotal, tolerance);
//
//                HTMLCalculationReport.logCalculationTable(
//                        test,
//                        "Totals Comparison",
//                        lhsBinding.displayInfo(),
//                        rhsComp.displayInfo,
//                        calculationRule,
//                        Collections.singletonList(lhsTotal),
//                        Collections.singletonList(rhsTotal)
//                );
//
//                if (pass) {
//                    test.log(LogStatus.PASS, successMessage + " (Totals match within tolerance)");
//                } else {
//                    test.log(LogStatus.FAIL, "Totals mismatch. LHS=" + lhsTotal + ", RHS=" + rhsTotal
//                            + ", tolerance=" + tolerance);
//                }
//                return;
//            }
//
//            // Row-by-row mode → align by min length
//            int n = Math.min(lhsValues.size(), rhsValues.size());
//            if (n == 0) {
//                test.log(LogStatus.ERROR, "No overlapping rows to compare (after filters/offset/total logic).");
//                return;
//            }
//
//            List<Double> lhsTrim = lhsValues.subList(0, n);
//           List<Double> rhsTrim = rhsValues.subList(0, n);
//
//            // Row-wise pass/fail
//            int passCount = 0;
//            for (int i = 0; i < n; i++) {
//                Double l = lhsTrim.get(i);
//                Double r = rhsTrim.get(i);
//                if (withinTolerance(l, r, tolerance)) passCount++;
//            }
//            boolean allPass = (passCount == n);
//
//            HTMLCalculationReport.logCalculationTable(
//                    test,
//                    "Row-by-Row Comparison (" + n + " rows)",
//                    lhsBinding.displayInfo(),
//                    rhsComp.displayInfo,
//                    calculationRule,
//                    lhsTrim,
//                    rhsTrim
//            );
//
//            if (allPass) {
//                test.log(LogStatus.PASS, successMessage + " (All " + n + " rows within tolerance)");
//            } else {
//                test.log(LogStatus.FAIL, "Row-by-row mismatch. Passed " + passCount + " / " + n
//                        + " rows within tolerance=" + tolerance);
//            }
//
//        } catch (Exception e) {
//            test.log(LogStatus.ERROR, "Exception during validation: " + e.getMessage());
//        }
//    }
//
//    // ---------------------------- Internals ---------------------------- //
//
//    private static Workbook openMasterIfNeeded(String masterFilePath) {
//        if (masterFilePath == null || masterFilePath.trim().isEmpty()) return null;
//        try {
//            return new XSSFWorkbook(new FileInputStream(masterFilePath));
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    /** Encapsulates a bound column with values + display info. */
//    private static class ColumnBinding {
//        boolean ok;
//        String bindError;
//
//        Sheet sheet;
//        String sheetName;
//        String columnLetter;
//        String headerKeyword;
//        int headerRow;
//        int dataStartRow;
//
//        List<Double> values = new ArrayList<>();
//
//        String displayInfo() {
//            // e.g., "Sheet1.F (Net Salary)"
//            String h = (headerKeyword == null ? "" : headerKeyword);
//            return sheetName + "." + columnLetter + (h.isEmpty() ? "" : " (" + h + ")");
//        }
//    }
//
//    /** Prepare/bind a column on a workbook using keyword search + offset + total logic + filters. */
//    private static ColumnBinding bindColumn(
//            Workbook wb,
//            String sheetName,
//            String columnLetter,
//            Map<String, String> headerKeywords,
//            int startRowOffset,
//            ExcelExtraConfig extraConfig,
//            String fileTag,                     // "MASTER" or "DOWNLOADED" (for logs only)
//            List<ExcelFilter> filters,
//            ExtentTest test
//    ) {
//        ColumnBinding b = new ColumnBinding();
//        try {
//            if (wb == null) {
//                b.ok = false;
//                b.bindError = "Workbook is null: " + fileTag;
//                return b;
//            }
//            if (sheetName == null || sheetName.trim().isEmpty()) {
//                b.ok = false;
//                b.bindError = "Sheet name not provided (and not in expression)";
//                return b;
//            }
//
//            
//            //Encancement sheet name
//        //  Sheet sheet = wb.getSheet(sheetName);
//            Sheet sheet = wb.getSheet(normalizeSheetName(sheetName));
//
//            
//            if (sheet == null) {
//                b.ok = false;
//                b.bindError = "Sheet not found: " + sheetName + " (" + fileTag + ")";
//                return b;
//            }
//            b.sheet = sheet;
//            b.sheetName = sheetName;
//            b.columnLetter = columnLetter;
//
//            String headerKeyword = headerKeywords != null ? headerKeywords.get(columnLetter) : null;
//            b.headerKeyword = headerKeyword;
//
//            int headerRow = -1;
//            if (headerKeyword != null && !headerKeyword.trim().isEmpty()) {
//                headerRow = ExcelUtils.findHeaderRowInColumn(sheet, columnLetter, headerKeyword);
//                if (headerRow < 0) {
//                    // fallback: search anywhere
//                    headerRow = ExcelUtils.findHeaderRowAnywhere(sheet, headerKeyword);
//                }
//            } else {
//                // If no keyword given, assume header at row 0
//                headerRow = 0;
//            }
//            b.headerRow = headerRow;
//
//            b.dataStartRow = ExcelUtils.resolveDataStartRow(headerRow, Math.max(1, startRowOffset));
//
//            // read until "Total" if applicable
//            boolean stopAtTotal = extraConfig != null
//                    && "YES".equalsIgnoreCase(safeStr(extraConfig.getTotalLogicEnabled()));
//            String totalKeyword = extraConfig != null ? safeStr(extraConfig.getTotalKeyword()) : "Total";
//            int totalColumnIdx = extraConfig != null ? extraConfig.getTotalColumnIndex() : -1;
//
//            List<Double> raw = ExcelUtils.readNumericColumnTillTotal(
//                    sheet, columnLetter, b.dataStartRow, stopAtTotal, totalKeyword, totalColumnIdx
//            );
//
//            // Apply filters if any (NOTE: filters assumed to be for this sheet)
//            List<Integer> rowHits = null;
//            if (filters != null && !filters.isEmpty()) {
//                rowHits = ExcelUtils.findAllRowsMatchingFilters(sheet, b.dataStartRow, filters);
//            }
//
//            if (rowHits == null || rowHits.isEmpty()) {
//                b.values = raw;
//            } else {
//                // retain only indices that are present in hits
//                // raw[0] corresponds to row dataStartRow
//                Set<Integer> hitSet = new HashSet<>(rowHits);
//                List<Double> filtered = new ArrayList<>();
//                int lastRow = sheet.getLastRowNum();
//                for (int i = 0; i < raw.size(); i++) {
//                    int physicalRowIndex = b.dataStartRow + i;
//                    if (physicalRowIndex <= lastRow && hitSet.contains(physicalRowIndex)) {
//                        filtered.add(raw.get(i));
//                    }
//                }
//                b.values = filtered;
//            }
//
//            b.ok = true;
//            return b;
//
//        } catch (Exception ex) {
//            b.ok = false;
//            b.bindError = "Bind failed: " + ex.getMessage();
//            return b;
//        }
//    }
//
//    /** Sum helper ignoring nulls. */
//    private static Double sumNonNull(List<Double> list) {
//        if (list == null || list.isEmpty()) return 0.0;
//        double s = 0.0;
//        for (Double d : list) if (d != null) s += d;
//        return s;
//    }
//
//    /** Tolerance check: relative to |expected| (RHS). If expected near 0, fallback to absolute tolerance. */
//    private static boolean withinTolerance(Double lhs, Double rhs, double tol) {
//        if (lhs == null && rhs == null) return true;
//        if (lhs == null || rhs == null) return false;
//        double diff = Math.abs(lhs - rhs);
//        double scale = Math.max(1.0, Math.abs(rhs));
//        return diff <= tol * scale;
//        // NOTE: if you prefer absolute tolerance, change to: return diff <= tol;
//    }
//
//    /** Encapsulate RHS computation result. */
//    private static class RHSComputation {
//        boolean ok;
//        String error;
//        List<Double> values = new ArrayList<>();
//        String displayInfo; // for HTML header (e.g., "Sheet1.C + Sheet1.D * 8.33%")
//    }
//
//    /** Compute RHS vector from tokens (row-wise OR totals mode). */
//    private static RHSComputation computeRhs(
//            Workbook wbRhs,
//            Workbook wbDownloadedForContext, // not used now but kept for future alignments
//            ExcelExpressionParser.ParsedRule rule,
//            String defaultSheetName,
//            Map<String, String> headerKeywords,
//            int startRowOffset,
//            ExcelExtraConfig extraConfig,
//            String rhsTag,                       // "MASTER" or "DOWNLOADED" (for logs)
//            List<ExcelFilter> rhsFilters,        // filters applied on RHS sheets (if any)
//            boolean rowByRow,
//            ExtentTest test
//    ) {
//        RHSComputation out = new RHSComputation();
//        try {
//            // Token-wise vectors or scalars
//            List<ExcelExpressionParser.Token> tokens = rule.rhsTokens;
//
//            // Prepare a human-friendly display
//            out.displayInfo = tokens.stream().map(t -> {
//                switch (t.type) {
//                    case OPERATOR: return t.operator;
//                    case NUMBER:   return String.valueOf(t.number);
//                    case COLUMN:
//                        String sh = t.sheetName != null ? t.sheetName : defaultSheetName;
//                        String key = headerKeywords != null ? headerKeywords.get(t.column) : null;
//                        return (sh + "." + t.column + (key != null ? " (" + key + ")" : ""));
//                    default: return "?";
//                }
//            }).collect(Collectors.joining(" "));
//
//            // Build vectors/scalars
//            List<List<Double>> colVectors = new ArrayList<>();
//            List<Double> numScalars = new ArrayList<>();
//            List<String> ops = new ArrayList<>();
//
//            for (ExcelExpressionParser.Token t : tokens) {
//                switch (t.type) {
//                    case OPERATOR:
//                        ops.add(t.operator);
//                        break;
//
//                    case NUMBER:
//                        // scalar → represent as a single-element list for uniformity
//                        numScalars.add(t.number);
//                        colVectors.add(Collections.singletonList(t.number));
//                        break;
//
//                    case COLUMN:
//                        String sheetName = t.sheetName != null ? t.sheetName : defaultSheetName;
//                        ColumnBinding cb = bindColumn(
//                                wbRhs,
//                       //       sheetName,
//                                normalizeSheetName(sheetName),
//                                t.column,
//                                headerKeywords,
//                                startRowOffset,
//                                extraConfig,
//                                rhsTag,
//                                rhsFilters,
//                                test
//                        );
//                        if (!cb.ok) {
//                            out.ok = false;
//                            out.error = "RHS column bind failed for " + sheetName + "." + t.column + ": " + cb.bindError;
//                            return out;
//                        }
//                        colVectors.add(cb.values);
//                        break;
//                }
//            }
//
//            // Evaluate
//            if (!rowByRow) {
//                // Totals: collapse each vector to scalar, then compute left-to-right
//                List<Double> collapsed = new ArrayList<>();
//                for (List<Double> v : colVectors) collapsed.add(sumNonNull(v));
//
//                Double acc = collapsed.get(0);
//                int opIdx = 0;
//                for (int i = 1; i < collapsed.size(); i++) {
//                    String op = ops.get(opIdx++);
//                    acc = apply(acc, collapsed.get(i), op);
//                }
//                out.values = Collections.singletonList(acc);
//                out.ok = true;
//                return out;
//            }
//
//            // Row-by-row: align by min length across vectors
//            int minLen = Integer.MAX_VALUE;
//            for (List<Double> v : colVectors) {
//                minLen = Math.min(minLen, v.size());
//            }
//            if (minLen == Integer.MAX_VALUE || minLen == 0) {
//                out.ok = false;
//                out.error = "No RHS rows available after binding.";
//                return out;
//            }
//
//            List<Double> rhsVals = new ArrayList<>(minLen);
//            for (int r = 0; r < minLen; r++) {
//                Double acc = colVectors.get(0).get(r);
//                int opIdx = 0;
//                for (int i = 1; i < colVectors.size(); i++) {
//                    String op = ops.get(opIdx++);
//                    Double v = colVectors.get(i).get(r);
//                    acc = apply(acc, v, op);
//                }
//                rhsVals.add(acc);
//            }
//
//            out.values = rhsVals;
//            out.ok = true;
//            return out;
//
//        } catch (Exception ex) {
//            out.ok = false;
//            out.error = "RHS computation failed: " + ex.getMessage();
//            return out;
//        }
//    }
//
//    /** Apply binary operation with null-safety (null treated as 0). Change policy if needed. */
//    private static Double apply(Double a, Double b, String op) {
//        double x = (a == null ? 0.0 : a);
//        double y = (b == null ? 0.0 : b);
//        switch (op) {
//            case "+": return x + y;
//            case "-": return x - y;
//            case "*": return x * y;
//            case "/": return (y == 0.0 ? 0.0 : x / y); // safe divide
//            default:  return 0.0;
//        }
//    }
//
//    private static String safeStr(String s) { return (s == null ? "" : s); }
//}
