package com.amazon.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.Singleton;
import com.amazon.home.Home;

public class HomeTest {

	Home homePage = null;
	//Before method
	@BeforeMethod
	public void startBrowser(){
		Singleton singleton = Singleton.getInstances();
		homePage = new Home(singleton.getDriver());
		homePage.openAndlogin(singleton.getUsername(), singleton.getPassword());
	}
	
	@Test
	public void searchMobileAndFilter(){
		homePage.enterSearchData("Iphone 7");
		homePage.clickOnSearchButton();
		homePage.clickOnSearchResult();
	//	homePage.refineSearchBy();
	}
}
