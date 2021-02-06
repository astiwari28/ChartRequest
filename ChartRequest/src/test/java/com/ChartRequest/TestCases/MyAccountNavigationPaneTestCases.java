package com.ChartRequest.TestCases;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.HomePage;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SearchMyRequest;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class MyAccountNavigationPaneTestCases extends BrowserConfiguration {

	LoginPage loginpage;
	SignUpPage signUpPage;
	HomePage homePage;
	SearchMyRequest searchMyRequest;
	String newEmailId;

	@BeforeMethod()
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		//browserTearUp(GlobalVariables.preproductionUrl);
		loginpage = new LoginPage();
		signUpPage = new SignUpPage();
		String url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
		homePage=new HomePage();
		searchMyRequest=new SearchMyRequest();
	}

	@Test(priority = 1,enabled = true)
	public void changeOrganizationName() {
		loginpage.login(GlobalVariables.emailID, GlobalVariables.password);
		searchMyRequest.getLastPage();
		homePage.openMyAccountTab();
		homePage.clickEditButtonMyAccountTab();
		homePage.changeName("Patient", "", "");
	}
	
	@Test(priority = 2, enabled = false)
	public void changedEmailID() {
		loginpage.login(GlobalVariables.emailID, GlobalVariables.password);
		homePage.openMyAccountTab();
		homePage.clickEditButtonMyAccountTab();
		newEmailId=homePage.changeEmailId("patient.test@gmail.com");
		loginpage.logout();
		loginpage.login(newEmailId, GlobalVariables.password);
	}
	
	@Test(priority = 3, enabled = false)
	public void changedPassword() {
		loginpage.login(GlobalVariables.emailID, GlobalVariables.password);
		homePage.openMyAccountTab();
		homePage.clickEditButtonMyAccountTab();
		homePage.changePassword("Mangla@2807", "Test@1234", "Test@1234");
		loginpage.logout();
		loginpage.login(GlobalVariables.emailID, "Test@1234");
	}
	
	@Test(priority = 4, enabled = true)
	public void addFavoriteCustodians() {
		loginpage.login(GlobalVariables.emailID, GlobalVariables.password);
		homePage.openMyAccountTab();
		homePage.clickEditButtonMyAccountTab();
		List<String> listName=Arrays.asList("456 - IN");
		homePage.enterFavoriteProvider(listName);
	}
	
	@Test(priority = 5, enabled = true)
	public void changeDateofBirth() {
		loginpage.login(GlobalVariables.emailID, GlobalVariables.password);
		homePage.openMyAccountTab();
		homePage.clickEditButtonMyAccountTab();
		homePage.enterNewDateOfBirth("07281991");
	}
	
	@Test(priority = 6, enabled = true)
	public void addNewUser() {
		loginpage.login(GlobalVariables.emailID, GlobalVariables.password);
		homePage.clicknavigationTabMyOrganization();
		homePage.addInviteYourColleagues("Automation", "Testing", TestUtil.getAlphaDynamicString(5)+"@amail.com", "1234567890", "01011991", "Automation", "Testing");
	}
	
	@Test(priority = 7, enabled = true)
	public void addNewCreditCard() {
		loginpage.login(GlobalVariables.emailID, GlobalVariables.password);
		homePage.clicknavigationTabMyOrganization();
		homePage.addAndDeleteNewCreditCard("6011111111111117", "420", "12", "2035");
	}
	
	@Test(priority = 8, enabled = true)
	public void changeOrganizationDetails() {
		loginpage.login(GlobalVariables.requestorEmailStaging, GlobalVariables.password);
		homePage.clicknavigationTabMyOrganization();
		homePage.changeOrganizationNameAddress1CityStateZipCodePhone("Test", "2222 Hillside Avenue", "Indianapolis", "IN","46218");
	}
	
	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
