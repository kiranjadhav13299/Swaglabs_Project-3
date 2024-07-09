package com.swaglabs.test;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.swaglabs.base.BaseClass;
import com.swaglabs.pages.InventoryPage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.Constants;
import com.swaglabs.utils.utils;

public class InventoryTest extends BaseClass {

	public InventoryTest() throws IOException {
		super();
	}
	
	LoginPage loginPage;
	InventoryPage inventorypage;
	Constants constant;
	


	@Test()
	public void verifySauceLabsBackpackTitle() throws IOException, InterruptedException {

		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"),prop.getProperty("Password"));
		inventorypage = new InventoryPage(driver);
		String bagpackTitle = inventorypage.verifyBackpackTitle();
		Assert.assertEquals(bagpackTitle, constant.Sauce_Labs_Backpack_Title);
		String bagpackDiscr = inventorypage.VerifyBagpackDescr();
		Assert.assertEquals(bagpackDiscr, constant.Sauce_Labs_Backpack_desc);
		String bagpackPrice = inventorypage.VerifyBagpackPrice();
		Assert.assertEquals(bagpackPrice, constant.Sauce_Labs_Backpack_Price);
		String bagpackImg = inventorypage.VerifyBagpackImg();
		Assert.assertEquals(bagpackImg, constant.Sauce_Labs_Backpack_img);
		utils.logOut(driver);
	}


	
	//	@Test
	@Test()
	public void VerifydropdownAtoZ() throws IOException, InterruptedException{
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"),prop.getProperty("Password"));
		inventorypage = new InventoryPage(driver);
		String dropdown = inventorypage.VerifyDropdown();
		Assert.assertEquals(dropdown,constant.drvalueAtoZ );
		utils.logOut(driver);
		}

	@Test ()
	public void VerifyDdPriceLowToHigh() throws IOException, InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"),prop.getProperty("Password"));
		inventorypage = new InventoryPage(driver);
		String actualPrice = inventorypage.VerifyPriceLowTOHigh();
		Assert.assertEquals(actualPrice, constant.drPriceLtoH);
		utils.logOut(driver);

	}


	@Test ()
	public void selectName_zTOA_fromDD() throws IOException, InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"),prop.getProperty("Password"));
		inventorypage = new InventoryPage(driver);
		String actualTitle = inventorypage.VerifyDdZtoA();
		Assert.assertEquals(actualTitle, constant.redTshirtTitle);
		utils.logOut(driver);
	}

	@Test()
	public void clikOnProductTitle() throws IOException, InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"),prop.getProperty("Password"));
		inventorypage = new InventoryPage(driver);
		String actualUrl= inventorypage.clickOnprodTitle();
		Assert.assertEquals(actualUrl, constant.BagpackUrl);
		utils.logOut(driver);
	}

	@Test ()
	public void testbagpackAddToCart() throws IOException, InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"),prop.getProperty("Password"));
		inventorypage = new InventoryPage(driver);
		String title = inventorypage.ClickonBagpackAddtoCartbtn();
		Assert.assertEquals(title,constant.Sauce_Labs_Backpack_Title );
		utils.logOut(driver);
	}

	@Test
	public void clickOnRemoveBtn() throws InterruptedException, IOException {
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"),prop.getProperty("Password"));
		inventorypage = new InventoryPage(driver);
		inventorypage.clickOnAddToCartbtn();
		inventorypage.clickOnremoveBtn();
		utils.waitForElementToDisappear(driver, "remove-sauce-labs-backpack", Duration.ofSeconds(20));
		Assert.assertTrue(utils.isElementPresent(By.id("add-to-cart-sauce-labs-backpack")));
	}
	
	@Test
	public void clickOnburgerMenu() throws IOException, InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"),prop.getProperty("Password"));
		inventorypage = new InventoryPage(driver);
		inventorypage.burgerMenu();
		Assert.assertTrue(utils.isElementPresent(By.className("bm-menu-wrap")));
		
		
	}
	
	@Test
	public void clickOnCartLogo() throws IOException, InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login(prop.getProperty("Username"),prop.getProperty("Password"));
		inventorypage = new InventoryPage(driver);
		inventorypage.clickCartlogo();
		String cUrl = driver.getCurrentUrl();
		Assert.assertEquals(cUrl,constant.cartUrl);
	}
}