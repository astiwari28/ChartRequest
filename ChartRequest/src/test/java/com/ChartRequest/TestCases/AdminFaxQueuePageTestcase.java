package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminFaxQueuePage;
import com.ChartRequest.Pages.AdminSearchPage;
import com.ChartRequest.Pages.CustodianStatement_Old;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;

public class AdminFaxQueuePageTestcase extends BrowserConfiguration{

	LoginPage loginpage;
	SignUpPage signUpPage;
	AdminFaxQueuePage adminFaxQueuePage;
	CustodianStatement_Old custodianStatement;
	AdminSearchPage adminSearchPage;
	String url,newURL;
	
	@BeforeMethod()
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		loginpage = new LoginPage();
		signUpPage = new SignUpPage();
		url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
		adminFaxQueuePage=new AdminFaxQueuePage();
		custodianStatement=new CustodianStatement_Old();
		adminSearchPage=new AdminSearchPage();
	}
	
	@Test(priority = 1, enabled = true)
	private void createRequestFromFaxFromCustodianTabIncomingType() {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminFaxQueuePage.openFaxQueuePage();
			adminFaxQueuePage.openTab("Custodian");
			adminFaxQueuePage.typeFaxQueCustodian("Incoming");
			boolean flag=adminFaxQueuePage.createRequestFromFax();
			if (flag) {
				String requestNo=adminFaxQueuePage.getRequestNumber();
				custodianStatement.searchPage();
				adminSearchPage.adminSeachRequestsByRequestorID(requestNo);
			} else {
				System.out.println("No Request Found");
			}
	}
	
	@Test(priority = 2, enabled = true)
	private void createRequestFromFaxFromCustodianTabSentType() {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminFaxQueuePage.openFaxQueuePage();
			adminFaxQueuePage.openTab("Custodian");
			adminFaxQueuePage.typeFaxQueCustodian("Sent");
			boolean flag=adminFaxQueuePage.createRequestFromFax();
			if (flag) {
				String requestNo=adminFaxQueuePage.getRequestNumber();
				custodianStatement.searchPage();
				adminSearchPage.adminSeachRequestsByRequestorID(requestNo);
			} else {
				System.out.println("No Request Found");
			}
	}
	
	@Test(priority = 3, enabled = true)
	private void createRequestFromFaxFromCustodianTabArchieveViewType() {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminFaxQueuePage.openFaxQueuePage();
			adminFaxQueuePage.openTab("Custodian");
			adminFaxQueuePage.typeFaxQueCustodian("Archive");
			adminFaxQueuePage.createRequestArchive();
	}
	
	// FAX #2
	@Test(priority = 4, enabled = true)
	private void createRequestFromFaxFromFax2TabIncomingType() {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminFaxQueuePage.openFaxQueuePage();
			adminFaxQueuePage.openTab("Fax #2");
			adminFaxQueuePage.typeFaxQueFax2("Incoming");
			boolean flag=adminFaxQueuePage.createRequestFromFax();
			if (flag) {
				String requestNo=adminFaxQueuePage.getRequestNumber();
				custodianStatement.searchPage();
				adminSearchPage.adminSeachRequestsByRequestorID(requestNo);
			} else {
				System.out.println("No Request Found");
			}
	}
	
	@Test(priority = 5, enabled = true)
	private void createRequestFromFaxFromFax2TabSentType() {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminFaxQueuePage.openFaxQueuePage();
			adminFaxQueuePage.openTab("Fax #2");
			adminFaxQueuePage.typeFaxQueFax2("Sent");
			boolean flag=adminFaxQueuePage.createRequestFromFax();
			if (flag) {
				String requestNo=adminFaxQueuePage.getRequestNumber();
				custodianStatement.searchPage();
				adminSearchPage.adminSeachRequestsByRequestorID(requestNo);
			} else {
				System.out.println("No Request Found");
			}
	}
	
	@Test(priority = 6, enabled = true)
	private void createRequestFromFaxFromFax2TabArchieveViewType() {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminFaxQueuePage.openFaxQueuePage();
			adminFaxQueuePage.openTab("Fax #2");
			adminFaxQueuePage.typeFaxQueFax2("Archive");
			adminFaxQueuePage.createRequestArchive();
	}
	
	// Concentra
	@Test(priority = 7, enabled = true)
	private void createRequestFromFaxFromConcentraTabIncomingType() {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminFaxQueuePage.openFaxQueuePage();
			adminFaxQueuePage.openTab("Concentra");
			adminFaxQueuePage.typeFaxQueConcentra("Incoming");
			boolean flag=adminFaxQueuePage.createRequestFromFax();
			if (flag) {
				String requestNo=adminFaxQueuePage.getRequestNumber();
				custodianStatement.searchPage();
				adminSearchPage.adminSeachRequestsByRequestorID(requestNo);
			} else {
				System.out.println("No Request Found");
			}
	}
	
	@Test(priority = 8, enabled = true)
	private void createRequestFromFaxFromConcentraTabSentType() {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminFaxQueuePage.openFaxQueuePage();
			adminFaxQueuePage.openTab("Concentra");
			adminFaxQueuePage.typeFaxQueConcentra("Sent");
			boolean flag=adminFaxQueuePage.createRequestFromFax();
			if (flag) {
				String requestNo=adminFaxQueuePage.getRequestNumber();
				custodianStatement.searchPage();
				adminSearchPage.adminSeachRequestsByRequestorID(requestNo);
			} else {
				System.out.println("No Request Found");
			}
	}
	
	@Test(priority = 9, enabled = true)
	private void createRequestFromFaxFromConcentraTabArchieveViewType() {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminFaxQueuePage.openFaxQueuePage();
			adminFaxQueuePage.openTab("Concentra");
			adminFaxQueuePage.typeFaxQueConcentra("Archive");
			adminFaxQueuePage.createRequestArchive();
	}
	
	// Retrieval
	@Test(priority = 10, enabled = true)
	private void createRequestFromFaxFromRetrievalTabIncomingType() {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminFaxQueuePage.openFaxQueuePage();
			adminFaxQueuePage.openTab("Retrieval");
			adminFaxQueuePage.typeFaxQueRetrieval("Incoming");
			boolean flag=adminFaxQueuePage.createRequestFromFax();
			if (flag) {
				String requestNo=adminFaxQueuePage.getRequestNumber();
				custodianStatement.searchPage();
				adminSearchPage.adminSeachRequestsByRequestorID(requestNo);
			} else {
				System.out.println("No Request Found");
			}
	}
	
	@Test(priority = 11, enabled = true)
	private void createRequestFromFaxFromRetrievalTabSentType() {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminFaxQueuePage.openFaxQueuePage();
			adminFaxQueuePage.openTab("Retrieval");
			adminFaxQueuePage.typeFaxQueRetrieval("Sent");
			boolean flag=adminFaxQueuePage.createRequestFromFax();
			if (flag) {
				String requestNo=adminFaxQueuePage.getRequestNumber();
				custodianStatement.searchPage();
				adminSearchPage.adminSeachRequestsByRequestorID(requestNo);
			} else {
				System.out.println("No Request Found");
			}
	}
	
	@Test(priority = 12, enabled = true)
	private void createRequestFromFaxFromRetrievalTabArchieveViewType() {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminFaxQueuePage.openFaxQueuePage();
			adminFaxQueuePage.openTab("Retrieval");
			adminFaxQueuePage.typeFaxQueRetrieval("Archive");
			adminFaxQueuePage.createRequestArchive();
	}
	
	@Test(priority = 13, enabled = true)
	public void filterAndSearch() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminFaxQueuePage.openFaxQueuePage();
		adminFaxQueuePage.openTab("Custodian");
		adminFaxQueuePage.typeFaxQueCustodian("Incoming");
		adminFaxQueuePage.sortByArrivalTime();
		String faxNo=adminFaxQueuePage.getFaxNumber();
		adminFaxQueuePage.filterAndSerach(faxNo);
	}
	
	@Test(priority = 14, enabled = true)
	public void archieveRecord() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminFaxQueuePage.openFaxQueuePage();
		adminFaxQueuePage.openTab("Custodian");
		adminFaxQueuePage.typeFaxQueCustodian("Incoming");
		String FaxID=adminFaxQueuePage.archieveFaxId();
		adminFaxQueuePage.openTab("Custodian");
		adminFaxQueuePage.typeFaxQueCustodian("Archive");
		adminFaxQueuePage.verifyArchieveFaxId(FaxID);
	}
	
	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
