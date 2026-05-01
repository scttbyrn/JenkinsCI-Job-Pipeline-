package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import abstractMethods.ReuseableMethods;

public class TripPage extends ReuseableMethods {
	
	WebDriver driver;
	CurrencyPage currencypage;

	public TripPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}
	
	public CurrencyPage selectTrip() {
		
		//Select Trip:
		List <WebElement> trip = driver.findElements(By.xpath("//table[@class = 'tblTrip'] //tbody//tr//td"));
		boolean tripValidate = trip.stream().anyMatch(trips -> trips.getText().equalsIgnoreCase("Round Trip"));
		Assert.assertTrue(tripValidate);

		if (tripValidate) {

			WebElement tripSelect = trip.stream().filter(tripRadio -> tripRadio.getText().equalsIgnoreCase("Round Trip")).findFirst().orElse(null);
			tripSelect.click();

		}
		else {

			System.out.println("Please select Trip. ");
		}
		
		currencypage = new CurrencyPage(driver);
		return currencypage;
		
	}
}
