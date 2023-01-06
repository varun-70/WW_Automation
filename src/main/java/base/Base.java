package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

/** Base class is used to installing and closing the app */
public class Base {
	public static AndroidDriver<WebElement> driver;
	public static String appId;
	
	/** To Install and open the app */
	@BeforeTest
	public void openapln() throws IOException, InterruptedException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/Resources/global.properties");
		Properties prop= new Properties();
		prop.load(fis);
		
		File appDir=new File("src/main/java/Resources");
		File app=new File(appDir, (String) prop.get("WorldWinners"));
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, prop.get("AndroidDevice"));
		dc.setCapability(CapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.get("AndroidVersion"));
//		dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		URL url = new URL("http:0.0.0:4723/wd/hub");

		dc.setCapability("appPackage", "com.lotteryreactnative");
		// This package name of your app (you can get it from apk info app)
		dc.setCapability("appActivity","com.lotteryreactnative.MainActivity");
			
		driver = new AndroidDriver<>(url, dc);
		appId = driver.getCurrentPackage();

	}

	/** For closing the app*/
	@AfterTest
	public void closeapln() throws InterruptedException, IOException {
		Thread.sleep(2000);
//		driver.quit();
	}
}
