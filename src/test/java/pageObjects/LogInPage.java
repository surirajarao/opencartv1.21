package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends PageBase{
	public WebDriver driver;
	
	public LogInPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//lcators 
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtemail;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtpswd;
	
	//button[normalize-space()='Log in']
	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement btnlogin;
	
	//Action methods
	public void SetEamil(String email)
	{   txtemail.clear();
		txtemail.sendKeys(email);	
	}
 
	public void SetPassword(String password)
	{	txtpswd.clear();
		txtpswd.sendKeys(password);
	}
	
	public void ClickOLogin() 
	{
		btnlogin.click();
	}

}



	