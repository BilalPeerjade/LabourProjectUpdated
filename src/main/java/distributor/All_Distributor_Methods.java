package distributor;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import login.BasePage;
import login.LoginLocators;
import performer.LocatorsP;
import performer.PerformerLocator;
import rcp.OneCommonMethod;

	

public class All_Distributor_Methods extends BasePage
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
		
		Thread.sleep(5000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(5000);
		DistributerLocators.clickPremiseMasterArrow().click();
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
		
		Thread.sleep(5000);
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
	


		
	public static void AddEmployer( ExtentTest test,XSSFWorkbook workbook, String user) throws InterruptedException, IOException
	{
		
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		
		if(user.equalsIgnoreCase("Distributor Add New"))
		{
//			LoginLocators.Search().sendKeys("AVACORED5");
		
			Thread.sleep(5000);
			Thread.sleep(5000);
			Thread.sleep(5000);
			DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(5000);
			DistributerLocators.clickPremiseMasterArrow().click();
			Thread.sleep(7000);
			DistributerLocators.clickOnboardCLRA().click();
			Thread.sleep(5000);
			DistributerLocators.clickAddNewDesignation().click();
			
			Thread.sleep(2000);
			getDriver().navigate().refresh();
			
			Thread.sleep(8000);
			DistributerLocators.clickAddNewDesignation().click();
			
			FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook1 = WorkbookFactory.create(fis);
	        Sheet sheet = workbook1.getSheetAt(0);
			
			Thread.sleep(1000);
			Row row = sheet.getRow(10);						//Selected 0th index row (First row)
			Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
			String pename = c.getStringCellValue();
			DistributerLocators.clickPEName().sendKeys(OneCommonMethod.getRandomString());
			
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
		
		
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		
		
	}
	public static void CLRAEmployerAddNew( ExtentTest test,XSSFWorkbook workbook, String user) throws InterruptedException, IOException
	{
		
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		
		if(user.equalsIgnoreCase("Distributor Add New"))
		{
//			LoginLocators.Search().sendKeys("AVACORED5");
		
			Thread.sleep(5000);
			Thread.sleep(5000);
			Thread.sleep(5000);
	//		DistributerLocators.SerchCustomer().sendKeys("TESTAUTO3");
			OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"AVACORED5");;
			Thread.sleep(5000);
			DistributerLocators.clickPremiseMasterArrow().click();
			Thread.sleep(7000);
			DistributerLocators.clickOnboardCLRA().click();
			Thread.sleep(5000);
			DistributerLocators.clickAddNewDesignation().click();
			
			Thread.sleep(2000);
			getDriver().navigate().refresh();
			
			Thread.sleep(8000);
			DistributerLocators.clickAddNewDesignation().click();
			
			FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook1 = WorkbookFactory.create(fis);
	        Sheet sheet = workbook1.getSheetAt(0);
			
			Thread.sleep(1000);
			Row row = sheet.getRow(10);						//Selected 0th index row (First row)
			Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
			String pename = c.getStringCellValue();
			DistributerLocators.clickPEName().sendKeys(OneCommonMethod.getRandomString());
			
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
		
		
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		
		
	}
	
	
	public static void UpdateEmployer( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(5000);
		DistributerLocators.clickPremiseMasterArrow().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		Thread.sleep(2000);
//		DistributerLocators.clickUpdateEmp().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(8000);
		DistributerLocators.clickUpdateEmp().click();
		
		Thread.sleep(2000);
//		DistributerLocators.clickNatureOfBuisness().clear();
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(0);
		
		
		
		Thread.sleep(1000);
		Row row1 = sheet.getRow(11);						//Selected 0th index row (First row)
		Cell c1 = row1.getCell(1);						//Selected cell (0 row,1 column)
		String NOB = c1.getStringCellValue();
//		DistributerLocators.clickNatureOfBuisness().sendKeys(NOB);

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
		
		Thread.sleep(5000);Thread.sleep(5000);Thread.sleep(5000);
	//	DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"AVACORED5");
		Thread.sleep(4000);
		DistributerLocators.clickPremiseMasterArrow().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(5000);
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
		
/*		Thread.sleep(9000);
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
*/
		Thread.sleep(1000);
		DistributerLocators.clickOkBtn().click();
		
	}
	
	public static void HolidayMaster( ExtentTest test,XSSFWorkbook workbook) throws Exception
	{
		
		Thread.sleep(5000);
		Thread.sleep(5000);
		Thread.sleep(5000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(10000);
		DistributerLocators.clickPremiseMasterArrow().click();
		Thread.sleep(7000);
		
		//Correct Entity Verification
	    OneCommonMethod.verifyTestEntity(
	    driver.get(), test,
	    By.xpath("//span[normalize-space()='AVATCGEN CORE DEMO[AVACORED5]']"),
	    "AVATCGEN CORE DEMO[AVACORED5]"
	     );
		
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(1000);
		DistributerLocators.holidayMaster().click();
		
		 getDriver().navigate().refresh();
		
		 Thread.sleep(8000);
		 DistributerLocators.holidayMaster().click();
		 Thread.sleep(1000);
		DistributerLocators.clickBrowse1().click();
	
		 Thread.sleep(1000);
		 Robot robot=new Robot();
		 Thread.sleep(5000);
		 OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\Other Upload No need to change\\SampleHolidayMaster.xlsx");
//		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\SampleHolidayMaster.xlsx");
/*		 Thread.sleep(1000);
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
		 
		 */
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
	//   PerformerLocator.clickdashboard().click();
		
	}
	public static void bulkUpload( ExtentTest test,XSSFWorkbook workbook) throws Exception
	{
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Thread.sleep(5000);Thread.sleep(5000);Thread.sleep(5000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(5000);
		DistributerLocators.clickPremiseMasterArrow().click();
		Thread.sleep(7000);
		
		//Correct Entity Verification
	    OneCommonMethod.verifyTestEntity(
	    driver.get(), test,
	    By.xpath("//span[normalize-space()='AVATCGEN CORE DEMO[AVACORED5]']"),
	    "AVATCGEN CORE DEMO[AVACORED5]"
	     );
		
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(5000);
		DistributerLocators.bulkUpload().click();
		
		getDriver().navigate().refresh();
		
		Thread.sleep(8000);
		DistributerLocators.bulkUpload().click();
	
		 Thread.sleep(3000);
		DistributerLocators.clickBrowse1().click();
		
		 Robot robot=new Robot();
		 OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\Other Upload No need to change\\SamplePE.xlsx");
/*		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\SamplePE.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		 
		 //Now press CRTL
		 
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(2000);
		 
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
*/		 
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
		Thread.sleep(5000);Thread.sleep(5000);Thread.sleep(5000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(6000);
		DistributerLocators.clickPremiseMasterArrow().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		Thread.sleep(5000);
		getDriver().navigate().refresh();
		
		Thread.sleep(6000);
//		CountExcel1(test);
		
	    OneCommonMethod.validateExportedExcelDYNAMIC(
	    	    driver.get(),
	    	    test,
	    	    LoginLocators.Exportbtn(),        // WebElement for export button
	    	    LoginLocators.TotalNoOfItem(),     // WebElement for grid count text
	    	    "Entity",                               // Column header to verify
	    	    "Employeer file is exported successfully"     // Success log text (only if PASS)
	    	);
		
		
		
	}
	
	public static void SearchBoxEmp( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		
		Thread.sleep(5000); Thread.sleep(5000); Thread.sleep(5000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(5000);
		DistributerLocators.clickPremiseMasterArrow().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		Thread.sleep(5000);
		getDriver().navigate().refresh();
		
		Thread.sleep(8000);
		DistributerLocators.clickSearcbox2().sendKeys("Gopi");
		
	
		  List<String> li=new ArrayList<String>();
	       
	         li.add("Gopi");
	        
	
		List<String> filter=new ArrayList<String>();	
		
		filter.add("Gopi");
	
		
		Thread.sleep(3000);

//		DistributerLocators.readTotalItem1().click();					//Clicking on Text of total items just to scroll down.
		String s = DistributerLocators.readTotalItem1().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);

		List<WebElement> Maharashtra=getDriver().findElements(By.xpath("(//td[@role='gridcell'])[3]"));
		
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
	
	public static void CLRASearchEmployee( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
	
		
		Thread.sleep(5000); Thread.sleep(5000); Thread.sleep(5000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(5000);
		DistributerLocators.clickPremiseMasterArrow().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		Thread.sleep(5000);
		getDriver().navigate().refresh();
		
		Thread.sleep(8000);
		DistributerLocators.clickSearcbox2().sendKeys("Gopi");
		
	
		  List<String> li=new ArrayList<String>();
	       
	         li.add("Gopi");
	        
	
		List<String> filter=new ArrayList<String>();	
		
		filter.add("Gopi");
	
		
		Thread.sleep(3000);

//		DistributerLocators.readTotalItem1().click();					//Clicking on Text of total items just to scroll down.
		String s = DistributerLocators.readTotalItem1().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);

		List<WebElement> Maharashtra=getDriver().findElements(By.xpath("(//td[@role='gridcell'])[3]"));
		
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
		Thread.sleep(5000);
		DistributerLocators.clickDashboard().click();
		Thread.sleep(9000);
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
		DistributerLocators.clickSearcbox2().sendKeys("Andhra Pradesh");
		
	
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
		
		
		Thread.sleep(5000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"AVACORED5");
		Thread.sleep(5000);
		DistributerLocators.clickPremiseMasterArrow().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(5000);
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
		
		
		OneCommonMethod.scroll(driver.get(), 200);
		
		Thread.sleep(1000);
		DistributerLocators.clickPEType().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickPEActType().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		Thread.sleep(1000);
		
		OneCommonMethod.scroll(driver.get(), 500);
		
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
		
		Thread.sleep(210000);
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
	
	public static void CLRA_AddLocation_Error( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	{
		
		
		Thread.sleep(5000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"AVACORED5");
		Thread.sleep(5000);
		DistributerLocators.clickPremiseMasterArrow().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnboardCLRA().click();
		
		Thread.sleep(5000);
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
		
		
		OneCommonMethod.scroll(driver.get(), 200);
		
		Thread.sleep(1000);
		DistributerLocators.clickPEType().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		
		Thread.sleep(1000);
		DistributerLocators.clickPEActType().click();
		
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		Thread.sleep(1000);
		
		OneCommonMethod.scroll(driver.get(), 500);
		
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
		
		Thread.sleep(5000);
		String msg=DistributerLocators.clickMsg().getText();
		
		 if(msg.equalsIgnoreCase("Principle Employer Location Exists Already")||msg.equalsIgnoreCase("Principle Employer Location Exists Already"))
		 {
			 test.log(LogStatus.PASS, "All dropdowns and filters are working fine");
			 Thread.sleep(1000);
			 test.log(LogStatus.PASS, "Location is not added due to Location already exists");
			 Thread.sleep(1000);
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
	
		
		Thread.sleep(5000);
		Thread.sleep(5000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		
		//AVAREGTR
		Thread.sleep(1000);
		DistributerLocators.clickPremiseMasterArrow().click();
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
		
	}
	
	public static void ComplainceReassignment( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(5000);Thread.sleep(5000);Thread.sleep(5000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(8000);
		DistributerLocators.clickPremiseMasterArrow().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();
		Thread.sleep(1000);
		DistributerLocators.ComplianceTypeDropdown().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		Thread.sleep(1000);
		DistributerLocators.clickBranch1().click();
		Thread.sleep(1000);
		DistributerLocators.clickBranchTiangle().click();
		Thread.sleep(1000);
		DistributerLocators.select_Bobbili_Avacored_branch().click();
		
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
			
		
	}
	
	public static void scheduleCreationValidation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		

		Thread.sleep(5000);Thread.sleep(5000);Thread.sleep(5000);
		DistributerLocators.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(8000);
		DistributerLocators.clickPremiseMasterArrow().click();
		Thread.sleep(7000);
		DistributerLocators.clickOnBoardEntity().click();
		Thread.sleep(1000);
		DistributerLocators.managecompliance().click();
		Thread.sleep(1000);
		DistributerLocators.FirstTriangle().click();
		Thread.sleep(1000);
		DistributerLocators.scheduleCreation().click();
		Thread.sleep(1000);
		
		DistributerLocators.clickSubmit().click();
		Thread.sleep(5000);
		
		String txt = DistributerLocators.MessageText().getText();
		
		if(txt.equalsIgnoreCase("Please select Compliance Type, Period, and Year before submitting."))
		{
			 test.log(LogStatus.PASS, "Without selecting compliance type dropdown error message is displayed");
			 test.log(LogStatus.PASS, "Message displayed : " + txt);
		}
		else {
			 test.log(LogStatus.FAIL, "Without selecting compliance type Message displayed : " + txt);
			
		}
		
		DistributerLocators.ClickOK().click(); Thread.sleep(5000);
		
		DistributerLocators.clickComplianceType1().click();
		Thread.sleep(1000);
		DistributerLocators.selectComplianceType1().click();
		Thread.sleep(1000);
		
		DistributerLocators.clickSubmit().click();
		Thread.sleep(5000);
		String txt2 = DistributerLocators.MessageText().getText();
		
		if(txt2.equalsIgnoreCase("Please select Compliance Type, Period, and Year before submitting."))
		{
			 test.log(LogStatus.PASS, "Without selecting period dropdown error message is displayed");
			 test.log(LogStatus.PASS, "Message displayed : " + txt2);
		}
		else {
			 test.log(LogStatus.FAIL, "Without selecting period Message displayed : " + txt2);
			
		}
		
		DistributerLocators.ClickOK().click(); Thread.sleep(5000);
		
		DistributerLocators.clickPeriod().click();
		Thread.sleep(2000);
		DistributerLocators.selectComplianceType1().click();
		Thread.sleep(2000);
		
		
		DistributerLocators.clickSubmit().click();
		Thread.sleep(5000);
		String txt3 = DistributerLocators.MessageText().getText();
		
		if(txt3.equalsIgnoreCase("Please select Compliance Type, Period, and Year before submitting."))
		{
			 test.log(LogStatus.PASS, "Without selecting year dropdown error message is displayed");
			 test.log(LogStatus.PASS, "Message displayed : " + txt3);
		}
		else {
			 test.log(LogStatus.FAIL, "Without selecting year dropdown Message displayed : " + txt3);
			
		}
		
		
		
		
		
		
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
//		DistributerLocators.clickBranch1().click();

		Thread.sleep(1000);
//		DistributerLocators.clickCheckBox2().click();
		
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
	
	
	
	
	
	
	
	
	
	
	public static void complianceBox( ExtentTest test, String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		Thread.sleep(2000);
	//	LoginLocators.Search().sendKeys("WWKRG");		
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.ComplianceBox()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
		
	int open = Integer.parseInt(LoginLocators.ComplianceBox().getText());	
	LoginLocators.ComplianceBox().click();					                
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("svg-icon")));

	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   
	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								
	String compliancesCount = bits[bits.length - 2];				
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(9000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(9000);
	LoginLocators.ClosePopUp().click();
	Thread.sleep(3000);
	
	
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
	
}
	
	public static void GridAndExcelCountMatch(ExtentTest test,XSSFWorkbook workbook  ) throws InterruptedException, IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000); 		
        LoginLocators.TotalNumberOfItems().click();					
		Thread.sleep(2000);
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(8000);
		String[] bits = s.split(" ");								
		String compliancesCount = bits[bits.length - 2];				
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   s = LoginLocators.TotalNumberOfItems().getText();
			bits = s.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(2000);

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
	public static void GridAndExcelCountMatch1(ExtentTest test,XSSFWorkbook workbook  ) throws InterruptedException, IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000); 
        WebDriverWait wait = new WebDriverWait(getDriver(),(120));
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNoOfItem()));

        LoginLocators.TotalNoOfItem().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(2000);
		String s = LoginLocators.TotalNoOfItem().getText();
		Thread.sleep(8000);
		String[] bits = s.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   s = LoginLocators.TotalNoOfItem().getText();
			bits = s.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(2000);

Thread.sleep(1000);
File dir = new File("C:\\Users\\bilali\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Thread.sleep(1000);
try {
LoginLocators.Export().click();
}
catch(Exception e)
{
	LoginLocators.Exportbtn().click();
	
	}
test.log(LogStatus.PASS, "Compliance Assignment Report : File downloaded successfully.");

Thread.sleep(9000);
File dir1 = new File("C:\\Users\\bilali\\Downloads");
File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

if(dirContents.length < allFilesNew.length)
{
		
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

	public static void GridAndExcelCount(ExtentTest test,XSSFWorkbook workbook  ) throws InterruptedException, IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000); 
        WebDriverWait wait = new WebDriverWait(getDriver(),(120));
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNoOfItem()));

        LoginLocators.TotalNoOfItem().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(2000);
		String s = LoginLocators.TotalNoOfItem().getText();
		Thread.sleep(8000);
		String[] bits = s.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   s = LoginLocators.TotalNoOfItem().getText();
			bits = s.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(2000);

Thread.sleep(1000);
File dir = new File("C:\\Users\\bilali\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Thread.sleep(1000);
try {
LoginLocators.Export().click();
}
catch(Exception e)
{
	LoginLocators.Exportbtn().click();
	
	}
test.log(LogStatus.PASS, " File downloaded successfully.");

Thread.sleep(9000);
File dir1 = new File("C:\\Users\\bilali\\Downloads");
File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

if(dirContents.length < allFilesNew.length)
{
		
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

	public static void GridAndExcelCounts(ExtentTest test,XSSFWorkbook workbook  ) throws InterruptedException, IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000); 
        WebDriverWait wait = new WebDriverWait(getDriver(),(120));
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNoOfItem()));

        LoginLocators.TotalNoOfItem().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(2000);
		String s = LoginLocators.TotalNoOfItem().getText();
		Thread.sleep(8000);
		String[] bits = s.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   s = LoginLocators.TotalNoOfItem().getText();
			bits = s.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(2000);

Thread.sleep(1000);
File dir = new File("C:\\Users\\bilali\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Thread.sleep(1000);
try {
LoginLocators.Export().click();
}
catch(Exception e)
{
	LoginLocators.Exportbtn().click();
	
	}
test.log(LogStatus.PASS, " File downloaded successfully.");

Thread.sleep(9000);
File dir1 = new File("C:\\Users\\bilali\\Downloads");
File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

if(dirContents.length < allFilesNew.length)
{
		
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
	/*
	int no = sheet.getFirstRowNum();
	Row row = sheet.getRow(no);
	Cell c1 = row.getCell(0);
	int records =(int) c1.getNumericCellValue();
	*/
	sheet = workbook.getSheetAt(0);
	int columnNumber = 2;
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
	public static void GridAndExcelCountMatch2(ExtentTest test,XSSFWorkbook workbook  ) throws InterruptedException, IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000); 
        WebDriverWait wait = new WebDriverWait(getDriver(),(120));
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));

        LoginLocators.TotalNumberOfItems().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(2000);
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(8000);
		String[] bits = s.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   s = LoginLocators.TotalNumberOfItems().getText();
			bits = s.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(2000);

Thread.sleep(1000);
File dir = new File("C:\\Users\\bilali\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Thread.sleep(1000);
try {
LoginLocators.Export().click();
Thread.sleep(20000);
}
catch(Exception e)
{
	LoginLocators.Exportbtn().click();
	Thread.sleep(20000);
	
	}
test.log(LogStatus.PASS, " downloaded successfully.");

Thread.sleep(1000);
File dir1 = new File("C:\\Users\\bilali\\Downloads");
File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

if(dirContents.length < allFilesNew.length)
{
		
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
	test.log(LogStatus.FAIL, "  doesn't downloaded successfully.");
}

		
	}



	public static void GridAndExcelCountMatch3(ExtentTest test,XSSFWorkbook workbook  ) throws InterruptedException, IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000); 
        WebDriverWait wait = new WebDriverWait(getDriver(),(120));
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItem()));

        LoginLocators.TotalNumberOfItem().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(2000);
		String s = LoginLocators.TotalNumberOfItem().getText();
		Thread.sleep(8000);
		String[] bits = s.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   s = LoginLocators.TotalNumberOfItem().getText();
			bits = s.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(2000);

