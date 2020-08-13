package Serilization_DriverDetails;

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
import com.users.Base.TestBase;

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
public class DriverObject extends TestBase implements Serializable,Cloneable{
  @Test
  public void verify_Message() throws JsonParseException, JsonMappingException, IOException, ParseException {
	  
	  DriverDetials d=new DriverDetials();
	  d.setFirstname(excel.getData("driver_Post", 1, 1));
	  d.setLastname(excel.getData("driver_Post", 2, 1));
	  d.setEmailAddress(excel.getData("driver_Post", 3, 1));
	  //d.setMobileNumber(excel.getCellData("driver_Post", 4, 1));
	  String mob=excel.getCellData("driver_POST", 4, 1);
	  long num = Long.parseLong(mob);
	  d.setMobileNumber(num);
	  d.setPassword(excel.getData("driver_Post", 5, 1));
	  d.setGender(excel.getData("driver_Post", 6, 1));
	  
	  Response response=given().
	  body(d).
	  when().
	  contentType(ContentType.JSON).
	  post("http://localhost:8082/api/DriverProfile/DriverRegistration");
	  System.out.println("Message Response for Post Request :"+response.asString());
	  String DriverID = response.jsonPath().getString("driverId");
	  //Assert.assertEquals(DriverID, "67ce37c9-08b2-4516-a119-0d982e9d1ed7");
	  
	  String messageResponse=given().
			  	   baseUri("http://localhost:8082/").
			  	   basePath("/api/DriverProfile/GetDriverById/").
				  //queryParam("users").
			  	  pathParam("driverID",DriverID).
				  when().get("/{driverID}").
				  then().
				  log().all().extract().response().asString();
				  System.out.println("Message Details Response="+messageResponse);
				  JsonPath js=new JsonPath(messageResponse);
				  //Post Data Validation with excel Data
				 String Fname=js.getString("firstname");
				 Assert.assertEquals(Fname,excel.getData("driver_Post_ValidationData", 2, 1));
				 String Lname=js.getString("lastname");
				 Assert.assertEquals(Lname, excel.getData("driver_Post_ValidationData", 3, 1));
				 String email=js.getString("emailAddress");
				 Assert.assertEquals(email, excel.getData("driver_Post_ValidationData", 4, 1));
				 String MNumber=js.getString("mobileNumber");
				 Assert.assertEquals(MNumber, excel.getCellData("driver_Post_ValidationData", 5, 1));
				 String Gen=js.getString("gender");
				 Assert.assertEquals(Gen, excel.getData("driver_Post_ValidationData", 6, 1));
				 String VehType=js.getString("vehicleType");
				 Assert.assertEquals(VehType, excel.getData("driver_Post_ValidationData", 7, 1));
				 String PIN=js.getString("locationPinCode");
				 Assert.assertEquals(PIN, excel.getCellData("driver_Post_ValidationData", 8, 1));
				 String VehAvil=js.getString("vehicleAvailablity");
				 Assert.assertEquals(VehAvil, excel.getData("driver_Post_ValidationData", 9, 1));
				 String VehReg=js.getString("vehicleRegNumber");
				 Assert.assertEquals(VehReg, excel.getData("driver_Post_ValidationData", 10, 1));
	     /*DriverDetials mc=given().expect().defaultParser(Parser.JSON)
			 .when()
			 .get("http://localhost:3000/users").as(DriverDetials.class);
	 		System.out.println(mc.getFirstname());*/
	 		
				  
				  //Gson gson = new Gson(); 
				  
				 // Message[] userArray = gson.fromJson(messageResponse, Message[].class);  
				  //int user_Count=userArray.length;
				  //System.out.println("Number of User Records ="+user_Count);
				  
				  
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
				  
				/* for(Message user : userArray) {
					  
				      System.out.println("Users First Name= "+user.getFirstname());
				      System.out.println("Users Last Name= "+user.getLastname());
				      System.out.println("Users Subject ID= "+user.getSubjectID());
				      System.out.println("Users ID= "+user.getID());
				      System.out.println(msgInfo.getEmail());
				  }*/
				  
				  
  }
}
