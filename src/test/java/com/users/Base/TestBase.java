package com.users.Base;

import org.testng.annotations.Test;

import com.RestUtility.ExcelDataConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Serilization.Message;
import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class TestBase {
	public static RequestSpecification httpRequest;
	public static Response response;
	//public String empID="51838";
	public static Logger logger;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter reporter;
	
	public static ExcelDataConfig excel = new ExcelDataConfig(System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\API_List (1).xlsx");
	
	
  
  @BeforeClass
  public void setup() {
	  logger=Logger.getLogger("UsersRestAPI");
	  PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\java\\Properties\\Log4j.properties");
	  logger.setLevel(Level.DEBUG);
	  reporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\Reports\\TAXI_BOOKING_API.html");
	  
	  reporter.config().setDocumentTitle("Rest API Automation Report");
	  reporter.config().setReportName("API Report");
	  reporter.config().setTheme(Theme.STANDARD);
	  extent = new ExtentReports();
	  extent.attachReporter(reporter);
	  
}
  
 
}
