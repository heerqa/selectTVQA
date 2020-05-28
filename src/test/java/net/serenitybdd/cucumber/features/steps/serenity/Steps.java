package net.serenitybdd.cucumber.features.steps.serenity;



import cucumber.api.DataTable;
import org.junit.After;
import org.junit.Assert;

import com.project.pages.LoginPage;

import net.thucydides.core.annotations.Step;

import java.util.List;

public class Steps {
	LoginPage loginPage;

//	@After
//	public void closeBrowser() {
//		loginPage.quitBrowser();
//	}

	@Step
	public void user_is_on_login_page() throws Throwable {
	    loginPage.open();
	}

	@Step
	public void user_enter_username_and_and_password_as_and_click_Login_button(String arg1, String arg2) throws Throwable {
		loginPage.enterEmail(arg1);
		loginPage.enterPassword(arg2);
		loginPage.clickSignIn();
	}

	@Step
	public void home_page_is_displayed() throws Throwable {
		Assert.assertEquals(true, loginPage.isHomePageDisplayed());
	}

	@Step
	public void user_can_navigate_and_click_the_left_menu_tab(String arg1) throws Throwable {
		loginPage.user_can_navigate_and_click_the_left_menu_tab(arg1);
	}

	@Step
	public void user_can_navigate_and_click_the_following_sub_menu_tabs(List<String> myList) throws Throwable {
		loginPage.user_can_navigate_and_click_the_following_sub_menu_tabs(myList);
	}

	

}
