package com.inetbanking.testcases;

import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	
	public   String baseURL  = readconfig.getApplicationURL();
	public   String username = readconfig.getUserName();
	public   String password = readconfig.getPassWord() ;
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.prpoperties");
		
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
		driver = new ChromeDriver();
		}
		
		else if(br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}
		
		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.prpoperties");
		driver.get(baseURL);
	}
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
