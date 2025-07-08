package distributor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import clientPortal.All_ClientPortal_Locators;
import login.BasePage;
import login.LoginLocators;
import performer.LocatorsP;
import performer.PerformerLocator;
import rcp.OneCommonMethod;


public class MethodsD extends BasePage {
	
    static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour.xlsx";
	
	public static void complianceBox( ExtentTest test, String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		Thread.sleep(5000);
	//	LoginLocators.Search().sendKeys("WWKRG");		
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
		
	int open = Integer.parseInt(LoginLocators.ComplianceBox().getText());	
	LoginLocators.ComplianceBox().click();					                
    Thread.sleep(5000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("svg-icon")));

	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   
	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								
	String compliancesCount = bits[bits.length - 2];				
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	
	
	waitForLoaderToDisappear(); // 
	
	Thread.sleep(9000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(9000);
	LoginLocators.ClosePopUp().click();
	Thread.sleep(3000);
	
	
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
	
}
	
	public static void NotCompliedCheck( ExtentTest test, String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		Thread.sleep(2000);
	//	LoginLocators.Search().sendKeys("WWKRG");		
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.ComplianceBox()));
		Thread.sleep(5000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
		
		getDriver().findElement(By.xpath("//span[normalize-space()='Not Complied']")).click();
		Thread.sleep(5000);
		WebElement notCompliedred = getDriver().findElement(By.xpath("//div[@class='card']//app-cd-performance-summary//div//div//div//div[@role='graphics-document document']//*[name()='svg']//*[name()='g']//*[name()='g']//*[name()='g']//*[name()='g' and contains(@class,'k-chart-po')]//*[name()='path']"));
		
		notCompliedred.click();
		notCompliedred.click();
		Thread.sleep(10000);
	
	
}

	public static void EntitiesSearch( ExtentTest test, String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
			test.log(LogStatus.PASS, "Entity Search is working fine");
			
		}
		
		
		
		
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
}
	
	public static void CompanyLogo( ExtentTest test, String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
/*		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
			test.log(LogStatus.PASS, "Entity Search is working fine");
			
		}
		
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		*/
        WebElement ExpandIcon = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/SidebarToggleoff.svg']"));
        ExpandIcon.click();
        
        Thread.sleep(5000);
        String LogoTeamLease = getDriver().findElement(By.xpath("//img[@alt='TeamLease Logo']")).getText();
        WebElement LogoTeamL = getDriver().findElement(By.xpath("//img[@alt='TeamLease Logo']"));
        
        System.out.println(LogoTeamLease);
        
        if(LogoTeamL.isDisplayed())
        {
        	test.log(LogStatus.PASS,"'Team Lease RegTech Helping India Comply' Logo is displayed successfully");
        }
        else
        {
        	test.log(LogStatus.FAIL,"Logo is not displayed");
        }
        
        String base64Screenshot = OneCommonMethod.takeScreenshotBase64(driver.get());
        test.log(LogStatus.INFO, "ScreenShot <br>" + test.addBase64ScreenShot(base64Screenshot));
		
	
}
	public static void Logout( ExtentTest test, String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);Thread.sleep(5000);Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));

		LoginLocators.profileButtonLogout().click();
		Thread.sleep(3000);
		
		getDriver().findElement(By.xpath("//li[@title='Logout']")).click();
		Thread.sleep(3000);
		WebElement Singin = getDriver().findElement(By.xpath("//input[@id='Submit']"));
		Thread.sleep(3000);
		if (Singin.isDisplayed() )
		{
			test.log(LogStatus.PASS,"Logout link is working fine");
			
			String base64Screenshot = OneCommonMethod.takeScreenshotBase64(driver.get());
	        test.log(LogStatus.INFO, "ScreenShot <br>" + test.addBase64ScreenShot(base64Screenshot));
		}
		else
		{
			test.log(LogStatus.FAIL,"Logout link is not working");
		}
		
}
	
	
	public static void ProceedToDashboard( ExtentTest test, String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);Thread.sleep(5000);Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
			Thread.sleep(5000);
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
			Thread.sleep(5000);
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		
		String txt = LoginLocators.DashboardText().getText();
		
		if(txt.equalsIgnoreCase("Test Automation 2[TESTAUTO2]"))
		{
			test.log(LogStatus.PASS,"Proceed to dashboard button is working fine");
			test.log(LogStatus.PASS,"Entity displayed after proceed : " + txt);	
		}
		else
		{
			test.log(LogStatus.FAIL,"Proceed to dashboard button is not working");
			test.log(LogStatus.PASS,"Entity displayed : " + txt);	
		}
		
		
		
}
	
	public static void ChangePass( ExtentTest test, String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		Thread.sleep(3000);
		LoginLocators.profileButtonLogout().click();
		Thread.sleep(3000);
		
		getDriver().findElement(By.xpath("//li[@title='Change Password']")).click();
		Thread.sleep(3000);
		
		getDriver().findElement(By.xpath("//a[normalize-space()='Click here to go back']")).click();
		
		WebElement corporatebtn = getDriver().findElement(By.xpath("//button[normalize-space()='Corporate']"));
		
		if(corporatebtn.isDisplayed())
		{
			test.log(LogStatus.PASS,"'Click here to go back' link is working fine");
			
			test.log(LogStatus.PASS,"Dashboard page is displayed");
		}
		else
		{
			test.log(LogStatus.FAIL,"'Click here to go back' link is not working");
		}
	
}
	public static void EntityExcelDownload( ExtentTest test, String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));

		
		OneCommonMethod.zoomOutScreen(2); //Zoom Out
		
		test.log(LogStatus.INFO,"Checking Entity Location download");
		
		OneCommonMethod.validateFileDownload(
			    driver.get(),
			    test,
			    LoginLocators.EntityLocation_ExcelFile()  // ✅ WebElement passed
			);
		
		Thread.sleep(5000);
		test.log(LogStatus.INFO,"Now Checking Entity Master Excel download");
		
		OneCommonMethod.validateExportedExcel(
			    driver.get(),
			    test,
			    LoginLocators.Entity_ExcelFile(),            // Export button WebElement
			    LoginLocators.TotalNumberOfItem(),   // Count ka dynamic locator
			    "CLIENTNAME"                                  //Header Name
			);
	
		


		
}
	public static void PortalLogin( ExtentTest test, String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}

		
		getDriver().findElement(By.xpath("//img[@title='Portal Login']")).click();
		Thread.sleep(4000);
		getDriver().findElement(By.xpath("//img[@title='Sign In']")).click();
		
		Thread.sleep(4000);
		WebElement clientPortalElement = getDriver().findElement(By.xpath("//h4[normalize-space()='Compliance Performance']"));
		Thread.sleep(8000);
		if(clientPortalElement.isDisplayed())
		{
			test.log(LogStatus.PASS,"Portal Login & Sign In buttons are working fine");
			Thread.sleep(1300);
			test.log(LogStatus.PASS,"User is redirected to client portal successfully");
		}
		else
		{
			test.log(LogStatus.FAIL,"User is not redirected to client portal");
		}
}

	public static void GridAndExcelCountMatch(ExtentTest test,XSSFWorkbook workbook  ) throws InterruptedException, IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(5000); 		
        LoginLocators.TotalNumberOfItems().click();					
		Thread.sleep(2000);
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(8000);
		String[] bits = s.split(" ");								
		String compliancesCount = bits[bits.length - 2];				
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   s = LoginLocators.TotalNumberOfItems().getText();
			bits = s.split(" ");
        
		}
		
		Thread.sleep(5000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(2000);

Thread.sleep(4000);
File dir = new File("C:\\Users\\bilali\\Downloads");
File[] dirContents = dir.listFiles();							

Thread.sleep(5000);
try {
LoginLocators.Export().click();
}
catch(Exception e)
{
	LoginLocators.Exportbtn().click();
	
	}
test.log(LogStatus.PASS, "File downloaded successfully.");

Thread.sleep(8000);
File dir1 = new File("C:\\Users\\bilali\\Downloads");
File[] allFilesNew = dir1.listFiles();							

if(dirContents.length < allFilesNew.length)
{
		
	File lastModifiedFile = allFilesNew[0];			
    for (int i = 1; i < allFilesNew.length; i++) 	
    {
       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	
       {
           lastModifiedFile = allFilesNew[i];
       }
    }
	
	Thread.sleep(6000);
	fis = new FileInputStream(lastModifiedFile);
	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheetAt(0);					
	/*
	int no = sheet.getFirstRowNum();
	Row row = sheet.getRow(no);
	Cell c1 = row.getCell(0);
	int records =(int) c1.getNumericCellValue();
	*/
	sheet = workbook.getSheetAt(0);
	int columnNumber = 3;
	int rowCount = 0;
	int actualRow=0;
	
	for(Row row : sheet)
	{
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();
	
	if(count1 == actualRow)
	{
		//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{
		//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
}
else
{
	test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
}

		
	}
	public static void GridAndExcelCountMatch1(ExtentTest test,XSSFWorkbook workbook  ) throws InterruptedException, IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000); 
        WebDriverWait wait = new WebDriverWait(getDriver(),(120));
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNoOfItem()));

        LoginLocators.TotalNoOfItem().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(2000);
		String s = LoginLocators.TotalNoOfItem().getText();
		Thread.sleep(8000);
		String[] bits = s.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   s = LoginLocators.TotalNoOfItem().getText();
			bits = s.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(2000);

Thread.sleep(1000);
File dir = new File("C:\\Users\\bilali\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Thread.sleep(1000);
try {
LoginLocators.Export().click();
}
catch(Exception e)
{
	LoginLocators.Exportbtn().click();
	
	}
test.log(LogStatus.PASS, "Compliance Assignment Report : File downloaded successfully.");

Thread.sleep(9000);
File dir1 = new File("C:\\Users\\bilali\\Downloads");
File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

if(dirContents.length < allFilesNew.length)
{
		
	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
    {
       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
       {
           lastModifiedFile = allFilesNew[i];
       }
    }
	
	Thread.sleep(1000);
	fis = new FileInputStream(lastModifiedFile);
	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
	/*
	int no = sheet.getFirstRowNum();
	Row row = sheet.getRow(no);
	Cell c1 = row.getCell(0);
	int records =(int) c1.getNumericCellValue();
	*/
	sheet = workbook.getSheetAt(0);
	int columnNumber = 3;
	int rowCount = 0;
	int actualRow=0;
	
	for(Row row : sheet)
	{
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();
	
	if(count1 == actualRow)
	{
		//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{
		//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
}
else
{
	test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
}

		
	}

	public static void GridAndExcelCount(ExtentTest test,XSSFWorkbook workbook  ) throws InterruptedException, IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000); 
        WebDriverWait wait = new WebDriverWait(getDriver(),(120));
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNoOfItem()));

        LoginLocators.TotalNoOfItem().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(2000);
		String s = LoginLocators.TotalNoOfItem().getText();
		Thread.sleep(8000);
		String[] bits = s.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   s = LoginLocators.TotalNoOfItem().getText();
			bits = s.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(2000);

Thread.sleep(1000);
File dir = new File("C:\\Users\\bilali\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Thread.sleep(1000);
try {
LoginLocators.Export().click();
}
catch(Exception e)
{
	LoginLocators.Exportbtn().click();
	
	}
test.log(LogStatus.PASS, " File downloaded successfully.");

Thread.sleep(9000);
File dir1 = new File("C:\\Users\\bilali\\Downloads");
File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

if(dirContents.length < allFilesNew.length)
{
		
	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
    {
       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
       {
           lastModifiedFile = allFilesNew[i];
       }
    }
	
	Thread.sleep(1000);
	fis = new FileInputStream(lastModifiedFile);
	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
	/*
	int no = sheet.getFirstRowNum();
	Row row = sheet.getRow(no);
	Cell c1 = row.getCell(0);
	int records =(int) c1.getNumericCellValue();
	*/
	sheet = workbook.getSheetAt(0);
	int columnNumber = 3;
	int rowCount = 0;
	int actualRow=0;
	
	for(Row row : sheet)
	{
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();
	
	if(count1 == actualRow)
	{
		//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{
		//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
}
else
{
	test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
}

		
	}

	public static void GridAndExcelCounts(ExtentTest test,XSSFWorkbook workbook  ) throws InterruptedException, IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000); 
        WebDriverWait wait = new WebDriverWait(getDriver(),(120));
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNoOfItem()));

        LoginLocators.TotalNoOfItem().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(2000);
		String s = LoginLocators.TotalNoOfItem().getText();
		Thread.sleep(8000);
		String[] bits = s.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   s = LoginLocators.TotalNoOfItem().getText();
			bits = s.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(2000);

Thread.sleep(1000);
File dir = new File("C:\\Users\\bilali\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Thread.sleep(1000);
try {
LoginLocators.Export().click();
}
catch(Exception e)
{
	LoginLocators.Exportbtn().click();
	
	}
test.log(LogStatus.PASS, " File downloaded successfully.");

Thread.sleep(9000);
File dir1 = new File("C:\\Users\\bilali\\Downloads");
File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

if(dirContents.length < allFilesNew.length)
{
		
	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
    {
       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
       {
           lastModifiedFile = allFilesNew[i];
       }
    }
	
	Thread.sleep(1000);
	fis = new FileInputStream(lastModifiedFile);
	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
	/*
	int no = sheet.getFirstRowNum();
	Row row = sheet.getRow(no);
	Cell c1 = row.getCell(0);
	int records =(int) c1.getNumericCellValue();
	*/
	sheet = workbook.getSheetAt(0);
	int columnNumber = 2;
	int rowCount = 0;
	int actualRow=0;
	
	for(Row row : sheet)
	{
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();
	
	if(count1 == actualRow)
	{
		//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{
		//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
}
else
{
	test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
}

		
	}
	public static void GridAndExcelCountMatch2(ExtentTest test,XSSFWorkbook workbook  ) throws InterruptedException, IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000); 
        WebDriverWait wait = new WebDriverWait(getDriver(),(120));
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));

        LoginLocators.TotalNumberOfItems().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(2000);
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(8000);
		String[] bits = s.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   s = LoginLocators.TotalNumberOfItems().getText();
			bits = s.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(2000);

Thread.sleep(1000);
File dir = new File("C:\\Users\\bilali\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Thread.sleep(1000);
try {
LoginLocators.Export().click();
Thread.sleep(20000);
}
catch(Exception e)
{
	LoginLocators.Exportbtn().click();
	Thread.sleep(20000);
	
	}
test.log(LogStatus.PASS, " downloaded successfully.");

Thread.sleep(1000);
File dir1 = new File("C:\\Users\\bilali\\Downloads");
File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

if(dirContents.length < allFilesNew.length)
{
		
	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
    {
       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
       {
           lastModifiedFile = allFilesNew[i];
       }
    }
	
	Thread.sleep(1000);
	fis = new FileInputStream(lastModifiedFile);
	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
	/*
	int no = sheet.getFirstRowNum();
	Row row = sheet.getRow(no);
	Cell c1 = row.getCell(0);
	int records =(int) c1.getNumericCellValue();
	*/
	sheet = workbook.getSheetAt(0);
	int columnNumber = 3;
	int rowCount = 0;
	int actualRow=0;
	
	for(Row row : sheet)
	{
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();
	
	if(count1 == actualRow)
	{
		//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{
		//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
}
else
{
	test.log(LogStatus.FAIL, "  doesn't downloaded successfully.");
}

		
	}



	public static void GridAndExcelCountMatch3(ExtentTest test,XSSFWorkbook workbook  ) throws InterruptedException, IOException
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(2000); 
        WebDriverWait wait = new WebDriverWait(getDriver(),(120));
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItem()));

        LoginLocators.TotalNumberOfItem().click();					//Clicking on Text of total items just to scroll down.
		Thread.sleep(2000);
		String s = LoginLocators.TotalNumberOfItem().getText();
		Thread.sleep(8000);
		String[] bits = s.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   s = LoginLocators.TotalNumberOfItem().getText();
			bits = s.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(2000);

Thread.sleep(1000);
File dir = new File("C:\\Users\\bilali\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Thread.sleep(1000);
try {
LoginLocators.Export().click();
Thread.sleep(20000);
}
catch(Exception e)
{
	LoginLocators.Exportbtn().click();
	Thread.sleep(20000);
	
	}
test.log(LogStatus.PASS, " downloaded successfully.");

Thread.sleep(1000);
File dir1 = new File("C:\\Users\\bilali\\Downloads");
File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

if(dirContents.length < allFilesNew.length)
{
		
	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
    {
       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
       {
           lastModifiedFile = allFilesNew[i];
       }
    }
	
	Thread.sleep(1000);
	fis = new FileInputStream(lastModifiedFile);
	workbook = new XSSFWorkbook(fis);
	sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
	/*
	int no = sheet.getFirstRowNum();
	Row row = sheet.getRow(no);
	Cell c1 = row.getCell(0);
	int records =(int) c1.getNumericCellValue();
	*/
	sheet = workbook.getSheetAt(0);
	int columnNumber = 3;
	int rowCount = 0;
	int actualRow=0;
	
	for(Row row : sheet)
	{
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();
	
	if(count1 == actualRow)
	{
		//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{
		//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
}
else
{
	test.log(LogStatus.FAIL, " doesn't downloaded successfully.");
}

		
	}





	public static void UpcomingBox( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);Thread.sleep(5000);Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO2");
		//	LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO2");
		//	LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO2");
		//	LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.UpcomingBox().getText());	//Reading Dashboard count.
	LoginLocators.UpcomingBox().click();					                //Clicking on Dashboard count
    Thread.sleep(5000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(5000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(4000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(5000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "Overview button successfully");
	Thread.sleep(9000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);	
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	LoginLocators.ClosePopUp().click();
	Thread.sleep(3000);
	
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void OverdueBox( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);Thread.sleep(5000);	Thread.sleep(5000);	
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
			Thread.sleep(7000);
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
			Thread.sleep(7000);
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
			Thread.sleep(7000);
		}
		//LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.OverdueBox().getText());	//Reading Dashboard count.
	LoginLocators.OverdueBox().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(10000);
	
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.CloseDocument()));
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	try {
	LoginLocators.SelectValueDropdown().click();
	}
	catch(Exception e) {
		
	}
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	LoginLocators.ClosePopUp().click();
	Thread.sleep(3000);
	}
	else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}

	
	
}
	
	public static void PendingActionBox( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue2024().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.PendingActionBox().getText());	//Reading Dashboard count.
	LoginLocators.PendingActionBox().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(6000);
	
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.type()));

	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	LoginLocators.ClosePopUp().click();
	Thread.sleep(3000);
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void PendingReviewBox( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
	//	LoginLocators.Search().sendKeys("WWKRG");
		//LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue2024().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.PendingReviewBox().getText());	//Reading Dashboard count.
	LoginLocators.PendingReviewBox().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	LoginLocators.ClosePopUp().click();
	Thread.sleep(3000);
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void RegisterUpcoming( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
	//	LoginLocators.Search().sendKeys("WWKRG");
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.RegisterUpcoming().getText());	//Reading Dashboard count.
	LoginLocators.RegisterUpcoming().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(8000);
	
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.CloseDocument()));
	
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
	LoginLocators.ClosePopUp().click();
	Thread.sleep(3000);
	}
	catch(Exception e) {
		
		LoginLocators.Close().click();		
	}
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void RegisterOverdue( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.RegisterOverdue().getText());	//Reading Dashboard count.
	LoginLocators.RegisterOverdue().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void RegisterActionReview( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.RegisterActionReview().getText());	//Reading Dashboard count.
	LoginLocators.RegisterActionReview().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void ReturnUpcoming( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
	int open = Integer.parseInt(LoginLocators.ReturnUpcoming().getText());	//Reading Dashboard count.
	LoginLocators.ReturnUpcoming().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(8000);
	
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.CloseDocument()));
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void ReturnOverdue( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
	int open = Integer.parseInt(LoginLocators.ReturnOverdue().getText());	//Reading Dashboard count.
	LoginLocators.ReturnOverdue().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void ReturnActionReview( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(5000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
	int open = Integer.parseInt(LoginLocators.ReturnActionReview().getText());	//Reading Dashboard count.
	LoginLocators.ReturnActionReview().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void ChallanUpcoming( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(5000);
	int open = Integer.parseInt(LoginLocators.ChallanUpcoming().getText());	//Reading Dashboard count.
	LoginLocators.ChallanUpcoming().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(8000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.CloseDocument()));
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.BranchCodetype().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, "Compliance Count from grid is 0");

		}
	
}
	
	public static void ChallanOverdue( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(5000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.ChallanOverdue().getText());	//Reading Dashboard count.
	LoginLocators.ChallanOverdue().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, " Count from grid is 0");

		}
	
}
	
	public static void ChallanActionReview( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		//LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
	int open = Integer.parseInt(LoginLocators.ChallanActionReview().getText());	//Reading Dashboard count.
	LoginLocators.ChallanActionReview().click();					                //Clicking on Dashboard count
    Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
    
	Thread.sleep(2000);
   			
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    
    js.executeScript("window.scrollBy(0,1000)");
    Thread.sleep(2000);
   

	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(open == count1)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		}
		catch(Exception e) {
			
			LoginLocators.Close().click();		
		}
	}
else {
		
		test.log(LogStatus.PASS, " Count from grid is 0");

		}
	
}
	
	
	public static void RiskGraph( ExtentTest test,String risk,int complianceCount) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
	
		if(risk.equalsIgnoreCase("High"))
		{
			Thread.sleep(3000);
			LoginLocators.HighRisk().click();
			}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			LoginLocators.MediumRisk().click();					//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(2000);
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			LoginLocators.LowRisk().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
						                  
	Thread.sleep(2000);
   			
	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(count1 == complianceCount)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "'"+risk+"' - "+"Dashboard Count = "+complianceCount+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "'"+risk+"' - "+"Dashboard Count = "+complianceCount+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	try {
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	}
	catch(Exception e){
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	}
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp1().click();
	Thread.sleep(3000);
	}
	catch(Exception e) {
		
		LoginLocators.ClosePopUp2().click();
		Thread.sleep(3000);
	}	
	}
else {
		
		test.log(LogStatus.PASS, "'"+risk+"' - "+" Count from grid is 0");

		}
	
	
}
	
	public static void CompRiskGraph( ExtentTest test,String risk,int complianceCount) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
	
		if(risk.equalsIgnoreCase("High"))
		{
			Thread.sleep(3000);
			LoginLocators.CompHighRisk().click();
			}
		else if(risk.equalsIgnoreCase("Medium"))
		{
			LoginLocators.CompMediumRisk().click();					//Clicking on High value of Pie Chart of 'Not Completed'.
			Thread.sleep(2000);
		}
		else if(risk.equalsIgnoreCase("Low"))
		{
			LoginLocators.CompLowRisk().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
		}
						                  
	Thread.sleep(2000);
   			
	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	if(count1 == complianceCount)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "'"+risk+"' - "+"Dashboard Count = "+complianceCount+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "'"+risk+"' - "+"Dashboard Count = "+complianceCount+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	Thread.sleep(3000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	try {
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	}
	catch(Exception e) {
		LoginLocators.ApplyBtn().click();
		Thread.sleep(3000);
	}
	
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp1().click();
	Thread.sleep(3000);
	}
	catch(Exception e) {
		
		LoginLocators.ClosePopUp2().click();
		Thread.sleep(3000);
	}	
	}
else {
		
		test.log(LogStatus.PASS, "'"+risk+"' - "+" Count from grid is 0");

		}
	
	
}
	
	public static void Complied(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(5000);
//		LoginLocators.SelectPeriodValue1().click();
		LoginLocators.SelectPeriodValue2024().click();
		Thread.sleep(9000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    
	    js.executeScript("window.scrollBy(0,300)");
	    Thread.sleep(2000);
		int open = Integer.parseInt(LoginLocators.CompliedCount().getText());	//Reading Dashboard count.
		Thread.sleep(2000);
		//LoginLocators.Complied().getText();
	//	Thread.sleep(2000);		
		String path = "//*[local-name()='svg']//*[name()='g' and @class='k-chart-point']";
		 List<WebElement> PathNC = getDriver().findElements(By.xpath(path));
		Actions action = new Actions(getDriver());
		for(WebElement e : PathNC)
		{
			action.moveToElement(e).click().build().perform();
		}
			try {	
				LoginLocators.PenActnClosePopup().click();	
				Thread.sleep(2000);
		Thread.sleep(2000);
			}
			catch(Exception e) {
				
			}
		
   			
	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	
	if(count1 == open)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Complied Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Complied Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	try {
		LoginLocators.PenActnClosePopup().click();	
    	Thread.sleep(4000);
	}
	catch(Exception e) {
		
	}
	Thread.sleep(5000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	try {
	LoginLocators.typeValue().click();
	}
	catch(Exception e)
	{
		LoginLocators.typeValueEPF().click();
	}
	Thread.sleep(3000);
//	LoginLocators.SelectValue().click();
//	Thread.sleep(3000);
//	LoginLocators.SelectValueDropdown().click();
//	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "Overview Successfully");
	Thread.sleep(8000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.CloseDocument()));
	
	LoginLocators.CloseDocument().click();
	 By locate = By.xpath("//div//img[@class='svg-icon ng-star-inserted']");

		wait.until(ExpectedConditions.presenceOfElementLocated(locate));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		List<WebElement> downloadbtn = getDriver().findElements(locate);	
		Thread.sleep(3000);
		downloadbtn.get(2).click();
		Thread.sleep(3000);
		try {
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Download()));

		
		try {
			LoginLocators.Download().click();			
		 	Thread.sleep(2000);
			String msg = LoginLocators.MessageDisplayed().getText();	
			test.log(LogStatus.FAIL, msg);
			LoginLocators.OK().click();
									
		}
		catch(Exception e) {
			Thread.sleep(3000);
			File dir2 = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download			
			Thread.sleep(9000);			
			LoginLocators.Download().click();			
		 	Thread.sleep(18000);
			File dir3 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download		   
	        Thread.sleep(9000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Doc Downloaded.");
			}
		   else
		   {
			   
				test.log(LogStatus.FAIL, "Doc does not Downloaded");
			}		
		   Thread.sleep(5000);
			}
		}
		catch(Exception e) {
			
			test.log(LogStatus.PASS, "Doc not present to download");

		}
		finally {
			LoginLocators.CloseBranchCode().click();
			Thread.sleep(3000);
		}		
		View(test);	
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp1().click();
	Thread.sleep(3000);
	}
	catch(Exception e) {
		
		LoginLocators.ClosePopUp2().click();
		Thread.sleep(3000);
	}	
	
	}
	
