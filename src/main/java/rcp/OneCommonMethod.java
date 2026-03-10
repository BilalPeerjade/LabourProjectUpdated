package rcp;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
//Export Imports
//Selenium imports
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

import coordinator.CoordinatorLocator;
import distributor.Locators;
import login.BasePage;
import login.LoginLocators;

//Java standard libraries
import java.io.FileInputStream;
import java.time.Duration;

//Disabled Fields:
import java.util.Objects;


public class OneCommonMethod extends BasePage{
	
	
    public static String takeScreenshotBase64(WebDriver driver) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(src);
            return "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
            return null;
        }
    }
    
    //Method if test case is failed
/*   public static void captureScreenshotOnFailure(WebDriver driver, ExtentTest test, boolean isTestFailed) {
        if (isTestFailed) {
            try {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                byte[] fileContent = FileUtils.readFileToByteArray(src);
                String base64Screenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);

                test.log(LogStatus.FAIL, "Test failed - Screenshot captured",
                        test.addBase64ScreenShot(base64Screenshot));
            } catch (IOException e) {
                test.log(LogStatus.ERROR, "Screenshot capture failed: " + e.getMessage());
            }
        }
    }
*/
    public static void captureScreenshotOnFailure(WebDriver driver, ExtentTest test, boolean isTestFailed) {
        if (isTestFailed) {
            try {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                byte[] fileContent = FileUtils.readFileToByteArray(src);
                String base64Screenshot = "data:image/png;base64," + Base64.getEncoder().encodeToString(fileContent);

                test.log(LogStatus.UNKNOWN, "Test failed - Screenshot captured",
                        test.addBase64ScreenShot(base64Screenshot));
            } catch (IOException e) {
                test.log(LogStatus.UNKNOWN, "Screenshot capture failed: " + e.getMessage());
            }
        }
    }

    
 // OneCommonMethod.java  ──────────────── Calling below:
