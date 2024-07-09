package com.swaglabs.test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pages.InventoryPage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.ProductPage;
import com.swaglabs.utils.Constants;
import com.swaglabs.utils.utils;

public class productPageTest extends BaseClass {

	LoginPage loginPage;
	InventoryPage inventorypage;
	Constants constant;
	ProductPage prodPage;
	
	public productPageTest() throws IOException{
		super();
	}
	
	
  @Test
  public void ProdDetailsOnProdPage() throws IOException, InterruptedException {
	  loginPage = new LoginPage(driver);
	  loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	  inventorypage = new InventoryPage(driver);
	  inventorypage.clickOnprodTitle();
	  prodPage = new ProductPage();
	  String bagpackTitle =  prodPage.verifyBackpackTitle();
	  Assert.assertEquals(bagpackTitle, constant.Sauce_Labs_Backpack_Title);
	  String bagpackDsr = prodPage.VerifyBagpackDescr();
	  Assert.assertEquals(bagpackDsr, constant.Sauce_Labs_Backpack_desc);
	  String bagpackPrice = prodPage.VerifyBagpackPrice();
	  Assert.assertEquals(bagpackPrice, constant.Sauce_Labs_Backpack_Price);
	  String bagpackImg = prodPage.VerifyBagpackImg();
	  Assert.assertEquals(bagpackImg, constant.Sauce_Labs_Backpack_img);
	  
  }
  
  @Test
  public void AddToCartbackpack() throws InterruptedException, IOException{
	  loginPage = new LoginPage(driver);
	  loginPage.login(prop.getProperty("Username"), prop.getProperty("Password")); 
//	  prodPage = new ProductPage();
//	  prodPage.clickOnAddtoCartPP();
	  inventorypage = new InventoryPage(driver);
	  inventorypage.clickOnprodTitle();
	  String atcbtn = inventorypage.ClickonBagpackAddtoCartbtn();
	  Assert.assertEquals(atcbtn,constant.Sauce_Labs_Backpack_Title );
	  
  }
  
  @Test
  public void Removefromthecart() throws IOException, InterruptedException {
	  loginPage = new LoginPage(driver);
	  loginPage.login(prop.getProperty("Username"), prop.getProperty("Password")); 
	  inventorypage = new InventoryPage(driver); 
	  inventorypage.clickOnprodTitle();
	  prodPage = new ProductPage();
	  prodPage.clickOnRemoveBtn();
		Assert.assertTrue(utils.isElementPresent(By.id("add-to-cart-sauce-labs-backpack")));
	  
  }
}