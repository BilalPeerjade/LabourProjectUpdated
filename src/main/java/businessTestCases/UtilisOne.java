package businessTestCases;



import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
//Export Imports
//Selenium imports
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Apache POI for Excel handling
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//ExtentReports logging
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import distributor.Locators;
import login.LoginLocators;
import performer.PerformerLocator;
import utils.ExcelExtraConfig;
import utils.ExcelFileDetails;
import utils.ExcelF;
import utils.ExcelTargetValidation;
import utils.ExcelValueNormalizer;

//Java standard libraries
import java.io.FileInputStream;
import java.time.Duration;
import java.time.Instant;
//Disabled Fields:
import java.util.Objects;
import java.util.Set;









public class UtilisOne {
	
	
	//UtilisOne CommonBusinessUtilis 
	public static String check = "check";
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	//Method 1 and 2 are common for both
	
	//1
	public static File getLatestDownloadedExcelFile() {
	    File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
	    File[] files = downloadDir.listFiles((dir, name) -> name.endsWith(".xlsx") || name.endsWith(".xls"));

	    if (files == null || files.length == 0) return null;

	    Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
	    return files[0];  // Most recent
	}
	
	
	
	//2
	
	public static File downloadExcelAndReturnFile(WebDriver driver, By downloadLocator, ExtentTest test) {
	    try {
	        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
	        File previousFile = getLatestDownloadedExcelFile();  // null or latest

	        // ✅ Step 1: Click on download button via JS
	        WebElement downloadButton = driver.findElement(downloadLocator);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadButton);
	        test.log(LogStatus.INFO, "📥 Clicked to download file using JavaScript.");

	        // ✅ Step 2: Wait for new file
	        File newFile = null;
	        long startTime = System.currentTimeMillis();

	        while ((System.currentTimeMillis() - startTime) < 15000) {
	            Thread.sleep(1000);

	            File[] allFiles = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
	            if (allFiles != null && allFiles.length > 0) {
	                Arrays.sort(allFiles, Comparator.comparingLong(File::lastModified).reversed());
	                File latest = allFiles[0];

	                if (previousFile == null || !latest.getName().equals(previousFile.getName()) || latest.lastModified() > previousFile.lastModified()) {
	                    newFile = latest;
	                    break;
	                }
	            }
	        }

	        // ✅ Step 3: Validate result
	        if (newFile != null && newFile.exists()) {
	            test.log(LogStatus.PASS, "✅ File downloaded: " + newFile.getName());
	            return newFile;
	        } else {
	            test.log(LogStatus.FAIL, "❌ File download failed or file not found within timeout.");
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.ERROR, "❌ Error during file download: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return null;
	}


	
	
	
	
	
	
	
	//-------------------------
	
    /**
     * 🔧 Purpose:
     * Single utility method to perform business validations either by:
     * 1. Matching filtered master data against downloaded file
     * 2. Validating a downloaded column till a row containing a "Total" keyword
     */
	
	private static final boolean ENABLE_HTML_REPORT_TABLE = false;
    public static void validateExcelBusinessData(
            File downloadedFile,
            ExtentTest test,
            ExcelFileDetails masterDetails,
            ExcelTargetValidation targetDetails,
            ExcelExtraConfig extraConfig,
            String logText
    ) {
        try {
        	
        	//If no need we can remove below log file fetch data:
        //	test.log(LogStatus.INFO, "📄 Data Fetch file name: " + downloadedFile.getName()); 
        	
            if (downloadedFile == null || !downloadedFile.exists()) {
            	
                test.log(LogStatus.FAIL, "❌ Downloaded file is null or missing.");
                return;
            }
            

             /**Comment*/
            //Added enhancement below line if condition
            if (extraConfig == null || !"NO".equalsIgnoreCase(extraConfig.getEnable())) {
                test.log(LogStatus.PASS, logText);  // 🟢 Now logText will show in report
            }


            if (extraConfig != null && "YES".equalsIgnoreCase(extraConfig.getEnable())) {
                // ✅ Scenario: Just validate downloaded file column till "Total" row
                validateDownloadedFileTillTotal(test, downloadedFile, targetDetails, extraConfig, logText);
                return;
            }
            
            //**Changed below method:-
//            if (masterDetails != null) {
//                // ✅ Scenario: Filter and match master data with downloaded file
//                validateMatchingRecords(test, masterDetails, downloadedFile, targetDetails, logText);
//            } else {
//                test.log(LogStatus.WARNING, "⚠️ No master file or extra config provided to perform validation.");
//            } 
            if (masterDetails != null) {
          //      validateMatchingRecords(test, masterDetails, downloadedFile, targetDetails, logText);
            	validateMatchingRecords(test, masterDetails, downloadedFile, targetDetails, extraConfig, logText);
            } else if (!(extraConfig != null && "NO".equalsIgnoreCase(extraConfig.getEnable()))) {
                test.log(LogStatus.WARNING, "⚠️ No master file or extra config provided to perform validation.");
            }

            
            
            

        } catch (Exception e) {
            test.log(LogStatus.ERROR, "❌ Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void validateDownloadedFileTillTotal(
            ExtentTest test,
            File file,
            ExcelTargetValidation target,
            ExcelExtraConfig config,
            String logText
    ) {
        try (FileInputStream fis = new FileInputStream(file)) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheet(target.getSheetName());
            if (sheet == null) {
                test.log(LogStatus.FAIL, "❌ Sheet not found: " + target.getSheetName());
                return;
            }

            List<String> values = new ArrayList<>();
            for (Row row : sheet) {
                Cell stopCell = row.getCell(0);
                if (stopCell != null && stopCell.getCellType() == CellType.STRING
                        && stopCell.getStringCellValue().trim().equalsIgnoreCase(config.getStopAtKeyword())) {
                    break;
                }
                Cell cell = row.getCell(config.getColumnIndex());
                if (cell != null) {
                    if (cell.getCellType() == CellType.NUMERIC) {
                        values.add(String.valueOf((int) cell.getNumericCellValue()));
                    } else if (cell.getCellType() == CellType.STRING) {
                        values.add(cell.getStringCellValue().trim());
                    }
                }
            }

            if (values.isEmpty()) {
                test.log(LogStatus.PASS, "✅ No value found till 'Total' row — pass as per config.");
            } else {
                test.log(LogStatus.PASS, "✅ Values till 'Total' row: " + String.join(", ", values));
            }
        } catch (Exception e) {
            test.log(LogStatus.ERROR, "❌ Error reading downloaded file: " + e.getMessage());
        }
    }
    
    private static void validateMatchingRecords(
            ExtentTest test,
            ExcelFileDetails master,
            File downloadedFile,
            ExcelTargetValidation target,
            ExcelExtraConfig extraConfig,
            String logText
    ) {
        try (FileInputStream fis = new FileInputStream(master.getFilePath())) {

            Workbook masterWb = WorkbookFactory.create(fis);
            Sheet masterSheet = masterWb.getSheet(master.getSheetName());
            if (masterSheet == null) {
                test.log(LogStatus.FAIL, "❌ Master sheet not found: " + master.getSheetName());
                return;
            }

            Set<String> filteredNames = new HashSet<>();
            for (Row row : masterSheet) {

                if (row.getRowNum() == 0) continue; // skip header row
                /** --- **/
  //            if (check.equals("check")) continue;

                boolean match = true;
                if ("YES".equalsIgnoreCase(master.getApplyFilter()) && master.getFilters() != null) {
                    for (ExcelF filter : master.getFilters()) {
                        Cell cell = row.getCell(filter.getColumnIndex());
                        String val = cell != null ? cell.toString().trim() : "";
                        if (!filter.getValues().contains(val)) {
                            match = false;
                            break;
                        }
                    }
                }
                if (match) {
                    Cell nameCell = row.getCell(master.getEmpNameColumnIndex());
                    if (nameCell != null) {
                        String name = nameCell.toString().trim();
                        if (!name.isEmpty()) filteredNames.add(name);
                    }
                }
            }

            //Checking **** Hide for sometime for checking 
//            if (filteredNames.isEmpty()) {
//                test.log(LogStatus.PASS, "✅ No employees matched filter from master — skipping validation.");
//                return;
//            }

            // --- NORMALIZE MASTER VALUES IF ENABLED ---
            // Date normalization first (so dates standardize before text normalization)
            if (extraConfig != null && "YES".equalsIgnoreCase(extraConfig.getEnableDateMatch())) {
                filteredNames = filteredNames.stream()
                        .map(utils.ExcelValueNormalizer::normalizeDate)
                        .collect(Collectors.toSet());
            }
            if (extraConfig != null && "YES".equalsIgnoreCase(extraConfig.getEnableSmartTextMatch())) {
                filteredNames = filteredNames.stream()
                        .map(utils.ExcelValueNormalizer::normalize)
                        .collect(Collectors.toSet());
            }

            // 🔍 Check in downloaded file now
            try (FileInputStream dfis = new FileInputStream(downloadedFile)) {
                Workbook downloadedWb = WorkbookFactory.create(dfis);
                Sheet sheet = downloadedWb.getSheet(target.getSheetName());
                if (sheet == null) {
                    test.log(LogStatus.FAIL, "❌ Downloaded sheet not found: " + target.getSheetName());
                    return;
                }

                List<String> foundNames = new ArrayList<>();
                for (Row row : sheet) {

                    if (row.getRowNum() == 0) continue; // Skip header

                    Cell cell = row.getCell(target.getColumnIndex());
                    if (cell != null) {
                        String val = cell.toString().trim();
                        if (!val.isEmpty()) foundNames.add(val);
                    }
                }

                // 🆕 Enhancement: If downloaded column is empty, skip further checks
                //This code is helps if Downloaded file contains empty cells (Right now hiding due to its not required)
//                if (foundNames.isEmpty()) {
//                    test.log(LogStatus.INFO, "No values available in downloaded file for column index: " + target.getColumnIndex());
//                    return; // stop here
//                } 

                // --- NORMALIZE DOWNLOADED VALUES SAFELY ---
                // Use a temp list for transformations, then assign to a final variable used inside lambda
                List<String> tempNormalized = new ArrayList<>(foundNames);

                if (extraConfig != null && "YES".equalsIgnoreCase(extraConfig.getEnableDateMatch())) {
                    tempNormalized = tempNormalized.stream()
                            .map(utils.ExcelValueNormalizer::normalizeDate)
                            .collect(Collectors.toList());
                }
                if (extraConfig != null && "YES".equalsIgnoreCase(extraConfig.getEnableSmartTextMatch())) {
                    tempNormalized = tempNormalized.stream()
                            .map(utils.ExcelValueNormalizer::normalize)
                            .collect(Collectors.toList()); //This will normalize
                }

                final List<String> normalizedFoundNames = tempNormalized; // final = required for lambda capture

                // Compare using normalizedFoundNames (master values already normalized above if enabled)
                List<String> missing = filteredNames.stream()
                        .filter(name -> !normalizedFoundNames.contains(name))
                        .collect(Collectors.toList());

                // HTML Report block (use normalizedFoundNames for presence checks)
                if (ENABLE_HTML_REPORT_TABLE) {

                      //Enhancement need to add 
                
                
                } // end HTML report

                if (missing.isEmpty()) {
                	//-----Status-------
                	//
                   
                    test.log(LogStatus.PASS, "✅ All " + filteredNames.size() + " expected values found in downloaded file.");
                } else {
                    test.log(LogStatus.FAIL, "❌ Missing values: " + String.join(", ", missing));
                }
            }

        } catch (Exception e) {
            test.log(LogStatus.ERROR, "❌ Error comparing data: " + e.getMessage());
        }
    }

    

/*    private static void validateMatchingRecords(
            ExtentTest test,
            ExcelFileDetails master,
            File downloadedFile,
            ExcelTargetValidation target,
            //
            ExcelExtraConfig extraConfig,
            
            String logText
    ) {
        try (FileInputStream fis = new FileInputStream(master.getFilePath())) {
        	
        	//File Name get text
       // 	test.log(LogStatus.INFO, "📄 Data Fetch file name: " + downloadedFile.getName()); 
        	
        	
            Workbook masterWb = WorkbookFactory.create(fis);
            Sheet masterSheet = masterWb.getSheet(master.getSheetName());
            if (masterSheet == null) {
                test.log(LogStatus.FAIL, "❌ Master sheet not found: " + master.getSheetName());
                return;
            }

            Set<String> filteredNames = new HashSet<>();
            for (Row row : masterSheet) {
                
            	//Added below line
               if (row.getRowNum() == 0) continue; // skip header row  
            	
            	boolean match = true;
                if ("YES".equalsIgnoreCase(master.getApplyFilter()) && master.getFilters() != null) {
                    for (ExcelFilter filter : master.getFilters()) {
                        Cell cell = row.getCell(filter.getColumnIndex());
                        String val = cell != null ? cell.toString().trim() : "";
                        if (!filter.getValues().contains(val)) {
                            match = false;
                            break;
                        }
                    }
                }
                if (match) {
                    Cell nameCell = row.getCell(master.getEmpNameColumnIndex());
                    if (nameCell != null) {
                        String name = nameCell.toString().trim();
                        if (!name.isEmpty()) filteredNames.add(name);
                    }
                }
            }

            if (filteredNames.isEmpty()) {
                test.log(LogStatus.PASS, "✅ No employees matched filter from master — skipping validation.");
                return;
            }
            
            
            //Adding below method to Normalize values like GUJ to Gujrat etc
         // 🔹 Smart Text Match for Master Values
            if (extraConfig != null && "YES".equalsIgnoreCase(extraConfig.getEnableSmartTextMatch())) {
                filteredNames = filteredNames.stream()
                        .map(ExcelValueNormalizer::normalize)
                        .collect(Collectors.toSet());
            }

            // 🔹 Date Match for Master Values
            if (extraConfig != null && "YES".equalsIgnoreCase(extraConfig.getEnableDateMatch())) {
                filteredNames = filteredNames.stream()
                        .map(ExcelValueNormalizer::normalizeDate)
                        .collect(Collectors.toSet());
            }

            
            
            
            
            
            
            
            

            // 🔍 Check in downloaded file now
            try (FileInputStream dfis = new FileInputStream(downloadedFile)) {
                Workbook downloadedWb = WorkbookFactory.create(dfis);
                Sheet sheet = downloadedWb.getSheet(target.getSheetName());
                if (sheet == null) {
                    test.log(LogStatus.FAIL, "❌ Downloaded sheet not found: " + target.getSheetName());
                    return;
                }

                
                //-----
                List<String> foundNames = new ArrayList<>();
                for (Row row : sheet) {
                	
                	if (row.getRowNum() == 0) continue; // ✅ Skip header (Added for if no data available pass and skip header) 
                	
                    Cell cell = row.getCell(target.getColumnIndex());
                    if (cell != null) {
                        String val = cell.toString().trim();
                        if (!val.isEmpty()) foundNames.add(val);
                    }
                }
                
             // 🆕 Enhancement: Agar column me ek bhi value nahi hai
                //agar downloaded file me empty cells hai like dusre sheet me to ye log laga dega:-
                if (foundNames.isEmpty()) {
                    test.log(LogStatus.INFO, "No values available in downloaded file for column index: " + target.getColumnIndex());
                    return; // yahi pe ruk jao, fail/pass mat karo
                }

                
                
                //Adding below method to Normalize values like GUJ to Gujrat Female to FeMale etc:
                
//            // 🔹 Smart Text Match for Downloaded Values
//                if (extraConfig != null && "YES".equalsIgnoreCase(extraConfig.getEnableSmartTextMatch())) {
//                    foundNames = foundNames.stream()
//                            .map(ExcelValueNormalizer::normalize)
//                            .collect(Collectors.toList());
//                }
//
//                // 🔹 Date Match for Downloaded Values
//                if (extraConfig != null && "YES".equalsIgnoreCase(extraConfig.getEnableDateMatch())) {
//                    foundNames = foundNames.stream()
//                            .map(ExcelValueNormalizer::normalizeDate)
//                            .collect(Collectors.toList());
//                }
//
             // ✅ Keep foundNames untouched, use a new variable for normalized values
                List<String> normalizedFoundNames = new ArrayList<>(foundNames);

               
                
                // 🔹 Smart Text Match for Downloaded Values
                if (extraConfig != null && "YES".equalsIgnoreCase(extraConfig.getEnableSmartTextMatch())) {
                    normalizedFoundNames = normalizedFoundNames.stream()
                            .map(ExcelValueNormalizer::normalize)
                            .collect(Collectors.toList());
                }

                // 🔹 Date Match for Downloaded Values
                if (extraConfig != null && "YES".equalsIgnoreCase(extraConfig.getEnableDateMatch())) {
                    normalizedFoundNames = normalizedFoundNames.stream()
                            .map(ExcelValueNormalizer::normalizeDate)
                            .collect(Collectors.toList());
                }
                
                final List<String> normalizedFoundNames = normalizedFoundNamesTemp;

                List<String> missing = filteredNames.stream()
                        .filter(name -> !normalizedFoundNames.contains(name))
                        .collect(Collectors.toList());

                
                
                
                
                
                
                
//             //Enhancement (If in downloaded file no data available: in all cells)
//             // 🆕 Enhancement: Agar target column ke saare cells empty hain
//                if (foundNames.isEmpty()) {
//                    test.log(LogStatus.WARNING, "⚠ No values available in downloaded file for column index: "
//                        + target.getColumnIndex());
//                    return; // Skip further mismatch check
//                } 

        
                
                

        //        List<String> missing = filteredNames.stream()
        //                .filter(name -> !foundNames.contains(name))
        //                .collect(Collectors.toList());
                
                
                
                //HTML Report Enhancement: if Required:
             // ✅ Only show table if flag is ON
                
                if (ENABLE_HTML_REPORT_TABLE) {
                    StringBuilder htmlTable = new StringBuilder();

                    // 🔰 Header Info for Master & Downloaded Columns
                    String masterColLetter = getExcelColumnLetter2(master.getEmpNameColumnIndex());
                    String masterHeader = getHeaderValue(master.getFilePath(), master.getSheetName(), master.getEmpNameColumnIndex());

                    String downloadedColLetter = getExcelColumnLetter2(target.getColumnIndex());
                    String downloadedHeader = target.getHeaderKeyword() != null ? target.getHeaderKeyword() : "";

                    String masterColumnHeader = masterColLetter + ": " + masterHeader;
                    String downloadedColumnHeader = downloadedColLetter + ": " + downloadedHeader;

                    htmlTable.append("<br><b>📊 Sample Comparison Table:</b><br>")
                        .append("<table border='1' cellpadding='4' style='border-collapse:collapse; text-align:center; font-family:Arial, sans-serif;'>")
                        .append("<tr style='background-color:#f2f2f2;'>")
                        .append("<th style='width:60px;'>Row No.<br><small>&nbsp;</small></th>")
                        .append("<th>Master Value<br><small>").append(masterColumnHeader).append("</small></th>")
                        .append("<th>Downloaded Value<br><small>").append(downloadedColumnHeader).append("</small></th>")
                        .append("<th>Result<br><small>&nbsp;</small></th>")
                        .append("</tr>");

                    int rowNum = 1;
                    for (String masterValue : filteredNames) {
                        if (rowNum > 5) break; // ✅ Show only first 5 rows
                        String matchResult = foundNames.contains(masterValue)
                            ? "<span style='color:green;font-weight:bold;'>PASS</span>"
                            : "<span style='color:red;font-weight:bold;'>FAIL</span>";
                        String downloadedMatch = foundNames.contains(masterValue) ? masterValue : "❌ Not Found";

                        htmlTable.append("<tr>")
                            .append("<td>").append(rowNum).append("</td>")
                            .append("<td>").append(masterValue).append("</td>")
                            .append("<td>").append(downloadedMatch).append("</td>")
                            .append("<td>").append(matchResult).append("</td>")
                            .append("</tr>");

                        rowNum++;
                    }

                    htmlTable.append("</table>");
                    test.log(LogStatus.INFO, htmlTable.toString());
                }//Report table end
                
                
                if (missing.isEmpty()) {
                    test.log(LogStatus.PASS, "✅ All " + filteredNames.size() + " expected values found in downloaded file.");
                } else {
                    test.log(LogStatus.FAIL, "❌ Missing values: " + String.join(", ", missing));
                }
            }

        } catch (Exception e) {
            test.log(LogStatus.ERROR, "❌ Error comparing data: " + e.getMessage());
        }
    }
	*/
	

    
    
    
    
    
    //These Helper methods for Report tabel format to indetify the column header(Index) and header names
    private static String getExcelColumnLetter2(int colNum) {
        StringBuilder sb = new StringBuilder();
        while (colNum >= 0) {
            sb.insert(0, (char) ('A' + (colNum % 26)));
            colNum = (colNum / 26) - 1;
        }
        return sb.toString();
    }
    private static String getHeaderValue(String filePath, String sheetName, int colIndex) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);
            if (sheet != null) {
                Row headerRow = sheet.getRow(0); // assumes header is on row 0
                if (headerRow != null) {
                    Cell cell = headerRow.getCell(colIndex);
                    return cell != null ? cell.toString().trim() : "";
                }
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }
    
    
    //This method is for Excel Value Normalizer
    
    
    
    
    
    
    
    
    
    
    
    
    

	
        
    

    
    
    
    public static File getFileFromDownloadedFolder(String targetFileName, ExtentTest test) {
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
        File foundFile = searchFileRecursive(downloadDir, targetFileName, test);

        if (foundFile != null) {
            test.log(LogStatus.PASS, "✅ Target file found: " + foundFile.getName());
            return foundFile;
        } else {
            test.log(LogStatus.FAIL, "❌ Target file not found: " + targetFileName);
            return null;
        }
    }
    
    private static File searchFileRecursive(File dir, String targetFileName, ExtentTest test) {
        if (dir == null || !dir.exists()) {
            test.log(LogStatus.ERROR, "❌ Directory not found: " + (dir != null ? dir.getAbsolutePath() : "null"));
            return null;
        }

        test.log(LogStatus.INFO, "📂 Searching in folder: " + dir.getAbsolutePath());
        System.out.println("📂 Searching in folder: " + dir.getAbsolutePath()); // DEBUG

        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            test.log(LogStatus.WARNING, "⚠️ No files found in folder: " + dir.getAbsolutePath());
            return null;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("📄 Found file: " + file.getName()); // DEBUG
                test.log(LogStatus.INFO, "📄 Found file: " + file.getName());

                // ✅ Partial match (case-insensitive)
                if (file.getName().toLowerCase().contains(targetFileName.toLowerCase())) {
                    return file;
                }
            } else if (file.isDirectory()) {
                File found = searchFileRecursive(file, targetFileName, test);
                if (found != null) return found;
            }
        }
        return null;
    }


    
    
    
    
    
 /*   public static File getFileFromDownloadedFolder(String targetFileName, ExtentTest test) {
        File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");

        // ✅ Find latest downloaded folder
        File[] folders = downloadDir.listFiles(File::isDirectory);
        if (folders == null || folders.length == 0) {
            test.log(LogStatus.FAIL, "❌ No folders found in Downloads.");
            return null;
        }
        Arrays.sort(folders, Comparator.comparingLong(File::lastModified).reversed());
        File latestFolder = folders[0];

        // ✅ Search inside folder recursively
        File foundFile = searchFileRecursive(latestFolder, targetFileName);
        if (foundFile != null && foundFile.exists()) {
            test.log(LogStatus.PASS, "📄 Data Fetch file name: " + foundFile.getName());
            return foundFile;
        } else {
            test.log(LogStatus.FAIL, "❌ Target file not found: " + targetFileName);
            return null;
        }
    }

    private static File searchFileRecursive(File dir, String targetFileName) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) { System.out.println("📄 Found file: " + file.getName()); // DEBUG
                if (file.isFile() && file.getName().equalsIgnoreCase(targetFileName)) {
                    return file;
                } else if (file.isDirectory()) {
                    File found = searchFileRecursive(file, targetFileName);
                    if (found != null) return found;
                }
            }
        }
        return null;
    }

    */
    
    
    
    
    
    
    
    
