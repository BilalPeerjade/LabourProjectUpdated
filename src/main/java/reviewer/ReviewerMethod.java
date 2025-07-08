package reviewer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import distributor.DistributerLocators;
import login.BasePage;
import login.LoginLocators;
import performer.PerformerLocator;




public class ReviewerMethod extends BasePage 
{
	
	 static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour2.xlsx";
	 
	 
	 public static void StatutoryDocApplyClaerBtn(ExtentTest test, String user) throws InterruptedException
		{
		 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
		 	Thread.sleep(1000);
			if(user.equalsIgnoreCase("Performer"))
			{
				LoginLocators.Search().sendKeys("TESTAUTO");
				Thread.sleep(5000);
				ReviwerLocator.clickWorkspaceArrow().click();
				Thread.sleep(1000);
			}
			else if(user.equalsIgnoreCase("Distributor"))
			{
				LoginLocators.Search().sendKeys("AVACORED5");	
			}
			else if(user.equalsIgnoreCase("Reviewer"))
			{
				LoginLocators.Search().sendKeys("TESTAUTO");
				Thread.sleep(4000);
				ReviwerLocator.clickStaturyDocumentArrow().click();
			}
	
		 	
			Thread.sleep(8000);
			Thread.sleep(2000);
			ReviwerLocator.clickStatutoryDoc().click();
			Thread.sleep(2000);
			ReviwerLocator.clickComplianceType().click();
			Thread.sleep(2000);
			ReviwerLocator.selectComplianceType1().click();
			Thread.sleep(2000);
			ReviwerLocator.clickAct2().click();
			Thread.sleep(2000);
			ReviwerLocator.selectComplianceType().click();
			Thread.sleep(2000);
			ReviwerLocator.clickYear().click();
			Thread.sleep(2000);
			ReviwerLocator.selectComplianceType1().click();
			Thread.sleep(2000);
			ReviwerLocator.clickPeriod().click();
			Thread.sleep(2000);
			ReviwerLocator.selectComplianceType2().click();
			Thread.sleep(2000);
			ReviwerLocator.clickComplianceStatus().click();
			Thread.sleep(2000);
			ReviwerLocator.selectComplianceType().click();
			Thread.sleep(2000);
			Thread.sleep(1000);
			ReviwerLocator.clickBranch1().click();
			
			Thread.sleep(2000);
			ReviwerLocator.clickcheckbox().click();
			
//			Thread.sleep(1000);
//			ReviwerLocator.clickBranchTiangle().click();
//			Thread.sleep(1000);
//			ReviwerLocator.selectBranch1().click();
			Thread.sleep(1000);
			if(ReviwerLocator.clickApply().isEnabled())
			{
				Thread.sleep(1000);
				ReviwerLocator.clickApply().click();
				test.log(LogStatus.PASS, "Apply button working successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Apply button working successfully");
			}
			
//			Thread.sleep(1000);
//			wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
			
			Thread.sleep(1000);
			if(ReviwerLocator.clickClearBtn().isEnabled())
			{
				Thread.sleep(10000);
				ReviwerLocator.clickClearBtn().click();
				test.log(LogStatus.PASS, "Clear button working successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Clear button not working successfully");
			}
			
			
			Thread.sleep(5000);
			ReviwerLocator.clickdashboard().click();
			}


public static void StatutoryDocFilter(ExtentTest test) throws InterruptedException
{
 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	Thread.sleep(1000);
	ReviwerLocator.SerchCustomer().sendKeys("AVAANGUL");
	Thread.sleep(8000);
	ReviwerLocator.clickStaturyDocumentArrow().click();
	Thread.sleep(2000);
	ReviwerLocator.clickStatutoryDoc().click();
	Thread.sleep(2000);
	ReviwerLocator.clickComplianceType().click();
	Thread.sleep(2000);
	if(ReviwerLocator.Dropdown().isDisplayed())
	{
		Thread.sleep(2000);
		ReviwerLocator.Dropdown().click();
		test.log(LogStatus.PASS, "Register', 'Return', 'Challan' value should reflect in dropdown.");
	}
	else
	{
		test.log(LogStatus.FAIL, "Register', 'Return', 'Challan' value should not reflect in dropdown.");
	}
	
	Thread.sleep(2000);
	ReviwerLocator.clickAct2().click();
	
	Thread.sleep(2000);
	if(ReviwerLocator.Dropdown().isDisplayed())
	{
		
		test.log(LogStatus.PASS, "Act' value's should reflect in dropdown.");
	}
	else
	{
		test.log(LogStatus.FAIL, "Act' value's should not reflect in dropdown.");
	}
	Thread.sleep(2000);
	ReviwerLocator.clickYear().click();
	
	Thread.sleep(2000);
	if(ReviwerLocator.Dropdown().isDisplayed())
	{
		
		test.log(LogStatus.PASS, "Year' value's should reflect in dropdown.");
	}
	else
	{
		test.log(LogStatus.FAIL, "Year' value's should not reflect in dropdown.");
	}
	Thread.sleep(2000);
	ReviwerLocator.clickPeriod().click();
	Thread.sleep(2000);
	if(ReviwerLocator.Dropdown().isDisplayed())
	{
		
		test.log(LogStatus.PASS, "Period' value's should reflect in dropdown.");
	}
	else
	{
		test.log(LogStatus.FAIL, "Period' value's should not reflect in dropdown.");
	}
	
	Thread.sleep(2000);
	ReviwerLocator.clickComplianceStatus().click();
	Thread.sleep(2000);
	if(ReviwerLocator.Dropdown().isDisplayed())
	{
		
		test.log(LogStatus.PASS, "Closed-Delayed', 'Closed-Timely', 'Pending for performer', 'Pending for Reviewer' and 'Rejected' values should reflect in dropdown.");
	}
	else
	{
		test.log(LogStatus.FAIL, "Closed-Delayed', 'Closed-Timely', 'Pending for performer', 'Pending for Reviewer' and 'Rejected' values not should reflect in dropdown.");
	}
	

	Thread.sleep(5000);
	ReviwerLocator.clickdashboard().click();
	
}
public static void StateDocZipFile(ExtentTest test, String user) throws InterruptedException
{
 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	Thread.sleep(5000);
	
	if(user.equalsIgnoreCase("Performer"))
	{
		LoginLocators.Search().sendKeys("TESTAUTO");
		Thread.sleep(8000);
		ReviwerLocator.clickWorkspaceArrow().click();
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		LoginLocators.Search().sendKeys("TESTAUTO");
		Thread.sleep(8000);
		ReviwerLocator.clickStaturyDocumentArrow().click();
	}
	
	
	Thread.sleep(8000);
	ReviwerLocator.clickStatutoryDoc().click();
	
	Thread.sleep(2000);
	ReviwerLocator.clickComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType1().click();
	Thread.sleep(2000);
	ReviwerLocator.clickAct2().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.clickYear().click();
	Thread.sleep(2000);
	ReviwerLocator.selectYear2024().click();
	Thread.sleep(2000);
	ReviwerLocator.clickPeriod().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.clickComplianceStatus().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.clickBranch1().click();
	Thread.sleep(2000);
	ReviwerLocator.clickcheckbox().click();
//	Thread.sleep(1000);
//	ReviwerLocator.clickBranchTiangle().click();
//	Thread.sleep(1000);
//	ReviwerLocator.selectBranch1().click();
	Thread.sleep(2000);
	ReviwerLocator.clickApply().click();
	
	

		Thread.sleep(9000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
	
		Thread.sleep(4000);
		ReviwerLocator.clickDownload().click();
		
//		Thread.sleep(1000);
//		wait.until(ExpectedConditions.invisibilityOf(ReviwerLocator.gridLoad1()));
		
	
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
				String msg1=ReviwerLocator.FileNotFound().getText();
				
				 if(msg1.equalsIgnoreCase("File Not Found"))
				 {
					 test.log(LogStatus.PASS, "Message displayed = "+msg1);
					 
				 }
				 else
				 {
					 test.log(LogStatus.FAIL, "Message displayed = "+msg1);
				 }
				 Thread.sleep(2000);
				 ReviwerLocator.clickOkBtn().click();
			}
	
	Thread.sleep(2000);
		ReviwerLocator.clickdashboard().click();
		
	}
public static void StateDownloadDoc(ExtentTest test, String user) throws InterruptedException
{
 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	Thread.sleep(5000);
	if(user.equalsIgnoreCase("Performer"))
	{
		Thread.sleep(5000);
		LoginLocators.Search().sendKeys("TESTAUTO");
		Thread.sleep(8000);
		ReviwerLocator.clickWorkspaceArrow().click();
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		Thread.sleep(5000);
		LoginLocators.Search().sendKeys("TESTAUTO");
		Thread.sleep(8000);
		ReviwerLocator.clickStaturyDocumentArrow().click();
	}
	
	
	Thread.sleep(8000);
	Thread.sleep(2000);
	ReviwerLocator.clickStatutoryDoc().click();
	Thread.sleep(2000);
	ReviwerLocator.clickBranchRadioBtn().click();
	Thread.sleep(2000);
	ReviwerLocator.clickComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType1().click();
	Thread.sleep(2000);
	ReviwerLocator.clickAct2().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.clickYear().click();
	Thread.sleep(2000);
	ReviwerLocator.selectYear2024().click();
	Thread.sleep(2000);
	ReviwerLocator.clickPeriod().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.clickComplianceStatus().click();
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.clickBranch1().click();
	ReviwerLocator.clickcheckbox().click();
//	Thread.sleep(1000);
//	ReviwerLocator.clickBranchTiangle().click();
//	Thread.sleep(1000);
//	ReviwerLocator.selectBranch1().click();
	Thread.sleep(2000);
	ReviwerLocator.clickApply().click();
	
	Thread.sleep(6000);
	ReviwerLocator.clickTriangleGrid().click();
	
	Thread.sleep(4000);
	ReviwerLocator.clickDownload1().click();

	//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
	Thread.sleep(11000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(4000);
	ReviwerLocator.clickDownload2().click();
	
	Thread.sleep(4000);
	ReviwerLocator.clickCloseBtn().click();
	
//	Thread.sleep(1000);
//	wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
	

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
	ReviwerLocator.clickdashboard().click();
	
}
public static void StatutoryDocZipFile(ExtentTest test, String user) throws InterruptedException
{
	 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
		Thread.sleep(5000);
		ReviwerLocator.SerchCustomer().sendKeys("TESTAUTO");
		getDriver().navigate().refresh();
		Thread.sleep(8000);
		
		if(user.equalsIgnoreCase("Performer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
			Thread.sleep(8000);
			ReviwerLocator.clickWorkspaceArrow().click();
		}
		else if(user.equalsIgnoreCase("Distributor"))
		{
			LoginLocators.Search().sendKeys("AVACORED5");	
		}
		else if(user.equalsIgnoreCase("Reviewer"))
		{
			LoginLocators.Search().sendKeys("TESTAUTO");
			Thread.sleep(8000);
			ReviwerLocator.clickStaturyDocumentArrow().click();
		}
		
		
		Thread.sleep(8000);
		Thread.sleep(2000);
		ReviwerLocator.clickStatutoryDoc().click();
		Thread.sleep(2000);
		ReviwerLocator.clickBranchRadioBtn().click();
		Thread.sleep(2000);
		ReviwerLocator.clickComplianceType().click();
		Thread.sleep(2000);
		ReviwerLocator.selectComplianceType1().click();
		Thread.sleep(2000);
		ReviwerLocator.clickAct2().click();
		Thread.sleep(2000);
		ReviwerLocator.selectComplianceType().click();
		Thread.sleep(2000);
		ReviwerLocator.clickYear().click();
		Thread.sleep(2000);
		ReviwerLocator.selectYear2024().click();
		Thread.sleep(2000);
		ReviwerLocator.clickPeriod().click();
		Thread.sleep(2000);
		ReviwerLocator.selectComplianceType().click();
		Thread.sleep(2000);
		ReviwerLocator.clickComplianceStatus().click();
		Thread.sleep(2000);
		ReviwerLocator.selectComplianceType().click();
		
		Thread.sleep(2000);
		ReviwerLocator.clickBranch1().click();
		
		Thread.sleep(2000);
		ReviwerLocator.clickcheckbox().click();
//		Thread.sleep(1000);
//		ReviwerLocator.clickBranchTiangle().click();
//		Thread.sleep(1000);
//		ReviwerLocator.selectBranch1().click();
		Thread.sleep(2000);
		ReviwerLocator.clickApply().click();
		
	
		//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
		Thread.sleep(9000);
		File dir = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 
	
		Thread.sleep(4000);
		ReviwerLocator.clickDownload().click();
		
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
				Thread.sleep(9000);
				test.log(LogStatus.FAIL, "zip file should not get downloaded..");
			}
		Thread.sleep(5000);
		ReviwerLocator.clickdashboard().click();
			
	
	
}
public static void StatutoryDocDownloadDoc(ExtentTest test) throws InterruptedException
{
 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	Thread.sleep(5000);
	ReviwerLocator.SerchCustomer().sendKeys("TESTAUTO");
	Thread.sleep(8000);
	
	
	
	
	ReviwerLocator.clickStaturyDocumentArrow().click();
	Thread.sleep(2000);
	ReviwerLocator.clickStatutoryDoc().click();
	Thread.sleep(2000);
	ReviwerLocator.clickBranchRadioBtn().click();
	Thread.sleep(2000);
	ReviwerLocator.clickComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType1().click();
	Thread.sleep(2000);
	ReviwerLocator.clickAct2().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.clickYear().click();
	Thread.sleep(2000);
	ReviwerLocator.selectYear2024().click();
	Thread.sleep(2000);
	ReviwerLocator.clickPeriod().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.clickComplianceStatus().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType().click();
	
	Thread.sleep(2000);
	ReviwerLocator.clickBranch1().click();
	ReviwerLocator.clickcheckbox().click();
//	Thread.sleep(1000);
//	ReviwerLocator.clickBranchTiangle().click();
//	Thread.sleep(1000);
//	ReviwerLocator.selectBranch1().click();
	Thread.sleep(2000);
	ReviwerLocator.clickApply().click();
	
	Thread.sleep(2000);
	ReviwerLocator.clickTriangleGrid().click();
	
	Thread.sleep(4000);
	ReviwerLocator.clickDownload1().click();

	//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
	Thread.sleep(11000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(4000);
	ReviwerLocator.clickDownload2().click();
	
	Thread.sleep(4000);
	ReviwerLocator.clickCloseBtn().click();
	
//	Thread.sleep(1000);
//	wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
	

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
	ReviwerLocator.clickdashboard().click();
	
}
public static void ChallanDocDownload(ExtentTest test) throws InterruptedException
{
	Thread.sleep(3000);
	ReviwerLocator.SerchCustomer().sendKeys("TESTAUTO");
	Thread.sleep(8000);
	ReviwerLocator.clickStaturyDocumentArrow().click();
	Thread.sleep(2000);
	ReviwerLocator.clickStatutoryDoc().click();
	//ReviwerLocator.clickBranchRadioBtn().click();
	Thread.sleep(2000);
	ReviwerLocator.clickComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.clickAct2().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType4().click();
	Thread.sleep(2000);
	ReviwerLocator.clickYear().click();
	Thread.sleep(2000);
	ReviwerLocator.selectYear2024().click();
	Thread.sleep(2000);
	ReviwerLocator.clickPeriod().click();
	
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.clickComplianceStatus().click();
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.clickBranch1().click();
	ReviwerLocator.clickcheckbox().click();
//	Thread.sleep(1000);
//	ReviwerLocator.clickBranchTiangle().click();
//	Thread.sleep(1000);
//	ReviwerLocator.selectBranch1().click();
	Thread.sleep(1000);
	ReviwerLocator.clickApply().click();
	
	Thread.sleep(4000);
	ReviwerLocator.clickDownload().click();

	//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
	Thread.sleep(11000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(4000);
	ReviwerLocator.clickDownload2().click();
	
	Thread.sleep(4000);
	ReviwerLocator.clickCloseBtn().click();
	
//	Thread.sleep(1000);
//	wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
	

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
	ReviwerLocator.clickdashboard().click();
	
}
public static void ChallanDocViewandOverview(ExtentTest test) throws InterruptedException
{
	Thread.sleep(3000);
	ReviwerLocator.SerchCustomer().sendKeys("TESTAUTO");
	Thread.sleep(8000);
	ReviwerLocator.clickStaturyDocumentArrow().click();
	Thread.sleep(2000);
	ReviwerLocator.clickStatutoryDoc().click();
	Thread.sleep(2000);
	//ReviwerLocator.clickBranchRadioBtn().click();
	ReviwerLocator.clickComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.clickAct2().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType4().click();
	Thread.sleep(2000);
	ReviwerLocator.clickYear().click();
	Thread.sleep(2000);
	ReviwerLocator.selectYear2024().click();
	Thread.sleep(2000);
	ReviwerLocator.clickPeriod().click();
	Thread.sleep(1000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(1000);
	ReviwerLocator.clickComplianceStatus().click();
	Thread.sleep(1000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(1000);
	ReviwerLocator.clickBranch1().click();
	Thread.sleep(1000);
	ReviwerLocator.clickcheckbox().click();
//	Thread.sleep(1000);
//	ReviwerLocator.clickBranchTiangle().click();
//	Thread.sleep(1000);
//	ReviwerLocator.selectBranch1().click();
	Thread.sleep(1000);
	ReviwerLocator.clickApply().click();
//	Thread.sleep(1000);
//	Locator.clickTriangleGrid().click();

	Thread.sleep(1000);
	ReviwerLocator.clickview().click();
	
	Thread.sleep(1000);
	ReviwerLocator.clickview1().click();
	Thread.sleep(3000);
	String msg=ReviwerLocator.viewPopup().getText();
	if(msg.equalsIgnoreCase("Document Viewer"))
	{
		test.log(LogStatus.PASS, "View Popup open successfully:-"+msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "View Popup does not open successfully:-"+msg);
	}
	Thread.sleep(3000);
	ReviwerLocator.clickCloseBtn1().click();
	Thread.sleep(3000);
	ReviwerLocator.clickCloseBtn().click();
	
	Thread.sleep(9000);
	ReviwerLocator.clickOverview().click();
	
	Thread.sleep(1000);
	String msg1=ReviwerLocator.OverviewPopup().getText();
	if(msg1.equalsIgnoreCase("Compliance Overview"))
	{
		test.log(LogStatus.PASS, "Overview Popup open successfully:-"+msg1);
	}
	else
	{
		test.log(LogStatus.FAIL, "Overview Popup does not open successfully:-"+msg1);
	}
	Thread.sleep(1000);
	ReviwerLocator.clickCloseBtn().click();
	
	Thread.sleep(5000);
	ReviwerLocator.clickdashboard().click();
}

public static void ChallanComplianceDocViewandOverview(ExtentTest test) throws InterruptedException
	{
	Thread.sleep(3000);
	ReviwerLocator.SerchCustomer().sendKeys("TESTAUTO");
	Thread.sleep(8000);
	ReviwerLocator.clickStaturyDocumentArrow().click();
	Thread.sleep(2000);
	ReviwerLocator.clickStatutoryDoc().click();
	Thread.sleep(1000);
	ReviwerLocator.clickComplianceRadioBtn().click();
	Thread.sleep(1000);
	ReviwerLocator.clickComplianceType().click();
	Thread.sleep(1000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(1000);
	ReviwerLocator.clickAct2().click();
	Thread.sleep(1000);
	ReviwerLocator.selectComplianceType4().click();
	Thread.sleep(1000);
	ReviwerLocator.clickYear().click();
	Thread.sleep(1000);
	ReviwerLocator.selectYear2024().click();
	Thread.sleep(1000);
	ReviwerLocator.clickPeriod().click();
	Thread.sleep(1000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(1000);
	ReviwerLocator.clickComplianceStatus().click();
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(1000);
	ReviwerLocator.clickBranch1().click();
	Thread.sleep(1000);
	ReviwerLocator.clickcheckbox().click();
	//Thread.sleep(1000);
	//ReviwerLocator.clickBranchTiangle().click();
	//Thread.sleep(1000);
	//ReviwerLocator.selectBranch1().click();
	Thread.sleep(1000);
	ReviwerLocator.clickApply().click();


	Thread.sleep(1000);
	ReviwerLocator.clickview().click();
	
	Thread.sleep(1000);
	ReviwerLocator.clickview1().click();
	Thread.sleep(3000);
	String msg=ReviwerLocator.viewPopup().getText();
	if(msg.equalsIgnoreCase("Document Viewer"))
	{
		test.log(LogStatus.PASS, "View Popup open successfully:-"+msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "View Popup does not open successfully:-"+msg);
	}
	Thread.sleep(3000);
	ReviwerLocator.clickCloseBtn1().click();
	Thread.sleep(1000);
	ReviwerLocator.clickCloseBtn().click();
	
	Thread.sleep(9000);
	ReviwerLocator.clickOverview().click();
	
	Thread.sleep(1000);
	String msg1=ReviwerLocator.OverviewPopup().getText();
	if(msg1.equalsIgnoreCase("Compliance Overview"))
	{
		test.log(LogStatus.PASS, "Overview Popup open successfully:-"+msg1);
	}
	else
	{
		test.log(LogStatus.FAIL, "Overview Popup does not open successfully:-"+msg1);
	}
	Thread.sleep(9000);
	ReviwerLocator.clickCloseBtn().click();
	
	Thread.sleep(5000);
	ReviwerLocator.clickdashboard().click();
}

public static void ChallanComplianceDocDownload(ExtentTest test) throws InterruptedException
{
	Thread.sleep(3000);
	ReviwerLocator.SerchCustomer().sendKeys("TESTAUTO");
	Thread.sleep(8000);
	ReviwerLocator.clickStaturyDocumentArrow().click();
	Thread.sleep(2000);
	ReviwerLocator.clickStatutoryDoc().click();
	Thread.sleep(1000);
	ReviwerLocator.clickComplianceRadioBtn().click();
	Thread.sleep(1000);
	ReviwerLocator.clickComplianceType().click();
	Thread.sleep(1000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(1000);
	ReviwerLocator.clickAct2().click();
	Thread.sleep(1000);
	ReviwerLocator.selectComplianceType4().click();
	Thread.sleep(1000);
	ReviwerLocator.clickYear().click();
	Thread.sleep(1000);
	ReviwerLocator.selectYear2024().click();
	Thread.sleep(1000);
	ReviwerLocator.clickPeriod().click();
	Thread.sleep(1000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(1000);
	ReviwerLocator.clickComplianceStatus().click();
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(1000);
	ReviwerLocator.clickBranch1().click();
	ReviwerLocator.clickcheckbox().click();
//	Thread.sleep(1000);
//	ReviwerLocator.clickBranchTiangle().click();
//	Thread.sleep(1000);
//	ReviwerLocator.selectBranch1().click();
	Thread.sleep(1000);
	ReviwerLocator.clickApply().click();
	
	Thread.sleep(4000);
	ReviwerLocator.clickDownload().click();

	//String FilePath= "C:\\Users\\bilali\\Downloads\\AVAAEntity_2024_SEA_MAH_BranchNashik.zip";
	Thread.sleep(11000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(4000);
	ReviwerLocator.clickDownload2().click();
	
	Thread.sleep(4000);
	ReviwerLocator.clickCloseBtn().click();
	
//	Thread.sleep(1000);
//	wait.until(ExpectedConditions.invisibilityOf(Locator.gridLoad1()));
	

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
	ReviwerLocator.clickdashboard().click();
	
}
public static void StatutoryDocViewandOverview(ExtentTest test, String user) throws InterruptedException
{
 	WebDriverWait wait=new WebDriverWait(getDriver(),20);
	Thread.sleep(5000);
	ReviwerLocator.SerchCustomer().sendKeys("TESTAUTO");
	getDriver().navigate().refresh();
	Thread.sleep(8000);
	
	if(user.equalsIgnoreCase("Performer"))
	{
		Thread.sleep(8000);
		LoginLocators.Search().sendKeys("TESTAUTO");
		Thread.sleep(8000);
		ReviwerLocator.clickWorkspaceArrow().click();
	}
	else if(user.equalsIgnoreCase("Distributor"))
	{
		LoginLocators.Search().sendKeys("AVACORED5");	
	}
	else if(user.equalsIgnoreCase("Reviewer"))
	{
		Thread.sleep(8000);
		LoginLocators.Search().sendKeys("TESTAUTO");
		Thread.sleep(8000);
		ReviwerLocator.clickStaturyDocumentArrow().click();
	}
	
	Thread.sleep(8000);
	Thread.sleep(3000);
	ReviwerLocator.clickStatutoryDoc().click();
	
	Thread.sleep(2000);
	ReviwerLocator.clickComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType1().click();
	Thread.sleep(2000);
	ReviwerLocator.clickAct2().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.clickYear().click();
	Thread.sleep(2000);
	ReviwerLocator.selectYear2024().click();
	Thread.sleep(2000);
	ReviwerLocator.clickPeriod().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType().click();
	Thread.sleep(2000);
	ReviwerLocator.clickComplianceStatus().click();
	Thread.sleep(2000);
	ReviwerLocator.selectComplianceType().click();
	
	Thread.sleep(2000);
	ReviwerLocator.clickBranch1().click();
	ReviwerLocator.clickcheckbox().click();
//	Thread.sleep(1000);
//	ReviwerLocator.clickBranchTiangle().click();
//	Thread.sleep(1000);
//	ReviwerLocator.selectBranch1().click();
	Thread.sleep(2000);
	ReviwerLocator.clickApply().click();
	Thread.sleep(2000);
	ReviwerLocator.clickTriangleGrid().click();

	Thread.sleep(2000);
	ReviwerLocator.clickview().click();
	
	Thread.sleep(2000);
	ReviwerLocator.clickview1().click();
	Thread.sleep(3000);
	String msg=ReviwerLocator.viewPopup().getText();
	if(msg.equalsIgnoreCase("Document Viewer"))
	{
		test.log(LogStatus.PASS, "View Popup open successfully:-"+msg);
	}
	else
	{
		test.log(LogStatus.FAIL, "View Popup does not open successfully:-"+msg);
	}
	Thread.sleep(3000);
	ReviwerLocator.clickCloseBtn1().click();
	Thread.sleep(2000);
	ReviwerLocator.clickCloseBtn().click();
	
	Thread.sleep(9000);
	ReviwerLocator.clickOverview().click();
	
	Thread.sleep(2000);
	String msg1=ReviwerLocator.OverviewPopup().getText();
	if(msg1.equalsIgnoreCase("Compliance Overview"))
	{
		test.log(LogStatus.PASS, "Overview Popup open successfully:-"+msg1);
	}
	else
	{
		test.log(LogStatus.FAIL, "Overview Popup does not open successfully:-"+msg1);
	}
	Thread.sleep(20000);
	Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOf(ReviwerLocator.clickCloseBtn()));
	ReviwerLocator.clickCloseBtn().click();
	
	Thread.sleep(5000);
	ReviwerLocator.clickdashboard().click();
}

public static void OnBoardEntityExport( ExtentTest test) throws InterruptedException, IOException, AWTException
{
 	
 	Thread.sleep(2000);
	ReviwerLocator.SerchCustomer().sendKeys("AVACORED5");
	Thread.sleep(8000);
	ReviwerLocator.clickStaturyDocumentArrow().click();
	Thread.sleep(7000);
	ReviwerLocator.clickOnboardEntity().click();
	

	Thread.sleep(2000);
	File dir = new File("C:\\Users\\bilali\\Downloads");
	File[] dirContents = dir.listFiles();							//Counting number of files in directory before download 

	Thread.sleep(2000);
	ReviwerLocator.clickExportOnboardEntity().click();
	

	Thread.sleep(10000);
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
public static void UploadSealandSignature( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
{
	
	Thread.sleep(1000);
	ReviwerLocator.SerchCustomer().sendKeys("AVACORED5");

	Thread.sleep(1000);
	ReviwerLocator.clickDashboard().click();
	Thread.sleep(6000);
	ReviwerLocator.clickManageMaster().click();
	
	Thread.sleep(1000);
	ReviwerLocator.clickSealandSignatureBtn().click();
	
	 Thread.sleep(1000);
	 ReviwerLocator.clickBrowse1().click();
		
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
	     ReviwerLocator.clickUploadbtnCTCBtn().click();
		
		Thread.sleep(2000);
		String msg=ReviwerLocator.clickMsg().getText();
		
		 if(msg.equalsIgnoreCase("File uploaded successfully"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg);
		 }
		 Thread.sleep(1000);
		 ReviwerLocator.clickOkBtn().click();
		
		Thread.sleep(1000);
		ReviwerLocator.clickcloseBtn().click();
		Thread.sleep(1000);
		ReviwerLocator.clickdashboard().click();
	
	
}
public static void AddDesignation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
{
	
	Thread.sleep(1000);
	ReviwerLocator.SerchCustomer().sendKeys("AVACORED5");
	Thread.sleep(1000);
	ReviwerLocator.clickDashboard().click();
	Thread.sleep(5000);
	ReviwerLocator.clickManageMaster().click();
	Thread.sleep(1000);
	ReviwerLocator.clickDesignation().click();
	Thread.sleep(1000);
	ReviwerLocator.clickAddNewDesignation().click();
	
	FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook1 = WorkbookFactory.create(fis);
    Sheet sheet = workbook1.getSheetAt(0);
	
	Thread.sleep(1000);
	Row row = sheet.getRow(9);						//Selected 0th index row (First row)
	Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
	String designation = c.getStringCellValue();
	ReviwerLocator.enterDesignation().sendKeys(designation);
	
	Thread.sleep(1000);
	
	ReviwerLocator.clicksave().click();
	
	 Thread.sleep(500);
	  String msg=ReviwerLocator.clickMsg().getText();		//Reading Message appeared after save button
	  
	  if(msg.equalsIgnoreCase("Designation Added Successfully"))
	 {
		 test.log(LogStatus.PASS, "Message displayed = "+msg);
		 
	 }
	 else
	 {
		 test.log(LogStatus.FAIL, "Message displayed = "+msg);
	 }
	  
	  Thread.sleep(1000);
	  ReviwerLocator.clickOkBtn().click();
	}
public static void DuplicateDesignation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
{
	
	Thread.sleep(1000);
	ReviwerLocator.SerchCustomer().sendKeys("AVACORED5");
	Thread.sleep(8000);
	ReviwerLocator.clickStaturyDocumentArrow().click();
	Thread.sleep(7000);
	ReviwerLocator.clickManageMaster().click();
	Thread.sleep(1000);
	ReviwerLocator.clickDesignation().click();
	Thread.sleep(1000);
	ReviwerLocator.clickAddNewDesignation().click();
	
	FileInputStream fis = new FileInputStream(filePath);
    Workbook workbook1 = WorkbookFactory.create(fis);
    Sheet sheet = workbook1.getSheetAt(0);
	
	Thread.sleep(1000);
	Row row = sheet.getRow(9);						//Selected 0th index row (First row)
	Cell c = row.getCell(1);						//Selected cell (0 row,1 column)
//	String designation = c.getStringCellValue();
//	ReviwerLocator.enterDesignation().sendKeys(designation);
	ReviwerLocator.enterDesignation().sendKeys("EXECUTIVE ADMINISTRATION");
	
	Thread.sleep(1000);
	
	ReviwerLocator.clicksave().click();
	
	 Thread.sleep(500);
	  String msg=ReviwerLocator.clickMsg().getText();		//Reading Message appeared after save button
	  
	  if(msg.equalsIgnoreCase("Designation is already exists."))
	 {
		 test.log(LogStatus.PASS, "Message displayed = "+msg);
		 
	 }
	 else
	 {
		 test.log(LogStatus.FAIL, "Message displayed = "+msg);
	 }
	  
	  Thread.sleep(1000);
	  ReviwerLocator.clickOkBtn().click();
	}
public static void DesignationExportBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
{
	
	Thread.sleep(1000);
	ReviwerLocator.SerchCustomer().sendKeys("AVACORED5");
	Thread.sleep(1000);
	ReviwerLocator.clickStaturyDocumentArrow().click();
	Thread.sleep(7000);
	ReviwerLocator.clickManageMaster().click();
	Thread.sleep(2000);
	ReviwerLocator.clickDesignation().click();
	Thread.sleep(2000);
	ReviwerLocator.clickDesignation().click();
	
	
	Thread.sleep(3000);		
	JavascriptExecutor js = (JavascriptExecutor) getDriver() ;
	
    
    js.executeScript("window.scrollBy(0,500)");
    Thread.sleep(2000); 		
    ReviwerLocator.readTotalItemDesignation().click();
	String item = ReviwerLocator.readTotalItemDesignation().getText();
	String[] bits = item.split(" ");								//Splitting the String
	String compliancesCount = bits[bits.length - 2];				//Getting the second last word (total number of users)
	int count1 = Integer.parseInt(compliancesCount);

	if(compliancesCount.equalsIgnoreCase("to"))
	{
		Thread.sleep(5000);
	   item = ReviwerLocator.readTotalItemDesignation().getText();
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
	ReviwerLocator.clickExportBtn().click();
	
	WebDriverWait wait=new WebDriverWait(getDriver(), 30);
//	wait.until(ExpectedConditions.invisibilityOf(ReviwerLocator.clickApply()));
	
	Thread.sleep(60000);
	js1.executeScript("window.scrollBy(0, 500)");


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
	ReviwerLocator.SerchCustomer().sendKeys("AVACORED5");
	Thread.sleep(1000);
	ReviwerLocator.clickDashboard().click();
	Thread.sleep(6000);
	ReviwerLocator.clickManageMaster().click();
	Thread.sleep(1000);
	ReviwerLocator.clickDesignation().click();
	
	Thread.sleep(1000);
	ReviwerLocator.clickUploadBtn().click();
	
	
		
		 Thread.sleep(1000);
		 ReviwerLocator.clickBrowse1().click();
			
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
		     ReviwerLocator.clickUploadbtnCTCBtn().click();
			
			Thread.sleep(2000);
			String msg=ReviwerLocator.clickMsg().getText();
			
			 if(msg.equalsIgnoreCase("File uploaded successfully"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			 ReviwerLocator.clickOkBtn().click();
			
//			Thread.sleep(1000);
//			ReviwerLocator.clickcloseBtn().click();
			Thread.sleep(1000);
			ReviwerLocator.clickdashboard().click();
		
		
	
	}
public static void BulkUploadDesignationDetailes( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException, AWTException
{
	
	Thread.sleep(3000);
	ReviwerLocator.SerchCustomer().sendKeys("AVACORED5");
	Thread.sleep(4000);
	ReviwerLocator.clickStaturyDocumentArrow().click();
	Thread.sleep(6000);
	ReviwerLocator.clickManageMaster().click();
	Thread.sleep(1000);
	ReviwerLocator.clickDesignation().click();
	Thread.sleep(8000);
	ReviwerLocator.clickUploadBtn().click();
	Thread.sleep(1000);
	ReviwerLocator.UploadDesignationDetailes().click();
	
		
		 Thread.sleep(1000);
		 ReviwerLocator.clickBrowse1().click();
			
			 Robot robot=new Robot();
			 
			 StringSelection filepath= new  StringSelection("D:\\Upload Automation Files\\OtherTwo\\DesignationSample.xlsx");
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
		     ReviwerLocator.clickUploadbtnCTCBtn().click();
			
			Thread.sleep(2000);
			String msg=ReviwerLocator.clickMsg().getText();
			
			 if(msg.equalsIgnoreCase("File uploaded successfully"))
			 {
				 test.log(LogStatus.PASS, "Message displayed = "+msg);
				 
			 }
			 else
			 {
				 test.log(LogStatus.FAIL, "Message displayed = "+msg);
			 }
			 Thread.sleep(1000);
			 ReviwerLocator.clickOkBtn().click();
			

//				 * Thread.sleep(1000); Distr
//				 */ubutorLocators.clickcloseBtn().click();
			Thread.sleep(1000);
			ReviwerLocator.clickdashboard().click();
		
		
	
	}

public static void DeleteDesignation( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
{
	
	Thread.sleep(4000);
	ReviwerLocator.SerchCustomer().sendKeys("AVACORED5");
	Thread.sleep(4000);
	ReviwerLocator.clickStaturyDocumentArrow().click();
	Thread.sleep(7000);
	ReviwerLocator.clickManageMaster().click();
	Thread.sleep(4000);
	ReviwerLocator.clickDesignation().click();
	Thread.sleep(4000);
	
	
	//Locators coming from performer 
 	Thread.sleep(7000);
 	PerformerLocator.DesignationSerach().sendKeys("abcdefghijklmnopqrstuvwxyz");
 	Thread.sleep(7000);
	
 	getDriver().findElement(By.xpath("(//span[@class='k-list-item-text'])[1]")).click();
	
 	PerformerLocator.clickApply().click();
	
	
	
	ReviwerLocator.clickDeleteBtn().click();
	
	getDriver().findElement(By.xpath("//button[@title='OK']")).click();
	
	
	
	Thread.sleep(3000);
//	  String msg=ReviwerLocator.clickDeletemsg().getText();		//Reading Message appeared after save button
	  
	  String msg=ReviwerLocator.clickMsg().getText();
	  if(msg.equalsIgnoreCase("Designation Inactivated Successfully") || 
		 msg.equalsIgnoreCase("Are you sure you want to inactive this record?"))
	 {
		 test.log(LogStatus.PASS, "Message displayed = "+msg);
		 
	 }
	 else
	 {
		 test.log(LogStatus.FAIL, "Message displayed = "+msg);
	 }
	
	 Thread.sleep(1000);
	 ReviwerLocator.clickOkBtn().click();
/*		
		Thread.sleep(500);
	//	  String msg1=ReviwerLocator.clickDeletemsg1().getText();		//Reading Message appeared after save button
		  
		  String msg1=ReviwerLocator.clickMsg().getText();
		  
		  if(msg1.equalsIgnoreCase("Data Deleted Successfully"))
		 {
			 test.log(LogStatus.PASS, "Message displayed = "+msg1);
			 
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Message displayed = "+msg1);
		 }
	 Thread.sleep(1000);
	 ReviwerLocator.clickOkBtn().click(); */
	
}
public static void DesignationClearBtn( ExtentTest test,XSSFWorkbook workbook) throws InterruptedException, IOException
{
	
	Thread.sleep(1000);
	ReviwerLocator.SerchCustomer().sendKeys("AVACORED5");
	Thread.sleep(1000);
	ReviwerLocator.clickDashboard().click();
	Thread.sleep(7000);
	ReviwerLocator.clickManageMaster().click();
	Thread.sleep(1000);
	ReviwerLocator.clickDesignation().click();
	
	Thread.sleep(1000);
	ReviwerLocator.clickstatus().click();
	Thread.sleep(1000);
	ReviwerLocator.selectstatus().click();
	

	Thread.sleep(2000);
	if(ReviwerLocator.clickclearBtn().isEnabled())
	{
		Thread.sleep(2000);
		ReviwerLocator.clickclearBtn().click();
		 test.log(LogStatus.PASS, "clear button Work Successfully");
	}
	else
	{
		test.log(LogStatus.FAIL, "clear button not Work Successfully");
	}
	Thread.sleep(2000);
	ReviwerLocator.clickdashboard().click();
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