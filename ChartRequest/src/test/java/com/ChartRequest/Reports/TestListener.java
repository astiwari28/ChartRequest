package com.ChartRequest.Reports;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Utility.TestUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class TestListener extends BrowserConfiguration implements ITestListener {

	private static ExtentReports extentReports = ExtentManager.getInstance();
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		if (extentReports != null) {
			extentReports.flush();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extentReports
				.createTest(result.getInstanceName() + " :: " + result.getMethod().getMethodName());
		extentTest.set(test);
		System.out.println("Method Name: "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Successful</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, markup);
		WebDriver driver = BrowserConfiguration.driver;
		String path = takeScreenshot(driver, result.getMethod().getMethodName());
		try {
			extentTest.get().pass("<b><font color=Green>" + "Screenshot of Pass" + "</font><b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (Exception e) {
			extentTest.get().pass("Test Pass, cannot attach screenshot");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		extentTest.get().fail("<details><summary><b><font color=red>" + "Exception Occured, click to see details:"
				+ "</fonts></b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");
		WebDriver driver = BrowserConfiguration.driver;
		String path = takeScreenshot(driver, result.getMethod().getMethodName());
		try {
			extentTest.get().fail("<b><font color=red>" + "Screenshot of failure" + "</font><b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (Exception e) {
			extentTest.get().fail("Test failed, cannot attach screenshot");
		}
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Failed</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, markup);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String logText = "<b>Test Method " + result.getMethod().getMethodName() + " Skipped</b>";
		Markup markup = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP, markup);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public static void infoMessage(String message) {
		Markup markup = MarkupHelper.createLabel(message, ExtentColor.BLUE);
		extentTest.get().log(Status.INFO, markup);
	}

	public static void infoMessageFail(String message) {
		Markup markup = MarkupHelper.createLabel(message, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, markup);
	}

	private static String takeScreenshot(WebDriver driver, String methodName) {

		/*String fileName = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/screenshots/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		try {
			ImageIO.write(screenshot.getImage(), "PNG", new File(path));
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		String fileName = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/screenshots/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		try {
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(path));
			System.out.println("***************************************");
			System.out.println("Screenshot Stored at " + path);
			System.out.println("***************************************");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}

	public static String getScreenshotName(String methodName) {
		Date d = new Date();
		String fileName = methodName + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		return fileName;
	}
	
	public static void addDynamicScreenshotInReport(String screenShotName) {
		WebDriver driver = BrowserConfiguration.driver;
		String path = takeScreenshot(driver, screenShotName);
		try {
			extentTest.get().info("<b><font color=red>" + "Screenshot Taken" + "</font><b>",
					MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (Exception e) {
			extentTest.get().fail("Test failed, cannot attach screenshot");
			
		}
	}

}