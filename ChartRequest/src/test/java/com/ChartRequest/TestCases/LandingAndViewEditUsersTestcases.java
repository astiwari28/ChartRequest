package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminSearchPage;
import com.ChartRequest.Pages.CustodianStatement_Old;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SearchMyRequest;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class LandingAndViewEditUsersTestcases extends BrowserConfiguration {

	LoginPage loginpage;
	SignUpPage signUpPage;
	SearchMyRequest searchMyRequest;
	CustodianStatement_Old custodianStatement;
	AdminSearchPage adminSearchPage;
	String url,flagName,noteValue;
	
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
		searchMyRequest=new SearchMyRequest();
		custodianStatement=new CustodianStatement_Old();
		adminSearchPage=new AdminSearchPage();
	}
	
	@Test(priority = 1, enabled = true)
	private void changeLandingPageURL() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		adminSearchPage.openSearchResult(GlobalVariables.OrganizationName);
		String tempURL=adminSearchPage.openEditLandingPage("CustodianAutomation");
		if (url.contains("preproduction")) {
			TestUtil.openNewTabWithURL("https://staging.chartrequest.com/"+tempURL);
		} else {
			TestUtil.openNewTabWithURL("https://preproduction.chartrequest.com/"+tempURL);
		}
		
	}

	@Test(priority = 2, enabled = true)
	private void addNewUser() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		adminSearchPage.openSearchResult(GlobalVariables.OrganizationName);
		adminSearchPage.addViewUser();
	}
	
	@Test(priority = 3, enabled = true)
	private void EditCustodianDetails() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
			adminSearchPage.editCustodianDetails("Automation", "Automation Testing", "Automation", "automation@test.in", "1234567890");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 4, enabled = true)
	private void EditPracticeResources() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
			adminSearchPage.editPracticeResources("BCS");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 5, enabled = true)
	private void deleteCustodian() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.openListForDeletedCustodian("Test");
			String id=adminSearchPage.getCustodianNumber();
			adminSearchPage.deleteCustodian();
			adminSearchPage.verifyDeleteCustodian(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 6, enabled = true)
	private void convertToRequestor() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.openListForDeletedCustodian("Test");
			String newRequestorId=adminSearchPage.convertToRequestorAndGetNewRequetorNumber("Patient");
			custodianStatement.searchPage();
			adminSearchPage.findRequestorIdAfterConverstion(newRequestorId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 7, enabled = true)
	private void MergeToAnotherCustodian() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			custodianStatement.searchCustodianWithFilter("Unapproved");
			adminSearchPage.findUnApproveCustodianForMergeAndApprove();
			adminSearchPage.mergeCustodian(GlobalVariables.OrganizationName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 8, enabled = true)
	private void SearchUserByUserNameWithValidUserName() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchUsersByUserName("Demo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 9, enabled = true)
	private void SearchUserByUserNameWithInValidUserName() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchUsersByUserName("1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 10, enabled = true)
	private void SearchUserByUserNameWithEmailID() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchUsersByEmailId("demo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 11, enabled = true)
	private void SearchUserByUserNameWithInValidEmailID() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchUsersByEmailId("demo123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 12, enabled = true)
	private void SearchUserByUserNameWithRequestorID() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			/*searchMyRequest.getLastPage();
			String requestNo=searchMyRequest.getLastRequestIDFromAdmin();*/
			custodianStatement.searchPage();
			if (url.contains("staging")) {
				adminSearchPage.adminSearchUsersByRequestorID("2343");
			} else {
				adminSearchPage.adminSearchUsersByRequestorID("2296");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 13, enabled = true)
	private void SearchUserByUserNameWithRequestorName() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchUsersByRequestorName("Demo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 14, enabled = true)
	private void SearchUserByUserNameWithInValidRequestorName() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchUsersByRequestorName("sfg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 15, enabled = true)
	private void SearchUserByUserNameWithRequestorType() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchUsersByRequestorType("Law Firm - Defense");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 16, enabled = true)
	private void SearchUserByRequestSearchWithEmailID() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchRequestByEmailId("demo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 17, enabled = true)
	private void SearchUserByRequestSearchWithEnterpriseName() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchRequestByEnterpriseName("Test Requestor");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 18, enabled = true)
	private void SearchCustodianByCustodianName() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachCustodianByCustodianName(GlobalVariables.OrganizationName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 18, enabled = true)
	private void SearchCustodianByCustodianID() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachCustodianByCustodianId("2344");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 19, enabled = true)
	private void SearchCustodianByWrongCustodianID() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachCustodianByCustodianId("115");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 20, enabled = true)
	private void SearchCustodianByCustodianContact() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachCustodianByCustodianContactName("Automation");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 21, enabled = true)
	private void SearchCustodianByApprovalStatusApproved() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			custodianStatement.searchCustodianWithFilter("Approved");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 22, enabled = true)
	private void SearchCustodianByApprovalStatusUnapproved() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			custodianStatement.searchCustodianWithFilter("Unapproved");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 23, enabled = true)
	private void SearchCustodianByApprovalStatusUnverifiable() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			custodianStatement.searchCustodianWithFilter("Unverifiable");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 24, enabled = true)
	private void SearchCustodianByCustodianAliasAndLocationSite() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.openListForDeletedCustodian(GlobalVariables.OrganizationName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 25, enabled = true)
	private void SearchCustodianByCustodianServiceLevelSelfService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchCustodianByServiceLevel("Self-Service");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 26, enabled = true)
	private void SearchCustodianByCustodianServiceLevelFullService() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchCustodianByServiceLevel("Full Service");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 27, enabled = true)
	private void SearchCustodianByCustodianServiceLevelSelfServiceChartX() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchCustodianByServiceLevel("Self-Service - ChartX");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 28, enabled = true)
	private void SearchCustodianByCustodianServiceLevelFullServiceChartX() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchCustodianByServiceLevel("Full Service - ChartX");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 29, enabled = true)
	private void SearchCustodianByCustodianServiceLevelRetrievelBucket() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchCustodianByServiceLevel("Retrievel Bucket");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 30, enabled = true)
	private void SearchCustodianByCustodianEmail() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachCustodianByCustodianEmail("Automation");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 31, enabled = true)
	private void SearchCustodianByCustodianInvalidEmail() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachCustodianByCustodianEmail("mnp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 32, enabled = true)
	private void SearchCustodianByCustodianEnterpriseName() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchCustodianByEnterpriseName("All Enterprise");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 33, enabled = true)
	private void SearchCustodianByCustodianCityName() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachCustodianByCustodianCityName("Indianapolis");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 34, enabled = true)
	private void SearchCustodianByCustodianInvalidCityName() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachCustodianByCustodianCityName("India");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 35, enabled = true)
	private void SearchCustodianByCustodianPhoneNumber() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachCustodianByCustodianPhoneNumber("1234567890");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 36, enabled = true)
	private void SearchCustodianByCustodianInValidPhoneNumber() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachCustodianByCustodianPhoneNumber("0987654321");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 37, enabled = true)
	private void SearchCustodianByCustodianIncludeDeletedCustodians() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachCustodianByCustodianIncludeDeletedCustodians();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 38, enabled = true)
	private void SearchCustodianByCustodianShowOnlyDeletedCustodians() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachCustodianByCustodianShowOnlyDeletedCustodians();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 39, enabled = true)
	private void SearchRetrievalRequestsByCustodianName() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			if (url.contains("preproduction")) {
				adminSearchPage.adminSeachRetrievalRequestsByCustodianName("Automation Testing");	
			}
			else {
				adminSearchPage.adminSeachRetrievalRequestsByCustodianName("ABBBBB");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 40, enabled = true)
	private void SearchRetrievalRequestsByRequestorName() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachRetrievalRequestsByRequestorName("Demo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 41, enabled = true)
	private void SearchRetrievalRequestsByRequestorID() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			searchMyRequest.getLastPage();
			String requestNo=searchMyRequest.getLastRequestIDFromAdmin();
			custodianStatement.searchPage();
			adminSearchPage.adminSeachRetrievalRequestsByRequestorID(requestNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 42, enabled = true)
	private void SearchRetrievalRequestsByRequestorType() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachRetrievalRequestsByRequestorType("Health Care Provider");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 43, enabled = true)
	private void SearchRetrievalRequestsByPatientsFirstName() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachRetrievalRequestsByPatientsFirstName("Automation");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 44, enabled = true)
	private void SearchRetrievalRequestsByReasonForRequest() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSeachRetrievalRequestsByReasonForRequest("HEDIS");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 45, enabled = true)
	private void SearchRetrievalRequestByEnterpriseName() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchRetrievalRequestByEnterpriseName("Test Requestor");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 46, enabled = true)
	private void SearchRequestsByCustodianName() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchRequestByCustodianName(GlobalVariables.OrganizationName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 47, enabled = true)
	private void SearchRequestsByRequestorID() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			searchMyRequest.getLastPage();
			String requestNo=searchMyRequest.getLastRequestIDFromAdmin();
			custodianStatement.searchPage();
			adminSearchPage.adminSeachRequestsByRequestorID(requestNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 48, enabled = true)
	private void SearchRequestsByRequestStatus() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			adminSearchPage.adminSearchRequestByRequestStatus("Pending");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 49, enabled = true)
	public void createNewFlagCustodian() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
			flagName=TestUtil.getAlphaDynamicString(5);
			noteValue="Testing";
			custodianStatement.addNewFlag("Create",flagName,noteValue, true);
			//custodianStatement.addNewFlag("AutomationTesting",flagName,noteValue, true);
			custodianStatement.verifyFlagStatus();
			loginpage.logout();
			loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
			custodianStatement.verifyFlagStatusFromRequestForCustodian(noteValue);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test(priority = 50, enabled = true,dependsOnMethods = "createNewFlagCustodian")
	public void deleteNewFlagCustodian() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
			custodianStatement.deleteFlagCustodian(flagName);
			custodianStatement.verifyFlagStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test(priority = 51, enabled = true)
	public void createNewFlagRequest() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			custodianStatement.searchAndOpenByRequestorEmail(GlobalVariables.requestorEmailStaging);
			flagName=TestUtil.getAlphaDynamicString(5);
			noteValue="Testing";
			custodianStatement.addNewFlag("Create",flagName,noteValue, true);
			//custodianStatement.addNewFlag("AutomationTesting",flagName,noteValue, true);
			custodianStatement.verifyFlagStatus();
			custodianStatement.searchPage();
			custodianStatement.searchAndOpenByRequestorEmail(GlobalVariables.requestorEmailStaging);
			custodianStatement.verifyFlagStatusFromRequestForRequestor(noteValue);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test(priority = 52, enabled = true,dependsOnMethods = "createNewFlagRequest")
	public void deleteNewFlagRequest() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			custodianStatement.searchAndOpenByRequestorEmail(GlobalVariables.requestorEmailStaging);
			custodianStatement.deleteFlagRequestor(flagName);
			custodianStatement.verifyFlagStatus();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
