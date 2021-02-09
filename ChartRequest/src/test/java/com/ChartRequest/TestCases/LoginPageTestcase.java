package com.ChartRequest.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTestcase extends BrowserConfiguration {

	LoginPage loginpage;
	SignUpPage signUpPage;
	String url;

	public LoginPageTestcase() {
		super();
	}

	@BeforeMethod
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		//browserTearUp(GlobalVariables.preproductionUrl);
		loginpage = new LoginPage();
		signUpPage = new SignUpPage();
		String url = driver.getCurrentUrl();
		/*if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}*/
	}

	@Test
	public void verifyTitle() {
		String title = loginpage.verifyTitle();
		TestListener.infoMessage("Verify The Title " + title);
		System.out.println("1");
		Assert.assertEquals(title,
				"Medical Records Request - HIPAA Compliant Release of Information Software | ChartRequest");
	}

	@Test(priority = 1,enabled = true)
	public void loginWhenEmailIdAndPasswordGiven() {
		try {
			TestListener.infoMessage("Login With Valid Credinatls");
			System.out.println("2");
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			TestListener.infoMessage("User Loggin With :"+GlobalVariables.patientEmailStaging);
			try {
				TestUtil.screenshot();
			} catch (IOException e) {
				e.printStackTrace();
			}
			loginpage.logout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2,enabled = true)
	public void loginWhenInValidEmailID() {
		TestListener.infoMessage("Login With Wrong Email Id and Valid password");
		System.out.println("3");
		loginpage.login(properties.getProperty("emailidWrong"), properties.getProperty("password"));
		TestListener.infoMessage("User Enter The Email Id: "+properties.getProperty("emailidWrong")+" and password: "+properties.getProperty("password"));
		try {
			TestUtil.screenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3,enabled = true)
	public void loginWhenInValidPassword() {
		TestListener.infoMessage("Login With Valid Email Id and Wrong password");
		System.out.println("4");
		loginpage.login(properties.getProperty("emailid"), properties.getProperty("passwordWrong"));
		TestListener.infoMessage("User Enter The Email Id: "+properties.getProperty("emailid")+" and password: "+properties.getProperty("passwordWrong"));
		try {
			TestUtil.screenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4,enabled = true)
	public void loginWhenEmailIDandPasswordInValid() {
		TestListener.infoMessage("Login With Wrong Email Id and Wrong password");
		System.out.println("5");
		loginpage.login(properties.getProperty("emailidWrong"), properties.getProperty("passwordWrong"));
		TestListener.infoMessage("User Enter The Email Id: "+properties.getProperty("emailidWrong")+" and password: "+properties.getProperty("passwordWrong"));
		try {
			TestUtil.screenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5,enabled = true)
	public void loginBlankEmailWhenOnlyPassword() {
		TestListener.infoMessage("Login With Blank Email Id and Valid password");
		System.out.println("6");
		loginpage.login("", properties.getProperty("password"));
		TestListener.infoMessage("User Enter The Email Id: "+" "+" and password: "+properties.getProperty("password"));
		try {
			TestUtil.screenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 6,enabled = true)
	public void loginWhenOnlyEmailId() {
		TestListener.infoMessage("Login With Valid Email Id and Blank password");
		System.out.println("7");
		loginpage.loginWithoutUserNameandPassword(properties.getProperty("emailid"), "");
		TestListener.infoMessage("User Enter The Email Id: "+properties.getProperty("emailid")+" and password: "+" ");
		try {
			TestUtil.screenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 7,enabled = true)
	public void loginWhenNoEmailNoPassword() {
		TestListener.infoMessage("Login With Blank Email Id and Blank password");
		System.out.println("8");
		loginpage.loginWithoutUserNameandPassword("", "");
		TestListener.infoMessage("User Enter The Email Id: "+" "+" and password: "+" ");
		try {
			TestUtil.screenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 8, enabled = true)
	public void loginWithGmail() {
		/*TestListener.infoMessage("Login With Google Account");
		System.out.println("9");
		loginpage.loginWithGoogle();*/
	}

	@Test(priority = 9,enabled = true)
	public void signUpButtonOnLoginPage() {
		TestListener.infoMessage("Click on Singup Link Present on Login Page");
		System.out.println("10");
		loginpage.loginButton();
		loginpage.signUpOnLogin();
	}

	@Test(priority = 10,enabled = true)
	public void GethelpaccessingyouraccountOnLoginPage() {
		TestListener.infoMessage("Click on Get help accessing your account Link");
		System.out.println("11");
		loginpage.GetHelpAccessingYourAccount();

	}

	@Test(priority = 11,enabled = true)
	public void ForgotPasswordOnLoginPage() {
		TestListener.infoMessage("Verify The Forget Password");
		System.out.println("12");
		loginpage.ForgotPassword(GlobalVariables.forgotPasswordEmailId);
	}

	@Test(priority = 12,enabled = true)
	public void RemeberMeOnLoginPage() {
		TestListener.infoMessage("Verify The Remeber Me Checkbox");
		System.out.println("13");
		loginpage.loginRememberMe(properties.getProperty("emailid"), properties.getProperty("password"));
	}

	@Test(priority = 13,enabled = false)
	public void loginWithSSO() {
		TestListener.infoMessage("Login in SSO Credinatals");
		System.out.println("14");
		loginpage.loginUsingSSO("admin@chartrequest.com", "ashutosh.tiwari@full-cycle.com", "Mangla@2807");
	}

	@Test(priority = 14,enabled = true)
	public void ForgotPasswordWrongEmailOnLoginPage() {
		TestListener.infoMessage("Verify Forgot Password with invalid Email");
		System.out.println("15");
		loginpage.ForgotPasswordWrongEmail("abc@abc.com");
		TestListener.infoMessage("Email id is abc@abc.com");

	}

	@Test(priority = 15,enabled = true)
	public void homeButtonOnLoginPage() {
		TestListener.infoMessage("Verify the Home Page Link present on Login Page");
		System.out.println("16");
		// loginpage.loginButton();
		loginpage.homeOnLogin();
	}

	@Test(priority = 16,enabled = true)
	public void aboutButtonOnLoginPage() {
		TestListener.infoMessage("Verify the About Page Link present on Login Page");
		System.out.println("17");
		// loginpage.loginButton();
		loginpage.aboutOnLogin();
	}

	@Test(priority = 17,enabled = true)
	public void benefitsButtonOnLoginPage() {
		TestListener.infoMessage("Verify the Benfeits Page Link present on  Page");
		System.out.println("18");
		// loginpage.loginButton();
		loginpage.benefitOnLogin();
	}

	@Test(priority = 18,enabled = true)
	public void requestDemoOnLoginPage() {
		TestListener.infoMessage("Verify the Request Demo Page Link present on Login Page");
		System.out.println("19");
		// loginpage.loginButton();
		loginpage.requestADemoOnLogin();
	}

	@Test(priority = 19,enabled = true)
	public void FAQOnLoginPage() {
		TestListener.infoMessage("Verify the FAQ Page Link present on Login Page");
		System.out.println("20");
		// loginpage.loginButton();
		loginpage.FQAOnLogin();
	}

	@Test(priority = 20,enabled = false)
	public void RequestStatus() {
		TestListener.infoMessage("Verify the Request Status Page Link present on Login Page With valid Request ID");
		System.out.println("21");
		loginpage.requestStatus("25996");
		TestListener.infoMessage("Request Id is :25996");
	}

	@Test(priority = 21,enabled = false)
	public void RequestStatusWithInvalidRequestID() {
		TestListener.infoMessage("Verify the Request Status Page Link present on Login Page With invalid Request ID");
		System.out.println("22");
		loginpage.requestStatusWithErrorMessage("000");
		TestListener.infoMessage("Invalid request id is 000");
	}

	@Test(priority = 22,enabled = false)
	public void RequestStatusWithAlphabeticRequestID() {
		TestListener.infoMessage("Verify the Request Status Page Link present on Login Page With invalid Request ID having alphabets only");
		System.out.println("23");
		loginpage.requestStatusWithErrorMessage("ABC");
		TestListener.infoMessage("Invalid request id  having alphabets is ABC");

	}

	@Test(priority = 23,enabled = false)
    public void RequestStatusWithAplhaNumericRequestID() {
        TestListener.infoMessage("Verify the Request Status Page Link present on Login Page With invalid Request ID having alphanumeric only");
        System.out.println("24");
        loginpage.requestStatusWithErrorMessage("ABC000");
		TestListener.infoMessage("Invalid request id  having alphanumeric char is ABC000");

    }

	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
