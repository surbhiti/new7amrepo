package camapign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utility.Execl_utility;
import generic_utility.File_utility;
import generic_utility.Java_utility;
import generic_utility.Webdriver_utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom_Repository.Login_page;

public class Createcampwithproduct {

	public static void main(String[] args) throws Throwable {
		
		    File_utility flib = new File_utility();
		    String URL = flib.getKeyAndValue("url");
		    String UN = flib.getKeyAndValue("username");
		    String PW = flib.getKeyAndValue("pwd");
		    String BROWSER = flib.getKeyAndValue("browser");
		    WebDriver driver;
		    if(BROWSER.equalsIgnoreCase("chrome"))
		    {
		    	WebDriverManager.chromedriver().setup();
		    	driver=new ChromeDriver();
		    }
		    else if(BROWSER.equalsIgnoreCase("edge"))
		    	
		    {
		    	WebDriverManager.edgedriver().setup();
		    	driver=new EdgeDriver();
		    	
		    }
		    
		    else {
		    	
		    	driver=new ChromeDriver();
		    }
		    
		
		driver.get(URL);
		Login_page loginpage = new Login_page(driver);
		loginpage.LogInToVtiger(UN, PW);
		/*driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).click();*/
		
		WebElement more = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		
		/*Actions act = new Actions(driver);
		act.moveToElement(more).perform();*/
		Webdriver_utility wlib = new Webdriver_utility();
		wlib.actionClass(driver, more);
		
		driver.findElement(By.name("Campaigns")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		//window Handling
		String main = driver.getWindowHandle();
		System.out.println(main);
		
		Set<String> all = driver.getWindowHandles();
		
		for(String id:all)
		{
			if(!main.equals(id))
			{
				driver.switchTo().window(id);
				Thread.sleep(2000);
				driver.findElement(By.id("search_txt")).sendKeys("puma560");
				driver.findElement(By.name("search")).click();
				driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
				
			}
			
			
		}
		
		driver.switchTo().window(main);
		
		Thread.sleep(2000);
		
		Java_utility jlib = new Java_utility();
		int ranno = jlib.getranno();
		
		Execl_utility elib = new  Execl_utility();
		String campname = elib.getExcelDataUsingDataformetter("Campaigns", 0, 0)+ranno;
		
		Thread.sleep(2000);
		driver.findElement(By.name("campaignname")).sendKeys(campname);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//scroll By JavaExecutor
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)", ",");
			

	}

}
