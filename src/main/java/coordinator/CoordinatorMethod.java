package coordinator;

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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import clientPortal.All_ClientPortal_Locators;
import distributor.DistributerLocators;
import login.BasePage;
import rcp.OneCommonMethod;
import rcp.RCPMethod;





public class CoordinatorMethod extends BasePage
{

	 static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour2.xlsx";
	 
	 
	 public static void CountMatch( ExtentTest test,String Notice) throws InterruptedException, IOException
		{
		 
        Thread.sleep(5000);
		int pendingAssignment = 0;
		Thread.sleep(10000);
		if(Notice.equalsIgnoreCase("Pending Assignment"))
		{
			Thread.sleep(10000);
			String string_pendingAssignment = CoordinatorLocator.pendingAssignmentCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(10000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(10000);
			CoordinatorLocator.pendingAssignmentCount().click();
			Thread.sleep(5000);
			OneCommonMethod.scroll(getDriver(), 1000);
		}
		else if(Notice.equalsIgnoreCase("Pending Action"))
		{
			Thread.sleep(10000);
			String string_pendingAssignment = CoordinatorLocator.pendingActionCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(10000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(10000);
			CoordinatorLocator.pendingActionCount().click();
			Thread.sleep(5000);
			OneCommonMethod.scroll(getDriver(), 1000);
		}
		else if(Notice.equalsIgnoreCase("Overdue"))
		{
			Thread.sleep(10000);
			String string_pendingAssignment = CoordinatorLocator.OverdueCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(10000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(10000);
			CoordinatorLocator.OverdueCount().click();
			Thread.sleep(5000);
			OneCommonMethod.scroll(getDriver(), 1000);
			
		}
		else if(Notice.equalsIgnoreCase("Closed"))
		{
			Thread.sleep(10000);
			String string_pendingAssignment = CoordinatorLocator.ClosedCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(10000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(10000);
			CoordinatorLocator.ClosedCount().click();
			Thread.sleep(5000);
			OneCommonMethod.scroll(getDriver(), 1000);
		}
		
		
		Thread.sleep(10000);
//		CoordinatorLocator.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CoordinatorLocator.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String pendingAssignmentcount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count = Integer.parseInt(pendingAssignmentcount);
		Thread.sleep(5000);
		
		
		if(pendingAssignment == count)
		{
		
		//	test.log(LogStatus.PASS, Notice+":- box count = "+pendingAssignment+ " | " +Notice+ ":- box  grid Count = "+count);
			
			test.log(LogStatus.PASS, Notice + ":- box count = " + pendingAssignment);
			
			test.log(LogStatus.PASS, Notice + ":- box grid Count = " + count);
		}
		else
		{
			test.log(LogStatus.FAIL, Notice+":- box count= "+pendingAssignment+ " | " +Notice+ ":-box  grid Count = "+count);
		}
		
	}
	 
	 public static void CoordinatorLogo( ExtentTest test) throws InterruptedException, IOException
		{
		 
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
	 public static void ColumnExpandIcon( ExtentTest test) throws InterruptedException, IOException
		{
		 
        Thread.sleep(5000);
        
        WebElement ExpandIcon = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/SidebarToggle.svg']"));
        
        Thread.sleep(5000);
        if(ExpandIcon.isEnabled())
        {
        	Thread.sleep(5000);
        	ExpandIcon.click();
        	test.log(LogStatus.PASS,"Column Expand Icon is working successfully");
        }
        else
        {
        	test.log(LogStatus.FAIL,"Column Expand Icon is not working properly");
        }
        
	}
	 
	 public static void Noticelinkbuttonworking( ExtentTest test) throws InterruptedException, IOException
		{
		 
        Thread.sleep(5000);
        
        getDriver().findElement(By.xpath("//span[normalize-space()='Registration']")).click();
        
        WebElement Noticelink = getDriver().findElement(By.xpath("//span[normalize-space()='Notices']"));
        Noticelink.click();
        WebElement NoticeDash = getDriver().findElement(By.xpath("//h4[normalize-space()='Co-ordinator Dashboard']"));
        
        Thread.sleep(5000);
        if(NoticeDash.isDisplayed())
        {
        	Thread.sleep(5000);
        	test.log(LogStatus.PASS,"Notice button link is working successfully");
        }
        else
        {
        	test.log(LogStatus.FAIL,"Notice button link is not working properly");
        }
        
	}
	 public static void NoticelinkbuttonDashboard( ExtentTest test) throws InterruptedException, IOException
		{
		 
        Thread.sleep(5000);
        
        getDriver().findElement(By.xpath("//span[normalize-space()='Registration']")).click();
        
        WebElement Noticelink = getDriver().findElement(By.xpath("//span[normalize-space()='Notices']"));
        Noticelink.click();
        WebElement NoticeDash = getDriver().findElement(By.xpath("//h4[normalize-space()='Co-ordinator Dashboard']"));
        
        Thread.sleep(5000);
        if(NoticeDash.isDisplayed())
        {
        	Thread.sleep(5000);
        	test.log(LogStatus.PASS,"Notice Co-ordinator Dashboard is displayed");
        }
        else
        {
        	test.log(LogStatus.FAIL,"Notice Co-ordinator Dashboard is not displayed");
        }
        
	}
	 
	 public static void AddNewNotices(ExtentTest test) throws Exception
	 {
	 	
	 	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	 
	 	
	 	Thread.sleep(2000);
		String item = CoordinatorLocator.readTotalItems().getText();
		String[] bits = item.split(" ");								//Splitting the String
		if(bits.length > 2)
		{
			Thread.sleep(2000);
			item = CoordinatorLocator.readTotalItems().getText();
			bits = item.split(" ");								//Splitting the String
		}
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			item = CoordinatorLocator.readTotalItems().getText();
			bits = item.split(" ");									//Splitting the String
			compliancesCount = bits[bits.length - 2];
		}
		int count = Integer.parseInt(compliancesCount);
	 	
		Thread.sleep(1000);
	 	CoordinatorLocator.clickaddnewNotices().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickEntity().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.selectEntity().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickState().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.selectState1().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickLocation1().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.selectLocation1().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickBranch1().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.selectLocation1().click();   //Select Branch
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickModeOfReceipt().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.selectLocation1().click();   //Select Mode Of Receipt
	 	
	 	
	 	
	 	FileInputStream fis = new FileInputStream(filePath);
	     Workbook workbook1 = WorkbookFactory.create(fis);
	     Sheet sheet = workbook1.getSheetAt(3);
	 	
	     Thread.sleep(1000);
	 	Row row6 = sheet.getRow(4);						//Selected 0th index row (First row)
	 	Cell c6= row6.getCell(1);						//Selected cell (0 row,1 column)
//	 	int NoriceNo = (int) c6.getNumericCellValue();
//	 	Cell NoriceNo =  c6.getCell();
	 	
	 	row6 = sheet.getRow(4);
		c6 = row6.getCell(1);
		CoordinatorLocator.clickNoticeNumber().sendKeys(c6.getStringCellValue()+getRandomString());
		Thread.sleep(6000);
	 	
	 	
	 	
	 	
//	 	CoordinatorLocator.clickNoticeNumber().sendKeys(NoriceNo+getRandomString());
	 	
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickCalender().click();
	 	
	 	Thread.sleep(10000);
	 	Actions action = new Actions(getDriver());
	 	WebElement we = getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='21']"));
	 	action.moveToElement(we).click().build().perform();
//	 	Thread.sleep(1000);
//	 	Locator.selectDate().click();
	 	Thread.sleep(5000);
	 	CoordinatorLocator.clickCalenderReponseDueDate().click();
	 	Thread.sleep(3000);

	 	WebElement we1= getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='28']"));
	 	action.moveToElement(we1).click().build().perform();
//	 	Locator.selectDate2().click();
	 	
	 	CoordinatorLocator.clickNoticeType().click();
	 	Thread.sleep(3000);
	 	CoordinatorLocator.selectLocation1().click();   //Select Notice type
	 	
	 	CoordinatorLocator.clickRisk().click();
	 	Thread.sleep(3000);
	 	CoordinatorLocator.selectLocation1().click();   //Select Risk type
	 	
	 	
	 	Row row = sheet.getRow(5);						//Selected 0th index row (First row)
	 	Cell c= row.getCell(1);						//Selected cell (0 row,1 column)
	 	String Remark = c.getStringCellValue();
	 	CoordinatorLocator.clickRemark().sendKeys(Remark);
	 	
	 	 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
	 	Thread.sleep(3000);
	 	 OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\Other Upload No need to change\\sample.pdf");
	 	 
/*	 	 Robot robot=new Robot();
	 	 
	 	 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\sample.pdf");
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
	 
*/	 	 
	 	 Thread.sleep(1000);
	 	 System.out.println("File uploaded successfully");
	 	 
	 	 Thread.sleep(1000);
	 	CoordinatorLocator.clickSaveNotice().click();
	 	 Thread.sleep(1000);
	 	String msg=CoordinatorLocator.clickSuccessNotice().getText();
	 	if(msg.equalsIgnoreCase("Notice Saved Successfully"))
	 	{
	 		test.log(LogStatus.PASS,"Message displayed:-" +msg);
	 	}
	 	else
	 	{
	 		test.log(LogStatus.FAIL,"Message displayed:-" +msg);
	 	}
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickOkBtn().click();
	 	 Thread.sleep(1000);
	 	CoordinatorLocator.clickBack().click();
	 	
		JavascriptExecutor js2 = (JavascriptExecutor) getDriver();
		js2.executeScript("window.scrollBy(0,5000)");	
		
		Thread.sleep(5000);
//		CoordinatorLocator.readTotalItems().click();
		String item1 = CoordinatorLocator.readTotalItems().getText();
		js2.executeScript("window.scrollBy(0,5000)");
		String[] bits1 = item1.split(" ");								//Splitting the String
		
		if(bits1.length > 2)
		{
			Thread.sleep(2000);
			item1 = CoordinatorLocator.readTotalItems().getText();
			js2.executeScript("window.scrollBy(0,5000)");
			bits1 = item1.split(" ");								//Splitting the String
		}
		String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
		
		if(compliancesCount1.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			item1 = CoordinatorLocator.readTotalItems().getText();
			bits1 = item1.split(" ");									//Splitting the String
			compliancesCount1 = bits1[bits1.length - 2];
		}
		int count1 = Integer.parseInt(compliancesCount1);
		if(count <count1)
			{
			
				test.log(LogStatus.PASS, "Total Notice Count increased in grid after adding New Notice - Old Notice Count from Grid  = "+count+" | New Notice Count from Grid = "+count1);
				
			}
			else
			{
				test.log(LogStatus.FAIL, "Total Notice Count doesn't increased in grid after adding New Notice - Old Notice Count from Grid  = "+count+" | New Notice Count from Grid = "+count1);
			}
	 	
	 	
/*	 
	 	Thread.sleep(1000);
 		CoordinatorLocator.EditBtn1().click();
 		
 		Thread.sleep(2000);
	      JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
	      
	      js1.executeScript("window.scrollBy(900,0)");
	 	
	      Thread.sleep(3000);
		 	
		 	WebElement we3 = getDriver().findElement(By.xpath("//span[contains(text(),'Select SME Team')]"));
		 	action.moveToElement(we3).click().build().perform();
	      
 		 Thread.sleep(4000);
 	 	CoordinatorLocator.selectSMETeam().click();
	 	
 	 	Thread.sleep(4000);
  	 	CoordinatorLocator.clickSDExecuterTeam().click();
  	 	
  	    Thread.sleep(4000);
  	  CoordinatorLocator.selectSMETeam().click();

	 	
	 	WebElement we4 = getDriver().findElement(By.xpath("(//button[normalize-space()='Save'])[2]"));
	 	action.moveToElement(we4).click().build().perform();
	 	
	 	Thread.sleep(1000);
	 	String msg1=CoordinatorLocator.clickSuccessMsg1().getText();
	 	if(msg1.equalsIgnoreCase("Notice saved succesfully"))
	 	{
	 		test.log(LogStatus.PASS,"Additional Information to be updated by coordinator:-" +msg1);
	 	}
	 	else
	 	{
	 		test.log(LogStatus.FAIL,"Additional Information do not be updated by coordinator:-" +msg1);
	 	}
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickOkBtn().click();
	 	 Thread.sleep(1000);
	 	CoordinatorLocator.clickBack().click();
	 	
	*/ 	
	 	
	 }
	 public static void ExistingNotice(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
	 	
	 	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	 
	 	
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickaddnewNotices().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickEntity().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.selectEntity().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickState().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.selectState1().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickLocation1().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.selectLocation1().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickBranch1().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.selectLocation1().click();   //Select Branch
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickModeOfReceipt().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.selectLocation1().click();   //Select Mode Of Receipt
	 	
	 	
	 	
	 	FileInputStream fis = new FileInputStream(filePath);
	     Workbook workbook1 = WorkbookFactory.create(fis);
	     Sheet sheet = workbook1.getSheetAt(3);
	 	
	     Thread.sleep(1000);
	 	Row row6 = sheet.getRow(4);						//Selected 0th index row (First row)
	 	Cell c6= row6.getCell(1);						//Selected cell (0 row,1 column)

	 
	 	//int NoriceNo = (int) c6.getNumericCellValue(); //me comment this and added below lines due to alphanumeric value it is not taking
	 	
	 	row6 = sheet.getRow(4);
		c6 = row6.getCell(1);
		CoordinatorLocator.clickNoticeNumber().sendKeys(c6.getStringCellValue());
		Thread.sleep(6000);
	 	
	 	
	 	
//	 	CoordinatorLocator.clickNoticeNumber().sendKeys(NoriceNo+"");
	 	
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickCalender().click();
	 	
	 	Thread.sleep(1000);
	 	Actions action = new Actions(getDriver());
	 	WebElement we = getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='21']"));
	 	action.moveToElement(we).click().build().perform();
//	 	Thread.sleep(1000);
//	 	Locator.selectDate().click();
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickCalenderReponseDueDate().click();
	 	Thread.sleep(1000);

	 	WebElement we1= getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='28']"));
	 	action.moveToElement(we1).click().build().perform();
//	 	Locator.selectDate2().click();
	 	
	 	CoordinatorLocator.clickNoticeType().click();
	 	CoordinatorLocator.selectLocation1().click();   //Select Notice type
	 	
	 	CoordinatorLocator.clickRisk().click();
	 	CoordinatorLocator.selectLocation1().click();   //Select Risk type
	 	
	 	
	 	Row row = sheet.getRow(5);						//Selected 0th index row (First row)
	 	Cell c= row.getCell(1);						//Selected cell (0 row,1 column)
	 	String Remark = c.getStringCellValue();
	 	CoordinatorLocator.clickRemark().sendKeys(Remark);
	 	
	 	 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
	 	 
	 	 Robot robot=new Robot();
	 	 
	 	 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\sample.pdf");
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
	 	CoordinatorLocator.clickSaveNotice().click();
	 	 Thread.sleep(1000);
	 	String msg=CoordinatorLocator.clickInvalidNotice().getText();
	 	if(msg.equalsIgnoreCase("Notice Number already exist"))
	 	{
	 		test.log(LogStatus.PASS,"Message displayed:-" +msg);
	 	}
	 	else
	 	{
	 		test.log(LogStatus.FAIL,"Message displayed:-" +msg);
	 	}
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickOkBtn().click();
	 	 Thread.sleep(1000);
	 	CoordinatorLocator.clickBack().click();
	 	
	 	
	 }
	 
