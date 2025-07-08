package rcp;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class RCPLocator extends BasePage
{
	private static WebElement labour = null;			//WebElement variable created for Username input 
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
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div[1]/div[3]/div/div[1]/div/p"));
		return labour;
	}
	public static WebElement pendingActionLicenseCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div[1]/div[3]/div/div[2]/div/p"));
		return labour;
	}
	public static WebElement OverdueLicenseCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div[1]/div[3]/div/div[3]/div/p"));
		return labour;
	}

	public static WebElement ClosedLicenseCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div[1]/div[3]/div/div[4]/div/p"));
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
		labour = getDriver().findElement(By.xpath("//div[@class='icon-container']/button[2]"));
		return labour;
	}
	public static WebElement clickSubmit()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Submit']"));
		return labour;
	}
	public static WebElement gridLoad()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div[4]/kendo-loader/div/span[1]"));
		return labour;
	}
/*	public static WebElement readTotalItems()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//kendo-pager-info[@class='k-pager-info k-label']"));
		return labour;
	}*/
	public static WebElement readTotalItems() {
	    List<By> locators = Arrays.asList(
	    By.xpath("//kendo-pager-info[@class='k-pager-info k-label']"),
	    By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-new-registration-license/div[4]/app-grid-action-item/kendo-grid/kendo-pager/kendo-pager-info"),
	    By.cssSelector("body > app-root > div > app-layout > section > div > div > app-new-registration-license > div.grid > app-grid-action-item > kendo-grid > kendo-pager > kendo-pager-info"),
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

	
	
	
	public static WebElement readTotalItems1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-notices/div/kendo-grid/kendo-pager/kendo-pager-info"));
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
	public static WebElement clickBack()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
		return labour;
	}
	public static WebElement EditBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Edit'])"));
		return labour;
	}
	public static WebElement clickMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[@class='f-label']"));
		return labour;
	}

}
