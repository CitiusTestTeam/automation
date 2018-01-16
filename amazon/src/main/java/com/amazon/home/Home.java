package com.amazon.home;

import org.openqa.selenium.WebDriver;

import com.amazon.base.PageBase;

public class Home extends PageBase{
	
	WebDriver driver = null;
	public Home(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
}
