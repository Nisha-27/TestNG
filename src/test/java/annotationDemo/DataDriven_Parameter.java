package annotationDemo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDriven_Parameter {
	
	
	WebDriver driver = null;
	
	@Test(priority=0)
	@Parameters({"Url"})
	public void launchURL(String url)
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
	}
	
	@Test(priority = 1)
	@Parameters({"username","password"})
	public void enterValue(String uname, String password) throws InterruptedException
	{
		
		System.out.println(uname);
		System.out.println(password);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement username = driver.findElement(By.name("username"));
		
		WebElement passWord = driver.findElement(By.name("password"));
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		passWord.click();
		username.sendKeys(uname);
		passWord.sendKeys(password);
		Thread.sleep(5000);
	}

	@Test(priority=2)
	public void teardown()
	{
		driver.close();
	}
}
