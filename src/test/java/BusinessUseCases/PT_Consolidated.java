package BusinessUseCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import businessChallanForms.PT_ConsolidatedMethods;
import clientPortal.All_ClientPortal_Methods;
import distributor.MethodsD;
import formsCalculations.EPF_ConsolatedMethods;
import formsCalculations.PT_Methods;
import login.BasePage;
import login.LoginLocators;
import performer.LocatorsP;
import performer.MethodsP;
import performer.PerformerMethod;
import rcp.EndToEnd_B_Methods;




public class PT_Consolidated extends BasePage {
	
	
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
			extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\ReportChallanForms\\PT_Consolated.html",true);
			
	//		extent.config().enableHtmlEscape(false);
			
			test = extent.startTest("Labour - Performer Login - Business Scenarios ");
			
		//  String runTime = new SimpleDateFormat("EEEE, MMMM dd, yyyy, hh:mm a z").format(new Date());
		    String runTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
			test.log(LogStatus.PASS, "📆 Report Generated: <b>" + runTime + "</b>");
			
			test.log(LogStatus.PASS, "Logging into system");

			extent.endTest(test);
			extent.flush();
		}
		
		@BeforeMethod
		void Login() throws InterruptedException, IOException {
			initialization(link, 1, "Statutory");

			XSSFSheet sheet = ReadExcel(count);
			Row row0 = sheet.getRow(0); // Selected 0th index row (First row)
			Cell c1 = row0.getCell(1); // Selected cell (0 row,1 column)
			String URL = c1.getStringCellValue(); // Got the URL stored at position 0,1

			Row row1 = sheet.getRow(1); // Selected 1st index row (Second row)
			Cell c2 = row1.getCell(1); // Selected cell (1 row,1 column)
			String uname = c2.getStringCellValue(); // Got the URL stored at position 1,1

			Row row2 = sheet.getRow(2); // Selected 2nd index row (Third row)
			Cell c3 = row2.getCell(1); // Selected cell (2 row,1 column)
			String password = c3.getStringCellValue(); // Got the URL stored at position 2,1

		}
		
		@Test(priority = 1) 
		void ChallanPTConsolated_PTReport_EmployeeIds() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("PT Consolidated - PT Report - Validate Employee IDs are reflecting correctly");
			
			PT_ConsolidatedMethods.ChallanPTConsolated_PTReport_EmployeeIds(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 2) 
		void ChallanPTConsolated_PTReport_EmployeeName() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("PT Consolidated - PT Report - Validate Employee Names are reflecting correctly");
			
			PT_ConsolidatedMethods.ChallanPTConsolated_PTReport_EmployeeName(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
//		@Test(priority = 3) 
		void ChallanPTConsolated_PTReport_DOJ() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("PT Consolidated - PT Report - Validate DOJ are reflecting correctly");
			
			PT_ConsolidatedMethods.ChallanPTConsolated_PTReport_DOJ(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 5) 
		void ChallanPTConsolated_PTReport_Gender() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("PT Consolidated - PT Report - Validate Genders are reflecting correctly");
			
			PT_ConsolidatedMethods.ChallanPTConsolated_PTReport_Gender(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}

		
		@Test(priority = 6) 
		void ChallanPTConsolated_PTReport_Branch() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("PT Consolidated - PT Report - Validate Branches are reflecting correctly");
			
			PT_ConsolidatedMethods.ChallanPTConsolated_PTReport_Branch(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 7) //DONE docautoo4 till here
		void ChallanPTConsolated_PTReport_PTGrossWages() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("PT Consolidated - PT Report - Validate PT Gross wages are reflecting correctly");
			
			PT_ConsolidatedMethods.ChallanPTConsolated_PTReport_PTGrossWages(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}

		@Test(priority = 9) 
		void ChallanPTConsolated_PTReport_ClientPTDeduction() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("PT Consolidated - PT Report - Validate Client PT Deduction are reflecting correctly");
			PT_ConsolidatedMethods.ChallanPTConsolated_PTReport_ClientPTDeduction(test,"Performer");
			

			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 10) //Done DOCAUTOO4
		void ChallanPTConsolated_PTReport_PTAmountAsPerSlab() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("PT Consolidated - PT Report - Validate PT amount(As per slab) are reflecting correctly");
			
			PT_ConsolidatedMethods.ChallanPTConsolated_NAE_PTGrossWages(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		
		

		
		
		
		
		//Non Applicable Employees  NAE
		@Test(priority = 20) //Done
		void ChallanPTConsolated_NAE_EmployeeIds() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("PT Consolidated - Non Applicable Employees - Validate Employee IDs are reflecting correctly");
			
			PT_ConsolidatedMethods.ChallanPTConsolated_NAE_EmployeeIds(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 21) //Done
		void ChallanPTConsolated_NAE_EmployeeName() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("PT Consolidated - Non Applicable Employees - Validate Employee Names are reflecting correctly");
			
			PT_ConsolidatedMethods.ChallanPTConsolated_NAE_EmployeeName(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 22) //Done
		void ChallanPTConsolated_NAE_Gender() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("PT Consolidated - Non Applicable Employees - Validate Genders are reflecting correctly");
			
			PT_ConsolidatedMethods.ChallanPTConsolated_NAE_Gender(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 23) //Done
		void ChallanPTConsolated_NAE_Branch() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("PT Consolidated - Non Applicable Employees - Validate Branches are reflecting correctly");
			
			PT_ConsolidatedMethods.ChallanPTConsolated_NAE_Branch(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
//		@Test(priority = 24)  //any mistake here need to check
		void ChallanPTConsolated_NAE_PTGrossWages() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("PT Consolidated - Non Applicable Employees - Validate PT Gross wages are reflecting correctly");
			
			PT_ConsolidatedMethods.ChallanPTConsolated_NAE_PTGrossWages(test,"Performer");
			

			
			extent.endTest(test);
			extent.flush();
		}
		
		//
//		@Test(priority = 25) //Not possible to extract rows for NA employeescoz this is salary sheet
		void ChallanPTConsolated_NAE_ClientPTDeduction() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("PT Consolidated - Non Applicable Employees - Validate Client PT Deduction are reflecting correctly");
			
			PT_ConsolidatedMethods.ChallanPTConsolated_NAE_ClientPTDeduction(test,"Performer");
			
			

			
			extent.endTest(test);
			extent.flush();
		}
	
		
		
		
//		@Test(priority = 25) 
//		void PTSummaryAmountTest() throws InterruptedException, IOException, AWTException
//		{
//			test = extent.startTest("PT Consolidated - Summary - validate PT amount(As per slab) total is reflecting properly or not");
//			
//			PT_ConsolidatedMethods.PTSummaryAmountTest(test,"Performer");
//
//			extent.endTest(test);
//			extent.flush();
//		}
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		@AfterMethod
	  	void browserClosing() throws InterruptedException
	  	{
			Thread.sleep(1000);
			closeBrowser();
	  		//Thread.sleep(1000);
	  		//getDriver().close();
	  	}	       
	  		       		
	  	@AfterTest
	  	void Closing() throws InterruptedException
	  	{
	  		
	  	}
	
	

}
