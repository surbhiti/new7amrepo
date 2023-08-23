package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_utility {
	
	/**
	 * This method is used for launching application
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getKeyAndValue(String key) throws Throwable 
	
	{
		FileInputStream fis = new FileInputStream("./src/main/resources/data.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
		
		
	}
	

}
