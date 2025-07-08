package clientPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class CPLocator extends BasePage {
	
	private static WebElement MyDocument = null;			//WebElement variable created for Username input 
	private static WebElement pass = null;			//WebElement variable created for Password input
	private static WebElement submit = null;		//WebElement variable created for Submit button click
	
	public static WebElement MyDocument()		//Method for searching Username input
	{
		MyDocument = getDriver().findElement(By.xpath("//li[normalize-space(.//span[@class='links-name'])='My Documents']"));
		return MyDocument;
	}
	public static WebElement Entity()		//Method for searching Username input
	{
		MyDocument = getDriver().findElement(By.xpath("(//span[@class='k-input-inner k-readonly'])[1]"));
		return MyDocument;
	}
	public static WebElement EntityExpand()		//Method for searching Username input
	{
		MyDocument = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted']"));
		return MyDocument;
	}
	public static WebElement EntityExpand1()		//Method for searching Username input
	{
		MyDocument = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[2]"));
		return MyDocument;
	}
	
	public static WebElement checkbox()		//Method for searching Username input
	{
		MyDocument = getDriver().findElement(By.xpath("(//input[@class='radio-child'])[2]"));
		return MyDocument;
	}
	public static WebElement checkbox1()		//Method for searching Username input
	{
		MyDocument = getDriver().findElement(By.xpath("(//input[@class='radio-child'])[5]"));
		return MyDocument;
	}
	public static WebElement Applybtn()		//Method for searching Username input
	{
		MyDocument = getDriver().findElement(By.xpath("(//button[@class='figma-btn-white'])[2]"));
		return MyDocument;
	}
	public static WebElement ComplianceDropdown()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//app-dropdown-list[@class='dropdown-setting']"));
		return submit;
	}
	public static WebElement Actfilter()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[.='Select Act']"));
		return submit;
	}
	public static WebElement StaDocument()		//Method for searching Username input
	{
		MyDocument = getDriver().findElement(By.xpath("//span[normalize-space(.)='Statutory Documents']"));
		return MyDocument;
	}
	
	public static WebElement MISDocument()		//Method for searching Username input
	{
		MyDocument = getDriver().findElement(By.xpath("//span[normalize-space(.)='MIS Documents']"));
		return MyDocument;
	}
	
	public static WebElement EmployeeESIC()		//Method for searching Username input
	{
		MyDocument = getDriver().findElement(By.xpath("//span[normalize-space(.)='Employee ESIC']"));
		return MyDocument;
	}
	
	public static WebElement CriticalDocuments()		//Method for searching Username input
	{
		MyDocument = getDriver().findElement(By.xpath("//span[normalize-space(.)='Critical Documents']"));
		return MyDocument;
	}
	public static WebElement CheckBox1()		//Method for searching Username input
	{
		MyDocument = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		return MyDocument;
	}
	public static WebElement CheckBox2()		//Method for searching Username input
	{
		MyDocument = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		return MyDocument;
	}
	public static WebElement CheckBox3()		//Method for searching Username input
	{
		MyDocument = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[4]"));
		return MyDocument;
	}
	public static WebElement Download()		//Method for searching Username input
	{
		MyDocument = getDriver().findElement(By.xpath("//button[normalize-space()='Download']"));
		return MyDocument;
	}
	public static WebElement Year()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[.='Year']"));
		return submit;
	}
	public static WebElement Period()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[.='Period']"));
		return submit;
	}
	
	public static WebElement ClickAct()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return submit;
	}
	public static WebElement branch()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-multiselecttree[@formcontrolname='branches']"));
		return submit;
	}
	public static WebElement Downloads()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//img[@title='Download'])[1]"));
		return submit;
	}
	public static WebElement View()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//img[@title='View'])[1]"));
		return submit;
	}

	public static WebElement Viewed()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("tr[class='k-master-row k-table-row ng-star-inserted'] div[class='ng-star-inserted'] img[title='View']"));
		return submit;
	}
	public static WebElement ClosePopup()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//div[@class='k-window-titlebar-actions k-dialog-titlebar-actions'])[1]"));
		return submit;
	}
	public static WebElement Expand()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[5]"));
		return submit;
	}
	public static WebElement State()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//span[.=' Maharashtra '])[2]"));
		return submit;
	}
	public static WebElement Location()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//span[.=' ANDHERI WEST_Andheriya '])[2]"));
		return submit;
	}
	public static WebElement NewFolder()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@id='menu1']"));
		return submit;
	}
	public static WebElement NewFile()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@id='menu1'])[2]"));
		return submit;
	}
	public static WebElement FolderName()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//div[@class='require-container']/input[@type='text']"));
		return submit;
	}
	public static WebElement Create()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[normalize-space()='Create']"));
		return submit;
	}
	public static WebElement Close()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("button[title='Close']"));
		return submit;
	}
	public static WebElement folder()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("div[title='Labor Doc'] img[alt='Go to sub-folder']"));
		return submit;
	}
	public static WebElement Share()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//img[@class='svg-icon']"));
		return submit;
	}
	public static WebElement PermissionSelect()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'])[2]"));
		return submit;
	}
	public static WebElement PermissionSelectValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']//li[2]"));
		return submit;
	}
	
	public static WebElement SelectUser()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[@class='k-input-inner k-readonly']"));
		return submit;
	}
	public static WebElement Done()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-blue ng-star-inserted']"));
		return submit;
	}
	public static WebElement SelectUserVal()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[8]"));
		return submit;
	}
	
	
	
	
}
