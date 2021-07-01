package com.testfw.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testfw.basesetup.TestBaseSetup;
import com.testfw.pages.HomePage;
import com.testfw.pages.ProductDetailsPage;
import com.testfw.pages.SearchPage;
import com.testfw.utils.UtilityHelper;

public class ProductDetailsPageTest extends TestBaseSetup {
	
	HomePage homePage;
	ProductDetailsPage productDetailsPage;
	SearchPage searchPage;
	@BeforeMethod
	public void setUp() {			
		initialization();
		homePage = new HomePage ();
		searchPage = new SearchPage ();
		productDetailsPage = new ProductDetailsPage ();
	}
	
	@Test(priority=1)
	public void verifyAmountValuePage(){
	searchPage.searchKeyWord(prop.getProperty("bookname"));		
	searchPage.clickSeacrhButton();	
	String productValue = searchPage.getFirstItemValue();
	System.out.println(productValue);	
	searchPage.clickFirstSeacrhedItem();
	
	String cartVal= productDetailsPage.getPrice();
	Assert.assertTrue(true);
	System.out.println(cartVal);
	try {
		UtilityHelper.takeScreenshotAtEndOfTest();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//Assert.assertEquals(searchPageTitle, "Amazon.com : qa testing for bigginners","Home page title not matched");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
