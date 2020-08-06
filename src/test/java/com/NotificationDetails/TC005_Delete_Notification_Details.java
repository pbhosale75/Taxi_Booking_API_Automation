package com.NotificationDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.RestUtility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.ExtentReportListner.ExtentReportListner;
import com.relevantcodes.extentreports.LogStatus;
import com.users.Base.TestBase;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TC005_Delete_Notification_Details extends TestBase{
	
	public static Response response;
    public static String jsonAsString;
    public static String  UserID;
    public static String notificationID;
   
	 @BeforeClass
	    public static void setupURL()
	    {
		 logger.info("**************Started TC005_Delete_Users_Notification***************");
	        // here we setup the default URL and API base path to use throughout the tests
	        RestAssured.baseURI = "http://localhost:8088";
	        RestAssured.basePath = "/api/notification/";
	        
	    }

	    @Test
	    public static void callNotificationAPI() throws JSONException
	    {
	        // call the rides API, the full address is "http://yourwebsiteaddress.com/api/yourapi/rides",
	        // but we set the default above, so just need "/rides"
	        response =
	            when().
	                get("/Admin123").
	            then().
	                contentType(ContentType.JSON).  // check that the content type return from the API is JSON
	            extract().response(); // extract the response

	        // We convert the JSON response to a string, and save it in a variable called 'jsonAsString'
	        jsonAsString = response.asString();
	    
	        
	        JSONArray jsonArray = new JSONArray(jsonAsString);

            for(int i=0;i<jsonArray.length();i++)
            {
                org.json.JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                UserID = jsonObject1.optString("userId");
                System.out.println("User ID ="+UserID);
                notificationID=jsonObject1.optString("notificationId");
                System.out.println("Notification ID =" +notificationID);
            }
	        
	    }
 @Test
  public static void deleteNotificationDetails() {
	  String Uid =UserID;
	  String notification_ID=notificationID;
	  System.out.println("User ID="+Uid);
	  RestAssured.baseURI = "http://localhost:8088";

      Response response = null;

      try {
          response = RestAssured.given()
        		  				.basePath("/api/notification")
                                .pathParam("userID",Uid)
                                .pathParam("notificationId", notification_ID)
                                .when()
                                .delete("/{userID}/{notificationId}/delete");
                                //.get("/{userID}/{notificationId}","/delete/");
                                
          						
      } catch (Exception e) {
          e.printStackTrace();
      }

      System.out.println("Response for Dalete Request:" + response.asString());
      System.out.println("Status Code :" + response.getStatusCode());
      //System.out.println("Does Reponse contains 'employee_salary'? :" + response.asString().contains("employee_salary"));

      Assert.assertEquals(200, response.getStatusCode());
  }
 @AfterMethod
 public void tearDown(ITestResult result) {
	  logger.info("***************Finished TC001_GET_List_USERS************************");
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  //test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ "FAILED ", ExtentColor.RED));
		  test.log(Status.FAIL, "TEST CASE FAILED IS" +result.getName());//To name in extent report
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
	  //extent.flush();
 }
	
	@AfterTest
	  void endReport() {
		  
		  extent.flush();
		  }
 


}


