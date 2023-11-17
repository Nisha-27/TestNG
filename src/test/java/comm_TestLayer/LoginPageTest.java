package comm_TestLayer;

import java.io.IOException;

import org.testng.annotations.*;

import baseClass.BaseClassTest;

public class LoginPageTest extends BaseClassTest{

	
	// test - Assertion and validation
	
	@Test
	public void loginPageTest() throws IOException
	{
		login.getURL();
		login.enterLoginInfo();
		
	}
}
