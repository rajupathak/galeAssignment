package com.gale.driver;

import java.util.Objects;

import com.gale.enums.ConfigProperties;
import com.gale.factory.DriverFactory;
import com.gale.util.ReadProperty;

public class Driver {

	/**
	 * Private constructor to avoid external instantiation
	 */
	private Driver() {
	}

	public static void initDriver(String browser) {
		if (Objects.isNull(DriverManager.getDriver())) {

			DriverManager.setDriver(DriverFactory.getDriver(browser));	
			DriverManager.getDriver().get(ReadProperty.get(ConfigProperties.URL));
			DriverManager.getDriver().manage().window().maximize();
		}
	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
