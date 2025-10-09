package pageFactoryExamples.pageFactoryProject;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCataloguePage extends AbstractPage {
	
	WebDriver driver;
	
	public  ProductCataloguePage(WebDriver driver)
	{
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver,this);	
	}
	
	
	
	@FindBy(id= "userEmail")  // Always remember- Page Factory is exclusively for 'driver.findElement(By..)' construction.
	WebElement userEmailFieldElement;
	
	By userEmailField= By.id("userEmail");
	public WebElement userEmailField()
	{
		waitForClickabilityOfElement(driver, userEmailField );
		return userEmailFieldElement;
	}
	
	
	
	@FindBy(id="userPassword")
	WebElement userPasswordFieldElement;
	
	By userPasswordField = By.id("userPassword");
	public WebElement userPasswordField()
	{
		waitForClickabilityOfElement(driver, userPasswordField );
		return userPasswordFieldElement;
	}
	
	
	@FindBy(id= "login")
	WebElement loginButtonElement;
	
	By loginButton= By.id("login");
	public WebElement loginButton()
	{
		waitForClickabilityOfElement(driver, loginButton);
		return loginButtonElement;
	}
	
	///////////////////////////////////////////////
	By logOutIcon=  By.cssSelector("i[class*= 'sign-out']");
	public void waitFor_visibilityOfLogOutIcon()
	{
		waitForVisibilityOfElement(driver,logOutIcon);
	}
	/////////////////////////////////////////////
	
	@FindBy(css= "div.card")
	List<WebElement> productCards; // instructor named it 'products'
	
	By productCardsLocator= By.cssSelector("div.card"); //instructor named in 'productsBy'
	public List<WebElement> productCards() // instructor named it getProductList()
	{
		waitForVisibilityOfAllElements(driver,productCardsLocator);
		return productCards;
	}
	
	//Action method, to find product box by name (The box contains the product's name, image, buttons, etc.)
	
	public WebElement getProductByname(String productName)
	{
	//WebElement wantedElement_productBoxBorder=  this is not optimized. Instead, just return the whole thing.
		return productCards().stream() 
	          .filter(s-> s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
	          .findFirst().orElse(null);
	// check out:  .orElseThrow(() -> new RuntimeException("Product not found: " + productTitle));  instead of .orElse(null)
	
	//return wantedElement_productBoxBorder; (As per the previous comment).
	}
	

	/*** Note: If you're not using page object (Not a real-time practice),then including the below method (Used inside the stream)
	 *  makes more sence for readability. However including it here is 'inappropriate' at most as in, page factory, one strives for
	 *  using the @FindBy which does the construction of 'driver.findElement(By..)' and which is the sole purpose of using this
	 *  design pattern. This construction is only possible for 'driver' and not 's'. Therefore, include the equivalent of this
	 *  function inside the stream lines of code.
	 *
    By productNameBox= By.cssSelector("b");
    
	public  WebElement productNameBox(WebElement s)  
	{	
		return s.findElement(productNameBox);
	}
	*/ 
	
	//WebElement addToCartBtnElement = wantedElement_productBoxBorder.findElement(By.cssSelector("button:nth-of-type(2)"));
	
	By addToCartBtnLocator= By.cssSelector("button:nth-of-type(2)");
	
	public void addProductToCart(String productName)
	{
		WebElement productCard= getProductByname(productName); // Catching the returned filtered WebElement (The box) cotaining a sepcific text and storing it in a Web Element data type.
		//If one does not catch it then the next line's 'productCard' (in productCard.findElement) is something thast's not declared
		//🔴 Compile-time error → “cannot find symbol” (because productCard is undeclared).
		
		waitForClickabilityOfElement_miniDriver(driver,addToCartBtnLocator,productCard );// work on it if required ?: I think it is required as I've 
		// already waited for the visibility of the filtered by text box element but now I have to wait for the clickability of the button inside this box.
		productCard.findElement(addToCartBtnLocator).click();
	}
	
	//Interview Question: Can you apply 
	
	

}
