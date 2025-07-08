package clientPortal;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class ClientLocators extends BasePage{

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
	
	public static WebElement AVAENTEST( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//input[@value='AVACORED5']"));
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
	
	public static WebElement readTotalItems( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-client-entity-dashboard/div[2]/kendo-grid/kendo-pager/kendo-pager-info"));
		return clients;
	}
	
	public static WebElement readTotalItems1( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-client-dashboard/div[8]/div/div/app-client-compliance-calender/div[2]/div[2]/kendo-grid/kendo-pager/kendo-pager-info"));
		return clients;
	}
	
	public static WebElement Search( )		//Method for closing Message Popup
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
	{
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
	
	public static WebElement View( )		//Method for closing Message Popup
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
	
	public static WebElement State( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[@class='k-input-value-text'][normalize-space()='Select State']"));
		return clients;
	}
	
	public static WebElement State1( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='Maharashtra']"));
		return clients;
	}
	
	public static WebElement Location( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[contains(text(),'Select Loaction')]"));
		return clients;
	}
	
	public static WebElement Location1( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='AHMEDNAGAR [414001]']"));
		return clients;
	}
	
	public static WebElement Branch( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("(//span[contains(text(),'Select Branch')])[1]"));
		return clients;
	}
	
	public static WebElement Branch1( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//span[normalize-space()='Belgaon']"));
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
	
	public static WebElement Clear( )		//Method for closing Message Popup
	{
		clients = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ClearFilter.svg']"));
		return clients;
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
		clients = getDriver().findElement(By.xpath("(//*[name()='g'])[22]"));
		return clients;
	}
	
	public static WebElement Expired( )		
	{
		clients = getDriver().findElement(By.xpath("(//*[name()='g'])[19]"));
		return clients;
	}
	
	public static WebElement ActiveCol( )		
	{
		clients = getDriver().findElement(By.xpath("(//div[@class='cell-content total-click ng-star-inserted'])"));
		return clients;
	}
	
	public static WebElement ExpiredCol( )		
	{
		clients = getDriver().findElement(By.xpath("(//div[@class='cell-content total-click ng-star-inserted'])[2]"));
		return clients;
	}
	
	public static WebElement Overdue( )		
	{
		clients = getDriver().findElement(By.xpath("(//*[name()='g'])[9]"));
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
		clients = getDriver().findElement(By.xpath("//kendo-pager-info[@class='k-pager-info k-label ng-star-inserted']")); //body > app-root > div > app-layout > section > div > div > app-client-entity-dashboard-grid > div.col-12.colpadding0.ng-star-inserted > app-grid-action-item > kendo-grid > kendo-pager > kendo-pager-info
		return clients;
	}
	
	public static WebElement ECOverdue( )		
	{
		clients = getDriver().findElement(By.cssSelector("tbody tr:nth-child(7) td:nth-child(3) div:nth-child(1)"));//body > app-root > div > app-layout > section > div > div > app-client-entity-dashboard > div.col-12.colpadding0.ng-star-inserted > table > tbody > tr:nth-child(8) > td:nth-child(3)
		return clients;
	}
	
	public static WebElement ECComplied( )		
	{
		clients = getDriver().findElement(By.cssSelector("tbody tr:nth-child(10) td:nth-child(2) div:nth-child(1)"));
		return clients;
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
	
	public static WebElement DownloadBtn( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='Download'])[1]"));
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
	
	public static WebElement number( )		
	{
		clients = getDriver().findElement(By.xpath("//*[@class='month-number number-overdue']"));
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
	
	public static WebElement Download( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='Download'])[1]"));
		return clients;
	}
	
	public static WebElement InitiateAction( )		
	{
		clients = getDriver().findElement(By.xpath("(//img[@title='Initiate Action'])[1]"));
		return clients;
	}
	
	public static WebElement selectActivityType( )		
	{
		clients = getDriver().findElement(By.xpath("(//span[contains(text(),'Select Activity Type')])[1]"));
		return clients;
	}
	
	public static WebElement selectActivityType1( )		
	{
		clients = getDriver().findElement(By.xpath("(//span[contains(text(),'Approval')])[1]"));
		return clients;
	}
	
	public static WebElement Sumit( )		
	{
		clients = getDriver().findElement(By.xpath("(//button[normalize-space()='Submit'])[1]"));
		return clients;
	}
	
	public static WebElement read( )		
	{
		clients = getDriver().findElement(By.xpath("//div[@class='updates']//div[1]//a[1]"));
		return clients;
	}
	
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
	
	public static WebElement BrowseIn1( )		
	{
		clients = getDriver().findElement(By.xpath("(//button[@class='figma-btn-gray'][normalize-space()='Browse'])[2]"));
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
		clients = getDriver().findElement(By.xpath("//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon ng-star-inserted']"));
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
		clients = getDriver().findElement(By.xpath("(//img[contains(@title,'Edit')])[2]"));
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

