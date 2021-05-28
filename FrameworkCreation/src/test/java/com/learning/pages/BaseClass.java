package com.learning.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.internal.reflect.Parameter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learning.utility.BrowserFactory;
import com.learning.utility.ConfigDataProvider;
import com.learning.utility.ExcelDataProvider;
import com.learning.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public Helper helper;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void seupSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		helper = new Helper();

		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(
				System.getProperty("user.dir") + "/Reports/CRMReport_" + helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);

	}

	@Parameters({ "browser", "urlToBeTested" }) // Here value will be get from maven and this value is provided to below
												// variables
	@BeforeClass
	public void setUp(String browser, String url) {
		// driver = BrowserFactory.startApplication(driver, config.getBrowser(),
		// config.getStagingURL()); //Here browser & url is taking from
		// config.properties
		driver = BrowserFactory.startApplication(driver, browser, url); // here values are taking from POM.xml
	}

//	@BeforeClass
//	public void SetUpExceptionError(String clasName,String methodName,Exception e) {
//		  System.out.println("Error is from class:"+clasName + "and Method: "+methodName+"()- "+e.toString());
//	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		BrowserFactory.closeApplication(driver);

	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		System.out.println("fsdfsd1");
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("fsdfsd2");
			helper.captureScreenshots(driver);
			try {
				logger.fail("Test Failed",
						MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshots(driver)).build());
			} catch (Exception e) {
				System.out.println("Sorry..!Not able to add screenshot to Report");
			}
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("fsdfsd3");
			helper.captureScreenshots(driver);
			try {
				logger.pass("Test Passed",
						MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshots(driver)).build());
			} catch (Exception e) {
				System.out.println("Sorry..!Not able to add screenshot to Report");
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("fsdfsd4");
			helper.captureScreenshots(driver);
			try {
				logger.skip("Test skiped",
						MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshots(driver)).build());
			} catch (Exception e) {
				System.out.println("Sorry..!Not able to add screenshot to Report");
			}
		}
		report.flush();
	}

}
