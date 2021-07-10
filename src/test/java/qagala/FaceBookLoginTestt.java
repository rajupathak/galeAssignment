package qagala;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gale.pages.FaceBookLoginPage;
import com.gale.util.ExCelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

//Due to time constraiant Null check and other coding standard not considered  here 
//even I tried to create Framework but not able to use properly due to time limit 

public class FaceBookLoginTestt {
	public WebDriver driver = null;
	FaceBookLoginPage pageObject = null;

	ExCelReader excelObject = new ExCelReader();

	@BeforeMethod
	public void initDriver() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		pageObject = new FaceBookLoginPage(driver);

	}

	@Test
	public void verifyHomePageTitletest() throws IOException {

		// getUsername From Excel Reader

		// Now Login to facebook

		String email = ExCelReader.getCellvalue(0, 1, 0);
		String password = ExCelReader.getCellvalue(0, 1, 1);
		pageObject.getEmail().sendKeys(email);
		pageObject.getEmail().sendKeys(password);

		pageObject.getLogin().click();
//print CurrentUrl
		System.out.println(driver.getCurrentUrl());
		// Print Hrader
		System.out.println(driver.getPageSource());
	}

	@AfterMethod
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}

}
