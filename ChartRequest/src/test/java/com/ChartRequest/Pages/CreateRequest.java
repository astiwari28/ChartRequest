package com.ChartRequest.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

public class CreateRequest extends BrowserConfiguration {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	SearchMyRequest searchMyName = new SearchMyRequest();
	Actions actions = new Actions(driver);

	public CreateRequest() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-large btn-success']")
	WebElement makeaNewRequestForRecords;

	@FindBy(xpath = "//a[@class='btn btn-large pull-right-lg']")
	WebElement searchMyRequest;

	@FindBy(xpath = "//div[@id='search_state_chosen']")
	WebElement selectState;

	@FindBy(xpath = "//div[contains(@class,'chosen-search')]//input[contains(@class,'chosen-search-input')]")
	WebElement inputStateName;

	@FindBy(xpath = "//input[@id='search_name']")
	WebElement inputProviderName;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement buttonSearch;

	@FindBy(xpath = "//button[contains(text(),'Request Records')]")
	WebElement searchRequestorNameButton;

	@FindBy(xpath = "//h1/strong")
	WebElement requestNumber;

	@FindBy(xpath = "//h1")
	WebElement typeofRequest;

	@FindBy(xpath = "//input[@id='request_patient_attributes_given_names']")
	WebElement inputFirstNamePatientName;

	@FindBy(xpath = "//input[@id='request_patient_attributes_family_name']")
	WebElement inputLastNamePatientName;

	@FindBy(xpath = "//input[@id='request_patient_attributes_date_of_birth']")
	WebElement inputDateofBirthPatient;

	@FindBy(xpath = "//div[@id='request_scope_chosen']//ul[@class='chosen-choices']")
	WebElement inputRecordsType;

	@FindBy(xpath = "//input[@class='chosen-search-input default']")
	WebElement inputReasonForRequest;

	@FindBy(xpath = "//a[text()='Abandon Request']")
	WebElement buttonAbandonRequest;

	@FindBy(xpath = "//div[@id='notice']")
	WebElement errorMessage;

	@FindBy(xpath = "//Strong[text()='Upload Authorization']")
	WebElement buttonFileUploadAuthorization;

	@FindBy(xpath = "//input[@id='authorization_document']")
	WebElement buttonChooseFile;

	@FindBy(xpath = "//input[@id='submit_upload_authorization']")
	WebElement buttonUploadAuthorization;

	@FindBy(xpath = "//a[text()='Send to Provider']")
	WebElement buttonSendToProvider;

	@FindBy(xpath = "//input[@id='estimate_pending_initials']")
	WebElement inputInitilasAtEstimatePendingPage;

	@FindBy(xpath = "//b[contains(text(),'Approve Estimate')]")
	WebElement buttonApproveEstimate;

	@FindBy(xpath = "//a[text()='Add Card']")
	WebElement linkAddCreditCard;

	@FindBy(xpath = "//input[@id='card_number']")
	WebElement inputCreditCardNumber;

	@FindBy(xpath = "//input[@id='card_code']")
	WebElement inputCreditCardCVVNumber;

	@FindBy(xpath = "//a[text()='Pay By Check']")
	WebElement buttonPayByCheque;

	/*
	 * @FindBy(xpath = "//label[contains(normalize-space(),'Pay By Check')]")
	 * WebElement buttonPayByCheque;
	 */

	@FindBy(xpath = "//div[@id='notice']")
	WebElement successfulMessage;

	@FindBy(xpath = "//a[@class='btn dropdown-toggle btn-trans requestor-dropdown']")
	static WebElement nameoFtheUser;

	@FindBy(xpath = "//button[@class=' btn btn-primary btn-small add-credit-card']")
	WebElement addCreditCard;

	@FindBy(xpath = "//a[@class='delete-card']")
	WebElement deleteSavedCards;

	@FindBy(xpath = "//span[contains(text(),'Visa')]")
	WebElement visaCard;

	@FindBy(xpath = "//span[contains(text(),'Master')]")
	WebElement masterCard;

	@FindBy(xpath = "//button[contains(text(),'Submit Request')]")
	WebElement buttonSubmitRequest;

	@FindBy(xpath = "//a[contains(text(),'Care Coordination')]")
	WebElement buttonCareCoordination;

	@FindBy(xpath = "//a[contains(text(),'Request Records')]")
	WebElement buttonRequestRecords;

	@FindBy(xpath = "//span[contains(text(),'Save as Draft')]")
	WebElement buttonSaveAsDraft;

	@FindBy(xpath = "//a[text()='Requests']")
	WebElement buttonRequestOnTop;

	@FindBy(xpath = "//a[text()='Search My Requests']")
	WebElement buttonSearchMyRequests;

	@FindBy(xpath = "//button[text()='Adopt & Sign']")
	WebElement buttonAdoptAndSign;

	@FindBy(xpath = "//h3[contains(text(),'Adopt Your Signature')]")
	WebElement headingAdoptYourSignature;

	@FindBy(xpath = "//input[@id='fullname']")
	WebElement inputPatienetEauthFullName;

	@FindBy(xpath = "//input[@id='initials']")
	WebElement inputPatienetEauthInitials;

	@FindBy(xpath = "//input[@id='dob']")
	WebElement inputPatienetEauthDOB;

	@FindBy(xpath = "//input[@id='submit_upload_e_authorization']")
	WebElement buttonPatienetEauthSubmit;

	@FindBy(xpath = "//a[@class='no-wrap-id']")
	WebElement linkSearchRequestID;

	@FindBy(xpath = "//h4[contains(text(),'Reason for Accessing Request')]")
	WebElement headingforProcessing;

	@FindBy(xpath = "//label[contains(text(),'Processing')]")
	WebElement labelForProcessing;

	@FindBy(xpath = "//a[@id='edit-services']")
	WebElement buttonEditService;

	@FindBy(xpath = "//input[@id='update-services']")
	WebElement buttonUpdateService;

	@FindBy(xpath = "//input[@data-type='billing']")
	WebElement uploadBillingRecords;

	@FindBy(xpath = "//input[@data-type='other']")
	WebElement uploadOtherDocuments;

	@FindBy(xpath = "//input[@data-type='certifications']")
	WebElement uploadCertification;

	@FindBy(xpath = "//input[@data-type='medical']")
	WebElement uploadMedicalRecords;

	@FindBy(xpath = "//input[@data-type='affidavits']")
	WebElement uplaodAffidavits;

	@FindBy(xpath = "//input[@data-type='archived_records']")
	WebElement uploadArchivedRecords;

	@FindBy(xpath = "//input[@data-type='images']")
	WebElement uploadImageRecords;

	@FindBy(xpath = "//a[@id='generate-quote']")
	WebElement buttonSubmitToRequestor;

	@FindBy(xpath = "//button[@id='approve-picing-strategy-btn']")
	WebElement buttonApprovePricingStrategy;

	@FindBy(xpath = "//a[@id='approve-service-btn']")
	WebElement buttonApproveService;

	@FindBy(xpath = "//a[@id='submit-to-req-btn']")
	WebElement buttonSubmitToRequestorRequestProcessing;

	@FindBy(xpath = "//a[contains(text(),'Search Requestors')]")
	WebElement tabSearchRequestor;

	@FindBy(xpath = "//input[@id='search_email']")
	WebElement inputEmailId;

	@FindBy(xpath = "//label[contains(text(),'Enable bulk upload')]")
	WebElement checkboxEnableBulkUpload;

	@FindBy(xpath = "//i[@class='icon-user']")
	WebElement userIcon;

	@FindBy(xpath = "//a[contains(text(),'Create Bulk Request')]")
	WebElement createBulkRequest;

	@FindBy(xpath = "//a[text()='Start']")
	WebElement buttonStartBulkUpload;

	@FindBy(xpath = "//input[@name='commit']")
	WebElement searchButton;

	@FindBy(xpath = "//*[@id='company-search-list']/div/table/tbody/tr/td[1]/a")
	WebElement searchResult;

	@FindBy(xpath = "//a[@data-scroll='statements']")
	WebElement selectStatement;

	@FindBy(xpath = "//a[text()='Edit General Settings']")
	WebElement buttonEditGeneralSettings;

	@FindBy(xpath = "//div[contains(@class,'form-actions')]//input[contains(@name,'commit')]")
	WebElement buttonUpdateCustodian;

	@FindBy(xpath = "//div[@id='notice']")
	WebElement confrimationMessage;

	@FindBy(xpath = "//button[text()='Select']")
	WebElement buttonSelectBulkUpload;

	@FindBy(xpath = "//button[text()='Browse']")
	WebElement buttonBrowserBulk;

	@FindBy(xpath = "//button[text()='Upload Master Authorization']")
	WebElement buttonUploadMasterAuthorization;

	@FindBy(xpath = "//button[@id='btn-submit-requests']")
	WebElement buttonSubmitBulkUpload;

	@FindBy(xpath = "//b[contains(text(),'Requests created successfully.')]")
	WebElement labelBulkCompleteMessage;

	@FindBy(xpath = "//a[contains(text(),'View Pending Requests')]")
	WebElement buttonViewPenidngRequests;

	/*
	 * @FindBy(xpath = "//*[@id='bulk-upload-request-file']") WebElement
	 * buttonBrowserBulk;
	 */

	@FindBy(xpath = "//a[contains(text(),'Walk-in Request')]")
	WebElement buttonWalkinRequestTopCustodian;

	@FindBy(xpath = "//input[@id='walkin_requestor_form_name']")
	WebElement inputRequestorNameOrCompanyCustodian;

	@FindBy(xpath = "//div[@class='centered remove-right-padding']//input[@name='commit']")
	WebElement buttonNextRequestorName;

	@FindBy(xpath = "//input[@id='search_email']")
	WebElement inputCustodianEmailId;

	@FindBy(xpath = "//div[@class='alert alert-info']")
	WebElement noCustodian;

	@FindBy(xpath = "//a[contains(@class,'pull-right btn reset-search')]")
	WebElement buttonClearAndSearch;

	@FindBy(xpath = "//label[contains(text(),'Allow Walk-in Requests')]")
	WebElement labelAllowWalkinRequest;

	@FindBy(xpath = "//div/a[text()='Submit']")
	WebElement buttonSubmitCustodian;

	@FindBy(xpath = "//ul[contains(@class,'services-list delivery')]//label[1]")
	WebElement radioFaxButton;

	@FindBy(xpath = "//span[contains(text(),'Select Requestor Type')]")
	WebElement inputSelectRequestorType;

	@FindBy(xpath = "//div[@id='request_walkin_requestor_type_chosen']//input[@class='chosen-search-input']")
	WebElement inputSelectValueFromDropDownSelectRequestorType;

	@FindBy(xpath = "//span[contains(text(),'Select Frequent Requestor')]")
	WebElement inputSelectFrequentRequestor;

	@FindBy(xpath = "//div[@id='frequent_requestor_id_chosen']//input[@class='chosen-search-input']")
	WebElement inputSelectValueFromDropDownSelectFrequentRequestor;

	@FindBy(xpath = "//input[@id='request-fax-number']")
	WebElement inputFaxNumber;

	@FindBy(xpath = "//input[@id='request_recipient_name']")
	WebElement inputRecipientNameFax;

	@FindBy(xpath = "//i[@class='icon-service-affidavit']")
	WebElement radioButtonRecordCeritificateProcessing;

	@FindBy(xpath = "//button[text()='Submit to QA']")
	WebElement buttonSubmitToQA;

