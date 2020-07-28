package com.DriverDetails;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Post_ALL_Users extends TestBase{
	@Test()
 	 public static void post_New_Users() {
	 
	 logger.info("**************Started TC002_POST_Request_ALL_Users***************");
	 RestAssured.baseURI=excel.getData("Post_Req", 1,0);
	 httpRequest=RestAssured.given();
	 httpRequest.header("Content-Type","application/json");
	 JSONObject request=new JSONObject();
	 request.put(excel.getData("Post_Req", 1, 2),excel.getData("Post_Req", 1, 3));
	 request.put(excel.getData("Post_Req", 2, 2),excel.getData("Post_Req", 2, 3));
	 request.put(excel.getCellData("Post_Req", 3, 2),excel.getCellData("Post_Req", 3, 3));
	 request.put(excel.getCellData("Post_Req", 4, 2),excel.getCellData("Post_Req", 4, 3));
	 httpRequest.body(request.toJSONString());
	 response=httpRequest.post(excel.getData("Post_Req", 1, 1));
	 
	 
	 Helper.verifiy_Response_Body();
	 Helper.validate_Post_Json_ResponseBody();
	 Helper.verify_Status_Code();
	 Helper.verify_ResponseTime();
	 Helper.verify_StatusLine();
	 //Helper.verify_CreateStatusLine();
	 Helper.verify_ContentType();
	 //Helper.check_ServerType();
	// Helper.check_ContentEncoding();
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
