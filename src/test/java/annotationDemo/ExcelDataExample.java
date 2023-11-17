package annotationDemo;

import java.io.IOException;

import baseClass.BaseClassTest;
import baseClass.MyExcelReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


public class ExcelDataExample extends BaseClassTest{

	@Test(priority = 0)
	public void geturl() throws IOException
	{
		String url = launchURL();
		driver.get(url);
		
	}
	
	@Test(dataProviderClass = MyExcelReader.class, dataProvider = "getDataFromExcel")
	public void login(String username, String Password) throws InterruptedException
	{
		
		
		WebElement userName = driver.findElement(By.id("email"));
		
		userName.clear();
		userName.sendKeys(username);
		
		WebElement pass = driver.findElement(By.id("pass"));
		pass.clear();
		pass.sendKeys(Password);
		
		Thread.sleep(5000);
		//driver.findElement(By.name("login")).click();
	}
	
}
