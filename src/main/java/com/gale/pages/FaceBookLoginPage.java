package com.gale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookLoginPage {

	@FindBy(id = "email")
	private WebElement email;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(name = "login")
	private WebElement loginButton;

	public FaceBookLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
}
