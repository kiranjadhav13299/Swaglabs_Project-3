package com.swaglabs.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.swaglabs.base.BaseClass;
import com.swaglabs.utils.Constants;

public class CheckOutPageStep2 extends BaseClass {
	InventoryPage inventoryPage;
	Constants constant;
	
	WebElement actualTitle;
	WebElement Tax;
	WebElement Total;
	WebElement cancel;
	WebElement finish;
	
	public CheckOutPageStep2() throws IOException{
		super();
		this.actualTitle = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
		this.actualDescription = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[1]"));
		this.actualPrice =driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div"));
		this.itemTotal = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]"));
		this.Tax = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]"));
		this.Total = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]"));
		this.cancel = driver.findElement(By.id("cancel"));
		this.finish = driver.findElement(By.id("finish"));
	}
	
	public void prodDetailsOnchOut2() throws IOException {
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
	    
	    public void vTotalAmount() {
	    String itemtotal =itemTotal.getText();
	    String tax = Tax.getText();
	    String total =  Total.getText();
	    double intemprice =parsePrice(itemtotal);
	    double taxprice = parsePrice(tax);
	    double addition = intemprice+taxprice;
	    double totalprice = parsePrice(total);
	    Assert.assertEquals(addition, totalprice);
	    
	    }
	    
	    public  void cancelPayment() {
	    	cancel.click();
	    }
	    
	    public void FinishPayment() {
	    	finish.click();
	    }
	    
	    private double parsePrice(String text) {
	        // Assuming the text format is "Label: $XX.XX"
	        String priceString = text.replaceAll("[^\\d.]", ""); // Remove all non-digit and non-decimal point characters
	        return Double.parseDouble(priceString);
	    }
}