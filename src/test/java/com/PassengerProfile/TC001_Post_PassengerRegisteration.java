package com.PassengerProfile;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.RestUtility.Constant;
import com.RestUtility.Helper;
import com.users.Base.TestBase;

import io.restassured.RestAssured;

public class TC001_Post_PassengerRegisteration extends TestBase{
  @Test
  public void post_PassengerRegi_EmptyData() throws JSONException {
	  	logger.info("**************Started TC001_POST_Request__PassengerRegistration Do not pass values for below fields in POST request***************");
		 Constant.read_Constant();
		 RestAssured.baseURI=Constant.passenger_Registration_Post;
		 httpRequest=RestAssured.given();
		 httpRequest.header("Content-Type","application/json");
		 JSONObject request=new JSONObject();
		 request.put("passengerFirstName"," ");
		 request.put("passengerLastName"," ");
		 request.put("emailAddress"," ");
		 //request.put("mobileNumber"," ");
		 String mob="7123456789";
		 long num = Long.parseLong(mob);
		 request.put("mobileNumber", num);
		 request.put("password"," ");
		 request.put("gender"," ");
		 httpRequest.body(request.toJSONString());
		 response=httpRequest.post(Constant.passenger_Registration_Post_Resource);
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
		
	  
  }
