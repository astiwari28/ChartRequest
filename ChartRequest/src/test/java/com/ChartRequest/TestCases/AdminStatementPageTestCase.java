package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminStatementOnlyPage;
import com.ChartRequest.Pages.CreateRequest;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SearchMyRequest;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;

public class AdminStatementPageTestCase extends BrowserConfiguration {

	LoginPage loginpage;
	SignUpPage signUpPage;
	AdminStatementOnlyPage adminStatementPage;
	CreateRequest createRequest;
	SearchMyRequest searchMyRequest;
	String url, requestCreated;

	@BeforeMethod()
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		// browserTearUp(GlobalVariables.preproductionUrl);
		loginpage = new LoginPage();
		signUpPage = new SignUpPage();
		url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
		adminStatementPage = new AdminStatementOnlyPage();
		createRequest = new CreateRequest();
		searchMyRequest = new SearchMyRequest();
	}

	@Test(priority = 1, enabled = true)
	private void adminSetToPaid() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminStatementPage.searchPage();
		adminStatementPage.runStatementByCustodianName(GlobalVariables.OrganizationName);
		adminStatementPage.openStatmentPage();
		adminStatementPage.setToPaid("Demo A");
	}

	@Test(priority = 2, enabled = true)
	private void VerifyPaidStatement() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		// adminStatementPage.searchPage();
		adminStatementPage.openStatmentPage();
		adminStatementPage.openPaidUserAndVerify(GlobalVariables.OrganizationName);
	}

	@Test(priority = 3, enabled = true)
	private void VerifyAdvanceSearchRevenueShare() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminStatementPage.openStatmentPage();
		adminStatementPage.openAdvnaceSearch();
		adminStatementPage.advanceSearchByRevenueShare("Yes");
		adminStatementPage.verifyAdvanceSearchResult();
	}

	@Test(priority = 4, enabled = true)
	private void VerifyAdvanceSearchCurrentCommissions() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminStatementPage.openStatmentPage();
		adminStatementPage.openAdvnaceSearch();
		adminStatementPage.advanceSearchByCurrentCommissions("All");
		adminStatementPage.verifyAdvanceSearchResult();
	}

	@Test(priority = 5, enabled = true)
	private void VerifyAdvanceSearchServiceLevel() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminStatementPage.openStatmentPage();
		adminStatementPage.openAdvnaceSearch();
		adminStatementPage.advanceSearchByServiceLevel("Full Service");
		adminStatementPage.verifyAdvanceSearchResult();	
	}

	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
