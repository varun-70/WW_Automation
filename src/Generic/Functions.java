package Generic;

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

import Pom.ElementsStore;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Functions implements FunctionsInterface {

	AndroidDriver<WebElement> driver;
	public TouchAction action;
	public Scanner scanner;
	public Dimension size;
	public ElementsStore elements;

	public Functions(AndroidDriver<WebElement> driver) {
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
	 * @return the String data fetch from excel
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

	// Used for the tapping on the location by sending the location x-axis and y-axis as parameters
	@Override
	public void tapByLocation(int x, int y) {
		int width=size.width;
		int height=size.height;
		int tapByXCordinate=(width/6)*(x);
		int tapByYCordinate=(height/11)*(y);
		action.tap(PointOption.point(tapByXCordinate, tapByYCordinate)).perform();
	}

	// Used for the tapping on the element by sending the element parameter
	public void tapByElement(WebElement ele) {
		action.tap(new TapOptions().withElement(new ElementOption().withElement(ele))).perform();
	}

	// Used to dynamically enter the OTP on the console
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
	* 
	* 
	* Using swipe gesture on the screen by specifying the location by passing the 
	* start point (x-axis and y-axis) and end point (x-axis and y-axis) as parameters
	* 
	*/
	public void swipingLocation(int xStart, int xEnd, int yStart, int yEnd) {
		int width=size.width;
		int height=size.height;
		int startXCoordinate = (width/4)*(xStart); // 3 touch points on the x axis (width)
		int startYCoordinate = (height/7)*(yStart); // 6 touch points on the y axis (height)
		int endXCoordinate = (width/4)*(xEnd); // left most screen is 0 x-axis, and top most screen is 0 y-axis
		int endYCoordinate = (height/7)*(yEnd);
		
		action.longPress(longPressOptions().withPosition(PointOption.point(startXCoordinate, startYCoordinate))
				.withDuration(Duration.ofSeconds(1))).moveTo(PointOption.point(endXCoordinate, endYCoordinate)).release().perform();
	}
	
	/* Selecting the country code by passing the parameter as country code in int data type.
	* If the displayed country code and parameters passed are same then it will skip and return
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
