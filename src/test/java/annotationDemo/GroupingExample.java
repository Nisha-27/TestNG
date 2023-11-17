package annotationDemo;

import org.testng.annotations.*;

public class GroupingExample {

	
	@Test(groups = "Regression")
	public void m1()
	{
		System.out.println(" in method 1");
	}
	
	@Test(groups = {"sanity", "smoke"})
	public void m2()
	{
		System.out.println(" in method 2");
	}
	
	@Test(groups = "Regression")
	public void m3()
	{
		System.out.println(" in method 3");
	}
	
	
	@Test(groups = {"Regression", "sanity"})
	public void m4()
	{
		System.out.println(" in method 4");
	}
	
	@Test(groups = "smoke")
	public void m5()
	{
		System.out.println(" in method 5");
	}
	
	@Test(groups = {"Regression", "smoke"})
	public void m6()
	{
		System.out.println(" in method 6");
	}
	
	@Test(groups = "sanity")
	public void m7()
	{
		System.out.println(" in method 7");
	}
}
