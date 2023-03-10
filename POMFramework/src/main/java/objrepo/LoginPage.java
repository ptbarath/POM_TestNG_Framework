package objrepo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseclass.Baseclass;

public class LoginPage extends Baseclass {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}		
	


	@FindBy (id="login2")
	private WebElement Loginbutton;
	
	@FindBy (xpath="//a[@class='btn btn-black navbar-btn']")
	private WebElement Registerbutton;
	
	@FindBy (id="loginusername")
	private WebElement loginusername;
	
	@FindBy (id="loginpassword")
	private WebElement loginpassword;
	
	@FindBy (xpath="//button[@onclick='logIn()']")
	private WebElement Loginsubmitbutton;
	
	@FindBy (xpath="//a[text()='Welcome Barath']")
	private WebElement NameoftheUser;

		
	
	public String login(String username, String password) throws InterruptedException  {
		Loginbutton.click();
		log.info("Click don Login button");
		
		Thread.sleep(2000);
		loginusername.sendKeys(username);
		log.info("Entered Username");
		
		loginpassword.sendKeys(password);
		log.info("Entered Password");
		
		Loginsubmitbutton.click();
		log.info("Clicked on Submit button");
		Thread.sleep(5000);
		
	
		String Name=NameoftheUser.getText();		
		
		return Name;
	}
	

	
}
