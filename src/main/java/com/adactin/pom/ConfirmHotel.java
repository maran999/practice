package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmHotel {

	public static WebDriver driver;
	
	@FindBy(id = "radiobutton_0")
	private WebElement confirm;
	
	@FindBy(id = "continue")
	private WebElement confirmAndContinue;

	public ConfirmHotel(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	public WebElement getConfirm() {
		return confirm;
	}

	public WebElement getConfirmAndContinue() {
		return confirmAndContinue;
	}
	
	
}
