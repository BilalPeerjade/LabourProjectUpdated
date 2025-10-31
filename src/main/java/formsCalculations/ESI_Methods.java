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
import utils.ExcelF;
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
	

	
	

	public static void challan_ESI_Download400100( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		Challan_ESI_StaturyDocRedirection(test,user);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("400100", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); 

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
	}
	
	public static void challan_ESI_Download400200( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		Challan_ESI_StaturyDocRedirection(test,user);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("400200", 1);
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); 

        // Step 2: Get latest file
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        downloadedExcelFile = files[0];
	}



	
	public static void challan_ESI_400100_ALL_EmployeeID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		challan_ESI_Download400100(test,"");
        
        
    
     
        final List<ExcelF> af = new ArrayList<>();
        af.add(new ExcelF(38, Arrays.asList("Active")));
        af.add(new ExcelF(85, Arrays.asList("400100")));

       
        final ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            masterFilePath,             
            "EmployeeMaster",           
            3,                          
            af,                
            "YES"                       
        );

        
        final ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            "All Emp Workings",       
            1,                          
            "Employee No",             
            0                           
        );

        
        final ExcelExtraConfig extraConfig = new ExcelExtraConfig(
            "",                       
            0,                         
            ""                          
        );

        
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters !"
        );

        
        
        
        
        
        
