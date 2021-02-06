package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Pages.UserRolesAndPermission;
import com.ChartRequest.Utility.GlobalVariables;

public class UserRoleAndPermissionTestCases extends BrowserConfiguration{

	LoginPage loginpage;
	SignUpPage signUpPage;
	UserRolesAndPermission userRolesAndPermission;
	public UserRoleAndPermissionTestCases() {
		super();
	}
	
	@BeforeMethod
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		//browserTearUp(GlobalVariables.preproductionUrl);
		loginpage = new LoginPage();
		signUpPage = new SignUpPage();
		userRolesAndPermission=new UserRolesAndPermission();
		String url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
	}
	
	@Test(priority = 1, enabled = true)
	private void changePermissionAdminToStandard() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			userRolesAndPermission.openAdminUserRoleAndPermissionPage();
			userRolesAndPermission.changeRoleAssignedAdministratorToStandardUser("custodighffgfjjan@gmail.com");
			loginpage.logout();
			loginpage.login("custodighffgfjjan@gmail.com", GlobalVariables.password);
			userRolesAndPermission.verifyChangedUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2, enabled = true)
	private void changePermissionStandardToViewUser() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			userRolesAndPermission.openAdminUserRoleAndPermissionPage();
			userRolesAndPermission.changeRoleAssignedStandardUserToViewOnlyUser("custodighffgfjjan@gmail.com");
			loginpage.logout();
			loginpage.login("custodighffgfjjan@gmail.com", GlobalVariables.password);
			userRolesAndPermission.verifyChangedUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3, enabled = true)
	private void changePermissionViewUserToAdmin() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			userRolesAndPermission.openAdminUserRoleAndPermissionPage();
			userRolesAndPermission.changeRoleAssignedViewOnlyUserToAdministrator("custodighffgfjjan@gmail.com");
			loginpage.logout();
			loginpage.login("custodighffgfjjan@gmail.com", GlobalVariables.password);
			userRolesAndPermission.verifyChangedUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
