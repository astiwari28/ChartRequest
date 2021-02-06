package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminScheduleManagementPage;
import com.ChartRequest.Pages.AdminTeamAssignmentPage;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;

public class AdminScheduleManagementTestCase extends BrowserConfiguration {

	LoginPage loginpage;
	SignUpPage signUpPage;
	AdminScheduleManagementPage adminScheduleManagementPage;
	String url;
	AdminTeamAssignmentPage adminTeamAssignmentPage;

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
		adminScheduleManagementPage = new AdminScheduleManagementPage();
		adminTeamAssignmentPage=new AdminTeamAssignmentPage();
	}

	@Test(priority = 1, enabled = true)
	private void adminVerifyNewTeamAdded() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminTeamAssignmentPage.openAdminTeamAssigmentPage();
		if (adminTeamAssignmentPage.verifyTeamCreated("Automation Testing")) {
			System.out.println("Team Found");
		}
		else {
			adminScheduleManagementPage.openAdminScheduleManagementPage();
			adminTeamAssignmentPage.createTeamName(true);
			adminTeamAssignmentPage.addAndViewTeamMember();
			adminTeamAssignmentPage.addAndViewCustodian();		
			adminTeamAssignmentPage.verifyTeamCreated("Automation Testing");
		}
		/*loginpage.logout();
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminScheduleManagementPage.openAdminScheduleManagementPage();
		adminScheduleManagementPage.selectTeam("Automation Testing");*/
	}

	@Test(priority = 2, enabled = true)
	public void addAndDeleteShiftTiming() {
		if (url.contains("preproduction")) {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminScheduleManagementPage.openAdminScheduleManagementPage();
			adminScheduleManagementPage.selectTeam("Automation Testing");
			adminScheduleManagementPage.addShift("Custodian Automation");
		} else {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminScheduleManagementPage.openAdminScheduleManagementPage();
			adminScheduleManagementPage.selectTeam("Automation Testing");
			//adminScheduleManagementPage.addShift("Custodian Automation");
			adminScheduleManagementPage.addShift("admin admin alert");
		}
	}
	
	
	@Test(priority = 3, enabled = true)
	public void changeTime() {
		if (url.contains("preproduction")) {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminScheduleManagementPage.openAdminScheduleManagementPage();
			adminScheduleManagementPage.selectTeam("Automation Testing");
			adminScheduleManagementPage.addShift("Custodian Automation");
			adminScheduleManagementPage.changeShiftTime("Custodian");
		} else {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminScheduleManagementPage.openAdminScheduleManagementPage();
			adminScheduleManagementPage.selectTeam("Automation Testing");
			adminScheduleManagementPage.changeShiftTime("Custodian");
		}
	}

	@Test(priority = 4, enabled = true)
	public void changeTimeZone() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminScheduleManagementPage.openAdminScheduleManagementPage();
		adminScheduleManagementPage.selectTeam("Automation Testing");
		adminScheduleManagementPage.changeTimeZone();
	}
	
	@Test(priority = 5, enabled = true)
	private void adminDeleteTeam() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminTeamAssignmentPage.openAdminTeamAssigmentPage();
		adminTeamAssignmentPage.deleteTeam();
	}


	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
