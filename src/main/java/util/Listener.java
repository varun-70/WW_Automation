package util;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.Base;
import io.appium.java_client.appmanagement.ApplicationState;

public class Listener extends Base implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed test case");
		ScreenCaptureUtils.screenShot();
		
		ApplicationState appState = driver.queryAppState(appId);
		String appStateInString = String.valueOf(appState);
		
		if(appStateInString == "RUNNING_IN_FOREGROUND") {
			System.out.println("Running in foreground");
			driver.closeApp();
			driver.launchApp();
		}
		
		else if (appStateInString == "NOT_RUNNING") {
			System.out.println("Not running");
			driver.launchApp();
		}
		
		else if (appStateInString == "RUNNING_IN_BACKGROUND") {
			System.out.println("Running in background");
			driver.closeApp();
			driver.launchApp();
		}

	}
	
	@Override
	public void onTestSuccess(ITestResult result) {

	}
}
