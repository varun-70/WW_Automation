package scripts1;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import generic1.Generic;


public class Onboarding extends Generic {

	@Test
	public void onboarding() throws InterruptedException, Exception {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Onboarding
		// Get started screen and Phone number screen
		elements.getGetStartedOnboarding().click();
		String phno = function.getExcelData(1, 2);
		elements.getPhnoFieldOnboarding().sendKeys(phno);
		driver.hideKeyboard();
		elements.getCheckBoxPhnoscreenOnboarding().click();
		function.textAssertion(elements.getHeaderTextPhoneNumber(), "What’s your number?");	
		function.countryCodeSelection(91);
		elements.getTermsandConditionOnboarding().click();
		elements.getDoneButton().click();
		elements.getPrivacyPolicyOnboarding().click();
		elements.getDoneButton().click();
		elements.getNextButton().click();

		// Secret code screen
		function.tapByLocation(3, 3);
		function.textAssertion(elements.getHeaderTextSecretCode(), "We sent you a secret code!");
		elements.getChangeButton().click();
		Thread.sleep(1000);
		driver.hideKeyboard();
		elements.getNextButton().click();
		
		// String otp = Integer.toString(function.getotp());  // Getting dynamic input from the user
		function.tapByLocation(3, 3);
		elements.getotp_field_onboarding().sendKeys("1234");
		elements.getSubmitButton().click();		

		// Great let's get to know you screen
		elements.getFirstNameOnboarding().sendKeys("Varun");   // Filling all the required fields
		function.tapByLocation(3, 3);
		elements.getLastNameOnboarding().sendKeys("ms");
		function.swipingLocation(2, 2, 5, 2);
		elements.getPersonalEmailOnboarding().sendKeys("varun@gmail.com");
		elements.getRetypeEmailOnboarding().sendKeys("varun@gmail.com");
		
		elements.getDobOnboarding().click(); 			// Date of Birth
		elements.getOkButtonOnDatePicker().click();
		elements.getNextButton().click();
		Thread.sleep(2000);
		elements.getNextButton().click();
		elements.getSkipToHomeButton().click();
		Thread.sleep(1000);		
	}
}
