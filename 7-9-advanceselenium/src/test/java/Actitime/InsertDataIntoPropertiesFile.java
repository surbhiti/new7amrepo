package Actitime;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class InsertDataIntoPropertiesFile {

	public static void main(String[] args) throws Throwable {
		Properties pro = new Properties();
		pro.setProperty("username", "admin");
		pro.setProperty("password", "admin");
		pro.setProperty("url", "https://demo.actitime.com/login.do");
		
		FileOutputStream fos = new FileOutputStream("./src/main/resources/emptydata.properties.txt");
		pro.store(fos, "data");
		System.out.println("data written successfully");
		

	}

}
