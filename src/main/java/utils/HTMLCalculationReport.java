package utils;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.List;

/**
 * 📊 HTMLCalculationReport (v2-friendly, tolerance-aware)
 *
 * - ENABLE_HTML_REPORT_TABLE = true (default)
 * - Clean UI: neat headers, centered cells, PASS/FAIL pill badges
 * - Row-by-row: Row No. | MASTER VALUE (RHS) | DOWNLOADED VALUE (LHS) | RESULT
 * - Totals:     MASTER VALUE (RHS) | DOWNLOADED VALUE (LHS) | RESULT
 * - Master (RHS) header: compact like "Q: PT Gross"
 * - Downloaded (LHS) header: only the column letter (e.g., "I")
 * - Uses 3-arg ExtentReports v2 log to ensure HTML renders
 *
 * NOTE: Methods now accept `double tol` (fractional tolerance, e.g., 0.05 for 5%).
 */
public class HTMLCalculationReport {

    // Turn on/off once here; calling time pe kuch pass karne ki zarurat nahi
    public static boolean ENABLE_HTML_REPORT_TABLE = true;
    
    
 //   public static int HTML_REPORT_SAMPLE_ROWS = 5; //for 5 rows rowByrowLogic but not working

    // ---------- Public API ----------

    /** Row-by-row report (first 5 rows). IMPORTANT: pass tolerance as fraction (0.05 = 5%). */
    
    
    
    
    public static void logRowByRowTable(
            ExtentTest test,
            String title,
            String lhsSheetName,
            String lhsColumnLetter,
            String lhsHeaderName,
            String rhsExpression,
            List<Double> lhsValues,
            List<Double> rhsValues,
            double tol
    ) {
    	
    	
    	
    	
    	
        if (!ENABLE_HTML_REPORT_TABLE || test == null) return;

        // Prepare compact headers
        String masterHeader = prettyRhsHeader(rhsExpression);       // e.g., "Q: PT Gross"
        String downloadedHeader = prettyDownloadedHeader(lhsColumnLetter); // e.g., "I"

        StringBuilder sb = new StringBuilder();

        // Title
        sb.append("<div style='margin:6px 0 10px; font-weight:700; font-family:Arial, sans-serif;'>")
          .append(safe(title))
          .append("</div>");

/**      // Meta info //This will show formula need to discuss with sir if allowed we can add 
        sb.append("<div style='margin:0 0 10px; font-size:12px; font-family:Arial, sans-serif; color:#374151; white-space:nowrap;'>")
          .append("<b>LHS (Downloaded):</b> ").append(safe(lhsSheetName)).append(".").append(safe(lhsColumnLetter))
          .append("&nbsp;&nbsp;")
          .append("<b>RHS (Master):</b> ").append(safe(rhsExpression))
          .append("</div>"); **/

        // Table
        sb.append("<table style='border-collapse:collapse; width:100%; font-family:Arial, sans-serif; font-size:13px;'>");

        // Header row
        sb.append("<thead><tr>")
          .append(th("ROW NO.", 80))
          .append(th("MASTER VALUE<br><small style=\"font-weight:400;\">" + safe(masterHeader) + "</small>", 220))
          .append(th("DOWNLOADED VALUE<br><small style=\"font-weight:400;\">" + safe(downloadedHeader) + "</small>", 220))
          .append(th("RESULT", 120))
          .append("</tr></thead>");

        sb.append("<tbody>");

          int limit = Math.min(Math.min(safeSize(lhsValues), safeSize(rhsValues)), 5);
 //       int limit = Math.min(Math.min(safeSize(lhsValues), safeSize(rhsValues)), HTML_REPORT_SAMPLE_ROWS);

        for (int i = 0; i < limit; i++) {
            Double lv = lhsValues.get(i); // Downloaded
            Double rv = rhsValues.get(i); // Master/Calculated
            boolean ok = withinTolerance(lv, rv, tol);

            sb.append("<tr>")
              .append(tdCenter(String.valueOf(i + 1)))
              // NOTE: Master (RHS) first, Downloaded (LHS) second
              .append(tdCenter(fmt(rv)))
              .append(tdCenter(fmt(lv)))
              .append(tdCenter(ok
                      ? pill("PASS", true)
                      : pill("FAIL", false)))
              .append("</tr>");
        }

        sb.append("</tbody></table>");

        // Force render in ExtentReports v2 (pass HTML in details argument)
        test.log(LogStatus.INFO, sb.toString(), "");
    }

