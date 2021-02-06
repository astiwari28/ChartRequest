package com.ChartRequest.TestCases;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.CreateRequest;
import com.ChartRequest.Pages.CustodianStatement_Old;
import com.ChartRequest.Pages.EMRCredentialsPage;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class EMRCredentialsPageTestCases extends BrowserConfiguration{

	LoginPage loginpage;
	SignUpPage signUpPage;
	CustodianStatement_Old custodianStatement;
	EMRCredentialsPage emrCredentialsPage;
	String url, newURL;
	CreateRequest createRequest;

	@BeforeMethod()
	public void openbrowser() {
		browserTearUp(GlobalVariables.URL);
		loginpage = new LoginPage();
		signUpPage = new SignUpPage();
		url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
		emrCredentialsPage = new EMRCredentialsPage();
		custodianStatement=new CustodianStatement_Old();
		createRequest = new CreateRequest();
	}
	
	@Test(priority = 1, enabled = true)
	private void addEMRCredentials() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
		emrCredentialsPage.addEMRUser();
		emrCredentialsPage.addCredentials(true,"APM", "11/17/2020","www.google.com", "testing", "password", "Testing");
	}
	
	@Test(priority = 2, enabled = true)
	public void verifyNewSavedDetailsEMR() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
		emrCredentialsPage.addEMRUser();
		emrCredentialsPage.editDetails("APM", "www.yahoo.com", "Changed Notes");
		emrCredentialsPage.verifyNewDetailsSavedEMR("APM", "www.yahoo.com","Changed Notes");
	}
	
	@Test(priority = 3, enabled = true)
	private void deleteEMRCredentials() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
		emrCredentialsPage.addEMRUser();
		emrCredentialsPage.deleteEMRCredentials("APM");
	}
	
	@Test(priority = 4, enabled = true)
	public void verifyEMRAccessClickableRequestCreation() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
		emrCredentialsPage.addEMRUser();
		List<String> listofRecords=emrCredentialsPage.getSystemOfRecords();
		loginpage.logout();
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		//createRequest.changeCustodianToRequestor();
		createRequest.createNewRequest();
		emrCredentialsPage.verifyEMRAccessClickable();
		TestUtil.hardWait(5);
		List<String> listofRecordsFromEMR=emrCredentialsPage.getSystemOfRecordsFromEMRAccess();
		emrCredentialsPage.verifyList(listofRecords, listofRecordsFromEMR);
	}
	
	@Test(priority = 5, enabled = true)
	private void addVPNCredentials() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
		emrCredentialsPage.addVpnUser();
		emrCredentialsPage.addCredentials(false,"VPN1", "11/17/2020","www.google.com", "testing", "password", "Testing");
	}
	
	@Test(priority = 6, enabled = true)
	public void verifyNewSavedDetailsVPN() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
		emrCredentialsPage.addVpnUser();
		emrCredentialsPage.editDetails("VPN1", "www.yahoo.com", "Changed Notes");
		//emrCredentialsPage.addVpnUser();
		emrCredentialsPage.verifyNewDetailsSavedVPN("VPN1", "www.yahoo.com","Changed Notes");
	}
	
	@Test(priority = 7, enabled = true)
	private void deleteVPNCredentials() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
		emrCredentialsPage.addVpnUser();
		emrCredentialsPage.deleteEMRCredentials("VPN1");
	}
	
	@Test(priority = 8, enabled = true)
	public void verifyHeading() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		//emrCredentialsPage.getOrganizationName();
		custodianStatement.searchPage();
		custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
		emrCredentialsPage.addEMRUser();
		emrCredentialsPage.verifyHeading(GlobalVariables.OrganizationName);
	}
	
	@Test(priority = 9, enabled = false)
	public void verifySystemofRecordsFromEMRDropDown() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
		emrCredentialsPage.addEMRUser();
		List<String> nameFromEMRDropDown=emrCredentialsPage.getlistFromDropEMR();
		List<String> cNames = emrCredentialsPage.listofUserFromDB();
		emrCredentialsPage.verifyEMRandDB(cNames,nameFromEMRDropDown);
		
	}
	
	@Test(priority = 10, enabled = false)
	public void verifySystemofRecordsFromVPNDropDown() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
		emrCredentialsPage.addVpnUser();
		List<String> nameFromEMRDropDown=emrCredentialsPage.getlistFromDropVPN();
		List<String> cNames = emrCredentialsPage.listofUserFromDB();
		emrCredentialsPage.verifyEMRandDB(cNames,nameFromEMRDropDown);
	}
	
	@Test(priority = 11, enabled = true)
	public void backToCustodianPageFromEMRPage() {
		loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
		custodianStatement.searchPage();
		custodianStatement.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
		emrCredentialsPage.addEMRUser();
		emrCredentialsPage.backToCustodianPage();
	}
	
	
	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
