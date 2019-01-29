package com.david.varga.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SuccessPage extends Pages {
	public SuccessPage(WebDriver driver) {
		super(driver);
	}
	private By successMsgBy = By.xpath("//div[@class='bvt-modal-body bvt-success-text']");

	public By getSuccessMsgBy() {
		return successMsgBy;
	}
}
