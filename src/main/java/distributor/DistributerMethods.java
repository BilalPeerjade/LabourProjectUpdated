package distributor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import login.BasePage;
import performer.PerformerLocator;

public class DistributerMethods extends BasePage
{
	private static List<WebElement> elementsList = null;
	
	 static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour2.xlsx";
	public static void StateMaster( ExtentTest test) throws InterruptedException, IOException
	{
		
		DistributerLocators.SerchCustomer().sendKeys("AVAREGTR");
		
		DistributerLocators.clickDashboard().click();
		
		DistributerLocators.clickManageMaster().click();
		
		DistributerLocators.clickSearchState().sendKeys("Pune");
		
		List<WebElement>roc2 = getDriver().findElements(By.xpath("//ul[@class='k-list-ul']/li"));
		selectOptionFromDropDown_bs(roc2, "Bihar");
		
		DistributerLocators.clickApplyBtn().click();
		
//--------------------------------		
		
		
		
		
	}
	
	public static void StateAdd( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickManageMaster().click();
		Thread.sleep(1000);
		DistributerLocators.clickAddNewBtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickState().click();
		
		Thread.sleep(4000);
		List<WebElement>roc2 = getDriver().findElements(By.xpath("//ul[@class='k-list-ul']/li"));
		selectOptionFromDropDown_bs(roc2, "Bihar");
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(5);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		String city = c.getStringCellValue();
		DistributerLocators.clickcity().sendKeys(city);
		
		Thread.sleep(1000);
		Row row0 = sheet.getRow(6);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int location = (int) c1.getNumericCellValue();
		DistributerLocators.clicklocation().sendKeys(location+"");
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		 Thread.sleep(500);
		 // String msg=DistrubutorLocators.clickSucessMsg().getText();		//Reading Message appeared after save button
		  String msg=DistributerLocators.clickMsg().getText();
		  if(msg.equalsIgnoreCase("Record Already Exist")||msg.equalsIgnoreCase("Record Saved Successfully"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		  
		
		  Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
		
			Thread.sleep(1000);
			DistributerLocators.clickcloseBtn().click();
	
	}
	
	public static void StateAddInvalidLocationCode( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickManageMaster().click();
		Thread.sleep(1000);
		DistributerLocators.clickAddNewBtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickState().click();
		
		Thread.sleep(4000);
		List<WebElement>roc2 = getDriver().findElements(By.xpath("//ul[@class='k-list-ul']/li"));
		selectOptionFromDropDown_bs(roc2, "Bihar");
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(5);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		String city = c.getStringCellValue();
		DistributerLocators.clickcity().sendKeys(city);
		
		Thread.sleep(1000);
		Row row0 = sheet.getRow(7);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int location = (int) c1.getNumericCellValue();
		DistributerLocators.clicklocation().sendKeys(location+"");
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		 Thread.sleep(500);
		  String msg=DistributerLocators.clickInvalidLocationCode().getText();		//Reading Message appeared after save button
		  
		  if(msg.equalsIgnoreCase("Location code must be exactly 6 digits."))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		
			Thread.sleep(1000);
			DistributerLocators.clickcloseBtn().click();
	
	}
	
	public static void StateAddExistingCity( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickManageMaster().click();
		Thread.sleep(1000);
		DistributerLocators.clickAddNewBtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickState().click();
		
		Thread.sleep(4000);
		List<WebElement>roc2 = getDriver().findElements(By.xpath("//ul[@class='k-list-ul']/li"));
		selectOptionFromDropDown_bs(roc2, "Bihar");
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(8);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		String city = c.getStringCellValue();
		DistributerLocators.clickcity().sendKeys(city);
		
		Thread.sleep(1000);
		Row row0 = sheet.getRow(6);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		int location = (int) c1.getNumericCellValue();
		DistributerLocators.clicklocation().sendKeys(location+"");
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		 Thread.sleep(500);
		  //String msg=DistrubutorLocators.InvalidMsg().getText();		//Reading Message appeared after save button
		  String msg=DistributerLocators.clickMsg().getText();
		  if(msg.equalsIgnoreCase("Record Already Exist"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		  
		  Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
		
			Thread.sleep(1000);
			DistributerLocators.clickcloseBtn().click();
	
	}
	
	public static void StateExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickManageMaster().click();
		Thread.sleep(1000);
		CountExcel(test);
	}
	public static void UploadSealandSignature( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");

		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickManageMaster().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickSealandSignatureBtn().click();
		
		 Thread.sleep(1000);
			DistributerLocators.clickBrowse1().click();
			
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\testJPEG.jpeg");
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
			DistributerLocators.clickUploadbtnCTCBtn().click();
			
			Thread.sleep(2000);
			String msg=DistributerLocators.clickMsg().getText();
			
			 if(msg.equalsIgnoreCase("File uploaded successfully"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			 DistributerLocators.clickOkBtn().click();
			
			Thread.sleep(1000);
			DistributerLocators.clickcloseBtn().click();
			Thread.sleep(1000);
			DistributerLocators.clickdashboard().click();
		
		
	}
	
	public static void AddDesignation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickManageMaster().click();
		Thread.sleep(1000);
		DistributerLocators.clickDesignation().click();
		Thread.sleep(1000);
		DistributerLocators.clickAddNewDesignation().click();
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(9);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		String designation = c.getStringCellValue();
		DistributerLocators.enterDesignation().sendKeys(designation);
		
		Thread.sleep(1000);
		
		DistributerLocators.clicksave().click();
		
		 Thread.sleep(500);
		 // String msg=DistrubutorLocators.successMsg().getText();		//Reading Message appeared after save button
		  String msg=DistributerLocators.clickMsg().getText();
		  if(msg.equalsIgnoreCase("Designation is already exists."))
		 {
			 test.log(LogStatus.PASS, "Error Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		  
		  Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
		}
	public static void DuplicateDesignation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(71000);
		DistributerLocators.clickManageMaster().click();
		Thread.sleep(1000);
		DistributerLocators.clickDesignation().click();
		Thread.sleep(1000);
		DistributerLocators.clickAddNewDesignation().click();
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(9);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		String designation = c.getStringCellValue();
		DistributerLocators.enterDesignation().sendKeys(designation);
		
		Thread.sleep(1000);
		
		DistributerLocators.clicksave().click();
		
		 Thread.sleep(500);
		  //String msg=DistrubutorLocators.InvalidMsgDesignation().getText();		//Reading Message appeared after save button
		  String msg=DistributerLocators.clickMsg().getText();
		  if(msg.equalsIgnoreCase("Designation is already exists.")||msg.equalsIgnoreCase("Designation added successfully"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		  
		  Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
		}
	
	
	
	public static void CountExcel(ExtentTest test) throws InterruptedException, IOException
	{
		Thread.sleep(500);
		//litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);		
		//JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
        
       // js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000); 		
        //Locators.readTotalItem().click();
		String item = DistributerLocators.readTotalItem().getText();
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("of"))
		{
			Thread.sleep(5000);
		   item = DistributerLocators.readTotalItem().getText();
			bits = item.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-500)");
        Thread.sleep(2000);

		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
	
		Thread.sleep(1000);
		DistributerLocators.clickExport().click();
		
		WebDriverWait wait=new WebDriverWait(getDriver(), 20);
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOf(DistributerLocators.GridLoad()));
		
	
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
	

	public static void CountExcel1(ExtentTest test) throws InterruptedException, IOException
	{
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(500);
	
		String item = DistributerLocators.readTotalItem1().getText();
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("of"))
		{
			Thread.sleep(5000);
		   item = DistributerLocators.readTotalItem1().getText();
			bits = item.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-500)");
        Thread.sleep(2000);

		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
	
		Thread.sleep(1000);
		DistributerLocators.clickExport().click();
		
		WebDriverWait wait = new WebDriverWait(getDriver(),20); // Bilal
		wait.until(ExpectedConditions.invisibilityOf(DistributerLocators.clickExportCLRALocationLoader()));

		
		
//		WebDriverWait wait=new WebDriverWait(getDriver(), 20);
		
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.invisibilityOf(Locators.GridLoad()));
		
	
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
	
	public static void CountExcel2(ExtentTest test) throws InterruptedException, IOException
	{
		Thread.sleep(500);
	
		String item = DistributerLocators.readTotalItem2().getText();
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("of"))
		{
			Thread.sleep(5000);
		   item = DistributerLocators.readTotalItem2().getText();
			bits = item.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-500)");
        Thread.sleep(2000);

		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
	
		Thread.sleep(1000);
		DistributerLocators.clickLocationExportBtn().click();
		
		WebDriverWait wait = new WebDriverWait(getDriver(),20);
		wait.until(ExpectedConditions.invisibilityOf(DistributerLocators.clickLocationExportBtnLoader()));
		
//		WebDriverWait wait=new WebDriverWait(getDriver(), 20);
		
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.invisibilityOf(Locators.GridLoad()));
		
	
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
	
	
	
	public static void DesignationExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickManageMaster().click();
		Thread.sleep(1000);
		DistributerLocators.clickDesignation().click();
		Thread.sleep(1000);
		DistributerLocators.clickDesignation().click();
		
		
		Thread.sleep(500);		
		JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
		
        
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000); 		
        DistributerLocators.readTotalItemDesignation().click();
		String item = DistributerLocators.readTotalItemDesignation().getText();
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = DistributerLocators.readTotalItemDesignation().getText();
			bits = item.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-500)");
        Thread.sleep(2000);

		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
	
		Thread.sleep(1000);
		DistributerLocators.clickExportBtn().click();
		
		WebDriverWait wait=new WebDriverWait(getDriver(), 20);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.invisibilityOf(DistributerLocators.GridLoad1()));
		
	
	
		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
	
		if(dirContents.length < allFilesNew.length)
		{
			Thread.sleep(4000);					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	    {
	       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	       {
	           lastModifiedFile = allFilesNew[i];
	       }
	    }
		
		Thread.sleep(4000);
		fis = new FileInputStream(lastModifiedFile);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
		
		sheet = workbook.getSheetAt(0);
		int columnNumber = 0;  //it will capture 1st column rows
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
			Thread.sleep(7000);
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
	
		
		}
	
	public static void BulkUploadDesignation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(6000);
		DistributerLocators.clickManageMaster().click();
		Thread.sleep(1000);
		DistributerLocators.clickDesignation().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickUploadBtn().click();
		
		
			
			 Thread.sleep(1000);
				DistributerLocators.clickBrowse1().click();
				
				 Robot robot=new Robot();
				 Thread.sleep(5000);
				 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\DesignationSample.xlsx");
				 //copy above file to clipboard
				 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
				 
				 //Now press CRTL
				 Thread.sleep(8000);
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
				DistributerLocators.clickUploadbtnCTCBtn().click();
				
				Thread.sleep(2000);
				String msg=DistributerLocators.clickMsg().getText();
				
				 if(msg.equalsIgnoreCase("File uploaded successfully"))
				 {
					 test.log(LogStatus.PASS, "Message displayed = "+msg);
					 
				 }
				 else
				 {
					 test.log(LogStatus.FAIL, "Message displayed = "+msg);
				 }
				 Thread.sleep(1000);
				 DistributerLocators.clickOkBtn().click();
				
//				Thread.sleep(1000);
//				DistrubutorLocators.clickcloseBtn().click();
				Thread.sleep(1000);
				DistributerLocators.clickdashboard().click();
			
			
		
		}
	public static void BulkUploadDesignationDetailes( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	{
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//	getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(6000);
		DistributerLocators.clickManageMaster().click();
		Thread.sleep(1000);
		DistributerLocators.clickDesignation().click();
		Thread.sleep(1000);
		DistributerLocators.clickUploadBtn().click();
		Thread.sleep(1000);
		DistributerLocators.UploadDesignationDetailes().click();
		
			
			 Thread.sleep(1000);
				DistributerLocators.clickBrowse1().click();
				
				 Robot robot=new Robot();
				 Thread.sleep(5000);
				 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\DesignationSample.xlsx");
				 //copy above file to clipboard
				 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
				 
				 //Now press CRTL
				 Thread.sleep(8000);
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
				DistributerLocators.clickUploadbtnCTCBtn().click();
				
				Thread.sleep(2000);
				String msg=DistributerLocators.clickMsg().getText();
				
				 if(msg.equalsIgnoreCase("File uploaded successfully"))
				 {
					 test.log(LogStatus.PASS, "Message displayed = "+msg);
					 
				 }
				 else
				 {
					 test.log(LogStatus.FAIL, "Message displayed = "+msg);
				 }
				 Thread.sleep(1000);
				 DistributerLocators.clickOkBtn().click();
				

//					 * Thread.sleep(1000); Distr
//					 */ubutorLocators.clickcloseBtn().click();
				Thread.sleep(1000);
				DistributerLocators.clickdashboard().click();
			
			
		
		}
	public static void DeleteDesignation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickManageMaster().click();
		Thread.sleep(1000);
		DistributerLocators.clickDesignation().click();
		Thread.sleep(1000);
		DistributerLocators.clickDeleteBtn().click();
		
		
		Thread.sleep(500);
		  String msg=DistributerLocators.clickDeletemsg().getText();		//Reading Message appeared after save button
		  
		  if(msg.equalsIgnoreCase("Are you sure you want to delete this record?"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
			
			Thread.sleep(500);
			  String msg1=DistributerLocators.clickDeletemsg1().getText();		//Reading Message appeared after save button
			  
			  if(msg1.equalsIgnoreCase("Data Deleted Successfully"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg1);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg1);
			 }
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
		
	}
	public static void DesignationClearBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickManageMaster().click();
		Thread.sleep(1000);
		DistributerLocators.clickDesignation().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickstatus().click();
		Thread.sleep(1000);
		DistributerLocators.selectstatus().click();
		

		Thread.sleep(2000);
		if(DistributerLocators.clickclearBtn().isEnabled())
		{
			Thread.sleep(2000);
			DistributerLocators.clickclearBtn().click();
			 test.log(LogStatus.PASS, "clear button Work Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "clear button not Work Successfully");
		}
		Thread.sleep(2000);
		DistributerLocators.clickdashboard().click();
	}
	


		
	public static void AddEmployer( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		Thread.sleep(1000);
		DistributerLocators.clickAddNewDesignation().click();
		
		Thread.sleep(1000);
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.clickAddNewDesignation().click();
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(10);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		String pename = c.getStringCellValue();
		DistributerLocators.clickPEName().sendKeys(pename);
		
		Thread.sleep(1000);
		Row row1 = sheet.getRow(11);						//Selected 0th index row (First row)
		Cell c1 = row1.getCell(1);						//Selected cell (0 row,1 column)
		String NOB = c1.getStringCellValue();
		DistributerLocators.clickNatureOfBuisness().sendKeys(NOB);

		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath("(//button[normalize-space()='Save'])[1]"));
		action.moveToElement(we).click().build().perform();
		

		
		Thread.sleep(1000);
		String msg=DistributerLocators.clickMsg().getText();
		if(msg.equalsIgnoreCase("Principle Employer saved successfully")||msg.equalsIgnoreCase("Please Enter Unique Principle Employer Name"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
			
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
		
		
		
	}
	
	public static void UpdateEmployer( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		Thread.sleep(1000);
		DistributerLocators.clickUpdateEmp().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.clickUpdateEmp().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickNatureOfBuisness().clear();
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		
		
		Thread.sleep(1000);
		Row row1 = sheet.getRow(11);						//Selected 0th index row (First row)
		Cell c1 = row1.getCell(1);						//Selected cell (0 row,1 column)
		String NOB = c1.getStringCellValue();
		DistributerLocators.clickNatureOfBuisness().sendKeys(NOB);

		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath("(//button[normalize-space()='Save'])[1]"));
		action.moveToElement(we).click().build().perform();

		
		Thread.sleep(1000);
		String msg=DistributerLocators.clickMsg().getText();
		if(msg.equalsIgnoreCase("Principle Employer updated successfully"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
			
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
		
		
		
	}
	
	public static void DeleteEmployer( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickDeleteBtn().click();
		
		if(DistributerLocators.cancelbtn().isEnabled())
		{
		 Thread.sleep(1000);
			DistributerLocators.cancelbtn().click();
			test.log(LogStatus.PASS, "Cancel button working successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cancel button not working successfully.");
		}
		
		Thread.sleep(1000);
		DistributerLocators.clickDeleteBtn().click();
//		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
//		DistributerLocators.clickDeleteBtn().click();
		
		Thread.sleep(1000);
		String msg=DistributerLocators.clickMsg().getText();
		if(msg.equalsIgnoreCase("Are you sure you want to delete Principle Employer?"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
			
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		
		Thread.sleep(1000);
//		DistributerLocators.clickOkBtn().click(); //ME
		
		
//		
//		WebDriverWait wait=new WebDriverWait(getDriver(),50);
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.invisibilityOf(Locators.gridLoad()));
		
		Thread.sleep(9000);
		String msg1=DistributerLocators.clickMsg().getText();
		Thread.sleep(5000);
		if(msg1.equalsIgnoreCase("Principle Employer deleted successfully")||msg1.equalsIgnoreCase("Are you sure you want to delete Principle Employer?"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg1);
			
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg1);
		}
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
		
	}
	
	public static void HolidayMaster( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.holidayMaster().click();
		
		 getDriver().navigate().refresh();
		
		 Thread.sleep(1000);
		 DistributerLocators.holidayMaster().click();
		 Thread.sleep(1000);
		DistributerLocators.clickBrowse1().click();
	
		 Thread.sleep(1000);
		 Robot robot=new Robot();
		 Thread.sleep(5000);
		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\SampleHolidayMaster.xlsx");
		 Thread.sleep(1000);
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		 
		
		 //Now press CRTL
		 Thread.sleep(8000);
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
		DistributerLocators.clickUploadbtnCTCBtn().click();
		
		Thread.sleep(2000);
		String msg=DistributerLocators.clickMsg().getText();
		
		 if(msg.equalsIgnoreCase("File uploaded successfully"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		 Thread.sleep(1000);
		PerformerLocator.clickOkBtn().click();
		Thread.sleep(1000);
	   PerformerLocator.clickdashboard().click();
		
	}
	public static void bulkUpload( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	{
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.bulkUpload().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.bulkUpload().click();
	
		 Thread.sleep(1000);
		DistributerLocators.clickBrowse1().click();
		
		 Robot robot=new Robot();
		 
		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\SamplePE.xlsx");
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
		DistributerLocators.clickUploadbtnCTCBtn().click();
		
		Thread.sleep(2000);
		String msg=DistributerLocators.clickMsg().getText();
		
		 if(msg.equalsIgnoreCase("File uploaded successfully"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		 Thread.sleep(1000);
		PerformerLocator.clickOkBtn().click();
		Thread.sleep(1000);
	   PerformerLocator.clickdashboard().click();
		
	}
	
	public static void EmployeerExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		CountExcel1(test);
	}
	
	public static void SearchBoxEmp( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickSearcbox2().sendKeys("Prashant Dhale");
		
	
		  List<String> li=new ArrayList<String>();
	       
	         li.add("Prashant Dhale");
	        
	
		List<String> filter=new ArrayList<String>();	
		
		filter.add("Prashant Dhale");
	
		
		Thread.sleep(3000);

//		DistributerLocators.readTotalItem1().click();					//Clicking on Text of total items just to scroll down.
		String s = DistributerLocators.readTotalItem1().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);

		List<WebElement> Maharashtra=getDriver().findElements(By.xpath("//*[@role='grid']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[1]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();


		 if(i==0)
				{
					raw.addAll(Maharashtra);
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
		}else {
			test.log(LogStatus.FAIL,"No records found");	
		}
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
		
	}
	
	public static void SearchBoxLocation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickLocation().click();
		

		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(13);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String emp = c.getStringCellValue();
		DistributerLocators.clickemp().sendKeys(emp ,Keys.ENTER);

		
		Thread.sleep(1000);
		DistributerLocators.clickSearcbox2().sendKeys("AHMEDNAGAR");
		
	
		  List<String> li=new ArrayList<String>();
	       
	         li.add("AHMEDNAGAR");
	        
	
		List<String> filter=new ArrayList<String>();	
		
		filter.add("AHMEDNAGAR");
	
		
		Thread.sleep(3000);

		DistributerLocators.readTotalItem2().click();					//Clicking on Text of total items just to scroll down.
		String s = DistributerLocators.readTotalItem2().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);

		List<WebElement> Maharashtra=getDriver().findElements(By.xpath("//*[@role='grid']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[2]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();


		 if(i==0)
				{
					raw.addAll(Maharashtra);
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
		}else {
			test.log(LogStatus.FAIL,"No records found");	
		}
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
		
	}
	public static void LocationExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickLocation().click();
		

		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(5000);
		Row row = sheet.getRow(13);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(5000);
		String emp = c.getStringCellValue();
		DistributerLocators.clickemp().sendKeys(emp ,Keys.ENTER);
		
		Thread.sleep(1000);
		CountExcel2(test);
	}
	
	public static void DeleteLocation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickLocation().click();
		

		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(13);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String emp = c.getStringCellValue();
		DistributerLocators.clickemp().sendKeys(emp ,Keys.ENTER);
		
		Thread.sleep(1000);
		DistributerLocators.clickDeleteBtn().click();
		
		
		if(DistributerLocators.cancelbtn().isEnabled())
		{
		 Thread.sleep(1000);
			DistributerLocators.cancelbtn().click();
			test.log(LogStatus.PASS, "Cancel button working successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cancel button not working successfully.");
		}
		
//		Thread.sleep(1000);
//		DistrubutorLocators.clickDeleteBtn().click();
//		
//		//getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.clickDeleteBtn().click();
		
		Thread.sleep(1000);
		String msg=DistributerLocators.clickMsg().getText();
		if(msg.equalsIgnoreCase("Are you sure you want to delete Principle Employer?"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
			
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		
		Thread.sleep(1000);
//		DistributerLocators.clickOkBtn().click();
		
//		WebDriverWait wait=new WebDriverWait(getDriver(),50);
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.invisibilityOf(Locators.gridLoad()));
		
		Thread.sleep(9000);
		String msg1=DistributerLocators.clickMsg().getText();
		if(msg1.equalsIgnoreCase("Employer Location deleted successfully")||msg1.equalsIgnoreCase("Are you sure you want to delete Principle Employer?"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg1);
			
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg1);
		}
		Thread.sleep(1000);
//		DistributerLocators.clickOkBtn().click();
		
	}
	
	public static void AddLocation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	{
		
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickLocation().click();
		
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(13);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String emp = c.getStringCellValue();
		DistributerLocators.clickemp().sendKeys(emp ,Keys.ENTER);
		
		Thread.sleep(1000);
		DistributerLocators.clickAddNewBtn1().click();
		
		Robot robot = new Robot();  //Me

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);
		
		Thread.sleep(1000);
		Row row1 = sheet.getRow(14);						//Selected 0th index row (First row)
		Cell c1 = row1.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String state = c1.getStringCellValue();
		DistributerLocators.clickState1().sendKeys(state ,Keys.ENTER);
		
		
		Thread.sleep(1000);
		Row row2 = sheet.getRow(15);						//Selected 0th index row (First row)
		Cell c2 = row2.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String location = c2.getStringCellValue();
		DistributerLocators.clickLocation1().sendKeys(location ,Keys.ENTER);
		
		Thread.sleep(1000);
		Row row3 = sheet.getRow(16);						//Selected 0th index row (First row)
		Cell c3 = row3.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String branch = c3.getStringCellValue();
		DistributerLocators.clicKBranch().sendKeys(branch ,Keys.ENTER);
		
		
		Thread.sleep(1000);
		Row row4 = sheet.getRow(17);						//Selected 0th index row (First row)
		Cell c4 = row4.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String branchAddress = c4.getStringCellValue();
		DistributerLocators.clicKBranchAddress().sendKeys(branchAddress);

		Thread.sleep(1000);
		Row row5= sheet.getRow(18);						//Selected 0th index row (First row)
		Cell c5 = row5.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		int NoE = (int) c5.getNumericCellValue();
		DistributerLocators.clickNumber().sendKeys(NoE+"");
		
		Thread.sleep(1000);
		DistributerLocators.clickCalender1().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectDate().click();
		Thread.sleep(1000);
		DistributerLocators.clickCalender2().click();
		Thread.sleep(1000);
		DistributerLocators.selectDate1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickWeekOff().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickPEType().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickPEActType().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.weekHourseFrom().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectweekHourseFrom().click();
		
		Thread.sleep(1000);
		DistributerLocators.weekHourseTo().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectweekHourseTo().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickIntervalTo().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectIntervalTo().click();
		Thread.sleep(1000);
		DistributerLocators.clickIntervalFrom().click();
		Thread.sleep(1000);
		DistributerLocators.selectIntervalFrom().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickLocationApplicablitiy().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		Thread.sleep(2000);
		String msg=DistributerLocators.clickMsg().getText();
		
		 if(msg.equalsIgnoreCase("Principle Employer Location Saved Successfully")||msg.equalsIgnoreCase("Principle Employer Location Exists Already"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		 Thread.sleep(1000);
		PerformerLocator.clickOkBtn().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickcloseBtn().click();
		Thread.sleep(1000);
	   PerformerLocator.clickdashboard().click();
		
	}
	
	public static void editLOcation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	{
		
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		Thread.sleep(1000);
		DistributerLocators.clickLocation().click();
		

		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(13);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String emp = c.getStringCellValue();
		Thread.sleep(1000);
		DistributerLocators.clickemp().sendKeys(emp ,Keys.ENTER);
		
		Thread.sleep(1000);
		DistributerLocators.clickUpdateEmp().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickWeekOff().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType().click();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);
		
		Thread.sleep(10000);
		DistributerLocators.clicksave().click();
		
		Thread.sleep(2000);
		String msg=DistributerLocators.clickMsg().getText();
		
		 if(msg.equalsIgnoreCase("Principle Employer Location Updated Successfully"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		 Thread.sleep(1000);
		PerformerLocator.clickOkBtn().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickcloseBtn().click();
		Thread.sleep(1000);
	   PerformerLocator.clickdashboard().click();
	   
	}
	
	public static void UploadLocation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		Thread.sleep(1000);
		DistributerLocators.clickLocation().click();
		

		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(13);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String emp = c.getStringCellValue();
		Thread.sleep(1000);
		DistributerLocators.clickemp().sendKeys(emp ,Keys.ENTER);
	
		Thread.sleep(1000);
		DistributerLocators.clickUploadLocation().click();
		 
		 Thread.sleep(1000);
		DistributerLocators.clickBrowse1().click();
		
		 Robot robot=new Robot();
		 Thread.sleep(5000);
		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\SampleEmployeeLocation.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		 
		 //Now press CRTL
		 Thread.sleep(8000);
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
		DistributerLocators.clickUploadbtnCTCBtn().click();
		
		Thread.sleep(2000);
		String msg=DistributerLocators.clickMsg().getText();
		
		 if(msg.equalsIgnoreCase("File uploaded successfully"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		 Thread.sleep(1000);
		PerformerLocator.clickOkBtn().click();
		Thread.sleep(1000);
	   PerformerLocator.clickdashboard().click();
		
	}
	
	public static void ComplianceAssignmentRegister( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		
		//AVAREGTR
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickComplianceAssignment().click();
		Thread.sleep(1000);
		DistributerLocators.clickComplianceType().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch().click();
		Thread.sleep(1000);
		DistributerLocators.selectBranch().click();
		
		

		Thread.sleep(1000);
		DistributerLocators.clickCalender().click();
		
//		Thread.sleep(1000);
//		Locator.selectmonth().click();
//		Thread.sleep(1000);
//		Locator.selectYear().click();
//	
//		
//		Actions action = new Actions(getDriver());
//		WebElement we = getDriver().findElement(By.xpath("//td[@title='2021 Jan']"));
//		action.moveToElement(we).click().build().perform();
		
		Thread.sleep(1000);
		PerformerLocator.selectDate1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickPerformer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectPerformer().click();
		Thread.sleep(1000);
		DistributerLocators.clickreviewer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectreviewer().click();
		
		if(DistributerLocators.clickApply().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.clickApply().click();
			test.log(LogStatus.PASS, "Apply Button working successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Apply Button does not working successfully");
		}
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		Thread.sleep(1000);
		String msg=DistributerLocators.CASuccessMsg().getText();
		if(msg.equalsIgnoreCase(msg))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
		
		Thread.sleep(1000);
		String msg1=DistributerLocators.CASuccessMsg1().getText();
		if(msg1.equalsIgnoreCase(msg1))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg1);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg1);
		}
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
			
			Thread.sleep(1000);
			if(DistributerLocators.clickClearBtn().isEnabled())
			{	
				Thread.sleep(1000);
				DistributerLocators.clickClearBtn().click();
				test.log(LogStatus.PASS, "Clear button working successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Clear button not working successfully.");
			}
			
			Thread.sleep(1000);
			DistributerLocators.clickdashboard().click();
		
		
	}
	public static void ComplianceAssignmentReturn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickComplianceAssignment().click();
		Thread.sleep(1000);
		DistributerLocators.clickComplianceType().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch().click();
		Thread.sleep(1000);
		DistributerLocators.selectBranch().click();
		
		

		Thread.sleep(1000);
		DistributerLocators.clickCalender().click();
		
//		Thread.sleep(1000);
//		Locator.selectmonth().click();
//		Thread.sleep(1000);
//		Locator.selectYear().click();
//	
//		
//		Actions action = new Actions(getDriver());
//		WebElement we = getDriver().findElement(By.xpath("//td[@title='2021 Jan']"));
//		action.moveToElement(we).click().build().perform();
		
		Thread.sleep(1000);
		PerformerLocator.selectDate1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickPerformer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectPerformer().click();
		Thread.sleep(1000);
		DistributerLocators.clickreviewer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectreviewer().click();
		
		if(DistributerLocators.clickApply().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.clickApply().click();
			test.log(LogStatus.PASS, "Apply Button working successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Apply Button does not working successfully");
		}
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		Thread.sleep(1000);
		String msg=DistributerLocators.CASuccessMsg().getText();
		if(msg.equalsIgnoreCase(msg))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
		
		Thread.sleep(1000);
		String msg1=DistributerLocators.CASuccessMsg1().getText();
		if(msg1.equalsIgnoreCase(msg1))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg1);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg1);
		}
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
			
			Thread.sleep(1000);
			DistributerLocators.clickdashboard().click();
		
		
	}
	public static void ComplianceAssignmentChallan( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickComplianceAssignment().click();
		Thread.sleep(1000);
		DistributerLocators.clickComplianceType().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType2().click();
		Thread.sleep(1000);
		DistributerLocators.clickType().click();
		Thread.sleep(1000);
		DistributerLocators.selectType().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch().click();
		Thread.sleep(1000);
		DistributerLocators.selectBranch().click();
		
		

		Thread.sleep(1000);
		DistributerLocators.clickCalender().click();
		

		Thread.sleep(1000);
		PerformerLocator.selectDate1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickPerformer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectPerformer().click();
		Thread.sleep(1000);
		DistributerLocators.clickreviewer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectreviewer().click();
		
		if(DistributerLocators.clickApply().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.clickApply().click();
			test.log(LogStatus.PASS, "Apply Button working successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Apply Button does not working successfully");
		}
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		Thread.sleep(1000);
		String msg=DistributerLocators.CASuccessMsg().getText();
		if(msg.equalsIgnoreCase(msg))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
		
		Thread.sleep(1000);
		String msg1=DistributerLocators.CASuccessMsg1().getText();
		if(msg1.equalsIgnoreCase(msg1))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg1);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg1);
		}
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
			
