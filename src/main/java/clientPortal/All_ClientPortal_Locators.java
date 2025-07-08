package clientPortal;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class All_ClientPortal_Locators extends BasePage {

	private static WebElement labour = null;			//WebElement variable created for Username input
	
	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	private static WebElement clients = null;				//WebElement variable created for 'Categories' click
	
	public static WebElement SelectEntity( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[@class='k-input-inner k-readonly']"));
		return clients;
	}
	
	public static WebElement EntityTri( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])"));
		return clients;
	}
	
	public static WebElement EntityTri1( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[2]"));
		return clients;
	}
	
	public static WebElement EntityTri2( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[5]"));
		return clients;
	}
	
	
	public static WebElement AVAENTEST( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//input[@value='AVACORED5']"));
		return clients;
	}
	
	public static WebElement EntityTESTAUTO2( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//input[@value='TESTAUTO2']"));
		return clients;
	}
	
	public static WebElement Gopi( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//*[@id='0']/span/div/input"));
		return clients;
	}
	
	public static WebElement AVAAEntity( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//input[@value='AVAAEntity']"));
		return clients;
	}
	
	public static WebElement SelectYear( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//*[@class='k-input-value-text']"));
		return clients;
	}
	
	public static WebElement SelectYear22( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='2024']"));
		return clients;
	}
	
	public static WebElement SelectYear25( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='2025']"));
		return clients;
	}
	
	public static WebElement Apply( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ApplyFilter.svg']"));
		return clients;
	}
	
	public static WebElement Entities( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//div[@class='min-card-count']"));
		return clients;
	}
	
	public static WebElement readTotalItemsAllClient( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.cssSelector(".k-pager-info.k-label.ng-star-inserted"));
		return clients;
	}
	
	public static WebElement readTotalItems1( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//kendo-pager-info[@class='k-pager-info k-label']"));
		return clients;
	}
	
	public static WebElement Search( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//input[@placeholder='Type to Search']"));
		return clients;
	}
	
	public static WebElement compliancePerformanceSearch( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//input[@placeholder='Type to Search']"));
		return clients;
	}
	
	public static WebElement complianceDropdwonClick( )		//This Locator is for Assignened Compliances for clicking dropdown
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='Compliance']"));
		return clients;
	}
	public static WebElement complianceSelectOnRegisters( )		//
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='Register']"));
		return clients;
	}
	public static WebElement complianceSelectOnReturn( )		
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='Return']"));
		return clients;
	}
	public static WebElement complianceSelectOnChallan( )		
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='Challan']"));
		return clients;
	}
	
	public static WebElement RSGSearch( )//Method for closing Message Popup - RSG means Registration Graph Graph
	{
		clients = getDriver().findElement(By.xpath("//input[@placeholder='Type to Search']"));
		return clients;
	}
	
	public static WebElement Locations( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("(//div[@class='min-card-count'])[2]"));
		return clients;
	}
	
	public static WebElement AssignedCompliances( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("(//div[@class='min-card-count'])[3]"));
		return clients;
	}
	
	public static WebElement Export( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("(//img[@src='../assets/vectors/ExportButton.svg'])[1]"));
		return clients;
	}
	
	public static WebElement Overview( )		//Method for closing Message Popup
	{            //Me P7
		clients = getDriver().findElement(By.xpath("(//img[contains(@title,'Overview')])[1]"));
		return clients;
	}
	
	public static WebElement OverviewClose( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//*[@class='k-svg-i-x k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return clients;
	}
	
	public static WebElement CLDashboard( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='My Dashboard']"));
		return clients;
	}
	
	
	public static WebElement ExpiredRegistrations( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//div[@class='min-card-count-red']"));
		return clients;
	}
	
	public static WebElement OpenNotices( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("(//div[@class='min-card-count-red'])[2]"));
		return clients;
	}
	
	public static WebElement ViewAllClient( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='View'])[1]"));
		return clients;
	}
	
	public static WebElement Viewpage( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("(//span[@title='View Notices'])[1]"));
		return clients;
	}
	
	public static WebElement ViewAddNew( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("(//button[normalize-space()='Add New'])[1]"));
		return clients;
	}
	
	public static WebElement StateAllClient( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[@class='k-input-value-text'][normalize-space()='Select State']"));
		return clients;
	}
	
	public static WebElement State1( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='Maharashtra']"));
		return clients;
	}
	
	public static WebElement LocationAllClient( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[contains(text(),'Select Loaction')]"));
		return clients;
	}
	
	public static WebElement Location1( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']//li[2]"));
		return clients;
	}
	
	public static WebElement BranchAllClient( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("(//span[contains(text(),'Select Branch')])[1]"));
		return clients;
	}
	
	public static WebElement Branch1( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']//li[2]"));
		return clients;
	}
	
	public static WebElement ModeofReceipt( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[contains(text(),'Select Receipt Mode')]"));
		return clients;
	}
	
	public static WebElement ModeofReceipt1( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='Email']"));
		return clients;
	}
	
	public static WebElement NoticeNumber( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("(//input[@placeholder='Notice Number'])[1]"));
		return clients;
	}
	
	public static WebElement NoticeReceivedDate( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//div[@class='require-container ms-5']//*[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return clients;
	}
	
	public static WebElement NoticeReceivedDateT( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//input[@placeholder='DD-MM-YYYY']"));
		return clients;
	}
	
	public static WebElement NoticeReceivedDate1( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='2']"));
		return clients;
	}
	
	public static WebElement NoticeReceivedDate2( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("td[id='1f128d53-44b0-46c2-9fa5-10ced0b68da81733077800000'] span[class='k-link']"));
		return clients;
	}
	
	public static WebElement NoticedueDate1( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='4']"));
		return clients;
	}
	
	public static WebElement ResponseDueDate( )		{
		clients = getDriver().findElement(By.xpath("//div[@class='require-container']//*[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return clients;
	}
	
	public static WebElement NoticeType( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[contains(text(),'Select Notice Type')]"));
		return clients;
	}
	
	public static WebElement NoticeType1( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='PF - Delayed Remittance']"));
		return clients;
	}
	
	public static WebElement Risk( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[contains(text(),'Select Risk')]"));
		return clients;
	}
	
	public static WebElement Risk1( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='Critical']"));
		return clients;
	}
	
	public static WebElement Browse( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//button[@class='figma-btn-gray']"));
		return clients;
	}
	
	public static WebElement remark( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//textarea[@placeholder='Remarks']"));
		return clients;
	}
	
	public static WebElement SaveNotice( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//button[normalize-space()='Save Notice']"));
		return clients;
	}
	
