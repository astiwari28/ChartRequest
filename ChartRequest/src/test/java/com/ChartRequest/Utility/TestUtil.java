package com.ChartRequest.Utility;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ChartRequest.Browser.BrowserConfiguration;

public class TestUtil extends BrowserConfiguration {

	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 20;
	public static long EXPLICIT_WAIT = 20;

	public static void screenshot() throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filename = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss'.png'").format(new Date());
		String currentDir = System.getProperty("user.dir");
		File Destination = new File(currentDir + "/screenshots/" + filename);
		org.apache.commons.io.FileUtils.copyFile(source, Destination);
		System.out.println("ScreenShot taken");
	}

	public static void scrollToElement(String textTobeFound) {
		WebElement element = driver.findElement(By.linkText(textTobeFound));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
	}

	public static void MouseOverToElement(WebElement elemetToBeMouseOver) {
		Actions actions = new Actions(driver);
		actions.moveToElement(elemetToBeMouseOver).perform();

	}

	public static void scrollToElement(WebElement textTobeFound) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", textTobeFound);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author ashutosh
	 * @Description It Will Swtich between the Frames
	 * @since August 17 2020
	 */
	public static void swtichFrame() {
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Size of Frame is: " + size);
		driver.switchTo().frame(1);
	}

	/**
	 * @author ashutosh
	 * @Description It Will Swtich to Default/First Frames
	 * @since August 17 2020
	 */

	public static void swtichToDefaultFrame() {
		driver.switchTo().defaultContent();
	}

	public static void swtichToTab(int tabNo) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabNo));
	}

	/**
	 * @author ashutosh
	 * @Description It Will open New Tab with URL
	 * @since August 17 2020
	 */
	public static void openNewTabWithGmail() {
		try {
			((JavascriptExecutor) driver).executeScript("window.open('https://accounts.google.com/signin')");
			swtichTab(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void openNewTabWithURL(String URL) {
		try {
			((JavascriptExecutor) driver).executeScript("window.open('" + URL + "')");
			swtichTab(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void hardWait(int timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static String dateString() {
		String filename = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
		return filename;
	}

	public static String dateTimeString() {
		String filename = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		return filename;
	}

	public static void swtichTab(int swtichTabNo) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("No of Tabs Open: " + tabs.size());
		driver.switchTo().window(tabs.get(swtichTabNo));
	}

	public static String getAlphaDynamicString(int n) {
		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());
			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	public static boolean verifyStrings(String actualValue, String expectedValue) {
		Boolean flag = false;
		if (actualValue.equalsIgnoreCase(expectedValue)) {
			System.out.println("String Matched");
			flag = true;
		} else {
			System.out.println("String Not-Matched");
			flag = false;
		}
		return flag;
	}

	public static boolean isElementDisplayed(WebElement ele) {
		boolean elementDisplayed = false;
		try {
			ele.isDisplayed();
			elementDisplayed = true;
		} catch (Exception e) {
			elementDisplayed = false;
		}
		return elementDisplayed;
	}

	public static void closeCurrentTab() {
		driver.close();
		swtichTab(0);
	}

	public static String getOnlyNumberFromString(WebElement string) {
		String s = string.getText();
		Pattern p = Pattern.compile("(?<=Req. #)\\d+");
		Matcher m = p.matcher(s);
		if (m.find()) {
			System.out.println(m.group());
		}
		return m.group();
	}
	
	public static String getOnlyNumberFromString(WebElement string, String pattern) {
		String s = string.getText();
		Pattern p = Pattern.compile("(?<="+pattern+"#)\\d+");
		Matcher m = p.matcher(s);
		if (m.find()) {
			System.out.println(m.group());
		}
		return m.group();
	}

	public static String getOnlyNumberFromStringAdminPage(WebElement webElemnet) {
		String s = webElemnet.getText();
		Pattern p = Pattern.compile("(?<=Custodian #)\\d+");
		Matcher m = p.matcher(s);
		if (m.find()) {
			System.out.println(m.group());
		}
		return m.group();
	}

	public static String getOnlyNumberFromStringAdminPageGetRquestorNumber(WebElement webElemnet) {
		String s = webElemnet.getText();
		Pattern p = Pattern.compile("(?<=Admin → Requestor #)\\d+");
		Matcher m = p.matcher(s);
		if (m.find()) {
			System.out.println(m.group());
		}
		return m.group();
	}

	public static StringBuffer getOnlyNumberFromStringWithOutPattern(String str) {
		StringBuffer alpha = new StringBuffer(), num = new StringBuffer(), special = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i)))
				num.append(str.charAt(i));
			else if (Character.isAlphabetic(str.charAt(i)))
				alpha.append(str.charAt(i));
			else
				special.append(str.charAt(i));
		}

		/*
		 * System.out.println(alpha); /System.out.println(num);
		 * System.out.println(special);
		 */
		return num;
	}

	public static String getRandomNumericString(int n) {
		// chose a Character random from this String
		String AlphaNumericString = "1234567890";
		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());
			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	public static boolean isClickable(WebElement webe) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(webe));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String getNextDate() {
		String s;
		 Date date;
		 Format formatter;
		Calendar calendar = Calendar.getInstance();

	 date = calendar.getTime();
	 formatter = new SimpleDateFormat("MM/dd/yyyy");
	 s = formatter.format(date);
	 System.out.println("Today : " + s);

	 calendar.add(Calendar.DATE, 1);
	 date = calendar.getTime();
	 formatter = new SimpleDateFormat("MM/dd/yyyy");
	 s = formatter.format(date);
	 System.out.println("Tomorrow : " + s);
	return s;
	 }	
}
