package net.serenitybdd.cucumber.features;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.cucumber.features.steps.serenity.Steps;

import java.util.List;

public class StepDefination {
	

	
	@net.thucydides.core.annotations.Steps
	Steps steps;
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
		steps.user_is_on_login_page();
	}

	@Given("^user enter username and \"([^\"]*)\" and password as \"([^\"]*)\" and click Login button$")
	public void user_enter_username_and_and_password_as_and_click_Login_button(String arg1, String arg2) throws Throwable {
		steps.user_enter_username_and_and_password_as_and_click_Login_button(arg1, arg2);
	}

	@Then("^home page is displayed$")
	public void home_page_is_displayed() throws Throwable {
		steps.home_page_is_displayed();
	}

	@Given("^user can navigate and click the \"([^\"]*)\" left menu tab$")
	public void user_can_navigate_and_click_the_left_menu_tab(String arg1) throws Throwable {
	    steps.user_can_navigate_and_click_the_left_menu_tab(arg1);
	}

    @Then("^user can navigate and click the following sub menu tabs$")
    public void user_can_navigate_and_click_the_following_sub_menu_tabs(List<String> myList) throws Throwable {
		steps.user_can_navigate_and_click_the_following_sub_menu_tabs(myList);
    }
	



}
