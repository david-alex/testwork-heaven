package com.david.varga.pages;

import com.david.varga.pages.element.CreditCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends Pages {

	private CreditCard creditCard;
	private By numberBy = By.id("credit_card_number");
	private By nameBy = By.id("nameOnTheCard");
	private By monthBy = By.id("expiryDateM");
	private By yearBy = By.id("expiryDateY");
	private By securityBy = By.id("csc");
	private By amountBy = By.id("amount");
	private By submitBy = By.id("submitBtn");

	public By ccNumberAlertBy = By.xpath("//small[contains(text(),'Invalid card number')]");
	public By ccNameEmptyAlertBy = By.xpath("//small[contains(text(),'Name on card should not be empty')]");
	public By ccSecurityEmptyAlertBy = By.xpath("//small[contains(text(),'CSC value should not be empty')]");
	public By ccSecurityShortAlertBy = By.xpath("//small[contains(text(),'CSC length is incorrect') and (@class='help-block')]");
	public By ccSecurityInvalidAlertBy = By.xpath("//small[contains(text(),'CSC should contain only numeric characters') and (@class='help-block')]");
	public By ccAMountEmptyAlertBy = By.xpath("//small[contains(text(),'Amount cannot be empty')]");
	public By ccAmountInvalidAlertBy = By.xpath("//small[contains(text(),'Please enter a value with no more than 2 decimal figures') and (@data-bv-validator='regexp')]");

	public LandingPage(WebDriver driver, CreditCard creditCard) {
		super(driver);
		this.creditCard = creditCard;
	}


	public void sendFormNumber() {
		writeText(numberBy, creditCard.getCcNumber());
	}

	public void sendFormName() {
		writeText(nameBy, creditCard.getCcName());
	}

	public void sendFormMonth() {
		writeText(monthBy, creditCard.getCcMonth());
	}

	public void sendFormYear() {
		writeText(yearBy, creditCard.getCcYear());
	}

	public void sendFormSecurity() {
		writeText(securityBy, creditCard.getCcSecurityNumber());

		//workaround for no validation on security input's keypress
		click(By.xpath("//body"));
	}

	public void sendFormAmount() {
		writeText(amountBy, creditCard.getCcAmount());

		//workaround for no validation on amount input's keypress
		click(By.xpath("//body"));

	}

	public void clickSubmit() {
		click(submitBy);
	}

	public void fillForm() {
		sendFormNumber();
		sendFormName();
		sendFormMonth();
		sendFormYear();
		sendFormSecurity();
		sendFormAmount();

		clickSubmit();
	}

}
