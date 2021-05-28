package com.learning.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beust.jcommander.internal.Console;
import com.learning.pages.BaseClass;
import com.learning.pages.LoginPage;
import com.learning.utility.BrowserFactory;
import com.learning.utility.ExcelDataProvider;
import com.learning.utility.Helper;

public class LoginCRMTestcase extends BaseClass {

	//to create test case
	@Test
	public void loginApp() throws InterruptedException {
		try {

			logger = report.createTest("CRM Login");
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			logger.info("Starting the application");
			loginPage.CRMLogin(excel.getStringData("CRM_1", 0, 0), excel.getStringData("CRM_1", 0, 1));
			logger.pass("Login success");
			helper.captureScreenshots(driver);

		} catch (Exception e) {
			System.out.println("Error is from class:LoginCRMTestcase and Method:loginApp() - " + e.toString());
		}

	}

}
