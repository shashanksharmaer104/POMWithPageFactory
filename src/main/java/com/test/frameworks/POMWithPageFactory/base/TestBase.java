package com.test.frameworks.POMWithPageFactory.base;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.frameworks.POMWithPageFactory.utility.Log;

public class TestBase {

	public static WebDriver driver = null;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public static ExtentTest logger;

	@BeforeTest
	@Parameters({"EnvURL"})
	public void setup(String env) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shashank Sharma\\workspace\\"
				+ "AutomationFrameworkProject\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		DOMConfigurator.configure("log4j.xml");
		 
		//Log.startTestCase("Selenium_Test");
		
		// Extent report
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/STMExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", InetAddress.getLocalHost().getHostAddress());
		extent.setSystemInfo("Environment", env);
		extent.setSystemInfo("User Name", "Shashank Sharma");
		
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here");
		htmlReporter.config().setReportName("Name of the Report Comes here");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
	@BeforeMethod
	public void beforeMethod(ITestContext ctx) {
		logger = extent.createTest(ctx.getCurrentXmlTest().getName());
	}
	
	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.SUCCESS){
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
			//logger.log(Status.PASS, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Passed", ExtentColor.GREEN));
		}else if(result.getStatus() == ITestResult.FAILURE){
			//logger.log(Status.FAIL, "Test Case Failed is "+result.getName());
			//MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		}else if(result.getStatus() == ITestResult.SKIP){
			//logger.log(Status.SKIP, "Test Case Skipped is "+result.getName());
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));	
		}
	}
	
	@AfterTest
	public void shutDown() {
		driver.close();
		driver.quit();
		//Log.endTestCase("Selenium_Test_001");
		extent.flush();
	}
}
