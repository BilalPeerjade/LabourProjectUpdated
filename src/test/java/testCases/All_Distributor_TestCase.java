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

	
	public class All_Distributor_TestCase  extends BasePage {
		
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
			initialization(link,0,"Statutory");
		
		}
		
//		@Test(priority = 1) //Moved in all Bilal
		void CompanyLogo() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify to check after distributor login TeamLease RegTech Logo is displayed or not?");
			
			MethodsD.CompanyLogo(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
//		@Test(priority = 2) //Moved in all Bilal
		void Logout() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify Logout link is working or not");
			
			MethodsD.Logout(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
//		@Test(priority = 50) //Moved in all Bilal
	   	void StateCitySearch() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check Search State/Location Code dropdown is working or not");
	   		
	   		PerformerMethod.StateCitySearch(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}

		
		
	   @Test(priority = 1)//Moved in all
		void ComplianceBox() throws InterruptedException, IOException
		{
			test = extent.startTest("Count by Clicking on 'Compliance'");
			
	      //All_Distributor_Methods.complianceBox(test,"Distributor");
			MethodsD.complianceBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 2)//Moved in all
		void UpcomingBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Upcoming'");
			
		//	All_Distributor_Methods.UpcomingBox(test,"Distributor");
			MethodsD.UpcomingBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 3) //Moved in all
		void OverdueBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Overdue'");
			
		//	All_Distributor_Methods.OverdueBox(test,"Distributor");
			MethodsD.OverdueBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 4) //Moved in all
		void PendingActionBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Pending Action'");
			
		//	All_Distributor_Methods.PendingActionBox(test,"Distributor");
			MethodsD.PendingActionBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 5) //Moved in all
		void PendingReviewBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Pending Review'");
			
		//	All_Distributor_Methods.PendingReviewBox(test,"Distributor");
			MethodsD.PendingReviewBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 6) //Moved in all
		void RegisterUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Register - 'Upcoming'");
			
		//	All_Distributor_Methods.RegisterUpcoming(test,"Distributor");
			MethodsD.RegisterUpcoming(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 7) //Moved in all
		void RegisterOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Register - 'Overdue'");
			
		//	All_Distributor_Methods.RegisterOverdue(test,"Distributor");
			MethodsD.RegisterOverdue(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 8) //Moved in all
		void RegisterActionReview() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Register - 'Action/Review'");
			
		//	All_Distributor_Methods.RegisterActionReview(test,"Distributor");
			MethodsD.RegisterActionReview(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 9)//Moved in all
		void ReturnUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Returns - 'Upcoming'");
			
		//	All_Distributor_Methods.ReturnUpcoming(test,"Distributor");
			MethodsD.ReturnUpcoming(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 10) //Moved in all
		void ReturnOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Returns - 'Overdue'");
			
		//	All_Distributor_Methods.ReturnOverdue(test,"Distributor");
			MethodsD.ReturnOverdue(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 11) //Moved in all
		void ReturnActionReview() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Returns - 'Action/Review'");
			
		//	All_Distributor_Methods.ReturnActionReview(test,"Distributor");
			MethodsD.ReturnActionReview(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 12) //Moved in all
		void ChallanUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Challans - 'Upcoming'");
			
		//	All_Distributor_Methods.ChallanUpcoming(test,"Distributor");
			MethodsD.ChallanUpcoming(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 13) //Moved in all
		void ChallanOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Challans - 'Overdue'");
			
		//	All_Distributor_Methods.ChallanOverdue(test,"Distributor");
			MethodsD.ChallanOverdue(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 14) //Moved in all
		void ChallanActionReview() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Challans - 'Action/Review'");
			
		//	All_Distributor_Methods.ChallanActionReview(test,"Distributor");
			MethodsD.ChallanActionReview(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 15) //Moved in all
		void ComplianceFilter1() throws InterruptedException, IOException
		{
			test = extent.startTest(" Compliance Box Filter Verification'");
			
		//	All_Distributor_Methods.ComplianceFilter1(test,"Distributor");
			MethodsD.ComplianceFilter1(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 16) //Moved in all
		void UpcomingFilter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Upcoming Box Filter Verification'");
			
		//	All_Distributor_Methods.UpcomingFilter(test,"Distributor");
			MethodsD.UpcomingFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 17) //Moved in all
		void OverdueFilter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Overdue Box Filter Verification'");
			
		//	All_Distributor_Methods.OverdueFilter(test,"Distributor");
			MethodsD.OverdueFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 18) //Moved in all
		void PendingActionFilter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Pending Action Box Filter Verification'");
			
		//	All_Distributor_Methods.PendingActionFilter(test,"Distributor");
			MethodsD.PendingActionFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 19) //Moved in all
		void PendingReviewFilter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Pending Review Box Filter Verification'");
			
		//	All_Distributor_Methods.PendingReviewFilter(test,"Distributor");
			MethodsD.PendingReviewFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 20) //Moved in all
		void RegisterUpcomingFilter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Register - Upcoming Filter Verification'");
			
		//	All_Distributor_Methods.RegisterUpcomingFilter(test,"Distributor");
			MethodsD.RegisterUpcomingFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 21)
		void RiskSummaryNotCompliedGraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph -Risk Summary - Not Complied - Count Verification");
			
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			LoginLocators.Search().sendKeys("AVACORED5");
			//LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		    
		    js.executeScript("window.scrollBy(0,300)");
		    Thread.sleep(2000);
		    
			Thread.sleep(9000);
			int high = Integer.parseInt(LoginLocators.HighRisk().getText());	//Reading Dashboard count.
			int medium = Integer.parseInt(LoginLocators.MediumRisk().getText());	//Reading Dashboard count.
			int low = Integer.parseInt(LoginLocators.LowRisk().getText());	//Reading Dashboard count.
			
			Thread.sleep(500);
			
				if(high >= 0)
				{
					//Methods.HighRisk(test);
			//		All_Distributor_Methods.RiskGraph( test, "High", high);
					MethodsD.RiskGraph( test, "High", high);
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					js.executeScript("window.scrollBy(0,300)");
				//	All_Distributor_Methods.RiskGraph( test, "Medium", medium);
					MethodsD.RiskGraph( test, "Medium", medium);
				}
				else
				{
					js.executeScript("window.scrollBy(0,300)");
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+high);
				}
				
				if(low >= 0)
				{
					js.executeScript("window.scrollBy(0,300)");
				//	All_Distributor_Methods.RiskGraph( test, "Low", low);
					MethodsD.RiskGraph( test, "Low", low);
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
		
//		@Test(priority = 22) //Mved in all //Hide this dist due to locators changes (added performer login TC)
		void RiskSummaryCompliedGraphh() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph -Risk Summary - Complied - Count Verification");
			
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			LoginLocators.Search().sendKeys("AVACORED5");
			//LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
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
					All_Distributor_Methods.CompRiskGraph( test, "High", high);
				}
				else
				{
					test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
				}
				
				if(medium >= 0)
				{
					js.executeScript("window.scrollBy(0,300)");
					All_Distributor_Methods.CompRiskGraph( test, "Medium", medium);
				}
				else
				{
					js.executeScript("window.scrollBy(0,300)");
					test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+high);
				}
				
				if(low >= 0)
				{
					js.executeScript("window.scrollBy(0,300)");
					All_Distributor_Methods.CompRiskGraph( test, "Low", low);
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
		
		@Test(priority = 30) //Moved in all
		void RiskSummaryCompliedGraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph -Risk Summary - Complied - Count Verification");
			
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
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
		
		
		@Test(priority = 23) //Moved in all
		void Complied() throws InterruptedException, IOException
		{
			test = extent.startTest("Pie Chart - Performance summary - Complied - match verification");
			
		//	All_Distributor_Methods.Complied(test,"Distributor");
			MethodsD.Complied(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 24) Not Complied
		void NotComplied() throws InterruptedException, IOException
		{
			test = extent.startTest("Pie Chart - Performance summary - Not Complied - match verification");
			
			All_Distributor_Methods.NotComplied(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 25)
		void CompliedFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Pie Chart - Performance summary - Complied - Multiple filter verification");
			
		//	All_Distributor_Methods.CompliedFilter(test,"Distributor");
			MethodsD.CompliedFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		//Title: High Risk Summary - Complied - Multiple Filter verification
		@Test(priority = 26) //Moved similar in all
		void CompliedRiskSummaryGraphFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Pie Chart - Risk summary - Complied - Multiple filter verification");
			
		//	All_Distributor_Methods.CompliedRiskSummaryGraphFilter(test,"Distributor");
			MethodsD.CompliedRiskSummaryGraphFilter(test,"Distributor");
			MethodsD.CompliedHighRiskSummaryFilter(test, "Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 27) //Moved in all
		void ApplicableStatues() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify to check Applicable Statue is displayed or not?");
			
		//	All_Distributor_Methods.ApplicableStatues(test,"Distributor");
			MethodsD.ApplicableStatues(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 28) //Moved in all
		void DailyUpdate() throws InterruptedException, IOException
		{
			test = extent.startTest("Daily Update verification");
			
		//	All_Distributor_Methods.DailyUpdate(test,"Distributor");
			MethodsD.DailyUpdate(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
	
		


		
		
		@Test(priority = 29)
		void Report() throws InterruptedException, IOException
		{
			test = extent.startTest("Compliance Assignment Report ");
			
			All_Distributor_Methods.Report(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 30)
		void StatusReport() throws InterruptedException, IOException
		{
			test = extent.startTest("Status Report ");
			
			MethodsD.StatusReport(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 31)
		void VariousReport() throws InterruptedException, IOException
		{
			test = extent.startTest("Various Report ");
			
		//	All_Distributor_Methods.VariousReport(test,"Distributor");
			MethodsD.VariousReport(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 32)
		void CLRAAssignmentReport() throws InterruptedException, IOException
		{
			test = extent.startTest("CLRA Assignment Report");
			
			All_Distributor_Methods.CLRAAssignmentReport(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		//  --------------------My Documents-----------------
//		@Test(priority = 33) //Functionality Removed
		void MyDocumnent() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document - Add Registration Repository ");
			
			All_Distributor_Methods.MyDocumnent(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 34)
		void MyDocumnentExport() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document Export ");
			
			All_Distributor_Methods.MyDocumnentExport(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}

		
		@Test(priority = 35)
		void MyDocumentSearch() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document - search ");
			
			All_Distributor_Methods.MyDocumentSearch(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 36)
		void MyDocumnentDigitalSignature() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("My document - Digital Signature ");
			
		//	All_Distributor_Methods.MyDocumnentDigitalSignature(test,"Distributor");
			MethodsD.MyDocumnentDigitalSignature(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//Distributor Test Case 
		
		
		//------------------Manage Masters-------------------	
		
//		@Test(priority = 37) 
	   	void StateAdd() throws InterruptedException, IOException
	   	{
	   //	test = extent.startTest("Add State-City Master verification");
	   		test = extent.startTest("Manage Master - State City - Verify Add New Duplicate Error");
	   		
	   		All_Distributor_Methods.StateAdd(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	} 
		
		
		@Test(priority = 38)
	   	void StateAddInvalidLocationCode() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("State-City Master -Invalid Location Code verification");
	   		
	   		All_Distributor_Methods.StateAddInvalidLocationCode(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		@Test(priority = 39)
	   	void StateAddExistingCity() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("State-City Master -Existing City verification");
	   		
	   		
	   		All_Distributor_Methods.StateAddExistingCity(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 40)
	   	void StateExportBtn() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("State-City Master -Export Button verification");
	   		
	   		
	   		All_Distributor_Methods.StateExportBtn(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
//		@Test(priority = 41) Hide it due to master
	   	void UploadSealandSignature() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("State-City Master -Upload Seal and Signature verification");
	   		
	   		
	   		All_Distributor_Methods.UploadSealandSignature(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
//	     @Test(priority = 42) No Need to add
	   	void AddDesignation() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Add Designation master verification");
	   		
	   		
	   		All_Distributor_Methods.AddDesignation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
	     
		@Test(priority = 43)
	   	void DuplicateDesignation() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Duplicate Designation verification");
	   		
	   	//	All_Distributor_Methods.DuplicateDesignation(test, workbook);
	   		PerformerMethod.AddDesignation(test, workbook); //Common Method
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 44)
	   	void DesignationExportBtn() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Designation Master-Export Button verification");
	   		
	  // 	All_Distributor_Methods.DesignationExportBtn(test, workbook);
	   		PerformerMethod.DesignationExportBtn(test, workbook,"Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
	@Test(priority = 45) 
	   	void BulkUploadDesignation() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("Designation Master-Bulk Upload verification");
	   		
	   		
	   		All_Distributor_Methods.BulkUploadDesignation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
	    @Test(priority = 46) 
		void BulkUploadDesignationDetailes() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Designation Master-Bulk Upload designation Detailes verification");
			
			
			All_Distributor_Methods.BulkUploadDesignationDetailes(test, workbook);
			
			extent.endTest(test);
			extent.flush();

		}
	@Test(priority = 47)
	   	void DeleteDesignation() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Designation Master-Delete Designation verification");
	   		
	   		
	   		All_Distributor_Methods.DeleteDesignation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
			@Test(priority = 48)
	   	void DesignationClearBtn() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Designation Master-Clear Button verification");
	   		
	   		
	   		All_Distributor_Methods.DesignationClearBtn(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	} 
			
		
			
		//------------------------ OnBoard Entity--------------------------------//
	   //	--------------------Compliance Assignment-----------------------------
		@Test(priority = 49)
	   	void ComplianceAssignment() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad Entity-Compliance assignment -Register Compliance Type");
	   		
	   		All_Distributor_Methods.ComplianceAssignmentRegister(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 50)
	   	void ComplianceAssignmentReturn() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad Entity-Compliance assignment -Return Compliance Type");
	   		
	   		
	   		All_Distributor_Methods.ComplianceAssignmentReturn(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 51)
	   	void ComplianceAssignmentChallan() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad Entity-Compliance assignment -Challan Compliance Type");
	   		
	   		
	   		All_Distributor_Methods.ComplianceAssignmentChallan(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 52)
	   	void SearchBox() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad Entity-Compliance assignment -Search Box");
	   		
	   		
	   		All_Distributor_Methods.SearchBox(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 53)
	   	void ValidationMesssage() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad Entity-Compliance assignment -Without selecting Branch & Date");
	   		
	   		
	   		All_Distributor_Methods.ValidationMesssage(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 54)
	   	void WithoutselectingPerformerReviewer() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad Entity-Compliance assignment -Without selecting Performer & Reviewer");
	   		
	   		
	   		All_Distributor_Methods.WithoutselectingPerformerReviewer(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
	   	@Test(priority = 55)
	   	void Complianceactivationcancelbtn() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad Entity-Compliance assignment -Activation Popup -Cancel Button");
	   		
	   		
	   		All_Distributor_Methods.Complianceactivationcancelbtn(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
	   	
	   //------------------------------Manage Complaiance------------------------


	   	
		@Test(priority = 56)
	   	void ManageCompliance() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad Entity-Manage Compliance");
	   		
	   		
	   		All_Distributor_Methods.ManageCompliance(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 57) //Moved in all
	   	void ComplainceReassignment() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Onborad Entity - Manage Compliance-Compliance Reassignment");
	   		 
	   		All_Distributor_Methods.ComplainceReassignment(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 58)
	   	void ManageComplianceFilter() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad Entity-Manage Compliance-Filter Verification");
	   		
	   		
	   		All_Distributor_Methods.ManageComplianceFilter(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 59)
	   	void ActivationDateChange() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad Entity-Manage Compliance-Activation Date change");
	   		
	   		
	   		All_Distributor_Methods.ActivationDateChange(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
	@Test(priority = 59)
	   	void AssignmentRemoval() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad Entity-Manage Compliance-Assignment Removal");
	   		
	   		All_Distributor_Methods.AssignmentRemoval(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 60)
	   	void ScheduleCreation() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad Entity-Manage Compliance-Schedule Creation");
	   		
	   		
	   		All_Distributor_Methods.ScheduleCreation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 61)
	   	void WithoutSelctingFieldScheduleCreation() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad Entity-Manage Compliance-Schedule Creation-Without Selecting Filter");
	   		
	   		
	   		All_Distributor_Methods.WithoutSelctingFieldScheduleCreation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 62)
	   	void ScheduleRemoval() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad Entity-Manage Compliance-Schedule Removal");
	   		
	   		
	   		All_Distributor_Methods.ScheduleRemoval(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		//--------------------------------OnBoard CLRA---------------------------//
		
		@Test(priority = 63) //Moved in all
	   	void AddEmployer() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Add Employer verification");
	   		
	   		All_Distributor_Methods.AddEmployer(test, workbook, "Distributor Add New");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 64) //Moved in all
	   	void UpdateEmployer() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Update Employer verification");
	   		
	   		All_Distributor_Methods.UpdateEmployer(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 65) //Moved in all
	   	void DeleteEmployer() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Delete Employer verification");
	   		
	   		All_Distributor_Methods.DeleteEmployer(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 66) //Moved in all
	   	void HolidayMaster() throws Exception
	   	{
	   		test = extent.startTest("OnBorad CLRA-Upload Holiday Master verification");
	   		
	   		All_Distributor_Methods.HolidayMaster(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 67) //Moved in all
	   	void bulkUpload() throws Exception
	   	{
	   		test = extent.startTest("OnBorad CLRA-Bulk Upload verification");
	   		
	   		All_Distributor_Methods.bulkUpload(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 68) //Moved in all
	   	void EmployeerExportBtn() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Export Btn verification");
	   		
	   		All_Distributor_Methods.EmployeerExportBtn(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 69) //Moved in all
	   	void SearchBoxEmp() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Search Box verification");
	   		
	   		All_Distributor_Methods.SearchBoxEmp(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		
//		@Test(priority = 70) //Added similar 
	   	void AddLocation() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Add Location verification");
	   		
	   		All_Distributor_Methods.AddLocation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 70) //Moved in all
	   	void CLRA_AddLocation_Error() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Location - Verify to check add new error is displayed or not?");
	   		
	   		All_Distributor_Methods.CLRA_AddLocation_Error(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		@Test(priority = 71) //Added similar
	   	void editLOcation() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Update Location verification");
	   		
	   		
	   		All_Distributor_Methods.editLOcation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 72) //Added similar
	   	void UploadLocation() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Upload Location verification");
	   		
	   		All_Distributor_Methods.UploadLocation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 73)
	   	void LocationExportBtn() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Location-Export Btn verification");
	   		
	   		All_Distributor_Methods.LocationExportBtn(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		@Test(priority = 74) //if data is not reflecting run P70 
	   	void DeleteLocation() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Location-Delete Btn verification");
	   		
	   		
	   		All_Distributor_Methods.DeleteLocation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		@Test(priority = 75)
	   	void SearchBoxLocation() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Search Box location verification");
	   		
	   		All_Distributor_Methods.SearchBoxLocation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 76) //Added similar
	   	void Contractor() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Contractor verification");
	   		
	   		All_Distributor_Methods.Contractor(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 77)
	   	void EmpMapping() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Employee mapping verification");
	   		
	   		All_Distributor_Methods.EmpMapping(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		@Test(priority = 78)// added similar
	   	void UpdateEmpMapping() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Update Employee mapping verification");
	   		
	   		
	   		All_Distributor_Methods.UpdateEmpMapping(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		

		@Test(priority = 79) //added similar
	   	void ExportEmpMapping() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Update Export Btn Employee mapping verification");
	   		
	   		
	   		All_Distributor_Methods.ExportEmpMapping(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		//@Test(priority = 80)
	   	void deleteEmpMapping() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Delete Employee mapping verification");
	   		
	   		
	   		All_Distributor_Methods.deleteEmpMapping(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 81) //Moved similar
	   	void ComplianceAssignmentRegisterCLRA() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Registor-Compliance Assignment verification");
	   		
	   		
	   		All_Distributor_Methods.ComplianceAssignmentRegisterCLRA(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 82)
	   	void ComplianceAssignmentRetrunCLRA() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Return-Compliance Assignment verification");
	   		
	   		
	   		All_Distributor_Methods.ComplianceAssignmentRetrunCLRA(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		@Test(priority = 83)
	   	void SearchBoxComplianceAssignment() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Compliance assignment -Search Box");
	   		
	   		
	   		All_Distributor_Methods.SearchBoxComplianceAssignment(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
	   	
		@Test(priority = 84)
	   	void ManageComplianceCLRA() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Manage Compliance");
	   		
	   		
	   		All_Distributor_Methods.ManageComplianceCLRA(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
//		@Test(priority = 85)//Peninding moved simliar
	   	void ComplainceReassignmentCLRA() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Manage Compliance-Compliance Reassignment");
	   		 
	   		All_Distributor_Methods.ComplainceReassignmentCLRA(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		//@Test(priority = 86)//Peninding
	   	void ManageComplianceFilterCLRA() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Manage Compliance-Filter Verification");
	   		
	   		
	   		All_Distributor_Methods.ManageComplianceFilterCLRA(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 87)
	   	void ActivationDateChangeCLRA() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Manage Compliance-Activation Date change");
	   		
	   		
	   		All_Distributor_Methods.ActivationDateChangeCLRA(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
	    @Test(priority = 88) //added similar
	   	void AssignmentRemovalCLRA() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Manage Compliance-Assignment Removal");
	   		
	   		
	   		All_Distributor_Methods.AssignmentRemovalCLRA(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	
		@Test(priority = 89)
	   	void ScheduleCreationCLRA() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Manage Compliance-Schedule Creation");
	   		
	   		
	   		All_Distributor_Methods.ScheduleCreationCLRA(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 90)
	   	void WithoutSelctingFieldScheduleCreationCLRA() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Manage Compliance-Schedule Creation-Without Selecting Filter");
	   		
	   		
	   		All_Distributor_Methods.WithoutSelctingFieldScheduleCreationCLRA(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		@Test(priority = 91)
	   	void ScheduleRemovalCLRA() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Manage Compliance-Schedule Removal");
	   		
	   		
	   		All_Distributor_Methods.ScheduleRemovalCLRA(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		
		
		
		@Test(priority = 1)
		void User() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether user button is clickable or not.");
			
			Methods.User(test);
			
			extent.endTest(test);
			extent.flush();
		}

		
		
//		@Test(priority = 2) Hide this not required
		void UserAddNew() throws InterruptedException, IOException
		{
			test = extent.startTest("Validadte Add New Button of User Master Page");
			
			Methods.UserAddNew(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 3) Hide this not required
		void UserEdit() throws InterruptedException, IOException
		{
			test = extent.startTest("Validadte Edit Button of User Master Page");
			
			Methods.UserEdit(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 4) Hide this
		void UserEditInvalid() throws InterruptedException, IOException
		{
			test = extent.startTest("Validadte Edit Button of User Master with Invalid Data");
			
			Methods.UserEditInvalid(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 5) //find search added
		void SearchUser() throws InterruptedException, IOException
		{
			test = extent.startTest("validadte User Dropdown of User Master Page");
			
			Methods.SearchUser(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 6)
		void SearchUserClear() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate Clear Button of User Master Page");
			
			Methods.SearchUserClear(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 7) Hide this not required
		void UserDelete() throws InterruptedException, IOException
		{
			test = extent.startTest(" Validate Delete Button of User Master Page With No Compliances Assign");
			
			Methods.UserDelete(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 8) //
		void UserDeleteAssign() throws InterruptedException, IOException
		{
			test = extent.startTest(" Validate Confirmation Message Of Delete Button for User With Compliances Assigned from User Master Page");
			
			Methods.UserDeleteAssign(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 9) Hide this
		void UserDeleteCancel() throws InterruptedException, IOException
		{
			test = extent.startTest(" Validate 'Cancel' Button of Delete User from User Master Page");
			
			Methods.UserDeleteCancel(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 10) 
		void UserBack() throws InterruptedException, IOException
		{
			test = extent.startTest(" Validate Back Button of User Master Page");
			
			Methods.UserBack(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 11) //21/01/2025
		void ExportUser() throws InterruptedException, IOException
		{
			test = extent.startTest(" To check whether user is excel is getting downloaded or not");
			
			Methods.ExportUser(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	///////--------------------------Corporate -------------------------------------------///////////////////////
		
		@Test(priority = 12)
		void Corporate() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate Home Page Corporate button");
			
			Methods.Corporate(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 13) //Me Hide due to cant add more corporates
		void CorporateAddNew() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate Corporate Page Add new customer.");
			
			Methods.CorporateAddNew(test);
			
			extent.endTest(test);
			
			extent.flush();
		}
		
//		@Test(priority = 14) Hide this
		void CorporateEdit() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate Corporate Page Edit customer with valid details.");
			
			Methods.CorporateEdit(test);
			
			extent.endTest(test);
			
			extent.flush();
		}
		
//		@Test(priority = 15)
		void CorporateEditInvalid() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate Corporate Page Edit customer with invalid details");
			
			Methods.CorporateEditInvalid(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 16) 
		void SearchCorporate() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate Corporate Page Customer search dropdown");
			
			Methods.SearchCorporate(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 17) 
		void SearchCorporateClear() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate Corporate Page Clear button.");
			
			Methods.SearchCorporateClear(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 18) Hide this
		void corporateDelete() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate Corporate Page Delete customer 'OK' button");
			
			Methods.corporateDelete(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 19)
		void CorDeleteCancel() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate Corporate Page Delete customer 'Cancel' button.");
			
			Methods.CorDeleteCancel(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 20)//22/01/2025
		void CorporateView() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate Corporate Page View Entity button.");
			
			Methods.CorporateView(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 21)
		void CorporateBack() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate Corporate Page Back button");
			
			Methods.CorporateBack(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//--------------------------Entity --------------------------
		
		@Test(priority = 22) //23/01/2024
		void Entity() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether entity tab is clickable or not");
			
			Methods.Entity(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	//	@Test(priority = 23) //Change in labour1 sheet Entity Name line 18
		void EntityAddNew() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Add new entity Button With valid data.");
			
			Methods.EntityAddNew(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 24) Hide
		void EntityEdit() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate Entity Page Entity Edit Button With Valid Data.");
			
			Methods.EntityEdit(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 25) 
		void EntityEditinvalid() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate Entity Page Entity Edit Button With Invalid Data.");
			
			Methods.EntityEditinvalid(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 26) 
		void SearchCustomer() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether customer name drop down is working or not");
			
			Methods.SearchCorporate(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		//@Test(priority = 27) 
		void SearchEntity() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether entity drop down is working or not");
			
			Methods.SearchEntity(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 28) 
		void SearchEntityClear() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate entity Page Clear button.");
			
			Methods.SearchEntityClear(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 29)
		void EntityDeleteCancel() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate entity Page Delete customer 'Cancel' button.");
			
			Methods.EntityDeleteCancel(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 30) Hide this
		void EntityDelete() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether entity is getting deleted or not");
			
			Methods.EntityDelete(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 31)
		void EntityBulkUpload() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Entity Page Entity upload with valid details.");
			
			Methods.EntityBulkUpload(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 32) //24/01/2025
		void EntityBulkUploadInvalid() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Entity Page Entity upload with Invalid details.");
			
			boolean text	=	Methods.EntityBulkUploadInvalid(test);
			if(text==true)
			{
				test.log(LogStatus.PASS, "Error text file should get downloaded with proper error message along with row number.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Failure : Error file does not downloaded.");
			}
			  
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 33)//pass
		void EntityBulkUploadCheck() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate message for valid file upload in selected(Checkbox) Entity functionality.");
			
			Methods.EntityBulkUploadCheck(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 34)
		void EntityBulkUploadInvalidCheck() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate error message and error file download for Invalid data file upload in selected(checkbox) Entity functionality.");
			
				Methods.EntityBulkUploadInvalidCheck(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 35)
		void EntityBulkUploadCheckB() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate error message for empty file upload in selected(checkbox) Entity functionality.");
			
			Methods.EntityBulkUploadCheckB(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 36)
		void ResetBtn() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("To check whether reset button is working or not");
			
			Methods.ResetBtn(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 37)
		void AllCheckbox() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("To check whether all check boxes are getting selected or not");
			
			Methods.AllCheckbox(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 38) 
		void EntityBack() throws InterruptedException, IOException
		{
			test = extent.startTest(" Validate Back Button of Entity Page");
			
			Methods.EntityBack(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 39) 
		void EntityLocation() throws InterruptedException, IOException
		{
			test = extent.startTest(" To check whether EntityLocation excel is getting downloaded or not");
			
			Methods.EntityLocation(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 40) 
		void EntityExcel() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether Entity excel is getting downloaded o not");
			
			Methods.EntityExcel(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 41) 
		void Searchentities() throws InterruptedException, IOException
		{
			test = extent.startTest("Validate Entities search dropdown");
			
			Methods.Searchentities(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	///////--------------------------Onboard Entity - Premises -------------------------------------------///////////////////////
		
		@Test(priority = 42 , groups = {"Smoke"}) //25/01/2025
		void EntityBranchAddNew() throws InterruptedException, IOException
		{
			test = extent.startTest("To check whether add new premise button is working or not");
			
			Methods.EntityBranchAddNew(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 43) //Moved in all
		void ExportPremises() throws InterruptedException, IOException
		{
			test = extent.startTest("Premise Export Button");
			
			Methods.ExportPremises(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 44) //27/01/2025
		void UploadBranch() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Branch Upload With Valid Datails from onboard entity.");
			
			Methods.UploadBranch(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 45)
		void UploadBranchInvalid() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Branch Upload With inValid Datails from onboard entity.");
			
			boolean text	=	Methods.UploadBranchInvalid(test);
			if(text==true)
			{
				test.log(LogStatus.PASS, "Error text file should get downloaded with proper error message along with row number.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Failure : Error file does not downloaded.");
			}
			  
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 46) 
		void UploadBranchEmpty() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("To check whether error message display or not for empty file upload from premise master..");
			
			Methods.UploadBranchEmpty(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 46)
		void UploadBranchCheck() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Upload Selected(Checkbox) Location with Valid Datails of premise tab from onboard entity.");
			
			Methods.UploadBranchCheck(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 47)
		void UploadInvalidCheck() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Upload Selected(Checkbox) Location with Invalid Datails.");
			
				Methods.UploadInvalidCheck(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 48) //Pass
		void UploadBranchCheckEmpty() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Upload Selected(Checkbox) Location with Empty File");
			
				Methods.UploadBranchCheckEmpty(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 49) //Pass
		void UploadBranchInvalidTemp() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("To check whether error message display or not for invalid template file upload from premise upload.");
			
				Methods.UploadBranchInvalidTemp(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 50)
		void UploadBranchInvalidFormate() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate error message for the invalid formate file upload in bulk upload from premise master.");
			
			Methods.UploadBranchInvalidFormate(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 51)//Pass
		void Upload() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate validation message for the no choose file button from bulk upload of premise master.");
			
				Methods.Upload(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 52) 
		void UploadBranchCheckInvalidTemp() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate error message displayed for invalid template file upload in selected(CheckBox) location from premise master.");
			
				Methods.UploadBranchCheckInvalidTemp(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 53)
		void UploadBranchCheckInvalidFormate() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("validate error message displayed for invalid formate file upload in selected(Check box) location from premise master.");
			
				Methods.UploadBranchCheckInvalidFormate(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 54)
		void UploadCheck() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate validation message displayed for choose file button in selected(CheckBox) location from premise master.");
			
				Methods.UploadCheck(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 55)
		void UploadAddMapping() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Sample Document download of address mapping upload from premise master.");
			
				Methods.UploadAddMapping(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 56)
		void MUploadAddMapping() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate master document file download of address mapping upload from premise master.");
			
				Methods.MUploadAddMapping(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 57)
		void UploadAddressMap() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("To check whether valid address mapping file upload or not from premise master.");
			
				Methods.UploadAddressMap(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 58)
		void UploadAddressMapEmpty() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate error message for empty file upload in address mapping upload from premise master.");
			
				Methods.UploadAddressMapEmpty(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 59)
		void UploadAddInvalid() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate error message and error file download for address mapping upload from premise master with invalid data file.");
			
			boolean text	=	Methods.UploadAddInvalid(test);
			if(text==true)
			{
				test.log(LogStatus.PASS, "Error text file should get downloaded with proper error message along with row number.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Failure : Error file does not downloaded.");
			}
			  
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 60) 
		void UploadAddInvalidTemp() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate error message for the invalid template file upload in address mapping upload from premise master.");
			
				Methods.UploadAddInvalidTemp(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 61)
		void UploadAddInvalidFormate() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("To check whether error message display or not for invalid file formate upload from authority address mapping upload of premise master.");
			
				Methods.UploadAddInvalidFormate(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 62)
		void UploadADD() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate validation message for the no choose file button from bulk upload of premise master.");
			
				Methods.UploadADD(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 63)
		void SearchBranch() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("To check whether search field (branch) is working or not");
			
				Methods.SearchBranch(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 64)
		void BDeleteCancel() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Delete Branch 'Cancel' Button");
			
				Methods.BDeleteCancel(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 65)
		void branchDelete() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("To check whether branch is getting deleted or not");
			
				Methods.branchDelete(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
	///////--------------------------Onboard Entity - Paycode Mapping -------------------------------------------///////////////////////
		
//		@Test(priority = 66) //28/01/2025 //Not able to add this (Similar added)
		void PayCodeAddNew() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Onboard Entity Add New Paycode With Valid Data");
			
				Methods.PayCodeAddNew(test);
			
			extent.endTest(test);
			extent.flush();
		}
		  
		@Test(priority = 67) 
		void PayCodeAddNewInvalid() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Onboard Entity Add new Paycode With Invalid Data");
			
				Methods.PayCodeAddNewInvalid(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 68) //Moved in all
		void PayCodeEdit() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Onboard Entity Paycode 'Edit' Button.");
			
			Methods.PayCodeEdit(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 69) 
		void UploadPaycode() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Onboard Entity Paycode Upload with Valid Data.");
			
				Methods.UploadPaycode(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 70)
		void UploadPaycodeInvalid() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Onboard Entity Paycode Upload with Invalid Data.");
			
			boolean text	=	Methods.UploadPaycodeInvalid(test);
			if(text==true)
			{
				test.log(LogStatus.PASS, "Error text file should get downloaded with proper error message along with row number.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Failure : Error file does not downloaded.");
			}
			  
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 71)
		void UploadPaycodeEmpty() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Onboard Entity Paycode Upload with Empty File.");
			
				Methods.UploadPaycodeEmpty(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 72)
		void SearchPaycode() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate searchbox Apply Button Of Paycode Mapping Tab from Onboard Entity Module");
			
				Methods.SearchPaycode(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 73)
		void SearchPaycodeClear() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Onboard Entity's Paycode Mapping Clear Button");
			
			Methods.SearchPaycodeClear(test);
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 74)
		void PaycodeDeleteCancel() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Delete Paycode Mapping 'Cancel' Button");
			
			Methods.PaycodeDeleteCancel(test);
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 75)
		void PaycodeDelete() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("To check whether Paycode Mapping is getting deleted or not");
			
				Methods.PaycodeDelete(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
	///////--------------------------Onboard Entity - User-Branch Mapping -------------------------------------------///////////////////////

		@Test(priority = 76) //29/01/2025 //Moved in all
		void Mapuser() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("To check whether map user button is working or not");
			
			Methods.Mapuser(test);
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 77) 
		void Mapuseralready() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate error massage when  Existing user and branch mapping data which is already mapped to map user is working or not");
			
				Methods.Mapuseralready(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 78)
		void MapuserManagement() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("To check whether map user(management) button is working or not");
			
				Methods.MapuserManagement(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 79)
		void MapuserManagementAlredy() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate error massage when Existing user and branch mapping data which is already mapped to map user(management) is working or not");
			
				Methods.MapuserManagementAlredy(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 80)
		void UserMapDelete() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("To check whether mapping is getting deleted or not");
			
				Methods.UserMapDelete(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 81)
		void MapuserDeleteCancel() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Delete User Mapping 'Cancel' Button working or not");
			
				Methods.MapuserDeleteCancel(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 82)
		void UserMapFilter() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("To check whether  User Mapping apply button is working or not");
			
				Methods.UserMapFilter(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 83)
		void UserMapFilterClear() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("To check whether  User Mapping clear button is working or not.");
			
				Methods.UserMapFilterClear(test);
			
			  
			extent.endTest(test);
			extent.flush();
			
		}
		
	///////--------------------------Manage Masters - Leave Type -------------------------------------------///////////////////////
		
		@Test(priority = 84) //25/02/2025
		void Exportleavetype() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Manage Masters - Leave Type - To check whether excel is getting downloaded or not");
			
				Methods.Exportleavetype(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 85) //25/02/2025
		void Searchleave() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Manage Masters - Leave Type - To check whether search field is working or not");
			
				Methods.Searchleave(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 86) //25/02/2025
		void SearchleaveClear() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Manage Masters - Leave Type - To check whether search field clear or not");
			
				Methods.SearchleaveClear(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
	///////--------------------------Manage Masters - Paycode Mapping -------------------------------------------///////////////////////
		
		@Test(priority = 87) //25/02/2025
		void PayCodeAddNewMM() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Manage Masters - Validate Add New Paycode With Valid Data");
			
				Methods.PayCodeAddNewMM(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 88) 
		void PayCodeAddNewInvalidMM() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Manage Masters - Validate Add new Paycode With Invalid Data");
			
				Methods.PayCodeAddNewInvalidMM(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 89) 
		void PayCodeEditMM() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Manage Masters - Validate Paycode 'Edit' Button.");
			
				Methods.PayCodeEditMM(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 90) //2 test cases//26/02/2025
		void UploadPaycodeMM() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Manage Masters - Validate  Paycode Upload with Valid Data.");
			
				Methods.UploadPaycodeMM(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 91)
		void UploadPaycodeInvalidMM() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Manage Masters Paycode Upload with Invalid Data.");
			
			boolean text	=	Methods.UploadPaycodeInvalidMM(test);
			if(text==true)
			{
				test.log(LogStatus.PASS, "Error text file should get downloaded with proper error message along with row number.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Failure : Error file does not downloaded.");
			}
			  
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 92)
		void UploadPaycodeEmptyMM() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Manage Masters Paycode Upload with Empty File.");
			
				Methods.UploadPaycodeEmptyMM(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 93)
		void UploadPaycodeforMM() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Manage Masters Paycode Upload with Invalid formate File.");
			
				Methods.UploadPaycodeforMM(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 94)
		void UploadPaycodeNoMM() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Manage Masters Paycode Upload with without selecting File.");
			
				Methods.UploadPaycodeNoMM(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 95)
		void SearchPaycodeMM() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate searchbox Apply Button Of Paycode Mapping Tab from Manage Masters Module");
			
				Methods.SearchPaycodeMM(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 96)
		void SearchPaycodeClearMM() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Validate Manage Masters Paycode Mapping Clear Button");
			
				Methods.SearchPaycodeClearMM(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 97)
		void PaycodeDeleteCancelMM() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Manage Masters - Delete Paycode Mapping 'Cancel' Button");
			
				Methods.PaycodeDeleteCancelMM(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 98)
		void PaycodeDeleteMM() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Manage Masters - To check whether Paycode Mapping is getting deleted or not");
			
				Methods.PaycodeDeleteMM(test);
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
	///////--------------------------Manage Masters - Statutory Master -------------------------------------------///////////////////////
		
		@Test(priority = 99) 
		void ExportSM() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Manage Masters -Statutory Master - Challan - To check whether excel is getting downloaded or not");
			
				Methods.ExportSM(test,"Challan");
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 100) 
		void ExportSM1() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Manage Masters -Statutory Master - Register - To check whether excel is getting downloaded or not");
			
				Methods.ExportSM(test,"Register");
			
			  
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 101) 
		void ExportSM2() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Manage Masters -Statutory Master - returns - To check whether excel is getting downloaded or not");
			
				Methods.ExportSM(test,"returns");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 102) 
		void SearchSMMM() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Manage Masters -Statutory Master - Validate searchbox Apply Button  from Manage Masters Module");
			
				Methods.SearchSMMM(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 103) 
		void SearchSMClear() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Manage Masters -Statutory Master - Validate Clear Button");
			
				Methods.SearchSMClear(test);
			
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