/*	public static WebElement Clear( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ClearFilter.svg']"));
		return clients;
	}*/
	
	public static WebElement Clear() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//img[@src='../assets/vectors/ClearFilter.svg']"),
	        By.xpath("//button[@title='Clear']"),
	        By.xpath("//button[@class='figma-btn-white clear-btn']"),
	        By.cssSelector("")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("❌ Element not found using any locator.");
	    return null; // All locators failed
	}
	
	
	
	public static WebElement Edit( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='Edit'])[1]"));
		return clients;
	}
	
	public static WebElement Edit1( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[contains(@title,'Edit')])[1]"));
		return clients;
	}
	
	
	public static WebElement EditBack( )		
	{
		clients = getDriver().findElement(By.xpath("//button[@class='figma-btn-blue']"));
		return clients;
	}
	
	public static WebElement OverviewNo( )		
	{   
		clients = getDriver().findElement(By.xpath("(//img[@title='View'])[1]"));
		return clients;
	}
	public static WebElement compliancePerformanceOverView( )	//Me	
	{   
		clients = getDriver().findElement(By.xpath("(//img[@title='Overview'])[1]"));
		return clients;
	}
	public static WebElement compliancePerformanceViewNo( )		//Me
	{   
		clients = getDriver().findElement(By.xpath("(//img[@title='View'])[1]"));
		return clients;
	}
	
	public static WebElement OverviewOpenNotice( )		
	{   //P25 P46 P48
		clients = getDriver().findElement(By.xpath("(//img[@title='Overview'])[1]"));
		return clients;
	}
	
	public static WebElement OpenNoticePage( )		
	{
		clients = getDriver().findElement(By.xpath("//span[@title='Open Notices']"));
		return clients;
	}
	
	public static WebElement Active( )		
	{
		clients = getDriver().findElement(By.xpath("(//*[name()='g'])[20]"));
		return clients;
	}
	
	public static WebElement Expired( )		
	{
		clients = getDriver().findElement(By.xpath("(//*[name()='g'])[19]"));
		return clients;
	}
	
	public static WebElement ActiveCol( )		
	{
		clients = getDriver().findElement(By.xpath("(//div[@class='cell-content total-click'])"));
		return clients;
	}
	
	public static WebElement ExpiredCol( )		
	{
		clients = getDriver().findElement(By.xpath("(//div[@class='cell-content total-click'])[2]"));
		return clients;
	}
	
	public static WebElement Overdue( )		
	{
		clients = getDriver().findElement(By.xpath("(//*[name()='g'])[9]")); //(//*[name()='g'])[9]
		return clients;
	}
	
	public static WebElement Complied( )		
	{
		clients = getDriver().findElement(By.xpath("(//*[name()='g'])[8]"));
		return clients;
	}
	
	public static WebElement OverdueGrid( )		
	{
		clients = getDriver().findElement(By.xpath("(//div[@class='col-12 collpadding0'])[48]"));
		return clients;
	}
	
	
	public static WebElement PayrollCompliancesOverdue( )		
	{
		clients = getDriver().findElement(By.cssSelector("tbody tr:nth-child(6) td:nth-child(3) div:nth-child(1)"));
		return clients;
	}
	
	public static WebElement PayrollCompliancesComplied( )		
	{
		clients = getDriver().findElement(By.cssSelector("tbody tr:nth-child(6) td:nth-child(2) div:nth-child(1)"));
		return clients;
	}
	
	public static WebElement readTotalItemsD( )		
	{
		clients = getDriver().findElement(By.xpath("//kendo-pager-info[@class='k-pager-info k-label']")); //body > app-root > div > app-layout > section > div > div > app-client-entity-dashboard-grid > div.col-12.colpadding0.ng-star-inserted > app-grid-action-item > kendo-grid > kendo-pager > kendo-pager-info
		return clients;
	}
	
	public static WebElement ECOverdue( )		
	{
		clients = getDriver().findElement(By.xpath("(//div[@class='col-12 collpadding0 total-click'])[4]"));//body > app-root > div > app-layout > section > div > div > app-client-entity-dashboard > div.col-12.colpadding0.ng-star-inserted > table > tbody > tr:nth-child(8) > td:nth-child(3)
		return clients;
	}
	
	public static WebElement ECComplied( )		//me changed xpath
	{
		clients = getDriver().findElement(By.xpath("(//div[@class='col-12 collpadding0 total-click'][normalize-space()='4'])[1]"));
		return clients;
	}
	
	//RCComplied means -- Payroll Compliance overdue -- Actually it should be PCCompied
	public static WebElement RCComplied() {
	    List<By> locators = Arrays.asList(
	        By.xpath("(//div[@class='col-12 collpadding0 total-click'])[1]"),
	        By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-client-entity-dashboard/div[2]/table/tbody/tr[5]/td[2]/div"),
	        By.cssSelector("tbody tr:nth-child(5) td:nth-child(2) div:nth-child(1)")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("❌ Element not found using any locator.");
	    return null; // All locators failed
	}
	//PCOverdue means - Payroll Compliance Overdue
	public static WebElement PCOverdue() {
	    List<By> locators = Arrays.asList(
	        By.xpath("(//div[@class='col-12 collpadding0 total-click'])[2]"),
	        By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-client-entity-dashboard/div[2]/table/tbody/tr[5]/td[3]/div"),
	        By.cssSelector("tbody tr:nth-child(5) td:nth-child(3) div:nth-child(1)")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("❌ Element not found using any locator.");
	    return null; // All locators failed
	}
	
	
	
	
	
	public static WebElement Loader( )		
	{
		clients = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-client-entity-dashboard-grid/div[3]/kendo-loader/div"));
		return clients;
	}
	
	public static WebElement FCOverdue( )		
	{
		clients = getDriver().findElement(By.cssSelector("tbody tr:nth-child(11) td:nth-child(3) div:nth-child(1)"));
		return clients;
	}
	
	public static WebElement FCCompied( )		
	{
		clients = getDriver().findElement(By.cssSelector("tbody tr:nth-child(14) td:nth-child(2) div:nth-child(1)"));
		return clients;
	}
	
	public static WebElement ClraOverdue( )		
	{
		clients = getDriver().findElement(By.cssSelector("tbody tr:nth-child(18) td:nth-child(3) div:nth-child(1)"));
		return clients;
	}
	
	public static WebElement ClraComplied( )		
	{
		clients = getDriver().findElement(By.cssSelector("tbody tr:nth-child(18) td:nth-child(2) div:nth-child(1)"));
		return clients;
	}
	
	public static WebElement Open( )		
	{
		clients = getDriver().findElement(By.xpath("(//*[name()='g'])[30]"));
		return clients;
	}
	
	public static WebElement OpenCol( )		
	{
		clients = getDriver().findElement(By.cssSelector("tbody tr[role='row'] td:nth-child(3) div:nth-child(1)"));
		return clients;
	}
	
	public static WebElement Closed( )		
	{
		clients = getDriver().findElement(By.xpath("(//*[name()='g'])[31]"));
		return clients;
	}
	
	public static WebElement ClosedCol( )		
	{
		clients = getDriver().findElement(By.cssSelector("tbody tr[role='row'] td:nth-child(4) div:nth-child(1)"));
		return clients;
	}
	
	public static WebElement allNoticesColumCount() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//td[5]"),
	        By.cssSelector(".k-table-td.k-touch-action-auto.ng-star-inserted[data-kendo-grid-column-index='4']"),
	        By.xpath("//*[@id=\"k-32a65902-4259-4f10-9bfd-5d120dcb0e71\"]/kendo-grid-list/div/div[1]/table/tbody/tr/td[5]")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("❌ Element not found using any locator.");
	    return null; // All locators failed
	}
	
	
	
	public static WebElement DownloadBtn( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='Download'])[2]"));
		return clients;
	}
	public static WebElement compliancePerformanceDownloadBtn( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='Download'])"));
		return clients;
	}
	public static WebElement compliancePerformanceFileDownPopup( )		
	{
		clients = getDriver().findElement(By.xpath("//img[@alt='Download Document']"));
		return clients;
	}
	
	
	public static WebElement History( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='History'])[1]"));
		return clients;
	}
	
	public static WebElement RegistrationLicencesHistory( )		
	{
		clients = getDriver().findElement(By.xpath("(//span[@title='Registration & Licences History'])[1]"));
		return clients;
	}
	
	public static WebElement Registration( )		
	{
		clients = getDriver().findElement(By.xpath("(//*[name()='g'])[61]"));
		return clients;
	}
	public static WebElement ExpRegistration( )		
	{
		clients = getDriver().findElement(By.xpath("(//*[name()='g'])[62]"));
		return clients;
	}
	public static WebElement RSG_EditBtn( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='Edit'])"));
		return clients;
	}
	
	public static WebElement ClickTriangle( )		
	{
		clients = getDriver().findElement(By.xpath("(//span[@class='e-btn-icon e-icon-down-arrow e-icons e-icon-right'])[1]"));
		return clients;
	}
	
	
	public static WebElement nextmonth( )		
	{
		clients = getDriver().findElement(By.xpath("(//button[@aria-label='next month'])[1]"));
		return clients;
	}
	
	
	public static WebElement nextmonth2025( )		
	{
		clients = getDriver().findElement(By.xpath("//span[@title='Feb 2025']"));
		return clients;
	}
	public static WebElement nextmonth2024( )		
	{
		clients = getDriver().findElement(By.xpath("//span[@title='Feb 2024']"));
		return clients;
	}
	
	public static WebElement number( )		
	{
		clients = getDriver().findElement(By.xpath("//div[@class='month-number number-overdue'][normalize-space()='18']"));
		return clients;
	}
	public static WebElement number2( )		
	{
		clients = getDriver().findElement(By.xpath("//div[contains(@class,'selected-number')][normalize-space()='1']"));
		return clients;
	}
	
	public static WebElement OverviewCalen( )		
	{
		clients = getDriver().findElement(By.xpath("//img[@title='Overview']"));
		return clients;
	}
	
	public static WebElement OverviewColse( )		
	{
		clients = getDriver().findElement(By.xpath("//*[@class='k-svg-i-x k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return clients;
	}
	
	public static WebElement Back( )		
	{
		clients = getDriver().findElement(By.xpath("//button[@class='figma-btn-blue']"));
		return clients;
	}
	
	public static WebElement Download1test( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='Download'])[1]"));
		return clients;
	}
	
	public static WebElement InitiateAction( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='Initiate Action'])[1]"));
		return clients;
	}
	
