package Serialization_Data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.RestUtility.Constant;
import com.RestUtility.Helper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.users.Base.TestBase;

import groovy.transform.Sortable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MessageObject extends TestBase implements Serializable,Cloneable{
  @Test
  public static void verify_Message() throws JsonParseException, JsonMappingException, IOException, ParseException {
	  Message m=new Message();
	  //m.setUserId(excel.getData(sheetname, row, column));
	  m.setNotificationId("NavoTest");
	  m.setNotificationStatus("True");
	  m.setShortDesc("Thursday short123 notification");
	  m.setLongDesc("Thursday long notification");
	  m.setCreatedBy("PrakashBhosale");
	  
	  Response response=given().
			  body(m).
			  when().
			  contentType(ContentType.JSON).
			  post("http://localhost:8088/api/notification");
			  System.out.println("Message Response for Post Request :"+response.asString());
			  /*String Fname = response.jsonPath().getString("firstname");
			  Assert.assertEquals(Fname, "bushan");*/
	 
	 /* String messageResponse=given().
			  queryParam("users").
			  when().get("http://localhost:8088/api/notification/NavoTest").
			  then().
			  log().all().extract().response().asString();
			  System.out.println("Message Details Response="+messageResponse);
			  JsonPath js=new JsonPath(messageResponse);
				  Gson gson = new Gson(); 
				  
				  Message[] userArray = gson.fromJson(messageResponse, Message[].class);  
				  int user_Count=userArray.length;
				  System.out.println("Number of User Records ="+user_Count);
				  
				  
				 //Logic for Parsing Json with Json Path Class
				  
				/*  for(int i=0;i<user_Count;i++) {
					  String Fname = js.getString("["+i+"].firstname");
					 // System.out.println(Fname);
					  if(Fname=="Prakash"){
							 Assert.assertEquals(Fname, "Prakash");
							 System.out.println(Fname);
						  }
				      String Lname = js.getString("["+i+"].lastname");
				      String SubID=js.getString("["+i+"].subjectID");
				  }*/
				  
				  //Json Parsing Using PoJO Class
				  
				 /*for(Message user : userArray) {
					  
					  String UserID=user.getUserId();
				      System.out.println("Users UserID= "+user.getUserId());
				      System.out.println("Users Notification= "+user.getNotificationId());
				      System.out.println("Users NotificationStatus= "+user.getNotificationStatus());
				      System.out.println("Users Short Discription= "+user.getShortDesc());
				      System.out.println("Users Long Discription="+user.getLongDesc());
				      System.out.println("Users CreatedBY="+user.getCreatedBy());
				      Assert.assertEquals(UserID,"UserABC");
				  }*/
				  
			}
}
