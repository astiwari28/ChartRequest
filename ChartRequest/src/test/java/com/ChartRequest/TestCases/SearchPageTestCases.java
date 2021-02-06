package com.ChartRequest.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.CreateRequest;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SearchMyRequest;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchPageTestCases extends BrowserConfiguration {

	SignUpPage signUpPage;
	LoginPage loginpage;
	CreateRequest createRequest;
	SearchMyRequest searchMyRequest;
	String url;

	public SearchPageTestCases() {
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
		searchMyRequest = new SearchMyRequest();
	}

	// -----------------------Patient

	@Test(priority = 1, enabled = true)
	public void SearchByRequestIDPatient() {
		loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		String RequestID = createRequest.getRequestID();
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(RequestID);
	}

	@Test(priority = 2, enabled = true)
	public void SearchByPatientNamePatient() {
		loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByPatientName("Test Automation");
	}

	@Test(priority = 3, enabled = true)
	public void SearchByStatusPatient() {
		loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByinputStatus("Pending");
	}

	@Test(priority = 4, enabled = true)
	public void SearchByProviderNamePatient() {
		loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByProviderName(GlobalVariables.OrganizationName);
	}

	@Test(priority = 5, enabled = true)
	public void SearchByReasonOfRequestPatient() {
		loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByReasonForRequest("Other");
	}

	// -----------------------Requestor

	@Test(priority = 6, enabled = true)
	public void SearchByRequestIDRequestor() {
		loginpage.login(GlobalVariables.requestorEmailStaging, GlobalVariables.password);
		String RequestID = createRequest.getRequestID();
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(RequestID);
	}

	@Test(priority = 7, enabled = true)
	public void SearchByPatientNameRequestor() {
		loginpage.login(GlobalVariables.requestorEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByPatientName("Test Automation");
	}

	@Test(priority = 8, enabled = true)
	public void SearchByStatusRequestor() {
		loginpage.login(GlobalVariables.requestorEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByinputStatus("Pending");
	}

	@Test(priority = 9, enabled = true)
	public void SearchByProviderNameRequestor() {
		loginpage.login(GlobalVariables.requestorEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByProviderName(GlobalVariables.OrganizationName);
	}

	@Test(priority = 10, enabled = true)
	public void SearchByReasonOfRequestRequestor() {
		loginpage.login(GlobalVariables.requestorEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByReasonForRequest("Other");
	}

	// -----------------------custodian

	@Test(priority = 11, enabled = true)
	public void SearchByRequestIDCustodian() {
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.selectRequestTab();
		String RequestID = createRequest.getRequestID();
		System.out.println("Request ID:- " + RequestID);
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(RequestID);
	}

	@Test(priority = 12, enabled = true)
	public void SearchByPatientNameCustodian() {
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByPatientName("Test Automation");
	}

	@Test(priority = 13, enabled = true)
	public void SearchByStatusCustodian() {
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByinputStatus("Pending");
	}

	@Test(priority = 14, enabled = true)
	public void SearchByRequestorNameCustodian() {
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestorName(GlobalVariables.OrganizationName);
	}

	@Test(priority = 15, enabled = true)
	public void SearchByReasonOfRequestCustodian() {
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByReasonForRequest("Other");
	}

	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}

}
