package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import io.appium.java_client.android.AndroidDriver;

public class CarbonOffsetPage extends Base{

	/* --------------------------------------------------------------------------------
	* Carbon Offset Screen
	* Declaration -----------
	*/
	
	@FindBy(xpath = "//android.widget.TextView[@text='Next']")
	private WebElement nextButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='SKIP']")
	private WebElement skipButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='SWIPE TO BUY']")
	private List<WebElement> swipeToBuy;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Offset Your Carbon']/preceding-sibling::android.view.ViewGroup[1]/android.view.ViewGroup")
	private WebElement backButton;
	
	@FindBy(xpath = "//android.widget.TextView[contains(@text,'Confirm & Pay AED')]")
	private WebElement confirmAndPay;
	
	// Utilization---------------------
	
	public WebElement getNextButton() {
		return nextButton;
	}
	
	public WebElement getSkipButton() {
		return skipButton;
	}
	
	public List<WebElement> getSwipeToBuy() {
		return swipeToBuy;
	}
	
	public WebElement getBackButton() {
		return backButton;
	}

	public WebElement getConfirmAndPay() {
		return confirmAndPay;
	}

	
	// Initialization ------------

	public CarbonOffsetPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	

}
