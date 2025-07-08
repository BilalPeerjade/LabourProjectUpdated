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

import clientPortal.All_ClientPortal_Methods;
import distributor.MethodsD;
import login.BasePage;
import login.LoginLocators;
import performer.LocatorsP;
import performer.MethodsP;
import performer.PerformerMethod;

public class PerformerT extends BasePage {
	
	
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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\PerformerT.html",true);
		test = extent.startTest("Labour Performer login");
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

	
	
	@Test(priority = 1)
	void EntitiesSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("Entities - Verify to Entity Serach field is working fine");
		
		MethodsD.EntitiesSearch(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 2)
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
	@Test(priority = 2)
	void ChangePass() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check user is redirecting to Entity Page or not on clicking to 'Click here to go back' link");
		
		MethodsD.ChangePass(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 2)
	void EntityExcelDownload() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check Entity Locations & Entity Files are downloading or not?");
		
		MethodsD.EntityExcelDownload(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 2)//Moved in all
	void PortalLogin() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check user is redirecting to client pottal or not through portal login");
		
		MethodsD.PortalLogin(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
	@Test(priority = 4) //Bilals 
	void CompliedChecking() throws InterruptedException, IOException
	{
		test = extent.startTest("Performance summary - Complied - verify match verification");
		
		MethodsD.CompliedChecking(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
	
	//Performance Summary complied 23-05-2025
	@Test(priority = 20) //Bilal
	void Complied() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Performance summary - Complied - match verification");
		
		MethodsD.Complied(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 21)
	void CompliedFilter() throws InterruptedException, IOException
	{
		test = extent.startTest("Pie Chart - Performance summary - Complied - Multiple filter verification");
		
		MethodsD.CompliedFilter(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Manage Masters---
	
	@Test(priority =50) //Bilal //Moved in all
   	void StateCitySearch() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Manage Master - State City - Verify to check Search State/Location Code dropdown is working or not");
   		
   		
   		PerformerMethod.StateCitySearch(test, workbook,"Performer");
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	@Test(priority = 51) //Bilal Moved in all
   	void DesignationSearch() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Master - Designation - Verify to check Search/Select Designation dropdown is working or not");
   		   		
   		PerformerMethod.DesignationSearch(test, workbook,"Performer");

   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 52) //Bilal //Moved in all
   	void LeaveTypeSearch() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Master - Leave Type - Verify to check Search Leave Type dropdown is working or not?");
   		   		
   		PerformerMethod.LeaveTypeSearch(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 53) //Bilal //Moved in all
   	void PaycodeMappingSearchField() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check Add New error is displayed or not?");
   		   		
   		PerformerMethod.PaycodeMappingSearchField(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 53) //Bilal //Moved in all
   	void PaycodeMappingAddNew() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check Add New error is displayed or not?");
   		   		
   		PerformerMethod.PaycodeMappingAddNew(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 54) //Bilal //Moved in all
   	void PaycodeMappingEditUpdate() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check paycode is editable or not?");
   		   		
   		PerformerMethod.PaycodeMappingEditUpdate(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 55) //Bilal //Moved in all
   	void PaycodeMappingUpload() throws InterruptedException, IOException, AWTException
   	{
test = extent.startTest("Manage Masters - Paycode Mapping - Verify to check paycode Upload or not?");
   		   		
   		PerformerMethod.PaycodeMappingUpload(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	
	@Test(priority = 58) //Moved in all
   	void MastersStaturyDoc() throws InterruptedException, IOException, AWTException
   	{
test = extent.startTest("Manage Masters - Statutory Master - Verify to check Exports with all Compliance Types are working or not?");
   		   		
   		PerformerMethod.MastersStaturyDoc(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	
	
	@Test(priority = 59) //
   	void ChallanPTSlab() throws InterruptedException, IOException, AWTException
   	{
test = extent.startTest("Manage Masters - Challan PT Slab - Verify the Employee is mapping or not?");
   		   		
   		PerformerMethod.ChallanPTSlab(test, workbook);

   		extent.endTest(test);
   		extent.flush();
   	}
	
	
	
	//Premises Master
	@Test(priority = 41)
	void OnBoardEntitySearch() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("OnBoard Entity - Verify to search field is working or not?");
		
		PerformerMethod.OnBoardEntitySearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
	//Workspace----
	@Test(priority = 200) //Moved in all //Bilal
	void WorkspaceRegister() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - Verify Frequency Dropdown is enable or not?");
		
		MethodsD.WorkspaceFrequencyDropdown(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 200) //Bilal //Moved in all
	void WorkspaceApplyClearProceed() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - Verify Apply button, Proceed button & Clear button is working or not?");
		
		MethodsD.WorkspaceApplyClearProceed(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 201) //Moved in all //Bilal
	void WorkspaceChallanAct() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest(" Workspace - Verify after selecting Challan, Registers & Returns "
				               + "Act values are reflecting properly or not?");
		
		MethodsD.WorkspaceChallanAct(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 202) //Bilal //Moved in all
	void WorkspaceChallanForms() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify Challan Forms are reflecting or not?");
		
		MethodsD.WorkspaceChallanForms(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 203)//Bilal//Moved in all
	void WorkspaceRegistersForms() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify Registers Forms are reflecting or not?");
		
		MethodsD.WorkspaceRegistersForms(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 204)//Bilal//Moved in all
	void WorkspaceReturnForms() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify Returns Forms are reflecting or not?");
		
		MethodsD.WorkspaceReturnForms(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 204) //Bilal //Moved in all
	void WorkspaceRegistersSingleFormSelection() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify to select single form checkbox");
		
		MethodsD.WorkspaceRegistersSingleFormSelection(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 204) //Bilal //Moved in all
	void WorkspaceChallanActs() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Workspace - Verify to select Challan in Act dropdown Acts are displayed properly or not?");
		
		MethodsD.WorkspaceChallanActs(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	
	
	
	//Test for clicking Not Complied
//	@Test(priority = 1)
	void NotCompliedCheck() throws InterruptedException, IOException
	{
		test = extent.startTest(" Count by Clicking on 'Compliance'");
		
		MethodsD.NotCompliedCheck(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	//E2E
	@Test(priority = 27) //E2E for Challan PT calculate PT Gross Wages
	void StaturyDocuPT() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Statutory Documents - Challan PT File Check weather PT Gross wages total is coming properly or not");
		
		MethodsD.StaturyDocuPT(test,"Performer");
		
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