else {
		
		test.log(LogStatus.PASS, "Complied Count from grid is 0");

		}
	
	
}
	
	public static void NotComplied(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue().click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
//	    
	    js.executeScript("window.scrollBy(0,300)");
	    Thread.sleep(500);
	    int open = Integer.parseInt(LoginLocators.NotCompliede().getText());	//Reading Dashboard count.	    
	                  
	Thread.sleep(9000);
//	String path = "(//*[local-name()='svg']//*[name()='g' and @class='k-chart-point'])[2]";
//	 List<WebElement> PathNC = getDriver().findElements(By.xpath(path));
//	Actions action = new Actions(getDriver());
//	for(WebElement e : PathNC)
//	{
//		action.moveToElement(e).click().build().perform();
//	}
//		try {	
//			LoginLocators.PenActnClosePopup().click();	
//			Thread.sleep(2000);
//	Thread.sleep(2000);
//		}
//		catch(Exception e) {
//			
//		}
   			
	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								
	String compliancesCount = bits[bits.length - 2];				
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	
	if(count1 == open)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Not Complied Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Not Complied Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	
	Thread.sleep(2000);
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	LoginLocators.typeValue().click();
	Thread.sleep(3000);
	LoginLocators.SelectValue().click();
	Thread.sleep(3000);
	try {
	LoginLocators.SelectValueDropdown().click();
	Thread.sleep(3000);
	}
	catch(Exception e) {
		
	}
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	try {
	 By locate = By.xpath("//div//img[@class='svg-icon ng-star-inserted']");

		wait.until(ExpectedConditions.presenceOfElementLocated(locate));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		List<WebElement> downloadbtn = getDriver().findElements(locate);	
		Thread.sleep(3000);
		downloadbtn.get(2).click();
		Thread.sleep(3000);
	}
	catch(Exception e) {
		
	}
		try {
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Download()));

		
		try {
			LoginLocators.Download().click();			
		 	Thread.sleep(2000);
			String msg = LoginLocators.MessageDisplayed().getText();	
			test.log(LogStatus.FAIL, msg);
			LoginLocators.OK().click();
									
		}
		catch(Exception e) {
			Thread.sleep(3000);
			File dir2 = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents1 = dir2.listFiles();						
			Thread.sleep(9000);			
			LoginLocators.Download().click();			
		 	Thread.sleep(18000);
			File dir3 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						   
	        Thread.sleep(9000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Doc Downloaded.");
			}
		   else
		   {
			   
				test.log(LogStatus.FAIL, "Doc does not Downloaded");
			}		
		   Thread.sleep(5000);
			}
		}
		catch(Exception e) {
			
			test.log(LogStatus.PASS, "Doc not present to download");

		}
		finally {
			LoginLocators.CloseBranchCode().click();
			Thread.sleep(3000);
		}		
		View(test);	
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp1().click();
	Thread.sleep(3000);
	}
	catch(Exception e) {
		
		LoginLocators.ClosePopUp2().click();
		Thread.sleep(3000);
	}	
	}
else {
		
		test.log(LogStatus.PASS, "Not Complied Count from grid is 0");

		}
	
	
}
	
	
	public static void View( ExtentTest test) throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));

	By locate = By.xpath("//div//img[@class='svg-icon ng-star-inserted']");

	wait.until(ExpectedConditions.presenceOfElementLocated(locate));
	Thread.sleep(4000);
	// retrieving "foo-button" HTML element
	List<WebElement> downloadbtn = getDriver().findElements(locate);	
	Thread.sleep(3000);
	downloadbtn.get(3).click();
	Thread.sleep(3000);	
	try {
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Download()));
	//wait.until(ExpectedConditions.visibilityOf(LoginLocators.CloseBranchCode()));

	try {
		LoginLocators.Download().click();			
	 	Thread.sleep(5000);
	 	LoginLocators.ClosePopUp3().click();
		Thread.sleep(3000);
        test.log(LogStatus.PASS, "View Successfully");		
	}	
	catch(Exception e) {
		String msg = LoginLocators.MessageDisplayed1().getText();	
		test.log(LogStatus.FAIL, msg);
		LoginLocators.OK().click();
		}
	}
	catch(Exception e)
	{
		
	}
	finally {
	LoginLocators.CloseBranchCode().click();
	Thread.sleep(3000);
	}
}
	
	public static void ApplicableStatues(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    
	    js.executeScript("window.scrollBy(0,500)");
	    if(LoginLocators.ApplicableStatues().isDisplayed())
	    {
	    	LoginLocators.Applicablestatus().getText();
	    	test.log(LogStatus.PASS, "Applicable Statued tab displayed on dashboard");
    	
	    }
	    else {
	    	test.log(LogStatus.FAIL, "Applicable Statued tab does not displayed on dashboard");

	    }
	
	}
	
	public static void DailyUpdate(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(5000); Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
//		LoginLocators.SelectPeriodDashboard().click();
		
		Thread.sleep(2000);
//		LoginLocators.SelectPeriodValue1().click();
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    
	    js.executeScript("window.scrollBy(0,2000)");
	    if(LoginLocators.DailyUpdateHeader().isDisplayed())
	    {
	    	//String dly = LoginLocators.DailyUpdate().getText();
	    	//test.log(LogStatus.PASS, "Daily Update ="+dly);
	    	Thread.sleep(4000);
	    	LoginLocators.DailyUpdateReadMoreLink().click();
	    	test.log(LogStatus.PASS, "Daily Update Read More link is working fine");
    	
	    }
	    else {
	    	test.log(LogStatus.FAIL, "Daily Update Read More link is not working");

	    }
	
	}
	public static void Brows(ExtentTest test) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		
		LoginLocators.Search().sendKeys("AVACORED5");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(20000);
		LoginLocators.Brows().click();
		
		Runtime.getRuntime().exec("C:\\Users\\shitalb\\Documents\\UploadFile.exe");
		Thread.sleep(20000);
		LoginLocators.Button().click();
		test.log(LogStatus.PASS, "pass");

		
	}
	
	
	public static void ComplianceFilter1( ExtentTest test,String user) throws InterruptedException
	{
		
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
//		waitForLoaderToDisappear(); // 
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(5000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
		LoginLocators.ComplianceBox().click();					                
        Thread.sleep(2000);
	   
       LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranchnew().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue3().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue3().click();
       Thread.sleep(2000);
       
       LoginLocators.ActFilter().click();
       Thread.sleep(3000);
       String act =LoginLocators.ActFilterValue().getText();
       Thread.sleep(2000);
       LoginLocators.ActFilterValue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyButton().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        li.add(act);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		filter.add("Act");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		List<WebElement> actcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[4]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
				if(i==1)
				{
					raw.addAll(actcol);
				}
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Mohali_Branch Punjab")
						 ||text.get(l).equalsIgnoreCase("Branch Punjab")
						 ||text.get(l).equalsIgnoreCase("Mines Act, 1952 and Mines Rules, 1955"))
							
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
	}
	public static void UpcomingFilter( ExtentTest test,String user) throws InterruptedException
	{
		
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(5000);	Thread.sleep(5000);	Thread.sleep(5000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(8000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		Thread.sleep(10000);
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(5000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
		LoginLocators.UpcomingBox().click();				                
        Thread.sleep(6000);
	   
        
       wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectBranch())); 
       
       LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranchn().click();
       Thread.sleep(3000);
       String branch =LoginLocators.BranchvalueCheckbox().getText();
       Thread.sleep(2000);
       LoginLocators.BranchvalueCheckbox().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(6000);

		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));
		
		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Jayanagar III Block_TTTT")||text.get(l).equalsIgnoreCase("PUN Branch"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
	}
	public static void OverdueFilter( ExtentTest test,String user) throws InterruptedException
	{
		
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(5000);	Thread.sleep(5000);	Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		Thread.sleep(8000);
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(5000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
		LoginLocators.OverdueBox().click();				                
        Thread.sleep(6000);
	   
        wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectBranch()));
        
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranchSecond().click();
       Thread.sleep(3000);
       String branch =LoginLocators.BranchvalueCheckbox().getText();
       Thread.sleep(2000);
       LoginLocators.BranchvalueCheckbox().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));
		
		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Branch Punjab")||text.get(l).equalsIgnoreCase("tcs in hinjewadi"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
	}

	public static void PendingActionFilter( ExtentTest test,String user) throws InterruptedException
	{
		
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(5000);	Thread.sleep(5000);	Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(5000);
		LoginLocators.SelectPeriodValue2024().click();
		Thread.sleep(9000);
		LoginLocators.PendingActionBox().click();				                
        Thread.sleep(10000);
	   
        wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectBranch()));
        
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranchSecond().click();
       Thread.sleep(3000);
       String branch =LoginLocators.BranchvalueCheckbox().getText();
       Thread.sleep(10000);
       LoginLocators.BranchvalueCheckbox().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(6000);
		
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Branch Punjab")||text.get(l).equalsIgnoreCase("Branch Gujarat"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
	}

	//Bilal
	public static void CompliedChecking(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
//		LoginLocators.SelectPeriodValue1().click();
		LoginLocators.SelectPeriodValue2024().click();
		Thread.sleep(9000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    
	    js.executeScript("window.scrollBy(0,300)");
	    Thread.sleep(2000);
		int open = Integer.parseInt(LoginLocators.CompliedCount().getText());	//Reading Dashboard count.
		Thread.sleep(2000);
		//LoginLocators.Complied().getText();
	//	Thread.sleep(2000);		
		String path = "//*[local-name()='svg']//*[name()='g' and @class='k-chart-point']";
		 List<WebElement> PathNC = getDriver().findElements(By.xpath(path));
		Actions action = new Actions(getDriver());
		for(WebElement e : PathNC)
		{
			action.moveToElement(e).click().build().perform();
		}
			try {	
				LoginLocators.PenActnClosePopup().click();	
				Thread.sleep(2000);
		Thread.sleep(2000);
			}
			catch(Exception e) {
				
			}
		
   			
	String item = LoginLocators.TotalNumberOfItems().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);
	String s = LoginLocators.TotalNumberOfItems().getText();
	Thread.sleep(1000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
	Thread.sleep(4000);
	
	if(count1 == open)
				
	{
					
	//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
					
	test.log(LogStatus.PASS, "Complied Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
				
	else
				
	{
					
	//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
					
	test.log(LogStatus.FAIL, "Complied Dashboard Count = "+open+" | Displayed records from grid = "+count1);
				
	}
	try {
		LoginLocators.PenActnClosePopup().click();	
    	Thread.sleep(4000);
	}
	catch(Exception e) {
		
	}
	
	LoginLocators.BrachCode().click();
	Thread.sleep(3000);
	LoginLocators.type().click();
	Thread.sleep(3000);
	try {
	LoginLocators.typeValue().click();
	}
	catch(Exception e)
	{
		LoginLocators.typeValueEPF().click();
	}
	Thread.sleep(3000);
//	LoginLocators.SelectValue().click();
//	Thread.sleep(3000);
//	LoginLocators.SelectValueDropdown().click();
//	Thread.sleep(3000);
	LoginLocators.ApplyBtn().click();
	Thread.sleep(3000);
	//LoginLocators.displayedrecord().getText();
	Thread.sleep(3000);	
	LoginLocators.ClearBtn().click();
	Thread.sleep(3000);	
	test.log(LogStatus.PASS, "Branch Code Filters working Properly");
	LoginLocators.CloseBranchCode().click();
    JavascriptExecutor jss = (JavascriptExecutor) getDriver();
    
    jss.executeScript("window.scrollBy(0,-1000)");
    Thread.sleep(2000);
    MethodsD.GridAndExcelCountMatch(test,workbook);
	Thread.sleep(3000);
	By locator = By.className("svg-icon");

	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	Thread.sleep(4000);
	WebElement ViewButton = getDriver().findElement(locator);	
	Thread.sleep(3000);
JavascriptExecutor jse=(JavascriptExecutor) getDriver();
jse.executeScript("arguments[0].click();", ViewButton);
	Thread.sleep(4000);
	test.log(LogStatus.PASS, "overView Successfully");
	Thread.sleep(2000);
	LoginLocators.CloseDocument().click();
	 By locate = By.xpath("//div//img[@class='svg-icon ng-star-inserted']");

		wait.until(ExpectedConditions.presenceOfElementLocated(locate));
		Thread.sleep(4000);
		// retrieving "foo-button" HTML element
		List<WebElement> downloadbtn = getDriver().findElements(locate);	
		Thread.sleep(3000);
		downloadbtn.get(2).click();
		Thread.sleep(3000);
		try {
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Download()));

		
		try {
			LoginLocators.Download().click();			
		 	Thread.sleep(2000);
			String msg = LoginLocators.MessageDisplayed().getText();	
			test.log(LogStatus.FAIL, msg);
			LoginLocators.OK().click();
									
		}
		catch(Exception e) {
			Thread.sleep(3000);
			File dir2 = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download			
			Thread.sleep(9000);			
			LoginLocators.Download().click();			
		 	Thread.sleep(18000);
			File dir3 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download		   
	        Thread.sleep(9000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "Doc Downloaded.");
			}
		   else
		   {
			   
				test.log(LogStatus.FAIL, "Doc does not Downloaded");
			}		
		   Thread.sleep(5000);
			}
		}
		catch(Exception e) {
			
			test.log(LogStatus.PASS, "Doc not present to download");

		}
		finally {
			LoginLocators.CloseBranchCode().click();
			Thread.sleep(3000);
		}		
		View(test);	
	Thread.sleep(3000);
	try {
		LoginLocators.ClosePopUp1().click();
	Thread.sleep(3000);
	}
	catch(Exception e) {
		
		LoginLocators.ClosePopUp2().click();
		Thread.sleep(3000);
	}	
	
	}
	
else {
		
		test.log(LogStatus.PASS, "Complied Count from grid is 0");

		}
	
	
}
	
	
	public static void PendingReviewFilter( ExtentTest test,String user) throws InterruptedException
	{
		
		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(5000);
		LoginLocators.SelectPeriodValue2024().click();
		Thread.sleep(9000);
		LoginLocators.PendingReviewBox().click();				                
        Thread.sleep(5000);
	   
       LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       
       
       Thread.sleep(3000);
//     LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
     String branch =LoginLocators.ExpandAllclick().getText(); //clicking to All 
       Thread.sleep(2000);
      LoginLocators.ExpandAllclick().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Test Automation 2")||text.get(l).equalsIgnoreCase("Branch Gujarat"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
	}
	public static void RegisterUpcomingFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(15000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(5000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(9000);
		LoginLocators.RegisterUpcoming().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
        Thread.sleep(3000);
       //LoginLocators.ExpandBranchn().click();
        LoginLocators.ExpandBranchh().click();
        Thread.sleep(3000);
        
 //     String branch =LoginLocators.Branchvaluen().getText();
        Thread.sleep(2000);
 //     LoginLocators.Branchvaluen().click();
        
        String branch =LoginLocators.BranchPune_BranchPune().getText();
        Thread.sleep(2000);
        LoginLocators.BranchPune_BranchPune().click();
        
        Thread.sleep(2000);
        LoginLocators.ApplyBtn1().click();
        Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Jayanagar III Block_TTTT")||text.get(l).equalsIgnoreCase("Branch Pune"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
	}
	
	public static void RegisterOverdueFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.RegisterOverdue().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					//Clicking on Text of total items just to scroll down.
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Gujarat_Branch Gujarat")||text.get(l).equalsIgnoreCase("Branch Gujarat"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
	}
	
	public static void RegisterActionreviewFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.RegisterActionReview().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Gujarat_Branch Gujarat")||text.get(l).equalsIgnoreCase("Branch Gujarat"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
	}
	
	public static void ReturnUpcomingFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.ReturnUpcoming().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Gujarat_Branch Gujarat")||text.get(l).equalsIgnoreCase("Branch Gujarat"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
	}
	
	public static void ReturnOverdueFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.ReturnOverdue().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Gujarat_Branch Gujarat")||text.get(l).equalsIgnoreCase("Branch Gujarat"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
	}
	
	public static void ReturnActionReviewFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.ReturnActionReview().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Gujarat_Branch Gujarat")||text.get(l).equalsIgnoreCase("Branch Gujarat"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
	}
	
	public static void challanUpcomingFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.ChallanUpcoming().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Delhi_Bangalore")||text.get(l).equalsIgnoreCase("Bangalore"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
	}
	
	public static void challanOverdueFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.ChallanOverdue().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					//Clicking on Text of total items just to scroll down.
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Delhi_Bangalore")||text.get(l).equalsIgnoreCase("Bangalore"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
	}
	
	public static void challanActionReviewFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		LoginLocators.ChallanActionReview().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
       Thread.sleep(3000);
       LoginLocators.ExpandBranch().click();
       Thread.sleep(3000);
       String branch =LoginLocators.Branchvalue().getText();
       Thread.sleep(2000);
       LoginLocators.Branchvalue().click();
       Thread.sleep(2000);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
      //  li.add(locationtext);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
			
			  
			
						
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Delhi_Bangalore")||text.get(l).equalsIgnoreCase("Bangalore"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
	}
	
	public static void CompliedFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		
	//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
	//	wait.until(ExpectedConditions.elementToBeClickable(LoginLocators.SelectPeriodDashboard()));
		
	//	By element = By.xpath("//span[@class='k-input-inner']");
	//	wait.until(ExpectedConditions.elementToBeClickable(element));
		
		waitForLoaderToDisappear();
		
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue2024().click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();		

		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(3000);
		String path = "//*[local-name()='svg']//*[name()='g' and @class='k-chart-point']";
		 List<WebElement> PathNC = getDriver().findElements(By.xpath(path));
		Actions action = new Actions(getDriver());
		for(WebElement e : PathNC)
		{
			action.moveToElement(e).click().build().perform();
		}
		Thread.sleep(9000);
//		LoginLocators.PenActnClosePopup().click();	
     	Thread.sleep(4000);
//		LoginLocators.Complied().click();				                
      Thread.sleep(10000);
	   
      wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectBranch()));
      LoginLocators.SelectBranch().click();
      Thread.sleep(3000);
      LoginLocators.ExpandBranchh().click();
      Thread.sleep(3000);
      String branch =LoginLocators.BranchPune_BranchPune().getText();
      Thread.sleep(2000);
      LoginLocators.BranchPune_BranchPune().click();
      Thread.sleep(2000);
       
       LoginLocators.Period().click();
       Thread.sleep(3000);
   //    String period =LoginLocators.PeriodValue().getText();
       Thread.sleep(2000);
       LoginLocators.PeriodValue().click();
       Thread.sleep(2000);
       
       LoginLocators.SelectYear().click();
       Thread.sleep(3000);
   //    String year =LoginLocators.SelectYearvalue().getText();
       Thread.sleep(2000);
       WebElement SelectYearFilter = getDriver().findElement(By.xpath("(//span[normalize-space()='2024'])[3]"));
       SelectYearFilter.click();
    //   LoginLocators.SelectValuetype().click();
       Thread.sleep(2000);
       
   //    String Period = period+year;
   //    System.out.print(Period);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
     //   li.add(Period);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
	//	filter.add("period");
		
		
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
	//	List<WebElement> periodcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[10]"));

		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
				
			
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Branch Pune")||text.get(l).equalsIgnoreCase("ooooooooo"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
		
		
	}
	public static void CompliedHighRiskSummaryFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(5000);
		LoginLocators.SelectPeriodValue2024().click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();		

		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(3000);
//		String path = "//*[local-name()='svg']//*[name()='g' and @class='k-chart-point']";
//		 List<WebElement> PathNC = getDriver().findElements(By.xpath(path));
//		Actions action = new Actions(getDriver());
//		for(WebElement e : PathNC)
//		{
//			action.moveToElement(e).click().build().perform();
//		}
		
		Thread.sleep(5000);
		LocatorsP.CompHighRisk().click();
		
		
		
		Thread.sleep(9000);
//		LoginLocators.PenActnClosePopup().click();	
     	Thread.sleep(4000);
