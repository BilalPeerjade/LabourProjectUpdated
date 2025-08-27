package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

public class HTMLBuilder {

    /**
     * ✅ Generates a detailed HTML table comparing master vs downloaded values.
     * Includes headers, column letters, and PASS/FAIL for first 5 values.
     */
    public static String createDetailedComparisonTable(
            Set<String> masterValues,
            Set<String> downloadedValues,
            String masterFilePath,
            String masterSheet,
            int masterColIndex,
            int downloadedColIndex,
            String downloadedHeaderKeyword
    ) {
        StringBuilder htmlTable = new StringBuilder();

        // 🔰 Header Info for Master & Downloaded Columns
        String masterColLetter = getExcelColumnLetter(masterColIndex);
        String masterHeader = getHeaderValue(masterFilePath, masterSheet, masterColIndex);

        String downloadedColLetter = getExcelColumnLetter(downloadedColIndex);
        String downloadedHeader = downloadedHeaderKeyword != null ? downloadedHeaderKeyword : "";

        String masterColumnHeader = masterColLetter + ": " + masterHeader;
        String downloadedColumnHeader = downloadedColLetter + ": " + downloadedHeader;

        htmlTable.append("<br><b>📊 Sample Comparison Table:</b><br>")
            .append("<table border='1' cellpadding='4' style='border-collapse:collapse; text-align:center; font-family:Arial, sans-serif;'>")
            .append("<tr style='background-color:#f2f2f2;'>")
            .append("<th style='width:60px;'>Row No.<br><small>&nbsp;</small></th>")
            .append("<th>Master Value<br><small>").append(masterColumnHeader).append("</small></th>")
            .append("<th>Downloaded Value<br><small>").append(downloadedColumnHeader).append("</small></th>")
            .append("<th>Result<br><small>&nbsp;</small></th>")
            .append("</tr>");

        int rowNum = 1;
        for (String masterValue : masterValues) {
            if (rowNum > 5) break; // ✅ Show only first 5 rows
            String matchResult = downloadedValues.contains(masterValue)
                    ? "<span style='color:green;font-weight:bold;'>PASS</span>"
                    : "<span style='color:red;font-weight:bold;'>FAIL</span>";
            String downloadedMatch = downloadedValues.contains(masterValue) ? masterValue : "❌ Not Found";

            htmlTable.append("<tr>")
                .append("<td>").append(rowNum).append("</td>")
                .append("<td>").append(masterValue).append("</td>")
                .append("<td>").append(downloadedMatch).append("</td>")
                .append("<td>").append(matchResult).append("</td>")
                .append("</tr>");

            rowNum++;
        }

        htmlTable.append("</table>");
        return htmlTable.toString();
    }

    // 📌 Helper to convert column index to Excel-style column letter (e.g., 3 => D)
    private static String getExcelColumnLetter(int colNum) {
        StringBuilder sb = new StringBuilder();
        while (colNum >= 0) {
            sb.insert(0, (char) ('A' + (colNum % 26)));
            colNum = (colNum / 26) - 1;
        }
        return sb.toString();
    }

    // 📌 Helper to get header text from Excel
    private static String getHeaderValue(String filePath, String sheetName, int colIndex) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);
            if (sheet != null) {
                Row headerRow = sheet.getRow(0); // assumes header is on row 0
                if (headerRow != null) {
                    Cell cell = headerRow.getCell(colIndex);
                    return cell != null ? cell.toString().trim() : "";
                }
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }
}
