package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import clientPortal.All_ClientPortal_Methods;
import clientPortal.All_ClientPortal_Methods;
import clientPortal.All_ClientPortal_Methods;
import login.BasePage;



public class All_Client_Portal_TestCases extends BasePage {
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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\ClientPortal.html",true);
		test = extent.startTest("Loging In - Client Portal");
		test.log(LogStatus.PASS, "Logging into system");
		test.log(LogStatus.PASS, "Selected Entity: Test Automation 2[TESTAUTO2] AND Selected Year: 2024");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,6,"Statutory");
	
	}
	
	
	
	

	
	
	
	
	// Mayuri TCs - ClientTest.Java 1 to 112
	
	@Test(priority = 1) //04/02/2025
	void Entities() throws InterruptedException, IOException
	{
		test = extent.startTest("'Entities' Count verification");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.Entities(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 2) 
	void EntitiesSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Entity search field working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.EntitiesSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 3 , groups= {"Smoke"}) 
	void EntitiesTabPagination() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify Entities tab Paginations are working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.EntitiesTabPagination(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 4)
	void Locations() throws InterruptedException, IOException
	{
		test = extent.startTest("'Locations' Count verification");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.Locations(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5) //Bilal
	void LocationsPagination() throws InterruptedException, IOException
	{
		test = extent.startTest("'Locations' Verify all pagination buttons and items per page dropdwon is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.LocationsPagination(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6)
	void LocationsSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Locations search filter working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.LocationsSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 7)
	void AssignedCompliances() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assigned Compliances' - Count verification");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.AssignedCompliances(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 8) //Bilal
	void AssignedCompliancesRgisterReturnChallanCount() throws InterruptedException, IOException
	{
		test = extent.startTest("'Assigned Compliances' - Count verification for selection of compliance dropdown - Register , Return and Challan");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.AssignedCompliancesRgisterReturnChallanCount(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 9)
	void assignedCompSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("Assigned Compliances - Search and Clear button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.assignedCompSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	

	
	@Test(priority = 10) //Bilal 21-05-25
	void assignedCompRegisterExport() throws InterruptedException, IOException
	{
		test = extent.startTest("Assigned Compliances - Compliance dropdown Register - Verify Export count");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.assignedCompRegisterExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 11) //Bilal 
	void assignedCompReturnExport() throws InterruptedException, IOException
	{
		test = extent.startTest("Assigned Compliances - Compliance dropdown Return - Verify Export count");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.assignedCompReturnExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 12) //Bilal 
	void assignedCompChallanExport() throws InterruptedException, IOException
	{
		test = extent.startTest("Assigned Compliances - Compliance dropdown Challan - Verify Export count");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.assignedCompChallanExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
		@Test(priority = 13) // Bilal done 2 TC
		void assignedSelectActFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Assigned Compliances - Select Act & Apply button working or not?");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.assignedSelectActFilter(test);
			
			extent.endTest(test);
			extent.flush();
		}
	
		@Test(priority = 14) //
		void exportcount12() throws InterruptedException, IOException
		{
			test = extent.startTest("Assigned Compliances - Export button working or not?");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.exportcount(test);
			
			extent.endTest(test);
			extent.flush();
		}
	
	
	@Test(priority = 15)
	void OverviewAC() throws InterruptedException, IOException
	{
		test = extent.startTest("Assigned Compliances - Overview button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.OverviewAC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 16) //BILAL Pagination
	void AssignedCompliancesPagination() throws InterruptedException, IOException
	{
		test = extent.startTest("Assigned Compliances - Verify all Pagination is working fine or not?");
//		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.AssignedCompliancesPagination(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17)
	void ExpiredRegistrations() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' - Count verification");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.ExpiredRegistrations(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 18)
	void ExpiredRegistrationsEdit() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' - Edit button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.ExpiredRegistrationsEdit(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 19)
	void exportER() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' - Edit - Export button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.exportER(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 20)
	void ERSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' - Edit - Validate Existing License search field working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.ERSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 21)
	void ERSearchClear() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' -Edit - Validate clear button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.ERSearchClear(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
		//2 TC Bilal Not completed due to not able to click SubActivity trangle mark
//		@Test(priority = 22)
		void EExpandViewDownload() throws InterruptedException, IOException
		{
			test = extent.startTest("'Expired Registrations' - Edit - Validate Expand icon View and Download button is working or not?");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.EExpandViewDownload(test);
			
			extent.endTest(test);
			extent.flush();
		}
	
	
	@Test(priority = 23)
	void ERview() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' - Edit - Validate View button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.ERview(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 24)
	void ERviewBack() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' - Edit - Validate Back button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.ERviewBack(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 25) //Bilal InitiateAction Pass 
	void InitiateAction() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' - Edit - Validate InitiateAction Submit button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InitiateAction(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 26)
	void InitiateActionBack() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' - Edit - InitiateAction - Validate Back button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InitiateActionBack(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 27)
	void exportERE() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' -Edit - Validate Download button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.exportERE(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 28)
	void ExpiredRegistrationPagination() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' - Verify to check all Pagination is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.ExpiredRegistrationPagination(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 29)
	void OpenNotices() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - Count verification");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.OpenNotices(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 30)
	void OpenNoticesView() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - View button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.OpenNoticesView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 31) //Bilal Done Failing due to time issue
	void OpenNoticesEditDelete() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - Download and Edit button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.OpenNoticesEditDelete(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 31)(Hide due to added another test case same coz this is not working)
//	void ViewAddNew() throws InterruptedException, IOException, AWTException
//	{
//		test = extent.startTest("'Open Notices' - View - add new button working or not---?");
//		All_ClientPortal_Methods.filterEntityAUTO2(test);
//		All_ClientPortal_Methods.ViewAddNew(test);
		
//		extent.endTest(test);
//		extent.flush();
//	}
	
	@Test(priority = 32) //Bilal
	void OpenNoticesPagination() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - Verify to check all Pagination is working fine or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.OpenNoticesPagination(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 33)//05/02/2025 Pass
	void ViewAddNewNotices() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Open Notices' - View - add new button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.ViewAddNewNotices(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 34)
	void exportNotice() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Open Notices' - View - Export button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.exportNotice(test);
		
		extent.endTest(test);
		extent.flush();
	}

	
	
	
	
	@Test(priority = 35)
	void NoticeSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - View - Validate Notice search field working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.NoticeSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}    
	
	@Test(priority = 36)
	void NoticeSearchClear() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - View - Validate Notice clear button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.NoticeSearchClear(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 37)
	void OpenNoticesEditback() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - View - edit - Validate Notice Back button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.OpenNoticesEditback(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
		@Test(priority = 38) // Bilal Covered 4 TC
		void NoticeViewEditTabs() throws InterruptedException, IOException
		{
			test = extent.startTest("'Open Notices' - View - Edit - Check All tabs will be displayed or not?");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			All_ClientPortal_Methods.NoticeViewEditTabs(test);
			
			extent.endTest(test);
			extent.flush();
		}
	
	@Test(priority = 39) // Bilal Covered 5 Test Cases
	void NoticeViewEditDocumentDownload() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - View - Edit - Document Section - All Documents are downloading or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.NoticeViewEditDocumentDownload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 40)
	void OverviewNotice() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - View - Overview button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.OverviewNotice(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 41) //Bilal
	void OpenNoticeViewPagination() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - View - all Pagination is working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.OpenNoticeViewPagination(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 42)
	void OpenNoticesback() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - Edit - Validate Notice Back button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.OpenNoticesback(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
 // 27 to 29 Comment by Mayuri
//	@Test(priority = 43) //pending //06/02/2025
	void CompliancePerformance() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Overdue Count Verification");
		
		All_ClientPortal_Methods.CompliancePerformance(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 44) 
	void PayrollCompliancesOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Payroll Compliances - Overdue - Overview button working or not");
		
		All_ClientPortal_Methods.PayrollCompliancesOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 45) 
	void exportPayrollCompliancesOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Payroll Compliances - Overdue - Export button working or not");
		
		All_ClientPortal_Methods.exportPayrollCompliancesOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//---- Payroll Compliance Complied
	
//	@Test(priority = 46) //Bilal Pass //Checking need to check in Friday
	void RCCompliedCount() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance Graph – Payroll Compliances - Count Checking Complied and Grid");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RCCompliedCount(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 47) //Bilal Pass
	void searchRCComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance Graph – Payroll Compliances - Click on the complied count to verify if the search field works correctly?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.searchRCComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 48) //Bilal Pass
	void ClearExportRCComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance Graph – Payroll Compliances - Click on the complied count to verify if the Clear and Export button works correctly?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.ClearExportRCComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 49) //Bilal Pass
	void ViewOverDownloadRCComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance Graph – Payroll Compliances - Click on the complied count to verify if the View, Overview and Download buttons works correctly?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.ViewOverDownloadRCComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 50) //Bilal Pass
	void RCCompliedPagination() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance Graph – Payroll Compliances - Click on the complied count to verify if the all Pagination buttons works correctly?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RCCompliedPagination(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//Complience Perfromance Graph -- Payroll Compliances --> Overdue
	@Test(priority = 51) //Bilal Pass
	void RCOverdueSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance Graph – Payroll Compliances - Click on the overdue count to verify if the search field works correctly?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RCOverdueSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 52) //Bilal Pass
	void RCOverdueClearExport() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance Graph – Payroll Compliances - Click on the overdue count to verify if the Clear and Export button works correctly?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RCOverdueClearExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 53) //Bilal Pass
	void RCOverdueOverview() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance Graph – Payroll Compliances - Click on the overdue count to verify if the Overview button works correctly?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RCOverdueOverview(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 54) //Bilal Pass
	void RCOverduePagination() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance Graph – Payroll Compliances - Click on the overdue count to verify if the all Pagination buttons works correctly?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RCOverduePagination(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//Compliance Performance -- Establishment Compliances
	@Test(priority = 55) //Bilal Pass
	void searchEcComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance Graph – Establishment Compliances - Click on the complied count to verify if the search field works correctly?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.searchEcComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 56) //Bilal Pass
	void clearbtnEcComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Performance Graph – Establishment Compliances - Click on the complied count to verify if the 'clear button' works correctly?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.clearbtnEcComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 57) //Bilal Pass
	void exportEcComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Performance Graph – Establishment Compliances - Click on the complied count to verify if the 'Export button' works correctly?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.exportEcComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	//Bilal Pass
	@Test(priority = 58) 
	void ECComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Performance Graph – Establishment Compliances - Click on the complied count to verify if the 'View button' works correctly?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.ECComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	//Bilal Pass
	@Test(priority = 59) 
	void overviewECComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Performance Graph – Establishment Compliances - Click on the complied count to verify if the 'Overview button' works correctly?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.overviewECComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 60) 
	void downloadECComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Performance Graph – Establishment Compliances - Click on the complied count to verify if the 'Download button' works correctly?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.downloadECComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 61) 
	void PaginationECComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Performance Graph – Establishment Compliances - Click on the complied count to verify if the all 'Pagination buttons' works correctly?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.PaginationECComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
		
	
	//Establishment Compliances Overdue:
	
	@Test(priority = 62) //Bilal done
	void searchECOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Performance Graph – Establishment Compliances - Click on the overdue count to verify if the 'Search field' works correctly?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.searchECOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 63) //Bilal done
	void clearBtnECOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Performance Graph – Establishment Compliances - Click on the overdue count to verify if the 'Clear button' works correctly?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.clearBtnECOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 64) 
	void exportEC() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Performance Graph – Establishment Compliances - Click on the overdue count to verify if the 'Export button' works correctly?");
		
		All_ClientPortal_Methods.filterEntity(test);
		
		All_ClientPortal_Methods.exportEC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 65) 
	void ECOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Performance Graph – Establishment Compliances - Click on the overdue count to verify if the 'Overview button' works correctly?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.ECOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 66) 
	void ECOverduePagination() throws InterruptedException, IOException
	{
		test = extent.startTest("Compliance Performance Graph – Establishment Compliances - Click on the overdue count to verify if the all 'Pagination buttons' works correctly?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.ECOverduePagination(test);
		
		extent.endTest(test);
		extent.flush();
	}


	
	
	
//     @Test(priority = 68) me
	void FCOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Factory Compliances - Overdue - Overview button working or not");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.FCOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 69) Me
	void exportFC() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Factory Compliances - Overdue - Export button working or not");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.exportFC(test);
		
		extent.endTest(test);
		extent.flush();
	}

	
	
