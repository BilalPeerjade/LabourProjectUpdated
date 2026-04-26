package distributor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import login.BasePage;

public class DashboardCounts extends BasePage{
	
	private static WebElement labour = null;
	
	public static WebElement upcomingMain()		
	{
		labour = getDriver().findElement(By.xpath("//div[@title='Upcoming']"));
//		labour = getDriver().findElement(By.xpath("//div[@title='Overdue']"));
		return labour;
	}
	
	public static WebElement upcomingRegisters()		
	{
		labour = getDriver().findElement(By.xpath("(//div[@class='summary-card-content-item-count'])[1]"));
		return labour;
	}
		public static WebElement upcomingReturns()		
	{
		labour = getDriver().findElement(By.xpath("(//div[@class='summary-card-content-item-count'])[4]"));
		return labour;
	}
	public static WebElement upcomingChallans()		
	{
		labour = getDriver().findElement(By.xpath("(//div[@class='summary-card-content-item-count'])[7]"));
		return labour;
	}
	
	
	public static WebElement overdueMain() 
	{
		labour = getDriver().findElement(By.xpath("//div[@title='Overdue']"));
		return labour;
	}
	
	public static WebElement overdueRegisters() {
		labour = getDriver().findElement(By.xpath("(//div[@class='summary-card-content-item-count'])[2]"));
		return labour;
	}
	public static WebElement overdueReturns() {
		labour = getDriver().findElement(By.xpath("(//div[@class='summary-card-content-item-count'])[5]"));
		return labour;
	}
	public static WebElement overdueChallans() {
		labour = getDriver().findElement(By.xpath("(//div[@class='summary-card-content-item-count'])[8]"));
		return labour;
	}
		
	
	public static WebElement pendingActionMain() 
	{
		labour = getDriver().findElement(By.xpath("//div[@title='Pending Action']"));
		return labour;
	}
	public static WebElement pendingReviewMain() 
	{
		labour = getDriver().findElement(By.xpath("//div[@title='Pending Review']"));
		return labour;
	}
	
	public static WebElement actionRegisters() {
		labour = getDriver().findElement(By.xpath("(//div[@class='summary-card-content-item-count'])[3]"));
		return labour;
	}
	public static WebElement actionReturns() {
		labour = getDriver().findElement(By.xpath("(//div[@class='summary-card-content-item-count'])[6]"));
		return labour;
	}
	public static WebElement actionChallans() {
		labour = getDriver().findElement(By.xpath("(//div[@class='summary-card-content-item-count'])[9]"));
		return labour;
	}
	
	
	//-----------test-------
	public static void upcomingCountValidation(
	        ExtentTest test,
	        WebElement upcomingMain,
	        WebElement upcomingRegisters,
	        WebElement upcomingReturns,
	        WebElement upcomingChallans,
	        String logText) {

	    try {
	        // -------- Fetch & parse values --------
	        int mainUpcoming    = Integer.parseInt(upcomingMain.getText().replaceAll("[^0-9]", ""));

	        int registersCount  = Integer.parseInt(upcomingRegisters.getText().replaceAll("[^0-9]", ""));

	        int returnsCount    = Integer.parseInt(upcomingReturns.getText().replaceAll("[^0-9]", ""));

	        int challansCount   = Integer.parseInt(upcomingChallans.getText().replaceAll("[^0-9]", ""));

	        int calculatedTotal = registersCount + returnsCount + challansCount;

	        // -------- Logs (Readable) --------
	        test.log(LogStatus.INFO, logText);
	        test.log(LogStatus.INFO,"Main Upcoming Count : " + mainUpcoming);
	        test.log(LogStatus.INFO, "Registers = " + registersCount + " | Returns = " + returnsCount + " | Challans = " + challansCount);
	        test.log(LogStatus.INFO, "Calculated Total (Registers + Returns + Challans) = " + calculatedTotal);

	        // -------- Validation --------
	        if (mainUpcoming == calculatedTotal) {
	            test.log(LogStatus.PASS, "✅ Upcoming count matched successfully");
	        } else {
	            test.log(LogStatus.FAIL, "❌ Upcoming count mismatch");
	            test.log(LogStatus.FAIL, "Expected (Main) : " + mainUpcoming + " | Actual (Calculated) : " + calculatedTotal);
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.FAIL, "❌ Exception while validating Upcoming count : " + e.getMessage());
	    }
	}
	
	
	
	
	
