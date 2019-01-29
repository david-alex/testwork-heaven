package com.david.varga.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class FirefoxDriverTest {
	private WebDriver driver;

	@BeforeClass
	public static void setupClass() {
		WebDriverManager.firefoxdriver().setup();
	}

	@Before
	public void setupTest() {
		/*
		 * Note: Due to Incompatibility issues going on around Gecko Driver, Marionette and Firefox,
		 * setting marionette on or off may solve a problem,
		 * where the driver can not communicate with the actual browser instance
		 */
		FirefoxOptions firefoxOptions;

		try {
			System.setProperty("webdriver.firefox.marionette", "false");
			firefoxOptions = new FirefoxOptions().setLegacy(true);
			driver = new FirefoxDriver(firefoxOptions);
		} catch (UnreachableBrowserException e) {
			System.setProperty("webdriver.firefox.marionette", "true");
			firefoxOptions = new FirefoxOptions();
			driver = new FirefoxDriver(firefoxOptions);
		}


	}

	@After
	public void tearDown(){
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	@Test
	public void test(){
		driver.get("http://ec2-52-31-37-213.eu-west-1.compute.amazonaws.com/");
	}
}
