package com.ChartRequest.TestCases;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.AdminStatementOnlyPage;
import com.ChartRequest.Pages.CustodianStatement_Old;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class CutodianStatementTestcasesRestructure extends BrowserConfiguration {

	LoginPage loginpage;
	SignUpPage signUpPage;
	CustodianStatement_Old custodianStatement;
	AdminStatementOnlyPage adminStatementPage;
	List<String> cNames = Arrays.asList("AAA INTERCONNECT CARE INC.","Automation Custodian", "1st");

	@BeforeClass()
	public void openbrowser() {
		browserTearUp(GlobalVariables.productionUrl);
		//browserTearUp(GlobalVariables.preproductionUrl);
		//browserTearUp(GlobalVariables.stagingURL);
		loginpage = new LoginPage();
		signUpPage = new SignUpPage();
		String url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
		loginpage.login(GlobalVariables.prodAdminEmail, GlobalVariables.prodAdminPassword);
	}

	@Test(priority = 1, enabled = true)
	public void verifyStatement() {
		custodianStatement = new CustodianStatement_Old();
		List<String> cNames = custodianStatement.listofName();
		System.out.println("List is " + cNames);
		TestListener.infoMessage("List is " + cNames);
		for (String custodianID : cNames) {
			TestUtil.openNewTabWithURL("https://app.chartrequest.com/company/custodians/" + custodianID);
			TestUtil.hardWait(3);
			custodianStatement.searchCustodianByURL(custodianID);
			TestUtil.closeCurrentTab();
			System.out.println("*****Closed the Tab*****");

		}
	}

	@Test(priority = 2, enabled = false)
	public void verifyStatementPreProduction() {
		custodianStatement = new CustodianStatement_Old();
		// List<String> cNames = custodianStatement.listofName();
		System.out.println("List is " + cNames);
		for (String custodianID : cNames) {
			TestUtil.openNewTabWithURL("https://preproduction.chartrequest.com/company/custodians/" + custodianID);
			TestUtil.hardWait(3);
			custodianStatement.searchCustodianByURLToday(custodianID);
			TestUtil.closeCurrentTab();
			System.out.println("*****Closed the Tab*****");

		}
	}
	
	@Test(priority = 3, enabled = false)
	public void verifyStatementFromStatementPage() {
		adminStatementPage = new AdminStatementOnlyPage();
		adminStatementPage.openStatmentPage();
		// List<String> cNames = custodianStatement.listofName();
		System.out.println("List is " + cNames);
		for (String custodianName : cNames) {
			adminStatementPage.runStatementByCustodianName(custodianName);
			System.out.println("*****Verification Completed*****");

		}
	}

	@AfterClass(enabled = true)
	public void browserTearDown() {
		driver.quit();
		System.out.println("*****Closing The Window*****");

	}
}
