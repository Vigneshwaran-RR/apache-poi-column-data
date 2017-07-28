package com.vignesh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ApachePoiColumnData {

	public static void main(String[] args) {
			
		try{ 
			// Excel File initialize
			File src=new File("/test.xlsx");		 
			FileInputStream inputStream = new FileInputStream(src);		 
			Workbook workbook = new XSSFWorkbook(inputStream);
			org.apache.poi.ss.usermodel.Sheet firstSheet = workbook.getSheetAt(0);
			Row firstRow = firstSheet.getRow(firstSheet.getFirstRowNum());
			Integer noOfColumns = new Integer(firstRow.getLastCellNum()); // Get No of columns
			Integer noOfRows = new Integer(firstSheet.getLastRowNum()); // Get No of Rows
			// Empty Map to store the data from excel
			Map<Integer,List> data = new HashMap<>();
			// Loop through the each columns and store its value to the map - data
			for(int i = 0 ; i < noOfColumns ; i++) {
				List listData = new ArrayList<>();
				for(Row row : firstSheet) {
				 Cell cell = row.getCell(i);
				 listData.add(cell.getStringCellValue());
				}
				// Insert values to the map column wise
				data.put(i, listData);
				// Print the values through sysout
				System.out.println(data.toString());
			}
			
		}
		 catch(Exception ex) {
			ex.printStackTrace();
		} 
	}
}
