package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

public class AutoPlayPage {

	/* --------------------------------------------------------------------------------
	* AutoPlay
	* Declaration -----------
	*/
	
	@FindBy(xpath = "//android.widget.TextView[@text='Setup AutoPlay']")
	private WebElement setupAutoPlay;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Manage AutoPlay']")
	private WebElement manageAutoPlay;
	
	@FindBy(xpath = "(//android.view.ViewGroup)[22]")
	private WebElement plusButton;
	
	@FindBy(xpath = "(//android.view.ViewGroup)[21]")
	private WebElement minusButton;
	
	@FindBy(xpath = "(//android.widget.TextView)[6]")
	private WebElement noOfTicketAdded;
	
	@FindBy(xpath = "//android.widget.TextView[@text='DELETE']")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Skip to Home']")
	private WebElement skipToHomeButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Confirm']")
	private WebElement confirmButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Skip for Now']")
	private WebElement skipForNowButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Back to Home']")
	private WebElement backToHomeButton;
	
	@FindBy(xpath = "//android.widget.ScrollView//android.widget.TextView")
	private List<WebElement> ticketNo;
	
	// Utilization
	
	public WebElement getsetupAutoPlay() {
		Reporter.log("Setup AutoPlay button - clicked", true);
		return setupAutoPlay;
	}
	
	public WebElement getManageAutoPlay() {
		Reporter.log("Manage AutoPlay button - clicked", true);
		return manageAutoPlay;
	}
	
	public WebElement getPlusButton() {
		return plusButton;
	}
	
	public WebElement getMinusButton() {
		return minusButton;
	}
	
	public WebElement getNoOfTicketAdded() {
//		Reporter.log("No of ticket added - Text", true);
		return noOfTicketAdded;
	}
	
//	public WebElement getContinueWithnButton() {
//		ticketAdded=getContinueWithnButton().getText();
//		Reporter.log("No of ticket added", true);
//		return continueWithnButton;
//	}
	
	public WebElement getDeleteButton() {
		Reporter.log("Delete button", true);
		return deleteButton;
	}
	
	public WebElement getSkipToHomeButton() {
		Reporter.log("Next button", true);
		return skipToHomeButton;
	}
	
	public WebElement getConfirmButton() {
		Reporter.log("Confirm Button", true);
		return confirmButton;
	}
	
	public WebElement getSkipForNowButton() {
		Reporter.log("Skip for now button", true);
		return skipForNowButton;
	}
	
	public WebElement getBackToHomeButton() {
		Reporter.log("Back to home", true);
		return backToHomeButton;
	}
	
	public List<WebElement> getTicketNo() {
		return ticketNo;
	}
	
	// Initialization ------------

	public AutoPlayPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

}
