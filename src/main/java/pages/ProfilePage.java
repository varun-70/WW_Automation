package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

/** Onboarding profile screen Elements */

public class ProfilePage {

	//Declaration --------------------------------------------------------
	
	@FindBy(xpath = "//android.widget.EditText[@text='First Name']")
	private WebElement firstName;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Last Name']")
	private WebElement lastName;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Personal Email']/following-sibling::android.widget.EditText[1]")
	private WebElement personalEmail;

	@FindBy(xpath = "//android.widget.TextView[@text='Retype Personal Email']/following-sibling::android.widget.EditText[1]")
	private WebElement retypePersonalEmail;
	
//	@FindBy(xpath = "//android.widget.TextView[@text='DD / MM / YYYY']")
	@FindBy(xpath = "//android.widget.TextView[@text='When is your birthday?']/following-sibling::android.view.ViewGroup[1]")
	private WebElement dob;
	
	@FindBy(id = "android:id/date_picker_header_year")
	private WebElement datePickerYear;
	
	@FindBy(id = "android:id/date_picker_header_date")
	private WebElement datePickerHeaderDate;
	
	@FindBy(xpath = "//android.view.View[@resource-id='android:id/month_view']//android.view.View")
	private List<WebElement> datePickerMonthView;
	
	@FindBy(id = "android:id/prev")
	private WebElement previousMonth;
	
	@FindBy(id = "android:id/next")
	private WebElement nextMonth;
	
	@FindBy(id = "android:id/button1")
	private WebElement okButton;
	
	@FindBy(id = "android:id/button2")
	private WebElement cancelButton;
	
	@FindBy(id = "android:id/text1")
	private List<WebElement> yearsList;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Next']")
	private WebElement nextButton;
	
	// Utilization --------------------------------------------------------

	public WebElement getFirstName() {
		return firstName;
	}
	
	public WebElement getLastName() {
		return lastName;
	}
	
	public WebElement getPersonalEmail() {
		return personalEmail;
	}
	
	public WebElement getRetypePersonalEmail() {
		return retypePersonalEmail;
	}
	
	public WebElement getDob() {
		return dob;
	}
	
	public WebElement getDatePickerYear() {
		return datePickerYear;
	}
	
	public WebElement getDatePickerHeaderDate() {
		return datePickerHeaderDate;
	}
	
	public List<WebElement> getDatePickerMonthView() {
		return datePickerMonthView;
	}
	
	public WebElement getPreviousMonth() {
		return previousMonth;
	}
	
	public WebElement getNextMonth() {
		return nextMonth;
	}
	
	public WebElement getOkButton() {
		return okButton;
	}
	
	public WebElement getCancelButton() {
		return cancelButton;
	}
	
	public List<WebElement> getYearsList() {
		return yearsList;
	}
	
	public WebElement getNextButton() {
		Reporter.log("Next button", true);
		return nextButton;
	}
	
	// Initialization ------------

	public ProfilePage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
}
