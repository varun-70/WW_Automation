package generic1;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;
import java.util.zip.DataFormatException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import pom1.ElementsStore;

//Used for generic methods

public class CommonFunctions implements CommonFunctionsInterface {

	AndroidDriver<WebElement> driver;
	public TouchAction action;
	public Scanner scanner;
	public Dimension size;
	public ElementsStore elements;

	public CommonFunctions(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		initialize();
	}

	// Used for initializing all the non-static members
	public void initialize() {
		action = new TouchAction(driver);
		scanner = new Scanner(System.in);
		size = driver.manage().window().getSize();
		elements = new ElementsStore(driver);
	}

	/**
	 * Fetches the data from the excel as string, returns the fetched string value
	 * 
	 * @param row an integer of the row number in excel
	 * @param cell an integer of the cell number in excel
	 * @return the String data fetched from excel
	 * @exception EncryptedDocumentException  if the FileInputStream is used
	 * @exception IOException if the WorkbookFactory is used
	 */
	@Override
	public String getExcelData(int row, int cell) throws EncryptedDocumentException, IOException  {
		FileInputStream file = new FileInputStream("./Excel sheet/data.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("Sheet1");
		Row rowData = sh.getRow(row);
		Cell cellData = rowData.getCell(cell);
		String data = cellData.toString();
		return data;
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
	@Override
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

	/** 
	 * Used to dynamically enter the OTP on the console
	 * 
	 * @return the int OTP
	 */
	public int getotp() {
		System.out.print("Enter OTP: ");
		int otp = scanner.nextInt();
		return otp;
	}
	
	/**
	 * Gets the no. element text, click on "Continue with n Button" element dynamically
	 * 
	 * @return the continueWithnButton Web Element
	 * POM (Page Object Model) should have static data and doesn't support dynamic data in the element.
	 */
	public WebElement getContinueWithnButton() {
		String ticketAdded=ElementsStore.getNoOfTicketAdded().getText();
		WebElement continueWithnButton;
		if(ticketAdded.equals(1)) {
			continueWithnButton=driver.findElementByXPath("//android.widget.TextView[@text='Continue with "+ticketAdded+" ticket']");
			Reporter.log("Continue with "+ticketAdded+" ticket", true);
		}
		else {
			continueWithnButton=driver.findElementByXPath("//android.widget.TextView[@text='Continue with "+ticketAdded+" tickets']");
			Reporter.log("Continue with "+ticketAdded+" tickets", true);
		}
		return continueWithnButton;
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
	public void swipingLocation(int xStart, int xEnd, int yStart, int yEnd) {
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
	* Selecting the country code by passing the parameter as country code in int data type.
	* If the displayed country code and parameters passed are same then it will skip and return
	* 
	* @param code an int of country code
	*/
	public void countryCodeSelection(int code) {
		int countryCode=Integer.parseInt(elements.getCountryCode().getText().substring(1));
		if(countryCode==code) {
			return;
		}
		elements.getCountryCode().click();
		String code1=Integer.toString(code);
		elements.getSearchInputOfCountryCode().sendKeys(code1);
		elements.getCountryCodeSelect().click();
	}
	
	// For performing the verification by using assertion
	public void textAssertion(WebElement ele, String expected) {
		String actual = ele.getText();
		Assert.assertEquals(actual, expected);
		System.out.println(actual+" - Text verified");
	}
}
