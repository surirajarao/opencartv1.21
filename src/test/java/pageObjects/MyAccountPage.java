package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends PageBase {
	
public WebDriver driver;
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	//locators
	
	@FindBy(xpath = "//img[@alt='nopCommerce demo store']")
	WebElement imglogo;
	
	public boolean isMyLogoExists()
	{ try 
		{
			return(imglogo.isDisplayed());
		}
	
	catch(Exception e)
		{
			return false;
		}
	}
	
	
}
