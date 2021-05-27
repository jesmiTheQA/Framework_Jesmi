package com.learning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver lDriver) {
		this.driver = lDriver;
	}

	@FindBy(xpath = "//input[@type='text']")
	WebElement uName;
	@FindBy(xpath = "//input[@name='password']")
	WebElement uPassword;
	@FindBy(xpath = "//input[@value='login']")
	WebElement login;

	public void CRMLogin(String CRMusername, String CRMPassword) throws InterruptedException {
		try {
			// WebDriverWait wait = new WebDriverWait(driver, 10);
			Thread.sleep(2000);
			uName.sendKeys(CRMusername);

			// wait.until(ExpectedConditions.visibilityOf(uname));
			uPassword.sendKeys(CRMPassword);
			login.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Error is from class:LoginPage and Method: CRMLogin()- " + e.toString());
		}

	}

}
