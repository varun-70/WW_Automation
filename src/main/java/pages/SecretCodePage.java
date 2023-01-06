package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

/** Secret code screen Elements */

public class SecretCodePage {

	// Declaration -----------

	@FindBy(className = "android.widget.EditText")
	private WebElement otpField;
	
	@FindBy(xpath = "//android.widget.TextView")
	private WebElement headerTextSecretCode;
	
	@FindBy(xpath = "//android.widget.TextView[@text='CHANGE']")
	private WebElement changeButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Next']")
	private WebElement nextButton;

	// Utilization

	public WebElement getOtpField() {
		Reporter.log("OTP entered", true);
		return otpField;
	}
	
	public WebElement getHeaderTextSecretCode() {
		return headerTextSecretCode;
	}
	
	public WebElement getChangeButton() {
		Reporter.log("Change button - secret code", true);
		return changeButton;
	}

	public WebElement getSubmitButton() {
		Reporter.log("Submit button - secret code screen", true);
		return submitButton;
	}

	public WebElement getNextButton() {
		Reporter.log("Next button", true);
		return nextButton;
	}
	
	// Initialization ------------

	public SecretCodePage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
}
