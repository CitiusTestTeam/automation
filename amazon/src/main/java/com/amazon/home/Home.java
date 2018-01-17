package com.amazon.home;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amazon.base.PageBase;
import com.amazon.config.Config.RamSize;
import com.amazon.product.ProductDetails;

public class Home extends PageBase{
	
	WebDriver driver = null;
	private final String XPATH_SEARCH_BOX = ".//*[@id='twotabsearchtextbox']";
	private final String XPATH_LEFT_NAV_CORNER = ".//*[@id='leftNavContainer']/ul";
	private final String XPATH_SEARCH_BUTTON = ".//*[@id='nav-search']/form/div[2]/div/input";
	private final String XPATH_SEARCH_RESULT = ".//*[@id='result_%d']/div/div[3]/div[1]/a";
	private final String XPATH_TOTAL_SEARCH_RESULT = ".//*[@id='atfResults']/ul/li";

	public Home(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	public void enterSearchData(String searchData){
		enterData(XPATH_SEARCH_BOX, searchData);
	}
	
	public void clickOnSearchButton(){
		click(XPATH_SEARCH_BUTTON);
	}
	
	public void refineSearchBy(){
		List<WebElement> elements = elements(XPATH_LEFT_NAV_CORNER);
		for(int i=0; i <elements.size(); i++){
			Class<? extends WebElement> text = elements.get(i).getClass();
			System.out.println("Text : "+text);
		}
	}
	
	public void clickOnSearchResult() {
		List<WebElement> elements = elements(XPATH_TOTAL_SEARCH_RESULT);
		System.out.println("Elements: " + elements);
		System.out.println("String formatter: "
				+ String.format(XPATH_SEARCH_RESULT, 0));
		ProductDetails productDetails;
		for (int i = 0; i < elements.size(); i++) {
			click(String.format(XPATH_SEARCH_RESULT, i));
			driver.switchTo().window(getNewWindow());
			productDetails = new ProductDetails(driver);
			productDetails.clickOnSize(RamSize.GB128);
		}

	}
}