//		LoginLocators.Complied().click();				                
      Thread.sleep(2000);
	   
      LoginLocators.SelectBranch().click();
      Thread.sleep(3000);
      LoginLocators.ExpandBranchh().click();
      Thread.sleep(3000);
      String branch =LoginLocators.BranchPune_BranchPune().getText();
      Thread.sleep(2000);
      LoginLocators.BranchPune_BranchPune().click();
      Thread.sleep(2000);
       
       LoginLocators.Period().click();
       Thread.sleep(3000);
   //    String period =LoginLocators.PeriodValue().getText();
       Thread.sleep(2000);
       LoginLocators.PeriodValue().click();
       Thread.sleep(2000);
       
       LoginLocators.SelectYear().click();
       Thread.sleep(3000);
   //    String year =LoginLocators.SelectYearvalue().getText();
       Thread.sleep(2000);
       LoginLocators.SelectValuetype().click();
       Thread.sleep(2000);
       
   //    String Period = period+year;
   //    System.out.print(Period);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
     //   li.add(Period);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
	//	filter.add("period");
		
		
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
	//	List<WebElement> periodcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[10]"));

		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
				
			
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Branch Pune")||text.get(l).equalsIgnoreCase("ooooooooo"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
		Thread.sleep(5000);
		//Code for Clear button
		if(LoginLocators.Clear().isEnabled())
		{
			LoginLocators.Clear().click();
			test.log(LogStatus.PASS,"Clear button is working fine");	
		}
		else
		{
			test.log(LogStatus.FAIL,"Clear button is not working");
		}
		
		
		//View button:
		Thread.sleep(5000);
		if(LoginLocators.ViewButton().isEnabled())
		{
			LoginLocators.ViewButton().click();
			Thread.sleep(5000);
			LoginLocators.ViewDocument().click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS,"View button is working fine");	
		}
		else
		{
			test.log(LogStatus.FAIL,"View button is not working");
		}
		
		
	}
	
	public static void CompliedMediumRiskSummaryFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(5000);	Thread.sleep(5000);	Thread.sleep(5000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(5000);
		LoginLocators.SelectPeriodValue2024().click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();		

		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(3000);
//		String path = "//*[local-name()='svg']//*[name()='g' and @class='k-chart-point']";
//		 List<WebElement> PathNC = getDriver().findElements(By.xpath(path));
//		Actions action = new Actions(getDriver());
//		for(WebElement e : PathNC)
//		{
//			action.moveToElement(e).click().build().perform();
//		}
		
		Thread.sleep(5000);
		LocatorsP.CompMediumRisk().click();
		
		
		
		Thread.sleep(9000);
//		LoginLocators.PenActnClosePopup().click();	
     	Thread.sleep(4000);
//		LoginLocators.Complied().click();				                
      Thread.sleep(2000);
	   
      LoginLocators.SelectBranch().click();
      Thread.sleep(3000);
      LoginLocators.ExpandBranchh().click();
      Thread.sleep(3000);
      String branch =LoginLocators.BranchPune_BranchPune().getText();
      Thread.sleep(2000);
      LoginLocators.BranchPune_BranchPune().click();
      Thread.sleep(2000);
       
       LoginLocators.Period().click();
       Thread.sleep(3000);
   //    String period =LoginLocators.PeriodValue().getText();
       Thread.sleep(2000);
       LoginLocators.PeriodValue().click();
       Thread.sleep(2000);
       
       LoginLocators.SelectYear().click();
       Thread.sleep(3000);
   //    String year =LoginLocators.SelectYearvalue().getText();
       Thread.sleep(2000);
       LoginLocators.SelectValuetype().click();
       Thread.sleep(2000);
       
   //    String Period = period+year;
   //    System.out.print(Period);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
     //   li.add(Period);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
	//	filter.add("period");
		
		
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
	//	List<WebElement> periodcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[10]"));

		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
				
			
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Branch Pune")||text.get(l).equalsIgnoreCase("ooooooooo"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
		Thread.sleep(5000);
		//Code for Clear button
		if(LoginLocators.Clear().isEnabled())
		{
			LoginLocators.Clear().click();
			test.log(LogStatus.PASS,"Clear button is working fine");	
		}
		else
		{
			test.log(LogStatus.FAIL,"Clear button is not working");
		}
		
		
		//View button:
		Thread.sleep(5000);
		if(LoginLocators.ViewButton().isEnabled())
		{
			LoginLocators.ViewButton().click();
			Thread.sleep(5000);
			LoginLocators.ViewDocument().click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS,"View button is working fine");	
		}
		else
		{
			test.log(LogStatus.FAIL,"View button is not working");
		}
		
		
	}
	public static void CompliedLowRiskSummaryFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(5000);	Thread.sleep(5000);	Thread.sleep(5000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(5000);
		LoginLocators.SelectPeriodValue2024().click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();		

		js.executeScript("window.scrollBy(0,300)");	
		Thread.sleep(3000);
//		String path = "//*[local-name()='svg']//*[name()='g' and @class='k-chart-point']";
//		 List<WebElement> PathNC = getDriver().findElements(By.xpath(path));
//		Actions action = new Actions(getDriver());
//		for(WebElement e : PathNC)
//		{
//			action.moveToElement(e).click().build().perform();
//		}
		
		Thread.sleep(5000);
		LocatorsP.CompLowRisk().click();
		
		
		
		Thread.sleep(9000);
//		LoginLocators.PenActnClosePopup().click();	
     	Thread.sleep(4000);
//		LoginLocators.Complied().click();				                
      Thread.sleep(2000);
	   
      LoginLocators.SelectBranch().click();
      Thread.sleep(3000);
      LoginLocators.ExpandBranchh().click();
      Thread.sleep(3000);
      String branch =LoginLocators.BranchPune_BranchPune().getText();
      Thread.sleep(2000);
      LoginLocators.BranchPune_BranchPune().click();
      Thread.sleep(2000);
       
       LoginLocators.Period().click();
       Thread.sleep(3000);
   //    String period =LoginLocators.PeriodValue().getText();
       Thread.sleep(2000);
       LoginLocators.PeriodValue().click();
       Thread.sleep(2000);
       
       LoginLocators.SelectYear().click();
       Thread.sleep(3000);
   //    String year =LoginLocators.SelectYearvalue().getText();
       Thread.sleep(2000);
       LoginLocators.SelectValuetype().click();
       Thread.sleep(2000);
       
   //    String Period = period+year;
   //    System.out.print(Period);
       LoginLocators.ApplyBtn1().click();
       Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
     //   li.add(Period);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
	//	filter.add("period");
		
		
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
	//	List<WebElement> periodcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[10]"));

		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
				
			
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("Branch Pune")||text.get(l).equalsIgnoreCase("ooooooooo"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
		Thread.sleep(5000);
		//Code for Clear button
		if(LoginLocators.Clear().isEnabled())
		{
			LoginLocators.Clear().click();
			test.log(LogStatus.PASS,"Clear button is working fine");	
		}
		else
		{
			test.log(LogStatus.FAIL,"Clear button is not working");
		}
		
		
		//View button:
		Thread.sleep(5000);
		if(LoginLocators.ViewButton().isEnabled())
		{
			LoginLocators.ViewButton().click();
			Thread.sleep(5000);
			LoginLocators.ViewDocument().click();
			Thread.sleep(5000);
			test.log(LogStatus.PASS,"View button is working fine");	
		}
		else
		{
			test.log(LogStatus.FAIL,"View button is not working");
		}
		
		
	}
	
	public static void CompliedRiskSummaryGraphFilter( ExtentTest test,String user) throws InterruptedException
	{		
		WebDriverWait wait = new WebDriverWait( getDriver(),(60));
		Thread.sleep(3000);	
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    
	    js.executeScript("window.scrollBy(0,300)");
	    Thread.sleep(2000);
	    LocatorsP.HighRisk1().click();				                
        Thread.sleep(2000);
	   
        LoginLocators.SelectBranch().click();
        Thread.sleep(3000);
        LoginLocators.ExpandBranchh().click();
        Thread.sleep(3000);
        String branch =LoginLocators.Branchval().getText();
        Thread.sleep(2000);
        LoginLocators.Branchval().click();
        Thread.sleep(2000);
         
         LoginLocators.Period().click();
         Thread.sleep(3000);
     //    String period =LoginLocators.PeriodValue().getText();
         Thread.sleep(2000);
         LoginLocators.PeriodValue().click();
         Thread.sleep(2000);
         
         LoginLocators.SelectYear().click();
         Thread.sleep(3000);
     //    String year =LoginLocators.SelectYearvalue().getText();
         Thread.sleep(2000);
         LoginLocators.SelectValuetype().click();
         Thread.sleep(2000);
         
     //    String Period = period+year;
     //    System.out.print(Period);
         LoginLocators.ApplyBtn1().click();
         Thread.sleep(2000);
       
        List<String> li=new ArrayList<String>();
        
     //   li.add(Period);
        li.add(branch);
        
        Thread.sleep(3000);
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
	//	filter.add("period");
		
		
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]"));
	//	List<WebElement> periodcol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[10]"));

		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();
				if(i==0)
				{
					raw.addAll(branchcol);
				}
				
			
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==0)
					{
						if(text.get(l).equalsIgnoreCase("guntur_ooooooooo")||text.get(l).equalsIgnoreCase("ooooooooo"))
						{
						  pass.add(text.get(l));
						}
						else
						{
							 fail.add(text.get(l));
						}
					}
					
					else
					{
						
					
				if(text.get(l).equals(li.get(i)))
					{
					
					
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));
					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);
				}
				 }
				}
		
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records found");	
		}
		
	}
	
	
	public static void Report(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.Report().click();
		Thread.sleep(2000);
//		LoginLocators.Branch().click();
		Thread.sleep(2000);
//		LoginLocators.BranchValue().click();
		Thread.sleep(2000);
		LoginLocators.ComplianceType().click();
		Thread.sleep(2000);
		LoginLocators.SelectValuetype().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
	    Thread.sleep(9000);
	    
	    
	//	MethodsD.GridAndExcelCountMatch1(test,workbook);
		
/*		OneCommonMethod.validateExportedExcel(
			    driver.get(),
			    test,
			    LoginLocators.Exportbtn(),            // Export button WebElement
			    LoginLocators.TotalNoOfItem(),   // Count ka dynamic locator
			    "Act Name"                                  //Header Name
			); */
	    
	    OneCommonMethod.validateExportedExcelDYNAMIC(
	    	    driver.get(),
	    	    test,
	    	    LoginLocators.Exportbtn(),        // WebElement for export button
	    	    LoginLocators.TotalNoOfItem(),     // WebElement for grid count text
	    	    "Act Name",                               // Column header to verify
	    	    "Registers report exported successfully"     // Success log text (only if PASS)
	    	);

		
		Thread.sleep(3000);
		LoginLocators.ClearButton().click();
	    Thread.sleep(9000);
			
	
	}
	
	public static void CLRAAssignmentReport(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.Report().click();
		Thread.sleep(2000);
		
		LoginLocators.CLRAAssignReport().click();
		Thread.sleep(2000);
		LoginLocators.Branch2().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue4().click();
		Thread.sleep(2000);			
		LoginLocators.selecttype().click();
		Thread.sleep(2000);
		LoginLocators.TypeValue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyBtn1().click();
	    Thread.sleep(9000);
	    MethodsD.GridAndExcelCountMatch3(test,workbook);
		Thread.sleep(3000);
	    LoginLocators.Clearbtn1().click();
	    Thread.sleep(9000);
	}

	
	public static void VariousReport(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.Report().click();
		Thread.sleep(2000);
		
		 LoginLocators.VariousReport().click();
			Thread.sleep(2000);
			LoginLocators.VariousType().click();
			Thread.sleep(2000);
			LoginLocators.VariousTypeValue().click();
			Thread.sleep(2000);
//			LoginLocators.Calender().click();
//			Thread.sleep(2000);
//			LoginLocators.Calenderyear().click();
//			Thread.sleep(2000);
//			LoginLocators.CalenderMonth().click();
//			Thread.sleep(2000);
			LoginLocators.ApplyBtn2().click();
		    Thread.sleep(9000);
		    MethodsD.GridAndExcelCountMatch3(test,workbook);
			Thread.sleep(3000);
			
	}

	
	
	public static void StatusReport(ExtentTest test,String user) throws InterruptedException, IOException
	{
	

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO2");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(9000);
		LoginLocators.Report().click();
		Thread.sleep(2000);
		
		 LoginLocators.StatusReport().click();
			Thread.sleep(2000);
			LoginLocators.Branch1().click();
			Thread.sleep(2000);
			LoginLocators.BranchCheckBox().click();
			Thread.sleep(2000);
			LoginLocators.Monthly().click();
			Thread.sleep(2000);
			LoginLocators.MonthlyValue2().click();
			Thread.sleep(2000);
			LoginLocators.Year().click();
			Thread.sleep(2000);
			LoginLocators.Yearvalue().click();
			Thread.sleep(2000);
			LoginLocators.period().click();
			Thread.sleep(2000);
			LoginLocators.Yearvalue().click();//period value
			Thread.sleep(2000);
			LoginLocators.Status().click();
			Thread.sleep(2000);
			LoginLocators.Yearvalue().click();//period value
			Thread.sleep(2000);
			LoginLocators.ApplyBtn1().click();
		    Thread.sleep(9000);
		    MethodsD.GridAndExcelCountMatch2(test,workbook);
			Thread.sleep(3000);
		    
//		    File dir = new File("C:\\Users\\bilali\\Downloads");
//			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
//			
//			Thread.sleep(3000);
//			try {
//			    LoginLocators.Export().click();
//			    Thread.sleep(20000);
//			    }
//			    catch(Exception e)
//			    {
//			    	LoginLocators.Exportbtn().click();
//			    	Thread.sleep(20000);
//			    	
//			    	}		
//		 	Thread.sleep(9000);
//			File dir1 = new File("C:\\Users\\bilali\\Downloads");
//			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
//			
//			Thread.sleep(3000);
//		  
//	        
//		   if (dirContents.length < allFilesNew.length) {
//			    test.log(LogStatus.PASS, "Status Report : File downloaded successfully.");
//			}
//		   else
//		   {
//			    test.log(LogStatus.FAIL, "Status Report : File Does not downloaded successfully.");
//			}
//		   Thread.sleep(1000);
		        LoginLocators.Clearbtn1().click();
			    Thread.sleep(2000);
	}
	
	public static void PendingActionPerform( ExtentTest test,String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue().click();
		Thread.sleep(2000);
		int open = Integer.parseInt(LoginLocators.PendingActionBox().getText());	
	    Thread.sleep(2000);
	    LoginLocators.PendingActionBox().click();
	    Thread.sleep(2000);
	    LoginLocators.PendingActionEdit().click();	
	    Thread.sleep(9000);
	    
	    LoginLocators.ClickBrowse().click();
		Thread.sleep(8000);
		// Specify the file path
	    String filePath = "E:\\Labor Upload\\ContractsList__MyWorkspace (1).pdf";
	    StringSelection selection = new StringSelection(filePath);

	    // Copy file path to clipboard
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
	    Thread.sleep(2000);
	    // Use Robot class to paste the file path and press Enter
	    Robot robot = new Robot();
	    
	    // Simulate CTRL + V (Paste)
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    
	    // Press Enter to confirm the upload
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(500);
	    
	    
	    
//        LoginLocators.Brows().click();		
//		Runtime.getRuntime().exec("E:\\Labor Upload\\Laborfile.exe");
		Thread.sleep(2000);
		LoginLocators.Upload().click();
		Thread.sleep(2000);
		String  msg= LoginLocators.UploadSuccessfully().getText();
		LoginLocators.OK().click();
	    test.log(LogStatus.PASS, msg);
	    Thread.sleep(2000);
	    
	    LoginLocators.ComplianceRadioButton().click();
	    Thread.sleep(2000);
	    LoginLocators.ClickBrowse().click();
		Thread.sleep(8000);
		// Specify the file path
	    String filePath1 = "E:\\Labor Upload\\ContractsList__MyWorkspace (1) (1).pdf";
	    StringSelection selection1 = new StringSelection(filePath1);
//
//	    // Copy file path to clipboard
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection1, null);
	    Thread.sleep(2000);
	    // Use Robot class to paste the file path and press Enter
	    
	    // Simulate CTRL + V (Paste)
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    
	    // Press Enter to confirm the upload
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		LoginLocators.Upload().click();
		Thread.sleep(2000);
		LoginLocators.OK().click();
	    Thread.sleep(2000);
	    
	    LoginLocators.Submit().click();
	    Thread.sleep(4000);
		String  msgdisplayed= LoginLocators.UploadSuccessfully().getText();
		if(msgdisplayed.equalsIgnoreCase("Submitted Successfully"))
		{
			test.log(LogStatus.PASS, msgdisplayed);
		}
		else {
			test.log(LogStatus.FAIL, msgdisplayed);

		}
		LoginLocators.OK().click();
		Thread.sleep(4000);
		LoginLocators.PenActnClosePopup().click();
		Thread.sleep(4000);
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		int count = Integer.parseInt(LoginLocators.PendingActionBox().getText());	

		if(open == (open-1))
			
		{
						
		//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
						
		test.log(LogStatus.PASS, "Before perform action Count = "+open+" | After perform action Count = "+count);
					
		}
					
		else
					
		{
						
		//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
						
		test.log(LogStatus.FAIL, "Before perform action Count = "+open+" | After perform action Count = "+count);
					
		}
		    
	

	}
	public static void PendingReviewAction( ExtentTest test,String user) throws InterruptedException, IOException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
	//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
	//	LoginLocators.Search().sendKeys("WWKRG");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodDashboard().click();
		Thread.sleep(2000);
		LoginLocators.SelectPeriodValue1().click();
		Thread.sleep(2000);
		int open = Integer.parseInt(LoginLocators.PendingReviewBox().getText());	
	    Thread.sleep(2000);
	    LoginLocators.PendingReviewBox().click();
	    Thread.sleep(2000);
	    LoginLocators.PendingActionEdit().click();	
	    Thread.sleep(9000);
        LoginLocators.ClosedDelayed().click();		
        Thread.sleep(3000);
//        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", LoginLocators.Remark());
		LoginLocators.Remark().sendKeys("Nill");
		 Thread.sleep(2000);
		 LoginLocators.Calender1().click();
		 Thread.sleep(2000);
		 LoginLocators.CalenderDate().click();
		 Thread.sleep(2000);
	//	LoginLocators.Submitt().click();
	//	Thread.sleep(2000);
		LoginLocators.Reject().click();
		Thread.sleep(2000);
//		LoginLocators.Closebtn().click();
//		Thread.sleep(2000);
		String  msg= LoginLocators.UploadSuccessfully().getText();
//		LoginLocators.OK().click();
//	    test.log(LogStatus.PASS, msg);
	    Thread.sleep(2000);
