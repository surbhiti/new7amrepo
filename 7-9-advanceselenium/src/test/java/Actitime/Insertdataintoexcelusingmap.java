package Actitime;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Insertdataintoexcelusingmap {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/main/resources/exceldat.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet4");
		
		LinkedHashMap<String, String> map = new LinkedHashMap<String,String>();
		map.put("surbhi", "Tiwari");
		map.put("ritu", "shrivatri");
		map.put("Bhawana", "singh");
		map.put("navneet", "pannu");
		
		int rowno=0;
		for(Entry<String, String> m:map.entrySet())
		{
			Row row = sheet.createRow(rowno++);
			row.createCell(0).setCellValue(m.getKey());
			row.createCell(1).setCellValue(m.getValue());
				
			
		}
		
		
		FileOutputStream fos = new FileOutputStream("./src/main/resources/exceldat.xlsx");
		book.write(fos);
		book.close();
		System.out.println("data write sucessfully");

		
	}

}
