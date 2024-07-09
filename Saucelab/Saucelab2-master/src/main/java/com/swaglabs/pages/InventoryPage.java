package com.swaglabs.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.swaglabs.base.BaseClass;
import com.swaglabs.utils.utils;

public class InventoryPage extends BaseClass {
	private WebElement BagpackTitle;
	private WebElement BagpackDesc;
	private WebElement BagpackPrice;
	private WebElement Bagpackimg;
	private WebElement BagpackAddtoCart;
	private WebElement dropdown;
	private WebElement RemoveButton;
	private WebElement addToCartButton;
	private WebElement cartLogo;
	Select select;
	

	public InventoryPage(WebDriver driver) throws IOException {
		super();
		}
	
	public String verifyBackpackTitle() {
		WebElement bagTitle = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
		return bagTitle.getText();
	}
	
	public String VerifyBagpackDescr () {
		WebElement bagDscr =driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[1]/div"));
		return bagDscr.getText();
		
	}
	
	public String VerifyBagpackPrice () {
		WebElement bagPrice = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div"));
		return bagPrice.getText();
		
	}
	public String VerifyBagpackImg() {
		WebElement bagImg = driver.findElement(By.xpath("//a[@id=\"item_4_img_link\"]//img"));
		return bagImg.getAttribute("src");
	}
	
	public String VerifyDropdown() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.className("product_sort_container"));
		dropdown.click();
		select = new Select(dropdown);
		WebElement preselectedOption = select.getFirstSelectedOption();
		String preselectedValue = preselectedOption.getText();
		
		Thread.sleep(1000);
		
		return preselectedValue;
		
	}
	
	public String VerifyPriceLowTOHigh() {
		String expectedValue = "Price (low to high)";

		Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
		
		 dropdown.selectByVisibleText(expectedValue);
		 WebElement price = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div")) ;
			String actualPrice =price.getText();
		return actualPrice;
	}
	
	public String VerifyDdZtoA() {
		String expectedValue = "Name (Z to A)";
		Select dropdown = new Select(driver.findElement(By.className("product_sort_container")));
		dropdown.selectByVisibleText(expectedValue);
		WebElement title = driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div"));
		String actualTitle = title.getText();
		return actualTitle;
	}
	
	public String clickOnprodTitle() throws InterruptedException {
		WebElement bagTitle = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
		bagTitle.click();
		Thread.sleep(1000);
		String actualUrl = driver.getCurrentUrl();
		return actualUrl;
		
	}
	
	public String ClickonBagpackAddtoCartbtn() throws InterruptedException {
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		
		addToCartButton.click();

		WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
		String expectedButtonText = "Remove";
		Assert.assertEquals(removeButton.getText(), expectedButtonText);
		Thread.sleep(1000);
		utils.addToCart(driver);
			
		WebElement titleOfproductincart = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
		String title = titleOfproductincart.getText();
		return title;
	}
	public void clickOnAddToCartbtn() {
		WebElement addToCartButton =utils.waitForElementPresent(driver, By.id("add-to-cart-sauce-labs-backpack"), Duration.ofSeconds(20));
		addToCartButton.click();
	}
	
	public void clickonAddToCart2ndProd() {
		WebElement addToCartButton =utils.waitForElementPresent(driver, By.id("add-to-cart-sauce-labs-bike-light"), Duration.ofSeconds(20));
		addToCartButton.click();
	}
	
	public void clickOnremoveBtn() {
		WebElement Removebtn1 =utils.waitForElementPresent(driver, By.id("remove-sauce-labs-backpack"), Duration.ofSeconds(20));
		Removebtn1.click();
	}
	
	public void burgerMenu() {
		WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
		burgerMenu.click();
	}
	
	
	
	public void clickRemove() throws InterruptedException {
		addToCartButton =utils.waitForElementPresent(driver, By.id("add-to-cart-sauce-labs-backpack"), Duration.ofSeconds(5));
		addToCartButton.click();
		
//		Thread.sleep(1000);
		
	}
	
	public void clickCartlogo() {
		cartLogo = utils.waitForElementPresent(driver, By.className("shopping_cart_link"), Duration.ofSeconds(5));
		cartLogo.click();
		
	}
}