	public static WebElement riskSummaryNCHigh() {
		labour = getDriver().findElement(By.xpath("(//*[local-name()='svg']//*[name()='g' and contains (@clip-path,'url')]//*[name()='path' and contains (@fill,'#FA')])[1]"));
		return labour;
	}
	public static WebElement riskSummaryNCMedium() {
		labour = getDriver().findElement(By.xpath("(//*[local-name()='svg']//*[name()='g' and contains (@clip-path,'url')]//*[name()='path' and contains (@fill,'#FA')])[2]"));
		return labour;
	}
	public static WebElement riskSummaryNCLow() {
		labour = getDriver().findElement(By.xpath("(//*[local-name()='svg']//*[name()='g' and contains (@clip-path,'url')]//*[name()='path' and contains (@fill,'#FA')])[3]"));
		return labour;
	}
//	public static void performanceSummaryNonComplied(
//	        ExtentTest test,
//	        WebElement performanceSummaryMainNC,
//	        WebElement RiskSummaryHighNC,
//	        WebElement RiskSummaryMediumNC,
//	        WebElement RiskSummaryLowNC,
//	        String logText) {
//
//	    try {
//	        // -------- Fetch & parse values --------
////	        int performanceSummaryNonComplied    = Integer.parseInt(performanceSummaryMainNC.getText().replaceAll("[^0-9]", ""));
//	        int performanceSummaryNonComplied = Integer.parseInt(performanceSummaryMainNC.getAttribute("textContent").replaceAll("[^0-9]", ""));
//	        System.out.println("Count is " + performanceSummaryNonComplied);
//
////	        int RiskSummaryHigh  = Integer.parseInt(RiskSummaryHighNC.getText().replaceAll("[^0-9]", ""));
////	        int RiskSummaryHigh = Integer.parseInt(RiskSummaryHighNC.getAttribute("textContent").replaceAll("[^0-9]", ""));
////	        System.out.println("Count is " + RiskSummaryHigh);
//	        
//	        
//	        
//	 
//	        	JavascriptExecutor js = (JavascriptExecutor) driver;
//		        String value = (String) js.executeScript("return arguments[0].textContent;", RiskSummaryHighNC);
//
//		        int RiskSummaryHigh = Integer.parseInt(value.replaceAll("[^0-9]", ""));
//		        System.out.println("Count is " + RiskSummaryHigh);
//	        
//	        
//	        
//	        
//
//	        int RiskSummaryMedium    = Integer.parseInt(RiskSummaryMediumNC.getText().replaceAll("[^0-9]", ""));
//
//	        int RiskSummaryLow   = Integer.parseInt(RiskSummaryLowNC.getText().replaceAll("[^0-9]", ""));
//
//	        int calculatedTotal = RiskSummaryHigh + RiskSummaryMedium + RiskSummaryLow;
//
//	        // -------- Logs (Readable) --------
//	        test.log(LogStatus.INFO, logText);
//	        test.log(LogStatus.INFO,"Main Performance Summary Count : " + performanceSummaryNonComplied);
//	        test.log(LogStatus.INFO, "Risk Summary Non Complied :- High = " + RiskSummaryHigh + " | Medium = " + RiskSummaryMedium + " | Low = " + RiskSummaryLow);
//	        test.log(LogStatus.INFO, "Calculated Total Risk Summary Non Complied (High + Medium + Low) = " + calculatedTotal);
//
//	        // -------- Validation --------
//	        if (performanceSummaryNonComplied == calculatedTotal) {
//	            test.log(LogStatus.PASS, "✅ Performance Summary non complied count matched successfully");
//	        } else {
//	            test.log(LogStatus.FAIL, "❌ Performance Summary non complied count mismatch");
//	            test.log(LogStatus.FAIL, "Expected (Main) : " + performanceSummaryNonComplied + " | Actual (Calculated) : " + calculatedTotal);
//	        }
//
//	    } catch (Exception e) {
//	        test.log(LogStatus.FAIL, "❌ Exception while validating Performance Summary non complied count : " + e.getMessage());
//	    }
//	}
	
	
	
	
	
	
	
