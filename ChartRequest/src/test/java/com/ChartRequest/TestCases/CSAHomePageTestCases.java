package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminCSAHomePage;
import com.ChartRequest.Pages.AdminEnterpriseResourcePage;
import com.ChartRequest.Pages.ClinicalReviewerRequestAssignment;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class CSAHomePageTestCases extends BrowserConfiguration{

	LoginPage loginpage;
	SignUpPage signUpPage;
	AdminCSAHomePage adminCSAHomePage;
	AdminEnterpriseResourcePage adminEnterpriseResourcePage;
	ClinicalReviewerRequestAssignment clinicalReviewerRequestAssignment;
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
		adminCSAHomePage=new AdminCSAHomePage();
		adminEnterpriseResourcePage=new AdminEnterpriseResourcePage();
		clinicalReviewerRequestAssignment =new ClinicalReviewerRequestAssignment();
	}
	
	@Test(priority = 1, enabled = true)
	private void csaHomePageRequestorSignUpInstructions() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminCSAHomePage.openCSAHomePage();
			adminCSAHomePage.emailRequestorSingupInstructions(GlobalVariables.OrganizationName,"abc@abc.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2, enabled = true)
	private void csaHomePageSendFaxBack() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminCSAHomePage.openCSAHomePage();
			adminCSAHomePage.sendFaxBack(GlobalVariables.OrganizationName,"1234567890","Automation Test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3, enabled = true)
	private void csaHomePageCheckNumber() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminCSAHomePage.openCSAHomePage();
			adminCSAHomePage.searchByCheckByNumber("1234567890");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 4, enabled = true)
	private void csaHomePageInviteCustodianColleagues() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminCSAHomePage.openCSAHomePage();
			adminCSAHomePage.InviteCustodianColleagues(GlobalVariables.OrganizationName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 5, enabled = true)
	private void csaHomePageInviteRequestorColleagues() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminCSAHomePage.openCSAHomePage();
			adminCSAHomePage.InviteRequestorColleagues("Automation");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(priority = 6, enabled = true)
	private void csaHomePageAssignMe() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminCSAHomePage.openCSAHomePage();
			adminCSAHomePage.AssignToMe();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 7, enabled = true)
	private void csaHomePageAssignMeRequests() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminCSAHomePage.openCSAHomePage();
			adminCSAHomePage.AssignMeRequests();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 8, enabled = true)
	private void csaHomePageSearchRequestStatus() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminCSAHomePage.openCSAHomePage();
			adminCSAHomePage.filterAndSearchRequestStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 9, enabled = true)
	private void csaHomePageSearchRecordType() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminCSAHomePage.openCSAHomePage();
			adminCSAHomePage.filterAndSearchRecordType();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 10, enabled = true)
	private void csaHomePageCustodian() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminCSAHomePage.openCSAHomePage();
			adminCSAHomePage.filterAndSearchCustodian();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 11, enabled = true)
	private void EnterpriseAdminRequestProcessing() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminEnterpriseResourcePage.openAdminEnterpriseResourcesPage();
		boolean flag=adminEnterpriseResourcePage.enterprisesAdminTab();
		if (flag) {
			adminEnterpriseResourcePage.verifyNewEnterpriseAdminAdd();
		}
		TestUtil.hardWait(5);
		adminEnterpriseResourcePage.editAdminEnterprise(false);
		loginpage.logout();
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		adminCSAHomePage.openCSAHomePageFromCustodian();
		String requestNo=adminCSAHomePage.processRequestFromCustodianEnterpriseAdmin();
		clinicalReviewerRequestAssignment.processingofRequest();
		adminCSAHomePage.searchProcessedRequest(requestNo);
	}
	
	
	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
