package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver ldriver;
	public Loginpage(WebDriver rdriver){
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(name="uid")
	WebElement txtusername;
	
	@FindBy(name = "password")
	WebElement txtpassword;
	
	@FindBy(name = "btnLogin")
	WebElement button1;
	
	public  void username1(String uname) {
		txtusername.sendKeys(uname);
	}
	
	public void password1(String passwd) {
		txtpassword.sendKeys(passwd);
	}
	
	public void buttons() {
		button1.click();
	}

}