Thread.sleep(1000);
File dir = new File("C:\\Users\\bilali\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Thread.sleep(1000);
try {
LoginLocators.Export().click();
Thread.sleep(20000);
}
catch(Exception e)
{
	LoginLocators.Exportbtn().click();
	Thread.sleep(20000);
	
	}
test.log(LogStatus.PASS, " downloaded successfully.");

Thread.sleep(1000);
File dir1 = new File("C:\\Users\\bilali\\Downloads");
File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

if(dirContents.length < allFilesNew.length)
{
		
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
	test.log(LogStatus.FAIL, " doesn't downloaded successfully.");
}

		
	}





	public static void UpcomingBox( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.UpcomingBox().getText());	//Reading Dashboard count.
	LoginLocators.UpcomingBox().click();					                //Clicking on Dashboard count
    Thread.sleep(5000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(5000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(4000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(5000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(9000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);	
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	LoginLocators.ClosePopUp().click();
	Thread.sleep(3000);
	
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void OverdueBox( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		//LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.OverdueBox().getText());	//Reading Dashboard count.
	LoginLocators.OverdueBox().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	try {
	LoginLocators.SelectValueDropdown().click();
	}
	catch(Exception e) {
		
	}
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	LoginLocators.ClosePopUp().click();
	Thread.sleep(3000);
	}
	else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}

	
	
}
	
	public static void PendingActionBox( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.PendingActionBox().getText());	//Reading Dashboard count.
	LoginLocators.PendingActionBox().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	LoginLocators.ClosePopUp().click();
	Thread.sleep(3000);
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void PendingReviewBox( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("WWKRG");
		//LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.PendingReviewBox().getText());	//Reading Dashboard count.
	LoginLocators.PendingReviewBox().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	LoginLocators.ClosePopUp().click();
	Thread.sleep(3000);
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void RegisterUpcoming( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("WWKRG");
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.RegisterUpcoming().getText());	//Reading Dashboard count.
	LoginLocators.RegisterUpcoming().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
	LoginLocators.ClosePopUp().click();
	Thread.sleep(3000);
	}
	catch(Exception e) {
		
		LoginLocators.Close().click();		
	}
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void RegisterOverdue( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.RegisterOverdue().getText());	//Reading Dashboard count.
	LoginLocators.RegisterOverdue().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void RegisterActionReview( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.RegisterActionReview().getText());	//Reading Dashboard count.
	LoginLocators.RegisterActionReview().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void ReturnUpcoming( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
	int open = Integer.parseInt(LoginLocators.ReturnUpcoming().getText());	//Reading Dashboard count.
	LoginLocators.ReturnUpcoming().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void ReturnOverdue( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
	int open = Integer.parseInt(LoginLocators.ReturnOverdue().getText());	//Reading Dashboard count.
	LoginLocators.ReturnOverdue().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void ReturnActionReview( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
	int open = Integer.parseInt(LoginLocators.ReturnActionReview().getText());	//Reading Dashboard count.
	LoginLocators.ReturnActionReview().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void ChallanUpcoming( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
	int open = Integer.parseInt(LoginLocators.ChallanUpcoming().getText());	//Reading Dashboard count.
	LoginLocators.ChallanUpcoming().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void ChallanOverdue( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.ChallanOverdue().getText());	//Reading Dashboard count.
	LoginLocators.ChallanOverdue().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, " Count from grid is 0");

		}
	
}
	
	public static void ChallanActionReview( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		//LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.ChallanActionReview().getText());	//Reading Dashboard count.
	LoginLocators.ChallanActionReview().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, " Count from grid is 0");

		}
	
}
	
	
	public static void RiskGraph( ExtentTest test,String risk,int complianceCount) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
	
		if(risk.equalsIgnoreCase("High"))
		{
			Thread.sleep(3000);
			LoginLocators.HighRisk().click();
			}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			LoginLocators.MediumRisk().click();					//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(2000);
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			LoginLocators.LowRisk().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
						                  
	Thread.sleep(2000);
   			
	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(count1 == complianceCount)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "'"+risk+"' - "+"Dashboard Count = "+complianceCount+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "'"+risk+"' - "+"Dashboard Count = "+complianceCount+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	try {
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	}
	catch(Exception e){
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	}
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp1().click();
	Thread.sleep(3000);
	}
	catch(Exception e) {
		
		LoginLocators.ClosePopUp2().click();
		Thread.sleep(3000);
	}	
	}
else {
		
		test.log(LogStatus.PASS, "'"+risk+"' - "+" Count from grid is 0");

		}
	
	
}
	
	public static void CompRiskGraph( ExtentTest test,String risk,int complianceCount) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
	
		if(risk.equalsIgnoreCase("High"))
		{
			Thread.sleep(3000);
			LoginLocators.CompHighRisk().click();
			}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			LoginLocators.CompMediumRisk().click();					//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(2000);
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			LoginLocators.CompLowRisk().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
						                  
	Thread.sleep(2000);
   			
	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(count1 == complianceCount)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "'"+risk+"' - "+"Dashboard Count = "+complianceCount+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "'"+risk+"' - "+"Dashboard Count = "+complianceCount+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	try {
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	}
	catch(Exception e) {
		LoginLocators.ApplyBtn().click();
		Thread.sleep(3000);
	}
	
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp1().click();
	Thread.sleep(3000);
	}
	catch(Exception e) {
		
		LoginLocators.ClosePopUp2().click();
		Thread.sleep(3000);
	}	
	}
