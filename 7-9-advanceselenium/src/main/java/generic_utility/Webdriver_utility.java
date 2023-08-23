package generic_utility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_utility 
/**
 * this method is for maximise window
 */
{
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * this method used to wait till GUI load 
	 * @param driver
	 */
	public void implicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void fLuentWait(WebDriver driver,WebElement ele)
	{
		FluentWait wait = new FluentWait( driver);
		wait.pollingEvery(Duration.ofMillis(200));
		wait.withTimeout(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	/**
	 * this method is for switching window
	 */

public void switchingWindow(WebDriver driver,String Visibletext) 
{
	Set<String> allwindows = driver.getWindowHandles();
	Iterator<String> id = allwindows.iterator();
	while(id.hasNext())
	{
		String win = id.next();
		driver.switchTo().window(win);
		String title = driver.getTitle();
		if(title.contains(Visibletext))
		{
			break;
		}
	}
}

/**
 * this method is for action class
 * 
 */
public void moveToElement(WebDriver driver,WebElement ele)
{
	Actions act = new Actions(driver);
	act.moveToElement(ele).perform();
	
}
/**
 * This method to scroll the page
 * @param driver
 * @param ele
 */
public void scrollPage(WebDriver driver,WebElement ele)
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView()", ele);
	}
/**
 * select by value
 * @param ele
 * @param visibleText
 */
public void selectClassbyvalue(WebElement ele, String visibleText)
{
	Select sel = new Select(ele );
	sel.selectByValue(visibleText);
}
/**
 * accept the popup
 * @param driver
 */

public void alertAccept(WebDriver driver)
{
	Alert alt = driver.switchTo().alert();
	alt.accept();
}
/**
 * dismiss the popup
 * @param driver
 */
public void alertAdismiss(WebDriver driver)
{
	Alert alt = driver.switchTo().alert();
	alt.dismiss();
}

/**
 * these nethods are for switching to frame
 * @param driver
 * @param index
 */
public void switchToframe(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
	}

public void switchToframe(WebDriver driver,String id_name_attribute)

{
	driver.switchTo().frame(id_name_attribute);
}

public void switchBackfromFrame(WebDriver driver)
{
	driver.switchTo().defaultContent();
	}
}


