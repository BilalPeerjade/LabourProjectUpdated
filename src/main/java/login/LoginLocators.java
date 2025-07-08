package login;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginLocators extends BasePage {
	private static WebElement uname = null;			//WebElement variable created for Username input 
	private static WebElement pass = null;			//WebElement variable created for Password input
	private static WebElement submit = null;		//WebElement variable created for Submit button click
	
	public static WebElement setUname()		//Method for searching Username input
	{
		uname = getDriver().findElement(By.xpath("//input[@placeholder='Username']"));
		return uname;
	}
	
	public static WebElement setPassword()	//Method for searching Password input
	{
		pass =getDriver().findElement(By.xpath("//input[@placeholder='Password']"));
		return pass;
	}
	
	
	public static WebElement clickSubmit()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.id("Submit"));
		return submit;
	}
	
	public static WebElement Search()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.className("f-textbox"));
		return submit;
	}
	public static WebElement DashboardArrow()
	{
		submit = getDriver().findElement(By.xpath("//img[@title='Dashboard']"));
		return submit;
	}
	
	
	public static WebElement DashboardText()
	{
		submit = getDriver().findElement(By.xpath("//span[@class='dashboard']"));
		return submit;
	}
	public static WebElement Brows()	
	{
		submit = getDriver().findElement(By.xpath("//label[normalize-space()='Browse']"));
		return submit;
	}
	public static WebElement Button()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-blue'])[4]"));
		return submit;
	}
	public static WebElement Upload()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-blue upload-btn']"));
		return submit;
	}
	public static WebElement UploadSuccessfully()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//h4[@class='f-label']"));
		return submit;
	}
	public static WebElement Msg()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//small[@class='text-danger ng-star-inserted']"));
		return submit;
	}
	
	public static WebElement GenerationMsg()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//h4[@class='f-label']"));
		return submit;
	}
	public static WebElement Submit()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-blue']"));
		return submit;
	}
	
	public static WebElement ComplianceRadioButton()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//input[@id='rdFai'])[1]"));
		return submit;
	}
	
	
	public static WebElement PenActnClosePopup()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-x k-button-icon k-svg-icon k-icon ng-star-inserted'])[2]"));
		return submit;
	}
	public static WebElement ClosePopup()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-x k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return submit;
	}
	
	public static WebElement ComplianceBox()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.className("min-card-count"));
		return submit;
	}
	
	public static WebElement UpcomingBox()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(2) > div:nth-child(2) > div > div > div:nth-child(2) > div.min-card-count"));
		return submit;
	}
	
	public static WebElement OverdueBox()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(2) > div:nth-child(3) > div > div > div:nth-child(2) > div.min-card-count"));
		return submit;
	}
	
	public static WebElement PendingActionBox()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(2) > div:nth-child(4) > div > div > div:nth-child(2) > div.min-card-count"));
		return submit;
	}
	public static WebElement PendingActionEdit()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//img[@class='svg-icon ng-star-inserted']"));
		return submit;
	}
	public static WebElement ClosedDelayed()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@id='rdFai']"));
		return submit;
	}
	public static WebElement Calender1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("button[title='Toggle calendar']"));
		return submit;
	}
	public static WebElement CalenderDate()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//td[@class='k-calendar-td k-focus k-today ng-star-inserted']//span"));
		return submit;
	}
	
	public static WebElement Remark()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("textarea[placeholder='Remarks']"));
		return submit;
	}	
	public static WebElement Submitt()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-blue'])[1]"));
		return submit;
	}
	public static WebElement Reject()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-blue'])[2]"));
		return submit;
	}
	public static WebElement Closebtn()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-blue'])[3]"));
		return submit;
	}
	public static WebElement PendingReviewBox()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(2) > div:nth-child(5) > div > div > div:nth-child(2) > div.min-card-count"));
		return submit;
	}
	public static WebElement RegisterUpcoming()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)"));
		return submit;
	}
	public static WebElement RegisterOverdue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2)"));
		return submit;
	}
	public static WebElement RegisterActionReview()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2)"));
		return submit;
	}
	public static WebElement ReturnUpcoming()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)"));
		return submit;
	}
	public static WebElement ReturnOverdue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2)"));
		return submit;
	}
	
	public static WebElement ReturnActionReview()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2)"));
		return submit;
	}
	public static WebElement ChallanUpcoming()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)"));
		return submit;
	}
	public static WebElement ChallanOverdue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2)"));
		return submit;
	}
	public static WebElement ChallanActionReview()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2)"));
		return submit;
	}
	
