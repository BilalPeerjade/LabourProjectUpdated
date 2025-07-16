package distributor;

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
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import login.BasePage;
import login.LoginLocators;
import performer.PerformerLocator;
import rcp.OneCommonMethod;



public class Methods extends BasePage {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	 static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour1.xlsx";

	
	public static void User ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	    
		  
		 if(Locators.Users().isEnabled()) {
			 
				test.log(LogStatus.PASS,  "  User Button Working Sucessfully."); 
				Locators.Users().click();
		 }
		 else
		 {
		 	test.log(LogStatus.FAIL, "User Button Working Failure.");
		 }
		  	 Thread.sleep(3000);
		  
		  	
	}
	
	public static void UserAddNew ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				Thread.sleep(3000);
                 Locators.addNewBtn().click();
				Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(0);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.firstName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(1);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.lastName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(2);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.designation().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(3);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.mail().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(4);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

				int No = (int) c1.getNumericCellValue();
				Locators.contactno().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				Locators.Status().click();
				Thread.sleep(2000);
				Locators.Status1().click();
				Thread.sleep(2000);
				Locators.roledd().click();
				Thread.sleep(2000);
				Locators.roledd1().click();
				Thread.sleep(2000);
				Locators.Save().click();
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equals("Details Save Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void UserEdit ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				Thread.sleep(3000);
                 Locators.Edit().click();
				Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.firstName().clear();
				 	row0 = sheet.getRow(5);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.firstName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				
		
				Locators.Save().click();
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equals("Details Save Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void CorporateToEntity ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		Locators.Corporate().click();
		Thread.sleep(3000);
		Locators.CorporateSearch().click();
		Thread.sleep(3000);
		Locators.CorporateSearch().sendKeys("AVAREGTRAC");
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//span[normalize-space()='AVAREGTRAC (Regtrack Labour Test)']")).click();
		Thread.sleep(3000);
		Locators.Apply().click();
		Thread.sleep(3000);
		Locators.proceedEntity().click();
		Thread.sleep(3000);
		  	
	}
	
	public static void UserEditInvalid ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				Thread.sleep(3000);
                 Locators.Edit().click();
				Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.firstName().clear();
				 	row0 = sheet.getRow(6);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.firstName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				Locators.lastName().clear();
				row0 = sheet.getRow(7);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.lastName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				
		
				Locators.Save().click();
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//div[contains(text(),'First Name must contain only letters and spaces.')]")).getText();
				String text1 = getDriver().findElement(By.xpath("//div[contains(text(),'Last Name must contain only letters and spaces.')]")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				
					
					test.log(LogStatus.PASS,"Message Displayed : "+text +", "+text1);
			
					
		
				
				
		  	
	}
	
	public static void SearchUser ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				
				//Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.SearchUser().click();
				 	row0 = sheet.getRow(5);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
//				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				
				Locators.SearchUser().sendKeys("mahesh.darandale@tlregtech.in");
				
				
				Thread.sleep(3000);
				Locators.SearchUser1().click();
				Thread.sleep(3000);
			//	List<WebElement> options = getDriver().findElements(By.xpath("//ul[@id='ddlUser_listbox']/child::li"));
			//	selectOptionFromDropDown_bs(options, "Vaibhav (mahesh.darandale@tlregtech.in)");
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("(//*[@class='cell-content'])[1]")).getText();
				
					
				test.log(LogStatus.PASS, "User dropdown working successfully.");
				test.log(LogStatus.PASS, "User selected : "+text);
					
		
				
				
		  	
	}
	
	public static void SearchUserClear ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				
				//Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.SearchUser().click();
				 	row0 = sheet.getRow(5);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
