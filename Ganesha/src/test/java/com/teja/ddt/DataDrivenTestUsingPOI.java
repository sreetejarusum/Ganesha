package com.teja.ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTestUsingPOI {

	public String file = "C:\\Teja\\Teja2.0\\FrameWork\\Ganesha\\data\\FinalPlan.xlsx";
	public FileInputStream fis;
	public Properties props;
	public XSSFWorkbook workbook;
	public int sheetCount;
	public String sheetName = "td2";
	public String columnName = "TC's";
	public int columnNumber;
	public String data = "Checkout";
	public ArrayList<String> testdata;

	/**
	 * This Utility Accpts SheetName,ColumnName and Data
	 * @param SheetName
	 * @param columnName
	 * @param data
	 * @return
	 * @throws IOException
	 */
	
	public ArrayList<String> getTestData(String SheetName, String columnName, String data) throws IOException {
		testdata = new ArrayList<String>();
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet(sheetName);

		Iterator<Row> rows = sheet.iterator();
		Row firstRow = rows.next();

		Iterator<Cell> cells = firstRow.cellIterator();
		int i = 0;
		while (cells.hasNext()) {

			if (cells.next().getStringCellValue().equalsIgnoreCase(columnName)) {

				columnNumber = i;
			}
			i++;
		}

		while (rows.hasNext()) {
			Row r = rows.next();
			if (r.getCell(columnNumber).getStringCellValue().equalsIgnoreCase(data)) {

				Iterator<Cell> cl = r.cellIterator();
				while (cl.hasNext()) {

					Cell c = cl.next();

					if (c.getCellType() == CellType.STRING) {
						System.out.println(c.getStringCellValue());
					} else {
						System.out.println(NumberToTextConverter.toText(c.getNumericCellValue()));

					}

				}
			}
		}
		return testdata;
	}

}
