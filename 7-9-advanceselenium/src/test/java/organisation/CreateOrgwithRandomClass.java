package organisation;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgwithRandomClass {

	public static void main(String[] args) throws Throwable {
	
		Random r = new Random();
		int ran = r.nextInt(1000);
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		String orgname = "wipro"+ran;
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.id("phone")).sendKeys("9878987689");
		driver.findElement(By.id("email1")).sendKeys("kavita@gmail.com");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(AdminImg).perform();
		
         driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("Logout successfull");
		
		

	}

}
