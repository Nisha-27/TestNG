package listenerDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import annotationDemo.Testcase;

public class MyITestListener extends Testcase implements ITestListener{

	public void onTestSuccess(ITestResult result) {
	    
		System.out.println(" test success");
	  }
	
	public void onTestFailure(ITestResult result) {
		
		takeScreenshot();
		
		System.out.println(" test case failed");
	  }
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("test case skipped");
	  }
	
	public void onStart(ITestContext context)  // entire script
	{
		System.out.println(" on start");
	  }
	
	public void onTestStart(ITestResult result)  // particular
	{
		System.out.println(" on test started");	  
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("test completed");
	  }
}
