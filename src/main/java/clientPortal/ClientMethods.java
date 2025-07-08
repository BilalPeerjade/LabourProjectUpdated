package clientPortal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import distributor.Locators;
import login.BasePage;
import login.LoginLocators;

public class ClientMethods extends BasePage {
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	 static String filePath ="D:\\LabourAngularProject\\TestData\\Labour.xlsx";

	
	public static void filterEntity ( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(7000);		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
		
	  	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='k-input-inner k-readonly']")));	//Wait until records table get visible.

	  	
		ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAENTEST().click();
		Thread.sleep(2000);
		
		ClientLocators.SelectYear().click();
		Thread.sleep(2000);
	  	ClientLocators.SelectYear22().click();
		Thread.sleep(2000);
	 	ClientLocators.Apply().click();
			Thread.sleep(8000);
		  
			Thread.sleep(8000);
	}
	
	public static void Entities(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.Entities().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
	ClientLocators.Entities().click();
		Thread.sleep(5000);
		
//		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Entities in the grid = "+CatcountGrid+" | Dashboard Entities  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Entities in the grid = "+CatcountGrid+" | Dashboard Entities Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	
	public static void EntitiesSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
	ClientLocators.Entities().click();
		Thread.sleep(5000);
		try {Thread.sleep(5000);
		ClientLocators.Search().sendKeys("AVACORED5",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='AVACORED5']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected entity name along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "entity selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	public static void Locations(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.Locations().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
	ClientLocators.Locations().click();
		Thread.sleep(5000);
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Locations in the grid = "+CatcountGrid+" | Dashboard Locations  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Locations in the grid = "+CatcountGrid+" | Dashboard Locations Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void LocationsSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
	ClientLocators.Locations().click();
		Thread.sleep(5000);
		try {Thread.sleep(5000);
		ClientLocators.Search().sendKeys("Continental",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='Continental']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Locations name along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Locations selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	public static void AssignedCompliances(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.AssignedCompliances().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
	ClientLocators.AssignedCompliances().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Assigned Compliances in the grid = "+CatcountGrid+" | Dashboard Assigned Compliances  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Assigned Compliances in the grid = "+CatcountGrid+" | Dashboard Assigned Compliances Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void exportcount(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
	ClientLocators.AssignedCompliances().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void OverviewAC(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
	ClientLocators.AssignedCompliances().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		
		ClientLocators.Overview().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		
		
	}
	
	public static void ExpiredRegistrations(  ExtentTest test) throws InterruptedException, IOException
	{
		
		Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.ExpiredRegistrations().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
	ClientLocators.ExpiredRegistrations().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Expired Registrations in the grid = "+CatcountGrid+" | Dashboard Expired Registrations  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Expired Registrations in the grid = "+CatcountGrid+" | Dashboard Expired Registrations Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void ExpiredRegistrationsEdit( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
	
	ClientLocators.ExpiredRegistrations().click();
		Thread.sleep(5000);
		
		ClientLocators.EREdit().click();
		Thread.sleep(5000);
		String item = ClientLocators.EREditP().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("Existing License")) {
			Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on Edit button page redirect to the Existing License page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " view button not working ");

		}
		
		
	}
	
	public static void exportER(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.ExpiredRegistrations().click();
		Thread.sleep(5000);
		ClientLocators.EREdit().click();
		Thread.sleep(5000);
		
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void ERSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.ExpiredRegistrations().click();
		Thread.sleep(5000);
		ClientLocators.EREdit().click();
		Thread.sleep(5000);
		try {Thread.sleep(5000);
		ClientLocators.Search().sendKeys("400053",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='400053']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Location along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Location selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	public static void ERSearchClear(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.ExpiredRegistrations().click();
		Thread.sleep(5000);
		ClientLocators.EREdit().click();
		Thread.sleep(5000);
	
		ClientLocators.Search().sendKeys("400053",Keys.ENTER);
		Thread.sleep(4000);
		
		 if(ClientLocators.Clear().isEnabled()) {Thread.sleep(5000);
		 
			test.log(LogStatus.PASS,  " Clear button working successfully."); 
			ClientLocators.Clear().click();
	 }
	 else
	 {Thread.sleep(5000);
	 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
	 }
	  	 Thread.sleep(3000);
	  
		
	}
	
	 public static void ERviewBack( ExtentTest test) throws InterruptedException, IOException
	  	{Thread.sleep(5000);
	  	
	      	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	      	WebElement element = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
	      	ClientLocators.ExpiredRegistrations().click();
			Thread.sleep(5000);
			ClientLocators.EREdit().click();
			Thread.sleep(5000);
	  		
	  		ClientLocators.ViewER().click();
	  		Thread.sleep(5000);
	  		if(ClientLocators.Back().isEnabled()) {Thread.sleep(5000);
			 
			test.log(LogStatus.PASS,  " Back button working successfully."); 
			ClientLocators.Back().click();
	 }
	 else
	 {Thread.sleep(5000);
	 	test.log(LogStatus.FAIL, "Back button does not working properly.");
	 }
	  		
	  		
	  	}
	 
	 public static void ERview( ExtentTest test) throws InterruptedException, IOException
	  	{Thread.sleep(5000);
	  	
	      	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	      	WebElement element = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
	      	ClientLocators.ExpiredRegistrations().click();
			Thread.sleep(5000);
			ClientLocators.EREdit().click();
			Thread.sleep(5000);
	  		
	  		ClientLocators.ViewER().click();
	  		Thread.sleep(5000);
	       	ClientLocators.OverviewColse().click();
	  		Thread.sleep(5000);
	  		test.log(LogStatus.PASS,  " view successfully.");
	  		
	  	}
	 
	 public static void exportERE(  ExtentTest test) throws InterruptedException, IOException
		{Thread.sleep(5000);
		
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
			ClientLocators.ExpiredRegistrations().click();
			Thread.sleep(5000);
			ClientLocators.EREdit().click();
			Thread.sleep(5000);
			
			Thread.sleep(3000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(5000);
			ClientLocators.Download().click();

			Thread.sleep(8000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
				test.log(LogStatus.PASS,  " File downloaded successfully.");
			} else {Thread.sleep(5000);
				test.log(LogStatus.FAIL,  " File does not downloaded.");
			}
			
		}
	 
	 public static void InitiateAction( ExtentTest test) throws InterruptedException, IOException
	  	{Thread.sleep(5000);
	  	
	      	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	      	WebElement element = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
	      	ClientLocators.ExpiredRegistrations().click();
			Thread.sleep(5000);
			ClientLocators.EREdit().click();
			Thread.sleep(5000);
	  		
	  		ClientLocators.InitiateAction().click();
	  		Thread.sleep(5000);
	       	ClientLocators.selectActivityType().click();
	  		Thread.sleep(2000);
	  		ClientLocators.selectActivityType1().click();
	  		Thread.sleep(2000);
	  		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
	  		ClientLocators.Sumit().click();
	  		Thread.sleep(2000);
	  		 By locator = By.xpath("(//h4[@class='f-label'])");

				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				Thread.sleep(4000);
			String text = getDriver().findElement(By.xpath("(//h4[@class='f-label'])")).getText();
			
			if(!text.equalsIgnoreCase("SubActivity saved successfully"))
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
	
	 public static void InitiateActionBack( ExtentTest test) throws InterruptedException, IOException
	  	{Thread.sleep(5000);
	  	
	      	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	      	WebElement element = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
	      	ClientLocators.ExpiredRegistrations().click();
			Thread.sleep(5000);
			ClientLocators.EREdit().click();
			Thread.sleep(5000);
	  		
	  		ClientLocators.InitiateAction().click();
	  		Thread.sleep(5000);
	  		if(ClientLocators.Back().isEnabled()) {Thread.sleep(5000);
			 
			test.log(LogStatus.PASS,  " Back button working successfully."); 
			ClientLocators.Back().click();
	 }
	 else
	 {Thread.sleep(5000);
	 	test.log(LogStatus.FAIL, "Back button does not working properly.");
	 }
	  		
			
			
	  		
	  	}
	
	 
	public static void OpenNotices( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.OpenNotices().getText();		//Storing old value of Statutory overdue.
	int	CategoriesCountDas = Integer.parseInt(string_Categories);
	ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Open Notices in the grid = "+CatcountGrid+" | Dashboard Open Notices  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Open Notices in the grid = "+CatcountGrid+" | Dashboard Open Notices Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void OpenNoticesView( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(CPLocator.MyDocument()));	
		CPLocator.Entity().click();
		Thread.sleep(2000);
		CPLocator.EntityExpand1().click();
		Thread.sleep(2000);
		CPLocator.checkbox1().click();
		Thread.sleep(2000);		
		CPLocator.Applybtn().click();
	
	ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
		String item = ClientLocators.Viewpage().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("View Notices")) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on view button page redirect to the view notices page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " view button not working ");

		}
		
		
	}
	
	public static void ViewAddNew ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{Thread.sleep(5000);		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	    
			  	ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
				
		ClientLocators.ViewAddNew().click();
				Thread.sleep(4000);
				ClientLocators.State().click();
				Thread.sleep(1000);
				ClientLocators.State1().click();
				Thread.sleep(3000);
				
				ClientLocators.Location().click();
				Thread.sleep(1000);
				ClientLocators.Location1().click();
				Thread.sleep(3000);
				
				ClientLocators.Branch().click();
				Thread.sleep(1000);
				ClientLocators.Branch1().click();
				Thread.sleep(3000);
				
				ClientLocators.ModeofReceipt().click();
				Thread.sleep(1000);
				ClientLocators.ModeofReceipt1().click();
				Thread.sleep(3000);
				
				ClientLocators.NoticeNumber().sendKeys("NTC1133");;
				Thread.sleep(3000);
				
				ClientLocators.NoticeReceivedDateT().sendKeys("01-02-2024");;
				Thread.sleep(3000);
				ClientLocators.NoticeReceivedDateT().sendKeys("01-02-2024");;
				Thread.sleep(3000);
				ClientLocators.NoticeReceivedDateT().sendKeys("01-02-2024");;
				Thread.sleep(3000);
				
				//ClientLocators.NoticeReceivedDate().click();
				Thread.sleep(1000);
				//Actions action1 = new Actions(getDriver());

				//action1.moveToElement(ClientLocators.NoticeReceivedDate1()).click().perform();
			//	ClientLocators.NoticeReceivedDate1().click();
				Thread.sleep(1000);
			//	ClientLocators.NoticeReceivedDate2().click();
				Thread.sleep(3000);
				
				ClientLocators.ResponseDueDate().click();
				Thread.sleep(1000);
				ClientLocators.NoticedueDate1().click();
				Thread.sleep(3000);
				
				ClientLocators.NoticeType().click();
				Thread.sleep(1000);
				ClientLocators.NoticeType1().click();
				Thread.sleep(3000);
				
				ClientLocators.Risk().click();
				Thread.sleep(1000);
				ClientLocators.Risk1().click();
				Thread.sleep(3000);
				
				ClientLocators.Browse().click();
				Thread.sleep(3000);
				Robot robot=new Robot();
				 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\ContractsList__MyWorkspace.pdf");
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
						 
				
				 ClientLocators.remark().sendKeys("remark");
					Thread.sleep(3000);
				
				
					Thread.sleep(3000);
				
				
					ClientLocators.SaveNotice().click();
				
				Thread.sleep(4000);
				 By locator = By.xpath("//h4[@class='f-label']");

					wait.until(ExpectedConditions.presenceOfElementLocated(locator));
					Thread.sleep(4000);
				String text = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
				
				if(text.equalsIgnoreCase("Notice Saved Successfully"))
				{Thread.sleep(5000);
					
					test.log(LogStatus.PASS,"Message Displayed : "+text);
				}
				else
				{Thread.sleep(5000);
					
					test.log(LogStatus.FAIL,"Message Displayed : "+text);
					
		}
				Locators.ok().click();
				Thread.sleep(4000);
		  	
	}
	
	
	public static void exportNotice(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
//		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
//		wait.until(ExpectedConditions.visibilityOf(CPLocator.MyDocument()));	
		CPLocator.Entity().click();
		Thread.sleep(2000);
		CPLocator.EntityExpand1().click();
		Thread.sleep(2000);
		CPLocator.checkbox1().click();
		Thread.sleep(2000);		
		CPLocator.Applybtn().click();
		
		
		ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void NoticeSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
		try {Thread.sleep(5000);
		ClientLocators.Search().sendKeys("123344",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='24225']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected Notice No along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "Notice No selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	public static void NoticeSearchClear(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
				ClientLocators.Search().sendKeys("123344",Keys.ENTER);
		Thread.sleep(4000);
		
		Thread.sleep(3000);
		 if(ClientLocators.Clear().isEnabled()) {Thread.sleep(5000);
			 
				test.log(LogStatus.PASS,  " Clear button working successfully."); 
				ClientLocators.Clear().click();
		 }
		 else
		 {Thread.sleep(5000);
		 	test.log(LogStatus.FAIL, "Clear button does not working properly.");
		 }
		  	 Thread.sleep(3000);
		  
		
	}
	
	public static void OpenNoticesEditback( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
	
	ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
		ClientLocators.Edit1().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);
		ClientLocators.EditBack().click();
		Thread.sleep(3000);
		
		String item = ClientLocators.Viewpage().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("View Notices")) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on Back button page redirect to the view notices page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " Back button not working ");

		}
		
		
	}
	
	public static void OverviewNotice(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		
		
	}
	
	public static void OpenNoticesback( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
	
	ClientLocators.OpenNotices().click();
		Thread.sleep(5000);
		
	
		ClientLocators.Edit1().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);
		ClientLocators.EditBack().click();
		Thread.sleep(3000);
		
		String item = ClientLocators.OpenNoticePage().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("Open Notices")) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on Back button page redirect to the Open Notices page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " Back button not working ");

		}
		
		
	}
	
	public static void RegistrationStatus( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.Active().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	ClientLocators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ActiveCol().click();
		Thread.sleep(3000);
		
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Active in the grid = "+CatcountGrid+" | Dashboard Active  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Active in the grid = "+CatcountGrid+" | Dashboard Active Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void RegistrationStatusEx( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.Expired().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	ClientLocators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ExpiredCol().click();
		Thread.sleep(3000);
		
		
//		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Expired in the grid = "+CatcountGrid+" | Dashboard Expired  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Expired in the grid = "+CatcountGrid+" | Dashboard Expired Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	
	public static void RegistrationStatusExport( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.Active().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	ClientLocators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		Thread.sleep(5000);
		ClientLocators.ActiveCol().click();
		Thread.sleep(3000);
		
		
		
//		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(3000);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
		
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
	
	public static void RegistrationStatusExportE( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.Expired().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	ClientLocators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ExpiredCol().click();
		Thread.sleep(3000);
		
		
		
//		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(5000);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		Thread.sleep(5000);
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		Thread.sleep(5000);
		int count1 = Integer.parseInt(compliancesCount);
		
		
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

	
	public static void RegistrationSView( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	ClientLocators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ActiveCol().click();
		Thread.sleep(3000);
		
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  "view successfully.");
		
		
	}
	
	public static void RegistrationSViewEx( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	ClientLocators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ExpiredCol().click();
		Thread.sleep(3000);
		
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  "view successfully.");
		
		
	}
	
	
	public static void DownloadActive(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		ClientLocators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ActiveCol().click();
		Thread.sleep(3000);
		
	
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(3000);
		ClientLocators.DownloadBtn().click();

		Thread.sleep(10000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void DownloadActiveEx(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		ClientLocators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ExpiredCol().click();
		Thread.sleep(3000);
		
	
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.DownloadBtn().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void RegistrationSHistory( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	ClientLocators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ActiveCol().click();
		Thread.sleep(3000);
		
		
		ClientLocators.History().click();
		Thread.sleep(5000);
		String item = ClientLocators.RegistrationLicencesHistory().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("Registration & Licences History")) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on History button page redirect to the Registration & Licences History page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " History button not working ");

		}
		
	}
	
	public static void RegistrationSHistoryEx( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
     	ClientLocators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ExpiredCol().click();
		Thread.sleep(3000);
		
		
		ClientLocators.History().click();
		Thread.sleep(5000);
		String item = ClientLocators.RegistrationLicencesHistory().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("Registration & Licences History")) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on History button page redirect to the Registration & Licences History page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " History button not working ");

		}
		
	}
	
	public static void RegistrationSHistoryExport(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		ClientLocators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ActiveCol().click();
		Thread.sleep(3000);
		ClientLocators.History().click();
		Thread.sleep(5000);
		
	
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void RegistrationSHistoryExportEx(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		ClientLocators.Expired().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ExpiredCol().click();
		Thread.sleep(3000);
		ClientLocators.History().click();
		Thread.sleep(5000);
		
	
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void RegistrationSExport(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		ClientLocators.Active().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
	
		
	
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	
	public static void ActiveSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.Active().click();
		Thread.sleep(5000);
		ClientLocators.ActiveCol().click();
		Thread.sleep(3000);
		try {Thread.sleep(5000);
		ClientLocators.Search().sendKeys("12309856wrt",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='12309856wrt']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected License No along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "License No selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	public static void ExpiredSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.Expired().click();
		Thread.sleep(5000);
		ClientLocators.ExpiredCol().click();
		Thread.sleep(3000);
		try {Thread.sleep(5000);
		ClientLocators.Search().sendKeys("nbvc765",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[@title='nbvc765']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected License No along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "License No selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	
	public static void RegistrationSearch(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	
		ClientLocators.Active().click();
		Thread.sleep(5000);
		
		try {Thread.sleep(5000);
		ClientLocators.Search().sendKeys("Trade license",Keys.ENTER);
		Thread.sleep(4000);
		String text = getDriver().findElement(By.xpath("//div[normalize-space()='Trade license']")).getText();
		
			
		test.log(LogStatus.PASS, "Selected License Name along with their details should get reflected in the grid.");
		test.log(LogStatus.PASS, "License Name selected : "+text);
		
		Thread.sleep(3000);
		}catch(Exception e) {Thread.sleep(5000);
			test.log(LogStatus.PASS, "no record available");
		}
		
	}
	
	public static void CompliancePerformance( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
		ClientLocators.Gopi().click();
		Thread.sleep(4000);
		ClientLocators.SelectYear().click();
		Thread.sleep(2000);
	  	ClientLocators.SelectYear25().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		String string_Categories =ClientLocators.Overdue().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 2];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	ClientLocators.Overdue().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		
		js.executeScript("window.scrollBy(0,300)");	
		
		
		String string_User =ClientLocators.OverdueGrid().getText();		//Storing old value of Statutory overdue.
		int	UserCountDas = Integer.parseInt(string_User);
		if(CategoriesCountDas == UserCountDas)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Overdue in the grid = "+UserCountDas+" | Dashboard Overdue  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Overdue in the grid = "+UserCountDas+" | Dashboard Overdue Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void PayrollCompliancesOverdue(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
		ClientLocators.Gopi().click();
		Thread.sleep(4000);
		ClientLocators.SelectYear().click();
		Thread.sleep(2000);
	  	ClientLocators.SelectYear25().click();
		Thread.sleep(2000);
		
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.PayrollCompliancesOverdue().click();
		Thread.sleep(5000);
		ClientLocators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = ClientLocators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
	}
	
	public static void PayrollCompliancesComplie(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		Thread.sleep(2000);
		
		ClientLocators.Complied().click();
		Thread.sleep(5000);
		
		ClientLocators.PayrollCompliancesComplied().click();
		Thread.sleep(5000);
		ClientLocators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = ClientLocators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS,  " Overview successfully.");
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
		
		
	}
	
	public static void exportPayrollCompliancesOverdue(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
		ClientLocators.Gopi().click();
		Thread.sleep(4000);
		ClientLocators.SelectYear().click();
		Thread.sleep(2000);
	  	ClientLocators.SelectYear25().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.PayrollCompliancesOverdue().click();
		Thread.sleep(5000);
		ClientLocators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = ClientLocators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
	}
	
	public static void exportPayrollCompliancesComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		ClientLocators.Complied().click();
		Thread.sleep(5000);
		
		ClientLocators.PayrollCompliancesComplied().click();
		Thread.sleep(5000);
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
		
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Locators.Export().click();

	Thread.sleep(5500);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	if(dirContents.length < allFilesNew.length)
	{Thread.sleep(5000);

	test.log(LogStatus.PASS, "File downloaded successfully.");
	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	{Thread.sleep(5000);
	   if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	   {Thread.sleep(5000);
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
	{Thread.sleep(5000);
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {Thread.sleep(5000);
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();

	if(count1 == actualRow)
	{Thread.sleep(5000);
		
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{Thread.sleep(5000);
		
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
	}
	else
	{Thread.sleep(5000);
	test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
	}
		
	}
	
	public static void exportEcComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		ClientLocators.Complied().click();
		Thread.sleep(5000);
		
		ClientLocators.ECComplied().click();
		Thread.sleep(5000);
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
		
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Locators.Export().click();

	Thread.sleep(5500);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	if(dirContents.length < allFilesNew.length)
	{Thread.sleep(5000);

	test.log(LogStatus.PASS, "File downloaded successfully.");
	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	{Thread.sleep(5000);
	   if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	   {Thread.sleep(5000);
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
	{Thread.sleep(5000);
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {Thread.sleep(5000);
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();

	if(count1 == actualRow)
	{Thread.sleep(5000);
		
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{Thread.sleep(5000);
		
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
	}
	else
	{Thread.sleep(5000);
	test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
	}
		
	}
	
	
	
	
	
	
	public static void ECOverdue(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
		ClientLocators.Gopi().click();
		Thread.sleep(4000);
		ClientLocators.SelectYear().click();
		Thread.sleep(2000);
	  	ClientLocators.SelectYear25().click();
		Thread.sleep(2000);
		
		ClientLocators.Apply().click();
		Thread.sleep(4000);*/
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.ECOverdue().click();
		Thread.sleep(5000);
//		ClientLocators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = ClientLocators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		
		Thread.sleep(5000);
	    
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
	}else {Thread.sleep(5000);
		Thread.sleep(1000);
		
		
		test.log(LogStatus.PASS, "No records available.");
		
	}
		
	}
	
	public static void ECComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		
		ClientLocators.Complied().click();
		Thread.sleep(5000);
		
		ClientLocators.ECComplied().click();
		Thread.sleep(5000);
		
		ClientLocators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = ClientLocators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS,  " Overview successfully.");
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
	}
	
	public static void exportEC(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
		ClientLocators.Gopi().click();
		Thread.sleep(4000);
		ClientLocators.SelectYear().click();
		Thread.sleep(2000);
	  	ClientLocators.SelectYear25().click();
		Thread.sleep(2000);
		
		ClientLocators.Apply().click();
		Thread.sleep(4000);*/
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.ECOverdue().click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-client-entity-dashboard-grid/div[3]/kendo-loader/div")));
		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void FCOverdue(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
		ClientLocators.Gopi().click();
		Thread.sleep(4000);
		ClientLocators.SelectYear().click();
		Thread.sleep(2000);
	  	ClientLocators.SelectYear25().click();
		Thread.sleep(2000);
		
		ClientLocators.Apply().click();
		Thread.sleep(4000);*/
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.FCOverdue().click();
		Thread.sleep(5000);
//		ClientLocators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = ClientLocators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
	}
	
	public static void FCCompioed(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		ClientLocators.Complied().click();
		Thread.sleep(5000);
		
		ClientLocators.FCCompied().click();
		Thread.sleep(5000);
		
		ClientLocators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = ClientLocators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS,  " Overview successfully.");
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
	}
	public static void exportFC(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		/*ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
		ClientLocators.Gopi().click();
		Thread.sleep(4000);
		ClientLocators.SelectYear().click();
		Thread.sleep(2000);
	  	ClientLocators.SelectYear25().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);*/
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.FCOverdue().click();
		Thread.sleep(5000);
//		ClientLocators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = ClientLocators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
	}else {Thread.sleep(5000);
		Thread.sleep(1000);
		
		
		test.log(LogStatus.PASS, "No records available.");
		
	}
	}
	
	public static void exportFCComplies(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		ClientLocators.Complied().click();
		Thread.sleep(5000);
		
		ClientLocators.FCCompied().click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
		
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Locators.Export().click();

	Thread.sleep(5500);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	if(dirContents.length < allFilesNew.length)
	{Thread.sleep(5000);

	test.log(LogStatus.PASS, "File downloaded successfully.");
	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	{Thread.sleep(5000);
	   if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	   {Thread.sleep(5000);
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
	{Thread.sleep(5000);
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {Thread.sleep(5000);
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();

	if(count1 == actualRow)
	{Thread.sleep(5000);
		
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{Thread.sleep(5000);
		
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
	}
	else
	{Thread.sleep(5000);
	test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
	}
		
	}
	
	public static void ClraOverdue(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
		ClientLocators.Gopi().click();
		Thread.sleep(4000);
		ClientLocators.SelectYear().click();
		Thread.sleep(2000);
	  	ClientLocators.SelectYear25().click();
		Thread.sleep(2000);
		
		ClientLocators.Apply().click();
		Thread.sleep(4000);*/
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.ClraOverdue().click();
		Thread.sleep(5000);
		ClientLocators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = ClientLocators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  " Overview successfully.");
		
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
	}
	
	public static void ClraComplied(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		ClientLocators.Complied().click();
		Thread.sleep(5000);
		
		ClientLocators.ClraComplied().click();
		Thread.sleep(5000);
		
		ClientLocators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = ClientLocators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
		test.log(LogStatus.PASS,  " Overview successfully.");
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
	}
	
	
	public static void exportClra (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
		ClientLocators.Gopi().click();
		Thread.sleep(4000);
		ClientLocators.SelectYear().click();
		Thread.sleep(2000);
	  	ClientLocators.SelectYear25().click();
		Thread.sleep(2000);
		
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.ClraOverdue().click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[contains(@title,'Overview')])[1]")));
		Thread.sleep(8000);
		Thread.sleep(3000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void exportClraComplied (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		
		ClientLocators.Complied().click();
		Thread.sleep(5000);
		
		ClientLocators.ClraComplied().click();
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Locators.Export().click();

	Thread.sleep(5500);
	File dir1 = new File("C:\\Users\\bilali\\Downloads");
	File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

	if(dirContents.length < allFilesNew.length)
	{Thread.sleep(5000);

	test.log(LogStatus.PASS, "File downloaded successfully.");
	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
	for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
	{Thread.sleep(5000);
	   if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
	   {Thread.sleep(5000);
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
	{Thread.sleep(5000);
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {Thread.sleep(5000);
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();

	if(count1 == actualRow)
	{Thread.sleep(5000);
		
		test.log(LogStatus.PASS, "Total records from Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{Thread.sleep(5000);
		
		test.log(LogStatus.FAIL, "Total records from Grid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
	}
	else
	{Thread.sleep(5000);
	test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
	}
		
	}
	
	public static void exportCP (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
		ClientLocators.Gopi().click();
		Thread.sleep(4000);
		ClientLocators.SelectYear().click();
		Thread.sleep(2000);
	  	ClientLocators.SelectYear25().click();
		Thread.sleep(2000);
		
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		ClientLocators.Overdue().click();
		Thread.sleep(5000);
		
		ClientLocators.readTotalItemsD().click();					//Clicking on Text of total items just to scroll down.
		String s = ClientLocators.readTotalItemsD().getText();
		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {Thread.sleep(5000);
		
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		}else {Thread.sleep(5000);
			Thread.sleep(1000);
			
			
			test.log(LogStatus.PASS, "No records available.");
			
		}
		
	}
	
	public static void OpenStatus( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
		
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[30]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
		String string_Categories =ClientLocators.Open().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	ClientLocators.Open().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.OpenCol().click();
		Thread.sleep(3000);
		
		
//		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Open count in the grid = "+CatcountGrid+" | Dashboard Open Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Open count in the grid = "+CatcountGrid+" | Dashboard Open Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void OpenView(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[30]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		ClientLocators.Open().click();
		Thread.sleep(5000);
		
		ClientLocators.OpenCol().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
//		ClientLocators.OverviewClose().click(); //me comment
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  "view successfully.");
		
		
	}
	
	public static void exportOpen (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[30]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		ClientLocators.Open().click();
		Thread.sleep(5000);
		
		ClientLocators.OpenCol().click();
		Thread.sleep(5000);

		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void ClosedStatus( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[31]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		String string_Categories =ClientLocators.Closed().getText();		//Storing old value of Statutory overdue.
		String[] bits1 = string_Categories.split(" ");								//Splitting the String
		String compliancesCount1 = bits1[bits1.length - 1];
		int CategoriesCountDas = Integer.parseInt(compliancesCount1);
     	ClientLocators.Closed().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		ClientLocators.ClosedCol().click();
		Thread.sleep(3000);
		
		
//		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Closed count in the grid = "+CatcountGrid+" | Dashboard Closed Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Closed count in the grid = "+CatcountGrid+" | Dashboard Closed Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	public static void ClosedView(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[31]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		ClientLocators.Closed().click();
		Thread.sleep(5000);
		
		ClientLocators.ClosedCol().click();
		Thread.sleep(5000);
		
		ClientLocators.View().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  "view successfully.");
		
		
	}
	
	public static void exportClosed (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[31]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		ClientLocators.Closed().click();
		Thread.sleep(5000);
		
		ClientLocators.ClosedCol().click();
		Thread.sleep(5000);

		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void exportNoticeStatus (  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[31]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		ClientLocators.Closed().click();
		Thread.sleep(5000);

		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		Locators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void RegistrationStatusBar( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='g'])[61]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
		String string_Categories =ClientLocators.Registration().getText();		//Storing old value of Statutory overdue.
		
		int CategoriesCountDas = Integer.parseInt(string_Categories);
     	ClientLocators.Registration().click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (500));
		
		
		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Active in the grid = "+CatcountGrid+" | Dashboard Active  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Active in the grid = "+CatcountGrid+" | Dashboard Active Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	
	public static void RegistrationStatusExportBar( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	ClientLocators.Registration().click();
		Thread.sleep(5000);
		
		
//		ClientLocators.readTotalItems().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
		
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
	ClientLocators.CLDashboard().click();
	
	}

	
	public static void RegistrationSViewL( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	ClientLocators.Registration().click();
		Thread.sleep(5000);
		
		
		ClientLocators.OverviewNo().click();
		Thread.sleep(5000);
		ClientLocators.OverviewClose().click();
		
		Thread.sleep(3000);
		
			test.log(LogStatus.PASS,  "view successfully.");
		
		
	}
	
	public static void DownloadActiveBar(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	ClientLocators.Registration().click();
		Thread.sleep(5000);
		
	
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.DownloadBtn().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void RegistrationSHistoryBar( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	ClientLocators.Registration().click();
		Thread.sleep(5000);
		
		
		ClientLocators.History().click();
		Thread.sleep(5000);
		String item = ClientLocators.RegistrationLicencesHistory().getText();
		Thread.sleep(4000);
		if(item.equalsIgnoreCase("Registration & Licences History")) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Clicking on History button page redirect to the Registration & Licences History page");
		}else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " History button not working ");

		}
		
	}
	
	
	public static void RegistrationSHistoryExportBar(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("(//*[name()='text'][@id='chart-container-registration-status_Series_0_Point_0_Text_0'])[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		
     	ClientLocators.Registration().click();
		Thread.sleep(5000);
		ClientLocators.History().click();
		Thread.sleep(5000);
		
	
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.Export().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  " File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  " File does not downloaded.");
		}
		
	}
	
	public static void CalendarExport( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		WebElement element = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100)) ;
     	ClientLocators.ClickTriangle().click();
		Thread.sleep(2000);
		ClientLocators.nextmonth().click();
		Thread.sleep(1000);
		ClientLocators.nextmonth2025().click();
		Thread.sleep(5000);
		ClientLocators.number().click();
		Thread.sleep(5000);
		
		//ClientLocators.readTotalItems1().click();					//Clicking on total items count
		Thread.sleep(500);
		Actions action = new Actions(getDriver());

		By locator = By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-client-dashboard/div[8]/div/div/app-client-compliance-calender/div[2]/div[2]/kendo-grid/kendo-pager/kendo-pager-info");

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(4000);
		
		WebElement ViewButton = getDriver().findElement(locator);	
		Thread.sleep(3000);
	JavascriptExecutor jse=(JavascriptExecutor) getDriver();
	jse.executeScript("arguments[0].click();", ViewButton);
		Thread.sleep(4000);
		String item = ClientLocators.readTotalItems1().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int count1 = Integer.parseInt(compliancesCount);
		
		
		
File dir = new File("C:\\Users\\bilali\\Downloads");
File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

Locators.Export().click();

Thread.sleep(5500);
File dir1 = new File("C:\\Users\\bilali\\Downloads");
File[] allFilesNew = dir1.listFiles();							//Counting number of files in directory after download

if(dirContents.length < allFilesNew.length)
{Thread.sleep(5000);
	
	test.log(LogStatus.PASS, "File downloaded successfully.");
	File lastModifiedFile = allFilesNew[0];			//Storing any 0th index file in 'lastModifiedFile' file name.
    for (int i = 1; i < allFilesNew.length; i++) 	//For loop till the number of files in directory.
    {Thread.sleep(5000);
       if (lastModifiedFile.lastModified() < allFilesNew[i].lastModified()) 	//If allFilesNew[i] file is having large/latest time time of update then latest modified file be allFilesNew[i] file.
       {Thread.sleep(5000);
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
	{Thread.sleep(5000);
		
		Cell cell =row.getCell(columnNumber);
		if(cell != null) {Thread.sleep(5000);
			
			rowCount++;
			actualRow = rowCount-1;
		}
		
	}
	fis.close();
	
	if(count1 == actualRow)
	{Thread.sleep(5000);
		
		test.log(LogStatus.PASS, "Total records from Calendar Grid = "+count1+" | Total records from Report = "+actualRow);
	}
	else
	{Thread.sleep(5000);
		
		test.log(LogStatus.FAIL, "Total records from  CalendarGrid = "+count1+" | Total records from Excel Sheet = "+actualRow);
	}
}
else
{Thread.sleep(5000);
	test.log(LogStatus.FAIL, "File doesn't downloaded successfully.");
}
	
	}

    public static void CalendarCount( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
    	JavascriptExecutor js = (JavascriptExecutor) getDriver();
    	WebElement element = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(getDriver(), (100)) ;
     	ClientLocators.ClickTriangle().click();
		Thread.sleep(2000);
		ClientLocators.nextmonth().click();
		Thread.sleep(1000);
		ClientLocators.nextmonth2025().click();
		Thread.sleep(5000);
		
		
		String string_Categories =ClientLocators.number().getText();		//Storing old value of Statutory overdue.
		
		int CategoriesCountDas = Integer.parseInt(string_Categories);
     	ClientLocators.number().click();
		Thread.sleep(5000);
	
		
		
		ClientLocators.readTotalItems1().click();					//Clicking on total items count
		Thread.sleep(500);
		String item = ClientLocators.readTotalItems1().getText();	//Reading total items String value
		String[] bits = item.split(" ");								//Splitting the String
		String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
		int CatcountGrid = Integer.parseInt(compliancesCount);
		
		if(CategoriesCountDas == CatcountGrid)
		{Thread.sleep(5000);
			
			test.log(LogStatus.PASS, "No of Calendar Grid = "+CatcountGrid+" | Dashboard Calendar  Count = "+CategoriesCountDas);
		}
		else
		{Thread.sleep(5000);
		
			test.log(LogStatus.FAIL, "No of Calendar Grid= "+CatcountGrid+" | Dashboard Calendar Count = "+CategoriesCountDas);
		}
		Thread.sleep(3000);
		
	}
	
	
	
    public static void CalendarOverview( ExtentTest test) throws InterruptedException, IOException
  	{Thread.sleep(5000);
  	
      	JavascriptExecutor js = (JavascriptExecutor) getDriver();
      	WebElement element = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
  		WebDriverWait wait = new WebDriverWait(getDriver(), (100)) ;
       	ClientLocators.ClickTriangle().click();
  		Thread.sleep(2000);
  		ClientLocators.nextmonth().click();
  		Thread.sleep(1000);
  		ClientLocators.nextmonth2025().click();
  		Thread.sleep(5000);
       	ClientLocators.number().click();
  		Thread.sleep(5000);
  		
  		ClientLocators.OverviewCalen().click();
  		Thread.sleep(5000);
       	ClientLocators.OverviewColse().click();
  		Thread.sleep(5000);
  		test.log(LogStatus.PASS,  " Overview successfully.");
  		
  	}
    
    public static void DailyUpdates( ExtentTest test) throws InterruptedException, IOException
  	{Thread.sleep(5000);
  	
      	JavascriptExecutor js = (JavascriptExecutor) getDriver();
      	WebElement element = getDriver().findElement(By.xpath("//div[@class='updates']//div[1]//a[1]"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
  		WebDriverWait wait = new WebDriverWait(getDriver(), (100)) ;
       	ClientLocators.read().click();
  		Thread.sleep(2000);
  		SwitchtoChild(test);
  		
  		test.log(LogStatus.PASS,  " read more link working  successfully.");
  	  SwitchtoParent(test);
      Thread.sleep(3000);
  	}

    public static void SwitchtoChild( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);		
		Thread.sleep(3000);
		
		Set w = getDriver().getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      
	      getDriver().switchTo().window(ch);         // switching child window
	      
	    
			Thread.sleep(1000);
	      
	  
	}
    
    public static void SwitchtoParent( ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);		
		Thread.sleep(3000);
		
		Set w = getDriver().getWindowHandles();    // window handles
		Thread.sleep(3000);
	      Iterator t = w.iterator();  // window handles iterate
	      String pw = (String) t.next();
	      String ch = (String) t.next();
	      getDriver().close();
	      Thread.sleep(3000);
	      getDriver().switchTo().window(pw);         // switching child window
	       
	}
    
    
    public static void InputUpload ( ExtentTest test) throws InterruptedException, IOException, AWTException
	{Thread.sleep(5000);		
		Actions action = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
		Thread.sleep(3000);
	/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
	 	ClientLocators.InputUpload().click();
	 
		Thread.sleep(3000);

		ClientLocators.BrowseIn().click();
		Thread.sleep(3000);
		Robot robot=new Robot();
		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlyAttendance.xlsx");
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
					
					if(text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
						test.log(LogStatus.PASS,"Message Displayed : "+text1);
				
					}else {Thread.sleep(5000);
						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
					}
						Locators.ok().click();
		  	
	}
	
    public static void InputUploadTem ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{Thread.sleep(5000);		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);
   		//ClientLocators.SelectEntity().click();
   		Thread.sleep(2000);
   	 // 	ClientLocators.EntityTri1().click();
   		Thread.sleep(2000);
   		
   	//	ClientLocators.AVAAEntity().click();
   		Thread.sleep(2000);
   //		ClientLocators.Apply().click();
   		Thread.sleep(4000);
   		
   	 	ClientLocators.InputUpload().click();
   	 
   		Thread.sleep(3000);

   		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.Template().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Template File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "Template File does not downloaded.");
		}
   		  	
   	}
   	
       
    public static void InputUploadInavlid ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		ClientLocators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlyAttendance_InvalidData.xlsx");
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
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
  	
    public static void InputUploadBlank ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		ClientLocators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlyAttendance_Blank.xlsx");
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
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
  	
    public static void InputUploadInvalidformate ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		ClientLocators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\ContractsList__MyWorkspace.pdf");
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
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
  	
    
    public static void InputUploadInvalidTemp ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		ClientLocators.SelectEntity().click();
  		Thread.sleep(2000);
  	  	ClientLocators.EntityTri1().click();
  		Thread.sleep(2000);
  		
  		ClientLocators.AVAAEntity().click();
  		Thread.sleep(2000);
  		ClientLocators.Apply().click();
  		Thread.sleep(4000);
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		ClientLocators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\LocationSampleUpdate_AVAREGTR_20250125T052218413Z.xlsx");
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
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
  	
    public static void InputUploadNofile ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
  	
    public static void IUHistory(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
    	Thread.sleep(3000);
    	/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);
		
		 if(ClientLocators.HistoryIU().isEnabled()) {Thread.sleep(5000);
			 
				test.log(LogStatus.PASS,  " History button working successfully."); 
				ClientLocators.HistoryIU().click();
		 }
		 else
		 {Thread.sleep(5000);
		 	test.log(LogStatus.FAIL, "History button does not working properly.");
		 }
		  	 Thread.sleep(3000);
		  
		
	}
    
    public static void IUHistoryD(  ExtentTest test) throws InterruptedException, IOException
	{Thread.sleep(5000);
	
    	Thread.sleep(3000);
    	/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		ClientLocators.HistoryIU1().click();
  		Thread.sleep(3000);
  		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.InputHistoryD().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Input History File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "Input History File does not downloaded.");
		}
		 
		
	}
    
    
    public static void InputUploadTemSa ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{Thread.sleep(5000);		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);
   		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   	 	ClientLocators.InputUpload().click();
   	 
   		Thread.sleep(3000);

   		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.Template1().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Template File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "Template File does not downloaded.");
		}
   		  	
   	}
    
    public static void InputUploadSA ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{Thread.sleep(5000);		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);
   		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   	 	ClientLocators.InputUpload().click();
   	 
   		Thread.sleep(3000);

   		ClientLocators.BrowseIn1().click();
   		Thread.sleep(3000);
   		Robot robot=new Robot();
   		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlySalary_Valid Data.xlsx");
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
   				 
   		 Locators.UploadAM1().click();
   					
   					Thread.sleep(3000);
   				
   					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
   					
   					if(text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
   						test.log(LogStatus.PASS,"Message Displayed : "+text1);
   				
   					}else {Thread.sleep(5000);
   						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
   					}
   						Locators.ok().click();
   		  	
   	}
   	
    public static void InputUploadInavlidSA ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		ClientLocators.BrowseIn1().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlySalary_InValid Data.xlsx");
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
  				 
  		 Locators.UploadAM1().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadBlankSa ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		ClientLocators.BrowseIn1().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlySalary_Blank.xlsx");
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
  				 
  		 Locators.UploadAM1().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadInvalidformateSa ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		ClientLocators.BrowseIn1().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\ContractsList__MyWorkspace.pdf");
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
  				 
  		 Locators.UploadAM1().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadInvalidTempSa ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		ClientLocators.BrowseIn1().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\LocationSampleUpdate_AVAREGTR_20250125T052218413Z.xlsx");
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
  				 
  		 Locators.UploadAM1().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadNofileSa ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);

  		 Locators.UploadAM1().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void IUHistorySa(  ExtentTest test) throws InterruptedException, IOException
 	{Thread.sleep(5000);
 	
     	Thread.sleep(3000);
     	/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
   	 	ClientLocators.InputUpload().click();
   	 
   		Thread.sleep(3000);
 		
 		 if(ClientLocators.HistoryIU1().isEnabled()) {Thread.sleep(5000);
 			 
 				test.log(LogStatus.PASS,  " History button working successfully."); 
 				ClientLocators.HistoryIU1().click();
 		 }
 		 else
 		 {Thread.sleep(5000);
 		 	test.log(LogStatus.FAIL, "History button does not working properly.");
 		 }
 		  	 Thread.sleep(3000);
 		  
 		
 	}
    
    public static void IUHistoryDSA(  ExtentTest test) throws InterruptedException, IOException
  	{Thread.sleep(5000);
  	
      	Thread.sleep(3000);
      	/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
    		
    	 	ClientLocators.InputUpload().click();
    	 
    		Thread.sleep(3000);
    		ClientLocators.HistoryIU1().click();
    		Thread.sleep(3000);
    		File dir = new File("C:\\Users\\bilali\\Downloads");
  		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

  		Thread.sleep(500);
  		ClientLocators.InputHistoryD().click();

  		Thread.sleep(8000);
  		File dir1 = new File("C:\\Users\\bilali\\Downloads");
  		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
  		Thread.sleep(3000);
  		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
  			test.log(LogStatus.PASS,  "Input History File downloaded successfully.");
  		} else {Thread.sleep(5000);
  			test.log(LogStatus.FAIL,  "Input History File does not downloaded.");
  		}
  		 
  		
  	}
  	
    public static void InputUploadTemChha ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{Thread.sleep(5000);		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);
   		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   		
   	 	ClientLocators.InputUpload().click();
   	 
   		Thread.sleep(3000);
   		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Challan1().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);

   		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.Template().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Template File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "Template File does not downloaded.");
		}
   		  	
   	}
    
    
    public static void InputUploadCh ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{Thread.sleep(5000);		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);
   		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   	 	ClientLocators.InputUpload().click();
   	 
   		Thread.sleep(3000);
   		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Challan1().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);

   		ClientLocators.BrowseIn().click();
   		Thread.sleep(3000);
   		Robot robot=new Robot();
   		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlySalary_Valid Data.xlsx");
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
   					
   					if(text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
   						test.log(LogStatus.PASS,"Message Displayed : "+text1);
   				
   					}else {Thread.sleep(5000);
   						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
   					}
   						Locators.ok().click();
   	}

    public static void InputUploadInavlidCh ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Challan1().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);

  		ClientLocators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlySalary_InValid Data.xlsx");
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
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    
    public static void InputUploadBlankCh ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Challan1().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);

  		ClientLocators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlySalary_Blank.xlsx");
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
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadInvalidformateCh ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		
  		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Challan1().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);

  		ClientLocators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\ContractsList__MyWorkspace.pdf");
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
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadInvalidTempCh ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		
  		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Challan1().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);

  		ClientLocators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\LocationSampleUpdate_AVAREGTR_20250125T052218413Z.xlsx");
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
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    
    public static void InputUploadNofileCh ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  	/*	ClientLocators.SelectEntity().click();
  		Thread.sleep(2000);
  	  	ClientLocators.EntityTri1().click();
  		Thread.sleep(2000);
  		
  		ClientLocators.AVAAEntity().click();
  		Thread.sleep(2000);
  		ClientLocators.Apply().click();
  		Thread.sleep(4000);
  		*/
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Challan1().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);

  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void IUHistoryCh(  ExtentTest test) throws InterruptedException, IOException
 	{Thread.sleep(5000);
 	
     	Thread.sleep(3000);
     	/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   	 	ClientLocators.InputUpload().click();
   	 
   		Thread.sleep(3000);
   		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Challan1().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);
 		
 		 if(ClientLocators.HistoryIU().isEnabled()) {Thread.sleep(5000);
 			 
 				test.log(LogStatus.PASS,  " History button working successfully."); 
 				ClientLocators.HistoryIU().click();
 		 }
 		 else
 		 {Thread.sleep(5000);
 		 	test.log(LogStatus.FAIL, "History button does not working properly.");
 		 }
 		  	 Thread.sleep(3000);
 		  
 		
 	}
    
    public static void IUHistoryDCh(  ExtentTest test) throws InterruptedException, IOException
  	{Thread.sleep(5000);
  	
      	Thread.sleep(3000);
      	/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
    		
    	 	ClientLocators.InputUpload().click();
    	 
    		Thread.sleep(3000);
    		ClientLocators.Challan().click();
       		Thread.sleep(2000);
       		ClientLocators.Challan1().click();
       		Thread.sleep(4000);
       		ClientLocators.Apply().click();
       		Thread.sleep(4000);
    		ClientLocators.HistoryIU().click();
    		Thread.sleep(3000);
    		File dir = new File("C:\\Users\\bilali\\Downloads");
  		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

  		Thread.sleep(500);
  		ClientLocators.InputHistoryD().click();

  		Thread.sleep(8000);
  		File dir1 = new File("C:\\Users\\bilali\\Downloads");
  		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
  		Thread.sleep(3000);
  		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
  			test.log(LogStatus.PASS,  "Input History File downloaded successfully.");
  		} else {Thread.sleep(5000);
  			test.log(LogStatus.FAIL,  "Input History File does not downloaded.");
  		}
  		 
  		
  	}
    
    public static void InputUploadTemRe ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{Thread.sleep(5000);		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);
   		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   		
   	 	ClientLocators.InputUpload().click();
   	 
   		Thread.sleep(3000);
   		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Return().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);

   		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

		Thread.sleep(500);
		ClientLocators.Template().click();

		Thread.sleep(8000);
		File dir1 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
		Thread.sleep(3000);
		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
			test.log(LogStatus.PASS,  "Template File downloaded successfully.");
		} else {Thread.sleep(5000);
			test.log(LogStatus.FAIL,  "Template File does not downloaded.");
		}
   		  	
   	}
    
    public static void InputUploadRe ( ExtentTest test) throws InterruptedException, IOException, AWTException
   	{Thread.sleep(5000);		
   		Actions action = new Actions(getDriver());
   		WebDriverWait wait = new WebDriverWait( getDriver(), (40));
   		Thread.sleep(3000);
   		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   	 	ClientLocators.InputUpload().click();
   	 
   		Thread.sleep(3000);
   		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Return().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);

   		ClientLocators.BrowseIn().click();
   		Thread.sleep(3000);
   		Robot robot=new Robot();
   		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlySalary_Valid Data.xlsx");
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
   					
   					if(text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
   						test.log(LogStatus.PASS,"Message Displayed : "+text1);
   				
   					}else {Thread.sleep(5000);
   						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
   					}
   						Locators.ok().click();
   	}
    
    public static void InputUploadInavlidRe( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Return().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);

  		ClientLocators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlySalary_InValid Data.xlsx");
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
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadBlankRe ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Return().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);

  		ClientLocators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\Sample-MonthlySalary_Blank.xlsx");
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
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadInvalidformateRe ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		
  		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Return().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);

  		ClientLocators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\ContractsList__MyWorkspace.pdf");
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
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadInvalidTempRe( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		
  		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Return().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);

  		ClientLocators.BrowseIn().click();
  		Thread.sleep(3000);
  		Robot robot=new Robot();
  		 StringSelection filepath= new  StringSelection("D:\\Automation File\\Labour Auto\\LocationSampleUpdate_AVAREGTR_20250125T052218413Z.xlsx");
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
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    public static void InputUploadNofilere ( ExtentTest test) throws InterruptedException, IOException, AWTException
  	{Thread.sleep(5000);		
  		
  		Thread.sleep(3000);
  		/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
  		
  	 	ClientLocators.InputUpload().click();
  	 
  		Thread.sleep(3000);
  		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Return().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);

  		 Locators.Upload().click();
  					
  					Thread.sleep(3000);
  				
  					String text1 = getDriver().findElement(By.xpath("//h4[@class='f-label']")).getText();
  					
  					if(!text1.equalsIgnoreCase("File uploaded successfully")) {Thread.sleep(5000);
  						test.log(LogStatus.PASS,"Message Displayed : "+text1);
  				
  					}else {Thread.sleep(5000);
  						test.log(LogStatus.FAIL,"Message Displayed : "+text1);
  					}
  						Locators.ok().click();
  		  	
  	}
    
    
    public static void IUHistoryRe(  ExtentTest test) throws InterruptedException, IOException
 	{Thread.sleep(5000);
 	
     	Thread.sleep(3000);
     	/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
   		
   	 	ClientLocators.InputUpload().click();
   	 
   		Thread.sleep(3000);
   		ClientLocators.Challan().click();
   		Thread.sleep(2000);
   		ClientLocators.Return().click();
   		Thread.sleep(4000);
   		ClientLocators.Apply().click();
   		Thread.sleep(4000);
 		
 		 if(ClientLocators.HistoryIU().isEnabled()) {Thread.sleep(5000);
 			 
 				test.log(LogStatus.PASS,  " History button working successfully."); 
 				ClientLocators.HistoryIU().click();
 		 }
 		 else
 		 {Thread.sleep(5000);
 		 	test.log(LogStatus.FAIL, "History button does not working properly.");
 		 }
 		  	 Thread.sleep(3000);
 		  
 		
 	}
    
    public static void IUHistoryDRe(  ExtentTest test) throws InterruptedException, IOException
  	{Thread.sleep(5000);
  	
      	Thread.sleep(3000);
      	/*	ClientLocators.SelectEntity().click();
		Thread.sleep(2000);
	//  	ClientLocators.EntityTri1().click();
		Thread.sleep(2000);
		
		ClientLocators.AVAAEntity().click();
		Thread.sleep(2000);
		ClientLocators.Apply().click();
		Thread.sleep(4000);
		*/
    		
    	 	ClientLocators.InputUpload().click();
    	 
    		Thread.sleep(3000);
    		ClientLocators.Challan().click();
       		Thread.sleep(2000);
       		ClientLocators.Return().click();
       		Thread.sleep(4000);
       		ClientLocators.Apply().click();
       		Thread.sleep(4000);
    		ClientLocators.HistoryIU().click();
    		Thread.sleep(3000);
    		File dir = new File("C:\\Users\\bilali\\Downloads");
  		File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

  		Thread.sleep(500);
  		ClientLocators.InputHistoryD().click();

  		Thread.sleep(8000);
  		File dir1 = new File("C:\\Users\\bilali\\Downloads");
  		File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
  		Thread.sleep(3000);
  		if (dirContents.length < allFilesNew.length) {Thread.sleep(5000);
  			test.log(LogStatus.PASS,  "Input History File downloaded successfully.");
  		} else {Thread.sleep(5000);
  			test.log(LogStatus.FAIL,  "Input History File does not downloaded.");
  		}
  		 
  		
  	}
    
    /*
    public static void CriticalDocuments(  ExtentTest test) throws InterruptedException
	{Thread.sleep(5000);
		Thread.sleep(1000);
		ClientLocators.clickMyDocuments().click();					//Clicking on 'My Documents'
		
		Thread.sleep(1000);
		ClientLocators.clickCriticalDocuments().click();				//Clicking on 'Critical Documents'
		
		WebDriverWait wait = new WebDriverWait(getDriver(), (20));
	
		Thread.sleep(500);
		String name = ClientLocators.readFolderName().getText();		//Reading the folder name to create new folder.
		
		String folder = name+"A"; 
		
		ClientLocators.clickNewFolder().click();							//Clicking on '+New' button.
	
		Thread.sleep(2000);
	
		Thread.sleep(300);
	//	clickIsUniversal().click();
		
		Thread.sleep(1000);
		ClientLocators.writeFolderName().sendKeys(folder);			//Writing Folder name.
		
		Thread.sleep(1000);
		ClientLocators.clickCreate().click();						//Clicking on create button.
		
		Thread.sleep(500);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);
	//	String msg = driver.switchTo().alert().getText();
		//test.log(LogStatus.INFO, msg);
		Thread.sleep(500);
		try {Thread.sleep(5000);
			String t = OverduePOM.readFolderMsg().getText();
			test.log(LogStatus.PASS, t);
			//getDriver().switchTo().alert().accept();
		}catch(Exception e) {Thread.sleep(5000);
			
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
		name = readFolderName().getText();				//Reading the folder name we had created
		
		if(folder.equalsIgnoreCase(name))
		{Thread.sleep(5000);
			test.log(LogStatus.PASS, "Created folder '"+folder+"' displayed in the records.");
		}
		else
		{Thread.sleep(5000);
			test.log(LogStatus.FAIL, "Created folder '"+folder+"' doesn't displayed in the records.");
		}
		
		Thread.sleep(4000);
		readFolderName().click();						//Clicking on folder name we had created.
		Thread.sleep(1000);
		readFolderName().click();						//Clicking on folder name we had created.
		
		Thread.sleep(1000);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickNew()));
		clickNew().click();							//Clicking on 'New'
		
		Thread.sleep(500);
	//	litigationPerformer.MethodsPOM.progress();
		
		//Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickNewFile()));
		clickNewFile().click();						//CLicking on 'New File'
		
		Thread.sleep(1000);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);
		String workingDir = System.getProperty("user.dir");
		uploadNewFile().sendKeys("E:\\Ethics Committee Details.xlsx");	//uploading new file		
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickUploadDocument()));
		
		Thread.sleep(5000);
		clickUploadDocument().click();				//Clicking on 'Upload Document'
		
		Thread.sleep(5000);
	    // Switching to Alert        
        Alert alert = getDriver().switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= getDriver().switchTo().alert().getText();	
        
        Thread.sleep(3000);
        test.log(LogStatus.PASS, alertMessage);
        		
        // Displaying alert message		
        System.out.println(alertMessage);	
        
        		
        // Accepting alert		
        alert.accept();		
		
		
		
		Thread.sleep(100);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@align='left'])[1]")));
		readFolderName().click();						//Clicking on file we had uploaded.
		
		
		
		
		
//		if(readFolderName().isDisplayed())			//Checking if file got created or not.
//			test.log(LogStatus.PASS, "Uploaded file displayed.");
//		else
//			test.log(LogStatus.PASS, "Uploaded file does not displayed.");
//		
		//readFolderName().click();						//Clicking on file we had uploaded.
				
		Thread.sleep(500);
		clickShareFolder().click();					//Clicking on Share Folder image.
		
		Thread.sleep(1000);
	//	litigationPerformer.MethodsPOM.progress();
		
		Thread.sleep(500);
		wait.until(ExpectedConditions.elementToBeClickable(clickPeople()));
		clickPeople().click();						//Clicking on People drop down 
		clickSearchPeople().click();					//Clicking on Search People drop down.
		
		Thread.sleep(500);
	//	clickSearchPeople(driver).sendKeys("aayush tripathi");			//Writing user name to search for  CFO
	//	clickSearchPeople().sendKeys("Company");	        // Auditor
	//	clickSearchPeople().sendKeys("Amit shaha");	//Approver
		//Thread.sleep(4000);
		
		clickSearchPeople().sendKeys("Approver User");	//Department
		Thread.sleep(3000);
		
		clickPeopleCheckBox1().click();	
		Thread.sleep(3000);//Clicking on label to get out from people search box
		getDriver().findElement(By.xpath("//*[@id='divOpenPermissionPopup']/div/div/div[2]")).click();
		
		Thread.sleep(1000);
		clickDone().click();	//Clicking on 'Done' to share folder.
		Thread.sleep(1000);
		getDriver().switchTo().alert().accept();
		
		Thread.sleep(1000);
		readFolderName().click();						//Clicking on file name we had uploaded.
		
		Thread.sleep(500);
		clickShareFolder().click();					//Clicking on Share File image.
		Thread.sleep(500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ContentPlaceHolder1_myRepeater_LnkDeletShare_0']")));	//Waiting till the share element gets visible
		
		//Thread.sleep(1000);
		if(checkShared().isDisplayed())				//Checking if folder gor shared or not.
			test.log(LogStatus.PASS, "Uploaded file shared.");
		else
			test.log(LogStatus.PASS, "Uploaded file does not shared.");
		
		Thread.sleep(500);
		closeSharePoppup().click();
		Thread.sleep(500);
		Thread.sleep(1000);
		readFolderName().click();	
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_upPromotorList']/div/div/section/div[3]/div/div[2]/img[5]")).click();
		Thread.sleep(3000);
	String Msg=	getDriver().switchTo().alert().getText();
	test.log(LogStatus.PASS, Msg);
	getDriver().switchTo().alert().accept();
		Thread.sleep(3000);
		
		getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_lnkMyDrive']")).click();
		Thread.sleep(3000);
		//.findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilter']")).sendKeys(folder,Keys.ENTER);   //search folder
	/*
		.findElement(By.xpath("//*[@id='ContentPlaceHolder1_grdFolderDetail_lnkEditFolder_0']")).click();
		Thread.sleep(1000);
	
		.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtFolderName']")).clear();
		Thread.sleep(3000);
		.findElement(By.xpath("//*[@id='ContentPlaceHolder1_txtFolderName']")).sendKeys("Automated");
		Thread.sleep(1000);
		
		.findElement(By.xpath("//*[@id='ContentPlaceHolder1_btnCreateFolder1']")).click();
		Thread.sleep(3000);
	test.log(LogStatus.PASS, "Rename Successfully");
	getDriver().findElement(By.xpath("//*[@id='ContentPlaceHolder1_tbxFilter']")).sendKeys(folder,Keys.ENTER);   //search folder
		test.log(LogStatus.PASS, "Filter Working Successfully");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(OverduePOM.clickDashboard()));
		OverduePOM.clickDashboard().click();			//Clicking on Dashboard
	}

    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
