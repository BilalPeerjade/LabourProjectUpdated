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
		openBrower1(no);
		
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
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\bilali\\.cache\\selenium\\chromedriver\\win64\\144.0.7559.96\\chromedriver.exe");
					//WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--remote-allow-origins=*");
					driver.set(new ChromeDriver(options));		
			}
		
		if (browser.contains("chrome_secret")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Labour Angular\\LabourMergeProject\\LabourMergeProject\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-blink-features=AutomationControlled");//
			options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});//
			options.setExperimentalOption("useAutomationExtension", false);//
			options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");//
			
			options.addArguments("--remote-allow-origins=*");
			driver.set(new ChromeDriver(options));		
	}
		
		
		if (browser.contains("edge")) {
		    System.setProperty("webdriver.edge.driver", "C:\\Users\\bilali\\Desktop\\Automation Downloads\\msedgedriver.exe");
		    EdgeOptions options = new EdgeOptions();

		    // Selenium 3 me arguments aise set hote hain
		    options.setCapability("ms:edgeOptions", new HashMap<String, Object>() {{
		        put("args", Arrays.asList("--remote-allow-origins=*"));
		    }});
		    driver.set(new EdgeDriver(options));
		}
		
		
		
		//Taken after deep research
        if (browser.toLowerCase().contains("chromeUUUUU")) {

            System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\bilali\\.cache\\selenium\\chromedriver\\win64\\144.0.7559.96\\chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--start-maximized");

            ChromeDriver chromeDriver = new ChromeDriver(options);

            // 🔥 DEVTOOLS MAGIC STARTS HERE
            DevTools devTools = chromeDriver.getDevTools();
            devTools.createSession();

//            devTools.send(Network.enable(
//                    Optional.empty(),
//                    Optional.empty(),
//                    Optional.empty()
//            ));
            devTools.send(Network.enable(
		            Optional.empty(),
		            Optional.empty(),
		            Optional.empty(),
		            Optional.empty(),
		            Optional.empty()
		    ));
            

            Map<String, Object> headers = new HashMap<String, Object>();
//          headers.put("X-QA-Secret", "qa_9Fh38dkS93Jdk39DksLwP02xA");
            headers.put("X-QA-Secret", "qa_9Fh38dkS93Jdk39DksLwP02xA");
            

            devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
            // 🔥 HEADER INJECTED BEFORE ANY NAVIGATION

            driver.set(chromeDriver);
        }
        
        if (browser.toLowerCase().contains("chromeTTTTTTT")) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bilali\\.cache\\selenium\\chromedriver\\win64\\144.0.7559.96\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        ChromeDriver driver = new ChromeDriver(options);

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Enable Network so we can set headers
//        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.enable(
	            Optional.empty(),
	            Optional.empty(),
	            Optional.empty(),
	            Optional.empty(),
	            Optional.empty()
	    ));

        Map<String, Object> extraHeaders = new HashMap<>();
        extraHeaders.put("X-QA-Secret", "qa_9Fh38dkS93Jdk39DksLwP02xA");
        devTools.send(Network.setExtraHTTPHeaders(new Headers(extraHeaders)));

        // Remove known automation flag
        driver.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined});");

//        return driver;
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
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\bilali\\.cache\\selenium\\chromedriver\\win64\\144.0.7559.96\\chromedriver.exe");
	    
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
	
	
	public void initialization(String link,int no,String text) throws InterruptedException, IOException {
		try {
		//loadProperties(no);
		openBrower1(no);
		
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


