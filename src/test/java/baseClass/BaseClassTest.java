package baseClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import comm_PageLayer.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassTest {
	
	public static WebDriver driver = null;
	
	public static LoginPage login = new LoginPage();
	
	@BeforeTest
	public static WebDriver setUp() throws IOException
	{
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\config.properties");
		
		FileReader fr = new FileReader(file);
		
		Properties prop = new Properties();
		
		prop.load(fr);
		
		if(prop.getProperty("browser").equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			
		}
		
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			
		}
		
		return driver;
	}
	
	
	public static String launchURL() throws IOException
	{
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\configFiles\\config.properties");
		
		FileReader fr = new FileReader(file);
		
		Properties prop = new Properties();
		
		prop.load(fr);
		
		return (prop.getProperty("URL"));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
