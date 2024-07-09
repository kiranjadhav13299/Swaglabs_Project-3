package com.swaglabs.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.CheckoutPageStep1;
import com.swaglabs.pages.InventoryPage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.Constants;
import com.swaglabs.utils.utils;


public class CheckOutStep1Test extends BaseClass {
	LoginPage loginPage;
	InventoryPage inventory;
	CartPage cartPage;
	CheckoutPageStep1 checkout;
	Constants constant;

	public CheckOutStep1Test() throws IOException {
		super();
	}

	@Test
	public void EnterValidData() throws IOException, InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		inventory = new InventoryPage(driver);
		inventory.clickOnAddToCartbtn(); 
		utils.addToCart(driver);
		cartPage = new CartPage();
		cartPage.clickonCheckOut();
		checkout = new CheckoutPageStep1();
		checkout.EnterValidData();

		Assert.assertEquals(driver.getCurrentUrl(), constant.Checkout_Page_URL);

	}
	
	@Test
	public void keepFNblank() throws InterruptedException, IOException {
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		inventory = new InventoryPage(driver);
		inventory.clickOnAddToCartbtn(); 
		utils.addToCart(driver);
		cartPage = new CartPage();
		cartPage.clickonCheckOut();
		checkout = new CheckoutPageStep1();
		checkout.KeepFirstNameBlank();
		String error = checkout.errorMsg();
		Assert.assertEquals(error,"Error: First Name is required");
	}
	
	@Test
	public void keepLNblank() throws InterruptedException, IOException {
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		inventory = new InventoryPage(driver);
		inventory.clickOnAddToCartbtn(); 
		utils.addToCart(driver);
		cartPage = new CartPage();
		cartPage.clickonCheckOut();
		checkout = new CheckoutPageStep1();
		checkout.keepLastNameBlank();
		String error = checkout.errorMsg();
		Assert.assertEquals(error,"Error: Last Name is required");
	}
	
	@Test
	public void keepZipCodeblank() throws InterruptedException, IOException {
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		inventory = new InventoryPage(driver);
		inventory.clickOnAddToCartbtn(); 
		utils.addToCart(driver);
		cartPage = new CartPage();
		cartPage.clickonCheckOut();
		checkout = new CheckoutPageStep1();
		checkout.KeepZipCodeBlank();;
		String error = checkout.errorMsg();
		Assert.assertEquals(error,"Error: Postal Code is required");
	}
	
	@Test 
	public void AddSpecCharOrAlphabetsIntoZipCode() throws IOException, InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		inventory = new InventoryPage(driver);
		inventory.clickOnAddToCartbtn(); 
		utils.addToCart(driver);
		cartPage = new CartPage();
		cartPage.clickonCheckOut();
		checkout = new CheckoutPageStep1();
		checkout.EnterspecialCharInZipCode();
		String error = checkout.errorMsg();
		Assert.assertEquals(error,"Error: Only numeric values are allowed");
	}
	
	@Test
	public void ClickOnCancelBtn() throws IOException, InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		inventory = new InventoryPage(driver);
		inventory.clickOnAddToCartbtn(); 
		utils.addToCart(driver);
		cartPage = new CartPage();
		cartPage.clickonCheckOut();
		checkout = new CheckoutPageStep1();
		checkout.cancelCheckOut();
		Assert.assertEquals(driver.getCurrentUrl(),constant.cartUrl);
	}
	
	@Test
	public void clickOnContinue () throws IOException, InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		inventory = new InventoryPage(driver);
		inventory.clickOnAddToCartbtn(); 
		utils.addToCart(driver);
		cartPage = new CartPage();
		cartPage.clickonCheckOut();
		checkout = new CheckoutPageStep1();
		checkout.ClickOnContinue();
		Assert.assertEquals(driver.getCurrentUrl(), constant.Checkout_Page_URL);
	}
}