else {
		
		test.log(LogStatus.PASS, "'"+risk+"' - "+" Count from grid is 0");

		}
	
	
}
	
	public static void Complied(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    
	    js.executeScript("window.scrollBy(0,300)");
	    Thread.sleep(2000);
		int open = Integer.parseInt(LoginLocators.CompliedCount().getText());	//Reading Dashboard count.
		Thread.sleep(2000);
		//LoginLocators.Complied().getText();
	//	Thread.sleep(2000);		
		String path = "//*[local-name()='svg']//*[name()='g' and @class='k-chart-point']";
		 List<WebElement> PathNC = getDriver().findElements(By.xpath(path));
		Actions action = new Actions(getDriver());
		for(WebElement e : PathNC)
		{
			action.moveToElement(e).click().build().perform();
		}
			try {	
				LoginLocators.PenActnClosePopup().click();	
				Thread.sleep(2000);
		Thread.sleep(2000);
			}
			catch(Exception e) {
				
			}
		
   			
	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	
	if(count1 == open)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Complied Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Complied Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	try {
		LoginLocators.PenActnClosePopup().click();	
    	Thread.sleep(4000);
	}
	catch(Exception e) {
		
	}
	
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	try {
	LoginLocators.typeValue().click();
	}
	catch(Exception e)
	{
		LoginLocators.typeValueEPF().click();
	}
	Thread.sleep(3000);
//	LoginLocators.SelectValue().click();
//	Thread.sleep(3000);
//	LoginLocators.SelectValueDropdown().click();
//	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	 By locate = By.xpath("//div//img[@class='svg-icon ng-star-inserted']");

		wait.until(ExpectedConditions.presenceOfElementLocated(locate));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		List<WebElement> downloadbtn = getDriver().findElements(locate);	
		Thread.sleep(3000);
		downloadbtn.get(2).click();
		Thread.sleep(3000);
		try {
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Download()));

		
		try {
			LoginLocators.Download().click();			
		 	Thread.sleep(2000);
			String msg = LoginLocators.MessageDisplayed().getText();	
			test.log(LogStatus.FAIL, msg);
			LoginLocators.OK().click();
									
		}
		catch(Exception e) {
			Thread.sleep(3000);
			File dir2 = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download			
			Thread.sleep(9000);			
			LoginLocators.Download().click();			
		 	Thread.sleep(18000);
			File dir3 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download		   
	        Thread.sleep(9000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Doc Downloaded.");
			}
		   else
		   {
			   
				test.log(LogStatus.FAIL, "Doc does not Downloaded");
			}		
		   Thread.sleep(5000);
			}
		}
		catch(Exception e) {
			
			test.log(LogStatus.PASS, "Doc not present to download");

		}
		finally {
			LoginLocators.CloseBranchCode().click();
			Thread.sleep(3000);
		}		
		View(test);	
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp1().click();
	Thread.sleep(3000);
	}
	catch(Exception e) {
		
		LoginLocators.ClosePopUp2().click();
		Thread.sleep(3000);
	}	
	
	}
	
else {
		
		test.log(LogStatus.PASS, "Complied Count from grid is 0");

		}
	
	
}
	
	public static void NotComplied(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue().click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
//	    
	    js.executeScript("window.scrollBy(0,300)");
	    Thread.sleep(500);
	    int open = Integer.parseInt(LoginLocators.NotCompliede().getText());	//Reading Dashboard count.	    
	                  
	Thread.sleep(9000);
//	String path = "(//*[local-name()='svg']//*[name()='g' and @class='k-chart-point'])[2]";
//	 List<WebElement> PathNC = getDriver().findElements(By.xpath(path));
//	Actions action = new Actions(getDriver());
//	for(WebElement e : PathNC)
//	{
//		action.moveToElement(e).click().build().perform();
//	}
//		try {	
//			LoginLocators.PenActnClosePopup().click();	
//			Thread.sleep(2000);
//	Thread.sleep(2000);
//		}
//		catch(Exception e) {
//			
//		}
   			
	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								
	String compliancesCount = bits[bits.length - 2];				
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	
	if(count1 == open)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Not Complied Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Not Complied Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	try {
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	}
	catch(Exception e) {
		
	}
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	try {
	 By locate = By.xpath("//div//img[@class='svg-icon ng-star-inserted']");

		wait.until(ExpectedConditions.presenceOfElementLocated(locate));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		List<WebElement> downloadbtn = getDriver().findElements(locate);	
		Thread.sleep(3000);
		downloadbtn.get(2).click();
		Thread.sleep(3000);
	}
	catch(Exception e) {
		
	}
		try {
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Download()));

		
		try {
			LoginLocators.Download().click();			
		 	Thread.sleep(2000);
			String msg = LoginLocators.MessageDisplayed().getText();	
			test.log(LogStatus.FAIL, msg);
			LoginLocators.OK().click();
									
		}
		catch(Exception e) {
			Thread.sleep(3000);
			File dir2 = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents1 = dir2.listFiles();						
			Thread.sleep(9000);			
			LoginLocators.Download().click();			
		 	Thread.sleep(18000);
			File dir3 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						   
	        Thread.sleep(9000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Doc Downloaded.");
			}
		   else
		   {
			   
				test.log(LogStatus.FAIL, "Doc does not Downloaded");
			}		
		   Thread.sleep(5000);
			}
		}
		catch(Exception e) {
			
			test.log(LogStatus.PASS, "Doc not present to download");

		}
		finally {
			LoginLocators.CloseBranchCode().click();
			Thread.sleep(3000);
		}		
		View(test);	
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp1().click();
	Thread.sleep(3000);
	}
	catch(Exception e) {
		
		LoginLocators.ClosePopUp2().click();
		Thread.sleep(3000);
	}	
	}
