package com.ChartRequest.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Utility.TestUtil;

public class ReadOTPFromOnlineMobileNumber extends BrowserConfiguration {


	public ReadOTPFromOnlineMobileNumber() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr[1]//td[5]")
	WebElement OTPText;
	
	@FindBy(xpath = "//a[contains(text(),'Update Messages')]")
	WebElement buttonUpdateMessage;

	public String readOTPfromMobileNumber() {
		String s = null;
		List<WebElement> listOfNumbers = driver.findElements(
				By.xpath("//h5[contains(text(),'United States')]/preceding::a[text()='Open']/preceding::h4"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		for (WebElement ele : listOfNumbers) {
			System.out.println("Name + Number===>" + ele.getText());
			if (ele.getText().startsWith("+1")) {
				s = ele.getText();
				s = s.substring(2);
				System.out.println("Number==>" + s);
				break;
			} else {
				continue;
			}
		}
		driver.findElement(By.xpath("//h4[contains(text(),'" + s + "')]")).click();
		return s;
	}

	public String getOTPNumber() {
		while (!OTPText.getText().contains("ChartRequest")) {
			buttonUpdateMessage.click();
		}
		String s = OTPText.getText();
		Pattern p = Pattern.compile("(?<=code is )\\d+");
		Matcher m = p.matcher(s);
		if (m.find()) {
			System.out.println(m.group());
		}
		return m.group();

	}
}
