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

import clientPortal.ClientPortalMethod;
import login.BasePage;

public class ClientPortalTestCase extends BasePage
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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\Client Portal Login.html",true);
		test = extent.startTest("Loging In - Client Portal");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,6,"Statutory");
	
	}
	
	@Test(priority =1)
   	void AddNewLicense() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Add New License Request");
   		
   		
   		ClientPortalMethod.AddNewLicense(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =2)
   	void ExportBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Export Button verification");
   		
   		
   		ClientPortalMethod.ExportBtn(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority =3)
   	void SearchBox() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Search Box verification");
   		
   		
   		ClientPortalMethod.SearchBox(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =4)
   	void EditIcon() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit Icon verification");
   		
   		
   		ClientPortalMethod.EditIcon(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority =5)
   	void ExsitingLicenseExport() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing license -Export Button verification");
   		
   		
   		ClientPortalMethod.ExistingLicsneExportBtn(test,workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority =6)
   	void SearchBoxExistiongLicense() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing Licenses -Search Box verification");
   		
   		
   		ClientPortalMethod.SearchBoxExistiongLicense(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =7)
   	void ExistingLicenseViewIcon() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing Licenses -View Icon verification");
   		
   		
   		ClientPortalMethod.ExistingLicenseViewIcon(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority =8)
   	void ExistingLicenseInitiateAction() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing Licenses -Initiate Action- SubActivity verification");
   		
   		
   		ClientPortalMethod.ExistingLicenseInitiateAction(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority =9)
   	void ExistingLicenseDownload() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing Licenses -Download Button verification");
   		
   		
   		ClientPortalMethod.ExistingLicenseDownload(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
//	@Test(priority =10)//Pending
  	void ExistingLicenseSubActivityViewandDownload() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing Licenses -click Entity tringle  -View and  Download Button verification");
   		
   		
   		ClientPortalMethod.ExistingLicenseSubActivityViewandDownload(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
////////////////////////Regitration Repository//////////////////////
	
	@Test(priority =11)
   	void RegisrationRespository() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration Repostory - View and  Download Button verification");
   		
   		
   		ClientPortalMethod.RegisrationRespository(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority =12)
   	void RegistrationRepositoryFilter() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration Repostory - Filter verification");
   		
   		
   		ClientPortalMethod.RegistrationRepositoryFilter(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority =13)
   	void RegistrationRepositoryExportBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration Repostory - Export button verification");
   		
   		
   		ClientPortalMethod.RegistrationRepositoryExportBtn(test,workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
   	
  //////////////////////////////Notices///////////////////////////////////
   	
 	@Test(priority =14)
   	void AddNewNotices() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Add New Notices verification");
   		
   		
   		ClientPortalMethod.AddNewNotices(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
 @Test(priority =15)
   	void ExistingNoticesNo() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices -Existing Notice No verification");
   		
   		
   		ClientPortalMethod.ExistingNoticesNo(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =16)
   	void NoticeDocMandatory() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices -Notice document manadatory or not verification");
   		
   		
   		ClientPortalMethod.NoticeDocMandatory(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
 	
	@Test(priority =17)
   	void NoticeExportBtn() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Export Button verification");
   		
   		
   		ClientPortalMethod.NoticeExportBtn(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}	
	@Test(priority =18)
   	void NoticeEditDownloadView() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit,Download and view verification");
   		
   		
   		ClientPortalMethod.NoticeEditDownloadView(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}	
@Test(priority =19)
   	void NoticeSearchBox() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices -Search Box and clear Button verification");
   		
   		
   		ClientPortalMethod.NoticeSearchBox(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}	

/////////////////////////Statutory document///////////////////////////

@Test(priority =20)
void StatutoryDocApplyClaerBtn() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Apply Button and clear Verification");
	
	
	ClientPortalMethod.StatutoryDocApplyClaerBtn(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =21)
void StatutoryDocFilter() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Filter Verification");
	
	
	ClientPortalMethod.StatutoryDocFilter(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =22)
void StateDocZipFile() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document- Registor Compliance Type -Action Column -Zip File Verification");
	
	
	ClientPortalMethod.StateDocZipFile(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =23)
void StatutoryDocViewandOverview() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Registor Compliance Type -Action Column -View button Verification");
	
	
	ClientPortalMethod.StatutoryDocViewandOverview(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =24)
void StatutoryDocBulkDownload() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Registor Compliance Type - download button Verification");
	
	
	ClientPortalMethod.StatutoryDocBulkDownload(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =25)
void ChallanDoc() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Challan Compliance Type - select checkbox -download button Verification");
	
	
	ClientPortalMethod.ChallanDoc(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =26)
void ChallanComplianceDoc() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Challan Compliance Type - compliance download button Verification");
	
	
	ClientPortalMethod.ChallanComplianceDoc(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =27)
void ChallanViewBranchese() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Challan Compliance Type -View branches Verification");
	
	
	ClientPortalMethod.ChallanViewBranches(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =28)
void ChallanViewWorkingFile() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Challan Compliance Type -View working file Verification");
	
	
	ClientPortalMethod.ChallanViewWorkingFile(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =29)
void ChallanViewComplianceFile() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Challan Compliance Type -View compliance file Verification");
	
	
	ClientPortalMethod.ChallanViewComplianceFile(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =30)
void ChallanDocBulkDownload() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Challan Compliance Type - working file download button Verification");
	
	
	ClientPortalMethod.ChallanDocBulkDownload(test);
	
	extent.endTest(test);
	extent.flush();

}


////////////////////////Master abstract////////////////////

@Test(priority =31)
void RegionalDocView() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Master Abstract-Regional view document Verification");
	
	
	ClientPortalMethod.RegionalDocView(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =32)
void RegionalDocDownload() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Master Abstract-Regional download document Verification");
	
	
	ClientPortalMethod.RegionalDocDownload(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =33)
void EnglishDocView() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Master Abstract-English view document Verification");
	
	
	ClientPortalMethod.EnglishDocView(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =34)
void EnglishDocDownload() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Master Abstract-English download document Verification");
	
	
	ClientPortalMethod.EnglishDocDownload(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =35)
void SearchBoxMasterAbstract() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Master Abstract-Search box  Verification");
	
	
	ClientPortalMethod.SearchBoxMasterAbstarct(test);
	
	extent.endTest(test);
	extent.flush();

}

@AfterMethod
void close()
{
  getDriver().close();
}

}
