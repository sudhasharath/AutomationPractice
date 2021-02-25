package com.qa.Demosphere.base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.Demosphere.pages.CartPage;
import com.qa.Demosphere.pages.CreateAccountPage;
import com.qa.Demosphere.pages.HomePage;

public class BaseTest {
	
	public WebDriver driver;
	public BasePage basePage;
	public HomePage homepage;
	public CreateAccountPage createaccountpage;
	public CartPage cartpage;
	public Properties prop;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		homepage = new HomePage(driver);
		createaccountpage = new CreateAccountPage(driver);
		cartpage = new CartPage(driver);
	}

	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
}
