package Actitime;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadsingleDatafromExcel {

	public static void main(String[] args) throws Throwable {
		//step1: set the path
		FileInputStream fis = new FileInputStream("./src/main/resources/exceldat.xlsx");
		
		//step2:open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		
		//step3: get control to the sheet
		Sheet sheet = book.getSheet("Sheet1");
		
		//step4: get control to row
		Row row = sheet.getRow(0);
		
		//step5: get control to column
		Cell cell = row.getCell(0);
		String data = cell.getStringCellValue();
		
		System.out.println(data);
		
	}

}
