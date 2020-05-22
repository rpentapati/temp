package com.optum.nav.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.optum.nav.core.managers.ConfigManager;
import com.optum.nav.core.util.ExcelReader;

public class HomePage {

	public WebDriver driver = ConfigManager.browser();
	WebDriverWait wait = new WebDriverWait(driver,10);
	public ExcelReader read;
	
	@FindBy(xpath = Elements.SignInButton)
	private WebElement signInButton;

	@FindBy(xpath = Elements.ShoppingCart)
	private WebElement shoppingCart;

	@FindBy(css = Elements.Search_Btn)
	private WebElement Search_Btn;

	@FindBy(id = Elements.Login_Btn)
	private WebElement Login_Btn;

	@FindBy(id = Elements.SearchBox)
	private WebElement SearchBox;

	@FindBy(xpath = Elements.ResultsDisplayed)
	private WebElement ResultsDisplayed;

	@FindBy(css = Elements.AddToCart)
	private WebElement addToCart;
	
	@FindBy(xpath = Elements.proceedToCheckout)
	private WebElement proceedToCheckout;	
	
	@FindBy(css = Elements.productList)
	private List<WebElement> productList;

	
	@FindBy(id = Elements.seeAllBuyingOption)
	private WebElement seeAllBuyingOptions;

	public HomePage() {

		PageFactory.initElements(driver, this);
		read = new ExcelReader();
	}

	public void shoppingCart() {
		Assert.assertTrue(shoppingCart.isDisplayed());
		shoppingCart.click();
	}
	
	public void loginLink() {
		signInButton.click();
		signInButton.getText();
	}

	public void searchProduct(String product){
		
		SearchBox.sendKeys(product);
		Search_Btn.click();
	}
	
	public boolean validateResults(){
		
		wait.until(ExpectedConditions.visibilityOf(ResultsDisplayed));
		Assert.assertTrue(ResultsDisplayed.isDisplayed());
		return true;
	}
	
	public void clickAddToCart() {	
		int noOfProducts = productList.size();
		int random = (int)(Math.random()* noOfProducts);
		System.out.println("Random product index is " + random);
		Actions action = new Actions(driver);
		action.moveToElement(productList.get(random)).build().perform();
		action.click(productList.get(random)).build().perform();
		wait.until(ExpectedConditions.visibilityOf(seeAllBuyingOptions));
		seeAllBuyingOptions.click();
		
		wait.until(ExpectedConditions.visibilityOf(addToCart));
		Assert.assertTrue(addToCart.isDisplayed());
		addToCart.click();
	}
	
	public void proceedToCheckout() {
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
		proceedToCheckout.click();
	}

}
