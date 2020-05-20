package com.RestUtility;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.users.Base.TestBase;

import io.restassured.path.json.JsonPath;

public class Helper extends TestBase{
  @Test
  public static void CheckResponse_Body() {
	  logger.info("**************Checking Response Body**************");
	  test=extent.createTest("CheckResponse_Body");
	  extent.getStartedReporters().add(reporter);
	  String response_Body=response.getBody().asString();
	  logger.info("Response Body==>"+response_Body);
	  test.createNode(response_Body);
	  Assert.assertTrue(response_Body!=null);
	  //validating Response Body
	  JsonPath jsonPathEvaluator = response.jsonPath();
	  //List allValue=jsonPathEvaluator.getList(response_Body);
	  String firstName = jsonPathEvaluator.get("firstname");
	  Assert.assertTrue(firstName.equalsIgnoreCase("prakash"));
	  test.createNode(firstName);
	  String lastname = jsonPathEvaluator.get("lastname");
	  Assert.assertTrue(lastname.equalsIgnoreCase("bhosale"));
	  test.createNode(lastname);
	  String subjectID = jsonPathEvaluator.get("subjectID");
	  Assert.assertTrue(subjectID.equalsIgnoreCase("1"));
	  test.createNode(subjectID);
	 
	  
	  if(response_Body.contains("eve.holt@reqres.in")) {
		  System.out.println("Response Body valid");
		  //test=extent.createTest("Check Response Body", "Response Body valid");
	  }
	 
	  //Assert.assertEquals(response_Body.contains(Fname), true);
	  //Assert.assertEquals(response_Body.contains(Lname), true);
	 // Assert.assertEquals(response_Body.contains(SubID), true);
  }
 @Test
  public static void response_Code() {
	  logger.info("**************Checking Status Code**************");
	  //test=extent.createTest("checkStatus_Code");
	  int status_Code=response.getStatusCode();
	  logger.info("Status Code==>"+status_Code);
	  //String succus_Status=String.format("%d", status_Code);
	  //test.createNode(succus_Status);
	  String str1=String.valueOf(status_Code);
	  test.createNode(str1);
	  if(status_Code==200) {
		  System.out.println("200 for OK with Body (Updated response)");
		  test=extent.createTest("checkStatus_Code");
		  String str=String.valueOf(status_Code);
		  test.createNode(str);
		  Assert.assertEquals(status_Code, 200);
		 
	  }
	  else if(status_Code==201)
	  {
		  System.out.println("201 for OK (but no content) ");
		  test=extent.createTest("checkStatus_Code", "201 for OK (but no content)");
		  String str=String.valueOf(status_Code);
		  test.createNode(str);
		  Assert.assertEquals(status_Code, 201);
	  }
	  else if(status_Code==404)
	  {
		  System.out.println("Not Found");
		  test=extent.createTest("checkStatus_Code", "Not Found");
		  String str=String.valueOf(status_Code);
		  test.createNode(str);
		  Assert.assertEquals(status_Code, 404);
	  }  
  }

  @Test
  public static void checkResponseTime() {
	  logger.info("**************Checking Response Time**************");
	  test=extent.createTest("checkResponseTime");
	  long responseTime=response.getTime();
	  logger.info("Response Time==>"+responseTime);
	  String restime_Status=Long.toString(responseTime);
	  test.createNode(restime_Status);
	  //test.createNode(responseTime);
	  if(responseTime>=2000)
	  {
		  logger.warn("Response time is Gretter than 2000");
		  Assert.assertTrue(responseTime<3000);
		  
	  }
  }
  @Test
  public static void check_StatusLine() {
	  logger.info("**************Checking Status Line**************");
	  test=extent.createTest("check_StatusLine");
	  String status_Line=response.getStatusLine();
	  logger.info("Status line==>"+status_Line);
	  Assert.assertEquals(status_Line, "HTTP/1.1 200 OK");
	  test.createNode(status_Line);
	  
	  
  }
  @Test
  public static void check_CreateStatusLine() {
	  logger.info("**************check_CreateStatusLine**************");
	  test=extent.createTest("check_CreateStatusLine");
	  String create_status_Line=response.getStatusLine();
	  logger.info("Status line==>"+create_status_Line);
	  Assert.assertEquals(create_status_Line, "HTTP/1.1 201 Created");
	  //test=extent.createTest("check_CreateStatusLine", "HTTP/1.1 201 Created");
	  test.createNode(create_status_Line);
	  
  }
  
  @Test
  public static void check_ContentType() {
	  logger.info("**************Checking Content Type**************");
	  test=extent.createTest("check_ContentType");
	  String contentType=response.header("Content-Type");
	  logger.info("Content Type==>"+contentType);
	  Assert.assertEquals(contentType, "application/json; charset=utf-8");
	  test.createNode(contentType);
	 
  }
  @Test
  public static void check_ServerType() {
	  logger.info("**************Checking Server Type**************");
	  test=extent.createTest("check_ServerType");
	  String serverType=response.header("Server");
	  logger.info("ServerType==>"+serverType);
	  Assert.assertEquals(serverType, "cloudflare");
	  test.createNode(serverType);
	  
  }
  @Test
  public static void check_ContentEncoding() {
	  logger.info("**************Checking Server Type**************");
	  test=extent.createTest("check_ContentEncoding");
	  String contentEncoding=response.header("Content-Encoding");
	  logger.info("ContentEncoding==>"+contentEncoding);
	  Assert.assertEquals(contentEncoding, "gzip");
	  test.createNode(contentEncoding);
	  
  }
  @Test
  public static void check_ContentLength() {
	  logger.info("**************Checking Server Type**************");
	  test=extent.createTest("check_ContentLength");
	  String contentLength=response.header("Content-Length");
	  logger.info("ContentLength==>"+contentLength);
		
		 if(Integer.parseInt(contentLength)<100)
		 logger.warn("Content Length is Less than 100");
		  Assert.assertTrue(Integer.parseInt(contentLength)>100);
		  test.createNode(contentLength);
		  
	  //Assert.assertEquals(contentLength, "Content-Length");
	  
	  
  }
 @Test
  public static void check_Cookies() {
	  logger.info("**************Checking Server Cookies**************");
	  test=extent.createTest("check_Cookies");
	  String cookies=response.getCookie("PHPSESSID");
	  logger.info("Server Cookies==>"+cookies);
	  Assert.assertEquals(cookies, "gzip");
	  test.createNode(cookies);
  }
  @Test
  public static void check_Date() {
	  logger.info("**************Checking Server Date Time**************");
	  test=extent.createTest("check_Date");
	  long date_Time=response.getTime();
	  logger.info("Server Response Time==>"+date_Time);
	  String date_Status=Long.toString(date_Time);
	  test.createNode(date_Status);
	  //Assert.assertEquals(cookies, "gzip");
  }
}
