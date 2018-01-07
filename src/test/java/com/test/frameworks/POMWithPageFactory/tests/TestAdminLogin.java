package com.test.frameworks.POMWithPageFactory.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.test.frameworks.POMWithPageFactory.base.TestBase;
import com.test.frameworks.POMWithPageFactory.pageObjects.AdminLogin;
import com.test.frameworks.POMWithPageFactory.utility.ExcelUtils;
import com.test.frameworks.POMWithPageFactory.utility.Log;


public class TestAdminLogin extends TestBase {
	
	@Test
	@Parameters({"EnvURL","username","password"})
	public void testAdminLogin(String envURL, String username, String password) {
		try {
			Log.info("STEP 1: Launch Admin URL");
			driver.get(envURL);
			
			//Create page object
			AdminLogin adminLoginObj = new AdminLogin(driver);
			
			Log.info("STEP 2: Login Admin");
			adminLoginObj.loginAdmin(username, password);
			System.out.println("Test case 1 executed");
			
			//logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@DataProvider(name="Authentication")
	public static Object[][] credentials(){
		return new Object[][] {{"testuser_1","passsword","text1"},{"testuser_2","password","text2"}};
	}
	
	@Test(dataProvider="Authentication")
	public void testAdminLoginWithConstDataProvider(String username, String password, String text) {
		
		driver.get("https://talentcentral.cebglobal.com/admin/login");
		
		//Create page object
		AdminLogin adminLoginObj = new AdminLogin(driver);
		
		adminLoginObj.loginAdmin(username, password);
		System.out.println("Test case 2 executed");
		System.out.println("Extra text: " + text);
		
		// Added comment
	}
	
	@DataProvider(name="AuthenticationUsingExcel")
	public Object[][] Authentication() throws Exception{
		Object[][] testObjArray = ExcelUtils.getTableArray("C://Users//Shashank Sharma//workspace//POMWithPageFactory"
				+ "//src//test//java//testDataProvider//TestData.xlsx","Sheet1");
		return testObjArray;
	}
	
	@Test(dataProvider="AuthenticationUsingExcel")
	public void testAdminLoginWithDataProvider(String username, String password) {
		
		driver.get("https://talentcentral.cebglobal.com/admin/login");
		
		//Create page object
		AdminLogin adminLoginObj = new AdminLogin(driver);
		
		adminLoginObj.loginAdmin(username, password);
		System.out.println("Test case 3 executed");
		
		// Added comment
	}
	
}
