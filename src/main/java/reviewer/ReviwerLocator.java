package reviewer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class ReviwerLocator extends BasePage
{
	private static WebElement labour = null;			//WebElement variable created for Username input 

	public static WebElement SerchCustomer()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//input[@class='f-textbox']"));
		//input[@class='f-textbox']
		return labour;
	}
	public static WebElement clickDashboard()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Dashboard']"));
		return labour;
	}
	public static WebElement clickStaturyDocumentArrow()
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Statutory Document'])[1]"));
		return labour;
	}
	public static WebElement clickWorkspaceArrow()
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Workspace'])[1]"));
		return labour;
	}
	
	
	public static WebElement clickStatutoryDoc()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Statutory Documents']"));
		
		return labour;
	}
	public static WebElement clickComplianceType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'][normalize-space()='Compliance'])[1]"));
		
		return labour;
	}
	public static WebElement selectComplianceType()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li"));
		return labour;
	}
	public static WebElement selectYear2024()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='2024']"));
		return labour;
	}
	public static WebElement selectComplianceType1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[2]"));
		return labour;
	}
	public static WebElement selectComplianceType5()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[4]"));
		return labour;
	}
	public static WebElement selectComplianceType4()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[3]"));
		return labour;
	}
	public static WebElement Dropdown()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']"));
		return labour;
	}
	public static WebElement selectComplianceType6()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[9]"));
		return labour;
	}
	public static WebElement selectComplianceType2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[12]"));
		return labour;
	}
	public static WebElement selectComplianceType3()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-ul']/li[11]"));
		return labour;
	}
	public static WebElement clickAct2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Act')]"));
		return labour;
	}
	public static WebElement clickYear()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Year')]"));
		return labour;
	}
	public static WebElement clickPeriod()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Period')]"));
		return labour;
	}
	public static WebElement clickComplianceStatus()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Compliance Status')]"));
		return labour;
	}
	public static WebElement clickBranch1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Select Branch')]"));
		return labour;
	}
	public static WebElement clickBranchTiangle()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement selectBranch1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@role='group'])[2]/li"));
		return labour;
	}
	public static WebElement selectBranch2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@role='group'])[2]"));
		return labour;
	}
	public static WebElement clickTriangleGrid()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-svg-i-caret-alt-right k-treelist-toggle k-svg-icon k-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement clickDownload()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Download']"));
		return labour;
	}
	public static WebElement clickDownload1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//img[@title='Download'])[2]"));
		return labour;
	}
	public static WebElement clickDownload2()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@alt='Download Document']"));
		return labour;
	}
	public static WebElement clickCloseBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Close']"));
		return labour;
	}
	public static WebElement clickCloseBtn1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//button[@title='Close'])[2]"));
		return labour;
	}
	public static WebElement clickview()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("	//img[@title='View']"));
		return labour;
	}
	public static WebElement clickview1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='svg-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement clickOverview()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Overview']"));
		return labour;
	}
	public static WebElement viewPopup()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-window-title k-dialog-title'])[2]"));
		return labour;
	}
	public static WebElement OverviewPopup()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-window-title k-dialog-title']"));
		return labour;
	}
	public static WebElement readTotalItems()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-pager-info k-label']"));
		return labour;
	}
	public static WebElement selectDropdown()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-list-item-text']"));
		return labour;
	}
	public static WebElement clickClosedBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='k-svg-i-x k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return labour;
	}
	public static WebElement clickApply()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ApplyFilter.svg']"));
		
		return labour;
	}
	public static WebElement clickClearBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ClearFilter.svg']"));
		
		return labour;
	}
	public static WebElement clickdashboard()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='My Dashboard']"));
		return labour;
	}
	public static WebElement clickcheckbox()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//input[@type='checkbox'])"));
		
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
	public static WebElement clickOkBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='OK']"));
		return labour;
	}
	public static WebElement clickBranchRadioBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@id='State']"));
		return labour;
	}
	public static WebElement clickComplianceRadioBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@id='Compliance']"));
		return labour;
	}
	public static WebElement clickExportOnboardEntity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
		
		return labour;
	}
	public static WebElement clickOnboardEntity()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Onboard Entity']"));
		
		return labour;
	}
	public static WebElement clickManageMaster()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[normalize-space()='Manage Masters']"));
		return labour;
	}
	public static WebElement clickSealandSignatureBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@src='../assets/vectors/UploadButton.svg']"));
		return labour;
	}
	public static WebElement clickBrowse1()		//Method for searching Username input
	{
		 // wait = new WebDriverWait(getDriver(), 20);
	       labour = getDriver().findElement(By.xpath("//label[normalize-space()='Browse']"));
	   	     return labour;
		
	}
	public static WebElement clickUploadbtnCTCBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Upload']"));
		return labour;
	}
	public static WebElement clickMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[@class='f-label']"));
		return labour;
	}
	public static WebElement clickcloseBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[@title='Close']"));
		return labour;
	}
	public static WebElement clickDesignation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Designation']"));
		return labour;
	}
	public static WebElement clickAddNewDesignation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//button[normalize-space()='Add New']"));
		return labour;
	}
	public static WebElement enterDesignation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@id='Designation']"));
		return labour;
	}
	public static WebElement successMsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Designation Added Successfully']"));
		return labour;
	}
	public static WebElement clicksave()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//button[normalize-space()='Save'])[1]"));
		return labour;
	}
	public static WebElement readTotalItemDesignation()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-designation-master/kendo-grid/kendo-pager/kendo-pager-info"));
		return labour;
	}
	public static WebElement clickExportBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@class='exportbtn']"));
		return labour;
	}
	public static WebElement GridLoad1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-designation-master/div[2]/kendo-loader/div/span[1]"));
		return labour;
	}
	public static WebElement clickUploadBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//img[@title='Upload Bulk']"));
		return labour;
	}
	public static WebElement UploadDesignationDetailes()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//a[normalize-space()='Upload Designation Details']"));
		return labour;
	}
	public static WebElement clickstatus()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])[2]"));
		return labour;
	}
	public static WebElement selectstatus()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//span[contains(text(),'Active')]"));
		return labour;
	}
	public static WebElement clickclearBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@src='../assets/vectors/ClearFilter.svg']"));
		return labour;
	}
	public static WebElement clickDeleteBtn()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//*[@title='Delete']"));
		return labour;
	}
	public static WebElement clickDeletemsg()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Are you sure you want to delete this record?']"));
		return labour;
	}
	public static WebElement clickDeletemsg1()		//Method for searching Username input
	{
		labour = getDriver().findElement(By.xpath("//h4[normalize-space()='Data Deleted Successfully']"));
		return labour;
	}
	
}
