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

import coordinator.CoordinatorMethod;
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
		//Unhide if ask security questions!
	//	initializationSDExecutor(link,7,"Labour");
		
		//Hide if ask security questions!
		Initialization(link,7,"Labour");
		
		
//		String username = null;
//		login.LoginMethods.UserLoginSDExecutor(username,password,"SD Executor");
	
	}
	
               ////////Notices///////
	
	/////
	
	@Test(priority = 1) 
   	void CoordinatorLogo() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Verify the TeamLease RegTech logos are displayed after SD Executor login");
   		
   		Method.logoChecking(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 2) 
   	void ColumnExpandIcon() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Verify if the column expand/collapse icon functions correctly");
   		
   		Method.ColumnExpandIcon(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
@Test(priority = 3)
void CountMatch() throws InterruptedException, IOException
{
	test = extent.startTest("Notice- Translation Pending count verification");
	
	Method.CountMatch(test, "Extension");
	
	extent.endTest(test);
	extent.flush();

}
    @Test(priority = 4) 
	void translationPendingExport() throws InterruptedException, IOException
	{
		test = extent.startTest("Notices - Translation Pending - Verify Export button works correctly ");
		
		Method.tabsExport(test , "Translation Pending");
		
		extent.endTest(test);
		extent.flush();
	}

    @Test(priority = 5)
	void PendingAction() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice- Ext.Submission Pending count verification");
		
		Method.CountMatch(test, "Response Pending");
		
		extent.endTest(test);
		extent.flush();

	}

	@Test(priority = 6)
	void exSubmittionPendingExport() throws InterruptedException, IOException {
		test = extent.startTest("Notices - Ext Submittion Pending - Verify Export button works correctly ");

		Method.tabsExport(test, "Ext.Submission Pending");

		extent.endTest(test);
		extent.flush();
	}


@Test(priority = 7)
	void Overdue() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice- Submission Pending count verification");
		
		Method.CountMatch(test, "Overdue");
		
		extent.endTest(test);
		extent.flush();

	}	
    @Test(priority = 8)
	void submittionPendingExport() throws InterruptedException, IOException {
		test = extent.startTest("Notices - Submittion Pending - Verify Export button works correctly ");

		Method.tabsExport(test, "Submission Pending");

		extent.endTest(test);
		extent.flush();
	}


@Test(priority = 9)
	void Closed() throws InterruptedException, IOException
	{
		test = extent.startTest("Notice- Response Submitted count verification");
		
		Method.CountMatch(test, "Response Submitted");
		
		extent.endTest(test);
		extent.flush();

	}   
    @Test(priority = 10)
	void responseSubmittedExport() throws InterruptedException, IOException {
		test = extent.startTest("Notices - Response Submitted - Verify Export button works correctly ");

		Method.tabsExport(test, "Response Submitted");

		extent.endTest(test);
		extent.flush();
	}
@Test(priority = 11)
void NoticeExportBtn() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
{
	test = extent.startTest("Notices -Export Btn verification");
	
	
	Method.NoticeExportBtn(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 12)
void NoticeSearchBox() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
{
	test = extent.startTest("Notices -Search Box and clear button verification");
	
	Method.NoticeSearchBox(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 13)
void NoticeEditDownload() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
{
	test = extent.startTest("Notices -Edit and download button verification");
	
	
	Method.NoticeEditDownload(test);
	
	extent.endTest(test);
	extent.flush();

}    
     @Test(priority = 14)
     void translationReq() throws Exception
   {
		test = extent.startTest("Notices - Edit - Verify to check Translation Required label bar works correctly ");

		Method.translationReq(test);

		extent.endTest(test);
		extent.flush();

    }

	@Test(priority = 15)
	void extensionApplication() throws Exception {
		test = extent.startTest("Notices - Edit - Verify to check Extenstion Application label bar works correctly ");

		Method.extensionApplication(test);

		extent.endTest(test);
		extent.flush();

	}
	
	@Test(priority = 16)
	void noticeResponse() throws Exception {
		test = extent.startTest("Notices - Edit - Verify to check Notice Response label bar works correctly ");

		Method.noticeResponse(test);

		extent.endTest(test);
		extent.flush();

	}
	@Test(priority = 17)
   	void NoticeEditAllTabsCheck() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - Verify to check all tabs is displayed or not?");
   		
   		Method.NoticeEditAllTabsCheck(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 18)
   	void NoticeEditDocumentRepositoryDownloadCheck() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - Verify to download documents from document section");
   		
   		Method.documentSectionDownloads(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}

/////////////////////////////////Registration//////////////////////////////

    @Test(priority = 30)
	void RegistrationCountMatch() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration- Pending Applications (Offline) count verification");
		
		Method.RegistrationCountMatch(test, "Pending Assignment");
		
		extent.endTest(test);
		extent.flush();

	}
    @Test(priority = 31)
	void pendingApplicationExport() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration - Pending Applications (Offline) - Verify to check export works correctly");
		
		Method.registrationExportTabs(test, "Pending Assignment");
		
		extent.endTest(test);
		extent.flush();

	}
    @Test(priority = 32)
	void RegistrationPendingAction() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration- Applied and Awaiting Dept Approval count verification");
		
		Method.RegistrationCountMatch(test, "Pending Action");
		
		extent.endTest(test);
		extent.flush();

	}
    @Test(priority = 33)
	void appliedAndAwaitingExport() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration - Applied and Awaiting Dept Approval - Verify to check export works correctly");
		
		Method.registrationExportTabs(test, "Pending Action");
		
		extent.endTest(test);
		extent.flush();

	}
    @Test(priority = 34)
	void RegistrationOverdue() throws InterruptedException, IOException
	{ 
		test = extent.startTest("Registration- Overdue count verification");
		
		Method.RegistrationCountMatch(test, "Overdue");
		
		extent.endTest(test);
		extent.flush();

	}
    @Test(priority = 35)
	void overdueExport() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration - Overdue - Verify to check export works correctly");
		
		Method.registrationExportTabs(test, "Overdue");
		
		extent.endTest(test);
		extent.flush();

	}
    @Test(priority = 36)
	void RegistrationClosed() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration- Closed count verification");
		
		Method.RegistrationCountMatch(test, "Closed");
		
		extent.endTest(test);
		extent.flush();

	}
    @Test(priority = 37)
	void closedExport() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration - Closed - Verify to check export works correctly");
		
		Method.registrationExportTabs(test, "Closed");
		
		extent.endTest(test);
		extent.flush();

	}



	@Test(priority = 38)
	void ExportBtn() throws InterruptedException, IOException {
		test = extent.startTest("Registration - Verify to check Export button works correctly");

		Method.ExportBtn(test, workbook);

		extent.endTest(test);
		extent.flush();

	}
    @Test(priority = 39)
	void otaReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration - Verify to check OTA Report download works correctly");
		
		Method.registrationExportTabs(test, "OTA Report");
		
		extent.endTest(test);
		extent.flush();

	}
	
