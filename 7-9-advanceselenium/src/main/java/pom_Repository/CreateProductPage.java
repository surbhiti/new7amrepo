package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    @FindBy (xpath="//img[@title='Create Product...']")
    private WebElement CreateProImg;
    
    @FindBy (name="productname")
    private WebElement Proname;
    
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement Savebutton;

	public WebElement getCreateProImg() {
		return CreateProImg;
	}

	public WebElement getProname() {
		return Proname;
	}

	public WebElement getSavebutton() {
		return Savebutton;
	}
   
	




//Buisness Logic

	public void createProduct(String name)
	{
		CreateProImg.click();
		Proname.sendKeys(name);
		Savebutton.click();
	}
    

}
