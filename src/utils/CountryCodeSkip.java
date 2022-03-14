package utils;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import pages.CountryCodeSelection;

/** This class is used to skip the country code selection screen */

public class CountryCodeSkip {
	AndroidDriver<WebElement> driver;
	
	public CountryCodeSkip(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}
	
    /** 
	 * Selecting the country code by passing the parameter as country code in int data type.
	 * If the displayed country code and parameters passed are same then it will skip and return
 	 * 
	 * @param code an int of country code
 	 */
	public void countryCodeSelection(int code) {
		int countryCode=Integer.parseInt(CountryCodeSelection.getCountryCodeDropDown().getText().substring(1));
		if(countryCode==code) {
			return;
		}
		CountryCodeSelection.getCountryCodeDropDown().click();
		String code1=Integer.toString(code);
		CountryCodeSelection.getSearchInputOfCountryCode().sendKeys(code1);
		CountryCodeSelection.getCountryCodeSelect().click();
	}
	
}