//    OneCommonMethod.scroll(driver.get(), 400);   // 400 px down 
//    OneCommonMethod.scroll(driver.get(), -400);  // 400 px up
    public static void scroll(WebDriver driver, int yOffset) {
        try {
            ((JavascriptExecutor) driver)
                    .executeScript("window.scrollBy(0, arguments[0]);", yOffset);
            Thread.sleep(500);                 // thoda settle hone do
        } catch (Exception e) {
            // Yahan apna Extent log ya console print
            // System.out.println("Scroll failed: " + e.getMessage());
        }
    }
    

  //It will generate Random String just need to call 'getRandomString'
    public static String getRandomString() {
        return new java.util.Random().ints(6, 0, 62)
            .mapToObj(i -> "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(i))
            .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
            .toString();
    }

    public static void zoomOutScreen(int times) {
        try {
            Robot robot = new Robot();
            for (int i = 0; i < times; i++) {
            	Thread.sleep(2000);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_MINUS);
                robot.keyRelease(KeyEvent.VK_MINUS);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                Thread.sleep(2000); // thoda delay zoom-out ke beech
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    OneCommonMethod.setZoom(getDriver(), 80);
    public static void setZoom(WebDriver driver, int percent) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.body.style.zoom='" + percent + "%'");
            System.out.println("✅ Zoom set to " + percent + "% inside container");
            Thread.sleep(2000); 
        } catch (Exception e) {
            System.out.println("❌ Zoom change failed: " + e.getMessage());
        }
    }

    

    
    public static void explicitWaitForElementClickable(WebDriver driver, WebElement element, int durationInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            System.out.println("❌ Element not clickable within " + durationInSeconds + " seconds");
        }
    }

    
    
    
    
    
    
    
    
    
    

    
 //Export Start ------------

    public static void validateExportedExcel(WebDriver driver, ExtentTest test, WebElement exportButton, WebElement gridCountElement, String columnHeaderToCount) {
        try {
//            WebDriverWait wait = new WebDriverWait(getDriver(), 15);
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(120));
            
            
            Thread.sleep(5000);
            // Step 1: Get grid count from WebElement (already fetched)
            String itemText = gridCountElement.getText();  // Example: "1 – 1 of 1 items"
            String[] words = itemText.split(" ");
            String countStr = words[words.length - 2];

            if (countStr.equalsIgnoreCase("to")) {
                Thread.sleep(5000);
                itemText = gridCountElement.getText();
                words = itemText.split(" ");
                countStr = words[words.length - 2];
            }

            int gridCount = Integer.parseInt(countStr.trim());

            // Step 2: Count files before export
            String downloadPath = System.getProperty("user.home") + "\\Downloads";
            File dirBefore = new File(downloadPath);
            File[] filesBefore = dirBefore.listFiles();
            
            Thread.sleep(5000);
            // Step 3: Click Export
            scrollBy(driver, -500);
            wait.until(ExpectedConditions.elementToBeClickable(exportButton)).click();

            Thread.sleep(5000);
            // Step 4: Wait for file
            File downloadedFile = waitForNewFile(downloadPath, filesBefore, 20);
            if (downloadedFile == null) {
                test.log(LogStatus.FAIL, "❌ File did not download.");
                return;
            }

  //        test.log(LogStatus.PASS, "✅ File downloaded: " + downloadedFile.getName());
  //        test.log(LogStatus.PASS, "✅ <b>File Downloaded</b><br><b>File Name:</b> " + downloadedFile.getName());
            test.log(LogStatus.PASS, "File downloaded ");
            test.log(LogStatus.PASS, "File Name is :  " + downloadedFile.getName());


            // Step 5: Read Excel
            Thread.sleep(5000);
            FileInputStream fis = new FileInputStream(downloadedFile);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            Thread.sleep(5000);
            int targetColumn = findColumnIndex(sheet, columnHeaderToCount);
            int excelRowCount = 0;

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header
                Cell cell = row.getCell(targetColumn);
                if (cell != null && cell.getCellType() != CellType.BLANK) {
                    excelRowCount++;
                }
            }

            fis.close();

            // Step 6: Compare
            if (gridCount == excelRowCount) {
                test.log(LogStatus.PASS, "Grid Count = " + gridCount + " | Excel Row Count = " + excelRowCount);
            } else {
                test.log(LogStatus.FAIL, "❌ Mismatch: Grid Count = " + gridCount + " | Excel Row Count = " + excelRowCount);
            }

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "❌ Exception: ");
            e.printStackTrace();
        }
    }

    // helpers remain same (scrollBy, waitForNewFile, findColumnIndex)
   

    private static void scrollBy(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

    private static File waitForNewFile(String dirPath, File[] oldFiles, int timeoutSeconds) throws InterruptedException {
        File dir = new File(dirPath);
        long end = System.currentTimeMillis() + timeoutSeconds * 1000;

        while (System.currentTimeMillis() < end) {
            File[] newFiles = dir.listFiles();
            if (newFiles != null && newFiles.length > oldFiles.length) {
                File latestFile = newFiles[0];
                for (int i = 1; i < newFiles.length; i++) {
                    if (latestFile.lastModified() < newFiles[i].lastModified()) {
                        latestFile = newFiles[i];
                    }
                }
                return latestFile;
            }
            Thread.sleep(1000);
        }
        return null;
    }

    private static int findColumnIndex(Sheet sheet, String columnName) {
        Row headerRow = sheet.getRow(0);
        if (headerRow == null) return 0;

        for (Cell cell : headerRow) {
            if (cell.getStringCellValue().trim().equalsIgnoreCase(columnName)) {
                return cell.getColumnIndex();
            }
        }
        return 0;
    }
    
    
//Export End----to call use this: OneCommonMethod.validateExportedExcel(driver.get(), test, Locators.Export(), "Clientid");
    
    
    
    
    
    
    
    
    
    //Dynamic Export Excel File Code:----
    
    /**
     *  Re-usable Excel-export validator
     *  • successLogMessage  → sirf PASS hone par report me aayega
     *  • 2× scroll-down before reading grid count (200px each)
     *  • 2× scroll-up before clicking Export (200px each)
     *  • WebElements hi pass kare; By ki zaroorat nahin
     */
	public static void validateExportedExcelDYNAMIC(WebDriver driver, ExtentTest test, WebElement exportButton, WebElement gridCountElement, String columnHeaderToCount, String successLogMessage) 
	{
        try {
//            WebDriverWait wait = new WebDriverWait(driver, 15);
            WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(120));

            /* ---------- STEP-1: Scroll down twice & read grid count ---------- */
            for (int i = 0; i < 2; i++) {          // 2× down (200 px)
                scrollBy(driver, 200);
                Thread.sleep(5000);
            }

            String itemText  = gridCountElement.getText();        // e.g. "1 – 1 of 1 items"
            String[] words   = itemText.split(" ");
            String countStr  = words[words.length - 2];

            if (countStr.equalsIgnoreCase("to")) {                // sometimes "1 to 1 of 1"
                Thread.sleep(5000);
                itemText  = gridCountElement.getText();
                words     = itemText.split(" ");
                countStr  = words[words.length - 2];
            }

            int gridCount = Integer.parseInt(countStr.trim());

            //---------- STEP-2: Count files in Downloads BEFORE export ----------/
            String downloadPath = System.getProperty("user.home") + "\\Downloads";
            File   dirBefore    = new File(downloadPath);
            File[] filesBefore  = dirBefore.listFiles();
            Thread.sleep(5000);

            //---------- STEP-3: Scroll up twice & click Export ---------- /
            for (int i = 0; i < 2; i++) {          // 2× up (-200 px)
                scrollBy(driver, -200);
                Thread.sleep(5000);
            }

            wait.until(ExpectedConditions.elementToBeClickable(exportButton)).click();
//            Thread.sleep(50000);
//            Thread.sleep(15000);
            Thread.sleep(15000); //Wait for file download

            // ---------- STEP-4: Wait for new file ----------/
            File downloadedFile = waitForNewFile(downloadPath, filesBefore, 20);
            if (downloadedFile == null) {
                test.log(LogStatus.FAIL, "❌ File did not download.");
                return;
            }

            //---------- STEP-5: Read Excel & count rows ---------- /
            Thread.sleep(5000);
            FileInputStream fis = new FileInputStream(downloadedFile);
            Workbook workbook   = new XSSFWorkbook(fis);
            Sheet    sheet      = workbook.getSheetAt(0);

            int targetColumn    = findColumnIndex(sheet, columnHeaderToCount);
            int excelRowCount   = 0;

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;          // skip header
                Cell cell = row.getCell(targetColumn);
                if (cell != null && cell.getCellType() != CellType.BLANK) {
                    excelRowCount++;
                }
            }
            fis.close();

            //---------- STEP-6: Compare & LOG ----------/
            if (gridCount == excelRowCount) {
                test.log(LogStatus.PASS, "" + successLogMessage);                     // only on PASS
                test.log(LogStatus.PASS, "File Name : " + downloadedFile.getName());
                test.log(LogStatus.PASS, "Grid Count = " + gridCount +
                                          " | Excel Row Count = " + excelRowCount);
            } else {
                test.log(LogStatus.FAIL, "❌ Mismatch: Grid Count = " + gridCount +
                                          " | Excel Row Count = " + excelRowCount);
            }

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "❌ Exception during export validation.");
            e.printStackTrace();
        }
    }

    // ========== helpers remain unchanged ========== 
    private static void scrollBy1(WebDriver driver, int pixels) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ")");
    }

    
    
    
    
    
    
    
    
    
    
    
    //------------Download Code------------
    public static void validateFileDownload(WebDriver driver, ExtentTest test, WebElement downloadButton) {
        try {
//            String downloadPath = "C:\\Users\\bilali\\Downloads";
        	String downloadPath = System.getProperty("user.home") + File.separator + "Downloads";
            File downloadDir = new File(downloadPath);
            File[] filesBefore = downloadDir.listFiles();

            Thread.sleep(5000);

            // Use WebElement directly
            downloadButton.click();

            Thread.sleep(10000);

            File[] filesAfter = downloadDir.listFiles();
            Thread.sleep(3000);

            File downloadedFile = null;
            if (filesAfter.length > filesBefore.length) {
                for (File file : filesAfter) {
                    boolean isNew = true;
                    for (File oldFile : filesBefore) {
                        if (file.getName().equals(oldFile.getName())) {
                            isNew = false;
                            break;
                        }
                    }
                    if (isNew) {
                        downloadedFile = file;
                        break;
                    }
                }
            }

            if (downloadedFile != null) {
                test.log(LogStatus.PASS, "File downloaded.");
                test.log(LogStatus.PASS, "File Name is : " + downloadedFile.getName());
            } else {
                test.log(LogStatus.FAIL, "File was not downloaded.");
            }

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "❌ Exception during file download ");
        }
    }
    
    
	public static void validateFileDownloadDynamic(WebDriver driver, ExtentTest test, WebElement downloadButton, String logMessage) {
        try {
//            String downloadPath = "C:\\Users\\bilali\\Downloads";
            String downloadPath = System.getProperty("user.home") + File.separator + "Downloads";
            File downloadDir = new File(downloadPath);
            File[] filesBefore = downloadDir.listFiles();

//            Thread.sleep(80000);

            downloadButton.click();
//            Thread.sleep(50000);
            Thread.sleep(5000);

            File[] filesAfter = downloadDir.listFiles();
            Thread.sleep(8000);

            File downloadedFile = null;
            if (filesAfter.length > filesBefore.length) {
                for (File file : filesAfter) {
                    boolean isNew = true;
                    for (File oldFile : filesBefore) {
                        if (file.getName().equals(oldFile.getName())) {
                            isNew = false;
                            break;
                        }
                    }
                    if (isNew) {
                        downloadedFile = file;
                        break;
                    }
                }
            }
//            Thread.sleep(50000);
            Thread.sleep(5000);

            if (downloadedFile != null) {
                test.log(LogStatus.PASS, "" + logMessage);
                test.log(LogStatus.PASS, "File Name is : " + downloadedFile.getName());
            } else {
                test.log(LogStatus.FAIL, "" + logMessage + " - File was not downloaded.");
            }

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Exception during download: " + logMessage);
        }
    }
	
	
	public static void validateFileDownloadDynamicMASTER(WebDriver driver, ExtentTest test, WebElement downloadButton,
			String logMessage ,long timeSleep) {

	    try {
	        // ✅ Generic download path (Windows / Linux / Docker friendly)
	        String downloadPath = System.getProperty("user.home")
	                + File.separator + "Downloads";

	        File downloadDir = new File(downloadPath);
	        File[] filesBefore = downloadDir.listFiles();

	        downloadButton.click();
	        Thread.sleep(5000);
	        Thread.sleep(timeSleep);
	        
	        File[] filesAfter = downloadDir.listFiles();
	        Thread.sleep(8000);
	        Thread.sleep(timeSleep);

	        File downloadedFile = null;
	        Thread.sleep(timeSleep);
	        if (filesBefore != null && filesAfter != null
	                && filesAfter.length > filesBefore.length) {

	            for (File file : filesAfter) {
	                boolean isNew = true;

	                for (File oldFile : filesBefore) {
	                    if (file.getName().equals(oldFile.getName())) {
	                        isNew = false;
	                        break;
	                    }
	                }

	                if (isNew) {
	                    downloadedFile = file;
	                    break;
	                }
	            }
	        }

	        Thread.sleep(3000);

	        if (downloadedFile != null) {
	            test.log(LogStatus.PASS, logMessage);
	            test.log(LogStatus.PASS,
	                    "Downloaded File Name : " + downloadedFile.getName());
	        } else {
	            test.log(LogStatus.FAIL,
	                    logMessage + " - File was not downloaded");
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.FAIL,
	                "Exception during download : " + logMessage
	                        + " | " + e.getMessage());
	    }
	}


    
	public static void uploadUsingRobot(String filePath) throws Exception {
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        Thread.sleep(200);

        Robot robot = new Robot();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
    }
    
    
    //Testing:
    public static void uploadFileWithoutRobot(WebDriver driver, By fileInputLocator, String filePath, By uploadButton) throws Exception {
        
        // 1: Convert to absolute path (like Robot used clipboard)
        File file = new File(filePath);
        String absolute = file.getAbsolutePath();
        if(!file.exists()) {
            throw new RuntimeException("File not found: " + absolute);
        }

        // 2: Find <input type="file"> (Robot normally opened dialog, we directly target input)
        WebElement fileInput = driver.findElement(fileInputLocator);

        // If input is hidden → temporarily show it (Robot me nahi tha but docker me zaroori)
        try {
            if (!fileInput.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].style.display='block'; arguments[0].style.visibility='visible'; arguments[0].style.opacity=1;",
                        fileInput);
            }
        } catch (Exception ignored) {}

        // 3: Direct sendKeys (replacement of CTRL+V in Robot)
        fileInput.sendKeys(absolute);

        // 4: Click Upload (replacement of ENTER in Robot)
        Thread.sleep(3000);
        WebElement uploadBtn = driver.findElement(uploadButton);
        uploadBtn.click();

        // 5: Small wait
        Thread.sleep(1000);
    }

    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    //Method for Type to search 
	public static void searchAndLogMultipleKeywords(WebDriver driver, Map<String, List<String>> searchMap, WebElement searchBox, WebElement clearButton, ExtentTest test) 
	{
        try {
            Thread.sleep(3000);

            for (String columnName : searchMap.keySet()) {
                for (String keyword : searchMap.get(columnName)) {
                    try {
                        searchBox.clear();
                        searchBox.sendKeys(keyword, Keys.ENTER);
                        Thread.sleep(3000);

                        try {
                            WebElement cell = driver.findElement(By.xpath("//div[@title='" + keyword + "']"));
                            test.log(LogStatus.PASS, "Searched and found record under '" + columnName + "' column: " + keyword);
                        } catch (Exception e) {
                            test.log(LogStatus.INFO, "No record available for search keyword: '" + keyword + "' under column: '" + columnName + "'");
                        }

                        Thread.sleep(2000);
                        clearButton.click();
                        Thread.sleep(1000);

                    } catch (Exception innerEx) {
                        test.log(LogStatus.FAIL, "Search failed for keyword: '" + keyword + "'");
                        innerEx.printStackTrace();
                    }
                }
            }

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Exception occurred during multiple keyword search");
            e.printStackTrace();
        }
    }

    
  //Not working  
 /*   public static void validateFileUpload_Workspace(WebDriver driver, ExtentTest test, WebElement browseButton, WebElement uploadButton, WebElement messageElement, String filePath, String expectedText, String customMessage) {
        try {
            Thread.sleep(2000);
            browseButton.click();
            Thread.sleep(2000);

            Robot robot = new Robot();
            StringSelection filepath = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);

            robot.keyPress(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_V);
            Thread.sleep(2000);
            robot.keyRelease(KeyEvent.VK_V);
            Thread.sleep(2000);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            robot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(2000);
            uploadButton.click();
            Thread.sleep(3000);

            String actualMessage = messageElement.getText();

            if (actualMessage.equalsIgnoreCase(expectedText)) {
                test.log(LogStatus.PASS, customMessage + " " + actualMessage);
            } else {
                test.log(LogStatus.FAIL, customMessage + " Unexpected Message: " + actualMessage);
            }

        } catch (Exception ex) {
            test.log(LogStatus.FAIL, customMessage + " Something went wrong during upload process.");
        }
    }
*/

    public static void verifyTestEntity(WebDriver driver, ExtentTest test, By entityLocator, String expectedText) {
        try {
        	WebDriverWait wait=new WebDriverWait(getDriver(), Duration.ofSeconds(120));
            wait.until(ExpectedConditions.visibilityOfElementLocated(entityLocator));

            WebElement entityElement = driver.findElement(entityLocator);
            String actualText = entityElement.getText().trim();

            if (!actualText.contains(expectedText)) {
                test.log(LogStatus.FAIL, "Wrong entity detected. Found: " + actualText + " | Expected to contain: " + expectedText);
                throw new RuntimeException("Entity mismatch - stopping test.");
            }

        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Entity validation failed or not found.");
            throw new RuntimeException("Entity check failed.");
        }
    }
    
         
    
    
    
    
    
    
    //Distributor Performer Reviewer Logins:--Entity search:
    // OneCommonMethod.java
 //   OneCommonMethod.searchEntityAndSelect(driver.get(),test,LoginLocators.Search(),"AVACORED5");
	public static boolean searchEntityAndSelect(WebDriver driver, ExtentTest test, WebElement searchBox, String entityId)
	{
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // implicit wait for whole method

		//This is Entity Id column Xpath + EntityId which we are sending through send keys
		By gridCell = By.xpath("//div[@class='cell-content' and normalize-space()='" + entityId + "']");

		for (int attempt = 1; attempt <= 2; attempt++) {
			try {
				searchBox.clear();
				Thread.sleep(1500);
				searchBox.sendKeys(entityId);
				Thread.sleep(1000); // your preferred fixed pause

				WebElement row = driver.findElement(gridCell); // will auto‑wait up to 10 s
				row.click(); // proceed with entity
// hide report log // test.log(LogStatus.PASS, "Entity <b>" + entityId + "</b> found on attempt " + attempt);
				return true;
			} catch (Exception e) {
                // not found on this attempt – loop tries once more
			}
		}
		test.log(LogStatus.FAIL, "Entity <b>" + entityId + "</b> not visible in grid after two attempts");
		return false;
	}
    
	
	

	
	
	public static void selectCalendarDateFromInput(WebDriver driver, ExtentTest test, WebElement calendarOpener,
			WebElement navigateToParentView, String inputDate) {
		try {
			// Step 0: Convert "01-01-2024" to "Monday, January 1, 2024"
			SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat fullTitleFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
			SimpleDateFormat monthShortFormat = new SimpleDateFormat("MMM");
			SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

			Date date = inputFormat.parse(inputDate);

			String fullTitle = fullTitleFormat.format(date);
			String monthShort = monthShortFormat.format(date);
			String year = yearFormat.format(date);

			// Step 1: Open Calendar
			//calendarOpener.click();
			Thread.sleep(2000);

			// Step 2: Go to parent view (month/year level)
			navigateToParentView.click();
			Thread.sleep(2000);

			// Step 3: Select year
			WebElement yearElement = driver.findElement(By.xpath("//span[normalize-space()='" + year + "']"));
			yearElement.click();
			Thread.sleep(2000);

			// Step 4: Select month
			WebElement monthElement = driver.findElement(By.xpath("//td[@title='" + year + " " + monthShort + "']"));
			monthElement.click();
			Thread.sleep(3000);

			// Step 5: Select date
			WebElement dateElement = driver.findElement(By.xpath("//td[@title='" + fullTitle + "']"));
			dateElement.click();
			Thread.sleep(2000);

	//		test.log(LogStatus.PASS, "✅ Date selected successfully: " + fullTitle);
			System.out.println("Date is selected ");

		} catch (Exception e) {
		//	test.log(LogStatus.FAIL, "❌ Failed to select date: " + e.getMessage());
			System.out.println("Date is not selected ");
			e.printStackTrace();
		}
	}
	
	
	
	
	



	public static void verifyFieldIsTrulyNonEditable(WebElement element, ExtentTest test, String fieldName, String customMessage) {
	    try {
	        String originalValue = element.getAttribute("value");
	        try {
	            element.clear();
	            element.sendKeys("123456");
	        } catch (Exception e) {
	            // Ignore; input is blocked
	        }

	        String afterValue = element.getAttribute("value");

	        if (Objects.equals(originalValue, afterValue)) {
	            test.log(LogStatus.PASS, fieldName + " is non-editable. " + customMessage);
	        } else {
	            test.log(LogStatus.FAIL, fieldName + " is editable. " + customMessage + 
	                     " (Value changed from '" + originalValue + "' to '" + afterValue + "')");
	        }
	    } catch (Exception e) {
	          System.out.println("");
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void validateExcelTotal(WebDriver driver,ExtentTest test,By downloadLocator,String columnName,String sheetName,String logDescription) {
	   
		/**
		 * 📌 This common method does end-to-end validation of an Excel column total.
		 *
		 * ✅ Steps performed in this method:
		 *
		 * 1. Get the system's dynamic Downloads path.
		 * 2. Capture the list of files before download starts.
		 * 3. Click the download button using the provided locator (By).
		 * 4. Wait and identify the newly downloaded .xlsx file.
		 * 5. Open the Excel file and access the specified sheet (e.g., "Pending").
		 * 6. Locate the correct header row (default: second row / index 1).
		 * 7. Find the index of the column based on the provided column name (e.g., "Basic Wages").
		 * 8. Iterate through all rows after header:
		 *    - Keep summing all numeric values in that column.
		 *    - Stop when "Total" is found in first column; capture that total value from same column.
		 * 9. Compare the calculated sum vs total cell:
		 *    - If no data found, log as PASS.
		 *    - If both values match, log as PASS.
		 *    - If mismatch, log as FAIL.
		 * 10. Catch and log any exceptions as ERROR.
		 *
		 * 📎 All parameters (locator, column name, sheet name, log message) are dynamic.
		 * 🔁 Designed for reusability across modules (PF, ESI, PT, etc.).
		 */
		
		try {
	        // Step 1: Get user's Downloads directory
	        String downloadPath = System.getProperty("user.home") + File.separator + "Downloads";
	        File downloadDir = new File(downloadPath);
	        File[] beforeDownload = downloadDir.listFiles();

	        // Step 2: Trigger download
	        driver.findElement(downloadLocator).click();
	        Thread.sleep(10000); // Wait for download

	        // Step 3: Find new downloaded file
	        File[] afterDownload = downloadDir.listFiles();
	        File latestFile = null;
	        long lastModified = Long.MIN_VALUE;

	        for (File file : afterDownload) {
	            boolean isNew = true;
	            for (File old : beforeDownload) {
	                if (file.getName().equals(old.getName()) && file.lastModified() == old.lastModified()) {
	                    isNew = false;
	                    break;
	                }
	            }
	            if (isNew && file.getName().endsWith(".xlsx") && file.lastModified() > lastModified) {
	                latestFile = file;
	                lastModified = file.lastModified();
	            }
	        }

	        if (latestFile == null) {
	            test.log(LogStatus.FAIL, "❌ File not downloaded.");
	            return;
	        } else {
	            test.log(LogStatus.PASS, "✅ File downloaded: " + latestFile.getName());
	        }

	        // Step 4: Open Excel and get sheet
	        FileInputStream fis = new FileInputStream(latestFile);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheet(sheetName);

	        if (sheet == null) {
	            test.log(LogStatus.PASS, "'" + sheetName + "' sheet not found. No data to process.");
	            workbook.close(); fis.close();
	            return;
	        }

	        // Step 5: Find column index
	        int headerRowNum = 1; // second row (index 1)
	        Row headerRow = sheet.getRow(headerRowNum);
	        int targetCol = -1;

	        for (Cell cell : headerRow) {
	            if (cell.getCellType() == CellType.STRING &&
	                cell.getStringCellValue().trim().equalsIgnoreCase(columnName)) {
	                targetCol = cell.getColumnIndex();
	                break;
	            }
	        }

	        if (targetCol == -1) {
	            workbook.close(); fis.close();
	            test.log(LogStatus.PASS, "'" + columnName + "' column NOT found, no data to process.");
	            return;
	        }

	        // Step 6: Sum values and find total
	        double calculatedSum = 0;
	        double expectedTotal = 0;
	        boolean dataFound = false;

	        for (int i = headerRowNum + 1; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);
	            if (row == null) continue;

	            Cell firstCol = row.getCell(0);
	            if (firstCol != null && firstCol.getCellType() == CellType.STRING &&
	                firstCol.getStringCellValue().trim().equalsIgnoreCase("Total")) {

	                Cell totalCell = row.getCell(targetCol);
	                if (totalCell != null && totalCell.getCellType() == CellType.NUMERIC) {
	                    expectedTotal = totalCell.getNumericCellValue();
	                }
	                break;
	            }

	            Cell valCell = row.getCell(targetCol);
	            if (valCell != null && valCell.getCellType() == CellType.NUMERIC) {
	                calculatedSum += valCell.getNumericCellValue();
	                dataFound = true;
	            }
	        }

	        workbook.close(); fis.close();

	        // Step 7: Final check
	        if (!dataFound) {
	            test.log(LogStatus.PASS, "✅ No data found for '" + columnName + "' — treated as PASS.");
	        } else if (Math.abs(calculatedSum - expectedTotal) < 0.001) {
	            test.log(LogStatus.PASS, "✅ " + logDescription + " matched: " +
	                "Calculated = " + calculatedSum + ", Total = " + expectedTotal);
	        } else {
	            test.log(LogStatus.FAIL, "❌ " + logDescription + " mismatch: " +
	                "Calculated = " + calculatedSum + ", Total = " + expectedTotal);
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.ERROR, "❌ Exception during " + logDescription + ": " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	
	//-----------------Type Like Real User------------------
	public static void typeLikeUser(WebElement element, String value, int batchSize, int timeDelay) {
	    element.click();     // normal click first
	    element.clear();

	    int i = 0;
	    while (i < value.length()) {
	        int end = Math.min(i + batchSize, value.length());
	        element.sendKeys(value.substring(i, end));
	        i = end;
	        try {
	            Thread.sleep(timeDelay); // small human delay
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
	}
	
	
	
	//-----------------------------Clear button validations-----------------------------
	public static void verifyClearButton(WebDriver driver, ExtentTest test, WebElement clearButton, WebElement gridElement, String scenarioType) 
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    String beforeText = "";
	    String afterText = "";

	    int beforeCount = -1;
	    int afterCount = -1;

	    try {
	        // Scroll to Clear button before clicking
	        js.executeScript("arguments[0].scrollIntoView(true);", clearButton);
	        Thread.sleep(2000);

	        // ---------- COUNT_CHANGE ----------
	        if ("COUNT_CHANGE".equalsIgnoreCase(scenarioType)) {

	            // Scroll to grid BEFORE reading
	            js.executeScript("arguments[0].scrollIntoView(true);", gridElement);
	            Thread.sleep(2000);

	            beforeText = gridElement.getText();

	            // Extract ONLY main number (last number)
	            beforeCount = extractLastNumber(beforeText);

	            // Click Clear
	            clearButton.click();
	            Thread.sleep(5000);

	            // Scroll to grid AFTER clear
	            js.executeScript("arguments[0].scrollIntoView(true);", gridElement);
	            Thread.sleep(2000);

	            afterText = gridElement.getText();
	            afterCount = extractLastNumber(afterText);

	            if (beforeCount != afterCount) {
	                test.log(LogStatus.PASS, "Clear button are working fine");
	                test.log(LogStatus.PASS,"Before clicking (Clear Count) : " + beforeCount + " | After clicking (Clear Count) : " + afterCount);
	            } else {
	                test.log(LogStatus.FAIL, "Clear button are not working properly");
	                test.log(LogStatus.FAIL, "Before clicking (Clear Count) : " + beforeCount + " | After clicking (Clear Count) : " + afterCount);
	            }
	        }

	        // ---------- GRID_REMOVED ----------
	        else if ("GRID_REMOVED".equalsIgnoreCase(scenarioType)) {

	            // Click Clear (NO grid scroll after this)
	            clearButton.click();
	            Thread.sleep(2000);

	            boolean gridRemoved;

	            try {
	                gridRemoved = !gridElement.isDisplayed();
	            } catch (Exception e) {
	                gridRemoved = true; // removed from DOM / stale
	            }

	            if (gridRemoved) {
	                test.log(LogStatus.PASS, "Clear button are working fine");
	                test.log(LogStatus.PASS, "Grid is removed on clicking to clear");
	            } else {
	                test.log(LogStatus.FAIL, "Clear button are not working properly");
	                test.log(LogStatus.FAIL, "Grid is still visible after clicking clear");
	            }
	        }

	        else {
	            test.log(LogStatus.FAIL, "Invalid scenario type : " + scenarioType);
	        }
	        
	     // ---------- Scroll back to CLEAR (for next flow) ----------
	        js.executeScript("arguments[0].scrollIntoView(true);", clearButton);
	        Thread.sleep(2000);

	    } catch (Exception e) {
	        test.log(LogStatus.FAIL, "Exception while validating Clear button : " + e.getMessage());
	    }
	    
	}
	
	
	//-----------------------------Apply button validations-----------------------------
	public static void verifyApplyButton(WebDriver driver, ExtentTest test, WebElement applyButton,WebElement gridElement, String scenarioType) 
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    String beforeText = "";
	    String afterText = "";

	    int beforeCount = -1;
	    int afterCount = -1;

	    try {
	        // ---------- Scroll to GRID before reading ----------
	        js.executeScript("arguments[0].scrollIntoView(true);", gridElement);
	        Thread.sleep(2000);

	        if (gridElement.isDisplayed()) {
	            beforeText = gridElement.getText();
	            beforeCount = extractLastNumber(beforeText);
	        }

	        // ---------- Scroll to APPLY & click ----------
	        js.executeScript("arguments[0].scrollIntoView(true);", applyButton);
	        Thread.sleep(2000);

	        applyButton.click();
	        Thread.sleep(10000);

	        // ---------- Scroll to GRID after apply ----------
	        js.executeScript("arguments[0].scrollIntoView(true);", gridElement);
	        Thread.sleep(2000);

	        // ---------- APPLY_COUNT_CHANGE ----------
	        if ("APPLY_COUNT_CHANGE".equalsIgnoreCase(scenarioType)) {

	            afterText = gridElement.getText();
	            afterCount = extractLastNumber(afterText);

	            if (beforeCount != afterCount) {
	                test.log(LogStatus.PASS, "Apply button are working fine");
	                test.log(LogStatus.PASS, "Before clicking (Apply Count) : " + beforeCount + " | After clicking (Apply Count) : " + afterCount);
	            } else {
	                test.log(LogStatus.FAIL, "Apply button are not working properly");
	                test.log(LogStatus.FAIL, "Before clicking (Apply Count) : " + beforeCount + " | After clicking (Apply Count) : " + afterCount);
	            }
	        }

	        // ---------- APPLY_GRID_APPEARS ----------
	        else if ("APPLY_GRID_APPEARS".equalsIgnoreCase(scenarioType)) {

	            boolean gridVisible;
	            try {
	                gridVisible = gridElement.isDisplayed();
	            } catch (Exception e) {
	                gridVisible = false;
	            }

	            if (gridVisible) {
	                afterText = gridElement.getText();
	                afterCount = extractLastNumber(afterText);

	                test.log(LogStatus.PASS, "Apply button are working fine");
	                test.log(LogStatus.PASS, "Before clicking (Apply Count) : " + beforeCount + " | After clicking (Apply Count) : " + afterCount);
	            } else {
	                test.log(LogStatus.FAIL, "Apply button are not working properly");
	                test.log(LogStatus.FAIL, "Grid is not visible after clicking Apply");
	            }
	        }

	        else {
	            test.log(LogStatus.FAIL, "Invalid scenario type : " + scenarioType);
	        }

	        // ---------- Scroll back to APPLY (for next flow) ----------
	        js.executeScript("arguments[0].scrollIntoView(true);", applyButton);
	        Thread.sleep(2000);

	    } catch (Exception e) {
	        test.log(LogStatus.FAIL, "Exception while validating Apply button : " + e.getMessage());
	    }
	}

	//Small Helper for Apply & Clear button....
	private static int extractLastNumber(String text) {
	    String digits = text.replaceAll("[^0-9 ]", "").trim();
	    String[] parts = digits.split("\\s+");
	    return Integer.parseInt(parts[parts.length - 1]);
	}




	
	
	
	


	
	
/**	
	//--------Safe click-----
	//safe click: 
	public static void safeClick(WebDriver driver, WebElement element) {
//        wait.until(ExpectedConditions.visibilityOf(element));
//		  wait.until(ExpectedConditions.elementToBeClickable(element));

	    try {
	        // 1) try Selenium normal click
	        element.click();
	        return;
	        } catch (Exception ignored) {}

	    try {
	        // 2) Actions move + click
	        new Actions(driver).moveToElement(element).pause(Duration.ofMillis(200)).click().build().perform();
	        return;
	    	} catch (Exception ignored) {}

	    try {
	        // 3) scrollIntoView then JS click
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", element);
	        js.executeScript("arguments[0].click();", element);
	        return;
	    	} catch (JavascriptException je) {
	        System.out.println("JS click failed: " + je.getMessage());
	    	} catch (Exception ignored) {}

	    try {
	        // 4) dispatch MouseEvent (works when arguments[0].click() throws)
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        String script =
	            "var el = arguments[0];" +
	            "var ev = document.createEvent('MouseEvents');" +
	            "ev.initMouseEvent('click', true, true, window, 1, 0, 0, 0, 0, false, false, false, false, 0, null);" +
	            "el.dispatchEvent(ev);";
	        js.executeScript(script, element);
	        return;
	    	} catch (Exception e) {
	        System.out.println("dispatchEvent fallback failed: " + e.getMessage());
	    	}

	    try {
	        // 5) If overlay/pointer-events blocking, remove overlay or enable pointer events then click
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript(
	            "arguments[0].style.pointerEvents = 'auto';" +
	            "arguments[0].style.display = 'block';", element);
	        js.executeScript("arguments[0].click();", element);
	    	} catch (Exception e) {
	        System.out.println("final fallback failed: " + e.getMessage());
	        throw new RuntimeException("All click attempts failed", e);
	    	}
	    
	}

	*/
	
	
	
	
	
    
    

}
