package scripts;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import base.Base;
import pages.PlayWorldWinnersPage;
import util.SwipeUtils;
import util.TicketUtils;

public class PlayWorldWinnersTest extends Base{


	@Test
	public void playWorldWinners() throws InterruptedException, Exception {
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		PlayWorldWinnersPage regular = new PlayWorldWinnersPage(driver);
		TicketUtils tickets = new TicketUtils(driver);
		SwipeUtils swipe = new SwipeUtils(driver);
		
		// Play world winners flow
		try {
			regular.getPlayNowButton().isDisplayed();
		}
		catch(NoSuchElementException e) {
			System.err.println("Error cards are dispalyed with a proper internet");
			swipe.swipeByLocation(3, 3, 4, 6);
			regular.getPlayNowButton().isDisplayed();
		}
		
		regular.getPlayNowButton().click();
		
		for(int i=1;i<=3;i++) {
			try{
			if(regular.getNextButton().isDisplayed()) {
				regular.getNextButton().click();
				Thread.sleep(300);
			}
			else
				break;
			}
			catch(Exception e) {
				break;
			}
			
		}
		
		tickets.addTicket(10);
		tickets.deleteTicket(5);
	}


}
