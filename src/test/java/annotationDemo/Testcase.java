package annotationDemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import listenerDemo.MyRetryAnalyser;

public class Testcase {

	
	static WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}
	
	@Test(priority =1)
	public void login()
	{
		driver.findElement(By.id("email")).sendKeys("test");
		driver.findElement(By.id("pass")).sendKeys("test");
		Assert.assertEquals(true, true);
	}
	
	@Test(priority=2)
	public void validateTitle()
	{
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "facebook");
	}
	
	@Test(priority = 3)
	public void validateURL()
	{
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.facebook.com");
	}
	
	@AfterTest
	public void quit()
	{
		driver.close();
	}
	
	public static void takeScreenshot()
	{
		TakesScreenshot  tks = (TakesScreenshot)driver;
		
		File temp = tks.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir")+"./screenshot/facebook" + System.currentTimeMillis() + ".png");
		
		try {
			FileUtils.copyFile(temp, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
