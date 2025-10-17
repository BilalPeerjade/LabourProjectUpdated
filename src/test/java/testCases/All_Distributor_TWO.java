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


public class All_Distributor_TWO  extends BasePage
{
	
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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\AutomationLabour\\LabourProjectUpdated\\Report\\Distributor.html",true);
		test = extent.startTest("Loging In - DistributorAdmin");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		Initialization(link,0,"Statutory");
	
	}

	
	/*
	
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
	
	
	@Test(priority = 3) //Bilal
	void UserMasterVerification() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check User master functionalities is working or not?");
		MethodsD.UserMasterVerification(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	@Test(priority = 4) //Bilal
	void Corporate_Verification() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check Corporate functionalities is working or not?");
		MethodsD.Corporate_Verification(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 5) //Bilal
	void CorporateEntity_Verification() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check Corporate - Entity functionalities is working or not?");
		MethodsD.CorporateEntity_Verification(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	@Test(priority = 6) //Bilal
	void CorporateEntity_BulkUploadVerification() throws Exception
	{
		test = extent.startTest("Verify to check Corporate - Entity - Bulk Upload verification ");
		MethodsD.CorporateEntity_BulkUploadVerification(test,"Performer");
		
		extent.endTest(test);
		extent.flush();
	}
	
	
	
	@Test(priority = 7) //Bilal
	void ProceedToDashboard() throws InterruptedException, IOException
	{
		test = extent.startTest("Verify to check proceed button is working or not?");
		MethodsD.ProceedToDashboard(test,"Distributor");
		
		extent.endTest(test);
		extent.flush();
	}

	
	
	//<--- Dashboard --->
	    @Test(priority = 8)
		void ComplianceBox() throws InterruptedException, IOException
		{
			test = extent.startTest("Count by Clicking on 'Compliance'");
			MethodsD.complianceBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
	   
		@Test(priority = 9)
		void ComplianceFilter1() throws InterruptedException, IOException
		{
			test = extent.startTest("Compliance Box Filter Verification'");
			MethodsD.ComplianceFilter1(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 10)
		void UpcomingBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Upcoming'");
			MethodsD.UpcomingBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 11)
		void UpcomingFilter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Upcoming Box Filter Verification'");
		//	All_Distributor_Methods.UpcomingFilter(test,"Distributor");
			MethodsD.UpcomingFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 12)
		void OverdueBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Overdue'");
		//	All_Distributor_Methods.OverdueBox(test,"Distributor");
			MethodsD.OverdueBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 13)
		void OverdueFilter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Overdue Box Filter Verification'");
			
		//	All_Distributor_Methods.OverdueFilter(test,"Distributor");
			MethodsD.OverdueFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 14)
		void PendingActionBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Pending Action'");
		//	All_Distributor_Methods.PendingActionBox(test,"Distributor");
			MethodsD.PendingActionBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 15)
		void PendingActionFilter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Pending Action Box Filter Verification'");
		//	All_Distributor_Methods.PendingActionFilter(test,"Distributor");
			MethodsD.PendingActionFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 16)
		void PendingReviewBox() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on 'Pending Review'");
			
		//	All_Distributor_Methods.PendingReviewBox(test,"Distributor");
			MethodsD.PendingReviewBox(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 17)
		void PendingReviewFilter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Pending Review Box Filter Verification'");
			
		//	All_Distributor_Methods.PendingReviewFilter(test,"Distributor");
			MethodsD.PendingReviewFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		//bifurgated dashboard
		@Test(priority = 18)
		void RegisterUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Register - 'Upcoming'");
			
		//	All_Distributor_Methods.RegisterUpcoming(test,"Distributor");
			MethodsD.RegisterUpcoming(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 19)
		void RegisterUpcomingFilter() throws InterruptedException, IOException
		{
			test = extent.startTest(" Register - Upcoming Filter Verification'");
			
		//	All_Distributor_Methods.RegisterUpcomingFilter(test,"Distributor");
			MethodsD.RegisterUpcomingFilter(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 20)
		void RegisterOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Register - 'Overdue'");
			
		//	All_Distributor_Methods.RegisterOverdue(test,"Distributor");
			MethodsD.RegisterOverdue(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 21)
		void RegisterActionReview() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Register - 'Action/Review'");
		//	All_Distributor_Methods.RegisterActionReview(test,"Distributor");
			MethodsD.RegisterActionReview(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 22)
		void ReturnUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Returns - 'Upcoming'");
			
		//	All_Distributor_Methods.ReturnUpcoming(test,"Distributor");
			MethodsD.ReturnUpcoming(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 23)
		void ReturnOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Returns - 'Overdue'");
			
		//	All_Distributor_Methods.ReturnOverdue(test,"Distributor");
			MethodsD.ReturnOverdue(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 24)
		void ReturnActionReview() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Returns - 'Action/Review'");
			
		//	All_Distributor_Methods.ReturnActionReview(test,"Distributor");
			MethodsD.ReturnActionReview(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 25)
		void ChallanUpcoming() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Challans - 'Upcoming'");
			
		//	All_Distributor_Methods.ChallanUpcoming(test,"Distributor");
			MethodsD.ChallanUpcoming(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 26)
		void ChallanOverdue() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Challans - 'Overdue'");
			
		//	All_Distributor_Methods.ChallanOverdue(test,"Distributor");
			MethodsD.ChallanOverdue(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 27)
		void ChallanActionReview() throws InterruptedException, IOException
		{
			test = extent.startTest(" Count by Clicking on Challans - 'Action/Review'");
		//	All_Distributor_Methods.ChallanActionReview(test,"Distributor");
			MethodsD.ChallanActionReview(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		//Dashboard Performance Summary (need to add non complied as well)
		@Test(priority = 28)
		void Complied() throws InterruptedException, IOException
		{
			test = extent.startTest("Pie Chart - Performance summary - Complied - match verification");
		//	All_Distributor_Methods.Complied(test,"Distributor");
			MethodsD.Complied(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 29) //Need to add below test case for complied filter test cases 
		void RiskSummaryCompliedGraph() throws InterruptedException, IOException
		{
			test = extent.startTest("Bar Graph -Risk Summary - Complied - Count Verification");
//			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(10000);
//			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
//			LoginLocators.Search().sendKeys("TESTAUTO2");
			
			OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO2");
			
			//LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
			Thread.sleep(5000);
//			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
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
		@Test(priority = 30) //Bilal
		void CompliedHighRiskSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("High Risk Summary - Complied - Multiple Filter verification");
			MethodsD.CompliedHighRiskSummaryFilter(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 31) //Bilal
		void CompliedMediumRiskSummaryFilter() throws InterruptedException, IOException
		{
			test = extent.startTest("Medium Risk Summary - Complied - Multiple Filter verification");
			MethodsD.CompliedMediumRiskSummaryFilter(test,"Performer");
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		@Test(priority = 32) //If see some test case add above
		void ApplicableStatues() throws InterruptedException, IOException
		{
			test = extent.startTest("Verify to check Applicable Statue is displayed or not?");
		//	All_Distributor_Methods.ApplicableStatues(test,"Distributor");
			MethodsD.ApplicableStatues(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		@Test(priority = 33)
		void DailyUpdate() throws InterruptedException, IOException
		{
			test = extent.startTest("Daily Update verification");
		//	All_Distributor_Methods.DailyUpdate(test,"Distributor");
			MethodsD.DailyUpdate(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		*/
		
		//Part 2
		

		
		//Manage Masters
		@Test(priority = 34) //Bilal
	   	void StateCitySearch() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check Search State/Location Code dropdown is working or not");
	   		PerformerMethod.StateCitySearch(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 35) //Bilal
	   	void StateCityAddressMapping() throws Exception
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check address mapping button is working or not?");
	   		PerformerMethod.StateCityAddressMapping(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 36) //Bilal
	   	void StateCityAddNewPopUp() throws Exception
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check add new popup is working correctly");
	   		PerformerMethod.StateCityAddNewPopUp(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
//		@Test(priority = 37) // Hide functionality
	   	void StateCitySealANDSignatureInvalid() throws Exception
	   	{
	   		test = extent.startTest("Manage Master - State City - Verify to check error without file selection and upload more than 4 kb file in seal and signature upload ");
	   		PerformerMethod.StateCitySealANDSignatureInvalid(test, workbook, "Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	
		
		@Test(priority = 38) //Bilal
	   	void DesignationSearch() throws InterruptedException, IOException
	   	{
			test = extent.startTest("Manage Master - Designation - Verify to check Search/Select Designation dropdown is working or not");  		
	   		PerformerMethod.DesignationSearch(test, workbook , "Distributor");

	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
	    @Test(priority = 39) 
	   	void BulkUpateDesignation() throws Exception
	   	{
	   		test = extent.startTest("Manage Masters - Verify to update designation through bulk upload");
	   		PerformerMethod.BulkUpateDesignationn(test, workbook,"Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	    
	    @Test(priority = 40) //Bilal this is for update 
	   	void BulkUpateDesignationAlreadyExistForUpdate() throws Exception
	   	{
	   		test = extent.startTest("Manage Masters - Designation - Verify to check error to update designation through upload");
	   		PerformerMethod.BulkUpateDesignationAlreadyExistForUpdate(test, workbook,"Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	    
	    @Test(priority = 41) //Bilal This is for upload 
	   	void BulkUpateDesignationAlreadyExist() throws Exception
	   	{
	   		test = extent.startTest("Manage Masters - Designation - Verify to check error to upload designation which is already exists in the system");
	   		PerformerMethod.BulkUpateDesignationAlreadyExist(test, workbook,"Distributor");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		//-----------*****On board Entity:*****------------
	    //Premises: 
	    
		@Test(priority = 42) 
		void ExportPremises() throws InterruptedException, IOException
		{
			test = extent.startTest("Onboard Entity - Premises - Verify Export button is working or not?");
			Methods.ExportPremises(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 43) 
		void EditPremises() throws InterruptedException, IOException
		{
			test = extent.startTest("Onboard Entity - Premises - Verify to check Edit button is working or not?");
			Methods.EditPremises(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		//Need to add above delete button verification 
		
		@Test(priority = 44) 
		void Premises_AddressMapping() throws InterruptedException, IOException
		{
			test = extent.startTest("Onboard Entity - Premises - Verify to check Address Mapping button is working or not");
			Methods.Premises_AddressMapping(test);
			
			extent.endTest(test);
			extent.flush();
		}
	    
	    		    
		//Onboard Entity --> Paycode mapping 
		
		
		@Test(priority = 45) 
	   	void OnboardEntityPaycodeSearchDropdown() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Onboard Entity - Paycode Mapping - Verify to check search paycode/header name dropdown is working or not?");
	   		Methods.OnboardEntityPaycodeSearchDropdown(test);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		@Test(priority = 46)
		void PayCodeAddNewError() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Onboard Entity - Paycode Mapping - Verify to check add new error is displayed or not?");
			Methods.PayCodeAddNewError(test, "Distributor Paycode Add New Error");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 47)
		void PayCodeAddNewErrorSequence() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Onboard Entity - Paycode Mapping - Verify to check error to enter paycode sequence more than 200");
			Methods.PayCodeAddNewError(test, "Distributor - Paycode Sequence Error");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 48) 
		void PayCodeEdit() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Onboard Entity - Paycode Mapping - Verify to check edit button is working or not?");
			Methods.PayCodeEdit(test);
			
			extent.endTest(test);
			extent.flush();
		}
				
		@Test(priority = 49) 
		void PayCodeUploadSampleFile() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Onboard Entity - Paycode Mapping - Verify to check upload - sample files is downloading or not?");
			Methods.PayCodeUploadSampleFile(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 50) 
		void PayCodeUploadCheck() throws Exception
		{
			test = extent.startTest("Onboard Entity - Paycode Mapping - Verify to check upload - paycode is uploading or not?");
			Methods.PayCodeUploadCheck(test);
			
			extent.endTest(test);
			extent.flush();
		}
		
		
		//Onboard Entity --> User branch mapping 
		
		@Test(priority = 51)
		void Entity_UMapuser() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("Onboard Entity - User-Branch Mapping - Verify to check Map User button is working or not?");
			All_Distributor_Methods.Entity_UMapuser(test);
			  
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		//Onboard Entity --> Manage Compliance: 
		//Activataion Date Change 		
		//Assignment Removal
		
		
		//Compliance Reassignment:
		@Test(priority = 52) 
	   	void ComplainceReassignment() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Onboard Entity - Manage Compliance - Verify to check compliance reassignment is working or not?");
	   		All_Distributor_Methods.ComplainceReassignment(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		
		//Schedule Creation:
		@Test(priority = 53) //Bilal
	   	void scheduleCreationValidation() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Onboard Entity - Manage Compliance - Schedule creation - Verify validation message"); 
	   		All_Distributor_Methods.scheduleCreationValidation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		//Schedule Removal
		
		
		
		
		
		
		//OnBoard CLRA:-----
		@Test(priority = 54)
	   	void CLRASearchEmployee() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA-Search Box verification");
	   		All_Distributor_Methods.CLRASearchEmployee(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		@Test(priority = 55)
	   	void CLRAEmployerAddNew() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("Onboard CLRA - Add Employer verification");
	   		All_Distributor_Methods.CLRAEmployerAddNew(test, workbook, "Distributor Add New");
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 56)
	   	void CLRA_HolidayMaster_verification() throws Exception
	   	{
	   		test = extent.startTest("OnBorad CLRA - Verify to upload holiday master verification");
	   		All_Distributor_Methods.CLRA_HolidayMaster_verification(test, workbook);
	   			
	   		test = extent.startTest("OnBorad CLRA - Verify to upload holiday master verification");
	   		All_Distributor_Methods.CLRA_HolidayMaster_verificationValidation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 57)
	   	void bulkUpload() throws Exception
	   	{
	   		test = extent.startTest("OnBorad CLRA-Bulk Upload verification");
	   		All_Distributor_Methods.bulkUpload(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 58)
	   	void EmployeerExportBtn() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Export button verification");
	   		All_Distributor_Methods.EmployeerExportBtn(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 59)
	   	void UpdateEmployer() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Employer - Verify to check edit button is working or not?");
	   		All_Distributor_Methods.UpdateEmployer(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		@Test(priority = 60) 
	   	void DeleteEmployer() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Employer - Verify to check delete button is working or not?");
	   		All_Distributor_Methods.DeleteEmployer(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		//CLRA: Location tab
		@Test(priority = 61) 
	   	void CLRA_Location_SearchField() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Location - Verify to search field is working or not?");
	   		All_Distributor_Methods.CLRA_Location_SearchField(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
//	Need to Check 	@Test(priority = 62) 
	   	void CLRA_AddLocation_Error() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Location - Verify to check add new error is displayed or not?");
	   		All_Distributor_Methods.CLRA_AddLocation_Error(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 63) //While uploading file with some error xml page is opening need to raise issue 
	   	void CLRA_AddLocation_Upload() throws Exception
	   	{
	   		test = extent.startTest("OnBoard CLRA - Location - Verify to check upload location button is working or not?");
	   		All_Distributor_Methods.CLRA_AddLocation_Upload(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 64) 
	   	void CLRA_AddLocation_EditUpdate() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Location - Verify to check Edit & Delete button is working or not?");
	   		All_Distributor_Methods.CLRA_AddLocation_EditUpdate(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		//CLRA Contractor
		@Test(priority = 65)
	   	void CLRA_Contractor() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Contractor verification");
	   		All_Distributor_Methods.CLRA_Contractor(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		
		//CLRA - Employee Mapping 
		@Test(priority = 66) 
	   	void CLRA_EmployeeMap_Filters() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Employee Mapping - Verify to check all filters are working fine or not?");
	   		All_Distributor_Methods.CLRA_EmployeeMap_Filters(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 67) 
	   	void CLRA_EmployeeMap_Migrate() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Employee Mapping - Verify to check employee migration is working or not?");
	   		All_Distributor_Methods.CLRA_EmployeeMap_Migrate(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 327) //Bilal need to this TC only bulk upload TC 
	   	void CLRA_EmployeeMap_bulkUpload() throws Exception
	   	{
	   		test = extent.startTest("OnBoard CLRA - Employee Mapping - Verify to download sample files in bulk upload ");
	   		All_Distributor_Methods.CLRA_EmployeeMap_bulkUpload(test, workbook);
	   			   		
	   		test = extent.startTest("OnBoard CLRA - Employee Mapping - Verify to check errors while uploading files");
	   		All_Distributor_Methods.CLRA_EmployeeMap_bulkUploadInvalid(test, workbook);
	   		
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
		
		@Test(priority = 341) //Bilal
	   	void CLRA_CompAssignment_Validations() throws InterruptedException, IOException, AWTException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Compliance Assignment validation error messages verification ");
	   		All_Distributor_Methods.CLRA_CompAssignment_Validations(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		//CLRA: Manage Compliances 
		@Test(priority = 344)
	   	void manageCompliances_DrpChecking() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Manage Compliances - Verify to check in activity dropdown all expected values reflecting correctly");
	   		All_Distributor_Methods.manageCompliances_DrpChecking(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		@Test(priority = 345)
	   	void CLRA_CompReassignment() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Manage Compliances - Compliance Reassignment verification ");
	   		All_Distributor_Methods.CLRA_CompReassignment(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
		
		//
		@Test(priority = 350)
	   	void CLRA_CompManage_ActDateChange() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBorad CLRA - Manage Compliances - Activation Date change verification ");
	   		All_Distributor_Methods.CLRA_CompManage_ActDateChange(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();

	   	}
	    @Test(priority = 351)
	   	void CLRA_ManageComp_AssignmentRemoval() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Manage Compliances - Assignment Removal Verification");
	   		All_Distributor_Methods.CLRA_ManageComp_AssignmentRemoval(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	    
	    @Test(priority = 352)
	   	void CLRA_ManageComp_ScneduleCreation() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Manage Compliances - Schedule creation verification");
	   		All_Distributor_Methods.CLRA_ManageComp_ScneduleCreation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
	    
		@Test(priority = 353) 
	   	void CLRAcheduleCreationValidation() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Manage Compliance - Schedule creation - validation verification");
	   		All_Distributor_Methods.CLRAscheduleCreationValidation(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
		
		@Test(priority = 355) 
	   	void CLRA_ManageComp_ScheduleRemoval() throws InterruptedException, IOException
	   	{
	   		test = extent.startTest("OnBoard CLRA - Manage Compliance - Schedule removal - verification");
	   		All_Distributor_Methods.CLRA_ManageComp_ScheduleRemoval(test, workbook);
	   		
	   		extent.endTest(test);
	   		extent.flush();
	   	}
			
		
		@Test(priority = 400)
		void Report() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Compliance Assignment Report ");
			MethodsD.CompAssignmentReport(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 401)
		void StatusReport() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Status Report ");
			MethodsD.DistMyReportStatusReport(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 402)
		void VariousReport() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - Various Report ");
			MethodsD.VariousReport(test,"Distributor");
			
			extent.endTest(test);
			extent.flush();
		}
		
		@Test(priority = 403)
		void CLRAAssignmentReport() throws InterruptedException, IOException
		{
			test = extent.startTest("My Report - CLRA Assignment Report");
			
			MethodsD.CLRAAssignmentReport(test,"Distributor");
			
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
