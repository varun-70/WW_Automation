package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

/** Country Code Selection Flow */

public class CountryCodeSelectionPage {

	// Declaration -----------
	
	@FindBy(xpath = "(//android.widget.TextView)[2]")
	private WebElement countryCodeDropdown;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Enter country name']")
	private WebElement searchInputOfCountryCode;
	
	@FindBy(xpath = "(//android.widget.TextView)[2]")
	private WebElement countryCodeSelect;

	// Utilization

	public WebElement getCountryCodeDropDown() {
		Reporter.log("Country Code", true);
		return countryCodeDropdown;
	}
	
	public WebElement getSearchInputOfCountryCode() {
		return searchInputOfCountryCode;
	}

	public WebElement getCountryCodeSelect() {
		return countryCodeSelect;
	}

	// Initialization ------------

	public CountryCodeSelectionPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
}
