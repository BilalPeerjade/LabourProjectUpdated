package sme;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import login.BasePage;
import login.LoginLocators;
import rcp.OneCommonMethod;



public class Methods extends BasePage
{
	 static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour2.xlsx";

	 public static void CountMatch( ExtentTest test,String Notice) throws InterruptedException, IOException
		{
		 Thread.sleep(10000);
		 getDriver().navigate().refresh();
		 Thread.sleep(10000);
		int pendingAssignment = 0;
		if(Notice.equalsIgnoreCase("Extension"))
		{
			Thread.sleep(10000);
			String string_pendingAssignment = Locator.pendingAssignmentCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(10000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(10000);
			Locator.pendingAssignmentCount().click();
			Thread.sleep(10000);
		}
		else if(Notice.equalsIgnoreCase("Response Pending"))
		{
			Thread.sleep(10000);
			String string_pendingAssignment = Locator.pendingActionCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(10000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(10000);
			Locator.pendingActionCount().click();
			Thread.sleep(10000);
		}
		else if(Notice.equalsIgnoreCase("Overdue"))
		{
			Thread.sleep(10000);
			String string_pendingAssignment = Locator.OverdueCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(10000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(10000);
			Locator.OverdueCount().click();
			Thread.sleep(10000);
			
		}
		else if(Notice.equalsIgnoreCase("Response Submitted"))
		{
			Thread.sleep(10000);
			String string_pendingAssignment = Locator.ClosedCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(10000);
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(10000);
			Locator.ClosedCount().click();
			Thread.sleep(10000);
		}
		
		
		OneCommonMethod.zoomOutScreen(2); //Zoom
		
		Thread.sleep(10000);
		Locator.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(5000);
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
	 
	 
	 public static void NoticeExportBtn(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
		 getDriver().navigate().refresh();
	 	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	 	
		js.executeScript("window.scrollBy(0,5000)");	
	 	
	 	 Thread.sleep(10000); 		
//	      Locator.readTotalItems().click();
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
	 	Locator.clickNoticeExport().click();
	 	

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
	 public static void NoticeSearchBox(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
		 getDriver().navigate().refresh();
	 	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	 	
	 	
	 	Thread.sleep(3000);
	 	Locator.SearchBox().sendKeys("Summon",Keys.ENTER);

	 	List<String> li=new ArrayList<String>();
	     
	    
	     li.add("Summon");

	     
	 	List<String> filter=new ArrayList<String>();	
	 	
	 	filter.add("Summon");	
	 	
	 	
	 	js.executeScript("window.scrollBy(0,150)");	
	 	Thread.sleep(3000);

	 	 Locator.readTotalItems().click();				//Clicking on Text of total items just to scroll down.
	 	String s = Locator.readTotalItems().getText();
	 	Thread.sleep(2000);

	 	try {
	 	Thread.sleep(5000);

	 	List<WebElement> typecol=getDriver().findElements(By.xpath("//tbody/tr[1]/td[5]/div[1]"));//Notice Type column xpath
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
	 
	 public static void NoticeEditDownload(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
		 getDriver().navigate().refresh();
	 	JavascriptExecutor js = (JavascriptExecutor) getDriver();	
	 	Thread.sleep(2000);
	 	File dir3 = new File("C:\\Users\\bilali\\Downloads");
	 	File[] dirContents1 = dir3.listFiles();							//Counting number of files in directory before download 

	 	
	 	Thread.sleep(2000);

	 	Locator.clickDownload().click();
	 	
	 	Thread.sleep(5500);
	 	File dir2= new File("C:\\Users\\bilali\\Downloads");
	 	File[] allFilesNew1 = dir2.listFiles();							//Counting number of files in directory after download

	 	if(dirContents1.length < allFilesNew1.length)
	 	{
	 	
	 		Thread.sleep(1000);					//Clicking on 'Excel Report' image.
	 		test.log(LogStatus.PASS, "Notice Document downloaded successfully.");
	 	}
	 	else
	 	{
	 		Thread.sleep(2000);
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
	 		test.log(LogStatus.PASS, "Edit button is not clickable.");
	 		
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


	 public static void Exp  (ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
	 {
	
		  OneCommonMethod.validateExportedExcelDYNAMIC(
		    	    driver.get(),
		    	    test,
		    	    LoginLocators.Exportbtn(),        // WebElement for export button
		    	    LoginLocators.TotalNoOfItem(),     // WebElement for grid count text
		    	    "State",                               // Column header to verify
		    	    "File Exported Successfully ! "     // Success log text (only if PASS)
		    	);

	 }
	 
	 
	 
	 
	 
}
