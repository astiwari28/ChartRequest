package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.ReadOTPFromEmailGmail;
import com.ChartRequest.Pages.ReadOTPFromOnlineMobileNumber;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

@Test
public class ReadOTPfromMobileNo extends BrowserConfiguration {

	ReadOTPFromOnlineMobileNumber readOtpFromMobileNumber;
	SignUpPage signUpPage;
	ReadOTPFromEmailGmail readOtpFromEmailGmail;

	public ReadOTPfromMobileNo() {
		super();
	}

	@BeforeMethod
	public void openbrowser() {
		try {
			browserTearUp(GlobalVariables.URL);
			// signUpPage = new SignUpPage();
			readOtpFromMobileNumber = new ReadOTPFromOnlineMobileNumber();
			// signUpPage.openApplicationURL();
			readOtpFromEmailGmail=new ReadOTPFromEmailGmail();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void runGmailCode() {
		//TestUtil.openNewTabWithGmail();
		//readOtpFromEmailGmail.readEmailForOTP("chartrequest.staging@gmail.com", "FullCycle@2020");
		//TestUtil.openNewTabWithURL("https://receive-smss.com/");
		//readOtpFromMobileNumber.readOTPfromMobileNumber();
		/*
		 * TestUtil.hardWait(10); readOtpFromMobileNumber.getOTPNumber();
		 */
		TestUtil.getNextDate();
	}

	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
