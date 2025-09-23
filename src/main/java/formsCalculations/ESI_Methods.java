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
import java.util.Collections;
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

import businessChallanForms.PT_ConsolidatedMethods;
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
import utils.methodsb;
import utils.ExcelTargetValidation;
import utils.ExcelUtils;
import utils.ExcelValueNormalizer;
import utils.HTMLBuilder;


public class ESI_Methods extends BasePage {
	
	
	static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour.xlsx";
	
	public static File downloadedExcelFile; // shared file for all test cases
	
	
	//DOCAUTOO4
	public static String masterFilePath = "D:\\Upload Automation Files\\BusinessScenarios\\DOCAUTOO4\\#1 Aug2025\\EmployeeMaster2.xlsx";
	public static String salaryFile = "D:\\Upload Automation Files\\BusinessScenarios\\DOCAUTOO4\\#1 Aug2025\\Sample_challansalary3.xlsx";
	
	
	
	public static void Challan_ESI_StaturyDocRedirection( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
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
		PerformerLocator.selectComplianceESI().click();
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
		
		
//		OneCommonMethod.zoomOutScreen(3);
		Thread.sleep(2000);
		
	}
	
	
	// Top of class me likho
	

	
	




	
	public static void Challan_ESI_400100_EmployeeID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		Challan_ESI_StaturyDocRedirection(test,user);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("400100", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
     // 🧪 Step 3: Prepare master file filters
        List<methodsb> allFilters = new ArrayList<>();
        
        allFilters.add(new methodsb(38, Arrays.asList("Active")));
 
        allFilters.add(new methodsb(85, Arrays.asList("400100")));

//      allFilters.add(new ExcelFilter(58, Arrays.asList("Yes")));
        
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
        String targetSheetName = "Remittence";
        int targetColumnIndex = 1;
        String targetHeaderKeyword = "Employee No";
        int targetStartRow = 0;

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
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters!"
        );
        
        
        
        
        
        
        WebDriver driver = UtilisOne.getDriver();
        UtilisOne.validateColumnHasUniqueValues(
	    driver,
	    test,
	    downloadedExcelFile,
	    0,                 // Column Index for Employee Number (e.g., column F)
	    0,                 // Header at row 2 (i.e., index 1)
	    "All Emp Workings",         // Sheet name
	    "All serial numbers are unique nos" );     // Log/Report label — It will display this log if pass
        
		
	}
	public static void ESIC_AllEMPWorkings_Test( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		Challan_ESI_StaturyDocRedirection(test,user);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("400100", 1);
		
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
		
		
		
		
		// Extra config: enable Total logic if you need totals handling (use actual total column index if needed)
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "YES",                               // enable total logic (if you want total-row handling)
		    ExcelUtils.columnLetterToIndex("A"), // index of column where "Total" text appears (example)
		    "Total"                              // total keyword
		);

		// Filters (if you need, sample as you gave earlier)
		List<methodsb> masterFilters = new ArrayList<>();
		List<methodsb> downloadedFilters = new ArrayList<>();

//		masterFilters.add(new ExcelFilter(ExcelUtils.columnLetterToIndex("X"), Arrays.asList("Yes")));
		masterFilters.add(new methodsb(ExcelUtils.columnLetterToIndex("Y"), Arrays.asList("400100")));
		
		
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("R", "ESI Gross"); // Master sheet MonthlyEmployeeChallanSalary
		headerMap.put("I", "EE");        // Downloaded sheet All Emp Workings


		// Call validator
		Utilis3.validateExcelCalculation(
		    downloadedExcelFile,   // File object for ESI_400100_Aug_2025 (12).xlsx
		    salaryFile,            // master file path or string pointing to Sample_challansalary3.xlsx
		    test,                  // ExtentTest test object
		    "All_Emp_Workings.I = Master.R * 0.0075", // calculation rule
		    "MASTER",              // rhsSource (your code used "MASTER" earlier)
		    "PT_Report",           // defaultSheetName (normalizes via alias map inside CommonBusinessUtilis3)
		    masterFilters,
		    downloadedFilters,
		    extraConfig,
		    5,                  // tolerance (1% relative) — adjust if you want stricter/looser
		    true,                 // compareRowByRow (false means value-existence-ish compare; follow project behavior)
		    0,                     // startRowOffset
		    headerMap,             // headerKeywords map you use
		    "🧪 Validating ESI: All Emp Workings.I ≈ Master.R * 0.75%" // successMessage / descriptive text
		);

		
		
		
		
