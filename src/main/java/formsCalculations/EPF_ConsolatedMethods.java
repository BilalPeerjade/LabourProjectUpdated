package formsCalculations;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import businessTestCases.UtilisOne;
import businessTestCases.Utilis3;
import businessTestCases.FilePath;
import login.BasePage;
import login.LoginLocators;
import performer.PerformerLocator;
import rcp.OneCommonMethod;
import utils.DownloadHelper;
import utils.ExcelExtraConfig;
import utils.ExcelFileDetails;
import utils.ExcelF;
import utils.ExcelTargetValidation;
import utils.ExcelUtils;
import utils.FileSearchHelper;
import utils.HTMLBuilder;




public class EPF_ConsolatedMethods extends BasePage {

	static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour.xlsx";
	
	public static File downloadedExcelFile; // shared file for all test cases
	public static File testFile; //for folder

	
	public static String masterFilePath = "D:\\Upload Automation Files\\BusinessScenarios\\Month\\EmployeeMaster_TESTAUTO.xlsx";
	
		
//	public static String salaryFile = "D:\\Upload Automation Files\\BusinessScenarios\\DOCAUTOO4\\#1 Aug2025\\Sample_challansalary3.xlsx";
	
//	String file = FilePath.salaryFile;
	
	
	
	public static String salaryFileTESTAUTO = "D:\\Upload Automation Files\\BusinessScenarios\\Month\\SampleSalary_TESTAUTO.xlsx";
	
	public static final boolean ENABLE_HTML_REPORT_TABLE = true; // HTML Report toggle
	
	
	
	
	
	
	
	
	
	public static void EPF_Consolated_Redirection( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
//		if(user.equalsIgnoreCase("Performer"))
//		{
//			LoginLocators.Search().sendKeys("TESTAUTO");
//			OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO");
//		}
//		else if(user.equalsIgnoreCase("Distributor"))
//		{
//			LoginLocators.Search().sendKeys("AVACORED5");	
//		}
//		else if(user.equalsIgnoreCase("Reviewer"))
//		{
//			LoginLocators.Search().sendKeys("AVACORED5");	
//		}
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO");
		
	  //	Report Generated Time:
	//		String runTime = new SimpleDateFormat("EEEE, MMMM dd, yyyy, hh:mm a z").format(new Date());
//		    String runTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
//			test.log(LogStatus.INFO, "📆 Report Generated: <b>" + runTime + "</b>");
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		PerformerLocator.clickStatutoryDoc().click();
		Thread.sleep(2000);
		PerformerLocator.clickComplianceType().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceChallan().click();
		Thread.sleep(2000);
		PerformerLocator.clickAct2().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceEPF().click();
		Thread.sleep(2000);
		PerformerLocator.clickYear().click();
		Thread.sleep(2000);
		PerformerLocator.Year2025().click();
		Thread.sleep(2000);
		PerformerLocator.clickPeriod().click();
		Thread.sleep(2000);
		PerformerLocator.selectMonthMay().click();
		
		
		Thread.sleep(2000);
		PerformerLocator.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		PerformerLocator.clickApply().click();
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click();
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click(); 
		Thread.sleep(7000);
		
//		PerformerLocator.EPF_ConsolatedWorkingDownload().click();
//		Thread.sleep(7000);
		
		
		
		
        // Step 1: Manually download file
		PerformerLocator.EPF_ConsolatedWorkingDownload().click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
		
/*		WebDriver driver = CommonBusinessUtilis.getDriver();
		
		CommonBusinessUtilis.validateExcelTotalByColumnIndex(
			    driver,                   // WebDriver instance
			    test,                     // ExtentTest instance for logging
			    downloadedExcelFile,      // File object (pending ka Excel)
			    12,                       // AD column = 29 (0 se start)
			    0,                        // Header is 2nd row (index 1)
			    "Remittance",                // Sheet name
			    "Gross Wages Calculations", // Custom log report text
			    1                       // Tolerance (exact match chahiye)
			);
*/
		
	}
	
	public static void Challan_PT_Redirection( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
//		if(user.equalsIgnoreCase("Performer"))
//		{
//			LoginLocators.Search().sendKeys("TESTAUTO");
//			OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO");
//		}
//		else if(user.equalsIgnoreCase("Distributor"))
//		{
//			LoginLocators.Search().sendKeys("AVACORED5");	
//		}
//		else if(user.equalsIgnoreCase("Reviewer"))
//		{
//			LoginLocators.Search().sendKeys("AVACORED5");	
//		}
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		PerformerLocator.clickStatutoryDoc().click();
		Thread.sleep(2000);
		PerformerLocator.clickComplianceType().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceChallan().click();
		Thread.sleep(2000);
		PerformerLocator.clickAct2().click();
		Thread.sleep(2000);
		PerformerLocator.selectCompliancePT().click();
		Thread.sleep(2000);
		PerformerLocator.clickYear().click();
		Thread.sleep(2000);
		PerformerLocator.Year2024().click();
		Thread.sleep(2000);
		PerformerLocator.clickPeriod().click();
		Thread.sleep(2000);
		PerformerLocator.selectMonth().click();
		
		
		Thread.sleep(2000);
		PerformerLocator.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		PerformerLocator.clickApply().click();
		Thread.sleep(6000);
		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click();
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click(); 
		Thread.sleep(7000);
		
//		PerformerLocator.EPF_ConsolatedWorkingDownload().click();
//		Thread.sleep(7000);
		
		
		
		
        // Step 1: Manually download file
		getDriver().findElement(By.xpath("//img[@alt='Download Document']")).click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
		
		
	}
	
	
	
	
	public static void Registers_KAR_FORM_A_Redirection( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

	//	WebDriverWait wait1 = new WebDriverWait(getDriver(), Duration.ofMinutes(2)); // 2 minutes
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
//		if(user.equalsIgnoreCase("Performer"))
//		{
//			LoginLocators.Search().sendKeys("TESTAUTO");
//			OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO");
//		}
//		else if(user.equalsIgnoreCase("Distributor"))
//		{
//			LoginLocators.Search().sendKeys("AVACORED5");	
//		}
//		else if(user.equalsIgnoreCase("Reviewer"))
//		{
//			LoginLocators.Search().sendKeys("AVACORED5");	
//		}
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		PerformerLocator.clickStatutoryDoc().click();
		Thread.sleep(2000);
		PerformerLocator.clickComplianceType().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceRegister().click();
		Thread.sleep(2000);
		PerformerLocator.clickAct2().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceShopsAndEstablishment().click();
		Thread.sleep(2000);
		PerformerLocator.clickYear().click();
		Thread.sleep(2000);
		PerformerLocator.Year2024().click();
		Thread.sleep(2000);
		PerformerLocator.clickPeriod().click();
		Thread.sleep(2000);
		PerformerLocator.selectMonth().click();
		
		
		Thread.sleep(2000);
		PerformerLocator.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Karnataka')]")).click();
		Thread.sleep(2000);
		PerformerLocator.clickApply().click();
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click();
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[2]")).click(); 
		Thread.sleep(7000);
		
//		PerformerLocator.EPF_ConsolatedWorkingDownload().click();
//		Thread.sleep(7000);
		
		
		WebElement triangle = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-right k-treelist-toggle k-svg-icon k-icon ng-star-inserted']"));
		triangle.click();
		Thread.sleep(7000);
		WebElement FormA = getDriver().findElement(By.xpath("(//img[@title='Download'])[2]"));
		
        // Step 1: Manually download file
		FormA.click();
		Thread.sleep(5000);
		getDriver().findElement(By.xpath("//img[@alt='Download Document']")).click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
		
		
	}
	
	
	public static void ChallanPFRedirectin( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"DOCAUTOO4");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		PerformerLocator.clickStatutoryDoc().click();
		Thread.sleep(2000);
		PerformerLocator.clickComplianceType().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceChallan().click();
		Thread.sleep(2000);
		PerformerLocator.clickAct2().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceEPF().click();
		Thread.sleep(2000);
		PerformerLocator.clickYear().click();
		Thread.sleep(2000);
		formLocators.Year2025().click();
		Thread.sleep(2000);
		PerformerLocator.clickPeriod().click();
		Thread.sleep(2000);
		formLocators.selectMonthAugust().click();
		
		
		Thread.sleep(2000);
		PerformerLocator.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("(//span[contains(text(),'Document Automation')])[2]")).click(); //Checkbox
		Thread.sleep(5000);
		PerformerLocator.clickApply().click();
		Thread.sleep(10000);
		
		
	}
	
	public static void Registers_KAR_FORM_A_FOLDER_Redirection( ExtentTest test, String user) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		PerformerLocator.clickStatutoryDoc().click();
		Thread.sleep(2000);
		PerformerLocator.clickComplianceType().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceRegister().click();
		Thread.sleep(2000);
		PerformerLocator.clickAct2().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceShopsAndEstablishment().click();
		Thread.sleep(2000);
		PerformerLocator.clickYear().click();
		Thread.sleep(2000);
		PerformerLocator.Year2024().click();
		Thread.sleep(2000);
		PerformerLocator.clickPeriod().click();
		Thread.sleep(2000);
		PerformerLocator.selectMonth().click();
		
		
		Thread.sleep(2000);
		PerformerLocator.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Karnataka')]")).click();
		Thread.sleep(2000);
		PerformerLocator.clickApply().click();
		Thread.sleep(2000);

		Thread.sleep(2000);

		Thread.sleep(7000);
		
		
		
		  
		          
		          
		// Step 1: Click zip Download button
		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click();
		Thread.sleep(10000);
		Thread.sleep(5000);

		// Step 2: Wait until ZIP appears in Downloads (max 30 sec)
		File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
		File latestZip = null;
		for (int i = 0; i < 30; i++) {
			File[] zipFiles = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".zip"));
			if (zipFiles != null && zipFiles.length > 0) {
				Arrays.sort(zipFiles, Comparator.comparingLong(File::lastModified).reversed());
				latestZip = zipFiles[0];
				if (latestZip.exists() && latestZip.length() > 0) {
					break; // ✅ file ready
				}
			}
			Thread.sleep(1000); // wait 1 sec and retry
		}

		// Step 3: Extract specific Excel from ZIP
		 downloadedExcelFile = getExcelFromLatestZip("KAR Central Form-B.xlsx", test);
