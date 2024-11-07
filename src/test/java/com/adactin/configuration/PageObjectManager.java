package com.adactin.configuration;

import org.openqa.selenium.WebDriver;

import com.adactin.pom.BookHotel;
import com.adactin.pom.ConfirmHotel;
import com.adactin.pom.LoginPage;
import com.adactin.pom.LogoutPage;
import com.adactin.pom.SearchHotel;

public class PageObjectManager {

	public static WebDriver driver;

	private LoginPage login;

	private SearchHotel search;

	private ConfirmHotel confirm;

	private BookHotel book;

	private LogoutPage logout;

	public PageObjectManager(WebDriver driver2) {
		this.driver = driver2;
	}

	public LoginPage getInstanceLoginPage() {
		login = new LoginPage(driver);
		return login;
	}

	public SearchHotel getInstanceSearchHotel() {
		search = new SearchHotel(driver);
		return search;

	}

	public ConfirmHotel getInstanceConfirmHotel() {
		confirm = new ConfirmHotel(driver);
		return confirm;

	}

	public BookHotel getInstanceBookHotel() {
		book = new BookHotel(driver);
		return book;

	}

	public LogoutPage getInstanceLogoutPage() {
		logout = new LogoutPage(driver);
		return logout;

	}
}
