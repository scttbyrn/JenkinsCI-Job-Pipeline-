package abstractTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LandingPage;

public class BasePage {
	
	public WebDriver driver;
	public LandingPage landingpage;
	
	public WebDriver initializer() throws IOException {
		
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//GlobalData.properties");
		properties.load(fis);
		
		String browserName = System.getProperty("browser") !=null ? System.getProperty("browser") : properties.getProperty("browser"); //set the browser environment in mvn using Ternary operator 
		
//		String browserName = properties.getProperty("browser"); //set the browser environment locally
		
		//
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
	
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
		
	}
	
	@BeforeMethod (alwaysRun = true)
	public LandingPage launchBrowser() throws IOException {
		
		driver = initializer();
		
		landingpage = new LandingPage(driver);
		
		return landingpage;
		 
		
	}
	
	@AfterMethod (alwaysRun = true)
	public void tearDown() {
		
		driver.quit();
		
	}

}
