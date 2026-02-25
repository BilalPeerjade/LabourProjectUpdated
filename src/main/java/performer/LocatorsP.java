package performer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class LocatorsP extends BasePage {
	
	
	private static WebElement uname = null;			//WebElement variable created for Username input 
	private static WebElement submit = null;		//WebElement variable created for Submit button click
	
	public static WebElement HighRisk1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(17) > text"));
		return submit;
	}
	public static WebElement MediumRisk1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(24) > text"));
		return submit;
	}
	public static WebElement LowRisk1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(23) > text"));
		return submit;
	}
	
	
	//----TESTAUTO2------NonComplied Green
	public static WebElement CompHighRisk()	
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(17) > text"));
		return submit;
	}
	
	public static WebElement CompMediumRisk()	
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(20) > text"));
		return submit;
	}
	public static WebElement CompLowRisk()
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(23) > text"));
		return submit;
	}
	
	
	//-----------AVANEW----------Changed to TESTAUTO2
	public static WebElement HighRisk2()//Risk Summ Non complied High
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(17) > text"));
		return submit;
	}
	public static WebElement MediumRisk2()
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(20) > text"));
		return submit;
	}
	public static WebElement LowRisk2()
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(4) > div:nth-child(2) > div > app-cd-risk-summary > div > kendo-chart > div > svg > g > g:nth-child(3) > g:nth-child(23) > text"));
		return submit;
	}
	
	
	
	
	
	
	
	
	
}
