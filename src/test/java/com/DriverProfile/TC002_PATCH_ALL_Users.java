package com.DriverProfile;

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

import com.RestUtility.ExcelDataConfig;
import com.RestUtility.Helper;
import com.aventstack.extentreports.Status;
import com.users.Base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_PATCH_ALL_Users extends TestBase{
	@Test(dataProvider = "userdataprovider")
 	 public static void post_New_Users(String Lname) {
	 logger.info("**************Started TC003_PUT_Request_ALL_Users***************");
	  RestAssured.baseURI="http://localhost:3000/users";
	  RequestSpecification httpRequest=RestAssured.given();
	  JSONObject requstParam=new JSONObject();
	  
	  requstParam.put("lastname", Lname);
	
	  
	  httpRequest.header("Content-Type","application/json");
	  httpRequest.body(requstParam.toJSONString());
	  response=httpRequest.request(Method.PATCH,"/3");
	  Helper.CheckResponse_Body();
	  //Assert.assertEquals(response_Body.contains(Fname), true);
	  //Assert.assertEquals(response_Body.contains(Lname), true);
	  //Assert.assertEquals(response_Body.contains(SubID), true);
	  Helper.response_Code();
	  Helper.checkResponseTime();
	  Helper.check_StatusLine();
	  Helper.check_ContentType();
	  //Helper.check_ServerType();
	  //Helper.check_ContentEncoding();
	 // Helper.check_Cookies();
	  Helper.check_Date();
 }
 		@DataProvider(name="userdataprovider")
 		String [][] getUsersData()
 		{
 			
 			String userData[][]= {{"Pawar"}};
 			return(userData);
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
