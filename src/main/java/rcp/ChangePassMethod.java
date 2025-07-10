package rcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import clientPortal.Date;
//import clientPortal.SimpleDateFormat;
//import clientPortal.TakesScreenshot;
//import clientPortal.WebDriver;
import coordinator.CoordinatorMethod;
import login.BasePage;
import login.LoginLocators;





public class ChangePassMethod extends BasePage
{
	
	
	
	
	
	 public static void ChangePassWithInvalidCurrentPass( ExtentTest test,String Notice) throws InterruptedException, IOException
		{
		    WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		    
		    Thread.sleep(3000);
		    Thread.sleep(5000);
		    Thread.sleep(10000);
		    ChangePassLocator.LogOut().click();
		    Thread.sleep(2000);
		    ChangePassLocator.ChangePassword().click();
		    Thread.sleep(5000);
		    wait.until(ExpectedConditions.visibilityOf(ChangePassLocator.newPasswordField()));
		    ChangePassLocator.currentPasswordField().sendKeys("heqp001haleq");
		    Thread.sleep(2000);
		    ChangePassLocator.newPasswordField().sendKeys("Hello@123");
		    Thread.sleep(2000);
		    ChangePassLocator.confirmPasswordField().sendKeys("Hello@123");
		    Thread.sleep(5000);
		    
		    if(ChangePassLocator.changePass_SubmitButton().isDisplayed())
		    {
			    ChangePassLocator.changePass_SubmitButton().click();
			    Thread.sleep(15000);
			    test.log(LogStatus.PASS, "Submit button is working fine");
		    }
		    
		    
		    wait.until(ExpectedConditions.visibilityOf(ChangePassLocator.messageAfterSubmit()));
		    
		    String txt = ChangePassLocator.messageAfterSubmit().getText();
		    
			if (txt.equalsIgnoreCase("Current password you entered is incorrect. Please check.")) {
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Entering invalid password in current password, password is not changed !");
				Thread.sleep(500);
				test.log(LogStatus.PASS, "Message Displayed :- " + txt);

			} else {
				Thread.sleep(5000);
				test.log(LogStatus.FAIL, "Message displayed : " + txt);
			}
			
			Thread.sleep(5000);
			if(ChangePassLocator.messageOK().isDisplayed() && 
			   ChangePassLocator.messageOK().isEnabled())
			{
				ChangePassLocator.messageOK().click();
				test.log(LogStatus.PASS, "OK button is working fine");
			}
			
			if(ChangePassLocator.changePass_ClearButton().isDisplayed())
			{
				ChangePassLocator.changePass_ClearButton().click();;
				test.log(LogStatus.PASS, "Clear button is working fine");
			}
			
			
			
			//New Scenario:-
			Thread.sleep(4000);
			ChangePassLocator.currentPasswordField().clear();
			Thread.sleep(1000);
			ChangePassLocator.newPasswordField().clear();
			Thread.sleep(1000);
			ChangePassLocator.confirmPasswordField().clear();
			
			
			Thread.sleep(1000);
			ChangePassLocator.currentPasswordField().sendKeys("Helloo@123");
			Thread.sleep(1000);
			ChangePassLocator.newPasswordField().sendKeys("Hello11@123");
			Thread.sleep(1000);
			ChangePassLocator.confirmPasswordField().sendKeys("Hello11@12345");
			
			Thread.sleep(5000);
			ChangePassLocator.changePass_SubmitButton().click();
			Thread.sleep(5000);
			
			String txt2 = ChangePassLocator.newANDconfirmPassError().getText();
			System.out.println("Error:------- " + txt2);
			if (txt2.equalsIgnoreCase("New Password and Confirm Password do not match.")) {
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Entering New Password and Confirm Password Different Password is not changed !");
				Thread.sleep(1200);
				test.log(LogStatus.PASS, "Message Displayed :- " + txt2);

			} else {
				Thread.sleep(5000);
				test.log(LogStatus.FAIL, "Message displayed : " + txt2);
			}
			
			
			
		//	ChangePassLocator.messageOK().click(); 
			
			
			//New Scenario
			getDriver().navigate().refresh();
			Thread.sleep(8000);
			ChangePassLocator.currentPasswordField().sendKeys("admin@123");
			Thread.sleep(1000);
			ChangePassLocator.newPasswordField().sendKeys("admin@123");
			Thread.sleep(1000);
			ChangePassLocator.confirmPasswordField().sendKeys("admin@123");
			Thread.sleep(1000);
			
			Thread.sleep(5000);
			ChangePassLocator.changePass_SubmitButton().click();
			Thread.sleep(5000);
			
			String txt3 = ChangePassLocator.messageAfterSubmit().getText();
			System.out.println("Error:------- " + txt3);
			if (txt3.equalsIgnoreCase("New Password can not be same as Old Password. Please enter different password.")) {
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Entering Current , New , Confirm Passwords same in all fields Error displayed !");
				Thread.sleep(1200);
				test.log(LogStatus.PASS, "Message Displayed :- " + txt3);

			} else {
				Thread.sleep(5000);
				test.log(LogStatus.FAIL, "Message displayed : " + txt3);
			}
			
			
			
			ChangePassLocator.messageOK().click(); 
					
	    }
	 
	 
	 
