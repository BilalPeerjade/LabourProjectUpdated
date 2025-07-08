package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import login.BasePage;
import sme.Methods;

public class SMETestCase extends BasePage
{

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
	
	
	public static String link = "mgmt1";  
	

	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\SME Login.html",true);
		test = extent.startTest("Loging In - SME-Executor");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,9,"Labour");
	
	}
	
////////Notices///////////////////////////////////
	
@Test(priority =1)
	void CountMatch() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice- Extension count verification");
		
		Methods.CountMatch(test, "Extension");
		
		extent.endTest(test);
		extent.flush();

	}
@Test(priority =2)
	void PendingAction() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice- Response Pending count verification");
		
		Methods.CountMatch(test, "Response Pending");
		
		extent.endTest(test);
		extent.flush();

	}
    @Test(priority = 3)
	void Overdue() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice- Overdue count verification");
		
		Methods.CountMatch(test, "Overdue");
		
		extent.endTest(test);
		extent.flush();

	}
@Test(priority =4)
	void Closed() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice- Response Submitted count verification");
		
		Methods.CountMatch(test, "Response Submitted");
		
		extent.endTest(test);
		extent.flush();

	}
@Test(priority =5)
	void NoticeExportBtn() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
	{
		test = extent.startTest("Notices -Export Btn verification");
		
		
		Methods.NoticeExportBtn(test);
		
		extent.endTest(test);
		extent.flush();

	}
@Test(priority =6)
	void NoticeSearchBox() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
	{
		test = extent.startTest("Notices -Search Box and clear button verification");
		
		
		Methods.NoticeSearchBox(test);
		
		extent.endTest(test);
		extent.flush();

	}
@Test(priority =7)
	void NoticeEditDownload() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
	{
		test = extent.startTest("Notices -Edit and download button verification");
		
		
		Methods.NoticeEditDownload(test);
		
		extent.endTest(test);
		extent.flush();

	}

@AfterMethod
void close()
{
  getDriver().close();
}
}
