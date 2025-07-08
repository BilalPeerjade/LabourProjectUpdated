package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import login.BasePage;

public class commonMethods extends BasePage {
	
	public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            // Folder path
            String destDir = System.getProperty("user.dir") + "/test-output/screenshots/";
            File dir = new File(destDir);
            if (!dir.exists()) {
                dir.mkdirs(); // create if not exists
            }

            // Timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String dest = destDir + screenshotName + "_" + timestamp + ".png";

            // Screenshot capture
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            return dest;

        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
            return null;
        }
    }
	
	

}