//				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				
				Locators.SearchUser().sendKeys("mahesh.darandale@tlregtech.in"); //Me
				
				
				Thread.sleep(3000);
				Locators.SearchUser1().click();
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
				Thread.sleep(4000);
				
				
					
				 if(Locators.Clear().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Clear button working successfully."); 
						Locators.Clear().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
				 }
				  	 Thread.sleep(3000);
				  
			
	}
	
	public static void UserDelete( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				
				Locators.Delete().click();
				
				Thread.sleep(3000);
				
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				Locators.DeleteOk().click();
				Thread.sleep(3000);
				String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				
					
					test.log(LogStatus.PASS,"Message Displayed : "+text1);
			
					
					Locators.ok().click();
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void UserDeleteAssign( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				
				Locators.Delete().click();
				
				Thread.sleep(3000);
				
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				Locators.DeleteOk().click();
				Thread.sleep(3000);
				String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				
					
					test.log(LogStatus.PASS,"Message Displayed : "+text1);
			
					
					Locators.ok().click();
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void UserDeleteCancel( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				Thread.sleep(3000);
				
				Locators.Delete().click();
				
				Thread.sleep(3000);
				
				 if(Locators.DeleteCan().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Cancel' button working successfully."); 
						Locators.DeleteCan().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Cancel' button does not working");
				 }
				  	 Thread.sleep(3000);
				  
				
					

					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void UserBack( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				
				 Thread.sleep(3000);
				
				 if(Locators.Back().isEnabled()) {
					 
						
						Locators.Back().click();
						 Thread.sleep(3000);
						String value = getDriver().getTitle();
						System.out.println(value);	//Assert.assertEquals(value, true);
						if(value!="")
						{
							test.log(LogStatus.PASS, "Back button working successfully.");
							test.log(LogStatus.PASS, "Page displayed : "+value);
					}
						else
						{
							test.log(LogStatus.PASS, "Back button does not work.");
							test.log(LogStatus.PASS, "Page displayed : "+value);

				}
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Back' button does not working");
				 }
				  	 Thread.sleep(3000);
				  
				
					
				
				
				
		  	
	}
	
	
	public static void ExportUser( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Users().click();
				
				
				 Thread.sleep(3000);
				 JavascriptExecutor js = (JavascriptExecutor) getDriver();
					js.executeScript("window.scrollBy(0,300)");	
					Thread.sleep(5000);
				 Thread.sleep(2000); 		
					Locators.GridCount().click();					//Clicking on Text of total items just to scroll down.
					Thread.sleep(1000);
					String s = 				Locators.GridCount().getText();
					Thread.sleep(8000);
					String[] bits = s.split(" ");								//Splitting the String
					String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
					int count1 = Integer.parseInt(compliancesCount);
				
					if(compliancesCount.equalsIgnoreCase("to"))
					{
						Thread.sleep(5000);
					   s = Locators.GridCount().getText();
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
			Locators.Export().click();
			Thread.sleep(9000);	
			test.log(LogStatus.PASS, " :- File downloaded successfully.");

			Thread.sleep(5500);
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
				int columnNumber = 2; //Check Email count
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
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
				
				
		  	
	}
	
	public static void  Corporate ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	    
		  
		 if(Locators.Corporate().isEnabled()) {
			 
				test.log(LogStatus.PASS,  "  Corporate Button Working Sucessfully.."); 
				Locators.Users().click();
		 }
		 else
		 {
		 	test.log(LogStatus.FAIL, "Corporate Button Working Failure.");
		 }
		  	 Thread.sleep(3000);
		  
		  	
	}
	
	public static void CorporateAddNew ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				Thread.sleep(3000);
                 Locators.addNewBtn().click();
				Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(8);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.name().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(9);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.CorporateID().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				Locators.Check().click();
				Thread.sleep(2000);
				row0 = sheet.getRow(10);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.BuyerName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(11);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Email().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(12);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

				int No = (int) c1.getNumericCellValue();
				Locators.ContactNo().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				
//				Locators.Save().click();
				Thread.sleep(4000);
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				String text2 = getDriver().findElement(By.xpath("//small[@class='text-danger ng-star-inserted']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text2.equals("Details Save Successfully")||text2.equals("CorporateID already exists"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void CorporateEdit ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				Thread.sleep(3000);
                 Locators.CorporateEdit().click();
				Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			  	Locators.name().clear();
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(8);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.name().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
			
				
				
				
				Locators.Save().click();
				Thread.sleep(4000);
			
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equals("Details Save Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void CorporateEditInvalid ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.SearchUser().click();
				 	row0 = sheet.getRow(15);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
//				row0 = sheet.getRow(16);
//				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
//				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				
				Locators.Triangle().click();
				Thread.sleep(3000);
				Locators.Triangle().click();
				Thread.sleep(3000);
				Locators.SearchUser1().click();
				Thread.sleep(3000);
			//	List<WebElement> options = getDriver().findElements(By.xpath("//ul[@id='ddlUser_listbox']/child::li"));
			//	selectOptionFromDropDown_bs(options, "Vaibhav (mahesh.darandale@tlregtech.in)");
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);

				
				
				
				
				
				Thread.sleep(3000);
                 Locators.CorporateEdit().click();
				Thread.sleep(3000);
//				 FileInputStream fis = new FileInputStream(filePath);
//			        Workbook workbook = WorkbookFactory.create(fis);
//			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			  	Locators.Email().clear();
				int roww = 0;
				Thread.sleep(500);
				Row row00 = sheet.getRow(roww); // Selected 0th index row (First row)
				Cell c11 = null;
				 	row00 = sheet.getRow(13);
				c11 = row00.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Email().sendKeys(c11.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
			
				row0 = sheet.getRow(14);
				c11 = row00.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Pan().sendKeys(c11.getStringCellValue()); // Writing Task title
				Thread.sleep(7000);
				
				OneCommonMethod.zoomOutScreen(2); //ZoomOut
				
				Locators.Save().click();
				Thread.sleep(4000);
			
				String text = getDriver().findElement(By.xpath("//small[@class='ng-star-inserted']")).getText();
				String text1 = getDriver().findElement(By.xpath("//div[contains(text(),'PAN must follow the format AAAAA1111A')]")).getText();
			
					test.log(LogStatus.PASS,"Message Displayed : "+text+", "+text1);
				
		
			
	}
	
	public static void SearchCorporate ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				
				//Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.SearchUser().click();
				 	row0 = sheet.getRow(15);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
//				row0 = sheet.getRow(16);
//				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
//				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				
				Locators.Triangle().click();
				Thread.sleep(3000);
				Locators.Triangle().click();
				Thread.sleep(3000);
				Locators.SearchUser1().click();
				Thread.sleep(3000);
			//	List<WebElement> options = getDriver().findElements(By.xpath("//ul[@id='ddlUser_listbox']/child::li"));
			//	selectOptionFromDropDown_bs(options, "Vaibhav (mahesh.darandale@tlregtech.in)");
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("(//*[@class='cell-content'])[1]")).getText();
				
					
				test.log(LogStatus.PASS, "Selected customer name along with their details should get reflected in the grid.");
				test.log(LogStatus.PASS, "customer selected : "+text);
					
		
				
				
		  	
	}
	
	
	public static void SearchCorporateClear ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				
				//Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.SearchUser().click();
				 	row0 = sheet.getRow(15);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				row0 = sheet.getRow(16);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
//				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				Locators.SearchUser1().click();
				Thread.sleep(3000);
			//	List<WebElement> options = getDriver().findElements(By.xpath("//ul[@id='ddlUser_listbox']/child::li"));
			//	selectOptionFromDropDown_bs(options, "Vaibhav (mahesh.darandale@tlregtech.in)");
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
				Thread.sleep(4000);
				 if(Locators.Clear().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Clear button working successfully."); 
					//	Locators.Users().click();
						Locators.Clear().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
				 }
				  	 Thread.sleep(3000);
				  
					
		
				
				
		  	
	}
	
	public static void corporateDelete( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				
				Locators.DeleteCor().click();
				
				Thread.sleep(3000);
				
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				Locators.DeleteOk().click();
				Thread.sleep(3000);
				String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				if(!text1.equalsIgnoreCase("Customer Branch Deletion Failed")) {
					test.log(LogStatus.PASS,"Message Displayed : "+text1);
			
				}else {
					test.log(LogStatus.FAIL,"Message Displayed : "+text1);
				}
					Locators.ok().click();
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void CorDeleteCancel( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Corporate().click();
		
		
		Locators.DeleteCor().click();
		
		Thread.sleep(3000);
				
				 if(Locators.DeleteCan().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Cancel' button working successfully."); 
						Locators.DeleteCan().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Cancel' button does not working");
				 }
				  	 Thread.sleep(3000);
				  
				
					

					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void CorporateView( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Corporate().click();
		
		
		 FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(1);

	  	Thread.sleep(3000);
	
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		Locators.SearchUser().click();
		 	row0 = sheet.getRow(15);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(3000);
//		row0 = sheet.getRow(16);
//		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
//		Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(3000);
		
		Locators.Triangle().click();
		Thread.sleep(3000);
		Locators.Triangle().click();
		Thread.sleep(3000);
		Locators.SearchUser1().click();
		Thread.sleep(3000);
	//	List<WebElement> options = getDriver().findElements(By.xpath("//ul[@id='ddlUser_listbox']/child::li"));
	//	selectOptionFromDropDown_bs(options, "Vaibhav (mahesh.darandale@tlregtech.in)");
		Thread.sleep(3000);

			 Locators.Apply().click();
				Thread.sleep(3000);

		
		
		
		
		
		Thread.sleep(3000);
				
		
		 if(Locators.proceedEntity().isEnabled()) {
		{
			Locators.proceedEntity().click();
		}
			test.log(LogStatus.PASS, "View Entity button Working Successfully.");
					
}
		else
		{
			test.log(LogStatus.FAIL, "View entity button does not working.");
		}	
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void CorporateBack( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				
				
				 Thread.sleep(3000);
				
				 if(Locators.Back().isEnabled()) {
					 
						
						Locators.Back().click();
						 Thread.sleep(3000);
						String value = getDriver().getTitle();
						System.out.println(value);	//Assert.assertEquals(value, true);
						if(value!="")
						{
							test.log(LogStatus.PASS, "Back button working successfully.");
							test.log(LogStatus.PASS, "Page displayed : "+value);
					}
						else
						{
							test.log(LogStatus.PASS, "Back button does not work.");
							test.log(LogStatus.PASS, "Page displayed : "+value);

				}
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Back' button does not working");
				 }
				  	 Thread.sleep(3000);
				  
				
					
				
				
				
		  	
	}
	
	
	public static void Entity( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		
	  	
/*	  	Locators.Corporate().click();

		FileInputStream fis = new FileInputStream(filePath);
	    Workbook workbook = WorkbookFactory.create(fis);
	    Sheet sheet = workbook.getSheetAt(1);

	  	Thread.sleep(3000);
	
		int row = 0;
		Thread.sleep(500);
		Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
		Cell c1 = null;
		Locators.SearchUser().click();
		 	row0 = sheet.getRow(15);
		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
		Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(3000);
//		row0 = sheet.getRow(16);
//		c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
//		Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
		Thread.sleep(3000);
		
		Locators.Triangle().click();
//		Thread.sleep(3000);
		Locators.Triangle().click();
		Thread.sleep(3000);
		Locators.SearchUser1().click();
		Thread.sleep(3000);
	//	List<WebElement> options = getDriver().findElements(By.xpath("//ul[@id='ddlUser_listbox']/child::li"));
	//	selectOptionFromDropDown_bs(options, "Vaibhav (mahesh.darandale@tlregtech.in)");
		Thread.sleep(3000);
	    Locators.Apply().click();
	    
	    */
				
	  	
	  	CorporateToEntity(test); //Filter it will direct go to Corporate search
	  	
		
//		Locators.proceedEntity().click();
		Thread.sleep(3000);
				
		
		 if(Locators.Entity().isEnabled()) {
		
			Locators.Entity().click();
		
			test.log(LogStatus.PASS, "Entity Tab Open Successfully.");
					
}
		else
		{
			test.log(LogStatus.FAIL, "Entity Tab Does Not Open.");
		}	
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void EntityAddNew ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				
				
				FileInputStream fis2 = new FileInputStream(filePath);
				Workbook workbook2 = WorkbookFactory.create(fis2);
				Sheet sheet2 = workbook2.getSheetAt(1);

				Thread.sleep(3000);

				int row2 = 0;
				Thread.sleep(500);
				Row row02 = sheet2.getRow(row2); // Selected 0th index row (First row)
				Cell c12 = null;
				Locators.SearchUser().click();
				row02 = sheet2.getRow(15);
				c12 = row02.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c12.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);

				// row02 = sheet2.getRow(16);
				// c12 = row02.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				// Locators.SearchUser().sendKeys(c12.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);

				Locators.Triangle().click();
				Thread.sleep(3000);
				Locators.Triangle().click();
				Thread.sleep(3000);
				Locators.SearchUser1().click();
				Thread.sleep(3000);
				// List<WebElement> options2 = getDriver().findElements(By.xpath("//ul[@id='ddlUser_listbox']/child::li"));
				// selectOptionFromDropDown_bs(options2, "Vaibhav (mahesh.darandale@tlregtech.in)");
				Thread.sleep(3000);

				Locators.Apply().click();
				Thread.sleep(3000);

				
				
				
				
				
				
				Thread.sleep(3000);
                 Locators.proceedEntity().click();
				Thread.sleep(3000);
				Locators.addNewBtn().click();
				
				
//Me				DistributerLocators.selectComplianceType().click();
				
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_MINUS);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyRelease(KeyEvent.VK_MINUS);
				

				
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(17);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EntityName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(18);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.ClientId().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				Locators.Check().click();
				Thread.sleep(2000);
				
				Locators.PFType().click();
				Thread.sleep(2000);
				Locators.PFType1().click();
				Thread.sleep(2000);
				
				
				Locators.PFCode().sendKeys("123335789012342"); // Writing Task title
				Thread.sleep(4000);
				
				row0 = sheet.getRow(20);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Address().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(21);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EnterEmail().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				
				Locators.State().click();
				Thread.sleep(2000);
				Locators.State1().click();
				Thread.sleep(2000);
				
				Locators.City().click();
				Thread.sleep(2000);
				Locators.City1().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(22);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.ContactPerson().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(23);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

			int	 No = (int) c1.getNumericCellValue();
				Locators.ContactNo1().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				Locators.StatusE().click();
				Thread.sleep(2000);
				Locators.StatusE1().click();
				Thread.sleep(2000);
				
//				Locators.CommencementDate().click();
				Thread.sleep(2000);
				Actions action1 = new Actions(getDriver());

//				action1.moveToElement(Locators.CommencementDate1()).click().perform();
				
				
				WebElement dateInput = getDriver().findElement(By.xpath("//input[@id='datepicker-1']"));
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='01-Jan-2020';", dateInput);


//				WebElement dateInput = getDriver().findElement(Locators.CommencementDate());
//				((JavascriptExecutor) getDriver()).executeScript("arguments[0].value='03-03-1999';", dateInput);

				

				
				
			//	Locators.CommencementDate1().click();
				Thread.sleep(2000);
				
				Locators.WagePeriodFrom().click();
				Thread.sleep(2000);
				Locators.WagePeriodFrom1().click();
				Thread.sleep(2000);
				
				Locators.WagePeriodTo().click();
				Thread.sleep(2000);
				Locators.WagePeriodTo1().click();
				Thread.sleep(2000);
				
				Locators.PaymentDay().click();
				Thread.sleep(2000);
		//	    Locators.PaymentDay1().click();
				Thread.sleep(2000);
				action1.moveToElement(Locators.PaymentDay1()).click().perform();
				
				
				Locators.EstablishmentType().click();
				Thread.sleep(2000);
				Locators.EstablishmentType1().click();
				Thread.sleep(2000);
				

				Locators.ActApplicability().click();
				Thread.sleep(2000);
				Locators.ActApplicability1().click();
				Thread.sleep(2000);
				
				Locators.BonusExempted().click();
				Thread.sleep(2000);
				Locators.BonusExempted1().click();
				Thread.sleep(2000);
				
				Locators.EDLIExcemption().click();
				Thread.sleep(2000);
				Locators.EDLIExcemption1().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(24);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

				 No = (int) c1.getNumericCellValue();
				Locators.BonusPer().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				
				
				
				
				Locators.next().click();
				Thread.sleep(4000);
				
				/////Spoc & Escalation Point Details///////////
				
				Locators.Salutation().click();
				Thread.sleep(2000);
				Locators.Salutation1().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(25);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.FirstName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(23);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

				 No = (int) c1.getNumericCellValue();
				Locators.ContactNumber().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				row0 = sheet.getRow(21);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SPOCEmail().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(26);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Designationspo().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.EP1Salutation().click();
				Thread.sleep(2000);
				Locators.EP1Salutation1().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(25);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EP1FirstName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(23);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

				 No = (int) c1.getNumericCellValue();
				Locators.EP1ContactNumber().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				row0 = sheet.getRow(21);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EP1SPOCEmail().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(26);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EP1Designationspo().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				Locators.next().click();
				Thread.sleep(4000);
				
				
				row0 = sheet.getRow(27);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.IVSPOCName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(28);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.IVSPOCEnterEmail().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				row0 = sheet.getRow(23);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

				 No = (int) c1.getNumericCellValue();
				Locators.IVSPOCMobileNumber().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				Locators.Type().click();
				Thread.sleep(2000);
				Locators.Type1().click();
				Thread.sleep(2000);
				
				Locators.EDLIExcemptionType().click();
				Thread.sleep(2000);
				Locators.EDLIExcemptionType1().click();
				Thread.sleep(2000);
				
				Locators.ServiceTaxExempted().click();
				Thread.sleep(2000);
				Locators.ServiceTaxExempted1().click();
				Thread.sleep(2000);
				
				Locators.CLRAApplicable().click();
				Thread.sleep(2000);
				Locators.CLRAApplicable1().click();
				Thread.sleep(2000);
				
				Locators.CLRAType().click();
				Thread.sleep(2000);
				Locators.CLRAType1().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(29);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.ContractorEmployerName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.POApplicable().click();
				Thread.sleep(2000);
				Locators.POApplicable1().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(30);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)

				 No = (int) c1.getNumericCellValue();
				Locators.AgreementID().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				Locators.Mandate().click();
				Thread.sleep(2000);
				Locators.Mandate1().click();
				Thread.sleep(2000);
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equals("Entity Added Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void EntityEdit ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.


	  	
	        	CorporateToEntity(test); //Filter it will direct go to Corporate search
				
	        	OneCommonMethod.zoomOutScreen(2);
	        	
				Thread.sleep(3000);

				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 
				Thread.sleep(3000);
				 
				Locators.EditEntity().click();
				Thread.sleep(3000);
				
				Locators.EntityName().clear();
				row0 = sheet.getRow(17);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EntityName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				
				Locators.next().click();
				Thread.sleep(4000);
				
				
				Locators.next().click();
				Thread.sleep(4000);
			
				
			
				
				
			
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equals("Entity Updated Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void EntityEditinvalid ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				Thread.sleep(3000);
                 Locators.view().click();
				Thread.sleep(3000);
				Locators.EditEntity().click();
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 
				Thread.sleep(2000);
				
			
				Locators.PFCode().clear();
				Locators.PFCode().sendKeys("1233357890123"); // Writing Task title
				Thread.sleep(4000);
				
				Locators.EnterEmail().clear();
				row0 = sheet.getRow(31);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EnterEmail().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.ContactNo1().clear();
				
				Locators.ContactNo1().sendKeys("12"); // Writing Task title
				Thread.sleep(4000);
				
				
				Locators.EntityName().click();
				
				Thread.sleep(4000);
				
				
				String text = Locators.ValMsg().getText();
				Thread.sleep(4000);
				String text1 = Locators.ValMsg1().getText();
				String text2 = Locators.ValMsg2().getText();
			
					
					test.log(LogStatus.PASS,"Message Displayed : "+text +", "+text1 +", "+text2);
				
				
				Thread.sleep(4000);
		  	
	}
	
	public static void SearchEntity ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				 Locators.view().click();
					Thread.sleep(3000);
				//Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.SearchUser().click();
				 	row0 = sheet.getRow(32);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				row0 = sheet.getRow(33);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				Locators.SearchUser1().click();
				Thread.sleep(3000);
			//	List<WebElement> options = getDriver().findElements(By.xpath("//ul[@id='ddlUser_listbox']/child::li"));
			//	selectOptionFromDropDown_bs(options, "Vaibhav (mahesh.darandale@tlregtech.in)");
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("(//*[@class='cell-content'])[1]")).getText();
				
					
				test.log(LogStatus.PASS, "Entities should reflected on the selection of selected customer. Selected entity should get reflected in the grid.");
				test.log(LogStatus.PASS, "Entitiy id selected : "+text);
					
		
				
				
		  	
	}
	
	public static void SearchEntityClear ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				 Locators.view().click();
					Thread.sleep(3000);
				//Thread.sleep(3000);
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				Locators.SearchUser().click();
				 	row0 = sheet.getRow(32);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				row0 = sheet.getRow(33);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.SearchUser().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				Locators.SearchUser1().click();
				Thread.sleep(3000);
			//	List<WebElement> options = getDriver().findElements(By.xpath("//ul[@id='ddlUser_listbox']/child::li"));
			//	selectOptionFromDropDown_bs(options, "Vaibhav (mahesh.darandale@tlregtech.in)");
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
						Thread.sleep(4000);
						 if(Locators.Clear().isEnabled()) {
							 
								test.log(LogStatus.PASS,  " Clear button working successfully."); 
								Locators.Clear().click();
						 }
						 else
						 {
						 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
						 }
						  	 Thread.sleep(3000);
						  
				
				
		  	
	}
	
	public static void EntityDelete( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				Locators.Corporate().click();
				
				 Locators.view().click();
					Thread.sleep(3000);
				
				Locators.DeleteEntity().click();
				
				Thread.sleep(3000);
				
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				Locators.DeleteOk().click();
				Thread.sleep(3000);
				String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				if(text1.equalsIgnoreCase("Deleted Successfully")) {
					test.log(LogStatus.PASS,"Message Displayed : "+text1);
			
				}else {
					test.log(LogStatus.FAIL,"Message Displayed : "+text1);
				}
					Locators.ok().click();
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void EntityDeleteCancel( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Corporate().click();
		
		
		 Locators.view().click();
			Thread.sleep(3000);
		
		Locators.DeleteEntity().click();
		
		Thread.sleep(3000);
				
				 if(Locators.DeleteCan().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Cancel' button working successfully."); 
						Locators.DeleteCan().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Cancel' button does not working");
				 }
				  	 Thread.sleep(3000);
				  
				
					

					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void EntityBulkUpload ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

//		Locators.Corporate().click();
		
		CorporateToEntity(test);
		
//		 Locators.view().click();
			Thread.sleep(3000);
		
		Locators.BulkUpload().click();
		
		Thread.sleep(3000);
Locators.DownloadTemplate().click();
		Thread.sleep(3000);
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\EntityUpload__20250123T073713110Z.xlsx");
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
				 
		 Locators.Upload().click();
					
					Thread.sleep(3000);
				
					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
					
					if(text1.equalsIgnoreCase("File uploaded successfully!")) {
						test.log(LogStatus.PASS,"Message Displayed : "+text1);
				
					}else {
						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
					}
						Locators.ok().click();
		  	
	}
	
	
	public static boolean EntityBulkUploadInvalid ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

//		Locators.Corporate().click();
		
		
//		 Locators.view().click();
	  	CorporateToEntity(test);
	  	
			Thread.sleep(3000);
		
		Locators.BulkUpload().click();
		
		Thread.sleep(3000);
Locators.DownloadTemplate2().click();
		Thread.sleep(3000);
		
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download
		
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Corporate-Entity\\EntityUpload__Invalid.xlsx");
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
				 
		 Locators.Upload().click();
					
		 Thread.sleep(7000);
		
			Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			
			int len1 = dirContents.length;
			int len2 = allFilesNew.length;
			
			System.out.println(len1);
			System.out.println(len2);
			Thread.sleep(3000);
			if(len1<len2)
			{
			
				return true;

			}
			else
			{
			
				return false;
				}

		  	
	}
	
	public static void EntityBulkUploadCheck ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

//		Locators.Corporate().click();
		
		
//		 Locators.view().click();
	  	
	  	CorporateToEntity(test);
	  	
			Thread.sleep(3000);
		
		Locators.BulkUpload().click();
		
		Thread.sleep(3000);
Locators.CheckBox().click();
		Thread.sleep(3000);
		Locators.DownloadTemplate2().click();
		Thread.sleep(3000);
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\EntityUpload__SelectedCBvalid.xlsx");
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
				 
		 Locators.Upload().click();
					
					Thread.sleep(3000);
				
					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
					
					if(text1.equalsIgnoreCase("Updated Successfully")) {
						test.log(LogStatus.PASS,"Message Displayed : "+text1);
				
					}else {
						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
					}
						Locators.ok().click();
		  	
	}
	
	public static void EntityBulkUploadInvalidCheck ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

