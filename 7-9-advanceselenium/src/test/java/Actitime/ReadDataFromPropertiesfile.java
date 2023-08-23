package Actitime;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromPropertiesfile {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/main/resources/adseldata.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String UN = pro.getProperty("username");
		String PW = pro.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(UN);
		driver.findElement(By.name("pwd")).sendKeys(PW);
		driver.findElement(By.id("loginButton")).click();
	}

}
