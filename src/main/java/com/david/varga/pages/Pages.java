package com.david.varga.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pages {

	public WebDriver driver;
	public WebDriverWait wait;

	public Pages (WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver,15);
	}

	public void waitVisibility(By elementBy) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
	}

	public void click(By elementBy) {

		waitVisibility(elementBy);
		driver.findElement(elementBy).click();
	}

	public void writeText (By elementBy, String text) {
		waitVisibility(elementBy);
		WebElement element = driver.findElement(elementBy);
		element.clear();
		element.sendKeys(text);
		element.sendKeys(Keys.ENTER);
	}

	public String readText (By elementBy) {
		waitVisibility(elementBy);
		return driver.findElement(elementBy).getText();
	}

	public boolean isElementPresentWithTimeout(By elementBy) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
