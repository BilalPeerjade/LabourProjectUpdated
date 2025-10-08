package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

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

import clientPortal.ClientMethods;
import distributor.Methods;
import login.BasePage;

public class ClientsTest extends BasePage {
	
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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\Labour.html",true);
		test = extent.startTest("Loging In -Client Portal");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,6,"Statutory");
		ClientMethods.filterEntity(test);
	
	}
	
	
	
	@Test(priority = 1) //04/02/2025
	void Entities() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on 'Entities'");
		
		ClientMethods.Entities(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 2) 
	void EntitiesSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Entity search filter working or not");
		
		ClientMethods.EntitiesSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 3)
	void Locations() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on 'Locations'");
		
		ClientMethods.Locations(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 4)
	void LocationsSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("Validate Locations search filter working or not");
		
		ClientMethods.LocationsSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5)
	void AssignedCompliances() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on 'Assigned Compliances'");
		
		ClientMethods.AssignedCompliances(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6)
	void exportcount() throws InterruptedException, IOException
	{
		test = extent.startTest("Assigned Compliances - Export button working or not");
		
		ClientMethods.exportcount(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 7)
	void OverviewAC() throws InterruptedException, IOException
	{
		test = extent.startTest("Assigned Compliances - Overview button working or not");
		
		ClientMethods.OverviewAC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void ExpiredRegistrations() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on 'Expired Registrations'");
		
		ClientMethods.ExpiredRegistrations(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void ExpiredRegistrationsEdit() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' -Edit button working or not ");
		
		ClientMethods.ExpiredRegistrationsEdit(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void exportER() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' - Edit - Export button working or not");
		
		ClientMethods.exportER(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void ERSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' -Edit - Validate Notice search filter working or not");
		
		ClientMethods.ERSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void ERSearchClear() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' -Edit - Validate clear button working or not");
		
		ClientMethods.ERSearchClear(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void ERview() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' -Edit - Validate View button working or not");
		
		ClientMethods.ERview(test);
		
		extent.endTest(test);
		extent.flush();
	}
	

	@Test(priority = 8)
	void ERviewBack() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' -Edit - Validate Back button working or not");
		
		ClientMethods.ERviewBack(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void InitiateAction() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' -Edit - Validate InitiateAction button working or not");
		
		ClientMethods.InitiateAction(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void InitiateActionBack() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' -Edit - InitiateAction - Validate Back button working or not");
		
		ClientMethods.InitiateActionBack(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 8)
	void exportERE() throws InterruptedException, IOException
	{
		test = extent.startTest("'Expired Registrations' -Edit - Validate Download button working or not");
		
		ClientMethods.exportERE(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 9)
	void OpenNotices() throws InterruptedException, IOException
	{
		test = extent.startTest("Count by Clicking on 'Open Notices'");
		
		ClientMethods.OpenNotices(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 10)
	void OpenNoticesView() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - view button working or not ");
		
		ClientMethods.OpenNoticesView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
//	@Test(priority = 11)//05/02/2025
	void ViewAddNew() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Open Notices' - view - add new button working or not ");
		
		ClientMethods.ViewAddNew(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 12)
	void exportNotice() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Open Notices' - view - Export button working or not ");
		
		ClientMethods.exportNotice(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 13)
	void NoticeSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - view - Validate Notice search filter working or not");
		
		ClientMethods.NoticeSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 14)
	void NoticeSearchClear() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - view - Validate Notice clear button working or not");
		
		ClientMethods.NoticeSearchClear(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 15)
	void OpenNoticesEditback() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - view - edit - Validate Notice Back button working or not");
		
		ClientMethods.OpenNoticesEditback(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 16)
	void OverviewNotice() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - view - Overview button working or not");
		
		ClientMethods.OverviewNotice(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 17)
	void OpenNoticesback() throws InterruptedException, IOException
	{
		test = extent.startTest("'Open Notices' - edit - Validate Notice Back button working or not");
		
		ClientMethods.OpenNoticesback(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 18)
	void RegistrationSExport() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status'  - Export button working or not");
		
		ClientMethods.RegistrationSExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 19) 
	void RegistrationSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active Validate search filter working or not");
		
		ClientMethods.RegistrationSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 20)
	void RegistrationStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active Count Verification");
		
		ClientMethods.RegistrationStatus(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 21) //2 test case //10/02/2025
	void RegistrationStatusExport() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Active - Export button working or not");
		
		ClientMethods.RegistrationStatusExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 22) //07/02/2025
	void RegistrationSView() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Active - view button working or not");
		
		ClientMethods.RegistrationSView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 23) //07/02/2025
	void DownloadActive() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Active - Download button working or not");
		
		ClientMethods.DownloadActive(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 24) //07/02/2025
	void RegistrationSHistory() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Active - History button working or not");
		
		ClientMethods.RegistrationSHistory(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 25) //07/02/2025
	void RegistrationSHistoryExport() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Active - History - Export button working or not");
		
		ClientMethods.RegistrationSHistoryExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 26) //06/02/2025
	void ActiveSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Active - Validate search filter working or not");
		
		ClientMethods.ActiveSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 27) //24/02/2024
	void RegistrationStatusEx() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired Count Verification");
		
		ClientMethods.RegistrationStatusEx(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 28) //2 test case //24/02/2025
	void RegistrationStatusExportE() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Expired - Export button working or not");
		
		ClientMethods.RegistrationStatusExportE(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 29) //25/02/2025
	void RegistrationSViewEx() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Expired - view button working or not");
		
		ClientMethods.RegistrationSViewEx(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 30) //25/02/2025
	void DownloadActiveEx() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Expired - Download button working or not");
		
		ClientMethods.DownloadActiveEx(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 31) //25/02/2025
	void RegistrationSHistoryEx() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Expired - History button working or not");
		
		ClientMethods.RegistrationSHistoryEx(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 32) //25/02/2025
	void RegistrationSHistoryExportEx() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Expired - History - Export button working or not");
		
		ClientMethods.RegistrationSHistoryExportEx(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 33) //25/02/2025
	void ExpiredSearch() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Expired - Validate search filter working or not");
		
		ClientMethods.ExpiredSearch(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	/*   // Comment by Mayuri
//	@Test(priority = 34) //pending //06/02/2025
	void CompliancePerformance() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Overdue Count Verification");
		
		ClientMethods.CompliancePerformance(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 35) 
	void PayrollCompliancesOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Payroll Compliances - Overdue - Overview button working or not");
		
		ClientMethods.PayrollCompliancesOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 36) 
	void exportPayrollCompliancesOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Payroll Compliances - Overdue - Export button working or not");
		
		ClientMethods.exportPayrollCompliancesOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	*/
	@Test(priority = 37) 
	void ECOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Establishment Compliances - Overdue - Overview button working or not");
		
		ClientMethods.ECOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 38) 
	void exportEC() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Establishment Compliances - Overdue - Export button working or not");
		
		ClientMethods.exportEC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 39) 
	void FCOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Factory Compliances - Overdue - Overview button working or not");
		
		ClientMethods.FCOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 40) 
	void exportFC() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Factory Compliances - Overdue - Export button working or not");
		
		ClientMethods.exportFC(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
/*	@Test(priority = 41) 
	void ClraOverdue() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Clra Compliances - Overdue - Overview button working or not");
		
		ClientMethods.ClraOverdue(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 42) 
	void exportClra() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Clra Compliances - Overdue - Export button working or not");
		
		ClientMethods.exportClra(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 43) 
	void exportCP() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Overdue - Export button working or not");
		
		ClientMethods.exportCP(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 44) //24/02/2025
	void PayrollCompliancesComplie() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Payroll Compliances - Complied - Overview button working or not");
		
		ClientMethods.PayrollCompliancesComplie(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 45) 
	void exportPayrollCompliancesComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Payroll Compliances - Complied - Export button working or not");
		
		ClientMethods.exportPayrollCompliancesComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 46) 
	void ECComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Establishment Compliances - Complied - Overview button working or not");
		
		ClientMethods.ECComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 47) 
	void exportEcComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Establishment Compliances - Complied - Export button working or not");
		
		ClientMethods.exportEcComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 48) 
	void FCCompioed() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Factory  Compliances - Complied - Overview button working or not");
		
		ClientMethods.FCCompioed(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 49) 
	void exportFCComplies() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Factory  Compliances - Complied - Export button working or not");
		
		ClientMethods.exportFCComplies(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 50) 
	void ClraComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Clra Compliances - Complied - Overview button working or not");
		
		ClientMethods.ClraComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 51) 
	void exportClraComplied() throws InterruptedException, IOException
	{
		test = extent.startTest("'Compliance Performance' - Clra Compliances - Complied - Export button working or not");
		
		ClientMethods.exportClraComplied(test);
		
		extent.endTest(test);
		extent.flush();
	}*/
	
	@Test(priority = 52) //07/02/2025
	void OpenStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Open Count Verification");
		
		ClientMethods.OpenStatus(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 53) 
	void OpenView() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Open - Overview button working or not");
		
		ClientMethods.OpenView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 54) 
	void exportOpen() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Open - Export button working or not");
		
		ClientMethods.exportOpen(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 55) 
	void ClosedStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Closed Count Verification");
		
		ClientMethods.ClosedStatus(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 56) 
	void ClosedView() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Closed - Overview button working or not");
		
		ClientMethods.ClosedView(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 57) 
	void exportClosed() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Closed -  Export button working or not");
		
		ClientMethods.exportClosed(test);
		
		extent.endTest(test);
		extent.flush();
	}

	@Test(priority = 58) 
	void exportNoticeStatus() throws InterruptedException, IOException
	{
		test = extent.startTest("'Notice Status' - Export button working or not");
		
		ClientMethods.exportNoticeStatus(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 59) //10/02/2025
	void RegistrationStatusBar() throws InterruptedException, IOException
	{
		test = extent.startTest("'Registration Status' - Total Active Licences Count Verification");
		
		ClientMethods.RegistrationStatusBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 60) //2 test case 
	void RegistrationStatusExportBar() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Total Active Licences - Export button working or not");
		
		ClientMethods.RegistrationStatusExportBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 61)
	void RegistrationSViewL() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Total Active Licences  - view button working or not");
		
		ClientMethods.RegistrationSViewL(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 62) 
	void DownloadActiveBar() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Total Active Licences - Download button working or not");
		
		ClientMethods.DownloadActiveBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 63)
	void RegistrationSHistoryBar() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Total Active Licences - History button working or not");
		
		ClientMethods.RegistrationSHistoryBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 64) 
	void RegistrationSHistoryExportBar() throws InterruptedException, IOException
	{
		test = extent.startTest("''Registration Status' - Total Active Licences - History - Export button working or not");
		
		ClientMethods.RegistrationSHistoryExportBar(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 65) //2 test case 
	void CalendarExport() throws InterruptedException, IOException
	{
		test = extent.startTest("'My Compliance Calendar - Export button working or not");
		
		ClientMethods.CalendarExport(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 66) //11/02/2025
	void CalendarCount() throws InterruptedException, IOException
	{
		test = extent.startTest("'My Compliance Calendar - Calendar Count Verification");
		
		ClientMethods.CalendarCount(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 67) 
	void CalendarOverview() throws InterruptedException, IOException
	{
		test = extent.startTest("'My Compliance Calendar - Overview button working or not");
		
		ClientMethods.CalendarOverview(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 68) 
	void DailyUpdates() throws InterruptedException, IOException
	{
		test = extent.startTest("'Daily Updates - Read more Link working or not");
		
		ClientMethods.DailyUpdates(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 69) 
	void InputUploadTem() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - To check whether sample template get downloaded or not from input web upload tab.");
		
		ClientMethods.InputUploadTem(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 70) 
	void InputUpload() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - Validate  upload with valid details.");
		
		ClientMethods.InputUpload(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 71) 
	void InputUploadInavlid() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - Validate  upload with Invalid details.");
		
		ClientMethods.InputUploadInavlid(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 72) 
	void InputUploadBlank() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - Validate  upload with Balnk sheet .");
		
		ClientMethods.InputUploadBlank(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 73) 
	void InputUploadInvalidformate() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - Validate error message for the invalid formate file upload.");
		
		ClientMethods.InputUploadInvalidformate(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 74) 
	void InputUploadInvalidTemp() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - Validate error message displayed for invalid template file upload.");
		
		ClientMethods.InputUploadInvalidTemp(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 75) 
	void InputUploadNofile() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - Validate validation message for the no choose file clicking on upload");
		
		ClientMethods.InputUploadNofile(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 76)  //12/02/2025
	void IUHistory() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - History button working or not");
		
		ClientMethods.IUHistory(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 77)  
	void IUHistoryD() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Attendance  - History - Input History get downloaded or not");
		
		ClientMethods.IUHistoryD(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 78) 
	void InputUploadTemSa() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Salary   - To check whether sample template get downloaded or not from input web upload tab.");
		
		ClientMethods.InputUploadTemSa(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 79) 
	void InputUploadSA() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Salary   - Validate  upload with valid details.");
		
		ClientMethods.InputUploadSA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 80) 
	void InputUploadInavlidSA() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Salary  - Validate upload with Invalid details.");
		
		ClientMethods.InputUploadInavlidSA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 81) //13/02/2025
	void InputUploadBlankSa() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Salary  - Validate  upload with Balnk sheet.");
		
		ClientMethods.InputUploadBlankSa(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 82) 
	void InputUploadInvalidformateSa() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Salary  - Validate error message for the invalid formate file upload.");
		
		ClientMethods.InputUploadInvalidformateSa(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 83) 
	void InputUploadInvalidTempSa() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Salary  - Validate error message displayed for invalid template file upload.");
		
		ClientMethods.InputUploadInvalidTempSa(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 84) 
	void InputUploadNofileSa() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Salary  - Validate validation message for the no choose file clicking on upload");
		
		ClientMethods.InputUploadNofileSa(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 85)  
	void IUHistorySa() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Salary  - History button working or not");
		
		ClientMethods.IUHistorySa(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 86)  
	void IUHistoryDSA() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Register - Salary  - History - Input History get downloaded or not");
		
		ClientMethods.IUHistoryDSA(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 87) 
	void InputUploadTemChha() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Challan - Salary   - To check whether sample template get downloaded or not from input web upload tab.");
		
		ClientMethods.InputUploadTemChha(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 88) 
	void InputUploadCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Challan - Salary   - Validate  upload with valid details.");
		
		ClientMethods.InputUploadCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 89) 
	void InputUploadInavlidCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Challan - Salary  - Validate upload with Invalid details.");
		
		ClientMethods.InputUploadInavlidCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 90) 
	void InputUploadBlankCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Challan - Salary  - Validate  upload with Balnk sheet.");
		
		ClientMethods.InputUploadBlankCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 91) //14/02/2025
	void InputUploadInvalidformateCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Challan - Salary  - Validate error message for the invalid formate file upload.");
		
		ClientMethods.InputUploadInvalidformateCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 92) 
	void InputUploadInvalidTempCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Challan - Salary  - Validate error message displayed for invalid template file upload.");
		
		ClientMethods.InputUploadInvalidTempCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 93) 
	void InputUploadNofileCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Challan - Salary  - Validate validation message for the no choose file clicking on upload");
		
		ClientMethods.InputUploadNofileCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 94)  
	void IUHistoryCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Challan - Salary  - History button working or not");
		
		ClientMethods.IUHistoryCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 95)  
	void IUHistoryDCh() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Challan - Salary  - History - Input History get downloaded or not");
		
		ClientMethods.IUHistoryDCh(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	/*@Test(priority = 96) 
	void InputUploadTemRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Return - Salary   - To check whether sample template get downloaded or not from input web upload tab.");
		
		ClientMethods.InputUploadTemRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 97) 
	void InputUploadRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Return - Salary   - Validate  upload with valid details.");
		
		ClientMethods.InputUploadRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 98) 
	void InputUploadInavlidRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Return - Salary  - Validate upload with Invalid details.");
		
		ClientMethods.InputUploadInavlidRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 99) 
	void InputUploadBlankRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Return - Salary  - Validate  upload with Balnk sheet.");
		
		ClientMethods.InputUploadBlankRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 100) 
	void InputUploadInvalidformateRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Return - Salary  - Validate error message for the invalid formate file upload.");
		
		ClientMethods.InputUploadInvalidformateRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 101) 
	void InputUploadInvalidTempRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Return - Salary  - Validate error message displayed for invalid template file upload.");
		
		ClientMethods.InputUploadInvalidTempRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 102) 
	void InputUploadNofilere() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Return - Salary  - Validate validation message for the no choose file clicking on upload");
		
		ClientMethods.InputUploadNofilere(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 103)  
	void IUHistoryRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Return - Salary  - History button working or not");
		
		ClientMethods.IUHistoryRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 104)  
	void IUHistoryDRe() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("'Input Upload  - Return - Salary  - History - Input History get downloaded or not");
		
		ClientMethods.IUHistoryDRe(test);
		
		extent.endTest(test);
		extent.flush();
	}
	
	*/
	
	
	
	
	//setTimeout(()=>{debugger},3000)
	
	//issues  
	//Pending scripts
	//Open Notices -download ,delete
//	Registration Status' - Active - History -view ,download search data not load
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