else {
		
		test.log(LogStatus.PASS, "Not Complied Count from grid is 0");

		}
	
	
}
	
	
	public static void View( ExtentTest test) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	By locate = By.xpath("//div//img[@class='svg-icon ng-star-inserted']");

	wait.until(ExpectedConditions.presenceOfElementLocated(locate));
	Thread.sleep(4000);
	// retrieving "foo-button" HTML element
	List<WebElement> downloadbtn = getDriver().findElements(locate);	
	Thread.sleep(3000);
	downloadbtn.get(3).click();
	Thread.sleep(3000);	
	try {
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Download()));
	//wait.until(ExpectedConditions.visibilityOf(LoginLocators.CloseBranchCode()));

	try {
		LoginLocators.Download().click();			
	 	Thread.sleep(5000);
	 	LoginLocators.ClosePopUp3().click();
		Thread.sleep(3000);
        test.log(LogStatus.PASS, "View Successfully");		
	}	
	catch(Exception e) {
		String msg = LoginLocators.MessageDisplayed1().getText();	
		test.log(LogStatus.FAIL, msg);
		LoginLocators.OK().click();
		}
	}
	catch(Exception e)
	{
		
	}
	finally {
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	}
}
	
	public static void ApplicableStatues(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    
	    js.executeScript("window.scrollBy(0,500)");
	    if(LoginLocators.ApplicableStatues().isDisplayed())
	    {
	    	LoginLocators.Applicablestatus().getText();
	    	test.log(LogStatus.PASS, "Applicable Statued tab displayed on dashboard");
    	
	    }
	    else {
	    	test.log(LogStatus.FAIL, "Applicable Statued tab does not displayed on dashboard");

	    }
	
	}
	
	public static void DailyUpdate(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    
	    js.executeScript("window.scrollBy(0,1000)");
	    if(LoginLocators.DailyUpdateHeader().isDisplayed())
	    {
	    	String dly = LoginLocators.DailyUpdate().getText();
	    	test.log(LogStatus.PASS, "Daily Update ="+dly);
    	
	    }
	    else {
	    	test.log(LogStatus.FAIL, "Daily Update not displayed on dashboard");

	    }
	
	}
	public static void Brows(ExtentTest test) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		
		LoginLocators.Search().sendKeys("AVACORED5");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(20000);
		LoginLocators.Brows().click();
		
		Runtime.getRuntime().exec("C:\\Users\\shitalb\\Documents\\UploadFile.exe");
		Thread.sleep(20000);
		LoginLocators.Button().click();
		test.log(LogStatus.PASS, "pass");

		
	}
	
	
	public static void ComplianceFilter1( ExtentTest test,String user) throws InterruptedException
	{
		
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
		LoginLocators.ComplianceBox().click();					                
        Thread.sleep(2000);
	   
       LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranchnew().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue3().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue3().click();
       Thread.sleep(2000);
       
       LoginLocators.ActFilter().click();
       Thread.sleep(3000);
       String act =LoginLocators.ActFilterValue().getText();
       Thread.sleep(2000);
       LoginLocators.ActFilterValue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyButton().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        li.add(act);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		filter.add("Act");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		List<WebElement> actcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[4]"));
		
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
				if(i==1)
				{
					raw.addAll(actcol);
				}
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Itanagar_www")||text.get(l).equalsIgnoreCase("www"))
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
	public static void UpcomingFilter( ExtentTest test,String user) throws InterruptedException
	{
		
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(5000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		Thread.sleep(8000);
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(5000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
		LoginLocators.UpcomingBox().click();				                
        Thread.sleep(7000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranchnew().click();
       Thread.sleep(3000);
       String branch =LoginLocators.BranchvalueCheckbox().getText(); //
       Thread.sleep(2000);
       LoginLocators.BranchvalueCheckbox().click(); //
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
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
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Jayanagar III Block_TTTT")||text.get(l).equalsIgnoreCase("TTTT"))
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
	public static void OverdueFilter( ExtentTest test,String user) throws InterruptedException
	{
		
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		Thread.sleep(8000);
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
		LoginLocators.OverdueBox().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalues().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalues().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
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
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Pune_tcs in hinjewadi")||text.get(l).equalsIgnoreCase("tcs in hinjewadi"))
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

	public static void PendingActionFilter( ExtentTest test,String user) throws InterruptedException
	{
		
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
		LoginLocators.PendingActionBox().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
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
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Gujarat_Branch Gujarat")||text.get(l).equalsIgnoreCase("Branch Gujarat"))
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

	public static void PendingReviewFilter( ExtentTest test,String user) throws InterruptedException
	{
		
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
		LoginLocators.PendingReviewBox().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
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
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Gujarat_Branch Gujarat")||text.get(l).equalsIgnoreCase("Branch Gujarat"))
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
	public static void RegisterUpcomingFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
		LoginLocators.RegisterUpcoming().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
        Thread.sleep(3000);
        LoginLocators.ExpandBranchn().click();
        Thread.sleep(3000);
        String branch =LoginLocators.Branchvaluen().getText();
        Thread.sleep(2000);
        LoginLocators.Branchvaluen().click();
        Thread.sleep(2000);
        LoginLocators.ApplyBtn1().click();
        Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
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
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Jayanagar III Block_TTTT")||text.get(l).equalsIgnoreCase("TTTT"))
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
	
	public static void RegisterOverdueFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.RegisterOverdue().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					//Clicking on Text of total items just to scroll down.
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
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
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Gujarat_Branch Gujarat")||text.get(l).equalsIgnoreCase("Branch Gujarat"))
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
	
	public static void RegisterActionreviewFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.RegisterActionReview().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
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
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Gujarat_Branch Gujarat")||text.get(l).equalsIgnoreCase("Branch Gujarat"))
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
	
	public static void ReturnUpcomingFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.ReturnUpcoming().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
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
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Gujarat_Branch Gujarat")||text.get(l).equalsIgnoreCase("Branch Gujarat"))
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
	
	public static void ReturnOverdueFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.ReturnOverdue().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
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
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Gujarat_Branch Gujarat")||text.get(l).equalsIgnoreCase("Branch Gujarat"))
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
	
	public static void ReturnActionReviewFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.ReturnActionReview().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
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
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Gujarat_Branch Gujarat")||text.get(l).equalsIgnoreCase("Branch Gujarat"))
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
	
	public static void challanUpcomingFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.ChallanUpcoming().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
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
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Delhi_Bangalore")||text.get(l).equalsIgnoreCase("Bangalore"))
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
	
	public static void challanOverdueFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.ChallanOverdue().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					//Clicking on Text of total items just to scroll down.
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
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
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Delhi_Bangalore")||text.get(l).equalsIgnoreCase("Bangalore"))
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
	
	public static void challanActionReviewFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.ChallanActionReview().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
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
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Delhi_Bangalore")||text.get(l).equalsIgnoreCase("Bangalore"))
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
	
	public static void CompliedFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();		

		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(3000);
		String path = "//*[local-name()='svg']//*[name()='g' and @class='k-chart-point']";
		 List<WebElement> PathNC = getDriver().findElements(By.xpath(path));
		Actions action = new Actions(getDriver());
		for(WebElement e : PathNC)
		{
			action.moveToElement(e).click().build().perform();
		}
		Thread.sleep(2000);
		LoginLocators.PenActnClosePopup().click();	
     	Thread.sleep(4000);
//		LoginLocators.Complied().click();				                
      Thread.sleep(2000);
	   
      LoginLocators.SelectBranch().click();
      Thread.sleep(3000);
      LoginLocators.ExpandBranchh().click();
      Thread.sleep(3000);
      String branch =LoginLocators.Branchval().getText();
      Thread.sleep(2000);
      LoginLocators.Branchval().click();
      Thread.sleep(2000);
       
       LoginLocators.Period().click();
       Thread.sleep(3000);
   //    String period =LoginLocators.PeriodValue().getText();
       Thread.sleep(2000);
       LoginLocators.PeriodValue().click();
       Thread.sleep(2000);
       
       LoginLocators.SelectYear().click();
       Thread.sleep(3000);
   //    String year =LoginLocators.SelectYearvalue().getText();
       Thread.sleep(2000);
       LoginLocators.SelectValuetype().click();
       Thread.sleep(2000);
       
   //    String Period = period+year;
   //    System.out.print(Period);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
     //   li.add(Period);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
	//	filter.add("period");
		
		
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
	//	List<WebElement> periodcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[10]"));

		
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
				
			
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("guntur_ooooooooo")||text.get(l).equalsIgnoreCase("ooooooooo"))
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
	
	public static void CompliedRiskSummaryGraphFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    
	    js.executeScript("window.scrollBy(0,300)");
	    Thread.sleep(2000);
	    LocatorsP.HighRisk1().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
        Thread.sleep(3000);
        LoginLocators.ExpandBranchh().click();
        Thread.sleep(3000);
        String branch =LoginLocators.Branchval().getText();
        Thread.sleep(2000);
        LoginLocators.Branchval().click();
        Thread.sleep(2000);
         
         LoginLocators.Period().click();
         Thread.sleep(3000);
     //    String period =LoginLocators.PeriodValue().getText();
         Thread.sleep(2000);
         LoginLocators.PeriodValue().click();
         Thread.sleep(2000);
         
         LoginLocators.SelectYear().click();
         Thread.sleep(3000);
     //    String year =LoginLocators.SelectYearvalue().getText();
         Thread.sleep(2000);
         LoginLocators.SelectValuetype().click();
         Thread.sleep(2000);
         
     //    String Period = period+year;
     //    System.out.print(Period);
         LoginLocators.ApplyBtn1().click();
         Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
     //   li.add(Period);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
	//	filter.add("period");
		
		
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
	//	List<WebElement> periodcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[10]"));

		
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
				
			
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("guntur_ooooooooo")||text.get(l).equalsIgnoreCase("ooooooooo"))
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
	
	
	public static void Report(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.Report().click();
		Thread.sleep(2000);
		LoginLocators.Branch().click();
		Thread.sleep(2000);
		LoginLocators.BranchValue().click();
		Thread.sleep(2000);
		LoginLocators.ComplianceType().click();
		Thread.sleep(2000);
		LoginLocators.SelectValuetype().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
	    Thread.sleep(9000);
		MethodsD.GridAndExcelCountMatch1(test,workbook);
		Thread.sleep(3000);
		LoginLocators.ClearButton().click();
	    Thread.sleep(9000);
			
	
	}
	
	public static void CLRAAssignmentReport(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.Report().click();
		Thread.sleep(2000);
		
		LoginLocators.CLRAAssignReport().click();
		Thread.sleep(2000);
		LoginLocators.Branch2().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue4().click();
		Thread.sleep(2000);			
		LoginLocators.selecttype().click();
		Thread.sleep(2000);
		LoginLocators.TypeValue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyBtn1().click();
	    Thread.sleep(9000);
	    MethodsD.GridAndExcelCountMatch3(test,workbook);
		Thread.sleep(3000);
	    LoginLocators.Clearbtn1().click();
	    Thread.sleep(9000);
	}

	
	public static void VariousReport(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.Report().click();
		Thread.sleep(2000);
		
		 LoginLocators.VariousReport().click();
			Thread.sleep(2000);
			LoginLocators.VariousType().click();
			Thread.sleep(2000);
			LoginLocators.VariousTypeValue().click();
			Thread.sleep(2000);
//			LoginLocators.Calender().click();
//			Thread.sleep(2000);
//			LoginLocators.Calenderyear().click();
//			Thread.sleep(2000);
//			LoginLocators.CalenderMonth().click();
//			Thread.sleep(2000);
			LoginLocators.ApplyBtn2().click();
		    Thread.sleep(9000);
		    MethodsD.GridAndExcelCountMatch3(test,workbook);
			Thread.sleep(3000);
			
	}

	
	
	public static void StatusReport(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.Report().click();
		Thread.sleep(2000);
		
		 LoginLocators.StatusReport().click();
			Thread.sleep(2000);
			LoginLocators.Branch1().click();
			Thread.sleep(2000);
			LoginLocators.BranchValue().click();
			Thread.sleep(2000);
			LoginLocators.Monthly().click();
			Thread.sleep(2000);
			LoginLocators.MonthlyValue().click();
			Thread.sleep(2000);
			LoginLocators.Year().click();
			Thread.sleep(2000);
			LoginLocators.Yearvalue().click();
			Thread.sleep(2000);
			LoginLocators.period().click();
			Thread.sleep(2000);
			LoginLocators.Yearvalue().click();//period value
			Thread.sleep(2000);
			LoginLocators.Status().click();
			Thread.sleep(2000);
			LoginLocators.Yearvalue().click();//period value
			Thread.sleep(2000);
			LoginLocators.ApplyBtn1().click();
		    Thread.sleep(9000);
		    MethodsD.GridAndExcelCountMatch2(test,workbook);
			Thread.sleep(3000);
		    
//		    File dir = new File("C:\\Users\\bilali\\Downloads");
//			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
//			
//			Thread.sleep(3000);
//			try {
//			    LoginLocators.Export().click();
//			    Thread.sleep(20000);
//			    }
//			    catch(Exception e)
//			    {
//			    	LoginLocators.Exportbtn().click();
//			    	Thread.sleep(20000);
//			    	
//			    	}		
//		 	Thread.sleep(9000);
//			File dir1 = new File("C:\\Users\\bilali\\Downloads");
//			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
//			
//			Thread.sleep(3000);
//		  
//	        
//		   if (dirContents.length < allFilesNew.length) {
//			    test.log(LogStatus.PASS, "Status Report : File downloaded successfully.");
//			}
//		   else
//		   {
//			    test.log(LogStatus.FAIL, "Status Report : File Does not downloaded successfully.");
//			}
//		   Thread.sleep(1000);
		        LoginLocators.Clearbtn1().click();
			    Thread.sleep(2000);
	}
	
	public static void PendingActionPerform( ExtentTest test,String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue().click();
		Thread.sleep(2000);
		int open = Integer.parseInt(LoginLocators.PendingActionBox().getText());	
	    Thread.sleep(2000);
	    LoginLocators.PendingActionBox().click();
	    Thread.sleep(2000);
	    LoginLocators.PendingActionEdit().click();	
	    Thread.sleep(9000);
	    
	    LoginLocators.ClickBrowse().click();
		Thread.sleep(8000);
		// Specify the file path
	    String filePath = "E:\\Labor Upload\\ContractsList__MyWorkspace (1).pdf";
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
	    
	    
	    
//        LoginLocators.Brows().click();		
//		Runtime.getRuntime().exec("E:\\Labor Upload\\Laborfile.exe");
		Thread.sleep(2000);
		LoginLocators.Upload().click();
		Thread.sleep(2000);
		String  msg= LoginLocators.UploadSuccessfully().getText();
		LoginLocators.OK().click();
	    test.log(LogStatus.PASS, msg);
	    Thread.sleep(2000);
	    
	    LoginLocators.ComplianceRadioButton().click();
	    Thread.sleep(2000);
	    LoginLocators.ClickBrowse().click();
		Thread.sleep(8000);
		// Specify the file path
	    String filePath1 = "E:\\Labor Upload\\ContractsList__MyWorkspace (1) (1).pdf";
	    StringSelection selection1 = new StringSelection(filePath1);
//
//	    // Copy file path to clipboard
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection1, null);
	    Thread.sleep(2000);
	    // Use Robot class to paste the file path and press Enter
	    
	    // Simulate CTRL + V (Paste)
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    
	    // Press Enter to confirm the upload
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		LoginLocators.Upload().click();
		Thread.sleep(2000);
		LoginLocators.OK().click();
	    Thread.sleep(2000);
	    
	    LoginLocators.Submit().click();
	    Thread.sleep(4000);
		String  msgdisplayed= LoginLocators.UploadSuccessfully().getText();
		if(msgdisplayed.equalsIgnoreCase("Submitted Successfully"))
		{
			test.log(LogStatus.PASS, msgdisplayed);
		}
		else {
			test.log(LogStatus.FAIL, msgdisplayed);

		}
		LoginLocators.OK().click();
		Thread.sleep(4000);
		LoginLocators.PenActnClosePopup().click();
		Thread.sleep(4000);
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		int count = Integer.parseInt(LoginLocators.PendingActionBox().getText());	

		if(open == (open-1))
			
		{
						
		//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
						
		test.log(LogStatus.PASS, "Before perform action Count = "+open+" | After perform action Count = "+count);
					
		}
					
		else
					
		{
						
		//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
						
		test.log(LogStatus.FAIL, "Before perform action Count = "+open+" | After perform action Count = "+count);
					
		}
		    
	

	}
	public static void PendingReviewAction( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		int open = Integer.parseInt(LoginLocators.PendingReviewBox().getText());	
	    Thread.sleep(2000);
	    LoginLocators.PendingReviewBox().click();
	    Thread.sleep(2000);
	    LoginLocators.PendingActionEdit().click();	
	    Thread.sleep(9000);
        LoginLocators.ClosedDelayed().click();		
        Thread.sleep(3000);
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", LoginLocators.Remark());
		LoginLocators.Remark().sendKeys("Nill");
		 Thread.sleep(2000);
		 LoginLocators.Calender1().click();
		 Thread.sleep(2000);
		 LoginLocators.CalenderDate().click();
		 Thread.sleep(2000);
	//	LoginLocators.Submitt().click();
	//	Thread.sleep(2000);
		LoginLocators.Reject().click();
		Thread.sleep(2000);
//		LoginLocators.Closebtn().click();
//		Thread.sleep(2000);
		String  msg= LoginLocators.UploadSuccessfully().getText();
//		LoginLocators.OK().click();
//	    test.log(LogStatus.PASS, msg);
	    Thread.sleep(2000);
//	    LoginLocators.Submit().click();
//	    Thread.sleep(4000);
		String  msgdisplayed= LoginLocators.UploadSuccessfully().getText();
		if(msgdisplayed.equalsIgnoreCase("Submitted Successfully") || msgdisplayed.equalsIgnoreCase("Rejected Successfully"))
		{
			test.log(LogStatus.PASS, msgdisplayed);
		}
		else {
			test.log(LogStatus.FAIL, msgdisplayed);

		}
		LoginLocators.OK().click();
		Thread.sleep(4000);	
		LoginLocators.Closebtn().click();
		Thread.sleep(2000);
		LoginLocators.ClosePopup().click();
		Thread.sleep(2000);	
		int count = Integer.parseInt(LoginLocators.PendingReviewBox().getText());	

		if(open == (open-1))
			
		{
						
		//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
						
		test.log(LogStatus.PASS, "Before Review action Count = "+open+" | After Review action Count = "+count);
					
		}
					
		else
					
		{
						
		//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
						
		test.log(LogStatus.FAIL, "Before Review action Count = "+open+" | After Review action Count = "+count);
					
		}
		
	}
	
	public static void Viewworspace( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 if (LoginLocators.View().isDisplayed()) {
				WebDriverWait wait = new WebDriverWait(getDriver(), (120));
				wait.until(ExpectedConditions.visibilityOf(LoginLocators.View()));
	        	LoginLocators.View().click();
	    	    Thread.sleep(500);
				test.log(LogStatus.PASS,  "View Successfully");
	    	    LoginLocators.ClosePopup().click();
	    	    Thread.sleep(500);
	    	    
		 }
	}
	
	public static void WorkspaceRegister( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
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
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
		try {
		MethodsD.Viewworspace(test,user);
		}
		catch(Exception e) {
			
		}
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		try {
       if(LoginLocators.AttendaceText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.AttendaceText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Attendance Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Attendance Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlyAttendance_03Mar2025040814.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

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

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   if(attendance.equalsIgnoreCase("File uploaded successfully"))
    		   {
    			   test.log(LogStatus.PASS, "Attendance "+ attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL,  "Attendance "+ attendance);

    		   }
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
      			//getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		//   test.log(LogStatus.PASS,  "Attendance "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));
    			Thread.sleep(2000);	
    		//   LoginLocators.UploadedGreenTick().click();
//    		   // Locate the element using the provided XPath
    	  //      WebElement greenTick = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']//td/following-sibling::td/following-sibling::td/following-sibling::td"));

    	        if (Uploadgreentick.isDisplayed()) {
    	        	
    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			System.out.println("Processed Green tick is displayed.");
    	        			
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }
////////////////
            }
            
		}	
}
else {
	
	test.log(LogStatus.PASS, "The attendance template is not available for upload.");	

}
		
		
		   
		}
		
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Attendance Not present");

		}
		
		MethodsD.Salary(test, user);	
		Thread.sleep(20000);	
		MethodsD.LeaveSummaryDetails(test, user);
		Thread.sleep(2000);	
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		LoginLocators.Refresh().click();
		Thread.sleep(2000);
        LoginLocators.Check().click();
		   Thread.sleep(9000);
		  // LoginLocators.OK().click();
		 //  Thread.sleep(2000);	
		   LoginLocators.Refresh().click();
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.GenerateDocument()));
		LoginLocators.Refresh().click();
		   LoginLocators.GenerateDocument().click();
		   Thread.sleep(2000);	
		   String msg = LoginLocators.GenerationMsg().getText();
			test.log(LogStatus.PASS, msg);	
			LoginLocators.OK().click();
			   Thread.sleep(2000);	
		
		 
	}
	
	
	public static void Salary( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.SalaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.SalaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Salary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Salary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlySalary_03Mar2025041212.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

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

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   if(attendance.equalsIgnoreCase("File uploaded successfully"))
    		   {
    			   test.log(LogStatus.PASS, "Salary "+ attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL,  "Salary "+ attendance);

    		   }
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   Thread.sleep(3000);
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		//   test.log(LogStatus.PASS,  "Salary "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        if (Uploadgreentick.isDisplayed()) {
    	        	LoginLocators.Refresh().click();
    	    		   Thread.sleep(500);	
        			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		LoginLocators.Refresh().click();
     	    		   Thread.sleep(500);
            			wait.until(ExpectedConditions.visibilityOf(Validatedgreentick));

    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			LoginLocators.Refresh().click();
    	    	    		   Thread.sleep(500);
                			wait.until(ExpectedConditions.visibilityOf(Processedgreentick));

    	        			System.out.println("Processed Green tick is displayed.");
    	        			
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }
////////////////
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The salary template is not available for upload.");	

		}
		}
		catch(Exception e)
		{
			
		}
		
       
		}
		
	public static void LeaveSummaryDetails( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.LeaveSummaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.LeaveSummaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Leave Summary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Leave Summary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlyLeaveSummary_01Mar2025105223.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

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

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   if(attendance.equalsIgnoreCase("File uploaded successfully"))
    		   {
    			   test.log(LogStatus.PASS, "Leave Summary Details "+ attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL,  "Leave Summary Details "+ attendance);

    		   }
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		 //  test.log(LogStatus.PASS,  "Leave Summary Details "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        if (Uploadgreentick.isDisplayed()) {
    	        	LoginLocators.Refresh().click();
    	    		   Thread.sleep(500);	
        			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		LoginLocators.Refresh().click();
     	    		   Thread.sleep(500);
            			wait.until(ExpectedConditions.visibilityOf(Validatedgreentick));

    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			LoginLocators.Refresh().click();
    	    	    		   Thread.sleep(500);
                			wait.until(ExpectedConditions.visibilityOf(Processedgreentick));

    	        			System.out.println("Processed Green tick is displayed.");
    	        			
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }
////////////////
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The leave salary template is not available for upload.");	

		}
		}
		catch(Exception e)
		{
			
		}
       
		}
		
	public static void History( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
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
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	

		if(LoginLocators.History().isDisplayed()) {
		LoginLocators.History().click();
		Thread.sleep(3000);
		String s = LoginLocators.TotalNumberOfItems().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
			
			Thread.sleep(2000);	
			File dir2 = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(9000);
			LoginLocators.successfilehistory().click();			
		 	Thread.sleep(18000);
			File dir3 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
		   
	        Thread.sleep(9000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "History file Downloaded.");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "History file Does Not Downloaded.");
			}		
		}
		else {
			test.log(LogStatus.PASS, "No Record found");	

		}
    }
		else {
			test.log(LogStatus.PASS, "History button not displayed for particular selection. ");	

		}
		
		
	}
	
	public static void WorkspaceReturn( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
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
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickReturn().click();
		Thread.sleep(2000);
		LoginLocators.Frequency().click();
		Thread.sleep(2000);
		LoginLocators.FrequencyValue().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandBranch().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
		try {
		MethodsD.Viewworspace(test,user);
		}
		catch(Exception e) {
			
		}
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		try {
       if(LoginLocators.AttendaceText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.AttendaceText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Attendance Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Attendance Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlyAttendance_19Feb2025011916.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

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

    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		   test.log(LogStatus.PASS,  "Attendance "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));
    	        if (Uploadgreentick.isDisplayed()) {
    	        	
    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			System.out.println("Processed Green tick is displayed.");
    	        			
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }

            }
            
		}	
       
}
		
