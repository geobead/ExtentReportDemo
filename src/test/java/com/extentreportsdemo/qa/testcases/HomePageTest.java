package com.extentreportsdemo.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class HomePageTest extends TestBase{

	@BeforeMethod
	public void setUp() {
		initialization();
	}

	@Test(priority=1, description="first test")
	public void buyStuff() {
		driver.get("https://myseatcovers.com/");
	}
	@Test(priority=2, description="second test")
	public void buyStuff2() {
		driver.get("https://myseatcovers.com/");
	}
	
	@Test(priority=3, description="this test is intended to fail to take screen shot", expectedExceptions = ArithmeticException.class)
	public void buyStuff3() {
		driver.get("https://myseatcovers.com/");
	}

	@Test(priority=4, description="second test")
	public void buyStuff4() {
		driver.get("https://myseatcovers.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
