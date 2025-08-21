package pageFactoryExamples.pageFactoryProject;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Add the note that: 
 * In AbstractPage.java, lump in the Selenium explicit wait methods that are already defind in the Selenium library and 
 * which will, most likely, be used in most testcases.
*  
*/

public class AbstractPage 
{
	WebDriver driver; 
	
	public AbstractPage(WebDriver driver)  // Only constructors are used to catch sent variables from a different class.
	{
		this.driver=driver; 
	}
	
	public void waitForVisibilityOfElement(WebDriver driver, By locator)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	
	public void waitForClickabilityOfElement(WebDriver driver, By locator)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
}