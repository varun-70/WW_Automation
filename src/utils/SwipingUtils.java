package utils;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class SwipingUtils {

	public static TouchAction action;
	public static Dimension size;
	
	public SwipingUtils(AndroidDriver<WebElement> driver) {
		action = new TouchAction(driver);
		size = driver.manage().window().getSize();
	}
	

    /**
	 * Using swipe gesture on the screen by specifying the location by passing the 
	 * start point (x-axis and y-axis) and end point (x-axis and y-axis) as parameters.
	 * 
	 * X-axis is divided into 4 parts(means 3 points on the screen), 0 is left corner and 4 is right corner of the screen
	 * Y-axis is divided into 7 parts(means 6 points on the screen), 0 is top corner and 6 is bottom corner of the screen
	 * 
	 * @param xStart an integer from 0 to 4 on x-axis, the starting point of x-axis.
	 * @param xEnd an integer from 0 to 7 on y-axis, the end point of x-axis
	 * @param yStart an integer from 0 to 4 on x-axis, the starting point of y-axis
	 * @param yEnd an integer from 0 to 7 on y-axis, the end point of y-axis
	 */
	public static void swipingLocation(int xStart, int xEnd, int yStart, int yEnd) {
		int width=size.width;
		int height=size.height;
		int startXCoordinate = (width/4)*(xStart); // 3 touch points on the x axis (width)
		int startYCoordinate = (height/7)*(yStart); // 6 touch points on the y axis (height)
		int endXCoordinate = (width/4)*(xEnd); 
		int endYCoordinate = (height/7)*(yEnd);
		
		action.longPress(longPressOptions().withPosition(PointOption.point(startXCoordinate, startYCoordinate))
				.withDuration(Duration.ofSeconds(1))).moveTo(PointOption.point(endXCoordinate, endYCoordinate)).release().perform();
	}
	
}
