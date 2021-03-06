package com.RestUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataConfig {
	XSSFWorkbook wb;
	XSSFSheet sh1;
	List list;
	public static File excel;
	public ExcelDataConfig(String excelPath)
	{
		try {
			File excel = new File(excelPath);
			FileInputStream fis = new FileInputStream(excel);
			 wb = new XSSFWorkbook(fis);
			 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	public String getData(String sheetname,int row,int column)
	{
		sh1 = wb.getSheet(sheetname);
		
		String data= sh1.getRow(row).getCell(column).getStringCellValue();
		return data;
		
		
	}
	public String getCellData(String sheetname,int row,int column)
	{
		sh1 = wb.getSheet(sheetname);
		DataFormatter formatter = new DataFormatter();
		String val = formatter.formatCellValue(sh1.getRow(row).getCell(column));
		return val;
		
	}
	
	
	
}
