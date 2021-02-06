package com.ChartRequest.Pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Utility.TestUtil;

public class CustodianStatement extends BrowserConfiguration {

	private static final Logger log = LogManager.getLogger(CustodianStatement.class.getName());

	WebDriverWait wait = new WebDriverWait(driver, 20);
	List<String> listOfCustodian = new ArrayList<String>();
	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;
	@FindBy(xpath = "//a[contains(text(),'[adm] Search')]")
	WebElement search;
	@FindBy(xpath = "//a[@href='/company/requests']")
	WebElement requestTab;
	@FindBy(xpath = "//label[text()='Month Processed/Priced']")
	WebElement labelMonthProcessed;
	@FindBy(xpath = "//div[@id='search_status_chosen']//input[contains(@class,'chosen-search-input default')]")
	WebElement inputTypeofRequestStatus;
	@FindBy(xpath = "//input[@id='search_priced_on']")
	WebElement inputSelectMonth;
	@FindBy(xpath = "//div[@id='search_status_chosen']//input[@class='chosen-search-input default']")
	WebElement inputStatus;
	@FindBy(xpath = "//select[@id='search_approval_status']")
	WebElement custodianApprovalStatus;
	@FindBy(xpath = "//input[@name='commit']")
	WebElement searchButton;
	@FindBy(xpath = "//th[contains(text(),'Custodian')]")
	WebElement headingName;
	@FindBy(xpath = "//nav[1][@class='pagination ml20']//a[contains(text(),'Next ')]")
	WebElement noOfPages;
	@FindBy(xpath = "//div[@id='search_custodian_id_chosen']//input[contains(@class,'chosen-search-input default')]")
	WebElement inputCustodianName;
	@FindBy(xpath = "//a[@data-scroll='statements']")
	WebElement selectStatement;
	@FindBy(xpath = "//a[contains(text(),'Run Statement')]")
	WebElement buttonRunStatement;
	@FindBy(xpath = "//a[contains(text(),'Back')]")
	WebElement backButton;
	@FindBy(xpath = "//div[@id='search_custodian_id_chosen']//input[contains(@class,'chosen-search-input default')]")
	WebElement searchCustodianName;
	@FindBy(xpath = "//td[@class='word-wrap']")
	WebElement openFindCustodianName;
	@FindBy(xpath = "//div[@class='col-md-8 col-xs-12']//a[contains(text(),'Next')]")
	WebElement noOfPagesAfterSearchFoundNextButton;
	@FindBy(xpath = "//div[@id='search_service_level_chosen']//input[contains(@class,'chosen-search-input default')]")
	WebElement inputCustodianServiceLevel;

	public CustodianStatement() {

		PageFactory.initElements(driver, this);
	}

