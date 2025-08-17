package pageFactoryExamples.pageFactoryProject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AbstractPage 
{
	WebDriver driver; 
	
	public AbstractPage(WebDriver driver)  // Only constructors are used to catch sent variables from a different class.
	{
		this.driver=driver; 
	}
	
	public void waitForEmailField(WebDriver driver, By emailExplicit)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(emailExplicit));
	}

}
