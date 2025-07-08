package distributor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class LocatorsD extends BasePage {
	
	
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
	public static WebElement DashboardArrow()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//img[@title='Dashboard']"));
		return submit;
	}
	public static WebElement Brows()	//Method for searching button for Save/Sign-in
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
	
	public static WebElement TotalNumberOfItems()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-pager-info[@class='k-pager-info k-label ng-star-inserted'])[1]"));
		return submit;
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
	

}