			Thread.sleep(1000);
			DistributerLocators.clickdashboard().click();
		
		
	}
	public static void SearchBox( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickComplianceAssignment().click();
		Thread.sleep(1000);
		DistributerLocators.clickComplianceType().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch().click();
		Thread.sleep(1000);
		DistributerLocators.selectBranch().click();
	
		Thread.sleep(1000);
		DistributerLocators.clickCalender().click();
	
		Thread.sleep(1000);
		PerformerLocator.selectDate1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickPerformer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectPerformer().click();
		Thread.sleep(1000);
		DistributerLocators.clickreviewer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectreviewer().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickSearcbox().sendKeys("Maharashtra");
		
		Thread.sleep(1000);
		DistributerLocators.clickApply().click();
		
		
		  List<String> li=new ArrayList<String>();
	       
	         li.add("Maharashtra");
	        
	
		List<String> filter=new ArrayList<String>();	
		
		filter.add("Maharashtra");
	
		
		Thread.sleep(3000);

//		PerformerLocator.readTotalItems().click();					//Clicking on Text of total items just to scroll down.
		String s = PerformerLocator.readTotalItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);

		List<WebElement> Maharashtra=getDriver().findElements(By.xpath("//*[@role='grid']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[5]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();


		 if(i==0)
				{
					raw.addAll(Maharashtra);
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
		}else {
			test.log(LogStatus.FAIL,"No records found");	
		}
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
		
	}
	
	public static void ValidationMesssage( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		Thread.sleep(1000);
		DistributerLocators.clickComplianceAssignment().click();
		Thread.sleep(1000);
		DistributerLocators.clickComplianceType().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType().click();
		Thread.sleep(1000);
		DistributerLocators.clickApply().click();
		
		Thread.sleep(1000);
		String msg=DistributerLocators.validmsg().getText();
		
		if(msg.equalsIgnoreCase("Please Select the Branch and Date"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		 Thread.sleep(1000);
		 DistributerLocators.clickOkBtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
	}
	
	public static void WithoutselectingPerformerReviewer( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickComplianceAssignment().click();
		Thread.sleep(1000);
		DistributerLocators.clickComplianceType().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType().click(); //selectComplianceType2
		Thread.sleep(1000);
//		DistributerLocators.clickType().click();
		Thread.sleep(1000);
//		DistributerLocators.selectType().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch().click();
		Thread.sleep(1000);
		DistributerLocators.selectBranch().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickCalender().click();
		

		Thread.sleep(1000);
		PerformerLocator.selectDate1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickApply().click();
			
		
		Thread.sleep(2000);
		DistributerLocators.clickCheckBox().click();
		
		Thread.sleep(2000);
		DistributerLocators.clickCheckBox1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		Thread.sleep(1000);
		DistributerLocators.CASuccessMsg().click();
	
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
		
		Thread.sleep(1000);
		String msg2=DistributerLocators.validmsg1().getText();
		if(msg2.equalsIgnoreCase("Please Select the Performer"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg2);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg2);
		}
		 Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
			
		Thread.sleep(1000);
		DistributerLocators.clickPerformer().click();
			
		Thread.sleep(1000);
		DistributerLocators.selectPerformer().click();
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
		
		Thread.sleep(1000);
		String msg1=DistributerLocators.validmsg2().getText();
		if(msg1.equalsIgnoreCase("Please Select the Reviewer"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg1);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg1);
		}
		 Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
			
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
		
	}
	
	public static void Complianceactivationcancelbtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickComplianceAssignment().click();
		Thread.sleep(1000);
		DistributerLocators.clickComplianceType().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch().click();
		Thread.sleep(1000);
		DistributerLocators.selectBranch().click();
	
		Thread.sleep(1000);
		DistributerLocators.clickCalender().click();
		
		Thread.sleep(1000);
		PerformerLocator.selectDate1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickPerformer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectPerformer().click();
		Thread.sleep(1000);
		DistributerLocators.clickreviewer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectreviewer().click();
		
		
			Thread.sleep(1000);
			DistributerLocators.clickApply().click();
			
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		if(DistributerLocators.cancelbtn().isEnabled())
		{
		 Thread.sleep(1000);
			DistributerLocators.cancelbtn().click();
			test.log(LogStatus.PASS, "Cancel button working successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cancel button not working successfully.");
		}
	
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
		
	}
	public static void ManageCompliance( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		
		if(DistributerLocators.managecompliance().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.managecompliance().click();
			test.log(LogStatus.PASS, "Name of compliance reassignment should be visible as Manage Compliances");
		}
		else
		{
			test.log(LogStatus.FAIL, "Name of compliance reassignment should not be visible as Manage Compliances");
		}
		
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
	}
	
	public static void ComplainceReassignment( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();
		Thread.sleep(1000);
		DistributerLocators.clickComplianceType1().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		Thread.sleep(1000);
		DistributerLocators.clickBranch1().click();
		Thread.sleep(1000);
		DistributerLocators.clickBranchTiangle().click();
		Thread.sleep(1000);
		DistributerLocators.selectBranch1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickRole().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickUser().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickNewUser().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		if(DistributerLocators.applybtn().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.applybtn().click();
			test.log(LogStatus.PASS, "Apply Button working successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Apply Button does not working successfully");
		}
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		Thread.sleep(1000);
		String msg=DistributerLocators.CRValidDate().getText();
		if(msg.equalsIgnoreCase("Compliance Reassigned Successfully"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
		
		Thread.sleep(1000);
		if(DistributerLocators.clickClearBtn().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.clickClearBtn().click();
			test.log(LogStatus.PASS, "Clear Button working successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Clear Button does not working successfully");
		}
		
		 
			Thread.sleep(1000);
			DistributerLocators.clickdashboard().click();
		
	}
	
	public static void ManageComplianceFilter( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();

		Thread.sleep(1000);
		DistributerLocators.clickComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch1().click();
		Thread.sleep(1000);
		DistributerLocators.clickBranchTiangle1().click();
	     Thread.sleep(1000);
		DistributerLocators.selectBranch1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickRole().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickUser().click();
		Thread.sleep(500);
	     String AssignedUser = DistributerLocators.selectComplianceType1().getText();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickNewUser().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();		
		
		Thread.sleep(1000);
//		DistributerLocators.clickSearcbox1().sendKeys("Gujarat");
		
		Thread.sleep(1000);
		DistributerLocators.applybtn().click();
		
		
		  List<String> li=new ArrayList<String>();
	       
		  //li.add("Branch");
		  li.add(AssignedUser);
	         li.add("Andhra Pradesh");
	        
	
		List<String> filter=new ArrayList<String>();	
		
		//filter.add("branch");
		filter.add("AssignedUser");
		filter.add("Andhra Pradesh");
	
		
		Thread.sleep(3000);

//		PerformerLocator.readTotalItems().click();					//Clicking on Text of total items just to scroll down.
		String s = PerformerLocator.readTotalItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);

		//List<WebElement> branchCol=getDriver().findElements(By.xpath("//*[@role='grid']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[4]"));
		List<WebElement> AssignedUsercol=getDriver().findElements(By.xpath("//*[@role='grid']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[8]"));
		List<WebElement> Maharashtra=getDriver().findElements(By.xpath("//*[@role='grid']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[3]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();


//		 if(i==0)
//				{
//					raw.addAll(branchCol);
//				}
			
		 if(i==0)
		   {
			 raw.addAll(AssignedUsercol);
		   }
		 
		 else if(i==1)
		   {
			 raw.addAll(Maharashtra);
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
	
	public static void ActivationDateChange( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickActivityDropDown().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch1().click();
		Thread.sleep(1000);
		DistributerLocators.clickBranchTiangle().click();
	     Thread.sleep(1000);
		DistributerLocators.selectBranch1().click();
		Thread.sleep(1000);
		DistributerLocators.applybtn().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox().click();
		
		Thread.sleep(1000);
		if(DistributerLocators.ActivationDateChangeCalender().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.ActivationDateChangeCalender().click();
			test.log(LogStatus.PASS, "Calender should get visible in the activation field.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Calender should not get visible in the activation field.");
		}
		
	
		Thread.sleep(1000);
		PerformerLocator.selectDate1().click();
		
		Thread.sleep(1000);
		if(DistributerLocators.clicksave().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.clicksave().click();
			test.log(LogStatus.PASS, " 'Save' button should get enabled.");
		}
		else
		{
			test.log(LogStatus.FAIL, " 'Save' button should not get enabled.");
		}
		
		
	
		Thread.sleep(1000);
		String msg=DistributerLocators.ActivationDateChangeMsg().getText();
		if(msg.equalsIgnoreCase("Activation Date Updated"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
	}
	public static void AssignmentRemoval( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickActivityDropDown().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch1().click();
		Thread.sleep(1000);
		DistributerLocators.clickBranchTiangle().click();
	     Thread.sleep(1000);
		DistributerLocators.selectBranch1().click();
		Thread.sleep(1000);
		DistributerLocators.applybtn().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox().click();
		
		Thread.sleep(1000);
		if(DistributerLocators.clickRemoveBtn().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.clickRemoveBtn().click();
			test.log(LogStatus.PASS, " 'Remove' button should get enabled.");
		}
		else
		{
			test.log(LogStatus.FAIL, " 'Remove' button should not get enabled.");
		}
		
		Thread.sleep(1000);
		String msg=DistributerLocators.AssignmentRemovalMsg().getText();
		if(msg.equalsIgnoreCase("Assignment Removed Successfully"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
	}
	public static void ScheduleCreation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickActivityDropDown().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType3().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickComplianceType1().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		Thread.sleep(1000);
		DistributerLocators.clickPeriod().click();
		
		Thread.sleep(1000);
		if(DistributerLocators.PeriodList().isEnabled())
		{
			test.log(LogStatus.PASS, "Dropdown list of months should get visible.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Dropdown list of months should not get visible.");
		}
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		Thread.sleep(1000);
		DistributerLocators.clickYear().click();
		
		Thread.sleep(1000);
		if(DistributerLocators.PeriodList().isEnabled())
		{
			test.log(LogStatus.PASS, "Dropdown list of Year should get visible.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Dropdown list of Year should not get visible.");
		}
		
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		

		Thread.sleep(1000);
		DistributerLocators.clickSubmit().click();
			
		Thread.sleep(1000);
		String msg=DistributerLocators.ScheduleCreationMsg().getText();
		if(msg.equalsIgnoreCase("Schedule created successfully."))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
	}
	
	public static void WithoutSelctingFieldScheduleCreation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickActivityDropDown().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType3().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickSubmit().click();
			
		Thread.sleep(1000);
		//String msg=DistrubutorLocators.ScheduleCreationMsg().getText();
		String msg=DistributerLocators.clickMsg().getText();
		
		if(msg.equalsIgnoreCase("Please select Compliance Type, Period, and Year before submitting."))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
	}
	
	public static void ScheduleRemoval( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickActivityDropDown().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType4().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch1().click();
		Thread.sleep(1000);
		DistributerLocators.clickBranchTiangle().click();
	     Thread.sleep(1000);
		DistributerLocators.selectBranch1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickPeriod().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		Thread.sleep(1000);
		DistributerLocators.clickYear().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.applybtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox().click();
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox1().click();

		
		Thread.sleep(1000);
		if(DistributerLocators.clickRemoveBtn().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.clickRemoveBtn().click();
			test.log(LogStatus.PASS, " 'Remove' button should get enabled.");
		}
		else
		{
			test.log(LogStatus.FAIL, " 'Remove' button should not get enabled.");
		}
		
		Thread.sleep(1000);
		//String msg=DistrubutorLocators.ScheduleRemovalMsg().getText();
		String msg=DistributerLocators.clickMsg().getText();
		if(msg.equalsIgnoreCase("Schedule Removed Successfully"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
	}
	
	public static void Contractor( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickContractor().click();
		
		Thread.sleep(1000);
		DistributerLocators.UpdateContractor().click();
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		Thread.sleep(2000);
		String msg=DistributerLocators.clickMsg().getText();
		
		 if(msg.equalsIgnoreCase("Contractor Saved Successfully"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		 Thread.sleep(1000);
		PerformerLocator.clickOkBtn().click();
		
		
		Thread.sleep(1000);
	   PerformerLocator.clickdashboard().click();
		
		
	}
	
	public static void EmpMapping( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(8000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(3000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickEmpMapping().click();
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(13);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String emp = c.getStringCellValue();
		DistributerLocators.clickemp().sendKeys(emp ,Keys.ENTER);
		
		Thread.sleep(1000);
		Row row1 = sheet.getRow(19);						//Selected 0th index row (First row)
		Cell c1 = row1.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String state = c1.getStringCellValue();
		DistributerLocators.clickState2().sendKeys(state ,Keys.ENTER);
		
		
		Thread.sleep(1000);
		Row row2 = sheet.getRow(20);						//Selected 0th index row (First row)
		Cell c2 = row2.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String location = c2.getStringCellValue();
		DistributerLocators.clickState1().sendKeys(location ,Keys.ENTER);
		
		Thread.sleep(1000);
		Row row3 = sheet.getRow(21);						//Selected 0th index row (First row)
		Cell c3 = row3.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String branch = c3.getStringCellValue();
		DistributerLocators.clickLocation1().sendKeys(branch ,Keys.ENTER);
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBoxEmpMapping().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickMigrate().click();
		
		Thread.sleep(1000);
		Row row4 = sheet.getRow(14);						//Selected 0th index row (First row)
		Cell c4 = row4.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String state2 = c4.getStringCellValue();
		DistributerLocators.clickMigrateState().sendKeys(state2 ,Keys.ENTER);
		
/*		DistributerLocators.clickMigrateLocation().click();
		Thread.sleep(1000);
		Row row6 = sheet.getRow(22);						//Selected 0th index row (First row)
		Cell c6 = row6.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String location3 = c6.getStringCellValue();
		DistributerLocators.clickMigrateLocation().sendKeys(location3 ,Keys.ENTER); */
	
		
/*		Thread.sleep(1000);
		Row row5 = sheet.getRow(16);						//Selected 0th index row (First row)
		Cell c5 = row5.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String branch1 = c5.getStringCellValue();
		DistributerLocators.clickMigrateBranch().sendKeys(branch1 ,Keys.ENTER); */
		
		Thread.sleep(2000);
		DistributerLocators.selectPELoaction().click();
		Thread.sleep(2000);
		DistributerLocators.selectPELocationValue().click();
		Thread.sleep(2000);
		DistributerLocators.selectPEBranch().click();
		Thread.sleep(2000);
		DistributerLocators.selectPELocationValue().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickCalender1().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectDate().click();
		Thread.sleep(1000);
		DistributerLocators.clickCalender2().click();
		Thread.sleep(1000);
		DistributerLocators.selectDate1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickCalender3().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectDate2().click();
		Thread.sleep(1000);
		DistributerLocators.clickCalender4().click();
		Thread.sleep(1000);
		DistributerLocators.selectDate3().click();
		
		Thread.sleep(4000);
		DistributerLocators.clicksave().click();
		
		Thread.sleep(30000);
		String msg=DistributerLocators.clickMsg().getText();
		
		 if(msg.equalsIgnoreCase("Employees Migrated Successfully"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		 Thread.sleep(1000);
		PerformerLocator.clickOkBtn().click();
		
		
		Thread.sleep(1000);
	   PerformerLocator.clickdashboard().click();
		
	}
	
	public static void UpdateEmpMapping( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(3000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickEmpMapping().click();
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(13);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String emp = c.getStringCellValue();
		DistributerLocators.clickemp().sendKeys(emp ,Keys.ENTER);
		
		Thread.sleep(1000);
		Row row1 = sheet.getRow(19);						//Selected 0th index row (First row)
		Cell c1 = row1.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String state = c1.getStringCellValue();
		DistributerLocators.clickState2().sendKeys(state ,Keys.ENTER);
		
		
		Thread.sleep(1000);
		Row row2 = sheet.getRow(20);						//Selected 0th index row (First row)
		Cell c2 = row2.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String location = c2.getStringCellValue();
		DistributerLocators.clickState1().sendKeys(location ,Keys.ENTER);
		
		Thread.sleep(1000);
		Row row3 = sheet.getRow(21);						//Selected 0th index row (First row)
		Cell c3 = row3.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String branch = c3.getStringCellValue();
		DistributerLocators.clickLocation1().sendKeys(branch ,Keys.ENTER);
		
		Thread.sleep(1000);
		DistributerLocators.clickUpdateEmp().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickContractEndReaseon().sendKeys("Test");
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		Thread.sleep(3000);
		String msg=DistributerLocators.clickMsg().getText();
		
		 if(msg.equalsIgnoreCase("Employee Updated Successfully"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		 Thread.sleep(1000);
		PerformerLocator.clickOkBtn().click();
		
		
		Thread.sleep(1000);
	   PerformerLocator.clickdashboard().click();
		
		
	}
	public static void ExportEmpMapping( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(3000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickEmpMapping().click();
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(13);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String emp = c.getStringCellValue();
		DistributerLocators.clickemp().sendKeys(emp ,Keys.ENTER);
		
		Thread.sleep(1000);
		Row row1 = sheet.getRow(19);						//Selected 0th index row (First row)
		Cell c1 = row1.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String state = c1.getStringCellValue();
		DistributerLocators.clickState2().sendKeys(state ,Keys.ENTER);
		
		
		Thread.sleep(1000);
		Row row2 = sheet.getRow(20);						//Selected 0th index row (First row)
		Cell c2 = row2.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String location = c2.getStringCellValue();
		DistributerLocators.clickState1().sendKeys(location ,Keys.ENTER);
		
		Thread.sleep(1000);
		Row row3 = sheet.getRow(21);						//Selected 0th index row (First row)
		Cell c3 = row3.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String branch = c3.getStringCellValue();
		DistributerLocators.clickLocation1().sendKeys(branch ,Keys.ENTER);
	
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
	
		Thread.sleep(1000);
		PerformerLocator.clickExportOnboardEntity().click();
		
	
		Thread.sleep(10000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
	
		if(dirContents.length < allFilesNew.length)
		{
		
			Thread.sleep(10000);					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	    {
	       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	       {
	           lastModifiedFile = allFilesNew[i];
	       }
	    }
		}
}
	public static void deleteEmpMapping( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(3000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickEmpMapping().click();
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(13);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String emp = c.getStringCellValue();
		DistributerLocators.clickemp().sendKeys(emp ,Keys.ENTER);
		
		Thread.sleep(1000);
		Row row1 = sheet.getRow(19);						//Selected 0th index row (First row)
		Cell c1 = row1.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String state = c1.getStringCellValue();
		DistributerLocators.clickState2().sendKeys(state ,Keys.ENTER);
		
		
		Thread.sleep(1000);
		Row row2 = sheet.getRow(20);						//Selected 0th index row (First row)
		Cell c2 = row2.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String location = c2.getStringCellValue();
		DistributerLocators.clickState1().sendKeys(location ,Keys.ENTER);
		
		Thread.sleep(1000);
		Row row3 = sheet.getRow(21);						//Selected 0th index row (First row)
		Cell c3 = row3.getCell(1);						//Selected cell (0 row,1 column)
		Thread.sleep(1000);
		String branch = c3.getStringCellValue();
		DistributerLocators.clickLocation1().sendKeys(branch ,Keys.ENTER);
		
		Thread.sleep(1000);
		DistributerLocators.clickDeleteBtn().click();
		
		
		if(DistributerLocators.cancelbtn().isEnabled())
		{
		 Thread.sleep(1000);
			DistributerLocators.cancelbtn().click();
			test.log(LogStatus.PASS, "Cancel button working successfully.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cancel button not working successfully.");
		}
		
	
		
		Thread.sleep(1000);
		DistributerLocators.clickDeleteBtn().click();
		
		Thread.sleep(1000);
		String msg=DistributerLocators.clickMsg().getText();
		if(msg.equalsIgnoreCase("Are you certain you want to delete Principle Employer?"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
			
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();

		
		Thread.sleep(9000);
		String msg1=DistributerLocators.clickMsg().getText();
		if(msg1.equalsIgnoreCase("Contractor deleted successfully"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg1);
			
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg1);
		}
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
		
	}
	
	public static void ComplianceAssignmentRegisterCLRA( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(3000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickComplianceAssignment().click();
		Thread.sleep(1000);
		DistributerLocators.clickComplianceType().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch().click();
		Thread.sleep(1000);
		DistributerLocators.selectBranch().click();
		
		

		Thread.sleep(1000);
		DistributerLocators.clickCalender().click();
		
//		Thread.sleep(1000);
//		Locator.selectmonth().click();
//		Thread.sleep(1000);
//		Locator.selectYear().click();
//	
//		
//		Actions action = new Actions(getDriver());
//		WebElement we = getDriver().findElement(By.xpath("//td[@title='2021 Jan']"));
//		action.moveToElement(we).click().build().perform();
		
		Thread.sleep(1000);
		PerformerLocator.selectDate1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickPerformer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectPerformer().click();
		Thread.sleep(1000);
		DistributerLocators.clickreviewer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectreviewer().click();
		
		if(DistributerLocators.clickApply().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.clickApply().click();
			test.log(LogStatus.PASS, "Apply Button working successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Apply Button does not working successfully");
		}
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		Thread.sleep(1000);
		String msg=DistributerLocators.CASuccessMsg().getText();
		if(msg.equalsIgnoreCase(msg))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
		
		Thread.sleep(1000);
		String msg1=DistributerLocators.CASuccessMsg1().getText();
		if(msg1.equalsIgnoreCase(msg1))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg1);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg1);
		}
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
			
			Thread.sleep(1000);
			if(DistributerLocators.clickClearBtn().isEnabled())
			{	
				Thread.sleep(1000);
				DistributerLocators.clickClearBtn().click();
				test.log(LogStatus.PASS, "Clear button working successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Clear button not working successfully.");
			}
			
			Thread.sleep(1000);
			DistributerLocators.clickdashboard().click();
		
		
	}
	public static void ComplianceAssignmentRetrunCLRA( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(3000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickComplianceAssignment().click();
		Thread.sleep(1000);
		DistributerLocators.clickComplianceType().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch().click();
		Thread.sleep(1000);
		DistributerLocators.selectBranch().click();
		
		

		Thread.sleep(1000);
		DistributerLocators.clickCalender().click();

		
		Thread.sleep(1000);
		PerformerLocator.selectDate1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickPerformer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectPerformer().click();
		Thread.sleep(1000);
		DistributerLocators.clickreviewer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectreviewer().click();
		
			
		Thread.sleep(1000);
		DistributerLocators.clickApply().click();
		
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox().click();
		
//		Thread.sleep(1000);
//		Locators.clickCheckBox1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		Thread.sleep(1000);
		String msg=DistributerLocators.CASuccessMsg().getText();
		if(msg.equalsIgnoreCase(msg))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
		
		Thread.sleep(1000);
		String msg1=DistributerLocators.CASuccessMsg1().getText();
		if(msg1.equalsIgnoreCase(msg1))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg1);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg1);
		}
		 Thread.sleep(1000);
			DistributerLocators.clickOkBtn().click();
			
			Thread.sleep(1000);
			DistributerLocators.clickdashboard().click();
		
		
	}
	
	public static void SearchBoxComplianceAssignment( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(3000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickComplianceAssignment().click();
		Thread.sleep(1000);
		DistributerLocators.clickComplianceType().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch().click();
		Thread.sleep(1000);
		DistributerLocators.selectBranch().click();
	
		Thread.sleep(1000);
		DistributerLocators.clickCalender().click();
	
		Thread.sleep(1000);
		PerformerLocator.selectDate1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickPerformer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectPerformer().click();
		Thread.sleep(1000);
		DistributerLocators.clickreviewer().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectreviewer().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickApply().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickSearcbox().sendKeys("Mumbai");
		
		Thread.sleep(1000);
		DistributerLocators.clickApply().click();
		
		
		  List<String> li=new ArrayList<String>();
	       
	         li.add("Mumbai");
	        
	
		List<String> filter=new ArrayList<String>();	
		
		filter.add("Mumbai");
	
		
		Thread.sleep(3000);

//		PerformerLocator.readTotalItems().click();					//Clicking on Text of total items just to scroll down.
		String s = PerformerLocator.readTotalItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);

		List<WebElement> Maharashtra=getDriver().findElements(By.xpath("//*[@role='grid']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[4]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();


		 if(i==0)
				{
					raw.addAll(Maharashtra);
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
		}else {
			test.log(LogStatus.FAIL,"No records found");	
		}
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
		
	}
	
	public static void ManageComplianceCLRA( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(3000);
		DistributerLocators.clickOnboardCLRA().click();
		
		
		if(DistributerLocators.managecompliance().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.managecompliance().click();
			test.log(LogStatus.PASS, "Name of compliance reassignment should be visible as Manage Compliances");
		}
		else
		{
			test.log(LogStatus.FAIL, "Name of compliance reassignment should not be visible as Manage Compliances");
		}
		
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
	}
	
	public static void ComplainceReassignmentCLRA( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(3000);
		DistributerLocators.clickOnboardCLRA().click();
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();
		Thread.sleep(1000);
		DistributerLocators.clickComplianceType1().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		Thread.sleep(1000);
		DistributerLocators.clickBranch1().click();
		Thread.sleep(1000);
		DistributerLocators.clickBranchTiangle1().click();
		Thread.sleep(1000);
		DistributerLocators.selectBranch1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickRole().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickUser().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickNewUser().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		if(DistributerLocators.applybtn().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.applybtn().click();
			test.log(LogStatus.PASS, "Apply Button working successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Apply Button does not working successfully");
		}
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clicksave().click();
		
		Thread.sleep(1000);
		String msg=DistributerLocators.CRValidDate().getText();
		if(msg.equalsIgnoreCase("Compliance Reassigned Successfully"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
		
		Thread.sleep(1000);
		if(DistributerLocators.clickClearBtn().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.clickClearBtn().click();
			test.log(LogStatus.PASS, "Clear Button working successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Clear Button does not working successfully");
		}
		
		 
			Thread.sleep(1000);
			DistributerLocators.clickdashboard().click();
		
	}
	
	public static void ManageComplianceFilterCLRA( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(3000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();

		Thread.sleep(1000);
		DistributerLocators.clickComplianceType1().click();
		
		
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch1().click();
		Thread.sleep(1000);
		DistributerLocators.clickBranchTiangle1().click();
	     Thread.sleep(1000);
		DistributerLocators.selectBranch1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickRole().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickUser().click();
		Thread.sleep(500);
	     String AssignedUser = DistributerLocators.selectComplianceType1().getText();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickNewUser().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();		
		
		Thread.sleep(1000);
		DistributerLocators.clickSearcbox1().sendKeys("Mumbai");
		
		Thread.sleep(1000);
		DistributerLocators.applybtn().click();
		
		
		  List<String> li=new ArrayList<String>();
	       
		  //li.add("Branch");
		  li.add(AssignedUser);
	         li.add("Mumbai");
	        
	
		List<String> filter=new ArrayList<String>();	
		
		//filter.add("branch");
		filter.add("AssignedUser");
		filter.add("Gujarat");
	
		
		Thread.sleep(3000);

		PerformerLocator.readTotalItems().click();					//Clicking on Text of total items just to scroll down.
		String s = PerformerLocator.readTotalItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);

		//List<WebElement> branchCol=getDriver().findElements(By.xpath("//*[@role='grid']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[4]"));
		List<WebElement> AssignedUsercol=getDriver().findElements(By.xpath("//*[@role='grid']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[8]"));
		List<WebElement> Maharashtra=getDriver().findElements(By.xpath("//*[@role='grid']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[3]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();


//		 if(i==0)
//				{
//					raw.addAll(branchCol);
//				}
			
		 if(i==0)
		   {
			 raw.addAll(AssignedUsercol);
		   }
		 
		 else if(i==1)
		   {
			 raw.addAll(Maharashtra);
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
	
	public static void ActivationDateChangeCLRA( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(3000);
		DistributerLocators.clickOnboardCLRA().click();
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickActivityDropDown().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch1().click();
//		Thread.sleep(1000);
//		Locators.clickBranchTiangle1().click();
	     Thread.sleep(1000);
		DistributerLocators.selectBranch2().click();
		
		Thread.sleep(1000);
		DistributerLocators.applybtn().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox().click();
		
		Thread.sleep(1000);
		if(DistributerLocators.ActivationDateChangeCalender().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.ActivationDateChangeCalender().click();
			test.log(LogStatus.PASS, "Calender should get visible in the activation field.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Calender should not get visible in the activation field.");
		}
		
	
		Thread.sleep(1000);
		PerformerLocator.selectDate1().click();
		
		Thread.sleep(1000);
		if(DistributerLocators.clicksave().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.clicksave().click();
			test.log(LogStatus.PASS, " 'Save' button should get enabled.");
		}
		else
		{
			test.log(LogStatus.FAIL, " 'Save' button should not get enabled.");
		}
		
		
	
		Thread.sleep(1000);
		String msg=DistributerLocators.ActivationDateChangeMsg().getText();
		if(msg.equalsIgnoreCase("Activation Date Updated"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
	}
	
	public static void AssignmentRemovalCLRA( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(3000);
		DistributerLocators.clickOnboardCLRA().click();
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickActivityDropDown().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch1().click();

		Thread.sleep(1000);
		DistributerLocators.clickCheckBox2().click();
		
//		Thread.sleep(1000);
//		Locators.clickBranch1().click();
//		Thread.sleep(1000);
//		Locators.clickBranchTiangle().click();
//	     Thread.sleep(1000);
//		Locators.selectBranch1().click();
		Thread.sleep(1000);
		DistributerLocators.applybtn().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox().click();
		
		Thread.sleep(1000);
		if(DistributerLocators.clickRemoveBtn().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.clickRemoveBtn().click();
			test.log(LogStatus.PASS, " 'Remove' button should get enabled.");
		}
		else
		{
			test.log(LogStatus.FAIL, " 'Remove' button should not get enabled.");
		}
		
		Thread.sleep(1000);
		String msg=DistributerLocators.AssignmentRemovalMsg().getText();
		if(msg.equalsIgnoreCase("Assignment Removed Successfully"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
	}
	
	public static void ScheduleCreationCLRA( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(3000);
		DistributerLocators.clickOnboardCLRA().click();
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickActivityDropDown().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType3().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickComplianceType1().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		Thread.sleep(1000);
		DistributerLocators.clickPeriod().click();
		
		Thread.sleep(1000);
		if(DistributerLocators.PeriodList().isEnabled())
		{
			test.log(LogStatus.PASS, "Dropdown list of months should get visible.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Dropdown list of months should not get visible.");
		}
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		Thread.sleep(1000);
		DistributerLocators.clickYear().click();
		
		Thread.sleep(1000);
		if(DistributerLocators.PeriodList().isEnabled())
		{
			test.log(LogStatus.PASS, "Dropdown list of Year should get visible.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Dropdown list of Year should not get visible.");
		}
		
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		

		Thread.sleep(1000);
		DistributerLocators.clickSubmit().click();
			
		Thread.sleep(1000);
		String msg=DistributerLocators.ScheduleCreationMsg().getText();
		if(msg.equalsIgnoreCase("Schedule created successfully."))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
	}
	
	public static void WithoutSelctingFieldScheduleCreationCLRA( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(3000);
		DistributerLocators.clickOnboardCLRA().click();
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickActivityDropDown().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType3().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickSubmit().click();
			
		Thread.sleep(1000);
		String msg=DistributerLocators.clickMsg().getText();
		if(msg.equalsIgnoreCase("Schedule created successfully."))
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
	}
	
	public static void ScheduleRemovalCLRA( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(1000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(3000);
		DistributerLocators.clickOnboardCLRA().click();
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickActivityDropDown().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType4().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickBranch1().click();
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox2().click();
		
//		Thread.sleep(1000);
//		Locators.clickBranchTiangle().click();
//	     Thread.sleep(1000);
//		Locators.selectBranch1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickPeriod().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType5().click();
		Thread.sleep(1000);
		DistributerLocators.clickYear().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType2().click();
		
		Thread.sleep(1000);
		DistributerLocators.applybtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickCheckBox1().click();

		
		Thread.sleep(1000);
		if(DistributerLocators.clickRemoveBtn().isEnabled())
		{
			Thread.sleep(1000);
			DistributerLocators.clickRemoveBtn().click();
			test.log(LogStatus.PASS, " 'Remove' button should get enabled.");
		}
		else
		{
			test.log(LogStatus.FAIL, " 'Remove' button should not get enabled.");
		}
		
		Thread.sleep(1000);
		String msg=DistributerLocators.ScheduleRemovalMsg().getText();
		if(msg.equalsIgnoreCase("Schedule Removed Successfully"))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
		Thread.sleep(1000);
		DistributerLocators.clickdashboard().click();
		
	}
	public static void selectOptionFromDropDown_bs(List<WebElement> options, String value) 
	{
		
		for(WebElement option:options)
		{
			if(option.getText().equals(value))
			{
				option.click();
				break;
			}
		}
	}
 }

	
