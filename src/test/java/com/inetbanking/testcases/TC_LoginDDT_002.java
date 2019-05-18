package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.Loginpage;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user,String pass) {
		Loginpage lp = new Loginpage(driver);
		lp.username1(user);
		lp.password1(pass);
		lp.buttons();
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			lp.logout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	
	public boolean isAlertPresent()
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
		
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		
		String path = System.getProperty("user.dir")+"src//test//java//com//inetbanking//testdata//Maven9.xlsx";
		int rownum =XLUtils.getrow(path, "sheet1");
		int colnum=XLUtils.getcol(path, "sheet1", 1);
		String logindata[][]=new String[rownum][colnum];
		for(int i=1;i<rownum;i++) {
			for(int j=0;j<colnum;j++) {
				logindata[i-1][j]=XLUtils.getcelldata(path, "sheet1", i, j);
			}
		}
		return logindata;
	}
	

}
