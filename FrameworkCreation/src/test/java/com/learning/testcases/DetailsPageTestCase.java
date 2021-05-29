package com.learning.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learning.pages.BaseClass;
import com.learning.pages.DetailsPage;
import com.learning.pages.LoginPage;

public class DetailsPageTestCase extends BaseClass{
	
	@Test
	public void detalsPageTest() {
		
//		LoginCRMTestcase loginPageTstcase=new LoginCRMTestcase();
//		try {
//			loginPageTstcase.loginApp();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		logger = report.createTest("Details Page");
		DetailsPage detailsPage = PageFactory.initElements(driver, DetailsPage.class);
		logger.info("Starting the application");
		detailsPage.enterDetails(excel.getStringData("CRM_1",0,3), excel.getStringData("CRM_1",0,4));
		logger.pass("Login success");
		helper.captureScreenshots(driver);
		
	}
	
	

}
