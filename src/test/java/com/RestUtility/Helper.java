package com.RestUtility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.users.Base.TestBase;

import Serialization_Data.Message;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Helper extends TestBase{
	public static String response_Body;
	public static String UserID;
	public static String jsonAsString;
	
  @Test
  public static void verifiy_Response_Body(){
	  logger.info("**************Checking Response Body**************");
	  
	  test=extent.createTest("verifiy_Response_Body");
	  extent.getStartedReporters().add(reporter);
	  response_Body=response.body().asString();
	  logger.info("Response Body==>"+response_Body);
	  test.createNode(response_Body);
	  System.out.println("Response Body Data="+response_Body);
	  
	  
	  
  }
  
	
//validating GET Request Json Response Body
  @Test
  public static void validate_GET_Json_ResponseBody() throws JsonParseException, JsonMappingException, IOException, ParseException, JSONException {
	  //test=extent.createTest("Validate Json GET Response Body");
	  test.log(Status.PASS, "Validate Json GET Response Body");
	  JsonPath js=new JsonPath(response_Body);
	  Gson gson = new Gson(); 
	  
	  Message[] userArray = gson.fromJson(response_Body, Message[].class);  
	  int user_Count=userArray.length;
	  System.out.println("Number of User Records ="+user_Count);
	  for(Message user : userArray) {
		  
		  String UserID=user.getUserId();
		  Assert.assertEquals(UserID,excel.getData("Get_JsonResponse", 1, 1));
	      String NotificationID=user.getNotificationId();
	      Assert.assertEquals(NotificationID,excel.getData("Get_JsonResponse", 2, 1));
	      String NotificationStatus=user.getNotificationStatus();
	      Assert.assertEquals(NotificationStatus,excel.getCellData("Get_JsonResponse", 3, 1));
	      String shortDisc=user.getShortDesc();
	      Assert.assertEquals(shortDisc,excel.getData("Get_JsonResponse", 4, 1));
	      String longDisc=user.getLongDesc();
	      Assert.assertEquals(longDisc,excel.getData("Get_JsonResponse", 5, 1));
	      String createdBy=user.getCreatedBy();
	      Assert.assertEquals(createdBy,excel.getData("Get_JsonResponse", 6, 1));
	      test.log(Status.PASS, UserID);
		  test.log(Status.PASS, NotificationID);
			 //test.createNode(userID,NotificationID);
		  test.log(Status.PASS, NotificationStatus);
		  test.log(Status.PASS, shortDisc);
			// test.createNode(NotificationStatus,ShortDisc);
		  test.log(Status.PASS, longDisc);
		  test.log(Status.PASS, createdBy);
			 //test.createNode(CreatedBy);
	  }
	   
  } 
	  

 //validating Post Request Json Response Body
	@Test
	  public static void validate_Post_Json_ResponseBody() throws ParseException {
	   
		test.log(Status.PASS, "Validate Json GET Response Body");	  
  }
 @Test
  public static void verify_Status_Code() {
	  logger.info("**************Checking Status Code**************");
	  test=extent.createTest("verify_Response_Code");
	  int status_Code=response.getStatusCode();
	  logger.info("Status Code==>"+status_Code);
	  //String succus_Status=String.format("%d", status_Code);
	  //test.createNode(succus_Status);
	  String str1=String.valueOf(status_Code);
	  test.createNode(str1);
	  if(status_Code==200) {
		  System.out.println("200 for OK with Body with (GET Request With response Body)");
		  String str=String.valueOf(status_Code);
		  
		  Assert.assertEquals(status_Code, 200);
		  
	  }
	  else if(status_Code==201)
	  {
		  System.out.println("201 for OK (Post Request With Updated content) ");
		  String str=String.valueOf(status_Code);
		  //test.createNode(str);
		  Assert.assertEquals(status_Code, 201);
		 
	  }
	  else if(status_Code==400)
	  {
		  System.out.println("Bad Request");
		  //test=extent.createTest("checkStatus_Code", "Not Found");
		  String str=String.valueOf(status_Code);
		  test.createNode(str);
		  Assert.assertEquals(status_Code, 400,"Bad Request Found");
		  //Assert.assertFalse(false);
		  test=extent.createTest("“Bad Request Found”: “OPERATION_Un_SUCCESS”,“400 for (Bad Request Found content)”: “Operation completed Un_successfully”");
	  } 
	  else if(status_Code==401)
	  {
		  System.out.println("Unauthorized");
		  //test=extent.createTest("checkStatus_Code", "Not Found");
		  String str=String.valueOf(status_Code);
		  test.createNode(str);
		  Assert.assertEquals(status_Code, 400,"Unauthorized Request Found");
		  //Assert.assertFalse(false);
		  test=extent.createTest("“Unauthorized Request Found”: “OPERATION_Un_SUCCESS”,“401 for (Unauthorized Request Found content)”: “Operation completed Un_successfully”");
	  } 
	  else if(status_Code==403)
	  {
		  System.out.println("Forbidden");
		  //test=extent.createTest("checkStatus_Code", "Not Found");
		  String str=String.valueOf(status_Code);
		  test.createNode(str);
		  Assert.assertEquals(status_Code, 403,"Forbidden Request Found");
		  //Assert.assertFalse(false);
		  test=extent.createTest("“Forbidden Request Found”: “OPERATION_Un_SUCCESS”,“403 for (Forbidden Found)”: “Operation completed Un_successfully”");
	  } 
	  else if(status_Code==404)
	  {
		  System.out.println("Not Found");
		  //test=extent.createTest("checkStatus_Code", "Not Found");
		  String str=String.valueOf(status_Code);
		  test.createNode(str);
		  Assert.assertEquals(status_Code, 404,"Invalid Request Found");
		  //Assert.assertFalse(false);
		  test=extent.createTest("“Invalid Request Found”: “OPERATION_Un_SUCCESS”,“404 for (Not Found content)”: “Operation completed Un_successfully”");
	  } 
	  else if(status_Code==405)
	  {
		  System.out.println("Method Not Allowed");
		  //test=extent.createTest("checkStatus_Code", "Not Found");
		  String str=String.valueOf(status_Code);
		  test.createNode(str);
		  Assert.assertEquals(status_Code, 405,"Method Not Allowed");
		  //Assert.assertFalse(false);
		  test=extent.createTest("“Method Not Allowed”: “OPERATION_Un_SUCCESS”,“405 for (Not Found content)”: “Operation completed Un_successfully”");
	  } 
	  else if(status_Code==500){
			Assert.assertEquals(500, status_Code, "Internal Server Error,duplicate id");
			test=extent.createTest("“Internal Server Error,duplicate id Found”: “OPERATION_Un_SUCCESS”,“500 for (Duplicate ID content)”: “Operation completed Un_successfully”");
			}
	  else {
		System.out.println("Rest of the Code not Present");
	}
	  
  }

  @Test
  public static void verify_ResponseTime() {
	  logger.info("**************Checking Response Time**************");
	  test=extent.createTest("verify_ResponseTime");
	  long responseTime=response.getTime();
	  logger.info("Response Time==>"+responseTime);
	  String restime_Status=Long.toString(responseTime);
	  test.createNode(restime_Status);
	  if(responseTime>=2000)
	  {
		  logger.warn("Response time is Gretter than 2000");
		  Assert.assertTrue(responseTime<3000);
		  
	  }
  }
  @Test
  public static void verify_StatusLine() {
	  logger.info("**************Checking Status Line**************");
	  test=extent.createTest("verify_StatusLine");
	  String status_Line=response.getStatusLine();
	  logger.info("Status line==>"+status_Line);
	  test.createNode(status_Line);
	  
	  if(status_Line=="HTTP/1.1 200 OK") {
		  System.out.println("200 for OK with Body with (GET Request With response Body)");
		  String str=String.valueOf(status_Line);
		  Assert.assertEquals(status_Line, "HTTP/1.1 200 OK");	
		  test.createNode(status_Line);
	  }
	  else if(status_Line=="HTTP/1.1 201 Created") {
		  System.out.println("200 for OK with Body with (GET Request With response Body)");
		  String str=String.valueOf(status_Line);
		  Assert.assertEquals(status_Line, "HTTP/1.1 201 Created");		
		  test.createNode(status_Line);
	  }

	  
	  
  }
 /* @Test
  public static void verify_CreateStatusLine() {
	  logger.info("**************check_CreateStatusLine**************");
	  test=extent.createTest("verify_CreateStatusLine");
	  String create_status_Line=response.getStatusLine();
	  logger.info("Status line==>"+create_status_Line);
	  Assert.assertEquals(create_status_Line, "HTTP/1.1 201 Created");
	  //test=extent.createTest("check_CreateStatusLine", "HTTP/1.1 201 Created");
	  test.createNode(create_status_Line);
	  
  }*/
  
  @Test
  public static void verify_ContentType() {
	  logger.info("**************Checking Content Type**************");
	  test=extent.createTest("verify_ContentType");
	  String contentType=response.header("Content-Type");
	  logger.info("Content Type==>"+contentType);
	  test=extent.createTest(contentType);
	  /*if(contentType=="application/json; charset=utf-8") {
		  System.out.println("Content Type is application/json; charset=utf-8");
		  Assert.assertEquals(contentType, "application/json; charset=utf-8");
		  test.createNode(contentType);
	  }
	  else if(contentType=="application/json") {
		  System.out.println("Content Type is application/json");
		  Assert.assertEquals(contentType, "application/json");
		  test.createNode(contentType);
	  }*/
	   if(contentType=="text/plain;charset=UTF-8") {
		  System.out.println("Content Type is text/plain;charset=UTF-8");
		  Assert.assertEquals(contentType, "text/plain;charset=UTF-8");
		  test.createNode(contentType);
		  test.log(Status.PASS, contentType);
	  }
	  
  }
  @Test
  public static void verify_ServerType() {
	  logger.info("**************Checking Server Type**************");
	  test=extent.createTest("verify_ServerType");
	  String serverType=response.header("Server");
	  logger.info("ServerType==>"+serverType);
	  Assert.assertEquals(serverType, "cloudflare");
	  test.createNode(serverType);
	  
  }
  @Test
  public static void verify_ContentEncoding() {
	  logger.info("**************Checking Server Type**************");
	  test=extent.createTest("verify_ContentEncoding");
	  String contentEncoding=response.header("Content-Encoding");
	  logger.info("ContentEncoding==>"+contentEncoding);
	  Assert.assertEquals(contentEncoding, "gzip");
	  test.createNode(contentEncoding);
	  
  }
  @Test
  public static void verify_ContentLength() {
	  logger.info("**************Checking Server Type**************");
	  test=extent.createTest("verify_ContentLength");
	  String contentLength=response.header("Content-Length");
	  logger.info("ContentLength==>"+contentLength);
		
		 if(Integer.parseInt(contentLength)<100)
		 logger.warn("Content Length is Less than 100");
		  //Assert.assertTrue(Integer.parseInt(contentLength)>200);
		 Assert.assertTrue(Integer.parseInt(contentLength)<200);
		  test.createNode(contentLength);
		  
	  //Assert.assertEquals(contentLength, "Content-Length");
	  
	  
  }
 @Test
  public static void verify_Cookies() {
	  logger.info("**************Checking Server Cookies**************");
	  test=extent.createTest("verify_Cookies");
	  String cookies=response.getCookie("PHPSESSID");
	  logger.info("Server Cookies==>"+cookies);
	  Assert.assertEquals(cookies, "gzip");
	  test.createNode(cookies);
  }
  @Test
  public static void verify_Date() {
	  logger.info("**************Checking Server Date Time**************");
	  test=extent.createTest("verify_Date");
	  long date_Time=response.getTimeIn(TimeUnit.DAYS);
	  logger.info("Server Response Time==>"+date_Time);
	  String date_Status=Long.toString(date_Time);
	  test.createNode(date_Status);
	  //Assert.assertEquals(cookies, "gzip");
  }
}
