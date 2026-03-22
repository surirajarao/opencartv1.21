package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegiestrationPage extends PageBase{
    public WebDriver driver;
	public AccountRegiestrationPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
   /// locators
   
	@FindBy(xpath="//input[@id='gender-male']")
	 WebElement radiobtn_gedermale;
	
	/*
	@FindBy(xpath="//input[@id='gender-female']")
	 WebElement radiobtn_gederfemale;
	*/
	
	@FindBy(xpath="//input[@id='FirstName']")
	 WebElement txt_fristname;
	
	@FindBy(xpath="//input[@id='LastName']")
	 WebElement txt_lastname;
	
	@FindBy(xpath="//input[@id='Email']")
	 WebElement txt_email;
	
	@FindBy(xpath="//input[@id='Company']")
	 WebElement txt_compnyname;
	
	
	@FindBy(xpath="//input[@id='NewsLetterSubscriptions_0__IsActive']")
	 WebElement ckeckbox;
	
	@FindBy(xpath="//input[@id='Password']")
	 WebElement txt_password;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	 WebElement txt_Conformpassword;
	
	@FindBy(xpath="//button[@id='register-button']")
	 WebElement btn_regester;
	
	@FindBy(xpath="//div[@class='result']")
	 WebElement messageconformation;
	
	
	//ActionsMethods
	
	 public void clickonGendermale ()
		{
		 radiobtn_gedermale.click();
		}
	 /*
	 public void clickonGenderfemea ()
		{
		 radiobtn_gederfemale.click();
		}*/
	 
	 public void setfristname (String fristname)
		{
		 txt_fristname.sendKeys(fristname);
		}
	 
	 public void setlastname (String lasttname)
		{
		 txt_lastname.sendKeys(lasttname);
		}
	 public void setemail (String email)
		{
		 txt_email.sendKeys(email);
		}
	 
	 public void setComnayname (String compnay_name)
		{
		 txt_compnyname.sendKeys(compnay_name);
		}
	 
	
	 public void Clickoncheckbox ()
		{
		 ckeckbox.click();
		}
	 
	
	 public void setpassword (String pwd)
		{
		 txt_password.sendKeys(pwd);
		}
	 public void setConformpassword (String conformpwd)
		{
		 txt_Conformpassword.sendKeys(conformpwd);
		}
	 public void clickonRegrestration()
		{
		
		 //1.click method
		 btn_regester.click();
		 
		 /*
		 //2 submit
		 btn_regester.submit();
		 
		 //action calss
		 Actions act = new Actions(driver);
		 act.moveToElement(btn_regester).perform();
		
		 // javascript method method 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("argument[0].click()", btn_regester);
		 
		 // waitmethod
		 
		 WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 mywait.until(ExpectedConditions.elementToBeClickable(btn_regester));
		 */
		}
	 
	 
	 
   public String getconformation()
   {   
	   try {
	   return(messageconformation.getText());
	   }
	   catch(Exception e)
	   {
		   return (e.getMessage());
	   }
   }
	 
	
	
}
