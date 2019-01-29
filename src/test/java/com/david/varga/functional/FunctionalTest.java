package com.david.varga.functional;

import com.david.varga.pages.LandingPage;
import com.david.varga.pages.SuccessPage;
import com.david.varga.pages.element.CreditCard;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTest {

	private WebDriver driver;
	private CreditCard creditCard;
	private static final String _url = "http://ec2-52-31-37-213.eu-west-1.compute.amazonaws.com/";;

	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}

	@Before
	public void setup() {
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
		driver = null;
	}

	@Test
	public void testHappyPath() {
		driver.get(_url);

		creditCard = new CreditCard.Builder().ccNumber("2211441133112233")
				.ccName("Mr Brightside").ccMonth("09").ccYear("21").ccSecurityNumber("554").ccAmount(10.99).build();

		LandingPage landingPage = new LandingPage(driver, creditCard);
		landingPage.fillForm();

		SuccessPage successPage = new SuccessPage(driver);

		Assert.assertTrue("Success msg is not visible",
				successPage.isElementPresentWithTimeout(successPage.getSuccessMsgBy()));

	}

	@Test
	public void testShortCardNumber() {
		driver.get(_url);
		creditCard = new CreditCard.Builder().ccNumber("111122223333").build();

		LandingPage landingPage = new LandingPage(driver, creditCard);
		landingPage.sendFormNumber();

		landingPage.waitVisibility(landingPage.ccNumberAlertBy);
	}

	@Test
	public void testNoCardNumber() {
		driver.get(_url);
		creditCard = new CreditCard.Builder().build();

		LandingPage landingPage = new LandingPage(driver, creditCard);
		landingPage.sendFormNumber();

		landingPage.waitVisibility(landingPage.ccNumberAlertBy);
	}
	@Test
	public void testNoCardName() {
		driver.get(_url);
		creditCard = new CreditCard.Builder().ccNumber("1111222233334444").build();

		LandingPage landingPage = new LandingPage(driver, creditCard);
		landingPage.sendFormNumber();
		landingPage.sendFormName();

		landingPage.waitVisibility(landingPage.ccNameEmptyAlertBy);
	}

	@Test
	public void testNoCardSecurity() {
		driver.get(_url);
		creditCard = new CreditCard.Builder().ccNumber("1111222233334444").ccName("Mr Brightside").build();

		LandingPage landingPage = new LandingPage(driver, creditCard);
		landingPage.sendFormNumber();
		landingPage.sendFormName();
		landingPage.sendFormSecurity();

		landingPage.waitVisibility(landingPage.ccSecurityEmptyAlertBy);
	}

	@Test
	public void testShortCardSecurity() {
		driver.get(_url);
		creditCard = new CreditCard.Builder().ccNumber("1111222233334444")
				.ccName("Mr Brightside").ccSecurityNumber("1").build();

		LandingPage landingPage = new LandingPage(driver, creditCard);
		landingPage.sendFormNumber();
		landingPage.sendFormName();
		landingPage.sendFormSecurity();

		landingPage.waitVisibility(landingPage.ccSecurityShortAlertBy);

	}

	@Test
	public void testInvalidCardSecurity() {
		driver.get(_url);
		creditCard = new CreditCard.Builder().ccNumber("1111222233334444")
				.ccName("Mr Brightside").ccSecurityNumber("hey").build();

		LandingPage landingPage = new LandingPage(driver, creditCard);
		landingPage.sendFormNumber();
		landingPage.sendFormName();
		landingPage.sendFormSecurity();

		landingPage.waitVisibility(landingPage.ccSecurityInvalidAlertBy);

	}

	@Test
	public void testNoCardAmount() {
		driver.get(_url);
		creditCard = new CreditCard.Builder().ccNumber("1111222233334444")
				.ccName("Mr Brightside").ccSecurityNumber("222").build();

		LandingPage landingPage = new LandingPage(driver, creditCard);
		landingPage.sendFormNumber();
		landingPage.sendFormName();
		landingPage.sendFormSecurity();
		landingPage.sendFormAmount();

		landingPage.waitVisibility(landingPage.ccAMountEmptyAlertBy);
	}

	@Test
	public void testNegativeCardAmount() {
		driver.get(_url);
		creditCard = new CreditCard.Builder().ccNumber("1111222233334444")
				.ccName("Mr Brightside").ccSecurityNumber("222").ccAmount(-2).build();

		LandingPage landingPage = new LandingPage(driver, creditCard);
		landingPage.sendFormNumber();
		landingPage.sendFormName();
		landingPage.sendFormSecurity();
		landingPage.sendFormAmount();

		landingPage.waitVisibility(landingPage.ccAmountInvalidAlertBy);
	}

	@Test
	public void testDecimalsCardAmount() {
		driver.get(_url);
		creditCard = new CreditCard.Builder().ccNumber("1111222233334444")
				.ccName("Mr Brightside").ccSecurityNumber("222").ccAmount(2.455).build();

		LandingPage landingPage = new LandingPage(driver, creditCard);
		landingPage.sendFormNumber();
		landingPage.sendFormName();
		landingPage.sendFormSecurity();
		landingPage.sendFormAmount();

		landingPage.waitVisibility(landingPage.ccAmountInvalidAlertBy);
	}
}
