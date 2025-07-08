package testCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import login.BasePage;

import performer.PerformerMethod;
import reviewer.ReviewerMethod;


public class PerformerTestCase extends BasePage
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
		extent = new com.relevantcodes.extentreports.ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\Performer Login.html",true);
		test = extent.startTest("Loging In -Performer");
		test.log(LogStatus.PASS, "Logging into system");

		extent.endTest(test);
		extent.flush();
	}
	
	@BeforeMethod
	void Login() throws InterruptedException, IOException
	{
		initialization(link,1,"Statutory");
	
	}
	
//-------------------------------Manage Master------------------------------------

	
//	@Test(priority =1)
   	void UploadSealandSignature() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("State-City Master -Upload Seal and Signature verification");
   		
   		
   		PerformerMethod.UploadSealandSignature(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
    @Test(priority = 2) //Moved in all
   	void AddDesignation() throws InterruptedException, IOException
   	{
test = extent.startTest("Manage Master - Designation - Verify Add New Designation Error is throwing or not?");
   		
   		PerformerMethod.AddDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
	
	@Test(priority = 3)// Duplicate TC
   	void DuplicateDesignation() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Duplicate Designation verification");
   		
   		PerformerMethod.DuplicateDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	@Test(priority = 4) //Moved in all
   	void DesignationExportBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Designation Master-Export Button verification");
   		
   		PerformerMethod.DesignationExportBtn(test, workbook, "Distributor");
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	
    @Test(priority =5) 
   	void BulkUploadDesignation() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("Designation Master-Bulk Upload verification");
   		
   		PerformerMethod.BulkUploadDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
    @Test(priority = 5) //BILAL 
   	void BulkUpateDesignation() throws Exception
   	{
   		test = extent.startTest("Manage Masters - Verify to update designation through bulk upload");
   		
   		PerformerMethod.BulkUpateDesignationn(test, workbook,"Performer");
   		
   		extent.endTest(test);
   		extent.flush();
   	}

@Test(priority = 6) 
	void BulkUploadDesignationDetailes() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("Designation Master-Bulk Upload designation Detailes verification");
		
		PerformerMethod.BulkUploadDesignationDetailes(test, workbook);
		
		extent.endTest(test);
		extent.flush();

	}
    @Test(priority = 7) //Moved in all
   	void DeleteDesignation() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Designation Master-Delete Designation verification");
   		
   		PerformerMethod.DeleteDesignation(test, workbook);
   		
   		extent.endTest(test);
   		extent.flush();
   	}

	@Test(priority = 8) //Moved in all
   	void DesignationClearBtn() throws InterruptedException, IOException
   	{
   		test = extent.startTest("Designation Master-Clear Button verification");
   		
   		PerformerMethod.DesignationClearBtn(test, workbook,"Performer");
   		
   		extent.endTest(test);
   		extent.flush();
   	}
	

	
	
	//========================On Board Employee==========================
	
    @Test(priority = 9) //Moved in all
   	void AddEmployee() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("Onboard Employee - Add Employee verification");
   		
   		PerformerMethod.AddEmployee(test);
   		
   		extent.endTest(test);
   		extent.flush();
   	}
    
  @Test(priority = 10)
   	void UpdateEmployee() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBoard Employee- Update Employee verification");
   		
   		
   		PerformerMethod.UpdateEmployee(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
    @Test(priority =11)
   	void UpdateStatusEmployee() throws InterruptedException, IOException
   	{
   		test = extent.startTest("OnBoard Employee- Update status employee verification");
   		
   		
   		PerformerMethod.UpdateStatusEmployee(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
   	
   
 @Test(priority =12)
   	void InvalidUANNo() throws InterruptedException, IOException, AWTException
   	{
   		test = extent.startTest("OnBoard Employee- Invalid Employee Detailes verification");
   		
   		
   		PerformerMethod.InvalidUANNo(test);
   		
   		extent.endTest(test);
   		extent.flush();

   	}
    @Test(priority = 13) //Moved in all
 	void SearchFilerEmp() throws InterruptedException, IOException
 	{
 		test = extent.startTest("OnBoard Employee- Search filter verification");
 		
 		PerformerMethod.SearchFilerEmp(test);
 		
 		extent.endTest(test);
 		extent.flush();
 	}
  
  
    @Test(priority = 14)
	void UploadEmp() throws InterruptedException, IOException, AWTException
	{
		test = extent.startTest("OnBoard Employee- Upload Employee verification");
		
		PerformerMethod.UploadEmp(test);
		
		extent.endTest(test);
		extent.flush();
	}

@Test(priority = 15)
void InvalidDateUploadEmp() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Bulk Upload-Invalid data verification");
	
	PerformerMethod.InvalidDataUploadEmp(test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority =16)
void InvalidPersonalEmpDeatiles() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee-Add Employee-Personal Detailes Invalid data verification");
	
	
	PerformerMethod.InvalidPersonalEmpDeatiles(test);
	
	extent.endTest(test);
	extent.flush();

}

@Test(priority =17)
void EmployeeReport() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Employee Report-Emp Master Report verification");
	
	
	PerformerMethod.EmployeeReport(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =18)
void EmployeeLimitedColumnReport() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Employee Report-Employee Limited Column Report verification");
	
	
	PerformerMethod.EmployeeLimitedColumnReport(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =19)
void EmployeeMonthwiseReport() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Employee Report-Employee Month wise Report verification");
	
	
	PerformerMethod.EmployeeMonthwiseReport(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =20)
void UploadEmptyFileEmp() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Bulk Upload- Empty File verification");
	
	
	PerformerMethod.UploadEmptyFileEmp(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =21)
void UploadTwoEmptyfieldEmp() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Bulk Upload- Two Empty field verification");
	
	
	PerformerMethod.UploadTwoEmptyfieldEmp(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =22)
void UploadTwofieldEmp() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Bulk Upload- Enter two field verification");
	
	
	PerformerMethod.UploadTwofieldEmp(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =23)
void UploadBtn() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Bulk Upload- Upload Button verification");
	
	
	PerformerMethod.UploadBtn(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =24)
void UploadInvalidFile() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Bulk Upload- Upload Invalid File verification");
	
	
	PerformerMethod.UploadInvalidFile(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =25)
void UploadInvalidFileFormat() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Bulk Upload- Upload Invalid File Format verification");
	
	
	PerformerMethod.UploadInvalidFileFormat(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =26)
void DownloadErrorFile() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Bulk Upload- Download error file button verification");
	
	
	PerformerMethod.DownloadErrorFile(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =27)
void selectColumn() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Bulk Upload- Select Header checkbox verification");
	
	
	PerformerMethod.selectColumn(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =28)
void ResetButton() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Bulk Upload- Reset Button verification");
	
	
	PerformerMethod.ResetButton(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =29)
void selectChexkboxUploadFile() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Bulk Upload- Select Checkbox-Fill the data for downloded header and keep any downloaded column empty verification");
	
	
	PerformerMethod.selectChexkboxUploadFile(test);
	
	extent.endTest(test);
	extent.flush();

}

@Test(priority =30)
void UploadCTC() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Employee CTC -Upload Employee CTC verification");
	
	
	PerformerMethod.UploadCTC(test);
	
	extent.endTest(test);
	extent.flush();

}

