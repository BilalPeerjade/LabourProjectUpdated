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
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Point;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.remote.RemoteWebElement;
	import org.openqa.selenium.support.Color;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

	import login.BasePage;
	import login.LoginLocators;


	public class MethodsP extends BasePage {
		
	    static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour.xlsx";
		
		public static void complianceBox( ExtentTest test, String user) throws InterruptedException, IOException
		{
		
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAENTITY");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
			
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
			Thread.sleep(2000);
		//	LoginLocators.Search().sendKeys("WWKRG");		
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.ComplianceBox()));
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
			
		int open = Integer.parseInt(LoginLocators.ComplianceBox().getText());	
		LoginLocators.ComplianceBox().click();					                
	    Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
		LoginLocators.ClosePopUp().click();
		Thread.sleep(3000);
		
		
		}
	else {
			
			test.log(LogStatus.PASS, "Compliance Count from grid is 0");

			}
		
		
	}
		
		public static void GridAndExcelCountMatch(ExtentTest test,XSSFWorkbook workbook  ) throws InterruptedException, IOException
		{
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
	        
	        js.executeScript("window.scrollBy(0,700)");
	        Thread.sleep(2000); 		
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
			
			Thread.sleep(2000);
	        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
	        
	        js1.executeScript("window.scrollBy(0,-1000)");
	        Thread.sleep(2000);

	Thread.sleep(1000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							

	Thread.sleep(1000);
	try {
	LoginLocators.Export().click();
	}
	catch(Exception e)
	{
		LoginLocators.Exportbtn().click();
		
	}
	Thread.sleep(7000);
	test.log(LogStatus.PASS, "File downloaded successfully.");

	Thread.sleep(5500);
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
		
		Thread.sleep(1000);
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
	Thread.sleep(20000);
	}
	catch(Exception e)
	{
		LoginLocators.Exportbtn().click();
		Thread.sleep(20000);
		
		}
	test.log(LogStatus.PASS, "Various Report : downloaded successfully.");

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
		test.log(LogStatus.FAIL, "Paycode master Report :  doesn't downloaded successfully.");
	}

			
		}



		public static void GridAndExcelCountMatch3(ExtentTest test,XSSFWorkbook workbook  ) throws InterruptedException, IOException
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
	test.log(LogStatus.PASS, "CLRA Compliance Assignment Report : downloaded successfully.");

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
		test.log(LogStatus.FAIL, "CLRA Compliance Assignment Report : doesn't downloaded successfully.");
	}

			
		}





		public static void UpcomingBox( ExtentTest test,String user) throws InterruptedException, IOException
		{
		
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAENTITY");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
		int open = Integer.parseInt(LoginLocators.UpcomingBox().getText());	//Reading Dashboard count.
		LoginLocators.UpcomingBox().click();					                //Clicking on Dashboard count
	    Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
	    
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
		
		public static void OverdueBox( ExtentTest test,String user) throws InterruptedException, IOException
		{
		
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAENTITY");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
			//LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
			//LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.SelectPeriodDashboard()));
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
		int open = Integer.parseInt(LoginLocators.OverdueBox().getText());	//Reading Dashboard count.
		LoginLocators.OverdueBox().click();					                //Clicking on Dashboard count
	    Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
	    
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
		
		public static void PendingActionBox( ExtentTest test,String user) throws InterruptedException, IOException
		{
		
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAENTITY");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
		int open = Integer.parseInt(LoginLocators.PendingActionBox().getText());	//Reading Dashboard count.
		LoginLocators.PendingActionBox().click();					                //Clicking on Dashboard count
	    Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
	    
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
		
		public static void PendingReviewBox( ExtentTest test,String user) throws InterruptedException, IOException
		{
		
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAENTITY");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
		int open = Integer.parseInt(LoginLocators.PendingReviewBox().getText());	//Reading Dashboard count.
		LoginLocators.PendingReviewBox().click();					                //Clicking on Dashboard count
	    Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
	    
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAENTITY");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("WWKRG");
		//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
		int open = Integer.parseInt(LoginLocators.RegisterUpcoming().getText());	//Reading Dashboard count.
		LoginLocators.RegisterUpcoming().click();					                //Clicking on Dashboard count
	    Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
	    
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
		
		public static void RegisterOverdue( ExtentTest test,String user) throws InterruptedException, IOException
		{
		
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAENTITY");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
		int open = Integer.parseInt(LoginLocators.RegisterOverdue().getText());	//Reading Dashboard count.
		LoginLocators.RegisterOverdue().click();					                //Clicking on Dashboard count
	    Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
	    
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAENTITY");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
		int open = Integer.parseInt(LoginLocators.RegisterActionReview().getText());	//Reading Dashboard count.
		LoginLocators.RegisterActionReview().click();					                //Clicking on Dashboard count
	    Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
	    
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAENTITY");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
		int open = Integer.parseInt(LoginLocators.ReturnUpcoming().getText());	//Reading Dashboard count.
		LoginLocators.ReturnUpcoming().click();					                //Clicking on Dashboard count
	    Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
	    
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
		
		public static void ReturnOverdue( ExtentTest test,String user) throws InterruptedException, IOException
		{
		
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAENTITY");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
		int open = Integer.parseInt(LoginLocators.ReturnOverdue().getText());	//Reading Dashboard count.
		LoginLocators.ReturnOverdue().click();					                //Clicking on Dashboard count
	    Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
	    
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAENTITY");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
		int open = Integer.parseInt(LoginLocators.ReturnActionReview().getText());	//Reading Dashboard count.
		LoginLocators.ReturnActionReview().click();					                //Clicking on Dashboard count
	    Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
	    
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAENTITY");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
		int open = Integer.parseInt(LoginLocators.ChallanUpcoming().getText());	//Reading Dashboard count.
		LoginLocators.ChallanUpcoming().click();					                //Clicking on Dashboard count
	    Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
	    
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
		
		public static void ChallanOverdue( ExtentTest test,String user) throws InterruptedException, IOException
		{
		
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAENTITY");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
		int open = Integer.parseInt(LoginLocators.ChallanOverdue().getText());	//Reading Dashboard count.
		LoginLocators.ChallanOverdue().click();					                //Clicking on Dashboard count
	    Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
	    
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAENTITY");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
			//LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
		int open = Integer.parseInt(LoginLocators.ChallanActionReview().getText());	//Reading Dashboard count.
		LoginLocators.ChallanActionReview().click();					                //Clicking on Dashboard count
	    Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));   
	    
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
				LocatorsP.HighRisk1().click();
				}
			else if(risk.equalsIgnoreCase("Medium"))
			{
				Thread.sleep(7000);
				LocatorsP.MediumRisk1().click();					//Clicking on High value of Pie Chart of 'Not Completed'.
				Thread.sleep(2000);
			}
			else if(risk.equalsIgnoreCase("Low"))
			{
				LocatorsP.LowRisk1().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
			}
							                  
		Thread.sleep(5000);
	   			
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
		Thread.sleep(7000);
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
				LocatorsP.CompHighRisk().click();
				wait.until(ExpectedConditions.visibilityOf(LoginLocators.TotalNumberOfItems()));
				Thread.sleep(5000);
			}
			else if(risk.equalsIgnoreCase("Medium"))
			{
				Thread.sleep(10000);
				LocatorsP.CompMediumRisk().click();					//Clicking on High value of Pie Chart of 'Not Completed'.
				Thread.sleep(2000);
			}
			else if(risk.equalsIgnoreCase("Low"))
			{
				LocatorsP.CompLowRisk().click();						//Clicking on Medium value of Pie Chart of 'Not Completed'.
			}
							                  
		Thread.sleep(4000);
	   			
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
		Thread.sleep(5000);
		
		//Explicit wait
		WebDriverWait wait2 = new WebDriverWait(getDriver(), (30));
		wait2.until(ExpectedConditions.visibilityOf(LoginLocators.CloseDocument()));
		
		Thread.sleep(8000);
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
			Thread.sleep(6000);
			LoginLocators.BranchCodeClearBtn().click();
			Thread.sleep(6000);
		}
		
		//LoginLocators.displayedrecord().getText();
		Thread.sleep(3000);	
		LoginLocators.ClearBtn().click();
		Thread.sleep(3000);	
		test.log(LogStatus.PASS, "Branch Code Filters working properly");
		Thread.sleep(360);
		test.log(LogStatus.PASS, "Branch Code Clear button is working properly");
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");

			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
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
		
//			LoginLocators.PenActnClosePopup().click();	
//	     	Thread.sleep(4000);
	//	
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
//		LoginLocators.SelectValue().click();
//		Thread.sleep(3000);
//		LoginLocators.SelectValueDropdown().click();
//		Thread.sleep(3000);
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
		
		public static void NotComplied(ExtentTest test,String user) throws InterruptedException, IOException
		{
		

			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");

			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
//		    
		    js.executeScript("window.scrollBy(0,300)");
		    Thread.sleep(500);
		    int open = Integer.parseInt(LoginLocators.NotCompliede().getText());	//Reading Dashboard count.
			Thread.sleep(2000);
		    
		                  
		Thread.sleep(9000);
	   			
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
	    MethodsP.GridAndExcelCountMatch(test,workbook);
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
			//LoginLocators.Search().sendKeys("WWKRG");

			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			
			Thread.sleep(4000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		    
		    js.executeScript("window.scrollBy(0,1000)");
		    if(LoginLocators.DailyUpdateHeader().isDisplayed())
		    {
		    	String dly = LoginLocators.DailyUpdate().getText();
		    	test.log(LogStatus.PASS, "Daily Update ="+dly);
	    	
		    }
		    else {
		    	test.log(LogStatus.FAIL, "Daily Update not displayed on dashboard");

		    }
		
		}
		public static void Brows(ExtentTest test) throws InterruptedException, IOException
		{
		

			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			
			LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
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
		public static void UpcomingFilter( ExtentTest test,String user) throws InterruptedException
		{
			
			
			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			Thread.sleep(3000);	
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
			LoginLocators.UpcomingBox().click();				                
	        Thread.sleep(2000);
		   
	        LoginLocators.SelectBranch().click();
	       Thread.sleep(3000);
	       LoginLocators.ExpandBranchnew().click();
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
		public static void OverdueFilter( ExtentTest test,String user) throws InterruptedException
		{
			
			
			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			Thread.sleep(3000);	
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
			LoginLocators.OverdueBox().click();				                
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

		public static void PendingActionFilter( ExtentTest test,String user) throws InterruptedException
		{
			
			
			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			Thread.sleep(3000);	
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
			//LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
			LoginLocators.PendingActionBox().click();				                
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

		public static void PendingReviewFilter( ExtentTest test,String user) throws InterruptedException
		{
			
			
			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			Thread.sleep(3000);	
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
			LoginLocators.PendingReviewBox().click();				                
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
		public static void RegisterUpcomingFilter( ExtentTest test,String user) throws InterruptedException
		{		
			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			Thread.sleep(3000);	
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(9000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(9000);
			LoginLocators.RegisterUpcoming().click();				                
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
		
		public static void RegisterOverdueFilter( ExtentTest test,String user) throws InterruptedException
		{		
			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			Thread.sleep(3000);	
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
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
				LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("WWKRG");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
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
				LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("WWKRG");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
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
				LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("WWKRG");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
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
				LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("WWKRG");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
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
				LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("WWKRG");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(2000);
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
			Thread.sleep(2000);
			LoginLocators.PenActnClosePopup().click();	
	     	Thread.sleep(4000);
//			LoginLocators.Complied().click();				                
	      Thread.sleep(2000);
		   
	        LoginLocators.SelectBranch().click();
	       Thread.sleep(3000);
	       LoginLocators.ExpandBranchnew1().click();
	       Thread.sleep(3000);
	       String branch =LoginLocators.Branchvalue1().getText();
	       Thread.sleep(2000);
	       LoginLocators.Branchvalue1().click();
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
	       LoginLocators.SelectYearvalue().click();
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
							if(text.get(l).equalsIgnoreCase("Pune_Branch Pune")||text.get(l).equalsIgnoreCase("Branch Pune"))
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
		
		public static void CompliedRiskSummaryGraphFilter( ExtentTest test,String user) throws InterruptedException
		{		
			WebDriverWait wait = new WebDriverWait( getDriver(),(60));
			Thread.sleep(3000);	
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
		//	LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodDashboard().click();
			Thread.sleep(2000);
			LoginLocators.SelectPeriodValue().click();
			Thread.sleep(2000);
	        JavascriptExecutor js = (JavascriptExecutor) getDriver();
		    
		    js.executeScript("window.scrollBy(0,300)");
		    Thread.sleep(2000);
			LoginLocators.CompHighRisk().click();				                
	        Thread.sleep(2000);
		   
	        LoginLocators.SelectBranch().click();
	       Thread.sleep(3000);
	       LoginLocators.ExpandBranch().click();
	       Thread.sleep(3000);
	       String branch =LoginLocators.Branchvalue().getText();
	       Thread.sleep(2000);
	       LoginLocators.Branchvalue().click();
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
	       LoginLocators.SelectYearvalue().click();
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
							if(text.get(l).equalsIgnoreCase("Gurgaon_Gurgaon")||text.get(l).equalsIgnoreCase("Gurgaon"))
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
			}
		//	LoginLocatorsLoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
		//	LoginLocators.Search().sendKeys("WWKRG");

			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
			LoginLocators.DashboardArrow().click();
			Thread.sleep(2000);
			LoginLocators.Report().click();
			Thread.sleep(2000);
			LoginLocators.Branch().click();
			Thread.sleep(2000);
			LoginLocators.BranchValue().click();
			Thread.sleep(2000);
			LoginLocators.ComplianceType().click();
			Thread.sleep(2000);
			LoginLocators.SelectValuetype().click();
			Thread.sleep(2000);
			LoginLocators.ApplyButton().click();
		    Thread.sleep(9000);
			MethodsP.GridAndExcelCountMatch1(test,workbook);
			Thread.sleep(3000);
			LoginLocators.ClearButton().click();
		    Thread.sleep(9000);
		    LoginLocators.StatusReport().click();
			Thread.sleep(2000);
			LoginLocators.Branch1().click();
			Thread.sleep(2000);
			LoginLocators.BranchValue().click();
			Thread.sleep(2000);
			LoginLocators.Monthly().click();
			Thread.sleep(2000);
			LoginLocators.MonthlyValue().click();
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
		    File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles();						//Counting number of files in directory before download
			
			Thread.sleep(3000);
			try {
			    LoginLocators.Export().click();
			    Thread.sleep(20000);
			    }
			    catch(Exception e)
			    {
			    	LoginLocators.Exportbtn().click();
			    	Thread.sleep(20000);
			    	
			    	}		
		 	Thread.sleep(9000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles();						//Counting number of files in directory after download
			
			Thread.sleep(3000);
		  
	        
		   if (dirContents.length < allFilesNew.length) {
			    test.log(LogStatus.PASS, "Status Report : File downloaded successfully.");
			}
		   else
		   {
			    test.log(LogStatus.FAIL, "Status Report : File Does not downloaded successfully.");
			}
		   Thread.sleep(1000);
		        LoginLocators.Clearbtn1().click();
			    Thread.sleep(2000);
			    LoginLocators.VariousReport().click();
				Thread.sleep(2000);
				LoginLocators.VariousType().click();
				Thread.sleep(2000);
				LoginLocators.VariousTypeValue().click();
				Thread.sleep(2000);
//				LoginLocators.Calender().click();
//				Thread.sleep(2000);
//				LoginLocators.Calenderyear().click();
//				Thread.sleep(2000);
//				LoginLocators.CalenderMonth().click();
//				Thread.sleep(2000);
				LoginLocators.ApplyBtn2().click();
			    Thread.sleep(9000);
			    MethodsP.GridAndExcelCountMatch2(test,workbook);
				Thread.sleep(3000);
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
			    MethodsP.GridAndExcelCountMatch3(test,workbook);
				Thread.sleep(3000);
			    LoginLocators.Clearbtn1().click();
			    Thread.sleep(9000);
		
		}
		public static void PendingActionPerform( ExtentTest test,String user) throws InterruptedException, IOException, AWTException
		{
		
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
		    
		    
		    
//	        LoginLocators.Brows().click();		
//			Runtime.getRuntime().exec("E:\\Labor Upload\\Laborfile.exe");
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
//		    // Copy file path to clipboard
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

			if(open != (open-1))
				
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
				LoginLocators.Search().sendKeys("AVACORP6");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVACORED5");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
			int open = Integer.parseInt(LoginLocators.PendingReviewBox().getText());	
		    Thread.sleep(2000);
		    LoginLocators.PendingReviewBox().click();
		    Thread.sleep(2000);
		    LoginLocators.PendingActionEdit().click();	
		    Thread.sleep(9000);
	        LoginLocators.ClosedDelayed().click();		
	        Thread.sleep(3000);
//	        JavascriptExecutor js = (JavascriptExecutor) getDriver();
//			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(2000);
	        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", LoginLocators.Remark());
			LoginLocators.Remark().sendKeys("Nill");
			 Thread.sleep(2000);
			 LoginLocators.Calender1().click();
			 Thread.sleep(2000);
			 LoginLocators.CalenderDate().click();
			 Thread.sleep(2000);
			LoginLocators.Submitt().click();
			Thread.sleep(2000);
//			LoginLocators.Closebtn().click();
//			Thread.sleep(2000);
			String  msg= LoginLocators.UploadSuccessfully().getText();
//			LoginLocators.OK().click();
//		    test.log(LogStatus.PASS, msg);
		    Thread.sleep(2000);
//		    LoginLocators.Submit().click();
//		    Thread.sleep(4000);
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
			LoginLocators.Closebtn().click();
			Thread.sleep(2000);
			LoginLocators.ClosePopup().click();
			Thread.sleep(2000);	
			int count = Integer.parseInt(LoginLocators.PendingReviewBox().getText());	

			if(open != (open-1))
				
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
			//LoginLocators.ExpandBranch().click();
			//Thread.sleep(2000);
			LoginLocators.branchvalue().click();
			Thread.sleep(2000);
			LoginLocators.ApplyButton().click();
			Thread.sleep(6000);
			
			try {
			MethodsP.Viewworspace(test,user);
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
	    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlyAttendance_20Feb2025063937.xlsx";
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
	      			//getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    		   LoginLocators.Refresh().click();
	    		   Thread.sleep(2000);	
	    		   test.log(LogStatus.PASS,  "Attendance "+ attendance);
	    		   
	    			wait.until(ExpectedConditions.visibilityOf(Uploadgreentick));
	    			Thread.sleep(2000);	
	    		//   LoginLocators.UploadedGreenTick().click();
//	    		   // Locate the element using the provided XPath
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
			
			MethodsP.Salary(test, user);	
			Thread.sleep(20000);	
			MethodsP.LeaveSummaryDetails(test, user);
			Thread.sleep(2000);	
			getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			LoginLocators.Refresh().click();
			Thread.sleep(2000);
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
	    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlySalary_20Feb2025064336.xlsx";
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
	    		   Thread.sleep(3000);
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
	    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlyLeaveSummary_20Feb2025064637.xlsx";
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("WWKRG");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
					test.log(LogStatus.PASS,  "file Downloaded from history.");
				}
			   else
			   {
					test.log(LogStatus.FAIL, "file Does Not Downloaded from history.");
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
		
		public static void WorkspaceReturn( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
		{
		
		//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
			MethodsP.Viewworspace(test,user);
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
			MethodsP.SalaryReturn(test, user);	
			Thread.sleep(2000);	
			MethodsP.LeaveSummaryDetailsReturn(test, user);
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
//			LoginLocators.frequency().click();
//			Thread.sleep(2000);
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
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
//			LoginLocators.Frequency().click();
//			Thread.sleep(2000);
//			LoginLocators.FrequencyValue().click();
//			Thread.sleep(2000);
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
			MethodsP.Viewworspace(test,user);
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
	    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlyChallanSalary_20Feb2025063022.xlsx";
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
	   			getDriver().manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
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
			MethodsP.SalaryChallan(test, user);	
			Thread.sleep(2000);	
			MethodsP.LeaveSummaryDetailsChallan(test, user);
			Thread.sleep(4000);	
			getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			 LoginLocators.Refresh().click();
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
	    	        String filePath = "E:\\Labor Upload\\Live Upload Sheet\\Sample-MonthlyChallanSalary_19Feb2025020415.xlsx";
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
		
		public static void Empty( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
		{
		


		//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
			WebDriverWait wait = new WebDriverWait(getDriver(), (120));
			Thread.sleep(7000);
			wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
			
//			try {
//			Methods.Viewworspace(test,user);
//			}
//			catch(Exception e) {
//				
//			}
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
			
//			try {
//			Methods.Viewworspace(test,user);
//			}
//			catch(Exception e) {
//				
//			}
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
//	        LoginLocators.Check().click();
//			   Thread.sleep(9000);
			//   LoginLocators.OK().click();
			//   Thread.sleep(2000);	
			   LoginLocators.Refresh().click();
//			wait.until(ExpectedConditions.visibilityOf(LoginLocators.GenerateDocument()));
//			LoginLocators.Refresh().click();
//			   LoginLocators.GenerateDocument().click();
//			   Thread.sleep(2000);	
//			   String msg = LoginLocators.GenerationMsg().getText();
//				test.log(LogStatus.PASS, msg);	
//				LoginLocators.OK().click();
//				   Thread.sleep(2000);	
			
			 
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("WWKRG");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
				LoginLocators.Search().sendKeys("AVAREGTR");
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVAREGTR");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("AVACORP6");	
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
			
//			try {
//			Methods.Viewworspace(test,user);
//			}
//			catch(Exception e) {
//				
//			}
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
			
	            
//	            	Thread.sleep(2000);	
//	    			File dir2 = new File("C:\\Users\\bilali\\Downloads");
//	    			File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
//	    			
//	    			Thread.sleep(9000);
//	    			
//	    	//	LoginLocators.AttendanceTemplate().click();
//	    			AttendanceTemplate.click();
//	    		 	Thread.sleep(18000);
//	    			File dir3 = new File("C:\\Users\\bilali\\Downloads");
//	    			File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
//	    			
//	    		   
//	    	        Thread.sleep(9000);
//	    		   if (dirContents1.length < allFilesNew1.length) {
//	    				//test.log(LogStatus.PASS,  "Attendance Template Downloaded.");
//	    			}
//	    		   else
//	    		   {
//	    			//	test.log(LogStatus.FAIL, "Attendance Template Does Not Downloaded.");
//	    			}		
//	    		   Thread.sleep(3000);
//	    		 //  LoginLocators.Browse().click();
	    		  
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

//		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
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

//		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		LoginLocators.ECRMasterTab().click();
		Thread.sleep(3000);
		MethodsP.GridAndExcelCount(test,workbook);
		Thread.sleep(2000);
		
	}

	public static void ECRMasterAddNew( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

//		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
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
		LoginLocators.UserID().sendKeys(id+"89031");
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

//		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
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

//		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
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

//		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
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
		LoginLocators.ClientID().sendKeys("AVATCGENGVT");
		Thread.sleep(500);
		LoginLocators.UserID().click();
		LoginLocators.UserID().sendKeys("4567890123578905");
		Thread.sleep(500);
		LoginLocators.password().click();
		LoginLocators.password().sendKeys("teamlease");
		Thread.sleep(500);
		LoginLocators.Save().click();
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

//		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("WWKRG");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
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

//		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		Thread.sleep(2000);
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.ESICCards().click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);
//		LoginLocators.ECRMasterTab().click();
//		Thread.sleep(3000);
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

	public static void AddUser( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

//		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
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
		   MethodsP.GridAndExcelCounts(test,workbook);
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

//		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
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
		   MethodsP.GridAndExcelCounts(test,workbook);
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

//		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
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

//		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
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
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
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
//		LoginLocators.rcnumber().click();
//		Thread.sleep(500);	
		LoginLocators.checkbox().click();
		Thread.sleep(500);
		LoginLocators.SaveDocument().click();
		Thread.sleep(500);
		String msg = LoginLocators.MessageDisplayed1().getText();
		   Thread.sleep(2000);
		   if(msg.equalsIgnoreCase("Record Updated Successfully!"))
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
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
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
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.MyDocument().click();
		Thread.sleep(2000);
		LoginLocators.DigitalSignatureTab().click();
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
		   MethodsP.DigitalSignatureEdit(test,user);
		   
	}

	public static void DigitalSignatureEdit(ExtentTest test,String user) throws InterruptedException, IOException, AWTException
	{


//		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
//		Thread.sleep(7000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
//		if(user.equalsIgnoreCase("Performer"))
//		{
//			LoginLocators.Search().sendKeys("Regtrack Pvt Ltd");
//		}
//		else if(user.equalsIgnoreCase("Distributor"))
//		{
//			LoginLocators.Search().sendKeys("WWKRG");	
//		}
//		else if(user.equalsIgnoreCase("Reviewer"))
//		{
//			LoginLocators.Search().sendKeys("Angular Entity");	
//		}
//		Thread.sleep(2000);
//		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
//		LoginLocators.DashboardArrow().click();
//		Thread.sleep(2000);
//		LoginLocators.MyDocument().click();
//		Thread.sleep(2000);
//		LoginLocators.DigitalSignatureTab().click();
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

//		WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVAREGTR");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("AVACORP6");	
		}
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.DashboardArrow()));
		Thread.sleep(2000);
		LoginLocators.DashboardArrow().click();
		Thread.sleep(2000);
		LoginLocators.MyDocument().click();
		Thread.sleep(2000);
		String searchvalue = LoginLocators.GridValue().getText();
		Thread.sleep(500);
		LoginLocators.Search1().sendKeys(searchvalue);
//		LoginLocators.Search1().click();
//		Thread.sleep(2000);
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

	}




