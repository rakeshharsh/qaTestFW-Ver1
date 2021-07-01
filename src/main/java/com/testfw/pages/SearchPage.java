package com.testfw.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testfw.basesetup.TestBaseSetup;

public class SearchPage extends TestBaseSetup {
	
	@FindBy(id="twotabsearchtextbox")

    WebElement amazonSearchBox;
	
	@FindBy(id="nav-search-submit-button")
	
	WebElement amazonSearchBtn;
	
	@FindBy(xpath ="(//img[@class=\"s-image\"])[1]")
	WebElement firstSearresult;
	
	@FindBy(xpath ="(//a[text()=\"Paperback\"])[1]/ancestor::div[1]/following-sibling::div/a/span/span/span[1]")
	WebElement priceSymbol; 
	
	@FindBy(xpath ="(//a[text()=\"Paperback\"])[1]/ancestor::div[1]/following-sibling::div/a/span/span/span[2]")
	WebElement wholePrice; 
	
	@FindBy(xpath ="(//a[text()=\"Paperback\"])[1]/ancestor::div[1]/following-sibling::div/a/span/span/span[3]")
	WebElement fractionPrice; 
	
	
	
	
	// Initializing the Page Objects:
		public SearchPage() {
			PageFactory.initElements(driver, this);
		}
	
public void searchKeyWord(String searchString){		
	    System.out.println(searchString);
		this.amazonSearchBox.sendKeys(searchString);	    
	    }

public void clickSeacrhButton(){		
	amazonSearchBtn.click();	
	
    }
	
	public String verifySearchPageTitle(){
	    String test = driver.getTitle();
	    //System.out.println(test);
		return driver.getTitle();
	}
	
	public String getFirstItemValue()
	
	{
		String paperbackPrice = priceSymbol.getText() + wholePrice.getText() + "." + fractionPrice.getText();
		return paperbackPrice;
				
	}
	
	public void clickFirstSeacrhedItem(){	
		
		firstSearresult.click();
	    }

}
