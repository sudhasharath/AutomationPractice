package com.qa.Demosphere.pages;

import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Demosphere.base.BasePage;
import com.qa.Demosphere.utils.ElementUtil;

public class CreateAccountPage extends BasePage	 {

	public static String acc_emailid_create;
	private WebDriver driver;
	ElementUtil elementUtil;
		
	public CreateAccountPage(WebDriver driver) {
	    this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public String auth_text;
	public String success_text;
	public String error_text;
	
		
	By Sign_in          = By.linkText("Sign in");
	By authentication   = By.xpath("//h1[@class='page-heading']");
	By emailid_create   = By.xpath("//input[@id='email_create']");
	By create_button    = By.xpath("//button[@name='SubmitCreate']");
	By radio_button     = By.xpath("//input[@id='id_gender2']");
	By first_name       = By.xpath("//input[@id='customer_firstname']");
	By last_name        = By.xpath("//input[@id='customer_lastname']");
	By email            = By.xpath("//input[@id='email']");
	By password         = By.xpath("//input[@id='passwd']");
	By dob_day          = By.xpath("//select[@id='days']");
	By dob_month        = By.xpath("//select[@id='months']");
	By dob_year         = By.xpath("//select[@id='years']");
	By newletters       = By.xpath("//input[@id='newsletter']");
	By sploffers        = By.xpath("//input[@id='optin']");
	By addr_firstname   = By.xpath("//input[@id='firstname']");
	By addr_lastname    = By.xpath("//input[@id='lastname']");
	By Company_name     = By.xpath("//input[@id='company']");
	By address_line1    = By.xpath("//input[@type='text'and@class='form-control'and@name='address1']");
	By address_line2    = By.xpath("//input[@type='text'and@class='form-control'and@name='address2']");
	By city             = By.xpath("//input[@id='city']");
	By state            = By.xpath("//select[@id='id_state']");
	By zipcode          = By.xpath("//input[@id='postcode']");
	By country          = By.xpath("//select[@id='id_country']");
	By mobile_phone     = By.xpath("//input[@id='phone_mobile']");
	By address_alias    = By.xpath("//input[@id='alias']");
	By register_button  = By.xpath("//span[text()='Register']");
	By welcome_text     = By.xpath("//p[@class='info-account']");
	By signout          = By.linkText("Sign out");
	By error_popup      = By.xpath("//div//ol//li");
	
// page actions
	
/**		
 * This method clicks on sign in button
 */
	public void click_on_signin_button() {
		elementUtil.doClick(Sign_in);
		auth_text = elementUtil.doGetText(authentication);
	}
	
/*
 * Generating  a random number	
 */
	 Random randomGenerator = new Random();
	 int randomInt = randomGenerator.nextInt(1000);
	
	
/**
 * This method enters all the personal details of the user 	
 */
	public void create_account_with_details(Properties prop) {
		//Read Account details from props file
		        acc_emailid_create = prop.getProperty("username")+randomInt+prop.getProperty("email").trim(); 
		String  acc_first_name     = prop.getProperty("first_name").trim(); 
		String  acc_last_name      = prop.getProperty("last_name").trim(); 
		String  acc_password       = prop.getProperty("password").trim(); 
		String  acc_dob_day        = prop.getProperty("dob_day").trim(); 
		String  acc_dob_month      = prop.getProperty("dob_month").trim(); 
		String  acc_dob_year       = prop.getProperty("dob_year").trim(); 
		String  acc_addr_firstname = prop.getProperty("addr_firstname").trim(); 
		String  acc_addr_lastname  = prop.getProperty("addr_lastname").trim(); 
		String  acc_Company_name   = prop.getProperty("Company_name").trim(); 
		String  acc_address_line1  = prop.getProperty("address_line1").trim(); 
		String  acc_address_line2  = prop.getProperty("address_line2").trim(); 
		String  acc_city           = prop.getProperty("city").trim(); 
		String  acc_state          = prop.getProperty("state").trim(); 
		String  acc_zipcode        = prop.getProperty("zipcode").trim(); 
		String  acc_country        = prop.getProperty("country").trim(); 
		String  acc_mobile_phone   = prop.getProperty("mobile_phone").trim(); 
		String  acc_address_alias  = prop.getProperty("address_alias").trim();
		
		click_on_signin_button();
		
	    elementUtil.doSendKeys(emailid_create, acc_emailid_create);
		elementUtil.doClick(create_button);
		elementUtil.doClick(radio_button);
		elementUtil.doSendKeys(first_name,acc_first_name);
		elementUtil.doSendKeys(last_name, acc_last_name);
		elementUtil.doSendKeys(password, acc_password);
		elementUtil.doSelectValuesByValue(dob_day, acc_dob_day);
		elementUtil.doSelectValuesByValue(dob_month, acc_dob_month);
		elementUtil.doSelectValuesByValue(dob_year, acc_dob_year);
		elementUtil.doClick(newletters);
		elementUtil.doClick(sploffers);
		elementUtil.doClear(addr_firstname);
		elementUtil.doSendKeys(addr_firstname, acc_addr_firstname);
		elementUtil.doClear(addr_lastname);
		elementUtil.doSendKeys(addr_lastname, acc_addr_lastname);
		elementUtil.doSendKeys(Company_name, acc_Company_name);
		elementUtil.doSendKeys(address_line1, acc_address_line1);
		elementUtil.doSendKeys(address_line2, acc_address_line2);
		elementUtil.doSendKeys(city, acc_city);
		elementUtil.doSelectValuesByVisibleText(state,acc_state);
		elementUtil.doSendKeys(zipcode, acc_zipcode);
		elementUtil.doSelectValuesByVisibleText(country, acc_country);
		elementUtil.doSendKeys(mobile_phone, acc_mobile_phone);
		elementUtil.doSendKeys(address_alias, acc_address_alias);
		elementUtil.doClick(register_button);
		
		success_text = elementUtil.doGetText(welcome_text);
		
		
		}
	
/**
 * This method clicks on sign out link
 */
	public void clickon_signout_link() {
		elementUtil.doClick(signout);
	}

/**
 * This method creates a failed account
 */
	public void createfailed_account() {
		elementUtil.doClick(Sign_in);
		elementUtil.doSendKeys(emailid_create,acc_emailid_create);
		elementUtil.doClick(create_button);
		error_text = elementUtil.doGetText(error_popup); 
	}
		
}
