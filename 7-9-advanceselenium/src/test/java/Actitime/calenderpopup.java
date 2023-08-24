package Actitime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calenderpopup {
//Welcome to calendar
	public static void main(String[] args) throws Throwable {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/flights/");
	     Actions act = new Actions(driver);
	     act.moveByOffset(10, 10).click().perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		Thread.sleep(4000);
		WebElement data = driver.findElement(By.xpath("//div[text()='July 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='30']"));
		Thread.sleep(2000);
		data.click();
		//calendar done
	}

}
