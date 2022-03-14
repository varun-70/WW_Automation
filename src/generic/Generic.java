package generic;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import pages.ElementsStore;
import utils.Initialize;

public class Generic {

	public static AndroidDriver<WebElement> driver;
	public static CommonFunctions function;
	public static ElementsStore elements;
	public static TouchAction action;

	@BeforeTest
	public void openapln() throws MalformedURLException {
		
		File appDir=new File("src");
		File app=new File(appDir, "WorldWinners.apk");
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
//		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
//		dc.setCapability(CapabilityType.PLATFORM_NAME, "Android");
//		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel v11 5.0inch  API 30");
		dc.setCapability(CapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		URL url = new URL("http:0.0.0:4723/wd/hub");

		driver = new AndroidDriver<>(url, dc);
		elements = new ElementsStore(driver);
		function = new CommonFunctions(driver);
		Initialize init = new Initialize(driver);
		action = new TouchAction(driver);

	}

	@AfterTest
	public void closeapln() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
