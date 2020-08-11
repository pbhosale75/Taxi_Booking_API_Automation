package com.NotificationDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestUtility.Constant;
import com.RestUtility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.qa.ExtentReportListner.ExtentReportListner;
import com.relevantcodes.extentreports.LogStatus;
import com.users.Base.TestBase;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.IOException;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC006_Get_One_Notification_Details extends TestBase{
	
	//public static Response response;
   // public static String jsonAsString;
   // public static String  UserID;
   // public static String notificationID;
    @Test
	    public static void callRidesAPI() throws JSONException, InterruptedException, JsonParseException, JsonMappingException, IOException, ParseException
	    {
	        // call the rides API, the full address is "http://yourwebsiteaddress.com/api/yourapi/rides",
	        // but we set the default above, so just need "/rides"
	    	logger.info("**************Started TC004_Get_One_UserNotification_Detials***************");
	        // here we setup the default URL and API base path to use throughout the tests
	    	Constant.read_Constant();
	  	  	RestAssured.baseURI=Constant.user_Notification_Get;
	  	  	httpRequest=RestAssured.given();
	  	  	response=httpRequest.request(Method.GET,Constant.user_Notification_Get_Resource);
	  	  
	  	  	Thread.sleep(3000);
	  	  	Helper.verifiy_Response_Body();
	  	  	Helper.validate_GET_Json_ResponseBody();
	  	  	Helper.verify_Status_Code();
	  	  	Helper.verify_StatusLine();
	  	  	Helper.verify_ContentType();
	  	  //Helper.verify_ServerType();
	  	  //Helper.check_ContentEncoding();
	  	  //Helper.verify_ContentLength();
	  	  //Helper.check_Cookies();
	  	  	Helper.verify_Date();
	    }
	  	  
 @Test
  public static void retrieveNotificationDetails() throws InterruptedException, JsonParseException, JsonMappingException, IOException, ParseException, JSONException {
	 	Thread.sleep(3000);
	  	Helper.verifiy_Response_Body();
	  	//Helper.getJson_Body();
	  	
	  	Constant.read_Constant();
	  	String Uid =Helper.UserID;
	  	String notification_ID=Helper.NotificationID;
	  	System.out.println("User ID="+Uid);
	  	RestAssured.baseURI=Constant.get_one_notification;
	  	httpRequest=RestAssured.given();
	  	httpRequest.basePath(Constant.get_one_notification__Resource);
	  
	  	httpRequest.pathParam("userID",Uid);
	  	httpRequest.pathParam("notificationId", notification_ID);
	  //	response=httpRequest.request(Method.GET,"/{userID}/{notificationId}");
	  	response=httpRequest.get("/{userID}/{notificationId}");
          						
 
      System.out.println("Response :" + response.asString());
      System.out.println("Status Code :" + response.getStatusCode());
      
      //System.out.println("Does Reponse contains 'employee_salary'? :" + response.asString().contains("employee_salary"));

      Assert.assertEquals(200, response.getStatusCode());
  }
 
 
 
}