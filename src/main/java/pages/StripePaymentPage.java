package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

/** Stripe payment pop-up Elements */

public class StripePaymentPage {

	// Declaration ----------------------------------------------

	@FindBy(id = "com.lotteryreactnative:id/et_card_number")
	private WebElement cardNumber;
	
	@FindBy(id = "com.lotteryreactnative:id/et_expiry")
	private WebElement expiry;
	
	@FindBy(id = "com.lotteryreactnative:id/et_cvc")
	private WebElement cvc;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Show dropdown menu\"]/.../.../preceding-sibling::android.widget.Spinner")
	private WebElement countryDropDown;
	
	@FindBy(id = "com.lotteryreactnative:id/label")
	private WebElement payButton;

	// Utilization -------------------------------------------------

	public WebElement getCardNumber() {
		return cardNumber;
	}

	public WebElement getExpiry() {
		return expiry;
	}

	public WebElement getCvc() {
		return cvc;
	}

	public WebElement getCountryDropDown() {
		return countryDropDown;
	}

	public WebElement getPayButton() {
		return payButton;
	}

	// Initialization ------------

	public StripePaymentPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

}