	public static WebElement psTotals() 
	{
		labour = getDriver().findElement(By.xpath("//b[text()='Totals']/.."));
		return labour;
	}
	public static WebElement psComplied() 
	{
		labour = getDriver().findElement(By.xpath("//span[text()='Complied']/.."));
		return labour;
	}
	public static WebElement psNonComplied() 
	{
		labour = getDriver().findElement(By.xpath("//span[text()='Not Complied']/.."));
		return labour;
	}
	public static void performanceSummaryTotalsCount(
	        ExtentTest test,
	        WebElement TotalMain,
	        WebElement compliedGreen,
	        WebElement nonCompliedRed,
	        String logText) {

	    try {
	        // -------- Fetch & parse values --------
	        int mainTotalCount    = Integer.parseInt(TotalMain.getText().replaceAll("[^0-9]", ""));

	        int CompliedCount  = Integer.parseInt(compliedGreen.getText().replaceAll("[^0-9]", ""));

	        int nonCompliedCount    = Integer.parseInt(nonCompliedRed.getText().replaceAll("[^0-9]", ""));

	        int calculatedTotal = CompliedCount + nonCompliedCount;

	        // -------- Logs (Readable) --------
	        test.log(LogStatus.INFO, logText);
	        test.log(LogStatus.INFO,"Main Totals Count : " + mainTotalCount);
	        test.log(LogStatus.INFO, "Complied = " + CompliedCount + " | Non Complied = " + nonCompliedCount + "");
	        test.log(LogStatus.INFO, "Calculated Total (Complied + Non Complied) = " + calculatedTotal);

	        // -------- Validation --------
	        if (mainTotalCount == calculatedTotal) {
	            test.log(LogStatus.PASS, "✅ Performance Summary Totals count matched successfully");
	        } else {
	            test.log(LogStatus.FAIL, "❌ Performance Summary Totals count mismatch");
	            test.log(LogStatus.FAIL, "Expected (Totals) : " + mainTotalCount + " | Actual (Calculated) : " + calculatedTotal);
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.FAIL, "❌ Exception while validating Performance Summary Totals count : " + e.getMessage());
	    }
	}
	
	
	public static void overdueCountValidation(
	        ExtentTest test,
	        WebElement overdueMain,
	        WebElement overdueRegisters,
	        WebElement overdueReturns,
	        WebElement overdueChallans,
	        String logText) {

	    try {
	        // -------- Fetch & parse values --------
	        int mainOverdue    = Integer.parseInt(overdueMain.getText().replaceAll("[^0-9]", ""));

	        int registersCount  = Integer.parseInt(overdueRegisters.getText().replaceAll("[^0-9]", ""));

	        int returnsCount    = Integer.parseInt(overdueReturns.getText().replaceAll("[^0-9]", ""));

	        int challansCount   = Integer.parseInt(overdueChallans.getText().replaceAll("[^0-9]", ""));

	        int calculatedTotal = registersCount + returnsCount + challansCount;

	        // -------- Logs (Readable) --------
	        test.log(LogStatus.INFO, logText);
	        test.log(LogStatus.INFO,"Main Overdue Count : " + mainOverdue);
	        test.log(LogStatus.INFO, "Registers = " + registersCount + " | Returns = " + returnsCount + " | Challans = " + challansCount);
	        test.log(LogStatus.INFO, "Calculated Total (Registers + Returns + Challans) = " + calculatedTotal);

	        // -------- Validation --------
	        if (mainOverdue == calculatedTotal) {
	            test.log(LogStatus.PASS, "✅ Overdue count matched successfully");
	        } else {
	            test.log(LogStatus.FAIL, "❌ Overdue count mismatch");
	            test.log(LogStatus.FAIL, "Expected (Main) : " + mainOverdue + " | Actual (Calculated) : " + calculatedTotal);
	        }

	    } catch (Exception e) {
	        test.log(LogStatus.FAIL, "❌ Exception while validating Overdue count : " + e.getMessage());
	    }
	}
	
	
	public static void pendingActionAndReviewCount(
	        ExtentTest test,
	        WebElement pendingActionMain,
	        WebElement pendingReviewMain,
	        WebElement actionRegisters,
	        WebElement actionReturns,
	        WebElement actionChallans,
	        String logText) {
		
		try {
			// -------- Fetch & parse values --------
			int mainPendingAction = Integer.parseInt(pendingActionMain.getText().replaceAll("[^0-9]", ""));
			int mainPendingReview = Integer.parseInt(pendingReviewMain.getText().replaceAll("[^0-9]", ""));

			int actionRegistersCount = Integer.parseInt(actionRegisters.getText().replaceAll("[^0-9]", ""));
			int actionReturnsCount = Integer.parseInt(actionReturns.getText().replaceAll("[^0-9]", ""));
			int actionChallanCount = Integer.parseInt(actionChallans.getText().replaceAll("[^0-9]", ""));

			int pendingActionPendingReviewCounts = mainPendingAction + mainPendingReview;
			int calculatedTotal = actionRegistersCount + actionReturnsCount + actionChallanCount;
			test.log(LogStatus.INFO, logText);
			test.log(LogStatus.INFO, "The Pending Action : " + mainPendingAction + " & Pending Review : "+ mainPendingReview + " == " + pendingActionPendingReviewCounts);

			test.log(LogStatus.INFO, "Registers action = " + actionRegistersCount + " | Returns action = "+ actionReturnsCount + " | Challans action = " + actionChallanCount);
			test.log(LogStatus.INFO, "Calculated Total (Registers + Returns + Challans) = " + calculatedTotal);

			// -------- Validation --------
			if (pendingActionPendingReviewCounts == calculatedTotal) {
				test.log(LogStatus.PASS, "✅ Pending Action & Pending Review count matched successfully");
			} else {
				test.log(LogStatus.FAIL, "❌ Pending Action & Pending Review count mismatch");
				test.log(LogStatus.FAIL, "Expected (Main) : " + pendingActionPendingReviewCounts + " | Actual (Calculated) : " + calculatedTotal);
			}

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "❌ Exception while validating Upcoming count : " + e.getMessage());
		}
		
		
	}
	
	
	public static WebElement asDisplayed() 
	{
		labour = getDriver().findElement(By.xpath("//span[text()='Displayed']/.."));
		return labour;
	}
	public static WebElement asNotDisplayed() 
	{
		labour = getDriver().findElement(By.xpath("//span[text()='Not Displayed']/.."));
		return labour;
	}
	public static void abstractSummaryDisplayed(ExtentTest test, WebElement upcomingMain, String logText) {

		try {
			// -------- Fetch & parse values --------
			int mainUpcoming = Integer.parseInt(upcomingMain.getText().replaceAll("[^0-9]", ""));

			int calculatedTotal = mainUpcoming;

			test.log(LogStatus.PASS, logText);
			// -------- Validation --------
			if (calculatedTotal <= 100) {
				test.log(LogStatus.PASS, "Abstract Summary Displayed count is displayed less than 100 = " + calculatedTotal);
			} else {
				test.log(LogStatus.FAIL, "Abstract Summary Displayed count is displayed more than 100 = " + calculatedTotal);
			}

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "❌ Exception while validating Displayed count : " + e.getMessage());
		}
	}
	
	public static void abstractSummaryNotDisplayed(ExtentTest test, WebElement upcomingMain, String logText) {

		try {
			// -------- Fetch & parse values --------
			int mainUpcoming = Integer.parseInt(upcomingMain.getText().replaceAll("[^0-9]", ""));

			int calculatedTotal = mainUpcoming;

			test.log(LogStatus.PASS, logText);
			// -------- Validation --------
			if (calculatedTotal <= 100) {
				test.log(LogStatus.PASS, "Abstract Summary Not Displayed count is displayed less than 100 = " + calculatedTotal);
			} else {
				test.log(LogStatus.FAIL, "Abstract Summary Not Displayed count is displayed more than 100 = " + calculatedTotal);
			}

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "❌ Exception while validating Not Displayed count : " + e.getMessage());
		}
	}
	
	


}
