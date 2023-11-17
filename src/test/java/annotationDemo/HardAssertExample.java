package annotationDemo;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertExample {

	@Test
	public void login()
	{
		if(false)
		{
			System.out.println("-------------------");
		}
		AssertJUnit.assertTrue(false);
		System.out.println("after assertion");
	}
	
	@Test
	public void home()
	{
		AssertJUnit.assertTrue(true);
		System.out.println("after assertion in home page");
	}
	
	@Test
	public void product()
	{
		SoftAssert a = new SoftAssert();
		//a.assertTrue(false);
		AssertJUnit.assertEquals(10, 11);
		a.assertAll();
		System.out.println("after assertion in product page");
		
	}
}
