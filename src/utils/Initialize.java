package utils;

import java.util.Scanner;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import pages.CommonButtons;
import pages.CountryCodeSelection;
import pages.ElementsStore;
import pages.GetReadyToPlay;
import pages.GetStarted;
import pages.PhoneNumberScreen;
import pages.WelcomeBack;

/** Used for initializing the driver for pages and necessary utils classes */

public class Initialize {

	AndroidDriver<WebElement> driver;

	public Initialize(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		initialize();
	}

	// Used for initializing the driver for pages and necessary utils classes
	public void initialize() {
		new CommonButtons(driver);
		new PhoneNumberScreen(driver);
		new GetReadyToPlay(driver);
		new GetStarted(driver);
		new WelcomeBack(driver);
		new CountryCodeSelection(driver);
		
		new ContinueButtonWithnTicketUtils(driver); //utils class
		new TappingUtils(driver);
		new SwipingUtils(driver);
		new CountryCodeSkip(driver);
	}
}
