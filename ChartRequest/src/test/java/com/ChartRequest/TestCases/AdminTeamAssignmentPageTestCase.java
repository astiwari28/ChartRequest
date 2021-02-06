package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminTeamAssignmentPage;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;

public class AdminTeamAssignmentPageTestCase extends BrowserConfiguration{

	LoginPage loginpage;
	SignUpPage signUpPage;
	AdminTeamAssignmentPage adminTeamAssignmentPage;
	String url;
	
	@BeforeMethod()
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		//browserTearUp(GlobalVariables.preproductionUrl);
		loginpage = new LoginPage();
		signUpPage = new SignUpPage();
		url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
		adminTeamAssignmentPage=new AdminTeamAssignmentPage();
	}
	
	@Test(priority = 1, enabled = true)
	private void adminCreateNewTeam() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminTeamAssignmentPage.openAdminTeamAssigmentPage();
		adminTeamAssignmentPage.createTeamName(false);
		adminTeamAssignmentPage.addAndViewTeamMember();
		adminTeamAssignmentPage.addAndViewCustodian();
	}
	
	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
