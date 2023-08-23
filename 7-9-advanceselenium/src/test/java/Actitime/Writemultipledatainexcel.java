package Actitime;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Writemultipledatainexcel {

	public static void main(String[] args) throws Throwable {
		
       FileInputStream fis = new FileInputStream("./src/main/resources/exceldat.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		
		Sheet sheet = book.getSheet("Sheet2");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		List<WebElement> alllinks = driver.findElements(By.xpath("//a")); //all links
		
		for(int i=0;i<alllinks.size();i++)
		{
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(alllinks.get(i).getAttribute("href"));
			
		}
		FileOutputStream fos = new FileOutputStream("./src/main/resources/exceldat.xlsx");
		book.write(fos);
		book.close();
		

	}

}
