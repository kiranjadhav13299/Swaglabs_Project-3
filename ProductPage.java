
package com.swaglabs.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.swaglabs.base.BaseClass;
import com.swaglabs.utils.utils;

public class ProductPage extends BaseClass{
	WebElement AddToCartbtn;
	WebElement bagTitle;
	WebElement removeBtn;
	

	public ProductPage() throws IOException {
		super();
		this.AddToCartbtn = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		this.bagTitle = driver.findElement(By.xpath("//div[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]"));
		
	}
	
	public String verifyBackpackTitle() {
		
		return bagTitle.getText();
	}
	
	public String VerifyBagpackDescr () {
		WebElement bagDscr =driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]"));
		return bagDscr.getText();
		
	}
	
	public String VerifyBagpackPrice () {
		WebElement bagPrice = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]"));
		return bagPrice.getText();
		
	}
	public String VerifyBagpackImg() {
		WebElement bagImg = driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[1]/img"));
		return bagImg.getAttribute("src");
	}
	
	public void clickOnAddtoCartPP() {
		AddToCartbtn.click();
		
		
	}
	
	public void clickOnRemoveBtn() {
		AddToCartbtn.click();
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();;
		utils.waitForElementToDisappear(driver, "remove-sauce-labs-backpack", Duration.ofSeconds(3));
		
		
	}
}