package extentReport;

import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsExample {
	
	ExtentSparkReporter spark;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void start()
	{
		// directory where output is to be printed
		spark = new ExtentSparkReporter(System.getProperty("user.dir")+"\\report\\extentreport.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);

	}
	
	@Test
	public  void signIn()
	{
	test = extent.createTest("user is on signing page");
	test.log(Status.PASS, "sign in page got passed");
	}
	
	@Test
	public void Homepage()
	{
		test = extent.createTest("user is on home page").assignAuthor("abi").assignCategory("smoke").assignDevice("chrome");
		test.pass("home page successful");
	}
	
	@Test
	public void productpage()
	{
		test = extent.createTest("user is on product page").assignAuthor("nisha").assignCategory("Regression").assignDevice("chrome");
		test.fail("product page failed");
	}
	
	@AfterTest
	public void quit()
	{
		extent.flush();
	}

}
