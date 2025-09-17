package login;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

//UserLogin2:
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginMethods extends BasePage {
	private static WebElement uname = null;			//WebElement variable created for Username input 
	private static WebElement pass = null;			//WebElement variable created for Password input
	private static WebElement submit = null;		//WebElement variable created for Submit button click
	private static WebElement QALink = null;		//WebElement variable created for Question Answer link after comes up after login
	private static WebElement question1 = null;		//WebElement variable created for question1 element
	private static WebElement question2 = null;		//WebElement variable created for question2 element
	private static WebElement ans1 = null;			//WebElement variable created for Answer1 input
	private static WebElement ans2 = null;			//WebElement variable created for Answer2 input
	private static WebElement validate = null;		//WebElement variable created for Answer Submit/Validate button
	private static WebElement comp_img = null;		//WebElement variable created for Compliance Image click
	
	public static WebElement setUname(WebDriver driver)		//Method for searching Username input
	{
		uname = driver.findElement(By.xpath("//*[@id='txtemail']"));
		return uname;
	}
	
	public static WebElement setPassword(WebDriver driver)	//Method for searching Password input
	{
		pass =driver.findElement(By.xpath("//*[@id='txtpass']"));
		return pass;
	}
	
	public static WebElement clickSubmit(WebDriver driver)	//Method for searching button for Save/Sign-in
	{
		submit = driver.findElement(By.xpath("//input[@name='Submit']"));
		return submit;
	}

	
	public static void UserLogin(String username, String password) throws InterruptedException {
		// WebDriverWait wait = new WebDriverWait(getDriver(), 40);
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 60);

		LoginLocators.setUname().sendKeys(username); // Sent username to input box
		Thread.sleep(3000);
		LoginLocators.setPassword().sendKeys(password); // Sent password to input box
		Thread.sleep(3000);
		LoginLocators.clickSubmit().click(); // Clicked on Sign-in button
		Thread.sleep(3000);

	}
	
	
	public static void UserLogin2(String username, String password) throws InterruptedException {
	    WebDriver driver = getDriver();
	    WebDriverWait wait1 = new WebDriverWait(driver, 60);
	    final int MAX_RETRIES = 3;

	    boolean unameOk = false;
	    boolean passOk = false;

	    for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
	        try {
	            // --- username: re-find and check value ---
	            WebElement u = LoginLocators.setUname(); // should re-find element each call
	            wait1.until(ExpectedConditions.visibilityOf(u));
	            String curU = safeGetValue(u);
	            if (!username.equals(curU)) {
	                try { u.clear(); } catch (Exception ignore) {}
	                u.click();
	                u.sendKeys(username);
	                Thread.sleep(200);
	                curU = safeGetValue(u);
	            }
	            if (username.equals(curU)) unameOk = true;

	            // --- password: re-find and check value ---
	            WebElement p = LoginLocators.setPassword();
	            wait1.until(ExpectedConditions.visibilityOf(p));
	            String curP = safeGetValue(p);
	            if (!password.equals(curP)) {
	                try { p.clear(); } catch (Exception ignore) {}
	                p.click();
	                p.sendKeys(password);
	                Thread.sleep(200);
	                curP = safeGetValue(p);
	            }
	            if (password.equals(curP)) passOk = true;

	            // If both ok, break early
	            if (unameOk && passOk) break;

	        } catch (StaleElementReferenceException sere) {
	            // element refreshed - just retry
	        } catch (TimeoutException te) {
	            // wait timed out - retry
	        } catch (Exception e) {
	            // optional: log e.getMessage()
	        }
	        Thread.sleep(400); // small backoff then next attempt
	    }

	    if (!unameOk) throw new RuntimeException("Unable to set username after retries");
	    if (!passOk) throw new RuntimeException("Unable to set password after retries");

	    // now click submit with simple retry (doesn't re-type inputs)
	    boolean clicked = false;
	    for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
	        try {
	            WebElement btn = LoginLocators.clickSubmit();
	            wait1.until(ExpectedConditions.elementToBeClickable(btn));
	            btn.click();
	            clicked = true;
	            break;
	        } catch (StaleElementReferenceException | TimeoutException | ElementClickInterceptedException e) {
	            // retry
	        } catch (Exception e) {
	            // last resort retry
	        }
	        Thread.sleep(300);
	    }
	    if (!clicked) throw new RuntimeException("Submit click failed after retries");
	}

	// helper to safely read input value (handles nulls)
	private static String safeGetValue(WebElement e) {
	    try {
	        String v = e.getAttribute("value");
	        return v == null ? "" : v;
	    } catch (Exception ex) {
	        return "";
	    }
	}
	
	
	
	
	
	
	
	
	
	

	public static WebDriver UserLoginSDExecutor(String username, String password, String method) throws InterruptedException
	{		
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(1000);
		LoginLocators.setUname().sendKeys(username);		//Sent username to input box 
		Thread.sleep(500);
		LoginLocators.setPassword().sendKeys(password);	//Sent password to input box
		LoginLocators.clickSubmit().click();				//Clicked on Sign-in button
		Thread.sleep(500);
		
			
		try
		{
			Thread.sleep(500);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.clickQALink()));
			wait.until(ExpectedConditions.elementToBeClickable(LoginLocators.clickQALink()));
			LoginLocators.clickQALink().click();				//Clicking on QA Link instead of OTP.
			
			//----------------------------------------------------------------------------//
			
			wait.until(ExpectedConditions.invisibilityOf(LoginLocators.clickQALink()));
		}
		catch(Exception e)
		{
			
		}
			
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Question1()));
			wait.until(ExpectedConditions.elementToBeClickable(LoginLocators.Question1()));
			String que1 = LoginLocators.Question1().getText();	//Storing the question in que variable.
			String ans1 = null;
			
			
			
			if(method.equalsIgnoreCase("cfo"))
			{
				ans1 = getAnswerCFO(que1);						//Storing the answer in ans variable.
			}
		
			else if(method.equalsIgnoreCase("SD"))
			{
				ans1 = "123";						//Storing the answer in ans variable.
			}
			
			
			
			
			
			else
			{
				ans1 = getAnswer(que1);							//Storing the answer in ans variable.
			}
			
			
			if(ans1.equalsIgnoreCase("birthplace"))
				LoginLocators.Answer1().sendKeys("place");		//Sending answer to the input box.
			else
				LoginLocators.Answer1().sendKeys(ans1);		//Sending answer to the input box.
			Thread.sleep(1000);
			
			//----------------------------------------------------------//
			
			String que2 = LoginLocators.Question2().getText();	//Storing the question in que variable.
			String ans2 = null;
			if(method.equalsIgnoreCase("cfo"))
			{
				ans2 = getAnswerCFO(que2);						//Storing the answer in ans variable.
			}
			
			
			else if(method.equalsIgnoreCase("SD"))
			{
				ans2 = "123";						//Storing the answer in ans variable.
			}
			
			else if(method.equalsIgnoreCase("company"))
			{
				ans2 = "123";						//Storing the answer in ans variable.
			}
			else
			{
				ans2 = getAnswer(que2);							//Storing the answer in ans variable.
			}
			
			
			if(ans2.equalsIgnoreCase("birthplace"))
				LoginLocators.Answer2().sendKeys("place");		//Sending answer to the input box.
			else
				LoginLocators.Answer2().sendKeys(ans2);		//Sending answer to the input box.
			Thread.sleep(100);
			
			LoginLocators.SubmitAnswer().click();				//Clicking on Submit button.
			Thread.sleep(4000);
			LoginLocators.LabourComplianceProject().click();
			Thread.sleep(3000);
			
		return getDriver();
	}

public static String getAnswerCFO(String que)			//Method created to extract last word from question
{														//as it is the answer of the question.
	String last = que.substring(que.lastIndexOf(" "));	//We are selecting word after last " ".
	int len = last.length();							
	String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
	if(ans.equalsIgnoreCase("pet"))
		ans = "dog";
	if(ans.equalsIgnoreCase("car"))
		ans = "red";
	return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
}
public static String getAnswer(String que)				//Method created to extract last word from question
{														//as it is the answer of the question.
	String last = que.substring(que.lastIndexOf(" "));		//We are selecting word after last " ".
	int len = last.length();							
	String ans = last.substring(1, len-1);				//We are neglecting letters from string of position first " " and last "?"
	return ans.toLowerCase();							//Returning answer and converting to LowerCase too.  
	
	
}
}
