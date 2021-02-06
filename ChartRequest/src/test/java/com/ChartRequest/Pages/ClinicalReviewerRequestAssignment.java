package com.ChartRequest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.TestUtil;

public class ClinicalReviewerRequestAssignment extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	CreateRequest createRequest = new CreateRequest();

	@FindBy(xpath = "//a[contains(text(),'Edit General Settings')]")
	WebElement buttonEditGeneralSetting;

	@FindBy(xpath = "//input[@id='custodian_custodian_settings_attributes_enable_on_hold']")
	WebElement checkboxOnHoldEnabled;

	@FindBy(xpath = "//input[@id='custodian_custodian_settings_attributes_skip_assignment_on_hold']")
	WebElement checkboxSkipAssignmentWhenMovedOnHold;

	@FindBy(xpath = "//input[@name='commit']")
	WebElement buttonUpdateCustodian;

	@FindBy(xpath = "//div[@id='notice']")
	WebElement confrimationMessage;

	@FindBy(xpath = "//a[contains(text(),'My Organization')]")
	WebElement navigationMyOrganization;

	@FindBy(xpath = "//a[@id='clinical_reviewer_edit_btn']")
	WebElement editClinicalReviewer;

	@FindBy(xpath = "//span[contains(text(),'Select User')]")
	// @FindBy(xpath = "//*[@id='clinical_reviewer_user_chosen']")
	WebElement dropdownClinicalReviewer;

	@FindBy(xpath = "//div[@id='clinical_reviewer_user_chosen']/div/div/input")
	WebElement inputClinicalReviewer;

	@FindBy(xpath = "//button[@id='add_review_user_btn']")
	WebElement buttonAddClinicalReviewer;

	@FindBy(xpath = "//button[contains(@class,'btn btn-danger delete_reviewer_btn')]")
	WebElement buttonDeleteReviewer;

	// @FindBy(xpath = "//a[@class='no-wrap-id']")
	@FindBy(xpath = "//table[@class='main-table table-striped request-container table-condensed']/tbody/tr/td[3]/a")
	WebElement linkSearchRequestID;

	@FindBy(xpath = "//h4[contains(text(),'Reason for Accessing Request')]")
	WebElement headingforProcessing;

	@FindBy(xpath = "//label[contains(text(),'Processing')]")
	WebElement labelForProcessing;

	@FindBy(xpath = "//table[@class='main-table table-striped request-container table-condensed']/tbody/tr/td[3]/a")
	WebElement linkOpenRequestId;

	@FindBy(xpath = "//button[text()='Submit to QA']")
	WebElement buttonSubmitToQA;

	@FindBy(xpath = "//a[contains(text(),'Perform QA Now')]")
	WebElement buttonPerformQANow;

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

	@FindBy(xpath = "//a[@id='move_to_hold']")
	WebElement dropDownReleaseNowRecords;

	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement buttonOkRequestOnHold;

	@FindBy(xpath = "//button[@id='approve-picing-strategy-btn']")
	WebElement buttonApprovePricingStrategy;

	@FindBy(xpath = "//a[@id='approve-service-btn']")
	WebElement buttonApproveService;

	@FindBy(xpath = "//a[@id='submit-to-req-btn']")
	WebElement buttonSubmitToRequestorRequestProcessing;

	@FindBy(xpath = "//p[@id='on_hold_skip_assign_user']")
	WebElement errorMessageNoClinicalReviewer;

	@FindBy(xpath = "//button[normalize-space()='Assign']")
	WebElement buttonAssignClinicalReviewer;

	@FindBy(xpath = "//button[normalize-space()='Assign User']")
	WebElement buttonFinalAssignClinicalReviewer;
	
	@FindBy(xpath = "//div[@class='clinical-review-check-list' and not(@style='display: none;')]/div[@class='checkbox']/label/input[@name='clinical-review-check']")
	//@FindBy(xpath = "//div[@class='clinical-review-check-list']//h4[contains(text(),'Clinical Review Checklist')]/ancestor::div[@class='clinical-review-check-list' and not(@style='display: none;')]")
	WebElement checkboxRecordsReviewedForClinicalAccuracy;
	
	@FindBy(xpath = "//div[@class='dropdown pull-right open']//a[@class='release_records_now'][normalize-space()='Release Now']")
	WebElement buttonDropDownReleaseNowRecords;
	
	public ClinicalReviewerRequestAssignment() {
		PageFactory.initElements(driver, this);
	}

	public void openEditGeneralSettings() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonEditGeneralSetting));
		buttonEditGeneralSetting.click();
	}

	public void allowSkipAssignmentWhenMovedOnHold() {
		wait.until(ExpectedConditions.elementToBeClickable(checkboxOnHoldEnabled));
		System.out.println("Before On Hold Enabled Status " + checkboxOnHoldEnabled.isSelected());
		TestListener.infoMessage("Before On Hold Enabled Status " + checkboxOnHoldEnabled.isSelected());
		js.executeScript("arguments[0].scrollIntoView(true);", checkboxOnHoldEnabled);
		if (!checkboxOnHoldEnabled.isSelected()) {
			checkboxOnHoldEnabled.click();
		}
		System.out.println("After On Hold Enabled Status " + checkboxOnHoldEnabled.isSelected());
		TestListener.infoMessage("After On Hold Enabled Status " + checkboxOnHoldEnabled.isSelected());

		/*
		 * wait.until(ExpectedConditions.visibilityOf(
		 * checkboxSkipAssignmentWhenMovedOnHold));
		 * System.out.println("Before Checkbox status of On Hold " +
		 * checkboxSkipAssignmentWhenMovedOnHold.isSelected()); if
		 * (!checkboxSkipAssignmentWhenMovedOnHold.isSelected()) {
		 * checkboxSkipAssignmentWhenMovedOnHold.click(); buttonUpdateCustodian.click();
		 * System.out.println("After Checkbox status of On Hold " +
		 * checkboxSkipAssignmentWhenMovedOnHold.isSelected()); }
		 */
		buttonUpdateCustodian.click();
		wait.until(ExpectedConditions.visibilityOf(confrimationMessage));
	}

	public void addClinicalReviewer(String reviewerName) {
		wait.until(ExpectedConditions.elementToBeClickable(navigationMyOrganization));
		navigationMyOrganization.click();
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.visibilityOf(editClinicalReviewer));
		TestUtil.hardWait(5);
		editClinicalReviewer.click();
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(dropdownClinicalReviewer));
		TestUtil.hardWait(5);
		//Verify the Clinical Reviewer is added for Not Before Adding
		if (verifyClinicalReviwerAddedornot(reviewerName)) {
			System.out.println("No Need to Add clinical reviwer");
		} else {
		dropdownClinicalReviewer.click();
		TestUtil.hardWait(5);
		js.executeScript("arguments[0].scrollIntoView(true);", dropdownClinicalReviewer);
		/*dropdownClinicalReviewer.click();
		inputClinicalReviewer.click();*/
		inputClinicalReviewer.sendKeys(reviewerName);
		inputClinicalReviewer.sendKeys(Keys.ENTER);
		buttonAddClinicalReviewer.click();
		int size = driver
				.findElements(By.xpath(
						"//div/ol[@class='reviewer-ul']/li/div[@class='reviewer_edit']/span[@class='reviewer_value']"))
				.size();
		for (int i = 1; i <= size; i++) {
			String reviewerNameFromList = driver.findElement(By.xpath("//div/ol[@class='reviewer-ul']/li[" + i + "]"))
					.getText();
			if (reviewerName.equalsIgnoreCase(reviewerNameFromList)) {
				System.out.println("Clinical Reviewer Name Added Successfully");
				TestListener.infoMessage("Clinical Reviewer Name Added Successfully");
			} else {
				System.out.println("Clinical Reviewer Name NOT-Added Successfully");
				TestListener.infoMessageFail("Clinical Reviewer Name NOT-Added Successfully");
				TestListener.addDynamicScreenshotInReport("addClinicalReviewer");
			}
		}
	}
	}

	public void deleteClinicalReviewer(String firstNameOfDeleteClinicalReviewer) {
		wait.until(ExpectedConditions.elementToBeClickable(navigationMyOrganization));
		navigationMyOrganization.click();
		js.executeScript("arguments[0].scrollIntoView(true);", editClinicalReviewer);
		wait.until(ExpectedConditions.visibilityOf(editClinicalReviewer));
		editClinicalReviewer.click();
		driver.findElement(By.xpath("//span[contains(@data-value,'" + firstNameOfDeleteClinicalReviewer + "')]"))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonDeleteReviewer));
		buttonDeleteReviewer.click();
	}

	public String enableQAandOnHoldProcessingRequest(String ClinicalReviewerName) {
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.
		 * xpath("//a[@href='/custodian?status=qa']"))));
		 * driver.findElement(By.xpath("//a[@href='/custodian?status=qa']")).click();
		 */
		
		wait.until(ExpectedConditions.elementToBeClickable(linkOpenRequestId));
		js.executeScript("arguments[0].click();", linkSearchRequestID);
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);

		// Submit To QA
		String tempRequestNo = createRequest.getRequestNo();
		buttonSubmitToQA.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonPerformQANow));
		buttonPerformQANow.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(element))
		int noOfFiles = driver
				.findElements(
						By.xpath("//h4[contains(text(),'Authorization Documents')]/following::a[@class='auth-file']"))
				.size();
		for (int i = 1; i <= noOfFiles; i++) {
			driver.findElement(By.xpath(
					"//h4[contains(text(),'Authorization Documents')]/following::a[@class='auth-file'][" + i + "]"))
					.click();
			if (TestUtil.isElementDisplayed(labelAuthorizationQAChecklistHeading)) {
				checkBoxAuthorizationCompliant.click();
				checkBoxPatientNameVerifiedAndMatches.click();
				checkBoxAuthorizationisSigned.click();
			}
		}
		buttonApprove.click();

		// Medical records
		TestUtil.hardWait(5);
		int noOfFilesMedical = driver
				.findElements(By.xpath("//h4[contains(text(),'Medical Records')]/following::a[@class='record-file']"))
				.size();
		for (int i = 1; i <= noOfFilesMedical; i++) {
			driver.findElement(
					By.xpath("//h4[contains(text(),'Medical Records')]/following::a[@class='record-file'][" + i + "]"))
					.click();
			if (TestUtil.isElementDisplayed(labelRecordsQAChecklistHeading)) {
				wait.until(ExpectedConditions.elementToBeClickable(checkBoxPatientNameVerifiedAndMatchesMedical));
				checkBoxPatientNameVerifiedAndMatchesMedical.click();
				checkBoxDatesofServiceRequestedVerifiedAndMatch.click();
				checkBoxRecordCertificationUploaded.click();
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(buttonApproveMedical));

		buttonApproveMedical.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonReleaseRecords));

		/*
		 * actions.moveToElement(buttonReleaseRecords);
		 * actions.click().build().perform();
		 */

		if (TestUtil.isElementDisplayed(buttonReleaseRecords)) {
			buttonReleaseRecords.click();
			dropDownReleaseNowRecords.click();
			if (TestUtil.isElementDisplayed(errorMessageNoClinicalReviewer)) {
				selectForHoldForReviewerName(ClinicalReviewerName);
				wait.until(ExpectedConditions.elementToBeClickable(buttonAssignClinicalReviewer));
				buttonAssignClinicalReviewer.click();
				wait.until(ExpectedConditions.elementToBeClickable(buttonFinalAssignClinicalReviewer));
				buttonFinalAssignClinicalReviewer.click();
			} else {
				TestListener.addDynamicScreenshotInReport("NoClinicalReviewer");
				System.exit(1);
			}
			// buttonOkRequestOnHold.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(buttonApprovePricingStrategy));
		TestUtil.hardWait(10);
		js.executeScript("arguments[0].click();", buttonApprovePricingStrategy);
		System.out.println("1");
		// TestUtil.hardWait(5);
		System.out.println("2");
		wait.until(ExpectedConditions.visibilityOf(buttonApproveService));
		System.out.println("3");
		// TestUtil.hardWait(5);
		System.out.println("4");
		js.executeScript("arguments[0].click();", buttonApproveService);
		// buttonApproveService.click();

		// TestUtil.hardWait(5);
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
		// TestUtil.hardWait(5);
		System.out.println("8");
		js.executeScript("arguments[0].click();", buttonSubmitToRequestorRequestProcessing);
		System.out.println("9");
		// TestUtil.hardWait(5);
		System.out.println("10");
		return tempRequestNo;
	}

	public void selectForHoldForReviewerName(String ClinicalReviewerName) {
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//*[@id='request_on_hold_processing_user_chosen']"))));
		// driver.findElement(By.xpath("//*[@id='request_on_hold_processing_user_chosen']/a")).click();
		// driver.findElement(By.xpath("//*[@id=\"request_on_hold_processing_user_chosen\"]")).click();
		driver.findElement(By.xpath("//div[@id='request_on_hold_processing_user_chosen']//input[@type='text']"))
				.sendKeys(ClinicalReviewerName);
		driver.findElement(By.xpath("//div[@id='request_on_hold_processing_user_chosen']//input[@type='text']"))
				.sendKeys(Keys.ENTER);
	}

	public void verifyOnHold(String RequestNo) {
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/custodian?status=qa']"))));
		driver.findElement(By.xpath("//a[@href='/custodian?status=qa']")).click();
		String tempRequestNo = /*driver.findElement(By.xpath(
				"//table[@class='main-table table-striped request-container table-condensed']/tbody/tr[1]/td[3]/a"))
				.getText();*/RequestNo;
		String tempGetText = driver.findElement(By.xpath(
				"//a[normalize-space()='" + tempRequestNo + "']//ancestor::td/span[@class='label  label-qa-on-hold']"))
				.getText();
		if (tempGetText.contains("Hold")) {
			System.out.println("Request in Hold State " + tempRequestNo);
		} else {
			System.out.println("Request NOT in Hold State " + tempRequestNo);
		}
	}

	public void verifyClinicalReviewerNameFromCustionMessage(String requestNo, String cliniarName) {
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/custodian?status=qa']"))));
		driver.findElement(By.xpath("//a[@href='/custodian?status=qa']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'" + requestNo + "')]")).click();
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[normalize-space()='View Provider Chat']"))));
		driver.findElement(By.xpath("//a[normalize-space()='View Provider Chat']")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@class='word-wrap-message internal-msg']"))));
		System.out.println(driver.findElement(By.xpath("//p[@class='word-wrap-message internal-msg']")).getText());
		String tempClinicalReviwerName=driver.findElement(By.xpath("//p[@class='word-wrap-message internal-msg']")).getText();
		if (tempClinicalReviwerName.contains(cliniarName)) {
			System.out.println("Clinical Reviwer is Assign to Correct user");
		} else {
			System.out.println("Clinical Reviwer is NOT-Assign to Correct user");
		}
		//p[@class='word-wrap-message internal-msg']
	}
	
	
	
	public void processingofRequest() {
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);
		TestUtil.hardWait(5);
		 //wait.until(ExpectedConditions.visibilityOf(element));
		int noOfFiles = driver
				.findElements(
						By.xpath("//h4[contains(text(),'Authorization Documents')]/following::a[@class='auth-file']"))
				.size();
		System.out.println("Number of Verify Authorization  "+noOfFiles);
		for (int i = 1; i <= noOfFiles; i++) {
			driver.findElement(By.xpath(
					"//h4[contains(text(),'Authorization Documents')]/following::a[@class='auth-file'][" + i + "]"))
					.click();
			if (TestUtil.isElementDisplayed(labelAuthorizationQAChecklistHeading)) {
				checkBoxAuthorizationCompliant.click();
				checkBoxPatientNameVerifiedAndMatches.click();
				checkBoxAuthorizationisSigned.click();
			}
		}
		buttonApprove.click();
		
		// Medical records

		int noOfFilesMedical = driver
				.findElements(By.xpath("//h4[contains(text(),'Medical Records')]/following::a[@class='record-file']"))
				.size();
		System.out.println("Number of Medical Records "+noOfFilesMedical);
		for (int i = 1; i <= noOfFilesMedical; i++) {
			driver.findElement(
					By.xpath("//h4[contains(text(),'Medical Records')]/following::a[@class='record-file'][" + i + "]"))
					.click();
			if (TestUtil.isElementDisplayed(labelRecordsQAChecklistHeading)) {
				wait.until(ExpectedConditions.elementToBeClickable(checkBoxPatientNameVerifiedAndMatchesMedical));
				checkBoxPatientNameVerifiedAndMatchesMedical.click();
				checkBoxDatesofServiceRequestedVerifiedAndMatch.click();
				checkBoxRecordCertificationUploaded.click();
			}
			else {
				TestUtil.isElementDisplayed(checkboxRecordsReviewedForClinicalAccuracy);
				wait.until(ExpectedConditions.elementToBeClickable(checkboxRecordsReviewedForClinicalAccuracy));
				checkboxRecordsReviewedForClinicalAccuracy.click();
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(buttonApproveMedical));
		buttonApproveMedical.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonReleaseRecords));
		if (TestUtil.isElementDisplayed(buttonReleaseRecords)) {
			buttonReleaseRecords.click();
			//driver.findElement(By.xpath("//*[@id='qa-step2-record']/div[2]/div[3]/div/ul/li[1]/a")).click();
			buttonDropDownReleaseNowRecords.click();
		}
		wait.until(ExpectedConditions.visibilityOf(confrimationMessage));
		String tempConfrimationMessage=confrimationMessage.getText();
		if (tempConfrimationMessage.contains("has been approved in QA")) {
			System.out.println("Request Move to QA");
			TestListener.addDynamicScreenshotInReport("Request Move to QA");
		} else {
			System.out.println("Request NOT-Move to QA");
			TestListener.infoMessageFail("Request NOT-Move to QA");
		}
		TestListener.addDynamicScreenshotInReport("requestProcess");
	}
	
	public boolean verifyClinicalReviwerAddedornot(String reviewerName) {
		boolean flag=false;
		int size = driver
				.findElements(By.xpath(
						"//div/ol[@class='reviewer-ul']/li/div[@class='reviewer_edit']/span[@class='reviewer_value']"))
				.size();
		for (int i = 1; i <= size; i++) {
			String reviewerNameFromList = driver.findElement(By.xpath("//div/ol[@class='reviewer-ul']/li[" + i + "]"))
					.getText();
			if (reviewerName.equalsIgnoreCase(reviewerNameFromList)) {
				System.out.println("Clinical Reviewer Already Added");
				TestListener.infoMessage("Clinical Reviewer Already Added");
				flag=true;
				break;
			} else {
				System.out.println("Clinical Reviewer NOT-Added");
				TestListener.infoMessageFail("Clinical Reviewer Already NOT-Added");
				TestListener.addDynamicScreenshotInReport("addClinicalRevieweraddedstatus");
				flag=false;
			}
		}
		return flag;
	}
}
