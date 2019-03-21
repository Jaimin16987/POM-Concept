package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class ProductNservicePage extends TestBase {

	
	@FindBy(xpath = "//a[contains(.,'New Product')]")
	WebElement NewProduct;
	@FindBy(xpath = "//input[@id='name']")
	WebElement Name;
	@FindBy(xpath = "//input[contains(@id,'price')]")
	WebElement SalePrice;
	@FindBy(xpath = "//input[@id='item_number']")
	WebElement ItemNumber;
	@FindBy(xpath = "//textarea[@id='description']")
	WebElement Desc;
	@FindBy(xpath = "//button[@id='submit']")
	WebElement Submit;
	@FindBy(xpath = "//div[@class='alert alert-success fade in']")
	WebElement NewProMsg;
	
	public ProductNservicePage(){
	  	  PageFactory.initElements(driver, this);  
	    }
	public String TitleOfProNservicepage() {
		return driver.getTitle();
	}
	public void ClickOnNewproduct() {
		NewProduct.click();
	}
	public void CreatNewProduct(String name,String Sprice,String itemNo,String desc) {
		Name.sendKeys(name);
		SalePrice.sendKeys(Sprice);
		ItemNumber.sendKeys(itemNo);
		Desc.sendKeys(desc);
		Submit.click();
	}
	public boolean veryfyNewPorductAddMsg() {
		return NewProMsg.isDisplayed();
	}
	
	
	
}
