package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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

import clientPortal.All_ClientPortal_Methods;
import distributor.All_Distributor_Methods;
import distributor.MethodsD;
import login.BasePage;
import login.LoginLocators;
import performer.LocatorsP;
import performer.MethodsP;
import performer.PerformerMethod;
import rcp.ChangePassMethod;
import rcp.OneCommonMethod;
import reviewer.ReviewerMethod;



public class All_Performer_TestCases extends BasePage{

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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\PerformerAll.html",true);
		test = extent.startTest("Loging In - Performer");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		Initialization(link,1,"Statutory");
		
		
		XSSFSheet sheet = ReadExcel(count);
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String URL = c1.getStringCellValue();			//Got the URL stored at position 0,1
	
		Row row1 = sheet.getRow(1);						//Selected 1st index row (Second row)
		Cell c2 = row1.getCell(1);						//Selected cell (1 row,1 column)
		String uname = c2.getStringCellValue();			//Got the URL stored at position 1,1
		
		Row row2 = sheet.getRow(2);						//Selected 2nd index row (Third row)
		Cell c3 = row2.getCell(1);						//Selected cell (2 row,1 column)
		String password = c3.getStringCellValue();		//Got the URL stored at position 2,1
	
	
	}
	


	
	@Test(priority = 1) 
	void CompanyLogo() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check after performer login TeamLease RegTech Logo is displayed or not?");
		
		MethodsD.CompanyLogo(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 2) 
	void Logout() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify Logout link is working or not");
		
		MethodsD.Logout(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
//		@Test(priority = 3) 
		void ChangePassWithInvalidCurrentPass() throws InterruptedException, IOException
		{
			test = extent.startTest("Change Password - Verify to change password with invalid scenarios");
				
			ChangePassMethod.ChangePassWithInvalidCurrentPass(test,"Reviewer");
				
			extent.endTest(test);
			extent.flush();
		}	
	
	
	@Test(priority = 4) 
	void ChangePass() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check user is redirecting to Entity Page or not on clicking to 'Click here to go back' link");
		
		MethodsD.ChangePass(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 5) 
	void EntitiesSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("Entities - Verify to Entity Search field is working fine");
		
		MethodsD.EntitiesSearch(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//NEED TO ADD HERE CORPORATE TEST CASES---
	
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
	
	
	
	@Test(priority = 9) //Bilal 
	void EntityExcelDownload() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check Entity Locations & Entity Files are downloading or not?");
		
		MethodsD.EntityExcelDownload(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 9) 
	void anchorDashboardSummary() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check Entity Locations & Entity Files are downloading or not?");
		
		MethodsD.anchorDashboardSummary(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 10)//Bilal
	void PortalLogin() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check user is redirecting to client portal or not through portal login");
		
		MethodsD.PortalLogin(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	

	//Started Dashboard below--
	
	//Compliance box - Verify Compliance count, Export button and Overview button are working properly or not
	@Test(priority = 11)
	void ComplianceBox() throws InterruptedException, IOException
	{
		test = extent.startTest("Dashboard - Count by Clicking on 'Compliance'");
		
		MethodsD.complianceBox(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 12) 
	void ComplianceFilter1() throws InterruptedException, IOException
	{
		test = extent.startTest(" Compliance Box Filter Verification'");
		
		MethodsD.ComplianceFilter1(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//Upcoming box - Verify Upcoming box count, Export button, Overview button and Branch Code Filters are working or not
	@Test(priority = 13)
	void UpcomingBox() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on 'Upcoming'");
		
		MethodsD.UpcomingBox(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 14)
	void UpcomingFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Upcoming Box Filter Verification'");
		
		MethodsD.UpcomingFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//Overdue box - Verify Overdue count, Export button and Overview button is working properly or not?
	@Test(priority = 15)
	void OverdueBox() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on 'Overdue'");
		
		MethodsD.OverdueBox(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 16) 
	void OverdueFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Overdue Box Filter Verification'");
		
		MethodsD.OverdueFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17) 
	void overdueRedirectionWorkspace() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify Overdue - view redirection to workspace button is working correctly");
		
		MethodsD.overdueRedirectionWorkspace(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	//Pending Action - Verify Pending Action count, Export button, Overview button and Branch code is working fine or not
	@Test(priority = 18)
	void PendingActionBox() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on 'Pending Action'");
		
		MethodsD.PendingActionBox(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 19)
	void PendingActionFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Pending Action Box Filter Verification'");
		
		MethodsD.PendingActionFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	//Need to discuss with sir we can hide this due to data will not come
//	@Test(priority = 20)
	void PendingActionPerform() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Action perform from pending action'");
		
		MethodsD.PendingActionPerform(test,"Reviewer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 20)
	void PendingReviewBox() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on 'Pending Review'");
		
		MethodsD.PendingReviewBox(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 21)
	void PendingReviewFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Pending Review Box Filter Verification'");
		
		MethodsD.PendingReviewFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 22)
	void RegisterUpcoming() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Register - 'Upcoming'");
		
		MethodsD.RegisterUpcoming(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 23) 
	void RegisterOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on Register - 'Overdue'");
		
		MethodsD.RegisterOverdue(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 24) 
	void RegisterOverdueFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Register - Overdue Filter Verification");
		
		MethodsD.RegisterOverdueFilter2(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 26)
	void ReturnUpcoming() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on Returns - 'Upcoming'");
		
		MethodsD.ReturnUpcoming(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 27) 
	void ReturnUpcomingFilter2() throws InterruptedException, IOException
	{
		test = extent.startTest("Returns - Upcoming Filter Verification");
		
		MethodsD.ReturnUpcomingFilter2(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 28) 
	void ReturnOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on Returns - 'Overdue'");
		
		MethodsD.ReturnOverdue(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 29) 
	void ReturnOverdueFilter2() throws InterruptedException, IOException
	{
		test = extent.startTest("Returns - Overdue Filter Verification");
		
		MethodsD.ReturnOverdueFilter2(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 30) 
	void ReturnAction() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on Returns - 'Action'");
		
		MethodsD.ReturnAction(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 31) // need to modify according to entity
	void ReturnActionFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Returns - Action Filter Verification");
		
		MethodsD.ReturnActionFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 32) 
	void ChallanUpcoming() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on Challans - 'Upcoming'");
		
		MethodsD.ChallanUpcoming(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 33) 
	void challanUpcomingFilters() throws InterruptedException, IOException
	{
		test = extent.startTest("Challan - Upcoming Filter Verification");
		
		MethodsD.challanUpcomingFilters(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 34) 
	void ChallanOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on Challans - 'Overdue'");
		
		MethodsD.ChallanOverdue(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 35) 
	void challanOverdueFilters() throws InterruptedException, IOException
	{
		test = extent.startTest("Challan - Overdue Filter Verification");
		
		MethodsD.challanOverdueFilters(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 35)// NEW TC NEW TC
	void Complied() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Performance summary - Complied - match verification");
		
		MethodsD.Complied(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 36) 
	void ChallanAction() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on Challans - 'Actions'");
		
		MethodsD.ChallanAction(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 37) 
	void challanActionsFilters() throws InterruptedException, IOException
	{
		test = extent.startTest("Challan - Actions Filter Verification");
		
		MethodsD.challanActionsFilters(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 39) 
	void RiskSummaryNotCompliedGraph() throws InterruptedException, IOException
	{
		test = extent.startTest("Bar Graph -Risk Summary - Not Complied - Count Verification");
		
		WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	//	LoginLocators.Search().sendKeys("WWKRG");
		LoginLocators.Search().sendKeys("TESTAUTO2");
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO2");
		
		Thread.sleep(5000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
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
		int high = Integer.parseInt(LocatorsP.HighRisk1().getText());	//Reading Dashboard count.
		int medium = Integer.parseInt(LocatorsP.MediumRisk1().getText());	//Reading Dashboard count.
		int low = Integer.parseInt(LocatorsP.LowRisk1().getText());	//Reading Dashboard count.
		
		Thread.sleep(500);
		
			if(high >= 0)
			{
				//Methods.HighRisk(test);
				MethodsP.RiskGraph( test, "High", high);
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				js.executeScript("window.scrollBy(0,300)");
				MethodsP.RiskGraph( test, "Medium", medium);
			}
			else
			{
				js.executeScript("window.scrollBy(0,300)");
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+high);
			}
			
			if(low >= 0)
			{
				js.executeScript("window.scrollBy(0,300)");
				MethodsP.RiskGraph( test, "Low", low);
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
	
	
	
	
	
	
	@Test(priority = 40)
	void RiskSummaryCompliedGraph() throws InterruptedException, IOException
	{
		test = extent.startTest("Bar Graph -Risk Summary - Complied - Count Verification");
		
		WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(120));
		Thread.sleep(5000);Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
//		LoginLocators.Search().sendKeys("TESTAUTO2");
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO2");
		
		//LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(7000);Thread.sleep(5000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(5000);
		LoginLocators.SelectPeriodValue2024().click();
		Thread.sleep(2000);
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
			Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 41) //Bilal
	void CompliedHighRiskSummaryFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("High Risk Summary - Complied - Multiple Filter verification");
		
		MethodsD.CompliedHighRiskSummaryFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 42) //Bilal
	void CompliedMediumRiskSummaryFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Medium Risk Summary - Complied - Multiple Filter verification");
		
		MethodsD.CompliedMediumRiskSummaryFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 43) //Bilal
	void CompliedLowRiskSummaryFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Low Risk Summary - Complied - Multiple Filter verification");
		
		MethodsD.CompliedLowRiskSummaryFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 45) 
	void abstractSummary() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check - Abstract Summary verifiction displaying correctly");
		MethodsD.abstractSummary(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 46) 
	void ApplicableStatues() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check Applicable Statue is displayed or not?");
		
		MethodsD.ApplicableStatues(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 47) 
	void DailyUpdate() throws InterruptedException, IOException
	{
		test = extent.startTest("Daily Update verification");
		
		MethodsD.DailyUpdate(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}

	
	//---Manage Masters---
	
	@Test(priority = 50) //Bilal
   	void StateCitySearch() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Manage Master - State City - Verify to check Search State/Location Code dropdown is working or not");
   		
   		PerformerMethod.StateCitySearch(test, workbook, "Performer");
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 50) 
   	void authorityAddressUpload() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Manage Master - State City - Verify to check Authority address upload working or not");
   		
   		PerformerMethod.authorityAddressUpload(test, workbook, "Performer");
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 52) 
   	void DesignationSearch() throws InterruptedException, IOException
   	{
        test = extent.startTest("Manage Master - Designation - Verify to check Search/Select Designation dropdown is working or not");
   		PerformerMethod.DesignationSearch(test, workbook , "Performer");
   		
   		test = extent.startTest("Manage Master - Designation - Verify to check Active/InActive filters are working or not");
   		PerformerMethod.designationActiveInActive(test , "Performer");

   		extent.endTest(test);
   		extent.flush();
   	}
	
    @Test(priority = 52)
   	void AddDesignation() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Master - Designation - Verify Add New Designation Error is throwing or not?");
   		
   		PerformerMethod.AddDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 53) //Fail
   	void DesignationExportBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Designation Master-Export Button verification");
   		
   		PerformerMethod.DesignationExportBtn(test, workbook,"Performer");
   		
   		extent.endTest(test);
   		extent.flush();
   	}
    
    @Test(priority = 54) //Pass
   	void DeleteDesignation() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Manage Master - Designation - Verify to Delete/Inactive Designation");
   		
   		PerformerMethod.DeleteDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
    
	@Test(priority = 55)
   	void DesignationClearBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Designation Master-Clear Button verification");
   		
   		PerformerMethod.DesignationClearBtn(test, workbook, "Performer");
   		
   		extent.endTest(test);
   		extent.flush();
   	}
    
	@Test(priority = 56) //Bilal 
   	void LeaveTypeSearch() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Master - Leave Type - Verify to check Search Leave Type dropdown is working or not?");
   		   		
   		PerformerMethod.LeaveTypeSearch(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 56) 
   	void leaveTypeExport() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Manage Master - Leave Type - Verify to check Export button working or not");
   		
   		PerformerMethod.leaveTypeExport(test, workbook, "Performer");
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 57) //Bilal
   	void PaycodeMappingSearchField() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check search field is working or not?");
   		   		
   		PerformerMethod.PaycodeMappingSearchField(test, workbook,"Performer");

   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 58) //Bilal
   	void PaycodeMappingAddNew() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check Add New error is displayed or not?");
   		   		
   		PerformerMethod.PaycodeMappingAddNew(test, workbook, "Performer");

   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 59) //Bilal
   	void PaycodeMappingEditUpdate() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check paycode is editable or not?");
   		   		
   		PerformerMethod.PaycodeMappingEditUpdate(test, workbook, "Performer");

   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 60) //Bilal 
   	void PaycodeMappingUpload() throws InterruptedException, IOException, AWTException
   	{
test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check paycode Upload or not?");
   		   		
   		PerformerMethod.PaycodeMappingUpload(test, workbook, "Performer");

   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 61) //Bilal 
   	void PaycodeMappingUploadInvalid() throws InterruptedException, IOException, AWTException
   	{
test = extent.startTest("Manage Masters - Paycode Mapping - Verify to upload invalid file which contains special characters error message is displayed or not?");
   		   		
   		PerformerMethod.PaycodeMappingUploadInvalid(test, workbook, "Performer");

   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 62) //Bilal
   	void MastersStaturyDoc() throws InterruptedException, IOException, AWTException
   	{
test = extent.startTest("Manage Masters - Statutory Master - Verify to check Exports with all Compliance Types are working or not?");
   		   		
   		PerformerMethod.MastersStaturyDoc(test, workbook, "Performer");

   		extent.endTest(test);
   		extent.flush();
   	}
	
