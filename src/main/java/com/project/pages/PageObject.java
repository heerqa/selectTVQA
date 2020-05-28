package com.project.pages;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.project.common.FileUtils;

public class PageObject extends net.serenitybdd.core.pages.PageObject {
static Logger Log = LoggerFactory.getLogger(PageObject.class.getName());
	
	public String getTitle() {
		return getDriver().getTitle();
	}
	
	public void waitForPageLoaded() throws InterruptedException {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        Thread.sleep(1999);
        Log.info("Waiting for Page Load");
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(expectation);
    }
	
	public void waitForUserNameToAppear() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchBox-triggerWrap")));
	}
	
	private boolean acceptNextAlert = true;	
	public void closeAlertAndGetItsText() throws InterruptedException {
		try {
			Alert alert = getDriver().switchTo().alert();
			Thread.sleep(2000);
			alert.accept();
		} finally {
			acceptNextAlert = true;
		}
	}

	public void uploadFile(String filePath, String btnNumber, WebElement ele, String className) throws InterruptedException{


		if (getDriver() instanceof JavascriptExecutor) {
			((JavascriptExecutor)getDriver()).executeScript("document.getElementsByClassName('btn-success')[15].setAttribute('class','btn');;");
		} else {
			throw new IllegalStateException("This driver does not support JavaScript!");
		}

		//uploadPDF.sendKeys(FileUtils.getResourceFile(this.getClass(), filePath).getPath());
		Thread.sleep(2500);
		//getDriver().findElement(By.id("file_upload_pdf")).click();;
		//getDriver().findElement(By.id("file_upload_pdf")).sendKeys("/U/sasdasd/builderstormqa/src/test/resources/attachments/drawing.pdf");
		ele.sendKeys(FileUtils.getResourceFile(this.getClass(), filePath).getPath());
		//uploadNewDrawing.click();
	}

	public void uploadFile(String filePath, String btnName, String btnNumber, WebElement ele, String className) throws InterruptedException{

		Log.info("INSIDE CLICK BUTTON METHOD");
		Log.info("" +getDriver().findElements(By.className(className)).size());
		Log.info("" + getDriver().findElements(By.className(className)).size());
		for (int i = 0; i < getDriver().findElements(By.className(className)).size(); i++) {

			System.out.println(getDriver().findElements(By.className(className)).get(i).getText());
			if (getDriver().findElements(By.className(className)).get(i).getText().contains(btnName)) {
				//getDriver().findElements(By.className(className)).get(i).click();
				Log.info("BUTTON FOUND");
				Log.info(String.valueOf(i));
				((JavascriptExecutor)getDriver()).executeScript("document.getElementsByClassName('"+className+"')["+i+"].setAttribute('class','btn');");
				break; 

			}
		}




		/*if (getDriver() instanceof JavascriptExecutor) {
		    ((JavascriptExecutor)getDriver()).executeScript("document.getElementsByClassName('btn-success')[15].setAttribute('class','btn');;");
		} else {
		    throw new IllegalStateException("This driver does not support JavaScript!");
		}
		 */
		//uploadPDF.sendKeys(FileUtils.getResourceFile(this.getClass(), filePath).getPath());
		Thread.sleep(2500);
		//getDriver().findElement(By.id("file_upload_pdf")).click();;
		//getDriver().findElement(By.id("file_upload_pdf")).sendKeys("/U/sasdasd/builderstormqa/src/test/resources/attachments/drawing.pdf");
		ele.sendKeys(FileUtils.getResourceFile(this.getClass(), filePath).getPath());
		//uploadNewDrawing.click();
	}

	public void uploadFileSecondSimialrBtn(String filePath, String btnName, String btnNumber, WebElement ele, String className) throws InterruptedException{

		//		System.out.println("INSIDE CLICK BUTTON METHOD");
		//		System.out.println(getDriver().findElements(By.className(className)).size());
		//		System.out.println(getDriver().findElements(By.className(className)).size());
		((JavascriptExecutor)getDriver()).executeScript("document.getElementsByClassName('"+className+"')[1].setAttribute('class','btn');");
		Thread.sleep(2500);
		ele.sendKeys(FileUtils.getResourceFile(this.getClass(), filePath).getPath());

	}

	public void clickButton(String className, String btnName) throws InterruptedException{
		Log.info("INSIDE CLICK BUTTON METHOD");
		int len = getDriver().findElements(By.className(className)).size();
		Log.info("SIZE : " + len);
		int i;
		for (i = 0; i < len; i++) {

			Log.info(getDriver().findElements(By.className(className)).get(i).getText());

			Log.info("GET Current button name :" + getDriver().findElements(By.className(className)).get(i).getText());
			if (getDriver().findElements(By.className(className)).get(i).getText().contains(btnName)) {
				Thread.sleep(2000);
				getDriver().findElements(By.className(className)).get(i).click();
				break; 				
			}
		}
		if(i == len) {
			throw new InterruptedException(); 
		}
	}

	public String getElementTxt(String className, String btnName){
		//		System.out.println("INSIDE CLICK BUTTON METHOD");
		String val=null;

		//		System.out.println(getDriver().findElements(By.className(className)).size());
		for (int i = 0; i < getDriver().findElements(By.className(className)).size(); i++) {

			Log.info(btnName);

			Log.info("GET Current button name :" + getDriver().findElements(By.className(className)).get(i).getText());
			if (getDriver().findElements(By.className(className)).get(i).getText().contains(btnName)) {
				Log.info("Found the element:");
				val= getDriver().findElements(By.className(className)).get(i).getText();
				break; 				
			}
		}
		return val;
	}

	public void clickElementTxt(String className, String btnName){
		//		System.out.println("INSIDE CLICK BUTTON METHOD");


		//		System.out.println(getDriver().findElements(By.className(className)).size());
		for (int i = 0; i < getDriver().findElements(By.className(className)).size(); i++) {

			Log.info(btnName);

			Log.info("GET Current button name :" + getDriver().findElements(By.className(className)).get(i).getText());
			if (getDriver().findElements(By.className(className)).get(i).getText().contains(btnName)) {
				Log.info("Found the element:");
				//				getDriver().findElements(By.className(className)).get(i).click();
				//				getDriver().findElements(By.className(className)).get(i).click();
				//				getDriver().findElements(By.className(className)).get(i).click();
				Actions action = new Actions(getDriver());
				action.moveToElement(getDriver().findElements(By.className(className)).get(i)).doubleClick().perform();
				break; 				
			}
		}

	}

	public void selectChecboxForUser(String className, String btnName){
		System.out.println("INSIDE CLICK BUTTON METHOD");

		//		System.out.println(getDriver().findElements(By.className(className)).size());
		for (int i = 0; i < getDriver().findElements(By.className(className)).size(); i++) {

			Log.info(btnName);

			Log.info("GET Current button name :" + getDriver().findElements(By.className(className)).get(i).getText());
			if (getDriver().findElements(By.className(className)).get(i).getText().contains(btnName)) {
				Log.info("Found the element:");
				//				getDriver().findElements(By.className(className)).get(i).click();
				//				getDriver().findElements(By.className(className)).get(i).click();
				//				getDriver().findElements(By.className(className)).get(i).click();
				Actions action = new Actions(getDriver());
				action.moveToElement(getDriver().findElements(By.className("x-grid-checkcolumn")).get(i)).doubleClick().perform();
				break; 				
			}
		}

	}

	public void setVal(String inputclassName,String val){
		//getDriver().findElement(By.cssSelector("#s2id_users_name > a.select2-choice > span.select2-arrow > b")).click();;
		//getDriver().findElement(By.cssSelector("select2-input")).sendKeys(val);
		getDriver().findElements(By.cssSelector(".select2-result-label")).get(1).click();
	}
	public void selectVal(String val){
		getDriver().findElement(By.cssSelector("#s2id_users_name > a.select2-choice > span.select2-arrow > b")).click();;
		getDriver().findElement(By.cssSelector("input.select2-input.select2-focused")).sendKeys(val);
		getDriver().findElement(By.cssSelector("div.select2-result-label")).click();
	}


	public void setSelectFields(String className,String index, String val){
		((JavascriptExecutor)getDriver()).executeScript("document.getElementsByClassName('"+className+"')["+index+"].innerText='" + val +"'");
	}

	public Boolean isElementExist(String className, String elementName){
		System.out.println("INSIDE CLICK BUTTON METHOD");
		String val=null;

		//		System.out.println(getDriver().findElements(By.className(className)).size());
		int len = getDriver().findElements(By.className(className)).size() - 1;
		for (int i = len; i >= 0; i--) {

			Log.info(elementName);

			Log.info("GET Current Element name :" + getDriver().findElements(By.className(className)).get(i).getText());
			if (getDriver().findElements(By.className(className)).get(i).getText().contains(elementName)) {
				Log.info("Found the element:");
				//				val= getDriver().findElements(By.className(className)).get(i).getText();
				return true;
			}
		}
		return false;
	}

	public Boolean isButtonEnabled(String className, String elementName){
		//		System.out.println("INSIDE CLICK BUTTON METHOD");
		String val=null;

		//		System.out.println(getDriver().findElements(By.className(className)).size());
		int len = getDriver().findElements(By.className(className)).size() - 1;
		for (int i = 0; i <= len; i++) {

			Log.info(elementName);

			Log.info("GET Current Element name :" + getDriver().findElements(By.className(className)).get(i).getText());
			if (getDriver().findElements(By.className(className)).get(i).getText().contains(elementName)) {
				Log.info("Found the element:");
				//				val= getDriver().findElements(By.className(className)).get(i).getText();
				return getDriver().findElements(By.className(className)).get(i).isEnabled();
			}
		}
		return false;
	}

	public void pleaseWait() {
			for(int i=0;i< 99;i++) {
				Log.info("Waiting : " +  i);
				try {
					Thread.sleep(2000);
					int len = getDriver().findElements(By.className("x-mask-msg-text")).size();
					if(len == 0) {
						break;
					}
					
					WebElement ele = getDriver().findElement(By.className("x-mask-msg-text"));
					if (!ele.isDisplayed()) {
						Log.info("IIIFFF " +  i);
						break;
					}
					Log.info("NO IIIFFF");
				} catch (Exception e) {
					// TODO: handle exception
					Log.info(e.getMessage());
				}
			}
			Log.info("Out For");		
	}

	public void selectFromList(String className, String elementName) throws InterruptedException {
		//		System.out.println("INSIDE CLICK BUTTON METHOD");	
		//		System.out.println(getDriver().findElements(By.className(className)).size());
		int i;
		int len = getDriver().findElements(By.className(className)).size();
		for (i = 0; i < len; i++) {
			Log.info("INSIDE Loop");
			Log.info(elementName);

			Log.info("GET Current Element name :" + getDriver().findElements(By.className(className)).get(i).getText());
			if (getDriver().findElements(By.className(className)).get(i).getText().contains(elementName)) {
				Log.info("Found the element:");
				//				val= getDriver().findElements(By.className(className)).get(i).getText();
				//				getDriver().findElements(By.className(className)).get(i).click();
				Log.info("document.getElementsByClassName('"+className+"')["+i+"].click()");
				evaluateJavascript("document.getElementsByClassName('"+className+"')["+i+"].click()");
				break;
			}
		}
		if(i == len) {
			throw new InterruptedException(); 
		}
	}
	
	public void sendTxtBasedUponPlacholder(String className, String placeholder, String str) throws InterruptedException {
		int len = getDriver().findElements(By.className(className)).size() - 1;
		int i;
		for (i = 0; i < len; i++) {
			Log.info("INSIDE Loop");
			Log.info(placeholder);

			Log.info("GET Current Element name :" + getDriver().findElements(By.className(className)).get(i).getAttribute("placeholder"));
			if (getDriver().findElements(By.className(className)).get(i).getAttribute("placeholder").contains(placeholder)) {
				Log.info("Found the element:");
				//				val= getDriver().findElements(By.className(className)).get(i).getText();
				//				getDriver().findElements(By.className(className)).get(i).click();
				getDriver().findElements(By.className(className)).get(i).sendKeys(str);
				break;
			}
		}
		if(i == len) {
			throw new InterruptedException(); 
		}
	}
	
	public void selectValueFromList(String className, String elementName) throws InterruptedException {
		//		System.out.println("INSIDE CLICK BUTTON METHOD");	
		//		System.out.println(getDriver().findElements(By.className(className)).size());
		int i;
		int len = getDriver().findElements(By.className(className)).size();
		for (i = 0; i < len; i++) {
			Log.info("INSIDE Loop");
			Log.info(elementName);

			Log.info("GET Current Element name :" + getDriver().findElements(By.className(className)).get(i).getText());
			if (getDriver().findElements(By.className(className)).get(i).getText().equals(elementName)) {
				Log.info("Found the element:");
				//				val= getDriver().findElements(By.className(className)).get(i).getText();
				//				getDriver().findElements(By.className(className)).get(i).click();
				Log.info("document.getElementsByClassName('"+className+"')["+i+"].click()");
				evaluateJavascript("document.getElementsByClassName('"+className+"')["+i+"].click()");
				break;
			}
		}
		if(i == len) {
			throw new InterruptedException(); 
		}
	}
	
	public void switchTabs() {
		ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs2.get(1));
	}
	
	public void switchToFirstTab() {
		ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
		getDriver().switchTo().window(tabs2.get(0));
	}
	
	public void reloadTab() {
		getDriver().navigate().refresh();
	}
}
