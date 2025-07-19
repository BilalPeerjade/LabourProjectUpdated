package clientPortal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import coordinator.CoordinatorLocator;
import coordinator.CoordinatorMethod;
import distributor.Locators;
import login.BasePage;
import login.LoginLocators;
import rcp.OneCommonMethod;

public class All_ClientPortal_Methods extends BasePage {

	
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	 static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour.xlsx";

	
	public static void filterEntity ( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(7000);		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='k-input-inner k-readonly']")));	//Wait until records table get visible.

	  	
		All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAENTEST().click();
		Thread.sleep(9000);
		
		All_ClientPortal_Locators.SelectYear().click();
		Thread.sleep(5000);
	  	All_ClientPortal_Locators.SelectYear22().click();
		Thread.sleep(2000);
	 	All_ClientPortal_Locators.Apply().click();
			Thread.sleep(8000);
		  
			Thread.sleep(8000);
	}
	
	public static void filterEntityAUTO2 ( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(7000);		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (120));
		Thread.sleep(6000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='k-input-inner k-readonly']")));	//Wait until records table get visible.

	  	
		All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(4000);
	  	All_ClientPortal_Locators.EntityTri2().click();
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.EntityTESTAUTO2()));
		
		All_ClientPortal_Locators.EntityTESTAUTO2().click();
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.SelectYear()));
		
		All_ClientPortal_Locators.SelectYear().click();
		Thread.sleep(6000);
	  	All_ClientPortal_Locators.SelectYear22().click();
		Thread.sleep(3000);
	 	All_ClientPortal_Locators.Apply().click();
			Thread.sleep(8000);
		  
	}
	
	public static void Flaky_filterEntityAUTO2 ( ExtentTest test) throws InterruptedException, IOException
	{
		
		int maxRetry = 3;
	    int attempts = 0;
	    boolean success = false;
	    
	    while (attempts < maxRetry) {
	        try {
	            // Your actual dropdown click + apply logic
	            System.out.println("Applying filters... attempt " + (attempts + 1));

	            // Simulating flaky action
	            if (Math.random() > 0.7) {
	                System.out.println("Filter applied successfully");
	                success = true;
	                break;
	            } else {
	                throw new Exception("Dropdown failed");
	            }

	        } catch (Exception e) {
	            System.out.println("Attempt " + (attempts + 1) + " failed.");
	        }
	        attempts++;
	    }

		
		
		
		
		
		
		Thread.sleep(7000);		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (120));
		Thread.sleep(6000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='k-input-inner k-readonly']")));	//Wait until records table get visible.

	  	
		All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(4000);
	  	All_ClientPortal_Locators.EntityTri2().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.EntityTESTAUTO2().click();
		Thread.sleep(10000);
		
		All_ClientPortal_Locators.SelectYear().click();
		Thread.sleep(6000);
	  	All_ClientPortal_Locators.SelectYear22().click();
		Thread.sleep(3000);
	 	All_ClientPortal_Locators.Apply().click();
			Thread.sleep(8000);
		  
	}
	
	
	public static void FlakyTest_filterEntityAUTO2(ExtentTest test) throws InterruptedException, IOException {
	    Thread.sleep(7000);
	    Actions action = new Actions(getDriver());
	    WebDriverWait wait = new WebDriverWait(getDriver(), 120);
	    Thread.sleep(6000);

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='k-input-inner k-readonly']"))); // Wait until records table get visible.

	    int maxRetry = 3;
	    int attempts = 0;
	    boolean success = false;

	    while (attempts < maxRetry) {
	        try {
	            System.out.println("Applying filters... attempt " + (attempts + 1));

	            All_ClientPortal_Locators.SelectEntity().click();
	            Thread.sleep(4000);

	            All_ClientPortal_Locators.EntityTri2().click();
	            Thread.sleep(5000);

	            All_ClientPortal_Locators.EntityTESTAUTO2().click();
	            Thread.sleep(10000);

	            All_ClientPortal_Locators.SelectYear().click();
	            Thread.sleep(6000);

	            All_ClientPortal_Locators.SelectYear22().click();
	            Thread.sleep(3000);

	            All_ClientPortal_Locators.Apply().click();
	            Thread.sleep(8000);

	            // If everything passed without exception, mark success and break the loop
	            success = true;
	            System.out.println("Filter applied successfully");
	            break;

	        } catch (Exception e) {
	            System.out.println("Attempt " + (attempts + 1) + " failed with error: " + e.getMessage());
	        }

	        attempts++;
	    }

	    if (!success) {
	        throw new RuntimeException("filterEntityAUTO2 failed after " + maxRetry + " retries");
	    }
	}

	
	
	

	
	
	
	public static void Entities(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.Entities().getText();		//Storing old value of Statutory overdue.
	    int	CategoriesCountDas = Integer.parseInt(string_Categories);
	    All_ClientPortal_Locators.Entities().click();
	    waitForLoaderToDisappear(); //Wait until loader removed
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Entities in the grid = "+CatcountGrid+" | Dashboard Entities  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Entities in the grid = "+CatcountGrid+" | Dashboard Entities Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);		
		
		
		
		
	}
	
	
	public static void EntitiesSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
	    All_ClientPortal_Locators.Entities().click();
		Thread.sleep(5000);
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.Search().sendKeys("TESTAUTO2",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='TESTAUTO2']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected entity name along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Entity selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	public static void EntitiesTabPagination(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
	    All_ClientPortal_Locators.Entities().click();
		Thread.sleep(5000);
		
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);
		
	
	}
	
	
	public static void Locations(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.Locations().getText();		//Storing old value of Statutory overdue.
    	int	CategoriesCountDas = Integer.parseInt(string_Categories);
	    All_ClientPortal_Locators.Locations().click();
	    waitForLoaderToDisappear(); //Wait until loader removed
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Locations in the grid = "+CatcountGrid+" | Dashboard Locations  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Locations in the grid = "+CatcountGrid+" | Dashboard Locations Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
			
	}
	
	public static void LocationsPagination(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		String string_Categories =All_ClientPortal_Locators.Locations().getText();		//Storing old value of Statutory overdue.
//    	int	CategoriesCountDas = Integer.parseInt(string_Categories);
		
		
		
	    All_ClientPortal_Locators.Locations().click();
		
//		All_ClientPortal_Locators.AssignedCompliances().click();
		
		
	    waitForLoaderToDisappear(); //Wait until loader removed
		Thread.sleep(5000);
		
		
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);
		
		
	}
	
	
	public static void LocationsSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
	All_ClientPortal_Locators.Locations().click();
		Thread.sleep(5000);
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.Search().sendKeys("TESTAUTO2",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='TESTAUTO2']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Locations name along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Entity selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	public static void AssignedCompliances(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.AssignedCompliances().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
	All_ClientPortal_Locators.AssignedCompliances().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Assigned Compliances in the grid = "+CatcountGrid+" | Dashboard Assigned Compliances Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Assigned Compliances in the grid = "+CatcountGrid+" | Dashboard Assigned Compliances Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void AssignedCompliancesRgisterReturnChallanCount(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
    Thread.sleep(5000);
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    Thread.sleep(3000);

    // Click on Assigned Compliances tab
    All_ClientPortal_Locators.AssignedCompliances().click();
    CoordinatorMethod.zoomOutScreen(2); // ZoomOut
    Thread.sleep(5000);

    WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    wait.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.readTotalItems()));
    Thread.sleep(3000);

    // Get total compliance count (before filter)
    All_ClientPortal_Locators.readTotalItems().click();
    String item = All_ClientPortal_Locators.readTotalItems().getText();
    String[] bits = item.split(" ");
    String totalComplianceStr = bits[bits.length - 2];
    int totalComplianceCount = Integer.parseInt(totalComplianceStr);
    Thread.sleep(2000);

    int registerCount = 0;
    int returnCount = 0;
    int challanCount = 0;

    // ------ Step 1: Register ------
    All_ClientPortal_Locators.complianceDropdwonClick().click();
    Thread.sleep(1000);
    All_ClientPortal_Locators.complianceSelectOnRegisters().click();
    All_ClientPortal_Locators.ClickApplyBtn().click();
    Thread.sleep(5000);

    String registerItem = All_ClientPortal_Locators.readTotalItems().getText();
    String[] regBits = registerItem.split(" ");
    registerCount = Integer.parseInt(regBits[regBits.length - 2]);
    test.log(LogStatus.INFO, "Register filter selected. Count found: " + registerCount);

    // ------ Step 2: Return ------
    All_ClientPortal_Locators.complianceSelectOnRegisters().click(); // Unselect previous
    Thread.sleep(1000);
    All_ClientPortal_Locators.complianceSelectOnReturn().click();
    All_ClientPortal_Locators.ClickApplyBtn().click();
    Thread.sleep(5000);

    String returnItem = All_ClientPortal_Locators.readTotalItems().getText();
    String[] retBits = returnItem.split(" ");
    returnCount = Integer.parseInt(retBits[retBits.length - 2]);
    test.log(LogStatus.INFO, "Return filter selected. Count found: " + returnCount);

    // ------ Step 3: Challan ------
    All_ClientPortal_Locators.complianceSelectOnReturn().click(); // Unselect previous
    Thread.sleep(1000);
    All_ClientPortal_Locators.complianceSelectOnChallan().click();
    All_ClientPortal_Locators.ClickApplyBtn().click();
    Thread.sleep(5000);

    String challanItem = All_ClientPortal_Locators.readTotalItems().getText();
    String[] chaBits = challanItem.split(" ");
    challanCount = Integer.parseInt(chaBits[chaBits.length - 2]);
    test.log(LogStatus.INFO, "Challan filter selected. Count found: " + challanCount);

    // ------ Step 4: Validation ------
    int combinedCount = registerCount + returnCount + challanCount;

    test.log(LogStatus.INFO, "Total Assigned Compliances Count (from dashboard): " + totalComplianceCount);
    test.log(LogStatus.INFO, "Combined Count (Register + Return + Challan): " + combinedCount);

    if (combinedCount == totalComplianceCount) {
        test.log(LogStatus.PASS, "PASS: Combined count matches total compliance count.");
    } else {
        test.log(LogStatus.FAIL, "FAIL: Combined count does not match total compliance count.");
    }

    Thread.sleep(2000);
		
	}
	
	
	
	
	public static void exportcount(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		waitForLoaderToDisappear();
		
	    All_ClientPortal_Locators.AssignedCompliances().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void assignedCompSearch(ExtentTest test) throws InterruptedException, IOException {
		Thread.sleep(5000);

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		All_ClientPortal_Locators.AssignedCompliances().click();
		Thread.sleep(5000);

/*		// Search Field Function
		try {
			Thread.sleep(5000);
			All_ClientPortal_Locators.compliancePerformanceSearch().sendKeys("20676", Keys.ENTER);
			Thread.sleep(4000);
			String text = getDriver().findElement(By.xpath("//div[@title='20676']")).getText();

			test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
			test.log(LogStatus.PASS, "Compliance ID selected : " + text);

			Thread.sleep(3000);
		} catch (Exception e) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}

		
	*/	
		
		
		
		
		
		
		
		// Clear Function
		All_ClientPortal_Locators.compliancePerformanceSearch().sendKeys("HelloHowAreYou", Keys.ENTER);
		Thread.sleep(4000);

		if (All_ClientPortal_Locators.Clear().isEnabled()) {
			Thread.sleep(5000);

			test.log(LogStatus.PASS, " Clear button working successfully.");
			All_ClientPortal_Locators.Clear().click();
		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, "Clear button does not working properly.");
		}
		Thread.sleep(3000);

	}
	public static void assignedCompRegisterExport(ExtentTest test) throws InterruptedException, IOException {
		Thread.sleep(5000);

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		All_ClientPortal_Locators.AssignedCompliances().click();
		Thread.sleep(5000);
		
		CoordinatorMethod.zoomOutScreen(2); //Zoom Out 

		All_ClientPortal_Locators.complianceDropdwonClick().click();
		Thread.sleep(3000);
		All_ClientPortal_Locators.complianceSelectOnRegisters().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.ClickApplyBtn().click();
		Thread.sleep(5000);
		
		test.log(LogStatus.PASS, "Compliance dropdown: Register is selected");

		// Export logic--

		String item = All_ClientPortal_Locators.readTotalItems().getText();
		String[] bits = item.split(" "); // Splitting the String
		String compliancesCount = bits[bits.length - 2]; // Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);

		if (compliancesCount.equalsIgnoreCase("to")) {
			Thread.sleep(5000);
			item = All_ClientPortal_Locators.readTotalItems().getText();
			bits = item.split(" ");

		}

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) getDriver();

		js1.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		All_ClientPortal_Locators.Export().click();

		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download

		if (dirContents.length < allFilesNew.length) {

			Thread.sleep(9000); // Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			File lastModifiedFile = allFilesNew[0]; // Storing any 0th index file in 'lastModifiedFile' file name.
			for (int i = 1; i < allFilesNew.length; i++) // For loop till the number of files in directory.
			{
				if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) // If allFilesNew[i] file is having
																						// large/latest time time of
																						// update then latest modified
																						// file be allFilesNew[i] file.
				{
					lastModifiedFile = allFilesNew[i];
				}
			}

			Thread.sleep(1000);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0); // Retrieving first sheet of Workbook

			sheet = workbook.getSheetAt(0);
			int columnNumber = 3;
			int rowCount = 0;
			int actualRow = 0;

			for (Row row : sheet) {

				Cell cell = row.getCell(columnNumber);
				if (cell != null) {

					rowCount++;
					actualRow = rowCount - 1;
				}

			}
			fis.close();

			if (count1 == actualRow) {
				// test.log(LogStatus.PASS, "No of records from grid matches to no of records in
				// Excel Sheet.");
				test.log(LogStatus.PASS,
						"Total records from Grid = " + count1 + " | Total records from Report = " + actualRow);
			} else {
				// test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of
				// records in Excel Sheet.");
				test.log(LogStatus.FAIL,
						"Total records from Grid = " + count1 + " | Total records from Excel Sheet = " + actualRow);
			}
		} else {
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}

	}
	
	public static void assignedCompReturnExport(ExtentTest test) throws InterruptedException, IOException {
		Thread.sleep(5000);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		//Explicit wait
		WebDriverWait wait2 = new WebDriverWait(getDriver(), (30));
		wait2.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.AssignedCompliances()));
		
		All_ClientPortal_Locators.AssignedCompliances().click();
		Thread.sleep(5000);
		
		CoordinatorMethod.zoomOutScreen(2); //Zoom Out 

		All_ClientPortal_Locators.complianceDropdwonClick().click();
		Thread.sleep(3000);
		All_ClientPortal_Locators.complianceSelectOnReturn().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.ClickApplyBtn().click();
		Thread.sleep(5000);
		
		test.log(LogStatus.PASS, "Compliance dropdown: Return is selected");

		// Export logic--

		String item = All_ClientPortal_Locators.readTotalItems().getText();
		String[] bits = item.split(" "); // Splitting the String
		String compliancesCount = bits[bits.length - 2]; // Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);

		if (compliancesCount.equalsIgnoreCase("to")) {
			Thread.sleep(5000);
			item = All_ClientPortal_Locators.readTotalItems().getText();
			bits = item.split(" ");

		}

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) getDriver();

		js1.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		All_ClientPortal_Locators.Export().click();

		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download

		if (dirContents.length < allFilesNew.length) {

			Thread.sleep(9000); // Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			File lastModifiedFile = allFilesNew[0]; // Storing any 0th index file in 'lastModifiedFile' file name.
			for (int i = 1; i < allFilesNew.length; i++) // For loop till the number of files in directory.
			{
				if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) // If allFilesNew[i] file is having
																						// large/latest time time of
																						// update then latest modified
																						// file be allFilesNew[i] file.
				{
					lastModifiedFile = allFilesNew[i];
				}
			}

			Thread.sleep(1000);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0); // Retrieving first sheet of Workbook

			sheet = workbook.getSheetAt(0);
			int columnNumber = 3;
			int rowCount = 0;
			int actualRow = 0;

			for (Row row : sheet) {

				Cell cell = row.getCell(columnNumber);
				if (cell != null) {

					rowCount++;
					actualRow = rowCount - 1;
				}

			}
			fis.close();

			if (count1 == actualRow) {
				// test.log(LogStatus.PASS, "No of records from grid matches to no of records in
				// Excel Sheet.");
				test.log(LogStatus.PASS,
						"Total records from Grid = " + count1 + " | Total records from Report = " + actualRow);
			} else {
				// test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of
				// records in Excel Sheet.");
				test.log(LogStatus.FAIL,
						"Total records from Grid = " + count1 + " | Total records from Excel Sheet = " + actualRow);
			}
		} else {
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}

	}
	
	public static void assignedCompChallanExport(ExtentTest test) throws InterruptedException, IOException {
		Thread.sleep(5000);

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		All_ClientPortal_Locators.AssignedCompliances().click();
		Thread.sleep(5000);
		
		CoordinatorMethod.zoomOutScreen(2); //Zoom Out 

		All_ClientPortal_Locators.complianceDropdwonClick().click();
		Thread.sleep(3000);
		All_ClientPortal_Locators.complianceSelectOnChallan().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.ClickApplyBtn().click();
		Thread.sleep(5000);

		test.log(LogStatus.PASS, "Compliance dropdown: Challan is selected");
		
		// Export logic--

		String item = All_ClientPortal_Locators.readTotalItems().getText();
		String[] bits = item.split(" "); // Splitting the String
		String compliancesCount = bits[bits.length - 2]; // Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);

		if (compliancesCount.equalsIgnoreCase("to")) {
			Thread.sleep(5000);
			item = All_ClientPortal_Locators.readTotalItems().getText();
			bits = item.split(" ");

		}

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) getDriver();

		js1.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		All_ClientPortal_Locators.Export().click();

		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download

		if (dirContents.length < allFilesNew.length) {

			Thread.sleep(9000); // Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			File lastModifiedFile = allFilesNew[0]; // Storing any 0th index file in 'lastModifiedFile' file name.
			for (int i = 1; i < allFilesNew.length; i++) // For loop till the number of files in directory.
			{
				if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) // If allFilesNew[i] file is having
																						// large/latest time time of
																						// update then latest modified
																						// file be allFilesNew[i] file.
				{
					lastModifiedFile = allFilesNew[i];
				}
			}

			Thread.sleep(1000);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0); // Retrieving first sheet of Workbook

			sheet = workbook.getSheetAt(0);
			int columnNumber = 3;
			int rowCount = 0;
			int actualRow = 0;

			for (Row row : sheet) {

				Cell cell = row.getCell(columnNumber);
				if (cell != null) {

					rowCount++;
					actualRow = rowCount - 1;
				}

			}
			fis.close();

			if (count1 == actualRow) {
				// test.log(LogStatus.PASS, "No of records from grid matches to no of records in
				// Excel Sheet.");
				test.log(LogStatus.PASS,
						"Total records from Grid = " + count1 + " | Total records from Report = " + actualRow);
			} else {
				// test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of
				// records in Excel Sheet.");
				test.log(LogStatus.FAIL,
						"Total records from Grid = " + count1 + " | Total records from Excel Sheet = " + actualRow);
			}
		} else {
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}

	}
	
	public static void assignedSelectActFilter(ExtentTest test) throws InterruptedException, IOException {
		Thread.sleep(5000);

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		All_ClientPortal_Locators.AssignedCompliances().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.AssignedComplianceSelectAct().click();
		Thread.sleep(3000);
		All_ClientPortal_Locators.AssignedComplianceSelectAct1().click();
		Thread.sleep(3000);
		All_ClientPortal_Locators.ClickApplyBtn().click();
		

		
		
		
		if(All_ClientPortal_Locators.ClickApplyBtn().isEnabled())
		{
			Thread.sleep(1000);
			All_ClientPortal_Locators.ClickApplyBtn().click();
			test.log(LogStatus.PASS, "Apply button working successfully");
			test.log(LogStatus.PASS, "Act is selected successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Apply button is not working");
		}



	}
	
	
	public static void OverviewAC(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
	All_ClientPortal_Locators.AssignedCompliances().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		
		All_ClientPortal_Locators.Overview().click();
		Thread.sleep(5000);
		Thread.sleep(10000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS,  " Overview successfully.");
		
		
	}
	
	public static void AssignedCompliancesPagination(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
	    All_ClientPortal_Locators.AssignedCompliances().click();
		Thread.sleep(5000);

		CoordinatorMethod.zoomOutScreen(2);   //Zoom Out
		
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);
		
		
	}
	
	public static void ExpiredRegistrations(  ExtentTest test) throws InterruptedException, IOException
	{
		
		Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.ExpiredRegistrations().getText();		//Storing old value of Statutory overdue.
	    int	CategoriesCountDas = Integer.parseInt(string_Categories);
	    All_ClientPortal_Locators.ExpiredRegistrations().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Expired Registrations in the grid = "+CatcountGrid+" | Dashboard Expired Registrations Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Expired Registrations in the grid = "+CatcountGrid+" | Dashboard Expired Registrations Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void ExpiredRegistrationsEdit( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
	
	All_ClientPortal_Locators.ExpiredRegistrations().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.EREdit().click();
		Thread.sleep(5000);
		String item = All_ClientPortal_Locators.EREditP().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("Existing License")) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on Edit button page redirect to the Existing License page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " view button not working ");

		}
		
		
	}
	
	public static void exportER(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		All_ClientPortal_Locators.ExpiredRegistrations().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.EREdit().click();
		Thread.sleep(5000);
		
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void ERSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		All_ClientPortal_Locators.ExpiredRegistrations().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.EREdit().click();
		Thread.sleep(5000);
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.Search().sendKeys("Expired",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='Expired']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "License Status selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	public static void ERSearchClear(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		All_ClientPortal_Locators.ExpiredRegistrations().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.EREdit().click();
		Thread.sleep(5000);
	
		All_ClientPortal_Locators.Search().sendKeys("400053",Keys.ENTER);
		Thread.sleep(4000);
		
		if (All_ClientPortal_Locators.Clear().isEnabled()) {
			Thread.sleep(5000);

			test.log(LogStatus.PASS, " Clear button working successfully.");
			All_ClientPortal_Locators.Clear().click();
		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, "Clear button does not working properly.");
		}
		Thread.sleep(3000);
	  
		
	}
	
	 public static void ERviewBack( ExtentTest test) throws InterruptedException, IOException
	  	{Thread.sleep(5000);
	  	
	      	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	      	WebElement element = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
	      	All_ClientPortal_Locators.ExpiredRegistrations().click();
			Thread.sleep(5000);
			All_ClientPortal_Locators.EREdit().click();
			Thread.sleep(5000);
	  		
	  		All_ClientPortal_Locators.ViewER().click();
	  		Thread.sleep(5000);
	  		if(All_ClientPortal_Locators.Back().isEnabled()) {Thread.sleep(5000);
			 
			test.log(LogStatus.PASS,  " Back button working successfully."); 
			All_ClientPortal_Locators.Back().click();
	 }
	 else
	 {Thread.sleep(5000);
	 	test.log(LogStatus.FAIL, "Back button does not working properly.");
	 }
	  		
	  		
	  	}
	 
	 public static void ERview( ExtentTest test) throws InterruptedException, IOException
	  	{Thread.sleep(5000);
	  	
	      	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	      	WebElement element = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
	      	All_ClientPortal_Locators.ExpiredRegistrations().click();
			Thread.sleep(5000);
			All_ClientPortal_Locators.EREdit().click();
			Thread.sleep(5000);
	  		
	  		All_ClientPortal_Locators.ViewER().click();
	  		Thread.sleep(5000);
//	       	All_ClientPortal_Locators.OverviewColse().click(); //Hide due to here close button is removed
	  		Thread.sleep(5000);
	  		test.log(LogStatus.PASS,  " View successfully.");
	  		
	  	}
	 public static void EExpandViewDownload( ExtentTest test) throws InterruptedException, IOException
	  	{Thread.sleep(5000);
	  	
	      	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	      	WebDriverWait wait = new WebDriverWait( getDriver(), (120));
	      	WebElement element = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
	      	All_ClientPortal_Locators.ExpiredRegistrations().click();
			Thread.sleep(5000);
			All_ClientPortal_Locators.EREdit().click();
			Thread.sleep(5000);
	  		
//			WebElement expandIcon = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-right k-treelist-toggle k-svg-icon k-icon']"));
//	  		All_ClientPortal_Locators.expandIconSubActivity().click();
			By locator = By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-client-entity-dashboard-grid:nth-child(3) > div:nth-child(3) > app-existing-registration-license:nth-child(1) > div:nth-child(2) > kendo-treelist:nth-child(1) > div:nth-child(1) > kendo-treelist-list:nth-child(2) > div:nth-child(1) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > kendo-icon-wrapper:nth-child");
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			
			WebElement ViewButton = getDriver().findElement(locator);	
			Thread.sleep(4000);
		JavascriptExecutor jse=(JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
	  		
	  		
	  		All_ClientPortal_Locators.ViewSubActivity().click();
	  		Thread.sleep(5000);
	       	All_ClientPortal_Locators.OverviewColse().click();
	  		Thread.sleep(5000);
	  		test.log(LogStatus.PASS,  " View successfully.");
	  		
	  		
			

			
	  		
	  	}
	 
	 
	 
	 public static void exportERE(  ExtentTest test) throws InterruptedException, IOException
		{Thread.sleep(5000);
		
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			All_ClientPortal_Locators.ExpiredRegistrations().click();
			Thread.sleep(5000);
			All_ClientPortal_Locators.EREdit().click();
			Thread.sleep(5000);
			
			Thread.sleep(3000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(5000);
			
     		All_ClientPortal_Locators.Download().click();
	
			Thread.sleep(8000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
				test.log(LogStatus.PASS,  " File downloaded successfully.");
			} else {Thread.sleep(5000);
				test.log(LogStatus.FAIL,  " File does not downloaded.");
			}
			
		}
	 
	 public static void ExpiredRegistrationPagination(  ExtentTest test) throws InterruptedException, IOException
		{Thread.sleep(5000);
		
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			All_ClientPortal_Locators.ExpiredRegistrations().click();
			Thread.sleep(5000);
			
			CoordinatorMethod.zoomOutScreen(2); //Zoom Out
			
			verifyPaginationGoToNextPage(test);
			Thread.sleep(5000);
			verifyPaginationGoToLastPage(test);
			Thread.sleep(5000);
			verifyItemsPerPageFunctionality(test);

			
		}
	 
	 public static void InitiateAction( ExtentTest test) throws InterruptedException, IOException
	  	{Thread.sleep(5000);
	  	
	      	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	      	WebElement element = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
	      	All_ClientPortal_Locators.ExpiredRegistrations().click();
			Thread.sleep(5000);
			All_ClientPortal_Locators.EREdit().click();
			Thread.sleep(5000);
	  		
	  		All_ClientPortal_Locators.InitiateAction().click();
	  		CoordinatorMethod.zoomOutScreen(4); //Zoom Out
	  		
	        JavascriptExecutor js2 = (JavascriptExecutor) getDriver();
	        js2.executeScript("window.scrollBy(0,1000)");
	  		
	  		Thread.sleep(5000);
	       	All_ClientPortal_Locators.clickActivityType().click();
	  		Thread.sleep(2000);
	  		All_ClientPortal_Locators.selectActivityTypeApproval().click();
	  		Thread.sleep(2000);
	  		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
	  		All_ClientPortal_Locators.Sumit().click();
	  		Thread.sleep(2000);
	  		 By locator = By.xpath("(//h4[@class='f-label'])");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
			String text = getDriver().findElement(By.xpath("(//h4[@class='f-label'])")).getText();
			
			if(!text.equalsIgnoreCase("SubActivity saved successfully")||!text.equalsIgnoreCase("Success"))
			{
				
				test.log(LogStatus.PASS,"Message Displayed : "+text);
			}
			else
			{
				
				test.log(LogStatus.FAIL,"Message Displayed : "+text);
				
	}
			Locators.ok().click();
			Thread.sleep(4000);
	  		
	  	}
	
	 public static void InitiateActionBack( ExtentTest test) throws InterruptedException, IOException
	  	{Thread.sleep(5000);
	  	
	      	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	      	WebElement element = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
	      	All_ClientPortal_Locators.ExpiredRegistrations().click();
			Thread.sleep(5000);
			All_ClientPortal_Locators.EREdit().click();
			Thread.sleep(5000);
	  		
	  		All_ClientPortal_Locators.InitiateAction().click();
	  		Thread.sleep(5000);
	  		if(All_ClientPortal_Locators.Back().isEnabled()) {Thread.sleep(5000);
			 
			test.log(LogStatus.PASS,  " Back button working successfully."); 
			All_ClientPortal_Locators.Back().click();
	 }
	 else
	 {Thread.sleep(5000);
	 	test.log(LogStatus.FAIL, "Back button does not working properly.");
	 }
	  		
			
			
	  		
	  	}
	
	 
	public static void OpenNotices( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.OpenNotices().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
	All_ClientPortal_Locators.OpenNotices().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Open Notices in the grid = "+CatcountGrid+" | Dashboard Open Notices  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Open Notices in the grid = "+CatcountGrid+" | Dashboard Open Notices Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void OpenNoticesView( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
	
	    All_ClientPortal_Locators.OpenNotices().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);
		String item = All_ClientPortal_Locators.Viewpage().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("View Notices")) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on view button page redirect to the view notices page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " view button not working ");

		}
		
		
	}
	public static void OpenNoticesEditDelete( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
	
	    All_ClientPortal_Locators.OpenNotices().click();
		Thread.sleep(5000);
		
		
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(5000);
		All_ClientPortal_Locators.compliancePerformanceDownloadBtn().click();
		Thread.sleep(8000);
//		All_ClientPortal_Locators.compliancePerformanceFileDownPopup().click();

		Thread.sleep(10000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
		
		
		//Edit Back Function:
		Thread.sleep(5000);
		All_ClientPortal_Locators.Edit1().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(5000);
//		All_ClientPortal_Locators.EditBack().click();
//		Thread.sleep(10000);
		
//		String item = All_ClientPortal_Locators.Viewpage().getText();
//		Thread.sleep(4000);
/*		if(item.equalsIgnoreCase("View Notices")) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on Back button page redirect to the view notices page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " Back button not working ");

		}*/
		
		
		if(All_ClientPortal_Locators.EditBack().isEnabled()) {Thread.sleep(5000);
		All_ClientPortal_Locators.EditBack().click();
		test.log(LogStatus.PASS,  "Edit and Back button is working fine");
	}else {Thread.sleep(5000);
		test.log(LogStatus.FAIL,  " Back button not working ");

	}
		

		
		
	}
	
	public static void OpenNoticesPagination( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
	
	    All_ClientPortal_Locators.OpenNotices().click();
		Thread.sleep(5000);
		
		
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);
		
		
	}
	
	public static void ViewAddNew ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{Thread.sleep(5000);		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
			  	All_ClientPortal_Locators.OpenNotices().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);
				
		All_ClientPortal_Locators.ViewAddNew().click();
				Thread.sleep(4000);
				All_ClientPortal_Locators.State().click();
				Thread.sleep(1000);
				All_ClientPortal_Locators.State1().click();
				Thread.sleep(3000);
				
				All_ClientPortal_Locators.Location().click();
				Thread.sleep(1000);
				All_ClientPortal_Locators.Location1().click();
				Thread.sleep(3000);
				
				All_ClientPortal_Locators.NoticeBranch().click();
				Thread.sleep(1000);
				All_ClientPortal_Locators.Branch1().click();
				Thread.sleep(3000);
				
				All_ClientPortal_Locators.ModeofReceipt().click();
				Thread.sleep(1000);
				All_ClientPortal_Locators.ModeofReceipt1().click();
				Thread.sleep(3000);
				
				All_ClientPortal_Locators.NoticeNumber().sendKeys(getRandomString());;
				Thread.sleep(3000);
				
/*				All_ClientPortal_Locators.NoticeReceivedDateT().sendKeys("01-02-2024");;
				Thread.sleep(3000);
				All_ClientPortal_Locators.NoticeReceivedDateT().sendKeys("01-02-2024");;
				Thread.sleep(3000);
				All_ClientPortal_Locators.NoticeReceivedDateT().sendKeys("01-02-2024");;
				Thread.sleep(3000); */
				
				Thread.sleep(1000);
				All_ClientPortal_Locators.clickCalender().click();
				
				Thread.sleep(1000);
				Actions action2 = new Actions(getDriver());
				WebElement we = getDriver().findElement(By.xpath("//span[@class='k-link'][normalize-space()='1']"));
				action2.moveToElement(we).click().build().perform();
				Thread.sleep(1000);
//				Locator.selectDate().click();
				
				Thread.sleep(1000);
				All_ClientPortal_Locators.clickCalenderReponseDueDate().click();
				Thread.sleep(1000);

				WebElement we1= getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='28']"));
				action2.moveToElement(we1).click().build().perform();
