package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.TestBaseforAlltestCases;

public class TC002Loginverification extends TestBaseforAlltestCases {
	public Logger logger;
	public  WebDriver driver;
	public Properties p;
	
	@SuppressWarnings("deprecation")
	@Parameters({"os","browser"})
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
		    case "chrome": 
					    System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
					    	driver = new ChromeDriver();
					    	driver.manage().window().maximize();
					    	break;
			case "edge":  driver = new EdgeDriver();break;
		    case "Firefox":  driver = new FirefoxDriver();break;
		    default : System.out.println("invalid browser");
		    return;
		    }
		    
		    
		   
		    
		    driver.manage().deleteAllCookies();
		    
		    logger.info("......Started...tc002_ Account regeestration....");
		  //  driver = new ChromeDriver();
			driver.get(p.getProperty("appurl"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().window().maximize();
	}
	
	@AfterClass(groups = {"Sanity","Regression","Master"})
	public void teardown()
	{
	  driver.close();
	}
		
	
	@Test(groups = {"Regression","Master"})
	public void VerifyLogin() throws InterruptedException {
	
		
		logger.info("******* test Login Started ********");
	//Homepage
		HomePage ip = new HomePage(driver);
		ip.clickonLogin();
	
	//login page
		Thread.sleep(5000);
		LogInPage login = new LogInPage(driver);
		Thread.sleep(5000);
		
		
		login.SetEamil(p.getProperty("email"));
		login.SetPassword(p.getProperty("password"));
		login.ClickOLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(null);
		*/
		//MyAccount 
		
		MyAccountPage ap =new MyAccountPage(driver);
		Thread.sleep(5000);
		boolean target = ap.isMyLogoExists();
		
		Assert.assertEquals(target, true);
		
		logger.info("******* TC002test case finished****");
		
	}	
	
}




