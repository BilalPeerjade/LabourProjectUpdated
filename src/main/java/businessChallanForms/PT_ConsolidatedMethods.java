package businessChallanForms;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
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
import java.util.Map.Entry;
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
import formsCalculations.PT_Methods;
import formsCalculations.formLocators;
import login.BasePage;
import login.LoginLocators;
import performer.PerformerLocator;
import rcp.OneCommonMethod;
import utils.ExcelExtraConfig;
import utils.ExcelFileDetails;
import utils.ExcelF;
import utils.ExcelTargetValidation;
import utils.ExcelUtils;
import utils.ExcelValueNormalizer;
import utils.HTMLBuilder;


//--
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.aventstack.extentreports.Status;


public class PT_ConsolidatedMethods extends BasePage {
	
	static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour.xlsx";
	
	public static File downloadedExcelFile; // shared file for all test cases
	


//	public static String EMPmasterFilePath = "D:\\Upload Automation Files\\BusinessScenarios\\Month\\EmployeeMaster_TESTAUTO.xlsx";

	//DOCAUTOO4
	public static String EMPmasterFilePath = "D:\\Upload Automation Files\\BusinessScenarios\\DOCAUTOO4\\EmployeeMaster.xlsx";
//	public static String salaryFile = "D:\\Upload Automation Files\\BusinessScenarios\\DOCAUTOO4\\#1 Aug2025\\Sample_challanSalary.xlsx";
	public static String salaryFile = "D:\\Upload Automation Files\\BusinessScenarios\\DOCAUTOO4\\#1 Aug2025\\Sample_challansalary3.xlsx";
	
	
//	public static String salaryFile = "D:\\Upload Automation Files\\BusinessScenarios\\Month\\SampleSalary_TESTAUTO.xlsx";
	
	
	
	public static String salaryFile_NAEmployee = "D:\\Upload Automation Files\\BusinessScenarios\\Month\\SampleSalaryNAEmployeeTESTAUTO.xlsx";
	
	public static String EmployeeMaster_NAEmployee = "D:\\Upload Automation Files\\BusinessScenarios\\Month\\Filtered\\EmployeeMaster_NAEmployee_TESTAUTO.xlsx";
	
	
	//Calculation report:
//	public static boolean ENABLE_HTML_REPORT_TABLE = true;
	
    // Turn on/off once here; calling time pe kuch pass karne ki zarurat nahi
//    public static boolean ENABLE_HTML_REPORT_TABLE_Calculation = true;
	
	public static void ChallanPTConsolated_Redirection( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.Search()));
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,formLocators.Search(),"DOCAUTOO4");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		formLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		formLocators.clickStatutoryDoc().click();
		Thread.sleep(2000);
		formLocators.clickComplianceType().click();
		Thread.sleep(2000);
		formLocators.selectComplianceChallan().click();
		Thread.sleep(2000);
		formLocators.clickAct2().click();
		Thread.sleep(2000);
		formLocators.selectCompliancePT().click();
		Thread.sleep(2000);
		formLocators.clickYear().click();
		Thread.sleep(2000);
		formLocators.Year2025().click();
		Thread.sleep(2000);
		formLocators.clickPeriod().click();
		Thread.sleep(2000);
		formLocators.selectMonthAugust().click();
		
		Thread.sleep(2000);
		formLocators.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		formLocators.Apply().click();
		Thread.sleep(6000);
		Thread.sleep(7000);
		
		
		
		
        // Step 1: Manually download file
		formLocators.PT_ConsolatedWorking().click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
	}
	
	
	public static void ChallanPTConsolated_PTReport_EmployeeIds( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.Search()));
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,formLocators.Search(),"DOCAUTOO4");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		formLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		formLocators.clickStatutoryDoc().click();
		Thread.sleep(2000);
		formLocators.clickComplianceType().click();
		Thread.sleep(2000);
		formLocators.selectComplianceChallan().click();
		Thread.sleep(2000);
		formLocators.clickAct2().click();
		Thread.sleep(2000);
		formLocators.selectCompliancePT().click();
		Thread.sleep(2000);
		formLocators.clickYear().click();
		Thread.sleep(2000);
		formLocators.Year2025().click();
		Thread.sleep(2000);
		formLocators.clickPeriod().click();
		Thread.sleep(2000);
		formLocators.selectMonthAugust().click();
		
		Thread.sleep(2000);
		formLocators.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		formLocators.Apply().click();
		Thread.sleep(6000);
		Thread.sleep(7000);
		
		
		
		
        // Step 1: Manually download file
		formLocators.PT_ConsolatedWorking().click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
        
/*        // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 38;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("Active"); 
        
        ExcelFilter regionFilter = new ExcelFilter(filterColumnIndex, filterValues);
        List<ExcelFilter> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	EMPmasterFilePath,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "NO"
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PT Report";
        int targetColumnIndex = 1;
        String targetHeaderKeyword = "Employee ID";
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
        CommonBusinessUtilis.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters!"
        );
		*/
        
        
     // 📌 Step 1: Prepare MULTI filters for Master (0-based indices)
        List<ExcelF> allFilters = new ArrayList<>();

        // Example filter-1: Status (column 38) == "Active"
        allFilters.add(new ExcelF(38, Arrays.asList("Active")));

        // Example filter-2:
        allFilters.add(new ExcelF(58, Arrays.asList("Yes")));

        // 🗂️ Step 2: Master file details
        String masterSheetName   = "EmployeeMaster";
        int masterColumnIndex    = 3;  // e.g., EmpID/Name column used by your utility (0-based)
        String applyFilterFlag   = "YES"; // << IMPORTANT: to enable applying the filters

        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
                EMPmasterFilePath,
                masterSheetName,
                masterColumnIndex,
                allFilters,
                applyFilterFlag
        );

        // 🎯 Step 3: Target validation (downloaded file)
        String targetSheetName      = "PT Report";
        int targetColumnIndex       = 1;             // 0-based (e.g., column B)
        String targetHeaderKeyword  = "Employee ID"; // header text to locate column/row
        int targetStartRow          = 0;

        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
                targetSheetName,
                targetColumnIndex,
                targetHeaderKeyword,
                targetStartRow
        );

        // ⚙️ Step 4: Extra config (no total logic in this scenario)
        String totalLogicEnabled = "NO"; // keep NO if you don't want total-row flow
        int totalColumnIndex     = 0;
        String totalKeyword      = "";

        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
                totalLogicEnabled,
                totalColumnIndex,
                totalKeyword
        );

        // ✅ Step 5: Final call
        UtilisOne.validateExcelBusinessData(
                downloadedExcelFile,
                test,
                masterFileDetails,
                targetValidation,
                extraConfig,
                "Employee IDs are reflecting properly as per masters! (multi-filter)"
        );
        
        
        
	}
	
	public static void ChallanPTConsolated_PTReport_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.Search()));
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,formLocators.Search(),"DOCAUTOO4");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		formLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		formLocators.clickStatutoryDoc().click();
		Thread.sleep(2000);
		formLocators.clickComplianceType().click();
		Thread.sleep(2000);
		formLocators.selectComplianceChallan().click();
		Thread.sleep(2000);
		formLocators.clickAct2().click();
		Thread.sleep(2000);
		formLocators.selectCompliancePT().click();
		Thread.sleep(2000);
		formLocators.clickYear().click();
		Thread.sleep(2000);
		formLocators.Year2025().click();
		Thread.sleep(2000);
		formLocators.clickPeriod().click();
		Thread.sleep(2000);
		formLocators.selectMonthAugust().click();
		
		Thread.sleep(2000);
		formLocators.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		formLocators.Apply().click();
		Thread.sleep(6000);
		Thread.sleep(7000);
		
		
		
		
        // Step 1: Manually download file
		formLocators.PT_ConsolatedWorking().click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
     // 🎯 Step 1: Prepare Target validation first (Downloaded file details)
        String targetHeaderKeyword = "Emp Name";
        int targetColumnIndex = 2;
        String targetSheetName = "PT Report";
        int targetStartRow = 0;

        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            targetSheetName,
            targetColumnIndex,
            targetHeaderKeyword,
            targetStartRow
        );

        // 🧪 Step 2: Prepare Master file filters
        List<ExcelF> allFilters = new ArrayList<>();

        // Filter-1:
        allFilters.add(new ExcelF(38, Arrays.asList("Active")));

        // Filter-2:
        allFilters.add(new ExcelF(58, Arrays.asList("Yes")));

        // 📊 Step 3: Prepare Master file details
        int masterColumnIndex = 5;
        String masterSheetName = "EmployeeMaster";

        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            EMPmasterFilePath,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "YES"   // ⚡ changed to YES because filters are now present
        );

        // 🛠️ Step 4: Extra Config — No total logic
        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
            "", 0, ""
        );

        // ✅ Step 5: Final call to reusable validator
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee Names are reflecting properly as per masters!"
        );

        
        
        
        
 /*       // 🎯 Step 1: Prepare Target validation first (Downloaded file details)
        String targetHeaderKeyword = "Emp Name";
        int targetColumnIndex = 2;
        String targetSheetName = "PT Report";
        int targetStartRow = 0;

        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            targetSheetName,
            targetColumnIndex,
            targetHeaderKeyword,
            targetStartRow
        );

        // 🧪 Step 2: Prepare Master file filters
        List<String> filterValues = Arrays.asList("KAR");
        ExcelFilter regionFilter = new ExcelFilter(6, filterValues);
        List<ExcelFilter> allFilters = Collections.singletonList(regionFilter);

        // 📊 Step 3: Prepare Master file details
        int masterColumnIndex = 5;
        String masterSheetName = "EmployeeMaster";

        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            EMPmasterFilePath,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "NO"
        );

        // 🛠️ Step 4: Extra Config — No total logic
        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
            "", 0, ""
        );

        // ✅ Step 5: Final call to reusable validator
        CommonBusinessUtilis.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee Names are reflecting properly as per masters!"
        ); */
		
	}
	
	public static void ChallanPTConsolated_PTReport_DOJ( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.Search()));
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,formLocators.Search(),"TESTAUTO");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		formLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		formLocators.clickStatutoryDoc().click();
		Thread.sleep(2000);
		formLocators.clickComplianceType().click();
		Thread.sleep(2000);
		formLocators.selectComplianceChallan().click();
		Thread.sleep(2000);
		formLocators.clickAct2().click();
		Thread.sleep(2000);
		formLocators.selectCompliancePT().click();
		Thread.sleep(2000);
		formLocators.clickYear().click();
		Thread.sleep(2000);
		formLocators.Year2024().click();
		Thread.sleep(2000);
		formLocators.clickPeriod().click();
		Thread.sleep(2000);
		formLocators.selectMonthJan().click();
		
		Thread.sleep(2000);
		formLocators.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		formLocators.Apply().click();
		Thread.sleep(6000);
		Thread.sleep(7000);
		
		
		
		
        // Step 1: Manually download file
		formLocators.PT_ConsolatedWorking().click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        

        
        
        // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 6;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("KAR");

        ExcelF regionFilter = new ExcelF(filterColumnIndex, filterValues);
        List<ExcelF> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 15;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	EMPmasterFilePath,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "NO"
        );
        
        

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PT Report";
        int targetColumnIndex = 3;
        String targetHeaderKeyword = "DOJ";
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
        
     // ✅ Enable Smart Text Match + Date Match
        extraConfig.setEnableSmartTextMatch("YES"); // GUJ↔Gujarat, Female↔FeMale
        extraConfig.setEnableDateMatch("NO");      // 01-01-2025 ↔ 01-Jan-2025

        // ✅ Step 7: Final call to reusable validator
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "DOJ (Date Of Joinings) are reflecting properly as per masters!"
        );
		
	}
	
	public static void ChallanPTConsolated_PTReport_Gender( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.Search()));
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,formLocators.Search(),"DOCAUTOO4");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		formLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		formLocators.clickStatutoryDoc().click();
		Thread.sleep(2000);
		formLocators.clickComplianceType().click();
		Thread.sleep(2000);
		formLocators.selectComplianceChallan().click();
		Thread.sleep(2000);
		formLocators.clickAct2().click();
		Thread.sleep(2000);
		formLocators.selectCompliancePT().click();
		Thread.sleep(2000);
		formLocators.clickYear().click();
		Thread.sleep(2000);
		formLocators.Year2025().click();
		Thread.sleep(2000);
		formLocators.clickPeriod().click();
		Thread.sleep(2000);
		formLocators.selectMonthAugust().click();
		
		Thread.sleep(2000);
		formLocators.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		formLocators.Apply().click();
		Thread.sleep(6000);
		Thread.sleep(7000);
		
		
		
		
        // Step 1: Manually download file
		formLocators.PT_ConsolatedWorking().click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
        //
