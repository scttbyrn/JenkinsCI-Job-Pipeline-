package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import abstractMethods.ReuseableMethods;

public class CurrencyPage extends ReuseableMethods {
	
	WebDriver driver;

	public CurrencyPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
	}                  
	
	public void selectCurrency() {
		
		//Select Currency:

		WebElement currency = driver.findElement(By.xpath("//select[@id = 'ctl00_mainContent_DropDownListCurrencysss']"));

		Select select = new Select(currency);

		select.selectByValue("AED");
		
	}
}