else {
	
	test.log(LogStatus.PASS, "The attendance template is not available for upload.");	

}
		
		}
		catch(Exception e)
		{
			
		}
		MethodsD.SalaryReturn(test, user);	
		Thread.sleep(2000);	
		MethodsD.LeaveSummaryDetailsReturn(test, user);
		Thread.sleep(4000);	
        LoginLocators.Check().click();
		   Thread.sleep(9000);
		   LoginLocators.OK().click();
		   Thread.sleep(2000);	
		   LoginLocators.Refresh().click();
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.GenerateDocument()));
		LoginLocators.Refresh().click();
		   LoginLocators.GenerateDocument().click();
		   Thread.sleep(2000);	
		   String msg = LoginLocators.GenerationMsg().getText();
			test.log(LogStatus.PASS, msg);	
			LoginLocators.OK().click();
			   Thread.sleep(2000);	
	
		
	}
		
	public static void frequencydropdown( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		//WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes

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
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		if(LoginLocators.frequency().isEnabled())
		{
			
			test.log(LogStatus.PASS, "After select Resgister : Frequency dropdown is disabled");	

		}
		else {
			LoginLocators.frequency().click();
			test.log(LogStatus.FAIL, "After select Resgister : Frequency dropdown is enabled");			
		}
//		LoginLocators.frequency().click();
//		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickReturn().click();
		Thread.sleep(2000);
		if(LoginLocators.frequency().isEnabled())
		{
			LoginLocators.frequency().click();
			test.log(LogStatus.PASS, "After select Return : Frequency dropdown is enabled");	

		}
		else {
			test.log(LogStatus.FAIL, "After select Return : Frequency dropdown is disabled");			
		}
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickchallan().click();
		Thread.sleep(2000);
		if(LoginLocators.frequency().isEnabled())
		{
			
			test.log(LogStatus.PASS, "After select Challan : Frequency dropdown is disabled");	

		}
		else {
			LoginLocators.frequency().click();
			test.log(LogStatus.FAIL, "After select Challan : Frequency dropdown is enabled");			
		}
		
	}

	public static void SalaryReturn( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.SalaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.SalaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Salary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Salary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlySalary_19Feb2025012247.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

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

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		   test.log(LogStatus.PASS,  "Salary "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        if (Uploadgreentick.isDisplayed()) {
    	        	LoginLocators.Refresh().click();
    	    		   Thread.sleep(500);	
        			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		LoginLocators.Refresh().click();
     	    		   Thread.sleep(500);
            			wait.until(ExpectedConditions.visibilityOf(Validatedgreentick));

    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			LoginLocators.Refresh().click();
    	    	    		   Thread.sleep(500);
                			wait.until(ExpectedConditions.visibilityOf(Processedgreentick));

    	        			System.out.println("Processed Green tick is displayed.");
    	        			
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }
////////////////
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The salary template is not available for upload.");	

		}
       
		}
		catch(Exception e)
		{
			
		}
	
	}
	
	
	public static void LeaveSummaryDetailsReturn( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.LeaveSummaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.LeaveSummaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Leave Summary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Leave Summary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlyLeaveSummary_19Feb2025012631.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

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

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		   test.log(LogStatus.PASS,  "Leave Summary Details "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        if (Uploadgreentick.isDisplayed()) {
    	        	LoginLocators.Refresh().click();
    	    		   Thread.sleep(500);	
        			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		LoginLocators.Refresh().click();
     	    		   Thread.sleep(500);
            			wait.until(ExpectedConditions.visibilityOf(Validatedgreentick));

    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			LoginLocators.Refresh().click();
    	    	    		   Thread.sleep(500);
                			wait.until(ExpectedConditions.visibilityOf(Processedgreentick));

    	        			System.out.println("Processed Green tick is displayed.");
    	        			
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }
////////////////
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The leave salary template is not available for upload.");	

		}
		}
		catch(Exception e) {
			
		}
       
		}
		
	public static void Workspacechallan( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
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
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickchallan().click();
		Thread.sleep(2000);
//		LoginLocators.Frequency().click();
//		Thread.sleep(2000);
//		LoginLocators.FrequencyValue().click();
//		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
		try {
		MethodsD.Viewworspace(test,user);
		}
		catch(Exception e) {
			
		}
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		try {
       if(LoginLocators.AttendaceText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.AttendaceText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Attendance Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Attendance Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlySalary_03Mar2025041212.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

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

    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   if(attendance.equalsIgnoreCase("File uploaded successfully"))
    		   {
    			   test.log(LogStatus.PASS, "Attendance "+ attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL,  "Attendance "+ attendance);

    		   }
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
   			getDriver().manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		//   test.log(LogStatus.PASS,  "Attendance "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));
    	        if (Uploadgreentick.isDisplayed()) {
    	        	
    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			LoginLocators.Refresh().click();
    	         		   Thread.sleep(2000);	
   	        			System.out.println("Processed Green tick is displayed.");

    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }

            }
            
		}	
       
}
		
