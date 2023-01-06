package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

public class CustomizePage {

	//Declaration --------------------------------------------------------
	
	@FindBy(xpath = "//android.widget.TextView[@text='CUSTOMIZE']")
	private List<WebElement> customize;
	
	@FindBy(xpath = "//android.widget.TextView[@text='RANDOMIZE']")
	private WebElement randomize;
	
	@FindBy(xpath = "//android.widget.TextView[@text='CLEAR ALL']")
	private WebElement clearAll;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Done']")
	private WebElement done;

	@FindBy(xpath = "(//android.view.ViewGroup)[17]//android.view.ViewGroup//android.widget.TextView")
	private List<WebElement> selectedNumbers;
	
	// Utilization --------------------------------------------------------

	public List<WebElement> getCustomize() {
		Reporter.log("Customize button - clicked", true);
		return customize;
	}
	
	public WebElement getRandomize() {
		Reporter.log("Randomize - clicked", true);
		return randomize;
	}
	
	public WebElement getClearAll() {
		Reporter.log("Clear all - clicked", true);
		return clearAll;
	}
	
	public WebElement getDone() {
		Reporter.log("Clear all - clicked", true);
		return done;
	}

	public List<WebElement> getSelectedNumbers() {
		return selectedNumbers;
	}
	
	// Initialization ------------

	public CustomizePage(AndroidDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
}
