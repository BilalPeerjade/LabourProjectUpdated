package superAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class SuperLocators extends BasePage  {

	
	private static WebElement Super = null;				//WebElement variable created for 'Categories' click
	private static WebElement compliances = null;				//WebElement variable created for 'Compliances' read and click
	private static List<WebElement> compliancesList = null;	
	
	public static WebElement SelectState( )		//Method for closing Message Popup
	{
		Super = getDriver().findElement(By.xpath("(//span[contains(text(),'Select State')])[1]"));
		return Super;
	}
	
	public static WebElement SelectState1( )		//Method for closing Message Popup
	{
		Super = getDriver().findElement(By.xpath("//span[contains(text(),'Andhra Pradesh')]"));
		return Super;
	}
	
	public static WebElement SelectAct( )		//Method for closing Message Popup
	{
		Super = getDriver().findElement(By.xpath("(//span[contains(text(),'Select Act')])[1]"));
		return Super;
	}
	
	public static WebElement SelectAct1( )		//Method for closing Message Popup
	{
		Super = getDriver().findElement(By.xpath("//span[contains(text(),'FACT and  Allied acts')]"));
		return Super;
	}
	
	public static WebElement regionalDownload( )		//Method for closing Message Popup
	{
		Super = getDriver().findElement(By.xpath("(//img[@alt='Icon 1'])[1]"));
		return Super;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
