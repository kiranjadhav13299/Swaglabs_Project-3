/**
 * 
 */
package com.swaglabs.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.swaglabs.base.BaseClass;
import com.swaglabs.utils.utils;
//import com.swaglabs.pages.InventoryPage;

/**
 * 
 */
public class LoginPage extends BaseClass {
	private WebElement username;
	private WebElement password;
	private WebElement loginButton;
	private WebElement errorMessage;
//	private WebElement title;
	
//	String invalidUser = "abc";
//	String invalidPass = "hdsjds";	


	public void clearCredentials() {
		// Assuming "username" and "password" are WebElement fields in your LoginPage
		username.clear();
		password.clear();
	}

	public LoginPage(WebDriver driver) throws IOException {
		super();
		this.username = driver.findElement(By.id("user-name"));
		this.password = driver.findElement(By.id("password"));
		this.loginButton = driver.findElement(By.id("login-button"));
		this.errorMessage = driver.findElement(By.xpath("//div[@id='login_button_container']/div/form/div[3]"));
//		this.title = driver.findElement(By.xpath("//*[@id=\\\"item_4_title_link\\\"]/div"));

	}

	public void login(String uName, String pWord) throws InterruptedException {
//		driver.navigate().refresh();
		username.sendKeys(uName);
		password.sendKeys(pWord);
		Thread.sleep(1000);
		loginButton.click();



		//		return new InventoryPage(driver);
	}
	public void invalidUsername() {
		
		username.sendKeys("dbbd");
		password.sendKeys("secret_sauce");
		loginButton.click();
	}

	
	
	public void invalidPassword() {
		username.sendKeys("standard_user");
		password.sendKeys("bdsb");
		loginButton.click();
	}
	
	public void blankUnamePass () {
//		driver.get("url");
		username.sendKeys("");
		username.clear();
		password.sendKeys("");
		
		password.clear();
		utils.waitForElementPresent(driver, By.id("login-button"), Duration.ofSeconds(20));
		loginButton.click();
	}
	
	public void blankUnameavalPass() throws InterruptedException {
//		driver.navigate().refresh();
		username.clear();
		username.sendKeys("");
		password.sendKeys("secret_sauce");
		loginButton.click();
	}
	public void validUnameablankPass() throws InterruptedException {
//		driver.navigate().refresh();
		username.clear();
		username.sendKeys("standard_user");
		password.sendKeys("");
		loginButton.click();
	}
	
	public void lockedUser() {
		username.clear();
		username.sendKeys("locked_out_user");
		password.sendKeys("secret_sauce");
		loginButton.click();
	}
	
	public void test() {
		username.clear();
		username.sendKeys("problem_user");
		password.sendKeys("secret_sauce");
		loginButton.click();
	}
	
	
	public String errorMsg() {
		return errorMessage.getText();
	}
	
	public String err() {
		return errorMessage.getText();
		
	}
	
//	public void burgerMenu() {
//		WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
//		burgerMenu.click();
//	}
	
//	public String bagTitle() {
//		return title.getText();
//	}
	

}