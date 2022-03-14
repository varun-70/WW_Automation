package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

/** Common buttons Elements on multiple screens */

public class CommonButtons {
	
	// Declaration -----------------------------------------------
	
	@FindBy(xpath = "//android.widget.TextView[@text='Next']")
	private WebElement nextButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Confirm']")
	private WebElement confirmButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Skip for Now']")
	private WebElement skipForNowButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Logout']")
	private WebElement logoutAboutWorldWinners;
	
	@FindBy(xpath = "(//android.widget.TextView[@text='Logout'])[2]")
	private WebElement logoutOnPopUp;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Done']")
	private WebElement doneButton;

	// Utilization ---------------------------------------------

	public WebElement getNextButton() {
		Reporter.log("Next button", true);
		return nextButton;
	}
	
	public WebElement getConfirmButton() {
		Reporter.log("Confirm Button", true);
		return confirmButton;
	}
	
	public WebElement getSkipForNowButton() {
		Reporter.log("Skip for now button", true);
		return skipForNowButton;
	}
	
	public WebElement getLogoutAboutWorldWinners() {
		Reporter.log("Log out button on the About World Winners", true);
		return logoutAboutWorldWinners;
	}
	
	public WebElement getlogoutOnPopUp() {
		Reporter.log("Log out button on the logout pop-up", true);
		return logoutOnPopUp;
	}
	
	public WebElement getDoneButton() {
		Reporter.log("Done button - Web version", true);
		return doneButton;
	}
	

	// Initialization ------------

	public CommonButtons(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

}