	@FindBy(xpath = "//a[contains(text(),'Perform QA Now')]")
	WebElement buttonPerformQANow;

	@FindBy(xpath = "//h4[text()='Authorization QA Checklist']")
	WebElement labelAuthorizationQAChecklistHeading;

	@FindBy(xpath = "//h4[text()='Records QA Checklist']")
	WebElement labelRecordsQAChecklistHeading;

	@FindBy(xpath = "//label[text()='Authorization Compliant']")
	WebElement checkBoxAuthorizationCompliant;

	@FindBy(xpath = "//label[text()='Patient Name Verified & Matches']")
	WebElement checkBoxPatientNameVerifiedAndMatches;

	@FindBy(xpath = "//div[not(@style='display: none;') and @class='qa-record-check-list']/div[1]/label/input")
	WebElement checkBoxPatientNameVerifiedAndMatchesMedical;

	@FindBy(xpath = "//label[text()='Authorization is Signed']")
	WebElement checkBoxAuthorizationisSigned;

	// Medical Checkbox
	@FindBy(xpath = "//div[not(@style='display: none;') and @class='qa-record-check-list']/div[2]/label/input")
	WebElement checkBoxDatesofServiceRequestedVerifiedAndMatch;

	@FindBy(xpath = "//div[not(@style='display: none;') and @class='qa-record-check-list']/div[3]/label/input")
	WebElement checkBoxRecordCertificationUploaded;

	@FindBy(xpath = "//button[text()='Approve']")
	WebElement buttonApprove;

	@FindBy(xpath = "//button[text()='Approve' and @id='qa-approve-record-btn']")
	WebElement buttonApproveMedical;

	/*
	 * @FindBy(xpath = "//div/button[@id='qa-release-record']") WebElement
	 * buttonReleaseRecords;
	 */

	@FindBy(xpath = "//div[contains(@class,'col-sm-4 qa-right-panel-2')]//button[@id='qa-release-record']")
	WebElement buttonReleaseRecords;

	@FindBy(xpath = "//a[@id='qa-approve-release']")
	WebElement dropDownReleaseNowRecords;

	/*
	 * @FindBy(xpath =
	 * "//textarea[@id='message']/preceding::div[@class='msg-requestor statusmessage'][1]"
	 * ) WebElement lastChartMessageRequestor;
	 */

	@FindBy(xpath = "//textarea[@id='message']/preceding::div[@class='msg-requestor usermessage'][1]")
	WebElement lastChartMessage;

	@FindBy(xpath = "//textarea[@id='message']/preceding::div[@class='msg-custodian usermessage'][1]")
	WebElement lastChartMessageCustodian;

	@FindBy(xpath = "//textarea[@id='message']")
	WebElement inputChartMessage;

	@FindBy(xpath = "//div[@id='internal']//textarea[@id='message']")
	WebElement inputChartMessgaeInternal;

	@FindBy(xpath = "//input[@value='Send']")
	WebElement buttonSendChat;

	@FindBy(xpath = "//a[contains(text(),'Public')]")
	WebElement tabPublicReplyCustodian;

	@FindBy(xpath = "//a[contains(text(),'Pay with Credit Card')]")
	WebElement payWithCreditCard;

	@FindBy(xpath = "//button[contains(text(),'Submit Payment')]")
	WebElement buttonSubmitPayment;

	@FindBy(xpath = "//a[@class='btn btn-large dropdown-toggle']")
	WebElement buttonMarkAsIncomplete;

	@FindBy(xpath = "//a[contains(text(),'Revisit Minimum Necessary')]")
	WebElement optionReasonOfMarkAsIncomplete;

	@FindBy(xpath = "//i[@class='fas fa-lock lock-icon-css']")
	WebElement buttonLock;

	@FindBy(xpath = "//i[contains(@class,'fas fa-unlock lock-unlock-icon-css')]")
	WebElement buttonUnlock;

	@FindBy(xpath = "//input[@id='lock_reason']")
	WebElement inputReasonOfLocking;

	@FindBy(xpath = "//button[@class='btn btn-default lock_request_confirm']")
	WebElement buttonLockInputPage;

	@FindBy(xpath = "//a[contains(text(),'Reopen Request')]")
	WebElement buttonReopenRequest;

	@FindBy(xpath = "//a[contains(text(),'Make a New Walkin Request for Records')]")
	WebElement buttonSpuMakeaNewWalkinRequestforRecords;

	@FindBy(xpath = "//button[@class='pull-right btn btn-primary ml10']")
	WebElement buttonSearchCustodianSPU;

	@FindBy(xpath = "//a[text()='Select Custodian']")
	WebElement buttonSelectCustodianSPU;

	@FindBy(xpath = "//input[@id='email']")
	WebElement inputEmailforRequestorSPU;

	@FindBy(xpath = "//button[@class='btn btn-primary pull-right-lg']")
	WebElement buttonSearchRequestorSPU;

	@FindBy(xpath = "//a[@class='btn btn-success arrow-white pull-right']")
	WebElement buttonSelectSearchRequestorSPU;

	@FindBy(xpath = "//button[@class='btn  btn-large submit-walkin-request-modal submit-walkin-request']")
	WebElement buttonNoSubmitWithoutSendingEmail;

	@FindBy(xpath = "//h1[@class='req-heading-title']//strong")
	WebElement requestID;

	@FindBy(xpath = "//label[contains(normalize-space(),'Pay By Check')]")
	WebElement labelPayByCkeck;
	
	@FindBy(xpath = "//li[@id='requests']//a[@href='/custodian']")
	WebElement tabRequestTopNavigation;
	
	@FindBy(xpath = "//a[normalize-space()='Records Delivered']")
	WebElement buttonRecordsDelivered;
	
	@FindBy(xpath = "//a[normalize-space()='Sent By Fax']")
	WebElement buttonSentByFax;
	
	@FindBy(xpath = "//label[normalize-space()='Pay By Check']/input")
	WebElement checkboxPayByCheck;
	
	@FindBy(xpath = "//label[normalize-space()='Pay By Credit Card']/input")
	WebElement checkboxPayByCreditCard;
	
	@FindBy(xpath = "//a[normalize-space()='Requests']")
	WebElement tabRequest;
	
	@FindBy(xpath = "//h4[normalize-space()='Request Records']/following::a[@href='/care_coordination/new_request']")
	WebElement buttonMakeaRequestCareCoordination;
	
	@FindBy(xpath = "//button[normalize-space()='Start']")
	WebElement buttonStart;
	
	@FindBy(xpath = "//input[@id='patient-firstname']")
	WebElement inputCareCoordinationPatientFirstName;

	@FindBy(xpath = "//input[@id='patient-lastname']")
	WebElement inputCareCoordinationPatientLastName;
	
	@FindBy(xpath = "//button[@data-steptochange='step-patient-dob'][normalize-space()='Next Step']")
	WebElement buttonNextMoveToDateOfBirth;
	
	@FindBy(xpath = "//input[@id='patient-dob']")
	WebElement inputCareCoordinationPatientDateOfBirth;
	
	@FindBy(xpath = "//button[@data-steptochange='step-patient-ssn'][normalize-space()='Next Step']")
	WebElement buttonNextMoveToSSN;
	
	@FindBy(xpath = "//button[@data-steptochange='step-patient-phone'][normalize-space()='Next Step']")
	WebElement buttonNextMoveToPhoneNumber;
	
	@FindBy(xpath = "//button[@data-steptochange='step-patient-appointment'][normalize-space()='Next Step']")
	WebElement buttonNextMoveToAppointment;

	@FindBy(xpath = "//button[@data-steptochange='step-select-provider'][normalize-space()='Next Step']")
	WebElement buttonNextMoveToSelectCustodian;

	@FindBy(xpath = "//span[@class='twitter-typeahead']//input[@id='search-provider-name']")
	WebElement inputCustodianName;
	
	@FindBy(xpath = "//div[@class='tt-suggestion tt-selectable']")
	WebElement dropDownSearchCustodian;
	
	@FindBy(xpath = "//button[@class='btn btn-invert pull-right btn-request-provider']")
	WebElement selectSearchCustodianName;
	
	@FindBy(xpath = "//button[@data-steptochange='step-record-details'][normalize-space()='Next Step']")
	WebElement buttonNextMoveToRecordDetails;
	
	@FindBy(xpath = "//button[@class='btn btn-invert btn-record-type'][normalize-space()='Medical']")
	WebElement buttonMedicalRecords;
	
	@FindBy(xpath = "//button[@class='btn btn-invert btn-dos'][normalize-space()='All']")
	WebElement buttonMedicalAllDurationRecords;
	
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement buttonContinue;
	
	@FindBy(xpath = "//button[@class='btn pull-right submit-req-btn waves-effect waves-light']")
	WebElement buttonSubmitRequestCareCoordination;
	
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-auto clickable offset-sm-3 offset-lg-1 offset-xl-3 p-2 provider-details btn-provider-advance-search btn']//u[contains(text(),'Try our Advance Search')]")
	WebElement linkTryOurAdvanceSearch;
	
	@FindBy(xpath = "//input[@id='provider_name']")
	WebElement inputTryOurAdvanceSearchProviderName;
	
	@FindBy(xpath = "//button[@class='btn bg-green btn-modal-search-provider pull-right waves-effect waves-light']")
	WebElement buttonSearchTryOurAdvanceSearch;
	
	@FindBy(xpath = "//div[@id='provider-modal-search-result']//div[1]//div[3]//button[1]")
	WebElement selectRequestAfterSearch;
	
	@FindBy(xpath = "//button[normalize-space()='Done']")
	WebElement buttonDoneTryOurAdvanceSearch;
	
	@FindBy(xpath = "//*[@id='request-submit-success-msg-holder']/div[1]/p[2]/a")
	WebElement linkOutboundRequest;
	
	@FindBy(xpath = "//tbody/tr[@class='odd outbound read-request'][1]/td[3]")
	WebElement requestIdCareCoordination;
	
	@FindBy(xpath = "//button[@class='btn btn-invert btn-filter-req all-filter pl-2']")
	WebElement tabAllFilter;
	
	@FindBy(xpath = "//button[@class='btn btn-invert btn-filter-req']//span[@class='ml-1 status-name'][normalize-space()='Pending']")
	WebElement tabPending;
	
	@FindBy(xpath = "//*[@id='table-inbound-request']/thead/tr/th[3]/span")
	WebElement buttonSortWithRequestId;
	
	@FindBy(xpath = "//button[@class='btn btn-sm-hollow-blue req-submit-to-requestor-btn perform-action-content']")
	WebElement buttonSubmitToRequestorCareCoordination;
	
	@FindBy(xpath = "//a[@href='/care_coordination/inbound_requests']")
	WebElement inboundRequest;
	
	@FindBy(xpath = "//a[contains(@href,'/care_coordination/walkin_request')][normalize-space()='Make a Request']")
	WebElement buttonMakeARequestWalkin;
	
	@FindBy(xpath = "//input[@id='wi-requestor-name']")
	WebElement inputRequestorNameWalkin;
	
	@FindBy(xpath = "//button[normalize-space()='Select']")
	WebElement buttonSelectSearchRequestor;
	
	@FindBy(xpath = "//button[@data-steptochange='step-patient-detail'][normalize-space()='Next']")
	WebElement buttonNext;
	