@Test(priority =31)
void InvalidDateUploadCTC() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Employee CTC-Upload Invalid data verification");
	
	
	PerformerMethod.InvalidDataUploadCTC(test);
	
	extent.endTest(test);
	extent.flush();

}

@Test(priority =32)
void DownloadCTCTemplateFile() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Employee CTC -Download CTC Template verfication");
	
	
	PerformerMethod.DownloadCTCTemplateFile(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =33)
void UploadCTCInvalidFile() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Employee CTC -Upload Invalid file verfication");
	
	
	PerformerMethod.UploadCTCInvalidFile(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =34)
void UploadCTCInvalidFileFormat() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Employee- Employee CTC -Upload Invalid file format verfication");
	
	
	PerformerMethod.UploadCTCInvalidFileFormat(test);
	
	extent.endTest(test);
	extent.flush();

}



//-------------------------Onboard Entity---------------------------------

@Test(priority = 35) //Moved in all
void OnBoardEntityExport() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Entity- Export Button verfication");
	
	PerformerMethod.OnBoardEntityExport(test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority = 36)
void UploadHolidayMaster() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Entity- Upload Holiday Master verfication");
	
	
	PerformerMethod.UploadHolidayMaster(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =37)
void InvalidDataUploadHolidayMaster() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Entity- Invalid Data Upload Holiday Master verfication");
	
	
	PerformerMethod.InvalidDataUploadHolidayMaster(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =38)
void InvalidFileUploadHolidayMaster() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Entity- Invalid File Upload Holiday Master verfication");
	
	
	PerformerMethod.InvalidFileUploadHolidayMaster(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =39)
void EmptyFileUploadHolidayMaster() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Entity- Empty File Upload Holiday Master verfication");
	
	
	PerformerMethod.EmptyFileUploadHolidayMaster(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =40)
void WithoutUploadHolidayMaster() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Entity- Upload Holiday Master - without upload file verfication");
	
	
	PerformerMethod.WithoutUploadHolidayMaster(test);
	
	extent.endTest(test);
	extent.flush();

}

@Test(priority = 41) //Moved in all
void onBoardEntityPremiseViewBtn() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Entity- triangle button -Premise details frame verfication");
	
	PerformerMethod.onBoardEntityPremiseViewBtn(test);
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority =42)
void onBoardEntityViewBtn() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Entity- view btn -Branch details   verfication");
	
	
	PerformerMethod.onBoardEntityViewBtn(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =43)
