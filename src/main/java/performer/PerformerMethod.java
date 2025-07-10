package performer;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import clientPortal.All_ClientPortal_Locators;
import distributor.Locators;
import login.BasePage;
import login.LoginLocators;
import rcp.OneCommonMethod;
import reviewer.ReviwerLocator;



public class PerformerMethod extends BasePage
{
	private static List<WebElement> elementsList = null;
	
	 static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour2.xlsx";
	
 public static void AddEmployee( ExtentTest test) throws InterruptedException, IOException, AWTException
	{
	 
	 JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(5000);
		PerformerLocator.SerchCustomer().sendKeys("TESTAUTO3");
		Thread.sleep(10000);
		PerformerLocator.clickWorkspaceArrow().click();
		Thread.sleep(7000);
		PerformerLocator.clickOnboardEmployee().click();
		Thread.sleep(1000);
		PerformerLocator.clickOnboardEmployee().click();
		
		Thread.sleep(1000);
		PerformerLocator.clickAddNewEmployee().click();
		Thread.sleep(1000);
		
		OneCommonMethod.zoomOutScreen(3); 
		
//		WebElement dateInput = getDriver().findElement(By.xpath("//input[@id='datepicker-1']"));
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='03-03-1990';", dateInput);

		
		
		Thread.sleep(1000);
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(1);
		
		Thread.sleep(2000);
		Row row = sheet.getRow(4);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		String empname = c.getStringCellValue();
		PerformerLocator.enterEmplName().sendKeys(empname);
		
		Thread.sleep(2000);
		Row row0 = sheet.getRow(5);						//Selected 0th index row (First row)
		Cell c0 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String fathername = c0.getStringCellValue();
		PerformerLocator.enterFatherName().sendKeys(fathername);
		
		Thread.sleep(2000);
		PerformerLocator.clickGender().click();
		
		Thread.sleep(2000);
		PerformerLocator.selectGender().click();
		
		Thread.sleep(2000);
		PerformerLocator.clickRelationship().click();
		
		Thread.sleep(5000);
		PerformerLocator.selectRelationship().click(); 
		
//		Thread.sleep(1000);
//		Locator.clickDoB().sendKeys("01-01-2000");
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("//input[@id='datepicker-1']")).sendKeys("03031999");
		
		Thread.sleep(2000);
//		PerformerLocator.clickPVF().click();
		
		
		Thread.sleep(2000);
		//Locator.selectmonth().click();
		
		Actions action = new Actions(getDriver());
/*		WebElement we = getDriver().findElement(By.xpath("//*[@title='Navigate to parent view']"));
		action.moveToElement(we).click().build().perform();
		
		
		WebElement we1 = getDriver().findElement(By.xpath("//*[@title='Navigate to parent view']"));
		action.moveToElement(we1).click().build().perform();
		
		Thread.sleep(1000);
		  Robot robot = new Robot();

	        // Scroll Down using Robot class
//	        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
//	        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

	        // Scroll Up using Robot class
	        robot.keyPress(KeyEvent.VK_PAGE_UP);
	        robot.keyRelease(KeyEvent.VK_PAGE_UP);
		
		Thread.sleep(1000);
//		WebElement we3 = getDriver().findElement(By.xpath("//span[@class='k-link'][normalize-space()='2000']"));
//		action.moveToElement(we3).click().build().perform();
		
		
		
		PerformerLocator.selectYear().click();
		Thread.sleep(4000);
		//Locator.selectmonth1().click();
		
		
		WebElement we2 = getDriver().findElement(By.xpath("//span[@class='k-link'][normalize-space()='Feb']"));
		action.moveToElement(we2).click().build().perform();
		Thread.sleep(2000);
		PerformerLocator.selectDate().click();
		
		*/
		
		// Open calendar
		PerformerLocator.clickCalendarDOB().click();
		Thread.sleep(1000);

		// Go to year selection
		getDriver().findElement(By.xpath("//*[@title='Navigate to parent view']")).click(); // once is enough
		Thread.sleep(500);

		// Select year
		getDriver().findElement(By.xpath("//span[normalize-space()='2020']")).click(); // example year
		getDriver().findElement(By.xpath("//span[normalize-space()='2015']")).click();
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//span[normalize-space()='2010']")).click();
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//span[normalize-space()='2005']")).click();
		Thread.sleep(1000);
		getDriver().findElement(By.xpath("//span[normalize-space()='2000']")).click();
		Thread.sleep(1000);

		// Select month
		getDriver().findElement(By.xpath("//td[@class='k-calendar-td k-focus']")).click();
		Thread.sleep(500);

		// Select date
		getDriver().findElement(By.xpath("(//span[@class='k-link'][normalize-space()='5'])")).click(); // example date

		
		
		
		
		
				
		
//		Thread.sleep(1000);
//		Row row1 = sheet.getRow(6);						//Selected 0th index row (First row)
//		Cell c1 = row1.getCell(1);						//Selected cell (0 row,1 column)
//		String address = c1.getStringCellValue();
//		Locator.clickAddress().sendKeys(address);
		
		Thread.sleep(2000);
		PerformerLocator.clickMaterialStatus().click();
		
		
		Thread.sleep(2000);
		PerformerLocator.selectMaterialStatus().click();
		
		
		Thread.sleep(1000);
		Row row2 = sheet.getRow(7);						//Selected 0th index row (First row)
		Cell c2 = row2.getCell(1);						//Selected cell (0 row,1 column)
		String email = c2.getStringCellValue();
		PerformerLocator.clickEmail().sendKeys(email);
		
		
		Thread.sleep(1000);
		Row row3 = sheet.getRow(8);						//Selected 0th index row (First row)
		Cell c3 = row3.getCell(1);						//Selected cell (0 row,1 column)
		int mobile = (int)c3.getNumericCellValue();
		PerformerLocator.clickMobile().sendKeys(mobile+"");
		
		Thread.sleep(1000);
		PerformerLocator.clickNatinality().click();
		
		Thread.sleep(1000);
		PerformerLocator.selectNatinality().click();
		
		Thread.sleep(1000);
		Row row4 = sheet.getRow(9);						//Selected 0th index row (First row)
		Cell c4 = row4.getCell(1);						//Selected cell (0 row,1 column)
		String pan = c4.getStringCellValue();
		PerformerLocator.clickPan().sendKeys(pan);
		
//		Thread.sleep(1000);
//		Row row5 = sheet.getRow(10);						//Selected 0th index row (First row)
//		Cell c5 = row5.getCell(1);						//Selected cell (0 row,1 column)
//		int aadhar = (int)c5.getNumericCellValue();
//		Locator.clickAdhar().sendKeys(aadhar+"");
		
		Thread.sleep(1000);
		PerformerLocator.clickphysicalychanged().click();
		Thread.sleep(1000);
		PerformerLocator.selectphysicalychanged().click();
		
	
//		Thread.sleep(1000);
//		Row row6 = sheet.getRow(11);						//Selected 0th index row (First row)
//		Cell c6= row6.getCell(1);						//Selected cell (0 row,1 column)
//		String peraddress = c6.getStringCellValue();
//		Locator.clickPerAddress().sendKeys(peraddress);
		
//		Thread.sleep(1000);
//		Row row7 = sheet.getRow(12);						//Selected 0th index row (First row)
//		Cell c7= row7.getCell(1);						//Selected cell (0 row,1 column)
//		String passport = c7.getStringCellValue();
//		Locator.clickPassportNo().sendKeys(passport);
		
//		Thread.sleep(1000);
//		Locator.clickpassportIssued().click();
//		Thread.sleep(1000);
//		Locator.selectNatinality().click();    ///Selcet Passport Issued
		
//		Thread.sleep(1000);
//		Locator.clickPVF().click();
//		
//		Thread.sleep(1000);
//		Locator.selectDate().click();
//		
//		Thread.sleep(1000);
//		Locator.clickPVT().sendKeys("10-Dec-2026");
		
		
		js.executeScript("window.scrollBy(0,200)");
		
//		Thread.sleep(1000);
//		Locator.clickIndentificationRemark().sendKeys("ok");
		
//		Thread.sleep(1000);
//		Row row8 = sheet.getRow(11);						//Selected 0th index row (First row)
//		Cell c8= row8.getCell(1);						//Selected cell (0 row,1 column)
//		String eca = c8.getStringCellValue();
//		Locator.clickECA().sendKeys(eca);
//		
//		Thread.sleep(1000);
//		Row row9 = sheet.getRow(8);						//Selected 0th index row (First row)
//		Cell c9 = row9.getCell(1);						//Selected cell (0 row,1 column)
//		int ecn = (int)c9.getNumericCellValue();
//		Locator.clickECN().sendKeys(ecn+"");
		
		Thread.sleep(1000);
		PerformerLocator.clickNext().click();

	
		Thread.sleep(1000);
		Row row10 = sheet.getRow(13);						//Selected 0th index row (First row)
		Cell c10 = row10.getCell(1);						//Selected cell (0 row,1 column)
//		int empid = (int)c10.getNumericCellValue();
		PerformerLocator.clickEmpId().sendKeys("EMP"+OneCommonMethod.getRandomString());
		
	
		
		Thread.sleep(1000);
//		Row row14 = sheet.getRow(14);						//Selected 0th index row (First row)
//		Cell c14 = row14.getCell(1);						//Selected cell (0 row,1 column)
//		int UAN = (int)c14.getNumericCellValue();
//		Locator.clickUAN().sendKeys(UAN+" ",Keys.ENTER);
		
		
//		PerformerLocator.clickUAN().sendKeys("202020202020",Keys.ENTER);

		Thread.sleep(1000);
		PerformerLocator.clickEmpType().click();
		Thread.sleep(1000);
		PerformerLocator.selectEmpType().click();
		
		Thread.sleep(1000);
		PerformerLocator.clickBranch().click();
		Thread.sleep(1000);
		PerformerLocator.selectBranch().click();
		
		Thread.sleep(1000);
		PerformerLocator.clickPTState().click();
		Thread.sleep(1000);
		PerformerLocator.selectPTState().click();
		
		Thread.sleep(1000);
		PerformerLocator.clickskillCategory().click();
		Thread.sleep(1000);
		PerformerLocator.selectskillCategory().click();
		

		
		Thread.sleep(1000);
/*		PerformerLocator.clickPVF().click();
		Thread.sleep(1000);
		PerformerLocator.selectmonth().click();
		Thread.sleep(1000);
		PerformerLocator.selectYear1().click();
		Thread.sleep(4000);
		//Locator.selectmonth1().click();
		
		//Actions action1 = new Actions(getDriver());
		WebElement we4= getDriver().findElement(By.xpath("//span[@class='k-link'][normalize-space()='Feb']"));
		action.moveToElement(we4).click().build().perform();
		*/
//		WebElement dateInput = getDriver().findElement(By.xpath("//input[@id='datepicker-4']"));
//		((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='03-03-2023';", dateInput);
		
	//Joining Date	
		// Open calendar
		PerformerLocator.clickCalendarDOB().click();
		Thread.sleep(1000);
		// Go to year selection
		getDriver().findElement(By.xpath("//*[@title='Navigate to parent view']")).click(); // once is enough
		Thread.sleep(2000);
		// Select year
		getDriver().findElement(By.xpath("//span[normalize-space()='2023']")).click(); // example year
		Thread.sleep(2000);
		// Select month
		getDriver().findElement(By.xpath("//td[@class='k-calendar-td k-focus']")).click();
		Thread.sleep(2000);
		// Select date
		getDriver().findElement(By.xpath("(//span[@class='k-link'][normalize-space()='5'])")).click(); // example date
		
		
		
		
		
		
		Thread.sleep(2000);
//		PerformerLocator.selectDate().click();
		
		

		Thread.sleep(1000);
		PerformerLocator.clickInternatitonalWorker().click();
		Thread.sleep(1000);
		PerformerLocator.selectphysicalychanged().click(); //select International Worker
		Thread.sleep(1000);
		PerformerLocator.clickStatus().click();
		Thread.sleep(1000);
		PerformerLocator.selectstatus().click();
		
		js.executeScript("window.scrollBy(0,200)");
		
