package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

/** Phone number screen Elements */

public class PhoneNumberScreen {


	// Declaration -----------------------------------------------

	//@FindBy(className = "android.widget.EditText")
	@FindBy(xpath = "//android.widget.EditText[@clickable='true']")
	private static WebElement phnoField;

	//@FindBy(name = "What’s your number?")
	@FindBy(className = "android.widget.TextView")
	private WebElement headerText;
	
	@FindBy(xpath = "(//android.widget.TextView)[2]")
	private WebElement countryCode;

	@FindBy(xpath = "(//android.view.ViewGroup[@clickable='true'])[3]")
	private WebElement checkBox;

	@FindBy(xpath = "//android.widget.TextView[@text='Terms & Conditions']")
	private WebElement termsandCondition;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
	private WebElement privacyPolicy;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Enter country name']")
	private WebElement searchInputOfCountryCode;
	
	@FindBy(xpath = "(//android.widget.TextView)[2]")
	private WebElement countryCodeSelect;

	// Utilization ---------------------------------------

	public static WebElement getPhnoField() {
		Reporter.log("Phone number entered", true);
		return phnoField;
	}

	public WebElement getCountryCode() {
		Reporter.log("Country Code", true);
		return countryCode;
	}
	
	public WebElement getHeaderText() {
		return headerText;
	}

	public WebElement getCheckBox() {
		Reporter.log("Check box", true);
		return checkBox;
	}

	public WebElement getTermsandCondition() {
		Reporter.log("Terms and Condition",true);
		return termsandCondition;
	}
	
	public WebElement getPrivacyPolicy() {
		Reporter.log("Privacy Policy", true);
		return privacyPolicy;
	}
	
	public WebElement getSearchInputOfCountryCode() {
		return searchInputOfCountryCode;
	}

	public WebElement getCountryCodeSelect() {
		return countryCodeSelect;
	}

	// Initialization ------------

	public PhoneNumberScreen(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

}