/*	public static WebElement TotalNumberOfItems()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-pager-info[@class='k-pager-info k-label ng-star-inserted'])[1]"));
		return submit;
	} */
	
	public static WebElement TotalNumberOfItems() {
	    List<By> locators = Arrays.asList(
	        By.xpath("(//kendo-pager-info[@class='k-pager-info k-label ng-star-inserted'])[1]"),
	        By.xpath("//kendo-pager-info[@class='k-pager-info k-label']"),
	        By.cssSelector(""),
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
	
	
	
	public static WebElement TotalNumberOfItem()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-pager-info[@class='k-pager-info k-label']"));
		return submit;
	}
	
	public static WebElement Export()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.className("exportbtn"));
		return submit;
	}
	public static WebElement Overview()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.className("svg-icon"));
		return submit;
	}
	
	public static WebElement CloseDocument()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@title='Close'])[2]"));
		return submit;
	}
	public static WebElement CloseX()
	{
		submit = getDriver().findElement(By.xpath("(//button[@title='Close'])"));
		return submit;
	}
	public static WebElement SelectBranch()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[@class='k-input-value-text ng-star-inserted']"));
		return submit;
	}
	public static WebElement Period()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@class='k-input-inner']"));
		return submit;
	}
	public static WebElement SelectYear()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-dropdownlist[@class='f-textbox k-picker-md k-rounded-md k-picker-solid k-dropdownlist k-picker'])[3]"));
		return submit;
	}
	public static WebElement SelectYearvalue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return submit;
	}
	
	public static WebElement PeriodValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[.='January']"));
		return submit;
	}
	public static WebElement July24()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[.='July']"));
		return submit;
	}
	public static WebElement ClosePopUp()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > app-dashboard-compliance-popup > kendo-dialog > div.k-window.k-dialog.ng-tns-c1063677181-1 > kendo-dialog-titlebar > div > button > kendo-icon-wrapper > kendo-svgicon"));
		return submit;
	}
	public static WebElement Close()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='k-window-titlebar-action k-dialog-titlebar-action k-button k-icon-button k-button-md k-rounded-md k-button-flat-base k-button-flat']"));
		return submit;
	}
	
	
	public static WebElement CloseBranchCode()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//div[@class='k-window-titlebar-actions k-dialog-titlebar-actions'])[2]"));
		return submit;
	}	
	
	public static WebElement ClosePopUp1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > app-risk-summary-popup > kendo-dialog > div.k-window.k-dialog.ng-tns-c1063677181-1 > kendo-dialog-titlebar > div > button > kendo-icon-wrapper > kendo-svgicon"));
		return submit;
	}
	
	public static WebElement ClosePopUp2()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector(".k-svg-i-x.k-button-icon.k-svg-icon.k-icon.ng-star-inserted"));
		return submit;
	}
	public static WebElement ClosePopUp3()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//div[@class='k-window-titlebar-actions k-dialog-titlebar-actions'])[3]"));
		return submit;
	}
	
	
	
	public static WebElement ExpandAllclick()	//Bilal
	{
		submit = getDriver().findElement(By.xpath("//span[@id='0']"));
		return submit;
	}
	public static WebElement ExpandBranch()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[5]"));
		return submit;
	}
	public static WebElement ExpandBranchSecond()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[2]"));
		return submit;
	}
	public static WebElement ExpandB()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[3]"));
		return submit;
	}
	
	
	public static WebElement ExpandBranchh()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[1]"));
		return submit;
	}
	
	
	public static WebElement ExpandBranchnew()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[2]"));
		return submit;
	}
	public static WebElement ExpandBranchn()	//ExpandBranchh
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[4]"));
		return submit;
	}
	public static WebElement ExpandBranchnew1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[4]"));
		return submit;
	}
	public static WebElement ExpandBranch1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[2]"));
		return submit;
	}
	
	public static WebElement Branchvalue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//span[.=' Gujarat_Branch Gujarat '])[1]"));
		return submit;
	}
	public static WebElement Branchvalues()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//span[.=' Pune_tcs in hinjewadi '])[1]"));
		return submit;
	}
	public static WebElement Branchvaluen()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//span[.=' Jayanagar III Block_TTTT '])[1]"));
		return submit;
	}
	public static WebElement BranchvalueCheckbox()	
	{
		submit = getDriver().findElement(By.xpath("//span[contains(text(),'Mohali')]"));
		return submit;
	}
	public static WebElement Branchvalue3()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[contains(text(),'Mohali_Branch Punjab')]"));
		return submit;
	}
	public static WebElement Branchval()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//span[.=' guntur_ooooooooo '])[1]"));
		return submit;
	}
	
	public static WebElement Branchvalue1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//span[.=' Pune_Branch Pune '])[1]"));
		return submit;
	}
	public static WebElement BranchPune_BranchPune()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//span[.=' pune_Branch Pune '])[1]"));
		return submit;
	}
	
	public static WebElement ActFilter()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return submit;
	}
	public static WebElement ActFilterValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']//li[2]"));
		return submit;
	}
	
	
	
	public static WebElement ApplyButton()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-white']"));
		return submit;
	}
	
	public static WebElement ClearButton()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-white'])[2]"));
		return submit;
	}
	public static WebElement Clear()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@title='Clear']"));
		return submit;
	}
	public static WebElement SelectPeriodDashboard()
	{
		submit = getDriver().findElement(By.xpath("//span[@class='k-input-inner']"));
		return submit;
	} 
	
	
/*	public static WebElement SelectPeriodDashboard() {
	    submit = getDriver().findElement(By.className("//span[@class='k-input-inner']"));
	    return submit;
	} */

	
	
	public static WebElement Entity_ExcelFile()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[normalize-space()='Entity Master']"));
		return submit;
	}
	public static WebElement EntityLocation_ExcelFile()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[normalize-space()='Entity Location']"));
		return submit;
	}
	public static WebElement SelectPeriodValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[.='2024']"));
		return submit;
	}
	public static WebElement SelectPeriodValue1()	//CC
	{
		submit = getDriver().findElement(By.xpath("//span[.='2025']"));
		return submit;
	}
	public static WebElement SelectPeriodValue2024()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[.='2024']"));
		return submit;
	}
	public static WebElement CompHighRisk()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(16) > text"));
		return submit;
	}
	
	public static WebElement CompMediumRisk()	//Method for searching button for Save/Sign-inaa
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(22) > text"));
		return submit;
	}
	public static WebElement CompLowRisk()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(22) > text"));
		return submit;
	}
