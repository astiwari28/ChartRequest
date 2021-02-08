package com.ChartRequest.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminRetrievalDashboardPage;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;

public class AdminRetrievalDashboardTestCases extends BrowserConfiguration{

	LoginPage loginpage;
	SignUpPage signUpPage;
	AdminRetrievalDashboardPage adminRetrievalDashboardPage;

	
	String url;
	
	@BeforeMethod()
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		loginpage = new LoginPage();
		signUpPage=new SignUpPage();
		adminRetrievalDashboardPage=new AdminRetrievalDashboardPage();
		url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
		
	}
	
	@Test(priority = 1, enabled = true)
	private void adminRetrievalDashboardNewTab() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminRetrievalDashboardPage.openAdminRetrievalDashboardPage();
			adminRetrievalDashboardPage.startRetrievalOnNewTab();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2, enabled = true)
	private void adminRetrievalDashboardFollowUpTab() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminRetrievalDashboardPage.openAdminRetrievalDashboardPage();
			adminRetrievalDashboardPage.startRetrievalOnFollowTab();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3, enabled = true)
	private void adminRetrievalDashboardQATab() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminRetrievalDashboardPage.openAdminRetrievalDashboardPage();
			adminRetrievalDashboardPage.startRetrievalOnQATab();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 4, enabled = true)
	private void adminRetrievalDashboardNewTabToolTip() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminRetrievalDashboardPage.openAdminRetrievalDashboardPage();
			adminRetrievalDashboardPage.verifyNewTabToolTip();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 5, enabled = true)
	private void adminRetrievalDashboardFollowUpTabToolTip() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminRetrievalDashboardPage.openAdminRetrievalDashboardPage();
			adminRetrievalDashboardPage.verifyFollowUpTabToolTip();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 6, enabled = true)
	private void adminRetrievalDashboardQATabToolTip() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminRetrievalDashboardPage.openAdminRetrievalDashboardPage();
			adminRetrievalDashboardPage.verifyQATabToolTip();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
