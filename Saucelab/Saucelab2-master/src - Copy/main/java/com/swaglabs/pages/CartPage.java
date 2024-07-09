package com.swaglabs.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.swaglabs.base.BaseClass;
import com.swaglabs.utils.Constants;

public class CartPage extends BaseClass{
	
	InventoryPage inventoryPage;
	Constants constant;
	WebElement actualTitle;
	WebElement actualDescription;
	WebElement actualPrice;
	WebElement RemoveBtnCart;
	WebElement CartBadge;
	WebElement ContinueShopping;
	WebElement checkout;
	

	
	public CartPage() throws IOException {
		super();
		this.actualTitle = driver.findElement(By.xpath("//*[@id='item_4_title_link']/div"));
		this.actualDescription = driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]"));
		this.actualPrice =driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div"));
		this.RemoveBtnCart = driver.findElement(By.id("remove-sauce-labs-backpack"));
		this.CartBadge = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span"));
		this.ContinueShopping = driver.findElement(By.id("continue-shopping"));
		this.checkout = driver.findElement(By.id("checkout"));
	}
	
	public void prodDetailsInCart() throws IOException {
		verifyTitle();
		verifyDescription();
		verifyPrice();
		
	}
	 public String verifyTitle() {
	        String Title = actualTitle.getText();
	        Assert.assertEquals(Title, constant.Sauce_Labs_Backpack_Title, "Title verification failed");
			return Title;
	    }
	    
	    // Method to verify product description
	 private void verifyDescription() {
	       
	        String Desc = actualDescription.getText() ; // code to retrieve description
	        Assert.assertEquals(Desc,constant.Sauce_Labs_Backpack_desc, "Description verification failed");
	    }
	    
	    // Method to verify product price
	    public void verifyPrice() {
	        // Locate price element and retrieve text
	        String Price = actualPrice.getText() ; // code to retrieve price
	        Assert.assertEquals(Price, constant.Sauce_Labs_Backpack_Price , "Price verification failed");
	    }
	    
	    public void removeProdFromCartPage() throws IOException {
	    	
	    	RemoveBtnCart.click();
	    	
	    }
	    
	    public String checkCartBadge() {
	    	return CartBadge.getText();
	    	
	    	
	    }
	    
	    
	    public void clickOnContinue() {
	    	ContinueShopping.click();
	    }
	    
	    public void clickonCheckOut() {
	    	checkout.click();
	    }
	    
}