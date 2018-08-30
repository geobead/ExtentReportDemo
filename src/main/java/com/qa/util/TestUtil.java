package com.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static String takeScreenShot() throws IOException {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String screenShotFilePath = currentDir + "/screenshots/" + System.currentTimeMillis() + ".png";
		FileUtils.copyFile(scrFile, new File(screenShotFilePath));
		return screenShotFilePath;
	}
}
