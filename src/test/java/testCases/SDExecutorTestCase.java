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
import login.LoginMethods;
import sdexecutor.Method;


public class SDExecutorTestCase extends BasePage
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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\SD-Executor Login.html",true);
		test = extent.startTest("Logging In - SD-Executor");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initializationSDExecutor(link,7,"Labour");
//		String username = null;
//		login.LoginMethods.UserLoginSDExecutor(username,password,"SD Executor");
	
	}
	
               ////////Notices///////
	
@Test(priority = 1)
void CountMatch() throws InterruptedException, IOException
{
	test = extent.startTest("Notice- Translation Pending count verification");
	
	Method.CountMatch(test, "Extension");
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 2)
	void PendingAction() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice- Ext.Submission Pending count verification");
		
		Method.CountMatch(test, "Response Pending");
		
		extent.endTest(test);
		extent.flush();

	}
@Test(priority = 3)
	void Overdue() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice- Submission Pending count verification");
		
		Method.CountMatch(test, "Overdue");
		
		extent.endTest(test);
		extent.flush();

	}
@Test(priority = 4)
	void Closed() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice- Response Submitted count verification");
		
		Method.CountMatch(test, "Response Submitted");
		
		extent.endTest(test);
		extent.flush();

	}
@Test(priority = 5)
void NoticeExportBtn() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
{
	test = extent.startTest("Notices -Export Btn verification");
	
	
	Method.NoticeExportBtn(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 6)
void NoticeSearchBox() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
{
	test = extent.startTest("Notices -Search Box and clear button verification");
	
	Method.NoticeSearchBox(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 7)
void NoticeEditDownload() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
{
	test = extent.startTest("Notices -Edit and download button verification");
	
	
	Method.NoticeEditDownload(test);
	
	extent.endTest(test);
	extent.flush();

}

/////////////////////////////////Registration//////////////////////////////

    @Test(priority = 8)
	void RegistrationCountMatch() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration- Pending Applications (Offline) count verification");
		
		Method.RegistrationCountMatch(test, "Pending Assignment");
		
		extent.endTest(test);
		extent.flush();

	}
    @Test(priority = 9)
	void RegistrationPendingAction() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration- Applied and Awaiting Dept Approval count verification");
		
		Method.RegistrationCountMatch(test, "Pending Action");
		
		extent.endTest(test);
		extent.flush();

	}
    @Test(priority = 10)
	void RegistrationOverdue() throws InterruptedException, IOException
	{ 
		test = extent.startTest("Registration- Overdue count verification");
		
		Method.RegistrationCountMatch(test, "Overdue");
		
		extent.endTest(test);
		extent.flush();

	}
@Test(priority =11)
	void RegistrationClosed() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration- Closed count verification");
		
		Method.RegistrationCountMatch(test, "Closed");
		
		extent.endTest(test);
		extent.flush();

	}

@Test(priority =12)
	void ExportBtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration - Export Button verification");
		
		
		Method.ExportBtn(test, workbook);
		
		extent.endTest(test);
		extent.flush();


	}
@Test(priority =13)
	void SearchBox() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration - Search Box verification");
		
		Method.SearchBox(test);
		
		extent.endTest(test);
		extent.flush();

	}
	
	@Test(priority = 14)
   	void EditIcon() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit Icon verification");
   		
   		Method.EditIcon(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
// 	@Test(priority =15)
   	void DeleteButton() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Delete Icon verification");
   		
   		
   		Method.DeleteButton(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
//	@Test(priority =16)
   	void DeleteCancelButton() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Delete Icon -Cancel button verification");
   		
   		
   		Method.DeleteCancelButton(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =21)
   	void ExistingLicenseCountMatch() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration-Existing License- Pending Assignment count verification");
   		
   		Method.ExistingLicenseCountMatch(test, "Pending Assignment");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =22)
   	void ExistingLicenseendingAction() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration-Existing License- Pending Action count verification");
   		
   		Method.ExistingLicenseCountMatch(test, "Pending Action");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority =23)
   	void ExistingLicenseOverdue() throws InterruptedException, IOException
   	{ 
   		test = extent.startTest("Registration- Existing License-Overdue count verification");
   		
   		Method.ExistingLicenseCountMatch(test, "Overdue");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =24)
   	void ExistingLicenseClosed() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration-Existing License- Closed count verification");
   		
   		Method.ExistingLicenseCountMatch(test, "Closed");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	@Test(priority =25)
   	void ExsitingLicenseExport() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing License-Export Butoon verification");
   		
   		
   		Method.ExistingLicsneExportBtn(test,workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority =26)
   	void SearchBoxExistiongLicense() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing Licenses -Search Box verification");
   		
   		
   		Method.SearchBoxExistiongLicense(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority = 27)
   	void ExistingLicenseViewIcon() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing Licenses -view icon verification");
   		
   		Method.ExistingLicenseViewIcon(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}

@Test(priority =28)
   	void ExistingLicenseDownload() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing Licenses -Download Button verification");
   		
   		
   		Method.ExistingLicenseDownload(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}

	@AfterMethod
	void close()
	{
	  getDriver().close();
	}
}
