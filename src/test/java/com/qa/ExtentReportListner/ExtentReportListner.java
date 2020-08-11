package com.qa.ExtentReportListner;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.PassengerProfile.TC002_Post_ALL_Users;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.users.Base.TestBase;

public class ExtentReportListner implements ITestListener{
	protected static ExtentReports reports;
	 protected static ExtentTest test;
	 @BeforeClass
	 public static void startTest()
	 {
	 reports = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\TAXI_BOOKING_API.html");
	 test = reports.startTest("ExtentDemo");
	 }
	 public void onTestStart(ITestResult result) {
		  System.out.println("on test start");
		  
		  test.log(LogStatus.INFO, result.getMethod().getMethodName() + "test is started");
		 }
		 public void onTestSuccess(ITestResult result) {
		  System.out.println("on test success");
		  test.log(LogStatus.PASS, result.getMethod().getMethodName());
		  test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed");
		 }
		 public void onTestFailure(ITestResult result) {
		  System.out.println("on test failure");
		  test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
		  
		   test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed");
		   test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", result.getThrowable().getMessage());
		  } 
		 public void onTestSkipped(ITestResult result) {
		  System.out.println("on test skipped");
		  test.log(LogStatus.SKIP, result.getMethod().getMethodName() + "test is skipped");
		 }
		 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		  System.out.println("on test sucess within percentage");
		 }
		 public void onStart(ITestContext context) {
		  System.out.println("on start");
		  
		 }
		 public void onFinish(ITestContext context) {
		  System.out.println("on finish");
		  
		 // extent.endTest(test);
		 // reports.endTest(test);
		  //reports.flush();
		 }

}