    /** Totals-only report (tolerance-aware). */
    public static void logTotalsTable(
            ExtentTest test,
            String title,
            String lhsSheetName,
            String lhsColumnLetter,
            String lhsHeaderName,
            String rhsExpression,
            Double lhsTotal,
            Double rhsTotal,
            double tol
    ) {
        if (!ENABLE_HTML_REPORT_TABLE || test == null) return;

        String masterHeader = prettyRhsHeader(rhsExpression);
        String downloadedHeader = prettyDownloadedHeader(lhsColumnLetter);
        boolean ok = withinTolerance(lhsTotal, rhsTotal, tol);

        StringBuilder sb = new StringBuilder();

        // Title
        sb.append("<div style='margin:6px 0 10px; font-weight:700; font-family:Arial, sans-serif;'>")
          .append(safe(title))
          .append("</div>");

/**        // Meta //This will show formula need to discuss with sir if allowed we can add 
        sb.append("<div style='margin:0 0 10px; font-size:12px; font-family:Arial, sans-serif; color:#374151; white-space:nowrap;'>")
          .append("<b>LHS (Downloaded):</b> ").append(safe(lhsSheetName)).append(".").append(safe(lhsColumnLetter))
          .append("&nbsp;&nbsp;")
          .append("<b>RHS (Master):</b> ").append(safe(rhsExpression))
          .append("</div>"); **/

        // Table
        sb.append("<table style='border-collapse:collapse; width:100%; font-family:Arial, sans-serif; font-size:13px;'>")
          .append("<thead><tr>")
          .append(th("MASTER VALUE<br><small style=\"font-weight:400;\">" + safe(masterHeader) + "</small>", 240))
          .append(th("DOWNLOADED VALUE<br><small style=\"font-weight:400;\">" + safe(downloadedHeader) + "</small>", 240))
          .append(th("RESULT", 120))
          .append("</tr></thead><tbody>");

        // NOTE: first TD = Master (RHS), second TD = Downloaded (LHS)
        sb.append("<tr>")
          .append(tdCenter(fmt(rhsTotal)))
          .append(tdCenter(fmt(lhsTotal)))
          .append(tdCenter(ok ? pill("PASS", true) : pill("FAIL", false)))
          .append("</tr>");

        sb.append("</tbody></table>");

        test.log(LogStatus.INFO, sb.toString(), "");
    }

    // ---------- Helpers (UI) ----------

    private static String th(String label, int minWidthPx) {
        return "<th style='background:#f7f7f9; border:1px solid #e5e7eb; padding:8px 10px; " +
                "text-align:center; text-transform:uppercase; letter-spacing:.4px; " +
                "min-width:" + minWidthPx + "px; white-space:nowrap;'>" + label + "</th>";
    }

    private static String tdCenter(String val) {
        return "<td style='border:1px solid #e5e7eb; padding:10px; text-align:center; white-space:nowrap;'>" +
                safe(val) + "</td>";
    }

    private static String pill(String text, boolean pass) {
        return "<span style='display:inline-block; padding:2px 12px; border-radius:999px; " +
                "background:" + (pass ? "#ecfdf5" : "#fef2f2") + "; " +
                "color:" + (pass ? "#065f46" : "#991b1b") + "; font-weight:700;'>" +
                safe(text) + "</span>";
    }

    // ---------- Helpers (data/format) ----------

    private static String safe(String s) {
        return (s == null) ? "" : s;
    }

    private static int safeSize(List<?> list) {
        return (list == null) ? 0 : list.size();
    }

    private static boolean bothNotNull(Double a, Double b) {
        return a != null && b != null;
    }

    private static String fmt(Double d) {
        if (d == null) return "";
        if (Math.abs(d - Math.rint(d)) < 1e-9) return String.valueOf(d.longValue());
        return String.valueOf(d);
    }