//Comment By Mayuri
//    @Test(priority = 70) 
	void ClraOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Clra Compliances - Overdue - Overview button working or not");
		
		All_ClientPortal_Methods.ClraOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 54) 
	void exportClra() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Clra Compliances - Overdue - Export button working or not");
		
		All_ClientPortal_Methods.exportClra(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 55) 
	void exportCP() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Overdue - Export button working or not");
		
		All_ClientPortal_Methods.exportCP(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 56) //24/02/2025
	void PayrollCompliancesComplie() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Payroll Compliances - Complied - Overview button working or not");
		
		All_ClientPortal_Methods.PayrollCompliancesComplie(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 57) 
	void exportPayrollCompliancesComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Payroll Compliances - Complied - Export button working or not");
		
		All_ClientPortal_Methods.exportPayrollCompliancesComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 58) 
	void FCCompioed() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Factory  Compliances - Complied - Overview button working or not");
		
		All_ClientPortal_Methods.FCCompioed(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 59) 
	void exportFCComplies() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Factory  Compliances - Complied - Export button working or not");
		
		All_ClientPortal_Methods.exportFCComplies(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 60) 
	void ClraComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Clra Compliances - Complied - Overview button working or not");
		
		All_ClientPortal_Methods.ClraComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 61) 
	void exportClraComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Clra Compliances - Complied - Export button working or not");
		
		All_ClientPortal_Methods.exportClraComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	// -- Registration Status Pie Chart
	@Test(priority = 71)
	void RegistrationSExport() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Export button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 72) 
	void RegistrationSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active validate Search field working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
