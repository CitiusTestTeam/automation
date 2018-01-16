package com.amazon.test;

import com.amazon.base.Singleton;
import com.amazon.home.Home;

public class HomeTest {

	Home homePage = null;
	//Before method
	public void startBrowser(){
		Singleton singleton = Singleton.getInstances();
		homePage = new Home(singleton.getDriver());
		homePage.openAndlogin(singleton.getUsername(), singleton.getPassword());
		
	}
}
