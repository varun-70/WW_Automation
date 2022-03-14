package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

/** Get ready to play... screen elements */

public class GetReadyToPlay {

	 // Declaration ---------------------------------------------
	
	@FindBy(xpath = "//android.widget.TextView[@text='Get ready to play...']")
	private WebElement textGetReadyToPlay;
	
	// Utilization --------------------------------------
	
	public WebElement getTextGetReadyToPlay() {
		Reporter.log("Text - Get ready to play...", true);
		return textGetReadyToPlay;
	}
	
	// Initialization ------------

	public GetReadyToPlay(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

}
