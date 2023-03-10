package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.Baseclass;
import objrepo.HomePage;
import objrepo.LoginPage;

public class LoginIntoAcc extends Baseclass {
	
	//@BeforeClass
	//LoginPage l= new LoginPage(driver);

	
	
	@Test(priority=0)
	public void verifyLoginfuntionality () throws InterruptedException  {
		LoginPage l= new LoginPage(driver);
		//l.LoginPageNavigation();
		String Name=l.login("Barath", "123456");
		softAssert.assertEquals(Name, "Welcome Barath");
		Assert.assertEquals(Name,"Welcome Barath");
		System.out.println("login successful");
		
		softAssert.assertAll();
		
	}
	
	@Test(priority=1)
	public void verifyProduct() {
		HomePage h= new HomePage(driver);
		h.PhoneList();
		}
		
	
	
}
