package com.qa.Demosphere.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Demosphere.base.BasePage;
import com.qa.Demosphere.utils.ElementUtil;


public class HomePage extends BasePage{
		
	private WebDriver driver;
	ElementUtil elementUtil;
	
	public String alert = null;
	public String count = null;
	
	By search_box             = By.xpath("//input[@id='search_query_top']");
	By magnifyingGlass_button = By.xpath("//button[@name='submit_search']");
	By search_count           = By.xpath("//span[@class='heading-counter']");
	By alert_warning          = By.xpath("//p[@class='alert alert-warning']");
	By product_count          = By.xpath("(//div[@class='product-count'])[1]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
/*
 * This method is used to search for an item provided in search box
 * @parm search string
 * @return String with number of items found 	
 */
	public String do_Search(String searchText) {
		elementUtil.doClear(search_box);
		elementUtil.doSendKeys(search_box, searchText);
		elementUtil.doClick(magnifyingGlass_button);
		
		String str_return = elementUtil.doGetText(search_count);
		
		if(str_return.charAt(0) == '0') {
			alert  = elementUtil.doGetText(alert_warning);
		} else {
			count = elementUtil.doGetText(product_count);
		}
		return str_return;
	}
}
