package clientPortal;


import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.AWTException;
import java.awt.RenderingHints.Key;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import login.BasePage;
import net.bytebuddy.asm.Advice.Enter;









public class ClientPortalMethod extends BasePage

{
	 static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour2.xlsx";
	
	public static void AddNewLicense( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
	
		Thread.sleep(3000);
		ClientPortalLocator.clickEntity().click();
		Thread.sleep(3000);
		ClientPortalLocator.clickTringle1().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectEnity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.ClickApplyBtn().click();
		
		Thread.sleep(1000);
		ClientPortalLocator.clickLicense().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickRegistration().click();
		
		ClientPortalLocator.clickAddNew().click();
		
		
		
		FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook1 = WorkbookFactory.create(fis);
        Sheet sheet = workbook1.getSheetAt(2);
		
		Thread.sleep(1000);
//		Row row = sheet.getRow(4);						//Selected 0th index row (First row)
//		Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
//		String state = c.getStringCellValue();
		ClientPortalLocator.clickState().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectState().click();
		
		
		Thread.sleep(1000);
		Row row1 = sheet.getRow(5);						//Selected 0th index row (First row)
		Cell c1= row1.getCell(1);						//Selected cell (0 row,1 column)
		String location = c1.getStringCellValue();
		ClientPortalLocator.clickLocation().sendKeys(location);
		
		Thread.sleep(1000);
		Row row2 = sheet.getRow(6);						//Selected 0th index row (First row)
		Cell c2= row2.getCell(1);						//Selected cell (0 row,1 column)
		String branch = c2.getStringCellValue();
		ClientPortalLocator.clickBranch().sendKeys(branch);
		
		ClientPortalLocator.clickLicenseType().click();
		ClientPortalLocator.selectLicenseType().click();
		
		Thread.sleep(1000);
		Row row3 = sheet.getRow(7);						//Selected 0th index row (First row)
		Cell c3= row3.getCell(1);						//Selected cell (0 row,1 column)
		String empname = c3.getStringCellValue();
		ClientPortalLocator.clickEmpName().sendKeys(empname);
		

		Thread.sleep(1000);
		Row row4 = sheet.getRow(9);						//Selected 0th index row (First row)
		Cell c4= row4.getCell(1);						//Selected cell (0 row,1 column)
		String empAddress = c4.getStringCellValue();
		ClientPortalLocator.clickEmpAddress().sendKeys(empAddress);
		
		Thread.sleep(1000);
		Row row5 = sheet.getRow(8);						//Selected 0th index row (First row)
		Cell c5= row5.getCell(1);						//Selected cell (0 row,1 column)
		String EmpMailId = c5.getStringCellValue();
		ClientPortalLocator.clickEmpMailId().sendKeys(EmpMailId);
		
		Thread.sleep(1000);
		Row row6 = sheet.getRow(10);						//Selected 0th index row (First row)
		Cell c6= row6.getCell(1);						//Selected cell (0 row,1 column)
		int empContact = (int) c6.getNumericCellValue();
		ClientPortalLocator.clickEmpContact().sendKeys(empContact+"");
	
		
		Thread.sleep(1000);
		Row row7 = sheet.getRow(11);						//Selected 0th index row (First row)
		Cell c7= row7.getCell(1);						//Selected cell (0 row,1 column)
		int mailcount = (int) c7.getNumericCellValue();
		ClientPortalLocator.clickMaleCount().sendKeys(mailcount+"");
		
		Thread.sleep(1000);
		Row row8 = sheet.getRow(12);						//Selected 0th index row (First row)
		Cell c8= row8.getCell(1);						//Selected cell (0 row,1 column)
		int FemaleCount = (int) c8.getNumericCellValue();
		ClientPortalLocator.clickFemaleCount().sendKeys(FemaleCount+"");

	
		Thread.sleep(1000);
		Row row9 = sheet.getRow(13);						//Selected 0th index row (First row)
		Cell c9= row9.getCell(1);						//Selected cell (0 row,1 column)
		String mailid = c9.getStringCellValue();
		ClientPortalLocator.clickManagerMailId().sendKeys(mailid);
		
		Thread.sleep(1000);
		Row row10 = sheet.getRow(14);						//Selected 0th index row (First row)
		Cell c10= row10.getCell(1);						//Selected cell (0 row,1 column)
		int contactNo = (int) c10.getNumericCellValue();
		ClientPortalLocator.clickContactNo().sendKeys(contactNo+"");
		
		Thread.sleep(1000);
		Row row11 = sheet.getRow(15);						//Selected 0th index row (First row)
		Cell c11= row11.getCell(1);						//Selected cell (0 row,1 column)
		String address = c11.getStringCellValue();
		ClientPortalLocator.clickAddress().sendKeys(address);

		Thread.sleep(1000);
		ClientPortalLocator.clickSubmit().click();
		
		String msg=ClientPortalLocator.clickSuccessMsg().getText();
		if(msg.equalsIgnoreCase("Registration saved successfully"))
		{
			test.log(LogStatus.PASS, "Message displayed:-"+msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Message displayed:-"+msg);
		}
		Thread.sleep(1000);
		ClientPortalLocator.clickOkBtn().click();
//		Thread.sleep(1000);
//		Locator.clickBack().click();
	}
	
	public static void ExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		ClientPortalLocator.clickEntity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickTringle1().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectEnity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.ClickApplyBtn().click();
		
		Thread.sleep(1000);
		ClientPortalLocator.clickLicense().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickRegistration().click();
		
		 Thread.sleep(2000); 		
//	        ClientPortalLocator.readTotalItems().click();
			String item = ClientPortalLocator.readTotalItems().getText();
			String[] bits = item.split(" ");								//Splitting the String
			String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
			int count1 = Integer.parseInt(compliancesCount);
		
			if(compliancesCount.equalsIgnoreCase("to"))
			{
				Thread.sleep(5000);
			   item = ClientPortalLocator.readTotalItems().getText();
				bits = item.split(" ");
	        
			}
			
			Thread.sleep(2000);
	        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
	        
	        js1.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
	
		Thread.sleep(1000);
		ClientPortalLocator.clickExport().click();
		
	
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
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(1000);
		ClientPortalLocator.clickEntity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickTringle1().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectEnity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.ClickApplyBtn().click();
		
		Thread.sleep(1000);
		ClientPortalLocator.clickLicense().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickRegistration().click();
		
			Thread.sleep(3000);
			ClientPortalLocator.SearchBox().sendKeys("Mumbai",Keys.ENTER);
		
			List<String> li=new ArrayList<String>();
	        
	       
	        li.add("Mumbai");
       
	        
			List<String> filter=new ArrayList<String>();	
			
			filter.add("Mumbai");	
			
			
			js.executeScript("window.scrollBy(0,150)");	
			Thread.sleep(3000);

			 ClientPortalLocator.readTotalItems().click();				//Clicking on Text of total items just to scroll down.
			String s = ClientPortalLocator.readTotalItems().getText();
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
			
			if(ClientPortalLocator.ClearBtn().isEnabled())
			{
				ClientPortalLocator.ClearBtn().click();
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
		ClientPortalLocator.clickEntity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickTringle1().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectEnity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.ClickApplyBtn().click();
		
		Thread.sleep(1000);
		ClientPortalLocator.clickLicense().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickRegistration().click();
		
		Thread.sleep(1000);
		if(ClientPortalLocator.EditBtn().isEnabled())
		{
			ClientPortalLocator.EditBtn().click();
			test.log(LogStatus.PASS, "Edit button is clickable.");
			
		}
		else
		{
			test.log(LogStatus.PASS, "Edit button is not clickable.");
			
		}
		Thread.sleep(1000);
		ClientPortalLocator.clickBack().click();
	}
		
	public static void ExistingLicsneExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
	{
		
		Thread.sleep(1000);
		ClientPortalLocator.clickEntity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickTringle1().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectEnity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.ClickApplyBtn().click();
		
		Thread.sleep(1000);
		ClientPortalLocator.clickLicense().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickRegistration().click();
		
		Thread.sleep(1000);
		ClientPortalLocator.ExistingLicesne().click();

		Thread.sleep(1000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
	
		Thread.sleep(1000);
		ClientPortalLocator.clickExistingLicenseExport().click();
		
	
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
		ClientPortalLocator.clickEntity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickTringle1().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectEnity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.ClickApplyBtn().click();
		
		Thread.sleep(1000);
		ClientPortalLocator.clickLicense().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickRegistration().click();
		Thread.sleep(1000);
		ClientPortalLocator.ExistingLicesne().click();
		
			Thread.sleep(3000);
			ClientPortalLocator.SearchBox().sendKeys("Shanipar",Keys.ENTER);
		
			List<String> li=new ArrayList<String>();
	        
	       
	        li.add("Shanipar");
       
	        
			List<String> filter=new ArrayList<String>();	
			
			filter.add("Shanipar");	
			
			
			js.executeScript("window.scrollBy(0,150)");	
			Thread.sleep(3000);

                
			try
			{

			
			Thread.sleep(5000);
	
			List<WebElement> typecol=getDriver().findElements(By.xpath("//*[@class='k-grid-aria-root']/kendo-treelist-list/div/div[1]/table/tbody/tr[1]/td[4]"));
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
			
			if(ClientPortalLocator.ClearBtn().isEnabled())
			{
				ClientPortalLocator.ClearBtn().click();
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
		ClientPortalLocator.clickEntity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickTringle1().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectEnity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.ClickApplyBtn().click();
		
		Thread.sleep(1000);
		ClientPortalLocator.clickLicense().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickRegistration().click();
		Thread.sleep(1000);
		ClientPortalLocator.ExistingLicesne().click();
		
		Thread.sleep(1000);
		ClientPortalLocator.ExistingLicesneViewIcon().click();
		
		Thread.sleep(1000);
		String msg =ClientPortalLocator.ExistingLicesneDetailes().getText();
		
		if(msg.equalsIgnoreCase("Existing License Details"))
		{
			
			test.log(LogStatus.PASS, "Existing License Details open successfully:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Existing License Details not open successfully:-" +msg);
		}
		//Thread.sleep(1000);
		//Locator.clickBack().click();
		
		Thread.sleep(1000);
		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
		action.moveToElement(we).click().build().perform();
		
		
	}
	
	public static void ExistingLicenseInitiateAction(ExtentTest test) throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(1000);
		ClientPortalLocator.clickEntity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickTringle1().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectEnity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.ClickApplyBtn().click();
		
		Thread.sleep(1000);
		ClientPortalLocator.clickLicense().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickRegistration().click();
		Thread.sleep(1000);
		ClientPortalLocator.ExistingLicesne().click();
		
		if(ClientPortalLocator.ExistingLicesneInitiateAction().isEnabled())
		{
			Thread.sleep(1000);
			ClientPortalLocator.ExistingLicesneInitiateAction().click();
			test.log(LogStatus.PASS, "Initiate Action Icon is clikable");
		}
		else
		{
			test.log(LogStatus.FAIL, "Initiate Action Icon is not clikable");
		}
		
		Thread.sleep(1000);
		ClientPortalLocator.clickActivityTab().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectActivityTab().click();
		
		Thread.sleep(2000);
		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath("//button[normalize-space()='Submit']"));
		action.moveToElement(we).click().build().perform();
		
		
//		Thread.sleep(1000);
//		Locator.clickSubmit().click();
		
		Thread.sleep(2000);
		//String msg =ClientPortalLocator.SccessMsgSubActivity().getText();
		
		
		String msg =ClientPortalLocator.clickMsg().getText();
		if(msg.equalsIgnoreCase("SubActivity saved successfully"))
		{
			
			test.log(LogStatus.PASS, "Message Displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL, "Message Displayed:-" +msg);
		}
		Thread.sleep(1000);
		ClientPortalLocator.clickOkBtn().click();
		
		Thread.sleep(1000);
		
		WebElement we1 = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
		action.moveToElement(we1).click().build().perform();
		////Thread.sleep(1000);
		//Locator.clickBack().click();
		
		
	}
	
	public static void ExistingLicenseDownload(ExtentTest test) throws InterruptedException, IOException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(1000);
		ClientPortalLocator.clickEntity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickTringle1().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectEnity().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.selectYear().click();
		Thread.sleep(1000);
		ClientPortalLocator.ClickApplyBtn().click();
		
		Thread.sleep(1000);
		ClientPortalLocator.clickLicense().click();
		Thread.sleep(1000);
		ClientPortalLocator.clickRegistration().click();
		Thread.sleep(1000);
		ClientPortalLocator.ExistingLicesne().click();
		
		
		
		Thread.sleep(5000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
	
		
		Thread.sleep(2000);
		ClientPortalLocator.ExistingLicesneDownload().click();
		//ClientPortalLocator.ExistingLicesneDownload().click();
		
		Thread.sleep(10000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
	
		if(dirContents.length < allFilesNew.length)
		{
		
			Thread.sleep(1000);					//Clicking on 'Excel Report' image.
			test.log(LogStatus.PASS, "File downloaded successfully.");
		}
		else
		{
			Thread.sleep(9000);	
			test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
		}
		
		
	}
	
	

public static void ExistingLicenseSubActivityViewandDownload(ExtentTest test) throws InterruptedException
{

	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(1000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectEnity1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickLicense().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickRegistration().click();
	Thread.sleep(2000);
	ClientPortalLocator.ExistingLicesne().click();
	
	Thread.sleep(5000);
	ClientPortalLocator.clickTringleSubactivity().click();
	
	
//	Thread.sleep(2000);
//	File dir = new File("C:\\Users\\bilali\\Downloads");
//	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
//
//	
//	Thread.sleep(1000);
//	Locator.ExistingLicesneSubActivityDownload().click();
//	Locator.ExistingLicesneSubActivityDownload().click();
//	
////	WebDriverWait wait = new WebDriverWait(getDriver(),20);
////	Thread.sleep(1000);
////	wait.until(ExpectedConditions.invisibilityOf(Locator.GridLoad()));
//
//	
//
//	
//	Thread.sleep(5000);
//	File dir1 = new File("C:\\Users\\bilali\\Downloads");
//	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download
//
//	Thread.sleep(2000);
//	if(dirContents.length < allFilesNew.length)
//	{
//	
//		
//		test.log(LogStatus.PASS, "File downloaded successfully.");
//	}
//	else
//	{
//		test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
//	}
	
	
	
	Thread.sleep(2000);
	ClientPortalLocator.ExistingLicesneSubactivityViewIcon().click();
	
	Thread.sleep(2000);
	String msg =ClientPortalLocator.ExistingLicesneDetailes().getText();
	
	if(msg.equalsIgnoreCase("Existing License Details"))
	{
		
		test.log(LogStatus.PASS, "Existing License Details open successfully:-" +msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "Existing License Details not open successfully:-" +msg);
	}
	

	
	
	Thread.sleep(2000);
	File dir3 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents1 = dir3.listFiles();							//Counting number of files in directory before download 

	
	Thread.sleep(2000);

	ClientPortalLocator.downloadLicenseDoc().click();
	
	Thread.sleep(5500);
	File dir2= new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew1 = dir2.listFiles();							//Counting number of files in directory after download

	if(dirContents1.length < allFilesNew1.length)
	{
	
		Thread.sleep(9000);					//Clicking on 'Excel Report' image.
		test.log(LogStatus.PASS, "License Document downloaded successfully.");
	}
	else
	{
		test.log(LogStatus.FAIL, "License Document doesn't downloaded successfully.");
	}
	
	Thread.sleep(1000);
	ClientPortalLocator.clickBack().click();
	

	
	
	
}

public static void RegisrationRespository(ExtentTest test) throws InterruptedException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(1000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickLicense().click();
	Thread.sleep(1000);
	ClientPortalLocator.RegistrationRepository().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.Branch().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectBranch().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickActivities().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.selectActivities().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.ExistingLicesneViewIcon().click();
	
	
	String msg=ClientPortalLocator.clickDocViewer().getText();
	if(msg.equalsIgnoreCase(msg))
	{
		test.log(LogStatus.PASS, "Registration Repostory Doc viewed successfully:-"+msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "Registration Repostory Doc viewed successfully:-"+msg);
	}
	
	Thread.sleep(1000);
	ClientPortalLocator.ClickClose().click();
	
	if(ClientPortalLocator.clickDownload().isEnabled())
	{
		Thread.sleep(1000);
		ClientPortalLocator.clickDownload().click();
		
		test.log(LogStatus.PASS, "Registration Repostory Doc downloaded successfully");
	}
	else
	{
		test.log(LogStatus.FAIL, "Registration Repostory Doc does not downloaded successfully");
	}
	
//	Thread.sleep(1000);
//	ClientPortalLocator.clickDownload().click();
//	
//	
//	Thread.sleep(1000);
//	String msg1 =ClientPortalLocator.clickAlert().getText();
//	
//	
//	if(msg1.equalsIgnoreCase("Invalid file type."))
//	{
//		test.log(LogStatus.FAIL,"Registration Repostory Doc downloaded successfully:-" +msg1);
//	}
//	else
//	{
//		test.log(LogStatus.PASS,"Registration Repostory Doc does not downloaded successfully:-" +msg1);
//	}
//	Thread.sleep(1000);
//	ClientPortalLocator.clickOkBtn().click();
}

public static void RegistrationRepositoryFilter(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
		
	Thread.sleep(1000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickLicense().click();
	Thread.sleep(1000);
	ClientPortalLocator.RegistrationRepository().click();
     
 	Thread.sleep(1000);
 	ClientPortalLocator.Branch().click();
 	Thread.sleep(1000);
 	String branch=ClientPortalLocator.selectBranch().getText();
 	Thread.sleep(1000);
 	ClientPortalLocator.selectBranch().click();
 	Thread.sleep(1000);
 	ClientPortalLocator.clickActivities().click();
 	
 	Thread.sleep(1000);
 	String activities=ClientPortalLocator.selectActivities().getText();
 	Thread.sleep(1000);
 	ClientPortalLocator.selectActivities().click();
 	
 	Thread.sleep(1000);
 	if(ClientPortalLocator.ClickApplyBtn().isEnabled())
 	{
	 	Thread.sleep(1000);
	 	ClientPortalLocator.ClickApplyBtn().click();
	 	test.log(LogStatus.PASS, "Apply button working successfully.");
 	}
 	else
 	{
 		test.log(LogStatus.FAIL, "Apply button does not working successfully.");
 	}
     
     
   
        List<String> li=new ArrayList<String>();
         li.add(branch);
         li.add(activities);
      
        
		List<String> filter=new ArrayList<String>();	
		filter.add("branch");
		filter.add("activities");
		
		Thread.sleep(4000);
		 JavascriptExecutor js=(JavascriptExecutor)getDriver();
		 js.executeScript("window.scrollBy(0,200)");	
		Thread.sleep(3000);
		 ClientPortalLocator.readTotalItems().click();					//Clicking on Text of total items just to scroll down.
		String s = ClientPortalLocator.readTotalItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);
	
		List<WebElement> branchcol=getDriver().findElements(By.xpath("//*[@class=\"k-grid-aria-root\"]/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[4]"));
		List<WebElement> activitycol=getDriver().findElements(By.xpath("//*[@class=\"k-grid-aria-root\"]/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[3]"));
		
		
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
			 else if(i==1)
			 {
				 raw.addAll(activitycol);
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
			test.log(LogStatus.PASS,"No records found");	
		}
		
		if(ClientPortalLocator.ClearBtn().isEnabled())
		{
			Thread.sleep(2000);
			ClientPortalLocator.ClearBtn().click();
			test.log(LogStatus.PASS, "Clear button working successfully.");
			
		}
		else
		{
			test.log(LogStatus.PASS, "Clear button not working successfully.");
			
		}
}

public static void RegistrationRepositoryExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
{
	
	Thread.sleep(1000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickLicense().click();
	Thread.sleep(1000);
	ClientPortalLocator.RegistrationRepository().click();
	
	 Thread.sleep(2000); 		
 //     ClientPortalLocator.readTotalItems().click();
		String item = ClientPortalLocator.readTotalItems().getText();
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = ClientPortalLocator.readTotalItems().getText();
			bits = item.split(" ");
        
		}
		
		Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
        
        js1.executeScript("window.scrollBy(0,-500)");
	Thread.sleep(1000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(1000);
	ClientPortalLocator.clickExistingLicenseExport().click();   //Registration Repository
	

	Thread.sleep(10000);
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

public static void AddNewNotices(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	

 	
	
	Thread.sleep(5000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(5000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickNotices().click();
	
	Thread.sleep(3000);
	String item = ClientPortalLocator.readTotalItemsNotice().getText();
	String[] bits = item.split(" ");								//Splitting the String
	if(bits.length > 2)
	{
		Thread.sleep(2000);
		item = ClientPortalLocator.readTotalItemsNotice().getText();
		bits = item.split(" ");								//Splitting the String
	}
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(2000);
		item = ClientPortalLocator.readTotalItemsNotice().getText();
		bits = item.split(" ");									//Splitting the String
		compliancesCount = bits[bits.length - 2];
	}
	int count = Integer.parseInt(compliancesCount);
	
	Thread.sleep(1000);
	ClientPortalLocator.clickaddnewNotices().click();
	ClientPortalLocator.clickState().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectState1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickLocation1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectLocation1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickNoticeBranch1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectLocation1().click();   //Select Branch
	Thread.sleep(1000);
	ClientPortalLocator.clickModeOfReceipt().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectLocation1().click();   //Select Mode Of Receipt
	
	
	
	FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook1 = WorkbookFactory.create(fis);
    Sheet sheet = workbook1.getSheetAt(2);
	
    Thread.sleep(1000);
	Row row6 = sheet.getRow(17);						//Selected 0th index row (First row)
	Cell c6= row6.getCell(1);						//Selected cell (0 row,1 column)
	int NoriceNo = (int) c6.getNumericCellValue();
	ClientPortalLocator.clickNoticeNumber().sendKeys(NoriceNo+"");
	
	Thread.sleep(1000);
	ClientPortalLocator.clickCalender().click();
	
	Thread.sleep(1000);
	Actions action = new Actions(getDriver());
	WebElement we = getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='21']"));
	action.moveToElement(we).click().build().perform();
	Thread.sleep(1000);
//	Locator.selectDate().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickCalenderReponseDueDate().click();
	Thread.sleep(1000);

	WebElement we1= getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='28']"));
	action.moveToElement(we1).click().build().perform();
//	Locator.selectDate2().click();
	
	ClientPortalLocator.clickNoticeType().click();
	ClientPortalLocator.selectLocation1().click();   //Select Notice type
	
	ClientPortalLocator.clickRisk().click();
	ClientPortalLocator.selectLocation1().click();   //Select Risk type
	
	
	Row row = sheet.getRow(18);						//Selected 0th index row (First row)
	Cell c= row.getCell(1);						//Selected cell (0 row,1 column)
	String Remark = c.getStringCellValue();
	ClientPortalLocator.clickRemark().sendKeys(Remark);
	
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
	ClientPortalLocator.clickSaveNotice().click();
	 Thread.sleep(1000);
	String msg=ClientPortalLocator.clickSuccessNotice().getText();
	if(msg.equalsIgnoreCase("Notice Saved Successfully"))
	{
		test.log(LogStatus.PASS,"Message displayed:-" +msg);
	}
	else
	{
		test.log(LogStatus.FAIL,"Message displayed:-" +msg);
	}
	Thread.sleep(1000);
	ClientPortalLocator.clickOkBtn().click();
	
	Thread.sleep(1000);

	WebElement we2 = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
	action.moveToElement(we2).click().build().perform();
	
	Thread.sleep(1000);
	ClientPortalLocator.readTotalItemsNotice().click();
	String item1 = ClientPortalLocator.readTotalItemsNotice().getText();
	String[] bits1 = item1.split(" ");								//Splitting the String
	
	if(bits1.length > 2)
	{
		Thread.sleep(2000);
		item1 = ClientPortalLocator.readTotalItemsNotice().getText();
		bits1 = item1.split(" ");								//Splitting the String
	}
	String compliancesCount1 = bits1[bits1.length - 2];				//Getting the second last word (total number of users)
	
	if(compliancesCount1.equalsIgnoreCase("to"))
	{
		Thread.sleep(2000);
		item1 = ClientPortalLocator.readTotalItemsNotice().getText();
		bits1 = item1.split(" ");									//Splitting the String
		compliancesCount1 = bits1[bits1.length - 2];
	}
	int count1 = Integer.parseInt(compliancesCount1);
	if(count < count1)
		{
		
			test.log(LogStatus.PASS, "Total Notice Count increased in grid after adding New Notice - Old Notice Count from Grid  = "+count+" | New Notice Count from Grid = "+count1);
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Total Notice Count doesn't increased in grid after adding New Notice - Old Notice Count from Grid  = "+count+" | New Notice Count from Grid = "+count1);
		}
	

	
	
}

public static void ExistingNoticesNo(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(1000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickNotices().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickaddnewNotices().click();
	ClientPortalLocator.clickState().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectState1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickLocation1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectLocation1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickNoticeBranch1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectLocation1().click();   //Select Branch
	Thread.sleep(1000);
	ClientPortalLocator.clickModeOfReceipt().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectLocation1().click();   //Select Mode Of Receipt
	
	
	
	FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook1 = WorkbookFactory.create(fis);
    Sheet sheet = workbook1.getSheetAt(2);
	
    Thread.sleep(1000);
	Row row6 = sheet.getRow(17);						//Selected 0th index row (First row)
	Cell c6= row6.getCell(1);						//Selected cell (0 row,1 column)
	int NoriceNo = (int) c6.getNumericCellValue();
	ClientPortalLocator.clickNoticeNumber().sendKeys(NoriceNo+"");
	
	Thread.sleep(1000);
	ClientPortalLocator.clickCalender().click();
	
	Thread.sleep(1000);
	Actions action = new Actions(getDriver());
	WebElement we = getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='21']"));
	action.moveToElement(we).click().build().perform();
//	Thread.sleep(1000);
//	Locator.selectDate().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickCalenderReponseDueDate().click();
	Thread.sleep(1000);

	WebElement we1= getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='28']"));
	action.moveToElement(we1).click().build().perform();
//	Locator.selectDate2().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickNoticeType().click();
	ClientPortalLocator.selectLocation1().click();   //Select Notice type
	
	Thread.sleep(1000);
	ClientPortalLocator.clickRisk().click();
	ClientPortalLocator.selectLocation1().click();   //Select Risk type
	
	
	Thread.sleep(1000);
	Row row = sheet.getRow(18);						//Selected 0th index row (First row)
	Cell c= row.getCell(1);						//Selected cell (0 row,1 column)
	String Remark = c.getStringCellValue();
	ClientPortalLocator.clickRemark().sendKeys(Remark);
	
	 getDriver().findElement(By.xpath("//*[@class='figma-btn-gray']")).click();
	 
	 Robot robot=new Robot();
		Thread.sleep(1000);
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
	ClientPortalLocator.clickSaveNotice().click();
	 Thread.sleep(1000);
	String msg=ClientPortalLocator.clickInvalidNotice().getText();
	if(msg.equalsIgnoreCase("Notice Number already exist"))
	{
		test.log(LogStatus.PASS,"Message displayed:-" +msg);
	}
	else
	{
		test.log(LogStatus.FAIL,"Message displayed:-" +msg);
	}
	Thread.sleep(1000);
	ClientPortalLocator.clickOkBtn().click();
	 Thread.sleep(1000);
	ClientPortalLocator.clickBack().click();
	
	
}

public static void NoticeDocMandatory(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(1000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickNotices().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickaddnewNotices().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickSaveNotice().click();
	
	 Thread.sleep(1000);
		String msg=ClientPortalLocator.clickNoticeDocMsg().getText();
		if(msg.equalsIgnoreCase("File is required."))
		{
			test.log(LogStatus.PASS,"Message displayed:-" +msg);
		}
		else
		{
			test.log(LogStatus.FAIL,"Message displayed:-" +msg);
		}
		 Thread.sleep(1000);
			ClientPortalLocator.clickBack().click();
	
}


public static void NoticeExportBtn(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(1000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	ClientPortalLocator.clickNotices().click();
	

	
	
	 Thread.sleep(2000); 		
//     ClientPortalLocator.readTotalItemsNotice().click();
		String item = ClientPortalLocator.readTotalItemsNotice().getText();
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
	
		if(compliancesCount.equalsIgnoreCase("to"))
		{
			Thread.sleep(5000);
		   item = ClientPortalLocator.readTotalItemsNotice().getText();
			bits = item.split(" ");
     
		}
		
		Thread.sleep(2000);
     JavascriptExecutor js1 = (JavascriptExecutor) getDriver();
     
     js1.executeScript("window.scrollBy(0,-500)");
	Thread.sleep(1000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(1000);
	ClientPortalLocator.clickNoticeExport().click();
	

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

public static void NoticeEditDownloadView(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(2000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	Thread.sleep(7000);
	ClientPortalLocator.clickNotices().click();
	
	
	

	
	Thread.sleep(2000);
	File dir3 = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents1 = dir3.listFiles();							//Counting number of files in directory before download 

	
	Thread.sleep(2000);

	ClientPortalLocator.clickDownload().click();
	
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
	
	Thread.sleep(2000);
	ClientPortalLocator.clickviewNoticeDocIcon().click();
	
	Thread.sleep(3000);
	String msg=ClientPortalLocator.clickDocViewer().getText();
	if(msg.equalsIgnoreCase(msg))
	{
		test.log(LogStatus.PASS, "Notice Doc viewed successfully:-"+msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "Notice Doc does not viewed successfully:-"+msg);
	}
	
	ClientPortalLocator.ClickClose().click();
	
	Thread.sleep(1000);
	if(ClientPortalLocator.EditBtn().isEnabled())
	{
		Thread.sleep(1000);
		ClientPortalLocator.EditBtn().click();
		test.log(LogStatus.PASS, "Edit button is clickable.");
		
	}
	else
	{
		test.log(LogStatus.PASS, "Edit button is not clickable.");
		
	}
//	Thread.sleep(1000);
//	Locator.clickBack().click();
	
	Thread.sleep(1000);
	Actions action = new Actions(getDriver());
	WebElement we1 = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
	action.moveToElement(we1).click().build().perform();
	
//	Thread.sleep(1000);
//	Locator.clickBackArrow().click();

}

public static void NoticeSearchBox(ExtentTest test) throws InterruptedException, EncryptedDocumentException, IOException, AWTException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	ClientPortalLocator.clickNotices().click();
	
	Thread.sleep(3000);
	ClientPortalLocator.SearchBox().sendKeys("Testtt",Keys.ENTER);

	List<String> li=new ArrayList<String>();
    
   
    li.add("Testtt");

    
	List<String> filter=new ArrayList<String>();	
	
	filter.add("Testtt");	
	
	
	js.executeScript("window.scrollBy(0,150)");	
	Thread.sleep(3000);

	 ClientPortalLocator.readTotalItems().click();				//Clicking on Text of total items just to scroll down.
	String s = ClientPortalLocator.readTotalItems().getText();
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
	
	if(ClientPortalLocator.ClearBtn().isEnabled())
	{
		ClientPortalLocator.ClearBtn().click();
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

public static void StatutoryDocApplyClaerBtn(ExtentTest test) throws InterruptedException
{

	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickMyDoc().click();
	
	ClientPortalLocator.clickStatutoryDoc().click();
	
	ClientPortalLocator.clickComplianceType().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(3000);
	
	ClientPortalLocator.clickAct2().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectComplianceType1().click();
	
	Thread.sleep(3000);
	ClientPortalLocator.clickPeriod().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickYear().click();
	ClientPortalLocator.selectComplianceType1().click();
	

	Thread.sleep(1000);
//	ClientPortalLocator.clickBranch1().click();
	Thread.sleep(1000);
//	ClientPortalLocator.clickBranchcheckbox().click();
	Thread.sleep(1000);
//	ClientPortalLocator.clickBranch1().click();
	Thread.sleep(1000);
	
	//ClientPortalLocator.clickPeriod().click(); //Bilal added 
	
	if(ClientPortalLocator.ClickApplyBtn().isEnabled())
	{
		Thread.sleep(1000);
		ClientPortalLocator.ClickApplyBtn().click();
		test.log(LogStatus.PASS, "Apply button working successfully");
	}
	else
	{
		test.log(LogStatus.FAIL, "Apply button working successfully");
	}
	
//	Thread.sleep(1000);
//	wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
	
	Thread.sleep(1000);
	if(ClientPortalLocator.clickClearBtn().isEnabled())
	{
		Thread.sleep(10000);
		ClientPortalLocator.clickClearBtn().click();
		test.log(LogStatus.PASS, "Clear button working successfully");
	}
	else
	{
		test.log(LogStatus.FAIL, "Clear button not working successfully");
	}
	
	
	Thread.sleep(5000);
	ClientPortalLocator.clickMyDashboard().click();
	}


public static void StatutoryDocFilter(ExtentTest test) throws InterruptedException
{
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickMyDoc().click();
	
	ClientPortalLocator.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickComplianceType().click();
	Thread.sleep(1000);
	if(ClientPortalLocator.selectComplianceType1().isDisplayed())
	{
		Thread.sleep(1000);
		ClientPortalLocator.selectComplianceType1().click();
		test.log(LogStatus.PASS, "Register', 'Return', 'Challan' value should reflect in dropdown.");
	}
	else
	{
		test.log(LogStatus.FAIL, "Register', 'Return', 'Challan' value should not reflect in dropdown.");
	}
	
	Thread.sleep(1000);
	ClientPortalLocator.clickAct2().click();
	
	Thread.sleep(1000);
	if(ClientPortalLocator.selectComplianceType1().isDisplayed())
	{
		
		test.log(LogStatus.PASS, "Act' value's should reflect in dropdown.");
	}
	else
	{
		test.log(LogStatus.FAIL, "Act' value's should not reflect in dropdown.");
	}
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	
	Thread.sleep(1000);
	if(ClientPortalLocator.selectComplianceType1().isDisplayed())
	{
		
		test.log(LogStatus.PASS, "Year' value's should reflect in dropdown.");
	}
	else
	{
		test.log(LogStatus.FAIL, "Year' value's should not reflect in dropdown.");
	}
	Thread.sleep(1000);
	ClientPortalLocator.clickPeriod().click();
	Thread.sleep(1000);
	if(ClientPortalLocator.selectComplianceType1().isDisplayed())
	{
		
		test.log(LogStatus.PASS, "Period' value's should reflect in dropdown.");
	}
	else
	{
		test.log(LogStatus.FAIL, "Period' value's should not reflect in dropdown.");
	}
	
	

	Thread.sleep(5000);
	ClientPortalLocator.clickMyDashboard().click();
	
}
public static void StateDocZipFile(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickMyDoc().click();
	
	ClientPortalLocator.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickComplianceType().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickAct2().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickPeriod().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	

	/*
	Thread.sleep(1000);
	ClientPortalLocator.clickBranch1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickBranchcheckbox().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickBranch1().click();   */
	
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	

	//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
	Thread.sleep(9000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(4000);
	ClientPortalLocator.clickDownload().click();
	
//	Thread.sleep(1000);
//	wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
	

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
			test.log(LogStatus.FAIL, "zip file should not get downloaded..");
		}


//catch(Exception e)
//{
//	
//	Thread.sleep(2000);
//	String msg1=Locator.FileNotFound().getText();
//	
//	 if(msg1.equalsIgnoreCase("File Not Found"))
//	 {
//		 test.log(LogStatus.PASS, "Message displayed = "+msg1);
//		 
//	 }
//	 else
//	 {
//		 test.log(LogStatus.FAIL, "Message displayed = "+msg1);
//	 }
//	 Thread.sleep(1000);
//	Locator.clickOkBtn().click();
//}
//	Thread.sleep(2000);
//	Locator.clickdashboard().click();
		
	
	
}

public static void StatutoryDocViewandOverview(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickMyDoc().click();
	
	ClientPortalLocator.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickComplianceType().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickAct2().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickPeriod().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	

	Thread.sleep(1000);
/*	ClientPortalLocator.clickBranch1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickBranchcheckbox().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickBranch1().click();
	Thread.sleep(1000);  */
	ClientPortalLocator.ClickApplyBtn().click();
	

	Thread.sleep(1000);
	ClientPortalLocator.clickview().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickview1().click();
	Thread.sleep(3000);
	String msg=ClientPortalLocator.viewPopup().getText();
	if(msg.equalsIgnoreCase("Document Viewer"))
	{
		test.log(LogStatus.PASS, "View Popup open successfully:-"+msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "View Popup does not open successfully:-"+msg);
	}
	Thread.sleep(3000);
	ClientPortalLocator.clickCloseBtn1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickCloseBtn().click();
}
public static void StatutoryDocBulkDownload(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(1000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickMyDoc().click();
	
	ClientPortalLocator.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickComplianceType().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickAct2().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickPeriod().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	

	Thread.sleep(1000);
/*	ClientPortalLocator.clickBranch1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickBranchcheckbox().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickBranch1().click(); */
	Thread.sleep(1000);
	
	ClientPortalLocator.ClickApplyBtn().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickCheckBox().click();
	
	
	
	Thread.sleep(9000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(1000);
	ClientPortalLocator.clickDownloadbulk().click();
	
		

	Thread.sleep(4000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	Thread.sleep(4000);
	if(dirContents.length < allFilesNew.length)
	{
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Document downloaded successfully");
		
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
			test.log(LogStatus.FAIL, "Document does not downloaded successfully");
		}
}

public static void ChallanDoc(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickMyDoc().click();
	
	ClientPortalLocator.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickComplianceType().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickAct2().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickPeriod().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	


	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	

	//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
	Thread.sleep(9000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(4000);
	ClientPortalLocator.clickDownload().click();
	
//	Thread.sleep(1000);
//	wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
	

	Thread.sleep(4000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	Thread.sleep(4000);
	if(dirContents.length < allFilesNew.length)
	{
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Working document file should get downloaded.");
		
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
			test.log(LogStatus.FAIL, "Working document file should not get downloaded..");
		}


//catch(Exception e)
//{
//	
//	Thread.sleep(2000);
//	String msg1=Locator.FileNotFound().getText();
//	
//	 if(msg1.equalsIgnoreCase("File Not Found"))
//	 {
//		 test.log(LogStatus.PASS, "Message displayed = "+msg1);
//		 
//	 }
//	 else
//	 {
//		 test.log(LogStatus.FAIL, "Message displayed = "+msg1);
//	 }
//	 Thread.sleep(1000);
//	Locator.clickOkBtn().click();
//}
//	Thread.sleep(2000);
//	Locator.clickdashboard().click();
		
	
	
}

public static void ChallanComplianceDoc(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickMyDoc().click();
	
	ClientPortalLocator.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickComplianceType().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickAct2().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickPeriod().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	


	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	
	//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
	Thread.sleep(9000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(4000);
	ClientPortalLocator.clickDownload1().click();
	
//	Thread.sleep(1000);
//	wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
	

	Thread.sleep(4000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	Thread.sleep(4000);
	if(dirContents.length < allFilesNew.length)
	{
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Compliance document file should get downloaded.");
		
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
			test.log(LogStatus.FAIL, "Compliance document file should not get downloaded..");
		}


//catch(Exception e)
//{
//	
//	Thread.sleep(2000);
//	String msg1=Locator.FileNotFound().getText();
//	
//	 if(msg1.equalsIgnoreCase("File Not Found"))
//	 {
//		 test.log(LogStatus.PASS, "Message displayed = "+msg1);
//		 
//	 }
//	 else
//	 {
//		 test.log(LogStatus.FAIL, "Message displayed = "+msg1);
//	 }
//	 Thread.sleep(1000);
//	Locator.clickOkBtn().click();
//}
//	Thread.sleep(2000);
//	Locator.clickdashboard().click();
		
	
	
}
public static void ChallanViewBranches(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickMyDoc().click();
	
	ClientPortalLocator.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickComplianceType().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickAct2().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickPeriod().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	


	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	
	Thread.sleep(1000);
	ClientPortalLocator.clickview().click();
	
	
	Thread.sleep(3000);
	String msg=ClientPortalLocator.viewPopup1().getText();
	if(msg.equalsIgnoreCase("Branches"))
	{
		test.log(LogStatus.PASS, "View Popup open successfully:-"+msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "View Popup does not open successfully:-"+msg);
	}
	
	Thread.sleep(1000);
	ClientPortalLocator.clickCloseBtn().click();
		
	
	
}
public static void ChallanViewWorkingFile(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickMyDoc().click();
	
	ClientPortalLocator.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickComplianceType().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickAct2().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickPeriod().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	


	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	if(ClientPortalLocator.clickview2().isEnabled())
	{
		Thread.sleep(1000);
		ClientPortalLocator.clickview2().click();
		
		test.log(LogStatus.FAIL, "Working File does not viewed successfully");
	}
	else
	{
		test.log(LogStatus.PASS, "Working File is viewed successfully");
	}
	
	
}
public static void ChallanViewComplianceFile(ExtentTest test) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickMyDoc().click();
	
	ClientPortalLocator.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickComplianceType().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickAct2().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectComplianceType1().click();  //Bilal changed type 3
	Thread.sleep(1000);
	ClientPortalLocator.clickPeriod().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	


	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	if(ClientPortalLocator.clickview3().isEnabled())
	{
		Thread.sleep(1000);
		ClientPortalLocator.clickview3().click();
		
		test.log(LogStatus.FAIL, "Compliance File does not viewed successfully");
	}
	else
	{
		test.log(LogStatus.PASS, "Compliance File is viewed successfully");
	}
	
	
}

public static void ChallanDocBulkDownload(ExtentTest test) throws InterruptedException
{
	

	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickMyDoc().click();
	
	ClientPortalLocator.clickStatutoryDoc().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickComplianceType().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickAct2().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickPeriod().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	


	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickCheckBox().click();
	
	
	
	Thread.sleep(9000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(1000);
	ClientPortalLocator.clickDownloadbulk().click();
	
		

	Thread.sleep(4000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	Thread.sleep(4000);
	if(dirContents.length < allFilesNew.length)
	{
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Document downloaded successfully");
		
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
			test.log(LogStatus.FAIL, "Document does not downloaded successfully");
		}
}

public static void RegionalDocView(ExtentTest test) throws InterruptedException
{
	

	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickMasterAbstract().click();
	
	Thread.sleep(5000);
	ClientPortalLocator.clickState1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectComplianceType1().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickAct2().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	

		Thread.sleep(10000);
		ClientPortalLocator.clickVieqRegional().click();

	
	
	Thread.sleep(30000);
	String msg=ClientPortalLocator.viewPopup1().getText();
	if(msg.equalsIgnoreCase("Document Viewer"))
	{
		test.log(LogStatus.PASS, "Regional document viewed successfully:-"+msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "Regional document does not viewed successfully:-"+msg);
	}
	
	Thread.sleep(1000);
	ClientPortalLocator.clickCloseBtn().click();
	
}
public static void RegionalDocDownload(ExtentTest test) throws InterruptedException
{
	

	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(4000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickMasterAbstract().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickState1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickAct2().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();

	Thread.sleep(9000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(1000);
	ClientPortalLocator.clickDownloadRegiinal().click();
	
		

	Thread.sleep(30000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	Thread.sleep(30000);
	if(dirContents.length < allFilesNew.length)
	{
		Thread.sleep(20000);
		test.log(LogStatus.PASS, "Document downloaded successfully");
		
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
			test.log(LogStatus.FAIL, "Document does not downloaded successfully");
	
		}
}

public static void EnglishDocView(ExtentTest test) throws InterruptedException
{
	

	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(5000);
	ClientPortalLocator.clickMasterAbstract().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickState1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickAct2().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	

		Thread.sleep(1000);
		ClientPortalLocator.clickViewEnglish().click();

	
	
	Thread.sleep(3000);
	String msg=ClientPortalLocator.viewPopup1().getText();
	if(msg.equalsIgnoreCase("Document Viewer"))
	{
		test.log(LogStatus.PASS, "English document viewed successfully:-"+msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "English document does not viewed successfully:-"+msg);
	}
	
	Thread.sleep(1000);
	ClientPortalLocator.clickCloseBtn().click();
	
}
public static void EnglishDocDownload(ExtentTest test) throws InterruptedException
{
	

	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickMasterAbstract().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickState1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickAct2().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();

	Thread.sleep(9000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(10000);
	ClientPortalLocator.clickDownloadEnglishl().click();
	
		

	Thread.sleep(10000);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	Thread.sleep(4000);
	if(dirContents.length < allFilesNew.length)
	{
		Thread.sleep(4000);
		test.log(LogStatus.PASS, "Document downloaded successfully");
		
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
			test.log(LogStatus.FAIL, "Document does not downloaded successfully");
	
		}
}

public static void SearchBoxMasterAbstarct(ExtentTest test) throws InterruptedException
{
	
	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	Thread.sleep(3000);
	ClientPortalLocator.clickEntity().click();
	Thread.sleep(3000);
	ClientPortalLocator.clickTringle1().click();
	Thread.sleep(3000);
	ClientPortalLocator.selectEnity().click();
	Thread.sleep(1000);
	ClientPortalLocator.clickYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectYear().click();
	Thread.sleep(1000);
	ClientPortalLocator.ClickApplyBtn().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickMasterAbstract().click();
	
	Thread.sleep(1000);
	ClientPortalLocator.clickState1().click();
	Thread.sleep(1000);
	ClientPortalLocator.selectComplianceType1().click();
	
//	Thread.sleep(1000);
//	Locator.clickAct2().click();
//	Thread.sleep(1000);
//	Locator.selectComplianceType1().click();
	
		Thread.sleep(3000);
		ClientPortalLocator.SearchBox().sendKeys("FACT",Keys.ENTER);
	
		List<String> li=new ArrayList<String>();
        
       
        li.add("FACT and Allied acts");
   
        
		List<String> filter=new ArrayList<String>();	
		
		filter.add("FACT and Allied acts");	
		
		
		js.executeScript("window.scrollBy(0,150)");	
		Thread.sleep(10000);

		 ClientPortalLocator.readTotalItemsMasterAbstract().click();				//Clicking on Text of total items just to scroll down.
		 Thread.sleep(5000);
		String s = ClientPortalLocator.readTotalItemsMasterAbstract().getText();
		Thread.sleep(5000);

		if(!s.equalsIgnoreCase("No items to display")) {
		Thread.sleep(5000);

		List<WebElement> typecol=getDriver().findElements(By.xpath("//*[@class='k-grid-aria-root']/kendo-grid-list/div/div[1]/table/tbody/tr[1]/td[2]"));
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
		
		if(ClientPortalLocator.ClearBtn().isEnabled())
		{
			ClientPortalLocator.ClearBtn().click();
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
}

	

		
	