void onBoardEntityPremiseDeatilesDisabled() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Entity- view btn -Premise details fields disabled");
	
	
	PerformerMethod.onBoardEntityPremiseDeatilesDisabled(test);
	
	extent.endTest(test);
	extent.flush();

}

@Test(priority =44)
void SearchFilerPremisesEntity() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Entity- Premises Master -Search Filter  verfication");
	
	
	PerformerMethod.SearchFilerPremisesEntity(test);
	
	extent.endTest(test);
	extent.flush();

}

@Test(priority =45)
void BranchDorpdownUserBranchMapping() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("OnBoard Entity- User Branch Mapping  -Branch Dropdown and user search bar verfication");
	
	
	PerformerMethod.BranchDorpdownUserBranchMapping(test);
	
	extent.endTest(test);
	extent.flush();

}
		/*@Test(priority =46) //Map User Tab Removed
		void MapUser() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("OnBoard Entity- User Branch Mapping  -Map User verfication");
			
			
			PerformerMethod.MapUser(test);
			
			extent.endTest(test);
			extent.flush();
		
		}
		@Test(priority =47)
		void MapUserManagement() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("OnBoard Entity- User Branch Mapping  -  Management User Map verfication");
			
			
			PerformerMethod.MapUserManagement(test);
			
			extent.endTest(test);
			extent.flush();
		
		}
		@Test(priority =48)
		void deleteUserBranchaMapping() throws InterruptedException, IOException, AWTException
		{
			test = extent.startTest("OnBoard Entity- User Branch Mapping  -  Delete Button verfication");
			
			
			PerformerMethod.deleteUserBranchaMapping(test);
			
			extent.endTest(test);
			extent.flush();
		
		}*/
//====================================My Document==================================================

    @Test(priority = 49)
    void StatutoryDocApplyClaerBtn() throws InterruptedException, IOException, AWTException
    {
	    test = extent.startTest("Statutoty Document-Apply Button and clear Verification");
    
	 // PerformerMethod.StatutoryDocApplyClaerBtn(test);
	    ReviewerMethod.StatutoryDocApplyClaerBtn(test, "Performer");
	
	    extent.endTest(test);
	    extent.flush();
    }

@Test(priority =50)
void StatutoryDocFilter() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Filter Verification");
	
	
	PerformerMethod.StatutoryDocFilter(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =51)
void StateDocZipFile() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-State -Registor Compliance Type -Action Column -Zip File Verification");
	
	ReviewerMethod.StateDocZipFile(test, "Performer");
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =52)
void StateDownloadDoc() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-State -Registor Compliance type-Action Column -Download Doc Verification");
	
	
	ReviewerMethod.StateDownloadDoc(test, "Performer");
	
	extent.endTest(test);
	extent.flush();

}


@Test(priority =53)
void StatutoryDocZipFile() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Branch -Registor compliance type-Action Column -Zip File Verification");
	
	ReviewerMethod.StatutoryDocZipFile(test,"Performer");
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =54)
void StatutoryDocDownloadDoc() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Branch -Registor Compliance type-Action Column -Download Doc Verification");
	
	
	ReviewerMethod.StatutoryDocDownloadDoc(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =55)
void StatutoryDocViewandOverview() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Branch - Registor Compliance type -Action Column -Overview and view button Verification");
	
	ReviewerMethod.StatutoryDocViewandOverview(test,"Performer");
	
	extent.endTest(test);
	extent.flush();
}

@Test(priority =56)
void ChallanDocDownload() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Branch -Challan Compliance type-Action Column -Download Doc Verification");
	
	
	ReviewerMethod.ChallanDocDownload(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =57)
void ChallanDocViewandOverview() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Branch -Challan Compliance type-Action Column -Overview and view button Verification");
	
	
	ReviewerMethod.ChallanDocViewandOverview(test);
	
	extent.endTest(test);
	extent.flush();

}

@Test(priority =58)
void ChallanComplianceDocDownload() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Compliance -Challan Compliance type-Action Column -Download Doc Verification");
	
	
	ReviewerMethod.ChallanComplianceDocDownload(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =59)
void ChallanComplianceDocViewandOverview() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Statutoty Document-Compliance -Challan Compliance type-Action Column -Overview and view button Verification");
	
	
	ReviewerMethod.ChallanComplianceDocViewandOverview(test);
	
	extent.endTest(test);
	extent.flush();

}

//===========================Input Files=======================================================


@Test(priority =60)
void InputFileFilter() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-Dropdown filter verification");
	
	
	PerformerMethod.InputFileFilter(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =61)