	 public static void ChangePassEyeButton( ExtentTest test,String Notice) throws InterruptedException, IOException
		{
		    WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		    
		    Thread.sleep(3000);
		    Thread.sleep(5000);
		    Thread.sleep(10000);
		    ChangePassLocator.LogOut().click();
		    Thread.sleep(2000);
		    ChangePassLocator.ChangePassword().click();
		    Thread.sleep(5000);
		    
		    
		    //Code for Current Password Eye button
			// 1. enter the password you want to test
			String expectedPwd = OneCommonMethod.getRandomString(); 
			ChangePassLocator.currentPasswordField().clear();
			ChangePassLocator.currentPasswordField().sendKeys(expectedPwd);

			// 2. click on the eye icon to toggle visibility
			ChangePassLocator.changePass_ShowPass1().click();
			Thread.sleep(5000);

			// 3. verify that the field now shows the plain text
			String actualPwd = ChangePassLocator.currentPasswordField().getAttribute("value");
			Thread.sleep(5000);

			if (expectedPwd.equals(actualPwd)) {
				test.log(LogStatus.PASS, "Current Password Eye button is working fine");
			    test.log(LogStatus.PASS, "Current Password Displayed :- " + actualPwd);
			} else {
				test.log(LogStatus.FAIL, "Current Password Displayed :- " + actualPwd);
			}
			
			
			
			//Code for New Password Eye button
			// 1. enter the password you want to test
			String expectedPwd2 = OneCommonMethod.getRandomString(); 
			ChangePassLocator.newPasswordField().clear();
			ChangePassLocator.newPasswordField().sendKeys(expectedPwd2);

			// 2. click on the eye icon to toggle visibility
			ChangePassLocator.changePass_ShowPass2().click();
			Thread.sleep(5000);

			// 3. verify that the field now shows the plain text
			String actualPwd2 = ChangePassLocator.newPasswordField().getAttribute("value");
			Thread.sleep(5000);

			if (expectedPwd2.equals(actualPwd2)) {
				test.log(LogStatus.PASS, "New Password Eye button is working fine");
			    test.log(LogStatus.PASS, "New Password Displayed :- " + actualPwd2);
			} else {
				test.log(LogStatus.FAIL, "New Password Displayed :- " + actualPwd2);
			}
			
			
			
			// 1. enter the password you want to test
			String expectedPwd3 = OneCommonMethod.getRandomString(); 
			ChangePassLocator.confirmPasswordField().clear();
			ChangePassLocator.confirmPasswordField().sendKeys(expectedPwd3);

			// 2. click on the eye icon to toggle visibility
			ChangePassLocator.changePass_ShowPass3().click();
			Thread.sleep(5000);

			// 3. verify that the field now shows the plain text
			String actualPwd3 = ChangePassLocator.confirmPasswordField().getAttribute("value");
			Thread.sleep(5000);

			if (expectedPwd3.equals(actualPwd3)) {
				test.log(LogStatus.PASS, "Confirm Password Eye button is working fine");
			    test.log(LogStatus.PASS, "Confirm Password Displayed :- " + actualPwd3);
			} else {
				test.log(LogStatus.FAIL, "Confirm Password Displayed :- " + actualPwd3);
			}
		    
		
	    }

	 
	 
	 
	 
	 
	 
}
