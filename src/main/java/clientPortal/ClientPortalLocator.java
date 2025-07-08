package clientPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class ClientPortalLocator extends BasePage
{
	
private static WebElement labour = null;			//WebElement variable created for Username input 

	

public static WebElement clickEntity()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("//span[@class='k-input-inner k-readonly']"));
	return labour;
}
public static WebElement clickTringle()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])"));
	return labour;
}
public static WebElement clickTringle1()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[2]"));
	return labour;
}
public static WebElement clickTringle3()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[4]"));
	return labour;
}
public static WebElement selectEnity()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("//*[@value='AVACORED5']"));
	//input[@value='AVACORED']
	return labour;
}
public static WebElement selectEnity1()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("//input[@value='AVAAEntity']"));
	return labour;
}
public static WebElement selectEnity2()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("//input[@value='AVACORP6']"));
	return labour;
}
public static WebElement clickYear()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("(//*[@role=\"combobox\"])[4]"));
	//*[@class='k-input-value-text']
	return labour;
}

public static WebElement selectYear()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("//span[normalize-space()='2025']"));
	return labour;
}
public static WebElement ClickApplyBtn()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ApplyFilter.svg']"));
	return labour;
}
public static WebElement clickLicense()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("//*[@type='button']"));
	return labour;
}


	public static WebElement clickRegistration()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Registration']"));
		return labour;
	}
	public static WebElement clickAddNew()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Add New']"));
		return labour;
	}
	public static WebElement clickState()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[3]"));
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
	public static WebElement clickLocation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])"));
		return labour;
	}
	public static WebElement clickLocation1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[4]"));
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
		labour = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text ng-star-inserted'])"));
		//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[5]
		return labour;
	}
	public static WebElement clickNoticeBranch1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select Branch')]"));
		//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[5]
		return labour;
	}
	public static WebElement clickModeOfReceipt()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[6]"));
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
	public static WebElement clickOkBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='OK']"));
		return labour;
	}
	public static WebElement clickMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[@class='f-label']"));
		return labour;
	}
	public static WebElement clickBack()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
		return labour;
	}
	public static WebElement clickBackArrow()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Back']"));
		return labour;
	}
	public static WebElement clickExport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Export']"));
		return labour;
	}
	public static WebElement clickExistingLicenseExport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='exportbtn']"));
		return labour;
	}
	public static WebElement readTotalItems()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//kendo-pager-info[@class='k-pager-info k-label ng-star-inserted']"));
		return labour;
	}
	public static WebElement readTotalItemsNotice()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-notice-client-portal/kendo-grid/kendo-pager/kendo-pager-info"));
		return labour;
	}
	public static WebElement readTotalItemsMasterAbstract()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-master-abstracts/kendo-grid/kendo-pager/kendo-pager-info"));
		return labour;
	}
	public static WebElement SearchBox()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@placeholder='Type to Search']"));
		return labour;
	}
	public static WebElement ClearBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ClearFilter.svg']"));
		return labour;
	}
	public static WebElement EditBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Edit'])"));
		return labour;
	}
	public static WebElement ExistingLicesne()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Existing License']"));
		return labour;
	}
	public static WebElement ExistingLicesneViewIcon()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='View'])[1]"));
		return labour;
	}
	public static WebElement ExistingLicesneInitiateAction()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Initiate Action'])[1]"));
		return labour;
	}
	public static WebElement ExistingLicesneDownload()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@alt='Download Icon']"));
		return labour;
	}
	public static WebElement ExistingLicesneDetailes()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-window-title k-dialog-title']"));
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
	public static WebElement SccessMsgSubActivity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='SubActivity saved successfully']"));
		return labour;
	}
	public static WebElement clickTringleSubactivity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//tbody/tr[1]/td[1]/kendo-icon-wrapper[1]/*[1]"));
		return labour;
	}
	public static WebElement ExistingLicesneSubactivityViewIcon()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='View'])[2]"));
		return labour;
	}
	public static WebElement ExistingLicesneSubActivityDownload()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@alt='Download Icon'])[2]"));
		return labour;
	}
	public static WebElement GridLoad()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div/div[3]/kendo-loader/div/span"));
		return labour;
	}
	public static WebElement downloadLicenseDoc()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@src='../assets/vectors/DownloadMedium.svg']"));
		return labour;
	}
	public static WebElement RegistrationRepository()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Registration Repository']"));
		return labour;
	}
	public static WebElement Branch()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-input-value-text ng-star-inserted']"));
		return labour;
	}
	public static WebElement selectBranch()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Assam')]"));
		//span[contains(text(),'Assam')]
		//*[@value='undefined']
		return labour;
	}
	public static WebElement clickActivities()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-input-value-text']"));
		return labour;
	}
	public static WebElement selectActivities()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[3]"));
		return labour;
	}
	public static WebElement clickDownload()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Download']"));
		return labour;
	}
	public static WebElement clickDownload1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@title='Download'])[2]"));
		return labour;
	}
	public static WebElement clickDocViewer()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-window-title k-dialog-title']"));
		return labour;
	}
	public static WebElement ClickClose()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Close']"));
		return labour;
	}
	public static WebElement clickAlert()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Invalid file type.']"));
		return labour;
	}
	public static WebElement clickNotices()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Notices']"));
		return labour;
	}
	public static WebElement clickaddnewNotices()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Add New']"));
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
	public static WebElement clickCalenderNoticeReceiveDate()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@id=\"kendo-dialog-content-148938\"]/div/form/div[4]/div[1]/div/app-kendo-datepicker/kendo-datepicker/button/kendo-icon-wrapper/kendo-svgicon"));
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
		labour = getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='28']"));
		return labour;
	}
	public static WebElement clickNoticeType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[7]"));
		return labour;
	}
	public static WebElement clickRisk()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[8]"));
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
		labour = getDriver().findElement(By.xpath("//h4[@class='f-label']"));
		return labour;
	}
	public static WebElement clickInvalidNotice()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Notice Number already exist']"));
		return labour;
	}
	public static WebElement clickNoticeDocMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//div[normalize-space()='File is required.']"));
		return labour;
	}
	public static WebElement clickNoticeExport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@src='../assets/vectors/ExportButton.svg']"));
		return labour;
	}
	public static WebElement clickviewNoticeDocIcon()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Overview'])[1]"));
		return labour;
	}
	public static WebElement clickAct2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select Act')]"));
		return labour;
	}
	public static WebElement clickComplianceStatus()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Compliance Status')]"));
		return labour;
	}
	public static WebElement clickStatutoryDoc()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Statutory Documents']"));
		
		return labour;
	}
	public static WebElement clickComplianceType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[@class='k-input-value-text'][normalize-space()='Compliance']"));
		return labour;
	}
	public static WebElement selectComplianceType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li"));
		return labour;
	}
	public static WebElement selectComplianceType1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class=\"k-list-ul\"]/li[2]"));
		return labour;
	}
	public static WebElement selectComplianceType2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Shops and Establishment and Allied Acts']"));
		return labour;
	}
	public static WebElement selectComplianceType3()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='2025']"));
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
	public static WebElement clickPeriod()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Period')]"));
		//span[contains(text(),'Period')]
		return labour;
	}
	public static WebElement PeriodList()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']"));
		return labour;
	}
	public static WebElement clickApply()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='figma-btn-white Actionbutton']"));
		return labour;
	}
	public static WebElement clickBranchTiangle()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[2]"));
		//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted']
		return labour;
	}
	public static WebElement clickBranchcheckbox()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@type=\"checkbox\"])[2]"));
		//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted']
		return labour;
	}
	public static WebElement selectBranch1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@role='group'])[2]"));
		//*[@role='group'])[2]/li
		return labour;
	}
	public static WebElement clickClearBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ClearFilter.svg']"));
		return labour;
	}
	public static WebElement clickdashboard()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Dashboard']"));
		return labour;
	}
	public static WebElement clickMyDoc()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='My Documents']"));
		return labour;
	}
	public static WebElement clickMyDashboard()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='My Dashboard']"));
		return labour;
	}
	public static WebElement gridLoad1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-my-compliance-document/div[3]/kendo-loader/div/span"));
		
		return labour;
	}
	
	public static WebElement FileNotFound()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='File Not Found']"));
		return labour;
	}
	public static WebElement clickview()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("	//img[@title='View']"));
		return labour;
	}
	public static WebElement clickview2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='View'])[2]"));
		return labour;
	}
	public static WebElement clickview3()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='View'])[3]"));
		return labour;
	}
	public static WebElement clickview1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='svg-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement viewPopup()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-window-title k-dialog-title'])[2]"));
		return labour;
	}
	public static WebElement viewPopup1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-window-title k-dialog-title']"));
		return labour;
	}
	public static WebElement clickCloseBtn1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//button[@title='Close'])[2]"));
		return labour;
	}
	public static WebElement clickCloseBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Close']"));
		return labour;
	}
	public static WebElement clickCheckBox()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@type=\"checkbox\"])[2]"));
		return labour;
	}
	public static WebElement clickDownloadbulk()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Download']"));
		return labour;
	}
	public static WebElement clickMasterAbstract()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Abstracts']"));
		return labour;
	}
	public static WebElement clickVieqRegional()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@alt='Icon e'])"));
		return labour;
	}
	public static WebElement clickViewEnglish()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@alt='Action Icon']"));
		return labour;
	}
	public static WebElement clickState1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@role='combobox']"));
		return labour;
	}
	public static WebElement clickDownloadRegiinal()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//tbody/tr[@role='row']/td[3]/img[1])"));
		return labour;
	}
	public static WebElement clickDownloadEnglishl()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//tbody/tr[@role='row']/td[4]/img[1])"));
		return labour;
	}
}

