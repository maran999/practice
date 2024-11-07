package com.adactin.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel {
	
	public static WebDriver driver;

	@FindBy(id = "location")
	private WebElement location;

	@FindBy(name = "hotels")
	private WebElement hotel;

	@FindBy(xpath = "(//select[@class='search_combobox'])[3]")
	private WebElement roomType;

	@FindBy(id = "room_nos")
	private WebElement numOfRoom;

	@FindBy(id = "datepick_in")
	private WebElement checkIn;

	@FindBy(id = "datepick_out")
	private WebElement checkOut;

	@FindBy(id = "adult_room")
	private WebElement numOfAdult;

	@FindBy(id = "child_room")
	private WebElement numOfChild;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement search;

	public SearchHotel(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver2, this);
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getNumOfRoom() {
		return numOfRoom;
	}

	public WebElement getCheckIn() {
		return checkIn;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	public WebElement getNumOfAdult() {
		return numOfAdult;
	}

	public WebElement getNumOfChild() {
		return numOfChild;
	}

	public WebElement getSearch() {
		return search;
	}
}
