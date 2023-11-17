package extentReport;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddScreenshotToExtent {
	
	
	WebDriver driver;
	
	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void browserSetup()
	{
		
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"\\report\\extentreport" + System.currentTimeMillis() + ".html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
	}
	
	@Test(priority = 0)
	public void validateTitle()
	{
		test = extent.createTest("validate the page title").assignAuthor("abi").assignCategory("Regression").assignDevice("Chrome");
		String actualTitle = driver.getTitle();
		
		System.out.println(actualTitle);
		
		if(actualTitle.equals("Google"))
		{
			test.pass("title matched");
		}
		else
		{
			test.fail("title not matched");
		}
		
	}

	@Test(priority = 1)
	public void checkImageLink() throws IOException
	{
		
		test = extent.createTest("validation of Images link").assignAuthor("abi").assignCategory("smoke").assignDevice("Chrome");
		
		try {
		driver.findElement(By.linkText("Ima")).click();
		String title = driver.getTitle();
		}
		catch(Exception e)
		{
			test.fail("exception occured" + e.getMessage());
			
			test.addScreenCaptureFromPath(AddScreenshot());
			
		}
		
	}
	
	@AfterTest
	public void quit()
	{
		extent.flush();
		driver.close();
	}
	
	
	public String AddScreenshot() throws IOException
	{
		TakesScreenshot tks = (TakesScreenshot)driver;
		
		File temp = tks.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./screenshot_fail/google"+System.currentTimeMillis()+"png");
		
		FileUtils.copyFile(temp, dest);
		
		String path = dest.getAbsolutePath();
		
		return path;
	
	}
}
