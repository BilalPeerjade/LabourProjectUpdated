package businessTestCases;



import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
//Export Imports
//Selenium imports
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Apache POI for Excel handling
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//ExtentReports logging
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import distributor.Locators;
import login.LoginLocators;
import performer.PerformerLocator;

//Java standard libraries
import java.io.FileInputStream;
import java.time.Duration;
import java.time.Instant;
//Disabled Fields:
import java.util.Objects;
import java.util.Set;









public class CommonBusinessUtilis {
	
	
	
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	//Method 1 and 2 are common for both
	
	//1
	public static File getLatestDownloadedExcelFile() {
	    File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
	    File[] files = downloadDir.listFiles((dir, name) -> name.endsWith(".xlsx") || name.endsWith(".xls"));

	    if (files == null || files.length == 0) return null;

	    Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
	    return files[0];  // Most recent
	}
	
	
	
	//2
	
	public static File downloadExcelAndReturnFile(WebDriver driver, By downloadLocator, ExtentTest test) {
	    try {
	        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
	        File previousFile = getLatestDownloadedExcelFile();  // null or latest

	        // ✅ Step 1: Click on download button via JS
	        WebElement downloadButton = driver.findElement(downloadLocator);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadButton);
	        test.log(LogStatus.INFO, "📥 Clicked to download file using JavaScript.");

	        // ✅ Step 2: Wait for new file
	        File newFile = null;
	        long startTime = System.currentTimeMillis();

	        while ((System.currentTimeMillis() - startTime) < 15000) {
	            Thread.sleep(1000);

	            File[] allFiles = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
	            if (allFiles != null && allFiles.length > 0) {
	                Arrays.sort(allFiles, Comparator.comparingLong(File::lastModified).reversed());
	                File latest = allFiles[0];

	                if (previousFile == null || !latest.getName().equals(previousFile.getName()) || latest.lastModified() > previousFile.lastModified()) {
	                    newFile = latest;
	                    break;
	                }
	            }
	        }

	        // ✅ Step 3: Validate result
	        if (newFile != null && newFile.exists()) {
	            test.log(LogStatus.PASS, "✅ File downloaded: " + newFile.getName());
	            return newFile;
	        } else {
	            test.log(LogStatus.FAIL, "❌ File download failed or file not found within timeout.");
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.ERROR, "❌ Error during file download: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return null;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	//Method Utils 1:--------
	public static void validateExcelTotalByColumnIndex (WebDriver driver,ExtentTest test,File filePath,int columnIndex,int headerRowIndex,String sheetName,String logText) {
	   
		
		/** 22-07-2025
		 * ✅ Purpose:
		 * This method validates the total of a specific column in an Excel sheet up to the "Total" row,
		 * and compares it with the actual value in the same column in that "Total" row.
		 * It logs:
		 *   - The downloaded file name
		 *   - Calculated total from column data
		 *   - Actual total from "Total" row
		 *   - Pass/Fail result
		 *
		 * ✅ Steps Performed:
		 * 1. Check if Excel file exists.
		 * 2. Log the file name being used for data validation.
		 * 3. Open the given sheet from the Excel file.
		 * 4. Start reading from the row after the header (based on `headerRowIndex`).
		 * 5. For each row:
		 *    - Sum the numeric values in the specified column (`columnIndex`).
		 *    - Stop if "Total" is found in first column.
		 * 6. Fetch the actual value from the "Total" row.
		 * 7. Log expected vs actual totals.
		 * 8. Log PASS if matched, FAIL if mismatch or "Total" row missing.
		 *
		 * ✅ Parameters:
		 * @param driver          WebDriver instance
		 * @param test            ExtentTest instance for logging
		 * @param filePath        Excel file to validate
		 * @param columnIndex     Index of column to sum (0-based)
		 * @param headerRowIndex  Row index where header starts (0-based)
		 * @param sheetName       Name of sheet in Excel to work on
		 * @param logText         Custom message to show in report logs
		 *
		 *
		 *
		 *
		 * ------------
		 * Calling:-
		 * 
		 *   //First Time calling: 
		 *   
		 *   WebDriver driver = CommonBusinessUtilis.getDriver();
		 *   
		 *   // Step 1: Manually download file
		 *   getDriver().findElement(By.xpath("(//img[@alt='Download Document'])[5]")).click();
		 *   Thread.sleep(8000); // wait for file to download
		 *   
		 *   // Step 2: Get latest file
		 *   File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
		 *   File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
		 *   Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
		 *   downloadedExcelFile = files[0];
		 *
		 *
		 *
		 * 
		 *    //Rest calling every time rest of the methods:
		 *    
		 *    WebDriver driver = CommonBusinessUtilis.getDriver();
		 *    ✅ Sample Call:
		 *    CommonBusinessUtilis.validateExcelTotalByColumnIndex(
		 *     driver,
		 *     test,
		 *     downloadedExcelFile,
		 *     5,          // column index
		 *     1,          // header at 2nd row (index 1)
		 *     "Pending",  // sheet name
		 *     "Basic Wages Validation"
		 * );
		 */

		try {
	        if (filePath == null || !filePath.exists()) {
	            test.log(LogStatus.FAIL, "❌ Excel file not found to validate.");
	            return;
	        }

	        // ✅ Log File Name
	        test.log(LogStatus.INFO, "📄 Data Fetch file name: " + filePath.getName());

	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet(sheetName);

	        if (sheet == null) {
	            test.log(LogStatus.FAIL, "❌ Sheet not found: " + sheetName);
	            workbook.close();
	            return;
	        }

	        double calculatedTotal = 0.0;
	        double fileTotal = -1;

	        for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);
	            if (row == null) continue;

	            Cell firstCell = row.getCell(0);
	            if (firstCell != null && firstCell.getCellType() == CellType.STRING
	                    && firstCell.getStringCellValue().trim().equalsIgnoreCase("Total")) {

	                Cell totalCell = row.getCell(columnIndex);
	                fileTotal = totalCell != null && totalCell.getCellType() == CellType.NUMERIC
	                        ? totalCell.getNumericCellValue() : 0;

	                break;
	            }

	            Cell dataCell = row.getCell(columnIndex);
	            if (dataCell != null && dataCell.getCellType() == CellType.NUMERIC) {
	                calculatedTotal += dataCell.getNumericCellValue();
	            }
	        }

	        workbook.close();

	        // ✅ Log Expected vs Actual
	        test.log(LogStatus.INFO, "📊 Expected count: " + calculatedTotal + "   ||   Actual count: " + fileTotal);

	        if (fileTotal == -1) {
	            test.log(LogStatus.FAIL, "❌ Total row not found in sheet: " + sheetName);
	            return;
	        }

	        if (Math.abs(calculatedTotal - fileTotal) < 0.01) {
	            test.log(LogStatus.PASS, "✅ " + logText + ": matched total: " + fileTotal);
	        } else {
	            test.log(LogStatus.FAIL, "❌ " + logText + ": mismatch. Expected: " + calculatedTotal + ", Found: " + fileTotal);
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.ERROR, "❌ Error during Excel total validation: " + e.getMessage());
	        e.printStackTrace();
	    }
	}