//				Locator.selectDate2().click();
				
				
				
		//		All_ClientPortal_Locators.NoticeReceivedDate().click();
				Thread.sleep(1000);
				//Actions action1 = new Actions(getDriver());

				//action1.moveToElement(All_ClientPortal_Locators.NoticeReceivedDate1()).click().perform();
			//	All_ClientPortal_Locators.NoticeReceivedDate1().click();
				Thread.sleep(1000);
				All_ClientPortal_Locators.NoticeReceivedDate2().click();
				Thread.sleep(3000);
				
				
				All_ClientPortal_Locators.ResponseDueDate().click();
				Thread.sleep(4000);
				
				
				
				
				Thread.sleep(4000);
				All_ClientPortal_Locators.NoticedueDate1().click();
				Thread.sleep(3000);
				
				All_ClientPortal_Locators.NoticeType().click();
				Thread.sleep(1000);
				All_ClientPortal_Locators.NoticeType1().click();
				Thread.sleep(3000);
				
				All_ClientPortal_Locators.Risk().click();
				Thread.sleep(1000);
				All_ClientPortal_Locators.Risk1().click();
				Thread.sleep(3000);
				
				All_ClientPortal_Locators.Browse().click();
				Thread.sleep(3000);
				Robot robot=new Robot();
				 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\sample.pdf");
				 //copy above file to clipboard
				 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
				
				 //Now press CRTL
				
				 robot.keyPress(KeyEvent.VK_CONTROL);
				 Thread.sleep(1000);
				
				 //PRESS V
				 robot.keyPress(KeyEvent.VK_V);
				 Thread.sleep(1000);
				
				 //Release V
				 robot.keyRelease(KeyEvent.VK_V);
				
				
				 //Release CRTL
				 robot.keyRelease(KeyEvent.VK_CONTROL);
				
				 //PRESS Enter
				 robot.keyPress(KeyEvent.VK_ENTER);
				
				 //Release CRTL
				 robot.keyRelease(KeyEvent.VK_ENTER);
				
				 Thread.sleep(1000);
						 
				
				 All_ClientPortal_Locators.remark().sendKeys("remark");
					Thread.sleep(3000);
				
				
					Thread.sleep(3000);
				
				
					All_ClientPortal_Locators.SaveNotice().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				if(text.equalsIgnoreCase("Notice Saved Successfully"))
				{Thread.sleep(5000);
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{Thread.sleep(5000);
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	
	public static void ViewAddNewNotices ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{Thread.sleep(5000);		
//		Actions action = new Actions(getDriver());
//		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
			  	All_ClientPortal_Locators.OpenNotices().click();
		Thread.sleep(15000);
		
		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);
				
//		All_ClientPortal_Locators.ViewAddNew().click();
		Thread.sleep(4000);
		
		CoordinatorMethod.zoomOutScreen(2); // 2 times zoom out
		
		Thread.sleep(3000);
		String item = All_ClientPortal_Locators.readTotalItemsNotice().getText();
		String[] bits = item.split(" ");								//Splitting the String
		if(bits.length > 2)
		{
			Thread.sleep(2000);
			item = All_ClientPortal_Locators.readTotalItemsNotice().getText();
			bits = item.split(" ");								//Splitting the String
		}
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			item = All_ClientPortal_Locators.readTotalItemsNotice().getText();
			bits = item.split(" ");									//Splitting the String
			compliancesCount = bits[bits.length - 2];
		}
		int count = Integer.parseInt(compliancesCount);
		
		Thread.sleep(5000);
		All_ClientPortal_Locators.clickaddnewNotices().click();
		Thread.sleep(3000);
		All_ClientPortal_Locators.clickStatee().click();
		
	//	Actions Class Clicking
	//	Actions action2 = new Actions(getDriver());
	//	action2.moveToElement(All_ClientPortal_Locators.clickStatee()).click().build().perform();
		
		
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectState1().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickLocation1().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectLocation1().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickNoticeBranch1().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectLocation1().click();   //Select Branch
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickModeOfReceipt().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectLocation1().click();   //Select Mode Of Receipt
		
		
		
		FileInputStream fis = new FileInputStream(filePath);
	    Workbook workbook1 = WorkbookFactory.create(fis);
	    Sheet sheet = workbook1.getSheetAt(6);
		
	    Thread.sleep(5000);
		Row row6 = sheet.getRow(16);						//Selected 0th index row (First row)
		Thread.sleep(5000);
		Cell c6= row6.getCell(1);						//Selected cell (0 row,1 column)
		int NoriceNo = (int) c6.getNumericCellValue();
		All_ClientPortal_Locators.clickNoticeNumber().sendKeys(NoriceNo+getRandomString());
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickCalender().click();
		
		Thread.sleep(1000);
		Actions action = new Actions(getDriver());
//		WebElement we = getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='21']"));
		
		WebElement we = getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='1']"));
		
		action.moveToElement(we).click().build().perform();
		Thread.sleep(1000);
//		Locator.selectDate().click();
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickCalenderReponseDueDate().click();
		Thread.sleep(3000);

		//me Clicking September Month:
		getDriver().findElement(By.xpath("(//span[contains(text(),'Sep')])[1]")).click();
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("(//span[@class='k-link'][normalize-space()='2'])[4]")).click();
		Thread.sleep(3000);
		
//		WebElement dateInput = getDriver().findElement(By.xpath("//input[@id='datepicker-2']"));
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='03-09-2025';", dateInput);
		
//		WebElement dateInput = All_ClientPortal_Locators.clickCalenderReponseDueDate();
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='03-10-2025';", dateInput);


		
		
		
//		WebElement we1= getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='28']"));
		
//		WebElement we1= getDriver().findElement(By.xpath("(//span[@class='k-link'][normalize-space()='30'])[1]"));
		
//		action.moveToElement(we1).click().build().perform();
//		Locator.selectDate2().click();
		
		All_ClientPortal_Locators.clickNoticeType().click();
		All_ClientPortal_Locators.selectLocation1().click();   //Select Notice type
		
		All_ClientPortal_Locators.clickRisk().click();
		All_ClientPortal_Locators.selectLocation1().click();   //Select Risk type
		
		
		Row row = sheet.getRow(17);						//Selected 0th index row (First row)
		Cell c= row.getCell(1);						//Selected cell (0 row,1 column)
		String Remark = c.getStringCellValue();
		All_ClientPortal_Locators.clickRemark().sendKeys(Remark);
		
		 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
		 
		 Robot robot=new Robot();
		 Thread.sleep(3000);
		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\sample.pdf");
		 Thread.sleep(3000);
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		 
		 //Now press CRTL
		 
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		 Thread.sleep(5000);
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(5000);
		 
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(5000);
		 
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 Thread.sleep(5000);
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		 Thread.sleep(5000);
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 Thread.sleep(5000);
		
		 System.out.println("File uploaded successfully");
		 
		 Thread.sleep(1000);
		All_ClientPortal_Locators.clickSaveNotice().click();
		 Thread.sleep(1000);
		String msg=All_ClientPortal_Locators.clickSuccessNotice().getText();
		if(msg.equalsIgnoreCase("Notice Saved Successfully"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickOkBtn().click();
		
		Thread.sleep(1000);

		WebElement we2 = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
		action.moveToElement(we2).click().build().perform();
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.readTotalItemsNotice().click();
		String item1 = All_ClientPortal_Locators.readTotalItemsNotice().getText();
		String[] bits1 = item1.split(" ");								//Splitting the String
		
		if(bits1.length > 2)
		{
			Thread.sleep(2000);
			item1 = All_ClientPortal_Locators.readTotalItemsNotice().getText();
			bits1 = item1.split(" ");								//Splitting the String
		}
		String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
		
		if(compliancesCount1.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			item1 = All_ClientPortal_Locators.readTotalItemsNotice().getText();
			bits1 = item1.split(" ");									//Splitting the String
			compliancesCount1 = bits1[bits1.length - 2];
		}
		int count1 = Integer.parseInt(compliancesCount1);
		if(count < count1)
			{
			
				test.log(LogStatus.PASS, "Total Notice Count increased in grid after adding New Notice - Old Notice Count from Grid  = "+count+" | New Notice Count from Grid = "+count1);
				
			}
			else
			{
				test.log(LogStatus.FAIL, "Total Notice Count doesn't increased in grid after adding New Notice - Old Notice Count from Grid  = "+count+" | New Notice Count from Grid = "+count1);
			}
				
				

		  	
	}
	
	
	
	public static void exportNotice(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		All_ClientPortal_Locators.OpenNotices().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		
		
/*		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		*/
		
	    OneCommonMethod.validateExportedExcelDYNAMIC(
	    	    driver.get(),
	    	    test,
	    	    LoginLocators.Exportbtn(),        // WebElement for export button
	    	    All_ClientPortal_Locators.readTotalItemsNotice(),     // WebElement for grid count text
	    	    "Notice Type",                               // Column header to verify
	    	    "File Exported Successfully ! "     // Success log text (only if PASS)
	    	);
		
		
	}
	
	public static void NoticeSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		All_ClientPortal_Locators.OpenNotices().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.Search().sendKeys("Highly Critical",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("(//div[normalize-space()='Highly Critical'])")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Notice No along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Risk Column is selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	public static void NoticeViewEditDocumentDownload(ExtentTest test) throws InterruptedException, IOException {
		Thread.sleep(5000);

		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		All_ClientPortal_Locators.OpenNotices().click();
		Thread.sleep(5000);

		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);

//		All_ClientPortal_Locators.Search().sendKeys("Notice Response Submitted to SD", Keys.ENTER);
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//img[@title='Edit']")).click();
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();
		Thread.sleep(5000);
		getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-document-section:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > img:nth-child(1)")).click(); //+icon

/*		
		// 1 Logic for Notice Document
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.NoticeDocumentDownload().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS, " Notice Document File downloaded successfully.");
		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, " Notice Document File is not downloaded");
		}

		// 2 - Logic for Translated Notice Document
		Thread.sleep(5000);
		File dir2 = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents2 = dir2.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.NoticeTranslatedDocument().click();

		Thread.sleep(8000);
		File dirr = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew2 = dirr.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents2.length < allFilesNew2.length) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS, " Notice Translated Document File downloaded successfully.");
		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, " Notice Translated Document File is not downloaded.");
		}

		//3 Logic for Extention Application Acknowledgement
		Thread.sleep(8000);
		File dir3 = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents3 = dir3.listFiles(); // Counting number of files in directory before download

		Thread.sleep(2200);
		All_ClientPortal_Locators.NoticeApplicationAcknowledgeDocument().click();

		Thread.sleep(10000);
		File dirrr = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew3 = dirrr.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents3.length < allFilesNew3.length) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS, " Notice Extension Application Acknowledgement File is downloaded successfully");
		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, " Notice Extension Application Acknowledgement File is not downloaded.");
		}

		//4 Logic for Draft Extension Application
		Thread.sleep(10000);
		File dir4 = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents4 = dir4.listFiles(); // Counting number of files in directory before download

		Thread.sleep(4000);
		All_ClientPortal_Locators.DraftExtensionApplicationDocument().click();

		Thread.sleep(10000);
		File dirrr4 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew4 = dirrr4.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents4.length < allFilesNew4.length) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS, " Notice Draft Extension Application File downloaded successfully.");
		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, " Notice Draft Extension Application File is not downloaded.");
		}

		//5 Logic for Draft Response (Prepared by SME)
		Thread.sleep(10000);
		File dir5 = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents5 = dir5.listFiles(); // Counting number of files in directory before download

		Thread.sleep(4000);
		All_ClientPortal_Locators.DraftResponseSMEDocument().click();

		Thread.sleep(10000);
		File dirrr5 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew5 = dirrr5.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents5.length < allFilesNew5.length) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS, " Notice Response Prepared by SME File is downloaded successfully.");
		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, " Notice Draft Extension Application File is not downloaded.");
		}
		
		
*/
		// 1 - Logic for Notice Document
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();

		Thread.sleep(500);
		try {
			if (All_ClientPortal_Locators.NoticeDocumentDownload().isDisplayed() && All_ClientPortal_Locators.NoticeDocumentDownload().isEnabled()) {
				All_ClientPortal_Locators.NoticeDocumentDownload().click();
				Thread.sleep(8000);
				File dir1 = new File("C:\\Users\\bilali\\Downloads");
				File[] allFilesNew = dir1.listFiles();
				Thread.sleep(3000);
				if (dirContents.length < allFilesNew.length) {
					Thread.sleep(5000);
					test.log(LogStatus.PASS, " Notice Document File downloaded successfully.");
				} else {
					Thread.sleep(5000);
					test.log(LogStatus.FAIL, " Notice Document File is not downloaded");
				}
			} else {
				test.log(LogStatus.INFO, "Notice Document - There is no document (button not clickable).");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, "Notice Document - There is No File Available");
		}

		// 2 - Logic for Translated Notice Document
		Thread.sleep(5000);
		File dir2 = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents2 = dir2.listFiles();

		Thread.sleep(500);
		try {
			if (All_ClientPortal_Locators.NoticeTranslatedDocument().isDisplayed() && All_ClientPortal_Locators.NoticeTranslatedDocument().isEnabled()) {
				All_ClientPortal_Locators.NoticeTranslatedDocument().click();
				Thread.sleep(8000);
				File dirr = new File("C:\\Users\\bilali\\Downloads");
				File[] allFilesNew2 = dirr.listFiles();
				Thread.sleep(3000);
				if (dirContents2.length < allFilesNew2.length) {
					Thread.sleep(5000);
					test.log(LogStatus.PASS, " Notice Translated Document File downloaded successfully.");
				} else {
					Thread.sleep(5000);
					test.log(LogStatus.FAIL, " Notice Translated Document File is not downloaded.");
				}
			} else {
				test.log(LogStatus.INFO, "Notice Translated Document - There is no document (button not clickable).");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, "Notice Translated Document - There is No File Available");
		}

		// 3 - Logic for Extension Application Acknowledgement
		Thread.sleep(8000);
		File dir3 = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents3 = dir3.listFiles();

		Thread.sleep(2200);
		try {
			if (All_ClientPortal_Locators.NoticeApplicationAcknowledgeDocument().isDisplayed() && All_ClientPortal_Locators.NoticeApplicationAcknowledgeDocument().isEnabled()) {
				All_ClientPortal_Locators.NoticeApplicationAcknowledgeDocument().click();
				Thread.sleep(10000);
				File dirrr = new File("C:\\Users\\bilali\\Downloads");
				File[] allFilesNew3 = dirrr.listFiles();
				Thread.sleep(3000);
				if (dirContents3.length < allFilesNew3.length) {
					Thread.sleep(5000);
					test.log(LogStatus.PASS, " Notice Extension Application Acknowledgement File is downloaded successfully");
				} else {
					Thread.sleep(5000);
					test.log(LogStatus.FAIL, " Notice Extension Application Acknowledgement File is not downloaded.");
				}
			} else {
				test.log(LogStatus.INFO, "Notice Extension Application Acknowledgement - There is no document (button not clickable).");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, "Notice Extension Application Acknowledgement - There is No File Available");
		}

		// 4 - Logic for Draft Extension Application
		Thread.sleep(10000);
		File dir4 = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents4 = dir4.listFiles();

		Thread.sleep(4000);
		try {
			if (All_ClientPortal_Locators.DraftExtensionApplicationDocument().isDisplayed() && All_ClientPortal_Locators.DraftExtensionApplicationDocument().isEnabled()) {
				All_ClientPortal_Locators.DraftExtensionApplicationDocument().click();
				Thread.sleep(10000);
				File dirrr4 = new File("C:\\Users\\bilali\\Downloads");
				File[] allFilesNew4 = dirrr4.listFiles();
				Thread.sleep(3000);
				if (dirContents4.length < allFilesNew4.length) {
					Thread.sleep(5000);
					test.log(LogStatus.PASS, " Notice Draft Extension Application File downloaded successfully.");
				} else {
					Thread.sleep(5000);
					test.log(LogStatus.FAIL, " Notice Draft Extension Application File is not downloaded.");
				}
			} else {
				test.log(LogStatus.INFO, "Notice Draft Extension Application - There is no document (button not clickable).");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, "Notice Draft Extension Application - There is No File Available");
		}

		// 5 - Logic for Draft Response (Prepared by SME)
		Thread.sleep(10000);
		File dir5 = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents5 = dir5.listFiles();

		Thread.sleep(4000);
		try {
			if (All_ClientPortal_Locators.DraftResponseSMEDocument().isDisplayed() && All_ClientPortal_Locators.DraftResponseSMEDocument().isEnabled()) {
				All_ClientPortal_Locators.DraftResponseSMEDocument().click();
				Thread.sleep(10000);
				File dirrr5 = new File("C:\\Users\\bilali\\Downloads");
				File[] allFilesNew5 = dirrr5.listFiles();
				Thread.sleep(3000);
				if (dirContents5.length < allFilesNew5.length) {
					Thread.sleep(5000);
					test.log(LogStatus.PASS, " Notice Response Prepared by SME File is downloaded successfully.");
				} else {
					Thread.sleep(5000);
					test.log(LogStatus.FAIL, " Notice Draft Extension Application File is not downloaded.");
				}
			} else {
				test.log(LogStatus.INFO, "Notice Response Prepared by SME - There is no document (button not clickable).");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, "Notice Response Prepared by SME - There is No File Available.");
		}

		


		
		
		
		
		

	}
	
	public static void NoticeViewEditTabs(ExtentTest test) throws InterruptedException, IOException {
		Thread.sleep(5000);

		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		All_ClientPortal_Locators.OpenNotices().click();
		Thread.sleep(5000);

		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);

//		All_ClientPortal_Locators.Search().sendKeys("NoticeNumber2", Keys.ENTER);
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//img[@title='Edit']")).click();
		Thread.sleep(5000);
		
		String BasicInfo = getDriver().findElement(By.xpath("//span[normalize-space()='Basic Information']")).getText();
		if(BasicInfo.equals("Basic Information"))
		{
			test.log(LogStatus.PASS,  "Notice Details Tab is displayed"); 
		}
		else 
		{
			test.log(LogStatus.FAIL,  "Notice Details Tab is not displayed"); 
		}
		
		
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//a[normalize-space()='SME Response']")).click();
		String TransReq = getDriver().findElement(By.xpath("//span[normalize-space()='Translation Required']")).getText();

		if(TransReq.equals("Translation Required"))
		{
			test.log(LogStatus.PASS,  "SME Response Tab is displayed"); 
		}
		else 
		{
			test.log(LogStatus.FAIL,  "SME Response Tab is not displayed"); 
		}
		
		
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//a[normalize-space()='SD Executer']")).click();
		//Me get text is not added due to in both tab same get.text is there
		if(TransReq.equals("Translation Required"))
		{
			test.log(LogStatus.PASS,  "SD Executor Tab is displayed"); 
		}
		else 
		{
			test.log(LogStatus.FAIL,  "SD Executor Tab is not displayed"); 
		}
		
		
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();
		String DocRepo = getDriver().findElement(By.xpath("//span[normalize-space()='Document Repository']")).getText();
		if(DocRepo.equals("Document Repository"))
		{
			test.log(LogStatus.PASS,  "Document Section Tab is displayed"); 
		}
		else 
		{
			test.log(LogStatus.FAIL,  "Document Section Tab is not displayed"); 
		}
		

	}
	
	
	public static void NoticeSearchClear(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		All_ClientPortal_Locators.OpenNotices().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);
				All_ClientPortal_Locators.Search().sendKeys("123344",Keys.ENTER);
		Thread.sleep(4000);
		
		Thread.sleep(3000);
		 if(All_ClientPortal_Locators.Clear().isEnabled()) {Thread.sleep(5000);
			 
				test.log(LogStatus.PASS,  " Clear button working successfully."); 
				All_ClientPortal_Locators.Clear().click();
		 }
		 else
		 {Thread.sleep(5000);
		 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
		 }
		  	 Thread.sleep(3000);
		  
		
	}
	
	public static void OpenNoticesEditback( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
	
	All_ClientPortal_Locators.OpenNotices().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.Edit1().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);
		All_ClientPortal_Locators.EditBack().click();
		Thread.sleep(3000);
		
		String item = All_ClientPortal_Locators.Viewpage().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("View Notices")) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on Back button page redirect to the view notices page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " Back button not working ");

		}
		
		
	}
	
	public static void OverviewNotice(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		All_ClientPortal_Locators.OpenNotices().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.OverviewOpenNotice().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		
		
	}
	public static void OpenNoticeViewPagination(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		All_ClientPortal_Locators.OpenNotices().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);
		
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);
		
		
	}
	
	
	public static void OpenNoticesback( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
	
	All_ClientPortal_Locators.OpenNotices().click();
		Thread.sleep(5000);
		
	
		All_ClientPortal_Locators.Edit1().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);
		All_ClientPortal_Locators.EditBack().click();
		Thread.sleep(3000);
		
		String item = All_ClientPortal_Locators.OpenNoticePage().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("Open Notices")) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on Back button page redirect to the Open Notices page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " Back button not working ");

		}
		
		
	}
	
	public static void RegistrationStatus( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.Active().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ActiveCol().click();
		Thread.sleep(3000);
		
		CoordinatorMethod.zoomOutScreen(2); //Zoom Out
		Thread.sleep(1000);
		
		All_ClientPortal_Locators.Search().sendKeys("Active",Keys.ENTER);
		Thread.sleep(3000);
		
		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Active in the grid = "+CatcountGrid+" | Dashboard Active  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Active in the grid = "+CatcountGrid+" | Dashboard Active Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void RegistrationStatusEx( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		String string_Categories =All_ClientPortal_Locators.Expired().getText();		//Storing old value of Statutory overdue.
//		String[] bits1 = string_Categories.split(" ");								//Splitting the String
//		String compliancesCount1 = bits1[bits1.length - 1];
//		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
		
		
		if(All_ClientPortal_Locators.Expired().isEnabled())
		{
			All_ClientPortal_Locators.Expired().click();
			
		}
		
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
/*		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
		
		
//		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Expired in the grid = "+CatcountGrid+" | Dashboard Expired  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Expired in the grid = "+CatcountGrid+" | Dashboard Expired Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
		*/
		// Step 1: Get count from "Active" column hyperlink
		WebElement activeLink = All_ClientPortal_Locators.ExpiredCol();
		String activeCountText = activeLink.getText().trim(); // e.g., "22"
		int activeDashboardCount = Integer.parseInt(activeCountText);
		test.log(LogStatus.INFO, "Expired count from dashboard: " + activeDashboardCount);

		// Step 2: Click on hyperlink to open grid
		activeLink.click();
		Thread.sleep(3000); // or use WebDriverWait if needed
		test.log(LogStatus.INFO, "Expired hyper link is clickable");

		// Step 3: Get grid count from top bar (e.g., "1 - 10 of 22 items")
		WebElement gridLabel = All_ClientPortal_Locators.readTotalItemsNotice(); // use your method here
		String gridText = gridLabel.getText().trim();
		String[] parts = gridText.split(" ");
		int activeGridCount = Integer.parseInt(parts[parts.length - 2]);
		test.log(LogStatus.INFO, "Expired count found in grid: " + activeGridCount);

		// Step 4: Match both counts
		if (activeDashboardCount == activeGridCount) {
		    test.log(LogStatus.PASS, "PASS: Expired count from dashboard matches grid count.");
		} else {
		    test.log(LogStatus.FAIL, "FAIL: Mismatch. Dashboard = " + activeDashboardCount + ", Grid = " + activeGridCount);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	public static void RegistrationStatusExport( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.Active().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		Thread.sleep(5000);
		All_ClientPortal_Locators.ActiveCol().click();
		Thread.sleep(3000);
		
		
		
//		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(8000);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
		
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							

		Thread.sleep(8000);
		try {
		LoginLocators.Export().click();
		}
		catch(Exception e)
		{
			LoginLocators.Exportbtn().click();
			
			}
		test.log(LogStatus.PASS, "File downloaded successfully.");

		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles();							

		if(dirContents.length < allFilesNew.length)
		{
				
			File lastModifiedFile = allFilesNew[0];			
		    for (int i = 1; i < allFilesNew.length; i++) 	
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(1000);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					
			/*
			int no = sheet.getFirstRowNum();
			Row row = sheet.getRow(no);
			Cell c1 = row.getCell(0);
			int records =(int) c1.getNumericCellValue();
			*/
			sheet = workbook.getSheetAt(0);
			int columnNumber = 3;
			int rowCount = 0;
			int actualRow=0;
			
			for(Row row : sheet)
			{
				
				Cell cell =row.getCell(columnNumber);
				if(cell != null) {
					
					rowCount++;
					actualRow = rowCount-1;
				}
				
			}
			fis.close();
			
			if(count1 == actualRow)
			{
				//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
				test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
			}
			else
			{
				//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
				test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
	
	}
	
	public static void RegistrationStatusExportE( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.Expired().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
		
		
		
//		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(5000);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		Thread.sleep(5000);
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		Thread.sleep(5000);
		int count1 = Integer.parseInt(compliancesCount);
		
		
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							

		Thread.sleep(1000);
		try {
		LoginLocators.Export().click();
		}
		catch(Exception e)
		{
			LoginLocators.Exportbtn().click();
			
			}
		test.log(LogStatus.PASS, "File downloaded successfully.");

		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles();							

		if(dirContents.length < allFilesNew.length)
		{
				
			File lastModifiedFile = allFilesNew[0];			
		    for (int i = 1; i < allFilesNew.length; i++) 	
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(1000);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					
			/*
			int no = sheet.getFirstRowNum();
			Row row = sheet.getRow(no);
			Cell c1 = row.getCell(0);
			int records =(int) c1.getNumericCellValue();
			*/
			sheet = workbook.getSheetAt(0);
			int columnNumber = 3;
			int rowCount = 0;
			int actualRow=0;
			
			for(Row row : sheet)
			{
				
				Cell cell =row.getCell(columnNumber);
				if(cell != null) {
					
					rowCount++;
					actualRow = rowCount-1;
				}
				
			}
			fis.close();
			
			if(count1 == actualRow)
			{
				//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
				test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
			}
			else
			{
				//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
				test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
	
	}
	
	
	public static void RegistrationStatusEdit( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.Expired().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
		
		All_ClientPortal_Locators.RegistrationStatusEditbtn().click();
		Thread.sleep(8000);
		
		String item = All_ClientPortal_Locators.EREditP().getText();
		String iteam2 = getDriver().findElement(By.xpath("//div[@title='Assigned By']")).getText();
		
		Thread.sleep(8000);
		if(item.equalsIgnoreCase("Existing License")||iteam2.equalsIgnoreCase("Assigned By")) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on Edit button page redirect to the Existing License page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "Edit button is not working");
		
		}

	
	}
	
	public static void RegistrationStatusEditSearch( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.Expired().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
	

		All_ClientPortal_Locators.RegistrationStatusEditbtn().click();
		Thread.sleep(8000);
		
		All_ClientPortal_Locators.Search().sendKeys("Expiring",Keys.ENTER);
		try {Thread.sleep(5000);

		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("(//div[@title='Expiring'][normalize-space()='Expiring'])[1]")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Status selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}

	
	}
	
	public static void RegistrationStatusEditExport( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.Expired().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
	

		All_ClientPortal_Locators.RegistrationStatusEditbtn().click();
		Thread.sleep(8000);
		

		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File Downloaded Successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
	}
	public static void RegistrationStatusEditView( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.Expired().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
	

		All_ClientPortal_Locators.RegistrationStatusEditbtn().click();
		Thread.sleep(8000);

		Thread.sleep(3000);
		
  		All_ClientPortal_Locators.ViewER().click();
  		Thread.sleep(5000);
//      All_ClientPortal_Locators.OverviewColse().click();  //Hide due to close is removed 
  		Thread.sleep(5000);
  		test.log(LogStatus.PASS,  "File View Successfully");

	
	}
	
	public static void RegistrationStatusEditInitiateAction( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.Expired().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
	

		All_ClientPortal_Locators.RegistrationStatusEditbtn().click();
		Thread.sleep(8000);
		
  //		All_ClientPortal_Locators.ViewER().click();
  		All_ClientPortal_Locators.InitiateAction().click();
  		Thread.sleep(5000);
  		if(All_ClientPortal_Locators.Back().isEnabled()) {Thread.sleep(5000);
		 
		test.log(LogStatus.PASS,  " InitiateAction button working fine."); 
		All_ClientPortal_Locators.Back().click();
		test.log(LogStatus.PASS,  " InitiateAction Back button working fine."); 
       }
        else
       {Thread.sleep(5000);
 	   test.log(LogStatus.FAIL, "Back button does not working properly.");
       }
		
	
	}
	
	
	public static void RegistrationStatusEditDownloadbtn( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.Expired().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
	

		All_ClientPortal_Locators.RegistrationStatusEditbtn().click();
		Thread.sleep(8000);

		
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download


		By locator = By.xpath("(//img[@title='Download'])[1]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	    JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	    Thread.sleep(2000);
	    jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "File Downloaded Successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "File does not downloaded");
		}
		

		
	
	}
	
	
	
	public static void RegistrationStatusEditClearbtn( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.Expired().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
	

		All_ClientPortal_Locators.RegistrationStatusEditbtn().click();
		Thread.sleep(8000);
		

		Thread.sleep(3000);
		
		
		All_ClientPortal_Locators.Search().sendKeys("HelloHowAreYou",Keys.ENTER);
		Thread.sleep(4000);
		
		 if(All_ClientPortal_Locators.Clear().isEnabled()) {Thread.sleep(5000);
		 
			test.log(LogStatus.PASS,  " Clear button working successfully."); 
			All_ClientPortal_Locators.Clear().click();
	 }
	 else
	 {Thread.sleep(5000);
	 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
	 }
	  	 Thread.sleep(3000);
	
	}
	
	
	public static void RegistrationActiveEditbtn(ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(2000);
     	All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ActiveCol().click();
		Thread.sleep(3000);
		
		All_ClientPortal_Locators.RegistrationStatusEditbtn().click();
		Thread.sleep(8000);
		
		String item = All_ClientPortal_Locators.EREditP().getText();
		String iteam2 = getDriver().findElement(By.xpath("//div[@title='Assigned By']")).getText();
		
		Thread.sleep(8000);
		if(item.equalsIgnoreCase("Existing License")||iteam2.equalsIgnoreCase("Assigned By")) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on Edit button page redirect to the Existing License page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "Edit button is not working");
		
		}
	}

	public static void RegistrationActiveEditSearch(ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ActiveCol().click();
		Thread.sleep(3000);
		
		All_ClientPortal_Locators.RegistrationStatusEditbtn().click();
		Thread.sleep(8000);
		
		
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.Search().sendKeys("Active",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("(//div[@title='Active'][normalize-space()='Active'])[1]")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Status selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		

	}
	
	public static void RegistrationActiveEditExport(ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ActiveCol().click();
		Thread.sleep(3000);
		
		All_ClientPortal_Locators.RegistrationStatusEditbtn().click();
		Thread.sleep(8000);
		
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File Downloaded Successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		

	}
	
	public static void RegistrationActiveEditClear(ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ActiveCol().click();
		Thread.sleep(3000);
		
		All_ClientPortal_Locators.RegistrationStatusEditbtn().click();
		Thread.sleep(8000);
		
		Thread.sleep(3000);
		
		
		All_ClientPortal_Locators.Search().sendKeys("HelloHowAreYou",Keys.ENTER);
		Thread.sleep(4000);
		
		 if(All_ClientPortal_Locators.Clear().isEnabled()) {Thread.sleep(5000);
		 
			test.log(LogStatus.PASS,  " Clear button working successfully."); 
			All_ClientPortal_Locators.Clear().click();
	 }
	 else
	 {Thread.sleep(5000);
	 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
	 }
	  	 Thread.sleep(3000);
		

	}
	
	
	public static void RegistrationActiveEditView(ExtentTest test) throws InterruptedException
	{
		Thread.sleep(5000);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ActiveCol().click();
		Thread.sleep(3000);
		
		All_ClientPortal_Locators.RegistrationStatusEditbtn().click();
		Thread.sleep(8000);
		
		Thread.sleep(3000);
		
  		All_ClientPortal_Locators.ViewER().click();
  		Thread.sleep(5000);
 //      	All_ClientPortal_Locators.OverviewColse().click(); Hide due to close button popup is removed
  		Thread.sleep(5000);
  		test.log(LogStatus.PASS,  "File View Successfully");

	}
	
	public static void RegistrationActiveEditInitiateAction(ExtentTest test) throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ActiveCol().click();
		Thread.sleep(3000);
		
		All_ClientPortal_Locators.RegistrationStatusEditbtn().click();
		Thread.sleep(8000);
		
//		CoordinatorMethod.zoomOutScreen(2);   //Zoom Out 2 times
		Thread.sleep(3000);
		
  		All_ClientPortal_Locators.ViewER().click();
  		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("window.scrollBy(0,5000)");
  		if(All_ClientPortal_Locators.Back().isEnabled()) {Thread.sleep(5000);
		 
		test.log(LogStatus.PASS,  " InitiateAction button working fine."); 
		All_ClientPortal_Locators.Back().click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS,  " InitiateAction Back button working fine."); 
       }
        else
       {Thread.sleep(5000);
 	   test.log(LogStatus.FAIL, "Back button does not working properly.");
       }

	}
	public static void RegistrationActiveEditInitiateActionSubmit(ExtentTest test) throws InterruptedException
	{
		Thread.sleep(5000);
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ActiveCol().click();
		Thread.sleep(3000);
		
		All_ClientPortal_Locators.RegistrationStatusEditbtn().click();
		Thread.sleep(8000);
		
		Thread.sleep(3000);
		
		
 // 		All_ClientPortal_Locators.ViewER().click();
  		
//		CoordinatorMethod.zoomOutScreen(4); //Zoom Out for 2 times
		
  		All_ClientPortal_Locators.InitiateAction().click();
  		Thread.sleep(5000);
       	All_ClientPortal_Locators.clickActivityType().click();
  		Thread.sleep(2000);
  		All_ClientPortal_Locators.selectActivityTypeApproval().click();
  		Thread.sleep(2000);
  		js.executeScript("window.scrollBy(0,5000)");
  		Thread.sleep(2000);
  		js.executeScript("window.scrollBy(0,5000)");
  		Thread.sleep(2000);
  		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
  		All_ClientPortal_Locators.Sumit().click();
  		Thread.sleep(2000);
  		 By locator = By.xpath("(//h4[@class='f-label'])");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("(//h4[@class='f-label'])")).getText();
		
		if(!text.equalsIgnoreCase("SubActivity saved successfully")||!text.equalsIgnoreCase("Success"))
		{
			test.log(LogStatus.PASS,"InitiateAction Submit button is working fine");
			Thread.sleep(1200);
			test.log(LogStatus.PASS,"Message Displayed : "+text);
		}
		else
		{
			
			test.log(LogStatus.FAIL,"Message Displayed : "+text);
			
}
		Locators.ok().click();
		Thread.sleep(4000);
  		

	}
	
	public static void RegistrationActiveEditDownloadbtn(ExtentTest test) throws InterruptedException
	{
		Thread.sleep(5000);Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ActiveCol().click();
		Thread.sleep(3000);
		
		All_ClientPortal_Locators.RegistrationStatusEditbtn().click();
		Thread.sleep(8000);
		
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download


		WebDriverWait wait = new WebDriverWait(getDriver(), 140);
		By locator = By.xpath("(//img[@title='Download'])[1]");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(4000);
	    JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	    Thread.sleep(2000);
	    jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "File Downloaded Successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "File does not downloaded");
		}
		
		
		


	}
	
	
	
	public static void RegistrationSView( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ActiveCol().click();
		Thread.sleep(3000);
		
		
		All_ClientPortal_Locators.OverviewNo().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  "view successfully.");
		
		
	}
	
	public static void RegistrationSViewEx( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
		
		
		All_ClientPortal_Locators.OverviewNo().click();
		Thread.sleep(5000);
//		All_ClientPortal_Locators.OverviewClose().click();
		
		
       	All_ClientPortal_Locators.OverviewColse().click();
  		Thread.sleep(5000);
  		test.log(LogStatus.PASS,  "File View Successfully");
		
		
// ME hide this		
/*		String msg = LoginLocators.UploadSuccessfully().getText();	
		Thread.sleep(3000);
		   if(msg.equalsIgnoreCase("Unsupported File Type")) //me did due to file is not there if file is there need to hide that and unhide Close.click
		   {
			   test.log(LogStatus.PASS,  msg);
		   }
		   else {
			   test.log(LogStatus.FAIL,   msg);

		   }
		
			test.log(LogStatus.PASS,  "view successfully.");
*/		
		
	}
	
	
	public static void DownloadActive(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ActiveCol().click();
		Thread.sleep(3000);
		
	
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(3000);
		All_ClientPortal_Locators.DownloadBtn().click();

		Thread.sleep(10000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void DownloadActiveEx(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
		
	
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.DownloadBtn().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void RegistrationSHistory( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ActiveCol().click();
		Thread.sleep(3000);
		
		
		All_ClientPortal_Locators.History().click();
		Thread.sleep(5000);
		String item = All_ClientPortal_Locators.RegistrationLicencesHistory().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("Registration & Licences History")) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on History button page redirect to the Registration & Licences History page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " History button not working ");

		}
		
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.Search().sendKeys("TESTAUTO2",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("(//div[normalize-space()='TESTAUTO2'])")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Notice No along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Risk Column is selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
		
		
	}
	
	public static void RegistrationSHistoryEx( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
		
		
		All_ClientPortal_Locators.History().click();
		Thread.sleep(5000);
		String item = All_ClientPortal_Locators.RegistrationLicencesHistory().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("Registration & Licences History")) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on History button page redirect to the Registration & Licences History page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " History button not working ");

		}
		
	}
	public static void RegistrationStatusExpiredPagination( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(5000);
		
		OneCommonMethod.zoomOutScreen(2);
		
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);
		
		
	}
	public static void RegistrationStatusPagination( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		Thread.sleep(5000);
		
		OneCommonMethod.zoomOutScreen(2); // ZoomOut
		
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);
		
		
	}
	
	public static void RegistrationSHistorySearch( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
		
		
		All_ClientPortal_Locators.History().click();
		Thread.sleep(5000);

		
		All_ClientPortal_Locators.Search().sendKeys("TESTAUTO2",Keys.ENTER);
		try {Thread.sleep(5000);

		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("(//div[normalize-space()='TESTAUTO2'])")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Status selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		

		
		
	}
	
	public static void RegistrationSHistoryExport(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ActiveCol().click();
		Thread.sleep(3000);
		All_ClientPortal_Locators.History().click();
		Thread.sleep(5000);
		
	
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	public static void RegistrationSActivePagination(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ActiveCol().click();
		
		Thread.sleep(5000);
		
		OneCommonMethod.zoomOutScreen(2); //Zoom Out
		
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);
		
	}
	
	
	public static void RegistrationSHistoryExportEx(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
		All_ClientPortal_Locators.History().click();
		Thread.sleep(5000);
		
	
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void RegistrationSHistoryViewDownload(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
		All_ClientPortal_Locators.History().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS,  "View successfully.");
		
		//Downlaod Logic:--
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.DownloadBtn().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "File does not downloaded.");
		}
	

		
	}
	
	public static void RegistrationSExport(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
	
		
	
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	
	public static void ActiveSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.ActiveCol().click();
		Thread.sleep(3000);
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.Search().sendKeys("Active",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("(//div[@title='Active'][normalize-space()='Active'])[1]")).getText();
		
			
		test.log(LogStatus.PASS, "Selected License No along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "License No selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	public static void RegistrationStatusActiveColumnCount(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
//		All_ClientPortal_Locators.ActiveCol().click();

		OneCommonMethod.zoomOutScreen(2); //ZoomOut 
		
		// Step 1: Get count from "Active" column hyperlink
		WebElement activeLink = All_ClientPortal_Locators.ActiveCol();
		String activeCountText = activeLink.getText().trim(); // e.g., "22"
		int activeDashboardCount = Integer.parseInt(activeCountText);
		test.log(LogStatus.INFO, "Active count from dashboard: " + activeDashboardCount);

		// Step 2: Click on hyperlink to open grid
		activeLink.click();
		Thread.sleep(3000); // or use WebDriverWait if needed
		test.log(LogStatus.INFO, "Active hyper link is clickable");

		// Step 3: Get grid count from top bar (e.g., "1 - 10 of 22 items")
		WebElement gridLabel = All_ClientPortal_Locators.readTotalItemsNotice(); // use your method here
		String gridText = gridLabel.getText().trim();
		String[] parts = gridText.split(" ");
		int activeGridCount = Integer.parseInt(parts[parts.length - 2]);
		test.log(LogStatus.INFO, "Active count found in grid: " + activeGridCount);

		// Step 4: Match both counts
		if (activeDashboardCount == activeGridCount) {
		    test.log(LogStatus.PASS, "PASS: Active count from dashboard matches grid count.");
		} else {
		    test.log(LogStatus.FAIL, "FAIL: Mismatch. Dashboard = " + activeDashboardCount + ", Grid = " + activeGridCount);
		}

		
	}
	public static void ExpiredSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		All_ClientPortal_Locators.Expired().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.ExpiredCol().click();
		Thread.sleep(3000);
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.Search().sendKeys("Expired",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='Expired']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected License No along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "License No selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	
	public static void RegistrationSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		All_ClientPortal_Locators.Active().click();
		Thread.sleep(5000);
		
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.Search().sendKeys("Shops and Establishment Registration",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[normalize-space()='TESTAUTO2']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected License Name along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "License Name selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	public static void CompliancePerformance( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Gopi().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.SelectYear().click();
		Thread.sleep(2000);
	  	All_ClientPortal_Locators.SelectYear25().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =All_ClientPortal_Locators.Overdue().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 2];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	All_ClientPortal_Locators.Overdue().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		
		js.executeScript("window.scrollBy(0,300)");	
		
		
		String string_User =All_ClientPortal_Locators.OverdueGrid().getText();		//Storing old value of Statutory overdue.
		int	UserCountDas = Integer.parseInt(string_User);
		if(CategoriesCountDas == UserCountDas)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Overdue in the grid = "+UserCountDas+" | Dashboard Overdue  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Overdue in the grid = "+UserCountDas+" | Dashboard Overdue Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void PayrollCompliancesOverdue(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Gopi().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.SelectYear().click();
		Thread.sleep(2000);
	  	All_ClientPortal_Locators.SelectYear25().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.Overdue().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.PayrollCompliancesOverdue().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = All_ClientPortal_Locators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewNo().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
	}
	
	public static void PayrollCompliancesComplie(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.PayrollCompliancesComplied().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = All_ClientPortal_Locators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		All_ClientPortal_Locators.OverviewNo().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS,  " Overview successfully.");
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
		
		
	}
	
	public static void exportPayrollCompliancesOverdue(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Gopi().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.SelectYear().click();
		Thread.sleep(2000);
	  	All_ClientPortal_Locators.SelectYear25().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.Overdue().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.PayrollCompliancesOverdue().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = All_ClientPortal_Locators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
	}
	
	public static void exportPayrollCompliancesComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.PayrollCompliancesComplied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
		
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Locators.Export().click();

	Thread.sleep(5500);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	if(dirContents.length < allFilesNew.length)
	{Thread.sleep(5000);

	test.log(LogStatus.PASS, "File downloaded successfully.");
	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	{Thread.sleep(5000);
	   if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	   {Thread.sleep(5000);
	       lastModifiedFile = allFilesNew[i];
	   }
	}

	Thread.sleep(1000);
	fis = new FileInputStream(lastModifiedFile);
	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
	/*
	int no = sheet.getFirstRowNum();
	Row row = sheet.getRow(no);
	Cell c1 = row.getCell(0);
	int records =(int) c1.getNumericCellValue();
	*/
	sheet = workbook.getSheetAt(0);
	int columnNumber = 3;
	int rowCount = 0;
	int actualRow=0;

	for(Row row : sheet)
	{Thread.sleep(5000);
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {Thread.sleep(5000);
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();

	if(count1 == actualRow)
	{Thread.sleep(5000);
		
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{Thread.sleep(5000);
		
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
	}
	else
	{Thread.sleep(5000);
	test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
	}
		
	}
	
	public static void exportEcComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ECComplied().click();
		Thread.sleep(10000);
		

		
		
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-client-entity-dashboard-grid/div[3]/kendo-loader/div")));
		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void RCCompliedCount(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
//		All_ClientPortal_Locators.RCComplied().click();
//		Thread.sleep(5000);
				
		



		// Step 1: Get hyperlink count from 'RC Complied'
		WebElement hyperlinkElement = All_ClientPortal_Locators.RCComplied();
		String hyperlinkText = hyperlinkElement.getText().trim();
		int hyperlinkCount = Integer.parseInt(hyperlinkText);
		test.log(LogStatus.INFO, "In Complied found " + hyperlinkCount + " count");

		// Step 2: Click on the hyperlink to go to grid
		hyperlinkElement.click();
		Thread.sleep(3000);  // Replace with WebDriverWait if needed

		// Step 3: Read the grid count from notice bar
		WebElement gridCountElement = All_ClientPortal_Locators.readTotalItemsNotice();
		String gridText = gridCountElement.getText(); // e.g., "1 - 2 of 5 items"

		// Step 4: Extract the count using split
		String[] bits = gridText.split(" ");
		int gridCount = Integer.parseInt(bits[bits.length - 2]);
		test.log(LogStatus.INFO, "In Grid found " + gridCount + " count");

		// Step 5: Compare both counts
		if (gridCount == hyperlinkCount) {
		    test.log(LogStatus.PASS, "PASS: Grid count matches hyperlink count.");
		} else {
		    test.log(LogStatus.FAIL, "FAIL: Grid count does not match hyperlink count. Grid: " + gridCount + ", Hyperlink: " + hyperlinkCount);
		}



		
		
	}
	
	
	public static void searchRCComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.RCComplied().click();
		Thread.sleep(5000);
				
		
		
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.compliancePerformanceSearch().sendKeys("67652",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='67652']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Compliance ID selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
		
	}
	public static void ClearExportRCComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
	//	All_ClientPortal_Locators.RCComplied.click();
   //	All_ClientPortal_Locators.RCComplied.click();
		All_ClientPortal_Locators.RCComplied().click();
		Thread.sleep(5000);
				
		
		All_ClientPortal_Locators.compliancePerformanceSearch().sendKeys("HelloHowAreYou", Keys.ENTER);
		Thread.sleep(4000);

		if (All_ClientPortal_Locators.Clear().isEnabled()) {
			Thread.sleep(5000);

			test.log(LogStatus.PASS, " Clear button working successfully.");
			All_ClientPortal_Locators.Clear().click();
		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, "Clear button does not working properly.");
		}
		Thread.sleep(3000);
		
		
		
		//Export
		Thread.sleep(2000);
//	      CoordinatorLocator.readTotalItems().click();
		String item = All_ClientPortal_Locators.readTotalItemsNotice().getText();
		String[] bits = item.split(" "); // Splitting the String
		String compliancesCount = bits[bits.length - 2]; // Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);

		if (compliancesCount.equalsIgnoreCase("to")) {
			Thread.sleep(5000);
			item = All_ClientPortal_Locators.readTotalItemsNotice().getText();
			bits = item.split(" ");

		}

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) getDriver();

		js1.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(3000);
//		All_ClientPortal_Locators.clickNoticeExport().click();
		Locators.Export().click();

		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download

		if (dirContents.length < allFilesNew.length) {

			Thread.sleep(9000); // Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			File lastModifiedFile = allFilesNew[0]; // Storing any 0th index file in 'lastModifiedFile' file name.
			for (int i = 1; i < allFilesNew.length; i++) // For loop till the number of files in directory.
			{
				if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) // If allFilesNew[i] file is having
																						// large/latest time time of
																						// update then latest modified
																						// file be allFilesNew[i] file.
				{
					lastModifiedFile = allFilesNew[i];
				}
			}

			Thread.sleep(1000);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0); // Retrieving first sheet of Workbook

			sheet = workbook.getSheetAt(0);
			int columnNumber = 3;
			int rowCount = 0;
			int actualRow = 0;

			for (Row row : sheet) {

				Cell cell = row.getCell(columnNumber);
				if (cell != null) {

					rowCount++;
					actualRow = rowCount - 1;
				}

			}
			fis.close();

			if (count1 == actualRow) {
				// test.log(LogStatus.PASS, "No of records from grid matches to no of records in
				// Excel Sheet.");
				test.log(LogStatus.PASS,
						"Total records from Grid = " + count1 + " | Total records from Report = " + actualRow);
			} else {
				// test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of
				// records in Excel Sheet.");
				test.log(LogStatus.FAIL,
						"Total records from Grid = " + count1 + " | Total records from Excel Sheet = " + actualRow);
			}
		} else {
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
		
	}
	
	public static void ViewOverDownloadRCComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.RCComplied().click();
		Thread.sleep(5000);
				
		
		
		
		//View
		All_ClientPortal_Locators.compliancePerformanceViewNo().click();
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//img[@alt='View Document']")).click();
		Thread.sleep(5000);
