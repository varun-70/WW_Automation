package util;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

/** This class is used for performing visual validations */

public class VisualTestUtils {

	/**
	 * For performing the verification by using hard assertion
	 * @param ele is an Web Element of the actual text
	 * @param expected is an String of the Expected text
	 */
	public static void textAssertion(WebElement ele, String expected) {
		String actual = ele.getText();
		Assert.assertEquals(actual, expected);
		System.out.println(" - Text verified");
	}
	
	/**
	 * For performing the verification by removing the spaces and tabs and by using hard assertion
	 * @param ele is an Web Element of the actual text
	 * @param expected is an String of the Expected text
	 */
	public static void textAssertionWithoutSpaces(WebElement ele, String expected) {
		String actual = ele.getText();
		actual = actual.replaceAll("\\s+","");
		Assert.assertEquals(actual, expected);
		System.out.println(" - Text verified");
	}
}
