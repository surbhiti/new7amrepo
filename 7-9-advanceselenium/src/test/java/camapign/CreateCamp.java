package camapign;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.Execl_utility;
import generic_utility.File_utility;
import generic_utility.Java_utility;
import generic_utility.Webdriver_utility;
import pom_Repository.Home1Page;

import pom_Repository.Login_page;



public class CreateCamp {

	public static void main(String[] args) throws Throwable {
		
		
		File_utility flib = new File_utility();
		String URL = flib.getKeyAndValue("url");
		String UN = flib.getKeyAndValue("username");
		String PW = flib.getKeyAndValue("pwd");
		
		
		
		
		/*FileInputStream fis = new FileInputStream("./src/main/resources/data.properties");
		Properties pro = new Properties();
		pro.load(fis);
		
		String URL = pro.getProperty("url");
		String UN = pro.getProperty("username");
		String PW = pro.getProperty("pwd");*/
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		
		 Login_page login = new Login_page(driver);
		 login.LogInToVtiger(UN, PW);
		/*driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);*/
		
		
		/*WebElement more = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(more).perform();
		
		
		Webdriver_utility wlib = new Webdriver_utility ();
		wlib.moveToElement(driver, more);
		
		driver.findElement(By.name("Campaigns")).click();*/
		
		Home1Page home = new Home1Page(driver);
		home.clickMoreLink(driver);
		home.clickCamplink();
		
		
		
		
		/*FileInputStream fes = new FileInputStream("./src/main/resources/Vtiger.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet("Campaigns");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);*/
		
		Java_utility jlib = new Java_utility();
		int ranno = jlib.getranno();
		Execl_utility elib = new Execl_utility();
		String campname = elib.getExcelData("Campaigns", 0, 0)+ranno;
		
		/*Random ran = new Random();
		int ranno = ran.nextInt(1000);*/
		//String campname = cell.getStringCellValue()+ranno;
		/*driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campname);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
		
		CreateCampPage Camp = new CreateCampPage(driver);
		Camp.CreateCampaigns(campname);
		
		//validation
		
		String actdata = driver.findElement(By.xpath("//td[@id='mouseArea_Campaign Name']")).getText();
		
		if(actdata.contains(campname))
		{
			System.out.println("pass");
		}
		else
			System.out.println("fail");
		
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		//home.logout(driver);
		
		

	}

}
