package scripts;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import base.Base;
import pages.ProfilePage;
import util.DatePickerUtils;
import util.SwipeUtils;
import util.TapUtils;

public class ProfileTest extends Base{

	@Test
	public void profile() throws URISyntaxException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Faker faker = new Faker();
		
		ProfilePage profileInfo = new ProfilePage(driver);
		
		profileInfo.getFirstName().sendKeys(faker.name().firstName());
		profileInfo.getLastName().sendKeys(faker.name().lastName());
		driver.hideKeyboard();
		
		TapUtils tap = new TapUtils(driver);
		String email = faker.internet().emailAddress();
		
		profileInfo.getPersonalEmail().sendKeys(email);
		profileInfo.getRetypePersonalEmail().sendKeys(email);
		
		SwipeUtils swipe = new SwipeUtils(driver);
		swipe.swipeByLocation(3, 3, 5, 3);
		
		profileInfo.getDob().click();
		
		DatePickerUtils dobUtils = new DatePickerUtils(driver);
		dobUtils.setDOB(faker.date().birthday(18, 100));
		
		profileInfo.getOkButton().click();
		profileInfo.getNextButton().click();
	}
}
