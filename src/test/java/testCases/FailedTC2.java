package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import clientPortal.All_ClientPortal_Methods;
import distributor.MethodsD;
import clientPortal.All_ClientPortal_Methods;
import clientPortal.All_ClientPortal_Methods;
import login.BasePage;
import performer.PerformerMethod;
import rcp.OneCommonMethod;

//Take screenshot
import org.testng.ITestResult;



public class FailedTC2 extends BasePage {
	public static WebElement upload = null;		//WebElement to get upload button
	public static ExtentReports extent;			//Instance created for report file
	public static ExtentTest test;				//Instance created for tests
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	public static List<WebElement> elementsList = null;
	public static List<WebElement> elementsList1 = null;
	public static List<WebElement> elementsList2 = null;
	public static List<WebElement> elementsList3 = null;
	public static List<WebElement> elementsList4 = null;
	public static List<WebElement> menus = null;
	public int count = 0;
	public int interest = 0;					//Variable created for reading Interest
	public int penalty = 0;						//Variable created for reading Penalty
	
	public static String link = "mgmt1";  
	
	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\FailedTC2.html",true);
		test = extent.startTest("Loging In - Client Portal"); // Need to change
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	//Client Portal Before Method
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,6,"Statutory"); //Need to change
	
	} 
	
	//Performer Before Method
/*	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,1,"Statutory");
		
		XSSFSheet sheet = ReadExcel(count);
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
	
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c2 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c2.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c3 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c3.getStringCellValue();		//Got the URL stored at position 2,1
	
	
	}
	*/
	
	
	
	
	
	@Test(priority = 222) 
	void InputUploadTemChha() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - To check whether sample template get downloaded or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadTemChha(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 223) 
	void InputUploadCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - Validate browse and upload file");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 223) 
	void InputUploadInavlidCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - Validate upload with Invalid details.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadInavlidCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 224) 
	void InputUploadBlankCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Challan - Salary  - Validate  upload with Balnk sheet.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadBlankCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 225) //14/02/2025
	void InputUploadInvalidformateCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - Validate error message for the invalid formate file upload.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadInvalidformateCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 226) 
	void InputUploadInvalidTempCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - Validate error message displayed for invalid template file upload.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadInvalidTempCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 227) 
	void InputUploadNofileCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - Validate validation message for the no choose file clicking on upload");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadNofileCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 228)  
	void IUHistoryCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - History button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUHistoryCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 229)  
	void IUHistoryDCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - History - Input History get downloaded or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUHistoryDCh(test);
		
		extent.endTest(test);
		extent.flush();
	}

	
	
	

	@Test(priority = 238) 
	void InputUploadNofilere() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Return - Salary - Validate validation message for the no choose file clicking on upload");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadNofilere(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 239)  
	void IUHistoryRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Input Upload - Return - Salary - History button is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUHistoryRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 240)  
	void IUHistoryDRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Input Upload - Return - Salary - History - Input History get downloaded or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUHistoryDRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	

	
	
	

	

   	
   	
	

	
	

//	@Test(retryAnalyzer = RetryAnalyzer.class , priority = 27)
	void exportERE() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' - Edit - Validate Download button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.exportERE(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	void browserClosing(ITestResult result) throws InterruptedException
  	{	
		
//	    boolean isFailed = result.getStatus() == ITestResult.FAILURE;
//	    OneCommonMethod.captureScreenshotOnFailure(getDriver(), test, isFailed); // call to your common method
		
	    
	    boolean isFailed = result.getStatus() == ITestResult.FAILURE;
	    OneCommonMethod.captureScreenshotOnFailure(getDriver(), test, isFailed); // Your common method call
	    Thread.sleep(3000);
		closeBrowser();
  		//Thread.sleep(1000);
  		//getDriver().close();
  	}	       
  		       		
  	@AfterTest
  	void Closing() throws InterruptedException
  	{
  		
  	}
	
	
	
	
	
	
}