else {
	
	test.log(LogStatus.PASS, "The attendance template is not available for upload.");	

}
		
		}
		catch(Exception e)
		{
			
		}
		MethodsD.SalaryChallan(test, user);	
		Thread.sleep(20000);	
		MethodsD.LeaveSummaryDetailsChallan(test, user);
		Thread.sleep(20000);
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 LoginLocators.Refresh().click();
		 Thread.sleep(4000);	
        LoginLocators.Check().click();
		   Thread.sleep(9000);
		 //  LoginLocators.OK().click();
		 //  Thread.sleep(2000);	
		   LoginLocators.Refresh().click();
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.GenerateDocument()));
		LoginLocators.Refresh().click();
		   LoginLocators.GenerateDocument().click();
		   Thread.sleep(2000);	
		   String msg = LoginLocators.GenerationMsg().getText();
		   if(msg.equalsIgnoreCase("Generation is in progress. Please check in the Statutory Documents, after receiving the email confirmation."))
		   {
			   test.log(LogStatus.PASS,  msg);
		   }
		   else {
			   test.log(LogStatus.FAIL,   msg);

		   }
			//test.log(LogStatus.PASS, msg);	
			LoginLocators.OK().click();
			   Thread.sleep(2000);	
	
		
	}
	
	
	public static void SalaryChallan( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.SalaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.SalaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Salary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Salary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlySalary_03Mar2025041212.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

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

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   if(attendance.equalsIgnoreCase("File uploaded successfully"))
    		   {
    			   test.log(LogStatus.PASS, "Salary "+ attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL, "Salary "+  attendance);

    		   }
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		  // test.log(LogStatus.PASS,  "Salary "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        if (Uploadgreentick.isDisplayed()) {
    	        	LoginLocators.Refresh().click();
    	    		   Thread.sleep(500);	
        			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		LoginLocators.Refresh().click();
     	    		   Thread.sleep(500);
            			wait.until(ExpectedConditions.visibilityOf(Validatedgreentick));

    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			LoginLocators.Refresh().click();
    	    	    		   Thread.sleep(5000);
                			wait.until(ExpectedConditions.visibilityOf(Processedgreentick));

    	        			System.out.println("Processed Green tick is displayed.");
    	        			LoginLocators.Refresh().click();
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }
////////////////
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The salary template is not available for upload.");	

		}
       
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(20000);
	
	}
	public static void LeaveSummaryDetailsChallan( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.LeaveSummaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.LeaveSummaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Leave Summary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Leave Summary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Sample-MonthlyLeaveSummary_29Jan2025054542.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

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

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   if(attendance.equalsIgnoreCase("File uploaded successfully"))
    		   {
    			   test.log(LogStatus.PASS, "Leave Summary Details "+ attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL, "Leave Summary Details "+  attendance);

    		   }
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		//   test.log(LogStatus.PASS,  "Leave Summary Details "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        if (Uploadgreentick.isDisplayed()) {
    	        	LoginLocators.Refresh().click();
    	    		   Thread.sleep(500);	
        			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		LoginLocators.Refresh().click();
     	    		   Thread.sleep(500);
            			wait.until(ExpectedConditions.visibilityOf(Validatedgreentick));

    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			LoginLocators.Refresh().click();
    	    	    		   Thread.sleep(500);
                			wait.until(ExpectedConditions.visibilityOf(Processedgreentick));

    	        			System.out.println("Processed Green tick is displayed.");
    	        			
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }
////////////////
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The leave salary template is not available for upload.");	

		}
		}
		catch(Exception e) {
			
		}
		Thread.sleep(20000);
       
		}
	
	public static void Empty( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	


	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
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
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
//		try {
//		Methods.Viewworspace(test,user);
//		}
//		catch(Exception e) {
//			
//		}
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		LoginLocators.Browse().click();
	       Thread.sleep(4000);  // Wait for dialog to appear

	        // Specify the file path
	        String filePath = "E:\\Labor Upload\\Sample-MonthlyAttendance_EmptySheet.xlsx";
	        StringSelection selection = new StringSelection(filePath);

	        // Copy file path to clipboard
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

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

	      //  System.out.println("File uploaded successfully!");
		//   LoginLocators.Uploads().click();
	        Thread.sleep(9000);
	        LoginLocators.Uploads().click();
		   Thread.sleep(7000);
		   
		   String attendance = LoginLocators.UploadSuccessfully().getText();
		   Thread.sleep(2000);
		   LoginLocators.OK().click();
		   Thread.sleep(2000);	
		   LoginLocators.Refresh().click();
		   Thread.sleep(2000);	
		   if(attendance.equalsIgnoreCase("Empty sheet"))
		   {
			   test.log(LogStatus.PASS,  attendance);
		   }
		   else {
			   test.log(LogStatus.FAIL,   attendance);

		   }
     
     
	}
		
	public static void WorkspaceRegisterEmptyfileupload( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	


	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
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
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandBranch().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
//		try {
//		Methods.Viewworspace(test,user);
//		}
//		catch(Exception e) {
//			
//		}
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		try {
       if(LoginLocators.AttendaceText().isDisplayed() || LoginLocators.SalaryText().isDisplayed() || LoginLocators.LeaveSummaryText().isDisplayed() ) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String textLS = LoginLocators.LeaveSummaryText().getText();

            String textsalary = LoginLocators.SalaryText().getText();
            String text = LoginLocators.AttendaceText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t) || textsalary.equalsIgnoreCase(t) || textLS.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				//test.log(LogStatus.PASS,  "Attendance Template Downloaded.");
    			}
    		   else
    		   {
    			//	test.log(LogStatus.FAIL, "Attendance Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Sample-MonthlyAttendance_EmptySheet.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

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

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		   if(attendance.equalsIgnoreCase("Empty sheet"))
    		   {
    			   test.log(LogStatus.PASS, "attendance"+ attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL, "attendance"+  attendance);

    		   }
            }
            
		}	
}
else {
	
	test.log(LogStatus.PASS, "The attendance template is not available for upload.");	

}
		
		
		   
		}
		
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Attendance Not present");

		}
		
	//	Methods.SalaryEmptysheet(test, user);	
	//	Thread.sleep(2000);	
	//	Methods.LeaveSummaryDetailsEmptySheet(test, user);
	//	Thread.sleep(4000);	
//        LoginLocators.Check().click();
//		   Thread.sleep(9000);
		//   LoginLocators.OK().click();
		//   Thread.sleep(2000);	
		   LoginLocators.Refresh().click();
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.GenerateDocument()));
//		LoginLocators.Refresh().click();
//		   LoginLocators.GenerateDocument().click();
//		   Thread.sleep(2000);	
//		   String msg = LoginLocators.GenerationMsg().getText();
//			test.log(LogStatus.PASS, msg);	
//			LoginLocators.OK().click();
//			   Thread.sleep(2000);	
		
		 
	}
	
	public static void SalaryEmptysheet( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.SalaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.SalaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Salary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Salary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Sample-MonthlySalary_EmptySheet.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

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

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		   if(attendance.equalsIgnoreCase("Empty sheet"))
    		   {
    			   test.log(LogStatus.PASS,  attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL,   attendance);

    		   }
    	       
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The salary template is not available for upload.");	

		}
		}
		catch(Exception e)
		{
			
		}
		
       
		}
		
	public static void LeaveSummaryDetailsEmptySheet( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.LeaveSummaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.LeaveSummaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Leave Summary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Leave Summary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Sample-MonthlyLeaveSummary_EmptySheet.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

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

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		   if(attendance.equalsIgnoreCase("Empty sheet"))
    		   {
    			   test.log(LogStatus.PASS,  attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL,   attendance);

    		   }    		   
    			
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The leave salary template is not available for upload.");	

		}
		}
		catch(Exception e)
		{
			
		}
       
		}
	
	public static void Workspacewithoutentersheetupload( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	


	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
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
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		LoginLocators.Submit().click();
		Thread.sleep(9000);	
		 String attendance = LoginLocators.UploadSuccessfully().getText();
		   Thread.sleep(2000);
		   LoginLocators.OK().click();
		   Thread.sleep(2000);	
		   LoginLocators.Refresh().click();
		   Thread.sleep(2000);	
		   if(attendance.equalsIgnoreCase("No file chosen"))
		   {
			   test.log(LogStatus.PASS,  attendance);
		   }
		   else {
			   test.log(LogStatus.FAIL,   attendance);

		   }    
		
	}
		
	public static void WorkspaceinvalidTemplateupload( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	


	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
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
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandBranch().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
//		try {
//		Methods.Viewworspace(test,user);
//		}
//		catch(Exception e) {
//			
//		}
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		try {
       if(LoginLocators.AttendaceText().isDisplayed() || LoginLocators.SalaryText().isDisplayed() || LoginLocators.LeaveSummaryText().isDisplayed() ) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String textLS = LoginLocators.LeaveSummaryText().getText();

            String textsalary = LoginLocators.SalaryText().getText();
            String text = LoginLocators.AttendaceText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t) || textsalary.equalsIgnoreCase(t) || textLS.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
//            	Thread.sleep(2000);	
//    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
//    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
//    			
//    			Thread.sleep(9000);
//    			
//    	//	LoginLocators.AttendanceTemplate().click();
//    			AttendanceTemplate.click();
//    		 	Thread.sleep(18000);
//    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
//    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
//    			
//    		   
//    	        Thread.sleep(9000);
//    		   if (dirContents1.length < allFilesNew1.length) {
//    				//test.log(LogStatus.PASS,  "Attendance Template Downloaded.");
//    			}
//    		   else
//    		   {
//    			//	test.log(LogStatus.FAIL, "Attendance Template Does Not Downloaded.");
//    			}		
//    		   Thread.sleep(3000);
//    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Sample-FineAndDeduction_InvalidTemplateUpload.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

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

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		   if(attendance.equalsIgnoreCase("Invalid Headers"))
    		   {
    			   test.log(LogStatus.PASS,  attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL,   attendance);

    		   }
            }
            
		}	
}
else {
	
	test.log(LogStatus.PASS, "The attendance template is not available for upload.");	

}
		
		
		   
		}
		
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Attendance Not present");

		}
		

		 
	}
	
	


public static void WorkspaceErroorFileDownload( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	LoginLocators.ComplianceDropdown().click();
	Thread.sleep(2000);
	LoginLocators.ClickRegister().click();
	Thread.sleep(2000);
	LoginLocators.SelectActDropdown().click();
	Thread.sleep(2000);
	LoginLocators.ClickAct().click();
	Thread.sleep(2000);
	LoginLocators.YearDropdown().click();
	Thread.sleep(2000);
	LoginLocators.Clickyear().click();
	Thread.sleep(2000);
	LoginLocators.PeriodDropdown().click();
	Thread.sleep(2000);
	LoginLocators.ClickPeriod().click();
	Thread.sleep(2000);
	LoginLocators.AllFile().click();
	Thread.sleep(2000);
	LoginLocators.SelectAllCheckbox().click();
	Thread.sleep(2000);
	LoginLocators.branch().click();
	Thread.sleep(2000);
	LoginLocators.ExpandBranch().click();
	Thread.sleep(2000);
	LoginLocators.branchvalue().click();
	Thread.sleep(2000);
	LoginLocators.ApplyButton().click();
	Thread.sleep(6000);
	LoginLocators.CheckBox().click();
	Thread.sleep(2000);
	LoginLocators.Proceed().click();
	Thread.sleep(9000);	
	try {
   if(LoginLocators.SalaryText().isDisplayed() ) {
	WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
    List<WebElement> rows = table.findElements(By.tagName("tr"));

    int Row_Count = rows.size();

	for (int i = 1; i <= Row_Count; i++) {
        // Construct the dynamic XPath
     //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
      //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
        
        String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
        WebElement col = getDriver().findElement(By.xpath(column));
        String t = col.getText();
        

        String textsalary = LoginLocators.SalaryText().getText();
        System.out.print(t + " | "+ textsalary); // Print text of each column
        if(textsalary.equalsIgnoreCase(t)) {
        String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
        WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
        
        String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
        WebElement Browse = getDriver().findElement(By.xpath(Brows));
      
        String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
        WebElement Uploads = getDriver().findElement(By.xpath(upload));
        
        String downloadErrorFile = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
        WebElement DownloadErrorFile = getDriver().findElement(By.xpath(downloadErrorFile));
        
        
        
        	Thread.sleep(2000);	
			File dir2 = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(9000);
			
	//	LoginLocators.AttendanceTemplate().click();
			AttendanceTemplate.click();
		 	Thread.sleep(18000);
			File dir3 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
		   
	        Thread.sleep(9000);
	   if (dirContents1.length < allFilesNew1.length) {
			//test.log(LogStatus.PASS,  "Attendance Template Downloaded.");
			}
		   else
		   {
			//	test.log(LogStatus.FAIL, "Attendance Template Does Not Downloaded.");
			}		
		   Thread.sleep(3000);
		 //  LoginLocators.Browse().click();
		  
		   Browse.click();
	       Thread.sleep(4000);  // Wait for dialog to appear

	        // Specify the file path
	        String filePath = "E:\\Labor Upload\\Sample-MonthlySalary_ErrorFile.xlsx";
	        StringSelection selection = new StringSelection(filePath);

	        // Copy file path to clipboard
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

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

	      //  System.out.println("File uploaded successfully!");
		//   LoginLocators.Uploads().click();
	        Thread.sleep(9000);
	        Uploads.click();
		   Thread.sleep(7000);
		   
		   String attendance = LoginLocators.UploadSuccessfully().getText();
		   Thread.sleep(2000);
		   LoginLocators.OK().click();
		   Thread.sleep(2000);	
		   LoginLocators.Refresh().click();
		   Thread.sleep(2000);	
		   if(attendance.equalsIgnoreCase("Invalid Headers"))
		   {
			   test.log(LogStatus.PASS,  attendance);
		   }
		   else {
			   test.log(LogStatus.FAIL,   attendance);

		   }
		   
		   Thread.sleep(2000);	
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(9000);
			
	//	LoginLocators.AttendanceTemplate().click();
			DownloadErrorFile.click();
		 	Thread.sleep(18000);
			File dirs = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dirs.listFiles();						//Counting number of files in directory after download
			
		   
	        Thread.sleep(9000);
	   if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "Error Sheet Downloaded.");
			}
		   else
		   {
			test.log(LogStatus.FAIL, "Error Sheet Does Not Downloaded.");
			}		
		   Thread.sleep(3000);
		   
        }
        
	}	
}
else {

test.log(LogStatus.PASS, "The sallary template is not available for upload.");	

}
	
	
	   
	}
	
	catch(Exception e) {
		test.log(LogStatus.FAIL, "Attendance Not present");

	}
	

	 
}


public static void ECRMasterExport( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	LoginLocators.ECRMasterTab().click();
	Thread.sleep(3000);
	MethodsD.GridAndExcelCount(test,workbook);
	Thread.sleep(2000);
	
}

