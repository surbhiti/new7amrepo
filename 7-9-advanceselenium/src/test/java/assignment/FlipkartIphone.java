package assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipkartIphone {

	public static void main(String[] args) throws Throwable {
		
	
	FileInputStream fis = new FileInputStream("./src/main/resources/data.properties");	
	Properties pro = new Properties();
	pro.load(fis);
	String URL = pro.getProperty("url1");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(URL);
	driver.findElement(By.xpath("//button[contains(@class,'_2KpZ6l _2doB4z')]")).click();
    driver.findElement(By.name("q")).sendKeys("iphone",Keys.ENTER);

	
	
	List<WebElement> iphone = driver.findElements(By.xpath("//div[@class='']"));
	List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	int count=0;
    
	
	for(WebElement wb:iphone )
    {
    	System.out.println(wb.getText());
    	count++;
    	
    }
        System.out.println("all links"+count);
	}

}
