package camapign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;

import generic_utility.Execl_utility;
import generic_utility.File_utility;
import generic_utility.Java_utility;
import pom_Repository.Home1Page;

import pom_Repository.Login_page;

public class Campaigns {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new EdgeDriver();
		File_utility flib = new File_utility();
		String URL = flib.getKeyAndValue("url");
		String UN = flib.getKeyAndValue("username");
	    String PW = flib.getKeyAndValue("pwd");
	    driver.get(URL);
	    
	   Login_page login = new Login_page(driver);
	   login.LogInToVtiger(UN, PW);
		
	   Home1Page home=new Home1Page(driver);
	   
	    home.clickMoreLink(driver);
	    home.clickCamplink();
	    Java_utility jlib = new Java_utility();
		int ranno = jlib.getranno();
		Execl_utility elib = new Execl_utility();
		String campname = elib.getExcelData("Campaigns", 0, 0)+ranno;
		CreateCampPage Camp = new CreateCampPage(driver);
		Camp.CreateCampaigns(campname);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
	  
	
	}

}
