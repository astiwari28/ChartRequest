package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.HomePage;
import com.ChartRequest.Pages.ReadOTPFromOnlineMobileNumber;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class SignUpPageTestCases extends BrowserConfiguration {

	SignUpPage signUpPage;
	ReadOTPFromOnlineMobileNumber readOtpFromMobileNumber;
	HomePage homePage;
	String mobileNo;

	public SignUpPageTestCases() {
		super();
	}

	@BeforeMethod
	public void openbrowser() {
		browserTearUp(GlobalVariables.localURL);
		signUpPage = new SignUpPage();
		homePage = new HomePage();
		readOtpFromMobileNumber = new ReadOTPFromOnlineMobileNumber();
		String url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
		TestUtil.openNewTabWithURL("https://receive-smss.com/");
		mobileNo = readOtpFromMobileNumber.readOTPfromMobileNumber();
		TestUtil.swtichToTab(0);
	}

	@Test(priority = 1)
	public void signUpAsPatient() {
		String actualEmailId = TestUtil.getAlphaDynamicString(4) + ".test@automation.com";
		signUpPage.signUpApplicationAsPatient("Test", "", "Automation", "Male", "01011991", actualEmailId,
				actualEmailId, "test@123", "test@123", "Automation", "", "US", "AK", "22713", mobileNo);
		String expectedEmailId = homePage.getAccountDetails();
		TestUtil.verifyStrings(actualEmailId, expectedEmailId);

	}

	@Test(priority = 2)
	public void signUpAsRequestor() {
		try {
			String actualEmailId = TestUtil.getAlphaDynamicString(4) + ".test@automation.com";
			signUpPage.signUpApplicationAsRequestor("Test", "", "Automation", actualEmailId, actualEmailId, "test@123",
					"test@123", "test", false, "Law Firm - Defense", "Google", "2222 Hillside Avenue", "",
					"Indianapolis", "IN", "46218", mobileNo, "");
			String expectedEmailId = homePage.getAccountDetails();
			TestUtil.verifyStrings(actualEmailId, expectedEmailId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void signUpAsCustodian() {
		try {
			String actualEmailId = TestUtil.getAlphaDynamicString(4) + ".test@automation.com";
			signUpPage.signUpApplicationAsCustodian("Test", "", "Automation", actualEmailId, actualEmailId, "test@123",
					"test@123", "test", false, "1234567890", "Google", "2222 Hillside Avenue", "", "Indianapolis", "IN",
					"46218", mobileNo, "www.google.com");
			String expectedEmailId = homePage.getAccountDetails();
			TestUtil.verifyStrings(actualEmailId, expectedEmailId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}

}
