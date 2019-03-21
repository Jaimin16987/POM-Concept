package com.qa.Pages;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class LoginPage extends TestBase {
	
   
// Page Factory or object repository
   // it will keep all the locator and method in this class
  @FindBy(xpath = "//input[@name='username']")
  WebElement username;
  @FindBy(xpath = "//input[@name='password']")
  WebElement password;
  @FindBy(xpath = "//button[contains(@name,'login')]")
  WebElement signInBtn;
  @FindBy(xpath = "//img[@class='logo']")
  WebElement logo;
  
//initializing the page object
  public LoginPage(){
	  PageFactory.initElements(driver, this);
	  
  }
 
  //Action
  public String verifyLoginPageTitle() {
	  return driver.getTitle();
	  
  }
  public boolean verifyLogo() {
	  return logo.isDisplayed();
  }
  public HomePage login(String un,String pwd) {
	  username.sendKeys(un);
	  password.sendKeys(pwd);
	  signInBtn.click();
	  return new HomePage();
  }
 
  
  
}
