package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.Base.TestBase;

public class CrmPage extends TestBase {


	
	@FindBy(xpath = "//input[contains(@name,'account')]")
	WebElement TypeName;
	@FindBy(xpath = "//input[@id='company']")
	WebElement CompanyName;
	@FindBy(xpath = "//input[contains(@id,'email')]")
	WebElement TypeEmail;
	@FindBy(xpath = "//span[@id='select2-country-container']")
	WebElement CountryName;
	@FindBy(xpath = "//button[contains(@id,'submit')]")
	WebElement Submit;
	@FindBy(xpath = "//li[contains(.,'United Kingdom')]")
	WebElement SelectUk;
	@FindBy(xpath = "//a[contains(text(),'Add Contact')]")
	WebElement AddcontactLink;
	
	 public CrmPage(){
	  	  PageFactory.initElements(driver, this);  
	    }
	 
	public String veryfyCrmPageTitle() {
		return driver.getTitle();
	}
	public void verifyClikOnAddContact() {
		AddcontactLink.click();
	}
	
	
	public void CreatNewContact(String name, String company,String email ) {
		
		TypeName.sendKeys(name);
		CompanyName.sendKeys(company);
		TypeEmail.sendKeys(email);
		
		Submit.click();
		
		
	}
	
	}


