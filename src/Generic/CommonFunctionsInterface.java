package generic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.DataFormatException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.w3c.dom.events.EventException;

public interface CommonFunctionsInterface {
	public abstract void tapByLocation(int x, int y);

	public abstract String getExcelData(int r, int c) throws FileNotFoundException, EncryptedDocumentException, DataFormatException, IOException;
	
	public abstract void tapByElement(WebElement ele);
	
	public abstract int getotp();
	
	public abstract WebElement getContinueWithnButton();
	
	public abstract void swipingLocation(int xStart, int xEnd, int yStart, int yEnd);
	
	public abstract void countryCodeSelection(int code);
	
	public abstract void textAssertion(WebElement ele, String expected);

}
