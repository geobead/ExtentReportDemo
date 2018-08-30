package com.qa.reports;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.qa.util.TestUtil;

public class ExtentTestNGITestListener implements ITestListener{

	private static ExtentReports extent = ExtentManager.createInstance();
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
    @Override
	public synchronized void onStart(ITestContext context) {
    	System.out.println("Extent Reports Version 3 Test Suite started!");
    	ExtentTest parent = extent.createTest(getClass().getName());
        parentTest.set(parent);
	}

	@Override
	public synchronized void onFinish(ITestContext context) {
		System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
		extent.flush();
	}
	
	@Override
	public synchronized void onTestStart(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " started!"));
		ExtentTest child = parentTest.get().createNode(result.getMethod().getMethodName());
        test.set(child);
	}

	@Override
	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " passed!"));
		test.get().pass("Test passed");
	}

	@Override
	public synchronized void onTestFailure(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " failed!"));
		test.get().fail(result.getThrowable());
		
        try {
        	String screenShotFilePath = TestUtil.takeScreenShot();
        	// log with snapshot (timestamped failure log entry with screenshot instead of text message)
        	test.get().fail("details", MediaEntityBuilder.createScreenCaptureFromPath(screenShotFilePath).build());
        	// test with snapshot (attaches screenshot)
			test.get().addScreenCaptureFromPath(screenShotFilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println((result.getMethod().getMethodName() + " skipped!"));
		test.get().skip(result.getThrowable());
	}

	@Override
	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
}

