package com.amazon.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.config.Config;
import com.amazon.config.TestConfig;

public class Singleton {

	private WebDriver driver = null;
	private String username = null;
	private String password = null;
	private String browser = null;
	private String url = null;
	private static Singleton singletonInstance = null;
	
	public static Singleton getInstances(){
		if(singletonInstance == null){
			singletonInstance = new Singleton();
		}
		singletonInstance.initializeConfig();
		return singletonInstance;
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}


	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}


	public String getBrowser() {
		return browser;
	}


	public String getUrl() {
		return url;
	}


	public static Singleton getSingletonInstance() {
		return singletonInstance;
	}


	private void initializeConfig(){
		this.browser = Config.getBrowserName();
		this.username = Config.getUsername();
		this.password = Config.getPassword();
		this.username = Config.getUsername();
		if(browser.equals(TestConfig.BROWSER_FIREFOX)){
			System.setProperty("webdriver.gecko.driver", "./Resource/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}
}
