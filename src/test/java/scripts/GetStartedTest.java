package scripts;

import org.testng.annotations.Test;

import base.Base;
import pages.GetStartedPage;

public class GetStartedTest extends Base {
	
	@Test
	public void test() {
		GetStartedPage landingScreen = new GetStartedPage(driver);
		landingScreen.getGetStartedOnboarding().click();
	}
}
