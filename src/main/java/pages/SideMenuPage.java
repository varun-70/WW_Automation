package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

/** Side Menu Elements */

public class SideMenuPage {

	/* --------------------------------------------------------------------------------
	* Side menu
	* Declaration -----------
	*/
	
	@FindBy(xpath = "//android.widget.TextView[@text='BUY CARBON OFFSETS']")
	private WebElement buyCarbonOffsets;
	
	@FindBy(xpath = "//android.widget.TextView[@text='BUY CARBON OFFSETS']/preceding-sibling::android.view.ViewGroup[1]")
	private WebElement sideMenuCloseIcon;
	
	@FindBy(xpath = "//android.widget.TextView[@text='About World Winners']/preceding-sibling::android.view.ViewGroup[1]/android.view.ViewGroup")
	private WebElement backIcon;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Cashout']")
	private WebElement cashout;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Setup AutoPlay']")
	private WebElement setupAutoPlay;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Manage AutoPlay']")
	private WebElement manageAutoPlay;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Past Results']")
	private WebElement pastResults;
	
	@FindBy(xpath = "//android.widget.TextView[@text='SHARE Dashboard']")
	private WebElement shareDashboard;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Profile']")
	private WebElement profile;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Transaction History']")
	private WebElement transactionHistory;
	
	@FindBy(xpath = "//android.widget.TextView[@text='About World Winners']")
	private WebElement aboutWorldWinners;
	
	@FindBy(xpath = "//android.widget.TextView[@text='How to Play']")
	private WebElement howToPlay;
	
	@FindBy(xpath = "//android.widget.TextView[@text='FAQ']")
	private WebElement faq;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Contact Support']")
	private WebElement contactSupport;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Reset Tutorials']")
	private WebElement resetTutorials;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Logout']")
	private WebElement logout;

	
	// Utilization---------------------
	
	public WebElement getBuyCarbonOffsets() {
		return buyCarbonOffsets;
	}
	
	public WebElement getSideMenuCloseIcon() {
		return sideMenuCloseIcon;
	}
	
	public WebElement getBackIcon() {
		return backIcon;
	}
	
	public WebElement getCashout() {
		return cashout;
	}
	
	public WebElement getSetupAutoPlay() {
		return setupAutoPlay;
	}
	
	public WebElement getManageAutoPlay() {
		return manageAutoPlay;
	}
	
	public WebElement getPastResults() {
		return pastResults;
	}
	
	public WebElement getShareDashboard() {
		return shareDashboard;
	}
	
	public WebElement getProfile() {
		return profile;
	}
	
	public WebElement getTransactionHistory() {
		return transactionHistory;
	}
	
	public WebElement getAboutWorldWinners() {
		return aboutWorldWinners;
	}
	
	public WebElement getHowToPlay() {
		return howToPlay;
	}
	
	public WebElement getFaq() {
		return faq;
	}
	
	public WebElement getContactSupport() {
		return contactSupport;
	}
	
	public WebElement getResetTutorials() {
		return resetTutorials;
	}
	
	public WebElement getLogout() {
		return logout;
	}

	
	// Initialization ------------

	public SideMenuPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
}
