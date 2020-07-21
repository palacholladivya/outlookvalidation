package com.simple.test;

import org.openqa.selenium.WebDriver;
import cucumber.api.java.After;

public class Hooks {

	private static WebDriver driver;
	
	public Hooks(WebDriver driver) {
		this.driver = driver;
	}

	@After()
	public void tearDown() {
		// clearing down driver object
		if (driver != null) {
			driver.close();
		}
	}
}
