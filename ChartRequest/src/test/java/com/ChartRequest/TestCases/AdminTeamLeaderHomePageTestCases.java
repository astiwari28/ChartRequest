package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminTeamAssignmentPage;
import com.ChartRequest.Pages.AdminTeamLeaderHomePage;
import com.ChartRequest.Pages.CreateRequest;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SearchMyRequest;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class AdminTeamLeaderHomePageTestCases extends BrowserConfiguration {

	LoginPage loginpage;
	SignUpPage signUpPage;
	AdminTeamLeaderHomePage adminTeamLeaderHomePage;
	AdminTeamAssignmentPage adminTeamAssignmentPage;
	CreateRequest createRequest;
	SearchMyRequest searchMyRequest;
	String url;

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
		adminTeamLeaderHomePage = new AdminTeamLeaderHomePage();
		adminTeamAssignmentPage = new AdminTeamAssignmentPage();
		createRequest = new CreateRequest();
		searchMyRequest = new SearchMyRequest();
	}

	@Test(priority = 1, enabled = true)
	private void adminSetGoalForTeam() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminTeamLeaderHomePage.openTeamLeaderHomePage();
		String goalNumber = adminTeamLeaderHomePage.addGoal(false, true);
		adminTeamLeaderHomePage.GoalNumber(goalNumber);
	}

	@Test(priority = 2, enabled = true)
	private void adminSetGoalForCSAUser() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminTeamLeaderHomePage.openTeamLeaderHomePage();
		String goalNumber = adminTeamLeaderHomePage.addGoal(true, false);
		adminTeamLeaderHomePage.GoalNumber(goalNumber);
	}

	@Test(priority = 3, enabled = true)
	private void adminOpenAlertCSAUser() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminTeamLeaderHomePage.openTeamLeaderHomePage();
		adminTeamLeaderHomePage.verifyAlertCSA();
	
	}

	@Test(priority = 4, enabled = true)
	private void adminOpenAlertTeam() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminTeamLeaderHomePage.openTeamLeaderHomePage();
		adminTeamLeaderHomePage.verifyAlertTeam();
	}

	@Test(priority = 5, enabled = true)
	private void adminOpenAlertType() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminTeamLeaderHomePage.openTeamLeaderHomePage();
		adminTeamLeaderHomePage.verifyAlertType();
	}

	@Test(priority = 6, enabled = true)
	private void adminCreateAlertCSAUser() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminTeamLeaderHomePage.openTeamLeaderHomePage();
		adminTeamLeaderHomePage.createAlert(true);
	}

	@Test(priority = 7, enabled = true)
	private void adminCreateAlertTeam() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminTeamLeaderHomePage.openTeamLeaderHomePage();
		adminTeamLeaderHomePage.createAlert(false);
	}

	@Test(priority = 8, enabled = true)
	private void NoTeamLeaderPageAccess() {
		loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		adminTeamLeaderHomePage.openTeamLeaderHomePage();
	}

	@Test(priority = 9, enabled = true)
	private void FilterAndSearch() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminTeamLeaderHomePage.openTeamLeaderHomePage();
		adminTeamLeaderHomePage.filterAndSearch();
	}

	@Test(priority = 10, enabled = false)
	private void adminDeleteTeam() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminTeamAssignmentPage.openAdminTeamAssigmentPage();
		adminTeamAssignmentPage.deleteTeam();
	}
	
	@Test(priority = 11, enabled = true)
	public void changeGoalNumber() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		TestUtil.hardWait(5);
		createRequest.openSearchPage();
		TestUtil.hardWait(5);
		adminTeamLeaderHomePage.moveRequestFromProcessingToPriced("Priced", GlobalVariables.OrganizationName);
		createRequest.processingRequest(false);
		adminTeamLeaderHomePage.openTeamLeaderHomePage();
		adminTeamLeaderHomePage.verifyGoalNumberRequestChange();
	}

	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
