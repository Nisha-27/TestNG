package library;

import org.openqa.selenium.By;

import baseClass.BaseClassTest;

public class ReusableMethods extends BaseClassTest{
	
	public static void enterValue(By WebElement, String value)
	{
		driver.findElement(WebElement).sendKeys(value);
	}
	
	public static void Click( By WebElement)
	{
		driver.findElement(WebElement).click();
		
		
	}

	// getTitle //getURL
	
	public static void teardown()
	{
		driver.close();
	}
	
}
