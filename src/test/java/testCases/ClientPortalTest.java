package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import clientPortal.CPMethod;
import distributor.MethodsD;
import login.BasePage;

public class ClientPortalTest extends BasePage {
	
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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\ClientPortal.html",true);
		test = extent.startTest("Loging In - Client Portal");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,4,"Statutory");
	
	}
	
	
	//   @Test(priority = 1)
		void MultipleDocument() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest(" My Document - Multiple documnet Downloaded.");
			
			CPMethod.MultipleDocument(test);
			
			extent.endTest(test);
			extent.flush();
		}
	   
	//   @Test(priority = 1)
		void MultipleDocumentDownload() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest(" My Document - documnet Downloaded Verification");
			
			CPMethod.MyDocument(test);
			
			extent.endTest(test);
			extent.flush();
		}
	   
	//   @Test(priority = 1)
		void MyDocumentView() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest(" My Document - Documnet View Verification");
			
			CPMethod.MyDocumentView(test);
			
			extent.endTest(test);
			extent.flush();
		}
	   
	//	 @Test(priority = 0)
			void MyDocumentFilter() throws InterruptedException, IOException, AWTException
			{
				test = extent.startTest(" My Document - Multiple Filter Verification");
				
				CPMethod.MyDocumentFilter(test);
				
				extent.endTest(test);
				extent.flush();
			}
		//	@Test(priority = 1)
			void MyDocumentAllTab() throws InterruptedException, IOException, AWTException
			{
				test = extent.startTest(" My Document ");
				
				CPMethod.MyDocumentAllTab(test);
				
				extent.endTest(test);
				extent.flush();
			}
		
		//	@Test(priority = 1)
			void CriticalDocument() throws InterruptedException, IOException, AWTException
			{
				test = extent.startTest(" My Document - Critical Document ");
				
				CPMethod.CriticalDocument(test);
				
				extent.endTest(test);
				extent.flush();
			}
		//	@Test(priority = 1)
			void CriticalDocumentSubFolder() throws InterruptedException, IOException, AWTException
			{
				test = extent.startTest(" My Document - Sub folder Critical Document ");
				
				CPMethod.CriticalDocumentSubFolder(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
		//	@Test(priority = 0)
			void CriticalDocumentNewFile() throws InterruptedException, IOException, AWTException
			{
				test = extent.startTest(" Critical Document - Add New File ");
				
				CPMethod.CriticalDocumentNewFile(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
			@Test(priority = 0)
			void CriticalDocumentshare() throws InterruptedException, IOException, AWTException
			{
				test = extent.startTest(" Critical Document - Share ");
				
				CPMethod.CriticalDocumentshare(test);
				
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
