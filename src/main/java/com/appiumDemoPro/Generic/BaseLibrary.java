package com.appiumDemoPro.Generic;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseLibrary {
	public  DesiredCapabilities cap=null;
	public static AndroidDriver<MobileElement> driver; 
	public static ExtentReports extent;
	ExtentTest logger;
	
	@BeforeClass
	public void reportGrenerator(){

		 extent=new ExtentReports("./test-output/advancereport.html");
	   	logger=extent.startTest("ByjusTest");
		 extent.loadConfig(new File("./test-output/extent-config.xml"));		
	}
		
	@BeforeMethod
	public void launchApp() throws Exception{

		DesiredCapabilities des=new DesiredCapabilities();
		des.setCapability("automationName",Constantlib.automationName);
		des.setCapability("platformName",Constantlib.platformName);
		des.setCapability( "platformVersion",Constantlib.platformVersion);
		des.setCapability( "deviceName",Constantlib.deviceName);
		des.setCapability("appActivity",Constantlib.appActivity);
		des.setCapability("appPackage",Constantlib.appPackage);

		
		System.out.println("Execution started");
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),des);
		 Thread.sleep(7000);
	
	}
	
		
	@AfterMethod
	
	public void cleanConfig(){
		System.out.println("i am closing app");
		
		driver.closeApp();
		
	}
	
	@AfterClass
	
	public void closeReport() throws InterruptedException{
		 extent.flush();
		 
		 Thread.sleep(3000);
//		 extent.close();
		
	}
	
}
