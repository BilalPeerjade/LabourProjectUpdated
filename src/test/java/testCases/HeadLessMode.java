package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import clientPortal.All_ClientPortal_Methods;
import login.BasePage;

public class HeadLessMode extends BasePage {

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    ExtentReports extent;
    ExtentTest test;

    String link = "mgmt1"; // ya jo aapka link value hai

    @BeforeTest
    void setBrowser() throws InterruptedException, IOException {
        extent = new ExtentReports("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\Report\\ClientPortal.html", true);

        System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe"); // <-- update your chromedriver path

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--window-size=1920,1080");

        driver.set(new ChromeDriver(options));

        test = extent.startTest("Logging In - Client Portal");
        test.log(LogStatus.PASS, "Logging into system");
        test.log(LogStatus.PASS, "Selected Entity: Test Automation 2[TESTAUTO2] AND Selected Year: 2024");

        extent.endTest(test);
        extent.flush();
    }

    @BeforeMethod
    void Login() throws InterruptedException, IOException {
        initialization(link, 6, "Statutory");
    }

    @Test(priority = 2)
    void EntitiesSearch() throws InterruptedException, IOException {
        test = extent.startTest("Validate Entity search field working or not?");
        All_ClientPortal_Methods.filterEntityAUTO2(test);
        All_ClientPortal_Methods.EntitiesSearch(test);

        extent.endTest(test);
        extent.flush();
    }

    @AfterMethod
    void browserClosing() throws InterruptedException {
        closeBrowser();
    }

    @AfterTest
    void Closing() throws InterruptedException {
        if (driver.get() != null) {
            driver.get().quit();
        }
        if (extent != null) {
            extent.flush();
            extent.close();
        }
    }
}