//	    LoginLocators.Submit().click();
//	    Thread.sleep(4000);
		String  msgdisplayed= LoginLocators.UploadSuccessfully().getText();
		if(msgdisplayed.equalsIgnoreCase("Submitted Successfully") || msgdisplayed.equalsIgnoreCase("Rejected Successfully"))
		{
			test.log(LogStatus.PASS, msgdisplayed);
		}
		else {
			test.log(LogStatus.FAIL, msgdisplayed);

		}
		LoginLocators.OK().click();
		Thread.sleep(4000);	
		LoginLocators.Closebtn().click();
		Thread.sleep(2000);
		LoginLocators.ClosePopup().click();
		Thread.sleep(2000);	
		int count = Integer.parseInt(LoginLocators.PendingReviewBox().getText());	

		if(open == (open-1))
			
		{
						
		//test.log(LogStatus.PASS, type+" count matches to number of records displayed.");
						
		test.log(LogStatus.PASS, "Before Review action Count = "+open+" | After Review action Count = "+count);
					
		}
					
		else
					
		{
						
		//test.log(LogStatus.FAIL, type+" count doesn't matches to number of records displayed.");
						
		test.log(LogStatus.FAIL, "Before Review action Count = "+open+" | After Review action Count = "+count);
					
		}
		
	}
	
	public static void Viewworspace( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 if (LoginLocators.View().isDisplayed()) {
				WebDriverWait wait = new WebDriverWait(getDriver(), (120));
				wait.until(ExpectedConditions.visibilityOf(LoginLocators.View()));
	        	LoginLocators.View().click();
	    	    Thread.sleep(500);
				test.log(LogStatus.PASS,  "View Successfully");
	    	    LoginLocators.ClosePopup().click();
	    	    Thread.sleep(500);
	    	    
		 }
	}
	
	public static void WorkspaceRegister( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	


	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
		try {
		MethodsD.Viewworspace(test,user);
		}
		catch(Exception e) {
			
		}
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		try {
       if(LoginLocators.AttendaceText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.AttendaceText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Attendance Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Attendance Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "D:\\Upload Automation Files\\WorkSpace\\AttendanceFile.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

    	        // Use Robot class to paste the file path and press Enter
    	        Robot robot = new Robot();
    	        
    	        // Simulate CTRL + V (Paste)
    	        robot.keyPress(KeyEvent.VK_CONTROL);
    	        robot.keyPress(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_CONTROL);
    	        
    	        // Press Enter to confirm the upload
                robot.keyPress(KeyEvent.VK_ENTER);
    	        robot.keyRelease(KeyEvent.VK_ENTER);

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   if(attendance.equalsIgnoreCase("File uploaded successfully"))
    		   {
    			   test.log(LogStatus.PASS, "Attendance "+ attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL,  "Attendance "+ attendance);

    		   }
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
      			//getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		//   test.log(LogStatus.PASS,  "Attendance "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));
    			Thread.sleep(2000);	
    		//   LoginLocators.UploadedGreenTick().click();
//    		   // Locate the element using the provided XPath
    	  //      WebElement greenTick = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']//td/following-sibling::td/following-sibling::td/following-sibling::td"));

    	        if (Uploadgreentick.isDisplayed()) {
    	        	
    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			System.out.println("Processed Green tick is displayed.");
    	        			
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }
////////////////
            }
            
		}	
}
else {
	
	test.log(LogStatus.PASS, "The attendance template is not available for upload.");	

}
		
		
		   
		}
		
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Attendance Not present");

		}
		
		MethodsD.Salary(test, user);	
		Thread.sleep(20000);	
		MethodsD.LeaveSummaryDetails(test, user);
		Thread.sleep(2000);	
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		LoginLocators.Refresh().click();
		Thread.sleep(2000);
        LoginLocators.Check().click();
		   Thread.sleep(9000);
		  // LoginLocators.OK().click();
		 //  Thread.sleep(2000);	
		   LoginLocators.Refresh().click();
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.GenerateDocument()));
		LoginLocators.Refresh().click();
		   LoginLocators.GenerateDocument().click();
		   Thread.sleep(2000);	
		   String msg = LoginLocators.GenerationMsg().getText();
			test.log(LogStatus.PASS, msg);	
			LoginLocators.OK().click();
			   Thread.sleep(2000);	
		
		 
	}
	public static void WorkspaceChallanAct( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(1000);
 
/*		LoginLocators.SelectChallan().click();
        Thread.sleep(3000);
        LoginLocators.Act().click();
        Thread.sleep(3000);
        
        //txt & txt2 & txt3 same xpath need to modify if changed
        String txt = getDriver().findElement(By.xpath("//kendo-list//ul/li")).getText();

        if (txt.equalsIgnoreCase("Employee Provident Fund Act") || 
            txt.equalsIgnoreCase("Employee State Insurance Act") || 
            txt.equalsIgnoreCase("Professional Tax Act")) 
        {
            
        	test.log(LogStatus.PASS, "On Selcting Challan Act dropdown values are displayed");
        	//test.log(LogStatus.PASS, );
        }
        else
        {
        	test.log(LogStatus.FAIL, "On Selcting Challan Act dropdown values not displayed");
        }
        
        LoginLocators.Clear().click();
        
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(1000);
        LoginLocators.ClickRegister().click();
        Thread.sleep(3000);
        LoginLocators.Act().click();
        Thread.sleep(3000);
        
        String txt2 = getDriver().findElement(By.xpath("//kendo-list//ul/li")).getText();

        if (txt2.equalsIgnoreCase("Shops and Establishment and Allied Acts") || 
            txt2.equalsIgnoreCase("Factory and Allied Acts") || 
            txt2.equalsIgnoreCase("Shops/Contract Labour Regulation & Abolition Act") ||
            txt2.equalsIgnoreCase("Factory/Contract Labour Regulation & Abolition Act")) 
        {
            
        	test.log(LogStatus.PASS, "On Selcting Register Act dropdown values are displayed");
        	//test.log(LogStatus.PASS, );
        }
        else
        {
        	test.log(LogStatus.FAIL, "On Selcting Register Act dropdown values not displayed");
        }
        LoginLocators.Clear().click();
        
        
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(1000);
		LoginLocators.SelectReturnn().click();
		Thread.sleep(1000);
        LoginLocators.FrequencyDropdown().click();
        Thread.sleep(3000);
        LoginLocators.FrequencyQuarterly().click();
        Thread.sleep(3000);
        LoginLocators.Act().click();
        Thread.sleep(3000);
        
        String txt3 = getDriver().findElement(By.xpath("//kendo-list//ul/li")).getText();
        
        if (txt3.equalsIgnoreCase("Employee's Compensation Act, 1923") || 
                txt3.equalsIgnoreCase("Employment Exchange (Compulsory Notification of Vacancies) Act, 1959") || 
                txt3.equalsIgnoreCase("Labor Welfare Fund Act, 1965") ||
                txt3.equalsIgnoreCase("Shops & Commercial Establishment Act") ||
                txt3.equalsIgnoreCase("Shops/Contract Labour Regulation & Abolition Act") || 
        	    txt3.equalsIgnoreCase("The Factories Act, 1948")) 
            {
                
            	test.log(LogStatus.PASS, "On Selcting Return Act dropdown values are displayed");
            	//test.log(LogStatus.PASS, );
            }
            else
            {
            	test.log(LogStatus.FAIL, "On Selcting Return Act dropdown values not displayed");
            }

		*/
		
        try {
            Thread.sleep(5000);

            // Get dropdown options
            List<WebElement> actOptions = getDriver().findElements(By.xpath("//span[@class='k-list-item-text']"));
            List<String> actualActs = new ArrayList<>();

            for (WebElement option : actOptions) {
                String actText = option.getText().trim();
                test.log(LogStatus.PASS, "Found Act: " + actText);
                actualActs.add(actText);
            }

            // Expected Acts
            List<String> expectedActs = Arrays.asList(
                "Challan",
                "Register",
                "Return"
            );

            // Compare and log missing acts only
            List<String> missingActs = new ArrayList<>();
            for (String expected : expectedActs) {
                if (!actualActs.contains(expected)) {
                    missingActs.add(expected);
                    test.log(LogStatus.FAIL, "Not Found Compliance: - " + expected);
                }
            }

            // Final Result
            if (missingActs.isEmpty()) {
                test.log(LogStatus.PASS, "All expected Compliances are present in the dropdown.");
            }

        } catch (Exception e) {
            
        }
	}
	
	public static void WorkspaceChallanForms( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(1000);
        LoginLocators.SelectChallan().click();
        Thread.sleep(3000);
        LoginLocators.Act().click();
        Thread.sleep(1000);
        LoginLocators.SelectChallanEPF().click();
        Thread.sleep(1000);
        LoginLocators.YearDrp().click();
        Thread.sleep(1000);
        LoginLocators.Year2024().click();
        Thread.sleep(1000);
        LoginLocators.PeriodDrp().click();
        Thread.sleep(1000);
        LoginLocators.PeriodJan().click();
        Thread.sleep(1000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(1000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
        WebElement viewbutton = getDriver().findElement(By.xpath("//img[@title='View']"));
        System.out.println(viewbutton);
        
        Thread.sleep(6000);
        if(viewbutton.isDisplayed())
        {
        	test.log(LogStatus.PASS, "Challans Forms are displayed");
        }
        else
        {
        	test.log(LogStatus.FAIL, "Challans Forms are not displayed");
        }
        
		
	}
	public static void WorkspaceRegistersForms( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(1000);
        LoginLocators.ClickRegisterDrp().click();
        Thread.sleep(3000);
        LoginLocators.Act().click();
        Thread.sleep(1000);
        LoginLocators.SelectRegisterSEA().click();
        Thread.sleep(1000);
        LoginLocators.YearDrp().click();
        Thread.sleep(1000);
        LoginLocators.Year2024().click();
        Thread.sleep(1000);
        LoginLocators.PeriodDrp().click();
        Thread.sleep(1000);
        LoginLocators.PeriodJan().click();
        Thread.sleep(1000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(1000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
        WebElement viewbutton = getDriver().findElement(By.xpath("//img[@title='View']"));
        System.out.println(viewbutton);
        
        Thread.sleep(6000);
        if(viewbutton.isDisplayed())
        {
        	test.log(LogStatus.PASS, "Registers Forms are displayed");
        }
        else
        {
        	test.log(LogStatus.FAIL, "Registers Forms are not displayed");
        }
		
	}
	public static void WorkspaceRegistersSingleFormSelection( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(1000);
        LoginLocators.ClickRegisterDrp().click();
        Thread.sleep(3000);
        LoginLocators.Act().click();
        Thread.sleep(1000);
        LoginLocators.SelectRegisterSEA().click();
        Thread.sleep(1000);
        LoginLocators.YearDrp().click();
        Thread.sleep(1000);
        LoginLocators.Year2024().click();
        Thread.sleep(1000);
        LoginLocators.PeriodDrp().click();
        Thread.sleep(1000);
        LoginLocators.PeriodJan().click();
        Thread.sleep(1000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(1000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
		WebElement allCB=getDriver().findElement(By.xpath("//div[@class='header-checkbox']"));
		
		WebElement singleCB=getDriver().findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		
		WebElement InputFileView=getDriver().findElement(By.xpath("(//img[@title='View'])[1]"));
		
		
		if(singleCB.isDisplayed() && allCB.isDisplayed() && InputFileView.isDisplayed())
		{
			allCB.click();
			Thread.sleep(6000);
			test.log(LogStatus.PASS, "Select all check box is working properly");
			allCB.click();
			Thread.sleep(5000);
			singleCB.click();
			test.log(LogStatus.PASS, "Select single check box is working properly");
			Thread.sleep(5000);
			InputFileView.click();
			test.log(LogStatus.PASS, "Input file view button is working properly");
		}
		else
		{
			test.log(LogStatus.FAIL, "Grid data is not displayed");
		}
		
	}
	public static void WorkspaceProceedBtn( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(1000);
        LoginLocators.ClickRegisterDrp().click();
        Thread.sleep(3000);
        LoginLocators.Act().click();
        Thread.sleep(1000);
        LoginLocators.SelectRegisterSEA().click();
        Thread.sleep(1000);
        LoginLocators.YearDrp().click();
        Thread.sleep(1000);
        LoginLocators.Year2024().click();
        Thread.sleep(1000);
        LoginLocators.PeriodDrp().click();
        Thread.sleep(1000);
        LoginLocators.PeriodJan().click();
        Thread.sleep(1000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(1000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
		WebElement allCB=getDriver().findElement(By.xpath("//div[@class='header-checkbox']"));
		
		
		List<WebElement> proceedButtons = getDriver().findElements(By.xpath("//button[normalize-space()='Proceed']"));

		if (!proceedButtons.isEmpty() && proceedButtons.get(0).isDisplayed()) {
		    test.log(LogStatus.FAIL, "Without selection of input check box, Proceed button is displayed");
		} else {
		    test.log(LogStatus.PASS, "Without selection of input check box, Proceed button is not displayed");
		}
		
		
	/*	if(LoginLocators.Proceed().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Wihout selection of input check box proceed button is displayed");
		}
		else
		{
			test.log(LogStatus.PASS, "Wihout selection of input check box proceed button is not displayed");
		}*/
		
		
		Thread.sleep(6000);
		allCB.click();
		Thread.sleep(6000);
		if(LoginLocators.Proceed().isDisplayed())
		{
			test.log(LogStatus.PASS, "With selection of input check box proceed button is displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "With selection of input check box proceed button is not displayed");
		}
		Thread.sleep(8000);
		
		LoginLocators.Proceed().click();
		if(LoginLocators.RefreshBtn().isDisplayed())
		{
			test.log(LogStatus.PASS, "Clicking the Proceed button takes the user to the Input Web Upload page.");
		}
		else
		{
			test.log(LogStatus.PASS, "Clicking the Proceed button does not redirect the user to the Input Web Upload page.");
		}
		
		
	}
	
	public static void WorkspaceChallanActs( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(1000);
        LoginLocators.SelectChallan().click();
        Thread.sleep(3000);
        LoginLocators.Act().click();
        Thread.sleep(5000);
        
        
        
//        String texsctt =  getDriver().findElement(By.xpath("//span[@class='k-list-item-text']")).getText();
        
//        System.out.println("TEXT FOUND: " + texsctt);
        
 
       
        
        
        
 /*       try {
            // Click on "Compliance" > "Challan"
//            LoginLocators.ComplianceDropdown().click();
 //           LoginLocators.SelectChallan().click();
            Thread.sleep(1000); // Wait for Act dropdown to populate

            // Click Act dropdown to reveal options
//            LoginLocators.ActDropdown().click();
            Thread.sleep(1000);

            // Fetch all dropdown values
            List<WebElement> actOptions = getDriver().findElements(By.xpath("//span[@class='k-list-item-text']"));
 
            
            List<String> actualActs = new ArrayList<>();

            for (WebElement option : actOptions) {
                System.out.println("Found: " + option.getText());
            }

            
            for (WebElement option : actOptions) {
                actualActs.add(option.getText().trim());
            }

            // Expected list
            List<String> expectedActs = Arrays.asList(
            		"Employee Provident Fund Act",
            		"Employee State Insurance Act",
            		"Professional Tax Act"
            );

            if (actualActs.containsAll(expectedActs)) {
                test.log(LogStatus.PASS, "All expected Acts are present in the dropdown: " + actualActs);
            } else {
                test.log(LogStatus.FAIL, "Missing values. Expected: " + expectedActs + ", but found: " + actualActs);
            }

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Exception occurred: " + e.getMessage());
        }
        */
        
/*        try {
            Thread.sleep(1000); // Wait for dropdown to load

            List<WebElement> actOptions = getDriver().findElements(By.xpath("//span[@class='k-list-item-text']"));
            List<String> actualActs = new ArrayList<>();

            // Print and log each act line by line
            for (WebElement option : actOptions) {
                String actText = option.getText().trim();
                System.out.println("Found: " + actText);
                test.log(LogStatus.INFO, "Found Act: " + actText);    // Each act on separate line
                actualActs.add(actText);
            }

            List<String> expectedActs = Arrays.asList(
                "Employee Provident Fund Act",
                "Employee State Insurance Act",
                "Professional Tax Act",
                "ABC scsc sjisnpoj"
            );

            if (actualActs.containsAll(expectedActs)) {
                test.log(LogStatus.PASS, "All expected Acts are present in the dropdown.");
            } else {
                test.log(LogStatus.FAIL, "Missing values. Expected: " + expectedActs + ", but found: " + actualActs);
            }

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Exception occurred: " + e.getMessage());
        }
*/
        
        try {
            Thread.sleep(5000);

            // Get dropdown options
            List<WebElement> actOptions = getDriver().findElements(By.xpath("//span[@class='k-list-item-text']"));
            List<String> actualActs = new ArrayList<>();

            for (WebElement option : actOptions) {
                String actText = option.getText().trim();
                test.log(LogStatus.PASS, "Found Act: " + actText);
                actualActs.add(actText);
            }

            // Expected Acts
            List<String> expectedActs = Arrays.asList(
                "Employee Provident Fund Act",
                "Employee State Insurance Act",
                "Professional Tax Act"
            );

            // Compare and log missing acts only
            List<String> missingActs = new ArrayList<>();
            for (String expected : expectedActs) {
                if (!actualActs.contains(expected)) {
                    missingActs.add(expected);
                    test.log(LogStatus.FAIL, "Not Found Act: - " + expected);
                }
            }

            // Final Result
            if (missingActs.isEmpty()) {
                test.log(LogStatus.PASS, "All expected Acts are present in the dropdown.");
            }

        } catch (Exception e) {
            
        }
        
		
	}
	
	public static void WorkspaceRegisterActs( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(1000);
        LoginLocators.ClickRegisterDrp().click();
        Thread.sleep(3000);
        LoginLocators.Act().click();
        Thread.sleep(5000);
            
        try {
            Thread.sleep(5000);

            // Get dropdown options
            List<WebElement> actOptions = getDriver().findElements(By.xpath("//span[@class='k-list-item-text']"));
            List<String> actualActs = new ArrayList<>();
            Thread.sleep(5000);

            for (WebElement option : actOptions) {
                String actText = option.getText().trim();
                test.log(LogStatus.PASS, "Found Act: " + actText);
                actualActs.add(actText);
            }

            // Expected Acts
            List<String> expectedActs = Arrays.asList(
                "Shops and Establishment and Allied Acts",
                "Factory and Allied Acts",
                "Shops/Contract Labour Regulation & Abolition Act",
                "Factory/Contract Labour Regulation & Abolition Act"
            );

            // Compare and log missing acts only
            List<String> missingActs = new ArrayList<>();
            for (String expected : expectedActs) {
                if (!actualActs.contains(expected)) {
                    missingActs.add(expected);
                    test.log(LogStatus.FAIL, "Not Found Act: - " + expected);
                }
            }

            // Final Result
            if (missingActs.isEmpty()) {
                test.log(LogStatus.PASS, "All expected Acts are present in the dropdown.");
            }

        } catch (Exception e) {
            
        }
        
		
	}
	
	public static void WorkspaceReturnActs( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
        LoginLocators.SelectReturnn().click();
        Thread.sleep(2000);
        LoginLocators.FrequencyDropdown().click();
        Thread.sleep(2000);
        LoginLocators.FrequencyMonthly().click();
        Thread.sleep(3000);
        LoginLocators.Act().click();
        Thread.sleep(5000);
            
        //Checking Return Monthly Acts
        try {
            Thread.sleep(5000);

            // Get dropdown options
//            List<WebElement> actOptions = getDriver().findElements(By.xpath("//span[@class='k-list-item-text']"));
            List<WebElement> actOptions = getDriver().findElements(LoginLocators.UniqueValues());
            List<String> actualActs = new ArrayList<>();
            Thread.sleep(5000);

            for (WebElement option : actOptions) {
                String actText = option.getText().trim();
                test.log(LogStatus.PASS, "Found Act: " + actText);
                actualActs.add(actText);
            }

            // Expected Acts
            List<String> expectedActs = Arrays.asList(
                "Employee's Compensation Act, 1923",
                "Employees State Insurance Act, 1948",
                "Employees' Provident Funds & Miscellaneous Provisions Act, 1952",
                "Labour Welfare Fund Act, 1965",
                "Payment of Bonus Act, 1965",
                "Payment of Gratuity Act, 1972",
                "Shops & Commercial Establishment Act",
                "Shops/Contract Labour Regulation & Abolition Act",
                "Tax on Professions, Trades, Callings and Employment's Act, 1976",
                "The Factories Act, 1948"
                
                
            );

            // Compare and log missing acts only
            List<String> missingActs = new ArrayList<>();
            for (String expected : expectedActs) {
                if (!actualActs.contains(expected)) {
                    missingActs.add(expected);
                    test.log(LogStatus.FAIL, "Not Found Act: - " + expected);
                }
            }

            // Final Result
            if (missingActs.isEmpty()) {
                test.log(LogStatus.PASS, "All expected Acts are present in the dropdown.");
            }

        } catch (Exception e) {
            
        }
        
	}
	public static void WorkspaceReturnQuarterlyActs( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
        LoginLocators.SelectReturnn().click();
        Thread.sleep(2000);
        LoginLocators.FrequencyDropdown().click();
        Thread.sleep(2000);
        LoginLocators.FrequencyQuarterly().click();
        Thread.sleep(3000);
        LoginLocators.Act().click();
        Thread.sleep(5000);
            
        //Checking Return Monthly Acts
        try {
            Thread.sleep(5000);

            // Get dropdown options
//            List<WebElement> actOptions = getDriver().findElements(By.xpath("//span[@class='k-list-item-text']"));
            List<WebElement> actOptions = getDriver().findElements(LoginLocators.UniqueValues());
            List<String> actualActs = new ArrayList<>();
            Thread.sleep(5000);

            for (WebElement option : actOptions) {
                String actText = option.getText().trim();
                test.log(LogStatus.PASS, "Found Act: " + actText);
                actualActs.add(actText);
            }

            // Expected Acts
            List<String> expectedActs = Arrays.asList(
                "Employee's Compensation Act, 1923",
                "Employment Exchange (Compulsory Notification of Vacancies) Act, 1959",
                "Labour Welfare Fund Act, 1965",
                "Shops & Commercial Establishment Act",
                "Shops/Contract Labour Regulation & Abolition Act",
                "The Factories Act, 1948"
                
            );

            // Compare and log missing acts only
            List<String> missingActs = new ArrayList<>();
            for (String expected : expectedActs) {
                if (!actualActs.contains(expected)) {
                    missingActs.add(expected);
                    test.log(LogStatus.FAIL, "Not Found Act: - " + expected);
                }
            }

            // Final Result
            if (missingActs.isEmpty()) {
                test.log(LogStatus.PASS, "All expected Acts are present in the dropdown.");
            }

        } catch (Exception e) {
            
        }
        
		
	}
	
	public static void WorkspaceReturnHalfYearlyActs( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
        LoginLocators.SelectReturnn().click();
        Thread.sleep(2000);
        LoginLocators.FrequencyDropdown().click();
        Thread.sleep(2000);
        LoginLocators.FrequencyHalfYearly().click();
        Thread.sleep(3000);
        LoginLocators.Act().click();
        Thread.sleep(5000);
            
        //Checking Return Monthly Acts
        try {
            Thread.sleep(5000);

            // Get dropdown options
//            List<WebElement> actOptions = getDriver().findElements(By.xpath("//span[@class='k-list-item-text']"));
            List<WebElement> actOptions = getDriver().findElements(LoginLocators.UniqueValues());
            List<String> actualActs = new ArrayList<>();
            Thread.sleep(5000);

            for (WebElement option : actOptions) {
                String actText = option.getText().trim();
                test.log(LogStatus.PASS, "Found Act: " + actText);
                actualActs.add(actText);
            }

            // Expected Acts
            List<String> expectedActs = Arrays.asList(
            		"Labour Welfare Fund Act, 1965",
            		"Shops & Commercial Establishment Act",
            		"Shops/Contract Labour Regulation & Abolition Act",
            		"Tax on Professions, Trades, Callings and Employment's Act, 1976",
            		"The Factories Act, 1948"
                
            );

            // Compare and log missing acts only
            List<String> missingActs = new ArrayList<>();
            for (String expected : expectedActs) {
                if (!actualActs.contains(expected)) {
                    missingActs.add(expected);
                    test.log(LogStatus.FAIL, "Not Found Act: - " + expected);
                }
            }

            // Final Result
            if (missingActs.isEmpty()) {
                test.log(LogStatus.PASS, "All expected Acts are present in the dropdown.");
            }

        } catch (Exception e) {
            
        }
        
		
	}
	public static void WorkspaceReturnAnnualActs( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
        LoginLocators.SelectReturnn().click();
        Thread.sleep(2000);
        LoginLocators.FrequencyDropdown().click();
        Thread.sleep(2000);
        LoginLocators.FrequencyAnnual().click();
        Thread.sleep(3000);
        LoginLocators.Act().click();
        Thread.sleep(9000);
            
        //Checking Return Monthly Acts
        try {
            Thread.sleep(5000);

            // Get dropdown options
//            List<WebElement> actOptions = getDriver().findElements(By.xpath("//span[@class='k-list-item-text']"));
            List<WebElement> actOptions = getDriver().findElements(LoginLocators.UniqueValues());
            List<String> actualActs = new ArrayList<>();
            Thread.sleep(8000);

            for (WebElement option : actOptions) {
                String actText = option.getText().trim();
                test.log(LogStatus.PASS, "Found Act: " + actText);
                actualActs.add(actText);
            }

            // Expected Acts
            List<String> expectedActs = Arrays.asList(
              "Contract Labour (Regulation & Abolition) Act,1970",
              "Employee's Compensation Act, 1923",
              "Employees State Insurance Act, 1948",
              "Industrial Establishment (National and Festival Holidays) Act, 1958",
              "Labour Welfare Fund Act, 1965",
              "Maternity Benefit Act, 1961",
              "Minimum Wages Act, 1948",
              "Payment of Bonus Act, 1965",
              "Payment of Gratuity Act, 1972",
              "Payment of wages Act,1936",
              "Shops & Commercial Establishment Act",
              "Shops/Contract Labour Regulation & Abolition Act",
              "Tax on Professions, Trades, Callings and Employment's Act, 1976",
              "The Factories Act, 1948",
              "The Sexual Harassment of Women at Workplace (Prevention, Prohibition and Redressal) Act, 2013"
                
            );

            // Compare and log missing acts only
            List<String> missingActs = new ArrayList<>();
            for (String expected : expectedActs) {
                if (!actualActs.contains(expected)) {
                    missingActs.add(expected);
                    test.log(LogStatus.FAIL, "Not Found Act: - " + expected);
                }
            }

            // Final Result
            if (missingActs.isEmpty()) {
                test.log(LogStatus.PASS, "All expected Acts are present in the dropdown.");
            }

        } catch (Exception e) {
            
        }
        
		
	}
	public static void WorkspaceReturnBiAnnualActs( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
        LoginLocators.SelectReturnn().click();
        Thread.sleep(2000);
        LoginLocators.FrequencyDropdown().click();
        Thread.sleep(2000);
        LoginLocators.FrequencyBiAnnual().click();
        Thread.sleep(3000);
        LoginLocators.Act().click();
        Thread.sleep(9000);
            
        //Checking Return Bi Annual Acts
        try {
            Thread.sleep(5000);

            // Get dropdown options
//            List<WebElement> actOptions = getDriver().findElements(By.xpath("//span[@class='k-list-item-text']"));
            List<WebElement> actOptions = getDriver().findElements(LoginLocators.UniqueValues());
            List<String> actualActs = new ArrayList<>();
            Thread.sleep(8000);

            for (WebElement option : actOptions) {
                String actText = option.getText().trim();
                test.log(LogStatus.PASS, "Found Act: " + actText);
                actualActs.add(actText);
            }

            // Expected Acts
            List<String> expectedActs = Arrays.asList(
              "Employment Exchange (Compulsory Notification of Vacancies) Act, 1959"
                
            );

            // Compare and log missing acts only
            List<String> missingActs = new ArrayList<>();
            for (String expected : expectedActs) {
                if (!actualActs.contains(expected)) {
                    missingActs.add(expected);
                    test.log(LogStatus.FAIL, "Not Found Act: - " + expected);
                }
            }

            // Final Result
            if (missingActs.isEmpty()) {
                test.log(LogStatus.PASS, "All expected Acts are present in the dropdown.");
            }

        } catch (Exception e) {
            
        }
        
		
	}
	
	public static void WorkspaceSelectYearColumn( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
//        LoginLocators.SelectReturnn().click();
        Thread.sleep(2000);
//        LoginLocators.FrequencyDropdown().click();
        Thread.sleep(2000);
//        LoginLocators.FrequencyBiAnnual().click();
        Thread.sleep(3000);
//        LoginLocators.Act().click();
        LoginLocators.SelectYearDropdown().click();
        Thread.sleep(9000);
            
        //Checking Return Bi Annual Acts
        try {
            Thread.sleep(5000);

            // Get dropdown options
//            List<WebElement> actOptions = getDriver().findElements(By.xpath("//span[@class='k-list-item-text']"));
            List<WebElement> actOptions = getDriver().findElements(LoginLocators.UniqueValues());
            List<String> actualActs = new ArrayList<>();
            Thread.sleep(8000);

            for (WebElement option : actOptions) {
                String actText = option.getText().trim();
                test.log(LogStatus.PASS, "Found Year: " + actText);
                actualActs.add(actText);
            }

            // Expected Acts
            List<String> expectedActs = Arrays.asList(
            		"2025",
            		"2024",
            		"2023",
            		"2022",
            		"2021",
            		"2020",
            		"2019",
            		"2018",
            		"2017"
                
            );

            // Compare and log missing acts only
            List<String> missingActs = new ArrayList<>();
            for (String expected : expectedActs) {
                if (!actualActs.contains(expected)) {
                    missingActs.add(expected);
                    test.log(LogStatus.FAIL, "Not Found Year: - " + expected);
                }
            }

            // Final Result
            if (missingActs.isEmpty()) {
                test.log(LogStatus.PASS, "All expected Years are present in the dropdown.");
            }

        } catch (Exception e) {
            
        }
        
		
	}
	public static void WorkspaceSelectPeriodColumn( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		
//		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);

		LoginLocators.PeriodDrp().click();
        Thread.sleep(9000);
            
        //Checking Return Bi Annual Acts
        try {
            Thread.sleep(5000);

            // Get dropdown options
//            List<WebElement> actOptions = getDriver().findElements(By.xpath("//span[@class='k-list-item-text']"));
            List<WebElement> actOptions = getDriver().findElements(LoginLocators.UniqueValues());
            List<String> actualActs = new ArrayList<>();
            Thread.sleep(8000);

            for (WebElement option : actOptions) {
                String actText = option.getText().trim();
                test.log(LogStatus.PASS, "Found Period: " + actText);
                actualActs.add(actText);
            }

            // Expected Acts
            List<String> expectedActs = Arrays.asList(
            		"January",
            		"February",
            		"March",
            		"April",
            		"May",
            		"June",
            		"July",
            		"August",
            		"September",
            		"October",
            		"November",
            		"December"
                
            );

            // Compare and log missing acts only
            List<String> missingActs = new ArrayList<>();
            for (String expected : expectedActs) {
                if (!actualActs.contains(expected)) {
                    missingActs.add(expected);
                    test.log(LogStatus.FAIL, "Not Found Period: - " + expected);
                }
            }

            // Final Result
            if (missingActs.isEmpty()) {
                test.log(LogStatus.PASS, "All expected Periods are present in the dropdown.");
            }

        } catch (Exception e) {
            
        }
        
		
	}
	public static void WorkspaceReturnForms( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(1000);
        LoginLocators.SelectReturnn().click();
        Thread.sleep(3000);
        LoginLocators.FrequencyDropdown().click();
        Thread.sleep(1000);
        LoginLocators.FrequencyAnnual().click();
        Thread.sleep(1000);
        LoginLocators.Act().click();
        Thread.sleep(1000);
        LoginLocators.ActPaymentOfBonus1965().click();
        Thread.sleep(1000);
        LoginLocators.YearDrp().click();
        Thread.sleep(1000);
        LoginLocators.Year2024().click();
        Thread.sleep(1000);
        LoginLocators.PeriodDrp().click();
        Thread.sleep(1000);
        LoginLocators.PeriodAnnual().click();
        Thread.sleep(1000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(1000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
        WebElement viewbutton = getDriver().findElement(By.xpath("//img[@title='View']"));
        System.out.println(viewbutton);
        
        Thread.sleep(6000);
        if(viewbutton.isDisplayed())
        {
        	test.log(LogStatus.PASS, "Returns Forms are displayed");
        }
        else
        {
        	test.log(LogStatus.FAIL, "Returns Forms are not displayed");
        }
		
	}
	
	
	public static void WorkspaceFrequencyDropdown( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		

/*
		try {
		    // ----------- Challan -----------
		    LoginLocators.ComplianceDropdown().click();
		    Thread.sleep(1000);
		    LoginLocators.SelectChallan().click();
		    Thread.sleep(1000);
		    LoginLocators.Clear().click();
		    Thread.sleep(1000);

		    try {
		        LoginLocators.FrequencyDropdown().click();
		        test.log(LogStatus.PASS, "On selecting 'Challan', Frequency dropdown is ENABLED.");
		    } catch (Exception e) {
		        test.log(LogStatus.INFO, "On selecting 'Challan', Frequency dropdown is DISABLED.");
		    }

		    // ----------- Register -----------
		    Thread.sleep(1000);
		    LoginLocators.ComplianceDropdown().click();
		    Thread.sleep(1000);
		    LoginLocators.ClickRegister().click();
		    Thread.sleep(1000);
		    LoginLocators.Clear().click();
		    Thread.sleep(1000);

		    try {
		        LoginLocators.FrequencyDropdown().click();
		        test.log(LogStatus.PASS, "On selecting 'Register', Frequency dropdown is ENABLED.");
		    } catch (Exception e) {
		        test.log(LogStatus.INFO, "On selecting 'Register', Frequency dropdown is DISABLED.");
		    }

		    // ----------- Return -----------
		    Thread.sleep(1000);
		    LoginLocators.ComplianceDropdown().click();
		    Thread.sleep(1000);
		    LoginLocators.SelectReturn().click();
		    Thread.sleep(1000);
		    LoginLocators.Clear().click();
		    Thread.sleep(1000);

		    try {
		        LoginLocators.FrequencyDropdown().click();
		        test.log(LogStatus.PASS, "On selecting 'Return', Frequency dropdown is ENABLED.");
		    } catch (Exception e) {
		        test.log(LogStatus.INFO, "On selecting 'Return', Frequency dropdown is DISABLED.");
		    }

		} catch (Exception e) {
		    test.log(LogStatus.ERROR, "Unexpected error: " + e.getMessage());
		}


*/
		
/*		
		// ----------- Challan -----------
	    LoginLocators.ComplianceDropdown().click();
	    Thread.sleep(1000);
	    LoginLocators.SelectChallan().click();
	    Thread.sleep(1000);
	    LoginLocators.Clear().click();
	    Thread.sleep(1000);

	    if(LoginLocators.FrequencyDropdown().isEnabled()&&LoginLocators.FrequencyDropdown().isEnabled())
	    {
	    	LoginLocators.FrequencyDropdown().click();
	    	LoginLocators.FrequencyQuarterly().click();
	    	test.log(LogStatus.PASS, "On clicking Challans Frequency dropdown is ENABLED");
	    }
	    else {
	    	test.log(LogStatus.INFO, "On clicking Challans Frequency dropdown is DISABLED");
	    }


	    // ----------- Register -----------
	    Thread.sleep(1000);
	    LoginLocators.ComplianceDropdown().click();
	    Thread.sleep(1000);
	    LoginLocators.ClickRegister().click();
	    Thread.sleep(1000);
	    LoginLocators.Clear().click();
	    Thread.sleep(1000);
	    
	    if(LoginLocators.FrequencyDropdown().isEnabled()&&LoginLocators.FrequencyDropdown().isEnabled())
	    {
	    	LoginLocators.FrequencyDropdown().click();
	    	LoginLocators.FrequencyQuarterly().click();
	    	test.log(LogStatus.PASS, "On clicking Register Frequency dropdown is ENABLED");
	    }
	    else {
	    	test.log(LogStatus.INFO, "On clicking Register Frequency dropdown is DISABLED");
	    }


*/
	    // ----------- Return -----------
	    Thread.sleep(1000);
	    LoginLocators.ComplianceDropdown().click();
	    Thread.sleep(1000);
	    LoginLocators.SelectReturnn().click();
	    Thread.sleep(1000);
//	    LoginLocators.Clear().click();
	    Thread.sleep(1000);
		
	    if(LoginLocators.FrequencyDropdown().isEnabled()&&LoginLocators.FrequencyDropdown().isEnabled())
	    {
	    	LoginLocators.FrequencyDropdown().click();
	    	LoginLocators.FrequencyQuarterly().click();
	    	test.log(LogStatus.PASS, "On clicking Return Frequency dropdown is ENABLED");
	    }
	    else {
	    	test.log(LogStatus.INFO, "On clicking Return Frequency dropdown is DISABLED");
	    }
		
	
		
		
/*		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		// ----------- Challan -----------
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(1000);
		LoginLocators.SelectChallan().click();
		Thread.sleep(1000);
		LoginLocators.Clear().click();
		Thread.sleep(1000);

		WebElement challanDropdown = LoginLocators.FrequencyDropdown();
		Boolean challanDisabled = (Boolean) js.executeScript("return arguments[0].hasAttribute('disabled') || arguments[0].disabled;", challanDropdown);

		if (!challanDisabled) {
		    challanDropdown.click();
		    LoginLocators.FrequencyQuarterly().click();
		    test.log(LogStatus.PASS, "On clicking Challans Frequency dropdown is ENABLED");
		} else {
		    test.log(LogStatus.INFO, "On clicking Challans Frequency dropdown is DISABLED");
		}

		// ----------- Register -----------
		Thread.sleep(1000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(1000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(1000);
		LoginLocators.Clear().click();
		Thread.sleep(1000);

		WebElement registerDropdown = LoginLocators.FrequencyDropdown();
		Boolean registerDisabled = (Boolean) js.executeScript("return arguments[0].hasAttribute('disabled') || arguments[0].disabled;", registerDropdown);

		if (!registerDisabled) {
		    registerDropdown.click();
		    LoginLocators.FrequencyQuarterly().click();
		    test.log(LogStatus.PASS, "On clicking Register Frequency dropdown is ENABLED");
		} else {
		    test.log(LogStatus.INFO, "On clicking Register Frequency dropdown is DISABLED");
		}

		// ----------- Return -----------
		Thread.sleep(1000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(1000);
		LoginLocators.SelectReturn().click();
		Thread.sleep(1000);
		LoginLocators.Clear().click();
		Thread.sleep(1000);

		WebElement returnDropdown = LoginLocators.FrequencyDropdown();
		Boolean returnDisabled = (Boolean) js.executeScript("return arguments[0].hasAttribute('disabled') || arguments[0].disabled;", returnDropdown);

		if (!returnDisabled) {
		    returnDropdown.click();
		    LoginLocators.FrequencyQuarterly().click();
		    test.log(LogStatus.PASS, "On clicking Return Frequency dropdown is ENABLED");
		} else {
		    test.log(LogStatus.INFO, "On clicking Return Frequency dropdown is DISABLED");
		}
		*/

		 
	}
	
	public static void WorkspaceApplyClearProceed( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(5000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(1000);
        LoginLocators.SelectChallan().click();
        Thread.sleep(3000);
        LoginLocators.Act().click();
        Thread.sleep(1000);
        LoginLocators.SelectChallanEPF().click();
        Thread.sleep(1000);
        LoginLocators.YearDrp().click();
        Thread.sleep(1000);
        LoginLocators.Year2024().click();
        Thread.sleep(1000);
        LoginLocators.PeriodDrp().click();
        Thread.sleep(1000);
        LoginLocators.PeriodJan().click();
        Thread.sleep(1000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(1000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
//		LoginLocators.ApplyButton().click();
		Thread.sleep(4000);
		
		if(LoginLocators.ApplyButton().isDisplayed())
		{
			LoginLocators.ApplyButton().click();
			test.log(LogStatus.PASS, "Apply button is working fine");
			Thread.sleep(8000);
		}
		else
		{
			test.log(LogStatus.FAIL, "Apply button is not working");
		}
		Thread.sleep(8000);
		LoginLocators.CheckBox().click();
		
		Thread.sleep(5000);
		if(LoginLocators.Proceed().isDisplayed())
		{
			LoginLocators.Proceed().click();
			test.log(LogStatus.PASS, "Proceed button is working fine");
			Thread.sleep(8000);
		}
		else
		{
			test.log(LogStatus.PASS, "Proceed button is not working");
		}
		Thread.sleep(5000);
		
		if(LoginLocators.Back().isEnabled())
		{
			LoginLocators.Back().click();
			test.log(LogStatus.PASS, "Back button is working fine");
		}
		else
		{
			test.log(LogStatus.PASS, "Back button is not working");
		}
		
		Thread.sleep(6000);
		if(LoginLocators.Clear().isEnabled())
		{
			LoginLocators.Clear().click();
			test.log(LogStatus.PASS, "Clear button is working fine");
		}
		else
		{
			test.log(LogStatus.PASS, "Clear button is not working");
		}

		 
	}
	
	public static void StaturyDocuPT( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	


	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		PerformerLocator.clickStatutoryDoc().click();
		Thread.sleep(2000);
		PerformerLocator.clickComplianceType().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceChallan().click();
		Thread.sleep(2000);
		PerformerLocator.clickAct2().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceType4().click();
		Thread.sleep(2000);
		PerformerLocator.clickYear().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceType1().click();
		Thread.sleep(2000);
		PerformerLocator.clickPeriod().click();
		Thread.sleep(2000);
		PerformerLocator.selectMonth().click();
		
		
		Thread.sleep(2000);
		PerformerLocator.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		PerformerLocator.clickApply().click();
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click();
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click(); 
		Thread.sleep(2000);
		
		
	//This code is for validate PT Gross Total	
		try {
	        // Step 1: Pre-download file count
	        File downloadDir = new File("C:\\Users\\bilali\\Downloads");
	        File[] beforeDownload = downloadDir.listFiles();

	        // Step 2: Click Download Button
//	        All_ClientPortal_Locators.DownloadBtn().click();
	        getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click();
	        Thread.sleep(4000);
	        getDriver().findElement(By.xpath("(//img[@alt='Download Document'])[1]")).click();
	        Thread.sleep(10000); // Wait for download

	        // Step 3: Post-download file count & detect new file
	        File[] afterDownload = downloadDir.listFiles();
	        File latestFile = null;
	        long lastModifiedTime = Long.MIN_VALUE;

	        for (File file : afterDownload) {
	            boolean isNew = true;
	            for (File oldFile : beforeDownload) {
	                if (file.getName().equals(oldFile.getName()) && file.lastModified() == oldFile.lastModified()) {
	                    isNew = false;
	                    break;
	                }
	            }
	            if (isNew && file.getName().endsWith(".xlsx") && file.lastModified() > lastModifiedTime) {
	                latestFile = file;
	                lastModifiedTime = file.lastModified();
	            }
	        }

	        // Step 4: Download check
	        if (latestFile != null) {
	            test.log(LogStatus.PASS, "File downloaded successfully: " + latestFile.getName());
	        } else {
	            test.log(LogStatus.FAIL, "File not downloaded.");
	            return;
	        }

	        // Step 5: Excel validation logic
	        FileInputStream fis = new FileInputStream(latestFile);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet("PTChallan");

	        double calculatedSum = 0;
	        double expectedTotal = 0;

	        for (Row row : sheet) {
	            Cell cellA = row.getCell(0);
	            if (cellA != null && cellA.getCellType() == CellType.STRING &&
	                cellA.getStringCellValue().trim().equalsIgnoreCase("Total")) {

	                Cell totalCell = row.getCell(6); // Column G
	                if (totalCell != null && totalCell.getCellType() == CellType.NUMERIC) {
	                    expectedTotal = totalCell.getNumericCellValue();
	                }
	                break;
	            }

	            Cell salaryCell = row.getCell(6); // Column G
	            if (salaryCell != null && salaryCell.getCellType() == CellType.NUMERIC) {
	                calculatedSum += salaryCell.getNumericCellValue();
	            }
	        }

	        workbook.close();
	        fis.close();

	        // Step 6: Final report log
	        if (calculatedSum == expectedTotal) {
	            test.log(LogStatus.PASS, "PT Challan Amount Match ✅ - Calculated: " + calculatedSum + ", Expected: " + expectedTotal);
	        } else {
	            test.log(LogStatus.FAIL, "PT Challan Amount Mismatch ❌ - Calculated: " + calculatedSum + ", Expected: " + expectedTotal);
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.ERROR, "Exception: " + e.getMessage());
	        e.printStackTrace();
	    }
		
		
	
	
//This code is for validte Genders Male and Female only but it is not working properly		
		
/*		// Step 1: Pre-download file count
		File downloadDir = new File("C:\\Users\\bilali\\Downloads");
		File[] beforeDownload = downloadDir.listFiles();

		// Step 2: Click to Download
		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click();
		Thread.sleep(4000);
		getDriver().findElement(By.xpath("(//img[@alt='Download Document'])[1]")).click();
		Thread.sleep(10000); // Wait for download

		// Step 3: Post-download file detect
		File[] afterDownload = downloadDir.listFiles();
		File latestFile = null;
		long lastMod = Long.MIN_VALUE;
		for (File file : afterDownload) {
		    if (file.lastModified() > lastMod && !file.isDirectory() && file.getName().endsWith(".xlsx")) {
		        latestFile = file;
		        lastMod = file.lastModified();
		    }
		}

		if (latestFile == null) {
		    test.log(LogStatus.FAIL, "❌ Downloaded file not found.");
		    return;
		} else {
		    test.log(LogStatus.PASS, "✅ File downloaded successfully: " + latestFile.getName());
		}

		// Step 4: Validate Gender Values
		FileInputStream fis = new FileInputStream(latestFile);
		Workbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheetAt(0);

		List<String> invalidGenders = new ArrayList<>();

		// Auto-detect Gender column by header name
		int genderColumnIndex = -1;
		Row headerRow = sheet.getRow(0);
		if (headerRow != null) {
		    for (Cell cell : headerRow) {
		        if (cell != null && cell.getCellType() == CellType.STRING) {
		            String header = cell.getStringCellValue().trim();
		            if (header.equalsIgnoreCase("Gender")) {
		                genderColumnIndex = cell.getColumnIndex();
		                break;
		            }
		        }
		    }
		}

		if (genderColumnIndex == -1) {
		    workbook.close();
		    fis.close();
		    test.log(LogStatus.FAIL, "❌ 'Gender' column not found in the sheet.");
		    return;
		}

		// Validate gender values
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		    Row row = sheet.getRow(i);
		    if (row != null) {
		        Cell genderCell = row.getCell(genderColumnIndex);
		        if (genderCell != null) {
		            genderCell.setCellType(CellType.STRING);
		            String gender = genderCell.getStringCellValue().trim();
		            if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female")) {
		                invalidGenders.add("Row " + (i + 1) + ": " + gender);
		            }
		        } else {
		            invalidGenders.add("Row " + (i + 1) + ": (Empty)");
		        }
		    }
		}

		workbook.close();
		fis.close();

		if (invalidGenders.isEmpty()) {
		    test.log(LogStatus.PASS, "✅ All gender values are valid (Male/Female only).");
		} else {
		    test.log(LogStatus.FAIL, "❌ Invalid Gender values found:<br>" + String.join("<br>", invalidGenders));
		}

	*/
	
	
		
	}
	
	
	
	public static void Salary( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.SalaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.SalaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Salary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Salary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "D:\\Upload Automation Files\\WorkSpace\\SalaryFile.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

    	        // Use Robot class to paste the file path and press Enter
    	        Robot robot = new Robot();
    	        
    	        // Simulate CTRL + V (Paste)
    	        robot.keyPress(KeyEvent.VK_CONTROL);
    	        robot.keyPress(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_CONTROL);
    	        
    	        // Press Enter to confirm the upload
                robot.keyPress(KeyEvent.VK_ENTER);
    	        robot.keyRelease(KeyEvent.VK_ENTER);

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   if(attendance.equalsIgnoreCase("File uploaded successfully"))
    		   {
    			   test.log(LogStatus.PASS, "Salary "+ attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL,  "Salary "+ attendance);

    		   }
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   Thread.sleep(3000);
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		//   test.log(LogStatus.PASS,  "Salary "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        if (Uploadgreentick.isDisplayed()) {
    	        	LoginLocators.Refresh().click();
    	    		   Thread.sleep(500);	
        			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		LoginLocators.Refresh().click();
     	    		   Thread.sleep(500);
            			wait.until(ExpectedConditions.visibilityOf(Validatedgreentick));

    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			LoginLocators.Refresh().click();
    	    	    		   Thread.sleep(500);
                			wait.until(ExpectedConditions.visibilityOf(Processedgreentick));

    	        			System.out.println("Processed Green tick is displayed.");
    	        			
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }
////////////////
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The salary template is not available for upload.");	

		}
		}
		catch(Exception e)
		{
			
		}
		
       
		}
		
	public static void LeaveSummaryDetails( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.LeaveSummaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.LeaveSummaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Leave Summary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Leave Summary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlyLeaveSummary_01Mar2025105223.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

    	        // Use Robot class to paste the file path and press Enter
    	        Robot robot = new Robot();
    	        
    	        // Simulate CTRL + V (Paste)
    	        robot.keyPress(KeyEvent.VK_CONTROL);
    	        robot.keyPress(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_CONTROL);
    	        
    	        // Press Enter to confirm the upload
                robot.keyPress(KeyEvent.VK_ENTER);
    	        robot.keyRelease(KeyEvent.VK_ENTER);

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   if(attendance.equalsIgnoreCase("File uploaded successfully"))
    		   {
    			   test.log(LogStatus.PASS, "Leave Summary Details "+ attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL,  "Leave Summary Details "+ attendance);

    		   }
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		 //  test.log(LogStatus.PASS,  "Leave Summary Details "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        if (Uploadgreentick.isDisplayed()) {
    	        	LoginLocators.Refresh().click();
    	    		   Thread.sleep(500);	
        			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		LoginLocators.Refresh().click();
     	    		   Thread.sleep(500);
            			wait.until(ExpectedConditions.visibilityOf(Validatedgreentick));

    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			LoginLocators.Refresh().click();
    	    	    		   Thread.sleep(500);
                			wait.until(ExpectedConditions.visibilityOf(Processedgreentick));

    	        			System.out.println("Processed Green tick is displayed.");
    	        			
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }
////////////////
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The leave salary template is not available for upload.");	

		}
		}
		catch(Exception e)
		{
			
		}
       
		}
		
	public static void History( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	

		if(LoginLocators.History().isDisplayed()) {
		LoginLocators.History().click();
		Thread.sleep(3000);
		String s = LoginLocators.TotalNumberOfItems().getText();
		if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
			
			Thread.sleep(2000);	
			File dir2 = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(9000);
			LoginLocators.successfilehistory().click();			
		 	Thread.sleep(18000);
			File dir3 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
		   
	        Thread.sleep(9000);
		   if (dirContents1.length < allFilesNew1.length) {
				test.log(LogStatus.PASS,  "History file Downloaded.");
			}
		   else
		   {
				test.log(LogStatus.FAIL, "History file Does Not Downloaded.");
			}		
		}
		else {
			test.log(LogStatus.PASS, "No Record found");	

		}
    }
		else {
			test.log(LogStatus.PASS, "History button not displayed for particular selection. ");	

		}
		
		
	}
	
	public static void WorkspaceSampleTemplate( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		
		Thread.sleep(2000);	
		
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(5000);
		
		getDriver().findElement(By.xpath("//img[@title='Download']")).click(); //sample download

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Sample Document File is downloaded Successfully");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "Sample Document File is not downloaded");
		}
		
		
	}

		
	public static void WorkspaceEmptyFile( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.SelectChallan().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.SelectChallanEPF().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.PeriodJune().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		
		Thread.sleep(2000);	
		
/*		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(5000);
		
		getDriver().findElement(By.xpath("//img[@title='Download']")).click(); //sample download

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Sample Document File is downloaded Successfully");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "Sample Document File is not downloaded");
		}
		
		*/
		
		//No File selected Validation:
		
//		GetMessageText
		
		LoginLocators.UploadFile().click();
		Thread.sleep(5000);
		String txt = LoginLocators.GetMessageText().getText();
		
		if (txt.equalsIgnoreCase("No file chosen")) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Without Selecting File clicking to upload Message Displayed :- " + txt);

		} else {
			Thread.sleep(5000);
			test.log(LogStatus.FAIL, "Without Selecting File clicking to upload Message Displayed :- " + txt);
		}
		
		LoginLocators.ClickOK().click();
		
		
		Thread.sleep(5000);
		LoginLocators.BrowseFile().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\WorkSpace\\Empty.xlsx");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(2000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(2000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		Thread.sleep(2000);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		Thread.sleep(2000);
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		Thread.sleep(2000);
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(3000);
  				 
  		LoginLocators.UploadFile().click();
  					
			Thread.sleep(3000);

			
			String text1 = LoginLocators.GetMessageText().getText();

			if (text1.equalsIgnoreCase("Empty sheet")) {
				Thread.sleep(5000);
				test.log(LogStatus.PASS, "While Uploading Empty File Error Message Displayed :- " + text1);

			} else {
				Thread.sleep(5000);
				test.log(LogStatus.FAIL, "While Uploading Empty File Error Message Displayed :- " + text1);
			}
		
		
	}
	
	public static void WorkspaceErrorFileUpload( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.SelectChallan().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.SelectChallanEPF().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.PeriodJune().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		
		Thread.sleep(2000);	
		
		Thread.sleep(5000);
		LoginLocators.BrowseFile().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\WorkSpace\\2 Column Data Invalid File.xlsx");
  		 //copy above file to clipboard
  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
  		
  		 //Now press CRTL
  		
  		 robot.keyPress(KeyEvent.VK_CONTROL);
  		 Thread.sleep(2000);
  		
  		 //PRESS V
  		 robot.keyPress(KeyEvent.VK_V);
  		 Thread.sleep(2000);
  		
  		 //Release V
  		 robot.keyRelease(KeyEvent.VK_V);
  		Thread.sleep(2000);
  		
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_CONTROL);
  		Thread.sleep(2000);
  		 //PRESS Enter
  		 robot.keyPress(KeyEvent.VK_ENTER);
  		Thread.sleep(2000);
  		 //Release CRTL
  		 robot.keyRelease(KeyEvent.VK_ENTER);
  		
  		 Thread.sleep(3000);
  				 
  		LoginLocators.UploadFile().click();
  					
			Thread.sleep(3000);

			
			String text1 = LoginLocators.GetMessageText().getText();

			if (text1.equalsIgnoreCase("Error uploading file")) {
				Thread.sleep(5000);
				test.log(LogStatus.PASS, "While Uploading File with only 2 columns data Message displayed : " + text1);

			} else {
				Thread.sleep(5000);
				test.log(LogStatus.FAIL, "While Uploading File with only 2 columns data Message displayed: " + text1);
			}
		
		
			
			Thread.sleep(5000);
			LoginLocators.ClickOK().click();
			Thread.sleep(5000);
			
			
			
			//Invalid Template:
			LoginLocators.BrowseFile().click();
	  		Thread.sleep(3000);
	  		Robot robot2=new Robot();
	  		 StringSelection filepath2= new  StringSelection("D:\\Upload Automation Files\\WorkSpace\\InvalidTemplate.xlsx");
	  		 //copy above file to clipboard
	  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath2, null);
	  		
	  		 //Now press CRTL
	  		
	  		 robot2.keyPress(KeyEvent.VK_CONTROL);
	  		 Thread.sleep(2000);
	  		
	  		 //PRESS V
	  		 robot2.keyPress(KeyEvent.VK_V);
	  		 Thread.sleep(2000);
	  		
	  		 //Release V
	  		 robot2.keyRelease(KeyEvent.VK_V);
	  		Thread.sleep(2000);
	  		
	  		 //Release CRTL
	  		 robot2.keyRelease(KeyEvent.VK_CONTROL);
	  		Thread.sleep(2000);
	  		 //PRESS Enter
	  		 robot2.keyPress(KeyEvent.VK_ENTER);
	  		Thread.sleep(2000);
	  		 //Release CRTL
	  		 robot2.keyRelease(KeyEvent.VK_ENTER);
	  		
	  		 Thread.sleep(3000);
	  				 
	  		LoginLocators.UploadFile().click();
	  					
				Thread.sleep(3000);

				
				String text2 = LoginLocators.GetMessageText().getText();

				if (text2.equalsIgnoreCase("Please upload a file with correct headers.")) {
					Thread.sleep(5000);
					test.log(LogStatus.PASS, "While Uploading Invalid Headers File Error Message displayed : " + text2);

				} else {
					Thread.sleep(5000);
					test.log(LogStatus.FAIL, "While Uploading Invalid Headers File Error Message displayed: " + text2);
				}


		
	}
	
	public static void WorkspaceInvalidFileDownloadErrorFile( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.SelectChallan().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.SelectChallanEPF().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.PeriodJune().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		
		Thread.sleep(2000);	
		
				
			
			//Invalid Template:
			LoginLocators.BrowseFile().click();
	  		Thread.sleep(3000);
	  		Robot robot2=new Robot();
	  		 StringSelection filepath2= new  StringSelection("D:\\Upload Automation Files\\WorkSpace\\SampleTemplateInvalid.xlsx");
	  		 //copy above file to clipboard
	  		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath2, null);
	  		
	  		 //Now press CRTL
	  		
	  		 robot2.keyPress(KeyEvent.VK_CONTROL);
	  		 Thread.sleep(2000);
	  		
	  		 //PRESS V
	  		 robot2.keyPress(KeyEvent.VK_V);
	  		 Thread.sleep(2000);
	  		
	  		 //Release V
	  		 robot2.keyRelease(KeyEvent.VK_V);
	  		Thread.sleep(2000);
	  		
	  		 //Release CRTL
	  		 robot2.keyRelease(KeyEvent.VK_CONTROL);
	  		Thread.sleep(2000);
	  		 //PRESS Enter
	  		 robot2.keyPress(KeyEvent.VK_ENTER);
	  		Thread.sleep(2000);
	  		 //Release CRTL
	  		 robot2.keyRelease(KeyEvent.VK_ENTER);
	  		
	  		 Thread.sleep(3000);
	  				 
	  		LoginLocators.UploadFile().click();
	  					
				Thread.sleep(3000);

				
				String text2 = LoginLocators.GetMessageText().getText();

				if (text2.equalsIgnoreCase("Error uploading file")) {
					Thread.sleep(5000);
					test.log(LogStatus.PASS, "While Uploading Invalid File Error Message displayed : " + text2);

				} else {
					Thread.sleep(5000);
					test.log(LogStatus.FAIL, "While Uploading Invalid File Error Message displayed: " + text2);
				}
				
				Thread.sleep(5000);
				LoginLocators.ClickOK().click();
				Thread.sleep(5000);
				LoginLocators.RefreshBtn().click();
				Thread.sleep(5000);
				LoginLocators.RefreshBtn().click();
				Thread.sleep(5000);
				LoginLocators.RefreshBtn().click();
				Thread.sleep(5000);
				LoginLocators.RefreshBtn().click();
				Thread.sleep(5000);
				LoginLocators.RefreshBtn().click();
				Thread.sleep(5000);
				
				
				//Downloading Error File:
				Thread.sleep(3000);
				File dir = new File("C:\\Users\\bilali\\Downloads");
				File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

				Thread.sleep(5000);
				
				LoginLocators.ErrorFileDownload().click();
		
				Thread.sleep(8000);
				File dir1 = new File("C:\\Users\\bilali\\Downloads");
				File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
				Thread.sleep(3000);
				if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
					test.log(LogStatus.PASS,  "Error File downloaded successfully.");
				} else {Thread.sleep(5000);
					test.log(LogStatus.FAIL,  "Error File does not downloaded.");
				}


		
	}
	
	
	public static void ECRMasterSearches( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(5000);
		
		LoginLocators.ECRMasterTab().click();
		Thread.sleep(5000);
		LoginLocators.searchuserid().sendKeys("AVACORED");
		Thread.sleep(5000);
		LoginLocators.searchuseridDD().click();
		
		
		LoginLocators.TotalNumberOfItem().click();					
		String s = LoginLocators.TotalNumberOfItem().getText();
		Thread.sleep(2000);
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
			String searchvalue1 = LoginLocators.GridValue().getText();
			   test.log(LogStatus.PASS,  "Search filter Working properly : "+ searchvalue1);

		}
		else {
			   test.log(LogStatus.FAIL,  "Search filter does not working properly ");

		}
		
		Thread.sleep(5000);
		if(LoginLocators.Clear().isEnabled())
		{
			Thread.sleep(5000);
			LoginLocators.Clear().click();
			test.log(LogStatus.PASS, "Clear button working successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Clear button not working successfully");
		}
		
	}
	
	public static void WorkspaceReturn( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickReturn().click();
		Thread.sleep(2000);
		LoginLocators.Frequency().click();
		Thread.sleep(2000);
		LoginLocators.FrequencyValue().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandBranch().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
		try {
		MethodsD.Viewworspace(test,user);
		}
		catch(Exception e) {
			
		}
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		try {
       if(LoginLocators.AttendaceText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.AttendaceText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Attendance Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Attendance Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlyAttendance_19Feb2025011916.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

    	        // Use Robot class to paste the file path and press Enter
    	        Robot robot = new Robot();
    	        
    	        // Simulate CTRL + V (Paste)
    	        robot.keyPress(KeyEvent.VK_CONTROL);
    	        robot.keyPress(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_CONTROL);
    	        
    	        // Press Enter to confirm the upload
                robot.keyPress(KeyEvent.VK_ENTER);
    	        robot.keyRelease(KeyEvent.VK_ENTER);

    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		   test.log(LogStatus.PASS,  "Attendance "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));
    	        if (Uploadgreentick.isDisplayed()) {
    	        	
    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			System.out.println("Processed Green tick is displayed.");
    	        			
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }

            }
            
		}	
       
}
		
