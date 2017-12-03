package com.test.frameworks.POMWithPageFactory.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.test.frameworks.POMWithPageFactory.utility.Log;

public class TestBase {

	public static WebDriver driver = null;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shashank Sharma\\workspace\\AutomationFrameworkProject\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		DOMConfigurator.configure("log4j.xml");
		 
		//Log.startTestCase("Selenium_Test_001");
	}
	
	@AfterTest
	public void shutDown() {
		driver.close();
		driver.quit();
		Log.endTestCase("Selenium_Test_001");
	}
}
