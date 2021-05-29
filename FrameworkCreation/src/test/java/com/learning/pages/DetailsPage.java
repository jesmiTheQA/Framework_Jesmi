package com.learning.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DetailsPage {
	WebDriver driver;
	public DetailsPage(WebDriver iDriver) {
		this.driver=iDriver;
	}
	
	@FindBy(id="txtname")
WebElement name;
	@FindBy(id="ddlDistrict")
	WebElement district;
	
	public void enterDetails(String userName,String userDistrict) {
		name.sendKeys(userName);
		Select districtName = new Select(district);
		districtName.selectByValue(userDistrict);
	
	}

}
