package com.DriverProfile;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.RestUtility.Constant;
import com.RestUtility.Helper;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.users.Base.TestBase;

import io.restassured.RestAssured;

public class TC002_Post_DriverVerify extends TestBase {
  @Test(priority = 0)
  public static void post_drierVerify_EmptyData() throws JSONException {
	  	logger.info("**************Started TC002_POST_Request__DriverVerify Do not pass values for below fields in POST request***************");
	  	Constant.read_Constant();
		 RestAssured.baseURI=Constant.post_DriverVerify;
		 httpRequest=RestAssured.given();
		 httpRequest.header("Content-Type","application/json");
		 JSONObject request=new JSONObject();
		 request.put("username"," ");
		 request.put("password", " ");
		 httpRequest.body(request.toJSONString());
		 response=httpRequest.post(Constant.post_DriverVerify_Resources);
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
  public static void post_drierVerify_Invalid_UNM_PWD() throws JSONException {
	  logger.info("**************Started TC002_POST_Request__DriverVerify Do not pass values for below fields in POST request***************");
	  	Constant.read_Constant();
		 RestAssured.baseURI=Constant.post_DriverVerify;
		 httpRequest=RestAssured.given();
		 httpRequest.header("Content-Type","application/json");
		 JSONObject request=new JSONObject();
		 request.put("username","driver.test_89@gmail.com");
		 request.put("password", "Admin@demo89");
		 httpRequest.body(request.toJSONString());
		 response=httpRequest.post(Constant.post_DriverVerify_Resources);
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
  public static void post_drierVerify_Valid_UNM_PWD() throws JSONException, ParseException {
	  logger.info("**************Started TC002_POST_Request__DriverVerify Do  pass Valid values for below fields in POST request***************");
	  	Constant.read_Constant();
		 RestAssured.baseURI=Constant.post_DriverVerify;
		 httpRequest=RestAssured.given();
		 httpRequest.header("Content-Type","application/json");
		 JSONObject request=new JSONObject();
		 request.put(excel.getData("driver_verify_Post", 1, 0),excel.getData("driver_verify_Post", 1, 1));
		 request.put(excel.getData("driver_verify_Post", 2, 0),excel.getData("driver_verify_Post", 2, 1));
		 httpRequest.body(request.toJSONString());
		 response=httpRequest.post(Constant.post_DriverVerify_Resources);
		 Helper.verifiy_Response_Body();
		
		 Helper.verify_Status_Code();
		 Helper.validate_Post_Json_ResponseBody();
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
	  logger.info("***************Finished TC002_POST_Driver_Verify************************");
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