/*	public static WebElement HighRiskNonComplied()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(18) > text"));
		return submit;
	} */
	
	public static WebElement HighRisk()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(18) > text"));
		return submit;
	}
	
	
	public static WebElement MediumRisk()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(21) > text"));
		return submit;
	}
	public static WebElement LowRisk()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(24) > text"));
		return submit;
	}
	public static WebElement Dashboard()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='nav-links']/li[2]"));
		return submit;
	}
	
	public static WebElement NotComplied()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//*[name()='g'][@role='graphics-symbol'])[2]"));
		return submit;
	}
	public static WebElement BrachCode()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-white']"));
		return submit;
	}
	public static WebElement type()	
	{
		submit = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'])[5]"));
		return submit;
	}
	public static WebElement BranchCodetype()	
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='Type']"));
		return submit;
	}
	public static WebElement typeValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return submit;
	}
	public static WebElement typeValueEPF()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[3]"));
		return submit;
	}
	public static WebElement SelectValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//span[@class='k-input-inner'])[6]"));
		return submit;
	}
	public static WebElement SelectValueDropdown()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return submit;
	}
	public static WebElement ApplyBtn()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-white apply-btn'])[2]"));
		return submit;
	}
	public static WebElement BranchCodeClearBtn()
	{
		submit = getDriver().findElement(By.xpath("(//button[@title='Clear'])[2]"));
		return submit;
	}
	public static WebElement ApplyBtn1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-white apply-btn']"));
		return submit;
	}
	public static WebElement ApplyBtn2()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("img[src='../assets/vectors/ApplyFilter.svg']"));
		return submit;
	}
	
	public static WebElement ClearBtn()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-white clear-btn'])[2]"));
		return submit;
	}
	public static WebElement displayedrecord()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("#k-2df46ae9-4b4b-4792-9676-73d95f9ffe2e > kendo-grid-list > div > div.k-grid-table-wrap > table > tbody > tr > td:nth-child(2) > div"));
		return submit;
	}
	public static WebElement CompliedCount()//Complied green ka count ka xpath lena hai ye
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(1) > div > app-cd-performance-summary > div > div > div:nth-child(2) > div.status-card.complied > div.status-text > h2"));
		return submit;
	}
	public static WebElement CompliedCount1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//*[local-name()='svg']//*[name()='g' and @class='k-chart-point']//*[name()='path' and @fill='#FA6462']"));
		return submit;
	}
	public static WebElement Download()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button//img[@class='svg-icon ng-star-inserted']"));
		return submit;
	}
	public static WebElement SampleEmployeeDocument()
	{
		submit = getDriver().findElement(By.xpath("(//a[contains(text(),'Sample Document')])[1]"));
		return submit;
	}
	public static WebElement SampleFamilyDetails()	
	{
		submit = getDriver().findElement(By.xpath("(//a[contains(text(),'Sample Document')])[2]"));
		return submit;
	}
	public static WebElement Validation_Upload1()	
	{
		submit = getDriver().findElement(By.xpath("(//button[@title='Upload'])[1]"));
		return submit;
	}
	public static WebElement Validation_Upload2()	
	{
		submit = getDriver().findElement(By.xpath("(//button[@title='Upload'])[2]"));
		return submit;
	}
	public static WebElement Validation_Upload3()	
	{
		submit = getDriver().findElement(By.xpath("(//button[@title='Upload'])[3]"));
		return submit;
	}
	public static WebElement OK()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-green'])[1]"));
		return submit;
	}
	public static WebElement MessageDisplayed()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//h4[normalize-space()='File Not Found'])[1]"));
		return submit;
	}
	public static WebElement MessageDisplayed1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//h4[@class='f-label'])[1]"));
		return submit;
	}
	
	public static WebElement Complied()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//*[local-name()='svg']//*[name()='g' and @class='k-chart-point']"));
		return submit;
	}
	public static WebElement NotCompliede()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("div[class='card'] app-cd-performance-summary div div div div[class='status-card not-complied'] h2"));
		return submit;
	}
	public static WebElement RedColor()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//div/div[@class='status-color'])[1]"));
		return submit;
	}
	
	public static WebElement ApplicableStatues()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//h4[@class='Applicable-head']"));
		return submit;
	}
	public static WebElement Applicablestatus()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(5) > div:nth-child(2) > div > app-cd-applicable-status > ul > li:nth-child(2) > div"));
		return submit;
	}
	public static WebElement DailyUpdateHeader()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//h4[@class='Updates-head']"));
		return submit;
	}
	public static WebElement DailyUpdate()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(6) > div > div > app-cd-daily-updates > div > div.carousel-container > div > div > div:nth-child(3) > h3"));
		return submit;
	}
	public static WebElement DailyUpdateReadMoreLink()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//a[@class='read-more'])"));
		return submit;
	}
	public static WebElement Branch()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-multiselecttree[@class='f-textbox multi-box custom-multiselect k-input-md k-rounded-md k-input-solid k-multiselecttree k-input']"));
		return submit;
	}
	public static WebElement Branch1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-multiselecttree[@class='f-textbox k-input-md k-rounded-md k-input-solid k-multiselecttree k-input']"));
		return submit;
	}
	public static WebElement Branch2()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-multiselecttree[@class='f-textbox multi-box custom-multiselect-other k-input-md k-rounded-md k-input-solid k-multiselecttree k-input']"));
		return submit;
	}
	
	
	public static WebElement BranchValue()
	{
		submit = getDriver().findElement(By.xpath("(//input[@class='k-checkbox k-checkbox-md k-rounded-md'])[6]"));
		return submit;
	}
	public static WebElement BranchCheckBox()
	{
		submit = getDriver().findElement(By.xpath("//input[@type='checkbox']"));
		return submit;
	}
	public static WebElement Report()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='nav-links']//li//div//a//div//span[.='My Reports']"));
		return submit;
	}
	public static WebElement MyDocument()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='nav-links']//li//div//a//div//span[.='My Documents']"));
		return submit;
	}
	public static WebElement RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='Regulatory Abstracts']"));
		return submit;
	}
	public static WebElement Upload_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("//button[normalize-space()='Upload']"));
		return submit;
	}
	public static WebElement SelectState_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("//span[contains(text(),'Select State')]"));
		return submit;
	}
	public static WebElement SelectAct_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("//span[contains(text(),'Select Act')]"));
		return submit;
	}
	
	public static WebElement SelectState2_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("(//span[contains(text(),'Select State')])[2]"));
		return submit;
	}
	public static WebElement SelectAct2_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("(//span[contains(text(),'Select Act')])[2]"));
		return submit;
	}
	public static WebElement RegionalDownload_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("(//img[@title='Download'])[1]"));
		return submit;
	}
	public static WebElement RegionalView_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("(//img[@title='View'])[1]"));
		return submit;
	}
	public static WebElement EnglishDownload_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("(//img[@title='Download'])[2]"));
		return submit;
	}
	public static WebElement EnglishView_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("(//img[@title='View'])[2]"));
		return submit;
	}
	public static WebElement AckDownload_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("(//img[@title='Download'])[3]"));
		return submit;
	}
	public static WebElement AckView_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("(//img[@title='View'])[3]"));
		return submit;
	}
	
	public static WebElement SelectBranch_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("//span[contains(text(),'Select Branch')]"));
		return submit;
	}
	public static WebElement SelectDisplayType_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("//span[contains(text(),'Select Display Type')]"));
		return submit;
	}
	public static WebElement SelectHardCopyCheckBox_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("(//input[@id='rdUpd'])"));
		return submit;
	}
	public static WebElement CourierNo_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("//input[@placeholder='Enter numbers only']"));
		return submit;
	}
	public static WebElement SelectDispatch_RegulatoryAbstracts()
	{
		submit = getDriver().findElement(By.xpath("//span[contains(text(),'Select Dispatch Type')]"));
		return submit;
	}
	public static WebElement Select1st_RegulatoryAbstracts() //Here need to give common value 
	{
		submit = getDriver().findElement(By.xpath("//span[@class='k-list-item-text']"));
		return submit;
	}
	public static WebElement Select1stValueInUpload_RegulatoryAbstracts() //This xpath is after clicking on upload for first value
	{
		submit = getDriver().findElement(By.xpath("//li[@class='k-list-item k-focus ng-star-inserted']"));
		return submit;
	}
	public static WebElement Save_RegulatoryAbstracts() //This xpath is after clicking on upload for first value
	{
		submit = getDriver().findElement(By.xpath("//button[normalize-space()='Save']"));
		return submit;
	}
	public static WebElement Exportbtn()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='exportbtn']"));
		return submit;
	}
	public static WebElement TotalNoOfItem()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-pager-info[@class='k-pager-info k-label'])[1]"));
		return submit;
	}
	public static WebElement Grid()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//app-compliance-assignment-report[@class='ng-star-inserted']"));
		return submit;
	}
	public static WebElement StatusReport()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='nav nav-tabs']//li[2]"));
		return submit;
	}
	public static WebElement VariousReport()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='nav nav-tabs']//li[3]"));
		return submit;
	}
	public static WebElement CLRAAssignReport()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='nav nav-tabs']//li[4]"));
		return submit;
	}
	public static WebElement Clearbtn1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-white clear-btn']"));
		return submit;
	}
	
	public static WebElement Monthly()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-dropdownlist[@class='f-textbox k-picker-md k-rounded-md k-picker-solid k-dropdownlist k-picker']"));
		return submit;
	}
	public static WebElement ComplianceType()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-dropdownlist[@class='f-textbox k-picker-md k-rounded-md k-picker-solid k-dropdownlist k-picker']"));
		return submit;
	}
	public static WebElement SelectValuetype()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[1]"));
		return submit;
	}
	public static WebElement selecttype()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-dropdownlist[@class='f-textbox k-picker-md k-rounded-md k-picker-solid k-dropdownlist k-picker']"));
		return submit;
	}
	public static WebElement MonthlyValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[1]"));
		return submit;
	}
	public static WebElement MonthlyValue2()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return submit;
	}
	
	public static WebElement TypeValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[1]"));
		return submit;
	}
	
	public static WebElement Year()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//input[@class='k-input-inner'])[1]"));
		return submit;
	}
	public static WebElement Yearvalue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li/input"));
		return submit;
	}
	
	public static WebElement period()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//input[@class='k-input-inner'])[2]"));
		return submit;
	}
	public static WebElement periodvalue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//input[@class='k-input-inner'])[2]"));
		return submit;
	}
	public static WebElement Status()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//input[@class='k-input-inner'])[3]"));
		return submit;
	}
	
	public static WebElement VariousType()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-dropdownlist[@class='f-textbox k-picker-md k-rounded-md k-picker-solid k-dropdownlist k-picker']"));
		return submit;
	}
	public static WebElement VariousTypeValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[1]"));
		return submit;
	}
	public static WebElement Calender()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return submit;
	}
	public static WebElement Calenderyear()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-reset']/li[7]"));
		return submit;
	}
	
	public static WebElement CalenderMonth()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//td[@class='k-calendar-td ng-star-inserted k-focus']/span"));
		return submit;
	}
	public static WebElement WorkspaceArrow()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//img[@class='svg-icon'])[3]"));
		return submit;
	}
	public static WebElement StatutoryDocumentArroww()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//img[@title='Statutory Document'])[1]"));
		return submit;
	}
	public static WebElement View()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//img[@class='svg-icon']"));
		return submit;
	}
	public static WebElement ViewButton()
	{
		submit = getDriver().findElement(By.xpath("//img[@title='View']"));
		return submit;
	}
	public static WebElement ViewDocument()	//means on clicking to view btn - File popup is opened in that view document xpath is there
	{
		submit = getDriver().findElement(By.xpath("//img[@alt='View Document']"));
		return submit;
	}
	public static WebElement ComplianceDropdown()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[contains(text(),'Select Compliance')]"));
		return submit;
	}
	public static WebElement Frequency()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])[2]"));
		return submit;
	}
	public static WebElement FrequencyDropdown()	
	{
		submit = getDriver().findElement(By.xpath("//app-dropdown-list[@formcontrolname='frequency']"));
		return submit;
	}
	public static WebElement FrequencyMonthly()	
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='Monthly']"));
		return submit;
	}
	public static WebElement FrequencyQuarterly()	
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='Quarterly']"));
		return submit;
	}
	public static WebElement FrequencyHalfYearly()	
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='Half Yearly']"));
		return submit;
	}
	public static WebElement FrequencyAnnual()	
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='Annual']"));
		return submit;
	}
	public static WebElement FrequencyBiAnnual()	
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='BiAnnual']"));
		return submit;
	}
	public static WebElement ClickRegister()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li/span[.='Register']"));
		return submit;
	}
	public static WebElement ClickRegisterDrp()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='Register']"));
		return submit;
	}
	public static WebElement SelectReturnn()	
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='Return']"));
		return submit;
	}
	public static WebElement SelectChallan()
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='Challan']"));
		return submit;
	}
	public static WebElement SelectChallanEPF()	
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='Employee Provident Fund Act']"));
		return submit;
	}
	public static WebElement SelectRegisterSEA()	
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='Shops and Establishment and Allied Acts']"));
		return submit;
	}
	public static WebElement SelectActDropdown()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])[3]"));
		return submit;
	}
	public static WebElement Act()	
	{
		submit = getDriver().findElement(By.xpath("//span[contains(text(),'Select Act')]"));
		return submit;
	}
