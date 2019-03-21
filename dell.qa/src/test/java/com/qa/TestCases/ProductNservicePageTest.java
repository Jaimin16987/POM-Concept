package com.qa.TestCases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.CrmPage;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.Pages.ProductNservicePage;
import com.qa.Util.TestUtil;

public class ProductNservicePageTest extends TestBase {

 HomePage homePage;
 LoginPage loginPage;
 ProductNservicePage proNservice;
 TestUtil testUtil;
 String sheetName = "ProductData";
	public ProductNservicePageTest() {
		super();
	  }
	@BeforeMethod
	public void setUp() {
		 initialization();
		  loginPage = new LoginPage();
		  testUtil = new TestUtil();
		   proNservice = new ProductNservicePage();
	       homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
	       homePage.clickOnProductNServiceLink();
	       proNservice.ClickOnNewproduct();
	}
	@Test(priority=1)
	public void ProNservicePageTitileTest() {
		
		String title = proNservice.TitleOfProNservicepage();
	Assert.assertEquals(title, "Products & Services- TechFios Test Application - Billing","Title not metch");
	}
	@DataProvider
	public Object[][] getProductTestData(){
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=2,dataProvider="getProductTestData")
	public void CreatNewProductTest(String name,String Sprice,String itemNo,String desc) {
		  proNservice.CreatNewProduct(name, Sprice, itemNo, desc);
		 // proNservice.CreatNewProduct("laptop","500","123","testing" );
		  boolean msg = proNservice.veryfyNewPorductAddMsg();
		  Assert.assertTrue(msg);
	}
	 @AfterMethod
	 public void TearDown() {
		 driver.quit();
	 }
	







}
