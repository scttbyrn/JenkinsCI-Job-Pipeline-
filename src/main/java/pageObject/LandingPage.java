package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import abstractMethods.ReuseableMethods;

public class LandingPage extends ReuseableMethods{
	
	WebDriver driver;
	Actions action;
	TripPage trippage;
	
	public LandingPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
	}
	
	public TripPage selectDiscount(String dType) {
		
		//Select Discount Type:
		List <WebElement> discountType = driver.findElements(By.xpath("//div[@id = 'discount-checkbox'] //div[starts-with(@class, 'fleft')]"));
		WebElement discountRadio = discountType.stream().filter( discounts -> discounts.getText().equalsIgnoreCase(dType)).findFirst().orElse(null);
		
		action = new Actions(driver);
		action.moveToElement(discountRadio)
		.click()
		.build()
		.perform();
		
		trippage = new TripPage(driver);
		
		return trippage;
		
	}

}