	//----------Unique values Identifier -------------//
	//Method Utils 2
	public static void validateColumnHasUniqueValues(WebDriver driver,ExtentTest test,File filePath,int columnIndex,int headerRowIndex,String sheetName,String logText) {
	    
		
		
		/**
		 * ✅ Validates that all values in a specific column of an Excel sheet are unique.
		 *
		 * 🔧 Purpose:
		 * This method helps to ensure that key identifiers like Employee ID, UAN Number, PF Number, etc.,
		 * are unique in the Excel report generated by the application.
		 *
		 * 📌 Steps Performed:
		 * ------------------------------------------------------------
		 * 1. Excel file is downloaded once and saved in memory (as File object)
		 * 2. Target sheet is opened from the Excel file
		 * 3. Data is read row-by-row starting after the header row
		 * 4. Loop stops when first column value is "Total"
		 * 5. Each value from the given columnIndex is stored in a Set
		 * 6. Duplicates are tracked and logged if found
		 * 7. Logs show total count, unique count, and duplicate values if any
		 * 8. Pass/Fail is logged to Extent Report
		 *
		 * ✅ Parameters:
		 * @param driver           WebDriver instance (optional - for consistency)
		 * @param test             ExtentTest instance for logging test results
		 * @param filePath         Excel File object (already downloaded & saved)
		 * @param columnIndex      Column index to validate (0-based)
		 * @param headerRowIndex   Index of header row (usually 1 for 2nd row)
		 * @param sheetName        Name of the sheet to validate (e.g., "Pending", "Remittances")
		 * @param logText          Friendly column name for logging (e.g., "UAN Number", "Employee ID")
		 *
		 *
		 *
		 *------------------------------------
		 * ✅ Example Calling (from test case):
		 *
		 *     WebDriver driver = CommonBusinessUtilis.getDriver();
		 *
		 *     // Manually download file (if download utility doesn't work)
		 *     getDriver().findElement(By.xpath("(//img[@alt='Download Document'])[5]")).click();
		 *     Thread.sleep(8000); // Wait for download
		 *
		 *     // Fetch latest downloaded file
		 *     File downloadDir = new File(System.getProperty("user.home") + "\\\\Downloads");
		 *     File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
		 *     Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
		 *     File downloadedExcelFile = files[0];
		 *
		 *    	
		 *    
		 *    
		 *    //We can call this method in every test case
		 *    
		 *     WebDriver driver = CommonBusinessUtilis.getDriver();
		 *     // ✅ Step 3: Call uniqueness method
		        CommonBusinessUtilis.validateColumnHasUniqueValues(
			    driver,
			    test,
			    downloadedExcelFile,
			    5,                 // Column Index for Employee Number (e.g., column F)
			    1,                 // Header at row 2 (i.e., index 1)
			    "Pending",         // Sheet name
			    "Employee Ids uniqnes" );     // Log/Report label — It will display this log if pass
			    
		 *    
		 *    
		 *    
		 *    
		 *
		 * 📌 Note:
		 * - `logText` is only used for reporting, not data fetching.
		 * - `columnIndex` must be accurate (0-based, count from first column).
		 */

		
		try {
	        if (filePath == null || !filePath.exists()) {
	            test.log(LogStatus.FAIL, "❌ Excel file not found for uniqueness validation.");
	            return;
	        }

	        // ✅ Step 1: Log file name
	        test.log(LogStatus.INFO, "📄 Data Fetch file name: " + filePath.getName());

	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet(sheetName);

	        if (sheet == null) {
	            test.log(LogStatus.FAIL, "❌ Sheet not found: " + sheetName);
	            workbook.close();
	            return;
	        }

	        Set<String> uniqueValues = new HashSet<>();
	        List<String> duplicates = new ArrayList<>();
	        int rowCount = 0;

	        for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);
	            if (row == null) continue;

	            // Stop if first column has "Total"
	            Cell firstCell = row.getCell(0);
	            if (firstCell != null && firstCell.getCellType() == CellType.STRING &&
	                    firstCell.getStringCellValue().trim().equalsIgnoreCase("Total")) {
	                break;
	            }

	            Cell dataCell = row.getCell(columnIndex);
	            String value = "";

	            if (dataCell != null) {
	                switch (dataCell.getCellType()) {
	                    case STRING:
	                        value = dataCell.getStringCellValue().trim();
	                        break;
	                    case NUMERIC:
	                        value = String.valueOf((long) dataCell.getNumericCellValue());
	                        break;
	                    case BOOLEAN:
	                        value = String.valueOf(dataCell.getBooleanCellValue());
	                        break;
	                    default:
	                        value = dataCell.toString().trim();
	                }

	                if (!value.isEmpty()) {
	                    if (!uniqueValues.add(value)) {
	                        duplicates.add(value);
	                    }
	                    rowCount++;
	                }
	            }
	        }