    /** Convert Excel column letter (e.g., "A", "L", "AA") to 0-based index for display if needed */
    @SuppressWarnings("unused")
    private static int colLetterToIndexSafe(String col) {
        if (col == null || col.isEmpty()) return -1;
        int res = 0;
        for (int i = 0; i < col.length(); i++) {
            char c = Character.toUpperCase(col.charAt(i));
            if (c < 'A' || c > 'Z') return -1;
            res = res * 26 + (c - 'A' + 1);
        }
        return res - 1; // zero-based
    }

    /** Make RHS expression concise for header: e.g., "MonthlyEmployeeSalary.Q (PT Gross)" -> "Q: PT Gross" */
    private static String prettyRhsHeader(String rhsExpression) {
        if (rhsExpression == null) return "";
        try {
            String s = rhsExpression.trim();

            // find first column letters after a dot
            String col = null;
            int dot = s.indexOf('.');
            if (dot >= 0) {
                for (int i = dot + 1; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c >= 'A' && c <= 'Z') {
                        int j = i;
                        while (j < s.length()) {
                            char c2 = s.charAt(j);
                            if (c2 < 'A' || c2 > 'Z') break;
                            j++;
                        }
                        col = s.substring(i, j);
                        break;
                    }
                }
            }

            // try to capture header text in parentheses
            String header = null;
            int paren = s.indexOf('(');
            if (paren >= 0) {
                int close = s.indexOf(')', paren + 1);
                if (close > paren) header = s.substring(paren + 1, close).trim();
            }

            if (col != null && header != null && !header.isEmpty()) return col + ": " + header;
            if (col != null) return col;
            return rhsExpression;
        } catch (Exception e) {
            return rhsExpression;
        }
    }

    /** For downloaded header, show only the column letter (e.g., "I"). */
    private static String prettyDownloadedHeader(String lhsColumnLetter) {
        return (lhsColumnLetter == null) ? "" : lhsColumnLetter.trim();
    }

    /**
     * Tolerance check consistent with CommonBusinessUtilis3:
     * relative to rhs (expected). If expected near 0, fallback scale = 1.0
     */
    private static boolean withinTolerance(Double lhs, Double rhs, double tol) {
        if (lhs == null && rhs == null) return true;
        if (lhs == null || rhs == null) return false;
        double diff = Math.abs(lhs - rhs);
        double scale = Math.max(1.0, Math.abs(rhs));
        return diff <= tol * scale;
    }
}







































