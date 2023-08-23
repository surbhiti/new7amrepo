package camapign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampPage {
	public CreateCampPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusbutton;
	
	@FindBy(name="campaignname")
	private WebElement Camptext;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;

	public WebElement getPlusbutton() {
		return plusbutton;
	}

	public WebElement getCamptext() {
		return Camptext;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	
	
	//Buisness Logic
	
	public void CreateCampaigns(String name)
	{
		plusbutton.click();
		Camptext.sendKeys(name);
		savebutton.click();
	}
}
