package com.optum.nav.core.managers;


import java.io.FileInputStream;
import java.util.Properties;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigManager {

	public static Properties properties = new Properties(); // Here we imported
															// Java.util
	public static String filepath;
	public static FileInputStream in;
	public static String URL;
	public static String Browser;
	public static WebDriver driver;
	public static String remoteURL;
	public static String userName;
	public static String password;
	public static String remote;

	

	public static WebDriver browser() {
		
		if(Boolean.valueOf(remote)==false) {
			if (Browser.equalsIgnoreCase("firefox")) {
				if(driver==null) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}
				else 
					return driver;			
			}
			else if (Browser.equalsIgnoreCase("ie")) {
				if(driver==null){
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
				}
				else 
					return driver;			
			}
			else if (Browser.equalsIgnoreCase("chrome")) {
				if(driver==null){
					WebDriverManager.chromedriver().setup();
					System.setProperty("webdriver.chrome.silentOutput", "true");
					driver = new ChromeDriver();
				}
				else 
					return driver;
			}		
		}
		else if (Boolean.valueOf(remote)==true) {
			if (Browser.equalsIgnoreCase("firefox")) {
				if(driver==null)
					driver = new RemoteWebDriver(DesiredCapabilities.firefox());
				else 
					return driver;			
			}
			else if (Browser.equalsIgnoreCase("ie")) {
				if(driver==null){
					driver = new RemoteWebDriver(DesiredCapabilities.internetExplorer());
				}
				else 
					return driver;			
			}
			else if (Browser.equalsIgnoreCase("chrome")) {
				if(driver==null)
					try {
						DesiredCapabilities capability = DesiredCapabilities.chrome();
						capability.setBrowserName("chrome");
						driver = new RemoteWebDriver(new URL("http://192.168.0.101:4444/wd/hub"),capability);
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else 
					return driver;
			}	
		return driver;
}

	static {
		try {
			 if (System.getProperty("EnvType")==null) {
				filepath = "src/test/resources/env/yatra-environment.properties";
				in = new FileInputStream(System.getProperty("user.dir") + "/"
						+ filepath);
				properties.load(in);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		URL = properties.getProperty("url");		
		Browser = properties.getProperty("Browser");		
		userName =properties.getProperty("username");
		password =properties.getProperty("password");
		remote = properties.getProperty("RemoteExecution");
	}

	public static String LoginURL() {
		Reporter.log("URL is "+URL, true);
		return URL;
	}

	public static String LoginUserNmae() {
		Reporter.log("userName is"+userName, true);
		return userName;
	}
	
	public static String LoginPassword() {
		Reporter.log("password is"+password, true);
		return password;
	}
}
