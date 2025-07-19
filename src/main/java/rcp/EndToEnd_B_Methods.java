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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

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
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click(); 
		Thread.sleep(7000);
		
		
		
		
		
		
		
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

		


		
		

		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		try {
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

		
		*/
		
		
		
		
		
		
		
		
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}

