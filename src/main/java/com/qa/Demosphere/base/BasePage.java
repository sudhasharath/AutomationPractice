package com.qa.Demosphere.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.qa.Demosphere.utils.OptionsManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();	
	
	
/**
 * This method is used to initialize the driver on basis of given browser name	
 * @param browserName
 * @return driver
 */
	
	public WebDriver init_driver(Properties prop) {
		
		String browserName = prop.getProperty("browser").trim(); 
		System.out.println("Browser name is " + browserName);
		optionsManager = new OptionsManager(prop);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		} else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver(optionsManager.getFireFoxOptions()));
		} else if(browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass correct browser name .....");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		
		return getDriver();
	}
	
	public static WebDriver getDriver() {
		return tlDriver.get();
	}
/**
 * 	This method is used to initialize the properties from config.properties file
 * @return prop
 */
	public Properties init_prop() {
		prop = new Properties();
		String propPath = (".\\src\\main\\java\\com\\qa\\Demosphere\\config\\config.properties");
			
		try {
		    FileInputStream ip = new FileInputStream(propPath);
		    prop.load(ip);
	   } 
	   catch (FileNotFoundException e) {
		  e.printStackTrace();
	   } 
	   catch (IOException e) {
		  e.printStackTrace();
	   }
		return prop;
	}
}
	
