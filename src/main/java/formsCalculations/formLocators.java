package formsCalculations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import login.BasePage;


public class formLocators extends BasePage {

	private static WebElement labour = null;
	private static WebElement submit = null;
	
	public static WebElement Search()
	{
		labour = getDriver().findElement(By.className("f-textbox"));
		return labour;
	}
	
	public static WebElement WorkspaceArrow()
	{
		submit = getDriver().findElement(By.xpath("(//img[@class='svg-icon'])[3]"));
		return submit;
	}
	public static WebElement clickStatutoryDoc()
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Statutory Documents']"));
		
		return labour;
	}
	public static WebElement clickComplianceType()	
	{
		labour = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'][normalize-space()='Compliance'])[1]"));
		
		return labour;
	}
	public static WebElement selectComplianceChallan()	
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Challan']"));
		return labour;
	}
	public static WebElement clickAct2()	
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Act')]"));
		return labour;
	}
	public static WebElement selectCompliancePT()
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Professional Tax Act']"));
		return labour;
	}
	public static WebElement clickYear()
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Year')]"));
		return labour;
	}
	public static WebElement Year2025()	
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='2025']"));
		return labour;
	}
	public static WebElement Year2024()	
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='2024']"));
		return labour;
	}
	public static WebElement clickPeriod()	
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Period')]"));
		return labour;
	}
	public static WebElement selectMonthJan()
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'January')]"));
		return labour;
	}
	public static WebElement selectMonthAugust()
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='August']"));
		return labour;
	}
	public static WebElement selectMonthFeb()
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'January')]"));
		return labour;
	}
	public static WebElement selectMonthMay()	
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'May')]"));
		return labour;
	}
	public static WebElement selectMonthAug()
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'January')]"));
		return labour;
	}
	public static WebElement selectMonthSep()
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'January')]"));
		return labour;
	}
	public static WebElement selectMonthOctober()
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'January')]"));
		return labour;
	}
	public static WebElement selectMonthNov()
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'January')]"));
		return labour;
	}
	public static WebElement selectMonthDec()
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'January')]"));
		return labour;
	}
	public static WebElement clickBranch1()	
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select Branch')]"));
		return labour;
	}
	public static WebElement Apply()		
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Apply']"));
		return labour;
	}
	public static WebElement PT_ConsolatedWorking()		
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='PT Consolidated Workings']"));
		return labour;
	}
	

	public static WebElement downloadDocument()		
	{
		labour = getDriver().findElement(By.xpath("//img[@alt='Download Document']"));
		return labour;
	}
	public static WebElement downloadDocument5()		
	{
		labour = getDriver().findElement(By.xpath("(//img[@alt='Download Document'])[5]"));
		return labour;
	}
	public static WebElement closeXbutton()		
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Close']"));
		return labour;
	}
	
	public static WebElement triangle()		
	{
		labour = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-right k-treelist-toggle k-svg-icon k-icon ng-star-inserted']"));
		return labour;
	}

	
	
	
}