/**  //We can use this code when we are doing Registers validations
    //Folder Checking code:
    public static void validateExcelFromFolderOrFile(
            String folderMode, // "YES" or "NO"
            String searchFileName, // only applicable if folderMode = "YES"
            File downloadedFileOrFolder,
            ExtentTest test,
            ExcelFileDetails masterDetails,
            ExcelTargetValidation targetDetails,
            ExcelExtraConfig extraConfig,
            String logText
    ) {
        File finalFileToValidate = downloadedFileOrFolder;

        try {
            if ("YES".equalsIgnoreCase(folderMode)) {
                test.log(LogStatus.INFO, "📂 Folder mode enabled — Searching for file: " + searchFileName);
                finalFileToValidate = FileFinderHelper.findFileInFolder(downloadedFileOrFolder, searchFileName);
                if (finalFileToValidate == null) {
                    test.log(LogStatus.FAIL, "❌ File not found in downloaded folder: " + searchFileName);
                    return;
                }
            }

            // ✅ File name log here (NOT inside validateExcelBusinessData to avoid duplicate logs)
            test.log(LogStatus.INFO, "📄 Data Fetch file name: " + finalFileToValidate.getName());

            // Call your original utility
            validateExcelBusinessData(finalFileToValidate, test, masterDetails, targetDetails, extraConfig, logText);

        } catch (Exception e) {
            test.log(LogStatus.ERROR, "❌ Error while finding/validating file: " + e.getMessage());
        }
    }

    **/
    
    
    
    
	
	
	
	
	
	
	
	