	        workbook.close();

	        // ✅ Step 2: Log result
	        test.log(LogStatus.INFO, "🔎 " + logText + " → Total values: " + rowCount + " || Unique values: " + uniqueValues.size());

	        if (duplicates.isEmpty()) {
	            test.log(LogStatus.PASS, "✅ " + logText + " values are unique.");
	        } else {
	            test.log(LogStatus.FAIL, "❌ " + logText + " has duplicates: " + String.join(", ", duplicates));
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.ERROR, "❌ Error in uniqueness validation: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	
	
	
	
	//Method 3: change name: validateDynamicEPFAndHeaderValue
	//This method is for specially PF Working File
/*	public static void validateTotalCellValueWithTotalSummary(WebDriver driver,ExtentTest test,File filePath,String sheetName,int totalColumnIndex,int headerRowIndex,String totalKeyword,int dynamicHeaderColumnIndex,String headerName,int rowsAfterHeader) {
		    
		
		try {
		        if (filePath == null || !filePath.exists()) {
		            test.log(LogStatus.FAIL, "❌ Excel file not found for validation.");
		            return;
		        }

		        test.log(LogStatus.INFO, "📄 Data Fetch file name: " + filePath.getName());
		        FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheet(sheetName);

		        if (sheet == null) {
		            test.log(LogStatus.FAIL, "❌ Sheet not found: " + sheetName);
		            workbook.close();
		            return;
		        }

		        // Step 1: Get EPF Wages Total from column till 'Total' row
		        double epfTotal = 0.0;
		        double fileTotal = -1;
		    //  for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) 
		        for (int i = 0; i <= sheet.getLastRowNum(); i++)
		        
		        {
		            Row row = sheet.getRow(i);
		            if (row == null) continue;

		            Cell firstCell = row.getCell(0);
		            if (firstCell != null && firstCell.getCellType() == CellType.STRING &&
		                firstCell.getStringCellValue().trim().equalsIgnoreCase(totalKeyword)) {

		                Cell totalCell = row.getCell(totalColumnIndex);
//		                fileTotal = (totalCell != null && totalCell.getCellType() == CellType.NUMERIC)
//		                    ? totalCell.getNumericCellValue() : 0;
		                
		                if (totalCell != null && totalCell.getCellType() == CellType.NUMERIC) {
		                    fileTotal = totalCell.getNumericCellValue();
		                } else {
		                    fileTotal = 0; // ✅ even if empty or non-numeric
		                }
		                
		                
		                
		                break;
		            }

		            Cell dataCell = row.getCell(totalColumnIndex);
		            if (dataCell != null && dataCell.getCellType() == CellType.NUMERIC) {
		                epfTotal += dataCell.getNumericCellValue();
		            }
		        }

		        // Step 2: Find header in given column, and fetch cell 'N' rows below
		        double belowValue = -1;
		        boolean headerFound = false;

		   //   for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) 
		        for (int i = 0; i <= sheet.getLastRowNum(); i++)
		        
		        {
		            Row row = sheet.getRow(i);
		            if (row == null) continue;

		            Cell headerCell = row.getCell(dynamicHeaderColumnIndex);
		            if (headerCell != null && headerCell.getCellType() == CellType.STRING &&
		          //    headerCell.getStringCellValue().trim().equalsIgnoreCase(headerName)
		            	headerCell.getStringCellValue().toLowerCase().contains(headerName.toLowerCase())) 
		            
		            {

		                Row targetRow = sheet.getRow(i + rowsAfterHeader);
		                if (targetRow != null) {
		                    Cell targetCell = targetRow.getCell(dynamicHeaderColumnIndex);
		                    if (targetCell != null && targetCell.getCellType() == CellType.NUMERIC) {
		                        belowValue = targetCell.getNumericCellValue();
		                        headerFound = true;
		                        break;
		                    }
		                }
		            }
		        }

		        workbook.close();

		        // 🔍 Logs
		        test.log(LogStatus.INFO, "📊 EPF Total: " + fileTotal);
		        test.log(LogStatus.INFO, "📉 " + headerName + " +" + rowsAfterHeader + " Row Value: " + belowValue);

		        if (!headerFound) {
		            test.log(LogStatus.FAIL, "❌ Header '" + headerName + "' not found in column index " + dynamicHeaderColumnIndex);
		            return;
		        }

		  //    if (fileTotal == -1) {
		  //          test.log(LogStatus.FAIL, "❌ 'Total' row not found in column A.");
		  //          return;
		  //     } 
		        if (fileTotal == -1) {
		            test.log(LogStatus.INFO, "ℹ️ 'Total' row found but value cell was empty or non-numeric. Assuming 0.");
		            fileTotal = 0;
		        }


		        if ((fileTotal == 0 && belowValue == 0) || Math.abs(fileTotal - belowValue) < 0.01) {
		            test.log(LogStatus.PASS, "✅ Matched: EPF = " + fileTotal + " & " + headerName + " = " + belowValue);
		        } else {
		            test.log(LogStatus.FAIL, "❌ Mismatch: EPF = " + fileTotal + ", " + headerName + " = " + belowValue);
		        }

		    } catch (Exception e) {
		        test.log(LogStatus.ERROR, "❌ Error: " + e.getMessage());
		        e.printStackTrace();
		    }
		}

	*/
	
	
	
	
	
	
	//Method Utils 3
	
	//Method 3: change name: validateDynamicEPFAndHeaderValue
	//This method is for specially PF Working File
	public static void validateTotalCellValueWithTotalSummary(WebDriver driver,ExtentTest test,File filePath,String sheetName,int totalColumnIndex,int headerRowIndex,String totalKeyword,int dynamicHeaderColumnIndex,String headerName,int rowsAfterHeader) {    
		
	    /**
	     * ✅ Validates that the "EPF Total" in one column matches the value found below a dynamic header like "Basic".
	     *
	     * 🔧 Purpose:
	     * This method is used to ensure values such as EPF wages match a specific total fetched dynamically 
	     * from below a given header in another column.
	     * Useful in validating totals from sheets like "Pending", "Remittances", "All Employees", etc.
	     *
	     * 📌 Steps Performed:
	     * ------------------------------------------------------------
	     * 1. Opens the provided Excel file and accesses the given sheet.
	     * 2. Searches for the row where the first column (A) has the value "Total".
	     * 3. Captures the cell in that row at the provided totalColumnIndex (e.g., column S = 19).
	     * 4. Searches column 'dynamicHeaderColumnIndex' (e.g., column H = 7) for a header text matching 'headerName' (case-insensitive, partial match allowed).
	     * 5. Once found, it fetches the value from the cell 'rowsAfterHeader' rows below that header.
	     * 6. Logs both values via ExtentTest — and marks PASS if:
	     *      - Both values are 0
	     *      - OR their difference is within a 0.01 margin.
	     * 7. Handles empty or missing cells by treating them as 0.
	     *
	     * 📥 Parameters:
	     * @param driver                      WebDriver instance
	     * @param test                        ExtentTest instance for reporting
	     * @param filePath                    File object of the Excel (already downloaded manually)
	     * @param sheetName                   Sheet to validate (e.g., "Pending", "Remittances")
	     * @param totalColumnIndex            Index of the column where EPF total is (0-based, e.g., 19 for column S)
	     * @param headerRowIndex              Index of the header row (0-based, e.g., 1 for row 2 in Excel)
	     * @param totalKeyword                Keyword to locate the total row (e.g., "Total" in column A)
	     * @param dynamicHeaderColumnIndex    Index of the column to search for dynamic header (e.g., 7 for column H)
	     * @param headerName                  Header name to match (case-insensitive, partial match allowed e.g., "Basic")
	     * @param rowsAfterHeader             How many rows after header to fetch value (usually 1 or 2)
	     *
	     * ✅ Example Calling (from test case):
	     * ------------------------------------------------------------
	     *     File downloadedExcelFile = getLatestDownloadedExcelFile(); // Already downloaded manually
	     *     
	     *     CommonBusinessUtilis.validateTotalCellValueWithTotalSummary(
	     *         driver,
	     *         test,
	     *         downloadedExcelFile,
	     *         "Remittances",        // Sheet Name
	     *         19,                   // Column S (EPF Wages)
	     *         1,                    // Header at row 2
	     *         "Total",              // Total row identifier
	     *         7,                    // Column H (for "Basic")
	     *         "Basic",              // Header Text to look for
	     *         1                     // Fetch 1 row below
	     *     );
	     *
	     * 📌 Notes:
	     * - If "Total" row is found but its cell is empty → it's treated as 0.
	     * - If header is not found → failure is logged.
	     * - If value below header is missing → treated as -1 (and failure logged unless both are zero).
	     * - `headerName` can be partial (e.g., "Basic" will match "Basic (Wages)")
	     *
	     */
		
		/**
		Calling this method like this: 
		    WebDriver driver = CommonBusinessUtilis.getDriver();
		    File downloadedExcelFile = getLatestDownloadedExcelFile(); // Already downloaded manually
			CommonBusinessUtilis.validateTotalCellValueWithTotalSummary(
				    driver,
				    test,
				    downloadedExcelFile,     // File already downloaded manually, pass here
				    "Remittances",           // Sheet name where data exists
				    19,                      // totalColumnIndex → Column 'T' → EPF Wages
				    1,                       // headerRowIndex → Excel row 2 (0-based index = 1)
				    "Total",                 // totalKeyword → will check column A for 'Total'
				    7,                       // dynamicHeaderColumnIndex → Column H
				    "Basic",                 // headerName → Will match if contains 'Basic'
				    1                        // rowsAfterHeader → Fetch value 1 row below header
				);
		*/


		try {
		        if (filePath == null || !filePath.exists()) {
		            test.log(LogStatus.FAIL, "❌ Excel file not found for validation.");
		            return;
		        }

		        test.log(LogStatus.INFO, "📄 Data Fetch file name: " + filePath.getName());

		        FileInputStream fis = new FileInputStream(filePath);
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheet(sheetName);

		        if (sheet == null) {
		            test.log(LogStatus.FAIL, "❌ Sheet not found: " + sheetName);
		            workbook.close();
		            return;
		        }

		        // Step 1: Get EPF Total value from column till "Total" row
		        double epfTotal = 0.0;
		        double fileTotal = -1;

		        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
		            Row row = sheet.getRow(i);
		            if (row == null) continue;

		            Cell firstCell = row.getCell(0);
		            if (firstCell != null && firstCell.getCellType() == CellType.STRING &&
		                firstCell.getStringCellValue().trim().equalsIgnoreCase(totalKeyword)) {

		                Cell totalCell = row.getCell(totalColumnIndex);
		                if (totalCell != null && totalCell.getCellType() == CellType.NUMERIC) {
		                    fileTotal = totalCell.getNumericCellValue();
		                } else {
		                    fileTotal = 0; // Treat empty/missing as 0
		                }
		                break;
		            }

		            Cell dataCell = row.getCell(totalColumnIndex);
		            if (dataCell != null && dataCell.getCellType() == CellType.NUMERIC) {
		                epfTotal += dataCell.getNumericCellValue();
		            }
		        }

		        // Step 2: Find "headerName" in column and get N rows below
		        double belowValue = -1;
		        boolean headerFound = false;

		        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
		            Row row = sheet.getRow(i);
		            if (row == null) continue;

		            Cell headerCell = row.getCell(dynamicHeaderColumnIndex);
		            if (headerCell != null) {
		                try {
		                    String headerVal = headerCell.toString().trim().toLowerCase();
		                    if (headerVal.contains(headerName.toLowerCase())) {
		                        Row targetRow = sheet.getRow(i + rowsAfterHeader);
		                        if (targetRow != null) {
		                            Cell targetCell = targetRow.getCell(dynamicHeaderColumnIndex);
		                            if (targetCell != null && targetCell.getCellType() == CellType.NUMERIC) {
		                                belowValue = targetCell.getNumericCellValue();
		                            } else {
		                                belowValue = 0; // If value missing, treat as 0
		                            }
		                            headerFound = true;
		                            break;
		                        }
		                    }
		                } catch (Exception e) {
		                    // Ignore and continue
		                }
		            }
		        }

		        workbook.close();

		        // 🔍 Logs
		        test.log(LogStatus.INFO, "📊 EPF Total: " + fileTotal);
		        test.log(LogStatus.INFO, "📉 " + headerName + " +" + rowsAfterHeader + " Row Value: " + belowValue);

		        if (!headerFound) {
		            test.log(LogStatus.FAIL, "❌ Header '" + headerName + "' not found in column index " + dynamicHeaderColumnIndex);
		            return;
		        }

		        if (fileTotal == -1) {
		            test.log(LogStatus.INFO, "ℹ️ 'Total' row found but value cell was empty or non-numeric. Assuming 0.");
		            fileTotal = 0;
		        }

		        if ((fileTotal == 0 && belowValue == 0) || Math.abs(fileTotal - belowValue) < 0.01) {
		            test.log(LogStatus.PASS, "✅ Matched: EPF = " + fileTotal + " & " + headerName + " = " + belowValue);
		        } else {
		            test.log(LogStatus.FAIL, "❌ Mismatch: EPF = " + fileTotal + ", " + headerName + " = " + belowValue);
		        }

		    } catch (Exception e) {
		        test.log(LogStatus.ERROR, "❌ Error: " + e.getMessage());
		        e.printStackTrace();
		    }
		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Method 4:
	

