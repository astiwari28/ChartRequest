package com.ChartRequest.Pages;

import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.GlobalVariables;
import com.ChartRequest.Utility.TestUtil;

public class AdminExecutivePage extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;

	@FindBy(xpath = "//a[contains(normalize-space(),'[adm] Executive')]")
	WebElement adminDropDownExecutivePage;

	@FindBy(xpath = "//h3[@class='modal-title']")
	WebElement headingExecutiveAccess;

	@FindBy(xpath = "//input[@id='pin']")
	WebElement inputPin;

	@FindBy(xpath = "//button[@id='check-pin-btn']")
	WebElement buttonEnter;

	@FindBy(xpath = "//a[contains(normalize-space(),'Partners')]")
	WebElement buttonPartners;

	@FindBy(xpath = "//a[@href='/company/partners/new']")
	WebElement buttonAddPartners;

	@FindBy(xpath = "//h2[contains(text(),'Add a Partner')]")
	WebElement headingAddaPartner;

	@FindBy(xpath = "//input[@id='partner_name']")
	WebElement inputPartnerName;

	@FindBy(xpath = "//input[@id='organization_address']")
	WebElement inputPartnerAddress1;

	@FindBy(xpath = "//label[@for='partner_city']")
	WebElement inputPartnerCity;

	@FindBy(xpath = "//input[@id='partner_zipcode']")
	WebElement inputPartnerZipcode;

	@FindBy(xpath = "//input[@value='Create Partner']")
	WebElement buttonCreatePartner;

	@FindBy(xpath = "//a[contains(normalize-space(),'Bulk Uploads')]")
	WebElement buttonBulkUploadRequestor;

	@FindBy(xpath = "//a[@href='/bulk_uploads/custodians']")
	WebElement buttonBulkUploadCustodian;

	@FindBy(xpath = "//*[@id='company_custodian_bulk_abandon']/table/tbody/tr[1]/td[1]/a")
	WebElement getRequestIDNumber;

	@FindBy(xpath = "//*[@id='company_custodian_bulk_abandon']/table/tbody/tr[1]/td[1]/input")
	WebElement checkboxRequestIDNumber;

	@FindBy(xpath = "//div/a[contains(text(),'Abandon Request')]")
	WebElement buttonAbandonRequest;

	@FindBy(xpath = "//a[contains(text(),'Others')]")
	WebElement selectReasonAsOthers;

	@FindBy(xpath = "//input[@id='reason_abandoning_text']")
	WebElement inputReasonForOthers;

	@FindBy(xpath = "//input[@id='abn-submit']")
	WebElement buttonSubmitReasonForOthers;

	@FindBy(xpath = "//button[@id='bulk_abandon_confirmation']")
	WebElement finalConfrimationOfAbandonRequest;

	@FindBy(xpath = "//label[@for='processing']")
	WebElement buttonReasonForProcessing;

	@FindBy(xpath = "//a[@href='/bulk_uploads/custodians']")
	WebElement buttonBulkUploadCustodians;

	@FindBy(xpath = "//textarea[@id='message']/preceding::div[@class='msg-requestor statusmessage'][1]")
	WebElement lastMessageCustodianInternalView;

	@FindBy(xpath = "//div[@class='status-abandoned_by_requestor pull-right']")
	WebElement statusOfTheRequest;

	@FindBy(xpath = "//a[@href='/executive/user_sessions']")
	WebElement buttonSessionDetailsReport;

	@FindBy(xpath = "//button[contains(normalize-space(),'Search')]")
	WebElement buttonSearchSessionDetailsReport;

	@FindBy(xpath = "//table[@class='table table-hover check-batch-table']/tbody/tr")
	WebElement searchResultSessionDetailsReport;

	@FindBy(xpath = "//input[@id='user_name']")
	WebElement inputUserNameSessionDetailsReport;

	@FindBy(xpath = "//a[@href='/requestor/requests']")
	WebElement buttonSearchMyRequest;

	@FindBy(xpath = "//div[@id='search_status_in_chosen']//input[@value='Filter by Request Status']")
	WebElement inputSearchByStatus;

	@FindBy(xpath = "//input[@id='search_priced_on_gte']")
	WebElement inputMonthProcessedAndPriced;

	@FindBy(xpath = "//input[@id='req-search-btn']")
	WebElement searchButton;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr")
	WebElement searchResultFirstRow;

	@FindBy(xpath = "//table[@class='table table-striped']/tbody/tr[1]/td[1]")
	WebElement getRequestID;

	@FindBy(xpath = "//a[contains(normalize-space(),'Pay with Check')]")
	WebElement buttonPayByCheck;

	@FindBy(xpath = "//a[contains(normalize-space(),'[adm] Custodian View')]")
	WebElement buttonChangeToCustodianView;

	@FindBy(xpath = "//a[contains(text(),'Record Payment')]")
	WebElement buttonRecordPayment;

	@FindBy(xpath = "//a[contains(text(),'Check Collected')]")
	WebElement linkCheckCollected;

	@FindBy(xpath = "//a[contains(normalize-space(),'Completed')]")
	WebElement completedRequestTab;

	@FindBy(xpath = "//tbody[@class='request-container']/tr[1]/td[2]/a")
	WebElement getCompletedRequestIDNumber;

	@FindBy(xpath = "//a[contains(text(),'Request a Refund')]")
	WebElement openRefundRequestPage;

	@FindBy(xpath = "//span[contains(text(),'Select an Option')]")
	WebElement dropDownRequestIdentificationNumber;

	@FindBy(xpath = "//*[@id='refund_request_request_id_chosen']/div/div/input")
	WebElement inputRequestIdentificationNumber;

	@FindBy(xpath = "//*[contains(text(),' Due From Requestor')]//preceding::li[1]/span")
	WebElement getrequestReundPrice;

	@FindBy(xpath = "//span[contains(text(),'Select')]")
	WebElement dropDownRefundPrice;

	@FindBy(xpath = "//input[@id='refund_request_amount_requested']")
	WebElement inputRefundPrice;

	@FindBy(xpath = "//div[@id='refund_request_reason_chosen']//span")
	WebElement dropDownReasonForRequestRefund;

	@FindBy(xpath = "//div[@id='refund_request_reason_chosen']//input[@type='text']")
	WebElement inputReasonForRequestRefund;

	@FindBy(xpath = "//textarea[@id='refund_request_additional_comment']")
	WebElement inputAdditionalComments;

	@FindBy(xpath = "//a[@class='upload-txt add_fields']")
	WebElement uploadFileForRequestRefund;

	@FindBy(xpath = "//input[@id='mailing_address1']")
	WebElement refundRequestAdress1;
	
	@FindBy(xpath = "//input[@id='refund_request_city']")
	WebElement refundRequestCity;
	
	@FindBy(xpath = "//input[@id='refund_request_zip']")
	WebElement refundRequestZip;

	@FindBy(xpath = "//input[@value='Request Refund']")
	WebElement buttonRequestRefund;

	@FindBy(xpath = "//h2[contains(text(),'Request a Refund')]")
	WebElement headingForCompletingRefund;

	@FindBy(xpath = "//a[contains(text(),'Back to Home')]")
	WebElement buttonBackToHome;

	@FindBy(xpath = "//a[@href='/refund_requests']")
	WebElement openRefundProcessing;

	@FindBy(xpath = "//a[contains(text(),'Filter')]")
	WebElement buttonFilterAndSearchRefund;

	@FindBy(xpath = "//input[@id='search_request_id']")
	WebElement inputRequestIDRefundProcess;

	@FindBy(xpath = "//input[@value='Search']")
	WebElement buttonRefundSearch;

	@FindBy(xpath = "//a[contains(normalize-space(),'Review Refund')]")
	WebElement linkReviewRefund;

	@FindBy(xpath = "//a[contains(text(),'Approve Refund')]")
	WebElement buttonApproveRefund;

	@FindBy(xpath = "//a[contains(text(),'Deny Refund')]")
	WebElement buttonDenyRefund;

	@FindBy(xpath = "//label[contains(text(),'Full Refund')]")
	WebElement checkboxFullRefund;

	@FindBy(xpath = "//label[contains(text(),'Partial Refund')]")
	WebElement checkboxPartialRefund;

	@FindBy(xpath = "//input[@value='Approve']")
	WebElement buttonFinalApproveRefund;

	@FindBy(xpath = "//input[@id='refund_request_amount_issued']")
	WebElement inputManualAmountRefund;

	@FindBy(xpath = "//a[contains(text(),'Custodian View')]")
	WebElement buttonCustodianView;

	@FindBy(xpath = "//h4[contains(text(),'Reason for Accessing Request')]")
	WebElement headingforProcessing;

	@FindBy(xpath = "//label[contains(text(),'Processing')]")
	WebElement labelForProcessing;

	@FindBy(xpath = "//input[@id='check_num']")
	WebElement inputCheckNumber;

	@FindBy(xpath = "//input[@id='check_amt']")
	WebElement inputcheckAmount;

	@FindBy(xpath = "//input[@id='submit-check-btn']")
	WebElement submitCheckDetails;

	@FindBy(xpath = "//strong[@id='cus_bag_type']")
	WebElement getNameofBank;

	@FindBy(xpath = "//div[@id='notice']")
	WebElement getMessage;
	
	@FindBy(xpath = "//input[@id='batch_check_number']")
	WebElement inputChequeNumber;
	
	@FindBy(xpath = "//input[@value='Search All']")
	WebElement buttonSearchAll;
	
	@FindBy(xpath = "//table[@class='table table-hover check-batch-table']/tbody/tr")
	WebElement searchResultChequeFind;
	
	@FindBy(xpath = "//a[contains(text(),'Last »')]")
	WebElement lastPageOfResults;
	
	@FindBy(xpath = "//input[@value='Deny Refund']")
	WebElement denyButton;
	
	@FindBy(xpath = "//span[@class='col-md-12 custom_label_text']")
	WebElement headingOfDenying;
	
	@FindBy(xpath = "//textarea[@id='refund_request_denial_reason']")
	WebElement textAreaRefundRequestDenialReason;
	
	@FindBy(xpath = "//div[@class='Box-root Margin-left--8 Flex-flex Flex-alignItems--baseline Flex-direction--row']")
	WebElement dropdownStripe;
	
	@FindBy(xpath = "//input[@aria-label='Search…']")
	WebElement searchBoxStripe;
	
	@FindBy(xpath = "//div[@id='search_status_chosen']//ul[@class='chosen-choices']")
	WebElement textboxRefundStatus;
	
	@FindBy(xpath = "//tbody/tr[1]/td[5]")
	WebElement refundStatsValue;
	
	@FindBy(xpath = "//a[normalize-space()='Reset']")
	WebElement buttonResetFilterAndSearch;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]/a")
	WebElement refundStatsRequest;
	
	/*@FindBy(xpath = "//a[@class='btn dropdown-toggle btn-trans requestor-dropdown']")
	static WebElement nameoFtheUser;*/
	
	@FindBy(xpath = "//a[@class='no-wrap-id']")
	WebElement linkSearchRequestID;
	
	@FindBy(xpath = "//a[normalize-space()='[adm] Requestor View']")
	WebElement textadmRequestorView;

	
	public AdminExecutivePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Open the Executive Page from the admin page
	 */
	public void openExecutivePage(String executivePinCode) {
		System.out.println("Opening the Admin Drop Down");
		TestListener.infoMessage("OPening the ");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDownExecutivePage));
		adminDropDownExecutivePage.click();
		TestListener.infoMessage("Opening the Executive Page");
		wait.until(ExpectedConditions.visibilityOf(headingExecutiveAccess));
		inputPin.sendKeys(executivePinCode);
		buttonEnter.click();
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Open the Executive Page from the admin page and select the add
	 *              partner
	 * 
	 * @param Partner Address1
	 * @param Partner Request Type
	 */
	public void addPatners(String partnerAddress1, String partnerRequestorType) {
		wait.until(ExpectedConditions.elementToBeClickable(buttonPartners));
		buttonPartners.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonAddPartners));
		buttonAddPartners.click();
		TestListener.infoMessage("Click on Add Partner Button");
		wait.until(ExpectedConditions.elementToBeClickable(headingAddaPartner));
		String tempPartnerFullName = TestUtil.getAlphaDynamicString(6);
		System.out.println("Name is : " + tempPartnerFullName);
		TestListener.infoMessage("Partner Name is "+tempPartnerFullName);
		inputPartnerName.sendKeys(tempPartnerFullName);
		inputPartnerAddress1.sendKeys(partnerAddress1);
		inputPartnerAddress1.sendKeys(Keys.DOWN);
		inputPartnerAddress1.click();
		/*
		 * inputPartnerCity.sendKeys(partnerCityName); selectState(StateName);
		 * inputPartnerZipcode.sendKeys(partnerZipCode);
		 */
		selectRequestorType(partnerRequestorType);
		buttonCreatePartner.click();
		int noOfSize = driver.findElements(By.xpath("//table[@class='table table-striped table-hover']/tbody/tr"))
				.size();
		for (int i = 1; i <= noOfSize; i++) {
			String actualPartnerName = driver
					.findElement(
							By.xpath("//table[@class='table table-striped table-hover']/tbody/tr[" + i + "]/td[1]"))
					.getText();
			if (actualPartnerName.equalsIgnoreCase(tempPartnerFullName)) {
				System.out.println("Partner Added Successfully");
				TestListener.infoMessage("Partner Name is "+tempPartnerFullName);
				break;
			} else {
				System.out.println("Partner Added Un-Successfully");
				TestListener.infoMessageFail("Unable To Add Partner "+tempPartnerFullName);
			}
		}
	}

	public void selectState(String partnerStateName) {
		Select selectState = new Select(driver.findElement(By.name("partner[state]")));
		selectState.selectByVisibleText(partnerStateName);
	}

	public void selectRequestorType(String partnerRequestorType) {
		Select selectState = new Select(driver.findElement(By.name("partner[requestor_type]")));
		selectState.selectByVisibleText(partnerRequestorType);
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Open the Executive Page from the admin page and open the
	 *              Requestor Bulk Upload Section and perform the Abandon Request
	 * 
	 * @param Partner Address1
	 * @param Partner Request Type
	 */
	public void bulkUploadRequestorAbandon(boolean Custodian) {
		wait.until(ExpectedConditions.elementToBeClickable(buttonBulkUploadRequestor));
		if (Custodian) {
			buttonBulkUploadRequestor.click();
			buttonBulkUploadCustodian.click();
			TestListener.infoMessage("Opening of Custodian Bulk Upload");
		} else {
			buttonBulkUploadRequestor.click();
			TestListener.infoMessage("Opening of Requestor Bulk Upload");
		}
		// String tempRequestIdNo = getRequestIDNumber.getText();
		String tempURL = driver.getCurrentUrl();
		System.out.println("Temp URL " + tempURL);
		if (TestUtil.isElementDisplayed(lastPageOfResults)) {
			lastPageOfResults.click();
		}
		String tempAttributeValue = getRequestIDNumber.getAttribute("href");
		System.out.println("Temp Attribute Value " + tempAttributeValue);
		TestListener.infoMessage("Opening URL in new tab is "+tempAttributeValue);
		TestUtil.hardWait(10);
		TestUtil.openNewTabWithURL(tempAttributeValue);
		wait.until(ExpectedConditions.visibilityOf(buttonReasonForProcessing));
		buttonReasonForProcessing.click();
		TestUtil.hardWait(5);
		TestUtil.swtichTab(0);
		wait.until(ExpectedConditions.visibilityOf(checkboxRequestIDNumber));
		checkboxRequestIDNumber.click();
		buttonAbandonRequest.click();
		TestListener.infoMessage("Click on Abandon Request");
		selectReasonAsOthers.click();
		inputReasonForOthers.sendKeys("Automation");
		buttonSubmitReasonForOthers.click();
		wait.until(ExpectedConditions.elementToBeClickable(finalConfrimationOfAbandonRequest));
		finalConfrimationOfAbandonRequest.click();
		TestUtil.hardWait(5);
		driver.switchTo().alert().accept();
		TestUtil.swtichTab(1);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(buttonReasonForProcessing));
		buttonReasonForProcessing.click();
		String tempMessage = lastMessageCustodianInternalView.getText();
		if (tempMessage.contains("Request abandoned by requestor. Reason: Automation")) {
			Assert.assertTrue(true, "Request Get Abandoned");
			System.out.println(">>>>>Request Get Abandoned<<<<<");
			TestListener.infoMessage(">>>>>Request Get Abandoned<<<<<");
		} else {
			Assert.assertFalse(false, "Request unable to Get Abandoned");
			System.out.println(">>>>>Request unable to Get Abandoned<<<<<");
			TestListener.infoMessageFail(">>>>>Request unable to Get Abandoned<<<<<");
		}
		String tempStatusOfRequest = statusOfTheRequest.getText();
		if (tempStatusOfRequest.contains("Abandoned by requestor")) {
			Assert.assertTrue(true, "Status of Request Changed");
			System.out.println(">>>>>Status of Request Changed<<<<<");
			TestListener.infoMessage(">>>>>Status of Request Changed<<<<<");
		} else {
			Assert.assertFalse(false, "Status of Request NOT Changed");
			System.out.println(">>>>>Status of Request NOT Changed<<<<<");
			TestListener.infoMessageFail(">>>>>Status of Request NOT Changed<<<<<");
		}
	}

	public void sessionDetailsReportByUserType(String userType) {
		System.out.println(">>>>>Search Session Details For " + userType);
		TestListener.infoMessage(">>>>>Search Session Details For " + userType);
		wait.until(ExpectedConditions.elementToBeClickable(buttonSessionDetailsReport));
		buttonSessionDetailsReport.click();
		selectUserType(userType);
		buttonSearchSessionDetailsReport.click();
		wait.until(ExpectedConditions.visibilityOf(searchResultSessionDetailsReport));
		if (TestUtil.isElementDisplayed(searchResultSessionDetailsReport)) {
			System.out.println(">>>>>Search Session Deatils is Working For <<<<<" + userType);
			TestListener.infoMessage(">>>>>Search Session Deatils is Working For <<<<<" + userType);
		} else {
			System.out.println(">>>>>Search Session Deatils is NOT Working <<<<<" + userType);
			TestListener.infoMessageFail(">>>>>Search Session Deatils is Working For <<<<<" + userType);

		}
	}

	public void SessionDetailsReportByUserName(String userName) {
		wait.until(ExpectedConditions.elementToBeClickable(buttonSessionDetailsReport));
		buttonSessionDetailsReport.click();
		inputUserNameSessionDetailsReport.sendKeys(userName);
		buttonSearchSessionDetailsReport.click();
		wait.until(ExpectedConditions.visibilityOf(searchResultSessionDetailsReport));
		if (TestUtil.isElementDisplayed(searchResultSessionDetailsReport)) {
			System.out.println(">>>>>Search Session Deatils is Working<<<<<");
			TestListener.infoMessage(">>>>>Search Session Deatils is Working<<<<<");
		} else {
			System.out.println(">>>>>Search Session Deatils is NOT Working<<<<<");
			TestListener.infoMessageFail(">>>>>Search Session Deatils is NOT Working<<<<<");
		}
	}

	public void selectUserType(String UserType) {
		Select selectState = new Select(driver.findElement(By.name("search[user_type]")));
		selectState.selectByVisibleText(UserType);
	}

	public void searchChequeNumber() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonRecordPayment));
		buttonRecordPayment.click();
		wait.until(ExpectedConditions.elementToBeClickable(linkCheckCollected));
		linkCheckCollected.click();
	}

	public String getMonthName() {
		Calendar c = Calendar.getInstance();
		return c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH);
	}

	public String getCompletedRequestNumber() {
		wait.until(ExpectedConditions.elementToBeClickable(completedRequestTab));
		completedRequestTab.click();
		TestUtil.hardWait(5);
		String requestNumber = getCompletedRequestIDNumber.getText();
		getCompletedRequestIDNumber.click();
		System.out.println("Request Id is :- " + requestNumber);
		return requestNumber;
	}

	public String getRefundPrice() {
		wait.until(ExpectedConditions.visibilityOf(getrequestReundPrice));
		String tempRefundPrice = getrequestReundPrice.getText().replaceAll("$", "");
		System.out.println("Refund Price is :- " + tempRefundPrice);
		return tempRefundPrice;
	}

	public void refundRequest(String RequestIdNumber, String refundPrice, String reasonForReFund,
			String refundRequestAddress) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(openRefundRequestPage));
			TestListener.infoMessage("Opening of Refund a Request Page");
			openRefundRequestPage.click();
			dropDownRequestIdentificationNumber.click();
			TestListener.infoMessage("Request Number is "+RequestIdNumber);
			inputRequestIdentificationNumber.sendKeys(RequestIdNumber);
			inputRequestIdentificationNumber.sendKeys(Keys.ENTER);
			dropDownRefundPrice.click();
			inputRefundPrice.sendKeys(refundPrice);
			dropDownReasonForRequestRefund.click();
			TestListener.infoMessage("Refund Price is "+refundPrice);
			inputReasonForRequestRefund.sendKeys(reasonForReFund);
			inputReasonForRequestRefund.sendKeys(Keys.ENTER);
			TestListener.infoMessage("Reason of refund is "+reasonForReFund);
			inputAdditionalComments.sendKeys("Automation Testing");
			
			uploadFileForRequestRefund.click();
			TestUtil.hardWait(5);
			try {
				Runtime.getRuntime()
						.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/FileUploadAuth.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
			 
			TestUtil.hardWait(5);
			refundRequestAdress1.sendKeys(refundRequestAddress);
			refundRequestAdress1.sendKeys(Keys.TAB);
			refundRequestCity.sendKeys(GlobalVariables.GlobalCityName);
			Select selectSize = new Select(driver.findElement(By.name("refund_request[state]")));
			selectSize.selectByVisibleText("IN");
			refundRequestZip.sendKeys(GlobalVariables.GlobalZipCode);
			buttonRequestRefund.click();
			wait.until(ExpectedConditions.visibilityOf(headingForCompletingRefund));
			TestUtil.hardWait(10);
			buttonBackToHome.click();
			System.out.println("Waiting for processing the request for 10 Seconds");
			} catch (Exception e) {
				e.printStackTrace();
			}}

	public void processingRefund(String RequestID, boolean ApproveRefund, boolean FullRefund, String reasonForDeny) {
		try {

			TestUtil.hardWait(5);
			wait.until(ExpectedConditions.elementToBeClickable(openRefundProcessing));
			openRefundProcessing.click();
			TestListener.infoMessage("Opening The Refund Request For Processing");
			wait.until(ExpectedConditions.elementToBeClickable(buttonFilterAndSearchRefund));
			buttonFilterAndSearchRefund.click();
			wait.until(ExpectedConditions.elementToBeClickable(inputRequestIDRefundProcess));
			inputRequestIDRefundProcess.sendKeys(RequestID);
			System.out.println("Request Id For Refund Process is:- " + RequestID);
			TestListener.infoMessage("Request Id For Refund Process is:- " + RequestID);
			buttonRefundSearch.click();
			wait.until(ExpectedConditions.visibilityOf(linkReviewRefund));
			linkReviewRefund.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonApproveRefund));
			if (ApproveRefund) {
				buttonApproveRefund.click();
				if (FullRefund) {
					checkboxFullRefund.click();
					buttonFinalApproveRefund.click();
					TestListener.infoMessage("Full Amount Refund");
				} else {
					checkboxPartialRefund.click();
					wait.until(ExpectedConditions.visibilityOf(inputManualAmountRefund));
					inputManualAmountRefund.clear();
					inputManualAmountRefund.sendKeys("10");
					buttonFinalApproveRefund.click();
					TestListener.infoMessage("Partial Amount Refund is $10");
				}
			} else {
				buttonDenyRefund.click();
				wait.until(ExpectedConditions.visibilityOf(headingOfDenying));
				selectWhyAreYouDenyingTheRefund(reasonForDeny);
				if (reasonForDeny.contains("Other")) {
					textAreaRefundRequestDenialReason.sendKeys("Automation");
				}
				denyButton.click();
				wait.until(ExpectedConditions.visibilityOf(getMessage));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBankName() {
		return getNameofBank.getText();
	}

	public String checkProcessingFromAdmin(String checkAmountToBePaid) {
		wait.until(ExpectedConditions.visibilityOf(buttonCustodianView));
		TestListener.infoMessage("Opening the request from the Admin for entering the Cheque Number");
		buttonCustodianView.click();
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);
		wait.until(ExpectedConditions.elementToBeClickable(buttonRecordPayment));
		buttonRecordPayment.click();
		wait.until(ExpectedConditions.elementToBeClickable(linkCheckCollected));
		linkCheckCollected.click();
		wait.until(ExpectedConditions.visibilityOf(inputCheckNumber));
		String checkNumber = TestUtil.getRandomNumericString(6);
		System.out.println("Check Number is :- " + checkNumber);
		TestListener.infoMessage("Check Number is :- " + checkNumber);
		inputCheckNumber.sendKeys(checkNumber);
		inputCheckNumber.sendKeys(Keys.TAB);
		inputcheckAmount.sendKeys(checkAmountToBePaid);
		inputcheckAmount.sendKeys(Keys.TAB);
		submitCheckDetails.click();
		wait.until(ExpectedConditions.visibilityOf(getMessage));
		String actualMessage = getMessage.getText();
		if (actualMessage.contains("paid by check")) {
			Assert.assertTrue(true, "Paid By Check");
			System.out.println("Requestor Paid Through Cheque");
			TestListener.infoMessage("Requestor Paid Through Cheque");
		} else {
			Assert.assertFalse(false, "Not Paid By Check");
			System.out.println("Requestor Not Paid Through Cheque");
			TestListener.infoMessageFail("Requestor Not Paid Through Cheque");
		}
		return checkNumber;
	}
	
	public void checkChequeThroughExecutivePage(String chequeNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(inputChequeNumber));
		inputChequeNumber.sendKeys(chequeNumber);
		buttonSearchAll.click();
		if (TestUtil.isElementDisplayed(searchResultChequeFind)) {
			Assert.assertTrue(true, "Find the Cheque No");
			TestListener.infoMessage("Find the Cheque No");
		} else {
			Assert.assertFalse(false, "NOT Find the Cheque No");
			TestListener.infoMessageFail("NOT Find the Cheque No");
		}
	}
	
	public void selectWhyAreYouDenyingTheRefund(String ReasonOfDenying) {
		Select selectSize = new Select(driver.findElement(By.name("refund_request[denial_default_reason]")));
		selectSize.selectByVisibleText(ReasonOfDenying);
	}
	
	public void verifyRefundFromStripe(String RequestNo) {
		wait.until(ExpectedConditions.visibilityOf(dropdownStripe));
		dropdownStripe.click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'Retrieval Account')]"))));
		WebElement retrievalAccount=driver.findElement(By.xpath("//span[contains(text(),'Retrieval Account')]"));
		retrievalAccount.click();
		
		Actions actions=new Actions(driver);
		actions.moveToElement(retrievalAccount).click().build().perform();
		//js.executeScript("arguments[0].click();", retrievalAccount);
		
		TestUtil.hardWait(10);
		driver.findElement(By.xpath("//input[@aria-label='Search…']")).sendKeys(RequestNo);
		driver.findElement(By.xpath("//input[@aria-label='Search…']")).sendKeys(Keys.ENTER);
		TestUtil.hardWait(10);
		driver.findElement(By.xpath("//span[@class='ListViewItem-text Text-color--gray Text-fontSize--14 Text-fontWeight--medium Text-lineHeight--20 Text-numericSpacing--proportional Text-typeface--base Text-wrap--wrap Text-display--inline']")).click();
		TestListener.addDynamicScreenshotInReport("verifyRefundFromStripe");	
	}
	
	public void refundFilterAndSearch(String RefundStatus) {
		//TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(openRefundProcessing));
		openRefundProcessing.click();
		TestListener.infoMessage("Opening The Refund Request For Processing");
		wait.until(ExpectedConditions.elementToBeClickable(buttonFilterAndSearchRefund));
		buttonFilterAndSearchRefund.click();
		wait.until(ExpectedConditions.elementToBeClickable(textboxRefundStatus));
		textboxRefundStatus.click();
		textboxRefundStatus.click();
		driver.findElement(By.xpath("//li[normalize-space()='"+RefundStatus+"']")).click();
		TestListener.infoMessage("Refund Status is Checking for "+RefundStatus);
		buttonRefundSearch.click();
		TestListener.addDynamicScreenshotInReport("refundFilterAndSearch");
	}
	
	public void verifySearchResult(String RefundStatus) {
		wait.until(ExpectedConditions.visibilityOf(refundStatsValue));
		String tempRefundStatus=refundStatsValue.getText();
		if (tempRefundStatus.contains(RefundStatus)) {
			System.out.println("Status Changed to "+RefundStatus);
			TestListener.infoMessage("Status Changed to "+RefundStatus);
		} else {
			System.out.println("Status NOT-Changed to "+RefundStatus);
			TestListener.infoMessageFail("Status NOT-Changed to "+RefundStatus);
		}
		TestListener.addDynamicScreenshotInReport("verifySearchResult");
	}
	
	public void resetFilterAndSearch() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonFilterAndSearchRefund));
		buttonFilterAndSearchRefund.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonResetFilterAndSearch));
		buttonResetFilterAndSearch.click();
		TestListener.infoMessage("Opening Refund Filter And Search Page");
		TestListener.addDynamicScreenshotInReport("resetFilterAndSearch");
	}

	public void openRequestInRefund() {
		/*wait.until(ExpectedConditions.elementToBeClickable(openRefundProcessing));
		openRefundProcessing.click();
		TestUtil.hardWait(5);*/
		wait.until(ExpectedConditions.elementToBeClickable(refundStatsRequest));
		refundStatsRequest.click();
		TestUtil.swtichTab(1);
		//String userName = nameoFtheUser.getText();
		//js.executeScript("arguments[0].click();", linkSearchRequestID);
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);
		String tempvalue=textadmRequestorView.getText();
		if (tempvalue.contains("[adm] Requestor View")) {
			System.out.println("Its a Custodian View");
			TestListener.infoMessage("Request is Viewed From The Custodian");
			TestListener.addDynamicScreenshotInReport("openRequestInRefund");
		} else {
			System.out.println("Its NOT-a Custodian View");
			TestListener.infoMessageFail("Request is NOT-Viewed From The Custodian");
			TestListener.addDynamicScreenshotInReport("openRequestInRefund");
		}
	}
}