/*	public static WebElement clickActivityType( )		
	{
		clients = getDriver().findElement(By.xpath("(//span[contains(text(),'Select Activity Type')])[1]"));
		return clients;
	}*/ 
	//Now it is easy to use in any Initiate Action button
	public static WebElement clickActivityType() {
	    List<By> locators = Arrays.asList(
	        By.xpath("(//span[contains(text(),'Select Activity Type')])[1]"),
	        By.xpath("//span[contains(text(),'Select Activity Type')]"),
	        By.xpath("(//button[@class='k-input-button k-button k-icon-button k-button-md k-button-solid k-button-solid-base'])[4]"),
	        By.xpath("//span[contains(text(),'Approval')]"),
	        By.xpath("//span[contains(text(),'Renewal')]"),
	        By.xpath("//span[normalize-space()='Amendment']"),
	        By.xpath("//span[normalize-space()='Surrender']"),
	        By.xpath("//span[contains(text(),'Renewal and Surrender')]"),
	        By.xpath("//span[contains(text(),'Return')]")
	        );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("❌ Element not found using any locator.");
	    return null; // All locators failed
	}
	
	
	
	
	public static WebElement selectActivityTypeApproval( )		
	{
		clients = getDriver().findElement(By.xpath("(//span[contains(text(),'Approval')])[1]"));
		return clients;
	}
	
	public static WebElement Sumit( )		
	{
		clients = getDriver().findElement(By.xpath("(//button[normalize-space()='Submit'])[1]"));
		return clients;
	}
	
