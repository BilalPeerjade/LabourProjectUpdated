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


public class PT_Methods extends BasePage{
	
	static String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour.xlsx";
	
	public static File downloadedExcelFile; // shared file for all test cases

//	public static String masterFilePath = "D:\\Upload Automation Files\\BusinessScenarios\\Month\\EmployeeMaster_TESTAUTO.xlsx";
	
	//DOCAUTOO4
//	public static String masterFilePath = "D:\\Upload Automation Files\\BusinessScenarios\\DOCAUTOO4\\EmployeeMaster.xlsx";
	public static String masterFilePath = "D:\\Upload Automation Files\\BusinessScenarios\\DOCAUTOO4\\#1 Aug2025\\EmployeeMaster2.xlsx";
	public static String salaryFile = "D:\\Upload Automation Files\\BusinessScenarios\\Month\\SampleSalary_TESTAUTO.xlsx";
	

	
	
	
	
	
	

	
	
	
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
        
/**		CommonBusinessUtilis.validateExcelBusinessData(
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
		
		**/
  
/**        
     // 🔸 Step 1: Prepare Filters
        List<ExcelFilter> empMasterFilters = new ArrayList<>();
        empMasterFilters.add(new ExcelFilter(6, Arrays.asList("KAR")));

        // 🔸 Step 2: Create ExcelFileDetails
        ExcelFileDetails employeeMasterDetails = new ExcelFileDetails(
            masterFilePath,
            "EmployeeMaster",
            3,
            empMasterFilters,
            "NO"
        );

        // 🔸 Step 3: Target info
        ExcelTargetValidation ptTarget = new ExcelTargetValidation(
            "PTChallan",
            1,
            "Employee ID",
            0
        );

        // 🔸 Step 4: Extra config for summary logging etc.
        ExcelExtraConfig ptExtraConfig = new ExcelExtraConfig("", 0, "");

        // 🔸 Step 5: Final call
        CommonBusinessUtilis.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            employeeMasterDetails,
            ptTarget,
            ptExtraConfig,
      //      "🧪 Validating PT based on Master File"
            "Validating PT Employee IDs based on Master File data"
            //Validating PT Employee IDs based on Master File data
        );


        // 🔁 Another use-case — for "Remittance" total validation

        // Step A: Target config
        ExcelTargetValidation remittanceTarget = new ExcelTargetValidation(
            "Remittance",
            1,
            "Basic",
            0
        );

        // Step B: Total config
        ExcelExtraConfig remittanceExtra = new ExcelExtraConfig(
            "NO",
            1,
            "Total"
        );

        // Step C: Final call (no master file needed here)
        CommonBusinessUtilis.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            null,
            remittanceTarget,
            remittanceExtra,
            ""
        );

        
        */
        
        
      
        int filterColumnIndex = 6;
        List<String> filterValues = Arrays.asList("KAR");
        methodsb regionFilter = new methodsb(filterColumnIndex, filterValues);
        List<methodsb> af = new ArrayList<>();
        af.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            af,
            "NO"
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PTChallan";
        int targetColumnIndex = 1;
        String targetHeaderKeyword = "Employee ID";
        int targetStartRow = 0;
        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            targetSheetName,
            targetColumnIndex,
            targetHeaderKeyword,
            targetStartRow
        );

        // 🛠️ Step 6: Extra Config — no total row logic here
        ExcelExtraConfig extraConfig = new ExcelExtraConfig("", 0, "");

        // ✅ Step 7: Final call to reusable validator
        UtilisOne.validateExcelBusinessData(
        	downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "🧪 Validating PT based on Master File"
        );
        
        
        
		
		
	}
	
	public static void Challan_PT_StaturyDocRedirection( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
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
		PerformerLocator.selectCompliancePT().click();
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
		
		
		OneCommonMethod.zoomOutScreen(3);
		Thread.sleep(2000);
		
	}
	
	
	public static void Challan_PT_ValidateEmployeeID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
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
        
        
        
         
        int filterColumnIndex = 6;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("KAR");

        methodsb regionFilter = new methodsb(filterColumnIndex, filterValues);
        List<methodsb> af = new ArrayList<>();
        af.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            af,
            "NO"
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PTChallan";
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
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters!"
        );
        
        
        
		
		
	}
	
	
	public static void Challan_PT_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
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
        
/**		CommonBusinessUtilis.validateExcelBusinessData(
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
		
		**/
  
