package baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Loggers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	public static WebDriver driver;	
	public Logger log= LogManager.getLogger(Baseclass.class);
	public SoftAssert softAssert= new SoftAssert();
	
	@BeforeSuite
	@Parameters("url")
	public void initializeDriver(@Optional String url) throws IOException{
		try {
		Properties prop= new Properties();
		FileInputStream file= new FileInputStream("D:\\Selenium\\Selenium Projects\\POMFramework\\src\\main\\java\\data.properties");
		prop.load(file);
		String browsername =prop.getProperty("browser");
		
		
		
		if (browsername.equals("chrome")) {	
		//System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium Jar files\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(options);
				
		// execute in chrome browser
		}
		else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Software\\Selenium Jar files\\geckodriver-v0.32.2-win-aarch64\\geckodriver.exe");
			driver= new FirefoxDriver();
			// execute in firefox browser
		}
		else {
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			driver= new ChromeDriver();
			// execute in chrome browser
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		}
		catch(NullPointerException e){
			System.out.println("");
		}
		catch(NoSuchElementException e) {
			System.out.println("");
		}
		catch(TimeoutException e) {
			System.out.println("");
		}
		catch(ElementNotInteractableException e) {
			System.out.println("");
		}
		catch(StaleElementReferenceException e) {
			System.out.println("");
		}
		
	}
	
	@AfterClass
	public void Closebrowser() {
		try {
			driver.close();
		}
			catch(Exception e) {
				log.info("Closing the Browser");
			}
		}
	
	
	public void softAssert() {
		try {
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void log() {
		// TODO Auto-generated method stubs
		
	}
	
	
	
	

}
