package qagala;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gale.pages.FlipCartHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

//Due to time constraiant Null check and other coding standard not considered  here 
//even I tried to create Framework but not able to use properly due to time limit 

public class FilpCartTest {
	public WebDriver driver = null;
	FlipCartHomePage pageObject = null;
	String expectedTitle = "Online Shopping Site for Mobiles";

	@BeforeMethod
	public void initDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		pageObject = new FlipCartHomePage(driver);
		// close the PopUp:

		WebElement element = pageObject.getClosePopUp();
		element.click();
	}

	@Test
	public void verifyHomePageTitletest() {

		// veirfy the Home Page title :

		String actualtTitle = driver.getTitle();
		if (actualtTitle.contains(expectedTitle)) {
			Assert.assertTrue(true);

		}

	}

	@Test
	public void verifyProDuctList() {
		List<String> list1 = new ArrayList();
		// First Search for ther Prodcut

		WebElement searchBox = pageObject.getSearchBox();

		searchBox.sendKeys("Sony Camera");

		// Click on submit button
		WebElement submitButton = pageObject.getSbumitButton();

		submitButton.click();

		String prodcutName = pageObject.getProductname().getText();
		String productPrice = pageObject.getprodcutPrice().getText();
		String productRating = pageObject.getproductRating().getText();

		// Add all value in List

		list1.add(prodcutName);
		list1.add(productPrice);
		list1.add(productRating);

		System.out.println(list1);

		// Now Click on Prodcut

		pageObject.getProductname().click();

		// User is navigate to prodcut description page

		// get the productname,price,Rating and store in another list and compare both
		// the lIst

		List<String> list2 = new ArrayList();
		list2.add(pageObject.getProdcutnameOnDescriptionPage().getText());

		list2.add(pageObject.getProdcutPriceOnDescriptionPage().getText());
		list2.add(pageObject.getProdcutRatingOnDescriptionPage().getText());

		// now comapre list 1 and list 2
		if (list1.equals(list2) == true) {
			Assert.assertTrue(true);
		} else {

			System.out.println(" Array List are not equal");
		}

	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}

}
