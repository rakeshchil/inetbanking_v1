package com.inetbanking.testcases;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void logintest() {
		
		Loginpage lp = new Loginpage(driver);
		
		lp.username1(username);
		lp.password1(password);
		lp.buttons();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}


}