	//This code is working but need to modify from gpt taken from perplexity 
	public static void validateColumnWithCalculation_Enhanced(
		    ExtentTest test,
		    File excelFile,
		    String sheetName,
		    int baseColIndex,
		    int calcColIndex,
		    String operation,
		    double operand,
		    int headerRowIndex,
		    String logText,
		    double allowedTolerance
		) {
		    try (FileInputStream fis = new FileInputStream(excelFile)) {
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheet(sheetName);
		        if (sheet == null) {
		            test.log(LogStatus.FAIL, "❌ Sheet not found: " + sheetName);
		            return;
		        }
		        // Safe column headers
		        Row headerRow = sheet.getRow(headerRowIndex);
		        String baseHeader = "[Blank]";
		        String calcHeader = "[Blank]";
		        String baseColLetter = getExcelColumnLetter(baseColIndex);
		        String calcColLetter = getExcelColumnLetter(calcColIndex);
		        if (headerRow != null) {
		            Cell baseHeaderCell = headerRow.getCell(baseColIndex);
		            if (baseHeaderCell != null) baseHeader = baseHeaderCell.toString();
		            Cell calcHeaderCell = headerRow.getCell(calcColIndex);
		            if (calcHeaderCell != null) calcHeader = calcHeaderCell.toString();
		        }
		        // File info
		        String fileName = excelFile.getName();
		        String runTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
		        test.log(LogStatus.INFO, "📄 Data Fetch file name: <b>" + fileName + "</b>");
		        test.log(LogStatus.INFO, "📆 Report Generated: <b>" + runTime + "</b>");
		        test.log(LogStatus.INFO, "<b>" + logText + "</b>");
		        // Pick all valid (non-null, with data) rows after header
		        List<Integer> allRowIndices = new ArrayList<>();
		        int lastRowIndex = sheet.getLastRowNum();
		        // Only consider rows with at least one non-blank cell (so blanks/whitespace rows are skipped)
		        for (int i = headerRowIndex+1; i <= lastRowIndex; i++) {
		            Row row = sheet.getRow(i);
		            if (row == null) continue;
		            boolean hasData = false;
		            for (int j = 0; j < Math.max(baseColIndex, calcColIndex)+1; j++) {
		                Cell cc = row.getCell(j);
		                if (cc != null && cc.getCellType() != CellType.BLANK && !"".equals(cc.toString().trim())) {
		                    hasData = true;
		                    break;
		                }
		            }
		            if (hasData) allRowIndices.add(i);
		        }
		        // First 4 non-header data rows
		        List<Integer> rowsToReport = new ArrayList<>();
		        for (int i = 0; i < allRowIndices.size() && i < 4; i++) rowsToReport.add(allRowIndices.get(i));
		        
		        
		        
		        // Add second last and last actual row (if more than 4 exist)
	//	        if (allRowIndices.size() > 5)
	//	            rowsToReport.add(allRowIndices.get(allRowIndices.size()-2));
	//	        if (allRowIndices.size() > 4)
	//	            rowsToReport.add(allRowIndices.get(allRowIndices.size()-1)); // Last row (likely contains "Total")
		        
		        
		     // Add 2nd last and "Total" row (where Sl No == "Total"), if present
	//	        if (allRowIndices.size() > 5)
	//	            rowsToReport.add(allRowIndices.get(allRowIndices.size()-2));
		        

		        // Find actual "Total" row in block
	//	        Integer totalRowIdx = null;
	//	        for (Integer idx : allRowIndices) {
	//	            Row row = sheet.getRow(idx);
	//	            if (row != null) {
	//	                Cell slNoCell = row.getCell(0);
	//	                if (slNoCell != null && slNoCell.getCellType() == CellType.STRING
	//	                    && slNoCell.getStringCellValue().trim().equalsIgnoreCase("Total")) {
	//	                    totalRowIdx = idx;
	//	                    break;
	//	                }
	//	            }
	//	        }
		        
		        
		     // Pick first 5 valid data rows (after header)
		        for (int i = 0; i < allRowIndices.size() && i < 5; i++)
		            rowsToReport.add(allRowIndices.get(i));

		        // Find the actual 'Total' row (where first column is "Total", case-insensitive)
		        Integer totalRowIdx = null;
		        for (Integer idx : allRowIndices) {
		            Row row = sheet.getRow(idx);
		            if (row != null) {
		                Cell slNoCell = row.getCell(0);
		                if (slNoCell != null && slNoCell.getCellType() == CellType.STRING
		                    && slNoCell.getStringCellValue().trim().equalsIgnoreCase("Total")) {
		                    totalRowIdx = idx;
		                    break;
		                }
		            }
		        }
		        if (totalRowIdx != null && !rowsToReport.contains(totalRowIdx)) {
		            rowsToReport.add(totalRowIdx);
		        }

		        
		        
		        
		        
		        
		        
		        
		        if (totalRowIdx != null) {
		            rowsToReport.add(totalRowIdx);
		        }
		        
		        
		        

		        
		        
		        
		        
		        
		        
		        // Prepare table
		        StringBuilder htmlTable = new StringBuilder();
		        htmlTable.append("<table border='1' cellpadding='4' style='border-collapse:collapse'><tr>")
		            .append("<th>Row No.</th>")
		            .append("<th>Employee Name</th>")
		            .append("<th>").append(baseColLetter).append(": ").append(baseHeader).append("</th>")
		            .append("<th>").append(calcColLetter).append(": ").append(calcHeader).append("</th>")
		            .append("<th>Expected</th><th>Diff</th><th>Result</th></tr>");
		        int passCount = 0, failCount = 0, totalCount = 0;
		        boolean reportHasFail = false;
		        for (Integer i: rowsToReport) {
		            Row row = sheet.getRow(i);
		            if (row == null) continue;
		            Cell nameCell = row.getCell(2); // If not available, show blank
		            String empName = (nameCell != null) ? nameCell.toString() : "";
		            // In summary/"Total" row, show "Total" or summary keyword in empName
		            Cell firstCell = row.getCell(0);
		            if (firstCell != null && firstCell.getCellType() == CellType.STRING &&
		                firstCell.getStringCellValue().trim().toLowerCase().contains("total"))
		                empName = firstCell.getStringCellValue();
		            double baseValue = getCellNumericValue(row.getCell(baseColIndex));
		            double calcValue = getCellNumericValue(row.getCell(calcColIndex));
		            double expected = 0;
		            switch (operation) {
		                case "%": expected = round2(baseValue * operand / 100); break;
		                case "*": expected = round2(baseValue * operand); break;
		                case "+": expected = round2(baseValue + operand); break;
		                case "-": expected = round2(baseValue - operand); break;
		                default: expected = 0;
		            }
		            double diff = round2(Math.abs(calcValue - expected));
		            totalCount++;
		            boolean pass = diff <= allowedTolerance;
		            if (pass) passCount++; else failCount++;
		            if (!pass) reportHasFail = true;
		            htmlTable.append("<tr><td>").append(i+1).append("</td>")
		                .append("<td>").append(empName).append("</td>")
		                .append("<td>").append(baseValue).append("</td>")
		                .append("<td>").append(calcValue).append("</td>")
		                .append("<td>").append(expected).append("</td>")
		                .append("<td>").append(diff).append("</td>")
		                .append("<td>")
		                .append(pass ? "<span style='color:green;font-weight:bold;'>PASS</span>"
		                             : "<span style='color:red;font-weight:bold;'>FAIL</span>")
		                .append("</td></tr>");
		        }
		        htmlTable.append("</table>");
		        if (reportHasFail)
		            test.log(LogStatus.FAIL, htmlTable.toString());
		        else
		            test.log(LogStatus.PASS, htmlTable.toString());
		        test.log(reportHasFail ? LogStatus.FAIL : LogStatus.PASS,
		            "<b>Summary:</b> Rows displayed: " + totalCount + " | Passed: " + passCount + " | Failed: " + failCount);
		    } catch (Exception e) {
		        test.log(LogStatus.ERROR, "❌ Exception in calculation: " + e.getMessage());
		        e.printStackTrace();
		    }
		}
		private static String getExcelColumnLetter(int colNum) {
		    StringBuilder sb = new StringBuilder();
		    while (colNum >= 0) {
		        sb.insert(0, (char) ('A' + (colNum % 26)));
		        colNum = (colNum / 26) - 1;
		    }
		    return sb.toString();
		}
		private static double getCellNumericValue(Cell c) {
		    if (c == null) return 0;
		    if (c.getCellType() == CellType.NUMERIC) return c.getNumericCellValue();
		    try { return Double.parseDouble(c.toString().trim()); } catch (Exception e) { return 0; }
		}
		private static double round2(double val) {
		    return Math.round(val * 100.0) / 100.0;
		}



	
	
			



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	

}