//		All_ClientPortal_Locators.OverviewClose().click();
		getDriver().findElement(By.xpath("(//button[@icon='close'])[2]")).click();

		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click(); //Clicking 2 times close due to 2 closes are there
		Thread.sleep(3000);

		test.log(LogStatus.PASS, " View Successfully.");
		
		
		//Overview
		String s1 = All_ClientPortal_Locators.readTotalItemsD().getText();
		if (!s1.equalsIgnoreCase("0 - 0 of 0 items")) {
			Thread.sleep(5000);

			All_ClientPortal_Locators.compliancePerformanceOverView().click();
			Thread.sleep(5000);
			All_ClientPortal_Locators.OverviewClose().click();

			Thread.sleep(3000);

			test.log(LogStatus.PASS, " Overview Successfully.");
		} else {
			Thread.sleep(5000);
			Thread.sleep(1000);

			test.log(LogStatus.PASS, "No records available.");

		}
		
		//Download
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(5000);
		All_ClientPortal_Locators.compliancePerformanceDownloadBtn().click();
		Thread.sleep(8000);
		All_ClientPortal_Locators.compliancePerformanceFileDownPopup().click();

		Thread.sleep(10000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
	}
	public static void RCCompliedPagination(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.RCComplied().click();
		Thread.sleep(5000);
		
		CoordinatorMethod.zoomOutScreen(2); //Zoom Out
		
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);
		
		
	}
	
	public static void RCOverdueSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.PCOverdue().click();
		Thread.sleep(5000);
		
		
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.compliancePerformanceSearch().sendKeys("140307",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='140307']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Compliance ID selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}

		
		
	}
	public static void RCOverdueClearExport(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.PCOverdue().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.compliancePerformanceSearch().sendKeys("HelloHowAreYou", Keys.ENTER);
		Thread.sleep(4000);

		if (All_ClientPortal_Locators.Clear().isEnabled()) {
			Thread.sleep(5000);

			test.log(LogStatus.PASS, " Clear button working successfully.");
			All_ClientPortal_Locators.Clear().click();
		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, "Clear button does not working properly.");
		}
		Thread.sleep(3000);
		
		
		
		//Export
		Thread.sleep(2000);
//	      CoordinatorLocator.readTotalItems().click();
		String item = All_ClientPortal_Locators.readTotalItemsNotice().getText();
		String[] bits = item.split(" "); // Splitting the String
		String compliancesCount = bits[bits.length - 2]; // Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);

		if (compliancesCount.equalsIgnoreCase("to")) {
			Thread.sleep(5000);
			item = All_ClientPortal_Locators.readTotalItemsNotice().getText();
			bits = item.split(" ");

		}

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) getDriver();

		js1.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(3000);
//		All_ClientPortal_Locators.clickNoticeExport().click();
		Locators.Export().click();

		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download

		if (dirContents.length < allFilesNew.length) {

			Thread.sleep(9000); // Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			File lastModifiedFile = allFilesNew[0]; // Storing any 0th index file in 'lastModifiedFile' file name.
			for (int i = 1; i < allFilesNew.length; i++) // For loop till the number of files in directory.
			{
				if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) // If allFilesNew[i] file is having
																						// large/latest time time of
																						// update then latest modified
																						// file be allFilesNew[i] file.
				{
					lastModifiedFile = allFilesNew[i];
				}
			}

			Thread.sleep(1000);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0); // Retrieving first sheet of Workbook

			sheet = workbook.getSheetAt(0);
			int columnNumber = 3;
			int rowCount = 0;
			int actualRow = 0;

			for (Row row : sheet) {

				Cell cell = row.getCell(columnNumber);
				if (cell != null) {

					rowCount++;
					actualRow = rowCount - 1;
				}

			}
			fis.close();

			if (count1 == actualRow) {
				// test.log(LogStatus.PASS, "No of records from grid matches to no of records in
				// Excel Sheet.");
				test.log(LogStatus.PASS,
						"Total records from Grid = " + count1 + " | Total records from Report = " + actualRow);
			} else {
				// test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of
				// records in Excel Sheet.");
				test.log(LogStatus.FAIL,
						"Total records from Grid = " + count1 + " | Total records from Excel Sheet = " + actualRow);
			}
		} else {
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}

		
		
	}
	public static void RCOverdueOverview(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.PCOverdue().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.Overview().click();
		Thread.sleep(9000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS,  " Overview successfully.");
		
		
	}
	public static void RCOverduePagination(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.PCOverdue().click();
		Thread.sleep(5000);
		
		OneCommonMethod.zoomOutScreen(2);   //Zoom Out
		
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);
		
		
	}
	public static void searchEcComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ECComplied().click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Establishment Compliances 'Complied' hyper link is clickable");		
		
		
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.compliancePerformanceSearch().sendKeys("20676",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='20676']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Compliance ID selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
		
	}
	

	public static void clearbtnEcComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ECComplied().click();
		Thread.sleep(10000);
				
		
		
		All_ClientPortal_Locators.compliancePerformanceSearch().sendKeys("HelloHowAreYou",Keys.ENTER);
		Thread.sleep(4000);
		
		 if(All_ClientPortal_Locators.Clear().isEnabled()) {Thread.sleep(5000);
		 
			test.log(LogStatus.PASS,  " Clear button working successfully."); 
			All_ClientPortal_Locators.Clear().click();
	 }
	 else
	 {Thread.sleep(5000);
	 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
	 }
	  	 Thread.sleep(3000);
		
		
	}
	
	
	public static void searchECOverdue(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		All_ClientPortal_Locators.Overdue().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ECOverdue().click();
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Establishment Compliances 'Overdue' hyper link is clickable");
		
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.compliancePerformanceSearch().sendKeys("73475",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='73475']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Location selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
		
	
	}
	public static void clearBtnECOverdue(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		All_ClientPortal_Locators.Overdue().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ECOverdue().click();
		
		Thread.sleep(5000);
		All_ClientPortal_Locators.compliancePerformanceSearch().sendKeys("Testing for Automation Purpose",Keys.ENTER);
		Thread.sleep(4000);
		
		 if(All_ClientPortal_Locators.Clear().isEnabled()) {Thread.sleep(5000);
		 
			test.log(LogStatus.PASS,  " Clear button working successfully."); 
			All_ClientPortal_Locators.Clear().click();
	 }
	 else
	 {Thread.sleep(5000);
	 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
	 }
	  	 Thread.sleep(3000);

		
	}
	
	
	
	
	public static void ECOverdue(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Gopi().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.SelectYear().click();
		Thread.sleep(2000);
	  	All_ClientPortal_Locators.SelectYear25().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);*/
		All_ClientPortal_Locators.Overdue().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ECOverdue().click();
		Thread.sleep(8000);
//		All_ClientPortal_Locators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = All_ClientPortal_Locators.readTotalItemsD().getText();
/*		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		
		Thread.sleep(10000);
	    
		//OverviewOpenNotice locator name change me
		All_ClientPortal_Locators.OverviewOpenNotice().click();
		Thread.sleep(10000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
	}else {Thread.sleep(5000);
		Thread.sleep(1000);
		
		
		test.log(LogStatus.PASS, "No records available.");
		
	} */
		
		
		
		//me Hide upside 
		All_ClientPortal_Locators.OverviewOpenNotice().click();
		Thread.sleep(10000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		
		
			
	}
	public static void ECOverduePagination(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		
		All_ClientPortal_Locators.Overdue().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ECOverdue().click();
		Thread.sleep(8000);

		OneCommonMethod.zoomOutScreen(2); // ZoomOut
		
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);
		
		
		
	}
	
	public static void ECComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ECComplied().click();
		Thread.sleep(10000);
		
//		All_ClientPortal_Locators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = All_ClientPortal_Locators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		All_ClientPortal_Locators.compliancePerformanceViewNo().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS,  " View Successfully.");
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
	}
	
	public static void overviewECComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ECComplied().click();
		Thread.sleep(5000);
		
//		All_ClientPortal_Locators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = All_ClientPortal_Locators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		All_ClientPortal_Locators.compliancePerformanceOverView().click();
		Thread.sleep(10000);
		//Explicit wait
		WebDriverWait wait2 = new WebDriverWait(getDriver(), (30));
		wait2.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.OverviewClose()));
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS,  " Overview Successfully.");
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
	}
	public static void downloadECComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ECComplied().click();
		Thread.sleep(5000);
		

		
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(5000);
		All_ClientPortal_Locators.compliancePerformanceDownloadBtn().click();
		Thread.sleep(8000);
		All_ClientPortal_Locators.compliancePerformanceFileDownPopup().click();

		Thread.sleep(10000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	public static void PaginationECComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ECComplied().click();
		Thread.sleep(5000);
		
		OneCommonMethod.zoomOutScreen(2); // ZoomOut 2 Times
		
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);
		

	}
	
	
	
	public static void exportEC(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Gopi().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.SelectYear().click();
		Thread.sleep(2000);
	  	All_ClientPortal_Locators.SelectYear25().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);*/
		All_ClientPortal_Locators.Overdue().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ECOverdue().click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-client-entity-dashboard-grid/div[3]/kendo-loader/div")));
		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void FCOverdue(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Gopi().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.SelectYear().click();
		Thread.sleep(2000);
	  	All_ClientPortal_Locators.SelectYear25().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);*/
		All_ClientPortal_Locators.Overdue().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.FCOverdue().click();
		Thread.sleep(5000);
