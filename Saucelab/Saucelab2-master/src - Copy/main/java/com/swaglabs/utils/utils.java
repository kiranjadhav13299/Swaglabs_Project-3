
/**
 * 
 */
package com.swaglabs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 */
public class utils {

	public static  WebDriver driver;
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT =10;
//	public static WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
	
	public static void logOut(WebDriver driver) {
		WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
				burgerMenu.click();
		WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
		logout.click();
		driver.manage().deleteAllCookies();
	}
	
	public static void clickElement(WebDriver driver, By locator) {
	    try {
	        WebElement element = driver.findElement(locator);
	        element.click();
	    } catch (Exception e) {
	        // Add logging or error handling as needed
	        e.printStackTrace();
	    }
	}

    // Method for entering text into a text field
    public static void enterText(WebDriver driver, By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Method for getting text from an element
    public static String getText(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    // Method for navigating to a URL
    public static void navigateToURL(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

    // Method for waiting for an element to be present
//    public static void waitForElementPresent(WebDriver driver, By locator, int timeoutInSeconds) {
//        // Implementation of wait logic using WebDriverWait
//        // This is just a basic example, you might want to use WebDriverWait with ExpectedConditions
//    }
    
    public static WebElement waitForElementPresent(WebDriver driver, By locator, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    
    
  //########## Method to Select data from Excel Sheet #########//
  	public static Object[][] getDatafromExcelsheet(String sheetname) throws IOException
  	{
  		File excelfile = new File(System.getProperty("user.dir")+"//src//test//java//resources//TestData//ExcelData.xlsx");
  		//XSSFWorkbook workbook = null;
  		
  		FileInputStream fisSheet = new FileInputStream(excelfile);
  		
  		XSSFWorkbook workbook = new XSSFWorkbook(fisSheet);
  		
  		/*try
  		{
  			FileInputStream fisSheet = new FileInputStream(excelfile);
  			workbook = new XSSFWorkbook(fisSheet);
  		}
  		catch (Throwable e)
  		{
  			e.printStackTrace();
  		}*/
  		
  		
  		XSSFSheet sheet = workbook.getSheet(sheetname);
  		
  		int rows = sheet.getLastRowNum();
  		int columns = sheet.getRow(0).getLastCellNum();
  		
  		Object[][] data = new Object[rows][columns];
  		
  		for(int i=0; i<rows;i++)
  		{
  			XSSFRow row= sheet.getRow(i+1); // Read the data from second row while skipping header
  			
  			for(int j=0; j<columns; j++)
  			{
  				XSSFCell cell=row.getCell(j);
  				CellType celltype = cell.getCellType();
  				
  				switch(celltype) {
  				
  				case STRING:
  					data[i][j] = cell.getStringCellValue();
  					System.out.println("Cell value:"+data[i][j]);
  					break;
  				case NUMERIC:
  					data[i][j] = Integer.toString((int)cell.getNumericCellValue());
  					break;
  				case BOOLEAN:
  					data[i][j] = cell.getBooleanCellValue();
  					break;
  				default:
  					System.out.println("No cell data found");
  					break;
  				}
  				
  			}
  		}
  		
  		return data;
  	}
  	
  	
  	
  	public static void addToCart(WebDriver driver) {
  		try {
  		WebElement aTC = driver.findElement(By.id("shopping_cart_container"));
  		aTC.click();
  	} catch(Exception e) {
  		System.out.println(e);
  	}
  	
  	}
  	
  	public static void waitForElementToDisappear(WebDriver driver, String elementId, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(elementId)));
    }
  	
  	public static boolean isElementPresent(By locator) {
  	    try {
  	        try {
				driver.findElement(locator);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  	        return true;
  	    } catch (NoSuchElementException e) {
  	        return false;
  	    }
  	}

	
}