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

import clientPortal.All_ClientPortal_Methods;
import distributor.MethodsD;
import formsCalculations.EPF_ConsolatedMethods;
import formsCalculations.PT_Me;
import formsCalculations.PT_Methods;
import login.BasePage;
import login.LoginLocators;
import performer.LocatorsP;
import performer.MethodsP;
import performer.PerformerMethod;
import rcp.EndToEnd_B_Methods;



public class ClientPTStateWise extends BasePage {
	
	
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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\ReportChallanForms\\PT_Forms.html",true);
		test = extent.startTest("Labour - Forms Automation - PT Challan (Client PT-state wise)");
		
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
	void Challan_PT_ANP_EmployeeID() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - ANP - Validate Employee IDs are reflecting correctly");
		PT_Me.Challan_PT_ANP_EmployeeID(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 2) 
	void Challan_PT_ANP_EmployeeName() throws InterruptedException, IOException, AWTException
	{
	       test = extent.startTest("PT Challan - ANP - Validate 'Employee Names' are reflecting correctly");
	      PT_Me.Challan_PT_ANP_EmployeeName(test, "");
	      
			extent.endTest(test);
			extent.flush();
	}
	@Test(priority = 3) 
	void Challan_PT_ANP_Gender() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - ANP - Validate 'Genders' are reflecting correctly");
		PT_Me.Challan_PT_ANP_Gender(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 4) 
	void Challan_PT_ANP_PTState() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - ANP - Validate 'PT State' are reflecting correctly");
		PT_Me.Challan_PT_ANP_PTState(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 5) 
	void Challan_PT_ANP_Location() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - ANP - Validate 'Locations' are reflecting correctly");
		PT_Me.Challan_PT_ANP_Location(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 6) 
	void Challan_PT_ANP_PTGrossWages() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - ANP - Validate 'PT Gross Wages' are reflecting correctly");
		PT_Me.Challan_PT_ANP_PTGrossWages(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 7) 
	void Challan_PT_ANP_PTAmount() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - ANP - Validate 'PT amount' are reflecting correctly");
		PT_Me.Challan_PT_ANP_PTAmount(test,"Performer");
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 8) 
	void Challan_PT_BHR_EmployeeID() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - BHR - Validate Employee IDs are reflecting correctly");
		PT_Me.Challan_PT_BHR_EmployeeID(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 9) 
	void Challan_PT_BHR_EmployeeName() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - BHR - Validate 'Employee Names' are reflecting correctly");
		PT_Me.Challan_PT_BHR_EmployeeName(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 10) 
	void Challan_PT_BHR_Gender() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - BHR - Validate 'Genders' are reflecting correctly");
		PT_Me.Challan_PT_BHR_Gender(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 11) 
	void Challan_PT_BHR_PTState() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - BHR - Validate 'PT State' are reflecting correctly");
		PT_Me.Challan_PT_BHR_PTState(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 12) 
	void Challan_PT_BHR_Location() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - BHR - Validate 'Locations' are reflecting correctly");
		PT_Me.Challan_PT_BHR_Location(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 13) 
	void Challan_PT_BHR_PTGrossWages() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - BHR - Validate 'PT Gross Wages' are reflecting correctly");
		PT_Me.Challan_PT_BHR_PTGrossWages(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 14) 
	void Challan_PT_BHR_PTAmount() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - BHR - Validate 'PT amount' are reflecting correctly");
		PT_Me.Challan_PT_BHR_PTAmount(test,"Performer");
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 15) 
	void Challan_PT_GUJ_EmployeeID() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - GUJ - Validate Employee IDs are reflecting correctly");
		PT_Me.Challan_PT_GUJ_EmployeeID(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 16) 
	void Challan_PT_GUJ_EmployeeName() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - GUJ - Validate 'Employee Names' are reflecting correctly");
		PT_Me.Challan_PT_GUJ_EmployeeName(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 17) 
	void Challan_PT_GUJ_Gender() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - GUJ - Validate 'Genders' are reflecting correctly");
		PT_Me.Challan_PT_GUJ_Gender(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 18) 
	void Challan_PT_GUJ_PTState() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - GUJ - Validate 'PT State' are reflecting correctly");
		PT_Me.Challan_PT_GUJ_PTState(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 19) 
	void Challan_PT_GUJ_Location() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - GUJ - Validate 'Locations' are reflecting correctly");
		PT_Me.Challan_PT_GUJ_Location(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 20) 
	void Challan_PT_GUJ_PTGrossWages() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - GUJ - Validate 'PT Gross Wages' are reflecting correctly");
		PT_Me.Challan_PT_GUJ_PTGrossWages(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 21) 
	void Challan_PT_GUJ_PTAmount() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - GUJ - Validate 'PT amount' are reflecting correctly");
		PT_Me.Challan_PT_GUJ_PTAmount(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	@Test(priority = 22) 
	void Challan_PT_JAK_EmployeeID() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - JAK - Validate Employee IDs are reflecting correctly");
		PT_Me.Challan_PT_JAK_EmployeeID(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 23) 
	void Challan_PT_JAK_EmployeeName() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - JAK - Validate 'Employee Names' are reflecting correctly");
		PT_Me.Challan_PT_JAK_EmployeeName(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 24) 
	void Challan_PT_JAK_Gender() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - JAK - Validate 'Genders' are reflecting correctly");
		PT_Me.Challan_PT_JAK_Gender(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 25) 
	void Challan_PT_JAK_PTState() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - JAK - Validate 'PT State' are reflecting correctly");
		PT_Me.Challan_PT_JAK_PTState(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 26) 
	void Challan_PT_JAK_Location() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - JAK - Validate 'Locations' are reflecting correctly");
		PT_Me.Challan_PT_JAK_Location(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 27) 
	void Challan_PT_JAK_PTGrossWages() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - JAK - Validate 'PT Gross Wages' are reflecting correctly");
		PT_Me.Challan_PT_JAK_PTGrossWages(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 28) 
	void Challan_PT_JAK_PTAmount() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - JAK - Validate 'PT amount' are reflecting correctly");
		PT_Me.Challan_PT_JAK_PTAmount(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 29) 
	void Challan_PT_KAR_EmployeeID() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - KAR - Validate Employee IDs are reflecting correctly");
		PT_Me.Challan_PT_KAR_EmployeeID(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 30) 
	void Challan_PT_KAR_EmployeeName() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - KAR - Validate 'Employee Names' are reflecting correctly");
		PT_Me.Challan_PT_KAR_EmployeeName(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 31) 
	void Challan_PT_KAR_Gender() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - KAR - Validate 'Genders' are reflecting correctly");
		PT_Me.Challan_PT_KAR_Gender(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 32) 
	void Challan_PT_KAR_PTState() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - KAR - Validate 'PT State' are reflecting correctly");
		PT_Me.Challan_PT_KAR_PTState(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 33) 
	void Challan_PT_KAR_Location() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - KAR - Validate 'Locations' are reflecting correctly");
		PT_Me.Challan_PT_KAR_Location(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 34) 
	void Challan_PT_KAR_PTGrossWages() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - KAR - Validate 'PT Gross Wages' are reflecting correctly");
		PT_Me.Challan_PT_KAR_PTGrossWages(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 35) 
	void Challan_PT_KAR_PTAmount() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - KAR - Validate 'PT amount' are reflecting correctly");
		PT_Me.Challan_PT_KAR_PTAmount(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	@Test(priority = 37) 
	void Challan_PT_KRL_EmployeeID() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - KRL - Validate Employee IDs are reflecting correctly");
		PT_Me.Challan_PT_KRL_EmployeeID(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 38) 
	void Challan_PT_KRL_EmployeeName() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - KRL - Validate 'Employee Names' are reflecting correctly");
		PT_Me.Challan_PT_KRL_EmployeeName(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 39) 
	void Challan_PT_KRL_Gender() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - KRL - Validate 'Genders' are reflecting correctly");
		PT_Me.Challan_PT_KRL_Gender(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 40) 
	void Challan_PT_KRL_PTState() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - KRL - Validate 'PT State' are reflecting correctly");
		PT_Me.Challan_PT_KRL_PTState(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 41) 
	void Challan_PT_KRL_Location() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - KRL - Validate 'Locations' are reflecting correctly");
		PT_Me.Challan_PT_KRL_Location(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 42) 
	void Challan_PT_KRL_PTGrossWages() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - KRL - Validate 'PT Gross Wages' are reflecting correctly");
		PT_Me.Challan_PT_KRL_PTGrossWages(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 43) 
	void Challan_PT_KRL_PTAmount() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - KRL - Validate 'PT amount' are reflecting correctly");
		PT_Me.Challan_PT_KRL_PTAmount(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
	
	@Test(priority = 44) 
	void Challan_PT_MAP_EmployeeID() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - MAP - Validate Employee IDs are reflecting correctly");
		PT_Me.Challan_PT_MAP_EmployeeID(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 45) 
	void Challan_PT_MAP_EmployeeName() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - MAP - Validate 'Employee Names' are reflecting correctly");
		PT_Me.Challan_PT_MAP_EmployeeName(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 46) 
	void Challan_PT_MAP_Gender() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - MAP - Validate 'Genders' are reflecting correctly");
		PT_Me.Challan_PT_MAP_Gender(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 47) 
	void Challan_PT_MAP_PTState() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - MAP - Validate 'PT State' are reflecting correctly");
		PT_Me.Challan_PT_MAP_PTState(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 48) 
	void Challan_PT_MAP_Location() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - MAP - Validate 'Locations' are reflecting correctly");
		PT_Me.Challan_PT_MAP_Location(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 49) 
	void Challan_PT_MAP_PTGrossWages() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - MAP - Validate 'PT Gross Wages' are reflecting correctly");
		PT_Me.Challan_PT_MAP_PTGrossWages(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 50) 
	void Challan_PT_MAP_PTAmount() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - MAP - Validate 'PT amount' are reflecting correctly");
		PT_Me.Challan_PT_MAP_PTAmount(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	@Test(priority = 51) 
	void Challan_PT_MAH_EmployeeID() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - MAH - Validate Employee IDs are reflecting correctly");
		PT_Me.Challan_PT_MAH_EmployeeID(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 52) 
	void Challan_PT_MAH_EmployeeName() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - MAH - Validate 'Employee Names' are reflecting correctly");
		PT_Me.Challan_PT_MAH_EmployeeName(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 53) 
	void Challan_PT_MAH_Gender() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - MAH - Validate 'Genders' are reflecting correctly");
		PT_Me.Challan_PT_MAH_Gender(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 54) 
	void Challan_PT_MAH_PTState() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - MAH - Validate 'PT State' are reflecting correctly");
		PT_Me.Challan_PT_MAH_PTState(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 55) 
	void Challan_PT_MAH_Location() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - MAH - Validate 'Locations' are reflecting correctly");
		PT_Me.Challan_PT_MAH_Location(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 56) 
	void Challan_PT_MAH_PTGrossWages() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - MAH - Validate 'PT Gross Wages' are reflecting correctly");
		PT_Me.Challan_PT_MAH_PTGrossWages(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 57) 
	void Challan_PT_MAH_PTAmount() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - MAH - Validate 'PT amount' are reflecting correctly");
		PT_Me.Challan_PT_MAH_PTAmount(test,"Performer");
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 58) 
	void Challan_PT_ORS_EmployeeID() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - ORS - Validate Employee IDs are reflecting correctly");
		PT_Me.Challan_PT_ORS_EmployeeID(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 59) 
	void Challan_PT_ORS_EmployeeName() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - ORS - Validate 'Employee Names' are reflecting correctly");
		PT_Me.Challan_PT_ORS_EmployeeName(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 60) 
	void Challan_PT_ORS_Gender() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - ORS - Validate 'Genders' are reflecting correctly");
		PT_Me.Challan_PT_ORS_Gender(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 61) 
	void Challan_PT_ORS_PTState() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - ORS - Validate 'PT State' are reflecting correctly");
		PT_Me.Challan_PT_ORS_PTState(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 62) 
	void Challan_PT_ORS_Location() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - ORS - Validate 'Locations' are reflecting correctly");
		PT_Me.Challan_PT_ORS_Location(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 63) 
	void Challan_PT_ORS_PTGrossWages() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - ORS - Validate 'PT Gross Wages' are reflecting correctly");
		PT_Me.Challan_PT_ORS_PTGrossWages(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 64) 
	void Challan_PT_ORS_PTAmount() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - ORS - Validate 'PT amount' are reflecting correctly");
		PT_Me.Challan_PT_ORS_PTAmount(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 65) 
	void Challan_PT_PND_EmployeeID() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - PND - Validate Employee IDs are reflecting correctly");
		PT_Me.Challan_PT_PND_EmployeeID(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 66) 
	void Challan_PT_PND_EmployeeName() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - PND - Validate 'Employee Names' are reflecting correctly");
		PT_Me.Challan_PT_PND_EmployeeName(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 67) 
	void Challan_PT_PND_Gender() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - PND - Validate 'Genders' are reflecting correctly");
		PT_Me.Challan_PT_PND_Gender(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 68) 
	void Challan_PT_PND_PTState() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - PND - Validate 'PT State' are reflecting correctly");
		PT_Me.Challan_PT_PND_PTState(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 69) 
	void Challan_PT_PND_Location() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - PND - Validate 'Locations' are reflecting correctly");
		PT_Me.Challan_PT_PND_Location(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 70) 
	void Challan_PT_PND_PTGrossWages() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - PND - Validate 'PT Gross Wages' are reflecting correctly");
		PT_Me.Challan_PT_PND_PTGrossWages(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 71) 
	void Challan_PT_PND_PTAmount() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - PND - Validate 'PT amount' are reflecting correctly");
		PT_Me.Challan_PT_PND_PTAmount(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	@Test(priority = 72) 
	void Challan_PT_PJB_EmployeeID() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - PJB - Validate Employee IDs are reflecting correctly");
		PT_Me.Challan_PT_PJB_EmployeeID(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 73) 
	void Challan_PT_PJB_EmployeeName() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - PJB - Validate 'Employee Names' are reflecting correctly");
		PT_Me.Challan_PT_PJB_EmployeeName(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 74) 
	void Challan_PT_PJB_Gender() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - PJB - Validate 'Genders' are reflecting correctly");
		PT_Me.Challan_PT_PJB_Gender(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 75) 
	void Challan_PT_PJB_PTState() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - PJB - Validate 'PT State' are reflecting correctly");
		PT_Me.Challan_PT_PJB_PTState(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 76) 
	void Challan_PT_PJB_Location() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - PJB - Validate 'Locations' are reflecting correctly");
		PT_Me.Challan_PT_PJB_Location(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 77) 
	void Challan_PT_PJB_PTGrossWages() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - PJB - Validate 'PT Gross Wages' are reflecting correctly");
		PT_Me.Challan_PT_PJB_PTGrossWages(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 78) 
	void Challan_PT_PJB_PTAmount() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - PJB - Validate 'PT amount' are reflecting correctly");
		PT_Me.Challan_PT_PJB_PTAmount(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}

	
	
	@Test(priority = 79) 
	void Challan_PT_TMN_EmployeeID() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - TMN - Validate Employee IDs are reflecting correctly");
		PT_Me.Challan_PT_TMN_EmployeeID(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 80) 
	void Challan_PT_TMN_EmployeeName() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - TMN - Validate 'Employee Names' are reflecting correctly");
		PT_Me.Challan_PT_TMN_EmployeeName(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 81) 
	void Challan_PT_TMN_Gender() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - TMN - Validate 'Genders' are reflecting correctly");
		PT_Me.Challan_PT_TMN_Gender(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 82) 
	void Challan_PT_TMN_PTState() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - TMN - Validate 'PT State' are reflecting correctly");
		PT_Me.Challan_PT_TMN_PTState(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 83) 
	void Challan_PT_TMN_Location() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - TMN - Validate 'Locations' are reflecting correctly");
		PT_Me.Challan_PT_TMN_Location(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 84) 
	void Challan_PT_TMN_PTGrossWages() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - TMN - Validate 'PT Gross Wages' are reflecting correctly");
		PT_Me.Challan_PT_TMN_PTGrossWages(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 85) 
	void Challan_PT_TMN_PTAmount() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - TMN - Validate 'PT amount' are reflecting correctly");
		PT_Me.Challan_PT_TMN_PTAmount(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
	@Test(priority = 86) 
	void Challan_PT_TRP_EmployeeID() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - TRP - Validate Employee IDs are reflecting correctly");
		PT_Me.Challan_PT_TRP_EmployeeID(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 87) 
	void Challan_PT_TRP_EmployeeName() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - TRP - Validate 'Employee Names' are reflecting correctly");
		PT_Me.Challan_PT_TRP_EmployeeName(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 88) 
	void Challan_PT_TRP_Gender() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - TRP - Validate 'Genders' are reflecting correctly");
		PT_Me.Challan_PT_TRP_Gender(test, "");
		
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 89) 
	void Challan_PT_TRP_PTState() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - TRP - Validate 'PT State' are reflecting correctly");
		PT_Me.Challan_PT_TRP_PTState(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 90) 
	void Challan_PT_TRP_Location() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - TRP - Validate 'Locations' are reflecting correctly");
		PT_Me.Challan_PT_TRP_Location(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 91) 
	void Challan_PT_TRP_PTGrossWages() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - TRP - Validate 'PT Gross Wages' are reflecting correctly");
		PT_Me.Challan_PT_TRP_PTGrossWages(test, "");
		
		
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 92) 
	void Challan_PT_TRP_PTAmount() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - TRP - Validate 'PT amount' are reflecting correctly");
		PT_Me.Challan_PT_TRP_PTAmount(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
	
	
	@Test(priority = 93) 
	void Challan_PT_WEB_EmployeeID() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - WEB - Validate Employee IDs are reflecting correctly");
		PT_Me.Challan_PT_WEB_EmployeeID(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 94) 
	void Challan_PT_WEB_EmployeeName() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - WEB - Validate 'Employee Names' are reflecting correctly");
		PT_Me.Challan_PT_WEB_EmployeeName(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 95) 
	void Challan_PT_WEB_Gender() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - WEB - Validate 'Genders' are reflecting correctly");
		PT_Me.Challan_PT_WEB_Gender(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 96) 
	void Challan_PT_WEB_PTState() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - WEB - Validate 'PT State' are reflecting correctly");
		PT_Me.Challan_PT_WEB_PTState(test, "");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 97) 
	void Challan_PT_WEB_Location() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - WEB - Validate 'Locations' are reflecting correctly");
		PT_Me.Challan_PT_WEB_Location(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 98) 
	void Challan_PT_WEB_PTGrossWages() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - WEB - Validate 'PT Gross Wages' are reflecting correctly");
		PT_Me.Challan_PT_WEB_PTGrossWages(test, "");
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 99) 
	void Challan_PT_WEB_PTAmount() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("PT Challan - WEB - Validate 'PT amount' are reflecting correctly");
		PT_Me.Challan_PT_WEB_PTAmount(test,"Performer");
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
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
