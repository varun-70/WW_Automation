package util;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class TapUtils {

	public TouchAction action;
	public Dimension size;

	public TapUtils(AndroidDriver<WebElement> driver) {
		action = new TouchAction(driver);
		size = driver.manage().window().getSize();
	}

	/**
	 * Receives x-axis and y-axis parameters, calculate, and taps on the x-axis and y-axis co-ordinate.
	 *
	 * X-axis is divided into 6 parts(means 5 points on the screen), 0 is left corner and 6 is right corner of the screen
	 * Y-axis is divided into 11 parts(means 10 points on the screen), 0 is top corner and 11 is bottom corner of the screen
	 *
	 * @param xAxis an integer from 0 to 6 on x-axis
	 * @param yAxis an integer from 0 to 11 on y-axis
	 */
	public void tapByLocation(int xAxis, int yAxis) {
		int width=size.width;
		int height=size.height;
		int tapByXCordinate=(width/6)*(xAxis);
		int tapByYCordinate=(height/11)*(yAxis);
		action.tap(PointOption.point(tapByXCordinate, tapByYCordinate)).perform();
	}

	/**
	 * Used for the tapping on the location by sending the location x-axis and y-axis as parameters.
	 *
	 * @param ele an WebElement
	 */
	public void tapByElement(WebElement ele) {
		action.tap(new TapOptions().withElement(new ElementOption().withElement(ele))).perform();
	}

}