//        ExcelExtraConfig extraConfig = new ExcelExtraConfig();
//        extraConfig.setEnableSmartTextMatch("YES"); // Enable smart match
//        
//
//        
//        ExcelExtraConfig extraConfig = new ExcelExtraConfig();
//        extraConfig.setEnableSmartTextMatch("YES"); // For loose matching
//        extraConfig.setEnableDateMatch("YES");      // For date normalization

        
        
        
        
        
        
     // 🧪 Step 3: Prepare master file filters
        List<ExcelF> allFilters = new ArrayList<>();

        // Filter-2: Status filter (column 38) == "Active"
        allFilters.add(new ExcelF(38, Arrays.asList("Active")));

        // Filter-3: Another filter (column 58) == "Yes"
        allFilters.add(new ExcelF(58, Arrays.asList("Yes")));

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 10;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            EMPmasterFilePath,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "YES"   // ⚡ use YES since filters are applied
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PT Report";
        int targetColumnIndex = 5;
        String targetHeaderKeyword = "Gender";
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

        // ✅ Enable Smart Text Match + Date Match
        extraConfig.setEnableSmartTextMatch("YES"); // GUJ↔Gujarat, Female↔FeMale
        extraConfig.setEnableDateMatch("NO");      // 01-01-2025 ↔ 01-Jan-2025

        // ✅ Step 7: Final call to reusable validator
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Genders are reflecting properly as per masters!"
        );

		
	}
	public static void ChallanPTConsolated_NAE_Gender( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.Search()));
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,formLocators.Search(),"DOCAUTOO4");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		formLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		formLocators.clickStatutoryDoc().click();
		Thread.sleep(2000);
		formLocators.clickComplianceType().click();
		Thread.sleep(2000);
		formLocators.selectComplianceChallan().click();
		Thread.sleep(2000);
		formLocators.clickAct2().click();
		Thread.sleep(2000);
		formLocators.selectCompliancePT().click();
		Thread.sleep(2000);
		formLocators.clickYear().click();
		Thread.sleep(2000);
		formLocators.Year2025().click();
		Thread.sleep(2000);
		formLocators.clickPeriod().click();
		Thread.sleep(2000);
		formLocators.selectMonthAugust().click();
		
		Thread.sleep(2000);
		formLocators.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		formLocators.Apply().click();
		Thread.sleep(6000);
		Thread.sleep(7000);
		
		
		
		
        // Step 1: Manually download file
		formLocators.PT_ConsolatedWorking().click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        

        
        
        
        // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 58;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("No");

        ExcelF regionFilter = new ExcelF(filterColumnIndex, filterValues);
        List<ExcelF> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 10;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	
        	FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "Yes"
        );
        
        

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PT Report";
        int targetColumnIndex = 5;
        String targetHeaderKeyword = "Gender";
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
        
     // ✅ Enable Smart Text Match + Date Match
        extraConfig.setEnableSmartTextMatch("YES"); // GUJ↔Gujarat, Female↔FeMale
        extraConfig.setEnableDateMatch("NO");      // 01-01-2025 ↔ 01-Jan-2025

        // ✅ Step 7: Final call to reusable validator
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Genders are reflecting properly as per masters!"
        );
		
	}
	
	public static void ChallanPTConsolated_PTReport_Branch( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.Search()));
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,formLocators.Search(),"DOCAUTOO4");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		formLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		formLocators.clickStatutoryDoc().click();
		Thread.sleep(2000);
		formLocators.clickComplianceType().click();
		Thread.sleep(2000);
		formLocators.selectComplianceChallan().click();
		Thread.sleep(2000);
		formLocators.clickAct2().click();
		Thread.sleep(2000);
		formLocators.selectCompliancePT().click();
		Thread.sleep(2000);
		formLocators.clickYear().click();
		Thread.sleep(2000);
		formLocators.Year2025().click();
		Thread.sleep(2000);
		formLocators.clickPeriod().click();
		Thread.sleep(2000);
		formLocators.selectMonthAugust().click();
		
		Thread.sleep(2000);
		formLocators.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		formLocators.Apply().click();
		Thread.sleep(6000);
		Thread.sleep(7000);
		
		
		
		
        // Step 1: Manually download file
		formLocators.PT_ConsolatedWorking().click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        

        
        
        
        
        
        
     // 🧪 Step 3: Prepare master file filters
        List<ExcelF> allFilters = new ArrayList<>();

        // Filter-1: Status filter (column 38) == "Active"
        allFilters.add(new ExcelF(38, Arrays.asList("Active")));

        // Filter-2: Another filter (column 58) == "Yes"
        allFilters.add(new ExcelF(58, Arrays.asList("Yes")));

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 8;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            EMPmasterFilePath,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "YES"   // ⚡ filters ko enable karna zaroori hai
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PT Report";
        int targetColumnIndex = 7;
        String targetHeaderKeyword = "Branch";
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

        // ✅ Enable Smart Text Match + Date Match
        extraConfig.setEnableSmartTextMatch("YES"); // GUJ↔Gujarat, Female↔FeMale
        extraConfig.setEnableDateMatch("YES");      // 01-01-2025 ↔ 01-Jan-2025

        // ✅ Step 7: Final call to reusable validator
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Branches are reflecting properly as per masters!"
        );

		
	}
	
	public static void ChallanPTConsolated_PTReport_PTGrossWages( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.Search()));
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,formLocators.Search(),"DOCAUTOO4");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		formLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		formLocators.clickStatutoryDoc().click();
		Thread.sleep(2000);
		formLocators.clickComplianceType().click();
		Thread.sleep(2000);
		formLocators.selectComplianceChallan().click();
		Thread.sleep(2000);
		formLocators.clickAct2().click();
		Thread.sleep(2000);
		formLocators.selectCompliancePT().click();
		Thread.sleep(2000);
		formLocators.clickYear().click();
		Thread.sleep(2000);
		formLocators.Year2025().click();
		Thread.sleep(2000);
		formLocators.clickPeriod().click();
		Thread.sleep(2000);
		formLocators.selectMonthAugust().click();
		
		Thread.sleep(2000);
		formLocators.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		formLocators.Apply().click();
		Thread.sleep(6000);
		Thread.sleep(7000);
		
		
		
		
        // Step 1: Manually download file
		formLocators.PT_ConsolatedWorking().click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
        
        
     // 🧪 Step 3: Prepare master file filters
        List<ExcelF> allFilters = new ArrayList<>();

        // Filter-1: 20
//        allFilters.add(new ExcelF(21, Arrays.asList("Yes")));
        
        allFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("AC"),Arrays.asList("Yes")));


        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "MonthlyEmployeeChallanSalary";
        int masterColumnIndex = 16;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            FilePath.SALARY_FILE,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "YES"   // ⚡ Filters ko apply karne ke liye YES
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PT Report";
        int targetColumnIndex = 8;
        String targetHeaderKeyword = "PT Gross wages";
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

        // ✅ Enable Smart Text Match + Date Match (optional)
        // extraConfig.setEnableSmartTextMatch("NO");
        // extraConfig.setEnableDateMatch("NO");

        // ✅ Step 7: Final call to reusable validator
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "PT Gross wages are reflecting properly as per masters!"
        );

		
	}
	
	public static void ChallanPTConsolated_PTReport_PTGrossWagesTotal( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		ChallanPTConsolated_Redirection(test,user);

		
		
		// Extra config me total logic enable kar de
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "YES",                               // enable total logic
		    ExcelUtils.columnLetterToIndex("A"), // jis column me "Total" likha hota hai uska index (example: I)
		    "Total"                              // keyword jo sheet me likha hai
		);


		
		List<ExcelF> masterFilters = new ArrayList<>();
		List<ExcelF> targetFilters = new ArrayList<>();

		
		//This is also work for direct column Name as V
		masterFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("V"), Arrays.asList("YES")));
		


		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Q", "PT Gross");
		headerMap.put("I", "PT Gross wages");

		// call
		Utilis3.validateExcelCalculation(
		    downloadedExcelFile,
		    salaryFile,
		    test,
		    "PT_Report.I = Master.Q",
		    "MASTER",
		    "PT Report",
		    masterFilters,
		    targetFilters,
		    extraConfig,
		    0.01,
		    false,
		    0,
		    headerMap,
		    "PT Gross wages total is coming properly as per masters"
		);

		
		
	} 
	
	public static void ChallanPTConsolated_PTReport_ClientPTDeductionTOTAL( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
//		ChallanPTConsolated_Redirection(test,user);
		
		
		// Extra config me total logic enable kar de
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "YES",                               // enable total logic
		    ExcelUtils.columnLetterToIndex("A"), // jis column me "Total" likha hota hai uska index (example: I)
		    "Total"                              // keyword jo sheet me likha hai
		);

		// Filters 
		List<ExcelF> masterFilters = new ArrayList<>();
		
		
		List<ExcelF> targetFilters = new ArrayList<>();

		// Header map (optional, logs me accha dikhega)
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("H", "PT deduction");
		headerMap.put("J", "Client PT deduction");

		// ✅ Calling: Master.Q ka sum == Downloaded.I ka Total
		Utilis3.validateExcelCalculation(
		    downloadedExcelFile,              // File downloaded
		    salaryFile,                       // Master file
		    test,                             // ExtentTest
		    "PT_Report.J = Master.H",         // Expression
		    "MASTER",                         // rhsSource
		    "PT Report",                      // default sheet for downloaded
		    masterFilters,                    // filters for master
		    targetFilters,                    // filters for downloaded
		    extraConfig,                      // <-- total logic on
		    0.01,                             // tolerance
		    true,                            // row by row compare off
		    0,                                // start row offset
		    headerMap,                        // header labels
		    "Client PT Deduction total is coming properly as per masters"
		);

	}
	
	
	public static void ChallanPTConsolated_PTReport_ClientPTDeduction( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.Search()));
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,formLocators.Search(),"TESTAUTO");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		formLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		formLocators.clickStatutoryDoc().click();
		Thread.sleep(2000);
		formLocators.clickComplianceType().click();
		Thread.sleep(2000);
		formLocators.selectComplianceChallan().click();
		Thread.sleep(2000);
		formLocators.clickAct2().click();
		Thread.sleep(2000);
		formLocators.selectCompliancePT().click();
		Thread.sleep(2000);
		formLocators.clickYear().click();
		Thread.sleep(2000);
		formLocators.Year2024().click();
		Thread.sleep(2000);
		formLocators.clickPeriod().click();
		Thread.sleep(2000);
		formLocators.selectMonthJan().click();
		
		Thread.sleep(2000);
		formLocators.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		formLocators.Apply().click();
		Thread.sleep(6000);
		Thread.sleep(7000);
		
		
		
		
        // Step 1: Manually download file
		formLocators.PT_ConsolatedWorking().click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
        
        
        // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 6;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("KAR");

        ExcelF regionFilter = new ExcelF(filterColumnIndex, filterValues);
        List<ExcelF> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "MonthlyEmployeeSalary";
        int masterColumnIndex = 7;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	salaryFile,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "NO"
        );
        
        

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PT Report";
        int targetColumnIndex = 9;
        String targetHeaderKeyword = "Client PT deduction";
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
        
     // ✅ Enable Smart Text Match + Date Match
