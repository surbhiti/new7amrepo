package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Fetchsingledata {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/main/resources/exceldat.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet5");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		
		/*String data = cell.getStringCellValue();
		System.out.println(data);*/ //wrong approach as it is integer value
		
		DataFormatter formetter = new DataFormatter();
		String data = formetter.formatCellValue(cell);
		System.out.println(data);
	

	}

}
