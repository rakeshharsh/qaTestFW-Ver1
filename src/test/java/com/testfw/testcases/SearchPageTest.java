package com.testfw.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.testfw.pages.SearchPage;
import com.testfw.utils.UtilityHelper;
import com.testfw.basesetup.*;

public class SearchPageTest extends TestBaseSetup{
	
	SearchPage searchPage;
	@BeforeMethod
	public void setUp() {
			
		initialization();
		searchPage = new SearchPage ();
	}
	
	@Test(priority=1)
	public void verifySearchPageTitleTest(){
	searchPage.searchKeyWord(prop.getProperty("bookname"));		
	searchPage.clickSeacrhButton();
	
	String productValue = searchPage.getFirstItemValue();
	System.out.println(productValue);
	
	searchPage.clickFirstSeacrhedItem();
	String searchPageTitle = searchPage.verifySearchPageTitle();
	try {
		UtilityHelper.takeScreenshotAtEndOfTest();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Assert.assertEquals(searchPageTitle, "Amazon.com : qa testing for bigginners","Home page title not matched");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
