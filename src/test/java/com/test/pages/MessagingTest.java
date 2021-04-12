package com.test.pages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.main.base.TestBase;
import com.main.pages.MessagingPage;

public class MessagingTest extends TestBase {

	public MessagingPage msgPage;
	
	public MessagingTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
	}
	
	@Test(priority=1)
	public void launchAppTest() {
		msgPage=new MessagingPage();
		msgPage.startApp();
	}
	
	@Test(priority=2)
	public void addMsgTest() {
	boolean state=msgPage.addMsg();
	System.out.println(state);
	
	}


}
