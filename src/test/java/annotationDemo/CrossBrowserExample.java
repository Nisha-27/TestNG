package annotationDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserExample {

	
	WebDriver driver = null;
	
	@BeforeTest
	@Parameters({"browser"})
	public void browserSetup(String browser)
	{
		switch(browser)
		{
		case "chrome" : WebDriverManager.chromedriver().setup();
						driver = new ChromeDriver(); 
						driver.manage().window().maximize();
						break;
						
		case "edge" : WebDriverManager.edgedriver().setup();
						driver = new EdgeDriver(); 
						driver.manage().window().maximize();
						break;
		
		case "firefox" : WebDriverManager.firefoxdriver().setup();
							driver = new FirefoxDriver(); 
							driver.manage().window().maximize();
							break;
		
		case "safari" : WebDriverManager.safaridriver().setup();
					driver = new SafariDriver(); 
					driver.manage().window().maximize();
					break;
					
		default: System.out.println("provide the valid browser name"+ browser);
		}
		driver.get("https://www.google.com");}
	
	@Test(priority = 1)
	public void validateTitle()
	{
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Google");
	}
	
	@Test(priority = 2)
	public void validateURL()
	{
		driver.findElement(By.partialLinkText("Imag")).click();
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, "https://www.google.com/imghp?hl=en&ogbl");
	}
	
	@AfterTest
	public void quit()
	{
		driver.close();
	}

}
