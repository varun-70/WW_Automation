package util;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import pages.ProfilePage;

public class DatePickerUtils {
	AndroidDriver<WebElement> driver;

	/**
	 * Takes the DOB in parameter and set the date in the date picket
	 * 
	 * @param dob takes the date in date format
	 */
	public void setDOB(Date dob) {
		ProfilePage profile = new ProfilePage(driver);
		System.out.println(dob);
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dob);
		int date = calendar.get(Calendar.DATE);
		int year = calendar.get(Calendar.YEAR);
		int month = getMonthNumber(new SimpleDateFormat("MMM").format(dob)) + 1;
		System.out.println(date + "-" + month + "-" + year);
		
		
		profile.getDatePickerHeaderDate();
		profile.getDatePickerMonthView();
		
		int currentYear = Integer.valueOf(profile.getDatePickerYear().getText());
		String[] monthInarr = (profile.getDatePickerHeaderDate().getText()).split(" ");
		
		int currentMonth = getMonthNumber(monthInarr[1]);
		
		if(year!=currentYear) {
			profile.getDatePickerYear().click();
//			ScrollUtils scroll = new ScrollUtils(driver);
//			scroll.scrollByText(Integer.toString(year));
			swipeInListTillExpectedTextAndTap(profile.getYearsList(), Integer.toString(year), 15);
			
//			driver.findElementByXPath("//*[@resource-id='android:id/date_picker_year_picker']/*[@text='" + year + "']").click();
		}
		
		if(month<currentMonth) {
			for(int i=0; i<=currentMonth-month; i++) {
				profile.getPreviousMonth().click();
			}
		}
		else if (month>currentMonth) {
			for(int i=0; i<=month-currentMonth; i++) {
				profile.getNextMonth().click();
			}
		}
		
		profile.getDatePickerMonthView().get(date-1).click();
		
	}
	
	/**
	 * Takes month name and return month number
	 * 
	 * @param monthName
	 * @return the month in number
	 */
	public int getMonthNumber(String monthName) {
		Date date = null;
		try {
			date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(monthName);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}
	
	/**
	 * To perform the swipe action in a list until the expected text is visible
	 * 
	 * @param list Multiple elements in a list
	 * @param expectedText 
	 * @param time, the time swipe action will be performed if expected text is not found
	 */
	public void swipeInListTillExpectedTextAndTap(List<WebElement> list, String expectedText, int time) {
		int i = 1;
		while (!driver.getPageSource().contains(expectedText)) {
			swipeInListFromLastToFirst(list);
			i++;
			if (i == time)
				break;
		}
		driver.findElementByXPath("//*[@resource-id='android:id/date_picker_year_picker']/*[@text='" + expectedText + "']").click();
	}
	
	/**
	 * To perform the swipe action in a list from first to last 
	 * 
	 * @param listID Multiple elements in a list
	 */
	public void swipeInListFromLastToFirst(List<WebElement> listID) {
		int items = listID.size();
		Point centerOfFirstElement = listID.get(0).getLocation();
		Point centerOfLastElement = listID.get(items-1).getLocation();
		
		TouchAction action = new TouchAction<>(driver);
		action.longPress(longPressOptions().withPosition(PointOption.point(centerOfFirstElement.x, centerOfFirstElement.y))
				.withDuration(Duration.ofMillis(100))).moveTo(PointOption.point(centerOfLastElement.x, centerOfLastElement.y))
				.release().perform();
		
	}
	
	/**
	 * Constructor to initialize the driver whenever an object is created
	 * 
	 * @param driver
	 */
	public DatePickerUtils(AndroidDriver<WebElement> driver) {
		this.driver = driver;
	}
	
}
