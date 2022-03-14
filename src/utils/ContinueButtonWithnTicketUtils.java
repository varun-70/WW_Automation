package utils;

import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import pages.ElementsStore;

public class ContinueButtonWithnTicketUtils {
	AndroidDriver<WebElement> driver;
	
	public ContinueButtonWithnTicketUtils(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}
	
	/**
	 * Gets the no. element text, click on "Continue with n Button" element dynamically
	 * 
	 * @return the continueWithnButton Web Element
	 * POM (Page Object Model) should have static data and doesn't support dynamic data in the element.
	 */
	public WebElement getContinueWithnButton() {
		String ticketAdded=ElementsStore.getNoOfTicketAdded().getText();
		WebElement continueWithnButton;
		if(ticketAdded.equals(1)) {
			continueWithnButton=driver.findElementByXPath("//android.widget.TextView[@text='Continue with "+ticketAdded+" ticket']");
			Reporter.log("Continue with "+ticketAdded+" ticket", true);
		}
		else {
			continueWithnButton=driver.findElementByXPath("//android.widget.TextView[@text='Continue with "+ticketAdded+" tickets']");
			Reporter.log("Continue with "+ticketAdded+" tickets", true);
		}
		return continueWithnButton;
	}
	
}
