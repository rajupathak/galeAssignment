package com.gale.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gale.driver.DriverManager;

public class FlipCartHomePage {

	// All the below Xpath are just for an exmaple and consedering there is no
	// Iframe in the page and due to time constraint i have not considered css and
	// dynamic xpath this is just for eaxmple

	
	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2doB4z']")
	private WebElement closePupUp;
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement serchBox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitButton;

	@FindBy(xpath = "(//div[@class='col col-7-12'])[1]/div[1]")
	private WebElement prodcutName;

	@FindBy(xpath = "((//div[@class='_25b18c'])[1]/div[1]")
	private WebElement prodcutPrice;

	@FindBy(xpath = "(//div[@class='_3LWZlK'])[1]")
	private WebElement ratings;
	
	//Product name  on Description page:
		@FindBy(xpath = "(//span[@class='B_NuCI']")
		private WebElement prodcutnameOnDescriptionPage;
		
	//Price on Description page:
	@FindBy(xpath = "(//div[@class='_30jeq3 _16Jk6d']")
	private WebElement prodcutPriceOnDescriptionPage;
	
	//Rating On Description page:
	@FindBy(xpath = "//div[@class='_3LWZlK']")
	private WebElement prodcutRatingonnDescriptionPage;
	

	public FlipCartHomePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public WebElement getClosePopUp() {
		return closePupUp;
	}
	
	public WebElement getSearchBox() {
		return serchBox;
	}

	public WebElement getSbumitButton() {
		return submitButton;
	}

	public WebElement getProductname() {
		return prodcutName;
	}

	public WebElement getprodcutPrice() {
		return prodcutPrice;
	}

	public WebElement getproductRating() {
		return ratings;
	}
	
	
	public WebElement getProdcutPriceOnDescriptionPage() {
		return prodcutPriceOnDescriptionPage;
	}
	
	public WebElement getProdcutRatingOnDescriptionPage() {
		return prodcutRatingonnDescriptionPage;
	}
	
	public WebElement getProdcutnameOnDescriptionPage() {
		return prodcutnameOnDescriptionPage;
	}
}
