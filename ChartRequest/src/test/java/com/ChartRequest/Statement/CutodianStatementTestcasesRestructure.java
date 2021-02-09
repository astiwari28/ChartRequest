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

public class CutodianStatementTestcasesRestructure {

	static WebDriver driver;
	LoginPage loginpage;
	SignUpPage signUpPage;
	CustodianStatement_Old custodianStatement;
	AdminStatementOnlyPage adminStatementPage;
	String url;
	List<String> cNames = Arrays.asList("1265", "1363", "1523", "2308", "3250", "3341", "3555", "4827", "6095", "6397",
			"6446", "8934", "9182", "9550", "10963", "10965", "10966", "11066", "11289", "11865", "12760", "13240",
			"13252", "13445", "13447", "13503", "13737", "13739", "13742", "13743", "13838", "14044", "14046", "14048",
			"14467", "15966", "16004", "16006", "16007", "16009", "16011", "16012", "16015", "16016", "16123", "16216",
			"16235", "16249", "16250", "16333", "16342", "16375", "16480", "16488", "16493", "16601", "16607", "16727",
			"16766", "16779", "16850", "16860", "16861", "16871", "16917", "16927", "16945", "17004", "17005", "17006",
			"17007", "17008", "17009", "17011", "17017", "17018", "17031", "17125", "17126", "17129", "17254", "17255",
			"17256", "17257", "17259", "17532", "17533", "17534", "17535", "17538", "17539", "17540", "17562", "17570",
			"17632", "17633", "17634", "17635", "17637", "17640", "17641", "17642", "17645", "17646", "17647", "17672",
			"17689", "17827", "17829", "17944", "17945", "17946", "17947", "17948", "18107", "18111", "18113", "18195",
			"18294", "18298", "18306", "18308", "18313", "18315", "18318", "18347", "18614", "18640", "18641", "18651",
			"18788", "18789", "18790", "18792", "18814", "18934", "18960", "19054", "19091", "19100", "19104", "19106",
			"19108", "19109", "19110", "19111", "19115", "19124", "19140", "19146", "19251", "19272", "19275", "19281",
			"19284", "19294", "19414", "19435", "19436", "19439", "19441", "19442", "19443", "19444", "19445", "19461",
			"19471", "19474", "19481", "19525", "19678", "19705", "20014", "20038", "20041", "20078", "20202", "20310",
			"20608", "20656", "20687", "20704", "20720", "20727", "20734", "20761", "20790", "20805", "20834", "20835",
			"20844", "20845", "20846", "20849", "20850", "20875", "21301", "21303", "21580", "21582", "21613", "21917",
			"22283", "22680", "22801", "23159", "23206", "23210", "23492", "24238", "24919", "25276", "25669", "27130",
			"28099", "28201", "29733", "29936", "30622", "31200", "31938", "35582", "36007", "36413", "36716", "38539",
			"38554", "38557", "38562", "39878", "40210");

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
		System.out.println("Current URL:- " + url);
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
		try {

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
				System.out.println("--- Test case 1---");
				System.out.println("*****Closed the Tab*****");

			}

		} catch (Exception e) {
			e.printStackTrace();
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
