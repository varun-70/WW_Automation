package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

public class ElementsStore {

	// ==============================================================================


	/* --------------------------------------------------------------------------------
	* Common buttons
	* Declaration -----------
	*/

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

	// Utilization

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
	
	/* --------------------------------------------------------------------------------
	* Get Started screen
	* Declaration -----------
	*/ 

	@FindBy(xpath = "//android.widget.TextView[@text='Get Started!']")
	private WebElement getStartedOnboarding;
	

	// Utilization

	public WebElement getGetStartedOnboarding() {
		Reporter.log("Get Started", true);
		return getStartedOnboarding;
	}
	

	// --------------------------------------------------------------------------------
	// Phone number screen

	// Declaration -----------

	//@FindBy(className = "android.widget.EditText")
	@FindBy(xpath = "//android.widget.EditText[@clickable='true']")
	private WebElement phnoFieldOnboarding;

	//@FindBy(name = "What’s your number?")
	@FindBy(className = "android.widget.TextView")
	private WebElement headerTextPhoneNumber;
	
	@FindBy(xpath = "(//android.widget.TextView)[2]")
	private WebElement countryCode;

	//@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")
	@FindBy(xpath = "(//android.view.ViewGroup[@clickable='true'])[3]")
	private WebElement checkBoxPhnoscreenOnboarding;

	@FindBy(xpath = "//android.widget.TextView[@text='Terms & Conditions']")
	private WebElement termsandConditionOnboarding;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
	private WebElement privacyPolicyOnboarding;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Enter country name']")
	private WebElement searchInputOfCountryCode;
	
	@FindBy(xpath = "(//android.widget.TextView)[2]")
	private WebElement countryCodeSelect;

	// Utilization

	public WebElement getPhnoFieldOnboarding() {
		Reporter.log("Phone number entered", true);
		return phnoFieldOnboarding;
	}

	public WebElement getCountryCode() {
		Reporter.log("Country Code", true);
		return countryCode;
	}
	
	public WebElement getHeaderTextPhoneNumber() {
		return headerTextPhoneNumber;
	}

	public WebElement getCheckBoxPhnoscreenOnboarding() {
		Reporter.log("Check box", true);
		return checkBoxPhnoscreenOnboarding;
	}

	public WebElement getTermsandConditionOnboarding() {
		Reporter.log("Terms and Condition",true);
		return termsandConditionOnboarding;
	}
	
	public WebElement getPrivacyPolicyOnboarding() {
		Reporter.log("Privacy Policy", true);
		return privacyPolicyOnboarding;
	}
	
	public WebElement getSearchInputOfCountryCode() {
		return searchInputOfCountryCode;
	}

	public WebElement getCountryCodeSelect() {
		return countryCodeSelect;
	}

	// --------------------------------------------------------------------------------
	// Secret code screen
	// Declaration -----------

	@FindBy(className = "android.widget.EditText")
	private WebElement otpFieldOnboarding;
	
	@FindBy(xpath = "//android.widget.TextView")
	private WebElement headerTextSecretCode;
	
	@FindBy(xpath = "//android.widget.TextView[@text='CHANGE']")
	private WebElement changeButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Submit']")
	private WebElement submitButton;

	// Utilization

	public WebElement getotp_field_onboarding() {
		Reporter.log("OTP entered", true);
		return otpFieldOnboarding;
	}
	
	public WebElement getHeaderTextSecretCode() {
		return headerTextSecretCode;
	}
	
	public WebElement getChangeButton() {
		Reporter.log("Change button - secret code", true);
		return changeButton;
	}

	public WebElement getSubmitButton() {
		Reporter.log("Submit button - secret code screen", true);
		return submitButton;
	}


	// --------------------------------------------------------------------------------
	// Great! Let's get to know you... screen
	// Declaration -----------

	@FindBy(xpath = "//android.widget.EditText[@text='First Name']")
	private WebElement firstNameOnboarding;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Last Name']")
	private WebElement lastNameOnboarding;


	@FindBy(xpath = "//android.widget.EditText[@index='7']")
	private WebElement personalEmailOnboarding;
	
	@FindBy(xpath = "//android.widget.EditText[@index='10']")
	private WebElement retypeEmailOnboarding;
	
