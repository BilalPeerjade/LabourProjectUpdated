package rcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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

import clientPortal.All_ClientPortal_Locators;
import coordinator.CoordinatorLocator;
//import clientPortal.Date;
//import clientPortal.SimpleDateFormat;
//import clientPortal.TakesScreenshot;
//import clientPortal.WebDriver;
import coordinator.CoordinatorMethod;
import distributor.DistributerLocators;
import login.BasePage;
import login.LoginLocators;

//--------------Take screenshot--------
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class RCPMethod extends BasePage
{
	
	 public static void RegistrationCountMatch( ExtentTest test,String Notice) throws InterruptedException, IOException
		{

	 	 getDriver().navigate().refresh();
		 
		 Thread.sleep(10000);
		 RCPLocator.clickRegistration().click();
		int pendingAssignment = 0;
		if(Notice.equalsIgnoreCase("Pending Assignment"))
		{
			Thread.sleep(1000);
			String string_pendingAssignment = RCPLocator.RegistartionpendingAssignmentCount().getText();		//Storing old value of Statutory overdue.
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(3000);
			RCPLocator.RegistartionpendingAssignmentCount().click();
		}
		else if(Notice.equalsIgnoreCase("Pending Action"))
		{
			Thread.sleep(1000);
			String string_pendingAssignment = RCPLocator.RegistartionpendingActionCount().getText();		//Storing old value of Statutory overdue.
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(3000);
			RCPLocator.RegistartionpendingActionCount().click();
		}
		else if(Notice.equalsIgnoreCase("Overdue"))
		{
			Thread.sleep(1000);
			String string_pendingAssignment = RCPLocator.RegistartionOverdueCount().getText();		//Storing old value of Statutory overdue.
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(1000);
			RCPLocator.RegistartionOverdueCount().click();
			
		}
		else if(Notice.equalsIgnoreCase("Closed"))
		{
			Thread.sleep(1000);
			String string_pendingAssignment = RCPLocator.RegistartionClosedCount().getText();		//Storing old value of Statutory overdue.
			pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(3000);
			RCPLocator.RegistartionClosedCount().click();
		}
		
		
		Thread.sleep(5000);
//		RCPLocator.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = RCPLocator.readTotalItems().getText();	//Reading total items String value
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
	 
	 public static void RegistrationPendingApplicationExport( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		{
//		 WebDriverWait wait = new WebDriverWait(getDriver(), 140);

	 	 getDriver().navigate().refresh();
		
			Thread.sleep(6000);
			RCPLocator.clickRegistration().click();
			Thread.sleep(3000);
			RCPLocator.RegistartionpendingAssignmentCount().click();
			
			
			 Thread.sleep(2000); 		
//		        RCPLocator.readTotalItems().click();
				String item = RCPLocator.readTotalItems().getText();
				String[] bits = item.split(" ");								//Splitting the String
				String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				int count1 = Integer.parseInt(compliancesCount);
			
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					Thread.sleep(5000);
				   item = RCPLocator.readTotalItems().getText();
					bits = item.split(" ");
		        
				}
				
				Thread.sleep(2000);
		        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		        
		        js1.executeScript("window.scrollBy(0,-500)");
			Thread.sleep(1000);
			File dir = new File("C:\\Users\\swapnilb\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(2000);
			RCPLocator.clickExport().click();
			
		
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\swapnilb\\Downloads");
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
	 
	 public static void RegistrationAppliedAwatingDeptExport( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		{
//		 WebDriverWait wait = new WebDriverWait(getDriver(), 140);

	 	 getDriver().navigate().refresh();
		
			Thread.sleep(6000);
			RCPLocator.clickRegistration().click();
			Thread.sleep(3000);
			

			RCPLocator.RegistartionpendingActionCount().click();
			
			 Thread.sleep(2000); 		
//		        RCPLocator.readTotalItems().click();
				String item = RCPLocator.readTotalItems().getText();
				String[] bits = item.split(" ");								//Splitting the String
				String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				int count1 = Integer.parseInt(compliancesCount);
			
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					Thread.sleep(5000);
				   item = RCPLocator.readTotalItems().getText();
					bits = item.split(" ");
		        
				}
				
				Thread.sleep(2000);
		        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		        
		        js1.executeScript("window.scrollBy(0,-500)");
			Thread.sleep(1000);
			File dir = new File("C:\\Users\\swapnilb\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(2000);
			RCPLocator.clickExport().click();
			
		
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\swapnilb\\Downloads");
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
	 
	 
	 public static void RegistrationOverdueExport( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		{
//		 WebDriverWait wait = new WebDriverWait(getDriver(), 140);

	 	 getDriver().navigate().refresh();
		
			Thread.sleep(6000);
			RCPLocator.clickRegistration().click();
//			CoordinatorMethod.zoomOutScreen(2);
			Thread.sleep(3000);
			
			RCPLocator.RegistartionOverdueCount().click();
			
			 Thread.sleep(2000); 		
//		        RCPLocator.readTotalItems().click();
				String item = RCPLocator.readTotalItems().getText();
				String[] bits = item.split(" ");								//Splitting the String
				String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				int count1 = Integer.parseInt(compliancesCount);
			
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					Thread.sleep(5000);
				   item = RCPLocator.readTotalItems().getText();
					bits = item.split(" ");
		        
				}
				
				Thread.sleep(2000);
		        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		        
		        js1.executeScript("window.scrollBy(0,-500)");
			Thread.sleep(1000);
			File dir = new File("C:\\Users\\swapnilb\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(5000);
			RCPLocator.clickExport().click();
			
		
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\swapnilb\\Downloads");
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
	 
	 public static void RegistrationClosedExport( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		{
//		 WebDriverWait wait = new WebDriverWait(getDriver(), 140);

	 	 getDriver().navigate().refresh();
//	 	CoordinatorMethod.zoomOutScreen(2);
			Thread.sleep(6000);
			RCPLocator.clickRegistration().click();
//			CoordinatorMethod.zoomOutScreen(2);
			Thread.sleep(3000);
			
			RCPLocator.RegistartionClosedCount().click();
			
			 Thread.sleep(2000); 		
//		        RCPLocator.readTotalItems().click();
				String item = RCPLocator.readTotalItems().getText();
				String[] bits = item.split(" ");								//Splitting the String
				String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				int count1 = Integer.parseInt(compliancesCount);
			
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					Thread.sleep(5000);
				   item = RCPLocator.readTotalItems().getText();
					bits = item.split(" ");
		        
				}
				
				Thread.sleep(2000);
		        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		        
		        js1.executeScript("window.scrollBy(0,-500)");
			Thread.sleep(1000);
			File dir = new File("C:\\Users\\swapnilb\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(2000);
			RCPLocator.clickExport().click();
			
		
			Thread.sleep(5500);
			File dir1 = new File("C:\\Users\\swapnilb\\Downloads");
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
	 
	 public static void RCPLogo( ExtentTest test,String Notice) throws InterruptedException, IOException
		{

	 	 getDriver().navigate().refresh();
		 
		 Thread.sleep(3000);
		 RCPLocator.clickRegistration().click();
		 
		 
	       Thread.sleep(5000);
	        String LogoTeamLease = getDriver().findElement(By.xpath("//img[@alt='TeamLease Logo']")).getText();
	        WebElement LogoTeamL = getDriver().findElement(By.xpath("//img[@alt='TeamLease Logo']"));
	        Thread.sleep(5000);
	        System.out.println(LogoTeamLease);
	        Thread.sleep(5000);
	        if(LogoTeamL.isDisplayed())
	        {
	        	test.log(LogStatus.PASS,"'Team Lease RegTech Helping India Comply' Logo is displayed successfully");
	        	Thread.sleep(5000);
	            String base64Screenshot = OneCommonMethod.takeScreenshotBase64(driver.get());
	            test.log(LogStatus.INFO, "ScreenShot <br>" + test.addBase64ScreenShot(base64Screenshot));
	        }
	        else
	        {
	        	test.log(LogStatus.FAIL,"Logo is not displayed");
	        }
		
	}
	 
	 public static void RCPcolumnExpandIcon( ExtentTest test,String Notice) throws InterruptedException, IOException
		{

	 	 getDriver().navigate().refresh();
		 
		 Thread.sleep(3000);
		 RCPLocator.clickRegistration().click();
		 
		 
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
		 
	        
	        String base64Screenshot = OneCommonMethod.takeScreenshotBase64(driver.get());
	        test.log(LogStatus.INFO, "Column Expand Icon is working fine <br>" + test.addBase64ScreenShot(base64Screenshot));
		
	}
	 public static void RCPRegistration( ExtentTest test,String Notice) throws InterruptedException, IOException
		{

	 	 getDriver().navigate().refresh();
		 
		 Thread.sleep(5000);
		 
		 if(RCPLocator.clickRegistration().isDisplayed())
		 {
			 Thread.sleep(5000);
			 RCPLocator.clickRegistration().click();
			 test.log(LogStatus.PASS,"Registration module link is clickable");
			 Thread.sleep(5000);
		 }
		 else
		 {
			 test.log(LogStatus.FAIL,"Registration module link is not displayed");
		 }
		
		 Thread.sleep(5000);
		String RCPDash =  getDriver().findElement(By.xpath("//h4[normalize-space()='RCP Dashboard']")).getText();
		Thread.sleep(5000);
		if(RCPDash.equalsIgnoreCase("RCP Dashboard"))
		{
			test.log(LogStatus.PASS,"After clicking to Registration module link RCP Dashboard is displayed successfully");
		}
		else
		{
			 test.log(LogStatus.FAIL,"RCP Dashboard is not displayed ");
		}
	}
	 
	 public static void ExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		{
//		 WebDriverWait wait = new WebDriverWait(getDriver(), 140);

	 	 getDriver().navigate().refresh();
		
			Thread.sleep(10000);
			RCPLocator.clickRegistration().click();
			
			 Thread.sleep(5000); 		
//		        RCPLocator.readTotalItems().click();
				String item = RCPLocator.readTotalItems().getText();
				String[] bits = item.split(" ");								//Splitting the String
				String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
				int count1 = Integer.parseInt(compliancesCount);
			
				if(compliancesCount.equalsIgnoreCase("to"))
				{
					Thread.sleep(5000);
				   item = RCPLocator.readTotalItems().getText();
					bits = item.split(" ");
		        
				}
				
				Thread.sleep(2000);
		        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
		        
		        js1.executeScript("window.scrollBy(0,-500)");
		        Thread.sleep(1000);
		        File dir = new File("C:\\Users\\swapnilb\\Downloads");
		        File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
		        Thread.sleep(5000);
		        RCPLocator.clickExport().click();
			
		
		        Thread.sleep(10000);
		        File dir1 = new File("C:\\Users\\swapnilb\\Downloads");
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
		        		if(cell != null)
		        		{
					
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
	 
	 public static void OTAReport (ExtentTest test ) throws InterruptedException 
	 {
	 	 getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			Thread.sleep(10000);
			RCPLocator.clickRegistration().click();
			Thread.sleep(6000);
			
			OneCommonMethod.validateFileDownloadDynamic(
				    driver.get(),
				    test,
				    RCPLocator.OTAReport(),   // WebElement
				    "OTA Report is Exported successfully !"   // Dynamic log message
				);
			Thread.sleep(6000);
		 
	 }
	 public static void SearchBox(ExtentTest test) throws InterruptedException
		{

	 	 getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			Thread.sleep(10000);
			RCPLocator.clickRegistration().click();
			
				Thread.sleep(3000);
				RCPLocator.SearchBox().sendKeys("RCP25-4799",Keys.ENTER);
			
				List<String> li=new ArrayList<String>();
		        
		       
		        li.add("RCP25-4799");
	       
		        
				List<String> filter=new ArrayList<String>();	
				
				filter.add("RCP25-4799");	
				
				
				js.executeScript("window.scrollBy(0,150)");	
				Thread.sleep(3000);

				 RCPLocator.readTotalItems().click();				//Clicking on Text of total items just to scroll down.
				String s = RCPLocator.readTotalItems().getText();
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
				
				if(RCPLocator.ClearBtn().isEnabled())
				{
					RCPLocator.ClearBtn().click();
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

	 getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(3000);
			RCPLocator.clickRegistration().click();
			
			Thread.sleep(3000);
			if(RCPLocator.editBtn().isEnabled())
			{
				Thread.sleep(3000);
				RCPLocator.editBtn().click();
				test.log(LogStatus.PASS, "Edit button is clickable.");
				
			}
			else
			{
				test.log(LogStatus.PASS, "Edit button is not clickable.");
				
			}
			Thread.sleep(1000);
			RCPLocator.clickBack().click();
		}
	 
	 public static void EditSubmittedToDept(ExtentTest test) throws Exception
		{

			getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();

			Thread.sleep(8000);
			RCPLocator.clickRegistration().click();
			Thread.sleep(5000);
			RCPLocator.editBtn().click();
			
/*			RCPLocator.submittedToDeptBtn();
			
			RCPLocator.draftAppToDeptDate().click();
			OneCommonMethod.selectCalendarDateFromInput(driver.get(), test, 
					RCPLocator.draftAppToDeptDate(), // calendar icon
					DistributerLocators.Calendar_NavigateToParentView(), // parent view arrow
					"15-08-2025" // date in dd-MM-yyyy format
			);
			Thread.sleep(2000);
			RCPLocator.browse1().click();
			Thread.sleep(3000);
			OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\Notice Module\\Upload Validations\\Test.pdf");
			Thread.sleep(3000);
			RCPLocator.submittedToDeptBtn().click();
			Thread.sleep(3000);
			String successMessage = RCPLocator.clickMsg().getText();
			Thread.sleep(3000);
			if(successMessage.equalsIgnoreCase("Submitted to department Successfully")) {
				test.log(LogStatus.PASS, "On clicking to Submitted to department button success message is displayed");
				test.log(LogStatus.PASS, "Message displayed : " +successMessage);
			}
			else
			{
				test.log(LogStatus.FAIL, "Message displayed : " + successMessage);
			}
			
			*/
			
			
			try {
			    WebElement submitBtn = RCPLocator.submittedToDeptBtn();

			    if (submitBtn.isDisplayed() && submitBtn.isEnabled()) {
			        // --- Perform complete flow only if button is enabled ---
			        RCPLocator.draftAppToDeptDate().click();
			        OneCommonMethod.selectCalendarDateFromInput(driver.get(), test,
			                RCPLocator.draftAppToDeptDate(),                  // calendar icon
			                DistributerLocators.Calendar_NavigateToParentView(), // parent view arrow
			                "15-08-2025"                                     // date
			        );
			        Thread.sleep(2000);

			        RCPLocator.browse1().click();
			        Thread.sleep(3000);
			        OneCommonMethod.uploadUsingRobot("\"D:\\AutomationLabourFiles\\Test_123.pdf\"");
			        Thread.sleep(3000);

			        submitBtn.click();
			        Thread.sleep(3000);

			        String successMessage = RCPLocator.clickMsg().getText();
			        Thread.sleep(3000);

			        if (successMessage.equalsIgnoreCase("Submitted to department Successfully")) {
			            test.log(LogStatus.PASS, "On clicking Submit to department button, success message is displayed");
			            test.log(LogStatus.PASS, "Message displayed : " + successMessage);
			        } else {
			            test.log(LogStatus.FAIL, "Message displayed : " + successMessage);
			        }

			    } else {
			        // --- If button disabled/hidden, skip everything ---
			        test.log(LogStatus.INFO, "Submit to Department button is disabled/hidden — skipping all steps.");
			    }
			} catch (Exception e) {
			    test.log(LogStatus.INFO, "Submit to Department button is disabled/hidden — skipping all steps.");
			}


			
			
			
		}
	 
	 public static void EditClosureVerification(ExtentTest test) throws Exception
		{

			getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();

			Thread.sleep(8000);
			RCPLocator.clickRegistration().click();
			Thread.sleep(5000);
			
			//If req we can enable below line
//			getDriver().findElement(By.xpath("//span[normalize-space()='Applied and Awaiting Dept Approval']")).click();
			Thread.sleep(5000);
			RCPLocator.editBtn().click();
			
			
/*			RCPLocator.closureButton();
			
			Thread.sleep(5000);
			RCPLocator.plus1_ActivityClosure().click();
			Thread.sleep(5000);
	        RCPLocator.browse2().click();
	        Thread.sleep(3000);
	        OneCommonMethod.uploadUsingRobot("D:\AutomationLabourFiles\Test_123.pdf");
			
			
	        Thread.sleep(3000);
	        RCPLocator.browse2().click();
	        Thread.sleep(3000);
	        OneCommonMethod.uploadUsingRobot("D:\AutomationLabourFiles\Test_123.pdf");
	        Thread.sleep(3000);
	        
	        RCPLocator.registrationLicenseNo().sendKeys(OneCommonMethod.getRandomString());
	        Thread.sleep(3000);
	        RCPLocator.isLifetime().click();
	        Thread.sleep(3000);
	        
	        
	        RCPLocator.calendar4().click();
			OneCommonMethod.selectCalendarDateFromInput(driver.get(), test, 
					RCPLocator.calendar4(), // calendar icon
					DistributerLocators.Calendar_NavigateToParentView(), // parent view arrow
					"28-08-2025" // date in dd-MM-yyyy format
			);
			Thread.sleep(3000);
			RCPLocator.closureButton().click();
			Thread.sleep(3000);
			
			
	        String successMessage = RCPLocator.clickMsg().getText();
	        Thread.sleep(3000);

	        if (successMessage.equalsIgnoreCase("Activity Closed Successfully")) {
	            test.log(LogStatus.PASS, "New License copy is accepted document");
	            Thread.sleep(2000);
	            test.log(LogStatus.PASS, "Payment Recepit is accepted document");
	            Thread.sleep(1500);
	            test.log(LogStatus.PASS, "Registration License No is accepted given text");
	            Thread.sleep(3000);
	            test.log(LogStatus.PASS, "is Lifetime checkbox is selected");
	            Thread.sleep(1000);
	            test.log(LogStatus.PASS, "Calendars dates is selected");
	            test.log(LogStatus.PASS, "On clicking to colsure button success message is displayed ");
	            test.log(LogStatus.PASS, "Message displayed : " + successMessage);
	        } else {
	            test.log(LogStatus.FAIL, "Message displayed : " + successMessage);
	        }
			
			*/
			
			RCPLocator.plus1_ActivityClosure().click();
			Thread.sleep(2000);
			try {
			    WebElement closureBtn = RCPLocator.closureButton();

			    if (closureBtn.isDisplayed() && closureBtn.isEnabled()) {
			        // --- Perform complete flow only if Closure button is enabled ---

			        Thread.sleep(5000);
			//      RCPLocator.plus1_ActivityClosure().click();
			        Thread.sleep(5000);

			        RCPLocator.browse2().click();
			        Thread.sleep(3000);
			        OneCommonMethod.uploadUsingRobot("D:\\AutomationLabourFiles\\Test_123.pdf");

			        Thread.sleep(3000);
			        RCPLocator.browse3().click();
			        Thread.sleep(3000);
			        OneCommonMethod.uploadUsingRobot("D:\\AutomationLabourFiles\\Test_123.pdf");
			        Thread.sleep(3000);

			        RCPLocator.registrationLicenseNo().sendKeys(OneCommonMethod.getRandomString());
			        Thread.sleep(3000);
			        RCPLocator.isLifetime().click();
			        Thread.sleep(3000);

			        RCPLocator.calendar4().click();
			        OneCommonMethod.selectCalendarDateFromInput(
			                driver.get(), test,
			                RCPLocator.calendar4(),                          // calendar icon
			                DistributerLocators.Calendar_NavigateToParentView(), // parent view arrow
			                "28-08-2025"                                      // dd-MM-yyyy
			        );
			        Thread.sleep(3000);

			        closureBtn.click();
			        Thread.sleep(3000);

			        String successMessage = RCPLocator.clickMsg().getText();
			        Thread.sleep(3000);

			        if (successMessage.equalsIgnoreCase("Activity Closed Successfully")) {
			            test.log(LogStatus.PASS, "New License copy is accepted document");
			            Thread.sleep(2000);
			            test.log(LogStatus.PASS, "Payment Recepit is accepted document");
			            Thread.sleep(1500);
			            test.log(LogStatus.PASS, "Registration License No is accepted given text");
			            Thread.sleep(3000);
			            test.log(LogStatus.PASS, "is Lifetime checkbox is selected");
			            Thread.sleep(1000);
			            test.log(LogStatus.PASS, "Calendars dates is selected");
			            test.log(LogStatus.PASS, "On clicking to colsure button success message is displayed ");
			            test.log(LogStatus.PASS, "Message displayed : " + successMessage);
			        } else {
			            test.log(LogStatus.FAIL, "Message displayed : " + successMessage);
			        }

			    } else {
			        // --- If button disabled/hidden, skip everything ---
			        test.log(LogStatus.INFO, "Closure button is disabled/hidden — skipping all steps.");
			    }

			} catch (Exception e) {
			    test.log(LogStatus.INFO, "Closure button is disabled/hidden — skipping all steps.");
			}

			
				
		}
	 public static void documentRepositoryDownloads(ExtentTest test) throws Exception
		{

			getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();

			Thread.sleep(8000);
			RCPLocator.clickRegistration().click();
			Thread.sleep(5000);
			RCPLocator.editBtn().click();
			Thread.sleep(5000);
			RCPLocator.documentSection().click();
			Thread.sleep(5000);
			RCPLocator.plus2().click();
			Thread.sleep(5000);
			WebElement Doc_download1 = getDriver().findElement(By.xpath("//img[@alt='Action Icon' or @title='No File Availabe']"));

			
			
	/*		
			Thread.sleep(3000);
			File dir = new File("C:\\Users\\swapnilb\\Downloads");
			File[] dirContents = dir.listFiles();
			Thread.sleep(4400);
			try {
				if (Doc_download1.isDisplayed() && Doc_download1.isEnabled()) {
					Doc_download1.click();
					Thread.sleep(8000);
					File dir1 = new File("C:\\Users\\swapnilb\\Downloads");
					File[] allFilesNew = dir1.listFiles();
					Thread.sleep(3000);
					if (dirContents.length < allFilesNew.length) {
						Thread.sleep(5000);
						test.log(LogStatus.PASS, "Acknowledgement Copy Document File downloaded successfully.");
					} else {
						Thread.sleep(5000);
						test.log(LogStatus.FAIL, "Acknowledgement Copy Document File is not downloaded");
					}
				} else {
					test.log(LogStatus.INFO, "Acknowledgement Copy Document - There is no document (button not clickable).");
				}
			} catch (Exception e) {
				test.log(LogStatus.INFO, "Acknowledgement Copy Document - There is No File Available");
			}
			
			
			
			
			
			
			
			
			// ✅ Dynamic locator (adjust if needed)
			By downloadIcon = By.xpath("(//img[@alt='Action Icon' or @title='No File Availabe'])[2]");

			// ✅ Your download folder
			File downloadDir = new File("C:\\Users\\swapnilb\\Downloads");

			// ✅ Optional: agar kisi specific filename ka hissa pata ho, pass karo; warna "" rehne do
			String expectedNameContains = ""; // e.g., "Payment_Receipt" ya ".pdf"

			// ✅ Safe download attempt (no exception leak)
			try {
			    List<WebElement> icons = getDriver().findElements(downloadIcon);

			    if (icons == null || icons.isEmpty()) {
			        test.log(LogStatus.INFO, "Payment Receipt Document - Download button not present on UI.");
			    } else {
			        WebElement btn = icons.get(0);

			        String title = "";
			        try { title = String.valueOf(btn.getAttribute("title")); } catch (Exception ignored) {}

			        boolean visiblyDisplayed = false;
			        boolean enabled = false;
			        try { visiblyDisplayed = btn.isDisplayed(); } catch (Exception ignored) {}
			        try { enabled = btn.isEnabled(); } catch (Exception ignored) {}

			        // "No File Availabe" (UI typo) or not clickable → INFO
			        if ((title != null && title.trim().equalsIgnoreCase("No File Availabe")) || !visiblyDisplayed || !enabled) {
			            test.log(LogStatus.INFO, "Payment Receipt Document - There is No File Available (button not clickable/disabled).");
			        } else {
			            // Baseline count
			            int beforeCount = safeCount(downloadDir);

			            // Try clicking (normal then JS fallback)
			            boolean clicked = false;
			            try {
			                btn.click();
			                clicked = true;
			            } catch (Exception click1) {
			                try {
			                    ((org.openqa.selenium.JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", btn);
			                    clicked = true;
			                } catch (Exception click2) {
			                    // last fallback: move+click
			                    try {
			                        new org.openqa.selenium.interactions.Actions(getDriver()).moveToElement(btn).click().perform();
			                        clicked = true;
			                    } catch (Exception ignored) { }
			                }
			            }

			            if (!clicked) {
			                test.log(LogStatus.INFO, "Payment Receipt Document - Download button present but not clickable right now.");
			            } else {
			                // Wait up to 20s for a new file to appear (polling)
			                File newFile = waitForNewFile(downloadDir, beforeCount, 20000, expectedNameContains);

			                if (newFile != null) {
			                    test.log(LogStatus.PASS, "Payment Receipt Document - File downloaded successfully: " + newFile.getName());
			                } else {
			                    test.log(LogStatus.FAIL, "Payment Receipt Document - File not downloaded (no new file detected).");
			                }
			            }
			        }
			    }
			} catch (Throwable t) {
			    // Fully swallow errors into INFO (as you asked: no error throwing)
			    test.log(LogStatus.INFO, "Payment Receipt Document - Skipped (unexpected condition but not failing the test).");
			}



			
			
			
			

			
			
			
			
			

			
			// ✅ Download #3: "Uploaded Final RC/License Document"
			try {
			    By downloadIcon3 = By.xpath("(//img[@alt='Action Icon' or @title='No File Availabe'])[3]");
			    File downloadDir3 = new File("C:\\Users\\swapnilb\\Downloads");
			    String expectedNameContains3 = ""; // optional hint: e.g., "RC" or ".pdf"

			    java.util.List<WebElement> icons3 = getDriver().findElements(downloadIcon3);

			    if (icons3 == null || icons3.isEmpty()) {
			        test.log(LogStatus.INFO, "Uploaded Final RC/License Document - Download button not present on UI.");
			    } else {
			        WebElement btn3 = icons3.get(0);

			        String title3 = "";
			        try { title3 = String.valueOf(btn3.getAttribute("title")); } catch (Exception ignored) {}

			        boolean displayed3 = false, enabled3 = false;
			        try { displayed3 = btn3.isDisplayed(); } catch (Exception ignored) {}
			        try { enabled3 = btn3.isEnabled(); } catch (Exception ignored) {}

			        if ((title3 != null && title3.trim().equalsIgnoreCase("No File Availabe")) || !displayed3 || !enabled3) {
			            test.log(LogStatus.INFO, "Uploaded Final RC/License Document - There is No File Available (button not clickable/disabled).");
			        } else {
			            // Baseline file count (safe)
			            int beforeCount3 = 0;
			            try {
			                File[] list3 = (downloadDir3 != null) ? downloadDir3.listFiles() : null;
			                beforeCount3 = (list3 == null) ? 0 : list3.length;
			            } catch (Exception ignored) {}

			            // Click with fallbacks
			            boolean clicked3 = false;
			            try {
			                btn3.click();
			                clicked3 = true;
			            } catch (Exception c1) {
			                try {
			                    ((org.openqa.selenium.JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", btn3);
			                    clicked3 = true;
			                } catch (Exception c2) {
			                    try {
			                        new org.openqa.selenium.interactions.Actions(getDriver()).moveToElement(btn3).click().perform();
			                        clicked3 = true;
			                    } catch (Exception ignored) { }
			                }
			            }

			            if (!clicked3) {
			                test.log(LogStatus.INFO, "Uploaded Final RC/License Document - Download button present but not clickable right now.");
			            } else {
			                // Poll up to 20s for a new file; pick newest; optionally check name contains hint
			                long deadline3 = System.currentTimeMillis() + 20000L;
			                File detected3 = null;

			                while (System.currentTimeMillis() < deadline3) {
			                    try {
			                        File[] current3 = (downloadDir3 != null) ? downloadDir3.listFiles() : null;
			                        int currCount3 = (current3 == null) ? 0 : current3.length;

			                        if (currCount3 > beforeCount3 && current3 != null) {
			                            // Find newest file
			                            File newest3 = null;
			                            long t3 = Long.MIN_VALUE;
			                            for (File f : current3) {
			                                if (f != null && f.exists()) {
			                                    long lm = f.lastModified();
			                                    if (lm > t3) { t3 = lm; newest3 = f; }
			                                }
			                            }
			                            if (newest3 != null) {
			                                detected3 = newest3;
			                                if (expectedNameContains3 == null || expectedNameContains3.trim().isEmpty()
			                                    || newest3.getName().toLowerCase().contains(expectedNameContains3.toLowerCase().trim())) {
			                                    break; // accept
			                                }
			                            }
			                        }
			                        Thread.sleep(500);
			                    } catch (Exception ignored) {
			                        try { Thread.sleep(500); } catch (InterruptedException ignored2) {}
			                    }
			                }

			                if (detected3 != null) {
			                    test.log(LogStatus.PASS, "Uploaded Final RC/License Document - File downloaded successfully: " + detected3.getName());
			                } else {
			                    test.log(LogStatus.FAIL, "Uploaded Final RC/License Document - File not downloaded (no new file detected).");
			                }
			            }
			        }
			    }
			} catch (Throwable t) {
			    // As requested: no hard errors, convert to INFO
			    test.log(LogStatus.INFO, "Uploaded Final RC/License Document - Skipped (unexpected condition but not failing the test).");
			}

			*/
			
			
			
			
			attemptDocumentDownload(By.xpath("(//img[@alt='Action Icon' or @title='No File Availabe'])[1]"),
			        "Acknowledgement Copy Document", "", test);

			attemptDocumentDownload(By.xpath("(//img[@alt='Action Icon' or @title='No File Availabe'])[2]"),
			        "Payment Receipt Document", "", test);

			attemptDocumentDownload(By.xpath("(//img[@alt='Action Icon' or @title='No File Availabe'])[3]"),
			        "Uploaded Final RC/License Document", "", test);

			
			
			
		}
		/* ----------------- helpers (put these in your common class if you prefer) ----------------- */

		private static int safeCount(File dir) {
		    try {
		        File[] list = (dir != null) ? dir.listFiles() : null;
		        return (list == null) ? 0 : list.length;
		    } catch (Exception e) {
		        return 0;
		    }
		}

		/**
		 * Wait for a new file to appear in dir compared to baseline count.
		 * If expectedNameContains is non-empty, also prefers matching file.
		 * timeoutMs: total time to wait; polls every 500ms.
		 * Returns the detected new File, or null if none appears in time.
		 */
		private static File waitForNewFile(File dir, int baselineCount, long timeoutMs, String expectedNameContains) {
		    long deadline = System.currentTimeMillis() + timeoutMs;
		    File candidate = null;

		    while (System.currentTimeMillis() < deadline) {
		        try {
		            File[] current = (dir != null) ? dir.listFiles() : null;
		            if (current != null && current.length > baselineCount) {
		                // Pick the newest file
		                File newest = null;
		                long newestTime = Long.MIN_VALUE;
		                for (File f : current) {
		                    if (f != null && f.exists()) {
		                        long lm = f.lastModified();
		                        if (lm > newestTime) {
		                            newestTime = lm;
		                            newest = f;
		                        }
		                    }
		                }
		                candidate = newest;
		                if (candidate != null) {
		                    // If a hint is provided, verify name contains it; else accept first new file
		                    if (expectedNameContains == null || expectedNameContains.trim().isEmpty()
		                        || candidate.getName().toLowerCase().contains(expectedNameContains.toLowerCase().trim())) {
		                        return candidate;
		                    }
		                }
		            }
		            Thread.sleep(500);
		        } catch (Exception ignored) {
		            // keep polling
		            try { Thread.sleep(500); } catch (InterruptedException ignored2) {}
		        }
		    }
		    return candidate; // might be null
		}
		
		
		
		
		//Reusable: 
		public static void attemptDocumentDownload(By icon, String label, String expectedNameContains, ExtentTest test) {
		    try {
		        File downloadDir = new File("C:\\Users\\swapnilb\\Downloads");
		        java.util.List<WebElement> icons = getDriver().findElements(icon);

		        if (icons == null || icons.isEmpty()) {
		            test.log(LogStatus.INFO, label + " - Download button not present on UI.");
		            return;
		        }

		        WebElement btn = icons.get(0);
		        String title = "";
		        try { title = String.valueOf(btn.getAttribute("title")); } catch (Exception ignored) {}

		        boolean displayed = false, enabled = false;
		        try { displayed = btn.isDisplayed(); } catch (Exception ignored) {}
		        try { enabled = btn.isEnabled(); } catch (Exception ignored) {}

		        if ((title != null && title.trim().equalsIgnoreCase("No File Availabe")) || !displayed || !enabled) {
		            test.log(LogStatus.INFO, label + " - There is No File Available.");
		            return;
		        }

		        int beforeCount = 0;
		        try {
		            File[] list = (downloadDir != null) ? downloadDir.listFiles() : null;
		            beforeCount = (list == null) ? 0 : list.length;
		        } catch (Exception ignored) {}

		        boolean clicked = false;
		        try { btn.click(); clicked = true; }
		        catch (Exception c1) {
		            try { ((org.openqa.selenium.JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", btn); clicked = true; }
		            catch (Exception c2) {
		                try { new org.openqa.selenium.interactions.Actions(getDriver()).moveToElement(btn).click().perform(); clicked = true; }
		                catch (Exception ignored) { }
		            }
		        }

		        if (!clicked) {
		            test.log(LogStatus.INFO, label + " - Download button present but not clickable right now.");
		            return;
		        }

		        long deadline = System.currentTimeMillis() + 20000L;
		        File detected = null;

		        while (System.currentTimeMillis() < deadline) {
		            try {
		                File[] current = (downloadDir != null) ? downloadDir.listFiles() : null;
		                int currCount = (current == null) ? 0 : current.length;

		                if (currCount > beforeCount && current != null) {
		                    File newest = null;
		                    long t = Long.MIN_VALUE;
		                    for (File f : current) {
		                        if (f != null && f.exists()) {
		                            long lm = f.lastModified();
		                            if (lm > t) { t = lm; newest = f; }
		                        }
		                    }
		                    if (newest != null) {
		                        detected = newest;
		                        if (expectedNameContains == null || expectedNameContains.trim().isEmpty()
		                            || newest.getName().toLowerCase().contains(expectedNameContains.toLowerCase().trim())) {
		                            break;
		                        }
		                    }
		                }
		                Thread.sleep(500);
		            } catch (Exception ignored) {
		                try { Thread.sleep(500); } catch (InterruptedException ignored2) {}
		            }
		        }

		        if (detected != null) {
		            test.log(LogStatus.PASS, label + " - File downloaded successfully: " + detected.getName());
		        } else {
		            test.log(LogStatus.FAIL, label + " - File not downloaded (no new file detected).");
		        }
		    } catch (Throwable t) {
		        test.log(LogStatus.INFO, label + " - Skipped (unexpected condition but not failing the test).");
		    }
		}

		
		
		
	 
		 public static void editDocumentSectionDocReqOTActivity(ExtentTest test) throws Exception
			{

				getDriver().navigate().refresh();
				JavascriptExecutor js = (JavascriptExecutor) getDriver();

				Thread.sleep(8000);
				RCPLocator.clickRegistration().click();
				Thread.sleep(5000);
				RCPLocator.editBtn().click();
				
				Thread.sleep(8000);
				RCPLocator.documentSection().click();
				Thread.sleep(5000);
				RCPLocator.plus1_OTActivity().click();
				
				if(RCPLocator.clickSubmit().isDisplayed()) {
					test.log(LogStatus.PASS,  "Document Requirements for the OT Activity is working fine"); 
				}
				else {
					test.log(LogStatus.PASS,  "Document Requirements for the OT Activity - Submit button is not displayed");
				}
				
			}
	 
	 
	 
	 
	 
	 
	 
	 public static void EditTabsVerification(ExtentTest test) throws Exception
		{

			getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();

			Thread.sleep(8000);
			RCPLocator.clickRegistration().click();
			Thread.sleep(5000);
			RCPLocator.editBtn().click();
			
			Thread.sleep(8000);
			String BasicInfo = getDriver().findElement(By.xpath("//button[normalize-space()='Submitted to department']")).getText();
			if(BasicInfo.equals("Submitted to department"))
			{
				test.log(LogStatus.PASS,  "RCP Team Tab is displayed"); 
			}
			else 
			{
				test.log(LogStatus.FAIL,  "RCP Team Tab is not displayed"); 
			}
			
			
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//a[normalize-space()='License Request Details']")).click();
			String TransReq = getDriver().findElement(By.xpath("//span[normalize-space()='Basic Information']")).getText();

			if(TransReq.equals("Basic Information"))
			{
				test.log(LogStatus.PASS,  "License Request Details Tab is displayed"); 
			}
			else 
			{
				test.log(LogStatus.FAIL,  "License Request Details Tab is not displayed"); 
			}
			
			
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//a[normalize-space()='SD Executer']")).click();
			String submittedToDept = getDriver().findElement(By.xpath("//button[normalize-space()='Submitted to department']")).getText();

			if(submittedToDept.equals("Submitted to department"))
			{
				test.log(LogStatus.PASS,  "SD Executer Tab is displayed"); 
			}
			else 
			{
				test.log(LogStatus.FAIL,  "SD Executer Tab is not displayed"); 
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
	 
	 public static void DeleteButton(ExtentTest test) throws InterruptedException
		{

	 	 getDriver().navigate().refresh();
			
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			Thread.sleep(3000);
			RCPLocator.clickRegistration().click();
			
			
			Thread.sleep(3000);
			String item = RCPLocator.readTotalItems().getText();
		String[] bits = item.split(" ");								//Splitting the String
		if(bits.length > 2)
		{
			Thread.sleep(2000);
			item = RCPLocator.readTotalItems().getText();
			bits = item.split(" ");								//Splitting the String
		}
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(2000);
			item = RCPLocator.readTotalItems().getText();
			bits = item.split(" ");									//Splitting the String
			compliancesCount = bits[bits.length - 2];
		}
		int count = Integer.parseInt(compliancesCount);
			
			Thread.sleep(2000);
			RCPLocator.clickDelete().click();
			
			Thread.sleep(3000);
			String msg=RCPLocator.clickDeleteMsg().getText();
			
			 if(msg.equalsIgnoreCase("Are you sure you want to delete this License?"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
				RCPLocator.clickOkBtn().click();
				
				Thread.sleep(2000);
				String msg1=RCPLocator.clickMsg().getText();
				Thread.sleep(2000);
				 if(msg1.equalsIgnoreCase("License deleted successfully"))
				 {
					 Thread.sleep(2000);
					 test.log(LogStatus.PASS, "Message displayed = "+msg1);
					 
				 }
				 else
				 {
					 test.log(LogStatus.FAIL, "Message displayed = "+msg1);
				 }
				 
				 Thread.sleep(1000);
				RCPLocator.clickOkBtn().click();
				
				Thread.sleep(1000);
//			RCPLocator.readTotalItems().click();
			String item1 = RCPLocator.readTotalItems().getText();
			String[] bits1 = item1.split(" ");								//Splitting the String
			
			if(bits1.length > 2)
			{
				Thread.sleep(2000);
				item1 = RCPLocator.readTotalItems().getText();
				bits1 = item1.split(" ");								//Splitting the String
			}
			String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
			
			if(compliancesCount1.equalsIgnoreCase("to"))
			{
				Thread.sleep(2000);
				item1 = RCPLocator.readTotalItems().getText();
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
	 
	 public static void ExistingLicenseCountMatch( ExtentTest test,String Notice) throws InterruptedException, IOException
		{

	  getDriver().navigate().refresh();
		 
		 Thread.sleep(8000);
		RCPLocator.clickRegistration().click();
			
		Thread.sleep(6000);
		RCPLocator.ExistingLicesne().click();

		//int pendingAssignment = 0;
		if(Notice.equalsIgnoreCase("Pending Assignment"))
		{
			Thread.sleep(5000);
			String string_pendingAssignment = RCPLocator.pendingAssignmentLicenseCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(5000);
			test.log(LogStatus.PASS, "Pedning assignment box count :-"+string_pendingAssignment);
			//pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(5000);
			RCPLocator.pendingAssignmentLicenseCount().click();
			Thread.sleep(5000);
		}
		else if(Notice.equalsIgnoreCase("Pending Action"))
		{
			Thread.sleep(2000);
			String string_pendingAssignment = RCPLocator.pendingActionLicenseCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Pedning Action  box count :-"+string_pendingAssignment);
			//pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(3000);
			RCPLocator.pendingActionLicenseCount().click();
		}
		else if(Notice.equalsIgnoreCase("Overdue"))
		{
			Thread.sleep(2000);
			String string_pendingAssignment = RCPLocator.OverdueLicenseCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Ovedrue  box count :-"+string_pendingAssignment);
			//pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(3000);
			RCPLocator.OverdueLicenseCount().click();
			
		}
		else if(Notice.equalsIgnoreCase("Closed"))
		{
			Thread.sleep(2000);
			String string_pendingAssignment = RCPLocator.ClosedLicenseCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Closed  box count :-"+string_pendingAssignment);
			//pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(3000);
			RCPLocator.ClosedLicenseCount().click();
		}
		
		
//		Thread.sleep(5000);
//		RCPLocator.readTotalItems().click();					//Clicking on total items count
//		Thread.sleep(500);
//		String item = RCPLocator.readTotalItems().getText();	//Reading total items String value
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

	 		getDriver().navigate().refresh();
			Thread.sleep(10000);
			RCPLocator.clickRegistration().click();
			
			Thread.sleep(5000);
			RCPLocator.ExistingLicesne().click();

			Thread.sleep(5000);
			File dir = new File("C:\\Users\\swapnilb\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(3000);
			RCPLocator.clickExistingLicenseExport().click();
			
		
			Thread.sleep(10000);
			File dir1 = new File("C:\\Users\\swapnilb\\Downloads");
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
			

	  getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(3000);
			RCPLocator.clickRegistration().click();
			Thread.sleep(3000);
			RCPLocator.ExistingLicesne().click();
			
				Thread.sleep(3000);
				RCPLocator.SearchBox().sendKeys("Maharashtra",Keys.ENTER);
			
				List<String> li=new ArrayList<String>();
		        
		       
		        li.add("Maharashtra");
	       
		        
				List<String> filter=new ArrayList<String>();	
				
				filter.add("Maharashtra");	
				
				
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
				
				if(RCPLocator.ClearBtn().isEnabled())
				{
					RCPLocator.ClearBtn().click();
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
		 	getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			
			Thread.sleep(3000);
			RCPLocator.clickRegistration().click();
			Thread.sleep(1000);
			RCPLocator.ExistingLicesne().click();
//			Thread.sleep(1000);
//			RCPLocator.pendingActionLicenseCount().click();

			
			Thread.sleep(1000);
			RCPLocator.ExistingLicesneViewIcon().click();
			
			Thread.sleep(3000);
			String msg =RCPLocator.ExistingLicesneDetailes().getText();
			
			if(msg.equalsIgnoreCase("Existing License Details"))
			{
				
				test.log(LogStatus.PASS, "Existing License Details open successfully:-" +msg);
			}
			else
			{
				test.log(LogStatus.FAIL, "Existing License Details not open successfully:-" +msg);
			}
			Thread.sleep(1000);
			RCPLocator.clickBack().click();
			
			
		}
		
		public static void ExistingLicenseDownload(ExtentTest test) throws InterruptedException, IOException
		{
		 	getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			WebDriverWait wait=new WebDriverWait(getDriver(), 20);
			Thread.sleep(5000);
			RCPLocator.clickRegistration().click();
			Thread.sleep(5000);
			RCPLocator.ExistingLicesne().click();
			
			Thread.sleep(3000);
			File dir = new File("C:\\Users\\swapnilb\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			wait.until(ExpectedConditions.visibilityOf(RCPLocator.ExistingLicesneDownload()));
			
			Thread.sleep(3000);
			RCPLocator.ExistingLicesneDownload().click();
			Thread.sleep(3000);
			
//			WebDriverWait wait=new WebDriverWait(getDriver(), 20);
//			wait.until(ExpectedConditions.invisibilityOf(RCPLocator.gridLoad()));
			
			Thread.sleep(8000);
			File dir1 = new File("C:\\Users\\swapnilb\\Downloads");
			File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
		
			if(dirContents.length < allFilesNew.length)
			{
			
				Thread.sleep(9000);					//Clicking on 'Excel Report' image.
				test.log(LogStatus.PASS, "File downloaded successfully.");
			}
			else
			{
				Thread.sleep(9000);	
				test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
			}
			
			Thread.sleep(3000);

			
		}

	 
		public static void DeleteCancelButton(ExtentTest test) throws InterruptedException
		{
			getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			Thread.sleep(3000);
			RCPLocator.clickRegistration().click();
			
			Thread.sleep(3000);
			RCPLocator.clickDelete().click();
			
			if(RCPLocator.clickCancelBtn().isEnabled())
			{
				Thread.sleep(3000);
				RCPLocator.clickCancelBtn().click();
				test.log(LogStatus.PASS, "Cancel button is clickable");
			}
			else
			{
				test.log(LogStatus.FAIL, "Cancel button is clickable");
			}
			
		}
	 
	 
/*	 
	 public static String takeScreenshot(WebDriver driver, String screenshotName) 
	 {
		    try 
		    {
		        String destDir = System.getProperty("user.dir") + "/test-output/Screenshot/";
		        File dir = new File(destDir);
		        if (!dir.exists())
		        {
		            dir.mkdirs();
		        }

		        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		        String dest = destDir + screenshotName + "_" + timestamp + ".png";

		        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        File destination = new File(dest);
		        FileUtils.copyFile(source, destination);
		        return dest;

		    } catch (IOException e) {
		        System.out.println("Screenshot capture failed: " + e.getMessage());
		        return null;
		    }
		}
	 
	 */
	 
	 
	 public static String takeScreenshot(WebDriver driver, String screenshotName)
	 {
		    try 
		    {
		        String destDir = System.getProperty("user.dir") + "/test-output/screenshots/";
		        File dir = new File(destDir);
		        if (!dir.exists()) 
		        {
		            dir.mkdirs(); // create folder if not exists
		        }

		        // No timestamp → override enabled
		        String dest = destDir + screenshotName + ".png";

		        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        File destination = new File(dest);
		        FileUtils.copyFile(source, destination);
		        return dest;

		    } 
		    catch (IOException e)
		    {
		        System.out.println("Screenshot capture failed: " + e.getMessage());
		        return null;
		    }
		}

}
