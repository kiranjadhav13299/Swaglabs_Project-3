package com.swaglabs.base;

//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.swaglabs.utils.utils;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * 
 */
public class BaseClass {
	 public static WebDriver driver;
	 public static Properties prop;
	 
	 
	 public BaseClass() throws IOException {
		 try {
			 prop = new Properties();
			 FileInputStream ip= new FileInputStream("C:\\Users\\prati\\OneDrive\\Desktop\\Java Projects\\SwagLabs\\src\\main\\java\\com\\swaglabs\\config\\config.properties"); 
			 prop.load(ip);
			 
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	 }
	 
	 
	 
	    @SuppressWarnings("deprecation")
		@BeforeMethod
	    public void setUp() {
	    	// You can configure the browser type based on your requirements
	        String browserName = prop.getProperty("browser"); // or "firefox"
	        String userN = prop.getProperty("username");
	        String passW = prop.getProperty("password");
	        String iuser = prop.getProperty("invaliduser");
	        String ipass = prop.getProperty("invalidpass");

	        if (browserName.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        } else if (browserName.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        }
	        
	        else if (browserName.equalsIgnoreCase("edge")) {
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	        }

	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        driver.manage().timeouts().pageLoadTimeout(utils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	        driver.manage().timeouts().implicitlyWait(utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
	        
	        driver.get(prop.getProperty("url"));
	        
	    }

	    @AfterMethod
	    public void tearDown() {
	        // Close the WebDriver instance
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}