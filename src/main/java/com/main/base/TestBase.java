package com.main.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	
	public static Properties prop;
	public static AppiumDriver<?> driver;
	
	public TestBase() {
			
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("D:\\Eclipse\\workspace\\appiumDemo\\src\\test\\resources\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	//This method is used to start the Appium
	
    public static void initialization() {

		try {
			driver = startAppium();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

    //This method is used for initiating the Appium Driver with capabilities and connection protocol

	public static AppiumDriver<?> startAppium() {
		 try {
			DesiredCapabilities cap = new DesiredCapabilities();
			// All Capability values are retrieved from config.properties file.
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("PLATFORM_NAME"));
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("PLATFORM_VERS"));
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DEVICE_NAME"));
			cap.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");
			cap.setCapability("appPackage", "com.google.android.apps.messaging");
			cap.setCapability("autoLaunch", true);
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 500);
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

			// Declaring the driver as "Android driver" with the Host and Port number to communicate with Appium desktop
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
      }catch (Exception e) {
			driver = null;
            e.printStackTrace();
		}
		
	 return driver;
	}
}
	

	
