package com.learning.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() { //using constructor
		File src = new File("./TestData/TestData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read excel file: " + e.getMessage());
		}

	}

	public String getStringData(int SheetIndex, int rowNumber, int columnNumber) { // Method overloading - 1 >> Method
																					// name is same, same number of
																					// parameter but type is different
		return wb.getSheetAt(SheetIndex).getRow(rowNumber).getCell(columnNumber).getStringCellValue();
	}

	public String getStringData(String sheetName, int rowNumber, int columnNumber) { // Method overloading - 1
		return wb.getSheet(sheetName).getRow(rowNumber).getCell(columnNumber).getStringCellValue();
	}

	public double getIntegerData(String sheetName, int rowNumber, int columnNumber) {
		return wb.getSheet(sheetName).getRow(rowNumber).getCell(columnNumber).getNumericCellValue();
	}

}
