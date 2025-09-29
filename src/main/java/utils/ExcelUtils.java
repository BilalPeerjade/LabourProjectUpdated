package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import org.apache.poi.ss.usermodel.*;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



//new for calcluations:
//====== Add these imports at the top if not present ======
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.util.*;
import java.util.regex.Pattern;
import java.lang.reflect.Method;


public class ExcelUtils {

    // ✅ Read specific column from master file with optional filter
    public static Set<String> readFilteredColumnValues(String filePath, String sheetName, int targetColumnIndex, List<ExcelF> filters) {
        Set<String> values = new HashSet<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) return values;

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // skip header
                boolean match = true;

                if (filters != null) {
                    for (ExcelF filter : filters) {
                        Cell filterCell = row.getCell(filter.getColumnIndex());
                        String cellValue = filterCell != null ? filterCell.toString().trim() : "";
                        if (!filter.getValues().contains(cellValue)) {
                            match = false;
                            break;
                        }
                    }
                }

                if (match) {
                    Cell targetCell = row.getCell(targetColumnIndex);
                    if (targetCell != null) {
                        String val = targetCell.toString().trim();
                        if (!val.isEmpty()) values.add(val);
                    }
                }
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return values;
    }
	
	
	

/**    // ✅ Read column values from downloaded Excel file
    public static Set<String> readColumnValues(File downloadedFile, String sheetName, int columnIndex) {
        Set<String> values = new HashSet<>();

        try (FileInputStream fis = new FileInputStream(downloadedFile)) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) return values;

            for (Row row : sheet) {
                Cell cell = row.getCell(columnIndex);
                if (cell != null) {
                    String val = cell.toString().trim();
                    if (!val.isEmpty()) values.add(val);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return values;
    }  **/

 // ✅ Read column values from downloaded Excel file
    public static Set<String> readColumnValues(File downloadedFile, String sheetName, int columnIndex) {
        Set<String> values = new HashSet<>();

        try (FileInputStream fis = new FileInputStream(downloadedFile)) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) return values;

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // ✅ Skip header row
                Cell cell = row.getCell(columnIndex);
                if (cell != null) {
                    String val = cell.toString().trim();
                    if (!val.isEmpty()) values.add(val);
                }
            }

            // 🆕 Enhancement: If all cells are empty in this column
            if (values.isEmpty()) {
                System.out.println("⚠ No values available in downloaded file for column index: " + columnIndex);
                
             //   test.log(LogStatus.PASS, "No data in cells");
                // Agar report me chahiye to ye karo:
             //    test.log(LogStatus.WARNING, "⚠ No values available in downloaded file for column index: " + columnIndex);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return values;
    }

    
    
    
    
    
    
 // ✅ Validate Total column till specific keyword row
    public static void validateTotalTillKeyword(
        File downloadedFile,
        com.relevantcodes.extentreports.ExtentTest test,
        ExcelTargetValidation target,
        ExcelExtraConfig config
    ) {
        try (FileInputStream fis = new FileInputStream(downloadedFile)) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(target.getSheetName());

            if (sheet == null) {
                test.log(com.relevantcodes.extentreports.LogStatus.FAIL, "❌ Sheet not found: " + target.getSheetName());
                return;
            }

            double calculatedSum = 0;
            Double totalCellValue = null;

            for (Row row : sheet) {
                Cell firstCell = row.getCell(0);
                if (firstCell != null && firstCell.getCellType() == CellType.STRING &&
                    firstCell.getStringCellValue().trim().equalsIgnoreCase(config.getStopAtKeyword())) {
                    
                    // ✅ Stop here and get total cell
                    Cell totalCell = row.getCell(config.getTotalColumnIndex());
                    if (totalCell != null && totalCell.getCellType() == CellType.NUMERIC) {
                        totalCellValue = totalCell.getNumericCellValue();
                    }
                    break;
                }

                Cell cell = row.getCell(target.getColumnIndex());
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    calculatedSum += cell.getNumericCellValue();
                }
            }

            if (totalCellValue == null) {
                test.log(com.relevantcodes.extentreports.LogStatus.FAIL, "❌ 'Total' row or cell not found.");
            } else {
                if (Math.abs(calculatedSum - totalCellValue) <= 1.0) { // small tolerance
                    test.log(com.relevantcodes.extentreports.LogStatus.PASS,
                        "✅ Total matched. Expected: " + calculatedSum + ", Found: " + totalCellValue);
                } else {
                    test.log(com.relevantcodes.extentreports.LogStatus.FAIL,
                        "❌ Total mismatch. Expected: " + calculatedSum + ", Found: " + totalCellValue);
                }
            }

        } catch (Exception e) {
            test.log(com.relevantcodes.extentreports.LogStatus.ERROR, "❌ Exception during total validation: " + e.getMessage());
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 // ✅ Convert alias to actual sheet name (auto replace underscores with spaces)
    public static String normalizeSheetName(String sheetName) {
        if (sheetName == null) return null;
        // Replace underscores with spaces
        return sheetName.replace("_", " ").trim();
    }

    
    
    
    
    
    
    
    
    //Calculation part:------------
    
 // ====== Paste below methods inside ExcelUtils class ======

    /** Convert column letter(s) (e.g., "A", "D", "AA") to zero-based index (A=0). */
    public static int colLetterToIndex(String letter) {
        if (letter == null || letter.trim().isEmpty())
            throw new IllegalArgumentException("Column letter is null/empty");
        String s = letter.trim().toUpperCase(Locale.ROOT);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 'A' || c > 'Z') {
                throw new IllegalArgumentException("Invalid column letter: " + letter);
            }
            result = result * 26 + (c - 'A' + 1);
        }
        return result - 1; // zero-based
    }

    /** Convert zero-based column index to Excel letters (0=A, 27=AB). */
    public static String indexToColLetter(int index) {
        if (index < 0) throw new IllegalArgumentException("Index cannot be negative: " + index);
        StringBuilder sb = new StringBuilder();
        int n = index + 1; // switch to 1-based for letter math
        while (n > 0) {
            int rem = (n - 1) % 26;
            sb.append((char)('A' + rem));
            n = (n - 1) / 26;
        }
        return sb.reverse().toString();
    }

    /**
     * Find the row index (0-based) where a header/keyword appears ANYWHERE in the sheet.
     * Case-insensitive, trims cells. Returns -1 if not found.
     */
    public static int findHeaderRowAnywhere(Sheet sheet, String headerKeyword) {
        if (sheet == null || headerKeyword == null) return -1;
        String needle = headerKeyword.trim().toLowerCase(Locale.ROOT);
        for (Row row : sheet) {
            for (Cell cell : row) {
                String v = getString(cell);
                if (v != null && v.trim().toLowerCase(Locale.ROOT).equals(needle)) {
                    return row.getRowNum();
                }
            }
        }
        return -1;
    }

    /**
     * Find the row index (0-based) where a header/keyword appears in a SPECIFIC column letter.
     * If not found => -1.
     */
    public static int findHeaderRowInColumn(Sheet sheet, String columnLetter, String headerKeyword) {
        if (sheet == null || columnLetter == null || headerKeyword == null) return -1;
        int col = colLetterToIndex(columnLetter);
        String needle = headerKeyword.trim().toLowerCase(Locale.ROOT);
        for (Row row : sheet) {
            Cell cell = row.getCell(col);
            String v = getString(cell);
            if (v != null && v.trim().toLowerCase(Locale.ROOT).equals(needle)) {
                return row.getRowNum();
            }
        }
        return -1;
    }

    /**
     * Compute data start row given a found header row and an offset (rows to skip after header).
     * If headerRow < 0, returns -1.
     */
    public static int resolveDataStartRow(int headerRow, int startRowOffset) {
        if (headerRow < 0) return -1;
        int start = headerRow + Math.max(1, startRowOffset); // at least 1 row after header
        return start;
    }

    /**
     * Read numeric values from a given column (letter) starting at startRow,
     * optionally stopping when a "Total" row is encountered.
     *
     * @param totalKeyword         e.g., "Total" (case-insensitive). If null/empty and stopAtTotal=true, defaults to "Total".
     * @param totalCheckColumnIdx  If >= 0, only check this column for totalKeyword.
     *                             If < 0, scan the ENTIRE ROW for totalKeyword.
     */
