package com.main.pages;

import org.openqa.selenium.By;

import com.main.base.TestBase;

//import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;

public class MessagingPage extends TestBase {
	
static By anyField = MobileBy.id("com.google.android.apps.messaging:id/start_new_conversation_button");
boolean assertion;

	public void startApp() {
		try{
		driver.launchApp();
      }catch(Exception e) {
		e.printStackTrace();
			
		}
	}
	public boolean addMsg() {
		assertion = false;
		try {
			driver.findElement(anyField).click();
			assertion = true;
			
		} catch (Exception e) {
			assertion = false;
			e.printStackTrace();
		}
		return assertion;
	}
}


