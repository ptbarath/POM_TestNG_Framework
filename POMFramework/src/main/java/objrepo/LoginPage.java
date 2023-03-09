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

		
	
	public void login(String username, String password) throws InterruptedException  {
		Loginbutton.click();
		Thread.sleep(3000);
		loginusername.sendKeys(username);
		loginpassword.sendKeys(password);
		Loginsubmitbutton.click();
		
	}
	
}
