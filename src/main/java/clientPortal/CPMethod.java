package clientPortal;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import login.BasePage;
import login.LoginLocators;

public class CPMethod extends BasePage{
	
    static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour.xlsx";

	
	public static void MultipleDocument( ExtentTest test) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(CPLocator.MyDocument()));	
		CPLocator.Entity().click();
		Thread.sleep(2000);
		CPLocator.EntityExpand().click();
		Thread.sleep(2000);
		CPLocator.checkbox().click();
		Thread.sleep(2000);		
		CPLocator.Applybtn().click();
		Thread.sleep(3000);
		CPLocator.MyDocument().click();
		Thread.sleep(2000);
		CPLocator.StaDocument().click();
		Thread.sleep(2000);
		CPLocator.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		CPLocator.Actfilter().click();
		Thread.sleep(2000);
		CPLocator.ClickAct().click();
		Thread.sleep(2000);
		CPLocator.Year().click();
		Thread.sleep(2000);
		LoginLocators.typeValueEPF().click();
		Thread.sleep(2000);
		CPLocator.Period().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod1().click();
		Thread.sleep(2000);
		CPLocator.branch().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue4().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(3000);
		CPLocator.CheckBox1().click();
		Thread.sleep(500);
		CPLocator.CheckBox2().click();
		Thread.sleep(500);
		CPLocator.CheckBox3().click();
		Thread.sleep(500);
		
		File dir2 = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(9000);
		CPLocator.Download().click();
		
	 	Thread.sleep(18000);
		File dir3 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
		
	   
        Thread.sleep(9000);
	   if (dirContents1.length < allFilesNew1.length) {
			test.log(LogStatus.PASS,  " Document Downloaded.");
		}
	   else
	   {
			test.log(LogStatus.FAIL, "Document Does Not Downloaded.");
		}		
	   Thread.sleep(5000);
		
		
		
	}
	
	public static void MyDocument( ExtentTest test) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(CPLocator.MyDocument()));	
		CPLocator.Entity().click();
		Thread.sleep(2000);
		CPLocator.EntityExpand().click();
		Thread.sleep(2000);
		CPLocator.checkbox().click();
		Thread.sleep(2000);		
		CPLocator.Applybtn().click();
		Thread.sleep(3000);
		CPLocator.MyDocument().click();
		Thread.sleep(2000);
		CPLocator.StaDocument().click();
		Thread.sleep(2000);
		CPLocator.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		CPLocator.Actfilter().click();
		Thread.sleep(2000);
		CPLocator.ClickAct().click();
		Thread.sleep(2000);
		CPLocator.Year().click();
		Thread.sleep(2000);
		LoginLocators.typeValueEPF().click();
		Thread.sleep(2000);
		CPLocator.Period().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod1().click();
		Thread.sleep(2000);
		CPLocator.branch().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue4().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(3000);
		
		File dir2 = new File("C:\\Users\\bilali\\Downloads");
		File[] dirContents1 = dir2.listFiles();						//Counting number of files in directory before download
		
		Thread.sleep(9000);
		CPLocator.Downloads().click();
		
	 	Thread.sleep(18000);
		File dir3 = new File("C:\\Users\\bilali\\Downloads");
		File[] allFilesNew1 = dir3.listFiles();						//Counting number of files in directory after download
		
	   
        Thread.sleep(9000);
	   if (dirContents1.length < allFilesNew1.length) {
			test.log(LogStatus.PASS,  " Document Downloaded.");
		}
	   else
	   {
			test.log(LogStatus.FAIL, "Document Does Not Downloaded.");
		}		
	   Thread.sleep(5000);
		
		
		
	}

	public static void MyDocumentView( ExtentTest test) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(CPLocator.MyDocument()));	
		CPLocator.Entity().click();
		Thread.sleep(2000);
		CPLocator.EntityExpand().click();
		Thread.sleep(2000);
		CPLocator.checkbox().click();
		Thread.sleep(2000);		
		CPLocator.Applybtn().click();
		Thread.sleep(3000);
		CPLocator.MyDocument().click();
		Thread.sleep(2000);
		CPLocator.StaDocument().click();
		Thread.sleep(2000);
		CPLocator.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		CPLocator.Actfilter().click();
		Thread.sleep(2000);
		CPLocator.ClickAct().click();
		Thread.sleep(2000);
		CPLocator.Year().click();
		Thread.sleep(2000);
		LoginLocators.typeValueEPF().click();
		Thread.sleep(2000);
		CPLocator.Period().click();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod1().click();
		Thread.sleep(2000);
		CPLocator.branch().click();
		Thread.sleep(2000);
		LoginLocators.branchvalue4().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(3000);
		CPLocator.View().click();
		Thread.sleep(3000);
		CPLocator.Viewed().click();
		Thread.sleep(3000);
		LoginLocators.CloseBranchCode().click();
		Thread.sleep(3000);
		test.log(LogStatus.PASS, "Document Viewed.");
		Thread.sleep(3000);
		LoginLocators.ClosePopup().click();
		
		
	}
	
	public static void MyDocumentFilter( ExtentTest test) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(CPLocator.MyDocument()));	
		CPLocator.Entity().click();
		Thread.sleep(2000);
		CPLocator.EntityExpand().click();
		Thread.sleep(2000);
		CPLocator.checkbox().click();
		Thread.sleep(2000);		
		CPLocator.Applybtn().click();
		Thread.sleep(3000);
		CPLocator.MyDocument().click();
		Thread.sleep(2000);
		CPLocator.StaDocument().click();
		Thread.sleep(2000);
		
		CPLocator.ComplianceDropdown().click();
		Thread.sleep(2000);
		LoginLocators.ClickRegister().click();
		Thread.sleep(2000);
		
		CPLocator.Actfilter().click();
		Thread.sleep(2000);
		CPLocator.ClickAct().click();
		Thread.sleep(2000);
		
		CPLocator.Year().click();
		Thread.sleep(2000);
		String year = LoginLocators.typeValueEPF().getText();
		LoginLocators.typeValueEPF().click();
		Thread.sleep(2000);
		
		CPLocator.Period().click();
		Thread.sleep(2000);
		String period = LoginLocators.ClickPeriod1().getText();
		Thread.sleep(2000);
		LoginLocators.ClickPeriod1().click();
		Thread.sleep(2000);
		
		
		CPLocator.branch().click();
		Thread.sleep(2000);		
		CPLocator.Expand().click();
		Thread.sleep(2000);
		String loc = CPLocator.Location().getText();
		Thread.sleep(500);
		CPLocator.Location().click();
		Thread.sleep(2000);
		LoginLocators.ApplyButton().click();
		Thread.sleep(3000);
      List<String> li=new ArrayList<String>();
      
      
      li.add(year);
      li.add(period);
      li.add(loc);
     
      
      Thread.sleep(3000);
      
		List<String> filter=new ArrayList<String>();	
		
		filter.add("Year");
		filter.add("Period");
		filter.add("Location");
		
		
		JavascriptExecutor j = (JavascriptExecutor) getDriver();
		j.executeScript("window.scrollBy(0,1000)");	
		Thread.sleep(3000);

		LoginLocators.TotalNumberOfItems().click();					//Clicking on Text of total items just to scroll down.
		String s = LoginLocators.TotalNumberOfItems().getText();
		Thread.sleep(2000);

		if(!s.equalsIgnoreCase("0 - 0 of 0 items")) {
		Thread.sleep(5000);
	
		List<WebElement> yearcol=getDriver().findElements(By.xpath("//td[7]"));
		List<WebElement> periodcol=getDriver().findElements(By.xpath("//td[6]"));
		List<WebElement> Loccol=getDriver().findElements(By.xpath("//td[4]"));
		
		Thread.sleep(2000);

		for(int i=0; i<li.size(); i++){
			
			List<String> text= new ArrayList<String>();
			HashSet<String> pass=new LinkedHashSet<>();
			HashSet<String> fail=new LinkedHashSet<>();
			List<WebElement> raw=new ArrayList<WebElement>();

				if(i==0)
				{
					raw.addAll(yearcol);
				}
			else if(i==1)
				{
					raw.addAll(periodcol);
				}
			else if(i==2)
			{
				raw.addAll(Loccol);
			}
				
				for(int k=0;k<raw.size();k++)
				{
					text.add(raw.get(k).getText());
				}
				for(int l=0;l<text.size();l++)
				{
					
					if(i==2)
					{
						if(text.get(l).equalsIgnoreCase("ANDHERI WEST_Andheriya")||text.get(l).equalsIgnoreCase("ANDHERI WEST"))
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

	public static void MyDocumentAllTab( ExtentTest test) throws InterruptedException, IOException, AWTException
	{
	
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(CPLocator.MyDocument()));
		CPLocator.Entity().click();
		Thread.sleep(2000);
		CPLocator.EntityExpand().click();
		Thread.sleep(2000);
		CPLocator.checkbox().click();
		Thread.sleep(2000);		
		CPLocator.Applybtn().click();
		Thread.sleep(3000);
		CPLocator.MyDocument().click();
		Thread.sleep(3000);
if(CPLocator.StaDocument().isDisplayed()&&CPLocator.MISDocument().isDisplayed()&&CPLocator.EmployeeESIC().isDisplayed()&&CPLocator.CriticalDocuments().isDisplayed()) {
		
		test.log(LogStatus.PASS, "The tab of Statutory Document, MIS Document, Employee ESIC and Critical Documents should be seen below the My document tab");
	}else {
		
		test.log(LogStatus.FAIL, "The tab of Statutory Document, MIS Document, Employee ESIC and Critical Documents should not seen below the My document tab");
		
	}
} 

	public static void CriticalDocument( ExtentTest test) throws InterruptedException, IOException, AWTException
	{
	
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
		Thread.sleep(3000);
		CPLocator.MyDocument().click();
		Thread.sleep(2000);
		CPLocator.CriticalDocuments().click();
		Thread.sleep(2000);
		CPLocator.NewFolder().click();
		Thread.sleep(2000);
		CPLocator.FolderName().sendKeys("Labor Doc Live");
		Thread.sleep(2000);
		CPLocator.Create().click();
		Thread.sleep(2000);
		String msg = LoginLocators.UploadSuccessfully().getText();
		   Thread.sleep(2000);
		   if(msg.equalsIgnoreCase("Folder Created Succesfully"))
		   {
			   test.log(LogStatus.PASS,  msg);
		   }
		   else {
			   test.log(LogStatus.FAIL,   msg);

		   }
		   LoginLocators.OK().click();
		   Thread.sleep(2000);
		   
		
		
		
	}
	
	public static void CriticalDocumentSubFolder( ExtentTest test) throws InterruptedException, IOException, AWTException
	{
	
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
		Thread.sleep(3000);
		CPLocator.MyDocument().click();
		Thread.sleep(2000);
		CPLocator.CriticalDocuments().click();
		Thread.sleep(2000);
		Actions actions = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.cssSelector("div[title='Labor Doc'] img[alt='Go to sub-folder']"));
        actions.doubleClick(element).perform();
		Thread.sleep(2000);
		CPLocator.NewFolder().click();
		Thread.sleep(2000);
		CPLocator.FolderName().sendKeys("Labor Document");
		Thread.sleep(2000);
		CPLocator.Create().click();
		Thread.sleep(2000);
		String msg = LoginLocators.UploadSuccessfully().getText();
		   Thread.sleep(2000);
		   if(msg.equalsIgnoreCase("Folder Created Succesfully"))
		   {
			   test.log(LogStatus.PASS,  msg);
		   }
		   else {
			   test.log(LogStatus.FAIL,   msg);

		   }
		   LoginLocators.OK().click();
		   Thread.sleep(2000);
		   
		
		
		
	}
	
	public static void CriticalDocumentNewFile( ExtentTest test) throws InterruptedException, IOException, AWTException
	{
	
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
		Thread.sleep(3000);
		CPLocator.MyDocument().click();
		Thread.sleep(2000);
		CPLocator.CriticalDocuments().click();
		Thread.sleep(2000);
		Actions actions = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath("(//img[@class='foldertogo ng-star-inserted'])[4]"));
        actions.doubleClick(element).perform();
		Thread.sleep(2000);
		CPLocator.NewFile().click();
		Thread.sleep(2000);
		LoginLocators.Browes().click();
		Thread.sleep(2000);
		
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
		
		LoginLocators.Uploadbtn().click();
		Thread.sleep(2000);
		
		String msg = LoginLocators.UploadSuccessfully().getText();
		   Thread.sleep(2000);
		   if(msg.equalsIgnoreCase("File Uploaded Successfully"))
		   {
			   test.log(LogStatus.PASS,  msg);
		   }
		   else {
			   test.log(LogStatus.FAIL,   msg);

		   }
		   LoginLocators.OK().click();
		   Thread.sleep(2000);
		   
		
		
		
	}
	
	
	public static void CriticalDocumentshare( ExtentTest test) throws InterruptedException, IOException, AWTException
	{
	
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
		Thread.sleep(3000);
		CPLocator.MyDocument().click();
		Thread.sleep(2000);
		CPLocator.CriticalDocuments().click();
		Thread.sleep(2000);
		CPLocator.Share().click();
		Thread.sleep(2000);
		CPLocator.PermissionSelect().click();
		Thread.sleep(2000);
		CPLocator.PermissionSelectValue().click();
		Thread.sleep(2000);
		CPLocator.SelectUser().click();
		Thread.sleep(2000);
		CPLocator.SelectUserVal().click();
		Thread.sleep(2000);
		CPLocator.Done().click();
		Thread.sleep(2000);
		
		String msg = LoginLocators.UploadSuccessfully().getText();
		   Thread.sleep(2000);
		   if(msg.equalsIgnoreCase("The Folder has been shared successfully!"))
		   {
			   test.log(LogStatus.PASS,  msg);
		   }
		   else {
			   test.log(LogStatus.FAIL,   msg);

		   }
		   LoginLocators.OK().click();
		   Thread.sleep(2000);
		   
		
		
		
	}

}
