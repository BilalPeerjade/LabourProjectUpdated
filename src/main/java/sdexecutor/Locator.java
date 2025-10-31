package sdexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class Locator extends BasePage
{
	private static WebElement labour = null;			//WebElement variable created for Username input 

	

	public static WebElement pendingAssignmentCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//div[@class='row col-md-12 colpadding0']//div[1]//div[1]//p[1]"));
		return labour;
	}
	public static WebElement readTotalItems()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-pager-info k-label']"));
		return labour;
	}
	public static WebElement readTotalItems1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-notices/div/kendo-grid/kendo-pager/kendo-pager-info"));
		return labour;
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
	public static WebElement EditBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Edit'])"));
		return labour;
	}
	public static WebElement clickBack()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
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
	public static WebElement clickExport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Export']"));
		return labour;
	}
	public static WebElement clickOTAReport()
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='OTA Report']"));
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
	public static WebElement clickOkBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='OK']"));
		return labour;
	}
	public static WebElement ExistingLicesne()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Existing License']"));
		return labour;
	}
	public static WebElement pendingAssignmentLicenseCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div[1]/div[2]/div/div[1]/div/p"));
		return labour;
	}
	public static WebElement pendingActionLicenseCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div[1]/div[2]/div/div[2]/div/p"));
		return labour;
	}
	public static WebElement OverdueLicenseCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div[1]/div[2]/div/div[3]/div/p"));
		return labour;
	}

	public static WebElement ClosedLicenseCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div[1]/div[2]/div/div[4]/div/p"));
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
		labour = getDriver().findElement(By.xpath("//*[@class='k-window-title k-dialog-title']"));
		return labour;
	}
	public static WebElement ExistingLicesneInitiateAction()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Initiate Action'])[1]"));
		return labour;
	}
	public static WebElement ExistingLicesneTringle()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-svg-i-caret-alt-right k-treelist-toggle k-svg-icon k-icon']"));
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
	public static WebElement ExistingLicesneDownload()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@alt='Download Icon']"));
		return labour;
	}
	public static WebElement clickSubmit()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Submit']"));
		return labour;
	}
	public static WebElement submittedToDept()
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Submitted to department']"));
		return labour;
	}
	public static WebElement closureBtn()
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Closure']"));
		return labour;
	}
	public static WebElement gridLoad()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div[4]/kendo-loader/div/span[1]"));
		return labour;
	}
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
	public static WebElement yesRadio()
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Yes']//input[@type='radio']"));
		return labour;
	}
	public static WebElement noRadio()
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='No']//input[@type='radio']"));
		return labour;
	}
	public static WebElement browse()
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Browse']"));
		return labour;
	}
	public static WebElement brows2()
	{
		labour = getDriver().findElement(By.xpath("(//button[normalize-space()='Browse'])[2]"));
		return labour;
	}
	public static WebElement brows3()
	{
		labour = getDriver().findElement(By.xpath("(//button[normalize-space()='Browse'])[3]"));
		return labour;
	}
	public static WebElement errorText()
	{
		labour = getDriver().findElement(By.xpath("//div[@class='text-danger']"));
		return labour;
	}
	public static WebElement errorText2()
	{
		labour = getDriver().findElement(By.xpath("(//div[@class='text-danger'])[2]"));
		return labour;
	}
	public static WebElement errorText3()
	{
		labour = getDriver().findElement(By.xpath("(//div[@class='text-danger'])[3]"));
		return labour;
	}
	public static WebElement registrationLicenseNO()
	{
		labour = getDriver().findElement(By.xpath("//div[@class='require-container']//input[@type='text']"));
		return labour;
	}
	public static WebElement message1()
	{
		labour = getDriver().findElement(By.xpath("(//h4[@class='f-label'])[1]"));
		return labour;
	}
	public static WebElement message3()
	{
		labour = getDriver().findElement(By.xpath("(//h4[@class='f-label'])[3]"));
		return labour;
	}
	public static WebElement calendar1()
	{
		labour = getDriver().findElement(By.xpath("(//button[@aria-label='Toggle calendar'])[1]"));
		return labour;
	}
	public static WebElement calendar2()
	{
		labour = getDriver().findElement(By.xpath("(//button[@aria-label='Toggle calendar'])[2]"));
		return labour;
	}
	public static WebElement calendar3()
	{
		labour = getDriver().findElement(By.xpath("(//button[@aria-label='Toggle calendar'])[3]"));
		return labour;
	}
	public static WebElement calendar4()
	{
		labour = getDriver().findElement(By.xpath("(//button[@aria-label='Toggle calendar'])[4]"));
		return labour;
	}
	public static WebElement isLifeTime()
	{
		labour = getDriver().findElement(By.xpath("//input[@id='rdGen']"));
		return labour;
	}
	public static WebElement draftExtFromSMEDownload()
	{
		labour = getDriver().findElement(By.xpath("//img[@alt='Action Icon']"));
		return labour;
	}
	public static WebElement AcknowledgementCopy()
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/NoAccessDownload.svg']"));
		return labour;
	}
	public static WebElement PaymentReceipt()
	{
		labour = getDriver().findElement(By.xpath("(//img[@src='../assets/vectors/NoAccessDownload.svg'])[2]"));
		return labour;
	}
	public static WebElement UploadedFinalRCLicense()
	{
		labour = getDriver().findElement(By.xpath("(//img[@src='../assets/vectors/NoAccessDownload.svg'])[3]"));
		return labour;
	}

}
