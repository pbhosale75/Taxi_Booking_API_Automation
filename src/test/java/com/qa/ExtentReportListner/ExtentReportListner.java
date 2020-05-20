package com.qa.ExtentReportListner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.PassengerProfile.TC002_Post_ALL_Users;
import com.aventstack.extentreports.Status;
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