//	public class ExcelFilter {
//		private int columnIndex;
//		private List<String> values;
//
//		public ExcelFilter(int columnIndex, List<String> values) {
//			this.columnIndex = columnIndex;
//			this.values = values;
//		}
//
//		public int getColumnIndex() {
//			return columnIndex;
//		}
//
//		public List<String> getValues() {
//			return values;
//		}
//
//	}    
	    
	    //---

//public class ExcelFileDetails {
//    private String filePath;
//    private String sheetName;
//    private int empNameColumnIndex;
//    private List<ExcelFilter> filters;
//    private String applyFilter;
//
//    public ExcelFileDetails(String filePath, String sheetName, int empNameColumnIndex, List<ExcelFilter> filters, String applyFilter) {
//        this.filePath = filePath;
//        this.sheetName = sheetName;
//        this.empNameColumnIndex = empNameColumnIndex;
//        this.filters = filters;
//        this.applyFilter = applyFilter;
//    }
//
//    public String getFilePath() {
//        return filePath;
//    }
//
//    public String getSheetName() {
//        return sheetName;
//    }
//
//    public int getEmpNameColumnIndex() {
//        return empNameColumnIndex;
//    }
//
//    public List<ExcelFilter> getFilters() {
//        return filters;
//    }
//
//    public String getApplyFilter() {
//        return applyFilter;
//    }
//	    
//}
    
    
    
