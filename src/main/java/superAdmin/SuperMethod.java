package superAdmin;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import distributor.Locators;
import login.BasePage;

public class SuperMethod extends BasePage{
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	 static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour1.xlsx";

	 
	 public static void regionalDownload ( ExtentTest test) throws InterruptedException, IOException, AWTException
		{		
			Actions action = new Actions(getDriver());
			WebDriverWait wait = new WebDriverWait( getDriver(), (40));
			Thread.sleep(3000);
		    
					Thread.sleep(3000);
					SuperLocators.SelectState().click();
					Thread.sleep(3000);
					SuperLocators.SelectState1().click();
					Thread.sleep(3000);
					
					SuperLocators.SelectAct().click();
					Thread.sleep(3000);
					SuperLocators.SelectAct1().click();
					Thread.sleep(4000);
			
			
			Thread.sleep(3000);
			File dir = new File("C:\\Users\\bilali\\Downloads");
			File[] dirContents = dir.listFiles(); // Counting number of files in directory before download

			Thread.sleep(500);
			SuperLocators.regionalDownload().click();

			Thread.sleep(8000);
			File dir1 = new File("C:\\Users\\bilali\\Downloads");
			File[] allFilesNew = dir1.listFiles(); // Counting number of files in directory after download
			Thread.sleep(3000);
			if (dirContents.length < allFilesNew.length) {
				test.log(LogStatus.PASS,  " RegionalFile downloaded successfully.");
			} else {
				test.log(LogStatus.FAIL,  "Regional File does not downloaded.");
			}
			

			Thread.sleep(3000);
			
		}
	 
	 
}
