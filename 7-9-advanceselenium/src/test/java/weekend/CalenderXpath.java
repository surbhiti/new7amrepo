package weekend;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderXpath {

	public static void main(String[] args) 
	
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//div[@class='sc-gKclnd hSnAGZ']")).click();
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 dRQhOp']")).click();
		//driver.findElement(By.xpath("//span[@class='sc-gKclnd hSnAGZ']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		/*driver.findElement(By.xpath("//div[text()='August 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='24']"))
		.click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();*/
		
		//make xpath dynamic
		String month = "August 2023";
		String day = "30";
		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']"))
		.click();
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		
		//driver.findElement(By.xpath("//span[text()='Travellers & Class']")).click();
		
		//make dynamic xpath
		
		//make it dynamic
		//String person = "Adults";
		//int noofperson=2;
		driver.findElement(By.xpath("(//p[text()='Adults']/ancestor::div[@class='sc-12foipm-78 dLDesG']/descendant::span[@class='sc-12foipm-64 hkDsNh'])[2]")).click();
		driver.findElement(By.xpath("(//p[text()='Children']/ancestor::div[@class='sc-12foipm-78 dLDesG']/descendant::span[@class='sc-12foipm-64 hkDsNh'])[4]")).click();
		driver.findElement(By.xpath("(//p[text()='Infants']/ancestor::div[@class='sc-12foipm-78 dLDesG']/descendant::span[@class='sc-12foipm-64 hkDsNh'])[6]")).click();
		driver.findElement(By.linkText("Done")).click();
		
		
	}
	

}
