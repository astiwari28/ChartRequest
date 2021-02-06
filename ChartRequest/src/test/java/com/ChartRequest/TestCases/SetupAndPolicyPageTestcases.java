package com.ChartRequest.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.CreateRequest;
import com.ChartRequest.Pages.CustodianStatement;
import com.ChartRequest.Pages.CustodianStatement_Old;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SetupAndPolicyPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class SetupAndPolicyPageTestcases extends BrowserConfiguration {

	LoginPage loginpage;
	SignUpPage signUpPage;
	CustodianStatement custodianStatement;
	CustodianStatement_Old custodianStatement_Old;
	SetupAndPolicyPage setupAndPolicyPage;
	CreateRequest createRequest;

	public SetupAndPolicyPageTestcases() {
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
		custodianStatement = new CustodianStatement();
		custodianStatement_Old = new CustodianStatement_Old();
		setupAndPolicyPage = new SetupAndPolicyPage();
		createRequest = new CreateRequest();
	}

	@Test(priority = 1, enabled = true)
	private void editServiceYouOffer() {
		try {
			loginpage.login(GlobalVariables.adminEmail, GlobalVariables.adminPassword);
			custodianStatement.searchPage();
			custodianStatement_Old.searchAndOpenByCustodianName(GlobalVariables.OrganizationName);
			setupAndPolicyPage.openEditServiceAndPolicyPage();
			String PriceInstantDownload =TestUtil.getRandomNumericString(3);
			String PriceFaxReturn =TestUtil.getRandomNumericString(3);
			String PriceAffidavit=TestUtil.getRandomNumericString(3);
			setupAndPolicyPage.changePrice(PriceInstantDownload, PriceFaxReturn, PriceAffidavit);
			loginpage.logout();
			loginpage.login(GlobalVariables.patientEmailStaging, GlobalVariables.password);
			createRequest.createNewRequest();
			createRequest.selectStateForRequestCreation(GlobalVariables.selectState, GlobalVariables.OrganizationName);
			setupAndPolicyPage.getPriceInstantDownload();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
