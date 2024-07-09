package com.swaglabs.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.InventoryPage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.Constants;
import com.swaglabs.utils.utils;

public class CartTest extends BaseClass {
	LoginPage loginPage;
	InventoryPage inventory;
	CartPage cartPage;
	Constants constant;
	public CartTest() throws IOException {
		super();
	}
	
	
	
  @Test
  public void VerifyProdDetailsOnCartPage() throws IOException, InterruptedException {
	  loginPage = new LoginPage(driver);
	  loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	  inventory = new InventoryPage(driver);
	  inventory.clickOnAddToCartbtn();
	  utils.addToCart(driver);
//	  Thread.sleep(1000);
	  cartPage = new CartPage();
	  cartPage.prodDetailsInCart();
	  }
  
  
  @Test
  public void clickOnRemove() throws IOException, InterruptedException {
	  loginPage = new LoginPage(driver);
	  loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	  inventory = new InventoryPage(driver);
	  inventory.clickOnAddToCartbtn(); 
	  inventory.clickonAddToCart2ndProd();
	  utils.addToCart(driver);
	  cartPage = new CartPage();
	  String currentBadge =cartPage.checkCartBadge();
	  cartPage.removeProdFromCartPage();
	  String presentBadge =cartPage.checkCartBadge();
	  int currentBadgeValue = Integer.parseInt(currentBadge);
	  int presentBadgeValue = Integer.parseInt(presentBadge);

	  int difference = currentBadgeValue - presentBadgeValue;
	 Assert.assertEquals(presentBadgeValue, difference);
  	}
  
  @Test
  public void clickOnContinueShopping() throws IOException, InterruptedException {
	  loginPage = new LoginPage(driver);
	  loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	  inventory = new InventoryPage(driver);
	  inventory.clickOnAddToCartbtn(); 
	  utils.addToCart(driver);
	  cartPage = new CartPage();
	  cartPage.clickOnContinue();
	  Thread.sleep(1000);
	  String url =driver.getCurrentUrl();
	  Assert.assertEquals(url, constant.HomePageURL);
  }
  @Test
  public void clickOnCheckOut() throws IOException, InterruptedException {
	  loginPage = new LoginPage(driver);
	  loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	  inventory = new InventoryPage(driver);
	  inventory.clickOnAddToCartbtn(); 
	  utils.addToCart(driver);
	  cartPage = new CartPage();
	  cartPage.clickonCheckOut();
	  Thread.sleep(1000);
	  
	  Assert.assertEquals(driver.getCurrentUrl(), constant.checkOutStep1);
  }
  
  
  
  
  
}