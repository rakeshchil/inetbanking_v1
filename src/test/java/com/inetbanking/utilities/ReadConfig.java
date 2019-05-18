package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fi = new FileInputStream(src);
			pro = new Properties();
			pro.load(fi);
		}
		catch(Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
		
	}
	
	public String getApplicationURL() {
		String URL = pro.getProperty("baseURL");
		return URL;
	}
	
	public String getUserName() {
		String usernameq = pro.getProperty("username");
		return usernameq;
	}
	
	public String getPassWord() {
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
	public String getchromepath() {
		String chromes = pro.getProperty("chromepath");
		return chromes;
	}

	public String getFirefoxpath() {
		String firefoxes = pro.getProperty("firefoxpath");
		return firefoxes;
	}
}