//package utils;
//
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//
//import java.util.List;
//
///**
// * 📊 HTMLCalculationReport (v2-friendly)
// *
// * - ENABLE_HTML_REPORT_TABLE = true (default)
// * - Clean UI: neat headers, centered cells, PASS/FAIL pill badges
// * - Row-by-row: Row No. | MASTER VALUE (RHS) | DOWNLOADED VALUE (LHS) | RESULT
// * - Totals:     MASTER VALUE (RHS) | DOWNLOADED VALUE (LHS) | RESULT
// * - Master (RHS) header: compact like "Q: PT Gross"
// * - Downloaded (LHS) header: only the column letter (e.g., "I")
// * - Uses 3-arg ExtentReports v2 log to ensure HTML renders
// */
//public class HTMLCalculationReport {
//
//    // Turn on/off once here; calling time pe kuch pass karne ki zarurat nahi
//    public static boolean ENABLE_HTML_REPORT_TABLE_Calculation = true;
//
//    // ---------- Public API ----------
//
//    /** Row-by-row report (first 5 rows) */
//    public static void logRowByRowTable(
//            ExtentTest test,
//            String title,
//            String lhsSheetName,     // downloaded sheet name (for meta only)
//            String lhsColumnLetter,  // downloaded column letter (LHS)
//            String lhsHeaderName,    // downloaded header (unused for new header text; meta only)
//            String rhsExpression,    // RHS expression (Master side)
//            List<Double> lhsValues,  // LHS values (Downloaded)
//            List<Double> rhsValues   // RHS values (Master / calculated)
//    ) {
//        if (!ENABLE_HTML_REPORT_TABLE_Calculation || test == null) return;
//
//        // Prepare compact headers
//        String masterHeader = prettyRhsHeader(rhsExpression);       // e.g., "Q: PT Gross"
//        String downloadedHeader = prettyDownloadedHeader(lhsColumnLetter); // e.g., "I"
//
//        StringBuilder sb = new StringBuilder();
//
//        // Title
//        sb.append("<div style='margin:6px 0 10px; font-weight:700; font-family:Arial, sans-serif;'>")
//          .append(safe(title))
//          .append("</div>");
//
//        // Meta info
//        sb.append("<div style='margin:0 0 10px; font-size:12px; font-family:Arial, sans-serif; color:#374151; white-space:nowrap;'>")
//          .append("<b>LHS (Downloaded):</b> ").append(safe(lhsSheetName)).append(".").append(safe(lhsColumnLetter))
//          .append("&nbsp;&nbsp;")
//          .append("<b>RHS (Master):</b> ").append(safe(rhsExpression))
//          .append("</div>");
//
//        // Table
//        sb.append("<table style='border-collapse:collapse; width:100%; font-family:Arial, sans-serif; font-size:13px;'>");
//
//        // Header row
//        sb.append("<thead><tr>")
//          .append(th("ROW NO.", 80))
//          .append(th("MASTER VALUE<br><small style=\"font-weight:400;\">" + safe(masterHeader) + "</small>", 220))
//          .append(th("DOWNLOADED VALUE<br><small style=\"font-weight:400;\">" + safe(downloadedHeader) + "</small>", 220))
//          .append(th("RESULT", 120))
//          .append("</tr></thead>");
//
//        sb.append("<tbody>");
//
//        int limit = Math.min(Math.min(safeSize(lhsValues), safeSize(rhsValues)), 5);
//        for (int i = 0; i < limit; i++) {
//            Double lv = lhsValues.get(i); // Downloaded
//            Double rv = rhsValues.get(i); // Master/Calculated
//            boolean ok = bothNotNull(lv, rv) && Math.abs(lv - rv) < 0.01;
//
//            sb.append("<tr>")
//              .append(tdCenter(String.valueOf(i + 1)))
//              // NOTE: Master (RHS) first, Downloaded (LHS) second
//              .append(tdCenter(fmt(rv)))
//              .append(tdCenter(fmt(lv)))
//              .append(tdCenter(ok
//                      ? pill("PASS", true)
//                      : pill("FAIL", false)))
//              .append("</tr>");
//        }
//
//        sb.append("</tbody></table>");
//
//        // Force render in ExtentReports v2
//        test.log(LogStatus.INFO, sb.toString(), "");
//    }
//
//    /** Totals-only report */
//    public static void logTotalsTable(
//            ExtentTest test,
//            String title,
//            String lhsSheetName,     // downloaded sheet name (for meta only)
//            String lhsColumnLetter,  // downloaded column letter (LHS)
//            String lhsHeaderName,    // downloaded header (unused for new header text; meta only)
//            String rhsExpression,    // RHS expression (Master side)
//            Double lhsTotal,         // LHS total (Downloaded)
//            Double rhsTotal          // RHS total (Master/Calculated)
//    ) {
//        if (!ENABLE_HTML_REPORT_TABLE_Calculation || test == null) return;
//
//        String masterHeader = prettyRhsHeader(rhsExpression);
//        String downloadedHeader = prettyDownloadedHeader(lhsColumnLetter);
//        boolean ok = bothNotNull(lhsTotal, rhsTotal) && Math.abs(lhsTotal - rhsTotal) < 0.01;
//
//        StringBuilder sb = new StringBuilder();
//
//        // Title
//        sb.append("<div style='margin:6px 0 10px; font-weight:700; font-family:Arial, sans-serif;'>")
//          .append(safe(title))
//          .append("</div>");
//
//        // Meta
//        sb.append("<div style='margin:0 0 10px; font-size:12px; font-family:Arial, sans-serif; color:#374151; white-space:nowrap;'>")
//          .append("<b>LHS (Downloaded):</b> ").append(safe(lhsSheetName)).append(".").append(safe(lhsColumnLetter))
//          .append("&nbsp;&nbsp;")
//          .append("<b>RHS (Master):</b> ").append(safe(rhsExpression))
//          .append("</div>");
//
//        // Table
//        sb.append("<table style='border-collapse:collapse; width:100%; font-family:Arial, sans-serif; font-size:13px;'>")
//          .append("<thead><tr>")
//          .append(th("MASTER VALUE<br><small style=\"font-weight:400;\">" + safe(masterHeader) + "</small>", 240))
//          .append(th("DOWNLOADED VALUE<br><small style=\"font-weight:400;\">" + safe(downloadedHeader) + "</small>", 240))
//          .append(th("RESULT", 120))
//          .append("</tr></thead><tbody>");
//
//        // NOTE: first TD = Master (RHS), second TD = Downloaded (LHS)
//        sb.append("<tr>")
//          .append(tdCenter(fmt(rhsTotal)))
//          .append(tdCenter(fmt(lhsTotal)))
//          .append(tdCenter(ok ? pill("PASS", true) : pill("FAIL", false)))
//          .append("</tr>");
//
//        sb.append("</tbody></table>");
//
//        test.log(LogStatus.INFO, sb.toString(), "");
//    }
//
//    // ---------- Helpers (UI) ----------
//
//    private static String th(String label, int minWidthPx) {
//        return "<th style='background:#f7f7f9; border:1px solid #e5e7eb; padding:8px 10px; " +
//                "text-align:center; text-transform:uppercase; letter-spacing:.4px; " +
//                "min-width:" + minWidthPx + "px; white-space:nowrap;'>" + label + "</th>";
//    }
//
//    private static String tdCenter(String val) {
//        return "<td style='border:1px solid #e5e7eb; padding:10px; text-align:center; white-space:nowrap;'>" +
//                safe(val) + "</td>";
//    }
//
//    private static String pill(String text, boolean pass) {
//        return "<span style='display:inline-block; padding:2px 12px; border-radius:999px; " +
//                "background:" + (pass ? "#ecfdf5" : "#fef2f2") + "; " +
//                "color:" + (pass ? "#065f46" : "#991b1b") + "; font-weight:700;'>" +
//                safe(text) + "</span>";
//    }
//
//    // ---------- Helpers (data/format) ----------
//
//    private static String safe(String s) {
//        return (s == null) ? "" : s;
//    }
//
//    private static int safeSize(List<?> list) {
//        return (list == null) ? 0 : list.size();
//    }
//
//    private static boolean bothNotNull(Double a, Double b) {
//        return a != null && b != null;
//    }
//
//    private static String fmt(Double d) {
//        if (d == null) return "";
//        if (Math.abs(d - Math.rint(d)) < 1e-9) return String.valueOf(d.longValue());
//        return String.valueOf(d);
//    }
//
//    /** Convert Excel column letter (e.g., "A", "L", "AA") to 0-based index for display if needed */
//    @SuppressWarnings("unused")
//    private static int colLetterToIndexSafe(String col) {
//        if (col == null || col.isEmpty()) return -1;
//        int res = 0;
//        for (int i = 0; i < col.length(); i++) {
//            char c = Character.toUpperCase(col.charAt(i));
//            if (c < 'A' || c > 'Z') return -1;
//            res = res * 26 + (c - 'A' + 1);
//        }
//        return res - 1; // zero-based
//    }
//
//    /** Make RHS expression concise for header: e.g., "MonthlyEmployeeSalary.Q (PT Gross)" -> "Q: PT Gross" */
//    private static String prettyRhsHeader(String rhsExpression) {
//        if (rhsExpression == null) return "";
//        try {
//            String s = rhsExpression.trim();
//
//            // find first column letters after a dot
//            String col = null;
//            int dot = s.indexOf('.');
//            if (dot >= 0) {
//                for (int i = dot + 1; i < s.length(); i++) {
//                    char c = s.charAt(i);
//                    if (c >= 'A' && c <= 'Z') {
//                        int j = i;
//                        while (j < s.length()) {
//                            char c2 = s.charAt(j);
//                            if (c2 < 'A' || c2 > 'Z') break;
//                            j++;
//                        }
//                        col = s.substring(i, j);
//                        break;
//                    }
//                }
//            }
//
//            // try to capture header text in parentheses
//            String header = null;
//            int paren = s.indexOf('(');
//            if (paren >= 0) {
//                int close = s.indexOf(')', paren + 1);
//                if (close > paren) header = s.substring(paren + 1, close).trim();
//            }
//
//            if (col != null && header != null && !header.isEmpty()) return col + ": " + header;
//            if (col != null) return col;
//            return rhsExpression;
//        } catch (Exception e) {
//            return rhsExpression;
//        }
//    }
//
//    /** For downloaded header, show only the column letter (e.g., "I"). */
//    private static String prettyDownloadedHeader(String lhsColumnLetter) {
//        return (lhsColumnLetter == null) ? "" : lhsColumnLetter.trim();
//    }
//}
//
//
















