//        WebDriver driver = CommonBusinessUtilis.getDriver();
//        CommonBusinessUtilis.validateColumnHasUniqueValues(
//	    driver,
//	    test,
//	    downloadedExcelFile,
//	    0,                 // Column Index for Employee Number (e.g., column F)
//	    0,                 // Header at row 2 (i.e., index 1)
//	    "All Emp Workings",         // Sheet name
//	    "All serial numbers are unique nos" );     // Log/Report label — It will display this log if pass
        
		
	}
	public static void challan_ESI_400100_Pending_EmployeeNO( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		challan_ESI_Download400100(test,"");
        
        
    
     
        final List<ExcelF> af = new ArrayList<>();
        af.add(new ExcelF(38, Arrays.asList("Active")));
        af.add(new ExcelF(85, Arrays.asList("400100")));
  //      new ExcelF(50, Arrays.asList("Yes"))
        af.add(new ExcelF(50, Arrays.asList("No")));

       
        final ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            masterFilePath,             
            "EmployeeMaster",           
            3,                          
            af,                
            "YES"                       
        );

        
        final ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            "Pending",       
            1,                          
            "Employee No",             
            0                           
        );

        
        final ExcelExtraConfig extraConfig = new ExcelExtraConfig(
            "",                       
            0,                         
            ""                          
        );

        
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters !"
        );
	}
	public static void challan_ESI_400100_Remittence_EmployeeID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{

		challan_ESI_Download400100(test,"");
        
        
    
     
        final List<ExcelF> af = new ArrayList<>();
        af.add(new ExcelF(38, Arrays.asList("Active")));
        af.add(new ExcelF(85, Arrays.asList("400100")));
        af.add(new ExcelF(50, Arrays.asList("Yes")));

       
        final ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            masterFilePath,             
            "EmployeeMaster",           
            3,                          
            af,                
            "YES"                       
        );

        
        final ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            "Remittence",       
            1,                          
            "Employee No",             
            0                           
        );

        
        final ExcelExtraConfig extraConfig = new ExcelExtraConfig(
            "",                       
            0,                         
            ""                          
        );

        
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Employee IDs are reflecting properly as per masters !"
        );
	}
	public static void challan_ESI_400100_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		challan_ESI_Download400100(test,"");
        
     
        List<ExcelF> FFF = new ArrayList<>();
        
        FFF.add(new ExcelF(38, Arrays.asList("Active")));
 
        FFF.add(new ExcelF(85, Arrays.asList("400100")));


        
        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 5;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            FFF,
            "YES"   // Yes
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "All Emp Workings";
        int targetColumnIndex = 2;
        String targetHeaderKeyword = "Employee Name";
        int targett = 0;

        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            targetSheetName,
            targetColumnIndex,
            targetHeaderKeyword,
            targett
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
	public static void challan_ESI_400100_Remittence_EmployeeName( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		challan_ESI_Download400100(test,"");
        
     
        List<ExcelF> FFF = new ArrayList<>();
        
        FFF.add(new ExcelF(38, Arrays.asList("Active")));
        FFF.add(new ExcelF(85, Arrays.asList("400100")));
        FFF.add(new ExcelF(50, Arrays.asList("No")));


        
        // 📊 Step 4: Prepare ExcelFileDetails for Master
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 5;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            FFF,
            "YES"   // Yes
        );

        // 🎯 Step 5: Prepare Target validation for downloaded file
        String targetSheetName = "Remittence";
        int targetColumnIndex = 2;
        String targetHeaderKeyword = "Employee Name";
        int targett = 0;

        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            targetSheetName,
            targetColumnIndex,
            targetHeaderKeyword,
            targett
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
	public static void challan_ESI_400100_Pending_EmployeeID( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		challan_ESI_Download400100(test,"");
        
     
		
		List<ExcelF> employeeFilters = new ArrayList<>();
		employeeFilters.addAll(List.of(
		    new ExcelF(38, List.of("Active")),
		    new ExcelF(85, List.of("400100")),
		    new ExcelF(50, List.of("Yes"))
		));

		
		ExcelFileDetails masterConfig = new ExcelFileDetails(
		    FilePath.EMPLOYEE_MASTER,
		    "EmployeeMaster",
		    5,
		    employeeFilters,
		    "YES" 
		);

		
		ExcelTargetValidation targetConfig = new ExcelTargetValidation(
		    "Remittence",     
		    2,                
		    "Employee Name",  
		    0                 
		);

		
		ExcelExtraConfig optionalConfig = new ExcelExtraConfig(
		    "",  
		    0,    
		    ""    
		);

		
		UtilisOne.validateExcelBusinessData(
		    downloadedExcelFile,   
		    test,                  
		    masterConfig,          
		    targetConfig,          
		    optionalConfig,        
		    "Employee Names are reflecting properly as per masters !"
		);

        

	
	
	}
	public static void challan_ESI_400100_Location( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		challan_ESI_Download400100(test,"");
        
     
        List<ExcelF> FFF = new ArrayList<>();
        
        FFF.add(new ExcelF(38, Arrays.asList("Active")));
 
        FFF.add(new ExcelF(85, Arrays.asList("400100")));


        
        
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 8;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            FFF,
            "YES"   // Yes
        );

        
        String targetSheetName = "All Emp Workings";
        int targetColumnIndex = 3;
        String targetHeaderKeyword = "Location";
        int targett = 0;

        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            targetSheetName,
            targetColumnIndex,
            targetHeaderKeyword,
            targett
        );

        
        String totalLogicEnabled = "";
        int totalColumnIndex = 0;
        String totalKeyword = "";

        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
            totalLogicEnabled,
            totalColumnIndex,
            totalKeyword
        );

        // Final 
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Locations are reflecting properly as per masters !"
        );
	
	
	}
	public static void challan_ESI_400100_ESI_NO( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		challan_ESI_Download400100(test,"");
        
     
        List<ExcelF> FFF = new ArrayList<>();
        
        FFF.add(new ExcelF(38, Arrays.asList("Active")));
 
        FFF.add(new ExcelF(85, Arrays.asList("400100")));


        
        
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 18;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            FFF,
            "YES"   // Yes
        );

        
        String targetSheetName = "All Emp Workings";
        int targetColumnIndex = 12;
        String targetHeaderKeyword = "Location";
        int targett = 0;

        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            targetSheetName,
            targetColumnIndex,
            targetHeaderKeyword,
            targett
        );

        
        String totalLogicEnabled = "";
        int totalColumnIndex = 0;
        String totalKeyword = "";

        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
            totalLogicEnabled,
            totalColumnIndex,
            totalKeyword
        );

        // Final 
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "ESI NOs are reflecting properly as per masters !"
        );
	
	
	}
	public static void challan_ESI_400100_Remittence_Location( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		challan_ESI_Download400100(test,"");
        
     
        List<ExcelF> FFF = new ArrayList<>();
        
        FFF.add(new ExcelF(38, Arrays.asList("Active")));
 
        FFF.add(new ExcelF(85, Arrays.asList("400100")));
        FFF.add(new ExcelF(50, Arrays.asList("Yes")));


        
        
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 8;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            FFF,
            "YES"   // Yes
        );

        
        String targetSheetName = "Remittence";
        int targetColumnIndex = 3;
        String targetHeaderKeyword = "Location";
        int targett = 0;

        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            targetSheetName,
            targetColumnIndex,
            targetHeaderKeyword,
            targett
        );

        
        String totalLogicEnabled = "";
        int totalColumnIndex = 0;
        String totalKeyword = "";

        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
            totalLogicEnabled,
            totalColumnIndex,
            totalKeyword
        );

        // Final 
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Locations are reflecting properly as per masters !"
        );
	
	
	}
	
	public static void challan_ESI_400100_Remittence_ESI_NO( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		challan_ESI_Download400100(test,"");
        
        
        
        List<ExcelF> filters = Arrays.asList(
                new ExcelF(38, Arrays.asList("Active")),
                new ExcelF(85,  Arrays.asList("400100")),
                new ExcelF(50, Arrays.asList("Yes"))
            );
            
            ExcelFileDetails masterDetails = new ExcelFileDetails(
                FilePath.EMPLOYEE_MASTER,
                "EmployeeMaster",
                18,
                filters,
                "YES"
            );
            
            ExcelTargetValidation targetVal = new ExcelTargetValidation(
                "Remittence",
                12,
                "",
                0
            );
            
            ExcelExtraConfig cfg = new ExcelExtraConfig("", 0, "");
            
            UtilisOne.validateExcelBusinessData(
                downloadedExcelFile,
                test,
                masterDetails,
                targetVal,
                cfg,
                "ESI NOs are reflecting properly as per masters !"
            );


	
	}
	public static void challan_ESI_400100_Pending_Location( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		challan_ESI_Download400100(test,"");
        
     
        List<ExcelF> FFF = new ArrayList<>();
        
        FFF.add(new ExcelF(38, Arrays.asList("Active")));
 
        FFF.add(new ExcelF(85, Arrays.asList("400100")));
        FFF.add(new ExcelF(50, Arrays.asList("No")));


        
        
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 8;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            FFF,
            "YES"   // Yes
        );

        
        String targetSheetName = "Remittence";
        int targetColumnIndex = 3;
        String targetHeaderKeyword = "Location";
        int targett = 0;

        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            targetSheetName,
            targetColumnIndex,
            targetHeaderKeyword,
            targett
        );

        
        String totalLogicEnabled = "";
        int totalColumnIndex = 0;
        String totalKeyword = "";

        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
            totalLogicEnabled,
            totalColumnIndex,
            totalKeyword
        );

        // Final 
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Locations are reflecting properly as per masters !"
        );
	
	
	}
	public static void challan_ESI_400100_Pending_ESI_NO( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		challan_ESI_Download400100(test,"");
        
        
        
        List<ExcelF> filters = Arrays.asList(
                new ExcelF(38, Arrays.asList("Active")),
                new ExcelF(85,  Arrays.asList("400100")),
                new ExcelF(50, Arrays.asList("No"))
            );
            
            ExcelFileDetails masterDetails = new ExcelFileDetails(
                FilePath.EMPLOYEE_MASTER,
                "EmployeeMaster",
                18,
                filters,
                "YES"
            );
            
            ExcelTargetValidation targetVal = new ExcelTargetValidation(
                "Remittence",
                12,
                "",
                0
            );
            
            ExcelExtraConfig cfg = new ExcelExtraConfig("", 0, "");
            
            UtilisOne.validateExcelBusinessData(
                downloadedExcelFile,
                test,
                masterDetails,
                targetVal,
                cfg,
                "ESI NOs are reflecting properly as per masters !"
            );


	
	}
	
	public static void challan_ESI_400100_Remittence_ClientESICode( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		challan_ESI_Download400100(test,"");
        
        
        
        List<ExcelF> filters = Arrays.asList(
                new ExcelF(38, Arrays.asList("Active")),
                new ExcelF(85,  Arrays.asList("400100")),
                new ExcelF(50, Arrays.asList("Yes"))
            );
            
            ExcelFileDetails masterDetails = new ExcelFileDetails(
                FilePath.EMPLOYEE_MASTER,
                "EmployeeMaster",
                85,
                filters,
                "YES"
            );
            
            ExcelTargetValidation targetVal = new ExcelTargetValidation(
                "Remittence",
                13,
                "",
                0
            );
            
            ExcelExtraConfig cfg = new ExcelExtraConfig("", 0, "");
            
            UtilisOne.validateExcelBusinessData(
                downloadedExcelFile,
                test,
                masterDetails,
                targetVal,
                cfg,
                "Client ESI Code are reflecting properly as per masters !"
            );

        
	
	
	}
	public static void challan_ESI_400100_Pending_ClientESICode( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		challan_ESI_Download400100(test,"");
        
        
        
		
		List<ExcelF> ttt = new ArrayList<>();
		{
		    ttt.add(new ExcelF(38, List.of("Active")));
		    ttt.add(new ExcelF(85, List.of("400100")));
		    ttt.add(new ExcelF(50, List.of("No")));
		}

		
		ExcelFileDetails masterDetails =
		        new ExcelFileDetails(
		                FilePath.EMPLOYEE_MASTER,
		                "EmployeeMaster",
		                85,
		                ttt,
		                "YES"
		        );

		
		ExcelTargetValidation targetVal =
		        new ExcelTargetValidation(
		                "Remittence",
		                13,
		                "",
		                0
		        );

		
		ExcelExtraConfig cfg =
		        new ExcelExtraConfig(
		                "",
		                0,
		                ""
		        );

		
		UtilisOne
		        .validateExcelBusinessData(
		                downloadedExcelFile,
		                test,
		                masterDetails,
		                targetVal,
		                cfg,
		                "Client ESI Code are reflecting properly as per masters !"
		        );


        
	
	
	}
	public static void challan_ESI_400100_ClientESICode( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		challan_ESI_Download400100(test,"");
        
        
        
        List<ExcelF> filters = Arrays.asList(
                new ExcelF(38, Arrays.asList("Active")),
                new ExcelF(85,  Arrays.asList("400100")),
                new ExcelF(50, Arrays.asList("Yes"))
            );
            
            ExcelFileDetails masterDetails = new ExcelFileDetails(
                FilePath.EMPLOYEE_MASTER,
                "EmployeeMaster",
                85,
                filters,
                "YES"
            );
            
            ExcelTargetValidation targetVal = new ExcelTargetValidation(
                "All Emp Workings",
                13,
                "",
                0
            );
            
            ExcelExtraConfig cfg = new ExcelExtraConfig("", 0, "");
            
            UtilisOne.validateExcelBusinessData(
                downloadedExcelFile,
                test,
                masterDetails,
                targetVal,
                cfg,
                "Client ESI Code are reflecting properly as per masters !"
            );

        
	
	
	}
	public static void challan_ESI_400100_DOJ( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		challan_ESI_Download400100(test,"");
        
     
        List<ExcelF> FFF = new ArrayList<>();
        
        FFF.add(new ExcelF(38, Arrays.asList("Active")));
 
        FFF.add(new ExcelF(85, Arrays.asList("400100")));


        
        
        String masterSheetName = "EmployeeMaster";
        int masterColumnIndex = 15;
        ExcelFileDetails masterFileDetails = new ExcelFileDetails(
            FilePath.EMPLOYEE_MASTER,
            masterSheetName,
            masterColumnIndex,
            FFF,
            "YES"   // Yes
        );

        
        String targetSheetName = "All Emp Workings";
        int targetColumnIndex = 4;
        String targetHeaderKeyword = "DOJ";
        int targett = 0;

        ExcelTargetValidation targetValidation = new ExcelTargetValidation(
            targetSheetName,
            targetColumnIndex,
            targetHeaderKeyword,
            targett
        );

        
        String totalLogicEnabled = "";
        int totalColumnIndex = 0;
        String totalKeyword = "";

        ExcelExtraConfig extraConfig = new ExcelExtraConfig(
            totalLogicEnabled,
            totalColumnIndex,
            totalKeyword
        );
        
        // ✅ Enable Smart Text Match + Date Match
        extraConfig.setEnableSmartTextMatch("No"); // GUJ↔Gujarat, Female↔FeMale
        extraConfig.setEnableDateMatch("YES");      // 01-01-2025 ↔ 01-Jan-2025
        

        // Final 
        UtilisOne.validateExcelBusinessData(
            downloadedExcelFile,
            test,
            masterFileDetails,
            targetValidation,
            extraConfig,
            "Locations are reflecting properly as per masters !"
        );
	
	
	}

	
	
	
	
	
	
	//Pending: 
	//utils Not working 
	/*
	public static void ESIC_AllEMPWorkings_Test( ExtentTest test, String user) throws InterruptedException, IOException, AWTException
	{
		Challan_ESI_StaturyDocRedirection(test,user);
		
		DownloadHelper d1 = new DownloadHelper(driver.get(), test);
		d1.clickDownload("400100", 1);
		
		
		Thread.sleep(5000);
        // Step 1: Manually download file
		formLocators.downloadDocument().click();
        Thread.sleep(10000); 

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
		List<ExcelF> masterFilters = new ArrayList<>();
		List<ExcelF> downloadedFilters = new ArrayList<>();

//		masterFilters.add(new ExcelFilter(ExcelUtils.columnLetterToIndex("X"), Arrays.asList("Yes")));
		masterFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("Y"), Arrays.asList("400100")));
		
		
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
		List<ExcelF> masterFilters = new ArrayList<>();
		List<ExcelF> downloadedFilters = new ArrayList<>();

		masterFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("Y"), Arrays.asList("400100")));
		
		
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
		
		
		
		ExcelExtraConfig extraConfig = new ExcelExtraConfig(
			    "NO",                                // NO => don't sum, just take direct cell
			    ExcelUtils.columnLetterToIndex("A"),"Total");

			List<ExcelF> masterFilters = new ArrayList<>();
			masterFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("Y"), Arrays.asList("400100")));

			List<ExcelF> targetFilters = new ArrayList<>();
			targetFilters.add(new ExcelF(ExcelUtils.columnLetterToIndex("A"), Arrays.asList("Total"))); // pick only Total row

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

			List<ExcelF> masterFilters = new ArrayList<>();
			List<ExcelF> targetFilters = new ArrayList<>();
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
			

		
	}
	*/
	
	

}