else {
	
	test.log(LogStatus.PASS, "The attendance template is not available for upload.");	

}
		
		}
		catch(Exception e)
		{
			
		}
		MethodsD.SalaryReturn(test, user);	
		Thread.sleep(2000);	
		MethodsD.LeaveSummaryDetailsReturn(test, user);
		Thread.sleep(4000);	
        LoginLocators.Check().click();
		   Thread.sleep(9000);
		   LoginLocators.OK().click();
		   Thread.sleep(2000);	
		   LoginLocators.Refresh().click();
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.GenerateDocument()));
		LoginLocators.Refresh().click();
		   LoginLocators.GenerateDocument().click();
		   Thread.sleep(2000);	
		   String msg = LoginLocators.GenerationMsg().getText();
			test.log(LogStatus.PASS, msg);	
			LoginLocators.OK().click();
			   Thread.sleep(2000);	
	
		
	}
		
	public static void frequencydropdown( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		//WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		if(LoginLocators.frequency().isEnabled())
		{
			
			test.log(LogStatus.PASS, "After select Resgister : Frequency dropdown is disabled");	

		}
		else {
			LoginLocators.frequency().click();
			test.log(LogStatus.FAIL, "After select Resgister : Frequency dropdown is enabled");			
		}
//		LoginLocators.frequency().click();
//		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickReturn().click();
		Thread.sleep(2000);
		if(LoginLocators.frequency().isEnabled())
		{
			LoginLocators.frequency().click();
			test.log(LogStatus.PASS, "After select Return : Frequency dropdown is enabled");	

		}
		else {
			test.log(LogStatus.FAIL, "After select Return : Frequency dropdown is disabled");			
		}
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickchallan().click();
		Thread.sleep(2000);
		if(LoginLocators.frequency().isEnabled())
		{
			
			test.log(LogStatus.PASS, "After select Challan : Frequency dropdown is disabled");	

		}
		else {
			LoginLocators.frequency().click();
			test.log(LogStatus.FAIL, "After select Challan : Frequency dropdown is enabled");			
		}
		
	}

	public static void SalaryReturn( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.SalaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.SalaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Salary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Salary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlySalary_19Feb2025012247.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

    	        // Use Robot class to paste the file path and press Enter
    	        Robot robot = new Robot();
    	        
    	        // Simulate CTRL + V (Paste)
    	        robot.keyPress(KeyEvent.VK_CONTROL);
    	        robot.keyPress(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_CONTROL);
    	        
    	        // Press Enter to confirm the upload
                robot.keyPress(KeyEvent.VK_ENTER);
    	        robot.keyRelease(KeyEvent.VK_ENTER);

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		   test.log(LogStatus.PASS,  "Salary "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        if (Uploadgreentick.isDisplayed()) {
    	        	LoginLocators.Refresh().click();
    	    		   Thread.sleep(500);	
        			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		LoginLocators.Refresh().click();
     	    		   Thread.sleep(500);
            			wait.until(ExpectedConditions.visibilityOf(Validatedgreentick));

    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			LoginLocators.Refresh().click();
    	    	    		   Thread.sleep(500);
                			wait.until(ExpectedConditions.visibilityOf(Processedgreentick));

    	        			System.out.println("Processed Green tick is displayed.");
    	        			
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }
////////////////
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The salary template is not available for upload.");	

		}
       
		}
		catch(Exception e)
		{
			
		}
	
	}
	
	
	public static void LeaveSummaryDetailsReturn( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.LeaveSummaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.LeaveSummaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Leave Summary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Leave Summary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlyLeaveSummary_19Feb2025012631.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

    	        // Use Robot class to paste the file path and press Enter
    	        Robot robot = new Robot();
    	        
    	        // Simulate CTRL + V (Paste)
    	        robot.keyPress(KeyEvent.VK_CONTROL);
    	        robot.keyPress(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_CONTROL);
    	        
    	        // Press Enter to confirm the upload
                robot.keyPress(KeyEvent.VK_ENTER);
    	        robot.keyRelease(KeyEvent.VK_ENTER);

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		   test.log(LogStatus.PASS,  "Leave Summary Details "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        if (Uploadgreentick.isDisplayed()) {
    	        	LoginLocators.Refresh().click();
    	    		   Thread.sleep(500);	
        			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		LoginLocators.Refresh().click();
     	    		   Thread.sleep(500);
            			wait.until(ExpectedConditions.visibilityOf(Validatedgreentick));

    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			LoginLocators.Refresh().click();
    	    	    		   Thread.sleep(500);
                			wait.until(ExpectedConditions.visibilityOf(Processedgreentick));

    	        			System.out.println("Processed Green tick is displayed.");
    	        			
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }
////////////////
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The leave salary template is not available for upload.");	

		}
		}
		catch(Exception e) {
			
		}
       
		}
		
	public static void Workspacechallan( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickchallan().click();
		Thread.sleep(2000);
//		LoginLocators.Frequency().click();
//		Thread.sleep(2000);
//		LoginLocators.FrequencyValue().click();
//		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
		try {
		MethodsD.Viewworspace(test,user);
		}
		catch(Exception e) {
			
		}
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		try {
       if(LoginLocators.AttendaceText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.AttendaceText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Attendance Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Attendance Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "D:\\Upload Automation Files\\Other Upload No need to change\\AUTOTEST Challan.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

    	        // Use Robot class to paste the file path and press Enter
    	        Robot robot = new Robot();
    	        
    	        // Simulate CTRL + V (Paste)
    	        robot.keyPress(KeyEvent.VK_CONTROL);
    	        robot.keyPress(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_CONTROL);
    	        
    	        // Press Enter to confirm the upload
                robot.keyPress(KeyEvent.VK_ENTER);
    	        robot.keyRelease(KeyEvent.VK_ENTER);

    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   if(attendance.equalsIgnoreCase("File uploaded successfully"))
    		   {
    			   test.log(LogStatus.PASS, "Attendance "+ attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL,  "Attendance "+ attendance);

    		   }
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
   			getDriver().manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		//   test.log(LogStatus.PASS,  "Attendance "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));
    	        if (Uploadgreentick.isDisplayed()) {
    	        	
    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			LoginLocators.Refresh().click();
    	         		   Thread.sleep(2000);	
   	        			System.out.println("Processed Green tick is displayed.");

    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }

            }
            
		}	
       
}
		