/*	public static WebElement read( )		
	{
		clients = getDriver().findElement(By.xpath("//div[@class='updates']//div[1]//a[1]"));
		return clients;
	}
*/	
	public static WebElement InputUpload( )		
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='Input Upload']"));
		return clients;
	}
	
	public static WebElement Template( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='Sample Template'])[1]"));
		return clients;
	}
	
	public static WebElement Template1( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='Sample Template'])[2]"));
		return clients;
	}
	
	public static WebElement BrowseIn( )		
	{
		clients = getDriver().findElement(By.xpath("(//button[@class='figma-btn-gray'][normalize-space()='Browse'])[1]"));
		return clients;
	}
	public static WebElement BrowseInOtherUpload1( )		
	{
		clients = getDriver().findElement(By.xpath("(//button[@class='figma-btn-gray'][normalize-space()='Browse'])[2]"));
		return clients;
	}
	
	public static WebElement BrowseIn1( )		
	{
		clients = getDriver().findElement(By.xpath("(//button[@class='figma-btn-gray'][normalize-space()='Browse'])[3]"));
		return clients;
	}
	
	public static WebElement HistoryIU( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='History'])[1]"));
		return clients;
	}
	
	public static WebElement InputHistoryD( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='Download'])[1]"));
		return clients;
	}
	
	public static WebElement HistoryIU1( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='History'])[2]"));
		return clients;
	}
	
	public static WebElement Challan( )		
	{
		clients = getDriver().findElement(By.xpath("//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon']"));
		return clients;
	}
	
	public static WebElement Challan1( )		
	{
		clients = getDriver().findElement(By.xpath("//span[contains(text(),'Challan')]"));
		return clients;
	}
	
	public static WebElement Return( )		
	{
		clients = getDriver().findElement(By.xpath("//span[contains(text(),'Return')]"));
		return clients;
	}
	
	public static WebElement clickMyDocuments( )		
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='My Documents']"));
		return clients;
	}
	
	public static WebElement clickCriticalDocuments( )		
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='Critical Documents']"));
		return clients;
	}
	
	public static WebElement readFolderName( )		
	{
		clients = getDriver().findElement(By.xpath("//*[@class='cell-content ng-star-inserted']"));
		return clients;
	}
	
	public static WebElement clickNewFolder( )		
	{
		clients = getDriver().findElement(By.xpath("//button[@id='menu1']"));
		return clients;
	}
	
	public static WebElement writeFolderName( )		
	{
		clients = getDriver().findElement(By.xpath("//input[@placeholder='Enter Folder Name']"));
		return clients;
	}
	
	public static WebElement clickCreate( )		
	{
		clients = getDriver().findElement(By.xpath("//button[normalize-space()='Create']"));
		return clients;
	}
	
	public static WebElement EREdit( )		
	{
		clients = getDriver().findElement(By.xpath("//img[@title='Edit ']"));
		return clients;
	}
	
	public static WebElement RegistrationStatusEditbtn( ) //Me added this locator		
	{
		clients = getDriver().findElement(By.xpath("//img[@title='Edit']"));
		return clients;
	}
	
	
	
	public static WebElement EREditP( )		
	{
		clients = getDriver().findElement(By.xpath("//span[@title='Existing License']"));
		return clients;
	}
	
	public static WebElement ViewER( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='View'])[1]"));
		return clients;
	}
	
	public static WebElement expandIconSubActivity( )		
	{
		clients = getDriver().findElement(By.xpath("(//*[@viewBox='0 0 512 512'])[13]"));
		return clients;
	}
	public static WebElement ViewSubActivity( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='View'])[2]"));
		return clients;
	}
	
	
	public static WebElement compliancePerformanceGraph() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//*[@id='chart-container-compliance-performance_Series_0_Point_0']"),
	        By.xpath("//*[@y='35.75']"),
	        By.xpath("//*[name()='path' and @id='chart-container-compliance-performance_Series_0_Point_0']"),
	        By.cssSelector("#chart-container-compliance-performance_Series_0_Point_0")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("❌ Element not found using any locator.");
	    return null; // All locators failed
	}
	
	//EST means Establishment 
	public static WebElement ESTCompliance() {
	    List<By> locators = Arrays.asList(
	        By.xpath("(//div[@class='col-12 collpadding0 total-click'])[2]"),
	        By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-client-entity-dashboard/div[2]/table/tbody/tr[9]/td[2]/div"),
	        By.xpath(""),
	        By.cssSelector("tbody tr:nth-child(9) td:nth-child(2) div:nth-child(1)")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("❌ Element not found using any locator.");
	    return null; // All locators failed
	}
	
	public static WebElement PayRollCompliance() {
	    List<By> locators = Arrays.asList(
	        By.cssSelector("tbody tr:nth-child(5) td:nth-child(2) div:nth-child(1)"),
	        By.xpath("(//div[@class='col-12 collpadding0 total-click'])[1]"),
	        By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-client-entity-dashboard/div[2]/table/tbody/tr[5]/td[2]/div"),
	        By.cssSelector("body > app-root > div > app-layout > section > div > div > app-client-entity-dashboard > div.col-12.colpadding0.ng-star-inserted > table > tbody > tr:nth-child(5) > td:nth-child(2) > div")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("❌ Element not found using any locator.");
	    return null; // All locators failed
	}
	
	
	
	
	
	
	
	
	
	
	
	

public static WebElement clickEntity()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("//span[@class='k-input-inner k-readonly']"));
	return labour;
}
public static WebElement clickTringle()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])"));
	return labour;
}
public static WebElement clickTringle1()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[2]"));
	return labour;
}
public static WebElement clickTringle3()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[4]"));
	return labour;
}
public static WebElement selectEnity()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("//*[@value='AVACORED5']"));
	//input[@value='AVACORED']
	return labour;
}
public static WebElement selectEnity1()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("//input[@value='AVAAEntity']"));
	return labour;
}
public static WebElement selectEnity2()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("//input[@value='AVACORP6']"));
	return labour;
}
public static WebElement clickYear()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("(//*[@role=\"combobox\"])[4]"));
	//*[@class='k-input-value-text']
	return labour;
}

