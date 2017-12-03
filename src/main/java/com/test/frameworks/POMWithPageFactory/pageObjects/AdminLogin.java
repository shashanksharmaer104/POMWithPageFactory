package com.test.frameworks.POMWithPageFactory.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.frameworks.POMWithPageFactory.base.PageBase;

public class AdminLogin extends PageBase {
	
	WebDriver driver;
	
	public AdminLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}
	
	@FindBy(id="j_username")
	WebElement userNameElement;
	
	@FindBy(id="j_password")
	WebElement passwordElement;
	
	@FindBy(id="proceed")
	WebElement submitElement;
	

	public void loginAdmin(String username, String password) {
		try {
			wait.until(ExpectedConditions.visibilityOf(userNameElement));
			userNameElement.sendKeys(username);
			passwordElement.sendKeys(password);
			//submitElement.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
