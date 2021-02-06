package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminBlockedFaxNumberPage;
import com.ChartRequest.Pages.AdminCSAHomePage;
import com.ChartRequest.Pages.AdminFaxQueuePage;
import com.ChartRequest.Pages.AdminSearchPage;
import com.ChartRequest.Pages.CreateRequest;
import com.ChartRequest.Pages.CustodianStatement_Old;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;

public class AdminBlockedFaxNumberPageTestCases extends BrowserConfiguration {

	LoginPage loginpage;
	SignUpPage signUpPage;
	AdminBlockedFaxNumberPage adminBlockedFaxNumberPage;
	String url, newURL;
	CreateRequest createRequest;
	AdminCSAHomePage adminCSAHomePage;

	@BeforeMethod()
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		loginpage = new LoginPage(); 
		signUpPage = new SignUpPage();
		url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
		adminBlockedFaxNumberPage = new AdminBlockedFaxNumberPage();
		createRequest = new CreateRequest();
		adminCSAHomePage=new AdminCSAHomePage();
	}

	@Test(priority = 1, enabled = true)
	private void addNumberInBlockedFaxNumberList() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminBlockedFaxNumberPage.openBlockedFaxNumberPage();
		adminBlockedFaxNumberPage.addBlockFaxNumber("1234567890");
	}
	
	@Test(priority = 2, enabled = true)
	public void unableToSendFaxFromRequestCreation() {
		loginpage.login(GlobalVariables.requestorEmailStaging, GlobalVariables.password);
		//createRequest.createNewRequest();
		//createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
		adminBlockedFaxNumberPage.sentFaxblockedNumber("1234567890");
	}
	
	@Test(priority = 3, enabled = true)
	private void sendFaxBackBlockedNumberInCSAHomePage() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminCSAHomePage.openCSAHomePage();
			adminCSAHomePage.sendFaxBack(GlobalVariables.OrganizationName,"1234567890","Automation Test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	@Test(priority = 4, enabled = true)
	private void sendFaxBackNoBlockedNumberInCSAHomePage() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			adminCSAHomePage.openCSAHomePage();
			adminCSAHomePage.sendFaxBack(GlobalVariables.OrganizationName,"1111111111","Automation Test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	

	@Test(priority = 5, enabled = true)
	public void notBlockedFaxNumberCompletedRequest() {
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		adminBlockedFaxNumberPage.sendFaxOnCompletedRequest("1111111111");
	}
	
	@Test(priority = 6, enabled = true)
	public void blockedFaxNumberCompletedRequest() {
		loginpage.login(GlobalVariables.custodianEmailStaging, GlobalVariables.password);
		adminBlockedFaxNumberPage.sendFaxOnCompletedRequest("1234567890");
	}
	
	@Test(priority = 7, enabled = true)
	private void deletedNumberInBlockedFaxNumberList() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		adminBlockedFaxNumberPage.openBlockedFaxNumberPage();
		adminBlockedFaxNumberPage.deleteBlockFaxNumber("1234567890");
	}
	
	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}