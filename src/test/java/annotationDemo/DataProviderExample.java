package annotationDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderExample {
	
WebDriver driver = null;
	
	@Test(priority=0, dataProvider ="provdingData")
	public void launchURL(String url) throws InterruptedException
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 1, dataProvider="data")
	public void enterValue(String uname, String password)
	{
		
		System.out.println(uname);
		System.out.println(password);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement username = driver.findElement(By.name("username"));
		
		
		
		WebElement passWord = driver.findElement(By.name("password"));
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		username.clear();
		passWord.click(); 
		
		passWord.clear();
		username.sendKeys(uname);
		passWord.sendKeys(password);
	}

	@Test(priority=2, enabled = false)
	public void teardown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
	
	@DataProvider
	public Object[] provdingData()
	{
		Object[] arr = {"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"};
		return arr;
	}
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] tarr = { {"xxxx", "123"} , 
							{"yyy", "365"} , 
							{"Admin", "admin123"} };
	
	return tarr;
	
	}

}