//		Locators.Corporate().click();
		
		
//		 Locators.view().click();
	  	CorporateToEntity(test);
	  	
			Thread.sleep(3000);
		
		Locators.BulkUpload().click();
		
		Thread.sleep(3000);
		Locators.CheckBox().click();
		Thread.sleep(3000);
Locators.DownloadTemplate2().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Corporate-Entity\\EntitySelectCD Invalid.xlsx");
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
				 
		 Locators.Upload().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Error uploading file")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void EntityBulkUploadCheckB ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

//		Locators.Corporate().click();
		
		
//		 Locators.view().click();
	  	CorporateToEntity(test);
			Thread.sleep(3000);
		
		Locators.BulkUpload().click();
		
		Thread.sleep(3000);
Locators.CheckBox().click();
		Thread.sleep(3000);
		Locators.DownloadTemplate2().click();
		Thread.sleep(3000);
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Corporate-Entity\\EntityUpload__SelectedCB EmptyFile.xlsx");
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
				 
		 Locators.Upload().click();
					
					Thread.sleep(3000);
				
					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
					
					if(!text1.equalsIgnoreCase("File uploaded successfully!")) {
						test.log(LogStatus.PASS,"Message Displayed : "+text1);
				
					}else {
						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
					}
						Locators.ok().click();
		  	
	}
	
	public static void ResetBtn ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

//		Locators.Corporate().click();
		
		
//		 Locators.proceedEntity().click();
	  	
	  	CorporateToEntity(test);
	  	
		Thread.sleep(3000);
		
		Locators.BulkUpload().click();
		
		Thread.sleep(3000);
        Locators.CheckBox().click();
		Thread.sleep(3000);
		
		if(Locators.Reset().isEnabled()) {
			 
			test.log(LogStatus.PASS,  "  Check box should be preselected. Check box selection should get removed when user clicked on reset button."); 
			Locators.Reset().click();
	 }
	 else
	 {
	 	test.log(LogStatus.FAIL, "reset Button Working Failure.");
	 }
	  	 Thread.sleep(3000);
	  
				
					
		  	
	}
	
	public static void AllCheckbox ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

