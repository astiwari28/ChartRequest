package com.ChartRequest.Pages;

import java.util.Calendar;
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
import com.ChartRequest.Utility.TestUtil;

public class AdminStatementOnlyPage extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	@FindBy(xpath = "//a[contains(text(),'[adm] Statements')]")
	WebElement dropDownStatement;

	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;

	@FindBy(xpath = "//div[@id='search_custodian_id_chosen']//input[@value='Select Some Options']")
	WebElement inputCustodianName;

	@FindBy(xpath = "//input[@value='Search']")
	WebElement buttonSearch;

	@FindBy(xpath = "//table[@class='main-table table table-condensed']/tbody/tr")
	WebElement searchResult;

	@FindBy(xpath = "//table[@class='main-table table-striped']/tbody/tr")
	WebElement searchResultRows;

	@FindBy(xpath = "//p[contains(text(),'This Custodian has no statements')]")
	WebElement verifyStatementDateText;

	@FindBy(xpath = "//a[contains(text(),'[adm] Search')]")
	WebElement search;

	@FindBy(xpath = "//select[@id='search_approval_status']")
	WebElement custodianApprovalStatus;

	@FindBy(xpath = "//a[@data-scroll='statements']")
	WebElement selectStatement;

	@FindBy(xpath = "//div[@id='search_custodian_id_chosen']//input[@value='Select Some Options']")
	WebElement enterCustodianName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement buttonSearchStatementPage;

	@FindBy(xpath = "//a[contains(text(),'Set')]")
	WebElement serchResultStatementPage;

	@FindBy(xpath = "//a[contains(text(),'Run Statement')]")
	WebElement buttonRunStatement;

	@FindBy(xpath = "//a[normalize-space()='All Statements']")
	WebElement buttonAllStatements;

	@FindBy(xpath = "//input[@id='search_when_time']")
	WebElement inputMonthProcessed;
	
	@FindBy(xpath = "//select[@id='search_revenue_share']")
	WebElement dropDownRevenueShare;
	
	@FindBy(xpath = "//a[normalize-space()='Advanced Search']")
	WebElement linkAdvanceSearch;
	
	@FindBy(xpath = "//table[@class='main-table table-striped']/tbody/tr[1]")
	WebElement advanceSearchResult;
	
	@FindBy(xpath = "//div[@id='search_service_level_chosen']//ul[@class='chosen-choices']")
	WebElement dropDownServiceLevel;
	
	@FindBy(xpath = "//input[@value='Select Service Level']")
	WebElement inputServiceLevel;
	
		public AdminStatementOnlyPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Open The Admin Drop Down and Click on the Statement Link
	 * 
	 */

	public void openStatmentPage() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
			adminDropDown.click();
			wait.until(ExpectedConditions.elementToBeClickable(dropDownStatement));
			dropDownStatement.click();
			wait.until(ExpectedConditions.elementToBeClickable(inputCustodianName));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchPage() {
		System.out.println("Opening the Admin Search Page");
		TestListener.infoMessage("Opening the Admin Search Page");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(search));
		search.click();
		wait.until(ExpectedConditions.visibilityOf(custodianApprovalStatus));
	}

	public void runStatementByCustodianName(String CustodianName) {
		TestUtil.hardWait(5);
		try {
			inputCustodianName.click();
			inputCustodianName.sendKeys(Keys.BACK_SPACE);
			inputCustodianName.sendKeys(CustodianName);
			inputCustodianName.sendKeys(Keys.ENTER);
			buttonSearch.click();
			wait.until(ExpectedConditions.visibilityOf(searchResult));
			TestListener.addDynamicScreenshotInReport("SearchResult");
			if (TestUtil.isElementDisplayed(searchResult)) {
				driver.findElement(By.xpath("//a[contains(normalize-space(),'" + CustodianName + "')]")).click();
				wait.until(ExpectedConditions.visibilityOf(selectStatement));
				executeStatementButton();
				TestUtil.hardWait(10);
				System.out.println("Wait for 10 Second");
			} else {
				System.out.println("No Search Results Found");
			}
		} catch (Exception e) {
			TestListener.infoMessageFail("Expection Occurred "+e.getStackTrace());
			e.printStackTrace();
		}
	}

	public void executeStatementButton() {
		selectStatement.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		buttonRunStatement.click();
		TestListener.infoMessage("Executing the statement button");
	}

	public void setToPaid(String CustodianName) {
		wait.until(ExpectedConditions.elementToBeClickable(enterCustodianName));
		enterCustodianName.click();
		enterCustodianName.sendKeys(CustodianName);
		enterCustodianName.sendKeys(Keys.ENTER);
		buttonSearchStatementPage.click();
		TestListener.infoMessage("Custodian Name is :- "+CustodianName);
		wait.until(ExpectedConditions.visibilityOf(serchResultStatementPage));
		serchResultStatementPage.click();
		driver.switchTo().alert().accept();
	}

	public void openPaidUserAndVerify(String CustodianName) {
		TestListener.infoMessage("Verify the Paid Custodian ");
		wait.until(ExpectedConditions.elementToBeClickable(enterCustodianName));
		enterCustodianName.click();
		enterCustodianName.sendKeys(CustodianName);
		enterCustodianName.sendKeys(Keys.ENTER);
		buttonSearchStatementPage.click();
		wait.until(ExpectedConditions.visibilityOf(serchResultStatementPage));
		int sizeofPaid = driver.findElements(By.xpath("//a[normalize-space()='Paid']")).size();
		if (sizeofPaid >= 1) {
			String value = driver.findElement(By.xpath("//a[normalize-space()='Paid']")).getAttribute("href");
			System.out.println("Value is " + value);
			TestUtil.openNewTabWithURL(value);
			wait.until(ExpectedConditions.elementToBeClickable(buttonAllStatements));
			if (TestUtil.isElementDisplayed(buttonAllStatements)) {
				System.out.println("At Statement Paid Page");
				TestListener.infoMessage("Its a Paid Custodian");
			} else {
				System.out.println("NOT At Statement Paid Page");
				TestListener.infoMessage("Its a NOT Paid Custodian");
			}
		} else {
			System.out.println("No Paid Button is Found");
			TestListener.infoMessageFail("No Paid Button is Found");
		}
	}

	public void openAdvnaceSearch() {
		wait.until(ExpectedConditions.elementToBeClickable(linkAdvanceSearch));
		linkAdvanceSearch.click();
	}

	public String getProcessingMonth() {
		String[] monthName = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		Calendar cal = Calendar.getInstance();
		String month = monthName[cal.get(Calendar.MONTH)];
		System.out.println("Month name: " + month);
		return month;
	}

	public String getProcessingYear() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		String currentYear=Integer.toString(year);
		return currentYear;
	}
	
	public void selectRevenueShare(String revenueShare) {
		Select selectSize = new Select(driver.findElement(By.name("search[revenue_share]")));
		selectSize.selectByVisibleText(revenueShare);
	}
	
	public void advanceSearchByRevenueShare(String revenueShare) {
		wait.until(ExpectedConditions.visibilityOf(dropDownRevenueShare));
		selectRevenueShare(revenueShare);
		buttonSearchStatementPage.click();
	}
	
	public void verifyAdvanceSearchResult() {
		wait.until(ExpectedConditions.visibilityOf(advanceSearchResult));
		if (TestUtil.isElementDisplayed(advanceSearchResult)) {
			System.out.println("Advance Search Result is Working");
			TestListener.infoMessage("Advance Search Result is Working");
			TestListener.addDynamicScreenshotInReport("advanceSearchResult");
		} else {
			System.out.println("Advance Search Result NOT Working");
			TestListener.infoMessage("Advance Search Result NOT Working");
			TestListener.addDynamicScreenshotInReport("advanceSearchResult");
		}
	}
	
	public void advanceSearchByCurrentCommissions(String currentCommissions) {
		wait.until(ExpectedConditions.visibilityOf(dropDownRevenueShare));
		selectCurrentCommissions(currentCommissions);
		buttonSearchStatementPage.click();
	}
	
	public void selectCurrentCommissions(String CurrentCommissions) {
		Select selectSize = new Select(driver.findElement(By.name("search[current_commissions]")));
		selectSize.selectByVisibleText(CurrentCommissions);
	}
	
	public void advanceSearchByServiceLevel(String serviceLevel) {
		wait.until(ExpectedConditions.visibilityOf(dropDownServiceLevel));
		inputServiceLevel.click();
		inputServiceLevel.sendKeys(serviceLevel);
		inputServiceLevel.sendKeys(Keys.ENTER);
		buttonSearchStatementPage.click();
		TestListener.infoMessage("Service Level is:- "+serviceLevel);
	}
}