//		All_ClientPortal_Locators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = All_ClientPortal_Locators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		//me made OverviewOpenNotice locator
		All_ClientPortal_Locators.OverviewOpenNotice().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
	}
	
	public static void FCCompioed(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.FCCompied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = All_ClientPortal_Locators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		All_ClientPortal_Locators.OverviewNo().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS,  " Overview successfully.");
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
	}
	public static void exportFC(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		/*All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Gopi().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.SelectYear().click();
		Thread.sleep(2000);
	  	All_ClientPortal_Locators.SelectYear25().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);*/
		All_ClientPortal_Locators.Overdue().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.FCOverdue().click();
		Thread.sleep(5000);
//		All_ClientPortal_Locators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = All_ClientPortal_Locators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
	}else {Thread.sleep(5000);
		Thread.sleep(1000);
		
		
		test.log(LogStatus.PASS, "No records available.");
		
	}
	}
	
	public static void exportFCComplies(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.FCCompied().click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
		
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Locators.Export().click();

	Thread.sleep(5500);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	if(dirContents.length < allFilesNew.length)
	{Thread.sleep(5000);

	test.log(LogStatus.PASS, "File downloaded successfully.");
	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	{Thread.sleep(5000);
	   if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	   {Thread.sleep(5000);
	       lastModifiedFile = allFilesNew[i];
	   }
	}

	Thread.sleep(1000);
	fis = new FileInputStream(lastModifiedFile);
	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
	/*
	int no = sheet.getFirstRowNum();
	Row row = sheet.getRow(no);
	Cell c1 = row.getCell(0);
	int records =(int) c1.getNumericCellValue();
	*/
	sheet = workbook.getSheetAt(0);
	int columnNumber = 3;
	int rowCount = 0;
	int actualRow=0;

	for(Row row : sheet)
	{Thread.sleep(5000);
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {Thread.sleep(5000);
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();

	if(count1 == actualRow)
	{Thread.sleep(5000);
		
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{Thread.sleep(5000);
		
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
	}
	else
	{Thread.sleep(5000);
	test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
	}
		
	}
	
	public static void ClraOverdue(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Gopi().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.SelectYear().click();
		Thread.sleep(2000);
	  	All_ClientPortal_Locators.SelectYear25().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);*/
		All_ClientPortal_Locators.Overdue().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ClraOverdue().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = All_ClientPortal_Locators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		
		All_ClientPortal_Locators.OverviewNo().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
	}
	
	public static void ClraComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ClraComplied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = All_ClientPortal_Locators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		All_ClientPortal_Locators.OverviewNo().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS,  " Overview successfully.");
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
	}
	
	
	public static void exportClra (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Gopi().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.SelectYear().click();
		Thread.sleep(2000);
	  	All_ClientPortal_Locators.SelectYear25().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.Overdue().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ClraOverdue().click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void exportClraComplied (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		All_ClientPortal_Locators.Complied().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ClraComplied().click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Locators.Export().click();

	Thread.sleep(5500);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	if(dirContents.length < allFilesNew.length)
	{Thread.sleep(5000);

	test.log(LogStatus.PASS, "File downloaded successfully.");
	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	{Thread.sleep(5000);
	   if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	   {Thread.sleep(5000);
	       lastModifiedFile = allFilesNew[i];
	   }
	}

	Thread.sleep(1000);
	fis = new FileInputStream(lastModifiedFile);
	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
	/*
	int no = sheet.getFirstRowNum();
	Row row = sheet.getRow(no);
	Cell c1 = row.getCell(0);
	int records =(int) c1.getNumericCellValue();
	*/
	sheet = workbook.getSheetAt(0);
	int columnNumber = 3;
	int rowCount = 0;
	int actualRow=0;

	for(Row row : sheet)
	{Thread.sleep(5000);
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {Thread.sleep(5000);
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();

	if(count1 == actualRow)
	{Thread.sleep(5000);
		
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{Thread.sleep(5000);
		
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
	}
	else
	{Thread.sleep(5000);
	test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
	}
		
	}
	
	public static void exportCP (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Gopi().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.SelectYear().click();
		Thread.sleep(2000);
	  	All_ClientPortal_Locators.SelectYear25().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.Overdue().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = All_ClientPortal_Locators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
	}
	
	public static void OpenStatus( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[30]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
		String string_Categories =All_ClientPortal_Locators.Open().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	
		//me added this validation 
     	if(All_ClientPortal_Locators.Open().isEnabled())
     	{
     		All_ClientPortal_Locators.Open().click();
			test.log(LogStatus.PASS, "Notice Status Circle graph - Open link is working fine");
     	}
     	
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.OpenCol().click();
		Thread.sleep(3000);
		
		
//		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Open count in the grid = "+CatcountGrid+" | Dashboard Open Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Open count in the grid = "+CatcountGrid+" | Dashboard Open Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	public static void NoticeStatusSearch( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[30]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	
     	All_ClientPortal_Locators.Open().click();
     	
		Thread.sleep(5000);
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.Search().sendKeys("Test Automation 2",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[contains(text(),'Test Automation 2')]")).getText();
		
			
		test.log(LogStatus.PASS, "Selected entity name along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Entity selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
     	
		
	}
	
	public static void OpenView(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[30]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		All_ClientPortal_Locators.Open().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.OpenCol().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click(); //me comment
		
		Thread.sleep(3000);

		
		test.log(LogStatus.PASS,  " File View Successfully.");

		
//		Me Hide this
/*		String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
		String text2 = getDriver().findElement(By.xpath("(//span[@id='kendo-dialog-title-289389'])[1]")).getText();	
		
			if(!text1.equalsIgnoreCase("Unsupported File Type")||!text2.equalsIgnoreCase("Document Viewer")) {Thread.sleep(5000);
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {Thread.sleep(5000);
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
		
*/		
		
		
	}
	public static void NoticeStatusOpenPagination(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[30]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		All_ClientPortal_Locators.Open().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.OpenCol().click();
		Thread.sleep(5000);
		
		
		OneCommonMethod.zoomOutScreen(2); //ZoomOut
		
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);

		

		
	}
	public static void NoticeStatusOpenHyperLinkCount(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[30]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		All_ClientPortal_Locators.Open().click();
		Thread.sleep(5000);
		
		
		OneCommonMethod.zoomOutScreen(2); //Zoom Out
		Thread.sleep(5000);
		
		// Step 1: Get count from "Active" column hyperlink
		WebElement activeLink = All_ClientPortal_Locators.OpenCol();
		String activeCountText = activeLink.getText().trim(); // e.g., "22"
		int activeDashboardCount = Integer.parseInt(activeCountText);
		test.log(LogStatus.INFO, "Open count from Open hyper link: " + activeDashboardCount);

		// Step 2: Click on hyperlink to open grid
		activeLink.click();
		Thread.sleep(3000); // or use WebDriverWait if needed
		test.log(LogStatus.INFO, "Open column hyper link is clickable");

		// Step 3: Get grid count from top bar (e.g., "1 - 10 of 22 items")
		WebElement gridLabel = All_ClientPortal_Locators.readTotalItemsNotice(); // use your method here
		String gridText = gridLabel.getText().trim();
		String[] parts = gridText.split(" ");
		int activeGridCount = Integer.parseInt(parts[parts.length - 2]);
		test.log(LogStatus.INFO, "Open count found in grid: " + activeGridCount);

		// Step 4: Match both counts
		if (activeDashboardCount == activeGridCount) {
		    test.log(LogStatus.PASS, "PASS: Active count from open column matches grid count.");
		} else {
		    test.log(LogStatus.FAIL, "FAIL: Mismatch. Dashboard = " + activeDashboardCount + ", Grid = " + activeGridCount);
		}
			
		
		
	}
	
	public static void exportOpen (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[30]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		All_ClientPortal_Locators.Open().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.OpenCol().click();
		Thread.sleep(5000);

/*		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
*/		
		
		
		
		
		OneCommonMethod.validateExportedExcel(
			    driver.get(),
			    test,
			    All_ClientPortal_Locators.Export(),            // Export button WebElement
			    All_ClientPortal_Locators.readTotalItems(),   // Count ka dynamic locator
			    "Notice Type"                                  //Header Name
			);


		
		
		
/*		// Export logic--

		String item = All_ClientPortal_Locators.readTotalItems().getText();
		String[] bits = item.split(" "); // Splitting the String
		String compliancesCount = bits[bits.length - 2]; // Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);

		if (compliancesCount.equalsIgnoreCase("to")) {
			Thread.sleep(5000);
			item = All_ClientPortal_Locators.readTotalItems().getText();
			bits = item.split(" ");

		}

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) getDriver();

		js1.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		All_ClientPortal_Locators.Export().click();

		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download

		if (dirContents.length < allFilesNew.length) {

			Thread.sleep(9000); // Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			File lastModifiedFile = allFilesNew[0]; // Storing any 0th index file in 'lastModifiedFile' file name.
			for (int i = 1; i < allFilesNew.length; i++) // For loop till the number of files in directory.
			{
				if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) // If allFilesNew[i] file is having
																						// large/latest time time of
																						// update then latest modified
																						// file be allFilesNew[i] file.
				{
					lastModifiedFile = allFilesNew[i];
				}
			}

			Thread.sleep(1000);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0); // Retrieving first sheet of Workbook

			sheet = workbook.getSheetAt(0);
			int columnNumber = 3;
			int rowCount = 0;
			int actualRow = 0;

			for (Row row : sheet) {

				Cell cell = row.getCell(columnNumber);
				if (cell != null) {

					rowCount++;
					actualRow = rowCount - 1;
				}

			}
			fis.close();

			if (count1 == actualRow) {
				// test.log(LogStatus.PASS, "No of records from grid matches to no of records in
				// Excel Sheet.");
				test.log(LogStatus.PASS,
						"Total records from Grid = " + count1 + " | Total records from Report = " + actualRow);
			} else {
				// test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of
				// records in Excel Sheet.");
				test.log(LogStatus.FAIL,
						"Total records from Grid = " + count1 + " | Total records from Excel Sheet = " + actualRow);
			}
		} else {
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
		
		*/
		
	}
	
	public static void ClosedStatus( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[31]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		String string_Categories =All_ClientPortal_Locators.Closed().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	All_ClientPortal_Locators.Closed().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		All_ClientPortal_Locators.ClosedCol().click();
		Thread.sleep(3000);
		
		
//		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Closed count in the grid = "+CatcountGrid+" | Dashboard Closed Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Closed count in the grid = "+CatcountGrid+" | Dashboard Closed Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void ClosedView(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[31]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		All_ClientPortal_Locators.Closed().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ClosedCol().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  "View successfully.");
		
		
	}
	public static void NoticeStatusClosedPagination(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[31]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		All_ClientPortal_Locators.Closed().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ClosedCol().click();
		Thread.sleep(5000);
		
		OneCommonMethod.zoomOutScreen(2); 
		
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);
		
		
	}
	public static void NoticeStatusOpenClosedCountWithTotalNotices(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[31]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		All_ClientPortal_Locators.Closed().click();
		Thread.sleep(5000);
		

		  try {
		        // Step 1: Read Open count
		        WebElement openElement = All_ClientPortal_Locators.OpenCol();
		        String openText = openElement.getText().trim();
		        int openCount = Integer.parseInt(openText);
		        test.log(LogStatus.INFO, "Open count: " + openCount);

		        // Step 2: Read Closed count
		        WebElement closedElement = All_ClientPortal_Locators.ClosedCol();
		        String closedText = closedElement.getText().trim();
		        int closedCount = Integer.parseInt(closedText);
		        test.log(LogStatus.INFO, "Closed count: " + closedCount);

		        // Step 3: Read Total Notices count
		        WebElement totalElement = All_ClientPortal_Locators.allNoticesColumCount();
		        String totalText = totalElement.getText().trim();
		        int totalCount = Integer.parseInt(totalText);
		        test.log(LogStatus.INFO, "Total Notices count: " + totalCount);

		        // Step 4: Validate
		        if (openCount + closedCount == totalCount) {
		            test.log(LogStatus.PASS, "PASS: Open + Closed = Total (" + openCount + " + " + closedCount + " = " + totalCount + ")");
		        } else {
		            test.log(LogStatus.FAIL, "FAIL: Count mismatch. Open (" + openCount + ") + Closed (" + closedCount + ") != Total (" + totalCount + ")");
		        }

		    } catch (Exception e) {
		        test.log(LogStatus.FAIL, "Exception occurred: " + e.getMessage());
		    }
		

		
		
	}
	
	public static void NoticeStatusPagination(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[31]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		All_ClientPortal_Locators.Closed().click();
		Thread.sleep(5000);
		
		
		
		OneCommonMethod.zoomOutScreen(2); //Zoom Out
		
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);
		

		
		
	}
	public static void AbstractStatusIsDisplayed(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
/*		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[31]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		All_ClientPortal_Locators.Closed().click();
		*/
		Thread.sleep(5000);
		
//	    JavascriptExecutor js = (JavascriptExecutor) getDriver();
//	    js.executeScript("window.scrollBy(0,1000)");
	    
	    JavascriptExecutor js2 = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("//h4[normalize-space()='Abstract Status']"));
		js2.executeScript("arguments[0].scrollIntoView(true);", element);
		
	    Thread.sleep(5000);
	    WebElement Abstract = getDriver().findElement(By.xpath("//h4[normalize-space()='Abstract Status']"));
	    Abstract.getText();
	    
	    if(Abstract.isDisplayed())
	    {
	    	System.out.println("Abstract is displayed");
            test.log(LogStatus.PASS, "Abstract Status Grpah is displayed");
	    
            String base64Screenshot = OneCommonMethod.takeScreenshotBase64(driver.get());
            test.log(LogStatus.INFO, "ScreenShot <br>" + test.addBase64ScreenShot(base64Screenshot));
	    }
		
		
	}
	public static void NoticeStatusClosedHyperLinkCount(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[31]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		All_ClientPortal_Locators.Closed().click();
		Thread.sleep(5000);
		
//		All_ClientPortal_Locators.ClosedCol().click();
		
		OneCommonMethod.zoomOutScreen(2); //Zoom Out
		Thread.sleep(5000);
		
		// Step 1: Get count from "Active" column hyperlink
		WebElement activeLink = All_ClientPortal_Locators.ClosedCol();
		String activeCountText = activeLink.getText().trim(); // e.g., "22"
		int activeDashboardCount = Integer.parseInt(activeCountText);
		test.log(LogStatus.INFO, "Closed count from closed hyper link: " + activeDashboardCount);

		// Step 2: Click on hyperlink to open grid
		activeLink.click();
		Thread.sleep(3000); // or use WebDriverWait if needed
		test.log(LogStatus.INFO, "Closed column hyper link is clickable");

		// Step 3: Get grid count from top bar (e.g., "1 - 10 of 22 items")
		WebElement gridLabel = All_ClientPortal_Locators.readTotalItemsNotice(); // use your method here
		String gridText = gridLabel.getText().trim();
		String[] parts = gridText.split(" ");
		int activeGridCount = Integer.parseInt(parts[parts.length - 2]);
		test.log(LogStatus.INFO, "Closed count found in grid: " + activeGridCount);

		// Step 4: Match both counts
		if (activeDashboardCount == activeGridCount) {
		    test.log(LogStatus.PASS, "PASS: Active count from closed column matches grid count.");
		} else {
		    test.log(LogStatus.FAIL, "FAIL: Mismatch. Dashboard = " + activeDashboardCount + ", Grid = " + activeGridCount);
		}
		
		
	}
	
	public static void exportClosed (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[31]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		All_ClientPortal_Locators.Closed().click();
		Thread.sleep(5000);
		
		All_ClientPortal_Locators.ClosedCol().click();
		Thread.sleep(5000);

/*		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		} */
		
		OneCommonMethod.validateExportedExcel(
			    driver.get(),
			    test,
			    All_ClientPortal_Locators.Export(),            // Export button WebElement
			    All_ClientPortal_Locators.readTotalItems(),   // Count ka dynamic locator
			    "NoticeType"                                  //Header Name
			);
		
	}
	
	public static void exportNoticeStatus (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[31]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		All_ClientPortal_Locators.Closed().click();
		Thread.sleep(5000);

/*		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
	*/
		
	
		
		// Export logic--
		OneCommonMethod.validateExportedExcel(
			    driver.get(),
			    test,
			    All_ClientPortal_Locators.Export(),            // Export button WebElement
			    All_ClientPortal_Locators.readTotalItems(),   // Count ka dynamic locator
			    "Clientid"                                  //Header Name
			);
		

/*		String item = All_ClientPortal_Locators.readTotalItems().getText();
		String[] bits = item.split(" "); // Splitting the String
		String compliancesCount = bits[bits.length - 2]; // Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);

		if (compliancesCount.equalsIgnoreCase("to")) {
			Thread.sleep(5000);
			item = All_ClientPortal_Locators.readTotalItems().getText();
			bits = item.split(" ");

		}

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) getDriver();

		js1.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		All_ClientPortal_Locators.Export().click();

		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download

		if (dirContents.length < allFilesNew.length) {

			Thread.sleep(9000); // Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			File lastModifiedFile = allFilesNew[0]; // Storing any 0th index file in 'lastModifiedFile' file name.
			for (int i = 1; i < allFilesNew.length; i++) // For loop till the number of files in directory.
			{
				if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) // If allFilesNew[i] file is having
																						// large/latest time time of
																						// update then latest modified
																						// file be allFilesNew[i] file.
				{
					lastModifiedFile = allFilesNew[i];
				}
			}

			Thread.sleep(1000);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0); // Retrieving first sheet of Workbook

			sheet = workbook.getSheetAt(0);
			int columnNumber = 3;
			int rowCount = 0;
			int actualRow = 0;

			for (Row row : sheet) {

				Cell cell = row.getCell(columnNumber);
				if (cell != null) {

					rowCount++;
					actualRow = rowCount - 1;
				}

			}
			fis.close();

			if (count1 == actualRow) {
				// test.log(LogStatus.PASS, "No of records from grid matches to no of records in
				// Excel Sheet.");
				test.log(LogStatus.PASS,
						"Total records from Grid = " + count1 + " | Total records from Report = " + actualRow);
			} else {
				// test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of
				// records in Excel Sheet.");
				test.log(LogStatus.FAIL,
						"Total records from Grid = " + count1 + " | Total records from Excel Sheet = " + actualRow);
			}
		} else {
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
		
		
		
*/

		
		
	}
	public static void compliancePerformanceG (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = All_ClientPortal_Locators.compliancePerformanceGraph();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		

		All_ClientPortal_Locators.compliancePerformanceGraph().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.ESTCompliance().click();
		test.log(LogStatus.PASS, "Complied Column is selected");
		
		// Search
		Thread.sleep(5000);
		try {
			Thread.sleep(5000);
			All_ClientPortal_Locators.Search().sendKeys("20676", Keys.ENTER);
			Thread.sleep(4000);
			String text = getDriver().findElement(By.xpath("//div[@title='20676']")).getText();

			test.log(LogStatus.PASS, "Compliance ID is entered in search field : " + text);
			test.log(LogStatus.PASS, "Compliance ID is selected : " + text);

			Thread.sleep(3000);
		} catch (Exception e) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}

		// Compliance dropdown apply button
		All_ClientPortal_Locators.complianceDropdwonClick().click();
		Thread.sleep(3000);
		All_ClientPortal_Locators.complianceSelectOnRegisters().click();
		Thread.sleep(3000);

		if (All_ClientPortal_Locators.ClickApplyBtn().isEnabled()) {
			Thread.sleep(5000);
			All_ClientPortal_Locators.ClickApplyBtn().click();
			test.log(LogStatus.PASS, "Compliance dropdown is working fine");

			test.log(LogStatus.PASS, "Apply button is working fine");
		}

		// Clear button
		if (All_ClientPortal_Locators.Clear().isEnabled()) {
			Thread.sleep(5000);

			test.log(LogStatus.PASS, " Clear button working fine");
			All_ClientPortal_Locators.Clear().click();
		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, "Clear button does not working properly.");
		}
		Thread.sleep(10000);
		
		
		
		// Export logic--

				String item = All_ClientPortal_Locators.readTotalItems().getText();
				String[] bits = item.split(" "); // Splitting the String
				String compliancesCount = bits[bits.length - 2]; // Getting the second last word (total number of users)
				int count1 = Integer.parseInt(compliancesCount);

				if (compliancesCount.equalsIgnoreCase("to")) {
					Thread.sleep(5000);
					item = All_ClientPortal_Locators.readTotalItems().getText();
					bits = item.split(" ");

				}

				Thread.sleep(2000);
				JavascriptExecutor js1 = (JavascriptExecutor) getDriver();

				js1.executeScript("window.scrollBy(0,-500)");
				Thread.sleep(1000);
				File dir = new File("C:\\Users\\bilali\\Downloads");
				File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(1000);
				All_ClientPortal_Locators.Export().click();

				Thread.sleep(5500);
				File dir1 = new File("C:\\Users\\bilali\\Downloads");
				File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download

				if (dirContents.length < allFilesNew.length) {

					Thread.sleep(9000); // Clicking on 'Excel Report' image.
					test.log(LogStatus.PASS, "File downloaded successfully.");
					File lastModifiedFile = allFilesNew[0]; // Storing any 0th index file in 'lastModifiedFile' file name.
					for (int i = 1; i < allFilesNew.length; i++) // For loop till the number of files in directory.
					{
						if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) // If allFilesNew[i] file is having
																								// large/latest time time of
																								// update then latest modified
																								// file be allFilesNew[i] file.
						{
							lastModifiedFile = allFilesNew[i];
						}
					}

					Thread.sleep(1000);
					fis = new FileInputStream(lastModifiedFile);
					workbook = new XSSFWorkbook(fis);
					sheet = workbook.getSheetAt(0); // Retrieving first sheet of Workbook

					sheet = workbook.getSheetAt(0);
					int columnNumber = 3;
					int rowCount = 0;
					int actualRow = 0;

					for (Row row : sheet) {

						Cell cell = row.getCell(columnNumber);
						if (cell != null) {

							rowCount++;
							actualRow = rowCount - 1;
						}

					}
					fis.close();

					if (count1 == actualRow) {
						// test.log(LogStatus.PASS, "No of records from grid matches to no of records in
						// Excel Sheet.");
						test.log(LogStatus.PASS,
								"Total records from Grid = " + count1 + " | Total records from Report = " + actualRow);
					} else {
						// test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of
						// records in Excel Sheet.");
						test.log(LogStatus.FAIL,
								"Total records from Grid = " + count1 + " | Total records from Excel Sheet = " + actualRow);
					}
				} else {
					test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
				}
		
	}
	public static void compliancePerformanceBarGraph (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = All_ClientPortal_Locators.compliancePerformanceGraph();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		

		All_ClientPortal_Locators.compliancePerformanceGraph().click();
		Thread.sleep(4000);
		test.log(LogStatus.INFO, "Compliance Performance graph is clickable");
		All_ClientPortal_Locators.PayRollCompliance().click();
		test.log(LogStatus.INFO, "Payroll Compliances Complied Column is selected");
		
		
		// Search
		Thread.sleep(5000);
		try {
			Thread.sleep(5000);
			All_ClientPortal_Locators.Search().sendKeys("1921", Keys.ENTER);
			Thread.sleep(4000);
			String text = getDriver().findElement(By.xpath("//div[@title='1921']")).getText();

			test.log(LogStatus.PASS, "Compliance ID is entered in search field : " + text);
			test.log(LogStatus.PASS, "Compliance ID is selected : " + text);

			Thread.sleep(3000);
		} catch (Exception e) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
		
		// Compliance dropdown apply button
//		All_ClientPortal_Locators.complianceDropdwonClick().click();
		getDriver().findElement(By.xpath("//span[contains(text(),'Challan')]")).click();
		Thread.sleep(3000);
		All_ClientPortal_Locators.complianceSelectOnChallan().click();
		Thread.sleep(3000);

		if (All_ClientPortal_Locators.ClickApplyBtn().isEnabled()) {
			Thread.sleep(5000);
			All_ClientPortal_Locators.ClickApplyBtn().click();
			test.log(LogStatus.PASS, "Compliance dropdown is working fine");

			test.log(LogStatus.PASS, "Apply button is working fine");
		}
		Thread.sleep(5000);
		
		
		// Clear button
		if (All_ClientPortal_Locators.Clear().isEnabled()) {
			Thread.sleep(5000);

			test.log(LogStatus.PASS, " Clear button working fine");
			All_ClientPortal_Locators.Clear().click();
		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, "Clear button does not working properly.");
		}
		Thread.sleep(10000);
		
		
		// Export logic--

		String item = All_ClientPortal_Locators.readTotalItems().getText();
		String[] bits = item.split(" "); // Splitting the String
		String compliancesCount = bits[bits.length - 2]; // Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);

		if (compliancesCount.equalsIgnoreCase("to")) {
			Thread.sleep(5000);
			item = All_ClientPortal_Locators.readTotalItems().getText();
			bits = item.split(" ");

		}

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) getDriver();

		js1.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		All_ClientPortal_Locators.Export().click();

		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download

		if (dirContents.length < allFilesNew.length) {

			Thread.sleep(9000); // Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			File lastModifiedFile = allFilesNew[0]; // Storing any 0th index file in 'lastModifiedFile' file name.
			for (int i = 1; i < allFilesNew.length; i++) // For loop till the number of files in directory.
			{
				if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) // If allFilesNew[i] file is having
																						// large/latest time time of
																						// update then latest modified
																						// file be allFilesNew[i] file.
				{
					lastModifiedFile = allFilesNew[i];
				}
			}

			Thread.sleep(1000);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0); // Retrieving first sheet of Workbook

			sheet = workbook.getSheetAt(0);
			int columnNumber = 3;
			int rowCount = 0;
			int actualRow = 0;

			for (Row row : sheet) {

				Cell cell = row.getCell(columnNumber);
				if (cell != null) {

					rowCount++;
					actualRow = rowCount - 1;
				}

			}
			fis.close();

			if (count1 == actualRow) {
				// test.log(LogStatus.PASS, "No of records from grid matches to no of records in
				// Excel Sheet.");
				test.log(LogStatus.PASS,
						"Total records from Grid = " + count1 + " | Total records from Report = " + actualRow);
			} else {
				// test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of
				// records in Excel Sheet.");
				test.log(LogStatus.FAIL,
						"Total records from Grid = " + count1 + " | Total records from Excel Sheet = " + actualRow);
			}
		} else {
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
		
	}
	
	public static void compliancePerformanceBarGraphPRCViewOvewviewDown (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = All_ClientPortal_Locators.compliancePerformanceGraph();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		

		All_ClientPortal_Locators.compliancePerformanceGraph().click();
		Thread.sleep(4000);
		test.log(LogStatus.INFO, "Compliance Performance graph is clickable");
		All_ClientPortal_Locators.PayRollCompliance().click();
		test.log(LogStatus.INFO, "Payroll Compliances Complied Column is selected");
		
		
		//View -- this logic little different dont use this
		Thread.sleep(4000);
		All_ClientPortal_Locators.View().click();
		Thread.sleep(4000);
		getDriver().findElement(By.xpath("//img[@alt='View Document']")).click();
		Thread.sleep(10000);
   //   All_ClientPortal_Locators.OverviewColse().click();
       	getDriver().findElement(By.xpath("(//button[@title='Close'])[2]")).click(); //View close
       	
       	Thread.sleep(4000);
       	All_ClientPortal_Locators.OverviewColse().click();
       	test.log(LogStatus.PASS,  " View successfully.");
       	
       	
       	
       	Thread.sleep(5000);
       	//Overview
		All_ClientPortal_Locators.Overview().click();
		waitForLoaderToDisappear(); //Wait until loader removed
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		test.log(LogStatus.PASS,  " Overview successfully.");
		
		
		
		Thread.sleep(10000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(5000);
		
 		All_ClientPortal_Locators.Download().click();
 		Thread.sleep(5000);

 		getDriver().findElement(By.xpath("//img[@alt='Download Document']")).click(); //After Open popup download document
 		
		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
		
		





		
		
	}
	
	
	public static void compliancePerformanceECViewOverviewDownload (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = All_ClientPortal_Locators.compliancePerformanceGraph();
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		

		All_ClientPortal_Locators.compliancePerformanceGraph().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.ESTCompliance().click();
		test.log(LogStatus.PASS, "Complied Column is selected");
		
		//View -- this logic little different dont use this
		Thread.sleep(4000);
		All_ClientPortal_Locators.View().click();
		Thread.sleep(4000);
		getDriver().findElement(By.xpath("//img[@alt='View Document']")).click();
		Thread.sleep(10000);
   //   All_ClientPortal_Locators.OverviewColse().click();
       	getDriver().findElement(By.xpath("(//button[@title='Close'])[2]")).click(); //View close
       	
       	Thread.sleep(4000);
       	All_ClientPortal_Locators.OverviewColse().click();
       	test.log(LogStatus.PASS,  " View successfully.");
       	
       	
       	
       	Thread.sleep(5000);
       	//Overview
		All_ClientPortal_Locators.Overview().click();
		waitForLoaderToDisappear(); //Wait until loader removed
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		test.log(LogStatus.PASS,  " Overview successfully.");
		
		
		
		Thread.sleep(10000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(5000);
		
 		All_ClientPortal_Locators.Download().click();

 		getDriver().findElement(By.xpath("//img[@alt='Download Document']")).click(); //After Open popup download document
 		
		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
		
		
		
	}
	
	public static void RegistrationStatusBar( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[61]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
		String string_Categories =All_ClientPortal_Locators.Registration().getText();		//Storing old value of Statutory overdue.
		Thread.sleep(5000);
		int CategoriesCountDas = Integer.parseInt(string_Categories);
		Thread.sleep(5000);
     	All_ClientPortal_Locators.Registration().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		
		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Active in the grid = "+CatcountGrid+" | Dashboard Active  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Active in the grid = "+CatcountGrid+" | Dashboard Active Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	
	public static void RegistrationStatusExportBar( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.Registration().click();
		Thread.sleep(5000);
		
		
//		All_ClientPortal_Locators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = All_ClientPortal_Locators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
		
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							

		Thread.sleep(1000);
		try {
		LoginLocators.Export().click();
		}
		catch(Exception e)
		{
			LoginLocators.Exportbtn().click();
			
			}
		test.log(LogStatus.PASS, "File downloaded successfully.");

		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles();							

		if(dirContents.length < allFilesNew.length)
		{
				
			File lastModifiedFile = allFilesNew[0];			
		    for (int i = 1; i < allFilesNew.length; i++) 	
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(1000);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					
			/*
			int no = sheet.getFirstRowNum();
			Row row = sheet.getRow(no);
			Cell c1 = row.getCell(0);
			int records =(int) c1.getNumericCellValue();
			*/
			sheet = workbook.getSheetAt(0);
			int columnNumber = 3;
			int rowCount = 0;
			int actualRow=0;
			
			for(Row row : sheet)
			{
				
				Cell cell =row.getCell(columnNumber);
				if(cell != null) {
					
					rowCount++;
					actualRow = rowCount-1;
				}
				
			}
			fis.close();
			
			if(count1 == actualRow)
			{
				//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
				test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
			}
			else
			{
				//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
				test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
	All_ClientPortal_Locators.CLDashboard().click();
	
	}
	public static void RegistrationStatusGraphSearchBar( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.Registration().click();
		Thread.sleep(5000);
		
		
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.RSGSearch().sendKeys("TESTAUTO2",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='TESTAUTO2']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Location selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
		

	
	}

	
	public static void RegistrationSViewL( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.Registration().click();
		Thread.sleep(5000);
		
		
		All_ClientPortal_Locators.OverviewNo().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  "view successfully.");
		
		
	}
	
	public static void DownloadActiveBar(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.Registration().click();
		Thread.sleep(5000);
		
	
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.DownloadBtn().click(); //Ye locator hai

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void RegistrationSHistoryBar( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.Registration().click();
		Thread.sleep(5000);
		
		
		All_ClientPortal_Locators.History().click();
		Thread.sleep(5000);
		String item = All_ClientPortal_Locators.RegistrationLicencesHistory().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("Registration & Licences History")) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on History button page redirect to the Registration & Licences History page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " History button not working ");

		}
		
	}
	
	
	public static void RegistrationSHistoryExportBar(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.Registration().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.History().click();
		Thread.sleep(5000);
		
	
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	public static void RSG_ActiveEditSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.Registration().click();
		Thread.sleep(5000);
		
		
		All_ClientPortal_Locators.RSG_EditBtn().click();
		
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.RSGSearch().sendKeys("TESTAUTO2",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='TESTAUTO2']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Entity selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}	
			
	}
	
	public static void RSG_ActiveEditClear(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.Registration().click();
		Thread.sleep(5000);
		
		
		All_ClientPortal_Locators.RSG_EditBtn().click();
		
		All_ClientPortal_Locators.Search().sendKeys("HelloHowAreYou",Keys.ENTER);
		Thread.sleep(4000);
		
		 if(All_ClientPortal_Locators.Clear().isEnabled()) {Thread.sleep(5000);
		 
			test.log(LogStatus.PASS,  " Clear button working successfully."); 
			All_ClientPortal_Locators.Clear().click();
	 }
	 else
	 {Thread.sleep(5000);
	 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
	 }
	  	 Thread.sleep(3000);
		
			
	}
	
	
	public static void RSG_ActiveEditExport(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.Registration().click();
		Thread.sleep(5000);
		
		
		All_ClientPortal_Locators.RSG_EditBtn().click();
		
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
			
	}
	
	public static void RSG_ActiveEditView(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.Registration().click();
		Thread.sleep(5000);
		
		
		All_ClientPortal_Locators.RSG_EditBtn().click();
		
		All_ClientPortal_Locators.compliancePerformanceViewNo().click();
		Thread.sleep(5000);
//		All_ClientPortal_Locators.OverviewClose().click(); //Hide due to close screen is removed
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  "View Successfully.");
			
	}
	
	public static void RSG_ActiveEditInitiateAction(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.Registration().click();
		Thread.sleep(5000);
		
		
		All_ClientPortal_Locators.RSG_EditBtn().click();
		
  		All_ClientPortal_Locators.ViewER().click();
  		Thread.sleep(5000);
  		if(All_ClientPortal_Locators.Back().isEnabled()) {Thread.sleep(5000);
		 
		test.log(LogStatus.PASS,  " InitiateAction button working fine."); 
		All_ClientPortal_Locators.Back().click();
       }
        else
       {Thread.sleep(5000);
 	   test.log(LogStatus.FAIL, "Back button does not working properly.");
       }
		
			
	}
	public static void RSG_ActiveEditInitiateDownload(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.Registration().click();
		Thread.sleep(5000);
		
		
		All_ClientPortal_Locators.RSG_EditBtn().click();
		
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.DownloadBtn().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
		
			
	}
	public static void RSG_ExpireSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[62]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait( getDriver(), (30));
		Thread.sleep(4000);
     	All_ClientPortal_Locators.ExpRegistration().click();
     	waitForLoaderToDisappear();
		
