package com.RestUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Constant {
	public static String user_Notification_Get="";
	public static String user_Notification_Get_Resource="";
	public static String user_Notification_Post="";
	public static String user_notification_Post_Resource="";
	
	
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
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