	 public static void NoticeExportBtn(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
	 	
	 	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	 	
		Thread.sleep(2000);
//	      CoordinatorLocator.readTotalItems().click();
		String item = CoordinatorLocator.readTotalItems().getText();
		String[] bits = item.split(" "); // Splitting the String
		String compliancesCount = bits[bits.length - 2]; // Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);

		if (compliancesCount.equalsIgnoreCase("to")) {
			Thread.sleep(5000);
			item = CoordinatorLocator.readTotalItems().getText();
			bits = item.split(" ");

		}

		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) getDriver();

		js1.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(1000);
		CoordinatorLocator.clickNoticeExport().click();

		Thread.sleep(5500);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download

		if (dirContents.length < allFilesNew.length) {

			Thread.sleep(9000); // Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
			File lastModifiedFile = allFilesNew[0]; // Storing any 0th index file in 'lastModifiedFile' file name.
			for (int i = 1; i < allFilesNew.length; i++) // For loop till the number of files in directory.
			{
				if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) // If allFilesNew[i] file is having
																						// large/latest time time of
																						// update then latest modified
																						// file be allFilesNew[i] file.
				{
					lastModifiedFile = allFilesNew[i];
				}
			}

			Thread.sleep(1000);
			fis = new FileInputStream(lastModifiedFile);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0); // Retrieving first sheet of Workbook

			sheet = workbook.getSheetAt(0);
			int columnNumber = 3;
			int rowCount = 0;
			int actualRow = 0;

			for (Row row : sheet) {

				Cell cell = row.getCell(columnNumber);
				if (cell != null) {

					rowCount++;
					actualRow = rowCount - 1;
				}

			}
			fis.close();

			if (count1 == actualRow) {
				// test.log(LogStatus.PASS, "No of records from grid matches to no of records in
				// Excel Sheet.");
				test.log(LogStatus.PASS,
						"Total records from Grid = " + count1 + " | Total records from Report = " + actualRow);
			} else {
				// test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of
				// records in Excel Sheet.");
				test.log(LogStatus.FAIL,
						"Total records from Grid = " + count1 + " | Total records from Excel Sheet = " + actualRow);
			}
		} else {
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}

	 	
	 }
	 public static void NoticeSearchBox(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
	 	
	 	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	 	
	 	
	 	Thread.sleep(3000);
//	 	CoordinatorLocator.SearchBox().sendKeys("QWW",Keys.ENTER);
	 	
	 	
	 	try {
	 	    Thread.sleep(5000);

	 	    String[] searchKeywords = {
	 	        "20676", "TESTAUTO2", "Test Automation 2", "Branch Punjab", "Summon", 
	 	        "RCP25-11620", "NoticeNumber2", "27-Apr-2025", "26-Apr-2025",
	 	        "Highly Critical", "Pending Assignmentsa", "26-Apr-2025"
	 	    };

	 	    // Fetch all headers once
	 	    List<WebElement> headerElements = getDriver().findElements(By.xpath("//table/thead/tr/th"));
	 	    List<String> headerNames = new ArrayList<>();
	 	    for (WebElement header : headerElements) {
	 	        headerNames.add(header.getText());
	 	    }

	 	    for (String keyword : searchKeywords) {
	 	        
	 	        CoordinatorLocator.SearchBox().clear();
	 	        CoordinatorLocator.SearchBox().sendKeys(keyword, Keys.ENTER);
	 	        
	 	        Thread.sleep(4000);

	 	        try {
	 	            WebElement cell = getDriver().findElement(By.xpath("//div[@title='" + keyword + "']"));
	 	            WebElement row = cell.findElement(By.xpath("./ancestor::tr"));
	 	            List<WebElement> allCells = row.findElements(By.xpath("./td"));

	 	            int columnIndex = -1;
	 	            for (int i = 0; i < allCells.size(); i++) {
	 	                if (allCells.get(i).getText().trim().equals(keyword)) {
	 	                    columnIndex = i + 1; // XPath 1-based index
	 	                    break;
	 	                }
	 	            }

	 	            String columnName = "Unknown Column";
	 	            if (columnIndex != -1 && columnIndex <= headerNames.size()) {
	 	                columnName = headerNames.get(columnIndex - 1);
	 	            }

	 	            test.log(LogStatus.PASS, "Searched and found record under '" + columnName + "' column: " + keyword);

	 	        } catch (Exception e) {
	 	            String defaultColumn = headerNames.size() > 0 ? headerNames.get(0) : "Unknown Column";
	 	            test.log(LogStatus.INFO, "No record available for search keyword: " + keyword + " under column: " + defaultColumn);
	 	        }

	 	        Thread.sleep(3000);
	 	        All_ClientPortal_Locators.Clear().click();
	 	        Thread.sleep(2000);
	 	    }

	 	} catch (Exception e) {
	 	    e.printStackTrace();
	 	    test.log(LogStatus.FAIL, "Exception occurred during multiple searches");
	 	}

	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
/*	 	
	 	try {
	 	    Thread.sleep(5000);

	 	    String[] searchKeywords = {"20676", "TESTAUTO2", "Test Automation 2", "Branch Punjab", "Summon", "RCP25-11620" , "NoticeNumber2", "27-Apr-2025", "26-Apr-2025","Highly Critical","Pending Assignment","26-Apr-2025"};

	 	    for (String keyword : searchKeywords) {
	 	    	
	 	    	CoordinatorLocator.SearchBox().clear();
		 	    CoordinatorLocator.SearchBox().sendKeys(keyword, Keys.ENTER);
		 	    
	 	        Thread.sleep(4000);

	 	        try {
	 	            // 1. Find the cell which contains the keyword
	 	            WebElement cell = getDriver().findElement(By.xpath("//div[@title='" + keyword + "']"));
	 	            
	 	            // 2. Find the column index
	 	            WebElement row = cell.findElement(By.xpath("./ancestor::tr")); // find parent row
	 	            List<WebElement> allCells = row.findElements(By.xpath("./td"));
	 	            
	 	            int columnIndex = -1;
	 	            for (int i = 0; i < allCells.size(); i++) {
	 	                if (allCells.get(i).getText().trim().equals(keyword)) {
	 	                    columnIndex = i + 1; // XPath index starts from 1
	 	                    break;
	 	                }
	 	            }
	 	            
	 	            String columnName = "Unknown Column";

	 	            // 3. Now fetch the column name from header
	 	            if (columnIndex != -1) {
	 	                WebElement header = getDriver().findElement(By.xpath("//table/thead/tr/th[" + columnIndex + "]"));
	 	                columnName = header.getText();
	 	            }

	 	            // 4. Now finally log
	 	            test.log(LogStatus.PASS, "Searched and found record under '" + columnName + "' column: " + keyword);

	 	        } catch (Exception e) {
	 	            test.log(LogStatus.INFO, "No record available for search keyword: " + keyword);
	 	        }

	 	        Thread.sleep(3000);
	 	        All_ClientPortal_Locators.Clear().click();
	 	        Thread.sleep(2000);
	 	    }

	 	} catch (Exception e) {
	 	    e.printStackTrace();
	 	    test.log(LogStatus.FAIL, "Exception occurred during multiple searches");
	 	}

	 	
	*/ 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
/*	 	
	 	try {
	 	    Thread.sleep(5000);

	 	    // Multiple search keywords
	 	    String[] searchKeywords = {"TESTAUTO2", "Test Automation 2", "Branch Punjab", "Summon"};

	 	    for (String keyword : searchKeywords) {
	 	        // Search the keyword
	 	    	CoordinatorLocator.SearchBox().clear();
	 	       CoordinatorLocator.SearchBox().sendKeys(keyword, Keys.ENTER);
	 	        Thread.sleep(4000);

	 	        try {
	 	            String text = getDriver().findElement(By.xpath("//div[@title='" + keyword + "']")).getText();
	 	            test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
	 	            test.log(LogStatus.PASS, "Compliance ID selected: " + text);
	 	        } catch (Exception e) {
	 	            test.log(LogStatus.PASS, "No record available for search keyword: " + keyword);
	 	        }

	 	        // Click on Clear button
	 	        Thread.sleep(3000);
	 	        All_ClientPortal_Locators.Clear().click();
	 	        Thread.sleep(2000);
	 	    }

	 	} catch (Exception e) {
	 	    e.printStackTrace();
	 	    test.log(LogStatus.FAIL, "Exception occurred during multiple searches");
	 	}

	*/ 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
/*
	 	List<String> li=new ArrayList<String>();
	     
	    
	     li.add("QWW");

	     
	 	List<String> filter=new ArrayList<String>();	
	 	
	 	filter.add("QWW");	
	 	
	 	
	 	js.executeScript("window.scrollBy(0,150)");	
	 	Thread.sleep(3000);

	 	 CoordinatorLocator.readTotalItems().click();				//Clicking on Text of total items just to scroll down.
	 	String s = CoordinatorLocator.readTotalItems().getText();
	 	Thread.sleep(2000);

	 	try
	 	{
		 	Thread.sleep(5000);
	
		 	List<WebElement> typecol=getDriver().findElements(By.xpath("//*[@class='k-grid-aria-root']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[3]"));
		 	Thread.sleep(2000);
	
		 	for(int i=0; i<li.size(); i++){
	 		
	 		List<String> text= new ArrayList<String>();
	 		HashSet<String> pass=new LinkedHashSet<>();
	 		HashSet<String> fail=new LinkedHashSet<>();
	 		List<WebElement> raw=new ArrayList<WebElement>();


	 	 if(i==0)
	 			{
	 				raw.addAll(typecol);
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
	 	
	 	if(CoordinatorLocator.ClearBtn().isEnabled())
	 	{
	 		CoordinatorLocator.ClearBtn().click();
	 		test.log(LogStatus.PASS, "Clear button working successfully.");
	 		
	 	}
	 	else
	 	{
	 		test.log(LogStatus.PASS, "Clear button not working successfully.");
	 		
	 	}
	 	
	 	}
	 	}
	 	catch (Exception e) 
	 	{
	 		test.log(LogStatus.PASS,"No records available.");
		}
	 	
	 	
	 	*/
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 }
	 public static void NoticeEditDownload(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
	 	
	 	
	 	JavascriptExecutor js = (JavascriptExecutor) getDriver();	
	 	Thread.sleep(2000);
	 	File dir3 = new File("C:\\Users\\bilali\\Downloads");
	 	File[] dirContents1 = dir3.listFiles();							//Counting number of files in directory before download 

	 	
	 	Thread.sleep(5000);

	 	CoordinatorLocator.clickDownload().click();
	 	
	 
	 	
//		WebDriverWait wait=new WebDriverWait(getDriver(), 20); //me hide that
		
		Thread.sleep(10000);
//		wait.until(ExpectedConditions.invisibilityOf(CoordinatorLocator.GridLoad()));
	 	
	 	Thread.sleep(5500);
	 	File dir2= new File("C:\\Users\\bilali\\Downloads");
	 	File[] allFilesNew1 = dir2.listFiles();							//Counting number of files in directory after download

	 	if(dirContents1.length < allFilesNew1.length)
	 	{
	 	
	 		Thread.sleep(9000);					//Clicking on 'Excel Report' image.
	 		test.log(LogStatus.PASS, "Notice Document downloaded successfully.");
	 	}
	 	else
	 	{
	 		test.log(LogStatus.FAIL, "Notice Document doesn't downloaded successfully.");
	 	}
	 	
	 	
	 	
	 	Thread.sleep(10000);
	 	if(CoordinatorLocator.EditBtn().isEnabled())
	 	{
	 		Thread.sleep(1000);
	 		CoordinatorLocator.EditBtn().click();
	 		test.log(LogStatus.PASS, "Edit button is clickable.");
	 		
	 	}
	 	else
	 	{
	 		test.log(LogStatus.PASS, "Edit button is not clickable.");
	 		
	 	}
//	 	Thread.sleep(1000);
//	 	Locator.clickBack().click();
	 	
	 	Thread.sleep(1000);
	 	Actions action = new Actions(getDriver());
	 	WebElement we = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
	 	action.moveToElement(we).click().build().perform();
	 	
	 }
	 
	 public static void NoticeEditBasicSave(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
			WebDriverWait wait = new WebDriverWait(getDriver(), 140);

			Thread.sleep(5000);
			CoordinatorLocator.SearchBox().sendKeys("Pending Assignment", Keys.ENTER);
			Thread.sleep(5000);
			CoordinatorLocator.EditBtn().click();
			Thread.sleep(5000);

			CoordinatorLocator.EnterRemarksfield().sendKeys(getRandomString());
			Thread.sleep(5000);
			CoordinatorLocator.EditBasicInfoSave().click();


			Thread.sleep(4000);
			By locator = By.xpath("//h4[@class='f-label']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();

			if (text.equalsIgnoreCase("Notice Saved Successfully")) {
				Thread.sleep(5000);

				test.log(LogStatus.PASS, "Message Displayed : " + text);
			} else {
				Thread.sleep(5000);

				test.log(LogStatus.FAIL, "Message Displayed : " + text);
			}

		}
	 
	 public static void NoticeEditSaveWithoutAssign(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
			WebDriverWait wait = new WebDriverWait(getDriver(), 140);

			Thread.sleep(5000);
			CoordinatorLocator.SearchBox().sendKeys("Pending Assignment", Keys.ENTER);
			Thread.sleep(5000);
			CoordinatorLocator.EditBtn().click();
			Thread.sleep(5000);


			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,1000)");
			WebElement element = getDriver().findElement(By.xpath("(//button[normalize-space()='Save'])[2]"));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(4000);
			
			
//			CoordinatorLocator.EditBasicInfoSave().click();
			
			//It will click 2nd Save button
			CoordinatorLocator.clickSave().click();


			Thread.sleep(4000);
			By locator = By.xpath("//h4[@class='f-label']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();

			if (text.equalsIgnoreCase("Notice Not saved succesfully")) {
				Thread.sleep(5000);

				test.log(LogStatus.PASS, "Message Displayed : " + text);
			} else {
				Thread.sleep(5000);

				test.log(LogStatus.FAIL, "Message Displayed : " + text);
			}

		}
	 
	 public static void NoticeEditSaveAssignUser(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
			WebDriverWait wait = new WebDriverWait(getDriver(), 140);

			Thread.sleep(5000);
			CoordinatorLocator.SearchBox().sendKeys("Pending Assignment", Keys.ENTER);
			Thread.sleep(5000);
			CoordinatorLocator.EditBtn().click();
			Thread.sleep(5000);


			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,1000)");
			WebElement element = getDriver().findElement(By.xpath("(//button[normalize-space()='Save'])[2]"));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(4000);
			
			CoordinatorLocator.TranslationReqYes().click();
			Thread.sleep(4000);
			CoordinatorLocator.clickSMETeam().click();
			Thread.sleep(4000);
			CoordinatorLocator.SelectSMETeamMohit().click();
			Thread.sleep(4000);
			
			
			CoordinatorLocator.clickSDExecutorTeam().click();
			Thread.sleep(4000);
			CoordinatorLocator.SelectSDExecutorRitwik().click();
			Thread.sleep(4000);
			
			//It will click 2nd Save button
			CoordinatorLocator.clickSave().click();


			Thread.sleep(4000);
			By locator = By.xpath("//h4[@class='f-label']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(5000);
			String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();

			if (text.equalsIgnoreCase("Notice saved succesfully")) {
				Thread.sleep(5000);
				test.log(LogStatus.PASS, "Translation Required Checkbox selected Yes");
				test.log(LogStatus.PASS, "SME Team dropdown is selected");
				test.log(LogStatus.PASS, "SD Executer Team dropdown is selected");
				test.log(LogStatus.PASS, "Message Displayed : " + text);
			} else {
				Thread.sleep(5000);

				test.log(LogStatus.FAIL, "Message Displayed : " + text);
			}

		}
	 
	 public static void NoticeEditAllTabsCheck(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
			WebDriverWait wait = new WebDriverWait(getDriver(), 140);

			Thread.sleep(5000);
			CoordinatorLocator.SearchBox().sendKeys("Pending Assignment", Keys.ENTER);
			Thread.sleep(5000);
			CoordinatorLocator.EditBtn().click();
			Thread.sleep(5000);
			
			
			
			String BasicInfo = getDriver().findElement(By.xpath("//a[normalize-space()='Notice Details']")).getText();
			if(BasicInfo.equals("Notice Details"))
			{
				test.log(LogStatus.PASS,  "Edit Button clicked successfully"); 
				test.log(LogStatus.PASS,  "Notice Details Tab is displayed"); 
			}
			else 
			{
				test.log(LogStatus.FAIL,  "Notice Details Tab is not displayed"); 
			}
			
			
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//a[normalize-space()='SME Response']")).click();
			String TransReq = getDriver().findElement(By.xpath("//span[normalize-space()='Translation Required']")).getText();

			if(TransReq.equals("Translation Required"))
			{
				test.log(LogStatus.PASS,  "SME Response Tab is displayed"); 
			}
			else 
			{
				test.log(LogStatus.FAIL,  "SME Response Tab is not displayed"); 
			}
			
			
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//a[normalize-space()='SD Executer']")).click();
			//Me get text is not added due to in both tab same get.text is there
			if(TransReq.equals("Translation Required"))
			{
				test.log(LogStatus.PASS,  "SD Executor Tab is displayed"); 
			}
			else 
			{
				test.log(LogStatus.FAIL,  "SD Executor Tab is not displayed"); 
			}
			
			
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();
			String DocRepo = getDriver().findElement(By.xpath("//span[normalize-space()='Document Repository']")).getText();
			if(DocRepo.equals("Document Repository"))
			{
				test.log(LogStatus.PASS,  "Document Section Tab is displayed"); 
			}
			else 
			{
				test.log(LogStatus.FAIL,  "Document Section Tab is not displayed"); 
			}


		}
	 
	 public static void NoticeEditDocumentRepositoryDownloadCheck(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
			WebDriverWait wait = new WebDriverWait(getDriver(), 140);

			Thread.sleep(5000);
			
			
			CoordinatorLocator.SearchBox().sendKeys("NoticeNumber2", Keys.ENTER);
			Thread.sleep(5000);
			CoordinatorLocator.EditBtn().click();
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();


			// + Document Repository label bar
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn'])[1]")).click();
			
			// 1 Logic for Notice Document
			Thread.sleep(3000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			All_ClientPortal_Locators.NoticeDocumentDownload().click();

			Thread.sleep(8000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				Thread.sleep(5000);
				test.log(LogStatus.PASS, " Notice Number Search : NoticeNumber2");
				test.log(LogStatus.PASS, " Notice Edit button work successfully");
				test.log(LogStatus.PASS, " Notice Document File downloaded successfully.");
			} else {
				Thread.sleep(5000);
				test.log(LogStatus.FAIL, " Notice Document File is not downloaded");
			}

			// 2 - Logic for Translated Notice Document
			Thread.sleep(5000);
			File dir2 = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents2 = dir2.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			All_ClientPortal_Locators.NoticeTranslatedDocument().click();

			Thread.sleep(8000);
			File dirr = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew2 = dirr.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents2.length < allFilesNew2.length) {
				Thread.sleep(5000);
				test.log(LogStatus.PASS, " Notice Translated Document File downloaded successfully.");
			} else {
				Thread.sleep(5000);
				test.log(LogStatus.FAIL, " Notice Translated Document File is not downloaded.");
			}

			//3 Logic for Extention Application Acknowledgement
			Thread.sleep(8000);
			File dir3 = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents3 = dir3.listFiles(); // Counting number of files in directory before download

			Thread.sleep(2200);
			All_ClientPortal_Locators.NoticeApplicationAcknowledgeDocument().click();

			Thread.sleep(10000);
			File dirrr = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew3 = dirrr.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents3.length < allFilesNew3.length) {
				Thread.sleep(5000);
				test.log(LogStatus.PASS, " Notice Extension Application Acknowledgement File is downloaded successfully");
			} else {
				Thread.sleep(5000);
				test.log(LogStatus.FAIL, " Notice Extension Application Acknowledgement File is not downloaded.");
			}

			//4 Logic for Draft Extension Application
			Thread.sleep(10000);
			File dir4 = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents4 = dir4.listFiles(); // Counting number of files in directory before download

			Thread.sleep(4000);
			All_ClientPortal_Locators.DraftExtensionApplicationDocument().click();

			Thread.sleep(10000);
			File dirrr4 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew4 = dirrr4.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents4.length < allFilesNew4.length) {
				Thread.sleep(5000);
				test.log(LogStatus.PASS, " Notice Draft Extension Application File downloaded successfully.");
			} else {
				Thread.sleep(5000);
				test.log(LogStatus.FAIL, " Notice Draft Extension Application File is not downloaded.");
			}

			//5 Logic for Draft Response (Prepared by SME)
			Thread.sleep(10000);
			File dir5 = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents5 = dir5.listFiles(); // Counting number of files in directory before download

			Thread.sleep(4000);
			All_ClientPortal_Locators.DraftResponseSMEDocument().click();

			Thread.sleep(10000);
			File dirrr5 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew5 = dirrr5.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents5.length < allFilesNew5.length) {
				Thread.sleep(5000);
				test.log(LogStatus.PASS, " Notice Response Prepared by SME File is downloaded successfully.");
			} else {
				Thread.sleep(5000);
				test.log(LogStatus.FAIL, " Notice Draft Extension Application File is not downloaded.");
			}



		}
	 public static void NoticeDocMandatory(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
	 	
	 	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	 	
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickaddnewNotices().click();
	 	
	 	Thread.sleep(1000);
	 	CoordinatorLocator.clickSaveNotice().click();
	 	
	 	 Thread.sleep(1000);
	 		String msg=CoordinatorLocator.clickNoticeDocMsg().getText();
	 		if(msg.equalsIgnoreCase("File is required."))
	 		{
	 			test.log(LogStatus.PASS,"Message displayed:-" +msg);
	 		}
	 		else
	 		{
	 			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
	 		}
	 		 Thread.sleep(1000);
	 			CoordinatorLocator.clickBack().click();
	 	
	 }
	 
	 public static void RegistrationCountMatch( ExtentTest test,String Notice) throws InterruptedException, IOException
		{
		 
		 Thread.sleep(6000);
		CoordinatorLocator.clickRegistration().click();
		Thread.sleep(10000);
		int pendingAssignment = 0;
		Thread.sleep(6000);
		if(Notice.equalsIgnoreCase("Pending Assignment"))
		{
			Thread.sleep(6000);
			String string_pendingAssignment = CoordinatorLocator.RegistartionpendingAssignmentCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(6000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(6000);
			CoordinatorLocator.RegistartionpendingAssignmentCount().click();
			Thread.sleep(6000);
		}
		else if(Notice.equalsIgnoreCase("Pending Action"))
		{
			Thread.sleep(6000);
			String string_pendingAssignment = CoordinatorLocator.RegistartionpendingActionCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(6000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(6000);
			CoordinatorLocator.RegistartionpendingActionCount().click();
			Thread.sleep(6000);
		}
		else if(Notice.equalsIgnoreCase("Overdue"))
		{
			Thread.sleep(6000);
			String string_pendingAssignment = CoordinatorLocator.RegistartionOverdueCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(6000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(6000);
			CoordinatorLocator.RegistartionOverdueCount().click();
			Thread.sleep(6000);
			
		}
		else if(Notice.equalsIgnoreCase("Closed"))
		{
			Thread.sleep(6000);
			String string_pendingAssignment = CoordinatorLocator.RegistartionClosedCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(6000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(6000);
			CoordinatorLocator.RegistartionClosedCount().click();
			Thread.sleep(6000);
		}
		
		
		Thread.sleep(6000);
//		CoordinatorLocator.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = CoordinatorLocator.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String pendingAssignmentcount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count = Integer.parseInt(pendingAssignmentcount);
		
		
		
		if(pendingAssignment==count)
		{
		
			test.log(LogStatus.PASS, Notice+":- box count = "+pendingAssignment+ " | " +Notice+ ":- box  grid Count = "+count);
		}
		else
		{
			test.log(LogStatus.FAIL, Notice+":- box count= "+pendingAssignment+ " | " +Notice+ ":-box  grid Count = "+count);
		}
		
	}
	 
	 public static void AddNewLicense( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		{
		
			
			
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			Thread.sleep(5000);
			CoordinatorLocator.clickAddNew().click();
			
			Thread.sleep(1000);
		 	CoordinatorLocator.clickEntityRehistrationDropdown().click();
		 	Thread.sleep(1000);
		 	CoordinatorLocator.selectEntity().click();
			
			FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook1 = WorkbookFactory.create(fis);
	        Sheet sheet = workbook1.getSheetAt(3);
			
			Thread.sleep(1000);
//			Row row = sheet.getRow(4);						//Selected 0th index row (First row)
//			Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
//			String state = c.getStringCellValue();
			CoordinatorLocator.clickStateRegistrationDropdown().click();
			Thread.sleep(1000);
			CoordinatorLocator.selectState1().click();
			
			
			Thread.sleep(1000);
			Row row1 = sheet.getRow(8);						//Selected 0th index row (First row)
			Cell c1= row1.getCell(1);						//Selected cell (0 row,1 column)
			String location = c1.getStringCellValue();
			CoordinatorLocator.clickLocation().sendKeys(location);
			
			Thread.sleep(1000);
			Row row2 = sheet.getRow(9);						//Selected 0th index row (First row)
			Cell c2= row2.getCell(1);						//Selected cell (0 row,1 column)
			String branch = c2.getStringCellValue();
			CoordinatorLocator.clickBranch().sendKeys(branch);
			
			CoordinatorLocator.clickLicenseType().click();
			CoordinatorLocator.selectLicenseType().click();
			
			Thread.sleep(1000);
			Row row3 = sheet.getRow(10);						//Selected 0th index row (First row)
			Cell c3= row3.getCell(1);						//Selected cell (0 row,1 column)
			String empname = c3.getStringCellValue();
			CoordinatorLocator.clickEmpName().sendKeys(empname);
			

			Thread.sleep(1000);
			Row row4 = sheet.getRow(12);						//Selected 0th index row (First row)
			Cell c4= row4.getCell(1);						//Selected cell (0 row,1 column)
			String empAddress = c4.getStringCellValue();
			CoordinatorLocator.clickEmpAddress().sendKeys(empAddress);
			
			Thread.sleep(1000);
			Row row5 = sheet.getRow(11);						//Selected 0th index row (First row)
			Cell c5= row5.getCell(1);						//Selected cell (0 row,1 column)
			String EmpMailId = c5.getStringCellValue();
			CoordinatorLocator.clickEmpMailId().sendKeys(EmpMailId);
			
			Thread.sleep(1000);
			Row row6 = sheet.getRow(13);						//Selected 0th index row (First row)
			Cell c6= row6.getCell(1);						//Selected cell (0 row,1 column)
			int empContact = (int) c6.getNumericCellValue();
			CoordinatorLocator.clickEmpContact().sendKeys(empContact+"");
		
			
			Thread.sleep(1000);
			Row row7 = sheet.getRow(14);						//Selected 0th index row (First row)
			Cell c7= row7.getCell(1);						//Selected cell (0 row,1 column)
			int mailcount = (int) c7.getNumericCellValue();
			CoordinatorLocator.clickMaleCount().sendKeys(mailcount+"");
			
			Thread.sleep(1000);
			Row row8 = sheet.getRow(15);						//Selected 0th index row (First row)
			Cell c8= row8.getCell(1);						//Selected cell (0 row,1 column)
			int FemaleCount = (int) c8.getNumericCellValue();
			CoordinatorLocator.clickFemaleCount().sendKeys(FemaleCount+"");

		
			Thread.sleep(1000);
			Row row9 = sheet.getRow(16);						//Selected 0th index row (First row)
			Cell c9= row9.getCell(1);						//Selected cell (0 row,1 column)
			String mailid = c9.getStringCellValue();
			CoordinatorLocator.clickManagerMailId().sendKeys(mailid);
			
			Thread.sleep(1000);
			Row row10 = sheet.getRow(17);						//Selected 0th index row (First row)
			Cell c10= row10.getCell(1);						//Selected cell (0 row,1 column)
			int contactNo = (int) c10.getNumericCellValue();
			CoordinatorLocator.clickContactNo().sendKeys(contactNo+"");
			
			Thread.sleep(1000);
			Row row11 = sheet.getRow(18);						//Selected 0th index row (First row)
			Cell c11= row11.getCell(1);						//Selected cell (0 row,1 column)
			String address = c11.getStringCellValue();
			CoordinatorLocator.clickAddress().sendKeys(address);

			Thread.sleep(1000);
			CoordinatorLocator.clickSubmit().click();
			
			String msg=CoordinatorLocator.clickSuccessMsg().getText();
			if(msg.equalsIgnoreCase("Registration saved successfully"))
			{
				test.log(LogStatus.PASS, "Registration is added for RCP Team login");
				Thread.sleep(1160);
				test.log(LogStatus.PASS, "Message displayed:-"+msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed:-"+msg);
			}
			Thread.sleep(1000);
			CoordinatorLocator.clickOkBtn().click();
//			Thread.sleep(1000);
//			Locator.clickBack().click();
		}
	 
	 
	 public static void AddNewLicenseForSDExecutor( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		{
		
			
			
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			Thread.sleep(1000);
			CoordinatorLocator.clickAddNew().click();
			
			Thread.sleep(1000);
		 	CoordinatorLocator.clickEntity().click();
		 	Thread.sleep(1000);
		 	CoordinatorLocator.selectEntity().click();
			
			FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook1 = WorkbookFactory.create(fis);
	        Sheet sheet = workbook1.getSheetAt(3);
			
			Thread.sleep(1000);
//			Row row = sheet.getRow(4);						//Selected 0th index row (First row)
//			Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
//			String state = c.getStringCellValue();
			CoordinatorLocator.clickState().click();
			Thread.sleep(1000);
			CoordinatorLocator.selectStateAndraPardesh().click();
			
			
			Thread.sleep(1000);
			Row row1 = sheet.getRow(8);						//Selected 0th index row (First row)
			Cell c1= row1.getCell(1);						//Selected cell (0 row,1 column)
			String location = c1.getStringCellValue();
			CoordinatorLocator.clickLocation().sendKeys(location);
			
			Thread.sleep(1000);
			Row row2 = sheet.getRow(9);						//Selected 0th index row (First row)
			Cell c2= row2.getCell(1);						//Selected cell (0 row,1 column)
			String branch = c2.getStringCellValue();
			CoordinatorLocator.clickBranch().sendKeys(branch);
			
			CoordinatorLocator.clickLicenseType().click();
			Thread.sleep(3000);
			CoordinatorLocator.selectLicenseTypeFSSAI().click();
			
			Thread.sleep(1000);
			Row row3 = sheet.getRow(10);						//Selected 0th index row (First row)
			Cell c3= row3.getCell(1);						//Selected cell (0 row,1 column)
			String empname = c3.getStringCellValue();
			CoordinatorLocator.clickEmpName().sendKeys(empname);
			

			Thread.sleep(1000);
			Row row4 = sheet.getRow(12);						//Selected 0th index row (First row)
			Cell c4= row4.getCell(1);						//Selected cell (0 row,1 column)
			String empAddress = c4.getStringCellValue();
			CoordinatorLocator.clickEmpAddress().sendKeys(empAddress);
			
			Thread.sleep(1000);
			Row row5 = sheet.getRow(11);						//Selected 0th index row (First row)
			Cell c5= row5.getCell(1);						//Selected cell (0 row,1 column)
			String EmpMailId = c5.getStringCellValue();
			CoordinatorLocator.clickEmpMailId().sendKeys(EmpMailId);
			
			Thread.sleep(1000);
			Row row6 = sheet.getRow(13);						//Selected 0th index row (First row)
			Cell c6= row6.getCell(1);						//Selected cell (0 row,1 column)
			int empContact = (int) c6.getNumericCellValue();
			CoordinatorLocator.clickEmpContact().sendKeys(empContact+"");
		
			
			Thread.sleep(1000);
			Row row7 = sheet.getRow(14);						//Selected 0th index row (First row)
			Cell c7= row7.getCell(1);						//Selected cell (0 row,1 column)
			int mailcount = (int) c7.getNumericCellValue();
			CoordinatorLocator.clickMaleCount().sendKeys(mailcount+"");
			
			Thread.sleep(1000);
			Row row8 = sheet.getRow(15);						//Selected 0th index row (First row)
			Cell c8= row8.getCell(1);						//Selected cell (0 row,1 column)
			int FemaleCount = (int) c8.getNumericCellValue();
			CoordinatorLocator.clickFemaleCount().sendKeys(FemaleCount+"");

		
			Thread.sleep(1000);
			Row row9 = sheet.getRow(16);						//Selected 0th index row (First row)
			Cell c9= row9.getCell(1);						//Selected cell (0 row,1 column)
			String mailid = c9.getStringCellValue();
			CoordinatorLocator.clickManagerMailId().sendKeys(mailid);
			
			Thread.sleep(1000);
			Row row10 = sheet.getRow(17);						//Selected 0th index row (First row)
			Cell c10= row10.getCell(1);						//Selected cell (0 row,1 column)
			int contactNo = (int) c10.getNumericCellValue();
			CoordinatorLocator.clickContactNo().sendKeys(contactNo+"");
			
			Thread.sleep(1000);
			Row row11 = sheet.getRow(18);						//Selected 0th index row (First row)
			Cell c11= row11.getCell(1);						//Selected cell (0 row,1 column)
			String address = c11.getStringCellValue();
			CoordinatorLocator.clickAddress().sendKeys(address);

			Thread.sleep(1000);
			CoordinatorLocator.clickSubmit().click();
			
			String msg=CoordinatorLocator.clickSuccessMsg().getText();
			if(msg.equalsIgnoreCase("Registration saved successfully"))
			{
				test.log(LogStatus.PASS, "Registration is added for SD Executor Team login");
				Thread.sleep(1100);
				test.log(LogStatus.PASS, "Message displayed:-"+msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed:-"+msg);
			}
			Thread.sleep(1000);
			CoordinatorLocator.clickOkBtn().click();
//			Thread.sleep(1000);
//			Locator.clickBack().click();
		}
	 
	 public static void ExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		{
			
		
			Thread.sleep(4000);
			CoordinatorLocator.clickRegistration().click();
			
			 Thread.sleep(5000); 		
				JavascriptExecutor js = (JavascriptExecutor) getDriver();
				js.executeScript("window.scrollBy(0,5000)");
				
//		        CoordinatorLocator.readTotalItems().click();
				String item = CoordinatorLocator.readTotalItems().getText();
				String[] bits = item.split(" ");								//Splitting the String
				String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				int count1 = Integer.parseInt(compliancesCount);
			
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					Thread.sleep(5000);
				   item = CoordinatorLocator.readTotalItems().getText();
					bits = item.split(" ");
		        
				}
				
				Thread.sleep(2000);
		        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		        
		        js1.executeScript("window.scrollBy(0,-500)");
			Thread.sleep(1000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(5000);
			CoordinatorLocator.clickExport().click();
			
		
			Thread.sleep(10000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
			if(dirContents.length < allFilesNew.length)
			{
			
				Thread.sleep(3000);					//Clicking on 'Excel Report' image.
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
				Thread.sleep(1000);		
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
		
			
			}
	 public static void SearchBox(ExtentTest test) throws InterruptedException
		{
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			
				Thread.sleep(3000);
				CoordinatorLocator.SearchBox().sendKeys("TESTAUTO2",Keys.ENTER);
			
				List<String> li=new ArrayList<String>();
		        
		       
		        li.add("TESTAUTO2");
	       
		        
				List<String> filter=new ArrayList<String>();	
				
				filter.add("TESTAUTO2");	
				
				
				js.executeScript("window.scrollBy(0,150)");	
				Thread.sleep(3000);

//				 CoordinatorLocator.readTotalItems().click();				//Clicking on Text of total items just to scroll down.
				String s = CoordinatorLocator.readTotalItems().getText();
				Thread.sleep(2000);

				if(!s.equalsIgnoreCase("No items to display")) {
				Thread.sleep(5000);
		
				List<WebElement> typecol=getDriver().findElements(By.xpath("//*[@id=\"k-14dcbc10-aef9-4d0d-8606-3f3e7dfcfd8f\"]/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[1]/div"));
				Thread.sleep(2000);

				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement> raw=new ArrayList<WebElement>();


				 if(i==0)
						{
							raw.addAll(typecol);
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
				
				if(CoordinatorLocator.ClearBtn().isEnabled())
				{
					CoordinatorLocator.ClearBtn().click();
					test.log(LogStatus.PASS, "Clear button working successfully.");
					
				}
				else
				{
					test.log(LogStatus.PASS, "Clear button not working successfully.");
					
				}
				
				}
				}
				else
				{
					test.log(LogStatus.PASS,"No records found");	
				}
			}
	 
	 public static void EditIcon(ExtentTest test) throws InterruptedException
		{
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			
			Thread.sleep(1000);
			if(CoordinatorLocator.EditBtn().isEnabled())
			{
				CoordinatorLocator.EditBtn().click();
				test.log(LogStatus.PASS, "Edit button is clickable.");
				
			}
			else
			{
				test.log(LogStatus.PASS, "Edit button is not clickable.");
				
			}
			Thread.sleep(1000);
			CoordinatorLocator.clickBack().click();
		}
	 
	 public static void EditIconMiniTabsLicense(ExtentTest test) throws InterruptedException
		{
		 WebDriverWait wait = new WebDriverWait(getDriver(), 140);
		 
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			Thread.sleep(1000);
			CoordinatorLocator.EditBtn().click();
			
			
			Thread.sleep(5000);

//			WebElement plus1 = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn ng-star-inserted'])[1]"));
//			WebElement plus2 = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn ng-star-inserted'])[2]"));
//			WebElement plus3 = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn ng-star-inserted'])[3]"));
//			WebElement plus4 = getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn ng-star-inserted'])[4]"));
			
			
//			WebElement ActivityClosure = getDriver().findElement(By.xpath("//img[@class='svg-icon-btn ng-star-inserted']"));
			Thread.sleep(4000);
			
//			clickElementUsingJS(CoordinatorLocator.plus1());
			
			Thread.sleep(4000);
			if(CoordinatorLocator.plus1().isEnabled())
			{
				CoordinatorLocator.plus1().click();
				test.log(LogStatus.PASS, "+ Basic Information button is Opened and Closed.");
			}
			else
			{
				test.log(LogStatus.FAIL, "+ Basic Information button is not clickable.");
			}
			

			
			Thread.sleep(4000);
			if(CoordinatorLocator.plus2().isEnabled())
			{
				CoordinatorLocator.plus2().click();
				test.log(LogStatus.PASS, "+ Finance Approval Status button is Opened and Closed.");
			}
			else
			{
				test.log(LogStatus.FAIL, "+ Finance Approval Status button is not clickable.");
			}
			
			Thread.sleep(4000);
			if(CoordinatorLocator.plus3().isEnabled())
			{
				CoordinatorLocator.plus3().click();
				test.log(LogStatus.PASS, "+ OT Assignment button is Opened and Closed.");
			}
			else
			{
				test.log(LogStatus.FAIL, "+ OT Assignment button is not clickable.");
			}
			
			Thread.sleep(4000);
			if(CoordinatorLocator.plus4().isEnabled())
			{
				CoordinatorLocator.plus4().click();
				test.log(LogStatus.PASS, "+ Activity Relevant Dates button is Opened and Closed.");
				Thread.sleep(4000);
			}
			else
			{
				test.log(LogStatus.FAIL, "+ Activity Relevant Dates button is not clickable.");
			}
			
		}
	 
	 public static void EditIconBasicInfoSave(ExtentTest test) throws InterruptedException
		{
		 WebDriverWait wait = new WebDriverWait(getDriver(), 140);
		 
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			Thread.sleep(1000);
			
			CoordinatorLocator.SearchBox().sendKeys("Requested",Keys.ENTER);
			Thread.sleep(3000);
			CoordinatorLocator.EditBtn().click();
			
			CoordinatorLocator.plus1().click();
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
			
			
			
			Thread.sleep(4000);
			By locator = By.xpath("//h4[@class='f-label']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();

			if (text.equalsIgnoreCase("Info updated successfully")) {
				Thread.sleep(5000);
				
				test.log(LogStatus.PASS, "Basic Information Save button working fine");
				test.log(LogStatus.PASS, "Message Displayed : " + text);
			} else {
				Thread.sleep(5000);

				test.log(LogStatus.FAIL, "Message Displayed : " + text);
			}
				
		}
	 
	 public static void EditIconFinanceApprovalSave(ExtentTest test) throws InterruptedException
		{
		 WebDriverWait wait = new WebDriverWait(getDriver(), 140);
		 
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			Thread.sleep(1000);
			getDriver().navigate().refresh();
			Thread.sleep(2000);
			CoordinatorLocator.SearchBox().sendKeys("Requested",Keys.ENTER);
			Thread.sleep(3000);
			CoordinatorLocator.EditBtn().click();
			
			CoordinatorLocator.plus2().click();
			Thread.sleep(3000);
			//Clicking on Approval tab
			getDriver().findElement(By.xpath("(//input[@id='rdGen'])[1]")).click();
			Thread.sleep(5000);
			
			//Input Remaks
			getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys(getRandomString());
			Thread.sleep(3000);
			getDriver().findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
			
			
			
			Thread.sleep(4000);
			By locator = By.xpath("//h4[@class='f-label']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();

			if (text.equalsIgnoreCase("Finance approval updated successfully")) {
				Thread.sleep(5000);
				test.log(LogStatus.PASS, "Finance Approval Status tab is opened");
				Thread.sleep(2100);
				test.log(LogStatus.PASS, "Finaince Approval checkbox is selected");
				Thread.sleep(501);
				test.log(LogStatus.PASS, "Finaince Approval is done successfully");
				Thread.sleep(177);
				test.log(LogStatus.PASS, "Finaince Approval Save button is working fine");
				Thread.sleep(50);
				test.log(LogStatus.PASS, "Finaince Approval Message Displayed : " + text);
			} else {
				Thread.sleep(5000);

				test.log(LogStatus.FAIL, "Message Displayed : " + text);
			}
			
			
			
			
			
			//OT Assignment
			
			Thread.sleep(10000);
			WebElement clickOnOK = getDriver().findElement(By.xpath("//button[@class='figma-btn-green']"));
			
			if(clickOnOK.isDisplayed())
			{
				clickOnOK.click();
			}
			
			
			
			CoordinatorLocator.plus3().click();
			Thread.sleep(3000);

//			CoordinatorLocator.clickonRCPDropdown().click();
			Thread.sleep(4000);
//			CoordinatorLocator.selectonRCPDropdownuser().click();
			
			
			
			
			try {
			    WebElement rcpDropdown = CoordinatorLocator.clickonRCPDropdown();
			    if (rcpDropdown.isDisplayed() && rcpDropdown.isEnabled()) {
			        rcpDropdown.click();
			        Thread.sleep(4000);
			        CoordinatorLocator.selectonRCPDropdownuser().click();
			    } else {
			        System.out.println("RCP Dropdown is not enabled/displayed.");
			    }
			} catch (Exception e) {
			    System.out.println("RCP Dropdown not found or not interactable: " + e.getMessage());
			}

			try {
			    WebElement sdDropdown = CoordinatorLocator.clickonSDExeDropdown();
			    if (sdDropdown.isDisplayed() && sdDropdown.isEnabled()) {
			        sdDropdown.click();
			        Thread.sleep(4000);
			        CoordinatorLocator.selectonSDExDropdownRITWIK().click();
			    } else {
			        System.out.println("SD Executor Dropdown is not enabled/displayed.");
			    }
			} catch (Exception e) {
			    System.out.println("SD Dropdown not found or not interactable: " + e.getMessage());
			}

			

			
			//it will click if dropdown is open and enabled only
//			safeClickDropdown(CoordinatorLocator.clickonRCPDropdown(), CoordinatorLocator.selectonRCPDropdownuser());
			
//			safeClickDropdown(CoordinatorLocator.clickonSDExeDropdown(), CoordinatorLocator.selectonSDExDropdownRITWIK());
			
			
			
			
			getDriver().findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();			
			
			
			Thread.sleep(4000);
			By locator2 = By.xpath("//h4[@class='f-label']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator2));
			Thread.sleep(4000);
			String text2 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();

			if (text2.equalsIgnoreCase("OT assigned successfully")) {
				Thread.sleep(5000);
				
				test.log(LogStatus.PASS, "OT Assignment tab is opened");
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "User is selected successfully");
				Thread.sleep(1000);
				Thread.sleep(1000);
				test.log(LogStatus.PASS, "OT Assignment Save button is working fine");
				test.log(LogStatus.PASS, "OT Assignment Message Displayed : " + text2);
			} else {
				Thread.sleep(5000);

				test.log(LogStatus.FAIL, "OT Assignment Message Displayed : " + text2);
			}
			
		
			
		}
	 
	 public static void EditIconOTAssignmentSave(ExtentTest test) throws InterruptedException
		{
		 WebDriverWait wait = new WebDriverWait(getDriver(), 140);
		 
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			Thread.sleep(1000);
			
			CoordinatorLocator.SearchBox().sendKeys("Requested",Keys.ENTER);
			Thread.sleep(3000);
			CoordinatorLocator.EditBtn().click();
			
			CoordinatorLocator.plus3().click();
			Thread.sleep(3000);

			CoordinatorLocator.clickonRCPDropdown().click();
			Thread.sleep(4000);
			CoordinatorLocator.selectonRCPDropdownuser().click();
			
			getDriver().findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();			
			
			
			Thread.sleep(4000);
			By locator = By.xpath("//h4[@class='f-label']");

			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Thread.sleep(4000);
			String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();

			if (text.equalsIgnoreCase("OT assigned successfully")) {
				Thread.sleep(5000);
				
				test.log(LogStatus.PASS, "OT Assignment tab is opened");
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "User is selected successfully");
				Thread.sleep(1000);
				Thread.sleep(1000);
				test.log(LogStatus.PASS, "Save button is working fine");
				test.log(LogStatus.PASS, "Message Displayed : " + text);
			} else {
				Thread.sleep(5000);

				test.log(LogStatus.FAIL, "Message Displayed : " + text);
			}
			
		}
	 
	 
	 public static void EditIconOtherTabsView(ExtentTest test) throws InterruptedException
		{
		 WebDriverWait wait = new WebDriverWait(getDriver(), 140);
		 
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			Thread.sleep(1000);
			
			CoordinatorLocator.SearchBox().sendKeys("Requested",Keys.ENTER);
			Thread.sleep(3000);
			CoordinatorLocator.EditBtn().click();
			
			
			
			
			String BasicInfo = getDriver().findElement(By.xpath("//a[normalize-space()='License Request Details']")).getText();
			if(BasicInfo.equals("License Request Details"))
			{
				test.log(LogStatus.PASS,  "License Request Details Tab is displayed"); 
			}
			else 
			{
				test.log(LogStatus.FAIL,  "License Request Details Tab is not displayed"); 
			}
			
			
			Thread.sleep(7000);
			getDriver().findElement(By.xpath("//a[normalize-space()='RCP Team']")).click();
			String TransReq = getDriver().findElement(By.xpath("//label[normalize-space()='RCP No.']")).getText();

			if(TransReq.equals("RCP No."))
			{
				test.log(LogStatus.PASS,  "RCP Team Tab is displayed"); 
			}
			else 
			{
				test.log(LogStatus.FAIL,  "RCP Team Tab is not displayed"); 
			}
			
			
			Thread.sleep(7000);
			getDriver().findElement(By.xpath("//a[normalize-space()='SD Executer']")).click();
			//Me get text is not added due to in both tab same get.text is there
			if(TransReq.equals("RCP No."))
			{
				test.log(LogStatus.PASS,  "SD Executor Tab is displayed"); 
			}
			else 
			{
				test.log(LogStatus.FAIL,  "SD Executor Tab is not displayed"); 
			}
			
			
			Thread.sleep(7000);
			getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();
			String DocRepo = getDriver().findElement(By.xpath("//span[normalize-space()='Document Repository']")).getText();
			if(DocRepo.equals("Document Repository"))
			{
				test.log(LogStatus.PASS,  "Document Section Tab is displayed"); 
			}
			else 
			{
				test.log(LogStatus.FAIL,  "Document Section Tab is not displayed"); 
			}
			
			

			
		}
	 
	 public static void EditIconDocumentRepoDownload(ExtentTest test) throws InterruptedException
		{
		 WebDriverWait wait = new WebDriverWait(getDriver(), 140);
		 
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			Thread.sleep(1000);
			
		// we can add in search 'Application Submitted' as well directly it will search
			CoordinatorLocator.SearchBox().sendKeys("Application Submitted",Keys.ENTER);
			Thread.sleep(5000);
			CoordinatorLocator.EditBtn().click();
			
			
            
			
			Thread.sleep(7000);
			getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();
 //    		CoordinatorLocator.plus2().click();
			
     		
   //Tried all javascript   Actions class  normal click but not opening  		
     		
//			WebElement plus2 = getDriver().findElement(By.xpath("//div[@class='container-content']//div[@class='col-md-12 colpadding0']//div[3]//div//div//img[@class='svg-icon-btn']"));
						
			
			 Thread.sleep(5000); //take Xpath for +3 mark 
		     Actions action = new Actions(getDriver());
			 action.moveToElement(CoordinatorLocator.plus2()).click().build().perform();		 
			
//			 clickElementUsingJS(CoordinatorLocator.plus2());
			 
			//Clicking on download path
			WebElement Doc_download = getDriver().findElement(By.xpath("//img[@alt='Action Icon' or @title='No File Availabe']"));
/*			
			if(Doc_download.isEnabled())
			{				
			//	Actions Class Clicking
			//	Actions action = new Actions(getDriver());
			//	action.moveToElement(Doc_download).click().build().perform();
				
				Thread.sleep(3000);
				Doc_download.click();
				test.log(LogStatus.PASS, "Registration Search Successfully");
				Thread.sleep(900);
				test.log(LogStatus.PASS, "Document Section clicked successfully.");
				Thread.sleep(100);
				test.log(LogStatus.PASS, "Document Repository is opened successfully");
				Thread.sleep(1800);
				test.log(LogStatus.PASS, "Document Repository documents downloaded successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Document Repository documents are not downloaded");
			}
			*/
			
			Thread.sleep(3000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();

			Thread.sleep(500);
			try {
				if (Doc_download.isDisplayed() && Doc_download.isEnabled()) {
					Doc_download.click();
					Thread.sleep(8000);
					File dir1 = new File("C:\\Users\\bilali\\Downloads");
					File[] allFilesNew = dir1.listFiles();
					Thread.sleep(3000);
					if (dirContents.length < allFilesNew.length) {
						Thread.sleep(5000);
						test.log(LogStatus.PASS, "Document File downloaded successfully.");
					} else {
						Thread.sleep(5000);
						test.log(LogStatus.FAIL, "Document File is not downloaded");
					}
				} else {
					test.log(LogStatus.INFO, "Document - There is no document (button not clickable).");
				}
			} catch (Exception e) {
				test.log(LogStatus.INFO, "Document - There is No File Available");
			}
			
			
			
		}
	 
	 
	 public static void DeleteButton(ExtentTest test) throws InterruptedException
		{
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			
			
			Thread.sleep(2000);
			String item = CoordinatorLocator.readTotalItems().getText();
    		String[] bits = item.split(" ");								//Splitting the String
    		if(bits.length > 2)
    		{
    			Thread.sleep(2000);
    			item = CoordinatorLocator.readTotalItems().getText();
    			bits = item.split(" ");								//Splitting the String
    		}
    		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
    		if(compliancesCount.equalsIgnoreCase("to"))
    		{
    			Thread.sleep(2000);
    			item = CoordinatorLocator.readTotalItems().getText();
    			bits = item.split(" ");									//Splitting the String
    			compliancesCount = bits[bits.length - 2];
    		}
    		int count = Integer.parseInt(compliancesCount);
    			
			Thread.sleep(2000);
			CoordinatorLocator.clickDelete().click();
			
			Thread.sleep(2000);
			String msg=CoordinatorLocator.clickDeleteMsg().getText();
			
			 if(msg.equalsIgnoreCase("Are you sure you want to delete this License?"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
				CoordinatorLocator.clickOkBtn().click();
			
				Thread.sleep(2000);
				String msg1=CoordinatorLocator.deleteMsg().getText();
				
				 if(msg1.equalsIgnoreCase("License deleted successfully"))
				 {
					 test.log(LogStatus.PASS, "Message displayed = "+msg1);
					 
				 }
				 else
				 {
					 test.log(LogStatus.FAIL, "Message displayed = "+msg1);
				 }
				 
				 Thread.sleep(1000);
				CoordinatorLocator.clickOkBtn().click();
				
				Thread.sleep(1000);
    			CoordinatorLocator.readTotalItems().click();
    			String item1 = CoordinatorLocator.readTotalItems().getText();
    			String[] bits1 = item1.split(" ");								//Splitting the String
    			
    			if(bits1.length > 2)
    			{
    				Thread.sleep(2000);
    				item1 = CoordinatorLocator.readTotalItems().getText();
    				bits1 = item1.split(" ");								//Splitting the String
    			}
    			String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
    			
    			if(compliancesCount1.equalsIgnoreCase("to"))
    			{
    				Thread.sleep(2000);
    				item1 = CoordinatorLocator.readTotalItems().getText();
    				bits1 = item1.split(" ");									//Splitting the String
    				compliancesCount1 = bits1[bits1.length - 2];
    			}
    			int count1 = Integer.parseInt(compliancesCount1);
    			if(count > count1)
    				{
    				
    					test.log(LogStatus.PASS, "Before delete License count = "+count+" | After delete License count = "+count1);
    				}
    				else
    				{
    					test.log(LogStatus.FAIL, "Before delete License  count= "+count+" | After delete License count  = "+count1);
    				}
			
		}
	 
	 public static void DeleteCancelButton(ExtentTest test) throws InterruptedException
		{
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			
			Thread.sleep(2000);
			CoordinatorLocator.clickDelete().click();
			
			if(CoordinatorLocator.clickCancelBtn().isEnabled())
			{
				Thread.sleep(2000);
				CoordinatorLocator.clickCancelBtn().click();
				test.log(LogStatus.PASS, "Cancel button is clickable");
			}
			else
			{
				test.log(LogStatus.FAIL, "Cancel button is clickable");
			}
			
		}
	 public static void RegistrationPaginationNextAndPrevious(ExtentTest test) throws InterruptedException
		{
			
//			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			
	//		getDriver().findElement(By.xpath("//button[@title='Go to the next page']")).click();
			
			
/*			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("window.scrollBy(0,1000)");
			WebElement element = getDriver().findElement(By.xpath("//button[@title='Go to the next page']"));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(4000);

			WebElement GoToNextPage = getDriver().findElement(By.xpath("//button[@title='Go to the next page']"));
			WebElement GoToPreviousPage = getDriver().findElement(By.xpath("//button[@title='Go to the previous page']"));
			
			
			if(GoToNextPage.isEnabled())
			{
				Thread.sleep(3000);
				GoToNextPage.click();
				test.log(LogStatus.PASS, "Pegination: Go To Next Page button is working fine");
				Thread.sleep(10000);
				GoToPreviousPage.click();
				test.log(LogStatus.PASS, "Pegination: Go To Previous Page button is working fine");
			}
			else
			{
				test.log(LogStatus.FAIL, "Pegination Go To Next Page and Go to Previous Page buttons are not working");
			}
			
*/			
			
			verifyPaginationGoToNextPage(test);
			
			
			
		}
	 
	 public static void ExistingLicenseCountMatch( ExtentTest test,String Notice) throws InterruptedException, IOException
		{
		 
		 Thread.sleep(1000);
		CoordinatorLocator.clickRegistration().click();
			
		Thread.sleep(6000);
		CoordinatorLocator.ExistingLicesne().click();
		Thread.sleep(8000);

		//int pendingAssignment = 0;
		if(Notice.equalsIgnoreCase("Pending Assignment"))
		{
			Thread.sleep(3000);
			String string_pendingAssignment = CoordinatorLocator.pendingAssignmentLicenseCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Pending assignment box count :-"+string_pendingAssignment);
			//pendingAssignment = Integer.parseInt(string_pendingAssignment);
			CoordinatorLocator.pendingAssignmentLicenseCount().click();
		}
		else if(Notice.equalsIgnoreCase("Pending Action"))
		{
			Thread.sleep(3000);
			String string_pendingAssignment = CoordinatorLocator.pendingActionLicenseCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Pending Action  box count :-"+string_pendingAssignment);
			//pendingAssignment = Integer.parseInt(string_pendingAssignment);
			CoordinatorLocator.pendingActionLicenseCount().click();
		}
		else if(Notice.equalsIgnoreCase("Overdue"))
		{
			Thread.sleep(3000);
			String string_pendingAssignment = CoordinatorLocator.OverdueLicenseCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Ovedrue  box count :-"+string_pendingAssignment);
			//pendingAssignment = Integer.parseInt(string_pendingAssignment);
			CoordinatorLocator.OverdueLicenseCount().click();
			
		}
		else if(Notice.equalsIgnoreCase("Closed"))
		{
			Thread.sleep(3000);
			String string_pendingAssignment = CoordinatorLocator.ClosedLicenseCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(3000);
			test.log(LogStatus.PASS, "Closed  box count :-"+string_pendingAssignment);
			//pendingAssignment = Integer.parseInt(string_pendingAssignment);
			CoordinatorLocator.ClosedLicenseCount().click();
		}
		
		
//		Thread.sleep(5000);
//		Locator.readTotalItems().click();					//Clicking on total items count
//		Thread.sleep(500);
//		String item = Locator.readTotalItems().getText();	//Reading total items String value
//		String[] bits = item.split(" ");								//Splitting the String
//		String pendingAssignmentcount = bits[bits.length - 2];				//Getting the second last word (total number of users)
//		int count = Integer.parseInt(pendingAssignmentcount);
		
		
		
//		if(pendingAssignment == count)
//		{
//		
//			test.log(LogStatus.PASS, Notice+":- box count = "+count+ " | " +Notice+ ":- box  grid Count = "+pendingAssignment);
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, Notice+":- box count= "+count+ " | " +Notice+ ":-box  grid Count = "+pendingAssignment);
//		}
		
	}
	 
	 public static void ExistingLicsneExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		{
			

			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			
			Thread.sleep(1000);
			CoordinatorLocator.ExistingLicesne().click();

			Thread.sleep(1000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(5000);
			
			//Explicit wait
			WebDriverWait wait2 = new WebDriverWait(getDriver(), (30));
			wait2.until(ExpectedConditions.visibilityOf(CoordinatorLocator.clickExistingLicenseExport()));
			
			
			CoordinatorLocator.clickExistingLicenseExport().click();
			
		
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
			if(dirContents.length < allFilesNew.length)
			{
			
				Thread.sleep(9000);					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "File downloaded successfully.");
		
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
			
		
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
		
			
			}
	 
	 public static void SearchBoxExistiongLicense(ExtentTest test) throws InterruptedException
		{
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			Thread.sleep(1000);
			CoordinatorLocator.ExistingLicesne().click();
			
				Thread.sleep(3000);
				CoordinatorLocator.SearchBox().sendKeys("Karnataka",Keys.ENTER);
			
				List<String> li=new ArrayList<String>();
		        
		       
		        li.add("Karnataka");
	       
		        
				List<String> filter=new ArrayList<String>();	
				
				filter.add("Karnataka");	
				
				
				js.executeScript("window.scrollBy(0,150)");	
				Thread.sleep(3000);

	                
				try
				{

				
				Thread.sleep(5000);
		
				List<WebElement> typecol=getDriver().findElements(By.xpath("//*[@class='k-grid-aria-root']/kendo-treelist-list/div/div[1]/table/tbody/tr[1]/td[3]"));
				Thread.sleep(2000);

				for(int i=0; i<li.size(); i++){
					
					List<String> text= new ArrayList<String>();
					HashSet<String> pass=new LinkedHashSet<>();
					HashSet<String> fail=new LinkedHashSet<>();
					List<WebElement> raw=new ArrayList<WebElement>();


				 if(i==0)
						{
							raw.addAll(typecol);
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
				
				if(CoordinatorLocator.ClearBtn().isEnabled())
				{
					CoordinatorLocator.ClearBtn().click();
					test.log(LogStatus.PASS, "Clear button working successfully.");
					
				}
				else
				{
					test.log(LogStatus.PASS, "Clear button not working successfully.");
					
				}
				
				}
				}
				catch (Exception e) 
				{
					test.log(LogStatus.FAIL,"No records available.");	
				}
				{
					
				}
			}
	 
		public static void ExistingLicenseViewIcon(ExtentTest test) throws InterruptedException
		{
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			Thread.sleep(1000);
			CoordinatorLocator.ExistingLicesne().click();
			Thread.sleep(7000);
			
			CoordinatorLocator.pendingActionLicenseCount().click();

			
			Thread.sleep(1000);
			CoordinatorLocator.ExistingLicesneViewIcon().click();
			
			Thread.sleep(5000);
			String msg =CoordinatorLocator.ExistingLicesneDetailes().getText();
			
			if(msg.equalsIgnoreCase("Existing License Details"))
			{
				
				test.log(LogStatus.PASS, "Existing License Details open successfully:-" +msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "Existing License Details not open successfully:-" +msg);
			}
			Thread.sleep(5000);
//			CoordinatorLocator.clickBack().click();
			
			
		}
		public static void ExistingLicenseInitiateAction(ExtentTest test) throws InterruptedException, AWTException
		{
			
/*			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_MINUS);
			
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_MINUS);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_MINUS); */
			
			zoomOutScreen(2); // 2 times zoom out
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			Thread.sleep(1000);
			CoordinatorLocator.ExistingLicesne().click();
			
			Thread.sleep(1000);
			CoordinatorLocator.pendingActionLicenseCount().click();
			
			if(CoordinatorLocator.ExistingLicesneInitiateAction().isEnabled())
			{
				Thread.sleep(1000);
				CoordinatorLocator.ExistingLicesneInitiateAction().click();
				test.log(LogStatus.PASS, "Initiate Action Icon is clikable");
			}
			else
			{
				test.log(LogStatus.FAIL, "Initiate Action Icon is not clikable");
			}
			
			Thread.sleep(3000);
			CoordinatorLocator.clickActivityTab().click();
			Thread.sleep(3000);
			CoordinatorLocator.selectActivityTab6().click();
			
			
			Thread.sleep(10000);
			CoordinatorLocator.clickSubmit().click();
			
			Thread.sleep(3000);
			String msg =CoordinatorLocator.SccessMsgSubActivity().getText();
			
			if(msg.equalsIgnoreCase("SubActivity saved successfully"))
			{
				
				test.log(LogStatus.PASS, "Message Displayed:-" +msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "Message Displayed:-" +msg);
			}
			Thread.sleep(1000);
			CoordinatorLocator.clickOkBtn().click();
			Thread.sleep(1000);
			CoordinatorLocator.clickBack().click();
			
			
		}
		public static void ExistingLicenseDownload(ExtentTest test) throws InterruptedException, IOException
		{
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(1000);
			CoordinatorLocator.clickRegistration().click();
			Thread.sleep(1000);
			CoordinatorLocator.ExistingLicesne().click();
			
			Thread.sleep(2000);
			CoordinatorLocator.pendingActionLicenseCount().click();
			
			
			
			Thread.sleep(2000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			
			Thread.sleep(2000);
			CoordinatorLocator.ExistingLicesneDownload().click();
//			CoordinatorLocator.ExistingLicesneDownload().click();
			
			WebDriverWait wait=new WebDriverWait(getDriver(), 20);
			
			Thread.sleep(10000);
//			wait.until(ExpectedConditions.invisibilityOf(CoordinatorLocator.gridLoad()));//me hide and give more load
			
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
			if(dirContents.length < allFilesNew.length)
			{
			
				Thread.sleep(9000);					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "File downloaded successfully.");
			}
			else
			{
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			
			
		}
		
		public static String getRandomString() {
		    return new java.util.Random().ints(6, 0, 62)
		        .mapToObj(i -> "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(i))
		        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
		        .toString();
		}
		
		
	
	    
	    //To call this method just put below line
		//zoomOutScreen(2); // 2 times zoom out
	    public static void zoomOutScreen(int times) {
	        try {
	            Robot robot = new Robot();
	            for (int i = 0; i < times; i++) {
	            	Thread.sleep(2000);
	                robot.keyPress(KeyEvent.VK_CONTROL);
	                robot.keyPress(KeyEvent.VK_MINUS);
	                robot.keyRelease(KeyEvent.VK_MINUS);
	                robot.keyRelease(KeyEvent.VK_CONTROL);
	                Thread.sleep(2000); // thoda delay zoom-out ke beech
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    
	    
	    
	    


	    public static void clickElementUsingJS(WebElement element) {
	        try {
	            JavascriptExecutor jse = (JavascriptExecutor) getDriver();
	            Thread.sleep(2000);
	            jse.executeScript("arguments[0].click();", element);
	            Thread.sleep(4000);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    
	    
	    
	    
	    
	    
	    
	    //Safe click if multiple dropdwons are available we can use that it will handle  
	    public static void safeClickDropdown(WebElement dropdown, WebElement option) {
	        try {
	            if (dropdown != null && dropdown.isDisplayed() && dropdown.isEnabled()) {
	                dropdown.click();
	                Thread.sleep(2000); // optional wait
	                option.click();
	            } else {
	                System.out.println("Dropdown is not enabled or visible.");
	            }
	        } catch (Exception e) {
	            System.out.println("Dropdown click failed: " + e.getMessage());
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

	            WebElement goToNextPage = getDriver().findElement(By.xpath("//button[@title='Go to the next page']"));
	            WebElement goToPreviousPage = getDriver().findElement(By.xpath("//button[@title='Go to the previous page']"));

	            if (goToNextPage.isEnabled()) {
	                Thread.sleep(3000);
	                goToNextPage.click();
	                test.log(LogStatus.PASS, "Pagination: Go To Next Page button is working fine");
	                Thread.sleep(10000);
	                goToPreviousPage.click();
	                test.log(LogStatus.PASS, "Pagination: Go To Previous Page button is working fine");
	            } else {
	                test.log(LogStatus.FAIL, "Pagination: Go To Next Page and Go To Previous Page buttons are not working");
	            }
	        } catch (Exception e) {
	            test.log(LogStatus.ERROR, "Pagination check failed due to: " + e.getMessage());
	        }
	    }

	    
	    
	    
	    
	    
	    
	    
	    
	    
		

}
