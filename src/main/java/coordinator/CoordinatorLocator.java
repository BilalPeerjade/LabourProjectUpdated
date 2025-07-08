package coordinator;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class CoordinatorLocator extends BasePage
{
	private static WebElement labour = null;			//WebElement variable created for Username input 

	

	public static WebElement pendingAssignmentCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//div[@class='row col-md-12 colpadding0']//div[1]//div[1]//p[1]"));
		return labour;
	}
/*	public static WebElement readTotalItems()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-pager-info k-label']"));
		return labour;
	}
*/	
	public static WebElement readTotalItems() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//*[@class='k-pager-info k-label']"),
	        By.cssSelector("body > app-root > div > app-layout > section > div > div > app-new-registration-license > div.grid.ng-star-inserted > app-grid-action-item > kendo-grid > kendo-pager > kendo-pager-info"),
	        By.xpath("//kendo-pager-info[@class='k-pager-info k-label ng-star-inserted']"),
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
	    System.out.println("❌ Element not found using any locator.");
	    return null; // All locators failed
	}
	
	
	public static WebElement pendingActionCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//div[@class='dashboard-container colpadding0']//div[2]//div[1]//p[1]"));
		return labour;
	}
	public static WebElement OverdueCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//body[1]/app-root[1]/div[1]/app-layout[1]/section[1]/div[1]/div[1]/app-notices[1]/div[1]/div[2]/div[3]/div[1]/p[1]"));
		return labour;
	}
	public static WebElement ClosedCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//body[1]/app-root[1]/div[1]/app-layout[1]/section[1]/div[1]/div[1]/app-notices[1]/div[1]/div[2]/div[4]/div[1]/p[1]"));
		return labour;
	}
	public static WebElement clickaddnewNotices()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Add Notice']"));
		return labour;
	}
	public static WebElement clickEntity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])"));
		return labour;
	}
	public static WebElement clickEntityRehistrationDropdown()
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select Entity')]"));
		return labour;
	}
	public static WebElement selectEntity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li"));
		return labour;
	}
	
	public static WebElement clickState()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[2]"));
		return labour;
	}
	public static WebElement clickStateRegistrationDropdown()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[2]"));
		return labour;
	}
	public static WebElement selectState()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[11]"));
		return labour;
	}
	public static WebElement selectState1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[3]"));
		return labour;
	}
	public static WebElement selectStateAndraPardesh()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Andhra Pradesh']"));
		return labour;
	}
	public static WebElement clickLocation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])"));
		return labour;
	}
	public static WebElement clickLocation1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[3]"));
		return labour;
	}
	public static WebElement selectLocation1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return labour;
	}
	public static WebElement clickBranch()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[2]"));
		return labour;
	}
	public static WebElement clickBranch1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[4]"));
		return labour;
	}
	public static WebElement clickModeOfReceipt()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[5]"));
		return labour;
	}
	public static WebElement clickNoticeNumber()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname='noticeNo']"));
		return labour;
	}
	public static WebElement clickCalender()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement clickCalenderReponseDueDate()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon ng-star-inserted'])[2]"));
		return labour;
	}
	public static WebElement selectDate()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='2']"));
		return labour;
	}
	public static WebElement selectDate2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='6']"));
		return labour;
	}
	public static WebElement clickNoticeType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[6]"));
		return labour;
	}
	public static WebElement clickRisk()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[7]"));
		return labour;
	}
	public static WebElement clickRemark()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname='remarks']"));
		return labour;
	}
	public static WebElement clickSaveNotice()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Save Notice']"));
		return labour;
	}
	public static WebElement clickSuccessNotice()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Notice Saved Successfully']"));
		return labour;
	}
	public static WebElement clickInvalidNotice()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Notice Number already exist']"));
		return labour;
	}
	
	public static WebElement clickOkBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='OK']"));
		return labour;
	}
	public static WebElement clickBack()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
		return labour;
	}
	public static WebElement clickNoticeExport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@src='../assets/vectors/ExportButton.svg']"));
		return labour;
	}
	public static WebElement SearchBox()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@placeholder='Type to Search']"));
		return labour;
	}
	
	public static WebElement EnterRemarksfield() //Me
	{
		labour = getDriver().findElement(By.xpath("//textarea[@placeholder='Enter Remarks']"));
		return labour;
	}
	public static WebElement ClearBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ClearFilter.svg']"));
		return labour;
	}
	public static WebElement clickDownload()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Download']"));
		return labour;
	}
	public static WebElement GridLoad()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-notices/div/div[4]/kendo-loader/div/span[1]"));
		return labour;
	}
	public static WebElement EditBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Edit'])"));
		return labour;
	}
	public static WebElement EditBtn1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Edit'])[2]"));
		return labour;
	}
	public static WebElement clickNoticeDocMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//div[normalize-space()='File is required.']"));
		return labour;
	}
	public static WebElement clickRegistration()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Registration']"));
		return labour;
	}
	public static WebElement RegistartionpendingAssignmentCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='mb-0 count-text']"));
		return labour;
	}
	public static WebElement RegistartionpendingActionCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='mb-0 count-text'])[2]"));
		return labour;
	}
	public static WebElement RegistartionOverdueCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='mb-0 count-text'])[3]"));
		return labour;
	}
	public static WebElement RegistartionClosedCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='mb-0 count-text'])[4]"));
		return labour;
	}
	public static WebElement clickAddNew()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Add New']"));
		return labour;
	}
	public static WebElement clickLicenseType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select License Type')]"));
		return labour;
	}
	public static WebElement selectLicenseType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[2]"));
		return labour;
	}
	public static WebElement selectLicenseTypeFSSAI()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='FSSAI LICENCE Registration']"));
		return labour;
	}
	public static WebElement clickEmpName()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[3]"));
		return labour;
	}
	public static WebElement clickEmpAddress()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[4]"));
		return labour;
	}
	public static WebElement clickEmpMailId()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[5]"));
		return labour;
	}
	public static WebElement clickEmpContact()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[6]"));
		return labour;
	}
	public static WebElement clickMaleCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='number'])[1]"));
		return labour;
	}
	public static WebElement clickFemaleCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='number'])[2]"));
		return labour;
	}
	public static WebElement clickManagerMailId()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[7]"));
		return labour;
	}
	public static WebElement clickContactNo()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[8]"));
		return labour;
	}
	public static WebElement clickAddress()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[9]"));
		return labour;
	}
	public static WebElement clickSubmit()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Submit']"));
		return labour;
	}
	public static WebElement clickSuccessMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Registration saved successfully']"));
		return labour;
	}
	public static WebElement clickExport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Export']"));
		return labour;
	}
	public static WebElement clickDelete()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Delete'])[1]"));
		return labour;
	}
	public static WebElement clickDeleteMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Are you sure you want to delete this License?']"));
		return labour;
	}
	public static WebElement clickCancelBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Cancel']"));
		return labour;
	}
	public static WebElement ExistingLicesne()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Existing License']"));
		return labour;
	}
	public static WebElement pendingAssignmentLicenseCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div[1]/div[1]/div/div[1]/div/p"));
		return labour;
	}
	public static WebElement pendingActionLicenseCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div[1]/div[1]/div/div[2]/div/p"));
		return labour;
	}
	public static WebElement OverdueLicenseCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div[1]/div[1]/div/div[3]/div/p"));
		return labour;
	}

	public static WebElement ClosedLicenseCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div[1]/div[1]/div/div[4]/div/p"));
		return labour;
	}
	public static WebElement clickExistingLicenseExport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='exportbtn']"));
		return labour;
	}
	
	public static WebElement ExistingLicesneViewIcon()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='View'])[1]"));
		return labour;
	}
	public static WebElement ExistingLicesneDetailes()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[@title='Existing License Details']"));
		return labour;
	}
	public static WebElement ExistingLicesneInitiateAction()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Initiate Action'])[1]"));
		return labour;
	}
	public static WebElement clickActivityTab()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[4]"));
		return labour;
	}
	public static WebElement selectActivityTab()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[3]"));
		return labour;
	}
	public static WebElement selectActivityTab6()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[6]"));
		return labour;
	}
	public static WebElement SccessMsgSubActivity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='SubActivity saved successfully']"));
		return labour;
	}
	public static WebElement ExistingLicesneDownload()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@alt='Download Icon']"));
		return labour;
	}
	public static WebElement clickSMETeam()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select SME Team')]"));
		return labour;
	}
	
	public static WebElement selectSMETeam()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return labour;
	}
	public static WebElement clickSDExecuterTeam()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])[9]"));
		return labour;
	}
	public static WebElement selectSDExecuterTeam()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-item']"));
		return labour;
	}
	public static WebElement clickSave()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//button[normalize-space()='Save'])[2]"));
		return labour;
	}
	public static WebElement EditBasicInfoSave()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//button[normalize-space()='Save'])[1]"));
		return labour;
	}
	
	public static WebElement clickSuccessMsg1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Notice saved succesfully']"));
		return labour;
	}
	public static WebElement gridLoad()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div[4]/kendo-loader/div/span[1]"));
		return labour;
	}
	public static WebElement deleteMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='License deleted successfully']"));
		return labour;
	}
	
	public static WebElement SelectSMETeamMohit()		
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return labour;
	}
	public static WebElement clickSDExecutorTeam()		
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[21]"));
		return labour;
	}
	
	public static WebElement SelectSDExecutorRitwik()		
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[21]"));
		return labour;
	}
	public static WebElement TranslationReqYes()		
	{
		labour = getDriver().findElement(By.xpath("//input[@id='rdGen']"));
		return labour;
	}
	
	//These from edit mini tabs
	public static WebElement plus1()		
	{
		labour = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn'])[1]"));
		return labour;
	}
	public static WebElement plus2()		
	{
		labour = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn'])[2]"));
		return labour;
	}
	public static WebElement plus3()		
	{
		labour = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn'])[3]"));
		return labour;
	}
	public static WebElement plus4()		
	{
		labour = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn'])[4]"));
		return labour;
	}
	
	public static WebElement clickonRCPDropdown()		
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select RCP')]"));
		return labour;
	}
	public static WebElement selectonRCPDropdownuser()		
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='RCP USA']"));
		return labour;
	}
	public static WebElement clickonSDExeDropdown()		
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select SD Executor')]"));
		return labour;
	}
	public static WebElement selectonSDExDropdownRITWIK()		
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='RITWIK Jaguar']"));
		return labour;
	}
	
	
	
	
	
	
	
}
