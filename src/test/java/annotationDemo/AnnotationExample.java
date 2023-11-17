package annotationDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationExample {
  @Test
  public void test1() {
	  System.out.println(" in test 1");
  }
  @Test
  public void test2() {
	  System.out.println(" in test 2");
  }
  @Test
  public void test3() {
	  System.out.println(" in test 3");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println(" before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println(" after method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println(" before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println(" after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println(" beofre test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println(" after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println(" before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("after suite");
  }

}
