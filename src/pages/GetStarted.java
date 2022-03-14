package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

/** Get Started screen elements */ 
public class GetStarted {

	//Declaration --------------------------------------------------------
	
	@FindBy(xpath = "//android.widget.TextView[@text='Get Started!']")
	private WebElement getStartedOnboarding;
	
	@FindBy(xpath = "//android.widget.TextView[2]")
	private WebElement headerText;
	
	@FindBy(xpath = "//android.widget.TextView[3]")
	private WebElement descriptiveText;

	// Utilization --------------------------------------------------------

	public WebElement getGetStartedOnboarding() {
		Reporter.log("Get Started", true);
		return getStartedOnboarding;
	}
	
	public WebElement getHeaderText() {
		return headerText;
	}
	
	public WebElement getDescriptiveText() {
		return descriptiveText;
	}

	// Initialization ------------

	public GetStarted(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

}
