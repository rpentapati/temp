package com.optum.nav.pageobjects;


public class Elements {
	//public static final String Signin = "#nav-tools [data-nav-role='signin']";
	public static final String SignInButton = "//div[@id='nav-signin-tooltip']//a[@data-nav-role='signin']";
	public static final String Email = "email";
	public static final String Continue = "continue";
	public static final String Password = "ap_password";
	public static final String Login_Btn = "signInSubmit";
	
	
	
	// Locators for login page
	public static final String Search_Btn = "[type=\"submit\"]";
	public static final String SearchBox = "twotabsearchtextbox";
	public static final String ResultsDisplayed = "//div[contains(@class,\"sg-col-14-of-20\")]//div[contains(@class,'a-section')]";
	public static final String ShoppingCart = "//*[@id='shopping_cart']/a";
	public static final String AddToCart = "input[name=\"submit.addToCart\"]";
	public static final String proceedToCheckout ="//a[contains(text(),'Proceed to checkout')]";
	public static final String productList = "span[data-component-type='s-product-image'] a div img";
	public static final String seeAllBuyingOption = "buybox-see-all-buying-choices-announce";
}
