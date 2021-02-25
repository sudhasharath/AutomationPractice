package com.qa.Demosphere.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil{
	
/**
 * This method is used to create web element on the basis of given By locator
 * @param locator
 * @return
 */
	private WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		}catch(Exception e) {
			System.out.println("element could not be created " +locator);
		}
		return element;
	}	
	
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
		
	public void doClick(By locator) {
		getElement(locator).click();
			
	}
	
	public void doClear(By locator) {
		getElement(locator).clear();
	}
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	//*******************Actions Class********************
	
	public void doActionsClick(By locator) {
		Actions ac = new Actions(driver);
		ac.click(getElement(locator)).click().perform();
	}
		
	public void doMoveToElement(By locator) {
		Actions ac = new Actions(driver);
		ac.moveToElement(getElement(locator)).perform();
	}
	
//*********************drop down utils****************
		
	public void doSelectValuesByVisibleText(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	
	public void doSelectValuesByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
}