//	@Test(priority = 63) //Bilal  hide this due to in PT Location data is not reflecting
   	void ChallanPTSlab() throws InterruptedException, IOException, AWTException
   	{
test = extent.startTest("Manage Masters - Challan PT Slab - Verify the Employee is mapping or not?");
   		   		
   		PerformerMethod.ChallanPTSlab(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	
   	


	//Part 2

 /**

   	
   	//Onboard Employee:--
   	
//   @Test(priority = 100)
 	void SearchFilerEmp() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Onboard Employee - Search filter verification");
 		
 		PerformerMethod.SearchFilerEmp(test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
    @Test(priority = 100) // NEW TC need to remove : SearchFilerEmp
 	void employeeFilters() throws InterruptedException, IOException
 	{
 		test = extent.startTest("Onboard Employee - Manage Employee - Verify to check employee search filters are working correctly");
 		
 		PerformerMethod.employeeFilters(test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
    //For test checking
//    @Test(priority = 101)
//   	void AddEmployeeLocatorChaining() throws InterruptedException, IOException, AWTException
//   	{
//   		test = extent.startTest("Onboard Employee - Add Employee verification");
//   		
//   		PerformerMethod.AddEmployeeLocatorChaining(test);
//   		
//   		extent.endTest(test);
//   		extent.flush();
//   	}
    @Test(priority = 101)
   	void AddEmployee() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("Onboard Employee - Add Employee verification");
   		
   		PerformerMethod.AddEmployee(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
    
    @Test(priority = 110) 
    void employeeBulkUpload() throws Exception
    {
    	test = extent.startTest("Onboard Employee - Verify to check bulk upload functionalities working correctly");
    	
    	PerformerMethod.employeeBulkUpload(test);
    	
    	extent.endTest(test);
    	extent.flush();

    }
    
    @Test(priority = 110) 
    void employeeBulkUploadHistory() throws Exception
    {
    	test = extent.startTest("Onboard Employee - Bulk Upload - Verify to download file from history button");
    	
    	PerformerMethod.employeeBulkUploadHistory(test);
    	
    	extent.endTest(test);
    	extent.flush();

    }
    
    
    @Test(priority = 110) 
    void employeeEdit() throws InterruptedException, IOException, AWTException
    {
    	test = extent.startTest("Onboard Employee - Manage Employee - Verify to check edit button functionality is working correctly");
    	
    	PerformerMethod.employeeEdit(test);
    	
    	extent.endTest(test);
    	extent.flush();

    }
    
    
    
    @Test(priority = 110)
    void employeeMasterReportExport() throws InterruptedException, IOException, AWTException
    {
    	test = extent.startTest("OnBoard Employee- Employee Report - Verify to export Employee Master Report");
    	
    	PerformerMethod.employeeMasterReportExport2(test);
    	
    	extent.endTest(test);
    	extent.flush();

    }
    
    @Test(priority = 111)
    void employeeLimitedExport() throws InterruptedException, IOException, AWTException
    {
    	test = extent.startTest("OnBoard Employee - Employee Report - Verify to export Employee Limited Column Report");
    	
    	PerformerMethod.employeeLimitedExport(test);
    	
    	extent.endTest(test);
    	extent.flush();

    }
    
    
    
   	//Premises Master / OnBoard Entity---
	@Test(priority = 150)
	void OnBoardEntitySearch() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("OnBoard Entity - Verify to check search field is working or not?");
		
		PerformerMethod.OnBoardEntitySearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
    
   	@Test(priority = 151)
   	void OnBoardEntityExport() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBoard Entity - Export Button verfication");
   		
   		PerformerMethod.OnBoardEntityExport(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
   	
   	@Test(priority = 152)
   	void onBoardEntityPremiseViewBtn() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBoard Entity- triangle button -Premise details frame verfication");
   		
   		PerformerMethod.onBoardEntityPremiseViewBtn(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
   	
   	
	@Test(priority = 170) 
	void ubExport() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Onboard Entity - User-Branch Mapping - Verify to check Export button works correctly");
		
		All_Distributor_Methods.ubExport(test, "Performer");
		  
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 171) 
	void ubExportsFilters() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Onboard Entity - User-Branch Mapping - Verify to check Exports with Filters are working correctly ");
		
		All_Distributor_Methods.ubExportsFilters(test, "Performer");
		  
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 172) 
	void ubDelete() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Onboard Entity - User-Branch Mapping - Verify to check Delete button are working correctly ");
		
		All_Distributor_Methods.ubDelete(test, "Performer");
		  
		extent.endTest(test);
		extent.flush();
	}
   	
   	//-----Workspace----
	@Test(priority = 200) //Bilal
	void workspaceRegister() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - Verify Frequency Dropdown is enable or not?");
		
		MethodsD.WorkspaceFrequencyDropdown(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}

	
	@Test(priority = 201) //Bilal
	void WorkspaceChallanAct() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify to select Compliance dropdown Compliances are reflecting properly or not?");
		
		MethodsD.WorkspaceChallanAct(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 202) //Bilal
	void WorkspaceChallanActs() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify to select Challan in Act dropdown Acts are displayed properly or not?");
		
		MethodsD.WorkspaceChallanActs(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 203) //Bilal
	void WorkspaceRegisterActs() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify to select Register in Act dropdown Acts are displayed properly or not?");
		
		MethodsD.WorkspaceRegisterActs(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 204) //Bilal
	void WorkspaceReturnActs() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify to select 'Return - Monthly' in Act dropdown Acts are displayed properly or not?");
		
		MethodsD.WorkspaceReturnActs(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 205) //Bilal
	void WorkspaceReturnQuarterlyActs() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify to select 'Return - Quarterly' in Act dropdown Acts are displayed properly or not?");
		
		MethodsD.WorkspaceReturnQuarterlyActs(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 206) //Bilal
	void WorkspaceReturnHalfYearlyActs() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify to select 'Return - HalfYearly' in Act dropdown Acts are displayed properly or not?");
		
		MethodsD.WorkspaceReturnHalfYearlyActs(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 207) //Bilal
	void WorkspaceReturnAnnualActs() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify to select 'Return - Annual' in Act dropdown Acts are displayed properly or not?");
		
		MethodsD.WorkspaceReturnAnnualActs(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 208) //Bilal
	void WorkspaceReturnBiAnnualActs() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify to select 'Return - BiAnnual' in Act dropdown Acts are displayed properly or not?");
		
		MethodsD.WorkspaceReturnBiAnnualActs(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 209) //Bilal
	void WorkspaceSelectYearColumn() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify to select 'Select Year' dropdown & check Years are displayed properly or not?");
		
		MethodsD.WorkspaceSelectYearColumn(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 210) //Bilal
	void WorkspaceSelectPeriodColumn() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify to select 'Select Period' dropdown & check Periods are displayed properly or not?");
		
		MethodsD.WorkspaceSelectPeriodColumn(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 211) //Bilal
	void WorkspaceApplyClearProceed() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - Verify Apply button, Proceed button & Clear button is working or not?");
		
		MethodsD.WorkspaceApplyClearProceed(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 212) //Bilal
	void WorkspaceChallanForms() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify Challan Forms are reflecting or not?");
		MethodsD.WorkspaceChallanForms(test,"Performer");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 213)//Bilal
	void WorkspaceRegistersForms() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify Registers Forms are reflecting or not?");
		
		MethodsD.WorkspaceRegistersForms(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 214)//Bilal
	void WorkspaceReturnForms() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify Returns Forms are reflecting or not?");
		
		MethodsD.WorkspaceReturnForms(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 215) //Bilal
	void WorkspaceRegistersSingleFormSelection() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify to select forms check box & Input File view button is working or not?");
		
		MethodsD.WorkspaceRegistersSingleFormSelection(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 216) //Bilal
	void WorkspaceProceedBtn() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify to check proceed button works correctly according to input forms check box selection");
		
		MethodsD.WorkspaceProceedBtn(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 217) //Document generation
	void WorkspaceRegister() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify to check document generation works correctly");
		
		MethodsD.WorkspaceRegister(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 218) //
	void History() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - 'History file download verification' ");
		
		MethodsD.History(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 219) //Bilal
	void WorkspaceSampleTemplate() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - Verify to download sample document");
		
		MethodsD.WorkspaceSampleTemplate(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 220) //Bilal
	void WorkspaceEmptyFile() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify Errors without selecting file upload & Empty file upload");
		
		MethodsD.WorkspaceEmptyFile(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 221) //Bilal
	void WorkspaceErrorFileUpload() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify error with uploading only 2 columns data & Invalid Headers File");
		
		MethodsD.WorkspaceErrorFileUpload(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 222) //Bilal
	void WorkspaceInvalidFileDownloadErrorFile() throws InterruptedException, IOException, AWTException
	{
	  //test = extent.startTest("abc Workspace - Verify error with uploading only 2 columns data & Invalid Headers File");
		test = extent.startTest("Workspace - Verify to download error file with uploading 2 columns data");
		MethodsD.WorkspaceInvalidFileDownloadErrorFile(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
	
	
	
	
	@Test(priority = 250) //Bilal
	void ECRMasterSearch() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - ECR Master - Verify search field and clear button is working or not?");
		
		MethodsD.ECRMasterSearches(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 251)
	void ECRMasterExport() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - ECR Master - Verify Export button is working or not?");
		
		MethodsD.ECRMasterExport(test,"Reviewer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 252)
	void ECRMasterAddNewInvalidId() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - ECR Master - Verify Add New with Invalid Client ID Error is displayed or not?");
		
		MethodsD.ECRMasterInvalidClientID(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 260)
	void ECRConfirmationGrid() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - ECR Confirmation - Verify to check grid data is reflecting or not?");
		
		MethodsD.ECRConfirmationGrid(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	//---------Statutory Documents--------
	
    @Test(priority = 300)
    void StatutoryDocumentModule() throws InterruptedException, IOException, AWTException
    {
	    test = extent.startTest("To check weather Statutory Documents module link is working or not?");
    
	    PerformerMethod.StatutoryDocumentModule(test);
	
	    extent.endTest(test);
	    extent.flush();
    }
	@Test(priority = 301)
	void StatutoryDocApplyClaerBtn() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Statutory Documents - Apply Button and clear Verification");
		
		ReviewerMethod.StatutoryDocApplyClaerBtn(test, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 301)
	void StatutoryDocRegisterForms() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Statutory Documents - Verify to check Registers forms is displayed correctly");
		
		ReviewerMethod.StatutoryDocRegisterForms(test, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 305)
	void StateDocZipFile() throws InterruptedException, IOException, AWTException 
	{
		test = extent.startTest("Statutory Documents - Registers - Verify to download ZIP folder");
		ReviewerMethod.StateDocZipFile(test, "Performer");
		
		test = extent.startTest("Statutory Documents - Registers - Verify to check Overview button is working correctly");
		ReviewerMethod.StateDownloadDocOverview(test, "Performer");

		test = extent.startTest("Statutory Documents - Registers - Verify to download document file");
		ReviewerMethod.StateDownloadDocSingle(test, "Performer");
		
		test = extent.startTest("Statutory Documents - Registers - Verify to view document file");
		ReviewerMethod.StateViewDocSingle(test, "Performer");

		extent.endTest(test);
		extent.flush();

	}
	
	@Test(priority = 306) 
	void staturyDocChallanForms() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Statutory Documents - Verify to check Challan forms is displayed correctly");
		
		ReviewerMethod.staturyDocChallanForms(test, "Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 307) //PT
	void PTConsolidatedW() throws InterruptedException, IOException, AWTException 
	{	
		test = extent.startTest("Statutory Documents - Challan PT - Verify to check PT Consolidated Workings File is downloading correctly");
		ReviewerMethod.StateDocZipFileChallan(test, "Performer");//redirection
		ReviewerMethod.PTConsolidatedW(test, "Performer");
		
		test = extent.startTest("Statutory Documents - Challan PT - Verify to check Branch view button is working correctly");
		ReviewerMethod.branchView(test, "Performer");
		
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 307) 
	void StateDocZipFileChallan() throws InterruptedException, IOException, AWTException 
	{	
		test = extent.startTest("Statutory Documents - Challan PT - Verify to check Overview button is working correctly");
		ReviewerMethod.StateDocZipFileChallan(test, "Performer"); //redirection
		ReviewerMethod.StateDownloadDocOverviewChallanPT(test, "Performer");

		test = extent.startTest("Statutory Documents - Challan PT - Verify to download document file");
		ReviewerMethod.StateDownloadDocSingle(test, "Performer");
		
		test = extent.startTest("Statutory Documents - Challan PT - Verify to view document file");
		ReviewerMethod.StateViewDocSingle(test, "Performer");

		extent.endTest(test);
		extent.flush();

	}
	
	@Test(priority = 308) //ESIC
	void ESIConsolidatedW() throws InterruptedException, IOException, AWTException 
	{	
		test = extent.startTest("Statutory Documents - Challan ESI - Verify to check ESI Consolidated Workings File is downloading correctly");
		ReviewerMethod.StateDocZipFileChallanESI(test, "Performer");//redirection
		ReviewerMethod.ESIConsolidatedW(test, "Performer");
		
		test = extent.startTest("Statutory Documents - Challan ESI - Verify to check Branch view button is working correctly");
		ReviewerMethod.branchView(test, "Performer");
		
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 309) 
	void challanESIC() throws InterruptedException, IOException, AWTException 
	{	
		test = extent.startTest("Statutory Documents - Challan ESI - Verify to check Overview button is working correctly");
		ReviewerMethod.StateDocZipFileChallanESI(test, "Performer"); //redirection
		ReviewerMethod.StateDownloadDocOverviewChallanPT(test, "Performer");

		test = extent.startTest("Statutory Documents - Challan ESI - Verify to download document file");
		ReviewerMethod.StateDownloadDocSingle(test, "Performer");
		
		test = extent.startTest("Statutory Documents - Challan ESI - Verify to view document file");
		ReviewerMethod.StateViewDocSingle(test, "Performer");

		extent.endTest(test);
		extent.flush();

	}
	@Test(priority = 310) // NEW TC -- PF
	void EPFConsolidatedW() throws InterruptedException, IOException, AWTException 
	{	
		test = extent.startTest("Statutory Documents - Challan EPF - Verify to check ESI Consolidated Workings File is downloading correctly");
		ReviewerMethod.StateDocZipFileChallanEPF(test, "Performer");//redirection
		ReviewerMethod.EPFConsolidatedW(test, "Performer");
		
		test = extent.startTest("Statutory Documents - Challan EPF - Verify to check Branch view button is working correctly");
		ReviewerMethod.branchView(test, "Performer");
		
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 311) // NEW TC PF
	void challanEPF() throws InterruptedException, IOException, AWTException 
	{	
		test = extent.startTest("Statutory Documents - Challan EPF - Verify to check Overview button is working correctly");
		ReviewerMethod.StateDocZipFileChallanEPF(test, "Performer"); //redirection
		ReviewerMethod.StateDownloadDocOverviewChallanPT(test, "Performer");

		test = extent.startTest("Statutory Documents - Challan EPF - Verify to download document file");
		ReviewerMethod.StateDownloadDocSingleEPF(test, "Performer");
		
		test = extent.startTest("Statutory Documents - Challan EPF - Verify to view document file");
		ReviewerMethod.StateViewDocSingleEPF(test, "Performer");

		extent.endTest(test);
		extent.flush();

	}
	
    
    //----- Input Files -----
    
    
    
    
    
    //---- ESIC Cards -----
    
	@Test(priority = 400)
	void SubcodeMasterSearch() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("ESIC Cards - Subcode Master - Search box verification");
		
		MethodsD.SubcodeMasterSearch(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 401)
	void SubcodeMasterAddNew() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("ESIC Cards - Subcode Master - Verify on clicking to Add New & Edit buttons Popup is opening or not?");
		
		MethodsD.SubcodeMasterAddNew(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 402)
	void SubcodeMasterExportbutton() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("ESIC Cards - Subcode Master - Verify Export button is working or not?");
		
		MethodsD.SubcodeMasterExportbutton(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 403)
	void DispensaryMasterSearch() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("ESIC Cards - Dispensary Master - Verify state dropdown & type to search field is working or not?");
		
		MethodsD.DispensaryMasterSearch(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 404)
	void DispensaryMasterAddNew() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("ESIC Cards - Dispensary Master - Verify Add New button is working or not?");
		
		MethodsD.DispensaryMasterAddNew(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 405)
	void DispensaryMasterExport() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("ESIC Cards - Dispensary Master - Verify Export button is working properly or not?");
		
		MethodsD.DispensaryMasterExport(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 406)
	void DispensaryMasterEditPopup() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("ESIC Cards - Dispensary Master - Verify Edit button is working or not?");
		
		MethodsD.DispensaryMasterEditPopup(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 407)
	void ESICInputs_NewGeneration() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("ESIC Cards - ESIC Inputs - New Generation - Verify Sample Documents are downloading or not?");
		
		MethodsD.ESICInputs_NewGeneration(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 409)
	void ESICInputs_NewGeneration_UploadValidation() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("ESIC Cards - ESIC Inputs - New Generation - Verify Error without uploading file");
		
		MethodsD.ESICInputs_NewGeneration_UploadValidation(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 410)
	void ESICInputs_NewGeneration_BrowseDelete() throws Exception
	{
		test = extent.startTest("ESIC Cards - ESIC Inputs - New Generation - Verify Browse and Delete buttons are working or not?");
		
		MethodsD.ESICInputs_NewGeneration_BrowseDelete(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 411)
	void ESICInputs_Updation_SampleFile() throws Exception
	{
		test = extent.startTest("ESIC Cards - ESIC Inputs - Updation - Verify Sample Documents are downloading or not?");
		
		MethodsD.ESICInputs_Updation_SampleFile(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 412)
	void ESICInputs_Updation_UploadValidation() throws Exception
	{
		test = extent.startTest("ESIC Cards - ESIC Inputs - Updation - Verify Error without uploading file");
		
		MethodsD.ESICInputs_Updation_UploadValidation(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 413)
	void ESICInputs_Updation_BrowseDelete() throws Exception
	{
		test = extent.startTest("ESIC Cards - ESIC Inputs - Updation - Verify Browse and Delete buttons are working or not?");
		
		MethodsD.ESICInputs_Updation_BrowseDelete(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 414)
	void ESICInputs_Downloads_SampleFile() throws Exception
	{
		test = extent.startTest("ESIC Cards - ESIC Inputs - Downloads - Verify Sample Documents are downloading or not?");
		
		MethodsD.ESICInputs_Downloads_SampleFile(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 415)
	void ESICInputs_Downloads_UploadValidation() throws Exception
	{
		test = extent.startTest("ESIC Cards - ESIC Inputs - Downloads - Verify Error without uploading file");
		
		MethodsD.ESICInputs_Downloads_UploadValidation(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 416)
	void ESICInputs_Downloads_BrowseDelete() throws Exception
	{
		test = extent.startTest("ESIC Cards - ESIC Inputs - Downloads - Verify Browse and Delete buttons are working or not?");
		
		MethodsD.ESICInputs_Downloads_BrowseDelete(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 417)
	void ESICInputs_Failed_SampleDownload() throws Exception
	{
		test = extent.startTest("ESIC Cards - ESIC Inputs - Failed - Verify Sample Documents are downloading or not?");
		
		MethodsD.ESICInputs_Failed_SampleDownload(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 418)
	void ESICInputs_Failed_UploadValidation() throws Exception
	{
		test = extent.startTest("ESIC Cards - ESIC Inputs - Failed - Verify Error without uploading file");
		
		MethodsD.ESICInputs_Failed_UploadValidation(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 419)
	void ESICInputs_Failed_BrowseDelete() throws Exception
	{
		test = extent.startTest("ESIC Cards - ESIC Inputs - Failed - Verify Browse and Delete buttons are working or not?");
		
		MethodsD.ESICInputs_Failed_BrowseDelete(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//------ Reports -------
	
	
	@Test(priority = 440) 
	void myreportComplianceAssignment() throws InterruptedException, IOException
	{
		test = extent.startTest("My Report - Compliance Assignment Report ");
		
		MethodsD.myreportComplianceAssignment(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 441) 
	void assignmentReportsRegister() throws InterruptedException, IOException
	{
		test = extent.startTest("My Report - Compliance Assignment Report - Verify to check Registers compliance exports correctly");
		
		MethodsD.assignmentReportsFilterExports(test,"Distributor", "Registers");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 442) 
	void assignmentReportsReturn() throws InterruptedException, IOException
	{
		test = extent.startTest("My Report - Compliance Assignment Report - Verify to check Returns compliance exports correctly");
		
		MethodsD.assignmentReportsFilterExports(test,"Distributor", "Returns");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 400) 
	void assignmentReportsChallan() throws InterruptedException, IOException
	{
		test = extent.startTest("My Report - Compliance Assignment Report - Verify to check Challans compliance exports correctly");
		
		MethodsD.assignmentReportsFilterExports(test,"Distributor", "Challans");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 400)
	void consolidatedStatusReport() throws InterruptedException, IOException
	{
		test = extent.startTest("My Report - Consolidated Status Report - Verification");
		
		MethodsD.consolidatedStatusReport(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
	@Test(priority = 450)
	void StatusReport() throws InterruptedException, IOException
	{
		test = extent.startTest("My Report - Status Report ");
		
		MethodsD.DistMyReportStatusReport(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
		@Test(priority = 460) 
		void clraAssignmentReport() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - CLRA Assignment Report");
			
			MethodsD.clraAssignmentReport(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
	

**/

	
   	
    @AfterMethod
    void afterMethod(ITestResult result) throws InterruptedException {
        int priority = result.getMethod().getPriority();
        String testName = result.getMethod().getMethodName();
        String status = (result.getStatus() == ITestResult.SUCCESS) ? "PASSED"
                        : (result.getStatus() == ITestResult.FAILURE) ? "FAILED" : "SKIPPED";

        System.out.println("-------------------------------------------------");
        System.out.println("✅ Test: " + testName + " | 🕐 Priority: " + priority + " | 📊 Status: " + status);
        System.out.println("-------------------------------------------------\n");

        Thread.sleep(1000);
        closeBrowser();
    }
   	
//   	
//	@AfterMethod
//  	void browserClosing() throws InterruptedException
//  	{
//		Thread.sleep(10000);
//		closeBrowser();
//  		//Thread.sleep(1000);
//  		//getDriver().close();
//  	}	       
  		       		
  	@AfterTest
  	void Closing() throws InterruptedException
  	{
  		
  	}
}
