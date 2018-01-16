package com.amazon.test;

import com.amazon.base.Singleton;
import com.amazon.home.Login;

public class LoginTest {

	Login loginPage = null;
	//Before method
	public void startBrowser(){
		Singleton singleton = Singleton.getInstances();
		loginPage = new Login(singleton.getDriver(), singleton.getUrl());
		loginPage.openAndlogin(singleton.getUsername(), singleton.getPassword());
	}
	
	
	public static void main(String[] args) {
		LoginTest loginTest = new LoginTest();
		loginTest.startBrowser();
	}
}
