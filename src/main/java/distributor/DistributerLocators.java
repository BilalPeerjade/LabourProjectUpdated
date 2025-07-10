package distributor;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import login.BasePage;



public class DistributerLocators extends BasePage
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
	public static WebElement clickPremiseMasterArrow()
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Premise Master'])[1]"));
		return labour;
	}
	public static WebElement clickManageMaster()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Manage Masters']"));
		return labour;
	}
	public static WebElement clickOnBoardEntity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Onboard Entity']"));
		return labour;
	}
	public static WebElement clickComplianceAssignment()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Compliance Assignment']"));
		return labour;
	}
	public static WebElement clickOnboardCLRA()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Onboard CLRA']"));
		return labour;
	}
	public static WebElement clickSearchState()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@placeholder='Search State/Location Code']"));
		return labour;
	}
	public static WebElement clickApplyBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[@type='submit']"));
		return labour;
	}
	public static WebElement clickAddNewBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Add New']"));
		return labour;
	}
	public static WebElement clickState()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'])[2]"));
		return labour;
	}
	public static WebElement clickcity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@placeholder='Enter City']"));
		return labour;
	}
	public static WebElement clicklocation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@placeholder='Enter Location']"));
		return labour;
	}
	public static WebElement clicksave()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//button[normalize-space()='Save'])"));
		return labour;
	}
	public static WebElement clicksaveMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Principle Employer saved successfully']"));
		return labour;
	}
	public static WebElement clickUpdateMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Principle Employer updated successfully']"));
		return labour;
	}
	public static WebElement clickSucessMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//h4[normalize-space()='Saved Successfully'])"));
		return labour;
	}
	public static WebElement clickOkBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='OK']"));
		return labour;
	}
	public static WebElement clickcloseBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Close']"));
		return labour;
	}
	public static WebElement clickInvalidLocationCode()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//small[@class='text-danger ng-star-inserted']"));
		return labour;
	}
	public static WebElement InvalidMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='col-md-12 f-label alert-msg']/h4"));
		return labour;
	}
	public static WebElement clickExport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Export']"));
		return labour;
	}
	public static WebElement clickExportCLRALocationLoader()		//Bilal
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-principle-employer/div[4]/kendo-loader/div/span[1]"));
		return labour;
	}
