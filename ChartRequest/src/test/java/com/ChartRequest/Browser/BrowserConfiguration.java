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
		//WebDriverManager.chromedriver().setup();
		/*ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-geolocation");*/
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/test/resources/DriversExe/chromedriver_binary");
		driver = new ChromeDriver();
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
