package formsCalculations;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
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

import businessTestCases.CommonBusinessUtilis;
import login.BasePage;
import login.LoginLocators;
import performer.PerformerLocator;
import rcp.OneCommonMethod;
import utils.ExcelExtraConfig;
import utils.ExcelFileDetails;
import utils.ExcelFilter;
import utils.ExcelTargetValidation;
import utils.ExcelUtils;
import utils.FileSearchHelper;
import utils.HTMLBuilder;




public class EPF_ConsolatedMethods extends BasePage {

	static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour.xlsx";
	
	public static File downloadedExcelFile; // shared file for all test cases
	public static File testFile; //for folder

	
	public static String masterFilePath = "D:\\Upload Automation Files\\BusinessScenarios\\Month\\EmployeeMaster_TESTAUTO.xlsx";
	
		
	
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
	
	public static void Registers_KAR_FORM_A_FOLDER_Redirection( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
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
		

		
//		WebElement triangle = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-right k-treelist-toggle k-svg-icon k-icon ng-star-inserted']"));
//		triangle.click();
//		Thread.sleep(7000);
//		WebElement FormA = getDriver().findElement(By.xpath("(//img[@title='Download'])[2]"));
//		
//		
//		
//        // Step 1: Manually download file
//		FormA.click();
//		Thread.sleep(5000);
//		getDriver().findElement(By.xpath("//img[@alt='Download Document']")).click();
//        Thread.sleep(8000); // wait for file to download
//
		
		
		
        // Step 2: Get latest file
//        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
//        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
//        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
//        downloadedExcelFile = files[0];
		
		
		
		          // Step 1: Download folder manually
		          getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click(); 
		          Thread.sleep(8000);
		          Thread.sleep(8000);
		  
		          // Step 2: Find specific file from folder & set globally
//		          downloadedExcelFile = FileSearchHelper.getFileFromDownloadedFolder(
//		          "KAR Central Form-B.xlsx", test ); // File Name
		          
/**		          downloadedExcelFile = FileSearchHelper.getFileFromLatestFolder(
		        		    "KAR Central Form A (Part-A)",
		        		    test
		        		);
		          
		          if (downloadedExcelFile == null) {
		        	    test.log(LogStatus.FAIL, "File not found in the latest downloaded folder");
		        	} */
		          
		          

		          
		          
		     //code is taken from perplixity calling code
//		          FileSearchHelper.extractZipOnce();
//		          FileSearchHelper.setCurrentTestFile("KAR Central Form A (Part-A)/Central Form A (Part-A).xlsx");
//		          File testFile = FileSearchHelper.getCurrentTestFile();
//		          // Use testFile in your test logic
		          
		          
		          


        
        
        
        
        
		
		
	}
	
	
	
	public static void PfCO_Remittance_M_GrossWage_Total( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	
		
		EPF_Consolated_Redirection(test, user);
		

		WebDriver driver = null;
		File downloadedExcelFile = null;

		try {
			// Step 1: Initialize WebDriver (as per your existing utilities)
			driver = CommonBusinessUtilis.getDriver();

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
			WebDriver driver = CommonBusinessUtilis.getDriver();

			// Step 1: Get Latest Downloaded File
			File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
			File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
			if (files == null || files.length == 0) {
				test.log(LogStatus.FAIL, "❌ No Excel file found in Downloads.");
				return;
			}
			Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
			File downloadedExcelFile = files[0];

			// Step 2: Validate file existence
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

			// Step 4: Calculate column total up to "Total"
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
		
		
		WebDriver driver = CommonBusinessUtilis.getDriver();
		
		
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
		
		CommonBusinessUtilis.validateExcelBusinessData(
			    downloadedExcelFile,
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
			        "Remittance",      // ✅ Sheet name in downloaded file
			        1,                 // ✅ Column index where Employee Names appear (C column = index 2)
			        "Employee No",   // ✅ Keyword to search in header row (or logs)
			        0                  // ✅ Start directly from header row
			    ),
			    new ExcelExtraConfig("", 0, ""),  // ✅ No Total logic needed
			    "🧪 Validating based on Master File"
			);
		
		
		CommonBusinessUtilis.validateExcelBusinessData(
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
		
		CommonBusinessUtilis.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    new ExcelFileDetails(
			        masterFilePath,
			        "EmployeeMaster",  // ✅ Sheet name from master file
			        5,                 // ✅ Column index for EmpName in Master (F column = index 5)
			        Arrays.asList(
			            new ExcelFilter(6, Arrays.asList("KAR"))  // ✅ J column = index 6
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
		
		
		CommonBusinessUtilis.validateExcelBusinessData(
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
	
	public static void Registers_Form_A_check( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		Registers_KAR_FORM_A_Redirection(test,user);
		
		CommonBusinessUtilis.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    new ExcelFileDetails(
			        masterFilePath,
			        "EmployeeMaster",  // ✅ Sheet name from master file
			        5,                 // ✅ Column index for EmpName in Master (F column = index 5)
			        Arrays.asList(
			            new ExcelFilter(6, Arrays.asList("KAR"))  // ✅ J column = index 6
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
		
		
		CommonBusinessUtilis.validateExcelBusinessData(
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
		
		CommonBusinessUtilis.validateExcelBusinessData(
			    downloadedExcelFile,
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
	
	public static void RegisterFolderRedirectionChecking( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		Registers_KAR_FORM_A_FOLDER_Redirection(test,user);
		
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
		
		
	}
	
	
	
	
	public static void Challan_PT_GUJAII(ExtentTest test, String user) throws InterruptedException, IOException, AWTException 
	{
	    
		
		try {
	        // --- Setup Helper Class Instances ---
	        ExcelFilter stateFilter = new ExcelFilter();
	        stateFilter.setColumnName("State");
	        stateFilter.setValues(Arrays.asList("MH"));

	        List<ExcelFilter> filters = new ArrayList<>();
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
		
		CommonBusinessUtilis.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    new ExcelFileDetails(
			        masterFilePath,
			        "EmployeeMaster",
			        3,
			        Arrays.asList(
			            new ExcelFilter(6, Arrays.asList("KAR"))
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

			CommonBusinessUtilis.validateExcelBusinessData(
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
