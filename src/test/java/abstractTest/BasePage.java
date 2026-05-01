package abstractTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LandingPage;

public class BasePage {
	
	public WebDriver driver;
	public LandingPage landingpage;
	
	public WebDriver initializer() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
		
	}
	
	@BeforeMethod (alwaysRun = true)
	public LandingPage launchBrowser() {
		
		driver = initializer();
		
		landingpage = new LandingPage(driver);
		
		return landingpage;
		 
		
	}
	
	@AfterMethod (alwaysRun = true)
	public void tearDown() {
		
		driver.quit();
		
	}

}
