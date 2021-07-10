package com.gale.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExCelReader {
	public static String getCellvalue(int sheetNumber,int row,int cell) {
		String cellValue = null;
		try {
			// Specify the path of file
			File src = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\FaceBook.xlsx");

			// load file
			FileInputStream fis = new FileInputStream(src);

			// Load workbook
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Load sheet- Here we are loading first sheetonly
			XSSFSheet sh1 = wb.getSheetAt(0);

			cellValue= sh1.getRow(row).getCell(cell).getStringCellValue();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
		return cellValue;
	}
	
	public static void main(String[] args) {
		System.out.println(ExCelReader.getCellvalue(0,1,1));
	}
}
