package vtiger.Practice;

import java.io.FileInputStream;
import java.util.Properties;

public class Propertyfileex {
	
	public static void main(String[] args) throws Throwable{
		
		//load the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\data.properties");
		
		//create object of property class
		Properties pro = new Properties();
		
		//load the file
		pro.load(fis);
		
		//provide the key and get the value
		String URL = pro.getProperty("url");
		System.out.println(URL);
		
		
	}

}