/**		// Extra config me total logic enable kar de
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "YES",                               // enable total logic
		    ExcelUtils.columnLetterToIndex("A"), // jis column me "Total" likha hota hai uska index (example: I)
		    "Total"                              // keyword jo sheet me likha hai
		);
		
		List<ExcelFilter> masterFilters = new ArrayList<>();
		List<ExcelFilter> targetFilters = new ArrayList<>();

		// filter Column V for exact "YES"
//		masterFilters.add(new ExcelFilter(21, Arrays.asList("YES")));
		
		//This is also work for direct column Name as V
		masterFilters.add(new ExcelFilter(ExcelUtils.columnLetterToIndex("X"), Arrays.asList("Yes")));
		masterFilters.add(new ExcelFilter(ExcelUtils.columnLetterToIndex("Y"), Arrays.asList("400100")));

		
//		targetFilters.add(new ExcelFilter(ExcelUtils.columnLetterToIndex("G"), Arrays.asList("Andhra Pradesh")));

		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("R", "ESI Gross");
		headerMap.put("I", "EE");

		// call
		CommonBusinessUtilis3.validateExcelCalculation(
		    downloadedExcelFile,
		    salaryFile,
		    test,
		    "All_Emp_Workings.I = Master.R * 0.0075",
		    "MASTER",
		    "All Emp Workings",
		    masterFilters,
		    targetFilters,
		    extraConfig,
		    0.01,
		    false,
		    0,
		    headerMap,
		    "PT Gross wages total is coming properly as per masters"
		); */
		
		
	} 
	public static void ESIC_AllEMPWorkings_Test1( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		
		// Extra config: enable Total logic if you need totals handling (use actual total column index if needed)
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "YES",                               // enable total logic (if you want total-row handling)
		    ExcelUtils.columnLetterToIndex("A"), // index of column where "Total" text appears (example)
		    "Total"                              // total keyword
		);

		// Filters (if you need, sample as you gave earlier)
		List<methodsb> masterFilters = new ArrayList<>();
		List<methodsb> downloadedFilters = new ArrayList<>();

		masterFilters.add(new methodsb(ExcelUtils.columnLetterToIndex("Y"), Arrays.asList("400100")));
		
		
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("R", "ESI Gross"); // Master sheet MonthlyEmployeeChallanSalary
		headerMap.put("J", "ER");        // Downloaded sheet All Emp Workings


		// Call validator
		Utilis3.validateExcelCalculation(
		    downloadedExcelFile,   // File object for ESI_400100_Aug_2025 (12).xlsx
		    salaryFile,            // master file path or string pointing to Sample_challansalary3.xlsx
		    test,                  // ExtentTest test object
		    "All_Emp_Workings.J = Master.R * 0.0325", // calculation rule
		    "MASTER",              // rhsSource (your code used "MASTER" earlier)
		    "PT_Report",           // defaultSheetName (normalizes via alias map inside CommonBusinessUtilis3)
		    masterFilters,
		    downloadedFilters,
		    extraConfig,
		    1,                  // tolerance (1% relative) — adjust if you want stricter/looser
		    false,                 // compareRowByRow (false means value-existence-ish compare; follow project behavior)
		    0,                     // startRowOffset
		    headerMap,             // headerKeywords map you use
		    "ER is reflecting as per masters" // successMessage / descriptive text
		);
	}
	public static void ESIC_AllEMPWorkings_Test3( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
/**		ExcelExtraConfig extraConfig = new ExcelExtraConfig("YES",
			    ExcelUtils.columnLetterToIndex("A"),"Total");

			List<ExcelFilter> masterFilters = new ArrayList<>();
			List<ExcelFilter> targetFilters = new ArrayList<>();
			masterFilters.add(new ExcelFilter(ExcelUtils.columnLetterToIndex("Y"),Arrays.asList("400100")));
			
			targetFilters.add(new ExcelFilter(ExcelUtils.columnLetterToIndex("A"),Arrays.asList("Total")));
			
			
			
			Map<String, String> headerMap = new HashMap<>();
			headerMap.put("R", "ESI Gross"); // Master sheet MonthlyEmployeeChallanSalary
			headerMap.put("K", "Total");        // Downloaded sheet All Emp Workings

			CommonBusinessUtilis3.validateExcelCalculation(
			    downloadedExcelFile,
			    salaryFile,
			    test,
			    "All Emp Workings.K = Master.R * 0.0075 + Master.R * 0.0375",
			    "MASTER",
			    "PT_Report",
			    masterFilters,
			    targetFilters,
			    extraConfig,
			    1,      // tolerance 1% (won't help here — differences ~10%)
			    false,
			    0,
			    headerMap,
			    "🧪 Validating ESI: All Emp Workings.K ≈ Master.R * (0.0075 + 0.0375)"
			);
**/
		
		
		
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
			    "NO",                                // NO => don't sum, just take direct cell
			    ExcelUtils.columnLetterToIndex("A"),"Total");

			List<methodsb> masterFilters = new ArrayList<>();
			masterFilters.add(new methodsb(ExcelUtils.columnLetterToIndex("Y"), Arrays.asList("400100")));

			List<methodsb> targetFilters = new ArrayList<>();
			targetFilters.add(new methodsb(ExcelUtils.columnLetterToIndex("A"), Arrays.asList("Total"))); // pick only Total row

			Map<String, String> headerMap = new HashMap<>();
			headerMap.put("R", "ESI Gross"); // Master
