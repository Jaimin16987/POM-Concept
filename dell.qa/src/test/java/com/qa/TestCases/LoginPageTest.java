package com.qa.TestCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
    HomePage homePage;
Logger log = Logger.getLogger(LoginPageTest.class);
public LoginPageTest() {
	super();
  }

  @BeforeMethod
  public void setUp() {
	 log.info("broweser is launching");
	  initialization();
	   loginPage = new LoginPage();
  }
  @Test(priority=3)
  public void LoginPageTitleTest() {
	  
	  String title = loginPage.verifyLoginPageTitle();
	  Assert.assertEquals(title, "Login - TechFios Test Application - Billing");
  }
  
  @Test(priority=1)
  public void LoginTest() {
	  
	   homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));  
  }
  @Test(priority=2)
  public void verifylogo() {
	 boolean flag = loginPage.verifyLogo();
	 Assert.assertTrue(flag);
  }
  

  @AfterMethod
  public void teraDown() {
	  driver.quit();
  }


}