/**        
     // 🔸 Step 1: Prepare Filters
        List<ExcelFilter> empMasterFilters = new ArrayList<>();
        empMasterFilters.add(new ExcelFilter(6, Arrays.asList("KAR")));

        // 🔸 Step 2: Create ExcelFileDetails
        ExcelFileDetails employeeMasterDetails = new ExcelFileDetails(
            masterFilePath,
            "EmployeeMaster",
            3,
            empMasterFilters,
            "NO"
        );

        // 🔸 Step 3: Target info
        ExcelTargetValidation ptTarget = new ExcelTargetValidation(
            "PTChallan",
            1,
            "Employee ID",
            0
        );

        // 🔸 Step 4: Extra config for summary logging etc.
        ExcelExtraConfig ptExtraConfig = new ExcelExtraConfig("", 0, "");

        // 🔸 Step 5: Final call
        CommonBusinessUtilis.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            employeeMasterDetails,
            ptTarget,
            ptExtraConfig,
      //      "🧪 Validating PT based on Master File"
            "Validating PT Employee IDs based on Master File data"
            //Validating PT Employee IDs based on Master File data
        );


        // 🔁 Another use-case — for "Remittance" total validation

        // Step A: Target config
        ExcelTargetValidation remittanceTarget = new ExcelTargetValidation(
            "Remittance",
            1,
            "Basic",
            0
        );

        // Step B: Total config
        ExcelExtraConfig remittanceExtra = new ExcelExtraConfig(
            "NO",
            1,
            "Total"
        );

        // Step C: Final call (no master file needed here)
        CommonBusinessUtilis.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            null,
            remittanceTarget,
            remittanceExtra,
            ""
        );

        
        */
        
        
 /*     
        int filterColumnIndex = 6;
        List<String> filterValues = Arrays.asList("KAR");
        ExcelFilter regionFilter = new ExcelFilter(filterColumnIndex, filterValues);
        List<ExcelFilter> af = new ArrayList<>();
        af.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 5;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	masterFilePath,
            masterSheetName,
            masterColumnIndex,
            af,
            "NO"
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PTChallan";
        int targetColumnIndex = 2;
        String targetHeaderKeyword = "Emp Name";
        int targetStartRow = 0;
        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            targetSheetName,
            targetColumnIndex,
            targetHeaderKeyword,
            targetStartRow
        );

        // 🛠️ Step 6: Extra Config — no total row logic here
        ExcelExtraConfig extraConfig = new ExcelExtraConfig("", 0, "");

        // ✅ Step 7: Final call to reusable validator
        CommonBusinessUtilis.validateExcelBusinessData(
        	downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
      //      "🧪 Validating PT based on Master File"
            "Validating Emplpoyee Names from Employee Master file"
        );
        */
