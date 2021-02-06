package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminBlockedFaxNumberPage;
import com.ChartRequest.Pages.ClinicalReviewerRequestAssignment;
import com.ChartRequest.Pages.CustodianStatement_Old;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;

public class ClinicalReviewerRequestAssignmentTestCase extends BrowserConfiguration{

	LoginPage loginpage;
	SignUpPage signUpPage;
	ClinicalReviewerRequestAssignment clinicalReviewerRequestAssignment;
	CustodianStatement_Old custodianStatement;
	String url, newURL;

	@BeforeMethod()
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		loginpage = new LoginPage();
		signUpPage = new SignUpPage();
		url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
		clinicalReviewerRequestAssignment = new ClinicalReviewerRequestAssignment();
		custodianStatement=new CustodianStatement_Old();
		
	}
	
	@Test(priority = 1, enabled = true)
	private void addCinicalReviewNameAndVerify() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
		clinicalReviewerRequestAssignment.openEditGeneralSettings();
		clinicalReviewerRequestAssignment.allowSkipAssignmentWhenMovedOnHold();
		loginpage.logout();
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		clinicalReviewerRequestAssignment.addClinicalReviewer("Custodian Automation");
		loginpage.logout();
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		String requestNo=clinicalReviewerRequestAssignment.enableQAandOnHoldProcessingRequest("Custodian Automation");
		clinicalReviewerRequestAssignment.verifyOnHold(requestNo);
		clinicalReviewerRequestAssignment.verifyClinicalReviewerNameFromCustionMessage(requestNo,"Custodian");
	}
	
	@Test(priority = 3, enabled = true)
	public void deleteClinicalReviewName() {
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		clinicalReviewerRequestAssignment.deleteClinicalReviewer("Automation");
	}
	
	@Test(priority = 2, enabled = true)
	private void addCinicalReviewNameAndVerifySSO() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
		clinicalReviewerRequestAssignment.openEditGeneralSettings();
		clinicalReviewerRequestAssignment.allowSkipAssignmentWhenMovedOnHold();
		loginpage.logout();
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		//loginpage.login(GlobalVariables.newCustodian, GlobalVariables.password);
		clinicalReviewerRequestAssignment.addClinicalReviewer("Custodian Testing");
		loginpage.logout();
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		//loginpage.login(GlobalVariables.newCustodian, GlobalVariables.password);
		String requestNo=clinicalReviewerRequestAssignment.enableQAandOnHoldProcessingRequest("Custodian Testing");
		clinicalReviewerRequestAssignment.verifyOnHold(requestNo);
		clinicalReviewerRequestAssignment.verifyClinicalReviewerNameFromCustionMessage(requestNo,"Custodian");
	}
	
	
	@Test(priority = 4, enabled = true)
	private void noCinicalReviewNameAndVerify() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		custodianStatement.searchAndOpenByCustodianName("Automation Testing");
		clinicalReviewerRequestAssignment.openEditGeneralSettings();
		clinicalReviewerRequestAssignment.allowSkipAssignmentWhenMovedOnHold();
		loginpage.logout();
		/*loginpage.login(GlobalVariables.newCustodian, GlobalVariables.password);
		clinicalReviewerRequestAssignment.enableQAandOnHoldProcessingRequest("Nitin Bhatt");*/
	}
	
	
	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
