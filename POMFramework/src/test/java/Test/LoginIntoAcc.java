package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseclass.Baseclass;
import objrepo.LoginPage;

public class LoginIntoAcc extends Baseclass {
	
	//@BeforeClass
	//LoginPage l= new LoginPage(driver);

	
	
	@Test
	public void LoginIntoAccount () throws InterruptedException  {
		LoginPage l= new LoginPage(driver);
		//l.LoginPageNavigation();
		l.login("Barath", "123456");
		
	}
}
