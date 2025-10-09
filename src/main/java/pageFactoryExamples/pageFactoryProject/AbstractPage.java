package pageFactoryExamples.pageFactoryProject;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Add the note that: 
 * In AbstractPage.java, lump in the Selenium explicit wait methods that are already defind in the Selenium library and 
 * which will, most likely, be used in most testcases.
 * 
 * So many many Selenium utilities could all be lumped in here:
 * Explicit Wait methods, switching to frame, switching to windows, JavaScript executor, Alert handlings
 * , etc.etc. ALL RE-USABLE code could be included here.
 */

public class AbstractPage
{
	WebDriver driver; 
	WebElement wantedElement_productBoxBorder;

	
	public AbstractPage(WebDriver driver)  // Only constructors are used to catch sent variables from a different class.
	{
		this.driver=driver; 
	}
	
	
	
	public void waitForVisibilityOfElement(WebDriver driver, By locator) // or waitForElementToAppear
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	
	public void waitForClickabilityOfElement(WebDriver driver, By locator)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	public void waitForClickabilityOfElement_miniDriver(WebDriver driver, By locator, WebElement element)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.elementToBeClickable(element.findElement(locator))); 
	// it is the method:  .elementToBeClickable(WebElement element)    instead of   .elementToBeClickable(By locator)
	
	}
	
	
	
	public void waitForVisibilityOfAllElements(WebDriver driver, By locator)
	{
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	
}