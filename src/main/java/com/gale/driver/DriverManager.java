package com.gale.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	private DriverManager() {
	}

	public static WebDriver getDriver() {
		return dr.get();
	}

	private static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

	static void setDriver(WebDriver driverref) {
		if (Objects.nonNull(driverref)) {
			dr.set(driverref);
		}
	}

	static void unload() {
		dr.remove();
	}
}
