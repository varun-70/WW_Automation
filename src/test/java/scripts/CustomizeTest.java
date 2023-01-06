package scripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import base.Base;
import pages.CustomizePage;
import pages.PlayWorldWinnersPage;
import util.TicketUtils;

public class CustomizeTest extends Base{
	@Test
	public void customize() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		CustomizePage customize = new CustomizePage(driver);
		PlayWorldWinnersPage regular = new PlayWorldWinnersPage(driver);
		TicketUtils tickets = new TicketUtils(driver);
		
		int n = customize.getCustomize().size();
		System.out.println(n);
		Thread.sleep(500);
		customize.getCustomize().get(n-1).click();

		for(int i=0; i<customize.getSelectedNumbers().size(); i++) {
			Thread.sleep(500);
			System.out.println(customize.getSelectedNumbers().get(i).getText());
		}
		
//		customize.getRandomize().click();
//		customize.getClearAll().click();
//		customize.getRandomize().click();
		
		for(int i=6; i>=0; i--) {
			Thread.sleep(500);
			System.out.println("clicked - " + customize.getSelectedNumbers().get(i).getText());
			customize.getSelectedNumbers().get(i).click();
		}
		
		customize.getRandomize().click();
		
		Thread.sleep(2000);
		
		customize.getDone().click();
		
		
	}
}
