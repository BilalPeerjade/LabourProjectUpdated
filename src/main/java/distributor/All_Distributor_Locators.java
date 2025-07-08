package distributor;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import login.BasePage;

public class All_Distributor_Locators extends BasePage {

	public static FileInputStream fis = null;	//File input stream variable
	public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
	public static XSSFSheet sheet = null;		//Sheet variable
	
	
	private static WebElement uname = null;			//WebElement variable created for Username input 
	private static WebElement pass = null;			//WebElement variable created for Password input
	private static WebElement submit = null;		//WebElement variable created for Submit button click
	
	private static WebElement user = null;				//WebElement variable created for 'Categories' click
	private static WebElement compliances = null;				//WebElement variable created for 'Compliances' read and click
	private static List<WebElement> compliancesList = null;	
	
	public static WebElement Users( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='User']"));
		return user;
	}
	
	public static WebElement addNewBtn( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Add New']"));
		return user;
	}
	
	public static WebElement firstName( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='First Name']"));
		return user;
	}
	
	
	public static WebElement lastName( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Last Name']"));
		return user;
	}
	
	public static WebElement designation( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Designation']"));
		return user;
	}
	
	public static WebElement mail( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Email']"));
		return user;
	}
	
	public static WebElement contactno( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Contact No']"));
		return user;
	}
	
	public static WebElement Status( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[2]"));
		return user;
	}
	
	public static WebElement Status1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//span[contains(text(),'Active')])"));
		return user;
	}
	
	public static WebElement roledd( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//*[@class='k-input-value-text'])[3]"));
		return user;
	}
	
	public static WebElement roledd1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Performer')]"));
		return user;
	}
	
	public static WebElement Save( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Save']"));
		return user;
	}
	
	public static WebElement ok( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[@class='figma-btn-green']"));
		return user;
	}
	
	public static WebElement Edit( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//tbody/tr[1]/td[7]/img[1]"));
		return user;
	}
	
	public static WebElement SearchUser( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@class='k-input-inner']"));
		return user;
	}
	
	public static WebElement SearchUser1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//*[@class='k-list-item-text']"));
		return user;
	}
	
	public static WebElement Apply( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ApplyFilter.svg']"));
		return user;
	}
	
	public static WebElement Clear( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//div[@class='col-md-8 colpadding0']//button[2]"));
		return user;
	}
	
	public static WebElement Delete( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//tbody/tr[1]/td[7]/img[2]"));
		return user;
	}
	
	public static WebElement DeleteOk( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//div[@class='col-md-12 ok-btn-confirm colpadding0 ng-star-inserted']//button[@class='figma-btn-blue']"));
		return user;
	}
	
	public static WebElement DeleteCan( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Cancel']"));
		return user;
	}
	
	public static WebElement Back( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Back']"));
		return user;
	}
	
	
	public static WebElement GridCount( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-user-master > kendo-grid > kendo-pager > kendo-pager-info"));
		return user;
	}
	
	
	
	public static WebElement ExportT2( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
		return user;
	}
	
	public static WebElement ExportT1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
		return user;
	}
	
	
	
	public static WebElement Corporate( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Corporate']"));
		return user;
	}
	
	public static WebElement name( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Customer Name']"));
		return user;
	}
	
	public static WebElement CorporateID( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Corporate ID']"));
		return user;
	}
	
	public static WebElement BuyerName( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Buyer Name']"));
		return user;
	}
	
	public static WebElement Email( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Email']"));
		return user;
	}
	
	public static WebElement ContactNo( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Contact No']"));
		return user;
	}
	
	public static WebElement Check( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Check']"));
		return user;
	}
	
	public static WebElement CorporateEdit( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//tbody/tr[1]/td[6]/div[1]/img[1]"));
		return user;
	}
	
	public static WebElement Pan( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//*[@formcontrolname='cO_PAN']"));
		return user;
	}
	
	public static WebElement DeleteCor( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//tbody/tr[1]/td[6]/div[1]/img[2]"));
		return user;
	}
	
	public static WebElement view( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//tbody/tr[1]/td[6]/div[1]/img[3]"));
		return user;
	}
	
	public static WebElement Entity( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//a[normalize-space()='Entity']"));
		return user;
	}
	
	public static WebElement EntityName( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Entity Name']"));
		return user;
	}
	
	public static WebElement ClientId( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Client Id']"));
		return user;
	}
	
	public static WebElement PFType( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[@class='k-input-value-text'][normalize-space()='Select']"));
		return user;
	}
	
	public static WebElement PFType1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Client']"));
		return user;
	}
	
	public static WebElement PFCode( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter PF Code']"));
		return user;
	}
	
	public static WebElement Address( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//textarea[@placeholder='Enter Address']"));
		return user;
	}
	
	public static WebElement EnterEmail( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Email']"));
		return user;
	}
	
	
	public static WebElement State( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Select State')]"));
		return user;
	}
	
	public static WebElement State1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Andhra Pradesh')]"));
		return user;
	}
	
	
	public static WebElement City( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Select City')]"));
		return user;
	}
	
	public static WebElement City1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Amaravati main Road-522402')]"));
		return user;
	}
	
	public static WebElement ContactPerson( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Contact Person']"));
		return user;
	}
	
	public static WebElement ContactNo1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Contact Number']"));
		return user;
	}
	
	
	public static WebElement StatusE( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[6]"));
		return user;
	}
	
	public static WebElement StatusE1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Active']"));
		return user;
	}
	
	public static WebElement CommencementDate( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//*[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return user;
	}
	
	public static WebElement CommencementDate1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='7']"));
		return user;
	}
	
	public static WebElement WagePeriodFrom( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[7]"));
		return user;
	}
	
	public static WebElement WagePeriodFrom1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='2']"));
		return user;
	}
	
	public static WebElement WagePeriodTo( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[8]"));
		return user;
	}
	
	public static WebElement WagePeriodTo1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'3')]"));
		return user;
	}
	
	public static WebElement PaymentDay( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[9]"));
		return user;
	}
	
	public static WebElement PaymentDay1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='2']"));
		return user;
	}
	
	public static WebElement EstablishmentType()	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[10]"));
		return user;
	}
	
	public static WebElement EstablishmentType1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Shop & Establishment')]"));
		return user;
	}
	
	public static WebElement ActApplicability()	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[11]"));
		return user;
	}
	
	public static WebElement ActApplicability1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='State']"));
		return user;
	}
	
	public static WebElement BonusExempted()	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[13]"));
		return user;
	}
	
	public static WebElement BonusExempted1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Yes')]"));
		return user;
	}
	
	public static WebElement EDLIExcemption()	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[14]"));
		return user;
	}
	
	public static WebElement EDLIExcemption1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'No')]"));
		return user;
	}
	
	public static WebElement BonusPer( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Bonus Percentage']"));
		return user;
	}
	
	public static WebElement next( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Next']"));
		return user;
	}
	
	public static WebElement Salutation( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[3]"));
		return user;
	}
	
	public static WebElement Salutation1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Ms')]"));
		return user;
	}
	
	public static WebElement FirstName( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@formcontrolname='FirstName']"));
		return user;
	}
	
	public static WebElement ContactNumber( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@formcontrolname='ContactNumber']"));
		return user;
	}
	
	public static WebElement SPOCEmail( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@formcontrolname='SPOCEmail']"));
		return user;
	}
	
	public static WebElement Designationspo( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Designation']"));
		return user;
	}
	
	public static WebElement EP1Salutation( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[4]"));
		return user;
	}
	
	public static WebElement EP1Salutation1( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//span[contains(text(),'Ms')])[2]"));
		return user;
	}
	
	public static WebElement EP1FirstName( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//div[4]//div[2]//div[1]//input[1]"));
		return user;
	}
	
	public static WebElement EP1ContactNumber( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//div[5]//div[2]//div[1]//input[1]"));
		return user;
	}
	
	public static WebElement EP1SPOCEmail( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("//div[6]//div[1]//div[1]//input[1]"));
		return user;
	}
	
	public static WebElement EP1Designationspo( )		//Method for closing Message Popup
	{
		user = getDriver().findElement(By.xpath("(//input[@placeholder='Enter Designation'])[2]"));
		return user;
	}
	
	
	public static WebElement IVSPOCName( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter First Name']"));
		return user;
	}
	
	public static WebElement IVSPOCEnterEmail( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Email']"));
		return user;
	}
	
	public static WebElement IVSPOCMobileNumber( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Mobile Number']"));
		return user;
	}
	
	public static WebElement Type( )		
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[3]"));
		return user;
	}
	
	public static WebElement Type1( )		
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Public')]"));
		return user;
	}
	
	public static WebElement EDLIExcemptionType( )		
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[4]"));
		return user;
	}
	
	public static WebElement EDLIExcemptionType1( )		
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='B']"));
		return user;
	}
	
	public static WebElement ServiceTaxExempted( )		
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[5]"));
		return user;
	}
	
	public static WebElement ServiceTaxExempted1( )		
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Yes')]"));
		return user;
	}
	
	public static WebElement CLRAApplicable( )		
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[6]"));
		return user;
	}
	
	public static WebElement CLRAApplicable1( )		
	{
		user = getDriver().findElement(By.xpath("(//span[contains(text(),'Yes')])[2]"));
		return user;
	}
	
	public static WebElement CLRAType( )		
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[7]"));
		return user;
	}
	
	public static WebElement CLRAType1( )		
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Client as Contractor')]"));
		return user;
	}
	
	public static WebElement ContractorEmployerName( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter Employer Name']"));
		return user;
	}
	
	public static WebElement POApplicable( )		
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[8]"));
		return user;
	}
	
	public static WebElement POApplicable1( )		
	{
		user = getDriver().findElement(By.xpath("(//span[contains(text(),'Yes')])[3]"));
		return user;
	}
	
	public static WebElement AgreementID( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Enter AgreementID']"));
		return user;
	}
	
	public static WebElement Mandate( )		
	{
		user = getDriver().findElement(By.xpath("(//button[@aria-label='Select'])[9]"));
		return user;
	}
	
	public static WebElement Mandate1( )		
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'One time')]"));
		return user;
	}
	
	public static WebElement Triangle( )		
	{
		user = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])"));
		return user;                             
	}
	
	public static WebElement selectDropdown( )		
	{
		user = getDriver().findElement(By.xpath("//input[@id='k-8631657d-527f-4962-986f-59bcf19af021']"));
		return user;
	}
	
	public static WebElement EditEntity( )		
	{
		user = getDriver().findElement(By.xpath("(//img[@title='Edit'])[1]"));
		return user;
	}
	
	public static WebElement DeleteEntity( )		
	{
		user = getDriver().findElement(By.xpath("(//img[@title='Delete'])[1]"));
		return user;
	}
	
	public static WebElement ValMsg( )		
	{
		user = getDriver().findElement(By.xpath("//div[contains(text(),' PF Code must be either \"NA\" or 15 alphanumeric characters (no leading 0). ')]"));
		return user;
	}
	
	public static WebElement ValMsg1( )		
	{
		user = getDriver().findElement(By.xpath("//div[contains(text(),'Please enter a valid email address.')]"));
		return user;
	}
	

	public static WebElement ValMsg2( )		
	{
		user = getDriver().findElement(By.xpath("//div[contains(text(),'Only Numbers, max 10 digits allowed.')]"));
		return user;
	}
	
	public static WebElement BulkUpload ( )		
	{
		user = getDriver().findElement(By.xpath("(//button[normalize-space()='Bulk Upload'])[1]"));
		return user;
	}
	
	public static WebElement DownloadTemplate ( )		
	{
		user = getDriver().findElement(By.xpath("//img[@title='Sample Template']"));
		return user;
	}
	
	public static WebElement  Browse ( )		
	{
		user = getDriver().findElement(By.xpath("//label[normalize-space()='Browse']"));
		return user;
	}
	
	public static WebElement  UploadT2 ( )		//Bilal when change class
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Upload']"));
		return user;
	}
	
	public static WebElement  UploadT3 ( )		
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Upload']"));
		return user;
	}
	
	
	
	public static WebElement  UploadAM ( )		
	{
		user = getDriver().findElement(By.xpath("(//button[normalize-space()='Upload'])[2]"));
		return user;
	}
	
	public static WebElement  UploadAM1 ( )		
	{
		user = getDriver().findElement(By.xpath("(//button[normalize-space()='Upload'])[3]"));
		return user;
	}
	
	public static WebElement  Upload1 ( )		
	{
		user = getDriver().findElement(By.xpath("//button[@class='figma-btn-blue figma-popup custom-button']"));
		return user;
	}
	
	public static WebElement  Upload2 ( )		
	{
		user = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-paycode-master/div[3]/app-paycode-upload-popup/kendo-dialog/div[2]/div/button"));
		return user;
	}
	
	public static WebElement  CheckBox ( )		
	{
		user = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[4]"));
		return user;
	}
	
	public static WebElement  Reset ( )		
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Reset']"));
		return user;
	}
	
	public static WebElement  CheckBoxAll ( )		
	{
		user = getDriver().findElement(By.xpath("(//input[@type='checkbox'])"));
		return user;
	}
	
	public static WebElement  EntityLocation ( )		
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Entity Location']"));
		return user;
	}
	
	public static WebElement  EntityExcel ( )		
	{
		user = getDriver().findElement(By.xpath("//div[@class='row colpadding0']//button[4]"));
		return user;
	}
	
	public static WebElement  Searchentities ( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Type to Search']"));
		return user;
	}
	
	public static WebElement  Dashboard ( )		
	{
		user = getDriver().findElement(By.xpath("//img[@title='Dashboard']"));
		return user;
	}
	
	public static WebElement  OnboardEntity ( )		
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Onboard Entity']"));
		return user;
	}
	
	public static WebElement  Addpremises ( )		
	{
		user = getDriver().findElement(By.xpath("//img[@title='Add']"));
		return user;
	}
	
	public static WebElement  CateringApplicability( )		
	{
		user = getDriver().findElement(By.xpath("//input[@type='checkbox']"));
		return user;
	}
	
	public static WebElement  BranchName( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Branch Name']"));
		return user;
	}
	
	public static WebElement  Maharashtra( )		
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Maharashtra']"));
		return user;
	}
	
	public static WebElement  BranchAddress( )		
	{
		user = getDriver().findElement(By.xpath("//textarea[@placeholder='Branch Address']"));
		return user;
	}
	
	public static WebElement  Location( )		
	{
		user = getDriver().findElement(By.xpath("(//input[@class='k-input-inner'])[2]"));
		return user;
	}
	
	
	public static WebElement  aurangabad( )		
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Aurangabad')]"));
		return user;
	}
	
	public static WebElement  EstablishmentTypeb( )		
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Select']"));
		return user;
	}
	
	public static WebElement  OfficeType( )		
	{
		user = getDriver().findElement(By.xpath("(//span[normalize-space()='Select'])[2]"));
		return user;
	}
	
	public static WebElement  OfficeType1( )		
	{
		user = getDriver().findElement(By.xpath("(//span[contains(text(),'Branch')])[2]"));
		return user;
	}
	
	public static WebElement  EmployerName( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Employee Name']"));
		return user;
	}
	
	public static WebElement  EmployerAddress( )		
	{
		user = getDriver().findElement(By.xpath("//textarea[@placeholder='Employee Address']"));
		return user;
	}
	
	public static WebElement  ManagerName( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Manager Name']"));
		return user;
	}
	
	public static WebElement  ManagerAddress( )		
	{
		user = getDriver().findElement(By.xpath("//textarea[@placeholder='Manager Address']"));
		return user;
	}
	
	public static WebElement  CompanyPhNo( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Mobile No']"));
		return user;
	}
	
	public static WebElement  HRPhNo( )		
	{
		user = getDriver().findElement(By.xpath("(//input[@placeholder='Mobile No'])[2]"));
		return user;
	}
	
	
	public static WebElement  NatureofBusiness( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Nature of Business']"));
		return user;
	}
	
	public static WebElement  WorkTimings( )		
	{
		user = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'])[3]"));
		return user;
	}
	
	public static WebElement  WorkTimings1( )		
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Shift')]"));
		return user;
	}
	
	public static WebElement  WeekOffDays( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Select']"));
		return user;
	}
	
	public static WebElement  WeekOffDays1( )		
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Monday']"));
		
		return user;
	}
	
	public static WebElement  Municipality( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Muncipality']"));
		return user;
	}
	
	public static WebElement  BusinessType( )		
	{
		user = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'])[4]"));
		return user;
	}
	
	public static WebElement  BusinessType1( )		
	{
		user = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return user;
	}
	
	public static WebElement  Powertomposefines( )		
	{
		user = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'])[5]"));
		return user;
	}
	
	public static WebElement  Powertomposefines1( )		
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'YES')]"));
		return user;
	}
	
	public static WebElement  MaintainForms( )		
	{
		user = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'])[6]"));
		return user;
	}
	
	public static WebElement  MaintainForms1( )		
	{
		user = getDriver().findElement(By.xpath("(//span[contains(text(),'YES')])[2]"));
		return user;
	}
	
	public static WebElement  TradeLicence( )		
	{
		user = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'])[8]"));
		return user;
	}
	
	public static WebElement  TradeLicence1( )		
	{
		user = getDriver().findElement(By.xpath("(//span[contains(text(),'YES')])[3]"));
		return user;
	}
	
	public static WebElement  BranchStartDate( )		
	{
		user = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-calendar k-button-icon k-svg-icon k-icon ng-star-inserted'])[4]"));
		return user;
	}
	
	public static WebElement  StatusB( )		
	{
		user = getDriver().findElement(By.xpath("(//span[@class='k-input-value-text'])[9]"));
		return user;
	}
	
	public static WebElement  LocationAnchor( )		
	{
		user = getDriver().findElement(By.xpath("(//input[@class='k-input-inner'])[11]"));
		return user;
	}
	
	public static WebElement  LocationAnchor1( )		
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Sunil Kumar']"));
		return user;
	}
	
	public static WebElement  ExportPremises( )		
	{
		user = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ExportButton.svg']"));
		return user;
	}
	
	public static WebElement  UpoadBranch( )		
	{
		user = getDriver().findElement(By.xpath("(//*[@class='figma-btn-blue'])[3]"));
		return user;
	}
	
	public static WebElement  UpoadBranchSam( )		
	{
		user = getDriver().findElement(By.xpath("//img[@title='Sample Template']"));
		return user;
	}
	
	public static WebElement  BranchTriangle( )		
	{
		user = getDriver().findElement(By.xpath("(//*[@viewBox='0 0 512 512'])[9]"));
		return user;
	}
	
	public static WebElement  BranchTriangle1( )		
	{
		user = getDriver().findElement(By.xpath("(//*[@viewBox='0 0 512 512'])[10]"));
		return user;
	}
	
	public static WebElement  Deletebranch( )		
	{
		user = getDriver().findElement(By.xpath("(//img[@title='Delete'])[1]"));
		return user;
	}
	
	public static WebElement  Searchbranch( )		
	{
		user = getDriver().findElement(By.xpath("//input[@placeholder='Type to Search']"));
		return user;
	}
	
	public static WebElement  PaycodeMapping( )		
	{
		user = getDriver().findElement(By.xpath("//a[normalize-space()='Paycode Mapping']"));
		return user;
	}
	
	public static WebElement  UserBranchMapping( )		
	{
		user = getDriver().findElement(By.xpath("//a[normalize-space()='User-Branch Mapping']"));
		return user;
	}
	
	public static WebElement  PaycodeAdd( )		
	{
		user = getDriver().findElement(By.xpath("//button[@title='Add New']"));
		return user;
	}
	
	public static WebElement  Header( )		
	{
		user = getDriver().findElement(By.xpath("//input[@name='headerName']"));
		return user;
	}
	
	public static WebElement  PaycodeType( )		
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Select']"));
		return user;
	}
	
	public static WebElement  PaycodeType1( )		
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Earning')]"));
		return user;
	}
	
	public static WebElement  Paycode( )		
	{
		user = getDriver().findElement(By.xpath("(//span[normalize-space()='Select'])[2]"));
		return user;
	}
	
	public static WebElement  Paycode1( )		
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Academic Allowance']"));
		return user;
	}
	
	public static WebElement  SequenceOrder( )		
	{
		user = getDriver().findElement(By.xpath("//input[@name='sequenceOrder']"));
		return user;
	}
	
	public static WebElement  EditPaycod( )		
	{
		user = getDriver().findElement(By.xpath("(//img[@title='Edit'])[1]"));
		return user;
	}
	
	public static WebElement  uploadPaycod( )		
	{
		user = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/uploadWhite.svg']"));
		return user;
	}
	
	public static WebElement  SamplePaycod( )		
	{
		user = getDriver().findElement(By.xpath("(//*[@id='btnSampleRLCS'])[2]"));
		return user;
	}
	
	public static WebElement  serach( )		
	{
		user = getDriver().findElement(By.xpath("(//*[@id='btnSampleRLCS'])[2]"));
		return user;
	}
	
	public static WebElement  Deletepaycode( )		
	{
		user = getDriver().findElement(By.xpath("(//img[@title='Delete'])[1]"));
		return user;
	}
	
	public static WebElement   MapUser ( )		
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Map User']"));
		return user;
	}
	
	public static WebElement   SearchAct ( )		
	{
		user = getDriver().findElement(By.xpath("(//input[@class='k-input-inner'])[2]"));
		return user;
	}
	
	
	public static WebElement   Shops ( )		
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Shops and Establishment Allied']"));
		return user;
	}
	
	public static WebElement   Branch ( )		
	{
		user = getDriver().findElement(By.xpath("(//span[normalize-space()='Select Branch'])[1]"));
		return user;
	}
	
	public static WebElement   Branch1 ( )		
	{
		user = getDriver().findElement(By.xpath("(//span[@class='k-input-inner k-readonly'])[2]"));
		return user;
	}
	
	public static WebElement   Branchtri ( )		
	{
		user = getDriver().findElement(By.xpath("//*[@class='k-svg-i-caret-alt-right k-svg-icon k-icon ng-star-inserted']"));
		return user;
	}
	
	public static WebElement   Branchtri1 ( )		
	{
		user = getDriver().findElement(By.xpath("//input[@type='checkbox']"));
		return user;
	}
	
	public static WebElement   Branchtri2 ( )		
	{
		user = getDriver().findElement(By.xpath("(//input[@type='checkbox'])[5]"));
		return user;
	}
	
	
	public static WebElement   SearchUserm ( )		
	{
		user = getDriver().findElement(By.xpath("(//input[@class='k-input-inner'])[3]"));
		return user;
	}
	
	public static WebElement   SearchUsermA ( )		
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Jassimran (jassimran.s@teamlease.com)']"));
		return user;
	}
	
	public static WebElement   SearchUserm1 ( )		
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Sagar (sagaryadav478@gmail.com)']"));
		return user;
	}
	
	public static WebElement   Management ( )		
	{
		user = getDriver().findElement(By.xpath("//input[@id='rdIndustry']"));
		return user;
	}
	
	public static WebElement   SelectAct ( )		
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),'Select Act')]"));
		return user;
	}
	
	public static WebElement   SelectBranchT2 ( )		
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),' Select Branches ')]"));
		return user;
	}
	
	public static WebElement   SelectBranchT1 ( )		
	{
		user = getDriver().findElement(By.xpath("//span[contains(text(),' Select Branches ')]"));
		return user;
	}
	
	
	public static WebElement   ClearFilter ( )		
	{
		user = getDriver().findElement(By.xpath("//img[@src='../assets/vectors/ClearFilter.svg']"));
		return user;
	}
	
	public static WebElement   Grid ( )		
	{
		user = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-user-branch-mapping/div[2]/app-grid-action-item/kendo-grid/kendo-pager/kendo-pager-info"));
		return user;
	}
	
	public static WebElement    UploadAddressMapping  ( )		
	{
		user = getDriver().findElement(By.xpath("//button[normalize-space()='Upload Address Mapping']"));
		return user;
	}
	
	public static WebElement    SampleDoc  ( )		
	{
		user = getDriver().findElement(By.xpath("//div[@class='ng-star-inserted']//a[1]"));
		return user;
	}
	
	public static WebElement    MasterDownload  ( )		
	{
		user = getDriver().findElement(By.xpath("(//a[normalize-space()='Master Download'])[1]"));
		return user;
	}
	
	public static WebElement  AllCheck  ( )		
	{
		user = getDriver().findElement(By.xpath("(//input[@type='checkbox'])"));
		return user;
	}
	
	public static WebElement  ManageMasters  ( )		
	{
		user = getDriver().findElement(By.xpath("//span[normalize-space()='Manage Masters']"));
		return user;
	}
	
	public static WebElement  Gridcount  ( )		
	{
		user = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-leave-type-master/kendo-grid/kendo-pager/kendo-pager-info"));
		return user;
	}
	
	public static WebElement  Gridcount1  ( )		
	{
		user = getDriver().findElement(By.xpath("/html/body/app-root/div/app-layout/section/div/div/app-statutory-master/kendo-grid/kendo-pager/kendo-pager-info"));
		return user;
	}
	
	public static WebElement  LeaveType  ( )		
	{
		user = getDriver().findElement(By.xpath("//a[normalize-space()='Leave Type']"));
		return user;
	}
	
	public static WebElement  SearchT1( )		//Bilal change method name 
	{
		user = getDriver().findElement(By.xpath("//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon']"));
		return user;
	}
	public static WebElement  SearchT2( )		
	{
		user = getDriver().findElement(By.xpath("//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon']"));
		return user;
	}
	
	
	
	public static WebElement  Search1( )		
	{
		user = getDriver().findElement(By.xpath("(//*[@class='k-svg-i-caret-alt-down k-button-icon k-svg-icon k-icon'])[2]"));
		return user;
	}
	
	public static WebElement  SearchLT  ( )		
	{
		user = getDriver().findElement(By.xpath("(//*[@class='k-list-ul']/li)[2]"));
		return user;
	}
	
	public static WebElement  StatutoryMaster( )		
	{
		user = getDriver().findElement(By.xpath("//a[normalize-space()='Statutory Master']"));
		return user;
	}
	
	public static WebElement  ComplianceType( )		
	{
		user = getDriver().findElement(By.xpath("//span[@class='k-input-value-text']"));
		return user;
	}
	
	public static WebElement  ComplianceType1  ( )		
	{
		user = getDriver().findElement(By.xpath("(//*[@class='k-list-ul']/li)[2]"));
		return user;
	}
	
	public static WebElement  ComplianceType2  ( )		
	{
		user = getDriver().findElement(By.xpath("(//*[@class='k-list-ul']/li)[3]"));
		return user;
	}
	
	public static WebElement  ComplianceType3  ( )		
	{
		user = getDriver().findElement(By.xpath("(//*[@class='k-list-ul']/li)[4]"));
		return user;
	}
	
	
	
	
	
	
	
	
	
	
	public static WebElement setUname()		//Method for searching Username input
	{
		uname = getDriver().findElement(By.xpath("//input[@placeholder='Username']"));
		return uname;
	}
	
	
	public static WebElement setPassword()	//Method for searching Password input
	{
		pass =getDriver().findElement(By.xpath("//input[@placeholder='Password']"));
		return pass;
	}
	
	
	public static WebElement clickSubmit()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.id("Submit"));
		return submit;
	}
	
	public static WebElement Search()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.className("f-textbox"));
		return submit;
	}
	public static WebElement DashboardArrow()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//img[@title='Dashboard']"));
		return submit;
	}
	public static WebElement Brows()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//label[normalize-space()='Browse']"));
		return submit;
	}
	public static WebElement Button()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-blue'])[4]"));
		return submit;
	}
	public static WebElement Upload()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-blue upload-btn']"));
		return submit;
	}
	public static WebElement UploadSuccessfully()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//h4[@class='f-label']"));
		return submit;
	}
	public static WebElement Msg()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//small[@class='text-danger ng-star-inserted']"));
		return submit;
	}
	
	public static WebElement GenerationMsg()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//h4[@class='f-label']"));
		return submit;
	}
	public static WebElement Submit()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//button[@class='figma-btn-blue']"));
		return submit;
	}
	
	public static WebElement ComplianceRadioButton()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//input[@id='rdFai'])[1]"));
		return submit;
	}
	
	
	public static WebElement PenActnClosePopup()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-svgicon[@class='k-svg-i-x k-button-icon k-svg-icon k-icon ng-star-inserted'])[2]"));
		return submit;
	}
	public static WebElement ClosePopup()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-svgicon[@class='k-svg-i-x k-button-icon k-svg-icon k-icon ng-star-inserted']"));
		return submit;
	}
	
	public static WebElement ComplianceBox()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.className("min-card-count"));
		return submit;
	}
	
	public static WebElement UpcomingBox()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(2) > div:nth-child(2) > div > div > div:nth-child(2) > div.min-card-count"));
		return submit;
	}
	
	public static WebElement OverdueBox()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(2) > div:nth-child(3) > div > div > div:nth-child(2) > div.min-card-count"));
		return submit;
	}
	
	public static WebElement PendingActionBox()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(2) > div:nth-child(4) > div > div > div:nth-child(2) > div.min-card-count"));
		return submit;
	}
	public static WebElement PendingActionEdit()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//img[@class='svg-icon ng-star-inserted']"));
		return submit;
	}
	public static WebElement ClosedDelayed()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@id='rdFai']"));
		return submit;
	}
	public static WebElement Calender1()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("button[title='Toggle calendar']"));
		return submit;
	}
	public static WebElement CalenderDate()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//td[@class='k-calendar-td k-focus k-today ng-star-inserted']//span"));
		return submit;
	}
	
	public static WebElement Remark()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("textarea[placeholder='Remarks']"));
		return submit;
	}	
	public static WebElement Submitt()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-blue'])[1]"));
		return submit;
	}
	public static WebElement Reject()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-blue'])[2]"));
		return submit;
	}
	public static WebElement Closebtn()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@class='figma-btn-blue'])[3]"));
		return submit;
	}
	public static WebElement PendingReviewBox()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root > div > app-layout > section > div > div > app-compliance-dashboard > div:nth-child(2) > div:nth-child(5) > div > div > div:nth-child(2) > div.min-card-count"));
		return submit;
	}
	public static WebElement RegisterUpcoming()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)"));
		return submit;
	}
	public static WebElement RegisterOverdue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2)"));
		return submit;
	}
	public static WebElement RegisterActionReview()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2)"));
		return submit;
	}
	public static WebElement ReturnUpcoming()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)"));
		return submit;
	}
	public static WebElement ReturnOverdue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2)"));
		return submit;
	}
	
	public static WebElement ReturnActionReview()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2)"));
		return submit;
	}
	public static WebElement ChallanUpcoming()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2)"));
		return submit;
	}
	public static WebElement ChallanOverdue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2)"));
		return submit;
	}
	public static WebElement ChallanActionReview()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.cssSelector("body > app-root:nth-child(1) > div:nth-child(1) > app-layout:nth-child(1) > section:nth-child(2) > div:nth-child(3) > div:nth-child(1) > app-compliance-dashboard:nth-child(3) > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2)"));
		return submit;
	}
	
	public static WebElement TotalNumberOfItems()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-pager-info[@class='k-pager-info k-label ng-star-inserted'])[1]"));
		return submit;
	}
	public static WebElement TotalNumberOfItem()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//kendo-pager-info[@class='k-pager-info k-label']"));
		return submit;
	}
	
	public static WebElement Export()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.className("exportbtn"));
		return submit;
	}
	public static WebElement Overview()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.className("svg-icon"));
		return submit;
	}
	
	public static WebElement CloseDocument()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//button[@title='Close'])[2]"));
		return submit;
	}
	
	public static WebElement SelectBranch()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[@class='k-input-value-text ng-star-inserted']"));
		return submit;
	}
	public static WebElement Period()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//input[@class='k-input-inner']"));
		return submit;
	}
	public static WebElement SelectYear()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("(//kendo-dropdownlist[@class='f-textbox k-picker-md k-rounded-md k-picker-solid k-dropdownlist k-picker'])[3]"));
		return submit;
	}
	public static WebElement SelectYearvalue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//ul[@class='k-list-ul']/li[2]"));
		return submit;
	}
	
	public static WebElement PeriodValue()	//Method for searching button for Save/Sign-in
	{
		submit = getDriver().findElement(By.xpath("//span[.='January']"));
		return submit;
	}
	
	
	
	
	
	
	
}
