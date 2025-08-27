package businessChallanForms;

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

import businessTestCases.CommonBusinessUtilis;

import businessTestCases.CommonBusinessUtilis3;
import formsCalculations.PT_Methods;
import formsCalculations.formLocators;
import login.BasePage;
import login.LoginLocators;
import performer.PerformerLocator;
import rcp.OneCommonMethod;
import utils.ExcelExtraConfig;
import utils.ExcelFileDetails;
import utils.ExcelFilter;
import utils.ExcelTargetValidation;
import utils.ExcelUtils;
import utils.ExcelValueNormalizer;
import utils.HTMLBuilder;



public class PT_ConsolidatedMethods extends BasePage {
	
	static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour.xlsx";
	
	public static File downloadedExcelFile; // shared file for all test cases

	public static String EMPmasterFilePath = "D:\\Upload Automation Files\\BusinessScenarios\\Month\\EmployeeMaster_TESTAUTO.xlsx";
	
	public static String salaryFile = "D:\\Upload Automation Files\\BusinessScenarios\\Month\\SampleSalary_TESTAUTO.xlsx";
	
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
	}
	
	
	public static void ChallanPTConsolated_PTReport_EmployeeIds( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
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
		
	}
	
	public static void ChallanPTConsolated_PTReport_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
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
        );
		
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

        ExcelFilter regionFilter = new ExcelFilter(filterColumnIndex, filterValues);
        List<ExcelFilter> allFilters = new ArrayList<>();
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
        CommonBusinessUtilis.validateExcelBusinessData(
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
        int filterColumnIndex = 6;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("KAR");

        ExcelFilter regionFilter = new ExcelFilter(filterColumnIndex, filterValues);
        List<ExcelFilter> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 10;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	EMPmasterFilePath,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "NO"
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
        CommonBusinessUtilis.validateExcelBusinessData(
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

        ExcelFilter regionFilter = new ExcelFilter(filterColumnIndex, filterValues);
        List<ExcelFilter> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 10;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	EmployeeMaster_NAEmployee,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "NO"
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
        CommonBusinessUtilis.validateExcelBusinessData(
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
        int filterColumnIndex = 6;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("KAR");

        ExcelFilter regionFilter = new ExcelFilter(filterColumnIndex, filterValues);
        List<ExcelFilter> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 8;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	EMPmasterFilePath,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "NO"
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
        CommonBusinessUtilis.validateExcelBusinessData(
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

        ExcelFilter regionFilter = new ExcelFilter(filterColumnIndex, filterValues);
        List<ExcelFilter> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "MonthlyEmployeeSalary";
        int masterColumnIndex = 16;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	salaryFile,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "NO"
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
        
     // ✅ Enable Smart Text Match + Date Match
//        extraConfig.setEnableSmartTextMatch("NO"); // GUJ↔Gujarat, Female↔FeMale
 //       extraConfig.setEnableDateMatch("NO");      // 01-01-2025 ↔ 01-Jan-2025

        // ✅ Step 7: Final call to reusable validator
        CommonBusinessUtilis.validateExcelBusinessData(
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
/*		
		// 📝 Extra config: enable total logic
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		        "YES",                               // enable total logic
		        ExcelUtils.columnLetterToIndex("A"), // downloaded file me jis column me "Total" likha hai (I -> 8)
		        "Total"                              // keyword to identify total row
		);

		// Filters agar chahiye (optional)
		List<ExcelFilter> masterFilters = new ArrayList<>();
		List<ExcelFilter> downloadedFilters = new ArrayList<>();

		// Header map agar chahiye (optional)
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Q", "PT Gross");    // Master column Q
		headerMap.put("I", "PT Gross wages");   // Downloaded column I

		// ✅ CALLING
		CommonBusinessUtilis3.validateExcelCalculation(
		        downloadedExcelFile,
		        salaryFile,   // master file path
		        test,
		        "PT_Report.I = Master.Q",   // rule: downloaded I = master Q total
		        "MASTER",                   // RHS source (taking from master file)
		        "PT Report",                // default downloaded sheet name
		        masterFilters,
		        downloadedFilters,
		        extraConfig,
		        0.01,                       // tolerance (1%)
		        false,                      // ⚡ false => only TOTALS check, not row by row
		        0,                          // startRowOffset
		        headerMap,
		        "PT Gross wages total is reflecting correctly as per masters!"
		);
*/
		
		
		// Extra config me total logic enable kar de
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "YES",                               // enable total logic
		    ExcelUtils.columnLetterToIndex("A"), // jis column me "Total" likha hota hai uska index (example: I)
		    "Total"                              // keyword jo sheet me likha hai
		);

		// Filters agar chahiye to add kar, warna empty list
		List<ExcelFilter> masterFilters = new ArrayList<>();
		List<ExcelFilter> targetFilters = new ArrayList<>();

		// Header map (optional, logs me accha dikhega)
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Q", "PT Gross");
		headerMap.put("I", "PT Gross wages");

		// ✅ Calling: Master.Q ka sum == Downloaded.I ka Total
		CommonBusinessUtilis3.validateExcelCalculation(
		    downloadedExcelFile,              // File downloaded
		    salaryFile,                       // Master file
		    test,                             // ExtentTest
		    "PT_Report.I = Master.Q",         // Expression
		    "MASTER",                         // rhsSource
		    "PT Report",                      // default sheet for downloaded
		    masterFilters,                    // filters for master
		    targetFilters,                    // filters for downloaded
		    extraConfig,                      // <-- total logic on
		    0.01,                             // tolerance
		    true,                            // row by row compare off
		    0,                                // start row offset
		    headerMap,                        // header labels
		    "PT Gross wages total is coming properly as per masters"
		);

/*        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
                "YES",                               // enable total logic? "YES"/"NO"
                ExcelUtils.columnLetterToIndex("A"), // column index where "Total" keyword might be present (L -> 11)
                "Total"                              // total keyword (case-insensitive)
            );
        
        List<ExcelFilter> masterFilters = new ArrayList<>();   // add filters if needed
        List<ExcelFilter> targetFilters = new ArrayList<>();      
 //     masterFilters.add(new ExcelFilter(6, Arrays.asList("PUNE")));

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Q", "PT Gross");     // optional: header keywords per column letter
        headerMap.put("I", "PT Gross wages");
//       headerMap.put("L", "Diffrence");


        CommonBusinessUtilis3.validateExcelCalculation(
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
        	    "Validating Master.H - Downloaded.K = Downloaded.L"
        	);
*/		
		
		
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
		List<ExcelFilter> masterFilters = new ArrayList<>();
		
		
		List<ExcelFilter> targetFilters = new ArrayList<>();

		// Header map (optional, logs me accha dikhega)
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("H", "PT deduction");
		headerMap.put("J", "Client PT deduction");

		// ✅ Calling: Master.Q ka sum == Downloaded.I ka Total
		CommonBusinessUtilis3.validateExcelCalculation(
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

        ExcelFilter regionFilter = new ExcelFilter(filterColumnIndex, filterValues);
        List<ExcelFilter> allFilters = new ArrayList<>();
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
        CommonBusinessUtilis.validateExcelBusinessData(
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
        
        List<ExcelFilter> masterFilters = new ArrayList<>();   // add filters if needed
        List<ExcelFilter> targetFilters = new ArrayList<>();      
 //     masterFilters.add(new ExcelFilter(6, Arrays.asList("PUNE")));

        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("H", "PT deduction");     // optional: header keywords per column letter
        headerMap.put("K", "PT amount(As per slab)");
        headerMap.put("L", "Diffrence");


        CommonBusinessUtilis3.validateExcelCalculation(
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








        
        
        
        
/*     // 🧪 Step 1: Define calculation rule
        String calculationRule = "L = H - K";   // H (master) - K (downloaded) = L (downloaded)

        // 🗂️ Step 2: Master File Details
        String masterSheetName = "Sheet1";
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
                new File(masterFilePath),   // local master file
                masterSheetName,
                ExcelUtils.columnLetterToIndex("H"),  // convert "H" → 7
                null,   // filters, if any (null → no filter)
                "YES"   // YES = use master file
        );

        // 🎯 Step 3: Target Validation (Downloaded file)
        String targetSheetName = "Sheet1";
        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
                targetSheetName,
                ExcelUtils.columnLetterToIndex("L"), // target column = L
                "Expected Result",   // optional header keyword, can keep empty
                0                    // startRowIndex (0 → from header)
        );

        // ⚙️ Step 4: Extra Config (Total row logic if needed)
        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
                "YES",    // enable total logic? YES/NO
                ExcelUtils.columnLetterToIndex("L"),  // column index where total is present
                "Total"   // keyword to stop at
        );

        // 📊 Step 5: Run validation
        CommonBusinessUtilis2.validateExcelCalculation(
                downloadedExcelFile,   // downloaded file path
                test,                  // ExtentTest object
                masterFileDetails,     // master details (H)
                targetValidation,      // downloaded L
                extraConfig,           // total logic
                calculationRule,       // "L = H - K"
                "RowByRow",            // compare mode ("RowByRow" or "TotalOnly")
                0.01                   // tolerance
        ); */


        
        
        
		
	}
	
	public static void ChallanPTConsolated_NAE_Branch( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		
        
        
		ChallanPTConsolated_Redirection(test,user);
        
        
        // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 6;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("KAR");

        ExcelFilter regionFilter = new ExcelFilter(filterColumnIndex, filterValues);
        List<ExcelFilter> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 8;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	EmployeeMaster_NAEmployee,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "NO"
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
        CommonBusinessUtilis.validateExcelBusinessData(
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
		List<ExcelFilter> masterFilters = new ArrayList<>();
		masterFilters.add(new ExcelFilter(6, Arrays.asList("")));
		
		
		List<ExcelFilter> targetFilters = new ArrayList<>();

		// Header map (optional, logs me accha dikhega)
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("H", "PT deduction");
		headerMap.put("J", "Client PT deduction");

		// ✅ Calling: Master.Q ka sum == Downloaded.I ka Total
		CommonBusinessUtilis3.validateExcelCalculation(
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
		List<ExcelFilter> masterFilters = new ArrayList<>();
		masterFilters.add(new ExcelFilter(6, Arrays.asList("")));
		
		
		List<ExcelFilter> targetFilters = new ArrayList<>();

		// Header map (optional, logs me accha dikhega)
		Map<String, String> headerMap = new HashMap<>();
		headerMap.put("Q", "PT Gross");
		headerMap.put("I", "Client PT deduction");

		// ✅ Calling: Master.Q ka sum == Downloaded.I ka Total
		CommonBusinessUtilis3.validateExcelCalculation(
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
		
		PT_ConsolidatedMethods.validatePTAmounts(downloadedExcelFile, test);
        
		
	}
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
	                        " | PT Values: " + ptValues);
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

        ExcelFilter regionFilter = new ExcelFilter(filterColumnIndex, filterValues);
        List<ExcelFilter> allFilters = new ArrayList<>();
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
        CommonBusinessUtilis.validateExcelBusinessData(
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
        
        
        
        
        
/**		CommonBusinessUtilis.validateExcelBusinessData(
			    downloadedExcelFile,
			    test,
			    new ExcelFileDetails(
			        masterFilePath,
			        "EmployeeMaster",  // ✅ Sheet name from master file
			        5,                 // ✅ Column index for EmpName in Master (F column = index 5)
			        Arrays.asList(
			            new ExcelFilter(58, Arrays.asList("No"))  // ✅ J column = index 6
			        ),
			        "YES"               // ✅ No filter to apply
			    ),
			    new ExcelTargetValidation(
			        "Non Applicable Employees",      // ✅ Sheet name in downloaded file
			        1,                 // ✅ Column index where Employee Names appear (C column = index 2)
			        "Employee ID",   // ✅ Keyword to search in header row (or logs)
			        0                  // ✅ Start directly from header row
			    ),
			    new ExcelExtraConfig("", 0, ""),  // ✅ No Total logic needed
			    "🧪 Validating based on Master File"
			);
        
        **/
        
        
        
        
        
        // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 58;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("No"); //FiName
        filterValues.add(""); //Blank

        ExcelFilter regionFilter = new ExcelFilter(filterColumnIndex, filterValues);
        List<ExcelFilter> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	EmployeeMaster_NAEmployee,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "No"
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
		
	}
	public static void ChallanPTConsolated_NAE_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
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
        List<String> filterValues = Arrays.asList("KAR");
        ExcelFilter regionFilter = new ExcelFilter(6, filterValues);
        List<ExcelFilter> allFilters = Collections.singletonList(regionFilter);

        // 📊 Step 3: Prepare Master file details
        int masterColumnIndex = 5;
        String masterSheetName = "EmployeeMaster";

        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	EmployeeMaster_NAEmployee,
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
        );
		
	}
	
	
	
	
	

}
