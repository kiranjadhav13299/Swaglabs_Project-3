package com.swaglabs.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.CheckOutPageStep2;
import com.swaglabs.utils.Constants;

public class CheckOutStep2Test extends BaseClass {
	CheckOutStep1Test step1;
	CheckOutPageStep2 step2;
	CartPage cart;
	Constants constant;



	public CheckOutStep2Test() throws IOException {
		super();

	}

	@Test
	public void VerifyProdDetails() throws IOException, InterruptedException {

		step1 = new CheckOutStep1Test();
		step1.EnterValidData();
		step2 = new CheckOutPageStep2();
		step2.prodDetailsOnchOut2();
	}


	@Test
	public void VerifyTotalAmount() throws IOException, InterruptedException {
		step1 = new CheckOutStep1Test();
		step1.EnterValidData();
		step2 = new CheckOutPageStep2();
		step2.vTotalAmount();
		Thread.sleep(5000);
	}
	@Test
	public void VerifyCancelPayment() throws IOException, InterruptedException {
		step1 = new CheckOutStep1Test();
		step1.EnterValidData();
		step2 = new CheckOutPageStep2();
		step2.cancelPayment();
		Assert.assertEquals(driver.getCurrentUrl(), constant.HomePageURL);
		
		
	}
	@Test 
	public void VerifyFinishPayment() throws IOException, InterruptedException {
		step1 = new CheckOutStep1Test();
		step1.EnterValidData();
		step2 = new CheckOutPageStep2();
		step2.FinishPayment();
		Assert.assertEquals(driver.getCurrentUrl(), constant.Finish_Url);
	}
}