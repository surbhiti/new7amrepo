package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Execl_utility {

	public String getExcelData(String Sheetname,int rowno,int cellno) throws Throwable, IOException {
		FileInputStream fes = new FileInputStream("./src/main/resources/Vtiger.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(Sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		
		
		String Exceldata = cell.getStringCellValue();
		return Exceldata;
		
		}
	
	public String getExcelDataUsingDataformetter(String Sheetname,int rowno,int cellno) throws Throwable, IOException 
	
	{
		FileInputStream fes = new FileInputStream("./src/main/resources/Vtiger.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(Sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		
		
		DataFormatter Formatter = new DataFormatter();
		String Exceldata = Formatter.formatCellValue(cell);
		return Exceldata;
		
		
	}
}
