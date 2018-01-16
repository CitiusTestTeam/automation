package com.amazon.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	WebDriver driver = null;
	private final String XPATH_SIGN_IN_BUTTON = ".//*[@id='nav-flyout-ya-signin']/a/span.nav-action-inner";

	public Utility(WebDriver driver){
		this.driver = driver;
	}
	
	public void mouseHover(String mouseHoverElement){
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath(mouseHoverElement));
		WebElement signInElement = driver.findElement(By.xpath(XPATH_SIGN_IN_BUTTON));
		System.out.println("is element visible mouse hover: "+element.isDisplayed());

		
		action.moveToElement(element).perform();
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(signInElement));
		action.moveToElement(signInElement).click().perform();
		
		//action.moveToElement(element).build().perform();
	}
	
	public void click(String element){
		driver.findElement(By.xpath(element)).click();
	}
	
	public void enterData(String element, String data){
		driver.findElement(By.xpath(element)).sendKeys(data);
	}
}
