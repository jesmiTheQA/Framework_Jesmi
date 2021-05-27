package com.learning.utility;

import java.io.File;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public String captureScreenshots(WebDriver driver) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotFilePath=System.getProperty("user.dir")+ "./Screenshots/_" + getCurrentDateTime() + ".png";
		try {
			FileHandler.copy(src, new File(screenshotFilePath));
		} catch (Exception e) {
			System.out.println("Unable to capture Screenshots" + e.getMessage());
		}
		return screenshotFilePath;
	}

	public String getCurrentDateTime() {
//		DataFormat CustomFormat=(DataFormat) new SimpleDateFormat("MM_dd_yyyy_HH_MM_SS");
//		Date currentDate=new Date();
//		CustomFormat.getFormat(currentDate)
		DateTimeFormatter CustomFormat = DateTimeFormatter.ofPattern("MM_dd_yyyy_HH_mm_ss");
		LocalDateTime currentDate = LocalDateTime.now();
		return CustomFormat.format(currentDate);
	}
}
