package com.ChartRequest.TestCases;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminExecutivePage;
import com.ChartRequest.Pages.AdminSearchPage;
import com.ChartRequest.Pages.CreateRequest;
import com.ChartRequest.Pages.CustodianStatement_Old;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SearchMyRequest;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class ExecutivePageTestCases extends BrowserConfiguration {

	LoginPage loginpage;
	SignUpPage signUpPage;
	AdminExecutivePage adminExecutivePage;
	CreateRequest createRequest;
	SearchMyRequest searchMyRequest;
	AdminSearchPage adminSearchPage;
	CustodianStatement_Old custodianStatement;
	String url, requestCreated;

	@BeforeMethod()
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		// browserTearUp(GlobalVariables.preproductionUrl);
		loginpage = new LoginPage();
		signUpPage = new SignUpPage();
		url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
		adminExecutivePage = new AdminExecutivePage();
		createRequest = new CreateRequest();
		searchMyRequest = new SearchMyRequest();
		adminSearchPage=new AdminSearchPage();
		custodianStatement=new CustodianStatement_Old();
	}

	@Test(priority = 1, enabled = false)
	private void adminExecutivePageAddPartner() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminExecutivePage.openExecutivePage("1234");
			adminExecutivePage.addPatners(GlobalVariables.GlobalAddress, "Patient");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2, enabled = false)
	private void adminExecutivePageBulkUploadAbandonRequestor() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminExecutivePage.openExecutivePage("1234");
			adminExecutivePage.bulkUploadRequestorAbandon(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3, enabled = false)
	private void adminExecutivePageBulkUploadAbandonCustodian() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminExecutivePage.openExecutivePage("1234");
			adminExecutivePage.bulkUploadRequestorAbandon(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4, enabled = false)
	private void adminExecutivePageSessionDetailsReportByUserName() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminExecutivePage.openExecutivePage("1234");
			adminExecutivePage.SessionDetailsReportByUserName("Jafar");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 5, enabled = false)
	private void adminExecutivePageSessionDetailsReportByUserType() {
		try {
			List<String> cNames = Arrays.asList("All", "SPU", "Custodian", "Requestor");
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminExecutivePage.openExecutivePage("1234");
			for (String string : cNames) {
				adminExecutivePage.sessionDetailsReportByUserType(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 6, enabled = false)
	private void adminExecutivePageSearchCheque() {
		createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		createRequest.createNewRequest();
		createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
		createRequest.payByCheque();
		requestCreated = createRequest.fillFormDetailsRequestCreation("Automation", "Test Patient", "01011991",
				"Medical", false, "General Release");
		loginpage.logout();
		String requestNo = requestCreated;
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(requestNo);
		// searchMyRequest.searchByRequestID("26525");
		createRequest.processingRequest(false);
		adminExecutivePage.searchChequeNumber();
	}

	@Test(priority = 7, enabled = false)
	public void raiseARefundRequest() {
		createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		/*
		 * String tempRequestNumber=adminExecutivePage.getCompletedRequestNumber();
		 * String tempRefundprice=adminExecutivePage.getRefundPrice();
		 * adminExecutivePage.refundRequest(tempRequestNumber, tempRefundprice, "Other",
		 * GlobalVariables.GlobalAddress); loginpage.logout();
		 * loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		 * adminExecutivePage.openExecutivePage("1234");
		 * adminExecutivePage.processingRefund(tempRequestNumber, true, false);
		 */
		createRequest.createNewRequest();
		createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
		requestCreated = createRequest.fillFormDetailsRequestCreation("Automation", "Test Patient", "01011991",
				"Medical", false, "General Release");
		String requestNo = requestCreated;
		loginpage.logout();
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
		loginpage.logout();
		createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		// String tempRequestNumber=adminExecutivePage.getCompletedRequestNumber();
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(requestNo);
		driver.findElement(By.xpath("//a[contains(text(),'" + requestNo + "')]")).click();
		TestUtil.hardWait(5);
		String tempRefundprice = adminExecutivePage.getRefundPrice();
		adminExecutivePage.refundRequest(requestNo, tempRefundprice, "Other", GlobalVariables.GlobalAddress);
		loginpage.logout();
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminExecutivePage.openExecutivePage("1234");
		//adminExecutivePage.processingRefund(requestNo, true, false,"");
		/*Change for Deny Refund*/
		adminExecutivePage.processingRefund(requestNo, false, false,"Other");
		loginpage.logout();
		loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(requestNo);
		createRequest.getchartMessageRequest(requestNo, null);
		//adminExecutivePage.processingRefund("29483", true, false,"");
		/*TestUtil.openNewTabWithURL("https://dashboard.stripe.com/login");
		loginpage.loginStripe("chartrequest.testing@gmail.com", "Fullcycle123@");
		adminExecutivePage.verifyRefundFromStripe(requestNo);*/
	}

	@Test(priority = 8, enabled = false)
	public void CheckProcessing() {
		createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		createRequest.createNewRequest();
		createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
		requestCreated = createRequest.fillFormDetailsRequestCreation("Automation", "Test Patient", "01011991",
				"Medical", false, "General Release");
		String requestNo = requestCreated;
		loginpage.logout();
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(requestNo);
		// searchMyRequest.searchByRequestID("26525");
		createRequest.processingRequest(false);
		loginpage.logout();
		
		createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		// String tempRequestNumber=adminExecutivePage.getCompletedRequestNumber();
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(requestNo);
		driver.findElement(By.xpath("//a[contains(text(),'" + requestNo + "')]")).click();
		TestUtil.hardWait(5);
		String tempRefundprice = adminExecutivePage.getRefundPrice();
		String tempRefund=tempRefundprice.substring(1);	
		loginpage.logout();
		
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		adminSearchPage.adminSeachRequestsByRequestorID(requestNo);
		driver.findElement(By.xpath("//a[contains(text(),'" + requestNo + "')]")).click();
		TestUtil.hardWait(5);
		String tempChequeNumber=adminExecutivePage.checkProcessingFromAdmin(tempRefund);
		adminExecutivePage.openExecutivePage("1234");
		adminExecutivePage.checkChequeThroughExecutivePage(tempChequeNumber);
	}
	
	@Test(priority = 9, enabled = false)
	public void raiseARefundRequestDenyCode701() {
		createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		/*
		 * String tempRequestNumber=adminExecutivePage.getCompletedRequestNumber();
		 * String tempRefundprice=adminExecutivePage.getRefundPrice();
		 * adminExecutivePage.refundRequest(tempRequestNumber, tempRefundprice, "Other",
		 * GlobalVariables.GlobalAddress); loginpage.logout();
		 * loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		 * adminExecutivePage.openExecutivePage("1234");
		 * adminExecutivePage.processingRefund(tempRequestNumber, true, false);
		 */
		createRequest.createNewRequest();
		createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
		String requestNo = createRequest.fillFormDetailsRequestCreation("Automation", "Test Patient", "01011991",
				"Medical", false, "General Release");
		loginpage.logout();
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(requestNo);
		// searchMyRequest.searchByRequestID("26525");
		createRequest.processingRequest(false);
		//Chaning from here Change the price
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(requestNo);
		searchMyRequest.openSearchRequestID(requestNo);
		createRequest.changeTheService();
		//Till here
		loginpage.logout();
		
		loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		System.out.println("Login Again For Compeleted The Request");
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(requestNo);
		createRequest.completingRequest(requestNo);
		loginpage.logout();
		createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		// String tempRequestNumber=adminExecutivePage.getCompletedRequestNumber();
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(requestNo);
		driver.findElement(By.xpath("//a[contains(text(),'" + requestNo + "')]")).click();
		TestUtil.hardWait(5);
		String tempRefundprice = adminExecutivePage.getRefundPrice();
		adminExecutivePage.refundRequest(requestNo, tempRefundprice, "Other", GlobalVariables.GlobalAddress);
		loginpage.logout();
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminExecutivePage.openExecutivePage("1234");
		adminExecutivePage.processingRefund(requestNo, false, false,"701 - No Reason to Refund - Patient");
	}
	
	@Test(priority = 10, enabled = false)
	public void raiseARefundRequestDenyOthers() {
		createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		/*
		 * String tempRequestNumber=adminExecutivePage.getCompletedRequestNumber();
		 * String tempRefundprice=adminExecutivePage.getRefundPrice();
		 * adminExecutivePage.refundRequest(tempRequestNumber, tempRefundprice, "Other",
		 * GlobalVariables.GlobalAddress); loginpage.logout();
		 * loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		 * adminExecutivePage.openExecutivePage("1234");
		 * adminExecutivePage.processingRefund(tempRequestNumber, true, false);
		 */
		createRequest.createNewRequest();
		createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
		requestCreated = createRequest.fillFormDetailsRequestCreation("Automation", "Test Patient", "01011991",
				"Medical", false, "General Release");
		String requestNo = requestCreated;
		loginpage.logout();
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
		loginpage.logout();
		createRequest = loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
		// String tempRequestNumber=adminExecutivePage.getCompletedRequestNumber();
		createRequest.openSearchPage();
		searchMyRequest.searchByRequestID(requestNo);
		driver.findElement(By.xpath("//a[contains(text(),'" + requestNo + "')]")).click();
		TestUtil.hardWait(5);
		String tempRefundprice = adminExecutivePage.getRefundPrice();
		adminExecutivePage.refundRequest(requestNo, tempRefundprice, "Other", GlobalVariables.GlobalAddress);
		loginpage.logout();
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminExecutivePage.openExecutivePage("1234");
		adminExecutivePage.processingRefund(requestNo, false, false,"Other");
	}

	@Test(priority = 11, enabled = true)
	public void Task161VerifyFilterAndSearchStatusRefundStatusAndOpenRequestInCustodianView() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminExecutivePage.openExecutivePage("1234");
		adminExecutivePage.refundFilterAndSearch("Approved");
		adminExecutivePage.verifySearchResult("Approved");
		adminExecutivePage.resetFilterAndSearch();
		adminExecutivePage.verifySearchResult("Pending Review");
		adminExecutivePage.openRequestInRefund();
	}
	
	
	@AfterMethod(enabled = false)
	public void browserTearDown() {
		driver.quit();
	}
}
