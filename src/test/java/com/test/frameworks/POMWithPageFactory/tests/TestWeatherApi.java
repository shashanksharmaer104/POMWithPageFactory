package com.test.frameworks.POMWithPageFactory.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.frameworks.POMWithPageFactory.base.TestBase;
import com.test.frameworks.POMWithPageFactory.pageObjects.WeatherApiResponse;
import com.test.frameworks.POMWithPageFactory.utility.Log;

public class TestWeatherApi extends TestBase {

	
	@Test
	@Parameters({"EnvURL"})
	public void testWeatherApi(String envURL) {
		try {
			Log.info("STEP 1: Launch Weather API URL");
			driver.get(envURL);
			
			//Create page object
			WeatherApiResponse weatherApiObj = new WeatherApiResponse(driver);
			
			// Get response
			weatherApiObj.getResponse(envURL);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