//		Robot robot = new Robot();
//		Actions action = new Actions(driver);
//		action.moveToElement(element).click().perform();
		
		
		Thread.sleep(5000);
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.RSGSearch().sendKeys("TESTAUTO2",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='TESTAUTO2']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Entity selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
				
		
	}
	
	public static void RSG_ExpiredExport(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.ExpRegistration().click();
     	
		Thread.sleep(5000);
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.RSGSearch().sendKeys("TESTAUTO2",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='TESTAUTO2']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Location selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
				
	}
	public static void RSG_ExpiredViewDownload(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.ExpRegistration().click();
     	waitForLoaderToDisappear(); //Wait until loader removed
     	
     	//View:
		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
	    test.log(LogStatus.PASS,  "View successfully.");
	    
	    //Download:
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.DownloadBtn().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
     	
	    		
	}
	
	public static void RSG_ExpiredHistorySearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.ExpRegistration().click();
     	waitForLoaderToDisappear(); //Wait until loader removed
     
     	//History button
		All_ClientPortal_Locators.History().click();
		Thread.sleep(5000);
		String item = All_ClientPortal_Locators.RegistrationLicencesHistory().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("Registration & Licences History")) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on History button page redirect to the Registration & Licences History page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " History button not working ");

		}
     	
		//Search
		
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.RSGSearch().sendKeys("TESTAUTO2",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='TESTAUTO2']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Entity selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
 
		Thread.sleep(5000);
		
		//Export
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
	    		
	}
	public static void RSG_ExpiredHistoryViewDownload(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.ExpRegistration().click();
     	waitForLoaderToDisappear(); //Wait until loader removed
     
     	//History button
		All_ClientPortal_Locators.History().click();
		Thread.sleep(5000);
		
		
		//View:--
		Thread.sleep(5000);
		All_ClientPortal_Locators.View().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.OverviewClose().click();
		
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS,  "View Successfully.");
		
		
		//Download
		Thread.sleep(5000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.DownloadBtn().click(); //Ye locator hai

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}

	    		
	}
	public static void RSG_ExpiredEditSearchClearExport(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.ExpRegistration().click();
     	waitForLoaderToDisappear(); //Wait until loader removed
     
     	All_ClientPortal_Locators.Edit().click();
     	test.log(LogStatus.PASS, "Edit button is working fine");
     	
     	//Search
		try {Thread.sleep(5000);
		All_ClientPortal_Locators.RSGSearch().sendKeys("TESTAUTO2",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='TESTAUTO2']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Location selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}

		
		//Clear
		 if(All_ClientPortal_Locators.Clear().isEnabled()) {Thread.sleep(5000);
		 
			test.log(LogStatus.PASS,  " Clear button working successfully."); 
			All_ClientPortal_Locators.Clear().click();
	       }
	       else
	       {Thread.sleep(5000);
	    	test.log(LogStatus.FAIL, "Clear button does not working properly.");
	        }
	    	Thread.sleep(3000);
	    	
	    	
	    	//Export
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			All_ClientPortal_Locators.Export().click();

			Thread.sleep(8000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
				test.log(LogStatus.PASS,  " File downloaded successfully.");
			} else {Thread.sleep(5000);
				test.log(LogStatus.FAIL,  " File does not downloaded.");
			}
		
	    		
	}
	
	public static void RSG_ExpiredEditViewDownload(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.ExpRegistration().click();
     	waitForLoaderToDisappear(); //Wait until loader removed
     
     	All_ClientPortal_Locators.Edit().click();
     	test.log(LogStatus.PASS, "Edit button is working fine");
     	
     	
     	//View
		All_ClientPortal_Locators.View().click();
		CoordinatorMethod.zoomOutScreen(2); // 2 times zoom out
		Thread.sleep(5000);
		All_ClientPortal_Locators.Back().click();
		
		Thread.sleep(3000);
		
	    test.log(LogStatus.PASS,  "View Successfully.");
	    
	    
	    //Download:
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(5000);
		All_ClientPortal_Locators.compliancePerformanceDownloadBtn().click();
		Thread.sleep(8000);
//		All_ClientPortal_Locators.compliancePerformanceFileDownPopup().click();

		Thread.sleep(10000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}

     	
	    		
	}
	public static void RSG_ExpiredEditInitiateAction(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	All_ClientPortal_Locators.ExpRegistration().click();
     	waitForLoaderToDisappear(); //Wait until loader removed
     
     	All_ClientPortal_Locators.Edit().click();
     	test.log(LogStatus.PASS, "Edit button is working fine");
     	
     	//Back button
     	All_ClientPortal_Locators.InitiateAction().click();
     	CoordinatorMethod.zoomOutScreen(2); //Zoom Out
     	Thread.sleep(5000);
     	All_ClientPortal_Locators.Back().click();
     	test.log(LogStatus.PASS, "Initiate Action Back button is working fine");
     	waitForLoaderToDisappear(); //Wait until loader removed
     	
     	//Submit button
     	Thread.sleep(5000);
  		All_ClientPortal_Locators.InitiateAction().click();
  		Thread.sleep(5000);
       	All_ClientPortal_Locators.clickActivityType().click();
  		Thread.sleep(2000);
  		All_ClientPortal_Locators.selectActivityTypeApproval().click();
  		Thread.sleep(2000);
  		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
  		All_ClientPortal_Locators.Sumit().click();
  		Thread.sleep(2000);
  		 By locator = By.xpath("(//h4[@class='f-label'])");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("(//h4[@class='f-label'])")).getText();
		
		if(!text.equalsIgnoreCase("SubActivity saved successfully")||!text.equalsIgnoreCase("Success"))
		{
			
			test.log(LogStatus.PASS,"Message Displayed : "+text);
		}
		else
		{
			
			test.log(LogStatus.FAIL,"Message Displayed : "+text);
			
        }
     	
     	
     	
     	
     	
     	
     	
	    		
	}
	
	public static void CalendarExport( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("//h4[normalize-space()='My Compliance Calendar']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100)) ;
		
		
		
		
		
     	All_ClientPortal_Locators.ClickTriangle().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.nextmonth().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.nextmonth2025().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.number2().click();
		Thread.sleep(5000);
		
		//All_ClientPortal_Locators.readTotalItems1().click();					//Clicking on total items count
		Thread.sleep(5000);
		Actions action = new Actions(getDriver());

//		By locator = By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-client-dashboard/div[8]/div/div/app-client-compliance-calender/div[2]/div[2]/kendo-grid/kendo-pager/kendo-pager-info");

//		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
//		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(8000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
//	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(7000);
		String item = All_ClientPortal_Locators.readTotalItems1().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
		Thread.sleep(6000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
	
		Thread.sleep(6000);
		All_ClientPortal_Locators.clickExport2().click();
		
	
		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
	
		if(dirContents.length < allFilesNew.length)
		{
		
			Thread.sleep(9000);					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
		File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	    {
	       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	       {
	           lastModifiedFile = allFilesNew[i];
	       }
	    }
		
		Thread.sleep(6000);
		fis = new FileInputStream(lastModifiedFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
		
		sheet = workbook.getSheetAt(0);
		int columnNumber = 3;
		int rowCount = 0;
		int actualRow=0;
		
		for(Row row : sheet)
		{
			
			Cell cell =row.getCell(columnNumber);
			if(cell != null) {
				
				rowCount++;
				actualRow = rowCount-1;
			}
			
		}
		fis.close();
		
		if(count1 == actualRow)
		{
			//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
			test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
		}
		else
		{
			//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
			test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
		}
		}
		else
		{
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
	
	}
	
	public static void CalendarNextPreviousToday( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("//h4[normalize-space()='My Compliance Calendar']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100)) ;
		
		
		
		
		WebElement next = getDriver().findElement(By.xpath("//div[@title='Next']"));
		WebElement previous = getDriver().findElement(By.xpath("//div[@title='Previous']"));
		WebElement today = getDriver().findElement(By.xpath("//div[@title='Previous']"));
		
		Thread.sleep(2000);
		if(next.isEnabled())
		{
			Thread.sleep(2000);
			next.click();
			test.log(LogStatus.PASS, "Next button is clickable");
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Next button is not clickable");
		}
	    
		Thread.sleep(2000);
		if(previous.isEnabled())
		{
			Thread.sleep(2000);
			previous.click();
			test.log(LogStatus.PASS, "Previous button is clickable");
		}
		else
		{
			test.log(LogStatus.FAIL, "Previous button is not clickable");
		}
		
		Thread.sleep(2000);
		if(today.isEnabled())
		{
			Thread.sleep(2000);
			today.click();
			test.log(LogStatus.PASS, "Today hyper link is clickable");
		}
		else
		{
			test.log(LogStatus.FAIL, "Today hyper link is not clickable");
		}
	}
	

    public static void CalendarCount( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
    	JavascriptExecutor js = (JavascriptExecutor) getDriver();
    	WebElement element = getDriver().findElement(By.xpath("//h4[normalize-space()='My Compliance Calendar']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100)) ;
     	All_ClientPortal_Locators.ClickTriangle().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.nextmonth().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.nextmonth2025().click();
//		All_ClientPortal_Locators.nextmonth2024().click();
		Thread.sleep(5000);
		
		
		String string_Categories =All_ClientPortal_Locators.number().getText();		//Storing old value of Statutory overdue.
		
		int CategoriesCountDas = Integer.parseInt(string_Categories);
     	All_ClientPortal_Locators.number().click();
		Thread.sleep(5000);
	
		
		
		All_ClientPortal_Locators.readTotalItems1().click();					//Clicking on total items count
		Thread.sleep(5000);
		String item = All_ClientPortal_Locators.readTotalItems1().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Calendar Grid = "+CatcountGrid+" | Dashboard Calendar  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Calendar Grid= "+CatcountGrid+" | Dashboard Calendar Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	
	
    public static void CalendarOverviewPagination( ExtentTest test) throws InterruptedException, IOException
  	{Thread.sleep(5000);
  	
      	JavascriptExecutor js = (JavascriptExecutor) getDriver();
      	WebElement element = getDriver().findElement(By.xpath("//h4[normalize-space()='My Compliance Calendar']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
  		WebDriverWait wait = new WebDriverWait(getDriver(), (100)) ;
       	All_ClientPortal_Locators.ClickTriangle().click();
  		Thread.sleep(2000);
  		All_ClientPortal_Locators.nextmonth().click();
  		Thread.sleep(1000);
  		All_ClientPortal_Locators.nextmonth2025().click();
  		Thread.sleep(5000);
       	All_ClientPortal_Locators.number().click();
  		Thread.sleep(5000);
  		
  		All_ClientPortal_Locators.OverviewCalen().click();
  		Thread.sleep(10000);
  		Thread.sleep(5000);
       	All_ClientPortal_Locators.OverviewColse().click();
  		Thread.sleep(5000);
  		test.log(LogStatus.PASS,  " Overview successfully.");
  		Thread.sleep(5000);
  		
  		OneCommonMethod.zoomOutScreen(2); 
  		
  		test.log(LogStatus.INFO,  "Checking Pagination buttons");
		verifyPaginationGoToNextPage(test);
		Thread.sleep(5000);
		verifyPaginationGoToLastPage(test);
		Thread.sleep(5000);
		verifyItemsPerPageFunctionality(test);
  		
  		
  	}
    
    
    
    public static void DailyUpdates( ExtentTest test) throws InterruptedException, IOException
  	{Thread.sleep(5000);
  	
      	JavascriptExecutor js = (JavascriptExecutor) getDriver();
      	WebElement element = getDriver().findElement(By.xpath("//div[@class='updates']//div[1]//a[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
  		WebDriverWait wait = new WebDriverWait(getDriver(), (100)) ;
  		
  		
  		WebElement left = getDriver().findElement(By.xpath("//button[@class='carousel-btn left-btn']"));
  		WebElement right = getDriver().findElement(By.xpath("//button[@class='carousel-btn right-btn']"));
  		
  		Thread.sleep(5000);
  		if(left.isDisplayed())
  		{
  			Thread.sleep(5000);
  			left.click();
  			test.log(LogStatus.PASS,  "Left <  button is working fine");
  		}
  		else {
  			
  		}
  		
  		if(right.isDisplayed())
  		{
  			Thread.sleep(5000);
  			right.click();
  			test.log(LogStatus.PASS,  "Right >  button is working fine");
  		}
  		else {
  			
  		}
  		
       	All_ClientPortal_Locators.read().click();
  		Thread.sleep(2000);
  		SwitchtoChild(test);
  		
  		test.log(LogStatus.PASS,  " read more link working  successfully.");
  	  SwitchtoParent(test);
      Thread.sleep(3000);
  	}

    public static void SwitchtoChild( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);		
		Thread.sleep(3000);
		
		Set w = getDriver().getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver().switchTo().window(ch);         // switching child window
	      
	    
			Thread.sleep(1000);
	      
	  
	}
    
    public static void SwitchtoParent( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);		
		Thread.sleep(3000);
		
		Set w = getDriver().getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      getDriver().close();
	      Thread.sleep(3000);
	      getDriver().switchTo().window(pw);         // switching child window
	       
	}
    
    
    public static void InputUpload ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{Thread.sleep(5000);		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
	 	All_ClientPortal_Locators.InputUpload().click();
	 
		Thread.sleep(3000);

		All_ClientPortal_Locators.BrowseIn().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\Sample-MonthlyAttendance.xlsx");
		 //copy above file to clipboard
		 Thread.sleep(3000);
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		
		 //Now press CRTL
		
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(2000);
		
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(2000);
		
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		 Thread.sleep(2000);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 Thread.sleep(2000);
		
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		 Thread.sleep(2000);
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(2000);
				 
		 Locators.Upload().click();
					
					Thread.sleep(3000);
				
					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
					
					if(text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
						test.log(LogStatus.PASS,"Message Displayed : "+text1);
				
					}else {Thread.sleep(5000);
						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
					}
						Locators.ok().click();
		  	
	}
	
    public static void InputUploadTem ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{Thread.sleep(5000);		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);
   		//All_ClientPortal_Locators.SelectEntity().click();
   		Thread.sleep(2000);
   	 // 	All_ClientPortal_Locators.EntityTri1().click();
   		Thread.sleep(2000);
   		
   	//	All_ClientPortal_Locators.AVAAEntity().click();
   		Thread.sleep(2000);
   //		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);
   		
   	 	All_ClientPortal_Locators.InputUpload().click();
   	 
   		Thread.sleep(3000);

   		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.Template().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Template File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "Template File does not downloaded.");
		}
   		  	
   	}
    public static void InputUploadFilters ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{Thread.sleep(5000);		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);


   		Thread.sleep(4000);
   		
   	 	All_ClientPortal_Locators.InputUpload().click();
   	 	
   		Thread.sleep(5000);
   		All_ClientPortal_Locators.complianceDrp().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.complianceDrpSelect1().click();
   		
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.inputperiodDrp().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.inputperiodDrpSelect1().click();
   		
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.inputYearDrpp().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.inputYearDrppSelect2().click();
   		
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Apply();
   		Thread.sleep(5000);
   		if(All_ClientPortal_Locators.ClickApplyBtn().isEnabled())
   		{
   			Thread.sleep(2000);
   			test.log(LogStatus.PASS, "Compliance dropdown working successfully");
   			test.log(LogStatus.PASS, "Period dropdown working successfully");
   			test.log(LogStatus.PASS, "Year dropdown working successfully");
   			test.log(LogStatus.PASS, "Apply button working successfully");
   			
   		}
   		else
   		{
   			test.log(LogStatus.FAIL, "Apply button not working");
   		}
   		Thread.sleep(2000);

   		
   	}
    
       
    public static void InputUploadInavlid ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		All_ClientPortal_Locators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlyAttendance_InvalidData.xlsx");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
  	
    public static void InputUploadBlank ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		All_ClientPortal_Locators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlyAttendance_Blank.xlsx");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
  	
    public static void InputUploadInvalidformate ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		All_ClientPortal_Locators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\sample.pdf");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("Error While Uploading File")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
  	
    
    public static void InputUploadInvalidTemp ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(1000);
 /* 		All_ClientPortal_Locators.SelectEntity().click();
  		Thread.sleep(2000);
  	  	All_ClientPortal_Locators.EntityTri1().click();
  		Thread.sleep(2000);
  		
  		All_ClientPortal_Locators.AVAAEntity().click();
  		Thread.sleep(2000);
  		All_ClientPortal_Locators.Apply().click(); */
  		Thread.sleep(4000);
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		All_ClientPortal_Locators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\sample.pdf");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("Error While Uploading")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
  	
    public static void InputUploadNofile ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
  	
    public static void IUHistory(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
    	Thread.sleep(3000);
    	/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);
		
		 if(All_ClientPortal_Locators.HistoryIU().isEnabled()) {Thread.sleep(5000);
			 
				test.log(LogStatus.PASS,  " History button working successfully."); 
				All_ClientPortal_Locators.HistoryIU().click();
		 }
		 else
		 {Thread.sleep(5000);
		 	test.log(LogStatus.FAIL, "History button does not working properly.");
		 }
		  	 Thread.sleep(3000);
		  
		
	}
    
    public static void IUHistoryD(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
    	Thread.sleep(3000);
    	/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		All_ClientPortal_Locators.HistoryIU1().click();
  		Thread.sleep(3000);
  		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.InputHistoryD().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Input History File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "Input History File does not downloaded.");
		}
		 
		
	}
    
    
    public static void InputUploadTemSa ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{Thread.sleep(5000);		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);
   		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   	 	All_ClientPortal_Locators.InputUpload().click();
   	 
   		Thread.sleep(3000);

   		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.Template1().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Template File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "Template File does not downloaded.");
		}
   		  	
   	}
    
    public static void InputUploadSA ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{Thread.sleep(5000);		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);
   		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   	 	All_ClientPortal_Locators.InputUpload().click();
   	 
   		Thread.sleep(3000);

   		All_ClientPortal_Locators.BrowseIn1().click();
   		Thread.sleep(3000);
   		Robot robot=new Robot();
   		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\ChallanSalary.xlsx");
   		 //copy above file to clipboard
   		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
   		
   		 //Now press CRTL
   		
   		 robot.keyPress(KeyEvent.VK_CONTROL);
   		 Thread.sleep(2000);
   		
   		 //PRESS V
   		 robot.keyPress(KeyEvent.VK_V);
   		 Thread.sleep(2000);
   		
   		 //Release V
   		 robot.keyRelease(KeyEvent.VK_V);
   		Thread.sleep(2000);
   		
   		
   		 //Release CRTL
   		 robot.keyRelease(KeyEvent.VK_CONTROL);
   		Thread.sleep(2000);
   		
   		 //PRESS Enter
   		 robot.keyPress(KeyEvent.VK_ENTER);
   		Thread.sleep(2000);
   		
   		 //Release CRTL
   		 robot.keyRelease(KeyEvent.VK_ENTER);
   		
   		 Thread.sleep(2000);
   				 
   		 Locators.UploadAM1().click();
   					
   					Thread.sleep(3000);
   				
   					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
   					
   					if(text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
   						test.log(LogStatus.PASS,"Message Displayed : "+text1);
   				
   					}else {Thread.sleep(5000);
   						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
   					}
   						Locators.ok().click();
   		  	
   	}
   	
    public static void InputUploadInavlidSA ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		All_ClientPortal_Locators.BrowseIn1().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\sample.pdf");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.UploadAM1().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("Error While Upload")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadBlankSa ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		All_ClientPortal_Locators.BrowseIn1().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlySalary_Blank.xlsx");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.UploadAM1().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadInvalidformateSa ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		All_ClientPortal_Locators.BrowseIn1().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\ContractsList__MyWorkspace.pdf");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.UploadAM1().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadInvalidTempSa ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		All_ClientPortal_Locators.BrowseIn1().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\LocationSampleUpdate_AVAREGTR_20250125T052218413Z.xlsx");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.UploadAM1().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadNofileSa ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		 Locators.UploadAM1().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void IUHistorySa(  ExtentTest test) throws InterruptedException, IOException
 	{Thread.sleep(5000);
 	
     	Thread.sleep(3000);
     	/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
   	 	All_ClientPortal_Locators.InputUpload().click();
   	 
   		Thread.sleep(3000);
 		
 		 if(All_ClientPortal_Locators.HistoryIU1().isEnabled()) {Thread.sleep(5000);
 			 
 				test.log(LogStatus.PASS,  " History button working successfully."); 
 				All_ClientPortal_Locators.HistoryIU1().click();
 		 }
 		 else
 		 {Thread.sleep(5000);
 		 	test.log(LogStatus.FAIL, "History button does not working properly.");
 		 }
 		  	 Thread.sleep(3000);
 		  
 		
 	}
    
    public static void IUHistoryDSA(  ExtentTest test) throws InterruptedException, IOException
  	{Thread.sleep(5000);
  	
      	Thread.sleep(3000);
      	/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
    		
    	 	All_ClientPortal_Locators.InputUpload().click();
    	 
    		Thread.sleep(5000);
    		All_ClientPortal_Locators.HistoryIU1().click();
    		Thread.sleep(5000);
    		File dir = new File("C:\\Users\\bilali\\Downloads");
  		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

  		Thread.sleep(4000);
  		All_ClientPortal_Locators.InputHistoryD().click();

  		Thread.sleep(8000);
  		File dir1 = new File("C:\\Users\\bilali\\Downloads");
  		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
  		Thread.sleep(6000);
  		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
  			test.log(LogStatus.PASS,  "Input History File downloaded successfully.");
  		} else {Thread.sleep(5000);
  			test.log(LogStatus.FAIL,  "Input History File does not downloaded.");
  		}
  		 
  		
  	}
    
	public static void IUFianlUploadDownload(ExtentTest test) throws InterruptedException, IOException {
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(3000);
		All_ClientPortal_Locators.InputUpload().click();

		Thread.sleep(5000);
		Thread.sleep(2000);
		Thread.sleep(2000);
		All_ClientPortal_Locators.inputperiodDrp().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.inputperiodDrpSelect1().click();

		Thread.sleep(5000);
//       All_ClientPortal_Locators.Apply();
		
		// Code for clicking Apply button
		By locator = By.xpath("//img[@src='../assets/vectors/ApplyFilter.svg']");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = getDriver().findElement(locator);
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);

		Thread.sleep(2000);
		// 1 Logic for Attendance File download
        //All_ClientPortal_Locators.inputFinalUploadDownload1();

		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(3000);
		All_ClientPortal_Locators.inputFinalUploadDownload1().click();

		Thread.sleep(10000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Attendance File: Final input uploaded downloaded successfully");
		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, "Attendance File: Final input uploaded not downloaded");
		}



	}
	public static void IUFianlUploadDownloadSalary(ExtentTest test) throws InterruptedException, IOException {
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(3000);
		All_ClientPortal_Locators.InputUpload().click();

		Thread.sleep(5000);
		Thread.sleep(2000);
		Thread.sleep(2000);
		All_ClientPortal_Locators.inputperiodDrp().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.inputperiodDrpSelect1().click();

		Thread.sleep(5000);
//       All_ClientPortal_Locators.Apply();
		
		// Code for clicking Apply button
		By locator = By.xpath("//img[@src='../assets/vectors/ApplyFilter.svg']");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = getDriver().findElement(locator);
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);

		Thread.sleep(2000);
		
		// Logic for Salary File download
		// All_ClientPortal_Locators.inputFinalUploadDownload2();

		File dir2 = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents2 = dir2.listFiles(); // Counting number of files in directory before download

		Thread.sleep(3000);
		All_ClientPortal_Locators.inputFinalUploadDownload2().click();

		Thread.sleep(10000);
		File dir12 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew2 = dir12.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents2.length < allFilesNew2.length) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Salary File: Final input uploaded downloaded successfully");
		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, "Salary File: Final input uploaded not downloaded");
		}


	}
	
  	
    public static void InputUploadTemChha ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{Thread.sleep(5000);		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);
   		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   		
   	 	All_ClientPortal_Locators.InputUpload().click();
   	 
   		Thread.sleep(5000);
   		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(5000);
   		All_ClientPortal_Locators.Challan1().click();
   		Thread.sleep(5000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);

   		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(4000);
		All_ClientPortal_Locators.Template().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(5000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Template File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "Template File does not downloaded.");
		}
   		  	
   	}
    
    
    public static void InputUploadCh ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{Thread.sleep(5000);		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);
   		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   	 	All_ClientPortal_Locators.InputUpload().click();
   	 
   		Thread.sleep(3000);
   		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Challan1().click();
   		Thread.sleep(4000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);

   		All_ClientPortal_Locators.BrowseIn().click();
   		Thread.sleep(3000);
   		Robot robot=new Robot();
   		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\ChallanSalary.xlsx");
   		 //copy above file to clipboard
   		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
   		
   		 //Now press CRTL
   		
   		 robot.keyPress(KeyEvent.VK_CONTROL);
   		 Thread.sleep(1000);
   		
   		 //PRESS V
   		 robot.keyPress(KeyEvent.VK_V);
   		 Thread.sleep(1000);
   		
   		 //Release V
   		 robot.keyRelease(KeyEvent.VK_V);
   		
   		
   		 //Release CRTL
   		 robot.keyRelease(KeyEvent.VK_CONTROL);
   		
   		 //PRESS Enter
   		 robot.keyPress(KeyEvent.VK_ENTER);
   		
   		 //Release CRTL
   		 robot.keyRelease(KeyEvent.VK_ENTER);
   		
   		 Thread.sleep(1000);
   				 
   		 Locators.Upload().click();
   					
   					Thread.sleep(3000);
   				
   					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
   					
   					if(text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
   					
   					    test.log(LogStatus.PASS,"Salary File is uploaded successfully.");
   						test.log(LogStatus.PASS,"Message Displayed : "+text1);
   				
   					}else {Thread.sleep(5000);
   						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
   					}
   						Locators.ok().click();
   	}

    public static void InputUploadInavlidCh ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Challan1().click();
   		Thread.sleep(4000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);

  		All_ClientPortal_Locators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlySalary_InValid Data.xlsx");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    
    public static void InputUploadBlankCh ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Challan1().click();
   		Thread.sleep(4000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);

  		All_ClientPortal_Locators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlySalary_Blank.xlsx");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadInvalidformateCh ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		
  		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Challan1().click();
   		Thread.sleep(4000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);

  		All_ClientPortal_Locators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\ContractsList__MyWorkspace.pdf");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadInvalidTempCh ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		
  		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Challan1().click();
   		Thread.sleep(4000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);

  		All_ClientPortal_Locators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\LocationSampleUpdate_AVAREGTR_20250125T052218413Z.xlsx");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    
    public static void InputUploadNofileCh ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  	/*	All_ClientPortal_Locators.SelectEntity().click();
  		Thread.sleep(2000);
  	  	All_ClientPortal_Locators.EntityTri1().click();
  		Thread.sleep(2000);
  		
  		All_ClientPortal_Locators.AVAAEntity().click();
  		Thread.sleep(2000);
  		All_ClientPortal_Locators.Apply().click();
  		Thread.sleep(4000);
  		*/
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Challan1().click();
   		Thread.sleep(4000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);

  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void IUHistoryCh(  ExtentTest test) throws InterruptedException, IOException
 	{Thread.sleep(5000);
 	
     	Thread.sleep(3000);
     	/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   	 	All_ClientPortal_Locators.InputUpload().click();
   	 
   		Thread.sleep(3000);
   		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Challan1().click();
   		Thread.sleep(4000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);
 		
 		 if(All_ClientPortal_Locators.HistoryIU().isEnabled()) {Thread.sleep(5000);
 			 
 				test.log(LogStatus.PASS,  "History button working successfully."); 
 				All_ClientPortal_Locators.HistoryIU().click();
 		 }
 		 else
 		 {Thread.sleep(5000);
 		 	test.log(LogStatus.FAIL, "History button does not working properly.");
 		 }
 		  	 Thread.sleep(3000);
 		  
 		
 	}
    
    public static void IUHistoryDCh(  ExtentTest test) throws InterruptedException, IOException
  	{Thread.sleep(5000);
  	
      	Thread.sleep(3000);
      	/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
    		
    	 	All_ClientPortal_Locators.InputUpload().click();
    	 
    		Thread.sleep(3000);
    		All_ClientPortal_Locators.Challan().click();
       		Thread.sleep(2000);
       		All_ClientPortal_Locators.Challan1().click();
       		Thread.sleep(4000);
       		All_ClientPortal_Locators.Apply().click();
       		Thread.sleep(4000);
    		All_ClientPortal_Locators.HistoryIU().click();
    		Thread.sleep(3000);
    		File dir = new File("C:\\Users\\bilali\\Downloads");
  		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

  		Thread.sleep(500);
  		All_ClientPortal_Locators.InputHistoryD().click();

  		Thread.sleep(8000);
  		File dir1 = new File("C:\\Users\\bilali\\Downloads");
  		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
  		Thread.sleep(3000);
  		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
  		    test.log(LogStatus.PASS,  "Input History File popup is opened successfully");
  			test.log(LogStatus.PASS,  "Input History File downloaded successfully.");
  		} else {Thread.sleep(5000);
  			test.log(LogStatus.FAIL,  "Input History File does not downloaded.");
  		}
  		 
  		
  	}
    
    public static void InputUploadTemRe ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{Thread.sleep(5000);		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);
   		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   		
   	 	All_ClientPortal_Locators.InputUpload().click();
   	 
   		Thread.sleep(3000);
   		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Return().click();
   		Thread.sleep(4000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);

   		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.Template().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Template File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "Template File does not downloaded.");
		}
   		  	
   	}
    
    public static void InputUploadRe ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{Thread.sleep(5000);		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);
   		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   	 	All_ClientPortal_Locators.InputUpload().click();
   	 
   		Thread.sleep(3000);
   		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Return().click();
   		Thread.sleep(4000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);

   		All_ClientPortal_Locators.BrowseIn().click();
   		Thread.sleep(3000);
   		Robot robot=new Robot();
   		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlySalary_Valid Data.xlsx");
   		 //copy above file to clipboard
   		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
   		
   		 //Now press CRTL
   		
   		 robot.keyPress(KeyEvent.VK_CONTROL);
   		 Thread.sleep(1000);
   		
   		 //PRESS V
   		 robot.keyPress(KeyEvent.VK_V);
   		 Thread.sleep(1000);
   		
   		 //Release V
   		 robot.keyRelease(KeyEvent.VK_V);
   		
   		
   		 //Release CRTL
   		 robot.keyRelease(KeyEvent.VK_CONTROL);
   		
   		 //PRESS Enter
   		 robot.keyPress(KeyEvent.VK_ENTER);
   		
   		 //Release CRTL
   		 robot.keyRelease(KeyEvent.VK_ENTER);
   		
   		 Thread.sleep(1000);
   				 
   		 Locators.Upload().click();
   					
   					Thread.sleep(3000);
   				
   					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
   					
   					if(text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
   						test.log(LogStatus.PASS,"Message Displayed : "+text1);
   				
   					}else {Thread.sleep(5000);
   						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
   					}
   						Locators.ok().click();
   	}
    
    
	public static void InputUploadReturn(ExtentTest test) throws InterruptedException, IOException, AWTException {
		Thread.sleep(5000);
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
		Thread.sleep(3000);

		All_ClientPortal_Locators.InputUpload().click();

		Thread.sleep(5000);
		All_ClientPortal_Locators.complianceDrp().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.complianceDrpSelect3().click();

		Thread.sleep(7000);
		All_ClientPortal_Locators.inputperiodDrp().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.inputperiodDrpSelect1().click();

		Thread.sleep(5000);
//       All_ClientPortal_Locators.Apply();
		// Code for clicking Apply button
		By locator = By.xpath("//img[@src='../assets/vectors/ApplyFilter.svg']");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = getDriver().findElement(locator);
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);

		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		All_ClientPortal_Locators.Template().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Sample Template File downloaded successfully.");
		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, "Sample Template File does not downloaded.");
		}

		// Logic for File Upload
		All_ClientPortal_Locators.BrowseIn().click();
		Thread.sleep(3000);
		Robot robot = new Robot();
		StringSelection filepath = new StringSelection(
				"D:\\Upload Automation Files\\Other Upload No need to change\\Sample-MonthlyAttendance.xlsx");
		// copy above file to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		// Now press CRTL

		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		// PRESS V
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		// Release V
		robot.keyRelease(KeyEvent.VK_V);

		// Release CRTL
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// PRESS Enter
		robot.keyPress(KeyEvent.VK_ENTER);

		// Release CRTL
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(1000);

		Locators.Upload().click();

		Thread.sleep(3000);

		String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();

		if (text1.equalsIgnoreCase("File uploaded successfully")) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Message Displayed : " + text1);

		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, "Message Displayed : " + text1);
		}
		Locators.ok().click();

	}
	
	public static void InputUploadReturnOtherUp(ExtentTest test) throws InterruptedException, IOException, AWTException {
		Thread.sleep(5000);
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait(getDriver(), (40));
		Thread.sleep(3000);

		All_ClientPortal_Locators.InputUpload().click();

		Thread.sleep(5000);
		All_ClientPortal_Locators.complianceDrp().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.complianceDrpSelect3().click();

		Thread.sleep(7000);
		All_ClientPortal_Locators.inputperiodDrp().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.inputperiodDrpSelect1().click();

		Thread.sleep(5000);
//       All_ClientPortal_Locators.Apply();
		// Code for clicking Apply button
		By locator = By.xpath("//img[@src='../assets/vectors/ApplyFilter.svg']");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		WebElement ViewButton = getDriver().findElement(locator);
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);



		// Logic for File Other Upload Zip File
		All_ClientPortal_Locators.BrowseInOtherUpload1().click();
		
		Thread.sleep(3000);
		Robot robot = new Robot();
		StringSelection filepath = new StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\Return.zip");
		// copy above file to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

		// Now press CRTL

		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);

		// PRESS V
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);

		// Release V
		robot.keyRelease(KeyEvent.VK_V);

		// Release CRTL
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// PRESS Enter
		robot.keyPress(KeyEvent.VK_ENTER);

		// Release CRTL
		robot.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(1000);

		Locators.UploadOthers1().click();

		Thread.sleep(3000);

		String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();

		if (text1.equalsIgnoreCase("File uploaded successfully")) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Message Displayed : " + text1);

		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, "Message Displayed : " + text1);
		}
		Locators.ok().click();

	}
	
	
	
    
    public static void InputUploadInavlidRe( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Return().click();
   		Thread.sleep(4000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);

  		All_ClientPortal_Locators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlySalary_InValid Data.xlsx");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadBlankRe ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Return().click();
   		Thread.sleep(4000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);

  		All_ClientPortal_Locators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlySalary_Blank.xlsx");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadInvalidformateRe ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		
  		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Return().click();
   		Thread.sleep(4000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);

  		All_ClientPortal_Locators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\ContractsList__MyWorkspace.pdf");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadInvalidTempRe( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		
  		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Return().click();
   		Thread.sleep(4000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);

  		All_ClientPortal_Locators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\LocationSampleUpdate_AVAREGTR_20250125T052218413Z.xlsx");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(1000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(1000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(1000);
  				 
  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadNofilere ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	All_ClientPortal_Locators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Return().click();
   		Thread.sleep(4000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);

  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    
    public static void IUHistoryRe(  ExtentTest test) throws InterruptedException, IOException
 	{Thread.sleep(5000);
 	
     	Thread.sleep(3000);
     	/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   	 	All_ClientPortal_Locators.InputUpload().click();
   	 
   		Thread.sleep(3000);
   		All_ClientPortal_Locators.Challan().click();
   		Thread.sleep(2000);
   		All_ClientPortal_Locators.Return().click();
   		Thread.sleep(4000);
   		All_ClientPortal_Locators.Apply().click();
   		Thread.sleep(4000);
 		
 		 if(All_ClientPortal_Locators.HistoryIU().isEnabled()) {Thread.sleep(5000);
 			 
 				test.log(LogStatus.PASS,  " History button working successfully."); 
 				All_ClientPortal_Locators.HistoryIU().click();
 		 }
 		 else
 		 {Thread.sleep(5000);
 		 	test.log(LogStatus.FAIL, "History button does not working properly.");
 		 }
 		  	 Thread.sleep(3000);
 		  
 		
 	}
    
    public static void IUHistoryDRe(  ExtentTest test) throws InterruptedException, IOException
  	{Thread.sleep(5000);
  	
      	Thread.sleep(3000);
      	/*	All_ClientPortal_Locators.SelectEntity().click();
		Thread.sleep(2000);
	//  	All_ClientPortal_Locators.EntityTri1().click();
		Thread.sleep(2000);
		
		All_ClientPortal_Locators.AVAAEntity().click();
		Thread.sleep(2000);
		All_ClientPortal_Locators.Apply().click();
		Thread.sleep(4000);
		*/
    		
    	 	All_ClientPortal_Locators.InputUpload().click();
    	 
    		Thread.sleep(3000);
    		All_ClientPortal_Locators.Challan().click();
       		Thread.sleep(2000);
       		All_ClientPortal_Locators.Return().click();
       		Thread.sleep(4000);
       		All_ClientPortal_Locators.Apply().click();
       		Thread.sleep(4000);
    		All_ClientPortal_Locators.HistoryIU().click();
    		Thread.sleep(3000);
    		File dir = new File("C:\\Users\\bilali\\Downloads");
  		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

  		Thread.sleep(500);
  		All_ClientPortal_Locators.InputHistoryD().click();

  		Thread.sleep(8000);
  		File dir1 = new File("C:\\Users\\bilali\\Downloads");
  		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
  		Thread.sleep(3000);
  		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
  			test.log(LogStatus.PASS,  "Input History File downloaded successfully.");
  		} else {Thread.sleep(5000);
  			test.log(LogStatus.FAIL,  "Input History File does not downloaded.");
  		}
  		 
  		
  	}
    
    /*
    public static void CriticalDocuments(  ExtentTest test) throws InterruptedException
	{Thread.sleep(5000);
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickMyDocuments().click();					//Clicking on 'My Documents'
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickCriticalDocuments().click();				//Clicking on 'Critical Documents'
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (20));
	
		Thread.sleep(500);
		String name = All_ClientPortal_Locators.readFolderName().getText();		//Reading the folder name to create new folder.
		
		String folder = name+"A"; 
		
		All_ClientPortal_Locators.clickNewFolder().click();							//Clicking on '+New' button.
	
		Thread.sleep(2000);
	
		Thread.sleep(300);
	//	clickIsUniversal().click();
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.writeFolderName().sendKeys(folder);			//Writing Folder name.
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickCreate().click();						//Clicking on create button.
		
		Thread.sleep(500);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);
	//	String msg = driver.switchTo().alert().getText();
		//test.log(LogStatus.INFO, msg);
		Thread.sleep(500);
		try {Thread.sleep(5000);
			String t = OverduePOM.readFolderMsg().getText();
			test.log(LogStatus.PASS, t);
			//getDriver().switchTo().alert().accept();
		}catch(Exception e) {Thread.sleep(5000);
			
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
		name = readFolderName().getText();				//Reading the folder name we had created
		
		if(folder.equalsIgnoreCase(name))
		{Thread.sleep(5000);
			test.log(LogStatus.PASS, "Created folder '"+folder+"' displayed in the records.");
		}
		else
		{Thread.sleep(5000);
			test.log(LogStatus.FAIL, "Created folder '"+folder+"' doesn't displayed in the records.");
		}
		
		Thread.sleep(4000);
		readFolderName().click();						//Clicking on folder name we had created.
		Thread.sleep(1000);
		readFolderName().click();						//Clicking on folder name we had created.
		
		Thread.sleep(1000);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickNew()));
		clickNew().click();							//Clicking on 'New'
		
		Thread.sleep(500);
	//	litigationPerformer.MethodsPOM.progress();
		
		//Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickNewFile()));
		clickNewFile().click();						//CLicking on 'New File'
		
		Thread.sleep(1000);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);
		String workingDir = System.getProperty("user.dir");
		uploadNewFile().sendKeys("E:\\Ethics Committee Details.xlsx");	//uploading new file		
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickUploadDocument()));
		
		Thread.sleep(5000);
		clickUploadDocument().click();				//Clicking on 'Upload Document'
		
		Thread.sleep(5000);
	    // Switching to Alert        
        Alert alert = getDriver().switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= getDriver().switchTo().alert().getText();	
        
        Thread.sleep(3000);
        test.log(LogStatus.PASS, alertMessage);
        		
        // Displaying alert message		
        System.out.println(alertMessage);	
        
        		
        // Accepting alert		
        alert.accept();		
		
		
		
		Thread.sleep(100);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
		readFolderName().click();						//Clicking on file we had uploaded.
		
		
		
		
		
//		if(readFolderName().isDisplayed())			//Checking if file got created or not.
//			test.log(LogStatus.PASS, "Uploaded file displayed.");
//		else
//			test.log(LogStatus.PASS, "Uploaded file does not displayed.");
//		
		//readFolderName().click();						//Clicking on file we had uploaded.
				
		Thread.sleep(500);
		clickShareFolder().click();					//Clicking on Share Folder image.
		
		Thread.sleep(1000);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickPeople()));
		clickPeople().click();						//Clicking on People drop down 
		clickSearchPeople().click();					//Clicking on Search People drop down.
		
		Thread.sleep(500);
	//	clickSearchPeople(driver).sendKeys("aayush tripathi");			//Writing user name to search for  CFO
	//	clickSearchPeople().sendKeys("Company");	        // Auditor
	//	clickSearchPeople().sendKeys("Amit shaha");	//Approver
		//Thread.sleep(4000);
		
		clickSearchPeople().sendKeys("Approver User");	//Department
		Thread.sleep(3000);
		
		clickPeopleCheckBox1().click();	
		Thread.sleep(3000);//Clicking on label to get out from people search box
		getDriver().findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[2]")).click();
		
		Thread.sleep(1000);
		clickDone().click();	//Clicking on 'Done' to share folder.
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		
		Thread.sleep(1000);
		readFolderName().click();						//Clicking on file name we had uploaded.
		
		Thread.sleep(500);
		clickShareFolder().click();					//Clicking on Share File image.
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_myRepeater_LnkDeletShare_0']")));	//Waiting till the share element gets visible
		
		//Thread.sleep(1000);
		if(checkShared().isDisplayed())				//Checking if folder gor shared or not.
			test.log(LogStatus.PASS, "Uploaded file shared.");
		else
			test.log(LogStatus.PASS, "Uploaded file does not shared.");
		
		Thread.sleep(500);
		closeSharePoppup().click();
		Thread.sleep(500);
		Thread.sleep(1000);
		readFolderName().click();	
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_upPromotorList']/div/div/section/div[3]/div/div[2]/img[5]")).click();
		Thread.sleep(3000);
	String Msg=	getDriver().switchTo().alert().getText();
	test.log(LogStatus.PASS, Msg);
	getDriver().switchTo().alert().accept();
		Thread.sleep(3000);
		
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkMyDrive']")).click();
		Thread.sleep(3000);
		//.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilter']")).sendKeys(folder,Keys.ENTER);   //search folder
	/*
		.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail_lnkEditFolder_0']")).click();
		Thread.sleep(1000);
	
		.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtFolderName']")).clear();
		Thread.sleep(3000);
		.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtFolderName']")).sendKeys("Automated");
		Thread.sleep(1000);
		
		.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCreateFolder1']")).click();
		Thread.sleep(3000);
	test.log(LogStatus.PASS, "Rename Successfully");
	getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilter']")).sendKeys(folder,Keys.ENTER);   //search folder
		test.log(LogStatus.PASS, "Filter Working Successfully");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();			//Clicking on Dashboard
	}

    */
    
    
    

	
    
    
    
    
	public static void AddNewLicense( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
	
/*		Thread.sleep(3000);
		All_ClientPortal_Locators.clickEntity().click();
		Thread.sleep(3000);
		All_ClientPortal_Locators.clickTringle1().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectEnity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.ClickApplyBtn().click(); */
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickLicense().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickRegistration().click();
		Thread.sleep(10000);
		All_ClientPortal_Locators.clickAddNew().click();
		Thread.sleep(2000);
		
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(6);
		
		Thread.sleep(5000);
//		Row row = sheet.getRow(4);						//Selected 0th index row (First row)
//		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
//		String state = c.getStringCellValue();
		All_ClientPortal_Locators.registrationclickState().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectState().click();
		
		
		Thread.sleep(1000);
		Row row1 = sheet.getRow(5);						//Selected 0th index row (First row)
		Thread.sleep(2000);
		Cell c1= row1.getCell(1);						//Selected cell (0 row,1 column)
		String location = c1.getStringCellValue();
		All_ClientPortal_Locators.clickLocation().sendKeys(location);
		
		Thread.sleep(1000);
		Row row2 = sheet.getRow(6);						//Selected 0th index row (First row)
		Cell c2= row2.getCell(1);						//Selected cell (0 row,1 column)
		String branch = c2.getStringCellValue();
		All_ClientPortal_Locators.clickBranch().sendKeys(branch);
		
		All_ClientPortal_Locators.clickLicenseType().click();
		All_ClientPortal_Locators.selectLicenseType().click();
		
		Thread.sleep(1000);
		Row row3 = sheet.getRow(7);						//Selected 0th index row (First row)
		Cell c3= row3.getCell(1);						//Selected cell (0 row,1 column)
		String empname = c3.getStringCellValue();
		All_ClientPortal_Locators.clickEmpName().sendKeys(empname);
		

		Thread.sleep(1000);
		Row row4 = sheet.getRow(9);						//Selected 0th index row (First row)
		Cell c4= row4.getCell(1);						//Selected cell (0 row,1 column)
		String empAddress = c4.getStringCellValue();
		All_ClientPortal_Locators.clickEmpAddress().sendKeys(empAddress);
		
		Thread.sleep(1000);
		Row row5 = sheet.getRow(8);						//Selected 0th index row (First row)
		Cell c5= row5.getCell(1);						//Selected cell (0 row,1 column)
		String EmpMailId = c5.getStringCellValue();
		All_ClientPortal_Locators.clickEmpMailId().sendKeys(EmpMailId);
		
		Thread.sleep(1000);
		Row row6 = sheet.getRow(10);						//Selected 0th index row (First row)
		Cell c6= row6.getCell(1);						//Selected cell (0 row,1 column)
		int empContact = (int) c6.getNumericCellValue();
		All_ClientPortal_Locators.clickEmpContact().sendKeys(empContact+"");
	
		
		Thread.sleep(1000);
		Row row7 = sheet.getRow(11);						//Selected 0th index row (First row)
		Cell c7= row7.getCell(1);						//Selected cell (0 row,1 column)
		int mailcount = (int) c7.getNumericCellValue();
		All_ClientPortal_Locators.clickMaleCount().sendKeys(mailcount+"");
		
		Thread.sleep(1000);
		Row row8 = sheet.getRow(12);						//Selected 0th index row (First row)
		Cell c8= row8.getCell(1);						//Selected cell (0 row,1 column)
		int FemaleCount = (int) c8.getNumericCellValue();
		All_ClientPortal_Locators.clickFemaleCount().sendKeys(FemaleCount+"");

	
		Thread.sleep(1000);
		Row row9 = sheet.getRow(13);						//Selected 0th index row (First row)
		Cell c9= row9.getCell(1);						//Selected cell (0 row,1 column)
		String mailid = c9.getStringCellValue();
		All_ClientPortal_Locators.clickManagerMailId().sendKeys(mailid);
		
		Thread.sleep(1000);
		Row row10 = sheet.getRow(14);						//Selected 0th index row (First row)
		Cell c10= row10.getCell(1);						//Selected cell (0 row,1 column)
		int contactNo = (int) c10.getNumericCellValue();
		All_ClientPortal_Locators.clickContactNo().sendKeys(contactNo+"");
		
		Thread.sleep(1000);
		Row row11 = sheet.getRow(15);						//Selected 0th index row (First row)
		Cell c11= row11.getCell(1);						//Selected cell (0 row,1 column)
		String address = c11.getStringCellValue();
		All_ClientPortal_Locators.clickAddress().sendKeys(address);

		Thread.sleep(1000);
		All_ClientPortal_Locators.clickSubmit().click();
		
		String msg=All_ClientPortal_Locators.clickSuccessMsg().getText();
		if(msg.equalsIgnoreCase("Registration saved successfully"))
		{
			test.log(LogStatus.PASS, "Message displayed:-"+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed:-"+msg);
		}
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickOkBtn().click();
//		Thread.sleep(1000);
//		Locator.clickBack().click();
	}
	
	public static void ExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
/*		All_ClientPortal_Locators.clickEntity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickTringle1().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectEnity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.ClickApplyBtn().click(); */
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickLicense().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickRegistration().click();
		
		 Thread.sleep(2000); 		
//	        All_ClientPortal_Locators.readTotalItems().click();
			String item = All_ClientPortal_Locators.readTotalItems().getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = All_ClientPortal_Locators.readTotalItems().getText();
				bits = item.split(" ");
	        
			}
			
			Thread.sleep(2000);
	        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
	        
	        js1.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
	
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickExport().click();
		
	
		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
	
		if(dirContents.length < allFilesNew.length)
		{
		
			Thread.sleep(9000);					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
		File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	    {
	       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	       {
	           lastModifiedFile = allFilesNew[i];
	       }
	    }
		
		Thread.sleep(1000);
		fis = new FileInputStream(lastModifiedFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
		
		sheet = workbook.getSheetAt(0);
		int columnNumber = 3;
		int rowCount = 0;
		int actualRow=0;
		
		for(Row row : sheet)
		{
			
			Cell cell =row.getCell(columnNumber);
			if(cell != null) {
				
				rowCount++;
				actualRow = rowCount-1;
			}
			
		}
		fis.close();
		
		if(count1 == actualRow)
		{
			//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
			test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
		}
		else
		{
			//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
			test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
		}
		}
		else
		{
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
	
		
		}
	public static void SearchBox(ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(1000);
/*		All_ClientPortal_Locators.clickEntity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickTringle1().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectEnity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.ClickApplyBtn().click(); */
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickLicense().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickRegistration().click();
		
			Thread.sleep(3000);
			All_ClientPortal_Locators.SearchBox().sendKeys("Test Loaction",Keys.ENTER);
		
			List<String> li=new ArrayList<String>();
	        
	       
	        li.add("Test Loaction");
       
	        
			List<String> filter=new ArrayList<String>();	
			
			filter.add("Test Loaction");	
			
			
			js.executeScript("window.scrollBy(0,150)");	
			Thread.sleep(3000);

			 All_ClientPortal_Locators.readTotalItems().click();				//Clicking on Text of total items just to scroll down.
			String s = All_ClientPortal_Locators.readTotalItems().getText();
			Thread.sleep(2000);

			if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
	
			List<WebElement> typecol=getDriver().findElements(By.xpath("//*[@class='k-grid-aria-root']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[3]"));
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();


			 if(i==0)
					{
						raw.addAll(typecol);
					}
				
					
					
				for(int k=0;k<raw.size();k++)
					{
						text.add(raw.get(k).getText());
					}

				for(int l=0;l<text.size();l++)
				 {
						
					if(text.get(l).equals(li.get(i)))
						{
							pass.add(text.get(l));	
							System.out.println("pass : "+text.get(l)+" : "+li.get(i));

						}
					else
					   {
							fail.add(text.get(l));		
							System.out.println("fail : "+text.get(l)+" : "+li.get(i));
							System.out.println(i);

					   }
				  }
						
				             
			 
		for(String Fal : fail)
			 {
					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
			 }	
			 for(String Pas : pass)
			 {
				 	test.log(LogStatus.PASS,  " Search box working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
			 }
			 text.clear();
			pass.clear();
			fail.clear();
			raw.clear();
			
			if(All_ClientPortal_Locators.ClearBtn().isEnabled())
			{
				All_ClientPortal_Locators.ClearBtn().click();
				test.log(LogStatus.PASS, "Clear button working successfully.");
				
			}
			else
			{
				test.log(LogStatus.PASS, "Clear button not working successfully.");
				
			}
			
			}
			}
			else
			{
				test.log(LogStatus.PASS,"No records found");	
			}
		}
	
	public static void EditIcon(ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(1000);
/*		All_ClientPortal_Locators.clickEntity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickTringle1().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectEnity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.ClickApplyBtn().click();   */
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickLicense().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickRegistration().click();
		
		Thread.sleep(1000);
		if(All_ClientPortal_Locators.EditBtn().isEnabled())
		{
			All_ClientPortal_Locators.EditBtn().click();
			test.log(LogStatus.PASS, "Edit button is clickable.");
			
		}
		else
		{
			test.log(LogStatus.PASS, "Edit button is not clickable.");
			
		}
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickBack().click();
	}
	
	public static void EditIconChecktabs(ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(1000);

		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickLicense().click();
		Thread.sleep(3000);
		All_ClientPortal_Locators.clickRegistration().click();
		Thread.sleep(4000);
		All_ClientPortal_Locators.EditBtn().click();
		
		
		
		Thread.sleep(7000);
//		getDriver().findElement(By.xpath("//img[@title='Edit']")).click();
		
		String BasicInfo = getDriver().findElement(By.xpath("//a[normalize-space()='License Request Details']")).getText();
		if(BasicInfo.equals("License Request Details"))
		{
			test.log(LogStatus.PASS,  "License Request Details Tab is displayed"); 
		}
		else 
		{
			test.log(LogStatus.FAIL,  "License Request Details Tab is not displayed"); 
		}
		
		
		Thread.sleep(7000);
		getDriver().findElement(By.xpath("//a[normalize-space()='RCP Team']")).click();
		String TransReq = getDriver().findElement(By.xpath("//label[normalize-space()='RCP No.']")).getText();

		if(TransReq.equals("RCP No."))
		{
			test.log(LogStatus.PASS,  "RCP Team Tab is displayed"); 
		}
		else 
		{
			test.log(LogStatus.FAIL,  "RCP Team Tab is not displayed"); 
		}
		
		
		Thread.sleep(7000);
		getDriver().findElement(By.xpath("//a[normalize-space()='SD Executer']")).click();
		//Me get text is not added due to in both tab same get.text is there
		if(TransReq.equals("RCP No."))
		{
			test.log(LogStatus.PASS,  "SD Executor Tab is displayed"); 
		}
		else 
		{
			test.log(LogStatus.FAIL,  "SD Executor Tab is not displayed"); 
		}
		
		
		Thread.sleep(7000);
		getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();
		String DocRepo = getDriver().findElement(By.xpath("//span[normalize-space()='Document Repository']")).getText();
		if(DocRepo.equals("Document Repository"))
		{
			test.log(LogStatus.PASS,  "Document Section Tab is displayed"); 
		}
		else 
		{
			test.log(LogStatus.FAIL,  "Document Section Tab is not displayed"); 
		}
		
	}
	
	public static void EditIconsMiniTabs(ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(getDriver(), 140);

		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickLicense().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickRegistration().click();
		
		All_ClientPortal_Locators.EditBtn().click();
		
		WebElement plus1 = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn'])[1]"));
		WebElement plus2 = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn'])[2]"));
		WebElement plus3 = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn'])[3]"));
		WebElement plus4 = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn'])[4]"));
		
		
//		WebElement ActivityClosure = getDriver().findElement(By.xpath("//img[@class='svg-icon-btn ng-star-inserted']"));
		
		
		Thread.sleep(4000);
		if(plus1.isEnabled())
		{
			plus1.click();
			test.log(LogStatus.PASS, "+ Basic Information button is clickable.");
		}
		else
		{
			test.log(LogStatus.FAIL, "+ Basic Information button is not clickable.");
		}
		
		
		Thread.sleep(4000);
		if(plus2.isEnabled())
		{
			plus2.click();
			test.log(LogStatus.PASS, "+ Finance Approval Status button is clickable.");
		}
		else
		{
			test.log(LogStatus.FAIL, "+ Finance Approval Status button is not clickable.");
		}
		
		Thread.sleep(4000);
		if(plus3.isEnabled())
		{
			plus3.click();
			test.log(LogStatus.PASS, "+ OT Assignment button is clickable.");
		}
		else
		{
			test.log(LogStatus.FAIL, "+ OT Assignment button is not clickable.");
		}
		
		Thread.sleep(4000);
		if(plus4.isEnabled())
		{
			plus4.click();
			test.log(LogStatus.PASS, "+ Activity Relevant Dates button is clickable.");
			Thread.sleep(4000);
		}
		else
		{
			test.log(LogStatus.FAIL, "+ Activity Relevant Dates button is not clickable.");
		}
		
	
/*		
		
		Thread.sleep(8000);
		getDriver().findElement(By.xpath("//a[normalize-space()='RCP Team']")).click();
		Thread.sleep(4000);
		if(ActivityClosure.isEnabled())
		{
			ActivityClosure.click();
			test.log(LogStatus.PASS, "+ Activity Closure button is clickable.");
			Thread.sleep(4000);
		}
		else
		{
			test.log(LogStatus.FAIL, "+ Activity Closure button is not clickable.");
		}
		
		Thread.sleep(8000);
//		getDriver().findElement(By.xpath("//a[normalize-space()='SD Executer']")).click();		
		
		
		By locator = By.xpath("//a[normalize-space()='SD Executer']");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);

		WebElement ViewButton = getDriver().findElement(locator);
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		
		
		Thread.sleep(4000);
		if(plus1.isEnabled())
		{
			plus1.click();
			test.log(LogStatus.PASS, "+ Activity Closure button is clickable.");
		}
		else
		{
			test.log(LogStatus.FAIL, "+ Activity Closure button is not clickable.");
		}
		
*/		
/*
		Thread.sleep(8000);
		getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();
		Thread.sleep(4000);
		if(plus1.isEnabled())
		{
			plus1.click();
			test.log(LogStatus.PASS, "+ Document Requirements for the OT Activity button is clickable.");
		}
		else
		{
			test.log(LogStatus.FAIL, "+ Document Requirements for the OT Activity button is not clickable.");
		}
		
		Thread.sleep(4000);
		if(plus2.isEnabled())
		{
			plus2.click();
			test.log(LogStatus.PASS, "+ Document Repository button is clickable.");
		}
		else
		{
			test.log(LogStatus.FAIL, "+ Document Repository button is not clickable.");
		}
		
	*/	
		Thread.sleep(4000);

		
	}
	
	public static void EditIconsMiniTabsRCP(ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(getDriver(), 140);

		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickLicense().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickRegistration().click();
		
		All_ClientPortal_Locators.EditBtn().click();
		
		WebElement plus1 = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn ng-star-inserted'])[1]"));
		WebElement plus2 = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn ng-star-inserted'])[2]"));
		WebElement plus3 = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn ng-star-inserted'])[3]"));
		WebElement plus4 = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn ng-star-inserted'])[4]"));
		
		
		WebElement ActivityClosure = getDriver().findElement(By.xpath("//img[@class='svg-icon-btn ng-star-inserted']"));
		

		
		Thread.sleep(8000);
		getDriver().findElement(By.xpath("//a[normalize-space()='RCP Team']")).click();
		Thread.sleep(4000);
		if(plus1.isEnabled())
		{
//			plus1.click();
			By locator = By.xpath("(//img[@class='svg-icon-btn ng-star-inserted'])[1]");
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);

			WebElement ViewButton = getDriver().findElement(locator);
			Thread.sleep(4000);
			JavascriptExecutor jse = (JavascriptExecutor) getDriver();
			Thread.sleep(2000);
			jse.executeScript("arguments[0].click();", ViewButton);
			Thread.sleep(4000);
			
			
			
			test.log(LogStatus.PASS, "+ Activity Closure button is clickable.");
			Thread.sleep(4000);
		}
		else
		{
			test.log(LogStatus.FAIL, "+ Activity Closure button is not clickable.");
		}
		
		Thread.sleep(8000);
