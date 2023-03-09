package baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	public static WebDriver driver;	
	
	
	@BeforeSuite
	public void initializeDriver() throws IOException{
		Properties prop= new Properties();
		FileInputStream file= new FileInputStream("D:\\Selenium\\Selenium Projects\\POMFramework\\src\\main\\java\\data.properties");
		prop.load(file);
		String browsername = prop.getProperty("browser");
		
		
		
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
			System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium Jar files\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			// execute in chrome browser
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/");
	}
	
	
	
	

}
