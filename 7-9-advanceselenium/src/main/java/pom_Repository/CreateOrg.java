package pom_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrg
{
	public CreateOrg(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    @FindBy (xpath="//img[@title='Create Organization...']")
    private WebElement CreateOrgImg;
    
    
    @FindBy (name="accountname")
    private WebElement Orgname;
    
    @FindBy (id="phone")
    private WebElement Phnno;
    
    @FindBy (id="email1")
    private WebElement Email;
	
    @FindBy (xpath="//input[@title='Save [Alt+S]']")
    private WebElement SaveButton;

	public WebElement getCreateOrgImg() {
		return CreateOrgImg;
	}

	public WebElement getOrgname() {
		return Orgname;
	}

	public WebElement getPhnno() {
		return Phnno;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

//Buisness Logic
	
	public void CreateOrganisation(String name,String phone,String email)
	{
		CreateOrgImg.click();
		
		Orgname.sendKeys(name);
		Phnno.sendKeys(phone);
		Email.sendKeys(email);
		
		SaveButton.click();
		
		
	}
}



