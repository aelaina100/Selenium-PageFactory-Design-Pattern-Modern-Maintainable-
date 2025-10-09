package pageFactoryExamples.pageFactoryProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ProductCatalogue {
	
	
	@Test
	public void cartPanel() throws InterruptedException
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		String userName= "ae@gmail.com";
		String password= "Test12345";
		String productName= "iphone 13 pro";
		driver.get("https://rahulshettyacademy.com/client");
		//Logging in:
		ProductCataloguePage ProductCatalogue =new ProductCataloguePage(driver);
		ProductCatalogue.userEmailField().sendKeys(userName);
		ProductCatalogue.userPasswordFieldElement.sendKeys(password);
		ProductCatalogue.loginButton().click();
		
		ProductCatalogue.waitFor_visibilityOfLogOutIcon();
		ProductCatalogue.addProductToCart(productName);
		
		
	}
	

}
