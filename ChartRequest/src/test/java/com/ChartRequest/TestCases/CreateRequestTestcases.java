package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.ClinicalReviewerRequestAssignment;
import com.ChartRequest.Pages.CreateRequest;
import com.ChartRequest.Pages.CustodianStatement_Old;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SearchMyRequest;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class CreateRequestTestcases extends BrowserConfiguration {

	SignUpPage signUpPage;
	LoginPage loginpage;
	CreateRequest createRequest;
	CustodianStatement_Old custodianStatement;
	String requestCreated;
	SearchMyRequest searchMyRequest;
	ClinicalReviewerRequestAssignment clinicalReviewerRequestAssignment;


	public CreateRequestTestcases() {
		super();
	}

	@BeforeMethod
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		// browserTearUp(GlobalVariables.preproductionUrl);
		loginpage = new LoginPage();
		signUpPage = new SignUpPage();
		String url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
		createRequest = new CreateRequest();
		custodianStatement = new CustodianStatement_Old();
		searchMyRequest = new SearchMyRequest();
		clinicalReviewerRequestAssignment=new ClinicalReviewerRequestAssignment();
	}

	@Test(priority = 1, enabled = false)
	public void creatingNewRequestFromPatientAccount() {
		createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		createRequest.createNewRequest();
		createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
		requestCreated = createRequest.fillFormDetailsRequestCreation("Automation", "Test Patient", "01011991",
				"Medical", false, "General Release");
		TestListener.infoMessage("Requested Id is:- " + requestCreated);
	}

	@Test(priority = 2, enabled = false,dependsOnMethods = "creatingNewRequestFromPatientAccount")
	public void processingOFrequest() {
		String requestNo = requestCreated;
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(requestNo);
		// searchMyRequest.searchByRequestID("26525");
		createRequest.processingRequest(false);
		loginpage.logout();
		loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		System.out.println("Login Again For Compeleted The Request");
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(requestNo);
		createRequest.completingRequest(requestNo);

	}

	@Test(priority = 3, enabled = false)
	public void requestAbandonedPatient() {
		createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		createRequest.createNewRequest();
		createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
		createRequest.abandonRequest();
	}

	@Test(priority = 4, enabled = false)
	public void saveToDraftWithOutDetailsPatient() {
		createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		createRequest.createNewRequest();
		createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
		createRequest.saveRequestIntoDraft();
	}

	@Test(priority = 5, enabled = false)
	public void bulkUploadPatient() {
		createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		if (custodianStatement.verifyBulkUploadButton()) {
			createRequest.openBulkUploadPage();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			createRequest.uploadBulkUploadFile();
		} else {
			System.out.println("Button Not Found");
			loginpage.logout();
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			createRequest.enableBulkUpload(GlobalVariables.patientEmailStaging);
			loginpage.logout();
			createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.openBulkUploadPage();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			createRequest.uploadBulkUploadFile();
			searchMyRequest.getLastPage();
		}
	}

	@Test(priority = 6, enabled = false)
	public void creatingNewRequestFromEpatientAuth() {
		createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		createRequest.createNewRequest();
		createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
		createRequest.fillFormDetailsRequestCreation("Automation", "Test Requestor", "01011991", "Medical", true,
				"Patient eAuthorize");
	}

	@Test(priority = 7, enabled = true)
	public void creatingNewRequestFromRequestorAccount() {
		createRequest = loginpage.login(GlobalVariables.requestorEmailStaging, GlobalVariables.password);
		createRequest.createNewRequest();
		createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
		requestCreated = createRequest.fillFormDetailsRequestCreation("Automation", "Test", "01011991", "Medical", true,
				"General Release");
	}

	@Test(priority = 8, enabled = true)
	public void processingOFrequestRequestor() {
		//String requestNo = requestCreated;
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openLastRequestPage();
		createRequest.openLastRequest();
		//createRequest.openSearchPage();
		//searchMyRequest.searchByRequestID(requestNo);
		//searchMyRequest.searchByRequestID("29736");
		createRequest.processingRequest(true);
		/*
		 * loginpage.logout(); loginpage.login(GlobalVariables.requestorEmailStaging,
		 * GlobalVariables.password); createRequest.openSearchPage();
		 * searchMyRequest.searchByRequestID(requestNo);
		 * createRequest.completingRequest(requestNo);
		 */
	}

	@Test(priority = 9, enabled = true)
	public void requestAbandonedRequestor() {
		createRequest = loginpage.login(GlobalVariables.requestorEmailStaging, GlobalVariables.password);
		createRequest.createNewRequest();
		createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
		createRequest.abandonRequest();
	}

	@Test(priority = 10, enabled = true)
	public void saveToDraftWithOutDetailsRequestor() {
		createRequest = loginpage.login(GlobalVariables.requestorEmailStaging, GlobalVariables.password);
		createRequest.createNewRequest();
		createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
		createRequest.saveRequestIntoDraft();
	}

	@Test(priority = 11, enabled = true)
	public void bulkUploadRequestor() {
		createRequest = loginpage.login(GlobalVariables.requestorEmailStaging, GlobalVariables.password);
		if (custodianStatement.verifyBulkUploadButton()) {
			createRequest.openBulkUploadPage();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			createRequest.uploadBulkUploadFile();
		} else {
			System.out.println("Button Not Found");
			loginpage.logout();
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			createRequest.enableBulkUpload(GlobalVariables.requestorEmailStaging);
			loginpage.logout();
			createRequest = loginpage.login(GlobalVariables.requestorEmailStaging, GlobalVariables.password);
			createRequest.openBulkUploadPage();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			createRequest.uploadBulkUploadFile();
		}
	}

	@Test(priority = 12, enabled = true)
	public void creatingNewRequestFromCustodianAccount() {
		createRequest = loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		if (createRequest.verifyCareCordinationButton()) {
			loginpage.logout();
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			custodianStatement.searchCustodianAndEnableDisableCareCordination(GlobalVariables.custodianIDTesting);
			loginpage.logout();
			createRequest = loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
			createRequest.changeCustodianToRequestor();
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			createRequest.fillFormDetailsRequestCreation("Automation", "Test Custodian", "01011991", "Medical", true,
					"General Release");
		} else {
			createRequest.changeCustodianToRequestor();
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			createRequest.fillFormDetailsRequestCreation("Automation", "Test Custodian", "01011991", "Medical", true,
					"General Release");
		}
	}

	@Test(priority = 13, enabled = true)
	public void requestAbandonedCustodian() {
		createRequest = loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.changeCustodianToRequestor();
		createRequest.createNewRequest();
		createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
		createRequest.abandonRequest();
	}

	@Test(priority = 14, enabled = true)
	public void saveToDraftWithOutDetailsCustodian() {
		createRequest = loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.changeCustodianToRequestor();
		createRequest.createNewRequest();
		createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
		createRequest.saveRequestIntoDraft();
	}

	@Test(priority = 15, enabled = true)
	public void bulkUploadCustodian() {
		createRequest = loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		if (custodianStatement.verifyBulkUploadButton()) {
			createRequest.openBulkUploadPage();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			createRequest.uploadBulkUploadFile();
		} else {
			System.out.println("Button Not Found");
			loginpage.logout();
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			createRequest.enableBulkUpload(GlobalVariables.custodianEmailStaging);
			loginpage.logout();
			createRequest = loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
			createRequest.openBulkUploadPage();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			createRequest.uploadBulkUploadFile();
		}
	}

	@Test(priority = 16, enabled = true)
	public void WalkinRequestCustodian() {
		createRequest = loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		if (createRequest.verifyWalkinButton()) {
			createRequest.walkinRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			requestCreated = createRequest.fillFormDetailsRequestCreation("Automation", "Test Custodian", "01011991",
					"Medical", true, "General Release");
		} else {
			System.out.println("Button Not Found");
			loginpage.logout();
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			createRequest.enableWakinRequest();
			loginpage.logout();
			createRequest = loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
			createRequest.walkinRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			requestCreated = createRequest.fillFormDetailsRequestCreation("Automation", "Test Custodian", "01011991",
					"Medical", true, "General Release");

		}
	}

	@Test(priority = 17, enabled = true/* ,dependsOnMethods ="WalkinRequestCustodian" */)
	public void processingOFrequestWalkin() {
		//String requestNo = requestCreated;
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openLastRequestPage();
		createRequest.openLastRequest();
		//createRequest.openSearchPage();
		//searchMyRequest.searchByRequestID(requestNo);
		//searchMyRequest.searchByRequestID("29433");
		//createRequest.processOfWalkinRequest();
		createRequest.processingRequest(true);
		loginpage.logout();
		/*loginpage.login(GlobalVariables.custodianEmailStaging,GlobalVariables.password);
		System.out.println("Login Again For Compeleted The Request");
		createRequest.openSearchPage(); 
		//searchMyRequest.searchByRequestID(requestNo);
		//createRequest.completingRequest(requestNo);*/
	}

	@Test(priority = 18, enabled = true)
	public void chartProviderMessageRequestorToCustodian() {
		loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		String RequestID = createRequest.getRequestID();
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(RequestID);
		// createRequest.getchartMessageRequest(RequestID,GlobalVariables.chatMessageFromRequestor);
		createRequest.getchartMessageRequest(RequestID, GlobalVariables.chatMessageFromRequestor);
		loginpage.logout();
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(RequestID);
		createRequest.getchartMessageCustodian(RequestID, true, null);
	}

	@Test(priority = 19, enabled = true)
	public void chartProviderMessageCustodianToRequestor() {
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		//searchMyRequest.searchMultipleConditionCustodian("Pending", "Patient");
		searchMyRequest.searchMultipleConditionCustodian("Pending", "test");
		String RequestID = createRequest.getSearchByMultipleFilter();
		createRequest.getchartMessageCustodian(RequestID, true, GlobalVariables.chatMessageFromCustodian);
		loginpage.logout();
		loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(RequestID);
		createRequest.getchartMessageRequest(RequestID, null);
	}

	@Test(priority = 20, enabled = true)
	public void incompleteRequestCustodian() {
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchMultipleConditionCustodian("Pending", "Patient");
		String RequestID = createRequest.getSearchByMultipleFilter();
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(RequestID);
		createRequest.openSearchTicketIncompleteRequest(RequestID);
	}

	@Test(priority = 21, enabled = true)
	public void lockingAndUnlockingRequest() {
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchMultipleConditionCustodian("Pending", "Patient");
		String RequestID = createRequest.getSearchByMultipleFilter();
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(RequestID);
		createRequest.lockandUnlockRequest(RequestID);
		TestUtil.hardWait(3);
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(RequestID);
		createRequest.lockandUnlockRequest(RequestID);
	}

	@Test(priority = 22, enabled = true)
	public void reOpenAbandonRequest() {
		loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByinputStatus("abandoned_by_requestor");
		TestListener.addDynamicScreenshotInReport("abandoned_by_requestor");
		String RequestID = createRequest.getSearchByMultipleFilterRequestor();
		createRequest.openAbandonedRequest(RequestID);
	}

	@Test(priority = 23, enabled = true)
	public void WalkinRequestCustodianSPU() {
		try {

			createRequest = loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			if (createRequest.verifyWalkinButton()) {
				createRequest.walkinRequestSPU(GlobalVariables.selectState, GlobalVariables.OrganizationName,
						GlobalVariables.requestorEmailStaging);
				requestCreated = createRequest.fillFormDetailsRequestCreation("Automation", "Test Custodian",
						"01011991", "Medical", true, "General Release");
			} else {
				System.out.println("Button Not Found");
				loginpage.logout();
				loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
				custodianStatement.searchPage();
				createRequest.enableWakinRequest();
				loginpage.logout();
				loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
				createRequest.walkinRequestSPU(GlobalVariables.selectState, GlobalVariables.OrganizationName,
						GlobalVariables.requestorEmailStaging);
				requestCreated = createRequest.fillFormDetailsRequestCreation("Automation", "Test Custodian",
						"01011991", "Medical", true, "General Release");
			}
			//createRequest.processingRequest(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 24, enabled = true)
	public void createRequestCareCordination() {
		loginpage.login(GlobalVariables.newCustodian, GlobalVariables.password);
		//loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openCareCoordination();
		createRequest.createRequestFromCareCordination("Automation Custodian");
		//createRequest.processingofCareCoordinateRequest();
		
	}
	
	@Test(priority = 25, enabled = true)
	public void processingRequestCareCordination() {
		//loginpage.login(GlobalVariables.newCustodian, GlobalVariables.password);
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		if (createRequest.verifyCareCordinationButton()) {
			createRequest.openCareCoordination();
			createRequest.processingofCareCoordinateRequest();
		} else {
			loginpage.logout();
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			custodianStatement.searchCustodianAndEnableDisableCareCordination(GlobalVariables.custodianIDTesting);
			loginpage.logout();
			createRequest = loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
			createRequest.openCareCoordination();
			createRequest.processingofCareCoordinateRequest();
		} 
	}
	
	@Test(priority = 26, enabled = true)
	public void createRequestCareCordinationWalkin() {
		loginpage.login(GlobalVariables.newCustodian, GlobalVariables.password);
		//loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openCareCoordination();
		createRequest.createWalkinRequestCareCoordination(true,"requestor.automation@test.com");
		//createRequest.processingofCareCoordinateRequest();
	}	
	
	@Test(priority = 27, enabled = true)
	public void verifyReferalStatus() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		custodianStatement.searchAndOpenByCustodianName("Automation Testing");
		clinicalReviewerRequestAssignment.openEditGeneralSettings();
		createRequest.verifyEnableReferralManagement();
		loginpage.logout();
		loginpage.login(GlobalVariables.newCustodian, GlobalVariables.password);
		//loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openCareCoordination();
		if (createRequest.statusOfReferralsCard()) {
			createRequest.startReferal("Automation Testing", TestUtil.getAlphaDynamicString(10),
					TestUtil.getAlphaDynamicString(6) + "@test.com", GlobalVariables.OrganizationName);
		}
		else {
			System.out.println("Desging in Progress");
		}
	}
	
	@AfterMethod(enabled = false)
	public void browserTearDown() {
		driver.quit();	
	}
}
