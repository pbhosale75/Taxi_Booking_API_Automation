package com.NotificationDetails;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
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
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.users.Base.TestBase;

import Serilization.Message;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Post_Notification_Users extends TestBase{
	@Test()
 	 public static void post_New_Users() throws JsonParseException, JsonMappingException, IOException, ParseException, JSONException {
	 
	 logger.info("**************Started TC002_POST_Request_Users_NOTIFICATION***************");
	 Constant.read_Constant();
	 RestAssured.baseURI=Constant.user_Notification_Post;
	 httpRequest=RestAssured.given();
	 httpRequest.header("Content-Type","application/json");
	 JSONObject request=new JSONObject();
	 request.put(excel.getData("Post_Req", 1, 0),excel.getData("Post_Req", 1, 1));
	 request.put(excel.getData("Post_Req", 2, 0),excel.getData("Post_Req", 2, 1));
	 request.put(excel.getCellData("Post_Req", 3, 0),excel.getCellData("Post_Req", 3, 1));
	 request.put(excel.getCellData("Post_Req", 4, 0),excel.getCellData("Post_Req", 4, 1));
	 request.put(excel.getCellData("Post_Req", 5, 0),excel.getCellData("Post_Req", 5, 1));
	 request.put(excel.getCellData("Post_Req", 6, 0),excel.getCellData("Post_Req", 6, 1));
	 httpRequest.body(request.toJSONString());
	 response=httpRequest.post(Constant.user_notification_Post_Resource);
	 Helper.verifiy_Response_Body();
	 //Helper.validate_Post_Json_ResponseBody();
	 //Helper.validate_GET_Json_ResponseBody();
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
 		logger.info("***************Finished TC002_POST_USERS_NOTIFICATION************************");
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
