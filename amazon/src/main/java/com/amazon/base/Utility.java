package com.amazon.base;

import java.util.List;

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
	
	public void click(String element){
		element(element).click();
	}
	
	public void enterData(String element, String data){
		element(element).sendKeys(data);
	}
	
	public WebElement element(String element){
		return driver.findElement(By.xpath(element));
	}
	
	public List<WebElement> elements(String element){
		return driver.findElements(By.xpath(element));
	}
	
	public String getNewWindow(){
		return driver.getWindowHandle();
	}
	
	public String getText(String element){
		return element(element).getText();
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
}
