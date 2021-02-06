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
import org.openqa.selenium.JavascriptExecutor;
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

public class CustodianStatement_Old extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	JavascriptExecutor js = (JavascriptExecutor) driver;
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
	
//	@FindBy(xpath = "//a[@title='Add Custodian Flag']")
	@FindBy(xpath = "//a[normalize-space()='[Add Flag Name]']")
	WebElement linkAddNewFlag;
	
	@FindBy(xpath = "//div[@class='modal-header']/h4/span[normalize-space()='Add']")
	WebElement headingAddNewFlagModule;
	
	@FindBy(xpath = "//input[@id='create_flag_name']")
	WebElement inputFlagName;
	
	@FindBy(xpath = "//button[@id='create_flag_save_btn']")
	WebElement buttonSaveFlagName;
	
	@FindBy(xpath = "//textarea[@id='flag_note']")
	WebElement textAreaFlagNote;
	
	@FindBy(xpath = "//input[@id='is_recurring']")
	WebElement checkboxFlagRecurring;
	
	@FindBy(xpath = "//input[@id='flag_expire']")
	WebElement inputFlagExpire;
	
	@FindBy(xpath = "//input[@value='Save']")
	WebElement buttonSaveFlag;
	
	//@FindBy(xpath = "//span[@id='available_custodian']")
	@FindBy(xpath = "//div[contains(@class,'row-fluid')]/div/ul/span[contains(text(),'Available requests')]")
	WebElement headingAvailableRequests;
	
	@FindBy(xpath = "//a[@class='btn dropdown-toggle btn-trans requestor-dropdown']")
	WebElement userName;
	
	@FindBy(xpath = "//table[contains(@class,'main-table table')]/tbody/tr[1]/td[3]")
	WebElement requestIDInCustodian;
	
	@FindBy(xpath = "//table[contains(@class,'main-table table')]/tbody/tr[1]/td[2]/a")
	WebElement requestIDInRequestor;
	
	@FindBy(xpath = "//h4[contains(text(),'Reason for Accessing Request')]")
	WebElement headingforProcessing;

	@FindBy(xpath = "//label[contains(text(),'Processing')]")
	WebElement labelForProcessing;
	
	@FindBy(xpath = "//div[@class='alert alert-info cust-flag-info']")
	WebElement flagValueVerify;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'Search Requestors')]")
	WebElement adminTabSearchRequestor;
	
	@FindBy(xpath = "//input[@id='search_email']")
	WebElement inputRequestEmailID;
	
	@FindBy(xpath = "//input[contains(@value,'Search')]")
	WebElement buttonSearch;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'Search Users')]")
	WebElement adminTabSearchUsers;
	
	public CustodianStatement_Old() {
		PageFactory.initElements(driver, this);
	}

	public void searchPage() {
		TestUtil.hardWait(5);
		System.out.println("Opening the Admin Search Page");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(search));
		search.click();
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.visibilityOf(custodianApprovalStatus));
	}

	public void searchCustodianWithFilter(String selectTypeofCustodian) {
		System.out.println("Value of "+selectTypeofCustodian+" Custodian");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Select approvedCustodian = new Select(custodianApprovalStatus);
		approvedCustodian.selectByVisibleText(selectTypeofCustodian);
		TestUtil.hardWait(5);
		searchButton.click();
		System.out.println("List of "+selectTypeofCustodian+" Custodian");
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
					String expectedValue = CustodianStatement_Old.getDate();
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
					String expectedValue = CustodianStatement_Old.getTodayDate();
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

		String previousMonthStartDate = CustodianStatement_Old.getFirstDateofthePreviousMonth();
		String previousMonthEndDate = CustodianStatement_Old.getLastDateofthePreviousMonth();
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
					" SELECT distinct organizations.id FROM \"organizations\" INNER JOIN \"requests\" ON \"requests\".\"custodian_id\" = \"organizations\".\"id\" WHERE \"organizations\".\"type\" IN ('Custodian') AND (requests.status IN ('completed') AND requests.is_referral='f'AND date(requests.ordered_on) >= '"
							+ previousMonthStartDate + "' AND date(requests.ordered_on) <= '" + previousMonthEndDate
							+ "' AND organizations.approved_at is not null AND (organizations.is_demo = false or organizations.is_demo IS NULL))");
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
		//calendar.setTime(today);
		// calendar.add(Calendar.MONTH, 1);
		//calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		Date todayDateOfMonth = calendar.getTime();
		DateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		// System.out.println("Today : " + sdf.format(today));
		// System.out.println("Last Day of Month: " + sdf.format(lastDayOfMonth));
		//System.out.println("Yesterday Date : " + sdf.format(today));
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

	public void searchCustodianAndEnableDisableCareCordination(String custodianName) {
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
		TestListener.infoMessage("Search Custodian Name is:- "+CustodianName);
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
		TestUtil.hardWait(5);
		TestListener.infoMessage("Searching for Custodian Name "+CustodianName);
		wait.until(ExpectedConditions.elementToBeClickable(searchResult));
		searchResult.click();
		TestUtil.hardWait(5);
	}
	/**
	 * @author ashutosh.tiwari
	 * @Description Add New Flag
	 * @since November 14 2020
	 * */
	public void addNewFlag(String FlagType, String FlagName,String FlagNote, boolean Recurring) {
		wait.until(ExpectedConditions.elementToBeClickable(linkAddNewFlag));
		linkAddNewFlag.click();
		wait.until(ExpectedConditions.visibilityOf(headingAddNewFlagModule));
		selectTypeFlag(FlagType);
		if (FlagType.contains("Create")) {
			wait.until(ExpectedConditions.visibilityOf(inputFlagName));
			inputFlagName.sendKeys(FlagName);
			buttonSaveFlagName.click();
		}
		selectTypeFlag(FlagName);
		System.out.println("Flag Name is:- "+FlagName);
		wait.until(ExpectedConditions.visibilityOf(textAreaFlagNote));
		textAreaFlagNote.sendKeys(FlagNote);
		System.out.println("Flag Note is:- "+FlagNote);
		if (Recurring) {
			checkboxFlagRecurring.click();
		} else {
			inputFlagExpire.click();
			inputFlagExpire.sendKeys(Keys.ENTER);
		}
		buttonSaveFlag.click();
	}
	
	public void selectTypeFlag(String FlagName) {
		Select selectFlagName= new Select(driver.findElement(By.name("flag_name")));
		if (FlagName.contains("Create")) {
			selectFlagName.selectByValue("create_flag");
		} else {
			selectFlagName.selectByVisibleText(FlagName);
		}
	}
	
	public void verifyFlagStatus() {
		wait.until(ExpectedConditions.visibilityOf(confrimationMessage));
		if (TestUtil.isElementDisplayed(confrimationMessage)) {
			String tempMessage=confrimationMessage.getText();
			if (tempMessage.contains("Flag has set Successfully")) {
				//Custodian Flag has set Successfully
				System.out.println("Flag has set Successfully");
			} else if (tempMessage.contains("Flag has deleted Successfully")) {
				//Custodian Flag has deleted Successfully
				System.out.println("Flag has deleted Successfully");
			}else{
				System.out.println("No Flag Status");
			}
		} else {
			System.out.println("Flag Status Not Set");
		}
	}
	
	public void deleteFlagCustodian(String FlagName) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(linkAddNewFlag));
		driver.findElement(By.xpath("//span[normalize-space()='"+FlagName+"']/ancestor::tr//span[@class='pull-left']/a")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	public void deleteFlagRequestor(String FlagName) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(linkAddNewFlag));
		driver.findElement(By.xpath("//span[normalize-space()='"+FlagName+"']/ancestor::tr//span[@class='pull-right']/a")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	public void verifyFlagStatusFromRequestForCustodian(String noteValue) {
		wait.until(ExpectedConditions.elementToBeClickable(headingAvailableRequests));
		requestIDInCustodian.click();
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);
		wait.until(ExpectedConditions.visibilityOf(flagValueVerify));
		String tempValue=flagValueVerify.getText();
		if (tempValue.contains(noteValue)) {
			System.out.println("Flag Matched Successfully");
		} else {
			System.out.println("Flag NOT-Matched Un-Successfully");
		}
	}
	
	public void searchAndOpenByRequestorEmail(String RequestorEmail) {
		TestUtil.hardWait(5);
		TestListener.infoMessage("Open and Search By Requestor Email");
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchRequestor.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputRequestEmailID));
		inputRequestEmailID.sendKeys(RequestorEmail);
		buttonSearch.click();
		TestUtil.hardWait(5);
		TestListener.infoMessage("Searching for Requestor Email "+RequestorEmail);
		wait.until(ExpectedConditions.elementToBeClickable(searchResult));
		searchResult.click();
	}
	
	public void verifyFlagStatusFromRequestForRequestor(String noteValue) {
		driver.findElement(By.xpath("//table[@class='main-table table-striped table-condensed']/tbody/tr/td[4]/a[contains(text(),'pending')]")).click();
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);
		wait.until(ExpectedConditions.visibilityOf(flagValueVerify));
		String tempValue=flagValueVerify.getText();
		if (tempValue.contains(noteValue)) {
			System.out.println("Flag Matched Successfully");
		} else {
			System.out.println("Flag NOT-Matched Un-Successfully");
		}
	}
}
