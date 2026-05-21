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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import distributor.All_Distributor_Methods;
import distributor.DistributerMethods;
import distributor.Methods;
import distributor.MethodsD;
import distributor.All_Distributor_Methods;
import login.BasePage;
import login.LoginLocators;
import performer.LocatorsP;
import performer.MethodsP;
import performer.PerformerMethod;
import rcp.OneCommonMethod;





public class All_Distributor_TWO extends BasePage {
	
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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\LabourD.html",true);
		test = extent.startTest("Loging In - DistributorAdmin");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		Initialization(link,0,"Statutory");
	
	}



	@Test(priority = 1) //Bilal
	void CompanyLogo() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check after distributor login TeamLease RegTech Logo is displayed or not?");
		
		
		MethodsD.CompanyLogo(test,"Performer");
		
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
	
	
	@Test(priority = 15) //Bilal
	void UserMasterVerification() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check User master functionalities is working or not?");
		
		MethodsD.UserMasterVerification(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void customerUserMapping() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check Customer User Mapping functionalities is working or not?");
		
		MethodsD.customerUserMapping(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 20) //Bilal
	void Corporate_Verification() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check Corporate functionalities is working or not?");
		
		MethodsD.Corporate_Verification(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 20) //Bilal
	void corporate_UserMapping() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check corporate - corporate user mapping works correctly");
		
		MethodsD.corporate_UserMapping(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 25) //Bilal
	void CorporateEntity_Verification() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check Corporate - Entity functionalities is working or not?");
		
		MethodsD.CorporateEntity_Verification(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 26) //Bilal
	void CorporateEntity_BulkUploadVerification() throws Exception
	{
		test = extent.startTest("Verify to check Corporate - Entity - Bulk Upload verification ");
		
		MethodsD.CorporateEntity_BulkUploadVerification(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 40) //Bilal
	void ProceedToDashboard() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check proceed button is working or not?");
		
		MethodsD.ProceedToDashboard(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}

	
	
	
	//<--- Dashboard --->
	    @Test(priority = 50)
		void ComplianceBox() throws InterruptedException, IOException
		{
			test = extent.startTest("Count by Clicking on 'Compliance'");
			
			MethodsD.complianceBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
	   
		@Test(priority = 52)
		void ComplianceFilter1() throws InterruptedException, IOException
		{
			test = extent.startTest("Compliance Box Filter Verification'");
			
			MethodsD.ComplianceFilter1(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 53)
		void UpcomingBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Upcoming'");
			
			MethodsD.UpcomingBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 54)
		void UpcomingFilter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Upcoming Box Filter Verification'");
			
		//	All_Distributor_Methods.UpcomingFilter(test,"Distributor");
			MethodsD.UpcomingFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 54)
		void compliancesCount() throws InterruptedException, IOException
		{
			test = extent.startTest("Upcoming Box count verification with categorised upcoming");
			
			MethodsD.compliancesCount(test,"Distributor", "TESTAUTO2");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 55)
		void OverdueBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Overdue'");
			
		//	All_Distributor_Methods.OverdueBox(test,"Distributor");
			MethodsD.OverdueBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 56)
		void OverdueFilter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Overdue Box Filter Verification'");
			
		//	All_Distributor_Methods.OverdueFilter(test,"Distributor");
			MethodsD.OverdueFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 56)
		void compliancesOverdueCount() throws InterruptedException, IOException
		{
			test = extent.startTest("Overdue Box count verification with categorised overdues");
			
			MethodsD.compliancesOverdueCount(test,"Distributor", "TESTAUTO2");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 57)
		void PendingActionBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Pending Action'");
			
		//	All_Distributor_Methods.PendingActionBox(test,"Distributor");
			MethodsD.PendingActionBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 58)
		void PendingActionFilter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Pending Action Box Filter Verification'");
			
		//	All_Distributor_Methods.PendingActionFilter(test,"Distributor");
			MethodsD.PendingActionFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 58)
		void pendingActionAndReviewCount() throws InterruptedException, IOException
		{
			test = extent.startTest("Pending Action & Pending Review counts verification with categorised action ");
			
			MethodsD.pendingActionAndReviewCount(test,"Distributor", "AVAHRTEC");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 59)
		void PendingReviewBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Pending Review'");
			
		//	All_Distributor_Methods.PendingReviewBox(test,"Distributor");
			MethodsD.PendingReviewBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 60)
		void PendingReviewFilter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Pending Review Box Filter Verification'");
			
		//	All_Distributor_Methods.PendingReviewFilter(test,"Distributor");
			MethodsD.PendingReviewFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		//bifurgated dashboard
		@Test(priority = 61)
		void RegisterUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Register - 'Upcoming'");
			
		//	All_Distributor_Methods.RegisterUpcoming(test,"Distributor");
			MethodsD.RegisterUpcoming(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 62)
		void RegisterUpcomingFilter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Register - Upcoming Filter Verification'");
			
		//	All_Distributor_Methods.RegisterUpcomingFilter(test,"Distributor");
			MethodsD.RegisterUpcomingFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 63)
		void RegisterOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Register - 'Overdue'");
			
		//	All_Distributor_Methods.RegisterOverdue(test,"Distributor");
			MethodsD.RegisterOverdue(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 65)
		void RegisterActionReview() throws InterruptedException, IOException
		{
			test = extent.startTest("Count by Clicking on Register - 'Action/Review'");
			
		//	All_Distributor_Methods.RegisterActionReview(test,"Distributor");
			MethodsD.RegisterActionReview(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 67)
		void ReturnUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest("Count by Clicking on Returns - 'Upcoming'");
			
		//	All_Distributor_Methods.ReturnUpcoming(test,"Distributor");
			MethodsD.ReturnUpcoming(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 69)
		void ReturnOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest("Count by Clicking on Returns - 'Overdue'");
			
		//	All_Distributor_Methods.ReturnOverdue(test,"Distributor");
			MethodsD.ReturnOverdue(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 71)
		void ReturnActionReview() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Returns - 'Action/Review'");
			
		//	All_Distributor_Methods.ReturnActionReview(test,"Distributor");
			MethodsD.ReturnActionReview(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 73)
		void ChallanUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Challans - 'Upcoming'");
			
		//	All_Distributor_Methods.ChallanUpcoming(test,"Distributor");
			MethodsD.ChallanUpcoming(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 75)
		void ChallanOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Challans - 'Overdue'");
			
		//	All_Distributor_Methods.ChallanOverdue(test,"Distributor");
			MethodsD.ChallanOverdue(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 77)
		void ChallanActionReview() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Challans - 'Action/Review'");
			
		//	All_Distributor_Methods.ChallanActionReview(test,"Distributor");
			MethodsD.ChallanActionReview(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		//Dashboard Performance Summary (need to add non complied as well)
		@Test(priority = 80)
		void Complied() throws InterruptedException, IOException
		{
			test = extent.startTest("Pie Chart - Performance summary - Complied - match verification");
			
			MethodsD.Complied(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 80)//NEW TC NEW TC - Pending
		void performanceSummaryTotals() throws InterruptedException, IOException
		{
			test = extent.startTest("Performance Summary Totals verification with complied and non complied");
			
			MethodsD.performanceSummaryTotals(test,"Distributor", "TESTAUTO2");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 81) 
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
		
		@Test(priority = 82) 
		void nonCompliedHighRiskSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("High Risk Summary - Non Complied - Multiple Filter verification");
			
			MethodsD.nonCompliedHighRiskSummaryFilter(test,"Performer", "High");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 83) 
		void nonCompliedMediumRiskSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Medium Risk Summary - Non Complied - Multiple Filter verification");
			
			MethodsD.nonCompliedHighRiskSummaryFilter(test,"Performer", "Medium");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 84) 
		void nonCompliedLowRiskSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Low Risk Summary - Non Complied - Multiple Filter verification");
			
			MethodsD.nonCompliedHighRiskSummaryFilter(test,"Performer", "Low");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		
		
		
		
		@Test(priority = 85) //Need to add below test case for complied filter test cases 
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
		@Test(priority = 86) //Bilal
		void CompliedHighRiskSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("High Risk Summary - Complied - Multiple Filter verification");
			
			MethodsD.CompliedHighRiskSummaryFilter(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 87) //Bilal
		void CompliedMediumRiskSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Medium Risk Summary - Complied - Multiple Filter verification");
			
			MethodsD.CompliedMediumRiskSummaryFilter(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 89)  //NEW TC NEW TC
		void abstractSummary() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify to check - Abstract Summary verifiction displaying correctly");
			MethodsD.abstractSummary(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 90) //If see some test case add above
		void ApplicableStatues() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify to check Applicable Statue is displayed or not?");
			
		//	All_Distributor_Methods.ApplicableStatues(test,"Distributor");
			MethodsD.ApplicableStatues(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 91)
		void DailyUpdate() throws InterruptedException, IOException
		{
			test = extent.startTest("Daily Update verification");
			
		//	All_Distributor_Methods.DailyUpdate(test,"Distributor");
			MethodsD.DailyUpdate(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
	
/*
	//Part 2


		
		//Manage Masters
		@Test(priority = 100) //Bilal
	   	void StateCitySearch() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check Search State/Location Code dropdown is working or not");
	   		
	   		PerformerMethod.StateCitySearch(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 101) 
	   	void stateCityExportMapping() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check export mapping buttons working or not");
	   		
	   		PerformerMethod.stateCityExportMapping(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 102) 
	   	void stateCityExport() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check export mapping buttons working or not");
	   		
	   		PerformerMethod.stateCityExport(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 103) 
	   	void authorityAddressUpload() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check Authority address upload working or not");
	   		
	   		PerformerMethod.authorityAddressUpload(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 104) //Bilal
	   	void StateCityAddressMapping() throws Exception
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check address mapping button is working or not?");
	   		
	   		PerformerMethod.StateCityAddressMapping(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 105) //Bilal
	   	void StateCityAddNewPopUp() throws Exception
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check add new popup is working correctly");
	   		
	   		PerformerMethod.StateCityAddNewPopUp(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
//		@Test(priority = 106) // Hide functionality
	   	void StateCitySealANDSignatureInvalid() throws Exception
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check error without file selection and upload more than 4 kb file in seal and signature upload ");
	   		
	   		PerformerMethod.StateCitySealANDSignatureInvalid(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		
		
		
		
		@Test(priority = 107) 
	   	void DesignationSearch() throws InterruptedException, IOException
	   	{
            test = extent.startTest("Manage Master - Designation - Verify to check Search/Select Designation dropdown is working or not");
	   		PerformerMethod.DesignationSearch(test, workbook , "Distributor");
	   		
	   		test = extent.startTest("Manage Master - Designation - Verify to check Active/InActive filters are working or not");
	   		PerformerMethod.designationActiveInActive(test , "Distributor");

	   		extent.endTest(test);
	   		extent.flush();
	   	}
	    @Test(priority = 110) 
	   	void BulkUpateDesignation() throws Exception
	   	{
	   		test = extent.startTest("Manage Masters - Verify to update designation through bulk upload");
	   		
	   		PerformerMethod.BulkUpateDesignationn(test, workbook,"Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	    @Test(priority = 111) //Bilal this is for update 
	   	void BulkUpateDesignationAlreadyExistForUpdate() throws Exception
	   	{
	   		test = extent.startTest("Manage Masters - Designation - Verify to check error to update designation through upload");
	   		
	   		PerformerMethod.BulkUpateDesignationAlreadyExistForUpdate(test, workbook,"Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	    
	    @Test(priority = 112) //Bilal This is for upload 
	   	void BulkUpateDesignationAlreadyExist() throws Exception
	   	{
	   		test = extent.startTest("Manage Masters - Designation - Verify to check error to upload designation which is already exists in the system");
	   		
	   		PerformerMethod.BulkUpateDesignationAlreadyExist(test, workbook,"Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	    
		@Test(priority = 118) 
	   	void leaveTypeSearch() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Manage Master - Leave Type - Verify to check Search Leave type/Description working or not");
	   		
	   		PerformerMethod.leaveTypeSearch(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 119) 
	   	void leaveTypeExport() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Manage Master - Leave Type - Verify to check Export button working or not");
	   		
	   		PerformerMethod.leaveTypeExport(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 125)
	   	void PaycodeMappingSearchField() throws InterruptedException, IOException
	   	{
	test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check search field is working or not?");
	   		   		
	   		PerformerMethod.PaycodeMappingSearchField(test, workbook,"Distributor");

	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 126) 
	   	void PaycodeMappingAddNew() throws InterruptedException, IOException
	   	{
	test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check Add New error is displayed or not?");
	   		   		
	   		PerformerMethod.PaycodeMappingAddNew(test, workbook, "Distributor");

	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 127) 
	   	void paycodeUploadSample() throws InterruptedException, IOException, AWTException
	   	{
	test = extent.startTest("Manage Masters - Paycode Mapping - Upload - Verify to check sample documents are downloading or not");
	   		   		
	   		PerformerMethod.paycodeUploadSample(test, workbook, "Distributor");

	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 128) 
	   	void PaycodeMappingUpload() throws InterruptedException, IOException, AWTException
	   	{
	test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check paycode Upload or not?");
	   		   		
	   		PerformerMethod.PaycodeMappingUpload(test, workbook, "Distributor");

	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 129) 
	   	void PaycodeMappingUploadInvalid() throws InterruptedException, IOException, AWTException
	   	{
	test = extent.startTest("Manage Masters - Paycode Mapping - Verify to upload invalid file which contains special characters error message is displayed or not?");
	   		   		
	   		PerformerMethod.PaycodeMappingUploadInvalid(test, workbook, "Distributor");

	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 130)  
	   	void PaycodeMappingEditUpdate() throws InterruptedException, IOException
	   	{
	test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check paycode is editable or not?");
	   		   		
	   		PerformerMethod.PaycodeMappingEditUpdate(test, workbook, "Distributor");

	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 135) 
	   	void manageMasterStaturyMaster() throws InterruptedException, IOException, AWTException
	   	{
	test = extent.startTest("Manage Masters - Statutory Master - Verify to check filters verification are working or not?");
	   		   		
	   		PerformerMethod.manageMasterStaturyMaster(test, workbook, "Distributor");

	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 136) 
	   	void MastersStaturyDoc() throws InterruptedException, IOException, AWTException
	   	{
	test = extent.startTest("Manage Masters - Statutory Master - Verify to check Exports with all Compliance Types are working or not?");
	   		   		
	   		PerformerMethod.MastersStaturyDoc(test, workbook, "Distributor");

	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 139) //Swapnil
		void OnboardEmployee() throws Exception
		{
			test = extent.startTest("OnBoard Employee - DOL Reactivation section Verification.");
			MethodsD.dolReactivation(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		//My Document Digital signature
		@Test(priority = 140) 
		void MyDocumentSearch() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document - Digital Signature - Verify Search field is working or not?");
			
			MethodsD.digitalSingantureSearch(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 141) 
		void addNeDigitalSignature() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document - Digital Signature - Verify to add new - New Digital Signature is adding or not");
			
			MethodsD.addNeDigitalSignature(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 142) 
		void addNewExistingDigitalSignature() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document - Digital Signature - Verify to add new - Existing Digital Signature is adding or not");
			
			MethodsD.addNewExistingDigitalSignature(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 143) 
		void effectiveDateFromToAddNew() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document - Digital Signature - Verify to add new - check error messages to selecting effective from date is greater than effective to date ");
			
			MethodsD.effectiveDateFromToAddNew(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 144) 
		void digitalSignatureEdit() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document - Digital Signature - Verify to check edit button working or not");
			
			MethodsD.digitalSignatureEdit(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 145) 
		void effectiveDateFromToEdit() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document - Digital Signature - Verify to edit - check error messages to selecting effective from date is greater than effective to date ");
			
			MethodsD.effectiveDateFromToEdit(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		//-----------*****On board Entity:*****------------
	    //Premises: 
		
		@Test(priority = 160)
		void searchPremises() throws InterruptedException, IOException
		{
			test = extent.startTest("Onboard Entity - Premises - Verify to check type to search field is working or not?");
			
			Methods.searchPremises(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 161) // NEW TC (Pending)
		void uploadShiftMasterPremises() throws Exception
		{
			test = extent.startTest("Onboard Entity - Premises - Verify to check upload shift master is working or not?");
			
			Methods.uploadShiftMasterPremises(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 162) 
		void uploadAddressMapping() throws Exception
		{
			test = extent.startTest("Onboard Entity - Premises - Verify to check upload address mapping is working or not?");
			
			Methods.uploadAddressMapping(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 163) 
		void uploadPremises() throws Exception
		{
			test = extent.startTest("Onboard Entity - Premises - Verify to check upload button is working or not?");
			
			Methods.uploadPremises(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		@Test(priority = 165) 
		void ExportPremises() throws InterruptedException, IOException
		{
			test = extent.startTest("Onboard Entity - Premises - Verify Export button is working or not?");
			
			Methods.ExportPremises(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 170) 
		void EditPremises() throws InterruptedException, IOException
		{
			test = extent.startTest("Onboard Entity - Premises - Verify to check Edit button is working or not?");
			
			Methods.EditPremises(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 171) 
		void deletePremises() throws InterruptedException, IOException
		{
			test = extent.startTest("Onboard Entity - Premises - Verify to check Delete button is working or not?");
			
			Methods.deletePremises(test);
			
			extent.endTest(test);
			extent.flush();
		}
		

		
		//Need to add above delete button verification 
		@Test(priority = 175) 
		void Premises_AddressMapping() throws InterruptedException, IOException
		{
			test = extent.startTest("Onboard Entity - Premises - Verify to check Address Mapping button is working or not");
			
			Methods.Premises_AddressMapping(test);
			
			extent.endTest(test);
			extent.flush();
		}
	    
	    
	    
	    
//Onboard Entity --> Paycode mapping 
		@Test(priority = 210) 
	   	void OnboardEntityPaycodeSearchDropdown() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Onboard Entity - Paycode Mapping - Verify to check search paycode/header name dropdown is working or not?");
	   		 
	   		Methods.OnboardEntityPaycodeSearchDropdown(test);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 211)
		void PayCodeAddNewError() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Onboard Entity - Paycode Mapping - Verify to check add new error is displayed or not?");
			
			Methods.PayCodeAddNewError(test, "Distributor Paycode Add New Error");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 212)
		void PayCodeAddNewErrorSequence() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Onboard Entity - Paycode Mapping - Verify to check error to enter paycode sequence more than 200");
			
			Methods.PayCodeAddNewError(test, "Distributor - Paycode Sequence Error");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 213) 
		void PayCodeEdit() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Onboard Entity - Paycode Mapping - Verify to check edit button is working or not?");
			
			Methods.PayCodeEdit(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		@Test(priority = 214) 
		void PayCodeUploadSampleFile() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Onboard Entity - Paycode Mapping - Verify to check upload - sample files is downloading or not?");
			
			Methods.PayCodeUploadSampleFile(test);
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 215) 
		void PayCodeUploadCheck() throws Exception
		{
			test = extent.startTest("Onboard Entity - Paycode Mapping - Verify to check upload - paycode is uploading or not?");
			
			Methods.PayCodeUploadCheck(test);
			
			extent.endTest(test);
			extent.flush();
		}
//Onboard Entity --> User branch mapping 
		@Test(priority = 220) 
		void Entity_UMapuser() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Onboard Entity - User-Branch Mapping - Verify to check Map User button is working or not?");
			
			All_Distributor_Methods.Entity_UMapuser(test);
			  
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 221) 
		void ubExport() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Onboard Entity - User-Branch Mapping - Verify to check Export button works correctly");
			
			All_Distributor_Methods.ubExport(test,"Distributor");
			  
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 222)
		void ubExportsFilters() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Onboard Entity - User-Branch Mapping - Verify to check Exports with Filters are working correctly ");
			
			All_Distributor_Methods.ubExportsFilters(test, "Distributor");
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 223)  
		void ubDelete() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Onboard Entity - User-Branch Mapping - Verify to check Delete button are working correctly ");
			
			All_Distributor_Methods.ubDelete(test, "Distributor");
			  
			extent.endTest(test);
			extent.flush();
		}
		
	
		//Compliance asiisgnment
		@Test(priority = 225) 
		void Entity_CompAssignment() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Onboard Entity - Compliance Assignment - Verify to check compliance assignment works correctly");
			
			All_Distributor_Methods.Entity_CompAssignment(test, workbook);
			  
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		
		
//Onboard Entity --> Manage Compliance: 
		
		//Activataion Date Change 
		@Test(priority = 230)
		void ActivationDateChange() throws InterruptedException, IOException {
			test = extent.startTest("Onboard Entity - Manage Compliance - Verify to check Activation Date change works correctly");

			All_Distributor_Methods.manageCompActivationDateChange(test, workbook);

			extent.endTest(test);
			extent.flush();

		}
		
		
		//Assignment Removal
		@Test(priority = 235) 
		void AssignmentRemoval() throws InterruptedException, IOException {
			test = extent.startTest("OnBorad Entity - Manage Compliance - Verify to check Assignment Removal works correctly");

			All_Distributor_Methods.manageCompAssignmentRemoval(test, workbook);

			extent.endTest(test);
			extent.flush();

		}
		@Test(priority = 236) 
	   	void bulkCompReassignment() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Onboard Entity - Manage Compliance - Bulk Compliance Reassignment - Verify validation message");
	   		 
	   		All_Distributor_Methods.bulkCompReassignment(test, workbook,"Entity");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		//Compliance Reassignment:
		@Test(priority = 240) 
	   	void ComplainceReassignment() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Onboard Entity - Manage Compliance - Verify to check compliance reassignment is working or not?");
	   		 
	   		All_Distributor_Methods.onboardEntityComplainceReassignment(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		//Schedule Creation:
		@Test(priority = 250) //Bilal 
	   	void scheduleCreationValidation() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Onboard Entity - Manage Compliance - Schedule creation - Verify validation message");
	   		 
	   		All_Distributor_Methods.scheduleCreationValidation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		//Schedule Removal
		@Test(priority = 255) 
		void ScheduleRemoval() throws InterruptedException, IOException {
			test = extent.startTest("Onboard Entity - Manage Compliance - Verify Schedule Removal works correctly");

			All_Distributor_Methods.manageCompScheduleRemoval(test, workbook);

			extent.endTest(test);
			extent.flush();

		}
		
		
		
		
		
		//OnBoard CLRA:-----
		@Test(priority = 300) 
	   	void CLRASearchEmployee() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Search Box verification");
	   		
	   		All_Distributor_Methods.CLRASearchEmployee(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 301) 
	   	void CLRAEmployerAddNew() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Onboard CLRA - Add Employer verification");
	   		
	   		All_Distributor_Methods.CLRAEmployerAddNew(test, workbook, "Distributor Add New");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 302) 
	   	void CLRA_HolidayMaster_verification() throws Exception
	   	{
	   		test = extent.startTest("OnBorad CLRA - Verify to upload holiday master verification");
	   		
	   		All_Distributor_Methods.CLRA_HolidayMaster_verification(test, workbook);
	   		
	   		
	   		test = extent.startTest("OnBorad CLRA - Verify to upload holiday master verification");
	   		All_Distributor_Methods.CLRA_HolidayMaster_verificationValidation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 303) 
	   	void bulkUpload() throws Exception
	   	{
	   		test = extent.startTest("OnBorad CLRA-Bulk Upload verification");
	   		
	   		All_Distributor_Methods.bulkUpload(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 304) 
	   	void EmployeerExportBtn() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Export button verification");
	   		
	   		All_Distributor_Methods.EmployeerExportBtn(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 305) 
	   	void UpdateEmployer() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Employer - Verify to check edit button is working or not?");
	   		
	   		All_Distributor_Methods.UpdateEmployer(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 306) //Completed till here
	   	void DeleteEmployer() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Employer - Verify to check delete button is working or not?");
	   		
	   		All_Distributor_Methods.DeleteEmployer(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		//CLRA: Location tab
		@Test(priority = 310) 
	   	void CLRA_Location_SearchField() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Locations - Verify to search field is working or not?");
	   		
	   		All_Distributor_Methods.CLRA_Location_SearchField(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 311) 
	   	void CLRA_AddLocation_Error() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Locations - Verify to check add new error is displayed or not?");
	   		
	   		All_Distributor_Methods.CLRA_AddLocation_Error(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 312) //While uploading file with some error xml page is opening need to raise issue 
	   	void CLRA_AddLocation_Upload() throws Exception
	   	{
	   		test = extent.startTest("OnBoard CLRA - Locations - Verify to check upload location button is working or not?");
	   		
	   		All_Distributor_Methods.CLRA_AddLocation_Upload(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 313) 
	   	void CLRA_LocationExport() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Locations - Verify to check Export button is working or not?");
	   		
	   		All_Distributor_Methods.CLRA_LocationExport(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 315) 
	   	void CLRA_AddLocation_EditUpdate() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Locations - Verify to check Edit & Delete button is working or not?");
	   		
	   		All_Distributor_Methods.CLRA_AddLocation_EditUpdate(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		//CLRA Contractor
		@Test(priority = 320)
	   	void CLRA_Contractor() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Contractor verification");
	   		
	   		All_Distributor_Methods.CLRA_Contractor(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		
		//CLRA - Employee Mapping 
		@Test(priority = 325) 
	   	void CLRA_EmployeeMap_Filters() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Employee Mapping - Verify to check all filters are working fine or not?");
	   		
	   		All_Distributor_Methods.CLRA_EmployeeMap_Filters(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 326) 
	   	void CLRA_EmployeeMap_Migrate() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Employee Mapping - Verify to check employee migration is working or not?");
	   		
	   		All_Distributor_Methods.CLRA_EmployeeMap_Migrate(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 327) //Bilal need to this TC only bulk upload TC 
	   	void CLRA_EmployeeMap_bulkUpload() throws Exception
	   	{
	   		test = extent.startTest("OnBoard CLRA - Employee Mapping - Verify to download sample files in bulk upload ");
	   		All_Distributor_Methods.CLRA_EmployeeMap_bulkUpload(test, workbook);
	   		
	   		
	   		test = extent.startTest("OnBoard CLRA - Employee Mapping - Verify to check errors while uploading files");
	   		All_Distributor_Methods.CLRA_EmployeeMap_bulkUploadInvalid(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		@Test(priority = 330) //Bilal
	   	void CLRA_EmployeeMap_Export() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Employee Mapping - Verify to check export button is working or not?");
	   		
	   		All_Distributor_Methods.CLRA_EmployeeMap_Export(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		//CLRA - Compliance Assignment 
		@Test(priority = 340) //Bilal
	   	void ComplianceAssignmentRegisterCLRA() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Compliance Assignment verification ");
	   		
	   		All_Distributor_Methods.CLRA_CompAssignment(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 341) //Bilal
	   	void CLRA_CompAssignment_Validations() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Compliance Assignment validation error messages verification ");
	   		
	   		All_Distributor_Methods.CLRA_CompAssignment_Validations(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		//CLRA: Manage Compliances 
		@Test(priority = 344)
	   	void manageCompliances_DrpChecking() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Manage Compliances - Verify to check in activity dropdown all expected values reflecting correctly");
	   		 
	   		All_Distributor_Methods.manageCompliances_DrpChecking(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		@Test(priority = 345)
	   	void CLRA_CompReassignment() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Manage Compliances - Compliance Reassignment verification ");
	   		 
	   		All_Distributor_Methods.CLRA_CompReassignment(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		//
		@Test(priority = 350)
	   	void CLRA_CompManage_ActDateChange() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Manage Compliances - Activation Date change verification ");
	   		 
	   		All_Distributor_Methods.CLRA_CompManage_ActDateChange(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
	    @Test(priority = 351)
	   	void CLRA_ManageComp_AssignmentRemoval() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Manage Compliances - Assignment Removal Verification");
	   		
	   		All_Distributor_Methods.CLRA_ManageComp_AssignmentRemoval(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	    
	    
		@Test(priority = 352) 
	   	void CLRAbulkCompReassignment() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Manage Compliance - Bulk Compliance Reassignment - Verify validation message");
	   		 
	   		All_Distributor_Methods.bulkCompReassignment(test, workbook, "CLRA");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	    @Test(priority = 353)
	   	void CLRA_ManageComp_ScneduleCreation() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Manage Compliances - Schedule creation verification");
	   		
	   		All_Distributor_Methods.CLRA_ManageComp_ScneduleCreation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	    
		@Test(priority = 354) 
	   	void CLRAcheduleCreationValidation() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Manage Compliance - Schedule creation - validation verification");
	   		 
	   		All_Distributor_Methods.CLRAscheduleCreationValidation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 356) 
	   	void CLRA_ManageComp_ScheduleRemoval() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Manage Compliance - Schedule removal - verification");
	   		 
	   		All_Distributor_Methods.CLRA_ManageComp_ScheduleRemoval(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		
		
		@Test(priority = 400) 
		void myreportComplianceAssignment() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Compliance Assignment Report ");
			
			MethodsD.myreportComplianceAssignment(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 401) 
		void assignmentReportsRegister() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Compliance Assignment Report - Verify to check Registers compliance exports correctly");
			
			MethodsD.assignmentReportsFilterExports(test,"Distributor", "Registers");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 402) 
		void assignmentReportsReturn() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Compliance Assignment Report - Verify to check Returns compliance exports correctly");
			
			MethodsD.assignmentReportsFilterExports(test,"Distributor", "Returns");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 403) 
		void assignmentReportsChallan() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Compliance Assignment Report - Verify to check Challans compliance exports correctly");
			
			MethodsD.assignmentReportsFilterExports(test,"Distributor", "Challans");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 404)
		void StatusReport() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Status Report ");
			
			MethodsD.DistMyReportStatusReport(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 405)
		void VariousReport() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Various Report ");
			
			MethodsD.VariousReport(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 406) 
		void clraAssignmentReport() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - CLRA Assignment Report");
			
			MethodsD.clraAssignmentReport(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		

	
	
	
*/


	   
	   
	
	   
	
	   
	   
	
	
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
