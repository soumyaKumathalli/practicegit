package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class ExcelUtil {
	
	
private static final String TEST_DATA_SHEET_PATH="./src/test/resources/TestData/Opencartexcel.xlsx";
private Workbook book;
private static Sheet sheet;
	
public Object[][] getTestdata(String sheetname) {
	Object data[][]=null;
	try {
		//get the path of the file
		FileInputStream ip=new 	FileInputStream(TEST_DATA_SHEET_PATH);
		//add the file to workbook class
		book=WorkbookFactory.create(ip);
		//after adding the xcel to book get sheet name
		sheet=book.getSheet(sheetname);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//so first it will take no of columns count and the first row how many columns are that count
	data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for(int i=0;i<sheet.getLastRowNum();i++) {
		for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();//here string is used because it needs to be converted to java string
			
		}
	}
	return data;
}

}
