package pageFactoryExamples.pageFactoryProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 

// Page factory/ Page object .java class files contain locators + Synchronization + Action methods (If any).
public class faceBookLoginPage extends AbstractPage {
	
	WebDriver driver;
	// this constructor is the 1st thing to ever execute in this file ! (Just examine its corresponding TC and this would be the conclusion
	// that one would always arrive to!).
	public faceBookLoginPage(WebDriver driver) // Only constructors are used to catch sent variable(s) from a different class.
	{                                        // Sent via either: mere object creation, in the other class, parameterized w the variables(s)
		                                     //                : or the 'Super' keyword, in the child class, parameterized w the variable
		                                      //                 to be sent to the parent class.
		super(driver);
		this.driver= driver; // This local global driver (To the left of the = operator) now equals the passed down 'driver' argument. which is the object from the actual test case. 
		PageFactory.initElements(driver, this); 
		
		// Purpose of the above line: 
		//So that the 'construction', as explained in the code lines below, of combining 'driver' with 'findElement(By..)' and 
		// then storing it in a WebElement type is possible. 
		 //(So the final construction is, for example, :  WebElement emailField= driver.findElement(By.id("email")); )
	}
	// Separate: Click on the different 'driver' words above and see what gets highlighted throughout this .java class file.
	
	// The two lines below reflect the so-called page factory design pattern, 
	// that reduces the syntax of WebElement element = driver.findElement(By.("")
	@FindBy(id= "email")
	WebElement emailFieldElement; // this could be used in the actual TC. However; an explicit wait, above it, targetting this web element
	                         //  is to be executed first, where if this synchronization step passes then the controller proceeds
	                         //  to this driver.findElement() step. For this, the next line should be a method that includes the
	                         // synchronization step plus returning this 'emailFieldElement' web element so that
	                        // , in the actual testcase, an action (.click() or .sendKeys(), etc.) could be attached to this called
	                        // method [because this called method = the returned value = emailFiedBox = driver.findElement() ]
	
	/* In run-time, the above two lines will be constructed to: 
	 *        WebElement emailField= driver.findElement(By.id("email"));
	 *        The construction is possible
		      since 'driver' was already initialized, inside the constructor, by the 'initElements()' method of the 'PageFactory' class.	
		      // Interview Question: How does the @FindBy annotation knows about the driver. The Answer has already been given.     
     */
	
	// Now for easier maintenance include the synchronization code in a separate Abstract.java class 
	
	By locatorForEmailField= By.id("email");
	public WebElement emailField()
	{
		waitForVisibilityOfElement(driver, locatorForEmailField); //Since both 'AbstractPage' (Parent) & faceBookLoginPage
		                                           // (child) are untility classes (non contain the
		                                            //  main/@TestNg annotation where the controller
		                                             // starts executing, then no object creation of
		                                             // this child class is necessary.
		 return emailFieldElement; // future exercise: remove the 'return' keyword and go from there.
	}	
	
	
	
	@FindBy(id= "pass")
	WebElement passwordFieldElement;
	
	By locatorForPasswordField = By.id("pass"); // needed for the explicit wait code where the locator isn't embedded in driver.findElement
	public WebElement passwordField()
	{
		waitForVisibilityOfElement(driver, locatorForPasswordField);
		return passwordFieldElement;
	}
	
	@FindBy(name= "login")
	WebElement loginButtonElement;
	
	By locatorForLoginButton = By.name("login");
	public WebElement loginButton()
	{ 
		waitForClickabilityOfElement(driver,locatorForLoginButton);
		return loginButtonElement;
	}
	//Note: double click on @FindBy to find the correct spelling of all the locators.
	
	//Below: An action method for logging in (Executable on this particular page of the app). It's needed by every test case.
	//       An action method = the name of such methods defined in an object repository class.
	
	public void loginApplication(String email, String password)
	{
		emailField().sendKeys(email); 
	//Attention: emailFieldElement.sendKeys(email); works but won't include the explicit wait step above it targetting the email field ! (no good)
		passwordField().sendKeys(password);
		loginButton().click();
	}
	
	// Another action method.
	public void goTo(String url)  // Personally I don't see the point of this ! 
	{                              // as simply, driver.get(""); in the actual testcase .java class file, 
		                            // optimizes our code as opossed to including it in this Action class !.
		driver.get(url);             // so, for now, leave this Action method here as is and let's see later.
	}
}
