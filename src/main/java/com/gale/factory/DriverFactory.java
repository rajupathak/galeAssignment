package com.gale.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {
	private DriverFactory() {
	}

	public static WebDriver getDriver(String browser){

		WebDriver driver=null;

		if(browser.equalsIgnoreCase("chrome")) {
			
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			//	driver.findElement(By.xpath(""));)
			}
		
		else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		return driver;
}

}