/*	public static WebElement UniqueValues()	//This is Unique Identifier of dropdowns
	{
		submit = getDriver().findElement(By.xpath("//span[@class='k-list-item-text']"));
		return submit;
	} */
	public static By UniqueValues() //This is Unique Identifier of dropdowns
	{
	    return By.xpath("//span[@class='k-list-item-text']");
	}

	public static WebElement ActPaymentOfBonus1965()	
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='Payment of Bonus Act, 1965']"));
		return submit;
	}
	public static WebElement YearDropdown()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])[4]"));
		return submit;
	}
	public static WebElement YearDrp()	//Bilal
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])[4]"));
		return submit;
	}
	public static WebElement SelectYearDropdown()	//Bilal
	{
		submit = getDriver().findElement(By.xpath("//span[contains(text(),'Select Year')]"));
		return submit;
	}
	public static WebElement Year2024()	//Bilal
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='2024']"));
		return submit;
	}
	public static WebElement PeriodDropdown()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])[5]"));
		return submit;
	}
	public static WebElement PeriodDrp()
	{
		submit = getDriver().findElement(By.xpath("//span[contains(text(),'Select Period')]"));
		return submit;
	}
	public static WebElement PeriodJan()	
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='January']"));
		return submit;
	}
	public static WebElement PeriodJune()	
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='June']"));
		return submit;
	}
	public static WebElement PeriodAnnual()	//Period Dropdown Annul Value
	{
		submit = getDriver().findElement(By.xpath("//span[@class='k-list-item-text']"));
		return submit;
	}
	public static WebElement NoRecordsAvailable()	
	{
		submit = getDriver().findElement(By.xpath("//div[@class='k-grid-norecords-template ng-star-inserted']"));
		return submit;
	}
	public static WebElement ClickAct()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[1]"));
		return submit;
	}
	
	public static WebElement ClickPeriod()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[1]"));
		return submit;
	}
	public static WebElement ClickPeriod1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[13]"));
		return submit;
	}
	
	
	
	public static WebElement Clickyear()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return submit;
	}
	public static WebElement Clickyear1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[1]"));
		return submit;
	}
	public static WebElement AllFile()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//span[@class='k-input-inner k-readonly'])[1]"));
		return submit;
	}
	
	public static WebElement SelectAllCheckbox()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//span[.=' Select All '])[1]"));
		return submit;
	}
	public static WebElement branch()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//span[@class='k-input-inner k-readonly'])[2]"));
		return submit;
	}
	public static WebElement branchvalue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[5]"));
		return submit;
	}
	public static WebElement branchvalue4()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@class='k-checkbox k-checkbox-md k-rounded-md']"));
		return submit;
	}
	
	public static WebElement CheckBox()	//Select Check Box before proceed button
	{
		submit = getDriver().findElement(By.xpath("//input[@type='checkbox']"));
		return submit;
	}
	public static WebElement Proceed()	//Proceed to workspace
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-blue']"));
		return submit;
	}
	public static WebElement Back()
	{
		submit = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
		return submit;
	}
	public static WebElement BrowseFile()
	{
		submit = getDriver().findElement(By.xpath("//button[@title='Browse']"));
		return submit;
	}
	public static WebElement UploadFile()
	{
		submit = getDriver().findElement(By.xpath("//button[normalize-space()='Upload']"));
		return submit;
	}
	public static WebElement GetMessageText()
	{
		submit = getDriver().findElement(By.xpath("//h4[@class='f-label']"));
		return submit;
	}
	public static WebElement ClickOK()
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='OK']"));
		return submit;
	}
	
	public static WebElement AttendaceText()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//*[contains(normalize-space(text()), 'Attendance')]"));
		return submit;
	}
	
	public static WebElement SalaryText()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//*[contains(normalize-space(text()), 'Salary')]"));
		return submit;
	}
	public static WebElement LeaveSummaryText()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//*[contains(normalize-space(text()), 'Leave Summary Details')]"));
		return submit;
	}
	public static WebElement Attendance()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']//td"));
		return submit;
	}
	public static WebElement AttendanceTemplate()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']//td/following-sibling::td"));
		return submit;
	}
	public static WebElement Browse()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']//td/following-sibling::td/following-sibling::td"));
		return submit;
	}
	public static WebElement Uploads()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']//td/following-sibling::td/following-sibling::td//button[@class='figma-btn-blue']"));
		return submit;
	}
	
	public static WebElement UploadedGreenTick()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']//td/following-sibling::td/following-sibling::td/following-sibling::td"));
		return submit;
	}
	public static WebElement ValidatedGreenTick()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']//td/following-sibling::td[1]/following-sibling::td/following-sibling::td/following-sibling::td"));
		return submit;
	}
	public static WebElement ProcessedGreenTick()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']//td/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td[1]/following-sibling::td"));
		return submit;
	}
	public static WebElement Refresh()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-white'])[2]"));
		return submit;
	}
	public static WebElement RefreshBtn()	
	{
		submit = getDriver().findElement(By.xpath("//button[@title='Refresh']"));
		return submit;
	}
	public static WebElement ErrorFileDownload()	
	{
		submit = getDriver().findElement(By.xpath("//img[@title='Error']"));
		return submit;
	}
	public static WebElement lock()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/sandclock.svg']"));
		return submit;
	}
	
	
	
	
	public static WebElement Check()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-white marginleft']"));
		return submit;
	}
	public static WebElement GenerateDocument()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[normalize-space()='Generate Documents']"));
		return submit;
	}
	
	public static WebElement History()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']//tr[1]//td/following-sibling::td[6]"));
		return submit;
	}
	public static WebElement successfilehistory()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button/img[@class='svg-icon ng-star-inserted']"));
		return submit;
	}
	
	public static WebElement close()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@title='Close']"));
		return submit;
	}
	
	public static WebElement frequency()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-dropdownlist[@class='f-textbox k-picker-md k-rounded-md k-picker-solid k-dropdownlist k-picker disabled k-disabled'] | (//kendo-dropdownlist[@class='f-textbox k-picker-md k-rounded-md k-picker-solid k-dropdownlist k-picker'])[2]"));
		return submit;
	}
	
	public static WebElement ClickReturn()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li/span[.='Return']"));
		return submit;
	}
	public static WebElement Clickchallan()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li/span[.='Challan']"));
		return submit;
	}
	public static WebElement FrequencyValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return submit;
	}
	public static WebElement ECRMasterTab()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//a[normalize-space()='ECR Master']"));
		return submit;
	}
	public static WebElement ECRConfirmation()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='nav nav-tabs']//li[3]"));
		return submit;
	}
	
	public static WebElement ClientTextId()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//td[@class='k-table-td k-touch-action-auto']/div"));
		return submit;
	}
	public static WebElement searchuserid()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@placeholder='Search User ID']"));
		return submit;
	}	
	public static WebElement searchuseridDD()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//div[@class='k-list-content']//ul//li[1]"));
		return submit;
	}
	public static WebElement AddNew()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-blue']"));
		return submit;
	}
	public static WebElement AddNewBtn()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@title='Add New']"));
		return submit;
	}
	public static WebElement AddNewPopupESIC_SubcodeMaster()
	{
		submit = getDriver().findElement(By.xpath("//span[@class='k-window-title k-dialog-title']"));
		return submit;
	}
	public static WebElement ClientID()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("input[placeholder='Client ID']"));
		return submit;
	}
	public static WebElement UserID()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@class='f-textbox form-control ng-untouched ng-pristine ng-invalid']"));
		return submit;
	}
	public static WebElement password()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@id='password']"));
		return submit;
	}
	public static WebElement Save()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-blue figma-popup ng-star-inserted']"));
		return submit;
	}
	public static WebElement CloseAddnewpopup()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-x k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return submit;
	}
	public static WebElement BulkUpload()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-blue upload-btn']"));
		return submit;
	}
	public static WebElement SampleDocument()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//a[@id='btnSampleRLCS']"));
		return submit;
	}	
	public static WebElement Uploadbtn()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[normalize-space()='Upload']"));
		return submit;
	}
	
	public static WebElement Edit()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//img[@title='Edit'])[1]"));
		return submit;
	}
	public static WebElement edit()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//img[@title='edit'])[1]"));
		return submit;
	}
	public static WebElement Delete1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//img[@title='Delete'])[1]"));
		return submit;
	}
	public static WebElement Delete2()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//img[@title='Delete'])[2]"));
		return submit;
	}
	public static WebElement Delete3()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//img[@title='Delete'])[3]"));
		return submit;
	}
	
	public static WebElement ClickBrowse()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-gray']"));
		return submit;
	}
	public static WebElement GridValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(1)"));
		return submit;
	}
	public static WebElement id()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(1)"));
		return submit;
	}
	
	public static WebElement GridValue1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(2)"));
		return submit;
	}
	public static WebElement ESICCards()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='nav-links']/li[9]"));
		return submit;
	}
	
	public static WebElement UserId()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("input[placeholder='Enter User ID']"));
		return submit;
	}
	
	public static WebElement DispensaryMaster()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='nav nav-tabs']//li[2]"));
		return submit;
	}
	public static WebElement ESICInputs()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='nav nav-tabs']//li[3]"));
		return submit;
	}
	public static WebElement CheckBox_Updation()	//ESIC Updation checkbox
	{
		submit = getDriver().findElement(By.xpath("(//input[@class='radio-row-input'])[2]"));
		return submit;
	}
	public static WebElement CheckBox_Downloads() //ESIC Download check box
	{
		submit = getDriver().findElement(By.xpath("(//input[@class='radio-row-input'])[3]"));
		return submit;
	}
	public static WebElement CheckBox_Failed() //ESIC Failed check box
	{
		submit = getDriver().findElement(By.xpath("(//input[@class='radio-row-input'])[4]"));
		return submit;
	}
	public static WebElement ESICReport()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='nav nav-tabs']//li[4]"));
		return submit;
	}
	public static WebElement searchStatedropdown()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@placeholder='Search State/Select State']"));
		return submit;
	}
	
	public static WebElement ClickState()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li//span[.='Maharashtra']"));
		return submit;
	}
	
	public static WebElement districtName()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@formcontrolname='districtName']"));
		return submit;
	}
	public static WebElement dispenceryName()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@id='dispenceryName']"));
		return submit;
	}
	public static WebElement Serach()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("input[placeholder='Type to Search']"));
		return submit;
	}
	public static WebElement EmployeeSampleSheet()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//a[@download='ESIC_GenerationEmployeeUpload.xlsx']"));
		return submit;
	}
	
	public static WebElement FamilyDetailsSample()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//a[@download='ESIC_GenerationFamilyDetails.xlsx']"));
		return submit;
	}
	
	public static WebElement SelectReportType()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//app-dropdown-list[@valuefield='id']"));
		return submit;
	}
	public static WebElement SelectType()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//app-dropdown-list[@valuefield='id'])[2]"));
		return submit;
	}
	public static WebElement SelectActivity()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[1]"));
		return submit;
	}
	public static WebElement ActivityValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return submit;
	}
	public static WebElement SelectState()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[2]"));
		return submit;
	}
	public static WebElement StateValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return submit;
	}
	public static WebElement Location()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[3]"));
		return submit;
	}
	public static WebElement LocationValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return submit;
	}
	public static WebElement ClickBranch()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[4]"));
		return submit;
	}
	public static WebElement ClickBranchValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return submit;
	}
	public static WebElement RegistrationType()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[5]"));
		return submit;
	}
	public static WebElement RegistrationTypeValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return submit;
	}
	public static WebElement rcnumber()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@formcontrolname='rcNumber']"));
		return submit;
	}
	public static WebElement checkbox()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@id='new']"));
		return submit;
	}
	public static WebElement SaveDocument()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-blue figma-popup custom-btn']"));
		return submit;
	}
	public static WebElement chooseFile()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[normalize-space()='Browse']"));
		return submit;
	}
	
	public static WebElement Select()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'])[2]"));
		return submit;
	}
	public static WebElement SelectEntityvalue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'])[2]"));
		return submit;
	}
	public static WebElement Consolidated()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-blue custom-btn'])[1]"));
		return submit;
	}
	public static WebElement Expired()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-blue custom-btn'])[2]"));
		return submit;
	}
	public static WebElement CloseToExpired()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-blue custom-btn'])[3]"));
		return submit;
	}
	public static WebElement DigitalSignatureTab()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='nav nav-tabs']//li[2]"));
		return submit;
	}
	public static WebElement AddNewDS()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-blue add-new']"));
		return submit;
	}
	public static WebElement AuthorisedPerId()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@formcontrolname='authorisedPersonId']"));
		return submit;
	}
	public static WebElement AuthorisedPer()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@formcontrolname='authorisedPerson']"));
		return submit;
	}
	public static WebElement designation()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@formcontrolname='designation']"));
		return submit;
	}
	public static WebElement mobileNo()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@formcontrolname='mobile']"));
		return submit;
	}
	public static WebElement EffectiveFrom()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@aria-label='Toggle calendar']"));
		return submit;
	}
	public static WebElement EffectiveFromDate()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[.='1']"));
		return submit;
	}
	public static WebElement EffectiveTo()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@aria-label='Toggle calendar'])[2]"));
		return submit;
	}
	public static WebElement EffectiveToDate()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[.='28']"));
		return submit;
	}
	public static WebElement Browes()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//label[normalize-space()='Browse']"));
		return submit;
	}
	public static WebElement Browes1_ESIC()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@title='Browse'])[1]"));
		return submit;
	}
	public static WebElement Browes2_ESIC()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@title='Browse'])[2]"));
		return submit;
	}
	public static WebElement Browes3_ESIC()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@title='Browse'])[3]"));
		return submit;
	}
	public static WebElement NoFileChosenTXT1()	
	{
		submit = getDriver().findElement(By.xpath("(//div[@class='file-display d-flex align-items-center'])[1]"));
		return submit;
	}
	public static WebElement NoFileChosenTXT2()	
	{
		submit = getDriver().findElement(By.xpath("(//div[@class='file-display d-flex align-items-center'])[2]"));
		return submit;
	}
	public static WebElement NoFileChosenTXT3()	
	{
		submit = getDriver().findElement(By.xpath("(//div[@class='file-display d-flex align-items-center'])[3]"));
		return submit;
	}
	public static WebElement Remaark()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//textarea[@formcontrolname='remark']"));
		return submit;
	}
	public static WebElement StatusDropDown()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//app-dropdown-list[@textfield='text']"));
		return submit;
	}
	public static WebElement StatusValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return submit;
	}
	public static WebElement MsgDisp()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//h4[@class='f-label'])[3]"));
		return submit;
	}
	public static WebElement Search1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@class='f-textbox']"));
		return submit;
	}
	public static WebElement RegulatoryAbstract()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='Regulatory Abstracts']"));
		return submit;
	}
	
	public static WebElement SelState()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("span[id='k-38e3363f-5dcf-46fb-953c-bae976d6069f'] span[class='k-input-value-text']"));
		return submit;
	}
	public static WebElement SelStateval()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[1]"));
		return submit;
	}
	public static WebElement SelAct()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("span[id='k-10a910f1-1ca3-4087-8d47-4db40b0fe51e'] span[class='k-input-value-text']"));
		return submit;
	}
	public static WebElement SelBranch()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("span[id='k-79b098b9-7ee3-444a-ae99-6163b0a7b3a0'] span[class='k-input-value-text']"));
		return submit;
	}
	public static WebElement DisplayedType()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("span[id='k-4fd3098e-f431-4962-b074-7f8870ff5712'] span[class='k-input-value-text']"));
		return submit;
	}
	
	
	//-----------
	public static WebElement clickQALink()	//Do Not Have OTP
	{
		submit = getDriver().findElement(By.xpath("//a[@id='lnkSecurityQA']"));
		return submit;
	}
	public static WebElement Question1()	//Do Not Have OTP
	{
		submit = getDriver().findElement(By.xpath("//span[@id='lblQuestion1']"));
		return submit;
	}
	public static WebElement Question2()	//Do Not Have OTP
	{
		submit = getDriver().findElement(By.xpath("//span[@id='lblQuestion2']"));
		return submit;
	}
	public static WebElement Answer1()		//Method for searching input box of first answer
	{
		submit = getDriver().findElement(By.xpath("//input[@name='txtAnswer1']"));
		return submit;
	}
	
	public static WebElement Answer2()		//Method for searching input box of second answer
	{
		submit = getDriver().findElement(By.xpath("//input[@name='txtAnswar2']"));
		return submit;
	}
	public static WebElement SubmitAnswer()	//Do Not Have OTP
	{
		submit = getDriver().findElement(By.xpath("//input[@value='Validate']"));
		return submit;
	}
	public static WebElement LabourComplianceProject()	//Do Not Have OTP
	{
		submit = getDriver().findElement(By.xpath("//span[normalize-space()='Labour Compliance']"));
		return submit;
	}
	
	
	
	public static WebElement goToNextPage() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//button[@title='Go to the next page']"),
	        By.xpath("//button[@class='k-pager-nav k-button k-icon-button k-button-md k-button-flat-base k-button-flat']"),
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
	
	public static WebElement goToPreviousPage() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//button[@title='Go to the previous page']"),
	        By.xpath("//button[@title='Go to the previous page']//kendo-icon-wrapper[@class='k-icon-wrapper-host']"),
	        By.xpath("//button[@class='k-pager-nav k-button k-icon-button k-button-md k-button-flat-base k-button-flat']")     );

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
	
	public static WebElement profileButtonLogout() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//img[@src='../assets/vectors/Profile.svg']"),
	        By.xpath("//span[@title='Vaibhav performer']"),
	        By.xpath("//i[@class='fa fa-solid fa-caret-down toggle-Profile']")     );

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
	
	
	
	
	
	
	
}
