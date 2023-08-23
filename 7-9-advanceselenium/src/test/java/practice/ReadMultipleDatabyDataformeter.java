package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDatabyDataformeter {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/main/resources/exceldat.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet2");
		int rows = sheet.getLastRowNum();
		
	     for(int i=0;i<rows;i++)
			
		{
			Row r = sheet.getRow(i);
			short cells = r.getLastCellNum();
			for(int j=0;j<=cells;j++)
			{
				Cell c = r.getCell(j);
				DataFormatter formetter = new DataFormatter();
				String data = formetter.formatCellValue(c);
				System.out.println(data);
			}
			
			
		}

	}

}
