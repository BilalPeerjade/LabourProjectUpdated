package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class DistributorTest  extends BasePage {
	
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
	
	
   @Test(priority = 1)
	void ComplianceBox() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on 'Compliance'");
		
		MethodsD.complianceBox(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 2)
	void UpcomingBox() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on 'Upcoming'");
		
		MethodsD.UpcomingBox(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void OverdueBox() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on 'Overdue'");
		
		MethodsD.OverdueBox(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 4)
	void PendingActionBox() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on 'Pending Action'");
		
		MethodsD.PendingActionBox(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5)
	void PendingReviewBox() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on 'Pending Review'");
		
		MethodsD.PendingReviewBox(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 6)
	void RegisterUpcoming() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Register - 'Upcoming'");
		
		MethodsD.RegisterUpcoming(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 7)
	void RegisterOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Register - 'Overdue'");
		
		MethodsD.RegisterOverdue(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void RegisterActionReview() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Register - 'Action/Review'");
		
		MethodsD.RegisterActionReview(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 9)
	void ReturnUpcoming() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Returns - 'Upcoming'");
		
		MethodsD.ReturnUpcoming(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 10)
	void ReturnOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Returns - 'Overdue'");
		
		MethodsD.ReturnOverdue(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 11)
	void ReturnActionReview() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Returns - 'Action/Review'");
		
		MethodsD.ReturnActionReview(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 12)
	void ChallanUpcoming() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Challans - 'Upcoming'");
		
		MethodsD.ChallanUpcoming(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13)
	void ChallanOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Challans - 'Overdue'");
		
		MethodsD.ChallanOverdue(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 14)
	void ChallanActionReview() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on Challans - 'Action/Review'");
		
		MethodsD.ChallanActionReview(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 15)
	void ComplianceFilter1() throws InterruptedException, IOException
	{
		test = extent.startTest(" Compliance Box Filter Verification'");
		
		MethodsD.ComplianceFilter1(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 16)
	void UpcomingFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Upcoming Box Filter Verification'");
		
		MethodsD.UpcomingFilter(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 17)
	void OverdueFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Overdue Box Filter Verification'");
		
		MethodsD.OverdueFilter(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 18)
	void PendingActionFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Pending Action Box Filter Verification'");
		
		MethodsD.PendingActionFilter(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 19)
	void PendingReviewFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Pending Review Box Filter Verification'");
		
		MethodsD.PendingReviewFilter(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 20)
	void RegisterUpcomingFilter() throws InterruptedException, IOException
	{
		test = extent.startTest(" Register - Upcoming Filter Verification'");
		
		MethodsD.RegisterUpcomingFilter(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 21)
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
				MethodsD.RiskGraph( test, "High", high);
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				js.executeScript("window.scrollBy(0,300)");
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
	
	@Test(priority = 22)
	void RiskSummaryCompliedGraph() throws InterruptedException, IOException
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
		int high = Integer.parseInt(LoginLocators.CompHighRisk().getText());	//Reading Dashboard count.
		int medium = Integer.parseInt(LoginLocators.CompMediumRisk().getText());	//Reading Dashboard count.
		int low = Integer.parseInt(LoginLocators.CompLowRisk().getText());	//Reading Dashboard count.
		
		Thread.sleep(500);
		
			if(high >= 0)
			{
				//Methods.HighRisk(test);
				MethodsD.CompRiskGraph( test, "High", high);
			}
			else
			{
				test.log(LogStatus.PASS, "'High' Risk Compliance Count = "+high);
			}
			
			if(medium >= 0)
			{
				js.executeScript("window.scrollBy(0,300)");
				MethodsD.CompRiskGraph( test, "Medium", medium);
			}
			else
			{
				js.executeScript("window.scrollBy(0,300)");
				test.log(LogStatus.PASS, "'Medium' Risk Compliance Count = "+high);
			}
			
			if(low >= 0)
			{
				js.executeScript("window.scrollBy(0,300)");
				MethodsD.CompRiskGraph( test, "Low", low);
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
	
	@Test(priority = 23)
	void Complied() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Performance summary - Complied - match verification");
		
		MethodsD.Complied(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 24)
	void NotComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Performance summary - Not Complied - match verification");
		
		MethodsD.NotComplied(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
//	@Test(priority = 25)
	void CompliedFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Performance summary - Complied - Multiple filter verification");
		
		MethodsD.CompliedFilter(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 26)
	void CompliedRiskSummaryGraphFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Risk summary - Complied - Multiple filter verification");
		
		MethodsD.CompliedRiskSummaryGraphFilter(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 27)
	void ApplicableStatues() throws InterruptedException, IOException
	{
		test = extent.startTest("Applicable Statue verification");
		
		MethodsD.ApplicableStatues(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 28)
	void DailyUpdate() throws InterruptedException, IOException
	{
		test = extent.startTest("Daily Update verification");
		
		MethodsD.DailyUpdate(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 29)
	void Report() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Assignment Report ");
		
		MethodsD.Report(test,"Distributor");
		
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
		
		MethodsD.VariousReport(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 32)
	void CLRAAssignmentReport() throws InterruptedException, IOException
	{
		test = extent.startTest("CLRA Assignment Report");
		
		MethodsD.CLRAAssignmentReport(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	//  ------My Documents-
	@Test(priority = 33)
	void MyDocumnent() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("My document - Add Registration Repository ");
		
		MethodsD.MyDocumnent(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 34)
	void MyDocumnentExport() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("My document Export ");
		
		MethodsD.MyDocumnentExport(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}

	
	@Test(priority = 35)
	void MyDocumentSearch() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("My document - search ");
		
		MethodsD.MyDocumentSearch(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 36)
	void MyDocumnentDigitalSignature() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("My document - Digital Signature ");
		
		MethodsD.MyDocumnentDigitalSignature(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
	
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
