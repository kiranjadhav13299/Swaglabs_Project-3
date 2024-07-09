package com.swaglabs.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.base.BaseClass;
import com.swaglabs.pages.CheckOutCompletePage;
import com.swaglabs.utils.Constants;

public class CheckOutFinalTest extends BaseClass {
	 CheckOutStep2Test step2;
	 CheckOutCompletePage complete;
	 Constants constant;
	 
  public CheckOutFinalTest() throws IOException {
	 
	  super();	
	}

@Test
  public void VerifyThankUAndOrderMsg() throws IOException, InterruptedException {
	step2 = new CheckOutStep2Test();
	step2.VerifyFinishPayment();
	complete = new CheckOutCompletePage();
	complete.VerifythankUmsg();
	String thankU = complete.VerifythankUmsg();
	Assert.assertEquals(thankU, constant.thankUmsg);
	String orderMsg = complete.VerifyOrderMsg();
	Assert.assertEquals(orderMsg, constant.orderMsg);
  }
	@Test
	public void clickOnBackHome() throws IOException, InterruptedException {
		step2 = new CheckOutStep2Test();
		step2.VerifyFinishPayment();
		complete = new CheckOutCompletePage();
		complete.clickOnbackHomebtn();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getCurrentUrl(), constant.HomePageURL);
	}
}