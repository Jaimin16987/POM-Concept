package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.CrmPage;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;

public class CrmPageTest extends TestBase {
 LoginPage loginPage;
 HomePage homePage;
 CrmPage crmPage;
	public CrmPageTest() {
		super();
	  }
	 @BeforeMethod
	  public void setUp() {
		  initialization();
		   loginPage = new LoginPage();
		   crmPage = new CrmPage();
	       homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	       homePage.clickOnCrmlink();
	       crmPage.verifyClikOnAddContact();
	 
	 }
	 
	 @Test(priority=2)
	 public void CreateNewContactTest() {
		 crmPage.CreatNewContact("peter", "ebay", "pet@yahoo.com");
	 }
	
	 @Test(priority=1)
	 public void clickOnAddContactTest()  {	
		 crmPage.verifyClikOnAddContact();
	 }
	 @Test(priority=3)
	 public void crmPageTitleTest() {
		 String title = crmPage.veryfyCrmPageTitle();
		 Assert.assertEquals(title, "Contacts - TechFios Test Application - Billing");
	 }
	
	 
	 
	 
	 
	 
	 
	 @AfterMethod
	 public void TearDown() {
		 driver.quit();
	 }








}
