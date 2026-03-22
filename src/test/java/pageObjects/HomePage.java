package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage extends PageBase{
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
	    
		super(driver);
		PageFactory.initElements(driver, this);
		
	}

	
	
	//locators
	
	 @FindBy(xpath="//a[normalize-space()='Log in']")
	 WebElement link_login;
	 
	 @FindBy(xpath="//a[normalize-space()='Register']")
	 WebElement linkRegrestration;
	 
	 
	 
	 //ActionMethods
	 
	 public void clickOnRegrestration()
		{
		 linkRegrestration.click();
		}
  
	 public void clickonLogin()
		{
		 link_login.click();
		}
	 
}
