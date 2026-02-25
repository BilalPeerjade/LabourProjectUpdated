package distributor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import login.BasePage;

public class DashboardCounts extends BasePage{
	
	private static WebElement labour = null;
	
	public static WebElement upcomingMain()		
	{
//		labour = getDriver().findElement(By.xpath("//div[@title='Upcoming']"));
		labour = getDriver().findElement(By.xpath("//div[@title='Overdue']"));
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
	
	
//	public static void upcommingCount
//	       (ExtentTest test, 
//            WebElement upcomming, 
//			WebElement upcomingRegisters,
//			WebElement upcomingReturns,
//			WebElement upcomingChallans,
//			String logText) {
//		
//		
//		String upcommingElement = upcomming.getText();
//		int upcomingValue = Integer.parseInt(upcommingElement.replaceAll("[^0-9]", ""));
//		System.out.println("Upcoming value = " + upcomingValue);
//		
//		
//		String upcomingRegistersElement = upcomingRegisters.getText();
//		int upcomingRegistersValue = Integer.parseInt(upcomingRegistersElement.replaceAll("[^0-9]", ""));
//		System.out.println("Upcoming value = " + upcomingRegistersValue);
//		
//		String upcomingReturnsElement = upcomingRegisters.getText();
//		int upcomingReturnsValue = Integer.parseInt(upcomingReturnsElement.replaceAll("[^0-9]", ""));
//		System.out.println("Upcoming value = " + upcomingReturnsValue);
//		
//		String upcomingChallansElement = upcomingRegisters.getText();
//		int upcomingChallansValue = Integer.parseInt(upcomingChallansElement.replaceAll("[^0-9]", ""));
//		System.out.println("Upcoming value = " + upcomingChallansValue);
//		
//		int categrozedBox = upcomingRegistersValue + upcomingReturnsValue + upcomingChallansValue ;
//		int mainUpcoming = upcomingValue;
//		
//		if(mainUpcoming == categrozedBox) {
//			  test.log(LogStatus.PASS , (logText + "Count Matched Successfully ! " ));
//test.log(LogStatus.PASS , ("Calculated : " + "Upcoming = " + upcomming + " Upcoming Registers " + upcomingRegisters + " UpcomingReturns " + upcomingReturns + " UpcomingChallans " + upcomingChallans));
//			  
//		}
//		
//	}
	
	
	
	
	
	
    //Calling sample:
    //https://screenrec.com/share/cA3xQ4wOY9
//    DashboardCounts.upcomingCountValidation(test,
//            DashboardCounts.upcomingMain(),
//            DashboardCounts.upcomingRegisters(),
//            DashboardCounts.upcomingReturns(),
//            DashboardCounts.upcomingChallans(),
//           "Dashboard → Upcoming count validation 2024 year");
	
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


}
