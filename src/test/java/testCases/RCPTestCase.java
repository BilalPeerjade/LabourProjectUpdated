package testCases;

import java.io.FileInputStream;
import java.io.IOException;

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
import rcp.RCPMethod;





public class RCPTestCase extends  BasePage
{

		public static WebElement upload = null;		//WebElement to get upload button
		public static ExtentReports extent;			//Instance created for report file
		public static ExtentTest test;				//Instance created for tests
		public static FileInputStream fis = null;	//File input stream variable
		public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
		public static XSSFSheet sheet = null;		//Sheet variable
		
		public static String link = "mgmt1";  



	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\RCPLogin.html",true);
		test = extent.startTest("Logging In - RCP");
		test.log(LogStatus.PASS, "Logging into system");
	
		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,8,"Labour");
	
	}

	
	
	
	
	
	
	
	
	
	
	
		/////////////////////////////////Registration//////////////////////////////

	@Test(priority =1)
	void RCPLogo() throws InterruptedException, IOException
	{
	test = extent.startTest("Registration- Pending Applications (Online) count verification");
	
	RCPMethod.RCPLogo(test, "Pending Assignment");
	
	extent.endTest(test);
	extent.flush();
	
	}
	@Test(priority = 2)
	void RCPcolumnExpandIcon() throws InterruptedException, IOException
	{
	test = extent.startTest("Verify if the column expand/collapse icon functions correctly");
	
	RCPMethod.RCPcolumnExpandIcon(test, "Pending Assignment");
	
	extent.endTest(test);
	extent.flush();
	
	}
	
	
	
	    
	
		@Test(priority = 3)
		void RegistrationCountMatch() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration- Pending Applications (Online) count verification");
		
		RCPMethod.RegistrationCountMatch(test, "Pending Assignment");
		
		extent.endTest(test);
		extent.flush();
		
		}
		
		@Test(priority = 4)
		void RegistrationPendingApplicationExport() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration- Pending Applications (Online) box Export button verification");
		
		RCPMethod.RegistrationPendingApplicationExport(test, workbook);
		
		extent.endTest(test);
		extent.flush();
		
		}
		
		
		
		
		@Test(priority = 5)
		void RegistrationPendingAction() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration - Applied and Awaiting Dept Approval count verification");
		
		RCPMethod.RegistrationCountMatch(test, "Pending Action");
		
		extent.endTest(test);
		extent.flush();
		
		}
		
		@Test(priority = 6) //Bilal
		void RegistrationAppliedAwatingDeptExport() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration - Applied and Awaiting Dept Approval box Export count verification");
		
		RCPMethod.RegistrationAppliedAwatingDeptExport(test, workbook);
		
		extent.endTest(test);
		extent.flush();
		
		}
		
		
		@Test(priority = 7)
		void RegistrationOverdue() throws InterruptedException, IOException
		{ 
		test = extent.startTest("Registration- Overdue count verification");
		
		RCPMethod.RegistrationCountMatch(test, "Overdue");
		
		extent.endTest(test);
		extent.flush();
		
		}
		@Test(priority = 8) //Bilal
		void RegistrationOverdueExport() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration - Overdue box Export count verification");
		
		RCPMethod.RegistrationOverdueExport(test, workbook);
		
		extent.endTest(test);
		extent.flush();
		
		}
		
		@Test(priority = 9)
		void RegistrationClosed() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration- Closed count verification");
		
		RCPMethod.RegistrationCountMatch(test, "Closed");
		
		extent.endTest(test);
		extent.flush();
		
		}
		@Test(priority = 10) //Bilal
		void RegistrationClosedExport() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration - Closed box Export count verification");
		
		RCPMethod.RegistrationClosedExport(test, workbook);
		
		extent.endTest(test);
		extent.flush();
		
		}
		
		
		@Test(priority = 11)
		void ExportBtn() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration - RCP Dashboard Page Export Button verification");
		
		
		RCPMethod.ExportBtn(test, workbook);
		
		extent.endTest(test);
		extent.flush();
		
		
		}
		@Test(priority = 12)
		void SearchBox() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration - Search Box verification");
		
		
		RCPMethod.SearchBox(test);
		
		extent.endTest(test);
		extent.flush();
		
		}
		
		@Test(priority = 13)
		void EditIcon() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration - Edit Icon verification");
		
		
		RCPMethod.EditIcon(test);
		
		extent.endTest(test);
		extent.flush();
		
		}
//		@Test(priority = 14) Hide this due Req is like need to remove delete option from front end 
		void DeleteButton() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration - Delete Icon verification");
		
		RCPMethod.DeleteButton(test);
		
		extent.endTest(test);
		extent.flush();
		
		}
//		@Test(priority = 15) hide this due to we are removing delete option from front end
		void DeleteCancelButton() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration - Delete Icon -Cancel button verification");
		
		
		RCPMethod.DeleteCancelButton(test);
		
		extent.endTest(test);
		extent.flush();
		
		}
		@Test(priority = 16)
		void ExistingLicenseCountMatch() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration-Existing License- Pending Assignment(Online) count verification");
		
		RCPMethod.ExistingLicenseCountMatch(test, "Pending Assignment");
		
		extent.endTest(test);
		extent.flush();
		
		}
		@Test(priority = 17)
		void ExistingLicenseendingAction() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration-Existing License- Applied and Awaiting Dept Approval count verification");
		
		RCPMethod.ExistingLicenseCountMatch(test, "Pending Action");
		
		extent.endTest(test);
		extent.flush();
		
		}
		@Test(priority = 18)
		void ExistingLicenseOverdue() throws InterruptedException, IOException
		{ 
		test = extent.startTest("Registration- Existing License-Overdue count verification");
		
		RCPMethod.ExistingLicenseCountMatch(test, "Overdue");
		
		extent.endTest(test);
		extent.flush();
		
		}
		@Test(priority = 19)
		void ExistingLicenseClosed() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration-Existing License- Closed count verification");
		
		RCPMethod.ExistingLicenseCountMatch(test, "Closed");
		
		extent.endTest(test);
		extent.flush();
		
		}
		
		@Test(priority = 20)
		void ExsitingLicenseExport() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration - Existing License-Export Butoon verification");
		
		
		RCPMethod.ExistingLicsneExportBtn(test,workbook);
		
		extent.endTest(test);
		extent.flush();
		
		}
		@Test(priority = 21)
		void SearchBoxExistiongLicense() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration - Existing Licenses -Search Box verification");
		
		
		RCPMethod.SearchBoxExistiongLicense(test);
		
		extent.endTest(test);
		extent.flush();
		
		}
		@Test(priority = 22)
		void ExistingLicenseViewIcon() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration - Existing Licenses -view icon verification");
		
		RCPMethod.ExistingLicenseViewIcon(test);
		
		extent.endTest(test);
		extent.flush();
		}
		
		@Test(priority = 23)
		void ExistingLicenseDownload() throws InterruptedException, IOException
		{
		test = extent.startTest("Registration - Existing Licenses - Download Button verification");
		
		RCPMethod.ExistingLicenseDownload(test);
		
		extent.endTest(test);
		extent.flush();
		
		}
		
		
		
		
		@AfterMethod
		void close() throws InterruptedException
		{
			Thread.sleep(6000);
			
		getDriver().close();
		}

}