//		downloadedExcelFile = getExcelFromLatestZip("KAR Central Form A (Part-A).xlsx", test);

		Thread.sleep(4000);
		
		
		
		
		if (downloadedExcelFile == null) {
		    test.log(LogStatus.FAIL, "ZIP extraction failed or file not found.");
		} else {
		    test.log(LogStatus.INFO, "Using extracted file: " + downloadedExcelFile.getAbsolutePath());
		}

		
		
	}
	
	public static void Registers_Redirection( ExtentTest test, String user) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.Search()));
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"TESTAUTO");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(LoginLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		LoginLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		PerformerLocator.clickStatutoryDoc().click();
		Thread.sleep(2000);
		PerformerLocator.clickComplianceType().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceRegister().click();
		Thread.sleep(2000);
		PerformerLocator.clickAct2().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceShopsAndEstablishment().click();
		Thread.sleep(2000);
		PerformerLocator.clickYear().click();
		Thread.sleep(2000);
		PerformerLocator.Year2024().click();
		Thread.sleep(2000);
		PerformerLocator.clickPeriod().click();
		Thread.sleep(2000);
		PerformerLocator.selectMonth().click();
		
		
		Thread.sleep(2000);
		PerformerLocator.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Karnataka')]")).click();
		Thread.sleep(2000);
		PerformerLocator.clickApply().click();
		Thread.sleep(2000);

		Thread.sleep(2000);

		Thread.sleep(7000);
	
	
	}
	
	
	
	// Robust ZIP -> extract -> verify method
	public static File getExcelFromLatestZip(String expectedFileName, ExtentTest test) throws Exception {
	    File downloadDir = new File(System.getProperty("user.home") + File.separator + "Downloads");
	    if (!downloadDir.exists()) {
	        if (test != null) test.log(LogStatus.FAIL, "❌ Downloads folder not found: " + downloadDir.getAbsolutePath());
	        throw new IllegalStateException("Downloads folder not found: " + downloadDir.getAbsolutePath());
	    }

	    // find latest zip
	    File[] zipFiles = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".zip"));
	    if (zipFiles == null || zipFiles.length == 0) {
	        if (test != null) test.log(LogStatus.FAIL, "❌ No ZIP files found in Downloads folder");
	        return null;
	    }
	    Arrays.sort(zipFiles, Comparator.comparingLong(File::lastModified).reversed());
	    File latestZip = zipFiles[0];

	    // log picked zip
	    if (test != null) test.log(LogStatus.INFO, "📂 ZIP picked: " + latestZip.getName());
	    System.out.println("DEBUG: ZIP picked -> " + latestZip.getAbsolutePath() + " (size=" + latestZip.length() + ")");

	    // wait until ZIP file appears to be stable (size doesn't change for short period)
	    final int stabilityChecks = 5;
	    final long stableDelayMs = 300L;
	    long prevSize = -1;
	    int stable = 0;
	    for (int i = 0; i < stabilityChecks; i++) {
	        long curSize = latestZip.length();
	        if (curSize == prevSize && curSize > 0) {
	            stable++;
	        } else {
	            stable = 0;
	        }
	        prevSize = curSize;
	        if (stable >= 2) break; // considered stable
	        Thread.sleep(stableDelayMs);
	    }

	    // inspect entries
	    try (java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(latestZip)) {
	        System.out.println("DEBUG: Files inside ZIP:");
	        zipFile.stream().forEach(e -> System.out.println(" - " + e.getName()));

	        // Try to find expected file (case-insensitive). Try exact filename match, then fuzzy contains.
	        java.util.zip.ZipEntry entry = zipFile.stream()
	                .filter(e -> new File(e.getName()).getName().equalsIgnoreCase(expectedFileName.trim()))
	                .findFirst()
	                .orElse(null);

	        if (entry == null) {
	            // fallback: partial/contains match
	            entry = zipFile.stream()
	                    .filter(e -> new File(e.getName()).getName().toLowerCase().contains(expectedFileName.toLowerCase().trim()))
	                    .findFirst()
	                    .orElse(null);
	        }

	        if (entry == null) {
	            if (test != null) test.log(LogStatus.FAIL, "❌ File not found in zip: " + expectedFileName);
	            System.out.println("DEBUG: File not found in zip by name: " + expectedFileName);
	            return null;
	        }

	        // Extract to temp location
	        File extractedFile = new File(System.getProperty("java.io.tmpdir"), new File(entry.getName()).getName());
	        try (InputStream is = zipFile.getInputStream(entry);
	             FileOutputStream fos = new FileOutputStream(extractedFile)) {
	            byte[] buffer = new byte[4096];
	            int len;
	            while ((len = is.read(buffer)) > 0) {
	                fos.write(buffer, 0, len);
	            }
	            fos.flush();
	        }

	        // quick checks and small retry if size==0
	        if (extractedFile.length() == 0) {
	            // small wait and retry read (sometimes OS hasn't flushed)
	            Thread.sleep(300);
	            if (extractedFile.length() == 0) {
	                if (test != null) test.log(LogStatus.FAIL, "❌ Extracted file is empty: " + extractedFile.getName());
	                System.out.println("DEBUG: Extracted file empty -> " + extractedFile.getAbsolutePath());
	                return null;
	            }
	        }

	        // Try to open with Apache POI to ensure file is a valid XLSX
	        boolean good = false;
	        int attempts = 0;
	        Exception lastEx = null;
	        while (attempts < 3 && !good) {
	            attempts++;
	            try (FileInputStream fis = new FileInputStream(extractedFile)) {
	                org.apache.poi.ss.usermodel.Workbook wb = org.apache.poi.ss.usermodel.WorkbookFactory.create(fis);
	                // basic sanity: at least one sheet
	                if (wb.getNumberOfSheets() > 0) {
	                    good = true;
	                }
	                wb.close();
	            } catch (Exception e) {
	                lastEx = e;
	                System.out.println("DEBUG: POI open failed attempt " + attempts + " -> " + e.getMessage());
	                Thread.sleep(200);
	            }
	        }

	        if (!good) {
	            if (test != null) test.log(LogStatus.FAIL, "❌ Extracted XLSX not readable: " + extractedFile.getName() + " (POI errors).");
	            System.out.println("DEBUG: extracted file not readable by POI. lastEx=" + (lastEx==null? "null" : lastEx.getMessage()));
	            return null;
	        }

	        // success
	        if (test != null) test.log(LogStatus.PASS, "📄 xlsx File found & verified: " + extractedFile.getName());
	        System.out.println("DEBUG: extracted & verified -> " + extractedFile.getAbsolutePath() + " (size=" + extractedFile.length() + ")");
	        return extractedFile;
	    } // zipFile auto-closed
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	//Zip Download and Extract:-
	public static File getExcelFromLatestZip(String expectedFileName, ExtentTest test) throws Exception {
	    File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
	    File[] zipFiles = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".zip"));
	    if (zipFiles == null || zipFiles.length == 0) {
	        if (test != null) {
	            test.log(LogStatus.FAIL, "❌ No ZIP files found in Downloads folder");
	        } else {
	            System.out.println("❌ No ZIP files found in Downloads folder");
	        }
	        return null;
	    }

	    // Sort by latest modified → pick latest zip
	    Arrays.sort(zipFiles, Comparator.comparingLong(File::lastModified).reversed());
	    File latestZip = zipFiles[0];

	    // Log picked ZIP file
	    if (test != null) {
	        test.log(LogStatus.INFO, "📂 ZIP picked: " + latestZip.getName());
	    } else {
	        System.out.println("📂 ZIP picked: " + latestZip.getName());
	    }

	    try (java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(latestZip)) {
	        // Debug: print entries
	        System.out.println("🔍 Files inside ZIP:");
	        zipFile.stream().forEach(e -> System.out.println(" - " + e.getName()));

	        // Try to find expected file (case-insensitive, partial match allowed)
	        java.util.zip.ZipEntry entry = zipFile.stream()
	                .filter(e -> new File(e.getName()).getName().toLowerCase().contains(expectedFileName.toLowerCase().trim()))
	                .findFirst()
	                .orElse(null);

	        // ❌ File not found case
	        if (entry == null) {
	            if (test != null) {
	                test.log(LogStatus.FAIL, "❌ File not found in zip: " + expectedFileName);
	            } else {
	                System.out.println("❌ File not found in zip: " + expectedFileName);
	            }
	            return null;
	        }

	        // Extract file to temp dir
	        File extractedFile = new File(System.getProperty("java.io.tmpdir"), new File(entry.getName()).getName());
	        try (InputStream is = zipFile.getInputStream(entry);
	             FileOutputStream fos = new FileOutputStream(extractedFile)) {
	            byte[] buffer = new byte[1024];
	            int len;
	            while ((len = is.read(buffer)) > 0) {
	                fos.write(buffer, 0, len);
	            }
	        }

	        // Log success
	        if (test != null) {
	            test.log(LogStatus.PASS, "📄xlsx File found: " + extractedFile.getName());
	        } else {
	            System.out.println("📄 File found: " + extractedFile.getName());
	        }

	        return extractedFile;
	    }
	}


	*/
	
	
	
	public static void PfCO_Remittance_M_GrossWage_Total( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		
		EPF_Consolated_Redirection(test, user);
		

		WebDriver driver = null;
		File downloadedExcelFile = null;

		try {
			// Step 1: Initialize WebDriver (as per your existing utilities)
			driver = UtilisOne.getDriver();

			// Step 2: Manually download file via selenium click
//			PerformerLocator.EPF_ConsolatedWorkingDownload().click();

			// Wait for download to complete (adjust as per file size/network speed)
			Thread.sleep(8000);

			// Step 3: Get latest downloaded Excel file
			File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
			File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
			if (files == null || files.length == 0) {
				test.log(LogStatus.FAIL, "❌ No Excel files found in downloads folder.");
				return;
			}
			Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
			downloadedExcelFile = files[0];

			// Step 4: Validate Excel Total for specific Column in specific Sheet
			validateExcelTotalByColumnIndex(driver, test, downloadedExcelFile, 12, // Column index : 12 (as per your
																					// example)
					0, // Header row index : 0 (means 1st row has header)
					"Remittance", // Sheet name
					"Gross Wages Calculations", // Custom log message
					1.0 // Tolerance (you gave 1)
			);
		} catch (Exception e) {
			test.log(LogStatus.ERROR, "❌ Error in demoValidateExcelTotalWithDownload: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (driver != null) {
				driver.quit(); // properly close driver after test run
			}
		}
	}

	// Your complete original method combined as a single method (no helper calls)
	public static void validateExcelTotalByColumnIndex(WebDriver driver, ExtentTest test, File filePath,
			int columnIndex, int headerRowIndex, String sheetName, String logText, double tolerance) {
		try {
			if (filePath == null || !filePath.exists()) {
				test.log(LogStatus.FAIL, "❌ Excel file not found to validate.");
				return;
			}

			test.log(LogStatus.INFO, "📄 Data Fetch file name: " + filePath.getName());

			FileInputStream fis = new FileInputStream(filePath);
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);

			if (sheet == null) {
				test.log(LogStatus.FAIL, "❌ Sheet not found: " + sheetName);
				workbook.close();
				return;
			}

			double calculatedTotal = 0.0;
			double fileTotal = -1;

			for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row == null)
					continue;

				Cell firstCell = row.getCell(0);
				if (firstCell != null && firstCell.getCellType() == CellType.STRING
						&& firstCell.getStringCellValue().trim().equalsIgnoreCase("Total")) {

					Cell totalCell = row.getCell(columnIndex);
					fileTotal = totalCell != null && totalCell.getCellType() == CellType.NUMERIC
							? totalCell.getNumericCellValue()
							: 0;

					break;
				}

				Cell dataCell = row.getCell(columnIndex);
				if (dataCell != null && dataCell.getCellType() == CellType.NUMERIC) {
					calculatedTotal += dataCell.getNumericCellValue();
				}
			}

			workbook.close();

			test.log(LogStatus.INFO, "📊 Expected count: " + calculatedTotal + "   ||   Actual count: " + fileTotal);

			if (fileTotal == -1) {
				test.log(LogStatus.FAIL, "❌ Total row not found in sheet: " + sheetName);
				return;
			}

			if (Math.abs(calculatedTotal - fileTotal) <= Math.max(tolerance, 0.01)) {
				test.log(LogStatus.PASS, "✅ " + logText + ": matched total: " + fileTotal);
			} else {
				test.log(LogStatus.FAIL,
						"❌ " + logText + ": mismatch. Expected: " + calculatedTotal + ", Found: " + fileTotal);
			}

		} catch (Exception e) {
			test.log(LogStatus.ERROR, "❌ Error during Excel total validation: " + e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public static void PfCO_Remittance_N_BasicWages_Total( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		EPF_Consolated_Redirection(test, user);
		
		
		{
			WebDriver driver = UtilisOne.getDriver();

			// Step 1: Get Latest Downloaded File
			File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
			File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
			if (files == null || files.length == 0) {
				test.log(LogStatus.FAIL, "❌ No Excel file found in Downloads.");
				return;
			}
			Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
			File downloadedExcelFile = files[0];

			
			if (downloadedExcelFile == null || !downloadedExcelFile.exists()) {
				test.log(LogStatus.FAIL, "❌ Excel file not found to validate.");
				return;
			}
			test.log(LogStatus.INFO, "📄 Data Fetch file name: " + downloadedExcelFile.getName());

			// Step 3: Open sheet
			Workbook workbook = WorkbookFactory.create(new FileInputStream(downloadedExcelFile));
			Sheet sheet = workbook.getSheet("Remittance");
			if (sheet == null) {
				test.log(LogStatus.FAIL, "❌ Sheet not found: Remittance");
				workbook.close();
				return;
			}

			
			int columnIndex = 13;
			int headerRowIndex = 0;
			double calculatedTotal = 0.0;
			double fileTotal = -1;

			for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				if (row == null)
					continue;

				Cell firstCell = row.getCell(0);
				if (firstCell != null && firstCell.getCellType() == CellType.STRING
						&& firstCell.getStringCellValue().trim().equalsIgnoreCase("Total")) {

					Cell totalCell = row.getCell(columnIndex);
					fileTotal = totalCell != null && totalCell.getCellType() == CellType.NUMERIC
							? totalCell.getNumericCellValue()
							: 0;
					break;
				}

				Cell dataCell = row.getCell(columnIndex);
				if (dataCell != null && dataCell.getCellType() == CellType.NUMERIC) {
					calculatedTotal += dataCell.getNumericCellValue();
				}
			}
			workbook.close();

			// Step 5: Log result
			test.log(LogStatus.INFO, "📊 Expected count: " + calculatedTotal + "   ||   Actual count: " + fileTotal);
			if (fileTotal == -1) {
				test.log(LogStatus.FAIL, "❌ Total row not found in sheet.");
			} else if (Math.abs(calculatedTotal - fileTotal) <= 1) {
				test.log(LogStatus.PASS, "✅ Basic Wages Calculations: matched total: " + fileTotal);
			} else {
				test.log(LogStatus.FAIL,
						"❌ Gross Wages Calculations: mismatch. Expected: " + calculatedTotal + ", Found: " + fileTotal);
			}
		}

		
		
		
		
	}
	
	public static void PfCO_Remittance_EmployeeCheck( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		EPF_Consolated_Redirection(test, user);
		
		
		WebDriver driver = UtilisOne.getDriver();
		
		
/**		CommonBusinessUtilis.validateExcelBusinessData(
				downloadedExcelFile,
			    test,
			    new ExcelFileDetails(masterFilePath, "EmployeeMaster", 3, Arrays.asList(
			        new ExcelFilter(6, Arrays.asList("KAR"))
			    ), "NO"),
			    
			    
			    new ExcelTargetValidation("Remittance", 1, "Employee No", 0),
			    new ExcelExtraConfig("", 0, ""),
			    "🧪 Validating based on Master File"
			);


		CommonBusinessUtilis.validateExcelBusinessData(
				downloadedExcelFile,
			    test,
			    null,
			    new ExcelTargetValidation("Sheet1", 1, "Basic", 0),
			    new ExcelExtraConfig("NO", 1, "Total"),
			    "🧪 Validate till 'Total' row only"
			);

		*/
		
		UtilisOne.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    new ExcelFileDetails(
			        masterFilePath,
			        "EmployeeMaster",  // ✅ Sheet name from master file
			        3,                 // ✅ Column index for EmpName in Master (F column = index 5)
			        Arrays.asList(
			            new ExcelF(6, Arrays.asList("KAR"))  // ✅ J column = index 6
			        ),
			        "NO"               // ✅ No filter to apply
			    ),
			    new ExcelTargetValidation(
			        "Remittance",      // ✅ Sheet name in downloaded file
			        1,                 // ✅ Column index where Employee Names appear (C column = index 2)
			        "Employee No",   // ✅ Keyword to search in header row (or logs)
			        0                  // ✅ Start directly from header row
			    ),
			    new ExcelExtraConfig("", 0, ""),  // ✅ No Total logic needed
			    "🧪 Validating based on Master File"
			);
		
		
		UtilisOne.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    null,
			    new ExcelTargetValidation(
			        "Remittance",   // ✅ Downloaded file sheet name
			        1,          // ✅ Column index to sum/validate (B column = index 1)
			        "Basic",    // ✅ Just for log, ya optionally keyword to start from
			        0           // ✅ Start from first row
			    ),
			    new ExcelExtraConfig(
			        "NO",       // ✅ Don’t apply Total row logic
			        1,          // ✅ Column index where “Total” will be checked if YES
			        "Total"     // ✅ Keyword to stop at
			    ),
			    "🧪 Validate till 'Total' row only"
			);

		
		
	}
	
	public static void PfCO_Remittance_EmployeeCheck2( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		UtilisOne.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    new ExcelFileDetails(
			        masterFilePath,
			        "EmployeeMaster",  // ✅ Sheet name from master file
			        5,                 // ✅ Column index for EmpName in Master (F column = index 5)
			        Arrays.asList(
			            new ExcelF(6, Arrays.asList("KAR"))  // ✅ J column = index 6
			        ),
			        "NO"               // ✅ No filter to apply
			    ),
			    new ExcelTargetValidation(
			        "Remittance",      // ✅ Sheet name in downloaded file
			        2,                 // ✅ Column index where Employee Names appear (C column = index 2)
			        "Employee Name",   // ✅ Keyword to search in header row (or logs)
			        0                  // ✅ Start directly from header row
			    ),
			    new ExcelExtraConfig("", 0, ""),  // ✅ No Total logic needed
			    "🧪 Validating based on Master File"
			);
		
		
		UtilisOne.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    null,
			    new ExcelTargetValidation(
			        "Remittance",   // ✅ Downloaded file sheet name
			        1,          // ✅ Column index to sum/validate (B column = index 1)
			        "Basic",    // ✅ Just for log, ya optionally keyword to start from
			        0           // ✅ Start from first row
			    ),
			    new ExcelExtraConfig(
			        "NO",       // ✅ Don’t apply Total row logic
			        1,          // ✅ Column index where “Total” will be checked if YES
			        "Total"     // ✅ Keyword to stop at
			    ),
			    "🧪 Validate till 'Total' row only"
			);
		
		
	}
	
	public static void PF_AllEMPWorkings_Test( ExtentTest test, String user) throws Exception
	{
		ChallanPFRedirectin(test,user);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("345678765456794", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument5().click();
        Thread.sleep(10000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
        
        
     // ---------- Simple ready-to-drop calling (uses your globals downloadedExcelFile & salaryFile) ----------
        ExcelExtraConfig extraConfig = new ExcelExtraConfig("NO", ExcelUtils.columnLetterToIndex("H"), "VPF");

        List<ExcelF> masterFilters = new ArrayList<>();
        List<ExcelF> downloadedFilters = new ArrayList<>();

        // master filters you gave
        masterFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("AD"), Arrays.asList("Chattishgad Branch")));
        masterFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("AF"), Arrays.asList("Yes")));
        
        //Downloaded filters
        downloadedFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("G"), Arrays.asList("VPF")));

        // header map: Master.I is total (~63000) and downloaded header "Basic" is in H (we pass H, util will apply +7 internally)
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("I", "VPF");    // Master sheet column I (expected ~63000)
        headerMap.put("H", "Basic");             // Downloaded sheet header to locate "Basic" (utility will use +7 as per your rule)

        // FINAL call — simple, same style as your reference
        Utilis3.validateExcelCalculation(
            downloadedExcelFile,
            FilePath.SALARY_FILE,
            test,
            "All_Employees.H = Master.I",   // keep H here (your util will use header H and startRowOffset to apply +7 logic)
            "MASTER",
            "All_Employees",                // or "All_Employees" if your util prefers alias — keep as your project expects All Employees
            masterFilters,
            downloadedFilters,
            extraConfig,
            1,       // tolerance %
            false,   // compareRowByRow
            7,       // startRowOffset (you wanted 7 — used here)
            headerMap,
            "🧪 Validating VPF/Basic+7: All Employees.(Basic+7) = MASTER.I (expected ~63000)"
        );

        
        
        
        
        
		
		
	}
	public static void PF_AllEMPWorkings_Test2( ExtentTest test, String user) throws Exception
	{
		ChallanPFRedirectin(test,user);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("345678765456795", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument5().click();
        Thread.sleep(10000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
        
        
     // ---------- Simple ready-to-drop calling (uses your globals downloadedExcelFile & salaryFile) ----------
        ExcelExtraConfig extraConfig = new ExcelExtraConfig("NO", ExcelUtils.columnLetterToIndex("G"), "VPF");

        List<ExcelF> masterFilters = new ArrayList<>();
        List<ExcelF> downloadedFilters = new ArrayList<>();

        // master filters you gave
        masterFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("AD"), Arrays.asList("DaraNHaveli Branch")));
        masterFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("AF"), Arrays.asList("Yes")));
        
        //Downloaded filters
        downloadedFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("G"), Arrays.asList("VPF")));

        // header map: Master.I is total (~63000) and downloaded header "Basic" is in H (we pass H, util will apply +7 internally)
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("I", "VPF");    // Master sheet column I (expected ~63000)
        headerMap.put("H", "Basic");             // Downloaded sheet header to locate "Basic" (utility will use +7 as per your rule)

        // FINAL call — simple, same style as your reference
        Utilis3.validateExcelCalculation(
            downloadedExcelFile,
            FilePath.SALARY_FILE,
            test,
            "All_Employees.H = Master.I",   // keep H here (your util will use header H and startRowOffset to apply +7 logic)
            "MASTER",
            "All_Employees",                // or "All_Employees" if your util prefers alias — keep as your project expects All Employees
            masterFilters,
            downloadedFilters,
            extraConfig,
            1,       // tolerance %
            false,   // compareRowByRow
            7,       // startRowOffset (you wanted 7 — used here)
            headerMap,
            "🧪 Validating VPF as per masters"
        );

		
	}
	public static void PF_AllEMPWorkings_Test3( ExtentTest test, String user) throws Exception
	{
	     // ---------- Simple ready-to-drop calling (uses your globals downloadedExcelFile & salaryFile) ----------
        ExcelExtraConfig extraConfig = new ExcelExtraConfig("NO", ExcelUtils.columnLetterToIndex("G"), "VPF");

        List<ExcelF> masterFilters = new ArrayList<>();
        List<ExcelF> downloadedFilters = new ArrayList<>();
        
        

        // master filters you gave
        masterFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("AD"), Arrays.asList("DaraNHaveli Branch")));
        masterFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("AF"), Arrays.asList("Yes")));
        
        //Downloaded filters
        downloadedFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("G"), Arrays.asList("EPS Wages")));

        // header map: Master.I is total (~63000) and downloaded header "Basic" is in H (we pass H, util will apply +7 internally)
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("P", "PF Gross");    // Master sheet column I (expected ~63000)
        headerMap.put("H", "Basic");             // Downloaded sheet header to locate "Basic" (utility will use +7 as per your rule)

        // FINAL call — simple, same style as your reference
        Utilis3.validateExcelCalculation(
            downloadedExcelFile,
            FilePath.SALARY_FILE,
            test,
            "All_Employees.H = Master.P",   // keep H here (your util will use header H and startRowOffset to apply +7 logic)
            "MASTER",
            "All_Employees",                // or "All_Employees" if your util prefers alias — keep as your project expects All Employees
            masterFilters,
            downloadedFilters,
            extraConfig,
            1,       // tolerance %
            false,   // compareRowByRow
            2,       // startRowOffset (you wanted 7 — used here)
            headerMap,
            "🧪 Validating VPF as per masters"
        );

		
	}
	public static void PF_AllEMPWorkings_Test4( ExtentTest test, String user) throws Exception
	{
	     // ---------- Simple ready-to-drop calling (uses your globals downloadedExcelFile & salaryFile) ----------
        ExcelExtraConfig extraConfig = new ExcelExtraConfig("NO", ExcelUtils.columnLetterToIndex("G"), "VPF");

        List<ExcelF> masterFilters = new ArrayList<>();
        List<ExcelF> downloadedFilters = new ArrayList<>();

        // master filters you gave
        masterFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("AD"), Arrays.asList("DaraNHaveli Branch")));
        masterFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("AF"), Arrays.asList("Yes")));
        
        //Downloaded filters
 //     downloadedFilters.add(new ExcelFilter(ExcelUtils.columnLetterToIndex("G"), Arrays.asList("EPS Wages")));

        // header map: Master.I is total (~63000) and downloaded header "Basic" is in H (we pass H, util will apply +7 internally)
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("P", "PF Gross");    // Master sheet column I (expected ~63000)
        headerMap.put("V", "12% (EPF) A/C No 1");             // Downloaded sheet header to locate "Basic" (utility will use +7 as per your rule)

        // FINAL call — simple, same style as your reference
        Utilis3.validateExcelCalculation(
            downloadedExcelFile,
            FilePath.SALARY_FILE,
            test,
            "All_Employees.V = Master.P * 0.12",   // keep H here (your util will use header H and startRowOffset to apply +7 logic)
            "MASTER",
            "All_Employees",                // or "All_Employees" if your util prefers alias — keep as your project expects All Employees
            masterFilters,
            downloadedFilters,
            extraConfig,
            1,       // tolerance %
            true,   // compareRowByRow
            2,       // startRowOffset (you wanted 2 — used here)
            headerMap,
            "🧪 Validating VPF as per masters"
        );

		
	}
	public static void PF_AllEMPWorkings_Test5( ExtentTest test, String user) throws Exception
	{
	     // ---------- Simple ready-to-drop calling (uses your globals downloadedExcelFile & salaryFile) ----------
        ExcelExtraConfig extraConfig = new ExcelExtraConfig("NO", ExcelUtils.columnLetterToIndex("G"), "VPF");

        List<ExcelF> masterFilters = new ArrayList<>();
        List<ExcelF> downloadedFilters = new ArrayList<>();

        // master filters you gave
        masterFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("AD"), Arrays.asList("DaraNHaveli Branch")));
        masterFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("AF"), Arrays.asList("Yes")));
        
        //Downloaded filters
 //     downloadedFilters.add(new ExcelFilter(ExcelUtils.columnLetterToIndex("G"), Arrays.asList("EPS Wages")));

        // header map: Master.I is total (~63000) and downloaded header "Basic" is in H (we pass H, util will apply +7 internally)
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("P", "PF Gross");    // Master sheet column I (expected ~63000)
        headerMap.put("V", "12% (EPF) A/C No 1");             // Downloaded sheet header to locate "Basic" (utility will use +7 as per your rule)

        // FINAL call — simple, same style as your reference
        Utilis3.validateExcelCalculation(
            downloadedExcelFile,
            FilePath.SALARY_FILE,
            test,
            "All_Employees.V = Master.P * 0.12",
            "MASTER",
            "All_Employees",
            masterFilters,
            downloadedFilters,
            extraConfig,
            1,       
            false,   
            1,
            headerMap,
            "🧪 Validating VPF as per masters"
        );

		
	}
	public static void RegisterFormB_Test( ExtentTest test, String user) throws Exception
	{
		
		
		Registers_KAR_FORM_A_FOLDER_Redirection(test,user);
		
/**		Registers_Redirection(test,user);
		
		formLocators.triangle().click();
		Thread.sleep(5000);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("Maintaining Register of Wages in Form B", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];   **/
		
		
		
		
		
		ExcelExtraConfig extraConfig = new ExcelExtraConfig("YES",ExcelUtils.columnLetterToIndex("A"),"Total");

			List<ExcelF> masterFilters = new ArrayList<>();
			List<ExcelF> targetFilters = new ArrayList<>();
			masterFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("AL"),Arrays.asList("Karnataka Branch")));
			
			Map<String, String> headerMap = new HashMap<>();
			headerMap.put("C", "Basic"); // Master sheet MonthlyEmployeeChallanSalary
			headerMap.put("H", "Basic Pay");        // Downloaded sheet All Emp Workings

			Utilis3.validateExcelCalculation(
			    downloadedExcelFile,
			    salaryFileTESTAUTO,
			    test,
			    "Central_Form_B.H = Master.C",
			    "MASTER",
			    "Central_Form_B",
			    masterFilters,
			    targetFilters,
			    extraConfig,
			    1,      // tolerance 1% (won't help here — differences ~10%)
			    true,
			    3, // Jump 
			    headerMap,
			    "🧪 Validating ESI: All Emp Workings.K ≈ Master.R * (0.0075 + 0.0375)"
			);
			
			
			
			
			
			

		
		
		
	}
	
	public static void Registers_Form_A_check( ExtentTest test, String user) throws Exception
	{
		
//		Registers_KAR_FORM_A_Redirection(test,user);
		
		Registers_KAR_FORM_A_FOLDER_Redirection(test,user);
		
		UtilisOne.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    new ExcelFileDetails(
			        masterFilePath,
			        "EmployeeMaster",  // ✅ Sheet name from master file
			        5,                 // ✅ Column index for EmpName in Master (F column = index 5)
			        Arrays.asList(
			            new ExcelF(6, Arrays.asList("KAR"))  // ✅ J column = index 6
			        ),
			        "YES"               // ✅ No filter to apply
			    ),
			    new ExcelTargetValidation(
			        "Central Form A (Part-A)",      // ✅ Sheet name in downloaded file
			        2,                 // ✅ Column index where Employee Names appear (C column = index 2)
			        "Name",   // ✅ Keyword to search in header row (or logs)
			        1                  // ✅ Start directly from header row
			    ),
			    new ExcelExtraConfig("", 0, ""),  // ✅ No Total logic needed
			    "🧪 Validating based on Master File"
			);
		
		
		UtilisOne.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    null,
			    new ExcelTargetValidation(
			        "Remittance",   // ✅ Downloaded file sheet name
			        1,          // ✅ Column index to sum/validate (B column = index 1)
			        "Basic",    // ✅ Just for log, ya optionally keyword to start from
			        0           // ✅ Start from first row
			    ),
			    new ExcelExtraConfig(
			        "NO",       // ✅ Don’t apply Total row logic
			        1,          // ✅ Column index where “Total” will be checked if YES
			        "Total"     // ✅ Keyword to stop at
			    ),
			    "" //Total log if req
			);
		
		
		
		
		//2
		UtilisOne.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    new ExcelFileDetails(
			        masterFilePath,
			        "EmployeeMaster",  // ✅ Sheet name from master file
			        5,                 // ✅ Column index for EmpName in Master (F column = index 5)
			        Arrays.asList(
			            new ExcelF(6, Arrays.asList("MAH"))  // ✅ J column = index 6
			        ),
			        "YES"               // ✅ No filter to apply
			    ),
			    new ExcelTargetValidation(
			        "Central Form A (Part-A)",      // ✅ Sheet name in downloaded file
			        2,                 // ✅ Column index where Employee Names appear (C column = index 2)
			        "Name",   // ✅ Keyword to search in header row (or logs)
			        1                  // ✅ Start directly from header row
			    ),
			    new ExcelExtraConfig("", 0, ""),  // ✅ No Total logic needed
			    "🧪 Validating based on Master File"
			);
		
		
		UtilisOne.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    null,
			    new ExcelTargetValidation(
			        "Remittance",   // ✅ Downloaded file sheet name
			        1,          // ✅ Column index to sum/validate (B column = index 1)
			        "Basic",    // ✅ Just for log, ya optionally keyword to start from
			        0           // ✅ Start from first row
			    ),
			    new ExcelExtraConfig(
			        "NO",       // ✅ Don’t apply Total row logic
			        1,          // ✅ Column index where “Total” will be checked if YES
			        "Total"     // ✅ Keyword to stop at
			    ),
			    "" //Total log if req
			);
		
		
		
		
	}
	
	
	public static void Challan_PT_GUJA( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		Challan_PT_Redirection(test,user);
		
		UtilisOne.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    new ExcelFileDetails(
			        masterFilePath,
			        "EmployeeMaster",  // ✅ Sheet name from master file
			        3,                 // ✅ Column index for EmpName in Master (F column = index 5)
			        Arrays.asList(
			            new ExcelF(6, Arrays.asList("KAR"))  // ✅ J column = index 6
			        ),
			        "NO"               // ✅ No filter to apply
			    ),
			    new ExcelTargetValidation(
			        "PTChallan",      // ✅ Sheet name in downloaded file
			        1,                 // ✅ Column index where Employee Names appear (C column = index 2)
			        "Employee ID",   // ✅ Keyword to search in header row (or logs)
			        0                  // ✅ Start directly from header row
			    ),
			    new ExcelExtraConfig("", 0, ""),  // ✅ No Total logic needed
			    "🧪 Validating PT based on Master File"
			);
		
		
		UtilisOne.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    null,
			    new ExcelTargetValidation(
			        "Remittance",   // ✅ Downloaded file sheet name
			        1,          // ✅ Column index to sum/validate (B column = index 1)
			        "Basic",    // ✅ Just for log, ya optionally keyword to start from
			        0           // ✅ Start from first row
			    ),
			    new ExcelExtraConfig(
			        "NO",       // ✅ Don’t apply Total row logic
			        1,          // ✅ Column index where “Total” will be checked if YES
			        "Total"     // ✅ Keyword to stop at
			    ),
			    "" //Total log if req
			);
		
		
	}
	
	public static void RegisterFolderRedirectionChecking( ExtentTest test, String user) throws Exception
	{
		
		Registers_KAR_FORM_A_FOLDER_Redirection(test,user);
		
		
		
		
		
		
	/*	
		// 🧪 Step 3: Prepare master file filters
		List<ExcelFilter> allFilters = new ArrayList<>();
		allFilters.add(new ExcelFilter(38, Arrays.asList("Active"))); // Employment Status
		allFilters.add(new ExcelFilter(9, Arrays.asList("KAR")));      // State filter
		allFilters.add(new ExcelFilter(58, Arrays.asList("Yes")));     // AadharSeeding

		// 📊 Step 4: Prepare ExcelFileDetails for Master (Employee IDs from EmpID col index=3)
		String masterSheetName = "EmployeeMaster";
		int masterColumnIndex = 3;  // EmpID column
		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
		    masterFilePath,
		    masterSheetName,
		    masterColumnIndex,
		    allFilters,
		    "YES"   // Yes = filters applied
		);

		// 🎯 Step 5: Prepare Target validation for downloaded file
		String targetSheetName = "Central Form-B";
		int targetColumnIndex = 0;  // Sl. No. in Employee Register (EmpIDs like EM08, EM09)
		String targetHeaderKeyword = "Sl. No. in Employee Register";
		int targetStartRow = 16;    // Data starts here

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		// 🛠️ Step 6: Prepare Extra Config (No total row logic here)
		String totalLogicEnabled = "";
		int totalColumnIndex = 0;
		String totalKeyword = "";

		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    totalLogicEnabled,
		    totalColumnIndex,
		    totalKeyword
		);

		// ✅ Step 7: Final call to reusable validator
		CommonBusinessUtilis.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Employee IDs are reflecting properly as per masters!"
		);

	*/	
		
		
	/*     // 🧪 Step 3: Prepare master file filters
        List<ExcelFilter> allFilters = new ArrayList<>();
        
        allFilters.add(new ExcelFilter(38, Arrays.asList("Active")));
 
        allFilters.add(new ExcelFilter(9, Arrays.asList("KAR")));

        allFilters.add(new ExcelFilter(58, Arrays.asList("Yes")));
        
        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            masterFilePath,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "YES"   // Yes filters to apply
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "Central Form-B";
        int targetColumnIndex = 1;
        String targetHeaderKeyword = "Sl. No. in Employee Register";
        int targetStartRow = 2;

        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            targetSheetName,
            targetColumnIndex,
            targetHeaderKeyword,
            targetStartRow
        );

        // 🛠️ Step 6: Prepare Extra Config (No total row logic here)
        String totalLogicEnabled = "";
        int totalColumnIndex = 0;
        String totalKeyword = "";

        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
            totalLogicEnabled,
            totalColumnIndex,
            totalKeyword
        );

        // ✅ Step 7: Final call to reusable validator
        CommonBusinessUtilis.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters!"
        );
		
		
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		
		
		
		CommonBusinessUtilis.validateExcelBusinessData(
				testFile,
			    test,
			    new ExcelFileDetails(
			        masterFilePath,
			        "EmployeeMaster",  // ✅ Sheet name from master file
			        3,                 // ✅ Column index for EmpName in Master (F column = index 5)
			        Arrays.asList(
			            new ExcelFilter(6, Arrays.asList("KAR"))  // ✅ J column = index 6
			        ),
			        "NO"               // ✅ No filter to apply
			    ),
			    new ExcelTargetValidation(
			        "PTChallan",      // ✅ Sheet name in downloaded file
			        1,                 // ✅ Column index where Employee Names appear (C column = index 2)
			        "Employee ID",   // ✅ Keyword to search in header row (or logs)
			        0                  // ✅ Start directly from header row
			    ),
			    new ExcelExtraConfig("", 0, ""),  // ✅ No Total logic needed
			    "🧪 Validating PT based on Master File"
			);
		
		
		CommonBusinessUtilis.validateExcelBusinessData(
				testFile,
			    test,
			    null,
			    new ExcelTargetValidation(
			        "Remittance",   // ✅ Downloaded file sheet name
			        1,          // ✅ Column index to sum/validate (B column = index 1)
			        "Basic",    // ✅ Just for log, ya optionally keyword to start from
			        0           // ✅ Start from first row
			    ),
			    new ExcelExtraConfig(
			        "NO",       // ✅ Don’t apply Total row logic
			        1,          // ✅ Column index where “Total” will be checked if YES
			        "Total"     // ✅ Keyword to stop at
			    ),
			    "" //Total log if req
			);
		*/
		
	}
	
	
	
	
	public static void Challan_PT_GUJAII(ExtentTest test, String user) throws InterruptedException, IOException, AWTException 
	{
	    
		
		try {
	        // --- Setup Helper Class Instances ---
	        ExcelF stateFilter = new ExcelF();
	        stateFilter.setColumnName("State");
	        stateFilter.setValues(Arrays.asList("MH"));

	        List<ExcelF> filters = new ArrayList<>();
	        filters.add(stateFilter);

	        ExcelFileDetails masterDetails = new ExcelFileDetails();
	        masterDetails.setFilePath(masterFilePath);
	        masterDetails.setSheetName("Master");
	        masterDetails.setEmpNameColumnIndex(2); // Assuming 'UAN' is in 3rd column
	        masterDetails.setApplyFilter("YES");
	        masterDetails.setFilters(filters);

	        ExcelTargetValidation targetDetails = new ExcelTargetValidation();
	        targetDetails.setSheetName("Remittance");
	        targetDetails.setColumnIndex(5); // Assuming UAN is in 6th column in exported file
	        targetDetails.setHeaderKeyword("UAN No");

	        ExcelExtraConfig extraConfig = new ExcelExtraConfig();
	        extraConfig.setEnable("NO");

	        if (downloadedExcelFile == null || !downloadedExcelFile.exists()) {
	            test.log(LogStatus.FAIL, "❌ Downloaded file is missing.");
	            return;
	        }

	        test.log(LogStatus.INFO, "📄 Data Fetch file name: " + downloadedExcelFile.getName());

	        // --- Read master values ---
	        Set<String> filteredUANs = ExcelUtils.readFilteredColumnValues(
	            masterDetails.getFilePath(),
	            masterDetails.getSheetName(),
	            masterDetails.getEmpNameColumnIndex(),
	            masterDetails.getFilters()
	        );

	        if (filteredUANs.isEmpty()) {
	            test.log(LogStatus.PASS, "✅ No UANs matched in master file for given filter.");
	            return;
	        }

	        // --- Read downloaded column values ---
	        Set<String> downloadedUANs = ExcelUtils.readColumnValues(
	            downloadedExcelFile,
	            targetDetails.getSheetName(),
	            targetDetails.getColumnIndex()
	        );

	        List<String> missing = filteredUANs.stream()
	            .filter(u -> !downloadedUANs.contains(u))
	            .collect(Collectors.toList());

	        if (missing.isEmpty()) {
	            test.log(LogStatus.PASS, "✅ All expected UANs found in downloaded file.");
	        } else {
	            test.log(LogStatus.FAIL, "❌ Missing UANs: " + String.join(", ", missing));

	            if (ENABLE_HTML_REPORT_TABLE) {
	                String htmlTable = HTMLBuilder.createDetailedComparisonTable(
	                    filteredUANs,
	                    downloadedUANs,
	                    masterDetails.getFilePath(),
	                    masterDetails.getSheetName(),
	                    masterDetails.getEmpNameColumnIndex(),
	                    targetDetails.getColumnIndex(),
	                    targetDetails.getHeaderKeyword()
	                );
	                test.log(LogStatus.INFO, htmlTable);
	            }



	        }
	    } catch (Exception e) {
	        test.log(LogStatus.ERROR, "❌ Exception: " + e.getMessage());
	        e.printStackTrace();
	    }
	
	}
	
	
	public static void Challan_PT_GUJFormATest(ExtentTest test, String user) throws InterruptedException, IOException, AWTException 
	{
		
		Challan_PT_Redirection(test,user);
		
		UtilisOne.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    new ExcelFileDetails(
			        masterFilePath,
			        "EmployeeMaster",
			        3,
			        Arrays.asList(
			            new ExcelF(6, Arrays.asList("KAR"))
			        ),
			        "NO"
			    ),
			    new ExcelTargetValidation(
			        "PTChallan",
			        1,
			        "Employee ID",
			        0
			    ),
			    new ExcelExtraConfig("", 0, ""),
			    "🧪 Validating PT based on Master File"
			);

			UtilisOne.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    null,
			    new ExcelTargetValidation(
			        "Remittance",
			        1,
			        "Basic",
			        0
			    ),
			    new ExcelExtraConfig(
			        "NO",
			        1,
			        "Total"
			    ),
			    ""
			);

		
		
		
