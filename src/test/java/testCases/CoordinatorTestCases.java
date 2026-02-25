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


public class CoordinatorTestCases extends BasePage
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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\Co-ordinator Login.html",true);
		test = extent.startTest("Loging In - Co-ordinator");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		Initialization(link,5,"Labour");
	
	}
	
	
	
	

	//---------------------Notice Module------------------	
	@Test(priority = 1) //Bilal
   	void CoordinatorLogo() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Verify the TeamLease RegTech logos are displayed after coordinator login");
   		
   		CoordinatorMethod.CoordinatorLogo(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 2) //Bilal
   	void ColumnExpandIcon() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Verify if the column expand/collapse icon functions correctly");
   		
   		CoordinatorMethod.ColumnExpandIcon(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	

	
	@Test(priority = 3) //Bilal
   	void Noticelinkbuttonworking() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Check whether the Notice Module link works correctly or not?");
   		
   		CoordinatorMethod.Noticelinkbuttonworking(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 4) //Bilal
   	void NoticelinkbuttonDashboard() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Check whether after clicking on notice dashboard will be displayed or not?");
   		
   		CoordinatorMethod.NoticelinkbuttonDashboard(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 5)
   	void CountMatch() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Notices - Pending Assignment count verification");
   		
   		CoordinatorMethod.CountMatch(test, "Pending Assignment");
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 6)
   	void PendingAssignmentExport() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Notices - Pending Assignment - Export button verification");
   		
   		CoordinatorMethod.BoxClickExportVerification(test, "Pending Assignment");
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	
	@Test(priority = 7)
   	void PendingAction() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Notices - Pending Action count verification");
   		
   		CoordinatorMethod.CountMatch(test, "Pending Action");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 8)
   	void PendingActionExport() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Notices - Pending Action - Export button verification");
   		
   		CoordinatorMethod.BoxClickExportVerification(test, "Pending Action");
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	
	@Test(priority = 9)
   	void Overdue() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Notices - Overdue count verification");
   		
   		CoordinatorMethod.CountMatch(test, "Overdue");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
//	@Test(priority = 10)
   	void OverdueExport() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Notices - Overdue - Export button verification");
   		
   		CoordinatorMethod.BoxClickExportVerification(test, "Overdue");
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 11)
   	void Closed() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Notices - Closed count verification");
   		
   		CoordinatorMethod.CountMatch(test, "Closed");
   		
   		extent.endTest(test);
   		extent.flush();

   	}  
	