//    public static List<Double> readNumericColumnTillTotal(
//            Sheet sheet,
//            String columnLetter,
//            int startRow,
//            boolean stopAtTotal,
//            String totalKeyword,
//            int totalCheckColumnIdx
//    ) {
//        List<Double> out = new ArrayList<>();
//        if (sheet == null || columnLetter == null) return out;
//
//        int col = colLetterToIndex(columnLetter);
//        String totalNeedle = (totalKeyword == null || totalKeyword.trim().isEmpty())
//                ? "total"
//                : totalKeyword.trim().toLowerCase(Locale.ROOT);
//
//        int last = sheet.getLastRowNum();
///*        for (int r = Math.max(0, startRow); r <= last; r++) {
//            Row row = sheet.getRow(r);
//            if (row == null) continue;
//
//            if (stopAtTotal && isTotalRow(row, totalNeedle, totalCheckColumnIdx)) {
//                break;
//            }
//
//            Cell cell = row.getCell(col);
//            Double val = getNumeric(cell);
//            if (val != null) out.add(val);
//        } */
//        for (int r = Math.max(0, startRow); r <= last; r++) {
//            Row row = sheet.getRow(r);
//            if (row == null) continue;
//
//            // 🛑 Agar total mode ON hai aur current row hi "Total" row hai → loop break
//            if (stopAtTotal && isTotalRow(row, totalNeedle, totalCheckColumnIdx)) {
//                break;
//            }
//
//            // ✅ Row-by-row values sirf tab lo jab Total logic disabled ho
//            if (!stopAtTotal) {
//                Cell cell = row.getCell(col);
//                Double val = getNumeric(cell);
//                if (val != null) out.add(val);
//            }
//        } 
//        return out;
//    }
    
    public static List<Double> readNumericColumnTillTotal(
            Sheet sheet,
            String columnLetter,
            int startRow,
            boolean stopAtTotal,
            String totalKeyword,
            int totalCheckColumnIdx
    ) {
        List<Double> out = new ArrayList<>();
        if (sheet == null || columnLetter == null) return out;

        int col = colLetterToIndex(columnLetter);
        int last = sheet.getLastRowNum();

        String totalNeedle = (totalKeyword == null || totalKeyword.trim().isEmpty())
                ? "total"
                : totalKeyword.trim().toLowerCase(Locale.ROOT);

        // 👉 CASE 1: Agar sirf TOTAL logic enable hai → directly "Total" row pick karo, upper rows ignore
        if (stopAtTotal) {
            for (int r = Math.max(0, startRow); r <= last; r++) {
                Row row = sheet.getRow(r);
                if (row == null) continue;

                if (isTotalRow(row, totalNeedle, totalCheckColumnIdx)) {
                    Cell cell = row.getCell(col);
                    Double val = getNumeric(cell);
                    if (val != null) out.add(val);
                    break; // 🛑 total mil gaya → loop stop
                }
            }
            return out;
        }

        // 👉 CASE 2: Normal row-by-row reading (ignore "Total" row if encountered)
        for (int r = Math.max(0, startRow); r <= last; r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;

            if (isTotalRow(row, totalNeedle, totalCheckColumnIdx)) {
                // "Total" row skip karna hai row-by-row mode me
                continue;
            }

            Cell cell = row.getCell(col);
            Double val = getNumeric(cell);
            if (val != null) out.add(val);
        }

        return out;
    }

    
    
    

    /**
     * Check if a row is a "Total" row.
     * If totalCheckColumnIdx >= 0, only that column is checked.
     * If totalCheckColumnIdx < 0, ANY text cell in the row equal to totalKeyword matches.
     */
