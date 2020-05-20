package com.RestUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Constant {
	public static String user_List="";
	public static String user_Single="";
	
	
	public static void read_Constant()
	{
		try {
			FileInputStream fis=new FileInputStream("D://Core_Java//TAXI_BOOKING_RestAssured//src//test//java//Properties//Object.properties");
			Properties pro=new Properties();
			pro.load(fis);
			user_List=pro.getProperty("list_User");
			user_Single=pro.getProperty("single_User");
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
