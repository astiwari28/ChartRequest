package com.ChartRequest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.TestUtil;

public class SearchMyRequest extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 20);

	public SearchMyRequest() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='search_id_equals']")
	WebElement inputRequestID;

	@FindBy(xpath = "//input[@id='search_with_patient_by_name']")
	WebElement inputPatientName;

	@FindBy(xpath = "//div[@id='search_status_in_chosen']//input[contains(@class,'chosen-search-input default')]")
	WebElement inputStatus;

	@FindBy(xpath = "//input[@id='search_custodian_name_contains']")
	WebElement inputProviderName;

	@FindBy(xpath = "//input[@value='Search']")
	WebElement buttonSearch;

	@FindBy(xpath = "//a[@class='no-wrap-id']")
	WebElement searchResult;

	@FindBy(xpath = "//tr[1]//td[3]")
	WebElement patientNameResult;

	@FindBy(xpath = "//th[contains(text(),'Patient Name')]/following::td[4]")
	WebElement patientNameResultCustodian;

	@FindBy(xpath = "//tr[1]//td[2]")
	WebElement statusResult;

	@FindBy(xpath = "//th[contains(text(),'Status')]/following::td[3]")
	WebElement statusResultCustodian;

	@FindBy(xpath = "//tr[1]//td[6]")
	WebElement providerResult;

	@FindBy(xpath = "//th[contains(text(),'Custodian Name')]/following::td[7]")
	WebElement providerResultCustodian;

	@FindBy(xpath = "//a[@class='btn dropdown-toggle btn-trans requestor-dropdown']")
	WebElement nameoFtheUser;

	@FindBy(xpath = "//div[@id='search_reason_for_request_in_chosen']//input[@class='chosen-search-input default']")
	WebElement inputReasonOfRequest;

	@FindBy(xpath = "//th[contains(text(),'Custodian Name')]/following::td[10]")
	WebElement providerResultCustodianAccount;

	@FindBy(xpath = "//label[text()='Requestor Name']/following-sibling::input")
	WebElement inputRequestorName;

	@FindBy(xpath = "//th[contains(text(),'Custodian Name')]/following::td[6]")
	WebElement searchResultRequestorName;
	
	@FindBys(@FindBy(xpath = "//body/div[5]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[8]/a[1]"))
	WebElement getLast;
	
	@FindBy(xpath = "//table[@class='main-table table-striped table-condensed']/tbody")
	WebElement visibilityOfTable;
	
	@FindBy(xpath = "//h4[contains(text(),'Reason for Accessing Request')]")
	WebElement reasonForAccessingRequest;
	
	
	public void searchByRequestID(String RequestID) {
		wait.until(ExpectedConditions.elementToBeClickable(inputRequestID));
		inputRequestID.click();
		inputRequestID.sendKeys(RequestID);
		TestListener.infoMessage("Request Id:- " + RequestID);
		buttonSearch.click();
		wait.until(ExpectedConditions.visibilityOf(searchResult));
		String expectedResult = searchResult.getText();
		TestListener.infoMessage("Expected Request Id:- " + expectedResult);
		if (RequestID.equals(expectedResult)) {
			System.out.println("Request ID Found " + RequestID);
			TestListener.infoMessage("Request ID Found " + expectedResult);
		} else {
			System.out.println("Request ID Not Found " + RequestID);
			TestListener.infoMessageFail("Request ID Found " + expectedResult);
		}
	}

	public void openSearchRequestID(String RequestID) {
		driver.findElement(By.xpath("//a[contains(text(),'"+RequestID+"')]")).click();
		wait.until(ExpectedConditions.visibilityOf(reasonForAccessingRequest));
	}
	
	public void searchByPatientName(String patientName) {
		String userName = nameoFtheUser.getText();
		if (!userName.contains("Custodian")) {
			wait.until(ExpectedConditions.elementToBeClickable(inputPatientName));
			inputPatientName.click();
			inputPatientName.sendKeys(patientName);
			buttonSearch.click();
			wait.until(ExpectedConditions.visibilityOf(patientNameResult));
			String expectedResult = patientNameResult.getText();
			if (patientName.equals(expectedResult)) {
				System.out.println("Patient Name Found " + patientName);
				TestListener.infoMessage("Patient Name Found " + expectedResult);
			} else {
				System.out.println("Patient Name Not Found " + patientName);
				TestListener.infoMessageFail("Patient Name Not Found " + expectedResult);
			}

		} else {
			wait.until(ExpectedConditions.elementToBeClickable(inputPatientName));
			inputPatientName.click();
			inputPatientName.sendKeys(patientName);
			buttonSearch.click();
			wait.until(ExpectedConditions.visibilityOf(patientNameResultCustodian));
			int noofRow = driver.findElements(By.xpath("//*[@id='custodian_home_requests']/div[2]/table/tbody/tr"))
					.size();

			for (int i = 1; i <= noofRow; i++) {
				String expectedValue = driver
						.findElement(
								By.xpath("//*[@id='custodian_home_requests']/div[2]/table/tbody/tr[" + i + "]/td[4]"))
						.getText();
				if (patientName.equals(expectedValue)) {
					System.out.println("Patient Name Found " + patientName);
					System.out.println("Value found at:- " + i);
					TestListener.infoMessage("Patient Name Found " + expectedValue);
					break;
				} else {
					System.out.println("Patient Name Not Found " + patientName);
					TestListener.infoMessageFail("Patient Name Not Found " + expectedValue);
					continue;
				}
			}
		}
	}

	public void searchByinputStatus(String statusType) {
		String userName = nameoFtheUser.getText();
		if (!userName.contains("Custodian")) {
			wait.until(ExpectedConditions.elementToBeClickable(inputStatus));
			inputStatus.click();
			inputStatus.sendKeys(statusType);
			inputStatus.sendKeys(Keys.ENTER);
			buttonSearch.click();
			wait.until(ExpectedConditions.visibilityOf(statusResult));
			String expectedResult = statusResult.getText();
			if (statusType.equals(expectedResult)) {
				System.out.println(statusType + " Status Found ");
				TestListener.infoMessage("Status Found " + expectedResult);
			} else {
				System.out.println(statusType + " Status Not Found ");
				TestListener.infoMessageFail("Status Not Found " + expectedResult);
			}

		} else {
			wait.until(ExpectedConditions.elementToBeClickable(inputStatus));
			inputStatus.click();
			inputStatus.sendKeys(statusType);
			inputStatus.sendKeys(Keys.ENTER);
			buttonSearch.click();
			wait.until(ExpectedConditions.visibilityOf(statusResultCustodian));
			String expectedResult = statusResultCustodian.getText();
			if (statusType.equals(expectedResult)) {
				System.out.println(statusType + " Status Found ");
				TestListener.infoMessage("Status Found " + expectedResult);
			} else {
				System.out.println(statusType + " Status Not Found ");
				TestListener.infoMessageFail("Status Not Found " + expectedResult);
			}

		}
	}

	public void searchByProviderName(String providerName) {
		String userName = nameoFtheUser.getText();
		if (!userName.contains("Custodian")) {
			wait.until(ExpectedConditions.elementToBeClickable(inputProviderName));
			inputProviderName.click();
			inputProviderName.sendKeys(providerName);
			buttonSearch.click();
			wait.until(ExpectedConditions.visibilityOf(providerResult));
			String expectedResult = providerResult.getText();
			if (providerName.equals(expectedResult)) {
				System.out.println("Provider Name Found " + providerName);
				TestListener.infoMessage("Provider Name Found " + expectedResult);
			} else {
				System.out.println("Provider Name Not Found " + providerName);
				TestListener.infoMessageFail("Provider Name Not Found " + expectedResult);
			}

		} else {
			wait.until(ExpectedConditions.elementToBeClickable(inputProviderName));
			inputProviderName.click();
			inputProviderName.sendKeys(providerName);
			buttonSearch.click();
			wait.until(ExpectedConditions.visibilityOf(providerResultCustodian));
			String expectedResult = providerResultCustodian.getText();
			if (providerName.equals(expectedResult)) {
				System.out.println("Provider Name Found " + providerName);
				TestListener.infoMessage("Provider Name Found " + expectedResult);
			} else {
				System.out.println("Provider Name Not Found " + providerName);
				TestListener.infoMessageFail("Provider Name Not Found " + expectedResult);
			}

		}
	}

	public void searchByReasonForRequest(String ReasonOfRequest) {

		String userName = nameoFtheUser.getText();
		if (!userName.contains("Custodian")) {
			wait.until(ExpectedConditions.elementToBeClickable(inputReasonOfRequest));
			inputReasonOfRequest.click();
			inputReasonOfRequest.sendKeys(ReasonOfRequest);
			inputReasonOfRequest.sendKeys(Keys.ENTER);
			buttonSearch.click();
			wait.until(ExpectedConditions.visibilityOf(providerResultCustodian));
			String expectedResult = providerResultCustodian.getText();
			if (ReasonOfRequest.equals(expectedResult)) {
				System.out.println("Reason of Request Found " + expectedResult);
				TestListener.infoMessage("Reason of Request Found " + expectedResult);
			} else {
				System.out.println("Reason of Request Not Found " + expectedResult);
				TestListener.infoMessageFail("Reason of Request Not Found " + expectedResult);
			}
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(inputReasonOfRequest));
			inputReasonOfRequest.click();
			inputReasonOfRequest.sendKeys(ReasonOfRequest);
			inputReasonOfRequest.sendKeys(Keys.ENTER);
			buttonSearch.click();
			wait.until(ExpectedConditions.visibilityOf(providerResultCustodianAccount));
			String expectedResult = providerResultCustodianAccount.getText();
			if (ReasonOfRequest.equals(expectedResult)) {
				System.out.println("Reason of Request Found " + ReasonOfRequest);
				TestListener.infoMessage("Reason of Request Found " + expectedResult);
			} else {
				System.out.println("Reason of Request Not Found " + ReasonOfRequest);
				TestListener.infoMessageFail("Reason of Request Not Found " + expectedResult);
			}
		}
	}

	public void searchByRequestorName(String RequestorName) {
		wait.until(ExpectedConditions.elementToBeClickable(inputRequestorName));
		inputRequestorName.click();
		inputRequestorName.sendKeys(RequestorName);
		inputRequestorName.sendKeys(Keys.ENTER);
		buttonSearch.click();
		wait.until(ExpectedConditions.visibilityOf(providerResult));
		String expectedResult = providerResult.getText();
		if (RequestorName.equalsIgnoreCase(expectedResult)) {
			System.out.println("Requestor Name Found " + RequestorName);
			TestListener.infoMessage("Requestor Name Found " + expectedResult);
		} else {
			System.out.println("Requestor Name Not Found " + RequestorName);
			TestListener.infoMessageFail("Requestor Name Not Found " + expectedResult);
		}

	}
	
	public void searchMultipleConditionCustodian(String statusType, String RequestorName) {
		wait.until(ExpectedConditions.elementToBeClickable(inputStatus));
		inputStatus.click();
		inputStatus.sendKeys(statusType);
		inputStatus.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(inputRequestorName));
		inputRequestorName.click();
		inputRequestorName.sendKeys(RequestorName);
		inputRequestorName.sendKeys(Keys.ENTER);
		buttonSearch.click();
	
	}

	public boolean getLastPage() {
		boolean flag=false;
		if (TestUtil.isElementDisplayed(getLast)) {
			getLast.click();
			flag=true;
			TestUtil.hardWait(5);
		}
		return flag;
	}
	
	public boolean DynmaicLastPage() {
		boolean flag=false;
		WebElement noOfPage=driver.findElement(By.xpath("//nav[1]//ul[1]//li[1]"));
		if (TestUtil.isElementDisplayed(noOfPage)) {
			int tempPages=driver.findElements(By.xpath("//nav[1]//ul[1]//li")).size();
			driver.findElement(By.xpath("//nav[2]//ul[1]//li["+tempPages+"]//a[1]")).click();
			flag=true;
			TestUtil.hardWait(5);
		}
		return flag;
	}
	
	public String getLastRequestIDFromAdmin() {
		wait.until(ExpectedConditions.visibilityOf(visibilityOfTable));
		int noOfRows=driver.findElements(By.xpath("//table[@class='main-table table-striped table-condensed']/tbody/tr")).size();
		String getRequesID=driver.findElement(By.xpath("//table[@class='main-table table-striped table-condensed']/tbody/tr["+noOfRows+"]/td[2]/a")).getText();
		return getRequesID;
	}
}
