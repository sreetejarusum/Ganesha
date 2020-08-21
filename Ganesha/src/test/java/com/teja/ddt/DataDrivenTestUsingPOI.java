package com.teja.ddt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTestUsingPOI {
	
	public static String file="//Ganesha//data//FinalPlan.xlsx";
	public static FileInputStream fis;
	public static Properties props;
	public static XSSFWorkbook workbook;
	public static int sheetCount;
	public static String sheetName="td2";
	
	public static void main(String[] args) throws IOException {
		
		fis=new FileInputStream(file);
		workbook=new XSSFWorkbook(fis);
		
		sheetCount=workbook.getNumberOfSheets();
		
		for(int i=0;i<sheetCount;i++) {
			if(workbook.getSheetAt(i).equals(sheetName)) {
				XSSFSheet sheet=workbook.getSheetAt(i);
			}
		}
		
	}

}