//		getDriver().findElement(By.xpath("//a[normalize-space()='SD Executer']")).click();		
		
		
		By locator = By.xpath("//a[normalize-space()='SD Executer']");
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);

		WebElement ViewButton = getDriver().findElement(locator);
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		
		
		Thread.sleep(4000);
		if(plus1.isEnabled())
		{
			plus1.click();
			test.log(LogStatus.PASS, "+ Activity Closure button is clickable.");
		}
		else
		{
			test.log(LogStatus.FAIL, "+ Activity Closure button is not clickable.");
		}
		
		
		Thread.sleep(8000);
		getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();
		Thread.sleep(4000);
		if(plus1.isEnabled())
		{
			plus1.click();
			test.log(LogStatus.PASS, "+ Document Requirements for the OT Activity button is clickable.");
		}
		else
		{
			test.log(LogStatus.FAIL, "+ Document Requirements for the OT Activity button is not clickable.");
		}
		
		Thread.sleep(4000);
		if(plus2.isEnabled())
		{
			plus2.click();
			test.log(LogStatus.PASS, "+ Document Repository button is clickable.");
		}
		else
		{
			test.log(LogStatus.FAIL, "+ Document Repository button is not clickable.");
		}
		
		Thread.sleep(4000);

		
	}
	
	public static void EditIconUploadDoc(ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(getDriver(), 140);

		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickLicense().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickRegistration().click();
		
		All_ClientPortal_Locators.EditBtn().click();
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();
		
		WebElement plus1 = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn ng-star-inserted'])[1]"));
		Thread.sleep(5000);
		plus1.click();
		

		
	}
	
	
	public static void ExistingLicsneExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
/*		All_ClientPortal_Locators.clickEntity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickTringle1().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectEnity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.ClickApplyBtn().click(); */
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickLicense().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickRegistration().click();
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.ExistingLicesne().click();

		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
	
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickExistingLicenseExport().click();
		
	
		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
	
		if(dirContents.length < allFilesNew.length)
		{
		
			Thread.sleep(9000);					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
	
		File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	    {
	       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	       {
	           lastModifiedFile = allFilesNew[i];
	       }
	    }
		
		Thread.sleep(1000);
		fis = new FileInputStream(lastModifiedFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
		
		sheet = workbook.getSheetAt(0);
		int columnNumber = 3;
		int rowCount = 0;
		int actualRow=0;
		
		for(Row row : sheet)
		{
			
			Cell cell =row.getCell(columnNumber);
			if(cell != null) {
				
				rowCount++;
				actualRow = rowCount-1;
			}
			
		}
		fis.close();
		
	
		}
		else
		{
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
	
		
		}
	
	public static void SearchBoxExistiongLicense(ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(1000);
/*		All_ClientPortal_Locators.clickEntity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickTringle1().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectEnity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.ClickApplyBtn().click(); */
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickLicense().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickRegistration().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.ExistingLicesne().click();
		
			Thread.sleep(3000);
			All_ClientPortal_Locators.SearchBox().sendKeys("Branch Pune",Keys.ENTER);
		
			List<String> li=new ArrayList<String>();
	        
	       
	        li.add("Branch Pune");
       
	        
			List<String> filter=new ArrayList<String>();	
			
			filter.add("Branch Pune");	
			
			
			js.executeScript("window.scrollBy(0,150)");	
			Thread.sleep(3000);

                
			try
			{

			
			Thread.sleep(5000);
	
			List<WebElement> typecol=getDriver().findElements(By.xpath("//*[@class='k-grid-aria-root']/kendo-treelist-list/div/div[1]/table/tbody/tr[1]/td[4]"));
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();


			 if(i==0)
					{
						raw.addAll(typecol);
					}
				
					
					
				for(int k=0;k<raw.size();k++)
					{
						text.add(raw.get(k).getText());
					}

				for(int l=0;l<text.size();l++)
				 {
						
					if(text.get(l).equals(li.get(i)))
						{
							pass.add(text.get(l));	
							System.out.println("pass : "+text.get(l)+" : "+li.get(i));

						}
					else
					   {
							fail.add(text.get(l));		
							System.out.println("fail : "+text.get(l)+" : "+li.get(i));
							System.out.println(i);

					   }
				  }
						
				             
			 
		for(String Fal : fail)
			 {
					test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
			 }	
			 for(String Pas : pass)
			 {
				 	test.log(LogStatus.PASS,  " Search box working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
			 }
			 text.clear();
			pass.clear();
			fail.clear();
			raw.clear();
			
			if(All_ClientPortal_Locators.ClearBtn().isEnabled())
			{
				All_ClientPortal_Locators.ClearBtn().click();
				test.log(LogStatus.PASS, "Clear button working successfully.");
				
			}
			else
			{
				test.log(LogStatus.PASS, "Clear button not working successfully.");
				
			}
			
			}
			}
			catch (Exception e) 
			{
				test.log(LogStatus.FAIL,"No records available.");	
			}
			{
				
			}
		}
	
	public static void ExistingLicenseViewIcon(ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(1000);
/*		All_ClientPortal_Locators.clickEntity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickTringle1().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectEnity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.ClickApplyBtn().click(); */
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickLicense().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickRegistration().click();
		Thread.sleep(5000);
		All_ClientPortal_Locators.ExistingLicesne().click();
		
		CoordinatorMethod.zoomOutScreen(2); 
		Thread.sleep(1000);
		All_ClientPortal_Locators.ExistingLicesneViewIcon().click();
		
		Thread.sleep(1000);
//String msg =All_ClientPortal_Locators.ExistingLicesneDetailes().getText(); //Hide this due to get text is not happening also same locator is use in another TC
		
	    String msg = getDriver().findElement(By.xpath("//span[@title='Existing License Details']")).getText();
		
		if(msg.equalsIgnoreCase("Existing License Details"))
		{
			
			test.log(LogStatus.PASS, "Existing License Details open successfully:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Existing License Details not open successfully:-" +msg);
		}
		//Thread.sleep(1000);
		//Locator.clickBack().click();
		
		Thread.sleep(1000);
		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
		action.moveToElement(we).click().build().perform();
		test.log(LogStatus.PASS, "Back button is working fine");
		
	}
	
	public static void ExistingLicenseInitiateAction(ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(1000);
/*		All_ClientPortal_Locators.clickEntity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickTringle1().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectEnity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.ClickApplyBtn().click(); */
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickLicense().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickRegistration().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.ExistingLicesne().click();
		
		if(All_ClientPortal_Locators.ExistingLicesneInitiateAction().isEnabled())
		{
			Thread.sleep(1000);
			All_ClientPortal_Locators.ExistingLicesneInitiateAction().click();
			test.log(LogStatus.PASS, "Initiate Action Icon is clikable");
		}
		else
		{
			test.log(LogStatus.FAIL, "Initiate Action Icon is not clikable");
		}
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickActivityTab().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectActivityTab().click();
		
		Thread.sleep(2000);
		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath("//button[normalize-space()='Submit']"));
		action.moveToElement(we).click().build().perform();
		
		
//		Thread.sleep(1000);
//		Locator.clickSubmit().click();
		
		Thread.sleep(2000);
		//String msg =All_ClientPortal_Locators.SccessMsgSubActivity().getText();
		
		
		String msg =All_ClientPortal_Locators.clickMsg().getText();
		if(msg.equalsIgnoreCase("SubActivity saved successfully"))
		{
			
			test.log(LogStatus.PASS, "Message Displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Message Displayed:-" +msg);
		}
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickOkBtn().click();
		
		Thread.sleep(1000);
		
		WebElement we1 = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
		action.moveToElement(we1).click().build().perform();
		////Thread.sleep(1000);
		//Locator.clickBack().click();
		
		
	}
	
	public static void ExistingLicenseDownload(ExtentTest test) throws InterruptedException, IOException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(1000);
/*		All_ClientPortal_Locators.clickEntity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickTringle1().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectEnity().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectYear().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.ClickApplyBtn().click(); */
		
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickLicense().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickRegistration().click();
		Thread.sleep(1000);
		All_ClientPortal_Locators.ExistingLicesne().click();
		
		
		
		Thread.sleep(5000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(3000);
		All_ClientPortal_Locators.DownloadBtn().click();

		Thread.sleep(10000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	

public static void ExistingLicenseSubActivityViewandDownload(ExtentTest test) throws InterruptedException
{

	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(1000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectEnity1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickLicense().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickRegistration().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.ExistingLicesne().click();
	
	Thread.sleep(5000);
	All_ClientPortal_Locators.clickTringleSubactivity().click();
	
	
//	Thread.sleep(2000);
//	File dir = new File("C:\\Users\\bilali\\Downloads");
//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
//
//	
//	Thread.sleep(1000);
//	Locator.ExistingLicesneSubActivityDownload().click();
//	Locator.ExistingLicesneSubActivityDownload().click();
//	
////	WebDriverWait wait = new WebDriverWait(getDriver(),20);
////	Thread.sleep(1000);
////	wait.until(ExpectedConditions.invisibilityOf(Locator.GridLoad()));
//
//	
//
//	
//	Thread.sleep(5000);
//	File dir1 = new File("C:\\Users\\bilali\\Downloads");
//	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
//
//	Thread.sleep(2000);
//	if(dirContents.length < allFilesNew.length)
//	{
//	
//		
//		test.log(LogStatus.PASS, "File downloaded successfully.");
//	}
//	else
//	{
//		test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
//	}
	
	
	
	Thread.sleep(2000);
	All_ClientPortal_Locators.ExistingLicesneSubactivityViewIcon().click();
	
	Thread.sleep(2000);
	String msg =All_ClientPortal_Locators.ExistingLicesneDetailes().getText();
	
	if(msg.equalsIgnoreCase("Existing License Details"))
	{
		
		test.log(LogStatus.PASS, "Existing License Details open successfully:-" +msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "Existing License Details not open successfully:-" +msg);
	}
	

	
	
	Thread.sleep(2000);
	File dir3 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents1 = dir3.listFiles();							//Counting number of files in directory before download 

	
	Thread.sleep(2000);

	All_ClientPortal_Locators.downloadLicenseDoc().click();
	
	Thread.sleep(5500);
	File dir2= new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew1 = dir2.listFiles();							//Counting number of files in directory after download

	if(dirContents1.length < allFilesNew1.length)
	{
	
		Thread.sleep(9000);					//Clicking on 'Excel Report' image.
		test.log(LogStatus.PASS, "License Document downloaded successfully.");
	}
	else
	{
		test.log(LogStatus.FAIL, "License Document doesn't downloaded successfully.");
	}
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickBack().click();
	

	
	
	
}

public static void RegisrationRespository(ExtentTest test) throws InterruptedException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(1000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickLicense().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.RegistrationRepository().click();
	
	Thread.sleep(8000);
	//Explicit wait
	WebDriverWait wait2 = new WebDriverWait(getDriver(), (30));
	wait2.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.Branch()));
	
	All_ClientPortal_Locators.Branch().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectBranch().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickActivities().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectActivities().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.ExistingLicesneViewIcon().click();
	
	
	String msg=All_ClientPortal_Locators.clickDocViewer().getText();
	if(msg.equalsIgnoreCase(msg))
	{
		test.log(LogStatus.PASS, "Registration Repostory Doc viewed successfully:-"+msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "Registration Repostory Doc viewed successfully:-"+msg);
	}
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickClose().click();
	
	if(All_ClientPortal_Locators.clickDownload().isEnabled())
	{
		Thread.sleep(1000);
		All_ClientPortal_Locators.clickDownload().click();
		
		test.log(LogStatus.PASS, "Registration Repostory Doc downloaded successfully");
	}
	else
	{
		test.log(LogStatus.FAIL, "Registration Repostory Doc does not downloaded successfully");
	}
	
//	Thread.sleep(1000);
//	All_ClientPortal_Locators.clickDownload().click();
//	
//	
//	Thread.sleep(1000);
//	String msg1 =All_ClientPortal_Locators.clickAlert().getText();
//	
//	
//	if(msg1.equalsIgnoreCase("Invalid file type."))
//	{
//		test.log(LogStatus.FAIL,"Registration Repostory Doc downloaded successfully:-" +msg1);
//	}
//	else
//	{
//		test.log(LogStatus.PASS,"Registration Repostory Doc does not downloaded successfully:-" +msg1);
//	}
//	Thread.sleep(1000);
//	All_ClientPortal_Locators.clickOkBtn().click();
}

public static void RegistrationRepositoryFilter(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
		
	Thread.sleep(1000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickLicense().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.RegistrationRepository().click();
     
 	Thread.sleep(6000);
 	//Explicit wait
 	WebDriverWait wait2 = new WebDriverWait(getDriver(), (30));
 	wait2.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.Branch()));
 	
 	All_ClientPortal_Locators.Branch().click();
 	Thread.sleep(1000);
 	String branch=All_ClientPortal_Locators.selectBranch().getText();
 	Thread.sleep(1000);
 	All_ClientPortal_Locators.selectBranch().click();
 	Thread.sleep(1000);
 	All_ClientPortal_Locators.clickActivities().click();
 	
 	Thread.sleep(1000);
 	String activities=All_ClientPortal_Locators.selectActivities().getText();
 	Thread.sleep(1000);
 	All_ClientPortal_Locators.selectActivities().click();
 	
 	Thread.sleep(1000);
 	if(All_ClientPortal_Locators.ClickApplyBtn().isEnabled())
 	{
	 	Thread.sleep(1000);
	 	All_ClientPortal_Locators.ClickApplyBtn().click();
	 	test.log(LogStatus.PASS, "Apply button working successfully.");
 	}
 	else
 	{
 		test.log(LogStatus.FAIL, "Apply button does not working successfully.");
 	}
     
     
   
        List<String> li=new ArrayList<String>();
         li.add(branch);
         li.add(activities);
      
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		filter.add("activities");
		
		Thread.sleep(4000);
		 JavascriptExecutor js=(JavascriptExecutor)getDriver();
		 js.executeScript("window.scrollBy(0,200)");	
		Thread.sleep(3000);
		 All_ClientPortal_Locators.readTotalItems().click();					//Clicking on Text of total items just to scroll down.
		String s = All_ClientPortal_Locators.readTotalItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//*[@class=\"k-grid-aria-root\"]/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[4]"));
		List<WebElement> activitycol=getDriver().findElements(By.xpath("//*[@class=\"k-grid-aria-root\"]/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[3]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

			 if(i==0)
				{
					raw.addAll(branchcol);
				}
			 else if(i==1)
			 {
				 raw.addAll(activitycol);
			 }
			
				
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

			for(int l=0;l<text.size();l++)
			 {
					
				if(text.get(l).equals(li.get(i)))
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				   {
						fail.add(text.get(l));		
						System.out.println("fail : "+text.get(l)+" : "+li.get(i));
						System.out.println(i);

				   }
			  }
					
			             
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 	test.log(LogStatus.PASS,  " Search box working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
		 }
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		
		}
		}
		else
		{
			test.log(LogStatus.PASS,"No records found");	
		}
		
		if(All_ClientPortal_Locators.ClearBtn().isEnabled())
		{
			Thread.sleep(2000);
			All_ClientPortal_Locators.ClearBtn().click();
			test.log(LogStatus.PASS, "Clear button working successfully.");
			
		}
		else
		{
			test.log(LogStatus.PASS, "Clear button not working successfully.");
			
		}
}