	@FindBy(xpath = "//input[@id='wi-patient-firstname']")
	WebElement inputFirstNameWalkin;
	
	@FindBy(xpath = "//input[@id='wi-patient-lastname']")
	WebElement inputLastNameWalkin;
	
	@FindBy(xpath = "//button[@data-steptochange='step-patient-dob'][normalize-space()='Next']")
	WebElement buttonNextAtPatientDetailsWalkin;
	
	@FindBy(xpath = "//input[@id='wi-patient-dob']")
	WebElement inputDateOfBirthWalkin;
	
	@FindBy(xpath = "//button[@data-steptochange='step-patient-ssn'][normalize-space()='Next']")
	WebElement buttonNextAtDateOfBirthWalkin;
	
	@FindBy(xpath = "//button[@data-steptochange='step-patient-phone'][normalize-space()='Next']")
	WebElement buttonNextAtSSNWalkin;
	
	@FindBy(xpath = "//button[@data-steptochange='step-record-details'][normalize-space()='Next']")
	WebElement buttonNextAtPhoneNumberWalkin;
	
	@FindBy(xpath = "//button[@data-steptochange='step-reason-record'][normalize-space()='Next']")
	WebElement buttonNextAtRecordsTypeWalkin;
	
	@FindBy(xpath = "//div[@class='select-wrapper mdb-select md-form mb-0 cc-dd cc-dd-line req-reason-select text-16 mt-1']")
	WebElement dropdownSelectReasonWalkin;
	
	//@FindBy(xpath = "//*[@id='select-options-c97378a2-ba49-4ffc-9a9a-426130de6bb0']/span/div/input")
	@FindBy(css = "ul[id='select-options-2ff563aa-2a39-4dcb-8185-459858088320'] input[placeholder='Search here..']")
	WebElement inputSearchReason;
	
	@FindBy(xpath = "//button[@data-steptochange='step-additional-info'][normalize-space()='Next']")
	WebElement buttonNextAtReasonOfRequestWalkin;
	
	@FindBy(xpath = "//button[@data-steptochange='step-record-deliver-method'][normalize-space()='Next']")
	WebElement buttonNextAtAdditionalInformationWalkin;
	
	@FindBy(css = "input[class='form-control fax-number text-14 mb-0 fax-format']")
	WebElement inputFaxNumberWalkinCareCoordination;
	
	@FindBy(xpath = "//input[@class='not-allow-space form-control recepient-name fax-recepient-name text-14 mb-0']")
	WebElement inputRecipientNameWalkin;
	
	@FindBy(xpath = "//div[@class='select-wrapper mdb-select md-form cc-dd mt-3 mb-0 select-fax-recepient-type']//input[@type='text']")
	WebElement inputRecipientTypeWalkin;
	
	@FindBy(css = "div[class='row wizard-step step-record-deliver-method cc-scroller'] li:nth-child(2) span:nth-child(1)")
	WebElement requestTypeFromDropDownWalkin;
	
	@FindBy(xpath = "//button[@data-steptochange='step-additional-service'][normalize-space()='Next']")
	WebElement buttonNextAtFaxDetailsInformationWalkin;
	
	@FindBy(xpath = "//button[@data-steptochange='step-payment-method'][normalize-space()='Next']")
	WebElement buttonNextAtAdditionalServiceWalkin;
	
	@FindBy(xpath = "//div[@data-service-key='pay_by_credit_card']")
	WebElement buttonPayByCreditCard;
	
	@FindBy(xpath = "//button[@data-steptochange='step-upload-auth'][normalize-space()='Next']")
	WebElement buttonNextAtPaymentMethodWalkin;
	
	@FindBy(xpath = "//span[normalize-space()='Authorization on File']")
	WebElement fileUploadTabAuthorization;
	
	//@FindBy(xpath = "//input[@class='upload-auth']")
	@FindBy(xpath = "//div[@class='row wizard-step step-upload-auth cc-scroller']//div[5]//div[1]")
	WebElement buttonUploadAuthorizationWalkin;
	
	@FindBy(xpath = "//button[normalize-space()='Review Request']")
	WebElement buttonReviewRequest;
	
	@FindBy(xpath = "//button[@class='btn pull-right submit-req-btn px-2 waves-effect waves-light btn-orange']")
	WebElement buttonSubmitRequestWalkin;
	
	@FindBy(xpath = "//span[@class='cc-form-edit-buttons btn-edit-patient-details pull-right']//span[contains(text(),'Edit')]")
	WebElement buttonEditPatientInformationWalkinRequest;
	
	@FindBy(xpath = "//input[@id='wi_edit_patient_lname']")
	WebElement inputWalkinEditPatientLastName;
	
	@FindBy(xpath = "//span[@class='patient-detail-save-edit save-edit pull-right']")
	WebElement buttonSaveNewDetails;
	
	@FindBy(xpath = "//h2[normalize-space()='How do you want your records to be delivered?']")
	WebElement headingOfRecordToBeDelivered;
	
	@FindBy(xpath = "//div[normalize-space()='Instant Download']")
	WebElement buttonInstantDownload;
	
	@FindBy(xpath = "//a[contains(text(),'Last »')]")
	WebElement lastPageOfResults;
	
	@FindBy(xpath = "//button[normalize-space()='Approve Pricing Strategy']")
	WebElement buttonApprovePricingStrategyCareCoordination;
	
	@FindBy(xpath = "//button[normalize-space()='Approve Services']")
	WebElement buttonApproveServicesCareCoordination;
	
	@FindBy(xpath = "//button[@class='btn waves-effect waves-light px-1 action-btn submit-to-requestor-btn']")
	WebElement buttonSubmitRequestorFinalCareCoordination;
	
	@FindBy(xpath = "//input[@id='patient-ssn']")
	WebElement inputSociaclSecurityNumberCareCordination;
	
	@FindBy(xpath = "//input[@id='patient-phone']")
	WebElement inputPatientPhoneNumberCareCordination;
	
	@FindBy(xpath = "//input[@id='patient-appointment-date']")
	WebElement inputPatientAppointmentDateCareCordination;
	
	@FindBy(xpath = "//input[@class='select-dropdown']")
	WebElement inputRequestorTypeWalkinCareCoordination;
	
	@FindBy(xpath = "//input[@id='requestorAddress']")
	WebElement inputAddressCareCoordinationWalkin;
	
	@FindBy(xpath = "//input[@id='requestorCity']")
	WebElement inputRequestorCityCareCoordinationWalkin;
	
	@FindBy(xpath = "//label[contains(text(),'Enable Care Coordination')]/input")
	WebElement labelEnableCareCoordination;
	
	//@FindBy(xpath = "//label[contains(text(),'Enable Referral Management')]/input")
	@FindBy(xpath = "//input[@id='custodian_custodian_settings_attributes_enable_referral_management']")
	WebElement labelEnableReferralManagement;
	
	@FindBy(xpath = "//h4[normalize-space()='Refer a Patient']")
	WebElement headingReferAPatient;
	
	/*@FindBy(xpath = "//a[normalize-space()='Coming Soon']")
	WebElement buttonCardComingSoonCareCoordination;
	
	@FindBy(xpath = "//a[normalize-space()='Start Referral']")
	WebElement buttonCardStartReferralCareCoordination;*/
	
	@FindBy(xpath = "//a[@href='/care_coordination/referral_network']")
	WebElement buttonTextReferralCareCoordination;
	
	@FindBy(xpath = "//span[normalize-space()='Continue']")
	WebElement buttonContinueCareCoordinationAfterRefer;
	
	@FindBy(xpath = "//input[@id='rn-patient-firstname']")
	WebElement inputReferFirstNameCareCoordination;
	
	@FindBy(xpath = "//input[@id='rn-patient-lastname']")
	WebElement inputReferLastNameNameCareCoordination;
	
	@FindBy(xpath = "//button[@data-steptochange='step-patient-dob'][normalize-space()='Continue']")
	WebElement buttonContinueButtonOnPatientDetails;
	
	@FindBy(xpath = "//input[@id='rn-patient-dob']")
	WebElement inputReferPatientDateOfBirth;
	
	@FindBy(xpath = "//button[@data-steptochange='step-patient-ssn'][normalize-space()='Continue']")
	WebElement buttonContinueButtonOnDateOfBirthDetails;
	
	@FindBy(xpath = "//input[@id='rn-patient-ssn']")
	WebElement inputReferSSNCareCoordination;	
	
	@FindBy(xpath = "//button[@data-steptochange='step-patient-contact-info'][normalize-space()='Continue']")
	WebElement buttonContinueButtonSSNDetails;
	
	@FindBy(xpath = "//input[@id='rn-patient-phone']")
	WebElement inputReferPhoneNumber;
	
	@FindBy(xpath = "//input[@id='rn-patient-email']")
	WebElement inputReferEmailId;
	
	@FindBy(xpath = "//button[@data-steptochange='step-select-provider'][normalize-space()='Continue']")
	WebElement buttonContinueButtonContactDetails;
	
	@FindBy(xpath = "//input[@id='rn-search-custodian-name']")
	WebElement inputProviderNameRefer;
	
	@FindBy(xpath = "//button[@class='btn bg-green btn-rn-search-custodian mx-0 waves-effect waves-light']")
	WebElement buttonSearchButtonRefer;
	
	@FindBy(xpath = "//label[@class='custom-control-label clickable addclickarea']")
	WebElement selectTheSearchResult;
	
	@FindBy(xpath = "//button[@data-steptochange='step-upload-patient-file'][normalize-space()='Continue']")
	WebElement buttonContinueButtonSelectingProvider;
	
	@FindBy(xpath = "//div[@class='col-12 col-lg-6 mb-3 mb-lg-3 px-1 record-holder medical-record-holder']//*[@id='uploadCommonFiles']/input")
	WebElement uploadMedicalFile;
	
	@FindBy(xpath = "//button[@data-steptochange='step-patient-appointment'][normalize-space()='Continue']")
	WebElement buttonContinueButtonUploadingFile;
	
	@FindBy(xpath = "//a[@data-action='skip']")
	WebElement buttonSkipAppointment;
	
	@FindBy(xpath = "//label[@for=\"Medical'+ cust_id +'\"]")
	WebElement checkboxMedicalRequestReturnRecords;
	
	@FindBy(xpath = "//label[@for=\"Images'+ cust_id +'\"]")
	WebElement checkboxImagesRequestReturnRecords;
	
	@FindBy(xpath = "//label[@for=\"Billing'+ cust_id +'\"]")
	WebElement checkboxBillingRequestReturnRecords;
	
	@FindBy(xpath = "//textarea[@class='form-control z-depth-1 provider-comments']")
	WebElement textareaComments;
	
	@FindBy(xpath = "//button[normalize-space()='Verify Referral Details']")
	WebElement buttonVerifyReferralDetails;
	
	@FindBy(xpath = "//button[normalize-space()='Submit Referral']")
	WebElement buttonSubmitReferral;
	
	@FindBy(xpath = "//button[normalize-space()='SUBMIT REFERRAL']")
	WebElement buttonFinalSubmitReferral;
	
	@FindBy(xpath = "//span[@class='ref-req-id']")
	WebElement refernceNumber;
	
	@FindBy(xpath = "//a[contains(text(),'You can also review your referral’s status')]")
	WebElement linkOfReferralStatus;
	
	@FindBy(xpath = "//div[@class='col-12 mt-2 filter-by-holder mb-4']/span[normalize-space()='Nearby' ]")
	WebElement buttonNearByReferal;
	
