package annotationDemo;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClass.BaseClassTest;

public class LoginUsingBasetest extends BaseClassTest {
	
	@Test
	public void LaunchURL() throws IOException, Exception
	{
		BaseClassTest base = new BaseClassTest();
		
		String url = base.launchURL();
		
		System.out.println(url);
		
		driver.get(url);
		
		Thread.sleep(10000);
	}
	
}
