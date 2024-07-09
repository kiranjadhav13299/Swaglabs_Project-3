package com.swaglabs.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.swaglabs.base.BaseClass;

public class CheckOutCompletePage extends BaseClass {
	
	WebElement thankUmsg;
	WebElement OrderMsg;
	WebElement backHome;
	
	public CheckOutCompletePage() throws IOException {
		super();
		this.thankUmsg = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
		this.OrderMsg = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/div"));
		this.backHome = driver.findElement(By.id("back-to-products"));
	}
	
	public String VerifyOrderMsg() {
		return OrderMsg.getText();
	}
	public String VerifythankUmsg() {
		return thankUmsg.getText();
	}
	public void clickOnbackHomebtn() {
		backHome.click();
	}

}