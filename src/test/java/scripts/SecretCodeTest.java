package scripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Base;
import pages.SecretCodePage;
import util.TapUtils;
import util.TestDataUtils;
import util.LoginApi;

public class SecretCodeTest extends Base {

	@Parameters({"PhoneNumber"})
	@Test
	public void test(String phoneNumber) throws InterruptedException, URISyntaxException, IOException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SecretCodePage secretCode = new SecretCodePage(driver);
		TapUtils tap = new TapUtils(driver);
		TestDataUtils testData = new TestDataUtils();

		Thread.sleep(4000);
		tap.tapByLocation(3, 2);
//		tap.tapByLocation(2, 3);
//		secretCode.getChangeButton().click();
//		Thread.sleep(2000);
//		driver.hideKeyboard();
//		secretCode.getNextButton().click();
//		tap.tapByLocation(2, 3);
//		tap.tapByLocation(3, 4);

		secretCode.getOtpField().sendKeys(LoginApi.getLoginCode("91" + phoneNumber));


		secretCode.getSubmitButton().click();

	}

}