//        extraConfig.setEnableSmartTextMatch("NO"); // GUJ↔Gujarat, Female↔FeMale
 //       extraConfig.setEnableDateMatch("NO");      // 01-01-2025 ↔ 01-Jan-2025

        // ✅ Step 7: Final call to reusable validator
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Client PT deduction are reflecting properly as per masters!"
        );
		
	}
	
	public static void ChallanPTConsolated_PTReport_Diffrence( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.Search()));
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,formLocators.Search(),"DOCAUTOO4");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		formLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		formLocators.clickStatutoryDoc().click();
		Thread.sleep(2000);
		formLocators.clickComplianceType().click();
		Thread.sleep(2000);
		formLocators.selectComplianceChallan().click();
		Thread.sleep(2000);
		formLocators.clickAct2().click();
		Thread.sleep(2000);
		formLocators.selectCompliancePT().click();
		Thread.sleep(2000);
		formLocators.clickYear().click();
		Thread.sleep(2000);
		formLocators.Year2025().click();
		Thread.sleep(2000);
		formLocators.clickPeriod().click();
		Thread.sleep(2000);
		formLocators.selectMonthAug().click();
		
		Thread.sleep(2000);
		formLocators.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		formLocators.Apply().click();
		Thread.sleep(6000);
		Thread.sleep(7000);
		
		
		
		
        // Step 1: Manually download file
		formLocators.PT_ConsolatedWorking().click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
     // use ExcelUtils.columnLetterToIndex(...) method you've already added
     // If ExcelExtraConfig constructor is (String totalLogicEnabled, int totalColumnIndex, String totalKeyword)


        
        
        
        
     // filters (agar nahi hai to empty lists de)
 //       List<ExcelFilter> masterFilters = new ArrayList<>();
  //      List<ExcelFilter> targetFilters = new ArrayList<>();

        // header map (agar nahi hai to empty)
 //       Map<String,String> headerMap = new HashMap<>();
        
        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
                "YES",                               // enable total logic? "YES"/"NO"
                ExcelUtils.columnLetterToIndex("L"), // column index where "Total" keyword might be present (L -> 11)
                "Total"                              // total keyword (case-insensitive)
            );
        
        List<ExcelF> masterFilters = new ArrayList<>();   // add filters if needed
        List<ExcelF> targetFilters = new ArrayList<>();      
 //     masterFilters.add(new ExcelFilter(6, Arrays.asList("PUNE")));

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("H", "PT deduction");     // optional: header keywords per column letter
        headerMap.put("K", "PT amount(As per slab)");
        headerMap.put("L", "Diffrence");


        Utilis3.validateExcelCalculation(
        	    downloadedExcelFile,
        	    salaryFile,
        	    test,
        	    "PT_Report.L = Master.H - PT_Report.K",
        	    "MASTER",
        	    "PT Report",
        	    masterFilters,
        	    targetFilters,
        	    extraConfig,
        	    0.01,
        	    true,
        	    0,
        	    headerMap,
        	    "Validating Master.H - Downloaded.K = Downloaded.L"
        	);


        
		
	}
	
	public static void ChallanPTConsolated_NAE_Branch( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		
        
        
		ChallanPTConsolated_Redirection(test,user);
        
        
        // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 58;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("No");

        ExcelF regionFilter = new ExcelF(filterColumnIndex, filterValues);
        List<ExcelF> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 8;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "Yes"
        );
        
        

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "Non Applicable Employees";
        int targetColumnIndex = 7;
        String targetHeaderKeyword = "Branch";
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
        
     // ✅ Enable Smart Text Match + Date Match
        extraConfig.setEnableSmartTextMatch("YES"); // GUJ↔Gujarat, Female↔FeMale
        extraConfig.setEnableDateMatch("YES");      // 01-01-2025 ↔ 01-Jan-2025

        // ✅ Step 7: Final call to reusable validator
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Branches are reflecting properly as per masters!"
        );
		
	}
	
	public static void ChallanPTConsolated_NAE_ClientPTDeductionTOTAL( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		// Extra config me total logic enable kar de
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "YES",                               // enable total logic
		    ExcelUtils.columnLetterToIndex("A"), // jis column me "Total" likha hota hai uska index (example: I)
		    "Total"                              // keyword jo sheet me likha hai
		);

		// Filters 
		List<ExcelF> masterFilters = new ArrayList<>();
		masterFilters.add(new ExcelF(6, Arrays.asList("")));
		
		
		List<ExcelF> targetFilters = new ArrayList<>();

		// Header map (optional, logs me accha dikhega)
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("H", "PT deduction");
		headerMap.put("J", "Client PT deduction");

		// ✅ Calling: Master.Q ka sum == Downloaded.I ka Total
		Utilis3.validateExcelCalculation(
		    downloadedExcelFile,              // File downloaded
		    salaryFile_NAEmployee,                       // Master file
		    test,                             // ExtentTest
		    "Non_Applicable_Employees.J = Master.H",         // Expression
		    "MASTER",                         // rhsSource
		    "Non Applicable Employees",                      // default sheet for downloaded
		    masterFilters,                    // filters for master
		    targetFilters,                    // filters for downloaded
		    extraConfig,                      // <-- total logic on
		    0.01,                             // tolerance
		    false,                            // row by row compare off
		    0,                                // start row offset
		    headerMap,                        // header labels
		    "Client PT Deduction total is coming properly as per masters"
		);
		
	}
	
	public static void ChallanPTConsolated_NAE_PTGrossWagesTOTAL( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		
		// Extra config me total logic enable kar de
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "YES",                               // enable total logic
		    ExcelUtils.columnLetterToIndex("A"), // jis column me "Total" likha hota hai uska index (example: I)
		    "Total"                              // keyword jo sheet me likha hai
		);

		// Filters 
		List<ExcelF> masterFilters = new ArrayList<>();
		masterFilters.add(new ExcelF(6, Arrays.asList("")));
		
		
		List<ExcelF> targetFilters = new ArrayList<>();

		// Header map (optional, logs me accha dikhega)
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Q", "PT Gross");
		headerMap.put("I", "Client PT deduction");

		// ✅ Calling: Master.Q ka sum == Downloaded.I ka Total
		Utilis3.validateExcelCalculation(
		    downloadedExcelFile,              // File downloaded
		    salaryFile_NAEmployee,                       // Master file
		    test,                             // ExtentTest
		    "Non_Applicable_Employees.I = Master.Q",         // Expression
		    "MASTER",                         // rhsSource
		    "Non Applicable Employees",                      // default sheet for downloaded
		    masterFilters,                    // filters for master
		    targetFilters,                    // filters for downloaded
		    extraConfig,                      // <-- total logic on
		    0.01,                             // tolerance
		    false,                            // row by row compare off
		    0,                                // start row offset
		    headerMap,                        // header labels
		    "PT Gross wages TOTAL is coming properly as per masters"
		);
		
	}
	
	public static void ChallanPTConsolated_NAE_PTGrossWages( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		ChallanPTConsolated_Redirection(test,user);
		
//		PT_ConsolidatedMethods.validatePTAmounts(downloadedExcelFile, test);
		
		test.log(LogStatus.INFO,
			    "ℹ️ LOGIC GIVEN: PT values are derived from backend slab rules based on employee gross wages and state-wise PT rules. " +
			    "Each state has different slabs. For states like MAHARASHTRA, ODISHA, MADHYA PRADESH, JAMMU & KASHMIR, and KARNATAKA, " +
			    "the PT amount increases in 2nd+ generation runs as per backend rules. " +
			    "Additionally, for MAHARASHTRA Female employees: Gross ≤ 25000 → PT = 0, Gross > 25000 → PT = 200.");
		
		
		Map<String, Integer> runCounts = new HashMap<>();
		runCounts.put("MAHARASHTRA", 1);
		runCounts.put("MADHYA PRADESH", 1);
		runCounts.put("ODISHA", 1);
		runCounts.put("JAMMU & KASHMIR", 1);
		runCounts.put("KARNATAKA", 1);

		PT_ConsolidatedMethods.validatePTAmountsUpdatedFlexible(downloadedExcelFile, test, runCounts);

        
		
	}
	
	
	
	
