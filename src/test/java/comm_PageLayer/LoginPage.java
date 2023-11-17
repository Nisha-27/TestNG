package comm_PageLayer;

import java.io.IOException;

import org.openqa.selenium.By;

import baseClass.BaseClassTest;
import library.ReusableMethods;

public class LoginPage extends BaseClassTest{

	
	// Webelement
	By userName = By.id("email");
	By password = By.id("pass");
	By loginBtn = By.name("login");
	
	//methods
	
	public void getURL() throws IOException
	{
		String url = launchURL();
		driver.get(url);
	}
	
	public void enterLoginInfo()
	{
		ReusableMethods.enterValue(userName, "Admin");
		ReusableMethods.enterValue(password, "Admin123");
		ReusableMethods.Click(loginBtn);
	}
	
	
	
}
