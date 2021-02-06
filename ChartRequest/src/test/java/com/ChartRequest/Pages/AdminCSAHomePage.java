package com.ChartRequest.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ChartRequest.Browser.BrowserConfiguration;
import com.ChartRequest.Reports.TestListener;
import com.ChartRequest.Utility.TestUtil;

public class AdminCSAHomePage extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@FindBy(xpath = "//a[contains(@class,'btn dropdown-toggle btn-trans requestor-dropdown')]")
	WebElement adminDropDown;

	@FindBy(xpath = "//li//a[contains(text(),'[adm] CSA Home')]")
	WebElement adminDropDownCSAHomePage;

	@FindBy(xpath = "//h4[contains(text(),'Daily Progress Ranking')]")
	WebElement headingDailyProgressRanking;

	@FindBy(xpath = "//*[@id='send_req_link_custodian_chosen']/a")
	WebElement dropDownSelectCustodianName;

	@FindBy(xpath = "//a[contains(text(),'Email Requestor Sign Up Instructions')]")
	WebElement linkEmailRequestorSignUpInstructions;

	@FindBy(xpath = "//div[@id='send_req_link_custodian_chosen']//input[@type='text']")
	WebElement inputCustodianAccountForEmailRequestorSignUpInstructions;

	@FindBy(xpath = "//p//input[@placeholder='Requestor email']")
	WebElement inputRequestorEmail;

	@FindBy(xpath = "//input[contains(@value,'Send')]")
	WebElement sendButton;

	@FindBy(xpath = "//div[@id='notice']")
	WebElement confrimationMessage;

	@FindBy(xpath = "//a[contains(normalize-space(),'Send Fax-Back')]")
	WebElement linkSendFaxBack;

	@FindBy(xpath = "//div[@id='faxback_custodian_id_chosen']//span")
	WebElement dropDownSelectCustodianNameSendFaxBack;

	@FindBy(xpath = "//div[@id='faxback_custodian_id_chosen']//input[contains(@type,'text')]")
	WebElement inputCustodianAccountForSendFaxBack;

	@FindBy(xpath = "//input[@id='fax-back-fax-number']")
	WebElement inputFaxNumber;

	@FindBy(xpath = "//input[@id='patient_name']")
	WebElement inputFaxPatientName;

	@FindBy(xpath = "//input[@id='auth_file']")
	WebElement uploadAuthFile;

	@FindBy(xpath = "//input[@id='send-fax-back']")
	WebElement buttonSendFaxBack;

	@FindBy(xpath = "//button[@id='submit-send-fax']")
	WebElement buttonYesSendFaxBack;

	@FindBy(xpath = "//a[contains(normalize-space(),'Search for Check By Number')]")
	WebElement linkSearchForCheckByNumber;

	@FindBy(xpath = "//h4[contains(normalize-space(),'Search for Check By Number')]")
	WebElement headingSearchingForCheckByNumber;

	@FindBy(xpath = "//input[@id='check_number']")
	WebElement inputCheckNumber;

	@FindBy(xpath = "//input[contains(@class,'btn btn-primary')]")
	WebElement buttonSearchForCheckNumber;

	@FindBy(xpath = "//*[@id='search-check-data']/div/table/tbody/tr")
	WebElement searchResultCheckNumber;

	@FindBy(xpath = "//a[contains(text(),'Invite Custodian Colleagues')]")
	WebElement linkInviteCustodianColleagues;

	@FindBy(xpath = "//h4[contains(text(),'Invite Custodian Colleague')]")
	WebElement headingInviteCustodianColleague;

	@FindBy(xpath = "//*[@id='custodian_id_chosen']")
	WebElement dropDownSelectCustodian;

	@FindBy(xpath = "//*[@id='custodian_id_chosen']/div/div/input")
	WebElement dropDownInputSelectCustodian;

	@FindBy(xpath = "//span[4]//input[1]")
	WebElement inputFirstName;

	@FindBy(xpath = "//span[@class='col-sm-6 col-xs-12']//input[@id='last_name']	")
	WebElement inputLastName;

	@FindBy(xpath = "//span[@class='col-sm-6 col-xs-12 ']//input[@id='email']")
	WebElement inputEmailID;

	@FindBy(xpath = "//div[@id='invite-custodian-colleagues']//input[@id='fullname']")
	WebElement inputFullName;

	@FindBy(xpath = "//div[@id='invite-custodian-colleagues']//input[@id='initials']")
	WebElement inputInitials;

	@FindBy(xpath = "//div[@id='invite-custodian-colleagues']//input[contains(@type,'checkbox')]")
	WebElement checkboxYesThisUserShouldHaveAccessToThisPHI;

	@FindBy(xpath = "//div[@id='invite-custodian-colleagues']//span[contains(@class,'pull-right')]")
	WebElement buttonSendEmail;

	@FindBy(xpath = "//a[contains(normalize-space(),'Invite Requestor Colleagues')]")
	WebElement linkInviteRequestorColleagues;

	@FindBy(xpath = "//h4[contains(normalize-space(),'Invite Requestor Colleague')]")
	WebElement headingInviteRequestorColleague;

	@FindBy(xpath = "//input[@id='requestor_name']")
	WebElement inputSearchRequestor;

	@FindBy(xpath = "//a[@id='requestor-search-link']")
	WebElement buttonSearchRequestor;

	@FindBy(xpath = "//input[@id='name']")
	WebElement inputRequestorFirstName;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement inputRequestorLastName;

	@FindBy(xpath = "//input[@id='email']")
	WebElement inputRequestorEmailID;

	@FindBy(xpath = "//input[@id='fullname']")
	WebElement inputRequestorFullName;

	@FindBy(xpath = "//input[@id='initials']")
	WebElement inputRequetorIntials;

	@FindBy(xpath = "//input[contains(@class,'checkbox-not-matched-email')]")
	WebElement checkboxYesThisUserShouldHaveAccessToThisPHIRequestor;

	@FindBy(xpath = "//a[contains(@class,'btn search-requestor-btn invite_colleagues_verify_btn invite_colleagues_state_change_btn')]")
	WebElement buttonSendEmailRequestor;

	@FindBy(xpath = "//div[@class='row-fluid overflow-x-auto']//a[contains(normalize-space(),'Last »')]")
	WebElement lastPageOfCSAHomePage;

	@FindBy(xpath = "//button[contains(text(),'Bulk')]")
	WebElement buttonBulkActions;

	@FindBy(xpath = "//tr[@class='unread_message'][1]/following::input[1]")
	WebElement checkboxSecondRowValue;

	@FindBy(xpath = "//a[@id='company_csa_bulk_assign_dropdown_btn']")
	WebElement assignToMeLink;

	@FindBy(xpath = "//div[@id='company_csa_bulk_assign_chosen']//span")
	WebElement dropDownAssignMe;

	@FindBy(xpath = "//div[@id='company_csa_bulk_assign_chosen']//input[@type='text']")
	WebElement inputAssignUserName;

	@FindBy(xpath = "//button[@id='company_csa_bulk_assign_to_btn']")
	WebElement buttonAssign;

	@FindBy(xpath = "//button[@id='assign_unassign_confirmation']")
	WebElement buttonFinalAssignToMeOK;

	@FindBy(xpath = "//button[@data-assign-url='/company/csa_homes/assign_me_requests']")
	WebElement buttonAssignMeRequest;

	@FindBy(xpath = "//a[@id='assign_me_requests_qa_id']")
	WebElement dropDownQARequest;

	@FindBy(xpath = "//button[@id='dropdown1']")
	WebElement buttonFilterAndSearch;
	
	@FindBy(xpath = "//div[@id='csa_home_request_status_chosen']//ul[@class='chosen-choices']")
	WebElement requestStatus;

	@FindBy(xpath = "//div[@id='csa_home_request_status_chosen']//input[@value='Select Some Options']")
	WebElement inputSearchRequest;
	
	@FindBy(xpath = "//input[@id='csa_home_filter_search']")
	WebElement buttonSearchInFilterAndSearch;
	
	@FindBy(xpath = "//table[@class='main-table csa-table table-condensed']")
	WebElement searchResultHomePage;
	
	@FindBy(xpath = "//div[@id='csa_home_records_type_chosen']//ul[@class='chosen-choices']")
	WebElement recordType;
	
	@FindBy(xpath = "//div[@id='csa_home_records_type_chosen']//input[@value='Select Some Options']")
	WebElement inputSearchRecordType;
	
	@FindBy(xpath = "//div[@id='custodian_for_csa_chosen']//ul[@class='chosen-choices']")
	WebElement custodianSearch;
	
	@FindBy(xpath = "//div[@id='custodian_for_csa_chosen']//input[@value='Select Some Options']")
	WebElement inputSearchCustodian;
	
	@FindBy(xpath = "//a[@href='/custodian/csa_homes']")
	WebElement menuCSAHomeFromCustodian;
	
	@FindBy(xpath = "//a[@href='/enterprise_admin/ea_clinical_admin_review']")
	WebElement tabClinicalAdminReview;
	
	@FindBy(xpath = "//table[@class='main-table table-striped request-container table-condensed']/tbody/tr[1]/td[2]/a")
	WebElement getRequestNumberFromCustidonCSAPage;
	
	@FindBy(xpath = "//a[@href='/enterprise_admin/requests']")
	WebElement tabSearchRequestAdminEnterprise;
	
	@FindBy(xpath = "//input[@id='search_id']")
	WebElement inputSearch;
	
	@FindBy(xpath = "//input[@value='Search']")
	WebElement buttonSearch;
	
	@FindBy(xpath =  "//tbody/tr[1]")
	WebElement searchResult;
	
	@FindBy(xpath = "//tbody/tr[1]/td[3]")
	WebElement statusOfSearchResult;
	
	public AdminCSAHomePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Open the CSA Home Page from the admin page
	 */

	public void openCSAHomePage() {
		System.out.println("Opening the Admin Drop Down");
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(adminDropDownCSAHomePage));
		adminDropDownCSAHomePage.click();
		TestListener.infoMessage("Open Admin CSA Home Page");
		wait.until(ExpectedConditions.visibilityOf(headingDailyProgressRanking));
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Email Requestor Sign Up Instructions and Send
	 *              Instruction to the respective email.
	 * 
	 * @param Custodian Name
	 */
	public void emailRequestorSingupInstructions(String CustodianName, String EmailID) {
		TestUtil.hardWait(5);
		linkEmailRequestorSignUpInstructions.click();
		wait.until(ExpectedConditions.elementToBeClickable(dropDownSelectCustodianName));
		dropDownSelectCustodianName.click();
		inputCustodianAccountForEmailRequestorSignUpInstructions.click();
		inputCustodianAccountForEmailRequestorSignUpInstructions.sendKeys(CustodianName);
		inputCustodianAccountForEmailRequestorSignUpInstructions.sendKeys(Keys.ENTER);
		inputRequestorEmail.sendKeys(EmailID);
		sendButton.click();
		wait.until(ExpectedConditions.visibilityOf(confrimationMessage));
		String getMessage = confrimationMessage.getText();
		Assert.assertTrue(getMessage.contains("Request sent to requestor"));
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the SendFaxBack link and fill the details and click on
	 *              send button Instruction to the respective email.
	 * 
	 * @param Custodian Name, FaxNumber, PatientName
	 */
	public void sendFaxBack(String CustodianName, String FaxNumber, String PatientName) {
		try {
			TestUtil.hardWait(5);
			linkSendFaxBack.click();
			wait.until(ExpectedConditions.elementToBeClickable(dropDownSelectCustodianNameSendFaxBack));
			dropDownSelectCustodianNameSendFaxBack.click();
			inputCustodianAccountForSendFaxBack.click();
			inputCustodianAccountForSendFaxBack.sendKeys(CustodianName);
			inputCustodianAccountForSendFaxBack.sendKeys(Keys.ENTER);
			inputFaxNumber.sendKeys(FaxNumber);
			inputFaxPatientName.sendKeys(PatientName);
			js.executeScript("arguments[0].click();", uploadAuthFile);
			TestUtil.hardWait(5);
			try {
				Runtime.getRuntime()
						.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/FileUploadAuth.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (TestUtil.isClickable(buttonSendFaxBack)) {
				buttonSendFaxBack.click();
				System.out.println("Send Fax Back Button is clickable");
				TestListener.infoMessage("Send Fax Back Button is clickable");
				wait.until(ExpectedConditions.elementToBeClickable(buttonYesSendFaxBack));
				buttonYesSendFaxBack.click();
				wait.until(ExpectedConditions.visibilityOf(confrimationMessage));
				String actualValue = confrimationMessage.getText();
				Assert.assertTrue(actualValue.contains("Fax Back Sent Successfully."));
				
			} else {
				System.out.println("Send Fax Back Button is NOT-clickable");
				TestListener.infoMessageFail("Send Fax Back Button is NOT-clickable");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the CheckByNumber link and fill the details and click
	 *              on send button
	 * 
	 * @param CheckNumber
	 */
	public void searchByCheckByNumber(String CheckNumber) {
		TestUtil.hardWait(5);
		linkSearchForCheckByNumber.click();
		wait.until(ExpectedConditions.visibilityOf(headingSearchingForCheckByNumber));
		inputCheckNumber.sendKeys(CheckNumber);
		buttonSearchForCheckNumber.click();
		wait.until(ExpectedConditions.visibilityOf(searchResultCheckNumber));
		if (TestUtil.isElementDisplayed(searchResultCheckNumber)) {
			System.out.println("Cheque Number Found");
		} else {
			System.out.println("Cheque Number Not-Found");
		}
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Invite Custodian Colleague link and fill the
	 *              details and click on send button
	 * 
	 * @param custodianName
	 */
	public void InviteCustodianColleagues(String custodianName) {
		TestUtil.hardWait(5);
		linkInviteCustodianColleagues.click();
		wait.until(ExpectedConditions.visibilityOf(headingInviteCustodianColleague));
		dropDownSelectCustodian.click();
		dropDownInputSelectCustodian.sendKeys(custodianName);
		dropDownInputSelectCustodian.sendKeys(Keys.ENTER);
		inputFirstName.sendKeys(TestUtil.getAlphaDynamicString(7));
		inputLastName.sendKeys(TestUtil.getAlphaDynamicString(7));
		inputEmailID.sendKeys(TestUtil.getAlphaDynamicString(7) + "@automation.com");
		if (TestUtil.isElementDisplayed(inputFullName)) {
			inputFullName.sendKeys("Automation Testing");
			inputInitials.sendKeys("Automation");
		}
		checkboxYesThisUserShouldHaveAccessToThisPHI.click();
		buttonSendEmail.click();
		String actualValue = confrimationMessage.getText();
		Assert.assertTrue(actualValue.contains("User was successfully created."));
		TestListener.infoMessage("User was successfully created.");
	}

	/**
	 * @author ashutosh.tiwari
	 * @Description Click on the Invite Requestor Colleague link and fill the
	 *              details and click on send button
	 * 
	 * @param custodianName
	 */
	public void InviteRequestorColleagues(String custodianName) {
		TestUtil.hardWait(5);
		linkInviteRequestorColleagues.click();
		wait.until(ExpectedConditions.visibilityOf(headingInviteRequestorColleague));
		inputSearchRequestor.sendKeys(custodianName);
		buttonSearchRequestor.click();
		inputRequestorFirstName.sendKeys(TestUtil.getAlphaDynamicString(7));
		inputRequestorLastName.sendKeys(TestUtil.getAlphaDynamicString(7));
		inputRequestorEmailID.sendKeys(TestUtil.getAlphaDynamicString(7) + "@automation.com");
		if (TestUtil.isElementDisplayed(inputRequestorFullName)) {
			inputRequestorFullName.sendKeys("Automation Testing");
			inputRequetorIntials.sendKeys("Automation");
		}
		checkboxYesThisUserShouldHaveAccessToThisPHIRequestor.click();
		buttonSendEmailRequestor.click();
		String actualValue = confrimationMessage.getText();
		Assert.assertTrue(actualValue.contains("User was successfully created."));
		TestListener.infoMessage("User was successfully created.");
	}

	public void AssignToMe() {
		TestUtil.hardWait(5);
		lastPageOfCSAHomePage.click();
		wait.until(ExpectedConditions.visibilityOf(checkboxSecondRowValue));
		checkboxSecondRowValue.click();
		wait.until(ExpectedConditions.visibilityOf(buttonBulkActions));
		buttonBulkActions.click();
		wait.until(ExpectedConditions.visibilityOf(assignToMeLink));
		assignToMeLink.click();
		wait.until(ExpectedConditions.visibilityOf(dropDownAssignMe));
		dropDownAssignMe.click();
		inputAssignUserName.sendKeys("admin");
		inputAssignUserName.sendKeys(Keys.ENTER);
		buttonAssign.click();
		TestListener.infoMessage("Assigning user name is Admin");
		wait.until(ExpectedConditions.elementToBeClickable(buttonFinalAssignToMeOK));
		buttonFinalAssignToMeOK.click();
		TestListener.infoMessage("Request Assign To Me successfully.");
	}

	public void selectAssignMeUserName(String assignMeUserName) {
		Select selectSize = new Select(driver.findElement(By.name("request[authorization_type]")));
		selectSize.selectByVisibleText(assignMeUserName);
	}

	public void AssignMeRequests() {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(buttonAssignMeRequest));
		buttonAssignMeRequest.click();
		wait.until(ExpectedConditions.elementToBeClickable(dropDownQARequest));
		dropDownQARequest.click();
		TestListener.addDynamicScreenshotInReport("AssignMe Request Alert");
		driver.switchTo().alert().accept();
	}

	public void filterAndSearchRequestStatus() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonFilterAndSearch));
		buttonFilterAndSearch.click();
		wait.until(ExpectedConditions.elementToBeClickable(requestStatus));
		inputSearchRequest.click();
		inputSearchRequest.sendKeys("Pending");
		inputSearchRequest.sendKeys(Keys.ENTER);
		buttonSearchInFilterAndSearch.click();
		wait.until(ExpectedConditions.visibilityOf(searchResultHomePage));
		if (TestUtil.isElementDisplayed(searchResultHomePage)) {
			System.out.println("Search Result Working for Requests Status");
			TestListener.infoMessage("Search Result Working for Requests Status");
		} else {
			System.out.println("Search Result NOT-Working for Request Status");
			TestListener.infoMessage("Search Result NOT-Working for Request Status");
		}
		
	}
	
	public void filterAndSearchRecordType() {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(buttonFilterAndSearch));
		buttonFilterAndSearch.click();
		wait.until(ExpectedConditions.elementToBeClickable(recordType));
		recordType.click();
		inputSearchRecordType.sendKeys("Medical");
		inputSearchRecordType.sendKeys(Keys.ENTER);
		buttonSearchInFilterAndSearch.click();
		wait.until(ExpectedConditions.visibilityOf(searchResultHomePage));
		if (TestUtil.isElementDisplayed(searchResultHomePage)) {
			System.out.println("Search Result Working for Record Type");
			TestListener.infoMessage("Search Result Working for Record Type");
		} else {
			System.out.println("Search Result NOT-Working for Record Type");
			TestListener.infoMessage("Search Result NOT-Working for Record Type");
		}
	}
	
	public void filterAndSearchCustodian() {
		TestUtil.hardWait(5);
		wait.until(ExpectedConditions.elementToBeClickable(buttonFilterAndSearch));
		buttonFilterAndSearch.click();
		wait.until(ExpectedConditions.elementToBeClickable(custodianSearch));
		inputSearchCustodian.click();
		inputSearchCustodian.sendKeys("Admin");
		inputSearchCustodian.sendKeys(Keys.ENTER);
		buttonSearchInFilterAndSearch.click();
		wait.until(ExpectedConditions.visibilityOf(searchResultHomePage));
		if (TestUtil.isElementDisplayed(searchResultHomePage)) {
			System.out.println("Search Result Working for Custodian");
			TestListener.infoMessage("Search Result Working for Custodian");
		} else {
			System.out.println("Search Result NOT-Working for Custodian");
			TestListener.infoMessage("Search Result NOT-Working for Custodian");
		}
	}
	
	public void openCSAHomePageFromCustodian() {
		/*wait.until(ExpectedConditions.visibilityOf(adminDropDown));
		adminDropDown.click();
		wait.until(ExpectedConditions.elementToBeClickable(menuCSAHomeFromCustodian));
		menuCSAHomeFromCustodian.click();*/
		wait.until(ExpectedConditions.elementToBeClickable(tabClinicalAdminReview));
		tabClinicalAdminReview.click();
		TestListener.addDynamicScreenshotInReport("opentabClinicalAdminReview");
	}
	
	public String processRequestFromCustodianEnterpriseAdmin() {
		wait.until(ExpectedConditions.visibilityOf(getRequestNumberFromCustidonCSAPage));
		String tempRequestNumber=getRequestNumberFromCustidonCSAPage.getText();
		System.out.println("Request Number is "+tempRequestNumber);
		TestListener.infoMessage("Request Number is "+tempRequestNumber);
		TestListener.addDynamicScreenshotInReport("requestNumber");

		/*WebElement claimAndProcessButton=driver.findElement(By.xpath("//a[@href='/custodian/csa_homes/"+tempRequestNumber+"/claim_process']"));
		WebElement processButton=driver.findElement(By.xpath("//a[@href='/custodian/requests/"+tempRequestNumber+"/qa']"));

		if (TestUtil.isElementDisplayed(claimAndProcessButton)) {
			claimAndProcessButton.click();
		} else {
			processButton.click();
		}*/
		
		driver.findElement(By.xpath("//a[@href='/custodian/requests/"+tempRequestNumber+"/qa']")).click();
		return tempRequestNumber;
	}
	
	public void searchProcessedRequest(String RequestNo) {
		wait.until(ExpectedConditions.elementToBeClickable(tabSearchRequestAdminEnterprise));
		tabSearchRequestAdminEnterprise.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputSearch));
		inputSearch.sendKeys(RequestNo);
		wait.until(ExpectedConditions.elementToBeClickable(buttonSearch));
		buttonSearch.click();
		wait.until(ExpectedConditions.visibilityOf(searchResult));
		String status=statusOfSearchResult.getText();
		System.out.println("Status of Request is: "+status);
		Assert.assertEquals(status, "Priced","Status of Request is "+status);
		TestListener.infoMessage("Status of Request is "+status);
		TestUtil.scrollToElement(statusOfSearchResult);
		TestListener.addDynamicScreenshotInReport("searchProcessedRequest");
	}
}
