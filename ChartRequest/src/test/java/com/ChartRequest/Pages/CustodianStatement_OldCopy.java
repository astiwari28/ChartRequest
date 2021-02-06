package com.ChartRequest.Pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class CustodianStatement_OldCopy extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	List<String> listOfCustodian = new ArrayList<String>();
	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;
	@FindBy(xpath = "//a[contains(text(),'[adm] Search')]")
	WebElement search;
	@FindBy(xpath = "//select[@id='search_approval_status']")
	WebElement custodianApprovalStatus;
	@FindBy(xpath = "//input[@name='commit']")
	WebElement searchButton;
	@FindBy(xpath = "//td[contains(text(),'Custodian Name')]")
	WebElement headingName;
	@FindBy(xpath = "//nav[1][@class='pagination ml20']//a[contains(text(),'Next ')]")
	WebElement noOfPages;
	@FindBy(xpath = "//div[@id='search_custodian_id_chosen']//input[contains(@class,'chosen-search-input default')]")
	WebElement inputCustodianName;
	@FindBy(xpath = "//input[@id='search_id']")
	WebElement inputCustodianID;
	@FindBy(xpath = "//a[@data-scroll='statements']")
	WebElement selectStatement;
	@FindBy(xpath = "//a[contains(text(),'Run Statement')]")
	WebElement buttonRunStatement;
	@FindBy(xpath = "//a[contains(text(),'Back')]")
	WebElement backButton;
	@FindBy(xpath = "//p[contains(text(),'This Custodian has no statements')]")
	WebElement verifyStatementDateText;
	@FindBy(xpath = "//h4[contains(text(),'Your session has expired!')]")
	WebElement sessionExpireText;
	@FindBy(xpath = "//a[contains(@class,'pull-right btn reset-search')]")
	WebElement buttonClearAndSearch;
	@FindBy(xpath = "//div[@class='alert alert-info']")
	WebElement noCustodian;
	@FindBy(xpath = "//*[@id='company-search-list']/div/table/tbody/tr/td[1]/a")
	WebElement searchResult;
	@FindBy(xpath = "//a[text()='Edit General Settings']")
	WebElement buttonEditGeneralSettings;
	@FindBy(xpath = "//label[contains(text(),'Enable Care Coordination')]")
	WebElement labelEnableCareCoordination;
	@FindBy(xpath = "//div[contains(@class,'form-actions')]//input[contains(@name,'commit')]")
	WebElement buttonUpdateCustodian;
	@FindBy(xpath = "//div[@id='notice']")
	WebElement confrimationMessage;
	@FindBy(xpath = "//a[contains(text(),'Create Bulk Request')]")
	WebElement dropDownBulkUpload;
	@FindBy(xpath = "//section[@id='actual_req']//tbody//tr[1]//td[2]/a")
	WebElement openFirstRequest;

	public CustodianStatement_OldCopy() {

		PageFactory.initElements(driver, this);
	}

	public void searchPage() {
		System.out.println("Opening the Admin Search Page");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(search));
		search.click();
		wait.until(ExpectedConditions.visibilityOf(custodianApprovalStatus));
	}

	public void searchCustodianWithFilter(String selectTypeofCustodian) {
		System.out.println("Value of " + selectTypeofCustodian + " Custodian");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Select approvedCustodian = new Select(custodianApprovalStatus);
		approvedCustodian.selectByVisibleText(selectTypeofCustodian);
		TestUtil.hardWait(5);
		searchButton.click();
		System.out.println("List of " + selectTypeofCustodian + " Custodian");
	}

	public List<String> getCustodianName() {
		wait.until(ExpectedConditions.visibilityOf(headingName));
		List<WebElement> sizeOfTable = driver.findElements(By.xpath("//tbody/tr"));
		int a = sizeOfTable.size();
		for (int i = 1; i <= a; i++) {
			String nameofCustodianTempFromUI = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).getText();
			String nameofCustodiantemp1 = nameofCustodianTempFromUI.replaceAll("[()|]", "");
			String nameofCustodiantemp = nameofCustodiantemp1.substring(1);
			String nameofCustodian = nameofCustodiantemp.substring(1);
			System.out.println("Name of Custodian :: " + nameofCustodian);
			listOfCustodian.add(nameofCustodian);
		}
		System.out.println("List of Custodian ::" + listOfCustodian);
		return listOfCustodian;
	}

	public void searchCustodianByName(String custodianName) {
		try {
			// TestUtil.hardWait(5);
			// wait.until(ExpectedConditions.elementToBeClickable(inputCustodianID));
			// driver.findElement(By.linkText(custodianName)).click();
			// buttonClearAndSearch.click();
			// TestUtil.hardWait(10);
			// inputCustodianName.click();
			// inputCustodianName.sendKeys(custodianName);
			// inputCustodianName.sendKeys(Keys.ENTER);
			inputCustodianID.click();
			System.out.println("Click on Input ID");
			inputCustodianID.clear();
			System.out.println("Clear Input ID");
			inputCustodianID.sendKeys(custodianName);
			System.out.println("Enter Custodian ID");

			// TestUtil.hardWait(5);
			// wait.until(ExpectedConditions.elementToBeClickable(searchButton));
			searchButton.click();
			System.out.println("Click on Search Button");
			wait.until(ExpectedConditions.elementToBeClickable(searchResult));
			System.out.println("Wait for Search result");
			if (TestUtil.isElementDisplayed(noCustodian)) {
				buttonClearAndSearch.click();
				System.out.println("Custodian Search Not found");
			} else {
				// driver.findElement(By.xpath("//a[contains(text(),'" + custodianName +
				// "')]")).click();
				searchResult.click();
				System.out.println("Click on Search Result");
				wait.until(ExpectedConditions.elementToBeClickable(selectStatement));
				System.out.println("Wait for Select Statement");
				// executeStatementButton();
				// TestUtil.hardWait(10);
				if (getValueOfStatament()) {
					System.out.println("Statement generated for " + custodianName);
				} else {
					if (custodianName != null) {
					}
					System.out.println("Statement Not generated for " + custodianName);
					TestListener.infoMessage("Statement Not generated for:- " + custodianName);
				}
				// TestUtil.hardWait(10);
				// TestUtil.scrollToElement(backButton);
				// wait.until(ExpectedConditions.visibilityOf(backButton));
				backButton.click();
				System.out.println("Click on Back Button");
				// TestUtil.hardWait(10);
				wait.until(ExpectedConditions.elementToBeClickable(searchButton));
				System.out.println("Search button found on Custodian ID Page");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void executeStatementButton() {
		selectStatement.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// buttonRunStatement.click();
	}

	public boolean waitForStatementButton() {
		wait.until(ExpectedConditions.elementToBeClickable(selectStatement));
		boolean flag = false;
		if (TestUtil.isElementDisplayed(selectStatement)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean getValueOfStatament() {
		System.out.println("Verify the Result");
		boolean flag = false;
		if (TestUtil.isElementDisplayed(verifyStatementDateText)) {
			flag = false;
		} else {
			try {
				// String actualValue
				// =driver.findElement(By.xpath("//div[@class='table-responsive
				// row-fluid']/table/tbody/tr/td[2]")).getText();
				int noofRow = driver.findElements(By.xpath("//div[@class='table-responsive row-fluid']/table/tbody/tr"))
						.size();
				// System.out.println("Actual Value is "+actualValue);
				for (int i = 1; i <= noofRow; i++) {
					String actualValue = driver
							.findElement(By.xpath(
									"//div[@class='table-responsive row-fluid']/table/tbody/tr[" + i + "]/td[2]"))
							.getText();
					// String expectedValue = CustodianStatement_OldCopy.getDate();
					String expectedValue = "30 Sep 2020";
					if (actualValue.equals(expectedValue)) {
						flag = true;
						System.out.println("Actual Value:- " + actualValue + " Expected Value:- " + expectedValue);
						System.out.println("Value found at:- " + i);
						break;
					} else if (TestUtil.isElementDisplayed(verifyStatementDateText)) {
						flag = false;
						continue;
					} else {
						flag = false;
						continue;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	public boolean getValueOfStatamentTodayDate() {
		System.out.println("Verify the Result");
		boolean flag = false;
		if (TestUtil.isElementDisplayed(verifyStatementDateText)) {
			flag = false;
		} else {
			try {
				// String actualValue
				// =driver.findElement(By.xpath("//div[@class='table-responsive
				// row-fluid']/table/tbody/tr/td[2]")).getText();
				int noofRow = driver.findElements(By.xpath("//div[@class='table-responsive row-fluid']/table/tbody/tr"))
						.size();
				// System.out.println("Actual Value is "+actualValue);
				for (int i = 1; i <= noofRow; i++) {
					String actualValue = driver
							.findElement(By.xpath(
									"//div[@class='table-responsive row-fluid']/table/tbody/tr[" + i + "]/td[2]"))
							.getText();
					String expectedValue = CustodianStatement_OldCopy.getTodayDate();
					if (actualValue.equals(expectedValue)) {
						flag = true;
						System.out.println("Actual Value:- " + actualValue + " Expected Value:- " + expectedValue);
						System.out.println("Value found at:- " + i);
						break;
					} else if (TestUtil.isElementDisplayed(verifyStatementDateText)) {
						flag = false;
						continue;
					} else {
						flag = false;
						continue;
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	public String getMonthName() {
		Calendar cal = Calendar.getInstance();
		// System.out.println(new SimpleDateFormat("MMM").format(cal.getTime()));
		return new SimpleDateFormat("MMM").format(cal.getTime());
	}

	public String getYear() {
		int y = Calendar.getInstance().get(Calendar.YEAR);
		// System.out.println(y);
		return Integer.toString(y);
	}

	public List<String> listofName() {

		String previousMonthStartDate = CustodianStatement_OldCopy.getFirstDateofthePreviousMonth();
		String previousMonthEndDate = CustodianStatement_OldCopy.getLastDateofthePreviousMonth();
		Connection c = null;
		Statement stmt = null;
		List<String> listofName = new ArrayList<String>();
		try {
			Class.forName("org.postgresql.Driver");
			// c =
			// DriverManager.getConnection("jdbc:postgresql://localhost.aptible.in:45293/db",
			// "aptible","gAQC_kwP980NYI-DEhlYF7DAuz-o21P-");
			c = DriverManager.getConnection(
					"jdbc:postgresql://" + GlobalVariables.productionHostName + ":" + GlobalVariables.productionPortNo
							+ "/" + GlobalVariables.productionDatabaseName,
					GlobalVariables.productionUserName, GlobalVariables.productionDBPassword);

			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT DISTINCT organizations.id FROM \"organizations\" INNER JOIN \"requests\" ON \"requests\".\"custodian_id\" = \"organizations\".\"id\" WHERE \"organizations\".\"type\" IN ('Custodian') AND (requests.status IN ('completed') AND requests.is_referral='f' AND date(requests.ordered_on) >= '09/01/2020' AND date(requests.ordered_on) <= '09/30/2020' AND organizations.approved_at is not null AND (organizations.is_demo = false or organizations.is_demo IS NULL)) ORDER BY organizations.id");
			while (rs.next()) {
				String name = rs.getString(1);
				System.out.println("Name is " + name);
				listofName.add(name);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Operation done successfully" + listofName);
		return listofName;
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

	public static String getTodayDate() {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		// calendar.setTime(today);
		// calendar.add(Calendar.MONTH, 1);
		// calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		Date todayDateOfMonth = calendar.getTime();
		DateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		// System.out.println("Today : " + sdf.format(today));
		// System.out.println("Last Day of Month: " + sdf.format(lastDayOfMonth));
		// System.out.println("Yesterday Date : " + sdf.format(today));
		return sdf.format(todayDateOfMonth);
	}

	public void searchCustodianByURL(String custodianID) {
		// wait.until(ExpectedConditions.elementToBeClickable(selectStatement));
		// System.out.println("Wait for Select Statement");
		try {
			if (getValueOfStatament()) {
				System.out.println("Statement generated for " + custodianID);
			} else {
				if (custodianID != null) {
				}
				System.out.println("Statement Not generated for " + custodianID);
				TestListener.infoMessage("Statement Not generated for:- " + custodianID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchCustodianByURLToday(String custodianID) {
		// wait.until(ExpectedConditions.elementToBeClickable(selectStatement));
		// System.out.println("Wait for Select Statement");
		try {
			if (getValueOfStatamentTodayDate()) {
				System.out.println("Statement generated for " + custodianID);
			} else {
				if (custodianID != null) {
				}
				System.out.println("Statement Not generated for " + custodianID);
				TestListener.infoMessage("Statement Not generated for:- " + custodianID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchCustodianAndRemoveCareCordination(String custodianName) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(inputCustodianID));
			inputCustodianID.click();
			System.out.println("Click on Input ID");
			inputCustodianID.clear();
			System.out.println("Clear Input ID");
			inputCustodianID.sendKeys(custodianName);
			System.out.println("Enter Custodian ID");

			searchButton.click();
			System.out.println("Click on Search Button");
			wait.until(ExpectedConditions.elementToBeClickable(searchResult));
			System.out.println("Wait for Search result");
			if (TestUtil.isElementDisplayed(noCustodian)) {
				buttonClearAndSearch.click();
				System.out.println("Custodian Search Not found");
			} else {
				searchResult.click();
				System.out.println("Click on Search Result");
				wait.until(ExpectedConditions.elementToBeClickable(selectStatement));
				System.out.println("Wait for Select Statement");
				buttonEditGeneralSettings.click();
				wait.until(ExpectedConditions.elementToBeClickable(labelEnableCareCoordination));
				labelEnableCareCoordination.click();
				buttonUpdateCustodian.click();
				wait.until(ExpectedConditions.visibilityOf(confrimationMessage));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getFirstDateofthePreviousMonth() {
		DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.add(Calendar.DAY_OF_MONTH, -1);
		Date lastDateOfPreviousMonth = aCalendar.getTime();
		aCalendar.set(Calendar.DATE, 1);
		Date firstDateOfPreviousMonth = aCalendar.getTime();
		sdf.format(firstDateOfPreviousMonth);
		return (sdf.format(firstDateOfPreviousMonth));
	}

	public static String getLastDateofthePreviousMonth() {
		DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.set(Calendar.DATE, 1);
		aCalendar.add(Calendar.DAY_OF_MONTH, -1);
		Date lastDateOfPreviousMonth = aCalendar.getTime();
		aCalendar.set(Calendar.DATE, 1);
		Date firstDateOfPreviousMonth = aCalendar.getTime();
		sdf.format(firstDateOfPreviousMonth);
		return (sdf.format(lastDateOfPreviousMonth));
	}

	public void clickBulkUpload() {
		System.out.println("Searching for Bulk");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(dropDownBulkUpload));
		search.click();
		wait.until(ExpectedConditions.elementToBeClickable(custodianApprovalStatus));
	}

	public boolean verifyBulkUploadButton() {
		System.out.println("Searching for Bulk");
		TestListener.infoMessage("Verify Bulk Button is present or not");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		boolean status = TestUtil.isElementDisplayed(dropDownBulkUpload);
		adminDropDown.click();
		return status;
	}

	public void searchAndOpenByCustodianNameFirstRequest(String CustodianName) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(inputCustodianName));
		inputCustodianName.click();
		inputCustodianName.sendKeys(CustodianName);
		inputCustodianName.sendKeys(Keys.ENTER);
		searchButton.click();
		TestListener.infoMessage("Search Custodian Name is:- " + CustodianName);
		wait.until(ExpectedConditions.elementToBeClickable(searchResult));
		searchResult.click();
		wait.until(ExpectedConditions.elementToBeClickable(openFirstRequest));
		openFirstRequest.click();
		TestListener.infoMessage("Open the Request");
	}

	public void searchAndOpenByCustodianName(String CustodianName) {
		TestUtil.hardWait(5);
		TestListener.infoMessage("Open and Search By Custodian Name");
		wait.until(ExpectedConditions.elementToBeClickable(inputCustodianName));
		inputCustodianName.click();
		inputCustodianName.sendKeys(CustodianName);
		inputCustodianName.sendKeys(Keys.ENTER);
		searchButton.click();
		TestListener.infoMessage("Searching for Custodian Name " + CustodianName);
		wait.until(ExpectedConditions.elementToBeClickable(searchResult));
		searchResult.click();
	}
}
