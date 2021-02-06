package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.CreateRequest;
import com.ChartRequest.Pages.CustodianStatement;
import com.ChartRequest.Pages.CustodianStatement_Old;
import com.ChartRequest.Pages.HomePage;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SearchMyRequest;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.GlobalVariables;

public class MessagesTestCaseNavigationPaneTestCases extends BrowserConfiguration {

	SignUpPage signUpPage;
	LoginPage loginpage;
	CreateRequest createRequest;
	SearchMyRequest searchMyRequest;
	HomePage homePage;
	CustodianStatement custodianStatement;
	CustodianStatement_Old custodianStatement_Old;

	public MessagesTestCaseNavigationPaneTestCases() {
		super();
	}

	@BeforeMethod
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		//browserTearUp(GlobalVariables.preproductionUrl);
		loginpage = new LoginPage();
		signUpPage = new SignUpPage();
		String url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
		createRequest = new CreateRequest();
		searchMyRequest = new SearchMyRequest();
		homePage = new HomePage();
		custodianStatement = new CustodianStatement();
		custodianStatement_Old = new CustodianStatement_Old();
	}

	@Test(priority = 1, enabled = true)
	public void ReadMessageCountFromCustodian() {
		try {

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
			homePage.verifyMessageCount();
			createRequest.getchartMessageCustodian(RequestID, true, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2, enabled = true)
	public void chartProviderMessageCustodianToRequestor() {
		try {

			loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
			createRequest.openSearchPage();
			searchMyRequest.searchMultipleConditionCustodian("Pending", "Test Automation");
			String RequestID = createRequest.getSearchByMultipleFilter();
			createRequest.getchartMessageCustodian(RequestID, true, GlobalVariables.chatMessageFromCustodian);
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.openSearchPage();
			searchMyRequest.searchByRequestID(RequestID);
			homePage.verifyMessageCount();
			createRequest.getchartMessageRequest(RequestID, null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3, enabled = true)
	public void chartProviderMessageCustodianToCustodian() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			custodianStatement_Old.searchAndOpenByCustodianNameFirstRequest(GlobalVariables.OrganizationName);
			createRequest.selectTypeOfProcessingRequest();
			String id = createRequest.sendMessage(true, GlobalVariables.chatMessageFromCustodian);
			loginpage.logout();
			loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
			createRequest.openSearchPage();
			searchMyRequest.searchByRequestID(id);
			homePage.verifyMessageCount();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
		TestListener.infoMessage("Closing of Web Driver");
	}
}
