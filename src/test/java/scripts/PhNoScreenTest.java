package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pages.CountryCodeSelectionPage;
import pages.PhNoScreenPage;

public class PhNoScreenTest extends Base {
	
	@Parameters({"PhoneNumber"})
	@Test
	public void test(String phoneNumber) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PhNoScreenPage phNo = new PhNoScreenPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,10);
		countryCodeSelection(91);
		phNo.getPhnoField().sendKeys(phoneNumber);
		phNo.getCheckBox().click();
		phNo.getTermsandCondition().click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
//		wait.until(ExpectedConditions.driver.isKeyboardShown());
		Thread.sleep(2000);
		driver.hideKeyboard();
		phNo.getPrivacyPolicy().click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		phNo.getNextButton().click();

		ExpectedCondition<Boolean> t = ExpectedConditions.invisibilityOf(phNo.getTermsandCondition());
		
//		System.out.println(ExpectedConditions.invisibilityOf(phNo.getTermsandCondition()));
//		System.out.println(ExpectedConditions.visibilityOf(phNo.getTermsandCondition()));
//		wait.until(ExpectedConditions.visibilityOf(phNo.getTermsandCondition()));
//		System.out.println(waitForElementToDisappear(phNo.getTermsandCondition()));
//		System.out.println(ExpectedConditions.visibilityOf(phNo.getTermsandCondition()));
//		System.out.println(ExpectedConditions.invisibilityOf(phNo.getTermsandCondition()));
	}
	
	/**
	 * Waits for the element to disappear on the page/screen
	 * 
	 * @param element
	 * @return
	 */
	public boolean waitForElementToDisappear(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver,10);
	    try {
	        wait.until((ExpectedConditions.invisibilityOf(element)));
	        return true;
	    }catch (Throwable t){
	        return false;
	    }
	}
	
    /** 
     * This method is used to skip the country code selection screen
     * 
	 * Selecting the country code by passing the parameter as country code in int data type.
	 * If the displayed country code and parameters passed are same then it will skip and return
 	 * 
	 * @param code an int of country code
     * @throws InterruptedException 
 	 */
	public void countryCodeSelection(int code) throws InterruptedException {
		CountryCodeSelectionPage cc = new CountryCodeSelectionPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		int countryCode=Integer.parseInt(cc.getCountryCodeDropDown().getText().substring(1));
		if(countryCode==code) {
			driver.hideKeyboard();
			return;
		}
		cc.getCountryCodeDropDown().click();
		String code1=Integer.toString(code);
		cc.getSearchInputOfCountryCode().sendKeys(code1);
		cc.getCountryCodeSelect().click();
	}
}
