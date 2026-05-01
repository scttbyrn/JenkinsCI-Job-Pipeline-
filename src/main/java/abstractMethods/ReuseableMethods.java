package abstractMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ReuseableMethods {
	
	WebDriver driver;
	String url;
	
	public String getGlobalEnvURL() throws IOException {
		
		
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//GlobalData.properties");
		properties.load(fis);
		
		String EnvinromnetURL = System.getProperty("env") !=null ? System.getProperty("env") : properties.getProperty("env");
		
		if (EnvinromnetURL.equalsIgnoreCase("QA")) {
			
			url = "https://rahulshettyacademy.com/dropdownsPractise/";
		}
		
		if (EnvinromnetURL.equalsIgnoreCase("UAT")) {
			
			url = "https://github.com/";
		}
		return url;
		
		
	}
	
	public ReuseableMethods(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void gotoWebsite() throws IOException {
		
		driver.get(getGlobalEnvURL());

		//"https://rahulshettyacademy.com/dropdownsPractise/"
	}

}