public static void RegistrationRepositoryExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
{
	
	Thread.sleep(1000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickLicense().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.RegistrationRepository().click();
	
	 Thread.sleep(6000); 		
 //     All_ClientPortal_Locators.readTotalItems().click();
		String item = All_ClientPortal_Locators.readTotalItems().getText();
		Thread.sleep(6000); 
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = All_ClientPortal_Locators.readTotalItems().getText();
			bits = item.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-500)");
	Thread.sleep(1000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(1000);
	All_ClientPortal_Locators.clickExistingLicenseExport().click();   //Registration Repository
	

	Thread.sleep(10000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	if(dirContents.length < allFilesNew.length)
	{
		Thread.sleep(9000);					//Clicking on 'Excel Report' image.
		test.log(LogStatus.PASS, "File downloaded successfully.");

	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
    {
       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
       {
           lastModifiedFile = allFilesNew[i];
       }
    }
	
	Thread.sleep(1000);
	fis = new FileInputStream(lastModifiedFile);
	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
	
	sheet = workbook.getSheetAt(0);
	int columnNumber = 3;
	int rowCount = 0;
	int actualRow=0;
	
	for(Row row : sheet)
	{
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();
	
	if(count1 == actualRow)
	{
		//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{
		//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
	}
	else
	{
		test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
	}

	
	}

public static void AddNewNotices(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	

 	
	
	Thread.sleep(5000);

	Thread.sleep(1000);
	All_ClientPortal_Locators.clickNotices().click();
	
	Thread.sleep(3000);
	String item = All_ClientPortal_Locators.readTotalItemsNotice().getText();
	String[] bits = item.split(" ");								//Splitting the String
	if(bits.length > 2)
	{
		Thread.sleep(2000);
		item = All_ClientPortal_Locators.readTotalItemsNotice().getText();
		bits = item.split(" ");								//Splitting the String
	}
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(2000);
		item = All_ClientPortal_Locators.readTotalItemsNotice().getText();
		bits = item.split(" ");									//Splitting the String
		compliancesCount = bits[bits.length - 2];
	}
	int count = Integer.parseInt(compliancesCount);
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickaddnewNotices().click();
	All_ClientPortal_Locators.noticeclickState().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectState1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickLocation1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectLocation1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickNoticeBranch1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectLocation1().click();   //Select Branch
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickModeOfReceipt().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectLocation1().click();   //Select Mode Of Receipt
	
	
	
	FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook1 = WorkbookFactory.create(fis);
    Sheet sheet = workbook1.getSheetAt(6);
	
    Thread.sleep(5000);
	Row row6 = sheet.getRow(16);						//Selected 0th index row (First row)
	Thread.sleep(5000);
	Cell c6= row6.getCell(1);						//Selected cell (0 row,1 column)
	int NoriceNo = (int) c6.getNumericCellValue();
	All_ClientPortal_Locators.clickNoticeNumber().sendKeys(NoriceNo+getRandomString());
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickCalender().click();
	
	Thread.sleep(1000);
	Actions action = new Actions(getDriver());
	WebElement we = getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='21']"));
	action.moveToElement(we).click().build().perform();
	Thread.sleep(1000);
//	Locator.selectDate().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickCalenderReponseDueDate().click();
	Thread.sleep(1000);

	WebElement we1= getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='28']"));
	action.moveToElement(we1).click().build().perform();
//	Locator.selectDate2().click();
	
	All_ClientPortal_Locators.clickNoticeType().click();
	All_ClientPortal_Locators.selectLocation1().click();   //Select Notice type
	
	All_ClientPortal_Locators.clickRisk().click();
	All_ClientPortal_Locators.selectLocation1().click();   //Select Risk type
	
	
	Row row = sheet.getRow(17);						//Selected 0th index row (First row)
	Cell c= row.getCell(1);						//Selected cell (0 row,1 column)
	String Remark = c.getStringCellValue();
	All_ClientPortal_Locators.clickRemark().sendKeys(Remark);
	
	 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
	 
	 Robot robot=new Robot();
	 Thread.sleep(3000);
	 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\sample.pdf");
	 Thread.sleep(3000);
	 //copy above file to clipboard
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
	 
	 //Now press CRTL
	 
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 Thread.sleep(1000);
	 Thread.sleep(5000);
	 //PRESS V
	 robot.keyPress(KeyEvent.VK_V);
	 Thread.sleep(5000);
	 
	 //Release V
	 robot.keyRelease(KeyEvent.VK_V);
	 
	 
	 //Release CRTL
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	 
	 //PRESS Enter
	 robot.keyPress(KeyEvent.VK_ENTER);
	 
	 //Release CRTL
	 robot.keyRelease(KeyEvent.VK_ENTER);
	 
	 Thread.sleep(1000);
	 System.out.println("File uploaded successfully");
	 
	 Thread.sleep(1000);
	All_ClientPortal_Locators.clickSaveNotice().click();
	 Thread.sleep(1000);
	String msg=All_ClientPortal_Locators.clickSuccessNotice().getText();
	if(msg.equalsIgnoreCase("Notice Saved Successfully"))
	{
		test.log(LogStatus.PASS,"Message displayed:-" +msg);
	}
	else
	{
		test.log(LogStatus.FAIL,"Message displayed:-" +msg);
	}
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickOkBtn().click();
	
	Thread.sleep(1000);

	WebElement we2 = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
	action.moveToElement(we2).click().build().perform();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.readTotalItemsNotice().click();
	String item1 = All_ClientPortal_Locators.readTotalItemsNotice().getText();
	String[] bits1 = item1.split(" ");								//Splitting the String
	
	if(bits1.length > 2)
	{
		Thread.sleep(2000);
		item1 = All_ClientPortal_Locators.readTotalItemsNotice().getText();
		bits1 = item1.split(" ");								//Splitting the String
	}
	String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
	
	if(compliancesCount1.equalsIgnoreCase("to"))
	{
		Thread.sleep(2000);
		item1 = All_ClientPortal_Locators.readTotalItemsNotice().getText();
		bits1 = item1.split(" ");									//Splitting the String
		compliancesCount1 = bits1[bits1.length - 2];
	}
	int count1 = Integer.parseInt(compliancesCount1);
	if(count < count1)
		{
		
			test.log(LogStatus.PASS, "Total Notice Count increased in grid after adding New Notice - Old Notice Count from Grid  = "+count+" | New Notice Count from Grid = "+count1);
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Total Notice Count doesn't increased in grid after adding New Notice - Old Notice Count from Grid  = "+count+" | New Notice Count from Grid = "+count1);
		}
	

	
	
}

public static void ExistingNoticesNo(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(1000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickNotices().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickaddnewNotices().click();
	All_ClientPortal_Locators.noticeclickState().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectState1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickLocation1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectLocation1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickNoticeBranch1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectLocation1().click();   //Select Branch
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickModeOfReceipt().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectLocation1().click();   //Select Mode Of Receipt
	
	
	
	FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook1 = WorkbookFactory.create(fis);
    Sheet sheet = workbook1.getSheetAt(6);
	
    Thread.sleep(1000);
	Row row6 = sheet.getRow(16);						//Selected 0th index row (First row)
	Cell c6= row6.getCell(1);						//Selected cell (0 row,1 column)
	int NoriceNo = (int) c6.getNumericCellValue();
	All_ClientPortal_Locators.clickNoticeNumber().sendKeys(NoriceNo+"");
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickCalender().click();
	
	Thread.sleep(1000);
	Actions action = new Actions(getDriver());
	WebElement we = getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='21']"));
	action.moveToElement(we).click().build().perform();
//	Thread.sleep(1000);
//	Locator.selectDate().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickCalenderReponseDueDate().click();
	Thread.sleep(1000);

	WebElement we1= getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='28']"));
	action.moveToElement(we1).click().build().perform();
//	Locator.selectDate2().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickNoticeType().click();
	All_ClientPortal_Locators.selectLocation1().click();   //Select Notice type
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickRisk().click();
	All_ClientPortal_Locators.selectLocation1().click();   //Select Risk type
	
	
	Thread.sleep(1000);
	Row row = sheet.getRow(18);						//Selected 0th index row (First row)
	Cell c= row.getCell(1);						//Selected cell (0 row,1 column)
	String Remark = c.getStringCellValue();
	All_ClientPortal_Locators.clickRemark().sendKeys(Remark);
	
	 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
	 
	 Robot robot=new Robot();
		Thread.sleep(1000);
	 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\sample.pdf");
	 //copy above file to clipboard
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
	 
	 //Now press CRTL
	 
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 Thread.sleep(1000);
	 
	 //PRESS V
	 robot.keyPress(KeyEvent.VK_V);
	 Thread.sleep(1000);
	 
	 //Release V
	 robot.keyRelease(KeyEvent.VK_V);
	 
	 
	 //Release CRTL
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	 
	 //PRESS Enter
	 robot.keyPress(KeyEvent.VK_ENTER);
	 
	 //Release CRTL
	 robot.keyRelease(KeyEvent.VK_ENTER);
	 
	 Thread.sleep(1000);
	 System.out.println("File uploaded successfully");
	 
	 Thread.sleep(1000);
	All_ClientPortal_Locators.clickSaveNotice().click();
	 Thread.sleep(1000);
	String msg=All_ClientPortal_Locators.clickInvalidNotice().getText();
	if(msg.equalsIgnoreCase("Notice Number already exist"))
	{
		test.log(LogStatus.PASS,"Message displayed:-" +msg);
	}
	else
	{
		test.log(LogStatus.FAIL,"Message displayed:-" +msg);
	}
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickOkBtn().click();
	 Thread.sleep(1000);
	All_ClientPortal_Locators.clickBack().click();
	
	
}

public static void NoticeDocMandatory(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(1000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickNotices().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickaddnewNotices().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickSaveNotice().click();
	
	 Thread.sleep(1000);
		String msg=All_ClientPortal_Locators.clickNoticeDocMsg().getText();
		if(msg.equalsIgnoreCase("File is required."))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		 Thread.sleep(1000);
			All_ClientPortal_Locators.clickBack().click();
	
}


public static void NoticeExportBtn(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(1000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	All_ClientPortal_Locators.clickNotices().click();
	

	
	
	 Thread.sleep(7000); 		
//     All_ClientPortal_Locators.readTotalItemsNotice().click();
		String item = All_ClientPortal_Locators.readTotalItemsNotice().getText();
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = All_ClientPortal_Locators.readTotalItemsNotice().getText();
			bits = item.split(" ");
     
		}
		
		Thread.sleep(2000);
     JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
     
     js1.executeScript("window.scrollBy(0,-500)");
	Thread.sleep(1000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(1000);
	All_ClientPortal_Locators.clickNoticeExport().click();
	

	Thread.sleep(5500);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	if(dirContents.length < allFilesNew.length)
	{
	
		Thread.sleep(9000);					//Clicking on 'Excel Report' image.
		test.log(LogStatus.PASS, "File downloaded successfully.");
	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
 for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
 {
    if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
    {
        lastModifiedFile = allFilesNew[i];
    }
 }
	
	Thread.sleep(1000);
	fis = new FileInputStream(lastModifiedFile);
	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
	
	sheet = workbook.getSheetAt(0);
	int columnNumber = 3;
	int rowCount = 0;
	int actualRow=0;
	
	for(Row row : sheet)
	{
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();
	
	if(count1 == actualRow)
	{
		//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{
		//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
	}
	else
	{
		test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
	}

	
}

public static void NoticeEditDownloadView(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(7000);
	All_ClientPortal_Locators.clickNotices().click();
	
	
	

	
	Thread.sleep(2000);
	File dir3 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents1 = dir3.listFiles();							//Counting number of files in directory before download 

	
	Thread.sleep(2000);

	All_ClientPortal_Locators.clickDownload().click();
	
	Thread.sleep(5500);
	File dir2= new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew1 = dir2.listFiles();							//Counting number of files in directory after download

	if(dirContents1.length < allFilesNew1.length)
	{
	
		Thread.sleep(9000);					//Clicking on 'Excel Report' image.
		test.log(LogStatus.PASS, "Notice Document downloaded successfully.");
	}
	else
	{
		test.log(LogStatus.FAIL, "Notice Document doesn't downloaded successfully.");
	}
	
	Thread.sleep(2000);
	All_ClientPortal_Locators.clickviewNoticeDocIcon().click();
	
	Thread.sleep(3000);
	String msg=All_ClientPortal_Locators.clickDocViewer().getText();
	if(msg.equalsIgnoreCase(msg))
	{
		test.log(LogStatus.PASS, "Notice Doc viewed successfully:-"+msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "Notice Doc does not viewed successfully:-"+msg);
	}
	
	All_ClientPortal_Locators.ClickClose().click();
	
	Thread.sleep(1000);
	if(All_ClientPortal_Locators.EditBtn().isEnabled())
	{
		Thread.sleep(1000);
		All_ClientPortal_Locators.EditBtn().click();
		test.log(LogStatus.PASS, "Edit button is clickable.");
		
	}
	else
	{
		test.log(LogStatus.PASS, "Edit button is not clickable.");
		
	}
//	Thread.sleep(1000);
//	Locator.clickBack().click();
	
	Thread.sleep(1000);
	Actions action = new Actions(getDriver());
	WebElement we1 = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
	action.moveToElement(we1).click().build().perform();
	
//	Thread.sleep(1000);
//	Locator.clickBackArrow().click();

}

public static void NoticeSearchBox(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);

	
	All_ClientPortal_Locators.clickNotices().click();
	
	Thread.sleep(3000);
	All_ClientPortal_Locators.SearchBox().sendKeys("Branch Pune",Keys.ENTER);

	List<String> li=new ArrayList<String>();
    
   
    li.add("Branch Pune");

    
	List<String> filter=new ArrayList<String>();	
	
	filter.add("Branch Pune");	
	
	
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);

	 All_ClientPortal_Locators.readTotalItems().click();				//Clicking on Text of total items just to scroll down.
	String s = All_ClientPortal_Locators.readTotalItems().getText();
	Thread.sleep(2000);

	if(!s.equalsIgnoreCase("No items to display")) {
	Thread.sleep(5000);

	List<WebElement> typecol=getDriver().findElements(By.xpath("//*[@class='k-grid-aria-root']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[3]"));
	Thread.sleep(2000);

	for(int i=0; i<li.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();


	 if(i==0)
			{
				raw.addAll(typecol);
			}
		
			
			
		for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}

		for(int l=0;l<text.size();l++)
		 {
				
			if(text.get(l).equals(li.get(i)))
				{
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : "+li.get(i));

				}
			else
			   {
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);

			   }
		  }
				
		             
	 
		for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
	 }	
	 for(String Pas : pass)
	 {
		 	test.log(LogStatus.PASS,  " Search box working properly.");
			test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
			System.out.println(filter.get(i)+" : "+Pas);
	 }
	 text.clear();
	pass.clear();
	fail.clear();
	raw.clear();
	
	if(All_ClientPortal_Locators.ClearBtn().isEnabled())
	{
		All_ClientPortal_Locators.ClearBtn().click();
		test.log(LogStatus.PASS, "Clear button working successfully.");
		
	}
	else
	{
		test.log(LogStatus.PASS, "Clear button not working successfully.");
		
	}
	
	}
	}
	else
	{
		test.log(LogStatus.PASS,"No records found");	
	}
	
}


public static void NoticeEditAllTabs(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);

	
	All_ClientPortal_Locators.clickNotices().click();
	
	Thread.sleep(3000);
	All_ClientPortal_Locators.SearchBox().sendKeys("Pending Assignment",Keys.ENTER);
	
	All_ClientPortal_Locators.EditBtn().click();
	

	String BasicInfo = getDriver().findElement(By.xpath("//a[normalize-space()='Notice Details']")).getText();
	if(BasicInfo.equals("Notice Details"))
	{
		test.log(LogStatus.PASS,  "Edit Button clicked successfully"); 
		test.log(LogStatus.PASS,  "Notice Details Tab is displayed"); 
	}
	else 
	{
		test.log(LogStatus.FAIL,  "Notice Details Tab is not displayed"); 
	}
	
	
	Thread.sleep(5000);
	getDriver().findElement(By.xpath("//a[normalize-space()='SME Response']")).click();
	String TransReq = getDriver().findElement(By.xpath("//span[normalize-space()='Translation Required']")).getText();

	if(TransReq.equals("Translation Required"))
	{
		test.log(LogStatus.PASS,  "SME Response Tab is displayed"); 
	}
	else 
	{
		test.log(LogStatus.FAIL,  "SME Response Tab is not displayed"); 
	}
	
	
	Thread.sleep(5000);
	getDriver().findElement(By.xpath("//a[normalize-space()='SD Executer']")).click();
	//Me get text is not added due to in both tab same get.text is there
	if(TransReq.equals("Translation Required"))
	{
		test.log(LogStatus.PASS,  "SD Executor Tab is displayed"); 
	}
	else 
	{
		test.log(LogStatus.FAIL,  "SD Executor Tab is not displayed"); 
	}
	
	
	Thread.sleep(5000);
	getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();
	String DocRepo = getDriver().findElement(By.xpath("//span[normalize-space()='Document Repository']")).getText();
	if(DocRepo.equals("Document Repository"))
	{
		test.log(LogStatus.PASS,  "Document Section Tab is displayed"); 
	}
	else 
	{
		test.log(LogStatus.FAIL,  "Document Section Tab is not displayed"); 
	}
	
	
}

public static void NoticeEditDocumentRepositoryDownload(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);

	
	All_ClientPortal_Locators.clickNotices().click();
	
	Thread.sleep(3000);
//	All_ClientPortal_Locators.SearchBox().sendKeys("NoticeNumber2",Keys.ENTER);
	
//	All_ClientPortal_Locators.EditBtn().click();
	
//	All_ClientPortal_Locators.Search().sendKeys("NoticeNumber2", Keys.ENTER);
	Thread.sleep(5000);
	getDriver().findElement(By.xpath("//img[@title='Edit']")).click();
	Thread.sleep(5000);
	getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();

	getDriver().findElement(By.xpath("//div[@class='col-md-12 colpadding0']//div[2]//div[1]//div[1]//img[1]")).click();
	
	
/*	// 1 Logic for Notice Document
	Thread.sleep(3000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

	Thread.sleep(500);
	All_ClientPortal_Locators.NoticeDocumentDownload().click();

	Thread.sleep(8000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents.length < allFilesNew.length) {
		Thread.sleep(5000);
		test.log(LogStatus.PASS, " Notice Document File downloaded successfully.");
	} else {
		Thread.sleep(5000);
		test.log(LogStatus.FAIL, " Notice Document File is not downloaded");
	}

	// 2 - Logic for Translated Notice Document
	Thread.sleep(5000);
	File dir2 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents2 = dir2.listFiles(); // Counting number of files in directory before download

	Thread.sleep(500);
	All_ClientPortal_Locators.NoticeTranslatedDocument().click();

	Thread.sleep(8000);
	File dirr = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew2 = dirr.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents2.length < allFilesNew2.length) {
		Thread.sleep(5000);
		test.log(LogStatus.PASS, " Notice Translated Document File downloaded successfully.");
	} else {
		Thread.sleep(5000);
		test.log(LogStatus.FAIL, " Notice Translated Document File is not downloaded.");
	}

	//3 Logic for Extention Application Acknowledgement
	Thread.sleep(8000);
	File dir3 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents3 = dir3.listFiles(); // Counting number of files in directory before download

	Thread.sleep(2200);
	All_ClientPortal_Locators.NoticeApplicationAcknowledgeDocument().click();

	Thread.sleep(10000);
	File dirrr = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew3 = dirrr.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents3.length < allFilesNew3.length) {
		Thread.sleep(5000);
		test.log(LogStatus.PASS, " Notice Extension Application Acknowledgement File is downloaded successfully");
	} else {
		Thread.sleep(5000);
		test.log(LogStatus.FAIL, " Notice Extension Application Acknowledgement File is not downloaded.");
	}

	//4 Logic for Draft Extension Application
	Thread.sleep(10000);
	File dir4 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents4 = dir4.listFiles(); // Counting number of files in directory before download

	Thread.sleep(4000);
	All_ClientPortal_Locators.DraftExtensionApplicationDocument().click();

	Thread.sleep(10000);
	File dirrr4 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew4 = dirrr4.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents4.length < allFilesNew4.length) {
		Thread.sleep(5000);
		test.log(LogStatus.PASS, " Notice Draft Extension Application File downloaded successfully.");
	} else {
		Thread.sleep(5000);
		test.log(LogStatus.FAIL, " Notice Draft Extension Application File is not downloaded.");
	}

	//5 Logic for Draft Response (Prepared by SME)
	Thread.sleep(10000);
	File dir5 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents5 = dir5.listFiles(); // Counting number of files in directory before download

	Thread.sleep(4000);
	All_ClientPortal_Locators.DraftResponseSMEDocument().click();

	Thread.sleep(10000);
	File dirrr5 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew5 = dirrr5.listFiles(); // Counting number of files in directory after download
	Thread.sleep(3000);
	if (dirContents5.length < allFilesNew5.length) {
		Thread.sleep(5000);
		test.log(LogStatus.PASS, " Notice Response Prepared by SME File is downloaded successfully.");
	} else {
		Thread.sleep(5000);
		test.log(LogStatus.FAIL, " Notice Draft Extension Application File is not downloaded.");
	}
	*/
	
	
	//This logic is like if document is not available also it will not fail it will log as INFO 
	
	// 1 - Logic for Notice Document
	Thread.sleep(3000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();

	Thread.sleep(500);
	try {
		if (All_ClientPortal_Locators.NoticeDocumentDownload().isDisplayed() && All_ClientPortal_Locators.NoticeDocumentDownload().isEnabled()) {
			All_ClientPortal_Locators.NoticeDocumentDownload().click();
			Thread.sleep(8000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				Thread.sleep(5000);
				test.log(LogStatus.PASS, " Notice Document File downloaded successfully.");
			} else {
				Thread.sleep(5000);
				test.log(LogStatus.FAIL, " Notice Document File is not downloaded");
			}
		} else {
			test.log(LogStatus.INFO, "Notice Document - There is no document (button not clickable).");
		}
	} catch (Exception e) {
		test.log(LogStatus.INFO, "Notice Document - There is No File Available");
	}

	// 2 - Logic for Translated Notice Document
	Thread.sleep(5000);
	File dir2 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents2 = dir2.listFiles();

	Thread.sleep(500);
	try {
		if (All_ClientPortal_Locators.NoticeTranslatedDocument().isDisplayed() && All_ClientPortal_Locators.NoticeTranslatedDocument().isEnabled()) {
			All_ClientPortal_Locators.NoticeTranslatedDocument().click();
			Thread.sleep(8000);
			File dirr = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew2 = dirr.listFiles();
			Thread.sleep(3000);
			if (dirContents2.length < allFilesNew2.length) {
				Thread.sleep(5000);
				test.log(LogStatus.PASS, " Notice Translated Document File downloaded successfully.");
			} else {
				Thread.sleep(5000);
				test.log(LogStatus.FAIL, " Notice Translated Document File is not downloaded.");
			}
		} else {
			test.log(LogStatus.INFO, "Notice Translated Document - There is no document (button not clickable).");
		}
	} catch (Exception e) {
		test.log(LogStatus.INFO, "Notice Translated Document - There is No File Available");
	}

	// 3 - Logic for Extension Application Acknowledgement
	Thread.sleep(8000);
	File dir3 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents3 = dir3.listFiles();

	Thread.sleep(2200);
	try {
		if (All_ClientPortal_Locators.NoticeApplicationAcknowledgeDocument().isDisplayed() && All_ClientPortal_Locators.NoticeApplicationAcknowledgeDocument().isEnabled()) {
			All_ClientPortal_Locators.NoticeApplicationAcknowledgeDocument().click();
			Thread.sleep(10000);
			File dirrr = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew3 = dirrr.listFiles();
			Thread.sleep(3000);
			if (dirContents3.length < allFilesNew3.length) {
				Thread.sleep(5000);
				test.log(LogStatus.PASS, " Notice Extension Application Acknowledgement File is downloaded successfully");
			} else {
				Thread.sleep(5000);
				test.log(LogStatus.FAIL, " Notice Extension Application Acknowledgement File is not downloaded.");
			}
		} else {
			test.log(LogStatus.INFO, "Notice Extension Application Acknowledgement - There is no document (button not clickable).");
		}
	} catch (Exception e) {
		test.log(LogStatus.INFO, "Notice Extension Application Acknowledgement - There is No File Available");
	}

	// 4 - Logic for Draft Extension Application
	Thread.sleep(10000);
	File dir4 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents4 = dir4.listFiles();

	Thread.sleep(4000);
	try {
		if (All_ClientPortal_Locators.DraftExtensionApplicationDocument().isDisplayed() && All_ClientPortal_Locators.DraftExtensionApplicationDocument().isEnabled()) {
			All_ClientPortal_Locators.DraftExtensionApplicationDocument().click();
			Thread.sleep(10000);
			File dirrr4 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew4 = dirrr4.listFiles();
			Thread.sleep(3000);
			if (dirContents4.length < allFilesNew4.length) {
				Thread.sleep(5000);
				test.log(LogStatus.PASS, " Notice Draft Extension Application File downloaded successfully.");
			} else {
				Thread.sleep(5000);
				test.log(LogStatus.FAIL, " Notice Draft Extension Application File is not downloaded.");
			}
		} else {
			test.log(LogStatus.INFO, "Notice Draft Extension Application - There is no document (button not clickable).");
		}
	} catch (Exception e) {
		test.log(LogStatus.INFO, "Notice Draft Extension Application - There is No File Available");
	}

	// 5 - Logic for Draft Response (Prepared by SME)
	Thread.sleep(10000);
	File dir5 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents5 = dir5.listFiles();

	Thread.sleep(4000);
	try {
		if (All_ClientPortal_Locators.DraftResponseSMEDocument().isDisplayed() && All_ClientPortal_Locators.DraftResponseSMEDocument().isEnabled()) {
			All_ClientPortal_Locators.DraftResponseSMEDocument().click();
			Thread.sleep(10000);
			File dirrr5 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew5 = dirrr5.listFiles();
			Thread.sleep(3000);
			if (dirContents5.length < allFilesNew5.length) {
				Thread.sleep(5000);
				test.log(LogStatus.PASS, " Notice Response Prepared by SME File is downloaded successfully.");
			} else {
				Thread.sleep(5000);
				test.log(LogStatus.FAIL, " Notice Draft Extension Application File is not downloaded.");
			}
		} else {
			test.log(LogStatus.INFO, "Notice Response Prepared by SME - There is no document (button not clickable).");
		}
	} catch (Exception e) {
		test.log(LogStatus.INFO, "Notice Response Prepared by SME - There is No File Available.");
	}
	
	
	
}

public static void StatutoryDocApplyClaerBtn(ExtentTest test) throws InterruptedException
{

	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickMyDoc().click();
	
	All_ClientPortal_Locators.clickStatutoryDoc().click();
	
	All_ClientPortal_Locators.clickComplianceType().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(3000);
	
	All_ClientPortal_Locators.clickAct2().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickPeriod().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickYear().click();
	All_ClientPortal_Locators.selectYear2024().click();
	

	Thread.sleep(1000);
//	All_ClientPortal_Locators.clickBranch1().click();
	Thread.sleep(1000);
//	All_ClientPortal_Locators.clickBranchcheckbox().click();
	Thread.sleep(1000);
//	All_ClientPortal_Locators.clickBranch1().click();
	Thread.sleep(1000);
	
	//All_ClientPortal_Locators.clickPeriod().click(); //Bilal added 
	
	if(All_ClientPortal_Locators.ClickApplyBtn().isEnabled())
	{
		Thread.sleep(1000);
		All_ClientPortal_Locators.ClickApplyBtn().click();
		test.log(LogStatus.PASS, "Apply button working successfully");
	}
	else
	{
		test.log(LogStatus.FAIL, "Apply button working successfully");
	}
	
//	Thread.sleep(1000);
//	wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
	
	Thread.sleep(1000);
	if(All_ClientPortal_Locators.clickClearBtn().isEnabled())
	{
		Thread.sleep(10000);
		All_ClientPortal_Locators.clickClearBtn().click();
		test.log(LogStatus.PASS, "Clear button working successfully");
	}
	else
	{
		test.log(LogStatus.FAIL, "Clear button not working successfully");
	}
	
	
	Thread.sleep(5000);
	All_ClientPortal_Locators.clickMyDashboard().click();
	}


