package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminEnterpriseResourcePage;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class AdminEnterpriseResourcesTestCases extends BrowserConfiguration{

	LoginPage loginpage;
	SignUpPage signUpPage;
	AdminEnterpriseResourcePage adminEnterpriseResourcePage;
	String url,newURL;
	
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
		adminEnterpriseResourcePage=new AdminEnterpriseResourcePage();
	}
	
	@Test(priority = 1, enabled = true)
	private void adminCreateNewLandingURL() {
		if (url.contains("preproduction")) {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
			adminEnterpriseResourcePage.createNewLandingPageURL("Expressive");
			adminEnterpriseResourcePage.verifyNewLandingUrl(url, "Automation");
		
		} else {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
			adminEnterpriseResourcePage.createNewLandingPageURL("Expressive");
			adminEnterpriseResourcePage.verifyNewLandingUrl(url, "Automation");
		
		}
	}
	
	@Test(priority = 2, enabled = true,dependsOnMethods ="adminCreateNewLandingURL")
	private void changeLandingURLAgain() {
		if (url.contains("preproduction")) {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
			adminEnterpriseResourcePage.changeMultiLocationLandingPageURL();
			adminEnterpriseResourcePage.verifyNewLandingUrl(url, "AutomationTesting");	
		} else {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
			adminEnterpriseResourcePage.changeMultiLocationLandingPageURL();
			adminEnterpriseResourcePage.verifyNewLandingUrl(url, "AutomationTesting");
		}
	}
	
	@Test(priority = 3, enabled = true, dependsOnMethods = "changeLandingURLAgain")
	private void addCustodianRemoveCustodianAndDeleteLandingPageURL() {
		if (url.contains("preproduction")) {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
			adminEnterpriseResourcePage.addCustodianInLandingPage();
			adminEnterpriseResourcePage.removeCustodian();
			adminEnterpriseResourcePage.deletePageURL();
		
		} else {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
			adminEnterpriseResourcePage.addCustodianInLandingPage();
			adminEnterpriseResourcePage.removeCustodian();
			adminEnterpriseResourcePage.deletePageURL();
		}
	}
	
	@Test(priority = 4, enabled = true)
	private void adminEnterprisAddNewAdmin() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
		boolean flag=adminEnterpriseResourcePage.enterprisesAdminTab();
		if (flag) {
			adminEnterpriseResourcePage.verifyNewEnterpriseAdminAdd();
		}
		TestUtil.hardWait(5);
		adminEnterpriseResourcePage.editAdminEnterprise(true);
		adminEnterpriseResourcePage.deleteNewlyAddedEnterpriseAdmin();
	}
	
	@Test(priority = 5, enabled = true)
	private void adminEnterprisSSOPermission() {
		if (url.contains("preproduction")) {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
			adminEnterpriseResourcePage.addUserSSOPermission();
			adminEnterpriseResourcePage.removeUserSSOPermission();
		} else {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
			adminEnterpriseResourcePage.addUserSSOPermission();
			adminEnterpriseResourcePage.removeUserSSOPermission();
		}
	}
	
	@Test(priority = 6, enabled = true)
	private void adminEnterprise() {
		if (url.contains("preproduction")) {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
			//adminEnterpriseResourcePage.EnterprisesPresent();
			adminEnterpriseResourcePage.addCreateEnterprise("Custodian","Retrieval");
			adminEnterpriseResourcePage.addOrganizationEnterprise();
			adminEnterpriseResourcePage.removeOrganizationEnterprise();
			adminEnterpriseResourcePage.removeEnterpriseAdd();			
		} else {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
			//adminEnterpriseResourcePage.EnterprisesPresent();
			adminEnterpriseResourcePage.addCreateEnterprise("Custodian","Retrieval");
			adminEnterpriseResourcePage.addOrganizationEnterprise();
			adminEnterpriseResourcePage.removeOrganizationEnterprise();
			adminEnterpriseResourcePage.removeEnterpriseAdd();
		}
	}
	
	@Test(priority = 7, enabled = true)
	private void createRoute() {
		if (url.contains("preproduction")) {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
			adminEnterpriseResourcePage.createRoute("American Health Imaging","American Health Imaging (Florida)");
		} else {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
			adminEnterpriseResourcePage.createRoute("American Health Imaging","American Health Imaging (Florida)");
		}
	}	
	
	@Test(priority = 8, enabled = true)
	public void verifyCreateRoute() {
		if (url.contains("preproduction")) {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
			//adminEnterpriseResourcePage.createRoute("American Health Imaging","American Health Imaging (Florida)");
			adminEnterpriseResourcePage.verifyRoute();
		} else {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
			//adminEnterpriseResourcePage.createRoute("American Health Imaging","American Health Imaging (Florida)");
			adminEnterpriseResourcePage.verifyRoute();
		}
	}
	
	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
