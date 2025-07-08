package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
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

import distributor.DistributerMethods;

import login.BasePage;

public class DistributorTestCase  extends BasePage {
	
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
	
	
	public static String link = "mgmt1";  
	

	
	@BeforeTest
	void setBrowser() throws InterruptedException, IOException
	{
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\Distributor Login.html",true);
		test = extent.startTest("Loging In - Distributor");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,0,"Statutory");
	
	}
	
//------------------Manage Masters-------------------	
	
	@Test(priority = 1) //Pass this TC due to Master changed message
   	void StateAdd() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Add State-City Master verification");
   		
   		DistributerMethods.StateAdd(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();
   	} 
	
	
	@Test(priority = 2)
   	void StateAddInvalidLocationCode() throws InterruptedException, IOException
   	{
   		test = extent.startTest("State-City Master -Invalid Location Code verification");
   		
   		DistributerMethods.StateAddInvalidLocationCode(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
	
	@Test(priority =3)
   	void StateAddExistingCity() throws InterruptedException, IOException
   	{
   		test = extent.startTest("State-City Master -Existing City verification");
   		
   		
   		DistributerMethods.StateAddExistingCity(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =4)
   	void StateExportBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("State-City Master -Export Button verification");
   		
   		
   		DistributerMethods.StateExportBtn(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
//	@Test(priority =5) Hide it due to master
   	void UploadSealandSignature() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("State-City Master -Upload Seal and Signature verification");
   		
   		
   		DistributerMethods.UploadSealandSignature(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
     @Test(priority =6)
   	void AddDesignation() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Add Designation master verification");
   		
   		
   		DistributerMethods.AddDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
     
	@Test(priority = 7)
   	void DuplicateDesignation() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Duplicate Designation verification");
   		
   		
   		DistributerMethods.DuplicateDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 8)
   	void DesignationExportBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Designation Master-Export Button verification");
   		
   		
   		DistributerMethods.DesignationExportBtn(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority = 9) 
   	void BulkUploadDesignation() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("Designation Master-Bulk Upload verification");
   		
   		
   		DistributerMethods.BulkUploadDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
    @Test(priority = 10) 
	void BulkUploadDesignationDetailes() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Designation Master-Bulk Upload designation Detailes verification");
		
		
		DistributerMethods.BulkUploadDesignationDetailes(test, workbook);
		
		extent.endTest(test);
		extent.flush();

	}
@Test(priority =11)
   	void DeleteDesignation() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Designation Master-Delete Designation verification");
   		
   		
   		DistributerMethods.DeleteDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
		@Test(priority =12)
   	void DesignationClearBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Designation Master-Clear Button verification");
   		
   		
   		DistributerMethods.DesignationClearBtn(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	} 
		
	
		
	//------------------------ OnBoard Entity--------------------------------//
   //	--------------------Compliance Assignment-----------------------------
	@Test(priority =13)
   	void ComplianceAssignment() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad Entity-Compliance assignment -Register Compliance Type");
   		
   		
   		DistributerMethods.ComplianceAssignmentRegister(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =14)
   	void ComplianceAssignmentReturn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad Entity-Compliance assignment -Return Compliance Type");
   		
   		
   		DistributerMethods.ComplianceAssignmentReturn(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =15)
   	void ComplianceAssignmentChallan() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad Entity-Compliance assignment -Challan Compliance Type");
   		
   		
   		DistributerMethods.ComplianceAssignmentChallan(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =16)
   	void SearchBox() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad Entity-Compliance assignment -Search Box");
   		
   		
   		DistributerMethods.SearchBox(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =17)
   	void ValidationMesssage() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad Entity-Compliance assignment -Without selecting Branch & Date");
   		
   		
   		DistributerMethods.ValidationMesssage(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =18)
   	void WithoutselectingPerformerReviewer() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad Entity-Compliance assignment -Without selecting Performer & Reviewer");
   		
   		
   		DistributerMethods.WithoutselectingPerformerReviewer(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
   	@Test(priority =19)
   	void Complianceactivationcancelbtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad Entity-Compliance assignment -Activation Popup -Cancel Button");
   		
   		
   		DistributerMethods.Complianceactivationcancelbtn(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
   	
   //------------------------------Manage Complaiance------------------------


   	
	@Test(priority =20)
   	void ManageCompliance() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad Entity-Manage Compliance");
   		
   		
   		DistributerMethods.ManageCompliance(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	//@Test(priority =21)
   	void ComplainceReassignment() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad Entity-Manage Compliance-Compliance Reassignment");
   		 
   		
   		DistributerMethods.ComplainceReassignment(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =22)
   	void ManageComplianceFilter() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad Entity-Manage Compliance-Filter Verification");
   		
   		
   		DistributerMethods.ManageComplianceFilter(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =23)
   	void ActivationDateChange() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad Entity-Manage Compliance-Activation Date change");
   		
   		
   		DistributerMethods.ActivationDateChange(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority =24)
   	void AssignmentRemoval() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad Entity-Manage Compliance-Assignment Removal");
   		
   		
   		DistributerMethods.AssignmentRemoval(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =25)
   	void ScheduleCreation() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad Entity-Manage Compliance-Schedule Creation");
   		
   		
   		DistributerMethods.ScheduleCreation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =26)
   	void WithoutSelctingFieldScheduleCreation() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad Entity-Manage Compliance-Schedule Creation-Without Selecting Filter");
   		
   		
   		DistributerMethods.WithoutSelctingFieldScheduleCreation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =27)
   	void ScheduleRemoval() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad Entity-Manage Compliance-Schedule Removal");
   		
   		
   		DistributerMethods.ScheduleRemoval(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	//--------------------------------OnBoard CLRA---------------------------//
	
	@Test(priority =28)
   	void AddEmployer() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad CLRA-Add Employer verification");
   		
   		
   		DistributerMethods.AddEmployer(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =29)
   	void UpdateEmployer() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad CLRA-Update Employer verification");
   		
   		
   		DistributerMethods.UpdateEmployer(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =30) 
   	void DeleteEmployer() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad CLRA-Delete Employer verification");
   		
   		
   		DistributerMethods.DeleteEmployer(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =31)
   	void HolidayMaster() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Upload Holiday Master verification");
   		
   		
   		DistributerMethods.HolidayMaster(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =32)
   	void bulkUpload() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Bulk Upload verification");
   		
   		
   		DistributerMethods.bulkUpload(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =33)
   	void EmployeerExportBtn() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Export Btn verification");
   		
   		
   		DistributerMethods.EmployeerExportBtn(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =34)
   	void SearchBoxEmp() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Search Box verification");
   		
   		
   		DistributerMethods.SearchBoxEmp(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	
	@Test(priority =35)
   	void AddLocation() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Add Location verification");
   		
   		
   		DistributerMethods.AddLocation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =36)
   	void editLOcation() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Update Location verification");
   		
   		
   		DistributerMethods.editLOcation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =37)
   	void UploadLocation() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Upload Location verification");
   		
   		
   		DistributerMethods.UploadLocation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =38)
   	void LocationExportBtn() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Location-Export Btn verification");
   		
   		
   		DistributerMethods.LocationExportBtn(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	@Test(priority =39) //if data is not reflecting run P35 
   	void DeleteLocation() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Location-Delete Btn verification");
   		
   		
   		DistributerMethods.DeleteLocation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	@Test(priority =40)
   	void SearchBoxLocation() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Search Box location verification");
   		
   		
   		DistributerMethods.SearchBoxLocation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =41)
   	void Contractor() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Contractor verification");
   		
   		
   		DistributerMethods.Contractor(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority = 42)
   	void EmpMapping() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Employee mapping verification");
   		
   		
   		DistributerMethods.EmpMapping(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	@Test(priority =43)
   	void UpdateEmpMapping() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Update Employee mapping verification");
   		
   		
   		DistributerMethods.UpdateEmpMapping(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	

	@Test(priority =44)
   	void ExportEmpMapping() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Update Export Btn Employee mapping verification");
   		
   		
   		DistributerMethods.ExportEmpMapping(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	//@Test(priority =45)
   	void deleteEmpMapping() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Delete Employee mapping verification");
   		
   		
   		DistributerMethods.deleteEmpMapping(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =46)
   	void ComplianceAssignmentRegisterCLRA() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Registor-Compliance Assignment verification");
   		
   		
   		DistributerMethods.ComplianceAssignmentRegisterCLRA(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =47)
   	void ComplianceAssignmentRetrunCLRA() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBorad CLRA-Return-Compliance Assignment verification");
   		
   		
   		DistributerMethods.ComplianceAssignmentRetrunCLRA(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	@Test(priority = 48)
   	void SearchBoxComplianceAssignment() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad CLRA-Compliance assignment -Search Box");
   		
   		
   		DistributerMethods.SearchBoxComplianceAssignment(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
   	
	@Test(priority =49)
   	void ManageComplianceCLRA() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad CLRA-Manage Compliance");
   		
   		
   		DistributerMethods.ManageComplianceCLRA(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	//@Test(priority =47)//Peninding
   	void ComplainceReassignmentCLRA() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad CLRA-Manage Compliance-Compliance Reassignment");
   		 
   		
   		DistributerMethods.ComplainceReassignmentCLRA(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	//@Test(priority =48)//Peninding
   	void ManageComplianceFilterCLRA() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad CLRA-Manage Compliance-Filter Verification");
   		
   		
   		DistributerMethods.ManageComplianceFilterCLRA(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =50)
   	void ActivationDateChangeCLRA() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad CLRA-Manage Compliance-Activation Date change");
   		
   		
   		DistributerMethods.ActivationDateChangeCLRA(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
@Test(priority =51)
   	void AssignmentRemovalCLRA() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad CLRA-Manage Compliance-Assignment Removal");
   		
   		
   		DistributerMethods.AssignmentRemovalCLRA(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =52)
   	void ScheduleCreationCLRA() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad CLRA-Manage Compliance-Schedule Creation");
   		
   		
   		DistributerMethods.ScheduleCreationCLRA(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =53)
   	void WithoutSelctingFieldScheduleCreationCLRA() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad CLRA-Manage Compliance-Schedule Creation-Without Selecting Filter");
   		
   		
   		DistributerMethods.WithoutSelctingFieldScheduleCreationCLRA(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	@Test(priority =54)
   	void ScheduleRemovalCLRA() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBorad CLRA-Manage Compliance-Schedule Removal");
   		
   		
   		DistributerMethods.ScheduleRemovalCLRA(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
   	
		
	@AfterMethod
	void close()
	{
	  getDriver().close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@AfterMethod
//  	void browserClosing() throws InterruptedException
//  	{
//		closeBrowser();
////  		Thread.sleep(1000);
////  		getDriver().close();
//  	}	       
  		       		
  	 

}