public static WebElement selectYear()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("//span[normalize-space()='2025']"));
	return labour;
}
public static WebElement ClickApplyBtn()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ApplyFilter.svg']"));
	return labour;
}
public static WebElement clickLicense()		//Method for searching Username input
{
	labour = getDriver().findElement(By.xpath("//*[@type='button']"));
	return labour;
}


	public static WebElement clickRegistration()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Registration']"));
		return labour;
	}
	public static WebElement clickAddNew()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Add New']"));
		return labour;
	}
/*	public static WebElement clickState()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[3]"));
		return labour;
	}*/
	public static WebElement registrationclickState() {
	    List<By> locators = Arrays.asList(
	    	By.xpath("(//button[@class='k-input-button k-button k-icon-button k-button-md k-button-solid k-button-solid-base'])[2]"),
	        By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-new-registration-licenses-add-popup/div[2]/div[1]/div[2]/div/kendo-combobox/button/kendo-icon-wrapper/kendo-svgicon"),
	        By.cssSelector("body > app-root > div > app-layout > section > div > div > app-new-registration-licenses-add-popup > div.dialog-content > div:nth-child(1) > div:nth-child(2) > div > kendo-combobox > button > kendo-icon-wrapper > kendo-svgicon"),
	        
	        By.cssSelector("kendo-combobox[class='f-textbox k-input-md k-rounded-md k-input-solid k-combobox k-input'] button[aria-label='Select']")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("Click Select state element is not found");
	    return null; // All locators failed
	}
	public static WebElement noticeclickState() {
	    List<By> locators = Arrays.asList(
	    	By.xpath("//span[@class='k-input-value-text'][normalize-space()='Select State']"),
	        By.xpath("//span[normalize-space()='Select State']"),
	        By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[3]"),
	        
	        By.cssSelector("span[id='k-59e13578-4413-4b25-97f5-4f2c6f892b50'] span[class='k-input-value-text']")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("Click Select state element is not found");
	    return null; // All locators failed
	}
	
	
	
	
	
	public static WebElement clickStatee()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select State')]"));
		return labour;
	}
	
	public static WebElement selectState()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return labour;
	}
	public static WebElement selectState1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[3]"));
		return labour;
	}
	public static WebElement clickLocation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])"));
		return labour;
	}
	public static WebElement clickLocation1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[3]"));
		return labour;
	}
	public static WebElement selectLocation1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return labour;
	}
	public static WebElement clickBranch()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[2]"));
		return labour;
	}
	public static WebElement clickBranch1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text ng-star-inserted'])"));
		//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[5]
		return labour;
	}
	public static WebElement clickNoticeBranch1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select Branch')]"));
		//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[5]
		return labour;
	}
	public static WebElement clickModeOfReceipt()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[5]"));
		return labour;
	}
	public static WebElement clickLicenseType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select License Type')]"));
		return labour;
	}
	public static WebElement selectLicenseType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[2]"));
		return labour;
	}
	public static WebElement clickEmpName()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[3]"));
		return labour;
	}
	public static WebElement clickEmpAddress()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[4]"));
		return labour;
	}
	public static WebElement clickEmpMailId()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[5]"));
		return labour;
	}
	public static WebElement clickEmpContact()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[6]"));
		return labour;
	}
	public static WebElement clickMaleCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='number'])[1]"));
		return labour;
	}
	public static WebElement clickFemaleCount()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='number'])[2]"));
		return labour;
	}
	public static WebElement clickManagerMailId()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[7]"));
		return labour;
	}
	public static WebElement clickContactNo()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[8]"));
		return labour;
	}
	public static WebElement clickAddress()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='text'])[9]"));
		return labour;
	}
	public static WebElement clickSubmit()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Submit']"));
		return labour;
	}
	public static WebElement clickSuccessMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Registration saved successfully']"));
		return labour;
	}
	public static WebElement clickOkBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='OK']"));
		return labour;
	}
	public static WebElement clickMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[@class='f-label']"));
		return labour;
	}
	public static WebElement clickBack()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
		return labour;
	}
	public static WebElement clickBackArrow()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Back']"));
		return labour;
	}
	public static WebElement clickExport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Export']"));
		return labour;
	}
	public static WebElement clickExport_compliancedetails()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
		return labour;
	}
	public static WebElement clickExport2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Export']"));
		return labour;
	}
	public static WebElement clickExistingLicenseExport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='exportbtn']"));
		return labour;
	}
	public static WebElement readTotalItems()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//kendo-pager-info[@class='k-pager-info k-label ng-star-inserted' or @class='k-pager-info k-label']"));
		return labour;
	}