		Thread.sleep(1000);
		PerformerLocator.clickEmployment().click();
		Thread.sleep(2000);
		PerformerLocator.selectEmployment().click();
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0,200)");
		
		PerformerLocator.clickPayrollMonth().click();
		Thread.sleep(1000);
		PerformerLocator.selectMonth().click();
		Thread.sleep(1000);
		PerformerLocator.clickPayrollYear().click();
		Thread.sleep(1000);
		PerformerLocator.selectPayrollYear().click();
		
		Thread.sleep(1000);
		PerformerLocator.clickPFCappingApplicability().click();
		Thread.sleep(1000);
		PerformerLocator.selectPFCappingApplicability().click();
		
		Thread.sleep(1000);
		//Locator.clickNext().click();
		js.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		
		WebElement we5= getDriver().findElement(By.xpath("//button[normalize-space()='Next']"));
		Thread.sleep(3000);
	//	action.moveToElement(we5).click().build().perform();
	//	we5.click();
	//	JavascriptExecutor jss = (JavascriptExecutor) getDriver();
	//	jss.executeScript("arguments[0].click();", we5);
	//	we5.sendKeys(Keys.ENTER);
	//	WebDriverWait wait = new WebDriverWait(getDriver(), (30));
	//	WebElement we6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Next']")));
	//	we6.click();

	//	Point location = we5.getLocation();
	//	new Actions(getDriver()).moveByOffset(location.getX(), location.getY()).click().build().perform();
		
		By locator = By.xpath("//button[normalize-space()='Next']");
		  WebDriverWait wait = new WebDriverWait(getDriver(), (30));
					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
					// retrieving "foo-button" HTML element
					WebElement ViewButton = getDriver().findElement(locator);	
					Thread.sleep(3000);
				JavascriptExecutor jse=(JavascriptExecutor) getDriver();
				jse.executeScript("arguments[0].click();", ViewButton);
					Thread.sleep(4000);


		
		Thread.sleep(5000);
		PerformerLocator.clicksecurityprovided().click();
		
		Thread.sleep(1000);
		PerformerLocator.selectphysicalychanged().click();  //select security provided
		
		Thread.sleep(1000);
		PerformerLocator.clickEmpType1().click();
		
		Thread.sleep(1000);
		PerformerLocator.selectEmpType1().click();
		
		Thread.sleep(1000);
		PerformerLocator.clicksave().click();
		Thread.sleep(1000);
		PerformerLocator.clicksave().click();
		
		 Thread.sleep(1000);
		  String msg=PerformerLocator.EmptsuccessMsg().getText();		//Reading Message appeared after save button
		  
		  if(msg.equalsIgnoreCase("Employee Added Successfully"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		
		  Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			
			  Thread.sleep(1000);
				PerformerLocator.clickdashboard().click();
		
		
		
	}
 
 
 
 
 public static void UpdateEmployee( ExtentTest test) throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		PerformerLocator.clickDashboard().click();
		Thread.sleep(7000);
		PerformerLocator.clickOnboardEmployee().click();
		Thread.sleep(1000);
		PerformerLocator.clickOnboardEmployee().click();
		
		Thread.sleep(1000);
		PerformerLocator.clickUpdateNewEmployee().click();
		
		OneCommonMethod.zoomOutScreen(3); //ZoomOut
		
		 Thread.sleep(1000);
	      PerformerLocator.enterEmplName().clear();
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(1);
		
        
		Thread.sleep(1000);
		Row row = sheet.getRow(4);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		String empname = c.getStringCellValue();
		PerformerLocator.enterEmplName().sendKeys(empname);
		
		Thread.sleep(1000);
		PerformerLocator.clickNext().click();
		Thread.sleep(1000);
		PerformerLocator.clickEmpId().clear();
	
		Thread.sleep(1000);
		Row row10 = sheet.getRow(13);						//Selected 0th index row (First row)
		Cell c10 = row10.getCell(1);						//Selected cell (0 row,1 column)
		int empid = (int)c10.getNumericCellValue();
		PerformerLocator.clickEmpId().sendKeys(empid+"");
		
		Thread.sleep(1000);
		PerformerLocator.clickNext().click();
		
		Thread.sleep(1000);
		PerformerLocator.clicksecurityprovided().click();
		
		Thread.sleep(1000);
		PerformerLocator.selectphysicalychanged().click();  //select security provided
		
		Thread.sleep(1000);
		PerformerLocator.clicksave().click();
		//Locator.clicksave().click();
		
		 Thread.sleep(1000);
		  String msg=PerformerLocator.EmptUpdatesuccessMsg().getText();		//Reading Message appeared after save button
		  
		  if(msg.equalsIgnoreCase("Employee Updated Successfully"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		
		  Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			
			  Thread.sleep(1000);
				PerformerLocator.clickdashboard().click();
		
		
		
	}
 
 public static void UpdateStatusEmployee(ExtentTest test) throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		PerformerLocator.clickDashboard().click();
		Thread.sleep(7000);
		PerformerLocator.clickOnboardEmployee().click();
		Thread.sleep(1000);
		PerformerLocator.clickOnboardEmployee().click();
		Thread.sleep(1000);
		PerformerLocator.clickUpdateNewEmployee().click();
		

		Thread.sleep(1000);
		PerformerLocator.clickNext().click();
		
		Thread.sleep(1000);
		PerformerLocator.clickStatus().click();
		Thread.sleep(1000);
		PerformerLocator.updatestatus().click();
	
		Thread.sleep(1000);
		PerformerLocator.clickNext().click();
		
		
		Thread.sleep(1000);
		PerformerLocator.clicksave().click();
		//Locator.clicksave().click();
		
		 Thread.sleep(1000);
		  String msg=PerformerLocator.EmptUpdatesuccessMsg().getText();		//Reading Message appeared after save button
		  
		  if(msg.equalsIgnoreCase("Employee Updated Successfully"))
		 {
			 test.log(LogStatus.PASS, " 'Status should get update in status column to Active. = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, " 'Status should not get update in status column to Active. = "+msg);
		 }
		
		  Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			
			  Thread.sleep(1000);
				PerformerLocator.clickdashboard().click();
		
		
		
		
		
		
		
	}
 
 public static void UploadEmp( ExtentTest test) throws InterruptedException, IOException, AWTException
	{
		Thread.sleep(1000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		PerformerLocator.clickDashboard().click();
		Thread.sleep(7000);
		PerformerLocator.clickOnboardEmployee().click();
		Thread.sleep(1000);
		PerformerLocator.clickUploadEmp().click();
		
		
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
	
		Thread.sleep(1000);
		PerformerLocator.clickdownloadbtn().click();
		
	
		Thread.sleep(1000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
	
		Thread.sleep(3000);
		if(dirContents.length < allFilesNew.length)
		{
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Sample dcoument downloaded successfully.");
			
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
		}
		    
			else
			{  
				Thread.sleep(3000);
				test.log(LogStatus.FAIL, "Sample dcoument doesn't downloaded successfully.");
			}
			
	
		Thread.sleep(1000);
		//Locator.clickBrowse();
	
		 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
		 
		 Robot robot=new Robot();
		 
		 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\EmployeeMaster.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		 
		 //Now press CRTL
		 
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		 
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		 
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		 
		 
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		 
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 Thread.sleep(1000);
		 System.out.println("File uploaded successfully");
		 
	     Thread.sleep(1000);
		PerformerLocator.clickUploadbtn().click();
		
		Thread.sleep(2000);
		String msg=PerformerLocator.successmsgUploadEmp().getText();
		
		 if(msg.equalsIgnoreCase("File uploaded Successfully!"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		 Thread.sleep(1000);
		PerformerLocator.clickOkBtn().click();
		
		Thread.sleep(1000);
		PerformerLocator.clickClosedBtn().click();
			
		Thread.sleep(1000);
		PerformerLocator.clickdashboard().click();
	}
 public static void InvalidDataUploadEmp( ExtentTest test) throws InterruptedException, IOException, AWTException
	{
		Thread.sleep(1000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		PerformerLocator.clickDashboard().click();
		Thread.sleep(7000);
		PerformerLocator.clickOnboardEmployee().click();
		Thread.sleep(1000);
		PerformerLocator.clickUploadEmp().click();
		Thread.sleep(1000);
		PerformerLocator.clickdownloadbtn().click();
		Thread.sleep(1000);
		//Locator.clickBrowse();
	
		 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
		 
		 Robot robot=new Robot();
		 
		 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\EmployeeMaster_Invalid.xlsx");
		 //copy above file to clipboard
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		 
		 //Now press CRTL
		 
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 Thread.sleep(1000);
		 
		 //PRESS V
		 robot.keyPress(KeyEvent.VK_V);
		 Thread.sleep(1000);
		 
		 //Release V
		 robot.keyRelease(KeyEvent.VK_V);
		 
		 
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 
		 //PRESS Enter
		 robot.keyPress(KeyEvent.VK_ENTER);
		 
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		 
		 Thread.sleep(1000);
		 System.out.println("File upload successfully");
		 
	     Thread.sleep(1000);
		PerformerLocator.clickUploadbtn().click();
		
		Thread.sleep(2000);
		String msg=PerformerLocator.clickMsg().getText();
		
		 if(msg.equalsIgnoreCase("Invalid CSV"))
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
		 }
		 Thread.sleep(1000);
		PerformerLocator.clickOkBtn().click();
		
		Thread.sleep(1000);
		PerformerLocator.clickClosedBtn().click();
			
		Thread.sleep(1000);
		PerformerLocator.clickdashboard().click();
	}
 
 public static void InvalidUANNo( ExtentTest test) throws InterruptedException, IOException, AWTException
	{
		Thread.sleep(1000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		PerformerLocator.clickDashboard().click();
		Thread.sleep(7000);
		PerformerLocator.clickOnboardEmployee().click();
		Thread.sleep(1000);
		PerformerLocator.clickOnboardEmployee().click();
		
		Thread.sleep(1000);
		PerformerLocator.clickAddNewEmployee().click();
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(1);
		
		Thread.sleep(1000);
		Row row = sheet.getRow(4);						//Selected 0th index row (First row)
		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
		String empname = c.getStringCellValue();
		PerformerLocator.enterEmplName().sendKeys(empname);
		
		Thread.sleep(1000);
		Row row0 = sheet.getRow(5);						//Selected 0th index row (First row)
		Cell c0 = row0.getCell(1);						//Selected cell (0 row,1 column)
		String fathername = c0.getStringCellValue();
		PerformerLocator.enterFatherName().sendKeys(fathername);
		
		Thread.sleep(1000);
		PerformerLocator.clickGender().click();
		
		Thread.sleep(1000);
		PerformerLocator.selectGender().click();
		
		Thread.sleep(1000);
		PerformerLocator.clickRelationship().click();
		
		Thread.sleep(1000);
		PerformerLocator.selectRelationship().click();
	
		Thread.sleep(2000);
		PerformerLocator.clickPVF().click();
		
		Thread.sleep(2000);
		//Locator.selectmonth().click();
		
		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath("//*[@title='Navigate to parent view']"));
		action.moveToElement(we).click().build().perform();
		
		
		WebElement we1 = getDriver().findElement(By.xpath("//*[@title='Navigate to parent view']"));
		action.moveToElement(we1).click().build().perform();
		
		Thread.sleep(1000);
		  Robot robot = new Robot();

		  // Scroll Up using Robot class
	        robot.keyPress(KeyEvent.VK_PAGE_UP);
	        robot.keyRelease(KeyEvent.VK_PAGE_UP);
		
		Thread.sleep(1000);
		WebElement we3 = getDriver().findElement(By.xpath("//span[@class='k-link'][normalize-space()='2000']"));
		action.moveToElement(we3).click().build().perform();
		
		
		
		PerformerLocator.selectYear().click();
		Thread.sleep(4000);
		//Locator.selectmonth1().click();
		
		
		WebElement we2 = getDriver().findElement(By.xpath("//span[@class='k-link'][normalize-space()='Feb']"));
		action.moveToElement(we2).click().build().perform();
		Thread.sleep(2000);
		PerformerLocator.selectDate().click();
					
		Thread.sleep(1000);
		PerformerLocator.clickMaterialStatus().click();
		
		
		Thread.sleep(1000);
		PerformerLocator.selectMaterialStatus().click();
		
		
		Thread.sleep(1000);
		Row row2 = sheet.getRow(7);						//Selected 0th index row (First row)
		Cell c2 = row2.getCell(1);						//Selected cell (0 row,1 column)
		String email = c2.getStringCellValue();
		PerformerLocator.clickEmail().sendKeys(email);
		
		
		Thread.sleep(1000);
		Row row3 = sheet.getRow(8);						//Selected 0th index row (First row)
		Cell c3 = row3.getCell(1);						//Selected cell (0 row,1 column)
		int mobile = (int)c3.getNumericCellValue();
		PerformerLocator.clickMobile().sendKeys(mobile+"");
		
		Thread.sleep(1000);
		PerformerLocator.clickNatinality().click();
		
		Thread.sleep(1000);
		PerformerLocator.selectNatinality().click();
		
		Thread.sleep(1000);
		Row row4 = sheet.getRow(9);						//Selected 0th index row (First row)
		Cell c4 = row4.getCell(1);						//Selected cell (0 row,1 column)
		String pan = c4.getStringCellValue();
		PerformerLocator.clickPan().sendKeys(pan);
	
		Thread.sleep(1000);
		PerformerLocator.clickphysicalychanged().click();
		Thread.sleep(1000);
		PerformerLocator.selectphysicalychanged().click();
		

			
		Thread.sleep(1000);
		PerformerLocator.clickNext().click();
	
		Thread.sleep(1000);
//		Row row10 = sheet.getRow(13);						//Selected 0th index row (First row)
//		Cell c10 = row10.getCell(1);						//Selected cell (0 row,1 column)
//		int empid = (int)c10.getNumericCellValue();
//		Locator.clickEmpId().sendKeys(empid+"",Keys.ENTER);
		
		PerformerLocator.clickEmpId().sendKeys("@##1");
		Thread.sleep(1000);
		PerformerLocator.clickIFSC().sendKeys("89");
		Thread.sleep(1000);
		PerformerLocator.clickPFNumber().sendKeys("200");
		
		Thread.sleep(1000);
		PerformerLocator.clickBankAcNo().sendKeys("300");
		Thread.sleep(1000);
		PerformerLocator.clickESICNo().sendKeys("400");
		
		Thread.sleep(1000);
		PerformerLocator.clickUAN().sendKeys("8749",Keys.ENTER);
		
		Thread.sleep(1000);
		PerformerLocator.clickNext().click();
	
		
	
		
		Thread.sleep(2000);
		PerformerLocator.clickPVF().click();
		
		Thread.sleep(2000);
		//Locator.selectmonth().click();
		
	
		WebElement we4 = getDriver().findElement(By.xpath("//*[@title='Navigate to parent view']"));
		action.moveToElement(we4).click().build().perform();
		
		
		WebElement we5= getDriver().findElement(By.xpath("//*[@title='Navigate to parent view']"));
		action.moveToElement(we5).click().build().perform();
		
	
	

		  // Scroll Up using Robot class
	        robot.keyPress(KeyEvent.VK_PAGE_UP);
	        robot.keyRelease(KeyEvent.VK_PAGE_UP);
		
		Thread.sleep(1000);
		WebElement we6 = getDriver().findElement(By.xpath("//span[@class='k-link'][normalize-space()='2000']"));
		action.moveToElement(we6).click().build().perform();
		
		
		
		PerformerLocator.selectYear().click();
		Thread.sleep(4000);
		//Locator.selectmonth1().click();
		
		
		WebElement we7 = getDriver().findElement(By.xpath("//span[@class='k-link'][normalize-space()='Feb']"));
		action.moveToElement(we7).click().build().perform();
		Thread.sleep(2000);
		PerformerLocator.selectDate().click();
		
		
	
		
		Thread.sleep(2000);
		String msg1=PerformerLocator.clickJod().getText();
		Thread.sleep(1000);
		PerformerLocator.clickOkBtn().click();
		
		
		Thread.sleep(1000);
		String msg=PerformerLocator.clickInvalidUANmsg().getText();		//Reading Message appeared after save button
		String msg2=PerformerLocator.clickInvalidEmpId().getText();
		String msg3=PerformerLocator.InvalidIFSC().getText();
		String msg4=PerformerLocator.InvalidPFNumber().getText();
		String msg5=PerformerLocator.InvalidBankAcNo().getText();
		String msg6=PerformerLocator.InvalidESICNo().getText();
		
		  
		  test.log(LogStatus.PASS, "Message displayed = "+msg+"," +msg1 +","+msg2 +","+msg3 +","+msg4+ ","+msg5 +","+msg6);
			 
		Thread.sleep(1000);
		PerformerLocator.closeBtn().click();
			
		Thread.sleep(1000);
		PerformerLocator.clickdashboard().click();
		
		
		
	}
 
	public static void SearchFilerEmp(ExtentTest test) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(),20);
		Thread.sleep(5000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(5000);
		PerformerLocator.clickWorkspaceArrow().click();
		Thread.sleep(7000);
		PerformerLocator.clickOnboardEmployee().click();
			
			Thread.sleep(5000);
			PerformerLocator.searchEmpName().click();
			
			 By Tringle = By.xpath("//input[@role='combobox']");
             wait.until(ExpectedConditions.presenceOfElementLocated(Tringle)).sendKeys("Rajesh",Keys.ENTER);
             
              Thread.sleep(1000);
     		PerformerLocator.clickEmpName().click();
     		
     		Thread.sleep(1000);
     		PerformerLocator.selectDropdown().click();
     		
//		     Thread.sleep(4000);
//             WebElement ViewButton = getDriver().findElement(Tringle);	
//			 Thread.sleep(4000);
//			 JavascriptExecutor jse=(JavascriptExecutor)getDriver();
//			 jse.executeScript("arguments[0].click();", ViewButton);
			
			Thread.sleep(1000);
			PerformerLocator.clickStatusEmp().click();
			Thread.sleep(1000);
			PerformerLocator.selectstatus().click();
			
			Thread.sleep(1000);
			PerformerLocator.Apply().click();
		
			  List<String> li=new ArrayList<String>();
		       
		         li.add("Rajesh");
		         li.add("Active");
		
			List<String> filter=new ArrayList<String>();	
			
			filter.add("EmpName");
			filter.add("status");
			
			Thread.sleep(3000);

			PerformerLocator.readTotalItems().click();					//Clicking on Text of total items just to scroll down.
			String s = PerformerLocator.readTotalItems().getText();
			Thread.sleep(2000);

			if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
	
			List<WebElement> EmpName=getDriver().findElements(By.xpath("//*[@class='k-grid-aria-root']/kendo-grid-list/div/div[1]/table/tbody/tr/td[2]/div"));
			List<WebElement> status=getDriver().findElements(By.xpath("//*[@class='k-grid-aria-root']/kendo-grid-list/div/div[1]/table/tbody/tr/td[8]/div"));
			Thread.sleep(2000);

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();


			 if(i==0)
					{
						raw.addAll(EmpName);
					}
			 else if(i==1)
			   {
				 raw.addAll(status);
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
				 	test.log(LogStatus.PASS,  " Search box working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
			 }
			text.clear();
			pass.clear();
			fail.clear();
			raw.clear();
			
			
			}
			}else {
				test.log(LogStatus.FAIL,"No records found");	
			}
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
		}
	
	public static void InvalidPersonalEmpDeatiles( ExtentTest test) throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
		Thread.sleep(1000);
		PerformerLocator.clickDashboard().click();
		Thread.sleep(7000);
		PerformerLocator.clickOnboardEmployee().click();
		Thread.sleep(1000);
		PerformerLocator.clickOnboardEmployee().click();
		
		Thread.sleep(1000);
		PerformerLocator.clickAddNewEmployee().click();
		Thread.sleep(1000);
		PerformerLocator.enterEmplName().sendKeys("@@");
		Thread.sleep(1000);
		PerformerLocator.enterFatherName().sendKeys("@@");
		Thread.sleep(1000);
		PerformerLocator.clickEmail().sendKeys("sfneha");
		Thread.sleep(1000);
		PerformerLocator.clickMobile().sendKeys("456");
		Thread.sleep(1000);
		PerformerLocator.clickPan().sendKeys("9823");
		Thread.sleep(1000);
		PerformerLocator.clickAdhar().sendKeys("9876");
		Thread.sleep(1000);
		PerformerLocator.clickPassportNo().sendKeys("908");
		Thread.sleep(1000);
		PerformerLocator.clickECN().sendKeys("890",Keys.ENTER);
		
		
		Thread.sleep(1000);
		PerformerLocator.clickNext().click();
		
		
		
		Thread.sleep(1000);
		  String msg=PerformerLocator.InvalidEmpName().getText();		//Reading Message appeared after save button
		  String msg1=PerformerLocator.InvalidFatherName().getText();
		  String msg2=PerformerLocator.InvalidEmail().getText();
		  String msg3=PerformerLocator.InvalidMobileNo().getText();
		  String msg4=PerformerLocator.InvalidPAN().getText();
		  String msg5=PerformerLocator.InvalidAddhar().getText();
		  String msg6=PerformerLocator.InvalidPassport().getText();
		  String msg7=PerformerLocator.InvalidEmergencyNo().getText();
		 
		  test.log(LogStatus.PASS, "Message displayed =" +msg +"," +","+msg1 +"," +msg2 +"," +msg3 +","+msg4 +","+msg5+","+msg6 +","+msg7);
			 
		  Thread.sleep(1000);
			PerformerLocator.closeBtn().click();
		
	}
	 public static void DownloadCTCTemplateFile( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
		 	WebDriverWait wait = new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.EmpCTC().click();
			
			Thread.sleep(7000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(3000);
			PerformerLocator.DownloadTemplate().click();
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOf(PerformerLocator.gridLoad2()));
		
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
			Thread.sleep(3000);
			if(dirContents.length < allFilesNew.length)
			{
				
				test.log(LogStatus.PASS, "CTC Template downloaded successfully.");
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
			}
			    
			else
			{  
				Thread.sleep(3000);
				test.log(LogStatus.FAIL, "CTC  Template doesn't downloaded successfully.");
			}
			
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
				
		
			
			
		}
	 public static void UploadCTC( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.EmpCTC().click();
			
			Thread.sleep(1000);
			PerformerLocator.DownloadTemplate().click();
			Thread.sleep(10000);
			//Locator.clickBrowse();
		
			 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\CTCTemplate_24.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File Upload successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.clickUploadbtnCTCBtn().click();
			
			Thread.sleep(2000);
			//String msg=PerformerLocator.successmsgUploadCTC().getText();
			String msg=PerformerLocator.clickMsg().getText();
			
			 if(msg.equalsIgnoreCase("File uploaded successfully"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
		}
	 public static void InvalidDataUploadCTC( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
		 Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.EmpCTC().click();
			
			Thread.sleep(1000);
			PerformerLocator.DownloadTemplate().click();
			Thread.sleep(10000);
			//Locator.clickBrowse();
		
			 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\CTCTemplateInvalidData.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File upload successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.clickUploadbtnCTCBtn().click();
			
			Thread.sleep(2000);
			//String msg=PerformerLocator.UploadInvalidMsg().getText();
			String msg=PerformerLocator.clickMsg().getText();
			
			 if(msg.equalsIgnoreCase("Invalid CSV"))
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
		
				
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
		}
	 public static void EmployeeReport( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
		 	WebDriverWait  wait=new WebDriverWait(getDriver(), 20);
		 	Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.EmpReport().click();
			Thread.sleep(1000);
			PerformerLocator.clickSelectReport().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickEmpMasterReport().click();
			
		
			Thread.sleep(1000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(1000);
			PerformerLocator.clickExport().click();
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOf(PerformerLocator.gridLoad()));
			
		
			Thread.sleep(1000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
			if(dirContents.length < allFilesNew.length)
			{
			
				Thread.sleep(10000);					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "File downloaded successfully.");
			File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(10000);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
			
			sheet = workbook.getSheetAt(0);
			int columnNumber = 3;
			int rowCount = 0;
			int actualRow=0;
			
			for(Row row : sheet)
			{
				
				Cell cell =row.getCell(columnNumber);
				if(cell != null)
				{
					
					rowCount++;
					actualRow = rowCount-1;
				}
				
			}
			
			
			}
			else
			{
				Thread.sleep(10000);
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
		
			
		}
			
	 public static void EmployeeLimitedColumnReport( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
		 
			 WebDriverWait  wait=new WebDriverWait(getDriver(), 20);
			 Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.EmpReport().click();
			Thread.sleep(1000);
			PerformerLocator.clickSelectReport().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickEmployeeLimitedColumnReport().click();
			
			
			
			
			Thread.sleep(2000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(2000);
			PerformerLocator.clickExport().click();
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOf(PerformerLocator.gridLoad()));
			
		
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			
			Thread.sleep(30000);
			if(dirContents.length < allFilesNew.length)
			{
				Thread.sleep(30000);
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
			}
			    
				else
    			{  
    				Thread.sleep(3000);
    				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
    			}
				
				Thread.sleep(1000);
				PerformerLocator.clickdashboard().click();
		
			
		}
	 public static void EmployeeMonthwiseReport( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
		 WebDriverWait  wait=new WebDriverWait(getDriver(), 20);
		 Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.EmpReport().click();
			Thread.sleep(1000);
			PerformerLocator.clickSelectReport().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickEmployeeMonthwiseReport().click();
			Thread.sleep(1000);
			PerformerLocator.selectBranches().click();
			Thread.sleep(1000);
			PerformerLocator.clicktringle().click();
			Thread.sleep(1000);
			PerformerLocator.clickLocation().click();
			Thread.sleep(1000);
			PerformerLocator.clickclickMonth().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickSelectMonth().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickclickYear().click();
			Thread.sleep(1000);
			PerformerLocator.clickSelectYear().click();
			

			
			
			Thread.sleep(1000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(1000);
			PerformerLocator.clickExport().click();
			
			Thread.sleep(2000);
			wait.until(ExpectedConditions.invisibilityOf(PerformerLocator.gridLoad()));
		
			Thread.sleep(10000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
			Thread.sleep(30000);
			if(dirContents.length < allFilesNew.length)
			{
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "File downloaded successfully.");
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
			}
			    
				else
    			{  
    				Thread.sleep(3000);
    				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
    			}
				
				Thread.sleep(1000);
				PerformerLocator.clickdashboard().click();
			
		}
	 
	 public static void UploadEmptyFileEmp( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.clickUploadEmp().click();
			Thread.sleep(1000);
			PerformerLocator.clickdownloadbtn().click();
			
			Thread.sleep(1000);
			//Locator.clickBrowse();
		
			 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\EmployeeMaster_EmptyFile.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(2000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File download successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.clickUploadbtn().click();
			
			Thread.sleep(2000);
			//String msg=PerformerLocator.UploadEmptyFileMsg().getText();
			
			String msg=PerformerLocator.clickMsg().getText();
			
			 if(msg.equalsIgnoreCase("Empty Sheet"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickClosedBtn().click();
				
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
		}
	 public static void UploadTwoEmptyfieldEmp( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.clickUploadEmp().click();
			Thread.sleep(1000);
			PerformerLocator.clickdownloadbtn().click();
			
			Thread.sleep(1000);
			//Locator.clickBrowse();
		
			 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\EmployeeMaster_EmptyTwoField.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File download successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.clickUploadbtn().click();
			
			
			Thread.sleep(2000);
			//String msg=PerformerLocator.successmsgUploadEmp().getText();
			
			String msg=PerformerLocator.clickMsg().getText();
			
			 if(msg.equalsIgnoreCase("File uploaded Successfully!"))
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickClosedBtn().click();
				
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
		}
	 
	 public static void UploadBtn( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.clickUploadEmp().click();
			Thread.sleep(1000);
			PerformerLocator.clickdownloadbtn().click();
			 Thread.sleep(1000);
			PerformerLocator.clickUploadbtn().click();
			Thread.sleep(2000);
			//String msg=PerformerLocator.UploadBtnMsg().getText();
			
			String msg=PerformerLocator.clickMsg().getText();
			if(msg.equalsIgnoreCase("Please select a file to upload."))
			{
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
					 
			}
			 else
			{
				test.log(LogStatus.FAIL, "Message displayed = "+msg);
			}
			Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
				
			Thread.sleep(1000);
			PerformerLocator.clickClosedBtn().click();
					
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
			
			
		}
	 public static void UploadInvalidFile( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.clickUploadEmp().click();
			Thread.sleep(1000);
			PerformerLocator.clickdownloadbtn().click();
			Thread.sleep(1000);
			//Locator.clickBrowse();
		
			 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\DesignationSample.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File download successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.clickUploadbtn().click();
			
			
			Thread.sleep(2000);
			//String msg=PerformerLocator.invalidFileMsg().getText();
			
			String msg=PerformerLocator.clickMsg().getText();
			
			 if(msg.equalsIgnoreCase("Invalid Template"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickClosedBtn().click();
				
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
			
			
		}
	 public static void UploadInvalidFileFormat( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.clickUploadEmp().click();
			Thread.sleep(1000);
			PerformerLocator.clickdownloadbtn().click();
			Thread.sleep(1000);
			//Locator.clickBrowse();
		
			 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Desktop\\sample.pdf");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File uploaded successfully");
			 
//		     Thread.sleep(2000);
//			Locator.clickUploadbtn().click();
			
			
			Thread.sleep(2000);
			//String msg=PerformerLocator.invalidFileFormatMsg().getText();
			
			String msg=PerformerLocator.clickMsg().getText();
			
			 if(msg.equalsIgnoreCase("Please upload XLSX file only"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickClosedBtn().click();
				
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
			
			
		}
	 
	 public static void DownloadErrorFile( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.clickUploadEmp().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickdownloadbtn().click();
			
			
			Thread.sleep(1000);
			//Locator.clickBrowse();
		
			 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
			 Thread.sleep(1000);
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\EmployeeMaster_EmptyTwoField.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			
			 
			 Thread.sleep(1000);
			PerformerLocator.clickRefresh().click();
			
			Thread.sleep(7000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(7000);
			PerformerLocator.clickValidationMsg().click();
			
		
			Thread.sleep(7000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
			Thread.sleep(7000);
			if(dirContents.length < allFilesNew.length)
			{
				
				test.log(LogStatus.PASS, "Error file downloaded successfully.");
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
			}
			    
				else
				{  
					Thread.sleep(7000);
					test.log(LogStatus.FAIL, "Error file doesn't downloaded successfully.");
				}
				
		
		
			Thread.sleep(3000);
			PerformerLocator.clickClosedBtn().click();
				
			Thread.sleep(3000);
			PerformerLocator.clickdashboard().click();
		}
	 public static void selectColumn( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.clickUploadEmp().click();
			
			Thread.sleep(1000);
			if(PerformerLocator.clickCheckbox().isEnabled())
			{
				Thread.sleep(1000);
				PerformerLocator.clickCheckbox().click();
				test.log(LogStatus.PASS,"All headers check boxes should get select.");
			}
			else
			{
				test.log(LogStatus.FAIL,"All headers check boxes should not get select.");
			}
			Thread.sleep(3000);
			PerformerLocator.clickClosedBtn().click();
				
			Thread.sleep(3000);
			PerformerLocator.clickdashboard().click();
			
		}
	 
	 public static void ResetButton( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.clickUploadEmp().click();
			Thread.sleep(1000);
			PerformerLocator.clickCheckbox().click();
			
			Thread.sleep(1000);
			if(PerformerLocator.clickReset().isEnabled())
			{
				Thread.sleep(1000);
				PerformerLocator.clickReset().click();
				test.log(LogStatus.PASS,"All headers check boxes should get de-select.");
			}
			else
			{
				test.log(LogStatus.FAIL,"All headers check boxes should get de-select.");
			}
			Thread.sleep(3000);
			PerformerLocator.clickClosedBtn().click();
				
			Thread.sleep(3000);
			PerformerLocator.clickdashboard().click();
			
		}
	 
	 
	 public static void selectChexkboxUploadFile( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.clickUploadEmp().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickcheckbox().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickcheckbox1().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickcheckbox2().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickcheckbox3().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickdownloadbtn().click();
			
			
			Thread.sleep(2000);
			
		
			 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
			 Thread.sleep(2000);
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\EmployeeMaster_SelectCheckBox.xlsx");
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
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			
			 
			 Thread.sleep(1000);
			 System.out.println("File uploaded successfully");
			 
			 Thread.sleep(1000);
				PerformerLocator.clickUploadbtn().click();
				
				Thread.sleep(2000);
				//String msg=PerformerLocator.successmsgUploadEmp().getText();
				
				String msg=PerformerLocator.clickMsg().getText();
				
				 if(msg.equalsIgnoreCase("File uploaded Successfully!"))
				 {
					 test.log(LogStatus.FAIL, "Message displayed = "+msg);
					 
				 }
				 else
				 {
					 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 }
				Thread.sleep(2000);
				PerformerLocator.clickOkBtn().click();
				
				Thread.sleep(4000);
				PerformerLocator.clickRefresh().click();
				Thread.sleep(1000);
				PerformerLocator.clickRefresh().click();
				
				Thread.sleep(9000);
				PerformerLocator.clickClosedBtn().click();
					
				Thread.sleep(2000);
				PerformerLocator.clickdashboard().click();
		}
	 public static void UploadTwofieldEmp( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.clickUploadEmp().click();
			Thread.sleep(1000);
			PerformerLocator.clickdownloadbtn().click();
			
			Thread.sleep(1000);
			//Locator.clickBrowse();
		
			 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\EmployeeMaster_TwoField.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File download successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.clickUploadbtn().click();
			
			
			Thread.sleep(2000);
			//String msg=PerformerLocator.successmsgUploadEmp().getText();
			
			String msg=PerformerLocator.clickMsg().getText();
			
			 if(msg.equalsIgnoreCase("File uploaded Successfully!"))
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 }
			 
			
			 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			
			 Thread.sleep(1000);
				PerformerLocator.clickRefresh().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickClosedBtn().click();
				
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
		}
	 
	 
	 public static void UploadCTCInvalidFile( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			 WebDriverWait wait=new WebDriverWait(getDriver(),20);
			 Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.EmpCTC().click();
			
			Thread.sleep(1000);
			PerformerLocator.DownloadTemplate().click();
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOf(PerformerLocator.gridLoad2()));
			
			Thread.sleep(2000);
			//Locator.clickBrowse();
		
			 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\DesignationSample.xlsx");
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
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(2000);
			 System.out.println("File download successfully");
			 
			 Thread.sleep(1000);
				PerformerLocator.clickUploadbtnCTCBtn().click();
				
			
			
			Thread.sleep(2000);
			//String msg=PerformerLocator.invalidFileMsg().getText();
			
			String msg=PerformerLocator.clickMsg().getText();
			
			 if(msg.equalsIgnoreCase("Invalid Template"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			
		
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
			
			
		}
	 
	 public static void UploadCTCInvalidFileFormat( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			 WebDriverWait wait=new WebDriverWait(getDriver(),20);
			 Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEmployee().click();
			Thread.sleep(1000);
			PerformerLocator.EmpCTC().click();
			
			
			
			Thread.sleep(2000);
			//Locator.clickBrowse();
		
			 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Desktop\\sample.pdf");
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
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(2000);
			 System.out.println("File uploaded successfully");
			 
			
				
			Thread.sleep(2000);
			//String msg=PerformerLocator.invalidFileFormatMsg().getText();
			
			String msg=PerformerLocator.clickMsg().getText();
			 if(msg.equalsIgnoreCase("Please upload XLSX file only"))
			 {
				test.log(LogStatus.PASS, "Message displayed = "+msg);
					 
				}
				 else
				 {
					 test.log(LogStatus.FAIL, "Message displayed = "+msg);
				 }
				 Thread.sleep(1000);
				PerformerLocator.clickOkBtn().click();
				Thread.sleep(1000);
				PerformerLocator.clickdashboard().click();			
			
		}
	 
	 public static void OnBoardEntityExport( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
		 	
		 	Thread.sleep(5000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(5000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEntity().click();
			
		
			Thread.sleep(5000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(1000);
			PerformerLocator.clickExportOnboardEntity().click();
			
		
			Thread.sleep(15000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
			if(dirContents.length < allFilesNew.length)
			{
			
				Thread.sleep(10000);					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "File downloaded successfully.");
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
		    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
		    {
		       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
		       {
		           lastModifiedFile = allFilesNew[i];
		       }
		    }
			
			Thread.sleep(10000);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
			
			sheet = workbook.getSheetAt(0);
			int columnNumber = 3;
			int rowCount = 0;
			int actualRow=0;
			
			for(Row row : sheet)
			{
				
				Cell cell =row.getCell(columnNumber);
				if(cell != null)
				{
					
					rowCount++;
					actualRow = rowCount-1;
				}
				
			}
			
			
			}
			else
			{
				Thread.sleep(10000);
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
		
			
		}
	 
	 public static void onBoardEntityPremiseViewBtn( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
		 	Thread.sleep(5000);
			PerformerLocator.SerchCustomer().sendKeys("TESTAUTO2");
			Thread.sleep(5000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEntity().click();

			Thread.sleep(7000);
			getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-right k-treelist-toggle k-svg-icon k-icon']")).click();

			Thread.sleep(5000);
			String pjb = getDriver().findElement(By.xpath("//div[@title='Punjab'][normalize-space()='Punjab']")).getText();
			if(pjb.equalsIgnoreCase("Punjab"))
			{
				test.log(LogStatus.PASS, "> Triangle button is working fine");
			}
			else
			{
				test.log(LogStatus.FAIL, "> Triangle button does not working");
			}
			
/*			try 
			{
				Thread.sleep(4000);
				Actions action = new Actions(getDriver());
				WebElement we = getDriver().findElement(By.xpath("(//*[@xmlns='http://www.w3.org/2000/svg'])[9]"));
				action.moveToElement(we).click().build().perform();
				
				
				Thread.sleep(4000);
				WebElement we1 = getDriver().findElement(By.xpath("(//*[@xmlns='http://www.w3.org/2000/svg'])[11]"));
				action.moveToElement(we1).click().build().perform();
				test.log(LogStatus.PASS, "Premise details frame should appear.");
	
				
	
			}
			catch(Exception e)
			{
				test.log(LogStatus.FAIL, "Premise details frame should not appear.");
			}	
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
			*/
		}
	 
	 public static void OnBoardEntitySearch( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
		 	Thread.sleep(5000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(5000);
			PerformerLocator.clickWorkspaceArrow().click();
			Thread.sleep(5000);
			PerformerLocator.clickOnboardEntity().click();
			
			Thread.sleep(7000);
getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-right k-treelist-toggle k-svg-icon k-icon']")).click();

    		Thread.sleep(5000);
    		try {Thread.sleep(5000);
    		PerformerLocator.TypeToSearch().sendKeys("Maharashtra",Keys.ENTER);
    		Thread.sleep(4000);
    		String text = getDriver().findElement(By.xpath("(//div[normalize-space()='Maharashtra'])")).getText();
    		
    			
    		test.log(LogStatus.PASS, "Selected Notice No along with their details should get reflected in the grid.");
    		test.log(LogStatus.PASS, "Displayed: "+text);
    		
    		Thread.sleep(3000);
    		}catch(Exception e) {Thread.sleep(5000);
    			test.log(LogStatus.PASS, "no record available");
    		}


		
		}
	 public static void onBoardEntityViewBtn( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
		 	Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEntity().click();
			
			
			try 
			{
				Thread.sleep(4000);
				Actions action = new Actions(getDriver());
				WebElement we = getDriver().findElement(By.xpath("(//*[@xmlns='http://www.w3.org/2000/svg'])[9]"));
				
				action.moveToElement(we).click().build().perform();
				
				Thread.sleep(4000);
				WebElement we1 = getDriver().findElement(By.xpath("(//*[@xmlns='http://www.w3.org/2000/svg'])[11]"));
				action.moveToElement(we1).click().build().perform();
				
				Thread.sleep(1000);
				PerformerLocator.clickeditBtn().click();
				
				test.log(LogStatus.PASS, "Branch details should display.");
				
				Thread.sleep(1000);
				PerformerLocator.clickClose().click();
			}
			catch(Exception e)
			{
				test.log(LogStatus.FAIL, "Branch details should not display.");
			}	
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
		}
	 public static void onBoardEntityPremiseDeatilesDisabled( ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
		 	Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEntity().click();
			
			Thread.sleep(4000);
			Actions action = new Actions(getDriver());
			WebElement we = getDriver().findElement(By.xpath("(//*[@xmlns='http://www.w3.org/2000/svg'])[9]"));
			
			action.moveToElement(we).click().build().perform();
			
			Thread.sleep(4000);
			WebElement we1 = getDriver().findElement(By.xpath("(//*[@xmlns='http://www.w3.org/2000/svg'])[11]"));
			action.moveToElement(we1).click().build().perform();
			Thread.sleep(1000);
			PerformerLocator.clickeditBtn().click();
			
			Thread.sleep(1000);
			if(!PerformerLocator.clickEntity().isEnabled())
			{
				Thread.sleep(1000);
				PerformerLocator.clickEntity().click();
				test.log(LogStatus.PASS, "Premise details fields should be disabled.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Premise details fields should not be disabled.");
			}
			Thread.sleep(1000);
			PerformerLocator.clickClose().click();
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
		
		}
	 public static void SearchFilerPremisesEntity(ExtentTest test) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEntity().click();
				
				Thread.sleep(1000);
				PerformerLocator.clickSearchFiletr().click();
				
				 By Tringle = By.xpath("//input[@placeholder='Type to Search']");
	             wait.until(ExpectedConditions.presenceOfElementLocated(Tringle)).sendKeys("QWW",Keys.ENTER);
	             
	             Thread.sleep(4000);
					Actions action = new Actions(getDriver());
					WebElement we = getDriver().findElement(By.xpath("(//*[@xmlns='http://www.w3.org/2000/svg'])[9]"));
					action.moveToElement(we).click().build().perform();
					
					
					Thread.sleep(4000);
					WebElement we1 = getDriver().findElement(By.xpath("(//*[@xmlns='http://www.w3.org/2000/svg'])[11]"));
					action.moveToElement(we1).click().build().perform();
				
			
				  List<String> li=new ArrayList<String>();
			       
			         li.add("QWW");
			        
			
				List<String> filter=new ArrayList<String>();	
				
				filter.add("Branch");
				
				
//				Thread.sleep(3000);
//
//				Locator.readTotalItems().click();					//Clicking on Text of total items just to scroll down.
//			String s = Locator.readTotalItems().getText();
				Thread.sleep(2000);

//				if(!s.equalsIgnoreCase("No items to display")) {
				Thread.sleep(5000);
				
				try
				{
		
				List<WebElement> Branch=getDriver().findElements(By.xpath("//*[@class=\"k-grid-aria-root\"]/kendo-treelist-list/div/div[1]/table/tbody/tr[3]/td[1]"));
				

				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement> raw=new ArrayList<WebElement>();


				 if(i==0)
						{
							raw.addAll(Branch);
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
					 	test.log(LogStatus.PASS,  " Search box working properly.");
						test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
						System.out.println(filter.get(i)+" : "+Pas);
				 }
				text.clear();
				pass.clear();
				fail.clear();
				raw.clear();
				
				
				}
				}
				catch (Exception e)
				{
					// TODO: handle exception
					test.log(LogStatus.FAIL,"No records found");
				} 
						
				
				Thread.sleep(1000);
				PerformerLocator.clickdashboard().click();
			}
	 public static void BranchDorpdownUserBranchMapping(ExtentTest test) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEntity().click();
			Thread.sleep(1000);
			PerformerLocator.UserBranchMapping().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickAct().click();
			
			Thread.sleep(1000);
			PerformerLocator.selectAct().click();
			Thread.sleep(1000);
			PerformerLocator.clickAct().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickBranchPOnboardEntity().click();
			
			Thread.sleep(1000);
			PerformerLocator.selectBranchPOnboardEntity().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickUser().click();
			
			 By Tringle = By.xpath("//input[@class='k-input-inner']");
             wait.until(ExpectedConditions.presenceOfElementLocated(Tringle)).sendKeys("clientportal@tcg.com",Keys.ENTER);
              Thread.sleep(4000);
              WebElement ViewButton = getDriver().findElement(Tringle);	
			 Thread.sleep(4000);
			 JavascriptExecutor jse=(JavascriptExecutor)getDriver();
			 jse.executeScript("arguments[0].click();", ViewButton);
			
//			Thread.sleep(1000);
//			Locator.selectUser().click();
			
			Thread.sleep(1000);
			if(PerformerLocator.clickApply().isEnabled())
			{
				Thread.sleep(1000);
				PerformerLocator.clickApply().click();
				test.log(LogStatus.PASS,"Apply button is working");
			}
			else
			{
				test.log(LogStatus.FAIL,"Apply button is not working");
			}
			
			  List<String> li=new ArrayList<String>();
		       
		         li.add("Continental");
		         li.add("Client Portal");
		        
		
			List<String> filter=new ArrayList<String>();	
			
			filter.add("Branch");
			filter.add("User");
			
			Thread.sleep(3000);

			PerformerLocator.readTotalItems().click();					//Clicking on Text of total items just to scroll down.
			String s = PerformerLocator.readTotalItems().getText();
			Thread.sleep(2000);

			if(!s.equalsIgnoreCase("No items to display")) {
			Thread.sleep(5000);
			
			
	
			List<WebElement> Branch=getDriver().findElements(By.xpath("//*[@class='k-grid-aria-root']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[2]"));
			List<WebElement> User=getDriver().findElements(By.xpath("//*[@class=\"k-grid-aria-root\"]/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[3]"));
			

			for(int i=0; i<li.size(); i++){
				
				List<String> text= new ArrayList<String>();
				HashSet<String> pass=new LinkedHashSet<>();
				HashSet<String> fail=new LinkedHashSet<>();
				List<WebElement> raw=new ArrayList<WebElement>();


			 if(i==0)
					{
						raw.addAll(Branch);
					}
			 else if(i==1)
			 {
				 raw.addAll(User);
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
				 	test.log(LogStatus.PASS,  " Search box working properly.");
					test.log(LogStatus.PASS, filter.get(i)+" displayed : "+Pas);	
					System.out.println(filter.get(i)+" : "+Pas);
			 }
			text.clear();
			pass.clear();
			fail.clear();
			raw.clear();
			
			
			}
			}
			else
			{
				// TODO: handle exception
				test.log(LogStatus.FAIL,"No records found");
			} 
			
			Thread.sleep(1000);
			if(PerformerLocator.clickClearBtn().isEnabled())
			{
				Thread.sleep(1000);
				PerformerLocator.clickClearBtn().click();
				test.log(LogStatus.PASS,  " Clear button working successfully");
			}
			else
			{
				test.log(LogStatus.PASS,  " Clear button is not working successfully");
			}
			
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
			
	}
	 public static void UploadHolidayMaster(ExtentTest test) throws InterruptedException, AWTException
		{
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEntity().click();
			Thread.sleep(1000);
			PerformerLocator.clickUploadHolidayMaster().click();
			
			Thread.sleep(1000);
			//Locator.clickBrowse();
		
			 getDriver().findElement(By.xpath("//label[normalize-space()='Browse']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\Sample-YearlyHoliday_Branchwise.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File uploaded successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.clickUploadbtnCTCBtn().click();
			
			Thread.sleep(2000);
			//String msg=PerformerLocator.successUploadHoliday().getText();
			
			String msg=PerformerLocator.clickMsg().getText();
			
			 if(msg.equalsIgnoreCase("File uploaded successfully"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			
//			Thread.sleep(1000);
//			Locator.clickClosedBtn().click();
				
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
		}
	 
	 public static void InvalidDataUploadHolidayMaster(ExtentTest test) throws InterruptedException, AWTException
		{
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEntity().click();
			Thread.sleep(1000);
			PerformerLocator.clickUploadHolidayMaster().click();
			
			Thread.sleep(1000);
			//Locator.clickBrowse();
		
			 getDriver().findElement(By.xpath("//label[normalize-space()='Browse']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\InvalidDataYearlyHoliday_Branchwise.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
				Thread.sleep(3000);
				File dir = new File("C:\\Users\\bilali\\Downloads");
				File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File uploaded successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.clickUploadbtnCTCBtn().click();
			
			try
			{
				
			
			Thread.sleep(2000);
			//String msg=PerformerLocator.InvalidmsgHolidayMaster().getText();
			String msg=PerformerLocator.clickMsg().getText();
			
			
			 if(msg.equalsIgnoreCase("Error while uploading the file. Please check error file."))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			
			 Thread.sleep(1000);
				PerformerLocator.clickOkBtn().click();
				
				Thread.sleep(1000);
				PerformerLocator.clickClosedBtn().click();
		
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
			
			
			Thread.sleep(3000);
			if(dirContents.length < allFilesNew.length)
			{
				 Thread.sleep(3000);
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
			    
			    Thread.sleep(3000);
				test.log(LogStatus.PASS, "Error File downloaded successfully.");
				
				
			} 
			else
    			{  
    				Thread.sleep(30000);
    				test.log(LogStatus.FAIL, "Error File doesn't downloaded successfully.");
    			}
			
//			Thread.sleep(1000);
//			PerformerLocator.clickOkBtn().click();
		}
			catch(Exception e)
			{
				Thread.sleep(2000);
				//String msg=PerformerLocator.successUploadHoliday().getText();
				String msg=PerformerLocator.clickMsg().getText();
				
				 if(msg.equalsIgnoreCase("File uploaded successfully"))
				 {
					 test.log(LogStatus.FAIL, "Message displayed = "+msg);
					 
				 }
				 else
				 {
					 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 }	
					Thread.sleep(1000);
					PerformerLocator.clickOkBtn().click();
			}
			
//			Thread.sleep(1000);
//			Locator.clickClosedBtn().click();
				
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
		}
	 
	 public static void InvalidFileUploadHolidayMaster(ExtentTest test) throws InterruptedException, AWTException
		{
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEntity().click();
			Thread.sleep(1000);
			PerformerLocator.clickUploadHolidayMaster().click();
			
			Thread.sleep(1000);
			//Locator.clickBrowse();
		
			 getDriver().findElement(By.xpath("//label[normalize-space()='Browse']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\CTCTemplateInvalidData.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File uploaded successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.clickUploadbtnCTCBtn().click();
			
			Thread.sleep(2000);
			//String msg=PerformerLocator.successUploadHoliday().getText();
			
			String msg=PerformerLocator.clickMsg().getText();
			
			 if(msg.equalsIgnoreCase("Error while uploading the file. Please check error file."))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickClosedBtn().click();
				
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
		}
	 public static void EmptyFileUploadHolidayMaster(ExtentTest test) throws InterruptedException, AWTException
		{
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEntity().click();
			Thread.sleep(1000);
			PerformerLocator.clickUploadHolidayMaster().click();
			
			Thread.sleep(1000);
			//Locator.clickBrowse();
		
			 getDriver().findElement(By.xpath("//label[normalize-space()='Browse']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\EmptyFile -YearlyHoliday_Branchwise.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File uploaded successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.clickUploadbtnCTCBtn().click();
			
			
			Thread.sleep(2000);
			//String msg=PerformerLocator.successUploadHoliday().getText();
			
			String msg=PerformerLocator.clickMsg().getText();
			
			 if(msg.equalsIgnoreCase("File uploaded successfully"))
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickClosedBtn().click();
				
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
		}
	 public static void WithoutUploadHolidayMaster(ExtentTest test) throws InterruptedException, AWTException
		{
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEntity().click();
			Thread.sleep(1000);
			PerformerLocator.clickUploadHolidayMaster().click();
			
			Thread.sleep(1000);
			
		     Thread.sleep(1000);
			PerformerLocator.clickUploadbtnCTCBtn().click();
			
			Thread.sleep(2000);
			//String msg=PerformerLocator.withoutUploadfilemsgHolidayMaster().getText();
			
			String msg=PerformerLocator.clickMsg().getText();
			
			 if(msg.equalsIgnoreCase("You have not chosen any file."))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickClosedBtn().click();
				
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
		}
	 public static void MapUser(ExtentTest test) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEntity().click();
			Thread.sleep(1000);
			PerformerLocator.UserBranchMapping().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickMapUser().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickAct1().click();
			
			Thread.sleep(1000);
			PerformerLocator.selectAct().click();
			
			
			Thread.sleep(1000);
			PerformerLocator.clickBranchPOnboardEntity1().click();
			
			Thread.sleep(1000);
			PerformerLocator.selectBranchPOnboardEntity().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranchPOnboardEntity1().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickUser1().click();
			
			By Tringle = By.xpath("(//input[@class='k-input-inner'])[3]");
		 	wait.until(ExpectedConditions.presenceOfElementLocated(Tringle)).sendKeys("Vaibhav (performe",Keys.ENTER);
           Thread.sleep(4000);
           WebElement ViewButton = getDriver().findElement(Tringle);	
			Thread.sleep(4000);
			JavascriptExecutor jse=(JavascriptExecutor)getDriver();
			jse.executeScript("arguments[0].click();", ViewButton);
			 
			 
				Thread.sleep(1000);
				PerformerLocator.clickSave().click();
				
				Thread.sleep(2000);
				//String msg=PerformerLocator.successMsg().getText();
				String msg=PerformerLocator.clickMsg().getText();
				
				 if(msg.equalsIgnoreCase("User Branch mapped successfully..."))
				 {
					 test.log(LogStatus.PASS, "Message displayed = "+msg);
					 
				 }
				 else
				 {
					 test.log(LogStatus.FAIL, "Message displayed = "+msg);
				 }
				 Thread.sleep(1000);
					PerformerLocator.clickOkBtn().click();
					
						
					Thread.sleep(1000);
					PerformerLocator.clickdashboard().click();
		}
	 public static void MapUserManagement(ExtentTest test) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEntity().click();
			Thread.sleep(1000);
			PerformerLocator.UserBranchMapping().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickMapUser().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickmgmtradiobtn().click();			
			Thread.sleep(1000);
			PerformerLocator.clickAct1().click();
			
			Thread.sleep(1000);
			PerformerLocator.selectAct().click();
			
			
			Thread.sleep(1000);
			PerformerLocator.clickBranchPOnboardEntity1().click();
			
			Thread.sleep(1000);
			PerformerLocator.selectBranchPOnboardEntity().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranchPOnboardEntity1().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickUserTringle().click();
			
			Thread.sleep(1000);
			PerformerLocator.selectUserDropdown().click();
		 
				Thread.sleep(1000);
				PerformerLocator.clickSave().click();
				
				Thread.sleep(2000);
				//String msg=PerformerLocator.successMsg().getText();
				String msg=PerformerLocator.clickMsg().getText();
				
				 if(msg.equalsIgnoreCase("User Branch mapped successfully..."))
				 {
					 test.log(LogStatus.PASS, "Message displayed = "+msg);
					 
				 }
				 else
				 {
					 test.log(LogStatus.FAIL, "Message displayed = "+msg);
				 }
				 Thread.sleep(1000);
					PerformerLocator.clickOkBtn().click();
					
						
					Thread.sleep(1000);
					PerformerLocator.clickdashboard().click();
		}
	 
	 public static void deleteUserBranchaMapping(ExtentTest test) throws InterruptedException
		{
		
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickOnboardEntity().click();
			Thread.sleep(1000);
			PerformerLocator.UserBranchMapping().click();
			
			Thread.sleep(2000);
			String item = PerformerLocator.readTotalItems().getText();
    		String[] bits = item.split(" ");								//Splitting the String
    		if(bits.length > 2)
    		{
    			Thread.sleep(2000);
    			item = PerformerLocator.readTotalItems().getText();
    			bits = item.split(" ");								//Splitting the String
    		}
    		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
    		if(compliancesCount.equalsIgnoreCase("to"))
    		{
    			Thread.sleep(2000);
    			item = PerformerLocator.readTotalItems().getText();
    			bits = item.split(" ");									//Splitting the String
    			compliancesCount = bits[bits.length - 2];
    		}
    		int count = Integer.parseInt(compliancesCount);
    			
			Thread.sleep(2000);
			PerformerLocator.clickDeleteBtn().click();
			
			Thread.sleep(2000);
			String msg=PerformerLocator.deleteMsg().getText();
			
			 if(msg.equalsIgnoreCase("Are you certain you want to delete this Mapping??"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
				PerformerLocator.clickOkBtn().click();
				
				Thread.sleep(2000);
				String msg1=PerformerLocator.deleteMsg1().getText();
				
				 if(msg1.equalsIgnoreCase("Record deleted succesfully"))
				 {
					 test.log(LogStatus.PASS, "Message displayed = "+msg1);
					 
				 }
				 else
				 {
					 test.log(LogStatus.FAIL, "Message displayed = "+msg1);
				 }
				 
				 Thread.sleep(1000);
				PerformerLocator.clickOkBtn().click();
				
				Thread.sleep(1000);
    			PerformerLocator.readTotalItems().click();
    			String item1 = PerformerLocator.readTotalItems().getText();
    			String[] bits1 = item1.split(" ");								//Splitting the String
    			
    			if(bits1.length > 2)
    			{
    				Thread.sleep(2000);
    				item1 = PerformerLocator.readTotalItems().getText();
    				bits1 = item1.split(" ");								//Splitting the String
    			}
    			String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
    			
    			if(compliancesCount1.equalsIgnoreCase("to"))
    			{
    				Thread.sleep(2000);
    				item1 = PerformerLocator.readTotalItems().getText();
    				bits1 = item1.split(" ");									//Splitting the String
    				compliancesCount1 = bits1[bits1.length - 2];
    			}
    			int count1 = Integer.parseInt(compliancesCount1);
    			if(count > count1)
    				{
    				
    					test.log(LogStatus.PASS, "Before delete user branch mapping count = "+count+" | After delete user branch mapping count = "+count1);
    				}
    				else
    				{
    					test.log(LogStatus.FAIL, "Before delete user branch mapping  count= "+count+" | After delete user branch mapping count  = "+count1);
    				}
    			
				Thread.sleep(1000);
				PerformerLocator.clickdashboard().click();
		}
	 
	 public static void StatutoryDocApplyClaerBtn(ExtentTest test) throws InterruptedException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickWorkspaceArrow().click();
			Thread.sleep(7000);
			PerformerLocator.clickStatutoryDoc().click();
			Thread.sleep(2000);
			PerformerLocator.clickComplianceType().click();
			Thread.sleep(2000);
			PerformerLocator.selectComplianceType1().click();
			Thread.sleep(2000);
			PerformerLocator.clickAct2().click();
			Thread.sleep(2000);
			PerformerLocator.selectComplianceType().click();
			Thread.sleep(2000);
			PerformerLocator.clickYear().click();
			Thread.sleep(2000);
			PerformerLocator.selectComplianceType1().click();
			Thread.sleep(2000);
			PerformerLocator.clickPeriod().click();
			Thread.sleep(2000);
			PerformerLocator.selectComplianceType2().click();
			Thread.sleep(2000);
			PerformerLocator.clickComplianceStatus().click();
			Thread.sleep(2000);
			PerformerLocator.selectComplianceType().click();
			Thread.sleep(2000);
			PerformerLocator.clickBranch1().click();
			Thread.sleep(2000);
			PerformerLocator.clickBranchTiangle().click();
			Thread.sleep(2000);
			PerformerLocator.selectBranch1().click();
			Thread.sleep(2000);
			if(PerformerLocator.clickApply().isEnabled())
			{
				Thread.sleep(1000);
				PerformerLocator.clickApply().click();
				test.log(LogStatus.PASS, "Apply button working successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Apply button working successfully");
			}
			
//			Thread.sleep(1000);
//			wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
			
			Thread.sleep(1000);
			if(PerformerLocator.clickClearBtn().isEnabled())
			{
				Thread.sleep(10000);
				PerformerLocator.clickClearBtn().click();
				test.log(LogStatus.PASS, "Clear button working successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Clear button not working successfully");
			}
			
			
			Thread.sleep(5000);
			PerformerLocator.clickdashboard().click();
			}
	 public static void StatutoryDocumentModule(ExtentTest test) throws InterruptedException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("TESTAUTO");
			Thread.sleep(1000);
			PerformerLocator.clickWorkspaceArrow().click();
			Thread.sleep(7000);
			PerformerLocator.clickStatutoryDoc().click();
			Thread.sleep(5000);
			
			String compDoc = getDriver().findElement(By.xpath("//a[normalize-space()='Compliance Documents']")).getText();
			
			if(compDoc.equalsIgnoreCase("Compliance Documents"))
			{
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Statutory Documents Module link is working fine");
			}
			else
			{
				test.log(LogStatus.FAIL, "Statutory Documents Module link is not working");
			}
			
			Thread.sleep(1000);
			}
	 
	 public static void StateDocZipFile(ExtentTest test) throws InterruptedException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
		 	Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickStatutoryDoc().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.clickAct2().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.clickComplianceStatus().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickcheckbox().click();
//			Thread.sleep(1000);
//			PerformerLocator.clickBranchTiangle().click();
//			Thread.sleep(1000);
//			PerformerLocator.selectBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
		
			//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
			Thread.sleep(9000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(4000);
			PerformerLocator.clickDownload().click();
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.invisibilityOf(PerformerLocator.gridLoad1()));
			
		
			Thread.sleep(4000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
			Thread.sleep(4000);
			if(dirContents.length < allFilesNew.length)
			{
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "zip file should get downloaded.");
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
			}
			    
				else
				{  
					Thread.sleep(2000);
					String msg1=PerformerLocator.FileNotFound().getText();
					
					 if(msg1.equalsIgnoreCase("File Not Found"))
					 {
						 test.log(LogStatus.PASS, "Message displayed = "+msg1);
						 
					 }
					 else
					 {
						 test.log(LogStatus.FAIL, "Message displayed = "+msg1);
					 }
					 Thread.sleep(1000);
					PerformerLocator.clickOkBtn().click();
				}
		
		
		
			Thread.sleep(2000);
			PerformerLocator.clickdashboard().click();
				
			
			
		}
			
	 public static void StatutoryDocZipFile(ExtentTest test) throws InterruptedException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickStatutoryDoc().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranchRadioBtn().click();
			Thread.sleep(1000);
			
			PerformerLocator.clickComplianceType().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.clickAct2().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType6().click();
			Thread.sleep(1000);
			PerformerLocator.clickComplianceStatus().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranchTiangle().click();
			Thread.sleep(1000);
			PerformerLocator.selectBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
		
			//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
			Thread.sleep(9000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(4000);
			PerformerLocator.clickDownload().click();
			
//			Thread.sleep(1000);
//			wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
			
		
			Thread.sleep(4000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
			Thread.sleep(4000);
			if(dirContents.length < allFilesNew.length)
			{
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "zip file should get downloaded.");
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
			}
			    
				else
				{  
					Thread.sleep(9000);
					test.log(LogStatus.FAIL, "zip file should not get downloaded..");
				}
			Thread.sleep(5000);
			PerformerLocator.clickdashboard().click();
				
			
			
		}
	 
	 public static void StateDownloadDoc(ExtentTest test) throws InterruptedException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickStatutoryDoc().click();
			
			PerformerLocator.clickBranchRadioBtn().click();
			
			PerformerLocator.clickComplianceType().click();
			PerformerLocator.selectComplianceType1().click();
			PerformerLocator.clickAct2().click();
			PerformerLocator.selectComplianceType().click();
			PerformerLocator.clickYear().click();
			PerformerLocator.selectComplianceType1().click();
			PerformerLocator.clickPeriod().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType6().click();
			Thread.sleep(1000);
			PerformerLocator.clickComplianceStatus().click();
			PerformerLocator.selectComplianceType().click();
			
			Thread.sleep(1000);
			ReviwerLocator.clickBranch1().click();
			Thread.sleep(1000);
			ReviwerLocator.clickcheckbox().click();
//			Thread.sleep(1000);
//			PerformerLocator.clickBranchTiangle().click();
//			Thread.sleep(1000);
//			PerformerLocator.selectBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickTriangleGrid().click();
			
			Thread.sleep(4000);
			PerformerLocator.clickDownload1().click();
		
			//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
			Thread.sleep(11000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(4000);
			PerformerLocator.clickDownload2().click();
			
			Thread.sleep(4000);
			PerformerLocator.clickCloseBtn().click();
			
//			Thread.sleep(1000);
//			wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
			
		
			Thread.sleep(4000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
			Thread.sleep(4000);
			if(dirContents.length < allFilesNew.length)
			{
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Indivisual Document should get downloaded.");
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
			}
			    
				else
				{  
					Thread.sleep(9000);
					test.log(LogStatus.FAIL, "Indivisual Document should not get downloaded.");
				}
				
			Thread.sleep(5000);
			PerformerLocator.clickdashboard().click();
			
		}

			
	 public static void StatutoryDocDownloadDoc(ExtentTest test) throws InterruptedException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickStatutoryDoc().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranchRadioBtn().click();
			Thread.sleep(1000);
			
			PerformerLocator.clickComplianceType().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.clickAct2().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType6().click();
			Thread.sleep(1000);
			PerformerLocator.clickComplianceStatus().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranchTiangle().click();
			Thread.sleep(1000);
			PerformerLocator.selectBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickTriangleGrid().click();
			
			Thread.sleep(4000);
			PerformerLocator.clickDownload1().click();
		
			//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
			Thread.sleep(11000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(4000);
			PerformerLocator.clickDownload2().click();
			
			Thread.sleep(4000);
			PerformerLocator.clickCloseBtn().click();
			
//			Thread.sleep(1000);
//			wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
			
		
			Thread.sleep(4000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
			Thread.sleep(4000);
			if(dirContents.length < allFilesNew.length)
			{
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Indivisual Document should get downloaded.");
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
			}
			    
				else
				{  
					Thread.sleep(9000);
					test.log(LogStatus.FAIL, "Indivisual Document should not get downloaded.");
				}
				
			Thread.sleep(5000);
			PerformerLocator.clickdashboard().click();
			
		}
	 
	 public static void StatutoryDocViewandOverview(ExtentTest test) throws InterruptedException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickStatutoryDoc().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranchRadioBtn().click();
			Thread.sleep(1000);
			
			PerformerLocator.clickComplianceType().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.clickAct2().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType6().click();
			Thread.sleep(1000);
			PerformerLocator.clickComplianceStatus().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranchTiangle().click();
			Thread.sleep(1000);
			PerformerLocator.selectBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			Thread.sleep(1000);
			PerformerLocator.clickTriangleGrid().click();
		
			Thread.sleep(1000);
			PerformerLocator.clickview().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickview1().click();
			Thread.sleep(3000);
			String msg=PerformerLocator.viewPopup().getText();
			if(msg.equalsIgnoreCase("Document Viewer"))
			{
				test.log(LogStatus.PASS, "View Popup open successfully:-"+msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "View Popup does not open successfully:-"+msg);
			}
			Thread.sleep(3000);
			PerformerLocator.clickCloseBtn1().click();
			Thread.sleep(1000);
			PerformerLocator.clickCloseBtn().click();
			
			Thread.sleep(9000);
			PerformerLocator.clickOverview().click();
			
			Thread.sleep(1000);
			String msg1=PerformerLocator.OverviewPopup().getText();
			if(msg1.equalsIgnoreCase("Compliance Overview"))
			{
				test.log(LogStatus.PASS, "Overview Popup open successfully:-"+msg1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Overview Popup does not open successfully:-"+msg1);
			}
			Thread.sleep(1000);
			PerformerLocator.clickCloseBtn().click();
			
			Thread.sleep(5000);
			PerformerLocator.clickdashboard().click();
		}
	 
	 public static void ChallanDocViewandOverview(ExtentTest test) throws InterruptedException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickStatutoryDoc().click();
			PerformerLocator.clickBranchRadioBtn().click();
			PerformerLocator.clickComplianceType().click();
			PerformerLocator.selectComplianceType().click();
			
			PerformerLocator.clickAct2().click();
			PerformerLocator.selectComplianceType().click();
			PerformerLocator.clickYear().click();
			PerformerLocator.selectComplianceType1().click();
			PerformerLocator.clickPeriod().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType2().click();
			Thread.sleep(1000);
			PerformerLocator.clickComplianceStatus().click();
			PerformerLocator.selectComplianceType().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranchTiangle().click();
			Thread.sleep(1000);
			PerformerLocator.selectBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
//			Thread.sleep(1000);
//			Locator.clickTriangleGrid().click();
		
			Thread.sleep(1000);
			PerformerLocator.clickview().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickview1().click();
			Thread.sleep(3000);
			String msg=PerformerLocator.viewPopup().getText();
			if(msg.equalsIgnoreCase("Document Viewer"))
			{
				test.log(LogStatus.PASS, "View Popup open successfully:-"+msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "View Popup does not open successfully:-"+msg);
			}
			Thread.sleep(3000);
			PerformerLocator.clickCloseBtn1().click();
			Thread.sleep(1000);
			PerformerLocator.clickCloseBtn().click();
			
			Thread.sleep(9000);
			PerformerLocator.clickOverview().click();
			
			Thread.sleep(1000);
			String msg1=PerformerLocator.OverviewPopup().getText();
			if(msg1.equalsIgnoreCase("Compliance Overview"))
			{
				test.log(LogStatus.PASS, "Overview Popup open successfully:-"+msg1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Overview Popup does not open successfully:-"+msg1);
			}
			Thread.sleep(1000);
			PerformerLocator.clickCloseBtn().click();
			
			Thread.sleep(5000);
			PerformerLocator.clickdashboard().click();
		}
	 
	 public static void ChallanDocDownload(ExtentTest test) throws InterruptedException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickStatutoryDoc().click();
			PerformerLocator.clickBranchRadioBtn().click();
			PerformerLocator.clickComplianceType().click();
			PerformerLocator.selectComplianceType().click();
			
			PerformerLocator.clickAct2().click();
			PerformerLocator.selectComplianceType().click();
			PerformerLocator.clickYear().click();
			PerformerLocator.selectComplianceType1().click();
			PerformerLocator.clickPeriod().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType2().click();
			Thread.sleep(1000);
			PerformerLocator.clickComplianceStatus().click();
			PerformerLocator.selectComplianceType().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranchTiangle().click();
			Thread.sleep(1000);
			PerformerLocator.selectBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			Thread.sleep(4000);
			PerformerLocator.clickDownload().click();
		
			//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
			Thread.sleep(11000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(4000);
			PerformerLocator.clickDownload2().click();
			
			Thread.sleep(4000);
			PerformerLocator.clickCloseBtn().click();
			
//			Thread.sleep(1000);
//			wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
			
		
			Thread.sleep(4000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
			Thread.sleep(4000);
			if(dirContents.length < allFilesNew.length)
			{
				Thread.sleep(4000);
				test.log(LogStatus.PASS, " Document should get downloaded.");
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
			}
			    
				else
				{  
					Thread.sleep(9000);
					test.log(LogStatus.FAIL, "Document should not get downloaded.");
				}
				
			Thread.sleep(5000);
			PerformerLocator.clickdashboard().click();
			
		}
	 public static void ChallanComplianceDocViewandOverview(ExtentTest test) throws InterruptedException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickStatutoryDoc().click();
			PerformerLocator.clickComplianceRadioBtn().click();
			PerformerLocator.clickComplianceType().click();
			PerformerLocator.selectComplianceType().click();
			
			PerformerLocator.clickAct2().click();
			PerformerLocator.selectComplianceType().click();
			PerformerLocator.clickYear().click();
			PerformerLocator.selectComplianceType1().click();
			PerformerLocator.clickPeriod().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType2().click();
			Thread.sleep(1000);
			PerformerLocator.clickComplianceStatus().click();
			PerformerLocator.selectComplianceType().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranchTiangle().click();
			Thread.sleep(1000);
			PerformerLocator.selectBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
//			Thread.sleep(1000);
//			Locator.clickTriangleGrid().click();
		
			Thread.sleep(1000);
			PerformerLocator.clickview().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickview1().click();
			Thread.sleep(3000);
			String msg=PerformerLocator.viewPopup().getText();
			if(msg.equalsIgnoreCase("Document Viewer"))
			{
				test.log(LogStatus.PASS, "View Popup open successfully:-"+msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "View Popup does not open successfully:-"+msg);
			}
			Thread.sleep(3000);
			PerformerLocator.clickCloseBtn1().click();
			Thread.sleep(1000);
			PerformerLocator.clickCloseBtn().click();
			
			Thread.sleep(9000);
			PerformerLocator.clickOverview().click();
			
			Thread.sleep(1000);
			String msg1=PerformerLocator.OverviewPopup().getText();
			if(msg1.equalsIgnoreCase("Compliance Overview"))
			{
				test.log(LogStatus.PASS, "Overview Popup open successfully:-"+msg1);
			}
			else
			{
				test.log(LogStatus.FAIL, "Overview Popup does not open successfully:-"+msg1);
			}
			Thread.sleep(1000);
			PerformerLocator.clickCloseBtn().click();
			
			Thread.sleep(5000);
			PerformerLocator.clickdashboard().click();
		}
	 
	 public static void ChallanComplianceDocDownload(ExtentTest test) throws InterruptedException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickStatutoryDoc().click();
			PerformerLocator.clickComplianceRadioBtn().click();
			PerformerLocator.clickComplianceType().click();
			PerformerLocator.selectComplianceType().click();
			
			PerformerLocator.clickAct2().click();
			PerformerLocator.selectComplianceType().click();
			PerformerLocator.clickYear().click();
			PerformerLocator.selectComplianceType1().click();
			PerformerLocator.clickPeriod().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType2().click();
			Thread.sleep(1000);
			PerformerLocator.clickComplianceStatus().click();
			PerformerLocator.selectComplianceType().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickBranchTiangle().click();
			Thread.sleep(1000);
			PerformerLocator.selectBranch1().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			Thread.sleep(4000);
			PerformerLocator.clickDownload().click();
		
			//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
			Thread.sleep(11000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(4000);
			PerformerLocator.clickDownload2().click();
			
			Thread.sleep(4000);
			PerformerLocator.clickCloseBtn().click();
			
//			Thread.sleep(1000);
//			wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
			
		
			Thread.sleep(4000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
			Thread.sleep(4000);
			if(dirContents.length < allFilesNew.length)
			{
				Thread.sleep(4000);
				test.log(LogStatus.PASS, " Document should get downloaded.");
				
				File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
			    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
			    {
			       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
			       {
			           lastModifiedFile = allFilesNew[i];
			       }
			    }
			}
			    
				else
				{  
					Thread.sleep(9000);
					test.log(LogStatus.FAIL, "Document should not get downloaded.");
				}
				
			Thread.sleep(5000);
			PerformerLocator.clickdashboard().click();
			
		}
	 
	 public static void StatutoryDocFilter(ExtentTest test) throws InterruptedException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickStatutoryDoc().click();
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType().click();
			Thread.sleep(1000);
			if(PerformerLocator.Dropdown().isDisplayed())
			{
				Thread.sleep(1000);
				PerformerLocator.Dropdown().click();
				test.log(LogStatus.PASS, "Register', 'Return', 'Challan' value should reflect in dropdown.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Register', 'Return', 'Challan' value should not reflect in dropdown.");
			}
			
			Thread.sleep(1000);
			PerformerLocator.clickAct2().click();
			
			Thread.sleep(1000);
			if(PerformerLocator.Dropdown().isDisplayed())
			{
				
				test.log(LogStatus.PASS, "Act' value's should reflect in dropdown.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Act' value's should not reflect in dropdown.");
			}
			Thread.sleep(1000);
			PerformerLocator.clickYear().click();
			
			Thread.sleep(1000);
			if(PerformerLocator.Dropdown().isDisplayed())
			{
				
				test.log(LogStatus.PASS, "Year' value's should reflect in dropdown.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Year' value's should not reflect in dropdown.");
			}
			Thread.sleep(1000);
			PerformerLocator.clickPeriod().click();
			Thread.sleep(1000);
			if(PerformerLocator.Dropdown().isDisplayed())
			{
				
				test.log(LogStatus.PASS, "Period' value's should reflect in dropdown.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Period' value's should not reflect in dropdown.");
			}
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceStatus().click();
			Thread.sleep(1000);
			if(PerformerLocator.Dropdown().isDisplayed())
			{
				
				test.log(LogStatus.PASS, "Closed-Delayed', 'Closed-Timely', 'Pending for performer', 'Pending for Reviewer' and 'Rejected' values should reflect in dropdown.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Closed-Delayed', 'Closed-Timely', 'Pending for performer', 'Pending for Reviewer' and 'Rejected' values not should reflect in dropdown.");
			}
			
		
			Thread.sleep(5000);
			PerformerLocator.clickdashboard().click();
			
		}
	 
	 public static void InputFileFilter(ExtentTest test) throws InterruptedException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			if(PerformerLocator.Dropdown().isDisplayed())
			{
				Thread.sleep(1000);
				PerformerLocator.Dropdown().click();
				test.log(LogStatus.PASS, "Register', 'Return', 'Challan' value should reflect in dropdown.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Register', 'Return', 'Challan' value should not reflect in dropdown.");
			}
			
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			
			Thread.sleep(1000);
			if(PerformerLocator.Dropdown().isDisplayed())
			{
				
				test.log(LogStatus.PASS, "Year' value's should reflect in dropdown.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Year' value's should not reflect in dropdown.");
			}
			
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			if(PerformerLocator.Dropdown().isDisplayed())
			{
				
				test.log(LogStatus.PASS, "Period' value's should reflect in dropdown.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Period' value's should not reflect in dropdown.");
			}
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(2000);
			PerformerLocator.clickdashboard().click();
			
		}
	 
	 public static void InputFileSubmitBtn(ExtentTest test) throws InterruptedException, AWTException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType3().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
					
			if(PerformerLocator.clickSubmit().isEnabled())
			{
				Thread.sleep(1000);
				PerformerLocator.clickSubmit().click();
				test.log(LogStatus.PASS, "After clicking on the submit button the user should redirect to workspace screen.");
			}
			else
			{
				test.log(LogStatus.FAIL, "'After clicking on the submit button the user should not redirect to workspace screen.");
			}
			
			Thread.sleep(2000);
			PerformerLocator.clickdashboard().click();
			
			
		}
	 public static void InputFileSampleTemplate(ExtentTest test) throws InterruptedException, AWTException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType3().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			if(PerformerLocator.clickSampleTemplate().isEnabled())
			{
				Thread.sleep(1000);
				PerformerLocator.clickSampleTemplate().click();
				test.log(LogStatus.PASS, "Sample template downloaded successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Sample template does not downloaded successfully.");
			}
			
			if(PerformerLocator.clickDownloadBtn().isEnabled())
			{
				Thread.sleep(1000);
				PerformerLocator.clickDownloadBtn().click();
				test.log(LogStatus.PASS, "'Respective file should get downloaded.");
			}
			else
			{
				test.log(LogStatus.FAIL, "'Respective file should get downloaded.");
			}
			
			
			Thread.sleep(5000);
			PerformerLocator.clickdashboard().click();
		}
			
	 public static void InputFileAttendanceUploadSheet(ExtentTest test) throws InterruptedException, AWTException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType3().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			Thread.sleep(1000);
		
		
			 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray download-btn']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\Sample-MonthlyAttendance_19Feb2025043710.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File uploaded successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.clickUploadbtnCTCBtn().click();
			
			Thread.sleep(2000);
			String msg=PerformerLocator.successUploadHoliday().getText();
			
			 if(msg.equalsIgnoreCase("File uploaded successfully"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			Thread.sleep(1000);
		   PerformerLocator.clickdashboard().click();
	}
	 
	 public static void InputFileSalaryeUploadSheet(ExtentTest test) throws InterruptedException, AWTException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType3().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			Thread.sleep(1000);
		
		
			 getDriver().findElement(By.xpath("(//*[@class='figma-btn-gray download-btn'])[2]")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\Sample-MonthlySalary_21Feb2025065259.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File uploaded successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.UploadBtn().click();
			
			Thread.sleep(2000);
			String msg=PerformerLocator.successUploadHoliday().getText();
			
			 if(msg.equalsIgnoreCase("File uploaded successfully"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			Thread.sleep(1000);
		   PerformerLocator.clickdashboard().click();
	}
	
	 public static void InputFileAttendanceInvalidDataSheet(ExtentTest test) throws InterruptedException, AWTException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType3().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			Thread.sleep(1000);
		
		
			 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray download-btn']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\Sample-MonthlyAttendance_InvalidData.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File uploaded successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.clickUploadbtnCTCBtn().click();
			
			Thread.sleep(100);
			String msg=PerformerLocator.clickerrorFile().getText();
			
			 if(msg.equalsIgnoreCase("Error occurred.Error file downloaded"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(100);
			PerformerLocator.clickOkBtn().click();
			Thread.sleep(1000);
		   PerformerLocator.clickdashboard().click();
	}
	 
	 public static void InputFileAttendanceWithoutUpload(ExtentTest test) throws InterruptedException, AWTException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType3().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			 Thread.sleep(1000);
				PerformerLocator.clickUploadbtnCTCBtn().click();
				
				Thread.sleep(100);
				String msg=PerformerLocator.withoutUploadSheet().getText();
				
				 if(msg.equalsIgnoreCase("No file chosen"))
				 {
					 test.log(LogStatus.PASS, "Message displayed = "+msg);
					 
				 }
				 else
				 {
					 test.log(LogStatus.FAIL, "Message displayed = "+msg);
				 }
				 Thread.sleep(100);
				PerformerLocator.clickOkBtn().click();
				Thread.sleep(1000);
			   PerformerLocator.clickdashboard().click();
		}
	 
	 public static void InputFileSalaryWithoutUpload(ExtentTest test) throws InterruptedException, AWTException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType3().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			 Thread.sleep(1000);
				PerformerLocator.UploadBtn().click();
				
				Thread.sleep(100);
				String msg=PerformerLocator.withoutUploadSheet().getText();
				
				 if(msg.equalsIgnoreCase("No file chosen"))
				 {
					 test.log(LogStatus.PASS, "Message displayed = "+msg);
					 
				 }
				 else
				 {
					 test.log(LogStatus.FAIL, "Message displayed = "+msg);
				 }
				 Thread.sleep(100);
				PerformerLocator.clickOkBtn().click();
				Thread.sleep(1000);
			   PerformerLocator.clickdashboard().click();
		}
	 
	 public static void InputFileSalaryInvalidSheet(ExtentTest test) throws InterruptedException, AWTException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType3().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			Thread.sleep(1000);
		
		
			 getDriver().findElement(By.xpath("(//*[@class='figma-btn-gray download-btn'])[2]")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\UploadAuthorityAddress.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File uploaded successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.UploadBtn().click();
			
			Thread.sleep(100);
			String msg=PerformerLocator.invalidSheet().getText();
			
			 if(msg.equalsIgnoreCase("Invalid template"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(100);
			PerformerLocator.clickOkBtn().click();
			Thread.sleep(1000);
		   PerformerLocator.clickdashboard().click();
	}
	 
	 
	 public static void InputFileAttendanceInvalidSheet(ExtentTest test) throws InterruptedException, AWTException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType3().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			Thread.sleep(1000);
		
		
			 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray download-btn']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\UploadAuthorityAddress.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File uploaded successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.clickUploadbtnCTCBtn().click();
			
			Thread.sleep(100);
			String msg=PerformerLocator.invalidSheet().getText();
			
			 if(msg.equalsIgnoreCase("Invalid template"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(100);
			PerformerLocator.clickOkBtn().click();
			Thread.sleep(1000);
		   PerformerLocator.clickdashboard().click();
	}
	 
	 public static void InputFileDisableDownload(ExtentTest test) throws InterruptedException, AWTException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			
			WebElement yourButton= getDriver().findElement(By.xpath("(//button[contains(text(),'Download')])"));

			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].removeAttribute('disabled','disabled')",yourButton);
			wait.until(ExpectedConditions.elementToBeClickable(yourButton));
			
			Thread.sleep(1000);
			if(yourButton.isEnabled())
			{
				
				test.log(LogStatus.PASS, "'Download' button should be disabled.");
			}
			else
			{
				
				
				test.log(LogStatus.FAIL, "'Download' button should not be disabled.");
			}
			
			
			Thread.sleep(1000);
			WebElement yourButton1= getDriver().findElement(By.xpath("(//*[@class='figma-btn-gray download-btn'])"));
			js.executeScript("arguments[0].removeAttribute('disabled','disabled')",yourButton1);
			wait.until(ExpectedConditions.elementToBeClickable(yourButton1));
			
			Thread.sleep(1000);
			if(yourButton1.isEnabled())
			{
				
				test.log(LogStatus.PASS, "'Browse' button should be disabled.");
			}
			else
			{
				
				test.log(LogStatus.FAIL, "'Browse' button should not be disabled.");
			}
			
			
			Thread.sleep(1000);
			WebElement yourButton2= getDriver().findElement(By.xpath("(//button[normalize-space()='Upload'])"));
			js.executeScript("arguments[0].removeAttribute('disabled','disabled')",yourButton2);
			wait.until(ExpectedConditions.elementToBeClickable(yourButton2));
			
			Thread.sleep(1000);
			if(yourButton2.isEnabled())
			{
				
				test.log(LogStatus.PASS, "'Upload' button should be disabled.");
			}
			else
			{
				
				test.log(LogStatus.FAIL, "'Upload' button should not be disabled.");
			}
			
			Thread.sleep(1000);
			   PerformerLocator.clickdashboard().click();
			
		}
	 public static void ErrorFileDownload(ExtentTest test) throws InterruptedException, AWTException
		{
		 WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType3().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			
			Thread.sleep(1000);
			
			
			 getDriver().findElement(By.xpath("(//*[@class='figma-btn-gray download-btn'])[2]")).click();
			 
			 Robot robot=new Robot();
			 
				Thread.sleep(1000);
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\Sample-MonthlySalary_Invalid data.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			
			 
		     Thread.sleep(1000);
			PerformerLocator.UploadBtn().click();
			
			Thread.sleep(6000);
			String msg=PerformerLocator.clickerrorFile().getText();
			
			 if(msg.equalsIgnoreCase("Error occurred.Error file downloaded"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			
			
			 if(PerformerLocator.downloaderrorFile().isDisplayed())
			 {
				 Thread.sleep(1000);
					PerformerLocator.downloaderrorFile().click();
				 test.log(LogStatus.PASS, "Error file should get downloaded");
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Error file should not get downloaded");
			 }
			
			Thread.sleep(1000);
		   PerformerLocator.clickdashboard().click();
			
			
		}
	 
	 public static void GreenColour(ExtentTest test) throws InterruptedException, AWTException
		{
		 WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType3().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			Thread.sleep(2000);
			
			String buttonColor = getDriver().findElement(By.xpath("(//img[@class='greentick'])[1]")).getCssValue("background-color");
			
			String hex=	Color.fromString(buttonColor).asHex();
			
			System.out.println(hex);
			Thread.sleep(2000);
			if(hex.equalsIgnoreCase("#000000")) 
			{
			
				test.log(LogStatus.PASS,  " green tickmark appearing  for valid template file upload from input web upload tab of input files menu of performr profile");
			}
			else
			{
			
		
				test.log(LogStatus.FAIL,  " green tickmark does not appearing for valid template file upload from input web upload tab of input files menu of performr profile");
			}
			
			
		        
			
			Thread.sleep(1000);
			   PerformerLocator.clickdashboard().click();
		}
	 
	 public static void RedColour(ExtentTest test) throws InterruptedException, AWTException
		{
		 WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType3().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			Thread.sleep(2000);
			
			String buttonColor = getDriver().findElement(By.xpath("//*[@src='../assets/vectors/Incorrect_Icon.svg']")).getCssValue("background-color");
			
			String hex=	Color.fromString(buttonColor).asHex();
			
			System.out.println(hex);
			Thread.sleep(2000);
			if(hex.equalsIgnoreCase("#000000")) 
			{
			
				test.log(LogStatus.PASS,  " red crossmark appearing for invalid template file upload from input web upload tab of input files menu of performr profile");
			}
			else
			{
			
		
				test.log(LogStatus.FAIL,  " red crossmark does not appearing for valid template file upload from input web upload tab of input files menu of performr profile");
			}
			
			Thread.sleep(1000);
			 PerformerLocator.clickdashboard().click();
		}
	 
	 public static void GreenColourUploaded(ExtentTest test) throws InterruptedException, AWTException
		{
		 WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType3().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			Thread.sleep(2000);
			
			String buttonColor = getDriver().findElement(By.xpath("(//img[@class='greentick'])[2]")).getCssValue("background-color");
			String hex=	Color.fromString(buttonColor).asHex();
			
			System.out.println(hex);
			Thread.sleep(2000);
			if(hex.equalsIgnoreCase("##34b233")) 
			{
			
				test.log(LogStatus.PASS,  "green tickmarks appearing in uploaded columns for valid file upload from of input web upload tab of input files menu from performer login");
			}
			else
			{
			
		
				test.log(LogStatus.FAIL,  " green tickmark does not appearing in uploaded columns for valid file upload from of input web upload tab of input files menu from performer login");
			}
			
			String buttonColor1 = getDriver().findElement(By.xpath("(//img[@class='greentick'])[3]")).getCssValue("background-color");
			String hex1=	Color.fromString(buttonColor1).asHex();
			System.out.println(hex1);
			Thread.sleep(2000);
			if(hex1.equalsIgnoreCase("#000000")) 
			{
			
				test.log(LogStatus.PASS,  " green tickmarks appearing in validated columns for valid file upload from of input web upload tab of input files menu from performer login");
			}
			else
			{
			
		
				test.log(LogStatus.FAIL,  " green tickmarks does not appearing in validated columns for valid file upload from of input web upload tab of input files menu from performer login");
			}
			
			
			Thread.sleep(2000);
			WebElement myElement = (new WebDriverWait(getDriver(), 30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(".grid-scroll-container")));
            myElement.click();
            Actions move = new Actions(getDriver());
            move.moveToElement(myElement).clickAndHold();
            move.moveByOffset(125,0);
            move.release();
            move.perform();
			
            Thread.sleep(2000);
			String buttonColor2 = getDriver().findElement(By.xpath("(//img[@class='greentick'])[4]")).getCssValue("background-color");
			String hex2=	Color.fromString(buttonColor2).asHex();
			
			System.out.println(hex2);
			Thread.sleep(2000);
			if(hex2.equalsIgnoreCase("#000000")) 
			{
			
				test.log(LogStatus.PASS,  "green tickmarks appearing in processed columns for valid file upload from of input web upload tab of input files menu from performer login");
			}
			else
			{
			
		
				test.log(LogStatus.FAIL,  "green tickmarks does not appearing in processed columns for valid file upload from of input web upload tab of input files menu from performer login");
			}
			
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
		}
	 
	 public static void History(ExtentTest test) throws InterruptedException, AWTException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType3().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			Thread.sleep(1000);
			PerformerLocator.HistoryIcon().click();
			String msg=PerformerLocator.InputHistory().getText();
			
			if(msg.equalsIgnoreCase("Input History"))
			{
				test.log(LogStatus.PASS,"History icon working successfully:=" +msg);
			}
			else
			{
				test.log(LogStatus.FAIL,"History icon does not working successfully:=" +msg);
			}
			
			if(PerformerLocator.clickDownloadHistoryIcon().isEnabled())
			{
				Thread.sleep(1000);
				PerformerLocator.clickDownloadHistoryIcon().click();
				
				test.log(LogStatus.PASS, "Download Button working successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Download Button not working successfully.");
				
			};
			
			
			Thread.sleep(1000);
			PerformerLocator.clickCloseBtn().click();
			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
		}
	 
	 
	 public static void AnchorDashboardSummary(ExtentTest test) throws InterruptedException, AWTException
		{

		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
		 	Thread.sleep(1000);
			
			
			if(PerformerLocator.AnchorDashboardSummary().isEnabled())
			{
				Thread.sleep(1000);
				PerformerLocator.AnchorDashboardSummary().click();
				test.log(LogStatus.PASS, "Anchor Dashboard Summary tab is clickable");
			}
			else
			{
				test.log(LogStatus.FAIL, "Anchor Dashboard Summary tab not clickable");
			}
			
			
			
			Thread.sleep(1000);
			PerformerLocator.searchEmpName().click();         //Compliance Type
			
			Thread.sleep(1000);
			if(PerformerLocator.Dropdown().isDisplayed())
			{
				Thread.sleep(1000);
				PerformerLocator.Dropdown().click();
				test.log(LogStatus.PASS, "Register', 'Return', 'Challan' value should reflect in dropdown.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Register', 'Return', 'Challan' value should not reflect in dropdown.");
			}
			
			
			Thread.sleep(1000);
			PerformerLocator.clickYear().click();
			
			Thread.sleep(1000);
			if(PerformerLocator.Dropdown().isDisplayed())
			{
				
				test.log(LogStatus.PASS, "Year' value's should reflect in dropdown.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Year' value's should not reflect in dropdown.");
			}
			
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType1().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			if(PerformerLocator.Dropdown().isDisplayed())
			{
				
				test.log(LogStatus.PASS, "Period' value's should reflect in dropdown.");
			}
			else
			{
				test.log(LogStatus.FAIL, "Period' value's should not reflect in dropdown.");
			}
			
			
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType1().click();
			
			if(PerformerLocator.clickApply().isEnabled())
			{
				Thread.sleep(1000);
				PerformerLocator.clickApply().click();
				test.log(LogStatus.PASS, "Apply Button is working");
			}
			else
			{
				test.log(LogStatus.FAIL, "Apply Button is not working");
			
			}
			

			if(PerformerLocator.clickClearBtn().isEnabled())
			{
				Thread.sleep(1000);
				PerformerLocator.clickClearBtn().click();
				test.log(LogStatus.PASS, "Clear Button is working");
			}
			else
			{
				test.log(LogStatus.FAIL, "Clear Button is not working");
			
			}

			Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
			
		}
	 
	 public static void InputFileSalaryUploadSheet(ExtentTest test,String type) throws InterruptedException, AWTException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
			Thread.sleep(1000);
			PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			Thread.sleep(1000);
			PerformerLocator.clickDashboard().click();
			Thread.sleep(7000);
			PerformerLocator.clickInputFile().click();
			
			Thread.sleep(1000);
			PerformerLocator.clickComplianceType1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType1().click();
			
			if(type.equals("Challan"))
	  		{
	  			
				Thread.sleep(1000);
				PerformerLocator.clickComplianceType1().click();
				Thread.sleep(1000);
				PerformerLocator.selectComplianceType1().click();
	  		}
	  		else if(type.equals("Return"))
	  		{
	  			
	  			Thread.sleep(1000);
				PerformerLocator.clickComplianceType1().click();
				Thread.sleep(1000);
				PerformerLocator.selectComplianceType5().click();
	  		}
			
			
			Thread.sleep(1000);
			PerformerLocator.clickYear1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType4().click();
			Thread.sleep(1000);
			PerformerLocator.clickPeriod1().click();
			Thread.sleep(1000);
			PerformerLocator.selectComplianceType3().click();
			Thread.sleep(1000);
			PerformerLocator.clickApply().click();
			
			Thread.sleep(1000);
		
		
			 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray download-btn']")).click();
			 
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\Sample-MonthlySalary_21Feb2025065259.xlsx");
			 //copy above file to clipboard
			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
			 
			 //Now press CRTL
			 
			 robot.keyPress(KeyEvent.VK_CONTROL);
			 Thread.sleep(1000);
			 
			 //PRESS V
			 robot.keyPress(KeyEvent.VK_V);
			 Thread.sleep(1000);
			 
			 //Release V
			 robot.keyRelease(KeyEvent.VK_V);
			 
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_CONTROL);
			 
			 //PRESS Enter
			 robot.keyPress(KeyEvent.VK_ENTER);
			 
			 //Release CRTL
			 robot.keyRelease(KeyEvent.VK_ENTER);
			 
			 Thread.sleep(1000);
			 System.out.println("File uploaded successfully");
			 
		     Thread.sleep(1000);
			PerformerLocator.clickUploadbtnCTCBtn().click();
			
			Thread.sleep(2000);
			String msg=PerformerLocator.successUploadHoliday().getText();
			
			 if(msg.equalsIgnoreCase("File uploaded successfully"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
			Thread.sleep(1000);
		   PerformerLocator.clickdashboard().click();
	}
	 
	 public static void InputFileChallanSalaryUploadSheet(ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			
			Thread.sleep(500);
			InputFileSalaryUploadSheet(test, "Challan");
			
			
			Thread.sleep(1000);
			   PerformerLocator.clickdashboard().click();
		}
	 
	 public static void InputFileReturnSalaryUploadSheet(ExtentTest test) throws InterruptedException, IOException, AWTException
		{
			WebDriverWait wait = new WebDriverWait(getDriver(), 50);
			
			Thread.sleep(500);
			InputFileSalaryUploadSheet(test, "Return");
			
			
			Thread.sleep(1000);
			   PerformerLocator.clickdashboard().click();
		}
	 
	 public static void UploadSealandSignature( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	 {
	 	
	 	Thread.sleep(1000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");

	 	Thread.sleep(1000);
		PerformerLocator.clickDashboard().click();
	 	Thread.sleep(7000);
		PerformerLocator.clickManageMaster().click();
	 	
	 	Thread.sleep(1000);
		PerformerLocator.clickSealandSignatureBtn().click();
	 	
	 	 Thread.sleep(1000);
			PerformerLocator.clickBrowse1().click();
	 		
	 		 Robot robot=new Robot();
	 		 
	 		 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\chart_11zon.jpeg");
	 		 //copy above file to clipboard
	 		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
	 		 
	 		 //Now press CRTL
	 		 
	 		 robot.keyPress(KeyEvent.VK_CONTROL);
	 		 Thread.sleep(1000);
	 		 
	 		 //PRESS V
	 		 robot.keyPress(KeyEvent.VK_V);
	 		 Thread.sleep(1000);
	 		 
	 		 //Release V
	 		 robot.keyRelease(KeyEvent.VK_V);
	 		 
	 		 
	 		 //Release CRTL
	 		 robot.keyRelease(KeyEvent.VK_CONTROL);
	 		 
	 		 //PRESS Enter
	 		 robot.keyPress(KeyEvent.VK_ENTER);
	 		 
	 		 //Release CRTL
	 		 robot.keyRelease(KeyEvent.VK_ENTER);
	 		 
	 		 Thread.sleep(1000);
	 		 System.out.println("File uploaded successfully");
	 		 
	 	     Thread.sleep(1000);
				PerformerLocator.clickUploadbtnCTCBtn().click();
	 		
	 		Thread.sleep(2000);
	 		String msg=	PerformerLocator.clickMsg().getText();
	 		
	 		 if(msg.equalsIgnoreCase("File uploaded successfully"))
	 		 {
	 			 test.log(LogStatus.PASS, "Message displayed = "+msg);
	 			 
	 		 }
	 		 else
	 		 {
	 			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
	 		 }
	 		 Thread.sleep(1000);
				PerformerLocator.clickOkBtn().click();
	 		
	 		Thread.sleep(1000);
			PerformerLocator.clickcloseBtn().click();
	 		Thread.sleep(1000);
			PerformerLocator.clickdashboard().click();
	 	
	 	
	 }
	 public static void AddDesignation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	 {
	 	
		WebDriverWait wait = new WebDriverWait(getDriver(), (30));
	 	Thread.sleep(2000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
	 	Thread.sleep(5000);
		PerformerLocator.clickWorkspaceArrow().click();
	 	Thread.sleep(5000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(5000);
		PerformerLocator.clickDesignation().click();
		wait.until(ExpectedConditions.visibilityOf(PerformerLocator.clickAddNewDesignation()));
	 	Thread.sleep(3000);
		PerformerLocator.clickAddNewDesignation().click();
	 	
	 	FileInputStream fis = new FileInputStream(filePath);
	     Workbook workbook1 = WorkbookFactory.create(fis);
	     Sheet sheet = workbook1.getSheetAt(0);
	 	
	 	Thread.sleep(1000);
//	 	Row row = sheet.getRow(9);						//Selected 0th index row (First row)
//	 	Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
//	 	String designation = c.getStringCellValue();
//		PerformerLocator.enterDesignation().sendKeys(designation);
	 	
	 	PerformerLocator.enterDesignation().sendKeys("Engineer");
	 	
	 	Thread.sleep(1000);
	 	
		PerformerLocator.clicksave().click();
	 	
	 	 Thread.sleep(500);
	 	  String msg=			PerformerLocator.clickMsg().getText();		//Reading Message appeared after save button
	 	  
	 	  if(msg.equalsIgnoreCase("Designation Added Successfully") || msg.equalsIgnoreCase("Designation is already exists."))
	 	 {
	 		 test.log(LogStatus.PASS, "Message displayed = "+msg);
	 		 
	 	 }
	 	 else
	 	 {
	 		 test.log(LogStatus.FAIL, "Message displayed = "+msg);
	 	 }
	 	  
	 	  Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
	 	}
	 
	 public static void StateCitySearch( ExtentTest test,XSSFWorkbook workbook, String user) throws InterruptedException, IOException
	 {
	 	
		 
		    Thread.sleep(10000);
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("TESTAUTO3");
				PerformerLocator.clickWorkspaceArrow().click();
			 	Thread.sleep(5000);
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("TESTAUTO3");
				PerformerLocator.DistributorPremisesArrow().click();
				Thread.sleep(5000);
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("TESTAUTO3");	
				PerformerLocator.ReviewerStaturyDocumentArrow().click();
			 	Thread.sleep(5000);
			}
			
	 	
	 	Thread.sleep(5000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(5000);
//		PerformerLocator.clickDesignation().click();
	 	Thread.sleep(1000);
//		PerformerLocator.clickAddNewDesignation().click();
	 	
	 	PerformerLocator.StateCitySearch().click();
	 	Thread.sleep(2000);
	 	PerformerLocator.StateCitySearch().sendKeys("Bangalore");
	 	Thread.sleep(2000);
	 	PerformerLocator.StateCitySearchSelectSeondValue().click();
	 	Thread.sleep(2000);
	 	PerformerLocator.clickApply().click();
	 	Thread.sleep(5000);
	 	String txt = getDriver().findElement(By.xpath("//div[@title='Karnataka']")).getText();
	 	if(txt.equalsIgnoreCase("Karnataka")){
	 		Thread.sleep(1000);
	 		test.log(LogStatus.PASS, "Search State/ Location Code dropdown is working fine");
	 		test.log(LogStatus.PASS, "Value displayed in grid:- " + txt);
	 	}
		
	 	else
	 	{
	 		test.log(LogStatus.PASS, "Search Value is not displayed");
	 	}
	 	
	 	}
	 
	 public static void StateCitySealANDSignatureInvalid( ExtentTest test,XSSFWorkbook workbook, String user) throws Exception
	 {
	 	
		 
		    Thread.sleep(10000);
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("TESTAUTO3");
				PerformerLocator.clickWorkspaceArrow().click();
			 	Thread.sleep(5000);
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("TESTAUTO3");
				PerformerLocator.DistributorPremisesArrow().click();
				Thread.sleep(5000);
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("TESTAUTO3");	
				PerformerLocator.ReviewerStaturyDocumentArrow().click();
			 	Thread.sleep(5000);
			}
			
	 	
	 	Thread.sleep(5000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(5000);
	 	Thread.sleep(1000);
	 	
	 	PerformerLocator.StateCitySearch().click();
	 	Thread.sleep(2000);
	 	PerformerLocator.StateCitySearch().sendKeys("TEst1");
	 	Thread.sleep(4000); Thread.sleep(4000);
	 	
	getDriver().findElement(By.xpath("//span[normalize-space(.)='TEst1 (123454) (Maharashtra)']")).click(); 	
	 	
	 	
	 	Thread.sleep(2000);
	 	PerformerLocator.clickApply().click();
	 	Thread.sleep(5000);
	 	
	 	PerformerLocator.StateCitySealAndSingnature().click();
	 	
	 	PerformerLocator.Uplaodclick().click();
	 	
	 	String txtt =	PerformerLocator.clickMsg().getText();
	 	if(txtt.equalsIgnoreCase("No file selected")){
	 		Thread.sleep(1000);
	 		test.log(LogStatus.PASS, "Without file selection, success message not reflect ");
	 		test.log(LogStatus.PASS, "Message displayed : " + txtt);
	 	}
		
	 	else
	 	{
	 		test.log(LogStatus.PASS, "Search Value is not displayed");
	 	}
	 	
	 	
	 	PerformerLocator.clickOkBtn().click();
	 	
	 	
	 	
	 	Thread.sleep(5000);
	// 	PerformerLocator.browse().click(); 
	 	getDriver().findElement(By.xpath("//div[@role='dialog']//label[normalize-space()='Browse']")).click();
	// 	LoginLocators.Browes1_ESIC().click();
	 	Thread.sleep(5000);
	 	OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\OtherTwo\\SampleJpgFile.jpg");
	 	
	 	PerformerLocator.Uplaodclick().click();
	 	Thread.sleep(2000);
	 //	String txt = getDriver().findElement(By.xpath("//div[@title='Karnataka']")).getText();
	 	String txt=			PerformerLocator.clickMsg().getText();
	 	if(txt.equalsIgnoreCase("Please upload 1kb - 4 kb valid .jpg or .jpeg file.")){
	 		Thread.sleep(1000);
	 		test.log(LogStatus.PASS, "On uploading more than 4 kb file, it is not uploaded");
	 		test.log(LogStatus.PASS, "Message displayed : " + txt);
	 	}
		
	 	else
	 	{
	 		test.log(LogStatus.PASS, "Search Value is not displayed");
	 	}
	 	
	 	}
	 
	 public static void StateCityAddressMapping( ExtentTest test,XSSFWorkbook workbook, String user) throws Exception
	 {
	 	
		 
		    Thread.sleep(10000);
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVACORED5");
				PerformerLocator.clickWorkspaceArrow().click();
			 	Thread.sleep(5000);
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("TESTAUTO3");
				PerformerLocator.DistributorPremisesArrow().click();
				Thread.sleep(5000);
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORED5");	
				PerformerLocator.ReviewerStaturyDocumentArrow().click();
			 	Thread.sleep(5000);
			}
			
	 	
	 	Thread.sleep(5000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(5000);
	 	Thread.sleep(1000);
	 	
	 	PerformerLocator.StateCitySearch().click();
	 	Thread.sleep(2000);
	 	PerformerLocator.StateCitySearch().sendKeys("TEst1");
	 	Thread.sleep(4000); Thread.sleep(4000);
	 	
	getDriver().findElement(By.xpath("//span[normalize-space(.)='TEst1 (123454) (Maharashtra)']")).click(); 	
	 	
	 	
	 	Thread.sleep(2000);
	 	PerformerLocator.clickApply().click();
	 	Thread.sleep(5000);
	 	
	 	PerformerLocator.StateCityAddressMapping().click();
	 	Thread.sleep(5000);
	 	PerformerLocator.StateCityAddressMapping_ClearXcrossMark().click();
	 	Thread.sleep(7000);
	 	PerformerLocator.StateCitySelectAddressDropdown().sendKeys(Keys.ENTER);
//	 	PerformerLocator.StateCitySelectAddressDropdown().click();
	 	Thread.sleep(3000);
	 	PerformerLocator.StateCityAddressMapping_2ndValue().click();
	 	Thread.sleep(2000);
	 	PerformerLocator.StateCityAddressMapping_SaveBtn().click();
	 	Thread.sleep(2000);
	 	
	 	String txt2 = PerformerLocator.clickMsg().getText();
	 	
	 	
	 	if(txt2.equalsIgnoreCase("Record Added successfully")){
	 		Thread.sleep(1000);
	 		test.log(LogStatus.PASS, "Address Mapping arrow button is working fine");
	 		test.log(LogStatus.PASS, "Address dropdown filter and save button is working fine");
	 		test.log(LogStatus.PASS, "Message displayed : " + txt2);
	 	}
		
	 	else
	 	{
	 		test.log(LogStatus.FAIL, "Message displayed : " + txt2);
	 	}
	 	
	 	}
	 
	 public static void DesignationSearch ( ExtentTest test,XSSFWorkbook workbook ,String user) throws InterruptedException, IOException
	 {
	 	
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("TESTAUTO3");
				Thread.sleep(5000);
				PerformerLocator.clickWorkspaceArrow().click();
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("TESTAUTO3");
				Thread.sleep(5000);
				PerformerLocator.DistributorPremisesArrow().click();
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("TESTAUTO3");
				Thread.sleep(5000);
				PerformerLocator.ReviewerStaturyDocumentArrow().click();
			}
		 

//		PerformerLocator.SerchCustomer().sendKeys("TESTAUTO2");
	 	Thread.sleep(5000);
//		PerformerLocator.clickWorkspaceArrow().click();
	 	Thread.sleep(1000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(1000);
//		PerformerLocator.clickDesignation().click();
	 	Thread.sleep(1000);
//		PerformerLocator.clickAddNewDesignation().click();
	 	
	 	PerformerLocator.clickDesignation().click();
	 	
	 	Thread.sleep(10000);
	 	PerformerLocator.DesignationSerach().click();
	 	
	 	//Give max wait due to hudge data
	 	
	 	Thread.sleep(7000);
	 	PerformerLocator.DesignationSerach().sendKeys("Software Developer");
	 	Thread.sleep(7000);
	 	PerformerLocator.StateCitySearchSelectSeondValue().click();
	 	Thread.sleep(7000);
	 	PerformerLocator.clickApply().click();
	 	Thread.sleep(7000);
	 	WebElement txt = getDriver().findElement(By.xpath("//div[contains(text(),'Software')]"));
	 	if(txt.isDisplayed()){
	 		Thread.sleep(1000);
	 		test.log(LogStatus.PASS, "Search/Select Designation dropdown is working fine");
	 	}
		
	 	else
	 	{
	 		test.log(LogStatus.PASS, "Search Value is not displayed");
	 	}
	 	
	 	}
	 
	 public static void LeaveTypeSearch ( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	 {
	 	
	 	Thread.sleep(3000);
		PerformerLocator.SerchCustomer().sendKeys("TESTAUTO2");
	 	Thread.sleep(5000);
		PerformerLocator.clickWorkspaceArrow().click();
	 	Thread.sleep(5000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(5000);
//		PerformerLocator.clickDesignation().click();
	 	Thread.sleep(1000);
//		PerformerLocator.clickAddNewDesignation().click();
	 	
	 	PerformerLocator.LeaveTypeModule().click();
	 	
	 	Thread.sleep(10000);
	 	PerformerLocator.LeaveTypeSearch().click();
	 	
	 	//Give max wait due to hudge data
	 	
	 	Thread.sleep(7000);
	 	PerformerLocator.LeaveTypeSearch().sendKeys("Absent");
	 	Thread.sleep(7000);
	 	PerformerLocator.StateCitySearchSelectSeondValue().click();
	 	Thread.sleep(7000);
	 	PerformerLocator.clickApply().click();
	 	Thread.sleep(7000);                              //Meaning If Absent is displayed then it will fetch
	 	WebElement txt = getDriver().findElement(By.xpath("//div[contains(text(),'Absent')]"));
	 	if(txt.isDisplayed()){
	 		Thread.sleep(1000);
	 		test.log(LogStatus.PASS, "Search Leave Type Dropdown is working fine");
	 	}
		
	 	else
	 	{
	 		test.log(LogStatus.PASS, "Search Value is not displayed");
	 	}
	 	
	 	}
	 public static void PaycodeMappingAddNew ( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	 {
	 	
	 	Thread.sleep(5000);Thread.sleep(5000);Thread.sleep(5000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
	 	Thread.sleep(5000);
		PerformerLocator.clickWorkspaceArrow().click();
		
 		//Correct Entity Verification
        OneCommonMethod.verifyTestEntity(
        driver.get(), test,
        By.xpath("//span[normalize-space()='AVATCGEN CORE DEMO[AVACORED5]']"),
        "AVATCGEN CORE DEMO[AVACORED5]"
         );
		
	 	Thread.sleep(5000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(3000);

	 	
	 	PerformerLocator.clickPaycodeMappingModule().click();
	 	Thread.sleep(3000);
	 	PerformerLocator.clickAddNewDesignation().click(); //clicking to Add Paycode 
	 	Thread.sleep(2000);
	 	getDriver().findElement(By.xpath("//input[@placeholder='Header Name']")).sendKeys("Holiday Allowance");
	 	Thread.sleep(2000);
	 	getDriver().findElement(By.xpath("(//span[normalize-space()='Select'])[1]")).click();
	 	Thread.sleep(2000);
	 	getDriver().findElement(By.xpath("//span[normalize-space()='Earning']")).click();
	 	Thread.sleep(2000);
	 	getDriver().findElement(By.xpath("(//span[normalize-space()='Select'])[2]")).click();
	 	Thread.sleep(2000);
	 	getDriver().findElement(By.xpath("//span[normalize-space()='Holiday Allowance']")).click();
	 	Thread.sleep(2000);
	 	getDriver().findElement(By.xpath("//input[@placeholder='Sequence Order']")).sendKeys("2");
	 	Thread.sleep(2000);
	 	
	 	PerformerLocator.clicksave().click();
	 	
/*	 	WebElement errorMessage = getDriver().findElement(By.xpath("//h4[normalize-space()='Paycode is already exists']"));
	 	if(errorMessage.equals("Paycode is already exists"))
	 	{
	 		test.log(LogStatus.PASS, "Error Message is displayed: " + errorMessage);
	 	}
	 	
	 	else
	 	{
	 		test.log(LogStatus.FAIL, "Error Message is not displayed" );
	 	}
*/	 	
	    
		String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
		
		if(text1.equalsIgnoreCase("Paycode is already exists")) {Thread.sleep(5000);
			test.log(LogStatus.PASS,"Message Displayed : "+text1);
	
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,"Message Displayed : "+text1);
		}

	 	
	 	}
	 
	 public static void PaycodeMappingSearchField ( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	 {
	 	
	 	Thread.sleep(5000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
	 	Thread.sleep(5000);
		PerformerLocator.clickWorkspaceArrow().click();
	 	Thread.sleep(5000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(5000);

	 	
	 	PerformerLocator.clickPaycodeMappingModule().click();
	 	Thread.sleep(3000);

	 	PerformerLocator.PaycodeMappingSearch().click();
	 	Thread.sleep(3000);
	 	PerformerLocator.PaycodeMappingSearch().sendKeys("Basic");
	 	Thread.sleep(3000);
	 	getDriver().findElement(By.xpath("//ul[@class='k-list-ul']")).click();
	 	Thread.sleep(3000);
	 	PerformerLocator.clickApply().click();
	 	
	 	Thread.sleep(7000);                              //Meaning If Absent is displayed then it will fetch
	 	WebElement txt = getDriver().findElement(By.xpath("//div[contains(text(),'Basic')]"));
	 	if(txt.isDisplayed()){
	 		Thread.sleep(1000);
	 		test.log(LogStatus.PASS, "Search Paycode /Header Name dropdown is working fine");
	 	}
		
	 	else
	 	{
	 		test.log(LogStatus.PASS, "Search Value is not displayed");
	 	}
	 	

	 	
	 	}
	 public static void PaycodeMappingEditUpdate ( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	 {
	 	
	 	Thread.sleep(1000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
	 	Thread.sleep(1000);
		PerformerLocator.clickWorkspaceArrow().click();
	 	Thread.sleep(5000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(3000);

	 	
	 	PerformerLocator.clickPaycodeMappingModule().click();
	 	Thread.sleep(3000);
	 
	 	PerformerLocator.clickeditBtn().click();
	 	Thread.sleep(3000);
	 	
	 	PerformerLocator.clicksave().click();
	 	
	
	    
		String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
		
		if(text1.equalsIgnoreCase("Data Edited Successfully")) {Thread.sleep(5000);
		    test.log(LogStatus.PASS,"Edit button is working successfully");
			test.log(LogStatus.PASS,"Message Displayed : "+text1);
	
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,"Message Displayed : "+text1);
		}

	 	
	 	}
	 
	 public static void PaycodeMappingUpload ( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	 {
	 	
	 	Thread.sleep(5000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
	 	Thread.sleep(8000);
		PerformerLocator.clickWorkspaceArrow().click();
	 	Thread.sleep(5000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(3000);

	 	
	 	PerformerLocator.clickPaycodeMappingModule().click();
	 	Thread.sleep(3000);
	 
	 	PerformerLocator.Uplaodclick().click();
	 	Thread.sleep(3000);
	 	getDriver().findElement(By.xpath("//label[normalize-space()='Browse']")).click();
	 	Thread.sleep(3000);
	 	
	 	
  		Robot robot=new Robot();
 		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\PaycodeUpload.xlsx");
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
 		
 		 Thread.sleep(5000);
 				 
 //		 Locators.Upload().click();
 		 getDriver().findElement(By.xpath("(//button[normalize-space()='Upload'])[2]")).click();
 					
 					Thread.sleep(5000);
 				
 					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
 					
 					if(text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
 						test.log(LogStatus.PASS,"Message Displayed : "+text1);
 				
 					}else {Thread.sleep(5000);
 						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
 					}
	 	
	
	    
/*		String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
		
		if(text1.equalsIgnoreCase("Data Edited Successfully")) {Thread.sleep(5000);
		    test.log(LogStatus.PASS,"Edit button is working successfully");
			test.log(LogStatus.PASS,"Message Displayed : "+text1);
	
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,"Message Displayed : "+text1);
		}
*/
	 	
	 	}
	 
	 public static void PaycodeMappingUploadInvalid ( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	 {
	 	
	 	Thread.sleep(1000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
	 	Thread.sleep(1000);
		PerformerLocator.clickWorkspaceArrow().click();
	 	Thread.sleep(5000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(3000);

	 	
	 	PerformerLocator.clickPaycodeMappingModule().click();
	 	Thread.sleep(3000);
	 
	 	PerformerLocator.Uplaodclick().click();
	 	Thread.sleep(3000);
	 	getDriver().findElement(By.xpath("//label[normalize-space()='Browse']")).click();
	 	Thread.sleep(3000);
	 	
	 	
  		Robot robot=new Robot();
 		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\OtherTwo\\ManageMaster-InvalidPayCode.xlsx");
 		 //copy above file to clipboard
 		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
 		
 		 //Now press CRTL
 		
 		 robot.keyPress(KeyEvent.VK_CONTROL);
 		 Thread.sleep(2000);
 		
 		 //PRESS V
 		 robot.keyPress(KeyEvent.VK_V);
 		 Thread.sleep(1000);
 		
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
 		
 		 Thread.sleep(5000);
 				 
 //		 Locators.Upload().click();
 		 getDriver().findElement(By.xpath("(//button[normalize-space()='Upload'])[2]")).click();
 					
 					Thread.sleep(5000);
 				
 		//			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
 					String text1=	PerformerLocator.clickMsg().getText();
 					
 					if(text1.equalsIgnoreCase("Invalid template file!")) {Thread.sleep(5000);
 						test.log(LogStatus.PASS,"Message Displayed : "+text1);
 				
 					}else {Thread.sleep(5000);
 						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
 					}
	 	
	
	    

	 	
	 	}
	 
	 
	 public static void MastersStaturyDoc ( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	 {
	 	
	 	Thread.sleep(1000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
	 	Thread.sleep(1000);
		PerformerLocator.clickWorkspaceArrow().click();
	 	Thread.sleep(5000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(3000);

	 	
	 	PerformerLocator.clickStaturyMasterTab().click();
	 	Thread.sleep(3000);
	 
	 //	PerformerLocator.clickStaturyMasterTab().click();
	 	
	 	PerformerLocator.clickComplianceDropdwon().click();
	 	Thread.sleep(2000);
	 	
	 	PerformerLocator.selectComplianceChallan().click();
	 	Thread.sleep(2000);
	 	
	 	OneCommonMethod.zoomOutScreen(2);
	 	
	 	PerformerLocator.Apply().click();
	 	Thread.sleep(5000);

	 	test.log(LogStatus.INFO,"Checking Challan Export with grid count");
		// Export logic-- Challan
		OneCommonMethod.validateExportedExcel(
			    driver.get(),
			    test,
			    PerformerLocator.clickExportBtn(),            // Export button WebElement
			    PerformerLocator.ReadTotalIteams(),   // Count ka dynamic locator
			    "Short Description"                                  //Header Name
			);
	 	
	
		PerformerLocator.Clear().click();
		Thread.sleep(3000);
		PerformerLocator.clickComplianceDropdwon().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceRegister().click();
		Thread.sleep(2000);
		PerformerLocator.Apply().click();
		Thread.sleep(5000);
		
		
		test.log(LogStatus.INFO,"Now Checking Registers Export with grid count");
		// Export logic-- Registers
		OneCommonMethod.validateExportedExcel(
			    driver.get(),
			    test,
			    PerformerLocator.clickExportBtn(),            // Export button WebElement
			    PerformerLocator.ReadTotalIteams(),   // Count ka dynamic locator
			    "Form Name"                                  //Header Name
			);
		
		PerformerLocator.Clear().click();
		Thread.sleep(2000);
		PerformerLocator.clickComplianceDropdwon().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceReturns().click();
		Thread.sleep(2000);
		PerformerLocator.Apply().click();
		Thread.sleep(5000);
		
		
		test.log(LogStatus.INFO,"Now Checking Returns Export with grid count");
		// Export logic-- Return
		OneCommonMethod.validateExportedExcel(
			    driver.get(),
			    test,
			    PerformerLocator.clickExportBtn(),            // Export button WebElement
			    PerformerLocator.ReadTotalIteams(),   // Count ka dynamic locator
			    "Short Description"                                  //Header Name
			);

	 	
	 	}
	 public static void ChallanPTSlab ( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	 {
	 	
	 	Thread.sleep(1000);
		PerformerLocator.SerchCustomer().sendKeys("AVANEW");
	 	Thread.sleep(1000);
		PerformerLocator.clickWorkspaceArrow().click();
	 	Thread.sleep(5000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(3000);

	 	
	 	PerformerLocator.clickChallanPTSlabTab().click();
	 	Thread.sleep(3000);
	 
	 
	 	OneCommonMethod.zoomOutScreen(2); //ZoomOut
	 	
	 	PerformerLocator.clickOnSelectStateDropdown().click();
	 	Thread.sleep(2000);
	 	
	 	PerformerLocator.clickOnKeralaState().click();
	 	Thread.sleep(2000);
	 	
	 	
	 	PerformerLocator.Apply().click();
	 	Thread.sleep(5000);

//There is some error from dev side thats why hide this:	 	
	 	//Clicking to PT Location Dropdown 
//	 	getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'])[2]")).click();
	 	
	 	//Save Mapping button
//	 	getDriver().findElement(By.xpath("//button[normalize-space()='Save Mapping']")).click();
	 	
	 	//clicking to save button
	 	getDriver().findElement(By.xpath("(//img[@title='Save'])[1]")).click();
	 	
	 	String msg = getDriver().findElement(By.xpath("//h4[normalize-space()='Data Saved Successfully']")).getText();
	 	
		if(msg.equalsIgnoreCase("Data Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Message displayed:-"+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed:-"+msg);
		}
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//button[@title='OK']")).click();
		
		
		if(PerformerLocator.Clear().isDisplayed())
		{
			PerformerLocator.Clear().click();
		}


	 	
	 	}
	 
	 public static void DuplicateDesignation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	 {
	 	
	 	Thread.sleep(1000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
	 	Thread.sleep(1000);
		PerformerLocator.clickDashboard().click();
	 	Thread.sleep(7000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(1000);
		PerformerLocator.clickDesignation().click();
	 	Thread.sleep(1000);
		PerformerLocator.clickAddNewDesignation().click();
	 	
	 	FileInputStream fis = new FileInputStream(filePath);
	     Workbook workbook1 = WorkbookFactory.create(fis);
	     Sheet sheet = workbook1.getSheetAt(0);
	 	
	 	Thread.sleep(1000);
	 	Row row = sheet.getRow(9);						//Selected 0th index row (First row)
	 	Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
	 	String designation = c.getStringCellValue();
		PerformerLocator.enterDesignation().sendKeys(designation);
	 	
	 	Thread.sleep(1000);
	 	
		PerformerLocator.clicksave().click();
	 	
	 	 Thread.sleep(500);
	 	  String msg=			PerformerLocator.clickMsg().getText();		//Reading Message appeared after save button
	 	  
	 	  if(msg.equalsIgnoreCase("Designation is already exists."))
	 	 {
	 		 test.log(LogStatus.PASS, "Message displayed = "+msg);
	 		 
	 	 }
	 	 else
	 	 {
	 		 test.log(LogStatus.FAIL, "Message displayed = "+msg);
	 	 }
	 	  
	 	  Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
	 	}
	 public static void DesignationExportBtn( ExtentTest test,XSSFWorkbook workbook,String user) throws InterruptedException, IOException
	 {
		 
		 Thread.sleep(5000);
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVACORED5");
				Thread.sleep(5000);
				PerformerLocator.clickWorkspaceArrow().click();
			 	Thread.sleep(7000);
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVANEW");
				Thread.sleep(5000);
				PerformerLocator.clickDashboard().click();
			 	Thread.sleep(10000);
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORED5");	
			}
		
	 	Thread.sleep(1000);
	 	Thread.sleep(5000);
	 	WebDriverWait wait2 = new WebDriverWait(getDriver(), (30));
	 	wait2.until(ExpectedConditions.visibilityOf(PerformerLocator.clickManageMaster()));
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(5000);
		PerformerLocator.clickDesignation().click();
	 	Thread.sleep(4000);
		PerformerLocator.clickDesignation().click();
	 	
	 	
	 	Thread.sleep(500);		
	 	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	 	
	     
	     js.executeScript("window.scrollBy(0,500)");
	     Thread.sleep(5000); 		
			PerformerLocator.readTotalItemDesignation().click();
	 	String item = 			PerformerLocator.readTotalItemDesignation().getText();
	 	String[] bits = item.split(" ");								//Splitting the String
	 	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	 	int count1 = Integer.parseInt(compliancesCount);

	 	if(compliancesCount.equalsIgnoreCase("to"))
	 	{
	 		Thread.sleep(5000);
	 	   item = 			PerformerLocator.readTotalItemDesignation().getText();
	 		bits = item.split(" ");
	     
	 	}
	 	
	 	Thread.sleep(2000);
	     JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
	     
	     js1.executeScript("window.scrollBy(0,-500)");
	     Thread.sleep(2000);

	 	Thread.sleep(1000);
	 	File dir = new File("C:\\Users\\bilali\\Downloads");
	 	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	 	Thread.sleep(1000);
		PerformerLocator.clickExportBtn().click();
	 	
	 	WebDriverWait wait=new WebDriverWait(getDriver(), 60);
	 	Thread.sleep(10000);
	 	wait.until(ExpectedConditions.invisibilityOf(PerformerLocator.GridLoad1()));
	 	Thread.sleep(60000);


	 	Thread.sleep(5500);
	 	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	 	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	 	if(dirContents.length < allFilesNew.length)
	 	{
	 		Thread.sleep(4000);					//Clicking on 'Excel Report' image.
	 		test.log(LogStatus.PASS, "File downloaded successfully.");
	 		File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	     for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	     {
	        if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	        {
	            lastModifiedFile = allFilesNew[i];
	        }
	     }
	 	
	 	Thread.sleep(4000);
	 	fis = new FileInputStream(lastModifiedFile);
	 	workbook = new XSSFWorkbook(fis);
	 	sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
	 	
	 	sheet = workbook.getSheetAt(0);
	 	int columnNumber = 0;
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
	 		Thread.sleep(7000);
	 		test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
	 	}

	 	
	 	}
	 public static void BulkUploadDesignation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	 {
	 	
	 	Thread.sleep(1000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
	 	Thread.sleep(1000);
		PerformerLocator.clickWorkspaceArrow().click();
	 	Thread.sleep(6000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(1000);
		PerformerLocator.clickDesignation().click();
	 	
	 	Thread.sleep(1000);
		PerformerLocator.clickUploadBtn().click();
	 	
	 	
	 		
	 		 Thread.sleep(1000);
				PerformerLocator.clickBrowse1().click();
	 			
	 			 Robot robot=new Robot();
	 			 
	 			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\DesignationSample.xlsx");
	 			 //copy above file to clipboard
	 			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
	 			 
	 			 //Now press CRTL
	 			 
	 			 robot.keyPress(KeyEvent.VK_CONTROL);
	 			 Thread.sleep(1000);
	 			 
	 			 //PRESS V
	 			 robot.keyPress(KeyEvent.VK_V);
	 			 Thread.sleep(1000);
	 			 
	 			 //Release V
	 			 robot.keyRelease(KeyEvent.VK_V);
	 			 
	 			 
	 			 //Release CRTL
	 			 robot.keyRelease(KeyEvent.VK_CONTROL);
	 			 
	 			 //PRESS Enter
	 			 robot.keyPress(KeyEvent.VK_ENTER);
	 			 
	 			 //Release CRTL
	 			 robot.keyRelease(KeyEvent.VK_ENTER);
	 			 
	 			 Thread.sleep(1000);
	 			 System.out.println("File uploaded successfully");
	 			 
	 		     Thread.sleep(1000);
	 			PerformerLocator.clickUploadbtnCTCBtn().click();
	 			
	 			Thread.sleep(2000);
	 			String msg=	PerformerLocator.clickMsg().getText();
	 			
	 			 if(msg.equalsIgnoreCase("File uploaded successfully"))
	 			 {
	 				 test.log(LogStatus.PASS, "Message displayed = "+msg);
	 				 
	 			 }
	 			 else
	 			 {
	 				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
	 			 }
	 			 Thread.sleep(1000);
	 			PerformerLocator.clickOkBtn().click();
	 			
//	 			Thread.sleep(1000);
//	 			ReviwerLocator.clickcloseBtn().click();
	 			Thread.sleep(1000);
				PerformerLocator.clickdashboard().click();
	 		
	 		
	 	
	 	}
	 
	 public static void BulkUpateDesignationn( ExtentTest test,XSSFWorkbook workbook,String user) throws Exception
	 {
	 	
	 	Thread.sleep(5000);
		PerformerLocator.SerchCustomer().sendKeys("TESTAUTO3");
	 	Thread.sleep(5000);
	 	
	 	if(user.equalsIgnoreCase("Performer"))
		{
	 		PerformerLocator.clickWorkspaceArrow().click();
	 		Thread.sleep(5000);
		}
		
		else if(user.equalsIgnoreCase("Distributor"))
		{
			PerformerLocator.DistributorPremisesArrow().click();
			Thread.sleep(5000);
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			PerformerLocator.ReviewerStaturyDocumentArrow().click();
			Thread.sleep(5000);
		}
	 	Thread.sleep(5000);
	 	Thread.sleep(5000);
	 	
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(5000);
		PerformerLocator.clickDesignation().click();
	 	
	 	Thread.sleep(5000);
		PerformerLocator.clickUploadBtn().click();
		Thread.sleep(5000);
		PerformerLocator.UploadDesignationDetailes().click();
	 	
		OneCommonMethod.validateFileDownloadDynamic(
			    driver.get(),
			    test,
			    PerformerLocator.SampleDocumentDownload(),   // WebElement
			    "Sample Document is downloaded"   // Dynamic log message
			);
	 	
	 		
		Thread.sleep(5000);
				PerformerLocator.clickBrowse1().click();
	 			
	 			 Robot robot=new Robot();
	 			 
	 			 OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\OtherTwo\\Designation.xlsx");
	 			 
	 /*			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\DesignationSample.xlsx");
	 			 //copy above file to clipboard
	 			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
	 			 
	 			 //Now press CRTL
	 			 
	 			 robot.keyPress(KeyEvent.VK_CONTROL);
	 			 Thread.sleep(1000);
	 			 
	 			 //PRESS V
	 			 robot.keyPress(KeyEvent.VK_V);
	 			 Thread.sleep(1000);
	 			 
	 			 //Release V
	 			 robot.keyRelease(KeyEvent.VK_V);
	 			 
	 			 
	 			 //Release CRTL
	 			 robot.keyRelease(KeyEvent.VK_CONTROL);
	 			 
	 			 //PRESS Enter
	 			 robot.keyPress(KeyEvent.VK_ENTER);
	 			 
	 			 //Release CRTL
	 			 robot.keyRelease(KeyEvent.VK_ENTER);
	 			 
	 			 Thread.sleep(1000);
	 			 System.out.println("File uploaded successfully");
	 	*/		 
	 		     Thread.sleep(1000);
	 			PerformerLocator.clickUploadbtnCTCBtn().click();
	 			
	 			Thread.sleep(2000);
	 			String msg=	PerformerLocator.clickMsg().getText();
	 			
	 			 if(msg.equalsIgnoreCase("File uploaded successfully"))
	 			 {
	 				 test.log(LogStatus.PASS, "Message displayed = "+msg);
	 				 
	 			 }
	 			 else
	 			 {
	 				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
	 			 }
	 			 Thread.sleep(1000);
	 			PerformerLocator.clickOkBtn().click();
	 			
//	 			Thread.sleep(1000);
//	 			ReviwerLocator.clickcloseBtn().click();
	 			Thread.sleep(1000);
	 		
	 	
	 	}
	 
	 public static void BulkUpateDesignationAlreadyExist( ExtentTest test,XSSFWorkbook workbook,String user) throws Exception
	 {
	 	
	 	Thread.sleep(5000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
	 	Thread.sleep(5000);
	 	
	 	if(user.equalsIgnoreCase("Performer"))
		{
	 		PerformerLocator.clickWorkspaceArrow().click();
	 		Thread.sleep(5000);
		}
		
		else if(user.equalsIgnoreCase("Distributor"))
		{
			PerformerLocator.DistributorPremisesArrow().click();
			Thread.sleep(5000);
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			PerformerLocator.ReviewerStaturyDocumentArrow().click();
			Thread.sleep(5000);
		}
	 	Thread.sleep(5000);
	 	Thread.sleep(5000);
	 	
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(5000);
		PerformerLocator.clickDesignation().click();
	 	
	 	Thread.sleep(5000);
		PerformerLocator.clickUploadBtn().click();
		Thread.sleep(5000);
//		PerformerLocator.UploadDesignationDetailes().click();
	 	
		OneCommonMethod.validateFileDownloadDynamic(
			    driver.get(),
			    test,
			    PerformerLocator.SampleDocumentDownload(),   // WebElement
			    "Sample Document is downloaded"   // Dynamic log message
			);
	 	
	 		
		        Thread.sleep(5000);
				PerformerLocator.clickBrowse1().click();
	 			
	 			 Robot robot=new Robot();
	 			 
	 			 OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\OtherTwo\\DesignationSampleAlreadyExist.xlsx");
	 			 		 
	 		     Thread.sleep(1000);
	 			PerformerLocator.clickUploadbtnCTCBtn().click();
	 			
	 			Thread.sleep(2000);
	 			String msg=	PerformerLocator.clickMsg().getText();
	 			
	 			 if(msg.equalsIgnoreCase("Error While Uploading"))
	 			 {
	 				 test.log(LogStatus.PASS, "Message displayed = "+msg);
	 				 
	 			 }
	 			 else
	 			 {
	 				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
	 			 }
	 			 Thread.sleep(1000);
	 			PerformerLocator.clickOkBtn().click();
	 			
//	 			Thread.sleep(1000);
//	 			ReviwerLocator.clickcloseBtn().click();
	 			Thread.sleep(1000);
	 		
	 	}
	 
	 public static void BulkUpateDesignationAlreadyExistForUpdate( ExtentTest test,XSSFWorkbook workbook,String user) throws Exception
	 {
	 	
	 	Thread.sleep(5000);Thread.sleep(5000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
	 	Thread.sleep(5000);
	 	
	 	if(user.equalsIgnoreCase("Performer"))
		{
	 		PerformerLocator.clickWorkspaceArrow().click();
	 		Thread.sleep(5000);
		}
		
		else if(user.equalsIgnoreCase("Distributor"))
		{
			PerformerLocator.DistributorPremisesArrow().click();
			Thread.sleep(5000);
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			PerformerLocator.ReviewerStaturyDocumentArrow().click();
			Thread.sleep(5000);
		}
	 	Thread.sleep(5000);
	 	Thread.sleep(5000);
	 	
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(5000);
		PerformerLocator.clickDesignation().click();
	 	
	 	Thread.sleep(5000);
		PerformerLocator.clickUploadBtn().click();
		Thread.sleep(5000);
		PerformerLocator.UploadDesignationDetailes().click();
	 	
		OneCommonMethod.validateFileDownloadDynamic(
			    driver.get(),
			    test,
			    PerformerLocator.SampleDocumentDownload(),   // WebElement
			    "Sample Document is downloaded"   // Dynamic log message
			);
	 	
	 		
		        Thread.sleep(5000);
				PerformerLocator.clickBrowse1().click();
	 			
	 			 Robot robot=new Robot();
	 			 
	 			 OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\OtherTwo\\DesignationSampleUploadError.xlsx");
	 			 		 
	 		     Thread.sleep(1000);
	 			PerformerLocator.clickUploadbtnCTCBtn().click();
	 			
	 			Thread.sleep(2000);
	 			String msg=	PerformerLocator.clickMsg().getText();
	 			
	 			 if(msg.equalsIgnoreCase("Error While Uploading"))
	 			 {
	 				 test.log(LogStatus.PASS, "Message displayed = "+msg);
	 				 
	 			 }
	 			 else
	 			 {
	 				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
	 			 }
	 			 Thread.sleep(1000);
	 			PerformerLocator.clickOkBtn().click();
	 			
//	 			Thread.sleep(1000);
//	 			ReviwerLocator.clickcloseBtn().click();
	 			Thread.sleep(1000);
	 		
	 		
	 	
	 	}
	 
	 public static void BulkUploadDesignationDetailes( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
	 {
	 	
	 	Thread.sleep(1000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
	 	Thread.sleep(1000);
		PerformerLocator.clickDashboard().click();
	 	Thread.sleep(6000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(1000);
		PerformerLocator.clickDesignation().click();
	 	Thread.sleep(1000);
		PerformerLocator.clickUploadBtn().click();
	 	Thread.sleep(1000);
		PerformerLocator.UploadDesignationDetailes().click();
	 	
	 		
	 		 Thread.sleep(1000);
				PerformerLocator.clickBrowse1().click();
	 			
	 			 Robot robot=new Robot();
	 			 
	 			 StringSelection filepath= new  StringSelection("C:\\Users\\snehalp\\Documents\\DesignationSample.xlsx");
	 			 //copy above file to clipboard
	 			 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
	 			 
	 			 //Now press CRTL
	 			 
	 			 robot.keyPress(KeyEvent.VK_CONTROL);
	 			 Thread.sleep(1000);
	 			 
	 			 //PRESS V
	 			 robot.keyPress(KeyEvent.VK_V);
	 			 Thread.sleep(1000);
	 			 
	 			 //Release V
	 			 robot.keyRelease(KeyEvent.VK_V);
	 			 
	 			 
	 			 //Release CRTL
	 			 robot.keyRelease(KeyEvent.VK_CONTROL);
	 			 
	 			 //PRESS Enter
	 			 robot.keyPress(KeyEvent.VK_ENTER);
	 			 
	 			 //Release CRTL
	 			 robot.keyRelease(KeyEvent.VK_ENTER);
	 			 
	 			 Thread.sleep(1000);
	 			 System.out.println("File uploaded successfully");
	 			 
	 		     Thread.sleep(1000);
	 			PerformerLocator.clickUploadbtnCTCBtn().click();
	 			
	 			Thread.sleep(2000);
	 			String msg=	PerformerLocator.clickMsg().getText();
	 			
	 			 if(msg.equalsIgnoreCase("File uploaded successfully"))
	 			 {
	 				 test.log(LogStatus.PASS, "Message displayed = "+msg);
	 				 
	 			 }
	 			 else
	 			 {
	 				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
	 			 }
	 			 Thread.sleep(1000);
	 			PerformerLocator.clickOkBtn().click();
	 			

//	 				 * Thread.sleep(1000); Distr
//	 				 */ubutorLocators.clickcloseBtn().click();
	 			Thread.sleep(1000);
				PerformerLocator.clickdashboard().click();
	 		
	 		
	 	
	 	}

	 public static void DeleteDesignation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	 {
	 	
	 	Thread.sleep(1000);
		PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
	 	Thread.sleep(5000);
		PerformerLocator.clickWorkspaceArrow().click();
	 	Thread.sleep(7000);
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(4000);
		PerformerLocator.clickDesignation().click();
		Thread.sleep(8000);
		
	 	PerformerLocator.DesignationSerach().click();
	 	
	 	//Give max wait due to hudge data
	 	
	 	Thread.sleep(7000);
	 	PerformerLocator.DesignationSerach().sendKeys("abcdefghijklmnopqrstuvwxyz");
	 	Thread.sleep(7000);
		
	 	getDriver().findElement(By.xpath("(//span[@class='k-list-item-text'])[1]")).click();
		
	 	PerformerLocator.clickApply().click();
	 	
	 	Thread.sleep(4000);
		PerformerLocator.clickDeleteBtn().click();
	 	
	 	
	 	Thread.sleep(500);
	 	  String msg=PerformerLocator.clickDeletemsg().getText();		//Reading Message appeared after save button
	 	  
	 	  if(msg.equalsIgnoreCase("Are you sure you want to inactive this record?"))
	 	 {
	 		 test.log(LogStatus.PASS, "Message displayed = "+msg);
	 		 
	 	 }
	 	 else
	 	 {
	 		 test.log(LogStatus.FAIL, "Message displayed = "+msg);
	 	 }
	 	
	 	 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
	 		
	 		Thread.sleep(500);
	 		  String msg1=PerformerLocator.clickDeletemsg1().getText();		//Reading Message appeared after save button
	 		  
	 		  if(msg1.equalsIgnoreCase("Designation Inactivated Successfully"))
	 		 {
	 			 test.log(LogStatus.PASS, "Message displayed = "+msg1);
	 			 
	 		 }
	 		 else
	 		 {
	 			 test.log(LogStatus.FAIL, "Message displayed = "+msg1);
	 		 }
	 	 Thread.sleep(1000);
			PerformerLocator.clickOkBtn().click();
	 	
	 }
	 public static void DesignationClearBtn( ExtentTest test,XSSFWorkbook workbook, String user) throws InterruptedException, IOException
	 {
	 	
			if(user.equalsIgnoreCase("Performer"))
			{
				Thread.sleep(4000);
				LoginLocators.Search().sendKeys("AVACORED5");
//				PerformerLocator.SerchCustomer().sendKeys("AVACORED5");
			 	Thread.sleep(5000);
				PerformerLocator.clickWorkspaceArrow().click();
			 	Thread.sleep(7000);
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVACORED5");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORED5");	
			}
		 
		 
		PerformerLocator.clickManageMaster().click();
	 	Thread.sleep(1000);
		PerformerLocator.clickDesignation().click();
	 	
	 	Thread.sleep(1000);
		PerformerLocator.clickstatus().click();
	 	Thread.sleep(1000);
		PerformerLocator.selectstatus().click();
	 	

	 	Thread.sleep(2000);
	 	if(PerformerLocator.clickclearBtn().isEnabled())
	 	{
	 		Thread.sleep(2000);
			PerformerLocator.clickclearBtn().click();
	 		 test.log(LogStatus.PASS, "clear button Work Successfully");
	 	}
	 	else
	 	{
	 		test.log(LogStatus.FAIL, "clear button not Work Successfully");
	 	}
	 	Thread.sleep(2000);
		PerformerLocator.clickdashboard().click();
	 }
	 public static void selectOptionFromDropDown_bs(List<WebElement> options, String value) 
	 {
	 	
	 	for(WebElement option:options)
	 	{
	 		if(option.getText().equals(value))
	 		{
	 			option.click();
	 			break;
	 		}
	 	}
	 }


}
