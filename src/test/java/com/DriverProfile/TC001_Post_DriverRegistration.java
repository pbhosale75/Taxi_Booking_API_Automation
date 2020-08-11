package com.DriverProfile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
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
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.users.Base.TestBase;

import Serilization.Message;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Post_DriverRegistration extends TestBase{
	//
	
	@Test(priority = 0)
	 public static void post_DriveRegi_EmptyDate() throws JsonParseException, JsonMappingException, IOException, ParseException, JSONException {
	 
	 logger.info("**************Started TC001_POST_Request__DriverRegistration Do not pass values for below fields in POST request***************");
	 Constant.read_Constant();
	 RestAssured.baseURI=Constant.driver_Registration_Post;
	 httpRequest=RestAssured.given();
	 httpRequest.header("Content-Type","application/json");
	 JSONObject request=new JSONObject();
	 request.put("firstname"," ");
	 request.put("lastname"," ");
	 request.put("emailAddress"," ");
	 //request.put("mobileNumber"," ");
	 String mob="7123456789";
	 long num = Long.parseLong(mob);
	 request.put("mobileNumber", num);
	 request.put("password"," ");
	 request.put("gender"," ");
	 httpRequest.body(request.toJSONString());
	 response=httpRequest.post(Constant.driver_Registration_Post_Resource);
	 Helper.verifiy_Response_Body();
	
	 Helper.verify_Status_Code();
	 //Helper.validate_Post_Json_ResponseBody();
	 Helper.verify_ResponseTime();
	 Helper.verify_StatusLine();
	 //Helper.verify_CreateStatusLine();
	 Helper.verify_ContentType();
	 //Helper.check_ServerType();
	// Helper.check_ContentEncoding();
	// Helper.check_Cookies();
	 Helper.verify_Date();
	}
	
	@Test(priority = 1)
	 public static void post_DriveRegi_Invalid_MobNo() throws JsonParseException, JsonMappingException, IOException, ParseException, JSONException {
	 
	 logger.info("**************Started TC001_POST_Request__DriverRegistration Invalid Mobile Number pass values for below fields in POST request***************");
	 Constant.read_Constant();
	 RestAssured.baseURI=Constant.driver_Registration_Post;
	 httpRequest=RestAssured.given();
	 httpRequest.header("Content-Type","application/json");
	 JSONObject request=new JSONObject();
	 request.put("firstname","testdriver");
	 request.put("lastname","lastdriver");
	 request.put("emailAddress","driver.test_80@gmail.com");
	 //request.put("mobileNumber"," ");
	 String mob="71234567";
	 long num = Long.parseLong(mob);
	 request.put("mobileNumber", num);
	 request.put("password","Admin@demo");
	 request.put("gender","male");
	 httpRequest.body(request.toJSONString());
	 response=httpRequest.post(Constant.driver_Registration_Post_Resource);
	 Helper.verifiy_Response_Body();
	
	 Helper.verify_Status_Code();
	 //Helper.validate_Post_Json_ResponseBody();
	 Helper.verify_ResponseTime();
	 Helper.verify_StatusLine();
	 //Helper.verify_CreateStatusLine();
	 Helper.verify_ContentType();
	 //Helper.check_ServerType();
	// Helper.check_ContentEncoding();
	// Helper.check_Cookies();
	 Helper.verify_Date();
	}
	@Test(priority = 2)
 	 public static void post_New_Users() throws JsonParseException, JsonMappingException, IOException, ParseException, JSONException {
	 
	 logger.info("**************Started TC001_POST_Request__DriverRegistration***************");
	 Constant.read_Constant();
	 RestAssured.baseURI=Constant.driver_Registration_Post;
	 httpRequest=RestAssured.given();
	 httpRequest.header("Content-Type","application/json");
	 JSONObject request=new JSONObject();
	 request.put(excel.getData("driver_POST", 1, 0),excel.getData("driver_POST", 1, 1));
	 
	 request.put(excel.getData("driver_POST", 2, 0),excel.getData("driver_POST", 2, 1));
	 request.put(excel.getData("driver_POST", 3, 0),excel.getData("driver_POST", 3, 1));
	 String mob=excel.getCellData("driver_POST", 4, 1);
	 long num = Long.parseLong(mob);
	 request.put("mobileNumber", num);
	 request.put(excel.getData("driver_POST", 5, 0),excel.getData("driver_POST", 5, 1));
	 request.put(excel.getData("driver_POST", 6, 0),excel.getData("driver_POST", 6, 1));
	 httpRequest.body(request.toJSONString());
	 response=httpRequest.post(Constant.driver_Registration_Post_Resource);
	 Helper.verifiy_Response_Body();
	 Helper.verify_Status_Code();
	 Helper.validate_Post_Json_ResponseBody();
	 Helper.verify_ResponseTime();
	 Helper.verify_StatusLine();
	 //Helper.verify_CreateStatusLine();
	 Helper.verify_ContentType();
	 Helper.verify_ServerType();
	 //Helper.verify_ContentEncoding();
	// Helper.check_Cookies();
	 Helper.verify_Date();
	}
	@AfterMethod
	  public void tearDown(ITestResult result) {
		  logger.info("***************Finished TC001_POST_Driver_Registration************************");
		  if(result.getStatus()==ITestResult.FAILURE)
		  {
			  //test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ "FAILED ", ExtentColor.RED));
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