//package utils;
//
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
//
//import java.util.List;
//
///**
// * 📊 HTMLCalculationReport
// *
// * - Single global flag: ENABLE_HTML_REPORT_TABLE (turn ON/OFF in one place)
// * - Row-by-row: first 5 rows only
// * - Totals-only: shows only the totals line
// * - LHS me column letter + (index) + header name show hota hai
// * - RHS me expression string (e.g., "MonthlyEmployeeSalary.H - PT Report.K")
// */
//public class HTMLCalculationReport {
//
//    // Turn on/off once here; calling time pe kuch pass karne ki zarurat nahi
//    public static boolean ENABLE_HTML_REPORT_TABLE_Calculation = true;
//
//    // ---------- Public API ----------
//
//    /** Row-by-row report (first 5 rows) */
//    public static void logRowByRowTable(
//            ExtentTest test,
//            String title,
//            String lhsSheetName,
//            String lhsColumnLetter,
//            String lhsHeaderName,
//            String rhsExpression,
//            List<Double> lhsValues,
//            List<Double> rhsValues
//    ) {
//        if (!ENABLE_HTML_REPORT_TABLE_Calculation || test == null) return;
//
//        String lhsColIndexStr = "(" + colLetterToIndexSafe(lhsColumnLetter) + ")";
//        String lhsHeader = safe(lhsColumnLetter) + " " + lhsColIndexStr + ": " + safe(lhsHeaderName);
//
//        StringBuilder sb = new StringBuilder();
//
//        // Title
//        sb.append("<div style='margin:6px 0 10px; font-weight:700; font-family:Arial, sans-serif;'>")
//          .append(safe(title))
//          .append("</div>");
//
//        // Meta line
//        sb.append("<div style='margin:0 0 10px; font-size:12px; font-family:Arial, sans-serif; color:#374151; white-space:nowrap;'>")
//          .append("<b>LHS:</b> ")
//          .append(safe(lhsSheetName)).append(".").append(safe(lhsColumnLetter))
//          .append(" &nbsp; <span style='color:#6b7280;'>").append(lhsHeader).append("</span>")
//          .append("<br><b>RHS:</b> ").append(safe(rhsExpression))
//          .append("</div>");
//
//        // Table (clean UI)
//        sb.append("<table style='border-collapse:collapse; width:100%; font-family:Arial, sans-serif; font-size:13px;'>");
//
//        // Header row
//        sb.append("<thead><tr>")
//          .append("<th style='background:#f7f7f9; border:1px solid #e5e7eb; padding:8px 10px; text-align:center; text-transform:uppercase; letter-spacing:.4px; min-width:70px; white-space:nowrap;'>Row No.</th>")
//          
//          .append("<th style='background:#f7f7f9; border:1px solid #e5e7eb; padding:8px 10px; text-align:center; text-transform:uppercase; letter-spacing:.4px; min-width:200px; white-space:nowrap;'>MASTER VALUE<br><small>")
//     //     .append(lhsHeader)    ---//
//          .append(prettyRhsHeader(rhsExpression))
//          .append("</small></th>")
//          .append("<th style='background:#f7f7f9; border:1px solid #e5e7eb; padding:8px 10px; text-align:center; text-transform:uppercase; letter-spacing:.4px; min-width:200px; white-space:nowrap;'>DOWNLOADED VALUE<br><small>")
//     //   .append(safe(rhsExpression)) ---//
//          .append(prettyDownloadedHeader(lhsColumnLetter))
//          .append("</small></th>")
//          
//          
//          .append("<th style='background:#f7f7f9; border:1px solid #e5e7eb; padding:8px 10px; text-align:center; text-transform:uppercase; letter-spacing:.4px; min-width:110px; white-space:nowrap;'>Result</th>")
//          .append("</tr></thead>");
//
//        sb.append("<tbody>");
//
//        int limit = Math.min(Math.min(safeSize(lhsValues), safeSize(rhsValues)), 5);
//        for (int i = 0; i < limit; i++) {
//            Double lv = lhsValues.get(i);
//            Double rv = rhsValues.get(i);
//            boolean ok = bothNotNull(lv, rv) && Math.abs(lv - rv) < 0.01;
//
//            sb.append("<tr>")
//              .append("<td style='border:1px solid #e5e7eb; padding:8px 10px; text-align:center;'>").append(i + 1).append("</td>")
////              .append("<td style='border:1px solid #e5e7eb; padding:8px 10px; text-align:center; white-space:nowrap;'>").append(fmt(lv)).append("</td>")
////              .append("<td style='border:1px solid #e5e7eb; padding:8px 10px; text-align:center; white-space:nowrap;'>").append(fmt(rv)).append("</td>")
//              
//              .append("<td style='border:1px solid #e5e7eb; padding:8px 10px; text-align:center; white-space:nowrap;'>").append(fmt(rv)).append("</td>")
//              .append("<td style='border:1px solid #e5e7eb; padding:8px 10px; text-align:center; white-space:nowrap;'>").append(fmt(lv)).append("</td>")
//              
//              
//              .append("<td style='border:1px solid #e5e7eb; padding:8px 10px; text-align:center;'>")
//              .append(ok
//                ? "<span style='display:inline-block; padding:2px 10px; border-radius:999px; background:#ecfdf5; color:#065f46; font-weight:700;'>PASS</span>"
//                : "<span style='display:inline-block; padding:2px 10px; border-radius:999px; background:#fef2f2; color:#991b1b; font-weight:700;'>FAIL</span>")
//              .append("</td>")
//              .append("</tr>");
//        }
//
//        sb.append("</tbody></table>");
//
//        test.log(LogStatus.INFO, sb.toString(), "");
//    }
//
//
//    /** Totals-only report */
//    public static void logTotalsTable(
//            ExtentTest test,
//            String title,
//            String lhsSheetName,
//            String lhsColumnLetter,
//            String lhsHeaderName,
//            String rhsExpression,
//            Double lhsTotal,
//            Double rhsTotal
//    ) {
//        if (!ENABLE_HTML_REPORT_TABLE_Calculation || test == null) return;
//
//        String lhsColIndexStr = "(" + colLetterToIndexSafe(lhsColumnLetter) + ")";
//        String lhsHeader = safe(lhsColumnLetter) + " " + lhsColIndexStr + ": " + safe(lhsHeaderName);
//        boolean ok = bothNotNull(lhsTotal, rhsTotal) && Math.abs(lhsTotal - rhsTotal) < 0.01;
//
//        StringBuilder sb = new StringBuilder();
//
//        // Title
//        sb.append("<div style='margin:6px 0 10px; font-weight:700; font-family:Arial, sans-serif;'>")
//          .append(safe(title))
//          .append("</div>");
//
//        // Meta
//        sb.append("<div style='margin:0 0 10px; font-size:12px; font-family:Arial, sans-serif; color:#374151; white-space:nowrap;'>")
//          .append("<b>LHS:</b> ").append(safe(lhsSheetName)).append(".").append(safe(lhsColumnLetter))
//          .append(" &nbsp; <span style='color:#6b7280;'>").append(lhsHeader).append("</span>")
//          .append("<br><b>RHS:</b> ").append(safe(rhsExpression))
//          .append("</div>");
//
//        // Table
//        sb.append("<table style='border-collapse:collapse; width:100%; font-family:Arial, sans-serif; font-size:13px;'>")
//          .append("<thead><tr>")
//          .append("<th style='background:#f7f7f9; border:1px solid #e5e7eb; padding:8px 10px; text-align:center; text-transform:uppercase; letter-spacing:.4px; min-width:200px; white-space:nowrap;'>MASTER VALUE<br><small>")
//          .append(lhsHeader).append("</small></th>")
//          .append("<th style='background:#f7f7f9; border:1px solid #e5e7eb; padding:8px 10px; text-align:center; text-transform:uppercase; letter-spacing:.4px; min-width:200px; white-space:nowrap;'>DOWNLOADED VALUE<br><small>")
//          .append(safe(rhsExpression)).append("</small></th>")
//          
//          
//          
//          .append("<th style='background:#f7f7f9; border:1px solid #e5e7eb; padding:8px 10px; text-align:center; text-transform:uppercase; letter-spacing:.4px; min-width:120px; white-space:nowrap;'>Result</th>")
//          .append("</tr></thead><tbody>");
//
//        sb.append("<tr>")
//          .append("<td style='border:1px solid #e5e7eb; padding:10px; text-align:center; white-space:nowrap;'>").append(fmt(lhsTotal)).append("</td>")
//          .append("<td style='border:1px solid #e5e7eb; padding:10px; text-align:center; white-space:nowrap;'>").append(fmt(rhsTotal)).append("</td>")
//          .append("<td style='border:1px solid #e5e7eb; padding:10px; text-align:center;'>")
//          .append(ok
//            ? "<span style='display:inline-block; padding:2px 12px; border-radius:999px; background:#ecfdf5; color:#065f46; font-weight:700;'>PASS</span>"
//            : "<span style='display:inline-block; padding:2px 12px; border-radius:999px; background:#fef2f2; color:#991b1b; font-weight:700;'>FAIL</span>")
//          .append("</td>")
//          .append("</tr>");
//
//        sb.append("</tbody></table>");
//
//        test.log(LogStatus.INFO, sb.toString(), "");
//    }
//
//
//    // ---------- Helpers ----------
//
//    private static String safe(String s) {
//        return (s == null) ? "" : s;
//    }
//
//    private static int safeSize(List<?> list) {
//        return (list == null) ? 0 : list.size();
//    }
//
//    private static boolean bothNotNull(Double a, Double b) {
//        return a != null && b != null;
//    }
//
//    private static String fmt(Double d) {
//        if (d == null) return "";
//        // strip .0 if integer-ish
//        if (Math.abs(d - Math.rint(d)) < 1e-9) return String.valueOf(d.longValue());
//        return String.valueOf(d);
//    }
//
//    /** Convert Excel column letter (e.g., "A", "L", "AA") to 0-based index for display */
//    private static int colLetterToIndexSafe(String col) {
//        if (col == null || col.isEmpty()) return -1;
//        int res = 0;
//        for (int i = 0; i < col.length(); i++) {
//            char c = Character.toUpperCase(col.charAt(i));
//            if (c < 'A' || c > 'Z') return -1;
//            res = res * 26 + (c - 'A' + 1);
//        }
//        return res - 1; // zero-based
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//   //     return res - 1; // zero-based
//    }
//
//    /** Make RHS expression concise for header: e.g., "MonthlyEmployeeSalary.Q (PT Gross)" -> "Q: PT Gross" */
//    private static String prettyRhsHeader(String rhsExpression) {
//        if (rhsExpression == null) return "";
//        // Try to capture ".<LETTER(S)> (HeaderText)"
//        // Examples it can handle inside the expression string:
//        //   "MonthlyEmployeeSalary.Q (PT Gross)"
//        //   "PT Report.K (Something)"
//        try {
//            String s = rhsExpression.trim();
//            // pick the first ".X (Y)" pattern if present
//            int dot = s.indexOf('.');
//            int paren = s.indexOf('(', dot + 1);
//            int spaceAfter = s.indexOf(' ', dot + 1);
//            // find column letters after the dot
//            String col = null;
//            for (int i = dot + 1; i < s.length(); i++) {
//                char c = s.charAt(i);
//                if (c >= 'A' && c <= 'Z') {
//                    int j = i;
//                    while (j < s.length() && s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') j++;
//                    col = s.substring(i, j);
//                    break;
//                }
//            }
//            String header = null;
//            if (paren >= 0) {
//                int close = s.indexOf(')', paren + 1);
//                if (close > paren) header = s.substring(paren + 1, close).trim();
//            }
//            if (col != null && header != null && !header.isEmpty()) {
//                return col + ": " + header;
//            }
//            if (col != null) return col;           // fallback to just column letters
//            return rhsExpression;                   // final fallback: original
//        } catch (Exception e) {
//            return rhsExpression;
//        }
//    }
//
//    /** For downloaded header, show only the column letter (e.g., "I"). */
//    private static String prettyDownloadedHeader(String lhsColumnLetter) {
//        return (lhsColumnLetter == null) ? "" : lhsColumnLetter.trim();
//    }
//   
//        
//    }
//    
    

    
    