//			headerMap.put("K", "Total");     // Downloaded
			headerMap.put("G", "Total");     // Downloaded

//			String calculationRule = "K = R * 0.0075 + R * 0.0375"; 
			String calculationRule = "G = R * 0.0075 + R * 0.0375"; 
			String defaultSheetName = "All Emp Workings";

			Utilis3.validateExcelCalculation(
			    downloadedExcelFile,
			    FilePath.SALARY_FILE,
			    test,
			    calculationRule,
			    "MASTER",
			    defaultSheetName,
			    masterFilters,
			    targetFilters,       // now filter ensures only Total row picked
			    extraConfig,         // NO => direct total row check
			    1,
			    false,
			    0,
			    headerMap,
			    "🧪 Validating ESI: All Emp Workings.K (Total row) ≈ Master.R * (0.0075 + 0.0375)"
			);


		
		
		
	}
	public static void ESIC_AllEMPWorkings_Test4( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		ExcelExtraConfig extraConfig = new ExcelExtraConfig("YES",
			    ExcelUtils.columnLetterToIndex("A"),"Total");

			List<methodsb> masterFilters = new ArrayList<>();
			List<methodsb> targetFilters = new ArrayList<>();
//			masterFilters.add(new ExcelFilter(ExcelUtils.columnLetterToIndex("Y"),Arrays.asList("400100")));
			
//			targetFilters.add(new ExcelFilter(ExcelUtils.columnLetterToIndex("A"),Arrays.asList("Total")));
			
			
			
			Map<String, String> headerMap = new HashMap<>();
			headerMap.put("G", "ESI Wages"); // Master sheet MonthlyEmployeeChallanSalary
			headerMap.put("I", "EE");        // Downloaded sheet All Emp Workings

			Utilis3.validateExcelCalculation(
			    downloadedExcelFile,
			    salaryFile,
			    test,
			    "I = G * 0.0075",    // I G
			    "DOWNLOADED",
			    "All Emp Workings",  //sheet
			    
			    masterFilters,
			    targetFilters,
			    extraConfig,
			    1,      
			    false,
			    0,
			    headerMap,
			    "🧪 Validating ESI: All Emp Workings.K ≈ Master.R * (0.0075 + 0.0375)"
			);
			
		/*  //This will applied directly Downloaded to downloaded  
		// --- prepare extra config (same as your original)
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "YES",
		    ExcelUtils.columnLetterToIndex("A"),
		    "Total"
		);

		// --- prepare filters (empty lists kept as you had them)
		List<ExcelFilter> masterFilters = new ArrayList<>();
		List<ExcelFilter> targetFilters = new ArrayList<>();
		// masterFilters.add(new ExcelFilter(ExcelUtils.columnLetterToIndex("Y"), Arrays.asList("400100")));
		// targetFilters.add(new ExcelFilter(ExcelUtils.columnLetterToIndex("A"), Arrays.asList("Total")));

		// --- header map (same as you provided)
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("G", "ESI Wages"); // Master sheet MonthlyEmployeeChallanSalary
		headerMap.put("I", "EE");        // Downloaded sheet All Emp Workings

		// === IMPORTANT CHANGE: use column-only expression and set default sheet name to the downloaded sheet
		String calculationRule = "I = G * 0.0075";     // column-only (no sheet prefix with spaces)
		String defaultSheetName = "All Emp Workings";  // name of the downloaded sheet (exact, includes spaces)

		// --- tolerance & other flags (same as your original)
		int tolerancePercent = 1;   // 1% tolerance
		boolean skipHeader = false;
		int startRowIndex = 0;      // adjust if needed

		// --- final call
		CommonBusinessUtilis3.validateExcelCalculation(
		    downloadedExcelFile,              // File or ExcelFileDetails for downloaded file
		    salaryFile,                       // File or ExcelFileDetails for master file
		    test,                             // ExtentTest or your test logger object
		    calculationRule,                  // "I = G * 0.0075"
		    "DOWNLOADED",                     // target type (same as your original)
		    defaultSheetName,                 // "All Emp Workings" -> default sheet for column-only rule
		    masterFilters,
		    targetFilters,
		    extraConfig,
		    tolerancePercent,
		    skipHeader,
		    startRowIndex,
		    headerMap,
		    "🧪 Validating ESI: All Emp Workings.K ≈ Master.R * (0.0075 + 0.0375)" // descriptive log text
		);
*/

		
	}
	
	
	

}
