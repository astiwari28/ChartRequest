package com.ChartRequest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Utility.TestUtil;

public class AdminRetrievalDashboardPage extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String tempRequestNumber;

	public AdminRetrievalDashboardPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;

	@FindBy(xpath = "//a[@href='/company/retrieval_dashboards']")
	WebElement adminRetrievalDashboardOption;

	@FindBy(xpath = "//td[normalize-space()='Custodian']")
	WebElement tableHeading;

	@FindBy(xpath = "//a[normalize-space()='New']")
	WebElement tabNewAdminRetrievalDashboard;

	@FindBy(xpath = "//tbody/tr[1]/td[9]")
	WebElement valueOfLastRetrievalEffort;

	@FindBy(xpath = "//tbody/tr[1]/td[10]/a[1]")
	WebElement firstStartRecordsRetrievalButton;

	@FindBy(xpath = "//h4[contains(text(),'Reason for Accessing Request')]")
	WebElement headingforProcessing;

	@FindBy(xpath = "//label[contains(text(),'Processing')]")
	WebElement labelForProcessing;

	@FindBy(xpath = "//a[normalize-space()='Select Retrieval Effort']")
	WebElement selectRetrievalEffortDropDown;

	@FindBy(xpath = "//a[normalize-space()='Log Call']")
	WebElement selectLogCallDropDown;

	@FindBy(xpath = "//input[@value='Log Call']")
	WebElement buttonLogCall;

	@FindBy(xpath = "//div[@id='notice']")
	WebElement notificationStatus;

	@FindBy(xpath = "//a[normalize-space()='Follow Up']")
	WebElement tabFollowUpAdminRetrievalDashboard;

	@FindBy(xpath = "//tbody/tr[1]/td[3]")
	WebElement getRequestNumber;

	@FindBy(xpath = "//a[normalize-space()='QA']")
	WebElement tabQAAdminRetrievalDashboard;
	
	@FindBy(xpath = "//h4[text()='Authorization QA Checklist']")
	WebElement labelAuthorizationQAChecklistHeading;
	
	@FindBy(xpath = "//label[text()='Authorization Compliant']")
	WebElement checkBoxAuthorizationCompliant;
	
	@FindBy(xpath = "//label[text()='Patient Name Verified & Matches']")
	WebElement checkBoxPatientNameVerifiedAndMatches;
	
	@FindBy(xpath = "//label[text()='Authorization is Signed']")
	WebElement checkBoxAuthorizationisSigned;
	
	@FindBy(xpath = "//button[text()='Approve']")
	WebElement buttonApprove;
	
	@FindBy(xpath = "//h4[text()='Records QA Checklist']")
	WebElement labelRecordsQAChecklistHeading;
	
	@FindBy(xpath = "//div[not(@style='display: none;') and @class='qa-record-check-list']/div[1]/label/input")
	WebElement checkBoxPatientNameVerifiedAndMatchesMedical;
	
	@FindBy(xpath = "//div[not(@style='display: none;') and @class='qa-record-check-list']/div[2]/label/input")
	WebElement checkBoxDatesofServiceRequestedVerifiedAndMatch;
	
	@FindBy(xpath = "//div[not(@style='display: none;') and @class='qa-record-check-list']/div[3]/label/input")
	WebElement checkBoxRecordCertificationUploaded;
	
	@FindBy(xpath = "//button[text()='Approve' and @id='qa-approve-record-btn']")
	WebElement buttonApproveMedical;
	
	@FindBy(xpath = "//div[contains(@class,'col-sm-4 qa-right-panel-2')]//button[@id='qa-release-record']")
	WebElement buttonReleaseRecords;
	
	@FindBy(xpath = "//div[@class='dropdown pull-right open']//a[@class='release_records_now'][normalize-space()='Release Now']")
	WebElement dropDownReleaseNowRecords;
	
	@FindBy(xpath = "//button[@id='approve-picing-strategy-btn']")
	WebElement buttonApprovePricingStrategy;
	
	@FindBy(xpath = "//a[@id='approve-service-btn']")
	WebElement buttonApproveService;
	
	@FindBy(xpath = "//a[@id='submit-to-req-btn']")
	WebElement buttonSubmitToRequestorRequestProcessing;
	
	@FindBy(xpath = "//label[normalize-space()='Records reviewed for clinical accuracy']")
	WebElement labelRecordsReviewedForClinicalAccuracy;
	
	/**
	 * @author ashutosh.tiwari
	 * @since Feb 8th 2021
	 * @Description This method will open the Admin Retrieval Dashboard Page From
	 *              Login
	 */
	public void openAdminRetrievalDashboardPage() {
		adminDropDown.click();
		adminRetrievalDashboardOption.click();
		wait.until(ExpectedConditions.visibilityOf(tableHeading));
	}

	/**
	 * @author ashutosh.tiwari
	 * @since Feb 8th 2021
	 * @Description This method will click on New Tab and start recording the last
	 *              Retrieval Effort
	 */
	public void startRetrievalOnNewTab() {
		wait.until(ExpectedConditions.elementToBeClickable(tabNewAdminRetrievalDashboard));
		tabNewAdminRetrievalDashboard.click();
		// Getting value of last Retrieval Effort and Request Number
		tempRequestNumber = getRequestNumber.getText();
		System.out.println("Request Number is "+tempRequestNumber);
		String valueOfLastRetrievalEffortString = valueOfLastRetrievalEffort.getText();
		if (valueOfLastRetrievalEffortString.isBlank() || valueOfLastRetrievalEffortString.contains(" ")) {
			System.out.println("No Last Retrieval Effort is added yet on New tab");
		} else {
			System.out.println("Last Retrieval Effort is added Already on New tab " + valueOfLastRetrievalEffortString);
		}
		js.executeScript("arguments[0].click();", firstStartRecordsRetrievalButton);
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);
		wait.until(ExpectedConditions.visibilityOf(selectRetrievalEffortDropDown));
		js.executeScript("arguments[0].click();", selectLogCallDropDown);
		System.out.println("Selected the Log Call");
		js.executeScript("arguments[0].click();", buttonLogCall);
		wait.until(ExpectedConditions.visibilityOf(notificationStatus));
		openAdminRetrievalDashboardPage();
		js.executeScript("arguments[0].click();", tabFollowUpAdminRetrievalDashboard);
		// Verify The Request From New Tab To Follow Tab Movement
		String valueOfNewLastRetrievalEffortString = driver
				.findElement(By.xpath("//a[normalize-space()='" + tempRequestNumber + "']/following::tr[1]/td[9]"))
				.getText();
		if (valueOfNewLastRetrievalEffortString.isBlank() || valueOfNewLastRetrievalEffortString.contains(" ")) {
			System.out.println("No Last Retrieval Effort is added yet");
		} else {
			System.out.println("Last Retrieval Effort is added Already " + valueOfNewLastRetrievalEffortString);
		}
	}

	/**
	 * @author ashutosh.tiwari
	 * @since Feb 8th 2021
	 * @Description This method will click on Followup Tab and start recording the
	 *              last Retrieval Effort
	 */
	public void startRetrievalOnFollowTab() {
		wait.until(ExpectedConditions.elementToBeClickable(tabFollowUpAdminRetrievalDashboard));
		tabFollowUpAdminRetrievalDashboard.click();
		// Getting value of last Retrieval Effort and Request Number
		System.out.println("Request Number is "+tempRequestNumber);
		String valueOfLastRetrievalEffortString = driver
				.findElement(By.xpath("//a[normalize-space()='" + tempRequestNumber + "']/following::tr[1]/td[9]"))
				.getText();
		if (valueOfLastRetrievalEffortString.isBlank() || valueOfLastRetrievalEffortString.contains(" ")) {
			System.out.println("No Last Retrieval Effort is added yet on Followup tab");
		} else {
			System.out.println("Last Retrieval Effort is added Already on Followup tab " + valueOfLastRetrievalEffortString);
		}
		js.executeScript("arguments[0].click();", driver
				.findElement(By.xpath("//a[normalize-space()='" + tempRequestNumber + "']/following::tr[1]/td[10]/a[1]")));
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);
		wait.until(ExpectedConditions.visibilityOf(selectRetrievalEffortDropDown));
		js.executeScript("arguments[0].click();", selectLogCallDropDown);
		System.out.println("Selected the Log Call");
		js.executeScript("arguments[0].click();", buttonLogCall);
		wait.until(ExpectedConditions.visibilityOf(notificationStatus));
		openAdminRetrievalDashboardPage();
		js.executeScript("arguments[0].click();", tabFollowUpAdminRetrievalDashboard);
		// Verify The Request From New Tab To Follow Tab Movement
		String valueOfNewLastRetrievalEffortString = driver
				.findElement(By.xpath("//a[normalize-space()='" + tempRequestNumber + "']/following::tr[1]/td[9]"))
				.getText();
		if (valueOfNewLastRetrievalEffortString.isBlank() || valueOfNewLastRetrievalEffortString.contains(" ")) {
			System.out.println("No Last Retrieval Effort is added yet");
		} else {
			System.out.println("Last Retrieval Effort is added Already " + valueOfNewLastRetrievalEffortString);
		}

	}
	
	/**
	 * @author ashutosh.tiwari
	 * @since Feb 8th 2021
	 * @Description This method will click on QA Tab and start recording the
	 *              last Retrieval Effort
	 */
	public void startRetrievalOnQATab() {
		wait.until(ExpectedConditions.elementToBeClickable(tabQAAdminRetrievalDashboard));
		tabQAAdminRetrievalDashboard.click();
		TestUtil.hardWait(5);
		tempRequestNumber = getRequestNumber.getText();
		System.out.println("Request Number is "+tempRequestNumber);
		String valueOfLastRetrievalEffortString = valueOfLastRetrievalEffort.getText();
		if (valueOfLastRetrievalEffortString.isBlank() || valueOfLastRetrievalEffortString.contains(" ")) {
			System.out.println("No Last Retrieval Effort is added yet on QA tab");
		} else {
			System.out.println("Last Retrieval Effort is added Already on QA tab " + valueOfLastRetrievalEffortString);
		}
		js.executeScript("arguments[0].click();", firstStartRecordsRetrievalButton);
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);
		
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(element))
		int noOfFiles = driver
				.findElements(By
						.xpath("//h4[contains(text(),'Authorization Documents')]/following::a[@class='auth-file']"))
				.size();
		System.out.println("No of File Size:- "+noOfFiles);
		for (int i = 1; i <= noOfFiles; i++) {
			driver.findElement(By.xpath(
					"//h4[contains(text(),'Authorization Documents')]/following::a[@class='auth-file'][" + i + "]"))
					.click();
			TestUtil.hardWait(5);
			if (TestUtil.isElementDisplayed(labelAuthorizationQAChecklistHeading)) {
				/*checkBoxAuthorizationCompliant.click();
				checkBoxPatientNameVerifiedAndMatches.click();
				checkBoxAuthorizationisSigned.click();*/
				js.executeScript("arguments[0].click();", checkBoxAuthorizationCompliant);
				js.executeScript("arguments[0].click();", checkBoxPatientNameVerifiedAndMatches);
				js.executeScript("arguments[0].click();", checkBoxAuthorizationisSigned);
			}
		}
		buttonApprove.click();

		// Medical records

		int noOfFilesMedical = driver
				.findElements(
						By.xpath("//h4[contains(text(),'Medical Records')]/following::a[@class='record-file']"))
				.size();
		System.out.println("No of File Medical Size:- "+noOfFilesMedical);
		for (int i = 1; i <= noOfFilesMedical; i++) {
			driver.findElement(By.xpath(
					"//h4[contains(text(),'Medical Records')]/following::a[@class='record-file'][" + i + "]"))
					.click();
			TestUtil.hardWait(5);
			if (TestUtil.isElementDisplayed(labelRecordsQAChecklistHeading)) {
				wait.until(ExpectedConditions.elementToBeClickable(checkBoxPatientNameVerifiedAndMatchesMedical));
				/*checkBoxPatientNameVerifiedAndMatchesMedical.click();
				checkBoxDatesofServiceRequestedVerifiedAndMatch.click();
				checkBoxRecordCertificationUploaded.click();*/
				js.executeScript("arguments[0].click();", checkBoxPatientNameVerifiedAndMatchesMedical);
				js.executeScript("arguments[0].click();", checkBoxDatesofServiceRequestedVerifiedAndMatch);
				js.executeScript("arguments[0].click();", checkBoxRecordCertificationUploaded);
			}
			else {
				js.executeScript("arguments[0].click();", labelRecordsReviewedForClinicalAccuracy);
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(buttonApproveMedical));
		buttonApproveMedical.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonReleaseRecords));
		if (TestUtil.isElementDisplayed(buttonReleaseRecords)) {
			buttonReleaseRecords.click();
			dropDownReleaseNowRecords.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(buttonApprovePricingStrategy));
		TestUtil.hardWait(10);
		js.executeScript("arguments[0].click();", buttonApprovePricingStrategy);
		System.out.println("1");
		System.out.println("2");
		wait.until(ExpectedConditions.visibilityOf(buttonApproveService));
		System.out.println("3");
		System.out.println("4");
		js.executeScript("arguments[0].click();", buttonApproveService);
		// buttonApproveService.click();
		System.out.println("5");
		TestUtil.hardWait(5);
		System.out.println("6");
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'(invoice)')]"))));
		js.executeScript("arguments[0].click()", buttonApproveService);
		int i = 0;
		while (!buttonSubmitToRequestorRequestProcessing.getText().contains("Submit To Requestor")) {
			js.executeScript("arguments[0].click()", buttonApproveService);
			System.out.println("Trying to Click " + i);
			i++;
		}
		wait.until(ExpectedConditions.elementToBeClickable(buttonSubmitToRequestorRequestProcessing));
		System.out.println("7");
		System.out.println("8");
		js.executeScript("arguments[0].click();", buttonSubmitToRequestorRequestProcessing);
		System.out.println("9");
		System.out.println("10");
	}
	
	public void verifyNewTabToolTip() {
		String actualNewTabToolTipValue=tabNewAdminRetrievalDashboard.getAttribute("data-title");
		String expectedNewTabToolTipValue="No retrieval efforts have been made yet for these requests.";
		Assert.assertEquals(actualNewTabToolTipValue, expectedNewTabToolTipValue, "New Tab Tool Tip String Text Matched");
	}
	
	public void verifyFollowUpTabToolTip() {
		String actualNewTabToolTipValue=tabFollowUpAdminRetrievalDashboard.getAttribute("data-title");
		String expectedNewTabToolTipValue="At least one retrieval effort has been made for these requests. We'll need to follow up with the custodian.";
		Assert.assertEquals(actualNewTabToolTipValue, expectedNewTabToolTipValue, "New Tab Tool Tip String Text Matched");
	}
	
	public void verifyQATabToolTip() {
		String actualNewTabToolTipValue=tabQAAdminRetrievalDashboard.getAttribute("data-title");
		String expectedNewTabToolTipValue="Records have been retrieved for these requests - nice! It's time for Quality Assurance.";
		Assert.assertEquals(actualNewTabToolTipValue, expectedNewTabToolTipValue, "New Tab Tool Tip String Text Matched");
	}
}
