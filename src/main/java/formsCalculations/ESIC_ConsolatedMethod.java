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

import businessTestCases.UtilisOne;
import login.BasePage;
import login.LoginLocators;
import performer.PerformerLocator;
import rcp.OneCommonMethod;
import utils.ExcelExtraConfig;
import utils.ExcelFileDetails;
import utils.ExcelF;
import utils.ExcelTargetValidation;
import utils.ExcelUtils;
import utils.FileSearchHelper;
import utils.HTMLBuilder;



public class ESIC_ConsolatedMethod extends BasePage {
	
	
	static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour.xlsx";
	
	public static File downloadedExcelFile; // shared file for all test cases

	public static String EMPmasterFilePath = "D:\\Upload Automation Files\\BusinessScenarios\\Month\\EmployeeMaster_TESTAUTO.xlsx";
	
	public static String salaryFile = "D:\\Upload Automation Files\\BusinessScenarios\\Month\\SampleSalary_TESTAUTO.xlsx";
	
	public static String salaryFile_NAEmployee = "D:\\Upload Automation Files\\BusinessScenarios\\Month\\SampleSalaryNAEmployeeTESTAUTO.xlsx";
	
	public static String EmployeeMaster_NAEmployee = "D:\\Upload Automation Files\\BusinessScenarios\\Month\\Filtered\\EmployeeMaster_NAEmployee_TESTAUTO.xlsx";
	
	
	
	
	
	
	public static void ESIC_Consolated_Redirection( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(120));

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
		PerformerLocator.selectComplianceChallan().click();
		Thread.sleep(2000);
		PerformerLocator.clickAct2().click();
		Thread.sleep(2000);
		PerformerLocator.selectComplianceESIC().click();
		Thread.sleep(2000);
		PerformerLocator.clickYear().click();
		Thread.sleep(2000);
		PerformerLocator.Year2025().click();
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
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click();
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click(); 
		Thread.sleep(7000);
		
		
        // Step 1: Manually download file
		PerformerLocator.ESIC_ConsolatedWorkingDownload().click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
		
	}
	
	public static void ESIC_AllEMPWorkings_EmployeeNo( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		ESIC_Consolated_Redirection(test, user);
		
		
        // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 6;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("KAR");

        ExcelF regionFilter = new ExcelF(filterColumnIndex, filterValues);
        List<ExcelF> allFilters = new ArrayList<>();
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
        String targetSheetName = "All Emp Workings";
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
	}
	public static void ESIC_AllEMPWorkings_ESIWages( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		ESIC_Consolated_Redirection(test, user);
		
		
        // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 6;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("KAR");

        ExcelF regionFilter = new ExcelF(filterColumnIndex, filterValues);
        List<ExcelF> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "MonthlyEmployeeSalary";
        int masterColumnIndex = 17;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	salaryFile,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "NO"
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "All Emp Workings";
        int targetColumnIndex = 6;
        String targetHeaderKeyword = "ESI Wages";
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
            "ESI Wages are reflecting properly as per masters!"
        );
	}
	public static void ESIC_AllEMPWorkings_ClientEmployeeESI( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		ESIC_Consolated_Redirection(test, user);
		
		
        // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 6;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("KAR");

        ExcelF regionFilter = new ExcelF(filterColumnIndex, filterValues);
        List<ExcelF> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "MonthlyEmployeeSalary";
        int masterColumnIndex = 6;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	salaryFile,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "NO"
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "All Emp Workings";
        int targetColumnIndex = 7;
        String targetHeaderKeyword = "Client EMPLOYEE ESI";
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
            "Client Employee ESI are reflecting properly as per masters !"
        );
	}
	
	public static void ESIC_AllEMPWorkings_ESINo( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		ESIC_Consolated_Redirection(test, user);
		
		
        // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 38;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("Active");

        ExcelF regionFilter = new ExcelF(filterColumnIndex, filterValues);
        List<ExcelF> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 18;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	EMPmasterFilePath,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "Yes"
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "All Emp Workings";
        int targetColumnIndex = 12;
        String targetHeaderKeyword = "ESI NO";
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
            "ESI NO are reflecting properly as per masters !"
        );
	}
	public static void ESIC_AllEMPWorkings_ClientESICode( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	//	ESIC_Consolated_Redirection(test, user);
		
		
        // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 38;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("Active");

        ExcelF regionFilter = new ExcelF(filterColumnIndex, filterValues);
        List<ExcelF> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 86;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	EMPmasterFilePath,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "Yes"
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "All Emp Workings";
        int targetColumnIndex = 13;
        String targetHeaderKeyword = "Client ESICode";
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
            "Client ESI Code are reflecting properly as per masters !"
        );
	}
	
	public static void ESIC_AllEMPWorkings_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		ESIC_Consolated_Redirection(test, user);
		
		
        // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 6;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("KAR");

        ExcelF regionFilter = new ExcelF(filterColumnIndex, filterValues);
        List<ExcelF> allFilters = new ArrayList<>();
        allFilters.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 5;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	EMPmasterFilePath,
            masterSheetName,
            masterColumnIndex,
            allFilters,
            "NO"
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "All Emp Workings";
        int targetColumnIndex = 2;
        String targetHeaderKeyword = "Employee Name";
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
            "Employee Names are reflecting properly as per masters !"
        );
	}
	
	public static void ESIC_AllEMPWorkings_Location( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
	//	ESIC_Consolated_Redirection(test, user);
		
		
        // 🧪 Step 3: Prepare master file filters
        int filterColumnIndex = 6;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("KAR");

        ExcelF regionFilter = new ExcelF(filterColumnIndex, filterValues);
        List<ExcelF> allFilters = new ArrayList<>();
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
        String targetSheetName = "All Emp Workings";
        int targetColumnIndex = 3;
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

        // ✅ Step 7: Final call to reusable validator
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Locations are reflecting properly as per masters !"
        );
	}
	
	
	
	

}
