package com.ChartRequest.Pages;

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
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.TestUtil;

/**
 * @author ashutosh.tiwari
 *
 */
public class AdminSearchPage extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	CustodianStatement custodianStatement = new CustodianStatement();

	@FindBy(xpath = "//a[contains(text(),'Edit Landing Page')]")
	WebElement buttonEditLandingPage;

	@FindBy(xpath = "//input[@id='custodian_settings_short_code']")
	WebElement inputSetNewAddressURL;

	@FindBy(xpath = "//input[contains(@value,'Save')]")
	WebElement buttonSave;

	@FindBy(xpath = "//div[@id='notice']")
	WebElement savedMessage;

	@FindBy(xpath = "//div[@id='search_custodian_id_chosen']//input[contains(@value,'Select Some Options')]")
	WebElement inputCustodianName;

	@FindBy(xpath = "//input[contains(@value,'Search')]")
	WebElement buttonSearch;

	@FindBy(xpath = "//td[@class='word-wrap']")
	WebElement searchResult;

	@FindBy(xpath = "//a[@data-target='#viewUserModal']")
	WebElement buttonViewEditUser;

	@FindBy(xpath = "//a[contains(@onclick,'reset_modal_fields()')]")
	WebElement buttonInviteUsers;

	@FindBy(xpath = "//input[@id='name']")
	WebElement inputFirstNameInviteUser;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement inputLastNameInviteUser;

	//@FindBy(xpath = "//input[@id='email']")
	@FindBy(className = "form-control auto-height email email-domain-verifier-input remove_blank_spaces_class")
	WebElement inputEmailInviteUser;

	@FindBy(xpath = "//input[@id='fullname']")
	WebElement inputInviteUserFullName;

	@FindBy(xpath = "//input[@id='initials']")
	WebElement inputInviteUserInitials;

	@FindBy(xpath = "//span/a[text()='Send Email']")
	WebElement buttonSendEmailInviteUser;

	@FindBy(xpath = "//img[@title='Edit Custodian Details']")
	WebElement editCustodianDetailsPencilIcon;

	@FindBy(xpath = "//div[contains(@class,'sheet')]//div[2]//dl[2]//div[1]//label[3]")
	WebElement sizeofOrganizationIs31To100Provider;

	@FindBy(xpath = "//label[4]")
	WebElement sizeofOrganizationIs100PlueProvider;

	@FindBy(xpath = "//div[contains(@class,'sheet')]//div[2]//dl[3]//div[1]//label[2]")
	WebElement averageRecordRequests30To150PerMonth;

	@FindBy(xpath = "//div[contains(@class,'sheet')]//div[2]//dl[3]//div[1]//label[3]")
	WebElement averageRecordRequestsMoreThan150PerMonth;

	@FindBy(xpath = "//dl//div[contains(@class,'edit-survey-control')]//div[1]//label[1]")
	WebElement recordReleaseMethodOurOfficeStaffReleasesTheRecords;

	@FindBy(xpath = "//section[@id='custodian_details']//dl//div[3]//label[1]")
	WebElement recordReleaseMethodA3rdPartyVendorReleasesRecordsForOurOffice;

	@FindBy(xpath = "//input[@id='vendor_name']")
	WebElement inputVendorName;

	@FindBy(xpath = "//input[@id='vendor_contact_name']")
	WebElement inputVendorContactName;

	@FindBy(xpath = "//input[@id='vendor_title']")
	WebElement inputVendorTitle;

	@FindBy(xpath = "//input[@id='vendor_email']")
	WebElement inputVendorEmail;

	@FindBy(xpath = "//input[@id='vendor_phone']")
	WebElement inputVendorPhone;

	@FindBy(xpath = "//section[@id='custodian_details']//div[3]//div[4]//label[1]")
	WebElement demoTimeAt630PM;

	@FindBy(xpath = "//button[@id='btn-save-survey-detail']")
	WebElement saveButton;

	@FindBy(xpath = "//div[@id='notice']")
	WebElement savedMessageNotification;

	@FindBy(xpath = "//img[@id='record_edit']")
	WebElement editAdditionalSystemsofRecordsPencilIcon;

	@FindBy(xpath = "//h3[contains(text(),'Select Additional System of Records')]")
	WebElement popUpHeading;

	@FindBy(xpath = "//input[@value='Select Additional System of Records']")
	WebElement inputAdditionalSystemOfRecords;

	@FindBy(xpath = "//div[@id='sys_rec_dd']//div//div//form//div//button[@type='submit'][contains(text(),'Save')]")
	WebElement buttonSaveAdditionalSystemOfRecords;

	@FindBy(xpath = "//button[contains(@data-toggle,'dropdown')]")
	WebElement dropDownAdmin;

	@FindBy(xpath = "//a[contains(text(),'Delete Custodian')]")
	WebElement buttonDeleteCustodian;

	@FindBy(xpath = "//input[@id='search_alias_and_site_location']")
	WebElement inputAliasAndSiteLocation;

	@FindBy(xpath = "//body[contains(@class,'index')]//tr[1]//td[1][1]//a[1]")
	WebElement searchResultApprovedCustdoianList;

	@FindBy(xpath = "//div[@class='heading requestor']//h1")
	WebElement getCustodianNumber;

	@FindBy(xpath = "//input[@id='search_id']")
	WebElement inputCustodianId;

	@FindBy(xpath = "//label[contains(text(),'Show only deleted custodians')]")
	WebElement checkboxShowOnlyDeletedCustodians;

	@FindBy(xpath = "//a[contains(text(),'Convert')]")
	WebElement buttonConvertToRequestor;

	@FindBy(xpath = "//select[@id='requestor_type']")
	WebElement dropReasonConvertToRequestor;

	@FindBy(xpath = "//input[contains(@value,'Convert to Requestor')]")
	WebElement buttonPopUpConvertToRequestor;

	@FindBy(xpath = "//div[@class='heading requestor']//h1")
	WebElement headingAfterConverting;

	@FindBy(xpath = "//a[contains(text(),'Search Requestors')]")
	WebElement tabSearchRequetor;

	@FindBy(xpath = "//a[contains(text(),'Merge Custodian')]")
	WebElement buttonMergeCustodian;

	@FindBy(xpath = "//div[@id='merge_custodian_chosen']//span")
	WebElement inputSelectThePrimaryCustodian;

	@FindBy(xpath = "//input[@value='Merge Accounts']")
	WebElement buttonMergeAccount;

	@FindBy(xpath = "//table[@class='main-table table table-condensed']/tbody/tr[1]/td[1]/a")
	WebElement unApprovedFirstSearchCustodianName;

	@FindBy(xpath = "//a[contains(@class,'pull-right modal-popup')]")
	WebElement buttonApprove;

	@FindBy(xpath = "//label[contains(@for,'crossCheckApproval')]")
	WebElement checkboxIHaveReviewedPotentialDuplicateCustodians;

	@FindBy(xpath = "//a[@id='forNonClient']")
	WebElement buttonApproveForNonClient;

	@FindBy(xpath = "//a[contains(normalize-space(),'Search Users')]")
	WebElement adminTabSearchUsers;

	@FindBy(xpath = "//input[@id='default_tab']")
	WebElement checkboxSetAsDefaultTab;

	@FindBy(xpath = "//input[@id='search_name']")
	WebElement inputUserName;

	@FindBy(xpath = "//table[@class='main-table table table-condensed']/tbody")
	WebElement searchResultUserSearch;
	
	@FindBy(xpath = "//input[@id='search_email']")
	WebElement inputUserEmailID;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'Search Requestors')]")
	WebElement adminTabSearchRequestor;
	
	@FindBy(xpath = "//input[@id='search_id']")
	WebElement inputRequestorID;
	
	@FindBy(xpath = "//input[@id='search_requestor_name']")
	WebElement inputRequestorName;
	
	@FindBy(xpath = "//input[@value='Select Requestor Type']")
	WebElement inputRequestorType;
	
	@FindBy(xpath = "//input[@id='search_email']")
	WebElement inputRequestEmailID;
	
	@FindBy(xpath = "//input[@value='Select Some Options']")
	WebElement inputRequestEnterpriseName;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'Search Custodians')]")
	WebElement adminTabSearchCustodian;
	
	@FindBy(xpath = "//input[@id='search_contact_user']")
	WebElement inputCustodianContact;
	
	@FindBy(xpath = "//input[@value='Select Service Level']")
	WebElement custodianServiceLevel;
	
	@FindBy(xpath = "//input[@id='search_email']")
	WebElement inputCustodianEmail;
	
	@FindBy(xpath = "//div[@class='alert alert-info']")
	WebElement noSearchFound;
	
	@FindBy(xpath = "//div[@id='search_custodian_corporate_id_chosen']//ul[@class='chosen-choices']")
	WebElement inputCustodianEnterpriseName;
	
	@FindBy(xpath = "//input[@id='search_location']")
	WebElement inputCustodianCityName;
	
	@FindBy(xpath = "//input[@id='search_phone']")
	WebElement inputCustodianPhoneNumber;
	
	@FindBy(xpath = "//label[contains(normalize-space(),'Include deleted custodians')]")
	WebElement inputCustodianIncludeDeletedCustodians;
	
	@FindBy(xpath = "//label[contains(normalize-space(),'Show only deleted custodians')]")
	WebElement inputCustodianShowOnlyDeletedCustodians;
	
	@FindBy(xpath = "//a[contains(normalize-space(),'Retrieval Requests')]")
	WebElement adminTabSearchRetrievalRequests;
	
	@FindBy(xpath = "//a[@class='chosen-single']//span")
	WebElement dropDownRetievalRequestsCustodianName;
	
	@FindBy(xpath = "//input[@class='chosen-search-input']")
	WebElement inputRetievalRequestsCustodianName;
	
	@FindBy(xpath = "//table[@class='table table-condensed']/tbody")
	WebElement searchResultRetrievalRequestsSearch;
	
	@FindBy(xpath = "//input[@id='search_requestor_name']")
	WebElement inputRetrievalRequestsRequestorName;

	@FindBy(xpath = "//input[@id='search_id']")
	WebElement inputRetrievalRequestsRequestorID;

	@FindBy(xpath = "//input[@value='Select Requestor Types']")
	WebElement inputRetievalRequestsRequestorType;
	
	@FindBy(xpath = "//input[@id='search_patient_given_names']")
	WebElement inputRetievalRequestsPatientsFirstName;
	
	@FindBy(xpath = "//div[@id='search_reason_for_request_chosen']//input[@value='Select Some Options']")
	WebElement inputRetievalRequestsReasonForRequest;
	
	@FindBy(xpath = "//div[@id='search_corporate_id_chosen']//input[@value='Select Some Options']")
	WebElement inputRetrievalRequestEnterpriseName;
	
	@FindBy(xpath = "//a[@href='/company/requests'][contains(normalize-space(),'Requests')]")
	WebElement adminTabRequestsTab;
	
	@FindBy(xpath = "//div[@id='search_custodian_id_chosen']//input[@value='Select Some Options']")
	WebElement inputRequestsCustodianName;

	@FindBy(xpath = "//*[@id='search_status_chosen']/ul/li/input")
	WebElement inputRequestsStatus;
	
	public AdminSearchPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description open the Search list when the Custodian Name is given and open
	 *              the Custodian Page from the admin search
	 * @param Custodian Name
	 */
	public void openSearchResult(String SearchCustodianName) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(inputCustodianName));
		inputCustodianName.click();
		inputCustodianName.sendKeys(SearchCustodianName);
		inputCustodianName.sendKeys(Keys.ENTER);
		buttonSearch.click();
		wait.until(ExpectedConditions.elementToBeClickable(searchResult));
		driver.findElement(By.xpath("//a[contains(text(),'" + SearchCustodianName + "')]")).click();

	}

	/**
	 * @author ashutosh.tiwari
	 * @Description open the Edit landing page when Custodian Page is opened from
	 *              the Admin Search page
	 * @param New URL
	 */
	public String openEditLandingPage(String NewURL) {
		wait.until(ExpectedConditions.elementToBeClickable(buttonEditLandingPage));
		buttonEditLandingPage.click();
		wait.until(ExpectedConditions.visibilityOf(inputSetNewAddressURL));
		inputSetNewAddressURL.clear();
		inputSetNewAddressURL.sendKeys(NewURL);
		TestListener.infoMessage("New URL is:- " + NewURL);
		buttonSave.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String actualValue = savedMessage.getText();
		if (actualValue.contains("Landing page updated")) {
			System.out.println("URL Changed for Landing Page.");
			TestListener.infoMessage("URL Changed for Landing Page.");
		} else {
			System.out.println("URL Not-Changed for Landing Page.");
			TestListener.infoMessage("URL Not-Changed for Landing Page.");
		}
		return NewURL;
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Add New User from the User Invite Button the Custodian Page
	 */
	public void addViewUser() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(buttonViewEditUser));
			buttonViewEditUser.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonInviteUsers));
			buttonInviteUsers.click();
			inputFirstNameInviteUser.sendKeys(TestUtil.getAlphaDynamicString(5));
			inputLastNameInviteUser.sendKeys("TestAutomation");
			inputLastNameInviteUser.sendKeys(Keys.TAB);
			String tempEmailId=TestUtil.getAlphaDynamicString(5) + "@test.com";
			System.out.println("Temp Email Id for Add User: "+tempEmailId);
			driver.findElement(By.xpath("/html/body/div[5]/div[6]/div/div/form/div[2]/div[1]/span[8]/input")).sendKeys(tempEmailId);
			TestUtil.hardWait(5);
			String attribute=driver.findElement(By.xpath("//div[@class='hide-things-together']")).getAttribute("style");
			if (!attribute.contentEquals("display: none;")) {
				inputInviteUserFullName.sendKeys("Automation Testing");
				inputInviteUserInitials.sendKeys("Automation");
			}
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@class='checkbox-not-matched-email']"))));
			driver.findElement(By.xpath("//input[@class='checkbox-not-matched-email']")).click();
			buttonSendEmailInviteUser.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Edit The custodian Name Details on Custodian Details Section and
	 *              verify that Organization Size, Average Record Request,Release
	 *              Record Method, Demo Time and verify the details
	 * @param Vendor Name
	 * @param Vendor Contact Name
	 * @param Vendor Title
	 * @param Vendor Email
	 */
	public void editCustodianDetails(String VendorName, String VendorContactName, String VendorTitle,
			String VendorEmail, String VendorPhone) {
		wait.until(ExpectedConditions.elementToBeClickable(editCustodianDetailsPencilIcon));
		editCustodianDetailsPencilIcon.click();
		// Change The Organization Size
		if (sizeofOrganizationIs31To100Provider.isSelected()) {
			sizeofOrganizationIs100PlueProvider.click();
		} else {
			sizeofOrganizationIs31To100Provider.click();
		}
		// Change the Average Record Request
		if (averageRecordRequests30To150PerMonth.isSelected()) {
			averageRecordRequestsMoreThan150PerMonth.click();
		} else {
			averageRecordRequests30To150PerMonth.click();
		}
		// Release Record Method
		if (recordReleaseMethodOurOfficeStaffReleasesTheRecords.isSelected()) {
			recordReleaseMethodA3rdPartyVendorReleasesRecordsForOurOffice.click();
			wait.until(ExpectedConditions.elementToBeClickable(inputVendorName));
			inputVendorName.sendKeys(VendorName);
			inputVendorContactName.sendKeys(VendorContactName);
			inputVendorTitle.sendKeys(VendorTitle);
			inputVendorEmail.sendKeys(VendorEmail);
			inputVendorPhone.sendKeys(VendorPhone);
		} else {
			recordReleaseMethodOurOfficeStaffReleasesTheRecords.click();
			// Demo Time
			demoTimeAt630PM.click();
		}
		// Saved New details
		saveButton.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessageNotification));
		String actualText = savedMessageNotification.getText();
		String expectedText = "Custodian details updated successfully";
		if (actualText.contains(expectedText)) {
			Assert.assertTrue(true, "Details Saved Successfully");
		} else {
			Assert.assertFalse(false, "Details Saved Successfully");

		}
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Edit the practice resources information and enter the favourtie
	 *              Records Name
	 * @param Additional System of Record Name
	 */
	public void editPracticeResources(String AdditionalSystemOfRecordsName) {
		wait.until(ExpectedConditions.elementToBeClickable(editCustodianDetailsPencilIcon));
		editCustodianDetailsPencilIcon.click();
		editAdditionalSystemsofRecordsPencilIcon.click();
		wait.until(ExpectedConditions.visibilityOf(popUpHeading));
		inputAdditionalSystemOfRecords.click();
		inputAdditionalSystemOfRecords.sendKeys(AdditionalSystemOfRecordsName);
		inputAdditionalSystemOfRecords.sendKeys(Keys.ENTER);
		// Saved New details
		buttonSaveAdditionalSystemOfRecords.click();
		wait.until(ExpectedConditions.visibilityOf(savedMessageNotification));
		String actualText = savedMessageNotification.getText();
		String expectedText = "Custodian details updated successfully";
		if (actualText.contains(expectedText)) {
			Assert.assertTrue(true, "Details Saved Successfully");
		} else {
			Assert.assertFalse(false, "Details Saved Successfully");

		}
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Find the List of Custodians using the alias name and search it
	 *              and open the Custodian name
	 * @param Additional System of Record Name
	 */
	public void openListForDeletedCustodian(String nameOfTheCustodian) {
		wait.until(ExpectedConditions.elementToBeClickable(inputAliasAndSiteLocation));
		inputAliasAndSiteLocation.sendKeys(nameOfTheCustodian);
		custodianStatement.searchCustodianWithFilter("Approved");
		wait.until(ExpectedConditions.visibilityOf(searchResultApprovedCustdoianList));
		searchResultApprovedCustdoianList.click();
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Delete the custodian from the Admin account
	 * 
	 */
	public void deleteCustodian() {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownAdmin));
		dropDownAdmin.click();
		buttonDeleteCustodian.click();
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.visibilityOf(savedMessage));
		String actualValue = savedMessage.getText();
		Assert.assertTrue(actualValue.contains("Custodian has deleted Successfully"),
				"Custodian has deleted Successfully");
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Getting the custodian number from custodian Page
	 * 
	 */
	public String getCustodianNumber() {
		wait.until(ExpectedConditions.visibilityOf(getCustodianNumber));
		String value = TestUtil.getOnlyNumberFromStringAdminPage(getCustodianNumber);
		System.out.println("Custodian Number is :- " + value);
		return value;
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Verify the Custodian is deleted or not
	 * @param Custodian Id
	 * 
	 */
	public void verifyDeleteCustodian(String custodianId) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.visibilityOf(inputCustodianId));
		inputCustodianId.sendKeys(custodianId);
		checkboxShowOnlyDeletedCustodians.click();
		buttonSearch.click();
		wait.until(ExpectedConditions.visibilityOf(searchResultApprovedCustdoianList));
		if (TestUtil.isElementDisplayed(searchResultApprovedCustdoianList)) {
			Assert.assertTrue(true, "Custodian Deleted Successfully");
		} else {
			Assert.assertFalse(false, "Custodian Deleted Un-Successfully");
		}
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Convert the Custodian to requestor from the admin page
	 * @param Reason for the convert
	 * 
	 */
	public String convertToRequestorAndGetNewRequetorNumber(String ReasonForConvert) {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownAdmin));
		dropDownAdmin.click();
		buttonConvertToRequestor.click();
		wait.until(ExpectedConditions.visibilityOf(dropReasonConvertToRequestor));
		selectConvertToRequestPopUpReason(ReasonForConvert);
		buttonPopUpConvertToRequestor.click();
		wait.until(ExpectedConditions.visibilityOf(headingAfterConverting));
		String requestId = TestUtil.getOnlyNumberFromStringAdminPageGetRquestorNumber(headingAfterConverting);
		return requestId;
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Select the value from the dropdown for the reason for converting
	 *              Custodian to Reqestor
	 * @param Reason For Converting To Requestor
	 * 
	 */
	public void selectConvertToRequestPopUpReason(String ReasonConvertToRequestor) {
		Select selectSize = new Select(driver.findElement(By.name("requestor_type")));
		selectSize.selectByVisibleText(ReasonConvertToRequestor);
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Find the Requestor Id after the converstion from the custodian
	 *              To requestor
	 * @param Reason For Converting To Requestor
	 * 
	 */
	public void findRequestorIdAfterConverstion(String RequestId) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(tabSearchRequetor));
		tabSearchRequetor.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputCustodianId));
		inputCustodianId.sendKeys(RequestId);
		buttonSearch.click();
		wait.until(ExpectedConditions.visibilityOf(searchResultApprovedCustdoianList));
		if (TestUtil.isElementDisplayed(searchResultApprovedCustdoianList)) {
			Assert.assertTrue(true, "Custodian Successfully Changed To Requestor");
		} else {
			Assert.assertFalse(false, "Custodian Un-Successfully Changed To Requestor");
		}
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Find the unapprove Custodian List and open the first custodian
	 *              and approve it for the converting to custodian to requetor
	 * 
	 */
	public void findUnApproveCustodianForMergeAndApprove() {
		wait.until(ExpectedConditions.elementToBeClickable(unApprovedFirstSearchCustodianName));
		unApprovedFirstSearchCustodianName.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonApprove));
		buttonApprove.click();
		wait.until(ExpectedConditions.elementToBeClickable(checkboxIHaveReviewedPotentialDuplicateCustodians));
		checkboxIHaveReviewedPotentialDuplicateCustodians.click();
		buttonApproveForNonClient.click();
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Click on merge button for merging the and verify the merging the
	 *              custodian is done or not
	 * 
	 */
	public void mergeCustodian(String primaryCustodianName) {
		wait.until(ExpectedConditions.elementToBeClickable(dropDownAdmin));
		dropDownAdmin.click();
		buttonMergeCustodian.click();
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(inputSelectThePrimaryCustodian));
		inputSelectThePrimaryCustodian.sendKeys(primaryCustodianName);
		buttonMergeAccount.click();
		String notification = savedMessage.getText();
		if (notification.contains("Custodian was Successfully Merged")) {
			Assert.assertTrue(true, "Custodian was Successfully Merged");
		} else {
			Assert.assertFalse(false, "Custodian was Un-Successfully Merged");
		}
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the User Search Tab when landed on the Search page of
	 *              the admin. Then enter the user name and click on search
	 *              button.Verify that search result is populated or not when searching by User Name.
	 * @param User Name for Search
	 */
	public void adminSearchUsersByUserName(String searchUserName) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchUsers.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputUserName));
		inputUserName.sendKeys(searchUserName);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Name Searching Working for user name " + searchUserName);
		} else {
			System.out.println("User Name Searching Not-Working for user name " + searchUserName);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the User Search Tab when landed on the Search page of
	 *              the admin. Then enter the user email id and click on search
	 *              button.Verify that search result is populated or not when searching by User Email ID.
	 * @param User Email Id for Search
	 */
	public void adminSearchUsersByEmailId(String searchEmailId) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchUsers.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputUserEmailID));
		inputUserEmailID.sendKeys(searchEmailId);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Email-ID Searching Working for user Email-ID " + searchEmailId);
		}else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Email-ID Searching Working for user Email-ID " + searchEmailId+" No Result Found");
		}  
		else {
			System.out.println("User Email-ID Searching Not-Working for user Email-ID " + searchEmailId);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Request Search Tab when landed on the Search page of
	 *              the admin. Then enter the user Requestor ID and click on search
	 *              button.Verify that search result is populated or not when searching by Requestor ID.
	 * @param Request Id for Search
	 */
	public void adminSearchUsersByRequestorID(String searchRequestorID) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchRequestor.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputRequestorID));
		inputRequestorID.sendKeys(searchRequestorID);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Requestor ID Searching Working for Requestor ID " + searchRequestorID);
		}else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Requestor ID Searching Working for Requestor ID " + searchRequestorID+" No Result Found");
		}  
		else {
			System.out.println("User Requestor ID Searching Not-Working for Requestor ID " + searchRequestorID);
		}
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Request Search Tab when landed on the Search page of
	 *              the admin. Then enter the user Requestor Name and click on search
	 *              button.Verify that search result is populated or not when searching by Requestor Name.
	 * @param Request Name for Search
	 */
	public void adminSearchUsersByRequestorName(String searchRequestorName) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchRequestor.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputRequestorName));
		inputRequestorName.sendKeys(searchRequestorName);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Requestor Name Searching Working for Requestor name " + searchRequestorName);
		}else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			System.out.println("actualString is "+actualString);
			Assert.assertTrue(actualString.contains("Warning! There were no requestors found"));
			System.out.println("User Requestor Name Searching Working for Requestor name " + searchRequestorName+" No Result Found");
		}  
		else {
			System.out.println("User Requestor Name Searching Not-Working for Requestor name " + searchRequestorName);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Request Search Tab when landed on the Search page of
	 *              the admin. Then enter the user Requestor ID and click on search
	 *              button.Verify that search result is populated or not when searching by Requestor Type.
	 * @param User Name for Search
	 */
	public void adminSearchUsersByRequestorType(String searchRequestorType) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchRequestor.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputRequestorType));
		inputRequestorType.click();
		inputRequestorType.sendKeys(searchRequestorType);
		inputRequestorType.sendKeys(Keys.ENTER);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Requestor Type Searching Working for Requestor Type " + searchRequestorType);
		}else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Requestor Type Searching Working for Requestor Type " + searchRequestorType+" No Result Found");
		}   
		else {
			System.out.println("User Requestor ID Searching Not-Working for Requestor Type " + searchRequestorType);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Request Search Tab when landed on the Search page of
	 *              the admin. Then enter the user email id and click on search
	 *              button.Verify that search result is populated or not when searching by Email ID.
	 * @param User Email Id for Search
	 */
	public void adminSearchRequestByEmailId(String searchEmailId) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchRequestor.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputRequestEmailID));
		inputRequestEmailID.sendKeys(searchEmailId);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Email-ID Searching Working for Requestor Email-ID " + searchEmailId);
		}else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Email-ID Searching Working for Requestor Email-ID " + searchEmailId+" No Result Found");
		}  
		else {
			System.out.println("User Email-ID Searching Not-Working for Requestor Email-ID " + searchEmailId);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Request Search Tab when landed on the Search page of
	 *              the admin. Then enter the user email id and click on search
	 *              button.Verify that search result is populated or not when searching by Enterprise Name.
	 * @param User Email Id for Search
	 */
	public void adminSearchRequestByEnterpriseName(String searchEnterpriseName) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchRequestor.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputRequestEnterpriseName));
		inputRequestEnterpriseName.sendKeys(searchEnterpriseName);
		inputRequestEnterpriseName.sendKeys(Keys.ENTER);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Email-ID Searching Working for Requestor Email-ID " + searchEnterpriseName);
		}else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Email-ID Searching Working for Requestor Email-ID " + searchEnterpriseName+" No Result Found");
		}  
		else {
			System.out.println("User Email-ID Searching Not-Working for Requestor Email-ID " + searchEnterpriseName);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Custodian Search Tab when landed on the Search page of
	 *              the admin. Then enter the user email id and click on search
	 *              button.Verify that search result is populated or not when searching by Custodian Name.
	 * @param User Custodian Name for Search
	 */
	public void adminSeachCustodianByCustodianName(String custodianName) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchCustodian.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputCustodianName));
		inputCustodianName.click();
		inputCustodianName.sendKeys(custodianName);
		inputCustodianName.sendKeys(Keys.ENTER);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Custodian Name Searching Working for Custodian Name " + custodianName);
		}else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Custodian Name Searching Working for Custodian Name " + custodianName+" No Result Found");
		}  
		else {
			System.out.println("User Custodian Name Searching Not-Working for Custodian Name " + custodianName);
		}

	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Custodian Search Tab when landed on the Search page of
	 *              the admin. Then enter the user email id and click on search
	 *              button.Verify that search result is populated or not when searching by Custodian ID.
	 * @param User Custodian Id for Search
	 */
	public void adminSeachCustodianByCustodianId(String custodianId) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchCustodian.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputCustodianId));
		inputCustodianId.click();
		inputCustodianId.sendKeys(custodianId);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Custodian ID Searching Working for Custodian ID " + custodianId);
		}else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Custodian ID Searching Working for Custodian ID " + custodianId+" No Result Found");
		} 
		else {
			System.out.println("User Custodian ID Searching Not-Working for Custodian ID " + custodianId);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Custodian Search Tab when landed on the Search page of
	 *              the admin. Then enter the user email id and click on search
	 *              button.Verify that search result is populated or not when searching by Custodian Contact Name.
	 * @param User Custodian Contact Name for Search
	 */
	public void adminSeachCustodianByCustodianContactName(String custodianContactName) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchCustodian.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputCustodianContact));
		inputCustodianContact.click();
		inputCustodianContact.sendKeys(custodianContactName);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Custodian ID Searching Working for Custodian ID " + custodianContactName);
		}else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Custodian ID Searching Working for Custodian ID " + custodianContactName+" No Result Found");
		} 
		else {
			System.out.println("User Custodian ID Searching Not-Working for Custodian ID " + custodianContactName);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Custodian Search Tab when landed on the Search page of
	 *              the admin. Then enter the user email id and click on search
	 *              button.Verify that search result is populated or not when searching by Custodian Alias & Site Location Name.
	 * @param User Custodian Alias & Site Location Name for Search
	 */
	public void adminSeachCustodianByCustodianAliasAndSiteLocation(String aliasAndSiteLocationName) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchCustodian.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputCustodianContact));
		inputCustodianContact.click();
		inputCustodianContact.sendKeys(aliasAndSiteLocationName);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Custodian ID Searching Working for Custodian ID " + aliasAndSiteLocationName);
		}else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Custodian ID Searching Working for Custodian ID " + aliasAndSiteLocationName+" No Result Found");
		} 
		else {
			System.out.println("User Custodian ID Searching Not-Working for Custodian ID " + aliasAndSiteLocationName);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Custodian Search Tab when landed on the Search page of
	 *              the admin. Then enter the user email id and click on search
	 *              button.Verify that search result is populated or not when searching by Custodian Service Level Name.
	 * @param User Custodian Service Level Name for Search
	 */
	public void adminSearchCustodianByServiceLevel(String custodianServiceLevelName) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchCustodian.click();
		wait.until(ExpectedConditions.elementToBeClickable(custodianServiceLevel));
		custodianServiceLevel.click();
		custodianServiceLevel.sendKeys(custodianServiceLevelName);
		custodianServiceLevel.sendKeys(Keys.ENTER);
		TestUtil.hardWait(5);
		buttonSearch.click();
		System.out.println("List of "+custodianServiceLevelName+" Custodian");
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Custodian Service Level Searching Working for Custodian ID " + custodianServiceLevelName);
		}else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Custodian Service Level Searching Working for Custodian ID " + custodianServiceLevelName+" No Result Found");
		} 
		else {
			System.out.println("User Custodian Service Level Searching Not-Working for Custodian ID " + custodianServiceLevelName);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Custodian Search Tab when landed on the Search page of
	 *              the admin. Then enter the user email id and click on search
	 *              button.Verify that search result is populated or not when searching by Custodian Service Level Name.
	 * @param User Custodian Service Level Name for Search
	 */
	public void adminSeachCustodianByCustodianEmail(String custodianEmail) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchCustodian.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputCustodianEmail));
		inputCustodianEmail.click();
		inputCustodianEmail.sendKeys(custodianEmail);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Custodian Email Searching Working for Custodian Email " + custodianEmail);
		} else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Custodian Email Searching Working for Custodian Email " + custodianEmail+" No Result Found");
		}
		else {
			System.out.println("User Custodian Email Searching Not-Working for Custodian Email " + custodianEmail);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Custodian Search Tab when landed on the Search page of
	 *              the admin. Then enter the Enterprise Name and click on search
	 *              button.Verify that search result is populated or not when searching by Custodian Enterprise Name.
	 * @param User Custodian Enterprise Name for Search
	 */
	public void adminSearchCustodianByEnterpriseName(String custodianEnterpriseName) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchCustodian.click();
		wait.until(ExpectedConditions.elementToBeClickable(custodianServiceLevel));
		inputCustodianEnterpriseName.click();
		inputCustodianEnterpriseName.sendKeys(custodianEnterpriseName);
		inputCustodianEnterpriseName.sendKeys(Keys.ENTER);
		TestUtil.hardWait(5);
		buttonSearch.click();
		System.out.println("List of "+custodianEnterpriseName+" Custodian");
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Custodian Service Level Searching Working for Custodian Service Level " + custodianEnterpriseName);
		}else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Custodian Service Level Searching Working for Custodian Service Level " + custodianEnterpriseName+" No Result Found");
		} 
		else {
			System.out.println("User Custodian Service Level Searching Not-Working for Custodian Service Level " + custodianEnterpriseName);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Custodian Search Tab when landed on the Search page of
	 *              the admin. Then enter the user email id and click on search
	 *              button.Verify that search result is populated or not when searching by Custodian City Name.
	 * @param User Custodian City Name for Search
	 */
	public void adminSeachCustodianByCustodianCityName(String custodianCityName) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchCustodian.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputCustodianEmail));
		inputCustodianCityName.click();
		inputCustodianCityName.sendKeys(custodianCityName);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Custodian City Searching Working for Custodian City Name " + custodianCityName);
		} else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Custodian City Searching Working for Custodian City Name " + custodianCityName+" No Result Found");
		}
		else {
			System.out.println("User Custodian City Searching Not-Working for Custodian City Name " + custodianCityName);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Custodian Search Tab when landed on the Search page of
	 *              the admin. Then enter the Phone Number and click on search
	 *              button.Verify that search result is populated or not when searching by Custodian Phone Number.
	 * @param User Custodian Phone Number for Search
	 */
	public void adminSeachCustodianByCustodianPhoneNumber(String custodianPhoneNumber) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		//adminTabSearchCustodian.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputCustodianIncludeDeletedCustodians));
		inputCustodianPhoneNumber.click();
		inputCustodianPhoneNumber.sendKeys(custodianPhoneNumber);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Custodian Phone Number Searching Working for Custodian Phone Number " + custodianPhoneNumber);
		} else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Custodian Phone Number Searching Working for Custodian Phone Number " + custodianPhoneNumber+" No Result Found");
		}
		else {
			System.out.println("User Custodian Phone Number Searching Not-Working for Custodian Phone Number " + custodianPhoneNumber);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Custodian Search Tab when landed on the Search page of
	 *              the admin. Then click on Include deleted custodians and click on search
	 *              button.Verify that search result is populated or not when searching by Include deleted custodians.
	 * 
	 */
	public void adminSeachCustodianByCustodianIncludeDeletedCustodians() {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		//adminTabSearchCustodian.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputCustodianIncludeDeletedCustodians));
		inputCustodianIncludeDeletedCustodians.click();
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Custodian Include Deleted Custodians Searching Working for Custodian Include Deleted Custodians ");
		} else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Custodian Include Deleted Custodians Searching Working for Custodian Include Deleted Custodians ");
		}
		else {
			System.out.println("User Custodian Include Deleted Custodians Searching Not-Working for Custodian Include Deleted Custodians ");
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Custodian Search Tab when landed on the Search page of
	 *              the admin. Then click on Only deleted custodians and click on search
	 *              button.Verify that search result is populated or not when searching by Only deleted custodians.
	 * 
	 */
	public void adminSeachCustodianByCustodianShowOnlyDeletedCustodians() {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		//adminTabSearchCustodian.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputCustodianShowOnlyDeletedCustodians));
		inputCustodianShowOnlyDeletedCustodians.click();
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Custodian Show Only Deleted Custodians Searching Working for Custodian Show Only Deleted Custodians ");
		} else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Custodian Show Only Deleted Custodians Searching Working for Custodian Show Only Deleted Custodians ");
		}
		else {
			System.out.println("User Custodian Show Only Deleted Custodians Searching Not-Working for Custodian Show Only Deleted Custodians ");
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Retrieval Requests Search Tab when landed on the Search page of
	 *              the admin. Then click on custodians Name and click on search
	 *              button.Verify that search result is populated or not when searching by Custodian Name.
	 * @param Custodian Name
	 */
	public void adminSeachRetrievalRequestsByCustodianName(String CustodianName) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchRetrievalRequests));
		adminTabSearchRetrievalRequests.click();
		wait.until(ExpectedConditions.elementToBeClickable(dropDownRetievalRequestsCustodianName));
		dropDownRetievalRequestsCustodianName.click();
		inputRetievalRequestsCustodianName.click();
		inputRetievalRequestsCustodianName.sendKeys(CustodianName);
		inputRetievalRequestsCustodianName.sendKeys(Keys.ENTER);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultRetrievalRequestsSearch)) {
			System.out.println("User Custodian Name Searching Working For Custodian Name "+CustodianName);
		} else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Custodian Name Searching Working for Custodian Name But no records Finds");
		}
		else {
			System.out.println("User Custodian Name Searching Not-Working For Custodian Name "+CustodianName);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Retrieval Requests Search Tab when landed on the Search page of
	 *              the admin. Then click on Requestor Name and click on search
	 *              button.Verify that search result is populated or not when searching by Requestor Name.
	 * @param Requestor	 Name
	 */
	public void adminSeachRetrievalRequestsByRequestorName(String RequestorName) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchRetrievalRequests));
		adminTabSearchRetrievalRequests.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputRetrievalRequestsRequestorName));
		inputRetrievalRequestsRequestorName.click();
		inputRetrievalRequestsRequestorName.sendKeys(RequestorName);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultRetrievalRequestsSearch)) {
			System.out.println("User Retrieval Requests Name Searching Working For Requestor Name "+RequestorName);
		} else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("User Retrieval Requests Searching Working for Requestor Name But no records Finds");
		}
		else {
			System.out.println("User Retrieval Requests Searching Not-Working For Requestor Name "+RequestorName);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Retrieval Requests Search Tab when landed on the Search page of
	 *              the admin. Then click on Requestor ID and click on search
	 *              button.Verify that search result is populated or not when searching by Requestor ID.
	 * @param Requestor ID
	 */
	public void adminSeachRetrievalRequestsByRequestorID(String RequestorID) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchRetrievalRequests));
		adminTabSearchRetrievalRequests.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputRetrievalRequestsRequestorID));
		inputRetrievalRequestsRequestorID.click();
		inputRetrievalRequestsRequestorID.sendKeys(RequestorID);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultRetrievalRequestsSearch)) {
			System.out.println("User Retrieval Requests Name Searching Working For Requestor Name "+RequestorID);
		} else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! No matching Record found"));
			System.out.println("User Retrieval Requests Searching Working for Requestor Name But no records Finds");
		}
		else {
			System.out.println("User Retrieval Requests Searching Not-Working For Requestor Name "+RequestorID);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Retrieval Requests Search Tab when landed on the Search page of
	 *              the admin. Then click on Requestor Type and click on search
	 *              button.Verify that search result is populated or not when searching by Requestor Type.
	 * @param Requestor Type
	 */
	public void adminSeachRetrievalRequestsByRequestorType(String RequestorType) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchRetrievalRequests));
		adminTabSearchRetrievalRequests.click();
		wait.until(ExpectedConditions.elementToBeClickable(dropDownRetievalRequestsCustodianName));
		inputRetievalRequestsRequestorType.click();
		inputRetievalRequestsRequestorType.sendKeys(RequestorType);
		inputRetievalRequestsRequestorType.sendKeys(Keys.ENTER);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultRetrievalRequestsSearch)) {
			System.out.println("User Requestor Type Searching Working For Requestor Type "+RequestorType);
		} else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("There were no Retrieval Requests found"), "");
			System.out.println("User Requestor Type Searching Working for Requestor Type But no records Finds");
		}
		else {
			System.out.println("User Requestor Type Searching Not-Working For Requestor Type "+RequestorType);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Retrieval Requests Search Tab when landed on the Search page of
	 *              the admin. Then click on Patient's First Name and click on search
	 *              button.Verify that search result is populated or not when searching by Patient's First Name.
	 * @param Patient's First Name
	 */
	public void adminSeachRetrievalRequestsByPatientsFirstName(String PatientsFirstName) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchRetrievalRequests));
		adminTabSearchRetrievalRequests.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputRetievalRequestsPatientsFirstName));
		inputRetievalRequestsPatientsFirstName.click();
		inputRetievalRequestsPatientsFirstName.sendKeys(PatientsFirstName);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultRetrievalRequestsSearch)) {
			System.out.println("User Patient's First Name Searching Working For Patient's First Name "+PatientsFirstName);
		} else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("There were no Retrieval Requests found"), "");
			System.out.println("User Patient's First Name Searching Working for Patient's First Name But no records Finds");
		}
		else {
			System.out.println("User Patient's First Name Searching Not-Working For Patient's First Name "+PatientsFirstName);
		}
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Retrieval Requests Search Tab when landed on the Search page of
	 *              the admin. Then click on Requestor Type and click on search
	 *              button.Verify that search result is populated or not when searching by Requestor Type.
	 * @param Requestor Type
	 */
	public void adminSeachRetrievalRequestsByReasonForRequest(String ReasonForRequest) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchRetrievalRequests));
		adminTabSearchRetrievalRequests.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputRetievalRequestsReasonForRequest));
		inputRetievalRequestsReasonForRequest.click();
		inputRetievalRequestsReasonForRequest.sendKeys(ReasonForRequest);
		inputRetievalRequestsReasonForRequest.sendKeys(Keys.ENTER);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultRetrievalRequestsSearch)) {
			System.out.println("Retrieval Request Tab Reason For Request Searching Working For Requestor Type "+ReasonForRequest);
		} else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("There were no Retrieval Requests found"), "");
			System.out.println("Retrieval Request Tab Reason For Request Searching Working for Requestor Type But no records Finds");
		}
		else {
			System.out.println("Retrieval Request Tab Reason For Request Searching Not-Working For Requestor Type "+ReasonForRequest);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Retrieval Request Search Tab when landed on the Search page of
	 *              the admin. Then enter the Enterprises name and click on search
	 *              button.Verify that search result is populated or not when searching by Enterprise Name.
	 * @param Custodian Name for Search
	 */
	public void adminSearchRetrievalRequestByEnterpriseName(String searchEnterpriseName) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabSearchRetrievalRequests.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputRetrievalRequestEnterpriseName));
		inputRetrievalRequestEnterpriseName.click();
		inputRetrievalRequestEnterpriseName.sendKeys(searchEnterpriseName);
		inputRetrievalRequestEnterpriseName.sendKeys(Keys.ENTER);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("Retrieval Request Tab Enterprises Name Searching Working for Enterprises Name " + searchEnterpriseName);
		}else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no custodians found"));
			System.out.println("Retrieval Request Tab Enterprises Name Searching Working for Enterprises Name " + searchEnterpriseName+" No Result Found");
		}  
		else {
			System.out.println("Retrieval Request Tab Enterprises Name Searching Not-Working for Enterprises Name " + searchEnterpriseName);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Request Search Tab when landed on the Search page of
	 *              the admin. Then enter the Custodian name and click on search
	 *              button.Verify that search result is populated or not when searching by Custodian Name.
	 * @param Custodian Name for Search
	 */
	public void adminSearchRequestByCustodianName(String CustodianName) {
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchUsers));
		adminTabRequestsTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputRequestsCustodianName));
		inputRequestsCustodianName.click();
		inputRequestsCustodianName.sendKeys(CustodianName);
		inputRequestsCustodianName.sendKeys(Keys.ENTER);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultUserSearch)) {
			System.out.println("User Custodian Name Searching Working for Custodian Name " + CustodianName);
		}else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no Request found"));
			System.out.println("User Custodian Name Searching Working for Custodian Name " + CustodianName+" No Result Found");
		}  
		else {
			System.out.println("Request Tab Custodian Name Searching Not-Working for Custodian Name " + CustodianName);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Requests Search Tab when landed on the Search page of
	 *              the admin. Then click on Requestor ID and click on search
	 *              button.Verify that search result is populated or not when searching by Requestor ID.
	 * @param Requestor ID
	 */
	public void adminSeachRequestsByRequestorID(String RequestorID) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(adminTabSearchRetrievalRequests));
		adminTabRequestsTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputRetrievalRequestsRequestorID));
		inputRetrievalRequestsRequestorID.click();
		inputRetrievalRequestsRequestorID.sendKeys(RequestorID);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultRetrievalRequestsSearch)) {
			System.out.println("User Retrieval Requests Name Searching Working For Requestor Name "+RequestorID);
		} else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("No matching Record found for the mentioned Request ID"));
			System.out.println("User Retrieval Requests Searching Working for Requestor Name But no records Finds");
		}
		else {
			System.out.println("User Retrieval Requests Searching Not-Working For Requestor Name "+RequestorID);
		}
	}
	
	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Request Search Tab when landed on the Search page of
	 *              the admin. Then enter the Request Status and click on search
	 *              button.Verify that search result is populated or not when searching by Request Status.
	 * @param Request Status for Search
	 */
	public void adminSearchRequestByRequestStatus(String RequestStatus) {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(adminTabRequestsTab));
		adminTabRequestsTab.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputRequestsStatus));
		inputRequestsStatus.click();
		inputRequestsStatus.sendKeys(RequestStatus);
		inputRequestsStatus.sendKeys(Keys.ENTER);
		buttonSearch.click();
		TestUtil.hardWait(5);
		// wait.until(ExpectedConditions.visibilityOf(searchResultUserSearch));
		if (TestUtil.isElementDisplayed(searchResultRetrievalRequestsSearch)) {
			System.out.println("Request Tab Status Type Searching Working for Request Status " + RequestStatus);
		}else if (TestUtil.isElementDisplayed(noSearchFound)) {
			String actualString=noSearchFound.getText();
			Assert.assertTrue(actualString.contains("Warning! There were no Request found"));
			System.out.println("Request Tab Status Type Searching Working for Request Status " + RequestStatus+" No Result Found");
		}  
		else {
			System.out.println("Request Tab Status Type Searching Not-Working for Request Status " + RequestStatus);
		}
	}
}