/*	public static WebElement readTotalItemsNotice()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-notice-client-portal/kendo-grid/kendo-pager/kendo-pager-info"));
		return labour;
	}
*/	
	public static WebElement readTotalItemsNotice() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//kendo-pager-info[@class='k-pager-info k-label ng-star-inserted' or @class='k-pager-info k-label']"),
	        By.xpath("//kendo-pager-info[@class='k-pager-info k-label ng-star-inserted']"),
	        By.xpath(""),
	        By.xpath("")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("❌ Element not found using any locator.");
	    return null; // All locators failed
	}

	
	
	
	public static WebElement readTotalItemsMasterAbstract()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//kendo-pager-info[@class='k-pager-info k-label']"));
		return labour;
	}
	public static WebElement SearchBox()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@placeholder='Type to Search']"));
		return labour;
	}
	public static WebElement ClearBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ClearFilter.svg']"));
		return labour;
	}
	public static WebElement EditBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Edit'])"));
		return labour;
	}
	public static WebElement ExistingLicesne()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Existing License']"));
		return labour;
	}
	public static WebElement ExistingLicesneViewIcon()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='View'])[1]"));
		return labour;
	}
	public static WebElement ExistingLicesneInitiateAction()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Initiate Action'])[1]"));
		return labour;
	}
	public static WebElement ExistingLicesneDownload()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Download'])[1]"));
		return labour;
	}
	public static WebElement ExistingLicesneDetailes()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-window-title k-dialog-title']"));
		return labour;
	}
	public static WebElement clickActivityTab()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[4]"));
		return labour;
	}
	public static WebElement selectActivityTab()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[@class='k-list-item-text ng-star-inserted'][normalize-space()='Return']"));
		return labour;
	}
	public static WebElement SccessMsgSubActivity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='SubActivity saved successfully']"));
		return labour;
	}
	public static WebElement clickTringleSubactivity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//tbody/tr[1]/td[1]/kendo-icon-wrapper[1]/*[1]"));
		return labour;
	}
	public static WebElement ExistingLicesneSubactivityViewIcon()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='View'])[2]"));
		return labour;
	}
	public static WebElement ExistingLicesneSubActivityDownload()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@alt='Download Icon'])[2]"));
		return labour;
	}
	public static WebElement GridLoad()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-existing-registration-license/div/div[3]/kendo-loader/div/span"));
		return labour;
	}
	public static WebElement downloadLicenseDoc()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@src='../assets/vectors/DownloadMedium.svg']"));
		return labour;
	}
	public static WebElement RegistrationRepository()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Registration Repository']"));
		return labour;
	}
	public static WebElement Branch()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-input-value-text']"));
		return labour;
	}
	public static WebElement NoticeBranch()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[5]"));
		return labour;
	}
	public static WebElement selectBranch()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Maharashtra')]"));
		//span[contains(text(),'Assam')]
		//*[@value='undefined']
		return labour;
	}
	public static WebElement clickActivities()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-input-value-text']"));
		return labour;
	}
	public static WebElement selectActivities()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[3]"));
		return labour;
	}
	public static WebElement clickDownload()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Download']"));
		return labour;
	}
	public static WebElement clickDownload1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@title='Download'])[2]"));
		return labour;
	}
	public static WebElement clickDocViewer()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-window-title k-dialog-title']"));
		return labour;
	}
	public static WebElement ClickClose()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Close']"));
		return labour;
	}
	public static WebElement clickAlert()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Invalid file type.']"));
		return labour;
	}
	public static WebElement clickNotices()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Notices']"));
		return labour;
	}
	public static WebElement clickaddnewNotices()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Add New']"));
		return labour;
	}
	public static WebElement clickNoticeNumber()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname='noticeNo']"));
		return labour;
	}
	public static WebElement clickCalender()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement clickCalenderNoticeReceiveDate()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@id=\"kendo-dialog-content-148938\"]/div/form/div[4]/div[1]/div/app-kendo-datepicker/kendo-datepicker/button/kendo-icon-wrapper/kendo-svgicon"));
		return labour;
	}
	public static WebElement clickCalenderReponseDueDate()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon ng-star-inserted'])[2]"));
		return labour;
	}
	public static WebElement selectDate()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='2']"));
		return labour;
	}
	public static WebElement selectDate2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@role='gridcell']//span[@class='k-link'][normalize-space()='28']"));
		return labour;
	}
	public static WebElement clickNoticeType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[6]"));
		return labour;
	}
	public static WebElement clickRisk()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[7]"));
		return labour;
	}
	public static WebElement clickRemark()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@formcontrolname='remarks']"));
		return labour;
	}
	public static WebElement clickSaveNotice()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Save Notice']"));
		return labour;
	}
	public static WebElement clickSuccessNotice()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[@class='f-label']"));
		return labour;
	}
	public static WebElement clickInvalidNotice()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Notice Number already exist']"));
		return labour;
	}
	public static WebElement clickNoticeDocMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//div[normalize-space()='File is required.']"));
		return labour;
	}
	public static WebElement clickNoticeExport()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@src='../assets/vectors/ExportButton.svg']"));
		return labour;
	}
	public static WebElement clickviewNoticeDocIcon()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Overview'])[1]"));
		return labour;
	}
	public static WebElement clickAct2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select Act')]"));
		return labour;
	}
	public static WebElement clickActPT()		//Bilal
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Professional Tax Act']"));
		return labour;
	}
	public static WebElement clickComplianceStatus()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Compliance Status')]"));
		return labour;
	}
	public static WebElement clickStatutoryDoc()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Statutory Documents']"));
		
		return labour;
	}
	public static WebElement clickComplianceType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[@class='k-input-value-text'][normalize-space()='Compliance']"));
		return labour;
	}
	public static WebElement selectComplianceType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li"));
		return labour;
	}
	public static WebElement selectComplianceType1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[2]"));
		return labour;
	}
	public static WebElement selectYear2024()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[3]"));
		return labour;
	}
	public static WebElement selectComplianceType2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Shops and Establishment and Allied Acts']"));
		return labour;
	}
	public static WebElement selectComplianceType3()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='2025']"));
		return labour;
	}
	public static WebElement selectComplianceType4()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[5]"));
		return labour;
	}
	public static WebElement clickType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//span[contains(text(),'Select Type')])[1]"));
		return labour;
	}
	public static WebElement selectType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[3]"));
		return labour;
	}
	public static WebElement clickPeriod()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Period')]"));
		//span[contains(text(),'Period')]
		return labour;
	}
	public static WebElement PeriodList()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']"));
		return labour;
	}
	public static WebElement clickApply()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='figma-btn-white Actionbutton']"));
		return labour;
	}
	public static WebElement clickBranchTiangle()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[2]"));
		//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted']
		return labour;
	}
	public static WebElement clickBranchcheckbox()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@type=\"checkbox\"])[2]"));
		//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted']
		return labour;
	}
	public static WebElement selectBranch1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@role='group'])[2]"));
		//*[@role='group'])[2]/li
		return labour;
	}
	public static WebElement clickClearBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ClearFilter.svg']"));
		return labour;
	}
	public static WebElement clickdashboard()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Dashboard']"));
		return labour;
	}
	public static WebElement clickMyDoc()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='My Documents']"));
		return labour;
	}
	public static WebElement clickMyDashboard()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='My Dashboard']"));
		return labour;
	}
	public static WebElement gridLoad1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-my-compliance-document/div[3]/kendo-loader/div/span"));
		
		return labour;
	}
	
	public static WebElement FileNotFound()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='File Not Found']"));
		return labour;
	}
	public static WebElement clickview()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("	//img[@title='View']"));
		return labour;
	}
	public static WebElement clickview2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='View'])[2]"));
		return labour;
	}
	public static WebElement clickview3()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='View'])[3]"));
		return labour;
	}
	public static WebElement clickview1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='svg-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement viewPopup()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-window-title k-dialog-title'])[2]"));
		return labour;
	}
	public static WebElement viewPopup1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-window-title k-dialog-title']"));
		return labour;
	}
	public static WebElement clickCloseBtn1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//button[@title='Close'])[2]"));
		return labour;
	}
	public static WebElement clickCloseBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Close']"));
		return labour;
	}
	public static WebElement clickCheckBox()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@type=\"checkbox\"])[2]"));
		return labour;
	}
	public static WebElement clickDownloadbulk()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Download']"));
		return labour;
	}
	public static WebElement clickMasterAbstract()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Abstracts']"));
		return labour;
	}
	public static WebElement clickVieqRegional()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@alt='Icon e'])"));
		return labour;
	}
	public static WebElement clickViewEnglish()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@alt='Action Icon']"));
		return labour;
	}
	public static WebElement clickState1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@role='combobox']"));
		return labour;
	}
	public static WebElement clickDownloadRegiinal()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//tbody/tr[@role='row']/td[3]/img[1])"));
		return labour;
	}
	public static WebElement clickDownloadEnglishl()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//tbody/tr[@role='row']/td[4]/img[1])"));
		return labour;
	}
	
	
	
	
	
	
	
	public static WebElement MyDocument()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//li[normalize-space(.//span[@class='links-name'])='My Documents']"));
		return labour;
	}
	public static WebElement Entity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//span[@class='k-input-inner k-readonly'])[1]"));
		return labour;
	}
	public static WebElement EntityExpand()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement EntityExpand1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[2]"));
		return labour;
	}
	
	public static WebElement checkbox()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@class='radio-child'])[2]"));
		return labour;
	}
	public static WebElement checkbox1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@class='radio-child'])[5]"));
		return labour;
	}
	public static WebElement Applybtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//button[@class='figma-btn-white'])[2]"));
		return labour;
	}
	public static WebElement ComplianceDropdown()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("//app-dropdown-list[@class='dropdown-setting']"));
		return labour;
	}
	public static WebElement Actfilter()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("//span[.='Select Act']"));
		return labour;
	}
	public static WebElement StaDocument()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space(.)='Statutory Documents']"));
		return labour;
	}
	
	public static WebElement MISDocument()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space(.)='MIS Documents']"));
		return labour;
	}
	
	public static WebElement EmployeeESIC()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space(.)='Employee ESIC']"));
		return labour;
	}
	
	public static WebElement CriticalDocuments()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space(.)='Critical Documents']"));
		return labour;
	}
	public static WebElement CheckBox1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		return labour;
	}
	public static WebElement CheckBox2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		return labour;
	}
	public static WebElement CheckBox3()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[4]"));
		return labour;
	}
	public static WebElement Download()		//Method for searching Username input
	{   //P17
		labour = getDriver().findElement(By.xpath("(//img[@title='Download'])[1]"));
		return labour;
	}
	public static WebElement DownloadButton()		//Method for searching Username input
	{   //P17
		labour = getDriver().findElement(By.xpath("//kendo-treelist-list//table[@class='k-table k-grid-table k-table-md']//tbody//tr//td[10]//div//button[3]"));
		return labour;
	}
	public static WebElement Year()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("//span[.='Year']"));
		return labour;
	}
	public static WebElement Period()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("//span[.='Period']"));
		return labour;
	}
	
	public static WebElement ClickAct()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return labour;
	}
	public static WebElement branch()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("//kendo-multiselecttree[@formcontrolname='branches']"));
		return labour;
	}
	public static WebElement Downloads()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Download'])[1]"));
		return labour;
	}
	public static WebElement View()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='View'])[1]"));
		return labour;
	}

	public static WebElement Viewed()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.cssSelector("tr[class='k-master-row k-table-row ng-star-inserted'] div[class='ng-star-inserted'] img[title='View']"));
		return labour;
	}
	public static WebElement ClosePopup()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("(//div[@class='k-window-titlebar-actions k-dialog-titlebar-actions'])[1]"));
		return labour;
	}
	public static WebElement Expand()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted'])[5]"));
		return labour;
	}
	public static WebElement State()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[3]"));
		return labour;
	}
	public static WebElement Location()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted'])[4]"));
		return labour;
	}
	public static WebElement NewFolder()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("//button[@id='menu1']"));
		return labour;
	}
	public static WebElement NewFile()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("(//button[@id='menu1'])[2]"));
		return labour;
	}
	public static WebElement FolderName()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("//div[@class='require-container']/input[@type='text']"));
		return labour;
	}
	public static WebElement Create()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Create']"));
		return labour;
	}
	public static WebElement Close()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.cssSelector("button[title='Close']"));
		return labour;
	}
	public static WebElement folder()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.cssSelector("div[title='Labor Doc'] img[alt='Go to sub-folder']"));
		return labour;
	}
	public static WebElement Share()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("//img[@class='svg-icon']"));
		return labour;
	}
	public static WebElement PermissionSelect()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'])[2]"));
		return labour;
	}
	public static WebElement PermissionSelectValue()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']//li[2]"));
		return labour;
	}
	
	public static WebElement SelectUser()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("//span[@class='k-input-inner k-readonly']"));
		return labour;
	}
	public static WebElement Done()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("//button[@class='figma-btn-blue ng-star-inserted']"));
		return labour;
	}
	public static WebElement SelectUserVal()	//Method for searching button for Save/Sign-in
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		return labour;
	}
	public static WebElement NoticeDocumentDownload()	//1
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Download the Notice Document']"));
		return labour;
	}
	public static WebElement NoticeTranslatedDocument()	//2 Method for Download Notice document
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Download Translated Notice Document']"));
		return labour;
	}
	public static WebElement NoticeApplicationAcknowledgeDocument()	//3 Method for Download Notice document
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Download Extention Application Acknowledgement']"));
		return labour;
	}
	public static WebElement DraftExtensionApplicationDocument()	//4 Method for Download Notice document
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Download the Draft Extension Application']"));
		return labour;
	}
	public static WebElement DraftResponseSMEDocument()	//5 Method for Download Notice document
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Download Draft Response (Prepared by SME)']"));
		return labour;
	}
	
	public static WebElement AssignedComplianceSelectAct()	
	{
		labour = getDriver().findElement(By.xpath("//span[@class='k-input-value-text'][normalize-space()='Select Act']"));
		return labour;
	}
	public static WebElement AssignedComplianceSelectAct1()	
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Contract Labour (Regulation and Abolition) Act, 1970')]"));
		return labour;
	}
	public static WebElement complianceDrp()	
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Register')]"));
		return labour;
	}
	public static WebElement complianceDrpSelect1()	
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Challan']"));
		return labour;
	}
	public static WebElement complianceDrpSelect3()	
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Return']"));
		return labour;
	}
	public static WebElement inputperiodDrp()	
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'July')]"));
		return labour;
	}
	public static WebElement inputperiodDrpSelect1()	
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='January']"));
		return labour;
	}
	public static WebElement inputperiodDrpSelect4()	
	{
		labour = getDriver().findElement(By.xpath("(//span[@class='k-list-item-text'][normalize-space()='April'])[1]"));
		return labour;
	}
	public static WebElement inputYearDrpp()	
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'2025')]"));
		return labour;
	}
	public static WebElement inputYearDrppSelect2()	
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='2024']"));
		return labour;
	}
	public static WebElement inputFinalUploadDownload1()	
	{
		labour = getDriver().findElement(By.xpath("(//button[@class='figma-btn-blue download-btn'][normalize-space()='Download'])[1]"));
		return labour;
	}
	public static WebElement inputFinalUploadDownload2()	
	{
		labour = getDriver().findElement(By.xpath("(//button[@class='figma-btn-blue download-btn'][normalize-space()='Download'])[2]"));
		return labour;
	}
	
	
	
