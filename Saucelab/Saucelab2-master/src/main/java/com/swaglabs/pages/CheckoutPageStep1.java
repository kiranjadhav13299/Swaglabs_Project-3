package com.swaglabs.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.swaglabs.base.BaseClass;

public class CheckoutPageStep1 extends BaseClass {
	WebElement firstNameField;
	WebElement lastNameField;
	WebElement zipCodeField;
	WebElement continueButton;
	WebElement errorMessage;
	WebElement cancelBtn;
	
    
	
	public CheckoutPageStep1() throws IOException {
		super();
		this.firstNameField = driver.findElement(By.id("first-name"));
		this.lastNameField = driver.findElement(By.id("last-name"));
		this.zipCodeField = driver.findElement(By.id("postal-code"));
		this.cancelBtn = driver.findElement(By.id("cancel"));
		this.continueButton = driver.findElement(By.id("continue"));
//		this.errorMessage = driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3"));
		
		
	}
	
	public void EnterValidData() {
		firstNameField.sendKeys("pratik");
		lastNameField.sendKeys("Godbole");
		zipCodeField.sendKeys("421601");
		continueButton.click();
	}
	
	public void keepAllfieldsBlank() {
		firstNameField.sendKeys("");
		lastNameField.sendKeys("");
		zipCodeField.sendKeys("");
		continueButton.click();
	}
	
	public void KeepFirstNameBlank() {
		firstNameField.sendKeys("");
		lastNameField.sendKeys("Godbole");
		zipCodeField.sendKeys("421601");
		continueButton.click();
	}
	
	public void keepLastNameBlank() {
		firstNameField.sendKeys("pratik");
		lastNameField.sendKeys("");
		zipCodeField.sendKeys("421601");
		continueButton.click();
	}
	
	public void KeepZipCodeBlank() {
		firstNameField.sendKeys("pratik");
		lastNameField.sendKeys("Godbole");
		zipCodeField.sendKeys("");
		continueButton.click();
		
	}
	
	public void EnterspecialCharInZipCode() {
		firstNameField.sendKeys("pratik");
		lastNameField.sendKeys("Godbole");
		zipCodeField.sendKeys("@#$");
		continueButton.click();
	}
	
	public void cancelCheckOut() {
		cancelBtn.click();
	}
	
	public void ClickOnContinue() {
		firstNameField.sendKeys("pratik");
		lastNameField.sendKeys("Godbole");
		zipCodeField.sendKeys("421601");
		continueButton.click();
	}
	
	public String errorMsg() {
		errorMessage = driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3"));
		return errorMessage.getText();
	}
	
}
