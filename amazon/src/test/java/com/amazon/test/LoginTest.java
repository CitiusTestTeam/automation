package com.amazon.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.amazon.base.Singleton;
import com.amazon.home.Login;


public class LoginTest {

	Login loginPage = null;
	//Before method
	
	@BeforeClass
	public void startBrowser(){
		Singleton singleton = Singleton.getInstances();
		loginPage = new Login(singleton.getDriver(), singleton.getUrl());
		loginPage.openAndlogin(singleton.getUsername(), singleton.getPassword());
	}
	
	@Test
	public void login() {
		LoginTest loginTest = new LoginTest();
		loginTest.startBrowser();
	}
	
	
}
