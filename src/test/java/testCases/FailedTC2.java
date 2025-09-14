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
	
	

	
	@Test(priority = 76) //2 test case //10/02/2025
	void RegistrationStatusExport() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active - Export button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 77) // Bilal 1 done
	void RegistrationActiveEditbtn() throws InterruptedException, IOException
	{
	test = extent.startTest("'Registration Status' - Active - Edit button working or not?");
	
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	All_ClientPortal_Methods.RegistrationActiveEditbtn(test);
	extent.endTest(test);
	extent.flush();
	
	}
	
	@Test(priority = 78) //Bilal 2 done
	void RegistrationActiveEditSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("Registrations Status' - Active - Edit - search field working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationActiveEditSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 79) //Bilal 3 Done
	void RegistrationActiveEditExport() throws InterruptedException, IOException
	{
		test = extent.startTest("Registrations Status' - Active - Edit - Export button is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationActiveEditExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 80) //Bilal 4 Done
	void RegistrationActiveEditClear() throws InterruptedException, IOException
	{
		test = extent.startTest("Registrations Status' - Active - Edit - Clear button is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationActiveEditClear(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 81) //Bilal 5 Done
	void RegistrationActiveEditView() throws InterruptedException, IOException
	{
		test = extent.startTest("Registrations Status' - Active - Edit - View button is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationActiveEditView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 82) //Bilal ---
	void RegistrationActiveEditInitiateActionSubmit() throws InterruptedException, IOException
	{
		test = extent.startTest("Registrations Status' - Active - Edit - InitiateAction Submit button is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationActiveEditInitiateActionSubmit(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 83) //Bilal 6 Done
	void RegistrationActiveEditInitiateAction() throws InterruptedException, IOException
	{
		test = extent.startTest("Registrations Status' - Active - Edit - InitiateAction Back button is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationActiveEditInitiateAction(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 84) //Bilal 7 test case is failing 
	void RegistrationActiveEditDownloadbtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Registrations Status' - Active - Edit - Download button is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationActiveEditDownloadbtn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 85) //07/02/2025
	void RegistrationSView() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active - view button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 86) //07/02/2025
	void DownloadActive() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active - Download button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.DownloadActive(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 87) //07/02/2025 //Search Bilal
	void RegistrationSHistory() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active - History button and Type to search field are working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSHistory(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 88) //07/02/2025
	void RegistrationSHistoryExport() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active - History - Export button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSHistoryExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 89) //07/02/2025
	void RegistrationSActivePagination() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active - Verify to check all Pagination buttons are working fine or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSActivePagination(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	
	@Test(priority = 90) //Bilal
	void RegistrationStatusEx() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Verify Expired link is working and Expired count is matching with grid or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEx(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	@Test(priority = 91) //2 test case //24/02/2025
	void RegistrationStatusExportE() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Export button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusExportE(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 92) //25/02/2025
	void ExpiredSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Validate Search field working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.ExpiredSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 93) //Bilal 8 Done
	void RegistrationStatusEdit() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Edit button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEdit(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 94) //Bilal 9 Done
	void RegistrationStatusEditSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Edit - Search field working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEditSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 95) //Bilal 10 Done
	void RegistrationStatusEditExport() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Edit - Export button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEditExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 96) //Bilal 11 Done
	void RegistrationStatusEditClearbtn() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Edit - Clear button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEditClearbtn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 97) //Bilal 12 Done
	void RegistrationStatusEditView() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Edit - View button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEditView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 98) //Bilal 13 Done
	void RegistrationStatusEditInitiateAction() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Edit - InitiateAction Back button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEditInitiateAction(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 99) //Bilal 14 failed file is not getting download
	void RegistrationStatusEditDownloadbtn() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Edit - Download button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEditDownloadbtn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 100) //25/02/2025
	void RegistrationSViewEx() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - View button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSViewEx(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 101) //25/02/2025
	void DownloadActiveEx() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Download button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.DownloadActiveEx(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 102) //25/02/2025
	void RegistrationSHistoryEx() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - History button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSHistoryEx(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 103) //25/02/2025
	void RegistrationSHistorySearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - History - Search field working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSHistorySearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 104) //25/02/2025
	void RegistrationSHistoryExportEx() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - History - Export button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSHistoryExportEx(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 105) //25/02/2025
	void RegistrationSHistoryViewDownload() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - History - View and Download button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSHistoryViewDownload(test);
		
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