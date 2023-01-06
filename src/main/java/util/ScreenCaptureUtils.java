package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import base.Base;
import io.appium.java_client.screenrecording.BaseStartScreenRecordingOptions;

public class ScreenCaptureUtils extends Base{
	static int name = 0;

	public static void screenShot() {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("src/main/java/Resources/Screenshot" + name + ".jpg"));
			name++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void startScreenRecording() {
		driver.startRecordingScreen();
	}
	
	public static void stopScreenRecording() {
//		String video = driver.stopRecordingScreen();
//		byte[] decode = Base64.decodeBase64(video);
//		
//		File fileName = new File("src/main/java/Resources/VideoRecording_test.mp4");
//		Files.write(decode, fileName);

	}
}
