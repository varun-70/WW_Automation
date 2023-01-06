package scripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import base.Base;
import pages.CarbonOffsetPage;
import pages.HomeScreenPage;
import pages.SideMenuPage;
import pages.StripePaymentPage;
import util.ScrollUtils;
import util.SwipeUtils;

public class CarbonOffsetTest extends Base{
	@Test
	public void carbonOffset() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		HomeScreenPage home = new HomeScreenPage(driver);
		SideMenuPage sideMenu = new SideMenuPage(driver);
		CarbonOffsetPage carbonOffset = new CarbonOffsetPage(driver);
		StripePaymentPage stripe = new StripePaymentPage(driver);
		
		home.getHamburgerOption().click();
		sideMenu.getBuyCarbonOffsets().click();
		
		try {
			for(int i=0; i<3; i++) {
				carbonOffset.getNextButton().click();
			}
		}
		catch (Exception e) {
		}
		
		SwipeUtils swipe = new SwipeUtils(driver);
		ScrollUtils scroll = new ScrollUtils(driver);
		
		for(int i=0; i<3; i++) {
			swipe.swipeByElementToOffset(carbonOffset.getSwipeToBuy().get(i), 600, 0);
			carbonOffset.getConfirmAndPay().click();
			stripe.getPayButton().isDisplayed();
			Thread.sleep(2000);
			stripe.getCardNumber().sendKeys("4242424242424242");
			Thread.sleep(2000);
			stripe.getExpiry().sendKeys("0525");
			Thread.sleep(2000);
			stripe.getCvc().sendKeys("111");
			Thread.sleep(2000);
			stripe.getPayButton().click();
			
//			if(stripe.getCountryDropDown().getText()!="India") {
//				stripe.getCountryDropDown().click();
//				scroll.scrollByText("India");
//			}
			
		}
		
		
		
	}
}
