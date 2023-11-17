package annotationDemo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributesExample {

	@Test(priority= -2, description ="test case for login page")
	public void login()
	{
		System.out.println(" in login page");
		AssertJUnit.assertTrue(false);

	}
	
	@Test(priority = -1, description ="test case for home page", dependsOnMethods = "login", alwaysRun = true)
	public void homepage()
	{
		System.out.println(" in home page");
	}
	
	@Test(priority = 0, description ="test case for product page", invocationCount=2, invocationTimeOut = 3000)
	public void productpage() throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println(" in product page");
	}
	
	@Test(priority = 1, description ="test case for cart page", enabled = false)
	public void addtocart()
	{
		System.out.println(" in cart page");
	}
	
	@Test(priority =2, timeOut = 4000)
	public void payment() throws InterruptedException
	{
		Thread.sleep(3000);
		System.out.println(" in payment page");
	}
	
	@Test(priority =3, invocationCount = 2, timeOut = 3000)
	public void search() throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println(" in payment page");
	}
	
	@Test(expectedExceptions=Exception.class)
	public void exception()
	{
		int x = 100/0;
		System.out.println("exception handled");
	}
}
