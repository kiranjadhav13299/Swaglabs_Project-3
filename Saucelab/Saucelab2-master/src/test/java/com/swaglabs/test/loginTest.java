package com.swaglabs.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.swaglabs.base.BaseClass;
//import com.swaglabs.pages.InventoryPage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.utils.utils;




public class loginTest extends BaseClass {


	public loginTest() throws IOException {
		super();

	}
	
	LoginPage loginPage;



	@Test (dataProvider ="exceldata", dataProviderClass = excelData.class, priority = 1 )
	public void valuNamePass(String userName, String passWord) throws IOException, InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login(userName,passWord);
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

		utils.logOut(driver);
	}
	
	
	@Test(priority=3)
	public void invaliduName() throws IOException, InterruptedException {
		
		
		loginPage = new LoginPage(driver);
		loginPage.clearCredentials();
		Thread.sleep(1000);
		loginPage.invalidUsername();
		loginPage.errorMsg();
		Assert.assertEquals(loginPage.errorMsg(), "Epic sadface: Username and password do not match any user in this service");
}
	
	@Test(priority=4)
	public void invalidPass() throws IOException, InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.clearCredentials();
		Thread.sleep(1000);
		loginPage.invalidPassword();
		loginPage.errorMsg();
		Assert.assertEquals(loginPage.errorMsg(), "Epic sadface: Username and password do not match any user in this service");
		
	}
	
	@Test(priority=2 ,enabled =true)
	public void blankUnamePass() throws IOException, InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.clearCredentials();
		Thread.sleep(1000);
//		loginPage.clearCredentials();
		
		loginPage.blankUnamePass();
//		loginPage.errorMsg();
		loginPage.err();
		Assert.assertEquals(loginPage.err(), "Epic sadface: Username is required");
	}
	@Test(priority=5)
	public void blnkUnameValidPass() throws IOException, InterruptedException {
		driver.navigate().refresh();
		loginPage = new LoginPage(driver);
		loginPage.clearCredentials();
//		Thread.sleep(1000);
//		driver.navigate().refresh();
		loginPage.blankUnameavalPass();
		loginPage.err();
		Thread.sleep(1000);
		Assert.assertEquals(loginPage.err(), "Epic sadface: Username is required");
	}
	
	@Test(priority=6)
	public void validunameablankpass() throws InterruptedException, IOException {
		driver.navigate().refresh();
		loginPage = new LoginPage(driver);
		loginPage.clearCredentials();
//		Thread.sleep(1000);
//		driver.navigate().refresh();
		loginPage.validUnameablankPass();;
		loginPage.err();
		Thread.sleep(1000);
		Assert.assertEquals(loginPage.err(), "Epic sadface: Password is required");
	}
	
	@Test(priority = 7)
	public void lockedOutUser() throws IOException, InterruptedException{
		driver.navigate().refresh();
		loginPage = new LoginPage(driver);
		loginPage.clearCredentials();
		loginPage.lockedUser();
		loginPage.err();
		Thread.sleep(1000);
		Assert.assertEquals(loginPage.err(), "Epic sadface: Sorry, this user has been locked out.");
	}
	
}

	