void InputFileSubmitBtn() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-Submit Btn verification");
	
	
	PerformerMethod.InputFileSubmitBtn(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =62)
void InputFileSampleTemplate() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-Sample Template and Download Button verification");
	
	
	PerformerMethod.InputFileSampleTemplate(test);
	
	extent.endTest(test);
	extent.flush();

}
@Test(priority =63)
void InputFileAttendanceUploadSheet() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-Upload Attendance sheet verification");
	
	
	PerformerMethod.InputFileAttendanceUploadSheet(test);
	
	extent.endTest(test);
	extent.flush(); 

}
@Test(priority =64)
void InputFileAttendanceInvalidDataSheet() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-Upload - Invalid Data Attendance sheet verification");
	
	
	PerformerMethod.InputFileAttendanceInvalidDataSheet(test);
	
	extent.endTest(test);
	extent.flush(); 

}

@Test(priority =65)
void InputFileAttendanceWithoutUpload() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-Upload - Without Upload Sheet Attendance sheet verification");
	
	
	PerformerMethod.InputFileAttendanceWithoutUpload(test);
	
	extent.endTest(test);
	extent.flush(); 

}
@Test(priority =66)
void InputFileAttendanceInvalidSheet() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-Upload - Invalid Attendance sheet verification");
	
	
	PerformerMethod.InputFileAttendanceInvalidSheet(test);
	
	extent.endTest(test);
	extent.flush(); 

}
@Test(priority =67)
void InputFileDisableDownload() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-To check whether download and Browse button is disabled or not when files not send by the client to performer from input web upload tab of input files menu.");
	
	
	PerformerMethod.InputFileDisableDownload(test);
	
	extent.endTest(test);
	extent.flush(); 

}

@Test(priority =68)
void InputFileSalaryeUploadSheet() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-Upload Valid data Salary sheet verification");
	
	
	PerformerMethod.InputFileSalaryeUploadSheet(test);
	
	extent.endTest(test);
	extent.flush(); 

}
@Test(priority =69)
void InputFileUploadInvalidFile() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-Upload Invalid data Salary sheet verification");
	
	
	PerformerMethod.ErrorFileDownload(test);
	
	extent.endTest(test);
	extent.flush(); 

}

@Test(priority =70)
void InputFileSalaryWithoutUpload() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-Upload - Without Upload  Salary sheet verification");
	
	
	PerformerMethod.InputFileSalaryWithoutUpload(test);
	
	extent.endTest(test);
	extent.flush(); 

}

@Test(priority =71)
void InputFileSalaryInvalidSheet() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-Upload -Invalid Salary sheet verification");
	
	
	PerformerMethod.InputFileSalaryInvalidSheet(test);
	
	extent.endTest(test);
	extent.flush(); 

}
//@Test(priority =60) //Not Run
void InputFileGreenTickMark() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-To check whether green tickmark appearing or not for valid template file upload from input web upload tab of input files menu of performr profile.");
	
	
	PerformerMethod.GreenColour(test);
	
	extent.endTest(test);
	extent.flush(); 

}

//@Test(priority =61)//Not Run
void InputFileRedCrossMark() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-To check whether red crossmark appearing or not for invalid template file upload from input web upload tab of input files menu of performr profile.");
	
	
	PerformerMethod.RedColour(test);
	
	extent.endTest(test);
	extent.flush(); 

}

//@Test(priority =62)//Not Run
void InputFileGreenTickMark1() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-To check whether green tickmarks appearing or not in uploaded, validated and processed columns for valid file upload from of input web upload tab of input files menu from performer login.");
	
	
	PerformerMethod.GreenColourUploaded(test);
	
	extent.endTest(test);
	extent.flush(); 

}
@Test(priority =72)
void History() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-History Icon  Verification");
	
	
	PerformerMethod.History(test);
	
	extent.endTest(test);
	extent.flush(); 

}

@Test(priority =73)
void AnchorDashboardSummary() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-Anchor Dashboard Summary  Verification");
	
	
	PerformerMethod.AnchorDashboardSummary(test);
	
	extent.endTest(test);
	extent.flush(); 

}

@Test(priority =74)
void InputFileSalaryUploadSheet() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-Challan Compliance Type - Upload Salary sheet verification");
	
	
	PerformerMethod.InputFileChallanSalaryUploadSheet(test);
	
	extent.endTest(test);
	extent.flush(); 

}
@Test(priority =75)
void InputFileReturnSalaryUploadSheet() throws InterruptedException, IOException, AWTException
{
	test = extent.startTest("Input File-Return Compliance Type - Upload Salary sheet verification");
	
	
	PerformerMethod.InputFileReturnSalaryUploadSheet(test);
	
	extent.endTest(test);
	extent.flush(); 

}
@AfterMethod

void Close()
{
	 getDriver().close(); 
}
}
