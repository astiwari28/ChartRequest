package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminDashboardPage;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;

public class AdminDashboardPageTestCase extends BrowserConfiguration{

	LoginPage loginpage;
	SignUpPage signUpPage;
	AdminDashboardPage adminDashboardPage;
	String url;
	
	@BeforeMethod()
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		loginpage = new LoginPage(); 
		signUpPage = new SignUpPage();
		url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
		adminDashboardPage=new AdminDashboardPage();
	}
	
	@Test(priority = 1, enabled = true)
	private void verifyRequestsProcessedValue() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminDashboardPage.openAdminDashboardPage();
		adminDashboardPage.getRequestsProcessed();
		adminDashboardPage.getPricedAndUnpaidRequests();
		adminDashboardPage.getAverageNewRequestsPerDay();
		adminDashboardPage.get90DayTurnAroundTime();
		adminDashboardPage.get30DayTurnAroundTime();
		adminDashboardPage.get7DayTurnAroundTime();
		adminDashboardPage.get90DayTurnAroundTimeFullService();
		adminDashboardPage.get30DayTurnAroundTimeFullService();
		adminDashboardPage.get7DayTurnAroundTimeFullService();
		adminDashboardPage.getValuefromGraph("Average Request Turnaround Time");
	}
	
	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
