package com.testfw.pages;

import com.testfw.basesetup.TestBaseSetup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends TestBaseSetup{
	
	@FindBy(xpath ="(//*[text()=\"Paperback\"])[1]")
	WebElement paperbkSel; 
	
	@FindBy(xpath ="//*[@id=\"price\"]")
	WebElement priceElement; 
	
	
	
	
	// Initializing the Page Objects:
		public ProductDetailsPage() {
			PageFactory.initElements(driver, this);
		}
	
public String getPrice(){	
	
	paperbkSel.click();
	paperbkSel.click();
	return priceElement.getText();
	    
			    
	    }
	

}
