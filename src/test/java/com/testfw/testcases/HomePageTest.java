package com.testfw.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.testfw.pages.HomePage;
import com.testfw.utils.UtilityHelper;
import com.testfw.basesetup.*;

public class HomePageTest extends TestBaseSetup {
	
	HomePage homePage;
	public HomePageTest() {
		super();
		homePage = new HomePage();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
	String homePageTitle = homePage.verifyHomePageTitle();
	try {
		UtilityHelper.takeScreenshotAtEndOfTest();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Assert.assertEquals(homePageTitle, "Amazon.com. Spend less. Smile more.","Home page title not matched");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