//    public class ExcelTargetValidation {
//        private String sheetName;
//        private int columnIndex;
//        private String keyword;
//        private int rowOffset;
//
//        public ExcelTargetValidation(String sheetName, int columnIndex, String keyword, int rowOffset) {
//            this.sheetName = sheetName;
//            this.columnIndex = columnIndex;
//            this.keyword = keyword;
//            this.rowOffset = rowOffset;
//        }
//
//        public String getSheetName() {
//            return sheetName;
//        }
//
//        public int getColumnIndex() {
//            return columnIndex;
//        }
//
//        public String getKeyword() {
//            return keyword;
//        }
//
//        public int getRowOffset() {
//            return rowOffset;
//        }
//    
//   } 
        
//        public class ExcelExtraConfig {
//            private String enable;
//            private int columnIndex;
//            private String stopAtKeyword;
//
//            public ExcelExtraConfig(String enable, int columnIndex, String stopAtKeyword) {
//                this.enable = enable;
//                this.columnIndex = columnIndex;
//                this.stopAtKeyword = stopAtKeyword;
//            }
//
//            public String getEnable() {
//                return enable;
//            }
//
//            public int getColumnIndex() {
//                return columnIndex;
//            }
//
//            public String getStopAtKeyword() {
//                return stopAtKeyword;
//            }
//        
//        }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-------------------
	
	
	

	
	//Method Utils 1:--------
	public static void validateExcelTotalByColumnIndex (WebDriver driver,ExtentTest test,File filePath,int columnIndex,int headerRowIndex,String sheetName,String logText, double tolerance) {
	   
		
		/** 22-07-2025
		 * ✅ Purpose:
		 * This method validates the total of a specific column in an Excel sheet up to the "Total" row,
		 * and compares it with the actual value in the same column in that "Total" row.
		 * It logs:
		 *   - The downloaded file name
		 *   - Calculated total from column data
		 *   - Actual total from "Total" row
		 *   - Pass/Fail result
		 *
		 * ✅ Steps Performed:
		 * 1. Check if Excel file exists.
		 * 2. Log the file name being used for data validation.
		 * 3. Open the given sheet from the Excel file.
		 * 4. Start reading from the row after the header (based on `headerRowIndex`).
		 * 5. For each row:
		 *    - Sum the numeric values in the specified column (`columnIndex`).
		 *    - Stop if "Total" is found in first column.
		 * 6. Fetch the actual value from the "Total" row.
		 * 7. Log expected vs actual totals.
		 * 8. Log PASS if matched, FAIL if mismatch or "Total" row missing.
		 *
		 * ✅ Parameters:
		 * @param driver          WebDriver instance
		 * @param test            ExtentTest instance for logging
		 * @param filePath        Excel file to validate
		 * @param columnIndex     Index of column to sum (0-based)
		 * @param headerRowIndex  Row index where header starts (0-based)
		 * @param sheetName       Name of sheet in Excel to work on
		 * @param logText         Custom message to show in report logs
		 *
		 *
		 *
		 *
		 * ------------
		 * Calling:-
		 * 
		 *   //First Time calling: 
		 *   
		 *   WebDriver driver = CommonBusinessUtilis.getDriver();
		 *   
		 *   // Step 1: Manually download file
		 *   getDriver().findElement(By.xpath("(//img[@alt='Download Document'])[5]")).click();
		 *   Thread.sleep(8000); // wait for file to download
		 *   
		 *   // Step 2: Get latest file
		 *   File downloadDir = new File(System.getProperty("user.home") + "\\Downloads");
		 *   File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".xlsx"));
		 *   Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
		 *   downloadedExcelFile = files[0];
		 *
		 *
		 *
		 * 
		 *    //Rest calling every time rest of the methods:
		 *    
		 *    WebDriver driver = CommonBusinessUtilis.getDriver();
		 *    ✅ Sample Call:
		 *    CommonBusinessUtilis.validateExcelTotalByColumnIndex(
		 *     driver,
		 *     test,
		 *     downloadedExcelFile,
		 *     5,          // column index
		 *     1,          // header at 2nd row (index 1)
		 *     "Pending",  // sheet name
		 *     "Basic Wages Validation"
		 * );
		 */

		try {
	        if (filePath == null || !filePath.exists()) {
	            test.log(LogStatus.FAIL, "❌ Excel file not found to validate.");
	            return;
	        }

	        // ✅ Log File Name
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
	            if (row == null) continue;

	            Cell firstCell = row.getCell(0);
	            if (firstCell != null && firstCell.getCellType() == CellType.STRING
	                    && firstCell.getStringCellValue().trim().equalsIgnoreCase("Total")) {

	                Cell totalCell = row.getCell(columnIndex);
	                fileTotal = totalCell != null && totalCell.getCellType() == CellType.NUMERIC
	                        ? totalCell.getNumericCellValue() : 0;

	                break;
	            }

	            Cell dataCell = row.getCell(columnIndex);
	            if (dataCell != null && dataCell.getCellType() == CellType.NUMERIC) {
	                calculatedTotal += dataCell.getNumericCellValue();
	            }
	        }

	        workbook.close();

	        // ✅ Log Expected vs Actual
	        test.log(LogStatus.INFO, "📊 Expected count: " + calculatedTotal + "   ||   Actual count: " + fileTotal);

	        if (fileTotal == -1) {
	            test.log(LogStatus.FAIL, "❌ Total row not found in sheet: " + sheetName);
	            return;
	        }
	        
	//      if (Math.abs(calculatedTotal - fileTotal) < 0.01)
	//      if (Math.abs(calculatedTotal - fileTotal) < tolerance) 
	        if (Math.abs(calculatedTotal - fileTotal) <= Math.max(tolerance, 0.01))

	        {
	            test.log(LogStatus.PASS, "✅ " + logText + ": matched total: " + fileTotal);
	        } else {
	            test.log(LogStatus.FAIL, "❌ " + logText + ": mismatch. Expected: " + calculatedTotal + ", Found: " + fileTotal);
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.ERROR, "❌ Error during Excel total validation: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	








	
	//Method 2
	public static void validateColumnHasUniqueValues(WebDriver driver,ExtentTest test,File filePath,int columnIndex,int headerRowIndex,String sheetName,String logText) {
	    
		
		

		
		try {
	        if (filePath == null || !filePath.exists()) {
	            test.log(LogStatus.FAIL, "❌ Excel file not found for uniqueness validation.");
	            return;
	        }

	        // ✅ Step 1: Log file name
	        test.log(LogStatus.INFO, "📄 Data Fetch file name: " + filePath.getName());

	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet(sheetName);

	        if (sheet == null) {
	            test.log(LogStatus.FAIL, "❌ Sheet not found: " + sheetName);
	            workbook.close();
	            return;
	        }

	        Set<String> uniqueValues = new HashSet<>();
	        List<String> duplicates = new ArrayList<>();
	        int rowCount = 0;

	        for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);
	            if (row == null) continue;

	            // Stop if first column has "Total"
	            Cell firstCell = row.getCell(0);
	            if (firstCell != null && firstCell.getCellType() == CellType.STRING &&
	                    firstCell.getStringCellValue().trim().equalsIgnoreCase("Total")) {
	                break;
	            }

	            Cell dataCell = row.getCell(columnIndex);
	            String value = "";

	            if (dataCell != null) {
	                switch (dataCell.getCellType()) {
	                    case STRING:
	                        value = dataCell.getStringCellValue().trim();
	                        break;
	                    case NUMERIC:
	                        value = String.valueOf((long) dataCell.getNumericCellValue()); //given long keyword
	                        break;
	                    case BOOLEAN:
	                        value = String.valueOf(dataCell.getBooleanCellValue());
	                        break;
	                    default:
	                        value = dataCell.toString().trim();
	                }

	                if (!value.isEmpty()) {
	                    if (!uniqueValues.add(value)) {
	                        duplicates.add(value);
	                    }
	                    rowCount++;
	                }
	            }
	        }

	        workbook.close();

	        // ✅ Step 2: Log result
	        test.log(LogStatus.INFO, "🔎 " + logText + " → Total values: " + rowCount + " || Unique values: " + uniqueValues.size());

	        if (duplicates.isEmpty()) {
	            test.log(LogStatus.PASS, "✅ " + logText + " values are unique.");
	        } else {
	            test.log(LogStatus.FAIL, "❌ " + logText + " has duplicates: " + String.join(", ", duplicates));
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.ERROR, "❌ Error in uniqueness validation: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	
	
	
	
	//Method 3: change name: validateDynamicEPFAndHeaderValue
	//This method is for specially PF Working File
/*	public static void validateTotalCellValueWithTotalSummary(WebDriver driver,ExtentTest test,File filePath,String sheetName,int totalColumnIndex,int headerRowIndex,String totalKeyword,int dynamicHeaderColumnIndex,String headerName,int rowsAfterHeader) {
		    
		
		try {
		        if (filePath == null || !filePath.exists()) {
		            test.log(LogStatus.FAIL, "❌ Excel file not found for validation.");
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

		        // Step 1: Get EPF Wages Total from column till 'Total' row
		        double epfTotal = 0.0;
		        double fileTotal = -1;
		    //  for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) 
		        for (int i = 0; i <= sheet.getLastRowNum(); i++)
		        
		        {
		            Row row = sheet.getRow(i);
		            if (row == null) continue;

		            Cell firstCell = row.getCell(0);
		            if (firstCell != null && firstCell.getCellType() == CellType.STRING &&
		                firstCell.getStringCellValue().trim().equalsIgnoreCase(totalKeyword)) {

		                Cell totalCell = row.getCell(totalColumnIndex);
//		                fileTotal = (totalCell != null && totalCell.getCellType() == CellType.NUMERIC)
//		                    ? totalCell.getNumericCellValue() : 0;
		                
		                if (totalCell != null && totalCell.getCellType() == CellType.NUMERIC) {
		                    fileTotal = totalCell.getNumericCellValue();
		                } else {
		                    fileTotal = 0; // ✅ even if empty or non-numeric
		                }
		                
		                
		                
		                break;
		            }

		            Cell dataCell = row.getCell(totalColumnIndex);
		            if (dataCell != null && dataCell.getCellType() == CellType.NUMERIC) {
		                epfTotal += dataCell.getNumericCellValue();
		            }
		        }

		        // Step 2: Find header in given column, and fetch cell 'N' rows below
		        double belowValue = -1;
		        boolean headerFound = false;

		   //   for (int i = headerRowIndex + 1; i <= sheet.getLastRowNum(); i++) 
		        for (int i = 0; i <= sheet.getLastRowNum(); i++)
		        
		        {
		            Row row = sheet.getRow(i);
		            if (row == null) continue;

		            Cell headerCell = row.getCell(dynamicHeaderColumnIndex);
		            if (headerCell != null && headerCell.getCellType() == CellType.STRING &&
		          //    headerCell.getStringCellValue().trim().equalsIgnoreCase(headerName)
		            	headerCell.getStringCellValue().toLowerCase().contains(headerName.toLowerCase())) 
		            
		            {

		                Row targetRow = sheet.getRow(i + rowsAfterHeader);
		                if (targetRow != null) {
		                    Cell targetCell = targetRow.getCell(dynamicHeaderColumnIndex);
		                    if (targetCell != null && targetCell.getCellType() == CellType.NUMERIC) {
		                        belowValue = targetCell.getNumericCellValue();
		                        headerFound = true;
		                        break;
		                    }
		                }
		            }
		        }

		        workbook.close();

		        // 🔍 Logs
		        test.log(LogStatus.INFO, "📊 EPF Total: " + fileTotal);
		        test.log(LogStatus.INFO, "📉 " + headerName + " +" + rowsAfterHeader + " Row Value: " + belowValue);

		        if (!headerFound) {
		            test.log(LogStatus.FAIL, "❌ Header '" + headerName + "' not found in column index " + dynamicHeaderColumnIndex);
		            return;
		        }

		  //    if (fileTotal == -1) {
		  //          test.log(LogStatus.FAIL, "❌ 'Total' row not found in column A.");
		  //          return;
		  //     } 
		        if (fileTotal == -1) {
		            test.log(LogStatus.INFO, "ℹ️ 'Total' row found but value cell was empty or non-numeric. Assuming 0.");
		            fileTotal = 0;
		        }


		        if ((fileTotal == 0 && belowValue == 0) || Math.abs(fileTotal - belowValue) < 0.01) {
		            test.log(LogStatus.PASS, "✅ Matched: EPF = " + fileTotal + " & " + headerName + " = " + belowValue);
		        } else {
		            test.log(LogStatus.FAIL, "❌ Mismatch: EPF = " + fileTotal + ", " + headerName + " = " + belowValue);
		        }

		    } catch (Exception e) {
		        test.log(LogStatus.ERROR, "❌ Error: " + e.getMessage());
		        e.printStackTrace();
		    }
		}

	*/
	
	
	
	
	
	
	//Method Utils 3
	
	//Method 3: change name: validateDynamicEPFAndHeaderValue
	//This method is for specially PF Working File
	public static void validateTotalCellValueWithTotalSummary(WebDriver driver,ExtentTest test,File filePath,String sheetName,int totalColumnIndex,int headerRowIndex,String totalKeyword,int dynamicHeaderColumnIndex,String headerName,int rowsAfterHeader) {    
		
	    /**
	     * ✅ Validates that the "EPF Total" in one column matches the value found below a dynamic header like "Basic".
	     *
	     * 🔧 Purpose:
	     * This method is used to ensure values such as EPF wages match a specific total fetched dynamically 
	     * from below a given header in another column.
	     * Useful in validating totals from sheets like "Pending", "Remittances", "All Employees", etc.
	     *
	     * 📌 Steps Performed:
	     * ------------------------------------------------------------
	     * 1. Opens the provided Excel file and accesses the given sheet.
	     * 2. Searches for the row where the first column (A) has the value "Total".
	     * 3. Captures the cell in that row at the provided totalColumnIndex (e.g., column S = 19).
	     * 4. Searches column 'dynamicHeaderColumnIndex' (e.g., column H = 7) for a header text matching 'headerName' (case-insensitive, partial match allowed).
	     * 5. Once found, it fetches the value from the cell 'rowsAfterHeader' rows below that header.
	     * 6. Logs both values via ExtentTest — and marks PASS if:
	     *      - Both values are 0
	     *      - OR their difference is within a 0.01 margin.
	     * 7. Handles empty or missing cells by treating them as 0.
	     *
	     * 📥 Parameters:
	     * @param driver                      WebDriver instance
	     * @param test                        ExtentTest instance for reporting
	     * @param filePath                    File object of the Excel (already downloaded manually)
	     * @param sheetName                   Sheet to validate (e.g., "Pending", "Remittances")
	     * @param totalColumnIndex            Index of the column where EPF total is (0-based, e.g., 19 for column S)
	     * @param headerRowIndex              Index of the header row (0-based, e.g., 1 for row 2 in Excel)
	     * @param totalKeyword                Keyword to locate the total row (e.g., "Total" in column A)
	     * @param dynamicHeaderColumnIndex    Index of the column to search for dynamic header (e.g., 7 for column H)
	     * @param headerName                  Header name to match (case-insensitive, partial match allowed e.g., "Basic")
	     * @param rowsAfterHeader             How many rows after header to fetch value (usually 1 or 2)
	     *
	     * ✅ Example Calling (from test case):
	     * ------------------------------------------------------------
	     *     File downloadedExcelFile = getLatestDownloadedExcelFile(); // Already downloaded manually
	     *     
	     *     CommonBusinessUtilis.validateTotalCellValueWithTotalSummary(
	     *         driver,
	     *         test,
	     *         downloadedExcelFile,
	     *         "Remittances",        // Sheet Name
	     *         19,                   // Column S (EPF Wages)
	     *         1,                    // Header at row 2
	     *         "Total",              // Total row identifier
	     *         7,                    // Column H (for "Basic")
	     *         "Basic",              // Header Text to look for
	     *         1                     // Fetch 1 row below
	     *     );
	     *
	     * 📌 Notes:
	     * - If "Total" row is found but its cell is empty → it's treated as 0.
	     * - If header is not found → failure is logged.
	     * - If value below header is missing → treated as -1 (and failure logged unless both are zero).
	     * - `headerName` can be partial (e.g., "Basic" will match "Basic (Wages)")
	     *
	     */
		
		/**
		Calling this method like this: 
		    WebDriver driver = CommonBusinessUtilis.getDriver();
		    File downloadedExcelFile = getLatestDownloadedExcelFile(); // Already downloaded manually
			CommonBusinessUtilis.validateTotalCellValueWithTotalSummary(
				    driver,
				    test,
				    downloadedExcelFile,     // File already downloaded manually, pass here
				    "Remittances",           // Sheet name where data exists
				    19,                      // totalColumnIndex → Column 'T' → EPF Wages
				    1,                       // headerRowIndex → Excel row 2 (0-based index = 1)
				    "Total",                 // totalKeyword → will check column A for 'Total'
				    7,                       // dynamicHeaderColumnIndex → Column H
				    "Basic",                 // headerName → Will match if contains 'Basic'
				    1                        // rowsAfterHeader → Fetch value 1 row below header
				);
		*/


		try {
		        if (filePath == null || !filePath.exists()) {
		            test.log(LogStatus.FAIL, "❌ Excel file not found for validation.");
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

		        // Step 1: Get EPF Total value from column till "Total" row
		        double epfTotal = 0.0;
		        double fileTotal = -1;

		        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
		            Row row = sheet.getRow(i);
		            if (row == null) continue;

		            Cell firstCell = row.getCell(0);
		            if (firstCell != null && firstCell.getCellType() == CellType.STRING &&
		                firstCell.getStringCellValue().trim().equalsIgnoreCase(totalKeyword)) {

		                Cell totalCell = row.getCell(totalColumnIndex);
		                if (totalCell != null && totalCell.getCellType() == CellType.NUMERIC) {
		                    fileTotal = totalCell.getNumericCellValue();
		                } else {
		                    fileTotal = 0; // Treat empty/missing as 0
		                }
		                break;
		            }

		            Cell dataCell = row.getCell(totalColumnIndex);
		            if (dataCell != null && dataCell.getCellType() == CellType.NUMERIC) {
		                epfTotal += dataCell.getNumericCellValue();
		            }
		        }

		        // Step 2: Find "headerName" in column and get N rows below
		        double belowValue = -1;
		        boolean headerFound = false;

		        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
		            Row row = sheet.getRow(i);
		            if (row == null) continue;

		            Cell headerCell = row.getCell(dynamicHeaderColumnIndex);
		            if (headerCell != null) {
		                try {
		                    String headerVal = headerCell.toString().trim().toLowerCase();
		                    if (headerVal.contains(headerName.toLowerCase())) {
		                        Row targetRow = sheet.getRow(i + rowsAfterHeader);
		                        if (targetRow != null) {
		                            Cell targetCell = targetRow.getCell(dynamicHeaderColumnIndex);
		                            if (targetCell != null && targetCell.getCellType() == CellType.NUMERIC) {
		                                belowValue = targetCell.getNumericCellValue();
		                            } else {
		                                belowValue = 0; // If value missing, treat as 0
		                            }
		                            headerFound = true;
		                            break;
		                        }
		                    }
		                } catch (Exception e) {
		                    // Ignore and continue
		                }
		            }
		        }

		        workbook.close();

		        // 🔍 Logs
		        test.log(LogStatus.INFO, "📊 EPF Total: " + fileTotal);
		        test.log(LogStatus.INFO, "📉 " + headerName + " +" + rowsAfterHeader + " Row Value: " + belowValue);

		        if (!headerFound) {
		            test.log(LogStatus.FAIL, "❌ Header '" + headerName + "' not found in column index " + dynamicHeaderColumnIndex);
		            return;
		        }

		        if (fileTotal == -1) {
		            test.log(LogStatus.INFO, "ℹ️ 'Total' row found but value cell was empty or non-numeric. Assuming 0.");
		            fileTotal = 0;
		        }

		        if ((fileTotal == 0 && belowValue == 0) || Math.abs(fileTotal - belowValue) < 0.01) {
		            test.log(LogStatus.PASS, "✅ Matched: EPF = " + fileTotal + " & " + headerName + " = " + belowValue);
		        } else {
		            test.log(LogStatus.FAIL, "❌ Mismatch: EPF = " + fileTotal + ", " + headerName + " = " + belowValue);
		        }

		    } catch (Exception e) {
		        test.log(LogStatus.ERROR, "❌ Error: " + e.getMessage());
		        e.printStackTrace();
		    }
		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Method 4:
	

	//This code is working but need to modify from gpt taken from perplexity 
	public static void validateColumnWithCalculation_Enhanced(
		    ExtentTest test,
		    File excelFile,
		    String sheetName,
		    int baseColIndex,
		    int calcColIndex,
		    String operation,
		    double operand,
		    int headerRowIndex,
		    String logText,
		    double allowedTolerance
		) {
		    try (FileInputStream fis = new FileInputStream(excelFile)) {
		        Workbook workbook = WorkbookFactory.create(fis);
		        Sheet sheet = workbook.getSheet(sheetName);
		        if (sheet == null) {
		            test.log(LogStatus.FAIL, "❌ Sheet not found: " + sheetName);
		            return;
		        }
		        Row headerRow = sheet.getRow(headerRowIndex);
		        String baseHeader = "[Blank]";
		        String calcHeader = "[Blank]";
		        String baseColLetter = getExcelColumnLetter(baseColIndex);
		        String calcColLetter = getExcelColumnLetter(calcColIndex);
		        if (headerRow != null) {
		            Cell baseHeaderCell = headerRow.getCell(baseColIndex);
		            if (baseHeaderCell != null) baseHeader = baseHeaderCell.toString();
		            Cell calcHeaderCell = headerRow.getCell(calcColIndex);
		            if (calcHeaderCell != null) calcHeader = calcHeaderCell.toString();
		        }
		        // File info at top
		        String fileName = excelFile.getName();
		        String runTime = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
		        test.log(LogStatus.INFO, "📄 Data Fetch file name: <b>" + fileName + "</b>");
		        test.log(LogStatus.INFO, "📆 Report Generated: <b>" + runTime + "</b>");
		        test.log(LogStatus.INFO, "<b>" + logText + "</b>");

		        // Collect all valid (non-null, with data) row indices after header
		        List<Integer> allRowIndices = new ArrayList<>();
		        int lastRowIndex = sheet.getLastRowNum();
		        for (int i = headerRowIndex+1; i <= lastRowIndex; i++) {
		            Row row = sheet.getRow(i);
		            if (row == null) continue;
		            boolean hasData = false;
		            for (int j : new int[]{baseColIndex, calcColIndex, 0, 2}) {
		                Cell cc = row.getCell(j);
		                if (cc != null && cc.getCellType() != CellType.BLANK && !"".equals(cc.toString().trim())) {
		                    hasData = true;
		                    break;
		                }
		            }
		            if (hasData) allRowIndices.add(i);
		        }

		        // Pick first 5 valid data rows (after header)
		        List<Integer> rowsToReport = new ArrayList<>();
		        for (int i = 0; i < allRowIndices.size() && i < 5; i++) // i < 5 it will pick first 5 rows
		            rowsToReport.add(allRowIndices.get(i));

		        // Find the actual 'Total' row (where first column is "Total", case-insensitive)
		        Integer totalRowIdx = null;
		        for (Integer idx : allRowIndices) {
		            Row row = sheet.getRow(idx);
		            if (row != null) {
		                Cell slNoCell = row.getCell(0);
		                if (slNoCell != null && slNoCell.getCellType() == CellType.STRING
		                    && slNoCell.getStringCellValue().trim().equalsIgnoreCase("Total")) {
		                    totalRowIdx = idx;
		                    break;
		                }
		            }
		        }
		        // Only add if not already among first 5
		        if (totalRowIdx != null && !rowsToReport.contains(totalRowIdx)) {
		            rowsToReport.add(totalRowIdx);
		        }

		        // Compute summary for ALL checked rows (not just displayed)
		        int allRowsChecked = 0, allPassCount = 0, allFailCount = 0;
		        boolean anyFail = false;
		        for (Integer idx : allRowIndices) {
		            Row row = sheet.getRow(idx);
		            double baseValue = getCellNumericValue(row.getCell(baseColIndex));
		            double calcValue = getCellNumericValue(row.getCell(calcColIndex));
		            double expected = 0;
		            switch (operation) {
		                case "%": expected = round2(baseValue * operand / 100); break;
		                case "*": expected = round2(baseValue * operand); break;
		                case "+": expected = round2(baseValue + operand); break;
		                case "-": expected = round2(baseValue - operand); break;
		                default: expected = 0;
		            }
		            double diff = round2(Math.abs(calcValue - expected));
		            boolean pass = diff <= allowedTolerance;
		            allRowsChecked++;
		            if (pass) allPassCount++; else allFailCount++;
		            if (!pass) anyFail = true;
		        }

		        // Prepare table
		        StringBuilder htmlTable = new StringBuilder();
		        htmlTable.append("<table border='1' cellpadding='4' style='border-collapse:collapse'><tr>")
		            .append("<th>Row No.</th>")
		            .append("<th>Employee Name</th>")
		            .append("<th>").append(baseColLetter).append(": ").append(baseHeader).append("</th>")
		            .append("<th>").append(calcColLetter).append(": ").append(calcHeader).append("</th>")
		            .append("<th>Expected</th><th>Diff</th><th>Result</th></tr>");

		        for (Integer i: rowsToReport) {
		            Row row = sheet.getRow(i);
		            if (row == null) continue;
		            String empName = "";
		            Cell nameCell = row.getCell(2);
		            if (nameCell != null) empName = nameCell.toString();
		            // In summary/"Total" row, show "Total" or summary keyword in empName
		            Cell firstCell = row.getCell(0);
		            if (firstCell != null && firstCell.getCellType() == CellType.STRING &&
		                firstCell.getStringCellValue().trim().toLowerCase().contains("total"))
		                empName = firstCell.getStringCellValue();
		            double baseValue = getCellNumericValue(row.getCell(baseColIndex));
		            double calcValue = getCellNumericValue(row.getCell(calcColIndex));
		            double expected = 0;
		            switch (operation) {
		                case "%": expected = round2(baseValue * operand / 100); break;
		                case "*": expected = round2(baseValue * operand); break;
		                case "+": expected = round2(baseValue + operand); break;
		                case "-": expected = round2(baseValue - operand); break;
		                default: expected = 0;
		            }
		            double diff = round2(Math.abs(calcValue - expected));
		            boolean pass = diff <= allowedTolerance;
		            htmlTable.append("<tr><td>").append(i+1).append("</td>")
		                .append("<td>").append(empName).append("</td>")
		                .append("<td>").append(baseValue).append("</td>")
		                .append("<td>").append(calcValue).append("</td>")
		                .append("<td>").append(expected).append("</td>")
		                .append("<td>").append(diff).append("</td>")
		                .append("<td>")
		                .append(pass ? "<span style='color:green;font-weight:bold;'>PASS</span>"
		                             : "<span style='color:red;font-weight:bold;'>FAIL</span>")
		                .append("</td></tr>");
		        }
		        htmlTable.append("</table>");

		        if (anyFail)
		            test.log(LogStatus.FAIL, htmlTable.toString());
		        else
		            test.log(LogStatus.PASS, htmlTable.toString());

		        // Show real summary stats across ALL checked rows
		        test.log(anyFail ? LogStatus.FAIL : LogStatus.PASS,
		            "<b>Summary:</b> Checked: " + allRowsChecked 
		            + ", Passed: " + allPassCount 
		            + ", Failed: " + allFailCount);

		    } catch (Exception e) {
		        test.log(LogStatus.ERROR, "❌ Exception in calculation: " + e.getMessage());
		        e.printStackTrace();
		    }
		}
		// --- Helpers ---
		private static String getExcelColumnLetter(int colNum) {
		    StringBuilder sb = new StringBuilder();
		    while (colNum >= 0) {
		        sb.insert(0, (char) ('A' + (colNum % 26)));
		        colNum = (colNum / 26) - 1;
		    }
		    return sb.toString();
		}
		private static double getCellNumericValue(Cell c) {
		    if (c == null) return 0;
		    if (c.getCellType() == CellType.NUMERIC) return c.getNumericCellValue();
		    try { return Double.parseDouble(c.toString().trim()); } catch (Exception e) { return 0; }
		}
		private static double round2(double val) {
		    return Math.round(val * 100.0) / 100.0;
		}




	
	
			


		

        }
	
	
	
	
	
	
	
	/**
	
	
// HTML Report block (use normalizedFoundNames for presence checks)
if (ENABLE_HTML_REPORT_TABLE) {

//OLD Table---

//    StringBuilder htmlTable = new StringBuilder();
//
//    String masterColLetter = getExcelColumnLetter2(master.getEmpNameColumnIndex());
//    String masterHeader = getHeaderValue(master.getFilePath(), master.getSheetName(), master.getEmpNameColumnIndex());
//
//    String downloadedColLetter = getExcelColumnLetter2(target.getColumnIndex());
//    String downloadedHeader = target.getHeaderKeyword() != null ? target.getHeaderKeyword() : "";
//
//    String masterColumnHeader = masterColLetter + ": " + masterHeader;
//    String downloadedColumnHeader = downloadedColLetter + ": " + downloadedHeader;
//
//    htmlTable.append("<br><b>📊 Sample Comparison Table:</b><br>")
//            .append("<table border='1' cellpadding='4' style='border-collapse:collapse; text-align:center; font-family:Arial, sans-serif;'>")
//            .append("<tr style='background-color:#f2f2f2;'>")
//            .append("<th style='width:60px;'>Row No.<br><small>&nbsp;</small></th>")
//            .append("<th>Master Value<br><small>").append(masterColumnHeader).append("</small></th>")
//            .append("<th>Downloaded Value<br><small>").append(downloadedColumnHeader).append("</small></th>")
//            .append("<th>Result<br><small>&nbsp;</small></th>")
//            .append("</tr>");
//
//    int rowNum = 1;
//    for (String masterValue : filteredNames) {
//        if (rowNum > 5) break; // Show only first 5 rows
//
//        boolean isPresent = normalizedFoundNames.contains(masterValue);
//        String matchResult = isPresent
//                ? "<span style='color:green;font-weight:bold;'>PASS</span>"
//                : "<span style='color:red;font-weight:bold;'>FAIL</span>";
//        String downloadedMatch = isPresent ? masterValue : "❌ Not Found";
//
//        htmlTable.append("<tr>")
//                .append("<td>").append(rowNum).append("</td>")
//                .append("<td>").append(masterValue).append("</td>")
//                .append("<td>").append(downloadedMatch).append("</td>")
//                .append("<td>").append(matchResult).append("</td>")
//                .append("</tr>");
//
//        rowNum++;
//    }
//
//    htmlTable.append("</table>");
//    test.log(LogStatus.INFO, htmlTable.toString());
	
	
	
	
	//Need to work
	 //New table:
	
/**              	      //New table:
	
	     // ===== Clean UI HTML table (drop-in) =====
	
	    StringBuilder htmlTable = new StringBuilder();

	    String masterColLetter = getExcelColumnLetter2(master.getEmpNameColumnIndex());
	    String masterHeader = getHeaderValue(master.getFilePath(), master.getSheetName(), master.getEmpNameColumnIndex());

	    String downloadedColLetter = getExcelColumnLetter2(target.getColumnIndex());
	    String downloadedHeader = (target.getHeaderKeyword() != null ? target.getHeaderKeyword() : "");

	    String masterColumnHeader = masterColLetter + ": " + masterHeader;      // e.g., F: EmpName
	    String downloadedColumnHeader = downloadedColLetter + (downloadedHeader.isEmpty() ? "" : (": " + downloadedHeader)); // e.g., C: EmpName

	    // Title
	    htmlTable.append("<div style='margin:6px 0 10px; font-weight:700; font-family:Arial, sans-serif;'>")
	             .append("Sample Comparison Table")
	             .append("</div>");

	    // Table header (v2-friendly: keep border attribute + inline styles; avoid <thead>/<tbody> if renderer is picky)
	    htmlTable.append("<table border='1' style='border-collapse:collapse; width:100%; font-family:Arial, sans-serif; font-size:13px; text-align:center;'>")
	             .append("<tr style='background:#f7f7f9;'>")
	             .append("<th style='border:1px solid #e5e7eb; padding:8px 10px; text-transform:uppercase; letter-spacing:.4px; min-width:80px; white-space:nowrap;'>Row No.</th>")
	             .append("<th style='border:1px solid #e5e7eb; padding:8px 10px; text-transform:uppercase; letter-spacing:.4px; min-width:220px; white-space:nowrap;'>MASTER VALUE<br><span style='font-weight:400; font-size:12px;'>")
	             .append(masterColumnHeader)
	             .append("</span></th>")
	             .append("<th style='border:1px solid #e5e7eb; padding:8px 10px; text-transform:uppercase; letter-spacing:.4px; min-width:220px; white-space:nowrap;'>DOWNLOADED VALUE<br><span style='font-weight:400; font-size:12px;'>")
	             .append(downloadedColumnHeader)
	             .append("</span></th>")
	             .append("<th style='border:1px solid #e5e7eb; padding:8px 10px; text-transform:uppercase; letter-spacing:.4px; min-width:120px; white-space:nowrap;'>Result</th>")
	             .append("</tr>");

	    int rowNum = 1;
	    for (String masterValue : filteredNames) {
	        if (rowNum > 5) break; // Show only first 5 rows

	        boolean isPresent = normalizedFoundNames.contains(masterValue);
	        String downloadedMatch = isPresent ? masterValue : "Not Found";
	        String pill = isPresent
	                ? "<span style='display:inline-block; padding:2px 12px; border-radius:999px; background:#ecfdf5; color:#065f46; font-weight:700;'>PASS</span>"
	                : "<span style='display:inline-block; padding:2px 12px; border-radius:999px; background:#fef2f2; color:#991b1b; font-weight:700;'>FAIL</span>";

	        htmlTable.append("<tr>")
	                 .append("<td style='border:1px solid #e5e7eb; padding:10px; white-space:nowrap;'>").append(rowNum).append("</td>")
	                 .append("<td style='border:1px solid #e5e7eb; padding:10px; white-space:nowrap;'>").append(masterValue).append("</td>")
	                 .append("<td style='border:1px solid #e5e7eb; padding:10px; white-space:nowrap;'>").append(downloadedMatch).append("</td>")
	                 .append("<td style='border:1px solid #e5e7eb; padding:10px;'>").append(pill).append("</td>")
	                 .append("</tr>");

	        rowNum++;
	    }

	    htmlTable.append("</table>");

	    // ---- v2-safe logging (swap args so HTML goes in details area) ----
	    String htmlOut = htmlTable.toString();
	    test.log(LogStatus.INFO, "", htmlOut);
	
	// ===== End drop-in block =====

 } // end HTML report
	
**/	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	


