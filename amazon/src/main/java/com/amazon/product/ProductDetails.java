package com.amazon.product;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.amazon.base.Utility;
import com.amazon.config.Config.RamSize;

public class ProductDetails extends Utility{

	public WebDriver driver;
	private final String XPATH_TOTAL_SIZE_DETAIL = ".//*[@id='variation_size_name']/ul/li";
	private final String XPATH_SIZE = ".//*[@id='size_name_%d']";
	private final String XPATH_SELECTED_SIZE = ".//*[@id='variation_size_name']/div/span";

	public ProductDetails(WebDriver driver){
		super(driver);
		this.driver = driver;
		System.out.println("Switched window title: "+driver.getTitle());
	}
	
	public void clickOnSize(RamSize ramsize){
		 if(!getText(XPATH_SELECTED_SIZE).equals(ramsize)){
			 List<WebElement> totalAvailableRamSize = elements(XPATH_TOTAL_SIZE_DETAIL);
			 for(int i=0; i<totalAvailableRamSize.size(); i++){
				 WebElement availableRamSizeElement = element(String.format(XPATH_SIZE, i));
				 if(availableRamSizeElement.getText().equals(ramsize)){
					 availableRamSizeElement.click();
					 System.out.println("fd");
				 }
			 }
		 }
		
	}
}
