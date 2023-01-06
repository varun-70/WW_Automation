package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

/** Play World Winners screen Elements */

public class PlayWorldWinnersPage {

	
	/* --------------------------------------------------------------------------------
	* Play World Winners
	* Declaration -----------
	*/
	
	@FindBy(xpath = "//android.widget.TextView[@text='Play Now!']")
	private WebElement playNowButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Next']")
	private WebElement nextButton;
	
	@FindBy(xpath = "(//android.view.ViewGroup)[22]")
	private WebElement plusButton;
	
	@FindBy(xpath = "(//android.view.ViewGroup)[21]")
	private WebElement minusButton;
	
	@FindBy(xpath = "(//android.widget.TextView)[6]")
	private WebElement noOfTicketAdded;

//	String ticketAdded;
//	@FindBy(xpath = "//android.widget.TextView[@text='Continue with \"+ticketAdded+\" ticket']")
//	private WebElement continueWithnButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='DELETE']")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//android.widget.ScrollView//android.widget.TextView")
	private List<WebElement> ticketNo;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Your balance']")
	private WebElement yourBalance;
	
	// Utilization
	
	public WebElement getPlayNowButton() {
		Reporter.log("Text - Get ready to play...", true);
		return playNowButton;
	}
	
	public WebElement getNextButton() {
		Reporter.log("Next button", true);
		return nextButton;
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
	
	public List<WebElement> getTicketNo() {
		return ticketNo;
	}
	
	public WebElement getYourBalance() {
		return yourBalance;
	}
	
	// Initialization ------------

	public PlayWorldWinnersPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

}
