package testCases;

import static org.testng.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import pageObjects.AccountRegiestrationPage;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import testBase.TestBaseforAlltestCases;

public class Tc1_Regrestration extends TestBaseforAlltestCases{

	public Logger logger;
	public static WebDriver driver;
	public Properties p;
	
	@Parameters({"browser"})
	@BeforeClass(groups = {"Sanity","Regression","Master"})
	public void Setup(@Optional("chrome") String br) throws InterruptedException, IOException
	{    
		
		//readproperties file data to steam
		FileReader file = new FileReader("C:\\Users\\HP\\eclipse-workspace\\opencartv1.21\\src\\test\\resources\\propertiFile.properties");
		 p = new Properties();
		    p.load(file);
		
		logger =LogManager.getLogger(this.getClass());
		    Thread.sleep(4000);
		    System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe"); 
		    
		    Thread.sleep(4000);
		    
		    switch(br.toLowerCase())
		    {
		    case "chrome":  driver = new ChromeDriver();break;
		    case "edge":  driver = new EdgeDriver();break;
		    case "Firefox":  driver = new FirefoxDriver();break;
		    default : System.out.println("invalid browser");
		    return;
		    }
		    
		    
		   
		    
		    driver.manage().deleteAllCookies();
		    
		    logger.info("......Started...tc001_ Account regeestration....");
		  //  driver = new ChromeDriver();
			driver.get(p.getProperty("appurl"));
			
			driver.manage().window().maximize();
	}
	
	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void teardown()
	{
	  driver.close();
	}
	
	
	@SuppressWarnings("deprecation")
	public  String ranndamString()
	{
	String generatestring=RandomStringUtils.randomAlphabetic(5);
	return generatestring;
	}
	
	@SuppressWarnings("deprecation")
	public String randomNumber()
	{
		String generateNumber=RandomStringUtils.random(10);
		return generateNumber;
	}
	
	@SuppressWarnings("deprecation")
	public String aplthaNumaric()
	
	{
		String generatestring=RandomStringUtils.randomAlphabetic(5);
		return generatestring;
	}
	
	@SuppressWarnings("deprecation")
public String randompassword()
	
	{
		String generatestring=RandomStringUtils.randomAlphabetic(5);
		String generateNumber=RandomStringUtils.random(3);
		return(generatestring+"@"+generateNumber);
	}
	
	

	 
	@Test(groups = {"Sanity","Master"})
	public void ValidationRegiter() throws InterruptedException
	{  
		//home page
		
		try {		
		HomePage ip = new HomePage(driver);
		 Thread.sleep(8000);
		  logger.info("......Click on my regrestration link");
		   ip.clickOnRegrestration();
		  // ip.clickonLogin();
		  
		   
		  //Regrestrationpage page 
		   AccountRegiestrationPage rgt = new AccountRegiestrationPage(driver);
		   Thread.sleep(9000);
		   logger.info("......provieding required details.......");
		   rgt.clickonGendermale();
		   //rgt.clickonGenderfemea();
		   rgt.setfristname(ranndamString().toUpperCase());
		   rgt.setlastname(ranndamString().toUpperCase());
		   
		   //String emaillogin = aplthaNumaric()+"@gmail.com";
		   rgt.setemail(aplthaNumaric()+"@gmail.com");
		   
		   rgt.setComnayname("TATA Sonsultancy Services");
		   rgt.Clickoncheckbox();
		   
		  String password=randompassword();
		   
		   rgt.setpassword(password);
		   rgt.setConformpassword(password);
		   
		   rgt.clickonRegrestration();
		   
		  String  getconformation =  rgt.getconformation();
		  
			
		  Assert.assertEquals(getconformation, "Your registration completed");
		  logger.info("test cases passed....");
		}
		  
		catch(Exception e)
		{
			logger.error("...test case failed...");
			logger.debug("......debuglogs.......");
			//Assert.fail();
				
			
		}  
	}
}
		
		   
	

