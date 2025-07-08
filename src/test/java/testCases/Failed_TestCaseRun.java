package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import clientPortal.All_ClientPortal_Methods;
import coordinator.CoordinatorMethod;
import distributor.All_Distributor_Methods;
import login.BasePage;
import login.LoginLocators;
import org.openqa.selenium.chrome.ChromeDriver; //For Headless mode
import org.openqa.selenium.WebDriver;   //Headless mode
import org.openqa.selenium.WebDriver;   //Headless mode
import org.openqa.selenium.chrome.ChromeDriver; //Headless mode
import org.openqa.selenium.chrome.ChromeOptions; //Headless mode



	public class Failed_TestCaseRun extends BasePage {
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
			extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\FailedTC.html",true);
			
			
			test = extent.startTest("Loging In - Client Login  Test Case"); //Need to change this name every time
			test.log(LogStatus.PASS, "Logging into system");

			extent.endTest(test);
			extent.flush();
		}
		
		@BeforeMethod
		void Login() throws InterruptedException, IOException
		{
			initialization(link,6,"Statutory"); //Need to change link number
		
		}
	
// This code for headless mode tried but still getting an errors
/*		
		
//		ChromeOptions opt = new ChromeOptions();
//		opt.setHeadless(true);		
//		WebDriver driver = new ChromeDriver(opt);
		
		
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		ChromeOptions opt = new ChromeOptions();
	//	opt.setHeadless(true); 
		// OR opt.addArguments("--headless");
		
		opt.addArguments("--window-size=1920,1080"); // recommended for full page rendering

		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://your-site.com");

		// rest of your test steps... 
		*/

		
		
		@Test(priority = 22)//05/02/2025  need to check with mayuri
		void ViewAddNew() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("'Open Notices' - View - add new button working or not?");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.ViewAddNew(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 22)//05/02/2025  need to check with mayuri
		void ViewAddNewNotices() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("'Open Notices' - View - add new button working or not?");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.ViewAddNewNotices(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
	  	
	 	@Test(priority = 59)
	   	void AddNewNotices() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
	   	{
	   		test = extent.startTest("Notices - Add New Notices verification");
	   		All_ClientPortal_Methods.filterEntityAUTO2(test);
	   		
	   		All_ClientPortal_Methods.AddNewNotices(test);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
	
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		

		
		

		
		@Test(priority = 1) //04/02/2025
		void Entities() throws InterruptedException, IOException
		{
			test = extent.startTest("'Entities' Count verification");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			
			All_ClientPortal_Methods.Entities(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 3)
		void Locations() throws InterruptedException, IOException
		{
			test = extent.startTest("'Locations' Count verification");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.Locations(test);
			
			extent.endTest(test);
			extent.flush();
		}

		@Test(priority = 4)
		void LocationsSearch() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate Locations search filter working or not?");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.LocationsSearch(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 7) //Bilal 
		void assignedCompChallanExport() throws InterruptedException, IOException
		{
			test = extent.startTest("Assigned Compliances - Compliance dropdown Challan - Verify Export count");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.assignedCompChallanExport(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 7) //Bilal 
		void assignedCompReturnExport() throws InterruptedException, IOException
		{
			test = extent.startTest("Assigned Compliances - Compliance dropdown Return - Verify Export count");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.assignedCompReturnExport(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 9)
		void OverviewAC() throws InterruptedException, IOException
		{
			test = extent.startTest("Assigned Compliances - Overview button working or not?");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.OverviewAC(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 15)
		void ERview() throws InterruptedException, IOException
		{
			test = extent.startTest("'Expired Registrations' - Edit - Validate View button working or not?");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.ERview(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 16) //Bilal InitiateAction Pass 
		void InitiateAction() throws InterruptedException, IOException
		{
			test = extent.startTest("'Expired Registrations' - Edit - Validate InitiateAction Submit button working or not?");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.InitiateAction(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 23)
		void exportNotice() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("'Open Notices' - View - Export button working or not?");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.exportNotice(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		//Bilal Pass
		@Test(priority = 36) 
		void overviewECComplied() throws InterruptedException, IOException
		{
			test = extent.startTest("Compliance Performance Graph – Click on the complied count to verify if the 'Overview button' works correctly?");
			
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.overviewECComplied(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 55) 
		void RegistrationStatus() throws InterruptedException, IOException
		{
			test = extent.startTest("'Registration Status' - Active Count Verification");
			
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			
			All_ClientPortal_Methods.RegistrationStatus(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 61) //Bilal 5 Done
		void RegistrationActiveEditView() throws InterruptedException, IOException
		{
			test = extent.startTest("Registrations Status' - Active - Edit - View button is working or not?");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.RegistrationActiveEditView(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 62) //Bilal 
		void RegistrationActiveEditInitiateActionSubmit() throws InterruptedException, IOException
		{
			test = extent.startTest("Registrations Status' - Active - Edit - InitiateAction Submit button is working or not?");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.RegistrationActiveEditInitiateActionSubmit(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 75) //Bilal 12 Done
		void RegistrationStatusEditView() throws InterruptedException, IOException
		{
			test = extent.startTest("'Registration Status' - Expired - Edit - View button working or not?");
			
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			
			All_ClientPortal_Methods.RegistrationStatusEditView(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 99) //Bilal Done
		void RSG_ActiveEditView() throws InterruptedException, IOException
		{
			test = extent.startTest("'Registration Status' - Total Active Licences - Edit - View button working or not?");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.RSG_ActiveEditView(test);
			
			extent.endTest(test);
			extent.flush();
		}
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		@AfterMethod
	  	void browserClosing() throws InterruptedException
	  	{
			closeBrowser();
	  		//Thread.sleep(1000);
	  		//getDriver().close();
	  	}	       
	  		       		
	  	@AfterTest
	  	void Closing() throws InterruptedException
	  	{
	  		
	  	}	 

	
}
