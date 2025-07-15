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
import distributor.Methods;
import distributor.MethodsD;
import distributor.All_Distributor_Methods;
import login.BasePage;
import login.LoginLocators;
import performer.LocatorsP;
import performer.MethodsP;
import performer.PerformerMethod;
import rcp.OneCommonMethod;





public class All_Distributor_TWO  extends BasePage {
	
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
			test = extent.startTest(" Count by Clicking on Register - 'Action/Review'");
			
		//	All_Distributor_Methods.RegisterActionReview(test,"Distributor");
			MethodsD.RegisterActionReview(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 67)
		void ReturnUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Returns - 'Upcoming'");
			
		//	All_Distributor_Methods.ReturnUpcoming(test,"Distributor");
			MethodsD.ReturnUpcoming(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 69)
		void ReturnOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Returns - 'Overdue'");
			
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
			
		//	All_Distributor_Methods.Complied(test,"Distributor");
			MethodsD.Complied(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 85) //Need to add below test case for complied filter test cases 
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
		
		
		
		
		//Manage Masters
		@Test(priority = 100) //Bilal
	   	void StateCitySearch() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check Search State/Location Code dropdown is working or not");
	   		
	   		PerformerMethod.StateCitySearch(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 101) //Bilal
	   	void StateCityAddressMapping() throws Exception
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check address mapping button is working or not?");
	   		
	   		PerformerMethod.StateCityAddressMapping(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 102) //Bilal
	   	void StateCitySealANDSignatureInvalid() throws Exception
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check error without file selection and upload more than 4 kb file in seal and signature upload ");
	   		
	   		PerformerMethod.StateCitySealANDSignatureInvalid(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		
		
		@Test(priority = 109) //Bilal
	   	void DesignationSearch() throws InterruptedException, IOException
	   	{
test = extent.startTest("Manage Master - Designation - Verify to check Search/Select Designation dropdown is working or not");
	   		   		
	   		PerformerMethod.DesignationSearch(test, workbook , "Distributor");

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
		
		
		//-----------*****On board Entity:*****------------
	    //Premises: 
		@Test(priority = 160) 
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
		void Mapuser() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Onboard Entity - User-Branch Mapping - Verify to check Map User button is working or not?");
			
			Methods.Mapuser(test);
			  
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		
		
//Onboard Entity --> Manage Compliance: 
		
		//Activataion Date Change 
		
		
		//Assignment Removal
		
		
		//Compliance Reassignment:
		@Test(priority = 240) 
	   	void ComplainceReassignment() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Onboard Entity - Manage Compliance - Verify to check compliance reassignment is working or not?");
	   		 
	   		All_Distributor_Methods.ComplainceReassignment(test, workbook);
	   		
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
	   	void HolidayMaster() throws Exception
	   	{
	   		test = extent.startTest("OnBorad CLRA-Upload Holiday Master verification");
	   		
	   		All_Distributor_Methods.HolidayMaster(test, workbook);
	   		
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
		@Test(priority = 306) 
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
	   		test = extent.startTest("OnBoard CLRA - Location - Verify to search field is working or not?");
	   		
	   		All_Distributor_Methods.CLRA_Location_SearchField(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 311) 
	   	void CLRA_AddLocation_Error() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Location - Verify to check add new error is displayed or not?");
	   		
	   		All_Distributor_Methods.CLRA_AddLocation_Error(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 312) //While uploading file with some error xml page is opening need to raise issue 
	   	void CLRA_AddLocation_Upload() throws Exception
	   	{
	   		test = extent.startTest("OnBoard CLRA - Location - Verify to check upload location button is working or not?");
	   		
	   		All_Distributor_Methods.CLRA_AddLocation_Upload(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 315) 
	   	void CLRA_AddLocation_EditUpdate() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Location - Verify to check Edit & Delete button is working or not?");
	   		
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
	   	void CLRA_EmployeeMap_bulkUpload() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Employee Mapping - Verify to download sample files in bulk upload ");
	   		
	   		All_Distributor_Methods.CLRA_EmployeeMap_bulkUpload(test, workbook);
	   		
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
		
		//CLRA: Manage Compliances 
		@Test(priority = 345)
	   	void CLRA_CompReassignment() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Manage Compliances - Compliance Reassignment verification ");
	   		 
	   		All_Distributor_Methods.CLRA_CompReassignment(test, workbook);
	   		
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
