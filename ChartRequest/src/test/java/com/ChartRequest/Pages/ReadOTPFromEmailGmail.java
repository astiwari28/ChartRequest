package com.ChartRequest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Utility.TestUtil;

public class ReadOTPFromEmailGmail extends BrowserConfiguration {
	
	public ReadOTPFromEmailGmail() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Sign in']")
	WebElement SignInLabel;
	
	@FindBy(id  = "identifierId")
	WebElement emailIdInput;

	@FindBy(xpath = "//*[@id='password']/div/div/div/input")
	WebElement passwordInput;

	@FindBy(xpath = "//div[@class='VfPpkd-RLmnJb']")
	WebElement nextButton;

	@FindBy(xpath = "//*[@id='forgotPassword']/div/button")
	WebElement forgetPassword;
	
	@FindBy(xpath="//a[text()='Inbox']")
	WebElement inboxLabel;

	public void readEmailForOTP(String emailUserName, String emailPassword) {
		System.out.println("Email is: "+emailUserName);
		emailIdInput.click();
		emailIdInput.sendKeys(emailUserName);
		//emailIdInput.sendKeys(Keys.TAB);
		TestUtil.MouseOverToElement(nextButton);
		nextButton.click();
		WebDriverWait wait = new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='forgotPassword']/div/button")));
		System.out.println("Password is: "+emailPassword);
		passwordInput.sendKeys(emailPassword);
		nextButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Inbox']")));

	}
}