/*    public static boolean isTotalRow(Row row, String totalKeywordLower, int totalCheckColumnIdx) {
        if (row == null || totalKeywordLower == null) return false;

        if (totalCheckColumnIdx >= 0) {
            Cell c = row.getCell(totalCheckColumnIdx);
            String v = getString(c);
            return v != null && v.trim().toLowerCase(Locale.ROOT).equals(totalKeywordLower);
        } else {
            for (Cell c : row) {
                String v = getString(c);
                if (v != null && v.trim().toLowerCase(Locale.ROOT).equals(totalKeywordLower)) {
                    return true;
                }
            }
            return false;
        }
    } */
    
    public static boolean isTotalRow(Row row, String totalNeedle, int totalCheckColumnIdx) {
        if (row == null) return false;

        String needle = (totalNeedle == null ? "total" : totalNeedle).trim().toLowerCase(Locale.ROOT);

        if (totalCheckColumnIdx >= 0) {
            Cell cell = row.getCell(totalCheckColumnIdx);
            String val = getString(cell);
            if (val == null) return false;

            // normalize: remove extra spaces & lowercase
            val = val.replace("\u00A0", " ") // non-breaking space hatao
                     .trim()
                     .toLowerCase(Locale.ROOT);

            // contains bhi allow karo
            return val.contains(needle);
        } else {
            for (Cell c : row) {
                String val = getString(c);
                if (val == null) continue;

                val = val.replace("\u00A0", " ")
                         .trim()
                         .toLowerCase(Locale.ROOT);

                if (val.contains(needle)) return true;
            }
            return false;
        }
    }


    

    /** Safe string getter for any cell. */
    public static String getString(Cell cell) {
        if (cell == null) return null;
        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    // usually not needed for headers; keep as string if required
                    return cell.getDateCellValue().toString();
                }
                double d = cell.getNumericCellValue();
                // avoid 1.0 => "1.0" trailing; format light-touch
                if (Math.floor(d) == d) return String.valueOf((long)d);
                return String.valueOf(d);
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                try {
                    // try numeric first
                    double nd = cell.getNumericCellValue();
                    if (Math.floor(nd) == nd) return String.valueOf((long)nd);
                    return String.valueOf(nd);
                } catch (Exception ex) {
                    try {
                        return cell.getStringCellValue();
                    } catch (Exception ignore) {
                        return null;
                    }
                }
            default: return null;
        }
    }

    /** Safe numeric getter (parses numeric or numeric-looking strings). */
    public static Double getNumeric(Cell cell) {
        if (cell == null) return null;
        try {
            switch (cell.getCellType()) {
                case NUMERIC:
                    return DateUtil.isCellDateFormatted(cell) ? null : cell.getNumericCellValue();
                case STRING:
                    String s = cell.getStringCellValue();
                    if (s != null) {
                        s = s.trim().replaceAll(",", "");
                        if (s.isEmpty()) return null;
                        // allow +/- and decimals
                        if (Pattern.matches("[-+]?\\d*(\\.\\d+)?", s)) {
                            return s.equals("+") || s.equals("-") ? null : Double.valueOf(s);
                        }
                    }
                    return null;
                case FORMULA:
                    try { return cell.getNumericCellValue(); } catch (Exception ex) { return null; }
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Find FIRST row index >= searchFrom where ALL filters match.
     * Each filter is (columnIndex, acceptedValues). Case-insensitive, trims.
     * NOTE: This helper expects an ExcelFilter with getters: getColumnIndex(), getAcceptedValues().
     */
    public static int findFirstRowMatchingFilters(
            Sheet sheet,
            int searchFrom,
            List<?> filters
    ) {
        if (sheet == null) return -1;
        if (filters == null || filters.isEmpty()) return searchFrom;

        int last = sheet.getLastRowNum();
        for (int r = Math.max(0, searchFrom); r <= last; r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;

            boolean allOk = true;
            for (Object f : filters) {
                int col = getFilterColumnIndex(f);
                List<String> acc = getFilterAcceptedValues(f);

                String cellVal = getString(row.getCell(col));
                String cellNorm = (cellVal == null ? "" : cellVal.trim().toLowerCase(Locale.ROOT));

                boolean anyMatch = false;
                for (String v : acc) {
                    if (v != null && cellNorm.equals(v.trim().toLowerCase(Locale.ROOT))) {
                        anyMatch = true; break;
                    }
                }
                if (!anyMatch) { allOk = false; break; }
            }
            if (allOk) return r;
        }
        return -1;
    }

    public static List<Integer> findAllRowsMatchingFilters(
            Sheet sheet,
            int searchFrom,
            List<?> filters
    ) {
        List<Integer> hits = new ArrayList<>();
        if (sheet == null) return hits;

        if (filters == null || filters.isEmpty()) {
            int last = sheet.getLastRowNum();
            for (int r = Math.max(0, searchFrom); r <= last; r++) hits.add(r);
            return hits;
        }

        int last = sheet.getLastRowNum();
        for (int r = Math.max(0, searchFrom); r <= last; r++) {
            Row row = sheet.getRow(r);
            if (row == null) continue;

            boolean allOk = true;
            for (Object f : filters) {
                int col = getFilterColumnIndex(f);
                List<String> acc = getFilterAcceptedValues(f);

                String cellVal = getString(row.getCell(col));
                String cellNorm = (cellVal == null ? "" : cellVal.trim().toLowerCase(Locale.ROOT));

                boolean anyMatch = false;
                for (String v : acc) {
                    if (v != null && cellNorm.equals(v.trim().toLowerCase(Locale.ROOT))) {
                        anyMatch = true; break;
                    }
                }
                if (!anyMatch) { allOk = false; break; }
            }
            if (allOk) hits.add(r);
        }
        return hits;
    }

    
 // ✅ Convert Excel column letter (A, B, C … AA …) to zero-based index
    public static int columnLetterToIndex(String columnLetter) {
        int result = 0;
        for (int i = 0; i < columnLetter.length(); i++) {
            char ch = columnLetter.charAt(i);
            result = result * 26 + (ch - 'A' + 1);
        }
        return result - 1; // zero-based index
    }

    
    
    
    
    
    
    
    
    
    
    //Added new for calculations:
    /** Try to read column index from a filter via common getter names. */
    public static int getFilterColumnIndex(Object filter) {
        Integer idx = tryInvokeIntGetter(filter, "getColumnIndex",
                                         "getFilterColumnIndex", "getColumn", "getIndex");
        if (idx == null) {
            throw new IllegalStateException("ExcelFilter column index getter not found. "
                + "Tried getColumnIndex/getFilterColumnIndex/getColumn/getIndex");
        }
        return idx;
    }

    /** Try to read accepted values list from a filter via common getter names. */
    @SuppressWarnings("unchecked")
    public static List<String> getFilterAcceptedValues(Object filter) {
        Object values = tryInvokeObjectGetter(filter, "getAcceptedValues",
                                              "getFilterValues", "getValues", "getAllowedValues");
        if (values == null) {
            throw new IllegalStateException("ExcelFilter values getter not found. "
                + "Tried getAcceptedValues/getFilterValues/getValues/getAllowedValues");
        }
        if (values instanceof List) {
            return (List<String>) values;
        } else if (values instanceof Collection) {
            return new ArrayList<>((Collection<String>) values);
        } else {
            throw new IllegalStateException("ExcelFilter values getter did not return a Collection/List");
        }
    }

    /* ==== small reflection helpers ==== */
    private static Integer tryInvokeIntGetter(Object obj, String... methodNames) {
        for (String m : methodNames) {
            try {
                Method mm = obj.getClass().getMethod(m);
                Object v = mm.invoke(obj);
                if (v instanceof Number) return ((Number) v).intValue();
            } catch (Exception ignore) {}
        }
        return null;
    }
    private static Object tryInvokeObjectGetter(Object obj, String... methodNames) {
        for (String m : methodNames) {
            try {
                Method mm = obj.getClass().getMethod(m);
                return mm.invoke(obj);
            } catch (Exception ignore) {}
        }
        return null;
    }

    
    
    
    
    public static Double readTotalCellValue(Sheet sheet, String columnLetter, String totalKeyword, int totalColumnIdx) {
        int colIdx = columnLetterToIndex(columnLetter);
        for (Row row : sheet) {
            Cell keyCell = row.getCell(totalColumnIdx); // usually "Total" column
            if (keyCell != null && keyCell.getCellType() == CellType.STRING) {
                if (totalKeyword.equalsIgnoreCase(keyCell.getStringCellValue().trim())) {
                    Cell valCell = row.getCell(colIdx);
                    if (valCell != null && valCell.getCellType() == CellType.NUMERIC) {
                        return valCell.getNumericCellValue();
                    }
                }
            }
        }
        return null;
    }

    
    
    
    
    
    
    
}