@Test(priority = 40)
	void SearchBox() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration - Search Box verification");
		
		Method.SearchBox(test);
		
		extent.endTest(test);
		extent.flush();

	}
	
	@Test(priority = 41)
   	void EditIcon() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit Icon verification");
   		
   		Method.EditIcon(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 42)
   	void editSubmittedToDept() throws Exception
   	{
   		test = extent.startTest("Registration - Edit - Verify to check Submitted to department section works correctly");
   		
   		Method.editSubmittedToDept(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 43)
   	void activityColsureLable() throws Exception
   	{
   		test = extent.startTest("Registration - Edit - Verify to check Activity Closure section works correctly");
   		
   		Method.activityColsureLable(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 44)
   	void registrationEditTabs() throws Exception
   	{
   		test = extent.startTest("Registration - Edit - Verify to check all tabs details displayed correctly ");
   		
   		Method.registrationEditTabs(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 45)
   	void registrationEditDocumentRepositiory() throws Exception
   	{
   		test = extent.startTest("Registration - Edit - Document Section - Verify to check Document Repository documents download correctly");
   		
   		Method.registrationEditDocumentRepositiory(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
// 	@Test(priority = 4)
   	void DeleteButton() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Delete Icon verification");
   		
   		
   		Method.DeleteButton(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
//	@Test(priority = 38)
   	void DeleteCancelButton() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Delete Icon -Cancel button verification");
   		
   		
   		Method.DeleteCancelButton(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 48)
   	void ExistingLicenseCountMatch() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration-Existing License- Pending Assignment count verification");
   		
   		Method.ExistingLicenseCountMatch(test, "Pending Assignment");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 49)
   	void ExistingLicenseendingAction() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration-Existing License- Pending Action count verification");
   		
   		Method.ExistingLicenseCountMatch(test, "Pending Action");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority = 50)
   	void ExistingLicenseOverdue() throws InterruptedException, IOException
   	{ 
   		test = extent.startTest("Registration- Existing License-Overdue count verification");
   		
   		Method.ExistingLicenseCountMatch(test, "Overdue");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 51)
   	void ExistingLicenseClosed() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration-Existing License- Closed count verification");
   		
   		Method.ExistingLicenseCountMatch(test, "Closed");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	@Test(priority = 52)
	void ExsitingLicenseExport() throws InterruptedException, IOException {
		test = extent.startTest("Registration - Existing License-Export Butoon verification");

		Method.ExistingLicsneExportBtn(test, workbook);

		extent.endTest(test);
		extent.flush();

	}

	@Test(priority = 53)
	void SearchBoxExistiongLicense() throws InterruptedException, IOException {
		test = extent.startTest("Registration - Existing Licenses -Search Box verification");

		Method.SearchBoxExistiongLicense(test);

		extent.endTest(test);
		extent.flush();

	}

	@Test(priority = 54)
	void ExistingLicenseViewIcon() throws InterruptedException, IOException {
		test = extent.startTest("Registration - Existing Licenses -view icon verification");

		Method.ExistingLicenseViewIcon(test);

		extent.endTest(test);
		extent.flush();

	}

	@Test(priority = 55)
	void ExistingLicenseDownload() throws InterruptedException, IOException {
		test = extent.startTest("Registration - Existing Licenses -Download Button verification");

		Method.ExistingLicenseDownload(test);

		extent.endTest(test);
		extent.flush();

	}
	
	
	//Swapnil's New TestCases for Statutory Document
	@Test(priority = 100)
	void StatutoryDocument() throws InterruptedException, IOException 
	{
		test = extent.startTest("Statutory Document - Statutory Documents verification");
		Method.StatutoryDocument(test);

		extent.endTest(test);
		extent.flush();

	}
	
	

	@AfterMethod
	void close()
	{
	  getDriver().close();
	}
}
