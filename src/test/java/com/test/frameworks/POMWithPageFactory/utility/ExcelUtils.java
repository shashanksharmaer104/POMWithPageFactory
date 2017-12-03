package com.test.frameworks.POMWithPageFactory.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static XSSFWorkbook ExcelWBook = null;
	public static XSSFSheet ExcelWSheet = null;
	public static XSSFRow Row = null;
	public static XSSFCell Cell = null;
	
	public static Object[][] getTableArray(String filePath, String sheetName) throws IOException {
		String[][] tabArray = null;
		
		FileInputStream ExcelFile = new FileInputStream(filePath);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		
		int startRow = 1;
		int startCol = 1;
		int totalRows = ExcelWSheet.getLastRowNum();
		int totalCols = 2;
		
		int ci,cj;
		
		tabArray = new String[totalRows][totalCols];
		ci=0;
		
		for (int i=startRow;i<=totalRows;i++, ci++) {           	   

			cj=0;

			for (int j=startCol;j<=totalCols;j++, cj++){

				try {
					tabArray[ci][cj] = getCellData(i,j);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(tabArray[ci][cj]);  
			}
		}
		return(tabArray);
	}
	
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			@SuppressWarnings("deprecation")
			int dataType = Cell.getCellType();
			if  (dataType == 3) {
				return "";
			}else{
				String CellData = Cell.getStringCellValue();
				return CellData;
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);
		}
	}
}
