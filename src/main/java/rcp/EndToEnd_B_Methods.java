package rcp;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import businessTestCases.CommonBusinessUtilis;
import clientPortal.All_ClientPortal_Locators;
import login.BasePage;
import login.LoginLocators;
import performer.LocatorsP;
import performer.PerformerLocator;
import rcp.OneCommonMethod;


public class EndToEnd_B_Methods extends BasePage {
	
    static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour.xlsx";
    
    
    
    
    
    
    
	public static void StaturyDocuPT( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	


	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		PerformerLocator.clickStatutoryDoc().click();
		Thread.sleep(2000);
		PerformerLocator.clickComplianceType().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceChallan().click();
		Thread.sleep(2000);
		PerformerLocator.clickAct2().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceType4().click();
		Thread.sleep(2000);
		PerformerLocator.clickYear().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceType1().click();
		Thread.sleep(2000);
		PerformerLocator.clickPeriod().click();
		Thread.sleep(2000);
		PerformerLocator.selectMonth().click();
		
		
		Thread.sleep(2000);
		PerformerLocator.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		PerformerLocator.clickApply().click();
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click();
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click(); 
		Thread.sleep(2000);
		
		
	//This code is for validate PT Gross Total	
		try {
	        // Step 1: Pre-download file count
	        File downloadDir = new File("C:\\Users\\bilali\\Downloads");
	        File[] beforeDownload = downloadDir.listFiles();

	        // Step 2: Click Download Button
//	        All_ClientPortal_Locators.DownloadBtn().click();
	        getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click();
	        Thread.sleep(4000);
	        getDriver().findElement(By.xpath("(//img[@alt='Download Document'])[1]")).click();
	        Thread.sleep(10000); // Wait for download

	        // Step 3: Post-download file count & detect new file
	        File[] afterDownload = downloadDir.listFiles();
	        File latestFile = null;
	        long lastModifiedTime = Long.MIN_VALUE;

	        for (File file : afterDownload) {
	            boolean isNew = true;
	            for (File oldFile : beforeDownload) {
	                if (file.getName().equals(oldFile.getName()) && file.lastModified() == oldFile.lastModified()) {
	                    isNew = false;
	                    break;
	                }
	            }
	            if (isNew && file.getName().endsWith(".xlsx") && file.lastModified() > lastModifiedTime) {
	                latestFile = file;
	                lastModifiedTime = file.lastModified();
	            }
	        }

	        // Step 4: Download check
	        if (latestFile != null) {
	            test.log(LogStatus.PASS, "File downloaded successfully: " + latestFile.getName());
	        } else {
	            test.log(LogStatus.FAIL, "File not downloaded.");
	            return;
	        }

	        // Step 5: Excel validation logic
	        FileInputStream fis = new FileInputStream(latestFile);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet("PTChallan");

	        double calculatedSum = 0;
	        double expectedTotal = 0;

	        for (Row row : sheet) {
	            Cell cellA = row.getCell(0);
	            if (cellA != null && cellA.getCellType() == CellType.STRING &&
	                cellA.getStringCellValue().trim().equalsIgnoreCase("Total")) {

	                Cell totalCell = row.getCell(6); // Column G
	                if (totalCell != null && totalCell.getCellType() == CellType.NUMERIC) {
	                    expectedTotal = totalCell.getNumericCellValue();
	                }
	                break;
	            }

	            Cell salaryCell = row.getCell(6); // Column G
	            if (salaryCell != null && salaryCell.getCellType() == CellType.NUMERIC) {
	                calculatedSum += salaryCell.getNumericCellValue();
	            }
	        }

	        workbook.close();
	        fis.close();

	        // Step 6: Final report log
	        if (calculatedSum == expectedTotal) {
	            test.log(LogStatus.PASS, "PT Challan Amount Match ✅ - Calculated: " + calculatedSum + ", Expected: " + expectedTotal);
	        } else {
	            test.log(LogStatus.FAIL, "PT Challan Amount Mismatch ❌ - Calculated: " + calculatedSum + ", Expected: " + expectedTotal);
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.ERROR, "Exception: " + e.getMessage());
	        e.printStackTrace();
	    }
		
		
		
		
	}
    
    
    
    
	public static void StaturyDocPF_Basic_EPFwagesMatching( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		PerformerLocator.clickStatutoryDoc().click();
		Thread.sleep(2000);
		PerformerLocator.clickComplianceType().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceChallan().click();
		Thread.sleep(2000);
		PerformerLocator.clickAct2().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceEPF().click();
		Thread.sleep(2000);
		PerformerLocator.clickYear().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceType1().click();
		Thread.sleep(2000);
		PerformerLocator.clickPeriod().click();
		Thread.sleep(2000);
		PerformerLocator.selectMonthMay().click();
		
		
		Thread.sleep(2000);
		PerformerLocator.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		PerformerLocator.clickApply().click();
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click(); 
		Thread.sleep(7000);
		getDriver().findElement(By.xpath("(//img[@alt='Download Document'])[5]")).click();
		Thread.sleep(7000);
		
		
		/**
	    This method performs the following steps:

	    1. Dynamically detects the user's Downloads folder.
	    2. Captures the list of files before download.
	    3. Initiates a file download through the browser (via XPath click).
	    4. Waits and captures the latest downloaded Excel file.
	    5. Opens the "Pending" tab from the Excel file.
	    6. Loops through rows to find:
	        - In Column A: the row where the cell value is "Total"
	            → From that row, captures the numeric value in Column S (index 18).
	        - In Column H: the cell with value "Basic"
	            → From that row, looks down 5 rows in same column to capture the next numeric value.
	    7. Compares the two extracted values:
	        - If both are zero or both match, it's marked as PASS.
	        - Else, marked as FAIL.
	    8. Any exception during process is logged as ERROR.
	*/

		
		
		
		
		
		
		
/*		
		
		try {
		    // Step 1: Capture pre-download state (dynamic & platform-independent path)
		    String downloadPath = System.getProperty("user.home") + File.separator + "Downloads";
		    File downloadDir = new File(downloadPath);
		    File[] beforeDownload = downloadDir.listFiles();

		    // Step 2: Trigger download
		    getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click();
		    Thread.sleep(4000);
		    getDriver().findElement(By.xpath("(//img[@alt='Download Document'])[5]")).click();
		    Thread.sleep(10000); // Allow download time

		    // Step 3: Find newly downloaded file
		    File[] afterDownload = downloadDir.listFiles();
		    File latestFile = null;
		    long lastModified = Long.MIN_VALUE;

		    for (File file : afterDownload) {
		        boolean isNew = true;
		        for (File old : beforeDownload) {
		            if (file.getName().equals(old.getName()) && file.lastModified() == old.lastModified()) {
		                isNew = false;
		                break;
		            }
		        }
		        if (isNew && file.getName().endsWith(".xlsx") && file.lastModified() > lastModified) {
		            latestFile = file;
		            lastModified = file.lastModified();
		        }
		    }

		    if (latestFile == null) {
		        test.log(LogStatus.FAIL, "❌ File not downloaded.");
		        return;
		    } else {
		        test.log(LogStatus.PASS, "✅ File downloaded: " + latestFile.getName());
		    }

		    // Step 4: Open the Excel sheet - now from "Pending" tab
		    FileInputStream fis = new FileInputStream(latestFile);
		    Workbook workbook = WorkbookFactory.create(fis);
		    Sheet sheet = workbook.getSheet("Pending");

		    double epfWagesTotal = 0;
		    double basicAmount = 0;

		    for (int i = 0; i <= sheet.getLastRowNum(); i++) {
		        Row row = sheet.getRow(i);
		        if (row == null) continue;

		        // Step 5: Check column A == "Total"
		        Cell cellA = row.getCell(0);
		        if (cellA != null && cellA.getCellType() == CellType.STRING &&
		            cellA.getStringCellValue().trim().equalsIgnoreCase("Total")) {

		            Cell cellS = row.getCell(18); // Column S = index 18
		            if (cellS != null && cellS.getCellType() == CellType.NUMERIC) {
		                epfWagesTotal = cellS.getNumericCellValue();
		            }
		        }

		        // Step 6: Find "Basic" in Column H and fetch numeric value below it
		        Cell cellH = row.getCell(7); // Column H = index 7
		        if (cellH != null && cellH.getCellType() == CellType.STRING &&
		            cellH.getStringCellValue().trim().equalsIgnoreCase("Basic")) {

		            // Scan below to find the first non-empty numeric value
		            for (int j = i + 1; j <= i + 5; j++) {
		                Row belowRow = sheet.getRow(j);
		                if (belowRow != null) {
		                    Cell valueCell = belowRow.getCell(7);
		                    if (valueCell != null && valueCell.getCellType() == CellType.NUMERIC) {
		                        basicAmount = valueCell.getNumericCellValue();
		                        break;
		                    }
		                }
		            }
		        }

		        if (epfWagesTotal != 0 && basicAmount != 0) break;
		    }

		    workbook.close();
		    fis.close();

		    // Step 7: Final Validation
		    boolean bothEmptyOrZero = (epfWagesTotal == 0 && basicAmount == 0);
		    boolean bothPresentAndMatch = (epfWagesTotal != 0 && basicAmount != 0 && epfWagesTotal == basicAmount);

		    if (bothEmptyOrZero || bothPresentAndMatch) {
		        test.log(LogStatus.PASS, "✅ EPF Wages (₹" + epfWagesTotal + ") matches Basic (₹" + basicAmount + ")");
		    } else {
		        test.log(LogStatus.FAIL, "❌ Mismatch - EPF Wages: ₹" + epfWagesTotal + ", Basic: ₹" + basicAmount);
		    }

		} catch (Exception e) {
		    test.log(LogStatus.ERROR, "❌ Exception while validating PF file: " + e.getMessage());
		    e.printStackTrace();
		}

		


		*/
		

		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		try {
		    String sheetName = "Remittances";
		   
		    
//		    FileInputStream fis = new FileInputStream("C:\\Users\\bilali\\Downloads\\PF_Working_New (1).xlsx");
		    
		    
		 // 🔍 Automatically pick latest downloaded Excel file from Downloads folder
		    File downloadDir = new File("C:\\Users\\bilali\\Downloads");
		    File[] files = downloadDir.listFiles((dir, name) -> name.endsWith(".xlsx"));

		    File latestFile = null;
		    long lastModified = Long.MIN_VALUE;

		    if (files != null) {
		        for (File file : files) {
		            if (file.lastModified() > lastModified) {
		                latestFile = file;
		                lastModified = file.lastModified();
		            }
		        }
		    }

		    if (latestFile != null) {
		        FileInputStream fis = new FileInputStream(latestFile);
		        Workbook workbook = WorkbookFactory.create(fis);
		        
		        // 📌 Your remaining logic continues from here...
		        // Sheet sheet = workbook.getSheet(...);
		    } else {
		        test.log(LogStatus.FAIL, "❌ No Excel file found in Downloads folder.");
		        return; // Exit the test early
		    }

		    
		    
		    
		    
		    

		    
		    
		    
		    
		    
		    
		    Workbook workbook = WorkbookFactory.create(fis);
		    Sheet sheet = workbook.getSheet(sheetName);

		    double epfWagesTotal = 0;
		    double basicAmount = 0;

		    boolean pfSummaryFound = false;
		    int basicColIndex = -1;
		    boolean basicValueCaptured = false;
		    boolean epfValueCaptured = false;

		    for (int i = 0; i <= sheet.getLastRowNum(); i++) {
		        Row row = sheet.getRow(i);
		        if (row == null) continue;

		        Cell firstCell = row.getCell(0);

		        // STEP 1: Get EPF Wages Total from "Total" row, column S (index 18)
		        if (firstCell != null && firstCell.getCellType() == CellType.STRING &&
		            firstCell.getStringCellValue().trim().equalsIgnoreCase("Total")) {

		            Cell epfTotalCell = row.getCell(18); // Column S
		            if (epfTotalCell != null && epfTotalCell.getCellType() == CellType.NUMERIC) {
		                epfWagesTotal = epfTotalCell.getNumericCellValue();
		                epfValueCaptured = true;
		            }
		        }

		        // STEP 2: Find PF Summary Section
		        for (Cell cell : row) {
		            if (cell != null && cell.getCellType() == CellType.STRING &&
		                cell.getStringCellValue().contains("PF Summary for wages details")) {
		                pfSummaryFound = true;
		                break;
		            }
		        }

		        // STEP 3: If PF Summary found, locate Basic column and fetch its value
		        if (pfSummaryFound && !basicValueCaptured) {
		            Row headerRow = sheet.getRow(i + 1);
		            if (headerRow != null) {
		                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
		                    Cell cell = headerRow.getCell(j);
		                    if (cell != null && cell.getCellType() == CellType.STRING &&
		                        cell.getStringCellValue().trim().equalsIgnoreCase("Basic")) {
		                        basicColIndex = j;
		                        break;
		                    }
		                }
		            }

		            // Now get value from (i + 2) row, same column
		            if (basicColIndex != -1) {
		                Row valueRow = sheet.getRow(i + 2);
		                if (valueRow != null) {
		                    Cell basicValueCell = valueRow.getCell(basicColIndex);
		                    if (basicValueCell != null && basicValueCell.getCellType() == CellType.NUMERIC) {
		                        basicAmount = basicValueCell.getNumericCellValue();
		                        basicValueCaptured = true;
		                    }
		                }
		            }
		        }

		        // Early exit if both found
		        if (epfValueCaptured && basicValueCaptured) {
		            break;
		        }
		    }

		    workbook.close();
		    fis.close();

		    // ✅ RESULT LOGIC
		    if (!epfValueCaptured || !basicValueCaptured) {
		        test.log(LogStatus.FAIL, "Cells are empty ❌ - EPF or Basic value missing in sheet");
		    } else if (epfWagesTotal == basicAmount) {
		        test.log(LogStatus.PASS, "PF Basic amount matched with EPF Wages Total ✅: ₹" + basicAmount);
		    } else {
		        test.log(LogStatus.FAIL, "Mismatch ❌ - EPF Wages Total: ₹" + epfWagesTotal + ", Basic: ₹" + basicAmount);
		    }

		} catch (Exception e) {
		    test.log(LogStatus.ERROR, "Exception occurred while validating PF wages: " + e.getMessage());
		    e.printStackTrace();
		}

		
		
		
		
		
	}
    
	
	
	
	public static void StaturyDocPF_Basic_BasicWagesColumn( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		PerformerLocator.clickStatutoryDoc().click();
		Thread.sleep(2000);
		PerformerLocator.clickComplianceType().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceChallan().click();
		Thread.sleep(2000);
		PerformerLocator.clickAct2().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceEPF().click();
		Thread.sleep(2000);
		PerformerLocator.clickYear().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceType1().click();
		Thread.sleep(2000);
		PerformerLocator.clickPeriod().click();
		Thread.sleep(2000);
		PerformerLocator.selectMonthMay().click();
		
		
		Thread.sleep(2000);
		PerformerLocator.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		PerformerLocator.clickApply().click();
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click();
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click(); 
		Thread.sleep(7000);
		
	
		
		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click();
		Thread.sleep(7000);
		
	//	getDriver().findElement(By.xpath("(//img[@alt='Download Document'])[5]")).click();
		Thread.sleep(5000);
		
		
		
		
		
	/**
	    This method performs the following steps:

	    1. Dynamically detects the current user's Downloads folder (platform-independent).
	    2. Captures the list of files in Downloads before the download starts.
	    3. Initiates the file download from the web application by clicking the appropriate buttons (using Selenium XPath).
	    4. Waits for the download to complete and detects the newly downloaded Excel (.xlsx) file.
	    5. Opens the downloaded Excel file and accesses the "Pending" sheet.
	    6. Identifies the header row (typically the second row) and locates the column index of "Basic Wages".
	    7. Iterates through all rows *below the header*:
	        - Sums all numeric values under the "Basic Wages" column until the "Total" row appears.
	        - When the "Total" row is reached (where first column is "Total"), captures the corresponding value in the "Basic Wages" column as the expected total.
	    8. Compares:
	        - The calculated sum of "Basic Wages" values.
	        - The expected total value from the "Total" row.
	    9. Logging results:
	        - If there is no "Basic Wages" data, logs as PASS (as per business rule).
	        - If sum and total match, logs as PASS.
	        - If they do not match, logs as FAIL.
	    10. Any exceptions during the process are caught and logged as ERROR.
	**/

		
		
		
	/*	
		OneCommonMethod.validateExcelTotal(
			    driver.get(),                                 // ✅ use .get() here
			    test,
			    PerformerLocator.PfWorkingFileDownload(),
			    "Basic Wages",
			    "Pending",
			    "Basic Wages Total Validation Matched..."
			);
		
		
		*/
		
		
		
		
		
/*		try {
		    // Step 1: Dynamic download directory (works on all user profiles)
		    String downloadPath = System.getProperty("user.home") + File.separator + "Downloads";
		    File downloadDir = new File(downloadPath);
		    File[] beforeDownload = downloadDir.listFiles();

		    // Step 2: Trigger Excel file download via Selenium
		    
		    Thread.sleep(4000);
		    PerformerLocator.PfWorkingFileDownload().click();
		    Thread.sleep(10000); // adjust if file is large

		    // Step 3: Identify newly downloaded file
		    File[] afterDownload = downloadDir.listFiles();
		    File latestFile = null;
		    long lastModified = Long.MIN_VALUE;

		    for (File file : afterDownload) {
		        boolean isNew = true;
		        for (File old : beforeDownload) {
		            if (file.getName().equals(old.getName()) && file.lastModified() == old.lastModified()) {
		                isNew = false;
		                break;
		            }
		        }
		        if (isNew && file.getName().endsWith(".xlsx") && file.lastModified() > lastModified) {
		            latestFile = file;
		            lastModified = file.lastModified();
		        }
		    }

		    if (latestFile == null) {
		        test.log(LogStatus.FAIL, "❌ File not downloaded.");
		        return;
		    } else {
		        test.log(LogStatus.PASS, "✅ File downloaded: " + latestFile.getName());
		    }

		    // Step 4: Read "Pending" Sheet, Find "Basic Wages" Header in 2nd row, and Sum its column
		    FileInputStream fis = new FileInputStream(latestFile);
		    Workbook workbook = WorkbookFactory.create(fis);
		    Sheet sheet = workbook.getSheet("Pending");

		    if (sheet == null) {
		        test.log(LogStatus.PASS, "'Pending' sheet not found. No data to process.");
		        workbook.close(); fis.close();
		        return;
		    }

		    // Step 5: Identify the row containing SECOND header and the column index for "Basic Wages"
		    int headerRowNum = 1; // Usually 2nd row (0-based index)
		    Row headerRow = sheet.getRow(headerRowNum);
		    int basicWagesCol = -1;
		    for (Cell cell : headerRow) {
		        if (cell.getCellType() == CellType.STRING &&
		            cell.getStringCellValue().trim().equalsIgnoreCase("Basic Wages")) {
		            basicWagesCol = cell.getColumnIndex();
		            break;
		        }
		    }

		    if (basicWagesCol == -1) {
		        // Column not found, skip
		        workbook.close(); fis.close();
		        test.log(LogStatus.PASS, "'Basic Wages' column NOT found, no data to process.");
		        return;
		    }

		    // Step 6: Sum all numbers in column "Basic Wages" till "Total" row
		    double calculatedSum = 0;
		    double expectedTotal = 0;
		    boolean dataFound = false;
		    for (int i = headerRowNum + 1; i <= sheet.getLastRowNum(); i++) {
		        Row row = sheet.getRow(i);
		        if (row == null)
		            continue;
		        Cell firstCol = row.getCell(0); // "Sl No" / "Total" finder
		        // If reached "Total" row, break and fetch total from that row
		        if (firstCol != null && firstCol.getCellType() == CellType.STRING &&
		            firstCol.getStringCellValue().trim().equalsIgnoreCase("Total")) {
		            Cell totalCell = row.getCell(basicWagesCol);
		            if (totalCell != null && totalCell.getCellType() == CellType.NUMERIC) {
		                expectedTotal = totalCell.getNumericCellValue();
		            }
		            break;
		        }
		        // Sum only if valid number present
		        Cell valCell = row.getCell(basicWagesCol);
		        if (valCell != null && valCell.getCellType() == CellType.NUMERIC) {
		            calculatedSum += valCell.getNumericCellValue();
		            dataFound = true;
		        }
		    }

		    workbook.close(); fis.close();

		    // Step 7: Final validation
		    if (!dataFound) {
		        test.log(LogStatus.PASS, "No 'Basic Wages' data found. Treated as PASS.");
		    } else if (Math.abs(calculatedSum - expectedTotal) < 0.001) {
		        test.log(LogStatus.PASS, "✅ Basic Wages SUM matched: Calculated = " + calculatedSum + ", Sheet Total = " + expectedTotal);
		    } else {
		        test.log(LogStatus.FAIL, "❌ Basic Wages SUM mismatch: Calculated = " + calculatedSum + ", Sheet Total = " + expectedTotal);
		    }

		} catch (Exception e) {
		    test.log(LogStatus.ERROR, "❌ Exception: ");
		    e.printStackTrace();
		}


		
		*/
		
		
		
		
		
		
	}
		
	
	
	public static void T1( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		OneCommonMethod.validateExcelTotal(
			    driver.get(),                                 // ✅ use .get() here
			    test,
			    PerformerLocator.PfWorkingFileDownload(),
			    "Gross Wages",
			    "Remittances",
			    "Gross Wages Total Validation Matched..."
			);
		

		
		
	}
	
	
	
	
	public static File downloadedExcelFile; // shared file for all test cases
	
	public static void T6( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		

	    
	        WebDriver driver = CommonBusinessUtilis.getDriver(); // ya jo bhi driver method hai
	        

	        // Step 1: Manually download file
	        getDriver().findElement(By.xpath("(//img[@alt='Download Document'])[5]")).click();
	        Thread.sleep(8000); // wait for file to download

	        // Step 2: Get latest file
	        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
	        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
	        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
	        downloadedExcelFile = files[0];
	        
	        
	        
	        
	        

	        CommonBusinessUtilis.validateExcelTotalByColumnIndex(
	        	    driver,
	        	    test,
	        	    downloadedExcelFile,
	        	    15,                  // Column Index
	        	    1,                  // Header is on row index 1 (i.e. second row)
	        	    "Pending",          // Sheet Name
	        	    "Basic Wages Validation"
	        	);

	    

		
		
	}
	
	public static void T7( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriver driver = CommonBusinessUtilis.getDriver();

	
		
        // Validate Basic Wages
		CommonBusinessUtilis.validateExcelTotalByColumnIndex(
			    driver,
			    test,
			    downloadedExcelFile,
			    52,                  // Column Index
			    1,                  // Header is on row index 1 (i.e. second row)
			    "All Employees",          // Sheet Name
			    "(--) All Employees Wages Validation"
			);

		
	}
	
	public static void T8( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		
        
		WebDriver driver = CommonBusinessUtilis.getDriver();
		
        // Validate Basic Wages
		CommonBusinessUtilis.validateExcelTotalByColumnIndex(
			    driver,
			    test,
			    downloadedExcelFile,
			    12,                  // Column Index
			    1,                  // Header is on row index 1 (i.e. second row)
			    "Pending",          // Sheet Name
			    "Basic Wages Validation"
			);

		
		
	}
	
	public static void T9( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriver driver = CommonBusinessUtilis.getDriver();
		
        // Validate Basic Wages
		CommonBusinessUtilis.validateExcelTotalByColumnIndex(
			    driver,
			    test,
			    downloadedExcelFile,
			    10,                  // Column Index
			    1,                  // Header is on row index 1 (i.e. second row)
			    "Remittances",          // Sheet Name
			    "Basic Wages Validation"
			);
		
	}
	//Unique Identi
	public static void T10( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		WebDriver driver = CommonBusinessUtilis.getDriver();

/*		// ✅ Step 1: Manually download
	//	driver.findElement(By.xpath("(//img[@alt='Download Document'])[5]")).click();
		getDriver().findElement(By.xpath("(//img[@alt='Download Document'])[5]")).click();
		Thread.sleep(8000); // Wait for download

		// ✅ Step 2: Fetch latest downloaded file
		File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
		File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
		Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
		File downloadedExcelFile = files[0];  // Latest file

		*/
		
		// ✅ Step 3: Call uniqueness method
		CommonBusinessUtilis.validateColumnHasUniqueValues(
			    driver,
			    test,
			    downloadedExcelFile,
			    1,                 // Column Index for Employee Number (e.g., column B)
			    1,                 // Header at row 2 (i.e., index 1)
			    "Pending",         // Sheet name
			    "Employee Ids uniqness"      // Log/Report label — bas yahi dikhaya jayega report me
			);

		

		
	}
	
	public static void T11( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		WebDriver driver = CommonBusinessUtilis.getDriver();
		// ✅ Step 3: Call uniqueness method
		CommonBusinessUtilis.validateColumnHasUniqueValues(
			    driver,
			    test,
			    downloadedExcelFile,
			    0,                 // Column Index for Employee Number (e.g., column B)
			    1,                 // Header at row 2 (i.e., index 1)
			    "Remittances",         // Sheet name
			    "Serial Numbers Uniquness"      // Log/Report label — bas yahi dikhaya jayega report me
			);
		
	}
	
	public static void T12( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		WebDriver driver = CommonBusinessUtilis.getDriver();
		// ✅ Step 3: Call uniqueness method
		CommonBusinessUtilis.validateColumnHasUniqueValues(
			    driver,
			    test,
			    downloadedExcelFile,
			    4,                 // Column Index for Employee Number (e.g., column B)
			    1,                 // Header at row 2 (i.e., index 1)
			    "Remittances",         // Sheet name
			    "P-F Numbers Uniquness"      // Log/Report label — bas yahi dikhaya jayega report me
			);
		
		
	}
	public static void T13( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		WebDriver driver = CommonBusinessUtilis.getDriver();
		File downloadedExcelFile = CommonBusinessUtilis.getLatestDownloadedExcelFile();
		CommonBusinessUtilis.validateTotalCellValueWithTotalSummary(
		    driver,
		    test,
		    downloadedExcelFile,
		    "Pending",        // sheetName
		    19,               // totalColumnIndex (S)
		    1,                // headerRowIndex
		    "Total",          // totalKeyword
		    7,                // dynamicHeaderColumnIndex (H)
		    "Basic",          // headerName
		    1                 // rowsAfterHeader
		);

	}
	public static void T14( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		WebDriver driver = CommonBusinessUtilis.getDriver();
		File downloadedExcelFile = CommonBusinessUtilis.getLatestDownloadedExcelFile();
		CommonBusinessUtilis.validateTotalCellValueWithTotalSummary(
		    driver,
		    test,
		    downloadedExcelFile,
		    "Pending",        // sheetName
		    19,               // totalColumnIndex (S)
		    1,                // headerRowIndex
		    "Total",          // totalKeyword
		    7,                // dynamicHeaderColumnIndex (H)
		    "PF Basic",          // headerName
		    1                 // rowsAfterHeader
		);
		
	}
	public static void T15( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		WebDriver driver = CommonBusinessUtilis.getDriver();
		File downloadedExcelFile = CommonBusinessUtilis.getLatestDownloadedExcelFile();
		CommonBusinessUtilis.validateTotalCellValueWithTotalSummary(
		    driver,
		    test,
		    downloadedExcelFile,
		    "Remittances",        // sheetName
		    19,               // totalColumnIndex (S)
		    1,                // headerRowIndex
		    "Total",          // totalKeyword
		    7,                // dynamicHeaderColumnIndex (H)
		    "BBBB",          // headerName
		    8                 // rowsAfterHeader
		); 
		


		
		
		
	}
	
	
	
	
	
	public static void T2( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		OneCommonMethod.validateExcelTotal(
			    driver.get(),                                 // ✅ use .get() here
			    test,
			    PerformerLocator.PfWorkingFileDownload(),
			    "Old Emp Arrear Basic",
			    "Pending",
			    "Old Emp Arrear Basic Total Validation Matched"
			);
		
	}
	
	public static void T3( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		OneCommonMethod.validateExcelTotal(
			    driver.get(),                                 // ✅ use .get() here
			    test,
			    PerformerLocator.PfWorkingFileDownload(),
			    "Reversal Basic",
			    "Pending",
			    "Reversal Basic Total Validation Matched..."
			);
		
	}
	public static void T4( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		OneCommonMethod.validateExcelTotal(
			    driver.get(),                                 // ✅ use .get() here
			    test,
			    PerformerLocator.PfWorkingFileDownload(),
			    "Actual Basic Wages",
			    "Pending",
			    "Actual Basic Wages Total Validation Matched"
			);

	}
	
	public static void T5( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		OneCommonMethod.validateExcelTotal(
			    driver.get(),                                 // ✅ use .get() here
			    test,
			    PerformerLocator.PfWorkingFileDownload(),
			    "DIFF",
			    "Pending",
			    "DIFF(-) Wages Total Validation Matched"
			);
	
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    



