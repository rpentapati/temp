package com.optum.nav.core.util;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.optum.nav.core.managers.ConfigManager;

//this class is were we will use all the reuseable functions e.g getwindow handle.

public class CommonUtil {
	public WebDriver driver = ConfigManager.browser(); // This will read the
												// configuration.java >
												// Gets the webdriver
												// instance

	public void getWindowHandle() {
		Set<String> handles = driver.getWindowHandles();// We will use this if
														// windows is greater
														// than 1 - otherwise we
														// just getwindowhandle
														// ();
		if (handles.size() >= 1) {
			System.out.println("Number of broiwsers opened are"
					+ handles.size());
			for (String handle : handles) {
				driver.switchTo().window(handle);

			}
		}

	}

	public void enterdata(WebElement e, String data) {

		e.sendKeys(data);
	}

}