else {
	
	test.log(LogStatus.PASS, "The attendance template is not available for upload.");	

}
		
		}
		catch(Exception e)
		{
			
		}
		MethodsD.SalaryChallan(test, user);	
		Thread.sleep(20000);	
		MethodsD.LeaveSummaryDetailsChallan(test, user);
		Thread.sleep(20000);
		getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 LoginLocators.Refresh().click();
		 Thread.sleep(4000);	
        LoginLocators.Check().click();
		   Thread.sleep(9000);
		 //  LoginLocators.OK().click();
		 //  Thread.sleep(2000);	
		   LoginLocators.Refresh().click();
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.GenerateDocument()));
		LoginLocators.Refresh().click();
		   LoginLocators.GenerateDocument().click();
		   Thread.sleep(2000);	
		   String msg = LoginLocators.GenerationMsg().getText();
		   if(msg.equalsIgnoreCase("Generation is in progress. Please check in the Statutory Documents, after receiving the email confirmation."))
		   {
			   test.log(LogStatus.PASS,  msg);
		   }
		   else {
			   test.log(LogStatus.FAIL,   msg);

		   }
			//test.log(LogStatus.PASS, msg);	
			LoginLocators.OK().click();
			   Thread.sleep(2000);	
	
		
	}
	
	
	public static void SalaryChallan( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.SalaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.SalaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Salary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Salary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlySalary_03Mar2025041212.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

    	        // Use Robot class to paste the file path and press Enter
    	        Robot robot = new Robot();
    	        
    	        // Simulate CTRL + V (Paste)
    	        robot.keyPress(KeyEvent.VK_CONTROL);
    	        robot.keyPress(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_CONTROL);
    	        
    	        // Press Enter to confirm the upload
                robot.keyPress(KeyEvent.VK_ENTER);
    	        robot.keyRelease(KeyEvent.VK_ENTER);

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   if(attendance.equalsIgnoreCase("File uploaded successfully"))
    		   {
    			   test.log(LogStatus.PASS, "Salary "+ attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL, "Salary "+  attendance);

    		   }
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		  // test.log(LogStatus.PASS,  "Salary "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        if (Uploadgreentick.isDisplayed()) {
    	        	LoginLocators.Refresh().click();
    	    		   Thread.sleep(500);	
        			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		LoginLocators.Refresh().click();
     	    		   Thread.sleep(500);
            			wait.until(ExpectedConditions.visibilityOf(Validatedgreentick));

    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			LoginLocators.Refresh().click();
    	    	    		   Thread.sleep(5000);
                			wait.until(ExpectedConditions.visibilityOf(Processedgreentick));

    	        			System.out.println("Processed Green tick is displayed.");
    	        			LoginLocators.Refresh().click();
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }
////////////////
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The salary template is not available for upload.");	

		}
       
		}
		catch(Exception e)
		{
			
		}
		Thread.sleep(20000);
	
	}
	public static void LeaveSummaryDetailsChallan( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.LeaveSummaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.LeaveSummaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Leave Summary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Leave Summary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Sample-MonthlyLeaveSummary_29Jan2025054542.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

    	        // Use Robot class to paste the file path and press Enter
    	        Robot robot = new Robot();
    	        
    	        // Simulate CTRL + V (Paste)
    	        robot.keyPress(KeyEvent.VK_CONTROL);
    	        robot.keyPress(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_CONTROL);
    	        
    	        // Press Enter to confirm the upload
                robot.keyPress(KeyEvent.VK_ENTER);
    	        robot.keyRelease(KeyEvent.VK_ENTER);

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   if(attendance.equalsIgnoreCase("File uploaded successfully"))
    		   {
    			   test.log(LogStatus.PASS, "Leave Summary Details "+ attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL, "Leave Summary Details "+  attendance);

    		   }
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		//   test.log(LogStatus.PASS,  "Leave Summary Details "+ attendance);
    		   
    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        if (Uploadgreentick.isDisplayed()) {
    	        	LoginLocators.Refresh().click();
    	    		   Thread.sleep(500);	
        			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));

    	        	System.out.println("Uploaded Green tick is displayed.");
    	        	if(Validatedgreentick.isDisplayed())
    	        	{
    	        		LoginLocators.Refresh().click();
     	    		   Thread.sleep(500);
            			wait.until(ExpectedConditions.visibilityOf(Validatedgreentick));

    	        		System.out.println("Validated Green tick is displayed.");
    	        		if(Processedgreentick.isDisplayed()) {
    	        			LoginLocators.Refresh().click();
    	    	    		   Thread.sleep(500);
                			wait.until(ExpectedConditions.visibilityOf(Processedgreentick));

    	        			System.out.println("Processed Green tick is displayed.");
    	        			
    	        		}
    	        		else {
    	        			System.out.println("Processed Green tick is NOT displayed.");
    	        		}
    	        		
    	        	}
    	        	else {
    	        		System.out.println("Validated Green tick is NOT displayed.");
    	        	}
    	            
    	        } else {
    	            System.out.println("Uploaded Green tick is NOT displayed.");
    	        }
////////////////
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The leave salary template is not available for upload.");	

		}
		}
		catch(Exception e) {
			
		}
		Thread.sleep(20000);
       
		}
	
	public static void Empty( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	


	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
//		try {
//		Methods.Viewworspace(test,user);
//		}
//		catch(Exception e) {
//			
//		}
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		LoginLocators.Browse().click();
	       Thread.sleep(4000);  // Wait for dialog to appear

	        // Specify the file path
	        String filePath = "E:\\Labor Upload\\Sample-MonthlyAttendance_EmptySheet.xlsx";
	        StringSelection selection = new StringSelection(filePath);

	        // Copy file path to clipboard
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

	        // Use Robot class to paste the file path and press Enter
	        Robot robot = new Robot();
	        
	        // Simulate CTRL + V (Paste)
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        
	        // Press Enter to confirm the upload
         robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);

	      //  System.out.println("File uploaded successfully!");
		//   LoginLocators.Uploads().click();
	        Thread.sleep(9000);
	        LoginLocators.Uploads().click();
		   Thread.sleep(7000);
		   
		   String attendance = LoginLocators.UploadSuccessfully().getText();
		   Thread.sleep(2000);
		   LoginLocators.OK().click();
		   Thread.sleep(2000);	
		   LoginLocators.Refresh().click();
		   Thread.sleep(2000);	
		   if(attendance.equalsIgnoreCase("Empty sheet"))
		   {
			   test.log(LogStatus.PASS,  attendance);
		   }
		   else {
			   test.log(LogStatus.FAIL,   attendance);

		   }
     
     
	}
		
	public static void WorkspaceRegisterEmptyfileupload( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	


	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandBranch().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
//		try {
//		Methods.Viewworspace(test,user);
//		}
//		catch(Exception e) {
//			
//		}
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		try {
       if(LoginLocators.AttendaceText().isDisplayed() || LoginLocators.SalaryText().isDisplayed() || LoginLocators.LeaveSummaryText().isDisplayed() ) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String textLS = LoginLocators.LeaveSummaryText().getText();

            String textsalary = LoginLocators.SalaryText().getText();
            String text = LoginLocators.AttendaceText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t) || textsalary.equalsIgnoreCase(t) || textLS.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				//test.log(LogStatus.PASS,  "Attendance Template Downloaded.");
    			}
    		   else
    		   {
    			//	test.log(LogStatus.FAIL, "Attendance Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Sample-MonthlyAttendance_EmptySheet.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

    	        // Use Robot class to paste the file path and press Enter
    	        Robot robot = new Robot();
    	        
    	        // Simulate CTRL + V (Paste)
    	        robot.keyPress(KeyEvent.VK_CONTROL);
    	        robot.keyPress(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_CONTROL);
    	        
    	        // Press Enter to confirm the upload
                robot.keyPress(KeyEvent.VK_ENTER);
    	        robot.keyRelease(KeyEvent.VK_ENTER);

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		   if(attendance.equalsIgnoreCase("Empty sheet"))
    		   {
    			   test.log(LogStatus.PASS, "attendance"+ attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL, "attendance"+  attendance);

    		   }
            }
            
		}	
}
else {
	
	test.log(LogStatus.PASS, "The attendance template is not available for upload.");	

}
		
		
		   
		}
		
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Attendance Not present");

		}
		
	//	Methods.SalaryEmptysheet(test, user);	
	//	Thread.sleep(2000);	
	//	Methods.LeaveSummaryDetailsEmptySheet(test, user);
	//	Thread.sleep(4000);	
//        LoginLocators.Check().click();
//		   Thread.sleep(9000);
		//   LoginLocators.OK().click();
		//   Thread.sleep(2000);	
		   LoginLocators.Refresh().click();
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.GenerateDocument()));
//		LoginLocators.Refresh().click();
//		   LoginLocators.GenerateDocument().click();
//		   Thread.sleep(2000);	
//		   String msg = LoginLocators.GenerationMsg().getText();
//			test.log(LogStatus.PASS, msg);	
//			LoginLocators.OK().click();
//			   Thread.sleep(2000);	
		
		 
	}
	
	public static void SalaryEmptysheet( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.SalaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.SalaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Salary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Salary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Sample-MonthlySalary_EmptySheet.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

    	        // Use Robot class to paste the file path and press Enter
    	        Robot robot = new Robot();
    	        
    	        // Simulate CTRL + V (Paste)
    	        robot.keyPress(KeyEvent.VK_CONTROL);
    	        robot.keyPress(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_CONTROL);
    	        
    	        // Press Enter to confirm the upload
                robot.keyPress(KeyEvent.VK_ENTER);
    	        robot.keyRelease(KeyEvent.VK_ENTER);

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		   if(attendance.equalsIgnoreCase("Empty sheet"))
    		   {
    			   test.log(LogStatus.PASS,  attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL,   attendance);

    		   }
    	       
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The salary template is not available for upload.");	

		}
		}
		catch(Exception e)
		{
			
		}
		
       
		}
		
	public static void LeaveSummaryDetailsEmptySheet( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		try {
		if(LoginLocators.LeaveSummaryText().isDisplayed()) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String text = LoginLocators.LeaveSummaryText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
            	Thread.sleep(2000);	
    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
    			
    			Thread.sleep(9000);
    			
    	//	LoginLocators.AttendanceTemplate().click();
    			AttendanceTemplate.click();
    		 	Thread.sleep(18000);
    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
    			
    		   
    	        Thread.sleep(9000);
    		   if (dirContents1.length < allFilesNew1.length) {
    				test.log(LogStatus.PASS,  "Leave Summary Template Downloaded.");
    			}
    		   else
    		   {
    				test.log(LogStatus.FAIL, "Leave Summary Template Does Not Downloaded.");
    			}		
    		   Thread.sleep(3000);
    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Sample-MonthlyLeaveSummary_EmptySheet.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

    	        // Use Robot class to paste the file path and press Enter
    	        Robot robot = new Robot();
    	        
    	        // Simulate CTRL + V (Paste)
    	        robot.keyPress(KeyEvent.VK_CONTROL);
    	        robot.keyPress(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_CONTROL);
    	        
    	        // Press Enter to confirm the upload
                robot.keyPress(KeyEvent.VK_ENTER);
    	        robot.keyRelease(KeyEvent.VK_ENTER);

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		   if(attendance.equalsIgnoreCase("Empty sheet"))
    		   {
    			   test.log(LogStatus.PASS,  attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL,   attendance);

    		   }    		   
    			
            }
            
		}
		}
		else {
			test.log(LogStatus.PASS, "The leave salary template is not available for upload.");	

		}
		}
		catch(Exception e)
		{
			
		}
       
		}
	
	public static void Workspacewithoutentersheetupload( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	


	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandB().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		LoginLocators.Submit().click();
		Thread.sleep(9000);	
		 String attendance = LoginLocators.UploadSuccessfully().getText();
		   Thread.sleep(2000);
		   LoginLocators.OK().click();
		   Thread.sleep(2000);	
		   LoginLocators.Refresh().click();
		   Thread.sleep(2000);	
		   if(attendance.equalsIgnoreCase("No file chosen"))
		   {
			   test.log(LogStatus.PASS,  attendance);
		   }
		   else {
			   test.log(LogStatus.FAIL,   attendance);

		   }    
		
	}
		
	public static void WorkspaceinvalidTemplateupload( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	


	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		LoginLocators.SelectActDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickAct().click();
		Thread.sleep(2000);
		LoginLocators.YearDropdown().click();
		Thread.sleep(2000);
		LoginLocators.Clickyear().click();
		Thread.sleep(2000);
		LoginLocators.PeriodDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod().click();
		Thread.sleep(2000);
		LoginLocators.AllFile().click();
		Thread.sleep(2000);
		LoginLocators.SelectAllCheckbox().click();
		Thread.sleep(2000);
		LoginLocators.branch().click();
		Thread.sleep(2000);
		LoginLocators.ExpandBranch().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(6000);
		
//		try {
//		Methods.Viewworspace(test,user);
//		}
//		catch(Exception e) {
//			
//		}
		LoginLocators.CheckBox().click();
		Thread.sleep(2000);
		LoginLocators.Proceed().click();
		Thread.sleep(9000);	
		try {
       if(LoginLocators.AttendaceText().isDisplayed() || LoginLocators.SalaryText().isDisplayed() || LoginLocators.LeaveSummaryText().isDisplayed() ) {
		WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));

	    int Row_Count = rows.size();
	
		for (int i = 1; i <= Row_Count; i++) {
            // Construct the dynamic XPath
         //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
          //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
            
            String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
            WebElement col = getDriver().findElement(By.xpath(column));
            String t = col.getText();
            
            String textLS = LoginLocators.LeaveSummaryText().getText();

            String textsalary = LoginLocators.SalaryText().getText();
            String text = LoginLocators.AttendaceText().getText();
            System.out.print(t + " | "+ text); // Print text of each column
            if(text.equalsIgnoreCase(t) || textsalary.equalsIgnoreCase(t) || textLS.equalsIgnoreCase(t)) {
            String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
            WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
            
            String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
            WebElement Browse = getDriver().findElement(By.xpath(Brows));
          
            String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
            WebElement Uploads = getDriver().findElement(By.xpath(upload));
            
            String uploadgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
            WebElement Uploadgreentick = getDriver().findElement(By.xpath(uploadgreentick));
            
            String validatedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[4]";
            WebElement Validatedgreentick = getDriver().findElement(By.xpath(validatedgreentick));

            String processedgreentick = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[5]";
            WebElement Processedgreentick = getDriver().findElement(By.xpath(processedgreentick));
		
            
//            	Thread.sleep(2000);	
//    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
//    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
//    			
//    			Thread.sleep(9000);
//    			
//    	//	LoginLocators.AttendanceTemplate().click();
//    			AttendanceTemplate.click();
//    		 	Thread.sleep(18000);
//    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
//    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
//    			
//    		   
//    	        Thread.sleep(9000);
//    		   if (dirContents1.length < allFilesNew1.length) {
//    				//test.log(LogStatus.PASS,  "Attendance Template Downloaded.");
//    			}
//    		   else
//    		   {
//    			//	test.log(LogStatus.FAIL, "Attendance Template Does Not Downloaded.");
//    			}		
//    		   Thread.sleep(3000);
//    		 //  LoginLocators.Browse().click();
    		  
    		   Browse.click();
    	       Thread.sleep(4000);  // Wait for dialog to appear

    	        // Specify the file path
    	        String filePath = "E:\\Labor Upload\\Sample-FineAndDeduction_InvalidTemplateUpload.xlsx";
    	        StringSelection selection = new StringSelection(filePath);

    	        // Copy file path to clipboard
    	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

    	        // Use Robot class to paste the file path and press Enter
    	        Robot robot = new Robot();
    	        
    	        // Simulate CTRL + V (Paste)
    	        robot.keyPress(KeyEvent.VK_CONTROL);
    	        robot.keyPress(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_V);
    	        robot.keyRelease(KeyEvent.VK_CONTROL);
    	        
    	        // Press Enter to confirm the upload
                robot.keyPress(KeyEvent.VK_ENTER);
    	        robot.keyRelease(KeyEvent.VK_ENTER);

    	      //  System.out.println("File uploaded successfully!");
    		//   LoginLocators.Uploads().click();
    	        Thread.sleep(9000);
    	        Uploads.click();
    		   Thread.sleep(7000);
    		   
    		   String attendance = LoginLocators.UploadSuccessfully().getText();
    		   Thread.sleep(2000);
    		   LoginLocators.OK().click();
    		   Thread.sleep(2000);	
    		   LoginLocators.Refresh().click();
    		   Thread.sleep(2000);	
    		   if(attendance.equalsIgnoreCase("Invalid Headers"))
    		   {
    			   test.log(LogStatus.PASS,  attendance);
    		   }
    		   else {
    			   test.log(LogStatus.FAIL,   attendance);

    		   }
            }
            
		}	
}
else {
	
	test.log(LogStatus.PASS, "The attendance template is not available for upload.");	

}
		
		
		   
		}
		
		catch(Exception e) {
			test.log(LogStatus.FAIL, "Attendance Not present");

		}
		

		 
	}
	
	


public static void WorkspaceErroorFileDownload( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(2000);
	LoginLocators.ComplianceDropdown().click();
	Thread.sleep(2000);
	LoginLocators.ClickRegister().click();
	Thread.sleep(2000);
	LoginLocators.SelectActDropdown().click();
	Thread.sleep(2000);
	LoginLocators.ClickAct().click();
	Thread.sleep(2000);
	LoginLocators.YearDropdown().click();
	Thread.sleep(2000);
	LoginLocators.Clickyear().click();
	Thread.sleep(2000);
	LoginLocators.PeriodDropdown().click();
	Thread.sleep(2000);
	LoginLocators.ClickPeriod().click();
	Thread.sleep(2000);
	LoginLocators.AllFile().click();
	Thread.sleep(2000);
	LoginLocators.SelectAllCheckbox().click();
	Thread.sleep(2000);
	LoginLocators.branch().click();
	Thread.sleep(2000);
	LoginLocators.ExpandBranch().click();
	Thread.sleep(2000);
	LoginLocators.branchvalue().click();
	Thread.sleep(2000);
	LoginLocators.ApplyButton().click();
	Thread.sleep(6000);
	LoginLocators.CheckBox().click();
	Thread.sleep(2000);
	LoginLocators.Proceed().click();
	Thread.sleep(9000);	
	try {
   if(LoginLocators.SalaryText().isDisplayed() ) {
	WebElement table = getDriver().findElement(By.xpath("//table[@class='k-grid-table k-table k-table-md']"));
    List<WebElement> rows = table.findElements(By.tagName("tr"));

    int Row_Count = rows.size();

	for (int i = 1; i <= Row_Count; i++) {
        // Construct the dynamic XPath
     //   String dynamicXPath = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
      //  List<WebElement> columns = getDriver().findElements(By.xpath(dynamicXPath));
        
        String column = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td";
        WebElement col = getDriver().findElement(By.xpath(column));
        String t = col.getText();
        

        String textsalary = LoginLocators.SalaryText().getText();
        System.out.print(t + " | "+ textsalary); // Print text of each column
        if(textsalary.equalsIgnoreCase(t)) {
        String Template = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[1]";
        WebElement AttendanceTemplate = getDriver().findElement(By.xpath(Template));
        
        String Brows = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[2]";
        WebElement Browse = getDriver().findElement(By.xpath(Brows));
      
        String upload = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//button[@class='figma-btn-blue']";
        WebElement Uploads = getDriver().findElement(By.xpath(upload));
        
        String downloadErrorFile = "//table[@class='k-grid-table k-table k-table-md']//tr[" + i + "]//td/following-sibling::td[3]";
        WebElement DownloadErrorFile = getDriver().findElement(By.xpath(downloadErrorFile));
        
        
        
        	Thread.sleep(2000);	
			File dir2 = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(9000);
			
	//	LoginLocators.AttendanceTemplate().click();
			AttendanceTemplate.click();
		 	Thread.sleep(18000);
			File dir3 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
			
		   
	        Thread.sleep(9000);
	   if (dirContents1.length < allFilesNew1.length) {
			//test.log(LogStatus.PASS,  "Attendance Template Downloaded.");
			}
		   else
		   {
			//	test.log(LogStatus.FAIL, "Attendance Template Does Not Downloaded.");
			}		
		   Thread.sleep(3000);
		 //  LoginLocators.Browse().click();
		  
		   Browse.click();
	       Thread.sleep(4000);  // Wait for dialog to appear

	        // Specify the file path
	        String filePath = "E:\\Labor Upload\\Sample-MonthlySalary_ErrorFile.xlsx";
	        StringSelection selection = new StringSelection(filePath);

	        // Copy file path to clipboard
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

	        // Use Robot class to paste the file path and press Enter
	        Robot robot = new Robot();
	        
	        // Simulate CTRL + V (Paste)
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        
	        // Press Enter to confirm the upload
            robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);

	      //  System.out.println("File uploaded successfully!");
		//   LoginLocators.Uploads().click();
	        Thread.sleep(9000);
	        Uploads.click();
		   Thread.sleep(7000);
		   
		   String attendance = LoginLocators.UploadSuccessfully().getText();
		   Thread.sleep(2000);
		   LoginLocators.OK().click();
		   Thread.sleep(2000);	
		   LoginLocators.Refresh().click();
		   Thread.sleep(2000);	
		   if(attendance.equalsIgnoreCase("Invalid Headers"))
		   {
			   test.log(LogStatus.PASS,  attendance);
		   }
		   else {
			   test.log(LogStatus.FAIL,   attendance);

		   }
		   
		   Thread.sleep(2000);	
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(9000);
			
	//	LoginLocators.AttendanceTemplate().click();
			DownloadErrorFile.click();
		 	Thread.sleep(18000);
			File dirs = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dirs.listFiles();						//Counting number of files in directory after download
			
		   
	        Thread.sleep(9000);
	   if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "Error Sheet Downloaded.");
			}
		   else
		   {
			test.log(LogStatus.FAIL, "Error Sheet Does Not Downloaded.");
			}		
		   Thread.sleep(3000);
		   
        }
        
	}	
}
else {

test.log(LogStatus.PASS, "The sallary template is not available for upload.");	

}
	
	
	   
	}
	
	catch(Exception e) {
		test.log(LogStatus.FAIL, "Attendance Not present");

	}
	

	 
}


public static void ECRMasterExport( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(2000);
	LoginLocators.ECRMasterTab().click();
	Thread.sleep(3000);
	MethodsD.GridAndExcelCount(test,workbook);
	Thread.sleep(2000);
	
}

