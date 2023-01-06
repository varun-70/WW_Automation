package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

/** Phone number screen Elements */

public class PhNoScreenPage {


	// Declaration -----------------------------------------------

//	@FindBy(className = "android.widget.EditText")
	@FindBy(xpath = "//android.widget.EditText[@clickable='true']")
	private WebElement phnoField;

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
	
	@FindBy(xpath = "//android.widget.TextView[@text='Next']")
	private WebElement nextButton;

	// Utilization ---------------------------------------

	public WebElement getPhnoField() {
		return phnoField;
	}

	public WebElement getCountryCode() {
		return countryCode;
	}
	
	public WebElement getHeaderText() {
		return headerText;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getTermsandCondition() {
		return termsandCondition;
	}
	
	public WebElement getPrivacyPolicy() {
		return privacyPolicy;
	}
	
	public WebElement getSearchInputOfCountryCode() {
		return searchInputOfCountryCode;
	}

	public WebElement getCountryCodeSelect() {
		return countryCodeSelect;
	}

	public WebElement getNextButton() {
		return nextButton;
	}
	
	// Initialization ------------

	public PhNoScreenPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

}