/*	public static WebElement readTotalItem()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-location-master/div[3]/kendo-grid/kendo-pager/kendo-pager-info"));
		return labour;
	}*/
	public static WebElement readTotalItem() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//kendo-pager-info[@class='k-pager-info k-label']"),
	        By.cssSelector(""),
	        By.xpath(""),
	        By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-location-master/div[3]/kendo-grid/kendo-pager/kendo-pager-info")//Not working this    
	        );

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
	    System.out.println("❌ Element not found using any locator.");
	    return null; // All locators failed
	}
	
	
	
	public static WebElement readTotalItemDesignation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-designation-master/kendo-grid/kendo-pager/kendo-pager-info"));
		return labour;
	}
	public static WebElement clickDesignation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Designation']"));
		return labour;
	}
	public static WebElement clickLeaveType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Leave Type']"));
		return labour;
	}
	public static WebElement clickAddNewDesignation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Add New']"));
		return labour;
	}
	public static WebElement clickUpdateEmp()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Edit'])[1]"));
		return labour;
	}
	public static WebElement UpdateContractor()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@title='edit']"));
		return labour;
	}
	public static WebElement enterDesignation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@id='Designation']"));
		return labour;
	}
	public static WebElement successMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Designation Added Successfully']"));
		return labour;
	}
	public static WebElement InvalidMsgDesignation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath(" //h4[normalize-space()='Designation is already exists.']"));
		return labour;
	}
	public static WebElement clickCloseBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath(" //*[@class='k-svg-i-x k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return labour;
		
	}
	public static WebElement clickExportBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='exportbtn']"));
		return labour;
	}
	public static WebElement clickUploadBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Upload Bulk']"));
		return labour;
	}
	public static WebElement UploadDesignationDetailes()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Upload Designation Details']"));
		return labour;
	}
	public static void clickBrowse()		//Method for searching Username input
	{
		 // wait = new WebDriverWait(getDriver(), 20);
	         WebElement UploadDocument = getDriver().findElement(By.xpath("//label[normalize-space()='Browse']"));
	   	     UploadDocument.sendKeys("C:\\Users\\snehalp\\Documents\\DesignationSample.xlsx");
		
	}
	public static void clickBrowseSealandSegnature()		//Method for searching Username input
	{
		 // wait = new WebDriverWait(getDriver(), 20);
	         WebElement UploadDocument = getDriver().findElement(By.xpath("//label[normalize-space()='Browse']"));
	   	     UploadDocument.sendKeys("C:\\Users\\snehalp\\Documents\\chart_11zon.xlsx");
		
	}
	public static WebElement clickBrowse1()
	{
		 // wait = new WebDriverWait(getDriver(), 20);
	       labour = getDriver().findElement(By.xpath("//label[normalize-space()='Browse']"));
	   	     return labour;
		
	}
	public static WebElement clickUpload()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Upload']"));
		return labour;
	}
	public static WebElement clickSuccsessMesg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='File Uploaded Successfully']"));
		return labour;
	}
	public static WebElement clickDeleteBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Delete']"));
		return labour;
	}
	public static WebElement clickDeletemsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Are you sure you want to delete this record?']"));
		return labour;
	}
	public static WebElement clickDeletemsg1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Data Deleted Successfully']"));
		return labour;
	}
	public static WebElement clickstatus()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])[2]"));
		return labour;
	}
	public static WebElement selectstatus()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Active')]"));
		return labour;
	}
	public static WebElement clickclearBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@src='../assets/vectors/ClearFilter.svg']"));
		return labour;
	}
	public static WebElement clickdashboard()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='My Dashboard']"));
		return labour;
	}
	public static WebElement clickSearchFiletr()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@placeholder='Search Leave Type/Description']"));
		return labour;
	}
	public static WebElement clickPEName()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@type='text']"));
		return labour;
	}
	public static WebElement clickNatureOfBuisness()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[2]"));
		return labour;
	}
	public static WebElement clickComplianceType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='dropdowns']"));
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
	public static WebElement selectComplianceType5()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[13]"));
		return labour;
	}
	public static WebElement selectComplianceType2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[3]"));
		return labour;
	}
	public static WebElement selectComplianceType3()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[4]"));
		return labour;
	}
	public static WebElement selectComplianceType4()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[5]"));
		return labour;
	}
	public static WebElement clickType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//span[contains(text(),'Select Type')])[1]"));
		return labour;
	}
	public static WebElement selectType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[3]"));
		return labour;
	}
	public static WebElement clickBranch()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),' Select Branches ')]"));
		return labour;
	}
	public static WebElement selectBranch()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@value='undefined']"));
		return labour;
	}
	public static WebElement clickCalender()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class=\"k-svg-i-calendar k-button-icon k-svg-icon k-icon\"]"));
		return labour;
	}
	public static WebElement Calender()	
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Toggle calendar']"));
		return labour;
	}
	public static WebElement clickPerformer()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select Performer')]"));
		return labour;
	}
	public static WebElement selectPerformer()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[2]"));
		return labour;
	}
	public static WebElement clickreviewer()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select Reviewer')]"));
		return labour;
	}
	public static WebElement selectreviewer()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[2]"));
		return labour;
	}
	public static WebElement clickApply()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ApplyFilter.svg']"));
		return labour;
	}
	public static WebElement clickCheckBox2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@type='checkbox'])"));
		return labour;
	}
	public static WebElement clickCheckBox()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@type='checkbox'])[2]"));
		return labour;
	}
	public static WebElement clickCheckBox1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@type='checkbox'])[3]"));
		return labour;
	}
	public static WebElement CASuccessMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='col-md-12 f-label alert-msg']/h4"));
		return labour;
	}
	public static WebElement CASuccessMsg1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Compliance Assigned Successfully!']"));
		return labour;
	}
	public static WebElement clickClearBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ClearFilter.svg']"));
		return labour;
	}
	public static WebElement clickSearcbox()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@placeholder='Type To Search']"));
		return labour;
	}
	public static WebElement Search() //CLRA
	{
		labour = getDriver().findElement(By.xpath("//input[@placeholder='Type to Search']"));
		return labour;
	}
	public static WebElement clickSearcbox2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@placeholder='Type to Search']"));
		return labour;
	}
	public static WebElement clickSearcbox1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class=\"f-textbox\"]"));
		return labour;
	}
	public static WebElement validmsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Please Select the Branch and Date']"));
		return labour;
	}
	public static WebElement validmsg1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Please Select the Performer']"));
		return labour;
	}
	public static WebElement validmsg2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Please Select the Reviewer']"));
		return labour;
	}
	public static WebElement cancelbtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Cancel']"));
		return labour;
	}
	public static WebElement managecompliance()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Manage Compliances']"));
		return labour;
	}
	public static WebElement FirstTriangle()
	{
		labour = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon']"));
		return labour;
	}
	public static WebElement scheduleCreation()
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Schedules Creation']"));
		return labour;
	}
	public static WebElement ValidationMsg()
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Compliance Reassigned Successfully']"));
		return labour;
	}
	public static WebElement clickComplianceType1()	
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[2]"));
		return labour;
	}
	public static WebElement ComplianceTypeDropdown()	//Manage Compliance 
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Compliance Type')]"));
		return labour;
	}
	public static WebElement clickActivityDropDown()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])"));
		return labour;
	}

	public static WebElement clickBranch1()	
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select Branch')]"));
		return labour;
	}
	public static WebElement clickBranchTiangle()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[2]"));
		//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted']
		return labour;
	}
	public static WebElement clickBranchTiangle1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])"));
		//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted']
		return labour;
	}
	public static WebElement select_Bobbili_Avacored_branch()
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Bobbili_Avacored test')]"));
		//*[@role='group'])[2]/li
		return labour;
	}
	public static WebElement selectBranch1()
	{
		labour = getDriver().findElement(By.xpath("(//*[@role='group'])[2]"));
		//*[@role='group'])[2]/li
		return labour;
	}
	public static WebElement selectBranch2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//div[@class='ng-tns-c3525725031-1 k-treeview-top k-treeview-bot']"));
		//*[@role='group'])[2]/li
		return labour;
	}
	public static WebElement clickRole()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Role')]"));
		return labour;
	}
	public static WebElement clickUser()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'][normalize-space()='User'])[1]"));
		return labour;
	}
	public static WebElement clickNewUser()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'New User')]"));
		return labour;
	}
	public static WebElement CRValidDate()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Compliance Reassigned Successfully']"));
		return labour;
	}
	public static WebElement applybtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ApplyFilter.svg']"));
		return labour;
	}
	public static WebElement ActivationDateChangeMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Activation Date Updated']"));
		return labour;
	}
	public static WebElement ActivationDateChangeCalender()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement clickRemoveBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//button[normalize-space()='Remove'])[1]"));
		return labour;
	}
	public static WebElement AssignmentRemovalMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Assignment Removed Successfully']"));
		return labour;
	}
	public static WebElement clickPeriod()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Period')]"));
		return labour;
	}
	public static WebElement PeriodList()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']"));
		return labour;
	}
	public static WebElement clickYear()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Year')]"));
		return labour;
	}
	public static WebElement clickSubmit()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@type='submit']"));
		return labour;
	}
	public static WebElement ScheduleCreationMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Schedule created successfully.']"));
		return labour;
	}
	public static WebElement ScheduleRemovalMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Schedule Removed Successfully']"));
		return labour;
	}
	public static WebElement clickInputFile()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Input Files']"));
		return labour;
	}
	public static WebElement clickRegistrationRepository()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Registration Repository']"));
		return labour;
	}
	public static WebElement GridLoad()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-location-master/div[3]/div/kendo-loader/div/span[1]"));
		return labour;
	}
	public static WebElement GridLoad1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-designation-master/div[2]/kendo-loader/div/span[1]"));
		return labour;
	}
	public static WebElement clickStatutoryDoc()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Statutory Document']"));
		
		return labour;
	}
	public static WebElement clickAct2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Act')]"));
		return labour;
	}
	public static WebElement clickComplianceStatus()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Compliance Status')]"));
		return labour;
	}
	public static WebElement clickMsg()	 
	{
		labour = getDriver().findElement(By.xpath("//h4[@class='f-label']"));
		return labour;
	}
	public static WebElement MessageText()	 
	{
		labour = getDriver().findElement(By.xpath("//h4[@class='f-label']"));
		return labour;
	}
	public static WebElement ClickOK()
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='OK']"));
		return labour;
	}
	public static WebElement gridLoad()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-principle-employer/div[4]/kendo-loader/div/span[1]"));
		return labour;
	}
	public static WebElement holidayMaster()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Holiday Master']"));
		return labour;
	}
	public static WebElement clickUploadbtnCTCBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Upload']"));
		return labour;
	}
	public static WebElement bulkUpload()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title=\"Bulk Upload\"]"));
		return labour;
	}
	public static WebElement readTotalItem1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-principle-employer/div[2]/app-grid-action-item/kendo-grid/kendo-pager/kendo-pager-info"));
		return labour;
	}
	public static WebElement readTotalItem2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-employer-location/div[2]/app-grid-action-item/kendo-grid/kendo-pager/kendo-pager-info"));
		return labour;
	}
	public static WebElement clickLocation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Locations']"));
		return labour;
	}
	public static WebElement clickContractor()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Contractor']"));
		return labour;
	}
	public static WebElement clickEmpMapping()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Employee Mapping']"));
		return labour;
	}
	
	//Employee Mapping dropdowns...
	public static WebElement EMap_dropdown1()
	{
		labour = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])[1]"));
		return labour;
	}
	public static WebElement EMap_dropdown2()
	{
		labour = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])[2]"));
		return labour;
	}
	public static WebElement EMap_dropdown3()
	{
		labour = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])[3]"));
		return labour;
	}
	public static WebElement EMap_dropdown4()
	{
		labour = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])[4]"));
		return labour;
	}
	public static WebElement EMap_select2ndvalue()
	{
		labour = getDriver().findElement(By.xpath("//li[@class='k-list-item'][2]"));
		return labour;
	}
	public static WebElement EMap_checkbox()
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		return labour;
	}
	
	public static WebElement EMap_Migrate_dropdown1()
	{
		labour = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement EMap_Migrate_dropdown2()
	{
		labour = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[2]"));
		return labour;
	}
	public static WebElement EMap_Migrate_dropdown3()
	{
		labour = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[3]"));
		return labour;
	}
	public static WebElement EMap_Migrate_selectValue2()
	{
		labour = getDriver().findElement(By.xpath("//li[@class='k-list-item ng-star-inserted'][2]"));
		return labour;
	}
	public static WebElement Calendar1()
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Toggle calendar']"));
		return labour;
	}
	public static WebElement Calendar2()
	{
		labour = getDriver().findElement(By.xpath("(//button[@title='Toggle calendar'])[2]"));
		return labour;
	}
	public static WebElement Calendar3()
	{
		labour = getDriver().findElement(By.xpath("(//button[@title='Toggle calendar'])[3]"));
		return labour;
	}
	public static WebElement Calendar_NavigateToParentView()
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Navigate to parent view']"));
		return labour;
	}
	public static WebElement Calendar_NavigateToParentView_2026()
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='2026']"));
		return labour;
	}
	
	
	
	
	
	public static WebElement clickemp()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@role='combobox']"));
		return labour;
	}
	
	public static WebElement clickState2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@role='combobox'])[2]"));
		return labour;
	}
	public static WebElement clickState1()
	{
		labour = getDriver().findElement(By.xpath("(//*[@role='combobox'])[1]"));
		return labour;
	}
	public static WebElement clickLocation1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@role='combobox'])[2]"));
		return labour;
	}
	public static WebElement clickAddNewBtn1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Add New']"));
		return labour;
	}
	public static WebElement clicKBranch()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@type='text']"));
		return labour;
	}
	
	public static WebElement clicKBranchAddress()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//textarea)[1]"));
		return labour;
	}
	public static WebElement clickNumber()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@type='number']"));
		return labour;
	}
	public static WebElement clickCalender1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon']"));
		return labour;
	}
	public static WebElement clickCalender2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon'])[2]"));
		return labour;
	}
	public static WebElement clickCalender3()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon'])[3]"));
		return labour;
	}
	public static WebElement clickCalender4()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon'])[4]"));
		return labour;
	}
	public static WebElement selectDate()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[@class='k-link'][normalize-space()='2']"));
		return labour;
	}
	public static WebElement selectDate1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[@class='k-link'][normalize-space()='25']"));
		return labour;
	}
	public static WebElement selectDate2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[@class='k-link'][normalize-space()='3']"));
		return labour;
	}
	public static WebElement selectDate3()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[@class='k-link'][normalize-space()='22']"));
		return labour;
	}
	public static WebElement clickWeekOff()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@role='combobox'])[5]"));
		return labour;
	}
	public static WebElement clickPEType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[1]"));
		return labour;
	}
	
	public static WebElement clickPEActType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[2]"));
		return labour;
	}
	public static WebElement weekHourseFrom()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[3]"));
		return labour;
	}
	public static WebElement selectweekHourseFrom()	
	{
		labour = getDriver().findElement(By.xpath("(//li[@class='k-list-item'])"));
		return labour;
	}
	public static WebElement weekHourseTo()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[4]"));
		return labour;
	}
	public static WebElement selectweekHourseTo()	//9:00 AM
	{
		labour = getDriver().findElement(By.xpath("(//li[@class='k-list-item'])[36]"));
		return labour;
	}
	
	public static WebElement clickIntervalFrom()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[5]"));
		return labour;
	}
	public static WebElement selectIntervalFrom()		//1:00
	{
		labour = getDriver().findElement(By.xpath("(//li[@class='k-list-item'])[4]"));
		return labour;
	}
	public static WebElement clickIntervalTo()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[6]"));
		return labour;
	}
	public static WebElement selectIntervalTo()		//2:00 AM
	{
		labour = getDriver().findElement(By.xpath("(//li[@class='k-list-item'])[8]"));
		return labour;
	}
	public static WebElement clickLocationApplicablitiy()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[7]"));
		return labour;
	}
	public static WebElement clickUploadLocation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/uploadWhite.svg']"));
		return labour;
	}
	public static WebElement Upload()
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Uplaod']"));
		return labour;
	}
	public static WebElement clickLocationExportBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@src='../assets/vectors/ExportButton.svg']"));
		return labour;
	}
	public static WebElement clickLocationExportBtnLoader()		//Bilal
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-employer-location/div[3]/kendo-loader/div/span[1]"));
		return labour;
	}
	public static WebElement clickCheckBoxEmpMapping()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@type='checkbox'])[2]"));
		return labour;
	}
	public static WebElement clickMigrate()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Migrate']"));
		return labour;
	}
	public static WebElement clickMigrateState()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@role='combobox'])[6]"));
		return labour;
	}
	public static WebElement clickMigrateBranch()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@role='combobox'])[8]"));
		return labour;
	}
	public static WebElement clickMigrateLocation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@role='combobox'])[7]"));
		return labour;
	}
	public static WebElement selectPELoaction()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[2]"));
		return labour;
	}
	public static WebElement selectPELocationValue()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']//li[2]"));
		return labour;
	}
	public static WebElement selectPEBranch()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[3]"));
		return labour;
	}
	
	
	public static WebElement clickContractEndReaseon()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@placeholder='Contract End Reason']"));
		return labour;
	}
	public static WebElement clickSealandSignatureBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@src='../assets/vectors/UploadButton.svg']"));
		return labour;
	}
}