public static void ECRMasterAddNew( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
	Thread.sleep(500);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(500);
	LoginLocators.ECRMasterTab().click();
	Thread.sleep(2000);
	String id = LoginLocators.id().getText();
	Thread.sleep(500);
	LoginLocators.AddNew().click();
	Thread.sleep(500);
	LoginLocators.ClientID().click();
	LoginLocators.ClientID().sendKeys("AVACORED9");
	Thread.sleep(500);
	LoginLocators.UserID().click();
	LoginLocators.UserID().sendKeys(id+"89036");
	Thread.sleep(500);
	LoginLocators.password().click();
	LoginLocators.password().sendKeys("teamlease");
	Thread.sleep(500);
	LoginLocators.Save().click();
	Thread.sleep(500);
	String attendance = LoginLocators.UploadSuccessfully().getText();
	   Thread.sleep(2000);
	   if(attendance.equalsIgnoreCase("User Updated successfully"))
	   {
		   test.log(LogStatus.PASS,  attendance);
	   }
	   else {
		   test.log(LogStatus.FAIL,   attendance);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(2000);
	  // LoginLocators.CloseAddnewpopup().click();
	  // Thread.sleep(2000);
	
	
	
	
}

public static void ECRMasterBulkUpload( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
	Thread.sleep(500);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(500);
	LoginLocators.ECRMasterTab().click();
	Thread.sleep(2000);
	LoginLocators.BulkUpload().click();
	Thread.sleep(500);
	Thread.sleep(2000);	
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	
	Thread.sleep(9000);
	LoginLocators.SampleDocument().click();
 	Thread.sleep(18000);
	File dirs = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dirs.listFiles();						//Counting number of files in directory after download
	
   
    Thread.sleep(9000);
if (dirContents.length < allFilesNew.length) {
	test.log(LogStatus.PASS,  "Sample Document Downloaded.");
	}
   else
   {
	test.log(LogStatus.FAIL, "Sample Document Does Not Downloaded.");
	}		
   Thread.sleep(3000);
	LoginLocators.Brows().click();
	Thread.sleep(2000);
	// Specify the file path
    String filePath = "E:\\Labor Upload\\UploadPFECRMaster.xlsx";
    StringSelection selection = new StringSelection(filePath);

    // Copy file path to clipboard
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    Thread.sleep(2000);
    // Use Robot class to paste the file path and press Enter
    Robot robot = new Robot();
    
    // Simulate CTRL + V (Paste)
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    
    // Press Enter to confirm the upload
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(500);
	LoginLocators.Uploadbtn().click();
	Thread.sleep(500);
	String attendance = LoginLocators.UploadSuccessfully().getText();
	   Thread.sleep(2000);
	   if(attendance.equalsIgnoreCase("File uploaded successfully!"))
	   {
		   test.log(LogStatus.PASS,  attendance);
	   }
	   else {
		   test.log(LogStatus.FAIL,   attendance);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(2000);
	  
	
	
	
	
}

public static void ECRMasterUpdate( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
	Thread.sleep(500);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(500);
	LoginLocators.ECRMasterTab().click();
	Thread.sleep(2000);
	LoginLocators.Edit().click();
	Thread.sleep(500);
	LoginLocators.password().click();
	LoginLocators.password().clear();
	LoginLocators.password().sendKeys("abcdefgh");
	Thread.sleep(500);
	LoginLocators.Save().click();
	Thread.sleep(500);
	String attendance = LoginLocators.UploadSuccessfully().getText();
	   Thread.sleep(2000);
	   if(attendance.equalsIgnoreCase("User Updated successfully"))
	   {
		   test.log(LogStatus.PASS,  attendance);
	   }
	   else {
		   test.log(LogStatus.FAIL,   attendance);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(2000);
	   
	
	
	
	
}

public static void ECRMasterInvalidClientID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
	Thread.sleep(500);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(500);
	LoginLocators.ECRMasterTab().click();
	Thread.sleep(2000);
	LoginLocators.AddNew().click();
	Thread.sleep(500);
	LoginLocators.ClientID().click();
	LoginLocators.ClientID().sendKeys("A");
	Thread.sleep(500);
	LoginLocators.UserID().click();
	LoginLocators.UserID().sendKeys("4567890123578905");
	Thread.sleep(500);
	LoginLocators.password().click();
	LoginLocators.password().sendKeys("teamlease");
	Thread.sleep(500);
//	LoginLocators.Save().click();
	Thread.sleep(500);
	String attendance = LoginLocators.Msg().getText();
	   Thread.sleep(2000);
	   if(attendance.equalsIgnoreCase("Client ID does not exist!"))
	   {
		   test.log(LogStatus.PASS,  attendance);
	   }
	   else {
		   test.log(LogStatus.FAIL,   attendance);

	   }
	   //LoginLocators.OK().click();
	  // Thread.sleep(2000);
	   LoginLocators.CloseAddnewpopup().click();
	   Thread.sleep(2000);
	
	
	
	
}

public static void ECRMasterSearch( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(2000);
	LoginLocators.ECRMasterTab().click();
	Thread.sleep(3000);
	String searchvalue = LoginLocators.GridValue().getText();
	Thread.sleep(500);
	LoginLocators.searchuserid().click();
	Thread.sleep(3000);
	LoginLocators.searchuserid().sendKeys(searchvalue);
	Thread.sleep(3000);
	LoginLocators.searchuserid().clear();
	Thread.sleep(3000);
	LoginLocators.searchuserid().sendKeys(searchvalue);
	Thread.sleep(3000);
	LoginLocators.searchuseridDD().click();
	Thread.sleep(3000);
	LoginLocators.TotalNumberOfItem().click();					
	String s = LoginLocators.TotalNumberOfItem().getText();
	Thread.sleep(2000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		String searchvalue1 = LoginLocators.GridValue().getText();
		   test.log(LogStatus.PASS,  "Search filter Working properly : "+ searchvalue1);

	}
	else {
		   test.log(LogStatus.FAIL,  "Search filter does not working properly ");

	}
	
	
}

public static void SubcodeMasterSearch( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	LoginLocators.ESICCards().click();
	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(3000);
//	LoginLocators.ECRMasterTab().click();
//	Thread.sleep(3000);
	String searchvalue = LoginLocators.GridValue().getText();
	Thread.sleep(500);
	LoginLocators.searchuserid().click();
	Thread.sleep(3000);
	LoginLocators.searchuserid().sendKeys(searchvalue);
	Thread.sleep(3000);
	LoginLocators.searchuserid().clear();
	Thread.sleep(3000);
	LoginLocators.searchuserid().sendKeys(searchvalue);
	Thread.sleep(3000);
	LoginLocators.searchuseridDD().click();
	Thread.sleep(3000);
	LoginLocators.TotalNumberOfItem().click();					
	String s = LoginLocators.TotalNumberOfItem().getText();
	Thread.sleep(2000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		String searchvalue1 = LoginLocators.GridValue().getText();
		   test.log(LogStatus.PASS,  "Search filter Working properly : "+ searchvalue1);

	}
	else {
		   test.log(LogStatus.FAIL,  "Search filter does not working properly ");

	}
	
	
}

public static void SubcodeMasterAddNew( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	LoginLocators.ESICCards().click();
	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(3000);
//	LoginLocators.ECRMasterTab().click();
//	Thread.sleep(3000);

	Thread.sleep(500);

	LoginLocators.AddNew().click();
	String AddNewTitle = LoginLocators.AddNewPopupESIC_SubcodeMaster().getText();
	
	if(AddNewTitle.equalsIgnoreCase("Add/Edit ESIC Subcode"))
	{
		test.log(LogStatus.PASS, "+Add New Popup is opened");
		test.log(LogStatus.PASS, "+Add New Popup Title Name displayed : " +AddNewTitle);
	}
	else
	{
		test.log(LogStatus.FAIL, "+Add New Popup is not working");
	}
	
	
	LoginLocators.CloseX().click();
	Thread.sleep(3000);
	LoginLocators.Edit().click();

	Thread.sleep(3000);
	String EditPopupTitle = LoginLocators.AddNewPopupESIC_SubcodeMaster().getText();
	if(EditPopupTitle.equalsIgnoreCase("Add/Edit ESIC Subcode"))
	{
		test.log(LogStatus.PASS, "Edit Popup is opened");
		test.log(LogStatus.PASS, "Edit Popup Title Name displayed : " +EditPopupTitle);
	}
	else
	{
		test.log(LogStatus.FAIL, "Edit Popup is not working");
	}
	
	
}

public static void SubcodeMasterExportbutton( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	LoginLocators.ESICCards().click();
	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(3000);
	
	OneCommonMethod.zoomOutScreen(2);
	
	OneCommonMethod.validateExportedExcel(
		    driver.get(),
		    test,
		    LoginLocators.Export(),            // Export button WebElement
		    LoginLocators.TotalNumberOfItems(),   // Count ka dynamic locator
		    "password"                                  //Header Name
		);

	
}
public static void DispensaryMasterSearch( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.DispensaryMaster().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(3000);
	
	LoginLocators.searchStatedropdown().click(); 
	Thread.sleep(3000);
	LoginLocators.searchStatedropdown().sendKeys("Maharashtra" , Keys.ENTER);
	Thread.sleep(5000);

	String searchStateDropdown = getDriver().findElement(By.xpath("(//div[normalize-space()='Maharashtra'])")).getText();
	
	if(searchStateDropdown.equalsIgnoreCase("Maharashtra"))
	{
		test.log(LogStatus.PASS,  "Search State/Select State dropdown is working fine");
		test.log(LogStatus.PASS,  "Search value is : " + searchStateDropdown);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Search State/Select State dropdown is not working");
	}
	Thread.sleep(5000);
	
	
	LoginLocators.Serach().sendKeys("Nashik" , Keys.ENTER);
	String TypeToSearchField = getDriver().findElement(By.xpath("//div[normalize-space()='Nashik']")).getText();
	Thread.sleep(5000);
	if(TypeToSearchField.equalsIgnoreCase("Nashik"))
	{
		test.log(LogStatus.PASS,  "Type to search field is working fine");
		test.log(LogStatus.PASS,  "Search value is : " + TypeToSearchField);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Type to search field is not working");
	}
	
}
public static void DispensaryMasterAddNew( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.DispensaryMaster().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(3000);
	
	LoginLocators.searchStatedropdown().click(); 
	Thread.sleep(3000);
	LoginLocators.searchStatedropdown().sendKeys("Maharashtra" , Keys.ENTER);
	Thread.sleep(5000);
	
	LoginLocators.AddNewBtn().click();
	
	String AddNewTitle = LoginLocators.AddNewPopupESIC_SubcodeMaster().getText();
	
	if(AddNewTitle.equalsIgnoreCase("Add/Edit New Dispencery"))
	{
		test.log(LogStatus.PASS, "+Add New Popup is opened");
		test.log(LogStatus.PASS, "+Add New Popup Title Name displayed : " +AddNewTitle);
	}
	else
	{
		test.log(LogStatus.FAIL, "+Add New Popup is not working");
	}
	
	Thread.sleep(5000);
	if(LoginLocators.CloseAddnewpopup().isDisplayed())
	{
		LoginLocators.CloseAddnewpopup().click();
		test.log(LogStatus.PASS, "Close x button is working fine");
	}
	else
	{
		test.log(LogStatus.FAIL, "Close x button is not working");
	}
	
	
	
	
}
public static void DispensaryMasterExport( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.DispensaryMaster().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(5000);
	
	
	LoginLocators.searchStatedropdown().click(); 
	Thread.sleep(3000);
	LoginLocators.searchStatedropdown().sendKeys("Maharashtra" , Keys.ENTER);
	
	
	OneCommonMethod.zoomOutScreen(2);
	
	OneCommonMethod.validateExportedExcel(
		    driver.get(),
		    test,
		    LoginLocators.Export(),            // Export button WebElement
		    LoginLocators.TotalNumberOfItems(),   // Count ka dynamic locator
		    "DistrictName"                                  //Header Name
		);
	
}
public static void DispensaryMasterEditPopup( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.DispensaryMaster().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(5000);
	
	
	LoginLocators.searchStatedropdown().click(); 
	Thread.sleep(3000);
	LoginLocators.searchStatedropdown().sendKeys("Maharashtra" , Keys.ENTER);
	
	LoginLocators.Edit().click();
	
	String AddNewTitle = LoginLocators.AddNewPopupESIC_SubcodeMaster().getText();
	
	if(AddNewTitle.equalsIgnoreCase("Add/Edit New Dispencery"))
	{
		test.log(LogStatus.PASS, "Edit Popup is opened");
		test.log(LogStatus.PASS, "Edit Popup Title Name displayed : " +AddNewTitle);
	}
	else
	{
		test.log(LogStatus.FAIL, "Edit button is not working");
	}
	
	Thread.sleep(5000);
	if(LoginLocators.CloseAddnewpopup().isDisplayed())
	{
		LoginLocators.CloseAddnewpopup().click();
		test.log(LogStatus.PASS, "Close x button is working fine");
	}
	else
	{
		test.log(LogStatus.FAIL, "Close x button is not working");
	}
	
}
public static void ESICInputs_NewGeneration( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.ESICInputs().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(5000);
	
	
	OneCommonMethod.validateFileDownloadDynamic(
		    driver.get(),
		    test,
		    LoginLocators.SampleEmployeeDocument(),   // WebElement
		    "Sample Employee File is downloaded"   // Dynamic log message
		);
	
	OneCommonMethod.validateFileDownloadDynamic(
		    driver.get(),
		    test,
		    LoginLocators.SampleFamilyDetails(),   // WebElement
		    "Sample Family Details File is downloaded"   // Dynamic log message
		);
	
}
public static void ESICInputs_NewGeneration_UploadValidation( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.ESICInputs().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(5000);
	
	LoginLocators.Validation_Upload1().click();
	
	String Employee = LoginLocators.MessageDisplayed1().getText();
	if(Employee.equalsIgnoreCase("You have not chosen any file"))
	{
		test.log(LogStatus.PASS,  "Employee Upload Validation displayed : "+ Employee);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Employee Upload Validation displayed : "+ Employee);
	}
	Thread.sleep(5000);
	LoginLocators.ClickOK().click();
	Thread.sleep(3000);
	
	LoginLocators.Validation_Upload2().click();
	
	String FamilyDetails = LoginLocators.MessageDisplayed1().getText();
	if(FamilyDetails.equalsIgnoreCase("You have not chosen any file"))
	{
		test.log(LogStatus.PASS,  "Family Details Upload Validation displayed : "+ FamilyDetails);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Family Details Upload Validation displayed : "+ FamilyDetails);
	}
	Thread.sleep(5000);
	LoginLocators.ClickOK().click();
	Thread.sleep(3000);
	
	LoginLocators.Validation_Upload3().click();
	
	String SelfPhotoUpload = LoginLocators.MessageDisplayed1().getText();
	if(SelfPhotoUpload.equalsIgnoreCase("Please select a file to upload"))
	{
		test.log(LogStatus.PASS,  "Self Photo Upload Validation displayed : "+ SelfPhotoUpload);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Self Photo Upload Validation displayed : "+ SelfPhotoUpload);
	}
	Thread.sleep(5000);
	LoginLocators.ClickOK().click();
	Thread.sleep(3000);
	
	
}
public static void uploadUsingRobot(String filePath) throws Exception {
    StringSelection selection = new StringSelection(filePath);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    Thread.sleep(2000);

    Robot robot = new Robot();
    Thread.sleep(2000);
    robot.keyPress(KeyEvent.VK_CONTROL);
    Thread.sleep(2000);
    robot.keyPress(KeyEvent.VK_V);
    Thread.sleep(2000);
    robot.keyRelease(KeyEvent.VK_V);
    Thread.sleep(2000);
    robot.keyRelease(KeyEvent.VK_CONTROL);

    Thread.sleep(2000);
    robot.keyPress(KeyEvent.VK_ENTER);
    Thread.sleep(2000);
    robot.keyRelease(KeyEvent.VK_ENTER);
    Thread.sleep(2000);
}

public static void ESICInputs_NewGeneration_BrowseDelete( ExtentTest test, String user) throws Exception
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(2000);
	
	//Correct Entity Verification
    OneCommonMethod.verifyTestEntity(
    driver.get(), test,
    By.xpath("//span[normalize-space()='AVATCGEN CORE DEMO[AVACORED5]']"),
    "AVATCGEN CORE DEMO[AVACORED5]"
     );
	
	Thread.sleep(5000);
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.ESICInputs().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(5000);
	
	
	LoginLocators.Browes1_ESIC().click();
	OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\OtherTwo\\EmptySheet.xlsx");
	test.log(LogStatus.PASS,  "Emplpoyee Browse button is working fine");
	
	LoginLocators.Delete1().click();
	
	String NoFileChosen1 = LoginLocators.NoFileChosenTXT1().getText();
	
	if(NoFileChosen1.equalsIgnoreCase("No file chosen"))
	{
		test.log(LogStatus.PASS,  "Emplopyee Delete button is working fine");
		test.log(LogStatus.PASS,  "Message displayed : "+ NoFileChosen1);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Delete button is not working : "+ NoFileChosen1);
	}
	
	
	Thread.sleep(5000);
	LoginLocators.Browes2_ESIC().click();
	OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\OtherTwo\\EmptySheet.xlsx");
	test.log(LogStatus.PASS,  "Family Details Browse button is working fine");
	
	Thread.sleep(3000);
	LoginLocators.Delete2().click();
	Thread.sleep(3000);
	String NoFileChosen2 = LoginLocators.NoFileChosenTXT2().getText();
	
	if(NoFileChosen2.equalsIgnoreCase("No file chosen"))
	{
		test.log(LogStatus.PASS,  "Family Details Delete button is working fine");
		test.log(LogStatus.PASS,  "Message displayed : "+ NoFileChosen2);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Delete button is not working : "+ NoFileChosen2);
	}
	
	
	
	Thread.sleep(5000);
	LoginLocators.Browes3_ESIC().click();
	OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\OtherTwo\\Empty.zip");
	test.log(LogStatus.PASS,  "Self Photo Upload Browse button is working fine");
	
	Thread.sleep(3000);
	LoginLocators.Delete3().click();
	Thread.sleep(3000);
	String NoFileChosen3 = LoginLocators.NoFileChosenTXT2().getText();
	
	if(NoFileChosen3.equalsIgnoreCase("No file chosen"))
	{
		test.log(LogStatus.PASS,  "Self Photo Delete button is working fine");
		test.log(LogStatus.PASS,  "Message displayed : "+ NoFileChosen3);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Delete button is not working : "+ NoFileChosen3);
	}
	
	
	
	
	System.out.print(NoFileChosen3);
	

}
public static void ESICInputs_Updation_SampleFile( ExtentTest test, String user) throws Exception
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.ESICInputs().click();
	Thread.sleep(5000);
	LoginLocators.CheckBox_Updation().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(5000);
	
	
	OneCommonMethod.validateFileDownloadDynamic(
		    driver.get(),
		    test,
		    LoginLocators.SampleEmployeeDocument(),   // WebElement
		    "Sample Employee File is downloaded"   // Dynamic log message
		);
	
	OneCommonMethod.validateFileDownloadDynamic(
		    driver.get(),
		    test,
		    LoginLocators.SampleFamilyDetails(),   // WebElement
		    "Sample Family Details File is downloaded"   // Dynamic log message
		);
	
}
public static void ESICInputs_Updation_UploadValidation( ExtentTest test, String user) throws Exception
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.ESICInputs().click();
	Thread.sleep(5000);
	LoginLocators.CheckBox_Updation().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(5000);
	
	
	
	LoginLocators.Validation_Upload1().click();
	
	String Employee = LoginLocators.MessageDisplayed1().getText();
	if(Employee.equalsIgnoreCase("You have not chosen any file"))
	{
		test.log(LogStatus.PASS,  "Employee Upload Validation displayed : "+ Employee);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Employee Upload Validation displayed : "+ Employee);
	}
	Thread.sleep(5000);
	LoginLocators.ClickOK().click();
	Thread.sleep(3000);
	
	LoginLocators.Validation_Upload2().click();
	
	String FamilyDetails = LoginLocators.MessageDisplayed1().getText();
	if(FamilyDetails.equalsIgnoreCase("You have not chosen any file"))
	{
		test.log(LogStatus.PASS,  "Family Details Upload Validation displayed : "+ FamilyDetails);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Family Details Upload Validation displayed : "+ FamilyDetails);
	}
	Thread.sleep(5000);
	LoginLocators.ClickOK().click();
	Thread.sleep(3000);

}
public static void ESICInputs_Updation_BrowseDelete( ExtentTest test, String user) throws Exception
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	
	//Correct Entity Verification
    OneCommonMethod.verifyTestEntity(
    driver.get(), test,
    By.xpath("//span[normalize-space()='AVATCGEN CORE DEMO[AVACORED5]']"),
    "AVATCGEN CORE DEMO[AVACORED5]"
     );
	
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.ESICInputs().click();
	Thread.sleep(5000);
	LoginLocators.CheckBox_Updation().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(5000);
	
	
	
	
	LoginLocators.Browes1_ESIC().click();
	OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\OtherTwo\\EmptySheet.xlsx");
	test.log(LogStatus.PASS,  "Emplpoyee Browse button is working fine");
	
	LoginLocators.Delete1().click();
	
	String NoFileChosen1 = LoginLocators.NoFileChosenTXT1().getText();
	
	if(NoFileChosen1.equalsIgnoreCase("No file chosen"))
	{
		test.log(LogStatus.PASS,  "Emplopyee Delete button is working fine");
		test.log(LogStatus.PASS,  "Message displayed : "+ NoFileChosen1);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Delete button is not working : "+ NoFileChosen1);
	}
	
	
	Thread.sleep(5000);
	LoginLocators.Browes2_ESIC().click();
	OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\OtherTwo\\EmptySheet.xlsx");
	test.log(LogStatus.PASS,  "Family Details Browse button is working fine");
	
	Thread.sleep(3000);
	LoginLocators.Delete2().click();
	Thread.sleep(3000);
	String NoFileChosen2 = LoginLocators.NoFileChosenTXT2().getText();
	
	if(NoFileChosen2.equalsIgnoreCase("No file chosen"))
	{
		test.log(LogStatus.PASS,  "Family Details Delete button is working fine");
		test.log(LogStatus.PASS,  "Message displayed : "+ NoFileChosen2);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Delete button is not working : "+ NoFileChosen2);
	}
}

public static void ESICInputs_Downloads_SampleFile( ExtentTest test, String user) throws Exception
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	
	//Correct Entity Verification
    OneCommonMethod.verifyTestEntity(
    driver.get(), test,
    By.xpath("//span[normalize-space()='AVATCGEN CORE DEMO[AVACORED5]']"),
    "AVATCGEN CORE DEMO[AVACORED5]"
     );
	
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.ESICInputs().click();
	Thread.sleep(5000);
	LoginLocators.CheckBox_Downloads().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(5000);
	
	
	OneCommonMethod.validateFileDownloadDynamic(
		    driver.get(),
		    test,
		    LoginLocators.SampleEmployeeDocument(),   // WebElement
		    "Sample Download Document is downloaded"   // Dynamic log message
		);
	
	

}
public static void ESICInputs_Downloads_UploadValidation( ExtentTest test, String user) throws Exception
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	
/*	//Correct Entity Verification
    OneCommonMethod.verifyTestEntity(
    driver.get(), test,
    By.xpath("//span[normalize-space()='AVATCGEN CORE DEMO[AVACORED5]']"),
    "AVATCGEN CORE DEMO[AVACORED5]"
     ); */
	
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.ESICInputs().click();
	Thread.sleep(5000);
	LoginLocators.CheckBox_Downloads().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(5000);
	
	
	
	LoginLocators.Validation_Upload1().click();
	Thread.sleep(3000);
	String Employee = LoginLocators.MessageDisplayed1().getText();
	if(Employee.equalsIgnoreCase("You have not chosen any file"))
	{
		test.log(LogStatus.PASS,  "Downloads Upload Validation displayed : "+ Employee);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Downloads Upload Validation displayed : "+ Employee);
	}
	Thread.sleep(5000);
	LoginLocators.ClickOK().click();
	Thread.sleep(3000);
	
	

}

public static void ESICInputs_Downloads_BrowseDelete( ExtentTest test, String user) throws Exception
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	
/*	//Correct Entity Verification
    OneCommonMethod.verifyTestEntity(
    driver.get(), test,
    By.xpath("//span[normalize-space()='AVATCGEN CORE DEMO[AVACORED5]']"),
    "AVATCGEN CORE DEMO[AVACORED5]"
     ); */
	
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.ESICInputs().click();
	Thread.sleep(5000);
	LoginLocators.CheckBox_Downloads().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(5000);
	
	
	
	
	LoginLocators.Browes1_ESIC().click();
	OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\OtherTwo\\EmptySheet.xlsx");
	test.log(LogStatus.PASS,  "Downloads Browse button is working fine");
	
	LoginLocators.Delete1().click();
	
	String NoFileChosen1 = LoginLocators.NoFileChosenTXT1().getText();
	
	if(NoFileChosen1.equalsIgnoreCase("No file chosen"))
	{
		test.log(LogStatus.PASS,  "Downloads Delete button is working fine");
		test.log(LogStatus.PASS,  "Message displayed : "+ NoFileChosen1);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Delete button is not working : "+ NoFileChosen1);
	}
	
}

public static void ESICInputs_Failed_SampleDownload( ExtentTest test, String user) throws Exception
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	
/*	//Correct Entity Verification
    OneCommonMethod.verifyTestEntity(
    driver.get(), test,
    By.xpath("//span[normalize-space()='AVATCGEN CORE DEMO[AVACORED5]']"),
    "AVATCGEN CORE DEMO[AVACORED5]"
     ); */
	
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.ESICInputs().click();
	Thread.sleep(5000);
	LoginLocators.CheckBox_Failed().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(5000);
	
	
	OneCommonMethod.validateFileDownloadDynamic(
		    driver.get(),
		    test,
		    LoginLocators.SampleEmployeeDocument(),   // WebElement
		    "Failed Sample File is downloaded"   // Dynamic log message
		);
	
	

}

public static void ESICInputs_Failed_UploadValidation( ExtentTest test, String user) throws Exception
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	
/*	//Correct Entity Verification
    OneCommonMethod.verifyTestEntity(
    driver.get(), test,
    By.xpath("//span[normalize-space()='AVATCGEN CORE DEMO[AVACORED5]']"),
    "AVATCGEN CORE DEMO[AVACORED5]"
     ); */
	
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.ESICInputs().click();
	Thread.sleep(5000);
	LoginLocators.CheckBox_Failed().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(5000);
	
	
	
	LoginLocators.Validation_Upload1().click();
	
	String Employee = LoginLocators.MessageDisplayed1().getText();
	if(Employee.equalsIgnoreCase("You have not chosen any file"))
	{
		test.log(LogStatus.PASS,  "Failed Upload Validation displayed : "+ Employee);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Failed Upload Validation displayed : "+ Employee);
	}
	Thread.sleep(5000);
	LoginLocators.ClickOK().click();
	Thread.sleep(3000);
	
}

public static void ESICInputs_Failed_BrowseDelete( ExtentTest test, String user) throws Exception
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.WorkspaceArrow().click();
	Thread.sleep(5000);
	
/*	//Correct Entity Verification
    OneCommonMethod.verifyTestEntity(
    driver.get(), test,
    By.xpath("//span[normalize-space()='AVATCGEN CORE DEMO[AVACORED5]']"),
    "AVATCGEN CORE DEMO[AVACORED5]"
     ); */
	
	LoginLocators.ESICCards().click();
	Thread.sleep(5000);
	LoginLocators.ESICInputs().click();
	Thread.sleep(5000);
	LoginLocators.CheckBox_Failed().click();
	Thread.sleep(5000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(5000);
	
	
	
	LoginLocators.Browes1_ESIC().click();
	OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\OtherTwo\\EmptySheet.xlsx");
	test.log(LogStatus.PASS,  "Failed Browse button is working fine");
	
	LoginLocators.Delete1().click();
	
	String NoFileChosen1 = LoginLocators.NoFileChosenTXT1().getText();
	
	if(NoFileChosen1.equalsIgnoreCase("No file chosen"))
	{
		test.log(LogStatus.PASS,  "Failed Delete button is working fine");
		test.log(LogStatus.PASS,  "Message displayed : "+ NoFileChosen1);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Delete button is not working : "+ NoFileChosen1);
	}
	
}
public static void AddUser( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(500);
	LoginLocators.DashboardArrow().click();
	Thread.sleep(2000);
	LoginLocators.ESICCards().click();
	Thread.sleep(2000);
	LoginLocators.AddNew().click();
	Thread.sleep(500);
	LoginLocators.UserId().sendKeys("356790065467654");
	Thread.sleep(500);
	LoginLocators.password().sendKeys("teamlease");
	Thread.sleep(500);
	LoginLocators.Save().click();
	Thread.sleep(500);
	String msg = LoginLocators.MessageDisplayed1().getText();
	   Thread.sleep(2000);
	   if(msg.equalsIgnoreCase("User Updated successfully"))
	   {
		   test.log(LogStatus.PASS,  msg);
	   }
	   else {
		   test.log(LogStatus.FAIL,   msg);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(2000);
	   getDriver().navigate().refresh();
		Thread.sleep(500);
	   MethodsD.GridAndExcelCounts(test,workbook);
		Thread.sleep(2000);
		LoginLocators.Edit().click();
		Thread.sleep(500);
		LoginLocators.UserId().clear();
		LoginLocators.UserId().sendKeys("3567900654699");
		Thread.sleep(500);
		LoginLocators.password().clear();
		LoginLocators.password().sendKeys("teamlease");
		Thread.sleep(500);
		LoginLocators.Save().click();
		Thread.sleep(500);
		String msgDisplayed = LoginLocators.MessageDisplayed1().getText();
		   Thread.sleep(2000);
		   if(msgDisplayed.equalsIgnoreCase("User Updated successfully"))
		   {
			   test.log(LogStatus.PASS,  msgDisplayed);
		   }
		   else {
			   test.log(LogStatus.FAIL,   msgDisplayed);

		   }
		   LoginLocators.OK().click();
		   Thread.sleep(2000);

		
}

public static void DispensaryMaster( ExtentTest test, String user,XSSFWorkbook workbook ) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(500);
	LoginLocators.DashboardArrow().click();
	Thread.sleep(2000);
	LoginLocators.ESICCards().click();
	Thread.sleep(2000);
	LoginLocators.DispensaryMaster().click();
	Thread.sleep(2000);
	LoginLocators.ComplianceDropdown().click();
	Thread.sleep(2000);
	LoginLocators.ClickState().click();
	Thread.sleep(2000);
	LoginLocators.AddNew().click();
	Thread.sleep(500);
	
	FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook1 = WorkbookFactory.create(fis);
    Sheet sheet = workbook1.getSheetAt(1);
	Thread.sleep(2000);
 				
	Row row = sheet.getRow(3);						//Selected 0th index row (First row)
 	Cell c= row.getCell(1);						//Selected cell (0 row,1 column)
 	String district1 = c.getStringCellValue();
 	LoginLocators.districtName().sendKeys(district1);
	
 	Row row1 = sheet.getRow(4);						//Selected 0th index row (First row)
 	Cell c1= row1.getCell(1);						//Selected cell (0 row,1 column)
 	String dispensary = c1.getStringCellValue();
 	LoginLocators.dispenceryName().sendKeys(dispensary);

	//LoginLocators.districtName().sendKeys("Yavatmal"); // Writing Task title
	//Thread.sleep(2000);	
	//LoginLocators.dispenceryName().sendKeys("Yavatmal, MH (ESIS Disp.)"); // Writing Task title
	Thread.sleep(2000);
	LoginLocators.Save().click();
	Thread.sleep(500);
	String msgDisplayed = LoginLocators.MessageDisplayed1().getText();
	   Thread.sleep(2000);
	   if(msgDisplayed.equalsIgnoreCase("Dispensary Updated successfully"))
	   {
		   test.log(LogStatus.PASS,  msgDisplayed);
	   }
	   else {
		   test.log(LogStatus.FAIL,   msgDisplayed);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(2000);
	   getDriver().navigate().refresh();
		Thread.sleep(500);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickState().click();
		Thread.sleep(2000);
	   MethodsD.GridAndExcelCounts(test,workbook);
		Thread.sleep(2000);
		LoginLocators.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickState().click();
		Thread.sleep(2000);
		String district = LoginLocators.GridValue1().getText();
		Thread.sleep(2000);	
		LoginLocators.edit().click();
		Thread.sleep(2000);
		
		LoginLocators.dispenceryName().clear();
		Thread.sleep(2000);
		LoginLocators.dispenceryName().sendKeys(district +", MH (ESIS Disp.)"); // Writing Task title
		Thread.sleep(2000);
		Thread.sleep(500);
		LoginLocators.Save().click();
		Thread.sleep(500);
		String msg = LoginLocators.MessageDisplayed1().getText();
		   Thread.sleep(2000);
		   if(msg.equalsIgnoreCase("Dispensary Updated successfully"))
		   {
			   test.log(LogStatus.PASS,  msg);
		   }
		   else {
			   test.log(LogStatus.FAIL,   msg);

		   }
		   LoginLocators.OK().click();
		   Thread.sleep(2000);

	
	
	
}

public static void DispensaryMasterFilter( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(500);
	LoginLocators.DashboardArrow().click();
	Thread.sleep(2000);
	LoginLocators.ESICCards().click();
	Thread.sleep(2000);
	LoginLocators.DispensaryMaster().click();
	Thread.sleep(2000);
	LoginLocators.ComplianceDropdown().click();
	Thread.sleep(2000);
	String state = LoginLocators.ClickState().getText();
	LoginLocators.ClickState().click();
	Thread.sleep(2000);
	
	List<String> li=new ArrayList<String>();
    
    //  li.add(locationtext);
      li.add(state);
      
      
      Thread.sleep(3000);
      
		List<String> filter=new ArrayList<String>();	
		filter.add("State");
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItem().click();					
		String s = LoginLocators.TotalNumberOfItem().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> statecol=getDriver().findElements(By.xpath("//td[1]"));
		
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(statecol);
				}
				
			for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}

				for(int l=0;l<text.size();l++)
					{
				if(text.get(l).equals(li.get(i)))
					{
						pass.add(text.get(l));	
						System.out.println("pass : "+text.get(l)+" : "+li.get(i));

					}
				else
				{
					fail.add(text.get(l));		
					System.out.println("fail : "+text.get(l)+" : "+li.get(i));
					System.out.println(i);

				}
				 }
		 
	for(String Fal : fail)
		 {
				test.log(LogStatus.FAIL, filter.get(i)+" column shows incorrect value : "+Fal);
		 }	
		 for(String Pas : pass)
		 {
			 test.log(LogStatus.PASS,  filter.get(i)+" dropdown working properly.");
				test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
				System.out.println(filter.get(i)+" : "+Pas);
	 }
		 text.clear();
		pass.clear();
		fail.clear();
		raw.clear();
		
		
		}
		}else {
			test.log(LogStatus.PASS,"No records available.");	
		}
		Thread.sleep(3000);

	
}

