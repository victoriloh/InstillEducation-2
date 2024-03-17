package base;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class UtilityTests extends BaseTests{
	
	public static boolean isAlertPresents() {
		try {
			driver.switchTo().alert();
			return true;
		} 
		catch (Exception e) {
			return false;
		}
	}
	
	public static String CheckBrowser() {
		// Get Browser name and version.
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getBrowserVersion();

		// return browser name and version.
		String os = browserName + " " + browserVersion;

		return os;
	}
	
	public static String addScreenshot() {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File scrFile = ts.getScreenshotAs(OutputType.FILE);

		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader = new FileInputStream(scrFile);
			byte[] bytes = new byte[(int) scrFile.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "data:image/png;base64," + encodedBase64;
	}
	
	public static void testTitle(String phrase) {
		String word = "<b>"+phrase+"</b>";
        Markup w = MarkupHelper.createLabel(word, ExtentColor.BLUE);
        testInfo.get().info(w);
	}
	
	/**
	 * @return number
	 * @description to generate a 11 digit number.
	 */
	public static String generatePhoneNumber() {

		long y = (long) (Math.random() * 100000 + 0333330000L);
		String Surfix = "080";
		String num = Long.toString(y);
		String number = Surfix + num;
		return number;

	}
	
	/**
	 * @return number
	 * @description to generate a 3 digit number.
	 */
	public static String generateRandomNumbers() {

		long y = (long) (Math.random() * 1000 + 03L);
		String num = Long.toString(y);
		return num;

	}
	
	/**
	 * Generates unique string of specified length from the English alphabets
	 * @param length
	 * @return
	 */
	public static String uniqueString(int length) {
		Random rand = new Random();
		StringBuilder result = new StringBuilder();
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		char[] alpha2 = alpha.toCharArray();

		for (int i = 1; i <= length; i++) {

			Integer xcv = rand.nextInt(26);
			result.append(alpha2[xcv]);
		}

		return result.toString();
	}
}
