package scripts;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.Base;
import pages.ConfirmScreenPage;
import pages.PlayWorldWinnersPage;
import util.TicketUtils;

public class ConfirmScreenTest extends Base{

	@Test
	public void confirmTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TicketUtils tickets = new TicketUtils(driver);
		ConfirmScreenPage confirm = new ConfirmScreenPage(driver);
		PlayWorldWinnersPage regular = new PlayWorldWinnersPage(driver);
		
		
		tickets.getContinueWithnButton().click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(regular.getYourBalance()));
		
		System.out.println(waitForElementToDisappear(regular.getYourBalance()));
//		Thread.sleep(4000);
		tickets.verifyTicketNo(6);
		
		confirm.getConfirmButton().click();
//		Thread.sleep(4000);
		System.out.println(waitForElementToDisappear(confirm.getConfirmSelection()));
		
		try {
			confirm.getBackToHomeButton().click();
		}
		catch(NoSuchElementException e) {
			confirm.getSkipForNowButton().click();
		}
		catch(Exception e) {
			System.out.println("ConfirmScreenTest.confirmTest()");
			confirm.getSkipForNowButton().click();
		}
	}
	
	public boolean waitForElementToDisappear(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver,10);
	    try {
	        wait.until((ExpectedConditions.invisibilityOf(element)));
	        return true;
	    }catch (Throwable t){
	        return false;
	    }
	}
}