//	@Test(priority = 73) Not Required Because it is taking Active / Expring all count  
	void RegistrationStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active Count Verification");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatus(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 74) //Bilal 2TCs
	void RegistrationStatusActiveColumnCount() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Verify Active column hyper link working and Active count matching with grid or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusActiveColumnCount(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 75) //06/02/2025
	void ActiveSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active - Validate search filter working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.ActiveSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 76) //2 test case //10/02/2025
	void RegistrationStatusExport() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active - Export button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 77) // Bilal 1 done
	void RegistrationActiveEditbtn() throws InterruptedException, IOException
	{
	test = extent.startTest("'Registration Status' - Active - Edit button working or not?");
	
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	All_ClientPortal_Methods.RegistrationActiveEditbtn(test);
	extent.endTest(test);
	extent.flush();
	
	}
	
	@Test(priority = 78) //Bilal 2 done
	void RegistrationActiveEditSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("Registrations Status' - Active - Edit - search field working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationActiveEditSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 79) //Bilal 3 Done
	void RegistrationActiveEditExport() throws InterruptedException, IOException
	{
		test = extent.startTest("Registrations Status' - Active - Edit - Export button is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationActiveEditExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 80) //Bilal 4 Done
	void RegistrationActiveEditClear() throws InterruptedException, IOException
	{
		test = extent.startTest("Registrations Status' - Active - Edit - Clear button is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationActiveEditClear(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 81) //Bilal 5 Done
	void RegistrationActiveEditView() throws InterruptedException, IOException
	{
		test = extent.startTest("Registrations Status' - Active - Edit - View button is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationActiveEditView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 82) //Bilal ---
	void RegistrationActiveEditInitiateActionSubmit() throws InterruptedException, IOException
	{
		test = extent.startTest("Registrations Status' - Active - Edit - InitiateAction Submit button is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationActiveEditInitiateActionSubmit(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 83) //Bilal 6 Done
	void RegistrationActiveEditInitiateAction() throws InterruptedException, IOException
	{
		test = extent.startTest("Registrations Status' - Active - Edit - InitiateAction Back button is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationActiveEditInitiateAction(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 84) //Bilal 7 test case is failing 
	void RegistrationActiveEditDownloadbtn() throws InterruptedException, IOException
	{
		test = extent.startTest("Registrations Status' - Active - Edit - Download button is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationActiveEditDownloadbtn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 85) //07/02/2025
	void RegistrationSView() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active - view button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 86) //07/02/2025
	void DownloadActive() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active - Download button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.DownloadActive(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 87) //07/02/2025 //Search Bilal
	void RegistrationSHistory() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active - History button and Type to search field are working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSHistory(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 88) //07/02/2025
	void RegistrationSHistoryExport() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active - History - Export button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSHistoryExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 89) //07/02/2025
	void RegistrationSActivePagination() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active - Verify to check all Pagination buttons are working fine or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSActivePagination(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	
	@Test(priority = 90) //Bilal
	void RegistrationStatusEx() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Verify Expired link is working and Expired count is matching with grid or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEx(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	
	@Test(priority = 91) //2 test case //24/02/2025
	void RegistrationStatusExportE() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Export button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusExportE(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 92) //25/02/2025
	void ExpiredSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Validate Search field working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.ExpiredSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 93) //Bilal 8 Done
	void RegistrationStatusEdit() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Edit button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEdit(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 94) //Bilal 9 Done
	void RegistrationStatusEditSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Edit - Search field working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEditSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 95) //Bilal 10 Done
	void RegistrationStatusEditExport() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Edit - Export button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEditExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 96) //Bilal 11 Done
	void RegistrationStatusEditClearbtn() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Edit - Clear button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEditClearbtn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 97) //Bilal 12 Done
	void RegistrationStatusEditView() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Edit - View button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEditView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 98) //Bilal 13 Done
	void RegistrationStatusEditInitiateAction() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Edit - InitiateAction Back button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEditInitiateAction(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 99) //Bilal 14 failed file is not getting download
	void RegistrationStatusEditDownloadbtn() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Edit - Download button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusEditDownloadbtn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 100) //25/02/2025
	void RegistrationSViewEx() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - View button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSViewEx(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 101) //25/02/2025
	void DownloadActiveEx() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Download button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.DownloadActiveEx(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 102) //25/02/2025
	void RegistrationSHistoryEx() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - History button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSHistoryEx(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 103) //25/02/2025
	void RegistrationSHistorySearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - History - Search field working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSHistorySearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 104) //25/02/2025
	void RegistrationSHistoryExportEx() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - History - Export button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSHistoryExportEx(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 105) //25/02/2025
	void RegistrationSHistoryViewDownload() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - History - View and Download button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationSHistoryViewDownload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 106) //Bilal
	void RegistrationStatusExpiredPagination() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Verify to check all Pagination buttons are working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusExpiredPagination(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 107) //Bilal This is Registration status main screen TC
	void RegistrationStatusPagination() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Verify to check all Pagination buttons are working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.RegistrationStatusPagination(test);
		
		extent.endTest(test);
		extent.flush();
	}

	
	@Test(priority = 108) //07/02/2025
	void OpenStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Open Count Verification in dashboard");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.OpenStatus(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 109) //Bilal
	void NoticeStatusSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Verify to search field is working properly or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.NoticeStatusSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 110) // 
	void exportNoticeStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Export button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.exportNoticeStatus(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 111) //Bilal
	void NoticeStatusOpenHyperLinkCount() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Verify Open link is working and count matching with grid or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.NoticeStatusOpenHyperLinkCount(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 112) 
	void exportOpen() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Open - Export button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.exportOpen(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 113) //
	void OpenView() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Open - View button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.OpenView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 114) //Bilal
	void NoticeStatusOpenPagination() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Open - Verify to check all Pagination buttons are working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.NoticeStatusOpenPagination(test);
		
		extent.endTest(test);
		extent.flush();
	}

	
	@Test(priority = 115) 
	void ClosedStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Closed Count Verification in dashboard");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.ClosedStatus(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 116) 
	void NoticeStatusClosedHyperLinkCount() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Verify Closed link is working and count matching with grid or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.NoticeStatusClosedHyperLinkCount(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 117) 
	void exportClosed() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Closed - Export button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.exportClosed(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 118) 
	void ClosedView() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Closed - View button working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.ClosedView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 119) //Bilal
	void NoticeStatusClosedPagination() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Closed - Verify to check all Pagination buttons are working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.NoticeStatusClosedPagination(test);
		
		extent.endTest(test);
		extent.flush();
	}    
	@Test(priority = 120) //Bilal
	void NoticeStatusOpenClosedCountWithTotalNotices() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Verify to check Open & Closed Notices column count is mathcing with Total Notices Column or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.NoticeStatusOpenClosedCountWithTotalNotices(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 121) //Bilal
	void NoticeStatusPagination() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Verify to check all Pagination buttons are working or not?");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.NoticeStatusPagination(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 122) //Bilal
	void AbstractStatusIsDisplayed() throws InterruptedException, IOException
	{
		test = extent.startTest("Abstract Status - Verify to check Abstract Status graph is displayed or not?");
		
//		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.AbstractStatusIsDisplayed(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
    //Hide due to all baar graphs hide	
/*	
	//Compliances Performance Bar Graph 
	@Test(priority = 112) //Bilal done
	void compliancePerformanceBarGraph() throws InterruptedException, IOException
	{
test = extent.startTest("Compliance Performance bar graph - Verify Search field , Challan dropdown , Apply button , Clear button and Export button is working or not? In Payroll Compliances complied");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.compliancePerformanceBarGraph(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 113) //Bilal done
	void compliancePerformanceBarGraphPRCViewOvewviewDown() throws InterruptedException, IOException
	{
test = extent.startTest("Compliance Performance bar graph - Verify View button , Ovewview button and Download button is working or not? In Payroll Compliances complied");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.compliancePerformanceBarGraphPRCViewOvewviewDown(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 114) //Bilal done
	void compliancePerformanceG() throws InterruptedException, IOException
	{
test = extent.startTest("Compliance Performance bar graph - Verify Search field , Compliance dropdown , Apply button , Clear button and Export is working or not? In Establishment Compliances complied ");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.compliancePerformanceG(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 115) //Bilal done
	void compliancePerformanceECViewOverviewDownload() throws InterruptedException, IOException
	{
test = extent.startTest("Compliance Performance bar graph - Verify to View button , Overview button and Download button is working or not? In Establishment Compliances complied");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.compliancePerformanceECViewOverviewDownload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

    //	Registration Status Graph--
	
//	@Test(priority = 116) //10/02/2025 Failed due to not capturing get.text 
	void RegistrationStatusBar() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Active Licences Count Verification");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationStatusBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 117) //2 test case 
	void RegistrationStatusExportBar() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Total Active Licences - Export button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationStatusExportBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 118) //2 test case 
	void RegistrationStatusGraphSearchBar() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Total Active Licences - Search field working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationStatusGraphSearchBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 119)
	void RegistrationSViewL() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Active Licences - view button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationSViewL(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 120) 
	void DownloadActiveBar() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Active Licences - Download button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.DownloadActiveBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 121)
	void RegistrationSHistoryBar() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Total Active Licences - History button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationSHistoryBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 122) 
	void RegistrationSHistoryExportBar() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Total Active Licences - History - Export button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RegistrationSHistoryExportBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 123) //Bilal Done
	void RSG_ActiveEditSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Total Active Licences - Edit - Search field working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RSG_ActiveEditSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 124) //Bilal Done
	void RSG_ActiveEditClear() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Active Licences - Edit - Clear button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RSG_ActiveEditClear(test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 125) //Bilal Done
	void RSG_ActiveEditExport() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Active Licences - Edit - Export button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RSG_ActiveEditExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 126) //Bilal Done
	void RSG_ActiveEditView() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Active Licences - Edit - View button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RSG_ActiveEditView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 127) //Bilal Done
	void RSG_ActiveEditInitiateAction() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Active Licences - Edit - InitiateAction button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RSG_ActiveEditInitiateAction(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 128) //Bilal Done
	void RSG_ActiveEditInitiateDownload() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Active Licences - Edit - Download button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RSG_ActiveEditInitiateDownload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 129) //Bilal N 27-03-25 
	void RSG_ExpireSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Expired Licences - Search field working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RSG_ExpireSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 130) //Bilal
	void RSG_ExpiredExport() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Expired Licences - Export button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RSG_ExpiredExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 131) //Bilal
	void RSG_ExpiredViewDownload() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Expired Licences - View and Download button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RSG_ExpiredViewDownload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 131) //Bilal
	void RSG_ExpiredHistorySearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Expired Licences - History button and Search Field and Export button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RSG_ExpiredHistorySearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 132) //Bilal - Fail raised an issue
	void RSG_ExpiredHistoryViewDownload() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Expired Licences - History - View and Download button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RSG_ExpiredHistoryViewDownload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 133) //Bilal
	void RSG_ExpiredEditSearchClearExport() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Expired Licences - Edit and Search Clear and Export button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RSG_ExpiredEditSearchClearExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 134) //Bilal
	void RSG_ExpiredEditViewDownload() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Expired Licences - Edit - View and Download button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RSG_ExpiredEditViewDownload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 135) //Bilal
	void RSG_ExpiredEditInitiateAction() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Expired Licences - Edit - InitiateAction Submit and Back button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.RSG_ExpiredEditInitiateAction(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	*/      //Hide due to all baar graphs hide
	
	
	
	
	/*
	
	
	
	
	// ---Compliance Calendar---
	@Test(priority = 137) //2 test case 
	void CalendarNextPreviousToday() throws InterruptedException, IOException
	{
		test = extent.startTest("'My Compliance Calendar - Verify Next & Previous buttons & Today hyper link is working or not?");
//		All_ClientPortal_Methods.filterEntity(test);
		All_ClientPortal_Methods.CalendarNextPreviousToday(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 138) //2 test case 
	void CalendarExport() throws InterruptedException, IOException
	{
		test = extent.startTest("'My Compliance Calendar - Export button working or not?");
		All_ClientPortal_Methods.filterEntity(test);
		All_ClientPortal_Methods.CalendarExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 139) //11/02/2025
	void CalendarCount() throws InterruptedException, IOException
	{
		test = extent.startTest("'My Compliance Calendar - Calendar Count Verification");
		All_ClientPortal_Methods.filterEntity(test);
		All_ClientPortal_Methods.CalendarCount(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 140) 
	void CalendarOverviewPagination() throws InterruptedException, IOException
	{
		test = extent.startTest("'My Compliance Calendar - Overview button & all Pagination buttons are working or not?");
		All_ClientPortal_Methods.filterEntity(test);
		All_ClientPortal_Methods.CalendarOverviewPagination(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 141) 
	void DailyUpdates() throws InterruptedException, IOException
	{
		test = extent.startTest("'Daily Updates - Read more Link working or not?");
//		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.DailyUpdates(test);
		
		extent.endTest(test);
		extent.flush();
	}

	
	
	
//------------------Client Portal Dashborad End-------------------------------	
	
	
	
	
	
	*/
	
	
	
	
	
	
	
	//---------Part 2-------For Daily Execution------

	
	//----------------------------New Input Upload---------------------------------------
	@Test(priority = 200 ,groups={"smoke"}) //Bilal
	void InputUploadFilters() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - To check weather All dropdowns are working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadFilters(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 201) 
	void InputUploadTem() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Attendance - To check whether sample template get downloaded or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadTem(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 202) 
	void InputUpload() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Input Upload - Register - Attendance - Validate Browse and upload file");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUpload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 203) 
	void InputUploadInavlid() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Attendance - Validate upload with Invalid details.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadInavlid(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 204) 
	void InputUploadBlank() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - Validate  upload with Balnk sheet .");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadBlank(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 205) 
	void InputUploadInvalidformate() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Attendance - Validate to upload pdf file");
		
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		
		All_ClientPortal_Methods.InputUploadInvalidformate(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 206) 
	void InputUploadInvalidTemp() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Attendance - Validate to upload invalid template file.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadInvalidTemp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 208) 
	void InputUploadNofile() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Input Upload - Register - Attendance - Validate validation message without file selection upload");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadNofile(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 209)  //12/02/2025
	void IUHistory() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance - History button working or not");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUHistory(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 210)  
	void IUHistoryD() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Attendance - History - Input History get downloaded or not");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUHistoryD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 211) 
	void InputUploadTemSa() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Salary - To check whether sample template get downloaded or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadTemSa(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 212) 
	void InputUploadSA() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Input Upload - Register - Salary - Validate Browse and upload file.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadSA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 213) 
	void InputUploadInavlidSA() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Salary - Validate upload with Invalid details.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadInavlidSA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 214) //13/02/2025
	void InputUploadBlankSa() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Salary - Validate  upload with Balnk sheet.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadBlankSa(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 215) 
	void InputUploadInvalidformateSa() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Salary - Validate error message for the invalid formate file upload.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadInvalidformateSa(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 216) 
	void InputUploadInvalidTempSa() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Salary - Validate error message displayed for invalid template file upload.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadInvalidTempSa(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 217) 
	void InputUploadNofileSa() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Salary - Validate validation message for the no choose file clicking on upload");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadNofileSa(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 218)  
	void IUHistorySa() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Salary - History button working or not");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUHistorySa(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 219)  
	void IUHistoryDSA() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Salary - History - Input History get downloaded or not");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUHistoryDSA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 220)  //Bilal
	void IUFianlUploadDownload() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Salary - Attendance and Salary Final Upload download or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUFianlUploadDownload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 221)  
	void IUFianlUploadDownloadSalary() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Register - Salary - Salary Final Upload download or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUFianlUploadDownloadSalary(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 222) 
	void InputUploadTemChha() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - To check whether sample template get downloaded or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadTemChha(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 223) 
	void InputUploadCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - Validate browse and upload file");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 223) 
	void InputUploadInavlidCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - Validate upload with Invalid details.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadInavlidCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 224) 
	void InputUploadBlankCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Challan - Salary  - Validate  upload with Balnk sheet.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadBlankCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 225) //14/02/2025
	void InputUploadInvalidformateCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - Validate error message for the invalid formate file upload.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadInvalidformateCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 226) 
	void InputUploadInvalidTempCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - Validate error message displayed for invalid template file upload.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadInvalidTempCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 227) 
	void InputUploadNofileCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - Validate validation message for the no choose file clicking on upload");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadNofileCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 228)  
	void IUHistoryCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - History button working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUHistoryCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 229)  
	void IUHistoryDCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Challan - Salary - History - Input History get downloaded or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUHistoryDCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
      //104 to 112 Comment By Mayuri---