	//@FindBy(xpath = "//android.widget.TextView[@text='DD / MM / YYYY']")
	@FindBy(xpath = "(//android.view.ViewGroup[@clickable='true'])[2]")
	private WebElement dobOnboarding;
	
	@FindBy(id = "android:id/button1")
	private WebElement okButtonOnDatePicker;
	
	// Utilization

	public WebElement getFirstNameOnboarding() {
		Reporter.log("First Name", true);
		return firstNameOnboarding;
	}

	public WebElement getLastNameOnboarding() {
		Reporter.log("Last Name", true);
		return lastNameOnboarding;
	}

	public WebElement getPersonalEmailOnboarding() {
		Reporter.log("Personal Email", true);
		return personalEmailOnboarding;
	}

	public WebElement getRetypeEmailOnboarding() {
		Reporter.log("Retype Personal Email", true);
		return retypeEmailOnboarding;
	}
	
	public WebElement getDobOnboarding() {
		Reporter.log("Date of Birth", true);
		return dobOnboarding;
	}
	
	public WebElement getOkButtonOnDatePicker() {
		Reporter.log("Date picker - ok button", true);
		return okButtonOnDatePicker;
	}
	
	
	/*----------------------------------------------------------------------------------
	 * Get ready to play... screen
	 * Declaration ---------------------- 
	 */
	
	@FindBy(xpath = "//android.widget.TextView[@text='Get ready to play...']")
	private WebElement textGetReadyToPlay;
	
	// Utilization
	
	public WebElement getTextGetReadyToPlay() {
		Reporter.log("Text - Get ready to play...", true);
		return textGetReadyToPlay;
	}
	
	
	// --------------------------------------------------------------------------------
	// Welcome back screen
	// Declaration -----------

	@FindBy(xpath = "//android.widget.TextView[@Text='Continue']")
	private WebElement continueButton;

	// Utilization

	public WebElement getContinueButton() {
		Reporter.log("Continue button - Welcome back screen", true);
		return continueButton;
	}
	

	/*----------------------------------------------------------------------------------
	 * Home screen and Carrefour congratulation screens
	 * Declaration ---------------------- 
	 */
	
	@FindBy(xpath = "//android.widget.TextView[@text='Play Now!']")
	private WebElement playNowButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Skip to Home']")
	private WebElement skipToHomeButton;
	
	// Utilization
	
	public WebElement getPlayNowButton() {
		Reporter.log("Text - Get ready to play...", true);
		return playNowButton;
	}
	
	public WebElement getSkipToHomeButton() {
		Reporter.log("Next button", true);
		return skipToHomeButton;
	}
	
	// --------------------------------------------------------------------------------
	// Side menu screen
	// Declaration -----------

	@FindBy(xpath = "(//android.view.ViewGroup)[22]")
	private WebElement hamburgerMenu;

	@FindBy(xpath = "//android.widget.TextView[@text='About World Winners']")
	private WebElement aboutWorldWinnersSidemenu;

	// Utilization

	public WebElement getHamburgerMenu() {
		Reporter.log("Hamburger menu", true);
		return hamburgerMenu;
	}

	public WebElement getAboutWorldWinnersSidemenu() {
		Reporter.log("About world winners - side menu", true);
		return aboutWorldWinnersSidemenu;
	}

	
	/* --------------------------------------------------------------------------------
	* Play World Winners buttons
	* Declaration -----------
	*/

	@FindBy(xpath = "(//android.view.ViewGroup)[21]")
	private WebElement plusButton;
	
	@FindBy(xpath = "(//android.widget.TextView)[6]")
	private static WebElement noOfTicketAdded;

//	String ticketAdded;
//	@FindBy(xpath = "//android.widget.TextView[@text='Continue with \"+ticketAdded+\" ticket']")
//	private WebElement continueWithnButton;
	
	@FindBy(xpath = "//android.widget.TextView[@text='DELETE']")
	private WebElement deleteButton;

	// Utilization

	public WebElement getPlusButton() {
		return plusButton;
	}
	
	public static WebElement getNoOfTicketAdded() {
		Reporter.log("No of ticket added - Text", true);
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
	
	// ===========================================================================================
	// Initialization ------------

	public ElementsStore(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}

}
