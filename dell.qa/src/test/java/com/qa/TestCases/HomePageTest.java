package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
// in Assert class we can write 1 more variable call error massage. 
public class HomePageTest extends TestBase{
    LoginPage loginPage;
    HomePage homePage;
	public HomePageTest() {
		super();
	  }
	// before each test case  launch the browser
	//@Test---execute test case
	// after test case quit the browser.
	
	
	 @BeforeMethod
	  public void setUp() {
		  initialization();
		   loginPage = new LoginPage();
	      homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	 }
	 @Test(priority=1)
	 public void HomePageTitleTest() {
		 String Title = homePage.verifyHomePageTitle();
		 Assert.assertEquals(Title, "Dashboard- TechFios Test Application - Billing");
	 }
	 @Test(priority=2)
	 public void userNameLableTest() {
		 
		boolean UserName = homePage.verifyUserNameLable();
		 Assert.assertTrue(UserName);
	 }
	
	 
	 @AfterMethod
	 public void TearDown() {
		 driver.quit();
	 }




}