//	  @Test(priority = 230) 
	void InputUploadTemRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Return - Salary - To check whether sample template get downloaded or not from input web upload tab.");
		
		All_ClientPortal_Methods.InputUploadTemRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 231) 
	void InputUploadRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Return - Salary - Validate  upload with valid details.");
		
		All_ClientPortal_Methods.InputUploadRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 232) //Bilal 2Tc
	void InputUploadReturn() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Return - Salary - Validate to download template and upload file.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadReturn(test);
		
		extent.endTest(test);
		extent.flush();
	}
	@Test(priority = 233) //Bilal 
	void InputUploadReturnOtherUp() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Return - Salary - Validate to upload Other Files.");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadReturnOtherUp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 234) 
	void InputUploadInavlidRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Return - Salary - Validate upload with Invalid details.");
		
		All_ClientPortal_Methods.InputUploadInavlidRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 235) 
	void InputUploadBlankRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Return - Salary - Validate  upload with Balnk sheet.");
		
		All_ClientPortal_Methods.InputUploadBlankRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 236) 
	void InputUploadInvalidformateRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Return - Salary - Validate error message for the invalid formate file upload.");
		
		All_ClientPortal_Methods.InputUploadInvalidformateRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 237) 
	void InputUploadInvalidTempRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Return - Salary  - Validate error message displayed for invalid template file upload.");
		
		All_ClientPortal_Methods.InputUploadInvalidTempRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 238) 
	void InputUploadNofilere() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload - Return - Salary - Validate validation message for the no choose file clicking on upload");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.InputUploadNofilere(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 239)  
	void IUHistoryRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Input Upload - Return - Salary - History button is working or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUHistoryRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 240)  
	void IUHistoryDRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Input Upload - Return - Salary - History - Input History get downloaded or not?");
		All_ClientPortal_Methods.filterEntityAUTO2(test);
		All_ClientPortal_Methods.IUHistoryDRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	
	
	
	
	
