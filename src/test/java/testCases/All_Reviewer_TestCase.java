package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

import distributor.Methods;
import distributor.MethodsD;
import login.BasePage;
import login.LoginLocators;
import performer.PerformerMethod;
import rcp.ChangePassMethod;
import reviewer.ReviewerMethod;


public class All_Reviewer_TestCase extends BasePage {

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
			extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\ReviewerAll.html",true);
			test = extent.startTest("Loging In - Reviewer");
			test.log(LogStatus.PASS, "Logging into system");

			extent.endTest(test);
			extent.flush();
		}
		
		@BeforeMethod
		void Login() throws InterruptedException, IOException
		{
			initialization(link,2,"Statutory");
		
		}
		
		@Test(priority = 1) //Bilal
		void CompanyLogo() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify to check after performer login TeamLease RegTech Logo is displayed or not?");
			
			MethodsD.CompanyLogo(test,"Performer"); //Same for performer
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 2) //Bilal
		void Logout() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify Logout link is working or not");
			
			MethodsD.Logout(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 3) //Bilal
		void ChangePassWithInvalidCurrentPass() throws InterruptedException, IOException
		{
			test = extent.startTest("Change Password - Verify to change password with invalid scenarios");
				
			ChangePassMethod.ChangePassWithInvalidCurrentPass(test,"Reviewer");
				
			extent.endTest(test);
			extent.flush();
		}	
		@Test(priority = 4) //Bilal
		void ChangePass() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify to check user is redirecting to Entity Page or not on clicking to 'Click here to go back' link");
			
			MethodsD.ChangePass(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 5) //Bilal
		void EntitiesSearch() throws InterruptedException, IOException
		{
			test = extent.startTest("Entities - Verify to Entity Serach field is working fine");
			
			MethodsD.EntitiesSearch(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		//NEED TO ADD HERE CORPORATE TEST CASES---
		
		@Test(priority = 10) //Bilal
		void EntityExcelDownload() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify to check Entity Locations & Entity Files are downloading or not?");
			
			MethodsD.EntityExcelDownload(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 11)//Bilal
		void PortalLogin() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify to check user is redirecting to client pottal or not through portal login");
			
			MethodsD.PortalLogin(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
	//Dashboard Test Cases:--- (NOTE: need to write and add Filter verification test cases) alternative sequence wise
		
		@Test(priority = 20)
		void ComplianceBox() throws InterruptedException, IOException
		{
			test = extent.startTest("Count by Clicking on 'Compliance'");
				
			MethodsD.complianceBox(test,"Reviewer");
				
			extent.endTest(test);
			extent.flush();
		}

	
		
		@Test(priority = 22)
		void UpcomingBox() throws InterruptedException, IOException
		{
			test = extent.startTest("Count by Clicking on 'Upcoming'");
			
			MethodsD.UpcomingBox(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 24)
		void OverdueBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Overdue'");
			
			MethodsD.OverdueBox(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		@Test(priority = 26)
		void PendingActionBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Pending Action'");
			
			MethodsD.PendingActionBox(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		@Test(priority = 28)
		void PendingReviewBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Pending Review'");
			
			MethodsD.PendingReviewBox(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		@Test(priority = 31)
		void RegisterUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Register - 'Upcoming'");
			
			MethodsD.RegisterUpcoming(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 33)
		void RegisterOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Register - 'Overdue'");
			
			MethodsD.RegisterOverdue(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 35) 
		void RegisterActionReview() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Register - 'Action/Review'");
			
			MethodsD.RegisterActionReview(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 37)
		void ReturnUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Returns - 'Upcoming'");
			
			MethodsD.ReturnUpcoming(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 39)
		void ReturnOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Returns - 'Overdue'");
			
			MethodsD.ReturnOverdue(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 41)
		void ReturnActionReview() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Returns - 'Action/Review'");
			
			MethodsD.ReturnActionReview(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 43)
		void ChallanUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Challans - 'Upcoming'");
			
			MethodsD.ChallanUpcoming(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 45)
		void ChallanOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Challans - 'Overdue'");
			
			MethodsD.ChallanOverdue(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 47)
		void ChallanActionReview() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Challans - 'Action/Review'");
			
			MethodsD.ChallanActionReview(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		
		
		
		
		//Manage Masters ----
		@Test(priority = 70) //Bilal
	   	void StateCitySearch() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check Search State/Location Code dropdown is working or not");
	   		
	   		PerformerMethod.StateCitySearch(test, workbook,"Reviewer");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		
		@Test(priority = 75) //Bilal
	   	void DesignationSearch() throws InterruptedException, IOException
	   	{
	test = extent.startTest("Manage Master - Designation - Verify to check Search/Select Designation dropdown is working or not");
	   		   		
	   		PerformerMethod.DesignationSearch(test, workbook, "Reviewer" );

	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		
		//My Documents -- Digital Signature
		@Test(priority = 100)
		void MyDocumentSearch() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document - Digital Signature - Verify Search field is working or not?");
			
			MethodsD.MyDocumentSearch(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		//Regulatory Abstracts
		@Test(priority = 150)
		void RegulatoryAbstractFilters() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Regulatory Abstracts - Verify dropdowns filters are working or not?");
			
			MethodsD.RegulatoryAbstractFilters(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 151)
		void RegulatoryAbstractUpload() throws Exception
		{
			test = extent.startTest("Regulatory Abstracts - Verify Upload button is working properly or not?");
			
			MethodsD.RegulatoryAbstractUpload(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 152)
		void RegulatoryAbstractUploadError() throws Exception
		{
			test = extent.startTest("Regulatory Abstracts - Verify Erros without uploading files and without selecting document type");
			
			MethodsD.RegulatoryAbstractUploadError(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 153)
		void RegulatoryAbstractRegional() throws Exception
		{
			test = extent.startTest("Regulatory Abstracts - Verify to check Regional column Download and View buttons are working or not?");
			
			MethodsD.RegulatoryAbstractRegional(test,"Reviewer Regional");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 154)
		void RegulatoryAbstractEnglish() throws Exception
		{
			test = extent.startTest("Regulatory Abstracts - Verify to check English column Download and View buttons are working or not?");
			
			MethodsD.RegulatoryAbstractRegional(test,"Reviewer English");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 155)
		void RegulatoryAbstractAcknowledgement() throws Exception
		{
			test = extent.startTest("Regulatory Abstracts - Verify to check Acknowledgement column Download and View buttons are working or not?");
			
			MethodsD.RegulatoryAbstractRegional(test,"Reviewer Acknowledgement");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		//Statutory Documents
		@Test(priority = 250)
		void StatutoryDocApplyClaerBtn() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Statutoty Document-Apply Button and clear Verification");
			
			ReviewerMethod.StatutoryDocApplyClaerBtn(test, "Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority =251) //This is not looking good (Need to write TCs like workspace filters verification)
		void StatutoryDocFilter() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Statutoty Document-Filter Verification");
			
			ReviewerMethod.StatutoryDocFilter(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 252)
		void StateDocZipFile() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Statutoty Document-Branch -Registor Compliance Type -Action Column -Zip File Verification");
			
			ReviewerMethod.StateDocZipFile(test , "Reviewer");
			
			extent.endTest(test);
			extent.flush();

		}
		@Test(priority = 253)
		void StateDownloadDoc() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Statutoty Document-Branch -Registor Compliance type-Action Column -Download Doc Verification");
			
			ReviewerMethod.StateDownloadDoc(test, "Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 254)
		void StatutoryDocViewandOverview() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Statutoty Document-Branch - Registor Compliance type -Action Column -Overview and view button Verification");
			
			ReviewerMethod.StatutoryDocViewandOverview(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();

		}
		@Test(priority = 255)
		void StatutoryDocZipFile() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Statutoty Document-State -Registor Compliance Type -Action Column -Zip File Verification");
			
			ReviewerMethod.StatutoryDocZipFile(test, "Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		@AfterMethod
	  	void browserClosing() throws InterruptedException
	  	{
			Thread.sleep(2000);
			closeBrowser();
	  		//Thread.sleep(1000);
	  		//getDriver().close();
	  	}	       
	  		       		
	  	@AfterTest
	  	void Closing() throws InterruptedException
	  	{
	  		
	  	}	
		
		
		
		

}