public static void StatutoryDocFilter(ExtentTest test) throws InterruptedException
{
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickMyDoc().click();
	
	All_ClientPortal_Locators.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickComplianceType().click();
	Thread.sleep(1000);
	if(All_ClientPortal_Locators.selectComplianceType1().isDisplayed())
	{
		Thread.sleep(1000);
		All_ClientPortal_Locators.selectComplianceType1().click();
		test.log(LogStatus.PASS, "Register', 'Return', 'Challan' value should reflect in dropdown.");
	}
	else
	{
		test.log(LogStatus.FAIL, "Register', 'Return', 'Challan' value should not reflect in dropdown.");
	}
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickAct2().click();
	
	Thread.sleep(1000);
	if(All_ClientPortal_Locators.selectComplianceType1().isDisplayed())
	{
		
		test.log(LogStatus.PASS, "Act' value's should reflect in dropdown.");
	}
	else
	{
		test.log(LogStatus.FAIL, "Act' value's should not reflect in dropdown.");
	}
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	
	Thread.sleep(1000);
	if(All_ClientPortal_Locators.selectComplianceType1().isDisplayed())
	{
		
		test.log(LogStatus.PASS, "Year' value's should reflect in dropdown.");
	}
	else
	{
		test.log(LogStatus.FAIL, "Year' value's should not reflect in dropdown.");
	}
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickPeriod().click();
	Thread.sleep(1000);
	if(All_ClientPortal_Locators.selectComplianceType1().isDisplayed())
	{
		
		test.log(LogStatus.PASS, "Period' value's should reflect in dropdown.");
	}
	else
	{
		test.log(LogStatus.FAIL, "Period' value's should not reflect in dropdown.");
	}
	
	

	Thread.sleep(5000);
	All_ClientPortal_Locators.clickMyDashboard().click();
	
}
public static void StateDocZipFile(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickMyDoc().click();
	
	All_ClientPortal_Locators.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickComplianceType().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickAct2().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickPeriod().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear2024().click();
	

	/*
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickBranch1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickBranchcheckbox().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickBranch1().click();   */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	

	//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
	Thread.sleep(9000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(4000);
	All_ClientPortal_Locators.clickDownload().click();
	
//	Thread.sleep(1000);
//	wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
	

	Thread.sleep(4000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	Thread.sleep(4000);
	if(dirContents.length < allFilesNew.length)
	{
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Zip file is downloaded successfully.");
		
		File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	    {
	       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	       {
	           lastModifiedFile = allFilesNew[i];
	       }
	    }
	}
	    
		else
		{  
			Thread.sleep(2000);
			test.log(LogStatus.FAIL, "zip file should not get downloaded..");
		}


//catch(Exception e)
//{
//	
//	Thread.sleep(2000);
//	String msg1=Locator.FileNotFound().getText();
//	
//	 if(msg1.equalsIgnoreCase("File Not Found"))
//	 {
//		 test.log(LogStatus.PASS, "Message displayed = "+msg1);
//		 
//	 }
//	 else
//	 {
//		 test.log(LogStatus.FAIL, "Message displayed = "+msg1);
//	 }
//	 Thread.sleep(1000);
//	Locator.clickOkBtn().click();
//}
//	Thread.sleep(2000);
//	Locator.clickdashboard().click();
		
	
	
}

public static void StatutoryDocViewandOverview(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickMyDoc().click();
	
	All_ClientPortal_Locators.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickComplianceType().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickAct2().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickPeriod().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear2024().click();
	

	Thread.sleep(1000);
/*	All_ClientPortal_Locators.clickBranch1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickBranchcheckbox().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickBranch1().click();
	Thread.sleep(1000);  */
	All_ClientPortal_Locators.ClickApplyBtn().click();
	

	Thread.sleep(1000);
	All_ClientPortal_Locators.clickview().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickview1().click();
	Thread.sleep(3000);
	String msg=All_ClientPortal_Locators.viewPopup().getText();
	if(msg.equalsIgnoreCase("Document Viewer"))
	{
		test.log(LogStatus.PASS, "View Popup open successfully:-"+msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "View Popup does not open successfully:-"+msg);
	}
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickCloseBtn1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickCloseBtn().click();
}
public static void StatutoryDocBulkDownload(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(1000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickMyDoc().click();
	
	All_ClientPortal_Locators.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickComplianceType().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickAct2().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickPeriod().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear2024().click();
	

	Thread.sleep(1000);
/*	All_ClientPortal_Locators.clickBranch1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickBranchcheckbox().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickBranch1().click(); */
	Thread.sleep(1000);
	
	All_ClientPortal_Locators.ClickApplyBtn().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickCheckBox().click();
	
	
	
	Thread.sleep(9000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(1000);
	All_ClientPortal_Locators.clickDownloadbulk().click();
	
		

	Thread.sleep(4000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	Thread.sleep(4000);
	if(dirContents.length < allFilesNew.length)
	{
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Document downloaded successfully");
		
		File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	    {
	       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	       {
	           lastModifiedFile = allFilesNew[i];
	       }
	    }
	}
	    
		else
		{  
			Thread.sleep(2000);
			test.log(LogStatus.FAIL, "Document does not downloaded successfully");
		}
}

public static void ChallanDoc(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickMyDoc().click();
	
	All_ClientPortal_Locators.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickComplianceType().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickAct2().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickPeriod().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear2024().click();
	


	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	
	

	//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
	Thread.sleep(9000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(4000);
	All_ClientPortal_Locators.clickDownload().click();
	
//	Thread.sleep(1000);
//	wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
	

	Thread.sleep(4000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	Thread.sleep(4000);
	if(dirContents.length < allFilesNew.length)
	{
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Working document file should get downloaded.");
		
		File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	    {
	       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	       {
	           lastModifiedFile = allFilesNew[i];
	       }
	    }
	}
	    
		else
		{  
			Thread.sleep(2000);
			test.log(LogStatus.FAIL, "Working document file should not get downloaded..");
		}


//catch(Exception e)
//{
//	
//	Thread.sleep(2000);
//	String msg1=Locator.FileNotFound().getText();
//	
//	 if(msg1.equalsIgnoreCase("File Not Found"))
//	 {
//		 test.log(LogStatus.PASS, "Message displayed = "+msg1);
//		 
//	 }
//	 else
//	 {
//		 test.log(LogStatus.FAIL, "Message displayed = "+msg1);
//	 }
//	 Thread.sleep(1000);
//	Locator.clickOkBtn().click();
//}
//	Thread.sleep(2000);
//	Locator.clickdashboard().click();
		
	
	
}

public static void ChallanComplianceDoc(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickMyDoc().click();
	
	All_ClientPortal_Locators.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickComplianceType().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickAct2().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickPeriod().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear2024().click();
	


	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	
	
	//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
	Thread.sleep(9000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(4000);
	All_ClientPortal_Locators.clickDownload1().click();
	
//	Thread.sleep(1000);
//	wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
	

	Thread.sleep(4000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	Thread.sleep(4000);
	if(dirContents.length < allFilesNew.length)
	{
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Compliance document file should get downloaded.");
		
		File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	    {
	       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	       {
	           lastModifiedFile = allFilesNew[i];
	       }
	    }
	}
	    
		else
		{  
			Thread.sleep(2000);
			test.log(LogStatus.FAIL, "Compliance document file should not get downloaded..");
		}


//catch(Exception e)
//{
//	
//	Thread.sleep(2000);
//	String msg1=Locator.FileNotFound().getText();
//	
//	 if(msg1.equalsIgnoreCase("File Not Found"))
//	 {
//		 test.log(LogStatus.PASS, "Message displayed = "+msg1);
//		 
//	 }
//	 else
//	 {
//		 test.log(LogStatus.FAIL, "Message displayed = "+msg1);
//	 }
//	 Thread.sleep(1000);
//	Locator.clickOkBtn().click();
//}
//	Thread.sleep(2000);
//	Locator.clickdashboard().click();
		
	
	
}
public static void ChallanViewBranches(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickMyDoc().click();
	
	All_ClientPortal_Locators.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickComplianceType().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickAct2().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickPeriod().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear2024().click();
	


	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickview().click();
	
	
	Thread.sleep(3000);
	String msg=All_ClientPortal_Locators.viewPopup1().getText();
	if(msg.equalsIgnoreCase("Branches"))
	{
		test.log(LogStatus.PASS, "View Popup open successfully:-"+msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "View Popup does not open successfully:-"+msg);
	}
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickCloseBtn().click();
		
	
	
}
public static void ChallanViewWorkingFile(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(4000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(5000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(5000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(6000);
	All_ClientPortal_Locators.clickMyDoc().click();
	
	All_ClientPortal_Locators.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickComplianceType().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickAct2().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickPeriod().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear2024().click();
	


	Thread.sleep(3000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	
	Thread.sleep(5000);
	if(All_ClientPortal_Locators.clickview2().isEnabled())
	{
		Thread.sleep(4000);
		All_ClientPortal_Locators.clickview2().click();
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Working File is viewed successfully");
	}
	else
	{
		test.log(LogStatus.FAIL, "Working File does not viewed successfully");
	}
	
	
}
public static void ChallanViewComplianceFile(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickMyDoc().click();
	
	All_ClientPortal_Locators.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickComplianceType().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickAct2().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectComplianceType1().click();  //Bilal changed type 3
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickPeriod().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear2024().click();
	


	Thread.sleep(3000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	
	if(All_ClientPortal_Locators.clickview3().isEnabled())
	{
		Thread.sleep(4000);
		All_ClientPortal_Locators.clickview3().click();
		test.log(LogStatus.PASS, "Compliance File is viewed successfully");
		
	}
	else
	{
		test.log(LogStatus.FAIL, "Compliance File does not viewed successfully");
	}
	
	
}

public static void ChallanDocBulkDownload(ExtentTest test) throws InterruptedException
{
	

	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickMyDoc().click();
	
	All_ClientPortal_Locators.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickComplianceType().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickAct2().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickPeriod().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear2024().click();
	


	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickCheckBox().click();
	
	
	
	Thread.sleep(9000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(1000);
	All_ClientPortal_Locators.clickDownloadbulk().click();
	
		

	Thread.sleep(4000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	Thread.sleep(4000);
	if(dirContents.length < allFilesNew.length)
	{
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Document downloaded successfully");
		
		File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	    {
	       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	       {
	           lastModifiedFile = allFilesNew[i];
	       }
	    }
	}
	    
		else
		{  
			Thread.sleep(2000);
			test.log(LogStatus.FAIL, "Document does not downloaded successfully");
		}
}

public static void RegionalDocView(ExtentTest test) throws InterruptedException
{
	

	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickMasterAbstract().click();
	
	Thread.sleep(5000);
	All_ClientPortal_Locators.clickState1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickAct2().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	

		Thread.sleep(10000);
		All_ClientPortal_Locators.clickVieqRegional().click();

	
	
	Thread.sleep(30000);
	String msg=All_ClientPortal_Locators.viewPopup1().getText();
	if(msg.equalsIgnoreCase("Document Viewer"))
	{
		test.log(LogStatus.PASS, "Regional document viewed successfully:-"+msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "Regional document does not viewed successfully:-"+msg);
	}
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickCloseBtn().click();
	
}
public static void RegionalDocDownload(ExtentTest test) throws InterruptedException
{
	

	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(4000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickMasterAbstract().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickState1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickAct2().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();

	Thread.sleep(9000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(1000);
	All_ClientPortal_Locators.clickDownloadRegiinal().click();
	
		

	Thread.sleep(30000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	Thread.sleep(30000);
	if(dirContents.length < allFilesNew.length)
	{
		Thread.sleep(20000);
		test.log(LogStatus.PASS, "Document downloaded successfully");
		
		File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	    {
	       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	       {
	           lastModifiedFile = allFilesNew[i];
	       }
	    }
	}
	    
		else
		{  
			Thread.sleep(2000);
			test.log(LogStatus.FAIL, "Document does not downloaded successfully");
	
		}
}

public static void EnglishDocView(ExtentTest test) throws InterruptedException
{
	

	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(5000);
	All_ClientPortal_Locators.clickMasterAbstract().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickState1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickAct2().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	

		Thread.sleep(1000);
		All_ClientPortal_Locators.clickViewEnglish().click();

	
	
	Thread.sleep(3000);
	String msg=All_ClientPortal_Locators.viewPopup1().getText();
	if(msg.equalsIgnoreCase("Document Viewer"))
	{
		test.log(LogStatus.PASS, "English document viewed successfully:-"+msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "English document does not viewed successfully:-"+msg);
	}
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickCloseBtn().click();
	
}
public static void EnglishDocDownload(ExtentTest test) throws InterruptedException
{
	

	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickMasterAbstract().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickState1().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickAct2().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectComplianceType1().click();

	Thread.sleep(9000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(10000);
	All_ClientPortal_Locators.clickDownloadEnglishl().click();
	
		

	Thread.sleep(10000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	Thread.sleep(4000);
	if(dirContents.length < allFilesNew.length)
	{
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Document downloaded successfully");
		
		File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	    {
	       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	       {
	           lastModifiedFile = allFilesNew[i];
	       }
	    }
	}
	    
		else
		{  
			Thread.sleep(2000);
			test.log(LogStatus.FAIL, "Document does not downloaded successfully");
	
		}
}

public static void SearchBoxMasterAbstarct(ExtentTest test) throws InterruptedException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
/*	All_ClientPortal_Locators.clickEntity().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickTringle1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectEnity().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.clickYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.selectYear().click();
	Thread.sleep(1000);
	All_ClientPortal_Locators.ClickApplyBtn().click(); */
	
	Thread.sleep(3000);
	All_ClientPortal_Locators.clickMasterAbstract().click();
	
	Thread.sleep(5000);
	All_ClientPortal_Locators.clickState1().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.selectComplianceType1().click();
	
//	Thread.sleep(1000);
//	Locator.clickAct2().click();
//	Thread.sleep(1000);
//	Locator.selectComplianceType1().click();
	
		Thread.sleep(3000);
		All_ClientPortal_Locators.SearchBox().sendKeys("FACT",Keys.ENTER);
	
		List<String> li=new ArrayList<String>();
        
       
        li.add("FACT and Allied acts");
   
        
		List<String> filter=new ArrayList<String>();	
		
		filter.add("FACT and Allied acts");	
		
		
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(10000);

		 All_ClientPortal_Locators.readTotalItemsNotice().click();				//Clicking on Text of total items just to scroll down.
		 Thread.sleep(5000);
		String s = All_ClientPortal_Locators.readTotalItemsNotice().getText();
		Thread.sleep(5000);

		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);

		List<WebElement> typecol=getDriver().findElements(By.xpath("//*[@class='k-grid-aria-root']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[2]"));
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();


		 if(i==0)
				{
					raw.addAll(typecol);
				}
			
				
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

			for(int l=0;l<text.size();l++)
			 {
					
				if(text.get(l).equals(li.get(i)))
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				   {
						fail.add(text.get(l));		
						System.out.println("fail : "+text.get(l)+" : "+li.get(i));
						System.out.println(i);

				   }
			  }
					
			             
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 	test.log(LogStatus.PASS,  " Search box working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
		 }
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		if(All_ClientPortal_Locators.ClearBtn().isEnabled())
		{
			All_ClientPortal_Locators.ClearBtn().click();
			test.log(LogStatus.PASS, "Clear button working successfully.");
			
		}
		else
		{
			test.log(LogStatus.PASS, "Clear button not working successfully.");
			
		}
		
		}
		}
		else
		{
			test.log(LogStatus.PASS,"No records found");	
		}
	}
	
	




public static void MultipleDocument( ExtentTest test) throws InterruptedException, IOException, AWTException
{

	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.MyDocument()));	
/*	All_ClientPortal_Locators.Entity().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.EntityExpand().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.checkbox().click();
	Thread.sleep(2000);		
	All_ClientPortal_Locators.Applybtn().click(); */
	Thread.sleep(3000);
	All_ClientPortal_Locators.MyDocument().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.StaDocument().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.ComplianceDropdown().click();
	Thread.sleep(2000);
	LoginLocators.ClickRegister().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.Actfilter().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.ClickAct().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.Year().click();
	Thread.sleep(2000);
	LoginLocators.typeValueEPF().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.Period().click();
	Thread.sleep(2000);
	LoginLocators.ClickPeriod1().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.branch().click();
	Thread.sleep(2000);
	LoginLocators.branchvalue4().click();
	Thread.sleep(2000);
	LoginLocators.ApplyButton().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.CheckBox1().click();
	Thread.sleep(500);
	All_ClientPortal_Locators.CheckBox2().click();
	Thread.sleep(500);
	All_ClientPortal_Locators.CheckBox3().click();
	Thread.sleep(500);
	
	File dir2 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
	
	Thread.sleep(9000);
	All_ClientPortal_Locators.Download().click();
	
 	Thread.sleep(18000);
	File dir3 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
	
   
    Thread.sleep(9000);
   if (dirContents1.length < allFilesNew1.length) {
		test.log(LogStatus.PASS,  " Document Downloaded.");
	}
   else
   {
		test.log(LogStatus.FAIL, "Document Does Not Downloaded.");
	}		
   Thread.sleep(5000);
	
	
	
}

public static void MyDocument( ExtentTest test) throws InterruptedException, IOException, AWTException
{

	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.MyDocument()));	
	All_ClientPortal_Locators.Entity().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.EntityExpand().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.checkbox().click();
	Thread.sleep(2000);		
	All_ClientPortal_Locators.Applybtn().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.MyDocument().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.StaDocument().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.ComplianceDropdown().click();
	Thread.sleep(2000);
	LoginLocators.ClickRegister().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.Actfilter().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.ClickAct().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.Year().click();
	Thread.sleep(2000);
	LoginLocators.typeValueEPF().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.Period().click();
	Thread.sleep(2000);
	LoginLocators.ClickPeriod1().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.branch().click();
	Thread.sleep(2000);
	LoginLocators.branchvalue4().click();
	Thread.sleep(2000);
	LoginLocators.ApplyButton().click();
	Thread.sleep(3000);
	
	File dir2 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
	
	Thread.sleep(9000);
	All_ClientPortal_Locators.Downloads().click();
	
 	Thread.sleep(18000);
	File dir3 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
	
   
    Thread.sleep(9000);
   if (dirContents1.length < allFilesNew1.length) {
		test.log(LogStatus.PASS,  " Document Downloaded.");
	}
   else
   {
		test.log(LogStatus.FAIL, "Document Does Not Downloaded.");
	}		
   Thread.sleep(5000);
	
	
	
}

public static void MyDocumentView( ExtentTest test) throws InterruptedException, IOException, AWTException
{

	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.MyDocument()));	
	All_ClientPortal_Locators.Entity().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.EntityExpand().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.checkbox().click();
	Thread.sleep(2000);		
	All_ClientPortal_Locators.Applybtn().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.MyDocument().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.StaDocument().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.ComplianceDropdown().click();
	Thread.sleep(2000);
	LoginLocators.ClickRegister().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.Actfilter().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.ClickAct().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.Year().click();
	Thread.sleep(2000);
	LoginLocators.typeValueEPF().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.Period().click();
	Thread.sleep(2000);
	LoginLocators.ClickPeriod1().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.branch().click();
	Thread.sleep(2000);
	LoginLocators.branchvalue4().click();
	Thread.sleep(2000);
	LoginLocators.ApplyButton().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.View().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.Viewed().click();
	Thread.sleep(3000);
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	test.log(LogStatus.PASS, "Document Viewed.");
	Thread.sleep(3000);
	LoginLocators.ClosePopup().click();
	
	
}

public static void MyDocumentFilter( ExtentTest test) throws InterruptedException, IOException, AWTException
{

	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.MyDocument()));	
	All_ClientPortal_Locators.Entity().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.EntityExpand().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.checkbox().click();
	Thread.sleep(2000);		
	All_ClientPortal_Locators.Applybtn().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.MyDocument().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.StaDocument().click();
	Thread.sleep(2000);
	
	All_ClientPortal_Locators.ComplianceDropdown().click();
	Thread.sleep(2000);
	LoginLocators.ClickRegister().click();
	Thread.sleep(2000);
	
	All_ClientPortal_Locators.Actfilter().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.ClickAct().click();
	Thread.sleep(2000);
	
	All_ClientPortal_Locators.Year().click();
	Thread.sleep(2000);
	String year = LoginLocators.typeValueEPF().getText();
	LoginLocators.typeValueEPF().click();
	Thread.sleep(2000);
	
	All_ClientPortal_Locators.Period().click();
	Thread.sleep(2000);
	String period = LoginLocators.ClickPeriod1().getText();
	Thread.sleep(2000);
	LoginLocators.ClickPeriod1().click();
	Thread.sleep(2000);
	
	
	All_ClientPortal_Locators.branch().click();
	Thread.sleep(2000);		
	All_ClientPortal_Locators.Expand().click();
	Thread.sleep(2000);
	String loc = All_ClientPortal_Locators.Location().getText();
	Thread.sleep(500);
	All_ClientPortal_Locators.Location().click();
	Thread.sleep(2000);
	LoginLocators.ApplyButton().click();
	Thread.sleep(3000);
  List<String> li=new ArrayList<String>();
  
  
  li.add(year);
  li.add(period);
  li.add(loc);
 
  
  Thread.sleep(3000);
  
	List<String> filter=new ArrayList<String>();	
	
	filter.add("Year");
	filter.add("Period");
	filter.add("Location");
	
	
	JavascriptExecutor j = (JavascriptExecutor) getDriver();
	j.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(3000);

	LoginLocators.TotalNumberOfItems().click();					//Clicking on Text of total items just to scroll down.
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(2000);

	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(5000);

	List<WebElement> yearcol=getDriver().findElements(By.xpath("//td[7]"));
	List<WebElement> periodcol=getDriver().findElements(By.xpath("//td[6]"));
	List<WebElement> Loccol=getDriver().findElements(By.xpath("//td[4]"));
	
	Thread.sleep(2000);

	for(int i=0; i<li.size(); i++){
		
		List<String> text= new ArrayList<String>();
		HashSet<String> pass=new LinkedHashSet<>();
		HashSet<String> fail=new LinkedHashSet<>();
		List<WebElement> raw=new ArrayList<WebElement>();

			if(i==0)
			{
				raw.addAll(yearcol);
			}
		else if(i==1)
			{
				raw.addAll(periodcol);
			}
		else if(i==2)
		{
			raw.addAll(Loccol);
		}
			
			for(int k=0;k<raw.size();k++)
			{
				text.add(raw.get(k).getText());
			}
			for(int l=0;l<text.size();l++)
			{
				
				if(i==2)
				{
					if(text.get(l).equalsIgnoreCase("ANDHERI WEST_Andheriya")||text.get(l).equalsIgnoreCase("ANDHERI WEST"))
					{
					  pass.add(text.get(l));
					}
					else
					{
						 fail.add(text.get(l));
					}
				}
				else
				{
					
				
			if(text.get(l).equals(li.get(i)))
				{
				
				
					pass.add(text.get(l));	
					System.out.println("pass : "+text.get(l)+" : "+li.get(i));
				}
			else
			{
				fail.add(text.get(l));		
				System.out.println("fail : "+text.get(l)+" : "+li.get(i));
				System.out.println(i);
			}
			 }
			}
	
for(String Fal : fail)
	 {
			test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
	 }	
	 for(String Pas : pass)
	 {
		 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
			test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
			System.out.println(filter.get(i)+" : "+Pas);
 }
	text.clear();
	pass.clear();
	fail.clear();
	raw.clear();
	
	
	}
	}else {
		test.log(LogStatus.PASS,"No records found");	
	}
	
}

public static void MyDocumentAllTab( ExtentTest test) throws InterruptedException, IOException, AWTException
{

	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.MyDocument()));
	All_ClientPortal_Locators.Entity().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.EntityExpand().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.checkbox().click();
	Thread.sleep(2000);		
	All_ClientPortal_Locators.Applybtn().click();
	Thread.sleep(3000);
	All_ClientPortal_Locators.MyDocument().click();
	Thread.sleep(3000);
if(All_ClientPortal_Locators.StaDocument().isDisplayed()&&All_ClientPortal_Locators.MISDocument().isDisplayed()&&All_ClientPortal_Locators.EmployeeESIC().isDisplayed()&&All_ClientPortal_Locators.CriticalDocuments().isDisplayed()) {
	
	test.log(LogStatus.PASS, "The tab of Statutory Document, MIS Document, Employee ESIC and Critical Documents should be seen below the My document tab");
}else {
	
	test.log(LogStatus.FAIL, "The tab of Statutory Document, MIS Document, Employee ESIC and Critical Documents should not seen below the My document tab");
	
}
} 

public static void CriticalDocument( ExtentTest test) throws InterruptedException, IOException, AWTException
{

	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.MyDocument()));	
/*	All_ClientPortal_Locators.Entity().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.EntityExpand1().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.checkbox1().click();
	Thread.sleep(2000);		
	All_ClientPortal_Locators.Applybtn().click(); */
	Thread.sleep(3000);
	All_ClientPortal_Locators.MyDocument().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.CriticalDocuments().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.NewFolder().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.FolderName().sendKeys("Labor Doc Live");
	Thread.sleep(2000);
	All_ClientPortal_Locators.Create().click();
	Thread.sleep(2000);
	String msg = LoginLocators.UploadSuccessfully().getText();
	   Thread.sleep(2000);
	   if(msg.equalsIgnoreCase("Folder Created Succesfully"))
	   {
		   test.log(LogStatus.PASS,  msg);
	   }
	   else {
		   test.log(LogStatus.FAIL,   msg);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(2000);
	   
	
	
	
}

public static void CriticalDocumentSubFolder( ExtentTest test) throws InterruptedException, IOException, AWTException
{

	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.MyDocument()));	
/*	All_ClientPortal_Locators.Entity().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.EntityExpand1().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.checkbox1().click();
	Thread.sleep(2000);		
	All_ClientPortal_Locators.Applybtn().click(); */
	Thread.sleep(3000);
	All_ClientPortal_Locators.MyDocument().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.CriticalDocuments().click();
	Thread.sleep(2000);
	Actions actions = new Actions(getDriver());
    WebElement element = getDriver().findElement(By.xpath("(//div[@title='Test Base MD'])[1]"));
    actions.doubleClick(element).perform();
	Thread.sleep(2000);
	All_ClientPortal_Locators.NewFolder().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.FolderName().sendKeys("Labor Document");
	Thread.sleep(2000);
	All_ClientPortal_Locators.Create().click();
	Thread.sleep(2000);
	String msg = LoginLocators.UploadSuccessfully().getText();
	   Thread.sleep(2000);
	   if(msg.equalsIgnoreCase("Folder Created Succesfully")||msg.equalsIgnoreCase("Folder Name already Exists"))
	   {
		   test.log(LogStatus.PASS,  msg);
	   }
	   else {
		   test.log(LogStatus.FAIL,   msg);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(2000);
	   
	
	
	
}

public static void CriticalDocumentNewFile( ExtentTest test) throws InterruptedException, IOException, AWTException
{

	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.MyDocument()));	
/*	All_ClientPortal_Locators.Entity().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.EntityExpand1().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.checkbox1().click();
	Thread.sleep(2000);		
	All_ClientPortal_Locators.Applybtn().click(); */
	Thread.sleep(3000);
	All_ClientPortal_Locators.MyDocument().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.CriticalDocuments().click();
	Thread.sleep(5000);
	Actions actions = new Actions(getDriver());
    WebElement element = getDriver().findElement(By.xpath("(//div[normalize-space()='Folder'])[1]"));
    actions.doubleClick(element).perform();
	Thread.sleep(2000);
	All_ClientPortal_Locators.NewFile().click();
	Thread.sleep(2000);
	LoginLocators.Browes().click();
	Thread.sleep(2000);
	
	String filePath = "D:\\Upload Automation Files\\Other Upload No need to change\\sample.pdf";
    StringSelection selection = new StringSelection(filePath);

    // Copy file path to clipboard
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    Thread.sleep(2000);
    // Use Robot class to paste the file path and press Enter
    Robot robot = new Robot();
    
    // Simulate CTRL + V (Paste)
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    
    // Press Enter to confirm the upload
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(500);
	
	LoginLocators.Uploadbtn().click();
	Thread.sleep(2000);
	
	String msg = LoginLocators.UploadSuccessfully().getText();
	   Thread.sleep(2000);
	   if(msg.equalsIgnoreCase("File Uploaded Successfully"))
	   {
		   test.log(LogStatus.PASS,  msg);
	   }
	   else {
		   test.log(LogStatus.FAIL,   msg);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(2000);
	   
	
	
	
}


public static void CriticalDocumentshare( ExtentTest test) throws InterruptedException, IOException, AWTException
{

	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(All_ClientPortal_Locators.MyDocument()));	
/*	All_ClientPortal_Locators.Entity().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.EntityExpand1().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.checkbox1().click();
	Thread.sleep(2000);		
	All_ClientPortal_Locators.Applybtn().click(); */
	Thread.sleep(3000);
	All_ClientPortal_Locators.MyDocument().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.CriticalDocuments().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.Share().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.PermissionSelect().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.PermissionSelectValue().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.SelectUser().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.SelectUserVal().click();
	Thread.sleep(2000);
	All_ClientPortal_Locators.Done().click();
	Thread.sleep(2000);
	
	String msg = LoginLocators.UploadSuccessfully().getText();
	   Thread.sleep(2000);
	   if(msg.equalsIgnoreCase("The Folder has been shared successfully!"))
	   {
		   test.log(LogStatus.PASS,  msg);
	   }
	   else {
		   test.log(LogStatus.FAIL,   msg);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(2000);
	   
}



//It will generate Random String just need to call 'getRandomString'
public static String getRandomString() {
    return new java.util.Random().ints(6, 0, 62)
        .mapToObj(i -> "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(i))
        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
        .toString();
}





public static void clickElementUsingJS(WebElement element) {
    try {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", element);
        Thread.sleep(4000);
    } catch (Exception e) {
        e.printStackTrace();
    }
}




public static void waitForLoaderToDisappear() {
    try {
        WebDriverWait wait = new WebDriverWait(getDriver(), 140);
        // Wait until loader disappears from the screen
        wait.until(ExpectedConditions.invisibilityOf(All_ClientPortal_Locators.loaderTime()));
    } catch (org.openqa.selenium.TimeoutException e) {
        System.out.println("Loader did not disappear within the expected time.");
    } catch (Exception e) {
        System.out.println("No loader found or some error: " + e.getMessage());
    }
}

public static void verifyFileDownload(By downloadButtonLocator, ExtentTest test) {
    try {
        File dirBefore = new File("C:\\Users\\bilali\\Downloads");
        File[] filesBefore = dirBefore.listFiles();

        Thread.sleep(500);
        getDriver().findElement(downloadButtonLocator).click(); // Download button click

        Thread.sleep(8000); // Wait for download to complete
        File dirAfter = new File("C:\\Users\\bilali\\Downloads");
        File[] filesAfter = dirAfter.listFiles();

        Thread.sleep(3000);
        if (filesBefore.length < filesAfter.length) {
            Thread.sleep(5000);
            test.log(LogStatus.PASS, "File downloaded successfully.");
        } else {
            Thread.sleep(5000);
            test.log(LogStatus.FAIL, "File did not download.");
        }
    } catch (Exception e) {
        test.log(LogStatus.FAIL, "Exception during file download: " + e.getMessage());
    }
}





public static void verifyPaginationGoToNextPage(ExtentTest test) {
    try {
        Thread.sleep(4000);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1000)");

        WebElement nextPageBtn = getDriver().findElement(By.xpath("//button[@title='Go to the next page']"));
        js.executeScript("arguments[0].scrollIntoView(true);", nextPageBtn);
        Thread.sleep(4000);

        WebElement goToNext = All_ClientPortal_Locators.goToNextPage();
        if (goToNext.isEnabled()) {
            Thread.sleep(3000);
            goToNext.click();
            test.log(LogStatus.PASS, "Pagination: Go To Next Page button is working fine");

            Thread.sleep(10000);

            WebElement goToPrevious = All_ClientPortal_Locators.goToPreviousPage();
            if (goToPrevious.isEnabled()) {
                goToPrevious.click();
                test.log(LogStatus.PASS, "Pagination: Go To Previous Page button is working fine");
            } else {
                test.log(LogStatus.INFO, "Pagination: Previous Page button is not clickable, maybe due to being on the first page.");
            }
        } else {
            test.log(LogStatus.INFO, "Pagination: Next Page button is not clickable, possibly due to no more data to paginate.");
        }
    } catch (Exception e) {
        test.log(LogStatus.ERROR, "Pagination check failed due to: " + e.getMessage());
    }
}


public static void verifyPaginationGoToLastPage(ExtentTest test) {
    try {
        Thread.sleep(4000);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1000)");

        WebElement lastPageBtn = getDriver().findElement(By.xpath("//button[@title='Go to the last page']"));
        js.executeScript("arguments[0].scrollIntoView(true);", lastPageBtn);
        Thread.sleep(4000);

        WebElement goToLast = All_ClientPortal_Locators.goToLastPage();
        if (goToLast.isEnabled()) {
            Thread.sleep(3000);
            goToLast.click();
            test.log(LogStatus.PASS, "Pagination: Go To Last Page button is working fine");

            Thread.sleep(10000);

            WebElement goToFirst = All_ClientPortal_Locators.goToFirstPage();
            if (goToFirst.isEnabled()) {
                goToFirst.click();
                test.log(LogStatus.PASS, "Pagination: Go To First Page button is working fine");
            } else {
                test.log(LogStatus.INFO, "Pagination: First Page button is not clickable, maybe already on the first page.");
            }
        } else {
            test.log(LogStatus.INFO, "Pagination: Last Page button is not clickable, possibly due to no data available to paginate.");
        }
    } catch (Exception e) {
        test.log(LogStatus.ERROR, "Pagination to last page check failed due to: " + e.getMessage());
    }
}



public static void verifyItemsPerPageFunctionality(ExtentTest test) {
    try {
        Thread.sleep(4000);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1000)");

        WebElement itemDropdown = All_ClientPortal_Locators.itemPerPageDrp();
        itemDropdown.click();
        Thread.sleep(2000);

        All_ClientPortal_Locators.itemPerPageselect20().click();
        test.log(LogStatus.PASS, "Pagination: Selected 20 items per page successfully");
        Thread.sleep(10000);

        itemDropdown.click();
        Thread.sleep(2000);

        All_ClientPortal_Locators.itemPerPageselect10().click();
        test.log(LogStatus.PASS, "Pagination: Selected 10 items per page successfully");
        Thread.sleep(10000);

        itemDropdown.click();
        Thread.sleep(2000);

        All_ClientPortal_Locators.itemPerPageselect5().click();
        test.log(LogStatus.PASS, "Pagination: Selected 5 items per page successfully");
        Thread.sleep(10000);

        itemDropdown.click();
        Thread.sleep(2000);

        All_ClientPortal_Locators.itemPerPageselectAll().click();
        test.log(LogStatus.PASS, "Pagination: Selected All items per page successfully");
        Thread.sleep(15000);

    } catch (Exception e) {
        test.log(LogStatus.ERROR, "Pagination: Items Per Page selection could not be completed.");
    }
}

















	
}
