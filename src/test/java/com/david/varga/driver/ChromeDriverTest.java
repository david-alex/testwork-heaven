package com.david.varga.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverTest {

	private WebDriver driver;

	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@Before
	public void setupTest() {
		driver = new ChromeDriver();
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

		Assert.assertTrue("URL of the browser doenst match the expected",
				driver.getCurrentUrl().equalsIgnoreCase("http://ec2-52-31-37-213.eu-west-1.compute.amazonaws.com/"));

	}
}
