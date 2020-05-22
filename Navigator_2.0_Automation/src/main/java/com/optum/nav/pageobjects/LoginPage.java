package com.optum.nav.pageobjects;

import static io.restassured.RestAssured.get;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.optum.nav.core.managers.ConfigManager;


public class LoginPage {

	public WebDriver driver = ConfigManager.browser();

	@FindBy(name = Elements.Email)
	private WebElement Email;

	@FindBy(id = Elements.Continue)
	private WebElement Continue;
	
	@FindBy(id = Elements.Password)
	private WebElement Password1;

	@FindBy(id = Elements.Login_Btn)
	private WebElement Login_Btn;

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}

	public void loginToApp(String userNmae, String Password) {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(Email));
		Email.clear();
		Email.sendKeys(userNmae);
		Continue.click();
		wait.until(ExpectedConditions.visibilityOf(Password1));
		Password1.clear();
		Password1.sendKeys(Password);
		Login_Btn.click();
	}
	
	public void checkAPI() {
		get("https://postman-echo.com/get?foo1=bar1&foo2=bar2").then().statusCode(200);
	}
	
}
