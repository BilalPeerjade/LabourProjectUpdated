package performer;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import login.BasePage;

public class PerformerLocator extends BasePage
{
private static WebElement labour = null;			//WebElement variable created for Username input 

	
	public static WebElement SerchCustomer()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@class='f-textbox']"));
		return labour;
	}
	public static WebElement clickDashboard()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Dashboard']"));
		return labour;
	}
	public static WebElement clickWorkspaceArrow()
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Workspace'])[1]"));
		return labour;
	}
	public static WebElement DistributorPremisesArrow()	
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Premise Master'])[1]"));
		return labour;
	}
	public static WebElement ReviewerStaturyDocumentArrow()	
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Statutory Document'])[1]"));
		return labour;
	}

	public static WebElement clickOnboardEmployee()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Onboard Employee']"));
		///html/body/app-root/div/app-layout/div/ul/li[4]/a/span
		return labour;
	}
	
	public static WebElement clickAddNewEmployee()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Add New']"));
		return labour;
	}
	public static WebElement clickUpdateNewEmployee()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Edit']"));
		return labour;
	}
	public static WebElement enterEmplName()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@formcontrolname='employeeName']"));
		return labour;
	}
	public static WebElement enterFatherName()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@formcontrolname='fatherHusbandName']"));
		return labour;
	}
	public static WebElement clickGender()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'][normalize-space()='Select'])[1]"));
		return labour;
	}
	public static WebElement selectGender()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Male')]"));
		return labour;
	}
	public static WebElement clickRelationship()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//span[@class='k-input-inner'])[2]"));
		return labour;
	}
	public static WebElement selectRelationship()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Father')]"));
		return labour;
	}
	public static WebElement clickDoB()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@placeholder='DD-MM-YYYY']"));	//input[@id='datepicker-1'
		return labour;
	}
	
	public static WebElement clickAddress()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//textarea[@class='form-control f-textbox ng-pristine ng-valid ng-touched']"));	
		return labour;
	}
	public static WebElement clickCalendarDOB()
	{
		labour = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon'])[1]"));
		return labour;
	}
	public static WebElement clickMaterialStatus()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[3]"));
		return labour;
	}
	public static WebElement selectMaterialStatus()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Married')]"));
		return labour;
	}
	public static WebElement clickEmail()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname='email']"));
		return labour;
	}
	public static WebElement clickMobile()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname='mobileNo']"));
		return labour;
	}
	public static WebElement clickNatinality()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[6]"));
		return labour;
	}
	public static WebElement selectNatinality()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'India')]"));
		return labour;
	}
	public static WebElement clickPan()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname='pan']"));
		return labour;
	}
	public static WebElement clickAdhar()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname='aadhar']"));
		return labour;
	}
	public static WebElement clickphysicalychanged()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[5]"));
		return labour;
	}
	public static WebElement selectphysicalychanged()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Yes')]"));
		return labour;
	}
	
	
	public static WebElement clickPerAddress()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='form-control f-textbox ng-pristine ng-valid ng-touched']"));
		return labour;
	}
	public static WebElement clickPassportNo()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname='passportNo']"));
		return labour;
	}
	public static WebElement clickpassportIssued()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[8]"));
		return labour;
	}
	
	public static WebElement clickPVF()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon'])[1]"));
		return labour;
	}

	public static WebElement selectmonth()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@id='kendo-calendarid-1-header']"));
		//span[normalize-space()='January 2025']
		return labour;
	}
	public static WebElement selectYear()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='2000']"));
		return labour;
	}
	public static WebElement selectYear1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='2024']"));
		return labour;
	}
	public static WebElement selectmonth1()		//Method for searching Username input
	{

		labour = getDriver().findElement(By.xpath("//span[@class='k-link'][normalize-space()='Feb']"));
		return labour;
	}
	public static WebElement selectDate()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[@class='k-link'][normalize-space()='2']"));
		return labour;
	}
	public static WebElement selectDate1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//td[@role='gridcell']//span[@class='k-link'][normalize-space()='2']"));
		return labour;
	}
	public static WebElement clickPVT()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@id='datepicker-6']"));
		return labour;
	}
	public static WebElement clickIndentificationRemark()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='form-control f-textbox ng-pristine ng-valid ng-touched'])[2]"));
		return labour;
	}
	public static WebElement clickECA()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='form-control f-textbox ng-pristine ng-valid ng-touched'])[3]"));
		return labour;
	}
	public static WebElement clickECN()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname='emergencyContactNum']"));
		return labour;
	}
	public static WebElement clickNext()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Next']"));
		return labour;
	}
	public static WebElement clickEmpId()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname='employeeID']"));
		return labour;
	}
	public static WebElement clickEmpType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[1]"));
		return labour;
	}
	public static WebElement selectEmpType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Contract')]"));
		return labour;
	}
	public static WebElement clickBranch()
	{
		labour = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[2]"));
		return labour;
	}
	public static WebElement selectBranch()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//span[@class='k-list-item-text'])[1]"));
		return labour;
	}
	public static WebElement clickPTState()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[2]"));
		return labour;
	}
	public static WebElement selectPTState()	
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Karnataka']"));
		return labour;
	}
	public static WebElement clickskillCategory()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[3]"));
		return labour;
	}
	public static WebElement selectskillCategory()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Highly Skilled')]"));
		return labour;
	}
	public static WebElement clickJoiningDate()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@id='datepicker-14']"));
		return labour;
	}
	public static WebElement clickInternatitonalWorker()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[4]"));
		return labour;
	}
	public static WebElement clickStatus()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[5]"));
		return labour;
	}
	public static WebElement selectstatus()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Active')]"));
		return labour;
	}
	public static WebElement updatestatus()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return labour;
	}
	public static WebElement clickPFCappingApplicability()
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[8]"));
		return labour;
	}
	public static WebElement selectPFCappingApplicability()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//span[contains(text(),'Yes')])[2]"));
		return labour;
	}
	public static WebElement clickEmployment()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[14]"));
		return labour;
	}
	public static WebElement selectEmployment()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'First Time')]"));
		return labour;
	}
	public static WebElement clickPayrollMonth()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[16]"));
		return labour;
	}
	public static WebElement selectMonth()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'January')]"));
		return labour;
	}
	public static WebElement clickPayrollYear()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[18]"));
		return labour;
	}
	public static WebElement selectPayrollYear()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'2022')]"));
		return labour;
	}
	public static WebElement clicksecurityprovided()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[4]"));
		return labour;
	}
	public static WebElement clickEmpType1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[7]"));
		return labour;
	}
	public static WebElement selectEmpType1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Core']"));
		return labour;
	}
	public static WebElement EmptsuccessMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Employee Added Successfully']"));
		return labour;
	}
	public static WebElement EmptUpdatesuccessMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Employee Updated Successfully']"));
		return labour;
	}
	public static WebElement clickdashboard()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='My Dashboard']"));
		return labour;
	}
	public static WebElement clickOkBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='OK']"));
		return labour;
	}
	public static WebElement clicksave()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Save']"));
		return labour;
	}
	public static WebElement clickBrowse()	
	{
		WebElement UploadDocument = getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']"));
  	     UploadDocument.sendKeys("C:\\Users\\snehalp\\Documents\\EmployeeMaster.xlsx");
		return labour;
	}
	
	public static WebElement browse()	
	{
		getDriver().findElement(By.xpath("(//label[normalize-space()='Browse'])[1]")); 
		return labour;
	}
	public static WebElement clickUploadEmp()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Bulk Upload']"));
		return labour;
	}
	public static WebElement clickUploadbtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Upload']"));
		return labour;
	}
	public static WebElement clickUploadbtnCTCBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Upload']"));
		return labour;
	}
	public static WebElement clickdownloadbtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Sample Template']"));
		return labour;
	}
	public static WebElement successmsgUploadEmp()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='File uploaded Successfully!']"));
		return labour;
	}
	public static WebElement invalidFileMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("	//h4[normalize-space()='Invalid Template']"));
		return labour;
	}
	public static WebElement invalidFileFormatMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("	//h4[normalize-space()='Please upload XLSX file only']"));
		return labour;
	}
	public static WebElement UploadBtnMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Please select a file to upload.']"));
		return labour;
	}
	public static WebElement UploadEmptyFileMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("	//h4[normalize-space()='Empty Sheet']"));
		return labour;
	}
	public static WebElement successmsgUploadCTC()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='File uploaded successfully']"));
		return labour;
	}
	public static WebElement searchEmpName()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@role='combobox']"));
		return labour;
	}
	public static WebElement clickStatusEmp()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])[2]"));
		return labour;
	}
	public static WebElement clickEmpName()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])"));
		return labour;
	}
	public static WebElement clickApplyBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Apply Filter']"));
		return labour;
	}
	public static WebElement readTotalItems()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-pager-info k-label']"));
		return labour;
	}
	public static WebElement selectDropdown()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-item-text']"));
		return labour;
	}
	public static WebElement clickClosedBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-svg-i-x k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement clickUAN()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname='UAN']"));
		return labour;
	}
	public static WebElement clickInvalidUANmsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='text-danger ng-star-inserted'])[4]"));
		return labour;
	}
	public static WebElement clickInvalidEmpId()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='text-danger ng-star-inserted']"));
		//div[contains(text(),'Contains only alphanumeric characters and hyphens')]
		return labour;
	}
	public static WebElement closeBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-svg-i-x k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement UploadInvalidMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath(" //h4[normalize-space()='Invalid CSV']"));
		return labour;
	}
	public static WebElement InvalidEmpName()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='text-danger ng-star-inserted'])[1]"));
		
		return labour;
	}
	public static WebElement InvalidFatherName()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='text-danger ng-star-inserted'])[2]"));
		
		return labour;
	}
	public static WebElement InvalidEmail()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='text-danger ng-star-inserted'])[3]"));
		
		return labour;
	}
	public static WebElement InvalidMobileNo()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='text-danger ng-star-inserted'])[4]"));
		
		return labour;
	}
	public static WebElement InvalidPAN()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='text-danger ng-star-inserted'])[5]"));
		
		return labour;
	}
	public static WebElement InvalidAddhar()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='text-danger ng-star-inserted'])[6]"));
		
		return labour;
	}
	public static WebElement InvalidPassport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='text-danger ng-star-inserted'])[7]"));
		
		return labour;
	}
	public static WebElement InvalidEmergencyNo()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='text-danger ng-star-inserted'])[8]"));
		
		return labour;
	}
	public static WebElement EmpCTC()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Employee CTC']"));
		
		return labour;
	}
	public static WebElement DownloadTemplate()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExcelDownload.svg']"));
		
		return labour;
	}
	public static WebElement EmpReport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Employee Report']"));
		
		return labour;
	}
	public static WebElement clickSelectReport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-input-button k-button k-icon-button k-button-md k-button-solid k-button-solid-base']"));
		
		return labour;
	}
	public static WebElement clickEmpMasterReport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-list-item-text'])[2]"));
		
		return labour;
	}
	public static WebElement clickEmployeeLimitedColumnReport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-list-item-text'])[3]"));
		
		return labour;
	}
	public static WebElement clickEmployeeMonthwiseReport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-list-item-text'])[4]"));
		
		return labour;
	}
	public static WebElement clickExport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[@class='exportbtn']"));
		
		return labour;
	}
	public static WebElement selectBranches()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[@class='k-input-inner k-readonly']"));
		
		return labour;
	}
	
	public static WebElement clicktringle()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted']"));
		
		return labour;
	}
	public static WebElement clickLocation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@value='undefined'])[3]"));
		//span[contains(text(),'Nashik_Branch Nashik')]
		return labour;
	}
	public static WebElement clickclickMonth()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-button k-button k-icon-button k-button-md k-button-solid k-button-solid-base'])[2]"));
		
		return labour;
	}
	public static WebElement clickSelectMonth()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'January')]"));
		
		return labour;
	}
	public static WebElement clickclickYear()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-button k-button k-icon-button k-button-md k-button-solid k-button-solid-base'])[3]"));
		
		return labour;
	}
	public static WebElement clickSelectYear()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'2024')]"));
		
		return labour;
	}
	public static WebElement clickJod()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Joining Date cannot be smaller than Date of Birth']"));
		
		return labour;
	}
	public static WebElement clickValidationMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Error File']"));
		
		return labour;
	}
	public static WebElement clickRefresh()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Refresh']"));
		
		return labour;
	}
	public static WebElement clickCheckbox()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//div[@class='custom-tooltip ng-star-inserted']//input[@type='checkbox']"));
		
		return labour;
	}
	public static WebElement clickReset()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Reset']"));
		
		return labour;
	}
	public static WebElement clickcheckbox()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[4]"));
		
		return labour;
	}
	public static WebElement clickcheckbox1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[5]"));
		
		return labour;
	}
	public static WebElement clickcheckbox2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[6]"));
		
		return labour;
	}
	public static WebElement clickcheckbox3()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[7]"));
		
		return labour;
	}
	public static WebElement gridLoad()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-employee-report/div[2]/kendo-loader/div/span"));
		
		return labour;
	}
	public static WebElement gridLoad1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-my-compliance-document/div[3]/kendo-loader/div/span"));
		
		return labour;
	}
	public static WebElement InvalidIFSC()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//div[contains(text(),'IFSC must be exactly 11 alphanumeric')]"));
		
		return labour;
	}
	public static WebElement gridLoad2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-employee-ctc/div[2]/kendo-loader/div/span[1]"));
		
		return labour;
	}
	public static WebElement InvalidPFNumber()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//div[contains(text(),'IT must be exactly 22 alphanumeric')]"));
		
		return labour;
	}
	public static WebElement InvalidBankAcNo()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//div[contains(text(),'Bank A/C No must be between 11 and 16 digits')]"));
		
		return labour;
	}
	public static WebElement InvalidESICNo()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//div[contains(text(),'ESIC Number must be exactly 10 digits')]"));
		
		return labour;
	}
	public static WebElement clickIFSC()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname='IFSC']"));
		
		return labour;
	}
	public static WebElement clickBankAcNo()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname=\"BankAC\"]"));
		
		return labour;
	}
	public static WebElement clickESICNo()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname=\"ESICNumber\"]"));
		
		return labour;
	}
	public static WebElement clickPFNumber()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname=\"PFNumber\"]"));
		
		return labour;
	}
	public static WebElement clickExportOnboardEntity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
		
		return labour;
	}
	public static WebElement clickOnboardEntity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Onboard Entity']"));
		
		return labour;
	}
	public static WebElement clickOnboardEntityViewBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@xmlns='http://www.w3.org/2000/svg'])[9]"));
		
		return labour;
	}
	public static WebElement clickeditBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Edit'])"));
		
		return labour;
	}
	public static WebElement clickOnboardEntityViewBtn1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@xmlns='http://www.w3.org/2000/svg'])[11]"));
		
		return labour;
	}
	public static WebElement clickSearchFiletr()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@placeholder='Type to Search']"));
		
		return labour;
	}
	public static WebElement UserBranchMapping()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='User-Branch Mapping']"));
		
		return labour;
	}
	public static WebElement clickAct()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon']"));
		
		return labour;
	}
	public static WebElement selectAct()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Shops and Establishment Allied')]"));
		
		return labour;
	}
	public static WebElement clickBranchPOnboardEntity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-input-inner k-readonly']"));
		
		return labour;
	}
	public static WebElement selectBranchPOnboardEntity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@type='checkbox']"));
		
		return labour;
	}
	public static WebElement clickUser()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class=\"k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon\"])[2]"));

		return labour;
	}
	public static WebElement selectUser()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-item-text ng-star-inserted']"));
		
		return labour;
	}
	public static WebElement clickApply()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ApplyFilter.svg']"));
		
		return labour;
	}
	public static WebElement clickClearBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ClearFilter.svg']"));
		
		return labour;
	}
	public static WebElement clickUploadHolidayMaster()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Upload Holiday Master']"));
		
		return labour;
	}
	public static WebElement successUploadHoliday()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='File uploaded successfully']"));
		return labour;
	}
	public static WebElement clickMapUser()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Map User']"));
		return labour;
	}
	public static WebElement clickSave()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Save']"));
		return labour;
	}
	public static WebElement successMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='User Branch mapped successfully...']"));
		return labour;
	}
	public static WebElement clickAct1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement clickBranchPOnboardEntity1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-inner k-readonly'])[2]"));
		
		return labour;
	}
	public static WebElement clickUser1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@role=\"combobox\"])[7]"));
		
		return labour;
	}
	public static WebElement clickUserTringle()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[2]"));
		
		return labour;
	}
	public static WebElement selectUserDropdown()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li"));
		
		return labour;
	}
	
	public static WebElement InvalidmsgHolidayMaster()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Invalid Template.']"));
		
		return labour;
	}
	public static WebElement withoutUploadfilemsgHolidayMaster()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='You have not chosen any file.']"));
		
		return labour;
	}
	public static WebElement clickmgmtradiobtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@id='rdIndustry']"));
		
		return labour;
	}
	public static WebElement clickDeleteBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Delete'])[1]"));
		
		return labour;
	}
	public static WebElement deleteMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Are you certain you want to delete this Mapping??']"));
		
		return labour;
	}
	public static WebElement deleteMsg1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Record deleted succesfully']"));
		
		return labour;
	}
	public static WebElement clickClose()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@icon='close']"));
		
		return labour;
	}
	public static WebElement clickEntity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])"));
		
		return labour;
	}
	public static WebElement clickStatutoryDoc()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Statutory Documents']"));
		
		return labour;
	}
	public static WebElement clickComplianceType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'][normalize-space()='Compliance'])[1]"));
		
		return labour;
	}
	public static WebElement selectComplianceType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li"));
		return labour;
	}
	public static WebElement selectComplianceType1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[2]"));
		return labour;
	}
	public static WebElement selectComplianceChallan()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Challan']"));
		return labour;
	}
	public static WebElement selectComplianceRegister()		
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Register']"));
		return labour;
	}
	public static WebElement selectComplianceReturns()		
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Returns']"));
		return labour;
	}
	
	public static WebElement selectComplianceType5()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[4]"));
		return labour;
	}
	public static WebElement selectComplianceType4()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[3]"));
		return labour;
	}
	public static WebElement Dropdown()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']"));
		return labour;
	}
	public static WebElement selectComplianceType6()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[9]"));
		return labour;
	}
	public static WebElement selectComplianceType2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[12]"));
		return labour;
	}
	public static WebElement selectComplianceType3()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[11]"));
		return labour;
	}
	public static WebElement clickAct2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Act')]"));
		return labour;
	}
	public static WebElement clickYear()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Year')]"));
		return labour;
	}

	
	public static WebElement clickPeriod()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Period')]"));
		return labour;
	}
	public static WebElement clickComplianceStatus()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Compliance Status')]"));
		return labour;
	}
	public static WebElement clickBranch1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select Branch')]"));
		return labour;
	}
	public static WebElement clickBranchTiangle()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement selectBranch1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@role='group'])[2]/li"));
		return labour;
	}
	public static WebElement selectBranch2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@role='group'])[2]"));
		return labour;
	}
	public static WebElement clickTriangleGrid()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-svg-i-caret-alt-right k-treelist-toggle k-svg-icon k-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement clickDownload()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Download']"));
		return labour;
	}
	public static WebElement clickDownload1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Download'])[2]"));
		return labour;
	}
	public static WebElement clickDownload2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@alt='View Document']"));
		return labour;
	}
	public static WebElement clickCloseBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Close']"));
		return labour;
	}
	public static WebElement clickCloseBtn1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//button[@title='Close'])[2]"));
		return labour;
	}
	public static WebElement clickview()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("	//img[@title='View']"));
		return labour;
	}
	public static WebElement clickview1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='svg-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement clickOverview()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Overview']"));
		return labour;
	}
	public static WebElement viewPopup()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-window-title k-dialog-title'])[2]"));
		return labour;
	}
	public static WebElement OverviewPopup()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-window-title k-dialog-title']"));
		return labour;
	}
	public static WebElement clickBranchRadioBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@id='Branch']"));
		return labour;
	}
	public static WebElement clickComplianceRadioBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@id='Compliance']"));
		return labour;
	}
	public static WebElement clickComplianceType1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-input-value-text']"));
		
		return labour;
	}
	public static WebElement clickPeriod1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[2]"));
		return labour;
	}
	public static WebElement clickYear1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[3]"));
		return labour;
	}
	public static WebElement clickSubmit()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Submit']"));
		return labour;
	}
	public static WebElement clickSampleTemplate()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Sample Template'])[1]"));
		return labour;
	}
	public static WebElement clickDownloadBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/button[1]"));
		return labour;
	}
	public static WebElement clickDownloadBtnDisable()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//button[contains(text(),'Download')])"));
		return labour;
	}
	public static WebElement clickBrowseBtnDisable()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='figma-btn-gray download-btn'])"));
		return labour;
	}
	public static WebElement clickerrorFile()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Error occurred.Error file downloaded']"));
		return labour;
	}
	public static WebElement downloaderrorFile()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/DownloadOrange.svg']"));
		return labour;
	}
	public static WebElement UploadBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//button[normalize-space()='Upload'])[2]"));
		return labour;
	}
	public static WebElement withoutUploadSheet()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='No file chosen']"));
		return labour;
	}
	public static WebElement invalidSheet()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Invalid template']"));
		return labour;
	}
	public static WebElement HistoryIcon()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/History.svg']"));
		return labour;
	}
	public static WebElement InputHistory()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[@class='k-window-title k-dialog-title']"));
		return labour;
	}
	public static WebElement clickDownloadHistoryIcon()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='download']"));
		return labour;
	}
	public static WebElement AnchorDashboardSummary()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Anchor Dashboard Summary']"));
		return labour;
	}
	public static WebElement FileNotFound()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='File Not Found']"));
		return labour;
	}
	public static WebElement clickInputFile()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Input Files']"));
		return labour;
	}
	public static WebElement clickManageMaster()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Manage Masters']"));
		return labour;
	}
	public static WebElement clickSealandSignatureBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@src='../assets/vectors/UploadButton.svg']"));
		return labour;
	}
	public static WebElement clickBrowse1()		//Method for searching Username input
	{
		 // wait = new WebDriverWait(getDriver(), 20);
	       labour = getDriver().findElement(By.xpath("//label[normalize-space()='Browse']"));
	   	     return labour;
		
	}
	
	public static WebElement clickMsg()	
	{
		labour = getDriver().findElement(By.xpath("//h4[@class='f-label']"));
		return labour;
	}
	public static WebElement clickcloseBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Close']"));
		return labour;
	}
	public static WebElement clickDesignation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Designation']"));
		return labour;
	}
	public static WebElement clickAddNewDesignation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Add New']"));
		return labour;
	}
	public static WebElement enterDesignation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@id='Designation']"));
		return labour;
	}

	public static WebElement readTotalItemDesignation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-designation-master/kendo-grid/kendo-pager/kendo-pager-info"));
		return labour;
	}
	public static WebElement clickExportBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='exportbtn']"));
		return labour;
	}
	public static WebElement GridLoad1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-designation-master/div[2]/kendo-loader/div/span[1]"));
		return labour;
	}
	public static WebElement clickUploadBtn()	
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Upload Bulk']"));
		return labour;
	}
	public static WebElement SampleDocumentDownload()
	{
		labour = getDriver().findElement(By.xpath("(//a[normalize-space()='Sample Document'])[1]"));
		return labour;
	}
	public static WebElement UploadDesignationDetailes()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Upload Designation Details']"));
		return labour;
	}
	public static WebElement clickstatus()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])[2]"));
		return labour;
	}

	public static WebElement clickDeletemsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Are you sure you want to inactive this record?']"));
		return labour;
	}
	public static WebElement clickDeletemsg1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Designation Inactivated Successfully']"));
		return labour;
	}
	public static WebElement clickclearBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@src='../assets/vectors/ClearFilter.svg']"));
		return labour;
	}
	public static WebElement StateCitySearch()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@placeholder='Search State/Location Code']"));
		return labour;
	}
	public static WebElement StateCityAddressMapping()
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Address Mapping']"));
		return labour;
	}
	public static WebElement StateCityAddressMapping_ClearXcrossMark() //this is clear x mark need to clear dropdown value 
	{
		labour = getDriver().findElement(By.xpath("//span[@class='k-clear-value ng-star-inserted']"));
		return labour;
	}
	public static WebElement StateCitySelectAddressDropdown() 
	{
		labour = getDriver().findElement(By.xpath("(//input[@class='k-input-inner'])[2]"));
		return labour;
	}
	public static WebElement StateCityAddressMapping_2ndValue() 
	{
		labour = getDriver().findElement(By.xpath("//li[@class='k-list-item ng-star-inserted'][2]"));
		return labour;
	}
	public static WebElement StateCityAddressMapping_SaveBtn() 
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Save'])[1]"));
		return labour;
	}
	public static WebElement StateCitySealAndSingnature()
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Seal & Signature'])[1]"));
		return labour;
	}
	public static WebElement StateCitySearchSelectSeondValue()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//div[@class='k-list-content']//ul//li[2]"));
		return labour;
	}
	public static WebElement DesignationSerach()		
	{
		labour = getDriver().findElement(By.xpath("//input[@placeholder='Search/Select Designation']"));
		return labour;
	}
	public static WebElement LeaveTypeModule()		
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Leave Type']"));
		return labour;
	}
	public static WebElement LeaveTypeSearch()		
	{
		labour = getDriver().findElement(By.xpath("//input[@placeholder='Search Leave Type/Description']"));
		return labour;
	}
	public static WebElement clickPaycodeMappingModule()		
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Paycode Mapping']"));
		return labour;
	}
	public static WebElement PaycodeMappingSearch()		
	{
		labour = getDriver().findElement(By.xpath("//input[@placeholder='Search Paycode/Header Name']"));
		return labour;
	}
	public static WebElement Uplaodclick()		
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Upload']"));
		return labour;
	}
	
	public static WebElement clickStaturyMasterTab()		
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Statutory Master']"));
		return labour;
	}
	public static WebElement clickChallanPTSlabTab()		
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Challan PT Slab']"));
		return labour;
	}
	public static WebElement clickComplianceDropdwon()		
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Compliance Type']"));
		return labour;
	}
	public static WebElement Apply()		
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Apply']"));
		return labour;
	}
	public static WebElement Clear()		
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Clear']"));
		return labour;
	}
	public static WebElement clickOnSelectStateDropdown()		
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select State')]"));
		return labour;
	}
	public static WebElement clickOnKeralaState()		
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Kerala']"));
		return labour;
	}
	public static WebElement TypeToSearch()		
	{
		labour = getDriver().findElement(By.xpath("//input[@placeholder='Type to Search']"));
		return labour;
	}
	
	public static WebElement ReadTotalIteams() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//kendo-pager-info[@class='k-pager-info k-label']"),
	        By.xpath(""),
	        By.xpath("")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("Reead Total Iteams");
	    return null; // All locators failed
	}
	
	
	
}
