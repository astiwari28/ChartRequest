package com.ChartRequest.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.TestUtil;

public class AdminStatementPage extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 30);

	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;

	@FindBy(xpath = "//a[contains(text(),'[adm] Search')]")
	WebElement search;

	@FindBy(xpath = "//select[@id='search_approval_status']")
	WebElement custodianApprovalStatus;
	
	@FindBy(xpath = "//a[contains(@class,'pull-right btn reset-search')]")
	WebElement buttonClearAndSearch;

	@FindBy(xpath = "//div[@id='search_custodian_id_chosen']//input[contains(@class,'chosen-search-input default')]")
	WebElement inputCustodianName;

	@FindBy(xpath = "//input[@name='commit']")
	WebElement searchButton;

	@FindBy(xpath = "//*[@id='company-search-list']/div/table/tbody/tr/td[1]/a")
	WebElement searchResult;

	@FindBy(xpath = "//div[@class='alert alert-info']")
	WebElement noCustodian;
	
	@FindBy(xpath = "//a[@data-scroll='statements']")
	WebElement selectStatement;
	
	@FindBy(xpath = "//a[contains(text(),'Run Statement')]")
	WebElement buttonRunStatement;
	
	@FindBy(xpath = "//a[contains(text(),'[adm] Statements')]")
	WebElement dropDownStatement;

	@FindBy(xpath = "//input[@value='Search']")
	WebElement buttonSearch;

	@FindBy(xpath = "//table[@class='main-table table-striped']/tbody/tr")
	WebElement searchResultRows;

	@FindBy(xpath = "//p[contains(text(),'This Custodian has no statements')]")
	WebElement verifyStatementDateText;
	
	@FindBy(xpath = "//div[@id='search_custodian_id_chosen']//input[@value='Select Some Options']")
	WebElement enterCustodianName;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement buttonSearchStatementPage;
	
	@FindBy(xpath = "//tbody/tr[1]/td[3]/a[1]")
	WebElement serchResultStatementPage;
	


	public AdminStatementPage() {
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

	public void searchCustodianByName(String custodianName) {
		try {
			TestUtil.hardWait(5);
			wait.until(ExpectedConditions.elementToBeClickable(buttonClearAndSearch));
			driver.findElement(By.linkText(custodianName)).click();
			buttonClearAndSearch.click();
			TestUtil.hardWait(10);
			inputCustodianName.click();
			inputCustodianName.sendKeys(custodianName);
			inputCustodianName.sendKeys(Keys.ENTER);
			TestUtil.hardWait(5);
			wait.until(ExpectedConditions.elementToBeClickable(searchButton));
			searchButton.click();
			System.out.println("Click on Search Button");
			wait.until(ExpectedConditions.elementToBeClickable(searchResult));
			System.out.println("Wait for Search result");
			if (TestUtil.isElementDisplayed(noCustodian)) {
				buttonClearAndSearch.click();
				System.out.println("Custodian Search Not found");
			} else {
				driver.findElement(By.xpath("//a[contains(text(),'" + custodianName +"')]")).click();
				searchResult.click();
				System.out.println("Click on Search Result");
				wait.until(ExpectedConditions.elementToBeClickable(selectStatement));
				System.out.println("Wait for Select Statement");
				executeStatementButton();
				TestUtil.hardWait(10);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void executeStatementButton() {
		selectStatement.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		buttonRunStatement.click();
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
				driver.findElement(By.xpath("//a[contains(normalize-space(),'"+CustodianName+"')]")).click();
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
	

	
	public void setToPaid(String CustodianName) {
		wait.until(ExpectedConditions.elementToBeClickable(enterCustodianName));
		enterCustodianName.click();
		enterCustodianName.sendKeys(CustodianName);
		enterCustodianName.sendKeys(Keys.ENTER);
		buttonSearchStatementPage.click();
		wait.until(ExpectedConditions.visibilityOf(serchResultStatementPage));
		serchResultStatementPage.click();
		driver.switchTo().alert().accept();
	}

}
