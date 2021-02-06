package com.ChartRequest.TestCases;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Pages.CustodianStatement_Old;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Utility.GlobalVariables;

public class CutodianStatementTestcases extends BrowserConfiguration {
	
	LoginPage loginpage;
	SignUpPage signUpPage;
	CustodianStatement_Old custodianStatement;
	/*List<String> cNames = Arrays.asList("16016", "6446", "50270", "38539", "4827", "6397", "19439", "41452", "41453",
			"14046", "41457", "50126", "21613", "36716", "18960", "25276", "28201", "14048", "14044", "50128", "29936",
			"19436", "63853", "50098", "8934", "65989", "17634", "50271", "50272", "13240", "72288", "85307", "74325",
			"29733", "50265", "74101", "20041", "41449", "57091", "17539", "39878", "74075", "55819", "11865", "74086",
			"72305", "3250", "57469", "80270", "38562", "19444", "75098", "13838", "20734", "16216", "74535", "19471",
			"18313", "20038", "17689", "19678", "6095", "68113", "22801", "13743", "20078", "21301", "19124", "19146",
			"74240", "31938", "10965", "18792", "74331", "72308", "74202", "50142", "87074", "17632", "74309", "20834",
			"50103", "74376", "23769", "19414", "18315", "14467", "51258", "20014", "17538", "74269", "18308", "19104",
			"28099", "19110", "74073", "17829", "19115", "24238", "21580", "18294", "20202", "50275", "19111", "19100",
			"47042", "74076", "19443", "19284", "17672", "20720", "18306", "18651", "17540", "74227", "10963", "19481",
			"17643", "19251", "30622", "20704", "74078", "53632", "74138", "50130", "74338", "19441");*/

	@BeforeClass()
	public void openbrowser() {
		browserTearUp(GlobalVariables.productionUrl);
		loginpage = new LoginPage();
		signUpPage = new SignUpPage();
		String url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			signUpPage.openApplicationURL();
		}
	}

	@Test(priority = 1)
	public void verifyStatement() {
		try {
			loginpage.login(GlobalVariables.prodAdminEmail, GlobalVariables.prodAdminPassword);
			custodianStatement = new CustodianStatement_Old();
			custodianStatement.searchPage();

			// custodianStatement.searchCustodianWithFilter("Approved");
			List<String> cNames = custodianStatement.listofName();
			System.out.println("List is " + cNames);

			for (String names : cNames) {
				System.out.println("Custodian Name is: " + names);
				custodianStatement.searchCustodianByName(names);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass(enabled = true)
	public void browserTearDown() {
		driver.quit();
	}
}
