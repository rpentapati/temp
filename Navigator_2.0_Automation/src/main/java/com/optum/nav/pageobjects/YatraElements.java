package com.optum.nav.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YatraElements {
	//public static final String Signin = "#nav-tools [data-nav-role='signin']";
	
	public static final String roundTrip = "a[title='Round Trip']";
	public static final String originCityTextBox = "BE_flight_origin_city";
	public static final String originCityMumbai = "//*[@class='ac_results origin_ac']//*[contains(text(),'Mumbai')]";
	public static final String destCityNewDelhi ="//*[@class='ac_results dest_ac']//*[contains(text(),'New Delhi')]";
	
	public static final String originDate = "BE_flight_origin_date";
	public static final String departureDate = "BE_flight_arrival_date";
	
	
	
}
