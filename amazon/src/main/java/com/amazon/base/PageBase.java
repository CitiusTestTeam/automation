package com.amazon.base;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.config.Config;

public class PageBase extends Utility{

	public WebDriver driver;
	private final String XPATH_HELLO_SIGN_IN = ".//*[@id='nav-link-yourAccount']/span[1]";
	private final String XPATH_SIGN_IN_BUTTON = ".//*[@id='nav-flyout-ya-signin']/a/span";
	private final String XPATH_EMAIL_OR_PHONE = ".//*[@id='ap_email']";
	private final String XPATH_CONTINUE = ".//*[@id='continue']";
	private final String XPATH_PASSWORD = ".//*[@id='ap_password']";
	private final String XPATH_LOGIN_BUTTON = ".//*[@id='signInSubmit']";
	protected WebDriverWait webDriverWait;
	public PageBase(WebDriver driver){
		super(driver);
		this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Config.TIMEOUT_EXPLICIT_IN_SECS);
	}
	
	public void openAndlogin(String userName, String password){
		
		driver.get(Config.url);
		
		mouseHover(XPATH_HELLO_SIGN_IN);
		
		
		boolean isvisible = isElementVisible(XPATH_SIGN_IN_BUTTON);
		
		System.out.println("final visibility of sign in button: "+isvisible);
		clickOnSignInButton();
		
		
		
		enterData(XPATH_EMAIL_OR_PHONE, userName);
		
		click(XPATH_CONTINUE);
		
		enterData(XPATH_PASSWORD, password);
		
		click(XPATH_LOGIN_BUTTON);
	}

	public void clickOnSignInButton(){
		click(XPATH_SIGN_IN_BUTTON);
	}
	
	
	public boolean isElementVisible(final String element){
		try {
            webDriverWait.until(new Function<WebDriver, Boolean>() {

				public Boolean apply(WebDriver t) {
					System.out.println("is visible: "+driver.findElement(By.xpath(element)).isDisplayed());
					if(!driver.findElement(By.xpath(element)).isDisplayed()){
						System.out.println("inside mouse hover");
						
						mouseHover(XPATH_HELLO_SIGN_IN);
					}
					return driver.findElement(By.xpath(element)).isDisplayed();
				}            	
			});
	}
		catch(Exception e){
			System.out.println("exception "+e);
		}
		return false;
	}
	
}
