package pageFactoryExamples.pageFactoryProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class faceBookLogin {
	
	@Test
	public void faceBookLoginTest() throws InterruptedException
	{
	
	WebDriver driver = new ChromeDriver(); 
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	faceBookLoginPage object= new faceBookLoginPage(driver);
	object.goTo("https://www.facebook.com/"); // in real-time the URL value id fed to the test case from ..(same comment below)
	
	/* Normally, the next line should be:
	 * 
	 * driver.findElement(By.cssSelector("")).sendKeys(""); 
	 * 
	 * However; in real-time locators need to be fed to the testcase from a page object or page factory .java class file.
	 *          & since locators are, most of time, included in the 'driver.findElement' statement
	 *          then, both the statement and its locator has to be fed to the test case from a page object/factory .java class file.
	 *          
	 *          Therefore, the 'driver' object [of the WebDriver interface] created here is to be sent/passed to the file
	 *          containing the locators:- (No to, again, re-creating 'driver' as an object of WebDriver in the page factory class).
	 *          
	 *          This can be achieved via creating, in this class,  an object x of the class containing 
	 *          the locators. This object x is parameterized with the driver object created here which 
	 *          requires the creation of a parameterized constructor in the class containing the locators.
	 *          
	 *          And that's how the 'driver' object in this class is sent/passed to the one containing the locators.
	 *          
	 */
	 
	String email= "someemail@gmail.com"; // in real-time these values are fed to the test case.
	String password= "Gibberish123";        // from a file that is anything but an object repository file
	
	object.emailField().sendKeys("adding some letters for automation");
	Thread.sleep(4000L);	
	object.emailFieldElement.clear(); //as opposed to: emailField().sendKeys cuz script already waited for visibility of email field
	Thread.sleep(4000L);
	object.loginApplication(email, password);      // as the latter should contain nothing but locators & action method(s)
	
	
	}

}
