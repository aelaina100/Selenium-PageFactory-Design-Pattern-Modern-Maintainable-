package pageFactoryExamples.pageFactoryProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class faceBookLoginPage extends AbstractPage {
	
	WebDriver driver;
	
	public faceBookLoginPage(WebDriver driver) // Only constructors are used to catch sent variable(s) from a different class.
	{                                        // Sent via either: mere object creation, in the other class, parameterized w the variables(s)
		                                     //                : or the 'Super' keyword, in the child class, parameterized w the variable
		                                      //                 to be sent to the parent class.
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this); 
		// arguments: initializes this local global 'driver' object  that now equals the passed one from
		 // the actual test case where it was defined as an object of the 'WebDriver' interface.
	}
	
	
	@FindBy(id= "email")
	WebElement emailFieldBox; // this line:
	// In run-time, it will be constructed to: WebElement emailField= driver.findElement(By.id("email"));
		// this is reason why the 'driver' object was initialized in the previous immediate line.
	
	// Now this WebElement could be accessed from the testcase file using line Z:  object.emailFieldBox.sendKeys()  .However;
	// above line Z, there should be an explicit wait targetting it. But, for easier maintenance include synchronization in a separate
	// Abstract.java class accompanied with, in this class, creating an emailFieldMethod that: 1- on 1st line: Calls the synchronization 
	// method  from the abstract class 2- On the second line: returns this emailFieldBox variable of the 'WebElement' type 
	// so that in the actual testcase file:- emailField() after executing all its line of code becomes equal to 
	
	// emailFieldBox (That is: driver.findElement(By.id("email")) where an action could be attached to it such .SendKeys("") etc.
	// if this value is retuned it means that the synchronization lines of code passed (didn't throw an exception as a result
	// of the field box element not being visible or whatever the condition that you choose for synchronization.
	
	
	By emailExplicit= By.id("email");
	public WebElement emailField()
	{
		waitForEmailField(driver, emailExplicit); //Since both 'AbstractPage' (Parent) & faceBookLoginPage
		                                           // (child) are untility classes (non contain the
		                                            //  main/@TestNg annotation where the controller
		                                             // starts executing, then no object creation of
		                                             // this child class is necessary.
		 return emailFieldBox; // future exercise: remove the 'return' keyword and go from there.
	}	
	
	
	
	@FindBy(id= "pass")
	WebElement passwordField;
	
	@FindBy(name= "login")
	WebElement loginButton;
	//Note: double click on @FindBy to find the correct spelling of all the locators.
	
	//Below: An action method for logging in. It's needed by every test case.
	//       An action method = the name of such methods defined in an object repository class.
	
	public void loginApplication(String email, String password)
	{
		emailField().sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	
	// Another action method.
	public void goTo(String url)  // Personally I don't see the point of this ! 
	{                              // as simply, driver.get(""); in the actual testcase .java class file, 
		                            // optimizes our code as opossed to including it in this Action class !.
		driver.get(url);             // so, for now, leave this Action method here as is and let's see later.
	}
}