//		Locators.Corporate().click();
		
		
//		 Locators.view().click();
	  	
	  	CorporateToEntity(test); //Method
	  	
			Thread.sleep(3000);
		
		Locators.BulkUpload().click();
		
		Thread.sleep(3000);
		
		if(Locators.CheckBoxAll().isEnabled()) {
			 
			test.log(LogStatus.PASS,  "All the check boxes should get selected consolidatly"); 
			Locators.CheckBoxAll().click();
	 }
	 else
	 {
	 	test.log(LogStatus.FAIL, "All the check boxes Button Working Failure.");
	 }
	  	 Thread.sleep(3000);
	  
				
					
		  	
	}
	
	public static void EntityBack( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	CorporateToEntity(test);
			Thread.sleep(3000);
				
				
				 if(Locators.Back().isEnabled()) {
					 
						
						Locators.Back().click();
						 Thread.sleep(3000);
						String value = getDriver().getTitle();
						System.out.println(value);	//Assert.assertEquals(value, true);
						if(value!="")
						{
							test.log(LogStatus.PASS, "Back button working successfully.");
							test.log(LogStatus.PASS, "Page displayed : "+value);
					}
						else
						{
							test.log(LogStatus.PASS, "Back button does not work.");
							test.log(LogStatus.PASS, "Page displayed : "+value);

				}
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Back' button does not working");
				 }
				  	 Thread.sleep(3000);
				  
				
					
				
				
				
		  	
	}
	
	public static void  EntityLocation( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.EntityLocation().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
	  
	}
	
	public static void  EntityExcel( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.EntityExcel().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " :- File does not downloaded.");
		}
	  
		
		  	
	}
	
	public static void Searchentities ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				
				Locators.Searchentities().sendKeys("AVASO TECH PVT LTD"); // Writing Task title
				Thread.sleep(3000);
				
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//tbody/tr[1]/td[3]/div[1]")).getText();
				
					
				test.log(LogStatus.PASS, "The searched entity should get reflectd along with the customer name on the grid.");
				test.log(LogStatus.PASS, "entity selected : "+text);
					
			
	}
	
	public static void EntityBranchAddNew ( ExtentTest test) throws InterruptedException, IOException
	{		
		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                Locators.clickPremisesArrow().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
				
				Locators.Addpremises().click();
				Thread.sleep(2000);
				
				Locators.CateringApplicability().click();
				Thread.sleep(3000);
				
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(34);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.BranchName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				
				Locators.SearchUser().sendKeys("maharashtra"); // Writing Task title
				Thread.sleep(4000);
				
				Locators.Maharashtra().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(35);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.BranchAddress().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(3000);
				
				Locators.Location().sendKeys("aurangabad"); // Writing Task title
				Thread.sleep(4000);
				Locators.aurangabad().click();
				Thread.sleep(2000);
				
				js.executeScript("window.scrollBy(0,100)");
				
				Thread.sleep(2000);
				Locators.EstablishmentTypeb().click();
				Thread.sleep(2000);
				Locators.EstablishmentType1().click();
				Thread.sleep(5000);
				
				Locators.OfficeType().click();
				Thread.sleep(2000);
			//	Locators.OfficeType1().click();
				Thread.sleep(2000);
			//	Actions action = new Actions(getDriver());

				action.moveToElement(Locators.OfficeType1()).click().perform();
			
				row0 = sheet.getRow(36);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EmployerName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(37);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.EmployerAddress().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(38);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.ManagerName().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				row0 = sheet.getRow(39);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.ManagerAddress().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				js.executeScript("window.scrollBy(0,100)");
				
				row0 = sheet.getRow(40);
				c1 = row0.getCell(1); 
				int No = (int) c1.getNumericCellValue();
				Locators.CompanyPhNo().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				row0 = sheet.getRow(41);
				c1 = row0.getCell(1); 
				 No = (int) c1.getNumericCellValue();
				Locators.HRPhNo().sendKeys("" + No + ""); // Writing Task title
				Thread.sleep(4000);
				
				Locators.RCNumber().sendKeys(OneCommonMethod.getRandomString());
				
				//RC Valid From Calendar
				// Open calendar
				Locators.RCValidFromCalendar().click();
				Thread.sleep(1000);
				// Go to year selection
				getDriver().findElement(By.xpath("//*[@title='Navigate to parent view']")).click(); // once is enough
				Thread.sleep(2000);
				// Select year
				getDriver().findElement(By.xpath("//span[normalize-space()='2025']")).click(); // example year
				Thread.sleep(2000);
				// Select month
				getDriver().findElement(By.xpath("//td[@class='k-calendar-td k-focus']")).click();
				Thread.sleep(2000);
				// Select date
				getDriver().findElement(By.xpath("(//span[@class='k-link'][normalize-space()='5'])")).click(); // example date

				
				//RC Valid TO Calendar
				// Open calendar
				Locators.RCValidToCalendar().click();
				Thread.sleep(1000);
				// Go to year selection
				getDriver().findElement(By.xpath("//*[@title='Navigate to parent view']")).click(); // once is enough
				Thread.sleep(2000);
				// Select year
				getDriver().findElement(By.xpath("//span[normalize-space()='2027']")).click(); // example year
				Thread.sleep(2000);
				// Select month
				getDriver().findElement(By.xpath("//td[@class='k-calendar-td k-focus']")).click();
				Thread.sleep(2000);
				// Select date
				getDriver().findElement(By.xpath("(//span[@class='k-link'][normalize-space()='5'])")).click(); // example date
				
				
				
				js.executeScript("window.scrollBy(0,100)");
				
				row0 = sheet.getRow(42);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.NatureofBusiness().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.WorkTimings().click();
				Thread.sleep(2000);
				Locators.WorkTimings1().click();
				Thread.sleep(2000);
				
				Locators.WeekOffDays().click();
				Thread.sleep(2000);
				Locators.WeekOffDays1().click();
				Thread.sleep(2000);
				
				row0 = sheet.getRow(43);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Municipality().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				js.executeScript("window.scrollBy(0,100)");
				
				Thread.sleep(2000);
				Locators.BusinessType().click();
				Thread.sleep(2000);
				action.moveToElement(Locators.BusinessType1()).click().perform();
			//	Locators.BusinessType1().click();
				Thread.sleep(2000);
				
				Locators.Powertomposefines().click();
				Thread.sleep(2000);
				Locators.Powertomposefines1().click();
				Thread.sleep(2000);
				
				js.executeScript("window.scrollBy(0,100)");
				
				Thread.sleep(2000);
				Locators.MaintainForms().click();
				Thread.sleep(2000);
				Locators.MaintainForms1().click();
				Thread.sleep(2000);
				
				js.executeScript("window.scrollBy(0,100)");
				
				Thread.sleep(2000);
				Locators.TradeLicence().click();
				Thread.sleep(2000);
				Locators.TradeLicence1().click();
				Thread.sleep(2000);
				
				Locators.BranchStartDate().click();
				Thread.sleep(2000);
				Actions action1 = new Actions(getDriver());

				action1.moveToElement(Locators.CommencementDate1()).click().perform();
				
				
				js.executeScript("window.scrollBy(0,100)");
				
				Thread.sleep(2000);
				Locators.StatusB().click();
				Thread.sleep(2000);
				Locators.Status1().click();
				Thread.sleep(2000);
				
				Locators.LocationAnchor().sendKeys("Sunil Kumar"); // Writing Task title
				Thread.sleep(4000);
				
			//	Locators.LocationAnchor1().click();
				Thread.sleep(2000);
				js.executeScript("window.scrollBy(0,200)");
				
				Thread.sleep(2000);
				Locators.Save().click();
				
				Thread.sleep(10000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("Details Saved Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void  ExportPremises( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		Thread.sleep(5000);Thread.sleep(5000);Thread.sleep(5000);
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.clickPremisesArrow().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
	  	
	  	File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.ExportPremises().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
	  
	}
	
	public static void  Premises_AddressMapping( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		Thread.sleep(5000);Thread.sleep(5000);Thread.sleep(5000);
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

//		Locators.Searchentities().sendKeys("TESTAUTO3"); // Writing Task title
	  	OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO3");
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.clickPremisesArrow().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
				
                WebElement Tringle = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-right k-treelist-toggle k-svg-icon k-icon']"));
                Tringle.click();
                Thread.sleep(3000);
              //kendo-svgicon[@class='k-svg-i-caret-alt-right k-treelist-toggle k-svg-icon k-icon']
                WebElement Tringle2 = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-right k-treelist-toggle k-svg-icon k-icon']"));
                Tringle2.click();
                Thread.sleep(3000);
                
                Locators.OnboardEntityAddressMapping().click();
                Thread.sleep(10000);
                
                Locators.OnboardEntityAddressMapping_SaveButton().click();
                Thread.sleep(5000);
                
                
                OneCommonMethod.scroll(driver.get(), 5000); 
                Thread.sleep(5000);
                
                
        		String txt = Locators.MessageTextF4().getText();
        		
        		if(txt.equalsIgnoreCase("Save successfully"))
        		{
        			 test.log(LogStatus.PASS, "Address Mapping button is working fine");
        			 Thread.sleep(3000);
        			 test.log(LogStatus.PASS, "Save button is working fine");
        			 test.log(LogStatus.PASS, "Message Displayed : " + txt);
        		}
        		else {
        			 test.log(LogStatus.FAIL, "Message displayed : " + txt);
        			
        		}

	  
	}
	
	public static void  EditPremises( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		Thread.sleep(5000);Thread.sleep(5000);Thread.sleep(5000);
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

//		Locators.Searchentities().sendKeys("TESTAUTO3"); // Writing Task title
	  	OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO3");
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.clickPremisesArrow().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
				
                WebElement Tringle = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-right k-treelist-toggle k-svg-icon k-icon']"));
                Tringle.click();
                Thread.sleep(3000);
              //kendo-svgicon[@class='k-svg-i-caret-alt-right k-treelist-toggle k-svg-icon k-icon']
                WebElement Tringle2 = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-right k-treelist-toggle k-svg-icon k-icon']"));
                Tringle2.click();
                Thread.sleep(3000);
                
                Locators.OnboardEntityEdit().click();
                Thread.sleep(5000);
                OneCommonMethod.scroll(driver.get(), 5000); 
                Thread.sleep(5000);
                
                Locators.Save().click();
                Thread.sleep(8000);
                
        		String txt = DistributerLocators.MessageText().getText();
        		
        		if(txt.equalsIgnoreCase("Details Updated Successfully"))
        		{
        			 test.log(LogStatus.PASS, "Premises Edit button is working fine");
        			 Thread.sleep(3000);
        			 test.log(LogStatus.PASS, "Save button is working fine");
        			 test.log(LogStatus.PASS, "Message Displayed : " + txt);
        		}
        		else {
        			 test.log(LogStatus.FAIL, "Message displayed : " + txt);
        			
        		}
                
                
                
	  	
	  
	}
	
	
	public static void UploadBranch ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
		
		
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.UpoadBranchSam().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "sample File downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "sample File does not downloaded.");
		}
		

		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\LocationSampleUpdate_AVACORED5_20250221T051451141Z.xlsx");
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
				 
		 Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("File uploaded successfully")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static boolean UploadBranchInvalid ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.clickPremisesArrow().click();
				Thread.sleep(6000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
		
		
		Thread.sleep(3000);
//        Locators.UpoadBranchSam().click();
		getDriver().findElement(By.xpath("//img[@title='Bulk Upload']")).click();
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download
		
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\PremisesInvalidDetails.xlsx");
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
				 
		 Locators.Upload1().click();
					
		 Thread.sleep(3000);
		 Locators.ok().click();
		 Thread.sleep(8000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			
			int len1 = dirContents.length;
			int len2 = allFilesNew.length;
			
			System.out.println(len1);
			System.out.println(len2);
			Thread.sleep(3000);
			if(len1<len2)
			{
			
				return true;

			}
			else
			{
			
				return false;
				}

			
	
		  	
	}
	
	public static void UploadBranchCheck ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("TESTAUTO3"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.clickPremisesArrow().click();
				Thread.sleep(6000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
		Thread.sleep(4000);
		Locators.CheckBox6().click();
		
		Thread.sleep(3000);
Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\OtherTwo\\Distributor_Premises_SelectedCB.xlsx");
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
		
		 Thread.sleep(2000);
				 
		 Locators.Upload1().click();
					
		
			Thread.sleep(5000);
			
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			Thread.sleep(5000);
			if(text1.equalsIgnoreCase("File uploaded successfully")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadInvalidCheck ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(10000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("TESTAUTO3"); // Writing Task title
		Thread.sleep(10000);
		
				
				Thread.sleep(3000);
                 Locators.clickPremisesArrow().click();
				Thread.sleep(6000);
				


				//Correct Entity Verification
                OneCommonMethod.verifyTestEntity(
	            driver.get(), test,
	            By.xpath("//span[normalize-space()='Test Automation 3[TESTAUTO3]']"),
	            "Test Automation 3[TESTAUTO3]"
	             );



				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
		Thread.sleep(4000);
		Locators.CheckBox().click();
		
		Thread.sleep(3000);
		Locators.CheckBox().click();
		Thread.sleep(3000);
Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\OtherTwo\\Distributor_Premises_SelectedCB Invalid.xlsx");
		 //copy above file to clipboard
		 Thread.sleep(2000);
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
		
		 Thread.sleep(2000);
				 
		 Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			Thread.sleep(5000);
			if(text1.equalsIgnoreCase("Invalid Template.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadBranchCheckEmpty ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(10000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("TESTAUTO3"); // Writing Task title
		Thread.sleep(10000);
		
				
        
				Thread.sleep(3000);
                 Locators.clickPremisesArrow().click();
                 
         		//Correct Entity Verification
                 OneCommonMethod.verifyTestEntity(
                 driver.get(), test,
                 By.xpath("//span[normalize-space()='Test Automation 3[TESTAUTO3]']"),
                 "Test Automation 3[TESTAUTO3]"
                  );
                 
                 
				Thread.sleep(4000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
		Thread.sleep(4000);
		Locators.CheckBox().click();
		
		Thread.sleep(3000);
Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\PremisesSelectedCheckBoxEmpty.xlsx");
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
		
		 Thread.sleep(2000);
				 
		 Locators.Upload1().click();
					

			Thread.sleep(3000);
	
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			Thread.sleep(2000);
			if(text1.equalsIgnoreCase("Empty Sheet")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadBranchEmpty ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
	
		Thread.sleep(3000);
		Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\PremisesEmptyFile.xlsx");
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
				 
		 Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Empty Sheet")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadBranchInvalidTemp ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(10000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("TESTAUTO3"); // Writing Task title
		Thread.sleep(10000);
		
				
				Thread.sleep(2000);
                 Locators.clickPremisesArrow().click();
                 
               //Correct Entity Verification
                 OneCommonMethod.verifyTestEntity(
                 driver.get(), test,
                 By.xpath("//span[normalize-space()='Test Automation 3[TESTAUTO3]']"),
                 "Test Automation 3[TESTAUTO3]"
                  );
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
	
		Thread.sleep(3000);
		Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\Other Upload No need to change\\PaycodeUpload.xlsx");
		 //copy above file to clipboard
		 Thread.sleep(2000);
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		 Thread.sleep(3000);
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
		
		 //Release CRTL
		 robot.keyRelease(KeyEvent.VK_ENTER);
		
		 Thread.sleep(2000);
				 
		 Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Invalid Template.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadBranchCheckInvalidTemp ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
		Thread.sleep(3000);
		Locators.CheckBox().click();
	
		Thread.sleep(3000);
		Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Charge.xlsx");
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
				 
		 Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Invalid Template.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	
	public static void UploadBranchInvalidFormate ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
	
		Thread.sleep(3000);
		Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\work.txt");
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
				 
		// Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Please upload XLSX file only.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadBranchCheckInvalidFormate ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
		Locators.CheckBox().click();
		
		Thread.sleep(3000);
		Thread.sleep(3000);
		Locators.UpoadBranchSam().click();
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\work.txt");
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
				 
		// Locators.Upload1().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Please upload XLSX file only.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	
	public static void Upload( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
	
		Thread.sleep(3000);	 
		 Locators.Upload1().click();
			
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("You have not chosen any file.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadCheck( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
	
	Locators.CheckBox().click();
		
		Thread.sleep(3000);
		 Locators.Upload1().click();
			
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("You have not chosen any file.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	
	public static void UploadAddMapping ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UploadAddressMapping().click();
		
		
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.SampleDoc().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "Sample template download link working successfully.");
		} else {
			test.log(LogStatus.FAIL,  "sample File does not downloaded.");
		}
		

		Thread.sleep(3000);
		
	
		
		  	
	}
	
	public static void MUploadAddMapping ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UploadAddressMapping().click();
		
		
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.MasterDownload().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  " Master Download link working successfully.");
		} else {
			test.log(LogStatus.FAIL,  " Master file Download  does not downloaded.");
		}
		

		Thread.sleep(3000);
	}
	
	public static void UploadAddressMap ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UploadAddressMapping().click();
		
		
		
		Thread.sleep(500);
		Locators.SampleDoc().click();

		
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\SampleLocation.xlsx");
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
				 
		 Locators.UploadAM().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("File uploaded successfully")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadAddressMapEmpty ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UploadAddressMapping().click();
		
		
		
		Thread.sleep(500);
		Locators.SampleDoc().click();

		
		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\SampleLocation_empty.xlsx");
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
				 
		 Locators.UploadAM().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Please Upload File with some data")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static boolean UploadAddInvalid ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
				Locators.UploadAddressMapping().click();
				
				
				
				Thread.sleep(500);
				Locators.SampleDoc().click();

		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download
		
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\SampleLocation_Invalid.xlsx");
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
				 
		 Locators.UploadAM().click();
					
		 Thread.sleep(3000);
		 
		 String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Invalid Template.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
	
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			
			int len1 = dirContents.length;
			int len2 = allFilesNew.length;
			
			System.out.println(len1);
			System.out.println(len2);
			Thread.sleep(3000);
			if(len1<len2)
			{
			
				return true;

			}
			else
			{
			
				return false;
				}

	}
	
	public static void UploadAddInvalidTemp ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
Locators.UploadAddressMapping().click();

				Thread.sleep(500);
				Locators.SampleDoc().click();
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Charge.xlsx");
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
				 
		 Locators.UploadAM().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Invalid Template.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadAddInvalidFormate ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
				Locators.UploadAddressMapping().click();

				Thread.sleep(500);
				Locators.SampleDoc().click();
	
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\work.txt");
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
		
	//	 Thread.sleep(1000);
				 
	//	 Locators.UploadAM().click();
					
		
		
			Thread.sleep(7000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("Please upload XLSX file only.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	

				Thread.sleep(3000);
	}
	
	public static void UploadADD( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
				Locators.UploadAddressMapping().click();
	
		Thread.sleep(3000);	 
		Locators.UploadAM().click();
			
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("You have not chosen any file.")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	
	
	
	public static void branchDelete( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	 	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
			Thread.sleep(3000);
			
					
					Thread.sleep(3000);
	                 Locators.Dashboard().click();
					Thread.sleep(3000);
					Locators.OnboardEntity().click();
					Thread.sleep(8000);
					
					 FileInputStream fis = new FileInputStream(filePath);
				        Workbook workbook = WorkbookFactory.create(fis);
				        Sheet sheet = workbook.getSheetAt(1);
			 
				  	Thread.sleep(3000);
				
					int row = 0;
					Thread.sleep(500);
					Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
					Cell c1 = null;
					 	row0 = sheet.getRow(34);
					c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
					Locators.Searchbranch().sendKeys(c1.getStringCellValue()); // Writing Task title
					Thread.sleep(2000);
					
					action.moveToElement(Locators.BranchTriangle()).click().perform();
					
					Thread.sleep(3000);
					action.moveToElement(Locators.BranchTriangle1()).click().perform();
				
					Thread.sleep(3000);
				
				Locators.Deletebranch().click();
				Thread.sleep(3000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				Locators.DeleteOk().click();
				Thread.sleep(3000);
				String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				if(text1.equalsIgnoreCase("Deleted Successfully")) {
					test.log(LogStatus.PASS,"Message Displayed : "+text1);
			
				}else {
					test.log(LogStatus.FAIL,"Message Displayed : "+text1);
				}
					Locators.ok().click();
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void BDeleteCancel( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(34);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Searchbranch().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				

				action.moveToElement(Locators.BranchTriangle()).click().perform();
				
			Thread.sleep(3000);
			action.moveToElement(Locators.BranchTriangle1()).click().perform();
		
			Thread.sleep(3000);
			
			Locators.Deletebranch().click();
			Thread.sleep(3000);
				
				 if(Locators.DeleteCan().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Cancel' button working successfully."); 
						Locators.DeleteCan().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Cancel' button does not working");
				 }
				  	 Thread.sleep(3000);	
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void AllCheckBox( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
		
		Locators.UpoadBranch().click();
	
				
				
				
				 if(Locators.AllCheck().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Cancel' button working successfully."); 
						Locators.AllCheck().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Cancel' button does not working");
				 }
				  	 Thread.sleep(3000);	
					Thread.sleep(3000);
				
				
		  	
	}
	
	
	public static void SearchBranch ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				
			
	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(8000);
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(34);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Searchbranch().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				action.moveToElement(Locators.BranchTriangle()).click().perform();
				
				Thread.sleep(3000);
				action.moveToElement(Locators.BranchTriangle1()).click().perform();
			
				Thread.sleep(3000);
				
			
			
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//div[@title='aurangabad']")).getText();
				
					
				test.log(LogStatus.PASS, "Searched branch related data should get reflected in the grid.");
				test.log(LogStatus.PASS, "Branch selected : "+text);
					
	}
	
	public static void PayCodeAddNew ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
				
				
				Locators.PaycodeAdd().click();
				Thread.sleep(3000);
				
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(44);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Header().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.PaycodeType().click();
				Thread.sleep(2000);
				Locators.PaycodeType1().click();
				Thread.sleep(2000);
				
				Locators.Paycode().click();
				Thread.sleep(2000);
				Locators.Paycode1().click();
				Thread.sleep(2000);
		

				
				
				Locators.SequenceOrder().sendKeys("2"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("Details Saved Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void PayCodeAddNewError ( ExtentTest test, String user) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.
	  	Thread.sleep(5000);Thread.sleep(5000);Thread.sleep(5000);
	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.clickPremisesArrow().click();
				Thread.sleep(5000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
				
				
				Locators.PaycodeAdd().click();
				Thread.sleep(3000);
				
				
				FileInputStream fis = new FileInputStream(filePath);
			    Workbook workbook = WorkbookFactory.create(fis);
			    Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(44);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Header().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.PaycodeType().click();
				Thread.sleep(2000);
				Locators.PaycodeType1().click();
				Thread.sleep(2000);
				
				Locators.Paycode().click();
				Thread.sleep(2000);
				Locators.Paycode1().click();
				Thread.sleep(2000);
		

				
				if(user.equalsIgnoreCase("Distributor Paycode Add New Error"))
				{
				
				
				
				Locators.SequenceOrder().sendKeys("2"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Save().click();
				
				Thread.sleep(4000);
//				 By locator = By.xpath("//h4[@class='f-label']");
//				 wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				 
				 
				Thread.sleep(4000);
			//	String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				String text = Locators.MessageTextF4().getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("Paycode is already exists"))
				{
					test.log(LogStatus.PASS,"Pay code is not added");
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
				
				
				
				}
				
				else if(user.equalsIgnoreCase("Distributor - Paycode Sequence Error"))
				{
					Locators.SequenceOrder().sendKeys("201"); // Writing Task title
					Thread.sleep(2000);
					
					Locators.Save().click();
					
					Thread.sleep(4000);

					 
					 
					Thread.sleep(4000);
					String text2 = Locators.MessageTextF4().getText();
					
					if(text2.equalsIgnoreCase("Please Enter Valid Paycode Sequence. It should be less or equal to '200'."))
					{
						test.log(LogStatus.PASS,"Pay code is not added");
						test.log(LogStatus.PASS,"Message Displayed : "+text2);
					}
					else
					{
						
						test.log(LogStatus.FAIL,"Message Displayed : "+text2);
						
			}
					Locators.ok().click();
					Thread.sleep(4000);
				}
				
				
				
				
		  	
	}
	
	
	public static void OnboardEntityPaycodeSearchDropdown ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Thread.sleep(3000);Thread.sleep(3000);Thread.sleep(3000);
	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                Locators.clickPremisesArrow().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
				
				Locators.PaycodeSearch().click();
				Thread.sleep(3000);
				Locators.PaycodeSearch().sendKeys("Basic",Keys.ENTER);
				Thread.sleep(3000);
				Locators.Apply().click();
				Thread.sleep(3000);
				
				String txt = getDriver().findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
				
				if(txt.equalsIgnoreCase("Basic"))
				{
					test.log(LogStatus.PASS,"Search Paycode/Header Name drodpown is working fine");
					test.log(LogStatus.PASS,"Apply button is working fine");
					test.log(LogStatus.PASS,"Text displayed : " + txt);
				}
				else
				{
					test.log(LogStatus.PASS,"Text displayed : " + txt);
				}
		  	
	}
	
	public static void PayCodeAddNewInvalid ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
				
				
				Locators.PaycodeAdd().click();
				Thread.sleep(3000);
				
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(44);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Header().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.PaycodeType().click();
				Thread.sleep(2000);
				Locators.PaycodeType1().click();
				Thread.sleep(2000);
				
				Locators.Paycode().click();
				Thread.sleep(2000);
				Locators.Paycode1().click();
				Thread.sleep(2000);
		

				
				Locators.SequenceOrder().sendKeys("0"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("Sequence Order should not be zero"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void PayCodeEdit ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.
	  	Thread.sleep(3000);Thread.sleep(5000);Thread.sleep(5000);
	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(5000);
		
				
				Thread.sleep(3000);
                 Locators.clickPremisesArrow().click();
				Thread.sleep(5000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
				
				
				Locators.EditPaycod().click();
				Thread.sleep(3000);
				
				if(Locators.PaycodeHeaderNameField().isEnabled())
				{
				Locators.PaycodeHeaderNameField().clear();
				Thread.sleep(2000);
				Locators.PaycodeHeaderNameField().sendKeys("Basic");
				test.log(LogStatus.PASS, "Paycode header name text is editable");
				Thread.sleep(2000);
				}

				
				WebElement field = Locators.PaycodTypeField();

				boolean reallyDisabled = !field.isEnabled()                          // disabled
				                      || field.getAttribute("disabled") != null      // HTML attr
				                      || field.getAttribute("readonly") != null;     // readonly

				if (reallyDisabled) {
				    test.log(LogStatus.PASS, "Paycode Type field disabled/readonly");
				} else {
				    test.log(LogStatus.FAIL, "Paycode Type field enabled ❌");
				}
				
				
				
				WebElement fieldHeaderName = Locators.PaycodeDisabledField();

				boolean reallyDisabled2 = !fieldHeaderName.isEnabled()                          // disabled
				                      || fieldHeaderName.getAttribute("disabled") != null      // HTML attr
				                      || fieldHeaderName.getAttribute("readonly") != null;     // readonly

				if (reallyDisabled2) {
				    test.log(LogStatus.PASS, "Paycode field is disabled/readonly");
				} else {
				    test.log(LogStatus.FAIL, "Paycode field enabled ❌");
				}

				
				
				
				if(Locators.SequenceOrder().isDisplayed())
				{
				Locators.SequenceOrder().clear();
				Thread.sleep(3000);
				Locators.SequenceOrder().sendKeys("2"); // Writing Task title
				 test.log(LogStatus.PASS, "Sequence Order field is working fine");
				Thread.sleep(2000);
				}
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("Data Edited Successfully"))
				{
					test.log(LogStatus.PASS,"Save button is working fine ");
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	public static void PayCodeUploadSampleFile ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.
	  	Thread.sleep(3000);Thread.sleep(5000);Thread.sleep(5000);
	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(5000);
		
				
				Thread.sleep(3000);
                 Locators.clickPremisesArrow().click();
				Thread.sleep(5000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
				
				
				Locators.uploadPaycod().click();
				Thread.sleep(3000);
				
				OneCommonMethod.validateFileDownloadDynamic(
					    driver.get(),
					    test,
					    Locators.PaycodMasterSampleFileDownload(),   // WebElement
					    "Master Paycode Sample File Downloaded"   // Dynamic log message
					);
				
				Thread.sleep(3000);
				
				OneCommonMethod.validateFileDownloadDynamic(
					    driver.get(),
					    test,
					    Locators.PaycodUploadPaycodeDownload(),   // WebElement
					    "Upload Paycode Sample File Downloaded"   // Dynamic log message
					);
				
		  	
	}
	public static void PayCodeUploadCheck ( ExtentTest test) throws Exception
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.
	  	Thread.sleep(3000);Thread.sleep(5000);Thread.sleep(5000);
	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(5000);
		
				
				Thread.sleep(3000);
                 Locators.clickPremisesArrow().click();
				Thread.sleep(5000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
				
				
				Locators.uploadPaycod().click();
				Thread.sleep(3000);
				Locators.Browse().click();
				Thread.sleep(3000);
				
				OneCommonMethod.uploadUsingRobot("D:\\Upload Automation Files\\OtherTwo\\SamplePaycodeMappingUpload.xlsx");
				Locators.upload2().click();
				
        		String txt = Locators.MessageTextF4().getText();
        		
        		if(txt.equalsIgnoreCase("File uploaded successfully"))
        		{
        			 test.log(LogStatus.PASS, "File Upload button is working fine");
        			 Thread.sleep(3000);
        			 test.log(LogStatus.PASS, "File uploaded successfully ");
        			 test.log(LogStatus.PASS, "Message Displayed : " + txt);
        		}
        		else {
        			 test.log(LogStatus.FAIL, "Message displayed : " + txt);
        			
        		}
				
				
				
		  	
	}
	
	public static void UploadPaycode ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
		
		Locators.uploadPaycod().click();
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Locators.SamplePaycod().click();
		Thread.sleep(3000);

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "Sample file downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "sample File does not downloaded.");
		}
		

		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\SamplePaycodeMappingUpload.xlsx");
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
				 
		 Locators.Upload2().click();
					
		
		
			Thread.sleep(3000);
			
			
				
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("File uploaded successfully")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static boolean UploadPaycodeInvalid ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
		
		Locators.uploadPaycod().click();
		
		
		Thread.sleep(3000);
Locators.SamplePaycod().click();
		Thread.sleep(3000);
		
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download
		
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\SamplePaycodeMappingUpload (1).xlsx");
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
				 
		 Locators.Upload2().click();
		 Thread.sleep(2000);
	String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			
				Locators.ok().click();
  	
				 Thread.sleep(2000);
		
		 Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			
			int len1 = dirContents.length;
			int len2 = allFilesNew.length;
			
			System.out.println(len1);
			System.out.println(len2);
			Thread.sleep(3000);
			if(len1<len2)
			{
			
				return true;

			}
			else
			{
			
				return false;
				}
		  	
	}
	
	public static void UploadPaycodeEmpty ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
		
		Locators.uploadPaycod().click();
		
		
		Thread.sleep(3000);
Locators.SamplePaycod().click();
		Thread.sleep(3000);
		
	
		
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\SamplePaycodeMappingUpload (3).xlsx");
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
				 
		 Locators.Upload2().click();
		 Thread.sleep(2000);
	String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			
				Locators.ok().click();
  	
				 Thread.sleep(2000);
		
		 Thread.sleep(3000);
		  	
	}
	
	public static void SearchPaycode ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				
			
	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.OnboardEntity().click();
		Thread.sleep(5000);
		
		Locators.PaycodeMapping().click();
		Thread.sleep(3000);


				Locators.SearchUser().sendKeys("Total Deductions"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUser1().click();
				Thread.sleep(3000);
			
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-paycode-master/div[2]/app-grid-action-item/kendo-grid/div/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[1]/div")).getText();
				
					
				test.log(LogStatus.PASS, "Searched paycode should get reflected in the grid, along with header name, paycode type, sequence order, ESI applicable, PF applicable, PT applicable, LWF applicable.");
				test.log(LogStatus.PASS, "Paycode selected : "+text);
					
		
	}
	
	public static void SearchPaycodeClear ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				
			
	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.OnboardEntity().click();
		Thread.sleep(5000);
		
		Locators.PaycodeMapping().click();
		Thread.sleep(3000);


				Locators.SearchUser().sendKeys("Total Deductions"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUser1().click();
				Thread.sleep(3000);
			
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
						if(Locators.Clear().isEnabled()) {
							 
							test.log(LogStatus.PASS,  " Clear button working successfully."); 
							Locators.Users().click();
					 }
					 else
					 {
					 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
					 }
					  	 Thread.sleep(3000);
			
	}
	
	public static void PaycodeDelete( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.OnboardEntity().click();
		Thread.sleep(5000);
		
		Locators.PaycodeMapping().click();
		Thread.sleep(3000);
					
				
				Locators.Deletepaycode().click();
				Thread.sleep(3000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				Locators.DeleteOk().click();
				Thread.sleep(3000);
				String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				if(text1.equalsIgnoreCase("Data Deleted Successfully")) {
					test.log(LogStatus.PASS,"Message Displayed : "+text1);
			
				}else {
					test.log(LogStatus.FAIL,"Message Displayed : "+text1);
				}
					Locators.ok().click();
					
					Thread.sleep(3000);
				
				
		  	  
	}
	
	public static void PaycodeDeleteCancel( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.OnboardEntity().click();
		Thread.sleep(5000);
		
		Locators.PaycodeMapping().click();
		Thread.sleep(3000);
					
				
				Locators.Deletepaycode().click();
				Thread.sleep(3000);
				
				 if(Locators.DeleteCan().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Cancel' button working successfully."); 
						Locators.DeleteCan().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Cancel' button does not working");
				 }
				  	 Thread.sleep(3000);	
					Thread.sleep(3000);	
		  	
	}
	
	public static void Mapuser ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.
	  	Thread.sleep(3000);Thread.sleep(5000);Thread.sleep(5000);
	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(8000);
                 Locators.clickPremisesArrow().click();
				Thread.sleep(5000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.UserBranchMapping().click();
				Thread.sleep(3000);
				
				
				Locators.MapUser().click();
				Thread.sleep(3000);
				
			
				Locators.SearchAct().sendKeys("Shops and"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Shops().click();
				Thread.sleep(2000);
				
				Locators.Branch().click();
				Thread.sleep(2000);
				Locators.Branchtri().click();
				Thread.sleep(2000);
				Locators.Branchtri1().click();
				Thread.sleep(2000);
				Locators.Branch1().click();
				Thread.sleep(2000);
		
				Locators.SearchUserm().sendKeys("QA (mahesh.darandale@tlregtech.in)"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUserm2().click();
				Thread.sleep(2000);
				
				
			
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("(//h4[@class='f-label'])");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("(//h4[@class='f-label'])")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("User Branch mapped successfully..."))
				{
					test.log(LogStatus.PASS,"Map User button is working fine");
					Thread.sleep(1000);
					test.log(LogStatus.PASS,"All dropdowns filters is working fine");
					Thread.sleep(2000);
					test.log(LogStatus.PASS,"User Mapped successfully");
					Thread.sleep(1000);
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void Mapuseralready ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.UserBranchMapping().click();
				Thread.sleep(3000);
				
				
				Locators.MapUser().click();
				Thread.sleep(3000);
				
			
				Locators.SearchAct().sendKeys("Shops and"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Shops().click();
				Thread.sleep(2000);
				
				Locators.Branch().click();
				Thread.sleep(2000);
				Locators.Branchtri().click();
				Thread.sleep(2000);
				Locators.Branchtri1().click();
				Thread.sleep(2000);
				Locators.Branch1().click();
				Thread.sleep(2000);
		
				Locators.SearchUserm().sendKeys("sagar (sag"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUserm1().click();
				Thread.sleep(2000);
				
				
			
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("(//h4[@class='f-label'])[3]");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("(//h4[@class='f-label'])[3]")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(!text.equalsIgnoreCase("User Branch mapped successfully..."))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	
	public static void MapuserManagement ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.UserBranchMapping().click();
				Thread.sleep(3000);
				
				
				Locators.MapUser().click();
				Thread.sleep(3000);
				Locators.Management().click();
				Thread.sleep(3000);
			
				Locators.SearchAct().sendKeys("Shops and"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Shops().click();
				Thread.sleep(2000);
				
				Locators.Branch().click();
				Thread.sleep(2000);
				Locators.Branchtri().click();
				Thread.sleep(2000);
				Locators.Branchtri1().click();
				Thread.sleep(2000);
				Locators.Branch1().click();
				Thread.sleep(2000);
				
				Locators.SearchUserm().sendKeys("Jassimran (jassimran"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUsermA().click();
				Thread.sleep(2000);
				
			
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("(//h4[@class='f-label'])[3]");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("(//h4[@class='f-label'])[3]")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("User Branch mapped successfully..."))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void MapuserManagementAlredy ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.UserBranchMapping().click();
				Thread.sleep(3000);
				
				
				Locators.MapUser().click();
				Thread.sleep(3000);
				Locators.Management().click();
				Thread.sleep(3000);
			
				Locators.SearchAct().sendKeys("Shops and"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Shops().click();
				Thread.sleep(2000);
				
				Locators.Branch().click();
				Thread.sleep(2000);
				Locators.Branchtri().click();
				Thread.sleep(2000);
				Locators.Branchtri1().click();
				Thread.sleep(2000);
				Locators.Branch1().click();
				Thread.sleep(2000);
				
				Locators.SearchUserm().sendKeys("Jassimran (jassimran"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUsermA().click();
				Thread.sleep(2000);
				
			
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("(//h4[@class='f-label'])[3]");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("(//h4[@class='f-label'])[3]")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(!text.equalsIgnoreCase("User Branch mapped successfully..."))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	
	public static void UserMapDelete( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.UserBranchMapping().click();
				Thread.sleep(3000);
				
				Locators.DeleteEntity().click();
				Thread.sleep(3000);
				
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				Locators.DeleteOk().click();
				Thread.sleep(3000);
				String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				
					
					test.log(LogStatus.PASS,"Message Displayed : "+text1);
			
					
					Locators.ok().click();
					
					Thread.sleep(3000);
				
				
		  	
	}
	
	public static void UserMapFilter( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.UserBranchMapping().click();
				Thread.sleep(3000);
				
				Locators.SelectAct().click();
				Thread.sleep(1000);
				Locators.Shops().click();
				Thread.sleep(3000);
		      
		      
		       Locators.SelectBranch().click();
				Thread.sleep(1000);
				Locators.Branchtri().click();
				Thread.sleep(3000);
				Locators.Branchtri2().click();
				Thread.sleep(3000);
				
				Locators.SearchUser().sendKeys("Jassimran (jassimran"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUsermA().click();
				Thread.sleep(2000);
		      
		       
				Locators.Apply().click();
			
		       Thread.sleep(3000);
		        List<String> li=new ArrayList<String>();
		        
		       
		        li.add("Mumbai Branch");
		        li.add("Jassimran Singh");
		        Thread.sleep(3000);
		        
				List<String> filter=new ArrayList<String>();	
			
				filter.add("Branches");	
				filter.add("User");	
				
				
				Thread.sleep(8000);
				
				String s = Locators.Grid().getText();
				Thread.sleep(3000);
				if(!s.equalsIgnoreCase("No items to display")) {
				Thread.sleep(5000);
			
				
				List<WebElement> Branch=getDriver().findElements(By.xpath("(//*[@class='cell-content'])[2]"));
				List<WebElement> Username=getDriver().findElements(By.xpath("(//*[@class='cell-content'])[3]"));
				Thread.sleep(2000);

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
							raw.addAll(Username);
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
					test.log(LogStatus.PASS,"No records found");	
				}
				Thread.sleep(8000);
				
				
				Thread.sleep(8000);
				if(Locators.ClearFilter().isEnabled())
				{
					test.log(LogStatus.PASS, "while click on Clear Button selected data should be cleared");
				
					Locators.ClearFilter().click();
				}
			
			else
			{
				test.log(LogStatus.FAIL, "while click on Clear Button selected data not cleared");
				
			}
				
		  	
	}
	
	public static void UserMapFilterClear( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.OnboardEntity().click();
				Thread.sleep(5000);
				
				Locators.UserBranchMapping().click();
				Thread.sleep(3000);
				
				Locators.SelectAct().click();
				Thread.sleep(1000);
				Locators.Shops().click();
				Thread.sleep(3000);
		      
		      
		       Locators.SelectBranch().click();
				Thread.sleep(1000);
				Locators.Branchtri().click();
				Thread.sleep(3000);
				Locators.Branchtri2().click();
				Thread.sleep(3000);
				
				Locators.SearchUser().sendKeys("Jassimran (jassimran"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.SearchUsermA().click();
				Thread.sleep(2000);
		      
		       
				Locators.Apply().click();
			
		       
						
				
				Thread.sleep(8000);
				if(Locators.ClearFilter().isEnabled())
				{
					test.log(LogStatus.PASS, "while click on Clear Button selected data should be cleared");
				
					Locators.ClearFilter().click();
				}
			
			else
			{
				test.log(LogStatus.FAIL, "while click on Clear Button selected data not cleared");
				
			}
				
		  	
	}
	
	
	public static void MapuserDeleteCancel( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.OnboardEntity().click();
		Thread.sleep(5000);
		
		Locators.UserBranchMapping().click();
		Thread.sleep(3000);
		
		Locators.DeleteEntity().click();
		Thread.sleep(3000);
				
				 if(Locators.DeleteCan().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Cancel' button working successfully."); 
						Locators.DeleteCan().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Cancel' button does not working");
				 }
				  	 Thread.sleep(3000);	
					Thread.sleep(3000);	  	
	}
	
	public static void Exportleavetype( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  //	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
		 Locators.Dashboard().click();
			Thread.sleep(3000);
			Locators.ManageMasters().click();
			Thread.sleep(5000);
			Locators.LeaveType().click();
			Thread.sleep(3000);
			
				 Thread.sleep(3000);
				 JavascriptExecutor js = (JavascriptExecutor) getDriver();
					js.executeScript("window.scrollBy(0,300)");	
					Thread.sleep(5000);
				 Thread.sleep(2000); 		
					Locators.Gridcount().click();					//Clicking on Text of total items just to scroll down.
					Thread.sleep(1000);
					String s = 	Locators.Gridcount().getText();
					Thread.sleep(8000);
					String[] bits = s.split(" ");								//Splitting the String
					String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
					int count1 = Integer.parseInt(compliancesCount);
				
					if(compliancesCount.equalsIgnoreCase("to"))
					{
						Thread.sleep(5000);
					   s = Locators.Gridcount().getText();
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
			Locators.Export().click();
			Thread.sleep(9000);	
			test.log(LogStatus.PASS, " :- File downloaded successfully.");

			Thread.sleep(5500);
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
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
				
				
		  	
	}
	
	public static void Searchleave ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	//  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
		 Locators.Dashboard().click();
			Thread.sleep(3000);
			Locators.ManageMasters().click();
			Thread.sleep(5000);
			Locators.LeaveType().click();
			Thread.sleep(3000);
				
				Locators.Search().click();
				Thread.sleep(3000);
				Locators.SearchLT().click();
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
				Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("(//*[@class='cell-content'])[3]")).getText();
				
					
				test.log(LogStatus.PASS, "Leave Type dropdown working successfully.");
				test.log(LogStatus.PASS, "Leave Type selected : "+text);
					
		
				
				
		  	
	}
	
	public static void SearchleaveClear ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  //	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
		 Locators.Dashboard().click();
			Thread.sleep(3000);
			Locators.ManageMasters().click();
			Thread.sleep(5000);
			Locators.LeaveType().click();
			Thread.sleep(3000);
				
				Locators.Search().click();
				Thread.sleep(3000);
				Locators.SearchLT().click();
				Thread.sleep(3000);
		
					 Locators.Apply().click();
						Thread.sleep(3000);
			
						 if(Locators.ClearFilter().isEnabled()) {
							 
								test.log(LogStatus.PASS,  " Clear button working successfully."); 
								Locators.ClearFilter().click();
						 }
						 else
						 {
						 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
						 }
		
				
				
		  	
	}
	
	public static void PayCodeAddNewMM ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	//  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.ManageMasters().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
				
				
				Locators.PaycodeAdd().click();
				Thread.sleep(3000);
				
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(44);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Header().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.PaycodeType().click();
				Thread.sleep(2000);
				Locators.PaycodeType1().click();
				Thread.sleep(2000);
				
				Locators.Paycode().click();
				Thread.sleep(2000);
				Locators.Paycode1().click();
				Thread.sleep(2000);
		

				
				
				Locators.SequenceOrder().sendKeys("2"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("Data Saved Successfully..."))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void PayCodeAddNewInvalidMM ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  //	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.ManageMasters().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
				
				
				
				Locators.PaycodeAdd().click();
				Thread.sleep(3000);
				
				
				 FileInputStream fis = new FileInputStream(filePath);
			        Workbook workbook = WorkbookFactory.create(fis);
			        Sheet sheet = workbook.getSheetAt(1);
		 
			  	Thread.sleep(3000);
			
				int row = 0;
				Thread.sleep(500);
				Row row0 = sheet.getRow(row); // Selected 0th index row (First row)
				Cell c1 = null;
				 	row0 = sheet.getRow(44);
				c1 = row0.getCell(1); // Selected cell (0 row,2 column) (2 column = third column)
				Locators.Header().sendKeys(c1.getStringCellValue()); // Writing Task title
				Thread.sleep(2000);
				
				Locators.PaycodeType().click();
				Thread.sleep(2000);
				Locators.PaycodeType1().click();
				Thread.sleep(2000);
				
				Locators.Paycode().click();
				Thread.sleep(2000);
				Locators.Paycode1().click();
				Thread.sleep(2000);
		

				
				Locators.SequenceOrder().sendKeys("0"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("Sequence Order should not be zero"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void PayCodeEditMM ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	 // 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.ManageMasters().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
				
				
				Locators.EditPaycod().click();
				Thread.sleep(3000);
				
				Locators.SequenceOrder().clear();
				Thread.sleep(3000);
				
				Locators.SequenceOrder().sendKeys("2"); // Writing Task title
				Thread.sleep(2000);
				
				Locators.Save().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				//List<WebElement> custdd = getDriver().findElements(By.xpath("//*[@class='k-input-value-text']"));
			//	selectOptionFromDropDown_bs(custdd, "Active");
				if(text.equalsIgnoreCase("Data Edited Successfully"))
				{
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	public static void UploadPaycodeMM ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	//  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.ManageMasters().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
		
		Locators.uploadPaycod().click();
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Locators.SamplePaycod().click();
		Thread.sleep(3000);

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {
			test.log(LogStatus.PASS,  "Sample file downloaded successfully.");
		} else {
			test.log(LogStatus.FAIL,  "sample File does not downloaded.");
		}
		

		Thread.sleep(3000);
		
	
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\SamplePaycodeMappingUpload.xlsx");
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
				 
		 Locators.Upload2().click();
		
			Thread.sleep(3000);
			
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(text1.equalsIgnoreCase("File uploaded successfully")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static boolean UploadPaycodeInvalidMM ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  //	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.ManageMasters().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
		
		Locators.uploadPaycod().click();
		
		
		Thread.sleep(3000);
Locators.SamplePaycod().click();
		Thread.sleep(3000);
		
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download
		
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\SamplePaycodeMappingUpload (1).xlsx");
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
				 
		 Locators.Upload2().click();
		 Thread.sleep(2000);
	String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			
				Locators.ok().click();
  	
				 Thread.sleep(2000);
		
		 Thread.sleep(3000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			
			int len1 = dirContents.length;
			int len2 = allFilesNew.length;
			
			System.out.println(len1);
			System.out.println(len2);
			Thread.sleep(3000);
			if(len1<len2)
			{
			
				return true;

			}
			else
			{
			
				return false;
				}
		  	
	}
	
	public static void UploadPaycodeEmptyMM ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  //	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.ManageMasters().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
		
		Locators.uploadPaycod().click();
		
		
		Thread.sleep(3000);
Locators.SamplePaycod().click();
		Thread.sleep(3000);
		
	
		
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\SamplePaycodeMappingUpload (3).xlsx");
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
				 
		 Locators.Upload2().click();
		 Thread.sleep(2000);
	String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			
				Locators.ok().click();
  	
				 Thread.sleep(2000);
		
		 Thread.sleep(3000);
		  	
	}
	
	public static void UploadPaycodeforMM ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	 // 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.ManageMasters().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
		
		Locators.uploadPaycod().click();
		Thread.sleep(3000);

		
		Locators.Browse().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\work.txt");
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
				 
		// Locators.Upload2().click();
		
			Thread.sleep(3000);
			
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(!text1.equalsIgnoreCase("File uploaded successfully")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void UploadPaycodeNoMM ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	 // 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
				Thread.sleep(3000);
                 Locators.Dashboard().click();
				Thread.sleep(3000);
				Locators.ManageMasters().click();
				Thread.sleep(5000);
				
				Locators.PaycodeMapping().click();
				Thread.sleep(3000);
		
		Locators.uploadPaycod().click();
		Thread.sleep(3000);

		
		 Locators.Upload2().click();
		
			Thread.sleep(3000);
			
			String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
			
			if(!text1.equalsIgnoreCase("File uploaded successfully")) {
				test.log(LogStatus.PASS,"Message Displayed : "+text1);
		
			}else {
				test.log(LogStatus.FAIL,"Message Displayed : "+text1);
			}
				Locators.ok().click();
  	
		  	
	}
	
	public static void SearchPaycodeMM ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	 // 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				
			
	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.ManageMasters().click();
		Thread.sleep(5000);
		
		Locators.PaycodeMapping().click();
		Thread.sleep(3000);


		Locators.Search().click();
		Thread.sleep(3000);
		Locators.SearchLT().click();
		Thread.sleep(3000);

			 Locators.Apply().click();
				Thread.sleep(3000);
	
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("(//*[@class='cell-content'])[1]")).getText();
		
					
				test.log(LogStatus.PASS, "Searched paycode should get reflected in the grid, along with header name, paycode type, sequence order, ESI applicable, PF applicable, PT applicable, LWF applicable.");
				test.log(LogStatus.PASS, "Paycode selected : "+text);
					
		
	}
	
	public static void SearchPaycodeClearMM ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	//  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				
			
	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.ManageMasters().click();
		Thread.sleep(5000);
		
		Locators.PaycodeMapping().click();
		Thread.sleep(3000);


		Locators.Search().click();
		Thread.sleep(3000);
		Locators.SearchLT().click();
		Thread.sleep(3000);

			 Locators.Apply().click();
				Thread.sleep(3000);
	
						if(Locators.ClearFilter().isEnabled()) {
							 
							test.log(LogStatus.PASS,  " Clear button working successfully."); 
							Locators.ClearFilter().click();
					 }
					 else
					 {
					 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
					 }
					  	 Thread.sleep(3000);
			
	}
	
	public static void PaycodeDeleteCancelMM( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  //	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.ManageMasters().click();
		Thread.sleep(5000);
		
		Locators.PaycodeMapping().click();
		Thread.sleep(3000);
					
				
				Locators.Deletepaycode().click();
				Thread.sleep(3000);
				
				 if(Locators.DeleteCan().isEnabled()) {
					 
						test.log(LogStatus.PASS,  " Cancel' button working successfully."); 
						Locators.DeleteCan().click();
				 }
				 else
				 {
				 	test.log(LogStatus.FAIL, "'Cancel' button does not working");
				 }
				  	 Thread.sleep(3000);	
					Thread.sleep(3000);	
		  	
	}
	
	public static void PaycodeDeleteMM( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	 // 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

		Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.ManageMasters().click();
		Thread.sleep(5000);
		
		Locators.PaycodeMapping().click();
		Thread.sleep(3000);
					
				
				Locators.Deletepaycode().click();
				Thread.sleep(3000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				Locators.DeleteOk().click();
				Thread.sleep(3000);
				String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				if(text1.equalsIgnoreCase("Data Deleted Successfully")) {
					test.log(LogStatus.PASS,"Message Displayed : "+text1);
			
				}else {
					test.log(LogStatus.FAIL,"Message Displayed : "+text1);
				}
					Locators.ok().click();
					
					Thread.sleep(3000);
				
				
		  	  
	}
	
	public static void ExportSM( ExtentTest test, String type) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  //	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
		 Locators.Dashboard().click();
			Thread.sleep(3000);
			Locators.ManageMasters().click();
			Thread.sleep(5000);
			Locators.StatutoryMaster().click();
			Thread.sleep(3000);
			
			Locators.ComplianceType().click();
			Thread.sleep(2000);
			if(type.equalsIgnoreCase("Challan")) {
				Locators.ComplianceType1().click();
				Thread.sleep(3000);
			}else if(type.equalsIgnoreCase("Register")) {
				Locators.ComplianceType2().click();
				Thread.sleep(3000);
			}else {
				Locators.ComplianceType3().click();
				Thread.sleep(3000);
			}
			
		
			Locators.Apply().click();
				 Thread.sleep(3000);
				 JavascriptExecutor js = (JavascriptExecutor) getDriver();
					js.executeScript("window.scrollBy(0,300)");	
					Thread.sleep(5000);
				 		
					Locators.Gridcount1().click();					//Clicking on Text of total items just to scroll down.
					Thread.sleep(1000);
					String s = 	Locators.Gridcount1().getText();
					Thread.sleep(8000);
					String[] bits = s.split(" ");								//Splitting the String
					String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
					int count1 = Integer.parseInt(compliancesCount);
				
					if(compliancesCount.equalsIgnoreCase("to"))
					{
						Thread.sleep(5000);
					   s = Locators.Gridcount1().getText();
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
			Locators.Export().click();
			Thread.sleep(9000);	
			test.log(LogStatus.PASS, " File downloaded successfully.");

			Thread.sleep(5500);
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
				test.log(LogStatus.FAIL, " :- File does not downloaded.");
			}
	  	
	}
	
	public static void SearchSMMM ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	//  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.

				
			
	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.ManageMasters().click();
		Thread.sleep(5000);
		
		Locators.StatutoryMaster().click();
		Thread.sleep(3000);
		
		Locators.ComplianceType().click();
		Thread.sleep(2000);
		
			Locators.ComplianceType2().click();
			Thread.sleep(3000);


		Locators.Search1().click();
		Thread.sleep(3000);
		Locators.SearchLT().click();
		Thread.sleep(3000);

			 Locators.Apply().click();
				Thread.sleep(3000);
	
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("(//*[@class='cell-content'])[3]")).getText();
		
					
				test.log(LogStatus.PASS, "Searched Form name should get reflected in the grid");
				test.log(LogStatus.PASS, "Form name selected : "+text);
					
		
	}
	
	
	public static void SearchSMClear ( ExtentTest test) throws InterruptedException, IOException
	{		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  //	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='User']")));	//Wait until records table get visible.
			
	  	Locators.Searchentities().sendKeys("AVACORED5"); // Writing Task title
		Thread.sleep(3000);
		
				
		Thread.sleep(3000);
        Locators.Dashboard().click();
		Thread.sleep(3000);
		Locators.ManageMasters().click();
		Thread.sleep(5000);
		
		Locators.StatutoryMaster().click();
		Thread.sleep(3000);
		
		Locators.ComplianceType().click();
		Thread.sleep(2000);
		
			Locators.ComplianceType2().click();
			Thread.sleep(3000);


		Locators.Search1().click();
		Thread.sleep(3000);
		Locators.SearchLT().click();
		Thread.sleep(3000);

			 Locators.Apply().click();
				Thread.sleep(3000);
	
				if(Locators.ClearFilter().isEnabled()) {
					 
					test.log(LogStatus.PASS,  " Clear button working successfully."); 
					Locators.ClearFilter().click();
			 }
			 else
			 {
			 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
			 }
			  	 Thread.sleep(3000);
		
		
	}
	
	
	
public static void selectOptionFromDropDown_bs(List<WebElement> options, String value) {
		
		for(WebElement option:options) {
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
	}

}
