package scripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import base.Base;
import pages.WelcomeBackPage;

public class WelcomeBackTest extends Base{
	
	@Test
	public void test() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WelcomeBackPage welcomeBack = new WelcomeBackPage(driver);
		welcomeBack.getContinueButton().click();
	}

}
