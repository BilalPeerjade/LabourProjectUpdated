package rcp;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;



public class ChangePassLocator extends BasePage{

	private static WebElement labour = null;			//WebElement variable created for Username input 

	public static WebElement clickHereToGoBackLink()
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Click here to go back']"));
		return labour;
	}
	public static WebElement LogOut()
	{
		labour = getDriver().findElement(By.xpath("//i[@title='Log Out']"));
		return labour;
	}
	public static WebElement ChangePassword()
	{
		labour = getDriver().findElement(By.xpath("//li[@title='Change Password']"));
		return labour;
	}
	public static WebElement currentPasswordField()
	{
		labour = getDriver().findElement(By.xpath("//input[@placeholder='Current Password']"));
		return labour;
	}
	public static WebElement newPasswordField()
	{
		labour = getDriver().findElement(By.xpath("//input[@placeholder='New Password']"));
		return labour;
	}
	public static WebElement confirmPasswordField()
	{
		labour = getDriver().findElement(By.xpath("//input[@placeholder='Confirm Password']"));
		return labour;
	}
	public static WebElement changePass_ClearButton()
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Clear']"));
		return labour;
	}
	public static WebElement changePass_SubmitButton()
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Submit']"));
		return labour;
	}
	public static WebElement changePass_ShowPass1() //Show Password Eye icon 1
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Show Password']"));
		return labour;
	}
	public static WebElement changePass_ShowPass2() //Show Password Eye icon 2
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Show Password'])[2]"));
		return labour;
	}
	public static WebElement changePass_ShowPass3() //Show Password Eye icon 3
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Show Password'])[3]"));
		return labour;
	}
	public static WebElement messageAfterSubmit() //after clicking to submit common message for get text
	{
		labour = getDriver().findElement(By.xpath("//h4[@class='f-label']"));
		return labour;
	}
	public static WebElement messageOK() //After message is displayed OK button xpath
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='OK']"));
		return labour;
	}
	
	
	//After Entering New correct and Confirm Password Incorrect Error messsage displayed that xpath for get text
	public static WebElement newANDconfirmPassError()
	{
		labour = getDriver().findElement(By.xpath("//small[normalize-space(.)='New Password and Confirm Password do not match.']"));
		return labour;
	}
	

}
