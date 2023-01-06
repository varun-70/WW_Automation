package util;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeUtils {

	public TouchAction action;
	public Dimension size;

	public SwipeUtils(AndroidDriver<WebElement> driver) {
		action = new TouchAction(driver);
		size = driver.manage().window().getSize();
	}

    /**
	 * Using swipe gesture on the screen by specifying the location by passing the
	 * start point (x-axis and y-axis) and end point (x-axis and y-axis) as parameters.
	 *
	 * X-axis is divided into 4 parts(means 3 points on the screen), 0 is left corner and 4 is right corner of the screen
	 * Y-axis is divided into 7 parts(means 6 points on the screen), 0 is top corner and 7 is bottom corner of the screen
	 *
	 * @param xStart an integer from 0 to 4 on x-axis, the starting point of x-axis.
	 * @param xEnd an integer from 0 to 7 on y-axis, the end point of x-axis
	 * @param yStart an integer from 0 to 4 on x-axis, the starting point of y-axis
	 * @param yEnd an integer from 0 to 7 on y-axis, the end point of y-axis
	 */
	public void swipeByLocation(int xStart, int xEnd, int yStart, int yEnd) {
		int width=size.width;
		int height=size.height;
		int startXCoordinate = (width/4)*(xStart); // 3 touch points on the x axis (width)
		int startYCoordinate = (height/7)*(yStart); // 6 touch points on the y axis (height)
		int endXCoordinate = (width/4)*(xEnd);
		int endYCoordinate = (height/7)*(yEnd);

		action.longPress(longPressOptions().withPosition(PointOption.point(startXCoordinate, startYCoordinate))
				.withDuration(Duration.ofSeconds(1))).moveTo(PointOption.point(endXCoordinate, endYCoordinate)).release().perform();
	}

	/**
	 * Performing swipe action from the element to offset position  
	 * 
	 * @param element is an element from where swipe action is performed
	 * @param xAxis is the offset location from the element in the xAxis
	 * @param yAxis is the offset location from the element in the yAxis
	 */
	public void swipeByElementToOffset(WebElement element, int xAxis, int yAxis) {
		
		Point elementLocation = element.getLocation();
		int xCoordinate = elementLocation.x;
		int yCoordinate = elementLocation.y;
		System.out.println(element.getLocation());
		System.out.println(elementLocation.x);
		System.out.println(elementLocation.y);
		action.longPress(longPressOptions().withElement(ElementOption.element(element))
				.withDuration(Duration.ofMillis(500))).moveTo(PointOption.point(xCoordinate + xAxis, yCoordinate + yAxis))
				.release().perform();
		
	}
	
	/**
	 * Performing swipe action from the one element to another element  
	 * 
	 * @param element is an element from where swipe action is performed
	 * @param xAxis is the offset location from the element in the xAxis
	 * @param yAxis is the offset location from the element in the yAxis
	 */
	public void swipeByElementToElement(WebElement startElement, WebElement endElement) {
		
		action.longPress(longPressOptions().withElement(ElementOption.element(startElement))
				.withDuration(Duration.ofMillis(500))).moveTo(ElementOption.element(endElement))
				.release().perform();
		
	}
}
