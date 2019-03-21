package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.Base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(.,'Welcome TechFios Tester')]")
	  WebElement userNameLable;
	
    @FindBy(xpath="//span[contains(text(),'Transactions')]")
	  WebElement TransLink;
    @FindBy(xpath = "//span[contains(text(),'Sales')]")
      WebElement salesLink;
    @FindBy(xpath="//span[contains(text(),'CRM')]")
	  WebElement CrmLink;
    @FindBy(xpath = "//span[contains(text(),'Products & Services')]")
      WebElement ProductNservice; 
    
  //initializing the page object
    public HomePage(){
  	  PageFactory.initElements(driver, this);
  	  
    }
  //Action
    public String verifyHomePageTitle() {
  	  return driver.getTitle();
  	  }
    public boolean verifyUserNameLable() {
    	return userNameLable.isDisplayed();
    }
    public void clickOnCrmlink() {
    	CrmLink.click();
	 }
   
   
    
   
    public void clickOnProductNServiceLink () {
    	ProductNservice.click();
    }
    





}
