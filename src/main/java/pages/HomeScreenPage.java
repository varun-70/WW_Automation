package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class HomeScreenPage {

	/* --------------------------------------------------------------------------------
	* Home Screen
	* Declaration -----------
	*/
	
	@FindBy(xpath = "//android.widget.TextView[@text='Coupons']/following-sibling::android.widget.TextView[1]")
	private WebElement couponBalance;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Coupons']/../preceding-sibling::android.view.ViewGroup[1]//android.view.ViewGroup[1]")
	private WebElement hamburgerOption;
	
	
	// Utilization---------------------
	
	public WebElement getCouponBalance() {
		return couponBalance;
	}
	
	public WebElement getHamburgerOption() {
		return hamburgerOption;
	}
	
	// Initialization ------------

	public HomeScreenPage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	
}
