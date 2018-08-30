package com.extentreportsdemo.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\Mr Truong\\\\Desktop\\\\selenium\\\\chromedriver_win32\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	}

	@Test
	public void buyStuff() {
		driver.get("https://myseatcovers.com/");
	}
	@Test
	public void buyStuff2() {
		driver.get("https://myseatcovers.com/");
	}

	@Test
	public void buyStuff3() {
		driver.get("https://myseatcovers.com/");
	}


	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
