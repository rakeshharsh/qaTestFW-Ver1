package com.testfw.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testfw.basesetup.*;

public class HomePage extends TestBaseSetup{
	
	@FindBy(id="twotabsearchtextbox")

    WebElement amazonSearchBox;
	
	@FindBy(id="nav-search-submit-button")

    WebElement amazonSearchBtn;
	
	public String verifyHomePageTitle(){
	    String test = driver.getTitle();
	    System.out.println(test);
		return driver.getTitle();
	}

}
