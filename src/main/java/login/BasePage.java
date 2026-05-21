package login;


	
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.xml.datatype.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


//Cloud Fare ByPass:-----
//import java.time.Duration;
//import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v143.network.Network;
import org.openqa.selenium.devtools.v143.network.model.Headers;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import java.util.Optional;

//import org.openqa.selenium.devtools.v120.network.Network;
import businessTestCases.FilePath;
import io.github.bonigarcia.wdm.WebDriverManager;


//import org.openqa.selenium.devtools.v148.network.Network;
//import org.openqa.selenium.devtools.v148.network.model.Headers;
//import org.openqa.selenium.devtools.v147.network.Network;




	

	public class BasePage {

		
		
		
//		public static  boolean ena; 
		
		
		
		public Properties prop;
		protected static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
		String URL;
		
		public String website;
		public static ExtentReports extent;			//Instance created for report file
		public static ExtentTest test;
		public static FileInputStream fis = null;	//File input stream variable
		public static XSSFWorkbook workbook = null;	//Excel sheet workbook variable
		public static XSSFSheet sheet = null;		//Sheet variable
		private final ReadWriteLock lock;
	    protected String uname;
	    protected   String password;
	    protected String url;
	    
	    String filePath ="D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour.xlsx";
	    
		public static WebDriver getDriver() {
			return driver.get();
		}

		public static XSSFSheet ReadExcel(int no) throws IOException
		{
			//String workingDir = System.getProperty("webdriver.chrome.driver","C:/March2022/PerformerPom/Driver/chromedriver.exe");
			fis = new FileInputStream("D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\TestData\\Labour.xlsx");
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(no);					//Retrieving third sheet of Workbook
			return sheet;
		}
		
	private synchronized void loadProperties(int no) throws IOException {
		
		XSSFSheet sheet = ReadExcel(no);
		Row row0 = sheet.getRow(0);						//Selected 0th index row (First row)
		Cell c1 = row0.getCell(1);						//Selected cell (0 row,1 column)
		 URL = c1.getStringCellValue();
			/*prop = new Properties();
			try {
				FileInputStream file = new FileInputStream("D:\\LabourCompliance_m\\LabourCompliance\\LabourCompliance\\env_data\\config.properties");
				prop.load(file);
				  browser = prop.getProperty("browser");	
				  website = prop.getProperty("website");
				  
				  }
			catch(Exception e){
				e.printStackTrace();
			}*/
		}
		

		
	
	
	public  BasePage() {
		   // this.filePath = filePath;
		    this.lock = new ReentrantReadWriteLock();
		}
	
	public String read_Login_url(int no) throws IOException {
		  lock.readLock().lock();
	    try {
	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(no);
	        Row row1 = sheet.getRow(0);
	        Cell c1 = row1.getCell(1);
	         url = c1.getStringCellValue();
	         
	        workbook.close();
	        fis.close();
	        return url;
	        
	    }
	    
	    finally {
	        lock.readLock().unlock();
	    }

	}

	
	public String read_Login_username(int no) throws IOException {
		  lock.readLock().lock();
	    try {
	        FileInputStream fis = new FileInputStream(filePath);
	        Workbook workbook = WorkbookFactory.create(fis);
	        Sheet sheet = workbook.getSheetAt(no);
	        Row row1 = sheet.getRow(1);
	        Cell c1 = row1.getCell(1);
	         uname = c1.getStringCellValue();
	        workbook.close();
	        fis.close();
	        return uname;
	    }
	    
	    finally {
	        lock.readLock().unlock();
	    }

	}

	public String read_Login_password(int no) throws IOException {
		  lock.readLock().lock();
	  try {
	      FileInputStream fis = new FileInputStream(filePath);
	      Workbook workbook = WorkbookFactory.create(fis);
	      Sheet sheet = workbook.getSheetAt(no);
	      Row row2 = sheet.getRow(2);
	      Cell c2 = row2.getCell(1);
	       password = c2.getStringCellValue();
	      workbook.close();
	      fis.close();
	      return password;
	  }
	  
	  finally {
	      lock.readLock().unlock();
	  }
	}
	
	public void Initialization(String link,int no,String text) throws InterruptedException, IOException {
		try {
		//loadProperties(no);
//		openBrower1(no);
		openBrower5(no);
		
		}catch(Exception e) {
			e.printStackTrace();
		}

		read_Login_username(no);
		read_Login_password(no);
		
		
		LoginMethods.Userlogin(uname,password);		//Method of Login class to login user.
			
	}
	public String browser= "chrome";	
	private void openBrower5(int no) throws IOException {

		if (browser.contains("chrome")) {
//					System.setProperty("webdriver.chrome.driver", "D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\chromedriver.exe");
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\bilali\\.cache\\selenium\\chromedriver\\win64\\148.0.7778.178\\chromedriver.exe");
					
					//WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--remote-allow-origins=*");
					driver.set(new ChromeDriver(options));		
			}
		
				else {
					System.out.println("please select valid browser");
				}
	
			getDriver().manage().window().maximize();
			getDriver().manage().deleteAllCookies();
//			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
//			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			//getDriver().get(url);
			read_Login_url(no);
			getDriver().get(url);
			
//			DesiredCapabilities cap = new DesiredCapabilities();

	 }
	
	
	private void openBrower1(int no) throws IOException, InterruptedException {
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\bilali\\.cache\\selenium\\chromedriver\\win64\\148.0.7778.178\\chromedriver.exe");
	    
	    
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    ChromeDriver chromeDriver = new ChromeDriver(options);
	    driver.set(chromeDriver);
	    
	    // ================= CDP HEADER INJECTION =================
	    DevTools devTools = chromeDriver.getDevTools();
	    devTools.createSession();
	    
	    devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
	    
	    Map<String, Object> headersMap = new HashMap<>();
	    headersMap.put("X-QA-Secret", "qa_9Fh38dkS93Jdk39DksLwP02xA");
	    
	    Headers headers = new Headers(headersMap);
	    devTools.send(Network.setExtraHTTPHeaders(headers));
	    
	    // ========================================================

	    getDriver().manage().window().maximize();
	    getDriver().manage().deleteAllCookies();

	    read_Login_url(no); // ensure this sets 'url'
	    getDriver().get(url);
	}
	
	
//		private void openBrower1(int no) throws IOException {
//
//		System.setProperty("webdriver.chrome.driver","D:\\Regtrack2.O-main\\chromedriver1.exe");
//
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//
//		ChromeDriver chromeDriver = new ChromeDriver(options);
//		driver.set(chromeDriver);
//
//		// :white_check_mark: FIRST: Read URL from Excel
//		read_Login_url(no);
//
//		// :white_check_mark: Enable network
//		chromeDriver.executeCdpCommand("Network.enable", new HashMap<>());
//
//		// :white_check_mark: Set Cloudflare header
//		Map<String, Object> headersMap = new HashMap<>();
//		headersMap.put("X-QA-Secret", "qa_9Fh38dkS93Jdk39DksLwP02xA");
//
//		Map<String, Object> params = new HashMap<>();
//		params.put("headers", headersMap);
//
//		chromeDriver.executeCdpCommand("Network.setExtraHTTPHeaders", params);
//
//		// :white_check_mark: THEN open URL
//		getDriver().get(url);
//
//		getDriver().manage().window().maximize();
//		}
	
	
	public void initialization(String link,int no,String text) throws InterruptedException, IOException {
		try {
		//loadProperties(no);
//		openBrower1(no);
		openBrower5(no);
		
		}catch(Exception e) {
			e.printStackTrace();
		}

		read_Login_username(no);
		read_Login_password(no);
		
		
		LoginMethods.UserLogin(uname,password);		//Method of Login class to login user.
			
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	

	
	
	
	
	
	
	
	
	
	
	

	
	
	public void initializationSDExecutor(String link,int no,String text) throws InterruptedException, IOException {
		try {
		//loadProperties(no);
		openBrower1(no);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		

		
		read_Login_username(no);
		read_Login_password(no);
		
		
		LoginMethods.UserLoginSDExecutor(uname,password,"SD");		//Method of Login class to login user.
		
		
		
		

	}
	public void initialization2(String link,int no,String text) throws InterruptedException, IOException {
		try {
		//loadProperties(no);
		openBrower1(no);
		
		}catch(Exception e) {
			e.printStackTrace();
		}

		read_Login_username(no);
		read_Login_password(no);
		
		
		LoginMethods.UserLogin2(uname,password);		//Method of Login class to login user.
			
	}
	
	
	

	public void closeBrowser() {
		getDriver().quit();
		driver.remove();
	}
	}