//	@Test(priority = 12)
   	void ClosedExport() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Notices - Closed - Export button verification");
   		
   		CoordinatorMethod.BoxClickExportVerification(test, "Closed");
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 13)
   	void addNoticeVerification() throws Exception
   	{
   		test = extent.startTest("Notices - Add New - Verify to check add new notices are working correctly");
   		
   		CoordinatorMethod.addNoticeVerification(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
  	@Test(priority = 14)
   	void ExistingNotice() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Existing Notices No verification");
   		
   		CoordinatorMethod.ExistingNotice(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
  	
	@Test(priority = 15)
   	void NoticeDocMandatory() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Verify to check notice document mandatory or not?");
        
   		CoordinatorMethod.NoticeDocMandatory(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	} 
	
	@Test(priority = 15) //New
   	void NoticeDocumentsChecking() throws Exception
   	{
   		test = extent.startTest("Notices - Add New - Verify to check Receipt Acknowledgement Browse button is enabled or not ");
     	CoordinatorMethod.NoticeAddNewRecepitAcknowledgement("Doc File",test);
   		
		
   		test = extent.startTest("Notices - Add New - Receipt Acknowledgement - Verify to upload DOC file");
   		CoordinatorMethod.NoticeAddNewRecepitAcknowledgement_2("Doc File",test);
   		
   		test = extent.startTest("Notices - Add New - Receipt Acknowledgement - Verify to upload DOCX file");
   		CoordinatorMethod.NoticeAddNewRecepitAcknowledgement_2("DOCX File",test);
   		
   		test = extent.startTest("Notices - Add New - Receipt Acknowledgement - Verify to upload PDF file");
   		CoordinatorMethod.NoticeAddNewRecepitAcknowledgement_2("PDF File",test);
   		
   		
   		test = extent.startTest("Notices - Add New - Receipt Acknowledgement - Verify to check error with upload XLS file");
   		CoordinatorMethod.NoticeAddNewRecepitAcknowledgementValidation("Validation : XLS",test);
   		
   		test = extent.startTest("Notices - Add New - Receipt Acknowledgement - Verify to check error with upload {XLSX} file");
   		CoordinatorMethod.NoticeAddNewRecepitAcknowledgementValidation("Validation : XLSX",test);
   		
   		test = extent.startTest("Notices - Add New - Receipt Acknowledgement - Verify to check error with upload ZIP file");
   		CoordinatorMethod.NoticeAddNewRecepitAcknowledgementValidation("Validation : ZIP",test);
   		
   		test = extent.startTest("Notices - Add New - Receipt Acknowledgement - Verify to check error with upload TXT file");
   		CoordinatorMethod.NoticeAddNewRecepitAcknowledgementValidation("Validation : TXT",test);
   		
   		test = extent.startTest("Notices - Add New - Receipt Acknowledgement - Verify to check error with upload PNG file");
   		CoordinatorMethod.NoticeAddNewRecepitAcknowledgementValidation("Validation : PNG",test);
   		
   		test = extent.startTest("Notices - Add New - Receipt Acknowledgement - Verify to check error with upload JPEG file");
   		CoordinatorMethod.NoticeAddNewRecepitAcknowledgementValidation("Validation : JPEG",test);
   		
   		test = extent.startTest("Notices - Add New - Receipt Acknowledgement - Verify to check error with upload HTML file");
   		CoordinatorMethod.NoticeAddNewRecepitAcknowledgementValidation("Validation : HTML",test);
   		
   		
   		extent.endTest(test);
   		extent.flush();
   	}

	@Test(priority = 16) //New
   	void noticeDocumentBrowse() throws Exception
   	{
   		test = extent.startTest("Notices - Add New - Verify to check Notice Document Browse button is enabled or not");
   		CoordinatorMethod.noticeDocumentBrowse("Doc File",test);
   		
   		
   		test = extent.startTest("Notices - Add New - Notice Document - Verify to upload DOC file");
   		CoordinatorMethod.NoticeAddNewNoticeDocument_2("Doc File",test);
   		
   		test = extent.startTest("Notices - Add New - Notice Document - Verify to upload DOCX file");
   		CoordinatorMethod.NoticeAddNewNoticeDocument_2("DOCX File",test);
   		
   		test = extent.startTest("Notices - Add New - Notice Document - Verify to upload PDF file");
   		CoordinatorMethod.NoticeAddNewNoticeDocument_2("PDF File",test);
   		
   		
   		
   		test = extent.startTest("Notices - Add New - Notice Document - Verify to check error with upload XLS file");
   		CoordinatorMethod.noticeAddNewNoticeDocumentValidation("Validation : XLS",test);
   		
   		test = extent.startTest("Notices - Add New - Notice Document - Verify to check error with upload {XLSX} file");
   		CoordinatorMethod.noticeAddNewNoticeDocumentValidation("Validation : XLSX",test);
   		
   		test = extent.startTest("Notices - Add New - Notice Document - Verify to check error with upload ZIP file");
   		CoordinatorMethod.noticeAddNewNoticeDocumentValidation("Validation : ZIP",test);
   		
   		test = extent.startTest("Notices - Add New - Notice Document - Verify to check error with upload TXT file");
   		CoordinatorMethod.noticeAddNewNoticeDocumentValidation("Validation : TXT",test);
   		
   		test = extent.startTest("Notices - Add New - Notice Document - Verify to check error with upload PNG file");
   		CoordinatorMethod.noticeAddNewNoticeDocumentValidation("Validation : PNG",test);
   			
   		test = extent.startTest("Notices - Add New - Notice Document - Verify to check error with upload JPEG file");
   		CoordinatorMethod.noticeAddNewNoticeDocumentValidation("Validation : JPEG",test);
   		
   		test = extent.startTest("Notices - Add New - Notice Document - Verify to check error with upload HTML file");
   		CoordinatorMethod.noticeAddNewNoticeDocumentValidation("Validation : HTML",test);
   		
   		extent.endTest(test);
   		extent.flush();
   		
   	}
	
	
	
	
  	@Test(priority = 16)
   	void NoticeExportBtn() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Export button verification");
   		
   		CoordinatorMethod.NoticeExportBtn(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
  	//N
	@Test(priority = 17)
	void NoticeSearchBox() throws InterruptedException, IOException, EncryptedDocumentException, AWTException {
		test = extent.startTest("Notices - Verify to check Type to search field is works correctly with all inputs");

		CoordinatorMethod.noticesTypeToSearchWithMultiple(test);

		extent.endTest(test);
		extent.flush();

	}
   	
  	@Test(priority = 18)
   	void NoticeEditDownload() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices -Edit and download button verification");
   		
   		
   		CoordinatorMethod.NoticeEditDownload(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}

  	
// 	@Test(priority = 19) //Bilal Issue from Developers side (Did below in good way)
   	void NoticeEditBasicSave() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - Basic Information Save button");
   		
   		
   		CoordinatorMethod.NoticeEditBasicSave(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
   	
	@Test(priority = 19) //these 2 TC depens on each other
	void NoticeEditVerification() throws InterruptedException, IOException, EncryptedDocumentException, AWTException {
		test = extent.startTest("Notices - Edit - Verify to check Basic Information label bar works correctly");
		CoordinatorMethod.NoticeEditVerification(test);
		
		
		test = extent.startTest("Notices - Edit - Verify to check Additional Information to be updated by coordinator label bar works correctly");
		CoordinatorMethod.NoticeEditAdditionalInfo(test);

		extent.endTest(test);
		extent.flush();
	}
	//n
	
	@Test(priority = 20) 
	void relaventDate() throws InterruptedException, IOException, EncryptedDocumentException, AWTException {
		test = extent.startTest("Notices - Edit - Verify to check Relevant Dates label bar works correctly");
		CoordinatorMethod.relaventDate(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
//	@Test(priority = 20) //Bilal
   	void NoticeEditSaveWithoutAssign() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - Verify error message without selecting users");
   		
   		CoordinatorMethod.NoticeEditSaveWithoutAssign(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	
//	@Test(priority = 21) //Pending that is an issue
   	void NoticeEditSaveAssignUser() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - Verify error message without selecting users");
   		
   		CoordinatorMethod.NoticeEditSaveAssignUser(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 22) //Bilal
   	void NoticeEditAllTabsCheck() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - Verify to check all tabs is displayed or not?");
   		
   		CoordinatorMethod.NoticeEditAllTabsCheck(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	
	@Test(priority = 23) 
   	void translationReq() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - SME Response - Verify to check Translation Required label bar works correctly ");
   		
   		CoordinatorMethod.translationReq(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 24) 
   	void extensionApplication() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - SME Response - Verify to check Extension Application label bar works correctly ");
   		
   		CoordinatorMethod.extensionApplication(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 25) 
   	void noticeResponselabel() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - SME Response - Verify to check Notice Response label bar works correctly ");
   		
   		CoordinatorMethod.noticeResponselabel(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 26) 
   	void smeResposeBackButton() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - SME Response - Verify to check Back button works correctly");
   		
   		CoordinatorMethod.smeResposeBackButton(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 27) 
   	void sdExtTranslationReq() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - SD Executor - Verify to check Translation Required label bar works correctly");
   		
   		CoordinatorMethod.sdExtTranslationReq(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 28) 
   	void sdExtExtensionApplication() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - SD Executor - Verify to check Extension Application label bar works correctly");
   		
   		CoordinatorMethod.sdExtExtensionApplication(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 29) 
   	void sdExtNoticeResponse() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - SD Executor - Verify to check Notice Response label bar works correctly");
   		
   		CoordinatorMethod.sdExtNoticeResponse(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 30) 
   	void sdExecutorBackButton() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - SD Executor - Verify to check Back button works correctly");
   		
   		CoordinatorMethod.sdExecutorBackButton(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 31) //5 TC
   	void NoticeEditDocumentRepositoryDownloadCheck() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - Verify to download documents from document section");
   		
   		CoordinatorMethod.NoticeEditDocumentRepositoryDownloadCheck(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 32) //NEW TC NEW TC
   	void doSectionDocReq() throws Exception
   	{
   		test = extent.startTest("Notices - Edit - Verify to check Document Requirements for the Notice works correctly");
   		
   		CoordinatorMethod.doSectionDocReq(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 33)
   	void docReqNoticeLabel() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - Verify to check Document Requirement for the Notice label bar works correctly ");
   		
   		CoordinatorMethod.docReqNoticeLabel(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 34) 
   	void docSectionBackButton() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit - Document Section - Verify to check Back button works correctly");
   		
   		CoordinatorMethod.docSectionBackButton(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
  	

	
	
   //-------------------------Registration Module-------------------
	
	@Test(priority = 50)
   	void RegistrationCountMatch() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Pending Assignment count verification");
   		
   		CoordinatorMethod.RegistrationCountMatch(test, "Pending Assignment");
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 51)
   	void RegistrationPendingAssignmentExport() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Pending Assignment tab - Export button count verification");
   		
   		CoordinatorMethod.RegistrationTabsExport(test, "Pending Assignment");
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 52)
   	void RegistrationPendingAction() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration- Pending Action count verification");
   		
   		CoordinatorMethod.RegistrationCountMatch(test, "Pending Action");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 53)
   	void RegistrationPendingActionExport() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Pending Action tab - Export button count verification");
   		
   		CoordinatorMethod.RegistrationTabsExport(test, "Pending Action");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 54)
   	void RegistrationOverdue() throws InterruptedException, IOException
   	{ 
   		test = extent.startTest("Registration- Overdue count verification");
   		
   		CoordinatorMethod.RegistrationCountMatch(test, "Overdue");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 55)
   	void RegistrationOverdueExport() throws InterruptedException, IOException
   	{ 
   		test = extent.startTest("Registration - Overdue tab - Export button count verification");
   		
   		CoordinatorMethod.RegistrationTabsExport(test, "Overdue");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	
	@Test(priority = 56)
   	void RegistrationClosed() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration- Closed count verification");
   		
   		CoordinatorMethod.RegistrationCountMatch(test, "Closed");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 57)
   	void RegistrationClosedExport() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Closed tab - Export button count verification");
   		
   		CoordinatorMethod.RegistrationTabsExport(test, "Closed");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 58)
   	void SearchBox() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Search box and Clear button verification");
   		
   		CoordinatorMethod.SearchBox(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
     @Test(priority = 59)
   	void AddNewLicense() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Add New License Request for Assigning RCP Team login");
   		
   		CoordinatorMethod.AddNewLicense(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
 
 //@Test(priority = 60) // Bilal T
	void AddNewLicenseForSDExecutor() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration - Add New License Request for Assigning SD Executor Team login");
		
		CoordinatorMethod.AddNewLicenseForSDExecutor(test, workbook);
		
		extent.endTest(test);
		extent.flush();
	}
    @Test(priority = 61)
  	void RegistrationAddNewBackButton() throws InterruptedException, IOException
  	{
  		test = extent.startTest("Registration - Add New - Verify to check back button is working or not?");
  		
  		CoordinatorMethod.RegistrationAddNewBackButton(test, workbook);
  		
  		extent.endTest(test);
  		extent.flush();
  	}
	
 
	@Test(priority = 62)
   	void ExportBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Export Button verification");
   		
   		CoordinatorMethod.ExportBtn(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}

	
	
 	@Test(priority = 63)
   	void EditIcon() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit Icon verification");
   		
   		CoordinatorMethod.EditIcon(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
 	@Test(priority = 64) //Bilal
   	void EditIconMiniTabsLicense() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit - Verify to check License Request Mini Tabs will opened and closed");
   		
   		CoordinatorMethod.EditIconMiniTabsLicense(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
 	
	@Test(priority = 65) //Non Critical
   	void RegistrationEditBasicInfo_DisabledFields() throws InterruptedException, IOException
   	{
		//1: RCP Field
   		test = extent.startTest("Registration - Edit - Basic Information - Verify to check RCP No field is disabled or not");
   		CoordinatorMethod.RegistrationEditBasicInfo_DisabledFields("Go To Basic Info",test);
   		CoordinatorMethod.RegistrationEditBasicInfo_DisabledFields("RCP Number",test);
   		
   		//2: Client ID Drop-down
   		test = extent.startTest("Registration - Edit - Basic Information - Verify to check Client ID dropdown is disabled or not");
   		CoordinatorMethod.RegistrationEditBasicInfo_DisabledFields("Client ID",test);
   		
   		//3: Client Name Field
   		test = extent.startTest("Registration - Edit - Basic Information - Verify to check Client Name field is disabled or not");
   		CoordinatorMethod.RegistrationEditBasicInfo_DisabledFields("Client Name",test);
   		
   		//4: State Drop-down
   		test = extent.startTest("Registration - Edit - Basic Information - Verify to check State dropdown is disabled or not");
   		CoordinatorMethod.RegistrationEditBasicInfo_DisabledFields("State--Dropdown",test);
   		
   		//5: Location Field
   		test = extent.startTest("Registration - Edit - Basic Information - Verify to check Location field is disabled or not");
   		CoordinatorMethod.RegistrationEditBasicInfo_DisabledFields("Location--Field",test);
   		
   		//6: Branch Field
   		test = extent.startTest("Registration - Edit - Basic Information - Verify to check Branch field is disabled or not");
   		CoordinatorMethod.RegistrationEditBasicInfo_DisabledFields("Branch--Field",test);
   		
   		//7: Address Field
   		test = extent.startTest("Registration - Edit - Basic Information - Verify to check Address field is disabled or not");
   		CoordinatorMethod.RegistrationEditBasicInfo_DisabledFields("Address--Field",test);
   		
   		//8: License Type
   		test = extent.startTest("Registration - Edit - Basic Information - Verify to check License field is disabled or not");
   		CoordinatorMethod.RegistrationEditBasicInfo_DisabledFields("License--Field",test);
   		
   		//9: Activity dropdown
   		test = extent.startTest("Registration - Edit - Basic Information - Verify to check Activity dropdown is disabled or not");
   		CoordinatorMethod.RegistrationEditBasicInfo_DisabledFields("Activity--Dropdown",test);
   		
   		//10: 
   		test = extent.startTest("Registration - Edit - Basic Information - Verify to check License type dropdown is disabled or not");
   		CoordinatorMethod.RegistrationEditBasicInfo_DisabledFields("LicenseType--Dropdown",test);
   		
   		
   		extent.endTest(test);
   		extent.flush();
   	}
 	
 	
 	@Test(priority = 66) //Bilal
   	void EditIconBasicInfoSave() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit - Verify to click Save button in basic information tab.");
   		CoordinatorMethod.EditIconBasicInfoSave(test);
   		
//   		test = extent.startTest("Registration - Edit - Verify Finance Approval and OT Assignment on clicking on save button");
//   		CoordinatorMethod.EditIconFinanceApprovalSaveCheck(test);
   		
//   		test = extent.startTest("Registration - Edit - Verify to check OT Assignment is working or not");
//   		CoordinatorMethod.EditIconOTAssignment(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
 	
 	@Test(priority = 67) //Bilal
   	void EditIconActRelevantDatesLabelBar() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit - Verify to check Activity Relevant Dates label bar is working properly or not");
   		
   		CoordinatorMethod.EditIconActRelevantDatesLabelBar(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
 	
 	@Test(priority = 68) //Bilal
   	void EditIconBackButton() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit - Verify to check License Request Details Back button is working or not?");
   		
   		CoordinatorMethod.EditIconBackButton(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
 	
 	
 	//That below both test case need to merge OT Assignment not happening
//	@Test(priority = 69) //Bilal
   	void EditIconFinanceApprovalSave() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit - Verify Finance Approval and OT Assignment on clicking on save button");
   		
   		CoordinatorMethod.EditIconFinanceApprovalSave(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
 	
 //	@Test(priority = 70) //Bilal //No need for this test case covered that TC in above TC
   	void EditIconOTAssignmentSave() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit - Verify Finance Approval on clicking on save");
   		
   		CoordinatorMethod.EditIconOTAssignmentSave(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
   	
 	
 	
 	
 	@Test(priority = 71) //Bilal
   	void EditIconOtherTabsView() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit - Verify to View RCP Team , SD Executor and Document Section tabs");
   		
   		CoordinatorMethod.EditIconOtherTabsView(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
 	
	@Test(priority = 72) //NEW TC NEW TC
   	void EditDocReqOTActivity() throws Exception
   	{
   		test = extent.startTest("Registration - Edit - Verification of Document Requirements for the OT Activity works correctly");
   		
   		CoordinatorMethod.EditDocReqOTActivity(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
 	
 	//Sometimes running sometimes not
	@Test(priority = 73) //Bilal   Pending Tried with all clicks but now working
   	void EditIconDocumentRepoDownload() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit - Verify to download documents from document repository.");
   		
   		CoordinatorMethod.EditIconDocumentRepoDownload(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
 	
 	
 	
 	
//	@Test(priority = 73) Functionality is removed
   	void DeleteButton() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Delete Icon verification");
   		
   		
   		CoordinatorMethod.DeleteButton(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
//   @Test(priority = 74) Functionality is removed
   	void DeleteCancelButton() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Delete Icon -Cancel button verification");
   		
   		CoordinatorMethod.DeleteCancelButton(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}

//Need to check with sir if they said yes then need to add pagination test cases as well
//    @Test(priority = 47)
	void RegistrationPaginationNextAndPrevious() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration - Verify Pagination - Go To Next Page button");
		
		CoordinatorMethod.RegistrationPaginationNextAndPrevious(test);
		
		extent.endTest(test);
		extent.flush();

	}




@Test(priority = 76)
   	void ExistingLicenseCountMatch() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration-Existing License- Pending Assignment count verification");
   		
   		CoordinatorMethod.ExistingLicenseCountMatch(test, "Pending Assignment");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	@Test(priority = 77) 	// NEW TC BY SWAPNIL
	void ExistingLicenseDraftRCPcountMatch() throws InterruptedException, IOException
	{
		test = extent.startTest("Registration - Existing License - Draft RCP  verification");
		CoordinatorMethod.ExistingLicenseDraftRCPcountMatch(test, "Draft RCP");
		
		extent.endTest(test);
		extent.flush();
	}




	@Test(priority = 77)
   	void ExistingLicenseendingAction() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration-Existing License- Pending Action count verification");
   		
   		CoordinatorMethod.ExistingLicenseCountMatch(test, "Pending Action");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority = 78)
   	void ExistingLicenseOverdue() throws InterruptedException, IOException
   	{ 
   		test = extent.startTest("Registration- Existing License-Overdue count verification");
   		
   		CoordinatorMethod.ExistingLicenseCountMatch(test, "Overdue");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 79)
   	void ExistingLicenseClosed() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration-Existing License- Closed count verification");
   		
   		CoordinatorMethod.ExistingLicenseCountMatch(test, "Closed");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 80)
   	void ExsitingLicenseExport() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing License-Export Butoon verification");
   		
   		CoordinatorMethod.ExistingLicsneExportBtn(test,workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority = 81) //Bilal Search and Clear 
   	void SearchBoxExistiongLicense() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing Licenses -Search Box verification");
   		
   		
   		CoordinatorMethod.SearchBoxExistiongLicense(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}

	@Test(priority = 82) // Bilal
	void ExistingLicenseViewIcon() throws InterruptedException, IOException {
		test = extent.startTest("Registration - Existing Licenses - view icon verification");

		CoordinatorMethod.ExistingLicenseViewIcon(test);

		extent.endTest(test);
		extent.flush();

	}

	@Test(priority = 83)
	void ExistingLicenseInitiateAction() throws InterruptedException, IOException, AWTException {
		test = extent.startTest("Registration - Existing Licenses -Initiate Action- SubActivity verification");

		CoordinatorMethod.ExistingLicenseInitiateAction(test);

		extent.endTest(test);
		extent.flush();

	}

	@Test(priority = 84)
	void ExistingLicenseDownload() throws InterruptedException, IOException {
		test = extent.startTest("Registration - Existing Licenses -Download Button verification");

		CoordinatorMethod.ExistingLicenseDownload(test);

		extent.endTest(test);
		extent.flush();

	}

	// Statutory Documents
		@Test(priority = 100)	// NEW TC BY SWAPNIL
		void StatutoryDocument() throws InterruptedException, IOException
		{
			test = extent.startTest("Statutory Document - Filters and downloads verification");
			CoordinatorMethod.StatutoryDoc(test);

			extent.endTest(test);
			extent.flush();

		} 






	@AfterMethod
	void close() throws InterruptedException
	{
		Thread.sleep(10000);
	  getDriver().close();
	}
}
