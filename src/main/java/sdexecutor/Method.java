package sdexecutor;

import java.awt.AWTException;
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
import clientPortal.All_ClientPortal_Methods;
import coordinator.CoordinatorLocator;
import coordinator.CoordinatorMethod;
import distributor.DistributerLocators;
import login.BasePage;
import login.LoginLocators;
import rcp.OneCommonMethod;





public class Method extends BasePage
{
	 static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour2.xlsx";
	 
	 public static void CountMatch( ExtentTest test,String Notice) throws InterruptedException, IOException
		{
		 
		 Thread.sleep(2000);
		 getDriver().navigate().refresh();

		 Thread.sleep(10000);
		 
		int pendingAssignment = 0;
		Thread.sleep(10000);
		if(Notice.equalsIgnoreCase("Extension"))
		{
			Thread.sleep(5000);
			String string_pendingAssignment = Locator.pendingAssignmentCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(5000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(5000);
			Locator.pendingAssignmentCount().click();
			Thread.sleep(5000);
		}
		else if(Notice.equalsIgnoreCase("Response Pending"))
		{
			Thread.sleep(5000);
			String string_pendingAssignment = Locator.pendingActionCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(5000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(5000);
			Locator.pendingActionCount().click();
			Thread.sleep(5000);
		}
		else if(Notice.equalsIgnoreCase("Overdue"))
		{
			Thread.sleep(5000);
			String string_pendingAssignment = Locator.OverdueCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(5000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(5000);
			Locator.OverdueCount().click();
			Thread.sleep(5000);
		}
		else if(Notice.equalsIgnoreCase("Response Submitted"))
		{
			Thread.sleep(5000);
			String string_pendingAssignment = Locator.ClosedCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(5000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(5000);
			Locator.ClosedCount().click();
			Thread.sleep(5000);
		}
		
		
		Thread.sleep(5000);
//		Locator.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = Locator.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String pendingAssignmentcount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count = Integer.parseInt(pendingAssignmentcount);
		
		
		
		if(pendingAssignment == count)
		{
		
			test.log(LogStatus.PASS, Notice+":- box count = "+count+ " | " +Notice+ ":- box  grid Count = "+pendingAssignment);
		}
		else
		{
			test.log(LogStatus.FAIL, Notice+":- box count= "+count+ " | " +Notice+ ":-box  grid Count = "+pendingAssignment);
		}
		
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
	 
	public static void tabsExport(ExtentTest test, String user) throws InterruptedException, IOException {

		Thread.sleep(5000);
		
		if(user.equalsIgnoreCase("Translation Pending")) {
			Locator.pendingAssignmentCount().click();
			Thread.sleep(5000);
		    OneCommonMethod.validateExportedExcelDYNAMIC(
		    	    driver.get(),
		    	    test,
		    	    LoginLocators.Exportbtn(),        // WebElement for export button
		    	    All_ClientPortal_Locators.readTotalItemsNotice(),     // WebElement for grid count text
		    	    "Notice Type",                               // Column header to verify
		    	    "Translation Pending File Exported Successfully !"     // Success log text (only if PASS)
		    	);
		}
		else if(user.equalsIgnoreCase("Ext.Submission Pending")) {
			
			Locator.pendingActionCount().click();
			Thread.sleep(5000);
			
		    OneCommonMethod.validateExportedExcelDYNAMIC(
		    	    driver.get(),
		    	    test,
		    	    LoginLocators.Exportbtn(),        // WebElement for export button
		    	    All_ClientPortal_Locators.readTotalItemsNotice(),     // WebElement for grid count text
		    	    "Notice Type",                               // Column header to verify
		    	    "Ext.Submission Pending File Exported Successfully !"     // Success log text (only if PASS)
		    	);
		}
		
		else if(user.equalsIgnoreCase("Submission Pending")) {
			
			Locator.OverdueCount().click();
			Thread.sleep(5000);
		    OneCommonMethod.validateExportedExcelDYNAMIC(
		    	    driver.get(),
		    	    test,
		    	    LoginLocators.Exportbtn(),        // WebElement for export button
		    	    All_ClientPortal_Locators.readTotalItemsNotice(),     // WebElement for grid count text
		    	    "Notice Type",                               // Column header to verify
		    	    "Submission Pending File Exported Successfully !"     // Success log text (only if PASS)
		    	);
		}
		
		else if(user.equalsIgnoreCase("Response Submitted")) {
			
			Locator.ClosedCount().click();
			Thread.sleep(5000);
		    OneCommonMethod.validateExportedExcelDYNAMIC(
		    	    driver.get(),
		    	    test,
		    	    LoginLocators.Exportbtn(),        // WebElement for export button
		    	    All_ClientPortal_Locators.readTotalItemsNotice(),     // WebElement for grid count text
		    	    "Notice Type",                               // Column header to verify
		    	    "Response Submitted File Exported Successfully !"     // Success log text (only if PASS)
		    	);
		}

	}
	 
	 
	 public static void logoChecking( ExtentTest test) throws InterruptedException, IOException
		{
		 
        Thread.sleep(15000);
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
	 
	 public static void NoticeExportBtn(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
	 	
	 	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	 	Thread.sleep(2000); 
	 	getDriver().navigate().refresh();
	 	 Thread.sleep(10000); 		
//	      Locator.readTotalItems().click();
	 		String item = Locator.readTotalItems().getText();
	 		
	 		
		    OneCommonMethod.validateExportedExcelDYNAMIC(
		    	    driver.get(),
		    	    test,
		    	    LoginLocators.Exportbtn(),        // WebElement for export button
		    	    Locator.readTotalItems(),     // WebElement for grid count text
		    	    "Branch",                               // Column header to verify
		    	    "File Exported Successfully ! "     // Success log text (only if PASS)
		    	);
	 		
	 		
	 		
	 		
//	 		String[] bits = item.split(" ");								//Splitting the String
//	 		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
//	 		int count1 = Integer.parseInt(compliancesCount);
//	 	
//	 		if(compliancesCount.equalsIgnoreCase("to"))
//	 		{
//	 			Thread.sleep(5000);
//	 		   item = Locator.readTotalItems().getText();
//	 			bits = item.split(" ");
//	      
//	 		}
//	 		
//	 		Thread.sleep(2000);
//	      JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
//	      
//	      js1.executeScript("window.scrollBy(0,-500)");
//	 	Thread.sleep(1000);
//	 	File dir = new File("C:\\Users\\bilali\\Downloads");
//	 	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
//
//	 	Thread.sleep(1000);
//	 	Locator.clickNoticeExport().click();
//	 	Thread.sleep(9000);					//Clicking on 'Excel Report' image.
//	 	test.log(LogStatus.PASS, "File downloaded successfully.");
//
//	 	Thread.sleep(5500);
//	 	File dir1 = new File("C:\\Users\\bilali\\Downloads");
//	 	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
//
//	 	if(dirContents.length < allFilesNew.length)
//	 	{
//	 	
//
//	 	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
//	  for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
//	  {
//	     if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
//	     {
//	         lastModifiedFile = allFilesNew[i];
//	     }
//	  }
//	 	
//	 	Thread.sleep(1000);
//	 	fis = new FileInputStream(lastModifiedFile);
//	 	workbook = new XSSFWorkbook(fis);
//	 	sheet = workbook.getSheetAt(0);					//Retrieving first sheet of Workbook
//	 	
//	 	sheet = workbook.getSheetAt(0);
//	 	int columnNumber = 3;
//	 	int rowCount = 0;
//	 	int actualRow=0;
//	 	
//	 	for(Row row : sheet)
//	 	{
//	 		
//	 		Cell cell =row.getCell(columnNumber);
//	 		if(cell != null) {
//	 			
//	 			rowCount++;
//	 			actualRow = rowCount-1;
//	 		}
//	 		
//	 	}
//	 	fis.close();
//	 	
//	 	if(count1 == actualRow)
//	 	{
//	 		//test.log(LogStatus.PASS, "No of records from grid matches to no of records in Excel Sheet.");
//	 		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
//	 	}
//	 	else
//	 	{
//	 		//test.log(LogStatus.FAIL, "No of records from grid doesn't matches to no of records in Excel Sheet.");
//	 		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
//	 	}
//	 	}
//	 	else
//	 	{
//	 		test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
//	 	}

	 	
	 }
	 public static void NoticeSearchBox(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
	 	
		 Thread.sleep(3000);
	 	 getDriver().navigate().refresh();
	 	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	 	
	 	
	 	Thread.sleep(10000);
	 	Locator.SearchBox().sendKeys("Test Automation 2",Keys.ENTER);

	 	List<String> li=new ArrayList<String>();
	     
	    
	     li.add("Test Automation 2");

	     
	 	List<String> filter=new ArrayList<String>();	
	 	
	 	filter.add("Test Automation 2");	
	 	
	 	
	 	js.executeScript("window.scrollBy(0,150)");	
	 	Thread.sleep(3000);

	 	 Locator.readTotalItems().click();				//Clicking on Text of total items just to scroll down.
	 	String s = Locator.readTotalItems().getText();
	 	Thread.sleep(2000);

	 	try {
	 	Thread.sleep(5000);

	 	List<WebElement> typecol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[2]/div[1]"));
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
	 	
	 	if(Locator.ClearBtn().isEnabled())
	 	{
	 		Locator.ClearBtn().click();
	 		test.log(LogStatus.PASS, "Clear button working successfully.");
	 		
	 	}
	 	else
	 	{
	 		test.log(LogStatus.PASS, "Clear button not working successfully.");
	 		
	 	}
	 	
	 	}
	 	}
	 	catch (Exception e) {
	 		test.log(LogStatus.PASS,"No records available.");	
		}
	 	
	 	
	 }
	
	 public static void DoNotHaveOTP(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
	 	

	 	 getDriver().navigate().refresh();
	 	 JavascriptExecutor js = (JavascriptExecutor) getDriver();
	 	 
	 	 
	 }			
	
	 
	 public static void NoticeEditDownload(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
		Thread.sleep(2000);
	 	getDriver().navigate().refresh();
	 	JavascriptExecutor js = (JavascriptExecutor) getDriver();	
	 	Thread.sleep(10000);
	 	File dir3 = new File("C:\\Users\\bilali\\Downloads");
	 	File[] dirContents1 = dir3.listFiles();							//Counting number of files in directory before download 

	 	
	 	Thread.sleep(2000);

	 	Locator.clickDownload().click();
	 	
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
	 	
	 	
	 	
	 	Thread.sleep(1000);
	 	if(Locator.EditBtn().isEnabled())
	 	{
	 		Thread.sleep(1000);
	 		Locator.EditBtn().click();
	 		test.log(LogStatus.PASS, "Edit button is clickable.");
	 		
	 	}
	 	else
	 	{
	 		test.log(LogStatus.FAIL, "Edit button is not clickable.");
	 		
	 	}
	 	
	 	Thread.sleep(2000);
	      JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
	      
	      js1.executeScript("window.scrollBy(900,0)");
//	 	Thread.sleep(1000);
//	 	Locator.clickBack().click();
	 	
		Thread.sleep(1000);
	 	Actions action = new Actions(getDriver());
	 	WebElement we = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
	 	action.moveToElement(we).click().build().perform();
	 	
	 	

	 }
	 public static void translationReq(ExtentTest test) throws Exception
	 {

	 	
	 	JavascriptExecutor js = (JavascriptExecutor) getDriver();	
	 	Thread.sleep(7000);
	 	getDriver().findElement(By.xpath("//span[normalize-space()='Translation Pending']")).click();
	 	Thread.sleep(4000);
	 	Locator.EditBtn().click();
	 	Thread.sleep(4000);
	 	
	 	if(Locator.plus1().isDisplayed()) {
		 	Locator.plus1().click();
		 	Thread.sleep(4000);
		 	test.log(LogStatus.PASS, "Translation Required label bar is working fine");
	 	}
	 	else {
	 		test.log(LogStatus.FAIL, "Translation Required label bar is not opened");
	 	}
	 	
	 	if(Locator.yesRadio().isDisplayed()) {
		 	Locator.yesRadio().click();
		 	Thread.sleep(4000);
		 	test.log(LogStatus.PASS, "Translation Required Radio button are working fine");
	 	}
	 	
	 	WebElement downloadIcon = getDriver().findElement(By.xpath("//img[@alt='Action Icon']"));
		OneCommonMethod.validateFileDownloadDynamic(driver.get(), test, downloadIcon,"Original Notice Document Downloaded successfully");
		Thread.sleep(8000);
		
		
		Thread.sleep(4000);
		Locator.clickSubmit().click();
		String errorTxt = Locator.errorText().getText();
		if(errorTxt.equals("File is required.")) {
			test.log(LogStatus.PASS, "Without uploading file in browse button error message is displayed");
//			test.log(LogStatus.PASS, "Error message displayed : " + errorTxt);
			test.log(LogStatus.PASS, "Error message displayed : <font color='red'>" + errorTxt + "</font>");
		}
		else {
			test.log(LogStatus.FAIL, "Browse Error Messahe displayed : " + errorTxt);
		}
		
		
		Locator.browse().click();
		Thread.sleep(4000);
		OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\Notice Module\\Upload Validations\\Test.pdf");
		Thread.sleep(4000);
		Locator.clickSubmit().click();
		String textM = Locator.message3().getText();
		Thread.sleep(4000);
		if(textM.equalsIgnoreCase("Translation Submitted Successfully")) {
			test.log(LogStatus.PASS, "File is uploaded successfully ");
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Submit button is working fine");
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "While clicking to submit button success message is displayed");
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Message displayed : " + textM);
		}
		else {
			test.log(LogStatus.FAIL, "Message displayed on clikcing to submit button : " + textM);
		}
	 	

	 }
	 public static void extensionApplication(ExtentTest test) throws Exception
	 {

	 	
	 	JavascriptExecutor js = (JavascriptExecutor) getDriver();	
	 	Thread.sleep(7000);
	 	getDriver().findElement(By.xpath("//span[normalize-space()='Ext.Submission Pending']")).click();
	 	Thread.sleep(4000);
	 	Locator.EditBtn().click();
	 	Thread.sleep(4000);
	 	
	 	if(Locator.plus2().isDisplayed()) {
		 	Locator.plus2().click();
		 	Thread.sleep(4000);
		 	test.log(LogStatus.PASS, "Extension Application label bar is working fine");
	 	}
	 	else {
	 		test.log(LogStatus.FAIL, "Extension Application label bar is not opened");
	 	}
	 	
	 	if(Locator.yesRadio().isDisplayed()) {
		 	Locator.yesRadio().click();
		 	Thread.sleep(4000);
		 	test.log(LogStatus.PASS, "Extension Required Radio button are working fine");
	 	}
	 	
	 	
	 	
	 	
		Thread.sleep(6000);
		Locator.clickSubmit().click();
		String errorTxt = Locator.errorText().getText();
		if(errorTxt.equals("File is required.")) {
			test.log(LogStatus.PASS, "Without uploading file in browse button of Acknowledgment Document error message is displayed");
//			test.log(LogStatus.PASS, "Error message displayed : " + errorTxt);
			test.log(LogStatus.PASS, "Error message displayed : <font color='red'>" + errorTxt + "</font>");
		}
		else {
			test.log(LogStatus.FAIL, "Browse Error Messahe displayed : " + errorTxt);
		}
	 	
	 	
	 	
	 	Locator.calendar1().click();
		OneCommonMethod.selectCalendarDateFromInput(driver.get(), test, 
				Locator.calendar1(), // calendar icon
				DistributerLocators.Calendar_NavigateToParentView(), // parent view arrow
				"31-10-2025" // date in dd-MM-yyyy format
		);
	 	
	 	
		
	 	Locator.calendar2().click();
		OneCommonMethod.selectCalendarDateFromInput(driver.get(), test, 
				Locator.calendar2(), // calendar icon
				DistributerLocators.Calendar_NavigateToParentView(), // parent view arrow
				"30-11-2025" // date in dd-MM-yyyy format
		);
	 	
	 	
		
		//This download file is not working 
////        String downloadPath = System.getProperty("user.home") + File.separator + "Downloads";
////        File dir = new File(downloadPath);
//		//---------
//		Thread.sleep(3000);
//		File dir = new File("C:\\Users\\bilali\\Downloads");
//		File[] dirContents = dir.listFiles();
//
//		Thread.sleep(500);
//		try {
//			if (Locator.draftExtFromSMEDownload().isDisplayed() && Locator.draftExtFromSMEDownload().isEnabled()) {
//				Locator.draftExtFromSMEDownload().click();
//				Thread.sleep(8000);
////				File dir1= new File(downloadPath);
//				File dir1 = new File("C:\\Users\\bilali\\Downloads");
//				File[] allFilesNew = dir1.listFiles();
//				Thread.sleep(3000);
//				if (dirContents.length < allFilesNew.length) {
//					Thread.sleep(5000);
//					test.log(LogStatus.PASS, "Draft Extension Application (from SME) -  File downloaded successfully.");
//				} else {
//					Thread.sleep(5000);
//					test.log(LogStatus.FAIL, "Draft Extension Application (from SME) -  File is not downloaded");
//				}
//			} else {
//				test.log(LogStatus.INFO, "Draft Extension Application (from SME) - There is no document (button not clickable).");
//			}
//		} catch (Exception e) {
//			test.log(LogStatus.INFO, "Draft Extension Application (from SME) - There is No File Available");
//		}
			

		
		
		
		Thread.sleep(6000);
		Locator.browse().click();
		Thread.sleep(4000);
		OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\Notice Module\\Upload Validations\\Test.pdf");
		
		
		
		Thread.sleep(4000);
		Locator.clickSubmit().click();
		String textM = Locator.message3().getText();
		Thread.sleep(4000);
		if(textM.equalsIgnoreCase("Extension Submitted Successfully")) {
			test.log(LogStatus.PASS, "Extended Application Submitted To Department Date is accepted");
			test.log(LogStatus.PASS, "Extended Date Granted Date is accepted");
			
			test.log(LogStatus.PASS, "File is uploaded successfully in Acknowledgment Document");
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Submit button is working fine");
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "While clicking to submit button success message is displayed");
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Message displayed : " + textM);
		}
		else {
			test.log(LogStatus.FAIL, "Message displayed on clikcing to submit button : " + textM);
		}

		

	 }
	 
	 public static void noticeResponse(ExtentTest test) throws Exception
	 {

	 	Thread.sleep(7000);
	 	getDriver().findElement(By.xpath("//span[normalize-space()='Submission Pending']")).click();
	 	Thread.sleep(4000);
	 	Locator.EditBtn().click();
	 	Thread.sleep(4000);
	 	
	 	if(Locator.plus3().isDisplayed()) {
		 	Locator.plus3().click();
		 	Thread.sleep(4000);
		 	test.log(LogStatus.PASS, "Notice Response label bar is working fine");
	 	}
	 	else {
	 		test.log(LogStatus.FAIL, "Notice Response label bar is not opened");
	 	}
	 	
		Thread.sleep(6000);
		Locator.clickSubmit().click();
		String errorTxt = Locator.errorText().getText();
		if(errorTxt.equals("File is required.")) {
			test.log(LogStatus.PASS, "Without uploading file in browse button of Acknowledgment Document error message is displayed");
//			test.log(LogStatus.PASS, "Error message displayed : " + errorTxt);
			test.log(LogStatus.PASS, "Error message displayed : <font color='red'>" + errorTxt + "</font>");
		}
		else {
			test.log(LogStatus.FAIL, "Browse Error Messahe displayed : " + errorTxt);
		}
	 	
	 	
	 	
	 	Locator.calendar1().click();
		OneCommonMethod.selectCalendarDateFromInput(driver.get(), test, 
				Locator.calendar1(), // calendar icon
				DistributerLocators.Calendar_NavigateToParentView(), // parent view arrow
				"31-10-2025" // date in dd-MM-yyyy format
		);
	 	
	 	
		
	 	Locator.calendar2().click();
		OneCommonMethod.selectCalendarDateFromInput(driver.get(), test, 
				Locator.calendar2(), // calendar icon
				DistributerLocators.Calendar_NavigateToParentView(), // parent view arrow
				"30-11-2025" // date in dd-MM-yyyy format
		);
	 	
	 	
		
		//This download file is not working 
////        String downloadPath = System.getProperty("user.home") + File.separator + "Downloads";
////        File dir = new File(downloadPath);
//		//---------
//		Thread.sleep(3000);
//		File dir = new File("C:\\Users\\bilali\\Downloads");
//		File[] dirContents = dir.listFiles();
//
//		Thread.sleep(500);
//		try {
//			if (Locator.draftExtFromSMEDownload().isDisplayed() && Locator.draftExtFromSMEDownload().isEnabled()) {
//				Locator.draftExtFromSMEDownload().click();
//				Thread.sleep(8000);
////				File dir1= new File(downloadPath);
//				File dir1 = new File("C:\\Users\\bilali\\Downloads");
//				File[] allFilesNew = dir1.listFiles();
//				Thread.sleep(3000);
//				if (dirContents.length < allFilesNew.length) {
//					Thread.sleep(5000);
//					test.log(LogStatus.PASS, "Draft Extension Application (from SME) -  File downloaded successfully.");
//				} else {
//					Thread.sleep(5000);
//					test.log(LogStatus.FAIL, "Draft Extension Application (from SME) -  File is not downloaded");
//				}
//			} else {
//				test.log(LogStatus.INFO, "Draft Extension Application (from SME) - There is no document (button not clickable).");
//			}
//		} catch (Exception e) {
//			test.log(LogStatus.INFO, "Draft Extension Application (from SME) - There is No File Available");
//		}
			

		
		
		
		Thread.sleep(6000);
		Locator.browse().click();
		Thread.sleep(4000);
		OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\Notice Module\\Upload Validations\\Test.pdf");
		
		
		
		Thread.sleep(4000);
		Locator.clickSubmit().click();
		String textM = Locator.message1().getText();
		Thread.sleep(4000);
		if(textM.equalsIgnoreCase("Notice Submitted Successfully")) {
			test.log(LogStatus.PASS, "Notice Response Submitted To Department Date is accepted");
			test.log(LogStatus.PASS, "Notice Closure Date Date is accepted");
			
			test.log(LogStatus.PASS, "File is uploaded successfully in Acknowledgment Document");
			Thread.sleep(4000);
			test.log(LogStatus.PASS, "Submit button is working fine");
			Thread.sleep(1000);
			test.log(LogStatus.PASS, "While clicking to submit button success message is displayed");
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Message displayed : " + textM);
		}
		else {
			test.log(LogStatus.FAIL, "Message displayed on clikcing to submit button : " + textM);
		}

		

	 }
	 public static void NoticeEditAllTabsCheck(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {

			Thread.sleep(5000);
//			CoordinatorLocator.SearchBox().sendKeys("Pending Assignment", Keys.ENTER);
			Thread.sleep(5000);
			CoordinatorLocator.EditBtn().click();
			Thread.sleep(5000);
			
			
			getDriver().findElement(By.xpath("//a[normalize-space()='Notice Details']")).click();
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
	 
	 public static void doSectionDocReqSDEx(ExtentTest test) throws Exception
	 {
			Thread.sleep(5000);
			Thread.sleep(5000);
			CoordinatorLocator.noticesModule().click();
			Thread.sleep(8000);
			CoordinatorLocator.EditBtn().click();
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();

			// + Document Repository label bar
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn'])[2]")).click();
			Thread.sleep(5000);
			
			String gridCountCheck = Locator.gridDocRequiredForNotice().getText();
			Thread.sleep(5000);
			if(gridCountCheck.equalsIgnoreCase("0 - 0 of 0 items")) {
				test.log(LogStatus.PASS, "No iteams are available for action");
			}
			else {
				Locator.clickDelete().click();
				Thread.sleep(5000);
				String deleteText = Locator.deleteMessage().getText();
				if(deleteText.equals("Are you sure you want to delete this record?")) {
					test.log(LogStatus.PASS, "On clicking to delete button confirmation message is displayed ");
					test.log(LogStatus.PASS, "Message displayed : " + deleteText);
				}
				else {
					test.log(LogStatus.FAIL, "On clicking to delete button confirmation message is displayed ");
					test.log(LogStatus.FAIL, "Message displayed : " + deleteText);
				}
				Thread.sleep(5000);
				Locator.clickCancelBtn().click();
				Thread.sleep(5000);
				Locator.clickDelete().click();
				Thread.sleep(5000);
				Locator.clickOkBtn().click();
				Thread.sleep(5000);
				String successMesg = Locator.deleteMessage().getText();
				Thread.sleep(5000);
				if(successMesg.equalsIgnoreCase("Record Deleted Successfully")) {
					test.log(LogStatus.PASS, "On clicking to Delete Confirmation OK button success message is displayed");
					test.log(LogStatus.PASS, "Message displayed : " + successMesg);
				}
				else {
					test.log(LogStatus.FAIL, "On clicking to Delete Confirmation OK button success message is not displayed properly");
					test.log(LogStatus.FAIL, "Message displayed : " + successMesg);
				}	
			}
	 }
	 
	 public static void documentSectionDownloads(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
			Thread.sleep(5000);
			Thread.sleep(5000);
			CoordinatorLocator.EditBtn().click();
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("(//img[@class='svg-icon-btn'])[1]")).click();

			All_ClientPortal_Methods.noticeDocuments(test);
			

		}
	 public static void RegistrationCountMatch( ExtentTest test,String Notice) throws InterruptedException, IOException
		{

		Thread.sleep(3000);
	 	getDriver().navigate().refresh();
		Thread.sleep(10000);
		Locator.clickRegistration().click();
		int pendingAssignment = 0;
		Thread.sleep(6000);
		if(Notice.equalsIgnoreCase("Pending Assignment"))
		{
			Thread.sleep(5000);
			String string_pendingAssignment = Locator.RegistartionpendingAssignmentCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(3000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(3000);
			Locator.RegistartionpendingAssignmentCount().click();
		}
		else if(Notice.equalsIgnoreCase("Pending Action"))
		{
			Thread.sleep(5000);
			String string_pendingAssignment = Locator.RegistartionpendingActionCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(3000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(3000);
			Locator.RegistartionpendingActionCount().click();
		}
		else if(Notice.equalsIgnoreCase("Overdue"))
		{
			Thread.sleep(5000);
			String string_pendingAssignment = Locator.RegistartionOverdueCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(3000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(5000);
			Locator.RegistartionOverdueCount().click();
			
		}
		else if(Notice.equalsIgnoreCase("Closed"))
		{
			Thread.sleep(5000);
			String string_pendingAssignment = Locator.RegistartionClosedCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(3000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(3000);
			Locator.RegistartionClosedCount().click();
		}
		
		
		Thread.sleep(6000);
//		Locator.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = Locator.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String pendingAssignmentcount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count = Integer.parseInt(pendingAssignmentcount);
		
		
		
		if(pendingAssignment == count)
		{
		
			test.log(LogStatus.PASS, Notice+":- box count = "+count+ " | " +Notice+ ":- box  grid Count = "+pendingAssignment);
		}
		else
		{
			test.log(LogStatus.FAIL, Notice+":- box count= "+count+ " | " +Notice+ ":-box  grid Count = "+pendingAssignment);
		}
		
	}
	 
	 public static void registrationExportTabs( ExtentTest test,String Notice) throws InterruptedException, IOException
		{
		 Thread.sleep(3000);
	 	 getDriver().navigate().refresh();
		 
		Thread.sleep(10000);
		Locator.clickRegistration().click();
		int pendingAssignment = 0;
		Thread.sleep(6000);
		if(Notice.equalsIgnoreCase("Pending Assignment"))
		{
			Thread.sleep(5000);
			Locator.RegistartionpendingAssignmentCount().click();
			
			OneCommonMethod.validateExportedExcelDYNAMIC(driver.get(), test, Locator.clickExport(),
					Locator.readTotalItems(), "Branch",
					"Pending Applications (Offline) - File Exported Successfully ! ");
		}
		else if(Notice.equalsIgnoreCase("Pending Action"))
		{
			Thread.sleep(5000);
			Locator.RegistartionpendingActionCount().click();
			
			OneCommonMethod.validateExportedExcelDYNAMIC(driver.get(), test, Locator.clickExport(),
					Locator.readTotalItems(), "Branch",
					"Applied and Awaiting Dept Approval - File Exported Successfully ! ");
			
			Thread.sleep(5000);
		}
		else if(Notice.equalsIgnoreCase("Overdue"))
		{
			Thread.sleep(5000);
			Locator.RegistartionOverdueCount().click();
			
			OneCommonMethod.validateExportedExcelDYNAMIC(driver.get(), test, Locator.clickExport(),
					Locator.readTotalItems(), "Branch",
					"Overdue - File Exported Successfully ! ");
			
			Thread.sleep(5000);
			
		}
		else if(Notice.equalsIgnoreCase("Closed"))
		{
			Thread.sleep(5000);
			Locator.RegistartionClosedCount().click();
			
			OneCommonMethod.validateExportedExcelDYNAMIC(driver.get(), test, Locator.clickExport(),
					Locator.readTotalItems(), "Branch",
					"Closed - File Exported Successfully ! ");
			
			Thread.sleep(5000);
		}
		
		else if(Notice.equalsIgnoreCase("OTA Report"))
		{
			Thread.sleep(5000);
			OneCommonMethod.validateFileDownloadDynamic(driver.get(),test,Locator.clickOTAReport(),"OTA Report is downloaded successfully !");
			Thread.sleep(5000);
		}
		
		
	}
	 public static void ExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		{

		 Thread.sleep(2000);
	 	 getDriver().navigate().refresh();
		
			Thread.sleep(10000);
			Locator.clickRegistration().click();
			
			 Thread.sleep(2000); 		
//		        Locator.readTotalItems().click();
				String item = Locator.readTotalItems().getText();
				String[] bits = item.split(" ");								//Splitting the String
				String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				int count1 = Integer.parseInt(compliancesCount);
			
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					Thread.sleep(5000);
				   item = Locator.readTotalItems().getText();
					bits = item.split(" ");
		        
				}
				
				Thread.sleep(2000);
		        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		        
		        js1.executeScript("window.scrollBy(0,-500)");
			Thread.sleep(1000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(1000);
			Locator.clickExport().click();
			
		
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
	 public static void SearchBox(ExtentTest test) throws InterruptedException
		{
		 Thread.sleep(2000);
	 	 getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			Thread.sleep(10000);
			Locator.clickRegistration().click();
			
				Thread.sleep(5000);
				Locator.SearchBox().sendKeys("RCP25-8784",Keys.ENTER);
			
				List<String> li=new ArrayList<String>();
		        
		       
		        li.add("RCP25-8784");
	       
		        
				List<String> filter=new ArrayList<String>();	
				
				filter.add("RCP25-8784");	
				
				
				js.executeScript("window.scrollBy(0,150)");	
				Thread.sleep(3000);

				 Locator.readTotalItems().click();				//Clicking on Text of total items just to scroll down.
				String s = Locator.readTotalItems().getText();
				Thread.sleep(2000);

				if(!s.equalsIgnoreCase("No items to display")) {
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
				
				if(Locator.ClearBtn().isEnabled())
				{
					Locator.ClearBtn().click();
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
		 Thread.sleep(5000);
		 getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(10000);
			Locator.clickRegistration().click();
			
			Thread.sleep(5000);
			if(Locator.EditBtn().isEnabled())
			{
				Thread.sleep(3000);
				Locator.EditBtn().click();
				test.log(LogStatus.PASS, "Edit button is clickable.");
				
			}
			else
			{
				test.log(LogStatus.PASS, "Edit button is not clickable.");
				
			}
			Thread.sleep(1000);
			Locator.clickBack().click();
		}
	 
	 public static void editSubmittedToDept(ExtentTest test) throws Exception
		{

		 	Thread.sleep(3000);
			getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();

			Thread.sleep(10000);
			Locator.clickRegistration().click();

			Thread.sleep(6000);
			Locator.EditBtn().click();
			Thread.sleep(6000);
			Locator.submittedToDept().click();
			Thread.sleep(3000);
			String errorTxt = Locator.errorText().getText();
			if(errorTxt.equals("File is required.")) {
				test.log(LogStatus.PASS, "Without uploading file in browse button of Applied Acknowledgement Copy error message is displayed");
//				test.log(LogStatus.PASS, "Error message displayed : " + errorTxt);
				test.log(LogStatus.PASS, "Error message displayed : <font color='red'>" + errorTxt + "</font>");
			}
			else {
				test.log(LogStatus.FAIL, "Browse Error Messahe displayed : " + errorTxt);
			}
			
			
			
			Thread.sleep(5000);
		 	Locator.calendar1().click();
			OneCommonMethod.selectCalendarDateFromInput(driver.get(), test, 
					Locator.calendar1(), 
					DistributerLocators.Calendar_NavigateToParentView(), 
					"30-10-2025" 
			);
			
			
			Thread.sleep(6000);
			Locator.browse().click();
			Thread.sleep(4000);
			OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\Notice Module\\Upload Validations\\Test.pdf");
			
			
			
			
			
			
			Thread.sleep(4000);
			Locator.submittedToDept().click();
			String textM = Locator.message1().getText();
			Thread.sleep(4000);
			if(textM.equalsIgnoreCase("Registration Submitted Successfully")) {
				test.log(LogStatus.PASS, "Draft Application filed to Department Date is accepted");
				
				test.log(LogStatus.PASS, "File is uploaded successfully in Applied Acknowledgement Copy");
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Submitted to department button is working fine");
				Thread.sleep(1000);
				test.log(LogStatus.PASS, "While clicking to Submitted to department button success message is displayed");
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Message displayed : " + textM);
			}
			else {
				test.log(LogStatus.FAIL, "Message displayed on clikcing to submit button : " + textM);
			}
			
			
		}
	 
	 
	 public static void activityColsureLable(ExtentTest test) throws Exception
		{
			Thread.sleep(2000);
			getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();

			Thread.sleep(10000);
			Locator.clickRegistration().click();

			Thread.sleep(6000);
			Locator.EditBtn().click();
			Thread.sleep(6000);
			
			
			Locator.	plus1().click();
			Locator.closureBtn().click();
			Thread.sleep(3000);
			String errorTxt2 = Locator.errorText2().getText();
			String errorTxt3 = Locator.errorText2().getText();
			if(errorTxt2.equals("File is required.")) {
				test.log(LogStatus.PASS, "Without uploading file in browse button of New License Copy error message is displayed");
				test.log(LogStatus.PASS, "Error message displayed : <font color='red'>" + errorTxt2 + "</font>");
			}
			else {
				test.log(LogStatus.FAIL, "Browse Error Messahe displayed : " + errorTxt2);
			}
			
			if(errorTxt3.equals("File is required.")) {
				test.log(LogStatus.PASS, "Without uploading file in browse button of Payment Receipt error message is displayed");
				test.log(LogStatus.PASS, "Error message displayed : <font color='red'>" + errorTxt3 + "</font>");
			}
			else {
				test.log(LogStatus.FAIL, "Browse Error Messahe displayed : " + errorTxt3);
			}
			
			Thread.sleep(5000);
			Locator.registrationLicenseNO().sendKeys(CoordinatorMethod.getRandomString());
			
			Thread.sleep(5000);
		 	Locator.calendar2().click();
			OneCommonMethod.selectCalendarDateFromInput(driver.get(), test, 
					Locator.calendar2(), 
					DistributerLocators.Calendar_NavigateToParentView(), 
					"30-10-2025" 
			);
			
			
			Thread.sleep(5000);
		 	Locator.calendar3().click();
			OneCommonMethod.selectCalendarDateFromInput(driver.get(), test, 
					Locator.calendar3(), 
					DistributerLocators.Calendar_NavigateToParentView(), 
					"30-12-2025" 
			);
			
			Thread.sleep(5000);
		 	Locator.calendar4().click();
			OneCommonMethod.selectCalendarDateFromInput(driver.get(), test, 
					Locator.calendar4(), 
					DistributerLocators.Calendar_NavigateToParentView(), 
					"30-01-2026" 
			);
			
			
			
			Thread.sleep(6000);
			Locator.brows2().click();
			Thread.sleep(4000);
			OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\Notice Module\\Upload Validations\\Test.pdf");
			
			Thread.sleep(6000);
			Locator.brows3().click();
			Thread.sleep(4000);
			OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\Notice Module\\Upload Validations\\Test.pdf");
			
			Thread.sleep(4000);
			Locator.isLifeTime().click();
			
			Thread.sleep(4000);
			Locator.closureBtn().click();
			String textM = Locator.message1().getText();
			Thread.sleep(4000);
			if(textM.equalsIgnoreCase("Activity Closed Successfully")) {
				test.log(LogStatus.PASS, "License Start Date is accepted");
				test.log(LogStatus.PASS, "License Expiry Date is accepted");
				test.log(LogStatus.PASS, "Closure Date is accepted");
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "File is uploaded successfully in New License Copy");
				Thread.sleep(3000);
				test.log(LogStatus.PASS, "File is uploaded successfully in Payment Receipt");
				Thread.sleep(4000);
				test.log(LogStatus.PASS, "Closure button is working fine");
				Thread.sleep(1500);
				test.log(LogStatus.PASS, "While clicking to Submitted to department button success message is displayed");
				Thread.sleep(2000);
				test.log(LogStatus.PASS, "Message displayed : " + textM);
			}
			else {
				test.log(LogStatus.FAIL, "Message displayed on clikcing to submit button : " + textM);
			}
			
			
		}
	 
	 public static void registrationEditTabs(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
		 WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(120));

			Thread.sleep(5000);
			Locator.clickRegistration().click();
			Thread.sleep(6000);
			Locator.EditBtn().click();
			Thread.sleep(5000);
			
			
			getDriver().findElement(By.xpath("//a[normalize-space()='License Request Details']")).click();
			Thread.sleep(5000);
			String BasicInfo = getDriver().findElement(By.xpath("//span[normalize-space()='Basic Information']")).getText();
			if(BasicInfo.equals("Basic Information"))
			{
				test.log(LogStatus.PASS,  "License Request Details tab is displayed"); 
			}
			else 
			{
				test.log(LogStatus.FAIL,  "License Request Details tab is not displayed"); 
			}
			
			
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//a[normalize-space()='RCP Team']")).click();
			Thread.sleep(5000);
			String TransReq = getDriver().findElement(By.xpath("//button[normalize-space()='Submitted to department']")).getText();

			if(TransReq.equals("Submitted to department"))
			{
				test.log(LogStatus.PASS,  "RCP Team tab is displayed"); 
			}
			else 
			{
				test.log(LogStatus.FAIL,  "RCP Team tab is not displayed"); 
			}
			
			
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//a[normalize-space()='SD Executer']")).click();
			Thread.sleep(5000);
			//get text is not added due to in both tab same get.text is there
			if(TransReq.equals("Submitted to department"))
			{
				test.log(LogStatus.PASS,  "SD Executor tab is displayed"); 
			}
			else 
			{
				test.log(LogStatus.FAIL,  "SD Executor tab is not displayed"); 
			}
			
			
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();
			Thread.sleep(5000);
			String DocRepo = getDriver().findElement(By.xpath("//span[normalize-space()='Document Repository']")).getText();
			if(DocRepo.equals("Document Repository"))
			{
				test.log(LogStatus.PASS,  "Document Section tab is displayed"); 
			}
			else 
			{
				test.log(LogStatus.FAIL,  "Document Section tab is not displayed"); 
			}


		}
	 public static void registrationEditDocumentRepositiory(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
		 WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(120));

			Thread.sleep(5000);
			Locator.clickRegistration().click();
			Thread.sleep(6000);
			Locator.EditBtn().click();
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//a[normalize-space()='Document Section']")).click();
			Thread.sleep(5000);
			Locator.plus2().click();
			Thread.sleep(5000);
			downloadDocuments(test);
			
	 }
	 public static void downloadDocuments(ExtentTest test) throws InterruptedException, IOException {
			
			
			// 1 - Logic for Notice Document
			Thread.sleep(3000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();

			Thread.sleep(500);
			try {
				if (Locator.AcknowledgementCopy().isDisplayed() && Locator.AcknowledgementCopy().isEnabled()) {
					Locator.AcknowledgementCopy().click();
					Thread.sleep(8000);
					File dir1 = new File("C:\\Users\\bilali\\Downloads");
					File[] allFilesNew = dir1.listFiles();
					Thread.sleep(3000);
					if (dirContents.length < allFilesNew.length) {
						Thread.sleep(5000);
						test.log(LogStatus.PASS, "Acknowledgement Copy downloaded successfully.");
					} else {
						Thread.sleep(5000);
						test.log(LogStatus.FAIL, "Acknowledgement Copy not downloaded");
					}
				} else {
					test.log(LogStatus.INFO, "Acknowledgement Copy - There is no document (button not clickable).");
				}
			} catch (Exception e) {
				test.log(LogStatus.INFO, "Acknowledgement Copy - There is No File Available");
			}

			// 2 - Logic for Translated Notice Document
			Thread.sleep(5000);
			File dir2 = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents2 = dir2.listFiles();

			Thread.sleep(500);
			try {
				if (Locator.PaymentReceipt().isDisplayed() && Locator.PaymentReceipt().isEnabled()) {
					Locator.PaymentReceipt().click();
					Thread.sleep(8000);
					File dirr = new File("C:\\Users\\bilali\\Downloads");
					File[] allFilesNew2 = dirr.listFiles();
					Thread.sleep(3000);
					if (dirContents2.length < allFilesNew2.length) {
						Thread.sleep(5000);
						test.log(LogStatus.PASS, "Payment Receipt File downloaded successfully.");
					} else {
						Thread.sleep(5000);
						test.log(LogStatus.FAIL, "Payment Receipt Document File is not downloaded.");
					}
				} else {
					test.log(LogStatus.INFO, "Payment Receipt - There is no document (button not clickable).");
				}
			} catch (Exception e) {
				test.log(LogStatus.INFO, "Payment Receipt - There is No File Available");
			}

			// 3 - Logic for Extension Application Acknowledgement
			Thread.sleep(8000);
			File dir3 = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents3 = dir3.listFiles();

			Thread.sleep(2200);
			try {
				if (All_ClientPortal_Locators.NoticeApplicationAcknowledgeDocument().isDisplayed() && All_ClientPortal_Locators.NoticeApplicationAcknowledgeDocument().isEnabled()) {
					All_ClientPortal_Locators.NoticeApplicationAcknowledgeDocument().click();
					Thread.sleep(10000);
					File dirrr = new File("C:\\Users\\bilali\\Downloads");
					File[] allFilesNew3 = dirrr.listFiles();
					Thread.sleep(3000);
					if (dirContents3.length < allFilesNew3.length) {
						Thread.sleep(5000);
						test.log(LogStatus.PASS, "Uploaded Final RC/License File is downloaded successfully");
					} else {
						Thread.sleep(5000);
						test.log(LogStatus.FAIL, "Uploaded Final RC/License File is not downloaded.");
					}
				} else {
					test.log(LogStatus.INFO, "Uploaded Final RC/License - There is no document (button not clickable).");
				}
			} catch (Exception e) {
				test.log(LogStatus.INFO, "Uploaded Final RC/License - There is No File Available");
			}


		}
	 
	 
	 public static void ExistingLicenseCountMatch( ExtentTest test,String Notice) throws InterruptedException, IOException
		{
		 Thread.sleep(2000);
		 getDriver().navigate().refresh();
		 
		 Thread.sleep(10000);
		Locator.clickRegistration().click();
			
		Thread.sleep(6000);
		Locator.ExistingLicesne().click();

		//int pendingAssignment = 0;
		if(Notice.equalsIgnoreCase("Pending Assignment"))
		{
			Thread.sleep(2000);
			String string_pendingAssignment = Locator.pendingAssignmentLicenseCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Pedning assignment box count :-"+string_pendingAssignment);
			//pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(3000);
			Locator.pendingAssignmentLicenseCount().click();
		}
		else if(Notice.equalsIgnoreCase("Pending Action"))
		{
			Thread.sleep(2000);
			String string_pendingAssignment = Locator.pendingActionLicenseCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Pedning Action  box count :-"+string_pendingAssignment);
			//pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(3000);
			Locator.pendingActionLicenseCount().click();
		}
		else if(Notice.equalsIgnoreCase("Overdue"))
		{
			Thread.sleep(2000);
			String string_pendingAssignment = Locator.OverdueLicenseCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Ovedrue  box count :-"+string_pendingAssignment);
			//pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(3000);
			Locator.OverdueLicenseCount().click();
			
		}
		else if(Notice.equalsIgnoreCase("Closed"))
		{
			Thread.sleep(2000);
			String string_pendingAssignment = Locator.ClosedLicenseCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Closed  box count :-"+string_pendingAssignment);
			//pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(3000);
			Locator.ClosedLicenseCount().click();
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
			

	 	// getDriver().navigate().refresh();
			Thread.sleep(3000);
			Locator.clickRegistration().click();
			
			Thread.sleep(6000);
			Locator.ExistingLicesne().click();

			Thread.sleep(3000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(3000);
			Locator.clickExistingLicenseExport().click();
			
		
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
			
		 Thread.sleep(3000);
	  getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(10000);
			Locator.clickRegistration().click();
			Thread.sleep(6000);
			Locator.ExistingLicesne().click();
			
				Thread.sleep(3000);
				Locator.SearchBox().sendKeys("Athani",Keys.ENTER);
			
				List<String> li=new ArrayList<String>();
		        
		       
		        li.add("Athani");
	       
		        
				List<String> filter=new ArrayList<String>();	
				
				filter.add("Athani");	
				
				
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
				
				if(Locator.ClearBtn().isEnabled())
				{
					Locator.ClearBtn().click();
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
		 Thread.sleep(3000);
	  getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(10000);
			Locator.clickRegistration().click();
			Thread.sleep(6000);
			Locator.ExistingLicesne().click();
//			Thread.sleep(1000);
//			Locator.pendingActionLicenseCount().click();

			
			Thread.sleep(6000);
			Locator.ExistingLicesneViewIcon().click();
			
			Thread.sleep(3000);
			String msg =Locator.ExistingLicesneDetailes().getText();
			
			if(msg.equalsIgnoreCase("Existing License Details"))
			{
				
				test.log(LogStatus.PASS, "Existing License Details open successfully:-" +msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "Existing License Details not open successfully:-" +msg);
			}
			Thread.sleep(3000);
			OneCommonMethod.scroll(getDriver(), 500);
			Locator.clickBack().click();
			
			
		}
		
		public static void ExistingLicenseDownload(ExtentTest test) throws InterruptedException, IOException
		{
			Thread.sleep(3000);
		 	getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(10000);
			Locator.clickRegistration().click();
			Thread.sleep(6000);
			Locator.ExistingLicesne().click();
			
//			Thread.sleep(2000);
//			Locator.pendingActionLicenseCount().click();
			
			
			
			Thread.sleep(3000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			
			Thread.sleep(3000);
			Locator.ExistingLicesneDownload().click();
			
			
			WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(120));
			
			Thread.sleep(5000);
//			wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad()));
			
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

	 
	 
	 
	 public static void StatutoryDocument(ExtentTest test) throws InterruptedException
	 {
		 getDriver().navigate().refresh();
		 Thread.sleep(10000);
		 
		 Locator.StatutoryDocumentButton().click();
		 Thread.sleep(3000);
		 		 
		 Locator.ClientDropdown().click();
		 Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Client Dropdown: Client dropdown is clickable.");

		 
		 Locator.SelectedClient().click();
		 Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Client Dropdown Selection: User is able to select Client from the dropdown.");

		 
		 Locator.ComplianceDropdown().click();
		 Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Compliance type Dropdown: Compliance type dropdown is clickable.");

		 
		 Locator.SelectedComplianceType().click();
		 Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Compliance type Dropdown Selection: User is able to select Compliance type from the dropdown");
	    	
		 
		 Locator.ActDropdown().click();
		 Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Act Dropdown: Act dropdown is clickable.");

		 
		 Locator.SelectedAct().click();
		 Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Act Dropdown Selection : User is able to select the Act from the dropdown");
	    	
		 
		 Locator.YearDropdown().click();
		 Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Year Dropdown: Year dropdown is clickable.");

		 
		 Locator.SelectedYear().click();
		 Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Year Dropdown Selection : User is able to select the Year from the dropdown.");
	 
		 
		 Locator.PeriodDropdown().click();
		 Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Period Dropdown: Period dropdown is clickable.");

		 
		 Locator.SelectedPeriod().click();
		 Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Period Dropdown Selection : User is able to select the Period from the dropdown.");

		 
		 Locator.ApplyButon().click();
		 Thread.sleep(3000);
		 test.log(LogStatus.PASS, "Apply Button : Apply Button is working fine.");

		 
		 Locator.CheckBoxAll().click();
		 Thread.sleep(3000);
		 
		 Thread.sleep(5000);
		 OneCommonMethod.validateFileDownloadDynamic(
	    		    driver.get(),
	    		    test,
	    		    Locator.BulkDownload(),   
	    		    "All Statutory Zip Document File Downloaded"   
	    		);
	    	
	    	Thread.sleep(5000);
	    	OneCommonMethod.validateFileDownloadDynamic(
	    		    driver.get(),
	    		    test,
	    		    Locator.SingleDownload(),   
	    		    "Statutory Document File Downloaded"   
	    		);
		 
		 	    	
	    	Locator.ViewFirst().click();
	    	Thread.sleep(5000);
	    	
	    	Locator.ViewSecond().click();
	    	Thread.sleep(5000);
	    	
	    	Locator.ViewSecondPopUpClose().click();
	    	Thread.sleep(5000);
	    	
	    	Locator.ViewMainPopUpClose().click();
	    	Thread.sleep(5000);
	    	test.log(LogStatus.PASS, "File View : File Viewed Successfully.");
	    		    	
	    	Locator.ClearButon().click();
	    	Thread.sleep(5000);
	    	test.log(LogStatus.PASS, "Clear Button : Clear Button is working fine.");
	    	
	 }
	 
	 

	 
	 
	 


}
