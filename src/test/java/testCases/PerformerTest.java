package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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

import distributor.MethodsD;
import login.BasePage;
import login.LoginLocators;
import performer.LocatorsP;
import performer.MethodsP;

public class PerformerTest extends BasePage {
	
	
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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\Performer.html",true);
		test = extent.startTest("Loging In - Performer");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,1,"Statutory");
		
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
	
	
	
	//Compliance box - Verify Compliance count, Export button and Overview button are working properly or not
	@Test(priority = 1) //Moved in all
	void ComplianceBox() throws InterruptedException, IOException
	{
		test = extent.startTest("Dashboard - Count by Clicking on 'Compliance'");
		
		MethodsD.complianceBox(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 2) //Moved in all
	void ComplianceFilter1() throws InterruptedException, IOException
	{
		test = extent.startTest(" Compliance Box Filter Verification'");
		
		MethodsD.ComplianceFilter1(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}

	
	//Upcoming box - Verify Upcoming box count, Export button, Overview button and Branch Code Filters are working or not
	@Test(priority = 3) //Moved in all
	void UpcomingBox() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on 'Upcoming'");
		
		MethodsD.UpcomingBox(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	

	//Overdue box - Verify Overdue count, Export button and Overview button is working properly or not?
	@Test(priority = 4) //Moved in all
	void OverdueBox() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on 'Overdue'");
		
		MethodsD.OverdueBox(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//Pending Action - Verify Pending Action count, Export button, Overview button and Branch code is working fine or not
	@Test(priority = 5) //Moved in all
	void PendingActionBox() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on 'Pending Action'");
		
		MethodsD.PendingActionBox(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//Need to discuss with sir we can hide this due to data will not come
	@Test(priority = 6) //Moved in all
	void PendingActionPerform() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Action perform from pending action'");
		
		MethodsD.PendingActionPerform(test,"Reviewer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 7) //Moved in all
	void PendingReviewBox() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on 'Pending Review'");
		
		MethodsD.PendingReviewBox(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 8) //Moved in all
	void RegisterUpcoming() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Register - 'Upcoming'");
		
		MethodsD.RegisterUpcoming(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	@Test(priority = 9) //
	void RegisterOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Register - 'Overdue'");
		
		MethodsD.RegisterOverdue(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 10)
	void RegisterActionReview() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Register - 'Action/Review'");
		
		MethodsD.RegisterActionReview(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 11)
	void ReturnUpcoming() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Returns - 'Upcoming'");
		
		MethodsD.ReturnUpcoming(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 12)
	void ReturnOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Returns - 'Overdue'");
		
		MethodsD.ReturnOverdue(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//.....
	@Test(priority = 13)
	void ReturnActionReview() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Returns - 'Action/Review'");
		
		MethodsD.ReturnActionReview(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 14)
	void ChallanUpcoming() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Challans - 'Upcoming'");
		
		MethodsD.ChallanUpcoming(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15)
	void ChallanOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Challans - 'Overdue'");
		
		MethodsD.ChallanOverdue(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void ChallanActionReview() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Challans - 'Action/Review'");
		
		MethodsD.ChallanActionReview(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 17) //Moved in all with sequance 
	void UpcomingFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Upcoming Box Filter Verification'");
		
		MethodsD.UpcomingFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 18) //Moved in all with sequance
	void OverdueFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Overdue Box Filter Verification'");
		
		MethodsD.OverdueFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}

	
	
	@Test(priority = 6) //Moved in all
	void PendingActionFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Pending Action Box Filter Verification'");
		
		MethodsD.PendingActionFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}

	
	@Test(priority = 20) //Moved in all
	void PendingReviewFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Pending Review Box Filter Verification'");
		
		MethodsD.PendingReviewFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 21)
	void RegisterUpcomingFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Register - Upcoming Filter Verification'");
		
		MethodsD.RegisterUpcomingFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}

		
	@Test(priority = 22)
	void RiskSummaryNotCompliedGraph() throws InterruptedException, IOException
	{
		test = extent.startTest("Bar Graph -Risk Summary - Not Complied - Count Verification");
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	//	LoginLocators.Search().sendKeys("WWKRG");
		LoginLocators.Search().sendKeys("AVACORED5");
		Thread.sleep(5000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		Thread.sleep(8000);
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
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
	
	
	@Test(priority = 23) //Moved in all
	void RiskSummaryCompliedGraph() throws InterruptedException, IOException
	{
		test = extent.startTest("Bar Graph -Risk Summary - Complied - Count Verification");
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		LoginLocators.Search().sendKeys("TESTAUTO2");
		//LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
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
		
			Thread.sleep(2000);
			LoginLocators.Dashboard().click();			//Clicking on Dashboard
			Thread.sleep(2000);
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 24)
	void Complied() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Performance summary - Complied - match verification");
		
		MethodsD.Complied(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 25) //Comment Due to Not Complied Xpath not getting
	void NotComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Performance summary - Not Complied - match verification");
		
		MethodsD.NotComplied(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 25)
	void CompliedFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Performance summary - Complied - Multiple filter verification");
		
		MethodsD.CompliedFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 25) //Bilal //Moved in all
	void CompliedHighRiskSummaryFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("High Risk Summary - Complied - Multiple Filter verification");
		
		MethodsD.CompliedHighRiskSummaryFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 25) //Bilal //Moved in all
	void CompliedMediumRiskSummaryFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Medium Risk Summary - Complied - Multiple Filter verification");
		
		MethodsD.CompliedMediumRiskSummaryFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 25) //Bilal //Moved in all
	void CompliedLowRiskSummaryFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Low Risk Summary - Complied - Multiple Filter verification");
		
		MethodsD.CompliedLowRiskSummaryFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 26)
	void CompliedRiskSummaryGraphFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Risk summary - Not Complied - Multiple filter verification");
		
		MethodsD.CompliedRiskSummaryGraphFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
	
	@Test(priority = 27)
	void WorkspaceRegister() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - 'Generate document' verification");
		
		MethodsD.WorkspaceRegister(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 28) //Moved in all
	void History() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - 'History file download verification' ");
		
		MethodsD.History(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 33)
	void frequencydropdown() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - 'Freqency filter enabled/disabled verification' ");
		
		MethodsD.frequencydropdown(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
///	@Test(priority = 34)
	void WorkspaceReturn() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - 'Return - Generate document' verification");
		
		MethodsD.WorkspaceReturn(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 35)//Pass
	void Workspacechallan() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - 'Challan - Generate document' verification");
		
		MethodsD.Workspacechallan(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 36)
	void WorkspaceRegisterEmptyfileupload() throws InterruptedException, IOException, AWTException
	{	
		test = extent.startTest(" Workspace - Empty sheet upload verification");
		
		MethodsD.Empty(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 37)
	void Workspacewithoutentersheetupload() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - without enter sheet upload verification");
		
		MethodsD.Workspacewithoutentersheetupload(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 38)
	void WorkspaceinvalidTemplateupload() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - Invalid templated upload verification");
		
		MethodsD.WorkspaceinvalidTemplateupload(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 39)
	void WorkspaceErroorFileDownload() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - Error sheet download verification");
		
		MethodsD.WorkspaceErroorFileDownload(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 40) //Moved in all
	void ECRMasterExport() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - ECR Master Export verification");
		
		MethodsD.ECRMasterExport(test,"Reviewer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 41)
	void ECRMasterAddNew() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - ECR Master - Add Client verification");
		
		MethodsD.ECRMasterAddNew(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 42)
	void ECRMasterBulkUpload() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - ECR Master - Bulk upload verification");
		
		MethodsD.ECRMasterBulkUpload(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 43)
	void ECRMasterUpdate() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - ECR Master - Edit verification");
		
		MethodsD.ECRMasterUpdate(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 44)//Moved in all
	void ECRMasterAddNewInvalidId() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - ECR Master - Verify Add New with Invalid Client ID Error is displayed or not?");
		
		MethodsD.ECRMasterInvalidClientID(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 45) //Moved in all
	void ECRMasterSearch() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - ECR Master - Search box verification");
		
		MethodsD.ECRMasterSearch(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 46)
	void ApplicableStatues() throws InterruptedException, IOException
	{
		test = extent.startTest("Applicable Statue verification");
		
		MethodsD.ApplicableStatues(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 47)
	void DailyUpdate() throws InterruptedException, IOException
	{
		test = extent.startTest("Daily Update verification");
		
		MethodsD.DailyUpdate(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	//My Report - Compliance Assignment Report - To check weather Register report is exporting or not
	@Test(priority = 29)
	void Report() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Assignment Report ");
		
		MethodsD.Report(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 30)
	void StatusReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Status Report ");
		
		MethodsD.StatusReport(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 31)
	void VariousReport() throws InterruptedException, IOException
	{
		test = extent.startTest("Various Report ");
		
		MethodsD.VariousReport(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 32)
	void CLRAAssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("CLRA Assignment Report");
		
		MethodsD.CLRAAssignmentReport(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	

	
	
	

	
	
	
	
	
	/*   ////Not For Run Whole ESIC Cards
//	@Test(priority = 1) //Moved in all
	void SubcodeMasterSearch() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" ESIC Cards - Subcode Master - Search box verification");
		
		Methods.SubcodeMasterSearch(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 1)
	void AddUser() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("ESIC Cards - Subcode Master - Add User verification");
		
		Methods.AddUser(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 46)
	void DispensaryMaster() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("ESIC Cards - Dispensary Master - Add User verification");
		
		Methods.DispensaryMaster(test,"Performer",workbook);
		
		extent.endTest(test);
		extent.flush();
	}
	/*
//	@Test(priority = 1)
	void DispensaryMasterFilter() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("ESIC Cards - Dispensary Master - Filter verification");
		
		Methods.DispensaryMasterFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 1)
	void dispensaryMasterSearch() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("ESIC Cards - Dispensary Master - Search box verification");
		
		Methods.dispensaryMasterSearch(test,"Performer");
		
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
