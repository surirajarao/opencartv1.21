package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestBaseforAlltestCases  {
	
	
	public static  WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass(groups = {"Sanity","Regression","Master"})
	@Parameters({"browser","os"})
	
	public void Setup( @Optional("chrome") String os, String br) throws InterruptedException, IOException
	{    
		
		//Read files 
		FileReader file = new FileReader("C:\\Users\\HP\\eclipse-workspace\\opencartv1.21\\src\\test\\resources\\propertiFile.properties");
		 p = new Properties();
		    p.load(file);
		    
		logger =LogManager.getLogger(this.getClass());
   
  if(p.getProperty("Execution_env").equalsIgnoreCase("remote"))
		  {
			  DesiredCapabilities cap = new DesiredCapabilities();
		 cap.setBrowserName(br);
			  //os 
			 if (os.equalsIgnoreCase("Windows"))
				 {
					 cap.setPlatform(Platform.WIN11);
				 }
		    
			 else if(os.equalsIgnoreCase("mac"))   
				 {
					 cap.setPlatform(Platform.MAC);
				 }
			 else
				 {
					System.out.println("No Matching Found");
					return;
			      }
		  
		  
  
			  switch(br.toLowerCase())  
			  {
			  case "Chrome"	:   cap.setBrowserName("Chrome");break;
			  					//System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe"); 
			  					//driver = new ChromeDriver();break;
			  case "MicrosoftEdge"		: 	cap.setBrowserName("MicrosoftEdge");break;
			  								//driver = new EdgeDriver();break;
			  case "Firefox"	:  	driver = new FirefoxDriver();break;
			  default 		:	System.out.println("invalid browser");
			  return;
			  }
			  
			  driver = new RemoteWebDriver (new URL(" http://10.243.60.203:4444"),cap);
		  }
  
         //Local run by changning in the properities files.
        if(p.getProperty("Execution_env").equalsIgnoreCase("local"))
        { //browser
		    switch(br.toLowerCase())  
			    {
			    case "Chrome"	:   
			    					System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe"); 
			    					driver = new ChromeDriver();break;
			    case "MicrosoftEdge"		: 	driver = new EdgeDriver();break;
			    								
			    case "Firefox"				:  	driver = new FirefoxDriver();break;
			    default 					:	System.out.println("invalid browser");
			    return;
			    }
        }
		    
		    driver.manage().deleteAllCookies();
		  driver = new ChromeDriver();
		   
			driver.get(p.getProperty("appurl"));
			
			
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().window().maximize();
	
		  }
		  
	@AfterClass
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
	
	// capture class 
	public String captureScreen(String tname) throws IOException {
		
		if (driver == null) {
	        throw new RuntimeException("Driver is NULL. Cannot take screenshot.");
	    }
	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    String targetFilePath = System.getProperty("C:\\Users\\HP\\eclipse-workspace\\opencartv1.21\\Screenshots"+ tname + "_" + timeStamp + ".png");
	    File targetFile = new File(targetFilePath);

	    sourceFile.renameTo(targetFile);

	    return targetFilePath;
	
			

		
	}
	
}