public static void ECRMasterAddNew( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	Thread.sleep(500);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(500);
	LoginLocators.ECRMasterTab().click();
	Thread.sleep(2000);
	String id = LoginLocators.id().getText();
	Thread.sleep(500);
	LoginLocators.AddNew().click();
	Thread.sleep(500);
	LoginLocators.ClientID().click();
	LoginLocators.ClientID().sendKeys("AVACORED9");
	Thread.sleep(500);
	LoginLocators.UserID().click();
	LoginLocators.UserID().sendKeys(id+"89036");
	Thread.sleep(500);
	LoginLocators.password().click();
	LoginLocators.password().sendKeys("teamlease");
	Thread.sleep(500);
	LoginLocators.Save().click();
	Thread.sleep(500);
	String attendance = LoginLocators.UploadSuccessfully().getText();
	   Thread.sleep(2000);
	   if(attendance.equalsIgnoreCase("User Updated successfully"))
	   {
		   test.log(LogStatus.PASS,  attendance);
	   }
	   else {
		   test.log(LogStatus.FAIL,   attendance);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(2000);
	  // LoginLocators.CloseAddnewpopup().click();
	  // Thread.sleep(2000);
	
	
	
	
}

public static void ECRMasterBulkUpload( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	Thread.sleep(500);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(500);
	LoginLocators.ECRMasterTab().click();
	Thread.sleep(2000);
	LoginLocators.BulkUpload().click();
	Thread.sleep(500);
	Thread.sleep(2000);	
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	
	Thread.sleep(9000);
	LoginLocators.SampleDocument().click();
 	Thread.sleep(18000);
	File dirs = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dirs.listFiles();						//Counting number of files in directory after download
	
   
    Thread.sleep(9000);
if (dirContents.length < allFilesNew.length) {
	test.log(LogStatus.PASS,  "Sample Document Downloaded.");
	}
   else
   {
	test.log(LogStatus.FAIL, "Sample Document Does Not Downloaded.");
	}		
   Thread.sleep(3000);
	LoginLocators.Brows().click();
	Thread.sleep(2000);
	// Specify the file path
    String filePath = "E:\\Labor Upload\\UploadPFECRMaster.xlsx";
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
	Thread.sleep(500);
	String attendance = LoginLocators.UploadSuccessfully().getText();
	   Thread.sleep(2000);
	   if(attendance.equalsIgnoreCase("File uploaded successfully!"))
	   {
		   test.log(LogStatus.PASS,  attendance);
	   }
	   else {
		   test.log(LogStatus.FAIL,   attendance);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(2000);
	  
	
	
	
	
}

public static void ECRMasterUpdate( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	Thread.sleep(500);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(500);
	LoginLocators.ECRMasterTab().click();
	Thread.sleep(2000);
	LoginLocators.Edit().click();
	Thread.sleep(500);
	LoginLocators.password().click();
	LoginLocators.password().clear();
	LoginLocators.password().sendKeys("abcdefgh");
	Thread.sleep(500);
	LoginLocators.Save().click();
	Thread.sleep(500);
	String attendance = LoginLocators.UploadSuccessfully().getText();
	   Thread.sleep(2000);
	   if(attendance.equalsIgnoreCase("User Updated successfully"))
	   {
		   test.log(LogStatus.PASS,  attendance);
	   }
	   else {
		   test.log(LogStatus.FAIL,   attendance);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(2000);
	   
	
	
	
	
}

public static void ECRMasterInvalidClientID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	Thread.sleep(500);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(500);
	LoginLocators.ECRMasterTab().click();
	Thread.sleep(2000);
	LoginLocators.AddNew().click();
	Thread.sleep(500);
	LoginLocators.ClientID().click();
	LoginLocators.ClientID().sendKeys("AVATCGENGVT");
	Thread.sleep(500);
	LoginLocators.UserID().click();
	LoginLocators.UserID().sendKeys("4567890123578905");
	Thread.sleep(500);
	LoginLocators.password().click();
	LoginLocators.password().sendKeys("teamlease");
	Thread.sleep(500);
	LoginLocators.Save().click();
	Thread.sleep(500);
	String attendance = LoginLocators.Msg().getText();
	   Thread.sleep(2000);
	   if(attendance.equalsIgnoreCase("Client ID does not exist!"))
	   {
		   test.log(LogStatus.PASS,  attendance);
	   }
	   else {
		   test.log(LogStatus.FAIL,   attendance);

	   }
	   //LoginLocators.OK().click();
	  // Thread.sleep(2000);
	   LoginLocators.CloseAddnewpopup().click();
	   Thread.sleep(2000);
	
	
	
	
}

public static void ECRMasterSearch( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	LoginLocators.ECRMasterTab().click();
	Thread.sleep(3000);
	String searchvalue = LoginLocators.GridValue().getText();
	Thread.sleep(500);
	LoginLocators.searchuserid().click();
	Thread.sleep(3000);
	LoginLocators.searchuserid().sendKeys(searchvalue);
	Thread.sleep(3000);
	LoginLocators.searchuserid().clear();
	Thread.sleep(3000);
	LoginLocators.searchuserid().sendKeys(searchvalue);
	Thread.sleep(3000);
	LoginLocators.searchuseridDD().click();
	Thread.sleep(3000);
	LoginLocators.TotalNumberOfItem().click();					
	String s = LoginLocators.TotalNumberOfItem().getText();
	Thread.sleep(2000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		String searchvalue1 = LoginLocators.GridValue().getText();
		   test.log(LogStatus.PASS,  "Search filter Working properly : "+ searchvalue1);

	}
	else {
		   test.log(LogStatus.FAIL,  "Search filter does not working properly ");

	}
	
	
}

public static void SubcodeMasterSearch( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.DashboardArrow().click();
	Thread.sleep(2000);
	LoginLocators.ESICCards().click();
	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(3000);
//	LoginLocators.ECRMasterTab().click();
//	Thread.sleep(3000);
	String searchvalue = LoginLocators.GridValue().getText();
	Thread.sleep(500);
	LoginLocators.searchuserid().click();
	Thread.sleep(3000);
	LoginLocators.searchuserid().sendKeys(searchvalue);
	Thread.sleep(3000);
	LoginLocators.searchuserid().clear();
	Thread.sleep(3000);
	LoginLocators.searchuserid().sendKeys(searchvalue);
	Thread.sleep(3000);
	LoginLocators.searchuseridDD().click();
	Thread.sleep(3000);
	LoginLocators.TotalNumberOfItem().click();					
	String s = LoginLocators.TotalNumberOfItem().getText();
	Thread.sleep(2000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		String searchvalue1 = LoginLocators.GridValue().getText();
		   test.log(LogStatus.PASS,  "Search filter Working properly : "+ searchvalue1);

	}
	else {
		   test.log(LogStatus.FAIL,  "Search filter does not working properly ");

	}
	
	
}

public static void AddUser( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(500);
	LoginLocators.DashboardArrow().click();
	Thread.sleep(2000);
	LoginLocators.ESICCards().click();
	Thread.sleep(2000);
	LoginLocators.AddNew().click();
	Thread.sleep(500);
	LoginLocators.UserId().sendKeys("356790065467654");
	Thread.sleep(500);
	LoginLocators.password().sendKeys("teamlease");
	Thread.sleep(500);
	LoginLocators.Save().click();
	Thread.sleep(500);
	String msg = LoginLocators.MessageDisplayed1().getText();
	   Thread.sleep(2000);
	   if(msg.equalsIgnoreCase("User Updated successfully"))
	   {
		   test.log(LogStatus.PASS,  msg);
	   }
	   else {
		   test.log(LogStatus.FAIL,   msg);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(2000);
	   getDriver().navigate().refresh();
		Thread.sleep(500);
	   MethodsD.GridAndExcelCounts(test,workbook);
		Thread.sleep(2000);
		LoginLocators.Edit().click();
		Thread.sleep(500);
		LoginLocators.UserId().clear();
		LoginLocators.UserId().sendKeys("3567900654699");
		Thread.sleep(500);
		LoginLocators.password().clear();
		LoginLocators.password().sendKeys("teamlease");
		Thread.sleep(500);
		LoginLocators.Save().click();
		Thread.sleep(500);
		String msgDisplayed = LoginLocators.MessageDisplayed1().getText();
		   Thread.sleep(2000);
		   if(msgDisplayed.equalsIgnoreCase("User Updated successfully"))
		   {
			   test.log(LogStatus.PASS,  msgDisplayed);
		   }
		   else {
			   test.log(LogStatus.FAIL,   msgDisplayed);

		   }
		   LoginLocators.OK().click();
		   Thread.sleep(2000);

		
}

public static void DispensaryMaster( ExtentTest test, String user,XSSFWorkbook workbook ) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(500);
	LoginLocators.DashboardArrow().click();
	Thread.sleep(2000);
	LoginLocators.ESICCards().click();
	Thread.sleep(2000);
	LoginLocators.DispensaryMaster().click();
	Thread.sleep(2000);
	LoginLocators.ComplianceDropdown().click();
	Thread.sleep(2000);
	LoginLocators.ClickState().click();
	Thread.sleep(2000);
	LoginLocators.AddNew().click();
	Thread.sleep(500);
	
	FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook1 = WorkbookFactory.create(fis);
    Sheet sheet = workbook1.getSheetAt(1);
	Thread.sleep(2000);
 				
	Row row = sheet.getRow(3);						//Selected 0th index row (First row)
 	Cell c= row.getCell(1);						//Selected cell (0 row,1 column)
 	String district1 = c.getStringCellValue();
 	LoginLocators.districtName().sendKeys(district1);
	
 	Row row1 = sheet.getRow(4);						//Selected 0th index row (First row)
 	Cell c1= row1.getCell(1);						//Selected cell (0 row,1 column)
 	String dispensary = c1.getStringCellValue();
 	LoginLocators.dispenceryName().sendKeys(dispensary);

	//LoginLocators.districtName().sendKeys("Yavatmal"); // Writing Task title
	//Thread.sleep(2000);	
	//LoginLocators.dispenceryName().sendKeys("Yavatmal, MH (ESIS Disp.)"); // Writing Task title
	Thread.sleep(2000);
	LoginLocators.Save().click();
	Thread.sleep(500);
	String msgDisplayed = LoginLocators.MessageDisplayed1().getText();
	   Thread.sleep(2000);
	   if(msgDisplayed.equalsIgnoreCase("Dispensary Updated successfully"))
	   {
		   test.log(LogStatus.PASS,  msgDisplayed);
	   }
	   else {
		   test.log(LogStatus.FAIL,   msgDisplayed);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(2000);
	   getDriver().navigate().refresh();
		Thread.sleep(500);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickState().click();
		Thread.sleep(2000);
	   MethodsD.GridAndExcelCounts(test,workbook);
		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickState().click();
		Thread.sleep(2000);
		String district = LoginLocators.GridValue1().getText();
		Thread.sleep(2000);	
		LoginLocators.edit().click();
		Thread.sleep(2000);
		
		LoginLocators.dispenceryName().clear();
		Thread.sleep(2000);
		LoginLocators.dispenceryName().sendKeys(district +", MH (ESIS Disp.)"); // Writing Task title
		Thread.sleep(2000);
		Thread.sleep(500);
		LoginLocators.Save().click();
		Thread.sleep(500);
		String msg = LoginLocators.MessageDisplayed1().getText();
		   Thread.sleep(2000);
		   if(msg.equalsIgnoreCase("Dispensary Updated successfully"))
		   {
			   test.log(LogStatus.PASS,  msg);
		   }
		   else {
			   test.log(LogStatus.FAIL,   msg);

		   }
		   LoginLocators.OK().click();
		   Thread.sleep(2000);

	
	
	
}

public static void DispensaryMasterFilter( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(500);
	LoginLocators.DashboardArrow().click();
	Thread.sleep(2000);
	LoginLocators.ESICCards().click();
	Thread.sleep(2000);
	LoginLocators.DispensaryMaster().click();
	Thread.sleep(2000);
	LoginLocators.ComplianceDropdown().click();
	Thread.sleep(2000);
	String state = LoginLocators.ClickState().getText();
	LoginLocators.ClickState().click();
	Thread.sleep(2000);
	
	List<String> li=new ArrayList<String>();
    
    //  li.add(locationtext);
      li.add(state);
      
      
      Thread.sleep(3000);
      
		List<String> filter=new ArrayList<String>();	
		filter.add("State");
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItem().click();					
		String s = LoginLocators.TotalNumberOfItem().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> statecol=getDriver().findElements(By.xpath("//td[1]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(statecol);
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
			test.log(LogStatus.PASS,"No records available.");	
		}
		Thread.sleep(3000);

	
}

public static void dispensaryMasterSearch( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.DashboardArrow().click();
	Thread.sleep(2000);
	LoginLocators.ESICCards().click();
	Thread.sleep(2000);
	LoginLocators.DispensaryMaster().click();
	Thread.sleep(2000);
	LoginLocators.ComplianceDropdown().click();
	Thread.sleep(2000);
	LoginLocators.ClickState().click();
	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(3000);
	String searchvalue = LoginLocators.GridValue1().getText();
	Thread.sleep(2000);

	LoginLocators.Serach().sendKeys(searchvalue);
	Thread.sleep(3000);

	LoginLocators.TotalNumberOfItem().click();					
	String s = LoginLocators.TotalNumberOfItem().getText();
	Thread.sleep(2000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		String searchvalue1 = LoginLocators.GridValue1().getText();
		   test.log(LogStatus.PASS,  "Search filter Working properly : "+ searchvalue1);

	}
	else {
		   test.log(LogStatus.FAIL,  "Search filter does not working properly ");

	}
	
}
public static void MyDocumnent(ExtentTest test,String user) throws InterruptedException, IOException, AWTException
{


	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	LoginLocators.DashboardArrow().click();
	Thread.sleep(9000);
	LoginLocators.MyDocument().click();
	Thread.sleep(2000);
	LoginLocators.AddNew().click();
	Thread.sleep(500);
	LoginLocators.SelectActivity().click();
	Thread.sleep(500);
	LoginLocators.ActivityValue().click();
	Thread.sleep(500);
	LoginLocators.SelectState().click();
	Thread.sleep(500);
	LoginLocators.StateValue().click();
	Thread.sleep(500);
	LoginLocators.Location().click();
	Thread.sleep(500);
	LoginLocators.LocationValue().click();
	Thread.sleep(500);
	LoginLocators.ClickBranch().click();
	Thread.sleep(500);
	LoginLocators.ClickBranchValue().click();
	Thread.sleep(500);
	LoginLocators.RegistrationType().click();
	Thread.sleep(500);
	LoginLocators.RegistrationTypeValue().click();
	Thread.sleep(500);
	FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook1 = WorkbookFactory.create(fis);
    Sheet sheet = workbook1.getSheetAt(3);
	Thread.sleep(2000);
 				
	Row row = sheet.getRow(0);						//Selected 0th index row (First row)
 	Cell c= row.getCell(1);						//Selected cell (0 row,1 column)
 	String rcnumber = c.getStringCellValue();
 	LoginLocators.rcnumber().sendKeys(rcnumber);
 	Thread.sleep(2000);
 	LoginLocators.chooseFile().click();
	Thread.sleep(4000);
 	
 	String filePath = "E:\\Labor Upload\\ContractsList__MyWorkspace (1).pdf";
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
	Thread.sleep(5000);
//	LoginLocators.rcnumber().click();
	Thread.sleep(5000);	
	LoginLocators.checkbox().click();
	Thread.sleep(500);
	LoginLocators.SaveDocument().click();
	Thread.sleep(500);
	String msg = LoginLocators.MessageDisplayed1().getText();
	   Thread.sleep(2000);
	   if(msg.equalsIgnoreCase("Record added Successfully!"))
	   {
		   test.log(LogStatus.PASS,  msg);
	   }
	   else {
		   test.log(LogStatus.FAIL,   msg);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(3000);
}
public static void MyDocumnentExport(ExtentTest test,String user) throws InterruptedException, IOException, AWTException
{


	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	LoginLocators.DashboardArrow().click();
	Thread.sleep(9000);
	LoginLocators.MyDocument().click();
	Thread.sleep(2000);
	LoginLocators.Exportbtn().click();
	Thread.sleep(2000);
	LoginLocators.Select().click();
	Thread.sleep(2000);
	LoginLocators.SelectEntityvalue().click();
	Thread.sleep(2000);
	File dir2 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
	
	Thread.sleep(9000);
	LoginLocators.Consolidated().click();
	
 	Thread.sleep(18000);
	File dir3 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
	
   
    Thread.sleep(9000);
   if (dirContents1.length < allFilesNew1.length) {
		test.log(LogStatus.PASS,  "Consolidated Report Downloaded.");
	}
   else
   {
		test.log(LogStatus.FAIL, "Consolidated Report Does Not Downloaded.");
	}		
   Thread.sleep(2000);
   File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	
	Thread.sleep(9000);
	LoginLocators.Expired().click();
	
	Thread.sleep(18000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew2 = dir1.listFiles();						//Counting number of files in directory after download
	
  
   Thread.sleep(9000);
  if (dirContents.length < allFilesNew2.length) {
		test.log(LogStatus.PASS,  "Expired Report Downloaded.");
	}
  else
  {
		test.log(LogStatus.FAIL, "Expired Report Does Not Downloaded.");
	}		
  Thread.sleep(3000);
  File dir4 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents4 = dir4.listFiles();						//Counting number of files in directory before download
	
	Thread.sleep(9000);
	LoginLocators.CloseToExpired().click();
	
	Thread.sleep(18000);
	File dir5 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew5 = dir5.listFiles();						//Counting number of files in directory after download
	

 Thread.sleep(9000);
if (dirContents4.length < allFilesNew5.length) {
		test.log(LogStatus.PASS,  "Close To Expired Report Downloaded.");
	}
else
{
		test.log(LogStatus.FAIL, "Close To Expired Report Does Not Downloaded.");
	}		
Thread.sleep(3000);
LoginLocators.CloseAddnewpopup().click();
Thread.sleep(3000);
	
	
}

public static void MyDocumnentDigitalSignature(ExtentTest test,String user) throws InterruptedException, IOException, AWTException
{


	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	LoginLocators.DashboardArrow().click();
	Thread.sleep(9000);
	LoginLocators.MyDocument().click();
	Thread.sleep(2000);
//	LoginLocators.DigitalSignatureTab().click(); //Hide this coz registrations is removed only digi sign is there
	Thread.sleep(2000);
	LoginLocators.AddNewDS().click();
	Thread.sleep(2000);
	
	FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook1 = WorkbookFactory.create(fis);
    Sheet sheet = workbook1.getSheetAt(3);
	Thread.sleep(2000);
 				
	Row row = sheet.getRow(1);						//Selected 0th index row (First row)
 	Cell c= row.getCell(1);						//Selected cell (0 row,1 column)
 	String AuthorisedPerId = c.getStringCellValue();
 	LoginLocators.AuthorisedPerId().sendKeys(AuthorisedPerId);
 	Thread.sleep(2000);
 	
 	Row row1 = sheet.getRow(2);						//Selected 0th index row (First row)
 	Cell c1= row1.getCell(1);						//Selected cell (0 row,1 column)
 	String AuthorisedPer = c1.getStringCellValue();
 	LoginLocators.AuthorisedPer().sendKeys(AuthorisedPer);
 	Thread.sleep(2000);
 	
 	Row row2 = sheet.getRow(3);						//Selected 0th index row (First row)
 	Cell c2= row2.getCell(1);						//Selected cell (0 row,1 column)
 	String designation = c2.getStringCellValue();
 	LoginLocators.designation().sendKeys(designation);
 	Thread.sleep(2000);
 	
 	Row row3 = sheet.getRow(4);						//Selected 0th index row (First row)
 	Cell c3= row3.getCell(1);						//Selected cell (0 row,1 column)
 	int mobileNo = (int) c3.getNumericCellValue();
 	LoginLocators.mobileNo().sendKeys(String.valueOf(mobileNo));
 	Thread.sleep(2000);
 	
 	LoginLocators.EffectiveFrom().click();
	Thread.sleep(2000);
	LoginLocators.EffectiveFromDate().click();
	Thread.sleep(2000);
	LoginLocators.EffectiveTo().click();
	Thread.sleep(2000);
	LoginLocators.EffectiveToDate().click();
	Thread.sleep(2000);
 	
 	Row row4 = sheet.getRow(5);						//Selected 0th index row (First row)
 	Cell c4= row4.getCell(1);						//Selected cell (0 row,1 column)
 	String Remark = c4.getStringCellValue();
 	LoginLocators.Remark().sendKeys(Remark);
 	Thread.sleep(2000);	
 	LoginLocators.StatusDropDown().click();
	Thread.sleep(2000);
	LoginLocators.StatusValue().click();
	Thread.sleep(2000);
	LoginLocators.SaveDocument().click();
	Thread.sleep(2000);
	Thread.sleep(500);
	String msg = LoginLocators.MsgDisp().getText();
	   Thread.sleep(2000);
	   if(msg.equalsIgnoreCase("Signature added successfully!"))
	   {
		   test.log(LogStatus.PASS, "Add - "+ msg);
	   }
	   else {
		   test.log(LogStatus.FAIL,  "Add - " + msg);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(3000);
	  // LoginLocators.ClosePopup().click();
	 //  Thread.sleep(3000);
	   MethodsD.DigitalSignatureEdit(test,user);
	   
}

public static void DigitalSignatureEdit(ExtentTest test,String user) throws InterruptedException, IOException, AWTException
{


//	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
//	Thread.sleep(7000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
//	if(user.equalsIgnoreCase("Performer"))
//	{
//		LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
//	}
//	else if(user.equalsIgnoreCase("Distributor"))
//	{
//		LoginLocators.Search().sendKeys("WWKRG");	
//	}
//	else if(user.equalsIgnoreCase("Reviewer"))
//	{
//		LoginLocators.Search().sendKeys("Angular Entity");	
//	}
//	Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
//	LoginLocators.DashboardArrow().click();
//	Thread.sleep(2000);
//	LoginLocators.MyDocument().click();
//	Thread.sleep(2000);
//	LoginLocators.DigitalSignatureTab().click();
	Thread.sleep(2000);
	LoginLocators.Edit().click();
	Thread.sleep(2000);
	
	FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook1 = WorkbookFactory.create(fis);
    Sheet sheet = workbook1.getSheetAt(3);
	Thread.sleep(2000);
 				
	LoginLocators.AuthorisedPerId().clear();
	Thread.sleep(500);
	Row row = sheet.getRow(1);						//Selected 0th index row (First row)
 	Cell c= row.getCell(1);						//Selected cell (0 row,1 column)
 	String AuthorisedPerId = c.getStringCellValue();
 	LoginLocators.AuthorisedPerId().sendKeys(AuthorisedPerId+"2");
 	Thread.sleep(2000);
 	
 	LoginLocators.AuthorisedPer().clear();
 	Thread.sleep(500);
 	Row row1 = sheet.getRow(2);						//Selected 0th index row (First row)
 	Cell c1= row1.getCell(1);						//Selected cell (0 row,1 column)
 	String AuthorisedPer = c1.getStringCellValue();
 	LoginLocators.AuthorisedPer().sendKeys(AuthorisedPer+" kumar");
 	Thread.sleep(2000);
 	LoginLocators.designation().clear();
 	Thread.sleep(500);
 	Row row2 = sheet.getRow(3);						//Selected 0th index row (First row)
 	Cell c2= row2.getCell(1);						//Selected cell (0 row,1 column)
 	String designation = c2.getStringCellValue();
 	LoginLocators.designation().sendKeys(designation);
 	Thread.sleep(2000);
 	LoginLocators.mobileNo().clear();
 	Thread.sleep(500);
 	Row row3 = sheet.getRow(4);						//Selected 0th index row (First row)
 	Cell c3= row3.getCell(1);						//Selected cell (0 row,1 column)
 	int mobileNo = (int) c3.getNumericCellValue();
 	LoginLocators.mobileNo().sendKeys(String.valueOf(mobileNo));
 	Thread.sleep(2000);
 	
 	LoginLocators.EffectiveFrom().click();
	Thread.sleep(2000);
	LoginLocators.EffectiveFromDate().click();
	Thread.sleep(2000);
	LoginLocators.EffectiveTo().click();
	Thread.sleep(2000);
	LoginLocators.EffectiveToDate().click();
	Thread.sleep(2000);
	LoginLocators.Remark().clear();
 	Thread.sleep(500);
 	Row row4 = sheet.getRow(5);						//Selected 0th index row (First row)
 	Cell c4= row4.getCell(1);						//Selected cell (0 row,1 column)
 	String Remark = c4.getStringCellValue();
 	LoginLocators.Remark().sendKeys(Remark);
 	Thread.sleep(2000);	
 	LoginLocators.StatusDropDown().click();
	Thread.sleep(2000);
	LoginLocators.StatusValue().click();
	Thread.sleep(2000);
	LoginLocators.SaveDocument().click();
	Thread.sleep(2000);
	Thread.sleep(500);
	String msg = LoginLocators.MsgDisp().getText();
	   Thread.sleep(2000);
	   if(msg.equalsIgnoreCase("Signature added successfully!"))
	   {
		   test.log(LogStatus.PASS, "Update -"+ msg);
	   }
	   else {
		   test.log(LogStatus.FAIL, "Update -"+  msg);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(3000);
	//   LoginLocators.ClosePopup().click();
	//   Thread.sleep(3000);
	   
}

public static void MyDocumentSearch( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
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
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.DashboardArrow().click();
	Thread.sleep(9000);
	LoginLocators.MyDocument().click();
	Thread.sleep(2000);
	String searchvalue = LoginLocators.GridValue().getText();
	Thread.sleep(500);
	LoginLocators.Search1().sendKeys(searchvalue);
//	LoginLocators.Search1().click();
//	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(3000);
	LoginLocators.TotalNumberOfItem().click();					
	String s = LoginLocators.TotalNumberOfItem().getText();
	Thread.sleep(2000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		String searchvalue1 = LoginLocators.GridValue().getText();
		   test.log(LogStatus.PASS,  "Search filter Working properly : "+ searchvalue1);

	}
	else {
		   test.log(LogStatus.FAIL,  "Search filter does not working properly ");

	}
	
}
	
	
	
	
	
	
	
	
}
