package coordinator;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;


public class CoordinatorDisabledField extends BasePage {

	private static WebElement labour = null;
	

	public static WebElement BasicInfoPlus1()
	{
		labour = getDriver().findElement(By.xpath("//img[@class='svg-icon-btn']"));
		return labour;
	}
	
	public static WebElement RCPNoField()
	{
		labour = getDriver().findElement(By.xpath("(//input[@class='f-textbox ng-untouched ng-pristine'])[1]"));
		return labour;
	}
	
	public static WebElement ClientNameField()
	{
		labour = getDriver().findElement(By.xpath("(//input[@class='f-textbox ng-untouched ng-pristine'])[2]"));
		return labour;
	}
	
	public static WebElement LocationField()
	{
		labour = getDriver().findElement(By.xpath("(//input[@class='f-textbox ng-untouched ng-pristine'])[3]"));
		return labour;
	}
	
	public static WebElement BranchField()
	{
		labour = getDriver().findElement(By.xpath("(//input[@class='f-textbox ng-untouched ng-pristine'])[4]"));
		return labour;
	}
	
	public static WebElement AddressField()
	{
		labour = getDriver().findElement(By.xpath("(//input[@class='f-textbox ng-untouched ng-pristine'])[5]"));
		return labour;
	}
	
	public static WebElement LicenseNoField()
	{
		labour = getDriver().findElement(By.xpath("(//input[@class='f-textbox ng-untouched ng-pristine'])[6]"));
		return labour;
	}
	
	
	public static WebElement ClientIDdropdown()
	{
		labour = getDriver().findElement(By.xpath("(//kendo-dropdownlist[@role='combobox'])[1]"));
		return labour;
	}
	
	public static WebElement StateDropdown()
	{
		labour = getDriver().findElement(By.xpath("(//kendo-dropdownlist[@role='combobox'])[2]"));
		return labour;
	}
	
	public static WebElement LicenseTypeDropdown()
	{
		labour = getDriver().findElement(By.xpath("(//kendo-dropdownlist[@role='combobox'])[3]"));
		return labour;
	}
	
	public static WebElement ActivityTypeDropdown()
	{
		labour = getDriver().findElement(By.xpath("(//kendo-dropdownlist[@role='combobox'])[4]"));
		return labour;
	}
	
	
	

}