	/**
	 * @author ashutosh.tiwari
	 * @since September 23 2020
	 * @Description Click on the Create New Request Button
	 * 
	 */

	public void createNewRequest() {
		makeaNewRequestForRecords.click();
		//TestListener.infoMessage("Click on Create New Request Button");
	}

	public void abandonRequest() {
		buttonAbandonRequest.click();
		driver.switchTo().alert().accept();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		boolean status = TestUtil.isElementDisplayed(errorMessage);
		if (status) {
			//TestListener.infoMessage("Request get Abandoned");
			Assert.assertTrue(errorMessage.getText().contains("has been abandoned"), "Request Get Abandoned");
		} else {
			Assert.assertFalse(errorMessage.getText().contains("has been abandoned"), "Request Not Get Abandoned");
			//TestListener.infoMessageFail("Request get Failed Abandoned");
		}
	}

	public void selectStateForRequestCreation(String State, String ProviderName) {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		selectState.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath("//div[@id='search_state_chosen']//ul[contains(@class,'chosen-results')]//li[contains(text(),'"
						+ State + "')]"))
				.click();
		inputProviderName.sendKeys(ProviderName);
		buttonSearch.click();
		//TestListener.infoMessage("State Name For Creating Request "+State+" ProviderName Found is "+ProviderName);
		if (TestUtil.isElementDisplayed(searchRequestorNameButton)) {
			wait.until(ExpectedConditions.elementToBeClickable(searchRequestorNameButton));
			searchRequestorNameButton.click();
			//TestListener.infoMessage(ProviderName+" Name Found");
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(buttonSelectBulkUpload));
			buttonSelectBulkUpload.click();
			//TestListener.infoMessage(ProviderName+" Name Found");
		}
	}

	public void payByCheque() {
		labelPayByCkeck.click();
	}

	public String fillFormDetailsRequestCreation(String firstName, String lastName, String dateofbirth,
			String medicalRecordType, boolean paymentByCC, String authorizationType) {
	String requestNo = null;
	try {
		TestUtil.hardWait(5);
		String userName = nameoFtheUser.getText();
		requestNo = getRequestNo();
		//TestListener.infoMessage("Request number is: "+requestNo);
		inputFirstNamePatientName.sendKeys(firstName);
		//TestListener.infoMessage("First Name is: "+firstName);
		inputLastNamePatientName.sendKeys(lastName);
		//TestListener.infoMessage("Last Name is: "+lastName);
		inputDateofBirthPatient.sendKeys(dateofbirth);
		//TestListener.infoMessage("Date of Birth is: "+dateofbirth);
		inputDateofBirthPatient.sendKeys(Keys.ENTER);
		inputRecordsType.click();
		driver.findElement(By.xpath("//li[contains(text(),'Medical')]")).click();
		inputReasonForRequest.click();
		driver.findElement(By.xpath("//li[contains(text(),'Other')]")).click();
		if (getTypeOfRequest().contains("Walkin") && userName.equalsIgnoreCase("Admin")) {
			wait.until(ExpectedConditions.elementToBeClickable(inputSelectRequestorType));
			inputSelectRequestorType.click();
			driver.findElement(By.xpath("//li[contains(text(),'Health Care Provider')]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(inputSelectFrequentRequestor));
			inputSelectFrequentRequestor.click();
			driver.findElement(By.xpath("//li[contains(text(),'Add a Requestor')]")).click();
			driver.findElement(By.xpath("//input[@id='frequent_requestor_name']"))
					.sendKeys(TestUtil.getAlphaDynamicString(8));
			driver.findElement(By.xpath("//input[@id='frequent_requestor_address']")).sendKeys("2222 Hillside Avenue");
			driver.findElement(By.xpath("//input[@id='frequent_requestor_city']")).sendKeys("Indianapolis");
			selectStateSPU("IN");
			driver.findElement(By.xpath("//input[@id='frequent_requestor_zipcode']")).sendKeys("46218");
			driver.findElement(By.xpath("//button[@id='add_frequent_requestor_btn']")).click();
		} else if (getTypeOfRequest().contains("Walkin")) {
			wait.until(ExpectedConditions.elementToBeClickable(inputSelectRequestorType));
			inputSelectRequestorType.click();
			driver.findElement(By.xpath("//li[contains(text(),'Health Care Provider')]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(inputSelectFrequentRequestor));
			inputSelectFrequentRequestor.click();
			driver.findElement(By.xpath("//li[contains(text(),'Automation Custodian')]")).click();
			radioFaxButton.click();
			inputFaxNumber.sendKeys("1234567890");
			inputFaxNumber.sendKeys(Keys.TAB);
			inputRecipientNameFax.sendKeys("Automation");
			selectRecipientType("Health Care Provider");
		}
		//TestListener.addDynamicScreenshotInReport("changeModeOfPayment");
		// Select Authorization
		if (authorizationType.contains("Patient eAuthorize")) {
			selectAuthorizationType(authorizationType);
			//TestListener.infoMessage("Type of Authorization is: "+authorizationType);
			js.executeScript("arguments[0].click();", buttonAdoptAndSign);
			wait.until(ExpectedConditions.visibilityOf(headingAdoptYourSignature));
			// dsfsd
			inputPatienetEauthFullName.sendKeys("Automation Testing");
			inputPatienetEauthInitials.sendKeys("Automation");
			inputPatienetEauthDOB.sendKeys("01011991");
			js.executeScript("arguments[0].click();", buttonPatienetEauthSubmit);
			TestUtil.hardWait(5);
		} else {
			selectAuthorizationType(authorizationType);
			wait.until(ExpectedConditions.elementToBeClickable(buttonFileUploadAuthorization));
			buttonFileUploadAuthorization.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonChooseFile));
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			js.executeScript("arguments[0].click();", buttonChooseFile);
			TestUtil.hardWait(5);
			try {
				Runtime.getRuntime()
						.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/FileUploadAuth.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
			TestUtil.hardWait(5);
			js.executeScript("arguments[0].click();", buttonUploadAuthorization);
			TestUtil.hardWait(5);
		}
		//TestListener.addDynamicScreenshotInReport("creatingNewRequest");
		if (TestUtil.isElementDisplayed(buttonSubmitCustodian)) {
			buttonSubmitCustodian.click();
		} else {
			js.executeScript("arguments[0].click();", buttonSendToProvider);
		}
		System.out.println("User Name is "+userName);
		if (userName.contains("Patient")) {
			wait.until(ExpectedConditions.elementToBeClickable(buttonApproveEstimate));
			//inputInitilasAtEstimatePendingPage.sendKeys("automation");
			buttonApproveEstimate.click();
		} else {
			buttonApproveEstimate.click();
		}
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// Mode of Payment
		modeOFPayment(paymentByCC, "4242424242424242", "420", "12", "2035");
		if (userName.equalsIgnoreCase("Admin")) {
			buttonNoSubmitWithoutSendingEmail.click();
		} else if (!userName.contains("Custodian")) {
			String actualInput = successfulMessage.getText();
			Assert.assertTrue(actualInput.contains(" sent to custodian"), "Request Completed");
		}
		
	
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return requestNo;
}

	public void selectAuthorizationType(String authorizationType) {
		Select selectAuthorizationName = new Select(driver.findElement(By.name("request[authorization_type]")));
		selectAuthorizationName.selectByVisibleText(authorizationType);
	}

	public void selectCreditCardMonth(String creditCardMonth) {
		Select selectSize = new Select(driver.findElement(By.xpath("//select[@id='card_month']")));
		selectSize.selectByValue(creditCardMonth);
	}

	public void selectCreditCardYear(String creditCardYear) {
		Select selectSize = new Select(driver.findElement(By.xpath("//select[@id='card_year']")));
		selectSize.selectByValue(creditCardYear);
	}

	public void modeOFPayment(boolean creditCard, String creditcardNo, String creditCardCVV, String ccMonth,
			String ccYear) {
		try {
			if (creditCard) {
				if (TestUtil.isElementDisplayed(linkAddCreditCard)) {
					linkAddCreditCard.click();
					inputCreditCardNumber.sendKeys(creditcardNo);
					inputCreditCardCVVNumber.sendKeys(creditCardCVV);
					selectCreditCardMonth(ccMonth);
					selectCreditCardYear(ccYear);
					addCreditCard.click();
					//TestListener.infoMessage("Adding the Credit Card");
					//TestListener.addDynamicScreenshotInReport("addCreditCardAdding");
					// js.executeScript("arguments[0].click();", addCreditCard);
					TestUtil.hardWait(10);
					wait.until(ExpectedConditions.elementToBeClickable(deleteSavedCards));
					js.executeScript("arguments[0].click();", visaCard);
					js.executeScript("arguments[0].click();", deleteSavedCards);
					TestUtil.hardWait(5);
					//wait.until(ExpectedConditions.alertIsPresent());
					//TestListener.infoMessage("Delete the Credit Card");
					driver.switchTo().alert().accept();
					//TestListener.addDynamicScreenshotInReport("addCreditCardDelete");
					TestUtil.hardWait(5);
					//wait.until(ExpectedConditions.elementToBeClickable(masterCard));
					TestUtil.isClickable(masterCard);
					js.executeScript("arguments[0].click();", masterCard);
					//masterCard.click();
					wait.until(ExpectedConditions.elementToBeClickable(buttonSubmitRequest));
					buttonSubmitRequest.click();
				}
			} else {
				js.executeScript("arguments[0].click();", buttonPayByCheque);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean verifyCareCordinationButton() {
		wait.until(ExpectedConditions.elementToBeClickable(buttonSearchMyRequests));
		boolean status = TestUtil.isElementDisplayed(buttonCareCoordination);
		return status;
	}

	public void changeCustodianToRequestor() {
		buttonRequestRecords.click();
	}

	public String getRequestNo() {
		String requestNo = requestNumber.getText().replaceAll("[^0-9]", "");
		return requestNo;
	}

	public String getTypeOfRequest() {
		//TestListener.infoMessage("Type of Request is: "+typeofRequest.getText());
		return typeofRequest.getText();
	}

	public void saveRequestIntoDraft() {
		String requestNo = getRequestNo();
		buttonSaveAsDraft.click();
		//TestListener.infoMessage("Clicked on Draft Button");
		buttonRequestOnTop.click();
		wait.until(ExpectedConditions.visibilityOf(buttonSearchMyRequests));
		buttonSearchMyRequests.click();
		searchMyName.searchByRequestID(requestNo);
	}

	public void openSearchPage() {
		String userName = nameoFtheUser.getText();
		if (!userName.contains("Custodian")) {
			wait.until(ExpectedConditions.elementToBeClickable(buttonRequestOnTop));
			buttonRequestOnTop.click();
			wait.until(ExpectedConditions.visibilityOf(makeaNewRequestForRecords));
			buttonSearchMyRequests.click();
		} else {
			wait.until(ExpectedConditions.elementToBeClickable(buttonRequestOnTop));
			buttonRequestOnTop.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			wait.until(ExpectedConditions.visibilityOf(buttonSearchMyRequests));
			buttonSearchMyRequests.click();

		}
	}

	public String getRequestID() {
		String userName = nameoFtheUser.getText();
		String RequestID;
		if (!userName.contains("Custodian")) {
			wait.until(ExpectedConditions.visibilityOf(buttonSearchMyRequests));
			int noOfRows = driver.findElements(By.xpath("//tr")).size();
			int elemetNo = noOfRows - 1;
			RequestID = driver.findElement(By.xpath("//tr[" + elemetNo + "]/td[2]/a")).getText();
		} else {
			// wait.until(ExpectedConditions.visibilityOf(buttonSearchMyRequests));
			int noOfRows = driver.findElements(By.xpath("//tr")).size();
			int elemetNo = noOfRows - 1;
			RequestID = driver.findElement(By.xpath("//tr[" + elemetNo + "]/td[3]/a")).getText();
		}
		//TestListener.infoMessage("Request Id is:- "+RequestID);
		System.out.println("Request Id is:- "+RequestID);
		return RequestID;
	}

	public void selectRequestTab() {
		wait.until(ExpectedConditions.elementToBeClickable(tabRequestTopNavigation));
		tabRequestTopNavigation.click();
		
	}
	
	public void processingRequest(boolean SubmitToQA) {
		String userName = nameoFtheUser.getText();
		if (!userName.equalsIgnoreCase("Admin")) {
			js.executeScript("arguments[0].click();", linkSearchRequestID);
			wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
			js.executeScript("arguments[0].click();", labelForProcessing);
		}
		TestUtil.hardWait(3);
		// wait.until(ExpectedConditions.elementToBeClickable(buttonEditService));
		// buttonEditService.click();
		// wait.until(ExpectedConditions.elementToBeClickable(radioButtonRecordCeritificateProcessing));
		// radioButtonRecordCeritificateProcessing.click();
		// js.executeScript("arguments[0].click();", buttonUpdateService);
		// Upload Billing Records
		// WebElement
		// newUploadBillingRecords=driver.findElement(By.xpath("//div[not(contains(@style,'display:none'))]/form"+uploadBillingRecords));
		if (TestUtil.isElementDisplayed(uploadBillingRecords)) {
			actions.moveToElement(uploadMedicalRecords);
			actions.click().build().perform();
			js.executeScript("arguments[0].click();", uploadBillingRecords);
			TestUtil.hardWait(5);
			try {
				Runtime.getRuntime()
						.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/FileUploadAuth.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
			TestUtil.hardWait(5);
		}

		// Upload Other Documents
		// WebElement
		// newUploadBillingRecords=driver.findElement(By.xpath("//div[not(contains(@style,'display:none'))]/form"+uploadBillingRecords));
		if (TestUtil.isElementDisplayed(uploadOtherDocuments)) {
			js.executeScript("arguments[0].click();", uploadOtherDocuments);
			TestUtil.hardWait(5);
			try {
				Runtime.getRuntime()
						.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/FileUploadAuth.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
			TestUtil.hardWait(5);
		}
		// Upload Certification
		if (TestUtil.isElementDisplayed(uploadCertification)) {
			js.executeScript("arguments[0].click();", uploadCertification);
			TestUtil.hardWait(5);
			try {
				Runtime.getRuntime()
						.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/FileUploadAuth.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
			TestUtil.hardWait(5);
		}
		// Upload Medical
		if (TestUtil.isElementDisplayed(uploadMedicalRecords)) {
			js.executeScript("arguments[0].click();", uploadMedicalRecords);
			TestUtil.hardWait(5);
			try {
				Runtime.getRuntime()
						.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/FileUploadAuth.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
			TestUtil.hardWait(5);
		}
		// Upload Affidavits
		if (TestUtil.isElementDisplayed(uplaodAffidavits)) {
			js.executeScript("arguments[0].click();", uplaodAffidavits);
			TestUtil.hardWait(5);
			try {
				Runtime.getRuntime()
						.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/FileUploadAuth.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
			TestUtil.hardWait(5);
		}
		// Upload archived
		if (TestUtil.isElementDisplayed(uploadArchivedRecords)) {
			js.executeScript("arguments[0].click();", uploadArchivedRecords);
			TestUtil.hardWait(5);
			try {
				Runtime.getRuntime()
						.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/FileUploadAuth.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
			TestUtil.hardWait(5);
		}
		// Upload Image
		if (TestUtil.isElementDisplayed(uploadImageRecords)) {
			js.executeScript("arguments[0].click();", uploadImageRecords);
			TestUtil.hardWait(5);
			try {
				Runtime.getRuntime()
						.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/FileUploadAuth.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
			TestUtil.hardWait(5);
		}
			if (SubmitToQA) {
				buttonSubmitToQA.click();
				wait.until(ExpectedConditions.elementToBeClickable(buttonPerformQANow));
				buttonPerformQANow.click();
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
				}
	
			} else {
			TestUtil.hardWait(5);
			js.executeScript("arguments[0].click();", buttonSubmitToRequestor);
			TestUtil.hardWait(10);
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
	}

	public void enableBulkUpload(String Name) {
		wait.until(ExpectedConditions.elementToBeClickable(tabSearchRequestor));
		tabSearchRequestor.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputEmailId));
		inputEmailId.click();
		inputEmailId.clear();
		inputEmailId.sendKeys(Name);
		searchButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(searchResult));
		searchResult.click();
		System.out.println("Click on Search Result");
		wait.until(ExpectedConditions.elementToBeClickable(buttonEditGeneralSettings));
		System.out.println("Clicking on Gernal Settings");
		buttonEditGeneralSettings.click();
		wait.until(ExpectedConditions.elementToBeClickable(checkboxEnableBulkUpload));
		checkboxEnableBulkUpload.click();
		//TestListener.infoMessage("Enable Bulk File Button");
		buttonUpdateCustodian.click();
		wait.until(ExpectedConditions.visibilityOf(confrimationMessage));
	}

	public void openBulkUploadPage() {
		userIcon.click();
		createBulkRequest.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonStartBulkUpload));
		buttonStartBulkUpload.click();
		//TestListener.infoMessage("Bulk File Upload Process Start");
	}

	public void uploadBulkUploadFile() {
		TestUtil.hardWait(5);
		TestUtil.scrollToElement(buttonBrowserBulk);
		// input[@id='bulk-upload-request-file'] //
		// wait.until(ExpectedConditions.visibilityOf(buttonBrowserBulk));
		// js.executeScript("arguments[0].click();", buttonBrowserBulk);
		actions.moveToElement(buttonBrowserBulk);
		actions.click().build().perform();
		// buttonBrowserBulk.click();
		TestUtil.hardWait(5);
		try {
			Runtime.getRuntime()
					.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/BulkFileUpload.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		TestUtil.hardWait(5);
		actions.moveToElement(buttonUploadMasterAuthorization);
		actions.click().build().perform();
		TestUtil.hardWait(5);
		try {
			Runtime.getRuntime()
					.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/FileUploadAuth.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		TestUtil.hardWait(5);
		buttonSubmitBulkUpload.click();
		TestUtil.hardWait(30);
		wait.until(ExpectedConditions.visibilityOf(buttonViewPenidngRequests));
		buttonViewPenidngRequests.click();
		wait.until(ExpectedConditions.elementToBeClickable(makeaNewRequestForRecords));
		//TestListener.infoMessage("Bulk File Proceess Completed");
	}

	public void walkinRequest() {
		buttonWalkinRequestTopCustodian.click();
		inputRequestorNameOrCompanyCustodian.sendKeys(GlobalVariables.custodianEmailStaging);
		buttonNextRequestorName.click();
	}

	public boolean verifyWalkinButton() {
		System.out.println("Searching for Walkin Button");
		boolean status = TestUtil.isElementDisplayed(buttonWalkinRequestTopCustodian);
		return status;
	}

	public void enableWakinRequest() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(inputCustodianEmailId));
			inputCustodianEmailId.click();
			System.out.println("Click on Input Email");
			inputCustodianEmailId.clear();
			System.out.println("Clear Input ID");
			inputCustodianEmailId.sendKeys(GlobalVariables.custodianEmailStaging);
			System.out.println("Enter Custodian Email");
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
				wait.until(ExpectedConditions.elementToBeClickable(labelAllowWalkinRequest));
				labelAllowWalkinRequest.click();
				buttonUpdateCustodian.click();
				wait.until(ExpectedConditions.visibilityOf(confrimationMessage));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectRecipientType(String recipientType) {
		Select selectSize = new Select(driver.findElement(By.name("request[recipient_type]")));
		selectSize.selectByVisibleText(recipientType);
	}

	public void getchartMessageRequest(String RequestID, String message) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='" + RequestID + "']"))));
		driver.findElement(By.xpath("//a[text()='" + RequestID + "']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(inputChartMessage));
		if (message != null) {
			inputChartMessage.sendKeys(message);
			buttonSendChat.click();
		} else {
			System.out.println("No Need to Send Message");

		}
		TestUtil.scrollDown();
		if (TestUtil.isElementDisplayed(lastChartMessage)) {
			wait.until(ExpectedConditions.visibilityOf(lastChartMessage));
			String excepted = lastChartMessage.getText();
			System.out.println("Actual Chat Message is From Custodian: " + excepted);
			//TestListener.infoMessage("Actual Chat Message is From Custodian: " + excepted);
		} else {
			wait.until(ExpectedConditions.visibilityOf(lastChartMessageCustodian));
			String excepted = lastChartMessageCustodian.getText();
			System.out.println("Actual Chat Message is From Custodian: " + excepted);
			//TestListener.infoMessage("Actual Chat Message is From Custodian: " + excepted);
		}

		/*
		 * wait.until(ExpectedConditions.visibilityOf(lastChartMessage)); String actual
		 * = lastChartMessage.getText();
		 * System.out.println("Actual Chat Message is From Requestor: " + actual);
		 */
	}

	public void getchartMessageCustodian(String RequestID, boolean wantToSendMessagePublicliy, String message) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='" + RequestID + "']"))));
		driver.findElement(By.xpath("//a[text()='" + RequestID + "']")).click();
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);
		wait.until(ExpectedConditions.elementToBeClickable(inputChartMessgaeInternal));
		if (message == null) {
			System.out.println("No Need to Send Message");
		} else {
			if (wantToSendMessagePublicliy) {
				tabPublicReplyCustodian.click();
				wait.until(ExpectedConditions.elementToBeClickable(inputChartMessage));
				inputChartMessage.sendKeys(message);
				buttonSendChat.click();
			} else {
				System.out.println("Im at Internal Note");
			}
		}
		if (TestUtil.isElementDisplayed(lastChartMessage)) {
			wait.until(ExpectedConditions.visibilityOf(lastChartMessage));
			String excepted = lastChartMessage.getText();
			System.out.println("Actual Chat Message is From Custodian: " + excepted);
		} else {
			wait.until(ExpectedConditions.visibilityOf(lastChartMessageCustodian));
			String excepted = lastChartMessageCustodian.getText();
			System.out.println("Actual Chat Message is From Custodian: " + excepted);
		}

	}

	public String getSearchByMultipleFilter() {
		int noOfRows = driver.findElements(By.xpath("//tr")).size();
		int elemetNo = noOfRows - 1;
		String RequestID = driver.findElement(By.xpath("//tr[" + elemetNo + "]/td[2]/a")).getText();
		return RequestID;
	}

	public void completingRequest(String RequestID) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='" + RequestID + "']"))));
		driver.findElement(By.xpath("//a[text()='" + RequestID + "']")).click();
		System.out.println("Selecting the Credit Card");
		js.executeScript("arguments[0].click();", payWithCreditCard);
		wait.until(ExpectedConditions.elementToBeClickable(masterCard));
		js.executeScript("arguments[0].click();", masterCard);
		wait.until(ExpectedConditions.elementToBeClickable(buttonSubmitPayment));
		js.executeScript("arguments[0].click();", buttonSubmitPayment);

	}

	public void openSearchTicketIncompleteRequest(String RequestID) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='" + RequestID + "']"))));
		driver.findElement(By.xpath("//a[text()='" + RequestID + "']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(labelForProcessing));
		labelForProcessing.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonMarkAsIncomplete));
		buttonMarkAsIncomplete.click();
		optionReasonOfMarkAsIncomplete.click();
		String actualMessage = errorMessage.getText();
		System.out.println("Actual message " + actualMessage);
		String expectedMessage = "Request " + RequestID + " has been incompleted because Revisit Minimum Necessary.";
		if (actualMessage.contains(expectedMessage)) {
			System.out.println(RequestID + " complete as Mark as Incomplete");
			//TestListener.infoMessage(RequestID+" complete as Mark as Incomplete");
		} else {
			System.out.println(RequestID + " Not complete as Mark as Incomplete");
			//TestListener.infoMessageFail(RequestID+" Not complete as Mark as Incomplete");
		}
	}

	public void lockandUnlockRequest(String RequestID) {
		try {
			wait.until(
					ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='" + RequestID + "']"))));
			driver.findElement(By.xpath("//a[text()='" + RequestID + "']")).click();
			wait.until(ExpectedConditions.elementToBeClickable(labelForProcessing));
			labelForProcessing.click();
			if (TestUtil.isElementDisplayed(buttonLock)) {
				wait.until(ExpectedConditions.elementToBeClickable(buttonLock));
				buttonLock.click();
				inputReasonOfLocking.sendKeys(GlobalVariables.reasonOfLocking);
				buttonLockInputPage.click();
				wait.until(ExpectedConditions.visibilityOf(lastChartMessageCustodian));
				String actualMessage = lastChartMessageCustodian.getText();
				String expectedMessage = "This request has been locked until further notice. Reason: Automation Testing";
				if (actualMessage.contains(expectedMessage)) {
					System.out.println(RequestID + " getting locked");
					//TestListener.infoMessage(RequestID+" getting locked");
				} else {
					System.out.println(RequestID + " not getting locked");
					//TestListener.infoMessageFail(RequestID+" not getting locked");
				}
			} else {
				wait.until(ExpectedConditions.elementToBeClickable(buttonUnlock));
				buttonUnlock.click();
				driver.switchTo().alert().accept();
				wait.until(ExpectedConditions.visibilityOf(lastChartMessageCustodian));
				String actualMessage = lastChartMessageCustodian.getText();
				String expectedMessage = "This request has been unlocked";
				if (actualMessage.contains(expectedMessage)) {
					System.out.println(RequestID + " getting unlocked");
					//TestListener.infoMessage(RequestID+" getting unlocked");
				} else {
					System.out.println(RequestID + " not getting unlocked");
					//TestListener.infoMessageFail(RequestID+" not getting unlocked");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void openAbandonedRequest(String RequestID) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='" + RequestID + "']"))));
		driver.findElement(By.xpath("//a[text()='" + RequestID + "']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonReopenRequest));
		buttonReopenRequest.click();
		wait.until(ExpectedConditions.visibilityOf(errorMessage));
		String actualMessage = errorMessage.getText();
		String expectedMessage = "Request " + RequestID + " reopened.";
		if (actualMessage.contains(expectedMessage)) {
			System.out.println(RequestID + " is Re-opened");
			//TestListener.infoMessage(RequestID+" is Re-opened");
		} else {
			System.out.println(RequestID + " not Re-opened");
			//TestListener.infoMessageFail(RequestID+" not Re-opened");
		}
	}

	public String getSearchByMultipleFilterRequestor() {
		int noOfRows = driver.findElements(By.xpath("//tr")).size();
		int elemetNo = noOfRows - 1;
		String RequestID = driver.findElement(By.xpath("//tr[" + elemetNo + "]/td[1]/a")).getText();
		return RequestID;
	}

	public void walkinRequestSPU(String State, String ProviderName, String RequestorEmailID) {
		try {

			buttonWalkinRequestTopCustodian.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonSpuMakeaNewWalkinRequestforRecords));
			buttonSpuMakeaNewWalkinRequestforRecords.click();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			selectState.click();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.findElement(By.xpath(
					"//div[@id='search_state_chosen']//ul[contains(@class,'chosen-results')]//li[contains(text(),'"
							+ State + "')]"))
					.click();
			inputProviderName.sendKeys(ProviderName);
			buttonSearchCustodianSPU.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonSelectCustodianSPU));
			buttonSelectCustodianSPU.click();
			wait.until(ExpectedConditions.elementToBeClickable(inputEmailforRequestorSPU));
			inputEmailforRequestorSPU.sendKeys(RequestorEmailID);
			wait.until(ExpectedConditions.elementToBeClickable(buttonSearchRequestorSPU));
			buttonSearchRequestorSPU.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonSelectSearchRequestorSPU));
			buttonSelectSearchRequestorSPU.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectStateSPU(String StateSPU) {
		Select select = new Select(driver.findElement(By.name("frequent_requestor_state")));
		select.selectByVisibleText(StateSPU);
	}

	public void selectTypeOfProcessingRequest() {
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);
	}

	public String sendMessage(boolean wantToSendMessagePublicliy, String message) {
		String requestID = getRequestNo();
		wait.until(ExpectedConditions.elementToBeClickable(inputChartMessgaeInternal));
		if (message == null) {
			System.out.println("No Need to Send Message");
			//TestListener.infoMessage("No Need to Send Message");
		} else {
			if (wantToSendMessagePublicliy) {
				tabPublicReplyCustodian.click();
				//TestListener.infoMessage("Selected The Public Reply tab");
				wait.until(ExpectedConditions.elementToBeClickable(inputChartMessage));
				inputChartMessage.sendKeys(message);
				//TestListener.infoMessage("Entering The Message "+message);
				buttonSendChat.click();
			} else {
				System.out.println("Im at Internal Note");
				//TestListener.infoMessage("Internal Note Tab is Selected");

			}
		}
		return requestID;
	}
	
	public void processOfWalkinRequest() {
		String userName = nameoFtheUser.getText();
		if (!userName.equalsIgnoreCase("Admin")) {
			js.executeScript("arguments[0].click();", linkSearchRequestID);
			wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
			js.executeScript("arguments[0].click();", labelForProcessing);
		}
		buttonRecordsDelivered.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonSentByFax));
		buttonSentByFax.click();
	}
	
	public void changeTheService() {
		wait.until(ExpectedConditions.visibilityOf(headingforProcessing));
		js.executeScript("arguments[0].click();", labelForProcessing);
		wait.until(ExpectedConditions.elementToBeClickable(buttonEditService));
		buttonEditService.click();
		wait.until(ExpectedConditions.visibilityOf(checkboxPayByCreditCard));
		System.out.println("Status of Pay By Check "+checkboxPayByCheck.isSelected());
		System.out.println("Status of Pay By Credit Card "+checkboxPayByCreditCard.isSelected());
		if (checkboxPayByCheck.isSelected()) {
			checkboxPayByCreditCard.click();
		} else {
			checkboxPayByCheck.click();
		}
		buttonUpdateService.click();
		wait.until(ExpectedConditions.visibilityOf(confrimationMessage));
		//TestListener.addDynamicScreenshotInReport("changeTheService");
	}
	
	public String createRequestFromCareCordination(String CustodianName) {
		String requestId = null;
		wait.until(ExpectedConditions.elementToBeClickable(buttonMakeaRequestCareCoordination));
		buttonMakeaRequestCareCoordination.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonStart));
		buttonStart.click();
		wait.until(ExpectedConditions.visibilityOf(inputCareCoordinationPatientFirstName));
		inputCareCoordinationPatientFirstName.sendKeys("Automation");
		String tempNo=TestUtil.getAlphaDynamicString(5);
		inputCareCoordinationPatientLastName.sendKeys("Testing "+tempNo);
		System.out.println("Patient Name is "+"Automation Testing "+tempNo);
		//TestListener.infoMessage("Patient Name is "+"Automation Testing "+tempNo);
		buttonNextMoveToDateOfBirth.click();
		wait.until(ExpectedConditions.visibilityOf(inputCareCoordinationPatientDateOfBirth));
		inputCareCoordinationPatientDateOfBirth.sendKeys("01011991");
		inputCareCoordinationPatientDateOfBirth.sendKeys(Keys.ENTER);
		//Skip The Social Security Number
		wait.until(ExpectedConditions.visibilityOf(buttonNextMoveToSSN));
		buttonNextMoveToSSN.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputSociaclSecurityNumberCareCordination));
		inputSociaclSecurityNumberCareCordination.sendKeys("123456789");
		//Skip The Phone Number
		wait.until(ExpectedConditions.visibilityOf(buttonNextMoveToPhoneNumber));
		buttonNextMoveToPhoneNumber.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputPatientPhoneNumberCareCordination));
		inputPatientPhoneNumberCareCordination.sendKeys("1234567890");
		//Skip The Appointment
		wait.until(ExpectedConditions.visibilityOf(buttonNextMoveToAppointment));
		buttonNextMoveToAppointment.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputPatientAppointmentDateCareCordination));
		inputPatientAppointmentDateCareCordination.sendKeys(TestUtil.getNextDate());
		//Select The Custodian
		wait.until(ExpectedConditions.visibilityOf(buttonNextMoveToSelectCustodian));
		buttonNextMoveToSelectCustodian.click();
		wait.until(ExpectedConditions.visibilityOf(inputCustodianName));
		String tempValue=driver.findElement(By.xpath("//div[@class='col-12 mt-2']/span[@data-filter_by='nearby']")).getAttribute("class");
		System.out.println("Value of Nearby:- "+tempValue);
		String url=driver.getCurrentUrl();
		if (url.contains("preproduction")) {
			if (tempValue.contains("provider-filter badge")) {
				driver.findElement(By.xpath("//div[@class='col-12 mt-2']/span[@data-filter_by='nearby']")).click();
			}
		} else {
			if (tempValue.contains("provider-filter badge selected")) {
				driver.findElement(By.xpath("//div[@class='col-12 mt-2']/span[@data-filter_by='nearby']")).click();
			}
		}
		inputCustodianName.sendKeys("Automation Custodian");
		dropDownSearchCustodian.click();
		inputCustodianName.sendKeys(Keys.ENTER);
		TestUtil.hardWait(3);
		driver.findElement(By.xpath("//button[@class='btn bg-green btn-search-provider mx-0 waves-effect waves-light']")).click();
		TestUtil.hardWait(3);
		wait.until(ExpectedConditions.visibilityOf(selectSearchCustodianName));
		selectSearchCustodianName.click();
		//searchCustodianCareCoordination(CustodianName);
		buttonNextMoveToRecordDetails.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonMedicalRecords));
		buttonMedicalRecords.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonMedicalAllDurationRecords));
		buttonMedicalAllDurationRecords.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonContinue));
		buttonContinue.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonSubmitRequestCareCoordination));
		buttonSubmitRequestCareCoordination.click();
		wait.until(ExpectedConditions.elementToBeClickable(linkOutboundRequest));
		linkOutboundRequest.click();
		wait.until(ExpectedConditions.visibilityOf(requestIdCareCoordination));
		requestId=requestIdCareCoordination.getText();
		System.out.println("Care Coordination Request Id:- "+requestId);
		//TestListener.infoMessage("Care Coordination Request Id:- "+requestId);
		//TestListener.addDynamicScreenshotInReport("createRequestFromCareCordination");
		return requestId;
	}
	
	public void openCareCoordination() {
		wait.until(ExpectedConditions.visibilityOf(tabRequest));
		buttonCareCoordination.click();
		TestUtil.swtichTab(1);
		//TestListener.infoMessage("Opening Care Coordination");
		//TestListener.addDynamicScreenshotInReport("openCareCoordination");
	}
	
	public String openLastRequest() {
		TestUtil.hardWait(3);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//tbody/tr"))));
		int noOfList=driver.findElements(By.xpath("//tbody/tr")).size();
		String tempRequestNo=driver.findElement(By.xpath("//tbody/tr["+noOfList+"]/td[3]")).getText();
		System.out.println("Request No is:- "+tempRequestNo);
		//driver.findElement(By.xpath("//tbody/tr["+noOfList+"]/td[3]")).click();
		return tempRequestNo;	
	}
	
	public void searchCustodianCareCoordination(String providerName) {
		wait.until(ExpectedConditions.elementToBeClickable(linkTryOurAdvanceSearch));
		linkTryOurAdvanceSearch.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputTryOurAdvanceSearchProviderName));
		inputTryOurAdvanceSearchProviderName.sendKeys(providerName);
		wait.until(ExpectedConditions.elementToBeClickable(buttonSearchTryOurAdvanceSearch));
		buttonSearchTryOurAdvanceSearch.click();
		TestUtil.hardWait(3);
		wait.until(ExpectedConditions.elementToBeClickable(selectRequestAfterSearch));
		selectRequestAfterSearch.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonDoneTryOurAdvanceSearch));
		buttonDoneTryOurAdvanceSearch.click();
		//TestListener.addDynamicScreenshotInReport("searchCustodianCareCoordination");
	}
	
	public void processingofCareCoordinateRequest() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(inboundRequest));
			inboundRequest.click();
			wait.until(ExpectedConditions.elementToBeClickable(tabAllFilter));
			tabAllFilter.click();
			wait.until(ExpectedConditions.elementToBeClickable(tabPending));
			tabPending.click();
			TestUtil.hardWait(3);
			wait.until(ExpectedConditions.elementToBeClickable(buttonSortWithRequestId));
			buttonSortWithRequestId.click();
			TestUtil.hardWait(5);
			buttonSortWithRequestId.click();
			TestUtil.hardWait(5);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//table[@id='table-inbound-request']//tbody/tr[@data-status='pending' and @role='row']"))));
			int noOfRequest=driver.findElements(By.xpath("//table[@id='table-inbound-request']//tbody/tr[@data-status='pending' and @role='row']")).size();
			System.out.println("No Of Request "+noOfRequest);
			TestUtil.hardWait(3);
			//driver.findElement(By.xpath("//table[@id='table-inbound-request']//tbody/tr[@data-status='pending' and @role='row']["+noOfRequest+"]")).click();
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//table[@id='table-inbound-request']//tbody/tr[@data-status='pending' and @role='row'][1]")));
			wait.until(ExpectedConditions.elementToBeClickable(buttonSubmitToRequestorCareCoordination));
			buttonSubmitToRequestorCareCoordination.click();
			/*wait.until(ExpectedConditions.elementToBeClickable(buttonApprovePricingStrategyCareCoordination));
			buttonApprovePricingStrategyCareCoordination.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonApproveServicesCareCoordination));
			//buttonApproveServicesCareCoordination.click();
			/*int i = 0;
			while (!buttonSubmitRequestorFinalCareCoordination.getText().contains("Submit To Requestor")) {
				js.executeScript("arguments[0].click()", buttonApproveServicesCareCoordination);	
				System.out.println("Trying to Click " + i);
				i++;
			}*/
			/*TestUtil.hardWait(5);
			js.executeScript("arguments[0].click()", buttonApproveServicesCareCoordination);
			//js.executeScript("arguments[0].click()", buttonApproveServicesCareCoordination);

			wait.until(ExpectedConditions.elementToBeClickable(buttonSubmitRequestorFinalCareCoordination));
			buttonSubmitRequestorFinalCareCoordination.click();*/
			//TestListener.addDynamicScreenshotInReport("processingofCareCoordinateRequest");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createWalkinRequestCareCoordination(boolean EditInRequest, String RequestorName) {
		wait.until(ExpectedConditions.elementToBeClickable(buttonMakeARequestWalkin));
		buttonMakeARequestWalkin.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonStart));
		buttonStart.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputRequestorNameWalkin));
		inputRequestorNameWalkin.sendKeys(RequestorName);
		//TestListener.infoMessage("Requestor Name is :- "+RequestorName);
		String tempURL=driver.getCurrentUrl();
		if (tempURL.contains("preproduction")) {
			driver.findElement(By.xpath("//a[normalize-space()='Show Frequent Requestor(s)']")).click();
		}
		/*inputRequestorNameWalkin.sendKeys(TestUtil.getAlphaDynamicString(5)+" Automation "+TestUtil.getRandomNumericString(2));
		TestUtil.hardWait(3);
		wait.until(ExpectedConditions.elementToBeClickable(inputRequestorTypeWalkinCareCoordination));
		inputRequestorTypeWalkinCareCoordination.click();
		TestUtil.hardWait(3);
		selectRequestorTypeWalkinCareCoordination("Individual");
		inputAddressCareCoordinationWalkin.sendKeys(GlobalVariables.GlobalAddress);
		inputRequestorCityCareCoordinationWalkin.sendKeys(GlobalVariables.GlobalCityName);*/
		wait.until(ExpectedConditions.elementToBeClickable(buttonSelectSearchRequestor));
		buttonSelectSearchRequestor.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonNext));
		buttonNext.click();
		//TestListener.addDynamicScreenshotInReport("screenShotName1");
		wait.until(ExpectedConditions.elementToBeClickable(inputFirstNameWalkin));
		inputFirstNameWalkin.sendKeys(TestUtil.getAlphaDynamicString(5));
		String tempNo=TestUtil.getRandomNumericString(2);
		inputLastNameWalkin.sendKeys(TestUtil.getAlphaDynamicString(5));
		//TestListener.addDynamicScreenshotInReport("screenShotName2");
		buttonNextAtPatientDetailsWalkin.click();
		wait.until(ExpectedConditions.elementToBeClickable(inputDateOfBirthWalkin));
		inputDateOfBirthWalkin.sendKeys("01011991");
		//TestListener.infoMessage("Date of Birth is :- 01011991");
		inputDateOfBirthWalkin.sendKeys(Keys.ENTER);
		buttonNextAtDateOfBirthWalkin.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonNextAtSSNWalkin));
		buttonNextAtSSNWalkin.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonNextAtPhoneNumberWalkin));
		buttonNextAtPhoneNumberWalkin.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonMedicalRecords));
		buttonMedicalRecords.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonMedicalAllDurationRecords));
		buttonMedicalAllDurationRecords.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonNextAtRecordsTypeWalkin));
		buttonNextAtRecordsTypeWalkin.click();
		wait.until(ExpectedConditions.elementToBeClickable(dropdownSelectReasonWalkin));
		dropdownSelectReasonWalkin.click();
		//wait.until(ExpectedConditions.visibilityOf(inputSearchReason));
		//inputSearchReason.sendKeys("Other");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[1]/div[8]/form/div[1]/div[3]/div/div[1]/div/ul/span/div/input")).sendKeys("Other");
		driver.findElement(By.xpath("//div[@class='reason-req-holder col px-0']//div//div//ul//li[22]")).click();
		//driver.findElement(By.xpath("//ul[@id='select-options-7674c427-5ec6-48e7-9742-284a81e1f95d']/li/span[contains(text(),'  Law Firm - Defense')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonNextAtReasonOfRequestWalkin));
		buttonNextAtReasonOfRequestWalkin.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonNextAtAdditionalInformationWalkin));
		buttonNextAtAdditionalInformationWalkin.click();
		wait.until(ExpectedConditions.visibilityOf(headingOfRecordToBeDelivered));
		String gettingHeadingText=headingOfRecordToBeDelivered.getText();
		System.out.println("Heading is:- "+gettingHeadingText);
		//TestListener.addDynamicScreenshotInReport("screenShotName3");
		/*if (gettingHeadingText.contains("How do you want your records to be delivered")) {
			wait.until(ExpectedConditions.elementToBeClickable(buttonInstantDownload));
			buttonInstantDownload.click();
		}
		else {
			wait.until(ExpectedConditions.elementToBeClickable(inputFaxNumberWalkinCareCoordination));
			inputFaxNumberWalkinCareCoordination.sendKeys("1234567890");
			wait.until(ExpectedConditions.elementToBeClickable(inputRecipientNameWalkin));
			inputRecipientNameWalkin.sendKeys("Automation Testing");
			wait.until(ExpectedConditions.elementToBeClickable(inputRecipientTypeWalkin));
			inputRecipientTypeWalkin.click();
			//driver.findElement(By.xpath("//ul[@id='select-options-7674c427-5ec6-48e7-9742-284a81e1f95d']/li/span[contains(text(),'  Law Firm - Defense')]")).click();
			//selectRecipientTypeWalkinCareCoordination("Law Firm - Defense");
			requestTypeFromDropDownWalkin.click();
		}*/
		
		//
		driver.findElement(By.xpath("//div[normalize-space()='Fax Return']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(inputFaxNumberWalkinCareCoordination));
		inputFaxNumberWalkinCareCoordination.sendKeys("1234567890");
		wait.until(ExpectedConditions.elementToBeClickable(inputRecipientNameWalkin));
		inputRecipientNameWalkin.sendKeys("Automation Testing");
		wait.until(ExpectedConditions.elementToBeClickable(inputRecipientTypeWalkin));
		inputRecipientTypeWalkin.click();
		//driver.findElement(By.xpath("//ul[@id='select-options-7674c427-5ec6-48e7-9742-284a81e1f95d']/li/span[contains(text(),'  Law Firm - Defense')]")).click();
		//selectRecipientTypeWalkinCareCoordination("Law Firm - Defense");
		requestTypeFromDropDownWalkin.click();
		//TestListener.addDynamicScreenshotInReport("screenShotName4");


		
		
		wait.until(ExpectedConditions.elementToBeClickable(buttonNextAtFaxDetailsInformationWalkin));
		buttonNextAtFaxDetailsInformationWalkin.click();
		TestUtil.hardWait(3);
		driver.findElement(By.xpath("//*[@id='patient-phone-form']/div[1]/div[2]/div/button[1]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonNextAtAdditionalServiceWalkin));
		buttonNextAtAdditionalServiceWalkin.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonPayByCreditCard));
		buttonPayByCreditCard.click();
		wait.until(ExpectedConditions.elementToBeClickable(buttonNextAtPaymentMethodWalkin));
		buttonNextAtPaymentMethodWalkin.click();
		wait.until(ExpectedConditions.elementToBeClickable(fileUploadTabAuthorization));
		fileUploadTabAuthorization.click();
		TestUtil.hardWait(3);
		wait.until(ExpectedConditions.elementToBeClickable(buttonUploadAuthorizationWalkin));
		//buttonUploadAuthorizationWalkin.click();
		js.executeScript("arguments[0].click();", buttonUploadAuthorizationWalkin);
		WebElement uploadFile=driver.findElement(By.xpath("//input[@class='upload-auth']"));
		TestUtil.hardWait(3);
		js.executeScript("arguments[0].click();", uploadFile);
		TestUtil.hardWait(5);
		driver.findElement(By.xpath("//*[@id='walkin-wizard-holder']/div[12]/div[1]/div[4]/div/div")).click();
		/*
		 * Actions actions=new Actions(driver);
		 * actions.moveToElement(buttonUploadAuthorizationWalkin).click();
		 */		
			TestUtil.hardWait(5);
		try {
			Runtime.getRuntime()
					.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/FileUploadAuth.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		TestUtil.hardWait(5);
		//TestListener.addDynamicScreenshotInReport("screenShotName5");
		wait.until(ExpectedConditions.elementToBeClickable(buttonReviewRequest));
		buttonReviewRequest.click();
		if (EditInRequest) {
			wait.until(ExpectedConditions.elementToBeClickable(buttonEditPatientInformationWalkinRequest));
			buttonEditPatientInformationWalkinRequest.click();
			wait.until(ExpectedConditions.elementToBeClickable(inputWalkinEditPatientLastName));
			String newTempNo=TestUtil.getRandomNumericString(2);
			inputWalkinEditPatientLastName.clear();
			inputWalkinEditPatientLastName.sendKeys("Testing "+newTempNo);
			System.out.println("Patient Name is "+"Automation Testing "+newTempNo);
			wait.until(ExpectedConditions.elementToBeClickable(buttonSaveNewDetails));
			buttonSaveNewDetails.click();
			//TestListener.addDynamicScreenshotInReport("screenShotName6");
		}
		wait.until(ExpectedConditions.elementToBeClickable(buttonSubmitRequestWalkin));
		buttonSubmitRequestWalkin.click();
		//TestListener.addDynamicScreenshotInReport("screenShotName7");
	}
	
	public void selectRecipientTypeWalkinCareCoordination(String ReceipientType) {
		Select selectRecipientType = new Select(driver.findElement(By.xpath("//select[@id='fax-recepient-type']")));
		selectRecipientType.selectByValue(ReceipientType);
	}
	
	public void openLastRequestPage() {
		wait.until(ExpectedConditions.elementToBeClickable(lastPageOfResults));
		lastPageOfResults.click();
		TestUtil.hardWait(3);
	}
	
	public void selectRequestorTypeWalkinCareCoordination(String RequestorType) {
		Select selectRecipientType = new Select(driver.findElement(By.xpath("//select[@id='wi-requestor-type-dd']")));
		selectRecipientType.selectByValue(RequestorType);
	}
	
	public void verifyEnableReferralManagement() {
		wait.until(ExpectedConditions.elementToBeClickable(labelEnableCareCoordination));
		TestUtil.scrollToElement(labelEnableCareCoordination);
		boolean statusOfEnableCareCoordination=labelEnableCareCoordination.isSelected();
		System.out.println("Status of Care-Coordination "+statusOfEnableCareCoordination);
		//TestListener.infoMessage("Status of Care-Coordination "+statusOfEnableCareCoordination);
		boolean statusOfEnableReferralManagement=labelEnableReferralManagement.isSelected();
		System.out.println("Status of Referral Management "+statusOfEnableReferralManagement);
		//TestListener.infoMessage("Status of Referral Management "+statusOfEnableReferralManagement);
		if (statusOfEnableCareCoordination) {
			System.out.println("Care Coordination is Already Selected");
			//TestListener.infoMessage("Care Coordination is Already Selected");
			if (statusOfEnableReferralManagement) {
				System.out.println("Referral Management is Already Selected");
				//TestListener.infoMessage("Referral Management is Already Selected");
			} else {
				labelEnableReferralManagement.click();
				statusOfEnableReferralManagement=labelEnableReferralManagement.isSelected();
				System.out.println("Enabling Referral Management and now its checked now");
				System.out.println("Status of Referral Management "+statusOfEnableReferralManagement);
				//TestListener.infoMessage("Enabling Referral Management and now its checked now");
				//TestListener.infoMessage("Status of Referral Management "+statusOfEnableReferralManagement);
			}
		}
		else {
			System.out.println("Care Coordination is Not Selected");
			//TestListener.infoMessage("Care Coordination is Not Selected");
			//TestListener.infoMessage("Enabling Care Coordination and now its checked now");
			labelEnableCareCoordination.click();
			statusOfEnableCareCoordination=labelEnableCareCoordination.isSelected();
			System.out.println("Status of Care-Coordination "+statusOfEnableCareCoordination);
			//TestListener.infoMessage("Status of Care-Coordination "+statusOfEnableCareCoordination);
			wait.until(ExpectedConditions.elementToBeClickable(labelEnableReferralManagement));
			//TestListener.infoMessage("Referral Management is Not Selected");
			//TestListener.infoMessage("Enabling Referral Management and now its checked now");
			labelEnableReferralManagement.click();
			statusOfEnableReferralManagement=labelEnableReferralManagement.isSelected();
			System.out.println("Status of Referral Management "+statusOfEnableReferralManagement);
			//TestListener.infoMessage("Status of Referral Management "+statusOfEnableReferralManagement);
		}
		buttonUpdateCustodian.click();
		wait.until(ExpectedConditions.visibilityOf(confrimationMessage));
	}
	
	public boolean statusOfReferralsCard() {
		boolean flag=false;
		wait.until(ExpectedConditions.elementToBeClickable(headingReferAPatient));
		String tempReferAPatientCard=buttonTextReferralCareCoordination.getText();
		System.out.println("Text of Card is "+tempReferAPatientCard);
		if (tempReferAPatientCard.contains("Coming Soon")) {
			System.out.println("Referral Management is not enabled");
			//TestListener.infoMessage("Referral Management is not enabled");
			flag=false;
		} 	
		else {
			System.out.println("Referral Management is enabled... You can Start Refer");
			//TestListener.infoMessage("Referral Management is enabled... You can Start Refer");
			flag=true;
		}
		return flag;
	}
	
	public void startReferal(String referFirstName, String referLastName, String referEmailId, String providerName) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(buttonTextReferralCareCoordination));
			buttonTextReferralCareCoordination.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonContinueCareCoordinationAfterRefer));
			buttonContinueCareCoordinationAfterRefer.click();
			//After Click on Continue Button
			wait.until(ExpectedConditions.visibilityOf(inputReferFirstNameCareCoordination));
			//Entering the FirstName and LastName
			inputReferFirstNameCareCoordination.sendKeys(referFirstName);
			inputReferLastNameNameCareCoordination.sendKeys(referLastName);
			System.out.println("First Name of Refer is "+referFirstName+" and Last Name of Refer is "+referLastName);
			//TestListener.infoMessage("First Name of Refer is "+referFirstName+" and Last Name of Refer is "+referLastName);
			//TestListener.addDynamicScreenshotInReport("referName");
			buttonContinueButtonOnPatientDetails.click();
			wait.until(ExpectedConditions.visibilityOf(inputReferPatientDateOfBirth));
			inputReferPatientDateOfBirth.sendKeys("01011991");
			//TestListener.infoMessage("Entering the date of birth");
			//TestListener.addDynamicScreenshotInReport("dateofbirth");
			buttonContinueButtonOnDateOfBirthDetails.click();
			wait.until(ExpectedConditions.visibilityOf(inputReferSSNCareCoordination));
			inputReferSSNCareCoordination.sendKeys("1234567890");
			//TestListener.infoMessage("Entering the SSN");
			//TestListener.addDynamicScreenshotInReport("ssn");
			buttonContinueButtonSSNDetails.click();
			wait.until(ExpectedConditions.visibilityOf(inputReferPhoneNumber));
			inputReferPhoneNumber.sendKeys("1234567890");
			inputReferEmailId.sendKeys(referEmailId);
			//TestListener.infoMessage("Entering the Phone Number and Email Id");
			System.out.println("Email id of the Refer Email:- "+referEmailId);
			//TestListener.infoMessage("Email id of the Refer Email:- "+referEmailId);
			//TestListener.addDynamicScreenshotInReport("contactDetails");		
			buttonContinueButtonContactDetails.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonNearByReferal));
			String getNearByValue=buttonNearByReferal.getAttribute("class");
			if (getNearByValue.contains("provider-filter badge selected")) {
				buttonNearByReferal.click();
			}
			wait.until(ExpectedConditions.visibilityOf(inputProviderNameRefer));
			inputProviderNameRefer.sendKeys(providerName);
			buttonSearchButtonRefer.click();
			wait.until(ExpectedConditions.visibilityOf(selectTheSearchResult));
			TestUtil.hardWait(3);
			selectTheSearchResult.click();
			System.out.println("Selecting the provider Name "+providerName);
			//TestListener.infoMessage("Selecting the provider Name"+providerName);
			//TestListener.addDynamicScreenshotInReport("selectingofprovider");				
			buttonContinueButtonSelectingProvider.click();
			TestUtil.hardWait(3);
			//wait.until(ExpectedConditions.elementToBeClickable(uploadMedicalFile));
			//uploadMedicalFile.click();
			js.executeScript("arguments[0].click();", uploadMedicalFile);
			System.out.println("Uploading Medical File");
			//TestListener.infoMessage("Uploading Medical File");
			//TestListener.addDynamicScreenshotInReport("uploadingMedicalFile");	
			TestUtil.hardWait(5);
			try {
				Runtime.getRuntime()
						.exec(System.getProperty("user.dir") + "/src/test/resources/UploadFileAuth/FileUploadAuth.exe");
			} catch (IOException e) {
				e.printStackTrace();
			}
			TestUtil.hardWait(5);
			buttonContinueButtonUploadingFile.click();
			//TestListener.infoMessage("Uploaded Medical File");
			//TestListener.addDynamicScreenshotInReport("uploadedMedicalFile");	
			TestUtil.hardWait(5);
			wait.until(ExpectedConditions.elementToBeClickable(buttonSkipAppointment));
			buttonSkipAppointment.click();
			wait.until(ExpectedConditions.elementToBeClickable(checkboxMedicalRequestReturnRecords));
			checkboxMedicalRequestReturnRecords.click();
			checkboxImagesRequestReturnRecords.click();
			checkboxBillingRequestReturnRecords.click();
			textareaComments.sendKeys("Testing");
			System.out.println("Request Return Records");
			//TestListener.infoMessage("Request Return Records");
			//TestListener.addDynamicScreenshotInReport("uploadedMedicalFile");	
			buttonVerifyReferralDetails.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonSubmitReferral));
			//TestListener.infoMessage("Final review Of Request");
			//TestListener.addDynamicScreenshotInReport("ReviewOfRequest");	
			buttonSubmitReferral.click();
			wait.until(ExpectedConditions.elementToBeClickable(buttonFinalSubmitReferral));
			//TestListener.infoMessage("Final Submit Review Button");
			//TestListener.addDynamicScreenshotInReport("FinalSubmitButtonReview");	
			buttonFinalSubmitReferral.click();
			wait.until(ExpectedConditions.elementToBeClickable(refernceNumber));
			String tempReferenceNumber=refernceNumber.getText();
			System.out.println("Refernce Number:- "+tempReferenceNumber);
			//TestListener.infoMessage("Refernce Number:- "+tempReferenceNumber);
			//TestListener.addDynamicScreenshotInReport("refernceNumberAfterSubmit");	
			linkOfReferralStatus.click();	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
