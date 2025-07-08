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
		 
		 Thread.sleep(3000);
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
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(2000);
			RCPLocator.clickExport().click();
			
		
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
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(2000);
			RCPLocator.clickExport().click();
			
		
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
	 
	 
	 public static void RegistrationOverdueExport( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		{
//		 WebDriverWait wait = new WebDriverWait(getDriver(), 140);

	 	 getDriver().navigate().refresh();
		
			Thread.sleep(6000);
			RCPLocator.clickRegistration().click();
			CoordinatorMethod.zoomOutScreen(2);
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
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(2000);
			RCPLocator.clickExport().click();
			
		
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
	 
	 public static void RegistrationClosedExport( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		{
//		 WebDriverWait wait = new WebDriverWait(getDriver(), 140);

	 	 getDriver().navigate().refresh();
	 	CoordinatorMethod.zoomOutScreen(2);
			Thread.sleep(6000);
			RCPLocator.clickRegistration().click();
			CoordinatorMethod.zoomOutScreen(2);
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
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(2000);
			RCPLocator.clickExport().click();
			
		
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
	 
	 public static void RCPLogo( ExtentTest test,String Notice) throws InterruptedException, IOException
		{

	 	 getDriver().navigate().refresh();
		 
		 Thread.sleep(3000);
		 RCPLocator.clickRegistration().click();
		 
		 
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
	 
	 public static void ExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
		{
//		 WebDriverWait wait = new WebDriverWait(getDriver(), 140);

	 	 getDriver().navigate().refresh();
		
			Thread.sleep(3000);
			RCPLocator.clickRegistration().click();
			
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
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(1000);
			RCPLocator.clickExport().click();
			
		
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

	 	 getDriver().navigate().refresh();
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			Thread.sleep(3000);
			RCPLocator.clickRegistration().click();
			
				Thread.sleep(3000);
				RCPLocator.SearchBox().sendKeys("RCP25-6192",Keys.ENTER);
			
				List<String> li=new ArrayList<String>();
		        
		       
		        li.add("RCP25-6192");
	       
		        
				List<String> filter=new ArrayList<String>();	
				
				filter.add("RCP25-6192");	
				
				
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
			if(RCPLocator.EditBtn().isEnabled())
			{
				Thread.sleep(3000);
				RCPLocator.EditBtn().click();
				test.log(LogStatus.PASS, "Edit button is clickable.");
				
			}
			else
			{
				test.log(LogStatus.PASS, "Edit button is not clickable.");
				
			}
			Thread.sleep(1000);
			RCPLocator.clickBack().click();
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
		 
		 Thread.sleep(3000);
		RCPLocator.clickRegistration().click();
			
		Thread.sleep(3000);
		RCPLocator.ExistingLicesne().click();

		//int pendingAssignment = 0;
		if(Notice.equalsIgnoreCase("Pending Assignment"))
		{
			Thread.sleep(2000);
			String string_pendingAssignment = RCPLocator.pendingAssignmentLicenseCount().getText();		//Storing old value of Statutory overdue.
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "Pedning assignment box count :-"+string_pendingAssignment);
			//pendingAssignment = Integer.parseInt(string_pendingAssignment);
			Thread.sleep(3000);
			RCPLocator.pendingAssignmentLicenseCount().click();
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
			Thread.sleep(3000);
			RCPLocator.clickRegistration().click();
			
			Thread.sleep(3000);
			RCPLocator.ExistingLicesne().click();

			Thread.sleep(3000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			Thread.sleep(3000);
			RCPLocator.clickExistingLicenseExport().click();
			
		
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
			Thread.sleep(3000);
			RCPLocator.clickRegistration().click();
			Thread.sleep(3000);
			RCPLocator.ExistingLicesne().click();
			
			Thread.sleep(3000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
		
			wait.until(ExpectedConditions.visibilityOf(RCPLocator.ExistingLicesneDownload()));
			
			Thread.sleep(3000);
			RCPLocator.ExistingLicesneDownload().click();
			
			
//			WebDriverWait wait=new WebDriverWait(getDriver(), 20);
//			wait.until(ExpectedConditions.invisibilityOf(RCPLocator.gridLoad()));
			
			Thread.sleep(8000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
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
	 public static String takeScreenshot(WebDriver driver, String screenshotName) {
		    try {
		        String destDir = System.getProperty("user.dir") + "/test-output/Screenshot/";
		        File dir = new File(destDir);
		        if (!dir.exists()) {
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
	 
	 
	 public static String takeScreenshot(WebDriver driver, String screenshotName) {
		    try {
		        String destDir = System.getProperty("user.dir") + "/test-output/screenshots/";
		        File dir = new File(destDir);
		        if (!dir.exists()) {
		            dir.mkdirs(); // create folder if not exists
		        }

		        // No timestamp → override enabled
		        String dest = destDir + screenshotName + ".png";

		        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        File destination = new File(dest);
		        FileUtils.copyFile(source, destination);
		        return dest;

		    } catch (IOException e) {
		        System.out.println("Screenshot capture failed: " + e.getMessage());
		        return null;
		    }
		}
	 
	 
	 
	 

	 
	 
	 
	 
	 
	 

}