public static void dispensaryMasterSearch( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	Thread.sleep(2000);
	LoginLocators.DashboardArrow().click();
	Thread.sleep(2000);
	LoginLocators.ESICCards().click();
	Thread.sleep(2000);
	LoginLocators.DispensaryMaster().click();
	Thread.sleep(2000);
	LoginLocators.ComplianceDropdown().click();
	Thread.sleep(2000);
	LoginLocators.ClickState().click();
	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(3000);
	String searchvalue = LoginLocators.GridValue1().getText();
	Thread.sleep(2000);

	LoginLocators.Serach().sendKeys(searchvalue);
	Thread.sleep(3000);

	LoginLocators.TotalNumberOfItem().click();					
	String s = LoginLocators.TotalNumberOfItem().getText();
	Thread.sleep(2000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		String searchvalue1 = LoginLocators.GridValue1().getText();
		   test.log(LogStatus.PASS,  "Search filter Working properly : "+ searchvalue1);

	}
	else {
		   test.log(LogStatus.FAIL,  "Search filter does not working properly ");

	}
	
}
public static void MyDocumnent(ExtentTest test,String user) throws InterruptedException, IOException, AWTException
{


	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	LoginLocators.DashboardArrow().click();
	Thread.sleep(9000);
	LoginLocators.MyDocument().click();
	Thread.sleep(2000);
	LoginLocators.AddNew().click();
	Thread.sleep(500);
	LoginLocators.SelectActivity().click();
	Thread.sleep(500);
	LoginLocators.ActivityValue().click();
	Thread.sleep(500);
	LoginLocators.SelectState().click();
	Thread.sleep(500);
	LoginLocators.StateValue().click();
	Thread.sleep(500);
	LoginLocators.Location().click();
	Thread.sleep(500);
	LoginLocators.LocationValue().click();
	Thread.sleep(500);
	LoginLocators.ClickBranch().click();
	Thread.sleep(500);
	LoginLocators.ClickBranchValue().click();
	Thread.sleep(500);
	LoginLocators.RegistrationType().click();
	Thread.sleep(500);
	LoginLocators.RegistrationTypeValue().click();
	Thread.sleep(500);
	FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook1 = WorkbookFactory.create(fis);
    Sheet sheet = workbook1.getSheetAt(3);
	Thread.sleep(2000);
 				
	Row row = sheet.getRow(0);						//Selected 0th index row (First row)
 	Cell c= row.getCell(1);						//Selected cell (0 row,1 column)
 	String rcnumber = c.getStringCellValue();
 	LoginLocators.rcnumber().sendKeys(rcnumber);
 	Thread.sleep(2000);
 	LoginLocators.chooseFile().click();
	Thread.sleep(4000);
 	
 	String filePath = "E:\\Labor Upload\\ContractsList__MyWorkspace (1).pdf";
    StringSelection selection = new StringSelection(filePath);

    // Copy file path to clipboard
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    Thread.sleep(2000);
    // Use Robot class to paste the file path and press Enter
    Robot robot = new Robot();
    
    // Simulate CTRL + V (Paste)
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    
    // Press Enter to confirm the upload
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(5000);
//	LoginLocators.rcnumber().click();
	Thread.sleep(5000);	
	LoginLocators.checkbox().click();
	Thread.sleep(500);
	LoginLocators.SaveDocument().click();
	Thread.sleep(500);
	String msg = LoginLocators.MessageDisplayed1().getText();
	   Thread.sleep(2000);
	   if(msg.equalsIgnoreCase("Record added Successfully!"))
	   {
		   test.log(LogStatus.PASS,  msg);
	   }
	   else {
		   test.log(LogStatus.FAIL,   msg);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(3000);
}
public static void MyDocumnentExport(ExtentTest test,String user) throws InterruptedException, IOException, AWTException
{


	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	LoginLocators.DashboardArrow().click();
	Thread.sleep(9000);
	LoginLocators.MyDocument().click();
	Thread.sleep(2000);
	LoginLocators.Exportbtn().click();
	Thread.sleep(2000);
	LoginLocators.Select().click();
	Thread.sleep(2000);
	LoginLocators.SelectEntityvalue().click();
	Thread.sleep(2000);
	File dir2 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
	
	Thread.sleep(9000);
	LoginLocators.Consolidated().click();
	
 	Thread.sleep(18000);
	File dir3 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
	
   
    Thread.sleep(9000);
   if (dirContents1.length < allFilesNew1.length) {
		test.log(LogStatus.PASS,  "Consolidated Report Downloaded.");
	}
   else
   {
		test.log(LogStatus.FAIL, "Consolidated Report Does Not Downloaded.");
	}		
   Thread.sleep(2000);
   File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
	
	Thread.sleep(9000);
	LoginLocators.Expired().click();
	
	Thread.sleep(18000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew2 = dir1.listFiles();						//Counting number of files in directory after download
	
  
   Thread.sleep(9000);
  if (dirContents.length < allFilesNew2.length) {
		test.log(LogStatus.PASS,  "Expired Report Downloaded.");
	}
  else
  {
		test.log(LogStatus.FAIL, "Expired Report Does Not Downloaded.");
	}		
  Thread.sleep(3000);
  File dir4 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents4 = dir4.listFiles();						//Counting number of files in directory before download
	
	Thread.sleep(9000);
	LoginLocators.CloseToExpired().click();
	
	Thread.sleep(18000);
	File dir5 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew5 = dir5.listFiles();						//Counting number of files in directory after download
	

 Thread.sleep(9000);
if (dirContents4.length < allFilesNew5.length) {
		test.log(LogStatus.PASS,  "Close To Expired Report Downloaded.");
	}
else
{
		test.log(LogStatus.FAIL, "Close To Expired Report Does Not Downloaded.");
	}		
Thread.sleep(3000);
LoginLocators.CloseAddnewpopup().click();
Thread.sleep(3000);
	
	
}

public static void MyDocumnentDigitalSignature(ExtentTest test,String user) throws InterruptedException, IOException, AWTException
{


	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
	LoginLocators.DashboardArrow().click();
	Thread.sleep(9000);
	LoginLocators.MyDocument().click();
	Thread.sleep(2000);
//	LoginLocators.DigitalSignatureTab().click();
	Thread.sleep(2000);
	LoginLocators.AddNewDS().click();
	Thread.sleep(2000);
	
	FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook1 = WorkbookFactory.create(fis);
    Sheet sheet = workbook1.getSheetAt(3);
	Thread.sleep(2000);
 				
	Row row = sheet.getRow(1);						//Selected 0th index row (First row)
 	Cell c= row.getCell(1);						//Selected cell (0 row,1 column)
 	String AuthorisedPerId = c.getStringCellValue();
 	LoginLocators.AuthorisedPerId().sendKeys(AuthorisedPerId);
 	Thread.sleep(2000);
 	
 	Row row1 = sheet.getRow(2);						//Selected 0th index row (First row)
 	Cell c1= row1.getCell(1);						//Selected cell (0 row,1 column)
 	String AuthorisedPer = c1.getStringCellValue();
 	LoginLocators.AuthorisedPer().sendKeys(AuthorisedPer);
 	Thread.sleep(2000);
 	
 	Row row2 = sheet.getRow(3);						//Selected 0th index row (First row)
 	Cell c2= row2.getCell(1);						//Selected cell (0 row,1 column)
 	String designation = c2.getStringCellValue();
 	LoginLocators.designation().sendKeys(designation);
 	Thread.sleep(2000);
 	
 	Row row3 = sheet.getRow(4);						//Selected 0th index row (First row)
 	Cell c3= row3.getCell(1);						//Selected cell (0 row,1 column)
 	int mobileNo = (int) c3.getNumericCellValue();
 	LoginLocators.mobileNo().sendKeys(String.valueOf(mobileNo));
 	Thread.sleep(2000);
 	
 	LoginLocators.EffectiveFrom().click();
	Thread.sleep(2000);
	LoginLocators.EffectiveFromDate().click();
	Thread.sleep(2000);
	LoginLocators.EffectiveTo().click();
	Thread.sleep(2000);
	LoginLocators.EffectiveToDate().click();
	Thread.sleep(2000);
 	
 	Row row4 = sheet.getRow(5);						//Selected 0th index row (First row)
 	Cell c4= row4.getCell(1);						//Selected cell (0 row,1 column)
 	String Remark = c4.getStringCellValue();
 	LoginLocators.Remark().sendKeys(Remark);
 	Thread.sleep(2000);	
 	LoginLocators.StatusDropDown().click();
	Thread.sleep(2000);
	LoginLocators.StatusValue().click();
	Thread.sleep(2000);
	LoginLocators.SaveDocument().click();
	Thread.sleep(2000);
	Thread.sleep(500);
	String msg = LoginLocators.MsgDisp().getText();
	   Thread.sleep(2000);
	   if(msg.equalsIgnoreCase("Signature added successfully!"))
	   {
		   test.log(LogStatus.PASS, "Add - "+ msg);
	   }
	   else {
		   test.log(LogStatus.FAIL,  "Add - " + msg);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(3000);
	  // LoginLocators.ClosePopup().click();
	 //  Thread.sleep(3000);
	   MethodsD.DigitalSignatureEdit(test,user);
	   
}

public static void DigitalSignatureEdit(ExtentTest test,String user) throws InterruptedException, IOException, AWTException
{


//	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
//	Thread.sleep(7000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
//	if(user.equalsIgnoreCase("Performer"))
//	{
//		LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
//	}
//	else if(user.equalsIgnoreCase("Distributor"))
//	{
//		LoginLocators.Search().sendKeys("WWKRG");	
//	}
//	else if(user.equalsIgnoreCase("Reviewer"))
//	{
//		LoginLocators.Search().sendKeys("Angular Entity");	
//	}
//	Thread.sleep(2000);
//	wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
//	LoginLocators.DashboardArrow().click();
//	Thread.sleep(2000);
//	LoginLocators.MyDocument().click();
//	Thread.sleep(2000);
//	LoginLocators.DigitalSignatureTab().click();
	Thread.sleep(2000);
	LoginLocators.Edit().click();
	Thread.sleep(2000);
	
	FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook1 = WorkbookFactory.create(fis);
    Sheet sheet = workbook1.getSheetAt(3);
	Thread.sleep(2000);
 				
	LoginLocators.AuthorisedPerId().clear();
	Thread.sleep(500);
	Row row = sheet.getRow(1);						//Selected 0th index row (First row)
 	Cell c= row.getCell(1);						//Selected cell (0 row,1 column)
 	String AuthorisedPerId = c.getStringCellValue();
 	LoginLocators.AuthorisedPerId().sendKeys(AuthorisedPerId+"2");
 	Thread.sleep(2000);
 	
 	LoginLocators.AuthorisedPer().clear();
 	Thread.sleep(500);
 	Row row1 = sheet.getRow(2);						//Selected 0th index row (First row)
 	Cell c1= row1.getCell(1);						//Selected cell (0 row,1 column)
 	String AuthorisedPer = c1.getStringCellValue();
 	LoginLocators.AuthorisedPer().sendKeys(AuthorisedPer+" kumar");
 	Thread.sleep(2000);
 	LoginLocators.designation().clear();
 	Thread.sleep(500);
 	Row row2 = sheet.getRow(3);						//Selected 0th index row (First row)
 	Cell c2= row2.getCell(1);						//Selected cell (0 row,1 column)
 	String designation = c2.getStringCellValue();
 	LoginLocators.designation().sendKeys(designation);
 	Thread.sleep(2000);
 	LoginLocators.mobileNo().clear();
 	Thread.sleep(500);
 	Row row3 = sheet.getRow(4);						//Selected 0th index row (First row)
 	Cell c3= row3.getCell(1);						//Selected cell (0 row,1 column)
 	int mobileNo = (int) c3.getNumericCellValue();
 	LoginLocators.mobileNo().sendKeys(String.valueOf(mobileNo));
 	Thread.sleep(2000);
 	
 	LoginLocators.EffectiveFrom().click();
	Thread.sleep(2000);
	LoginLocators.EffectiveFromDate().click();
	Thread.sleep(2000);
	LoginLocators.EffectiveTo().click();
	Thread.sleep(2000);
	LoginLocators.EffectiveToDate().click();
	Thread.sleep(2000);
	LoginLocators.Remark().clear();
 	Thread.sleep(500);
 	Row row4 = sheet.getRow(5);						//Selected 0th index row (First row)
 	Cell c4= row4.getCell(1);						//Selected cell (0 row,1 column)
 	String Remark = c4.getStringCellValue();
 	LoginLocators.Remark().sendKeys(Remark);
 	Thread.sleep(2000);	
 	LoginLocators.StatusDropDown().click();
	Thread.sleep(2000);
	LoginLocators.StatusValue().click();
	Thread.sleep(2000);
	LoginLocators.SaveDocument().click();
	Thread.sleep(2000);
	Thread.sleep(500);
	String msg = LoginLocators.MsgDisp().getText();
	   Thread.sleep(2000);
	   if(msg.equalsIgnoreCase("Signature added successfully!"))
	   {
		   test.log(LogStatus.PASS, "Update -"+ msg);
	   }
	   else {
		   test.log(LogStatus.FAIL, "Update -"+  msg);

	   }
	   LoginLocators.OK().click();
	   Thread.sleep(3000);
	//   LoginLocators.ClosePopup().click();
	//   Thread.sleep(3000);
	   
}

public static void MyDocumentSearch( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("TESTAUTO2");	
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.StatutoryDocumentArroww()));
		Thread.sleep(2000);
		LoginLocators.StatutoryDocumentArroww().click();
	}
	

	Thread.sleep(9000);
	LoginLocators.MyDocument().click();
	Thread.sleep(5000);
	String searchvalue = LoginLocators.GridValue().getText();
	Thread.sleep(5000);
//	LoginLocators.Search1().sendKeys(searchvalue);
	LoginLocators.Search1().sendKeys("EMP001");
//	LoginLocators.Search1().click();
//	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	js.executeScript("window.scrollBy(0,1000)");	
	Thread.sleep(3000);
	LoginLocators.TotalNumberOfItem().click();					
	String s = LoginLocators.TotalNumberOfItem().getText();
	Thread.sleep(2000);
	if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		String searchvalue1 = LoginLocators.GridValue().getText();
		   test.log(LogStatus.PASS,  "Search filter Working properly : "+ searchvalue1);

	}
	else {
		   test.log(LogStatus.FAIL,  "Search filter does not working properly ");

	}
	
}
public static void RegulatoryAbstractFilters( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("TESTAUTO2");	
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.StatutoryDocumentArroww()));
		Thread.sleep(2000);
		LoginLocators.StatutoryDocumentArroww().click();
	}
	

	Thread.sleep(9000);
	LoginLocators.RegulatoryAbstracts().click();
	Thread.sleep(5000);
	LoginLocators.SelectState_RegulatoryAbstracts().click();
	Thread.sleep(5000);
	LoginLocators.Select1st_RegulatoryAbstracts().click();
	Thread.sleep(5000);
	LoginLocators.SelectAct_RegulatoryAbstracts().click();
	Thread.sleep(5000);
	LoginLocators.Select1st_RegulatoryAbstracts().click();
	Thread.sleep(5000);
	String gridValue = getDriver().findElement(By.xpath("//div[@title='Maharashtra']")).getText();
	
	if(gridValue.equalsIgnoreCase("Maharashtra"))
	{
		test.log(LogStatus.PASS,  "Select State dropdown is working fine");
		Thread.sleep(53);
		test.log(LogStatus.PASS,  "Select Act dropdown is working fine");
		Thread.sleep(150);
		test.log(LogStatus.PASS,  "Value displayed in grid : " + gridValue);
	}
	else
	{
		test.log(LogStatus.FAIL,  "Filters are not working !");
	}
	Thread.sleep(5000);
	if(LoginLocators.Clear().isEnabled() && LoginLocators.Clear().isDisplayed())
	{
		LoginLocators.Clear().click();
		test.log(LogStatus.PASS,  "Clear button is wroking fine");
	}
	else
	{
		test.log(LogStatus.FAIL,  "Clear button is not wroking");
	}
	
}

public static void RegulatoryAbstractUpload( ExtentTest test, String user) throws Exception
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("TESTAUTO2");	
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.StatutoryDocumentArroww()));
		Thread.sleep(2000);
		LoginLocators.StatutoryDocumentArroww().click();
	}
	

	Thread.sleep(9000);
	LoginLocators.RegulatoryAbstracts().click();
	Thread.sleep(5000);
	
	LoginLocators.Upload_RegulatoryAbstracts().click();
	Thread.sleep(5000);
	LoginLocators.SelectState2_RegulatoryAbstracts().click();
	Thread.sleep(2000);
	LoginLocators.Select1stValueInUpload_RegulatoryAbstracts().click();
	Thread.sleep(2000);
	LoginLocators.SelectAct2_RegulatoryAbstracts().click();
	Thread.sleep(2000);
	LoginLocators.Select1stValueInUpload_RegulatoryAbstracts().click();
	Thread.sleep(2000);
	LoginLocators.SelectBranch_RegulatoryAbstracts().click();
	Thread.sleep(2000);
	LoginLocators.Select1stValueInUpload_RegulatoryAbstracts().click();
	Thread.sleep(2000);
	LoginLocators.SelectDisplayType_RegulatoryAbstracts().click();
	Thread.sleep(2000);
	LoginLocators.Select1stValueInUpload_RegulatoryAbstracts().click();
	
	Thread.sleep(2000);
	LoginLocators.SelectHardCopyCheckBox_RegulatoryAbstracts().click();
	Thread.sleep(2000);
	LoginLocators.CourierNo_RegulatoryAbstracts().sendKeys("10");
	Thread.sleep(2000);
	LoginLocators.SelectDispatch_RegulatoryAbstracts().click();
	Thread.sleep(2000);
	LoginLocators.Select1stValueInUpload_RegulatoryAbstracts().click();
	
	LoginLocators.BrowseFile().click();
	Thread.sleep(2000);
	OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\Other Upload No need to change\\sample.pdf");
	Thread.sleep(2000);
	
	LoginLocators.Save_RegulatoryAbstracts().click();
	
	String txt = LoginLocators.GetMessageText().getText();
	
	if (txt.equalsIgnoreCase("Saved Successfully")) {
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Upload :- All dropdowns and fields are working fine");
		Thread.sleep(1500);
		test.log(LogStatus.PASS, "File is uploaded successfully");
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Success Message displayed : " + txt);

	} else {
		Thread.sleep(5000);
		test.log(LogStatus.FAIL, "Message displayed : " + txt);
	}
	
	
}
public static void RegulatoryAbstractUploadError( ExtentTest test, String user) throws Exception
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("TESTAUTO2");	
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.StatutoryDocumentArroww()));
		Thread.sleep(2000);
		LoginLocators.StatutoryDocumentArroww().click();
	}
	

	Thread.sleep(9000);
	LoginLocators.RegulatoryAbstracts().click();
	Thread.sleep(5000);
	
	LoginLocators.Upload_RegulatoryAbstracts().click();
	Thread.sleep(8000);
	
	LoginLocators.Save_RegulatoryAbstracts().click();
	
	String documentTypeError = getDriver().findElement(By.xpath("(//div[@class='text-danger ng-star-inserted'])[1]")).getText();
	
	if (documentTypeError.equalsIgnoreCase("Select document type")) {
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Without selecting Document Type error message is displayed :- " + documentTypeError);

	} else {
		Thread.sleep(5000);
		test.log(LogStatus.FAIL, "Message displayed : " + documentTypeError);
	}
	
	Thread.sleep(5000);
	String FileUploadError = getDriver().findElement(By.xpath("(//div[@class='text-danger ng-star-inserted'])[2]")).getText();
	
	if (FileUploadError.equalsIgnoreCase("File is required.")) {
		Thread.sleep(5000);
		test.log(LogStatus.PASS, "Without Uploading file error message is displayed :- " + FileUploadError);

	} else {
		Thread.sleep(5000);
		test.log(LogStatus.FAIL, "Message displayed : " + FileUploadError);
	}
	
	WebElement closeBth = getDriver().findElement(By.xpath("(//div[@class='text-danger ng-star-inserted'])[2]"));
	
	if(closeBth.isDisplayed() && closeBth.isEnabled())
	{
		closeBth.click();
		test.log(LogStatus.PASS, "Close x button is working fine");
	}
}

public static void RegulatoryAbstractRegional( ExtentTest test, String user) throws Exception
{

//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
	WebDriverWait wait = new WebDriverWait(getDriver(), (120));
	Thread.sleep(7000);
	wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer Regional"))
	{
		LoginLocators.Search().sendKeys("TESTAUTO2");	
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.StatutoryDocumentArroww()));
		Thread.sleep(2000);
		LoginLocators.StatutoryDocumentArroww().click();
		
		
		Thread.sleep(9000);
		LoginLocators.RegulatoryAbstracts().click();
		Thread.sleep(5000);
		OneCommonMethod.validateFileDownloadDynamic(
			    driver.get(),
			    test,
			    LoginLocators.RegionalDownload_RegulatoryAbstracts(),   // WebElement
			    "Regional File is downloaded successfully"   // Dynamic log message
			);

		Thread.sleep(5000);
		LoginLocators.RegionalView_RegulatoryAbstracts().click();
		Thread.sleep(5000);
		if(LoginLocators.close().isDisplayed())
		{
			Thread.sleep(8000);
			LoginLocators.close().click();
			test.log(LogStatus.PASS, "Regional File view successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Regional File view button not working");
		}
	}
	
	else if(user.equalsIgnoreCase("Reviewer English"))
	{
		LoginLocators.Search().sendKeys("TESTAUTO2");	
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.StatutoryDocumentArroww()));
		Thread.sleep(2000);
		LoginLocators.StatutoryDocumentArroww().click();
		
		
		Thread.sleep(9000);
		LoginLocators.RegulatoryAbstracts().click();
		Thread.sleep(5000);
		OneCommonMethod.validateFileDownloadDynamic(
			    driver.get(),
			    test,
			    LoginLocators.EnglishDownload_RegulatoryAbstracts(),   // WebElement
			    "English File is downloaded successfully"   // Dynamic log message
			);

		Thread.sleep(5000);
		LoginLocators.EnglishView_RegulatoryAbstracts().click();
		Thread.sleep(5000);
		if(LoginLocators.close().isDisplayed())
		{
			Thread.sleep(8000);
			LoginLocators.close().click();
			test.log(LogStatus.PASS, "English File view successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "English File view button not working");
		}
	}
	
	else if(user.equalsIgnoreCase("Reviewer Acknowledgement"))
	{
		LoginLocators.Search().sendKeys("TESTAUTO2");	
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.StatutoryDocumentArroww()));
		Thread.sleep(2000);
		LoginLocators.StatutoryDocumentArroww().click();
		
		
		Thread.sleep(9000);
		LoginLocators.RegulatoryAbstracts().click();
		Thread.sleep(5000);
		OneCommonMethod.validateFileDownloadDynamic(
			    driver.get(),
			    test,
			    LoginLocators.AckDownload_RegulatoryAbstracts(),   // WebElement
			    "Acknowledgement File is downloaded successfully"   // Dynamic log message
			);

		Thread.sleep(5000);
		LoginLocators.AckView_RegulatoryAbstracts().click();
		Thread.sleep(5000);
		if(LoginLocators.close().isDisplayed())
		{
			Thread.sleep(8000);
			LoginLocators.close().click();
			test.log(LogStatus.PASS, "Acknowledgement File view successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Acknowledgement File view button not working");
		}
	}
	
	
	
}

public static void waitForLoaderToDisappear() {
    try {
        WebDriverWait wait = new WebDriverWait(getDriver(), 140);
        // Wait until loader disappears from the screen
        wait.until(ExpectedConditions.invisibilityOf(All_ClientPortal_Locators.loaderTime()));
    } catch (org.openqa.selenium.TimeoutException e) {
        System.out.println("Loader did not disappear within the expected time.");
    } catch (Exception e) {
        System.out.println("No loader found or some error: " + e.getMessage());
    }
}



public static void verifyPaginationGoToNextPage (ExtentTest test) {
    try {
        Thread.sleep(4000);

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1000)");

        WebElement nextPageBtn = getDriver().findElement(By.xpath("//button[@title='Go to the next page']"));
        js.executeScript("arguments[0].scrollIntoView(true);", nextPageBtn);
        Thread.sleep(4000);

        LoginLocators.goToNextPage();
        if (LoginLocators.goToNextPage().isEnabled()) {
            Thread.sleep(3000);
            LoginLocators.goToNextPage().click();
            test.log(LogStatus.PASS, "Pagination: Go To Next Page button is working fine");
            Thread.sleep(10000);
            LoginLocators.goToPreviousPage().click();
            test.log(LogStatus.PASS, "Pagination: Go To Previous Page button is working fine");
        } else {
            test.log(LogStatus.FAIL, "Pagination: Go To Next Page and Go To Previous Page buttons are not working");
        }
    } catch (Exception e) {
        test.log(LogStatus.ERROR, "Pagination check failed due to: " + e.getMessage());
    }
}
















}

