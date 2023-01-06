package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

/** Welcome Back screen Elements */

public class WelcomeBackPage {

	// Declaration ----------------------------------------------

	@FindBy(xpath = "//android.widget.TextView[@text='Continue']")
	private WebElement continueButton;

	// Utilization -------------------------------------------------

	public WebElement getContinueButton() {
		Reporter.log("Continue button - Welcome back screen", true);
		return continueButton;
	}

	// Initialization ------------

	public WelcomeBackPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

}
