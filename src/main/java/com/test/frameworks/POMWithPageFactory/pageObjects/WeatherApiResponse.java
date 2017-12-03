package com.test.frameworks.POMWithPageFactory.pageObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.frameworks.POMWithPageFactory.base.PageBase;

public class WeatherApiResponse extends PageBase {

	WebDriver driver;

	public WeatherApiResponse(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}
	
	public String getResponse(String url) throws ClientProtocolException, IOException {

		//WebElement elem = driver.findElement(By.tagName("pre"));

		StringBuffer result = new StringBuffer();
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		request.addHeader("User-Agent","Mozilla/5.0");
		HttpResponse response = client.execute(request);

		int responseCode = response.getStatusLine().getStatusCode();

		try {
			if(responseCode == 200) {
				System.out.println("Get response is successfull !!");
				BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				String line = "";
				while((line=reader.readLine())!=null) {
					result.append(line);
					System.out.println(result.toString());
				}
			}
		} catch (Exception e) {
			result.append("Get response failed");
			return result.toString();
		}
		return result.toString();
	}
}
