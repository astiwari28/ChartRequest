/*author :- Ashutosh*/

package com.ChartRequest.Browser;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserConfiguration {

	public static WebDriver driver;
	public Properties properties;
	
	public BrowserConfiguration() {
		properties = new Properties();

		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/ChartRequest/Confriguration/config.properties");
			properties.load(fis);
		} catch (Exception e) {
			System.out.println("File Not Found");
		}
	}

	public void browserTearUp(String URL) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
		options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
		options.addArguments("--headless"); // only if you are ACTUALLY running headless
		options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
		options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
		options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
		options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
		options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
		driver = new ChromeDriver(options);
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/test/resources/DriversExe/chromedriver_binary");
		driver = new ChromeDriver(options);
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(URL);
		System.out.println("URL :- "+URL);
		//TestListener.infoMessage("URL :- "+URL);
	}
	
	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
