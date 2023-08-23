package products;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import generic_utility.Execl_utility;
import generic_utility.File_utility;
import generic_utility.Java_utility;
import generic_utility.Webdriver_utility;

public class DeleteCreatedProduct {

	public static void main(String[] args) throws Throwable {
		File_utility flib = new File_utility();
	    String URL = flib.getKeyAndValue("url");
	    String UN = flib.getKeyAndValue("username");
	    String PW = flib.getKeyAndValue("pwd");
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		Java_utility jlib = new Java_utility();
		int ranno = jlib.getranno();
		
		Execl_utility elib = new Execl_utility();
		String data = elib.getExcelDataUsingDataformetter("Products", 0, 0);
		
		String proname=data+ranno;
		driver.findElement(By.name("productname")).sendKeys(proname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		String ProHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		System.out.println(ProHeader);
		
		driver.findElement(By.linkText("Products")).click();

		WebElement serachbox = driver.findElement(By.id("bas_searchfield"));
		
		Webdriver_utility wlib = new Webdriver_utility();
		wlib.selectClassbyvalue(serachbox, "productname");

		    driver.findElement(By.name("submit")).click();
			driver.findElement(By.name("search_text")).sendKeys(proname);
			driver.findElement(By.name("submit")).click();
			Thread.sleep(2000);
			
		driver.findElement(By.id("selectCurrentPageRec")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		wlib.alertAccept(driver);

	}

}
