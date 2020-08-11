package com.RestUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Constant {
	public static String user_Notification_Get="";
	public static String user_Notification_Get_Resource="";
	public static String user_Notification_Post="";
	public static String user_notification_Post_Resource="";
	public static String get_one_notification="";
	public static String get_one_notification__Resource="";
	public static String driver_Registration_Post=" ";
	public static String driver_Registration_Post_Resource=" ";
	public static String post_DriverVerify=" ";
	public static String post_DriverVerify_Resources=" ";
	
	public static void read_Constant()
	{
		try {
			
			
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Properties\\Object.properties");
			Properties pro=new Properties();
			pro.load(fis);
			user_Notification_Get=pro.getProperty("get_notification_User");
			user_Notification_Get_Resource=pro.getProperty("get_notification_User_Resouces");
			user_Notification_Post=pro.getProperty("post_notification_User");
			user_notification_Post_Resource=pro.getProperty("post_notification_User_Resource");
			get_one_notification=pro.getProperty("get_one_notification_User");
			get_one_notification__Resource=pro.getProperty("get_one_notification_User_Resource");
			driver_Registration_Post=pro.getProperty("post_DriverRegistration");
			driver_Registration_Post_Resource=pro.getProperty("post_DriverRegistration_Resources");
			post_DriverVerify=pro.getProperty("post_DriverVerify");
			post_DriverVerify_Resources=pro.getProperty("post_DriverVerify_Resources");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
