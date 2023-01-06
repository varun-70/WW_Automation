package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class WaitForElement {
	
	AndroidDriver<WebElement> driver;

	public WaitForElement(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}
	
	public boolean waitForElementToDisappear(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver,10);
	    try {
	        wait.until((ExpectedConditions.invisibilityOf(element)));
	        return true;
	    }catch (Throwable t){
	        return false;
	    }
	}
}
