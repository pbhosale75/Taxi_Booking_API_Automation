package com.PassengerProfile;

import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import com.RestUtility.Constant;
import com.RestUtility.Helper;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.users.Base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TC001_Get_List_Users extends TestBase {
 
  @Test()
  public static void getList_Users() throws InterruptedException {
	  
	  logger.info("**************Started TC001_Get_List_Users***************");
	  //test=extent.createTest("getAll_Users");
	  //test.log(Status.INFO, "GET API For USERS");
	  //test.log(Status.PASS, "GET API For USERS Verified");
	  
	  Constant.read_Constant();
	  RestAssured.baseURI=Constant.user_List;
	  httpRequest=RestAssured.given();
	  response=httpRequest.request(Method.GET);
	  Thread.sleep(3000);
	  Helper.CheckResponse_Body();
	  Helper.response_Code();
	  Helper.check_StatusLine();
	  Helper.check_ContentType();
	  Helper.check_ServerType();
	  Helper.check_ContentEncoding();
	  Helper.check_ContentLength();
	  //Helper.check_Cookies();
	  Helper.check_Date();
	  
  }
  @AfterMethod
  public void tearDown(ITestResult result) {
	  logger.info("***************Finished TC001_GET_List_USERS************************");
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ "FAILED ", ExtentColor.RED));
		  //test.log(Status.FAIL, "TEST CASE FAILED IS" +result.getName());//To name in extent report
		  test.log(Status.FAIL, "TEST CASE FAILED IS" +result.getThrowable());//To Add Exception/Error in Extent Report
	  }
	  else if(result.getStatus()==ITestResult.SKIP) {
		  test.log(Status.SKIP, "TEST CASE SKIPED IS" +result.getName());
	  }
	  
	  else if(result.getStatus()==ITestResult.SUCCESS) {
		  test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
		  test.log(Status.PASS, "TEST CASE PASSED IS " +result.getName());
		  //test.log(Status.PASS, "TEST CASE IS PASSED " +result.getStatus()+ "Status Name", ExtentColor.ORANGE);
		  test.log(Status.INFO, "My Test Cases Get Info " +result.getStatus());
	  }
	  
  }
  @AfterTest
  void endReport() {
	  extent.flush();
  }


 
  
}
