package vtiger.Practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Simpleproject {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//launch the browser
		driver.get("http://localhost:8888");
       
		//login to app
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//click on organisation link
		
		/*driver.findElement(By.linkText("Organizations")).click();
		
		//click on create organisation
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//create organisation give name
		
		driver.findElement(By.name("accountname")).sendKeys("ABC");
		
		//select chemical industry from dropdown
		
		WebElement industry = driver.findElement(By.name("industry"));
		Select sel = new Select(industry);
		sel.selectByValue("Chemicals");
		
		//save
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(OrgHeader.contains("ABC"))
		{
			System.out.println("passed");
			System.out.println(OrgHeader);
			
			
		}
		else
		{
			System.out.println("fail");
		}*/
		
		//logout
	
		/*WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(AdminImg).perform();
		
         driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("Logout successfull");*/
		WebElement profile = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).perform();
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
