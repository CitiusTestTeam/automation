package com.amazon.home;

import org.openqa.selenium.WebDriver;

import com.amazon.base.PageBase;

public class Login extends PageBase{

	public static String currentAnchor ="";
	public Login(WebDriver driver, String urlBase){
		super(driver);
	}
}
