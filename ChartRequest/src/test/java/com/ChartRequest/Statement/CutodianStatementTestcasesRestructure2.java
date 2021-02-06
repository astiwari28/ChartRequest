package com.ChartRequest.Statement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ChartRequest.Pages.AdminStatementOnlyPage;
import com.ChartRequest.Pages.CustodianStatement_Old;
import com.ChartRequest.Pages.LoginPage;
import com.ChartRequest.Pages.SignUpPage;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CutodianStatementTestcasesRestructure2 {

	static WebDriver driver;
	LoginPage loginpage;
	SignUpPage signUpPage;
	CustodianStatement_Old custodianStatement;
	AdminStatementOnlyPage adminStatementPage;
	String url;
	List<String> cNames = Arrays.asList("39878", "40210", "41449", "41452", "41453", "41457", "42352", "44661", "47042",
			"47513", "49665", "50001", "50098", "50099", "50101", "50102", "50103", "50123", "50125", "50126", "50127",
			"50128", "50129", "50130", "50131", "50135", "50136", "50139", "50141", "50142", "50154", "50155", "50156",
			"50157", "50158", "50262", "50263", "50265", "50268", "50270", "50271", "50272", "50273", "50275", "50838",
			"51258", "53632", "53635", "54945", "55819", "56781", "57088", "57091", "57469", "58647", "60634", "60642",
			"63542", "63853", "65063", "65985", "65989", "66849", "68113", "69572", "72288", "72305", "72308", "73018",
			"73188", "73393", "74055", "74056", "74057", "74058", "74059", "74060", "74062", "74065", "74069", "74072",
			"74073", "74074", "74075", "74076", "74077", "74078", "74079", "74080", "74082", "74083", "74084", "74085",
			"74086", "74087", "74089", "74090", "74091", "74095", "74096", "74097", "74098", "74102", "74103", "74106",
			"74108", "74113", "74120", "74121", "74122", "74123", "74124", "74125", "74126", "74127", "74128", "74129",
			"74130", "74131", "74132", "74134", "74135", "74137", "74138", "74140", "74141", "74143", "74148", "74149",
			"74150", "74151", "74157", "74158", "74162", "74168", "74169", "74170", "74172", "74174", "74188", "74189",
			"74198", "74202", "74205", "74211", "74213", "74215", "74216", "74217", "74218", "74219", "74221", "74222",
			"74223", "74225", "74226", "74227", "74228", "74229", "74230", "74231", "74234", "74242", "74243", "74245",
			"74246", "74248", "74249", "74250", "74257", "74258", "74261", "74265", "74268", "74269", "74270", "74284",
			"74294", "74295", "74301", "74302", "74305", "74308", "74309", "74310", "74311", "74315", "74320", "74322",
			"74325", "74326", "74327", "74328", "74332", "74333", "74335", "74339", "74341", "74342", "74346", "74349",
			"74376", "74535", "75098", "75675", "75676", "80270", "80282", "80285", "80290", "81942", "85304", "86773",
			"87074", "88346", "88852", "88880", "89428", "89432", "89526", "92163", "101958", "101959", "103605",
			"103719", "104745", "104907", "107850", "107934", "108334");

	@BeforeClass()
	public void openbrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(GlobalVariables.productionUrl);
		// browserTearUp(GlobalVariables.preproductionUrl);
		// browserTearUp(GlobalVariables.stagingURL);
		// loginpage = new LoginPage();
		// signUpPage = new SignUpPage();
		url = driver.getCurrentUrl();
		if (url.contains("staging")) {
			driver.findElement(By.id("details-button")).click();
			driver.findElement(By.xpath("//a[text()='Proceed to staging.chartrequest.com (unsafe)']")).click();
		}
		TestUtil.hardWait(10);
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']//a[contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//input[@id='login']")).sendKeys(GlobalVariables.prodAdminEmail);
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(GlobalVariables.prodAdminPassword);
		driver.findElement(By.xpath("//button[@class='btn-login btn']")).click();
	}

	@Test(priority = 1, enabled = true)
	public void verifyStatement() {
		// List<String> cNames = custodianStatement.listofName();
		System.out.println("List is " + cNames);
		TestListener.infoMessage("List is " + cNames);
		System.out.println("Size of List is " + cNames.size());
		TestListener.infoMessage("List is " + cNames.size());
		for (String custodianID : cNames) {
			openNewTabWithURL(url + "company/custodians/" + custodianID);
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
			searchCustodianByURL(custodianID);
			closeCurrentTab();
			System.out.println("--- Test case 2---");
			System.out.println("*****Closed the Tab*****");

		}
	}

	public void searchCustodianByURL(String custodianID) {
		// wait.until(ExpectedConditions.elementToBeClickable(selectStatement));
		// System.out.println("Wait for Select Statement");
		if (getValueOfStatament()) {
			// System.out.println("Statement generated for " + custodianID);
		} else {
			if (custodianID != null) {
			}
			System.out.println("Statement Not generated for " + custodianID);
			TestListener.infoMessage("Statement Not generated for:- " + custodianID);
		}

	}

	public boolean getValueOfStatament() {
		System.out.println("Verify the Result");
		boolean flag = false;

		// boolean status=isElementDisplayed(noStatement);

		// String
		// actualValue=driver.findElement(By.xpath("//div[@class='table-responsive
		// row-fluid']/table/tbody/tr/td[2]")).getText();
		int noofRow = driver.findElements(By.xpath("//div[@class='table-responsive row-fluid']/table/tbody/tr")).size();
		// System.out.println("Actual Value is "+actualValue);
		for (int i = 1; i <= noofRow; i++) {
			String actualValue = driver
					.findElement(By.xpath("//div[@class='table-responsive row-fluid']/table/tbody/tr[" + i + "]/td[2]"))
					.getText();
			String expectedValue = getDate();
			if (actualValue.equals(expectedValue)) {
				flag = true;
				// System.out.println("Actual Value:- " + actualValue + " Expected Value:- " +
				// expectedValue);
				// System.out.println("Value found at:- " + i);
				break;
			} /*
				 * else if (isElementDisplayed(driver.findElement(By.
				 * xpath("//p[contains(text(),'This Custodian has no statements')]")))) { flag =
				 * false; continue; }
				 */else {
				flag = false;
				continue;
			}
		}
		return flag;
	}

	public static String getDate() {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		// calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		Date lastDayOfMonth = calendar.getTime();
		DateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		// System.out.println("Today : " + sdf.format(today));
		// System.out.println("Last Day of Month: " + sdf.format(lastDayOfMonth));
		return sdf.format(lastDayOfMonth);
	}

	public static void openNewTabWithURL(String URL) {
		try {
			((JavascriptExecutor) driver).executeScript("window.open('" + URL + "')");
			swtichTab(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void swtichTab(int swtichTabNo) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("No of Tabs Open: " + tabs.size());
		driver.switchTo().window(tabs.get(swtichTabNo));
	}

	public static boolean isElementDisplayed(WebElement ele) {
		boolean elementDisplayed = false;
		try {
			ele.isDisplayed();
			elementDisplayed = true;
		} catch (Exception e) {
			elementDisplayed = false;
		}
		return elementDisplayed;
	}

	public static void closeCurrentTab() {
		driver.close();
		swtichTab(0);
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

	@AfterClass(enabled = false)
	public void browserTearDown() {
		driver.quit();
		System.out.println("*****Closing The Window*****");

	}
}
