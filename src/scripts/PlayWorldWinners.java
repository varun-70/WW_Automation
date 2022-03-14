package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.Generic;

public class PlayWorldWinners extends Generic{
	
	@Test
	public void playWorldWinners() throws InterruptedException, Exception {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Play world winners flow
		elements.getPlayNowButton().click();
		
		for(int i=1;i<=3;i++) {
			if(elements.getNextButton().isDisplayed()) {
				elements.getNextButton().click();
				Thread.sleep(300);
			}
			else
				break;
			
		}
		
		// Adding ticket on the Play world winners screen
		for(int i=1;i<10;i++) {
			if(elements.getPlusButton().isDisplayed()) {
				elements.getPlusButton().click();
				Thread.sleep(300);
			}
			else
				break;
			
		}
		
		int ele = driver.findElementsByXPath("//android.widget.TextView[@text='DELETE']").size();
		System.out.println("Number of \"Delete\" elements present "+ele);
		
		int ele1 = driver.findElementsByXPath("//android.widget.ScrollView[//android.widget.TextView[@text='DELETE']]").size();
		System.out.println("Number of \"Delete\" elements present "+ele1);
		
		int ele2 = driver.findElementsByXPath("//android.widget.ScrollView//child::android.widget.TextView[@text='DELETE']").size();
		System.out.println("Number of \"Delete\" elements present "+ele2);
		
		WebElement parentElement = driver.findElementByXPath("//android.widget.ScrollView");
		int childElement = parentElement.findElements(By.xpath("//android.widget.TextView[@text='DELETE']")).size();
		System.out.println("Number of \"Delete\" elements present "+childElement);
		
		// Swiping down(scroll up) on the Play world winners screen
		for(int i=1; i<=2; i++) {
			function.swipingLocation(2, 2, 3, 6);  // 3 position on x axis and 6 position on y axis
			Thread.sleep(150);   // left to right is x axis, and top to bottom is y axis
		}             			// left most screen is 0 x-axis, and top most screen is 0 y-axis
		
		function.getContinueWithnButton().click();
		elements.getConfirmButton().click();
		elements.getSkipForNowButton().click();
		Thread.sleep(1000);
		
	}

}
