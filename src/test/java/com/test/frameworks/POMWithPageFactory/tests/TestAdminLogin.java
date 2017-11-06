package com.test.frameworks.POMWithPageFactory.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.frameworks.POMWithPageFactory.base.BaseTest;
import com.test.frameworks.POMWithPageFactory.pageObjects.AdminLogin;

public class TestAdminLogin extends BaseTest {
	
	/*WebDriver driver;
	
	public TestAdminLogin(WebDriver driver) {
		this.driver = driver;
	}*/
	
	@Test
	@Parameters({"username","password"})
	public void testAdminLogin(String username, String password) {
		
		driver.get("https://talentcentral.cebglobal.com/admin/login");
		
		//Create page object
		AdminLogin adminLoginObj = new AdminLogin(driver);
		
		adminLoginObj.loginAdmin(username, password);
		
	}
	
}
