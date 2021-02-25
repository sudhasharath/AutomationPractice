package com.qa.Demosphere.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qa.Demosphere.base.BasePage;
import com.qa.Demosphere.utils.ElementUtil;

public class CartPage extends BasePage{
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String popup_text;
	public String str_empty;
			
	By first_dress        = By.xpath("(//div[@class='product-container'])[1]");
	By add_to_cart_1      = By.xpath("(//div[@class='button-container']//a//span)[2]");
	By pop_up_text        = By.xpath("//span[@class='ajax_cart_product_txt ']");
	By continue_shopping  = By.xpath("//span//i[@class='icon-chevron-left left']");
	By second_dress       = By.xpath("(//div[@class='product-container'])[2]");
	By add_to_cart_2      = By.xpath("(//div[@class='button-container']//a//span)[4]");
	By pop_up_plural_text = By.xpath("//span[@class='ajax_cart_product_txt_s  unvisible']");
	By cart               = By.xpath("//b");
	By remove_link        = By.xpath("(//span[@class='remove_link'])[1]");
	By empty_str          = By.xpath("//span[@class='ajax_cart_no_product']");

/**
 * This method is manipulate the cart by adding and removing items.		
 * @throws InterruptedException
 */
	public void cart_manipulation() throws InterruptedException {
		//Add first item to cart	
		add_item_tocart(first_dress,add_to_cart_1);
		Thread.sleep(1000);
		get_popup_text(pop_up_text);
		Thread.sleep(1000);
		elementUtil.doActionsClick(continue_shopping);
		
		//Add second item to cart	
		add_item_tocart(second_dress,add_to_cart_2);
		Thread.sleep(1000);
		get_popup_text(pop_up_plural_text);
		Thread.sleep(1000);
		elementUtil.doActionsClick(continue_shopping);
		Thread.sleep(1000);
		
		//Remove first item from cart
		remove_item_fromcart();
		
		//Remove Second item from cart
		remove_item_fromcart();
		
		str_empty = elementUtil.doGetText(empty_str);
	}
		
	public void add_item_tocart(By item_locator,By cart_locator) throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");
		elementUtil.doMoveToElement(item_locator);
		Thread.sleep(1000);
		elementUtil.doActionsClick(cart_locator);
		Thread.sleep(1000);
	}
		
	public void get_popup_text(By popup_locator) {
		popup_text = elementUtil.doGetText(popup_locator);
		System.out.println(popup_text);
	}	
					
	public void remove_item_fromcart() {
		elementUtil.doMoveToElement(cart);
		elementUtil.doActionsClick(remove_link);
	}
			
}
		

	
