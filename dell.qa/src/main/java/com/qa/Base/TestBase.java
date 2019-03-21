package com.qa.Base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeTest;


import com.qa.Util.TestUtil;
import com.qa.Util.WebEventListener;

public class TestBase {

 public static WebDriver driver;
 public static Properties prop;
 public  static EventFiringWebDriver e_driver;
 public static WebEventListener eventListener;
 public static final Logger logger = Logger.getLogger(TestBase.class.getName());
    public TestBase() {
    	
    	  try {
			      prop = new Properties();
			 FileInputStream fs = new FileInputStream("C:\\Users\\patel\\eclipse-workspace\\dell.qa\\src\\main\\java\\com"
					                     + "\\qa\\Config\\config.properties");
			      prop.load(fs);
		} catch (FileNotFoundException e) {
			    e.printStackTrace();
		} catch (IOException e) {
			    e.printStackTrace();
		}
        }
   public static void initialization() {
	            String browserName = prop.getProperty("browser");
	      if(browserName.equalsIgnoreCase("chrome")) {
		        System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe" );
			      driver = new ChromeDriver();
	    }
		  else if(browserName.equals("FF")) {
			    System.setProperty("webdriver.gecko.driver","C:\\Driver\\geckodriver.exe" );
				 driver = new FirefoxDriver();
		}
	          e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
			  eventListener = new WebEventListener();
			  e_driver.register(eventListener);
			  driver = e_driver;
			
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(TestUtil.page_Load_Timeout, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait,TimeUnit.SECONDS);
	    
	    driver.get(prop.getProperty("url"));
	    
        }
   



}

	  
   
    
    
    


