package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
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
import performer.LocatorsP;
import performer.MethodsP;
import performer.PerformerMethod;
import rcp.ChangePassMethod;
import rcp.OneCommonMethod;
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
	
			Initialization(link,2,"Statutory");
		
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
//		@Test(priority = 3) //Bilal
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
		
		@Test(priority = 6) 
		void Corporate_Verification() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify to check Corporate functionalities is working or not?");
			
			PerformerMethod.Corporate_Verify(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 7) 
		void CorporateEntity_Verification() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify to check Corporate - Entity functionalities is working or not?");
			
			PerformerMethod.CorporateEntity_Verify(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 8) 
		void CorporateEntity_Edit() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify to check Corporate - Entity - Edit functionalities is working or not?");
			
			PerformerMethod.CorporateEntity_Edit(test);
			
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
		
		
		@Test(priority = 15) //Bilal
		void ProceedToDashboard() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify to check proceed to dashboard button is working or not?");
			
			MethodsD.ProceedToDashboard(test,"Reviewer");
			
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
		
		@Test(priority = 23)
		void compliancesCount() throws InterruptedException, IOException
		{
			test = extent.startTest("Upcoming Box count verification with categorised upcoming");
			
			MethodsD.compliancesCount(test,"Distributor", "TESTAUTO2");
			
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
		
		@Test(priority = 25)//NEW TC NEW TC
		void compliancesOverdueCount() throws InterruptedException, IOException
		{
			test = extent.startTest("Overdue Box count verification with categorised overdues");
			
			MethodsD.compliancesOverdueCount(test,"Distributor", "TESTAUTO2");
			
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
		
		@Test(priority = 27)//NEW TC NEW TC
		void pendingActionAndReviewCount() throws InterruptedException, IOException
		{
			test = extent.startTest("Pending Action & Pending Review counts verification with categorised action ");
			
			MethodsD.pendingActionAndReviewCount(test,"Distributor", "TESTAUTO2");
			
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
		@Test(priority = 48)
		void Complied() throws InterruptedException, IOException
		{
			test = extent.startTest("Pie Chart - Performance summary - Complied - match verification");
			
			MethodsD.Complied(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		
		@Test(priority = 49) 
		void CompliedFilters() throws InterruptedException, IOException
		{
			test = extent.startTest("Pie Chart - Performance summary - Complied - Multiple Filter verification");
			
			MethodsD.nonCompliedHighRiskSummaryFilter(test,"Performer", "Complied Filters");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 49)//NEW TC NEW TC
		void performanceSummaryTotals() throws InterruptedException, IOException
		{
			test = extent.startTest("Performance Summary Totals verification with complied and non complied");
			
			MethodsD.performanceSummaryTotals(test,"Distributor", "TESTAUTO2");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		
		@Test(priority = 50)  
		void RiskSummaryNotCompliedGraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph -Risk Summary - Not Complied - Count Verification");
			
			WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			LoginLocators.Search().sendKeys("TESTAUTO2");
			OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO2");
			
			Thread.sleep(5000);
			Thread.sleep(8000);
			LoginLocators.DashboardArrow().click();
			Thread.sleep(10000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue2024().click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		    
		    js.executeScript("window.scrollBy(0,300)");
		    Thread.sleep(2000);
		    
			Thread.sleep(3000);
			int high = Integer.parseInt(LocatorsP.HighRisk2().getText());	//Reading Dashboard count.
			int medium = Integer.parseInt(LocatorsP.MediumRisk2().getText());	//Reading Dashboard count.
			int low = Integer.parseInt(LocatorsP.LowRisk2().getText());	//Reading Dashboard count.
			
			Thread.sleep(500);
			
				if(high >= 0)
				{
					MethodsP.RiskGraph2( test, "High", high);
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					js.executeScript("window.scrollBy(0,300)");
					MethodsP.RiskGraph2( test, "Medium", medium);
				}
				else
				{
					js.executeScript("window.scrollBy(0,300)");
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+high);
				}
				
				if(low >= 0)
				{
					js.executeScript("window.scrollBy(0,300)");
					MethodsP.RiskGraph2( test, "Low", low);
				}
				else
				{
					js.executeScript("window.scrollBy(0,300)");
					test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
				}
						
				Thread.sleep(5000);
			
				Thread.sleep(2000);
				LoginLocators.Dashboard().click();			//Clicking on Dashboard
				Thread.sleep(2000);
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 51) 
		void nonCompliedHighRiskSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("High Risk Summary - Non Complied - Multiple Filter verification");
			
			MethodsD.nonCompliedHighRiskSummaryFilter(test,"Performer", "High");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 52) 
		void nonCompliedMediumRiskSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Medium Risk Summary - Non Complied - Multiple Filter verification");
			
			MethodsD.nonCompliedHighRiskSummaryFilter(test,"Performer", "Medium");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 53) 
		void nonCompliedLowRiskSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Low Risk Summary - Non Complied - Multiple Filter verification");
			
			MethodsD.nonCompliedHighRiskSummaryFilter(test,"Performer", "Low");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 54) 
		void RiskSummaryCompliedGraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph -Risk Summary - Complied - Count Verification");
			
			WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(120));
			Thread.sleep(5000);Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
//			LoginLocators.Search().sendKeys("TESTAUTO2");
			
			OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO2");
			
			//LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(10000);Thread.sleep(5000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(3000);
			LoginLocators.SelectPeriodValue2024().click();
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		    
		    js.executeScript("window.scrollBy(0,300)");
		    Thread.sleep(2000);
		    
			Thread.sleep(3000);
			int high = Integer.parseInt(LocatorsP.CompHighRisk().getText());	//Reading Dashboard count.
			int medium = Integer.parseInt(LocatorsP.CompMediumRisk().getText());	//Reading Dashboard count.
			int low = Integer.parseInt(LocatorsP.CompLowRisk().getText());	//Reading Dashboard count.
			
			Thread.sleep(500);
			
				if(high >= 0)
				{
					//Methods.HighRisk(test);
					MethodsP.CompRiskGraph( test, "High", high);
				}
				else
				{
					test.log(LogStatus.PASS, "'Critical' Risk Compliance Count = "+high);
				}
				
			if(medium >= 0)
			{
					js.executeScript("window.scrollBy(0,300)");
				MethodsP.CompRiskGraph( test, "Medium", medium);
				}
				else
				{
					js.executeScript("window.scrollBy(0,300)");
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(low >= 0)
				{
					js.executeScript("window.scrollBy(0,300)");
					MethodsP.CompRiskGraph( test, "Low", low);
				}
				else
				{
					js.executeScript("window.scrollBy(0,300)");
					test.log(LogStatus.PASS, "'Low' Risk Compliance Count = "+low);
				}
						
				Thread.sleep(5000);
			
				Thread.sleep(5000);
				LoginLocators.Dashboard().click();			//Clicking on Dashboard
				Thread.sleep(5000);
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 55) 
		void CompliedHighRiskSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("High Risk Summary - Complied - Multiple Filter verification");
			
			MethodsD.CompliedHighRiskSummaryFilter(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 56) 
		void CompliedMediumRiskSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Medium Risk Summary - Complied - Multiple Filter verification");
			
			MethodsD.CompliedMediumRiskSummaryFilter(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 57) 
		void CompliedLowRiskSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Low Risk Summary - Complied - Multiple Filter verification");
			
			MethodsD.CompliedLowRiskSummaryFilter(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 59) 
		void abstractSummary() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify to check - Abstract Summary verifiction displaying correctly");
			MethodsD.abstractSummary(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 60) 
		void ApplicableStatues() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify to check Applicable Statue is displayed or not?");
			
			MethodsD.ApplicableStatues(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 61) 
		void DailyUpdate() throws InterruptedException, IOException
		{
			test = extent.startTest("Daily Update verification");
			
			MethodsD.DailyUpdate(test,"Distributor");
			
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
		
		@Test(priority = 74) 
	   	void authorityAddressUpload() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check Authority address upload working or not");
	   		
	   		PerformerMethod.authorityAddressUpload(test, workbook, "Reviewer");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		@Test(priority = 75) 
	   	void DesignationSearch() throws InterruptedException, IOException
	   	{
	        test = extent.startTest("Manage Master - Designation - Verify to check Search/Select Designation dropdown is working or not");
	   		PerformerMethod.DesignationSearch(test, workbook , "Performer");
	   		
	   		test = extent.startTest("Manage Master - Designation - Verify to check Active/InActive filters are working or not");
	   		PerformerMethod.designationActiveInActive(test , "Performer");

	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
	    @Test(priority = 76)
	   	void AddDesignation() throws InterruptedException, IOException
	   	{
	        test = extent.startTest("Manage Master - Designation - Verify Add New Designation Error is throwing or not?");
	   		
	   		PerformerMethod.AddDesignation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	    @Test(priority = 76) 
	   	void BulkUpateDesignation() throws Exception
	   	{
	   		test = extent.startTest("Manage Masters - Verify to update designation through bulk upload");
	   		
	   		PerformerMethod.BulkUpateDesignationn(test, workbook,"Reviewer");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	    @Test(priority = 77) 
	   	void BulkUpateDesignationAlreadyExistForUpdate() throws Exception
	   	{
	   		test = extent.startTest("Manage Masters - Designation - Verify to check error to update designation through upload");
	   		
	   		PerformerMethod.BulkUpateDesignationAlreadyExistForUpdate(test, workbook,"Reviewer");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		
		
		@Test(priority = 80) //Fail
	   	void DesignationExportBtn() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Manage Masters - Designation - Verify to check export button works correctly ");
	   		
	   		PerformerMethod.DesignationExportBtn(test, workbook,"Reviewer");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		
		@Test(priority = 85)
	   	void LeaveTypeSearch() throws InterruptedException, IOException
	   	{
	test = extent.startTest("Manage Master - Leave Type - Verify to check Search Leave Type dropdown is working or not?");
	   		   		
	   		PerformerMethod.LeaveTypeSearch(test, workbook);

	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 86) 
	   	void leaveTypeExport() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Manage Master - Leave Type - Verify to check Export button working or not");
	   		
	   		PerformerMethod.leaveTypeExport(test, workbook, "Reviewer");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 135) //(Override)
	   	void manageMasterStaturyMaster() throws InterruptedException, IOException, AWTException
	   	{
	test = extent.startTest("Manage Masters - Statutory Master - Verify to check filters verification are working or not?");
	   		   		
	   		PerformerMethod.manageMasterStaturyMaster(test, workbook, "Reviewer");

	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 136) ////NEW TC NEW TC  (Override)
	   	void MastersStaturyDoc() throws InterruptedException, IOException, AWTException
	   	{
	test = extent.startTest("Manage Masters - Statutory Master - Verify to check Exports with all Compliance Types are working or not?");
	   		   		
	   		PerformerMethod.MastersStaturyDoc(test, workbook, "Reviewer");

	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		
		
		//My Documents -- Digital Signature
		@Test(priority = 100)
		void MyDocumentSearch() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document - Digital Signature - Verify Search field is working or not?");
			
			MethodsD.digitalSingantureSearch(test,"Reviewer");
			
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
			test = extent.startTest("Statutory Documents - Verify to check Apply and clear buttons works correctly");
			
			ReviewerMethod.StatutoryDocApplyClaerBtn(test, "Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 251) //This is not looking good (Need to write TCs like workspace filters verification)
		void StatutoryDocFilter() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Statutory Documents - Filter Verification");
			
			ReviewerMethod.StatutoryDocFilter(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 252)
		void StateDocZipFile() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Statutory Documents - Registers - Verify to download ZIP folder");
			
			ReviewerMethod.StateDocZipFile(test , "Reviewer");
			
			extent.endTest(test);
			extent.flush();

		}
		@Test(priority = 253)
		void StateDownloadDoc() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Statutory Documents - Branch - Registor Compliance type-Action Column -Download Doc Verification");
			
			ReviewerMethod.StateDownloadDoc(test, "Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 254)
		void StatutoryDocViewandOverview() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Statutory Documents - Branch - Registor Compliance type -Action Column -Overview and view button Verification");
			
			ReviewerMethod.StatutoryDocViewandOverview(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();

		}
		@Test(priority = 255)
		void StatutoryDocZipFile() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Statutory Documents - State - Registor Compliance Type -Action Column -Zip File Verification");
			
			ReviewerMethod.StatutoryDocZipFile(test, "Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 256) 
		void staturyDocChallanForms() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Statutory Documents - Verify to check Challan forms is displayed correctly");
			
			ReviewerMethod.staturyDocChallanForms(test, "Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 257) 
		void PTConsolidatedW() throws InterruptedException, IOException, AWTException 
		{	
			test = extent.startTest("Statutory Documents - Challan PT - Verify to check PT Consolidated Workings File is downloading correctly");
			ReviewerMethod.StateDocZipFileChallan(test, "Reviewer");//redirection
			ReviewerMethod.PTConsolidatedW(test, "Reviewer");
			
			test = extent.startTest("Statutory Documents - Challan PT - Verify to check Branch view button is working correctly");
			ReviewerMethod.branchView(test, "Reviewer");
			
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 258) 
		void StateDocZipFileChallan() throws InterruptedException, IOException, AWTException 
		{	
			test = extent.startTest("Statutory Documents - Challan PT - Verify to check Overview button is working correctly");
			ReviewerMethod.StateDocZipFileChallan(test, "Reviewer"); //redirection
			ReviewerMethod.StateDownloadDocOverviewChallanPT(test, "Reviewer");

			test = extent.startTest("Statutory Documents - Challan PT - Verify to download document file");
			ReviewerMethod.StateDownloadDocSingle(test, "Reviewer");
			
			test = extent.startTest("Statutory Documents - Challan PT - Verify to view document file");
			ReviewerMethod.StateViewDocSingle(test, "Reviewer");

			extent.endTest(test);
			extent.flush();

		}
		
		@Test(priority = 259) //ESIC 
		void ESIConsolidatedW() throws InterruptedException, IOException, AWTException 
		{	
			test = extent.startTest("Statutory Documents - Challan ESI - Verify to check ESI Consolidated Workings File is downloading correctly");
			ReviewerMethod.StateDocZipFileChallanESI(test, "Reviewer");//redirection
			ReviewerMethod.ESIConsolidatedW(test, "Reviewer");
			
			test = extent.startTest("Statutory Documents - Challan ESI - Verify to check Branch view button is working correctly");
			ReviewerMethod.branchView(test, "Reviewer");
			
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 310) 
		void challanESIC() throws InterruptedException, IOException, AWTException 
		{	
			test = extent.startTest("Statutory Documents - Challan ESI - Verify to check Overview button is working correctly");
			ReviewerMethod.StateDocZipFileChallanESI(test, "Reviewer"); //redirection
			ReviewerMethod.StateDownloadDocOverviewChallanPT(test, "Reviewer");

			test = extent.startTest("Statutory Documents - Challan ESI - Verify to download document file");
			ReviewerMethod.StateDownloadDocSingle(test, "Reviewer");
			
			test = extent.startTest("Statutory Documents - Challan ESI - Verify to view document file");
			ReviewerMethod.StateViewDocSingle(test, "Reviewer");

			extent.endTest(test);
			extent.flush();

		}
		
		@Test(priority = 311) 
		void EPFConsolidatedW() throws InterruptedException, IOException, AWTException 
		{	
			test = extent.startTest("Statutory Documents - Challan EPF - Verify to check ESI Consolidated Workings File is downloading correctly");
			ReviewerMethod.StateDocZipFileChallanEPF(test, "Reviewer");//redirection
			ReviewerMethod.EPFConsolidatedW(test, "Reviewer");
			
			test = extent.startTest("Statutory Documents - Challan EPF - Verify to check Branch view button is working correctly");
			ReviewerMethod.branchView(test, "Performer");
			
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 312) 
		void challanEPF() throws InterruptedException, IOException, AWTException 
		{	
			test = extent.startTest("Statutory Documents - Challan EPF - Verify to check Overview button is working correctly");
			ReviewerMethod.StateDocZipFileChallanEPF(test, "Reviewer"); //redirection
			ReviewerMethod.StateDownloadDocOverviewChallanPT(test, "Reviewer");

			test = extent.startTest("Statutory Documents - Challan EPF - Verify to download document file");
			ReviewerMethod.StateDownloadDocSingleEPF(test, "Reviewer");
			
			test = extent.startTest("Statutory Documents - Challan EPF - Verify to view document file");
			ReviewerMethod.StateViewDocSingleEPF(test, "Reviewer");

			extent.endTest(test);
			extent.flush();

		}
		
		
		
		@Test(priority = 270) //NEW TC NEW TC
		void PayBonusStateDocZipFile() throws InterruptedException, IOException, AWTException 
		{
			test = extent.startTest("Statutory Documents - Returns - Verify to download ZIP folder");
			ReviewerMethod.PayBonusStateDocZipFile(test, "Reviewer");
			
			test = extent.startTest("Statutory Documents - Returns - Verify to check Overview button is working correctly");
			ReviewerMethod.StateDownloadDocOverview(test, "Performer");

			test = extent.startTest("Statutory Documents - Returns - Verify to download document file");
			ReviewerMethod.StateDownloadDocSingle(test, "Performer");
			
			test = extent.startTest("Statutory Documents - Returns - Verify to view document file");
			ReviewerMethod.StateViewDocSingle(test, "Performer");

			extent.endTest(test);
			extent.flush();

		}
		
		
		
		/////////// Reports //////////////////////
		 
		@Test(priority = 300) 	
		void myreportComplianceAssignment() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Compliance Assignment Report ");
			MethodsD.myreportComplianceAssignment(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 301) 
		void assignmentReportsRegister() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Compliance Assignment Report - Verify to check Registers compliance exports correctly");
			MethodsD.assignmentReportsFilterExports(test,"Reviewer", "Registers");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 302) 
		void assignmentReportsReturn() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Compliance Assignment Report - Verify to check Returns compliance exports correctly");
			MethodsD.assignmentReportsFilterExports(test,"Reviewer", "Returns");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 303) 
		void assignmentReportsChallan() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Compliance Assignment Report - Verify to check Challans compliance exports correctly");
			MethodsD.assignmentReportsFilterExports(test,"Reviewer", "Challans");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 304) 
		void statusReports() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Status Report Verification");
			MethodsD.DistMyReportStatusReport(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 304) 
		void variousReports() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Various Report Verification");
			MethodsD.VariousReport(test,"Reviewer");
			
			extent.endTest(test);
			extent.flush();
		}
				
		
		@Test(priority = 305) 
		void clraAssignmentReport() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - CLRA Assignment Report Verification");
			MethodsD.clraAssignmentReport(test,"Reviewer");
			
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
