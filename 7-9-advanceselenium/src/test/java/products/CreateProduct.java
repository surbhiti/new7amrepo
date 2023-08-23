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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.Execl_utility;
import generic_utility.File_utility;
import generic_utility.Java_utility;
import generic_utility.Webdriver_utility;
import pom_Repository.CreateProductPage;

public class CreateProduct {

	public static void main(String[] args) throws Throwable {
		
		File_utility flib = new File_utility();
		String URL=flib.getKeyAndValue("url");
		String UN=flib.getKeyAndValue("username");
		String PW=flib.getKeyAndValue("pwd");
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		Java_utility jlib = new Java_utility();
		int ranno = jlib.getranno();
		
		Execl_utility elib = new Execl_utility();
		String exceldata = elib.getExcelDataUsingDataformetter("Products", 0, 0);
		
		String proname = exceldata+ranno;
		
		/*driver.findElement(By.name("productname")).sendKeys(proname);
		
		WebElement ele = driver.findElement(By.linkText("vtiger.com"));
		
		Thread.sleep(2000);
		
		//Webdriver_utility wlib = new Webdriver_utility ();
		//wlib.scrollPage(driver, ele);
		
		
	    Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
	CreateProductPage CP = new CreateProductPage(driver);
	CP.createProduct(proname);

		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
}