//------------License-----Registration----------	
	
	     //Snehal TC - ClientPortalTestCase.Java 
	
	   @Test(priority = 241)
   	    void AddNewLicense() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Add New License Request");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.AddNewLicense(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 242)
   	void ExportBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Export Button verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.ExportBtn(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
   @Test(priority = 243)
   	void SearchBox() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Search Box verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.SearchBox(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 244)
   	void EditIcon() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit Icon verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.EditIcon(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 245)//Bilal Pass
   	void EditIconChecktabs() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit Icon - Check weather All tabs is displayed or not?");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.EditIconChecktabs(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 246) //Bilal Pass
   	void EditIconsMiniTabs() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit Icon - Check License Request Details Tabs will opened or not?");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.EditIconsMiniTabs(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
//	@Test(priority = 247) // Bilal Pending due to click is not working in +Activity Closure
   	void EditIconsMiniTabsRCP() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit Icon - Check All Tabs is open or not?");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.EditIconsMiniTabsRCP(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
//	@Test(priority = 248) //Bilal Pending due to not able to click 'Document Requirements for the OT Activity'
   	void EditIconUploadDoc() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Edit Icon - Check browse and submit document in 'Document Requirements for the OT Activity'");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.EditIconUploadDoc(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
@Test(priority = 249)
   	void ExsitingLicenseExport() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing license -Export Button verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.ExistingLicsneExportBtn(test,workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority = 250)
   	void SearchBoxExistiongLicense() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing Licenses -Search Box verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.SearchBoxExistiongLicense(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 251)
   	void ExistingLicenseViewIcon() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing Licenses -View Icon verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.ExistingLicenseViewIcon(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority = 252)
   	void ExistingLicenseInitiateAction() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing Licenses -Initiate Action- SubActivity verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.ExistingLicenseInitiateAction(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority = 253)
   	void ExistingLicenseDownload() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing Licenses - Download Button verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.ExistingLicenseDownload(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
//	@Test(priority = 254)//Pending
  	void ExistingLicenseSubActivityViewandDownload() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration - Existing Licenses -click Entity tringle - View and  Download Button verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.ExistingLicenseSubActivityViewandDownload(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
  	
  	
  	
  	
  	
//--------License-->Regitration Repository---
	
	@Test(priority = 256)
   	void RegisrationRespository() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration Repostory - View and Download Button verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.RegisrationRespository(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority = 257)
   	void RegistrationRepositoryFilter() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration Repostory - Filter verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.RegistrationRepositoryFilter(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority = 258)
   	void RegistrationRepositoryExportBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Registration Repostory - Export button verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.RegistrationRepositoryExportBtn(test,workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
   	




  //--------------------Notices--------------------
   	
 	@Test(priority = 259)
   	void AddNewNotices() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Add New Notices verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.AddNewNotices(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
 @Test(priority = 260)
   	void ExistingNoticesNo() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices -Existing Notice No verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.ExistingNoticesNo(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 261)
   	void NoticeDocMandatory() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices -Notice document manadatory or not verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.NoticeDocMandatory(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
 	
	@Test(priority = 262)
   	void NoticeExportBtn() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Export Button verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.NoticeExportBtn(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}	
	@Test(priority = 263)
   	void NoticeEditDownloadView() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices - Edit,Download and view verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.NoticeEditDownloadView(test);
   		
   		extent.endTest(test);

   	}	
@Test(priority = 264)
   	void NoticeSearchBox() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
   	{
   		test = extent.startTest("Notices -Search Box and clear Button verification");
   		All_ClientPortal_Methods.filterEntityAUTO2(test);
   		
   		All_ClientPortal_Methods.NoticeSearchBox(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}	
   	
   			@Test(priority = 265) //Bilal 
	   	void NoticeEditAllTabs() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
	   	{
	   		test = extent.startTest("Notices - Edit - Check weather all tabs will displayed or not?");
	   		All_ClientPortal_Methods.filterEntityAUTO2(test);
	   		
	   		All_ClientPortal_Methods.NoticeEditAllTabs(test);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
	   	
	   	@Test(priority = 266) //Bilal TC 5
	   	void NoticeEditDocumentRepositoryDownload() throws InterruptedException, IOException, EncryptedDocumentException, AWTException
	   	{
	   		test = extent.startTest("Notices - Edit - Check weather documents in document repository is downloaded or not?");
	   		All_ClientPortal_Methods.filterEntityAUTO2(test);
	   		
	   		All_ClientPortal_Methods.NoticeEditDocumentRepositoryDownload(test);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}




//---------------------Abstracts------------------------------

@Test(priority = 267)
void RegionalDocView() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Abstracts - Regional view document Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	
	All_ClientPortal_Methods.RegionalDocView(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 268)
void RegionalDocDownload() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Abstracts - Regional download document Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	
	All_ClientPortal_Methods.RegionalDocDownload(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 269)
void EnglishDocView() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Abstracts - English view document Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	
	All_ClientPortal_Methods.EnglishDocView(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 270)
void EnglishDocDownload() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Abstracts - English download document Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	
	All_ClientPortal_Methods.EnglishDocDownload(test);
	
	extent.endTest(test);
	extent.flush();

}

@Test(priority = 271)
void SearchBoxMasterAbstract() throws InterruptedException, IOException, AWTException {
	test = extent.startTest("Abstracts - Search box Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);

	All_ClientPortal_Methods.SearchBoxMasterAbstarct(test);

	extent.endTest(test);
	extent.flush();

}












///------My Document-->Statutory document-----

@Test(priority = 272)
void StatutoryDocApplyClaerBtn() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Apply Button and clear Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	
	All_ClientPortal_Methods.StatutoryDocApplyClaerBtn(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 273)
void StatutoryDocFilter() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Filter Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	
	All_ClientPortal_Methods.StatutoryDocFilter(test);
	
	extent.endTest(test);
	extent.flush();

}
   @Test(priority = 274)
void StateDocZipFile() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document- Registor Compliance Type -Action Column -Zip File Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	
	All_ClientPortal_Methods.StateDocZipFile(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 275)
void StatutoryDocViewandOverview() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Registor Compliance Type -Action Column -View button Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	
	All_ClientPortal_Methods.StatutoryDocViewandOverview(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 276)
void StatutoryDocBulkDownload() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Registor Compliance Type - download button Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	
	All_ClientPortal_Methods.StatutoryDocBulkDownload(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 277)
void ChallanDoc() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Challan Compliance Type - select checkbox -download button Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	
	All_ClientPortal_Methods.ChallanDoc(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 278)
void ChallanComplianceDoc() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Challan Compliance Type - compliance download button Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	
	All_ClientPortal_Methods.ChallanComplianceDoc(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 279)
void ChallanViewBranchese() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Challan Compliance Type -View branches Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	
	All_ClientPortal_Methods.ChallanViewBranches(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 280)
void ChallanViewWorkingFile() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Challan Compliance Type -View working file Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	
	All_ClientPortal_Methods.ChallanViewWorkingFile(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 281)
void ChallanViewComplianceFile() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Challan Compliance Type -View compliance file Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	
	All_ClientPortal_Methods.ChallanViewComplianceFile(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority = 282)
void ChallanDocBulkDownload() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Challan Compliance Type - working file download button Verification");
	All_ClientPortal_Methods.filterEntityAUTO2(test);
	
	All_ClientPortal_Methods.ChallanDocBulkDownload(test);
	
	extent.endTest(test);
	extent.flush();

}



	
	
	
	// Shetal TCs Critical Documents 
	
	//   @Test(priority = 283)  //Shetal Hide due to Statury Documents already done 
		void MultipleDocument() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Statutory Documents - Multiple documnet Downloaded.");
			All_ClientPortal_Methods.filterEntityAUTO2(test);
			
			All_ClientPortal_Methods.MultipleDocument(test);
			
			extent.endTest(test);
			extent.flush();
		}
	   
	 //   @Test(priority = 284)
		void MultipleDocumentDownload() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Statutory Documents - documnet Downloaded Verification");
			
			All_ClientPortal_Methods.MyDocument(test);
			
			extent.endTest(test);
			extent.flush();
		}
	   
	//  @Test(priority = 285)
		void MyDocumentView() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Statutory Documents - Documnet View Verification");
			
			All_ClientPortal_Methods.MyDocumentView(test);
			
			extent.endTest(test);
			extent.flush();
		}
	   
	//	 @Test(priority = 286)
			void MyDocumentFilter() throws InterruptedException, IOException, AWTException
			{
				test = extent.startTest("Statutory Documents - Multiple Filter Verification");
				
				All_ClientPortal_Methods.MyDocumentFilter(test);
				
				extent.endTest(test);
				extent.flush();
			}
	//		@Test(priority = 287)
			void MyDocumentAllTab() throws InterruptedException, IOException, AWTException
			{
				test = extent.startTest("Statutory Documents ");
				
				All_ClientPortal_Methods.MyDocumentAllTab(test);
				
				extent.endTest(test);
				extent.flush();
			}
		
			@Test(priority = 288) 
			void CriticalDocument() throws InterruptedException, IOException, AWTException
			{
				test = extent.startTest("Critical Document - Check to Create Folder");
				All_ClientPortal_Methods.filterEntityAUTO2(test);
				
				All_ClientPortal_Methods.CriticalDocument(test);
				
				extent.endTest(test);
				extent.flush();
			}
			@Test(priority = 289)
			void CriticalDocumentSubFolder() throws InterruptedException, IOException, AWTException
			{
				test = extent.startTest("Critical Document - Sub folder Critical Document");
				All_ClientPortal_Methods.filterEntityAUTO2(test);
				
				All_ClientPortal_Methods.CriticalDocumentSubFolder(test);
				
				extent.endTest(test);
				extent.flush();
			}
			
			@Test(priority = 290)
			void CriticalDocumentNewFile() throws InterruptedException, IOException, AWTException {
				test = extent.startTest("Critical Document - Check to Add/Upload New File");
				All_ClientPortal_Methods.filterEntityAUTO2(test);

				All_ClientPortal_Methods.CriticalDocumentNewFile(test);

				extent.endTest(test);
				extent.flush();
			}
			
			@Test(priority = 291) // me (need to add full access and other scenarios)
			void CriticalDocumentshare() throws InterruptedException, IOException, AWTException {
				test = extent.startTest("Critical Document - Share folder to another user");
				All_ClientPortal_Methods.filterEntityAUTO2(test);

				All_ClientPortal_Methods.CriticalDocumentshare(test);

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


