package com.ChartRequest.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminPermissionPage;
import com.ChartRequest.Pages.AdminSearchPage;
import com.ChartRequest.Pages.CreateRequest;
import com.ChartRequest.Pages.CustodianStatement_Old;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SearchMyRequest;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;

public class AdminPermissionPageTestcases extends BrowserConfiguration {

	LoginPage loginpage;
	SignUpPage signUpPage;
	AdminPermissionPage adminPermissionPage;
	CreateRequest createRequest;
	SearchMyRequest searchMyRequest;
	CustodianStatement_Old custodianStatement;
	AdminSearchPage adminSearchPage;

	String url;

	@BeforeMethod()
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		// browserTearUp(GlobalVariables.preproductionUrl);
		loginpage = new LoginPage();
		signUpPage = new SignUpPage();
		createRequest = new CreateRequest();
		searchMyRequest = new SearchMyRequest();
		adminSearchPage=new AdminSearchPage();
		custodianStatement=new CustodianStatement_Old();
		url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
		adminPermissionPage = new AdminPermissionPage();
	}

	@Test(priority = 1, enabled = false)
	private void adminExecutivePageAddPartner() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminPermissionPage.openPermissionPage();
			adminPermissionPage.addUser(GlobalVariables.custodianEmailStaging, "Team Lead");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2, enabled = false)
	private void adminExecutivePageChangePermissionAllowUserToPerformQA() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminPermissionPage.openPermissionAndSwtichToAccessGridPage();
			boolean status = adminPermissionPage.changePermissionAllowUserToPerformQA();
			loginpage.logout();
			loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
			createRequest.selectRequestTab();
			String RequestID = createRequest.getRequestID();
			System.out.println("Request ID:- " + RequestID);
			createRequest.openSearchPage();
			searchMyRequest.searchByRequestID(RequestID);
			searchMyRequest.openSearchRequestID(RequestID);
			adminPermissionPage.processingTheReasonforAccessingRequest();
			adminPermissionPage.verifyPerformQANowButton(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3, enabled = false)
	private void adminExecutivePageChangePermissionAllowUserToQATheirOwnRequest() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminPermissionPage.openPermissionAndSwtichToAccessGridPage();
			boolean status = adminPermissionPage.changePermissionAllowUserToQATheirOwnRequest();
			loginpage.logout();
			loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
			createRequest.selectRequestTab();
			String RequestID = createRequest.getRequestID();
			System.out.println("Request ID:- " + RequestID);
			createRequest.openSearchPage();
			searchMyRequest.searchByRequestID(RequestID);
			searchMyRequest.openSearchRequestID(RequestID);
			adminPermissionPage.processingTheReasonforAccessingRequest();
			//adminPermissionPage.verifyPerformQANowButton(staus);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 7, enabled = false)
	private void adminLockAndUnlockRequest() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminPermissionPage.openPermissionAndSwtichToAccessGridPage();
			boolean status = adminPermissionPage.changePermissionlockAndUnlockRequest();
			loginpage.logout();
			loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
			createRequest.selectRequestTab();
			String RequestID = createRequest.getRequestID();
			System.out.println("Request ID:- " + RequestID);
			createRequest.openSearchPage();
			searchMyRequest.searchByRequestID(RequestID);
			searchMyRequest.openSearchRequestID(RequestID);
			adminPermissionPage.processingTheReasonforAccessingRequest();
			adminPermissionPage.verifyLockAndUnlockRequest(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 8, enabled = false)
	private void adminCSAHomePage() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminPermissionPage.openPermissionAndSwtichToAccessGridPage();
			boolean status = adminPermissionPage.changePermissionViewAllTabsonCSAHome();
			loginpage.logout();
			loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
			adminPermissionPage.verifyCSAHomePage(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 10, enabled = false)
	private void adminMergeAndDeleteCustodians() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminPermissionPage.openPermissionAndSwtichToAccessGridPage();
			boolean status = adminPermissionPage.changePermissionMergeAndDeleteRequestors();
			loginpage.logout();
			loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
			custodianStatement.searchPage();
			adminSearchPage.openListForDeletedCustodian("Automation Custodian");
			//String id=adminSearchPage.getCustodianNumber();
			adminPermissionPage.verifyMergeAndDeleteCustion(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 11, enabled = false)
	private void adminViewAndEditPermission() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminPermissionPage.openPermissionAndSwtichToAccessGridPage();
			boolean status = adminPermissionPage.changePermissionViewAndEditPermission();
			loginpage.logout();
			loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
			adminPermissionPage.verifyViewAndEditPermission(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 12, enabled = false)
	private void adminViewAuditLogInRequests() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminPermissionPage.openPermissionAndSwtichToAccessGridPage();
			boolean status = adminPermissionPage.changePermissionViewAuditLogInRequests();
			loginpage.logout();
			loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
			createRequest.selectRequestTab();
			String RequestID = createRequest.getRequestID();
			System.out.println("Request ID:- " + RequestID);
			createRequest.openSearchPage();
			searchMyRequest.searchByRequestID(RequestID);
			driver.findElement(By.xpath("//a[contains(text(),'"+RequestID+"')]")).click();
			adminPermissionPage.verifyViewAuditLogInRequests(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 13, enabled = false)
	private void adminExecutivePageRemoveRole() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminPermissionPage.openPermissionPage();
			adminPermissionPage.removeUserRole(GlobalVariables.custodianEmailStaging);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(priority = 14, enabled = true)
	private void adminExecutivePageAddPartnerRetrievalSpecialist() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminPermissionPage.openPermissionPage();
			if (adminPermissionPage.verifyUserRoleExisiting(GlobalVariables.newCustodian)) {
				if (adminPermissionPage.verifyFromAccessGrid()) {
					System.out.println("No Need to Checkbox click");
				}
				else {
					adminPermissionPage.ViewEditRetrievalDashboardCheck();
				}
				System.out.println("No Need Add");
			} else {
				
				adminPermissionPage.addUser(GlobalVariables.newCustodian, "Retrieval Specialist");
				adminPermissionPage.verifyFromAccessGrid();
			}
			loginpage.logout();
			loginpage.login(GlobalVariables.newCustodian, GlobalVariables.password);
			adminPermissionPage.verifyRetrievalSpecialist();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
