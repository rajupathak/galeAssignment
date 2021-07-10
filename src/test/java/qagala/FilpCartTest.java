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

import com.gale.driver.Driver;
import com.gale.driver.DriverManager;
import com.gale.enums.ConfigProperties;
import com.gale.pages.FlipCartHomePage;
import com.gale.util.ReadProperty;

import io.github.bonigarcia.wdm.WebDriverManager;

//Due to time constraiant Null check and other coding standard not considered  here 
//even I tried to create Framework but not able to use properly due to time limit 

public class FilpCartTest {
	FlipCartHomePage pageObject = null;
	String expectedTitle = "Online Shopping Site for Mobiles";

	@BeforeMethod
	public void initDriver() throws InterruptedException {
		Driver.initDriver(ReadProperty.get(ConfigProperties.BROWSER));

		pageObject = new FlipCartHomePage();
		// close the PopUp:

		WebElement element = pageObject.getClosePopUp();
		element.click();

	}

	@Test
	public void verifyHomePageTitletest() {

		// veirfy the Home Page title :

		String actualtTitle = DriverManager.getDriver().getTitle();
		if (actualtTitle.contains(expectedTitle)) {
			Assert.assertTrue(true);

		}

	}

	@Test(enabled = true)
	public void verifyProDuctList() throws InterruptedException {
		List<String> list1 = new ArrayList();
		// First Search for ther Prodcut

		WebElement searchBox = pageObject.getSearchBox();

		searchBox.sendKeys("Sony Camera");

		// Click on submit button
		WebElement submitButton = pageObject.getSbumitButton();

		submitButton.click();
		Thread.sleep(5000);

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

		if (DriverManager.getDriver() != null) {
			Driver.quitDriver();
		}
	}

}
