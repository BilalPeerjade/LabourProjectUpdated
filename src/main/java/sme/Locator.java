package sme;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class Locator extends BasePage {

	
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
	public static WebElement ClearBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ClearFilter.svg']"));
		return labour;
	}
	public static WebElement SearchBox()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@placeholder='Type to Search']"));
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
}