/**	// ====== Unified validator with integrated diagnostics ======
	public static void validatePTAmountsUpdatedFlexible(
	        File downloadedExcelFile,
	        ExtentTest test,
	        Map<String, Integer> stateRunCounts) {
		
		//
	    // ----- normalize stateRunCounts keys and log (prevents caller-case-mismatch) -----
	    Map<String, Integer> normalizedRunCounts = new HashMap<>();
	    if (stateRunCounts != null && !stateRunCounts.isEmpty()) {
	        for (Map.Entry<String, Integer> e : stateRunCounts.entrySet()) {
	            String k = e.getKey();
	            if (k == null) continue;
	            normalizedRunCounts.put(k.trim().toUpperCase(), e.getValue());
	        }
	    }
	    stateRunCounts = normalizedRunCounts;
	    test.log(LogStatus.INFO, "State run-counts (normalized): " + stateRunCounts.toString());
	    // -------------------------------------------------------------------------------

		
		
		
		
		
		
		
		

	    try (FileInputStream fis = new FileInputStream(downloadedExcelFile);
	         Workbook wb = WorkbookFactory.create(fis)) {

	        // 1) Pick sheet safely
	        Sheet sheet = wb.getSheet("PT Report");
	        if (sheet == null) sheet = wb.getSheet("PTChallan");
	        if (sheet == null) sheet = wb.getNumberOfSheets() > 0 ? wb.getSheetAt(0) : null;

	        if (sheet == null) {
	            test.log(LogStatus.ERROR, "❌ No sheet found (expected 'PT Report' or 'PTChallan') in: " + downloadedExcelFile.getName());
	            return;
	        }

	        // 2) Header row
	        Row header = sheet.getRow(0);
	        if (header == null) {
	            test.log(LogStatus.ERROR, "❌ Header row missing in sheet: " + sheet.getSheetName());
	            return;
	        }

	        // 3) Resolve columns by header text (case-insensitive contains match)
	        int colState   = findColIndex(header, "PT State", "Client PT State", "PTState");
	        int colGender  = findColIndex(header, "Gender");
	        int colGross   = findColIndex(header, "PT Gross wages", "Gross", "PT Gross");
	        int colPT      = findColIndex(header, "PT amount(As per slab)", "PT amount", "PT Amount");

	        // Optional columns to detect TOTAL rows
	        int colEmpName = findColIndex(header, "Emp Name", "Employee Name", "Employee");
	        int colSlNo    = findColIndex(header, "Sl No", "S.No", "Sr No", "Sr.No");

	        if (colState < 0 || colGender < 0 || colGross < 0 || colPT < 0) {
	            test.log(LogStatus.ERROR,
	                    "❌ Required columns not found. Need headers like: " +
	                    "[PT State/Client PT State], [Gender], [PT Gross wages], [PT amount/PT amount(As per slab)]. " +
	                    "Found in sheet: " + sheet.getSheetName());
	            return;
	        }

	        // 4) Per-state counters & override counters
	        Map<String, Integer> stateRowCount = new HashMap<>();
	        Map<String, Integer> stateMismatchCount = new HashMap<>();
	        Map<String, Set<Integer>> statePTValues = new HashMap<>();
	        Map<String, Integer> overrideCounters = new HashMap<>();

	        // Diagnostics maps
	        Map<String, Integer> diagStateTotal = new HashMap<>();
	        Map<String, Map<Integer,Integer>> diagBaseCount = new HashMap<>();
	        Map<String, Map<Integer,Integer>> diagActualCount = new HashMap<>();
	        Map<String, Integer> diagWouldOverride = new HashMap<>();

	        int skippedTotalRows = 0;

	        int last = sheet.getLastRowNum();
	        for (int r = 1; r <= last; r++) { // skip header
	            Row row = sheet.getRow(r);
	            if (row == null) continue;

	            try {
	                String state  = getString(row.getCell(colState));
	                String gender = getString(row.getCell(colGender));
	                Double grossD = getNumeric(row.getCell(colGross));
	                Double actual = getNumeric(row.getCell(colPT));

	                // --- skip rows with blank/unknown state ---
	                if (state == null || state.trim().isEmpty()) {
	                    skippedTotalRows++;
	                    continue;
	                }

	                // --- skip typical TOTAL rows (by name or serial) ---
	                boolean isTotalRow = false;
	                if (!isTotalRow && colEmpName >= 0) {
	                    String empName = getString(row.getCell(colEmpName));
	                    if (empName != null && empName.trim().toLowerCase().contains("total")) isTotalRow = true;
	                }
	                if (!isTotalRow && colSlNo >= 0) {
	                    String slNo = getString(row.getCell(colSlNo));
	                    if (slNo != null && slNo.trim().toLowerCase().contains("total")) isTotalRow = true;
	                }
	                if (isTotalRow) {
	                    skippedTotalRows++;
	                    continue;
	                }

	                // --- basic sanity on numbers ---
	                if (gender == null || grossD == null || actual == null) {
	                    test.log(LogStatus.WARNING, "⚠ Row " + (r + 1) + " skipped (missing/invalid data).");
	                    continue;
	                }
	                if (grossD <= 0) {
	                    skippedTotalRows++;
	                    continue;           // ignore garbage
	                }
	                if (actual < 0 || actual > 5000) { // PT unrealistic guard
	                    skippedTotalRows++;
	                    continue;
	                }

	                // Normalize state key for maps
	                String stKey = state.trim().toUpperCase();

	                // 5) Base PT from backend slab
	                int basePT = ExcelValueNormalizer.getPTAmount(state, grossD.intValue());

	                // 6) Per-state runCount (default 1)
	                int runCount = 1;
	                if (stateRunCounts != null && !stateRunCounts.isEmpty()) {
	                    runCount = stateRunCounts.getOrDefault(stKey, 1);
	                }

	                // 7) Compute expected PT and update override counters
	                int expectedPT = applyStateOverridesAggregated(state, basePT, grossD, gender, runCount, overrideCounters);

	                // 8) Update main counters
	                stateRowCount.put(state, stateRowCount.getOrDefault(state, 0) + 1);
	                if (expectedPT != actual.intValue()) {
	                    stateMismatchCount.put(state, stateMismatchCount.getOrDefault(state, 0) + 1);
	                }
	                statePTValues.computeIfAbsent(state, k -> new HashSet<>()).add(actual.intValue());

	                // ---------- Diagnostics collection ----------
	                // total
	                diagStateTotal.put(stKey, diagStateTotal.getOrDefault(stKey, 0) + 1);

	                // base distribution
	                diagBaseCount.computeIfAbsent(stKey, k -> new HashMap<>());
	                Map<Integer,Integer> bm = diagBaseCount.get(stKey);
	                bm.put(basePT, bm.getOrDefault(basePT, 0) + 1);

	                // actual distribution
	                diagActualCount.computeIfAbsent(stKey, k -> new HashMap<>());
	                Map<Integer,Integer> am = diagActualCount.get(stKey);
	                am.put(actual.intValue(), am.getOrDefault(actual.intValue(), 0) + 1);

	                // would override?
	                int wouldBe = applyStateOverridesAggregated(state, basePT, grossD, gender, runCount, new HashMap<>());
	                if (wouldBe != basePT) {
	                    diagWouldOverride.put(stKey, diagWouldOverride.getOrDefault(stKey, 0) + 1);
	                }
	                // ---------- end diagnostics ----------

	            } catch (Exception ex) {
	                test.log(LogStatus.WARNING, "⚠ Row " + (r + 1) + " error: " + ex.getMessage());
	            }
	        }

	        // 9) Final summary per state
	        for (String state : stateRowCount.keySet()) {
	            int totalRows = stateRowCount.get(state);
	            int mismatches = stateMismatchCount.getOrDefault(state, 0);
	            Set<Integer> ptValues = statePTValues.getOrDefault(state, new HashSet<>());

	            if (mismatches == 0) {
	                test.log(LogStatus.PASS, "✅ State " + state.toUpperCase() +
	                        " | All " + totalRows + " rows matched as per masters. | PT Values: " + ptValues);
	            } else {
	                test.log(LogStatus.FAIL, "❌ State " + state.toUpperCase() +
	                        " | " + mismatches + " out of " + totalRows +
	                        " rows mismatched as per masters. | PT Values: " + ptValues);
	            }
	        }

	        // 10) Aggregated override counters
	        for (Entry<String, Integer> e : overrideCounters.entrySet()) {
	            test.log(LogStatus.INFO, e.getKey() + " | Count = " + e.getValue());
	        }

	        // 11) Diagnostics logging (one block)
	        logPerStateDiagnostics(diagStateTotal, diagBaseCount, diagActualCount, diagWouldOverride, test);

	        // 12) Optional debug line: how many TOTAL/blank rows were skipped
	        if (skippedTotalRows > 0) {
	            test.log(LogStatus.INFO, "Skipped TOTAL/blank rows: " + skippedTotalRows);
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.ERROR, "❌ Exception in validatePTAmountsUpdatedFlexible: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	// ====== Helper: apply overrides and aggregate counts (no per-row INFO spam) ======
	private static int applyStateOverridesAggregated(
	        String state,
	        int expectedPT,
	        double gross,
	        String gender,
	        int runCount,
	        Map<String, Integer> counters) {

	    int finalPT = expectedPT;
	    String st = (state == null) ? "" : state.trim().toUpperCase();

	    switch (st) {
	        case "MAHARASHTRA":
	            if ("FEMALE".equalsIgnoreCase(gender)) {
	                if (gross <= 25000) {
	                    finalPT = 0;
	                    bump(counters, "Maharashtra Female | Gross ≤ 25000 | PT = 0");
	                } else {
	                    finalPT = 200;
	                    bump(counters, "Maharashtra Female | Gross > 25000 | PT = 200");
	                }
	            }
	            if (runCount >= 2 && expectedPT == 200) {
	                finalPT = 300;
	                bump(counters, "Maharashtra 2nd+ run override → PT = 300");
	            }
	            break;

	        case "ODISHA":
	            if (runCount >= 2 && expectedPT == 200) {
	                finalPT = 300;
	                bump(counters, "Odisha 2nd+ run override → PT = 300");
	            }
	            break;

	        case "MADHYA PRADESH":
	            if (runCount >= 2) {
	                if (expectedPT == 166) {
	                    finalPT = 174;
	                    bump(counters, "Madhya Pradesh 2nd+ run override → 166 → 174");
	                } else if (expectedPT == 208) {
	                    finalPT = 212;
	                    bump(counters, "Madhya Pradesh 2nd+ run override → 208 → 212");
	                }
	            }
	            break;

	        case "JAMMU & KASHMIR":
	            if (runCount >= 2 && expectedPT == 208) {
	                finalPT = 212;
	                bump(counters, "J&K 2nd+ run override → 208 → 212");
	            }
	            break;

	        case "KARNATAKA":
	            if (runCount >= 2 && expectedPT == 200) {
	                finalPT = 300;
	                bump(counters, "Karnataka 2nd+ run override → 200 → 300");
	            }
	            break;
	    }
	    return finalPT;
	}

	// ====== Diagnostics logger ======
	private static void logPerStateDiagnostics(
	        Map<String, Integer> stateTotal,
	        Map<String, Map<Integer, Integer>> stateBasePTCount,
	        Map<String, Map<Integer, Integer>> stateActualPTCount,
	        Map<String, Integer> stateWouldBeOverridden,
	        ExtentTest test) {

	    test.log(LogStatus.INFO, "----- PER-STATE DIAGNOSTICS START -----");
	    for (String st : stateTotal.keySet()) {
	        int total = stateTotal.getOrDefault(st, 0);
	        Map<Integer,Integer> baseMap = stateBasePTCount.getOrDefault(st, new HashMap<>());
	        Map<Integer,Integer> actualMap = stateActualPTCount.getOrDefault(st, new HashMap<>());
	        int overridden = stateWouldBeOverridden.getOrDefault(st, 0);

	        StringBuilder sb = new StringBuilder();
	        sb.append("State ").append(st).append(" | Total rows: ").append(total)
	          .append(" | OverriddenCandidates: ").append(overridden)
	          .append(" | BasePT distribution: ").append(baseMap.toString())
	          .append(" | ActualPT distribution: ").append(actualMap.toString());

	        test.log(LogStatus.INFO, sb.toString());
	    }
	    test.log(LogStatus.INFO, "----- PER-STATE DIAGNOSTICS END -----");
	}

	// ====== Small helpers ======
	private static void bump(Map<String, Integer> map, String key) {
	    map.put(key, map.getOrDefault(key, 0) + 1);
	}

	private static int findColIndex(Row header, String... candidates) {
	    for (Cell c : header) {
	        String h = getString(c);
	        if (h == null) continue;
	        for (String cand : candidates) {
	            if (h.equalsIgnoreCase(cand) || h.toLowerCase().contains(cand.toLowerCase())) {
	                return c.getColumnIndex();
	            }
	        }
	    }
	    return -1;
	}

	private static String getString(Cell cell) {
	    if (cell == null) return null;
	    CellType t = cell.getCellType();
	    if (t == CellType.STRING)  return cell.getStringCellValue().trim();
	    if (t == CellType.NUMERIC) return String.valueOf((long) cell.getNumericCellValue());
	    if (t == CellType.BOOLEAN) return String.valueOf(cell.getBooleanCellValue());
	    return null;
	}

	private static Double getNumeric(Cell cell) {
	    if (cell == null) return null;
	    CellType t = cell.getCellType();
	    if (t == CellType.NUMERIC) return cell.getNumericCellValue();
	    if (t == CellType.STRING) {
	        try { return Double.parseDouble(cell.getStringCellValue().trim()); }
	        catch (Exception ignore) { return null; }
	    }
	    return null;
	}

**/
	
	
	
	
	
	
	
	
	
	
	
	// ====== Unified validator with integrated diagnostics and PT-value counts ======
	public static void validatePTAmountsUpdatedFlexible(
	        File downloadedExcelFile,
	        ExtentTest test,
	        Map<String, Integer> stateRunCounts) {

	    try (FileInputStream fis = new FileInputStream(downloadedExcelFile);
	         Workbook wb = WorkbookFactory.create(fis)) {

	        // 1) Pick sheet safely
	        Sheet sheet = wb.getSheet("PT Report");
	        if (sheet == null) sheet = wb.getSheet("PTChallan");
	        if (sheet == null) sheet = wb.getNumberOfSheets() > 0 ? wb.getSheetAt(0) : null;

	        if (sheet == null) {
	            test.log(LogStatus.ERROR, "❌ No sheet found (expected 'PT Report' or 'PTChallan') in: " + downloadedExcelFile.getName());
	            return;
	        }

	        // 2) Header row
	        Row header = sheet.getRow(0);
	        if (header == null) {
	            test.log(LogStatus.ERROR, "❌ Header row missing in sheet: " + sheet.getSheetName());
	            return;
	        }

	        // 3) Resolve columns by header text (case-insensitive contains match)
	        int colState   = findColIndex(header, "PT State", "Client PT State", "PTState");
	        int colGender  = findColIndex(header, "Gender");
	        int colGross   = findColIndex(header, "PT Gross wages", "Gross", "PT Gross");
	        int colPT      = findColIndex(header, "PT amount(As per slab)", "PT amount", "PT Amount");

	        // Optional columns to detect TOTAL rows
	        int colEmpName = findColIndex(header, "Emp Name", "Employee Name", "Employee");
	        int colSlNo    = findColIndex(header, "Sl No", "S.No", "Sr No", "Sr.No");

	        if (colState < 0 || colGender < 0 || colGross < 0 || colPT < 0) {
	            test.log(LogStatus.ERROR,
	                    "❌ Required columns not found. Need headers like: " +
	                    "[PT State/Client PT State], [Gender], [PT Gross wages], [PT amount/PT amount(As per slab)]. " +
	                    "Found in sheet: " + sheet.getSheetName());
	            return;
	        }

	        // 4) Per-state counters & override counters
	        Map<String, Integer> stateRowCount = new HashMap<>();
	        Map<String, Integer> stateMismatchCount = new HashMap<>();
	        // state -> (ptValue -> count)
	        Map<String, Map<Integer, Integer>> statePTValueCounts = new HashMap<>();
	        Map<String, Integer> overrideCounters = new HashMap<>();

	        // Diagnostics maps
	        Map<String, Integer> diagStateTotal = new HashMap<>();
	        Map<String, Map<Integer,Integer>> diagBaseCount = new HashMap<>();
	        Map<String, Map<Integer,Integer>> diagActualCount = new HashMap<>();
	        Map<String, Integer> diagWouldOverride = new HashMap<>();

	        int skippedTotalRows = 0;

	        int last = sheet.getLastRowNum();
	        for (int r = 1; r <= last; r++) { // skip header
	            Row row = sheet.getRow(r);
	            if (row == null) continue;

	            try {
	                String state  = getString(row.getCell(colState));
	                String gender = getString(row.getCell(colGender));
	                Double grossD = getNumeric(row.getCell(colGross));
	                Double actual = getNumeric(row.getCell(colPT));

	                // --- skip rows with blank/unknown state ---
	                if (state == null || state.trim().isEmpty()) {
	                    skippedTotalRows++;
	                    continue;
	                }

	                // --- skip typical TOTAL rows (by name or serial) ---
	                boolean isTotalRow = false;
	                if (!isTotalRow && colEmpName >= 0) {
	                    String empName = getString(row.getCell(colEmpName));
	                    if (empName != null && empName.trim().toLowerCase().contains("total")) isTotalRow = true;
	                }
	                if (!isTotalRow && colSlNo >= 0) {
	                    String slNo = getString(row.getCell(colSlNo));
	                    if (slNo != null && slNo.trim().toLowerCase().contains("total")) isTotalRow = true;
	                }
	                if (isTotalRow) {
	                    skippedTotalRows++;
	                    continue;
	                }

	                // --- basic sanity on numbers ---
	                if (gender == null || grossD == null || actual == null) {
	                    test.log(LogStatus.WARNING, "⚠ Row " + (r + 1) + " skipped (missing/invalid data).");
	                    continue;
	                }
	                if (grossD <= 0) {
	                    skippedTotalRows++;
	                    continue;           // ignore garbage
	                }
	                if (actual < 0 || actual > 5000) { // PT unrealistic guard
	                    skippedTotalRows++;
	                    continue;
	                }

	                // Normalize state key for maps
	                String stKey = state.trim().toUpperCase();

	                // 5) Base PT from backend slab
	                int basePT = ExcelValueNormalizer.getPTAmount(state, grossD.intValue());

	                // 6) Per-state runCount (default 1)
	                int runCount = 1;
	                if (stateRunCounts != null && !stateRunCounts.isEmpty()) {
	                    runCount = stateRunCounts.getOrDefault(stKey, 1);
	                }

	                // 7) Compute expected PT and update override counters
	                int expectedPT = applyStateOverridesAggregated(state, basePT, grossD, gender, runCount, overrideCounters);

	                // 8) Update main counters
	                stateRowCount.put(state, stateRowCount.getOrDefault(state, 0) + 1);
	                if (expectedPT != actual.intValue()) {
	                    stateMismatchCount.put(state, stateMismatchCount.getOrDefault(state, 0) + 1);
	                }

	                // update PT counts per state
	                int actualPTInt = actual.intValue();
	                statePTValueCounts.computeIfAbsent(state, k -> new HashMap<>());
	                Map<Integer,Integer> ptCountMap = statePTValueCounts.get(state);
	                ptCountMap.put(actualPTInt, ptCountMap.getOrDefault(actualPTInt, 0) + 1);

	                // ---------- Diagnostics collection ----------
	                // total
	                diagStateTotal.put(stKey, diagStateTotal.getOrDefault(stKey, 0) + 1);

	                // base distribution
	                diagBaseCount.computeIfAbsent(stKey, k -> new HashMap<>());
	                Map<Integer,Integer> bm = diagBaseCount.get(stKey);
	                bm.put(basePT, bm.getOrDefault(basePT, 0) + 1);

	                // actual distribution
	                diagActualCount.computeIfAbsent(stKey, k -> new HashMap<>());
	                Map<Integer,Integer> am = diagActualCount.get(stKey);
	                am.put(actualPTInt, am.getOrDefault(actualPTInt, 0) + 1);

	                // would override?
	                int wouldBe = applyStateOverridesAggregated(state, basePT, grossD, gender, runCount, new HashMap<>());
	                if (wouldBe != basePT) {
	                    diagWouldOverride.put(stKey, diagWouldOverride.getOrDefault(stKey, 0) + 1);
	                }
	                // ---------- end diagnostics ----------

	            } catch (Exception ex) {
	                test.log(LogStatus.WARNING, "⚠ Row " + (r + 1) + " error: " + ex.getMessage());
	            }
	        }

	        // 9) Final summary per state (with PT counts)
	        for (String state : stateRowCount.keySet()) {
	            int totalRows = stateRowCount.get(state);
	            int mismatches = stateMismatchCount.getOrDefault(state, 0);
	            Map<Integer,Integer> ptCounts = statePTValueCounts.getOrDefault(state, new HashMap<>());

	            // Format PT values as: [0:217, 200:339] sorted by PT value ascending
	            List<Integer> sortedKeys = new ArrayList<>(ptCounts.keySet());
	            Collections.sort(sortedKeys);
	            StringBuilder ptSummary = new StringBuilder();
	            ptSummary.append("[");
	            boolean first = true;
	            for (Integer k : sortedKeys) {
	                if (!first) ptSummary.append(", ");
	                ptSummary.append("").append(k).append(" : <b>").append(ptCounts.get(k)).append("</b>");
	                first = false;
	            }
	            ptSummary.append("]");

	            if (mismatches == 0) {
	                test.log(LogStatus.PASS, "✅ State " + state.toUpperCase() +
	                        " | All Employee count <b>" + totalRows + "</b> rows matched as per backend logic. | PT Values: " + ptSummary.toString());
	            } else {
	                test.log(LogStatus.FAIL, "❌ State " + state.toUpperCase() +
	                        " | " + mismatches + " out of " + totalRows +
	                        " rows mismatched as per backend logic. | PT Values: " + ptSummary.toString());
	            }
	        }

	        // 10) Aggregated override counters
	        for (Entry<String, Integer> e : overrideCounters.entrySet()) {
	            test.log(LogStatus.INFO, e.getKey() + " | Count = " + e.getValue());
	        }

	        // 11) Diagnostics logging (one block)
//	        logPerStateDiagnostics(diagStateTotal, diagBaseCount, diagActualCount, diagWouldOverride, test);

	        // 12) Optional debug line: how many TOTAL/blank rows were skipped
	        if (skippedTotalRows > 0) {
	            test.log(LogStatus.INFO, "Skipped TOTAL/blank rows: " + skippedTotalRows);
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.ERROR, "❌ Exception in validatePTAmountsUpdatedFlexible: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	// ====== Helper: apply overrides and aggregate counts (no per-row INFO spam) ======
	private static int applyStateOverridesAggregated(
	        String state,
	        int expectedPT,
	        double gross,
	        String gender,
	        int runCount,
	        Map<String, Integer> counters) {

	    int finalPT = expectedPT;
	    String st = (state == null) ? "" : state.trim().toUpperCase();

	    switch (st) {
	        case "MAHARASHTRA":
	            if ("FEMALE".equalsIgnoreCase(gender)) {
	                if (gross <= 25000) {
	                    finalPT = 0;
	                    bump(counters, "Maharashtra Female | Gross ≤ 25000 | PT = 0");
	                } else {
	                    finalPT = 200;
	                    bump(counters, "Maharashtra Female | Gross > 25000 | PT = 200");
	                }
	            }
	            if (runCount >= 2 && expectedPT == 200) {
	                finalPT = 300;
	                bump(counters, "Maharashtra 2nd+ run override → PT = 300");
	            }
	            break;

	        case "ODISHA":
	            if (runCount >= 2 && expectedPT == 200) {
	                finalPT = 300;
	                bump(counters, "Odisha 2nd+ run override → PT = 300");
	            }
	            break;

	        case "MADHYA PRADESH":
	            if (runCount >= 2) {
	                if (expectedPT == 166) {
	                    finalPT = 174;
	                    bump(counters, "Madhya Pradesh 2nd+ run override → 166 → 174");
	                } else if (expectedPT == 208) {
	                    finalPT = 212;
	                    bump(counters, "Madhya Pradesh 2nd+ run override → 208 → 212");
	                }
	            }
	            break;

	        case "JAMMU & KASHMIR":
	            if (runCount >= 2 && expectedPT == 208) {
	                finalPT = 212;
	                bump(counters, "J&K 2nd+ run override → 208 → 212");
	            }
	            break;

	        case "KARNATAKA":
	            if (runCount >= 2 && expectedPT == 200) {
	                finalPT = 300;
	                bump(counters, "Karnataka 2nd+ run override → 200 → 300");
	            }
	            break;
	    }
	    return finalPT;
	}

	// ====== Diagnostics logger ======
	private static void logPerStateDiagnostics(
	        Map<String, Integer> stateTotal,
	        Map<String, Map<Integer, Integer>> stateBasePTCount,
	        Map<String, Map<Integer, Integer>> stateActualPTCount,
	        Map<String, Integer> stateWouldBeOverridden,
	        ExtentTest test) {

	    test.log(LogStatus.INFO, "----- PER-STATE DIAGNOSTICS START -----");
	    for (String st : stateTotal.keySet()) {
	        int total = stateTotal.getOrDefault(st, 0);
	        Map<Integer,Integer> baseMap = stateBasePTCount.getOrDefault(st, new HashMap<>());
	        Map<Integer,Integer> actualMap = stateActualPTCount.getOrDefault(st, new HashMap<>());
	        int overridden = stateWouldBeOverridden.getOrDefault(st, 0);

	        StringBuilder sb = new StringBuilder();
	        sb.append("State ").append(st).append(" | Total rows: ").append(total)
	          .append(" | OverriddenCandidates: ").append(overridden)
	          .append(" | BasePT distribution: ").append(baseMap.toString())
	          .append(" | ActualPT distribution: ").append(actualMap.toString());

	        test.log(LogStatus.INFO, sb.toString());
	    }
	    test.log(LogStatus.INFO, "----- PER-STATE DIAGNOSTICS END -----");
	}

	/// ====== Small helpers ======
	private static void bump(Map<String, Integer> map, String key) {
	    map.put(key, map.getOrDefault(key, 0) + 1);
	}

	private static int findColIndex(Row header, String... candidates) {
	    for (Cell c : header) {
	        String h = getString(c);
	        if (h == null) continue;
	        for (String cand : candidates) {
	            if (h.equalsIgnoreCase(cand) || h.toLowerCase().contains(cand.toLowerCase())) {
	                return c.getColumnIndex();
	            }
	        }
	    }
	    return -1;
	}

	private static String getString(Cell cell) {
	    if (cell == null) return null;
	    CellType t = cell.getCellType();
	    if (t == CellType.STRING)  return cell.getStringCellValue().trim();
	    if (t == CellType.NUMERIC) return String.valueOf((long) cell.getNumericCellValue());
	    if (t == CellType.BOOLEAN) return String.valueOf(cell.getBooleanCellValue());
	    return null;
	}

	private static Double getNumeric(Cell cell) {
	    if (cell == null) return null;
	    CellType t = cell.getCellType();
	    if (t == CellType.NUMERIC) return cell.getNumericCellValue();
	    if (t == CellType.STRING) {
	        try { return Double.parseDouble(cell.getStringCellValue().trim()); }
	        catch (Exception ignore) { return null; }
	    }
	    return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	// ====== Unified validator: works for both "PT Report" (consolidated) and "PTChallan" (state-wise) ======
//	public static void validatePTAmountsUpdatedFlexible(
//	        File downloadedExcelFile,
//	        ExtentTest test,
//	        Map<String, Integer> stateRunCounts) {
//
//	    try (FileInputStream fis = new FileInputStream(downloadedExcelFile);
//	         Workbook wb = WorkbookFactory.create(fis)) {
//
//	        // 1) Pick sheet safely
//	        Sheet sheet = wb.getSheet("PT Report");
//	        if (sheet == null) sheet = wb.getSheet("PTChallan");
//	        if (sheet == null) sheet = wb.getNumberOfSheets() > 0 ? wb.getSheetAt(0) : null;
//
//	        if (sheet == null) {
//	            test.log(LogStatus.ERROR, "❌ No sheet found (expected 'PT Report' or 'PTChallan') in: " + downloadedExcelFile.getName());
//	            return;
//	        }
//
//	        // 2) Header row
//	        Row header = sheet.getRow(0);
//	        if (header == null) {
//	            test.log(LogStatus.ERROR, "❌ Header row missing in sheet: " + sheet.getSheetName());
//	            return;
//	        }
//
//	        // 3) Resolve columns by header text (case-insensitive contains match)
//	        int colState   = findColIndex(header, "PT State", "Client PT State");
//	        int colGender  = findColIndex(header, "Gender");
//	        int colGross   = findColIndex(header, "PT Gross wages", "Gross");
//	        int colPT      = findColIndex(header, "PT amount(As per slab)", "PT amount");
//
//	        // Optional columns to detect TOTAL rows
//	        int colEmpName = findColIndex(header, "Emp Name", "Employee Name", "Employee");
//	        int colSlNo    = findColIndex(header, "Sl No", "S.No", "Sr No", "Sr.No");
//
//	        if (colState < 0 || colGender < 0 || colGross < 0 || colPT < 0) {
//	            test.log(LogStatus.ERROR,
//	                    "❌ Required columns not found. Need headers like: " +
//	                    "[PT State/Client PT State], [Gender], [PT Gross wages], [PT amount/PT amount(As per slab)]. " +
//	                    "Found in sheet: " + sheet.getSheetName());
//	            return;
//	        }
//
//	        // 4) Per-state counters
//	        Map<String, Integer> stateRowCount = new HashMap<>();
//	        Map<String, Integer> stateMismatchCount = new HashMap<>();
//	        Map<String, Set<Integer>> statePTValues = new HashMap<>();
//
//	        // Aggregated override counters (one line per rule with Count)
//	        Map<String, Integer> overrideCounters = new HashMap<>();
//
//	        int last = sheet.getLastRowNum();
//	        for (int r = 1; r <= last; r++) { // skip header
//	            Row row = sheet.getRow(r);
//	            if (row == null) continue;
//
//	            try {
//	                String state  = getString(row.getCell(colState));
//	                String gender = getString(row.getCell(colGender));
//	                Double grossD = getNumeric(row.getCell(colGross));
//	                Double actual = getNumeric(row.getCell(colPT));
//
//	                // --- skip rows with blank/unknown state ---
//	                if (state == null || state.trim().isEmpty()) {
//	                    // likely TOTAL / summary row → skip silently
//	                    continue;
//	                }
//
//	                // --- skip typical TOTAL rows (by name or serial) ---
//	                boolean isTotalRow = false;
//	                if (!isTotalRow && colEmpName >= 0) {
//	                    String empName = getString(row.getCell(colEmpName));
//	                    if (empName != null && empName.trim().toLowerCase().contains("total")) isTotalRow = true;
//	                }
//	                if (!isTotalRow && colSlNo >= 0) {
//	                    String slNo = getString(row.getCell(colSlNo));
//	                    if (slNo != null && slNo.trim().toLowerCase().contains("total")) isTotalRow = true;
//	                }
//	                if (isTotalRow) continue;
//
//	                // --- basic sanity on numbers ---
//	                if (gender == null || grossD == null || actual == null) {
//	                    test.log(LogStatus.WARNING, "⚠ Row " + (r + 1) + " skipped (missing/invalid data).");
//	                    continue;
//	                }
//	                if (grossD <= 0) continue;           // ignore garbage
//	                if (actual < 0 || actual > 5000) {   // PT cannot be massive; ignore summary spillovers
//	                    continue;
//	                }
//
//	                // 5) Base PT from backend slab (ExcelValueNormalizer expects int gross)
//	                int basePT = ExcelValueNormalizer.getPTAmount(state, grossD.intValue());
//
//	                // 6) Per-state runCount (default 1)
//	                int runCount = 1;
//	                if (stateRunCounts != null && !stateRunCounts.isEmpty()) {
//	                    runCount = stateRunCounts.getOrDefault(state.trim().toUpperCase(), 1);
//	                }
//
//	                // 7) Apply overrides (with aggregated counters)
//	                int expectedPT = applyStateOverridesAggregated(
//	                        state, basePT, grossD, gender, runCount, overrideCounters);
//
//	                // 8) Update state counters
//	                stateRowCount.put(state, stateRowCount.getOrDefault(state, 0) + 1);
//	                if (expectedPT != actual.intValue()) {
//	                    stateMismatchCount.put(state, stateMismatchCount.getOrDefault(state, 0) + 1);
//	                }
//	                statePTValues.computeIfAbsent(state, k -> new HashSet<>()).add(actual.intValue());
//
//	            } catch (Exception ex) {
//	                test.log(LogStatus.WARNING, "⚠ Row " + (r + 1) + " error: " + ex.getMessage());
//	            }
//	        }
//
//	        // 9) Final summary per state
//	        for (String state : stateRowCount.keySet()) {
//	            int totalRows = stateRowCount.get(state);
//	            int mismatches = stateMismatchCount.getOrDefault(state, 0);
//	            Set<Integer> ptValues = statePTValues.getOrDefault(state, new HashSet<>());
//
//	            if (mismatches == 0) {
//	                test.log(LogStatus.PASS, "✅ State " + state.toUpperCase() +
//	                        " | All Employee count <b>" + totalRows + "</b> rows matched as per backend logic. | PT Values: " + ptValues);
//	            } else {
//	                test.log(LogStatus.FAIL, "❌ State " + state.toUpperCase() +
//	                        " | " + mismatches + " out of " + totalRows +
//	                        " rows mismatched as per backend logic. | PT Values: " + ptValues);
//	            }
//	        }
//
//	        // 10) Aggregated override counters
//	        for (Map.Entry<String, Integer> e : overrideCounters.entrySet()) {
//	            test.log(LogStatus.INFO, e.getKey() + " | Count = " + e.getValue());
//	        }
//
//	    } catch (Exception e) {
//	        test.log(LogStatus.ERROR, "❌ Exception in validatePTAmountsUpdatedFlexible: " + e.getMessage());
//	        e.printStackTrace();
//	    }
//	}
//
//
//	// ====== Helper: apply overrides and aggregate counts (no per-row INFO spam) ======
//	private static int applyStateOverridesAggregated(
//	        String state,
//	        int expectedPT,
//	        double gross,
//	        String gender,
//	        int runCount,
//	        Map<String, Integer> counters) {
//
//	    int finalPT = expectedPT;
//	    String st = (state == null) ? "" : state.trim().toUpperCase();
//
//	    switch (st) {
//	        case "MAHARASHTRA":
//	            if ("FEMALE".equalsIgnoreCase(gender)) {
//	                if (gross <= 25000) {
//	                    finalPT = 0;
//	                    bump(counters, "Maharashtra Female | Gross ≤ 25000 | PT = 0");
//	                } else {
//	                    finalPT = 200;
//	                    bump(counters, "Maharashtra Female | Gross > 25000 | PT = 200");
//	                }
//	            }
//	            if (runCount >= 2 && expectedPT == 200) {
//	                finalPT = 300;
//	                bump(counters, "Maharashtra 2nd+ run override → PT = 300");
//	            }
//	            break;
//
//	        case "ODISHA":
//	            if (runCount >= 2 && expectedPT == 200) {
//	                finalPT = 300;
//	                bump(counters, "Odisha 2nd+ run override → PT = 300");
//	            }
//	            break;
//
//	        case "MADHYA PRADESH":
//	        	if("MADHYA PRADESH".equalsIgnoreCase(st)) {
//	            if (runCount >= 2) {
//	                if (expectedPT == 166) {
//	                    finalPT = 174;
//	                    bump(counters, "Madhya Pradesh 2nd+ run override → 166 → 174");
//	                } else if (expectedPT == 208) {
//	                    finalPT = 212;
//	                    bump(counters, "Madhya Pradesh 2nd+ run override → 208 → 212");
//	                }
//	            }
//	        	}
//	            break;
//
//	        case "JAMMU & KASHMIR":
//	            if (runCount >= 2 && expectedPT == 208) {
//	                finalPT = 212;
//	                bump(counters, "J&K 2nd+ run override → 208 → 212");
//	            }
//	            break;
//
//	        case "KARNATAKA":
//	            if (runCount >= 2 && expectedPT == 200) {
//	                finalPT = 300;
//	                bump(counters, "Karnataka 2nd+ run override → 200 → 300");
//	            }
//	            break;
//	    }
//	    return finalPT;
//	}
//
//	// ====== Small helpers ======
//	private static void bump(Map<String, Integer> map, String key) {
//	    map.put(key, map.getOrDefault(key, 0) + 1);
//	}
//
//	private static int findColIndex(Row header, String... candidates) {
//	    for (Cell c : header) {
//	        String h = getString(c);
//	        if (h == null) continue;
//	        for (String cand : candidates) {
//	            if (h.equalsIgnoreCase(cand) || h.toLowerCase().contains(cand.toLowerCase())) {
//	                return c.getColumnIndex();
//	            }
//	        }
//	    }
//	    return -1;
//	}
//
//	private static String getString(Cell cell) {
//	    if (cell == null) return null;
//	    switch (cell.getCellType()) {
//	        case STRING:  return cell.getStringCellValue().trim();
//	        case NUMERIC: return String.valueOf((long) cell.getNumericCellValue());
//	        case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
//	        default: return null;
//	    }
//	}
//
//	private static Double getNumeric(Cell cell) {
//	    if (cell == null) return null;
//	    switch (cell.getCellType()) {
//	        case NUMERIC: return cell.getNumericCellValue();
//	        case STRING:
//	            try { return Double.parseDouble(cell.getStringCellValue().trim()); }
//	            catch (Exception ignore) { return null; }
//	        default: return null;
//	    }
//	}

	
	
	
	
	
	
	
	
	
/*
	public static void validatePTAmountsUpdated(
	        File downloadedExcelFile,
	        ExtentTest test,
	        Map<String, Integer> stateRunCounts) {

	    try (FileInputStream fis = new FileInputStream(downloadedExcelFile);
	         Workbook wb = WorkbookFactory.create(fis)) {

	        Sheet sheet = wb.getSheet("PT Report");
	        if (sheet == null) {
	            test.log(LogStatus.ERROR, "❌ Sheet 'PT Report' not found in file: " + downloadedExcelFile.getName());
	            return;
	        }

	        // Track counts & values per state
	        Map<String, Integer> stateRowCount = new HashMap<>();
	        Map<String, Integer> stateMismatchCount = new HashMap<>();
	        Map<String, Set<Integer>> statePTValues = new HashMap<>();

	        // 🔹 Aggregated override counters
	        Map<String, Integer> overrideCounters = new HashMap<>();

	        for (Row row : sheet) {
	            if (row.getRowNum() == 0) continue; // skip header

	            try {
	                // State (col index 6 = G)
	                Cell stateCell = row.getCell(6);
	                if (stateCell == null) continue;
	                String state = stateCell.getStringCellValue().trim();

	                // Gender (col index 5 = F)
	                Cell genderCell = row.getCell(5);
	                String gender = (genderCell != null) ? genderCell.getStringCellValue().trim() : "";

	                // Gross Wages (col index 8 = I)
	                Cell grossCell = row.getCell(8);
	                if (grossCell == null) continue;
	                double gross = grossCell.getNumericCellValue();

	                // Actual PT Amount (col index 10 = K)
	                Cell ptCell = row.getCell(10);
	                if (ptCell == null) continue;
	                double actualPT = ptCell.getNumericCellValue();

	                // Base PT slab from backend
	                int basePT = ExcelValueNormalizer.getPTAmount(state, (int) gross);

	                // State-specific run count (default = 1)
	                int runCount = stateRunCounts.getOrDefault(state.toUpperCase(), 1);

	                // Apply overrides (with counter tracking)
	                int expectedPT = applyStateOverrides(
	                        state, basePT, gross, gender, runCount, overrideCounters);

	                // Row counters
	                stateRowCount.put(state, stateRowCount.getOrDefault(state, 0) + 1);
	                if (expectedPT != (int) actualPT) {
	                    stateMismatchCount.put(state, stateMismatchCount.getOrDefault(state, 0) + 1);
	                }

	                // Collect unique PT values
	                statePTValues.computeIfAbsent(state, k -> new HashSet<>()).add((int) actualPT);

	            } catch (Exception ex) {
	                test.log(LogStatus.WARNING, "⚠ Row " + (row.getRowNum() + 1) +
	                        " skipped due to error: " + ex.getMessage());
	            }
	        }

	        // Final summary per state
	        for (String state : stateRowCount.keySet()) {
	            int totalRows = stateRowCount.get(state);
	            int mismatches = stateMismatchCount.getOrDefault(state, 0);
	            Set<Integer> ptValues = statePTValues.getOrDefault(state, new HashSet<>());

	            if (mismatches == 0) {
	                test.log(LogStatus.PASS, "✅ State " + state.toUpperCase() +
	                        " | All " + totalRows + " rows matched as per masters." +
	                        " | PT Values: " + ptValues);
	            } else {
	                test.log(LogStatus.FAIL, "❌ State " + state.toUpperCase() +
	                        " | " + mismatches + " out of " + totalRows +
	                        " rows mismatched as per masters." +
	                        " | PT Values: " + ptValues);
	            }
	        }

	        // 🔹 Log aggregated override counters
	        for (Map.Entry<String,Integer> entry : overrideCounters.entrySet()) {
	            test.log(LogStatus.INFO, entry.getKey() + " | Count = " + entry.getValue());
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.ERROR, "❌ Exception in validatePTAmountsUpdated: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	// 🔹 Helper for overrides (aggregated logging only)
	private static int applyStateOverrides(
	        String state,
	        int expectedPT,
	        double gross,
	        String gender,
	        int runCount,
	        Map<String,Integer> overrideCounters) {

	    int finalPT = expectedPT;

	    switch (state.toUpperCase()) {
	        case "MAHARASHTRA":
	            if ("FEMALE".equalsIgnoreCase(gender)) {
	                if (gross <= 25000) {
	                    finalPT = 0;
	                    String key = "Maharashtra Female | Gross ≤ 25000 | PT = 0";
	                    overrideCounters.put(key, overrideCounters.getOrDefault(key, 0) + 1);
	                } else {
	                    finalPT = 200;
	                    String key = "Maharashtra Female | Gross > 25000 | PT = 200";
	                    overrideCounters.put(key, overrideCounters.getOrDefault(key, 0) + 1);
	                }
	            }
	            if (runCount >= 2 && expectedPT == 200) {
	                finalPT = 300;
	                String key = "Maharashtra 2nd+ run override → PT = 300";
	                overrideCounters.put(key, overrideCounters.getOrDefault(key, 0) + 1);
	            }
	            break;

	        case "ODISHA":
	            if (runCount >= 2 && expectedPT == 200) {
	                finalPT = 300;
	                String key = "Odisha 2nd+ run override → PT = 300";
	                overrideCounters.put(key, overrideCounters.getOrDefault(key, 0) + 1);
	            }
	            break;

	        case "MADHYA PRADESH":
	            if (runCount >= 2) {
	                if (expectedPT == 166) {
	                    finalPT = 174;
	                    String key = "Madhya Pradesh 2nd+ run override → 166 → 174";
	                    overrideCounters.put(key, overrideCounters.getOrDefault(key, 0) + 1);
	                } else if (expectedPT == 208) {
	                    finalPT = 212;
	                    String key = "Madhya Pradesh 2nd+ run override → 208 → 212";
	                    overrideCounters.put(key, overrideCounters.getOrDefault(key, 0) + 1);
	                }
	            }
	            break;

	        case "JAMMU & KASHMIR":
	            if (runCount >= 2 && expectedPT == 208) {
	                finalPT = 212;
	                String key = "J&K 2nd+ run override → 208 → 212";
	                overrideCounters.put(key, overrideCounters.getOrDefault(key, 0) + 1);
	            }
	            break;

	        case "KARNATAKA":
	            if (runCount >= 2 && expectedPT == 200) {
	                finalPT = 300;
	                String key = "Karnataka 2nd+ run override → 200 → 300";
	                overrideCounters.put(key, overrideCounters.getOrDefault(key, 0) + 1);
	            }
	            break;
	    }

	    return finalPT;
	}

	

*/


	
	

	
	
	
	
	public static void validatePTAmounts(File downloadedExcelFile, ExtentTest test) {
	    try (FileInputStream fis = new FileInputStream(downloadedExcelFile)) {
	        Workbook wb = WorkbookFactory.create(fis);
	        Sheet sheet = wb.getSheet("PT Report"); // ✅ tere sheet ka naam

	        // 🔹 Track counts & values per state
	        Map<String, Integer> stateRowCount = new HashMap<>();
	        Map<String, Integer> stateMismatchCount = new HashMap<>();
	        Map<String, Set<Integer>> statePTValues = new HashMap<>();

	        for (Row row : sheet) {
	            if (row.getRowNum() == 0) continue; // skip header

	            try {
	                // PT State (col CJ = index 87)
	                Cell stateCell = row.getCell(6);
	                if (stateCell == null) continue;
	                String state = stateCell.getStringCellValue().trim();

	                // Gross Wages (col G = index 6)
	                Cell grossCell = row.getCell(8);
	                if (grossCell == null) continue;
	                double gross = grossCell.getNumericCellValue();

	                // Actual PT Amount (col H = index 7)
	                Cell ptCell = row.getCell(10);
	                if (ptCell == null) continue;
	                double actualPT = ptCell.getNumericCellValue();

	                // Expected PT from helper
	                int expectedPT = ExcelValueNormalizer.getPTAmount(state, (int) gross);

	                // Row counters
	                stateRowCount.put(state, stateRowCount.getOrDefault(state, 0) + 1);
	                if (expectedPT != (int) actualPT) {
	                    stateMismatchCount.put(state, stateMismatchCount.getOrDefault(state, 0) + 1);
	                }

	                // Collect unique PT values per state
	                statePTValues.computeIfAbsent(state, k -> new HashSet<>()).add((int) actualPT);

	            } catch (Exception ex) {
	                test.log(LogStatus.WARNING, "⚠ Row " + (row.getRowNum() + 1) +
	                        " skipped due to error: " + ex.getMessage());
	            }
	        }

	        // 🔹 Final summary per state
	        for (String state : stateRowCount.keySet()) {
	            int totalRows = stateRowCount.get(state);
	            int mismatches = stateMismatchCount.getOrDefault(state, 0);
	            Set<Integer> ptValues = statePTValues.getOrDefault(state, new HashSet<>());

	            if (mismatches == 0) {
	                test.log(LogStatus.PASS, "✅ State " + state.toUpperCase() +
	                        " | All " + totalRows + " rows matched as per masters." +
	                        " | PT Values : " + ptValues);
	            } else {
	                test.log(LogStatus.FAIL, "❌ State " + state.toUpperCase() +
	                        " | " + mismatches + " out of " + totalRows +
	                        " rows mismatched as per masters." +
	                        " | PT Values: " + ptValues);
	            }
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.ERROR, "❌ Exception in validatePTAmounts: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	
	public static void ChallanPTConsolated_NAE_ClientPTDeduction( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{


        
		ChallanPTConsolated_Redirection(test,user);
        
        
        // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 6;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("");

        ExcelF regionFilter = new ExcelF(filterColumnIndex, filterValues);
        List<ExcelF> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "MonthlyEmployeeSalary";
        int masterColumnIndex = 7;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	salaryFile_NAEmployee,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "NO"
        );
        
        

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PT Report";
        int targetColumnIndex = 8;
        String targetHeaderKeyword = "Non Applicable Employees";
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
        
     // ✅ Enable Smart Text Match + Date Match
//        extraConfig.setEnableSmartTextMatch("NO"); // GUJ↔Gujarat, Female↔FeMale
 //       extraConfig.setEnableDateMatch("NO");      // 01-01-2025 ↔ 01-Jan-2025

        // ✅ Step 7: Final call to reusable validator
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Client PT deduction are reflecting properly as per masters!"
        );
		
	}
	public static void ChallanPTConsolated_NAE_EmployeeIds( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.Search()));
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,formLocators.Search(),"DOCAUTOO4");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		formLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		formLocators.clickStatutoryDoc().click();
		Thread.sleep(2000);
		formLocators.clickComplianceType().click();
		Thread.sleep(2000);
		formLocators.selectComplianceChallan().click();
		Thread.sleep(2000);
		formLocators.clickAct2().click();
		Thread.sleep(2000);
		formLocators.selectCompliancePT().click();
		Thread.sleep(2000);
		formLocators.clickYear().click();
		Thread.sleep(2000);
		formLocators.Year2025().click();
		Thread.sleep(2000);
		formLocators.clickPeriod().click();
		Thread.sleep(2000);
		formLocators.selectMonthAugust().click();
		
		Thread.sleep(2000);
		formLocators.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		formLocators.Apply().click();
		Thread.sleep(6000);
		Thread.sleep(7000);
		
		
		
		
        // Step 1: Manually download file
		formLocators.PT_ConsolatedWorking().click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
        //DOCAUTOO4:--
        
        // 📌 Step 1: Prepare MULTI filters for Master (0-based indices)
        List<ExcelF> allFilters = new ArrayList<>();

        // Example filter-1: Status (column 38) == "Active"
        allFilters.add(new ExcelF(38, Arrays.asList("Active")));

        // Example filter-2:
        allFilters.add(new ExcelF(58, Arrays.asList("No")));

        // 🗂️ Step 2: Master file details
        String masterSheetName   = "EmployeeMaster";
        int masterColumnIndex    = 3;  // e.g., EmpID/Name column used by your utility (0-based)
        String applyFilterFlag   = "YES"; // << IMPORTANT: to enable applying the filters

        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
    //          EMPmasterFilePath,
                FilePath.EMPLOYEE_MASTER,
                masterSheetName,
                masterColumnIndex,
                allFilters,
                applyFilterFlag
        );

        // 🎯 Step 3: Target validation (downloaded file)
        String targetSheetName      = "Non Applicable Employees";
        int targetColumnIndex       = 1;             // 0-based (e.g., column B)
        String targetHeaderKeyword  = "Employee ID"; // header text to locate column/row
        int targetStartRow          = 0;

        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
                targetSheetName,
                targetColumnIndex,
                targetHeaderKeyword,
                targetStartRow
        );

        // ⚙️ Step 4: Extra config (no total logic in this scenario)
        String totalLogicEnabled = "NO"; // keep NO if you don't want total-row flow
        int totalColumnIndex     = 0;
        String totalKeyword      = "";

        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
                totalLogicEnabled,
                totalColumnIndex,
                totalKeyword
        );

        // ✅ Step 5: Final call
        UtilisOne.validateExcelBusinessData(
                downloadedExcelFile,
                test,
                masterFileDetails,
                targetValidation,
                extraConfig,
                "Employee IDs are reflecting properly as per masters! (multi-filter)"
        );
        
        
        
        
        
        
  /*      // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 58;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("No"); //FiName
//      filterValues.add(""); //Blank

        ExcelFilter regionFilter = new ExcelFilter(filterColumnIndex, filterValues);
        List<ExcelFilter> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	EMPmasterFilePath,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "Yes"
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "Non Applicable Employees";
        int targetColumnIndex = 1;
        String targetHeaderKeyword = "Employee ID";
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
        CommonBusinessUtilis.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters!"
        );
		*/
	}
	public static void ChallanPTConsolated_NAE_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		WebDriverWait wait = new WebDriverWait(getDriver(), (120));
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.Search()));
		
		OneCommonMethod.searchEntityAndSelect(driver.get(),test,formLocators.Search(),"DOCAUTOO4");
		
		
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(formLocators.WorkspaceArrow()));
		Thread.sleep(2000);
		formLocators.WorkspaceArrow().click();
		Thread.sleep(2000);
		
		formLocators.clickStatutoryDoc().click();
		Thread.sleep(2000);
		formLocators.clickComplianceType().click();
		Thread.sleep(2000);
		formLocators.selectComplianceChallan().click();
		Thread.sleep(2000);
		formLocators.clickAct2().click();
		Thread.sleep(2000);
		formLocators.selectCompliancePT().click();
		Thread.sleep(2000);
		formLocators.clickYear().click();
		Thread.sleep(2000);
		formLocators.Year2025().click();
		Thread.sleep(2000);
		formLocators.clickPeriod().click();
		Thread.sleep(2000);
		formLocators.selectMonthAugust().click();
		
		Thread.sleep(2000);
		formLocators.clickBranch1().click();
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		formLocators.Apply().click();
		Thread.sleep(6000);
		Thread.sleep(7000);
		
		
		
		
        // Step 1: Manually download file
		formLocators.PT_ConsolatedWorking().click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
        // 🎯 Step 1: Prepare Target validation first (Downloaded file details)
        String targetHeaderKeyword = "Emp Name";
        int targetColumnIndex = 2;
        String targetSheetName = "Non Applicable Employees";
        int targetStartRow = 0;

        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            targetSheetName,
            targetColumnIndex,
            targetHeaderKeyword,
            targetStartRow
        );

        // 🧪 Step 2: Prepare Master file filters
        List<String> filterValues = Arrays.asList("No");
        ExcelF regionFilter = new ExcelF(58, filterValues);
        List<ExcelF> allFilters = Collections.singletonList(regionFilter);

        // 📊 Step 3: Prepare Master file details
        int masterColumnIndex = 5;
        String masterSheetName = "EmployeeMaster";

        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
   
        	FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "Yes"
        );

        // 🛠️ Step 4: Extra Config — No total logic
        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
            "", 0, ""
        );

        // ✅ Step 5: Final call to reusable validator
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee Names are reflecting properly as per masters!"
        );
		
	}
	
	
	
	
	

}
