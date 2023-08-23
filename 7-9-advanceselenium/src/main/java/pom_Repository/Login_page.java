package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	
	public Login_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy,@FindBys,@FindAll
	
	@FindBy(name="user_name")
	private WebElement usertext;
	
	@FindBy(name="user_password")
	private WebElement pwdtext;
	
	@FindBy(id="submitButton")
	private WebElement submit;

	public WebElement getUsertext() {
		return usertext;
	}

	public WebElement getPwdtext() {
		return pwdtext;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	//BuisnessLogics
	
	public void LogInToVtiger(String UN,String PW )
	{
		usertext.sendKeys(UN);
		pwdtext.sendKeys(PW);
		submit.click();
		
	}

}
