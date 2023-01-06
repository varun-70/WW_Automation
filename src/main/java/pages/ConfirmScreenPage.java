package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

public class ConfirmScreenPage {

	//Declaration --------------------------------------------------------
	
	@FindBy(xpath = "//android.widget.TextView[@text='Skip to Home']")
	private WebElement skipToHomeButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Confirm']")
	private WebElement confirmButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Confirm Selections']")
	private WebElement confirmSelection;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Skip for Now']")
	private WebElement skipForNowButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Back to Home']")
	private WebElement backToHomeButton;
	
	@FindBy(xpath = "//android.widget.ScrollView//android.widget.TextView")
	private List<WebElement> ticketsScrollable;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Tickets']/following-sibling::android.widget.TextView[2]")
	private WebElement tickets;
	
	// Utilization --------------------------------------------------------

	public WebElement getSkipToHomeButton() {
		Reporter.log("Next button", true);
		return skipToHomeButton;
	}
	
	public WebElement getConfirmButton() {
		Reporter.log("Confirm Button", true);
		return confirmButton;
	}
	
	public WebElement getConfirmSelection() {
		return confirmSelection;
	}
	
	public WebElement getSkipForNowButton() {
		Reporter.log("Skip for now button", true);
		return skipForNowButton;
	}
	
	public WebElement getBackToHomeButton() {
		Reporter.log("Back to home", true);
		return backToHomeButton;
	}
	
	public List<WebElement> getTicketsScrollable() {
		return ticketsScrollable;
	}
	
	public WebElement getTickets() {
		return tickets;
	}
	
	
	// Initialization ------------

	public ConfirmScreenPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
}