/*		try {
		    // ✅ FILTER setup: Only select rows in master file where State == "KAR"
		    ExcelFilter filter = new ExcelFilter();
		    filter.setColumnName("State"); // only for readability/logging
		    filter.setValues(Arrays.asList("KAR"));
		    List<ExcelFilter> filters = new ArrayList<>();
		    filters.add(filter);

		    // ✅ MASTER FILE CONFIG
		    ExcelFileDetails masterDetails = new ExcelFileDetails();
		    masterDetails.setFilePath(masterFilePath); // Global master path
		    masterDetails.setSheetName("EmployeeMaster");
		    masterDetails.setEmpNameColumnIndex(3); // D column (0-based)
		    masterDetails.setApplyFilter("YES");
		    masterDetails.setFilters(filters);

		    // ✅ DOWNLOADED FILE CONFIG
		    ExcelTargetValidation targetDetails = new ExcelTargetValidation();
		    targetDetails.setSheetName("PTChallan");
		    targetDetails.setColumnIndex(1); // B column (0-based)
		    targetDetails.setHeaderKeyword("Employee ID");

		    // ✅ EXTRA CONFIG (NO Total logic here)
		    ExcelExtraConfig extraConfig = new ExcelExtraConfig();
		    extraConfig.setEnable("NO"); // we don't want total row validation

		    if (downloadedExcelFile == null || !downloadedExcelFile.exists()) {
		        test.log(LogStatus.FAIL, "❌ Downloaded file is missing.");
		        return;
		    }

		    test.log(LogStatus.INFO, "📄 Data Fetch file name: " + downloadedExcelFile.getName());

		    // ✅ FETCH values from Master
		    Set<String> masterValues = ExcelUtils.readFilteredColumnValues(
		        masterDetails.getFilePath(),
		        masterDetails.getSheetName(),
		        masterDetails.getEmpNameColumnIndex(),
		        masterDetails.getFilters()
		    );

		    if (masterValues.isEmpty()) {
		        test.log(LogStatus.PASS, "✅ No employees matched in master for given filter — skipping validation.");
		        return;
		    }

		    // ✅ FETCH values from Downloaded file
		    Set<String> downloadedValues = ExcelUtils.readColumnValues(
		        downloadedExcelFile,
		        targetDetails.getSheetName(),
		        targetDetails.getColumnIndex()
		    );

		    List<String> missing = masterValues.stream()
		        .filter(v -> !downloadedValues.contains(v))
		        .collect(Collectors.toList());

		    if (missing.isEmpty()) {
		        test.log(LogStatus.PASS, "✅ All expected Employee IDs found in downloaded file.");
		    } else {
		        test.log(LogStatus.FAIL, "❌ Missing Employee IDs: " + String.join(", ", missing));

		        if (ENABLE_HTML_REPORT_TABLE) {
		            String htmlTable = HTMLBuilder.createDetailedComparisonTable(
		                masterValues,
		                downloadedValues,
		                masterDetails.getFilePath(),
		                masterDetails.getSheetName(),
		                masterDetails.getEmpNameColumnIndex(),
		                targetDetails.getColumnIndex(),
		                targetDetails.getHeaderKeyword()
		            );
		            test.log(LogStatus.INFO, htmlTable);
		        }
		    }

		    // ✅ TOTAL LOGIC EXAMPLE (for a second sheet if required)
		    ExcelTargetValidation totalTarget = new ExcelTargetValidation();
		    totalTarget.setSheetName("Remittance");
		    totalTarget.setColumnIndex(1); // Column to sum (e.g., Basic Wages)
		    totalTarget.setHeaderKeyword("Basic");

		    ExcelExtraConfig totalConfig = new ExcelExtraConfig();
		    totalConfig.setEnable("YES");
		    totalConfig.setColumnIndex(1); // Same column to sum
		    totalConfig.setStopAtKeyword("Total"); // Stop summing when this keyword appears in col A

		    ExcelUtils.validateTotalTillKeyword(downloadedExcelFile, test, totalTarget, totalConfig);

		} catch (Exception e) {
		    test.log(LogStatus.ERROR, "❌ Exception: " + e.getMessage());
		    e.printStackTrace();
		}

*/		
		
		
/*		try {
		    // ✅ FILTER (for master): Where State = "MH"
		    ExcelFilter stateFilter = new ExcelFilter();
		    stateFilter.setColumnName("State"); // ✅ Column name (Not used directly, just for readability/logging)
		    stateFilter.setValues(Arrays.asList("MH")); // ✅ Allowed values for filter

		    List<ExcelFilter> filters = new ArrayList<>();
		    filters.add(stateFilter);

		    // ✅ MASTER FILE DETAILS (File path + Sheet + Which column to pick)
		    ExcelFileDetails masterDetails = new ExcelFileDetails();
		    masterDetails.setFilePath(masterFilePath); // ✅ Master file path defined at top of class
		    masterDetails.setSheetName("EmployeeMaster"); // ✅ Sheet name in master file
		    masterDetails.setEmpNameColumnIndex(3); // ✅ Master column index where 'EmpName/UAN/EmpID' exists (0-based)
		    masterDetails.setApplyFilter("NO"); // ✅ Apply filters
		    masterDetails.setFilters(filters); // ✅ Pass the filters list

		    // ✅ TARGET (Downloaded file): From where to validate data
		    ExcelTargetValidation targetDetails = new ExcelTargetValidation();
		    targetDetails.setSheetName("PTChallan"); // ✅ Downloaded file sheet name
		    targetDetails.setColumnIndex(1); // ✅ Column index from downloaded sheet to validate (0-based)
		    targetDetails.setHeaderKeyword("Employee ID"); // ✅ Optional: Just for HTML table header display

		    // ✅ EXTRA CONFIG: Whether to apply Total row logic (NO = skip)
		    ExcelExtraConfig extraConfig = new ExcelExtraConfig();
		    extraConfig.setEnable("NO"); // ✅ Skip Total Row logic

		    // ✅ Validate if file is actually downloaded
		    if (downloadedExcelFile == null || !downloadedExcelFile.exists()) {
		        test.log(LogStatus.FAIL, "❌ Downloaded file is missing.");
		        return;
		    }

		    test.log(LogStatus.INFO, "📄 Data Fetch file name: " + downloadedExcelFile.getName());

		    // ✅ Fetch values from Master (after applying filter)
		    Set<String> filteredUANs = ExcelUtils.readFilteredColumnValues(
		        masterDetails.getFilePath(),
		        masterDetails.getSheetName(),
		        masterDetails.getEmpNameColumnIndex(),
		        masterDetails.getFilters()
		    );

		    if (filteredUANs.isEmpty()) {
		        test.log(LogStatus.PASS, "✅ No UANs matched in master file for given filter.");
		        return;
		    }

		    // ✅ Extract values from downloaded file column
		    Set<String> downloadedUANs = ExcelUtils.readColumnValues(
		        downloadedExcelFile,
		        targetDetails.getSheetName(),
		        targetDetails.getColumnIndex()
		    );

		    List<String> missing = filteredUANs.stream()
		        .filter(u -> !downloadedUANs.contains(u))
		        .collect(Collectors.toList());

		    if (missing.isEmpty()) {
		        test.log(LogStatus.PASS, "✅ All expected UANs found in downloaded file.");
		    } else {
		        test.log(LogStatus.FAIL, "❌ Missing UANs: " + String.join(", ", missing));

		        // ✅ Optional: Add HTML table in report for sample comparison
		        if (ENABLE_HTML_REPORT_TABLE) {
		            String htmlTable = HTMLBuilder.createDetailedComparisonTable(
		                filteredUANs,
		                downloadedUANs,
		                masterDetails.getFilePath(),
		                masterDetails.getSheetName(),
		                masterDetails.getEmpNameColumnIndex(),
		                targetDetails.getColumnIndex(),
		                targetDetails.getHeaderKeyword()
		            );
		            test.log(LogStatus.INFO, htmlTable);
		        }
		    }
		} catch (Exception e) {
		    test.log(LogStatus.ERROR, "❌ Exception: " + e.getMessage());
		    e.printStackTrace();
		}

	*/	
		
	}
	
	
	
	
	
	
	

}
