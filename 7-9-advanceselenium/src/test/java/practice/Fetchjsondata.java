package practice;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Fetchjsondata {

	public static void main(String[] args) throws Throwable, IOException {
		File file = new File("./src/test/resources/actitime.json");
		
		ObjectMapper jsondata = new ObjectMapper();
		JsonNode data = jsondata.readTree(file);

		String URL = data.get("url").asText();
				
		 WebDriver driver = new ChromeDriver();
		driver.get(URL);
		
		
	}

}
