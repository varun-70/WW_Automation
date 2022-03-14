package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

/** Country Code Selection Flow */

public class CountryCodeSelection {

	// Declaration -----------
	
	@FindBy(xpath = "(//android.widget.TextView)[2]")
	private static WebElement countryCodeDropdown;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Enter country name']")
	private static WebElement searchInputOfCountryCode;
	
	@FindBy(xpath = "(//android.widget.TextView)[2]")
	private static WebElement countryCodeSelect;

	// Utilization

	public static WebElement getCountryCodeDropDown() {
		Reporter.log("Country Code", true);
		return countryCodeDropdown;
	}
	
	public static WebElement getSearchInputOfCountryCode() {
		return searchInputOfCountryCode;
	}

	public static WebElement getCountryCodeSelect() {
		return countryCodeSelect;
	}

	// Initialization ------------

	public CountryCodeSelection(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
}
