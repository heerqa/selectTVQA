package com.project.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.inject.internal.util.$Lists;
import com.google.inject.internal.util.$Strings;
import cucumber.api.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://stagingstv.freecast.com/")

public class LoginPage extends com.project.pages.PageObject {
	
	@FindBy(id="id_username")
	WebElement id_username;
	public void enterEmail(String val) throws InterruptedException {
		waitForPageLoaded();
		waitForTextToAppear("Sign In");
        id_username.sendKeys(val);
	}
	
	@FindBy(id="id_password")
	WebElement id_password;
	public void enterPassword(String val) throws InterruptedException {
		waitForPageLoaded();
        id_password.sendKeys(val);
	}
	
	public void clickSignIn() {
		getDriver().findElement(By.xpath("//button[contains(@class,'btn-primary')]")).click();
	}

	 public boolean isHomePageDisplayed() throws InterruptedException {
		waitForPageLoaded();
		waitForPageLoaded();
		return getDriver().findElement(By.xpath("//b[text()='Home']")).isDisplayed();
	 }

	public void user_can_navigate_and_click_the_left_menu_tab(String arg1) throws Throwable {
		getDriver().findElement(By.xpath("//span[contains(text(),'"+arg1+"')]")).click();
	}

	public void user_can_navigate_and_click_the_following_sub_menu_tabs(List<String> myList) throws Throwable {
		System.out.println(myList.get(0));
		getDriver().findElement(By.xpath("//a[text()='"+myList.get(0)+"']")).click();
		waitForPageLoaded();
		System.out.println(myList.get(1));
		getDriver().findElement(By.xpath("//a[text()='"+myList.get(1)+"']")).click();
		waitForPageLoaded();
		System.out.println(myList.get(2));
		getDriver().findElement(By.xpath("//a[text()='"+myList.get(2)+"']")).click();
		waitForPageLoaded();
		System.out.println(myList.get(3));
		getDriver().findElement(By.xpath("//a[text()='"+myList.get(3)+"']")).click();
		waitForPageLoaded();
		System.out.println(myList.get(4));
		getDriver().findElement(By.xpath("//a[text()='"+myList.get(4)+"']")).click();
		waitForPageLoaded();
		System.out.println(myList.get(5));
		getDriver().findElement(By.xpath("//a[text()='"+myList.get(5)+"']")).click();
		waitForPageLoaded();
	}

	public void quitBrowser() {
		getDriver().close();
	}

}