//        
//        try {
//		    // ✅ FILTER setup: Only select rows in master file where State == "KAR"
//		    methodsb filter = new methodsb();
//		    filter.setColumnName("State"); // only for readability/logging
//		    filter.setValues(Arrays.asList("KAR"));
//		    List<methodsb> filters = new ArrayList<>();
//		    filters.add(filter);
//
//		    // ✅ MASTER FILE CONFIG
//		    ExcelFileDetails masterDetails = new ExcelFileDetails();
//		    masterDetails.setFilePath(FilePath.EMPLOYEE_MASTER); // Global master path
//		    masterDetails.setSheetName("EmployeeMaster");
//		    masterDetails.setEmpNameColumnIndex(3); // D column (0-based)
//		    masterDetails.setApplyFilter("NO");
//		    masterDetails.setFilters(filters);
//
//		    // ✅ DOWNLOADED FILE CONFIG
//		    ExcelTargetValidation targetDetails = new ExcelTargetValidation();
//		    targetDetails.setSheetName("PTChallan");
//		    targetDetails.setColumnIndex(1); // B column (0-based)
//		    targetDetails.setHeaderKeyword("Employee ID");
//
//		    // ✅ EXTRA CONFIG (NO Total logic here)
//		    ExcelExtraConfig extraConfig = new ExcelExtraConfig();
//		    extraConfig.setEnable("NO"); // we don't want total row validation
//
//		    if (downloadedExcelFile == null || !downloadedExcelFile.exists()) {
//		        test.log(LogStatus.FAIL, "❌ Downloaded file is missing.");
//		        return;
//		    }
//
//		    test.log(LogStatus.INFO, "📄 Data Fetch file name: " + downloadedExcelFile.getName());
//
//		    // ✅ FETCH values from Master
//		    Set<String> masterValues = ExcelUtils.readFilteredColumnValues(
//		        masterDetails.getFilePath(),
//		        masterDetails.getSheetName(),
//		        masterDetails.getEmpNameColumnIndex(),
//		        masterDetails.getFilters()
//		    );
//
//		    if (masterValues.isEmpty()) {
//		        test.log(LogStatus.PASS, "✅ No employees matched in master for given filter — skipping validation.");
//		        return;
//		    }
//
//		    // ✅ FETCH values from Downloaded file
//		    Set<String> downloadedValues = ExcelUtils.readColumnValues(
//		        downloadedExcelFile,
//		        targetDetails.getSheetName(),
//		        targetDetails.getColumnIndex()
//		    );
//
//		    List<String> missing = masterValues.stream()
//		        .filter(v -> !downloadedValues.contains(v))
//		        .collect(Collectors.toList());
//
//		    if (missing.isEmpty()) {
//		        test.log(LogStatus.PASS, "✅ All expected Employee IDs found in downloaded file.");
//		    } else {
//		        test.log(LogStatus.FAIL, "❌ Missing Employee IDs: " + String.join(", ", missing));
//
//		        if (ENABLE_HTML_REPORT_TABLE) {
//		            String htmlTable = HTMLBuilder.createDetailedComparisonTable(
//		                masterValues,
//		                downloadedValues,
//		                masterDetails.getFilePath(),
//		                masterDetails.getSheetName(),
//		                masterDetails.getEmpNameColumnIndex(),
//		                targetDetails.getColumnIndex(),
//		                targetDetails.getHeaderKeyword()
//		            );
//		            test.log(LogStatus.INFO, htmlTable);
//		        }
//		    }
//
//		    // ✅ TOTAL LOGIC EXAMPLE (for a second sheet if required)
//		    ExcelTargetValidation totalTarget = new ExcelTargetValidation();
//		    totalTarget.setSheetName("Remittance");
//		    totalTarget.setColumnIndex(1); // Column to sum (e.g., Basic Wages)
//		    totalTarget.setHeaderKeyword("Basic");
//
//		    ExcelExtraConfig totalConfig = new ExcelExtraConfig();
//		    totalConfig.setEnable("YES");
//		    totalConfig.setColumnIndex(1); // Same column to sum
//		    totalConfig.setStopAtKeyword("Total"); // Stop summing when this keyword appears in col A
//
//		    ExcelUtils.validateTotalTillKeyword(downloadedExcelFile, test, totalTarget, totalConfig);
//
//		} catch (Exception e) {
//		    test.log(LogStatus.ERROR, "❌ Exception: " + e.getMessage());
//		    e.printStackTrace();
//		}
//        
//        
//		
//		
	}
	
	public static void Challan_PT_EmployeeNamee( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
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
        
        

      
        String targetHeaderKeyword = "Emp Name";
        int targetColumnIndex = 2;
        String targetSheetName = "PTChallan";
        int targetStartRow = 0;

        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            targetSheetName,
            targetColumnIndex,
            targetHeaderKeyword,
            targetStartRow
        );

         
        List<String> filterValues = Arrays.asList("KAR");
        methodsb regionFilter = new methodsb(6, filterValues);
        List<methodsb> af = Collections.singletonList(regionFilter);

         
        int masterColumnIndex = 5;
        String masterSheetName = "EmployeeMaster";

        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            af,
            "NO"
        );

         
        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
            "", 0, ""
        );

         
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Validating Employee Names from Employee Master file"
        );

	}
	
	
	public static void Challan_PT_Locations( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
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
        
        
        

        
        
        
        
        
         
        int filterColumnIndex = 6;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("KAR");

        methodsb regionFilter = new methodsb(filterColumnIndex, filterValues);
        List<methodsb> af = new ArrayList<>();
        af.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 8;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            af,
            "NO"
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PTChallan";
        int targetColumnIndex = 5;
        String targetHeaderKeyword = "Location";
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
            "Locations are reflecting properly as per masters!"
        );
        
		
		
	}
	
	public static void Challan_PT_PTGrossWages( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
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
        
        
        
        
        
        
        
        

        
        
        
        
        
         
        int filterColumnIndex = 6;
        List<String> filterValues = new ArrayList<>();
        filterValues.add("KAR");

        methodsb regionFilter = new methodsb(filterColumnIndex, filterValues);
        List<methodsb> af = new ArrayList<>();
        af.add(regionFilter);

        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "MonthlyEmployeeSalary";
        int masterColumnIndex = 16;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            FilePath.SALARY_FILE,
            masterSheetName,
            masterColumnIndex,
            af,
            "NO"
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PTChallan";
        int targetColumnIndex = 7;
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

        // ✅ Step 7: Final call to reusable validator
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "PT Gross Wages are reflecting properly as per masters!"
        );
        
		
		
	}
	
	public static void Challan_PT_PTAmount( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
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
		PerformerLocator.selectCompliancePT().click();
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
		getDriver().findElement(By.xpath("//span[contains(text(),'Gujarat')]")).click();
		Thread.sleep(2000);
		PerformerLocator.clickApply().click();
		Thread.sleep(6000);
		
		
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click();
		Thread.sleep(2000);
//		getDriver().findElement(By.xpath("(//img[@title='Download'])[1]")).click(); 
		Thread.sleep(7000);
		
		OneCommonMethod.scroll(driver.get(), 200); 
		
		// 1) Create helper once in your test/setup
//		DownloadHelper dl = new DownloadHelper(driver.get(), test);

		// 2) simplest call (exact match, first occurrence)
//		dl.clickDownload("MAH");
//		dl.clickDownload("MAH", 1);
		// 4) flexible contains + case-insensitive (branch name)
//		dl.clickDownload("MAH", 1, DownloadHelper.MatchOption.CONTAINS, true);
		
		DownloadHelper d2 = new DownloadHelper(driver.get(), test);
		d2.clickDownload("WEB", 1); // ab sirf MAH ka download click hoga
		Thread.sleep(2000);
//		d2.clickDownload("MAH", 9); // ab sirf MAH ka download click hoga

		Thread.sleep(7000);
		
		
		
		
        // Step 1: Manually download file
		getDriver().findElement(By.xpath("//img[@alt='Download Document']")).click();
        Thread.sleep(8000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
        PT_Methods.validatePTAmounts(downloadedExcelFile, test);

		
	}
	
	public static void Challan_PT_ANP_PTAmount( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		PT_Methods.validatePTAmounts(downloadedExcelFile, test);
		
		Map<String, Integer> runCounts = new HashMap<>();
		runCounts.put("", 1); // set generation count for that state
		PT_ConsolidatedMethods.validatePTAmountsUpdatedFlexible(downloadedExcelFile, test, runCounts);
	}
	
	public static void Challan_PT_BHR_PTAmount( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		PT_Methods.validatePTAmounts(downloadedExcelFile, test);
		
		Map<String, Integer> runCounts = new HashMap<>();
		runCounts.put("", 1); // set generation count for that state
		PT_ConsolidatedMethods.validatePTAmountsUpdatedFlexible(downloadedExcelFile, test, runCounts);
	}
	public static void Challan_PT_KAR_PTAmount( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		PT_Methods.validatePTAmounts(downloadedExcelFile, test);
		
		Map<String, Integer> runCounts = new HashMap<>();
		runCounts.put("", 1); // set generation count for that state
		PT_ConsolidatedMethods.validatePTAmountsUpdatedFlexible(downloadedExcelFile, test, runCounts);
	}
	public static void Challan_PT_KRL_PTAmount( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		PT_Methods.validatePTAmounts(downloadedExcelFile, test);
		
		Map<String, Integer> runCounts = new HashMap<>();
		runCounts.put("", 1); // set generation count for that state
		PT_ConsolidatedMethods.validatePTAmountsUpdatedFlexible(downloadedExcelFile, test, runCounts);
	}
	public static void Challan_PT_MAP_PTAmount( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		PT_Methods.validatePTAmounts(downloadedExcelFile, test);
		
		Map<String, Integer> runCounts = new HashMap<>();
		runCounts.put("MADHYA PRADESH", 1); // set generation count for that state
		PT_ConsolidatedMethods.validatePTAmountsUpdatedFlexible(downloadedExcelFile, test, runCounts);
	}
	public static void Challan_PT_JAK_PTAmount( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		PT_Methods.validatePTAmounts(downloadedExcelFile, test);
		
		Map<String, Integer> runCounts = new HashMap<>();
		runCounts.put("", 1); // set generation count for that state
		PT_ConsolidatedMethods.validatePTAmountsUpdatedFlexible(downloadedExcelFile, test, runCounts);
	}
	public static void Challan_PT_MAH_PTAmount( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		PT_Methods.validatePTAmounts(downloadedExcelFile, test);
		
		
		// Read state from first data row if you want (or you know it upfront)
		Map<String, Integer> runCounts = new HashMap<>();
//		runCounts.put("MAHARASHTRA", 1); // set generation count for that state
		PT_ConsolidatedMethods.validatePTAmountsUpdatedFlexible(downloadedExcelFile, test, runCounts);
		
	}
	public static void Challan_PT_ORS_PTAmount( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		PT_Methods.validatePTAmounts(downloadedExcelFile, test);
		
		Map<String, Integer> runCounts = new HashMap<>();
		runCounts.put("Orissa", 1); // set generation count for that state
		PT_ConsolidatedMethods.validatePTAmountsUpdatedFlexible(downloadedExcelFile, test, runCounts);
	}
	public static void Challan_PT_PND_PTAmount( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		PT_Methods.validatePTAmounts(downloadedExcelFile, test);
		
		Map<String, Integer> runCounts = new HashMap<>();
		runCounts.put("", 1); // set generation count for that state
		PT_ConsolidatedMethods.validatePTAmountsUpdatedFlexible(downloadedExcelFile, test, runCounts);
	}
	
	public static void validatePTAmounts(File downloadedExcelFile, ExtentTest test) {
	    try (FileInputStream fis = new FileInputStream(downloadedExcelFile)) {
	        Workbook wb = WorkbookFactory.create(fis);
	        Sheet sheet = wb.getSheet("PTChallan"); // ✅ tere sheet ka naam

	        // 🔹 Track counts & values per state
	        Map<String, Integer> stateRowCount = new HashMap<>();
	        Map<String, Integer> stateMismatchCount = new HashMap<>();
	        Map<String, Set<Integer>> statePTValues = new HashMap<>();

	        for (Row row : sheet) {
	            if (row.getRowNum() == 0) continue; // skip header

	            try {
	                // PT State (col CJ = index 87)
	                Cell stateCell = row.getCell(4);
	                if (stateCell == null) continue;
	                String state = stateCell.getStringCellValue().trim();

	                // Gross Wages (col G = index 6)
	                Cell grossCell = row.getCell(6);
	                if (grossCell == null) continue;
	                double gross = grossCell.getNumericCellValue();

	                // Actual PT Amount (col H = index 7)
	                Cell ptCell = row.getCell(7);
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


	
	
/**	public static void validatePTAmounts(
	        File masterFile,
	        File downloadedExcelFile,
	        ExtentTest test
	) {
	    try (
	        FileInputStream mfis = new FileInputStream(masterFile);
	        FileInputStream dfis = new FileInputStream(downloadedExcelFile)
	    ) {
	        Workbook masterWb = WorkbookFactory.create(mfis);
	        Workbook downloadedWb = WorkbookFactory.create(dfis);

	        // ✅ Master sheet (jisme PT State hai)
	        Sheet masterSheet = masterWb.getSheet("EmployeeMaster");

	        // ✅ Downloaded sheet (jisme Gross + PT Amount hai)
	        Sheet challanSheet = downloadedWb.getSheet("PTChallan");

	        if (masterSheet == null || challanSheet == null) {
	            test.log(LogStatus.FAIL, "❌ Required sheet not found in one of the files.");
	            return;
	        }

	        // 🔄 Row by row comparison (skip header = row 0)
	        for (int i = 1; i <= challanSheet.getLastRowNum(); i++) {
	            Row masterRow = masterSheet.getRow(i);
	            Row challanRow = challanSheet.getRow(i);

	            if (masterRow == null || challanRow == null) continue;

	            // 📌 Master → PT State (CJ = col 87)
	            Cell stateCell = masterRow.getCell(87);
	            if (stateCell == null) continue;
	            String state = stateCell.getStringCellValue().trim();

	            // 📌 Downloaded → Gross Wages (col G = index 6)
	            Cell grossCell = challanRow.getCell(6);
	            if (grossCell == null || grossCell.getCellType() != CellType.NUMERIC) continue;
	            double gross = grossCell.getNumericCellValue();

	            // 📌 Downloaded → Actual PT Amount (col H = index 7)
	            Cell ptCell = challanRow.getCell(7);
	            if (ptCell == null || ptCell.getCellType() != CellType.NUMERIC) continue;
	            double actualPT = ptCell.getNumericCellValue();

	            // 📌 Expected PT from helper
	            int expectedPT = ExcelValueNormalizer.getPTAmount(state, (int) gross);

	            // ✅ Compare
	            if (expectedPT == (int) actualPT) {
	                test.log(LogStatus.PASS, "✅ Row " + (i + 1) +
	                        " | State: " + state + " | Gross: " + gross +
	                        " | PT Correct: " + actualPT);
	            } else {
	                test.log(LogStatus.FAIL, "❌ Row " + (i + 1) +
	                        " | State: " + state + " | Gross: " + gross +
	                        " | Expected: " + expectedPT + " | Found: " + actualPT);
	            }
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.ERROR, "❌ Exception in PT validation: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	
	**/
	
	
	
	

	public static void Challan_PT_Gender( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
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
        
  /*      
		try {
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
		        test.log(LogStatus.PASS, "✅ No data matched in master for given filter — skipping validation.");
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

      
        String targetHeaderKeyword = "Gender";
        int targetColumnIndex = 3;
        String targetSheetName = "PTChallan";
        int targetStartRow = 0;

        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            targetSheetName,
            targetColumnIndex,
            targetHeaderKeyword,
            targetStartRow
        );

         
        List<String> filterValues = Arrays.asList("KAR");
        methodsb regionFilter = new methodsb(6, filterValues);
        List<methodsb> af = Collections.singletonList(regionFilter);

         
        int masterColumnIndex = 10;
        String masterSheetName = "EmployeeMaster";

        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            af,
            "NO"
        );

         
        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
            "", 0, ""
        );

         
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Validating Genders from Employee Master file"
        );
		
	}
	
	public static void Challan_PT_ANP_EmployeeID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		Challan_PT_StaturyDocRedirection(test,user);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("ANP", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
      
        List<methodsb> af = new ArrayList<>();
        
        af.add(new methodsb(38, Arrays.asList("Active")));
 
        af.add(new methodsb(9, Arrays.asList("ANP")));

        af.add(new methodsb(58, Arrays.asList("Yes")));
        
        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            af,
            "YES"   // Yes filters to apply
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PTChallan";
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
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters!"
        );
		
	}
	public static void Challan_PT_BHR_EmployeeID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		Challan_PT_StaturyDocRedirection(test,user);
		formLocators.closeXbutton().click();
		Thread.sleep(5000);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("BHR", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
      
        List<methodsb> af = new ArrayList<>();
        
        af.add(new methodsb(38, Arrays.asList("Active")));
 
        af.add(new methodsb(9, Arrays.asList("BHR")));

        af.add(new methodsb(58, Arrays.asList("Yes")));
        
        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            af,
            "YES"   // Yes filters to apply
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PTChallan";
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
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters!"
        );
	}
	public static void Challan_PT_MAH_EmployeeID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		Challan_PT_StaturyDocRedirection(test,user);
		formLocators.closeXbutton().click();
		Thread.sleep(5000);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("MAH", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
      
        List<methodsb> af = new ArrayList<>();
        
        af.add(new methodsb(38, Arrays.asList("Active")));
 
        af.add(new methodsb(9, Arrays.asList("MAH")));

        af.add(new methodsb(58, Arrays.asList("Yes")));
        
        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            af,
            "YES"   // Yes filters to apply
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PTChallan";
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
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters!"
        );
	}
	public static void Challan_PT_ORS_EmployeeID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		Challan_PT_StaturyDocRedirection(test,user);
		formLocators.closeXbutton().click();
		Thread.sleep(5000);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("ORS", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
      
        List<methodsb> af = new ArrayList<>();
        
        af.add(new methodsb(38, Arrays.asList("Active")));
 
        af.add(new methodsb(9, Arrays.asList("ORS")));

        af.add(new methodsb(58, Arrays.asList("Yes")));
        
        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            af,
            "YES"   // Yes filters to apply
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PTChallan";
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
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters!"
        );
	}
	public static void Challan_PT_PND_EmployeeID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		Challan_PT_StaturyDocRedirection(test,user);
		formLocators.closeXbutton().click();
		Thread.sleep(5000);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("PND", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
      
        List<methodsb> af = new ArrayList<>();
        
        af.add(new methodsb(38, Arrays.asList("Active")));
 
        af.add(new methodsb(9, Arrays.asList("PND")));

        af.add(new methodsb(58, Arrays.asList("Yes")));
        
        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            af,
            "YES"   // Yes filters to apply
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PTChallan";
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
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters!"
        );
	}
	public static void Challan_PT_PJB_EmployeeID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		Challan_PT_StaturyDocRedirection(test,user);
		formLocators.closeXbutton().click();
		Thread.sleep(5000);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("PJB", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
      
        List<methodsb> af = new ArrayList<>();
        
        af.add(new methodsb(38, Arrays.asList("Active")));
 
        af.add(new methodsb(9, Arrays.asList("PJB")));

        af.add(new methodsb(58, Arrays.asList("Yes")));
        
        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            af,
            "YES"   // Yes filters to apply
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PTChallan";
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
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters!"
        );
	}
	
	public static void Challan_PT_KAR_EmployeeID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		Challan_PT_StaturyDocRedirection(test,user);
		formLocators.closeXbutton().click();
		Thread.sleep(5000);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("KAR", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
      
        List<methodsb> af = new ArrayList<>();
        
        af.add(new methodsb(38, Arrays.asList("Active")));
 
        af.add(new methodsb(9, Arrays.asList("KAR")));

        af.add(new methodsb(58, Arrays.asList("Yes")));
        
        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            af,
            "YES"   // Yes filters to apply
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PTChallan";
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
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters!"
        );
	}
	public static void Challan_PT_KRL_EmployeeID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		Challan_PT_StaturyDocRedirection(test,user);
		formLocators.closeXbutton().click();
		Thread.sleep(5000);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("KRL", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
      
        List<methodsb> af = new ArrayList<>();
        
        af.add(new methodsb(38, Arrays.asList("Active")));
 
        af.add(new methodsb(9, Arrays.asList("KRL")));

        af.add(new methodsb(58, Arrays.asList("Yes")));
        
        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            af,
            "YES"   // Yes filters to apply
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PTChallan";
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
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters!"
        );
	}
	public static void Challan_PT_MAP_EmployeeID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		Challan_PT_StaturyDocRedirection(test,user);
		formLocators.closeXbutton().click();
		Thread.sleep(5000);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("MAP", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
      
        List<methodsb> af = new ArrayList<>();
        
        af.add(new methodsb(38, Arrays.asList("Active")));
 
        af.add(new methodsb(9, Arrays.asList("MAP")));

        af.add(new methodsb(58, Arrays.asList("Yes")));
        
        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            af,
            "YES"   // Yes filters to apply
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PTChallan";
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
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters!"
        );
	}
	
	public static void Challan_PT_JAK_EmployeeID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
//		Challan_PT_StaturyDocRedirection(test,user);
		formLocators.closeXbutton().click();
		Thread.sleep(5000);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("JAK", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); // wait for file to download

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
        
        
        
      
        List<methodsb> af = new ArrayList<>();
        
        af.add(new methodsb(38, Arrays.asList("Active")));
 
        af.add(new methodsb(9, Arrays.asList("JAK")));

        af.add(new methodsb(58, Arrays.asList("Yes")));
        
        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 3;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
        	FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            af,
            "YES"   // Yes filters to apply
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "PTChallan";
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
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters!"
        );
	}
	
	public static void Challan_PT_ANP_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Emp Name";
		int targetColumnIndex = 2;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("ANP")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 5;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karna hai
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Employee Names from Employee Master file"
		);

	}
	public static void Challan_PT_BHR_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Emp Name";
		int targetColumnIndex = 2;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("BHR")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 5;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karna hai
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Employee Names from Employee Master file"
		);

	}
	public static void Challan_PT_MAH_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Emp Name";
		int targetColumnIndex = 2;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("MAH")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 5;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karna hai
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Employee Names from Employee Master file"
		);

	}
	public static void Challan_PT_ORS_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Emp Name";
		int targetColumnIndex = 2;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("ORS")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 5;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karna hai
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Employee Names from Employee Master file"
		);

	}
	public static void Challan_PT_PJB_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Emp Name";
		int targetColumnIndex = 2;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("PJB")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 5;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karna hai
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Employee Names from Employee Master file"
		);

	}
	public static void Challan_PT_PND_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Emp Name";
		int targetColumnIndex = 2;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("PND")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 5;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karna hai
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Employee Names from Employee Master file"
		);

	}
	public static void Challan_PT_KAR_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Emp Name";
		int targetColumnIndex = 2;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("KAR")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 5;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karna hai
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Employee Names from Employee Master file"
		);

	}
	public static void Challan_PT_KRL_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Emp Name";
		int targetColumnIndex = 2;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("KRL")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 5;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karna hai
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Employee Names from Employee Master file"
		);

	}
	public static void Challan_PT_MAP_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Emp Name";
		int targetColumnIndex = 2;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("MAP")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 5;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karna hai
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Employee Names from Employee Master file"
		);

	}
	public static void Challan_PT_JAK_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Emp Name";
		int targetColumnIndex = 2;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("JAK")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 5;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karna hai
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Employee Names from Employee Master file"
		);

	}
	public static void Challan_PT_ANP_Gender( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Gender";
		int targetColumnIndex = 3;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("ANP")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 10;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Genders from Employee Master file"
		);

	}
	public static void Challan_PT_BHR_Gender( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Gender";
		int targetColumnIndex = 3;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("BHR")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 10;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Genders from Employee Master file"
		);

	}
	public static void Challan_PT_MAH_Gender( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Gender";
		int targetColumnIndex = 3;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("MAH")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 10;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Genders from Employee Master file"
		);

	}
	public static void Challan_PT_ORS_Gender( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Gender";
		int targetColumnIndex = 3;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("ORS")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 10;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Genders from Employee Master file"
		);

	}
	public static void Challan_PT_PND_Gender( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Gender";
		int targetColumnIndex = 3;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("PND")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 10;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Genders from Employee Master file"
		);

	}
	public static void Challan_PT_KAR_Gender( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Gender";
		int targetColumnIndex = 3;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("KAR")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 10;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Genders from Employee Master file"
		);

	}
	public static void Challan_PT_KRL_Gender( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Gender";
		int targetColumnIndex = 3;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("KRL")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 10;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Genders from Employee Master file"
		);

	}
	public static void Challan_PT_MAP_Gender( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Gender";
		int targetColumnIndex = 3;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("MAP")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 10;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Genders from Employee Master file"
		);

	}
	public static void Challan_PT_JAK_Gender( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "Gender";
		int targetColumnIndex = 3;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("JAK")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 10;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
				FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating Genders from Employee Master file"
		);

	}
	public static void Challan_PT_ANP_PTState( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "PT State";
		int targetColumnIndex = 4;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("ANP")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 9;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		
		// ✅ Enable Smart Text Match + Date Match
		extraConfig.setEnableSmartTextMatch("YES");  
		extraConfig.setEnableDateMatch("NO");
		

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating PT State from Employee Master file"
		);

	}
	public static void Challan_PT_BHR_PTState( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "PT State";
		int targetColumnIndex = 4;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("BHR")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 9;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		
		// ✅ Enable Smart Text Match + Date Match
		extraConfig.setEnableSmartTextMatch("YES");  
		extraConfig.setEnableDateMatch("NO");
		

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating PT State from Employee Master file"
		);

	}
	public static void Challan_PT_MAH_PTState( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "PT State";
		int targetColumnIndex = 4;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("MAH")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 9;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		
		// ✅ Enable Smart Text Match + Date Match
		extraConfig.setEnableSmartTextMatch("YES");  
		extraConfig.setEnableDateMatch("NO");
		

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating PT State from Employee Master file"
		);

	}
	public static void Challan_PT_ORS_PTState( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "PT State";
		int targetColumnIndex = 4;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("ORS")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 9;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		
		// ✅ Enable Smart Text Match + Date Match
		extraConfig.setEnableSmartTextMatch("YES");  
		extraConfig.setEnableDateMatch("NO");
		

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating PT State from Employee Master file"
		);

	}
	public static void Challan_PT_PND_PTState( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "PT State";
		int targetColumnIndex = 4;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("PND")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 9;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		
		// ✅ Enable Smart Text Match + Date Match
		extraConfig.setEnableSmartTextMatch("YES");  
		extraConfig.setEnableDateMatch("NO");
		

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating PT State from Employee Master file"
		);

	}
	public static void Challan_PT_KAR_PTState( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "PT State";
		int targetColumnIndex = 4;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("KAR")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 9;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		
		// ✅ Enable Smart Text Match + Date Match
		extraConfig.setEnableSmartTextMatch("YES");  
		extraConfig.setEnableDateMatch("NO");
		

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating PT State from Employee Master file"
		);

	}
	public static void Challan_PT_KRL_PTState( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "PT State";
		int targetColumnIndex = 4;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("KRL")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 9;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
				FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		
		// ✅ Enable Smart Text Match + Date Match
		extraConfig.setEnableSmartTextMatch("YES");  
		extraConfig.setEnableDateMatch("NO");
		

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating PT State from Employee Master file"
		);

	}
	public static void Challan_PT_MAP_PTState( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "PT State";
		int targetColumnIndex = 4;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("MAP")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 9;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
				FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		
		// ✅ Enable Smart Text Match + Date Match
		extraConfig.setEnableSmartTextMatch("YES");  
		extraConfig.setEnableDateMatch("NO");
		

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating PT State from Employee Master file"
		);

	}
	public static void Challan_PT_JAK_PTState( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		String targetHeaderKeyword = "PT State";
		int targetColumnIndex = 4;
		String targetSheetName = "PTChallan";
		int targetStartRow = 0;

		ExcelTargetValidation targetValidation = new ExcelTargetValidation(
		    targetSheetName,
		    targetColumnIndex,
		    targetHeaderKeyword,
		    targetStartRow
		);

		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("JAK")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		 
		int masterColumnIndex = 9;
		String masterSheetName = "EmployeeMaster";

		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
				FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"    
		);

		 
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
		    "", 0, ""
		);

		
		// ✅ Enable Smart Text Match + Date Match
		extraConfig.setEnableSmartTextMatch("YES");  
		extraConfig.setEnableDateMatch("NO");
		

		 
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,
		    test,
		    masterFileDetails,
		    targetValidation,
		    extraConfig,
		    "Validating PT State from Employee Master file"
		);

	}
	
	public static void Challan_PT_ANP_Location( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("ANP")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		// 📊 Step 4: Prepare ExcelFileDetails for Master
		String masterSheetName = "EmployeeMaster";
		int masterColumnIndex = 8;
		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
				FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karne ke liye YES
		);

		// 🎯 Step 5: Prepare Target validation for downloaded file
		String targetSheetName = "PTChallan";
		int targetColumnIndex = 5;
		String targetHeaderKeyword = "Location";
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
		    "Locations are reflecting properly as per masters!"
		);

	}
	public static void Challan_PT_BHR_Location( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("BHR")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		// 📊 Step 4: Prepare ExcelFileDetails for Master
		String masterSheetName = "EmployeeMaster";
		int masterColumnIndex = 8;
		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
				FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karne ke liye YES
		);

		// 🎯 Step 5: Prepare Target validation for downloaded file
		String targetSheetName = "PTChallan";
		int targetColumnIndex = 5;
		String targetHeaderKeyword = "Location";
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
		    "Locations are reflecting properly as per masters!"
		);

	}	
	public static void Challan_PT_MAH_Location( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("MAH")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		// 📊 Step 4: Prepare ExcelFileDetails for Master
		String masterSheetName = "EmployeeMaster";
		int masterColumnIndex = 8;
		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
				FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karne ke liye YES
		);

		// 🎯 Step 5: Prepare Target validation for downloaded file
		String targetSheetName = "PTChallan";
		int targetColumnIndex = 5;
		String targetHeaderKeyword = "Location";
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
		    "Locations are reflecting properly as per masters!"
		);

	}
	public static void Challan_PT_ORS_Location( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("ORS")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		// 📊 Step 4: Prepare ExcelFileDetails for Master
		String masterSheetName = "EmployeeMaster";
		int masterColumnIndex = 8;
		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
				FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karne ke liye YES
		);

		// 🎯 Step 5: Prepare Target validation for downloaded file
		String targetSheetName = "PTChallan";
		int targetColumnIndex = 5;
		String targetHeaderKeyword = "Location";
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
		    "Locations are reflecting properly as per masters!"
		);

	}
	public static void Challan_PT_PND_Location( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("ORS")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		// 📊 Step 4: Prepare ExcelFileDetails for Master
		String masterSheetName = "EmployeeMaster";
		int masterColumnIndex = 8;
		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
				FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karne ke liye YES
		);

		// 🎯 Step 5: Prepare Target validation for downloaded file
		String targetSheetName = "PTChallan";
		int targetColumnIndex = 5;
		String targetHeaderKeyword = "Location";
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
		    "Locations are reflecting properly as per masters!"
		);

	}
	public static void Challan_PT_KAR_Location( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("KAR")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		// 📊 Step 4: Prepare ExcelFileDetails for Master
		String masterSheetName = "EmployeeMaster";
		int masterColumnIndex = 8;
		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
				FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karne ke liye YES
		);

		// 🎯 Step 5: Prepare Target validation for downloaded file
		String targetSheetName = "PTChallan";
		int targetColumnIndex = 5;
		String targetHeaderKeyword = "Location";
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
		    "Locations are reflecting properly as per masters!"
		);

	}
	public static void Challan_PT_KRL_Location( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("KRL")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		// 📊 Step 4: Prepare ExcelFileDetails for Master
		String masterSheetName = "EmployeeMaster";
		int masterColumnIndex = 8;
		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karne ke liye YES
		);

		// 🎯 Step 5: Prepare Target validation for downloaded file
		String targetSheetName = "PTChallan";
		int targetColumnIndex = 5;
		String targetHeaderKeyword = "Location";
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
		    "Locations are reflecting properly as per masters!"
		);

	}
	public static void Challan_PT_MAP_Location( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("MAP")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		// 📊 Step 4: Prepare ExcelFileDetails for Master
		String masterSheetName = "EmployeeMaster";
		int masterColumnIndex = 8;
		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karne ke liye YES
		);

		// 🎯 Step 5: Prepare Target validation for downloaded file
		String targetSheetName = "PTChallan";
		int targetColumnIndex = 5;
		String targetHeaderKeyword = "Location";
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
		    "Locations are reflecting properly as per masters!"
		);

	}
	public static void Challan_PT_JAK_Location( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		 
		List<methodsb> af = new ArrayList<>();

		 
		af.add(new methodsb(38, Arrays.asList("Active")));

		 
		af.add(new methodsb(9, Arrays.asList("JAK")));

		 
		af.add(new methodsb(58, Arrays.asList("Yes")));

		// 📊 Step 4: Prepare ExcelFileDetails for Master
		String masterSheetName = "EmployeeMaster";
		int masterColumnIndex = 8;
		ExcelFileDetails masterFileDetails = new ExcelFileDetails(
			FilePath.EMPLOYEE_MASTER,
		    masterSheetName,
		    masterColumnIndex,
		    af,
		    "YES"   // ⚡ filters ko apply karne ke liye YES
		);

		// 🎯 Step 5: Prepare Target validation for downloaded file
		String targetSheetName = "PTChallan";
		int targetColumnIndex = 5;
		String targetHeaderKeyword = "Location";
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
		    "Locations are reflecting properly as per masters!"
		);

	}
	
	
	
	
	
	
	
	
	

}