/*	public static WebElement read( )		
	{
		clients = getDriver().findElement(By.xpath("//div[@class='updates']//div[1]//a[1]"));
		return clients;
	}
*/	
	
	public static WebElement read() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//div[@class='updates']//div[1]//a[1]"),
	        By.cssSelector("body > app-root > div > app-layout > section > div > div > app-client-dashboard > div:nth-child(2) > div:nth-child(6) > div > div > app-cd-daily-updates > div > div > div > div > div:nth-child(2) > a"),
	        By.xpath(""),
	        By.xpath("")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("❌ Element not found using any locator.");
	    return null; // All locators failed
	}
	
	
	
	public static WebElement loaderTime() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//div[@class='k-loader-canvas']"),
	        By.xpath("//span[@class='k-loader-segment ng-star-inserted']"),
	        By.cssSelector("body > app-root > div > app-layout > section > div > div > app-client-entity-dashboard-grid > div.loader-overlay.ng-star-inserted > kendo-loader > div"),
	        By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-client-entity-dashboard-grid/div[3]/kendo-loader/div")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("❌ Element not found using any locator.");
	    return null; // All locators failed
	}



	
	
	public static WebElement goToNextPage() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//button[@title='Go to the next page']"),
	        By.xpath("//button[@class='k-pager-nav k-button k-icon-button k-button-md k-button-flat-base k-button-flat']"),
	        By.xpath("")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("❌ Element not found using any locator.");
	    return null; // All locators failed
	}

	public static WebElement goToPreviousPage() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//button[@title='Go to the previous page']"),
	        By.xpath("//button[@title='Go to the previous page']//kendo-icon-wrapper[@class='k-icon-wrapper-host']"),
	        By.xpath("//button[@class='k-pager-nav k-button k-icon-button k-button-md k-button-flat-base k-button-flat']")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("❌ Element not found using any locator.");
	    return null; // All locators failed
	}
	
	public static WebElement goToLastPage() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//button[@title='Go to the last page']"),
	        By.className("k-pager-nav k-pager-last k-button k-icon-button k-button-md k-button-flat-base k-button-flat"),
	        By.xpath("//button[@class='k-pager-nav k-pager-last k-button k-icon-button k-button-md k-button-flat-base k-button-flat']")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("Go To Last Page Element not found using any locator.");
	    return null; // All locators failed
	}
	public static WebElement goToFirstPage() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//button[@title='Go to the first page']"),
	        By.xpath("//button[@class='k-pager-nav k-pager-first k-button k-icon-button k-button-md k-button-flat-base k-button-flat']"),
	        By.xpath("")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("Go To Last Page Element not found using any locator.");
	    return null; // All locators failed
	}
	
	public static WebElement itemPerPageDrp() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//kendo-pager[@class='k-pager k-grid-pager k-pager-md ng-star-inserted' or @class='k-pager k-grid-pager k-pager-md']//kendo-dropdownlist"),
	        By.className(""),
	        By.xpath("")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("Go To Last Page Element not found using any locator.");
	    return null; // All locators failed
	}
	
	public static WebElement itemPerPageselect20() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//div[@class='k-popup k-list-container k-dropdownlist-popup']//kendo-list//div//ul//li//span[normalize-space()='20']"),
	     //   By.className(""),
	        By.xpath("")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("Iteam per page Element not found using any locator.");
	    return null; // All locators failed
	}
	public static WebElement itemPerPageselect10() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//div[@class='k-popup k-list-container k-dropdownlist-popup']//kendo-list//div//ul//li//span[normalize-space()='10']"),
	     //   By.className(""),
	        By.xpath("")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("Iteam Per Page Element not found using any locator.");
	    return null; // All locators failed
	}
	
	public static WebElement itemPerPageselect5() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//div[@class='k-popup k-list-container k-dropdownlist-popup']//kendo-list//div//ul//li//span[normalize-space()='5']"),
	     //   By.className(""),
	        By.xpath("")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("Iteam Per Page Element not found using any locator.");
	    return null; // All locators failed
	}
	public static WebElement itemPerPageselectAll() {
	    List<By> locators = Arrays.asList(
	        By.xpath("//div[@class='k-popup k-list-container k-dropdownlist-popup']//kendo-list//div//ul//li//span[normalize-space()='All']"),
	     //   By.className(""),
	        By.xpath("")     );

	    for (By locator : locators) {
	        try {
	            WebElement element = getDriver().findElement(locator);
	            if (element != null && element.isDisplayed()) {
	                return element; // 🎯 Element found, return it immediately
	            }
	        } catch (Exception e) {
	            // Locator not found, try next one
	        }
	    }
	    System.out.println("Iteam Per Page Element not found using any locator.");
	    return null; // All locators failed
	}
	
	
	
	
}