	public void searchPage() {
		System.out.println("Opening of Search Page From Admin");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(search));
		search.click();
	}

	public void searchCustodianNameFromRequestTab() {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(requestTab));
		requestTab.click();
		wait.until(ExpectedConditions.visibilityOf(labelMonthProcessed));
		inputSelectMonth.click();
		driver.findElement(By.xpath("//span[contains(text(),'" + getMonthName() + "')]")).click();
		inputTypeofRequestStatus.click();
		inputStatus.click();
		inputStatus.sendKeys("Completed");
		inputStatus.sendKeys(Keys.ENTER);
		TestUtil.hardWait(3);
		inputCustodianServiceLevel.click();
		//inputCustodianServiceLevel.sendKeys("Self-Service");
		//TestUtil.scrollToElement("Custodian Service Level");
		TestUtil.hardWait(3);
		inputCustodianServiceLevel.sendKeys(Keys.ENTER);
		TestUtil.hardWait(3);
		searchButton.click();
	}

	public void searchCustodianWithFilter(String selectTypeofCustodian) {
		System.out.println("Value of Approved Custodian");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Select approvedCustodian = new Select(custodianApprovalStatus);
		approvedCustodian.selectByVisibleText(selectTypeofCustodian);
		TestUtil.hardWait(5);
		searchButton.click();
		System.out.println("List of Approved Custodian");
	}

	public List<String> getCustodianName() {
		wait.until(ExpectedConditions.visibilityOf(headingName));
		List<WebElement> sizeOfTable = driver.findElements(By.xpath("//tbody/tr"));
		if (noOfPagesAfterSearchFoundNextButton.isDisplayed()) {
			while (noOfPagesAfterSearchFoundNextButton.isDisplayed()) {
				int a = sizeOfTable.size();
				for (int i = 1; i <= a; i++) {
					String nameofCustodian = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[6]")).getText();
					/*
					 * String nameofCustodiantemp1 = nameofCustodianTempFromUI.replaceAll("[()|]",
					 * ""); String nameofCustodiantemp = nameofCustodiantemp1.substring(1); String
					 * nameofCustodian = nameofCustodiantemp.substring(1);
					 */
					System.out.println("Name of Custodian :: " + nameofCustodian);
					listOfCustodian.add(nameofCustodian);
				}
				noOfPagesAfterSearchFoundNextButton.click();
				TestUtil.hardWait(10);
				System.out.println("List of Custodian ::" + listOfCustodian);
			}

		} else {
			int a = sizeOfTable.size();
			for (int i = 1; i <= a; i++) {
				String nameofCustodian = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[6]")).getText();
				/*
				 * String nameofCustodiantemp1 = nameofCustodianTempFromUI.replaceAll("[()|]",
				 * ""); String nameofCustodiantemp = nameofCustodiantemp1.substring(1); String
				 * nameofCustodian = nameofCustodiantemp.substring(1);
				 */
				System.out.println("Name of Custodian :: " + nameofCustodian);
				listOfCustodian.add(nameofCustodian);
			}
			System.out.println("List of Custodian ::" + listOfCustodian);
		}

		return listOfCustodian;
	}

	public void searchCustodianByName(String custodianName) {
		TestUtil.hardWait(5);
		searchCustodianName.click();
		// driver.findElement(By.partialLinkText(custodianName)).click();
		searchCustodianName.sendKeys(custodianName);
		TestUtil.hardWait(2);
		searchCustodianName.sendKeys(Keys.ENTER);
		searchButton.click();
		TestUtil.hardWait(5);
		TestUtil.scrollToElement(custodianName);
		driver.findElement(By.xpath("//a[contains(text(),'" + custodianName + "')]")).click();
		TestUtil.hardWait(10);
		executeStatementButton();
		TestUtil.hardWait(10);
		getValueOfStatament();
		TestUtil.hardWait(10);
		TestUtil.scrollToElement(backButton);
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.visibilityOf(backButton));
		TestUtil.hardWait(5);
		backButton.click();
	}

	public void executeStatementButton() {
		selectStatement.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		buttonRunStatement.click();
	}

	public void getValueOfStatament() {
		/*
		 * List<WebElement> sizeOfTable =
		 * driver.findElements(By.xpath("//div[@class='table-responsive']//tbody//tr"));
		 * int a = sizeOfTable.size(); if (a > 0) { String getStatementDetails = driver
		 * .findElement(By.xpath("//div[@class='table-responsive']//tbody//tr[" + a +
		 * "]/td")).getText(); String value = getMonthName() + "-" + getYear(); //
		 * Assert.assertEquals(getStatementDetails, value);
		 * Assert.assertNotEquals(getStatementDetails, value); }
		 */

		String actualValue = driver
				.findElement(By.xpath("//div[contains(@class,'table-responsive row-fluid')]//tbody/tr[1]/td[2]"))
				.getText();
		String value = getMonthName() + " " + getYear();
		log.trace("Value When Statemment Run ::-> " + actualValue + " Expected Value for Verification ::-> " + value);
		Assert.assertTrue(actualValue.contains(value));

	}

	public String getMonthName() {
		Calendar cal = Calendar.getInstance();
		System.out.println(new SimpleDateFormat("MMM").format(cal.getTime()));
		return new SimpleDateFormat("MMM").format(cal.getTime());
	}

	public String getYear() {
		int y = Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(y);
		return Integer.toString(y);
	}

}
