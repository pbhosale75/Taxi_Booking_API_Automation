package Serilization;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import groovy.transform.Sortable;
import io.restassured.http.ContentType;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageObject implements Serializable,Cloneable{
  @Test
  public void verify_Message() throws JsonParseException, JsonMappingException, IOException, ParseException {
	  MessageInfo msgInfo=new MessageInfo();
	  msgInfo.setEmail("UserInfo3@gmail.com");
	  msgInfo.setPhone("7123445568");
	  msgInfo.setAddress("Las Wages");
	  Message m=new Message();
	  m.setFirstname("Pravin");
	  m.setLastname("Salunke");
	  m.setSubjectID("3");
	  m.setID("3");
	  m.setMessageInfo(msgInfo);
	  
	  Response response=given().
	  body(m).
	  when().
	  contentType(ContentType.JSON).
	  post("http://localhost:3000/users");
	  System.out.println("Message Response for Post Request :"+response.asString());
	  /*String Fname = response.jsonPath().getString("firstname");
	  Assert.assertEquals(Fname, "bushan");*/
	  
	  String messageResponse=given().
				  queryParam("users").
				  when().get("http://localhost:3000/users").
				  then().
				  log().all().extract().response().asString();
				  System.out.println("Message Details Response="+messageResponse);
				  JsonPath js=new JsonPath(messageResponse);
	 /*Message mc=given().expect().defaultParser(Parser.JSON)
			 .when()
			 .get("http://localhost:3000/users").as(Message.class);
	 		System.out.println(mc.getFirstname());*/
	 		
				  
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
				  
				 for(Message user : userArray) {
					  
				      System.out.println("Users First Name= "+user.getFirstname());
				      System.out.println("Users Last Name= "+user.getLastname());
				      System.out.println("Users Subject ID= "+user.getSubjectID());
				      System.out.println("Users ID= "+user.getID());
				      System.out.println(msgInfo.getEmail());
				  }
				  
				  
  }
}
