package com.adactin.stepDefinition;

import org.openqa.selenium.WebDriver;

import com.adactin.baseclass.Base_Class;
import com.adactin.configuration.File_Reader_Manager;
import com.adactin.configuration.PageObjectManager;
import com.adactin.pom.BookHotel;
import com.adactin.pom.ConfirmHotel;
import com.adactin.pom.LoginPage;
import com.adactin.pom.LogoutPage;
import com.adactin.pom.SearchHotel;
import com.adactin.runner.Runner;

import io.cucumber.java.en.*;

public class Stepdefinition extends Base_Class {

	public static WebDriver driver = Runner.driver;

	PageObjectManager pom = new PageObjectManager(driver);

	@Given("^user want the launch the adatin application$")
	public void user_want_the_launch_the_adatin_application() throws Throwable {
		String url = File_Reader_Manager.getInstance().getInstanceCR().getUrl();
		getUrl(url);
	}

	@When("user enter {string} the valid username")
	public void user_enter_the_valid_username(String username) {
		sendKeys(pom.getInstanceLoginPage().getUsername(), username);
	}

	@When("user enter {string} the valid password")
	public void user_enter_the_valid_password(String password) {
		sendKeys(pom.getInstanceLoginPage().getPassword(), password);
	}

	@Then("^user verify valid username and password$")
	public void user_verify_valid_username_and_password() throws Throwable {
		click(pom.getInstanceLoginPage().getLogin());
	}

	@When("user select the preferred location")
	public void user_select_the_preferred_location() {
		dropDown(pom.getInstanceSearchHotel().getLocation(), "byvalue", "Melbourne");
	}

	@When("user select the preferred hotel")
	public void user_select_the_preferred_hotel() {
		dropDown(pom.getInstanceSearchHotel().getHotel(), "byVisibleText", "Hotel Sunshine");
	}

	@When("user select {string} the preferred location")
	public void user_select_the_preferred_location(String location) {
		dropDown(pom.getInstanceSearchHotel().getLocation(), "byvalue", location);
	}

	@When("user select {string} the preferred hotel")
	public void user_select_the_preferred_hotel(String hotelname) {
		dropDown(pom.getInstanceSearchHotel().getHotel(), "byVisibleText", hotelname);
	}


	@When("user select {string} the room type")
	public void user_select_the_room_type(String roomtype) {
		dropDown(pom.getInstanceSearchHotel().getRoomType(), "byIndex", roomtype);
	}

	@When("user select {string} the number of rooms")
	public void user_select_the_number_of_rooms(String totroom) {
		dropDown(pom.getInstanceSearchHotel().getNumOfRoom(), "ByValue", totroom);
	}

	@When("user enter check in date")
	public void user_enter_check_in_date() {
		sendKeys(pom.getInstanceSearchHotel().getCheckIn(), "20/10/2021");
	}

	@When("user enter select check out date")
	public void user_enter_select_check_out_date() {
		sendKeys(pom.getInstanceSearchHotel().getCheckOut(), "24/10/2021");
	}

	@When("user want to select number of adult per room")
	public void user_want_to_select_number_of_adult_per_room() {
		dropDown(pom.getInstanceSearchHotel().getNumOfAdult(), "byValue", "2");
	}

	@When("user want to select number of children per room")
	public void user_want_to_select_number_of_children_per_room() {
		dropDown(pom.getInstanceSearchHotel().getNumOfChild(), "byValue", "3");
	}

	@Then("user verify the details")
	public void user_verify_the_details() {
		click(pom.getInstanceSearchHotel().getSearch());
	}

	@When("user check the check box")
	public void user_check_the_check_box() {
		click(pom.getInstanceConfirmHotel().getConfirm());
	}

	@Then("user verify the confirm hotel")
	public void user_verify_the_confirm_hotel() {
		click(pom.getInstanceConfirmHotel().getConfirmAndContinue());
	}

	@When("user enter the firstname")
	public void user_enter_the_firstname() {
		sendKeys(pom.getInstanceBookHotel().getFirstname(), "Manimaran");
	}

	@When("user enter the lastname")
	public void user_enter_the_lastname() {
		sendKeys(pom.getInstanceBookHotel().getLastname(), "Gopinathan");
	}

	@When("user enter the address")
	public void user_enter_the_address() {
		sendKeys(pom.getInstanceBookHotel().getAddress(), "No.7 T-Nagar, Chennai:6000015, Tamilnadu");
	}

	@When("user enter the card number")
	public void user_enter_the_card_number() throws Throwable {
		String num = File_Reader_Manager.getInstance().getInstanceCR().getCardNum();
		sendKeys(pom.getInstanceBookHotel().getCardNum(), num);
	}

	@When("user select the card type")
	public void user_select_the_card_type() {
		dropDown(pom.getInstanceBookHotel().getCardType(), "byIndex", "2");
	}

	@When("user select the expiry month")
	public void user_select_the_expiry_month() {
		dropDown(pom.getInstanceBookHotel().getExpMonth(), "byValue", "11");
	}

	@When("user select the expiry year")
	public void user_select_the_expiry_year() {
		dropDown(pom.getInstanceBookHotel().getExpYear(), "byVisibleText", "2021");
	}

	@When("user enter the CVV number")
	public void user_enter_the_cvv_number() throws Throwable {
		String cvv = File_Reader_Manager.getInstance().getInstanceCR().getCvv();
		sendKeys(pom.getInstanceBookHotel().getCvv(), cvv);
	}

	@Then("user verify the card details")
	public void user_verify_the_card_details() {
		click(pom.getInstanceBookHotel().getBookNow());
	}

	@When("user enter the logout button")
	public void user_enter_the_logout_button() {
		click(pom.getInstanceLogoutPage().getLogout());
	}
}
