package com.NotificationDetails;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.RestUtility.Constant;
import com.RestUtility.ExcelDataConfig;
import com.RestUtility.Helper;
import com.aventstack.extentreports.Status;
import com.users.Base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_PATCH_Notification_Users extends TC002_Post_Notification_Users{
	@Test()
 	 public static void put_New_Users() {
	 logger.info("**************Started TC003_PUT_Request_ALL_Users***************");
	  Constant.read_Constant();
	  RestAssured.baseURI=Constant.user_Notification_Post;
	  RequestSpecification httpRequest=RestAssured.given();
	  httpRequest.header("Content-Type","application/json");
	  JSONObject requstParam=new JSONObject();
	  requstParam.put(excel.getData("Patch_Req", 1, 0),excel.getData("Patch_Req", 1, 1));
	  requstParam.put(excel.getData("Patch_Req", 2, 0),excel.getData("Patch_Req", 2, 1));
	  requstParam.put(excel.getCellData("Patch_Req", 3, 0),excel.getCellData("Patch_Req", 3, 1));
	  requstParam.put(excel.getCellData("Patch_Req", 4, 0),excel.getCellData("Patch_Req", 4, 1));
	  requstParam.put(excel.getCellData("Patch_Req", 5, 0),excel.getCellData("Patch_Req", 5, 1));
	  requstParam.put(excel.getCellData("Patch_Req", 6, 0),excel.getCellData("Patch_Req", 6, 1));
	  httpRequest.body(requstParam.toJSONString());
	  response=httpRequest.patch(Constant.user_notification_Post_Resource);
	  Helper.verifiy_Response_Body();
	  //Assert.assertEquals(response_Body.contains(Fname), true);
	  //Assert.assertEquals(response_Body.contains(Lname), true);
	  //Assert.assertEquals(response_Body.contains(SubID), true);
	  Helper.verify_Status_Code();
	  Helper.verify_ResponseTime();
	  Helper.verify_StatusLine();
	  Helper.verify_ContentType();
	  //Helper.check_ServerType();
	  //Helper.check_ContentEncoding();
	 // Helper.check_Cookies();
	  Helper.verify_Date();
 }
 		@AfterMethod
 		  public void tearDown(ITestResult result) {
 			  logger.info("***************Finished TC001_GET_ALL_USERS************************");
 			  if(result.getStatus()==ITestResult.FAILURE)
 			  {
 				  test.log(Status.FAIL, "TEST CASE FAILED IS" +result.getName());//To name in extent report
 				  test.log(Status.FAIL, "TEST CASE FAILED IS" +result.getThrowable());//To Add Exception/Error in Extent Report
 			  }
 			  else if(result.getStatus()==ITestResult.SKIP) {
 				  test.log(Status.SKIP, "TEST CASE SKIPED IS" +result.getName());
 			  }
 			  else if(result.getStatus()==ITestResult.SUCCESS) {
 				  test.log(Status.PASS, "TEST CASE PASSED IS" +result.getName());
 				  test.log(Status.PASS, "TEST CASE IS PASSED" +result.getStatus());
 			  }
 			  
 		  }
 		  @AfterTest
 		  void endReport() {
 			  extent.flush();
 		  }


 }
