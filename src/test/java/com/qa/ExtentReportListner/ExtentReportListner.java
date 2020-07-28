package com.qa.ExtentReportListner;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.PassengerProfile.TC002_Post_ALL_Users;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;
import com.users.Base.TestBase;

public class ExtentReportListner extends TestBase implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase Started is :"+result.getName()); 
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase Succeses is :"+result.getName()); 
		//logger = extent.createTest(passTest);
		 Assert.assertTrue(true);
		 //To generate the log when the test case is passed
		 logger.getLogger("Test Pass");
		 
		// logger.log(LogStatus.PASS, "Test Case Passed is passTest");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase Failed is :"+result.getName()); 
		//TC001_Get_List_Users.tearDown(result);
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase Skipped is :"+result.getName()); 
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase Started is :"+context.getName()); 
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase Finished is :"+context.getName()); 
		
	}
}
